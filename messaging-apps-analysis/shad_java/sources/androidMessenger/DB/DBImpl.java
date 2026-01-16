package androidMessenger.DB;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import androidMessenger.utilites.AppFavorUtils;
import androidMessenger.utilites.MyLog;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.aaap.messengercore.db.CursorInterFace;
import ir.aaap.messengercore.db.DB;
import ir.aaap.messengercore.db.DBHelperImpl;
import ir.aaap.messengercore.db.DBParser;
import ir.aaap.messengercore.db.WhereCondition;
import ir.resaneh1.iptv.helper.FirebaseEventSender;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import org.rbmain.messenger.DispatchQueue;

/* loaded from: classes.dex */
public class DBImpl implements DB {
    private static String DATABASE_NAME = AppFavorUtils.DATA_BASE_NAME_MESSENGER;
    private int accountNumber;
    private Context context;
    private DB.Delegate delegate;
    private SqliteHelper sqliteHelper;
    private DispatchQueue storageQueue = new DispatchQueue("dbStorageQueue");
    public String whereValue = "?";

    public DBImpl(Context context, int i) {
        this.context = context;
        this.accountNumber = i;
    }

    public String getDatabaseName() {
        return DATABASE_NAME + "_" + this.accountNumber;
    }

    class SqliteHelper extends SQLiteOpenHelper {
        public SQLiteDatabase onCreateSqLiteDatabase;
        public SQLiteDatabase sqLiteDatabase;

        public SqliteHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
            super(context, str, cursorFactory, i);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            this.sqLiteDatabase = sQLiteDatabase;
            this.onCreateSqLiteDatabase = sQLiteDatabase;
            if (DBImpl.this.delegate != null) {
                DBImpl.this.delegate.onCreate();
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            this.sqLiteDatabase = sQLiteDatabase;
            if (DBImpl.this.delegate != null) {
                DBImpl.this.delegate.onUpgrade(i, i2);
            }
        }
    }

    @Override // ir.aaap.messengercore.db.DB
    public void init(final DB.Delegate delegate) {
        this.storageQueue.postRunnable(new Runnable() { // from class: androidMessenger.DB.DBImpl$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$init$0(delegate);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0(DB.Delegate delegate) {
        setDelegate(delegate);
        SqliteHelper sqliteHelper = new SqliteHelper(this.context, getDatabaseName(), null, 11);
        this.sqliteHelper = sqliteHelper;
        sqliteHelper.getWritableDatabase();
        this.context = null;
        this.sqliteHelper.getWritableDatabase().close();
    }

    @Override // ir.aaap.messengercore.db.DB
    public void close() {
        this.storageQueue.postRunnable(new Runnable() { // from class: androidMessenger.DB.DBImpl$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$close$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$close$1() {
        SQLiteDatabase sQLiteDatabase = this.sqliteHelper.sqLiteDatabase;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.close();
        }
        this.sqliteHelper.close();
    }

    public void setDelegate(DB.Delegate delegate) {
        this.delegate = delegate;
    }

    @Override // ir.aaap.messengercore.db.DB
    public void alterTableAddColumn(final String str, final String str2, final DB.ColumnTypeEnum columnTypeEnum) {
        this.storageQueue.postRunnable(new Runnable() { // from class: androidMessenger.DB.DBImpl$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() throws SQLException {
                this.f$0.lambda$alterTableAddColumn$2(str, str2, columnTypeEnum);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$alterTableAddColumn$2(String str, String str2, DB.ColumnTypeEnum columnTypeEnum) throws SQLException {
        this.sqliteHelper.sqLiteDatabase.execSQL("ALTER TABLE " + str + " ADD " + str2 + " " + getTypeString(columnTypeEnum));
    }

    @Override // ir.aaap.messengercore.db.DB
    public void createTable(String str, Set<String> set, Map<String, DB.ColumnTypeEnum> map) throws SQLException {
        String str2;
        SQLiteDatabase sQLiteDatabase = this.sqliteHelper.onCreateSqLiteDatabase;
        String str3 = "db null";
        if (sQLiteDatabase == null || sQLiteDatabase.isReadOnly()) {
            if (sQLiteDatabase != null) {
                str2 = "readOnly" + sQLiteDatabase.isReadOnly();
            } else {
                str2 = "db null";
            }
            FirebaseEventSender.setKey("createTable1", str2);
            sQLiteDatabase = this.sqliteHelper.sqLiteDatabase;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("table name");
        sb.append(str);
        if (sQLiteDatabase != null) {
            str3 = "readOnly" + sQLiteDatabase.isReadOnly();
        }
        sb.append(str3);
        FirebaseEventSender.setKey("createTable2", sb.toString());
        createTableIner(sQLiteDatabase, str, set, map);
    }

    @Override // ir.aaap.messengercore.db.DB
    public <T> ArrayList<T> selectObject(final String str, final Set<String> set, final WhereCondition whereCondition, final String str2, final boolean z, final int i, final DBParser<T> dBParser) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final ArrayList<T> arrayList = new ArrayList<>();
        this.storageQueue.postRunnable(new Runnable() { // from class: androidMessenger.DB.DBImpl$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$selectObject$3(set, str, whereCondition, str2, z, i, dBParser, arrayList, countDownLatch);
            }
        });
        try {
            countDownLatch.await();
        } catch (Exception e) {
            MyLog.handleException(e);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$selectObject$3(Set set, String str, WhereCondition whereCondition, String str2, boolean z, int i, DBParser dBParser, ArrayList arrayList, CountDownLatch countDownLatch) {
        String strSubstring;
        ArrayList arrayList2 = new ArrayList();
        String str3 = "SELECT ";
        if (set == null || set.size() == 0) {
            strSubstring = "SELECT *";
        } else {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                str3 = str3 + ((String) it.next()) + ",";
            }
            strSubstring = str3.substring(0, str3.length() - 1);
        }
        String str4 = strSubstring + " FROM " + str;
        if (whereCondition != null) {
            WhereObject whereCondition2 = parseWhereCondition(whereCondition);
            str4 = str4 + " WHERE " + whereCondition2.whereString;
            arrayList2.addAll(whereCondition2.args);
        }
        if (str2 != null) {
            String str5 = str4 + " ORDER BY " + str2;
            if (z) {
                str4 = str5 + " ASC ";
            } else {
                str4 = str5 + " DESC ";
            }
        }
        if (i > 0) {
            str4 = str4 + "  LIMIT  ?";
            arrayList2.add(i + BuildConfig.FLAVOR);
        }
        FirebaseEventSender.setKey("select", "tableName " + str + " " + whereCondition + BuildConfig.FLAVOR);
        try {
            final Cursor cursorRawQuery = this.sqliteHelper.getReadableDatabase().rawQuery(str4, (String[]) arrayList2.toArray(new String[arrayList2.size()]));
            if (cursorRawQuery != null) {
                if (cursorRawQuery.moveToFirst()) {
                    do {
                        arrayList.add(dBParser.parse(new CursorInterFace(this) { // from class: androidMessenger.DB.DBImpl.1
                            @Override // ir.aaap.messengercore.db.CursorInterFace
                            public String getString(String str6) {
                                int columnIndex = cursorRawQuery.getColumnIndex(str6);
                                if (columnIndex >= 0) {
                                    return cursorRawQuery.getString(columnIndex);
                                }
                                return null;
                            }

                            @Override // ir.aaap.messengercore.db.CursorInterFace
                            public int getInt(String str6) {
                                int columnIndex = cursorRawQuery.getColumnIndex(str6);
                                if (columnIndex >= 0) {
                                    return cursorRawQuery.getInt(columnIndex);
                                }
                                return 0;
                            }

                            @Override // ir.aaap.messengercore.db.CursorInterFace
                            public long getLong(String str6) {
                                int columnIndex = cursorRawQuery.getColumnIndex(str6);
                                if (columnIndex >= 0) {
                                    return cursorRawQuery.getLong(columnIndex);
                                }
                                return 0L;
                            }

                            @Override // ir.aaap.messengercore.db.CursorInterFace
                            public double getDouble(String str6) {
                                int columnIndex = cursorRawQuery.getColumnIndex(str6);
                                if (columnIndex >= 0) {
                                    return cursorRawQuery.getDouble(columnIndex);
                                }
                                return 0.0d;
                            }

                            @Override // ir.aaap.messengercore.db.CursorInterFace
                            public float getFloat(String str6) {
                                int columnIndex = cursorRawQuery.getColumnIndex(str6);
                                if (columnIndex >= 0) {
                                    return cursorRawQuery.getFloat(columnIndex);
                                }
                                return 0.0f;
                            }
                        }));
                    } while (cursorRawQuery.moveToNext());
                }
                cursorRawQuery.close();
            }
        } catch (Exception e) {
            MyLog.handleException(e);
        }
        try {
            countDownLatch.countDown();
        } catch (Exception e2) {
            MyLog.handleException(e2);
        }
    }

    @Override // ir.aaap.messengercore.db.DB
    public <T> ArrayList<T> selectObject(final String str, final Set<String> set, final WhereCondition whereCondition, final String[] strArr, final DBHelperImpl.FunctionEnum[] functionEnumArr, final boolean[] zArr, final int i, final DBParser<T> dBParser) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final ArrayList<T> arrayList = new ArrayList<>();
        this.storageQueue.postRunnable(new Runnable() { // from class: androidMessenger.DB.DBImpl$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$selectObject$4(set, str, whereCondition, strArr, functionEnumArr, zArr, i, dBParser, arrayList, countDownLatch);
            }
        });
        try {
            countDownLatch.await();
        } catch (Exception e) {
            MyLog.handleException(e);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$selectObject$4(Set set, String str, WhereCondition whereCondition, String[] strArr, DBHelperImpl.FunctionEnum[] functionEnumArr, boolean[] zArr, int i, DBParser dBParser, ArrayList arrayList, CountDownLatch countDownLatch) {
        boolean z;
        StringBuilder sb = new StringBuilder("SELECT ");
        ArrayList arrayList2 = new ArrayList();
        if (set == null || set.size() == 0) {
            sb.append("*");
        } else {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                sb.append(((String) it.next()) + ",");
            }
            sb = new StringBuilder(sb.toString().substring(0, sb.length() - 1));
        }
        sb.append(" FROM " + str);
        if (whereCondition != null) {
            WhereObject whereCondition2 = parseWhereCondition(whereCondition);
            sb.append(" WHERE " + whereCondition2.whereString);
            arrayList2.addAll(whereCondition2.args);
        }
        if (strArr != null && strArr.length > 0) {
            sb.append(" ORDER BY ");
            for (int i2 = 0; i2 < strArr.length; i2++) {
                if (functionEnumArr == null || i2 >= functionEnumArr.length || functionEnumArr[i2] == null) {
                    z = false;
                } else {
                    sb.append(getFunctionString(functionEnumArr[i2]) + "(");
                    z = true;
                }
                sb.append(strArr[i2]);
                if (z) {
                    sb.append(")");
                }
                if (i2 < zArr.length && zArr[i2]) {
                    sb.append(" ASC ");
                } else {
                    sb.append(" DESC ");
                }
                if (i2 < strArr.length - 1) {
                    sb.append(", ");
                }
            }
        }
        if (i > 0) {
            sb.append("  LIMIT  ?");
            arrayList2.add(i + BuildConfig.FLAVOR);
        }
        try {
            final Cursor cursorRawQuery = this.sqliteHelper.getReadableDatabase().rawQuery(sb.toString(), (String[]) arrayList2.toArray(new String[arrayList2.size()]));
            if (cursorRawQuery != null) {
                if (cursorRawQuery.moveToFirst()) {
                    do {
                        arrayList.add(dBParser.parse(new CursorInterFace(this) { // from class: androidMessenger.DB.DBImpl.2
                            @Override // ir.aaap.messengercore.db.CursorInterFace
                            public String getString(String str2) {
                                int columnIndex = cursorRawQuery.getColumnIndex(str2);
                                if (columnIndex >= 0) {
                                    return cursorRawQuery.getString(columnIndex);
                                }
                                return null;
                            }

                            @Override // ir.aaap.messengercore.db.CursorInterFace
                            public int getInt(String str2) {
                                int columnIndex = cursorRawQuery.getColumnIndex(str2);
                                if (columnIndex >= 0) {
                                    return cursorRawQuery.getInt(columnIndex);
                                }
                                return 0;
                            }

                            @Override // ir.aaap.messengercore.db.CursorInterFace
                            public long getLong(String str2) {
                                int columnIndex = cursorRawQuery.getColumnIndex(str2);
                                if (columnIndex >= 0) {
                                    return cursorRawQuery.getLong(columnIndex);
                                }
                                return 0L;
                            }

                            @Override // ir.aaap.messengercore.db.CursorInterFace
                            public double getDouble(String str2) {
                                int columnIndex = cursorRawQuery.getColumnIndex(str2);
                                if (columnIndex >= 0) {
                                    return cursorRawQuery.getDouble(columnIndex);
                                }
                                return 0.0d;
                            }

                            @Override // ir.aaap.messengercore.db.CursorInterFace
                            public float getFloat(String str2) {
                                int columnIndex = cursorRawQuery.getColumnIndex(str2);
                                if (columnIndex >= 0) {
                                    return cursorRawQuery.getFloat(columnIndex);
                                }
                                return 0.0f;
                            }
                        }));
                    } while (cursorRawQuery.moveToNext());
                }
                cursorRawQuery.close();
            }
        } catch (Exception e) {
            MyLog.handleException(e);
        }
        try {
            countDownLatch.countDown();
        } catch (Exception e2) {
            MyLog.handleException(e2);
        }
    }

    @Override // ir.aaap.messengercore.db.DB
    public int count(final String str, final Set<String> set, final WhereCondition whereCondition) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final int[] iArr = {0};
        this.storageQueue.postRunnable(new Runnable() { // from class: androidMessenger.DB.DBImpl$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$count$5(set, str, whereCondition, iArr, countDownLatch);
            }
        });
        try {
            countDownLatch.await();
        } catch (Exception e) {
            MyLog.handleException(e);
        }
        return iArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$count$5(Set set, String str, WhereCondition whereCondition, int[] iArr, CountDownLatch countDownLatch) {
        String strSubstring;
        ArrayList arrayList = new ArrayList();
        String str2 = "SELECT COUNT(";
        if (set == null || set.size() == 0) {
            strSubstring = "SELECT COUNT(*";
        } else {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                str2 = str2 + ((String) it.next()) + ",";
            }
            strSubstring = str2.substring(0, str2.length() - 1);
        }
        String str3 = (strSubstring + ")") + " FROM " + str;
        if (whereCondition != null) {
            WhereObject whereCondition2 = parseWhereCondition(whereCondition);
            str3 = str3 + " WHERE " + whereCondition2.whereString;
            arrayList.addAll(whereCondition2.args);
        }
        try {
            Cursor cursorRawQuery = this.sqliteHelper.getReadableDatabase().rawQuery(str3, (String[]) arrayList.toArray(new String[arrayList.size()]));
            if (cursorRawQuery.moveToFirst()) {
                iArr[0] = cursorRawQuery.getInt(0);
            }
            cursorRawQuery.close();
        } catch (Exception e) {
            MyLog.handleException(e);
        }
        try {
            countDownLatch.countDown();
        } catch (Exception e2) {
            MyLog.handleException(e2);
        }
    }

    @Override // ir.aaap.messengercore.db.DB
    public long min(String str, String str2, WhereCondition whereCondition) {
        return minOrMaxInner(true, str, str2, whereCondition);
    }

    @Override // ir.aaap.messengercore.db.DB
    public long max(String str, String str2, WhereCondition whereCondition) {
        return minOrMaxInner(false, str, str2, whereCondition);
    }

    private long minOrMaxInner(final boolean z, final String str, final String str2, final WhereCondition whereCondition) throws InterruptedException {
        if (str == null || str2 == null) {
            return 0L;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final long[] jArr = {0};
        this.storageQueue.postRunnable(new Runnable() { // from class: androidMessenger.DB.DBImpl$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$minOrMaxInner$6(z, str2, str, whereCondition, jArr, countDownLatch);
            }
        });
        try {
            countDownLatch.await();
        } catch (Exception e) {
            MyLog.handleException(e);
        }
        return jArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$minOrMaxInner$6(boolean z, String str, String str2, WhereCondition whereCondition, long[] jArr, CountDownLatch countDownLatch) {
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(z ? "MIN" : "MAX");
        String str3 = sb.toString() + "(" + str + ") FROM " + str2;
        if (whereCondition != null) {
            WhereObject whereCondition2 = parseWhereCondition(whereCondition);
            str3 = str3 + " WHERE " + whereCondition2.whereString;
            arrayList.addAll(whereCondition2.args);
        }
        try {
            Cursor cursorRawQuery = this.sqliteHelper.getReadableDatabase().rawQuery(str3, (String[]) arrayList.toArray(new String[arrayList.size()]));
            if (cursorRawQuery.moveToFirst()) {
                long j = cursorRawQuery.getLong(0);
                cursorRawQuery.close();
                jArr[0] = j;
            }
            cursorRawQuery.close();
        } catch (Exception unused) {
        }
        try {
            countDownLatch.countDown();
        } catch (Exception e) {
            MyLog.handleException(e);
        }
    }

    @Override // ir.aaap.messengercore.db.DB
    public void removeObject(final String str, final WhereCondition whereCondition) {
        if (str == null) {
            return;
        }
        this.storageQueue.postRunnable(new Runnable() { // from class: androidMessenger.DB.DBImpl$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() throws SQLException {
                this.f$0.lambda$removeObject$7(str, whereCondition);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeObject$7(String str, WhereCondition whereCondition) throws SQLException {
        try {
            SQLiteDatabase writableDatabase = this.sqliteHelper.getWritableDatabase();
            String str2 = "DELETE  FROM " + str;
            if (whereCondition != null) {
                WhereObject whereCondition2 = parseWhereCondition(whereCondition);
                String str3 = str2 + " WHERE " + whereCondition2.whereString;
                ArrayList<String> arrayList = whereCondition2.args;
                writableDatabase.execSQL(str3, arrayList.toArray(new String[arrayList.size()]));
            } else {
                writableDatabase.execSQL(str2);
            }
        } catch (SQLiteException e) {
            MyLog.handleException(e);
        }
    }

    @Override // ir.aaap.messengercore.db.DB
    public void dropTable(final String str) {
        if (str == null) {
            return;
        }
        this.storageQueue.postRunnable(new Runnable() { // from class: androidMessenger.DB.DBImpl$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() throws SQLException {
                this.f$0.lambda$dropTable$8(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$dropTable$8(String str) throws SQLException {
        try {
            this.sqliteHelper.getWritableDatabase().execSQL("DROP TABLE IF EXISTS " + str);
        } catch (SQLiteException e) {
            MyLog.handleException(e);
        }
    }

    private void createTableIner(SQLiteDatabase sQLiteDatabase, String str, Set<String> set, Map<String, DB.ColumnTypeEnum> map) throws SQLException {
        if (str == null || set == null || set.size() == 0 || map == null || map.size() == 0) {
            return;
        }
        String str2 = "CREATE TABLE " + str + "(";
        for (String str3 : map.keySet()) {
            DB.ColumnTypeEnum columnTypeEnum = map.get(str3);
            if (columnTypeEnum == null) {
                columnTypeEnum = DB.ColumnTypeEnum.Varchar20;
            }
            str2 = str2 + str3 + getTypeString(columnTypeEnum) + ",";
        }
        String strSubstring = str2.substring(0, str2.length() - 1);
        if (set.size() > 0) {
            String str4 = strSubstring + ", PRIMARY KEY (";
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                str4 = str4 + it.next() + ",";
            }
            strSubstring = str4.substring(0, str4.length() - 1) + ")";
        }
        sQLiteDatabase.execSQL(strSubstring + ")");
    }

    private String getTypeString(DB.ColumnTypeEnum columnTypeEnum) {
        switch (AnonymousClass3.$SwitchMap$ir$aaap$messengercore$db$DB$ColumnTypeEnum[columnTypeEnum.ordinal()]) {
            case 1:
                return " REAL ";
            case 2:
                return " INTEGER ";
            case 3:
                return " INTEGER DEFAULT 0 ";
            case 4:
                return " INTEGER DEFAULT -1 ";
            case 5:
                return " TEXT ";
            case 6:
                return " VARCHAR(60) ";
            case 7:
                return " VARCHAR(100) ";
            case 8:
                return " VARCHAR(300) ";
            default:
                return " VARCHAR(20) ";
        }
    }

    @Override // ir.aaap.messengercore.db.DB
    public void insertAllToTable(final String str, final String[] strArr, final ArrayList<String[]> arrayList) {
        this.storageQueue.postRunnable(new Runnable() { // from class: androidMessenger.DB.DBImpl$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$insertAllToTable$9(arrayList, str, strArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$insertAllToTable$9(ArrayList arrayList, String str, String[] strArr) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        try {
            SQLiteDatabase writableDatabase = this.sqliteHelper.getWritableDatabase();
            writableDatabase.beginTransaction();
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    insertToTableInner(writableDatabase, false, str, strArr, (String[]) it.next());
                }
            } catch (Exception e) {
                MyLog.e("DBImpl", e.toString());
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
        } catch (SQLiteException e2) {
            MyLog.handleException(e2);
        }
    }

    @Override // ir.aaap.messengercore.db.DB
    public void insertToTable(final String str, final String[] strArr, final String[] strArr2) {
        this.storageQueue.postRunnable(new Runnable() { // from class: androidMessenger.DB.DBImpl$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() throws SQLException {
                this.f$0.lambda$insertToTable$10(str, strArr, strArr2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$insertToTable$10(String str, String[] strArr, String[] strArr2) throws SQLException {
        try {
            insertToTableInner(this.sqliteHelper.getWritableDatabase(), false, str, strArr, strArr2);
        } catch (SQLiteException e) {
            MyLog.handleException(e);
        }
    }

    @Override // ir.aaap.messengercore.db.DB
    public void updateTable(final String str, final String[] strArr, final String[] strArr2, final WhereCondition whereCondition) {
        this.storageQueue.postRunnable(new Runnable() { // from class: androidMessenger.DB.DBImpl$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() throws SQLException {
                this.f$0.lambda$updateTable$11(str, strArr, strArr2, whereCondition);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateTable$11(String str, String[] strArr, String[] strArr2, WhereCondition whereCondition) throws SQLException {
        try {
            updateTableInner(this.sqliteHelper.getWritableDatabase(), str, strArr, strArr2, whereCondition);
        } catch (SQLiteException e) {
            MyLog.handleException(e);
        }
    }

    @Override // ir.aaap.messengercore.db.DB
    public void updateTable(final String str, final String[] strArr, final ArrayList<String[]> arrayList, final WhereCondition[] whereConditionArr) {
        this.storageQueue.postRunnable(new Runnable() { // from class: androidMessenger.DB.DBImpl$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateTable$12(strArr, arrayList, whereConditionArr, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateTable$12(String[] strArr, ArrayList arrayList, WhereCondition[] whereConditionArr, String str) {
        if (strArr == null || arrayList == null || arrayList.size() == 0) {
            return;
        }
        try {
            SQLiteDatabase writableDatabase = this.sqliteHelper.getWritableDatabase();
            writableDatabase.beginTransaction();
            for (int i = 0; i < arrayList.size(); i++) {
                try {
                    String[] strArr2 = (String[]) arrayList.get(i);
                    if (whereConditionArr != null && i < whereConditionArr.length) {
                        updateTableInner(writableDatabase, str, strArr, strArr2, whereConditionArr[i]);
                    } else {
                        updateTableInner(writableDatabase, str, strArr, strArr2, null);
                    }
                } catch (Exception unused) {
                }
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
        } catch (SQLiteException e) {
            MyLog.handleException(e);
        }
    }

    private void updateTableInner(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String[] strArr2, WhereCondition whereCondition) throws SQLException {
        if (strArr.length != strArr2.length) {
            return;
        }
        try {
            int length = strArr.length;
            ArrayList arrayList = new ArrayList(Arrays.asList(strArr2));
            String str2 = "UPDATE " + str + " SET ";
            for (int i = 0; i < length; i++) {
                str2 = str2 + strArr[i] + "=?";
                if (i < length - 1) {
                    str2 = str2 + ",";
                }
            }
            if (whereCondition != null) {
                WhereObject whereCondition2 = parseWhereCondition(whereCondition);
                str2 = str2 + " WHERE " + whereCondition2.whereString;
                arrayList.addAll(whereCondition2.args);
            }
            sQLiteDatabase.execSQL(str2, (String[]) arrayList.toArray(new String[arrayList.size()]));
        } catch (Exception unused) {
        }
    }

    private void insertToTableInner(SQLiteDatabase sQLiteDatabase, boolean z, String str, String[] strArr, String[] strArr2) throws SQLException {
        int iMin = Math.min(strArr.length, strArr2.length);
        String str2 = (z ? "INSERT or  Ignore INTO " : "INSERT or  Replace INTO ") + str + "(";
        for (int i = 0; i < iMin; i++) {
            str2 = str2 + strArr[i];
            if (i < iMin - 1) {
                str2 = str2 + ",";
            }
        }
        String str3 = str2 + ") VALUES(";
        for (int i2 = 0; i2 < iMin; i2++) {
            str3 = str3 + "?";
            if (i2 < iMin - 1) {
                str3 = str3 + ",";
            }
        }
        sQLiteDatabase.execSQL(str3 + ")", strArr2);
    }

    @Override // ir.aaap.messengercore.db.DB
    public String getOperatorString(WhereCondition.OperatorEnum operatorEnum) {
        switch (AnonymousClass3.$SwitchMap$ir$aaap$messengercore$db$WhereCondition$OperatorEnum[operatorEnum.ordinal()]) {
            case 1:
                return " And ";
            case 2:
                return " Or ";
            case 3:
            case 4:
                return " = ";
            case 5:
                return " > ";
            case 6:
                return " >= ";
            case 7:
                return " < ";
            case 8:
                return " <= ";
            case 9:
                return " in ";
            case 10:
                return " LIKE ";
            default:
                return BuildConfig.FLAVOR;
        }
    }

    /* renamed from: androidMessenger.DB.DBImpl$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$ir$aaap$messengercore$db$DB$ColumnTypeEnum;
        static final /* synthetic */ int[] $SwitchMap$ir$aaap$messengercore$db$DBHelperImpl$FunctionEnum;
        static final /* synthetic */ int[] $SwitchMap$ir$aaap$messengercore$db$WhereCondition$OperatorEnum;

        static {
            int[] iArr = new int[DBHelperImpl.FunctionEnum.values().length];
            $SwitchMap$ir$aaap$messengercore$db$DBHelperImpl$FunctionEnum = iArr;
            try {
                iArr[DBHelperImpl.FunctionEnum.Abs.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            int[] iArr2 = new int[WhereCondition.OperatorEnum.values().length];
            $SwitchMap$ir$aaap$messengercore$db$WhereCondition$OperatorEnum = iArr2;
            try {
                iArr2[WhereCondition.OperatorEnum.And.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$ir$aaap$messengercore$db$WhereCondition$OperatorEnum[WhereCondition.OperatorEnum.Or.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$ir$aaap$messengercore$db$WhereCondition$OperatorEnum[WhereCondition.OperatorEnum.EQ.ordinal()] = 3;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$ir$aaap$messengercore$db$WhereCondition$OperatorEnum[WhereCondition.OperatorEnum.EqCaseInsensitive.ordinal()] = 4;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$ir$aaap$messengercore$db$WhereCondition$OperatorEnum[WhereCondition.OperatorEnum.GT.ordinal()] = 5;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$ir$aaap$messengercore$db$WhereCondition$OperatorEnum[WhereCondition.OperatorEnum.GTE.ordinal()] = 6;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$ir$aaap$messengercore$db$WhereCondition$OperatorEnum[WhereCondition.OperatorEnum.LT.ordinal()] = 7;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$ir$aaap$messengercore$db$WhereCondition$OperatorEnum[WhereCondition.OperatorEnum.LTE.ordinal()] = 8;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$ir$aaap$messengercore$db$WhereCondition$OperatorEnum[WhereCondition.OperatorEnum.In.ordinal()] = 9;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$ir$aaap$messengercore$db$WhereCondition$OperatorEnum[WhereCondition.OperatorEnum.Like.ordinal()] = 10;
            } catch (NoSuchFieldError unused11) {
            }
            int[] iArr3 = new int[DB.ColumnTypeEnum.values().length];
            $SwitchMap$ir$aaap$messengercore$db$DB$ColumnTypeEnum = iArr3;
            try {
                iArr3[DB.ColumnTypeEnum.Real.ordinal()] = 1;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$ir$aaap$messengercore$db$DB$ColumnTypeEnum[DB.ColumnTypeEnum.Integer.ordinal()] = 2;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$ir$aaap$messengercore$db$DB$ColumnTypeEnum[DB.ColumnTypeEnum.IntegerDefault0.ordinal()] = 3;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$ir$aaap$messengercore$db$DB$ColumnTypeEnum[DB.ColumnTypeEnum.IntegerDefaultMinus1.ordinal()] = 4;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$ir$aaap$messengercore$db$DB$ColumnTypeEnum[DB.ColumnTypeEnum.LongText.ordinal()] = 5;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$ir$aaap$messengercore$db$DB$ColumnTypeEnum[DB.ColumnTypeEnum.Varchar60.ordinal()] = 6;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$ir$aaap$messengercore$db$DB$ColumnTypeEnum[DB.ColumnTypeEnum.Varchar100.ordinal()] = 7;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$ir$aaap$messengercore$db$DB$ColumnTypeEnum[DB.ColumnTypeEnum.Varchar300.ordinal()] = 8;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$ir$aaap$messengercore$db$DB$ColumnTypeEnum[DB.ColumnTypeEnum.Varchar20.ordinal()] = 9;
            } catch (NoSuchFieldError unused20) {
            }
        }
    }

    @Override // ir.aaap.messengercore.db.DB
    public String getFunctionString(DBHelperImpl.FunctionEnum functionEnum) {
        return AnonymousClass3.$SwitchMap$ir$aaap$messengercore$db$DBHelperImpl$FunctionEnum[functionEnum.ordinal()] != 1 ? BuildConfig.FLAVOR : " abs ";
    }

    private WhereObject parseWhereCondition(WhereCondition whereCondition) {
        if (whereCondition == null) {
            return new WhereObject();
        }
        if (whereCondition.isLeaf()) {
            WhereObject whereObject = new WhereObject();
            if (whereCondition.value != null) {
                whereObject.whereString = whereCondition.columnName + getOperatorString(whereCondition.operator) + this.whereValue;
                if (whereCondition.operator == WhereCondition.OperatorEnum.EqCaseInsensitive) {
                    whereObject.whereString += "  COLLATE NOCASE ";
                }
                whereObject.args.add(whereCondition.value);
            } else {
                ArrayList<String> arrayList = whereCondition.values;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    StringBuilder sb = new StringBuilder();
                    if (whereCondition.values.size() > 100) {
                        sb.append("(");
                        for (int size = whereCondition.values.size() - 1; size >= 0; size--) {
                            sb.append("'");
                            sb.append(whereCondition.values.get(size));
                            sb.append("'");
                            arrayList2.add(whereCondition.values.get(size) + BuildConfig.FLAVOR);
                            if (size == 0) {
                                sb.append(")");
                            } else {
                                sb.append(",");
                            }
                        }
                    } else {
                        sb.append("(");
                        for (int size2 = whereCondition.values.size() - 1; size2 >= 0; size2--) {
                            sb.append("? ");
                            arrayList2.add(whereCondition.values.get(size2) + BuildConfig.FLAVOR);
                            if (size2 == 0) {
                                sb.append(")");
                            } else {
                                sb.append(",");
                            }
                        }
                        whereObject.args.addAll(arrayList2);
                    }
                    whereObject.whereString = whereCondition.columnName + getOperatorString(whereCondition.operator) + ((Object) sb);
                    if (whereCondition.operator == WhereCondition.OperatorEnum.EqCaseInsensitive) {
                        whereObject.whereString += "  COLLATE NOCASE ";
                    }
                }
            }
            return whereObject;
        }
        WhereObject whereCondition2 = parseWhereCondition(whereCondition.left);
        WhereObject whereCondition3 = parseWhereCondition(whereCondition.right);
        WhereObject whereObject2 = new WhereObject();
        whereObject2.whereString = "(" + whereCondition2.whereString + getOperatorString(whereCondition.operator) + whereCondition3.whereString + ")";
        whereObject2.args.addAll(whereCondition2.args);
        whereObject2.args.addAll(whereCondition3.args);
        return whereObject2;
    }
}
