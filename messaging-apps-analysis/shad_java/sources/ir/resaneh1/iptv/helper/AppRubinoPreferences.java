package ir.resaneh1.iptv.helper;

import android.content.SharedPreferences;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.resaneh1.iptv.fragment.rubino.RubinoController;
import ir.resaneh1.iptv.model.InstaProfileObject;
import ir.resaneh1.iptv.model.InstaProfileSettingObject;
import ir.resaneh1.iptv.model.Rubino;
import ir.resaneh1.iptv.model.RubinoProfileObject;
import ir.resaneh1.iptv.model.SetStorySettingInput;
import java.util.ArrayList;
import java.util.Iterator;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.BaseController;
import org.rbmain.messenger.UserConfig;

/* loaded from: classes3.dex */
public class AppRubinoPreferences extends BaseController {
    private static volatile AppRubinoPreferences[] Instance = new AppRubinoPreferences[3];
    private RubinoProfileObject defaultProfileObject2;
    private InstaProfileSettingObject instaProfileSettingObject;
    private String namePreferences;
    private RubinoProfileObject profileObject2;
    private Rubino.GetProfileListOutput profilesOutput2;
    SharedPreferences sharedPreferences;
    private Rubino.ExploreTopicsObject topicsOutput;

    public enum Key {
        instaProfileObject,
        instaMyProfileList,
        instaProfileSetting,
        instaDefaultProfileObject,
        rubinoMyProfileList,
        rubinoProfileObject,
        exploreTopicsOutput,
        shopPersonalInfo
    }

    public static AppRubinoPreferences getInstance(int i) {
        AppRubinoPreferences appRubinoPreferences = Instance[i];
        if (appRubinoPreferences == null) {
            synchronized (RubinoController.class) {
                appRubinoPreferences = Instance[i];
                if (appRubinoPreferences == null) {
                    AppRubinoPreferences[] appRubinoPreferencesArr = Instance;
                    AppRubinoPreferences appRubinoPreferences2 = new AppRubinoPreferences(i);
                    appRubinoPreferencesArr[i] = appRubinoPreferences2;
                    appRubinoPreferences = appRubinoPreferences2;
                }
            }
        }
        return appRubinoPreferences;
    }

    public AppRubinoPreferences(int i) {
        super(i);
        this.profilesOutput2 = null;
        this.profileObject2 = null;
        this.defaultProfileObject2 = null;
        this.instaProfileSettingObject = null;
        this.namePreferences = "instaPreferences";
        this.sharedPreferences = ApplicationLoader.applicationContext.getSharedPreferences(this.namePreferences + UserConfig.getAcountAppendString(this.currentAccount), 0);
    }

    public void setString(Key key, String str) {
        this.sharedPreferences.edit().putString(key + BuildConfig.FLAVOR, str).commit();
    }

    public String getString(Key key, String str) {
        return this.sharedPreferences.getString(key + BuildConfig.FLAVOR, str);
    }

    public String getString(Key key) {
        return getString(key, BuildConfig.FLAVOR);
    }

    public void clearInstaData() {
        this.sharedPreferences.edit().clear().commit();
        this.instaProfileSettingObject = null;
        this.profilesOutput2 = null;
        this.profileObject2 = null;
        this.defaultProfileObject2 = null;
    }

    public InstaProfileObject getInstaCurrentProfileObject() {
        RubinoProfileObject rubinoCurrentProfileObject = getRubinoCurrentProfileObject();
        InstaProfileObject instaProfileObjectConvertToOldObject = rubinoCurrentProfileObject != null ? RubinoProfileObject.convertToOldObject(rubinoCurrentProfileObject) : null;
        return instaProfileObjectConvertToOldObject == null ? new InstaProfileObject() : instaProfileObjectConvertToOldObject;
    }

    public RubinoProfileObject getRubinoCurrentProfileObject() {
        RubinoProfileObject rubinoProfileObject = this.profileObject2;
        if (rubinoProfileObject != null) {
            return rubinoProfileObject;
        }
        String string = getString(Key.rubinoProfileObject, BuildConfig.FLAVOR);
        RubinoProfileObject rubinoProfileObject2 = null;
        if (string.length() > 0) {
            try {
                RubinoProfileObject rubinoProfileObject3 = (RubinoProfileObject) ApplicationLoader.getGson().fromJson(string, RubinoProfileObject.class);
                if (rubinoProfileObject3 != null) {
                    try {
                        rubinoProfileObject3.makeData(this.currentAccount);
                    } catch (Exception unused) {
                    }
                }
                rubinoProfileObject2 = rubinoProfileObject3;
            } catch (Exception unused2) {
            }
        }
        if (rubinoProfileObject2 == null) {
            rubinoProfileObject2 = getRubinoDefaultProfileObject();
        }
        if (rubinoProfileObject2 == null) {
            rubinoProfileObject2 = new RubinoProfileObject();
        }
        this.profileObject2 = rubinoProfileObject2;
        return rubinoProfileObject2;
    }

    public void setRubinoCurrentProfileObject(RubinoProfileObject rubinoProfileObject) {
        rubinoProfileObject.isMyProfile = true;
        this.profileObject2 = rubinoProfileObject;
        setString(Key.rubinoProfileObject, ApplicationLoader.getGson().toJson(rubinoProfileObject));
    }

    public RubinoProfileObject getRubinoDefaultProfileObject() {
        ArrayList<RubinoProfileObject> arrayList;
        Rubino.GetProfileListOutput profilesOutput2 = getProfilesOutput2();
        if (profilesOutput2 != null && (arrayList = profilesOutput2.profiles) != null) {
            Iterator<RubinoProfileObject> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                RubinoProfileObject next = it.next();
                if (next.is_default) {
                    this.defaultProfileObject2 = next;
                    break;
                }
            }
        }
        if (this.defaultProfileObject2 == null) {
            this.defaultProfileObject2 = new RubinoProfileObject();
        }
        return this.defaultProfileObject2;
    }

    public InstaProfileSettingObject getProfileSettingObject() {
        InstaProfileSettingObject instaProfileSettingObject;
        InstaProfileSettingObject instaProfileSettingObject2 = this.instaProfileSettingObject;
        if (instaProfileSettingObject2 != null) {
            return instaProfileSettingObject2;
        }
        String string = getString(Key.instaProfileSetting, BuildConfig.FLAVOR);
        if (string.length() > 0) {
            instaProfileSettingObject = (InstaProfileSettingObject) ApplicationLoader.getGson().fromJson(string, InstaProfileSettingObject.class);
        } else {
            instaProfileSettingObject = new InstaProfileSettingObject();
            instaProfileSettingObject.story_allow_reply = SetStorySettingInput.StoryAllowReplyEnum.AllFollowers;
            instaProfileSettingObject.story_save_to_gallery = false;
        }
        this.instaProfileSettingObject = instaProfileSettingObject;
        return instaProfileSettingObject;
    }

    public void setProfileSetting(InstaProfileSettingObject instaProfileSettingObject) {
        this.instaProfileSettingObject = instaProfileSettingObject;
        setString(Key.instaProfileSetting, ApplicationLoader.getGson().toJson(instaProfileSettingObject));
    }

    public Rubino.GetProfileListOutput getProfilesOutput2() {
        Rubino.GetProfileListOutput getProfileListOutput;
        Rubino.GetProfileListOutput getProfileListOutput2 = this.profilesOutput2;
        if (getProfileListOutput2 != null) {
            return getProfileListOutput2;
        }
        String string = getString(Key.rubinoMyProfileList, BuildConfig.FLAVOR);
        if (string.length() > 0) {
            getProfileListOutput = (Rubino.GetProfileListOutput) ApplicationLoader.getGson().fromJson(string, Rubino.GetProfileListOutput.class);
        } else {
            getProfileListOutput = new Rubino.GetProfileListOutput();
            getProfileListOutput.profiles = new ArrayList<>();
        }
        this.profilesOutput2 = getProfileListOutput;
        return getProfileListOutput;
    }

    public Rubino.ExploreTopicsObject getExploreTopics() {
        Rubino.ExploreTopicsObject exploreTopicsObject;
        Rubino.ExploreTopicsObject exploreTopicsObject2 = this.topicsOutput;
        if (exploreTopicsObject2 != null) {
            return exploreTopicsObject2;
        }
        String string = getString(Key.exploreTopicsOutput, BuildConfig.FLAVOR);
        if (string.length() > 0) {
            exploreTopicsObject = (Rubino.ExploreTopicsObject) ApplicationLoader.getGson().fromJson(string, Rubino.ExploreTopicsObject.class);
        } else {
            exploreTopicsObject = new Rubino.ExploreTopicsObject();
            exploreTopicsObject.topics = new ArrayList<>();
        }
        this.topicsOutput = exploreTopicsObject;
        return exploreTopicsObject;
    }

    public void setExploreTopics(Rubino.ExploreTopicsObject exploreTopicsObject) {
        exploreTopicsObject.lastUpdatedTime = System.currentTimeMillis();
        this.topicsOutput = exploreTopicsObject;
        setString(Key.exploreTopicsOutput, ApplicationLoader.getGson().toJson(exploreTopicsObject));
    }

    public RubinoProfileObject getMyProfileFromList(String str) {
        Iterator<RubinoProfileObject> it = getProfilesOutput2().profiles.iterator();
        while (it.hasNext()) {
            RubinoProfileObject next = it.next();
            if (next.id.equals(str)) {
                return next;
            }
        }
        return null;
    }

    public void setRubinoProfilesOutput(Rubino.GetProfileListOutput getProfileListOutput) {
        this.profilesOutput2 = getProfileListOutput;
        setString(Key.rubinoMyProfileList, ApplicationLoader.getGson().toJson(getProfileListOutput));
        RubinoProfileObject rubinoCurrentProfileObject = getRubinoCurrentProfileObject();
        RubinoProfileObject rubinoProfileObject = new RubinoProfileObject();
        Iterator<RubinoProfileObject> it = getProfileListOutput.profiles.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            RubinoProfileObject next = it.next();
            if (next.is_default) {
                rubinoProfileObject = next;
                break;
            }
        }
        if (rubinoCurrentProfileObject.id.isEmpty()) {
            setRubinoCurrentProfileObject(rubinoProfileObject);
            return;
        }
        boolean z = false;
        Iterator<RubinoProfileObject> it2 = getProfileListOutput.profiles.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            if (rubinoCurrentProfileObject.id.equals(it2.next().id)) {
                z = true;
                break;
            }
        }
        if (z) {
            return;
        }
        setRubinoCurrentProfileObject(rubinoProfileObject);
    }
}
