package io.appmetrica.analytics.impl;

import android.database.Cursor;
import io.appmetrica.analytics.coreapi.internal.db.DatabaseScript;

/* loaded from: classes3.dex */
public final class U4 extends DatabaseScript {
    public final String a = "sessions";
    public final int b = 200;
    public final String c = "id";
    public final String d = "start_time";
    public final String e = "report_request_parameters";
    public final String f = "server_time_offset";
    public final String g = "type";
    public final String h = "obtained_before_first_sync";
    public final C2821r7 i = new C2821r7(null, 1, 0 == true ? 1 : 0);

    public final C2798q7 a(Cursor cursor) {
        try {
            Long lValueOf = Long.valueOf(cursor.getLong(cursor.getColumnIndexOrThrow(this.c)));
            int i = cursor.getInt(cursor.getColumnIndexOrThrow(this.g));
            Wj wj = Wj.FOREGROUND;
            boolean z = true;
            if (i != 0) {
                wj = Wj.BACKGROUND;
                if (i != 1) {
                    wj = null;
                }
            }
            String string = cursor.getString(cursor.getColumnIndexOrThrow(this.e));
            Long lValueOf2 = Long.valueOf(cursor.getLong(cursor.getColumnIndexOrThrow(this.d)));
            Long lValueOf3 = Long.valueOf(cursor.getLong(cursor.getColumnIndexOrThrow(this.f)));
            if (cursor.getInt(cursor.getColumnIndexOrThrow(this.h)) != 1) {
                z = false;
            }
            return new C2798q7(lValueOf, wj, string, new C2774p7(lValueOf2, lValueOf3, Boolean.valueOf(z)));
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0082  */
    @Override // io.appmetrica.analytics.coreapi.internal.db.DatabaseScript
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void runScript(android.database.sqlite.SQLiteDatabase r12) throws android.database.SQLException {
        /*
            r11 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            java.lang.String r3 = r11.a     // Catch: java.lang.Throwable -> L5a
            int r2 = r11.b     // Catch: java.lang.Throwable -> L5a
            java.lang.String r10 = java.lang.String.valueOf(r2)     // Catch: java.lang.Throwable -> L5a
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r2 = r12
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L5a
        L19:
            boolean r3 = r2.moveToNext()     // Catch: java.lang.Throwable -> L5b
            if (r3 == 0) goto L5d
            io.appmetrica.analytics.impl.q7 r3 = r11.a(r2)     // Catch: java.lang.Throwable -> L5b
            if (r3 == 0) goto L19
            java.lang.Long r4 = r3.a     // Catch: java.lang.Throwable -> L5b
            if (r4 == 0) goto L19
            long r4 = r4.longValue()     // Catch: java.lang.Throwable -> L5b
            r6 = 0
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 < 0) goto L19
            io.appmetrica.analytics.impl.Wj r4 = r3.b     // Catch: java.lang.Throwable -> L5b
            if (r4 == 0) goto L19
            java.lang.String r4 = r3.c     // Catch: java.lang.Throwable -> L5b
            if (r4 == 0) goto L19
            int r4 = r4.length()     // Catch: java.lang.Throwable -> L5b
            if (r4 != 0) goto L42
            goto L19
        L42:
            io.appmetrica.analytics.impl.p7 r4 = r3.d     // Catch: java.lang.Throwable -> L5b
            java.lang.Long r4 = r4.a     // Catch: java.lang.Throwable -> L5b
            if (r4 == 0) goto L19
            long r4 = r4.longValue()     // Catch: java.lang.Throwable -> L5b
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 <= 0) goto L19
            io.appmetrica.analytics.impl.r7 r4 = r11.i     // Catch: java.lang.Throwable -> L5b
            android.content.ContentValues r3 = r4.fromModel(r3)     // Catch: java.lang.Throwable -> L5b
            r0.add(r3)     // Catch: java.lang.Throwable -> L5b
            goto L19
        L5a:
            r2 = r1
        L5b:
            if (r2 == 0) goto L60
        L5d:
            r2.close()
        L60:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "DROP TABLE IF EXISTS "
            r2.<init>(r3)
            java.lang.String r3 = r11.a
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r12.execSQL(r2)
            java.lang.String r2 = "CREATE TABLE IF NOT EXISTS sessions (id INTEGER,type INTEGER,report_request_parameters TEXT,session_description BLOB )"
            r12.execSQL(r2)
            java.util.Iterator r0 = r0.iterator()
        L7c:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L8e
            java.lang.Object r2 = r0.next()
            android.content.ContentValues r2 = (android.content.ContentValues) r2
            java.lang.String r3 = "sessions"
            r12.insertOrThrow(r3, r1, r2)     // Catch: java.lang.Throwable -> L7c
            goto L7c
        L8e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.appmetrica.analytics.impl.U4.runScript(android.database.sqlite.SQLiteDatabase):void");
    }
}
