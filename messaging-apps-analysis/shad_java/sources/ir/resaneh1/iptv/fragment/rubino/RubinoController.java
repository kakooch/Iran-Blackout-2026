package ir.resaneh1.iptv.fragment.rubino;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
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
import ir.aaap.messengercore.utilites.Objects;
import ir.appp.rghapp.rubinoPostSlider.ExploreVideoPlayer;
import ir.appp.rghapp.rubinoPostSlider.VideoPlayer;
import ir.medu.shad.R;
import ir.resaneh1.iptv.UIView.UILinearLayout;
import ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx;
import ir.resaneh1.iptv.apiMessanger.ApiServerException;
import ir.resaneh1.iptv.dialog.JustLinearLayoutDialog;
import ir.resaneh1.iptv.dialog.LoadingDialog;
import ir.resaneh1.iptv.fragment.InstaNewEventsFragment;
import ir.resaneh1.iptv.fragment.RubinoEditPostActivity;
import ir.resaneh1.iptv.helper.AppRubinoPreferences;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.helper.SpanHelper;
import ir.resaneh1.iptv.helper.StoryController;
import ir.resaneh1.iptv.helper.ToastiLikeSnack;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.EmojiSliderResultObject;
import ir.resaneh1.iptv.model.GetEmojiResultsInput;
import ir.resaneh1.iptv.model.GetPollResultProfilesInput;
import ir.resaneh1.iptv.model.GetStoryIdsOutput;
import ir.resaneh1.iptv.model.GetStoryOutput;
import ir.resaneh1.iptv.model.ListInput;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.model.Rubino;
import ir.resaneh1.iptv.model.RubinoCommentObject;
import ir.resaneh1.iptv.model.RubinoPostObject;
import ir.resaneh1.iptv.model.RubinoPostPosition;
import ir.resaneh1.iptv.model.RubinoProfileObject;
import ir.resaneh1.iptv.model.StoryObject;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.BaseController;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.LaunchActivity;

/* loaded from: classes3.dex */
public class RubinoController extends BaseController {
    public Map<String, Rubino.ActionOnRequestTypeEnum> actionOnRequestMap;
    private final Map<String, DisposableObserver> blockObserverMap;
    private final Map<String, Boolean> blockedProfileMap;
    private final Map<String, DisposableObserver> bookmarkPostObserverMap;
    private CompositeDisposable compositeDisposable;
    private final Map<String, DisposableObserver> followObserverMap;
    private final Map<String, Boolean> followRequestedProfileMap;
    private final Map<String, Boolean> followedProfileMap;
    public Map<String, DisposableObserver> getProfileObserverMap;
    private final Map<String, DisposableObserver> likeCommentObserverMap;
    private final Map<String, DisposableObserver> likePostObserverMap;
    private final Map<String, RubinoPostObject> postMap;
    public Map<String, RubinoProfileObject> profileForTagsMap;
    private final Object profileLock;
    public Map<String, RubinoProfileObject> profileMap;
    public static Queue<VideoPlayer> shouldReleasePlayers = new ArrayDeque();
    public static Queue<ExploreVideoPlayer> shouldReleasePlayersInExplore = new ArrayDeque();
    private static final RubinoController[] Instance = new RubinoController[3];

    public static RubinoController getInstance(int i) {
        RubinoController[] rubinoControllerArr = Instance;
        RubinoController rubinoController = rubinoControllerArr[i];
        if (rubinoController == null) {
            synchronized (RubinoController.class) {
                rubinoController = rubinoControllerArr[i];
                if (rubinoController == null) {
                    rubinoController = new RubinoController(i);
                    rubinoControllerArr[i] = rubinoController;
                }
            }
        }
        return rubinoController;
    }

    RubinoController(int i) {
        super(i);
        this.getProfileObserverMap = new HashMap();
        this.profileMap = new HashMap();
        this.profileLock = new Object();
        this.followObserverMap = new HashMap();
        this.likePostObserverMap = new HashMap();
        this.likeCommentObserverMap = new HashMap();
        this.bookmarkPostObserverMap = new HashMap();
        this.blockObserverMap = new HashMap();
        this.blockedProfileMap = new HashMap();
        this.followedProfileMap = new HashMap();
        this.followRequestedProfileMap = new HashMap();
        this.postMap = new HashMap();
        this.actionOnRequestMap = new HashMap();
        this.compositeDisposable = new CompositeDisposable();
        this.profileForTagsMap = new HashMap();
    }

    public void releaseExistingCachedPlayers() {
        while (!shouldReleasePlayers.isEmpty()) {
            VideoPlayer videoPlayerPoll = shouldReleasePlayers.poll();
            if (videoPlayerPoll != null) {
                videoPlayerPoll.releasePlayer();
            }
        }
    }

    /* renamed from: ir.resaneh1.iptv.fragment.rubino.RubinoController$1, reason: invalid class name */
    class AnonymousClass1 implements View.OnClickListener {
        final /* synthetic */ CompositeDisposable val$compositeDisposable;
        final /* synthetic */ int val$currentAccount;
        final /* synthetic */ String val$eventId;
        final /* synthetic */ String val$eventProfileId;

        AnonymousClass1(CompositeDisposable compositeDisposable, int i, String str, String str2) {
            this.val$compositeDisposable = compositeDisposable;
            this.val$currentAccount = i;
            this.val$eventId = str;
            this.val$eventProfileId = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RubinoController.showRubinoCenterDialog(true, new SpannableString(LocaleController.getString(R.string.rubinoDeleteNewEventNotificationQuestion)), LocaleController.getString(R.string.rubinoDeleteNewEventNotification), new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.1.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    CompositeDisposable compositeDisposable = anonymousClass1.val$compositeDisposable;
                    ApiRequestMessangerRx apiRequestMessangerRx = ApiRequestMessangerRx.getInstance(anonymousClass1.val$currentAccount);
                    AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                    compositeDisposable.add((Disposable) apiRequestMessangerRx.removeNotification(new Rubino.RemoveNotificationInput(anonymousClass12.val$eventId, anonymousClass12.val$eventProfileId)).subscribeWith(new DisposableObserver<MessangerOutput>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.1.1.1
                        @Override // io.reactivex.Observer
                        public void onComplete() {
                        }

                        @Override // io.reactivex.Observer
                        public void onError(Throwable th) {
                        }

                        @Override // io.reactivex.Observer
                        public void onNext(MessangerOutput messangerOutput) {
                            NotificationCenter.getInstance(AnonymousClass1.this.val$currentAccount).postNotificationName(NotificationCenter.rubinoNewEventDeleted, AnonymousClass1.this.val$eventId);
                        }
                    }));
                }
            });
        }
    }

    public static void removeNewEvent(int i, Context context, CompositeDisposable compositeDisposable, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Rubino.AlertItem(LocaleController.getString(R.string.rubinoDeleteNewEventNotification), 0, new AnonymousClass1(compositeDisposable, i, str, str2)));
        showRubinoCenterDialog(null, arrayList);
    }

    public static void openNewEventActivity(int i) {
        if (ApplicationLoader.applicationActivity != null) {
            RubinoProfileObject rubinoCurrentProfileObject = AppRubinoPreferences.getInstance(i).getRubinoCurrentProfileObject();
            if (!rubinoCurrentProfileObject.isPrivate()) {
                rubinoCurrentProfileObject.new_follow_request_count = 0;
            }
            rubinoCurrentProfileObject.new_general_count = 0;
            NotificationCenter.getInstance(i).postNotificationName(NotificationCenter.rubinoMyProfileNotifCountChange, new Object[0]);
            ApplicationLoader.applicationActivity.lambda$runLinkRequest$40(new RubinoNewEventActivity(RubinoNewEventActivity.eventType));
        }
    }

    public Observable<Rubino.ProfileListObject> getProfileByIdsObservable(ArrayList<String> arrayList) {
        Rubino.GetProfileByIdsInput getProfileByIdsInput = new Rubino.GetProfileByIdsInput(getMyCurrentProfileID());
        getProfileByIdsInput.profile_ids = arrayList;
        return getApiRequestMessangerRx().getProfileByIds(getProfileByIdsInput).observeOn(Schedulers.computation()).flatMap(new Function<MessangerOutput<Rubino.GetProfileListOutput>, ObservableSource<Rubino.ProfileListObject>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.2
            @Override // io.reactivex.functions.Function
            public ObservableSource<Rubino.ProfileListObject> apply(MessangerOutput<Rubino.GetProfileListOutput> messangerOutput) throws Exception {
                return Observable.just(RubinoController.this.makeProfileList(messangerOutput.data));
            }
        }).observeOn(AndroidSchedulers.mainThread()).doOnNext(new Consumer() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                this.f$0.lambda$getProfileByIdsObservable$0((Rubino.ProfileListObject) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getProfileByIdsObservable$0(Rubino.ProfileListObject profileListObject) throws Exception {
        ArrayList<RubinoProfileObject> arrayList;
        if (profileListObject == null || (arrayList = profileListObject.profiles) == null) {
            return;
        }
        Iterator<RubinoProfileObject> it = arrayList.iterator();
        while (it.hasNext()) {
            RubinoProfileObject next = it.next();
            this.profileForTagsMap.put(next.id, next);
        }
    }

    public RubinoProfileObject getTaggedRubinoProfileObject(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.profileForTagsMap.get(str);
    }

    public Observable<Rubino.ProfileListObject> getSearchProfilesForTagObservable(String str, String str2, int i) {
        Rubino.GetProfileForTagListInput getProfileForTagListInput = new Rubino.GetProfileForTagListInput(getMyCurrentProfileID());
        getProfileForTagListInput.search_text = !TextUtils.isEmpty(str) ? str.replace("@", BuildConfig.FLAVOR) : null;
        return getApiRequestMessangerRx().rubinoSearchProfilesForTag(getProfileForTagListInput).observeOn(Schedulers.computation()).flatMap(new Function<MessangerOutput<Rubino.GetProfileForTagListOutput>, ObservableSource<Rubino.ProfileListObject>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.3
            @Override // io.reactivex.functions.Function
            public ObservableSource<Rubino.ProfileListObject> apply(MessangerOutput<Rubino.GetProfileForTagListOutput> messangerOutput) throws Exception {
                return Observable.just(RubinoController.this.makeProfileList(messangerOutput.data));
            }
        });
    }

    public Observable<Rubino.PostObjectList> getTagPostsObservable(String str, String str2) {
        return getTaggedPostsObservable(str, str2);
    }

    private Observable<Rubino.PostObjectList> getTaggedPostsObservable(String str, String str2) {
        Rubino.GetListInput getListInput = new Rubino.GetListInput(AppRubinoPreferences.getInstance(this.currentAccount).getInstaCurrentProfileObject().id);
        getListInput.target_profile_id = str;
        getListInput.start_id = str2;
        return getApiRequestMessangerRx().getTaggedPosts(getListInput).observeOn(Schedulers.computation()).flatMap(new Function<MessangerOutput<Rubino.GetPostsOutput>, ObservableSource<Rubino.PostObjectList>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.4
            @Override // io.reactivex.functions.Function
            public ObservableSource<Rubino.PostObjectList> apply(MessangerOutput<Rubino.GetPostsOutput> messangerOutput) throws Exception {
                return Observable.just(RubinoController.this.makePostObjectList(messangerOutput.data));
            }
        }).observeOn(AndroidSchedulers.mainThread());
    }

    public RubinoProfileObject getInstantProfileInfoIfExistFromMap(String str) {
        if (str == null) {
            return null;
        }
        return this.profileMap.get(str);
    }

    public void deleteHighlight(final Rubino.StoryHighlight storyHighlight) {
        if (ApplicationLoader.applicationActivity == null) {
            return;
        }
        showRubinoCenterDialog(true, SpanHelper.makeWithColorAndRelativeSize(LocaleController.getString(R.string.rubinoDeleteHighLightQuestion), Theme.getColor(Theme.key_rubinoBlackColor), 1.5f), LocaleController.getString(R.string.rubinoDelete), new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                final String myCurrentProfileID = RubinoController.this.getMyCurrentProfileID();
                Rubino.RemoveHighlightCollectionInput removeHighlightCollectionInput = new Rubino.RemoveHighlightCollectionInput(myCurrentProfileID);
                removeHighlightCollectionInput.highlight_id = storyHighlight.highlight_id;
                RubinoController.this.compositeDisposable.add((Disposable) ApiRequestMessangerRx.getInstance(((BaseController) RubinoController.this).currentAccount).removeHighlightCollection(removeHighlightCollectionInput).subscribeWith(new DisposableObserver<MessangerOutput>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.5.1
                    @Override // io.reactivex.Observer
                    public void onComplete() {
                    }

                    @Override // io.reactivex.Observer
                    public void onError(Throwable th) {
                    }

                    @Override // io.reactivex.Observer
                    public void onNext(MessangerOutput messangerOutput) {
                        StoryController.getInstance(((BaseController) RubinoController.this).currentAccount).onHighlightChanged(storyHighlight.highlight_id);
                        NotificationCenter.getInstance(((BaseController) RubinoController.this).currentAccount).postNotificationName(NotificationCenter.highlightDeleted, myCurrentProfileID);
                    }
                }));
            }
        });
    }

    public Observable<Rubino.PostObjectList> getRecentFollowingPostsObservable(String str, String str2, int i, Rubino.SortEnum sortEnum) {
        Rubino.GetListInput getListInput = new Rubino.GetListInput(AppRubinoPreferences.getInstance(this.currentAccount).getInstaCurrentProfileObject().id);
        getListInput.limit = i;
        if (str2 != null && !str2.equals(BuildConfig.FLAVOR)) {
            getListInput.max_id = str2;
        }
        if (str != null && !str.equals(BuildConfig.FLAVOR)) {
            getListInput.min_id = str;
        }
        getListInput.sort = sortEnum;
        return getApiRequestMessangerRx().getRecentFollowingPosts(getListInput).observeOn(Schedulers.computation()).flatMap(new Function<MessangerOutput<Rubino.GetPostsOutput>, ObservableSource<Rubino.PostObjectList>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.6
            @Override // io.reactivex.functions.Function
            public ObservableSource<Rubino.PostObjectList> apply(final MessangerOutput<Rubino.GetPostsOutput> messangerOutput) throws Exception {
                return Observable.just(RubinoController.this.makePostObjectList(messangerOutput.data)).flatMap(new Function<Rubino.PostObjectList, ObservableSource<Rubino.PostObjectList>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.6.1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // io.reactivex.functions.Function
                    public ObservableSource<Rubino.PostObjectList> apply(Rubino.PostObjectList postObjectList) throws Exception {
                        ArrayList<RubinoPostObject> arrayList;
                        if (postObjectList != null && (arrayList = postObjectList.posts) != null) {
                            Iterator<RubinoPostObject> it = arrayList.iterator();
                            while (it.hasNext()) {
                                RubinoPostObject next = it.next();
                                if (((Rubino.GetPostsOutput) messangerOutput.data).profile_story_status != null) {
                                    RubinoController.this.getStoryController().setProfileStoryStatus(((Rubino.GetPostsOutput) messangerOutput.data).profile_story_status, next.post.profile_id);
                                }
                            }
                        }
                        return Observable.just(postObjectList);
                    }
                });
            }
        });
    }

    public Observable<Rubino.NewEventsListObject> getNewEventObservable(String str, int i) {
        Rubino.GetListInput getListInput = new Rubino.GetListInput(AppRubinoPreferences.getInstance(this.currentAccount).getInstaCurrentProfileObject().id);
        getListInput.limit = i;
        if (str != null && !str.equals(BuildConfig.FLAVOR)) {
            getListInput.max_id = str;
        }
        return getApiRequestMessangerRx().getNewEvents(getListInput).observeOn(Schedulers.computation()).flatMap(new Function<MessangerOutput<Rubino.GetNewEventsOutput>, ObservableSource<Rubino.NewEventsListObject>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.7
            @Override // io.reactivex.functions.Function
            public ObservableSource<Rubino.NewEventsListObject> apply(MessangerOutput<Rubino.GetNewEventsOutput> messangerOutput) throws Exception {
                return Observable.just(RubinoController.this.makeNewEventList(messangerOutput.data));
            }
        });
    }

    public Observable<Rubino.ProfileListObject> getBlockedProfilesObservable(String str, int i) {
        Rubino.GetListInput getListInput = new Rubino.GetListInput(AppRubinoPreferences.getInstance(this.currentAccount).getInstaCurrentProfileObject().id);
        getListInput.limit = i;
        if (str != null && !str.equals(BuildConfig.FLAVOR)) {
            getListInput.max_id = str;
        }
        return getApiRequestMessangerRx().getBlockedProfiles(getListInput).observeOn(Schedulers.computation()).flatMap(new Function<MessangerOutput<Rubino.GetProfileListOutput>, ObservableSource<Rubino.ProfileListObject>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.8
            @Override // io.reactivex.functions.Function
            public ObservableSource<Rubino.ProfileListObject> apply(MessangerOutput<Rubino.GetProfileListOutput> messangerOutput) throws Exception {
                return Observable.just(RubinoController.this.makeProfileList(messangerOutput.data)).flatMap(new Function<Rubino.ProfileListObject, ObservableSource<Rubino.ProfileListObject>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.8.1
                    @Override // io.reactivex.functions.Function
                    public ObservableSource<Rubino.ProfileListObject> apply(Rubino.ProfileListObject profileListObject) throws Exception {
                        ArrayList<RubinoProfileObject> arrayList = profileListObject.profiles;
                        if (arrayList != null) {
                            Iterator<RubinoProfileObject> it = arrayList.iterator();
                            while (it.hasNext()) {
                                RubinoProfileObject next = it.next();
                                next.isBlocked = true;
                                RubinoController.this.addToBlockedMap(next.id, true);
                            }
                        }
                        return Observable.just(profileListObject);
                    }
                });
            }
        });
    }

    public Observable<Rubino.ProfileListObject> getFollowerFollowingObservable(String str, boolean z, String str2, int i) {
        Rubino.GetListInput getListInput = new Rubino.GetListInput(AppRubinoPreferences.getInstance(this.currentAccount).getInstaCurrentProfileObject().id);
        getListInput.target_profile_id = str;
        getListInput.limit = i;
        if (str2 != null && !str2.equals(BuildConfig.FLAVOR)) {
            getListInput.max_id = str2;
        }
        if (z) {
            getListInput.f_type = Rubino.FollowingTypeEnum.Follower;
        } else {
            getListInput.f_type = Rubino.FollowingTypeEnum.Following;
        }
        return getApiRequestMessangerRx().getProfileFollowers(getListInput).observeOn(Schedulers.computation()).flatMap(new Function<MessangerOutput<Rubino.GetProfileListOutput>, ObservableSource<Rubino.ProfileListObject>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.9
            @Override // io.reactivex.functions.Function
            public ObservableSource<Rubino.ProfileListObject> apply(MessangerOutput<Rubino.GetProfileListOutput> messangerOutput) throws Exception {
                return Observable.just(RubinoController.this.makeProfileList(messangerOutput.data));
            }
        });
    }

    public Observable<Rubino.ProfileListObject> getPollResultObservable(String str, int i, String str2, int i2) {
        GetPollResultProfilesInput getPollResultProfilesInput = new GetPollResultProfilesInput(AppRubinoPreferences.getInstance(this.currentAccount).getInstaCurrentProfileObject().id);
        getPollResultProfilesInput.choice_number = i;
        getPollResultProfilesInput.story_id = str;
        getPollResultProfilesInput.limit = i2;
        if (str2 != null && !str2.equals(BuildConfig.FLAVOR)) {
            getPollResultProfilesInput.start_id = str2;
        }
        return getApiRequestMessangerRx().getPollResultProfiles(getPollResultProfilesInput).observeOn(Schedulers.computation()).flatMap(new Function<MessangerOutput<Rubino.GetProfileListOutput>, ObservableSource<Rubino.ProfileListObject>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.10
            @Override // io.reactivex.functions.Function
            public ObservableSource<Rubino.ProfileListObject> apply(MessangerOutput<Rubino.GetProfileListOutput> messangerOutput) throws Exception {
                return Observable.just(RubinoController.this.makeProfileList(messangerOutput.data));
            }
        });
    }

    public Observable<Rubino.GetEmojiResultsOutput> getEmojiSliderResultsObservable(String str, String str2, int i) {
        GetEmojiResultsInput getEmojiResultsInput = new GetEmojiResultsInput(AppRubinoPreferences.getInstance(this.currentAccount).getInstaCurrentProfileObject().id);
        getEmojiResultsInput.story_id = str;
        getEmojiResultsInput.limit = i;
        if (str2 != null && !str2.equals(BuildConfig.FLAVOR)) {
            getEmojiResultsInput.start_id = str2;
        }
        return getApiRequestMessangerRx().getEmojiSliderResults(getEmojiResultsInput).observeOn(Schedulers.computation()).flatMap(new Function<MessangerOutput<Rubino.GetEmojiResultsOutput>, ObservableSource<Rubino.GetEmojiResultsOutput>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.11
            @Override // io.reactivex.functions.Function
            public ObservableSource<Rubino.GetEmojiResultsOutput> apply(MessangerOutput<Rubino.GetEmojiResultsOutput> messangerOutput) throws Exception {
                Rubino.GetEmojiResultsOutput getEmojiResultsOutput;
                if (messangerOutput == null || (getEmojiResultsOutput = messangerOutput.data) == null) {
                    return null;
                }
                if (getEmojiResultsOutput.emoji_slider_results != null) {
                    Iterator<EmojiSliderResultObject> it = getEmojiResultsOutput.emoji_slider_results.iterator();
                    while (it.hasNext()) {
                        it.next().makeData(((BaseController) RubinoController.this).currentAccount);
                    }
                }
                return Observable.just(messangerOutput.data);
            }
        }).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<Rubino.ProfileListObject> getPostLikeObservable(String str, String str2, String str3, int i) {
        Rubino.GetListInput getListInput = new Rubino.GetListInput(AppRubinoPreferences.getInstance(this.currentAccount).getInstaCurrentProfileObject().id);
        getListInput.post_id = str;
        getListInput.post_profile_id = str2;
        getListInput.limit = i;
        if (str3 != null && !str3.equals(BuildConfig.FLAVOR)) {
            getListInput.max_id = str3;
        }
        return getApiRequestMessangerRx().getPostLikeProfiles(getListInput).observeOn(Schedulers.computation()).flatMap(new Function<MessangerOutput<Rubino.GetProfileListOutput>, ObservableSource<Rubino.ProfileListObject>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.12
            @Override // io.reactivex.functions.Function
            public ObservableSource<Rubino.ProfileListObject> apply(MessangerOutput<Rubino.GetProfileListOutput> messangerOutput) throws Exception {
                return Observable.just(RubinoController.this.makeProfileList(messangerOutput.data));
            }
        });
    }

    public Observable<Rubino.ProfileListObject> getCommentLikeObservable(String str, String str2, String str3, int i) {
        Rubino.GetListInput getListInput = new Rubino.GetListInput(AppRubinoPreferences.getInstance(this.currentAccount).getInstaCurrentProfileObject().id);
        getListInput.post_id = str;
        getListInput.comment_id = str2;
        getListInput.limit = i;
        if (str3 != null && !str3.equals(BuildConfig.FLAVOR)) {
            getListInput.max_id = str3;
        }
        return getApiRequestMessangerRx().getLikedCommentProfiles(getListInput).observeOn(Schedulers.computation()).flatMap(new Function<MessangerOutput<Rubino.GetProfileListOutput>, ObservableSource<Rubino.ProfileListObject>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.13
            @Override // io.reactivex.functions.Function
            public ObservableSource<Rubino.ProfileListObject> apply(MessangerOutput<Rubino.GetProfileListOutput> messangerOutput) throws Exception {
                return Observable.just(RubinoController.this.makeProfileList(messangerOutput.data));
            }
        });
    }

    public Observable<Rubino.ProfileListObject> getSuggestedProfilesObservable(String str, int i) {
        Rubino.GetListInput getListInput = new Rubino.GetListInput(AppRubinoPreferences.getInstance(this.currentAccount).getInstaCurrentProfileObject().id);
        getListInput.limit = i;
        getListInput.sort = Rubino.SortEnum.FromMax;
        if (str != null && !str.equals(BuildConfig.FLAVOR)) {
            getListInput.max_id = str;
        }
        return getApiRequestMessangerRx().getSuggestedProfiles(getListInput).observeOn(Schedulers.computation()).flatMap(new Function<MessangerOutput<Rubino.GetProfileListOutput>, ObservableSource<Rubino.ProfileListObject>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.14
            @Override // io.reactivex.functions.Function
            public ObservableSource<Rubino.ProfileListObject> apply(MessangerOutput<Rubino.GetProfileListOutput> messangerOutput) throws Exception {
                return Observable.just(RubinoController.this.makeProfileList(messangerOutput.data));
            }
        });
    }

    public Observable<Rubino.ProfileListObject> getSearchProfilesObservable(String str, String str2, int i) {
        Rubino.GetListInput getListInput = new Rubino.GetListInput(AppRubinoPreferences.getInstance(this.currentAccount).getInstaCurrentProfileObject().id);
        getListInput.username = str != null ? str.replace("@", BuildConfig.FLAVOR) : null;
        getListInput.limit = i;
        getListInput.sort = Rubino.SortEnum.FromMax;
        if (str2 != null && !str2.equals(BuildConfig.FLAVOR)) {
            getListInput.max_id = str2;
        }
        return getApiRequestMessangerRx().rubinoSearchProfiles2(getListInput).observeOn(Schedulers.computation()).flatMap(new Function<MessangerOutput<Rubino.GetProfileListOutput>, ObservableSource<Rubino.ProfileListObject>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.15
            @Override // io.reactivex.functions.Function
            public ObservableSource<Rubino.ProfileListObject> apply(MessangerOutput<Rubino.GetProfileListOutput> messangerOutput) throws Exception {
                return Observable.just(RubinoController.this.makeProfileList(messangerOutput.data));
            }
        });
    }

    public Observable<Rubino.ProfileListObject> getSearchFollowerProfilesObservable(String str, String str2, Rubino.FollowingTypeEnum followingTypeEnum, String str3, int i) {
        Rubino.GetListInput getListInput = new Rubino.GetListInput(AppRubinoPreferences.getInstance(this.currentAccount).getInstaCurrentProfileObject().id);
        getListInput.username = str2 != null ? str2.replace("@", BuildConfig.FLAVOR) : null;
        getListInput.limit = i;
        getListInput.search_type = followingTypeEnum;
        getListInput.target_profile_id = str;
        getListInput.sort = Rubino.SortEnum.FromMax;
        if (str3 != null && !str3.equals(BuildConfig.FLAVOR)) {
            getListInput.max_id = str3;
        }
        return getApiRequestMessangerRx().rubinoSearchFollowerProfiles(getListInput).observeOn(Schedulers.computation()).flatMap(new Function<MessangerOutput<Rubino.GetProfileListOutput>, ObservableSource<Rubino.ProfileListObject>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.16
            @Override // io.reactivex.functions.Function
            public ObservableSource<Rubino.ProfileListObject> apply(MessangerOutput<Rubino.GetProfileListOutput> messangerOutput) throws Exception {
                return Observable.just(RubinoController.this.makeProfileList(messangerOutput.data));
            }
        });
    }

    public Observable<Rubino.HashtagListObject> getSearchHashtagObservable(String str, String str2, int i) {
        Rubino.GetListInput getListInput = new Rubino.GetListInput(AppRubinoPreferences.getInstance(this.currentAccount).getInstaCurrentProfileObject().id);
        getListInput.content = str != null ? str.replace("#", BuildConfig.FLAVOR) : null;
        getListInput.limit = i;
        getListInput.sort = Rubino.SortEnum.FromMax;
        if (str2 != null && !str2.equals(BuildConfig.FLAVOR)) {
            getListInput.max_id = str2;
        }
        return getApiRequestMessangerRx().rubinoSearchHashTag2(getListInput).observeOn(Schedulers.computation()).flatMap(new Function<MessangerOutput<Rubino.GetHashtagListOutput>, ObservableSource<Rubino.HashtagListObject>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.17
            @Override // io.reactivex.functions.Function
            public ObservableSource<Rubino.HashtagListObject> apply(MessangerOutput<Rubino.GetHashtagListOutput> messangerOutput) throws Exception {
                return Observable.just(RubinoController.this.makeHashtagList(messangerOutput.data));
            }
        });
    }

    public Observable<Rubino.HashtagListObject> getHashtagTrendObservable(String str, int i) {
        Rubino.GetListInput getListInput = new Rubino.GetListInput(AppRubinoPreferences.getInstance(this.currentAccount).getInstaCurrentProfileObject().id);
        getListInput.limit = i;
        getListInput.sort = Rubino.SortEnum.FromMax;
        if (str != null && !str.equals(BuildConfig.FLAVOR)) {
            getListInput.max_id = str;
        }
        return getApiRequestMessangerRx().rubinoGetHashTagTrend(getListInput).observeOn(Schedulers.computation()).flatMap(new Function<MessangerOutput<Rubino.GetHashtagListOutput>, ObservableSource<Rubino.HashtagListObject>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.18
            @Override // io.reactivex.functions.Function
            public ObservableSource<Rubino.HashtagListObject> apply(MessangerOutput<Rubino.GetHashtagListOutput> messangerOutput) throws Exception {
                return Observable.just(RubinoController.this.makeHashtagList(messangerOutput.data));
            }
        });
    }

    public Observable<Rubino.CommentListObject> getCommentsObservable(String str, String str2, String str3, int i) {
        Rubino.GetListInput getListInput = new Rubino.GetListInput(AppRubinoPreferences.getInstance(this.currentAccount).getInstaCurrentProfileObject().id);
        getListInput.post_id = str;
        getListInput.post_profile_id = str2;
        getListInput.limit = i;
        if (str3 != null && !str3.equals(BuildConfig.FLAVOR)) {
            getListInput.max_id = str3;
        }
        return getApiRequestMessangerRx().rubinoGetComments(getListInput).observeOn(Schedulers.computation()).flatMap(new Function<MessangerOutput<Rubino.GetCommentsOutput>, ObservableSource<Rubino.CommentListObject>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.19
            @Override // io.reactivex.functions.Function
            public ObservableSource<Rubino.CommentListObject> apply(MessangerOutput<Rubino.GetCommentsOutput> messangerOutput) throws Exception {
                return Observable.just(RubinoController.this.makeCommentList(messangerOutput.data, false));
            }
        });
    }

    public Observable<Rubino.CommentListObject> getCommentReplyListObservable(String str, String str2, String str3, int i) {
        Rubino.GetListInput getListInput = new Rubino.GetListInput(AppRubinoPreferences.getInstance(this.currentAccount).getInstaCurrentProfileObject().id);
        getListInput.post_id = str;
        getListInput.comment_id = str2;
        getListInput.limit = i;
        if (str3 != null && !str3.equals(BuildConfig.FLAVOR)) {
            getListInput.max_id = str3;
        }
        return getApiRequestMessangerRx().rubinoGetCommentReplies(getListInput).observeOn(Schedulers.computation()).flatMap(new Function<MessangerOutput<Rubino.GetCommentsOutput>, ObservableSource<Rubino.CommentListObject>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.20
            @Override // io.reactivex.functions.Function
            public ObservableSource<Rubino.CommentListObject> apply(MessangerOutput<Rubino.GetCommentsOutput> messangerOutput) throws Exception {
                return Observable.just(RubinoController.this.makeCommentList(messangerOutput.data, true));
            }
        });
    }

    public Observable<Rubino.CommentOutput> getAddCommentObservable(String str, final String str2, String str3, final int i) {
        Rubino.AddCommentInput addCommentInput = new Rubino.AddCommentInput(AppRubinoPreferences.getInstance(this.currentAccount).getInstaCurrentProfileObject().id);
        addCommentInput.setForComment(str, str2, str3, i);
        return getApiRequestMessangerRx().rubinoAddComment(addCommentInput).doOnError(new Consumer<Throwable>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.23
            @Override // io.reactivex.functions.Consumer
            public void accept(Throwable th) throws Exception {
                RubinoPostObject fromPostMapIfExist = RubinoController.this.getFromPostMapIfExist(str2);
                if (fromPostMapIfExist != null) {
                    Iterator<RubinoCommentObject> it = fromPostMapIfExist.myComments.iterator();
                    while (it.hasNext()) {
                        RubinoCommentObject next = it.next();
                        if (next.isLocal && i == next.rnd) {
                            fromPostMapIfExist.myComments.remove(next);
                            return;
                        }
                    }
                }
            }
        }).flatMap(new Function<MessangerOutput<Rubino.AddCommentOutput>, ObservableSource<Rubino.CommentOutput>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.22
            @Override // io.reactivex.functions.Function
            public ObservableSource<Rubino.CommentOutput> apply(MessangerOutput<Rubino.AddCommentOutput> messangerOutput) throws Exception {
                return RubinoController.this.makeCommentOutput(messangerOutput, false);
            }
        }).observeOn(AndroidSchedulers.mainThread()).doOnNext(new Consumer<Rubino.CommentOutput>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.21
            @Override // io.reactivex.functions.Consumer
            public void accept(Rubino.CommentOutput commentOutput) throws Exception {
                RubinoController.this.updatePostOnAddComment(str2, commentOutput.comment, Integer.valueOf(i));
            }
        });
    }

    public Observable<Rubino.CommentOutput> getAddReplyCommentObservable(String str, final String str2, String str3, int i) {
        Rubino.AddCommentInput addCommentInput = new Rubino.AddCommentInput(AppRubinoPreferences.getInstance(this.currentAccount).getInstaCurrentProfileObject().id);
        addCommentInput.setForReply(str, str2, str3, i);
        return getApiRequestMessangerRx().rubinoAddReplyComment(addCommentInput).flatMap(new Function<MessangerOutput<Rubino.AddCommentOutput>, ObservableSource<Rubino.CommentOutput>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.25
            @Override // io.reactivex.functions.Function
            public ObservableSource<Rubino.CommentOutput> apply(MessangerOutput<Rubino.AddCommentOutput> messangerOutput) throws Exception {
                return RubinoController.this.makeCommentOutput(messangerOutput, true);
            }
        }).observeOn(AndroidSchedulers.mainThread()).doOnNext(new Consumer<Rubino.CommentOutput>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.24
            @Override // io.reactivex.functions.Consumer
            public void accept(Rubino.CommentOutput commentOutput) throws Exception {
                RubinoController.this.updatePostOnAddComment(str2, null, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Observable<Rubino.CommentOutput> makeCommentOutput(MessangerOutput<Rubino.AddCommentOutput> messangerOutput, boolean z) {
        Rubino.CommentOutput commentOutput = new Rubino.CommentOutput();
        RubinoCommentObject rubinoCommentObject = new RubinoCommentObject();
        commentOutput.comment = rubinoCommentObject;
        rubinoCommentObject.setComment(messangerOutput.data.comment, this.currentAccount);
        commentOutput.comment.isReply = z;
        return Observable.just(commentOutput);
    }

    public Observable<Rubino.NewEventsListObject> getRequestObservable(String str, int i) {
        Rubino.GetListInput getListInput = new Rubino.GetListInput(AppRubinoPreferences.getInstance(this.currentAccount).getInstaCurrentProfileObject().id);
        getListInput.limit = i;
        if (str != null && !str.equals(BuildConfig.FLAVOR)) {
            getListInput.max_id = str;
        }
        return getApiRequestMessangerRx().getNewFollowRequests(getListInput).observeOn(Schedulers.computation()).flatMap(new Function<MessangerOutput<Rubino.GetFollowRequestsOutput>, ObservableSource<Rubino.NewEventsListObject>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.26
            @Override // io.reactivex.functions.Function
            public ObservableSource<Rubino.NewEventsListObject> apply(MessangerOutput<Rubino.GetFollowRequestsOutput> messangerOutput) throws Exception {
                return Observable.just(RubinoController.this.makeNewEventList(messangerOutput.data));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rubino.NewEventsListObject makeNewEventList(Rubino.GetNewEventsOutput getNewEventsOutput) {
        ArrayList<Rubino.NewEventFromServerObject> arrayList;
        Rubino.NewEventsListObject newEventsListObject = new Rubino.NewEventsListObject();
        newEventsListObject.events = new ArrayList<>();
        if (getNewEventsOutput != null && (arrayList = getNewEventsOutput.records) != null) {
            Iterator<Rubino.NewEventFromServerObject> it = arrayList.iterator();
            while (it.hasNext()) {
                Rubino.NewEventFromServerObject next = it.next();
                Rubino.NewEventObject newEventObject = new Rubino.NewEventObject();
                newEventObject.setAsEvent(next);
                newEventsListObject.events.add(newEventObject);
                ArrayList<RubinoProfileObject> arrayList2 = next.owners;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    Iterator<RubinoProfileObject> it2 = next.owners.iterator();
                    while (it2.hasNext()) {
                        RubinoProfileObject next2 = it2.next();
                        Set<String> set = next.i_request;
                        if (set != null) {
                            Map<String, Boolean> map = this.followRequestedProfileMap;
                            String str = next2.id;
                            map.put(str, Boolean.valueOf(set.contains(str)));
                        }
                        Set<String> set2 = next.following_list;
                        if (set2 != null) {
                            String str2 = next2.id;
                            addToFollowedProfileMap(str2, set2.contains(str2));
                        }
                    }
                }
            }
        }
        return newEventsListObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rubino.HashtagListObject makeHashtagList(Rubino.GetHashtagListOutput getHashtagListOutput) {
        ArrayList<Rubino.HashtagObject> arrayList;
        Rubino.HashtagListObject hashtagListObject = new Rubino.HashtagListObject();
        hashtagListObject.hashtags = new ArrayList<>();
        if (getHashtagListOutput != null && (arrayList = getHashtagListOutput.hash_tags) != null) {
            Iterator<Rubino.HashtagObject> it = arrayList.iterator();
            while (it.hasNext()) {
                Rubino.HashtagObject next = it.next();
                next.createPostCountString();
                hashtagListObject.hashtags.add(next);
            }
        }
        return hashtagListObject;
    }

    public static void showRubinoCenterDialog(boolean z, SpannableString spannableString, String str, View.OnClickListener onClickListener) {
        showRubinoCenterDialog(false, z, null, spannableString, str, onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rubino.CommentListObject makeCommentList(Rubino.GetCommentsOutput getCommentsOutput, boolean z) {
        ArrayList<Rubino.CommentFromServer> arrayList;
        Rubino.CommentListObject commentListObject = new Rubino.CommentListObject();
        commentListObject.commentObjects = new ArrayList<>();
        if (getCommentsOutput != null && (arrayList = getCommentsOutput.comments) != null) {
            Iterator<Rubino.CommentFromServer> it = arrayList.iterator();
            while (it.hasNext()) {
                Rubino.CommentFromServer next = it.next();
                RubinoCommentObject rubinoCommentObject = new RubinoCommentObject();
                rubinoCommentObject.setComment(next, this.currentAccount);
                rubinoCommentObject.isReply = z;
                Set<String> set = getCommentsOutput.liked_comments;
                if (set != null && set.contains(next.id)) {
                    rubinoCommentObject.isLiked = true;
                }
                commentListObject.commentObjects.add(rubinoCommentObject);
            }
        }
        return commentListObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rubino.NewEventsListObject makeNewEventList(Rubino.GetFollowRequestsOutput getFollowRequestsOutput) {
        ArrayList<Rubino.NewEventFromServerObject> arrayList;
        Rubino.NewEventsListObject newEventsListObject = new Rubino.NewEventsListObject();
        newEventsListObject.events = new ArrayList<>();
        if (getFollowRequestsOutput != null && (arrayList = getFollowRequestsOutput.requests) != null) {
            Iterator<Rubino.NewEventFromServerObject> it = arrayList.iterator();
            while (it.hasNext()) {
                Rubino.NewEventFromServerObject next = it.next();
                Rubino.NewEventObject newEventObject = new Rubino.NewEventObject();
                newEventObject.setAsRequest(next);
                newEventsListObject.events.add(newEventObject);
                ArrayList<RubinoProfileObject> arrayList2 = next.owners;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    Iterator<RubinoProfileObject> it2 = next.owners.iterator();
                    while (it2.hasNext()) {
                        RubinoProfileObject next2 = it2.next();
                        Set<String> set = next.i_request;
                        if (set != null) {
                            Map<String, Boolean> map = this.followRequestedProfileMap;
                            String str = next2.id;
                            map.put(str, Boolean.valueOf(set.contains(str)));
                        }
                        Set<String> set2 = next.following_list;
                        if (set2 != null) {
                            String str2 = next2.id;
                            addToFollowedProfileMap(str2, set2.contains(str2));
                        }
                    }
                }
            }
        }
        return newEventsListObject;
    }

    public Observable<Rubino.PostObjectList> getRelatedPostsObservable(final RubinoPostObject rubinoPostObject, RubinoPostPosition rubinoPostPosition, String str, int i) {
        Rubino.GetListInput getListInput = new Rubino.GetListInput(AppRubinoPreferences.getInstance(this.currentAccount).getInstaCurrentProfileObject().id);
        getListInput.limit = i;
        getListInput.start_id = str;
        Rubino.PostObjectFromServer postObjectFromServer = rubinoPostObject.post;
        getListInput.post_id = postObjectFromServer.id;
        getListInput.post_profile_id = postObjectFromServer.profile_id;
        getListInput.post_position = rubinoPostPosition;
        return getApiRequestMessangerRx().getRelatedPosts(getListInput).observeOn(Schedulers.computation()).flatMap(new Function<MessangerOutput<Rubino.GetRelatedExplorePostsOutput>, ObservableSource<Rubino.PostObjectList>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.27
            @Override // io.reactivex.functions.Function
            public ObservableSource<Rubino.PostObjectList> apply(final MessangerOutput<Rubino.GetRelatedExplorePostsOutput> messangerOutput) throws Exception {
                return Observable.just(RubinoController.this.makePostObjectList(messangerOutput.data, rubinoPostObject)).flatMap(new Function<Rubino.PostObjectList, ObservableSource<Rubino.PostObjectList>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.27.1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // io.reactivex.functions.Function
                    public ObservableSource<Rubino.PostObjectList> apply(Rubino.PostObjectList postObjectList) throws Exception {
                        ArrayList<RubinoPostObject> arrayList;
                        if (postObjectList != null && (arrayList = postObjectList.posts) != null) {
                            Iterator<RubinoPostObject> it = arrayList.iterator();
                            while (it.hasNext()) {
                                RubinoPostObject next = it.next();
                                RubinoProfileObject rubinoProfileObject = next.profile;
                                RubinoProfileObject.ProfileStatusEnum profileStatusEnum = RubinoProfileObject.ProfileStatusEnum.Public;
                                rubinoProfileObject.profile_status = profileStatusEnum;
                                next.getProfileTryFromMap().profile_status = profileStatusEnum;
                                if (((Rubino.GetRelatedExplorePostsOutput) messangerOutput.data).profile_story_status != null) {
                                    RubinoController.this.getStoryController().setProfileStoryStatus(((Rubino.GetRelatedExplorePostsOutput) messangerOutput.data).profile_story_status, next.post.profile_id);
                                }
                            }
                            try {
                                RubinoPostObject rubinoPostObject2 = postObjectList.selectedPost;
                                RubinoProfileObject rubinoProfileObject2 = rubinoPostObject2.profile;
                                RubinoProfileObject.ProfileStatusEnum profileStatusEnum2 = RubinoProfileObject.ProfileStatusEnum.Public;
                                rubinoProfileObject2.profile_status = profileStatusEnum2;
                                rubinoPostObject2.getProfileTryFromMap().profile_status = profileStatusEnum2;
                                if (((Rubino.GetRelatedExplorePostsOutput) messangerOutput.data).profile_story_status != null) {
                                    RubinoController.this.getStoryController().setProfileStoryStatus(((Rubino.GetRelatedExplorePostsOutput) messangerOutput.data).profile_story_status, postObjectList.selectedPost.post.profile_id);
                                }
                            } catch (Exception e) {
                                MyLog.handleException(e);
                            }
                        }
                        return Observable.just(postObjectList);
                    }
                });
            }
        }).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<Rubino.PostObjectList> getProfilesPostListObservable(Collection<Rubino.RubinoProfilePostId> collection) {
        Rubino.GetProfilesPostListInput getProfilesPostListInput = new Rubino.GetProfilesPostListInput(AppRubinoPreferences.getInstance(this.currentAccount).getInstaCurrentProfileObject().id);
        getProfilesPostListInput.profile_post_ids = collection;
        return getApiRequestMessangerRx().getProfilesPostList(getProfilesPostListInput).observeOn(Schedulers.computation()).flatMap(new Function<MessangerOutput<Rubino.GetPostsOutput>, ObservableSource<Rubino.PostObjectList>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.28
            @Override // io.reactivex.functions.Function
            public ObservableSource<Rubino.PostObjectList> apply(final MessangerOutput<Rubino.GetPostsOutput> messangerOutput) throws Exception {
                return Observable.just(RubinoController.this.makePostObjectList(messangerOutput.data)).flatMap(new Function<Rubino.PostObjectList, ObservableSource<Rubino.PostObjectList>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.28.1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // io.reactivex.functions.Function
                    public ObservableSource<Rubino.PostObjectList> apply(Rubino.PostObjectList postObjectList) throws Exception {
                        ArrayList<RubinoPostObject> arrayList;
                        if (postObjectList != null && (arrayList = postObjectList.posts) != null) {
                            Iterator<RubinoPostObject> it = arrayList.iterator();
                            while (it.hasNext()) {
                                RubinoPostObject next = it.next();
                                RubinoProfileObject rubinoProfileObject = next.profile;
                                RubinoProfileObject.ProfileStatusEnum profileStatusEnum = RubinoProfileObject.ProfileStatusEnum.Public;
                                rubinoProfileObject.profile_status = profileStatusEnum;
                                next.getProfileTryFromMap().profile_status = profileStatusEnum;
                                if (((Rubino.GetPostsOutput) messangerOutput.data).profile_story_status != null) {
                                    RubinoController.this.getStoryController().setProfileStoryStatus(((Rubino.GetPostsOutput) messangerOutput.data).profile_story_status, next.post.profile_id);
                                }
                            }
                            try {
                                RubinoPostObject rubinoPostObject = postObjectList.selectedPost;
                                RubinoProfileObject rubinoProfileObject2 = rubinoPostObject.profile;
                                RubinoProfileObject.ProfileStatusEnum profileStatusEnum2 = RubinoProfileObject.ProfileStatusEnum.Public;
                                rubinoProfileObject2.profile_status = profileStatusEnum2;
                                rubinoPostObject.getProfileTryFromMap().profile_status = profileStatusEnum2;
                                if (((Rubino.GetPostsOutput) messangerOutput.data).profile_story_status != null) {
                                    RubinoController.this.getStoryController().setProfileStoryStatus(((Rubino.GetPostsOutput) messangerOutput.data).profile_story_status, postObjectList.selectedPost.post.profile_id);
                                }
                            } catch (Exception unused) {
                            }
                        }
                        return Observable.just(postObjectList);
                    }
                });
            }
        }).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<Rubino.PostObjectList> getExplorePostsObservable(String str, String str2, int i) {
        Rubino.GetListInput getListInput = new Rubino.GetListInput(AppRubinoPreferences.getInstance(this.currentAccount).getInstaCurrentProfileObject().id);
        getListInput.limit = i;
        getListInput.sort = Rubino.SortEnum.FromMax;
        getListInput.topic_id = str;
        if (str2 != null && !str2.equals(BuildConfig.FLAVOR)) {
            getListInput.max_id = str2;
        }
        return getApiRequestMessangerRx().getExplorePosts(getListInput).observeOn(Schedulers.computation()).flatMap(new Function<MessangerOutput<Rubino.GetPostsOutput>, ObservableSource<Rubino.PostObjectList>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.29
            @Override // io.reactivex.functions.Function
            public ObservableSource<Rubino.PostObjectList> apply(MessangerOutput<Rubino.GetPostsOutput> messangerOutput) throws Exception {
                return Observable.just(RubinoController.this.makePostObjectList(messangerOutput.data)).flatMap(new Function<Rubino.PostObjectList, ObservableSource<Rubino.PostObjectList>>(this) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.29.1
                    @Override // io.reactivex.functions.Function
                    public ObservableSource<Rubino.PostObjectList> apply(Rubino.PostObjectList postObjectList) throws Exception {
                        ArrayList<RubinoPostObject> arrayList;
                        if (postObjectList != null && (arrayList = postObjectList.posts) != null) {
                            Iterator<RubinoPostObject> it = arrayList.iterator();
                            while (it.hasNext()) {
                                RubinoPostObject next = it.next();
                                RubinoProfileObject rubinoProfileObject = next.profile;
                                RubinoProfileObject.ProfileStatusEnum profileStatusEnum = RubinoProfileObject.ProfileStatusEnum.Public;
                                rubinoProfileObject.profile_status = profileStatusEnum;
                                next.getProfileTryFromMap().profile_status = profileStatusEnum;
                            }
                        }
                        return Observable.just(postObjectList);
                    }
                });
            }
        }).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<Rubino.PostObjectList> getHashtagPostsObservable(String str, String str2, int i) {
        Rubino.GetListInput getListInput = new Rubino.GetListInput(AppRubinoPreferences.getInstance(this.currentAccount).getInstaCurrentProfileObject().id);
        getListInput.limit = i;
        getListInput.sort = null;
        getListInput.hashtag = str;
        if (str2 != null && !str2.equals(BuildConfig.FLAVOR)) {
            getListInput.start_id = str2;
        }
        return getApiRequestMessangerRx().getHashTagPosts(getListInput).observeOn(Schedulers.computation()).flatMap(new Function<MessangerOutput<Rubino.GetPostsOutput>, ObservableSource<Rubino.PostObjectList>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.30
            @Override // io.reactivex.functions.Function
            public ObservableSource<Rubino.PostObjectList> apply(MessangerOutput<Rubino.GetPostsOutput> messangerOutput) throws Exception {
                return Observable.just(RubinoController.this.makePostObjectList(messangerOutput.data));
            }
        }).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<Rubino.PostObjectList> getBookmarkPostsObservable(String str, int i) {
        Rubino.GetListInput getListInput = new Rubino.GetListInput(AppRubinoPreferences.getInstance(this.currentAccount).getInstaCurrentProfileObject().id);
        getListInput.limit = i;
        if (str != null && !str.equals(BuildConfig.FLAVOR)) {
            getListInput.max_id = str;
        }
        getListInput.sort = Rubino.SortEnum.FromMax;
        return getApiRequestMessangerRx().getBookmarkedPosts(getListInput).observeOn(Schedulers.computation()).flatMap(new Function<MessangerOutput<Rubino.GetPostsOutput>, ObservableSource<Rubino.PostObjectList>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.31
            @Override // io.reactivex.functions.Function
            public ObservableSource<Rubino.PostObjectList> apply(MessangerOutput<Rubino.GetPostsOutput> messangerOutput) throws Exception {
                return Observable.just(RubinoController.this.makePostObjectList(messangerOutput.data)).flatMap(new Function<Rubino.PostObjectList, ObservableSource<Rubino.PostObjectList>>(this) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.31.1
                    @Override // io.reactivex.functions.Function
                    public ObservableSource<Rubino.PostObjectList> apply(Rubino.PostObjectList postObjectList) throws Exception {
                        ArrayList<RubinoPostObject> arrayList;
                        if (postObjectList != null && (arrayList = postObjectList.posts) != null) {
                            Iterator<RubinoPostObject> it = arrayList.iterator();
                            while (it.hasNext()) {
                                it.next().isBookmarked = true;
                            }
                        }
                        return Observable.just(postObjectList);
                    }
                });
            }
        }).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<Rubino.PostObjectList> getProfilePostsObservable(boolean z, String str, String str2, String str3, int i, Rubino.SortEnum sortEnum) {
        if (z) {
            return getMyPostsObservable(str2, str3, i, sortEnum);
        }
        return getProfilePostsObservable(str, str2, str3, i, sortEnum);
    }

    private Observable<Rubino.PostObjectList> getMyPostsObservable(String str, String str2, int i, Rubino.SortEnum sortEnum) {
        Rubino.GetListInput getListInput = new Rubino.GetListInput(AppRubinoPreferences.getInstance(this.currentAccount).getInstaCurrentProfileObject().id);
        getListInput.limit = i;
        if (str2 != null && !str2.equals(BuildConfig.FLAVOR)) {
            getListInput.max_id = str2;
        }
        if (str != null && !str.equals(BuildConfig.FLAVOR)) {
            getListInput.min_id = str;
        }
        getListInput.sort = sortEnum;
        return getApiRequestMessangerRx().getMyProfilePosts(getListInput).observeOn(Schedulers.computation()).flatMap(new Function<MessangerOutput<Rubino.GetPostsOutput>, ObservableSource<Rubino.PostObjectList>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.32
            @Override // io.reactivex.functions.Function
            public ObservableSource<Rubino.PostObjectList> apply(MessangerOutput<Rubino.GetPostsOutput> messangerOutput) throws Exception {
                return Observable.just(RubinoController.this.makePostObjectList(messangerOutput.data));
            }
        }).observeOn(AndroidSchedulers.mainThread());
    }

    private Observable<Rubino.PostObjectList> getProfilePostsObservable(String str, String str2, String str3, int i, Rubino.SortEnum sortEnum) {
        Rubino.GetListInput getListInput = new Rubino.GetListInput(AppRubinoPreferences.getInstance(this.currentAccount).getInstaCurrentProfileObject().id);
        getListInput.limit = i;
        if (str3 != null && !str3.equals(BuildConfig.FLAVOR)) {
            getListInput.max_id = str3;
        }
        if (str2 != null && !str2.equals(BuildConfig.FLAVOR)) {
            getListInput.min_id = str2;
        }
        getListInput.sort = sortEnum;
        getListInput.target_profile_id = str;
        return getApiRequestMessangerRx().getProfilePosts(getListInput).observeOn(Schedulers.computation()).flatMap(new Function<MessangerOutput<Rubino.GetPostsOutput>, ObservableSource<Rubino.PostObjectList>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.33
            @Override // io.reactivex.functions.Function
            public ObservableSource<Rubino.PostObjectList> apply(MessangerOutput<Rubino.GetPostsOutput> messangerOutput) throws Exception {
                return Observable.just(RubinoController.this.makePostObjectList(messangerOutput.data));
            }
        }).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<Rubino.PostObjectList> getOnePostObservable(String str, String str2, boolean z) {
        RubinoPostObject fromPostMapIfExist = getFromPostMapIfExist(str2);
        if (!z && fromPostMapIfExist != null) {
            Rubino.PostObjectList postObjectList = new Rubino.PostObjectList();
            ArrayList<RubinoPostObject> arrayList = new ArrayList<>();
            postObjectList.posts = arrayList;
            arrayList.add(fromPostMapIfExist);
            return Observable.just(postObjectList);
        }
        Rubino.GetListInput getListInput = new Rubino.GetListInput(AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id);
        getListInput.limit = 1;
        getListInput.max_id = str2;
        getListInput.min_id = str2;
        getListInput.equal = true;
        getListInput.sort = Rubino.SortEnum.FromMax;
        getListInput.target_profile_id = str;
        return getApiRequestMessangerRx().getProfilePosts(getListInput).observeOn(Schedulers.computation()).flatMap(new Function<MessangerOutput<Rubino.GetPostsOutput>, ObservableSource<Rubino.PostObjectList>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.34
            @Override // io.reactivex.functions.Function
            public ObservableSource<Rubino.PostObjectList> apply(MessangerOutput<Rubino.GetPostsOutput> messangerOutput) throws Exception {
                return Observable.just(RubinoController.this.makePostObjectList(messangerOutput.data));
            }
        }).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<MessangerOutput<Rubino.GetProfileLinkItemsOutput>> getProfileLinkItemsObservable(String str) {
        return getApiRequestMessangerRx().getRubinoProfileLinkItems(new Rubino.GetProfileLinkItemsInput(AppRubinoPreferences.getInstance(this.currentAccount).getInstaCurrentProfileObject().id, str));
    }

    public RubinoProfileObject getInstantProfileInfoFromMapIfExist(String str) {
        Map<String, RubinoProfileObject> map = this.profileMap;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public RubinoProfileObject getInstantProfileInfoIfExist(CompositeDisposable compositeDisposable, final boolean z, final String str, boolean z2) {
        DisposableObserver disposableObserver;
        Observable<MessangerOutput<Rubino.GetProfileInfoOutput>> profileInfo;
        RubinoProfileObject rubinoProfileObject = this.profileMap.get(str);
        if ((z2 || rubinoProfileObject == null || System.currentTimeMillis() - rubinoProfileObject.lastUpdateTime > 5000) && ((disposableObserver = this.getProfileObserverMap.get(str)) == null || disposableObserver.isDisposed())) {
            String str2 = AppRubinoPreferences.getInstance(this.currentAccount).getInstaCurrentProfileObject().id;
            if (z) {
                profileInfo = getApiRequestMessangerRx().getMyProfileInfo(new Rubino.GetProfileInfoInput(str2));
            } else {
                profileInfo = getApiRequestMessangerRx().getProfileInfo(new Rubino.GetProfileInfoInput(str2, str));
            }
            DisposableObserver disposableObserver2 = (DisposableObserver) profileInfo.delay(z2 ? 400L : 10L, TimeUnit.MILLISECONDS).observeOn(Schedulers.computation()).doOnNext(new Consumer<MessangerOutput<Rubino.GetProfileInfoOutput>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.36
                @Override // io.reactivex.functions.Consumer
                public void accept(MessangerOutput<Rubino.GetProfileInfoOutput> messangerOutput) throws Exception {
                    RubinoProfileObject rubinoProfileObjectMakeProfileFromProfileInfo = RubinoController.this.makeProfileFromProfileInfo(messangerOutput.data);
                    RubinoController.this.addToProfileMap(rubinoProfileObjectMakeProfileFromProfileInfo);
                    if (z && rubinoProfileObjectMakeProfileFromProfileInfo.id.equals(AppRubinoPreferences.getInstance(((BaseController) RubinoController.this).currentAccount).getRubinoCurrentProfileObject().id)) {
                        AppRubinoPreferences.getInstance(((BaseController) RubinoController.this).currentAccount).setRubinoCurrentProfileObject(rubinoProfileObjectMakeProfileFromProfileInfo);
                    }
                }
            }).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<MessangerOutput<Rubino.GetProfileInfoOutput>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.35
                @Override // io.reactivex.Observer
                public void onComplete() {
                }

                @Override // io.reactivex.Observer
                public void onNext(MessangerOutput<Rubino.GetProfileInfoOutput> messangerOutput) {
                    RubinoController.this.getProfileObserverMap.remove(messangerOutput.data.profile.id);
                    RubinoController.this.getNotificationCenter().postNotificationName(NotificationCenter.rubinoProfileDidLoad, messangerOutput.data.profile.id);
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                    RubinoController.this.getProfileObserverMap.remove(str);
                    if (!(th instanceof ApiServerException) || ((ApiServerException) th).status_det != MessangerOutput.EnumStatusDet.INVALID_INPUT || !str.equals(AppRubinoPreferences.getInstance(((BaseController) RubinoController.this).currentAccount).getRubinoCurrentProfileObject().id)) {
                        RubinoController.this.getNotificationCenter().postNotificationName(NotificationCenter.rubinoProfileLoadingFailed, str);
                    } else if (AppRubinoPreferences.getInstance(((BaseController) RubinoController.this).currentAccount).getRubinoDefaultProfileObject() != null) {
                        new MainClickHandler().changeRubinoProfile(AppRubinoPreferences.getInstance(((BaseController) RubinoController.this).currentAccount).getRubinoDefaultProfileObject());
                    }
                }
            });
            if (compositeDisposable != null) {
                compositeDisposable.add(disposableObserver2);
            }
            this.getProfileObserverMap.put(str, disposableObserver2);
        }
        return rubinoProfileObject;
    }

    public boolean isProfileLoading(String str) {
        DisposableObserver disposableObserver = this.getProfileObserverMap.get(str);
        return (disposableObserver == null || disposableObserver.isDisposed()) ? false : true;
    }

    public boolean isProfileFollowRequested(RubinoProfileObject rubinoProfileObject) {
        Boolean bool = this.followRequestedProfileMap.get(rubinoProfileObject.id);
        if (bool != null) {
            return bool.booleanValue();
        }
        return rubinoProfileObject.isRequested;
    }

    public boolean hasPermissionAddPost() {
        return hasPermission(Rubino.ProfilePermissionsEnum.AddPost);
    }

    public boolean hasPermissionAddComment() {
        return hasPermission(Rubino.ProfilePermissionsEnum.AddComment);
    }

    public boolean hasPermissionAddStory() {
        return hasPermission(Rubino.ProfilePermissionsEnum.AddStory);
    }

    public boolean hasPermissionAddProfile() {
        return hasPermission(Rubino.ProfilePermissionsEnum.AddProfile);
    }

    public boolean hasPermissionAddLive() {
        return hasPermission(Rubino.ProfilePermissionsEnum.AddLive);
    }

    public boolean hasPermission(Rubino.ProfilePermissionsEnum profilePermissionsEnum) {
        HashMap<String, Set<Rubino.ProfilePermissionsEnum>> map;
        if (profilePermissionsEnum == null) {
            return true;
        }
        String myCurrentProfileID = getMyCurrentProfileID();
        Rubino.GetProfileListOutput profilesOutput2 = AppRubinoPreferences.getInstance(this.currentAccount).getProfilesOutput2();
        if (myCurrentProfileID == null || profilesOutput2 == null || (map = profilesOutput2.profile_permissions) == null || !map.containsKey(myCurrentProfileID)) {
            return true;
        }
        return profilesOutput2.profile_permissions.get(myCurrentProfileID).contains(profilePermissionsEnum);
    }

    public boolean isProfileFollowed(RubinoProfileObject rubinoProfileObject) {
        if (rubinoProfileObject == null) {
            return false;
        }
        Boolean bool = this.followedProfileMap.get(rubinoProfileObject.id);
        if (bool != null) {
            return bool.booleanValue();
        }
        return rubinoProfileObject.isFollowed;
    }

    public boolean isProfileBlocked(RubinoProfileObject rubinoProfileObject) {
        Boolean bool = this.blockedProfileMap.get(rubinoProfileObject.id);
        if (bool != null) {
            return bool.booleanValue();
        }
        return rubinoProfileObject.isBlocked;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RubinoProfileObject makeProfileFromProfileInfo(Rubino.GetProfileInfoOutput getProfileInfoOutput) {
        RubinoProfileObject rubinoProfileObject;
        if (getProfileInfoOutput == null || (rubinoProfileObject = getProfileInfoOutput.profile) == null) {
            return null;
        }
        rubinoProfileObject.username = rubinoProfileObject.username.toLowerCase();
        rubinoProfileObject.isRequested = getProfileInfoOutput.i_request;
        rubinoProfileObject.isFollowed = getProfileInfoOutput.in_following_list;
        rubinoProfileObject.isBlocked = getProfileInfoOutput.in_blocked_list;
        rubinoProfileObject.hasLinkItem = getProfileInfoOutput.has_profile_link_item;
        rubinoProfileObject.isMyProfile = rubinoProfileObject.id.equals(AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id);
        rubinoProfileObject.lastUpdateTime = System.currentTimeMillis();
        rubinoProfileObject.makeData(this.currentAccount);
        this.followRequestedProfileMap.put(rubinoProfileObject.id, Boolean.valueOf(getProfileInfoOutput.i_request));
        addToFollowedProfileMap(rubinoProfileObject.id, getProfileInfoOutput.in_following_list);
        addToBlockedMap(rubinoProfileObject.id, getProfileInfoOutput.in_blocked_list);
        getStoryController().updateMapFromProfileInfoOutput(getProfileInfoOutput);
        return rubinoProfileObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addToBlockedMap(String str, boolean z) {
        if (this.blockedProfileMap.size() > 1000) {
            this.blockedProfileMap.clear();
        }
        this.blockedProfileMap.put(str, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addToFollowedProfileMap(String str, boolean z) {
        if (this.followedProfileMap.size() > 1000) {
            this.followedProfileMap.clear();
        }
        this.followedProfileMap.put(str, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addToFollowRequestedMap(String str, boolean z) {
        if (this.followRequestedProfileMap.size() > 1000) {
            this.followRequestedProfileMap.clear();
        }
        this.followRequestedProfileMap.put(str, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rubino.PostObjectList makePostObjectList(Rubino.GetPostsOutput getPostsOutput) {
        ArrayList<Rubino.SplitPost> arrayList;
        Rubino.PostObjectList postObjectList = new Rubino.PostObjectList();
        if (getPostsOutput != null && (arrayList = getPostsOutput.items) != null) {
            Collections.sort(arrayList, new Comparator<Rubino.SplitPost>(this) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.37
                @Override // java.util.Comparator
                public int compare(Rubino.SplitPost splitPost, Rubino.SplitPost splitPost2) {
                    return splitPost.index < splitPost2.index ? -1 : 1;
                }
            });
            postObjectList.sortedItems = new ArrayList<>();
            if (getPostsOutput.posts != null) {
                Iterator<Rubino.SplitPost> it = getPostsOutput.items.iterator();
                while (it.hasNext()) {
                    Rubino.SplitPost next = it.next();
                    if (next.index <= getPostsOutput.posts.size()) {
                        postObjectList.sortedItems.add(next);
                    }
                }
            }
        }
        postObjectList.posts = new ArrayList<>();
        if (getPostsOutput != null) {
            postObjectList.nextStartId = getPostsOutput.next_start_id;
            postObjectList.hasContinue = getPostsOutput.has_continue;
            ArrayList<Rubino.PostObjectFromServer> arrayList2 = getPostsOutput.posts;
            if (arrayList2 != null) {
                Iterator<Rubino.PostObjectFromServer> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    Rubino.PostObjectFromServer next2 = it2.next();
                    RubinoPostObject rubinoPostObject = new RubinoPostObject();
                    Set<String> set = getPostsOutput.liked_posts;
                    if (set != null && set.contains(next2.id)) {
                        rubinoPostObject.isLiked = true;
                    }
                    Set<String> set2 = getPostsOutput.bookmarked_posts;
                    if (set2 != null && set2.contains(next2.id)) {
                        rubinoPostObject.isBookmarked = true;
                    }
                    rubinoPostObject.setPost(next2, this.currentAccount);
                    RubinoProfileObject rubinoProfileObject = getRubinoController().profileMap.get(next2.profile_id);
                    if (rubinoProfileObject != null) {
                        rubinoProfileObject.full_thumbnail_url = next2.full_post_profile_thumbnail_url;
                        rubinoProfileObject.username = next2.post_profile_username.toLowerCase();
                    }
                    postObjectList.posts.add(rubinoPostObject);
                }
            }
        }
        addToPostMap(postObjectList.posts);
        return postObjectList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rubino.PostObjectList makePostObjectList(Rubino.GetRelatedExplorePostsOutput getRelatedExplorePostsOutput, RubinoPostObject rubinoPostObject) {
        Rubino.PostObjectFromServer postObjectFromServer;
        int i;
        Rubino.PostObjectList postObjectList = new Rubino.PostObjectList();
        if (getRelatedExplorePostsOutput == null) {
            return postObjectList;
        }
        postObjectList.isAutoScrollEnable = getRelatedExplorePostsOutput.auto_scroll_enable;
        Rubino.PostObjectFromServer postObjectFromServer2 = getRelatedExplorePostsOutput.selected_post;
        if (postObjectFromServer2 != null) {
            RubinoPostObject fromPostMapIfExist = getFromPostMapIfExist(postObjectFromServer2.id);
            int i2 = 0;
            if (fromPostMapIfExist != null && (postObjectFromServer = fromPostMapIfExist.post) != null && (i = postObjectFromServer.size) > 0) {
                i2 = i;
            }
            rubinoPostObject.setPost(getRelatedExplorePostsOutput.selected_post, this.currentAccount);
            postObjectList.selectedPost = rubinoPostObject;
            rubinoPostObject.post.size = i2;
            addToPostMap(rubinoPostObject);
        }
        postObjectList.posts = new ArrayList<>();
        postObjectList.nextStartId = getRelatedExplorePostsOutput.next_start_id;
        ArrayList<Rubino.PostObjectFromServer> arrayList = getRelatedExplorePostsOutput.related_posts;
        if (arrayList != null) {
            Iterator<Rubino.PostObjectFromServer> it = arrayList.iterator();
            while (it.hasNext()) {
                Rubino.PostObjectFromServer next = it.next();
                RubinoPostObject rubinoPostObject2 = new RubinoPostObject();
                boolean zContains = getRelatedExplorePostsOutput.following_list.contains(next.profile_id);
                rubinoPostObject2.setPost(next, this.currentAccount);
                addToFollowedProfileMap(rubinoPostObject2.post.profile_id, zContains);
                RubinoProfileObject rubinoProfileObject = this.profileMap.get(next.profile_id);
                if (rubinoProfileObject != null) {
                    rubinoProfileObject.full_thumbnail_url = next.full_post_profile_thumbnail_url;
                    rubinoProfileObject.username = next.post_profile_username.toLowerCase();
                }
                postObjectList.posts.add(rubinoPostObject2);
            }
        }
        addToPostMap(postObjectList.posts);
        return postObjectList;
    }

    public Observable<MessangerOutput<Rubino.GetPostByShareLinkOutput>> getPostShareLinkObservable(String str, final boolean z) {
        String str2 = AppRubinoPreferences.getInstance(this.currentAccount).getInstaCurrentProfileObject().id;
        if (str2.isEmpty()) {
            new MainClickHandler().openRubinoTab();
            return null;
        }
        return getApiRequestMessangerRx().getPostByShareLink(new Rubino.GetPostByShareLinkInput(str2, str)).observeOn(AndroidSchedulers.mainThread()).doOnNext(new Consumer<MessangerOutput<Rubino.GetPostByShareLinkOutput>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.38
            @Override // io.reactivex.functions.Consumer
            public void accept(MessangerOutput<Rubino.GetPostByShareLinkOutput> messangerOutput) throws Exception {
                if (ApplicationLoader.applicationActivity != null) {
                    if (messangerOutput == null) {
                        ToastiLikeSnack.showL(ApplicationLoader.applicationActivity, LocaleController.getString(R.string.rubinoNoPost));
                        return;
                    }
                    Rubino.GetPostByShareLinkOutput getPostByShareLinkOutput = messangerOutput.data;
                    if (!getPostByShareLinkOutput.has_access) {
                        if (getPostByShareLinkOutput.profile != null) {
                            new MainClickHandler().openProfileOrRubinoTab(messangerOutput.data.profile);
                            ToastiLikeSnack.showL(ApplicationLoader.applicationActivity, LocaleController.getString("follow_to_access", R.string.follow_to_access));
                            return;
                        } else {
                            ToastiLikeSnack.showL(ApplicationLoader.applicationActivity, LocaleController.getString("no_access_to_post", R.string.no_access_to_post));
                            return;
                        }
                    }
                    if (getPostByShareLinkOutput.has_access) {
                        if (getPostByShareLinkOutput.post == null) {
                            ToastiLikeSnack.showL(ApplicationLoader.applicationActivity, LocaleController.getString(R.string.rubinoNoPost));
                            return;
                        }
                        RubinoPostObject rubinoPostObject = new RubinoPostObject();
                        rubinoPostObject.setPost(messangerOutput.data.post, ((BaseController) RubinoController.this).currentAccount);
                        RubinoController.this.addToPostMap(rubinoPostObject);
                        new MainClickHandler().openRubinoPost(rubinoPostObject, z);
                    }
                }
            }
        });
    }

    public void clear() {
        try {
            this.compositeDisposable.dispose();
            this.compositeDisposable = new CompositeDisposable();
            this.profileMap.clear();
            this.followObserverMap.clear();
            this.likePostObserverMap.clear();
            this.likeCommentObserverMap.clear();
            this.blockObserverMap.clear();
            this.bookmarkPostObserverMap.clear();
            this.followRequestedProfileMap.clear();
            this.followedProfileMap.clear();
            this.blockedProfileMap.clear();
            this.getProfileObserverMap.clear();
            this.postMap.clear();
            this.actionOnRequestMap.clear();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addToProfileMap(RubinoProfileObject rubinoProfileObject) {
        synchronized (this.profileLock) {
            if (this.profileMap.size() > 1000) {
                this.profileMap.clear();
            }
            rubinoProfileObject.lastUpdateTime = System.currentTimeMillis();
            this.profileMap.put(rubinoProfileObject.id, rubinoProfileObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addToPostMap(RubinoPostObject rubinoPostObject) {
        ArrayList<RubinoPostObject> arrayList = new ArrayList<>();
        arrayList.add(rubinoPostObject);
        rubinoPostObject.updateTime = System.currentTimeMillis();
        addToPostMap(arrayList);
    }

    private void addToPostMap(ArrayList<RubinoPostObject> arrayList) {
        if (this.postMap.size() > 1000) {
            this.postMap.clear();
        }
        Iterator<RubinoPostObject> it = arrayList.iterator();
        while (it.hasNext()) {
            RubinoPostObject next = it.next();
            next.updateTime = System.currentTimeMillis();
            this.postMap.put(next.post.id, next);
        }
    }

    public RubinoPostObject getFromPostMapIfExist(String str) {
        RubinoPostObject rubinoPostObject = this.postMap.get(str);
        if (rubinoPostObject == null || System.currentTimeMillis() - rubinoPostObject.updateTime >= 300000) {
            return null;
        }
        return rubinoPostObject;
    }

    public Dialog onFollowButtonInProfileClicked(RubinoProfileObject rubinoProfileObject) {
        if (rubinoProfileObject.isMyProfile) {
            return null;
        }
        if (isProfileBlocked(rubinoProfileObject)) {
            if (ApplicationLoader.applicationActivity != null) {
                ToastiLikeSnack.showL(ApplicationLoader.applicationActivity, LocaleController.getString(R.string.rubinoFollowBlockedProfileAlert));
            }
            return null;
        }
        if (isProfileFollowRequested(rubinoProfileObject) || isProfileFollowed(rubinoProfileObject)) {
            if (ApplicationLoader.applicationActivity == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            RubinoBottomUpAlert rubinoBottomUpAlertCreateRubinoDialogItems = RubinoBottomUpAlert.createRubinoDialogItems(ApplicationLoader.applicationActivity.getLastFragment(), rubinoProfileObject.getUsername(), arrayList);
            arrayList.add(new Rubino.AlertBlockItem(rubinoProfileObject, rubinoBottomUpAlertCreateRubinoDialogItems));
            arrayList.add(new Rubino.AlertUnFollowItem(rubinoProfileObject, rubinoBottomUpAlertCreateRubinoDialogItems));
            rubinoBottomUpAlertCreateRubinoDialogItems.listAdapter.notifyDataSetChanged();
            return rubinoBottomUpAlertCreateRubinoDialogItems;
        }
        doFollowUnfollowAction(rubinoProfileObject, Rubino.FollowActionTypeEnum.Follow);
        return null;
    }

    public void doFollowUnfollowAction(RubinoProfileObject rubinoProfileObject) {
        doFollowUnfollowAction(rubinoProfileObject, (isProfileFollowRequested(rubinoProfileObject) || isProfileFollowed(rubinoProfileObject)) ? Rubino.FollowActionTypeEnum.Unfollow : Rubino.FollowActionTypeEnum.Follow);
    }

    public void doFollowUnfollowAction(final RubinoProfileObject rubinoProfileObject, final Rubino.FollowActionTypeEnum followActionTypeEnum) {
        Rubino.RequestFollowInput requestFollowInput = new Rubino.RequestFollowInput(AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id);
        String str = rubinoProfileObject.id;
        requestFollowInput.followee_id = str;
        requestFollowInput.f_type = followActionTypeEnum;
        if (followActionTypeEnum == Rubino.FollowActionTypeEnum.Unfollow) {
            rubinoProfileObject.isFollowed = false;
            rubinoProfileObject.isRequested = false;
            addToFollowedProfileMap(str, false);
            addToFollowRequestedMap(rubinoProfileObject.id, false);
        } else if (rubinoProfileObject.isPrivate()) {
            rubinoProfileObject.isRequested = true;
            rubinoProfileObject.isFollowed = false;
            addToFollowRequestedMap(rubinoProfileObject.id, true);
            addToFollowedProfileMap(rubinoProfileObject.id, false);
        } else {
            rubinoProfileObject.isRequested = false;
            rubinoProfileObject.isFollowed = true;
            addToFollowRequestedMap(rubinoProfileObject.id, false);
            addToFollowedProfileMap(rubinoProfileObject.id, true);
        }
        getNotificationCenter().postNotificationName(NotificationCenter.rubinoFollowBlockChanged, rubinoProfileObject.id);
        if (this.followObserverMap.containsKey(rubinoProfileObject.id)) {
            this.followObserverMap.get(rubinoProfileObject.id).dispose();
        }
        DisposableObserver disposableObserver = (DisposableObserver) getApiRequestMessangerRx().requestFollow(requestFollowInput).subscribeWith(new DisposableObserver<MessangerOutput>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.39
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput messangerOutput) {
                RubinoController.this.followObserverMap.remove(rubinoProfileObject.id);
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                RubinoController.this.followObserverMap.remove(rubinoProfileObject.id);
                if (followActionTypeEnum == Rubino.FollowActionTypeEnum.Follow) {
                    RubinoProfileObject rubinoProfileObject2 = rubinoProfileObject;
                    rubinoProfileObject2.isFollowed = false;
                    rubinoProfileObject2.isRequested = false;
                    RubinoController.this.addToFollowedProfileMap(rubinoProfileObject2.id, false);
                    RubinoController.this.addToFollowRequestedMap(rubinoProfileObject.id, false);
                } else if (rubinoProfileObject.isPrivate()) {
                    RubinoProfileObject rubinoProfileObject3 = rubinoProfileObject;
                    rubinoProfileObject3.isRequested = true;
                    rubinoProfileObject3.isFollowed = false;
                    RubinoController.this.addToFollowRequestedMap(rubinoProfileObject3.id, true);
                    RubinoController.this.addToFollowedProfileMap(rubinoProfileObject.id, false);
                } else {
                    RubinoProfileObject rubinoProfileObject4 = rubinoProfileObject;
                    rubinoProfileObject4.isRequested = false;
                    rubinoProfileObject4.isFollowed = true;
                    RubinoController.this.addToFollowRequestedMap(rubinoProfileObject4.id, false);
                    RubinoController.this.addToFollowedProfileMap(rubinoProfileObject.id, true);
                }
                RubinoController.this.getNotificationCenter().postNotificationName(NotificationCenter.rubinoFollowBlockChanged, rubinoProfileObject.id);
            }
        });
        this.followObserverMap.put(rubinoProfileObject.id, disposableObserver);
        this.compositeDisposable.add(disposableObserver);
    }

    public void editPost(CompositeDisposable compositeDisposable, final String str, String str2, Boolean bool, Boolean bool2, String str3, String[] strArr) {
        Rubino.EditPostInput editPostInput = new Rubino.EditPostInput(AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id);
        editPostInput.post_id = str;
        editPostInput.caption = str2;
        editPostInput.allow_show_comment = bool;
        editPostInput.is_for_sale = bool2;
        editPostInput.sale_price = str3;
        editPostInput.product_types = strArr;
        compositeDisposable.add((Disposable) getApiRequestMessangerRx().editPost(editPostInput).observeOn(Schedulers.computation()).doOnNext(new Consumer<MessangerOutput<Rubino.EditPostOutput>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.41
            @Override // io.reactivex.functions.Consumer
            public void accept(MessangerOutput<Rubino.EditPostOutput> messangerOutput) throws Exception {
                if (messangerOutput.data.post != null) {
                    RubinoPostObject rubinoPostObject = new RubinoPostObject();
                    rubinoPostObject.setPost(messangerOutput.data.post, ((BaseController) RubinoController.this).currentAccount);
                    RubinoPostObject fromPostMapIfExist = RubinoController.this.getFromPostMapIfExist(str);
                    if (fromPostMapIfExist != null) {
                        rubinoPostObject.isLiked = fromPostMapIfExist.isLiked;
                        rubinoPostObject.isBookmarked = fromPostMapIfExist.isBookmarked;
                    }
                    rubinoPostObject.isMyPost = true;
                    RubinoController.this.addToPostMap(rubinoPostObject);
                }
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<MessangerOutput<Rubino.EditPostOutput>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.40
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput<Rubino.EditPostOutput> messangerOutput) {
                RubinoController.this.getNotificationCenter().postNotificationName(NotificationCenter.rubinoPostEdited, str);
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                RubinoController.this.getNotificationCenter().postNotificationName(NotificationCenter.rubinoPostEditedFailed, str);
            }
        }));
    }

    public Observable<MessangerOutput<Rubino.SetPostProductsOutput>> setPostProducts(final String str, ArrayList<String> arrayList) {
        Rubino.SetPostProductsInput setPostProductsInput = new Rubino.SetPostProductsInput(AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id);
        setPostProductsInput.post_id = str;
        setPostProductsInput.product_ids = arrayList;
        return getApiRequestMessangerRx().setPostProducts(setPostProductsInput).observeOn(Schedulers.computation()).doOnNext(new Consumer<MessangerOutput<Rubino.SetPostProductsOutput>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.42
            @Override // io.reactivex.functions.Consumer
            public void accept(MessangerOutput<Rubino.SetPostProductsOutput> messangerOutput) throws Exception {
                if (messangerOutput.data.post != null) {
                    RubinoPostObject rubinoPostObject = new RubinoPostObject();
                    rubinoPostObject.setPost(messangerOutput.data.post, ((BaseController) RubinoController.this).currentAccount);
                    RubinoPostObject fromPostMapIfExist = RubinoController.this.getFromPostMapIfExist(str);
                    if (fromPostMapIfExist != null) {
                        rubinoPostObject.isLiked = fromPostMapIfExist.isLiked;
                        rubinoPostObject.isBookmarked = fromPostMapIfExist.isBookmarked;
                    }
                    rubinoPostObject.isMyPost = true;
                    RubinoController.this.addToPostMap(rubinoPostObject);
                }
            }
        }).observeOn(AndroidSchedulers.mainThread());
    }

    public void onLikePostClick(final RubinoPostObject rubinoPostObject, final Rubino.LikeActionTypeEnum likeActionTypeEnum) {
        if (rubinoPostObject == null || rubinoPostObject.post == null || likeActionTypeEnum == null) {
            return;
        }
        Rubino.LikeActionInput likeActionInput = new Rubino.LikeActionInput(AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id);
        Rubino.PostObjectFromServer postObjectFromServer = rubinoPostObject.post;
        likeActionInput.post_profile_id = postObjectFromServer.profile_id;
        likeActionInput.post_id = postObjectFromServer.id;
        Rubino.LikeActionTypeEnum likeActionTypeEnum2 = Rubino.LikeActionTypeEnum.Unlike;
        if (likeActionTypeEnum == likeActionTypeEnum2) {
            likeActionInput.action_type = likeActionTypeEnum2;
            postObjectFromServer.likes_count = NumberUtils.decrementIfPossibe(postObjectFromServer.likes_count);
        } else {
            likeActionInput.action_type = Rubino.LikeActionTypeEnum.Like;
            postObjectFromServer.likes_count = NumberUtils.incrementIfPossibe(postObjectFromServer.likes_count);
        }
        rubinoPostObject.createLikeCountSpan();
        rubinoPostObject.isLiked = likeActionTypeEnum == Rubino.LikeActionTypeEnum.Like;
        RubinoPostObject rubinoPostObject2 = this.postMap.get(rubinoPostObject.post.id);
        if (rubinoPostObject2 != null) {
            rubinoPostObject2.isLiked = rubinoPostObject.isLiked;
            rubinoPostObject2.post.likes_count = rubinoPostObject.post.likes_count;
            rubinoPostObject2.createLikeCountSpan();
        }
        getNotificationCenter().postNotificationName(NotificationCenter.rubinoLikePostChanged, rubinoPostObject.post.id, Boolean.valueOf(rubinoPostObject.isLiked), Long.valueOf(rubinoPostObject.post.likes_count));
        if (this.likePostObserverMap.containsKey(rubinoPostObject.post.id)) {
            this.likePostObserverMap.get(rubinoPostObject.post.id).dispose();
        }
        DisposableObserver disposableObserver = (DisposableObserver) getApiRequestMessangerRx().likePostAction(likeActionInput).subscribeWith(new DisposableObserver<MessangerOutput>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.43
            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput messangerOutput) {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                if (th instanceof ApiServerException) {
                    return;
                }
                RubinoController.this.likePostObserverMap.remove(rubinoPostObject.post.id);
                RubinoPostObject rubinoPostObject3 = rubinoPostObject;
                boolean z = likeActionTypeEnum != Rubino.LikeActionTypeEnum.Like;
                rubinoPostObject3.isLiked = z;
                if (z) {
                    Rubino.PostObjectFromServer postObjectFromServer2 = rubinoPostObject3.post;
                    postObjectFromServer2.likes_count = NumberUtils.incrementIfPossibe(postObjectFromServer2.likes_count);
                } else {
                    Rubino.PostObjectFromServer postObjectFromServer3 = rubinoPostObject3.post;
                    postObjectFromServer3.likes_count = NumberUtils.decrementIfPossibe(postObjectFromServer3.likes_count);
                }
                rubinoPostObject.createLikeCountSpan();
                RubinoPostObject rubinoPostObject4 = (RubinoPostObject) RubinoController.this.postMap.get(rubinoPostObject.post.id);
                if (rubinoPostObject4 != null) {
                    RubinoPostObject rubinoPostObject5 = rubinoPostObject;
                    rubinoPostObject4.isLiked = rubinoPostObject5.isLiked;
                    rubinoPostObject4.post.likes_count = rubinoPostObject5.post.likes_count;
                    rubinoPostObject4.createCaptionSpan();
                }
                NotificationCenter notificationCenter = RubinoController.this.getNotificationCenter();
                int i = NotificationCenter.rubinoLikePostChanged;
                RubinoPostObject rubinoPostObject6 = rubinoPostObject;
                notificationCenter.postNotificationName(i, rubinoPostObject6.post.id, Boolean.valueOf(rubinoPostObject6.isLiked), Long.valueOf(rubinoPostObject.post.likes_count));
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                RubinoController.this.likePostObserverMap.remove(rubinoPostObject.post.id);
            }
        });
        this.likePostObserverMap.put(rubinoPostObject.post.id, disposableObserver);
        this.compositeDisposable.add(disposableObserver);
    }

    public void onLikeCommentClick(final RubinoCommentObject rubinoCommentObject, String str, final Rubino.LikeActionTypeEnum likeActionTypeEnum) {
        if (rubinoCommentObject == null || rubinoCommentObject.comment == null || likeActionTypeEnum == null) {
            return;
        }
        Rubino.LikeActionInput likeActionInput = new Rubino.LikeActionInput(AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id);
        likeActionInput.post_id = str;
        Rubino.CommentFromServer commentFromServer = rubinoCommentObject.comment;
        likeActionInput.comment_id = commentFromServer.id;
        Rubino.LikeActionTypeEnum likeActionTypeEnum2 = Rubino.LikeActionTypeEnum.Unlike;
        if (likeActionTypeEnum == likeActionTypeEnum2) {
            likeActionInput.action_type = likeActionTypeEnum2;
            commentFromServer.likes_count = NumberUtils.decrementIfPossibe(commentFromServer.likes_count);
        } else {
            likeActionInput.action_type = Rubino.LikeActionTypeEnum.Like;
            commentFromServer.likes_count = NumberUtils.incrementIfPossibe(commentFromServer.likes_count);
        }
        rubinoCommentObject.createLikeCountString();
        rubinoCommentObject.isLiked = likeActionTypeEnum == Rubino.LikeActionTypeEnum.Like;
        getNotificationCenter().postNotificationName(NotificationCenter.rubinoLikeCommentChanged, rubinoCommentObject.comment.id, Boolean.valueOf(rubinoCommentObject.isLiked), Integer.valueOf(rubinoCommentObject.comment.likes_count));
        if (this.likeCommentObserverMap.containsKey(rubinoCommentObject.comment.id)) {
            this.likeCommentObserverMap.get(rubinoCommentObject.comment.id).dispose();
        }
        DisposableObserver disposableObserver = (DisposableObserver) getApiRequestMessangerRx().likeCommentAction(likeActionInput).subscribeWith(new DisposableObserver<MessangerOutput>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.44
            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput messangerOutput) {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                if (th instanceof ApiServerException) {
                    return;
                }
                RubinoController.this.likeCommentObserverMap.remove(rubinoCommentObject.comment.id);
                RubinoCommentObject rubinoCommentObject2 = rubinoCommentObject;
                boolean z = likeActionTypeEnum != Rubino.LikeActionTypeEnum.Like;
                rubinoCommentObject2.isLiked = z;
                if (z) {
                    Rubino.CommentFromServer commentFromServer2 = rubinoCommentObject2.comment;
                    commentFromServer2.likes_count = NumberUtils.incrementIfPossibe(commentFromServer2.likes_count);
                } else {
                    Rubino.CommentFromServer commentFromServer3 = rubinoCommentObject2.comment;
                    commentFromServer3.likes_count = NumberUtils.decrementIfPossibe(commentFromServer3.likes_count);
                }
                rubinoCommentObject.createLikeCountString();
                NotificationCenter notificationCenter = RubinoController.this.getNotificationCenter();
                int i = NotificationCenter.rubinoLikeCommentChanged;
                RubinoCommentObject rubinoCommentObject3 = rubinoCommentObject;
                notificationCenter.postNotificationName(i, rubinoCommentObject3.comment.id, Boolean.valueOf(rubinoCommentObject3.isLiked), Integer.valueOf(rubinoCommentObject.comment.likes_count));
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                RubinoController.this.likeCommentObserverMap.remove(rubinoCommentObject.comment.id);
            }
        });
        this.likeCommentObserverMap.put(rubinoCommentObject.comment.id, disposableObserver);
        this.compositeDisposable.add(disposableObserver);
    }

    public void onBlockClick(final RubinoProfileObject rubinoProfileObject, final Dialog dialog) {
        String string;
        String str;
        String str2;
        if (isProfileBlocked(rubinoProfileObject)) {
            string = LocaleController.getString(R.string.rubinoUnBlock);
            str = string + " " + rubinoProfileObject.getUsername() + " ؟";
            str2 = str + "\n\n" + LocaleController.getString(R.string.rubinoUnblockAlert);
        } else {
            string = LocaleController.getString(R.string.rubinoBlock);
            str = string + " " + rubinoProfileObject.getUsername() + " ؟";
            str2 = str + "\n\n" + LocaleController.getString(R.string.rubinoBlockAlert);
        }
        int iIndexOf = str2.indexOf(str);
        if (ApplicationLoader.applicationActivity != null) {
            showRubinoCenterDialog(true, SpanHelper.makeBoldWithColorAndRelativeSize(new SpannableString(str2), iIndexOf, str.length() + iIndexOf, Theme.getColor(Theme.key_rubinoBlackColor), 1.5f), string, new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.45
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    RubinoController.this.doBlockUnblockAction(rubinoProfileObject);
                    Dialog dialog2 = dialog;
                    if (dialog2 != null) {
                        dialog2.dismiss();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doBlockUnblockAction(final RubinoProfileObject rubinoProfileObject) {
        final Rubino.BlockInput blockInput = new Rubino.BlockInput(AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id);
        blockInput.blocked_id = rubinoProfileObject.id;
        if (isProfileBlocked(rubinoProfileObject)) {
            blockInput.action = Rubino.BlockActionEnum.Unblock;
        } else {
            blockInput.action = Rubino.BlockActionEnum.Block;
        }
        DisposableObserver disposableObserver = this.blockObserverMap.get(rubinoProfileObject.id);
        if (disposableObserver != null) {
            disposableObserver.dispose();
        }
        DisposableObserver disposableObserver2 = (DisposableObserver) getApiRequestMessangerRx().setBlockProfile(blockInput).subscribeWith(new DisposableObserver<MessangerOutput>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.46
            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput messangerOutput) {
                RubinoProfileObject rubinoProfileObject2 = rubinoProfileObject;
                Rubino.BlockActionEnum blockActionEnum = blockInput.action;
                Rubino.BlockActionEnum blockActionEnum2 = Rubino.BlockActionEnum.Block;
                boolean z = blockActionEnum == blockActionEnum2;
                rubinoProfileObject2.isBlocked = z;
                RubinoController.this.addToBlockedMap(rubinoProfileObject2.id, z);
                RubinoController.this.followedProfileMap.remove(rubinoProfileObject.id);
                RubinoController.this.followRequestedProfileMap.remove(rubinoProfileObject.id);
                if (blockInput.action == blockActionEnum2) {
                    RubinoController.this.addToFollowedProfileMap(rubinoProfileObject.id, false);
                    RubinoController.this.addToFollowRequestedMap(rubinoProfileObject.id, false);
                    RubinoProfileObject rubinoProfileObject3 = rubinoProfileObject;
                    rubinoProfileObject3.isFollowed = false;
                    rubinoProfileObject3.isRequested = false;
                }
                NotificationCenter notificationCenter = RubinoController.this.getNotificationCenter();
                int i = NotificationCenter.rubinoFollowBlockChanged;
                RubinoProfileObject rubinoProfileObject4 = rubinoProfileObject;
                notificationCenter.postNotificationName(i, rubinoProfileObject4.id, Boolean.valueOf(rubinoProfileObject4.isBlocked));
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                RubinoController.this.blockObserverMap.remove(rubinoProfileObject.id);
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                RubinoController.this.blockObserverMap.remove(rubinoProfileObject.id);
            }
        });
        this.blockObserverMap.put(rubinoProfileObject.id, disposableObserver2);
        this.compositeDisposable.add(disposableObserver2);
    }

    public void doBlockAction(final String str) {
        final Rubino.BlockInput blockInput = new Rubino.BlockInput(AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id);
        blockInput.blocked_id = str;
        blockInput.action = Rubino.BlockActionEnum.Block;
        DisposableObserver disposableObserver = this.blockObserverMap.get(str);
        if (disposableObserver != null) {
            disposableObserver.dispose();
        }
        DisposableObserver disposableObserver2 = (DisposableObserver) getApiRequestMessangerRx().setBlockProfile(blockInput).subscribeWith(new DisposableObserver<MessangerOutput>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.47
            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput messangerOutput) {
                RubinoController rubinoController = RubinoController.this;
                String str2 = str;
                Rubino.BlockActionEnum blockActionEnum = blockInput.action;
                Rubino.BlockActionEnum blockActionEnum2 = Rubino.BlockActionEnum.Block;
                rubinoController.addToBlockedMap(str2, blockActionEnum == blockActionEnum2);
                RubinoController.this.followedProfileMap.remove(str);
                RubinoController.this.followRequestedProfileMap.remove(str);
                if (blockInput.action == blockActionEnum2) {
                    RubinoController.this.addToFollowedProfileMap(str, false);
                    RubinoController.this.addToFollowRequestedMap(str, false);
                }
                NotificationCenter notificationCenter = RubinoController.this.getNotificationCenter();
                int i = NotificationCenter.rubinoFollowBlockChanged;
                Object[] objArr = new Object[2];
                objArr[0] = str;
                objArr[1] = Boolean.valueOf(blockInput.action == blockActionEnum2);
                notificationCenter.postNotificationName(i, objArr);
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                RubinoController.this.blockObserverMap.remove(str);
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                RubinoController.this.blockObserverMap.remove(str);
            }
        });
        this.blockObserverMap.put(str, disposableObserver2);
        this.compositeDisposable.add(disposableObserver2);
    }

    public static void showRubinoCenterDialog(boolean z, boolean z2, RubinoProfileObject rubinoProfileObject, SpannableString spannableString, String str, View.OnClickListener onClickListener) {
        showRubinoCenterDialog(z, z2, rubinoProfileObject, spannableString, str, LocaleController.getString(R.string.cancel2), -16476939, Theme.getColor(Theme.key_rubinoBlackColor), onClickListener, null);
    }

    public void onPostSaleListClick(String str) {
        if (ApplicationLoader.applicationActivity != null) {
            ListInput listInput = new ListInput(ListInput.ItemType.instaPostSale);
            listInput.post_id = str;
            ApplicationLoader.applicationActivity.lambda$runLinkRequest$40(new InstaNewEventsFragment(listInput));
        }
    }

    public void reportPost(RubinoPostObject rubinoPostObject, int i) {
        Rubino.ReportInput reportInput = new Rubino.ReportInput(AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id);
        Rubino.PostObjectFromServer postObjectFromServer = rubinoPostObject.post;
        reportInput.setForPost(postObjectFromServer.id, postObjectFromServer.profile_id, i);
        NotificationCenter notificationCenter = getNotificationCenter();
        int i2 = NotificationCenter.rubinoPostDeleted;
        Rubino.PostObjectFromServer postObjectFromServer2 = rubinoPostObject.post;
        notificationCenter.postNotificationName(i2, postObjectFromServer2.id, postObjectFromServer2.profile_id);
        reportRecord(reportInput);
    }

    public void reportComment(RubinoCommentObject rubinoCommentObject, String str, int i) {
        Rubino.ReportInput reportInput = new Rubino.ReportInput(AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id);
        reportInput.setForComment(rubinoCommentObject.comment.id, str, i);
        reportRecord(reportInput);
    }

    public void reportProfile(RubinoProfileObject rubinoProfileObject, int i) {
        Rubino.ReportInput reportInput = new Rubino.ReportInput(AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id);
        reportInput.setForProfile(rubinoProfileObject.id, i);
        reportRecord(reportInput);
    }

    public void reportLive(String str, String str2, int i) {
        Rubino.ReportInput reportInput = new Rubino.ReportInput(AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id);
        reportInput.setForLive(str2, str, i);
        reportRecord(reportInput);
    }

    private void reportRecord(Rubino.ReportInput reportInput) {
        if (ApplicationLoader.applicationActivity != null) {
            ToastiLikeSnack.showL(ApplicationLoader.applicationActivity, LocaleController.getString("ReportSent", R.string.ReportSent));
        }
        this.compositeDisposable.add((Disposable) getApiRequestMessangerRx().rubinoReportRecord(reportInput).subscribeWith(new DisposableObserver<MessangerOutput>(this) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.48
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

    public void shareOrCopyStory(CompositeDisposable compositeDisposable, StoryObject storyObject) {
        new MainClickHandler().directStory(storyObject);
    }

    public void shareOrCopyPost(final boolean z, final boolean z2, CompositeDisposable compositeDisposable, final RubinoPostObject rubinoPostObject) {
        String str = rubinoPostObject.post.share_url;
        if (str != null && !str.isEmpty()) {
            if (z) {
                new MainClickHandler().onCopyClicked(rubinoPostObject.post.share_url);
                return;
            } else if (z2) {
                new MainClickHandler().directPost(rubinoPostObject);
                return;
            } else {
                new MainClickHandler().shareStringOrLink(rubinoPostObject.post.share_url);
                return;
            }
        }
        final LoadingDialog loadingDialog = new LoadingDialog(ApplicationLoader.applicationActivity);
        Rubino.GetPostShareLinkInput getPostShareLinkInput = new Rubino.GetPostShareLinkInput(AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id);
        Rubino.PostObjectFromServer postObjectFromServer = rubinoPostObject.post;
        getPostShareLinkInput.post_id = postObjectFromServer.id;
        getPostShareLinkInput.post_profile_id = postObjectFromServer.profile_id;
        final DisposableObserver disposableObserver = (DisposableObserver) getApiRequestMessangerRx().getPostShareLink(getPostShareLinkInput).subscribeWith(new DisposableObserver<MessangerOutput<Rubino.GetPostShareLinkOutput>>(this) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.49
            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput<Rubino.GetPostShareLinkOutput> messangerOutput) {
                Rubino.GetPostShareLinkOutput getPostShareLinkOutput = messangerOutput.data;
                if (getPostShareLinkOutput.share_url != null) {
                    rubinoPostObject.post.share_url = getPostShareLinkOutput.share_url;
                    if (z) {
                        new MainClickHandler().onCopyClicked(rubinoPostObject.post.share_url);
                    } else if (z2) {
                        new MainClickHandler().directPost(rubinoPostObject);
                    } else {
                        new MainClickHandler().shareStringOrLink(rubinoPostObject.post.share_url);
                    }
                }
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                loadingDialog.dismiss();
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                loadingDialog.dismiss();
            }
        });
        compositeDisposable.add(disposableObserver);
        loadingDialog.setOnCancelListener(new DialogInterface.OnCancelListener(this) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.50
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                disposableObserver.dispose();
            }
        });
    }

    public void shareProfile(RubinoProfileObject rubinoProfileObject) {
        if (rubinoProfileObject.getUsername() == null || rubinoProfileObject.getUsername().isEmpty()) {
            return;
        }
        new MainClickHandler().onTextShare("https://" + LocaleController.getString(R.string.appHostDomainPlain) + "/" + rubinoProfileObject.getUsername());
    }

    public void copyProfile(RubinoProfileObject rubinoProfileObject) {
        if (rubinoProfileObject.getUsername() == null || rubinoProfileObject.getUsername().isEmpty()) {
            return;
        }
        new MainClickHandler().onCopyClicked("https://" + LocaleController.getString(R.string.appHostDomainPlain) + "/" + rubinoProfileObject.getUsername());
    }

    public void deleteProfilePage(final RubinoProfileObject rubinoProfileObject) {
        if (ApplicationLoader.applicationActivity == null) {
            return;
        }
        String string = LocaleController.formatString(R.string.rubinoDeletePageQuestion, rubinoProfileObject.username);
        showRubinoCenterDialog(true, SpanHelper.makeWithColorAndRelativeSize(new SpannableString(string + "\n\n" + LocaleController.getString(R.string.rubinoDeletePageQuestionInfo)), 0, string.length(), Theme.getColor(Theme.key_rubinoBlackColor), 1.5f), LocaleController.getString(R.string.rubinoDeletePage), new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.51
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RubinoController.this.compositeDisposable.add((Disposable) RubinoController.this.getApiRequestMessangerRx().removeRecord(Rubino.RemoveRecordInput.setInputForProfile(AppRubinoPreferences.getInstance(((BaseController) RubinoController.this).currentAccount).getRubinoCurrentProfileObject().id, rubinoProfileObject.id)).subscribeWith(new DisposableObserver<MessangerOutput<Rubino.RemoveRecordOutput>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.51.1
                    @Override // io.reactivex.Observer
                    public void onComplete() {
                    }

                    @Override // io.reactivex.Observer
                    public void onError(Throwable th) {
                    }

                    @Override // io.reactivex.Observer
                    public void onNext(MessangerOutput<Rubino.RemoveRecordOutput> messangerOutput) {
                        RubinoController.this.getNotificationCenter().postNotificationName(NotificationCenter.rubinoProfileDeleted, rubinoProfileObject.id);
                        if (AppRubinoPreferences.getInstance(((BaseController) RubinoController.this).currentAccount).getProfilesOutput2() != null && AppRubinoPreferences.getInstance(((BaseController) RubinoController.this).currentAccount).getProfilesOutput2().profiles != null) {
                            Rubino.GetProfileListOutput profilesOutput2 = AppRubinoPreferences.getInstance(((BaseController) RubinoController.this).currentAccount).getProfilesOutput2();
                            Iterator<RubinoProfileObject> it = profilesOutput2.profiles.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                RubinoProfileObject next = it.next();
                                String str = next.id;
                                if (str != null && str.equals(rubinoProfileObject.id)) {
                                    profilesOutput2.profiles.remove(next);
                                    break;
                                }
                            }
                            AppRubinoPreferences.getInstance(((BaseController) RubinoController.this).currentAccount).setRubinoProfilesOutput(profilesOutput2);
                        }
                        if (AppRubinoPreferences.getInstance(((BaseController) RubinoController.this).currentAccount).getRubinoDefaultProfileObject() != null) {
                            new MainClickHandler().changeRubinoProfile(AppRubinoPreferences.getInstance(((BaseController) RubinoController.this).currentAccount).getRubinoDefaultProfileObject());
                        }
                    }
                }));
            }
        });
    }

    public void onEditPostClicked(BaseFragment baseFragment, RubinoPostObject rubinoPostObject) {
        baseFragment.presentFragment(new RubinoEditPostActivity(rubinoPostObject));
    }

    public void deletePost(final RubinoPostObject rubinoPostObject) {
        if (ApplicationLoader.applicationActivity == null) {
            return;
        }
        showRubinoCenterDialog(true, SpanHelper.makeWithColorAndRelativeSize(LocaleController.getString(R.string.rubinoDeletePostQuestion), Theme.getColor(Theme.key_rubinoBlackColor), 1.5f), LocaleController.getString(R.string.rubinoDeletePost), new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.52
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RubinoController.this.compositeDisposable.add((Disposable) RubinoController.this.getApiRequestMessangerRx().removeRecord(Rubino.RemoveRecordInput.setInputForPost(AppRubinoPreferences.getInstance(((BaseController) RubinoController.this).currentAccount).getRubinoCurrentProfileObject().id, rubinoPostObject.post.id)).observeOn(Schedulers.computation()).doOnNext(new Consumer<MessangerOutput<Rubino.RemoveRecordOutput>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.52.2
                    @Override // io.reactivex.functions.Consumer
                    public void accept(MessangerOutput<Rubino.RemoveRecordOutput> messangerOutput) throws Exception {
                        AnonymousClass52 anonymousClass52 = AnonymousClass52.this;
                        RubinoProfileObject rubinoProfileObject = RubinoController.this.profileMap.get(rubinoPostObject.post.profile_id);
                        if (rubinoProfileObject != null) {
                            rubinoProfileObject.post_count = NumberUtils.decrementIfPossibe(rubinoProfileObject.post_count);
                            rubinoProfileObject.createCountString();
                        }
                        RubinoController.this.postMap.remove(rubinoPostObject.post.id);
                    }
                }).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<MessangerOutput<Rubino.RemoveRecordOutput>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.52.1
                    @Override // io.reactivex.Observer
                    public void onComplete() {
                    }

                    @Override // io.reactivex.Observer
                    public void onError(Throwable th) {
                    }

                    @Override // io.reactivex.Observer
                    public void onNext(MessangerOutput<Rubino.RemoveRecordOutput> messangerOutput) {
                        NotificationCenter notificationCenter = RubinoController.this.getNotificationCenter();
                        int i = NotificationCenter.rubinoPostDeleted;
                        Rubino.PostObjectFromServer postObjectFromServer = rubinoPostObject.post;
                        notificationCenter.postNotificationName(i, postObjectFromServer.id, postObjectFromServer.profile_id);
                    }
                }));
            }
        });
    }

    public Observable<MessangerOutput<Rubino.RemoveRecordOutput>> getDeleteCommentObservable(final RubinoCommentObject rubinoCommentObject) {
        String str = AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id;
        Rubino.CommentFromServer commentFromServer = rubinoCommentObject.comment;
        return getApiRequestMessangerRx().removeRecord(Rubino.RemoveRecordInput.setInputForComment(str, commentFromServer.id, commentFromServer.post_id)).observeOn(AndroidSchedulers.mainThread()).doOnNext(new Consumer<MessangerOutput<Rubino.RemoveRecordOutput>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.53
            @Override // io.reactivex.functions.Consumer
            public void accept(MessangerOutput<Rubino.RemoveRecordOutput> messangerOutput) throws Exception {
                RubinoController rubinoController = RubinoController.this;
                RubinoCommentObject rubinoCommentObject2 = rubinoCommentObject;
                rubinoController.updatePostOnDeleteComment(rubinoCommentObject2.comment.post_id, rubinoCommentObject2);
            }
        });
    }

    public void onAddPost(Rubino.PostObjectFromServer postObjectFromServer, String str) {
        RubinoProfileObject rubinoProfileObject = this.profileMap.get(str);
        if (rubinoProfileObject != null) {
            rubinoProfileObject.post_count = NumberUtils.incrementIfPossibe(rubinoProfileObject.post_count);
            rubinoProfileObject.createCountString();
        }
    }

    public static void showRubinoCenterDialog(boolean z, boolean z2, RubinoProfileObject rubinoProfileObject, SpannableString spannableString, String str, String str2, int i, int i2, final View.OnClickListener onClickListener, final View.OnClickListener onClickListener2) {
        LaunchActivity launchActivity = ApplicationLoader.applicationActivity;
        if (launchActivity == null) {
            return;
        }
        UILinearLayout uILinearLayout = new UILinearLayout();
        uILinearLayout.createView(launchActivity);
        final JustLinearLayoutDialog justLinearLayoutDialog = new JustLinearLayoutDialog(launchActivity, uILinearLayout.view);
        uILinearLayout.linearLayout.setBackgroundColor(Theme.getColor(Theme.key_dialogBackground));
        uILinearLayout.linearLayout.removeAllViews();
        uILinearLayout.linearLayout.setGravity(1);
        uILinearLayout.linearLayout.getLayoutParams().width = (int) Math.min(AndroidUtilities.dp(300.0f), DimensionHelper.getScreenWidth(launchActivity) * 0.73333335f);
        if (z) {
            ImageView imageView = new ImageView(launchActivity);
            GlideHelper.loadCircle(launchActivity, imageView, rubinoProfileObject.full_thumbnail_url, R.drawable.placeholder_avatar_man);
            uILinearLayout.linearLayout.addView(imageView, LayoutHelper.createFrame(100, 100.0f, 1, 8.0f, 28.0f, 8.0f, 12.0f));
        }
        TextView textView = new TextView(launchActivity);
        int i3 = Theme.key_rubinoGrayColor;
        textView.setTextColor(Theme.getColor(i3));
        textView.setTypeface(Theme.getRubinoTypeFaceRegular());
        textView.setGravity(1);
        textView.setTextSize(2, 13.0f);
        textView.setPadding(AndroidUtilities.dp(20.0f), AndroidUtilities.dp(16.0f), AndroidUtilities.dp(20.0f), AndroidUtilities.dp(16.0f));
        textView.setText(spannableString);
        uILinearLayout.linearLayout.addView(textView);
        FrameLayout frameLayout = new FrameLayout(launchActivity);
        frameLayout.setBackgroundColor(Theme.getColor(i3));
        frameLayout.setAlpha(0.5f);
        uILinearLayout.linearLayout.addView(frameLayout, LayoutHelper.createFrame(-1, 1.0f));
        TextView textView2 = new TextView(launchActivity);
        textView2.setTextColor(i);
        textView2.setTypeface(Theme.getRubinoTypeFaceRegular(), 1);
        textView2.setGravity(17);
        textView2.setTextSize(2, 16.0f);
        textView2.setPadding(AndroidUtilities.dp(16.0f), AndroidUtilities.dp(14.0f), AndroidUtilities.dp(16.0f), AndroidUtilities.dp(14.0f));
        textView2.setText(str);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.54
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                JustLinearLayoutDialog justLinearLayoutDialog2 = justLinearLayoutDialog;
                if (justLinearLayoutDialog2 != null) {
                    justLinearLayoutDialog2.dismiss();
                }
                View.OnClickListener onClickListener3 = onClickListener;
                if (onClickListener3 != null) {
                    onClickListener3.onClick(view);
                }
            }
        });
        uILinearLayout.linearLayout.addView(textView2);
        if (z2) {
            FrameLayout frameLayout2 = new FrameLayout(launchActivity);
            frameLayout2.setBackgroundColor(Theme.getColor(i3));
            frameLayout2.setAlpha(0.5f);
            uILinearLayout.linearLayout.addView(frameLayout2, LayoutHelper.createFrame(-1, 1.0f));
            TextView textView3 = new TextView(launchActivity);
            textView3.setTextColor(i2);
            textView3.setTypeface(Theme.getRubinoTypeFaceRegular());
            textView3.setGravity(1);
            textView3.setTextSize(2, 16.0f);
            textView3.setPadding(AndroidUtilities.dp(16.0f), AndroidUtilities.dp(14.0f), AndroidUtilities.dp(16.0f), AndroidUtilities.dp(14.0f));
            textView3.setText(str2);
            textView3.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.55
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    JustLinearLayoutDialog justLinearLayoutDialog2 = justLinearLayoutDialog;
                    if (justLinearLayoutDialog2 != null) {
                        justLinearLayoutDialog2.dismiss();
                    }
                    View.OnClickListener onClickListener3 = onClickListener2;
                    if (onClickListener3 != null) {
                        onClickListener3.onClick(view);
                    }
                }
            });
            uILinearLayout.linearLayout.addView(textView3);
        }
        justLinearLayoutDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rubino.ProfileListObject makeProfileList(Rubino.GetProfileListOutput getProfileListOutput) {
        ArrayList<String> arrayList;
        boolean z;
        Rubino.ProfileListObject profileListObject = new Rubino.ProfileListObject();
        profileListObject.profiles = new ArrayList<>();
        if (getProfileListOutput != null) {
            profileListObject.nextStartId = getProfileListOutput.next_start_id;
            if (getProfileListOutput.profiles != null) {
                if (getProfileListOutput instanceof Rubino.GetProfileForTagListOutput) {
                    Rubino.GetProfileForTagListOutput getProfileForTagListOutput = (Rubino.GetProfileForTagListOutput) getProfileListOutput;
                    ArrayList<String> arrayList2 = getProfileForTagListOutput.enable_profile_ids;
                    arrayList = (arrayList2 == null || arrayList2.isEmpty()) ? null : getProfileForTagListOutput.enable_profile_ids;
                    z = true;
                } else {
                    arrayList = null;
                    z = false;
                }
                Iterator<RubinoProfileObject> it = getProfileListOutput.profiles.iterator();
                while (it.hasNext()) {
                    RubinoProfileObject next = it.next();
                    String str = next.username;
                    next.username = str != null ? str.toLowerCase() : null;
                    next.createUsernameSpan();
                    Set<String> set = getProfileListOutput.following_list;
                    if (set != null) {
                        String str2 = next.id;
                        addToFollowedProfileMap(str2, set.contains(str2));
                    }
                    Set<String> set2 = getProfileListOutput.i_blocked;
                    if (set2 != null) {
                        String str3 = next.id;
                        addToBlockedMap(str3, set2.contains(str3));
                    }
                    Set<String> set3 = getProfileListOutput.i_request;
                    if (set3 != null) {
                        if (set3.contains(next.id)) {
                            this.followRequestedProfileMap.put(next.id, Boolean.TRUE);
                        } else {
                            this.followRequestedProfileMap.put(next.id, Boolean.FALSE);
                        }
                    }
                    next.isEnableForTag = !z || (arrayList != null && arrayList.contains(next.id));
                    profileListObject.profiles.add(next);
                }
            }
        }
        return profileListObject;
    }

    public void onBookmarkClick(final RubinoPostObject rubinoPostObject, final Rubino.BookMarkActionEnum bookMarkActionEnum) {
        Rubino.BookmarkActionInput bookmarkActionInput = new Rubino.BookmarkActionInput(AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id);
        Rubino.PostObjectFromServer postObjectFromServer = rubinoPostObject.post;
        bookmarkActionInput.post_profile_id = postObjectFromServer.profile_id;
        String str = postObjectFromServer.id;
        bookmarkActionInput.post_id = str;
        bookmarkActionInput.action_type = bookMarkActionEnum;
        rubinoPostObject.isBookmarked = bookMarkActionEnum != Rubino.BookMarkActionEnum.Unbookmark;
        RubinoPostObject rubinoPostObject2 = this.postMap.get(str);
        if (rubinoPostObject2 != null) {
            rubinoPostObject2.isBookmarked = rubinoPostObject.isBookmarked;
        }
        getNotificationCenter().postNotificationName(NotificationCenter.rubinoBookmarkPostChanged, rubinoPostObject.post.id, Boolean.valueOf(rubinoPostObject.isBookmarked));
        if (this.bookmarkPostObserverMap.containsKey(rubinoPostObject.post.id)) {
            this.bookmarkPostObserverMap.get(rubinoPostObject.post.id).dispose();
        }
        DisposableObserver disposableObserver = (DisposableObserver) getApiRequestMessangerRx().bookmarkPostAction(bookmarkActionInput).subscribeWith(new DisposableObserver<MessangerOutput>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.56
            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput messangerOutput) {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                if (th instanceof ApiServerException) {
                    return;
                }
                RubinoController.this.bookmarkPostObserverMap.remove(rubinoPostObject.post.id);
                rubinoPostObject.isBookmarked = bookMarkActionEnum == Rubino.BookMarkActionEnum.Unbookmark;
                RubinoPostObject rubinoPostObject3 = (RubinoPostObject) RubinoController.this.postMap.get(rubinoPostObject.post.id);
                if (rubinoPostObject3 != null) {
                    rubinoPostObject3.isBookmarked = rubinoPostObject.isBookmarked;
                }
                NotificationCenter notificationCenter = RubinoController.this.getNotificationCenter();
                int i = NotificationCenter.rubinoBookmarkPostChanged;
                RubinoPostObject rubinoPostObject4 = rubinoPostObject;
                notificationCenter.postNotificationName(i, rubinoPostObject4.post.id, Boolean.valueOf(rubinoPostObject4.isBookmarked));
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                RubinoController.this.bookmarkPostObserverMap.remove(rubinoPostObject.post.id);
            }
        });
        this.bookmarkPostObserverMap.put(rubinoPostObject.post.id, disposableObserver);
        this.compositeDisposable.add(disposableObserver);
    }

    public static void showRubinoCenterDialog(SpannableString spannableString, ArrayList<Rubino.AlertItem> arrayList) {
        LaunchActivity launchActivity = ApplicationLoader.applicationActivity;
        if (launchActivity == null || arrayList == null || arrayList.size() == 0) {
            return;
        }
        UILinearLayout uILinearLayout = new UILinearLayout();
        uILinearLayout.createView(launchActivity);
        final JustLinearLayoutDialog justLinearLayoutDialog = new JustLinearLayoutDialog(launchActivity, uILinearLayout.view);
        uILinearLayout.linearLayout.setBackgroundColor(Theme.getColor(Theme.key_dialogBackground));
        uILinearLayout.linearLayout.removeAllViews();
        uILinearLayout.linearLayout.setGravity(1);
        uILinearLayout.linearLayout.getLayoutParams().width = (int) Math.min(AndroidUtilities.dp(300.0f), DimensionHelper.getScreenWidth(launchActivity) * 0.73333335f);
        if (spannableString != null && !spannableString.toString().isEmpty()) {
            TextView textView = new TextView(launchActivity);
            int i = Theme.key_rubinoGrayColor;
            textView.setTextColor(Theme.getColor(i));
            textView.setTypeface(Theme.getRubinoTypeFaceRegular());
            textView.setGravity(1);
            textView.setTextSize(2, 13.0f);
            textView.setPadding(AndroidUtilities.dp(20.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(20.0f), AndroidUtilities.dp(16.0f));
            textView.setText(spannableString);
            uILinearLayout.linearLayout.addView(textView);
            FrameLayout frameLayout = new FrameLayout(launchActivity);
            frameLayout.setBackgroundColor(Theme.getColor(i));
            frameLayout.setAlpha(0.5f);
            uILinearLayout.linearLayout.addView(frameLayout, LayoutHelper.createFrame(-1, 1.0f));
        }
        TypedValue typedValue = new TypedValue();
        ApplicationLoader.applicationActivity.getTheme().resolveAttribute(android.R.attr.selectableItemBackground, typedValue, true);
        Iterator<Rubino.AlertItem> it = arrayList.iterator();
        while (it.hasNext()) {
            final Rubino.AlertItem next = it.next();
            TextView textView2 = new TextView(launchActivity);
            textView2.setTextColor(Theme.getColor(Theme.key_rubinoBlackColor));
            textView2.setTypeface(Theme.getRubinoTypeFaceRegular());
            textView2.setGravity(5);
            textView2.setTextSize(2, 16.0f);
            textView2.setPadding(AndroidUtilities.dp(16.0f), AndroidUtilities.dp(14.0f), AndroidUtilities.dp(16.0f), AndroidUtilities.dp(14.0f));
            textView2.setText(next.getText());
            textView2.setBackgroundResource(typedValue.resourceId);
            textView2.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.57
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (next.getOnClickListener() != null) {
                        next.getOnClickListener().onClick(view);
                    }
                    Dialog dialog = next.parentDialog;
                    if (dialog != null) {
                        dialog.dismiss();
                    }
                    JustLinearLayoutDialog justLinearLayoutDialog2 = justLinearLayoutDialog;
                    if (justLinearLayoutDialog2 != null) {
                        justLinearLayoutDialog2.dismiss();
                    }
                }
            });
            uILinearLayout.linearLayout.addView(textView2);
        }
        justLinearLayoutDialog.show();
    }

    public void getMyProfileList() {
        Rubino.GetListInput getListInput = new Rubino.GetListInput(null);
        getListInput.limit = 10;
        this.compositeDisposable.add((Disposable) getApiRequestMessangerRx().getMyProfileList(getListInput).subscribeWith(new DisposableObserver<MessangerOutput<Rubino.GetProfileListOutput>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.58
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput<Rubino.GetProfileListOutput> messangerOutput) {
                Rubino.GetProfileListOutput getProfileListOutput;
                if (messangerOutput == null || (getProfileListOutput = messangerOutput.data) == null || getProfileListOutput.profiles == null) {
                    return;
                }
                AppRubinoPreferences.getInstance(((BaseController) RubinoController.this).currentAccount).setRubinoProfilesOutput(messangerOutput.data);
            }
        }));
    }

    public RubinoChangeProfileDialog getChangeProfileAlert(Context context) {
        ArrayList<RubinoProfileObject> arrayList;
        ArrayList arrayList2 = new ArrayList();
        Rubino.GetProfileListOutput profilesOutput2 = AppRubinoPreferences.getInstance(this.currentAccount).getProfilesOutput2();
        if (profilesOutput2 != null && (arrayList = profilesOutput2.profiles) != null) {
            arrayList2.addAll(arrayList);
        }
        return RubinoChangeProfileDialog.createRubinoDialogItems((Activity) context, arrayList2);
    }

    public void onMyDefaultRubinoUsernameUpdated(String str) {
        String str2;
        RubinoProfileObject rubinoDefaultProfileObject = AppRubinoPreferences.getInstance(this.currentAccount).getRubinoDefaultProfileObject();
        if (rubinoDefaultProfileObject == null || (str2 = rubinoDefaultProfileObject.id) == null || str2.isEmpty() || Objects.equals(rubinoDefaultProfileObject.username, str)) {
            return;
        }
        rubinoDefaultProfileObject.username = str;
        HashSet hashSet = new HashSet();
        hashSet.add(RubinoProfileObject.UpdatedParameterEnum.username);
        onMyRubinoProfileUpdated(rubinoDefaultProfileObject, hashSet);
    }

    public void onMyRubinoProfileUpdated(RubinoProfileObject rubinoProfileObject, Set<RubinoProfileObject.UpdatedParameterEnum> set) {
        if (rubinoProfileObject != null) {
            RubinoProfileObject rubinoProfileObject2 = this.profileMap.get(rubinoProfileObject.id);
            if (rubinoProfileObject2 != null) {
                if (set == null) {
                    rubinoProfileObject.isMyProfile = true;
                    addToProfileMap(rubinoProfileObject);
                } else {
                    rubinoProfileObject2.lastUpdateTime = System.currentTimeMillis();
                    if (set.contains(RubinoProfileObject.UpdatedParameterEnum.username)) {
                        rubinoProfileObject2.username = rubinoProfileObject.username.toLowerCase();
                        rubinoProfileObject2.createUsernameSpan();
                    }
                    if (set.contains(RubinoProfileObject.UpdatedParameterEnum.name)) {
                        rubinoProfileObject2.name = rubinoProfileObject.name;
                    }
                    if (set.contains(RubinoProfileObject.UpdatedParameterEnum.bio)) {
                        rubinoProfileObject2.bio = rubinoProfileObject.bio;
                        rubinoProfileObject2.createBioSpan();
                        rubinoProfileObject2.createShortBioSpan();
                    }
                    if (set.contains(RubinoProfileObject.UpdatedParameterEnum.email)) {
                        rubinoProfileObject2.email = rubinoProfileObject.email;
                        rubinoProfileObject2.updateContactInfo();
                    }
                    if (set.contains(RubinoProfileObject.UpdatedParameterEnum.phone)) {
                        rubinoProfileObject2.phone = rubinoProfileObject.phone;
                        rubinoProfileObject2.updateContactInfo();
                    }
                    if (set.contains(RubinoProfileObject.UpdatedParameterEnum.website)) {
                        rubinoProfileObject2.website = rubinoProfileObject.website;
                        rubinoProfileObject2.updateContactInfo();
                    }
                    if (set.contains(RubinoProfileObject.UpdatedParameterEnum.avatar)) {
                        rubinoProfileObject2.full_thumbnail_url = rubinoProfileObject.full_thumbnail_url;
                        rubinoProfileObject2.full_photo_url = rubinoProfileObject.full_photo_url;
                    }
                    if (set.contains(RubinoProfileObject.UpdatedParameterEnum.is_message_allowed)) {
                        rubinoProfileObject2.is_message_allowed = rubinoProfileObject.is_message_allowed;
                    }
                    if (set.contains(RubinoProfileObject.UpdatedParameterEnum.is_mute)) {
                        rubinoProfileObject2.is_mute = rubinoProfileObject.is_mute;
                    }
                    if (set.contains(RubinoProfileObject.UpdatedParameterEnum.status)) {
                        rubinoProfileObject2.profile_status = rubinoProfileObject.profile_status;
                    }
                    if (set.contains(RubinoProfileObject.UpdatedParameterEnum.tag_post)) {
                        rubinoProfileObject2.tag_post = rubinoProfileObject.tag_post;
                    }
                }
            }
            if (rubinoProfileObject.id.equals(AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id)) {
                AppRubinoPreferences.getInstance(this.currentAccount).setRubinoCurrentProfileObject(rubinoProfileObject);
            }
            Rubino.GetProfileListOutput profilesOutput2 = AppRubinoPreferences.getInstance(this.currentAccount).getProfilesOutput2();
            int i = 0;
            while (true) {
                if (i >= profilesOutput2.profiles.size()) {
                    break;
                }
                if (profilesOutput2.profiles.get(i).id.equals(rubinoProfileObject.id)) {
                    profilesOutput2.profiles.set(i, rubinoProfileObject);
                    AppRubinoPreferences.getInstance(this.currentAccount).setRubinoProfilesOutput(profilesOutput2);
                    break;
                }
                i++;
            }
            getNotificationCenter().postNotificationNameOnUIThread(NotificationCenter.rubinoProfileUpdated, rubinoProfileObject.id);
        }
    }

    public Rubino.ExploreTopicsObject getExploreTopics() {
        Rubino.ExploreTopicsObject exploreTopics = AppRubinoPreferences.getInstance(this.currentAccount).getExploreTopics();
        if (exploreTopics != null) {
            return exploreTopics;
        }
        callGetExploreTopics();
        Rubino.ExploreTopicsObject exploreTopicsObject = new Rubino.ExploreTopicsObject();
        exploreTopicsObject.topics = new ArrayList<>();
        return exploreTopicsObject;
    }

    public Observable<Rubino.ExploreTopicsObject> getExploreTopicsObservable() {
        Rubino.ExploreTopicsObject exploreTopics = AppRubinoPreferences.getInstance(this.currentAccount).getExploreTopics();
        if (exploreTopics != null && System.currentTimeMillis() - exploreTopics.lastUpdatedTime < 3600000) {
            return Observable.just(exploreTopics);
        }
        return getApiRequestMessangerRx().getExplorePostTopics(new Rubino.BaseInput(AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id)).observeOn(Schedulers.computation()).doOnNext(new Consumer<MessangerOutput<Rubino.GetExploreTopicsOutput>>(this) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.60
            @Override // io.reactivex.functions.Consumer
            public void accept(MessangerOutput<Rubino.GetExploreTopicsOutput> messangerOutput) throws Exception {
            }
        }).flatMap(new Function<MessangerOutput<Rubino.GetExploreTopicsOutput>, ObservableSource<Rubino.ExploreTopicsObject>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.59
            @Override // io.reactivex.functions.Function
            public ObservableSource<Rubino.ExploreTopicsObject> apply(MessangerOutput<Rubino.GetExploreTopicsOutput> messangerOutput) throws Exception {
                Rubino.GetExploreTopicsOutput getExploreTopicsOutput;
                if (messangerOutput != null && (getExploreTopicsOutput = messangerOutput.data) != null && getExploreTopicsOutput.topics != null) {
                    Rubino.ExploreTopicsObject exploreTopicsObject = new Rubino.ExploreTopicsObject();
                    exploreTopicsObject.topics = new ArrayList<>();
                    Iterator<Rubino.ExploreTopicObject> it = messangerOutput.data.topics.iterator();
                    while (it.hasNext()) {
                        Rubino.ExploreTopicObject next = it.next();
                        if (!next.is_main) {
                            exploreTopicsObject.topics.add(next);
                        }
                    }
                    AppRubinoPreferences.getInstance(((BaseController) RubinoController.this).currentAccount).setExploreTopics(exploreTopicsObject);
                }
                return Observable.just(AppRubinoPreferences.getInstance(((BaseController) RubinoController.this).currentAccount).getExploreTopics());
            }
        }).observeOn(AndroidSchedulers.mainThread());
    }

    private void callGetExploreTopics() {
        this.compositeDisposable.add((Disposable) getApiRequestMessangerRx().getExplorePostTopics(new Rubino.BaseInput(AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id)).observeOn(Schedulers.computation()).doOnNext(new Consumer<MessangerOutput<Rubino.GetExploreTopicsOutput>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.62
            @Override // io.reactivex.functions.Consumer
            public void accept(MessangerOutput<Rubino.GetExploreTopicsOutput> messangerOutput) throws Exception {
                Rubino.GetExploreTopicsOutput getExploreTopicsOutput;
                if (messangerOutput == null || (getExploreTopicsOutput = messangerOutput.data) == null || getExploreTopicsOutput.topics == null) {
                    return;
                }
                Rubino.ExploreTopicsObject exploreTopicsObject = new Rubino.ExploreTopicsObject();
                exploreTopicsObject.topics = new ArrayList<>();
                Iterator<Rubino.ExploreTopicObject> it = messangerOutput.data.topics.iterator();
                while (it.hasNext()) {
                    Rubino.ExploreTopicObject next = it.next();
                    if (!next.is_main) {
                        exploreTopicsObject.topics.add(next);
                    }
                }
                AppRubinoPreferences.getInstance(((BaseController) RubinoController.this).currentAccount).setExploreTopics(exploreTopicsObject);
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<MessangerOutput<Rubino.GetExploreTopicsOutput>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.61
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput<Rubino.GetExploreTopicsOutput> messangerOutput) {
                Rubino.GetExploreTopicsOutput getExploreTopicsOutput;
                if (messangerOutput == null || (getExploreTopicsOutput = messangerOutput.data) == null || getExploreTopicsOutput.topics == null) {
                    return;
                }
                RubinoController.this.getNotificationCenter().postNotificationName(NotificationCenter.rubinoExploreTopicsUpdated, new Object[0]);
            }
        }));
    }

    public void updatePostOnAddComment(String str, RubinoCommentObject rubinoCommentObject, Integer num) {
        RubinoPostObject fromPostMapIfExist = getFromPostMapIfExist(str);
        if (fromPostMapIfExist != null) {
            Rubino.PostObjectFromServer postObjectFromServer = fromPostMapIfExist.post;
            postObjectFromServer.comment_count = NumberUtils.incrementIfPossibe(postObjectFromServer.comment_count);
            fromPostMapIfExist.createCommentCountSpan();
            if (num != null) {
                Iterator<RubinoCommentObject> it = fromPostMapIfExist.myComments.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    RubinoCommentObject next = it.next();
                    if (next.isLocal && next.rnd == num.intValue()) {
                        fromPostMapIfExist.myComments.remove(next);
                        break;
                    }
                }
            }
            if (rubinoCommentObject != null) {
                fromPostMapIfExist.myComments.add(rubinoCommentObject);
            }
            getNotificationCenter().postNotificationName(NotificationCenter.rubinoCommentCountChange, str, Long.valueOf(fromPostMapIfExist.post.comment_count));
        }
    }

    public void updatePostOnDeleteComment(String str, RubinoCommentObject rubinoCommentObject) {
        RubinoPostObject fromPostMapIfExist = getFromPostMapIfExist(str);
        if (fromPostMapIfExist != null) {
            Rubino.PostObjectFromServer postObjectFromServer = fromPostMapIfExist.post;
            postObjectFromServer.comment_count = NumberUtils.decrementIfPossibe(postObjectFromServer.comment_count);
            fromPostMapIfExist.createCommentCountSpan();
            if (rubinoCommentObject != null) {
                Iterator<RubinoCommentObject> it = fromPostMapIfExist.myComments.iterator();
                while (it.hasNext()) {
                    RubinoCommentObject next = it.next();
                    boolean z = rubinoCommentObject.isLocal;
                    if ((z && next.isLocal && rubinoCommentObject.rnd == next.rnd) || (!z && !next.isLocal && next.comment.id.equals(rubinoCommentObject.comment.id))) {
                        fromPostMapIfExist.myComments.remove(next);
                        break;
                    }
                }
            }
            getNotificationCenter().postNotificationName(NotificationCenter.rubinoCommentCountChange, str, Long.valueOf(fromPostMapIfExist.post.comment_count));
        }
    }

    public void syncMyProfileListWithServer() {
        Rubino.GetListInput getListInput = new Rubino.GetListInput(null);
        getListInput.limit = 10;
        this.compositeDisposable.add((Disposable) getApiRequestMessangerRx().getMyProfileList(getListInput).observeOn(Schedulers.computation()).doOnNext(new Consumer<MessangerOutput<Rubino.GetProfileListOutput>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.64
            @Override // io.reactivex.functions.Consumer
            public void accept(MessangerOutput<Rubino.GetProfileListOutput> messangerOutput) throws Exception {
                Rubino.GetProfileListOutput getProfileListOutput;
                if (messangerOutput == null || (getProfileListOutput = messangerOutput.data) == null || getProfileListOutput.profiles == null) {
                    return;
                }
                AppRubinoPreferences.getInstance(((BaseController) RubinoController.this).currentAccount).setRubinoProfilesOutput(messangerOutput.data);
                RubinoController.this.getNotificationCenter().postNotificationNameOnUIThread(NotificationCenter.rubinoMyProfileListUpdated, new Object[0]);
            }
        }).subscribeWith(new DisposableObserver<MessangerOutput<Rubino.GetProfileListOutput>>(this) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.63
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput<Rubino.GetProfileListOutput> messangerOutput) {
            }
        }));
    }

    public Observable<Integer> getCheckProfileObservable(final boolean z, final boolean z2) {
        return Observable.just(1).flatMap(new Function<Integer, ObservableSource<Integer>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.66
            @Override // io.reactivex.functions.Function
            public ObservableSource<Integer> apply(Integer num) throws Exception {
                if (z2 || AppRubinoPreferences.getInstance(((BaseController) RubinoController.this).currentAccount).getProfilesOutput2() == null || AppRubinoPreferences.getInstance(((BaseController) RubinoController.this).currentAccount).getProfilesOutput2().profiles == null || AppRubinoPreferences.getInstance(((BaseController) RubinoController.this).currentAccount).getProfilesOutput2().profiles.size() <= 0) {
                    Rubino.GetListInput getListInput = new Rubino.GetListInput(null);
                    getListInput.limit = 10;
                    return RubinoController.this.getApiRequestMessangerRx().getMyProfileList(getListInput).observeOn(Schedulers.computation()).doOnNext(new Consumer<MessangerOutput<Rubino.GetProfileListOutput>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.66.2
                        @Override // io.reactivex.functions.Consumer
                        public void accept(MessangerOutput<Rubino.GetProfileListOutput> messangerOutput) throws Exception {
                            Rubino.GetProfileListOutput getProfileListOutput;
                            if (messangerOutput == null || (getProfileListOutput = messangerOutput.data) == null || getProfileListOutput.profiles == null) {
                                return;
                            }
                            AppRubinoPreferences.getInstance(((BaseController) RubinoController.this).currentAccount).setRubinoProfilesOutput(messangerOutput.data);
                            RubinoController.this.getNotificationCenter().postNotificationNameOnUIThread(NotificationCenter.rubinoMyProfileListUpdated, new Object[0]);
                        }
                    }).flatMap(new Function<MessangerOutput<Rubino.GetProfileListOutput>, ObservableSource<Integer>>(this) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.66.1
                        @Override // io.reactivex.functions.Function
                        public ObservableSource<Integer> apply(MessangerOutput<Rubino.GetProfileListOutput> messangerOutput) throws Exception {
                            return Observable.just(1);
                        }
                    });
                }
                return Observable.just(1);
            }
        }).flatMap(new Function<Integer, ObservableSource<Integer>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.65
            @Override // io.reactivex.functions.Function
            public ObservableSource<Integer> apply(Integer num) throws Exception {
                String str = AppRubinoPreferences.getInstance(((BaseController) RubinoController.this).currentAccount).getRubinoCurrentProfileObject().id;
                if (str != null && !str.isEmpty()) {
                    RubinoProfileObject rubinoProfileObject = RubinoController.this.profileMap.get(str);
                    if (z || rubinoProfileObject == null || System.currentTimeMillis() - rubinoProfileObject.lastUpdateTime > 5000) {
                        return RubinoController.this.getApiRequestMessangerRx().getMyProfileInfo(new Rubino.GetProfileInfoInput(str)).observeOn(Schedulers.computation()).doOnNext(new Consumer<MessangerOutput<Rubino.GetProfileInfoOutput>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.65.3
                            @Override // io.reactivex.functions.Consumer
                            public void accept(MessangerOutput<Rubino.GetProfileInfoOutput> messangerOutput) throws Exception {
                                RubinoProfileObject rubinoProfileObjectMakeProfileFromProfileInfo = RubinoController.this.makeProfileFromProfileInfo(messangerOutput.data);
                                RubinoController.this.addToProfileMap(rubinoProfileObjectMakeProfileFromProfileInfo);
                                AppRubinoPreferences.getInstance(((BaseController) RubinoController.this).currentAccount).setRubinoCurrentProfileObject(rubinoProfileObjectMakeProfileFromProfileInfo);
                                RubinoController.this.getNotificationCenter().postNotificationNameOnUIThread(NotificationCenter.rubinoProfileDidLoad, rubinoProfileObjectMakeProfileFromProfileInfo.id);
                            }
                        }).doOnError(new Consumer<Throwable>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.65.2
                            @Override // io.reactivex.functions.Consumer
                            public void accept(Throwable th) throws Exception {
                                if ((th instanceof ApiServerException) && ((ApiServerException) th).status_det == MessangerOutput.EnumStatusDet.INVALID_INPUT && AppRubinoPreferences.getInstance(((BaseController) RubinoController.this).currentAccount).getRubinoDefaultProfileObject() != null) {
                                    new MainClickHandler().changeRubinoProfile(AppRubinoPreferences.getInstance(((BaseController) RubinoController.this).currentAccount).getRubinoDefaultProfileObject());
                                }
                            }
                        }).flatMap(new Function<MessangerOutput<Rubino.GetProfileInfoOutput>, ObservableSource<Integer>>(this) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.65.1
                            @Override // io.reactivex.functions.Function
                            public ObservableSource<Integer> apply(MessangerOutput<Rubino.GetProfileInfoOutput> messangerOutput) throws Exception {
                                return Observable.just(1);
                            }
                        });
                    }
                    return Observable.just(1);
                }
                throw new Exception();
            }
        });
    }

    public boolean isRequestAnswered(String str) {
        return this.actionOnRequestMap.containsKey(str);
    }

    public void onAcceptRequestClick(String str) {
        actionOnRequest(str, Rubino.ActionOnRequestTypeEnum.Accept);
    }

    public void onDeleteRequestClick(String str) {
        actionOnRequest(str, Rubino.ActionOnRequestTypeEnum.Decline);
    }

    private void actionOnRequest(String str, Rubino.ActionOnRequestTypeEnum actionOnRequestTypeEnum) {
        if (this.actionOnRequestMap.size() > 1000) {
            this.actionOnRequestMap.clear();
        }
        this.actionOnRequestMap.put(str, actionOnRequestTypeEnum);
        getNotificationCenter().postNotificationName(NotificationCenter.rubinoRequestAnswered, str);
        Rubino.ActionOnRequestInput actionOnRequestInput = new Rubino.ActionOnRequestInput(AppRubinoPreferences.getInstance(this.currentAccount).getInstaCurrentProfileObject().id);
        actionOnRequestInput.request_id = str;
        actionOnRequestInput.action = actionOnRequestTypeEnum;
        this.compositeDisposable.add((Disposable) getApiRequestMessangerRx().actionOnRequest(actionOnRequestInput).subscribeWith(new DisposableObserver<MessangerOutput>(this) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.67
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

    public void unFollowClickWithDialogIfNeeded(final RubinoProfileObject rubinoProfileObject, final Dialog dialog) {
        if (rubinoProfileObject == null) {
            return;
        }
        String string = LocaleController.getString(getRubinoController().isProfileFollowRequested(rubinoProfileObject) ? R.string.rubinoCancelRequest : R.string.rubinoUnfollow);
        if (rubinoProfileObject.isPrivate()) {
            if (ApplicationLoader.applicationActivity != null) {
                SpannableString spannableString = new SpannableString(BuildConfig.FLAVOR);
                if (getRubinoController().isProfileFollowRequested(rubinoProfileObject)) {
                    spannableString = new SpannableString(LocaleController.getString(R.string.rubinoCancelFollowRequestAlert));
                } else if (getRubinoController().isProfileFollowed(rubinoProfileObject)) {
                    String str = "@" + rubinoProfileObject.getUsername();
                    String string2 = LocaleController.formatString(R.string.rubinoUnfollowAlert, str);
                    int iIndexOf = string2.indexOf(str);
                    spannableString = SpanHelper.makeBoldLinkSpanWithColor(new SpannableString(string2), null, iIndexOf, str.length() + iIndexOf, Theme.getColor(Theme.key_rubinoGrayColor));
                }
                showRubinoCenterDialog(true, true, rubinoProfileObject, spannableString, string, new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.68
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        RubinoController.this.getRubinoController().doFollowUnfollowAction(rubinoProfileObject, Rubino.FollowActionTypeEnum.Unfollow);
                        Dialog dialog2 = dialog;
                        if (dialog2 != null) {
                            dialog2.dismiss();
                        }
                    }
                });
                return;
            }
            return;
        }
        getRubinoController().doFollowUnfollowAction(rubinoProfileObject, Rubino.FollowActionTypeEnum.Unfollow);
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public ImageSpan getImageSpanVerifyOrSale(boolean z, boolean z2, int i, int i2) {
        Drawable drawableMutate;
        if (z) {
            drawableMutate = ApplicationLoader.applicationActivity.getResources().getDrawable(R.drawable.rubino_verified_profile).mutate();
            drawableMutate.setColorFilter(new PorterDuffColorFilter(ApplicationLoader.applicationActivity.getResources().getColor(R.color.blue_500), PorterDuff.Mode.SRC_ATOP));
        } else {
            drawableMutate = z2 ? ApplicationLoader.applicationActivity.getResources().getDrawable(R.drawable.ic_sale_permission).mutate() : null;
        }
        if (drawableMutate == null) {
            return null;
        }
        int iSpToPx = AndroidUtilities.spToPx(i, ApplicationLoader.applicationActivity);
        drawableMutate.setBounds(0, 0, iSpToPx, iSpToPx);
        return new ImageSpan(drawableMutate, i2);
    }

    public Observable<Rubino.GetProfileHighlightsOutput> getMyHighlightsObservable() {
        return getProfileHighlightsObservable(getMyCurrentProfileID());
    }

    public String getMyCurrentProfileID() {
        return AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id;
    }

    public Observable<Rubino.GetProfileHighlightsOutput> getProfileHighlightsObservable(final String str) {
        Rubino.GetListInput getListInput = new Rubino.GetListInput(getMyCurrentProfileID());
        getListInput.target_profile_id = str;
        return getApiRequestMessangerRx().getProfileHighlights(getListInput).flatMap(new Function<MessangerOutput<Rubino.GetProfileHighlightsOutput>, Observable<Rubino.GetProfileHighlightsOutput>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.69
            @Override // io.reactivex.functions.Function
            public Observable<Rubino.GetProfileHighlightsOutput> apply(MessangerOutput<Rubino.GetProfileHighlightsOutput> messangerOutput) throws Exception {
                StoryController.getInstance(((BaseController) RubinoController.this).currentAccount).onProfileHighlightChanged(str);
                return Observable.just(messangerOutput.data);
            }
        });
    }

    public Observable<Integer> highlightStoryObservable(Rubino.StoryHighlight storyHighlight, String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        return highlightStoryObservable(storyHighlight, arrayList);
    }

    public Observable<Integer> highlightStoryObservable(Rubino.StoryHighlight storyHighlight, ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() == 0 || storyHighlight == null) {
            return Observable.just(0);
        }
        String str = storyHighlight.highlight_id;
        if (str == null || str.isEmpty()) {
            final String myCurrentProfileID = getMyCurrentProfileID();
            Rubino.AddHighlightInput addHighlightInput = new Rubino.AddHighlightInput(myCurrentProfileID);
            addHighlightInput.story_ids = arrayList;
            addHighlightInput.highlight_name = storyHighlight.name;
            return getApiRequestMessangerRx().addHighlight(addHighlightInput).observeOn(AndroidSchedulers.mainThread()).flatMap(new Function<MessangerOutput<Rubino.AddHighlightOutput>, Observable<Integer>>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.70
                @Override // io.reactivex.functions.Function
                public Observable<Integer> apply(MessangerOutput<Rubino.AddHighlightOutput> messangerOutput) throws Exception {
                    NotificationCenter.getInstance(((BaseController) RubinoController.this).currentAccount).postNotificationName(NotificationCenter.highlightAdded, myCurrentProfileID);
                    return Observable.just(1);
                }
            });
        }
        Rubino.HighlightStoryInput highlightStoryInput = new Rubino.HighlightStoryInput(getMyCurrentProfileID());
        highlightStoryInput.highlight_id = storyHighlight.highlight_id;
        highlightStoryInput.story_id = arrayList.get(0);
        return getApiRequestMessangerRx().highlightStory(highlightStoryInput).flatMap(new Function<MessangerOutput, Observable<Integer>>(this) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.71
            @Override // io.reactivex.functions.Function
            public Observable<Integer> apply(MessangerOutput messangerOutput) throws Exception {
                return Observable.just(1);
            }
        });
    }

    public Observable<Rubino.AddHighlightOutput> addHighlight(ArrayList<String> arrayList, String str, Rubino.InputHighlightCover inputHighlightCover) {
        final String myCurrentProfileID = getMyCurrentProfileID();
        Rubino.AddHighlightInput addHighlightInput = new Rubino.AddHighlightInput(myCurrentProfileID);
        addHighlightInput.story_ids = arrayList;
        addHighlightInput.highlight_name = str;
        addHighlightInput.highlight_cover = inputHighlightCover;
        return getApiRequestMessangerRx().addHighlight(addHighlightInput).flatMap(new Function() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return RubinoController.lambda$addHighlight$1((MessangerOutput) obj);
            }
        }).observeOn(AndroidSchedulers.mainThread()).doOnNext(new Consumer<Rubino.AddHighlightOutput>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.72
            @Override // io.reactivex.functions.Consumer
            public void accept(Rubino.AddHighlightOutput addHighlightOutput) throws Exception {
                NotificationCenter.getInstance(((BaseController) RubinoController.this).currentAccount).postNotificationName(NotificationCenter.highlightAdded, myCurrentProfileID);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Observable lambda$addHighlight$1(MessangerOutput messangerOutput) throws Exception {
        return Observable.just((Rubino.AddHighlightOutput) messangerOutput.data);
    }

    public void deleteStoryFromHighlight(final String str, final StoryObject storyObject) {
        if (storyObject == null || str == null || str.isEmpty()) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(storyObject.id);
        this.compositeDisposable.add((Disposable) editHighlight(str, null, arrayList, null, null).subscribeWith(new DisposableObserver<Integer>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.73
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onNext(Integer num) {
                StoryController.getInstance(((BaseController) RubinoController.this).currentAccount).onHighlightChanged(str);
                RubinoController.this.getNotificationCenter().postNotificationNameOnUIThread(NotificationCenter.myStoryDeleted, storyObject);
            }
        }));
    }

    public Observable<Integer> editHighlight(String str, ArrayList<String> arrayList, ArrayList<String> arrayList2, String str2, Rubino.InputHighlightCover inputHighlightCover) {
        final String myCurrentProfileID = getMyCurrentProfileID();
        Rubino.EditHighlightInput editHighlightInput = new Rubino.EditHighlightInput(myCurrentProfileID);
        ArrayList<String> arrayList3 = new ArrayList<>();
        editHighlightInput.highlight_id = str;
        if (arrayList != null && !arrayList.isEmpty()) {
            editHighlightInput.add_story_ids = arrayList;
            arrayList3.add("add_story_ids");
        }
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            editHighlightInput.remove_story_ids = arrayList2;
            arrayList3.add("remove_story_ids");
        }
        if (!TextUtils.isEmpty(str2)) {
            editHighlightInput.highlight_name = str2;
            arrayList3.add("highlight_name");
        }
        if (inputHighlightCover != null) {
            editHighlightInput.highlight_cover = inputHighlightCover;
            arrayList3.add("highlight_cover");
        }
        editHighlightInput.updated_parameters = arrayList3;
        if (arrayList3.isEmpty()) {
            return Observable.just(1);
        }
        return getApiRequestMessangerRx().editHighlight(editHighlightInput).flatMap(new Function() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return RubinoController.lambda$editHighlight$2((MessangerOutput) obj);
            }
        }).observeOn(AndroidSchedulers.mainThread()).doOnNext(new Consumer<Integer>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController.74
            @Override // io.reactivex.functions.Consumer
            public void accept(Integer num) throws Exception {
                NotificationCenter.getInstance(((BaseController) RubinoController.this).currentAccount).postNotificationName(NotificationCenter.highlightEdited, myCurrentProfileID);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Observable lambda$editHighlight$2(MessangerOutput messangerOutput) throws Exception {
        return Observable.just(1);
    }

    public Observable<Rubino.GetMyArchiveStoriesOutput> getMyArchiveStories(String str, int i) {
        Rubino.GetListInput getListInput = new Rubino.GetListInput(getMyCurrentProfileID());
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        getListInput.start_id = str;
        getListInput.limit = i;
        return getApiRequestMessangerRx().getMyArchiveStories(getListInput).flatMap(new Function() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return RubinoController.lambda$getMyArchiveStories$3((MessangerOutput) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Observable lambda$getMyArchiveStories$3(MessangerOutput messangerOutput) throws Exception {
        return Observable.just((Rubino.GetMyArchiveStoriesOutput) messangerOutput.data);
    }

    public Observable<GetStoryIdsOutput> getHighlightStoryIds(String str, String str2) {
        return getApiRequestMessangerRx().getHighlightStoryIds(new Rubino.GetHighlightStoryIdsInput(str, getMyCurrentProfileID(), str2)).flatMap(new Function() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return RubinoController.lambda$getHighlightStoryIds$4((MessangerOutput) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Observable lambda$getHighlightStoryIds$4(MessangerOutput messangerOutput) throws Exception {
        return Observable.just((GetStoryIdsOutput) messangerOutput.data);
    }

    public Observable<GetStoryOutput> getHighlightStory(ArrayList<String> arrayList, String str, String str2) {
        Rubino.GetHighlightStoriesInput getHighlightStoriesInput = new Rubino.GetHighlightStoriesInput(getMyCurrentProfileID());
        getHighlightStoriesInput.target_profile_id = str;
        getHighlightStoriesInput.story_ids = arrayList;
        getHighlightStoriesInput.highlight_id = str2;
        return getApiRequestMessangerRx().getHighlightStories(getHighlightStoriesInput, false).flatMap(new Function() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoController$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return RubinoController.lambda$getHighlightStory$5((MessangerOutput) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Observable lambda$getHighlightStory$5(MessangerOutput messangerOutput) throws Exception {
        return Observable.just((GetStoryOutput) messangerOutput.data);
    }
}
