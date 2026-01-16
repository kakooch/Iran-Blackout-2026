package com.google.android.gms.measurement.internal;

import android.database.sqlite.SQLiteDatabase;
import java.io.File;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzaj {
    static void zzb(zzei zzeiVar, SQLiteDatabase sQLiteDatabase) {
        if (zzeiVar == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        File file = new File(sQLiteDatabase.getPath());
        if (!file.setReadable(false, false)) {
            zzeiVar.zze().zza("Failed to turn off database read permission");
        }
        if (!file.setWritable(false, false)) {
            zzeiVar.zze().zza("Failed to turn off database write permission");
        }
        if (!file.setReadable(true, true)) {
            zzeiVar.zze().zza("Failed to turn on database read permission for owner");
        }
        if (file.setWritable(true, true)) {
            return;
        }
        zzeiVar.zze().zza("Failed to turn on database write permission for owner");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x007f A[Catch: SQLiteException -> 0x00ea, TryCatch #0 {SQLiteException -> 0x00ea, blocks: (B:20:0x0044, B:22:0x0070, B:24:0x007f, B:26:0x0087, B:27:0x008a, B:28:0x00b7, B:30:0x00ba, B:32:0x00bd, B:34:0x00c5, B:35:0x00cc, B:36:0x00cf, B:38:0x00d5, B:41:0x00e6, B:42:0x00e9, B:21:0x0069), top: B:54:0x0044, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ba A[Catch: SQLiteException -> 0x00ea, LOOP:1: B:30:0x00ba->B:35:0x00cc, LOOP_START, PHI: r13
      0x00ba: PHI (r13v1 int) = (r13v0 int), (r13v2 int) binds: [B:29:0x00b8, B:35:0x00cc] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {SQLiteException -> 0x00ea, blocks: (B:20:0x0044, B:22:0x0070, B:24:0x007f, B:26:0x0087, B:27:0x008a, B:28:0x00b7, B:30:0x00ba, B:32:0x00bd, B:34:0x00c5, B:35:0x00cc, B:36:0x00cf, B:38:0x00d5, B:41:0x00e6, B:42:0x00e9, B:21:0x0069), top: B:54:0x0044, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d5 A[Catch: SQLiteException -> 0x00ea, TryCatch #0 {SQLiteException -> 0x00ea, blocks: (B:20:0x0044, B:22:0x0070, B:24:0x007f, B:26:0x0087, B:27:0x008a, B:28:0x00b7, B:30:0x00ba, B:32:0x00bd, B:34:0x00c5, B:35:0x00cc, B:36:0x00cf, B:38:0x00d5, B:41:0x00e6, B:42:0x00e9, B:21:0x0069), top: B:54:0x0044, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static void zza(com.google.android.gms.measurement.internal.zzei r14, android.database.sqlite.SQLiteDatabase r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String[] r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 263
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaj.zza(com.google.android.gms.measurement.internal.zzei, android.database.sqlite.SQLiteDatabase, java.lang.String, java.lang.String, java.lang.String, java.lang.String[]):void");
    }
}
