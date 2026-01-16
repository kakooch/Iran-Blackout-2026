package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;
import ir.nasim.AbstractC3795Cj5;

/* loaded from: classes3.dex */
public class e {
    private static e c;
    private final Context a;
    private volatile String b;

    public e(Context context) {
        this.a = context.getApplicationContext();
    }

    public static e a(Context context) {
        AbstractC3795Cj5.j(context);
        synchronized (e.class) {
            try {
                if (c == null) {
                    r.d(context);
                    c = new e(context);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return c;
    }

    static final n d(PackageInfo packageInfo, n... nVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr != null) {
            if (signatureArr.length != 1) {
                Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
                return null;
            }
            o oVar = new o(packageInfo.signatures[0].toByteArray());
            for (int i = 0; i < nVarArr.length; i++) {
                if (nVarArr[i].equals(oVar)) {
                    return nVarArr[i];
                }
            }
        }
        return null;
    }

    public static final boolean e(PackageInfo packageInfo, boolean z) {
        PackageInfo packageInfo2;
        if (!z) {
            packageInfo2 = packageInfo;
        } else if (packageInfo != null) {
            if ("com.android.vending".equals(packageInfo.packageName) || "com.google.android.gms".equals(packageInfo.packageName)) {
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                z = (applicationInfo == null || (applicationInfo.flags & 129) == 0) ? false : true;
            }
            packageInfo2 = packageInfo;
        } else {
            packageInfo2 = null;
        }
        if (packageInfo != null && packageInfo2.signatures != null) {
            if ((z ? d(packageInfo2, q.a) : d(packageInfo2, q.a[0])) != null) {
                return true;
            }
        }
        return false;
    }

    private final w f(String str, boolean z, boolean z2) throws PackageManager.NameNotFoundException {
        w wVarC;
        ApplicationInfo applicationInfo;
        if (str == null) {
            return w.c("null pkg");
        }
        if (str.equals(this.b)) {
            return w.b();
        }
        if (r.e()) {
            wVarC = r.b(str, d.e(this.a), false, false);
        } else {
            try {
                PackageInfo packageInfo = this.a.getPackageManager().getPackageInfo(str, 64);
                boolean zE = d.e(this.a);
                if (packageInfo == null) {
                    wVarC = w.c("null pkg");
                } else {
                    Signature[] signatureArr = packageInfo.signatures;
                    if (signatureArr == null || signatureArr.length != 1) {
                        wVarC = w.c("single cert required");
                    } else {
                        o oVar = new o(packageInfo.signatures[0].toByteArray());
                        String str2 = packageInfo.packageName;
                        w wVarA = r.a(str2, oVar, zE, false);
                        wVarC = (!wVarA.a || (applicationInfo = packageInfo.applicationInfo) == null || (applicationInfo.flags & 2) == 0 || !r.a(str2, oVar, false, true).a) ? wVarA : w.c("debuggable release cert app rejected");
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                return w.d("no pkg ".concat(str), e);
            }
        }
        if (wVarC.a) {
            this.b = str;
        }
        return wVarC;
    }

    public boolean b(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (e(packageInfo, false)) {
            return true;
        }
        if (e(packageInfo, true)) {
            if (d.e(this.a)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    public boolean c(int i) throws PackageManager.NameNotFoundException {
        w wVarC;
        int length;
        String[] packagesForUid = this.a.getPackageManager().getPackagesForUid(i);
        if (packagesForUid != null && (length = packagesForUid.length) != 0) {
            wVarC = null;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    AbstractC3795Cj5.j(wVarC);
                    break;
                }
                wVarC = f(packagesForUid[i2], false, false);
                if (wVarC.a) {
                    break;
                }
                i2++;
            }
        } else {
            wVarC = w.c("no pkgs");
        }
        wVarC.e();
        return wVarC.a;
    }
}
