package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzec extends zzf {
    private final zzeb zza;
    private boolean zzb;

    zzec(zzfl zzflVar) {
        super(zzflVar);
        Context contextZzaw = this.zzx.zzaw();
        this.zzx.zzc();
        this.zza = new zzeb(this, contextZzaw, "google_app_measurement_local.db");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0116 A[PHI: r8
      0x0116: PHI (r8v3 android.database.sqlite.SQLiteDatabase) = (r8v2 android.database.sqlite.SQLiteDatabase), (r8v4 android.database.sqlite.SQLiteDatabase) binds: [B:55:0x00e6, B:70:0x0114] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0129  */
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
    private final boolean zzq(int r17, byte[] r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 318
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzec.zzq(int, byte[]):boolean");
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    protected final boolean zze() {
        return false;
    }

    public final void zzh() {
        int iDelete;
        zzg();
        try {
            SQLiteDatabase sQLiteDatabaseZzo = zzo();
            if (sQLiteDatabaseZzo == null || (iDelete = sQLiteDatabaseZzo.delete("messages", null, null)) <= 0) {
                return;
            }
            this.zzx.zzat().zzk().zzb("Reset local analytics data. records", Integer.valueOf(iDelete));
        } catch (SQLiteException e) {
            this.zzx.zzat().zzb().zzb("Error resetting local analytics data. error", e);
        }
    }

    public final boolean zzi(zzas zzasVar) {
        Parcel parcelObtain = Parcel.obtain();
        zzat.zza(zzasVar, parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        if (bArrMarshall.length <= 131072) {
            return zzq(0, bArrMarshall);
        }
        this.zzx.zzat().zzc().zza("Event is too long for local database. Sending event directly to service");
        return false;
    }

    public final boolean zzj(zzkg zzkgVar) {
        Parcel parcelObtain = Parcel.obtain();
        zzkh.zza(zzkgVar, parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        if (bArrMarshall.length <= 131072) {
            return zzq(1, bArrMarshall);
        }
        this.zzx.zzat().zzc().zza("User property too long for local database. Sending directly to service");
        return false;
    }

    public final boolean zzk(zzaa zzaaVar) {
        byte[] bArrZzX = this.zzx.zzl().zzX(zzaaVar);
        if (bArrZzX.length <= 131072) {
            return zzq(2, bArrZzX);
        }
        this.zzx.zzat().zzc().zza("Conditional user property too long for local database. Sending directly to service");
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:142:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x023a A[PHI: r9 r15
      0x023a: PHI (r9v3 int) = (r9v1 int), (r9v1 int), (r9v4 int) binds: [B:143:0x0228, B:158:0x0255, B:151:0x0238] A[DONT_GENERATE, DONT_INLINE]
      0x023a: PHI (r15v7 android.database.sqlite.SQLiteDatabase) = 
      (r15v5 android.database.sqlite.SQLiteDatabase)
      (r15v6 android.database.sqlite.SQLiteDatabase)
      (r15v8 android.database.sqlite.SQLiteDatabase)
     binds: [B:143:0x0228, B:158:0x0255, B:151:0x0238] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x020b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x01e6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0258 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0258 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0258 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable> zzl(int r24) {
        /*
            Method dump skipped, instructions count: 635
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzec.zzl(int):java.util.List");
    }

    public final boolean zzm() {
        return zzq(3, new byte[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0069 A[PHI: r4
      0x0069: PHI (r4v3 int) = (r4v1 int), (r4v1 int), (r4v4 int) binds: [B:29:0x0060, B:35:0x007c, B:32:0x0067] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzn() {
        /*
            r10 = this;
            java.lang.String r0 = "Error deleting app launch break from local database"
            r10.zzg()
            boolean r1 = r10.zzb
            r2 = 0
            if (r1 == 0) goto Lb
            return r2
        Lb:
            boolean r1 = r10.zzp()
            if (r1 == 0) goto L97
            r1 = 5
            r3 = 0
            r4 = 5
        L14:
            if (r3 >= r1) goto L88
            r5 = 0
            r6 = 1
            android.database.sqlite.SQLiteDatabase r5 = r10.zzo()     // Catch: java.lang.Throwable -> L3e android.database.sqlite.SQLiteException -> L40 android.database.sqlite.SQLiteFullException -> L42 android.database.sqlite.SQLiteDatabaseLockedException -> L61
            if (r5 != 0) goto L21
            r10.zzb = r6     // Catch: java.lang.Throwable -> L3e android.database.sqlite.SQLiteException -> L40 android.database.sqlite.SQLiteFullException -> L42 android.database.sqlite.SQLiteDatabaseLockedException -> L61
            return r2
        L21:
            r5.beginTransaction()     // Catch: java.lang.Throwable -> L3e android.database.sqlite.SQLiteException -> L40 android.database.sqlite.SQLiteFullException -> L42 android.database.sqlite.SQLiteDatabaseLockedException -> L61
            java.lang.String[] r7 = new java.lang.String[r6]     // Catch: java.lang.Throwable -> L3e android.database.sqlite.SQLiteException -> L40 android.database.sqlite.SQLiteFullException -> L42 android.database.sqlite.SQLiteDatabaseLockedException -> L61
            r8 = 3
            java.lang.String r8 = java.lang.Integer.toString(r8)     // Catch: java.lang.Throwable -> L3e android.database.sqlite.SQLiteException -> L40 android.database.sqlite.SQLiteFullException -> L42 android.database.sqlite.SQLiteDatabaseLockedException -> L61
            r7[r2] = r8     // Catch: java.lang.Throwable -> L3e android.database.sqlite.SQLiteException -> L40 android.database.sqlite.SQLiteFullException -> L42 android.database.sqlite.SQLiteDatabaseLockedException -> L61
            java.lang.String r8 = "messages"
            java.lang.String r9 = "type == ?"
            r5.delete(r8, r9, r7)     // Catch: java.lang.Throwable -> L3e android.database.sqlite.SQLiteException -> L40 android.database.sqlite.SQLiteFullException -> L42 android.database.sqlite.SQLiteDatabaseLockedException -> L61
            r5.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L3e android.database.sqlite.SQLiteException -> L40 android.database.sqlite.SQLiteFullException -> L42 android.database.sqlite.SQLiteDatabaseLockedException -> L61
            r5.endTransaction()     // Catch: java.lang.Throwable -> L3e android.database.sqlite.SQLiteException -> L40 android.database.sqlite.SQLiteFullException -> L42 android.database.sqlite.SQLiteDatabaseLockedException -> L61
            r5.close()
            return r6
        L3e:
            r0 = move-exception
            goto L82
        L40:
            r7 = move-exception
            goto L44
        L42:
            r7 = move-exception
            goto L6d
        L44:
            if (r5 == 0) goto L4f
            boolean r8 = r5.inTransaction()     // Catch: java.lang.Throwable -> L3e
            if (r8 == 0) goto L4f
            r5.endTransaction()     // Catch: java.lang.Throwable -> L3e
        L4f:
            com.google.android.gms.measurement.internal.zzfl r8 = r10.zzx     // Catch: java.lang.Throwable -> L3e
            com.google.android.gms.measurement.internal.zzei r8 = r8.zzat()     // Catch: java.lang.Throwable -> L3e
            com.google.android.gms.measurement.internal.zzeg r8 = r8.zzb()     // Catch: java.lang.Throwable -> L3e
            r8.zzb(r0, r7)     // Catch: java.lang.Throwable -> L3e
            r10.zzb = r6     // Catch: java.lang.Throwable -> L3e
            if (r5 == 0) goto L7f
            goto L69
        L61:
            long r6 = (long) r4     // Catch: java.lang.Throwable -> L3e
            android.os.SystemClock.sleep(r6)     // Catch: java.lang.Throwable -> L3e
            int r4 = r4 + 20
            if (r5 == 0) goto L7f
        L69:
            r5.close()
            goto L7f
        L6d:
            com.google.android.gms.measurement.internal.zzfl r8 = r10.zzx     // Catch: java.lang.Throwable -> L3e
            com.google.android.gms.measurement.internal.zzei r8 = r8.zzat()     // Catch: java.lang.Throwable -> L3e
            com.google.android.gms.measurement.internal.zzeg r8 = r8.zzb()     // Catch: java.lang.Throwable -> L3e
            r8.zzb(r0, r7)     // Catch: java.lang.Throwable -> L3e
            r10.zzb = r6     // Catch: java.lang.Throwable -> L3e
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
            com.google.android.gms.measurement.internal.zzfl r0 = r10.zzx
            com.google.android.gms.measurement.internal.zzei r0 = r0.zzat()
            com.google.android.gms.measurement.internal.zzeg r0 = r0.zze()
            java.lang.String r1 = "Error deleting app launch break from local database in reasonable time"
            r0.zza(r1)
        L97:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzec.zzn():boolean");
    }

    final SQLiteDatabase zzo() throws SQLiteException {
        if (this.zzb) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.zza.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.zzb = true;
        return null;
    }

    final boolean zzp() {
        Context contextZzaw = this.zzx.zzaw();
        this.zzx.zzc();
        return contextZzaw.getDatabasePath("google_app_measurement_local.db").exists();
    }
}
