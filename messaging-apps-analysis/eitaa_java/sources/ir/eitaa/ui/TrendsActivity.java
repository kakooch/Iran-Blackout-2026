package ir.eitaa.ui;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.helper.live.LiveHelper;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ImageLoader;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.browser.Browser;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Ads_Ad;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$TL_ads_AdPack;
import ir.eitaa.tgnet.TLRPC$TL_ads_getAdsPack;
import ir.eitaa.tgnet.TLRPC$TL_ads_inputAdsLocationTrends;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_get_trends;
import ir.eitaa.tgnet.TLRPC$TL_updateTrends;
import ir.eitaa.tgnet.TLRPC$Trend;
import ir.eitaa.tgnet.TLRPC$TrendGroup;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Cells.EmptyCell;
import ir.eitaa.ui.Cells.HeaderCell;
import ir.eitaa.ui.Cells.ShadowSectionCell;
import ir.eitaa.ui.Cells.TextCheckCell;
import ir.eitaa.ui.Cells.TextDetailSettingsCell;
import ir.eitaa.ui.Cells.TextInfoCell;
import ir.eitaa.ui.Cells.TextSettingsCell;
import ir.eitaa.ui.Components.EmptyTextProgressView;
import ir.eitaa.ui.Components.HotLiveList;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.Components.SearchViewPager;
import ir.eitaa.ui.Components.SimpleAdsList;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class TrendsActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private SimpleAdsList adsList;
    private RecyclerListView hashtagListView;
    private HashtagListAdapter hashtagsAdapter;
    private EmptyTextProgressView hashtagsProgressView;
    private HotLiveList hotliveList;
    private long getTrendsReqId = -1;
    private TLRPC$TL_updateTrends trends = null;
    private String adTitle = "";
    private ArrayList<TLRPC$Ads_Ad> loadedAds = new ArrayList<>();
    private List<TLRPC$Chat> loadedLiveChats = new ArrayList();
    private CountDownLatch syncLatch = null;

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.liveChatsNeedReload);
        return true;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() throws InterruptedException {
        if (this.getTrendsReqId != -1) {
            ConnectionsManager.getInstance(this.currentAccount).cancelRequest(this.getTrendsReqId, false);
        }
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.liveChatsNeedReload);
        super.onFragmentDestroy();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setAllowOverlayTitle(false);
        this.actionBar.setTitle(LocaleController.getString("Whatshot", R.string.Whatshot));
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.eitaa.ui.TrendsActivity.1
            @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int id) {
                if (id == -1) {
                    TrendsActivity.this.finishFragment();
                }
            }
        });
        FrameLayout frameLayout = new FrameLayout(context);
        EmptyTextProgressView emptyTextProgressView = new EmptyTextProgressView(context);
        this.hashtagsProgressView = emptyTextProgressView;
        emptyTextProgressView.setText(LocaleController.getString("NoResult", R.string.NoResult));
        frameLayout.addView(this.hashtagsProgressView, LayoutHelper.createFrame(-1, -1.0f));
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.hashtagListView = recyclerListView;
        recyclerListView.setLayoutManager(new LinearLayoutManager(context, 1, false));
        this.hashtagListView.setEmptyView(this.hashtagsProgressView);
        this.hashtagListView.setVerticalScrollBarEnabled(false);
        RecyclerListView recyclerListView2 = this.hashtagListView;
        HashtagListAdapter hashtagListAdapter = new HashtagListAdapter();
        this.hashtagsAdapter = hashtagListAdapter;
        recyclerListView2.setAdapter(hashtagListAdapter);
        this.hashtagListView.setVerticalScrollbarPosition(LocaleController.isRTL ? 1 : 2);
        this.hashtagListView.setGlowColor(Theme.getColor("avatar_backgroundActionBarBlue"));
        this.hashtagListView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.TrendsActivity.2
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public void onItemClick(View view, int position) {
                if (view instanceof TextSettingsCell) {
                    String string = ((TextSettingsCell) view).getTextView().getText().toString();
                    DialogsActivity dialogsActivity = new DialogsActivity(null);
                    dialogsActivity.setSearchString(string);
                    SearchViewPager.globalSearch = true;
                    SearchViewPager.trendString = string;
                    TrendsActivity.this.presentFragment(dialogsActivity);
                }
            }
        });
        frameLayout.addView(this.hashtagListView, LayoutHelper.createFrame(-1, -1, 48));
        this.fragmentView = frameLayout;
        frameLayout.setBackgroundColor(Theme.getColor("windowBackgroundGray"));
        new Thread(new Runnable() { // from class: ir.eitaa.ui.TrendsActivity.3
            @Override // java.lang.Runnable
            public void run() throws InterruptedException {
                TrendsActivity.this.syncLatch = new CountDownLatch(2);
                TrendsActivity.this.loadTrends();
                TrendsActivity.this.loadAds();
                TrendsActivity.this.loadLiveChats();
                Log.v("trendd", "await sync latch");
                try {
                    TrendsActivity.this.syncLatch.await(60L, TimeUnit.SECONDS);
                } catch (InterruptedException unused) {
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.TrendsActivity.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            TrendsActivity.this.finishFragment();
                        }
                    });
                }
                Log.v("trendd", "sync latch done");
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.TrendsActivity.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        TrendsActivity.this.updateRows();
                    }
                });
            }
        }).start();
        this.hashtagsProgressView.showProgress();
        this.actionBar.setSubtitle(LocaleController.getString("Updating", R.string.Updating));
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRows() {
        TLRPC$TL_updateTrends tLRPC$TL_updateTrends = this.trends;
        if (tLRPC$TL_updateTrends != null) {
            this.actionBar.setSubtitle(LocaleController.formatTrendsDate(tLRPC$TL_updateTrends.date));
            this.hashtagsProgressView.showTextView();
            this.hashtagsAdapter.setItems(this.trends.trendGroups);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadTrends() {
        Log.v("trendd", "loadTrends()");
        new TLRPC$TL_get_trends().lang = Locale.getDefault().getLanguage().toLowerCase();
        this.getTrendsReqId = ConnectionsManager.getInstance(this.currentAccount).sendRequest(r0, new RequestDelegate() { // from class: ir.eitaa.ui.TrendsActivity.4
            @Override // ir.eitaa.tgnet.RequestDelegate
            public void run(TLObject response, TLRPC$TL_error error) {
                Log.v("trendd", "loadTrends() response: " + response);
                TrendsActivity.this.getTrendsReqId = 0L;
                if (error == null) {
                    TrendsActivity.this.trends = (TLRPC$TL_updateTrends) response;
                    TrendsActivity.this.syncLatch.countDown();
                }
            }
        }, 2);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment, ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        if (id == NotificationCenter.liveChatsNeedReload) {
            loadLiveChats();
            HotLiveList hotLiveList = this.hotliveList;
            if (hotLiveList != null) {
                hotLiveList.showChats(this.loadedLiveChats);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void loadLiveChats() {
        Log.v("trendd", "loadLiveChats()");
        this.loadedLiveChats.clear();
        ArrayList arrayList = new ArrayList();
        ConcurrentHashMap<Integer, TLRPC$Chat> concurrentHashMap = MessagesController.getInstance(this.currentAccount).livechats;
        Iterator it = concurrentHashMap.keySet().iterator();
        while (it.hasNext()) {
            arrayList.add((TLRPC$Chat) concurrentHashMap.get((Integer) it.next()));
        }
        this.loadedLiveChats.addAll(arrayList);
        Log.v("trendd", "loadLiveChats() chats: " + arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAds() {
        Log.v("trendd", "loadAds()");
        TLRPC$TL_ads_getAdsPack tLRPC$TL_ads_getAdsPack = new TLRPC$TL_ads_getAdsPack();
        TLRPC$TL_ads_inputAdsLocationTrends tLRPC$TL_ads_inputAdsLocationTrends = new TLRPC$TL_ads_inputAdsLocationTrends();
        tLRPC$TL_ads_getAdsPack.location = tLRPC$TL_ads_inputAdsLocationTrends;
        tLRPC$TL_ads_inputAdsLocationTrends.groupTitle = "";
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_ads_getAdsPack, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$TrendsActivity$UCt3y06C83Iu_u2Avdl-Ej0uklA
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadAds$0$TrendsActivity(tLObject, tLRPC$TL_error);
            }
        }, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadAds$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadAds$0$TrendsActivity(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        Log.v("trendd", "loadAds() response: " + tLObject);
        if (tLRPC$TL_error == null) {
            TLRPC$TL_ads_AdPack tLRPC$TL_ads_AdPack = (TLRPC$TL_ads_AdPack) tLObject;
            ArrayList arrayList = new ArrayList();
            Iterator<TLRPC$Ads_Ad> it = tLRPC$TL_ads_AdPack.ads.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            ImageLoader.saveAdsThumbs(arrayList);
            if (arrayList.size() != 0) {
                this.loadedAds.addAll(arrayList);
                this.adTitle = tLRPC$TL_ads_AdPack.title;
            }
        }
        this.syncLatch.countDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    class HashtagListAdapter extends RecyclerListView.SelectionAdapter {
        private List<Object> items;

        private HashtagListAdapter() {
            this.items = new ArrayList();
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            return holder.getItemViewType() == 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View shadowSectionCell;
            final Context context = parent.getContext();
            if (viewType == 0) {
                shadowSectionCell = new HeaderCell(context);
                shadowSectionCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
            } else if (viewType == 1) {
                shadowSectionCell = new TextSettingsCell(context);
                shadowSectionCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
            } else if (viewType == 2) {
                shadowSectionCell = new ShadowSectionCell(context);
            } else if (viewType == 3) {
                TrendsActivity.this.adsList = new SimpleAdsList(context);
                TrendsActivity.this.adsList.setDelegate(new SimpleAdsList.Delegate() { // from class: ir.eitaa.ui.-$$Lambda$TrendsActivity$HashtagListAdapter$GpHWxKippQY8H5NBuROMTPMPbvk
                    @Override // ir.eitaa.ui.Components.SimpleAdsList.Delegate
                    public final void onAdClicked(TLRPC$Ads_Ad tLRPC$Ads_Ad) {
                        this.f$0.lambda$onCreateViewHolder$0$TrendsActivity$HashtagListAdapter(context, tLRPC$Ads_Ad);
                    }
                });
                TrendsActivity.this.adsList.location = new TLRPC$TL_ads_inputAdsLocationTrends();
                shadowSectionCell = TrendsActivity.this.adsList;
                TrendsActivity.this.adsList.showAds(TrendsActivity.this.loadedAds);
                TrendsActivity.this.adsList.setTitle(TrendsActivity.this.adTitle);
            } else if (viewType == 4) {
                TrendsActivity.this.hotliveList = new HotLiveList(context);
                TrendsActivity.this.hotliveList.setDelegate(new HotLiveList.Delegate() { // from class: ir.eitaa.ui.TrendsActivity.HashtagListAdapter.1
                    @Override // ir.eitaa.ui.Components.HotLiveList.Delegate
                    public void onClickedItem(TLRPC$Chat chat) {
                        long j = MessagesController.getInstance(((BaseFragment) TrendsActivity.this).currentAccount).liveStreamId;
                        long j2 = MessagesController.getInstance(((BaseFragment) TrendsActivity.this).currentAccount).liveDialogId;
                        int i = MessagesController.getInstance(((BaseFragment) TrendsActivity.this).currentAccount).liveDialogMsgId;
                        int i2 = chat.live_stream_msg_id;
                        if (i2 != 0 && i2 == i && j2 == (-chat.id)) {
                            LiveHelper.startLive(TrendsActivity.this.getParentActivity(), j2, i);
                        } else {
                            LiveVideoViewer.getInstance().setParentActivity(TrendsActivity.this.getParentActivity());
                            LiveVideoViewer.getInstance().openPhoto((int) chat.id, 0, 0);
                        }
                    }
                });
                shadowSectionCell = TrendsActivity.this.hotliveList;
                TrendsActivity.this.hotliveList.showChats(TrendsActivity.this.loadedLiveChats);
            } else {
                shadowSectionCell = null;
            }
            return new RecyclerListView.Holder(shadowSectionCell);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onCreateViewHolder$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onCreateViewHolder$0$TrendsActivity$HashtagListAdapter(Context context, TLRPC$Ads_Ad tLRPC$Ads_Ad) {
            Browser.performAdAction(context, tLRPC$Ads_Ad, TrendsActivity.this);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            int itemViewType = holder.getItemViewType();
            View view = holder.itemView;
            if (itemViewType == 3) {
                ((SimpleAdsList) view).setIndex(position / 2);
                return;
            }
            if (itemViewType == 4) {
                return;
            }
            Object obj = this.items.get(position);
            if (itemViewType == 0) {
                ((HeaderCell) view).setText((String) obj);
                return;
            }
            if (itemViewType == 1) {
                TLRPC$Trend tLRPC$Trend = (TLRPC$Trend) obj;
                if (tLRPC$Trend.count != 0) {
                    ((TextSettingsCell) view).setTextAndValue("#" + tLRPC$Trend.hashtag, "+" + String.valueOf(tLRPC$Trend.count), true);
                    return;
                }
                ((TextSettingsCell) view).setTextAndValue("#" + tLRPC$Trend.hashtag, "", true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.items.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            Object obj = this.items.get(position);
            if (obj == null) {
                return 2;
            }
            if (obj instanceof String) {
                return 0;
            }
            if (obj instanceof TLRPC$Trend) {
                return 1;
            }
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            return 0;
        }

        public void setItems(List<TLRPC$TrendGroup> groups) {
            this.items.clear();
            if (TrendsActivity.this.loadedLiveChats.size() == 0) {
                if (TrendsActivity.this.loadedAds.size() != 0) {
                    this.items.add(3);
                    this.items.add(null);
                }
            } else {
                this.items.add(4);
            }
            for (int i = 0; i < groups.size(); i++) {
                TLRPC$TrendGroup tLRPC$TrendGroup = groups.get(i);
                this.items.add(tLRPC$TrendGroup.title);
                this.items.addAll(tLRPC$TrendGroup.trends);
                this.items.add(null);
                if (i == 0 && TrendsActivity.this.loadedAds.size() != 0 && TrendsActivity.this.loadedLiveChats.size() != 0) {
                    this.items.add(3);
                    this.items.add(null);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.hashtagListView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{EmptyCell.class, TextSettingsCell.class, TextCheckCell.class, HeaderCell.class, TextInfoCell.class, TextDetailSettingsCell.class}, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundGray"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "avatar_backgroundActionBarBlue"));
        arrayList.add(new ThemeDescription(this.hashtagListView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, "avatar_backgroundActionBarBlue"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "avatar_actionBarIconBlue"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, "actionBarDefaultTitle"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "avatar_actionBarSelectorBlue"));
        arrayList.add(new ThemeDescription(this.hashtagsProgressView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "emptyListPlaceholder"));
        arrayList.add(new ThemeDescription(this.hashtagsProgressView, ThemeDescription.FLAG_PROGRESSBAR, null, null, null, null, "progressCircle"));
        arrayList.add(new ThemeDescription(this.hashtagListView, 0, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.hashtagListView, 0, new Class[]{TextSettingsCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteValueText"));
        arrayList.add(new ThemeDescription(this.hashtagListView, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueHeader"));
        return arrayList;
    }
}
