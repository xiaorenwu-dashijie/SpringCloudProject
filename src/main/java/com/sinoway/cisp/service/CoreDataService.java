package com.sinoway.cisp.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sinoway.cisp.dao.ContractAcceptDetailMapper;
import com.sinoway.cisp.dao.IdMapperMapper;
import com.sinoway.cisp.dao.InstiDetailMapper;
import com.sinoway.cisp.dao.LoanApplicationMapper;
import com.sinoway.cisp.dao.SinoBodyMapper;
import com.sinoway.cisp.entitys.ContractAcceptDetail;
import com.sinoway.cisp.entitys.CreditBody;
import com.sinoway.cisp.entitys.IdMapper;
import com.sinoway.cisp.entitys.LoanApplication;
import com.sinoway.cisp.entitys.SinoBody;
import com.sinoway.cisp.utils.CreateExcelUtil;
import com.sinoway.cisp.utils.HttpPostUtil;
import com.sinoway.cisp.utils.MddValidator;

@Component
public class CoreDataService{

	@Autowired
	private IdMapperMapper idMapperMapper;
	@Autowired
	private InstiDetailMapper instiDetailMapper;
	@Autowired
	private LoanApplicationMapper loanApplicationMapper;
	@Autowired
	private ContractAcceptDetailMapper contractAcceptDetailMapper;
	@Autowired
	private SinoBodyMapper sinoBodyMapper;
	
	@Value("${save_coredata_url}")
	private String save_coredata_url;

//	@Async
//	@Scheduled(cron = "${save_coredata_cron}")
	public void getCoreData() {

		List<CreditBody> list = new ArrayList<>();
		List<ContractAcceptDetail> contractAcceptDetails = contractAcceptDetailMapper.findLastWeek();
		if (CollectionUtils.isEmpty(contractAcceptDetails)) {
			System.out.println("没有信息主体录入");
		} else {
			for (ContractAcceptDetail contractAcceptDetail : contractAcceptDetails) {
				String cellPhoneNum = null;
				CreditBody creditBody = new CreditBody();
				creditBody.setSinoid("sinoway-"+UUID.randomUUID().toString().replaceAll("-", "").substring(0, 20));
				
				IdMapper idMapper = idMapperMapper.selectByPrimaryKey(contractAcceptDetail.getSinoid());
				String instiName = instiDetailMapper.selectInstiNameByInstiCode(idMapper.getInstiCode());
				SinoBody sinoBody = sinoBodyMapper.selectByPrimaryKey(idMapper.getSinoCardid());
				creditBody.setName(sinoBody.getName());
				creditBody.setCardid(sinoBody.getCardid());
				creditBody.setInstiName(instiName);
				
				LoanApplication loanApplication = loanApplicationMapper.selectByPrimaryKey(contractAcceptDetail.getSinoid());
				if (loanApplication!=null) {
					cellPhoneNum = loanApplication.getCellPhoneNum();
					if (!MddValidator.findMdd(contractAcceptDetail.getContractStatus(), "2","5","6")) {
						creditBody.setMonitorTag("1");//有贷中检测服务
					}else {
						creditBody.setMonitorTag("0");//无贷中检测服务
					}
				}else {
					cellPhoneNum = idMapper.getCellPhoneNum();
					creditBody.setMonitorTag("0");//无贷中检测服务
				}
				creditBody.setCellPhoneNum(cellPhoneNum);
				creditBody.setSinotime(idMapper.getSinotime());
				list.add(creditBody);
			}
			String path = "/var/creditbody/";
			File file = new File(path);
			if (!file.exists()) {
				file.mkdirs();
			}
			String fileName = "信息主体" + "--" + String.valueOf(System.currentTimeMillis());
			String fileType = "xlsx";
			String[] titleRow = { "sinoid", "name", "cardid", "cellPhoneNum", "instiName", "monitorTag",
					"sinotime" };
			try {
				CreateExcelUtil.writerBas(path, fileName, fileType, list, titleRow);
				HttpPostUtil u = new HttpPostUtil(save_coredata_url);
				u.addFileParameter("creditbodyExcel", new File(path + fileName + "." + fileType));
				u.addTextParameter("text", "中文");
				byte[] b = u.send();
				String result = new String(b);
				System.out.println(result);
				//删除Excel
				File file2 = new File(path + fileName + "." + fileType);
				file2.delete();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

	}

}
