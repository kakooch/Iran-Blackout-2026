package ir.nasim;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.v86, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC22384v86 {
    public static boolean a(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursorRawQuery = sQLiteDatabase.rawQuery("select DISTINCT tbl_name from sqlite_master where tbl_name = '" + str + Separators.QUOTE, null);
        if (cursorRawQuery == null) {
            return false;
        }
        if (cursorRawQuery.getCount() > 0) {
            cursorRawQuery.close();
            return true;
        }
        cursorRawQuery.close();
        return false;
    }
}
