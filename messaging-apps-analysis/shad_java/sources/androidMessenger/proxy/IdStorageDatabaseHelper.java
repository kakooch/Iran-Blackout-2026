package androidMessenger.proxy;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidMessenger.utilites.AppFavorUtils;
import androidMessenger.utilites.MyLog;
import io.github.inflationx.calligraphy3.BuildConfig;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.BaseController;

/* loaded from: classes.dex */
public class IdStorageDatabaseHelper extends SQLiteOpenHelper {
    private static final String CREATE_TABLE_DIALOG_ID;
    private static final String CREATE_TABLE_NOTIFICATION_ID;
    private static final String DATABASE_NAME = AppFavorUtils.DATA_BASE_NAME_ID_STORAGE + "Hash";
    private static volatile IdStorageDatabaseHelper[] Instance = new IdStorageDatabaseHelper[3];

    enum Column {
        guid,
        longId
    }

    enum TableName {
        dialogIdTable,
        notificationIdTable
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE ");
        sb.append(TableName.dialogIdTable);
        sb.append("(");
        Column column = Column.guid;
        sb.append(column);
        sb.append(" TEXT ,");
        Column column2 = Column.longId;
        sb.append(column2);
        sb.append(" INTEGER , PRIMARY KEY ( ");
        sb.append(column);
        sb.append(" ));");
        CREATE_TABLE_DIALOG_ID = sb.toString();
        CREATE_TABLE_NOTIFICATION_ID = "CREATE TABLE " + TableName.notificationIdTable + "(" + column + " TEXT ," + column2 + " INTEGER , PRIMARY KEY ( " + column + " ));";
    }

    public static IdStorageDatabaseHelper getInstance(int i) {
        IdStorageDatabaseHelper idStorageDatabaseHelper = Instance[i];
        if (idStorageDatabaseHelper == null) {
            synchronized (IdStorageDatabaseHelper.class) {
                idStorageDatabaseHelper = Instance[i];
                if (idStorageDatabaseHelper == null) {
                    IdStorageDatabaseHelper[] idStorageDatabaseHelperArr = Instance;
                    IdStorageDatabaseHelper idStorageDatabaseHelper2 = new IdStorageDatabaseHelper(i);
                    idStorageDatabaseHelperArr[i] = idStorageDatabaseHelper2;
                    idStorageDatabaseHelper = idStorageDatabaseHelper2;
                }
            }
        }
        return idStorageDatabaseHelper;
    }

    public IdStorageDatabaseHelper(int i) {
        super(ApplicationLoader.applicationContext, getDatabaseName(i), (SQLiteDatabase.CursorFactory) null, 2);
        new BaseController(i);
    }

    public static String getDatabaseName(int i) {
        return DATABASE_NAME + "_" + i;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL(CREATE_TABLE_DIALOG_ID);
        sQLiteDatabase.execSQL(CREATE_TABLE_NOTIFICATION_ID);
    }

    private void clearTable(String str, SQLiteDatabase sQLiteDatabase) throws SQLException {
        try {
            sQLiteDatabase.execSQL("DELETE  FROM " + str);
        } catch (Exception e) {
            MyLog.handleException(e);
        }
    }

    public void clearAll() {
        clearAll(getWritableDatabase());
    }

    private void clearAll(SQLiteDatabase sQLiteDatabase) throws SQLException {
        for (TableName tableName : TableName.values()) {
            clearTable(tableName.name(), sQLiteDatabase);
        }
    }

    public void addDialogId(String str, long j) throws Exception {
        addIdToTable(TableName.dialogIdTable.name(), str, j);
    }

    public void addNotificationId(String str, long j) throws Exception {
        addIdToTable(TableName.notificationIdTable.name(), str, j);
    }

    public Long getDialogId(String str) {
        return getId(TableName.dialogIdTable.name(), str);
    }

    public String getDialogGuid(long j) {
        return getGuid(TableName.dialogIdTable.name(), j);
    }

    public Long getNotificationId(String str) {
        return getId(TableName.notificationIdTable.name(), str);
    }

    public String getNotificationGuid(long j) {
        return getGuid(TableName.notificationIdTable.name(), j);
    }

    private void addIdToTable(String str, String str2, long j) throws Exception {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransaction();
            writableDatabase.execSQL("INSERT or Ignore INTO " + str + "(" + Column.guid + "," + Column.longId + ") VALUES(?,?) ", new String[]{str2, j + BuildConfig.FLAVOR});
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
        } catch (Exception e) {
            throw e;
        }
    }

    private Long getId(String str, String str2) {
        if (str != null && str2 != null) {
            Cursor cursorRawQuery = getReadableDatabase().rawQuery("SELECT  * FROM " + str + " WHERE " + Column.guid + " = '" + str2 + "'", null);
            if (cursorRawQuery.moveToFirst()) {
                long j = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex(Column.longId + BuildConfig.FLAVOR));
                cursorRawQuery.close();
                return Long.valueOf(j);
            }
            cursorRawQuery.close();
        }
        return null;
    }

    private String getGuid(String str, long j) {
        if (str == null) {
            return null;
        }
        Cursor cursorRawQuery = getReadableDatabase().rawQuery("SELECT  * FROM " + str + " WHERE " + Column.longId + " = '" + j + "'", null);
        if (cursorRawQuery.moveToFirst()) {
            String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex(Column.guid + BuildConfig.FLAVOR));
            cursorRawQuery.close();
            return string;
        }
        cursorRawQuery.close();
        return null;
    }
}
