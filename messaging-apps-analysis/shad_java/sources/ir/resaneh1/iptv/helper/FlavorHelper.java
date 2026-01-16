package ir.resaneh1.iptv.helper;

import org.rbmain.messenger.BuildConfig;

/* loaded from: classes.dex */
public enum FlavorHelper {
    RUBIKA("rubika"),
    RUBX("rubx");

    public final String flavorName;

    public static boolean isRubino() {
        return false;
    }

    public static boolean isShad() {
        return true;
    }

    FlavorHelper(String str) {
        this.flavorName = str;
    }

    public static boolean isRubika() {
        return BuildConfig.FLAVOR.startsWith(RUBIKA.flavorName);
    }

    public static boolean isRubx() {
        return BuildConfig.FLAVOR.startsWith(RUBX.flavorName);
    }
}
