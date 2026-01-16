package androidMessenger.network;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidMessenger.model.ApiCacheObject;
import androidMessenger.utilites.AppFavorUtils;
import androidMessenger.utilites.MyLog;
import io.github.inflationx.calligraphy3.BuildConfig;
import java.util.ArrayList;
import java.util.Collection;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.BaseController;

/* loaded from: classes.dex */
public class CacheDatabaseHelper extends SQLiteOpenHelper {
    private static final String CREATE_TABLE_ApiCache;
    private static final String DATABASE_NAME = AppFavorUtils.DATA_BASE_NAME_CACHE;
    private static volatile CacheDatabaseHelper[] Instance = new CacheDatabaseHelper[3];

    enum ApiCacheColumn {
        methodName,
        input,
        appVersion,
        output,
        expiredTime
    }

    enum TableName {
        apiCacheTable
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE ");
        sb.append(TableName.apiCacheTable);
        sb.append("(");
        ApiCacheColumn apiCacheColumn = ApiCacheColumn.methodName;
        sb.append(apiCacheColumn);
        sb.append(" TEXT ,");
        ApiCacheColumn apiCacheColumn2 = ApiCacheColumn.input;
        sb.append(apiCacheColumn2);
        sb.append(" TEXT ,");
        ApiCacheColumn apiCacheColumn3 = ApiCacheColumn.appVersion;
        sb.append(apiCacheColumn3);
        sb.append(" TEXT ,");
        sb.append(ApiCacheColumn.output);
        sb.append(" TEXT ,");
        sb.append(ApiCacheColumn.expiredTime);
        sb.append(" INTEGER , PRIMARY KEY ( ");
        sb.append(apiCacheColumn);
        sb.append(", ");
        sb.append(apiCacheColumn2);
        sb.append(", ");
        sb.append(apiCacheColumn3);
        sb.append(" ))");
        CREATE_TABLE_ApiCache = sb.toString();
    }

    public static CacheDatabaseHelper getInstance(int i) {
        CacheDatabaseHelper cacheDatabaseHelper = Instance[i];
        if (cacheDatabaseHelper == null) {
            synchronized (CacheDatabaseHelper.class) {
                cacheDatabaseHelper = Instance[i];
                if (cacheDatabaseHelper == null) {
                    CacheDatabaseHelper[] cacheDatabaseHelperArr = Instance;
                    CacheDatabaseHelper cacheDatabaseHelper2 = new CacheDatabaseHelper(i);
                    cacheDatabaseHelperArr[i] = cacheDatabaseHelper2;
                    cacheDatabaseHelper = cacheDatabaseHelper2;
                }
            }
        }
        return cacheDatabaseHelper;
    }

    public CacheDatabaseHelper(int i) {
        super(ApplicationLoader.applicationContext, getDatabaseName(i), (SQLiteDatabase.CursorFactory) null, 1);
        new BaseController(i);
    }

    public static String getDatabaseName(int i) {
        return DATABASE_NAME + "_" + i;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        String str = CREATE_TABLE_ApiCache;
        MyLog.e("CacheDatabaseHelper", str);
        sQLiteDatabase.execSQL(str);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) throws SQLException {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TableName.apiCacheTable);
        onCreate(sQLiteDatabase);
    }

    public void removeAll() {
        try {
            getWritableDatabase().execSQL("DELETE  FROM " + TableName.apiCacheTable);
        } catch (Exception e) {
            MyLog.handleException(e);
        }
    }

    public void addOrUpdateApiCache(ApiCacheObject apiCacheObject) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(apiCacheObject);
        addAllApiCache(arrayList);
    }

    public void addAllApiCache(Collection<ApiCacheObject> collection) throws SQLException {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransaction();
            for (ApiCacheObject apiCacheObject : collection) {
                writableDatabase.execSQL("INSERT  or Replace INTO " + TableName.apiCacheTable + "(" + ApiCacheColumn.methodName + "," + ApiCacheColumn.input + "," + ApiCacheColumn.appVersion + "," + ApiCacheColumn.output + "," + ApiCacheColumn.expiredTime + ") VALUES(?,?,?,?,'" + apiCacheObject.expiredTime + "')", new String[]{apiCacheObject.methodName, apiCacheObject.input, apiCacheObject.appVersion, apiCacheObject.output});
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
        } catch (Exception e) {
            removeAll();
            MyLog.handleException(e);
        }
    }

    public ApiCacheObject getApiCache(String str, String str2, String str3) {
        if (str != null && str2 != null && !str.equals(BuildConfig.FLAVOR)) {
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT  * FROM ");
            sb.append(TableName.apiCacheTable);
            sb.append(" WHERE ");
            ApiCacheColumn apiCacheColumn = ApiCacheColumn.methodName;
            sb.append(apiCacheColumn);
            sb.append(" = '");
            sb.append(str);
            sb.append("' AND ");
            ApiCacheColumn apiCacheColumn2 = ApiCacheColumn.input;
            sb.append(apiCacheColumn2);
            sb.append(" = '");
            sb.append(str2);
            sb.append("' AND ");
            ApiCacheColumn apiCacheColumn3 = ApiCacheColumn.appVersion;
            sb.append(apiCacheColumn3);
            sb.append(" = '");
            sb.append(str3);
            sb.append("'");
            String string = sb.toString();
            MyLog.e("CacheDatabaseHelper", string);
            Cursor cursorRawQuery = getReadableDatabase().rawQuery(string, null);
            if (cursorRawQuery.moveToFirst()) {
                ApiCacheObject apiCacheObject = new ApiCacheObject(cursorRawQuery.getString(cursorRawQuery.getColumnIndex(apiCacheColumn + BuildConfig.FLAVOR)), cursorRawQuery.getString(cursorRawQuery.getColumnIndex(apiCacheColumn2 + BuildConfig.FLAVOR)), cursorRawQuery.getString(cursorRawQuery.getColumnIndex(apiCacheColumn3 + BuildConfig.FLAVOR)), cursorRawQuery.getString(cursorRawQuery.getColumnIndex(ApiCacheColumn.output + BuildConfig.FLAVOR)), Long.valueOf(cursorRawQuery.getLong(cursorRawQuery.getColumnIndex(ApiCacheColumn.expiredTime + BuildConfig.FLAVOR))));
                cursorRawQuery.close();
                return apiCacheObject;
            }
            cursorRawQuery.close();
        }
        return null;
    }
}
