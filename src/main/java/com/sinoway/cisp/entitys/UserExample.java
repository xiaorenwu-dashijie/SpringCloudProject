package com.sinoway.cisp.entitys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
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

        public Criteria andUserPswIsNull() {
            addCriterion("user_psw is null");
            return (Criteria) this;
        }

        public Criteria andUserPswIsNotNull() {
            addCriterion("user_psw is not null");
            return (Criteria) this;
        }

        public Criteria andUserPswEqualTo(String value) {
            addCriterion("user_psw =", value, "userPsw");
            return (Criteria) this;
        }

        public Criteria andUserPswNotEqualTo(String value) {
            addCriterion("user_psw <>", value, "userPsw");
            return (Criteria) this;
        }

        public Criteria andUserPswGreaterThan(String value) {
            addCriterion("user_psw >", value, "userPsw");
            return (Criteria) this;
        }

        public Criteria andUserPswGreaterThanOrEqualTo(String value) {
            addCriterion("user_psw >=", value, "userPsw");
            return (Criteria) this;
        }

        public Criteria andUserPswLessThan(String value) {
            addCriterion("user_psw <", value, "userPsw");
            return (Criteria) this;
        }

        public Criteria andUserPswLessThanOrEqualTo(String value) {
            addCriterion("user_psw <=", value, "userPsw");
            return (Criteria) this;
        }

        public Criteria andUserPswLike(String value) {
            addCriterion("user_psw like", value, "userPsw");
            return (Criteria) this;
        }

        public Criteria andUserPswNotLike(String value) {
            addCriterion("user_psw not like", value, "userPsw");
            return (Criteria) this;
        }

        public Criteria andUserPswIn(List<String> values) {
            addCriterion("user_psw in", values, "userPsw");
            return (Criteria) this;
        }

        public Criteria andUserPswNotIn(List<String> values) {
            addCriterion("user_psw not in", values, "userPsw");
            return (Criteria) this;
        }

        public Criteria andUserPswBetween(String value1, String value2) {
            addCriterion("user_psw between", value1, value2, "userPsw");
            return (Criteria) this;
        }

        public Criteria andUserPswNotBetween(String value1, String value2) {
            addCriterion("user_psw not between", value1, value2, "userPsw");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNull() {
            addCriterion("user_phone is null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNotNull() {
            addCriterion("user_phone is not null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneEqualTo(String value) {
            addCriterion("user_phone =", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotEqualTo(String value) {
            addCriterion("user_phone <>", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThan(String value) {
            addCriterion("user_phone >", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("user_phone >=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThan(String value) {
            addCriterion("user_phone <", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThanOrEqualTo(String value) {
            addCriterion("user_phone <=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLike(String value) {
            addCriterion("user_phone like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotLike(String value) {
            addCriterion("user_phone not like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIn(List<String> values) {
            addCriterion("user_phone in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotIn(List<String> values) {
            addCriterion("user_phone not in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneBetween(String value1, String value2) {
            addCriterion("user_phone between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotBetween(String value1, String value2) {
            addCriterion("user_phone not between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserMailIsNull() {
            addCriterion("user_mail is null");
            return (Criteria) this;
        }

        public Criteria andUserMailIsNotNull() {
            addCriterion("user_mail is not null");
            return (Criteria) this;
        }

        public Criteria andUserMailEqualTo(String value) {
            addCriterion("user_mail =", value, "userMail");
            return (Criteria) this;
        }

        public Criteria andUserMailNotEqualTo(String value) {
            addCriterion("user_mail <>", value, "userMail");
            return (Criteria) this;
        }

        public Criteria andUserMailGreaterThan(String value) {
            addCriterion("user_mail >", value, "userMail");
            return (Criteria) this;
        }

        public Criteria andUserMailGreaterThanOrEqualTo(String value) {
            addCriterion("user_mail >=", value, "userMail");
            return (Criteria) this;
        }

        public Criteria andUserMailLessThan(String value) {
            addCriterion("user_mail <", value, "userMail");
            return (Criteria) this;
        }

        public Criteria andUserMailLessThanOrEqualTo(String value) {
            addCriterion("user_mail <=", value, "userMail");
            return (Criteria) this;
        }

        public Criteria andUserMailLike(String value) {
            addCriterion("user_mail like", value, "userMail");
            return (Criteria) this;
        }

        public Criteria andUserMailNotLike(String value) {
            addCriterion("user_mail not like", value, "userMail");
            return (Criteria) this;
        }

        public Criteria andUserMailIn(List<String> values) {
            addCriterion("user_mail in", values, "userMail");
            return (Criteria) this;
        }

        public Criteria andUserMailNotIn(List<String> values) {
            addCriterion("user_mail not in", values, "userMail");
            return (Criteria) this;
        }

        public Criteria andUserMailBetween(String value1, String value2) {
            addCriterion("user_mail between", value1, value2, "userMail");
            return (Criteria) this;
        }

        public Criteria andUserMailNotBetween(String value1, String value2) {
            addCriterion("user_mail not between", value1, value2, "userMail");
            return (Criteria) this;
        }

        public Criteria andQqNumIsNull() {
            addCriterion("qq_num is null");
            return (Criteria) this;
        }

        public Criteria andQqNumIsNotNull() {
            addCriterion("qq_num is not null");
            return (Criteria) this;
        }

        public Criteria andQqNumEqualTo(String value) {
            addCriterion("qq_num =", value, "qqNum");
            return (Criteria) this;
        }

        public Criteria andQqNumNotEqualTo(String value) {
            addCriterion("qq_num <>", value, "qqNum");
            return (Criteria) this;
        }

        public Criteria andQqNumGreaterThan(String value) {
            addCriterion("qq_num >", value, "qqNum");
            return (Criteria) this;
        }

        public Criteria andQqNumGreaterThanOrEqualTo(String value) {
            addCriterion("qq_num >=", value, "qqNum");
            return (Criteria) this;
        }

        public Criteria andQqNumLessThan(String value) {
            addCriterion("qq_num <", value, "qqNum");
            return (Criteria) this;
        }

        public Criteria andQqNumLessThanOrEqualTo(String value) {
            addCriterion("qq_num <=", value, "qqNum");
            return (Criteria) this;
        }

        public Criteria andQqNumLike(String value) {
            addCriterion("qq_num like", value, "qqNum");
            return (Criteria) this;
        }

        public Criteria andQqNumNotLike(String value) {
            addCriterion("qq_num not like", value, "qqNum");
            return (Criteria) this;
        }

        public Criteria andQqNumIn(List<String> values) {
            addCriterion("qq_num in", values, "qqNum");
            return (Criteria) this;
        }

        public Criteria andQqNumNotIn(List<String> values) {
            addCriterion("qq_num not in", values, "qqNum");
            return (Criteria) this;
        }

        public Criteria andQqNumBetween(String value1, String value2) {
            addCriterion("qq_num between", value1, value2, "qqNum");
            return (Criteria) this;
        }

        public Criteria andQqNumNotBetween(String value1, String value2) {
            addCriterion("qq_num not between", value1, value2, "qqNum");
            return (Criteria) this;
        }

        public Criteria andWechatNumIsNull() {
            addCriterion("wechat_num is null");
            return (Criteria) this;
        }

        public Criteria andWechatNumIsNotNull() {
            addCriterion("wechat_num is not null");
            return (Criteria) this;
        }

        public Criteria andWechatNumEqualTo(String value) {
            addCriterion("wechat_num =", value, "wechatNum");
            return (Criteria) this;
        }

        public Criteria andWechatNumNotEqualTo(String value) {
            addCriterion("wechat_num <>", value, "wechatNum");
            return (Criteria) this;
        }

        public Criteria andWechatNumGreaterThan(String value) {
            addCriterion("wechat_num >", value, "wechatNum");
            return (Criteria) this;
        }

        public Criteria andWechatNumGreaterThanOrEqualTo(String value) {
            addCriterion("wechat_num >=", value, "wechatNum");
            return (Criteria) this;
        }

        public Criteria andWechatNumLessThan(String value) {
            addCriterion("wechat_num <", value, "wechatNum");
            return (Criteria) this;
        }

        public Criteria andWechatNumLessThanOrEqualTo(String value) {
            addCriterion("wechat_num <=", value, "wechatNum");
            return (Criteria) this;
        }

        public Criteria andWechatNumLike(String value) {
            addCriterion("wechat_num like", value, "wechatNum");
            return (Criteria) this;
        }

        public Criteria andWechatNumNotLike(String value) {
            addCriterion("wechat_num not like", value, "wechatNum");
            return (Criteria) this;
        }

        public Criteria andWechatNumIn(List<String> values) {
            addCriterion("wechat_num in", values, "wechatNum");
            return (Criteria) this;
        }

        public Criteria andWechatNumNotIn(List<String> values) {
            addCriterion("wechat_num not in", values, "wechatNum");
            return (Criteria) this;
        }

        public Criteria andWechatNumBetween(String value1, String value2) {
            addCriterion("wechat_num between", value1, value2, "wechatNum");
            return (Criteria) this;
        }

        public Criteria andWechatNumNotBetween(String value1, String value2) {
            addCriterion("wechat_num not between", value1, value2, "wechatNum");
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

        public Criteria andFunCodeFormatIsNull() {
            addCriterion("fun_code_format is null");
            return (Criteria) this;
        }

        public Criteria andFunCodeFormatIsNotNull() {
            addCriterion("fun_code_format is not null");
            return (Criteria) this;
        }

        public Criteria andFunCodeFormatEqualTo(String value) {
            addCriterion("fun_code_format =", value, "funCodeFormat");
            return (Criteria) this;
        }

        public Criteria andFunCodeFormatNotEqualTo(String value) {
            addCriterion("fun_code_format <>", value, "funCodeFormat");
            return (Criteria) this;
        }

        public Criteria andFunCodeFormatGreaterThan(String value) {
            addCriterion("fun_code_format >", value, "funCodeFormat");
            return (Criteria) this;
        }

        public Criteria andFunCodeFormatGreaterThanOrEqualTo(String value) {
            addCriterion("fun_code_format >=", value, "funCodeFormat");
            return (Criteria) this;
        }

        public Criteria andFunCodeFormatLessThan(String value) {
            addCriterion("fun_code_format <", value, "funCodeFormat");
            return (Criteria) this;
        }

        public Criteria andFunCodeFormatLessThanOrEqualTo(String value) {
            addCriterion("fun_code_format <=", value, "funCodeFormat");
            return (Criteria) this;
        }

        public Criteria andFunCodeFormatLike(String value) {
            addCriterion("fun_code_format like", value, "funCodeFormat");
            return (Criteria) this;
        }

        public Criteria andFunCodeFormatNotLike(String value) {
            addCriterion("fun_code_format not like", value, "funCodeFormat");
            return (Criteria) this;
        }

        public Criteria andFunCodeFormatIn(List<String> values) {
            addCriterion("fun_code_format in", values, "funCodeFormat");
            return (Criteria) this;
        }

        public Criteria andFunCodeFormatNotIn(List<String> values) {
            addCriterion("fun_code_format not in", values, "funCodeFormat");
            return (Criteria) this;
        }

        public Criteria andFunCodeFormatBetween(String value1, String value2) {
            addCriterion("fun_code_format between", value1, value2, "funCodeFormat");
            return (Criteria) this;
        }

        public Criteria andFunCodeFormatNotBetween(String value1, String value2) {
            addCriterion("fun_code_format not between", value1, value2, "funCodeFormat");
            return (Criteria) this;
        }

        public Criteria andLastTimeLoginIsNull() {
            addCriterion("last_time_login is null");
            return (Criteria) this;
        }

        public Criteria andLastTimeLoginIsNotNull() {
            addCriterion("last_time_login is not null");
            return (Criteria) this;
        }

        public Criteria andLastTimeLoginEqualTo(Date value) {
            addCriterion("last_time_login =", value, "lastTimeLogin");
            return (Criteria) this;
        }

        public Criteria andLastTimeLoginNotEqualTo(Date value) {
            addCriterion("last_time_login <>", value, "lastTimeLogin");
            return (Criteria) this;
        }

        public Criteria andLastTimeLoginGreaterThan(Date value) {
            addCriterion("last_time_login >", value, "lastTimeLogin");
            return (Criteria) this;
        }

        public Criteria andLastTimeLoginGreaterThanOrEqualTo(Date value) {
            addCriterion("last_time_login >=", value, "lastTimeLogin");
            return (Criteria) this;
        }

        public Criteria andLastTimeLoginLessThan(Date value) {
            addCriterion("last_time_login <", value, "lastTimeLogin");
            return (Criteria) this;
        }

        public Criteria andLastTimeLoginLessThanOrEqualTo(Date value) {
            addCriterion("last_time_login <=", value, "lastTimeLogin");
            return (Criteria) this;
        }

        public Criteria andLastTimeLoginIn(List<Date> values) {
            addCriterion("last_time_login in", values, "lastTimeLogin");
            return (Criteria) this;
        }

        public Criteria andLastTimeLoginNotIn(List<Date> values) {
            addCriterion("last_time_login not in", values, "lastTimeLogin");
            return (Criteria) this;
        }

        public Criteria andLastTimeLoginBetween(Date value1, Date value2) {
            addCriterion("last_time_login between", value1, value2, "lastTimeLogin");
            return (Criteria) this;
        }

        public Criteria andLastTimeLoginNotBetween(Date value1, Date value2) {
            addCriterion("last_time_login not between", value1, value2, "lastTimeLogin");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNull() {
            addCriterion("user_type is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNotNull() {
            addCriterion("user_type is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeEqualTo(String value) {
            addCriterion("user_type =", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotEqualTo(String value) {
            addCriterion("user_type <>", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThan(String value) {
            addCriterion("user_type >", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThanOrEqualTo(String value) {
            addCriterion("user_type >=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThan(String value) {
            addCriterion("user_type <", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThanOrEqualTo(String value) {
            addCriterion("user_type <=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLike(String value) {
            addCriterion("user_type like", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotLike(String value) {
            addCriterion("user_type not like", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeIn(List<String> values) {
            addCriterion("user_type in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotIn(List<String> values) {
            addCriterion("user_type not in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeBetween(String value1, String value2) {
            addCriterion("user_type between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotBetween(String value1, String value2) {
            addCriterion("user_type not between", value1, value2, "userType");
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

        public Criteria andUserKeyIsNull() {
            addCriterion("user_key is null");
            return (Criteria) this;
        }

        public Criteria andUserKeyIsNotNull() {
            addCriterion("user_key is not null");
            return (Criteria) this;
        }

        public Criteria andUserKeyEqualTo(String value) {
            addCriterion("user_key =", value, "userKey");
            return (Criteria) this;
        }

        public Criteria andUserKeyNotEqualTo(String value) {
            addCriterion("user_key <>", value, "userKey");
            return (Criteria) this;
        }

        public Criteria andUserKeyGreaterThan(String value) {
            addCriterion("user_key >", value, "userKey");
            return (Criteria) this;
        }

        public Criteria andUserKeyGreaterThanOrEqualTo(String value) {
            addCriterion("user_key >=", value, "userKey");
            return (Criteria) this;
        }

        public Criteria andUserKeyLessThan(String value) {
            addCriterion("user_key <", value, "userKey");
            return (Criteria) this;
        }

        public Criteria andUserKeyLessThanOrEqualTo(String value) {
            addCriterion("user_key <=", value, "userKey");
            return (Criteria) this;
        }

        public Criteria andUserKeyLike(String value) {
            addCriterion("user_key like", value, "userKey");
            return (Criteria) this;
        }

        public Criteria andUserKeyNotLike(String value) {
            addCriterion("user_key not like", value, "userKey");
            return (Criteria) this;
        }

        public Criteria andUserKeyIn(List<String> values) {
            addCriterion("user_key in", values, "userKey");
            return (Criteria) this;
        }

        public Criteria andUserKeyNotIn(List<String> values) {
            addCriterion("user_key not in", values, "userKey");
            return (Criteria) this;
        }

        public Criteria andUserKeyBetween(String value1, String value2) {
            addCriterion("user_key between", value1, value2, "userKey");
            return (Criteria) this;
        }

        public Criteria andUserKeyNotBetween(String value1, String value2) {
            addCriterion("user_key not between", value1, value2, "userKey");
            return (Criteria) this;
        }

        public Criteria andUserPrivateIsNull() {
            addCriterion("user_private is null");
            return (Criteria) this;
        }

        public Criteria andUserPrivateIsNotNull() {
            addCriterion("user_private is not null");
            return (Criteria) this;
        }

        public Criteria andUserPrivateEqualTo(String value) {
            addCriterion("user_private =", value, "userPrivate");
            return (Criteria) this;
        }

        public Criteria andUserPrivateNotEqualTo(String value) {
            addCriterion("user_private <>", value, "userPrivate");
            return (Criteria) this;
        }

        public Criteria andUserPrivateGreaterThan(String value) {
            addCriterion("user_private >", value, "userPrivate");
            return (Criteria) this;
        }

        public Criteria andUserPrivateGreaterThanOrEqualTo(String value) {
            addCriterion("user_private >=", value, "userPrivate");
            return (Criteria) this;
        }

        public Criteria andUserPrivateLessThan(String value) {
            addCriterion("user_private <", value, "userPrivate");
            return (Criteria) this;
        }

        public Criteria andUserPrivateLessThanOrEqualTo(String value) {
            addCriterion("user_private <=", value, "userPrivate");
            return (Criteria) this;
        }

        public Criteria andUserPrivateLike(String value) {
            addCriterion("user_private like", value, "userPrivate");
            return (Criteria) this;
        }

        public Criteria andUserPrivateNotLike(String value) {
            addCriterion("user_private not like", value, "userPrivate");
            return (Criteria) this;
        }

        public Criteria andUserPrivateIn(List<String> values) {
            addCriterion("user_private in", values, "userPrivate");
            return (Criteria) this;
        }

        public Criteria andUserPrivateNotIn(List<String> values) {
            addCriterion("user_private not in", values, "userPrivate");
            return (Criteria) this;
        }

        public Criteria andUserPrivateBetween(String value1, String value2) {
            addCriterion("user_private between", value1, value2, "userPrivate");
            return (Criteria) this;
        }

        public Criteria andUserPrivateNotBetween(String value1, String value2) {
            addCriterion("user_private not between", value1, value2, "userPrivate");
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