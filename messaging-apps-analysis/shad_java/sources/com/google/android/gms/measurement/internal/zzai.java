package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzmg;
import io.github.inflationx.calligraphy3.BuildConfig;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.rbmain.tgnet.ConnectionsManager;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes3.dex */
final class zzai extends zzjv {
    private static final String[] zzb = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    private static final String[] zzc = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    private static final String[] zzd = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;"};
    private static final String[] zze = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    private static final String[] zzf = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    private static final String[] zzg = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] zzh = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] zzi = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private final zzah zzj;
    private final zzjr zzk;

    zzai(zzkd zzkdVar) {
        super(zzkdVar);
        this.zzk = new zzjr(this.zzx.zzax());
        this.zzx.zzc();
        this.zzj = new zzah(this, this.zzx.zzaw(), "google_app_measurement.db");
    }

    static final void zzV(ContentValues contentValues, String str, Object obj) {
        Preconditions.checkNotEmpty("value");
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put("value", (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put("value", (Long) obj);
        } else {
            if (!(obj instanceof Double)) {
                throw new IllegalArgumentException("Invalid value type");
            }
            contentValues.put("value", (Double) obj);
        }
    }

    private final long zzZ(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor cursorRawQuery = zze().rawQuery(str, strArr);
                if (!cursorRawQuery.moveToFirst()) {
                    throw new SQLiteException("Database returned empty set");
                }
                long j = cursorRawQuery.getLong(0);
                cursorRawQuery.close();
                return j;
            } catch (SQLiteException e) {
                this.zzx.zzat().zzb().zzc("Database error", str, e);
                throw e;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    private final long zzaa(String str, String[] strArr, long j) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = zze().rawQuery(str, strArr);
                if (!cursorRawQuery.moveToFirst()) {
                    cursorRawQuery.close();
                    return j;
                }
                long j2 = cursorRawQuery.getLong(0);
                cursorRawQuery.close();
                return j2;
            } catch (SQLiteException e) {
                this.zzx.zzat().zzb().zzc("Database error", str, e);
                throw e;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    final Object zzA(Cursor cursor, int i) {
        int type = cursor.getType(i);
        if (type == 0) {
            this.zzx.zzat().zzb().zza("Loaded invalid null value from database");
            return null;
        }
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i));
        }
        if (type == 3) {
            return cursor.getString(i);
        }
        if (type != 4) {
            this.zzx.zzat().zzb().zzb("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
            return null;
        }
        this.zzx.zzat().zzb().zza("Loaded invalid blob type value, ignoring it");
        return null;
    }

    public final long zzB() {
        return zzaa("select max(bundle_end_timestamp) from queue", null, 0L);
    }

    protected final long zzC(String str, String str2) {
        long jZzaa;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty("first_open_count");
        zzg();
        zzX();
        SQLiteDatabase sQLiteDatabaseZze = zze();
        sQLiteDatabaseZze.beginTransaction();
        long j = 0;
        try {
            try {
                StringBuilder sb = new StringBuilder(48);
                sb.append("select ");
                sb.append("first_open_count");
                sb.append(" from app2 where app_id=?");
                jZzaa = zzaa(sb.toString(), new String[]{str}, -1L);
                if (jZzaa == -1) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("app_id", str);
                    contentValues.put("first_open_count", (Integer) 0);
                    contentValues.put("previous_install_count", (Integer) 0);
                    if (sQLiteDatabaseZze.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                        this.zzx.zzat().zzb().zzc("Failed to insert column (got -1). appId", zzei.zzl(str), "first_open_count");
                        return -1L;
                    }
                    jZzaa = 0;
                }
            } catch (SQLiteException e) {
                e = e;
            }
            try {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("app_id", str);
                contentValues2.put("first_open_count", Long.valueOf(1 + jZzaa));
                if (sQLiteDatabaseZze.update("app2", contentValues2, "app_id = ?", new String[]{str}) == 0) {
                    this.zzx.zzat().zzb().zzc("Failed to update column (got 0). appId", zzei.zzl(str), "first_open_count");
                    return -1L;
                }
                sQLiteDatabaseZze.setTransactionSuccessful();
                return jZzaa;
            } catch (SQLiteException e2) {
                e = e2;
                j = jZzaa;
                this.zzx.zzat().zzb().zzd("Error inserting column. appId", zzei.zzl(str), "first_open_count", e);
                sQLiteDatabaseZze.endTransaction();
                return j;
            }
        } finally {
            sQLiteDatabaseZze.endTransaction();
        }
    }

    public final long zzD() {
        return zzaa("select max(timestamp) from raw_events", null, 0L);
    }

    public final boolean zzE() {
        return zzZ("select count(1) > 0 from raw_events", null) != 0;
    }

    public final boolean zzF() {
        return zzZ("select count(1) > 0 from raw_events where realtime = 1", null) != 0;
    }

    public final long zzG(String str) {
        Preconditions.checkNotEmpty(str);
        return zzaa("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    public final boolean zzH(String str, Long l, long j, com.google.android.gms.internal.measurement.zzdb zzdbVar) {
        zzg();
        zzX();
        Preconditions.checkNotNull(zzdbVar);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l);
        byte[] bArrZzbp = zzdbVar.zzbp();
        this.zzx.zzat().zzk().zzc("Saving complex main event, appId, data size", this.zzx.zzm().zzc(str), Integer.valueOf(bArrZzbp.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l);
        contentValues.put("children_to_process", Long.valueOf(j));
        contentValues.put("main_event", bArrZzbp);
        try {
            if (zze().insertWithOnConflict("main_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            this.zzx.zzat().zzb().zzb("Failed to insert complex main event (got -1). appId", zzei.zzl(str));
            return false;
        } catch (SQLiteException e) {
            this.zzx.zzat().zzb().zzc("Error storing complex main event. appId", zzei.zzl(str), e);
            return false;
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x00d6: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:44:0x00d6 */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.os.Bundle zzI(java.lang.String r8) throws java.lang.Throwable {
        /*
            r7 = this;
            r7.zzg()
            r7.zzX()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r7.zze()     // Catch: java.lang.Throwable -> Lbc android.database.sqlite.SQLiteException -> Lbe
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> Lbc android.database.sqlite.SQLiteException -> Lbe
            r3 = 0
            r2[r3] = r8     // Catch: java.lang.Throwable -> Lbc android.database.sqlite.SQLiteException -> Lbe
            java.lang.String r4 = "select parameters from default_event_params where app_id=?"
            android.database.Cursor r1 = r1.rawQuery(r4, r2)     // Catch: java.lang.Throwable -> Lbc android.database.sqlite.SQLiteException -> Lbe
            boolean r2 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            if (r2 != 0) goto L30
            com.google.android.gms.measurement.internal.zzfl r8 = r7.zzx     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            com.google.android.gms.measurement.internal.zzei r8 = r8.zzat()     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            com.google.android.gms.measurement.internal.zzeg r8 = r8.zzk()     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            java.lang.String r2 = "Default event parameters not found"
            r8.zza(r2)     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            r1.close()
            return r0
        L30:
            byte[] r2 = r1.getBlob(r3)     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            com.google.android.gms.internal.measurement.zzda r3 = com.google.android.gms.internal.measurement.zzdb.zzk()     // Catch: java.io.IOException -> La2 android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            com.google.android.gms.internal.measurement.zziw r2 = com.google.android.gms.measurement.internal.zzkf.zzt(r3, r2)     // Catch: java.io.IOException -> La2 android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            com.google.android.gms.internal.measurement.zzda r2 = (com.google.android.gms.internal.measurement.zzda) r2     // Catch: java.io.IOException -> La2 android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            com.google.android.gms.internal.measurement.zzhs r2 = r2.zzaA()     // Catch: java.io.IOException -> La2 android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            com.google.android.gms.internal.measurement.zzdb r2 = (com.google.android.gms.internal.measurement.zzdb) r2     // Catch: java.io.IOException -> La2 android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            com.google.android.gms.measurement.internal.zzkd r8 = r7.zza     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            r8.zzn()     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            java.util.List r8 = r2.zza()     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            android.os.Bundle r2 = new android.os.Bundle     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            r2.<init>()     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            java.util.Iterator r8 = r8.iterator()     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
        L56:
            boolean r3 = r8.hasNext()     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            if (r3 == 0) goto L9e
            java.lang.Object r3 = r8.next()     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            com.google.android.gms.internal.measurement.zzdf r3 = (com.google.android.gms.internal.measurement.zzdf) r3     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            java.lang.String r4 = r3.zzb()     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            boolean r5 = r3.zzi()     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            if (r5 == 0) goto L74
            double r5 = r3.zzj()     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            r2.putDouble(r4, r5)     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            goto L56
        L74:
            boolean r5 = r3.zzg()     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            if (r5 == 0) goto L82
            float r3 = r3.zzh()     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            r2.putFloat(r4, r3)     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            goto L56
        L82:
            boolean r5 = r3.zzc()     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            if (r5 == 0) goto L90
            java.lang.String r3 = r3.zzd()     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            r2.putString(r4, r3)     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            goto L56
        L90:
            boolean r5 = r3.zze()     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            if (r5 == 0) goto L56
            long r5 = r3.zzf()     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            r2.putLong(r4, r5)     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            goto L56
        L9e:
            r1.close()
            return r2
        La2:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzfl r3 = r7.zzx     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            com.google.android.gms.measurement.internal.zzei r3 = r3.zzat()     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            com.google.android.gms.measurement.internal.zzeg r3 = r3.zzb()     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            java.lang.String r4 = "Failed to retrieve default event parameters. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzei.zzl(r8)     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            r3.zzc(r4, r8, r2)     // Catch: android.database.sqlite.SQLiteException -> Lba java.lang.Throwable -> Ld5
            r1.close()
            return r0
        Lba:
            r8 = move-exception
            goto Lc0
        Lbc:
            r8 = move-exception
            goto Ld7
        Lbe:
            r8 = move-exception
            r1 = r0
        Lc0:
            com.google.android.gms.measurement.internal.zzfl r2 = r7.zzx     // Catch: java.lang.Throwable -> Ld5
            com.google.android.gms.measurement.internal.zzei r2 = r2.zzat()     // Catch: java.lang.Throwable -> Ld5
            com.google.android.gms.measurement.internal.zzeg r2 = r2.zzb()     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r3 = "Error selecting default event parameters"
            r2.zzb(r3, r8)     // Catch: java.lang.Throwable -> Ld5
            if (r1 == 0) goto Ld4
            r1.close()
        Ld4:
            return r0
        Ld5:
            r8 = move-exception
            r0 = r1
        Ld7:
            if (r0 == 0) goto Ldc
            r0.close()
        Ldc:
            goto Lde
        Ldd:
            throw r8
        Lde:
            goto Ldd
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzai.zzI(java.lang.String):android.os.Bundle");
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0343, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0344, code lost:
    
        r11.put("session_scoped", r0);
        r11.put("data", r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0358, code lost:
    
        if (zze().insertWithOnConflict("property_filters", null, r11, 5) != (-1)) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x035a, code lost:
    
        r23.zzx.zzat().zzb().zzb("Failed to insert property filter (got -1). appId", com.google.android.gms.measurement.internal.zzei.zzl(r24));
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x036e, code lost:
    
        r0 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0372, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0373, code lost:
    
        r23.zzx.zzat().zzb().zzc("Error storing property filter. appId", com.google.android.gms.measurement.internal.zzei.zzl(r24), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0386, code lost:
    
        zzX();
        zzg();
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24);
        r0 = zze();
        r3 = r17;
        r0.delete("property_filters", r3, new java.lang.String[]{r24, java.lang.String.valueOf(r10)});
        r0.delete("event_filters", r3, new java.lang.String[]{r24, java.lang.String.valueOf(r10)});
        r17 = r3;
        r4 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x03bd, code lost:
    
        r4 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x018b, code lost:
    
        r11 = r0.zzc().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0197, code lost:
    
        if (r11.hasNext() == false) goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x01a3, code lost:
    
        if (r11.next().zza() != false) goto L183;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x01a5, code lost:
    
        r23.zzx.zzat().zze().zzc("Property filter with no ID. Audience definition ignored. appId, audienceId", com.google.android.gms.measurement.internal.zzei.zzl(r24), java.lang.Integer.valueOf(r10));
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x01be, code lost:
    
        r11 = r0.zzf().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x01d4, code lost:
    
        if (r11.hasNext() == false) goto L184;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01d6, code lost:
    
        r12 = r11.next();
        zzX();
        zzg();
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24);
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01f0, code lost:
    
        if (android.text.TextUtils.isEmpty(r12.zzc()) == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01f2, code lost:
    
        r0 = r23.zzx.zzat().zze();
        r8 = com.google.android.gms.measurement.internal.zzei.zzl(r24);
        r11 = java.lang.Integer.valueOf(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x020a, code lost:
    
        if (r12.zza() == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x020c, code lost:
    
        r20 = java.lang.Integer.valueOf(r12.zzb());
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0217, code lost:
    
        r20 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0219, code lost:
    
        r0.zzd("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", r8, r11, java.lang.String.valueOf(r20));
        r21 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0224, code lost:
    
        r3 = r12.zzbp();
        r21 = r4;
        r4 = new android.content.ContentValues();
        r4.put("app_id", r24);
        r4.put("audience_id", java.lang.Integer.valueOf(r10));
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x023d, code lost:
    
        if (r12.zza() == false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x023f, code lost:
    
        r8 = java.lang.Integer.valueOf(r12.zzb());
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0248, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0249, code lost:
    
        r4.put("filter_id", r8);
        r4.put("event_name", r12.zzc());
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0259, code lost:
    
        if (r12.zzk() == false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x025b, code lost:
    
        r8 = java.lang.Boolean.valueOf(r12.zzm());
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0264, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0265, code lost:
    
        r4.put("session_scoped", r8);
        r4.put("data", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0279, code lost:
    
        if (zze().insertWithOnConflict("event_filters", null, r4, 5) != (-1)) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x027b, code lost:
    
        r23.zzx.zzat().zzb().zzb("Failed to insert event filter (got -1). appId", com.google.android.gms.measurement.internal.zzei.zzl(r24));
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x028e, code lost:
    
        r4 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0294, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0295, code lost:
    
        r23.zzx.zzat().zzb().zzc("Error storing event filter. appId", com.google.android.gms.measurement.internal.zzei.zzl(r24), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x02aa, code lost:
    
        r21 = r4;
        r0 = r0.zzc().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x02b8, code lost:
    
        if (r0.hasNext() == false) goto L172;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x02ba, code lost:
    
        r3 = r0.next();
        zzX();
        zzg();
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24);
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x02d4, code lost:
    
        if (android.text.TextUtils.isEmpty(r3.zzc()) == false) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x02d6, code lost:
    
        r0 = r23.zzx.zzat().zze();
        r7 = com.google.android.gms.measurement.internal.zzei.zzl(r24);
        r8 = java.lang.Integer.valueOf(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x02ee, code lost:
    
        if (r3.zza() == false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x02f0, code lost:
    
        r3 = java.lang.Integer.valueOf(r3.zzb());
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x02f9, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x02fa, code lost:
    
        r0.zzd("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", r7, r8, java.lang.String.valueOf(r3));
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0303, code lost:
    
        r4 = r3.zzbp();
        r11 = new android.content.ContentValues();
        r11.put("app_id", r24);
        r11.put("audience_id", java.lang.Integer.valueOf(r10));
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x031a, code lost:
    
        if (r3.zza() == false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x031c, code lost:
    
        r12 = java.lang.Integer.valueOf(r3.zzb());
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0325, code lost:
    
        r12 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0326, code lost:
    
        r11.put("filter_id", r12);
        r22 = r0;
        r11.put("property_name", r3.zzc());
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0338, code lost:
    
        if (r3.zzg() == false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x033a, code lost:
    
        r0 = java.lang.Boolean.valueOf(r3.zzh());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final void zzJ(java.lang.String r24, java.util.List<com.google.android.gms.internal.measurement.zzbu> r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1223
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzai.zzJ(java.lang.String, java.util.List):void");
    }

    protected final boolean zzK() {
        Context contextZzaw = this.zzx.zzaw();
        this.zzx.zzc();
        return contextZzaw.getDatabasePath("google_app_measurement.db").exists();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x023d: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:101:0x023d */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r4v3, types: [boolean] */
    public final void zzU(String str, long j, long j2, zzkc zzkcVar) throws Throwable {
        ?? IsEmpty;
        Cursor cursor;
        Cursor cursorRawQuery;
        String string;
        char c;
        String str2;
        String[] strArr;
        Preconditions.checkNotNull(zzkcVar);
        zzg();
        zzX();
        Cursor cursor2 = null;
        string = null;
        string = null;
        String string2 = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseZze = zze();
                IsEmpty = TextUtils.isEmpty(null);
                String str3 = BuildConfig.FLAVOR;
                try {
                    if (IsEmpty != 0) {
                        String[] strArr2 = j2 != -1 ? new String[]{String.valueOf(j2), String.valueOf(j)} : new String[]{String.valueOf(j)};
                        if (j2 != -1) {
                            str3 = "rowid <= ? and ";
                        }
                        StringBuilder sb = new StringBuilder(str3.length() + 148);
                        sb.append("select app_id, metadata_fingerprint from raw_events where ");
                        sb.append(str3);
                        sb.append("app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;");
                        cursorRawQuery = sQLiteDatabaseZze.rawQuery(sb.toString(), strArr2);
                        if (!cursorRawQuery.moveToFirst()) {
                            cursorRawQuery.close();
                            return;
                        } else {
                            string2 = cursorRawQuery.getString(0);
                            string = cursorRawQuery.getString(1);
                            cursorRawQuery.close();
                        }
                    } else {
                        String[] strArr3 = j2 != -1 ? new String[]{null, String.valueOf(j2)} : new String[]{null};
                        if (j2 != -1) {
                            str3 = " and rowid <= ?";
                        }
                        StringBuilder sb2 = new StringBuilder(str3.length() + 84);
                        sb2.append("select metadata_fingerprint from raw_events where app_id = ?");
                        sb2.append(str3);
                        sb2.append(" order by rowid limit 1;");
                        cursorRawQuery = sQLiteDatabaseZze.rawQuery(sb2.toString(), strArr3);
                        if (!cursorRawQuery.moveToFirst()) {
                            cursorRawQuery.close();
                            return;
                        } else {
                            string = cursorRawQuery.getString(0);
                            cursorRawQuery.close();
                        }
                    }
                    Cursor cursor3 = cursorRawQuery;
                    String str4 = string;
                    try {
                        Cursor cursorQuery = sQLiteDatabaseZze.query("raw_events_metadata", new String[]{"metadata"}, "app_id = ? and metadata_fingerprint = ?", new String[]{string2, str4}, null, null, "rowid", "2");
                        try {
                            if (!cursorQuery.moveToFirst()) {
                                this.zzx.zzat().zzb().zzb("Raw event metadata record is missing. appId", zzei.zzl(string2));
                                cursorQuery.close();
                                return;
                            }
                            try {
                                try {
                                    com.google.android.gms.internal.measurement.zzdj zzdjVarZzaA = ((com.google.android.gms.internal.measurement.zzdi) zzkf.zzt(com.google.android.gms.internal.measurement.zzdj.zzaj(), cursorQuery.getBlob(0))).zzaA();
                                    if (cursorQuery.moveToNext()) {
                                        this.zzx.zzat().zze().zzb("Get multiple raw event metadata records, expected one. appId", zzei.zzl(string2));
                                    }
                                    cursorQuery.close();
                                    Preconditions.checkNotNull(zzdjVarZzaA);
                                    zzkcVar.zza = zzdjVarZzaA;
                                    if (j2 != -1) {
                                        c = 1;
                                        str2 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?";
                                        strArr = new String[]{string2, str4, String.valueOf(j2)};
                                    } else {
                                        c = 1;
                                        str2 = "app_id = ? and metadata_fingerprint = ?";
                                        strArr = new String[]{string2, str4};
                                    }
                                    String[] strArr4 = new String[4];
                                    strArr4[0] = "rowid";
                                    strArr4[c] = "name";
                                    strArr4[2] = "timestamp";
                                    strArr4[3] = "data";
                                    Cursor cursorQuery2 = sQLiteDatabaseZze.query("raw_events", strArr4, str2, strArr, null, null, "rowid", null);
                                    if (!cursorQuery2.moveToFirst()) {
                                        this.zzx.zzat().zze().zzb("Raw event data disappeared while in transaction. appId", zzei.zzl(string2));
                                        cursorQuery2.close();
                                        return;
                                    }
                                    do {
                                        long j3 = cursorQuery2.getLong(0);
                                        try {
                                            com.google.android.gms.internal.measurement.zzda zzdaVar = (com.google.android.gms.internal.measurement.zzda) zzkf.zzt(com.google.android.gms.internal.measurement.zzdb.zzk(), cursorQuery2.getBlob(3));
                                            zzdaVar.zzl(cursorQuery2.getString(1));
                                            zzdaVar.zzo(cursorQuery2.getLong(2));
                                            if (!zzkcVar.zza(j3, zzdaVar.zzaA())) {
                                                cursorQuery2.close();
                                                return;
                                            }
                                        } catch (IOException e) {
                                            this.zzx.zzat().zzb().zzc("Data loss. Failed to merge raw event. appId", zzei.zzl(string2), e);
                                        }
                                    } while (cursorQuery2.moveToNext());
                                    cursorQuery2.close();
                                } catch (IOException e2) {
                                    this.zzx.zzat().zzb().zzc("Data loss. Failed to merge raw event metadata. appId", zzei.zzl(string2), e2);
                                    cursorQuery.close();
                                }
                            } catch (SQLiteException e3) {
                                e = e3;
                                IsEmpty = cursorQuery;
                                this.zzx.zzat().zzb().zzc("Data loss. Error selecting raw event. appId", zzei.zzl(string2), e);
                                if (IsEmpty != 0) {
                                    IsEmpty.close();
                                }
                            } catch (Throwable th) {
                                th = th;
                                cursor2 = cursorQuery;
                                if (cursor2 != null) {
                                    cursor2.close();
                                }
                                throw th;
                            }
                        } catch (SQLiteException e4) {
                            e = e4;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (SQLiteException e5) {
                        e = e5;
                        IsEmpty = cursor3;
                    } catch (Throwable th3) {
                        th = th3;
                        cursor2 = cursor3;
                    }
                } catch (SQLiteException e6) {
                    e = e6;
                }
            } catch (Throwable th4) {
                th = th4;
                cursor2 = cursor;
            }
        } catch (SQLiteException e7) {
            e = e7;
            IsEmpty = 0;
        } catch (Throwable th5) {
            th = th5;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzjv
    protected final boolean zzaz() {
        return false;
    }

    public final void zzb() {
        zzX();
        zze().beginTransaction();
    }

    public final void zzc() {
        zzX();
        zze().setTransactionSuccessful();
    }

    public final void zzd() {
        zzX();
        zze().endTransaction();
    }

    final SQLiteDatabase zze() {
        zzg();
        try {
            return this.zzj.getWritableDatabase();
        } catch (SQLiteException e) {
            this.zzx.zzat().zze().zzb("Error opening database", e);
            throw e;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x016e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzao zzf(java.lang.String r30, java.lang.String r31) {
        /*
            Method dump skipped, instructions count: 372
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzai.zzf(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzao");
    }

    public final void zzh(zzao zzaoVar) {
        Preconditions.checkNotNull(zzaoVar);
        zzg();
        zzX();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzaoVar.zza);
        contentValues.put("name", zzaoVar.zzb);
        contentValues.put("lifetime_count", Long.valueOf(zzaoVar.zzc));
        contentValues.put("current_bundle_count", Long.valueOf(zzaoVar.zzd));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzaoVar.zzf));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzaoVar.zzg));
        contentValues.put("last_bundled_day", zzaoVar.zzh);
        contentValues.put("last_sampled_complex_event_id", zzaoVar.zzi);
        contentValues.put("last_sampling_rate", zzaoVar.zzj);
        contentValues.put("current_session_count", Long.valueOf(zzaoVar.zze));
        Boolean bool = zzaoVar.zzk;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : 1L);
        try {
            if (zze().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                this.zzx.zzat().zzb().zzb("Failed to insert/update event aggregates (got -1). appId", zzei.zzl(zzaoVar.zza));
            }
        } catch (SQLiteException e) {
            this.zzx.zzat().zzb().zzc("Error storing event aggregates. appId", zzei.zzl(zzaoVar.zza), e);
        }
    }

    public final void zzi(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzX();
        try {
            zze().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            this.zzx.zzat().zzb().zzd("Error deleting user property. appId", zzei.zzl(str), this.zzx.zzm().zze(str2), e);
        }
    }

    public final boolean zzj(zzki zzkiVar) {
        Preconditions.checkNotNull(zzkiVar);
        zzg();
        zzX();
        if (zzk(zzkiVar.zza, zzkiVar.zzc) == null) {
            if (zzkk.zzh(zzkiVar.zzc)) {
                if (zzZ("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{zzkiVar.zza}) >= this.zzx.zzc().zzl(zzkiVar.zza, zzdw.zzF, 25, 100)) {
                    return false;
                }
            } else if (!"_npa".equals(zzkiVar.zzc)) {
                long jZzZ = zzZ("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{zzkiVar.zza, zzkiVar.zzb});
                this.zzx.zzc();
                if (jZzZ >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzkiVar.zza);
        contentValues.put("origin", zzkiVar.zzb);
        contentValues.put("name", zzkiVar.zzc);
        contentValues.put("set_timestamp", Long.valueOf(zzkiVar.zzd));
        zzV(contentValues, "value", zzkiVar.zze);
        try {
            if (zze().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                this.zzx.zzat().zzb().zzb("Failed to insert/update user property (got -1). appId", zzei.zzl(zzkiVar.zza));
            }
        } catch (SQLiteException e) {
            this.zzx.zzat().zzb().zzc("Error storing user property. appId", zzei.zzl(zzkiVar.zza), e);
        }
        return true;
    }

    /* JADX WARN: Not initialized variable reg: 11, insn: 0x00a8: MOVE (r10 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]), block:B:28:0x00a8 */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzki zzk(java.lang.String r20, java.lang.String r21) {
        /*
            r19 = this;
            r1 = r19
            r9 = r21
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r20)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r21)
            r19.zzg()
            r19.zzX()
            r10 = 0
            android.database.sqlite.SQLiteDatabase r11 = r19.zze()     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteException -> L82
            r0 = 3
            java.lang.String[] r13 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteException -> L82
            java.lang.String r0 = "set_timestamp"
            r2 = 0
            r13[r2] = r0     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteException -> L82
            java.lang.String r0 = "value"
            r3 = 1
            r13[r3] = r0     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteException -> L82
            java.lang.String r0 = "origin"
            r4 = 2
            r13[r4] = r0     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteException -> L82
            java.lang.String[] r15 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteException -> L82
            r15[r2] = r20     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteException -> L82
            r15[r3] = r9     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteException -> L82
            java.lang.String r12 = "user_attributes"
            java.lang.String r14 = "app_id=? and name=?"
            r16 = 0
            r17 = 0
            r18 = 0
            android.database.Cursor r11 = r11.query(r12, r13, r14, r15, r16, r17, r18)     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteException -> L82
            boolean r0 = r11.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L7e java.lang.Throwable -> La7
            if (r0 != 0) goto L45
            r11.close()
            return r10
        L45:
            long r6 = r11.getLong(r2)     // Catch: android.database.sqlite.SQLiteException -> L7e java.lang.Throwable -> La7
            java.lang.Object r8 = r1.zzA(r11, r3)     // Catch: android.database.sqlite.SQLiteException -> L7e java.lang.Throwable -> La7
            if (r8 != 0) goto L53
            r11.close()
            return r10
        L53:
            java.lang.String r4 = r11.getString(r4)     // Catch: android.database.sqlite.SQLiteException -> L7e java.lang.Throwable -> La7
            com.google.android.gms.measurement.internal.zzki r0 = new com.google.android.gms.measurement.internal.zzki     // Catch: android.database.sqlite.SQLiteException -> L7e java.lang.Throwable -> La7
            r2 = r0
            r3 = r20
            r5 = r21
            r2.<init>(r3, r4, r5, r6, r8)     // Catch: android.database.sqlite.SQLiteException -> L7e java.lang.Throwable -> La7
            boolean r2 = r11.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L7e java.lang.Throwable -> La7
            if (r2 == 0) goto L7a
            com.google.android.gms.measurement.internal.zzfl r2 = r1.zzx     // Catch: android.database.sqlite.SQLiteException -> L7e java.lang.Throwable -> La7
            com.google.android.gms.measurement.internal.zzei r2 = r2.zzat()     // Catch: android.database.sqlite.SQLiteException -> L7e java.lang.Throwable -> La7
            com.google.android.gms.measurement.internal.zzeg r2 = r2.zzb()     // Catch: android.database.sqlite.SQLiteException -> L7e java.lang.Throwable -> La7
            java.lang.String r3 = "Got multiple records for user property, expected one. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzei.zzl(r20)     // Catch: android.database.sqlite.SQLiteException -> L7e java.lang.Throwable -> La7
            r2.zzb(r3, r4)     // Catch: android.database.sqlite.SQLiteException -> L7e java.lang.Throwable -> La7
        L7a:
            r11.close()
            return r0
        L7e:
            r0 = move-exception
            goto L84
        L80:
            r0 = move-exception
            goto La9
        L82:
            r0 = move-exception
            r11 = r10
        L84:
            com.google.android.gms.measurement.internal.zzfl r2 = r1.zzx     // Catch: java.lang.Throwable -> La7
            com.google.android.gms.measurement.internal.zzei r2 = r2.zzat()     // Catch: java.lang.Throwable -> La7
            com.google.android.gms.measurement.internal.zzeg r2 = r2.zzb()     // Catch: java.lang.Throwable -> La7
            java.lang.String r3 = "Error querying user property. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzei.zzl(r20)     // Catch: java.lang.Throwable -> La7
            com.google.android.gms.measurement.internal.zzfl r5 = r1.zzx     // Catch: java.lang.Throwable -> La7
            com.google.android.gms.measurement.internal.zzed r5 = r5.zzm()     // Catch: java.lang.Throwable -> La7
            java.lang.String r5 = r5.zze(r9)     // Catch: java.lang.Throwable -> La7
            r2.zzd(r3, r4, r5, r0)     // Catch: java.lang.Throwable -> La7
            if (r11 == 0) goto La6
            r11.close()
        La6:
            return r10
        La7:
            r0 = move-exception
            r10 = r11
        La9:
            if (r10 == 0) goto Lae
            r10.close()
        Lae:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzai.zzk(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzki");
    }

    public final List<zzki> zzl(String str) {
        Preconditions.checkNotEmpty(str);
        zzg();
        zzX();
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                this.zzx.zzc();
                cursorQuery = zze().query("user_attributes", new String[]{"name", "origin", "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", "1000");
                if (!cursorQuery.moveToFirst()) {
                    cursorQuery.close();
                    return arrayList;
                }
                do {
                    String string = cursorQuery.getString(0);
                    String string2 = cursorQuery.getString(1);
                    if (string2 == null) {
                        string2 = BuildConfig.FLAVOR;
                    }
                    String str2 = string2;
                    long j = cursorQuery.getLong(2);
                    Object objZzA = zzA(cursorQuery, 3);
                    if (objZzA == null) {
                        this.zzx.zzat().zzb().zzb("Read invalid user property value, ignoring it. appId", zzei.zzl(str));
                    } else {
                        arrayList.add(new zzki(str, str2, string, j, objZzA));
                    }
                } while (cursorQuery.moveToNext());
                cursorQuery.close();
                return arrayList;
            } catch (SQLiteException e) {
                this.zzx.zzat().zzb().zzc("Error querying user properties. appId", zzei.zzl(str), e);
                List<zzki> listEmptyList = Collections.emptyList();
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return listEmptyList;
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x00ad, code lost:
    
        r3 = r19.zzx.zzat().zzb();
        r19.zzx.zzc();
        r3.zzb("Read more than the max allowed user properties, ignoring excess", java.lang.Integer.valueOf(com.facebook.stetho.websocket.CloseCodes.NORMAL_CLOSURE));
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x013a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.google.android.gms.measurement.internal.zzki> zzm(java.lang.String r20, java.lang.String r21, java.lang.String r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 320
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzai.zzm(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    public final boolean zzn(zzaa zzaaVar) {
        Preconditions.checkNotNull(zzaaVar);
        zzg();
        zzX();
        String str = zzaaVar.zza;
        Preconditions.checkNotNull(str);
        if (zzk(str, zzaaVar.zzc.zzb) == null) {
            long jZzZ = zzZ("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{str});
            this.zzx.zzc();
            if (jZzZ >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", zzaaVar.zzb);
        contentValues.put("name", zzaaVar.zzc.zzb);
        zzV(contentValues, "value", Preconditions.checkNotNull(zzaaVar.zzc.zza()));
        contentValues.put("active", Boolean.valueOf(zzaaVar.zze));
        contentValues.put("trigger_event_name", zzaaVar.zzf);
        contentValues.put("trigger_timeout", Long.valueOf(zzaaVar.zzh));
        contentValues.put("timed_out_event", this.zzx.zzl().zzX(zzaaVar.zzg));
        contentValues.put("creation_timestamp", Long.valueOf(zzaaVar.zzd));
        contentValues.put("triggered_event", this.zzx.zzl().zzX(zzaaVar.zzi));
        contentValues.put("triggered_timestamp", Long.valueOf(zzaaVar.zzc.zzc));
        contentValues.put("time_to_live", Long.valueOf(zzaaVar.zzj));
        contentValues.put("expired_event", this.zzx.zzl().zzX(zzaaVar.zzk));
        try {
            if (zze().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                this.zzx.zzat().zzb().zzb("Failed to insert/update conditional user property (got -1)", zzei.zzl(str));
            }
        } catch (SQLiteException e) {
            this.zzx.zzat().zzb().zzc("Error storing conditional user property", zzei.zzl(str), e);
        }
        return true;
    }

    /* JADX WARN: Not initialized variable reg: 10, insn: 0x0151: MOVE (r9 I:??[OBJECT, ARRAY]) = (r10 I:??[OBJECT, ARRAY]), block:B:28:0x0151 */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0154  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzaa zzo(java.lang.String r34, java.lang.String r35) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 344
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzai.zzo(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzaa");
    }

    public final int zzp(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzX();
        try {
            return zze().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            this.zzx.zzat().zzb().zzd("Error deleting conditional property", zzei.zzl(str), this.zzx.zzm().zze(str2), e);
            return 0;
        }
    }

    public final List<zzaa> zzq(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzg();
        zzX();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return zzr(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x008f, code lost:
    
        r3 = r41.zzx.zzat().zzb();
        r41.zzx.zzc();
        r3.zzb("Read more than the max allowed conditional properties, ignoring extra", java.lang.Integer.valueOf(com.facebook.stetho.websocket.CloseCodes.NORMAL_CLOSURE));
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x018c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.google.android.gms.measurement.internal.zzaa> zzr(java.lang.String r42, java.lang.String[] r43) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 402
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzai.zzr(java.lang.String, java.lang.String[]):java.util.List");
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0281: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:57:0x0281 */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0284  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzg zzs(java.lang.String r25) {
        /*
            Method dump skipped, instructions count: 648
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzai.zzs(java.lang.String):com.google.android.gms.measurement.internal.zzg");
    }

    public final void zzt(zzg zzgVar) {
        Preconditions.checkNotNull(zzgVar);
        zzg();
        zzX();
        String strZzc = zzgVar.zzc();
        Preconditions.checkNotNull(strZzc);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", strZzc);
        contentValues.put("app_instance_id", zzgVar.zzd());
        contentValues.put("gmp_app_id", zzgVar.zzf());
        contentValues.put("resettable_device_id_hash", zzgVar.zzl());
        contentValues.put("last_bundle_index", Long.valueOf(zzgVar.zzI()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzgVar.zzp()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzgVar.zzr()));
        contentValues.put("app_version", zzgVar.zzt());
        contentValues.put("app_store", zzgVar.zzx());
        contentValues.put("gmp_version", Long.valueOf(zzgVar.zzz()));
        contentValues.put("dev_cert_hash", Long.valueOf(zzgVar.zzB()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzgVar.zzF()));
        contentValues.put("day", Long.valueOf(zzgVar.zzO()));
        contentValues.put("daily_public_events_count", Long.valueOf(zzgVar.zzQ()));
        contentValues.put("daily_events_count", Long.valueOf(zzgVar.zzS()));
        contentValues.put("daily_conversions_count", Long.valueOf(zzgVar.zzU()));
        contentValues.put("config_fetched_time", Long.valueOf(zzgVar.zzJ()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzgVar.zzL()));
        contentValues.put("app_version_int", Long.valueOf(zzgVar.zzv()));
        contentValues.put("firebase_instance_id", zzgVar.zzn());
        contentValues.put("daily_error_events_count", Long.valueOf(zzgVar.zzY()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzgVar.zzW()));
        contentValues.put("health_monitor_sample", zzgVar.zzaa());
        contentValues.put("android_id", Long.valueOf(zzgVar.zzad()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(zzgVar.zzaf()));
        contentValues.put("admob_app_id", zzgVar.zzh());
        contentValues.put("dynamite_version", Long.valueOf(zzgVar.zzD()));
        List<String> listZzaj = zzgVar.zzaj();
        if (listZzaj != null) {
            if (listZzaj.size() == 0) {
                this.zzx.zzat().zze().zzb("Safelisted events should not be an empty list. appId", strZzc);
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", listZzaj));
            }
        }
        zzmg.zzb();
        if (this.zzx.zzc().zzn(strZzc, zzdw.zzah)) {
            contentValues.put("ga_app_id", zzgVar.zzj());
        }
        try {
            SQLiteDatabase sQLiteDatabaseZze = zze();
            if (sQLiteDatabaseZze.update("apps", contentValues, "app_id = ?", new String[]{strZzc}) == 0 && sQLiteDatabaseZze.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                this.zzx.zzat().zzb().zzb("Failed to insert/update app (got -1). appId", zzei.zzl(strZzc));
            }
        } catch (SQLiteException e) {
            this.zzx.zzat().zzb().zzc("Error storing app. appId", zzei.zzl(strZzc), e);
        }
    }

    public final zzag zzu(long j, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        return zzv(j, str, 1L, false, false, z3, false, z5);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0133  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzag zzv(long r23, java.lang.String r25, long r26, boolean r28, boolean r29, boolean r30, boolean r31, boolean r32) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 311
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzai.zzv(long, java.lang.String, long, boolean, boolean, boolean, boolean, boolean):com.google.android.gms.measurement.internal.zzag");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0040  */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String zzw() throws java.lang.Throwable {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.zze()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch: java.lang.Throwable -> L20 android.database.sqlite.SQLiteException -> L22
            boolean r2 = r0.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L1e java.lang.Throwable -> L3a
            if (r2 == 0) goto L1a
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch: android.database.sqlite.SQLiteException -> L1e java.lang.Throwable -> L3a
            r0.close()
            return r1
        L1a:
            r0.close()
            return r1
        L1e:
            r2 = move-exception
            goto L25
        L20:
            r0 = move-exception
            goto L3e
        L22:
            r0 = move-exception
            r2 = r0
            r0 = r1
        L25:
            com.google.android.gms.measurement.internal.zzfl r3 = r6.zzx     // Catch: java.lang.Throwable -> L3a
            com.google.android.gms.measurement.internal.zzei r3 = r3.zzat()     // Catch: java.lang.Throwable -> L3a
            com.google.android.gms.measurement.internal.zzeg r3 = r3.zzb()     // Catch: java.lang.Throwable -> L3a
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.zzb(r4, r2)     // Catch: java.lang.Throwable -> L3a
            if (r0 == 0) goto L39
            r0.close()
        L39:
            return r1
        L3a:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
        L3e:
            if (r1 == 0) goto L43
            r1.close()
        L43:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzai.zzw():java.lang.String");
    }

    public final boolean zzx() {
        return zzZ("select count(1) > 0 from queue where has_realtime = 1", null) != 0;
    }

    final void zzy() {
        zzg();
        zzX();
        if (zzK()) {
            long jZza = this.zzx.zzd().zzf.zza();
            long jElapsedRealtime = this.zzx.zzax().elapsedRealtime();
            long jAbs = Math.abs(jElapsedRealtime - jZza);
            this.zzx.zzc();
            if (jAbs > zzdw.zzx.zzb(null).longValue()) {
                this.zzx.zzd().zzf.zzb(jElapsedRealtime);
                zzg();
                zzX();
                if (zzK()) {
                    SQLiteDatabase sQLiteDatabaseZze = zze();
                    this.zzx.zzc();
                    int iDelete = sQLiteDatabaseZze.delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(this.zzx.zzax().currentTimeMillis()), String.valueOf(zzae.zzA())});
                    if (iDelete > 0) {
                        this.zzx.zzat().zzk().zzb("Deleted stale rows. rowsDeleted", Integer.valueOf(iDelete));
                    }
                }
            }
        }
    }

    final void zzz(List<Long> list) throws SQLException {
        zzg();
        zzX();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (zzK()) {
            String strJoin = TextUtils.join(",", list);
            StringBuilder sb = new StringBuilder(String.valueOf(strJoin).length() + 2);
            sb.append("(");
            sb.append(strJoin);
            sb.append(")");
            String string = sb.toString();
            StringBuilder sb2 = new StringBuilder(String.valueOf(string).length() + 80);
            sb2.append("SELECT COUNT(1) FROM queue WHERE rowid IN ");
            sb2.append(string);
            sb2.append(" AND retry_count =  2147483647 LIMIT 1");
            if (zzZ(sb2.toString(), null) > 0) {
                this.zzx.zzat().zze().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase sQLiteDatabaseZze = zze();
                StringBuilder sb3 = new StringBuilder(String.valueOf(string).length() + 127);
                sb3.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
                sb3.append(string);
                sb3.append(" AND (retry_count IS NULL OR retry_count < ");
                sb3.append(ConnectionsManager.DEFAULT_DATACENTER_ID);
                sb3.append(")");
                sQLiteDatabaseZze.execSQL(sb3.toString());
            } catch (SQLiteException e) {
                this.zzx.zzat().zzb().zzb("Error incrementing retry count. error", e);
            }
        }
    }
}
