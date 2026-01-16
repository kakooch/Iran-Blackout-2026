package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.fragment.rubino.RubinoController;
import org.rbmain.messenger.UserConfig;

/* loaded from: classes3.dex */
public class EmojiSliderResultObject {
    public int currentAccount = UserConfig.selectedAccount;
    public float float_answer;
    public String full_thumbnail_url;
    public String id;
    public String name;
    public transient RubinoProfileObject profileObject;
    public String profile_id;
    public String story_id;
    public String username;

    public void makeData(int i) {
        this.currentAccount = i;
        createProfile();
    }

    private void createProfile() {
        RubinoProfileObject rubinoProfileObject = new RubinoProfileObject();
        this.profileObject = rubinoProfileObject;
        rubinoProfileObject.id = this.profile_id;
        rubinoProfileObject.username = this.username;
        rubinoProfileObject.full_thumbnail_url = this.full_thumbnail_url;
        rubinoProfileObject.name = this.name;
        rubinoProfileObject.createUsernameSpan();
    }

    public RubinoProfileObject getProfileTryFromMap() {
        RubinoProfileObject rubinoProfileObject = RubinoController.getInstance(this.currentAccount).profileMap.get(this.profile_id);
        if (rubinoProfileObject != null) {
            this.profileObject = rubinoProfileObject;
            return rubinoProfileObject;
        }
        return this.profileObject;
    }
}
