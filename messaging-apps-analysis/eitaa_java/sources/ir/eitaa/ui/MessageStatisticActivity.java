package ir.eitaa.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.collection.ArraySet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.DialogObject;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.LruCache;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$ChatFull;
import ir.eitaa.tgnet.TLRPC$Message;
import ir.eitaa.tgnet.TLRPC$MessageFwdHeader;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_inputPeerEmpty;
import ir.eitaa.tgnet.TLRPC$TL_messages_messagesSlice;
import ir.eitaa.tgnet.TLRPC$TL_statsGraph;
import ir.eitaa.tgnet.TLRPC$TL_statsGraphError;
import ir.eitaa.tgnet.TLRPC$TL_stats_getMessagePublicForwards;
import ir.eitaa.tgnet.TLRPC$TL_stats_getMessageStats;
import ir.eitaa.tgnet.TLRPC$TL_stats_loadAsyncGraph;
import ir.eitaa.tgnet.TLRPC$TL_stats_messageStats;
import ir.eitaa.tgnet.TLRPC$messages_Messages;
import ir.eitaa.ui.ActionBar.ActionBarMenu;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Cells.EmptyCell;
import ir.eitaa.ui.Cells.HeaderCell;
import ir.eitaa.ui.Cells.LoadingCell;
import ir.eitaa.ui.Cells.ManageChatUserCell;
import ir.eitaa.ui.Cells.ShadowSectionCell;
import ir.eitaa.ui.Charts.BaseChartView;
import ir.eitaa.ui.Charts.data.ChartData;
import ir.eitaa.ui.Charts.data.StackLinearChartData;
import ir.eitaa.ui.Charts.view_data.ChartHeaderView;
import ir.eitaa.ui.Components.ChatAvatarContainer;
import ir.eitaa.ui.Components.CombinedDrawable;
import ir.eitaa.ui.Components.EmptyTextProgressView;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.RLottieImageView;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.StatisticActivity;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class MessageStatisticActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private ChatAvatarContainer avatarContainer;
    private TLRPC$ChatFull chat;
    private final long chatId;
    boolean drawPlay;
    private int emptyRow;
    private EmptyTextProgressView emptyView;
    private boolean endReached;
    private int endRow;
    private boolean firstLoaded;
    private int headerRow;
    private RLottieImageView imageView;
    private int interactionsChartRow;
    private StatisticActivity.ChartViewData interactionsViewData;
    private StatisticActivity.ZoomCancelable lastCancelable;
    private LinearLayoutManager layoutManager;
    private FrameLayout listContainer;
    private RecyclerListView listView;
    private ListAdapter listViewAdapter;
    private boolean loading;
    private int loadingRow;
    private final int messageId;
    private MessageObject messageObject;
    private int nextRate;
    private int overviewHeaderRow;
    private int overviewRow;
    private LinearLayout progressLayout;
    private int publicChats;
    private int rowCount;
    private BaseChartView.SharedUiComponents sharedUi;
    private int startRow;
    private boolean statsLoaded;
    ImageReceiver thumbImage;
    private LruCache<ChartData> childDataCache = new LruCache<>(15);
    private ArrayList<TLRPC$Message> messages = new ArrayList<>();
    ArraySet<Integer> shadowDivideCells = new ArraySet<>();
    private final Runnable showProgressbar = new Runnable() { // from class: ir.eitaa.ui.MessageStatisticActivity.1
        @Override // java.lang.Runnable
        public void run() {
            MessageStatisticActivity.this.progressLayout.animate().alpha(1.0f).setDuration(230L);
        }
    };

    public MessageStatisticActivity(MessageObject message) {
        this.messageObject = message;
        if (message.messageOwner.fwd_from == null) {
            this.chatId = message.getChatId();
            this.messageId = this.messageObject.getId();
        } else {
            this.chatId = -message.getFromChatId();
            this.messageId = this.messageObject.messageOwner.fwd_msg_id;
        }
        this.chat = getMessagesController().getChatFull(this.chatId);
    }

    private void updateRows() {
        this.shadowDivideCells.clear();
        this.headerRow = -1;
        this.startRow = -1;
        this.endRow = -1;
        this.loadingRow = -1;
        this.interactionsChartRow = -1;
        this.overviewHeaderRow = -1;
        this.overviewRow = -1;
        this.rowCount = 0;
        if (this.firstLoaded && this.statsLoaded) {
            AndroidUtilities.cancelRunOnUIThread(this.showProgressbar);
            if (this.listContainer.getVisibility() == 8) {
                this.progressLayout.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.MessageStatisticActivity.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        MessageStatisticActivity.this.progressLayout.setVisibility(8);
                    }
                });
                this.listContainer.setVisibility(0);
                this.listContainer.setAlpha(0.0f);
                this.listContainer.animate().alpha(1.0f).start();
            }
            int i = this.rowCount;
            int i2 = i + 1;
            this.rowCount = i2;
            this.overviewHeaderRow = i;
            int i3 = i2 + 1;
            this.rowCount = i3;
            this.overviewRow = i2;
            ArraySet<Integer> arraySet = this.shadowDivideCells;
            this.rowCount = i3 + 1;
            arraySet.add(Integer.valueOf(i3));
            if (this.interactionsViewData != null) {
                int i4 = this.rowCount;
                int i5 = i4 + 1;
                this.rowCount = i5;
                this.interactionsChartRow = i4;
                ArraySet<Integer> arraySet2 = this.shadowDivideCells;
                this.rowCount = i5 + 1;
                arraySet2.add(Integer.valueOf(i5));
            }
            if (!this.messages.isEmpty()) {
                int i6 = this.rowCount;
                int i7 = i6 + 1;
                this.rowCount = i7;
                this.headerRow = i6;
                this.startRow = i7;
                int size = i7 + this.messages.size();
                this.rowCount = size;
                this.endRow = size;
                int i8 = size + 1;
                this.rowCount = i8;
                this.emptyRow = size;
                ArraySet<Integer> arraySet3 = this.shadowDivideCells;
                this.rowCount = i8 + 1;
                arraySet3.add(Integer.valueOf(i8));
                if (!this.endReached) {
                    int i9 = this.rowCount;
                    this.rowCount = i9 + 1;
                    this.loadingRow = i9;
                }
            }
        }
        ListAdapter listAdapter = this.listViewAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        super.onFragmentCreate();
        if (this.chat != null) {
            loadStat();
            loadChats(100);
        } else {
            MessagesController.getInstance(this.currentAccount).loadFullChat(this.chatId, this.classGuid, true);
        }
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.chatInfoDidLoad);
        return true;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() throws InterruptedException {
        super.onFragmentDestroy();
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.chatInfoDidLoad);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment, ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        if (id == NotificationCenter.chatInfoDidLoad) {
            TLRPC$ChatFull tLRPC$ChatFull = (TLRPC$ChatFull) args[0];
            if (this.chat == null && tLRPC$ChatFull.id == this.chatId) {
                TLRPC$Chat chat = getMessagesController().getChat(Long.valueOf(this.chatId));
                if (chat != null) {
                    this.avatarContainer.setChatAvatar(chat);
                    this.avatarContainer.setTitle(chat.title);
                }
                this.chat = tLRPC$ChatFull;
                loadStat();
                loadChats(100);
                updateMenu();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:56:0x02c6  */
    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View createView(android.content.Context r21) {
        /*
            Method dump skipped, instructions count: 921
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.MessageStatisticActivity.createView(android.content.Context):android.view.View");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$0$MessageStatisticActivity(View view, int i) {
        int i2 = this.startRow;
        if (i < i2 || i >= this.endRow) {
            return;
        }
        TLRPC$Message tLRPC$Message = this.messages.get(i - i2);
        long dialogId = MessageObject.getDialogId(tLRPC$Message);
        Bundle bundle = new Bundle();
        if (DialogObject.isUserDialog(dialogId)) {
            bundle.putLong("user_id", dialogId);
        } else {
            bundle.putLong("chat_id", -dialogId);
        }
        bundle.putInt("message_id", tLRPC$Message.id);
        bundle.putBoolean("need_remove_previous_same_chat_activity", false);
        if (getMessagesController().checkCanOpenChat(bundle, this)) {
            presentFragment(new ChatActivity(bundle));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$1$MessageStatisticActivity(View view) {
        if (getParentLayout().fragmentsStack.size() > 1) {
            BaseFragment baseFragment = getParentLayout().fragmentsStack.get(getParentLayout().fragmentsStack.size() - 2);
            if ((baseFragment instanceof ChatActivity) && ((ChatActivity) baseFragment).getCurrentChat().id == this.chatId) {
                finishFragment();
                return;
            }
        }
        Bundle bundle = new Bundle();
        bundle.putLong("chat_id", this.chatId);
        bundle.putInt("message_id", this.messageId);
        bundle.putBoolean("need_remove_previous_same_chat_activity", false);
        presentFragment(new ChatActivity(bundle));
    }

    private void updateMenu() {
        TLRPC$ChatFull tLRPC$ChatFull = this.chat;
        if (tLRPC$ChatFull == null || !tLRPC$ChatFull.can_view_stats) {
            return;
        }
        ActionBarMenu actionBarMenuCreateMenu = this.actionBar.createMenu();
        actionBarMenuCreateMenu.clearItems();
        actionBarMenuCreateMenu.addItem(0, R.drawable.ic_ab_other).addSubItem(1, R.drawable.msg_stats, LocaleController.getString("ViewChannelStats", R.string.ViewChannelStats));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadChats(int count) {
        if (this.loading) {
            return;
        }
        this.loading = true;
        ListAdapter listAdapter = this.listViewAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
        TLRPC$TL_stats_getMessagePublicForwards tLRPC$TL_stats_getMessagePublicForwards = new TLRPC$TL_stats_getMessagePublicForwards();
        tLRPC$TL_stats_getMessagePublicForwards.limit = count;
        MessageObject messageObject = this.messageObject;
        TLRPC$MessageFwdHeader tLRPC$MessageFwdHeader = messageObject.messageOwner.fwd_from;
        if (tLRPC$MessageFwdHeader != null) {
            tLRPC$TL_stats_getMessagePublicForwards.msg_id = tLRPC$MessageFwdHeader.saved_from_msg_id;
            tLRPC$TL_stats_getMessagePublicForwards.channel = getMessagesController().getInputChannel(-this.messageObject.getFromChatId());
        } else {
            tLRPC$TL_stats_getMessagePublicForwards.msg_id = messageObject.getId();
            tLRPC$TL_stats_getMessagePublicForwards.channel = getMessagesController().getInputChannel(-this.messageObject.getDialogId());
        }
        if (!this.messages.isEmpty()) {
            ArrayList<TLRPC$Message> arrayList = this.messages;
            TLRPC$Message tLRPC$Message = arrayList.get(arrayList.size() - 1);
            tLRPC$TL_stats_getMessagePublicForwards.offset_id = tLRPC$Message.id;
            tLRPC$TL_stats_getMessagePublicForwards.offset_peer = getMessagesController().getInputPeer(MessageObject.getDialogId(tLRPC$Message));
            tLRPC$TL_stats_getMessagePublicForwards.offset_rate = this.nextRate;
        } else {
            tLRPC$TL_stats_getMessagePublicForwards.offset_peer = new TLRPC$TL_inputPeerEmpty();
        }
        getConnectionsManager().bindRequestToGuid(getConnectionsManager().sendRequest(tLRPC$TL_stats_getMessagePublicForwards, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$MessageStatisticActivity$fALt-_bL05XrH9VcPhO3jVndd9M
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadChats$3$MessageStatisticActivity(tLObject, tLRPC$TL_error);
            }
        }, null, null, 0, this.chat.stats_dc, 1, true), this.classGuid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadChats$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadChats$3$MessageStatisticActivity(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$MessageStatisticActivity$zz_dfFW17VlSq02Q7rkwBSuzMBE
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadChats$2$MessageStatisticActivity(tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadChats$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadChats$2$MessageStatisticActivity(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
        if (tLRPC$TL_error == null) {
            TLRPC$messages_Messages tLRPC$messages_Messages = (TLRPC$messages_Messages) tLObject;
            if ((tLRPC$messages_Messages.flags & 1) != 0) {
                this.nextRate = tLRPC$messages_Messages.next_rate;
            }
            int i = tLRPC$messages_Messages.count;
            if (i != 0) {
                this.publicChats = i;
            } else if (this.publicChats == 0) {
                this.publicChats = tLRPC$messages_Messages.messages.size();
            }
            this.endReached = !(tLRPC$messages_Messages instanceof TLRPC$TL_messages_messagesSlice);
            getMessagesController().putChats(tLRPC$messages_Messages.chats, false);
            getMessagesController().putUsers(tLRPC$messages_Messages.users, false);
            this.messages.addAll(tLRPC$messages_Messages.messages);
            EmptyTextProgressView emptyTextProgressView = this.emptyView;
            if (emptyTextProgressView != null) {
                emptyTextProgressView.showTextView();
            }
        }
        this.firstLoaded = true;
        this.loading = false;
        updateRows();
    }

    private void loadStat() {
        TLRPC$TL_stats_getMessageStats tLRPC$TL_stats_getMessageStats = new TLRPC$TL_stats_getMessageStats();
        MessageObject messageObject = this.messageObject;
        TLRPC$MessageFwdHeader tLRPC$MessageFwdHeader = messageObject.messageOwner.fwd_from;
        if (tLRPC$MessageFwdHeader != null) {
            tLRPC$TL_stats_getMessageStats.msg_id = tLRPC$MessageFwdHeader.saved_from_msg_id;
            tLRPC$TL_stats_getMessageStats.channel = getMessagesController().getInputChannel(-this.messageObject.getFromChatId());
        } else {
            tLRPC$TL_stats_getMessageStats.msg_id = messageObject.getId();
            tLRPC$TL_stats_getMessageStats.channel = getMessagesController().getInputChannel(-this.messageObject.getDialogId());
        }
        getConnectionsManager().sendRequest(tLRPC$TL_stats_getMessageStats, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$MessageStatisticActivity$4CurSmNXxZjGMltLGcCDC4p1GKU
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadStat$8$MessageStatisticActivity(tLObject, tLRPC$TL_error);
            }
        }, null, null, 0, this.chat.stats_dc, 1, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadStat$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadStat$8$MessageStatisticActivity(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$MessageStatisticActivity$yHt_VaiNGI6joN0BwM7qQUkTFCU
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadStat$7$MessageStatisticActivity(tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadStat$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadStat$7$MessageStatisticActivity(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
        this.statsLoaded = true;
        if (tLRPC$TL_error != null) {
            updateRows();
            return;
        }
        StatisticActivity.ChartViewData chartViewDataCreateViewData = StatisticActivity.createViewData(((TLRPC$TL_stats_messageStats) tLObject).views_graph, LocaleController.getString("InteractionsChartTitle", R.string.InteractionsChartTitle), 1, false);
        this.interactionsViewData = chartViewDataCreateViewData;
        if (chartViewDataCreateViewData != null && chartViewDataCreateViewData.chartData.x.length <= 5) {
            this.statsLoaded = false;
            final TLRPC$TL_stats_loadAsyncGraph tLRPC$TL_stats_loadAsyncGraph = new TLRPC$TL_stats_loadAsyncGraph();
            StatisticActivity.ChartViewData chartViewData = this.interactionsViewData;
            tLRPC$TL_stats_loadAsyncGraph.token = chartViewData.zoomToken;
            long[] jArr = chartViewData.chartData.x;
            tLRPC$TL_stats_loadAsyncGraph.x = jArr[jArr.length - 1];
            tLRPC$TL_stats_loadAsyncGraph.flags |= 1;
            final String str = this.interactionsViewData.zoomToken + "_" + tLRPC$TL_stats_loadAsyncGraph.x;
            ConnectionsManager.getInstance(this.currentAccount).bindRequestToGuid(ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_stats_loadAsyncGraph, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$MessageStatisticActivity$n6Q944xLmXRaLaVES2V0DBNqdB0
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject2, TLRPC$TL_error tLRPC$TL_error2) throws JSONException {
                    this.f$0.lambda$loadStat$6$MessageStatisticActivity(str, tLRPC$TL_stats_loadAsyncGraph, tLObject2, tLRPC$TL_error2);
                }
            }, null, null, 0, this.chat.stats_dc, 1, true), this.classGuid);
            return;
        }
        updateRows();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadStat$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadStat$6$MessageStatisticActivity(final String str, final TLRPC$TL_stats_loadAsyncGraph tLRPC$TL_stats_loadAsyncGraph, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) throws JSONException {
        ChartData chartDataCreateChartData = null;
        if (tLObject instanceof TLRPC$TL_statsGraph) {
            try {
                chartDataCreateChartData = StatisticActivity.createChartData(new JSONObject(((TLRPC$TL_statsGraph) tLObject).json.data), 1, false);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else if (tLObject instanceof TLRPC$TL_statsGraphError) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$MessageStatisticActivity$VdPDxDjXXz4D7-iEmK5HzeOg_Ts
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadStat$4$MessageStatisticActivity(tLObject);
                }
            });
        }
        final ChartData chartData = chartDataCreateChartData;
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$MessageStatisticActivity$N9I04bleuMZzJY2MRht4wPBXRdM
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadStat$5$MessageStatisticActivity(tLRPC$TL_error, chartData, str, tLRPC$TL_stats_loadAsyncGraph);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadStat$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadStat$4$MessageStatisticActivity(TLObject tLObject) {
        if (getParentActivity() != null) {
            Toast.makeText(getParentActivity(), ((TLRPC$TL_statsGraphError) tLObject).error, 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadStat$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadStat$5$MessageStatisticActivity(TLRPC$TL_error tLRPC$TL_error, ChartData chartData, String str, TLRPC$TL_stats_loadAsyncGraph tLRPC$TL_stats_loadAsyncGraph) {
        this.statsLoaded = true;
        if (tLRPC$TL_error != null || chartData == null) {
            updateRows();
            return;
        }
        this.childDataCache.put(str, chartData);
        StatisticActivity.ChartViewData chartViewData = this.interactionsViewData;
        chartViewData.childChartData = chartData;
        chartViewData.activeZoom = tLRPC$TL_stats_loadAsyncGraph.x;
        updateRows();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        AndroidUtilities.requestAdjustResize(getParentActivity(), this.classGuid);
        ListAdapter listAdapter = this.listViewAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            if (holder.getItemViewType() == 0) {
                return ((ManageChatUserCell) holder.itemView).getCurrentObject() instanceof TLObject;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return MessageStatisticActivity.this.rowCount;
        }

        /* renamed from: ir.eitaa.ui.MessageStatisticActivity$ListAdapter$1, reason: invalid class name */
        class AnonymousClass1 extends StatisticActivity.BaseChartCell {
            @Override // ir.eitaa.ui.StatisticActivity.BaseChartCell
            void loadData(StatisticActivity.ChartViewData viewData) {
            }

            AnonymousClass1(Context context, int type, BaseChartView.SharedUiComponents sharedUi) {
                super(context, type, sharedUi);
            }

            @Override // ir.eitaa.ui.StatisticActivity.BaseChartCell
            public void onZoomed() {
                if (this.data.activeZoom > 0) {
                    return;
                }
                performClick();
                BaseChartView baseChartView = this.chartView;
                if (baseChartView.legendSignatureView.canGoZoom) {
                    long selectedDate = baseChartView.getSelectedDate();
                    if (this.chartType == 4) {
                        StatisticActivity.ChartViewData chartViewData = this.data;
                        chartViewData.childChartData = new StackLinearChartData(chartViewData.chartData, selectedDate);
                        zoomChart(false);
                        return;
                    }
                    if (this.data.zoomToken == null) {
                        return;
                    }
                    zoomCanceled();
                    final String str = this.data.zoomToken + "_" + selectedDate;
                    ChartData chartData = (ChartData) MessageStatisticActivity.this.childDataCache.get(str);
                    if (chartData != null) {
                        this.data.childChartData = chartData;
                        zoomChart(false);
                        return;
                    }
                    TLRPC$TL_stats_loadAsyncGraph tLRPC$TL_stats_loadAsyncGraph = new TLRPC$TL_stats_loadAsyncGraph();
                    tLRPC$TL_stats_loadAsyncGraph.token = this.data.zoomToken;
                    if (selectedDate != 0) {
                        tLRPC$TL_stats_loadAsyncGraph.x = selectedDate;
                        tLRPC$TL_stats_loadAsyncGraph.flags |= 1;
                    }
                    MessageStatisticActivity messageStatisticActivity = MessageStatisticActivity.this;
                    final StatisticActivity.ZoomCancelable zoomCancelable = new StatisticActivity.ZoomCancelable();
                    messageStatisticActivity.lastCancelable = zoomCancelable;
                    zoomCancelable.adapterPosition = MessageStatisticActivity.this.listView.getChildAdapterPosition(this);
                    this.chartView.legendSignatureView.showProgress(true, false);
                    ConnectionsManager.getInstance(((BaseFragment) MessageStatisticActivity.this).currentAccount).bindRequestToGuid(ConnectionsManager.getInstance(((BaseFragment) MessageStatisticActivity.this).currentAccount).sendRequest(tLRPC$TL_stats_loadAsyncGraph, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$MessageStatisticActivity$ListAdapter$1$vgEypPxuZF1DpnoOG8q_VKrtkss
                        @Override // ir.eitaa.tgnet.RequestDelegate
                        public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) throws JSONException {
                            this.f$0.lambda$onZoomed$1$MessageStatisticActivity$ListAdapter$1(str, zoomCancelable, tLObject, tLRPC$TL_error);
                        }
                    }, null, null, 0, MessageStatisticActivity.this.chat.stats_dc, 1, true), ((BaseFragment) MessageStatisticActivity.this).classGuid);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: lambda$onZoomed$1, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void lambda$onZoomed$1$MessageStatisticActivity$ListAdapter$1(final String str, final StatisticActivity.ZoomCancelable zoomCancelable, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) throws JSONException {
                final ChartData chartDataCreateChartData = null;
                if (tLObject instanceof TLRPC$TL_statsGraph) {
                    try {
                        chartDataCreateChartData = StatisticActivity.createChartData(new JSONObject(((TLRPC$TL_statsGraph) tLObject).json.data), this.data.graphType, false);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else if (tLObject instanceof TLRPC$TL_statsGraphError) {
                    Toast.makeText(getContext(), ((TLRPC$TL_statsGraphError) tLObject).error, 1).show();
                }
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$MessageStatisticActivity$ListAdapter$1$RidLhlpkg8APnUpPLEoNYvDlKTs
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onZoomed$0$MessageStatisticActivity$ListAdapter$1(chartDataCreateChartData, str, zoomCancelable);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: lambda$onZoomed$0, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void lambda$onZoomed$0$MessageStatisticActivity$ListAdapter$1(ChartData chartData, String str, StatisticActivity.ZoomCancelable zoomCancelable) {
                if (chartData != null) {
                    MessageStatisticActivity.this.childDataCache.put(str, chartData);
                }
                if (chartData != null && !zoomCancelable.canceled && zoomCancelable.adapterPosition >= 0) {
                    View viewFindViewByPosition = MessageStatisticActivity.this.layoutManager.findViewByPosition(zoomCancelable.adapterPosition);
                    if (viewFindViewByPosition instanceof StatisticActivity.BaseChartCell) {
                        this.data.childChartData = chartData;
                        StatisticActivity.BaseChartCell baseChartCell = (StatisticActivity.BaseChartCell) viewFindViewByPosition;
                        baseChartCell.chartView.legendSignatureView.showProgress(false, false);
                        baseChartCell.zoomChart(false);
                    }
                }
                zoomCanceled();
            }

            @Override // ir.eitaa.ui.StatisticActivity.BaseChartCell
            public void zoomCanceled() {
                if (MessageStatisticActivity.this.lastCancelable != null) {
                    MessageStatisticActivity.this.lastCancelable.canceled = true;
                }
                int childCount = MessageStatisticActivity.this.listView.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = MessageStatisticActivity.this.listView.getChildAt(i);
                    if (childAt instanceof StatisticActivity.BaseChartCell) {
                        ((StatisticActivity.BaseChartCell) childAt).chartView.legendSignatureView.showProgress(false, true);
                    }
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View shadowSectionCell;
            if (i == 0) {
                View manageChatUserCell = new ManageChatUserCell(this.mContext, 6, 2, false);
                manageChatUserCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                shadowSectionCell = manageChatUserCell;
            } else if (i == 1) {
                shadowSectionCell = new ShadowSectionCell(this.mContext);
            } else if (i == 2) {
                HeaderCell headerCell = new HeaderCell(this.mContext, "windowBackgroundWhiteBlueHeader", 16, 11, false);
                headerCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                headerCell.setHeight(43);
                shadowSectionCell = headerCell;
            } else if (i == 4) {
                View anonymousClass1 = new AnonymousClass1(this.mContext, 1, MessageStatisticActivity.this.sharedUi = new BaseChartView.SharedUiComponents());
                anonymousClass1.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                shadowSectionCell = anonymousClass1;
            } else if (i == 5) {
                View overviewCell = MessageStatisticActivity.this.new OverviewCell(this.mContext);
                overviewCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
                overviewCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                shadowSectionCell = overviewCell;
            } else if (i == 6) {
                View emptyCell = new EmptyCell(this.mContext, 16);
                emptyCell.setLayoutParams(new RecyclerView.LayoutParams(-1, 16));
                emptyCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                shadowSectionCell = emptyCell;
            } else {
                shadowSectionCell = new LoadingCell(this.mContext, AndroidUtilities.dp(40.0f), AndroidUtilities.dp(120.0f));
            }
            return new RecyclerListView.Holder(shadowSectionCell);
        }

        /* JADX WARN: Removed duplicated region for block: B:33:0x00e1  */
        /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder r9, int r10) {
            /*
                Method dump skipped, instructions count: 239
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.MessageStatisticActivity.ListAdapter.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewRecycled(RecyclerView.ViewHolder holder) {
            View view = holder.itemView;
            if (view instanceof ManageChatUserCell) {
                ((ManageChatUserCell) view).recycle();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            if (MessageStatisticActivity.this.shadowDivideCells.contains(Integer.valueOf(position))) {
                return 1;
            }
            if (position == MessageStatisticActivity.this.headerRow || position == MessageStatisticActivity.this.overviewHeaderRow) {
                return 2;
            }
            if (position == MessageStatisticActivity.this.loadingRow) {
                return 3;
            }
            if (position == MessageStatisticActivity.this.interactionsChartRow) {
                return 4;
            }
            if (position == MessageStatisticActivity.this.overviewRow) {
                return 5;
            }
            return position == MessageStatisticActivity.this.emptyRow ? 6 : 0;
        }

        public TLRPC$Message getItem(int position) {
            if (position < MessageStatisticActivity.this.startRow || position >= MessageStatisticActivity.this.endRow) {
                return null;
            }
            return (TLRPC$Message) MessageStatisticActivity.this.messages.get(position - MessageStatisticActivity.this.startRow);
        }
    }

    public class OverviewCell extends LinearLayout {
        View[] cell;
        TextView[] primary;
        TextView[] title;

        public OverviewCell(Context context) {
            super(context);
            this.primary = new TextView[3];
            this.title = new TextView[3];
            this.cell = new View[3];
            setOrientation(1);
            setPadding(AndroidUtilities.dp(16.0f), 0, AndroidUtilities.dp(16.0f), AndroidUtilities.dp(16.0f));
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(0);
            for (int i = 0; i < 3; i++) {
                LinearLayout linearLayout2 = new LinearLayout(context);
                this.cell[i] = linearLayout2;
                linearLayout2.setOrientation(1);
                this.primary[i] = new TextView(context);
                this.title[i] = new TextView(context);
                this.primary[i].setTypeface(AndroidUtilities.getFontFamily(true));
                this.primary[i].setTextSize(1, 17.0f);
                this.title[i].setTextSize(1, 13.0f);
                linearLayout2.addView(this.primary[i]);
                linearLayout2.addView(this.title[i]);
                linearLayout.addView(linearLayout2, LayoutHelper.createLinear(-1, -2, 1.0f));
            }
            addView(linearLayout, LayoutHelper.createFrame(-1, -2.0f));
        }

        public void setData() {
            this.primary[0].setText(AndroidUtilities.formatWholeNumber(MessageStatisticActivity.this.messageObject.messageOwner.views, 0));
            this.title[0].setText(LocaleController.getString("StatisticViews", R.string.StatisticViews));
            if (MessageStatisticActivity.this.publicChats > 0) {
                this.cell[1].setVisibility(0);
                this.primary[1].setText(AndroidUtilities.formatWholeNumber(MessageStatisticActivity.this.publicChats, 0));
                this.title[1].setText(LocaleController.formatString("PublicShares", R.string.PublicShares, new Object[0]));
            } else {
                this.cell[1].setVisibility(8);
            }
            int i = MessageStatisticActivity.this.messageObject.messageOwner.forwards - MessageStatisticActivity.this.publicChats;
            if (i > 0) {
                this.cell[2].setVisibility(0);
                this.primary[2].setText(AndroidUtilities.formatWholeNumber(i, 0));
                this.title[2].setText(LocaleController.formatString("PrivateShares", R.string.PrivateShares, new Object[0]));
            } else {
                this.cell[2].setVisibility(8);
            }
            updateColors();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateColors() {
            for (int i = 0; i < 3; i++) {
                this.primary[i].setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
                this.title[i].setTextColor(Theme.getColor("windowBackgroundWhiteGrayText2"));
            }
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: ir.eitaa.ui.-$$Lambda$MessageStatisticActivity$Zm13aImoaaLmPKOKy8ckIrnzsTw
            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() {
                this.f$0.lambda$getThemeDescriptions$9$MessageStatisticActivity();
            }

            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public /* synthetic */ void onAnimationProgress(float f) {
                ThemeDescription.ThemeDescriptionDelegate.CC.$default$onAnimationProgress(this, f);
            }
        };
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{HeaderCell.class, ManageChatUserCell.class}, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundGray"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
        ChatAvatarContainer chatAvatarContainer = this.avatarContainer;
        arrayList.add(new ThemeDescription(chatAvatarContainer != null ? chatAvatarContainer.getTitleTextView() : null, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "player_actionBarTitle"));
        ChatAvatarContainer chatAvatarContainer2 = this.avatarContainer;
        arrayList.add(new ThemeDescription(chatAvatarContainer2 != null ? chatAvatarContainer2.getSubtitleTextView() : null, ThemeDescription.FLAG_TEXTCOLOR | ThemeDescription.FLAG_CHECKTAG, (Class[]) null, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "player_actionBarSubtitle", (Object) null));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "statisticChartLineEmpty"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, "divider"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ShadowSectionCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueHeader"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{ManageChatUserCell.class}, new String[]{"nameTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{ManageChatUserCell.class}, new String[]{"statusColor"}, (Paint[]) null, (Drawable[]) null, themeDescriptionDelegate, "windowBackgroundWhiteGrayText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{ManageChatUserCell.class}, new String[]{"statusOnlineColor"}, (Paint[]) null, (Drawable[]) null, themeDescriptionDelegate, "windowBackgroundWhiteBlueText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{ManageChatUserCell.class}, null, Theme.avatarDrawables, null, "avatar_text"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundRed"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundOrange"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundViolet"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundGreen"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundCyan"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundBlue"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundPink"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SUBMENUBACKGROUND, null, null, null, null, "actionBarDefaultSubmenuBackground"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SUBMENUITEM, null, null, null, null, "actionBarDefaultSubmenuItem"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SUBMENUITEM | ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, "actionBarDefaultSubmenuItemIcon"));
        StatisticActivity.putColorFromData(this.interactionsViewData, arrayList, themeDescriptionDelegate);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getThemeDescriptions$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getThemeDescriptions$9$MessageStatisticActivity() {
        RecyclerListView recyclerListView = this.listView;
        if (recyclerListView != null) {
            int childCount = recyclerListView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                recolorRecyclerItem(this.listView.getChildAt(i));
            }
            int hiddenChildCount = this.listView.getHiddenChildCount();
            for (int i2 = 0; i2 < hiddenChildCount; i2++) {
                recolorRecyclerItem(this.listView.getHiddenChildAt(i2));
            }
            int cachedChildCount = this.listView.getCachedChildCount();
            for (int i3 = 0; i3 < cachedChildCount; i3++) {
                recolorRecyclerItem(this.listView.getCachedChildAt(i3));
            }
            int attachedScrapChildCount = this.listView.getAttachedScrapChildCount();
            for (int i4 = 0; i4 < attachedScrapChildCount; i4++) {
                recolorRecyclerItem(this.listView.getAttachedScrapChildAt(i4));
            }
            this.listView.getRecycledViewPool().clear();
        }
        BaseChartView.SharedUiComponents sharedUiComponents = this.sharedUi;
        if (sharedUiComponents != null) {
            sharedUiComponents.invalidate();
        }
        this.avatarContainer.getSubtitleTextView().setLinkTextColor(Theme.getColor("player_actionBarSubtitle"));
    }

    private void recolorRecyclerItem(View child) {
        if (child instanceof ManageChatUserCell) {
            ((ManageChatUserCell) child).update(0);
        } else if (child instanceof StatisticActivity.BaseChartCell) {
            ((StatisticActivity.BaseChartCell) child).recolor();
            child.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
        } else if (child instanceof ShadowSectionCell) {
            CombinedDrawable combinedDrawable = new CombinedDrawable(new ColorDrawable(Theme.getColor("windowBackgroundGray")), Theme.getThemedDrawable(ApplicationLoader.applicationContext, R.drawable.greydivider, "windowBackgroundGrayShadow"), 0, 0);
            combinedDrawable.setFullsize(true);
            child.setBackground(combinedDrawable);
        } else if (child instanceof ChartHeaderView) {
            ((ChartHeaderView) child).recolor();
        } else if (child instanceof OverviewCell) {
            ((OverviewCell) child).updateColors();
            child.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
        }
        if (child instanceof EmptyCell) {
            child.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
        }
    }
}
