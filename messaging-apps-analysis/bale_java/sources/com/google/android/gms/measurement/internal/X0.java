package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcel;

/* loaded from: classes3.dex */
public final class X0 extends AbstractC2311u1 {
    private final V0 c;
    private boolean d;

    X0(H1 h1) {
        super(h1);
        Context contextF = this.a.f();
        this.a.z();
        this.c = new V0(this, contextF, "google_app_measurement_local.db");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00f4 A[PHI: r8
      0x00f4: PHI (r8v3 android.database.sqlite.SQLiteDatabase) = (r8v2 android.database.sqlite.SQLiteDatabase), (r8v4 android.database.sqlite.SQLiteDatabase) binds: [B:60:0x00f2, B:76:0x0125] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0135  */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v10, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean x(int r17, byte[] r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 330
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.X0.x(int, byte[]):boolean");
    }

    @Override // com.google.android.gms.measurement.internal.AbstractC2311u1
    protected final boolean n() {
        return false;
    }

    final SQLiteDatabase o() {
        if (this.d) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.c.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.d = true;
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:145:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0248 A[PHI: r9 r15
      0x0248: PHI (r9v3 int) = (r9v1 int), (r9v1 int), (r9v4 int) binds: [B:146:0x0234, B:162:0x0263, B:155:0x0246] A[DONT_GENERATE, DONT_INLINE]
      0x0248: PHI (r15v7 android.database.sqlite.SQLiteDatabase) = 
      (r15v5 android.database.sqlite.SQLiteDatabase)
      (r15v6 android.database.sqlite.SQLiteDatabase)
      (r15v8 android.database.sqlite.SQLiteDatabase)
     binds: [B:146:0x0234, B:162:0x0263, B:155:0x0246] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0214 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:198:0x01fa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0266 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0266 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0266 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List p(int r23) {
        /*
            Method dump skipped, instructions count: 646
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.X0.p(int):java.util.List");
    }

    public final void q() {
        int iDelete;
        h();
        try {
            SQLiteDatabase sQLiteDatabaseO = o();
            if (sQLiteDatabaseO == null || (iDelete = sQLiteDatabaseO.delete("messages", null, null)) <= 0) {
                return;
            }
            this.a.b().v().b("Reset local analytics data. records", Integer.valueOf(iDelete));
        } catch (SQLiteException e) {
            this.a.b().r().b("Error resetting local analytics data. error", e);
        }
    }

    public final boolean r() {
        return x(3, new byte[0]);
    }

    final boolean s() {
        Context contextF = this.a.f();
        this.a.z();
        return contextF.getDatabasePath("google_app_measurement_local.db").exists();
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0069 A[PHI: r4
      0x0069: PHI (r4v4 int) = (r4v1 int), (r4v2 int), (r4v1 int) binds: [B:35:0x007c, B:32:0x0067, B:29:0x0060] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean t() {
        /*
            r10 = this;
            java.lang.String r0 = "Error deleting app launch break from local database"
            r10.h()
            boolean r1 = r10.d
            r2 = 0
            if (r1 == 0) goto Lb
            return r2
        Lb:
            boolean r1 = r10.s()
            if (r1 == 0) goto L97
            r1 = 5
            r4 = r1
            r3 = r2
        L14:
            if (r3 >= r1) goto L88
            r5 = 0
            r6 = 1
            android.database.sqlite.SQLiteDatabase r5 = r10.o()     // Catch: java.lang.Throwable -> L21 android.database.sqlite.SQLiteException -> L23 android.database.sqlite.SQLiteFullException -> L25 android.database.sqlite.SQLiteDatabaseLockedException -> L61
            if (r5 != 0) goto L27
            r10.d = r6     // Catch: java.lang.Throwable -> L21 android.database.sqlite.SQLiteException -> L23 android.database.sqlite.SQLiteFullException -> L25 android.database.sqlite.SQLiteDatabaseLockedException -> L61
            return r2
        L21:
            r0 = move-exception
            goto L82
        L23:
            r7 = move-exception
            goto L44
        L25:
            r7 = move-exception
            goto L6d
        L27:
            r5.beginTransaction()     // Catch: java.lang.Throwable -> L21 android.database.sqlite.SQLiteException -> L23 android.database.sqlite.SQLiteFullException -> L25 android.database.sqlite.SQLiteDatabaseLockedException -> L61
            r7 = 3
            java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch: java.lang.Throwable -> L21 android.database.sqlite.SQLiteException -> L23 android.database.sqlite.SQLiteFullException -> L25 android.database.sqlite.SQLiteDatabaseLockedException -> L61
            java.lang.String[] r7 = new java.lang.String[]{r7}     // Catch: java.lang.Throwable -> L21 android.database.sqlite.SQLiteException -> L23 android.database.sqlite.SQLiteFullException -> L25 android.database.sqlite.SQLiteDatabaseLockedException -> L61
            java.lang.String r8 = "messages"
            java.lang.String r9 = "type == ?"
            r5.delete(r8, r9, r7)     // Catch: java.lang.Throwable -> L21 android.database.sqlite.SQLiteException -> L23 android.database.sqlite.SQLiteFullException -> L25 android.database.sqlite.SQLiteDatabaseLockedException -> L61
            r5.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L21 android.database.sqlite.SQLiteException -> L23 android.database.sqlite.SQLiteFullException -> L25 android.database.sqlite.SQLiteDatabaseLockedException -> L61
            r5.endTransaction()     // Catch: java.lang.Throwable -> L21 android.database.sqlite.SQLiteException -> L23 android.database.sqlite.SQLiteFullException -> L25 android.database.sqlite.SQLiteDatabaseLockedException -> L61
            r5.close()
            return r6
        L44:
            if (r5 == 0) goto L4f
            boolean r8 = r5.inTransaction()     // Catch: java.lang.Throwable -> L21
            if (r8 == 0) goto L4f
            r5.endTransaction()     // Catch: java.lang.Throwable -> L21
        L4f:
            com.google.android.gms.measurement.internal.H1 r8 = r10.a     // Catch: java.lang.Throwable -> L21
            com.google.android.gms.measurement.internal.d1 r8 = r8.b()     // Catch: java.lang.Throwable -> L21
            com.google.android.gms.measurement.internal.b1 r8 = r8.r()     // Catch: java.lang.Throwable -> L21
            r8.b(r0, r7)     // Catch: java.lang.Throwable -> L21
            r10.d = r6     // Catch: java.lang.Throwable -> L21
            if (r5 == 0) goto L7f
            goto L69
        L61:
            long r6 = (long) r4     // Catch: java.lang.Throwable -> L21
            android.os.SystemClock.sleep(r6)     // Catch: java.lang.Throwable -> L21
            int r4 = r4 + 20
            if (r5 == 0) goto L7f
        L69:
            r5.close()
            goto L7f
        L6d:
            com.google.android.gms.measurement.internal.H1 r8 = r10.a     // Catch: java.lang.Throwable -> L21
            com.google.android.gms.measurement.internal.d1 r8 = r8.b()     // Catch: java.lang.Throwable -> L21
            com.google.android.gms.measurement.internal.b1 r8 = r8.r()     // Catch: java.lang.Throwable -> L21
            r8.b(r0, r7)     // Catch: java.lang.Throwable -> L21
            r10.d = r6     // Catch: java.lang.Throwable -> L21
            if (r5 == 0) goto L7f
            goto L69
        L7f:
            int r3 = r3 + 1
            goto L14
        L82:
            if (r5 == 0) goto L87
            r5.close()
        L87:
            throw r0
        L88:
            com.google.android.gms.measurement.internal.H1 r0 = r10.a
            com.google.android.gms.measurement.internal.d1 r0 = r0.b()
            com.google.android.gms.measurement.internal.b1 r0 = r0.w()
            java.lang.String r1 = "Error deleting app launch break from local database in reasonable time"
            r0.a(r1)
        L97:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.X0.t():boolean");
    }

    public final boolean u(zzac zzacVar) {
        byte[] bArrC0 = this.a.N().c0(zzacVar);
        if (bArrC0.length <= 131072) {
            return x(2, bArrC0);
        }
        this.a.b().t().a("Conditional user property too long for local database. Sending directly to service");
        return false;
    }

    public final boolean v(zzaw zzawVar) {
        Parcel parcelObtain = Parcel.obtain();
        C2304t.a(zzawVar, parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        if (bArrMarshall.length <= 131072) {
            return x(0, bArrMarshall);
        }
        this.a.b().t().a("Event is too long for local database. Sending event directly to service");
        return false;
    }

    public final boolean w(zzkw zzkwVar) {
        Parcel parcelObtain = Parcel.obtain();
        b4.a(zzkwVar, parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        if (bArrMarshall.length <= 131072) {
            return x(1, bArrMarshall);
        }
        this.a.b().t().a("User property too long for local database. Sending directly to service");
        return false;
    }
}
