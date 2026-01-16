package ir.resaneh1.iptv.helper;

import android.content.SharedPreferences;
import com.google.gson.reflect.TypeToken;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.resaneh1.iptv.model.GetGameStatusOutput;
import java.lang.reflect.Type;
import java.util.ArrayList;
import org.rbmain.messenger.ApplicationLoader;

/* loaded from: classes3.dex */
public class GameTestAppPreferences {
    private static GameTestAppPreferences instance;
    private ArrayList<GetGameStatusOutput> arrayStatus = null;
    private String namePreferences = "gameTestPreferences";
    SharedPreferences sharedPreferences = ApplicationLoader.applicationContext.getSharedPreferences(this.namePreferences, 0);

    public enum Key {
        arrayStatusKey
    }

    public static GameTestAppPreferences getInstance() {
        if (instance == null) {
            instance = new GameTestAppPreferences();
        }
        return instance;
    }

    public void setString(Key key, String str) {
        this.sharedPreferences.edit().putString(key + BuildConfig.FLAVOR, str).commit();
    }

    public String getString(Key key, String str) {
        return this.sharedPreferences.getString(key + BuildConfig.FLAVOR, str);
    }

    public ArrayList<GetGameStatusOutput> getStatusArray() {
        ArrayList<GetGameStatusOutput> arrayList;
        ArrayList<GetGameStatusOutput> arrayList2 = this.arrayStatus;
        if (arrayList2 != null) {
            return arrayList2;
        }
        String string = getString(Key.arrayStatusKey, BuildConfig.FLAVOR);
        Type type = new TypeToken<ArrayList<GetGameStatusOutput>>(this) { // from class: ir.resaneh1.iptv.helper.GameTestAppPreferences.1
        }.getType();
        if (string.length() > 0) {
            arrayList = (ArrayList) ApplicationLoader.getGson().fromJson(string, type);
        } else {
            arrayList = new ArrayList<>();
        }
        this.arrayStatus = arrayList;
        return arrayList;
    }

    public void setStatusArray(ArrayList<GetGameStatusOutput> arrayList) {
        if (arrayList == null) {
            return;
        }
        this.arrayStatus = arrayList;
        setString(Key.arrayStatusKey, ApplicationLoader.getGson().toJson(arrayList));
    }
}
