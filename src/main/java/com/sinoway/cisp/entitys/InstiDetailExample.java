package com.sinoway.cisp.entitys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InstiDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InstiDetailExample() {
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

        public Criteria andInstiCodeIsNull() {
            addCriterion("insti_code is null");
            return (Criteria) this;
        }

        public Criteria andInstiCodeIsNotNull() {
            addCriterion("insti_code is not null");
            return (Criteria) this;
        }

        public Criteria andInstiCodeEqualTo(String value) {
            addCriterion("insti_code =", value, "instiCode");
            return (Criteria) this;
        }

        public Criteria andInstiCodeNotEqualTo(String value) {
            addCriterion("insti_code <>", value, "instiCode");
            return (Criteria) this;
        }

        public Criteria andInstiCodeGreaterThan(String value) {
            addCriterion("insti_code >", value, "instiCode");
            return (Criteria) this;
        }

        public Criteria andInstiCodeGreaterThanOrEqualTo(String value) {
            addCriterion("insti_code >=", value, "instiCode");
            return (Criteria) this;
        }

        public Criteria andInstiCodeLessThan(String value) {
            addCriterion("insti_code <", value, "instiCode");
            return (Criteria) this;
        }

        public Criteria andInstiCodeLessThanOrEqualTo(String value) {
            addCriterion("insti_code <=", value, "instiCode");
            return (Criteria) this;
        }

        public Criteria andInstiCodeLike(String value) {
            addCriterion("insti_code like", value, "instiCode");
            return (Criteria) this;
        }

        public Criteria andInstiCodeNotLike(String value) {
            addCriterion("insti_code not like", value, "instiCode");
            return (Criteria) this;
        }

        public Criteria andInstiCodeIn(List<String> values) {
            addCriterion("insti_code in", values, "instiCode");
            return (Criteria) this;
        }

        public Criteria andInstiCodeNotIn(List<String> values) {
            addCriterion("insti_code not in", values, "instiCode");
            return (Criteria) this;
        }

        public Criteria andInstiCodeBetween(String value1, String value2) {
            addCriterion("insti_code between", value1, value2, "instiCode");
            return (Criteria) this;
        }

        public Criteria andInstiCodeNotBetween(String value1, String value2) {
            addCriterion("insti_code not between", value1, value2, "instiCode");
            return (Criteria) this;
        }

        public Criteria andInstiTypeIsNull() {
            addCriterion("insti_type is null");
            return (Criteria) this;
        }

        public Criteria andInstiTypeIsNotNull() {
            addCriterion("insti_type is not null");
            return (Criteria) this;
        }

        public Criteria andInstiTypeEqualTo(String value) {
            addCriterion("insti_type =", value, "instiType");
            return (Criteria) this;
        }

        public Criteria andInstiTypeNotEqualTo(String value) {
            addCriterion("insti_type <>", value, "instiType");
            return (Criteria) this;
        }

        public Criteria andInstiTypeGreaterThan(String value) {
            addCriterion("insti_type >", value, "instiType");
            return (Criteria) this;
        }

        public Criteria andInstiTypeGreaterThanOrEqualTo(String value) {
            addCriterion("insti_type >=", value, "instiType");
            return (Criteria) this;
        }

        public Criteria andInstiTypeLessThan(String value) {
            addCriterion("insti_type <", value, "instiType");
            return (Criteria) this;
        }

        public Criteria andInstiTypeLessThanOrEqualTo(String value) {
            addCriterion("insti_type <=", value, "instiType");
            return (Criteria) this;
        }

        public Criteria andInstiTypeLike(String value) {
            addCriterion("insti_type like", value, "instiType");
            return (Criteria) this;
        }

        public Criteria andInstiTypeNotLike(String value) {
            addCriterion("insti_type not like", value, "instiType");
            return (Criteria) this;
        }

        public Criteria andInstiTypeIn(List<String> values) {
            addCriterion("insti_type in", values, "instiType");
            return (Criteria) this;
        }

        public Criteria andInstiTypeNotIn(List<String> values) {
            addCriterion("insti_type not in", values, "instiType");
            return (Criteria) this;
        }

        public Criteria andInstiTypeBetween(String value1, String value2) {
            addCriterion("insti_type between", value1, value2, "instiType");
            return (Criteria) this;
        }

        public Criteria andInstiTypeNotBetween(String value1, String value2) {
            addCriterion("insti_type not between", value1, value2, "instiType");
            return (Criteria) this;
        }

        public Criteria andInstiShortnameIsNull() {
            addCriterion("insti_shortname is null");
            return (Criteria) this;
        }

        public Criteria andInstiShortnameIsNotNull() {
            addCriterion("insti_shortname is not null");
            return (Criteria) this;
        }

        public Criteria andInstiShortnameEqualTo(String value) {
            addCriterion("insti_shortname =", value, "instiShortname");
            return (Criteria) this;
        }

        public Criteria andInstiShortnameNotEqualTo(String value) {
            addCriterion("insti_shortname <>", value, "instiShortname");
            return (Criteria) this;
        }

        public Criteria andInstiShortnameGreaterThan(String value) {
            addCriterion("insti_shortname >", value, "instiShortname");
            return (Criteria) this;
        }

        public Criteria andInstiShortnameGreaterThanOrEqualTo(String value) {
            addCriterion("insti_shortname >=", value, "instiShortname");
            return (Criteria) this;
        }

        public Criteria andInstiShortnameLessThan(String value) {
            addCriterion("insti_shortname <", value, "instiShortname");
            return (Criteria) this;
        }

        public Criteria andInstiShortnameLessThanOrEqualTo(String value) {
            addCriterion("insti_shortname <=", value, "instiShortname");
            return (Criteria) this;
        }

        public Criteria andInstiShortnameLike(String value) {
            addCriterion("insti_shortname like", value, "instiShortname");
            return (Criteria) this;
        }

        public Criteria andInstiShortnameNotLike(String value) {
            addCriterion("insti_shortname not like", value, "instiShortname");
            return (Criteria) this;
        }

        public Criteria andInstiShortnameIn(List<String> values) {
            addCriterion("insti_shortname in", values, "instiShortname");
            return (Criteria) this;
        }

        public Criteria andInstiShortnameNotIn(List<String> values) {
            addCriterion("insti_shortname not in", values, "instiShortname");
            return (Criteria) this;
        }

        public Criteria andInstiShortnameBetween(String value1, String value2) {
            addCriterion("insti_shortname between", value1, value2, "instiShortname");
            return (Criteria) this;
        }

        public Criteria andInstiShortnameNotBetween(String value1, String value2) {
            addCriterion("insti_shortname not between", value1, value2, "instiShortname");
            return (Criteria) this;
        }

        public Criteria andInstiNameIsNull() {
            addCriterion("insti_name is null");
            return (Criteria) this;
        }

        public Criteria andInstiNameIsNotNull() {
            addCriterion("insti_name is not null");
            return (Criteria) this;
        }

        public Criteria andInstiNameEqualTo(String value) {
            addCriterion("insti_name =", value, "instiName");
            return (Criteria) this;
        }

        public Criteria andInstiNameNotEqualTo(String value) {
            addCriterion("insti_name <>", value, "instiName");
            return (Criteria) this;
        }

        public Criteria andInstiNameGreaterThan(String value) {
            addCriterion("insti_name >", value, "instiName");
            return (Criteria) this;
        }

        public Criteria andInstiNameGreaterThanOrEqualTo(String value) {
            addCriterion("insti_name >=", value, "instiName");
            return (Criteria) this;
        }

        public Criteria andInstiNameLessThan(String value) {
            addCriterion("insti_name <", value, "instiName");
            return (Criteria) this;
        }

        public Criteria andInstiNameLessThanOrEqualTo(String value) {
            addCriterion("insti_name <=", value, "instiName");
            return (Criteria) this;
        }

        public Criteria andInstiNameLike(String value) {
            addCriterion("insti_name like", value, "instiName");
            return (Criteria) this;
        }

        public Criteria andInstiNameNotLike(String value) {
            addCriterion("insti_name not like", value, "instiName");
            return (Criteria) this;
        }

        public Criteria andInstiNameIn(List<String> values) {
            addCriterion("insti_name in", values, "instiName");
            return (Criteria) this;
        }

        public Criteria andInstiNameNotIn(List<String> values) {
            addCriterion("insti_name not in", values, "instiName");
            return (Criteria) this;
        }

        public Criteria andInstiNameBetween(String value1, String value2) {
            addCriterion("insti_name between", value1, value2, "instiName");
            return (Criteria) this;
        }

        public Criteria andInstiNameNotBetween(String value1, String value2) {
            addCriterion("insti_name not between", value1, value2, "instiName");
            return (Criteria) this;
        }

        public Criteria andCreditPersonIsNull() {
            addCriterion("credit_person is null");
            return (Criteria) this;
        }

        public Criteria andCreditPersonIsNotNull() {
            addCriterion("credit_person is not null");
            return (Criteria) this;
        }

        public Criteria andCreditPersonEqualTo(String value) {
            addCriterion("credit_person =", value, "creditPerson");
            return (Criteria) this;
        }

        public Criteria andCreditPersonNotEqualTo(String value) {
            addCriterion("credit_person <>", value, "creditPerson");
            return (Criteria) this;
        }

        public Criteria andCreditPersonGreaterThan(String value) {
            addCriterion("credit_person >", value, "creditPerson");
            return (Criteria) this;
        }

        public Criteria andCreditPersonGreaterThanOrEqualTo(String value) {
            addCriterion("credit_person >=", value, "creditPerson");
            return (Criteria) this;
        }

        public Criteria andCreditPersonLessThan(String value) {
            addCriterion("credit_person <", value, "creditPerson");
            return (Criteria) this;
        }

        public Criteria andCreditPersonLessThanOrEqualTo(String value) {
            addCriterion("credit_person <=", value, "creditPerson");
            return (Criteria) this;
        }

        public Criteria andCreditPersonLike(String value) {
            addCriterion("credit_person like", value, "creditPerson");
            return (Criteria) this;
        }

        public Criteria andCreditPersonNotLike(String value) {
            addCriterion("credit_person not like", value, "creditPerson");
            return (Criteria) this;
        }

        public Criteria andCreditPersonIn(List<String> values) {
            addCriterion("credit_person in", values, "creditPerson");
            return (Criteria) this;
        }

        public Criteria andCreditPersonNotIn(List<String> values) {
            addCriterion("credit_person not in", values, "creditPerson");
            return (Criteria) this;
        }

        public Criteria andCreditPersonBetween(String value1, String value2) {
            addCriterion("credit_person between", value1, value2, "creditPerson");
            return (Criteria) this;
        }

        public Criteria andCreditPersonNotBetween(String value1, String value2) {
            addCriterion("credit_person not between", value1, value2, "creditPerson");
            return (Criteria) this;
        }

        public Criteria andLawPersonIsNull() {
            addCriterion("law_person is null");
            return (Criteria) this;
        }

        public Criteria andLawPersonIsNotNull() {
            addCriterion("law_person is not null");
            return (Criteria) this;
        }

        public Criteria andLawPersonEqualTo(String value) {
            addCriterion("law_person =", value, "lawPerson");
            return (Criteria) this;
        }

        public Criteria andLawPersonNotEqualTo(String value) {
            addCriterion("law_person <>", value, "lawPerson");
            return (Criteria) this;
        }

        public Criteria andLawPersonGreaterThan(String value) {
            addCriterion("law_person >", value, "lawPerson");
            return (Criteria) this;
        }

        public Criteria andLawPersonGreaterThanOrEqualTo(String value) {
            addCriterion("law_person >=", value, "lawPerson");
            return (Criteria) this;
        }

        public Criteria andLawPersonLessThan(String value) {
            addCriterion("law_person <", value, "lawPerson");
            return (Criteria) this;
        }

        public Criteria andLawPersonLessThanOrEqualTo(String value) {
            addCriterion("law_person <=", value, "lawPerson");
            return (Criteria) this;
        }

        public Criteria andLawPersonLike(String value) {
            addCriterion("law_person like", value, "lawPerson");
            return (Criteria) this;
        }

        public Criteria andLawPersonNotLike(String value) {
            addCriterion("law_person not like", value, "lawPerson");
            return (Criteria) this;
        }

        public Criteria andLawPersonIn(List<String> values) {
            addCriterion("law_person in", values, "lawPerson");
            return (Criteria) this;
        }

        public Criteria andLawPersonNotIn(List<String> values) {
            addCriterion("law_person not in", values, "lawPerson");
            return (Criteria) this;
        }

        public Criteria andLawPersonBetween(String value1, String value2) {
            addCriterion("law_person between", value1, value2, "lawPerson");
            return (Criteria) this;
        }

        public Criteria andLawPersonNotBetween(String value1, String value2) {
            addCriterion("law_person not between", value1, value2, "lawPerson");
            return (Criteria) this;
        }

        public Criteria andCreditCodeIsNull() {
            addCriterion("credit_code is null");
            return (Criteria) this;
        }

        public Criteria andCreditCodeIsNotNull() {
            addCriterion("credit_code is not null");
            return (Criteria) this;
        }

        public Criteria andCreditCodeEqualTo(String value) {
            addCriterion("credit_code =", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeNotEqualTo(String value) {
            addCriterion("credit_code <>", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeGreaterThan(String value) {
            addCriterion("credit_code >", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeGreaterThanOrEqualTo(String value) {
            addCriterion("credit_code >=", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeLessThan(String value) {
            addCriterion("credit_code <", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeLessThanOrEqualTo(String value) {
            addCriterion("credit_code <=", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeLike(String value) {
            addCriterion("credit_code like", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeNotLike(String value) {
            addCriterion("credit_code not like", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeIn(List<String> values) {
            addCriterion("credit_code in", values, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeNotIn(List<String> values) {
            addCriterion("credit_code not in", values, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeBetween(String value1, String value2) {
            addCriterion("credit_code between", value1, value2, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeNotBetween(String value1, String value2) {
            addCriterion("credit_code not between", value1, value2, "creditCode");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressIsNull() {
            addCriterion("registered_address is null");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressIsNotNull() {
            addCriterion("registered_address is not null");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressEqualTo(String value) {
            addCriterion("registered_address =", value, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressNotEqualTo(String value) {
            addCriterion("registered_address <>", value, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressGreaterThan(String value) {
            addCriterion("registered_address >", value, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressGreaterThanOrEqualTo(String value) {
            addCriterion("registered_address >=", value, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressLessThan(String value) {
            addCriterion("registered_address <", value, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressLessThanOrEqualTo(String value) {
            addCriterion("registered_address <=", value, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressLike(String value) {
            addCriterion("registered_address like", value, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressNotLike(String value) {
            addCriterion("registered_address not like", value, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressIn(List<String> values) {
            addCriterion("registered_address in", values, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressNotIn(List<String> values) {
            addCriterion("registered_address not in", values, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressBetween(String value1, String value2) {
            addCriterion("registered_address between", value1, value2, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddressNotBetween(String value1, String value2) {
            addCriterion("registered_address not between", value1, value2, "registeredAddress");
            return (Criteria) this;
        }

        public Criteria andGeneralManagerIsNull() {
            addCriterion("general_manager is null");
            return (Criteria) this;
        }

        public Criteria andGeneralManagerIsNotNull() {
            addCriterion("general_manager is not null");
            return (Criteria) this;
        }

        public Criteria andGeneralManagerEqualTo(String value) {
            addCriterion("general_manager =", value, "generalManager");
            return (Criteria) this;
        }

        public Criteria andGeneralManagerNotEqualTo(String value) {
            addCriterion("general_manager <>", value, "generalManager");
            return (Criteria) this;
        }

        public Criteria andGeneralManagerGreaterThan(String value) {
            addCriterion("general_manager >", value, "generalManager");
            return (Criteria) this;
        }

        public Criteria andGeneralManagerGreaterThanOrEqualTo(String value) {
            addCriterion("general_manager >=", value, "generalManager");
            return (Criteria) this;
        }

        public Criteria andGeneralManagerLessThan(String value) {
            addCriterion("general_manager <", value, "generalManager");
            return (Criteria) this;
        }

        public Criteria andGeneralManagerLessThanOrEqualTo(String value) {
            addCriterion("general_manager <=", value, "generalManager");
            return (Criteria) this;
        }

        public Criteria andGeneralManagerLike(String value) {
            addCriterion("general_manager like", value, "generalManager");
            return (Criteria) this;
        }

        public Criteria andGeneralManagerNotLike(String value) {
            addCriterion("general_manager not like", value, "generalManager");
            return (Criteria) this;
        }

        public Criteria andGeneralManagerIn(List<String> values) {
            addCriterion("general_manager in", values, "generalManager");
            return (Criteria) this;
        }

        public Criteria andGeneralManagerNotIn(List<String> values) {
            addCriterion("general_manager not in", values, "generalManager");
            return (Criteria) this;
        }

        public Criteria andGeneralManagerBetween(String value1, String value2) {
            addCriterion("general_manager between", value1, value2, "generalManager");
            return (Criteria) this;
        }

        public Criteria andGeneralManagerNotBetween(String value1, String value2) {
            addCriterion("general_manager not between", value1, value2, "generalManager");
            return (Criteria) this;
        }

        public Criteria andZipCodeIsNull() {
            addCriterion("zip_code is null");
            return (Criteria) this;
        }

        public Criteria andZipCodeIsNotNull() {
            addCriterion("zip_code is not null");
            return (Criteria) this;
        }

        public Criteria andZipCodeEqualTo(Integer value) {
            addCriterion("zip_code =", value, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeNotEqualTo(Integer value) {
            addCriterion("zip_code <>", value, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeGreaterThan(Integer value) {
            addCriterion("zip_code >", value, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("zip_code >=", value, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeLessThan(Integer value) {
            addCriterion("zip_code <", value, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeLessThanOrEqualTo(Integer value) {
            addCriterion("zip_code <=", value, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeIn(List<Integer> values) {
            addCriterion("zip_code in", values, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeNotIn(List<Integer> values) {
            addCriterion("zip_code not in", values, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeBetween(Integer value1, Integer value2) {
            addCriterion("zip_code between", value1, value2, "zipCode");
            return (Criteria) this;
        }

        public Criteria andZipCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("zip_code not between", value1, value2, "zipCode");
            return (Criteria) this;
        }

        public Criteria andRegisteredCapitalIsNull() {
            addCriterion("registered_capital is null");
            return (Criteria) this;
        }

        public Criteria andRegisteredCapitalIsNotNull() {
            addCriterion("registered_capital is not null");
            return (Criteria) this;
        }

        public Criteria andRegisteredCapitalEqualTo(String value) {
            addCriterion("registered_capital =", value, "registeredCapital");
            return (Criteria) this;
        }

        public Criteria andRegisteredCapitalNotEqualTo(String value) {
            addCriterion("registered_capital <>", value, "registeredCapital");
            return (Criteria) this;
        }

        public Criteria andRegisteredCapitalGreaterThan(String value) {
            addCriterion("registered_capital >", value, "registeredCapital");
            return (Criteria) this;
        }

        public Criteria andRegisteredCapitalGreaterThanOrEqualTo(String value) {
            addCriterion("registered_capital >=", value, "registeredCapital");
            return (Criteria) this;
        }

        public Criteria andRegisteredCapitalLessThan(String value) {
            addCriterion("registered_capital <", value, "registeredCapital");
            return (Criteria) this;
        }

        public Criteria andRegisteredCapitalLessThanOrEqualTo(String value) {
            addCriterion("registered_capital <=", value, "registeredCapital");
            return (Criteria) this;
        }

        public Criteria andRegisteredCapitalLike(String value) {
            addCriterion("registered_capital like", value, "registeredCapital");
            return (Criteria) this;
        }

        public Criteria andRegisteredCapitalNotLike(String value) {
            addCriterion("registered_capital not like", value, "registeredCapital");
            return (Criteria) this;
        }

        public Criteria andRegisteredCapitalIn(List<String> values) {
            addCriterion("registered_capital in", values, "registeredCapital");
            return (Criteria) this;
        }

        public Criteria andRegisteredCapitalNotIn(List<String> values) {
            addCriterion("registered_capital not in", values, "registeredCapital");
            return (Criteria) this;
        }

        public Criteria andRegisteredCapitalBetween(String value1, String value2) {
            addCriterion("registered_capital between", value1, value2, "registeredCapital");
            return (Criteria) this;
        }

        public Criteria andRegisteredCapitalNotBetween(String value1, String value2) {
            addCriterion("registered_capital not between", value1, value2, "registeredCapital");
            return (Criteria) this;
        }

        public Criteria andWebUrlIsNull() {
            addCriterion("web_url is null");
            return (Criteria) this;
        }

        public Criteria andWebUrlIsNotNull() {
            addCriterion("web_url is not null");
            return (Criteria) this;
        }

        public Criteria andWebUrlEqualTo(String value) {
            addCriterion("web_url =", value, "webUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlNotEqualTo(String value) {
            addCriterion("web_url <>", value, "webUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlGreaterThan(String value) {
            addCriterion("web_url >", value, "webUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlGreaterThanOrEqualTo(String value) {
            addCriterion("web_url >=", value, "webUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlLessThan(String value) {
            addCriterion("web_url <", value, "webUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlLessThanOrEqualTo(String value) {
            addCriterion("web_url <=", value, "webUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlLike(String value) {
            addCriterion("web_url like", value, "webUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlNotLike(String value) {
            addCriterion("web_url not like", value, "webUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlIn(List<String> values) {
            addCriterion("web_url in", values, "webUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlNotIn(List<String> values) {
            addCriterion("web_url not in", values, "webUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlBetween(String value1, String value2) {
            addCriterion("web_url between", value1, value2, "webUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlNotBetween(String value1, String value2) {
            addCriterion("web_url not between", value1, value2, "webUrl");
            return (Criteria) this;
        }

        public Criteria andInstiAddressIsNull() {
            addCriterion("insti_address is null");
            return (Criteria) this;
        }

        public Criteria andInstiAddressIsNotNull() {
            addCriterion("insti_address is not null");
            return (Criteria) this;
        }

        public Criteria andInstiAddressEqualTo(String value) {
            addCriterion("insti_address =", value, "instiAddress");
            return (Criteria) this;
        }

        public Criteria andInstiAddressNotEqualTo(String value) {
            addCriterion("insti_address <>", value, "instiAddress");
            return (Criteria) this;
        }

        public Criteria andInstiAddressGreaterThan(String value) {
            addCriterion("insti_address >", value, "instiAddress");
            return (Criteria) this;
        }

        public Criteria andInstiAddressGreaterThanOrEqualTo(String value) {
            addCriterion("insti_address >=", value, "instiAddress");
            return (Criteria) this;
        }

        public Criteria andInstiAddressLessThan(String value) {
            addCriterion("insti_address <", value, "instiAddress");
            return (Criteria) this;
        }

        public Criteria andInstiAddressLessThanOrEqualTo(String value) {
            addCriterion("insti_address <=", value, "instiAddress");
            return (Criteria) this;
        }

        public Criteria andInstiAddressLike(String value) {
            addCriterion("insti_address like", value, "instiAddress");
            return (Criteria) this;
        }

        public Criteria andInstiAddressNotLike(String value) {
            addCriterion("insti_address not like", value, "instiAddress");
            return (Criteria) this;
        }

        public Criteria andInstiAddressIn(List<String> values) {
            addCriterion("insti_address in", values, "instiAddress");
            return (Criteria) this;
        }

        public Criteria andInstiAddressNotIn(List<String> values) {
            addCriterion("insti_address not in", values, "instiAddress");
            return (Criteria) this;
        }

        public Criteria andInstiAddressBetween(String value1, String value2) {
            addCriterion("insti_address between", value1, value2, "instiAddress");
            return (Criteria) this;
        }

        public Criteria andInstiAddressNotBetween(String value1, String value2) {
            addCriterion("insti_address not between", value1, value2, "instiAddress");
            return (Criteria) this;
        }

        public Criteria andFaxNumberIsNull() {
            addCriterion("fax_number is null");
            return (Criteria) this;
        }

        public Criteria andFaxNumberIsNotNull() {
            addCriterion("fax_number is not null");
            return (Criteria) this;
        }

        public Criteria andFaxNumberEqualTo(String value) {
            addCriterion("fax_number =", value, "faxNumber");
            return (Criteria) this;
        }

        public Criteria andFaxNumberNotEqualTo(String value) {
            addCriterion("fax_number <>", value, "faxNumber");
            return (Criteria) this;
        }

        public Criteria andFaxNumberGreaterThan(String value) {
            addCriterion("fax_number >", value, "faxNumber");
            return (Criteria) this;
        }

        public Criteria andFaxNumberGreaterThanOrEqualTo(String value) {
            addCriterion("fax_number >=", value, "faxNumber");
            return (Criteria) this;
        }

        public Criteria andFaxNumberLessThan(String value) {
            addCriterion("fax_number <", value, "faxNumber");
            return (Criteria) this;
        }

        public Criteria andFaxNumberLessThanOrEqualTo(String value) {
            addCriterion("fax_number <=", value, "faxNumber");
            return (Criteria) this;
        }

        public Criteria andFaxNumberLike(String value) {
            addCriterion("fax_number like", value, "faxNumber");
            return (Criteria) this;
        }

        public Criteria andFaxNumberNotLike(String value) {
            addCriterion("fax_number not like", value, "faxNumber");
            return (Criteria) this;
        }

        public Criteria andFaxNumberIn(List<String> values) {
            addCriterion("fax_number in", values, "faxNumber");
            return (Criteria) this;
        }

        public Criteria andFaxNumberNotIn(List<String> values) {
            addCriterion("fax_number not in", values, "faxNumber");
            return (Criteria) this;
        }

        public Criteria andFaxNumberBetween(String value1, String value2) {
            addCriterion("fax_number between", value1, value2, "faxNumber");
            return (Criteria) this;
        }

        public Criteria andFaxNumberNotBetween(String value1, String value2) {
            addCriterion("fax_number not between", value1, value2, "faxNumber");
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

        public Criteria andAccessIpIsNull() {
            addCriterion("access_ip is null");
            return (Criteria) this;
        }

        public Criteria andAccessIpIsNotNull() {
            addCriterion("access_ip is not null");
            return (Criteria) this;
        }

        public Criteria andAccessIpEqualTo(String value) {
            addCriterion("access_ip =", value, "accessIp");
            return (Criteria) this;
        }

        public Criteria andAccessIpNotEqualTo(String value) {
            addCriterion("access_ip <>", value, "accessIp");
            return (Criteria) this;
        }

        public Criteria andAccessIpGreaterThan(String value) {
            addCriterion("access_ip >", value, "accessIp");
            return (Criteria) this;
        }

        public Criteria andAccessIpGreaterThanOrEqualTo(String value) {
            addCriterion("access_ip >=", value, "accessIp");
            return (Criteria) this;
        }

        public Criteria andAccessIpLessThan(String value) {
            addCriterion("access_ip <", value, "accessIp");
            return (Criteria) this;
        }

        public Criteria andAccessIpLessThanOrEqualTo(String value) {
            addCriterion("access_ip <=", value, "accessIp");
            return (Criteria) this;
        }

        public Criteria andAccessIpLike(String value) {
            addCriterion("access_ip like", value, "accessIp");
            return (Criteria) this;
        }

        public Criteria andAccessIpNotLike(String value) {
            addCriterion("access_ip not like", value, "accessIp");
            return (Criteria) this;
        }

        public Criteria andAccessIpIn(List<String> values) {
            addCriterion("access_ip in", values, "accessIp");
            return (Criteria) this;
        }

        public Criteria andAccessIpNotIn(List<String> values) {
            addCriterion("access_ip not in", values, "accessIp");
            return (Criteria) this;
        }

        public Criteria andAccessIpBetween(String value1, String value2) {
            addCriterion("access_ip between", value1, value2, "accessIp");
            return (Criteria) this;
        }

        public Criteria andAccessIpNotBetween(String value1, String value2) {
            addCriterion("access_ip not between", value1, value2, "accessIp");
            return (Criteria) this;
        }

        public Criteria andFreezeStatusIsNull() {
            addCriterion("freeze_status is null");
            return (Criteria) this;
        }

        public Criteria andFreezeStatusIsNotNull() {
            addCriterion("freeze_status is not null");
            return (Criteria) this;
        }

        public Criteria andFreezeStatusEqualTo(String value) {
            addCriterion("freeze_status =", value, "freezeStatus");
            return (Criteria) this;
        }

        public Criteria andFreezeStatusNotEqualTo(String value) {
            addCriterion("freeze_status <>", value, "freezeStatus");
            return (Criteria) this;
        }

        public Criteria andFreezeStatusGreaterThan(String value) {
            addCriterion("freeze_status >", value, "freezeStatus");
            return (Criteria) this;
        }

        public Criteria andFreezeStatusGreaterThanOrEqualTo(String value) {
            addCriterion("freeze_status >=", value, "freezeStatus");
            return (Criteria) this;
        }

        public Criteria andFreezeStatusLessThan(String value) {
            addCriterion("freeze_status <", value, "freezeStatus");
            return (Criteria) this;
        }

        public Criteria andFreezeStatusLessThanOrEqualTo(String value) {
            addCriterion("freeze_status <=", value, "freezeStatus");
            return (Criteria) this;
        }

        public Criteria andFreezeStatusLike(String value) {
            addCriterion("freeze_status like", value, "freezeStatus");
            return (Criteria) this;
        }

        public Criteria andFreezeStatusNotLike(String value) {
            addCriterion("freeze_status not like", value, "freezeStatus");
            return (Criteria) this;
        }

        public Criteria andFreezeStatusIn(List<String> values) {
            addCriterion("freeze_status in", values, "freezeStatus");
            return (Criteria) this;
        }

        public Criteria andFreezeStatusNotIn(List<String> values) {
            addCriterion("freeze_status not in", values, "freezeStatus");
            return (Criteria) this;
        }

        public Criteria andFreezeStatusBetween(String value1, String value2) {
            addCriterion("freeze_status between", value1, value2, "freezeStatus");
            return (Criteria) this;
        }

        public Criteria andFreezeStatusNotBetween(String value1, String value2) {
            addCriterion("freeze_status not between", value1, value2, "freezeStatus");
            return (Criteria) this;
        }

        public Criteria andCreatTimeIsNull() {
            addCriterion("creat_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatTimeIsNotNull() {
            addCriterion("creat_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatTimeEqualTo(Date value) {
            addCriterion("creat_time =", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotEqualTo(Date value) {
            addCriterion("creat_time <>", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeGreaterThan(Date value) {
            addCriterion("creat_time >", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("creat_time >=", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeLessThan(Date value) {
            addCriterion("creat_time <", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeLessThanOrEqualTo(Date value) {
            addCriterion("creat_time <=", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeIn(List<Date> values) {
            addCriterion("creat_time in", values, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotIn(List<Date> values) {
            addCriterion("creat_time not in", values, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeBetween(Date value1, Date value2) {
            addCriterion("creat_time between", value1, value2, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotBetween(Date value1, Date value2) {
            addCriterion("creat_time not between", value1, value2, "creatTime");
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

        public Criteria andContractCodeIsNull() {
            addCriterion("contract_code is null");
            return (Criteria) this;
        }

        public Criteria andContractCodeIsNotNull() {
            addCriterion("contract_code is not null");
            return (Criteria) this;
        }

        public Criteria andContractCodeEqualTo(String value) {
            addCriterion("contract_code =", value, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeNotEqualTo(String value) {
            addCriterion("contract_code <>", value, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeGreaterThan(String value) {
            addCriterion("contract_code >", value, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeGreaterThanOrEqualTo(String value) {
            addCriterion("contract_code >=", value, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeLessThan(String value) {
            addCriterion("contract_code <", value, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeLessThanOrEqualTo(String value) {
            addCriterion("contract_code <=", value, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeLike(String value) {
            addCriterion("contract_code like", value, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeNotLike(String value) {
            addCriterion("contract_code not like", value, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeIn(List<String> values) {
            addCriterion("contract_code in", values, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeNotIn(List<String> values) {
            addCriterion("contract_code not in", values, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeBetween(String value1, String value2) {
            addCriterion("contract_code between", value1, value2, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeNotBetween(String value1, String value2) {
            addCriterion("contract_code not between", value1, value2, "contractCode");
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