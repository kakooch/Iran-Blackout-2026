package ir.resaneh1.iptv.fragment;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.fragment.StoryGalleryFragment;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.helper.StoryCameraGalleryContainerFrameLayout;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.GalleryResultObject;
import ir.resaneh1.iptv.model.RubinoGalleryObject;
import ir.resaneh1.iptv.model.TitleObject;
import ir.resaneh1.iptv.model.WidgetStoryObject;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.ImageReceiver;

/* loaded from: classes3.dex */
public class StoryCameraAndGalleryFragment extends PresenterFragment {
    private StoryCameraGalleryContainerFrameLayout containerFrameLayout;
    private int currentSnapPosition;
    private float downXValue;
    private float downYValue;
    public boolean initTypeLive;
    private WidgetStoryObject initWidget;
    private boolean isCameraPause;
    private boolean isDown;
    private boolean isUp;
    LinearLayout linearLayoutContainer;
    private DisposableObserver scrollIdleDisposable;
    private SnapHelper snapHelper;
    private StoryCameraFragment storyCameraFragment;
    private StoryGalleryFragment storyGalleryFragment;

    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.story_camera_and_gallery_fragment;
    }

    public StoryCameraAndGalleryFragment() {
        initFragmentParams();
    }

    private void initFragmentParams() {
        if (DimensionHelper.isShowstoryNeedFullScreen()) {
            this.isFullScreen = true;
        }
        this.isForceBlackTheme = true;
        this.needLockOrientation = true;
        this.fragmentName = "StoryCameraAndGalleryFragment";
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        ((Activity) context).getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: ir.resaneh1.iptv.fragment.StoryCameraAndGalleryFragment.1
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public void onSystemUiVisibilityChange(int i) {
                if ((i & 4) == 0) {
                    if (ApplicationLoader.applicationActivity.getLastFragment() instanceof StoryCameraAndGalleryFragment) {
                        StoryCameraAndGalleryFragment storyCameraAndGalleryFragment = StoryCameraAndGalleryFragment.this;
                        CompositeDisposable compositeDisposable = ((PresenterFragment) storyCameraAndGalleryFragment).compositeDisposable;
                        if (compositeDisposable == null || storyCameraAndGalleryFragment.isPaused) {
                            return;
                        }
                        compositeDisposable.add((Disposable) Observable.timer(150L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Long>() { // from class: ir.resaneh1.iptv.fragment.StoryCameraAndGalleryFragment.1.1
                            @Override // io.reactivex.Observer
                            public void onComplete() {
                            }

                            @Override // io.reactivex.Observer
                            public void onError(Throwable th) {
                            }

                            @Override // io.reactivex.Observer
                            public void onNext(Long l) {
                                if (DimensionHelper.isShowstoryNeedFullScreen()) {
                                    StoryCameraAndGalleryFragment.this.toggleFullscreenSwitch(true);
                                }
                                StoryCameraAndGalleryFragment.this.lockOrientationPortrait();
                            }
                        }));
                        return;
                    }
                    return;
                }
                MyLog.e("StoryCameraAndGalleryFragment", "onSystemUiVisibilityChange 2");
            }
        });
        return super.createView(context);
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void findView() {
        super.findView();
        this.linearLayoutContainer = (LinearLayout) findViewById(R.id.linearLayoutContainer);
        this.containerFrameLayout = (StoryCameraGalleryContainerFrameLayout) findViewById(R.id.containerFrameLayout);
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void init() throws IllegalStateException {
        super.init();
        this.progressBar.setVisibility(4);
        if (DimensionHelper.isShowstoryNeedFullScreen()) {
            toggleFullscreenSwitch(true);
        }
        this.needLockOrientation = true;
        lockOrientationPortrait();
        getFragmentView().setBackgroundColor(this.mContext.getResources().getColor(R.color.black));
        this.swipeBackEnabled = false;
        CustomLinearLayoutManager customLinearLayoutManager = new CustomLinearLayoutManager(this.mContext, 1, false);
        this.linearLayoutManager = customLinearLayoutManager;
        this.mainRecyclerView.setLayoutManager(customLinearLayoutManager);
        this.mainRecyclerView.setAdapter(new CustomAdapter());
        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        this.snapHelper = pagerSnapHelper;
        pagerSnapHelper.attachToRecyclerView(this.mainRecyclerView);
        this.mainRecyclerView.setPadding(0, 0, 0, 0);
        if (this.initWidget != null) {
            this.storyCameraFragment = new StoryCameraFragment(this.initWidget);
        } else {
            this.storyCameraFragment = new StoryCameraFragment();
        }
        StoryCameraFragment storyCameraFragment = this.storyCameraFragment;
        storyCameraFragment.initTypeLive = this.initTypeLive;
        storyCameraFragment.setParentLayout(this.parentLayout);
        this.storyCameraFragment.createView(this.mContext);
        this.storyCameraFragment.setLeftBottomImage(BuildConfig.FLAVOR, new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.StoryCameraAndGalleryFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                StoryCameraAndGalleryFragment.this.openGallery();
            }
        });
        this.storyCameraFragment.onResume();
        ((PresenterFragment) this).compositeDisposable.add((Disposable) StoryGalleryFragment.GalleryHelper.queryAndParseGalleryObject(true, true).subscribeWith(new DisposableObserver<GalleryResultObject>() { // from class: ir.resaneh1.iptv.fragment.StoryCameraAndGalleryFragment.3
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onNext(GalleryResultObject galleryResultObject) {
                ArrayList<RubinoGalleryObject> arrayList = galleryResultObject.galleryObjectArray;
                if (arrayList == null || arrayList.size() <= 0) {
                    return;
                }
                StoryCameraAndGalleryFragment.this.storyCameraFragment.setLeftBottomImage(galleryResultObject.galleryObjectArray.get(0).path, new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.StoryCameraAndGalleryFragment.3.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        StoryCameraAndGalleryFragment.this.openGallery();
                    }
                });
            }
        }));
        this.linearLayoutContainer.addView(this.storyCameraFragment.fragmentView, new FrameLayout.LayoutParams(DimensionHelper.getScreenMinDimension((Activity) this.mContext), DimensionHelper.getScreenMaxDimension((Activity) this.mContext) - DimensionHelper.getScreenStatusBarHeightIfNoCutoutAndNoNeedFullScreen()));
        StoryGalleryFragment storyGalleryFragment = new StoryGalleryFragment();
        this.storyGalleryFragment = storyGalleryFragment;
        storyGalleryFragment.setParentLayout(this.parentLayout);
        this.storyGalleryFragment.setOnGalleryListener(new StoryGalleryFragment.OnGalleryListener() { // from class: ir.resaneh1.iptv.fragment.StoryCameraAndGalleryFragment.4
            @Override // ir.resaneh1.iptv.fragment.StoryGalleryFragment.OnGalleryListener
            public void onGalleryLoaded(ArrayList<RubinoGalleryObject> arrayList) {
                if (StoryCameraAndGalleryFragment.this.storyCameraFragment == null || arrayList.size() <= 0) {
                    return;
                }
                StoryCameraAndGalleryFragment.this.storyCameraFragment.setLeftBottomImage(arrayList.get(0).path, new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.StoryCameraAndGalleryFragment.4.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        StoryCameraAndGalleryFragment.this.openGallery();
                    }
                });
            }

            @Override // ir.resaneh1.iptv.fragment.StoryGalleryFragment.OnGalleryListener
            public void onSelectItem(RubinoGalleryObject rubinoGalleryObject) {
                if (StoryCameraAndGalleryFragment.this.mainRecyclerView.getScrollState() == 0) {
                    StoryCameraAndGalleryFragment.this.nextStep(rubinoGalleryObject);
                }
            }
        });
        this.storyGalleryFragment.createView(this.mContext);
        this.storyGalleryFragment.mainRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() { // from class: ir.resaneh1.iptv.fragment.StoryCameraAndGalleryFragment.5
            @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public void onRequestDisallowInterceptTouchEvent(boolean z) {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                Log.e(BuildConfig.FLAVOR, "StoryCameraAndGalleryFragment1 action= " + motionEvent.getAction());
                if (action == 0) {
                    StoryCameraAndGalleryFragment.this.downXValue = motionEvent.getX();
                    StoryCameraAndGalleryFragment.this.downYValue = motionEvent.getY();
                    StoryCameraAndGalleryFragment.this.containerFrameLayout.setScrollEnable(false);
                    MyLog.e(BuildConfig.FLAVOR, "StoryCameraAndGalleryFragment1 down= " + StoryCameraAndGalleryFragment.this.downYValue);
                } else if (action == 2) {
                    MyLog.e(BuildConfig.FLAVOR, "StoryCameraAndGalleryFragment1 move");
                    motionEvent.getX();
                    float y = motionEvent.getY();
                    if (y == StoryCameraAndGalleryFragment.this.downYValue) {
                        return false;
                    }
                    StoryCameraAndGalleryFragment.this.isUp = false;
                    StoryCameraAndGalleryFragment.this.isDown = false;
                    boolean z = true;
                    if (StoryCameraAndGalleryFragment.this.downYValue < y) {
                        MyLog.e("StoryCameraAndGalleryFragment", "down");
                        StoryCameraAndGalleryFragment.this.isDown = true;
                    }
                    if (StoryCameraAndGalleryFragment.this.downYValue > y) {
                        MyLog.e("StoryCameraAndGalleryFragment", "up");
                        StoryCameraAndGalleryFragment.this.isUp = true;
                    }
                    MyLog.e("StoryCameraAndGalleryFragment", " canScroll 1" + StoryCameraAndGalleryFragment.this.storyGalleryFragment.mainRecyclerView.canScrollVertically(1) + " " + StoryCameraAndGalleryFragment.this.isUp);
                    MyLog.e("StoryCameraAndGalleryFragment", " canScroll -1" + StoryCameraAndGalleryFragment.this.storyGalleryFragment.mainRecyclerView.canScrollVertically(-1) + " " + StoryCameraAndGalleryFragment.this.isDown);
                    if ((StoryCameraAndGalleryFragment.this.storyGalleryFragment.mainRecyclerView.canScrollVertically(1) && StoryCameraAndGalleryFragment.this.isUp) || (StoryCameraAndGalleryFragment.this.storyGalleryFragment.mainRecyclerView.canScrollVertically(-1) && StoryCameraAndGalleryFragment.this.isDown)) {
                        recyclerView.getParent().requestDisallowInterceptTouchEvent(true);
                        z = false;
                    }
                    if (StoryCameraAndGalleryFragment.this.storyCameraFragment != null) {
                        StoryCameraAndGalleryFragment.this.containerFrameLayout.setScrollEnable(z);
                        MyLog.e("StoryCameraAndGalleryFragment", " isLockScrollBecauseOfCamera " + z);
                    }
                }
                return false;
            }
        });
        this.linearLayoutContainer.addView(this.storyGalleryFragment.fragmentView, new FrameLayout.LayoutParams(DimensionHelper.getScreenMinDimension((Activity) this.mContext), DimensionHelper.getScreenMaxDimension((Activity) this.mContext) - DimensionHelper.getScreenStatusBarHeightIfNoCutoutAndNoNeedFullScreen()));
        this.mainRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.resaneh1.iptv.fragment.StoryCameraAndGalleryFragment.6
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0) {
                    StoryCameraAndGalleryFragment.this.checkPageSelected();
                } else if (StoryCameraAndGalleryFragment.this.scrollIdleDisposable != null) {
                    StoryCameraAndGalleryFragment.this.scrollIdleDisposable.dispose();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                StoryCameraAndGalleryFragment.this.linearLayoutContainer.scrollBy(0, i2);
                super.onScrolled(recyclerView, i, i2);
            }
        });
        this.containerFrameLayout.setRecyclerView(this.mainRecyclerView);
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        StoryCameraFragment storyCameraFragment = this.storyCameraFragment;
        if (storyCameraFragment != null) {
            storyCameraFragment.onFragmentDestroy();
        }
        StoryGalleryFragment storyGalleryFragment = this.storyGalleryFragment;
        if (storyGalleryFragment != null) {
            storyGalleryFragment.onFragmentDestroy();
        }
        super.onFragmentDestroy();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        StoryCameraGalleryContainerFrameLayout storyCameraGalleryContainerFrameLayout;
        super.onResume();
        if (DimensionHelper.isShowstoryNeedFullScreen()) {
            toggleFullscreenSwitch(true);
        }
        lockOrientationPortrait();
        if (this.currentSnapPosition == 1 && (storyCameraGalleryContainerFrameLayout = this.containerFrameLayout) != null) {
            storyCameraGalleryContainerFrameLayout.scrollEnable = false;
        }
        StoryCameraFragment storyCameraFragment = this.storyCameraFragment;
        if (storyCameraFragment != null) {
            storyCameraFragment.onResume();
            this.currentSnapPosition = -1;
            this.isCameraPause = false;
            checkPageSelected();
        }
        StoryGalleryFragment storyGalleryFragment = this.storyGalleryFragment;
        if (storyGalleryFragment != null) {
            storyGalleryFragment.onResume();
        }
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onPause() {
        StoryCameraFragment storyCameraFragment = this.storyCameraFragment;
        if (storyCameraFragment != null) {
            storyCameraFragment.onPause();
            this.isCameraPause = true;
        }
        StoryGalleryFragment storyGalleryFragment = this.storyGalleryFragment;
        if (storyGalleryFragment != null) {
            storyGalleryFragment.onPause();
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openGallery() {
        try {
            this.storyCameraFragment.stopCameraRecording();
            this.mainRecyclerView.smoothScrollToPosition(1);
        } catch (Exception unused) {
            MyLog.e("StoryCameraAndGalleryFragment", "open Gallery");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nextStep(RubinoGalleryObject rubinoGalleryObject) {
        WidgetStoryObject widgetStoryObject = this.initWidget;
        if (widgetStoryObject != null) {
            widgetStoryObject.position = this.storyCameraFragment.getInitWidgetPosition();
            presentFragment(new AddStoryFragment(rubinoGalleryObject.path, rubinoGalleryObject.isVideo, this.initWidget, 1.0f / DimensionHelper.getStoryHWRatio()));
        } else {
            presentFragment(new AddStoryFragment(rubinoGalleryObject.path, rubinoGalleryObject.isVideo));
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onRequestPermissionsResultFragment(int i, String[] strArr, int[] iArr) {
        StoryCameraFragment storyCameraFragment = this.storyCameraFragment;
        if (storyCameraFragment != null) {
            storyCameraFragment.onRequestPermissionsResultFragment(i, strArr, iArr);
        }
        StoryGalleryFragment storyGalleryFragment = this.storyGalleryFragment;
        if (storyGalleryFragment != null) {
            storyGalleryFragment.onRequestPermissionsResultFragment(i, strArr, iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkPageSelected() {
        int position;
        RecyclerView.LayoutManager layoutManager = this.mainRecyclerView.getLayoutManager();
        View viewFindSnapView = this.snapHelper.findSnapView(layoutManager);
        if (viewFindSnapView == null || this.currentSnapPosition == (position = layoutManager.getPosition(viewFindSnapView))) {
            return;
        }
        this.currentSnapPosition = position;
        MyLog.e("StoryCameraAndGalleryFragment", "position " + this.currentSnapPosition);
        DisposableObserver disposableObserver = (DisposableObserver) Observable.timer(this.currentSnapPosition == 0 ? ImageReceiver.DEFAULT_CROSSFADE_DURATION : 2000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Long>() { // from class: ir.resaneh1.iptv.fragment.StoryCameraAndGalleryFragment.7
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onNext(Long l) {
                if (StoryCameraAndGalleryFragment.this.currentSnapPosition == 0) {
                    if (StoryCameraAndGalleryFragment.this.isCameraPause) {
                        StoryCameraAndGalleryFragment.this.storyCameraFragment.onResumeCamera();
                        StoryCameraAndGalleryFragment.this.isCameraPause = false;
                        return;
                    }
                    return;
                }
                StoryCameraAndGalleryFragment.this.storyCameraFragment.onPauseCamera();
                StoryCameraAndGalleryFragment.this.isCameraPause = true;
                if (StoryCameraAndGalleryFragment.this.storyGalleryFragment != null) {
                    StoryCameraAndGalleryFragment.this.storyGalleryFragment.checkPermissionAndLoadIfNeeded();
                }
            }
        });
        this.scrollIdleDisposable = disposableObserver;
        ((PresenterFragment) this).compositeDisposable.add(disposableObserver);
    }

    public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return 2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        }

        public CustomAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            FrameLayout frameLayout = new FrameLayout(StoryCameraAndGalleryFragment.this.mContext);
            frameLayout.setLayoutParams(new RecyclerView.LayoutParams(DimensionHelper.getScreenMinDimension((Activity) StoryCameraAndGalleryFragment.this.mContext), DimensionHelper.getScreenMaxDimension((Activity) StoryCameraAndGalleryFragment.this.mContext) - DimensionHelper.getScreenStatusBarHeightIfNoCutoutAndNoNeedFullScreen()));
            MyViewHolder myViewHolder = new MyViewHolder(StoryCameraAndGalleryFragment.this, frameLayout);
            frameLayout.setTag(myViewHolder);
            return myViewHolder;
        }
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public boolean onBackPressed() {
        if (this.currentSnapPosition == 1) {
            try {
                this.containerFrameLayout.scrollEnable = true;
                this.mainRecyclerView.smoothScrollToPosition(0);
                return false;
            } catch (Exception unused) {
                StoryCameraFragment storyCameraFragment = this.storyCameraFragment;
                if (storyCameraFragment != null) {
                    storyCameraFragment.onBackPressed();
                }
                StoryGalleryFragment storyGalleryFragment = this.storyGalleryFragment;
                if (storyGalleryFragment != null) {
                    storyGalleryFragment.onBackPressed();
                }
                return super.onBackPressed();
            }
        }
        StoryCameraFragment storyCameraFragment2 = this.storyCameraFragment;
        if (storyCameraFragment2 != null) {
            storyCameraFragment2.onBackPressed();
        }
        StoryGalleryFragment storyGalleryFragment2 = this.storyGalleryFragment;
        if (storyGalleryFragment2 != null) {
            storyGalleryFragment2.onBackPressed();
        }
        return super.onBackPressed();
    }

    public class MyViewHolder extends AbstractPresenter.AbstractViewHolder<TitleObject> {
        public MyViewHolder(StoryCameraAndGalleryFragment storyCameraAndGalleryFragment, View view) {
            super(view);
        }
    }

    private class CustomLinearLayoutManager extends LinearLayoutManager {
        public CustomLinearLayoutManager(Context context, int i, boolean z) {
            super(context, i, z);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollVertically() {
            return super.canScrollVertically() && (StoryCameraAndGalleryFragment.this.storyCameraFragment == null || !StoryCameraAndGalleryFragment.this.storyCameraFragment.isLockScrollBecauseOfCamera) && StoryCameraAndGalleryFragment.this.containerFrameLayout != null && StoryCameraAndGalleryFragment.this.containerFrameLayout.scrollEnable;
        }
    }
}
