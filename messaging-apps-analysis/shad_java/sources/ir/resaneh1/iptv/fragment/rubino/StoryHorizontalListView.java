package ir.resaneh1.iptv.fragment.rubino;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import ir.resaneh1.iptv.fragment.StoryCameraAndGalleryFragment;
import ir.resaneh1.iptv.fragment.StoryFragment;
import ir.resaneh1.iptv.fragment.StorySeenFragment;
import ir.resaneh1.iptv.fragment.messanger.LiveBroadCastActivity;
import ir.resaneh1.iptv.helper.AppRubinoPreferences;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.helper.StoryController;
import ir.resaneh1.iptv.model.RubinoProfileObject;
import ir.resaneh1.iptv.model.StoryListOfAProfileObject;
import ir.resaneh1.iptv.presenters.StoryPresenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.UserConfig;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.Point;
import org.rbmain.ui.Components.RecyclerListView;

/* loaded from: classes3.dex */
public class StoryHorizontalListView extends org.rbmain.ui.Components.RecyclerListView {
    ArrayList<StoryListOfAProfileObject> arrayList;
    CompositeDisposable compositeDisposable;
    private final int currentAccount;
    public int liveCount;
    Context mContext;
    RecyclerListView.OnItemClickListener onClickListener;
    private DisposableObserver storyDisposable;

    @Override // org.rbmain.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (getParent() != null && getParent().getParent() != null) {
            getParent().getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public StoryHorizontalListView(Context context, CompositeDisposable compositeDisposable) {
        super(context);
        this.currentAccount = UserConfig.selectedAccount;
        this.onClickListener = new RecyclerListView.OnItemClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.StoryHorizontalListView.2
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
            public void onItemClick(View view, int i) {
                final float x = view.getX() + (view.getMeasuredWidth() / 2.0f);
                final float y = ((view.getY() + (view.getY() + (view.getMeasuredHeight() / 2.0f))) / 2.0f) + ActionBar.getCurrentActionBarHeight();
                final StoryProfileCell storyProfileCell = (StoryProfileCell) view;
                if (ApplicationLoader.applicationActivity != null) {
                    if (storyProfileCell.currentStoryProfile.isLive) {
                        LiveBroadCastActivity liveBroadCastActivity = new LiveBroadCastActivity(storyProfileCell.currentStoryProfile.profileObject) { // from class: ir.resaneh1.iptv.fragment.rubino.StoryHorizontalListView.2.1
                            @Override // org.rbmain.ui.ActionBar.BaseFragment
                            public Point getDismissOriginPoint() {
                                for (int i2 = 0; i2 < StoryHorizontalListView.this.getChildCount(); i2++) {
                                    try {
                                        View childAt = StoryHorizontalListView.this.getChildAt(i2);
                                        if ((childAt instanceof StoryProfileCell) && storyProfileCell.currentStoryProfile.profileObject.id.equals(((StoryProfileCell) childAt).currentStoryProfile.profileObject.id) && ((StoryProfileCell) childAt).currentStoryProfile.isLive) {
                                            return new Point(x, y);
                                        }
                                    } catch (Exception unused) {
                                        return super.getDismissOriginPoint();
                                    }
                                }
                                return new Point(DimensionHelper.getScreenWidth(ApplicationLoader.applicationActivity) / 2, DimensionHelper.getScreenHeight(ApplicationLoader.applicationActivity) / 2);
                            }
                        };
                        liveBroadCastActivity.fragmentPresentOriginX = x;
                        liveBroadCastActivity.fragmentPresentOriginY = y;
                        liveBroadCastActivity.setIsSwipeDownEnable(true);
                        ApplicationLoader.applicationActivity.lambda$runLinkRequest$40(liveBroadCastActivity);
                        return;
                    }
                    ArrayList<StoryListOfAProfileObject> arrayList = StoryHorizontalListView.this.arrayList;
                    if (arrayList == null || arrayList.size() <= 0) {
                        return;
                    }
                    Iterator<StoryListOfAProfileObject> it = StoryHorizontalListView.this.arrayList.iterator();
                    while (it.hasNext()) {
                        it.next().isNeedToSetCurrentBasedOnSeen = true;
                    }
                    if (!StoryHorizontalListView.this.arrayList.get(0).isMyStory()) {
                        StoryHorizontalListView storyHorizontalListView = StoryHorizontalListView.this;
                        storyHorizontalListView.getStoryInfo(false, storyProfileCell, storyHorizontalListView.arrayList, i, x, y);
                        return;
                    }
                    if (i == 0) {
                        StoryController.ProfileStoryStatusEnum profileStoriesStatus = StoryController.getInstance(StoryHorizontalListView.this.currentAccount).getProfileStoriesStatus(AppRubinoPreferences.getInstance(StoryHorizontalListView.this.currentAccount).getRubinoCurrentProfileObject().id);
                        if (profileStoriesStatus == StoryController.ProfileStoryStatusEnum.SeenStory || profileStoriesStatus == StoryController.ProfileStoryStatusEnum.NotSeenStory) {
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(StoryHorizontalListView.this.arrayList.get(0));
                            StoryHorizontalListView.this.getStoryInfo(true, storyProfileCell, arrayList2, 0, x, y);
                            return;
                        }
                        ApplicationLoader.applicationActivity.lambda$runLinkRequest$40(new StoryCameraAndGalleryFragment());
                        return;
                    }
                    ArrayList arrayList3 = new ArrayList();
                    for (int i2 = StoryHorizontalListView.this.liveCount + 1; i2 < StoryHorizontalListView.this.arrayList.size(); i2++) {
                        arrayList3.add(StoryHorizontalListView.this.arrayList.get(i2));
                    }
                    StoryHorizontalListView storyHorizontalListView2 = StoryHorizontalListView.this;
                    storyHorizontalListView2.getStoryInfo(false, storyProfileCell, arrayList3, (i - 1) - storyHorizontalListView2.liveCount, x, y);
                }
            }
        };
        setWillNotDraw(false);
        this.compositeDisposable = compositeDisposable;
        this.mContext = context;
        this.arrayList = new ArrayList<>();
        setPadding(AndroidUtilities.dp(2.0f), 0, AndroidUtilities.dp(2.0f), 0);
        setItemAnimator(null);
        setLayoutAnimation(null);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, context) { // from class: ir.resaneh1.iptv.fragment.rubino.StoryHorizontalListView.1
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean supportsPredictiveItemAnimations() {
                return false;
            }
        };
        if (Build.VERSION.SDK_INT >= 17) {
            setLayoutDirection(0);
        }
        linearLayoutManager.setOrientation(0);
        setLayoutManager(linearLayoutManager);
        setAdapter(new ListAdapter());
        setOnItemClickListener(this.onClickListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(0.0f, getHeight() - 1, getWidth(), getHeight() - 1, Theme.getDividerPaint());
    }

    public void addOrUpdateProfileList(ArrayList<StoryListOfAProfileObject> arrayList, boolean z, int i) {
        if (z) {
            this.arrayList.clear();
            this.liveCount = 0;
        }
        this.liveCount += i;
        this.arrayList.addAll(arrayList);
        getAdapter().notifyDataSetChanged();
    }

    class ListAdapter extends RecyclerListView.SelectionAdapter {
        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return true;
        }

        ListAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new RecyclerListView.Holder(new StoryProfileCell(StoryHorizontalListView.this.mContext));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if (i < StoryHorizontalListView.this.arrayList.size()) {
                ((StoryProfileCell) viewHolder.itemView).setProfile(StoryHorizontalListView.this.arrayList.get(i));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return StoryHorizontalListView.this.arrayList.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getStoryInfo(final boolean z, StoryProfileCell storyProfileCell, final ArrayList<StoryListOfAProfileObject> arrayList, final int i, final float f, final float f2) {
        final RubinoProfileObject rubinoProfileObject;
        if (arrayList != null && i >= 0 && i < arrayList.size() && (rubinoProfileObject = arrayList.get(i).profileObject) != null) {
            if (StoryController.getInstance(this.currentAccount).getInstantProfileStoryIdsWithLocal(rubinoProfileObject, null, false) != null) {
                StoryController.getInstance(this.currentAccount).unSetCurrentLoadingProfile();
                openStoryFragment(z, arrayList, i, f, f2);
            } else {
                if (rubinoProfileObject.id.equals(StoryController.getInstance(this.currentAccount).currentLoadingProfileId)) {
                    return;
                }
                StoryController.getInstance(this.currentAccount).setCurrentLoadingProfile(rubinoProfileObject.id);
                final boolean[] zArr = {false};
                DisposableObserver disposableObserver = (DisposableObserver) StoryController.getInstance(this.currentAccount).getProfileStoryIdsWithLoadStoryObservable(rubinoProfileObject, storyProfileCell.currentStoryProfile.current, 10, false).observeOn(Schedulers.computation()).doOnNext(new Consumer<Integer>() { // from class: ir.resaneh1.iptv.fragment.rubino.StoryHorizontalListView.4
                    @Override // io.reactivex.functions.Consumer
                    public void accept(Integer num) throws Exception {
                        if (rubinoProfileObject.id.equals(StoryController.getInstance(StoryHorizontalListView.this.currentAccount).currentLoadingProfileId)) {
                            StoryController.getInstance(StoryHorizontalListView.this.currentAccount).unSetCurrentLoadingProfile();
                            zArr[0] = true;
                        }
                    }
                }).delay(10L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Integer>() { // from class: ir.resaneh1.iptv.fragment.rubino.StoryHorizontalListView.3
                    @Override // io.reactivex.Observer
                    public void onComplete() {
                    }

                    @Override // io.reactivex.Observer
                    public void onNext(Integer num) {
                        if (zArr[0]) {
                            StoryHorizontalListView.this.openStoryFragment(z, arrayList, i, f, f2);
                        }
                    }

                    @Override // io.reactivex.Observer
                    public void onError(Throwable th) {
                        if (rubinoProfileObject.id.equals(StoryController.getInstance(StoryHorizontalListView.this.currentAccount).currentLoadingProfileId)) {
                            StoryController.getInstance(StoryHorizontalListView.this.currentAccount).unSetCurrentLoadingProfile();
                        }
                    }
                });
                this.storyDisposable = disposableObserver;
                this.compositeDisposable.add(disposableObserver);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openStoryFragment(boolean z, final ArrayList<StoryListOfAProfileObject> arrayList, int i, final float f, final float f2) {
        if (z) {
            StorySeenFragment storySeenFragment = new StorySeenFragment(true);
            storySeenFragment.fragmentPresentOriginX = f;
            storySeenFragment.fragmentPresentOriginY = f2;
            ApplicationLoader.applicationActivity.lambda$runLinkRequest$40(storySeenFragment);
            return;
        }
        StoryFragment storyFragment = new StoryFragment(arrayList, i) { // from class: ir.resaneh1.iptv.fragment.rubino.StoryHorizontalListView.5
            @Override // org.rbmain.ui.ActionBar.BaseFragment
            public Point getDismissOriginPoint() {
                try {
                    float x = f;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= StoryHorizontalListView.this.getChildCount()) {
                            break;
                        }
                        View childAt = StoryHorizontalListView.this.getChildAt(i2);
                        if ((childAt instanceof StoryProfileCell) && ((StoryListOfAProfileObject) arrayList.get(this.currentSnapPosition)).profileObject.id.equals(((StoryProfileCell) childAt).currentStoryProfile.profileObject.id)) {
                            x = childAt.getX() + (childAt.getMeasuredWidth() / 2.0f);
                            break;
                        }
                        i2++;
                    }
                    return new Point(x, f2);
                } catch (Exception unused) {
                    return super.getDismissOriginPoint();
                }
            }
        };
        storyFragment.setScrollListener(new StoryPresenter.ScrollListener() { // from class: ir.resaneh1.iptv.fragment.rubino.StoryHorizontalListView.6
            @Override // ir.resaneh1.iptv.presenters.StoryPresenter.ScrollListener
            public void onFlingUp(float f3) {
            }

            @Override // ir.resaneh1.iptv.presenters.StoryPresenter.ScrollListener
            public void onScrollUp(float f3) {
            }

            @Override // ir.resaneh1.iptv.presenters.StoryPresenter.ScrollListener
            public void onScrollHorizontally(int i2) {
                StoryHorizontalListView storyHorizontalListView = StoryHorizontalListView.this;
                storyHorizontalListView.scrollToPosition(i2 + 1 + storyHorizontalListView.liveCount);
            }
        });
        storyFragment.fragmentPresentOriginX = f;
        storyFragment.fragmentPresentOriginY = f2;
        ApplicationLoader.applicationActivity.lambda$runLinkRequest$40(storyFragment);
    }
}
