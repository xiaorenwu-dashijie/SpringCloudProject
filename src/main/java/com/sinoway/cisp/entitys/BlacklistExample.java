package com.sinoway.cisp.entitys;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlacklistExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BlacklistExample() {
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

        public Criteria andSinoidIsNull() {
            addCriterion("sinoId is null");
            return (Criteria) this;
        }

        public Criteria andSinoidIsNotNull() {
            addCriterion("sinoId is not null");
            return (Criteria) this;
        }

        public Criteria andSinoidEqualTo(String value) {
            addCriterion("sinoId =", value, "sinoid");
            return (Criteria) this;
        }

        public Criteria andSinoidNotEqualTo(String value) {
            addCriterion("sinoId <>", value, "sinoid");
            return (Criteria) this;
        }

        public Criteria andSinoidGreaterThan(String value) {
            addCriterion("sinoId >", value, "sinoid");
            return (Criteria) this;
        }

        public Criteria andSinoidGreaterThanOrEqualTo(String value) {
            addCriterion("sinoId >=", value, "sinoid");
            return (Criteria) this;
        }

        public Criteria andSinoidLessThan(String value) {
            addCriterion("sinoId <", value, "sinoid");
            return (Criteria) this;
        }

        public Criteria andSinoidLessThanOrEqualTo(String value) {
            addCriterion("sinoId <=", value, "sinoid");
            return (Criteria) this;
        }

        public Criteria andSinoidLike(String value) {
            addCriterion("sinoId like", value, "sinoid");
            return (Criteria) this;
        }

        public Criteria andSinoidNotLike(String value) {
            addCriterion("sinoId not like", value, "sinoid");
            return (Criteria) this;
        }

        public Criteria andSinoidIn(List<String> values) {
            addCriterion("sinoId in", values, "sinoid");
            return (Criteria) this;
        }

        public Criteria andSinoidNotIn(List<String> values) {
            addCriterion("sinoId not in", values, "sinoid");
            return (Criteria) this;
        }

        public Criteria andSinoidBetween(String value1, String value2) {
            addCriterion("sinoId between", value1, value2, "sinoid");
            return (Criteria) this;
        }

        public Criteria andSinoidNotBetween(String value1, String value2) {
            addCriterion("sinoId not between", value1, value2, "sinoid");
            return (Criteria) this;
        }

        public Criteria andOverdueStartTimeIsNull() {
            addCriterion("overdue_start_time is null");
            return (Criteria) this;
        }

        public Criteria andOverdueStartTimeIsNotNull() {
            addCriterion("overdue_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andOverdueStartTimeEqualTo(Date value) {
            addCriterion("overdue_start_time =", value, "overdueStartTime");
            return (Criteria) this;
        }

        public Criteria andOverdueStartTimeNotEqualTo(Date value) {
            addCriterion("overdue_start_time <>", value, "overdueStartTime");
            return (Criteria) this;
        }

        public Criteria andOverdueStartTimeGreaterThan(Date value) {
            addCriterion("overdue_start_time >", value, "overdueStartTime");
            return (Criteria) this;
        }

        public Criteria andOverdueStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("overdue_start_time >=", value, "overdueStartTime");
            return (Criteria) this;
        }

        public Criteria andOverdueStartTimeLessThan(Date value) {
            addCriterion("overdue_start_time <", value, "overdueStartTime");
            return (Criteria) this;
        }

        public Criteria andOverdueStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("overdue_start_time <=", value, "overdueStartTime");
            return (Criteria) this;
        }

        public Criteria andOverdueStartTimeIn(List<Date> values) {
            addCriterion("overdue_start_time in", values, "overdueStartTime");
            return (Criteria) this;
        }

        public Criteria andOverdueStartTimeNotIn(List<Date> values) {
            addCriterion("overdue_start_time not in", values, "overdueStartTime");
            return (Criteria) this;
        }

        public Criteria andOverdueStartTimeBetween(Date value1, Date value2) {
            addCriterion("overdue_start_time between", value1, value2, "overdueStartTime");
            return (Criteria) this;
        }

        public Criteria andOverdueStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("overdue_start_time not between", value1, value2, "overdueStartTime");
            return (Criteria) this;
        }

        public Criteria andReasonIsNull() {
            addCriterion("reason is null");
            return (Criteria) this;
        }

        public Criteria andReasonIsNotNull() {
            addCriterion("reason is not null");
            return (Criteria) this;
        }

        public Criteria andReasonEqualTo(String value) {
            addCriterion("reason =", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotEqualTo(String value) {
            addCriterion("reason <>", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThan(String value) {
            addCriterion("reason >", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            addCriterion("reason >=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThan(String value) {
            addCriterion("reason <", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThanOrEqualTo(String value) {
            addCriterion("reason <=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLike(String value) {
            addCriterion("reason like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotLike(String value) {
            addCriterion("reason not like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonIn(List<String> values) {
            addCriterion("reason in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotIn(List<String> values) {
            addCriterion("reason not in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonBetween(String value1, String value2) {
            addCriterion("reason between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            addCriterion("reason not between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andPublicTimeIsNull() {
            addCriterion("public_time is null");
            return (Criteria) this;
        }

        public Criteria andPublicTimeIsNotNull() {
            addCriterion("public_time is not null");
            return (Criteria) this;
        }

        public Criteria andPublicTimeEqualTo(Date value) {
            addCriterion("public_time =", value, "publicTime");
            return (Criteria) this;
        }

        public Criteria andPublicTimeNotEqualTo(Date value) {
            addCriterion("public_time <>", value, "publicTime");
            return (Criteria) this;
        }

        public Criteria andPublicTimeGreaterThan(Date value) {
            addCriterion("public_time >", value, "publicTime");
            return (Criteria) this;
        }

        public Criteria andPublicTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("public_time >=", value, "publicTime");
            return (Criteria) this;
        }

        public Criteria andPublicTimeLessThan(Date value) {
            addCriterion("public_time <", value, "publicTime");
            return (Criteria) this;
        }

        public Criteria andPublicTimeLessThanOrEqualTo(Date value) {
            addCriterion("public_time <=", value, "publicTime");
            return (Criteria) this;
        }

        public Criteria andPublicTimeIn(List<Date> values) {
            addCriterion("public_time in", values, "publicTime");
            return (Criteria) this;
        }

        public Criteria andPublicTimeNotIn(List<Date> values) {
            addCriterion("public_time not in", values, "publicTime");
            return (Criteria) this;
        }

        public Criteria andPublicTimeBetween(Date value1, Date value2) {
            addCriterion("public_time between", value1, value2, "publicTime");
            return (Criteria) this;
        }

        public Criteria andPublicTimeNotBetween(Date value1, Date value2) {
            addCriterion("public_time not between", value1, value2, "publicTime");
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

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andLiveAddressIsNull() {
            addCriterion("live_address is null");
            return (Criteria) this;
        }

        public Criteria andLiveAddressIsNotNull() {
            addCriterion("live_address is not null");
            return (Criteria) this;
        }

        public Criteria andLiveAddressEqualTo(String value) {
            addCriterion("live_address =", value, "liveAddress");
            return (Criteria) this;
        }

        public Criteria andLiveAddressNotEqualTo(String value) {
            addCriterion("live_address <>", value, "liveAddress");
            return (Criteria) this;
        }

        public Criteria andLiveAddressGreaterThan(String value) {
            addCriterion("live_address >", value, "liveAddress");
            return (Criteria) this;
        }

        public Criteria andLiveAddressGreaterThanOrEqualTo(String value) {
            addCriterion("live_address >=", value, "liveAddress");
            return (Criteria) this;
        }

        public Criteria andLiveAddressLessThan(String value) {
            addCriterion("live_address <", value, "liveAddress");
            return (Criteria) this;
        }

        public Criteria andLiveAddressLessThanOrEqualTo(String value) {
            addCriterion("live_address <=", value, "liveAddress");
            return (Criteria) this;
        }

        public Criteria andLiveAddressLike(String value) {
            addCriterion("live_address like", value, "liveAddress");
            return (Criteria) this;
        }

        public Criteria andLiveAddressNotLike(String value) {
            addCriterion("live_address not like", value, "liveAddress");
            return (Criteria) this;
        }

        public Criteria andLiveAddressIn(List<String> values) {
            addCriterion("live_address in", values, "liveAddress");
            return (Criteria) this;
        }

        public Criteria andLiveAddressNotIn(List<String> values) {
            addCriterion("live_address not in", values, "liveAddress");
            return (Criteria) this;
        }

        public Criteria andLiveAddressBetween(String value1, String value2) {
            addCriterion("live_address between", value1, value2, "liveAddress");
            return (Criteria) this;
        }

        public Criteria andLiveAddressNotBetween(String value1, String value2) {
            addCriterion("live_address not between", value1, value2, "liveAddress");
            return (Criteria) this;
        }

        public Criteria andOverdueMoneyIsNull() {
            addCriterion("overdue_money is null");
            return (Criteria) this;
        }

        public Criteria andOverdueMoneyIsNotNull() {
            addCriterion("overdue_money is not null");
            return (Criteria) this;
        }

        public Criteria andOverdueMoneyEqualTo(BigDecimal value) {
            addCriterion("overdue_money =", value, "overdueMoney");
            return (Criteria) this;
        }

        public Criteria andOverdueMoneyNotEqualTo(BigDecimal value) {
            addCriterion("overdue_money <>", value, "overdueMoney");
            return (Criteria) this;
        }

        public Criteria andOverdueMoneyGreaterThan(BigDecimal value) {
            addCriterion("overdue_money >", value, "overdueMoney");
            return (Criteria) this;
        }

        public Criteria andOverdueMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("overdue_money >=", value, "overdueMoney");
            return (Criteria) this;
        }

        public Criteria andOverdueMoneyLessThan(BigDecimal value) {
            addCriterion("overdue_money <", value, "overdueMoney");
            return (Criteria) this;
        }

        public Criteria andOverdueMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("overdue_money <=", value, "overdueMoney");
            return (Criteria) this;
        }

        public Criteria andOverdueMoneyIn(List<BigDecimal> values) {
            addCriterion("overdue_money in", values, "overdueMoney");
            return (Criteria) this;
        }

        public Criteria andOverdueMoneyNotIn(List<BigDecimal> values) {
            addCriterion("overdue_money not in", values, "overdueMoney");
            return (Criteria) this;
        }

        public Criteria andOverdueMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("overdue_money between", value1, value2, "overdueMoney");
            return (Criteria) this;
        }

        public Criteria andOverdueMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("overdue_money not between", value1, value2, "overdueMoney");
            return (Criteria) this;
        }

        public Criteria andLoanLocationIsNull() {
            addCriterion("loan_location is null");
            return (Criteria) this;
        }

        public Criteria andLoanLocationIsNotNull() {
            addCriterion("loan_location is not null");
            return (Criteria) this;
        }

        public Criteria andLoanLocationEqualTo(String value) {
            addCriterion("loan_location =", value, "loanLocation");
            return (Criteria) this;
        }

        public Criteria andLoanLocationNotEqualTo(String value) {
            addCriterion("loan_location <>", value, "loanLocation");
            return (Criteria) this;
        }

        public Criteria andLoanLocationGreaterThan(String value) {
            addCriterion("loan_location >", value, "loanLocation");
            return (Criteria) this;
        }

        public Criteria andLoanLocationGreaterThanOrEqualTo(String value) {
            addCriterion("loan_location >=", value, "loanLocation");
            return (Criteria) this;
        }

        public Criteria andLoanLocationLessThan(String value) {
            addCriterion("loan_location <", value, "loanLocation");
            return (Criteria) this;
        }

        public Criteria andLoanLocationLessThanOrEqualTo(String value) {
            addCriterion("loan_location <=", value, "loanLocation");
            return (Criteria) this;
        }

        public Criteria andLoanLocationLike(String value) {
            addCriterion("loan_location like", value, "loanLocation");
            return (Criteria) this;
        }

        public Criteria andLoanLocationNotLike(String value) {
            addCriterion("loan_location not like", value, "loanLocation");
            return (Criteria) this;
        }

        public Criteria andLoanLocationIn(List<String> values) {
            addCriterion("loan_location in", values, "loanLocation");
            return (Criteria) this;
        }

        public Criteria andLoanLocationNotIn(List<String> values) {
            addCriterion("loan_location not in", values, "loanLocation");
            return (Criteria) this;
        }

        public Criteria andLoanLocationBetween(String value1, String value2) {
            addCriterion("loan_location between", value1, value2, "loanLocation");
            return (Criteria) this;
        }

        public Criteria andLoanLocationNotBetween(String value1, String value2) {
            addCriterion("loan_location not between", value1, value2, "loanLocation");
            return (Criteria) this;
        }

        public Criteria andLoanTypeIsNull() {
            addCriterion("loan_type is null");
            return (Criteria) this;
        }

        public Criteria andLoanTypeIsNotNull() {
            addCriterion("loan_type is not null");
            return (Criteria) this;
        }

        public Criteria andLoanTypeEqualTo(String value) {
            addCriterion("loan_type =", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeNotEqualTo(String value) {
            addCriterion("loan_type <>", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeGreaterThan(String value) {
            addCriterion("loan_type >", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeGreaterThanOrEqualTo(String value) {
            addCriterion("loan_type >=", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeLessThan(String value) {
            addCriterion("loan_type <", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeLessThanOrEqualTo(String value) {
            addCriterion("loan_type <=", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeLike(String value) {
            addCriterion("loan_type like", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeNotLike(String value) {
            addCriterion("loan_type not like", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeIn(List<String> values) {
            addCriterion("loan_type in", values, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeNotIn(List<String> values) {
            addCriterion("loan_type not in", values, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeBetween(String value1, String value2) {
            addCriterion("loan_type between", value1, value2, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeNotBetween(String value1, String value2) {
            addCriterion("loan_type not between", value1, value2, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanStartTimeIsNull() {
            addCriterion("loan_start_time is null");
            return (Criteria) this;
        }

        public Criteria andLoanStartTimeIsNotNull() {
            addCriterion("loan_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andLoanStartTimeEqualTo(Date value) {
            addCriterion("loan_start_time =", value, "loanStartTime");
            return (Criteria) this;
        }

        public Criteria andLoanStartTimeNotEqualTo(Date value) {
            addCriterion("loan_start_time <>", value, "loanStartTime");
            return (Criteria) this;
        }

        public Criteria andLoanStartTimeGreaterThan(Date value) {
            addCriterion("loan_start_time >", value, "loanStartTime");
            return (Criteria) this;
        }

        public Criteria andLoanStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("loan_start_time >=", value, "loanStartTime");
            return (Criteria) this;
        }

        public Criteria andLoanStartTimeLessThan(Date value) {
            addCriterion("loan_start_time <", value, "loanStartTime");
            return (Criteria) this;
        }

        public Criteria andLoanStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("loan_start_time <=", value, "loanStartTime");
            return (Criteria) this;
        }

        public Criteria andLoanStartTimeIn(List<Date> values) {
            addCriterion("loan_start_time in", values, "loanStartTime");
            return (Criteria) this;
        }

        public Criteria andLoanStartTimeNotIn(List<Date> values) {
            addCriterion("loan_start_time not in", values, "loanStartTime");
            return (Criteria) this;
        }

        public Criteria andLoanStartTimeBetween(Date value1, Date value2) {
            addCriterion("loan_start_time between", value1, value2, "loanStartTime");
            return (Criteria) this;
        }

        public Criteria andLoanStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("loan_start_time not between", value1, value2, "loanStartTime");
            return (Criteria) this;
        }

        public Criteria andLoanGuaranteeIsNull() {
            addCriterion("loan_guarantee is null");
            return (Criteria) this;
        }

        public Criteria andLoanGuaranteeIsNotNull() {
            addCriterion("loan_guarantee is not null");
            return (Criteria) this;
        }

        public Criteria andLoanGuaranteeEqualTo(String value) {
            addCriterion("loan_guarantee =", value, "loanGuarantee");
            return (Criteria) this;
        }

        public Criteria andLoanGuaranteeNotEqualTo(String value) {
            addCriterion("loan_guarantee <>", value, "loanGuarantee");
            return (Criteria) this;
        }

        public Criteria andLoanGuaranteeGreaterThan(String value) {
            addCriterion("loan_guarantee >", value, "loanGuarantee");
            return (Criteria) this;
        }

        public Criteria andLoanGuaranteeGreaterThanOrEqualTo(String value) {
            addCriterion("loan_guarantee >=", value, "loanGuarantee");
            return (Criteria) this;
        }

        public Criteria andLoanGuaranteeLessThan(String value) {
            addCriterion("loan_guarantee <", value, "loanGuarantee");
            return (Criteria) this;
        }

        public Criteria andLoanGuaranteeLessThanOrEqualTo(String value) {
            addCriterion("loan_guarantee <=", value, "loanGuarantee");
            return (Criteria) this;
        }

        public Criteria andLoanGuaranteeLike(String value) {
            addCriterion("loan_guarantee like", value, "loanGuarantee");
            return (Criteria) this;
        }

        public Criteria andLoanGuaranteeNotLike(String value) {
            addCriterion("loan_guarantee not like", value, "loanGuarantee");
            return (Criteria) this;
        }

        public Criteria andLoanGuaranteeIn(List<String> values) {
            addCriterion("loan_guarantee in", values, "loanGuarantee");
            return (Criteria) this;
        }

        public Criteria andLoanGuaranteeNotIn(List<String> values) {
            addCriterion("loan_guarantee not in", values, "loanGuarantee");
            return (Criteria) this;
        }

        public Criteria andLoanGuaranteeBetween(String value1, String value2) {
            addCriterion("loan_guarantee between", value1, value2, "loanGuarantee");
            return (Criteria) this;
        }

        public Criteria andLoanGuaranteeNotBetween(String value1, String value2) {
            addCriterion("loan_guarantee not between", value1, value2, "loanGuarantee");
            return (Criteria) this;
        }

        public Criteria andOverdueDurationIsNull() {
            addCriterion("overdue_duration is null");
            return (Criteria) this;
        }

        public Criteria andOverdueDurationIsNotNull() {
            addCriterion("overdue_duration is not null");
            return (Criteria) this;
        }

        public Criteria andOverdueDurationEqualTo(String value) {
            addCriterion("overdue_duration =", value, "overdueDuration");
            return (Criteria) this;
        }

        public Criteria andOverdueDurationNotEqualTo(String value) {
            addCriterion("overdue_duration <>", value, "overdueDuration");
            return (Criteria) this;
        }

        public Criteria andOverdueDurationGreaterThan(String value) {
            addCriterion("overdue_duration >", value, "overdueDuration");
            return (Criteria) this;
        }

        public Criteria andOverdueDurationGreaterThanOrEqualTo(String value) {
            addCriterion("overdue_duration >=", value, "overdueDuration");
            return (Criteria) this;
        }

        public Criteria andOverdueDurationLessThan(String value) {
            addCriterion("overdue_duration <", value, "overdueDuration");
            return (Criteria) this;
        }

        public Criteria andOverdueDurationLessThanOrEqualTo(String value) {
            addCriterion("overdue_duration <=", value, "overdueDuration");
            return (Criteria) this;
        }

        public Criteria andOverdueDurationLike(String value) {
            addCriterion("overdue_duration like", value, "overdueDuration");
            return (Criteria) this;
        }

        public Criteria andOverdueDurationNotLike(String value) {
            addCriterion("overdue_duration not like", value, "overdueDuration");
            return (Criteria) this;
        }

        public Criteria andOverdueDurationIn(List<String> values) {
            addCriterion("overdue_duration in", values, "overdueDuration");
            return (Criteria) this;
        }

        public Criteria andOverdueDurationNotIn(List<String> values) {
            addCriterion("overdue_duration not in", values, "overdueDuration");
            return (Criteria) this;
        }

        public Criteria andOverdueDurationBetween(String value1, String value2) {
            addCriterion("overdue_duration between", value1, value2, "overdueDuration");
            return (Criteria) this;
        }

        public Criteria andOverdueDurationNotBetween(String value1, String value2) {
            addCriterion("overdue_duration not between", value1, value2, "overdueDuration");
            return (Criteria) this;
        }

        public Criteria andOverdueStatusIsNull() {
            addCriterion("overdue_status is null");
            return (Criteria) this;
        }

        public Criteria andOverdueStatusIsNotNull() {
            addCriterion("overdue_status is not null");
            return (Criteria) this;
        }

        public Criteria andOverdueStatusEqualTo(String value) {
            addCriterion("overdue_status =", value, "overdueStatus");
            return (Criteria) this;
        }

        public Criteria andOverdueStatusNotEqualTo(String value) {
            addCriterion("overdue_status <>", value, "overdueStatus");
            return (Criteria) this;
        }

        public Criteria andOverdueStatusGreaterThan(String value) {
            addCriterion("overdue_status >", value, "overdueStatus");
            return (Criteria) this;
        }

        public Criteria andOverdueStatusGreaterThanOrEqualTo(String value) {
            addCriterion("overdue_status >=", value, "overdueStatus");
            return (Criteria) this;
        }

        public Criteria andOverdueStatusLessThan(String value) {
            addCriterion("overdue_status <", value, "overdueStatus");
            return (Criteria) this;
        }

        public Criteria andOverdueStatusLessThanOrEqualTo(String value) {
            addCriterion("overdue_status <=", value, "overdueStatus");
            return (Criteria) this;
        }

        public Criteria andOverdueStatusLike(String value) {
            addCriterion("overdue_status like", value, "overdueStatus");
            return (Criteria) this;
        }

        public Criteria andOverdueStatusNotLike(String value) {
            addCriterion("overdue_status not like", value, "overdueStatus");
            return (Criteria) this;
        }

        public Criteria andOverdueStatusIn(List<String> values) {
            addCriterion("overdue_status in", values, "overdueStatus");
            return (Criteria) this;
        }

        public Criteria andOverdueStatusNotIn(List<String> values) {
            addCriterion("overdue_status not in", values, "overdueStatus");
            return (Criteria) this;
        }

        public Criteria andOverdueStatusBetween(String value1, String value2) {
            addCriterion("overdue_status between", value1, value2, "overdueStatus");
            return (Criteria) this;
        }

        public Criteria andOverdueStatusNotBetween(String value1, String value2) {
            addCriterion("overdue_status not between", value1, value2, "overdueStatus");
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

        public Criteria andPersonalAddressIsNull() {
            addCriterion("personal_address is null");
            return (Criteria) this;
        }

        public Criteria andPersonalAddressIsNotNull() {
            addCriterion("personal_address is not null");
            return (Criteria) this;
        }

        public Criteria andPersonalAddressEqualTo(String value) {
            addCriterion("personal_address =", value, "personalAddress");
            return (Criteria) this;
        }

        public Criteria andPersonalAddressNotEqualTo(String value) {
            addCriterion("personal_address <>", value, "personalAddress");
            return (Criteria) this;
        }

        public Criteria andPersonalAddressGreaterThan(String value) {
            addCriterion("personal_address >", value, "personalAddress");
            return (Criteria) this;
        }

        public Criteria andPersonalAddressGreaterThanOrEqualTo(String value) {
            addCriterion("personal_address >=", value, "personalAddress");
            return (Criteria) this;
        }

        public Criteria andPersonalAddressLessThan(String value) {
            addCriterion("personal_address <", value, "personalAddress");
            return (Criteria) this;
        }

        public Criteria andPersonalAddressLessThanOrEqualTo(String value) {
            addCriterion("personal_address <=", value, "personalAddress");
            return (Criteria) this;
        }

        public Criteria andPersonalAddressLike(String value) {
            addCriterion("personal_address like", value, "personalAddress");
            return (Criteria) this;
        }

        public Criteria andPersonalAddressNotLike(String value) {
            addCriterion("personal_address not like", value, "personalAddress");
            return (Criteria) this;
        }

        public Criteria andPersonalAddressIn(List<String> values) {
            addCriterion("personal_address in", values, "personalAddress");
            return (Criteria) this;
        }

        public Criteria andPersonalAddressNotIn(List<String> values) {
            addCriterion("personal_address not in", values, "personalAddress");
            return (Criteria) this;
        }

        public Criteria andPersonalAddressBetween(String value1, String value2) {
            addCriterion("personal_address between", value1, value2, "personalAddress");
            return (Criteria) this;
        }

        public Criteria andPersonalAddressNotBetween(String value1, String value2) {
            addCriterion("personal_address not between", value1, value2, "personalAddress");
            return (Criteria) this;
        }

        public Criteria andOverdueTimesIsNull() {
            addCriterion("overdue_times is null");
            return (Criteria) this;
        }

        public Criteria andOverdueTimesIsNotNull() {
            addCriterion("overdue_times is not null");
            return (Criteria) this;
        }

        public Criteria andOverdueTimesEqualTo(String value) {
            addCriterion("overdue_times =", value, "overdueTimes");
            return (Criteria) this;
        }

        public Criteria andOverdueTimesNotEqualTo(String value) {
            addCriterion("overdue_times <>", value, "overdueTimes");
            return (Criteria) this;
        }

        public Criteria andOverdueTimesGreaterThan(String value) {
            addCriterion("overdue_times >", value, "overdueTimes");
            return (Criteria) this;
        }

        public Criteria andOverdueTimesGreaterThanOrEqualTo(String value) {
            addCriterion("overdue_times >=", value, "overdueTimes");
            return (Criteria) this;
        }

        public Criteria andOverdueTimesLessThan(String value) {
            addCriterion("overdue_times <", value, "overdueTimes");
            return (Criteria) this;
        }

        public Criteria andOverdueTimesLessThanOrEqualTo(String value) {
            addCriterion("overdue_times <=", value, "overdueTimes");
            return (Criteria) this;
        }

        public Criteria andOverdueTimesLike(String value) {
            addCriterion("overdue_times like", value, "overdueTimes");
            return (Criteria) this;
        }

        public Criteria andOverdueTimesNotLike(String value) {
            addCriterion("overdue_times not like", value, "overdueTimes");
            return (Criteria) this;
        }

        public Criteria andOverdueTimesIn(List<String> values) {
            addCriterion("overdue_times in", values, "overdueTimes");
            return (Criteria) this;
        }

        public Criteria andOverdueTimesNotIn(List<String> values) {
            addCriterion("overdue_times not in", values, "overdueTimes");
            return (Criteria) this;
        }

        public Criteria andOverdueTimesBetween(String value1, String value2) {
            addCriterion("overdue_times between", value1, value2, "overdueTimes");
            return (Criteria) this;
        }

        public Criteria andOverdueTimesNotBetween(String value1, String value2) {
            addCriterion("overdue_times not between", value1, value2, "overdueTimes");
            return (Criteria) this;
        }

        public Criteria andIshideIsNull() {
            addCriterion("ishide is null");
            return (Criteria) this;
        }

        public Criteria andIshideIsNotNull() {
            addCriterion("ishide is not null");
            return (Criteria) this;
        }

        public Criteria andIshideEqualTo(String value) {
            addCriterion("ishide =", value, "ishide");
            return (Criteria) this;
        }

        public Criteria andIshideNotEqualTo(String value) {
            addCriterion("ishide <>", value, "ishide");
            return (Criteria) this;
        }

        public Criteria andIshideGreaterThan(String value) {
            addCriterion("ishide >", value, "ishide");
            return (Criteria) this;
        }

        public Criteria andIshideGreaterThanOrEqualTo(String value) {
            addCriterion("ishide >=", value, "ishide");
            return (Criteria) this;
        }

        public Criteria andIshideLessThan(String value) {
            addCriterion("ishide <", value, "ishide");
            return (Criteria) this;
        }

        public Criteria andIshideLessThanOrEqualTo(String value) {
            addCriterion("ishide <=", value, "ishide");
            return (Criteria) this;
        }

        public Criteria andIshideLike(String value) {
            addCriterion("ishide like", value, "ishide");
            return (Criteria) this;
        }

        public Criteria andIshideNotLike(String value) {
            addCriterion("ishide not like", value, "ishide");
            return (Criteria) this;
        }

        public Criteria andIshideIn(List<String> values) {
            addCriterion("ishide in", values, "ishide");
            return (Criteria) this;
        }

        public Criteria andIshideNotIn(List<String> values) {
            addCriterion("ishide not in", values, "ishide");
            return (Criteria) this;
        }

        public Criteria andIshideBetween(String value1, String value2) {
            addCriterion("ishide between", value1, value2, "ishide");
            return (Criteria) this;
        }

        public Criteria andIshideNotBetween(String value1, String value2) {
            addCriterion("ishide not between", value1, value2, "ishide");
            return (Criteria) this;
        }

        public Criteria andHideTimeIsNull() {
            addCriterion("hide_time is null");
            return (Criteria) this;
        }

        public Criteria andHideTimeIsNotNull() {
            addCriterion("hide_time is not null");
            return (Criteria) this;
        }

        public Criteria andHideTimeEqualTo(Date value) {
            addCriterion("hide_time =", value, "hideTime");
            return (Criteria) this;
        }

        public Criteria andHideTimeNotEqualTo(Date value) {
            addCriterion("hide_time <>", value, "hideTime");
            return (Criteria) this;
        }

        public Criteria andHideTimeGreaterThan(Date value) {
            addCriterion("hide_time >", value, "hideTime");
            return (Criteria) this;
        }

        public Criteria andHideTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("hide_time >=", value, "hideTime");
            return (Criteria) this;
        }

        public Criteria andHideTimeLessThan(Date value) {
            addCriterion("hide_time <", value, "hideTime");
            return (Criteria) this;
        }

        public Criteria andHideTimeLessThanOrEqualTo(Date value) {
            addCriterion("hide_time <=", value, "hideTime");
            return (Criteria) this;
        }

        public Criteria andHideTimeIn(List<Date> values) {
            addCriterion("hide_time in", values, "hideTime");
            return (Criteria) this;
        }

        public Criteria andHideTimeNotIn(List<Date> values) {
            addCriterion("hide_time not in", values, "hideTime");
            return (Criteria) this;
        }

        public Criteria andHideTimeBetween(Date value1, Date value2) {
            addCriterion("hide_time between", value1, value2, "hideTime");
            return (Criteria) this;
        }

        public Criteria andHideTimeNotBetween(Date value1, Date value2) {
            addCriterion("hide_time not between", value1, value2, "hideTime");
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