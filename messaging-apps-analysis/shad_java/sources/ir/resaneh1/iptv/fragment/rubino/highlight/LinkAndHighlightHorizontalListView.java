package ir.resaneh1.iptv.fragment.rubino.highlight;

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
import ir.appp.common.utils.AndroidUtilities;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.StoryFragment;
import ir.resaneh1.iptv.fragment.StorySeenFragment;
import ir.resaneh1.iptv.fragment.rubino.RecyclerListView;
import ir.resaneh1.iptv.fragment.rubino.RubinoController;
import ir.resaneh1.iptv.helper.StoryController;
import ir.resaneh1.iptv.model.Rubino;
import ir.resaneh1.iptv.model.RubinoProfileLinkObject;
import ir.resaneh1.iptv.model.RubinoProfileObject;
import ir.resaneh1.iptv.model.StoryListOfAProfileObject;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import ir.resaneh1.iptv.presenters.StoryPresenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.UserConfig;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.Point;

/* loaded from: classes3.dex */
public class LinkAndHighlightHorizontalListView extends RecyclerListView {
    private int addNewHighlightRow;
    CompositeDisposable compositeDisposable;
    private final int currentAccount;
    private int highlightArrayEndRow;
    private int highlightArrayStartRow;
    ArrayList<Rubino.StoryHighlight> highlightList;
    private int linkArrayEndRow;
    private int linkArrayStartRow;
    ArrayList<RubinoProfileLinkObject> linkList;
    private ListAdapter listAdapter;
    Context mContext;
    RecyclerListView.OnItemClickListener onClickListener;
    private final RecyclerListView.OnItemLongClickListenerExtended onLongClickListener;
    String profileId;
    RubinoProfileObject profileObject;
    private int rowCount;
    private DisposableObserver storyDisposable;
    ArrayList<StoryListOfAProfileObject> storyListOfAProfileObjects;

    void updateRows() {
        this.linkArrayStartRow = -1;
        this.linkArrayEndRow = -1;
        this.highlightArrayStartRow = -1;
        this.highlightArrayEndRow = -1;
        this.addNewHighlightRow = -1;
        this.rowCount = 0;
        if (this.linkList.size() > 0) {
            int i = this.rowCount;
            this.linkArrayStartRow = i;
            int size = i + this.linkList.size();
            this.rowCount = size;
            this.linkArrayEndRow = size;
        }
        if (this.highlightList.size() > 0) {
            int i2 = this.rowCount;
            this.highlightArrayStartRow = i2;
            int size2 = i2 + this.highlightList.size();
            this.rowCount = size2;
            this.highlightArrayEndRow = size2;
        }
        if (this.profileId.equals(RubinoController.getInstance(this.currentAccount).getMyCurrentProfileID()) && RubinoController.getInstance(this.currentAccount).hasPermissionAddStory()) {
            int i3 = this.rowCount;
            this.rowCount = i3 + 1;
            this.addNewHighlightRow = i3;
        }
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (getParent() != null && getParent().getParent() != null) {
            getParent().getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public LinkAndHighlightHorizontalListView(Context context, CompositeDisposable compositeDisposable, RubinoProfileObject rubinoProfileObject) {
        super(context);
        this.highlightList = new ArrayList<>();
        this.storyListOfAProfileObjects = new ArrayList<>();
        this.linkList = new ArrayList<>();
        this.currentAccount = UserConfig.selectedAccount;
        this.onClickListener = new RecyclerListView.OnItemClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.LinkAndHighlightHorizontalListView.2
            @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListView.OnItemClickListener
            public void onItemClick(View view, int i) {
                if (ApplicationLoader.applicationActivity != null) {
                    if (i < LinkAndHighlightHorizontalListView.this.highlightArrayStartRow || i >= LinkAndHighlightHorizontalListView.this.highlightArrayEndRow) {
                        if (i < LinkAndHighlightHorizontalListView.this.linkArrayStartRow || i >= LinkAndHighlightHorizontalListView.this.linkArrayEndRow) {
                            if (i == LinkAndHighlightHorizontalListView.this.addNewHighlightRow) {
                                ApplicationLoader.applicationActivity.lambda$runLinkRequest$40(new ArchiveStoryListFragment());
                                return;
                            }
                            return;
                        }
                        LinkAndHighlightHorizontalListView linkAndHighlightHorizontalListView = LinkAndHighlightHorizontalListView.this;
                        ArrayList<RubinoProfileLinkObject> arrayList = linkAndHighlightHorizontalListView.linkList;
                        if (arrayList != null) {
                            RubinoProfileLinkObject rubinoProfileLinkObject = arrayList.get(i - linkAndHighlightHorizontalListView.linkArrayStartRow);
                            if (rubinoProfileLinkObject.link != null) {
                                new MainClickHandler().onLinkClick(rubinoProfileLinkObject.link);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    ArrayList<Rubino.StoryHighlight> arrayList2 = LinkAndHighlightHorizontalListView.this.highlightList;
                    if (arrayList2 == null || arrayList2.size() <= 0 || LinkAndHighlightHorizontalListView.this.profileId == null) {
                        return;
                    }
                    float x = view.getX() + (view.getMeasuredWidth() / 2.0f);
                    float y = ((view.getY() + (((view.getY() + (view.getMeasuredHeight() / 2.0f)) + LinkAndHighlightHorizontalListView.this.getY()) + ((View) LinkAndHighlightHorizontalListView.this.getParent()).getY())) / 2.0f) + ActionBar.getCurrentActionBarHeight();
                    LinkAndHighlightHorizontalListView linkAndHighlightHorizontalListView2 = LinkAndHighlightHorizontalListView.this;
                    boolean zEquals = linkAndHighlightHorizontalListView2.profileId.equals(RubinoController.getInstance(linkAndHighlightHorizontalListView2.currentAccount).getMyCurrentProfileID());
                    ProfileLinkCell profileLinkCell = (ProfileLinkCell) view;
                    LinkAndHighlightHorizontalListView linkAndHighlightHorizontalListView3 = LinkAndHighlightHorizontalListView.this;
                    linkAndHighlightHorizontalListView2.getStoryInfo(zEquals, profileLinkCell, linkAndHighlightHorizontalListView3.storyListOfAProfileObjects, i - linkAndHighlightHorizontalListView3.highlightArrayStartRow, x, y);
                }
            }
        };
        RecyclerListView.OnItemLongClickListenerExtended onItemLongClickListenerExtended = new RecyclerListView.OnItemLongClickListenerExtended() { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.LinkAndHighlightHorizontalListView.3
            @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListView.OnItemLongClickListenerExtended
            public void onLongClickRelease() {
            }

            @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListView.OnItemLongClickListenerExtended
            public void onMove(float f, float f2) {
            }

            @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListView.OnItemLongClickListenerExtended
            public boolean onItemClick(View view, int i, float f, float f2) {
                LinkAndHighlightHorizontalListView linkAndHighlightHorizontalListView = LinkAndHighlightHorizontalListView.this;
                String str = linkAndHighlightHorizontalListView.profileId;
                if (str == null || !str.equals(RubinoController.getInstance(linkAndHighlightHorizontalListView.currentAccount).getMyCurrentProfileID())) {
                    return false;
                }
                int i2 = i - LinkAndHighlightHorizontalListView.this.highlightArrayStartRow;
                if (i2 < 0 || i2 >= LinkAndHighlightHorizontalListView.this.highlightList.size()) {
                    return true;
                }
                LinkAndHighlightHorizontalListView linkAndHighlightHorizontalListView2 = LinkAndHighlightHorizontalListView.this;
                linkAndHighlightHorizontalListView2.openHighlightBottomSheet(linkAndHighlightHorizontalListView2.highlightList.get(i2));
                return true;
            }
        };
        this.onLongClickListener = onItemLongClickListenerExtended;
        setWillNotDraw(false);
        this.profileObject = rubinoProfileObject;
        this.profileId = rubinoProfileObject.id;
        this.compositeDisposable = compositeDisposable;
        this.mContext = context;
        setPadding(AndroidUtilities.dp(2.0f), 0, AndroidUtilities.dp(2.0f), 0);
        setItemAnimator(null);
        setLayoutAnimation(null);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, context) { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.LinkAndHighlightHorizontalListView.1
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
        ListAdapter listAdapter = new ListAdapter();
        this.listAdapter = listAdapter;
        setAdapter(listAdapter);
        setOnItemClickListener(this.onClickListener);
        setOnItemLongClickListener(onItemLongClickListenerExtended);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(0.0f, getHeight() - 1, getWidth(), getHeight() - 1, Theme.getDividerPaint());
    }

    public void addOrUpdateLinkList(ArrayList<RubinoProfileLinkObject> arrayList, boolean z) {
        if (z) {
            this.linkList.clear();
        }
        this.linkList.addAll(arrayList);
        updateRows();
    }

    public void addOrUpdateHighlightList(ArrayList<Rubino.StoryHighlight> arrayList, boolean z) {
        if (z) {
            this.highlightList.clear();
            this.storyListOfAProfileObjects.clear();
        }
        this.highlightList.addAll(arrayList);
        Iterator<Rubino.StoryHighlight> it = arrayList.iterator();
        while (it.hasNext()) {
            Rubino.StoryHighlight next = it.next();
            StoryListOfAProfileObject storyListOfAProfileObject = new StoryListOfAProfileObject(this.currentAccount);
            storyListOfAProfileObject.highlightId = next.highlight_id;
            storyListOfAProfileObject.profileObject = this.profileObject;
            this.storyListOfAProfileObjects.add(storyListOfAProfileObject);
        }
        updateRows();
    }

    class ListAdapter extends RecyclerListView.SelectionAdapter {
        @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return true;
        }

        ListAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new RecyclerListView.Holder(new ProfileLinkCell(LinkAndHighlightHorizontalListView.this.mContext));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if (i < LinkAndHighlightHorizontalListView.this.highlightArrayStartRow || i >= LinkAndHighlightHorizontalListView.this.highlightArrayEndRow) {
                if (i < LinkAndHighlightHorizontalListView.this.linkArrayStartRow || i >= LinkAndHighlightHorizontalListView.this.linkArrayEndRow) {
                    if (i == LinkAndHighlightHorizontalListView.this.addNewHighlightRow) {
                        ((ProfileLinkCell) viewHolder.itemView).setAsNewCell();
                        return;
                    }
                    return;
                } else {
                    ProfileLinkCell profileLinkCell = (ProfileLinkCell) viewHolder.itemView;
                    LinkAndHighlightHorizontalListView linkAndHighlightHorizontalListView = LinkAndHighlightHorizontalListView.this;
                    profileLinkCell.setData(linkAndHighlightHorizontalListView.linkList.get(i - linkAndHighlightHorizontalListView.linkArrayStartRow));
                    return;
                }
            }
            ProfileLinkCell profileLinkCell2 = (ProfileLinkCell) viewHolder.itemView;
            LinkAndHighlightHorizontalListView linkAndHighlightHorizontalListView2 = LinkAndHighlightHorizontalListView.this;
            profileLinkCell2.setData(linkAndHighlightHorizontalListView2.highlightList.get(i - linkAndHighlightHorizontalListView2.highlightArrayStartRow));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return LinkAndHighlightHorizontalListView.this.rowCount;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openHighlightBottomSheet(final Rubino.StoryHighlight storyHighlight) {
        if (storyHighlight == null || ApplicationLoader.applicationActivity == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Rubino.AlertItem(LocaleController.getString(R.string.rubinoEditHighLight), 0, new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.LinkAndHighlightHorizontalListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ApplicationLoader.applicationActivity.lambda$runLinkRequest$40(new AddHighlightFragment(storyHighlight));
            }
        }));
        arrayList.add(new Rubino.AlertItem(LocaleController.getString(R.string.rubinoDeleteHighLight), 0, new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.LinkAndHighlightHorizontalListView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RubinoController.getInstance(LinkAndHighlightHorizontalListView.this.currentAccount).deleteHighlight(storyHighlight);
            }
        }));
        RubinoController.showRubinoCenterDialog(null, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getStoryInfo(final boolean z, ProfileLinkCell profileLinkCell, final ArrayList<StoryListOfAProfileObject> arrayList, final int i, final float f, final float f2) {
        if (arrayList != null && i >= 0 && i < arrayList.size() && this.profileId != null) {
            if (StoryController.getInstance(this.currentAccount).getHighlightStoryIdsAndLoadIfNeeded(this.profileObject, arrayList.get(i).highlightId, false) != null) {
                StoryController.getInstance(this.currentAccount).unSetCurrentLoadingProfile();
                openStoryFragment(z, arrayList, i, f, f2);
            } else {
                if (this.profileId.equals(StoryController.getInstance(this.currentAccount).currentLoadingProfileId)) {
                    return;
                }
                StoryController.getInstance(this.currentAccount).setCurrentLoadingProfile(this.profileId);
                final boolean[] zArr = {false};
                DisposableObserver disposableObserver = (DisposableObserver) StoryController.getInstance(this.currentAccount).getHighlightStoryObservable(this.profileObject, arrayList.get(i).highlightId, profileLinkCell.currentHighlight.current, 10, false).observeOn(Schedulers.computation()).doOnNext(new Consumer<StoryController.ProfileStoryInfo>() { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.LinkAndHighlightHorizontalListView.7
                    @Override // io.reactivex.functions.Consumer
                    public void accept(StoryController.ProfileStoryInfo profileStoryInfo) throws Exception {
                        ((StoryListOfAProfileObject) arrayList.get(i)).info = profileStoryInfo;
                        LinkAndHighlightHorizontalListView linkAndHighlightHorizontalListView = LinkAndHighlightHorizontalListView.this;
                        if (linkAndHighlightHorizontalListView.profileId.equals(StoryController.getInstance(linkAndHighlightHorizontalListView.currentAccount).currentLoadingProfileId)) {
                            StoryController.getInstance(LinkAndHighlightHorizontalListView.this.currentAccount).unSetCurrentLoadingProfile();
                            zArr[0] = true;
                        }
                    }
                }).delay(10L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<StoryController.ProfileStoryInfo>() { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.LinkAndHighlightHorizontalListView.6
                    @Override // io.reactivex.Observer
                    public void onComplete() {
                    }

                    @Override // io.reactivex.Observer
                    public void onNext(StoryController.ProfileStoryInfo profileStoryInfo) {
                        if (zArr[0]) {
                            LinkAndHighlightHorizontalListView.this.openStoryFragment(z, arrayList, i, f, f2);
                        }
                    }

                    @Override // io.reactivex.Observer
                    public void onError(Throwable th) {
                        LinkAndHighlightHorizontalListView linkAndHighlightHorizontalListView = LinkAndHighlightHorizontalListView.this;
                        if (linkAndHighlightHorizontalListView.profileId.equals(StoryController.getInstance(linkAndHighlightHorizontalListView.currentAccount).currentLoadingProfileId)) {
                            StoryController.getInstance(LinkAndHighlightHorizontalListView.this.currentAccount).unSetCurrentLoadingProfile();
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
            StorySeenFragment storySeenFragment = new StorySeenFragment(true, StorySeenFragment.highlightType, arrayList, i);
            storySeenFragment.fragmentPresentOriginX = f;
            storySeenFragment.fragmentPresentOriginY = f2;
            ApplicationLoader.applicationActivity.lambda$runLinkRequest$40(storySeenFragment);
            return;
        }
        StoryFragment storyFragment = new StoryFragment(arrayList, i, true) { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.LinkAndHighlightHorizontalListView.8
            @Override // org.rbmain.ui.ActionBar.BaseFragment
            public Point getDismissOriginPoint() {
                try {
                    float x = f;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= LinkAndHighlightHorizontalListView.this.getChildCount()) {
                            break;
                        }
                        View childAt = LinkAndHighlightHorizontalListView.this.getChildAt(i2);
                        if ((childAt instanceof ProfileLinkCell) && ((ProfileLinkCell) childAt).currentHighlight != null && ((StoryListOfAProfileObject) arrayList.get(this.currentSnapPosition)).highlightId.equals(((ProfileLinkCell) childAt).currentHighlight.highlight_id)) {
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
        storyFragment.setScrollListener(new StoryPresenter.ScrollListener() { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.LinkAndHighlightHorizontalListView.9
            @Override // ir.resaneh1.iptv.presenters.StoryPresenter.ScrollListener
            public void onFlingUp(float f3) {
            }

            @Override // ir.resaneh1.iptv.presenters.StoryPresenter.ScrollListener
            public void onScrollUp(float f3) {
            }

            @Override // ir.resaneh1.iptv.presenters.StoryPresenter.ScrollListener
            public void onScrollHorizontally(int i2) {
                LinkAndHighlightHorizontalListView.this.scrollToPosition(i2 + 1);
            }
        });
        storyFragment.fragmentPresentOriginX = f;
        storyFragment.fragmentPresentOriginY = f2;
        ApplicationLoader.applicationActivity.lambda$runLinkRequest$40(storyFragment);
    }
}
