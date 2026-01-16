package ir.aaap.messengercore.db;

import java.util.ArrayList;

/* loaded from: classes3.dex */
public class WhereCondition {
    public String columnName;
    public WhereCondition left;
    public OperatorEnum operator;
    public WhereCondition right;
    public String value;
    public ArrayList<String> values;

    public enum OperatorEnum {
        And,
        Or,
        EQ,
        GT,
        GTE,
        LT,
        LTE,
        In,
        Like,
        EqCaseInsensitive
    }

    public WhereCondition(String str, OperatorEnum operatorEnum, String str2) {
        this.operator = operatorEnum;
        this.columnName = str;
        this.values = null;
        this.value = str2;
        this.right = null;
        this.left = null;
    }

    public WhereCondition(String str, OperatorEnum operatorEnum, ArrayList<String> arrayList) {
        this.operator = operatorEnum;
        this.columnName = str;
        this.value = null;
        this.values = arrayList;
        this.right = null;
        this.left = null;
    }

    public WhereCondition(WhereCondition whereCondition, OperatorEnum operatorEnum, WhereCondition whereCondition2) {
        this.operator = operatorEnum;
        this.left = whereCondition;
        this.right = whereCondition2;
        this.columnName = null;
        this.value = null;
        this.values = null;
    }

    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }
}
