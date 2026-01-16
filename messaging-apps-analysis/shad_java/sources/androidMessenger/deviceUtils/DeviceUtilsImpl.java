package androidMessenger.deviceUtils;

import android.content.Context;
import android.os.Build;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.aaap.messengercore.CoreUtilities;
import ir.aaap.messengercore.DeviceUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import org.rbmain.messenger.ApplicationLoader;

/* loaded from: classes.dex */
public class DeviceUtilsImpl implements DeviceUtils {
    String deviceId;

    @Override // ir.aaap.messengercore.DeviceUtils
    public String getAppVersion() {
        Context context = ApplicationLoader.applicationContext;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return "0.0.0";
        }
    }

    @Override // ir.aaap.messengercore.DeviceUtils
    public String getDeviceModel() {
        String str;
        try {
            str = Build.MANUFACTURER + Build.MODEL;
        } catch (Exception unused) {
            str = null;
        }
        return CoreUtilities.isNotEmpty(str) ? str : "Android unknown";
    }

    @Override // ir.aaap.messengercore.DeviceUtils
    public String getSystemLangCode() {
        String language = Locale.getDefault().getLanguage();
        return CoreUtilities.isNotEmpty(language) ? language : "en";
    }

    @Override // ir.aaap.messengercore.DeviceUtils
    public String getSystemVersion() {
        return "SDK " + Build.VERSION.SDK_INT;
    }

    @Override // ir.aaap.messengercore.DeviceUtils
    public String generateDeviceIdentifier() throws NoSuchAlgorithmException {
        if (this.deviceId == null) {
            try {
                String str = Build.BOARD + " " + Build.BRAND + " " + Build.CPU_ABI + " " + Build.DEVICE + " " + Build.DISPLAY + " " + Build.MANUFACTURER + " " + Build.MODEL + " " + Build.PRODUCT + " ";
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
                this.deviceId = str2.toUpperCase();
            } catch (Exception unused) {
                this.deviceId = "00000000000000000000000000000000";
            }
        }
        if (this.deviceId.isEmpty()) {
            this.deviceId = "00000000000000000000000000000000";
        }
        return this.deviceId;
    }
}
