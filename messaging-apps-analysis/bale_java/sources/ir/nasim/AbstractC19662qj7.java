package ir.nasim;

import android.content.Context;
import android.content.pm.Signature;
import android.os.Build;
import android.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: ir.nasim.qj7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC19662qj7 {
    public static boolean a(Context context) {
        boolean z = !c(context);
        boolean zE = e();
        boolean zD = d(context);
        if (AbstractC21784u76.b()) {
            return false;
        }
        return !z || zE || zD;
    }

    private static String b(String str) throws ClassNotFoundException {
        Class<?> cls = Class.forName("android.os.SystemProperties");
        return (String) cls.getMethod("get", String.class).invoke(cls, str);
    }

    public static boolean c(Context context) throws NoSuchAlgorithmException {
        if (!AbstractC21784u76.d() || AbstractC21784u76.a()) {
            return false;
        }
        try {
            for (Signature signature : context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures) {
                byte[] byteArray = signature.toByteArray();
                MessageDigest messageDigest = MessageDigest.getInstance("SHA");
                messageDigest.update(byteArray);
                if ("f3r+DpgBgPku7zibAY3thpdMcxw=\n".equals(Base64.encodeToString(messageDigest.digest(), 0))) {
                    return false;
                }
            }
        } catch (Exception unused) {
        }
        return true;
    }

    public static boolean d(Context context) {
        return AbstractC21784u76.d() && (context.getApplicationInfo().flags & 2) != 0;
    }

    public static boolean e() {
        boolean zContains;
        if (!AbstractC21784u76.d()) {
            return false;
        }
        try {
            zContains = b("ro.hardware").contains("goldfish");
        } catch (Exception unused) {
        }
        return Build.BRAND.equals("generic") || b("ro.kernel.qemu").equals("1") || zContains || b("ro.product.model").equals("sdk");
    }
}
