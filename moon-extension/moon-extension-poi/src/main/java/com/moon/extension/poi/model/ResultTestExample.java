package com.moon.extension.poi.model;

import java.util.ArrayList;
import java.util.List;

public class ResultTestExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ResultTestExample() {
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

        public Criteria andIdNoIsNull() {
            addCriterion("ID_NO is null");
            return (Criteria) this;
        }

        public Criteria andIdNoIsNotNull() {
            addCriterion("ID_NO is not null");
            return (Criteria) this;
        }

        public Criteria andIdNoEqualTo(String value) {
            addCriterion("ID_NO =", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoNotEqualTo(String value) {
            addCriterion("ID_NO <>", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoGreaterThan(String value) {
            addCriterion("ID_NO >", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoGreaterThanOrEqualTo(String value) {
            addCriterion("ID_NO >=", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoLessThan(String value) {
            addCriterion("ID_NO <", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoLessThanOrEqualTo(String value) {
            addCriterion("ID_NO <=", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoLike(String value) {
            addCriterion("ID_NO like", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoNotLike(String value) {
            addCriterion("ID_NO not like", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoIn(List<String> values) {
            addCriterion("ID_NO in", values, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoNotIn(List<String> values) {
            addCriterion("ID_NO not in", values, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoBetween(String value1, String value2) {
            addCriterion("ID_NO between", value1, value2, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoNotBetween(String value1, String value2) {
            addCriterion("ID_NO not between", value1, value2, "idNo");
            return (Criteria) this;
        }

        public Criteria andCommentsIsNull() {
            addCriterion("COMMENTS is null");
            return (Criteria) this;
        }

        public Criteria andCommentsIsNotNull() {
            addCriterion("COMMENTS is not null");
            return (Criteria) this;
        }

        public Criteria andCommentsEqualTo(String value) {
            addCriterion("COMMENTS =", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotEqualTo(String value) {
            addCriterion("COMMENTS <>", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsGreaterThan(String value) {
            addCriterion("COMMENTS >", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsGreaterThanOrEqualTo(String value) {
            addCriterion("COMMENTS >=", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsLessThan(String value) {
            addCriterion("COMMENTS <", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsLessThanOrEqualTo(String value) {
            addCriterion("COMMENTS <=", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsLike(String value) {
            addCriterion("COMMENTS like", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotLike(String value) {
            addCriterion("COMMENTS not like", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsIn(List<String> values) {
            addCriterion("COMMENTS in", values, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotIn(List<String> values) {
            addCriterion("COMMENTS not in", values, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsBetween(String value1, String value2) {
            addCriterion("COMMENTS between", value1, value2, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotBetween(String value1, String value2) {
            addCriterion("COMMENTS not between", value1, value2, "comments");
            return (Criteria) this;
        }

        public Criteria andColleaguesLikeIsNull() {
            addCriterion("COLLEAGUES_LIKE is null");
            return (Criteria) this;
        }

        public Criteria andColleaguesLikeIsNotNull() {
            addCriterion("COLLEAGUES_LIKE is not null");
            return (Criteria) this;
        }

        public Criteria andColleaguesLikeEqualTo(String value) {
            addCriterion("COLLEAGUES_LIKE =", value, "colleaguesLike");
            return (Criteria) this;
        }

        public Criteria andColleaguesLikeNotEqualTo(String value) {
            addCriterion("COLLEAGUES_LIKE <>", value, "colleaguesLike");
            return (Criteria) this;
        }

        public Criteria andColleaguesLikeGreaterThan(String value) {
            addCriterion("COLLEAGUES_LIKE >", value, "colleaguesLike");
            return (Criteria) this;
        }

        public Criteria andColleaguesLikeGreaterThanOrEqualTo(String value) {
            addCriterion("COLLEAGUES_LIKE >=", value, "colleaguesLike");
            return (Criteria) this;
        }

        public Criteria andColleaguesLikeLessThan(String value) {
            addCriterion("COLLEAGUES_LIKE <", value, "colleaguesLike");
            return (Criteria) this;
        }

        public Criteria andColleaguesLikeLessThanOrEqualTo(String value) {
            addCriterion("COLLEAGUES_LIKE <=", value, "colleaguesLike");
            return (Criteria) this;
        }

        public Criteria andColleaguesLikeLike(String value) {
            addCriterion("COLLEAGUES_LIKE like", value, "colleaguesLike");
            return (Criteria) this;
        }

        public Criteria andColleaguesLikeNotLike(String value) {
            addCriterion("COLLEAGUES_LIKE not like", value, "colleaguesLike");
            return (Criteria) this;
        }

        public Criteria andColleaguesLikeIn(List<String> values) {
            addCriterion("COLLEAGUES_LIKE in", values, "colleaguesLike");
            return (Criteria) this;
        }

        public Criteria andColleaguesLikeNotIn(List<String> values) {
            addCriterion("COLLEAGUES_LIKE not in", values, "colleaguesLike");
            return (Criteria) this;
        }

        public Criteria andColleaguesLikeBetween(String value1, String value2) {
            addCriterion("COLLEAGUES_LIKE between", value1, value2, "colleaguesLike");
            return (Criteria) this;
        }

        public Criteria andColleaguesLikeNotBetween(String value1, String value2) {
            addCriterion("COLLEAGUES_LIKE not between", value1, value2, "colleaguesLike");
            return (Criteria) this;
        }

        public Criteria andUserCharacterIsNull() {
            addCriterion("USER_CHARACTER is null");
            return (Criteria) this;
        }

        public Criteria andUserCharacterIsNotNull() {
            addCriterion("USER_CHARACTER is not null");
            return (Criteria) this;
        }

        public Criteria andUserCharacterEqualTo(String value) {
            addCriterion("USER_CHARACTER =", value, "userCharacter");
            return (Criteria) this;
        }

        public Criteria andUserCharacterNotEqualTo(String value) {
            addCriterion("USER_CHARACTER <>", value, "userCharacter");
            return (Criteria) this;
        }

        public Criteria andUserCharacterGreaterThan(String value) {
            addCriterion("USER_CHARACTER >", value, "userCharacter");
            return (Criteria) this;
        }

        public Criteria andUserCharacterGreaterThanOrEqualTo(String value) {
            addCriterion("USER_CHARACTER >=", value, "userCharacter");
            return (Criteria) this;
        }

        public Criteria andUserCharacterLessThan(String value) {
            addCriterion("USER_CHARACTER <", value, "userCharacter");
            return (Criteria) this;
        }

        public Criteria andUserCharacterLessThanOrEqualTo(String value) {
            addCriterion("USER_CHARACTER <=", value, "userCharacter");
            return (Criteria) this;
        }

        public Criteria andUserCharacterLike(String value) {
            addCriterion("USER_CHARACTER like", value, "userCharacter");
            return (Criteria) this;
        }

        public Criteria andUserCharacterNotLike(String value) {
            addCriterion("USER_CHARACTER not like", value, "userCharacter");
            return (Criteria) this;
        }

        public Criteria andUserCharacterIn(List<String> values) {
            addCriterion("USER_CHARACTER in", values, "userCharacter");
            return (Criteria) this;
        }

        public Criteria andUserCharacterNotIn(List<String> values) {
            addCriterion("USER_CHARACTER not in", values, "userCharacter");
            return (Criteria) this;
        }

        public Criteria andUserCharacterBetween(String value1, String value2) {
            addCriterion("USER_CHARACTER between", value1, value2, "userCharacter");
            return (Criteria) this;
        }

        public Criteria andUserCharacterNotBetween(String value1, String value2) {
            addCriterion("USER_CHARACTER not between", value1, value2, "userCharacter");
            return (Criteria) this;
        }

        public Criteria andBookLookingIsNull() {
            addCriterion("BOOK_LOOKING is null");
            return (Criteria) this;
        }

        public Criteria andBookLookingIsNotNull() {
            addCriterion("BOOK_LOOKING is not null");
            return (Criteria) this;
        }

        public Criteria andBookLookingEqualTo(String value) {
            addCriterion("BOOK_LOOKING =", value, "bookLooking");
            return (Criteria) this;
        }

        public Criteria andBookLookingNotEqualTo(String value) {
            addCriterion("BOOK_LOOKING <>", value, "bookLooking");
            return (Criteria) this;
        }

        public Criteria andBookLookingGreaterThan(String value) {
            addCriterion("BOOK_LOOKING >", value, "bookLooking");
            return (Criteria) this;
        }

        public Criteria andBookLookingGreaterThanOrEqualTo(String value) {
            addCriterion("BOOK_LOOKING >=", value, "bookLooking");
            return (Criteria) this;
        }

        public Criteria andBookLookingLessThan(String value) {
            addCriterion("BOOK_LOOKING <", value, "bookLooking");
            return (Criteria) this;
        }

        public Criteria andBookLookingLessThanOrEqualTo(String value) {
            addCriterion("BOOK_LOOKING <=", value, "bookLooking");
            return (Criteria) this;
        }

        public Criteria andBookLookingLike(String value) {
            addCriterion("BOOK_LOOKING like", value, "bookLooking");
            return (Criteria) this;
        }

        public Criteria andBookLookingNotLike(String value) {
            addCriterion("BOOK_LOOKING not like", value, "bookLooking");
            return (Criteria) this;
        }

        public Criteria andBookLookingIn(List<String> values) {
            addCriterion("BOOK_LOOKING in", values, "bookLooking");
            return (Criteria) this;
        }

        public Criteria andBookLookingNotIn(List<String> values) {
            addCriterion("BOOK_LOOKING not in", values, "bookLooking");
            return (Criteria) this;
        }

        public Criteria andBookLookingBetween(String value1, String value2) {
            addCriterion("BOOK_LOOKING between", value1, value2, "bookLooking");
            return (Criteria) this;
        }

        public Criteria andBookLookingNotBetween(String value1, String value2) {
            addCriterion("BOOK_LOOKING not between", value1, value2, "bookLooking");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("USER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("USER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("USER_NAME =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("USER_NAME <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("USER_NAME >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("USER_NAME >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("USER_NAME <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("USER_NAME <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("USER_NAME like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("USER_NAME not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("USER_NAME in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("USER_NAME not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("USER_NAME between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("USER_NAME not between", value1, value2, "userName");
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