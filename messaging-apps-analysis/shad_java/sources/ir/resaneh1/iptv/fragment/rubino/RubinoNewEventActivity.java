package ir.resaneh1.iptv.fragment.rubino;

import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import ir.appp.rghapp.rubinoPostSlider.PullToRefreshLayout;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited;
import ir.resaneh1.iptv.helper.AppRubinoPreferences;
import ir.resaneh1.iptv.helper.CrashHandelHelper;
import ir.resaneh1.iptv.helper.FlavorHelper;
import ir.resaneh1.iptv.helper.SpanHelper;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.FragmentType;
import ir.resaneh1.iptv.model.Rubino;
import ir.resaneh1.iptv.model.RubinoProfileObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class RubinoNewEventActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    public static int eventType = 0;
    public static int requestType = 1;
    private int arrayEndRow;
    private int arrayStartRow;
    private Context context;
    private int emptyViewRow;
    private ArrayList<Rubino.NewEventObject> eventArray = new ArrayList<>();
    private int eventTitleRow;
    public DisposableObserver fakeObserver;
    private boolean hasContinue;
    private long lastManualRefreshTime;
    private ListAdapter listAdapter;
    private RecyclerListViewEdited listView;
    private int loadMorePosition;
    public DisposableObserver loadObserver;
    private int loadingRow;
    private String maxId;
    private boolean needToRetry;
    PullToRefreshLayout.OnRefreshListener onRefreshListener;
    public DisposableObserver refreshObserver;
    private int requestNumberRow;
    private SpannableString requestSpannableString;
    private int retryRow;
    private int rowCount;
    private PullToRefreshLayout swipeRefreshLayout;
    private int type;

    public RubinoNewEventActivity(int i) {
        new ArrayList();
        this.onRefreshListener = new PullToRefreshLayout.OnRefreshListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoNewEventActivity.3
            @Override // ir.appp.rghapp.rubinoPostSlider.PullToRefreshLayout.OnRefreshListener
            public void onRefresh() {
                RubinoNewEventActivity.this.getEvents(true, true);
            }

            @Override // ir.appp.rghapp.rubinoPostSlider.PullToRefreshLayout.OnRefreshListener
            public void onRefreshViewAnimatingStatusChanged(boolean z) {
                AndroidUtilities.recycleViewSafeSuppressLayout(RubinoNewEventActivity.this.listView, z);
            }
        };
        FragmentType fragmentType = FragmentType.Rubino;
        this.fragmentName = "RubinoNewEventActivity" + i;
        this.swipeBackEnabled = true;
        this.isSmallActionBar = true;
        this.needLockOrientation = true;
        this.type = i;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        getNotificationCenter().addObserver(this, NotificationCenter.rubinoNewEventDeleted);
        getNotificationCenter().addObserver(this, NotificationCenter.rubinoRequestAnswered);
        getNotificationCenter().addObserver(this, NotificationCenter.rubinoFollowBlockChanged);
        return super.onFragmentCreate();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        getNotificationCenter().removeObserver(this, NotificationCenter.rubinoNewEventDeleted);
        getNotificationCenter().removeObserver(this, NotificationCenter.rubinoRequestAnswered);
        getNotificationCenter().removeObserver(this, NotificationCenter.rubinoFollowBlockChanged);
        super.onFragmentDestroy();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        this.context = context;
        this.actionBar.setBackButtonImage(R.drawable.ic_arrow_back_white);
        int i = this.type;
        if (i == eventType) {
            this.actionBar.setTitle(LocaleController.getString(R.string.rubinoNewEvents));
        } else if (i == requestType) {
            this.actionBar.setTitle(LocaleController.getString(R.string.rubinoRequests));
        }
        this.actionBar.getTitleTextView().setTypeface(Theme.getRubinoTypeFaceRegular());
        this.actionBar.setAllowOverlayTitle(true);
        this.actionBar.getTitleTextView().setPadding(0, 0, 0, 0);
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoNewEventActivity.1
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i2) {
                if (i2 == -1) {
                    if (FlavorHelper.isRubino()) {
                        RubinoNewEventActivity.this.getParentActivity().onBackPressed();
                    } else {
                        RubinoNewEventActivity.this.finishFragment();
                    }
                }
            }
        });
        this.listAdapter = new ListAdapter(context);
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        FrameLayout frameLayout2 = frameLayout;
        int i2 = Theme.key_windowBackgroundWhite;
        frameLayout2.setBackgroundColor(Theme.getColor(i2));
        RecyclerListViewEdited recyclerListViewEdited = new RecyclerListViewEdited(context);
        this.listView = recyclerListViewEdited;
        recyclerListViewEdited.setLayoutManager(new LinearLayoutManager(this, context, 1, false) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoNewEventActivity.2
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
        this.listView.setEmptyView(new RubinoEmptyView(context, 17));
        this.listView.setBackgroundColor(Theme.getColor(i2));
        PullToRefreshLayout pullToRefreshLayout = new PullToRefreshLayout(context);
        this.swipeRefreshLayout = pullToRefreshLayout;
        frameLayout2.addView(pullToRefreshLayout, LayoutHelper.createFrame(-1, -1, 51));
        this.swipeRefreshLayout.bindListViewToLayout(this.listView);
        frameLayout2.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f));
        this.listView.setAdapter(this.listAdapter);
        this.listView.setOnItemClickListener(new RecyclerListViewEdited.OnItemClickListenerExtended() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoNewEventActivity$$ExternalSyntheticLambda0
            @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited.OnItemClickListenerExtended
            public final void onItemClick(View view, int i3, float f, float f2) {
                RubinoNewEventActivity.lambda$createView$0(view, i3, f, f2);
            }
        });
        PullToRefreshLayout pullToRefreshLayout2 = this.swipeRefreshLayout;
        if (pullToRefreshLayout2 != null) {
            pullToRefreshLayout2.setEnabled(true);
            this.swipeRefreshLayout.setRefreshListener(this.onRefreshListener);
        }
        this.hasContinue = true;
        String string = LocaleController.getString(R.string.rubinoRequestNotifTitle);
        String string2 = LocaleController.getString(R.string.rubinoRequestNotifText);
        String str = string + "\n" + string2;
        int iIndexOf = str.indexOf(string2);
        SpannableString spannableStringMakeWithColorAndRelativeSize = SpanHelper.makeWithColorAndRelativeSize(new SpannableString(str), 0, string.length(), Theme.getColor(Theme.key_rubinoBlackColor), 1.1f);
        this.requestSpannableString = spannableStringMakeWithColorAndRelativeSize;
        this.requestSpannableString = SpanHelper.makeWithColorAndRelativeSize(spannableStringMakeWithColorAndRelativeSize, iIndexOf, str.length(), Theme.getColor(Theme.key_rubinoGrayColor), 1.0f);
        updateRows();
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createView$0(View view, int i, float f, float f2) {
        if (view instanceof NewEventCell) {
            ((NewEventCell) view).handleClick(f, f2);
        }
    }

    void updateRows() {
        updateRows(true);
    }

    void updateRows(boolean z) {
        ListAdapter listAdapter;
        this.arrayStartRow = -1;
        this.emptyViewRow = -1;
        this.arrayEndRow = -1;
        this.loadingRow = -1;
        this.eventTitleRow = -1;
        this.retryRow = -1;
        this.requestNumberRow = -1;
        this.loadMorePosition = Math.max(0, this.eventArray.size() - 15);
        this.rowCount = 0;
        RubinoProfileObject rubinoCurrentProfileObject = AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject();
        if (this.type == eventType && rubinoCurrentProfileObject.isPrivate()) {
            int i = this.rowCount;
            this.rowCount = i + 1;
            this.requestNumberRow = i;
        }
        if (this.needToRetry) {
            int i2 = this.rowCount;
            this.rowCount = i2 + 1;
            this.retryRow = i2;
        } else {
            if (this.eventArray.size() > 0) {
                if (this.requestNumberRow >= 0) {
                    int i3 = this.rowCount;
                    this.rowCount = i3 + 1;
                    this.eventTitleRow = i3;
                }
                int i4 = this.rowCount;
                this.arrayStartRow = i4;
                int size = i4 + this.eventArray.size();
                this.rowCount = size;
                this.arrayEndRow = size;
            }
            if (this.hasContinue) {
                int i5 = this.rowCount;
                this.rowCount = i5 + 1;
                this.loadingRow = i5;
            } else if (this.eventArray.size() == 0 && this.requestNumberRow < 0) {
                int i6 = this.rowCount;
                this.rowCount = i6 + 1;
                this.emptyViewRow = i6;
            }
        }
        if (!z || (listAdapter = this.listAdapter) == null) {
            return;
        }
        listAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRowsOnAddEvent() {
        if (this.arrayStartRow < 0 || this.eventArray.size() <= 0) {
            updateRows();
            return;
        }
        this.loadMorePosition = Math.max(0, this.eventArray.size() - 15);
        int i = this.rowCount;
        int i2 = this.arrayStartRow;
        this.rowCount = i2;
        int size = i2 + this.eventArray.size();
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
            if (i5 - i3 > 0) {
                this.listAdapter.notifyItemRangeInserted(i3 + 1, i5 - i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getEvents(final boolean z, final boolean z2) {
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
                    DisposableObserver disposableObserver3 = (DisposableObserver) Observable.timer(500L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Long>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoNewEventActivity.4
                        @Override // io.reactivex.Observer
                        public void onNext(Long l) {
                            if (RubinoNewEventActivity.this.swipeRefreshLayout != null) {
                                RubinoNewEventActivity.this.swipeRefreshLayout.setRefreshing(false, true);
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
            Observable<Rubino.NewEventsListObject> requestObservable = null;
            if (i == eventType) {
                requestObservable = getRubinoController().getNewEventObservable(z ? null : this.maxId, 50);
            } else if (i == requestType) {
                requestObservable = getRubinoController().getRequestObservable(z ? null : this.maxId, 50);
            }
            DisposableObserver disposableObserver8 = (DisposableObserver) requestObservable.observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Rubino.NewEventsListObject>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoNewEventActivity.5
                @Override // io.reactivex.Observer
                public void onNext(Rubino.NewEventsListObject newEventsListObject) {
                    ArrayList<Rubino.NewEventObject> arrayList;
                    RubinoNewEventActivity.this.swipeRefreshLayout.setRefreshing(false, true);
                    if (z && z2) {
                        RubinoNewEventActivity.this.lastManualRefreshTime = System.currentTimeMillis();
                    }
                    if (newEventsListObject == null || (arrayList = newEventsListObject.events) == null || arrayList.size() <= 0) {
                        RubinoNewEventActivity.this.hasContinue = false;
                    } else {
                        RubinoNewEventActivity rubinoNewEventActivity = RubinoNewEventActivity.this;
                        ArrayList<Rubino.NewEventObject> arrayList2 = newEventsListObject.events;
                        rubinoNewEventActivity.maxId = arrayList2.get(arrayList2.size() - 1).event.id;
                        if (z) {
                            RubinoNewEventActivity.this.eventArray.clear();
                        }
                        RubinoNewEventActivity.this.eventArray.addAll(newEventsListObject.events);
                    }
                    if (!z) {
                        RubinoNewEventActivity.this.updateRowsOnAddEvent();
                    } else {
                        RubinoNewEventActivity.this.updateRows();
                    }
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                    RubinoNewEventActivity.this.swipeRefreshLayout.setRefreshing(false, true);
                    dispose();
                    if (RubinoNewEventActivity.this.eventArray.size() == 0) {
                        RubinoNewEventActivity.this.needToRetry = true;
                    }
                    RubinoNewEventActivity.this.updateRows();
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

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        String str;
        Rubino.ActionOnRequestTypeEnum actionOnRequestTypeEnum;
        NewEventCell newEventCell;
        int i3;
        String str2;
        NewEventCell newEventCell2;
        int i4;
        ArrayList<RubinoProfileObject> arrayList;
        int iIndexOf = -1;
        if (i == NotificationCenter.rubinoNewEventDeleted) {
            String str3 = (String) objArr[0];
            Iterator<Rubino.NewEventObject> it = this.eventArray.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Rubino.NewEventObject next = it.next();
                if (next.event.id.equals(str3)) {
                    iIndexOf = this.eventArray.indexOf(next);
                    break;
                }
            }
            if (iIndexOf >= 0) {
                this.eventArray.remove(iIndexOf);
                updateRows(false);
                this.listAdapter.notifyItemRemoved(this.arrayStartRow + iIndexOf);
                return;
            }
            return;
        }
        if (i == NotificationCenter.rubinoFollowBlockChanged) {
            int childCount = this.listView.getChildCount();
            String str4 = (String) objArr[0];
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = this.listView.getChildAt(i5);
                if ((childAt instanceof NewEventCell) && (((i4 = (newEventCell2 = (NewEventCell) childAt).type) == NewEventCell.eventType || i4 == NewEventCell.requestType) && (arrayList = newEventCell2.currentEvent.event.owners) != null && arrayList.size() > 0 && newEventCell2.currentEvent.event.owners.get(0).id.equals(str4))) {
                    newEventCell2.setButtons();
                }
            }
            return;
        }
        if (i != NotificationCenter.rubinoRequestAnswered || (actionOnRequestTypeEnum = getRubinoController().actionOnRequestMap.get((str = (String) objArr[0]))) == null) {
            return;
        }
        if (actionOnRequestTypeEnum == Rubino.ActionOnRequestTypeEnum.Accept) {
            int childCount2 = this.listView.getChildCount();
            for (int i6 = 0; i6 < childCount2; i6++) {
                View childAt2 = this.listView.getChildAt(i6);
                if ((childAt2 instanceof NewEventCell) && ((i3 = (newEventCell = (NewEventCell) childAt2).type) == NewEventCell.eventType || i3 == NewEventCell.requestType)) {
                    Rubino.NewEventFromServerObject newEventFromServerObject = newEventCell.currentEvent.event;
                    if (newEventFromServerObject.model == Rubino.NotifEnum.Request && (str2 = newEventFromServerObject.request_id) != null && str2.equals(str)) {
                        newEventCell.setButtons();
                    }
                }
            }
            return;
        }
        if (actionOnRequestTypeEnum == Rubino.ActionOnRequestTypeEnum.Decline) {
            Iterator<Rubino.NewEventObject> it2 = this.eventArray.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Rubino.NewEventObject next2 = it2.next();
                String str5 = next2.event.request_id;
                if (str5 != null && str5.equals(str)) {
                    iIndexOf = this.eventArray.indexOf(next2);
                    break;
                }
            }
            if (iIndexOf >= 0) {
                this.eventArray.remove(iIndexOf);
                updateRows(false);
                this.listAdapter.notifyItemRemoved(this.arrayStartRow + iIndexOf);
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
            View view = viewHolder.itemView;
            return (view instanceof NewEventCell) || (view instanceof RubinoRetryView);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return RubinoNewEventActivity.this.rowCount;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view;
            View rubinoLoadingCell;
            if (i == 0) {
                final NewEventCell newEventCell = new NewEventCell(this.mContext);
                newEventCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
                newEventCell.setLongClick(new View.OnLongClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoNewEventActivity.ListAdapter.2
                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view2) {
                        Rubino.NewEventObject newEventObject;
                        NewEventCell newEventCell2 = newEventCell;
                        if (newEventCell2.type != NewEventCell.eventType || (newEventObject = newEventCell2.currentEvent) == null || newEventObject.event == null) {
                            return false;
                        }
                        int i2 = ((BaseFragment) RubinoNewEventActivity.this).currentAccount;
                        Context context = RubinoNewEventActivity.this.context;
                        CompositeDisposable compositeDisposable = RubinoNewEventActivity.this.compositeDisposable;
                        Rubino.NewEventFromServerObject newEventFromServerObject = newEventCell.currentEvent.event;
                        RubinoController.removeNewEvent(i2, context, compositeDisposable, newEventFromServerObject.id, newEventFromServerObject.profile_id);
                        return true;
                    }
                });
                view = newEventCell;
            } else {
                if (i == 4) {
                    View rubinoEmptyView = new RubinoEmptyView(this.mContext, 1);
                    rubinoEmptyView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    rubinoLoadingCell = rubinoEmptyView;
                } else if (i == 5) {
                    RubinoRetryView rubinoRetryView = new RubinoRetryView(this.mContext);
                    rubinoRetryView.setData(R.drawable.rubino_loadmore_icon_refresh);
                    rubinoRetryView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoNewEventActivity.ListAdapter.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            RubinoNewEventActivity.this.needToRetry = false;
                            RubinoNewEventActivity.this.updateRows();
                        }
                    });
                    rubinoRetryView.setBackgroundColor(-1);
                    rubinoRetryView.setLayoutParams(new RecyclerView.LayoutParams(-1, AndroidUtilities.dp(80.0f)));
                    ((LinearLayout.LayoutParams) rubinoRetryView.imageView.getLayoutParams()).topMargin = AndroidUtilities.dp(4.0f);
                    rubinoLoadingCell = rubinoRetryView;
                } else if (i == 6) {
                    View rubinoNewEventTitleCell = new RubinoNewEventTitleCell(this.mContext);
                    rubinoNewEventTitleCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
                    view = rubinoNewEventTitleCell;
                } else {
                    rubinoLoadingCell = new RubinoLoadingCell(this.mContext, false);
                }
                return new RecyclerListViewEdited.Holder(rubinoLoadingCell);
            }
            rubinoLoadingCell = view;
            return new RecyclerListViewEdited.Holder(rubinoLoadingCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            String string;
            int i2;
            MyLog.e("List Status", "onBind: " + viewHolder.getAdapterPosition());
            int itemViewType = viewHolder.getItemViewType();
            if (itemViewType == 0) {
                NewEventCell newEventCell = (NewEventCell) viewHolder.itemView;
                if (i < RubinoNewEventActivity.this.arrayStartRow || i >= RubinoNewEventActivity.this.arrayEndRow) {
                    if (i == RubinoNewEventActivity.this.requestNumberRow) {
                        newEventCell.setRequestNumber(RubinoNewEventActivity.this.requestSpannableString, AppRubinoPreferences.getInstance(((BaseFragment) RubinoNewEventActivity.this).currentAccount).getRubinoCurrentProfileObject().new_follow_request_count, ((BaseFragment) RubinoNewEventActivity.this).classGuid);
                    }
                } else {
                    try {
                        Rubino.NewEventObject newEventObject = (Rubino.NewEventObject) RubinoNewEventActivity.this.eventArray.get(i - RubinoNewEventActivity.this.arrayStartRow);
                        if (RubinoNewEventActivity.this.type == RubinoNewEventActivity.eventType) {
                            newEventCell.setEvent(newEventObject, ((BaseFragment) RubinoNewEventActivity.this).classGuid);
                        } else if (RubinoNewEventActivity.this.type == RubinoNewEventActivity.requestType) {
                            newEventCell.setRequest(newEventObject, ((BaseFragment) RubinoNewEventActivity.this).classGuid);
                        }
                    } catch (Exception e) {
                        CrashHandelHelper.handleCrashOnMyLog(e);
                        MyLog.handleException(e);
                    }
                }
            } else if (itemViewType != 4) {
                if (itemViewType == 6 && i == RubinoNewEventActivity.this.eventTitleRow) {
                    ((RubinoNewEventTitleCell) viewHolder.itemView).setText(LocaleController.getString(R.string.rubinoNewEvents));
                }
            } else {
                RubinoEmptyView rubinoEmptyView = (RubinoEmptyView) viewHolder.itemView;
                int i3 = RubinoNewEventActivity.this.type;
                int i4 = RubinoNewEventActivity.eventType;
                String string2 = BuildConfig.FLAVOR;
                if (i3 != i4) {
                    if (RubinoNewEventActivity.this.type == RubinoNewEventActivity.requestType) {
                        string2 = LocaleController.getString(R.string.rubinoNoRequest);
                        string = LocaleController.getString(R.string.rubinoNoRequestInfo);
                        i2 = R.drawable.rubino_empty_state_follow;
                    } else {
                        string = BuildConfig.FLAVOR;
                        i2 = 0;
                    }
                } else {
                    string2 = LocaleController.getString(R.string.rubinoNoEvent);
                    string = LocaleController.getString(R.string.rubinoNoEventInfo);
                    i2 = R.drawable.rubino_empty_state_heart;
                }
                rubinoEmptyView.setData(i2, string2, string);
            }
            if (RubinoNewEventActivity.this.hasContinue) {
                if (i == RubinoNewEventActivity.this.loadMorePosition || i == RubinoNewEventActivity.this.loadingRow) {
                    RubinoNewEventActivity.this.getEvents(false, false);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if ((i >= RubinoNewEventActivity.this.arrayStartRow && i < RubinoNewEventActivity.this.arrayEndRow) || i == RubinoNewEventActivity.this.requestNumberRow) {
                return 0;
            }
            if (i == RubinoNewEventActivity.this.loadingRow) {
                return 1;
            }
            if (i == RubinoNewEventActivity.this.emptyViewRow) {
                return 4;
            }
            if (i == RubinoNewEventActivity.this.retryRow) {
                return 5;
            }
            return i == RubinoNewEventActivity.this.eventTitleRow ? 6 : 0;
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
