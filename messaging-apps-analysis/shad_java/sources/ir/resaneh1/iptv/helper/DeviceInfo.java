package ir.resaneh1.iptv.helper;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import io.github.inflationx.calligraphy3.BuildConfig;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/* loaded from: classes3.dex */
public class DeviceInfo {
    public static String getDeviceID(Context context) {
        return generateDeviceIdentifier(context);
    }

    public static String generateDeviceIdentifier(Context context) throws NoSuchAlgorithmException {
        String str = ("35" + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (Build.CPU_ABI.length() % 10) + (Build.DEVICE.length() % 10) + (Build.DISPLAY.length() % 10) + (Build.HOST.length() % 10) + (Build.ID.length() % 10) + (Build.MANUFACTURER.length() % 10) + (Build.MODEL.length() % 10) + (Build.PRODUCT.length() % 10) + (Build.TAGS.length() % 10) + (Build.TYPE.length() % 10) + (Build.USER.length() % 10)) + Settings.Secure.getString(context.getContentResolver(), "android_id");
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes(), 0, str.length());
            byte[] bArrDigest = messageDigest.digest();
            String str2 = BuildConfig.FLAVOR;
            for (byte b : bArrDigest) {
                int i = b & 255;
                if (i <= 15) {
                    str2 = str2 + "0";
                }
                str2 = str2 + Integer.toHexString(i);
            }
            return str2.toUpperCase();
        } catch (Exception unused) {
            return UUID.randomUUID().toString();
        }
    }
}
