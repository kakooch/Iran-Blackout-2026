package ir.nasim;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;

/* loaded from: classes2.dex */
public abstract class ES4 {

    private static class a {
        static Signature[] a(SigningInfo signingInfo) {
            return signingInfo.getApkContentsSigners();
        }

        static long b(PackageInfo packageInfo) {
            return packageInfo.getLongVersionCode();
        }

        static Signature[] c(SigningInfo signingInfo) {
            return signingInfo.getSigningCertificateHistory();
        }

        static boolean d(SigningInfo signingInfo) {
            return signingInfo.hasMultipleSigners();
        }

        static boolean e(PackageManager packageManager, String str, byte[] bArr, int i) {
            return packageManager.hasSigningCertificate(str, bArr, i);
        }
    }

    public static long a(PackageInfo packageInfo) {
        return Build.VERSION.SDK_INT >= 28 ? a.b(packageInfo) : packageInfo.versionCode;
    }
}
