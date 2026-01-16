package ir.resaneh1.iptv.helper;

import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import ir.aaap.messengercore.model.ChatType;
import ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx;
import ir.resaneh1.iptv.apiMessanger.ApiServerException;
import ir.resaneh1.iptv.fragment.rubino.RubinoController;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.AddEmojiSliderAnswerInput;
import ir.resaneh1.iptv.model.AddPollAnswerInput;
import ir.resaneh1.iptv.model.AddViewStoryInput;
import ir.resaneh1.iptv.model.AddViewStoryOutput;
import ir.resaneh1.iptv.model.DeleteStoryInput;
import ir.resaneh1.iptv.model.DeleteStoryOutput;
import ir.resaneh1.iptv.model.GetMyStoryListInput;
import ir.resaneh1.iptv.model.GetMyStoryListOutput;
import ir.resaneh1.iptv.model.GetProfilesStoriesInput;
import ir.resaneh1.iptv.model.GetProfilesStoriesOutput;
import ir.resaneh1.iptv.model.GetProfilesStoryListInput;
import ir.resaneh1.iptv.model.GetProfilesStoryListOutput;
import ir.resaneh1.iptv.model.GetStoryIdsInput;
import ir.resaneh1.iptv.model.GetStoryIdsOutput;
import ir.resaneh1.iptv.model.GetStoryInput;
import ir.resaneh1.iptv.model.GetStoryOutput;
import ir.resaneh1.iptv.model.GetStoryViewersOutput;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.model.Rubino;
import ir.resaneh1.iptv.model.RubinoProfileObject;
import ir.resaneh1.iptv.model.StoryListOfAProfileObject;
import ir.resaneh1.iptv.model.StoryObject;
import ir.resaneh1.iptv.model.StoryProfileStoryId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.BaseController;
import org.rbmain.messenger.NotificationCenter;

/* loaded from: classes3.dex */
public class StoryController extends BaseController {
    private static volatile StoryController[] Instance = new StoryController[3];
    private CompositeDisposable compositeDisposable;
    public String currentLoadingProfileId;
    public Map<String, ProfileStoryInfo> highlightIdStoryInfoMap;
    private final Object highlightLock;
    private Set<String> loadingProfileStoryIds;
    private Set<String> loadingStorySet;
    public int maxMapSize;
    private Map<String, Boolean> profileHasLiveMap;
    public Map<String, ProfileStoryInfo> profileIdStoryInfoMap;
    private Map<String, ProfileStoryStatusEnum> profileIdStoryStatusMap;
    private Map<String, Set<String>> profileIdToSendSeenIdsMap;
    Comparator<StoryListOfAProfileObject> storyComparator;
    private Map<String, StoryInfo> storyMap;
    public Map<String, Integer> storySeenCountMap;
    public Map<String, GetStoryViewersOutput> storyViewersOutputStoryIdMap;
    public long validHighlightStoryIdsInfoDurationMillis;
    public long validMyStoryWithWidgetMillis;
    public long validProfileStoryIdsInfoDurationMillis;
    public long validStoryInfoDurationMillis;
    public long validStoryViewersDurationMillis;
    public long validStoryWithWidgetMillis;

    public enum ProfileStorySendingStatusEnum {
        SENDINGSTORY,
        ERRORSENDING,
        NONE
    }

    public enum ProfileStoryStatusEnum {
        SeenStory,
        NotSeenStory,
        NoStory,
        HasLive,
        Unknown
    }

    public void onHighlightChanged(String str) {
        ProfileStoryInfo profileStoryInfo = this.highlightIdStoryInfoMap.get(str);
        if (profileStoryInfo != null) {
            profileStoryInfo.updateTime = 0L;
        }
    }

    public void onProfileHighlightChanged(String str) {
        RubinoProfileObject rubinoProfileObject;
        String str2;
        if (str == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this.highlightLock) {
            for (String str3 : this.highlightIdStoryInfoMap.keySet()) {
                ProfileStoryInfo profileStoryInfo = this.highlightIdStoryInfoMap.get(str3);
                if (profileStoryInfo != null && (rubinoProfileObject = profileStoryInfo.profileObject) != null && (str2 = rubinoProfileObject.id) != null && str2.equals(str)) {
                    arrayList.add(str3);
                }
            }
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    this.highlightIdStoryInfoMap.remove((String) it.next());
                }
            }
        }
    }

    public static StoryController getInstance(int i) {
        StoryController storyController = Instance[i];
        if (storyController == null) {
            synchronized (StoryController.class) {
                storyController = Instance[i];
                if (storyController == null) {
                    StoryController[] storyControllerArr = Instance;
                    StoryController storyController2 = new StoryController(i);
                    storyControllerArr[i] = storyController2;
                    storyController = storyController2;
                }
            }
        }
        return storyController;
    }

    StoryController(int i) {
        super(i);
        this.compositeDisposable = new CompositeDisposable();
        this.profileIdStoryInfoMap = new HashMap();
        this.highlightIdStoryInfoMap = new HashMap();
        this.storyMap = new HashMap();
        this.storySeenCountMap = new HashMap();
        this.profileIdStoryStatusMap = new HashMap();
        this.profileHasLiveMap = new HashMap();
        this.storyViewersOutputStoryIdMap = new HashMap();
        this.profileIdToSendSeenIdsMap = new HashMap();
        this.maxMapSize = 100;
        this.validProfileStoryIdsInfoDurationMillis = 60000L;
        this.validHighlightStoryIdsInfoDurationMillis = 60000L;
        this.validStoryInfoDurationMillis = 3600000L;
        this.validStoryWithWidgetMillis = 60000L;
        this.validMyStoryWithWidgetMillis = 20000L;
        this.validStoryViewersDurationMillis = 60000L;
        this.loadingStorySet = new HashSet();
        this.loadingProfileStoryIds = new HashSet();
        this.highlightLock = new Object();
        this.storyComparator = new Comparator<StoryListOfAProfileObject>(this) { // from class: ir.resaneh1.iptv.helper.StoryController.21
            @Override // java.util.Comparator
            public int compare(StoryListOfAProfileObject storyListOfAProfileObject, StoryListOfAProfileObject storyListOfAProfileObject2) {
                if (storyListOfAProfileObject.isMyStory()) {
                    return -1;
                }
                if (storyListOfAProfileObject2.isMyStory()) {
                    return 1;
                }
                boolean z = storyListOfAProfileObject.isLive;
                if (z && storyListOfAProfileObject2.isLive) {
                    return 0;
                }
                if (z) {
                    return -1;
                }
                if (storyListOfAProfileObject2.isLive) {
                    return 1;
                }
                if (storyListOfAProfileObject.isSeenAllStories() == storyListOfAProfileObject2.isSeenAllStories()) {
                    return 0;
                }
                if (!storyListOfAProfileObject.isSeenAllStories() || storyListOfAProfileObject2.isSeenAllStories()) {
                    return (storyListOfAProfileObject.isSeenAllStories() || !storyListOfAProfileObject2.isSeenAllStories()) ? 0 : -1;
                }
                return 1;
            }
        };
    }

    public void clearLoadingMaps() {
        this.loadingStorySet.clear();
        this.loadingProfileStoryIds.clear();
    }

    public void clear() {
        try {
            this.compositeDisposable.dispose();
            this.compositeDisposable = new CompositeDisposable();
            this.storySeenCountMap.clear();
            this.profileIdStoryInfoMap.clear();
            this.highlightIdStoryInfoMap.clear();
            this.storyMap.clear();
            this.profileIdStoryStatusMap.clear();
            this.profileHasLiveMap.clear();
            this.storyViewersOutputStoryIdMap.clear();
            this.profileIdToSendSeenIdsMap.clear();
            this.loadingStorySet.clear();
            this.loadingProfileStoryIds.clear();
        } catch (Exception unused) {
        }
    }

    public void updateMapFromProfileInfoOutput(Rubino.GetProfileInfoOutput getProfileInfoOutput) {
        RubinoProfileObject rubinoProfileObject;
        if (getProfileInfoOutput == null || (rubinoProfileObject = getProfileInfoOutput.profile) == null) {
            return;
        }
        ProfileStoryStatusEnum profileStoryStatusEnum = getProfileInfoOutput.story_status;
        if (profileStoryStatusEnum != null) {
            addToProfileStoryStatusMap(rubinoProfileObject.id, profileStoryStatusEnum);
        }
        setProfileHasLive(getProfileInfoOutput.profile, getProfileInfoOutput.has_live, true);
    }

    public void setProfileHasLive(RubinoProfileObject rubinoProfileObject, boolean z, boolean z2) {
        if (rubinoProfileObject == null) {
            return;
        }
        if (this.profileHasLiveMap.size() > this.maxMapSize) {
            this.profileHasLiveMap.clear();
        }
        this.profileHasLiveMap.put(rubinoProfileObject.id, Boolean.valueOf(z));
        if (z2) {
            getNotificationCenter().postNotificationNameOnUIThread(NotificationCenter.rubinoLiveStatusChanged, rubinoProfileObject.id, rubinoProfileObject);
        }
    }

    public boolean profileHasLive(String str) {
        Boolean bool = this.profileHasLiveMap.get(str);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public void addStoryViewersOutputMap(String str, GetStoryViewersOutput getStoryViewersOutput) {
        if (str == null || getStoryViewersOutput == null) {
            return;
        }
        getStoryViewersOutput.updatedTime = System.currentTimeMillis();
        this.storyViewersOutputStoryIdMap.put(str, getStoryViewersOutput);
    }

    public void checkIsMyFirstStoryAndNotify() {
        ProfileStoryInfo instantProfileStoryIdsWithLocal = getInstantProfileStoryIdsWithLocal(AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject(), null, false);
        if (instantProfileStoryIdsWithLocal == null || instantProfileStoryIdsWithLocal.storyIdsObject == null) {
            return;
        }
        MyLog.e("StoryController", "checkIsMyFirstStoryAndNotify " + instantProfileStoryIdsWithLocal.storyIdsObject.size());
        if (instantProfileStoryIdsWithLocal.storyIdsObject.size() == 1) {
            getNotificationCenter().postNotificationNameOnUIThread(NotificationCenter.myFirstStoryAdded, new Object[0]);
        }
    }

    public ProfileStoryStatusEnum getProfileStoriesStatus(String str) {
        ProfileStoryInfo instantProfileStoryIdsWithLocal;
        ArrayList<StoryIdObject> arrayList;
        RubinoProfileObject rubinoCurrentProfileObject = AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject();
        String str2 = rubinoCurrentProfileObject.id;
        ProfileStoryStatusEnum profileStoryStatusEnum = this.profileIdStoryStatusMap.get(str);
        if (str.equals(str2) && ((profileStoryStatusEnum == null || profileStoryStatusEnum == ProfileStoryStatusEnum.NoStory) && (instantProfileStoryIdsWithLocal = getInstantProfileStoryIdsWithLocal(rubinoCurrentProfileObject, null, false)) != null && (arrayList = instantProfileStoryIdsWithLocal.storyIdsObject) != null && arrayList.size() > 0)) {
            Map<String, ProfileStoryStatusEnum> map = this.profileIdStoryStatusMap;
            ProfileStoryStatusEnum profileStoryStatusEnum2 = ProfileStoryStatusEnum.SeenStory;
            map.put(str2, profileStoryStatusEnum2);
            return profileStoryStatusEnum2;
        }
        if (profileStoryStatusEnum != null) {
            if (profileStoryStatusEnum != ProfileStoryStatusEnum.NotSeenStory || !str.equals(str2)) {
                return profileStoryStatusEnum;
            }
            Map<String, ProfileStoryStatusEnum> map2 = this.profileIdStoryStatusMap;
            ProfileStoryStatusEnum profileStoryStatusEnum3 = ProfileStoryStatusEnum.SeenStory;
            map2.put(str2, profileStoryStatusEnum3);
            return profileStoryStatusEnum3;
        }
        return ProfileStoryStatusEnum.Unknown;
    }

    public void addEmojiSliderAnswer(String str, String str2, float f) {
        if (ApplicationLoader.applicationActivity == null) {
            return;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        if (f < 0.0f) {
            f = 0.0f;
        }
        ApplicationLoader.applicationActivity.mainCompositeDisposable.add((Disposable) getApiRequestMessangerRx().addEmojiSliderAnswer(new AddEmojiSliderAnswerInput(AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id, str, str2, f)).subscribeWith(new DisposableObserver<MessangerOutput>(this) { // from class: ir.resaneh1.iptv.helper.StoryController.1
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput messangerOutput) {
            }
        }));
    }

    public void addPollAnswer(String str, String str2, int i) {
        if (ApplicationLoader.applicationActivity == null) {
            return;
        }
        ApplicationLoader.applicationActivity.mainCompositeDisposable.add((Disposable) getApiRequestMessangerRx().addPollAnswer(new AddPollAnswerInput(AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id, str, str2, i)).subscribeWith(new DisposableObserver<MessangerOutput>(this) { // from class: ir.resaneh1.iptv.helper.StoryController.2
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput messangerOutput) {
            }
        }));
    }

    public ProfileStorySendingStatusEnum getMyProfileStorySendingStatus() {
        ArrayList<StoryObject> localStories = SendStoryHelper.getInstance(this.currentAccount).getLocalStories();
        if (localStories.size() <= 0) {
            return ProfileStorySendingStatusEnum.NONE;
        }
        Iterator<StoryObject> it = localStories.iterator();
        while (it.hasNext()) {
            if (it.next().isFailed) {
                return ProfileStorySendingStatusEnum.ERRORSENDING;
            }
        }
        return ProfileStorySendingStatusEnum.SENDINGSTORY;
    }

    public boolean isStorySeen(String str, String str2) {
        Set<String> set;
        ProfileStoryInfo profileStoryInfo = this.profileIdStoryInfoMap.get(str2);
        Set<String> set2 = this.profileIdToSendSeenIdsMap.get(str2);
        return !(profileStoryInfo == null || (set = profileStoryInfo.seenStoryIds) == null || !set.contains(str)) || (set2 != null && set2.contains(str));
    }

    public GetStoryViewersOutput getViewersOutputStoryIdMap(String str) {
        Map<String, GetStoryViewersOutput> map;
        GetStoryViewersOutput getStoryViewersOutput;
        if (str == null || (map = this.storyViewersOutputStoryIdMap) == null || (getStoryViewersOutput = map.get(str)) == null || System.currentTimeMillis() - getStoryViewersOutput.updatedTime >= this.validStoryViewersDurationMillis) {
            return null;
        }
        return getStoryViewersOutput;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public StoryInfo addToStoryMap(StoryObject storyObject, String str) {
        if (storyObject == null || storyObject.id == null) {
            return null;
        }
        if (this.storyMap == null) {
            this.storyMap = new HashMap();
        }
        if (this.storyMap.size() > this.maxMapSize) {
            this.storyMap.clear();
        }
        StoryInfo storyInfo = new StoryInfo(str, storyObject, System.currentTimeMillis());
        this.storyMap.put(storyObject.id, storyInfo);
        return storyInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addToProfileStoryIdsInfoMap(String str, ProfileStoryInfo profileStoryInfo) {
        if (str == null || profileStoryInfo == null) {
            return;
        }
        if (this.profileIdStoryInfoMap.size() > this.maxMapSize) {
            this.profileIdStoryInfoMap.clear();
        }
        this.profileIdStoryInfoMap.put(str, profileStoryInfo);
    }

    public void addToProfileStoryStatusMap(String str, ProfileStoryStatusEnum profileStoryStatusEnum) {
        if (str == null || profileStoryStatusEnum == null) {
            return;
        }
        if (this.profileIdStoryStatusMap.size() > this.maxMapSize) {
            this.profileIdStoryStatusMap.clear();
        }
        this.profileIdStoryStatusMap.put(str, profileStoryStatusEnum);
    }

    public ProfileStoryInfo getInstantProfileStoryIdsEvenIfExpired(RubinoProfileObject rubinoProfileObject) {
        Map<String, ProfileStoryInfo> map = this.profileIdStoryInfoMap;
        if (map != null) {
            return map.get(rubinoProfileObject.id);
        }
        return null;
    }

    public ProfileStoryInfo getInstantHighlightStoryIdsEvenIfExpired(String str) {
        Map<String, ProfileStoryInfo> map = this.highlightIdStoryInfoMap;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public RubinoProfileObject getInstantProfile(String str) {
        ProfileStoryInfo profileStoryInfo;
        Map<String, ProfileStoryInfo> map = this.profileIdStoryInfoMap;
        if (map == null || (profileStoryInfo = map.get(str)) == null) {
            return null;
        }
        return profileStoryInfo.profileObject;
    }

    public ProfileStoryInfo getInstantProfileStoryIdsWithLocalAndLoadIfNeeded(RubinoProfileObject rubinoProfileObject, String str) {
        return getInstantProfileStoryIdsWithLocal(rubinoProfileObject, str, true);
    }

    public ProfileStoryInfo getInstantProfileStoryIdsWithLocal(RubinoProfileObject rubinoProfileObject, String str, boolean z) {
        String str2;
        if (str != null && !str.isEmpty()) {
            return getHighlightStoryIdsAndLoadIfNeeded(rubinoProfileObject, str, z);
        }
        if (rubinoProfileObject == null || (str2 = rubinoProfileObject.id) == null) {
            return null;
        }
        Map<String, ProfileStoryInfo> map = this.profileIdStoryInfoMap;
        if (map != null) {
            ProfileStoryInfo profileStoryInfo = map.get(str2);
            if (profileStoryInfo != null) {
                if (z && System.currentTimeMillis() - profileStoryInfo.updateTime > this.validProfileStoryIdsInfoDurationMillis) {
                    getProfileStoryIdsFromServer(rubinoProfileObject);
                }
                if (rubinoProfileObject.id.equals(AppRubinoPreferences.getInstance(this.currentAccount).getInstaCurrentProfileObject().id)) {
                    profileStoryInfo.addOrUpdateLocalStories(SendStoryHelper.getInstance(this.currentAccount).getLocalStories());
                }
                return profileStoryInfo;
            }
            if (z) {
                getProfileStoryIdsFromServer(rubinoProfileObject);
            }
        }
        if (!rubinoProfileObject.id.equals(AppRubinoPreferences.getInstance(this.currentAccount).getInstaCurrentProfileObject().id) || SendStoryHelper.getInstance(this.currentAccount).getLocalStories() == null || SendStoryHelper.getInstance(this.currentAccount).getLocalStories().size() <= 0) {
            return null;
        }
        ProfileStoryInfo profileStoryInfo2 = new ProfileStoryInfo();
        profileStoryInfo2.profileObject = rubinoProfileObject;
        profileStoryInfo2.updateTime = 0L;
        profileStoryInfo2.addOrUpdateLocalStories(SendStoryHelper.getInstance(this.currentAccount).getLocalStories());
        addToProfileStoryIdsInfoMap(rubinoProfileObject.id, profileStoryInfo2);
        return profileStoryInfo2;
    }

    public ProfileStoryInfo getHighlightStoryIdsAndLoadIfNeeded(RubinoProfileObject rubinoProfileObject, String str, boolean z) {
        if (str == null) {
            return null;
        }
        ProfileStoryInfo profileStoryInfo = this.highlightIdStoryInfoMap.get(str);
        if (z && (profileStoryInfo == null || System.currentTimeMillis() - profileStoryInfo.updateTime > this.validHighlightStoryIdsInfoDurationMillis)) {
            this.compositeDisposable.add((Disposable) getHighlightStoryObservable(rubinoProfileObject, str, 0, 5, false).subscribeWith(new DisposableObserver<ProfileStoryInfo>(this) { // from class: ir.resaneh1.iptv.helper.StoryController.3
                @Override // io.reactivex.Observer
                public void onComplete() {
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                }

                @Override // io.reactivex.Observer
                public void onNext(ProfileStoryInfo profileStoryInfo2) {
                }
            }));
        }
        return profileStoryInfo;
    }

    public void unSetCurrentLoadingProfile() {
        if (this.currentLoadingProfileId != null) {
            this.currentLoadingProfileId = null;
            getNotificationCenter().postNotificationNameOnUIThread(NotificationCenter.storyCurrentLoadingProfileChanged, new Object[0]);
        }
    }

    public void setCurrentLoadingProfile(String str) {
        String str2 = this.currentLoadingProfileId;
        if (str2 == null || !str2.equals(str)) {
            this.currentLoadingProfileId = str;
            getNotificationCenter().postNotificationNameOnUIThread(NotificationCenter.storyCurrentLoadingProfileChanged, new Object[0]);
        }
    }

    public void callGetMyStories() {
        final RubinoProfileObject rubinoCurrentProfileObject = AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject();
        if (rubinoCurrentProfileObject == null) {
            return;
        }
        GetMyStoryListInput getMyStoryListInput = new GetMyStoryListInput(rubinoCurrentProfileObject.id, 100, null);
        this.loadingProfileStoryIds.add(rubinoCurrentProfileObject.id);
        this.compositeDisposable.add((Disposable) getApiRequestMessangerRx().getMyStoryList(getMyStoryListInput).subscribeWith(new DisposableObserver<MessangerOutput<GetMyStoryListOutput>>() { // from class: ir.resaneh1.iptv.helper.StoryController.4
            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput<GetMyStoryListOutput> messangerOutput) {
                GetMyStoryListOutput getMyStoryListOutput;
                StoryController.this.loadingProfileStoryIds.remove(rubinoCurrentProfileObject.id);
                if (messangerOutput == null || (getMyStoryListOutput = messangerOutput.data) == null || getMyStoryListOutput.stories == null) {
                    return;
                }
                StoryController storyController = StoryController.this;
                storyController.addToProfileStoryIdsInfoMap(rubinoCurrentProfileObject.id, ProfileStoryInfo.createInfoFromMyStory(((BaseController) storyController).currentAccount, rubinoCurrentProfileObject, messangerOutput.data.stories, System.currentTimeMillis()));
                ProfileStoryInfo instantProfileStoryIdsWithLocalAndLoadIfNeeded = StoryController.this.getInstantProfileStoryIdsWithLocalAndLoadIfNeeded(rubinoCurrentProfileObject, null);
                if (instantProfileStoryIdsWithLocalAndLoadIfNeeded != null) {
                    StoryController.this.getNotificationCenter().postNotificationNameOnUIThread(NotificationCenter.profileStoryIdsDidLoad, instantProfileStoryIdsWithLocalAndLoadIfNeeded);
                }
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                StoryController.this.loadingProfileStoryIds.remove(rubinoCurrentProfileObject.id);
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                StoryController.this.loadingProfileStoryIds.remove(rubinoCurrentProfileObject.id);
            }
        }));
    }

    public Observable<ProfileStoryInfo> getProfileStoryIdsObservable(final RubinoProfileObject rubinoProfileObject) {
        ProfileStoryInfo profileStoryInfo = this.profileIdStoryInfoMap.get(rubinoProfileObject.id);
        if (profileStoryInfo != null && System.currentTimeMillis() - profileStoryInfo.updateTime <= this.validProfileStoryIdsInfoDurationMillis) {
            return Observable.just(profileStoryInfo);
        }
        MyLog.e("StoryLogPreload", "StoryController getStoryIds profileID " + rubinoProfileObject.id);
        return getApiRequestMessangerRx().getStoryIds(new GetStoryIdsInput(rubinoProfileObject.id, AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id)).observeOn(Schedulers.computation()).doOnNext(new Consumer<MessangerOutput<GetStoryIdsOutput>>() { // from class: ir.resaneh1.iptv.helper.StoryController.6
            @Override // io.reactivex.functions.Consumer
            public void accept(MessangerOutput<GetStoryIdsOutput> messangerOutput) throws Exception {
                StoryController.this.onGetStoryIdsResponse(rubinoProfileObject, messangerOutput);
            }
        }).flatMap(new Function<MessangerOutput<GetStoryIdsOutput>, ObservableSource<ProfileStoryInfo>>() { // from class: ir.resaneh1.iptv.helper.StoryController.5
            @Override // io.reactivex.functions.Function
            public ObservableSource<ProfileStoryInfo> apply(MessangerOutput<GetStoryIdsOutput> messangerOutput) throws Exception {
                return Observable.just(StoryController.this.profileIdStoryInfoMap.get(rubinoProfileObject.id));
            }
        }).observeOn(AndroidSchedulers.mainThread());
    }

    private Observable<ProfileStoryInfo> getHighlightStoryIdsObservable(final RubinoProfileObject rubinoProfileObject, final String str) {
        ProfileStoryInfo profileStoryInfo = this.highlightIdStoryInfoMap.get(str);
        if (profileStoryInfo != null && System.currentTimeMillis() - profileStoryInfo.updateTime <= this.validProfileStoryIdsInfoDurationMillis) {
            profileStoryInfo.highlightId = str;
            return Observable.just(profileStoryInfo);
        }
        return getApiRequestMessangerRx().getHighlightStoryIds(new Rubino.GetHighlightStoryIdsInput(RubinoController.getInstance(this.currentAccount).getMyCurrentProfileID(), rubinoProfileObject.id, str)).observeOn(Schedulers.computation()).flatMap(new Function<MessangerOutput<GetStoryIdsOutput>, ObservableSource<ProfileStoryInfo>>() { // from class: ir.resaneh1.iptv.helper.StoryController.7
            @Override // io.reactivex.functions.Function
            public ObservableSource<ProfileStoryInfo> apply(MessangerOutput<GetStoryIdsOutput> messangerOutput) throws Exception {
                ProfileStoryInfo profileStoryInfoCreateInfoFromOutput = ProfileStoryInfo.createInfoFromOutput(rubinoProfileObject, str, messangerOutput.data, System.currentTimeMillis());
                StoryController.this.highlightIdStoryInfoMap.put(str, profileStoryInfoCreateInfoFromOutput);
                profileStoryInfoCreateInfoFromOutput.highlightId = str;
                StoryController.this.getNotificationCenter().postNotificationNameOnUIThread(NotificationCenter.highlightStoryIdsDidLoad, profileStoryInfoCreateInfoFromOutput);
                return Observable.just(profileStoryInfoCreateInfoFromOutput);
            }
        }).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<Integer> getStoryIdsWithLoadStoryObservable(RubinoProfileObject rubinoProfileObject, String str, int i, int i2, boolean z) {
        if (str != null && !str.isEmpty()) {
            return getHighlightStoryObservable(rubinoProfileObject, str, i, i2, z).flatMap(new Function<ProfileStoryInfo, Observable<Integer>>(this) { // from class: ir.resaneh1.iptv.helper.StoryController.8
                @Override // io.reactivex.functions.Function
                public Observable<Integer> apply(ProfileStoryInfo profileStoryInfo) throws Exception {
                    return Observable.just(1);
                }
            });
        }
        return getProfileStoryIdsWithLoadStoryObservable(rubinoProfileObject, i, i2, z);
    }

    public Observable<Integer> getProfileStoryIdsWithLoadStoryObservable(final RubinoProfileObject rubinoProfileObject, final int i, final int i2, final boolean z) {
        final HashSet hashSet = new HashSet();
        return getProfileStoryIdsObservable(rubinoProfileObject).flatMap(new Function<ProfileStoryInfo, ObservableSource<Integer>>() { // from class: ir.resaneh1.iptv.helper.StoryController.9
            @Override // io.reactivex.functions.Function
            public ObservableSource<Integer> apply(ProfileStoryInfo profileStoryInfo) throws Exception {
                int i3;
                int i4 = i;
                if (i4 < 0) {
                    i4 = 0;
                }
                if (i2 > 0) {
                    for (int i5 = 0; i5 < i2 && (i3 = i4 + i5) < profileStoryInfo.storyIdsObject.size(); i5++) {
                        StoryIdObject storyIdObject = profileStoryInfo.storyIdsObject.get(i3);
                        if (!storyIdObject.isLocal && StoryController.this.getInstantStory(storyIdObject) == null) {
                            hashSet.add(storyIdObject.getIdOrRnd());
                        }
                    }
                }
                return StoryController.this.getLoadStoryObservable(hashSet, rubinoProfileObject.id, z);
            }
        });
    }

    public Observable<ProfileStoryInfo> getHighlightStoryObservable(final RubinoProfileObject rubinoProfileObject, final String str, final int i, final int i2, final boolean z) {
        final HashSet hashSet = new HashSet();
        final ProfileStoryInfo[] profileStoryInfoArr = new ProfileStoryInfo[1];
        return getHighlightStoryIdsObservable(rubinoProfileObject, str).flatMap(new Function<ProfileStoryInfo, ObservableSource<Integer>>() { // from class: ir.resaneh1.iptv.helper.StoryController.11
            @Override // io.reactivex.functions.Function
            public ObservableSource<Integer> apply(ProfileStoryInfo profileStoryInfo) throws Exception {
                int i3;
                ProfileStoryInfo[] profileStoryInfoArr2 = profileStoryInfoArr;
                profileStoryInfoArr2[0] = profileStoryInfo;
                profileStoryInfoArr2[0].highlightId = str;
                int i4 = i;
                if (i4 < 0) {
                    i4 = 0;
                }
                if (i2 > 0) {
                    for (int i5 = 0; i5 < i2 && (i3 = i4 + i5) < profileStoryInfo.storyIdsObject.size(); i5++) {
                        StoryIdObject storyIdObject = profileStoryInfo.storyIdsObject.get(i3);
                        if (!storyIdObject.isLocal && StoryController.this.getInstantStory(storyIdObject) == null) {
                            hashSet.add(storyIdObject.getIdOrRnd());
                        }
                    }
                }
                return StoryController.this.getHighlightLoadStoryObservable(str, hashSet, rubinoProfileObject.id, z);
            }
        }).flatMap(new Function<Integer, Observable<ProfileStoryInfo>>(this) { // from class: ir.resaneh1.iptv.helper.StoryController.10
            @Override // io.reactivex.functions.Function
            public Observable<ProfileStoryInfo> apply(Integer num) throws Exception {
                return Observable.just(profileStoryInfoArr[0]);
            }
        });
    }

    public void getProfileStoryIdsFromServer(final RubinoProfileObject rubinoProfileObject) {
        String str;
        if (rubinoProfileObject == null || (str = rubinoProfileObject.id) == null || this.loadingProfileStoryIds.contains(str)) {
            return;
        }
        if (rubinoProfileObject.id.equals(AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id)) {
            callGetMyStories();
        } else {
            this.loadingProfileStoryIds.add(rubinoProfileObject.id);
            this.compositeDisposable.add((Disposable) getApiRequestMessangerRx().getStoryIds(new GetStoryIdsInput(rubinoProfileObject.id, AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id)).observeOn(Schedulers.io()).subscribeWith(new DisposableObserver<MessangerOutput<GetStoryIdsOutput>>() { // from class: ir.resaneh1.iptv.helper.StoryController.12
                @Override // io.reactivex.Observer
                public void onNext(MessangerOutput<GetStoryIdsOutput> messangerOutput) {
                    StoryController.this.loadingProfileStoryIds.remove(rubinoProfileObject.id);
                    StoryController.this.onGetStoryIdsResponse(rubinoProfileObject, messangerOutput);
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                    StoryController.this.loadingProfileStoryIds.remove(rubinoProfileObject.id);
                    if ((th instanceof ApiServerException) && ((ApiServerException) th).status_det == MessangerOutput.EnumStatusDet.INVALID_AUTH) {
                        StoryController.this.addToProfileStoryStatusMap(rubinoProfileObject.id, ProfileStoryStatusEnum.NoStory);
                        StoryController.this.getNotificationCenter().postNotificationNameOnUIThread(NotificationCenter.storyListEmptyDetected, rubinoProfileObject.id);
                    }
                }

                @Override // io.reactivex.Observer
                public void onComplete() {
                    StoryController.this.loadingProfileStoryIds.remove(rubinoProfileObject.id);
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onGetStoryIdsResponse(RubinoProfileObject rubinoProfileObject, MessangerOutput<GetStoryIdsOutput> messangerOutput) {
        GetStoryIdsOutput getStoryIdsOutput;
        if (messangerOutput == null || (getStoryIdsOutput = messangerOutput.data) == null) {
            return;
        }
        addToProfileStoryIdsInfoMap(rubinoProfileObject.id, ProfileStoryInfo.createInfoFromOutput(rubinoProfileObject, null, getStoryIdsOutput, System.currentTimeMillis()));
        ProfileStoryInfo instantProfileStoryIdsWithLocalAndLoadIfNeeded = getInstantProfileStoryIdsWithLocalAndLoadIfNeeded(rubinoProfileObject, null);
        if (instantProfileStoryIdsWithLocalAndLoadIfNeeded != null) {
            ArrayList<StoryIdObject> arrayList = instantProfileStoryIdsWithLocalAndLoadIfNeeded.storyIdsObject;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList<StoryIdObject> arrayList2 = instantProfileStoryIdsWithLocalAndLoadIfNeeded.storyIdsObject;
                if (isStorySeen(arrayList2.get(arrayList2.size() - 1).getIdOrRnd(), rubinoProfileObject.id)) {
                    addToProfileStoryStatusMap(rubinoProfileObject.id, ProfileStoryStatusEnum.SeenStory);
                } else {
                    addToProfileStoryStatusMap(rubinoProfileObject.id, ProfileStoryStatusEnum.NotSeenStory);
                }
            } else {
                addToProfileStoryStatusMap(rubinoProfileObject.id, ProfileStoryStatusEnum.NoStory);
            }
            getNotificationCenter().postNotificationNameOnUIThread(NotificationCenter.allStoriesIsSeenChanged, new Object[0]);
            getNotificationCenter().postNotificationNameOnUIThread(NotificationCenter.profileStoryIdsDidLoad, instantProfileStoryIdsWithLocalAndLoadIfNeeded);
        }
    }

    public StoryObject getInstantStory(String str) {
        return getInstantStory(new StoryIdObject(str));
    }

    public StoryObject getInstantStory(StoryIdObject storyIdObject) {
        if (storyIdObject == null) {
            return null;
        }
        if (!storyIdObject.isLocal) {
            Map<String, StoryInfo> map = this.storyMap;
            if (map != null) {
                StoryInfo storyInfo = map.get(storyIdObject.id);
                MyLog.e("StoryMap", " storymap get " + storyIdObject.id);
                if (storyInfo != null && System.currentTimeMillis() - storyInfo.updateTime <= this.validStoryInfoDurationMillis) {
                    if (storyInfo.storyObject.hasNeedToUpdateWidget()) {
                        String str = storyInfo.storyObject.profile_id;
                        if (str == null || !str.equals(AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id)) {
                            if (System.currentTimeMillis() - storyInfo.updateTime <= this.validStoryWithWidgetMillis) {
                                return storyInfo.storyObject;
                            }
                            return null;
                        }
                        if (System.currentTimeMillis() - storyInfo.updateTime <= this.validMyStoryWithWidgetMillis) {
                            return storyInfo.storyObject;
                        }
                        return null;
                    }
                    return storyInfo.storyObject;
                }
            }
            return null;
        }
        return SendStoryHelper.getInstance(this.currentAccount).getLocalStory(storyIdObject.rndInt);
    }

    public StoryObject getInstantStoryEvenIfExpired(String str) {
        if (str == null) {
            return null;
        }
        try {
            Map<String, StoryInfo> map = this.storyMap;
            if (map != null) {
                StoryInfo storyInfo = map.get(str);
                MyLog.e("StoryMap", " storymap even expired get " + str);
                return storyInfo.storyObject;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public void loadStory(String str, ArrayList<String> arrayList, String str2, boolean z) {
        if (this.loadingStorySet.contains(str) || getInstantStory(str) != null) {
            return;
        }
        HashSet hashSet = new HashSet();
        hashSet.add(str);
        if (arrayList != null) {
            hashSet.addAll(arrayList);
        }
        this.compositeDisposable.add((Disposable) getLoadStoryObservable(hashSet, str2, z).subscribeWith(new DisposableObserver<Integer>(this) { // from class: ir.resaneh1.iptv.helper.StoryController.13
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onNext(Integer num) {
            }
        }));
    }

    public Observable<Integer> getLoadStoryObservable(final Set<String> set, final String str, final boolean z) {
        return Observable.just(0).observeOn(Schedulers.computation()).flatMap(new Function<Integer, ObservableSource<Integer>>() { // from class: ir.resaneh1.iptv.helper.StoryController.14
            @Override // io.reactivex.functions.Function
            public ObservableSource<Integer> apply(Integer num) throws Exception {
                if (set == null || str == null) {
                    return Observable.just(0);
                }
                final ArrayList arrayList = new ArrayList();
                for (String str2 : set) {
                    if (!StoryController.this.loadingStorySet.contains(str2) && StoryController.this.getInstantStory(str2) == null) {
                        arrayList.add(str2);
                    }
                }
                if (arrayList.size() > 0) {
                    StoryController.this.loadingStorySet.addAll(arrayList);
                    MyLog.e("StoryLogPreload", "StoryController getStory profileID " + str + " story ids " + arrayList.toString());
                    return StoryController.this.getApiRequestMessangerRx().getStory(new GetStoryInput(arrayList, str, AppRubinoPreferences.getInstance(((BaseController) StoryController.this).currentAccount).getRubinoCurrentProfileObject().id), z).observeOn(Schedulers.io()).doOnNext(new Consumer<MessangerOutput<GetStoryOutput>>() { // from class: ir.resaneh1.iptv.helper.StoryController.14.3
                        @Override // io.reactivex.functions.Consumer
                        public void accept(MessangerOutput<GetStoryOutput> messangerOutput) throws Exception {
                            GetStoryOutput getStoryOutput;
                            StoryController.this.loadingStorySet.removeAll(arrayList);
                            if (messangerOutput == null || (getStoryOutput = messangerOutput.data) == null || getStoryOutput.stories == null) {
                                return;
                            }
                            HashMap map = new HashMap();
                            Iterator<StoryObject> it = messangerOutput.data.stories.iterator();
                            while (it.hasNext()) {
                                StoryObject next = it.next();
                                next.makeData(((BaseController) StoryController.this).currentAccount);
                                MyLog.e("StoryLogPreload", "StoryController storyObjectLoaded profileID " + str + " storyid " + next.id);
                                map.put(next.id, Integer.valueOf(next.viewer_count));
                                AnonymousClass14 anonymousClass14 = AnonymousClass14.this;
                                StoryInfo storyInfoAddToStoryMap = StoryController.this.addToStoryMap(next, str);
                                if (storyInfoAddToStoryMap != null) {
                                    StoryController.this.getNotificationCenter().postNotificationNameOnUIThread(NotificationCenter.storyObjectDidLoad, storyInfoAddToStoryMap);
                                }
                            }
                            StoryController.this.updateSeenCount(map, true);
                        }
                    }).doOnError(new Consumer<Throwable>() { // from class: ir.resaneh1.iptv.helper.StoryController.14.2
                        @Override // io.reactivex.functions.Consumer
                        public void accept(Throwable th) throws Exception {
                            StoryController.this.loadingStorySet.removeAll(arrayList);
                        }
                    }).flatMap(new Function<MessangerOutput<GetStoryOutput>, ObservableSource<Integer>>(this) { // from class: ir.resaneh1.iptv.helper.StoryController.14.1
                        @Override // io.reactivex.functions.Function
                        public ObservableSource<Integer> apply(MessangerOutput<GetStoryOutput> messangerOutput) throws Exception {
                            return Observable.just(1);
                        }
                    });
                }
                return Observable.just(0);
            }
        }).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<Integer> getHighlightLoadStoryObservable(final String str, final Set<String> set, final String str2, final boolean z) {
        return Observable.just(0).observeOn(Schedulers.computation()).flatMap(new Function<Integer, ObservableSource<Integer>>() { // from class: ir.resaneh1.iptv.helper.StoryController.15
            @Override // io.reactivex.functions.Function
            public ObservableSource<Integer> apply(Integer num) throws Exception {
                if (set == null || str2 == null) {
                    return Observable.just(0);
                }
                final ArrayList<String> arrayList = new ArrayList<>();
                for (String str3 : set) {
                    if (!StoryController.this.loadingStorySet.contains(str3) && StoryController.this.getInstantStory(str3) == null) {
                        arrayList.add(str3);
                    }
                }
                if (arrayList.size() > 0) {
                    StoryController.this.loadingStorySet.addAll(arrayList);
                    MyLog.e("StoryLogPreload", "StoryController getStory profileID " + str2 + " story ids " + arrayList.toString());
                    Rubino.GetHighlightStoriesInput getHighlightStoriesInput = new Rubino.GetHighlightStoriesInput(StoryController.this.getRubinoController().getMyCurrentProfileID());
                    getHighlightStoriesInput.target_profile_id = str2;
                    getHighlightStoriesInput.story_ids = arrayList;
                    getHighlightStoriesInput.highlight_id = str;
                    return StoryController.this.getApiRequestMessangerRx().getHighlightStories(getHighlightStoriesInput, z).observeOn(Schedulers.io()).doOnNext(new Consumer<MessangerOutput<GetStoryOutput>>() { // from class: ir.resaneh1.iptv.helper.StoryController.15.3
                        @Override // io.reactivex.functions.Consumer
                        public void accept(MessangerOutput<GetStoryOutput> messangerOutput) throws Exception {
                            GetStoryOutput getStoryOutput;
                            StoryController.this.loadingStorySet.removeAll(arrayList);
                            if (messangerOutput == null || (getStoryOutput = messangerOutput.data) == null || getStoryOutput.stories == null) {
                                return;
                            }
                            HashMap map = new HashMap();
                            Iterator<StoryObject> it = messangerOutput.data.stories.iterator();
                            while (it.hasNext()) {
                                StoryObject next = it.next();
                                next.makeData(((BaseController) StoryController.this).currentAccount);
                                MyLog.e("StoryLogPreload", "StoryController storyObjectLoaded profileID " + str2 + " storyid " + next.id);
                                map.put(next.id, Integer.valueOf(next.viewer_count));
                                AnonymousClass15 anonymousClass15 = AnonymousClass15.this;
                                StoryInfo storyInfoAddToStoryMap = StoryController.this.addToStoryMap(next, str2);
                                if (storyInfoAddToStoryMap != null) {
                                    StoryController.this.getNotificationCenter().postNotificationNameOnUIThread(NotificationCenter.storyObjectDidLoad, storyInfoAddToStoryMap);
                                }
                            }
                            StoryController.this.updateSeenCount(map, true);
                        }
                    }).doOnError(new Consumer<Throwable>() { // from class: ir.resaneh1.iptv.helper.StoryController.15.2
                        @Override // io.reactivex.functions.Consumer
                        public void accept(Throwable th) throws Exception {
                            StoryController.this.loadingStorySet.removeAll(arrayList);
                        }
                    }).flatMap(new Function<MessangerOutput<GetStoryOutput>, ObservableSource<Integer>>(this) { // from class: ir.resaneh1.iptv.helper.StoryController.15.1
                        @Override // io.reactivex.functions.Function
                        public ObservableSource<Integer> apply(MessangerOutput<GetStoryOutput> messangerOutput) throws Exception {
                            return Observable.just(1);
                        }
                    });
                }
                return Observable.just(0);
            }
        }).observeOn(AndroidSchedulers.mainThread());
    }

    public void updateSeenCount(String str, int i, boolean z) {
        if (str == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put(str, Integer.valueOf(i));
        updateSeenCount(map, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSeenCount(Map<String, Integer> map, boolean z) {
        boolean z2 = false;
        for (String str : map.keySet()) {
            Integer num = this.storySeenCountMap.get(str);
            Integer num2 = map.get(str);
            if (num == null || num.intValue() < num2.intValue()) {
                this.storySeenCountMap.put(str, num2);
                z2 = true;
            }
        }
        if (z && z2) {
            getNotificationCenter().postNotificationNameOnUIThread(NotificationCenter.storySeenCountChange, new Object[0]);
        }
    }

    public void onAddNewStoryResponse(StoryObject storyObject) {
        String str;
        Map<String, ProfileStoryInfo> map;
        if (storyObject == null || storyObject.id == null || (str = storyObject.profile_id) == null || (map = this.profileIdStoryInfoMap) == null) {
            return;
        }
        ProfileStoryInfo profileStoryInfo = map.get(str);
        if (profileStoryInfo != null) {
            if (profileStoryInfo.storyIdsObject == null) {
                profileStoryInfo.storyIdsObject = new ArrayList<>();
            }
            profileStoryInfo.storyIdsObject.add(new StoryIdObject(storyObject.id));
        } else {
            ProfileStoryInfo profileStoryInfo2 = new ProfileStoryInfo();
            ArrayList<StoryIdObject> arrayList = new ArrayList<>();
            profileStoryInfo2.storyIdsObject = arrayList;
            arrayList.add(new StoryIdObject(storyObject.id));
            addToProfileStoryIdsInfoMap(storyObject.profile_id, profileStoryInfo2);
        }
        storyObject.makeData(this.currentAccount);
        addToStoryMap(storyObject, storyObject.profile_id);
        addToProfileStoryStatusMap(storyObject.profile_id, ProfileStoryStatusEnum.SeenStory);
        getNotificationCenter().postNotificationNameOnUIThread(NotificationCenter.myStoryAdded, storyObject);
    }

    public static class ProfileStoryInfo {
        public boolean canReply;
        public String chat_object_guid;
        public ChatType chat_object_type;
        public String highlightId;
        public RubinoProfileObject profileObject;
        public Set<String> seenStoryIds;
        public ArrayList<StoryIdObject> storyIdsObject;
        public long updateTime;

        public static ProfileStoryInfo createInfoFromOutput(RubinoProfileObject rubinoProfileObject, String str, GetStoryIdsOutput getStoryIdsOutput, long j) {
            ProfileStoryInfo profileStoryInfo = new ProfileStoryInfo();
            profileStoryInfo.profileObject = rubinoProfileObject;
            profileStoryInfo.highlightId = str;
            if (getStoryIdsOutput != null) {
                profileStoryInfo.storyIdsObject = new ArrayList<>();
                ArrayList<String> arrayList = getStoryIdsOutput.story_ids;
                if (arrayList != null) {
                    Iterator<String> it = arrayList.iterator();
                    while (it.hasNext()) {
                        profileStoryInfo.storyIdsObject.add(new StoryIdObject(it.next()));
                    }
                }
                profileStoryInfo.canReply = getStoryIdsOutput.can_reply;
                profileStoryInfo.chat_object_guid = getStoryIdsOutput.chat_object_guid;
                profileStoryInfo.chat_object_type = getStoryIdsOutput.chat_object_type;
                HashSet hashSet = new HashSet();
                profileStoryInfo.seenStoryIds = hashSet;
                hashSet.addAll(getStoryIdsOutput.seen_story_ids);
            }
            profileStoryInfo.updateTime = j;
            return profileStoryInfo;
        }

        public static ProfileStoryInfo createInfoFromMyStory(int i, RubinoProfileObject rubinoProfileObject, ArrayList<StoryObject> arrayList, long j) {
            ProfileStoryInfo profileStoryInfo = new ProfileStoryInfo();
            profileStoryInfo.profileObject = rubinoProfileObject;
            profileStoryInfo.storyIdsObject = new ArrayList<>();
            if (arrayList != null) {
                Iterator<StoryObject> it = arrayList.iterator();
                while (it.hasNext()) {
                    StoryObject next = it.next();
                    StoryController.getInstance(i).storySeenCountMap.put(next.id, Integer.valueOf(next.viewer_count));
                    next.profile_id = rubinoProfileObject.id;
                    StoryIdObject storyIdObject = new StoryIdObject(next.id);
                    storyIdObject.storyAbsObject = next;
                    profileStoryInfo.storyIdsObject.add(storyIdObject);
                }
            }
            profileStoryInfo.seenStoryIds = new HashSet();
            profileStoryInfo.updateTime = j;
            return profileStoryInfo;
        }

        public void addOrUpdateLocalStories(ArrayList<StoryObject> arrayList) {
            if (this.storyIdsObject == null) {
                this.storyIdsObject = new ArrayList<>();
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator<StoryIdObject> it = this.storyIdsObject.iterator();
            while (it.hasNext()) {
                StoryIdObject next = it.next();
                if (next.isLocal) {
                    arrayList2.add(next);
                }
            }
            this.storyIdsObject.removeAll(arrayList2);
            if (arrayList != null) {
                Iterator<StoryObject> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    this.storyIdsObject.add(new StoryIdObject(it2.next().rnd));
                }
            }
        }

        public void removeId(String str) {
            ArrayList<StoryIdObject> arrayList = this.storyIdsObject;
            if (arrayList != null) {
                Iterator<StoryIdObject> it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    StoryIdObject next = it.next();
                    if (next.getIdOrRnd().equals(str)) {
                        this.storyIdsObject.remove(next);
                        break;
                    }
                }
            }
            Set<String> set = this.seenStoryIds;
            if (set != null) {
                for (String str2 : set) {
                    if (str2.equals(str)) {
                        this.seenStoryIds.remove(str2);
                        return;
                    }
                }
            }
        }

        public ArrayList<String> getNextStoryIds(int i) {
            return getNextStoryIdsWithoutLocal(i, 10);
        }

        public ArrayList<String> getNextStoryIdsWithoutLocal(int i, int i2) {
            ArrayList<StoryIdObject> arrayList = this.storyIdsObject;
            if (arrayList == null) {
                return null;
            }
            if (i >= arrayList.size() - 1) {
                return null;
            }
            ArrayList<String> arrayList2 = new ArrayList<>();
            for (int i3 = 1; i3 <= i2; i3++) {
                int i4 = i + i3;
                if (i4 >= this.storyIdsObject.size() || i4 < 0) {
                    break;
                }
                StoryIdObject storyIdObject = this.storyIdsObject.get(i4);
                if (storyIdObject != null && !storyIdObject.isLocal) {
                    arrayList2.add(storyIdObject.getIdOrRnd());
                }
            }
            return arrayList2;
        }
    }

    public ArrayList<StoryObject> getMyStoryAbsObjectTryFromMap() {
        ProfileStoryInfo profileStoryInfo;
        ArrayList<StoryIdObject> arrayList;
        ArrayList<StoryObject> arrayList2 = new ArrayList<>();
        Map<String, ProfileStoryInfo> map = this.profileIdStoryInfoMap;
        if (map != null && (profileStoryInfo = map.get(AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id)) != null && (arrayList = profileStoryInfo.storyIdsObject) != null) {
            Iterator<StoryIdObject> it = arrayList.iterator();
            while (it.hasNext()) {
                StoryIdObject next = it.next();
                StoryObject instantStory = getInstantStory(next);
                if (instantStory != null) {
                    arrayList2.add(instantStory);
                } else {
                    StoryObject storyObject = next.storyAbsObject;
                    if (storyObject != null) {
                        arrayList2.add(storyObject);
                    }
                }
            }
        }
        return arrayList2;
    }

    public ArrayList<StoryObject> getHighlightStoryAbsObjectTryFromMap(String str) {
        ProfileStoryInfo profileStoryInfo;
        ArrayList<StoryIdObject> arrayList;
        ArrayList<StoryObject> arrayList2 = new ArrayList<>();
        Map<String, ProfileStoryInfo> map = this.highlightIdStoryInfoMap;
        if (map != null && (profileStoryInfo = map.get(str)) != null && (arrayList = profileStoryInfo.storyIdsObject) != null) {
            Iterator<StoryIdObject> it = arrayList.iterator();
            while (it.hasNext()) {
                StoryIdObject next = it.next();
                StoryObject instantStory = getInstantStory(next);
                if (instantStory != null) {
                    arrayList2.add(instantStory);
                } else {
                    StoryObject storyObject = next.storyAbsObject;
                    if (storyObject != null) {
                        arrayList2.add(storyObject);
                    }
                }
            }
        }
        return arrayList2;
    }

    public static class StoryIdObject {
        private String id;
        public boolean isLocal = true;
        private int rndInt;
        public StoryObject storyAbsObject;

        public boolean equals(Object obj) {
            if (obj != null && (obj instanceof StoryIdObject)) {
                StoryIdObject storyIdObject = (StoryIdObject) obj;
                boolean z = storyIdObject.isLocal;
                if (z && this.isLocal) {
                    return this.rndInt == storyIdObject.rndInt;
                }
                if (!z && !this.isLocal) {
                    return this.id.equals(storyIdObject.id);
                }
            }
            return false;
        }

        public StoryIdObject(String str) {
            this.id = str;
        }

        public StoryIdObject(int i) {
            this.rndInt = i;
        }

        public String getIdOrRnd() {
            if (this.isLocal) {
                return this.rndInt + BuildConfig.FLAVOR;
            }
            return this.id;
        }
    }

    public static class StoryInfo {
        public StoryObject storyObject;
        public long updateTime;

        public StoryInfo(String str, StoryObject storyObject, long j) {
            this.storyObject = storyObject;
            this.updateTime = j;
        }
    }

    public void deleteStory(StoryObject storyObject, String str) {
        if (str == null || str.isEmpty()) {
            deleteStory(storyObject);
        } else {
            getRubinoController().deleteStoryFromHighlight(str, storyObject);
        }
    }

    private void deleteStory(final StoryObject storyObject) {
        if (storyObject == null) {
            return;
        }
        if (storyObject.isLocal) {
            SendStoryHelper.getInstance(this.currentAccount).cancelSendLocalStory(storyObject);
        } else if (ApplicationLoader.applicationActivity != null) {
            ApplicationLoader.applicationActivity.mainCompositeDisposable.add((Disposable) getApiRequestMessangerRx().deleteStory(new DeleteStoryInput(storyObject.id, storyObject.profile_id)).observeOn(Schedulers.computation()).subscribeWith(new DisposableObserver<MessangerOutput<DeleteStoryOutput>>() { // from class: ir.resaneh1.iptv.helper.StoryController.16
                @Override // io.reactivex.Observer
                public void onComplete() {
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                }

                @Override // io.reactivex.Observer
                public void onNext(MessangerOutput<DeleteStoryOutput> messangerOutput) {
                    ProfileStoryInfo profileStoryInfo;
                    if (StoryController.this.storyMap != null) {
                        try {
                            StoryController.this.storyMap.remove(storyObject.id);
                        } catch (Exception unused) {
                        }
                    }
                    Map<String, ProfileStoryInfo> map = StoryController.this.profileIdStoryInfoMap;
                    if (map != null && (profileStoryInfo = map.get(storyObject.profile_id)) != null) {
                        profileStoryInfo.removeId(storyObject.id);
                    }
                    StoryController.this.getNotificationCenter().postNotificationNameOnUIThread(NotificationCenter.myStoryDeleted, storyObject);
                }
            }));
        }
    }

    public void setProfileStoryStatus(Map<String, ProfileStoryStatusEnum> map, String str) {
        ProfileStoryStatusEnum profileStoryStatusEnum;
        if (map == null || (profileStoryStatusEnum = map.get(str)) == null) {
            return;
        }
        if (profileStoryStatusEnum == ProfileStoryStatusEnum.NotSeenStory && str.equals(AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id)) {
            profileStoryStatusEnum = ProfileStoryStatusEnum.SeenStory;
        }
        addToProfileStoryStatusMap(str, profileStoryStatusEnum);
    }

    public void addStorySeen(String str, String str2) {
        StoryIdObject storyIdObject;
        Set<String> set;
        ProfileStoryInfo profileStoryInfo = this.profileIdStoryInfoMap.get(str2);
        if (profileStoryInfo == null || (set = profileStoryInfo.seenStoryIds) == null || !set.contains(str)) {
            Set<String> hashSet = this.profileIdToSendSeenIdsMap.get(str2);
            if (hashSet == null) {
                hashSet = new HashSet<>();
            }
            hashSet.add(str);
            this.profileIdToSendSeenIdsMap.put(str2, hashSet);
            if (profileStoryInfo != null) {
                storyIdObject = profileStoryInfo.storyIdsObject.get(r4.size() - 1);
            } else {
                storyIdObject = null;
            }
            if (storyIdObject != null && isStorySeen(storyIdObject.getIdOrRnd(), str2)) {
                addToProfileStoryStatusMap(str2, ProfileStoryStatusEnum.SeenStory);
            } else {
                addToProfileStoryStatusMap(str2, ProfileStoryStatusEnum.NotSeenStory);
            }
            getNotificationCenter().postNotificationNameOnUIThread(NotificationCenter.allStoriesIsSeenChanged, new Object[0]);
            if (hashSet.size() > 20) {
                callStorySeen(hashSet, str2);
            }
        }
    }

    public void sendSeenStoryIdsIfNeeded(String str) {
        Set<String> set = this.profileIdToSendSeenIdsMap.get(str);
        if (set != null) {
            callStorySeen(set, str);
        }
    }

    private void callStorySeen(Set<String> set, final String str) {
        if (set == null || set.size() == 0 || str == null) {
            return;
        }
        final ProfileStoryInfo profileStoryInfo = this.profileIdStoryInfoMap.get(str);
        final HashSet hashSet = new HashSet();
        if (profileStoryInfo != null) {
            for (String str2 : set) {
                if (!profileStoryInfo.seenStoryIds.contains(str2)) {
                    hashSet.add(str2);
                }
            }
        } else {
            hashSet.addAll(set);
        }
        if (hashSet.size() == 0) {
            return;
        }
        this.compositeDisposable.add((Disposable) getApiRequestMessangerRx().addViewStory(new AddViewStoryInput(AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id, hashSet, str)).subscribeWith(new DisposableObserver<MessangerOutput<AddViewStoryOutput>>() { // from class: ir.resaneh1.iptv.helper.StoryController.17
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput<AddViewStoryOutput> messangerOutput) {
                Set set2 = (Set) StoryController.this.profileIdToSendSeenIdsMap.get(str);
                if (set2 != null) {
                    set2.removeAll(hashSet);
                }
                ProfileStoryInfo profileStoryInfo2 = profileStoryInfo;
                if (profileStoryInfo2 != null) {
                    if (profileStoryInfo2.seenStoryIds == null) {
                        profileStoryInfo2.seenStoryIds = new HashSet();
                    }
                    profileStoryInfo.seenStoryIds.addAll(hashSet);
                }
            }
        }));
    }

    public StoryListOfAProfileObject createMyProfileStoryAndGetFromServer(boolean z) {
        StoryListOfAProfileObject storyListOfAProfileObject = new StoryListOfAProfileObject(this.currentAccount);
        RubinoProfileObject rubinoCurrentProfileObject = AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject();
        storyListOfAProfileObject.profileObject = rubinoCurrentProfileObject;
        storyListOfAProfileObject.info = this.profileIdStoryInfoMap.get(rubinoCurrentProfileObject.id);
        if (z) {
            getProfileStoryIdsFromServer(storyListOfAProfileObject.profileObject);
        }
        return storyListOfAProfileObject;
    }

    public Observable<Rubino.ProfilesStoriesListObject> getStoryObservable(final boolean z, String str, final ArrayList<StoryListOfAProfileObject> arrayList) {
        ApiRequestMessangerRx apiRequestMessangerRx = getApiRequestMessangerRx();
        String str2 = AppRubinoPreferences.getInstance(this.currentAccount).getInstaCurrentProfileObject().id;
        if (z) {
            str = null;
        }
        return apiRequestMessangerRx.getProfilesStories(new GetProfilesStoriesInput(str2, 100, str)).observeOn(Schedulers.computation()).flatMap(new Function<MessangerOutput<GetProfilesStoriesOutput>, ObservableSource<Rubino.ProfilesStoriesListObject>>() { // from class: ir.resaneh1.iptv.helper.StoryController.18
            @Override // io.reactivex.functions.Function
            public ObservableSource<Rubino.ProfilesStoriesListObject> apply(MessangerOutput<GetProfilesStoriesOutput> messangerOutput) throws Exception {
                ArrayList arrayList2;
                Rubino.ProfilesStoriesListObject profilesStoriesListObject = new Rubino.ProfilesStoriesListObject();
                if (messangerOutput != null && messangerOutput.data != null) {
                    ArrayList<StoryListOfAProfileObject> arrayList3 = new ArrayList<>();
                    profilesStoriesListObject.profiles = arrayList3;
                    if (messangerOutput.data.profiles != null) {
                        if (!z && (arrayList2 = arrayList) != null) {
                            arrayList3.addAll(arrayList2);
                        }
                        if (z) {
                            StoryController.getInstance(((BaseController) StoryController.this).currentAccount).clearLoadingMaps();
                            Map<String, ProfileStoryInfo> map = StoryController.this.profileIdStoryInfoMap;
                            if (map != null) {
                                map.clear();
                            }
                            if (StoryController.this.profileIdStoryStatusMap != null) {
                                StoryController.this.profileIdStoryStatusMap.clear();
                            }
                            if (StoryController.this.storyMap != null) {
                                StoryController.this.storyMap.clear();
                            }
                        }
                        Iterator<RubinoProfileObject> it = messangerOutput.data.profiles.iterator();
                        while (it.hasNext()) {
                            RubinoProfileObject next = it.next();
                            StoryListOfAProfileObject storyListOfAProfileObject = new StoryListOfAProfileObject(((BaseController) StoryController.this).currentAccount);
                            storyListOfAProfileObject.profileObject = next;
                            profilesStoriesListObject.profiles.add(storyListOfAProfileObject);
                            GetProfilesStoriesOutput getProfilesStoriesOutput = messangerOutput.data;
                            if (getProfilesStoriesOutput.seen_profile_ids != null && getProfilesStoriesOutput.seen_profile_ids.contains(next.id)) {
                                StoryController.this.addToProfileStoryStatusMap(next.id, ProfileStoryStatusEnum.SeenStory);
                            } else {
                                StoryController.this.addToProfileStoryStatusMap(next.id, ProfileStoryStatusEnum.NotSeenStory);
                            }
                        }
                    }
                    GetProfilesStoriesOutput getProfilesStoriesOutput2 = messangerOutput.data;
                    if (getProfilesStoriesOutput2.live_profiles != null) {
                        profilesStoriesListObject.liveProfileCount = 0;
                        Iterator<RubinoProfileObject> it2 = getProfilesStoriesOutput2.live_profiles.iterator();
                        while (it2.hasNext()) {
                            RubinoProfileObject next2 = it2.next();
                            StoryListOfAProfileObject storyListOfAProfileObject2 = new StoryListOfAProfileObject(((BaseController) StoryController.this).currentAccount);
                            storyListOfAProfileObject2.profileObject = next2;
                            storyListOfAProfileObject2.isLive = true;
                            StoryController.this.setProfileHasLive(next2, true, false);
                            profilesStoriesListObject.profiles.add(0, storyListOfAProfileObject2);
                            profilesStoriesListObject.liveProfileCount++;
                        }
                    }
                    Collections.sort(profilesStoriesListObject.profiles, StoryController.this.storyComparator);
                    if ((profilesStoriesListObject.profiles.size() <= 0 || !profilesStoriesListObject.profiles.get(0).isMyStory() || profilesStoriesListObject.profiles.get(0).isLive) && RubinoController.getInstance(((BaseController) StoryController.this).currentAccount).hasPermissionAddStory()) {
                        StoryListOfAProfileObject storyListOfAProfileObject3 = new StoryListOfAProfileObject(((BaseController) StoryController.this).currentAccount);
                        RubinoProfileObject rubinoCurrentProfileObject = AppRubinoPreferences.getInstance(((BaseController) StoryController.this).currentAccount).getRubinoCurrentProfileObject();
                        storyListOfAProfileObject3.profileObject = rubinoCurrentProfileObject;
                        StoryController.this.addToProfileStoryStatusMap(rubinoCurrentProfileObject.id, ProfileStoryStatusEnum.NoStory);
                        profilesStoriesListObject.profiles.add(0, storyListOfAProfileObject3);
                    }
                    profilesStoriesListObject.next_start_id = messangerOutput.data.next_start_id;
                }
                return Observable.just(profilesStoriesListObject);
            }
        });
    }

    public Observable<GetProfilesStoryListOutput> getProfilesStoryListObservableForMessenger(final Collection<StoryProfileStoryId> collection) {
        return Observable.just(0).observeOn(Schedulers.computation()).flatMap(new Function<Integer, ObservableSource<GetProfilesStoryListOutput>>() { // from class: ir.resaneh1.iptv.helper.StoryController.20
            @Override // io.reactivex.functions.Function
            public ObservableSource<GetProfilesStoryListOutput> apply(Integer num) throws Exception {
                Collection collection2 = collection;
                if (collection2 == null || collection2.size() == 0) {
                    return Observable.just(new GetProfilesStoryListOutput());
                }
                GetProfilesStoryListInput getProfilesStoryListInput = new GetProfilesStoryListInput(AppRubinoPreferences.getInstance(((BaseController) StoryController.this).currentAccount).getRubinoCurrentProfileObject().id);
                getProfilesStoryListInput.profile_story_ids = collection;
                return StoryController.this.getApiRequestMessangerRx().getProfilesStoryList(getProfilesStoryListInput).observeOn(Schedulers.io()).flatMap(new Function<MessangerOutput<GetProfilesStoryListOutput>, Observable<GetProfilesStoryListOutput>>() { // from class: ir.resaneh1.iptv.helper.StoryController.20.1
                    @Override // io.reactivex.functions.Function
                    public Observable<GetProfilesStoryListOutput> apply(MessangerOutput<GetProfilesStoryListOutput> messangerOutput) throws Exception {
                        GetProfilesStoryListOutput getProfilesStoryListOutput;
                        if (messangerOutput != null && (getProfilesStoryListOutput = messangerOutput.data) != null && getProfilesStoryListOutput.stories != null) {
                            Iterator<StoryObject> it = getProfilesStoryListOutput.stories.iterator();
                            while (it.hasNext()) {
                                it.next().makeData(((BaseController) StoryController.this).currentAccount);
                            }
                        }
                        return Observable.just(messangerOutput.data);
                    }
                });
            }
        }).observeOn(AndroidSchedulers.mainThread());
    }
}
