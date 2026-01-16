package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.gov.nist.core.Separators;
import android.text.TextUtils;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.Os8;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.gms.measurement.internal.k, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C2260k extends O3 {
    private static final String[] f = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    private static final String[] g = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    private static final String[] h = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;", "e_tag", "ALTER TABLE apps ADD COLUMN e_tag TEXT;", "session_stitching_token", "ALTER TABLE apps ADD COLUMN session_stitching_token TEXT;"};
    private static final String[] i = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    private static final String[] j = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    private static final String[] k = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] l = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] m = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private final C2255j d;
    private final K3 e;

    C2260k(Y3 y3) {
        super(y3);
        this.e = new K3(this.a.c());
        this.a.z();
        this.d = new C2255j(this, this.a.f(), "google_app_measurement.db");
    }

    static final void H(ContentValues contentValues, String str, Object obj) {
        AbstractC3795Cj5.f("value");
        AbstractC3795Cj5.j(obj);
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

    private final long I(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor cursorRawQuery = P().rawQuery(str, strArr);
                if (!cursorRawQuery.moveToFirst()) {
                    throw new SQLiteException("Database returned empty set");
                }
                long j2 = cursorRawQuery.getLong(0);
                cursorRawQuery.close();
                return j2;
            } catch (SQLiteException e) {
                this.a.b().r().c("Database error", str, e);
                throw e;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    private final long K(String str, String[] strArr, long j2) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = P().rawQuery(str, strArr);
                if (!cursorRawQuery.moveToFirst()) {
                    cursorRawQuery.close();
                    return j2;
                }
                long j3 = cursorRawQuery.getLong(0);
                cursorRawQuery.close();
                return j3;
            } catch (SQLiteException e) {
                this.a.b().r().c("Database error", str, e);
                throw e;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0079: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:122), block:B:27:0x0079 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r4v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v9 */
    public final void G(String str, long j2, long j3, W3 w3) throws Throwable {
        ?? IsEmpty;
        Cursor cursor;
        SQLiteDatabase sQLiteDatabaseP;
        Cursor cursorRawQuery;
        String string;
        String str2;
        Cursor cursorQuery;
        String str3;
        String[] strArr;
        AbstractC3795Cj5.j(w3);
        h();
        i();
        Cursor cursor2 = null;
        string = null;
        string = null;
        String string2 = null;
        try {
            try {
                sQLiteDatabaseP = P();
                IsEmpty = TextUtils.isEmpty(null);
                try {
                    if (IsEmpty != 0) {
                        cursorRawQuery = sQLiteDatabaseP.rawQuery("select app_id, metadata_fingerprint from raw_events where " + (j3 != -1 ? "rowid <= ? and " : "") + "app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;", j3 != -1 ? new String[]{String.valueOf(j3), String.valueOf(j2)} : new String[]{String.valueOf(j2)});
                        if (!cursorRawQuery.moveToFirst()) {
                            cursorRawQuery.close();
                            return;
                        } else {
                            string2 = cursorRawQuery.getString(0);
                            string = cursorRawQuery.getString(1);
                            cursorRawQuery.close();
                        }
                    } else {
                        cursorRawQuery = sQLiteDatabaseP.rawQuery("select metadata_fingerprint from raw_events where app_id = ?" + (j3 != -1 ? " and rowid <= ?" : "") + " order by rowid limit 1;", j3 != -1 ? new String[]{null, String.valueOf(j3)} : new String[]{null});
                        if (!cursorRawQuery.moveToFirst()) {
                            cursorRawQuery.close();
                            return;
                        } else {
                            string = cursorRawQuery.getString(0);
                            cursorRawQuery.close();
                        }
                    }
                    Cursor cursor3 = cursorRawQuery;
                    str2 = string;
                    try {
                        cursorQuery = sQLiteDatabaseP.query("raw_events_metadata", new String[]{"metadata"}, "app_id = ? and metadata_fingerprint = ?", new String[]{string2, str2}, null, null, "rowid", "2");
                    } catch (SQLiteException e) {
                        e = e;
                        IsEmpty = cursor3;
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor3;
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor2 = cursor;
            }
            try {
                if (!cursorQuery.moveToFirst()) {
                    this.a.b().r().b("Raw event metadata record is missing. appId", C2227d1.z(string2));
                    cursorQuery.close();
                    return;
                }
                try {
                    com.google.android.gms.internal.measurement.U u = (com.google.android.gms.internal.measurement.U) ((com.google.android.gms.internal.measurement.T) a4.C(com.google.android.gms.internal.measurement.U.O1(), cursorQuery.getBlob(0))).m();
                    if (cursorQuery.moveToNext()) {
                        this.a.b().w().b("Get multiple raw event metadata records, expected one. appId", C2227d1.z(string2));
                    }
                    cursorQuery.close();
                    AbstractC3795Cj5.j(u);
                    w3.a = u;
                    if (j3 != -1) {
                        str3 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?";
                        strArr = new String[]{string2, str2, String.valueOf(j3)};
                    } else {
                        str3 = "app_id = ? and metadata_fingerprint = ?";
                        strArr = new String[]{string2, str2};
                    }
                    Cursor cursorQuery2 = sQLiteDatabaseP.query("raw_events", new String[]{"rowid", "name", "timestamp", "data"}, str3, strArr, null, null, "rowid", null);
                    if (!cursorQuery2.moveToFirst()) {
                        this.a.b().w().b("Raw event data disappeared while in transaction. appId", C2227d1.z(string2));
                        cursorQuery2.close();
                        return;
                    }
                    do {
                        long j4 = cursorQuery2.getLong(0);
                        try {
                            com.google.android.gms.internal.measurement.I i2 = (com.google.android.gms.internal.measurement.I) a4.C(com.google.android.gms.internal.measurement.J.E(), cursorQuery2.getBlob(3));
                            i2.z(cursorQuery2.getString(1));
                            i2.D(cursorQuery2.getLong(2));
                            if (!w3.a(j4, (com.google.android.gms.internal.measurement.J) i2.m())) {
                                cursorQuery2.close();
                                return;
                            }
                        } catch (IOException e3) {
                            this.a.b().r().c("Data loss. Failed to merge raw event. appId", C2227d1.z(string2), e3);
                        }
                    } while (cursorQuery2.moveToNext());
                    cursorQuery2.close();
                } catch (IOException e4) {
                    this.a.b().r().c("Data loss. Failed to merge raw event metadata. appId", C2227d1.z(string2), e4);
                    cursorQuery.close();
                }
            } catch (SQLiteException e5) {
                e = e5;
                IsEmpty = cursorQuery;
                this.a.b().r().c("Data loss. Error selecting raw event. appId", C2227d1.z(string2), e);
                if (IsEmpty != 0) {
                    IsEmpty.close();
                }
            } catch (Throwable th3) {
                th = th3;
                cursor2 = cursorQuery;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e6) {
            e = e6;
            IsEmpty = 0;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public final int J(String str, String str2) {
        AbstractC3795Cj5.f(str);
        AbstractC3795Cj5.f(str2);
        h();
        i();
        try {
            return P().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            this.a.b().r().d("Error deleting conditional property", C2227d1.z(str), this.a.D().f(str2), e);
            return 0;
        }
    }

    protected final long L(String str, String str2) {
        SQLiteException e;
        long jK;
        ContentValues contentValues;
        AbstractC3795Cj5.f(str);
        AbstractC3795Cj5.f("first_open_count");
        h();
        i();
        SQLiteDatabase sQLiteDatabaseP = P();
        sQLiteDatabaseP.beginTransaction();
        try {
            try {
                jK = K("select first_open_count from app2 where app_id=?", new String[]{str}, -1L);
                if (jK == -1) {
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put(CommonUrlParts.APP_ID, str);
                    contentValues2.put("first_open_count", (Integer) 0);
                    contentValues2.put("previous_install_count", (Integer) 0);
                    if (sQLiteDatabaseP.insertWithOnConflict("app2", null, contentValues2, 5) == -1) {
                        this.a.b().r().c("Failed to insert column (got -1). appId", C2227d1.z(str), "first_open_count");
                        return -1L;
                    }
                    jK = 0;
                }
            } catch (SQLiteException e2) {
                e = e2;
                jK = 0;
            }
            try {
                contentValues = new ContentValues();
                contentValues.put(CommonUrlParts.APP_ID, str);
                contentValues.put("first_open_count", Long.valueOf(1 + jK));
            } catch (SQLiteException e3) {
                e = e3;
                this.a.b().r().d("Error inserting column. appId", C2227d1.z(str), "first_open_count", e);
                return jK;
            }
            if (sQLiteDatabaseP.update("app2", contentValues, "app_id = ?", new String[]{str}) == 0) {
                this.a.b().r().c("Failed to update column (got 0). appId", C2227d1.z(str), "first_open_count");
                return -1L;
            }
            sQLiteDatabaseP.setTransactionSuccessful();
            return jK;
        } finally {
            sQLiteDatabaseP.endTransaction();
        }
    }

    public final long M() {
        return K("select max(bundle_end_timestamp) from queue", null, 0L);
    }

    public final long N() {
        return K("select max(timestamp) from raw_events", null, 0L);
    }

    public final long O(String str) {
        AbstractC3795Cj5.f(str);
        return K("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    final SQLiteDatabase P() {
        h();
        try {
            return this.d.getWritableDatabase();
        } catch (SQLiteException e) {
            this.a.b().w().b("Error opening database", e);
            throw e;
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x00bf: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]) (LINE:192), block:B:38:0x00bf */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.os.Bundle Q(java.lang.String r8) throws java.lang.Throwable {
        /*
            r7 = this;
            r7.h()
            r7.i()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r7.P()     // Catch: java.lang.Throwable -> Lc1 android.database.sqlite.SQLiteException -> Lc3
            java.lang.String[] r2 = new java.lang.String[]{r8}     // Catch: java.lang.Throwable -> Lc1 android.database.sqlite.SQLiteException -> Lc3
            java.lang.String r3 = "select parameters from default_event_params where app_id=?"
            android.database.Cursor r1 = r1.rawQuery(r3, r2)     // Catch: java.lang.Throwable -> Lc1 android.database.sqlite.SQLiteException -> Lc3
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            if (r2 != 0) goto L34
            com.google.android.gms.measurement.internal.H1 r8 = r7.a     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            com.google.android.gms.measurement.internal.d1 r8 = r8.b()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            com.google.android.gms.measurement.internal.b1 r8 = r8.v()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            java.lang.String r2 = "Default event parameters not found"
            r8.a(r2)     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            r1.close()
            return r0
        L2e:
            r8 = move-exception
            goto Lbf
        L31:
            r8 = move-exception
            goto Lc5
        L34:
            r2 = 0
            byte[] r2 = r1.getBlob(r2)     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            com.google.android.gms.internal.measurement.I r3 = com.google.android.gms.internal.measurement.J.E()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31 java.io.IOException -> La7
            ir.nasim.Pr8 r2 = com.google.android.gms.measurement.internal.a4.C(r3, r2)     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31 java.io.IOException -> La7
            com.google.android.gms.internal.measurement.I r2 = (com.google.android.gms.internal.measurement.I) r2     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31 java.io.IOException -> La7
            com.google.android.gms.internal.measurement.P0 r2 = r2.m()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31 java.io.IOException -> La7
            com.google.android.gms.internal.measurement.J r2 = (com.google.android.gms.internal.measurement.J) r2     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31 java.io.IOException -> La7
            com.google.android.gms.measurement.internal.Y3 r8 = r7.b     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            r8.g0()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            java.util.List r8 = r2.I()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            android.os.Bundle r2 = new android.os.Bundle     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            r2.<init>()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            java.util.Iterator r8 = r8.iterator()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
        L5b:
            boolean r3 = r8.hasNext()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            if (r3 == 0) goto La3
            java.lang.Object r3 = r8.next()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            com.google.android.gms.internal.measurement.N r3 = (com.google.android.gms.internal.measurement.N) r3     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            java.lang.String r4 = r3.G()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            boolean r5 = r3.U()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            if (r5 == 0) goto L79
            double r5 = r3.A()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            r2.putDouble(r4, r5)     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            goto L5b
        L79:
            boolean r5 = r3.V()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            if (r5 == 0) goto L87
            float r3 = r3.B()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            r2.putFloat(r4, r3)     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            goto L5b
        L87:
            boolean r5 = r3.Y()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            if (r5 == 0) goto L95
            java.lang.String r3 = r3.H()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            r2.putString(r4, r3)     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            goto L5b
        L95:
            boolean r5 = r3.W()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            if (r5 == 0) goto L5b
            long r5 = r3.D()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            r2.putLong(r4, r5)     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            goto L5b
        La3:
            r1.close()
            return r2
        La7:
            r2 = move-exception
            com.google.android.gms.measurement.internal.H1 r3 = r7.a     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            com.google.android.gms.measurement.internal.d1 r3 = r3.b()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            com.google.android.gms.measurement.internal.b1 r3 = r3.r()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            java.lang.String r4 = "Failed to retrieve default event parameters. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.C2227d1.z(r8)     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            r3.c(r4, r8, r2)     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            r1.close()
            return r0
        Lbf:
            r0 = r1
            goto Lda
        Lc1:
            r8 = move-exception
            goto Lda
        Lc3:
            r8 = move-exception
            r1 = r0
        Lc5:
            com.google.android.gms.measurement.internal.H1 r2 = r7.a     // Catch: java.lang.Throwable -> L2e
            com.google.android.gms.measurement.internal.d1 r2 = r2.b()     // Catch: java.lang.Throwable -> L2e
            com.google.android.gms.measurement.internal.b1 r2 = r2.r()     // Catch: java.lang.Throwable -> L2e
            java.lang.String r3 = "Error selecting default event parameters"
            r2.b(r3, r8)     // Catch: java.lang.Throwable -> L2e
            if (r1 == 0) goto Ld9
            r1.close()
        Ld9:
            return r0
        Lda:
            if (r0 == 0) goto Ldf
            r0.close()
        Ldf:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C2260k.Q(java.lang.String):android.os.Bundle");
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x01de: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:479), block:B:44:0x01de */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.C2263k2 R(java.lang.String r35) {
        /*
            Method dump skipped, instructions count: 515
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C2260k.R(java.lang.String):com.google.android.gms.measurement.internal.k2");
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0126  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzac S(java.lang.String r27, java.lang.String r28) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C2260k.S(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzac");
    }

    public final C2250i T(long j2, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        return U(j2, str, 1L, false, false, z3, false, z5);
    }

    public final C2250i U(long j2, String str, long j3, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        AbstractC3795Cj5.f(str);
        h();
        i();
        String[] strArr = {str};
        C2250i c2250i = new C2250i();
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseP = P();
                Cursor cursorQuery = sQLiteDatabaseP.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count"}, "app_id=?", new String[]{str}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    this.a.b().w().b("Not updating daily counts, app is not known. appId", C2227d1.z(str));
                    cursorQuery.close();
                    return c2250i;
                }
                if (cursorQuery.getLong(0) == j2) {
                    c2250i.b = cursorQuery.getLong(1);
                    c2250i.a = cursorQuery.getLong(2);
                    c2250i.c = cursorQuery.getLong(3);
                    c2250i.d = cursorQuery.getLong(4);
                    c2250i.e = cursorQuery.getLong(5);
                }
                if (z) {
                    c2250i.b += j3;
                }
                if (z2) {
                    c2250i.a += j3;
                }
                if (z3) {
                    c2250i.c += j3;
                }
                if (z4) {
                    c2250i.d += j3;
                }
                if (z5) {
                    c2250i.e += j3;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("day", Long.valueOf(j2));
                contentValues.put("daily_public_events_count", Long.valueOf(c2250i.a));
                contentValues.put("daily_events_count", Long.valueOf(c2250i.b));
                contentValues.put("daily_conversions_count", Long.valueOf(c2250i.c));
                contentValues.put("daily_error_events_count", Long.valueOf(c2250i.d));
                contentValues.put("daily_realtime_events_count", Long.valueOf(c2250i.e));
                sQLiteDatabaseP.update("apps", contentValues, "app_id=?", strArr);
                cursorQuery.close();
                return c2250i;
            } catch (SQLiteException e) {
                this.a.b().r().c("Error updating daily counts. appId", C2227d1.z(str), e);
                if (0 != 0) {
                    cursor.close();
                }
                return c2250i;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0135  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.C2290q V(java.lang.String r30, java.lang.String r31) {
        /*
            Method dump skipped, instructions count: 313
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C2260k.V(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.q");
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0073: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]) (LINE:116), block:B:24:0x0073 */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.c4 X(java.lang.String r11, java.lang.String r12) {
        /*
            r10 = this;
            ir.nasim.AbstractC3795Cj5.f(r11)
            ir.nasim.AbstractC3795Cj5.f(r12)
            r10.h()
            r10.i()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r10.P()     // Catch: java.lang.Throwable -> L75 android.database.sqlite.SQLiteException -> L77
            java.lang.String r2 = "set_timestamp"
            java.lang.String r3 = "value"
            java.lang.String r4 = "origin"
            java.lang.String[] r3 = new java.lang.String[]{r2, r3, r4}     // Catch: java.lang.Throwable -> L75 android.database.sqlite.SQLiteException -> L77
            java.lang.String[] r5 = new java.lang.String[]{r11, r12}     // Catch: java.lang.Throwable -> L75 android.database.sqlite.SQLiteException -> L77
            java.lang.String r2 = "user_attributes"
            java.lang.String r4 = "app_id=? and name=?"
            r7 = 0
            r8 = 0
            r6 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L75 android.database.sqlite.SQLiteException -> L77
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            if (r2 != 0) goto L34
            r1.close()
            return r0
        L34:
            r2 = 0
            long r7 = r1.getLong(r2)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            r2 = 1
            java.lang.Object r9 = r10.Y(r1, r2)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            if (r9 != 0) goto L44
            r1.close()
            return r0
        L44:
            r2 = 2
            java.lang.String r5 = r1.getString(r2)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            com.google.android.gms.measurement.internal.c4 r2 = new com.google.android.gms.measurement.internal.c4     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            r3 = r2
            r4 = r11
            r6 = r12
            r3.<init>(r4, r5, r6, r7, r9)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            boolean r3 = r1.moveToNext()     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            if (r3 == 0) goto L6f
            com.google.android.gms.measurement.internal.H1 r3 = r10.a     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            com.google.android.gms.measurement.internal.d1 r3 = r3.b()     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            com.google.android.gms.measurement.internal.b1 r3 = r3.r()     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            java.lang.String r4 = "Got multiple records for user property, expected one. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.C2227d1.z(r11)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            r3.b(r4, r5)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            goto L6f
        L6b:
            r11 = move-exception
            goto L73
        L6d:
            r2 = move-exception
            goto L7a
        L6f:
            r1.close()
            return r2
        L73:
            r0 = r1
            goto L9d
        L75:
            r11 = move-exception
            goto L9d
        L77:
            r1 = move-exception
            r2 = r1
            r1 = r0
        L7a:
            com.google.android.gms.measurement.internal.H1 r3 = r10.a     // Catch: java.lang.Throwable -> L6b
            com.google.android.gms.measurement.internal.d1 r3 = r3.b()     // Catch: java.lang.Throwable -> L6b
            com.google.android.gms.measurement.internal.b1 r3 = r3.r()     // Catch: java.lang.Throwable -> L6b
            java.lang.String r4 = "Error querying user property. appId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.C2227d1.z(r11)     // Catch: java.lang.Throwable -> L6b
            com.google.android.gms.measurement.internal.H1 r5 = r10.a     // Catch: java.lang.Throwable -> L6b
            com.google.android.gms.measurement.internal.Y0 r5 = r5.D()     // Catch: java.lang.Throwable -> L6b
            java.lang.String r12 = r5.f(r12)     // Catch: java.lang.Throwable -> L6b
            r3.d(r4, r11, r12, r2)     // Catch: java.lang.Throwable -> L6b
            if (r1 == 0) goto L9c
            r1.close()
        L9c:
            return r0
        L9d:
            if (r0 == 0) goto La2
            r0.close()
        La2:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C2260k.X(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.c4");
    }

    final Object Y(Cursor cursor, int i2) {
        int type = cursor.getType(i2);
        if (type == 0) {
            this.a.b().r().a("Loaded invalid null value from database");
            return null;
        }
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i2));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i2));
        }
        if (type == 3) {
            return cursor.getString(i2);
        }
        if (type != 4) {
            this.a.b().r().b("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
            return null;
        }
        this.a.b().r().a("Loaded invalid blob type value, ignoring it");
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0042  */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String Z() throws java.lang.Throwable {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.P()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch: java.lang.Throwable -> L26 android.database.sqlite.SQLiteException -> L28
            boolean r2 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L1a android.database.sqlite.SQLiteException -> L1c
            if (r2 == 0) goto L1e
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch: java.lang.Throwable -> L1a android.database.sqlite.SQLiteException -> L1c
            r0.close()
            return r1
        L1a:
            r1 = move-exception
            goto L22
        L1c:
            r2 = move-exception
            goto L2b
        L1e:
            r0.close()
            return r1
        L22:
            r5 = r1
            r1 = r0
            r0 = r5
            goto L40
        L26:
            r0 = move-exception
            goto L40
        L28:
            r0 = move-exception
            r2 = r0
            r0 = r1
        L2b:
            com.google.android.gms.measurement.internal.H1 r3 = r6.a     // Catch: java.lang.Throwable -> L1a
            com.google.android.gms.measurement.internal.d1 r3 = r3.b()     // Catch: java.lang.Throwable -> L1a
            com.google.android.gms.measurement.internal.b1 r3 = r3.r()     // Catch: java.lang.Throwable -> L1a
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.b(r4, r2)     // Catch: java.lang.Throwable -> L1a
            if (r0 == 0) goto L3f
            r0.close()
        L3f:
            return r1
        L40:
            if (r1 == 0) goto L45
            r1.close()
        L45:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C2260k.Z():java.lang.String");
    }

    public final List a0(String str, String str2, String str3) {
        AbstractC3795Cj5.f(str);
        h();
        i();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat(Separators.STAR));
            sb.append(" and name glob ?");
        }
        return b0(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0058, code lost:
    
        r2 = r27.a.b().r();
        r27.a.z();
        r2.b("Read more than the max allowed conditional properties, ignoring extra", java.lang.Integer.valueOf(io.appmetrica.analytics.AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List b0(java.lang.String r28, java.lang.String[] r29) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C2260k.b0(java.lang.String, java.lang.String[]):java.util.List");
    }

    public final List c0(String str) {
        AbstractC3795Cj5.f(str);
        h();
        i();
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                this.a.z();
                cursorQuery = P().query("user_attributes", new String[]{"name", "origin", "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", "1000");
                if (!cursorQuery.moveToFirst()) {
                    cursorQuery.close();
                    return arrayList;
                }
                do {
                    String string = cursorQuery.getString(0);
                    String string2 = cursorQuery.getString(1);
                    if (string2 == null) {
                        string2 = "";
                    }
                    String str2 = string2;
                    long j2 = cursorQuery.getLong(2);
                    Object objY = Y(cursorQuery, 3);
                    if (objY == null) {
                        this.a.b().r().b("Read invalid user property value, ignoring it. appId", C2227d1.z(str));
                    } else {
                        arrayList.add(new c4(str, str2, string, j2, objY));
                    }
                } while (cursorQuery.moveToNext());
                cursorQuery.close();
                return arrayList;
            } catch (SQLiteException e) {
                this.a.b().r().c("Error querying user properties. appId", C2227d1.z(str), e);
                List listEmptyList = Collections.emptyList();
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

    /* JADX WARN: Code restructure failed: missing block: B:19:0x00a7, code lost:
    
        r0 = r17.a.b().r();
        r17.a.z();
        r0.b("Read more than the max allowed user properties, ignoring excess", java.lang.Integer.valueOf(io.appmetrica.analytics.AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT));
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0125  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List d0(java.lang.String r18, java.lang.String r19, java.lang.String r20) {
        /*
            Method dump skipped, instructions count: 303
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C2260k.d0(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    public final void e0() {
        i();
        P().beginTransaction();
    }

    public final void f0() {
        i();
        P().endTransaction();
    }

    final void g0(List list) throws SQLException {
        h();
        i();
        AbstractC3795Cj5.j(list);
        AbstractC3795Cj5.l(list.size());
        if (u()) {
            String str = Separators.LPAREN + TextUtils.join(",", list) + Separators.RPAREN;
            if (I("SELECT COUNT(1) FROM queue WHERE rowid IN " + str + " AND retry_count =  2147483647 LIMIT 1", null) > 0) {
                this.a.b().w().a("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                P().execSQL("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN " + str + " AND (retry_count IS NULL OR retry_count < 2147483647)");
            } catch (SQLiteException e) {
                this.a.b().r().b("Error incrementing retry count. error", e);
            }
        }
    }

    final void h0() {
        h();
        i();
        if (u()) {
            long jA = this.b.e0().e.a();
            long jElapsedRealtime = this.a.c().elapsedRealtime();
            long jAbs = Math.abs(jElapsedRealtime - jA);
            this.a.z();
            if (jAbs > ((Long) S0.z.a(null)).longValue()) {
                this.b.e0().e.b(jElapsedRealtime);
                h();
                i();
                if (u()) {
                    SQLiteDatabase sQLiteDatabaseP = P();
                    String strValueOf = String.valueOf(this.a.c().currentTimeMillis());
                    this.a.z();
                    int iDelete = sQLiteDatabaseP.delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{strValueOf, String.valueOf(C2240g.i())});
                    if (iDelete > 0) {
                        this.a.b().v().b("Deleted stale rows. rowsDeleted", Integer.valueOf(iDelete));
                    }
                }
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.O3
    protected final boolean l() {
        return false;
    }

    public final void m(String str, String str2) {
        AbstractC3795Cj5.f(str);
        AbstractC3795Cj5.f(str2);
        h();
        i();
        try {
            P().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            this.a.b().r().d("Error deleting user property. appId", C2227d1.z(str), this.a.D().f(str2), e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0337, code lost:
    
        r10.put("session_scoped", r0);
        r10.put("data", r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x034b, code lost:
    
        if (P().insertWithOnConflict("property_filters", null, r10, 5) != (-1)) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x034d, code lost:
    
        r23.a.b().r().b("Failed to insert property filter (got -1). appId", com.google.android.gms.measurement.internal.C2227d1.z(r24));
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0361, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0363, code lost:
    
        r0 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0367, code lost:
    
        r23.a.b().r().c("Error storing property filter. appId", com.google.android.gms.measurement.internal.C2227d1.z(r24), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x037a, code lost:
    
        i();
        h();
        ir.nasim.AbstractC3795Cj5.f(r24);
        r0 = P();
        r7 = r18;
        r0.delete("property_filters", r7, new java.lang.String[]{r24, java.lang.String.valueOf(r9)});
        r0.delete("event_filters", r7, new java.lang.String[]{r24, java.lang.String.valueOf(r9)});
        r18 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x03a3, code lost:
    
        r7 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x017b, code lost:
    
        r10 = r0.H().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0187, code lost:
    
        if (r10.hasNext() == false) goto L163;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0193, code lost:
    
        if (((com.google.android.gms.internal.measurement.C2130l) r10.next()).J() != false) goto L171;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0195, code lost:
    
        r23.a.b().w().c("Property filter with no ID. Audience definition ignored. appId, audienceId", com.google.android.gms.measurement.internal.C2227d1.z(r24), java.lang.Integer.valueOf(r9));
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x01ae, code lost:
    
        r10 = r0.G().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x01c4, code lost:
    
        if (r10.hasNext() == false) goto L172;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x01c6, code lost:
    
        r11 = (com.google.android.gms.internal.measurement.C2114e) r10.next();
        i();
        h();
        ir.nasim.AbstractC3795Cj5.f(r24);
        ir.nasim.AbstractC3795Cj5.j(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01e0, code lost:
    
        if (r11.G().isEmpty() == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01e2, code lost:
    
        r0 = r23.a.b().w();
        r10 = com.google.android.gms.measurement.internal.C2227d1.z(r24);
        r12 = java.lang.Integer.valueOf(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01fa, code lost:
    
        if (r11.O() == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x01fc, code lost:
    
        r16 = java.lang.Integer.valueOf(r11.B());
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0207, code lost:
    
        r16 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0209, code lost:
    
        r0.d("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", r10, r12, java.lang.String.valueOf(r16));
        r21 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0214, code lost:
    
        r3 = r11.g();
        r21 = r7;
        r7 = new android.content.ContentValues();
        r7.put(io.appmetrica.analytics.networktasks.internal.CommonUrlParts.APP_ID, r24);
        r7.put("audience_id", java.lang.Integer.valueOf(r9));
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x022d, code lost:
    
        if (r11.O() == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x022f, code lost:
    
        r8 = java.lang.Integer.valueOf(r11.B());
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0238, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0239, code lost:
    
        r7.put("filter_id", r8);
        r7.put("event_name", r11.G());
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0249, code lost:
    
        if (r11.P() == false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x024b, code lost:
    
        r8 = java.lang.Boolean.valueOf(r11.M());
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0254, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0255, code lost:
    
        r7.put("session_scoped", r8);
        r7.put("data", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0269, code lost:
    
        if (P().insertWithOnConflict("event_filters", null, r7, 5) != (-1)) goto L175;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x026b, code lost:
    
        r23.a.b().r().b("Failed to insert event filter (got -1). appId", com.google.android.gms.measurement.internal.C2227d1.z(r24));
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x027e, code lost:
    
        r7 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0284, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0285, code lost:
    
        r23.a.b().r().c("Error storing event filter. appId", com.google.android.gms.measurement.internal.C2227d1.z(r24), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x029a, code lost:
    
        r21 = r7;
        r0 = r0.H().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x02a8, code lost:
    
        if (r0.hasNext() == false) goto L177;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x02aa, code lost:
    
        r3 = (com.google.android.gms.internal.measurement.C2130l) r0.next();
        i();
        h();
        ir.nasim.AbstractC3795Cj5.f(r24);
        ir.nasim.AbstractC3795Cj5.j(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x02c4, code lost:
    
        if (r3.E().isEmpty() == false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x02c6, code lost:
    
        r0 = r23.a.b().w();
        r8 = com.google.android.gms.measurement.internal.C2227d1.z(r24);
        r10 = java.lang.Integer.valueOf(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x02de, code lost:
    
        if (r3.J() == false) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x02e0, code lost:
    
        r16 = java.lang.Integer.valueOf(r3.A());
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x02eb, code lost:
    
        r16 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x02ed, code lost:
    
        r0.d("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", r8, r10, java.lang.String.valueOf(r16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x02f6, code lost:
    
        r7 = r3.g();
        r10 = new android.content.ContentValues();
        r10.put(io.appmetrica.analytics.networktasks.internal.CommonUrlParts.APP_ID, r24);
        r10.put("audience_id", java.lang.Integer.valueOf(r9));
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x030d, code lost:
    
        if (r3.J() == false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x030f, code lost:
    
        r11 = java.lang.Integer.valueOf(r3.A());
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0318, code lost:
    
        r11 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0319, code lost:
    
        r10.put("filter_id", r11);
        r22 = r0;
        r10.put("property_name", r3.E());
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x032b, code lost:
    
        if (r3.K() == false) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x032d, code lost:
    
        r0 = java.lang.Boolean.valueOf(r3.I());
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0336, code lost:
    
        r0 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final void n(java.lang.String r24, java.util.List r25) {
        /*
            Method dump skipped, instructions count: 1160
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C2260k.n(java.lang.String, java.util.List):void");
    }

    public final void o() {
        i();
        P().setTransactionSuccessful();
    }

    public final void p(C2263k2 c2263k2) {
        AbstractC3795Cj5.j(c2263k2);
        h();
        i();
        String strD0 = c2263k2.d0();
        AbstractC3795Cj5.j(strD0);
        ContentValues contentValues = new ContentValues();
        contentValues.put(CommonUrlParts.APP_ID, strD0);
        contentValues.put("app_instance_id", c2263k2.e0());
        contentValues.put("gmp_app_id", c2263k2.i0());
        contentValues.put("resettable_device_id_hash", c2263k2.a());
        contentValues.put("last_bundle_index", Long.valueOf(c2263k2.Y()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(c2263k2.Z()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(c2263k2.X()));
        contentValues.put("app_version", c2263k2.g0());
        contentValues.put("app_store", c2263k2.f0());
        contentValues.put("gmp_version", Long.valueOf(c2263k2.W()));
        contentValues.put("dev_cert_hash", Long.valueOf(c2263k2.T()));
        contentValues.put("measurement_enabled", Boolean.valueOf(c2263k2.J()));
        contentValues.put("day", Long.valueOf(c2263k2.S()));
        contentValues.put("daily_public_events_count", Long.valueOf(c2263k2.Q()));
        contentValues.put("daily_events_count", Long.valueOf(c2263k2.P()));
        contentValues.put("daily_conversions_count", Long.valueOf(c2263k2.N()));
        contentValues.put("config_fetched_time", Long.valueOf(c2263k2.M()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(c2263k2.V()));
        contentValues.put("app_version_int", Long.valueOf(c2263k2.L()));
        contentValues.put("firebase_instance_id", c2263k2.h0());
        contentValues.put("daily_error_events_count", Long.valueOf(c2263k2.O()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(c2263k2.R()));
        contentValues.put("health_monitor_sample", c2263k2.j0());
        c2263k2.A();
        contentValues.put("android_id", (Long) 0L);
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(c2263k2.I()));
        contentValues.put("admob_app_id", c2263k2.b0());
        contentValues.put("dynamite_version", Long.valueOf(c2263k2.U()));
        contentValues.put("session_stitching_token", c2263k2.b());
        List listC = c2263k2.c();
        if (listC != null) {
            if (listC.isEmpty()) {
                this.a.b().w().b("Safelisted events should not be an empty list. appId", strD0);
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", listC));
            }
        }
        Os8.b();
        if (this.a.z().B(null, S0.k0) && !contentValues.containsKey("safelisted_events")) {
            contentValues.put("safelisted_events", (String) null);
        }
        try {
            SQLiteDatabase sQLiteDatabaseP = P();
            if (sQLiteDatabaseP.update("apps", contentValues, "app_id = ?", new String[]{strD0}) == 0 && sQLiteDatabaseP.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                this.a.b().r().b("Failed to insert/update app (got -1). appId", C2227d1.z(strD0));
            }
        } catch (SQLiteException e) {
            this.a.b().r().c("Error storing app. appId", C2227d1.z(strD0), e);
        }
    }

    public final void q(C2290q c2290q) {
        AbstractC3795Cj5.j(c2290q);
        h();
        i();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CommonUrlParts.APP_ID, c2290q.a);
        contentValues.put("name", c2290q.b);
        contentValues.put("lifetime_count", Long.valueOf(c2290q.c));
        contentValues.put("current_bundle_count", Long.valueOf(c2290q.d));
        contentValues.put("last_fire_timestamp", Long.valueOf(c2290q.f));
        contentValues.put("last_bundled_timestamp", Long.valueOf(c2290q.g));
        contentValues.put("last_bundled_day", c2290q.h);
        contentValues.put("last_sampled_complex_event_id", c2290q.i);
        contentValues.put("last_sampling_rate", c2290q.j);
        contentValues.put("current_session_count", Long.valueOf(c2290q.e));
        Boolean bool = c2290q.k;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : 1L);
        try {
            if (P().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                this.a.b().r().b("Failed to insert/update event aggregates (got -1). appId", C2227d1.z(c2290q.a));
            }
        } catch (SQLiteException e) {
            this.a.b().r().c("Error storing event aggregates. appId", C2227d1.z(c2290q.a), e);
        }
    }

    public final boolean r() {
        return I("select count(1) > 0 from raw_events", null) != 0;
    }

    public final boolean s() {
        return I("select count(1) > 0 from queue where has_realtime = 1", null) != 0;
    }

    public final boolean t() {
        return I("select count(1) > 0 from raw_events where realtime = 1", null) != 0;
    }

    protected final boolean u() {
        Context contextF = this.a.f();
        this.a.z();
        return contextF.getDatabasePath("google_app_measurement.db").exists();
    }

    public final boolean v(String str, Long l2, long j2, com.google.android.gms.internal.measurement.J j3) {
        h();
        i();
        AbstractC3795Cj5.j(j3);
        AbstractC3795Cj5.f(str);
        AbstractC3795Cj5.j(l2);
        byte[] bArrG = j3.g();
        this.a.b().v().c("Saving complex main event, appId, data size", this.a.D().d(str), Integer.valueOf(bArrG.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put(CommonUrlParts.APP_ID, str);
        contentValues.put("event_id", l2);
        contentValues.put("children_to_process", Long.valueOf(j2));
        contentValues.put("main_event", bArrG);
        try {
            if (P().insertWithOnConflict("main_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            this.a.b().r().b("Failed to insert complex main event (got -1). appId", C2227d1.z(str));
            return false;
        } catch (SQLiteException e) {
            this.a.b().r().c("Error storing complex main event. appId", C2227d1.z(str), e);
            return false;
        }
    }

    public final boolean w(zzac zzacVar) {
        AbstractC3795Cj5.j(zzacVar);
        h();
        i();
        String str = zzacVar.a;
        AbstractC3795Cj5.j(str);
        if (X(str, zzacVar.c.b) == null) {
            long jI = I("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{str});
            this.a.z();
            if (jI >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(CommonUrlParts.APP_ID, str);
        contentValues.put("origin", zzacVar.b);
        contentValues.put("name", zzacVar.c.b);
        H(contentValues, "value", AbstractC3795Cj5.j(zzacVar.c.P()));
        contentValues.put("active", Boolean.valueOf(zzacVar.e));
        contentValues.put("trigger_event_name", zzacVar.f);
        contentValues.put("trigger_timeout", Long.valueOf(zzacVar.h));
        contentValues.put("timed_out_event", this.a.N().c0(zzacVar.g));
        contentValues.put("creation_timestamp", Long.valueOf(zzacVar.d));
        contentValues.put("triggered_event", this.a.N().c0(zzacVar.i));
        contentValues.put("triggered_timestamp", Long.valueOf(zzacVar.c.c));
        contentValues.put("time_to_live", Long.valueOf(zzacVar.j));
        contentValues.put("expired_event", this.a.N().c0(zzacVar.k));
        try {
            if (P().insertWithOnConflict("conditional_properties", null, contentValues, 5) != -1) {
                return true;
            }
            this.a.b().r().b("Failed to insert/update conditional user property (got -1)", C2227d1.z(str));
            return true;
        } catch (SQLiteException e) {
            this.a.b().r().c("Error storing conditional user property", C2227d1.z(str), e);
            return true;
        }
    }

    public final boolean x(c4 c4Var) {
        AbstractC3795Cj5.j(c4Var);
        h();
        i();
        if (X(c4Var.a, c4Var.c) == null) {
            if (f4.X(c4Var.c)) {
                if (I("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{c4Var.a}) >= this.a.z().p(c4Var.a, S0.H, 25, 100)) {
                    return false;
                }
            } else if (!"_npa".equals(c4Var.c)) {
                long jI = I("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{c4Var.a, c4Var.b});
                this.a.z();
                if (jI >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(CommonUrlParts.APP_ID, c4Var.a);
        contentValues.put("origin", c4Var.b);
        contentValues.put("name", c4Var.c);
        contentValues.put("set_timestamp", Long.valueOf(c4Var.d));
        H(contentValues, "value", c4Var.e);
        try {
            if (P().insertWithOnConflict("user_attributes", null, contentValues, 5) != -1) {
                return true;
            }
            this.a.b().r().b("Failed to insert/update user property (got -1). appId", C2227d1.z(c4Var.a));
            return true;
        } catch (SQLiteException e) {
            this.a.b().r().c("Error storing user property. appId", C2227d1.z(c4Var.a), e);
            return true;
        }
    }
}
