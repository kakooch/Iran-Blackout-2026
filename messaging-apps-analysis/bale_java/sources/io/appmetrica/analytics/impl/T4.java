package io.appmetrica.analytics.impl;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import io.appmetrica.analytics.coreapi.internal.db.DatabaseScript;
import okhttp3.internal.connection.RealConnection;

/* loaded from: classes3.dex */
public final class T4 extends DatabaseScript {
    public final int a = 2000;
    public final String b = "number";
    public final String c = "global_number";
    public final String d = "number_of_type";
    public final String e = "name";
    public final String f = "value";
    public final String g = "type";
    public final String h = "time";
    public final String i = "session_id";
    public final String j = "error_environment";
    public final String k = "session_type";
    public final String l = "app_environment";
    public final String m = "app_environment_revision";
    public final String n = "truncated";
    public final String o = "custom_type";
    public final String p = "encrypting_mode";
    public final String q = "profile_id";
    public final String r = "first_occurrence_status";
    public final String s = "source";
    public final String t = "attribution_id_changed";
    public final String u = "open_id";
    public final String v = "extras";
    public final String w = "reports";
    public final C2486d7 x = new C2486d7(null, 1, 0 == true ? 1 : 0);

    public static boolean a(C2461c7 c2461c7) {
        Long l;
        Ta ta;
        Long l2;
        Long l3;
        Long l4;
        Integer num;
        Long l5 = c2461c7.a;
        return (l5 == null || l5.longValue() < RealConnection.IDLE_CONNECTION_HEALTHY_NS || c2461c7.b == null || (l = c2461c7.c) == null || l.longValue() < 0 || (ta = c2461c7.d) == null || ta == Ta.EVENT_TYPE_UNDEFINED || (l2 = c2461c7.e) == null || l2.longValue() < 0 || (l3 = c2461c7.f) == null || l3.longValue() < 0 || ((l4 = c2461c7.g.d) != null && l4.longValue() < 0) || ((num = c2461c7.g.i) != null && num.intValue() < 0)) ? false : true;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.db.DatabaseScript
    public final void runScript(SQLiteDatabase sQLiteDatabase) throws SQLException {
        Cursor cursorQuery;
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS events (id INTEGER PRIMARY KEY,session_id INTEGER,session_type INTEGER,number_in_session INTEGER,type INTEGER,global_number INTEGER,time INTEGER,event_description BLOB )");
        Cursor cursor = null;
        try {
            cursorQuery = sQLiteDatabase.query(this.w, null, null, null, null, null, null, String.valueOf(this.a));
            while (cursorQuery.moveToNext()) {
                try {
                    C2461c7 c2461c7A = a(cursorQuery);
                    if (c2461c7A != null && a(c2461c7A)) {
                        try {
                            sQLiteDatabase.insertOrThrow("events", null, this.x.fromModel(c2461c7A));
                        } catch (Throwable unused) {
                        }
                    }
                } catch (Throwable unused2) {
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursorQuery = cursor;
                        cursorQuery.close();
                    }
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + this.w);
                }
            }
        } catch (Throwable unused3) {
        }
        cursorQuery.close();
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + this.w);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(23:65|3|(1:5)(2:6|(2:8|5)(1:9))|10|(1:12)(3:13|(1:15)(2:16|(1:18)(1:19))|12)|20|(2:63|21)|(2:24|(1:26)(16:27|30|57|31|(1:33)(2:34|(0)(1:37))|61|40|(1:43)|44|59|45|48|(1:50)(1:51)|52|53|54))|23|57|31|(0)(0)|61|40|(0)|44|59|45|48|(0)(0)|52|53|54) */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0122, code lost:
    
        r27 = io.appmetrica.analytics.impl.EnumC2585h9.NATIVE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0141, code lost:
    
        r3 = -1;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0115 A[PHI: r4
      0x0115: PHI (r4v7 io.appmetrica.analytics.impl.h9) = (r4v5 io.appmetrica.analytics.impl.h9), (r4v6 io.appmetrica.analytics.impl.h9) binds: [B:32:0x0113, B:35:0x011a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0118 A[Catch: all -> 0x0120, TRY_LEAVE, TryCatch #0 {all -> 0x0120, blocks: (B:31:0x0107, B:34:0x0118), top: B:57:0x0107, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0151 A[Catch: all -> 0x016b, TryCatch #4 {all -> 0x016b, blocks: (B:3:0x0005, B:10:0x002a, B:20:0x00e0, B:44:0x0132, B:48:0x0142, B:52:0x0157, B:51:0x0151, B:38:0x0120, B:29:0x0103, B:13:0x00d4, B:16:0x00d9, B:6:0x0024, B:31:0x0107, B:34:0x0118, B:21:0x00ea, B:24:0x00fb, B:27:0x0100), top: B:65:0x0005, inners: #0, #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final io.appmetrica.analytics.impl.C2461c7 a(android.database.Cursor r32) {
        /*
            Method dump skipped, instructions count: 364
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.appmetrica.analytics.impl.T4.a(android.database.Cursor):io.appmetrica.analytics.impl.c7");
    }
}
