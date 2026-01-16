package ir.resaneh1.iptv.appUpdate;

import android.content.Context;

/* loaded from: classes3.dex */
public class UpdateUtils {
    public static int versionCompare(String str, String str2) {
        String[] strArrSplit = str.split("\\.");
        String[] strArrSplit2 = str2.split("\\.");
        int i = 0;
        while (i < strArrSplit.length && i < strArrSplit2.length && strArrSplit[i].equals(strArrSplit2[i])) {
            i++;
        }
        if (i < strArrSplit.length && i < strArrSplit2.length) {
            return Integer.signum(Integer.valueOf(strArrSplit[i]).compareTo(Integer.valueOf(strArrSplit2[i])));
        }
        return Integer.signum(strArrSplit.length - strArrSplit2.length);
    }

    public static String getAppVersion(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return "0.0.0";
        }
    }
}
