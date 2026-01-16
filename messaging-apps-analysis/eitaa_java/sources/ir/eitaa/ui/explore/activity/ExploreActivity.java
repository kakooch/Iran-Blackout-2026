package ir.eitaa.ui.explore.activity;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Build;
import android.text.style.CharacterStyle;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import ir.eitaa.helper.live.LiveHelper;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ImageLoader;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.MessagesStorage;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.browser.Browser;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Ads_Ad;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$InputPeer;
import ir.eitaa.tgnet.TLRPC$KeyboardButton;
import ir.eitaa.tgnet.TLRPC$TL_ads_AdPack;
import ir.eitaa.tgnet.TLRPC$TL_ads_getAdsPack;
import ir.eitaa.tgnet.TLRPC$TL_ads_inputAdsLocationTrends;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_get_trends;
import ir.eitaa.tgnet.TLRPC$TL_inputPeerEmpty;
import ir.eitaa.tgnet.TLRPC$TL_messages_searchGlobalExt;
import ir.eitaa.tgnet.TLRPC$TL_reactionCount;
import ir.eitaa.tgnet.TLRPC$TL_updateTrends;
import ir.eitaa.tgnet.TLRPC$Trend;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$messages_Messages;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.BackDrawable;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Cells.TextSelectionHelper;
import ir.eitaa.ui.Components.AlertsCreator;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.Components.SimpleAdsList;
import ir.eitaa.ui.LiveVideoViewer;
import ir.eitaa.ui.PinchToZoomHelper;
import ir.eitaa.ui.TrendsActivity;
import ir.eitaa.ui.explore.adapter.HashtagAdapter;
import ir.eitaa.ui.explore.cells.ExploreCell;
import ir.eitaa.ui.explore.cells.LivesLayout;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class ExploreActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private ExploreAdpter adapter;
    private RecyclerListView.SelectionAdapter hashtagAdapter;
    private RecyclerView listView;
    private LivesLayout livesLayout;
    private ProgressBar loadingView;
    private ArrayList<String> hashtags = new ArrayList<>();
    private ArrayList<TLRPC$Ads_Ad> loadedAds = new ArrayList<>();
    private long getTrendsReqId = -1;
    private ArrayList<TLRPC$Trend> trends = null;
    private ArrayList<MessageObject> messages = new ArrayList<>();
    public SparseArray<MessageObject> messagesById = new SparseArray<>();
    public ArrayList<String> sections = new ArrayList<>();
    public HashMap<String, ArrayList<MessageObject>> sectionArrays = new HashMap<>();
    public ArrayList<Integer> categoriesId = new ArrayList<>();
    private CountDownLatch syncLatch = null;
    private int reqId = 0;
    private SparseArray<MessageObject> messagesDict = new SparseArray<>();
    private boolean endReached = false;
    private TLRPC$InputPeer peer = new TLRPC$TL_inputPeerEmpty();

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.liveChatsNeedReload);
        return true;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        getParentActivity().setRequestedOrientation(1);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() throws InterruptedException {
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.liveChatsNeedReload);
        getParentActivity().setRequestedOrientation(2);
        super.onFragmentDestroy();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(final Context context) {
        this.actionBar.setTitle("کاوش");
        this.actionBar.setBackButtonDrawable(new BackDrawable(false));
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.eitaa.ui.explore.activity.ExploreActivity.1
            @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int id) {
                if (id == -1) {
                    ExploreActivity.this.finishFragment();
                } else if (id == 10) {
                    Toast.makeText(context, "Searching...", 0).show();
                    ExploreActivity.this.search();
                }
            }
        });
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        frameLayout.setBackgroundColor(Theme.getColor("windowBackgroundGray"));
        frameLayout.setLayoutParams(LayoutHelper.createFrame(-1, -1.0f));
        LivesLayout livesLayout = new LivesLayout(context);
        this.livesLayout = livesLayout;
        livesLayout.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.explore.activity.ExploreActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (ExploreActivity.this.livesLayout.lives.size() == 1) {
                    TLRPC$Chat tLRPC$Chat = ExploreActivity.this.livesLayout.lives.get(0);
                    long j = MessagesController.getInstance(((BaseFragment) ExploreActivity.this).currentAccount).liveDialogId;
                    int i = MessagesController.getInstance(((BaseFragment) ExploreActivity.this).currentAccount).liveDialogMsgId;
                    int i2 = tLRPC$Chat.live_stream_msg_id;
                    if (i2 != 0 && i2 == i && j == (-tLRPC$Chat.id)) {
                        LiveHelper.startLive(ExploreActivity.this.getParentActivity(), j, i);
                        return;
                    } else {
                        LiveVideoViewer.getInstance().setParentActivity(ExploreActivity.this.getParentActivity());
                        LiveVideoViewer.getInstance().openPhoto((int) tLRPC$Chat.id, 0, 0);
                        return;
                    }
                }
                if (ExploreActivity.this.livesLayout.lives.isEmpty()) {
                    return;
                }
                AlertsCreator.showLivesDialog(ExploreActivity.this.getParentActivity(), ExploreActivity.this.livesLayout.lives);
            }
        });
        int i = Build.VERSION.SDK_INT;
        this.actionBar.addView(this.livesLayout, 0, LayoutHelper.createFrame(200, 40.0f, 53, 0.0f, 8.0f + AndroidUtilities.pxToDp(i >= 21 ? AndroidUtilities.statusBarHeight : 0), 8.0f, 0.0f));
        this.hashtagAdapter = new HashtagAdapter(this.hashtags, context, new HashtagAdapter.OnItemClicked() { // from class: ir.eitaa.ui.explore.activity.ExploreActivity.3
            @Override // ir.eitaa.ui.explore.adapter.HashtagAdapter.OnItemClicked
            public void onItemClicked(int position) {
                if (position == ExploreActivity.this.hashtags.size()) {
                    ExploreActivity.this.presentFragment(new TrendsActivity());
                    return;
                }
                ExploreActivity.this.presentFragment(new KavoshActivity("#" + ((String) ExploreActivity.this.hashtags.get(position))));
            }
        });
        this.listView = new RecyclerView(context);
        ExploreAdpter exploreAdpter = new ExploreAdpter(context);
        this.adapter = exploreAdpter;
        this.listView.setAdapter(exploreAdpter);
        this.listView.setLayoutManager(new StaggeredGridLayoutManager(2, 1));
        frameLayout.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f, 17, 0.0f, 0.0f, 0.0f, 0.0f));
        ProgressBar progressBar = new ProgressBar(context, null, R.attr.progressBarStyleHorizontal);
        this.loadingView = progressBar;
        progressBar.setIndeterminate(true);
        if (i >= 21) {
            this.loadingView.setIndeterminateTintList(ColorStateList.valueOf(Theme.getColor("chats_actionBackground")));
        }
        this.loadingView.setPadding(0, 0, 0, 0);
        frameLayout.addView(this.loadingView, LayoutHelper.createFrame(-1, -2, 80));
        search();
        new Thread(new Runnable() { // from class: ir.eitaa.ui.explore.activity.ExploreActivity.4
            @Override // java.lang.Runnable
            public void run() throws InterruptedException {
                ExploreActivity.this.syncLatch = new CountDownLatch(2);
                ExploreActivity.this.loadTrends();
                ExploreActivity.this.loadAds();
                ExploreActivity.this.loadLiveChats();
                Log.v("trendd", "await sync latch");
                try {
                    ExploreActivity.this.syncLatch.await(60L, TimeUnit.SECONDS);
                } catch (InterruptedException unused) {
                }
                Log.v("trendd", "sync latch done");
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.explore.activity.ExploreActivity.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                    }
                });
            }
        }).start();
        this.livesLayout.setLives(loadLiveChats());
        return frameLayout;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment, ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        if (id == NotificationCenter.liveChatsNeedReload) {
            this.livesLayout.setLives(loadLiveChats());
        }
    }

    public void search() {
        updateLoadingState(true);
        Toast.makeText(getParentActivity(), "Searching...", 0).show();
        final int i = UserConfig.selectedAccount;
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.explore.activity.-$$Lambda$ExploreActivity$C6JWJ4nxfLL_R3kEmP8EeSSujHY
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$search$6$ExploreActivity(i);
            }
        }, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$search$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$search$6$ExploreActivity(final int i) {
        TLRPC$TL_messages_searchGlobalExt tLRPC$TL_messages_searchGlobalExt = new TLRPC$TL_messages_searchGlobalExt();
        tLRPC$TL_messages_searchGlobalExt.limit = 20;
        tLRPC$TL_messages_searchGlobalExt.q = "#ایران";
        tLRPC$TL_messages_searchGlobalExt.flags = 262144;
        tLRPC$TL_messages_searchGlobalExt.offset_id = 0;
        tLRPC$TL_messages_searchGlobalExt.offset_peer = new TLRPC$TL_inputPeerEmpty();
        ConnectionsManager.getInstance(i).sendRequest(tLRPC$TL_messages_searchGlobalExt, new RequestDelegate() { // from class: ir.eitaa.ui.explore.activity.-$$Lambda$ExploreActivity$vAIyXPSQWzkKHCAXiNZ4uzHkhTI
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$search$5$ExploreActivity(i, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$search$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$search$5$ExploreActivity(int i, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.explore.activity.-$$Lambda$ExploreActivity$BwETsLr30z3exDc5Np1LFcjz6x8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$search$2$ExploreActivity();
            }
        });
        final ArrayList arrayList = new ArrayList();
        if (tLRPC$TL_error == null) {
            TLRPC$messages_Messages tLRPC$messages_Messages = (TLRPC$messages_Messages) tLObject;
            MessagesController.getInstance(i).putChats(tLRPC$messages_Messages.chats, false);
            MessagesController.getInstance(i).putUsers(tLRPC$messages_Messages.users, false);
            MessagesStorage.getInstance(i).putUsersAndChats(tLRPC$messages_Messages.users, tLRPC$messages_Messages.chats, true, true);
            int iMin = Math.min(tLRPC$messages_Messages.chats.size(), tLRPC$messages_Messages.messages.size());
            for (int i2 = 0; i2 < iMin; i2++) {
                arrayList.add(new MessageObject(i, tLRPC$messages_Messages.messages.get(i2), false, true, 1));
            }
        } else {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.explore.activity.-$$Lambda$ExploreActivity$o9T-80rPsR7_nlgdvbc-YBSPsDs
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$search$3$ExploreActivity(tLRPC$TL_error);
                }
            });
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.explore.activity.-$$Lambda$ExploreActivity$CXbrXqqQ4qbqZm-DXwJpyiaSKeM
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$search$4$ExploreActivity(tLObject, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$search$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$search$2$ExploreActivity() {
        updateLoadingState(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$search$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$search$3$ExploreActivity(TLRPC$TL_error tLRPC$TL_error) {
        Toast.makeText(getParentActivity(), "Error: " + tLRPC$TL_error.text, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$search$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$search$4$ExploreActivity(TLObject tLObject, ArrayList arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            MessageObject messageObject = (MessageObject) arrayList.get(i);
            ArrayList<MessageObject> arrayList2 = this.sectionArrays.get(messageObject.monthKey);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList<>();
                this.sectionArrays.put(messageObject.monthKey, arrayList2);
                this.sections.add(messageObject.monthKey);
            }
            arrayList2.add(messageObject);
            this.messages.add(messageObject);
            this.messagesById.put(messageObject.getId(), messageObject);
        }
        this.adapter.notifyDataSetChanged();
    }

    class ExploreAdpter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        Context context;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            return position;
        }

        public ExploreAdpter(Context context) {
            this.context = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view;
            StaggeredGridLayoutManager.LayoutParams layoutParams = new StaggeredGridLayoutManager.LayoutParams(-1, -2);
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = 16;
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = 16;
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = 16;
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = 16;
            if (i == 0) {
                layoutParams.setFullSpan(true);
                SimpleAdsList simpleAdsList = new SimpleAdsList(this.context);
                simpleAdsList.setDelegate(new SimpleAdsList.Delegate() { // from class: ir.eitaa.ui.explore.activity.-$$Lambda$ExploreActivity$ExploreAdpter$9NX7LfCymKBDg-b-8n9dbPyLOr8
                    @Override // ir.eitaa.ui.Components.SimpleAdsList.Delegate
                    public final void onAdClicked(TLRPC$Ads_Ad tLRPC$Ads_Ad) {
                        this.f$0.lambda$onCreateViewHolder$0$ExploreActivity$ExploreAdpter(tLRPC$Ads_Ad);
                    }
                });
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = 0;
                ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = 0;
                ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = 0;
                simpleAdsList.setLayoutParams(layoutParams);
                view = simpleAdsList;
            } else if (i == 1) {
                layoutParams.setFullSpan(true);
                View recyclerView = new RecyclerView(this.context);
                recyclerView.setLayoutParams(layoutParams);
                view = recyclerView;
            } else {
                View exploreCell = new ExploreCell(viewGroup.getContext());
                exploreCell.setLayoutParams(layoutParams);
                view = exploreCell;
            }
            return new RecyclerListView.Holder(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onCreateViewHolder$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onCreateViewHolder$0$ExploreActivity$ExploreAdpter(TLRPC$Ads_Ad tLRPC$Ads_Ad) {
            Browser.performAdAction(ExploreActivity.this.getParentActivity(), tLRPC$Ads_Ad, ExploreActivity.this);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if (holder.getAdapterPosition() == ExploreActivity.this.messages.size() - 1) {
                ExploreActivity.this.search();
            }
            if (position == 0) {
                ((SimpleAdsList) holder.itemView).location = new TLRPC$TL_ads_inputAdsLocationTrends();
                return;
            }
            if (position == 1) {
                RecyclerView recyclerView = (RecyclerView) holder.itemView;
                recyclerView.setLayoutManager(new LinearLayoutManager(this.context, 0, LocaleController.isRTL));
                recyclerView.setAdapter(ExploreActivity.this.hashtagAdapter);
                ExploreActivity.this.hashtagAdapter.notifyDataSetChanged();
                return;
            }
            int adapterPosition = holder.getAdapterPosition() - 2;
            ExploreCell exploreCell = (ExploreCell) holder.itemView;
            final MessageObject messageObject = (MessageObject) ExploreActivity.this.messages.get(adapterPosition);
            exploreCell.setDelegate(new ExploreCell.ExploreCellDelegate() { // from class: ir.eitaa.ui.explore.activity.ExploreActivity.ExploreAdpter.1
                @Override // ir.eitaa.ui.explore.cells.ExploreCell.ExploreCellDelegate
                public /* synthetic */ void didLongPress(ExploreCell exploreCell2, float f, float f2) {
                    ExploreCell.ExploreCellDelegate.CC.$default$didLongPress(this, exploreCell2, f, f2);
                }

                @Override // ir.eitaa.ui.explore.cells.ExploreCell.ExploreCellDelegate
                public /* synthetic */ boolean didLongPressChannelAvatar(ExploreCell exploreCell2, TLRPC$Chat tLRPC$Chat, int i, float f, float f2) {
                    return ExploreCell.ExploreCellDelegate.CC.$default$didLongPressChannelAvatar(this, exploreCell2, tLRPC$Chat, i, f, f2);
                }

                @Override // ir.eitaa.ui.explore.cells.ExploreCell.ExploreCellDelegate
                public /* synthetic */ boolean didLongPressUserAvatar(ExploreCell exploreCell2, TLRPC$User tLRPC$User, float f, float f2) {
                    return ExploreCell.ExploreCellDelegate.CC.$default$didLongPressUserAvatar(this, exploreCell2, tLRPC$User, f, f2);
                }

                @Override // ir.eitaa.ui.explore.cells.ExploreCell.ExploreCellDelegate
                public /* synthetic */ void didPressBotButton(ExploreCell exploreCell2, TLRPC$KeyboardButton tLRPC$KeyboardButton) {
                    ExploreCell.ExploreCellDelegate.CC.$default$didPressBotButton(this, exploreCell2, tLRPC$KeyboardButton);
                }

                @Override // ir.eitaa.ui.explore.cells.ExploreCell.ExploreCellDelegate
                public /* synthetic */ void didPressChannelAvatar(ExploreCell exploreCell2, TLRPC$Chat tLRPC$Chat, int i, float f, float f2) {
                    ExploreCell.ExploreCellDelegate.CC.$default$didPressChannelAvatar(this, exploreCell2, tLRPC$Chat, i, f, f2);
                }

                @Override // ir.eitaa.ui.explore.cells.ExploreCell.ExploreCellDelegate
                public /* synthetic */ void didPressCommentButton(ExploreCell exploreCell2) {
                    ExploreCell.ExploreCellDelegate.CC.$default$didPressCommentButton(this, exploreCell2);
                }

                @Override // ir.eitaa.ui.explore.cells.ExploreCell.ExploreCellDelegate
                public /* synthetic */ void didPressHiddenForward(ExploreCell exploreCell2) {
                    ExploreCell.ExploreCellDelegate.CC.$default$didPressHiddenForward(this, exploreCell2);
                }

                @Override // ir.eitaa.ui.explore.cells.ExploreCell.ExploreCellDelegate
                public /* synthetic */ void didPressHint(ExploreCell exploreCell2, int i) {
                    ExploreCell.ExploreCellDelegate.CC.$default$didPressHint(this, exploreCell2, i);
                }

                @Override // ir.eitaa.ui.explore.cells.ExploreCell.ExploreCellDelegate
                public /* synthetic */ void didPressInstantButton(ExploreCell exploreCell2, int i) {
                    ExploreCell.ExploreCellDelegate.CC.$default$didPressInstantButton(this, exploreCell2, i);
                }

                @Override // ir.eitaa.ui.explore.cells.ExploreCell.ExploreCellDelegate
                public /* synthetic */ void didPressReaction(ExploreCell exploreCell2, TLRPC$TL_reactionCount tLRPC$TL_reactionCount) {
                    ExploreCell.ExploreCellDelegate.CC.$default$didPressReaction(this, exploreCell2, tLRPC$TL_reactionCount);
                }

                @Override // ir.eitaa.ui.explore.cells.ExploreCell.ExploreCellDelegate
                public /* synthetic */ void didPressReplyMessage(ExploreCell exploreCell2, int i) {
                    ExploreCell.ExploreCellDelegate.CC.$default$didPressReplyMessage(this, exploreCell2, i);
                }

                @Override // ir.eitaa.ui.explore.cells.ExploreCell.ExploreCellDelegate
                public /* synthetic */ void didPressSideButton(ExploreCell exploreCell2) {
                    ExploreCell.ExploreCellDelegate.CC.$default$didPressSideButton(this, exploreCell2);
                }

                @Override // ir.eitaa.ui.explore.cells.ExploreCell.ExploreCellDelegate
                public /* synthetic */ void didPressUrl(ExploreCell exploreCell2, CharacterStyle characterStyle, boolean z) {
                    ExploreCell.ExploreCellDelegate.CC.$default$didPressUrl(this, exploreCell2, characterStyle, z);
                }

                @Override // ir.eitaa.ui.explore.cells.ExploreCell.ExploreCellDelegate
                public /* synthetic */ void didPressUserAvatar(ExploreCell exploreCell2, TLRPC$User tLRPC$User, float f, float f2) {
                    ExploreCell.ExploreCellDelegate.CC.$default$didPressUserAvatar(this, exploreCell2, tLRPC$User, f, f2);
                }

                @Override // ir.eitaa.ui.explore.cells.ExploreCell.ExploreCellDelegate
                public /* synthetic */ void didPressVoteButtons(ExploreCell exploreCell2, ArrayList arrayList, int i, int i2, int i3) {
                    ExploreCell.ExploreCellDelegate.CC.$default$didPressVoteButtons(this, exploreCell2, arrayList, i, i2, i3);
                }

                @Override // ir.eitaa.ui.explore.cells.ExploreCell.ExploreCellDelegate
                public /* synthetic */ void didStartVideoStream(MessageObject messageObject2) {
                    ExploreCell.ExploreCellDelegate.CC.$default$didStartVideoStream(this, messageObject2);
                }

                @Override // ir.eitaa.ui.explore.cells.ExploreCell.ExploreCellDelegate
                public /* synthetic */ String getAdminRank(long j) {
                    return ExploreCell.ExploreCellDelegate.CC.$default$getAdminRank(this, j);
                }

                @Override // ir.eitaa.ui.explore.cells.ExploreCell.ExploreCellDelegate
                public /* synthetic */ PinchToZoomHelper getPinchToZoomHelper() {
                    return ExploreCell.ExploreCellDelegate.CC.$default$getPinchToZoomHelper(this);
                }

                @Override // ir.eitaa.ui.explore.cells.ExploreCell.ExploreCellDelegate
                public /* synthetic */ TextSelectionHelper.ChatListTextSelectionHelper getTextSelectionHelper() {
                    return ExploreCell.ExploreCellDelegate.CC.$default$getTextSelectionHelper(this);
                }

                @Override // ir.eitaa.ui.explore.cells.ExploreCell.ExploreCellDelegate
                public /* synthetic */ boolean isLandscape() {
                    return ExploreCell.ExploreCellDelegate.CC.$default$isLandscape(this);
                }

                @Override // ir.eitaa.ui.explore.cells.ExploreCell.ExploreCellDelegate
                public /* synthetic */ boolean keyboardIsOpened() {
                    return ExploreCell.ExploreCellDelegate.CC.$default$keyboardIsOpened(this);
                }

                @Override // ir.eitaa.ui.explore.cells.ExploreCell.ExploreCellDelegate
                public /* synthetic */ void onDiceFinished() {
                    ExploreCell.ExploreCellDelegate.CC.$default$onDiceFinished(this);
                }

                @Override // ir.eitaa.ui.explore.cells.ExploreCell.ExploreCellDelegate
                public /* synthetic */ void setShouldNotRepeatSticker(MessageObject messageObject2) {
                    ExploreCell.ExploreCellDelegate.CC.$default$setShouldNotRepeatSticker(this, messageObject2);
                }

                @Override // ir.eitaa.ui.explore.cells.ExploreCell.ExploreCellDelegate
                public /* synthetic */ boolean shouldDrawThreadProgress(ExploreCell exploreCell2) {
                    return ExploreCell.ExploreCellDelegate.CC.$default$shouldDrawThreadProgress(this, exploreCell2);
                }

                @Override // ir.eitaa.ui.explore.cells.ExploreCell.ExploreCellDelegate
                public /* synthetic */ boolean shouldRepeatSticker(MessageObject messageObject2) {
                    return ExploreCell.ExploreCellDelegate.CC.$default$shouldRepeatSticker(this, messageObject2);
                }

                @Override // ir.eitaa.ui.explore.cells.ExploreCell.ExploreCellDelegate
                public /* synthetic */ void videoTimerReached() {
                    ExploreCell.ExploreCellDelegate.CC.$default$videoTimerReached(this);
                }
            });
            messageObject.forceDrawAvatarAndShare = false;
            exploreCell.setFullyDraw(true);
            exploreCell.setMessageObject(messageObject, null, false, false);
            exploreCell.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.explore.activity.ExploreActivity.ExploreAdpter.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    ExploreActivity.this.presentFragment(new KavoshActivity(messageObject));
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return ExploreActivity.this.messages.size() + 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadTrends() {
        Log.v("trendd", "loadTrends()");
        new TLRPC$TL_get_trends().lang = Locale.getDefault().getLanguage().toLowerCase();
        this.getTrendsReqId = ConnectionsManager.getInstance(this.currentAccount).sendRequest(r0, new RequestDelegate() { // from class: ir.eitaa.ui.explore.activity.ExploreActivity.6
            @Override // ir.eitaa.tgnet.RequestDelegate
            public void run(TLObject response, TLRPC$TL_error error) {
                Log.v("trendd", "loadTrends() response: " + response);
                ExploreActivity.this.getTrendsReqId = 0L;
                if (error == null) {
                    ExploreActivity.this.trends = ((TLRPC$TL_updateTrends) response).trendGroups.get(0).trends;
                    for (int i = 0; i < ExploreActivity.this.trends.size(); i++) {
                        ExploreActivity.this.hashtags.add(((TLRPC$Trend) ExploreActivity.this.trends.get(i)).hashtag);
                    }
                    ExploreActivity.this.getParentActivity().runOnUiThread(new Runnable() { // from class: ir.eitaa.ui.explore.activity.ExploreActivity.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ExploreActivity.this.hashtagAdapter.notifyDataSetChanged();
                        }
                    });
                    ExploreActivity.this.syncLatch.countDown();
                }
            }
        }, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAds() {
        Log.v("trendd", "loadAds()");
        TLRPC$TL_ads_getAdsPack tLRPC$TL_ads_getAdsPack = new TLRPC$TL_ads_getAdsPack();
        TLRPC$TL_ads_inputAdsLocationTrends tLRPC$TL_ads_inputAdsLocationTrends = new TLRPC$TL_ads_inputAdsLocationTrends();
        tLRPC$TL_ads_getAdsPack.location = tLRPC$TL_ads_inputAdsLocationTrends;
        tLRPC$TL_ads_inputAdsLocationTrends.groupTitle = "";
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_ads_getAdsPack, new RequestDelegate() { // from class: ir.eitaa.ui.explore.activity.-$$Lambda$ExploreActivity$vXvS06Q5LRhDK58btaO3vBThdl8
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadAds$7$ExploreActivity(tLObject, tLRPC$TL_error);
            }
        }, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadAds$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadAds$7$ExploreActivity(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        Log.v("trendd", "loadAds() response: " + tLObject);
        if (tLRPC$TL_error == null) {
            ArrayList arrayList = new ArrayList();
            Iterator<TLRPC$Ads_Ad> it = ((TLRPC$TL_ads_AdPack) tLObject).ads.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            ImageLoader.saveAdsThumbs(arrayList);
            if (arrayList.size() != 0) {
                this.loadedAds.addAll(arrayList);
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.explore.activity.ExploreActivity.7
                @Override // java.lang.Runnable
                public void run() {
                    SimpleAdsList simpleAdsList = (SimpleAdsList) ExploreActivity.this.listView.getLayoutManager().findViewByPosition(0);
                    if (simpleAdsList != null) {
                        simpleAdsList.showAds(ExploreActivity.this.loadedAds);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized List<TLRPC$Chat> loadLiveChats() {
        ArrayList arrayList;
        Log.v("trendd", "loadLiveChats()");
        arrayList = new ArrayList();
        ConcurrentHashMap<Integer, TLRPC$Chat> concurrentHashMap = MessagesController.getInstance(this.currentAccount).livechats;
        Iterator it = concurrentHashMap.keySet().iterator();
        while (it.hasNext()) {
            arrayList.add((TLRPC$Chat) concurrentHashMap.get((Integer) it.next()));
        }
        Log.v("trendd", "loadLiveChats() chats: " + arrayList);
        return arrayList;
    }

    private void updateLoadingState(boolean state) {
        if (state) {
            this.loadingView.setVisibility(0);
            this.listView.setPadding(0, 0, 0, this.loadingView.getMeasuredHeight());
        } else {
            this.loadingView.setVisibility(4);
            this.listView.setPadding(0, 0, 0, 0);
        }
    }
}
