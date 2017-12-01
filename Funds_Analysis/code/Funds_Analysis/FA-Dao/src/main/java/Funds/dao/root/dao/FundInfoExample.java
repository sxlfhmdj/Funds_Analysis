package Funds.dao.root.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FundInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FundInfoExample() {
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

        public Criteria andFundCodeIsNull() {
            addCriterion("fund_code is null");
            return (Criteria) this;
        }

        public Criteria andFundCodeIsNotNull() {
            addCriterion("fund_code is not null");
            return (Criteria) this;
        }

        public Criteria andFundCodeEqualTo(String value) {
            addCriterion("fund_code =", value, "fundCode");
            return (Criteria) this;
        }

        public Criteria andFundCodeNotEqualTo(String value) {
            addCriterion("fund_code <>", value, "fundCode");
            return (Criteria) this;
        }

        public Criteria andFundCodeGreaterThan(String value) {
            addCriterion("fund_code >", value, "fundCode");
            return (Criteria) this;
        }

        public Criteria andFundCodeGreaterThanOrEqualTo(String value) {
            addCriterion("fund_code >=", value, "fundCode");
            return (Criteria) this;
        }

        public Criteria andFundCodeLessThan(String value) {
            addCriterion("fund_code <", value, "fundCode");
            return (Criteria) this;
        }

        public Criteria andFundCodeLessThanOrEqualTo(String value) {
            addCriterion("fund_code <=", value, "fundCode");
            return (Criteria) this;
        }

        public Criteria andFundCodeLike(String value) {
            addCriterion("fund_code like", value, "fundCode");
            return (Criteria) this;
        }

        public Criteria andFundCodeNotLike(String value) {
            addCriterion("fund_code not like", value, "fundCode");
            return (Criteria) this;
        }

        public Criteria andFundCodeIn(List<String> values) {
            addCriterion("fund_code in", values, "fundCode");
            return (Criteria) this;
        }

        public Criteria andFundCodeNotIn(List<String> values) {
            addCriterion("fund_code not in", values, "fundCode");
            return (Criteria) this;
        }

        public Criteria andFundCodeBetween(String value1, String value2) {
            addCriterion("fund_code between", value1, value2, "fundCode");
            return (Criteria) this;
        }

        public Criteria andFundCodeNotBetween(String value1, String value2) {
            addCriterion("fund_code not between", value1, value2, "fundCode");
            return (Criteria) this;
        }

        public Criteria andFundNameIsNull() {
            addCriterion("fund_name is null");
            return (Criteria) this;
        }

        public Criteria andFundNameIsNotNull() {
            addCriterion("fund_name is not null");
            return (Criteria) this;
        }

        public Criteria andFundNameEqualTo(String value) {
            addCriterion("fund_name =", value, "fundName");
            return (Criteria) this;
        }

        public Criteria andFundNameNotEqualTo(String value) {
            addCriterion("fund_name <>", value, "fundName");
            return (Criteria) this;
        }

        public Criteria andFundNameGreaterThan(String value) {
            addCriterion("fund_name >", value, "fundName");
            return (Criteria) this;
        }

        public Criteria andFundNameGreaterThanOrEqualTo(String value) {
            addCriterion("fund_name >=", value, "fundName");
            return (Criteria) this;
        }

        public Criteria andFundNameLessThan(String value) {
            addCriterion("fund_name <", value, "fundName");
            return (Criteria) this;
        }

        public Criteria andFundNameLessThanOrEqualTo(String value) {
            addCriterion("fund_name <=", value, "fundName");
            return (Criteria) this;
        }

        public Criteria andFundNameLike(String value) {
            addCriterion("fund_name like", value, "fundName");
            return (Criteria) this;
        }

        public Criteria andFundNameNotLike(String value) {
            addCriterion("fund_name not like", value, "fundName");
            return (Criteria) this;
        }

        public Criteria andFundNameIn(List<String> values) {
            addCriterion("fund_name in", values, "fundName");
            return (Criteria) this;
        }

        public Criteria andFundNameNotIn(List<String> values) {
            addCriterion("fund_name not in", values, "fundName");
            return (Criteria) this;
        }

        public Criteria andFundNameBetween(String value1, String value2) {
            addCriterion("fund_name between", value1, value2, "fundName");
            return (Criteria) this;
        }

        public Criteria andFundNameNotBetween(String value1, String value2) {
            addCriterion("fund_name not between", value1, value2, "fundName");
            return (Criteria) this;
        }

        public Criteria andShortNameIsNull() {
            addCriterion("short_name is null");
            return (Criteria) this;
        }

        public Criteria andShortNameIsNotNull() {
            addCriterion("short_name is not null");
            return (Criteria) this;
        }

        public Criteria andShortNameEqualTo(String value) {
            addCriterion("short_name =", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotEqualTo(String value) {
            addCriterion("short_name <>", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameGreaterThan(String value) {
            addCriterion("short_name >", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameGreaterThanOrEqualTo(String value) {
            addCriterion("short_name >=", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLessThan(String value) {
            addCriterion("short_name <", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLessThanOrEqualTo(String value) {
            addCriterion("short_name <=", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLike(String value) {
            addCriterion("short_name like", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotLike(String value) {
            addCriterion("short_name not like", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameIn(List<String> values) {
            addCriterion("short_name in", values, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotIn(List<String> values) {
            addCriterion("short_name not in", values, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameBetween(String value1, String value2) {
            addCriterion("short_name between", value1, value2, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotBetween(String value1, String value2) {
            addCriterion("short_name not between", value1, value2, "shortName");
            return (Criteria) this;
        }

        public Criteria andFundPyIsNull() {
            addCriterion("fund_py is null");
            return (Criteria) this;
        }

        public Criteria andFundPyIsNotNull() {
            addCriterion("fund_py is not null");
            return (Criteria) this;
        }

        public Criteria andFundPyEqualTo(String value) {
            addCriterion("fund_py =", value, "fundPy");
            return (Criteria) this;
        }

        public Criteria andFundPyNotEqualTo(String value) {
            addCriterion("fund_py <>", value, "fundPy");
            return (Criteria) this;
        }

        public Criteria andFundPyGreaterThan(String value) {
            addCriterion("fund_py >", value, "fundPy");
            return (Criteria) this;
        }

        public Criteria andFundPyGreaterThanOrEqualTo(String value) {
            addCriterion("fund_py >=", value, "fundPy");
            return (Criteria) this;
        }

        public Criteria andFundPyLessThan(String value) {
            addCriterion("fund_py <", value, "fundPy");
            return (Criteria) this;
        }

        public Criteria andFundPyLessThanOrEqualTo(String value) {
            addCriterion("fund_py <=", value, "fundPy");
            return (Criteria) this;
        }

        public Criteria andFundPyLike(String value) {
            addCriterion("fund_py like", value, "fundPy");
            return (Criteria) this;
        }

        public Criteria andFundPyNotLike(String value) {
            addCriterion("fund_py not like", value, "fundPy");
            return (Criteria) this;
        }

        public Criteria andFundPyIn(List<String> values) {
            addCriterion("fund_py in", values, "fundPy");
            return (Criteria) this;
        }

        public Criteria andFundPyNotIn(List<String> values) {
            addCriterion("fund_py not in", values, "fundPy");
            return (Criteria) this;
        }

        public Criteria andFundPyBetween(String value1, String value2) {
            addCriterion("fund_py between", value1, value2, "fundPy");
            return (Criteria) this;
        }

        public Criteria andFundPyNotBetween(String value1, String value2) {
            addCriterion("fund_py not between", value1, value2, "fundPy");
            return (Criteria) this;
        }

        public Criteria andFundTypeIsNull() {
            addCriterion("fund_type is null");
            return (Criteria) this;
        }

        public Criteria andFundTypeIsNotNull() {
            addCriterion("fund_type is not null");
            return (Criteria) this;
        }

        public Criteria andFundTypeEqualTo(String value) {
            addCriterion("fund_type =", value, "fundType");
            return (Criteria) this;
        }

        public Criteria andFundTypeNotEqualTo(String value) {
            addCriterion("fund_type <>", value, "fundType");
            return (Criteria) this;
        }

        public Criteria andFundTypeGreaterThan(String value) {
            addCriterion("fund_type >", value, "fundType");
            return (Criteria) this;
        }

        public Criteria andFundTypeGreaterThanOrEqualTo(String value) {
            addCriterion("fund_type >=", value, "fundType");
            return (Criteria) this;
        }

        public Criteria andFundTypeLessThan(String value) {
            addCriterion("fund_type <", value, "fundType");
            return (Criteria) this;
        }

        public Criteria andFundTypeLessThanOrEqualTo(String value) {
            addCriterion("fund_type <=", value, "fundType");
            return (Criteria) this;
        }

        public Criteria andFundTypeLike(String value) {
            addCriterion("fund_type like", value, "fundType");
            return (Criteria) this;
        }

        public Criteria andFundTypeNotLike(String value) {
            addCriterion("fund_type not like", value, "fundType");
            return (Criteria) this;
        }

        public Criteria andFundTypeIn(List<String> values) {
            addCriterion("fund_type in", values, "fundType");
            return (Criteria) this;
        }

        public Criteria andFundTypeNotIn(List<String> values) {
            addCriterion("fund_type not in", values, "fundType");
            return (Criteria) this;
        }

        public Criteria andFundTypeBetween(String value1, String value2) {
            addCriterion("fund_type between", value1, value2, "fundType");
            return (Criteria) this;
        }

        public Criteria andFundTypeNotBetween(String value1, String value2) {
            addCriterion("fund_type not between", value1, value2, "fundType");
            return (Criteria) this;
        }

        public Criteria andRiskLvlIsNull() {
            addCriterion("risk_lvl is null");
            return (Criteria) this;
        }

        public Criteria andRiskLvlIsNotNull() {
            addCriterion("risk_lvl is not null");
            return (Criteria) this;
        }

        public Criteria andRiskLvlEqualTo(String value) {
            addCriterion("risk_lvl =", value, "riskLvl");
            return (Criteria) this;
        }

        public Criteria andRiskLvlNotEqualTo(String value) {
            addCriterion("risk_lvl <>", value, "riskLvl");
            return (Criteria) this;
        }

        public Criteria andRiskLvlGreaterThan(String value) {
            addCriterion("risk_lvl >", value, "riskLvl");
            return (Criteria) this;
        }

        public Criteria andRiskLvlGreaterThanOrEqualTo(String value) {
            addCriterion("risk_lvl >=", value, "riskLvl");
            return (Criteria) this;
        }

        public Criteria andRiskLvlLessThan(String value) {
            addCriterion("risk_lvl <", value, "riskLvl");
            return (Criteria) this;
        }

        public Criteria andRiskLvlLessThanOrEqualTo(String value) {
            addCriterion("risk_lvl <=", value, "riskLvl");
            return (Criteria) this;
        }

        public Criteria andRiskLvlLike(String value) {
            addCriterion("risk_lvl like", value, "riskLvl");
            return (Criteria) this;
        }

        public Criteria andRiskLvlNotLike(String value) {
            addCriterion("risk_lvl not like", value, "riskLvl");
            return (Criteria) this;
        }

        public Criteria andRiskLvlIn(List<String> values) {
            addCriterion("risk_lvl in", values, "riskLvl");
            return (Criteria) this;
        }

        public Criteria andRiskLvlNotIn(List<String> values) {
            addCriterion("risk_lvl not in", values, "riskLvl");
            return (Criteria) this;
        }

        public Criteria andRiskLvlBetween(String value1, String value2) {
            addCriterion("risk_lvl between", value1, value2, "riskLvl");
            return (Criteria) this;
        }

        public Criteria andRiskLvlNotBetween(String value1, String value2) {
            addCriterion("risk_lvl not between", value1, value2, "riskLvl");
            return (Criteria) this;
        }

        public Criteria andSetUpDtIsNull() {
            addCriterion("set_up_dt is null");
            return (Criteria) this;
        }

        public Criteria andSetUpDtIsNotNull() {
            addCriterion("set_up_dt is not null");
            return (Criteria) this;
        }

        public Criteria andSetUpDtEqualTo(Date value) {
            addCriterion("set_up_dt =", value, "setUpDt");
            return (Criteria) this;
        }

        public Criteria andSetUpDtNotEqualTo(Date value) {
            addCriterion("set_up_dt <>", value, "setUpDt");
            return (Criteria) this;
        }

        public Criteria andSetUpDtGreaterThan(Date value) {
            addCriterion("set_up_dt >", value, "setUpDt");
            return (Criteria) this;
        }

        public Criteria andSetUpDtGreaterThanOrEqualTo(Date value) {
            addCriterion("set_up_dt >=", value, "setUpDt");
            return (Criteria) this;
        }

        public Criteria andSetUpDtLessThan(Date value) {
            addCriterion("set_up_dt <", value, "setUpDt");
            return (Criteria) this;
        }

        public Criteria andSetUpDtLessThanOrEqualTo(Date value) {
            addCriterion("set_up_dt <=", value, "setUpDt");
            return (Criteria) this;
        }

        public Criteria andSetUpDtIn(List<Date> values) {
            addCriterion("set_up_dt in", values, "setUpDt");
            return (Criteria) this;
        }

        public Criteria andSetUpDtNotIn(List<Date> values) {
            addCriterion("set_up_dt not in", values, "setUpDt");
            return (Criteria) this;
        }

        public Criteria andSetUpDtBetween(Date value1, Date value2) {
            addCriterion("set_up_dt between", value1, value2, "setUpDt");
            return (Criteria) this;
        }

        public Criteria andSetUpDtNotBetween(Date value1, Date value2) {
            addCriterion("set_up_dt not between", value1, value2, "setUpDt");
            return (Criteria) this;
        }

        public Criteria andHostPerIsNull() {
            addCriterion("host_per is null");
            return (Criteria) this;
        }

        public Criteria andHostPerIsNotNull() {
            addCriterion("host_per is not null");
            return (Criteria) this;
        }

        public Criteria andHostPerEqualTo(String value) {
            addCriterion("host_per =", value, "hostPer");
            return (Criteria) this;
        }

        public Criteria andHostPerNotEqualTo(String value) {
            addCriterion("host_per <>", value, "hostPer");
            return (Criteria) this;
        }

        public Criteria andHostPerGreaterThan(String value) {
            addCriterion("host_per >", value, "hostPer");
            return (Criteria) this;
        }

        public Criteria andHostPerGreaterThanOrEqualTo(String value) {
            addCriterion("host_per >=", value, "hostPer");
            return (Criteria) this;
        }

        public Criteria andHostPerLessThan(String value) {
            addCriterion("host_per <", value, "hostPer");
            return (Criteria) this;
        }

        public Criteria andHostPerLessThanOrEqualTo(String value) {
            addCriterion("host_per <=", value, "hostPer");
            return (Criteria) this;
        }

        public Criteria andHostPerLike(String value) {
            addCriterion("host_per like", value, "hostPer");
            return (Criteria) this;
        }

        public Criteria andHostPerNotLike(String value) {
            addCriterion("host_per not like", value, "hostPer");
            return (Criteria) this;
        }

        public Criteria andHostPerIn(List<String> values) {
            addCriterion("host_per in", values, "hostPer");
            return (Criteria) this;
        }

        public Criteria andHostPerNotIn(List<String> values) {
            addCriterion("host_per not in", values, "hostPer");
            return (Criteria) this;
        }

        public Criteria andHostPerBetween(String value1, String value2) {
            addCriterion("host_per between", value1, value2, "hostPer");
            return (Criteria) this;
        }

        public Criteria andHostPerNotBetween(String value1, String value2) {
            addCriterion("host_per not between", value1, value2, "hostPer");
            return (Criteria) this;
        }

        public Criteria andFundScaleIsNull() {
            addCriterion("fund_scale is null");
            return (Criteria) this;
        }

        public Criteria andFundScaleIsNotNull() {
            addCriterion("fund_scale is not null");
            return (Criteria) this;
        }

        public Criteria andFundScaleEqualTo(BigDecimal value) {
            addCriterion("fund_scale =", value, "fundScale");
            return (Criteria) this;
        }

        public Criteria andFundScaleNotEqualTo(BigDecimal value) {
            addCriterion("fund_scale <>", value, "fundScale");
            return (Criteria) this;
        }

        public Criteria andFundScaleGreaterThan(BigDecimal value) {
            addCriterion("fund_scale >", value, "fundScale");
            return (Criteria) this;
        }

        public Criteria andFundScaleGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fund_scale >=", value, "fundScale");
            return (Criteria) this;
        }

        public Criteria andFundScaleLessThan(BigDecimal value) {
            addCriterion("fund_scale <", value, "fundScale");
            return (Criteria) this;
        }

        public Criteria andFundScaleLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fund_scale <=", value, "fundScale");
            return (Criteria) this;
        }

        public Criteria andFundScaleIn(List<BigDecimal> values) {
            addCriterion("fund_scale in", values, "fundScale");
            return (Criteria) this;
        }

        public Criteria andFundScaleNotIn(List<BigDecimal> values) {
            addCriterion("fund_scale not in", values, "fundScale");
            return (Criteria) this;
        }

        public Criteria andFundScaleBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fund_scale between", value1, value2, "fundScale");
            return (Criteria) this;
        }

        public Criteria andFundScaleNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fund_scale not between", value1, value2, "fundScale");
            return (Criteria) this;
        }

        public Criteria andCreateDtIsNull() {
            addCriterion("create_dt is null");
            return (Criteria) this;
        }

        public Criteria andCreateDtIsNotNull() {
            addCriterion("create_dt is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDtEqualTo(Date value) {
            addCriterion("create_dt =", value, "createDt");
            return (Criteria) this;
        }

        public Criteria andCreateDtNotEqualTo(Date value) {
            addCriterion("create_dt <>", value, "createDt");
            return (Criteria) this;
        }

        public Criteria andCreateDtGreaterThan(Date value) {
            addCriterion("create_dt >", value, "createDt");
            return (Criteria) this;
        }

        public Criteria andCreateDtGreaterThanOrEqualTo(Date value) {
            addCriterion("create_dt >=", value, "createDt");
            return (Criteria) this;
        }

        public Criteria andCreateDtLessThan(Date value) {
            addCriterion("create_dt <", value, "createDt");
            return (Criteria) this;
        }

        public Criteria andCreateDtLessThanOrEqualTo(Date value) {
            addCriterion("create_dt <=", value, "createDt");
            return (Criteria) this;
        }

        public Criteria andCreateDtIn(List<Date> values) {
            addCriterion("create_dt in", values, "createDt");
            return (Criteria) this;
        }

        public Criteria andCreateDtNotIn(List<Date> values) {
            addCriterion("create_dt not in", values, "createDt");
            return (Criteria) this;
        }

        public Criteria andCreateDtBetween(Date value1, Date value2) {
            addCriterion("create_dt between", value1, value2, "createDt");
            return (Criteria) this;
        }

        public Criteria andCreateDtNotBetween(Date value1, Date value2) {
            addCriterion("create_dt not between", value1, value2, "createDt");
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