package com.sinoway.cisp.entitys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SearchDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SearchDetailExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andReportIdIsNull() {
            addCriterion("report_id is null");
            return (Criteria) this;
        }

        public Criteria andReportIdIsNotNull() {
            addCriterion("report_id is not null");
            return (Criteria) this;
        }

        public Criteria andReportIdEqualTo(String value) {
            addCriterion("report_id =", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdNotEqualTo(String value) {
            addCriterion("report_id <>", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdGreaterThan(String value) {
            addCriterion("report_id >", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdGreaterThanOrEqualTo(String value) {
            addCriterion("report_id >=", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdLessThan(String value) {
            addCriterion("report_id <", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdLessThanOrEqualTo(String value) {
            addCriterion("report_id <=", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdLike(String value) {
            addCriterion("report_id like", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdNotLike(String value) {
            addCriterion("report_id not like", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdIn(List<String> values) {
            addCriterion("report_id in", values, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdNotIn(List<String> values) {
            addCriterion("report_id not in", values, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdBetween(String value1, String value2) {
            addCriterion("report_id between", value1, value2, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdNotBetween(String value1, String value2) {
            addCriterion("report_id not between", value1, value2, "reportId");
            return (Criteria) this;
        }

        public Criteria andSinoidIsNull() {
            addCriterion("sinoid is null");
            return (Criteria) this;
        }

        public Criteria andSinoidIsNotNull() {
            addCriterion("sinoid is not null");
            return (Criteria) this;
        }

        public Criteria andSinoidEqualTo(String value) {
            addCriterion("sinoid =", value, "sinoid");
            return (Criteria) this;
        }

        public Criteria andSinoidNotEqualTo(String value) {
            addCriterion("sinoid <>", value, "sinoid");
            return (Criteria) this;
        }

        public Criteria andSinoidGreaterThan(String value) {
            addCriterion("sinoid >", value, "sinoid");
            return (Criteria) this;
        }

        public Criteria andSinoidGreaterThanOrEqualTo(String value) {
            addCriterion("sinoid >=", value, "sinoid");
            return (Criteria) this;
        }

        public Criteria andSinoidLessThan(String value) {
            addCriterion("sinoid <", value, "sinoid");
            return (Criteria) this;
        }

        public Criteria andSinoidLessThanOrEqualTo(String value) {
            addCriterion("sinoid <=", value, "sinoid");
            return (Criteria) this;
        }

        public Criteria andSinoidLike(String value) {
            addCriterion("sinoid like", value, "sinoid");
            return (Criteria) this;
        }

        public Criteria andSinoidNotLike(String value) {
            addCriterion("sinoid not like", value, "sinoid");
            return (Criteria) this;
        }

        public Criteria andSinoidIn(List<String> values) {
            addCriterion("sinoid in", values, "sinoid");
            return (Criteria) this;
        }

        public Criteria andSinoidNotIn(List<String> values) {
            addCriterion("sinoid not in", values, "sinoid");
            return (Criteria) this;
        }

        public Criteria andSinoidBetween(String value1, String value2) {
            addCriterion("sinoid between", value1, value2, "sinoid");
            return (Criteria) this;
        }

        public Criteria andSinoidNotBetween(String value1, String value2) {
            addCriterion("sinoid not between", value1, value2, "sinoid");
            return (Criteria) this;
        }

        public Criteria andUserAccountIsNull() {
            addCriterion("user_account is null");
            return (Criteria) this;
        }

        public Criteria andUserAccountIsNotNull() {
            addCriterion("user_account is not null");
            return (Criteria) this;
        }

        public Criteria andUserAccountEqualTo(String value) {
            addCriterion("user_account =", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountNotEqualTo(String value) {
            addCriterion("user_account <>", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountGreaterThan(String value) {
            addCriterion("user_account >", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountGreaterThanOrEqualTo(String value) {
            addCriterion("user_account >=", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountLessThan(String value) {
            addCriterion("user_account <", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountLessThanOrEqualTo(String value) {
            addCriterion("user_account <=", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountLike(String value) {
            addCriterion("user_account like", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountNotLike(String value) {
            addCriterion("user_account not like", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountIn(List<String> values) {
            addCriterion("user_account in", values, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountNotIn(List<String> values) {
            addCriterion("user_account not in", values, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountBetween(String value1, String value2) {
            addCriterion("user_account between", value1, value2, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountNotBetween(String value1, String value2) {
            addCriterion("user_account not between", value1, value2, "userAccount");
            return (Criteria) this;
        }

        public Criteria andReqReasonIsNull() {
            addCriterion("req_reason is null");
            return (Criteria) this;
        }

        public Criteria andReqReasonIsNotNull() {
            addCriterion("req_reason is not null");
            return (Criteria) this;
        }

        public Criteria andReqReasonEqualTo(String value) {
            addCriterion("req_reason =", value, "reqReason");
            return (Criteria) this;
        }

        public Criteria andReqReasonNotEqualTo(String value) {
            addCriterion("req_reason <>", value, "reqReason");
            return (Criteria) this;
        }

        public Criteria andReqReasonGreaterThan(String value) {
            addCriterion("req_reason >", value, "reqReason");
            return (Criteria) this;
        }

        public Criteria andReqReasonGreaterThanOrEqualTo(String value) {
            addCriterion("req_reason >=", value, "reqReason");
            return (Criteria) this;
        }

        public Criteria andReqReasonLessThan(String value) {
            addCriterion("req_reason <", value, "reqReason");
            return (Criteria) this;
        }

        public Criteria andReqReasonLessThanOrEqualTo(String value) {
            addCriterion("req_reason <=", value, "reqReason");
            return (Criteria) this;
        }

        public Criteria andReqReasonLike(String value) {
            addCriterion("req_reason like", value, "reqReason");
            return (Criteria) this;
        }

        public Criteria andReqReasonNotLike(String value) {
            addCriterion("req_reason not like", value, "reqReason");
            return (Criteria) this;
        }

        public Criteria andReqReasonIn(List<String> values) {
            addCriterion("req_reason in", values, "reqReason");
            return (Criteria) this;
        }

        public Criteria andReqReasonNotIn(List<String> values) {
            addCriterion("req_reason not in", values, "reqReason");
            return (Criteria) this;
        }

        public Criteria andReqReasonBetween(String value1, String value2) {
            addCriterion("req_reason between", value1, value2, "reqReason");
            return (Criteria) this;
        }

        public Criteria andReqReasonNotBetween(String value1, String value2) {
            addCriterion("req_reason not between", value1, value2, "reqReason");
            return (Criteria) this;
        }

        public Criteria andResultAddIsNull() {
            addCriterion("result_add is null");
            return (Criteria) this;
        }

        public Criteria andResultAddIsNotNull() {
            addCriterion("result_add is not null");
            return (Criteria) this;
        }

        public Criteria andResultAddEqualTo(String value) {
            addCriterion("result_add =", value, "resultAdd");
            return (Criteria) this;
        }

        public Criteria andResultAddNotEqualTo(String value) {
            addCriterion("result_add <>", value, "resultAdd");
            return (Criteria) this;
        }

        public Criteria andResultAddGreaterThan(String value) {
            addCriterion("result_add >", value, "resultAdd");
            return (Criteria) this;
        }

        public Criteria andResultAddGreaterThanOrEqualTo(String value) {
            addCriterion("result_add >=", value, "resultAdd");
            return (Criteria) this;
        }

        public Criteria andResultAddLessThan(String value) {
            addCriterion("result_add <", value, "resultAdd");
            return (Criteria) this;
        }

        public Criteria andResultAddLessThanOrEqualTo(String value) {
            addCriterion("result_add <=", value, "resultAdd");
            return (Criteria) this;
        }

        public Criteria andResultAddLike(String value) {
            addCriterion("result_add like", value, "resultAdd");
            return (Criteria) this;
        }

        public Criteria andResultAddNotLike(String value) {
            addCriterion("result_add not like", value, "resultAdd");
            return (Criteria) this;
        }

        public Criteria andResultAddIn(List<String> values) {
            addCriterion("result_add in", values, "resultAdd");
            return (Criteria) this;
        }

        public Criteria andResultAddNotIn(List<String> values) {
            addCriterion("result_add not in", values, "resultAdd");
            return (Criteria) this;
        }

        public Criteria andResultAddBetween(String value1, String value2) {
            addCriterion("result_add between", value1, value2, "resultAdd");
            return (Criteria) this;
        }

        public Criteria andResultAddNotBetween(String value1, String value2) {
            addCriterion("result_add not between", value1, value2, "resultAdd");
            return (Criteria) this;
        }

        public Criteria andReqTimeIsNull() {
            addCriterion("req_time is null");
            return (Criteria) this;
        }

        public Criteria andReqTimeIsNotNull() {
            addCriterion("req_time is not null");
            return (Criteria) this;
        }

        public Criteria andReqTimeEqualTo(Date value) {
            addCriterion("req_time =", value, "reqTime");
            return (Criteria) this;
        }

        public Criteria andReqTimeNotEqualTo(Date value) {
            addCriterion("req_time <>", value, "reqTime");
            return (Criteria) this;
        }

        public Criteria andReqTimeGreaterThan(Date value) {
            addCriterion("req_time >", value, "reqTime");
            return (Criteria) this;
        }

        public Criteria andReqTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("req_time >=", value, "reqTime");
            return (Criteria) this;
        }

        public Criteria andReqTimeLessThan(Date value) {
            addCriterion("req_time <", value, "reqTime");
            return (Criteria) this;
        }

        public Criteria andReqTimeLessThanOrEqualTo(Date value) {
            addCriterion("req_time <=", value, "reqTime");
            return (Criteria) this;
        }

        public Criteria andReqTimeIn(List<Date> values) {
            addCriterion("req_time in", values, "reqTime");
            return (Criteria) this;
        }

        public Criteria andReqTimeNotIn(List<Date> values) {
            addCriterion("req_time not in", values, "reqTime");
            return (Criteria) this;
        }

        public Criteria andReqTimeBetween(Date value1, Date value2) {
            addCriterion("req_time between", value1, value2, "reqTime");
            return (Criteria) this;
        }

        public Criteria andReqTimeNotBetween(Date value1, Date value2) {
            addCriterion("req_time not between", value1, value2, "reqTime");
            return (Criteria) this;
        }

        public Criteria andSinoCardidIsNull() {
            addCriterion("sino_cardid is null");
            return (Criteria) this;
        }

        public Criteria andSinoCardidIsNotNull() {
            addCriterion("sino_cardid is not null");
            return (Criteria) this;
        }

        public Criteria andSinoCardidEqualTo(String value) {
            addCriterion("sino_cardid =", value, "sinoCardid");
            return (Criteria) this;
        }

        public Criteria andSinoCardidNotEqualTo(String value) {
            addCriterion("sino_cardid <>", value, "sinoCardid");
            return (Criteria) this;
        }

        public Criteria andSinoCardidGreaterThan(String value) {
            addCriterion("sino_cardid >", value, "sinoCardid");
            return (Criteria) this;
        }

        public Criteria andSinoCardidGreaterThanOrEqualTo(String value) {
            addCriterion("sino_cardid >=", value, "sinoCardid");
            return (Criteria) this;
        }

        public Criteria andSinoCardidLessThan(String value) {
            addCriterion("sino_cardid <", value, "sinoCardid");
            return (Criteria) this;
        }

        public Criteria andSinoCardidLessThanOrEqualTo(String value) {
            addCriterion("sino_cardid <=", value, "sinoCardid");
            return (Criteria) this;
        }

        public Criteria andSinoCardidLike(String value) {
            addCriterion("sino_cardid like", value, "sinoCardid");
            return (Criteria) this;
        }

        public Criteria andSinoCardidNotLike(String value) {
            addCriterion("sino_cardid not like", value, "sinoCardid");
            return (Criteria) this;
        }

        public Criteria andSinoCardidIn(List<String> values) {
            addCriterion("sino_cardid in", values, "sinoCardid");
            return (Criteria) this;
        }

        public Criteria andSinoCardidNotIn(List<String> values) {
            addCriterion("sino_cardid not in", values, "sinoCardid");
            return (Criteria) this;
        }

        public Criteria andSinoCardidBetween(String value1, String value2) {
            addCriterion("sino_cardid between", value1, value2, "sinoCardid");
            return (Criteria) this;
        }

        public Criteria andSinoCardidNotBetween(String value1, String value2) {
            addCriterion("sino_cardid not between", value1, value2, "sinoCardid");
            return (Criteria) this;
        }

        public Criteria andSinotimeIsNull() {
            addCriterion("sinotime is null");
            return (Criteria) this;
        }

        public Criteria andSinotimeIsNotNull() {
            addCriterion("sinotime is not null");
            return (Criteria) this;
        }

        public Criteria andSinotimeEqualTo(Date value) {
            addCriterion("sinotime =", value, "sinotime");
            return (Criteria) this;
        }

        public Criteria andSinotimeNotEqualTo(Date value) {
            addCriterion("sinotime <>", value, "sinotime");
            return (Criteria) this;
        }

        public Criteria andSinotimeGreaterThan(Date value) {
            addCriterion("sinotime >", value, "sinotime");
            return (Criteria) this;
        }

        public Criteria andSinotimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sinotime >=", value, "sinotime");
            return (Criteria) this;
        }

        public Criteria andSinotimeLessThan(Date value) {
            addCriterion("sinotime <", value, "sinotime");
            return (Criteria) this;
        }

        public Criteria andSinotimeLessThanOrEqualTo(Date value) {
            addCriterion("sinotime <=", value, "sinotime");
            return (Criteria) this;
        }

        public Criteria andSinotimeIn(List<Date> values) {
            addCriterion("sinotime in", values, "sinotime");
            return (Criteria) this;
        }

        public Criteria andSinotimeNotIn(List<Date> values) {
            addCriterion("sinotime not in", values, "sinotime");
            return (Criteria) this;
        }

        public Criteria andSinotimeBetween(Date value1, Date value2) {
            addCriterion("sinotime between", value1, value2, "sinotime");
            return (Criteria) this;
        }

        public Criteria andSinotimeNotBetween(Date value1, Date value2) {
            addCriterion("sinotime not between", value1, value2, "sinotime");
            return (Criteria) this;
        }

        public Criteria andServiceCodeIsNull() {
            addCriterion("service_code is null");
            return (Criteria) this;
        }

        public Criteria andServiceCodeIsNotNull() {
            addCriterion("service_code is not null");
            return (Criteria) this;
        }

        public Criteria andServiceCodeEqualTo(String value) {
            addCriterion("service_code =", value, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andServiceCodeNotEqualTo(String value) {
            addCriterion("service_code <>", value, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andServiceCodeGreaterThan(String value) {
            addCriterion("service_code >", value, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andServiceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("service_code >=", value, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andServiceCodeLessThan(String value) {
            addCriterion("service_code <", value, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andServiceCodeLessThanOrEqualTo(String value) {
            addCriterion("service_code <=", value, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andServiceCodeLike(String value) {
            addCriterion("service_code like", value, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andServiceCodeNotLike(String value) {
            addCriterion("service_code not like", value, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andServiceCodeIn(List<String> values) {
            addCriterion("service_code in", values, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andServiceCodeNotIn(List<String> values) {
            addCriterion("service_code not in", values, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andServiceCodeBetween(String value1, String value2) {
            addCriterion("service_code between", value1, value2, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andServiceCodeNotBetween(String value1, String value2) {
            addCriterion("service_code not between", value1, value2, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andIscheckedIsNull() {
            addCriterion("ischecked is null");
            return (Criteria) this;
        }

        public Criteria andIscheckedIsNotNull() {
            addCriterion("ischecked is not null");
            return (Criteria) this;
        }

        public Criteria andIscheckedEqualTo(String value) {
            addCriterion("ischecked =", value, "ischecked");
            return (Criteria) this;
        }

        public Criteria andIscheckedNotEqualTo(String value) {
            addCriterion("ischecked <>", value, "ischecked");
            return (Criteria) this;
        }

        public Criteria andIscheckedGreaterThan(String value) {
            addCriterion("ischecked >", value, "ischecked");
            return (Criteria) this;
        }

        public Criteria andIscheckedGreaterThanOrEqualTo(String value) {
            addCriterion("ischecked >=", value, "ischecked");
            return (Criteria) this;
        }

        public Criteria andIscheckedLessThan(String value) {
            addCriterion("ischecked <", value, "ischecked");
            return (Criteria) this;
        }

        public Criteria andIscheckedLessThanOrEqualTo(String value) {
            addCriterion("ischecked <=", value, "ischecked");
            return (Criteria) this;
        }

        public Criteria andIscheckedLike(String value) {
            addCriterion("ischecked like", value, "ischecked");
            return (Criteria) this;
        }

        public Criteria andIscheckedNotLike(String value) {
            addCriterion("ischecked not like", value, "ischecked");
            return (Criteria) this;
        }

        public Criteria andIscheckedIn(List<String> values) {
            addCriterion("ischecked in", values, "ischecked");
            return (Criteria) this;
        }

        public Criteria andIscheckedNotIn(List<String> values) {
            addCriterion("ischecked not in", values, "ischecked");
            return (Criteria) this;
        }

        public Criteria andIscheckedBetween(String value1, String value2) {
            addCriterion("ischecked between", value1, value2, "ischecked");
            return (Criteria) this;
        }

        public Criteria andIscheckedNotBetween(String value1, String value2) {
            addCriterion("ischecked not between", value1, value2, "ischecked");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}