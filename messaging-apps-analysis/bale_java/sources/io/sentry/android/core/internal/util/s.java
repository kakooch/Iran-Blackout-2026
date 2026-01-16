package io.sentry.android.core.internal.util;

import android.content.Context;
import android.content.pm.PackageManager;
import io.sentry.ILogger;
import io.sentry.Y2;
import io.sentry.android.core.Y;
import java.io.File;
import java.nio.charset.Charset;

/* loaded from: classes3.dex */
public final class s {
    private static final Charset g = Charset.forName("UTF-8");
    private final Context a;
    private final Y b;
    private final ILogger c;
    private final String[] d;
    private final String[] e;
    private final Runtime f;

    public s(Context context, Y y, ILogger iLogger) {
        this(context, y, iLogger, new String[]{"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su", "/su/bin", "/system/xbin/daemonsu"}, new String[]{"com.devadvance.rootcloak", "com.devadvance.rootcloakplus", "com.koushikdutta.superuser", "com.thirdparty.superuser", "eu.chainfire.supersu", "com.noshufou.android.su"}, Runtime.getRuntime());
    }

    private boolean a() {
        for (String str : this.d) {
            try {
            } catch (RuntimeException e) {
                this.c.a(Y2.ERROR, e, "Error when trying to check if root file %s exists.", str);
            }
            if (new File(str).exists()) {
                return true;
            }
        }
        return false;
    }

    private boolean b(ILogger iLogger) throws PackageManager.NameNotFoundException {
        Y y = new Y(iLogger);
        PackageManager packageManager = this.a.getPackageManager();
        if (packageManager != null) {
            for (String str : this.e) {
                try {
                    if (y.d() >= 33) {
                        packageManager.getPackageInfo(str, PackageManager.PackageInfoFlags.of(0L));
                        return true;
                    }
                    packageManager.getPackageInfo(str, 0);
                    return true;
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0047 A[DONT_GENERATE, PHI: r2
      0x0047: PHI (r2v3 java.lang.Process) = (r2v1 java.lang.Process), (r2v4 java.lang.Process) binds: [B:20:0x0045, B:25:0x0058] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean c() {
        /*
            r6 = this;
            java.lang.String r0 = "/system/xbin/which"
            java.lang.String r1 = "su"
            java.lang.String[] r0 = new java.lang.String[]{r0, r1}
            r1 = 0
            r2 = 0
            java.lang.Runtime r3 = r6.f     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L4d
            java.lang.Process r2 = r3.exec(r0)     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L4d
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L4d
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L4d
            java.io.InputStream r4 = r2.getInputStream()     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L4d
            java.nio.charset.Charset r5 = io.sentry.android.core.internal.util.s.g     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L4d
            r3.<init>(r4, r5)     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L4d
            r0.<init>(r3)     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L4d
            java.lang.String r3 = r0.readLine()     // Catch: java.lang.Throwable -> L32
            if (r3 == 0) goto L28
            r3 = 1
            goto L29
        L28:
            r3 = r1
        L29:
            r0.close()     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L4d
            r2.destroy()
            return r3
        L30:
            r0 = move-exception
            goto L3c
        L32:
            r3 = move-exception
            r0.close()     // Catch: java.lang.Throwable -> L37
            goto L3b
        L37:
            r0 = move-exception
            r3.addSuppressed(r0)     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L4d
        L3b:
            throw r3     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L4d
        L3c:
            io.sentry.ILogger r3 = r6.c     // Catch: java.lang.Throwable -> L4b
            io.sentry.Y2 r4 = io.sentry.Y2.DEBUG     // Catch: java.lang.Throwable -> L4b
            java.lang.String r5 = "Error when trying to check if SU exists."
            r3.b(r4, r5, r0)     // Catch: java.lang.Throwable -> L4b
            if (r2 == 0) goto L5b
        L47:
            r2.destroy()
            goto L5b
        L4b:
            r0 = move-exception
            goto L5c
        L4d:
            io.sentry.ILogger r0 = r6.c     // Catch: java.lang.Throwable -> L4b
            io.sentry.Y2 r3 = io.sentry.Y2.DEBUG     // Catch: java.lang.Throwable -> L4b
            java.lang.String r4 = "SU isn't found on this Device."
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L4b
            r0.c(r3, r4, r5)     // Catch: java.lang.Throwable -> L4b
            if (r2 == 0) goto L5b
            goto L47
        L5b:
            return r1
        L5c:
            if (r2 == 0) goto L61
            r2.destroy()
        L61:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.internal.util.s.c():boolean");
    }

    private boolean d() {
        String strA = this.b.a();
        return strA != null && strA.contains("test-keys");
    }

    public boolean e() {
        return d() || a() || c() || b(this.c);
    }

    s(Context context, Y y, ILogger iLogger, String[] strArr, String[] strArr2, Runtime runtime) {
        this.a = (Context) io.sentry.util.u.c(context, "The application context is required.");
        this.b = (Y) io.sentry.util.u.c(y, "The BuildInfoProvider is required.");
        this.c = (ILogger) io.sentry.util.u.c(iLogger, "The Logger is required.");
        this.d = (String[]) io.sentry.util.u.c(strArr, "The root Files are required.");
        this.e = (String[]) io.sentry.util.u.c(strArr2, "The root packages are required.");
        this.f = (Runtime) io.sentry.util.u.c(runtime, "The Runtime is required.");
    }
}
