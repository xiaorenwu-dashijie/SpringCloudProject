package com.sinoway.cisp.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.sinoway.cisp.entitys.CreditBody;

public class CreateExcelUtil {

	/**
	 * 生成Excel表格
	 * 
	 * @param path
	 *            保存Excel表格的路径
	 * @param fileName
	 *            Excel表格的名称
	 * @param fileType
	 *            Excel表格的类型:xls、xlsx
	 * @param list
	 *            集合,里面的对象是根据需要而变化的
	 * @param titleRow
	 *            Excel表格的标题，是一个字符串数组 eg: String[] titltRow =
	 *            {"姓名","身份证号","家庭住址"};
	 * @return
	 * @throws IOException
	 */
	public static String writerBas(String path, String fileName, String fileType, List<CreditBody> list, String titleRow[])
			throws IOException {
		Workbook wb = null;
		String excelPath = path + fileName + "." + fileType;
		File file = new File(excelPath);
		Sheet sheet = null;
		// 创建工作文档对象
		if (!file.exists()) {
			if (fileType.equals("xls")) {
				wb = new HSSFWorkbook();
			} else if (fileType.equals("xlsx")) {
				wb = new XSSFWorkbook();
			} else {
				System.out.println("Error");
			}
		} else {
			if (fileType.equals("xls")) {
				wb = new HSSFWorkbook();

			} else if (fileType.equals("xlsx")) {
				wb = new XSSFWorkbook();

			} else {
				// throw new SimpleException("文件格式不正确");
				System.out.println("Error");
			}
		}

		System.out.println(file.exists());
		// 创建sheet对象
		if (sheet == null) {
			sheet = (Sheet) wb.createSheet("sheet1");
		}

		// 添加表头
		Row row = sheet.createRow(0); // 创建第一行
		Cell cell = row.createCell(0);
		for (int i = 0; i < titleRow.length; i++) {
			cell = row.createCell(i);
			cell.setCellValue(titleRow[i]);
			sheet.setColumnWidth(i, 20 * 256);
		}
		row.setHeight((short) 800);

		// 循环写入行数据
		for (int i = 0; i < list.size(); i++) {
			row = (Row) sheet.createRow(i + 1);
			row.setHeight((short) 500);
			row.createCell(0).setCellValue((list.get(i)).getSinoid());
			row.createCell(1).setCellValue((list.get(i)).getName());
			row.createCell(2).setCellValue((list.get(i)).getCardid());
			row.createCell(3).setCellValue((list.get(i)).getCellPhoneNum());
			row.createCell(4).setCellValue((list.get(i)).getInstiName());
			row.createCell(5).setCellValue((list.get(i)).getMonitorTag());
			row.createCell(6).setCellValue(DateUtils.dateToStr((list.get(i)).getSinotime()));
		}
		// 创建文件流
		OutputStream stream = new FileOutputStream(excelPath);
		// 写入数据
		wb.write(stream);
		// 关闭文件流
		stream.close();
		return excelPath;
	}

}
