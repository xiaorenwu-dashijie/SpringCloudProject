package com.sinoway.cisp.entitys;

import java.util.ArrayList;
import java.util.List;

public class CommonInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommonInfoExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
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

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andDataFromIsNull() {
            addCriterion("data_from is null");
            return (Criteria) this;
        }

        public Criteria andDataFromIsNotNull() {
            addCriterion("data_from is not null");
            return (Criteria) this;
        }

        public Criteria andDataFromEqualTo(String value) {
            addCriterion("data_from =", value, "dataFrom");
            return (Criteria) this;
        }

        public Criteria andDataFromNotEqualTo(String value) {
            addCriterion("data_from <>", value, "dataFrom");
            return (Criteria) this;
        }

        public Criteria andDataFromGreaterThan(String value) {
            addCriterion("data_from >", value, "dataFrom");
            return (Criteria) this;
        }

        public Criteria andDataFromGreaterThanOrEqualTo(String value) {
            addCriterion("data_from >=", value, "dataFrom");
            return (Criteria) this;
        }

        public Criteria andDataFromLessThan(String value) {
            addCriterion("data_from <", value, "dataFrom");
            return (Criteria) this;
        }

        public Criteria andDataFromLessThanOrEqualTo(String value) {
            addCriterion("data_from <=", value, "dataFrom");
            return (Criteria) this;
        }

        public Criteria andDataFromLike(String value) {
            addCriterion("data_from like", value, "dataFrom");
            return (Criteria) this;
        }

        public Criteria andDataFromNotLike(String value) {
            addCriterion("data_from not like", value, "dataFrom");
            return (Criteria) this;
        }

        public Criteria andDataFromIn(List<String> values) {
            addCriterion("data_from in", values, "dataFrom");
            return (Criteria) this;
        }

        public Criteria andDataFromNotIn(List<String> values) {
            addCriterion("data_from not in", values, "dataFrom");
            return (Criteria) this;
        }

        public Criteria andDataFromBetween(String value1, String value2) {
            addCriterion("data_from between", value1, value2, "dataFrom");
            return (Criteria) this;
        }

        public Criteria andDataFromNotBetween(String value1, String value2) {
            addCriterion("data_from not between", value1, value2, "dataFrom");
            return (Criteria) this;
        }

        public Criteria andCommonIsNull() {
            addCriterion("common is null");
            return (Criteria) this;
        }

        public Criteria andCommonIsNotNull() {
            addCriterion("common is not null");
            return (Criteria) this;
        }

        public Criteria andCommonEqualTo(String value) {
            addCriterion("common =", value, "common");
            return (Criteria) this;
        }

        public Criteria andCommonNotEqualTo(String value) {
            addCriterion("common <>", value, "common");
            return (Criteria) this;
        }

        public Criteria andCommonGreaterThan(String value) {
            addCriterion("common >", value, "common");
            return (Criteria) this;
        }

        public Criteria andCommonGreaterThanOrEqualTo(String value) {
            addCriterion("common >=", value, "common");
            return (Criteria) this;
        }

        public Criteria andCommonLessThan(String value) {
            addCriterion("common <", value, "common");
            return (Criteria) this;
        }

        public Criteria andCommonLessThanOrEqualTo(String value) {
            addCriterion("common <=", value, "common");
            return (Criteria) this;
        }

        public Criteria andCommonLike(String value) {
            addCriterion("common like", value, "common");
            return (Criteria) this;
        }

        public Criteria andCommonNotLike(String value) {
            addCriterion("common not like", value, "common");
            return (Criteria) this;
        }

        public Criteria andCommonIn(List<String> values) {
            addCriterion("common in", values, "common");
            return (Criteria) this;
        }

        public Criteria andCommonNotIn(List<String> values) {
            addCriterion("common not in", values, "common");
            return (Criteria) this;
        }

        public Criteria andCommonBetween(String value1, String value2) {
            addCriterion("common between", value1, value2, "common");
            return (Criteria) this;
        }

        public Criteria andCommonNotBetween(String value1, String value2) {
            addCriterion("common not between", value1, value2, "common");
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