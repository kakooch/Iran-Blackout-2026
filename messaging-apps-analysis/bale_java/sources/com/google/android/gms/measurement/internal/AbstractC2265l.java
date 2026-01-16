package com.google.android.gms.measurement.internal;

import android.database.sqlite.SQLiteDatabase;
import java.io.File;

/* renamed from: com.google.android.gms.measurement.internal.l, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC2265l {
    /* JADX WARN: Removed duplicated region for block: B:25:0x0074 A[Catch: SQLiteException -> 0x009e, TryCatch #5 {SQLiteException -> 0x009e, blocks: (B:21:0x0040, B:23:0x0066, B:25:0x0074, B:27:0x007c, B:28:0x007f, B:29:0x009d, B:33:0x00a2, B:35:0x00a5, B:37:0x00ad, B:38:0x00b4, B:39:0x00b7, B:41:0x00bd, B:44:0x00ce, B:45:0x00d1, B:22:0x005f), top: B:58:0x0040, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a2 A[Catch: SQLiteException -> 0x009e, LOOP:1: B:33:0x00a2->B:38:0x00b4, LOOP_START, PHI: r1
      0x00a2: PHI (r1v8 int) = (r1v7 int), (r1v9 int) binds: [B:32:0x00a0, B:38:0x00b4] A[DONT_GENERATE, DONT_INLINE], TryCatch #5 {SQLiteException -> 0x009e, blocks: (B:21:0x0040, B:23:0x0066, B:25:0x0074, B:27:0x007c, B:28:0x007f, B:29:0x009d, B:33:0x00a2, B:35:0x00a5, B:37:0x00ad, B:38:0x00b4, B:39:0x00b7, B:41:0x00bd, B:44:0x00ce, B:45:0x00d1, B:22:0x005f), top: B:58:0x0040, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00bd A[Catch: SQLiteException -> 0x009e, TryCatch #5 {SQLiteException -> 0x009e, blocks: (B:21:0x0040, B:23:0x0066, B:25:0x0074, B:27:0x007c, B:28:0x007f, B:29:0x009d, B:33:0x00a2, B:35:0x00a5, B:37:0x00ad, B:38:0x00b4, B:39:0x00b7, B:41:0x00bd, B:44:0x00ce, B:45:0x00d1, B:22:0x005f), top: B:58:0x0040, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static void a(com.google.android.gms.measurement.internal.C2227d1 r10, android.database.sqlite.SQLiteDatabase r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String[] r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 234
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.AbstractC2265l.a(com.google.android.gms.measurement.internal.d1, android.database.sqlite.SQLiteDatabase, java.lang.String, java.lang.String, java.lang.String, java.lang.String[]):void");
    }

    static void b(C2227d1 c2227d1, SQLiteDatabase sQLiteDatabase) {
        if (c2227d1 == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        File file = new File(sQLiteDatabase.getPath());
        if (!file.setReadable(false, false)) {
            c2227d1.w().a("Failed to turn off database read permission");
        }
        if (!file.setWritable(false, false)) {
            c2227d1.w().a("Failed to turn off database write permission");
        }
        if (!file.setReadable(true, true)) {
            c2227d1.w().a("Failed to turn on database read permission for owner");
        }
        if (file.setWritable(true, true)) {
            return;
        }
        c2227d1.w().a("Failed to turn on database write permission for owner");
    }
}
