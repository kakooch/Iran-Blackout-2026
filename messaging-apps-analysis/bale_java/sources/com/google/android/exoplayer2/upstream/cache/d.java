package com.google.android.exoplayer2.upstream.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.gov.nist.core.Separators;
import com.google.android.exoplayer2.database.DatabaseIOException;
import ir.nasim.AbstractC12345eS7;
import ir.nasim.AbstractC20011rK;
import ir.nasim.InterfaceC13995hA1;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
final class d {
    private static final String[] c = {"name", "length", "last_touch_timestamp"};
    private final InterfaceC13995hA1 a;
    private String b;

    public d(InterfaceC13995hA1 interfaceC13995hA1) {
        this.a = interfaceC13995hA1;
    }

    private static void a(SQLiteDatabase sQLiteDatabase, String str) throws SQLException {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
    }

    private Cursor c() {
        AbstractC20011rK.e(this.b);
        return this.a.F().query(this.b, c, null, null, null, null, null);
    }

    private static String d(String str) {
        return "ExoPlayerCacheFileMetadata" + str;
    }

    public Map b() throws DatabaseIOException {
        try {
            Cursor cursorC = c();
            try {
                HashMap map = new HashMap(cursorC.getCount());
                while (cursorC.moveToNext()) {
                    map.put((String) AbstractC20011rK.e(cursorC.getString(0)), new c(cursorC.getLong(1), cursorC.getLong(2)));
                }
                cursorC.close();
                return map;
            } finally {
            }
        } catch (SQLException e) {
            throw new DatabaseIOException(e);
        }
    }

    public void e(long j) throws DatabaseIOException {
        try {
            String hexString = Long.toHexString(j);
            this.b = d(hexString);
            if (AbstractC12345eS7.b(this.a.F(), 2, hexString) != 1) {
                SQLiteDatabase sQLiteDatabaseE = this.a.E();
                sQLiteDatabaseE.beginTransactionNonExclusive();
                try {
                    AbstractC12345eS7.d(sQLiteDatabaseE, 2, hexString, 1);
                    a(sQLiteDatabaseE, this.b);
                    sQLiteDatabaseE.execSQL("CREATE TABLE " + this.b + Separators.SP + "(name TEXT PRIMARY KEY NOT NULL,length INTEGER NOT NULL,last_touch_timestamp INTEGER NOT NULL)");
                    sQLiteDatabaseE.setTransactionSuccessful();
                    sQLiteDatabaseE.endTransaction();
                } catch (Throwable th) {
                    sQLiteDatabaseE.endTransaction();
                    throw th;
                }
            }
        } catch (SQLException e) {
            throw new DatabaseIOException(e);
        }
    }

    public void f(String str) throws DatabaseIOException {
        AbstractC20011rK.e(this.b);
        try {
            this.a.E().delete(this.b, "name = ?", new String[]{str});
        } catch (SQLException e) {
            throw new DatabaseIOException(e);
        }
    }

    public void g(Set set) throws DatabaseIOException {
        AbstractC20011rK.e(this.b);
        try {
            SQLiteDatabase sQLiteDatabaseE = this.a.E();
            sQLiteDatabaseE.beginTransactionNonExclusive();
            try {
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    sQLiteDatabaseE.delete(this.b, "name = ?", new String[]{(String) it.next()});
                }
                sQLiteDatabaseE.setTransactionSuccessful();
                sQLiteDatabaseE.endTransaction();
            } catch (Throwable th) {
                sQLiteDatabaseE.endTransaction();
                throw th;
            }
        } catch (SQLException e) {
            throw new DatabaseIOException(e);
        }
    }

    public void h(String str, long j, long j2) throws SQLException, DatabaseIOException {
        AbstractC20011rK.e(this.b);
        try {
            SQLiteDatabase sQLiteDatabaseE = this.a.E();
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", str);
            contentValues.put("length", Long.valueOf(j));
            contentValues.put("last_touch_timestamp", Long.valueOf(j2));
            sQLiteDatabaseE.replaceOrThrow(this.b, null, contentValues);
        } catch (SQLException e) {
            throw new DatabaseIOException(e);
        }
    }
}
