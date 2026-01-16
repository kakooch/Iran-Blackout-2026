package ir.resaneh1.iptv.fragment.rubino;

import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import ir.appp.rghapp.rubinoPostSlider.PullToRefreshLayout;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.FragmentType;
import ir.resaneh1.iptv.model.Rubino;
import ir.resaneh1.iptv.model.RubinoCommentObject;
import ir.resaneh1.iptv.model.RubinoPostObject;
import ir.resaneh1.iptv.model.RubinoProfileObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.ui.ActionBar.BaseFragment;

/* loaded from: classes3.dex */
public class RubinoProfileListActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    public static int blockedType = 5;
    public static int commentLikeType = 3;
    public static int followerType = 0;
    public static int followingType = 1;
    public static int postLikeAndViewType = 2;
    public static int suggestedType = 4;
    private int arrayEndRow;
    private int arrayStartRow;
    private RubinoCommentObject commentObject;
    private int emptyViewRow;
    public DisposableObserver fakeObserver;
    private boolean hasContinue;
    private long lastManualRefreshTime;
    private int likeCountTitleRow;
    private ListAdapter listAdapter;
    private RecyclerListViewEdited listView;
    private int loadMorePosition;
    public DisposableObserver loadObserver;
    private int loadingRow;
    private String maxId;
    private boolean needToRetry;
    PullToRefreshLayout.OnRefreshListener onRefreshListener;
    private String postId;
    private RubinoPostObject postObject;
    private ArrayList<RubinoProfileObject> profileArray = new ArrayList<>();
    public DisposableObserver refreshObserver;
    private int retryRow;
    private int rowCount;
    private PullToRefreshLayout swipeRefreshLayout;
    private String targetProfileId;
    private int type;
    private int viewCountRow;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createView$0(View view, int i, float f, float f2) {
    }

    public RubinoProfileListActivity(int i) {
        new ArrayList();
        this.onRefreshListener = new PullToRefreshLayout.OnRefreshListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoProfileListActivity.4
            @Override // ir.appp.rghapp.rubinoPostSlider.PullToRefreshLayout.OnRefreshListener
            public void onRefresh() {
                RubinoProfileListActivity.this.getProfiles(true, true);
            }

            @Override // ir.appp.rghapp.rubinoPostSlider.PullToRefreshLayout.OnRefreshListener
            public void onRefreshViewAnimatingStatusChanged(boolean z) {
                AndroidUtilities.recycleViewSafeSuppressLayout(RubinoProfileListActivity.this.listView, z);
            }
        };
        initFlags();
        this.type = i;
    }

    public RubinoProfileListActivity(int i, RubinoPostObject rubinoPostObject) {
        new ArrayList();
        this.onRefreshListener = new PullToRefreshLayout.OnRefreshListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoProfileListActivity.4
            @Override // ir.appp.rghapp.rubinoPostSlider.PullToRefreshLayout.OnRefreshListener
            public void onRefresh() {
                RubinoProfileListActivity.this.getProfiles(true, true);
            }

            @Override // ir.appp.rghapp.rubinoPostSlider.PullToRefreshLayout.OnRefreshListener
            public void onRefreshViewAnimatingStatusChanged(boolean z) {
                AndroidUtilities.recycleViewSafeSuppressLayout(RubinoProfileListActivity.this.listView, z);
            }
        };
        initFlags();
        this.type = i;
        this.postObject = rubinoPostObject;
        this.postId = rubinoPostObject.post.id;
    }

    public RubinoProfileListActivity(String str, RubinoCommentObject rubinoCommentObject) {
        new ArrayList();
        this.onRefreshListener = new PullToRefreshLayout.OnRefreshListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoProfileListActivity.4
            @Override // ir.appp.rghapp.rubinoPostSlider.PullToRefreshLayout.OnRefreshListener
            public void onRefresh() {
                RubinoProfileListActivity.this.getProfiles(true, true);
            }

            @Override // ir.appp.rghapp.rubinoPostSlider.PullToRefreshLayout.OnRefreshListener
            public void onRefreshViewAnimatingStatusChanged(boolean z) {
                AndroidUtilities.recycleViewSafeSuppressLayout(RubinoProfileListActivity.this.listView, z);
            }
        };
        initFlags();
        this.type = commentLikeType;
        this.postId = str;
        this.commentObject = rubinoCommentObject;
    }

    private void initFlags() {
        FragmentType fragmentType = FragmentType.Rubino;
        this.fragmentName = "RubinoProfileListActivity " + this.type;
        this.swipeBackEnabled = true;
        this.isSmallActionBar = true;
        this.needLockOrientation = true;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        getNotificationCenter().addObserver(this, NotificationCenter.rubinoFollowBlockChanged);
        return super.onFragmentCreate();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        getNotificationCenter().removeObserver(this, NotificationCenter.rubinoFollowBlockChanged);
        super.onFragmentDestroy();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0074  */
    @Override // org.rbmain.ui.ActionBar.BaseFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View createView(android.content.Context r7) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.resaneh1.iptv.fragment.rubino.RubinoProfileListActivity.createView(android.content.Context):android.view.View");
    }

    void updateRows() {
        RubinoPostObject rubinoPostObject;
        this.emptyViewRow = -1;
        this.viewCountRow = -1;
        this.likeCountTitleRow = -1;
        this.arrayStartRow = -1;
        this.arrayEndRow = -1;
        this.loadingRow = -1;
        this.retryRow = -1;
        this.loadMorePosition = Math.max(0, this.profileArray.size() - 15);
        this.rowCount = 0;
        if (this.needToRetry) {
            this.rowCount = 0 + 1;
            this.retryRow = 0;
            this.loadMorePosition = -1;
        } else {
            if (this.type == postLikeAndViewType && (rubinoPostObject = this.postObject) != null) {
                Rubino.PostObjectFromServer postObjectFromServer = rubinoPostObject.post;
                if (postObjectFromServer.file_type == Rubino.FileTypeEnum.Video && postObjectFromServer.video_view_count > 0) {
                    this.rowCount = 0 + 1;
                    this.viewCountRow = 0;
                }
            }
            if (this.profileArray.size() > 0) {
                if (this.viewCountRow >= 0) {
                    int i = this.rowCount;
                    this.rowCount = i + 1;
                    this.likeCountTitleRow = i;
                }
                int i2 = this.rowCount;
                this.arrayStartRow = i2;
                int size = i2 + this.profileArray.size();
                this.rowCount = size;
                this.arrayEndRow = size;
            }
            if (this.hasContinue) {
                int i3 = this.rowCount;
                this.rowCount = i3 + 1;
                this.loadingRow = i3;
            } else if (this.profileArray.size() == 0) {
                int i4 = this.rowCount;
                this.rowCount = i4 + 1;
                this.emptyViewRow = i4;
            }
        }
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRowsOnAddProfile() {
        if (this.arrayStartRow < 0 || this.profileArray.size() <= 0) {
            updateRows();
            return;
        }
        this.loadMorePosition = Math.max(0, this.profileArray.size() - 15);
        int i = this.rowCount;
        int i2 = this.arrayStartRow;
        this.rowCount = i2;
        int size = i2 + this.profileArray.size();
        this.rowCount = size;
        this.arrayEndRow = size;
        int i3 = this.loadingRow;
        if (this.hasContinue) {
            this.rowCount = size + 1;
            this.loadingRow = size;
        } else {
            this.loadingRow = -1;
        }
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            int i4 = this.rowCount;
            if (i > i4) {
                listAdapter.notifyItemRangeRemoved(i3, i - i4);
                return;
            }
            listAdapter.notifyItemRangeChanged(i3, 1);
            int i5 = this.rowCount;
            if ((i5 - i3) - 1 > 0) {
                this.listAdapter.notifyItemRangeInserted(i3 + 1, (i5 - i3) - 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getProfiles(final boolean z, final boolean z2) {
        if (z || this.hasContinue) {
            if (z) {
                DisposableObserver disposableObserver = this.refreshObserver;
                if (disposableObserver != null && !disposableObserver.isDisposed()) {
                    PullToRefreshLayout pullToRefreshLayout = this.swipeRefreshLayout;
                    if (pullToRefreshLayout != null) {
                        pullToRefreshLayout.setRefreshing(false, true);
                        return;
                    }
                    return;
                }
                if (z2 && System.currentTimeMillis() - this.lastManualRefreshTime < 10000) {
                    DisposableObserver disposableObserver2 = this.fakeObserver;
                    if (disposableObserver2 != null && !disposableObserver2.isDisposed()) {
                        this.fakeObserver.dispose();
                    }
                    DisposableObserver disposableObserver3 = (DisposableObserver) Observable.timer(500L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Long>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoProfileListActivity.5
                        @Override // io.reactivex.Observer
                        public void onNext(Long l) {
                            if (RubinoProfileListActivity.this.swipeRefreshLayout != null) {
                                RubinoProfileListActivity.this.swipeRefreshLayout.setRefreshing(false, true);
                            }
                        }

                        @Override // io.reactivex.Observer
                        public void onError(Throwable th) {
                            dispose();
                        }

                        @Override // io.reactivex.Observer
                        public void onComplete() {
                            dispose();
                        }
                    });
                    this.fakeObserver = disposableObserver3;
                    this.compositeDisposable.add(disposableObserver3);
                    return;
                }
                DisposableObserver disposableObserver4 = this.loadObserver;
                if (disposableObserver4 != null && !disposableObserver4.isDisposed()) {
                    this.loadObserver.dispose();
                }
            } else {
                DisposableObserver disposableObserver5 = this.loadObserver;
                if (disposableObserver5 != null && !disposableObserver5.isDisposed()) {
                    return;
                }
                DisposableObserver disposableObserver6 = this.refreshObserver;
                if (disposableObserver6 != null && !disposableObserver6.isDisposed()) {
                    this.refreshObserver.dispose();
                    PullToRefreshLayout pullToRefreshLayout2 = this.swipeRefreshLayout;
                    if (pullToRefreshLayout2 != null) {
                        pullToRefreshLayout2.setRefreshing(false, true);
                    }
                }
            }
            DisposableObserver disposableObserver7 = this.fakeObserver;
            if (disposableObserver7 != null && !disposableObserver7.isDisposed()) {
                this.fakeObserver.dispose();
            }
            int i = this.type;
            Observable<Rubino.ProfileListObject> blockedProfilesObservable = null;
            if (i == followerType) {
                blockedProfilesObservable = getRubinoController().getFollowerFollowingObservable(this.targetProfileId, true, z ? null : this.maxId, 50);
            } else if (i == followingType) {
                blockedProfilesObservable = getRubinoController().getFollowerFollowingObservable(this.targetProfileId, false, z ? null : this.maxId, 50);
            } else if (i == postLikeAndViewType) {
                RubinoController rubinoController = getRubinoController();
                Rubino.PostObjectFromServer postObjectFromServer = this.postObject.post;
                blockedProfilesObservable = rubinoController.getPostLikeObservable(postObjectFromServer.id, postObjectFromServer.profile_id, z ? null : this.maxId, 50);
            } else if (i == commentLikeType) {
                blockedProfilesObservable = getRubinoController().getCommentLikeObservable(this.postId, this.commentObject.comment.id, z ? null : this.maxId, 50);
            } else if (i == suggestedType) {
                blockedProfilesObservable = getRubinoController().getSuggestedProfilesObservable(z ? null : this.maxId, 50);
            } else if (i == blockedType) {
                blockedProfilesObservable = getRubinoController().getBlockedProfilesObservable(z ? null : this.maxId, 50);
            }
            DisposableObserver disposableObserver8 = (DisposableObserver) blockedProfilesObservable.observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Rubino.ProfileListObject>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoProfileListActivity.6
                @Override // io.reactivex.Observer
                public void onNext(Rubino.ProfileListObject profileListObject) {
                    ArrayList<RubinoProfileObject> arrayList;
                    RubinoProfileListActivity.this.swipeRefreshLayout.setRefreshing(false, true);
                    if (z && z2) {
                        RubinoProfileListActivity.this.lastManualRefreshTime = System.currentTimeMillis();
                    }
                    if (profileListObject == null || (arrayList = profileListObject.profiles) == null || arrayList.size() <= 0) {
                        RubinoProfileListActivity.this.hasContinue = false;
                    } else {
                        RubinoProfileListActivity rubinoProfileListActivity = RubinoProfileListActivity.this;
                        ArrayList<RubinoProfileObject> arrayList2 = profileListObject.profiles;
                        rubinoProfileListActivity.maxId = arrayList2.get(arrayList2.size() - 1).id;
                        if (z) {
                            RubinoProfileListActivity.this.profileArray.clear();
                        }
                        RubinoProfileListActivity.this.profileArray.addAll(profileListObject.profiles);
                    }
                    if (!z) {
                        RubinoProfileListActivity.this.updateRowsOnAddProfile();
                    } else {
                        RubinoProfileListActivity.this.updateRows();
                    }
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                    RubinoProfileListActivity.this.swipeRefreshLayout.setRefreshing(false, true);
                    dispose();
                    if (RubinoProfileListActivity.this.profileArray.size() == 0) {
                        RubinoProfileListActivity.this.needToRetry = true;
                        RubinoProfileListActivity.this.updateRows();
                    }
                }

                @Override // io.reactivex.Observer
                public void onComplete() {
                    dispose();
                }
            });
            if (z) {
                this.refreshObserver = disposableObserver8;
            } else {
                this.loadObserver = disposableObserver8;
            }
            this.compositeDisposable.add(disposableObserver8);
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean needButton() {
        int i = this.type;
        return i == followerType || i == followingType || i == suggestedType || i == blockedType;
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        ProfileOrHashtagCell profileOrHashtagCell;
        RubinoProfileObject rubinoProfileObject;
        if (i == NotificationCenter.rubinoFollowBlockChanged) {
            if (this.type == blockedType) {
                String str = (String) objArr[0];
                int iIndexOf = -1;
                Iterator<RubinoProfileObject> it = this.profileArray.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    RubinoProfileObject next = it.next();
                    if (next.id.equals(str)) {
                        iIndexOf = this.profileArray.indexOf(next);
                        break;
                    }
                }
                if (iIndexOf >= 0) {
                    this.profileArray.remove(iIndexOf);
                    updateRows();
                    this.listAdapter.notifyDataSetChanged();
                    return;
                }
                return;
            }
            if (needButton()) {
                int childCount = this.listView.getChildCount();
                String str2 = (String) objArr[0];
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = this.listView.getChildAt(i3);
                    if ((childAt instanceof ProfileOrHashtagCell) && (rubinoProfileObject = (profileOrHashtagCell = (ProfileOrHashtagCell) childAt).currentProfile) != null && rubinoProfileObject.id.equals(str2)) {
                        profileOrHashtagCell.setButtons();
                    }
                }
            }
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
            return RubinoProfileListActivity.this.rowCount;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View rubinoNewEventTitleCell;
            if (i == 0) {
                View profileOrHashtagCell = new ProfileOrHashtagCell(this.mContext, RubinoProfileListActivity.this.needButton(), false);
                profileOrHashtagCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
                rubinoNewEventTitleCell = profileOrHashtagCell;
            } else if (i == 2) {
                View rubinoLikeTitleCell = new RubinoLikeTitleCell(this.mContext, true);
                rubinoLikeTitleCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
                rubinoNewEventTitleCell = rubinoLikeTitleCell;
            } else if (i == 3) {
                View rubinoVideoViewCountCell = new RubinoVideoViewCountCell(this.mContext);
                rubinoVideoViewCountCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
                rubinoNewEventTitleCell = rubinoVideoViewCountCell;
            } else if (i == 4) {
                View rubinoEmptyView = new RubinoEmptyView(this.mContext, 17);
                rubinoEmptyView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                rubinoNewEventTitleCell = rubinoEmptyView;
            } else if (i == 5) {
                RubinoRetryView rubinoRetryView = new RubinoRetryView(this.mContext);
                rubinoRetryView.setData(R.drawable.rubino_loadmore_icon_refresh);
                rubinoRetryView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoProfileListActivity.ListAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        RubinoProfileListActivity.this.needToRetry = false;
                        RubinoProfileListActivity.this.updateRows();
                    }
                });
                rubinoRetryView.setLayoutParams(new RecyclerView.LayoutParams(-1, AndroidUtilities.dp(80.0f)));
                ((LinearLayout.LayoutParams) rubinoRetryView.imageView.getLayoutParams()).topMargin = AndroidUtilities.dp(4.0f);
                rubinoNewEventTitleCell = rubinoRetryView;
            } else if (i == 6) {
                rubinoNewEventTitleCell = new RubinoNewEventTitleCell(this.mContext);
            } else {
                rubinoNewEventTitleCell = new RubinoLoadingCell(this.mContext, false);
            }
            return new RecyclerListViewEdited.Holder(rubinoNewEventTitleCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            String string;
            MyLog.e("List Status", "onBind: " + viewHolder.getAdapterPosition());
            int itemViewType = viewHolder.getItemViewType();
            if (itemViewType == 0) {
                ProfileOrHashtagCell profileOrHashtagCell = (ProfileOrHashtagCell) viewHolder.itemView;
                if (i >= RubinoProfileListActivity.this.arrayStartRow && i < RubinoProfileListActivity.this.arrayEndRow) {
                    try {
                        RubinoProfileObject rubinoProfileObject = (RubinoProfileObject) RubinoProfileListActivity.this.profileArray.get(i - RubinoProfileListActivity.this.arrayStartRow);
                        RubinoProfileObject rubinoProfileObject2 = RubinoProfileListActivity.this.getRubinoController().profileMap.get(rubinoProfileObject.id);
                        if (rubinoProfileObject2 != null) {
                            profileOrHashtagCell.setProfile(rubinoProfileObject2, ((BaseFragment) RubinoProfileListActivity.this).classGuid);
                        } else {
                            profileOrHashtagCell.setProfile(rubinoProfileObject, ((BaseFragment) RubinoProfileListActivity.this).classGuid);
                        }
                    } catch (Exception unused) {
                    }
                }
            } else if (itemViewType == 2) {
                RubinoLikeTitleCell rubinoLikeTitleCell = (RubinoLikeTitleCell) viewHolder.itemView;
                SpannableString spannableString = null;
                if (RubinoProfileListActivity.this.postObject != null && RubinoProfileListActivity.this.postObject.post != null) {
                    RubinoPostObject fromPostMapIfExist = RubinoProfileListActivity.this.getRubinoController().getFromPostMapIfExist(RubinoProfileListActivity.this.postObject.post.id);
                    if (fromPostMapIfExist == null) {
                        spannableString = RubinoProfileListActivity.this.postObject.likeCountSpannableString;
                    } else {
                        spannableString = fromPostMapIfExist.likeCountSpannableString;
                    }
                }
                rubinoLikeTitleCell.setText(LocaleController.getString(R.string.rubinoLikeCountTitle), spannableString);
            } else if (itemViewType == 3) {
                RubinoVideoViewCountCell rubinoVideoViewCountCell = (RubinoVideoViewCountCell) viewHolder.itemView;
                if (RubinoProfileListActivity.this.postObject != null && RubinoProfileListActivity.this.postObject.post != null) {
                    RubinoPostObject fromPostMapIfExist2 = RubinoProfileListActivity.this.getRubinoController().getFromPostMapIfExist(RubinoProfileListActivity.this.postObject.post.id);
                    if (fromPostMapIfExist2 == null) {
                        rubinoVideoViewCountCell.setData(RubinoProfileListActivity.this.postObject.viewCountSpannableString);
                    } else {
                        rubinoVideoViewCountCell.setData(fromPostMapIfExist2.viewCountSpannableString);
                    }
                }
            } else if (itemViewType == 4) {
                RubinoEmptyView rubinoEmptyView = (RubinoEmptyView) viewHolder.itemView;
                int i2 = R.drawable.rubino_empty_state_follow;
                int i3 = RubinoProfileListActivity.this.type;
                int i4 = RubinoProfileListActivity.suggestedType;
                String string2 = BuildConfig.FLAVOR;
                if (i3 != i4) {
                    if (RubinoProfileListActivity.this.type == RubinoProfileListActivity.blockedType) {
                        string = LocaleController.getString(R.string.rubinoNoBlockedProfiles);
                        i2 = 0;
                    } else {
                        string = BuildConfig.FLAVOR;
                    }
                } else {
                    string2 = LocaleController.getString(R.string.rubinoNoSuggestedProfile);
                    string = BuildConfig.FLAVOR;
                }
                rubinoEmptyView.setData(i2, string2, string);
            }
            if (RubinoProfileListActivity.this.hasContinue) {
                if (i == RubinoProfileListActivity.this.loadMorePosition || i == RubinoProfileListActivity.this.loadingRow) {
                    RubinoProfileListActivity.this.getProfiles(false, true);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i >= RubinoProfileListActivity.this.arrayStartRow && i < RubinoProfileListActivity.this.arrayEndRow) {
                return 0;
            }
            if (i == RubinoProfileListActivity.this.loadingRow) {
                return 1;
            }
            if (i == RubinoProfileListActivity.this.emptyViewRow) {
                return 4;
            }
            if (i == RubinoProfileListActivity.this.retryRow) {
                return 5;
            }
            if (i == RubinoProfileListActivity.this.viewCountRow) {
                return 3;
            }
            return i == RubinoProfileListActivity.this.likeCountTitleRow ? 2 : 0;
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
}
