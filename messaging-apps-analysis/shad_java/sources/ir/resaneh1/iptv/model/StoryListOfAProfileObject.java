package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.fragment.rubino.RubinoController;
import ir.resaneh1.iptv.helper.AppRubinoPreferences;
import ir.resaneh1.iptv.helper.SendStoryHelper;
import ir.resaneh1.iptv.helper.StoryController;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class StoryListOfAProfileObject extends PresenterItem {
    private final int currentAccount;
    public String highlightId;
    public StoryController.ProfileStoryInfo info;
    public boolean isLive;
    public transient boolean isPreLoadStoryMediaCalled;
    public transient boolean isPreLoadedStory;
    private boolean lastHasLocal;
    public RubinoProfileObject profileObject;
    public int current = 0;
    public boolean isNeedToSetCurrentBasedOnSeen = true;

    public StoryListOfAProfileObject(int i) {
        this.currentAccount = i;
    }

    public boolean isSeenAllStories() {
        StoryController.ProfileStoryStatusEnum profileStoriesStatus = StoryController.getInstance(this.currentAccount).getProfileStoriesStatus(this.profileObject.id);
        return profileStoriesStatus != null && profileStoriesStatus == StoryController.ProfileStoryStatusEnum.SeenStory;
    }

    public RubinoProfileObject getProfileTryFromMap() {
        RubinoProfileObject rubinoProfileObject = RubinoController.getInstance(this.profileObject.currentAccount).profileMap.get(this.profileObject.id);
        if (rubinoProfileObject != null) {
            this.profileObject = rubinoProfileObject;
            return rubinoProfileObject;
        }
        return this.profileObject;
    }

    public boolean canReply() {
        StoryController.ProfileStoryInfo profileStoryInfo;
        return (isMyStory() || (profileStoryInfo = this.info) == null || !profileStoryInfo.canReply) ? false : true;
    }

    public boolean isMyStory() {
        return getProfileId().equals(AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id);
    }

    private boolean hasLocal() {
        if (this.lastHasLocal) {
            return true;
        }
        if (!isMyStory() || SendStoryHelper.getInstance(this.currentAccount).getLocalStories() == null || SendStoryHelper.getInstance(this.currentAccount).getLocalStories().size() <= 0) {
            return false;
        }
        this.lastHasLocal = true;
        return true;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        if (hasLocal()) {
            return PresenterItemType.localStoryListOfProfileObject;
        }
        return PresenterItemType.storyListOfProfileObject;
    }

    public StoryObject getCurrentStoryObject() {
        return getStoryObject(this.current);
    }

    public StoryObject getNextStoryObject() {
        return getStoryObject(this.current + 1);
    }

    public StoryObject getStoryObject(int i) {
        ArrayList<StoryController.StoryIdObject> arrayList;
        StoryController.ProfileStoryInfo profileStoryInfo = this.info;
        if (profileStoryInfo == null || (arrayList = profileStoryInfo.storyIdsObject) == null || i >= arrayList.size() || i < 0) {
            return null;
        }
        StoryObject instantStory = StoryController.getInstance(this.currentAccount).getInstantStory(this.info.storyIdsObject.get(i));
        if (instantStory != null) {
            return instantStory;
        }
        StoryController.getInstance(this.currentAccount).loadStory(this.info.storyIdsObject.get(i).getIdOrRnd(), this.info.getNextStoryIds(i), getProfileId(), false);
        return null;
    }

    public StoryController.StoryIdObject getCurrentStoryId() {
        ArrayList<StoryController.StoryIdObject> arrayList;
        int i;
        StoryController.ProfileStoryInfo profileStoryInfo = this.info;
        if (profileStoryInfo == null || (arrayList = profileStoryInfo.storyIdsObject) == null || this.current >= arrayList.size() || (i = this.current) < 0 || this.info.storyIdsObject.get(i) == null) {
            return null;
        }
        return this.info.storyIdsObject.get(this.current);
    }

    public void setCurrentBasedOnSeenForFirstTime() {
        if (this.isNeedToSetCurrentBasedOnSeen) {
            this.isNeedToSetCurrentBasedOnSeen = false;
            StoryController.ProfileStoryInfo profileStoryInfo = this.info;
            if (profileStoryInfo == null || profileStoryInfo.storyIdsObject == null) {
                return;
            }
            if (isSeenAllStories()) {
                this.current = 0;
                return;
            }
            int i = -1;
            for (int i2 = 0; i2 < this.info.storyIdsObject.size(); i2++) {
                if (StoryController.getInstance(this.currentAccount).isStorySeen(this.info.storyIdsObject.get(i2).getIdOrRnd(), getProfileId())) {
                    i = i2;
                }
            }
            int i3 = i + 1;
            if (i3 < this.info.storyIdsObject.size()) {
                this.current = i3;
            }
        }
    }

    public void setCurrentById(StoryController.StoryIdObject storyIdObject) {
        ArrayList<StoryController.StoryIdObject> arrayList;
        StoryController.ProfileStoryInfo profileStoryInfo = this.info;
        if (profileStoryInfo == null || (arrayList = profileStoryInfo.storyIdsObject) == null) {
            return;
        }
        Iterator<StoryController.StoryIdObject> it = arrayList.iterator();
        while (it.hasNext()) {
            StoryController.StoryIdObject next = it.next();
            if (next.equals(storyIdObject)) {
                this.current = this.info.storyIdsObject.indexOf(next);
                this.isNeedToSetCurrentBasedOnSeen = false;
            }
        }
    }

    public String getProfileId() {
        RubinoProfileObject rubinoProfileObject;
        String str;
        RubinoProfileObject rubinoProfileObject2 = this.profileObject;
        if (rubinoProfileObject2 != null && (str = rubinoProfileObject2.id) != null) {
            return str;
        }
        StoryController.ProfileStoryInfo profileStoryInfo = this.info;
        if (profileStoryInfo == null || (rubinoProfileObject = profileStoryInfo.profileObject) == null) {
            return null;
        }
        return rubinoProfileObject.id;
    }

    public boolean isSeenViewVisible() {
        return (!isMyStory() || getCurrentStoryObject() == null || getCurrentStoryObject().isLocal) ? false : true;
    }
}
