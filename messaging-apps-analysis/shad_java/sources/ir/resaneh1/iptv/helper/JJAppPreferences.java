package ir.resaneh1.iptv.helper;

import android.content.SharedPreferences;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.resaneh1.iptv.model.JJGetGroupsTabsOutput;
import ir.resaneh1.iptv.model.JJGetMatchAndTeamListOutput;
import ir.resaneh1.iptv.model.JJMatchObject;
import ir.resaneh1.iptv.model.JJTeamObject;
import ir.resaneh1.iptv.model.PredictLinkObject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.rbmain.messenger.ApplicationLoader;

/* loaded from: classes3.dex */
public class JJAppPreferences {
    public static PredictLinkObject currentPredictLink;
    private static JJAppPreferences instance;
    private JJGetMatchAndTeamListOutput matchAndTeamList = null;
    private JJGetGroupsTabsOutput groupsTabsList = null;
    private String namePreferences = "jjPreferences";
    SharedPreferences sharedPreferences = ApplicationLoader.applicationContext.getSharedPreferences(this.namePreferences, 0);

    public enum Key {
        jjTimestamp,
        jjMatchAndTeamList,
        jjMyTeamName,
        jjGroupsTabs
    }

    public static JJAppPreferences getInstance() {
        if (instance == null) {
            instance = new JJAppPreferences();
        }
        return instance;
    }

    public void setString(String str, String str2) {
        this.sharedPreferences.edit().putString(str + BuildConfig.FLAVOR, str2).commit();
    }

    public String getString(String str, String str2) {
        return this.sharedPreferences.getString(str + BuildConfig.FLAVOR, str2);
    }

    public void setLong(String str, long j) {
        this.sharedPreferences.edit().putLong(str + BuildConfig.FLAVOR, j).commit();
    }

    public long getLong(String str, long j) {
        return this.sharedPreferences.getLong(str + BuildConfig.FLAVOR, j);
    }

    public void clearJJData() {
        this.sharedPreferences.edit().clear().commit();
        this.matchAndTeamList = null;
        this.groupsTabsList = null;
    }

    public JJGetMatchAndTeamListOutput getMatchAndTeam() {
        JJGetMatchAndTeamListOutput jJGetMatchAndTeamListOutput;
        JJGetMatchAndTeamListOutput jJGetMatchAndTeamListOutput2 = this.matchAndTeamList;
        if (jJGetMatchAndTeamListOutput2 != null) {
            return jJGetMatchAndTeamListOutput2;
        }
        String string = getString(Key.jjMatchAndTeamList + currentPredictLink.id, BuildConfig.FLAVOR);
        if (string.length() > 0) {
            jJGetMatchAndTeamListOutput = (JJGetMatchAndTeamListOutput) ApplicationLoader.getGson().fromJson(string, JJGetMatchAndTeamListOutput.class);
        } else {
            jJGetMatchAndTeamListOutput = new JJGetMatchAndTeamListOutput();
        }
        this.matchAndTeamList = jJGetMatchAndTeamListOutput;
        return jJGetMatchAndTeamListOutput;
    }

    public JJGetGroupsTabsOutput getJJGroupsTabs() {
        JJGetGroupsTabsOutput jJGetGroupsTabsOutput;
        JJGetGroupsTabsOutput jJGetGroupsTabsOutput2 = this.groupsTabsList;
        if (jJGetGroupsTabsOutput2 != null) {
            return jJGetGroupsTabsOutput2;
        }
        String string = getString(Key.jjGroupsTabs + currentPredictLink.id, BuildConfig.FLAVOR);
        if (string.length() > 0) {
            jJGetGroupsTabsOutput = (JJGetGroupsTabsOutput) ApplicationLoader.getGson().fromJson(string, JJGetGroupsTabsOutput.class);
        } else {
            jJGetGroupsTabsOutput = new JJGetGroupsTabsOutput();
        }
        this.groupsTabsList = jJGetGroupsTabsOutput;
        return jJGetGroupsTabsOutput;
    }

    public void setJJGroupsTabs(JJGetGroupsTabsOutput jJGetGroupsTabsOutput) {
        if (jJGetGroupsTabsOutput == null) {
            return;
        }
        this.groupsTabsList = jJGetGroupsTabsOutput;
        setString(Key.jjGroupsTabs + currentPredictLink.id, ApplicationLoader.getGson().toJson(jJGetGroupsTabsOutput));
    }

    public void setOrUpdateMatchAndTeamList(JJGetMatchAndTeamListOutput jJGetMatchAndTeamListOutput) {
        String string = getString(Key.jjMatchAndTeamList + currentPredictLink.id, BuildConfig.FLAVOR);
        if (string.length() > 0) {
            this.matchAndTeamList = (JJGetMatchAndTeamListOutput) ApplicationLoader.getGson().fromJson(string, JJGetMatchAndTeamListOutput.class);
        } else {
            this.matchAndTeamList = null;
        }
        if (this.matchAndTeamList == null) {
            this.matchAndTeamList = jJGetMatchAndTeamListOutput;
        } else {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator<JJTeamObject> it = this.matchAndTeamList.result.teamUpdates.iterator();
            while (it.hasNext()) {
                JJTeamObject next = it.next();
                linkedHashMap.put(Integer.valueOf(next.id), next);
            }
            Iterator<JJTeamObject> it2 = jJGetMatchAndTeamListOutput.result.teamUpdates.iterator();
            while (it2.hasNext()) {
                JJTeamObject next2 = it2.next();
                linkedHashMap.put(Integer.valueOf(next2.id), next2);
            }
            this.matchAndTeamList.result.teamUpdates.clear();
            this.matchAndTeamList.result.teamUpdates.addAll(linkedHashMap.values());
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            Iterator<JJMatchObject> it3 = this.matchAndTeamList.result.matchUpdates.iterator();
            while (it3.hasNext()) {
                JJMatchObject next3 = it3.next();
                linkedHashMap2.put(Integer.valueOf(next3.id), next3);
            }
            Iterator<JJMatchObject> it4 = jJGetMatchAndTeamListOutput.result.matchUpdates.iterator();
            while (it4.hasNext()) {
                JJMatchObject next4 = it4.next();
                linkedHashMap2.put(Integer.valueOf(next4.id), next4);
            }
            this.matchAndTeamList.result.matchUpdates.clear();
            this.matchAndTeamList.result.matchUpdates.addAll(linkedHashMap2.values());
        }
        setString(Key.jjMatchAndTeamList + currentPredictLink.id, ApplicationLoader.getGson().toJson(this.matchAndTeamList));
    }
}
