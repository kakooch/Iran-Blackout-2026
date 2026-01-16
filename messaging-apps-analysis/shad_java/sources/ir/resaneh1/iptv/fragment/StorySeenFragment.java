package ir.resaneh1.iptv.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.dialog.LoadingDialog;
import ir.resaneh1.iptv.fragment.rubino.ProfileInSeenStoryCell;
import ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited;
import ir.resaneh1.iptv.fragment.rubino.RubinoEmojiSliderResultCell;
import ir.resaneh1.iptv.fragment.rubino.RubinoEmptyView;
import ir.resaneh1.iptv.fragment.rubino.RubinoLoadingCell;
import ir.resaneh1.iptv.fragment.rubino.RubinoPollResultCell;
import ir.resaneh1.iptv.fragment.rubino.RubinoRetryView;
import ir.resaneh1.iptv.helper.AppRubinoPreferences;
import ir.resaneh1.iptv.helper.CenterZoomLayoutManager;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.helper.StorageHelper;
import ir.resaneh1.iptv.helper.StoryController;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.GetStoryViewersInput;
import ir.resaneh1.iptv.model.GetStoryViewersOutput;
import ir.resaneh1.iptv.model.LoadMoreItem;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.model.RubinoProfileObject;
import ir.resaneh1.iptv.model.StoryListOfAProfileObject;
import ir.resaneh1.iptv.model.StoryObject;
import ir.resaneh1.iptv.presenter.MainPresenterSelector;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import ir.resaneh1.iptv.presenter.abstracts.PresenterSelector;
import ir.resaneh1.iptv.presenter.adapter.MainAdapter;
import ir.resaneh1.iptv.presenters.AddNewStoryInSeenPresenter;
import ir.resaneh1.iptv.presenters.RubinoProfileRowInSeenStoryPresenter;
import ir.resaneh1.iptv.presenters.StoryInSeenPresenter;
import ir.resaneh1.iptv.presenters.StoryPresenter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.ui.ActionBar.ActionBarAnimationType;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class StorySeenFragment extends PresenterFragment implements NotificationCenter.NotificationCenterDelegate {
    public static int highlightType = 1;
    public static int storyType;
    private int currentSnapPosition;
    private StoryController.StoryIdObject defaultStory;
    private FrameLayout devider1;
    private FrameLayout devider2;
    private int emojiSliderRow;
    private FrameLayout frameLayoutMiddle;
    private FrameLayout frameLayoutTopContainer;
    private boolean hasContinue;
    private ImageView imageViewClose;
    private ImageView imageViewDelete;
    private ImageView imageViewSeen;
    private ImageView imageViewTriangle;
    private boolean isInSeenMode;
    private boolean isSwipeDownEnable;
    private ListAdapter listAdapter;
    private RecyclerListViewEdited listView;
    private FrameLayout listViewContainer;
    private int loadMorePosition;
    private int loadingRow;
    private FrameLayout middleToolsBackground;
    private boolean needToRetry;
    private boolean needToScrollFirstTime;
    private int pollRow;
    private ArrayList<RubinoProfileObject> profileArray;
    private RecyclerView recyclerViewStory;
    private DisposableObserver requestDisposable;
    private int rowCount;
    private AnimatorSet scaleToBackAnimation;
    private AnimatorSet scaleToSmallAnimation;
    float screenHeight;
    float screenWidth;
    private SnapHelper snapHelper;
    private String startId;
    private int startIndex;
    private MainAdapter storyAdapter;
    private FrameLayout storyContainer;
    private StoryFragment storyFragment;
    private StoryInSeenPresenter storyInSeenPresenter;
    private AddNewStoryInSeenPresenter storyInSeenPresenterAddNew;
    private ArrayList<PresenterItem> storyList;
    private ArrayList<StoryListOfAProfileObject> storyListOfAProfileObjects;
    private TextView textViewSeenCount2;
    private int type;
    private int viewerArrayEndRow;
    private int viewerArrayStartRow;

    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.story_seen_fragment;
    }

    public StorySeenFragment(boolean z) {
        this.currentSnapPosition = -1;
        this.storyList = new ArrayList<>();
        this.hasContinue = true;
        this.profileArray = new ArrayList<>();
        new ArrayList();
        new ArrayList();
        this.type = 0;
        this.startIndex = 0;
        this.isSwipeDownEnable = z;
        this.needLockOrientation = true;
        this.isForceBlackTheme = true;
        this.fragmentName = "StorySeenFragment";
        this.type = storyType;
    }

    public StorySeenFragment(boolean z, int i, ArrayList<StoryListOfAProfileObject> arrayList, int i2) {
        this.currentSnapPosition = -1;
        this.storyList = new ArrayList<>();
        this.hasContinue = true;
        this.profileArray = new ArrayList<>();
        new ArrayList();
        new ArrayList();
        this.type = 0;
        this.startIndex = 0;
        this.isSwipeDownEnable = z;
        this.type = i;
        if (i == highlightType) {
            this.hasContinue = false;
        }
        this.startIndex = i2;
        this.storyListOfAProfileObjects = arrayList;
        this.needLockOrientation = true;
        this.isForceBlackTheme = true;
        this.fragmentName = "StorySeenFragment";
    }

    public StorySeenFragment(StoryController.StoryIdObject storyIdObject, boolean z) {
        this.currentSnapPosition = -1;
        this.storyList = new ArrayList<>();
        this.hasContinue = true;
        this.profileArray = new ArrayList<>();
        new ArrayList();
        new ArrayList();
        this.type = 0;
        this.startIndex = 0;
        this.defaultStory = storyIdObject;
        this.needLockOrientation = true;
        this.isSwipeDownEnable = z;
        this.isForceBlackTheme = true;
        this.fragmentName = "StorySeenFragment";
        this.type = storyType;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean isSwipeDownEnabled() {
        if (this.isInSeenMode) {
            return false;
        }
        return this.isSwipeDownEnable;
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void findView() {
        super.findView();
        this.frameLayoutMiddle = (FrameLayout) findViewById(R.id.frameLayoutMiddle);
        this.middleToolsBackground = (FrameLayout) findViewById(R.id.middleToolsBackground);
        this.imageViewDelete = (ImageView) findViewById(R.id.imageViewDelete);
        this.imageViewSeen = (ImageView) findViewById(R.id.imageViewSeen);
        this.frameLayoutTopContainer = (FrameLayout) findViewById(R.id.frameLayoutTopContainer);
        this.textViewSeenCount2 = (TextView) findViewById(R.id.textViewCount);
        this.imageViewClose = (ImageView) findViewById(R.id.imageViewClose);
        this.recyclerViewStory = (RecyclerView) findViewById(R.id.recyclerViewStory);
        this.listViewContainer = (FrameLayout) findViewById(R.id.listViewContainer);
        this.imageViewTriangle = (ImageView) findViewById(R.id.imageViewTriangle);
        this.devider1 = (FrameLayout) findViewById(R.id.devider1);
        this.devider2 = (FrameLayout) findViewById(R.id.devider2);
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void init() throws IllegalStateException {
        super.init();
        this.screenWidth = DimensionHelper.getScreenMinDimension((Activity) this.mContext);
        float screenMaxDimension = DimensionHelper.getScreenMaxDimension((Activity) this.mContext);
        this.screenHeight = screenMaxDimension;
        this.screenHeight = screenMaxDimension - DimensionHelper.getScreenStatusBarHeightIfNoCutoutAndNoNeedFullScreen();
        boolean z = false;
        this.swipeBackEnabled = false;
        int i = 1;
        if (this.isSwipeDownEnable) {
            this.swipeDownEnabled = true;
            this.fragmentAnimationDuration = 300.0f;
            this.presentAnimationType = ActionBarAnimationType.EXPAND;
            if (this.fragmentPresentOriginX != 0.0f && this.fragmentPresentOriginY != 0.0f) {
                this.dismissAnimationType = ActionBarAnimationType.COLLAPSE;
            } else {
                this.dismissAnimationType = ActionBarAnimationType.UTD;
            }
        }
        if (DimensionHelper.isShowstoryNeedFullScreen()) {
            this.isFullScreen = true;
            toggleFullscreenSwitch(true);
        }
        this.needLockOrientation = true;
        lockOrientationPortrait();
        this.progressBar.setVisibility(4);
        ImageView imageView = this.imageViewClose;
        int i2 = Theme.key_rubinoBlackColor;
        imageView.setColorFilter(Theme.getColor(i2), PorterDuff.Mode.SRC_ATOP);
        this.imageViewDelete.setColorFilter(Theme.getColor(i2), PorterDuff.Mode.SRC_ATOP);
        this.imageViewSeen.setColorFilter(Theme.getColor(i2), PorterDuff.Mode.SRC_ATOP);
        FrameLayout frameLayout = this.middleToolsBackground;
        int i3 = Theme.key_windowBackgroundWhite;
        frameLayout.setBackgroundColor(Theme.getColor(i3));
        FrameLayout frameLayout2 = this.frameLayoutMiddle;
        int i4 = Theme.key_actionBarDefault;
        frameLayout2.setBackgroundColor(Theme.getColor(i4));
        this.frameLayoutTopContainer.setBackgroundColor(Theme.getColor(i4));
        this.textViewSeenCount2.setTextColor(Theme.getColor(i2));
        FrameLayout frameLayout3 = this.devider1;
        int i5 = Theme.key_rubinoGrayColor;
        frameLayout3.setBackgroundColor(Theme.getColor(i5));
        this.devider2.setBackgroundColor(Theme.getColor(i5));
        this.devider1.setAlpha(0.5f);
        this.devider2.setAlpha(0.5f);
        Theme.ThemeInfo currentTheme = Theme.getCurrentTheme();
        if (currentTheme.isDark()) {
            if (currentTheme.getName().equals("Night")) {
                this.imageViewTriangle.setImageDrawable(this.mContext.getResources().getDrawable(R.drawable.rubino_triangle_night));
            } else if (currentTheme.getName().equals("Dark")) {
                this.imageViewTriangle.setImageDrawable(this.mContext.getResources().getDrawable(R.drawable.rubino_triangle_dark));
            } else {
                this.imageViewTriangle.setImageDrawable(this.mContext.getResources().getDrawable(R.drawable.rubino_triangle_white_border_grey));
            }
        } else {
            this.imageViewTriangle.setImageDrawable(this.mContext.getResources().getDrawable(R.drawable.rubino_triangle_white_border_grey));
        }
        FrameLayout frameLayout4 = new FrameLayout(this.mContext) { // from class: ir.resaneh1.iptv.fragment.StorySeenFragment.1
            @Override // android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
                return StorySeenFragment.this.isInSeenMode;
            }
        };
        this.storyContainer = frameLayout4;
        this.frameLayoutTopContainer.addView(frameLayout4, new FrameLayout.LayoutParams((int) this.screenWidth, (int) this.screenHeight));
        this.imageViewClose.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.StorySeenFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (StorySeenFragment.this.isInSeenMode) {
                    StorySeenFragment.this.startBackAnimation();
                }
            }
        });
        this.imageViewClose.setVisibility(4);
        this.imageViewDelete.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.StorySeenFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ApplicationLoader.applicationActivity == null || StorySeenFragment.this.currentSnapPosition < 0 || StorySeenFragment.this.currentSnapPosition >= StorySeenFragment.this.storyList.size()) {
                    return;
                }
                final StoryObject storyObject = null;
                try {
                    storyObject = (StoryObject) StorySeenFragment.this.storyList.get(StorySeenFragment.this.currentSnapPosition);
                } catch (Exception unused) {
                }
                if (storyObject != null) {
                    ArrayList arrayList = new ArrayList();
                    final ArrayList arrayList2 = new ArrayList();
                    String string = LocaleController.getString(R.string.delete);
                    if (storyObject.isLocal) {
                        string = LocaleController.getString(R.string.cancelSending);
                    }
                    arrayList.add(string);
                    arrayList2.add(1);
                    AlertDialog.Builder builder = new AlertDialog.Builder(StorySeenFragment.this.mContext);
                    builder.setItems((CharSequence[]) arrayList.toArray(new CharSequence[0]), new DialogInterface.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.StorySeenFragment.3.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i6) {
                            if (((Integer) arrayList2.get(i6)).intValue() == 1) {
                                StorySeenFragment.this.getStoryController().deleteStory(storyObject, StorySeenFragment.this.type == StorySeenFragment.highlightType ? StorySeenFragment.this.getCurrentHighlightId() : null);
                            }
                        }
                    });
                    builder.create().show();
                }
            }
        });
        if (this.type == highlightType) {
            this.storyFragment = new StoryFragment(this.storyListOfAProfileObjects, this.startIndex, true);
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(getStoryController().createMyProfileStoryAndGetFromServer(true));
            this.storyFragment = new StoryFragment((ArrayList<StoryListOfAProfileObject>) arrayList, 0, this.defaultStory);
        }
        this.storyFragment.setParentLayout(this.parentLayout);
        this.storyFragment.onFragmentCreate();
        this.storyFragment.createView(this.mContext);
        this.storyFragment.setScrollListener(new StoryPresenter.ScrollListener() { // from class: ir.resaneh1.iptv.fragment.StorySeenFragment.4
            @Override // ir.resaneh1.iptv.presenters.StoryPresenter.ScrollListener
            public void onFlingUp(float f) {
            }

            @Override // ir.resaneh1.iptv.presenters.StoryPresenter.ScrollListener
            public void onScrollHorizontally(int i6) {
            }

            @Override // ir.resaneh1.iptv.presenters.StoryPresenter.ScrollListener
            public void onScrollUp(float f) {
                MyLog.e("StorySeenFragment", "onScrollUp " + f);
                if (Math.abs(f) > AndroidUtilities.dp(10.0f)) {
                    StorySeenFragment.this.switchToSeenMode();
                }
            }
        });
        this.storyFragment.setSeenListener(new StoryPresenter.SeenClickListener() { // from class: ir.resaneh1.iptv.fragment.StorySeenFragment.5
            @Override // ir.resaneh1.iptv.presenters.StoryPresenter.SeenClickListener
            public void onClick() {
                StorySeenFragment.this.switchToSeenMode();
            }
        });
        this.storyContainer.addView(this.storyFragment.fragmentView, LayoutHelper.createFrame(-1, -1, 17));
        StoryInSeenPresenter storyInSeenPresenter = new StoryInSeenPresenter(this.mContext);
        this.storyInSeenPresenter = storyInSeenPresenter;
        int i6 = (int) (this.screenHeight * 0.2f);
        storyInSeenPresenter.height = i6;
        storyInSeenPresenter.width = (int) ((i6 * 1.0f) / DimensionHelper.getStoryHWRatio());
        AddNewStoryInSeenPresenter addNewStoryInSeenPresenter = new AddNewStoryInSeenPresenter(this.mContext);
        this.storyInSeenPresenterAddNew = addNewStoryInSeenPresenter;
        StoryInSeenPresenter storyInSeenPresenter2 = this.storyInSeenPresenter;
        addNewStoryInSeenPresenter.height = storyInSeenPresenter2.height;
        addNewStoryInSeenPresenter.width = storyInSeenPresenter2.width;
        if (Build.VERSION.SDK_INT >= 17) {
            this.recyclerViewStory.setLayoutDirection(0);
        }
        this.recyclerViewStory.setLayoutManager(new CenterZoomLayoutManager(this.mContext, 0, false));
        RecyclerView recyclerView = this.recyclerViewStory;
        float f = this.screenWidth;
        double d = f;
        Double.isNaN(d);
        recyclerView.setPadding((int) (d / 2.5d), 0, (int) (f / 2.5f), 0);
        LinearSnapHelper linearSnapHelper = new LinearSnapHelper();
        this.snapHelper = linearSnapHelper;
        linearSnapHelper.attachToRecyclerView(this.recyclerViewStory);
        this.recyclerViewStory.getLayoutParams().height = (int) (this.screenHeight * 0.2f);
        ((FrameLayout.LayoutParams) this.recyclerViewStory.getLayoutParams()).setMargins(0, 0, 0, 0);
        ((FrameLayout.LayoutParams) this.recyclerViewStory.getLayoutParams()).gravity = 80;
        this.recyclerViewStory.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.resaneh1.iptv.fragment.StorySeenFragment.6
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView2, int i7, int i8) {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView2, int i7) {
                if (i7 == 0) {
                    StorySeenFragment.this.checkPageSelected();
                }
            }
        });
        new RubinoProfileRowInSeenStoryPresenter(this.mContext);
        this.listView = new RecyclerListViewEdited(this.mContext);
        this.listViewContainer.getLayoutParams().height = (int) ((this.screenHeight * 3.0f) / 4.0f);
        this.listViewContainer.addView(this.listView, LayoutHelper.createFrame(-1, -1, 48));
        this.listView.getLayoutParams().height = ((int) ((this.screenHeight * 3.0f) / 4.0f)) - AndroidUtilities.dp(24.0f);
        this.listView.setPadding(0, 0, 0, AndroidUtilities.dp(48.0f));
        this.listView.setLayoutManager(new LinearLayoutManager(this, this.mContext, i, z) { // from class: ir.resaneh1.iptv.fragment.StorySeenFragment.7
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean supportsPredictiveItemAnimations() {
                return false;
            }
        });
        this.listView.setClipToPadding(false);
        this.listView.setClipChildren(false);
        this.listView.setVerticalScrollBarEnabled(false);
        this.listView.setItemAnimator(null);
        this.listView.setLayoutAnimation(null);
        this.listView.setEmptyView(new RubinoEmptyView(this.mContext, 17));
        this.listView.setBackgroundColor(Theme.getColor(i3));
        this.listViewContainer.setBackgroundColor(Theme.getColor(i3));
        ListAdapter listAdapter = new ListAdapter(this.mContext);
        this.listAdapter = listAdapter;
        this.listView.setAdapter(listAdapter);
        getStoryController().storyViewersOutputStoryIdMap.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchToSeenMode() {
        StoryListOfAProfileObject storyListOfAProfileObjectCreateMyProfileStoryAndGetFromServer;
        ArrayList<StoryController.StoryIdObject> arrayList;
        if (this.isInSeenMode) {
            return;
        }
        if (this.type == highlightType) {
            storyListOfAProfileObjectCreateMyProfileStoryAndGetFromServer = this.storyFragment.getCurrentStoryListOfProfileObject();
        } else {
            storyListOfAProfileObjectCreateMyProfileStoryAndGetFromServer = getStoryController().createMyProfileStoryAndGetFromServer(false);
        }
        if (storyListOfAProfileObjectCreateMyProfileStoryAndGetFromServer == null || storyListOfAProfileObjectCreateMyProfileStoryAndGetFromServer.getCurrentStoryId() == null) {
            return;
        }
        StoryController.ProfileStoryInfo profileStoryInfo = storyListOfAProfileObjectCreateMyProfileStoryAndGetFromServer.info;
        if (profileStoryInfo == null || (arrayList = profileStoryInfo.storyIdsObject) == null || arrayList.size() == 0) {
            getStoryController().createMyProfileStoryAndGetFromServer(true);
        }
        if (storyListOfAProfileObjectCreateMyProfileStoryAndGetFromServer.getCurrentStoryId() == null || !storyListOfAProfileObjectCreateMyProfileStoryAndGetFromServer.getCurrentStoryId().isLocal) {
            this.isInSeenMode = true;
            startSmallAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public StoryObject getCurrentStory() {
        ArrayList<PresenterItem> arrayList = this.storyList;
        String str = (arrayList == null || this.currentSnapPosition >= arrayList.size() || !(this.storyList.get(this.currentSnapPosition) instanceof StoryObject)) ? null : ((StoryObject) this.storyList.get(this.currentSnapPosition)).id;
        if (str != null) {
            return getStoryController().getInstantStory(new StoryController.StoryIdObject(str));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkPageSelected() {
        StoryController.ProfileStoryInfo profileStoryInfo;
        ArrayList<StoryController.StoryIdObject> arrayList;
        View viewFindSnapView = this.snapHelper.findSnapView(this.recyclerViewStory.getLayoutManager());
        if (viewFindSnapView != null) {
            int position = this.recyclerViewStory.getLayoutManager().getPosition(viewFindSnapView);
            this.currentSnapPosition = position;
            if (this.isInSeenMode && this.storyFragment != null) {
                DisposableObserver disposableObserver = this.requestDisposable;
                if (disposableObserver != null) {
                    disposableObserver.dispose();
                }
                if ((this.storyList.get(this.currentSnapPosition) instanceof LoadMoreItem) || this.type == highlightType) {
                    this.hasContinue = false;
                } else {
                    this.hasContinue = true;
                }
                this.profileArray.clear();
                updateRows();
                this.textViewSeenCount2.setText(BuildConfig.FLAVOR);
                if (this.storyList.get(this.currentSnapPosition) instanceof LoadMoreItem) {
                    this.imageViewDelete.setVisibility(8);
                    this.imageViewSeen.setVisibility(8);
                    return;
                }
                this.imageViewDelete.setVisibility(0);
                this.imageViewSeen.setVisibility(0);
                StoryListOfAProfileObject storyListOfAProfileObjectCreateMyProfileStoryAndGetFromServer = getStoryController().createMyProfileStoryAndGetFromServer(false);
                if (storyListOfAProfileObjectCreateMyProfileStoryAndGetFromServer == null || (profileStoryInfo = storyListOfAProfileObjectCreateMyProfileStoryAndGetFromServer.info) == null || (arrayList = profileStoryInfo.storyIdsObject) == null || position >= arrayList.size() || position < 0) {
                    return;
                }
                this.storyFragment.setMyStoryCurrentIndex(new StoryController.StoryIdObject(((StoryObject) this.storyList.get(position)).id));
                StoryObject storyObject = storyListOfAProfileObjectCreateMyProfileStoryAndGetFromServer.info.storyIdsObject.get(position).storyAbsObject;
                if (storyObject == null) {
                    return;
                }
                GetStoryViewersOutput viewersOutputStoryIdMap = getStoryController().getViewersOutputStoryIdMap(storyObject.id);
                if (viewersOutputStoryIdMap == null) {
                    this.hasContinue = this.type != highlightType;
                    this.startId = null;
                } else {
                    this.hasContinue = viewersOutputStoryIdMap.has_continue;
                    this.startId = viewersOutputStoryIdMap.next_start_id;
                    this.profileArray.addAll(viewersOutputStoryIdMap.viewers);
                }
                this.textViewSeenCount2.setText(storyObject.getSeenCountString());
                updateRows();
            }
        }
    }

    private void updateStoryList() {
        if (this.storyAdapter != null) {
            this.storyList.clear();
            this.storyAdapter.notifyDataSetChanged();
            this.storyList.addAll(getCurrentStoryList());
            if (hasLoadMore()) {
                this.storyList.add(new LoadMoreItem(new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.fragment.StorySeenFragment.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                    }
                }, LoadMoreItem.LoadMoreType.moreIcon));
            }
            this.storyAdapter.notifyDataSetChanged();
        }
    }

    private boolean hasLoadMore() {
        return this.type != highlightType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getCurrentHighlightId() {
        if (this.type == highlightType) {
            return this.storyFragment.getCurrentStoryListOfProfileObject().highlightId;
        }
        return null;
    }

    private ArrayList<StoryObject> getCurrentStoryList() {
        if (this.type == highlightType) {
            return getStoryController().getHighlightStoryAbsObjectTryFromMap(getCurrentHighlightId());
        }
        return getStoryController().getMyStoryAbsObjectTryFromMap();
    }

    private void startSmallAnimation() {
        if (this.storyAdapter == null) {
            ArrayList<PresenterItem> arrayList = new ArrayList<>();
            this.storyList = arrayList;
            arrayList.addAll(getCurrentStoryList());
            this.storyAdapter = new MainAdapter(this.mContext, this.storyList, new PresenterSelector() { // from class: ir.resaneh1.iptv.fragment.StorySeenFragment.9
                @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterSelector
                public AbstractPresenter getPresenter(PresenterItemType presenterItemType) {
                    if (presenterItemType == PresenterItemType.storyObject) {
                        return StorySeenFragment.this.storyInSeenPresenter;
                    }
                    if (presenterItemType == PresenterItemType.loadMore) {
                        return StorySeenFragment.this.storyInSeenPresenterAddNew;
                    }
                    return MainPresenterSelector.getInstance(StorySeenFragment.this.mContext).getPresenter(presenterItemType);
                }
            }, new OnPresenterItemClickListener() { // from class: ir.resaneh1.iptv.fragment.StorySeenFragment.10
                @Override // ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener
                public void onClick(AbstractPresenter.AbstractViewHolder abstractViewHolder) {
                    try {
                        if (StorySeenFragment.this.currentSnapPosition == abstractViewHolder.getAdapterPosition()) {
                            if (StorySeenFragment.this.isInSeenMode) {
                                if (StorySeenFragment.this.storyList == null || (StorySeenFragment.this.storyList.get(StorySeenFragment.this.currentSnapPosition) instanceof LoadMoreItem)) {
                                    if (StorySeenFragment.this.storyList != null && (StorySeenFragment.this.storyList.get(StorySeenFragment.this.currentSnapPosition) instanceof LoadMoreItem)) {
                                        StorySeenFragment.this.presentFragment(new StoryCameraAndGalleryFragment());
                                    }
                                } else {
                                    StorySeenFragment.this.startBackAnimation();
                                }
                            }
                        } else {
                            StorySeenFragment.this.recyclerViewStory.smoothScrollToPosition(abstractViewHolder.getAdapterPosition());
                        }
                    } catch (Exception unused) {
                    }
                }
            }, null);
            if (hasLoadMore()) {
                this.storyList.add(new LoadMoreItem(new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.fragment.StorySeenFragment.11
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                    }
                }, LoadMoreItem.LoadMoreType.moreIcon));
            }
            this.recyclerViewStory.setAdapter(this.storyAdapter);
            try {
                this.recyclerViewStory.getLayoutManager().scrollToPosition(0);
            } catch (Exception unused) {
            }
            this.needToScrollFirstTime = true;
            this.recyclerViewStory.scrollToPosition(0);
            this.recyclerViewStory.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: ir.resaneh1.iptv.fragment.StorySeenFragment.12
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (StorySeenFragment.this.needToScrollFirstTime) {
                        StorySeenFragment.this.needToScrollFirstTime = false;
                        if (StorySeenFragment.this.storyFragment.getMyStoryCurrentIndex() == ((CenterZoomLayoutManager) StorySeenFragment.this.recyclerViewStory.getLayoutManager()).findFirstCompletelyVisibleItemPosition()) {
                            StorySeenFragment.this.recyclerViewStory.getLayoutManager().scrollHorizontallyBy(0, null, null);
                            StorySeenFragment.this.checkPageSelected();
                        }
                    }
                }
            });
        } else {
            updateStoryList();
        }
        if (this.scaleToBackAnimation == null && this.scaleToSmallAnimation == null) {
            this.scaleToSmallAnimation = new AnimatorSet();
            this.storyContainer.setPivotY(r0.getHeight());
            this.storyContainer.setPivotX(this.screenWidth / 2.0f);
            this.scaleToSmallAnimation.playTogether(ObjectAnimator.ofFloat(this.storyContainer, "scaleX", 0.2f), ObjectAnimator.ofFloat(this.storyContainer, "scaleY", 0.2f), ObjectAnimator.ofFloat(this.frameLayoutTopContainer, "translationY", ((-this.screenHeight) * 3.0f) / 4.0f), ObjectAnimator.ofFloat(this.listViewContainer, "translationY", ((-this.screenHeight) * 3.0f) / 4.0f), ObjectAnimator.ofFloat(this.frameLayoutMiddle, "translationY", ((-this.screenHeight) * 3.0f) / 4.0f));
            this.scaleToSmallAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.resaneh1.iptv.fragment.StorySeenFragment.13
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    if (StorySeenFragment.this.storyFragment != null) {
                        StorySeenFragment.this.storyFragment.stopProgressAndSetPreview();
                        StorySeenFragment.this.storyFragment.onPause();
                        StorySeenFragment.this.lockOrientationPortrait();
                    }
                    StorySeenFragment.this.imageViewClose.setVisibility(0);
                    StorySeenFragment.this.needToScrollFirstTime = true;
                    int myStoryCurrentIndex = StorySeenFragment.this.storyFragment.getMyStoryCurrentIndex();
                    if (myStoryCurrentIndex < 0 || myStoryCurrentIndex >= StorySeenFragment.this.storyAdapter.getItemCount()) {
                        StorySeenFragment.this.recyclerViewStory.smoothScrollToPosition(0);
                        StorySeenFragment.this.currentSnapPosition = 0;
                    } else {
                        StorySeenFragment.this.recyclerViewStory.getLayoutManager().smoothScrollToPosition(StorySeenFragment.this.recyclerViewStory, null, myStoryCurrentIndex);
                        StorySeenFragment.this.currentSnapPosition = myStoryCurrentIndex;
                    }
                    if (myStoryCurrentIndex == ((CenterZoomLayoutManager) StorySeenFragment.this.recyclerViewStory.getLayoutManager()).findFirstCompletelyVisibleItemPosition()) {
                        StorySeenFragment.this.checkPageSelected();
                    }
                    super.onAnimationStart(animator);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (StorySeenFragment.this.scaleToSmallAnimation != null && StorySeenFragment.this.scaleToSmallAnimation.equals(animator)) {
                        StorySeenFragment.this.scaleToSmallAnimation = null;
                    }
                    StorySeenFragment.this.storyFragment.fragmentView.setVisibility(8);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    if (StorySeenFragment.this.scaleToSmallAnimation != null && StorySeenFragment.this.scaleToSmallAnimation.equals(animator)) {
                        StorySeenFragment.this.scaleToSmallAnimation = null;
                    }
                    super.onAnimationCancel(animator);
                }
            });
            this.scaleToSmallAnimation.setDuration(300L);
            this.scaleToSmallAnimation.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startBackAnimation() {
        if (this.scaleToSmallAnimation == null && this.scaleToBackAnimation == null) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.scaleToBackAnimation = animatorSet;
            animatorSet.playTogether(ObjectAnimator.ofFloat(this.storyContainer, "scaleX", 1.0f), ObjectAnimator.ofFloat(this.storyContainer, "scaleY", 1.0f), ObjectAnimator.ofFloat(this.frameLayoutTopContainer, "translationY", 0.0f), ObjectAnimator.ofFloat(this.listViewContainer, "translationY", 0.0f), ObjectAnimator.ofFloat(this.frameLayoutMiddle, "translationY", 0.0f));
            this.scaleToBackAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.resaneh1.iptv.fragment.StorySeenFragment.14
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    StorySeenFragment.this.imageViewClose.setVisibility(8);
                    if (StorySeenFragment.this.storyFragment != null) {
                        StorySeenFragment.this.storyFragment.resumeProgressAndSetPreview();
                        StorySeenFragment.this.storyFragment.onResume();
                        StorySeenFragment.this.storyFragment.fragmentView.setVisibility(0);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (StorySeenFragment.this.scaleToBackAnimation != null && StorySeenFragment.this.scaleToBackAnimation.equals(animator)) {
                        StorySeenFragment.this.scaleToBackAnimation = null;
                    }
                    StorySeenFragment.this.isInSeenMode = false;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    if (StorySeenFragment.this.scaleToBackAnimation != null && StorySeenFragment.this.scaleToBackAnimation.equals(animator)) {
                        StorySeenFragment.this.scaleToBackAnimation = null;
                    }
                    super.onAnimationCancel(animator);
                }
            });
            this.scaleToBackAnimation.setDuration(300L);
            this.scaleToBackAnimation.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadViewers(final StoryObject storyObject) {
        if (this.type == highlightType || storyObject == null || !this.hasContinue) {
            return;
        }
        DisposableObserver disposableObserver = this.requestDisposable;
        if (disposableObserver != null) {
            disposableObserver.dispose();
        }
        final GetStoryViewersInput getStoryViewersInput = new GetStoryViewersInput(storyObject.profile_id, storyObject.id, this.startId, 50);
        DisposableObserver disposableObserver2 = (DisposableObserver) getApiRequestMessangerRx().getStoryViewers(getStoryViewersInput).observeOn(Schedulers.computation()).doOnNext(new Consumer<MessangerOutput<GetStoryViewersOutput>>(this) { // from class: ir.resaneh1.iptv.fragment.StorySeenFragment.16
            @Override // io.reactivex.functions.Consumer
            public void accept(MessangerOutput<GetStoryViewersOutput> messangerOutput) throws Exception {
                GetStoryViewersOutput getStoryViewersOutput = messangerOutput.data;
                if (getStoryViewersOutput == null || getStoryViewersOutput.viewers == null) {
                    return;
                }
                Iterator<RubinoProfileObject> it = getStoryViewersOutput.viewers.iterator();
                while (it.hasNext()) {
                    RubinoProfileObject next = it.next();
                    String str = next.username;
                    next.username = str != null ? str.toLowerCase() : null;
                    next.createUsernameSpan();
                }
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<MessangerOutput<GetStoryViewersOutput>>() { // from class: ir.resaneh1.iptv.fragment.StorySeenFragment.15
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput<GetStoryViewersOutput> messangerOutput) {
                if (messangerOutput == null || messangerOutput.data == null) {
                    return;
                }
                StorySeenFragment.this.profileArray.addAll(messangerOutput.data.viewers);
                StorySeenFragment.this.startId = messangerOutput.data.next_start_id;
                StorySeenFragment.this.hasContinue = messangerOutput.data.has_continue;
                StorySeenFragment.this.updateRows();
                GetStoryViewersOutput viewersOutputStoryIdMap = StorySeenFragment.this.getStoryController().getViewersOutputStoryIdMap(storyObject.id);
                if (viewersOutputStoryIdMap == null) {
                    StorySeenFragment.this.getStoryController().addStoryViewersOutputMap(storyObject.id, messangerOutput.data);
                } else {
                    GetStoryViewersOutput getStoryViewersOutput = messangerOutput.data;
                    viewersOutputStoryIdMap.next_start_id = getStoryViewersOutput.next_start_id;
                    viewersOutputStoryIdMap.has_continue = getStoryViewersOutput.has_continue;
                    if (viewersOutputStoryIdMap.viewers == null) {
                        viewersOutputStoryIdMap.viewers = new ArrayList<>();
                    }
                    String str = getStoryViewersInput.start_id;
                    if (str == null || str.isEmpty()) {
                        viewersOutputStoryIdMap.viewers.clear();
                    }
                    GetStoryViewersOutput getStoryViewersOutput2 = messangerOutput.data;
                    if (getStoryViewersOutput2.viewers != null) {
                        viewersOutputStoryIdMap.viewers.addAll(getStoryViewersOutput2.viewers);
                    }
                }
                GetStoryViewersOutput viewersOutputStoryIdMap2 = StorySeenFragment.this.getStoryController().getViewersOutputStoryIdMap(storyObject.id);
                if (viewersOutputStoryIdMap2 != null) {
                    StorySeenFragment.this.getStoryController().updateSeenCount(storyObject.id, viewersOutputStoryIdMap2.viewers.size(), true);
                }
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                ((PresenterFragment) StorySeenFragment.this).isStopLoading = true;
                StorySeenFragment.this.setLoadMoreItemLoading(false);
            }
        });
        this.requestDisposable = disposableObserver2;
        ((PresenterFragment) this).compositeDisposable.add(disposableObserver2);
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        toggleFullscreenSwitch(this.isFullScreen);
        StoryFragment storyFragment = this.storyFragment;
        if (storyFragment == null || this.isInSeenMode) {
            return;
        }
        storyFragment.onResume();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onPause() {
        StoryFragment storyFragment = this.storyFragment;
        if (storyFragment != null) {
            storyFragment.onPause();
        }
        super.onPause();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    public void onLoadMoreItemClicked() {
        this.isStopLoading = false;
        loadViewers((StoryObject) this.storyList.get(this.currentSnapPosition));
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public boolean onBackPressed() {
        if (this.isInSeenMode) {
            startBackAnimation();
            return false;
        }
        getStoryController().storyViewersOutputStoryIdMap.clear();
        StoryFragment storyFragment = this.storyFragment;
        if (storyFragment != null) {
            storyFragment.onBackPressed();
        }
        return super.onBackPressed();
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        StoryFragment storyFragment;
        StoryObject storyObject;
        if (i == NotificationCenter.myStoryDeleted) {
            StoryObject storyObject2 = (StoryObject) objArr[0];
            if (storyObject2.profile_id == null || !AppRubinoPreferences.getInstance(this.currentAccount).getInstaCurrentProfileObject().id.equals(storyObject2.profile_id)) {
                return;
            }
            ArrayList<StoryObject> currentStoryList = getCurrentStoryList();
            if (currentStoryList.size() > 0) {
                if (this.storyList == null) {
                    this.storyList = new ArrayList<>();
                }
                this.storyList.clear();
                this.storyList.addAll(currentStoryList);
                MainAdapter mainAdapter = this.storyAdapter;
                if (mainAdapter != null) {
                    mainAdapter.notifyDataSetChanged();
                }
                if (this.currentSnapPosition > this.storyList.size() - 1) {
                    this.currentSnapPosition = this.storyList.size() - 1;
                }
                try {
                    this.recyclerViewStory.smoothScrollToPosition(this.currentSnapPosition);
                    return;
                } catch (Exception unused) {
                    this.recyclerViewStory.smoothScrollToPosition(0);
                    return;
                }
            }
            finishFragment();
            return;
        }
        if (i == NotificationCenter.myStoryAdded) {
            StoryObject storyObject3 = (StoryObject) objArr[0];
            if (storyObject3.profile_id == null || !AppRubinoPreferences.getInstance(this.currentAccount).getInstaCurrentProfileObject().id.equals(storyObject3.profile_id)) {
                return;
            }
            updateStoryList();
            return;
        }
        if (i == NotificationCenter.storySeenCountChange) {
            if (this.isInSeenMode) {
                MainAdapter mainAdapter2 = this.storyAdapter;
                if (mainAdapter2 != null) {
                    mainAdapter2.notifyDataSetChanged();
                }
                int i3 = this.currentSnapPosition;
                if (i3 < 0 || i3 >= this.storyList.size() || !(this.storyList.get(this.currentSnapPosition) instanceof StoryObject) || (storyObject = (StoryObject) this.storyList.get(this.currentSnapPosition)) == null) {
                    return;
                }
                this.textViewSeenCount2.setText(storyObject.getSeenCountString());
                return;
            }
            return;
        }
        if (i == NotificationCenter.storyObjectDidLoad) {
            StoryFragment storyFragment2 = this.storyFragment;
            if (storyFragment2 != null) {
                storyFragment2.didReceivedNotification(i, i2, objArr);
                return;
            }
            return;
        }
        if (i != NotificationCenter.highlightStoryIdsDidLoad || (storyFragment = this.storyFragment) == null) {
            return;
        }
        storyFragment.didReceivedNotification(i, i2, objArr);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        getNotificationCenter().addObserver(this, NotificationCenter.myStoryDeleted);
        getNotificationCenter().addObserver(this, NotificationCenter.myStoryAdded);
        getNotificationCenter().addObserver(this, NotificationCenter.storySeenCountChange);
        getNotificationCenter().addObserver(this, NotificationCenter.storyObjectDidLoad);
        if (this.type == highlightType) {
            getNotificationCenter().addObserver(this, NotificationCenter.highlightStoryIdsDidLoad);
        }
        return super.onFragmentCreate();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        StoryFragment storyFragment = this.storyFragment;
        if (storyFragment != null) {
            storyFragment.onFragmentDestroy();
        }
        getNotificationCenter().removeObserver(this, NotificationCenter.myStoryDeleted);
        getNotificationCenter().removeObserver(this, NotificationCenter.myStoryAdded);
        getNotificationCenter().removeObserver(this, NotificationCenter.storySeenCountChange);
        getNotificationCenter().removeObserver(this, NotificationCenter.storyObjectDidLoad);
        if (this.type == highlightType) {
            getNotificationCenter().removeObserver(this, NotificationCenter.highlightStoryIdsDidLoad);
        }
        super.onFragmentDestroy();
    }

    void updateRows() {
        this.viewerArrayStartRow = -1;
        this.pollRow = -1;
        this.emojiSliderRow = -1;
        this.viewerArrayEndRow = -1;
        this.loadingRow = -1;
        this.loadMorePosition = Math.max(0, this.profileArray.size() - 15);
        this.rowCount = 0;
        if (this.needToRetry) {
            this.rowCount = 0 + 1;
            this.loadMorePosition = -1;
        } else {
            StoryObject currentStory = getCurrentStory();
            if (currentStory != null) {
                if (currentStory.getPollIfExist() != null) {
                    int i = this.rowCount;
                    this.rowCount = i + 1;
                    this.pollRow = i;
                }
                if (currentStory.getEmojiSliderIfExist() != null) {
                    int i2 = this.rowCount;
                    this.rowCount = i2 + 1;
                    this.emojiSliderRow = i2;
                }
            }
            if (this.profileArray.size() > 0) {
                int i3 = this.rowCount;
                this.viewerArrayStartRow = i3;
                int size = i3 + this.profileArray.size();
                this.rowCount = size;
                this.viewerArrayEndRow = size;
            }
            if (this.hasContinue) {
                int i4 = this.rowCount;
                this.rowCount = i4 + 1;
                this.loadingRow = i4;
            }
        }
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    class ListAdapter extends RecyclerListViewEdited.SelectionAdapter {
        Context mContext;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return viewHolder.itemView instanceof RubinoRetryView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return StorySeenFragment.this.rowCount;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            FrameLayout frameLayout;
            FrameLayout rubinoLoadingCell;
            if (i == 0) {
                FrameLayout profileInSeenStoryCell = new ProfileInSeenStoryCell(this.mContext);
                profileInSeenStoryCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
                frameLayout = profileInSeenStoryCell;
            } else if (i == 2) {
                RubinoPollResultCell rubinoPollResultCell = new RubinoPollResultCell(this.mContext);
                rubinoPollResultCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
                rubinoPollResultCell.setOnShareClick(new RubinoPollResultCell.OnShareClickListener() { // from class: ir.resaneh1.iptv.fragment.StorySeenFragment.ListAdapter.1
                    @Override // ir.resaneh1.iptv.fragment.rubino.RubinoPollResultCell.OnShareClickListener
                    public void onShareClick(StoryObject storyObject) {
                        StorySeenFragment.this.sharePoll(storyObject);
                    }
                });
                frameLayout = rubinoPollResultCell;
            } else if (i == 3) {
                FrameLayout rubinoEmojiSliderResultCell = new RubinoEmojiSliderResultCell(this.mContext);
                rubinoEmojiSliderResultCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
                frameLayout = rubinoEmojiSliderResultCell;
            } else {
                rubinoLoadingCell = new RubinoLoadingCell(this.mContext, false);
                return new RecyclerListViewEdited.Holder(rubinoLoadingCell);
            }
            rubinoLoadingCell = frameLayout;
            return new RecyclerListViewEdited.Holder(rubinoLoadingCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            MyLog.e("List Status", "onBind: " + viewHolder.getAdapterPosition());
            int itemViewType = viewHolder.getItemViewType();
            if (itemViewType == 0) {
                ProfileInSeenStoryCell profileInSeenStoryCell = (ProfileInSeenStoryCell) viewHolder.itemView;
                if (i >= StorySeenFragment.this.viewerArrayStartRow && i < StorySeenFragment.this.viewerArrayEndRow) {
                    RubinoProfileObject rubinoProfileObject = (RubinoProfileObject) StorySeenFragment.this.profileArray.get(i - StorySeenFragment.this.viewerArrayStartRow);
                    RubinoProfileObject rubinoProfileObject2 = StorySeenFragment.this.getRubinoController().profileMap.get(rubinoProfileObject.id);
                    if (rubinoProfileObject2 != null) {
                        profileInSeenStoryCell.setProfile(rubinoProfileObject2, ((BaseFragment) StorySeenFragment.this).classGuid);
                    } else {
                        profileInSeenStoryCell.setProfile(rubinoProfileObject, ((BaseFragment) StorySeenFragment.this).classGuid);
                    }
                }
            } else if (itemViewType == 2) {
                RubinoPollResultCell rubinoPollResultCell = (RubinoPollResultCell) viewHolder.itemView;
                StoryObject currentStory = StorySeenFragment.this.getCurrentStory();
                if (currentStory != null && currentStory.getPollIfExist() != null) {
                    rubinoPollResultCell.setData(currentStory);
                }
            } else if (itemViewType == 3) {
                RubinoEmojiSliderResultCell rubinoEmojiSliderResultCell = (RubinoEmojiSliderResultCell) viewHolder.itemView;
                StoryObject currentStory2 = StorySeenFragment.this.getCurrentStory();
                if (currentStory2 != null) {
                    rubinoEmojiSliderResultCell.setData(currentStory2);
                }
            }
            if (StorySeenFragment.this.hasContinue) {
                if ((i == StorySeenFragment.this.loadMorePosition || i == StorySeenFragment.this.loadingRow) && (StorySeenFragment.this.storyList.get(StorySeenFragment.this.currentSnapPosition) instanceof StoryObject)) {
                    StorySeenFragment storySeenFragment = StorySeenFragment.this;
                    storySeenFragment.loadViewers((StoryObject) storySeenFragment.storyList.get(StorySeenFragment.this.currentSnapPosition));
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i >= StorySeenFragment.this.viewerArrayStartRow && i < StorySeenFragment.this.viewerArrayEndRow) {
                return 0;
            }
            if (i == StorySeenFragment.this.loadingRow) {
                return 1;
            }
            if (i == StorySeenFragment.this.pollRow) {
                return 2;
            }
            return i == StorySeenFragment.this.emojiSliderRow ? 3 : 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
            super.onViewDetachedFromWindow(viewHolder);
            MyLog.e("List Status", "detached: " + viewHolder.getAdapterPosition());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
            super.onViewAttachedToWindow(viewHolder);
            MyLog.e("List Status", "attached: " + viewHolder.getAdapterPosition());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sharePoll(final StoryObject storyObject) {
        if (storyObject == null || storyObject.pollWidget == null) {
            return;
        }
        String str = null;
        StoryObject.StoryTypeEnum storyTypeEnum = storyObject.story_type;
        if (storyTypeEnum == StoryObject.StoryTypeEnum.Video) {
            str = storyObject.full_snapshot_url;
        } else if (storyTypeEnum == StoryObject.StoryTypeEnum.Picture) {
            str = storyObject.full_file_url;
        }
        if (str == null) {
            return;
        }
        final LoadingDialog loadingDialog = new LoadingDialog(ApplicationLoader.applicationActivity);
        Glide.with(this.mContext).asBitmap().apply((BaseRequestOptions<?>) new RequestOptions()).load(str).into((RequestBuilder<Bitmap>) new SimpleTarget<Bitmap>() { // from class: ir.resaneh1.iptv.fragment.StorySeenFragment.17
            @Override // com.bumptech.glide.request.target.Target
            public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) throws IOException {
                onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
            }

            public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) throws IOException {
                loadingDialog.dismiss();
                if (bitmap == null) {
                    return;
                }
                String path = null;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 90, byteArrayOutputStream);
                File file = new File(StorageHelper.getTempDirectory(ApplicationLoader.applicationContext), "Compressed_Image_" + System.currentTimeMillis() + AndroidUtilities.getNextRnd() + ".jpg");
                try {
                    file.createNewFile();
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    fileOutputStream.write(byteArrayOutputStream.toByteArray());
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    path = file.getPath();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (path != null) {
                    StorySeenFragment storySeenFragment = StorySeenFragment.this;
                    StoryObject storyObject2 = storyObject;
                    storySeenFragment.presentFragment(new AddStoryFragment(path, false, storyObject2.pollWidget, storyObject2.w_h_ratio));
                }
            }

            @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
            public void onLoadFailed(Drawable drawable) {
                loadingDialog.dismiss();
                super.onLoadFailed(drawable);
            }
        });
    }
}
