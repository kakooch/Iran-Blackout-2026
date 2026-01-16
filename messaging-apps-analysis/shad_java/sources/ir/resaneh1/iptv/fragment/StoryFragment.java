package ir.resaneh1.iptv.fragment;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.request.target.Target;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import ir.appp.rghapp.rubinoPostSlider.FileLoaderRubinoPost;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.helper.CubeLayoutManager;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.helper.StoryController;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.RubinoProfileObject;
import ir.resaneh1.iptv.model.StoryListOfAProfileObject;
import ir.resaneh1.iptv.model.StoryObject;
import ir.resaneh1.iptv.presenter.MainPresenterSelector;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import ir.resaneh1.iptv.presenter.abstracts.OnLoadMoreListener;
import ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import ir.resaneh1.iptv.presenter.abstracts.PresenterSelector;
import ir.resaneh1.iptv.presenter.adapter.MainAdapter;
import ir.resaneh1.iptv.presenters.StoryPresenter;
import ir.resaneh1.iptv.story.StorySnapHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.ui.ActionBar.ActionBarAnimationType;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class StoryFragment extends PresenterFragment implements NotificationCenter.NotificationCenterDelegate {
    private static int highlightType = 1;
    private static int storyType;
    private CubeLayoutManager cubeLayoutManager;
    public int currentSnapPosition;
    private StoryController.StoryIdObject defaultStory;
    private StoryPresenter localStoryPresenter;
    private DisposableObserver preLoadObserver;
    private StoryPresenter.ScrollListener scrollListener;
    private StorySnapHelper snapHelper;
    private int startIndex;
    private final ArrayList<StoryListOfAProfileObject> storyOfProfileList;
    private StoryPresenter storyPresenter;
    private int type;
    private final Object syncStoryImageTargetMapObject = new Object();
    private final Map<String, Target<Drawable>> storyImageTargetViewMap = new HashMap();
    int preLoadProfileCount = 2;
    int preLoadStoryPerProfileCount = 2;
    int preLoadCurrentStoryCount = 2;

    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.story_fragment;
    }

    public StoryFragment(ArrayList<StoryListOfAProfileObject> arrayList, int i) {
        this.startIndex = 0;
        this.type = 0;
        this.storyOfProfileList = arrayList;
        this.startIndex = i;
        this.type = storyType;
        initFragmentParams();
    }

    public StoryFragment(ArrayList<StoryListOfAProfileObject> arrayList, int i, boolean z) {
        this.startIndex = 0;
        this.type = 0;
        this.storyOfProfileList = arrayList;
        this.startIndex = i;
        if (z) {
            this.type = highlightType;
        } else {
            this.type = storyType;
        }
        initFragmentParams();
    }

    public StoryFragment(ArrayList<StoryListOfAProfileObject> arrayList, int i, StoryController.StoryIdObject storyIdObject) {
        this.startIndex = 0;
        this.type = 0;
        this.storyOfProfileList = arrayList;
        this.startIndex = i;
        this.defaultStory = storyIdObject;
        this.type = storyType;
        initFragmentParams();
    }

    public void initFragmentParams() {
        this.fragmentName = "StoryFragment";
        this.isForceBlackTheme = true;
        if (DimensionHelper.isShowstoryNeedFullScreen()) {
            this.isFullScreen = true;
        }
    }

    public void setScrollListener(StoryPresenter.ScrollListener scrollListener) {
        this.scrollListener = scrollListener;
        StoryPresenter storyPresenter = this.storyPresenter;
        if (storyPresenter != null) {
            storyPresenter.setScrollListener(scrollListener);
        }
        StoryPresenter storyPresenter2 = this.localStoryPresenter;
        if (storyPresenter2 != null) {
            storyPresenter2.setScrollListener(scrollListener);
        }
    }

    public void setSeenListener(StoryPresenter.SeenClickListener seenClickListener) {
        StoryPresenter storyPresenter = this.storyPresenter;
        if (storyPresenter != null) {
            storyPresenter.setSeenClickListener(seenClickListener);
        }
        StoryPresenter storyPresenter2 = this.localStoryPresenter;
        if (storyPresenter2 != null) {
            storyPresenter2.setSeenClickListener(seenClickListener);
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        getNotificationCenter().addObserver(this, NotificationCenter.storyListEmptyDetected);
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.emojiDidLoad);
        getNotificationCenter().addObserver(this, NotificationCenter.storySendProgressChange);
        getNotificationCenter().addObserver(this, NotificationCenter.storySendProgressCompleted);
        getNotificationCenter().addObserver(this, NotificationCenter.storySendProgressCanceled);
        getNotificationCenter().addObserver(this, NotificationCenter.storySendFailedOrRetry);
        getNotificationCenter().addObserver(this, NotificationCenter.profileStoryIdsDidLoad);
        getNotificationCenter().addObserver(this, NotificationCenter.storyObjectDidLoad);
        getNotificationCenter().addObserver(this, NotificationCenter.myStoryDeleted);
        getNotificationCenter().addObserver(this, NotificationCenter.myStoryAdded);
        getNotificationCenter().addObserver(this, NotificationCenter.storySeenCountChange);
        if (this.type == highlightType) {
            getNotificationCenter().addObserver(this, NotificationCenter.highlightStoryIdsDidLoad);
        }
        return super.onFragmentCreate();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        getNotificationCenter().removeObserver(this, NotificationCenter.storyListEmptyDetected);
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.emojiDidLoad);
        getNotificationCenter().removeObserver(this, NotificationCenter.storySendProgressCompleted);
        getNotificationCenter().removeObserver(this, NotificationCenter.storySendProgressCanceled);
        getNotificationCenter().removeObserver(this, NotificationCenter.storySendProgressChange);
        getNotificationCenter().removeObserver(this, NotificationCenter.storySendFailedOrRetry);
        getNotificationCenter().removeObserver(this, NotificationCenter.profileStoryIdsDidLoad);
        getNotificationCenter().removeObserver(this, NotificationCenter.storyObjectDidLoad);
        getNotificationCenter().removeObserver(this, NotificationCenter.myStoryDeleted);
        getNotificationCenter().removeObserver(this, NotificationCenter.myStoryAdded);
        getNotificationCenter().removeObserver(this, NotificationCenter.storySeenCountChange);
        if (this.type == highlightType) {
            getNotificationCenter().removeObserver(this, NotificationCenter.highlightStoryIdsDidLoad);
        }
        DisposableObserver disposableObserver = this.preLoadObserver;
        if (disposableObserver != null) {
            disposableObserver.dispose();
        }
        cancelLastDownloadIfNeeded(this.currentSnapPosition, this.preLoadProfileCount);
        clearAllStoryPreloadPicture();
        super.onFragmentDestroy();
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        if (i == NotificationCenter.emojiDidLoad) {
            this.mainRecyclerView.invalidate();
            return;
        }
        if (i == NotificationCenter.storySendProgressChange || i == NotificationCenter.storySendProgressCanceled || i == NotificationCenter.storySendProgressCompleted || i == NotificationCenter.storySendFailedOrRetry) {
            updateVisibleLocalStoryIfNeeded(((Integer) objArr[0]).intValue());
            return;
        }
        if (i == NotificationCenter.storyListEmptyDetected) {
            removeProfile((String) objArr[0]);
            return;
        }
        if (i == NotificationCenter.profileStoryIdsDidLoad) {
            checkToRemoveEmptyStoryList(((StoryController.ProfileStoryInfo) objArr[0]).profileObject);
            updateVisibleProfileIfNeeded((StoryController.ProfileStoryInfo) objArr[0]);
            return;
        }
        if (i == NotificationCenter.myStoryDeleted || i == NotificationCenter.myStoryAdded) {
            updateVisibleStoryIfNeeded((StoryObject) objArr[0], i == NotificationCenter.myStoryDeleted);
            return;
        }
        if (i == NotificationCenter.storyObjectDidLoad) {
            StoryController.StoryInfo storyInfo = (StoryController.StoryInfo) objArr[0];
            if (storyInfo != null) {
                updateVisibleStoryIfNeeded(storyInfo.storyObject);
                return;
            }
            return;
        }
        if (i == NotificationCenter.storySeenCountChange) {
            updateStorySeenCountIfIsMyStory();
        } else if (i == NotificationCenter.highlightStoryIdsDidLoad && this.type == highlightType) {
            updateVisibleHighlightIfNeeded((StoryController.ProfileStoryInfo) objArr[0]);
        }
    }

    private void checkToRemoveEmptyStoryList(RubinoProfileObject rubinoProfileObject) {
        StoryController.ProfileStoryInfo instantProfileStoryIdsWithLocal;
        ArrayList<StoryController.StoryIdObject> arrayList;
        if (rubinoProfileObject == null || (instantProfileStoryIdsWithLocal = getStoryController().getInstantProfileStoryIdsWithLocal(rubinoProfileObject, null, false)) == null || (arrayList = instantProfileStoryIdsWithLocal.storyIdsObject) == null || arrayList.size() != 0) {
            return;
        }
        getStoryController().addToProfileStoryStatusMap(rubinoProfileObject.id, StoryController.ProfileStoryStatusEnum.NoStory);
        getNotificationCenter().postNotificationNameOnUIThread(NotificationCenter.storyListEmptyDetected, rubinoProfileObject.id);
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        ((Activity) context).getWindow().getDecorView();
        return super.createView(context);
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void findView() {
        super.findView();
        this.frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void init() throws IllegalStateException {
        super.init();
        this.needLockOrientation = true;
        lockOrientationPortrait();
        this.isNeedLifecycleObservable = true;
        this.swipeBackEnabled = false;
        this.swipeDownEnabled = true;
        this.fragmentAnimationDuration = 300.0f;
        this.presentAnimationType = ActionBarAnimationType.EXPAND;
        if (this.fragmentPresentOriginX != 0.0f && this.fragmentPresentOriginY != 0.0f) {
            this.dismissAnimationType = ActionBarAnimationType.COLLAPSE;
        } else {
            this.dismissAnimationType = ActionBarAnimationType.UTD;
        }
        this.progressBar.setVisibility(4);
        getFragmentView().setBackgroundColor(this.mContext.getResources().getColor(R.color.black));
        StoryPresenter storyPresenter = new StoryPresenter(this.mContext, false, new StoryPresenter.LockScrollListener() { // from class: ir.resaneh1.iptv.fragment.StoryFragment$$ExternalSyntheticLambda1
            @Override // ir.resaneh1.iptv.presenters.StoryPresenter.LockScrollListener
            public final void change(boolean z) {
                this.f$0.lambda$init$0(z);
            }
        });
        this.storyPresenter = storyPresenter;
        storyPresenter.storyFragment = this;
        storyPresenter.setScrollListener(this.scrollListener);
        StoryPresenter storyPresenter2 = new StoryPresenter(this.mContext, true, new StoryPresenter.LockScrollListener() { // from class: ir.resaneh1.iptv.fragment.StoryFragment$$ExternalSyntheticLambda0
            @Override // ir.resaneh1.iptv.presenters.StoryPresenter.LockScrollListener
            public final void change(boolean z) {
                this.f$0.lambda$init$1(z);
            }
        });
        this.localStoryPresenter = storyPresenter2;
        storyPresenter2.storyFragment = this;
        storyPresenter2.setScrollListener(this.scrollListener);
        setListLayout();
        this.mainArrayList.addAll(this.storyOfProfileList);
        this.mainAdapter.notifyDataSetChanged();
        this.mainRecyclerView.setNestedScrollingEnabled(false);
        if (Build.VERSION.SDK_INT >= 17) {
            this.mainRecyclerView.setLayoutDirection(0);
        }
        int i = this.startIndex;
        if (i < 0 || i >= this.storyOfProfileList.size()) {
            this.startIndex = 0;
        }
        try {
            this.mainRecyclerView.scrollToPosition(this.startIndex);
        } catch (Exception unused) {
        }
        int i2 = this.startIndex;
        this.currentSnapPosition = i2;
        if (i2 < 0 || i2 >= this.storyOfProfileList.size()) {
            return;
        }
        callGetStoryOfProfile(this.storyOfProfileList.get(this.startIndex));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0(boolean z) {
        this.cubeLayoutManager.setScrollEnabled(!z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$1(boolean z) {
        this.cubeLayoutManager.setScrollEnabled(!z);
    }

    public int getFirstCompletelyVisiblePosition() {
        if (this.mainRecyclerView.getLayoutManager() != null) {
            return ((LinearLayoutManager) this.mainRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
        }
        return -1;
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
        AndroidUtilities.removeAdjustResize(getParentActivity(), this.classGuid);
    }

    public int getMyStoryCurrentIndex() {
        int i = this.currentSnapPosition;
        if (i < 0 || i >= this.storyOfProfileList.size()) {
            return 0;
        }
        StoryListOfAProfileObject storyListOfAProfileObject = this.storyOfProfileList.get(this.currentSnapPosition);
        storyListOfAProfileObject.info = getStoryController().getInstantProfileStoryIdsWithLocal(storyListOfAProfileObject.profileObject, this.type == highlightType ? storyListOfAProfileObject.highlightId : null, false);
        if (storyListOfAProfileObject.isMyStory()) {
            return storyListOfAProfileObject.current;
        }
        return 0;
    }

    public StoryListOfAProfileObject getCurrentStoryListOfProfileObject() {
        StoryListOfAProfileObject storyListOfAProfileObject = this.storyOfProfileList.get(this.currentSnapPosition);
        storyListOfAProfileObject.info = getStoryController().getInstantProfileStoryIdsWithLocal(storyListOfAProfileObject.profileObject, this.type == highlightType ? storyListOfAProfileObject.highlightId : null, false);
        return storyListOfAProfileObject;
    }

    public void setMyStoryCurrentIndex(StoryController.StoryIdObject storyIdObject) {
        int i = this.currentSnapPosition;
        if (i < 0 || i >= this.storyOfProfileList.size()) {
            return;
        }
        StoryListOfAProfileObject storyListOfAProfileObject = this.storyOfProfileList.get(this.currentSnapPosition);
        storyListOfAProfileObject.info = getStoryController().getInstantProfileStoryIdsWithLocal(storyListOfAProfileObject.profileObject, this.type == highlightType ? storyListOfAProfileObject.highlightId : null, false);
        if (storyListOfAProfileObject.isMyStory()) {
            storyListOfAProfileObject.setCurrentById(storyIdObject);
        }
    }

    private void removeProfile(String str) {
        int iIndexOf;
        Iterator<StoryListOfAProfileObject> it = this.storyOfProfileList.iterator();
        while (true) {
            if (!it.hasNext()) {
                iIndexOf = -1;
                break;
            }
            StoryListOfAProfileObject next = it.next();
            if (next.getProfileId() != null && next.getProfileId().equals(str)) {
                iIndexOf = this.storyOfProfileList.indexOf(next);
                this.storyOfProfileList.remove(next);
                if (this.storyOfProfileList.size() == 0) {
                    if (ApplicationLoader.applicationActivity != null) {
                        ApplicationLoader.applicationActivity.onBackPressed();
                    }
                } else {
                    this.mainArrayList.remove(iIndexOf);
                    this.mainAdapter.notifyItemRemoved(iIndexOf);
                }
            }
        }
        if (iIndexOf == -1) {
            Iterator<PresenterItem> it2 = this.mainArrayList.iterator();
            while (it2.hasNext()) {
                PresenterItem next2 = it2.next();
                if (next2 instanceof StoryListOfAProfileObject) {
                    StoryListOfAProfileObject storyListOfAProfileObject = (StoryListOfAProfileObject) next2;
                    if (storyListOfAProfileObject.getProfileId() != null && storyListOfAProfileObject.getProfileId().equals(str)) {
                        int iIndexOf2 = this.mainArrayList.indexOf(next2);
                        this.mainArrayList.remove(iIndexOf2);
                        this.mainAdapter.notifyItemRemoved(iIndexOf2);
                        return;
                    }
                }
            }
        }
    }

    private void updateVisibleProfileIfNeeded(StoryController.ProfileStoryInfo profileStoryInfo) {
        View viewFindSnapView;
        if (profileStoryInfo == null || profileStoryInfo.profileObject == null || (viewFindSnapView = this.snapHelper.findSnapView(this.mainRecyclerView.getLayoutManager())) == null) {
            return;
        }
        StoryPresenter.MyViewHolder myViewHolder = (StoryPresenter.MyViewHolder) viewFindSnapView.getTag();
        Titem titem = myViewHolder.item;
        if (((StoryListOfAProfileObject) titem).profileObject == null || !((StoryListOfAProfileObject) titem).getProfileId().equals(profileStoryInfo.profileObject.id)) {
            return;
        }
        Titem titem2 = myViewHolder.item;
        ((StoryListOfAProfileObject) titem2).info = profileStoryInfo;
        this.storyPresenter.onBindViewHolder(myViewHolder, (StoryListOfAProfileObject) titem2);
    }

    private void updateVisibleHighlightIfNeeded(StoryController.ProfileStoryInfo profileStoryInfo) {
        View viewFindSnapView;
        if (profileStoryInfo == null || profileStoryInfo.profileObject == null || (viewFindSnapView = this.snapHelper.findSnapView(this.mainRecyclerView.getLayoutManager())) == null) {
            return;
        }
        StoryPresenter.MyViewHolder myViewHolder = (StoryPresenter.MyViewHolder) viewFindSnapView.getTag();
        Titem titem = myViewHolder.item;
        if (((StoryListOfAProfileObject) titem).highlightId == null || !((StoryListOfAProfileObject) titem).highlightId.equals(profileStoryInfo.highlightId)) {
            return;
        }
        Titem titem2 = myViewHolder.item;
        ((StoryListOfAProfileObject) titem2).info = profileStoryInfo;
        this.storyPresenter.onBindViewHolder(myViewHolder, (StoryListOfAProfileObject) titem2);
    }

    private void updateStorySeenCountIfIsMyStory() {
        View viewFindSnapView = this.snapHelper.findSnapView(this.mainRecyclerView.getLayoutManager());
        if (viewFindSnapView != null) {
            StoryPresenter.MyViewHolder myViewHolder = (StoryPresenter.MyViewHolder) viewFindSnapView.getTag();
            Titem titem = myViewHolder.item;
            if (((StoryListOfAProfileObject) titem).profileObject == null || !((StoryListOfAProfileObject) titem).isMyStory()) {
                return;
            }
            this.storyPresenter.onBindViewHolder(myViewHolder, (StoryListOfAProfileObject) myViewHolder.item);
        }
    }

    private void updateVisibleStoryIfNeeded(StoryObject storyObject, boolean z) {
        View viewFindViewByPosition;
        StoryPresenter.MyViewHolder myViewHolder;
        if (this.type == highlightType || storyObject == null || storyObject.profile_id == null) {
            return;
        }
        View viewFindSnapView = this.snapHelper.findSnapView(this.mainRecyclerView.getLayoutManager());
        if (viewFindSnapView != null) {
            myViewHolder = (StoryPresenter.MyViewHolder) viewFindSnapView.getTag();
        } else {
            try {
                viewFindViewByPosition = this.mainRecyclerView.getLayoutManager().findViewByPosition(this.currentSnapPosition);
            } catch (Exception unused) {
            }
            myViewHolder = viewFindViewByPosition != null ? (StoryPresenter.MyViewHolder) viewFindViewByPosition.getTag() : null;
        }
        if (myViewHolder == null) {
            return;
        }
        Titem titem = myViewHolder.item;
        if (((StoryListOfAProfileObject) titem).profileObject == null || !((StoryListOfAProfileObject) titem).profileObject.id.equals(storyObject.profile_id)) {
            return;
        }
        StoryListOfAProfileObject storyListOfAProfileObject = (StoryListOfAProfileObject) myViewHolder.item;
        StoryController storyController = getStoryController();
        Titem titem2 = myViewHolder.item;
        storyListOfAProfileObject.info = storyController.getInstantProfileStoryIdsWithLocalAndLoadIfNeeded(((StoryListOfAProfileObject) titem2).profileObject, this.type == highlightType ? ((StoryListOfAProfileObject) titem2).highlightId : null);
        Titem titem3 = myViewHolder.item;
        if (((StoryListOfAProfileObject) titem3).info != null && ((StoryListOfAProfileObject) titem3).info.storyIdsObject != null && ((StoryListOfAProfileObject) titem3).info.storyIdsObject.size() > 0) {
            Titem titem4 = myViewHolder.item;
            if (((StoryListOfAProfileObject) titem4).current >= ((StoryListOfAProfileObject) titem4).info.storyIdsObject.size()) {
                Titem titem5 = myViewHolder.item;
                ((StoryListOfAProfileObject) titem5).current = ((StoryListOfAProfileObject) titem5).info.storyIdsObject.size() - 1;
            }
            if (z) {
                this.storyPresenter.onBindViewHolder(myViewHolder, (StoryListOfAProfileObject) myViewHolder.item);
                return;
            } else {
                if (storyObject.id.equals(((StoryListOfAProfileObject) myViewHolder.item).getCurrentStoryId().getIdOrRnd())) {
                    this.storyPresenter.onBindViewHolder(myViewHolder, (StoryListOfAProfileObject) myViewHolder.item);
                    return;
                }
                return;
            }
        }
        getStoryController().addToProfileStoryStatusMap(storyObject.profile_id, StoryController.ProfileStoryStatusEnum.NoStory);
        getNotificationCenter().postNotificationNameOnUIThread(NotificationCenter.storyListEmptyDetected, storyObject.profile_id);
        nextPersonIfPossible(myViewHolder.getAdapterPosition(), 1);
    }

    private void updateVisibleStoryIfNeeded(StoryObject storyObject) {
        if (storyObject == null) {
            return;
        }
        View viewFindSnapView = this.snapHelper.findSnapView(this.mainRecyclerView.getLayoutManager());
        StoryPresenter.MyViewHolder myViewHolder = null;
        if (viewFindSnapView != null) {
            myViewHolder = (StoryPresenter.MyViewHolder) viewFindSnapView.getTag();
        } else {
            View viewFindViewByPosition = this.mainRecyclerView.getLayoutManager().findViewByPosition(this.currentSnapPosition);
            if (viewFindViewByPosition != null) {
                myViewHolder = (StoryPresenter.MyViewHolder) viewFindViewByPosition.getTag();
            }
        }
        if (myViewHolder == null) {
            return;
        }
        Titem titem = myViewHolder.item;
        if (((StoryListOfAProfileObject) titem).info == null || ((StoryListOfAProfileObject) titem).info.storyIdsObject == null || ((StoryListOfAProfileObject) titem).current >= ((StoryListOfAProfileObject) titem).info.storyIdsObject.size()) {
            return;
        }
        Titem titem2 = myViewHolder.item;
        if (((StoryListOfAProfileObject) titem2).info.storyIdsObject.get(((StoryListOfAProfileObject) titem2).current).getIdOrRnd().equals(storyObject.id)) {
            this.storyPresenter.onBindViewHolder(myViewHolder, (StoryListOfAProfileObject) myViewHolder.item);
        }
    }

    private void updateVisibleLocalStoryIfNeeded(int i) {
        StoryPresenter.MyViewHolder myViewHolder;
        View viewFindSnapView = this.snapHelper.findSnapView(this.mainRecyclerView.getLayoutManager());
        if (viewFindSnapView != null) {
            myViewHolder = (StoryPresenter.MyViewHolder) viewFindSnapView.getTag();
        } else {
            View viewFindViewByPosition = this.mainRecyclerView.getLayoutManager().findViewByPosition(this.currentSnapPosition);
            myViewHolder = viewFindViewByPosition != null ? (StoryPresenter.MyViewHolder) viewFindViewByPosition.getTag() : null;
        }
        if (myViewHolder == null || ((StoryListOfAProfileObject) myViewHolder.item).getCurrentStoryObject() == null || ((StoryListOfAProfileObject) myViewHolder.item).getCurrentStoryObject().rnd != i) {
            return;
        }
        this.localStoryPresenter.updateSendingState(myViewHolder);
    }

    public void setListLayout() throws IllegalStateException {
        CubeLayoutManager cubeLayoutManager = new CubeLayoutManager(this.mContext, 0, false);
        this.cubeLayoutManager = cubeLayoutManager;
        this.linearLayoutManager = cubeLayoutManager;
        this.mainRecyclerView.setLayoutManager(cubeLayoutManager);
        StorySnapHelper storySnapHelper = new StorySnapHelper();
        this.snapHelper = storySnapHelper;
        storySnapHelper.attachToRecyclerView(this.mainRecyclerView);
        this.mainRecyclerView.getLayoutParams().width = DimensionHelper.getScreenMinDimension((Activity) this.mContext);
        MainAdapter mainAdapter = new MainAdapter(this.mContext, this.mainArrayList, new PresenterSelector() { // from class: ir.resaneh1.iptv.fragment.StoryFragment.1
            final MainPresenterSelector mainPresenterSelector;

            {
                this.mainPresenterSelector = MainPresenterSelector.getInstance(StoryFragment.this.mContext);
            }

            @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterSelector
            public AbstractPresenter getPresenter(PresenterItemType presenterItemType) {
                if (presenterItemType == PresenterItemType.storyListOfProfileObject) {
                    return StoryFragment.this.storyPresenter;
                }
                if (presenterItemType == PresenterItemType.localStoryListOfProfileObject) {
                    return StoryFragment.this.localStoryPresenter;
                }
                return this.mainPresenterSelector.getPresenter(presenterItemType);
            }
        }, new OnPresenterItemClickListener(this) { // from class: ir.resaneh1.iptv.fragment.StoryFragment.2
            @Override // ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener
            public void onClick(AbstractPresenter.AbstractViewHolder abstractViewHolder) {
            }
        }, new OnLoadMoreListener(this) { // from class: ir.resaneh1.iptv.fragment.StoryFragment.3
            @Override // ir.resaneh1.iptv.presenter.abstracts.OnLoadMoreListener
            public void loadMore(int i) {
            }
        });
        this.mainAdapter = mainAdapter;
        mainAdapter.isWantLoadMore = false;
        this.mainRecyclerView.addOnItemTouchListener(new RecyclerView.SimpleOnItemTouchListener(this) { // from class: ir.resaneh1.iptv.fragment.StoryFragment.4
            @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
                return false;
            }
        });
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        ((ViewGroup) this.mainRecyclerView.getParent()).addView(frameLayout, LayoutHelper.createFrame(-1, -1.0f));
        frameLayout.setOnTouchListener(new View.OnTouchListener() { // from class: ir.resaneh1.iptv.fragment.StoryFragment.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int iFindFirstCompletelyVisibleItemPosition = ((LinearLayoutManager) StoryFragment.this.mainRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
                MyLog.e("StoryFragment", "onInterceptTouchEvent p" + iFindFirstCompletelyVisibleItemPosition + " s" + StoryFragment.this.mainRecyclerView.getScrollState());
                return iFindFirstCompletelyVisibleItemPosition == -1 && StoryFragment.this.mainRecyclerView.getScrollState() != 1;
            }
        });
        this.mainRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.resaneh1.iptv.fragment.StoryFragment.6
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                boolean z;
                boolean z2;
                ArrayList<StoryController.StoryIdObject> arrayList;
                super.onScrollStateChanged(recyclerView, i);
                MyLog.e("StoryFragment", "OnScrollListener newState" + i);
                if (i == 0) {
                    try {
                        View viewFindSnapView = StoryFragment.this.snapHelper.findSnapView(StoryFragment.this.mainRecyclerView.getLayoutManager());
                        if (viewFindSnapView != null) {
                            if (StoryFragment.this.getFirstCompletelyVisiblePosition() < 0) {
                                return;
                            }
                            int position = StoryFragment.this.mainRecyclerView.getLayoutManager().getPosition(viewFindSnapView);
                            StoryPresenter.MyViewHolder myViewHolder = (StoryPresenter.MyViewHolder) recyclerView.findViewHolderForAdapterPosition(position);
                            StoryFragment.this.mainAdapter.getLifecycle().onNext(PresenterFragment.LifeCycleState.resume);
                            MyLog.e("logStory", " position " + position + " currentSnapPosition " + StoryFragment.this.currentSnapPosition);
                            if (position != StoryFragment.this.currentSnapPosition) {
                                MyLog.e("logStory", " position " + position + " onBindViewHolder 1");
                                StoryFragment storyFragment = StoryFragment.this;
                                storyFragment.cancelLastDownloadIfNeeded(storyFragment.currentSnapPosition, 0);
                                StoryFragment storyFragment2 = StoryFragment.this;
                                storyFragment2.currentSnapPosition = position;
                                storyFragment2.storyPresenter.onBindViewHolder(myViewHolder, (StoryListOfAProfileObject) myViewHolder.item);
                            } else {
                                MyLog.e("logStory", " position " + position + " resumeProgressAndVideo 1");
                                StoryFragment.this.storyPresenter.hideAndShowViewsOnTouch(myViewHolder, true);
                                StoryFragment.this.storyPresenter.resumeProgressAndVideo(myViewHolder);
                            }
                            if (StoryFragment.this.scrollListener != null) {
                                StoryFragment.this.scrollListener.onScrollHorizontally(StoryFragment.this.currentSnapPosition);
                                return;
                            }
                            return;
                        }
                        StoryFragment.this.mainAdapter.getLifecycle().onNext(PresenterFragment.LifeCycleState.pause);
                        return;
                    } catch (Exception unused) {
                        return;
                    }
                }
                if (i != 1 || ((CubeLayoutManager) recyclerView.getLayoutManager()).canScrollHorizontally()) {
                    z = false;
                    z2 = false;
                } else {
                    int iFindLastCompletelyVisibleItemPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findLastCompletelyVisibleItemPosition();
                    z2 = iFindLastCompletelyVisibleItemPosition == StoryFragment.this.mainArrayList.size() - 1;
                    z = iFindLastCompletelyVisibleItemPosition == 0;
                }
                if (z2) {
                    ArrayList<PresenterItem> arrayList2 = StoryFragment.this.mainArrayList;
                    StoryListOfAProfileObject storyListOfAProfileObject = (StoryListOfAProfileObject) arrayList2.get(arrayList2.size() - 1);
                    StoryController.ProfileStoryInfo profileStoryInfo = storyListOfAProfileObject.info;
                    if (profileStoryInfo == null || (arrayList = profileStoryInfo.storyIdsObject) == null || storyListOfAProfileObject.current != arrayList.size() - 1 || ApplicationLoader.applicationActivity == null) {
                        return;
                    }
                    ApplicationLoader.applicationActivity.onBackPressed();
                    return;
                }
                if (z) {
                    StoryListOfAProfileObject storyListOfAProfileObject2 = (StoryListOfAProfileObject) StoryFragment.this.mainArrayList.get(0);
                    StoryController.ProfileStoryInfo profileStoryInfo2 = storyListOfAProfileObject2.info;
                    if (profileStoryInfo2 == null || profileStoryInfo2.storyIdsObject == null || storyListOfAProfileObject2.current != 0 || ApplicationLoader.applicationActivity == null) {
                        return;
                    }
                    ApplicationLoader.applicationActivity.onBackPressed();
                    return;
                }
                StoryFragment.this.mainAdapter.getLifecycle().onNext(PresenterFragment.LifeCycleState.pause);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                MyLog.e("StoryFragment", "OnScrollListener onScrolled x " + i + " y " + i2 + " state " + recyclerView.getScrollState());
                if (Math.abs(i) <= AndroidUtilities.dp(16.0f) || recyclerView.getScrollState() == 0) {
                    return;
                }
                StoryFragment.this.mainAdapter.getLifecycle().onNext(PresenterFragment.LifeCycleState.pause);
            }
        });
        this.mainAdapter.setParentLifeCycleObservable(getLifecycle());
        this.mainRecyclerView.setAdapter(this.mainAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelLastDownloadIfNeeded(final int i, final int i2) {
        MyLog.e("StoryLogPreload", "StoryFragment check to   cancel cancel Download position " + i + " countOfNextProfileToCancel " + i2);
        Observable.just(1).observeOn(Schedulers.computation()).subscribe(new DisposableObserver<Integer>() { // from class: ir.resaneh1.iptv.fragment.StoryFragment.7
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onNext(Integer num) {
                StoryListOfAProfileObject storyListOfAProfileObject;
                StoryController.ProfileStoryInfo instantProfileStoryIdsEvenIfExpired;
                ArrayList<String> nextStoryIdsWithoutLocal;
                for (int i3 = 0; i3 <= i2; i3++) {
                    int i4 = i + i3;
                    MyLog.e("StoryLogPreload", "StoryFragment check to   cancel cancel  positionToCancel " + i4);
                    if (i4 >= 0 && i4 < StoryFragment.this.storyOfProfileList.size() && (storyListOfAProfileObject = (StoryListOfAProfileObject) StoryFragment.this.storyOfProfileList.get(i4)) != null) {
                        if (StoryFragment.this.type == StoryFragment.highlightType) {
                            instantProfileStoryIdsEvenIfExpired = StoryFragment.this.getStoryController().getInstantHighlightStoryIdsEvenIfExpired(storyListOfAProfileObject.highlightId);
                        } else {
                            instantProfileStoryIdsEvenIfExpired = StoryFragment.this.getStoryController().getInstantProfileStoryIdsEvenIfExpired(storyListOfAProfileObject.profileObject);
                        }
                        if (instantProfileStoryIdsEvenIfExpired != null && instantProfileStoryIdsEvenIfExpired.storyIdsObject != null) {
                            if (i3 == 0) {
                                nextStoryIdsWithoutLocal = instantProfileStoryIdsEvenIfExpired.getNextStoryIdsWithoutLocal(storyListOfAProfileObject.current, StoryFragment.this.preLoadCurrentStoryCount);
                            } else {
                                nextStoryIdsWithoutLocal = instantProfileStoryIdsEvenIfExpired.getNextStoryIdsWithoutLocal(-1, StoryFragment.this.preLoadStoryPerProfileCount);
                            }
                            if (nextStoryIdsWithoutLocal != null) {
                                Iterator<String> it = nextStoryIdsWithoutLocal.iterator();
                                while (it.hasNext()) {
                                    StoryObject instantStoryEvenIfExpired = StoryFragment.this.getStoryController().getInstantStoryEvenIfExpired(it.next());
                                    if (instantStoryEvenIfExpired != null) {
                                        if (instantStoryEvenIfExpired.playerInfoObject != null) {
                                            MyLog.e("StoryLogPreload2", "cancel in StoryFragment position" + i4 + " storyId " + instantStoryEvenIfExpired.id + " url " + instantStoryEvenIfExpired.full_file_url);
                                            FileLoaderRubinoPost.getInstance(((BaseFragment) StoryFragment.this).currentAccount).cancelLoadFile(instantStoryEvenIfExpired.playerInfoObject);
                                        }
                                        StoryFragment.this.clearStoryPreloadPicture(instantStoryEvenIfExpired.id);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });
    }

    public void clearStoryPreloadPicture(String str) {
        if (str == null) {
            return;
        }
        Target<Drawable> target = this.storyImageTargetViewMap.get(str);
        if (target != null) {
            GlideHelper.clearTarget(this.mContext, target);
        }
        synchronized (this.syncStoryImageTargetMapObject) {
            this.storyImageTargetViewMap.remove(str);
        }
    }

    private void clearAllStoryPreloadPicture() {
        synchronized (this.syncStoryImageTargetMapObject) {
            Iterator<String> it = this.storyImageTargetViewMap.keySet().iterator();
            while (it.hasNext()) {
                Target<Drawable> target = this.storyImageTargetViewMap.get(it.next());
                if (target != null) {
                    GlideHelper.clearTarget(this.mContext, target);
                }
            }
            this.storyImageTargetViewMap.clear();
        }
    }

    public void stopProgressAndSetPreview() {
        StoryPresenter.MyViewHolder myViewHolder = (StoryPresenter.MyViewHolder) this.mainRecyclerView.findViewHolderForAdapterPosition(((LinearLayoutManager) this.mainRecyclerView.getLayoutManager()).findFirstVisibleItemPosition());
        if (myViewHolder != null) {
            myViewHolder.isForceToStopAsPreview = true;
            this.storyPresenter.setPreview(myViewHolder);
        }
    }

    public void resumeProgressAndSetPreview() {
        StoryPresenter.MyViewHolder myViewHolder = (StoryPresenter.MyViewHolder) this.mainRecyclerView.findViewHolderForAdapterPosition(((LinearLayoutManager) this.mainRecyclerView.getLayoutManager()).findFirstVisibleItemPosition());
        if (myViewHolder != null) {
            myViewHolder.isForceToStopAsPreview = false;
            this.storyPresenter.unSetPreview(myViewHolder);
        }
    }

    public void preLoadMedia(final int i) {
        DisposableObserver disposableObserver = this.preLoadObserver;
        if (disposableObserver != null && !disposableObserver.isDisposed()) {
            this.preLoadObserver.dispose();
        }
        DisposableObserver disposableObserver2 = (DisposableObserver) Observable.timer(1000L, TimeUnit.MILLISECONDS).observeOn(Schedulers.computation()).flatMap(new Function<Long, ObservableSource<Map<String, String>>>() { // from class: ir.resaneh1.iptv.fragment.StoryFragment.9
            @Override // io.reactivex.functions.Function
            public ObservableSource<Map<String, String>> apply(Long l) throws Exception {
                StoryListOfAProfileObject storyListOfAProfileObject;
                StoryController.ProfileStoryInfo instantProfileStoryIdsEvenIfExpired;
                ArrayList<StoryController.StoryIdObject> arrayList;
                ArrayList<String> nextStoryIdsWithoutLocal;
                HashMap map = new HashMap();
                int i2 = 0;
                while (true) {
                    StoryFragment storyFragment = StoryFragment.this;
                    if (i2 <= storyFragment.preLoadProfileCount) {
                        int i3 = i + i2;
                        if (i3 >= 0 && i3 < storyFragment.storyOfProfileList.size() && (storyListOfAProfileObject = (StoryListOfAProfileObject) StoryFragment.this.storyOfProfileList.get(i3)) != null && (i2 == 0 || !storyListOfAProfileObject.isPreLoadStoryMediaCalled)) {
                            MyLog.e("StoryLogPreload", "storyFragment tryToPreLoad index " + i3);
                            if (StoryFragment.this.type == StoryFragment.highlightType) {
                                instantProfileStoryIdsEvenIfExpired = StoryFragment.this.getStoryController().getInstantHighlightStoryIdsEvenIfExpired(storyListOfAProfileObject.highlightId);
                            } else {
                                instantProfileStoryIdsEvenIfExpired = StoryFragment.this.getStoryController().getInstantProfileStoryIdsEvenIfExpired(storyListOfAProfileObject.profileObject);
                            }
                            if (instantProfileStoryIdsEvenIfExpired != null && (arrayList = instantProfileStoryIdsEvenIfExpired.storyIdsObject) != null && arrayList.size() > 0) {
                                if (i2 == 0) {
                                    nextStoryIdsWithoutLocal = instantProfileStoryIdsEvenIfExpired.getNextStoryIdsWithoutLocal(storyListOfAProfileObject.current, StoryFragment.this.preLoadCurrentStoryCount);
                                } else {
                                    nextStoryIdsWithoutLocal = instantProfileStoryIdsEvenIfExpired.getNextStoryIdsWithoutLocal(-1, StoryFragment.this.preLoadStoryPerProfileCount);
                                }
                                if (nextStoryIdsWithoutLocal != null) {
                                    Iterator<String> it = nextStoryIdsWithoutLocal.iterator();
                                    while (it.hasNext()) {
                                        StoryObject instantStoryEvenIfExpired = StoryFragment.this.getStoryController().getInstantStoryEvenIfExpired(it.next());
                                        if (instantStoryEvenIfExpired != null) {
                                            storyListOfAProfileObject.isPreLoadStoryMediaCalled = true;
                                            if (!instantStoryEvenIfExpired.isPreLoadVideoOrImageCalled) {
                                                instantStoryEvenIfExpired.isPreLoadVideoOrImageCalled = true;
                                                StoryObject.StoryTypeEnum storyTypeEnum = instantStoryEvenIfExpired.story_type;
                                                StoryObject.StoryTypeEnum storyTypeEnum2 = StoryObject.StoryTypeEnum.Video;
                                                String str = null;
                                                if (storyTypeEnum == storyTypeEnum2 && instantStoryEvenIfExpired.playerInfoObject != null) {
                                                    MyLog.e("StoryLogPreload2", "preLoadVideo in storyFragment  storyId " + instantStoryEvenIfExpired.id + " index " + i3 + " profileId " + instantStoryEvenIfExpired.profile_id);
                                                    FileLoaderRubinoPost.getInstance(((BaseFragment) StoryFragment.this).currentAccount).loadFile(instantStoryEvenIfExpired.playerInfoObject, null, 0, 10);
                                                }
                                                if (StoryFragment.this.storyImageTargetViewMap.get(instantStoryEvenIfExpired.id) == null) {
                                                    StoryObject.StoryTypeEnum storyTypeEnum3 = instantStoryEvenIfExpired.story_type;
                                                    if (storyTypeEnum3 == StoryObject.StoryTypeEnum.Picture) {
                                                        str = instantStoryEvenIfExpired.full_file_url;
                                                    } else if (storyTypeEnum3 == storyTypeEnum2) {
                                                        str = instantStoryEvenIfExpired.full_snapshot_url;
                                                    }
                                                    MyLog.e("StoryLogPreload22", "preLoadPicture in storyFragment  storyId " + instantStoryEvenIfExpired.id + " storyType " + instantStoryEvenIfExpired.story_type + " index " + i3 + " profileId " + instantStoryEvenIfExpired.profile_id);
                                                    map.put(instantStoryEvenIfExpired.id, str);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        i2++;
                    } else {
                        return Observable.just(map);
                    }
                }
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Map<String, String>>() { // from class: ir.resaneh1.iptv.fragment.StoryFragment.8
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onNext(Map<String, String> map) {
                synchronized (StoryFragment.this.syncStoryImageTargetMapObject) {
                    Target<Drawable> targetPreload = null;
                    for (String str : map.keySet()) {
                        String str2 = map.get(str);
                        if (str2 != null) {
                            targetPreload = GlideHelper.preload(StoryFragment.this.mContext, str2);
                        }
                        if (targetPreload != null) {
                            StoryFragment.this.storyImageTargetViewMap.put(str, targetPreload);
                        }
                    }
                }
            }
        });
        this.preLoadObserver = disposableObserver2;
        ((PresenterFragment) this).compositeDisposable.add(disposableObserver2);
    }

    public void getCurrentStoryAndPreload(int i) {
        StoryListOfAProfileObject storyListOfAProfileObject;
        int i2 = -1;
        while (i2 <= 2) {
            int i3 = i + i2;
            if (i3 >= 0 && i3 < this.storyOfProfileList.size() && (storyListOfAProfileObject = this.storyOfProfileList.get(i3)) != null && (i2 == 0 || !storyListOfAProfileObject.isPreLoadedStory)) {
                storyListOfAProfileObject.isPreLoadedStory = true;
                ((PresenterFragment) this).compositeDisposable.add((Disposable) getStoryController().getStoryIdsWithLoadStoryObservable(storyListOfAProfileObject.profileObject, storyListOfAProfileObject.highlightId, storyListOfAProfileObject.current, 10, i2 != 0).subscribeWith(new DisposableObserver<Integer>(this) { // from class: ir.resaneh1.iptv.fragment.StoryFragment.10
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
            i2++;
        }
    }

    public void nextPersonIfPossible(int i, int i2) {
        final int i3 = i + i2;
        if (i3 >= 0 && i3 < this.mainArrayList.size()) {
            this.cubeLayoutManager.setScrollEnabled(true);
            this.mainRecyclerView.post(new Runnable() { // from class: ir.resaneh1.iptv.fragment.StoryFragment.11
                @Override // java.lang.Runnable
                public void run() {
                    ((LinearLayoutManager) StoryFragment.this.mainRecyclerView.getLayoutManager()).smoothScrollToPosition(StoryFragment.this.mainRecyclerView, new RecyclerView.State(), i3);
                }
            });
        } else {
            if (i3 < this.mainArrayList.size() || ApplicationLoader.applicationActivity == null) {
                return;
            }
            if ((ApplicationLoader.applicationActivity.getLastFragment() instanceof StoryFragment) || (ApplicationLoader.applicationActivity.getLastFragment() instanceof StorySeenFragment)) {
                ApplicationLoader.applicationActivity.getLastFragment().finishFragment();
            }
        }
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        AndroidUtilities.requestAdjustResize(getParentActivity(), this.classGuid);
        if (ApplicationLoader.applicationActivity != null) {
            ApplicationLoader.applicationActivity.getWindow().setSoftInputMode(16);
        }
        lockOrientationPortrait();
        MainAdapter mainAdapter = this.mainAdapter;
        if (mainAdapter != null) {
            mainAdapter.notifyDataSetChanged();
        }
    }

    public void callGetStoryOfProfile(StoryListOfAProfileObject storyListOfAProfileObject) {
        if (storyListOfAProfileObject == null || storyListOfAProfileObject.profileObject == null) {
            return;
        }
        StoryController.ProfileStoryInfo instantProfileStoryIdsWithLocalAndLoadIfNeeded = StoryController.getInstance(this.currentAccount).getInstantProfileStoryIdsWithLocalAndLoadIfNeeded(storyListOfAProfileObject.profileObject, this.type == highlightType ? storyListOfAProfileObject.highlightId : null);
        storyListOfAProfileObject.info = instantProfileStoryIdsWithLocalAndLoadIfNeeded;
        if (instantProfileStoryIdsWithLocalAndLoadIfNeeded == null || instantProfileStoryIdsWithLocalAndLoadIfNeeded.storyIdsObject == null) {
            return;
        }
        storyListOfAProfileObject.setCurrentBasedOnSeenForFirstTime();
        StoryController.StoryIdObject storyIdObject = this.defaultStory;
        if (storyIdObject != null) {
            storyListOfAProfileObject.setCurrentById(storyIdObject);
        }
        this.mainAdapter.notifyDataSetChanged();
    }
}
