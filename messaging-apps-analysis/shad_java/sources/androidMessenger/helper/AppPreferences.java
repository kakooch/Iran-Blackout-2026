package androidMessenger.helper;

import androidMessenger.utilites.AppFavorUtils;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.BaseController;

/* loaded from: classes.dex */
public class AppPreferences extends BaseController {

    public enum Key {
        isOldAppAuthChecked,
        isOldRubxAppAuthChecked
    }

    public static void setOldAppAuthChecked(boolean z) {
        ApplicationLoader.applicationContext.getSharedPreferences(AppFavorUtils.SHARED_PREF_NAME_APP, 0).edit().putBoolean(Key.isOldAppAuthChecked.name(), z).commit();
    }

    public static void setOldRubxAppAuthChecked(boolean z) {
        ApplicationLoader.applicationContext.getSharedPreferences(AppFavorUtils.SHARED_PREF_NAME_APP, 0).edit().putBoolean(Key.isOldRubxAppAuthChecked.name(), z).commit();
    }

    public static boolean getOldAppAuthChecked() {
        return ApplicationLoader.applicationContext.getSharedPreferences(AppFavorUtils.SHARED_PREF_NAME_APP, 0).getBoolean(Key.isOldAppAuthChecked.name(), false);
    }

    public static boolean getOldRubxAppAuthChecked() {
        return ApplicationLoader.applicationContext.getSharedPreferences(AppFavorUtils.SHARED_PREF_NAME_APP, 0).getBoolean(Key.isOldRubxAppAuthChecked.name(), false);
    }
}
