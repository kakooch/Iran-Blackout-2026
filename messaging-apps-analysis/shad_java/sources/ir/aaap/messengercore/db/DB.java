package ir.aaap.messengercore.db;

import ir.aaap.messengercore.db.DBHelperImpl;
import ir.aaap.messengercore.db.WhereCondition;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public interface DB {

    public enum ColumnTypeEnum {
        Varchar300,
        Varchar100,
        Varchar20,
        Varchar60,
        LongText,
        Integer,
        Real,
        IntegerDefault0,
        IntegerDefaultMinus1
    }

    public interface Delegate {
        void onCreate();

        void onUpgrade(int i, int i2);
    }

    void alterTableAddColumn(String str, String str2, ColumnTypeEnum columnTypeEnum);

    void close();

    int count(String str, Set<String> set, WhereCondition whereCondition);

    void createTable(String str, Set<String> set, Map<String, ColumnTypeEnum> map);

    void dropTable(String str);

    String getFunctionString(DBHelperImpl.FunctionEnum functionEnum);

    String getOperatorString(WhereCondition.OperatorEnum operatorEnum);

    void init(Delegate delegate);

    void insertAllToTable(String str, String[] strArr, ArrayList<String[]> arrayList);

    void insertToTable(String str, String[] strArr, String[] strArr2);

    long max(String str, String str2, WhereCondition whereCondition);

    long min(String str, String str2, WhereCondition whereCondition);

    void removeObject(String str, WhereCondition whereCondition);

    <T> ArrayList<T> selectObject(String str, Set<String> set, WhereCondition whereCondition, String str2, boolean z, int i, DBParser<T> dBParser);

    <T> ArrayList<T> selectObject(String str, Set<String> set, WhereCondition whereCondition, String[] strArr, DBHelperImpl.FunctionEnum[] functionEnumArr, boolean[] zArr, int i, DBParser<T> dBParser);

    void updateTable(String str, String[] strArr, ArrayList<String[]> arrayList, WhereCondition[] whereConditionArr);

    void updateTable(String str, String[] strArr, String[] strArr2, WhereCondition whereCondition);
}
