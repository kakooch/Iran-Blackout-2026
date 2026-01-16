package ir.resaneh1.iptv.helper;

import android.content.SharedPreferences;
import io.github.inflationx.calligraphy3.BuildConfig;
import org.rbmain.messenger.ApplicationLoader;

/* loaded from: classes3.dex */
public class AppPrefrencesTemp {
    private static AppPrefrencesTemp instance;
    private String namePreferences = "PreferencesTemp";
    SharedPreferences sharedPreferences = ApplicationLoader.applicationContext.getSharedPreferences(this.namePreferences, 0);

    public enum Key {
        startPopup
    }

    public static AppPrefrencesTemp getInstance() {
        if (instance == null) {
            instance = new AppPrefrencesTemp();
        }
        return instance;
    }

    public void setLong(String str, long j) {
        this.sharedPreferences.edit().putLong(str + BuildConfig.FLAVOR, j).commit();
    }

    public long getLong(String str, long j) {
        return this.sharedPreferences.getLong(str + BuildConfig.FLAVOR, j);
    }

    public void clearData() {
        this.sharedPreferences.edit().clear().commit();
    }

    public long getStartPopupShowedTime(String str) {
        return getLong(Key.startPopup + str, 0L);
    }

    public void increaseStartPopupShowedTime(String str) {
        setLong(Key.startPopup + str, getStartPopupShowedTime(str) + 1);
    }
}
