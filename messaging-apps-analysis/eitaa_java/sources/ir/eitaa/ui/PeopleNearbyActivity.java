package ir.eitaa.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Property;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.BuildVars;
import ir.eitaa.messenger.ChatObject;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.LocationController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$Peer;
import ir.eitaa.tgnet.TLRPC$PeerLocated;
import ir.eitaa.tgnet.TLRPC$TL_channels_getAdminedPublicChannels;
import ir.eitaa.tgnet.TLRPC$TL_contacts_getLocated;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_inputGeoPoint;
import ir.eitaa.tgnet.TLRPC$TL_peerChat;
import ir.eitaa.tgnet.TLRPC$TL_peerLocated;
import ir.eitaa.tgnet.TLRPC$TL_peerSelfLocated;
import ir.eitaa.tgnet.TLRPC$TL_peerUser;
import ir.eitaa.tgnet.TLRPC$TL_updatePeerLocated;
import ir.eitaa.tgnet.TLRPC$TL_updates;
import ir.eitaa.tgnet.TLRPC$Update;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Cells.HeaderCell;
import ir.eitaa.ui.Cells.ManageChatTextCell;
import ir.eitaa.ui.Cells.ManageChatUserCell;
import ir.eitaa.ui.Cells.ShadowSectionCell;
import ir.eitaa.ui.Components.AlertsCreator;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.RadialProgressView;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.Components.ShareLocationDrawable;
import ir.eitaa.ui.Components.UndoView;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class PeopleNearbyActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate, LocationController.LocationFetchCallback {
    private AnimatorSet actionBarAnimator;
    private View actionBarBackground;
    private boolean canCreateGroup;
    private int chatsCreateRow;
    private int chatsEndRow;
    private int chatsHeaderRow;
    private int chatsSectionRow;
    private int chatsStartRow;
    private Runnable checkExpiredRunnable;
    private boolean checkingCanCreate;
    private String currentGroupCreateAddress;
    private String currentGroupCreateDisplayAddress;
    private Location currentGroupCreateLocation;
    private boolean expanded;
    private boolean firstLoaded;
    private ActionIntroActivity groupCreateActivity;
    private int helpRow;
    private int helpSectionRow;
    private DefaultItemAnimator itemAnimator;
    private Location lastLoadedLocation;
    private long lastLoadedLocationTime;
    private LinearLayoutManager layoutManager;
    private RecyclerListView listView;
    private ListAdapter listViewAdapter;
    private AlertDialog loadingDialog;
    private int reqId;
    private int rowCount;
    private int showMeRow;
    private int showMoreRow;
    private AnimatorSet showProgressAnimation;
    private Runnable showProgressRunnable;
    private boolean showingLoadingProgress;
    private boolean showingMe;
    private UndoView undoView;
    private int usersEndRow;
    private int usersHeaderRow;
    private int usersSectionRow;
    private int usersStartRow;
    private ArrayList<View> animatingViews = new ArrayList<>();
    private Runnable shortPollRunnable = new Runnable() { // from class: ir.eitaa.ui.PeopleNearbyActivity.1
        @Override // java.lang.Runnable
        public void run() throws InterruptedException {
            if (PeopleNearbyActivity.this.shortPollRunnable != null) {
                PeopleNearbyActivity.this.sendRequest(true, 0);
                AndroidUtilities.cancelRunOnUIThread(PeopleNearbyActivity.this.shortPollRunnable);
                AndroidUtilities.runOnUIThread(PeopleNearbyActivity.this.shortPollRunnable, 25000L);
            }
        }
    };
    private int[] location = new int[2];
    private ArrayList<TLRPC$TL_peerLocated> users = new ArrayList<>(getLocationController().getCachedNearbyUsers());
    private ArrayList<TLRPC$TL_peerLocated> chats = new ArrayList<>(getLocationController().getCachedNearbyChats());

    public PeopleNearbyActivity() {
        checkForExpiredLocations(false);
        updateRows(null);
    }

    private void updateRows(DiffCallback diffCallback) {
        int iMin;
        this.rowCount = 0;
        this.usersStartRow = -1;
        this.usersEndRow = -1;
        this.showMoreRow = -1;
        this.chatsStartRow = -1;
        this.chatsEndRow = -1;
        this.chatsCreateRow = -1;
        this.showMeRow = -1;
        int i = 0 + 1;
        this.rowCount = i;
        this.helpRow = 0;
        int i2 = i + 1;
        this.rowCount = i2;
        this.helpSectionRow = i;
        int i3 = i2 + 1;
        this.rowCount = i3;
        this.usersHeaderRow = i2;
        this.rowCount = i3 + 1;
        this.showMeRow = i3;
        if (!this.users.isEmpty()) {
            if (this.expanded) {
                iMin = this.users.size();
            } else {
                iMin = Math.min(5, this.users.size());
            }
            int i4 = this.rowCount;
            this.usersStartRow = i4;
            int i5 = i4 + iMin;
            this.rowCount = i5;
            this.usersEndRow = i5;
            if (iMin != this.users.size()) {
                int i6 = this.rowCount;
                this.rowCount = i6 + 1;
                this.showMoreRow = i6;
            }
        }
        int i7 = this.rowCount;
        int i8 = i7 + 1;
        this.rowCount = i8;
        this.usersSectionRow = i7;
        int i9 = i8 + 1;
        this.rowCount = i9;
        this.chatsHeaderRow = i8;
        this.rowCount = i9 + 1;
        this.chatsCreateRow = i9;
        if (!this.chats.isEmpty()) {
            int i10 = this.rowCount;
            this.chatsStartRow = i10;
            int size = i10 + this.chats.size();
            this.rowCount = size;
            this.chatsEndRow = size;
        }
        int i11 = this.rowCount;
        this.rowCount = i11 + 1;
        this.chatsSectionRow = i11;
        if (this.listViewAdapter != null) {
            if (diffCallback == null) {
                this.listView.setItemAnimator(null);
                this.listViewAdapter.notifyDataSetChanged();
            } else {
                this.listView.setItemAnimator(this.itemAnimator);
                diffCallback.fillPositions(diffCallback.newPositionToItem);
                DiffUtil.calculateDiff(diffCallback).dispatchUpdatesTo(this.listViewAdapter);
            }
        }
    }

    private class DiffCallback extends DiffUtil.Callback {
        SparseIntArray newPositionToItem;
        private final ArrayList<TLRPC$TL_peerLocated> oldChats;
        int oldChatsEndRow;
        int oldChatsStartRow;
        SparseIntArray oldPositionToItem;
        int oldRowCount;
        private final ArrayList<TLRPC$TL_peerLocated> oldUsers;
        int oldUsersEndRow;
        int oldUsersStartRow;

        private DiffCallback() {
            this.oldPositionToItem = new SparseIntArray();
            this.newPositionToItem = new SparseIntArray();
            this.oldUsers = new ArrayList<>();
            this.oldChats = new ArrayList<>();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getOldListSize() {
            return this.oldRowCount;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getNewListSize() {
            return PeopleNearbyActivity.this.rowCount;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            int i;
            int i2;
            if (newItemPosition >= PeopleNearbyActivity.this.usersStartRow && newItemPosition < PeopleNearbyActivity.this.usersEndRow && oldItemPosition >= (i2 = this.oldUsersStartRow) && oldItemPosition < this.oldUsersEndRow) {
                return MessageObject.getPeerId(this.oldUsers.get(oldItemPosition - i2).peer) == MessageObject.getPeerId(((TLRPC$TL_peerLocated) PeopleNearbyActivity.this.users.get(newItemPosition - PeopleNearbyActivity.this.usersStartRow)).peer);
            }
            if (newItemPosition >= PeopleNearbyActivity.this.chatsStartRow && newItemPosition < PeopleNearbyActivity.this.chatsEndRow && oldItemPosition >= (i = this.oldChatsStartRow) && oldItemPosition < this.oldChatsEndRow) {
                return MessageObject.getPeerId(this.oldChats.get(oldItemPosition - i).peer) == MessageObject.getPeerId(((TLRPC$TL_peerLocated) PeopleNearbyActivity.this.chats.get(newItemPosition - PeopleNearbyActivity.this.chatsStartRow)).peer);
            }
            int i3 = this.oldPositionToItem.get(oldItemPosition, -1);
            return i3 == this.newPositionToItem.get(newItemPosition, -1) && i3 >= 0;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            return areItemsTheSame(oldItemPosition, newItemPosition);
        }

        public void fillPositions(SparseIntArray sparseIntArray) {
            sparseIntArray.clear();
            put(1, PeopleNearbyActivity.this.helpRow, sparseIntArray);
            put(2, PeopleNearbyActivity.this.helpSectionRow, sparseIntArray);
            put(3, PeopleNearbyActivity.this.usersHeaderRow, sparseIntArray);
            put(4, PeopleNearbyActivity.this.showMoreRow, sparseIntArray);
            put(5, PeopleNearbyActivity.this.usersSectionRow, sparseIntArray);
            put(6, PeopleNearbyActivity.this.chatsHeaderRow, sparseIntArray);
            put(7, PeopleNearbyActivity.this.chatsCreateRow, sparseIntArray);
            put(8, PeopleNearbyActivity.this.chatsSectionRow, sparseIntArray);
            put(9, PeopleNearbyActivity.this.showMeRow, sparseIntArray);
        }

        public void saveCurrentState() {
            this.oldRowCount = PeopleNearbyActivity.this.rowCount;
            this.oldUsersStartRow = PeopleNearbyActivity.this.usersStartRow;
            this.oldUsersEndRow = PeopleNearbyActivity.this.usersEndRow;
            this.oldChatsStartRow = PeopleNearbyActivity.this.chatsStartRow;
            this.oldChatsEndRow = PeopleNearbyActivity.this.chatsEndRow;
            this.oldUsers.addAll(PeopleNearbyActivity.this.users);
            this.oldChats.addAll(PeopleNearbyActivity.this.chats);
            fillPositions(this.oldPositionToItem);
        }

        private void put(int id, int position, SparseIntArray sparseIntArray) {
            if (position >= 0) {
                sparseIntArray.put(position, id);
            }
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() throws InterruptedException {
        super.onFragmentCreate();
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.newLocationAvailable);
        getNotificationCenter().addObserver(this, NotificationCenter.newPeopleNearbyAvailable);
        getNotificationCenter().addObserver(this, NotificationCenter.needDeleteDialog);
        checkCanCreateGroup();
        sendRequest(false, 0);
        AndroidUtilities.runOnUIThread(this.shortPollRunnable, 25000L);
        return true;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() throws InterruptedException {
        super.onFragmentDestroy();
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.newLocationAvailable);
        getNotificationCenter().removeObserver(this, NotificationCenter.newPeopleNearbyAvailable);
        getNotificationCenter().removeObserver(this, NotificationCenter.needDeleteDialog);
        Runnable runnable = this.shortPollRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
            this.shortPollRunnable = null;
        }
        Runnable runnable2 = this.checkExpiredRunnable;
        if (runnable2 != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable2);
            this.checkExpiredRunnable = null;
        }
        Runnable runnable3 = this.showProgressRunnable;
        if (runnable3 != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable3);
            this.showProgressRunnable = null;
        }
        UndoView undoView = this.undoView;
        if (undoView != null) {
            undoView.hide(true, 0);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setBackgroundDrawable(null);
        this.actionBar.setTitleColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.actionBar.setItemsColor(Theme.getColor("windowBackgroundWhiteBlackText"), false);
        this.actionBar.setItemsBackgroundColor(Theme.getColor("listSelectorSDK21"), false);
        this.actionBar.setCastShadows(false);
        this.actionBar.setAddToContainer(false);
        this.actionBar.setOccupyStatusBar(Build.VERSION.SDK_INT >= 21 && !AndroidUtilities.isTablet());
        this.actionBar.setTitle(LocaleController.getString("PeopleNearby", R.string.PeopleNearby));
        this.actionBar.getTitleTextView().setAlpha(0.0f);
        if (!AndroidUtilities.isTablet()) {
            this.actionBar.showActionModeTop();
        }
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.eitaa.ui.PeopleNearbyActivity.2
            @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int id) {
                if (id == -1) {
                    PeopleNearbyActivity.this.finishFragment();
                }
            }
        });
        FrameLayout frameLayout = new FrameLayout(context) { // from class: ir.eitaa.ui.PeopleNearbyActivity.3
            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                ((FrameLayout.LayoutParams) PeopleNearbyActivity.this.actionBarBackground.getLayoutParams()).height = ActionBar.getCurrentActionBarHeight() + (((BaseFragment) PeopleNearbyActivity.this).actionBar.getOccupyStatusBar() ? AndroidUtilities.statusBarHeight : 0) + AndroidUtilities.dp(3.0f);
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            }

            @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
                super.onLayout(changed, left, top, right, bottom);
                PeopleNearbyActivity.this.checkScroll(false);
            }
        };
        this.fragmentView = frameLayout;
        frameLayout.setBackgroundColor(Theme.getColor("windowBackgroundGray"));
        this.fragmentView.setTag("windowBackgroundGray");
        FrameLayout frameLayout2 = (FrameLayout) this.fragmentView;
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        recyclerListView.setGlowColor(0);
        RecyclerListView recyclerListView2 = this.listView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, 1, false);
        this.layoutManager = linearLayoutManager;
        recyclerListView2.setLayoutManager(linearLayoutManager);
        RecyclerListView recyclerListView3 = this.listView;
        ListAdapter listAdapter = new ListAdapter(context);
        this.listViewAdapter = listAdapter;
        recyclerListView3.setAdapter(listAdapter);
        this.listView.setVerticalScrollbarPosition(LocaleController.isRTL ? 1 : 2);
        frameLayout2.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f));
        this.itemAnimator = new DefaultItemAnimator() { // from class: ir.eitaa.ui.PeopleNearbyActivity.4
            @Override // androidx.recyclerview.widget.DefaultItemAnimator
            protected long getAddAnimationDelay(long removeDuration, long moveDuration, long changeDuration) {
                return removeDuration;
            }
        };
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PeopleNearbyActivity$z7F9Va8QvWOz-pmaCQUNkFBSVS8
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i) throws InterruptedException {
                this.f$0.lambda$createView$2$PeopleNearbyActivity(view, i);
            }
        });
        this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.eitaa.ui.PeopleNearbyActivity.5
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                PeopleNearbyActivity.this.checkScroll(true);
            }
        });
        View view = new View(context) { // from class: ir.eitaa.ui.PeopleNearbyActivity.6
            private Paint paint = new Paint();

            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                this.paint.setColor(Theme.getColor("windowBackgroundWhite"));
                int measuredHeight = getMeasuredHeight() - AndroidUtilities.dp(3.0f);
                canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), measuredHeight, this.paint);
                ((BaseFragment) PeopleNearbyActivity.this).parentLayout.drawHeaderShadow(canvas, measuredHeight);
            }
        };
        this.actionBarBackground = view;
        view.setAlpha(0.0f);
        frameLayout2.addView(this.actionBarBackground, LayoutHelper.createFrame(-1, -2.0f));
        frameLayout2.addView(this.actionBar, LayoutHelper.createFrame(-1, -2.0f));
        UndoView undoView = new UndoView(context);
        this.undoView = undoView;
        frameLayout2.addView(undoView, LayoutHelper.createFrame(-1, -2.0f, 83, 8.0f, 0.0f, 8.0f, 8.0f));
        updateRows(null);
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$2$PeopleNearbyActivity(View view, int i) throws InterruptedException {
        long j;
        if (getParentActivity() == null) {
            return;
        }
        int i2 = this.usersStartRow;
        if (i >= i2 && i < this.usersEndRow) {
            if (view instanceof ManageChatUserCell) {
                TLRPC$TL_peerLocated tLRPC$TL_peerLocated = this.users.get(i - i2);
                Bundle bundle = new Bundle();
                bundle.putLong("user_id", tLRPC$TL_peerLocated.peer.user_id);
                if (((ManageChatUserCell) view).hasAvatarSet()) {
                    bundle.putBoolean("expandPhoto", true);
                }
                bundle.putInt("nearby_distance", tLRPC$TL_peerLocated.distance);
                MessagesController.getInstance(this.currentAccount).ensureMessagesLoaded(tLRPC$TL_peerLocated.peer.user_id, 0, null);
                presentFragment(new ProfileActivity(bundle));
                return;
            }
            return;
        }
        int i3 = this.chatsStartRow;
        if (i >= i3 && i < this.chatsEndRow) {
            TLRPC$TL_peerLocated tLRPC$TL_peerLocated2 = this.chats.get(i - i3);
            Bundle bundle2 = new Bundle();
            TLRPC$Peer tLRPC$Peer = tLRPC$TL_peerLocated2.peer;
            if (tLRPC$Peer instanceof TLRPC$TL_peerChat) {
                j = tLRPC$Peer.chat_id;
            } else {
                j = tLRPC$Peer.channel_id;
            }
            bundle2.putLong("chat_id", j);
            presentFragment(new ChatActivity(bundle2));
            return;
        }
        if (i == this.chatsCreateRow) {
            if (this.checkingCanCreate || this.currentGroupCreateAddress == null) {
                AlertDialog alertDialog = new AlertDialog(getParentActivity(), 3);
                this.loadingDialog = alertDialog;
                alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: ir.eitaa.ui.-$$Lambda$PeopleNearbyActivity$twhUYq200UUnDx_KpfMDZFMDQhM
                    @Override // android.content.DialogInterface.OnCancelListener
                    public final void onCancel(DialogInterface dialogInterface) {
                        this.f$0.lambda$createView$0$PeopleNearbyActivity(dialogInterface);
                    }
                });
                this.loadingDialog.show();
                return;
            }
            openGroupCreate();
            return;
        }
        if (i == this.showMeRow) {
            final UserConfig userConfig = getUserConfig();
            if (this.showingMe) {
                userConfig.sharingMyLocationUntil = 0;
                userConfig.saveConfig(false);
                sendRequest(false, 2);
                updateRows(null);
            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
                builder.setTitle(LocaleController.getString("MakeMyselfVisibleTitle", R.string.MakeMyselfVisibleTitle));
                builder.setMessage(LocaleController.getString("MakeMyselfVisibleInfo", R.string.MakeMyselfVisibleInfo));
                builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PeopleNearbyActivity$KnsjMKaj8pE_gircM7THrPVBc7c
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i4) throws InterruptedException {
                        this.f$0.lambda$createView$1$PeopleNearbyActivity(userConfig, dialogInterface, i4);
                    }
                });
                builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                showDialog(builder.create());
            }
            userConfig.saveConfig(false);
            return;
        }
        if (i == this.showMoreRow) {
            this.expanded = true;
            DiffCallback diffCallback = new DiffCallback();
            diffCallback.saveCurrentState();
            updateRows(diffCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$0$PeopleNearbyActivity(DialogInterface dialogInterface) {
        this.loadingDialog = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$1$PeopleNearbyActivity(UserConfig userConfig, DialogInterface dialogInterface, int i) throws InterruptedException {
        userConfig.sharingMyLocationUntil = ConnectionsManager.DEFAULT_DATACENTER_ID;
        userConfig.saveConfig(false);
        sendRequest(false, 1);
        updateRows(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:4:0x000a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void checkScroll(boolean r11) {
        /*
            r10 = this;
            androidx.recyclerview.widget.LinearLayoutManager r0 = r10.layoutManager
            int r0 = r0.findFirstVisibleItemPosition()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto Lc
        La:
            r0 = 1
            goto L39
        Lc:
            ir.eitaa.ui.Components.RecyclerListView r3 = r10.listView
            androidx.recyclerview.widget.RecyclerView$ViewHolder r0 = r3.findViewHolderForAdapterPosition(r0)
            if (r0 != 0) goto L15
            goto La
        L15:
            android.view.View r0 = r0.itemView
            ir.eitaa.ui.PeopleNearbyActivity$HintInnerCell r0 = (ir.eitaa.ui.PeopleNearbyActivity.HintInnerCell) r0
            android.widget.TextView r3 = ir.eitaa.ui.PeopleNearbyActivity.HintInnerCell.access$2200(r0)
            int[] r4 = r10.location
            r3.getLocationOnScreen(r4)
            int[] r3 = r10.location
            r3 = r3[r2]
            android.widget.TextView r0 = ir.eitaa.ui.PeopleNearbyActivity.HintInnerCell.access$2200(r0)
            int r0 = r0.getMeasuredHeight()
            int r3 = r3 + r0
            ir.eitaa.ui.ActionBar.ActionBar r0 = r10.actionBar
            int r0 = r0.getBottom()
            if (r3 >= r0) goto L38
            goto La
        L38:
            r0 = 0
        L39:
            android.view.View r3 = r10.actionBarBackground
            java.lang.Object r3 = r3.getTag()
            if (r3 != 0) goto L43
            r3 = 1
            goto L44
        L43:
            r3 = 0
        L44:
            if (r0 == r3) goto Lc8
            android.view.View r3 = r10.actionBarBackground
            r4 = 0
            if (r0 == 0) goto L4d
            r5 = r4
            goto L51
        L4d:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r2)
        L51:
            r3.setTag(r5)
            android.animation.AnimatorSet r3 = r10.actionBarAnimator
            if (r3 == 0) goto L5d
            r3.cancel()
            r10.actionBarAnimator = r4
        L5d:
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            if (r11 == 0) goto Lb0
            android.animation.AnimatorSet r11 = new android.animation.AnimatorSet
            r11.<init>()
            r10.actionBarAnimator = r11
            r5 = 2
            android.animation.Animator[] r5 = new android.animation.Animator[r5]
            android.view.View r6 = r10.actionBarBackground
            android.util.Property r7 = android.view.View.ALPHA
            float[] r8 = new float[r2]
            if (r0 == 0) goto L77
            r9 = 1065353216(0x3f800000, float:1.0)
            goto L78
        L77:
            r9 = 0
        L78:
            r8[r1] = r9
            android.animation.ObjectAnimator r6 = android.animation.ObjectAnimator.ofFloat(r6, r7, r8)
            r5[r1] = r6
            ir.eitaa.ui.ActionBar.ActionBar r6 = r10.actionBar
            ir.eitaa.ui.ActionBar.SimpleTextView r6 = r6.getTitleTextView()
            android.util.Property r7 = android.view.View.ALPHA
            float[] r8 = new float[r2]
            if (r0 == 0) goto L8d
            goto L8e
        L8d:
            r3 = 0
        L8e:
            r8[r1] = r3
            android.animation.ObjectAnimator r0 = android.animation.ObjectAnimator.ofFloat(r6, r7, r8)
            r5[r2] = r0
            r11.playTogether(r5)
            android.animation.AnimatorSet r11 = r10.actionBarAnimator
            r0 = 150(0x96, double:7.4E-322)
            r11.setDuration(r0)
            android.animation.AnimatorSet r11 = r10.actionBarAnimator
            ir.eitaa.ui.PeopleNearbyActivity$7 r0 = new ir.eitaa.ui.PeopleNearbyActivity$7
            r0.<init>()
            r11.addListener(r0)
            android.animation.AnimatorSet r11 = r10.actionBarAnimator
            r11.start()
            goto Lc8
        Lb0:
            android.view.View r11 = r10.actionBarBackground
            if (r0 == 0) goto Lb7
            r1 = 1065353216(0x3f800000, float:1.0)
            goto Lb8
        Lb7:
            r1 = 0
        Lb8:
            r11.setAlpha(r1)
            ir.eitaa.ui.ActionBar.ActionBar r11 = r10.actionBar
            ir.eitaa.ui.ActionBar.SimpleTextView r11 = r11.getTitleTextView()
            if (r0 == 0) goto Lc4
            goto Lc5
        Lc4:
            r3 = 0
        Lc5:
            r11.setAlpha(r3)
        Lc8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.PeopleNearbyActivity.checkScroll(boolean):void");
    }

    private void openGroupCreate() throws InterruptedException {
        if (!this.canCreateGroup) {
            AlertsCreator.showSimpleAlert(this, LocaleController.getString("YourLocatedChannelsTooMuch", R.string.YourLocatedChannelsTooMuch));
            return;
        }
        ActionIntroActivity actionIntroActivity = new ActionIntroActivity(2);
        this.groupCreateActivity = actionIntroActivity;
        actionIntroActivity.setGroupCreateAddress(this.currentGroupCreateAddress, this.currentGroupCreateDisplayAddress, this.currentGroupCreateLocation);
        presentFragment(this.groupCreateActivity);
    }

    private void checkCanCreateGroup() {
        if (this.checkingCanCreate) {
            return;
        }
        this.checkingCanCreate = true;
        TLRPC$TL_channels_getAdminedPublicChannels tLRPC$TL_channels_getAdminedPublicChannels = new TLRPC$TL_channels_getAdminedPublicChannels();
        tLRPC$TL_channels_getAdminedPublicChannels.by_location = true;
        tLRPC$TL_channels_getAdminedPublicChannels.check_limit = true;
        getConnectionsManager().bindRequestToGuid(getConnectionsManager().sendRequest(tLRPC$TL_channels_getAdminedPublicChannels, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$PeopleNearbyActivity$TBo4bXIk9o9ifCJaSaJY4WP8cHc
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$checkCanCreateGroup$4$PeopleNearbyActivity(tLObject, tLRPC$TL_error);
            }
        }), this.classGuid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkCanCreateGroup$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkCanCreateGroup$4$PeopleNearbyActivity(TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PeopleNearbyActivity$ndjM2muI91gRBJFnW5rNDOVLU6c
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                this.f$0.lambda$checkCanCreateGroup$3$PeopleNearbyActivity(tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkCanCreateGroup$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkCanCreateGroup$3$PeopleNearbyActivity(TLRPC$TL_error tLRPC$TL_error) throws InterruptedException {
        this.canCreateGroup = tLRPC$TL_error == null;
        this.checkingCanCreate = false;
        AlertDialog alertDialog = this.loadingDialog;
        if (alertDialog == null || this.currentGroupCreateAddress == null) {
            return;
        }
        try {
            alertDialog.dismiss();
        } catch (Throwable th) {
            FileLog.e(th);
        }
        this.loadingDialog = null;
        openGroupCreate();
    }

    private void showLoadingProgress(boolean show) {
        if (this.showingLoadingProgress == show) {
            return;
        }
        this.showingLoadingProgress = show;
        AnimatorSet animatorSet = this.showProgressAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.showProgressAnimation = null;
        }
        if (this.listView == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int childCount = this.listView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.listView.getChildAt(i);
            if (childAt instanceof HeaderCellProgress) {
                HeaderCellProgress headerCellProgress = (HeaderCellProgress) childAt;
                this.animatingViews.add(headerCellProgress);
                RadialProgressView radialProgressView = headerCellProgress.progressView;
                Property property = View.ALPHA;
                float[] fArr = new float[1];
                fArr[0] = show ? 1.0f : 0.0f;
                arrayList.add(ObjectAnimator.ofFloat(radialProgressView, (Property<RadialProgressView, Float>) property, fArr));
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.showProgressAnimation = animatorSet2;
        animatorSet2.playTogether(arrayList);
        this.showProgressAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.PeopleNearbyActivity.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                PeopleNearbyActivity.this.showProgressAnimation = null;
                PeopleNearbyActivity.this.animatingViews.clear();
            }
        });
        this.showProgressAnimation.setDuration(180L);
        this.showProgressAnimation.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendRequest(boolean shortpoll, final int share) throws InterruptedException {
        Location location;
        if (!this.firstLoaded) {
            Runnable runnable = new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PeopleNearbyActivity$hbC-aS_jcekw-Xx7dPzwQRLB1ok
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$sendRequest$5$PeopleNearbyActivity();
                }
            };
            this.showProgressRunnable = runnable;
            AndroidUtilities.runOnUIThread(runnable, 1000L);
            this.firstLoaded = true;
        }
        Location lastKnownLocation = getLocationController().getLastKnownLocation();
        if (lastKnownLocation == null) {
            return;
        }
        this.currentGroupCreateLocation = lastKnownLocation;
        if (!shortpoll && (location = this.lastLoadedLocation) != null) {
            float fDistanceTo = location.distanceTo(lastKnownLocation);
            if (BuildVars.DEBUG_VERSION) {
                FileLog.d("located distance = " + fDistanceTo);
            }
            if (share == 0 && (SystemClock.elapsedRealtime() - this.lastLoadedLocationTime < 3000 || this.lastLoadedLocation.distanceTo(lastKnownLocation) <= 20.0f)) {
                return;
            }
            if (this.reqId != 0) {
                getConnectionsManager().cancelRequest(this.reqId, true);
                this.reqId = 0;
            }
        }
        if (this.reqId != 0) {
            return;
        }
        this.lastLoadedLocation = lastKnownLocation;
        this.lastLoadedLocationTime = SystemClock.elapsedRealtime();
        LocationController.fetchLocationAddress(this.currentGroupCreateLocation, this);
        TLRPC$TL_contacts_getLocated tLRPC$TL_contacts_getLocated = new TLRPC$TL_contacts_getLocated();
        TLRPC$TL_inputGeoPoint tLRPC$TL_inputGeoPoint = new TLRPC$TL_inputGeoPoint();
        tLRPC$TL_contacts_getLocated.geo_point = tLRPC$TL_inputGeoPoint;
        tLRPC$TL_inputGeoPoint.lat = lastKnownLocation.getLatitude();
        tLRPC$TL_contacts_getLocated.geo_point._long = lastKnownLocation.getLongitude();
        if (share != 0) {
            tLRPC$TL_contacts_getLocated.flags |= 1;
            tLRPC$TL_contacts_getLocated.self_expires = share == 1 ? ConnectionsManager.DEFAULT_DATACENTER_ID : 0;
        }
        this.reqId = getConnectionsManager().sendRequest(tLRPC$TL_contacts_getLocated, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$PeopleNearbyActivity$0BWsV3CJQMiergNEZ_KzhZ6psR8
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$sendRequest$7$PeopleNearbyActivity(share, tLObject, tLRPC$TL_error);
            }
        });
        getConnectionsManager().bindRequestToGuid(this.reqId, this.classGuid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$sendRequest$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$sendRequest$5$PeopleNearbyActivity() {
        showLoadingProgress(true);
        this.showProgressRunnable = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$sendRequest$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$sendRequest$7$PeopleNearbyActivity(final int i, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PeopleNearbyActivity$GryWCoCN2pdkE004XLFVmVfvTag
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$sendRequest$6$PeopleNearbyActivity(i, tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$sendRequest$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$sendRequest$6$PeopleNearbyActivity(int i, TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
        boolean z;
        this.reqId = 0;
        Runnable runnable = this.showProgressRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
            this.showProgressRunnable = null;
        }
        showLoadingProgress(false);
        UserConfig userConfig = getUserConfig();
        if (i != 1 || tLRPC$TL_error == null) {
            z = false;
        } else {
            userConfig.sharingMyLocationUntil = 0;
            updateRows(null);
            z = true;
        }
        if (tLObject != null && i != 2) {
            TLRPC$TL_updates tLRPC$TL_updates = (TLRPC$TL_updates) tLObject;
            getMessagesController().putUsers(tLRPC$TL_updates.users, false);
            getMessagesController().putChats(tLRPC$TL_updates.chats, false);
            DiffCallback diffCallback = new DiffCallback();
            diffCallback.saveCurrentState();
            this.users.clear();
            this.chats.clear();
            if (userConfig.sharingMyLocationUntil != 0) {
                userConfig.lastMyLocationShareTime = (int) (System.currentTimeMillis() / 1000);
                z = true;
            }
            int size = tLRPC$TL_updates.updates.size();
            boolean z2 = false;
            for (int i2 = 0; i2 < size; i2++) {
                TLRPC$Update tLRPC$Update = tLRPC$TL_updates.updates.get(i2);
                if (tLRPC$Update instanceof TLRPC$TL_updatePeerLocated) {
                    TLRPC$TL_updatePeerLocated tLRPC$TL_updatePeerLocated = (TLRPC$TL_updatePeerLocated) tLRPC$Update;
                    int size2 = tLRPC$TL_updatePeerLocated.peers.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        TLRPC$PeerLocated tLRPC$PeerLocated = tLRPC$TL_updatePeerLocated.peers.get(i3);
                        if (tLRPC$PeerLocated instanceof TLRPC$TL_peerLocated) {
                            TLRPC$TL_peerLocated tLRPC$TL_peerLocated = (TLRPC$TL_peerLocated) tLRPC$PeerLocated;
                            if (tLRPC$TL_peerLocated.peer instanceof TLRPC$TL_peerUser) {
                                this.users.add(tLRPC$TL_peerLocated);
                            } else {
                                this.chats.add(tLRPC$TL_peerLocated);
                            }
                        } else if (tLRPC$PeerLocated instanceof TLRPC$TL_peerSelfLocated) {
                            int i4 = userConfig.sharingMyLocationUntil;
                            int i5 = ((TLRPC$TL_peerSelfLocated) tLRPC$PeerLocated).expires;
                            if (i4 != i5) {
                                userConfig.sharingMyLocationUntil = i5;
                                z = true;
                            }
                            z2 = true;
                        }
                    }
                }
            }
            if (!z2 && userConfig.sharingMyLocationUntil != 0) {
                userConfig.sharingMyLocationUntil = 0;
                z = true;
            }
            checkForExpiredLocations(true);
            updateRows(diffCallback);
        }
        if (z) {
            userConfig.saveConfig(false);
        }
        Runnable runnable2 = this.shortPollRunnable;
        if (runnable2 != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable2);
            AndroidUtilities.runOnUIThread(this.shortPollRunnable, 25000L);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        ListAdapter listAdapter = this.listViewAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
        getLocationController().startLocationLookupForPeopleNearby(false);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
        UndoView undoView = this.undoView;
        if (undoView != null) {
            undoView.hide(true, 0);
        }
        getLocationController().startLocationLookupForPeopleNearby(true);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    protected void onBecomeFullyHidden() {
        super.onBecomeFullyHidden();
        UndoView undoView = this.undoView;
        if (undoView != null) {
            undoView.hide(true, 0);
        }
    }

    @Override // ir.eitaa.messenger.LocationController.LocationFetchCallback
    public void onLocationAddressAvailable(String address, String displayAddress, Location location) throws InterruptedException {
        this.currentGroupCreateAddress = address;
        this.currentGroupCreateDisplayAddress = displayAddress;
        this.currentGroupCreateLocation = location;
        ActionIntroActivity actionIntroActivity = this.groupCreateActivity;
        if (actionIntroActivity != null) {
            actionIntroActivity.setGroupCreateAddress(address, displayAddress, location);
        }
        AlertDialog alertDialog = this.loadingDialog;
        if (alertDialog == null || this.checkingCanCreate) {
            return;
        }
        try {
            alertDialog.dismiss();
        } catch (Throwable th) {
            FileLog.e(th);
        }
        this.loadingDialog = null;
        openGroupCreate();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    protected void onBecomeFullyVisible() {
        super.onBecomeFullyVisible();
        this.groupCreateActivity = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0064 A[PHI: r19
      0x0064: PHI (r19v3 java.util.ArrayList<ir.eitaa.tgnet.TLRPC$TL_peerLocated>) = 
      (r19v2 java.util.ArrayList<ir.eitaa.tgnet.TLRPC$TL_peerLocated>)
      (r19v2 java.util.ArrayList<ir.eitaa.tgnet.TLRPC$TL_peerLocated>)
      (r19v4 java.util.ArrayList<ir.eitaa.tgnet.TLRPC$TL_peerLocated>)
     binds: [B:31:0x0083, B:27:0x0075, B:20:0x0061] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // ir.eitaa.ui.ActionBar.BaseFragment, ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void didReceivedNotification(int r19, int r20, java.lang.Object... r21) throws java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 227
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.PeopleNearbyActivity.didReceivedNotification(int, int, java.lang.Object[]):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$didReceivedNotification$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$didReceivedNotification$8$PeopleNearbyActivity(TLRPC$Chat tLRPC$Chat, long j, boolean z) {
        if (tLRPC$Chat != null) {
            if (ChatObject.isNotInChat(tLRPC$Chat)) {
                getMessagesController().deleteDialog(j, 0, z);
                return;
            } else {
                getMessagesController().deleteParticipantFromChat(-j, getMessagesController().getUser(Long.valueOf(getUserConfig().getClientUserId())), null, null, z, z);
                return;
            }
        }
        getMessagesController().deleteDialog(j, 0, z);
    }

    private void checkForExpiredLocations(boolean cache) {
        Runnable runnable = this.checkExpiredRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
            this.checkExpiredRunnable = null;
        }
        int currentTime = getConnectionsManager().getCurrentTime();
        DiffCallback diffCallback = null;
        int i = 0;
        boolean z = false;
        int iMin = ConnectionsManager.DEFAULT_DATACENTER_ID;
        while (i < 2) {
            ArrayList<TLRPC$TL_peerLocated> arrayList = i == 0 ? this.users : this.chats;
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                int i3 = arrayList.get(i2).expires;
                if (i3 <= currentTime) {
                    if (diffCallback == null) {
                        diffCallback = new DiffCallback();
                        diffCallback.saveCurrentState();
                    }
                    arrayList.remove(i2);
                    i2--;
                    size--;
                    z = true;
                } else {
                    iMin = Math.min(iMin, i3);
                }
                i2++;
            }
            i++;
        }
        if (z && this.listViewAdapter != null) {
            updateRows(diffCallback);
        }
        if (z || cache) {
            getLocationController().setCachedNearbyUsersAndChats(this.users, this.chats);
        }
        if (iMin != Integer.MAX_VALUE) {
            Runnable runnable2 = new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PeopleNearbyActivity$HkCJ4L9EJgQudHfpoGeSkKhEF1E
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$checkForExpiredLocations$9$PeopleNearbyActivity();
                }
            };
            this.checkExpiredRunnable = runnable2;
            AndroidUtilities.runOnUIThread(runnable2, (iMin - currentTime) * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkForExpiredLocations$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkForExpiredLocations$9$PeopleNearbyActivity() {
        this.checkExpiredRunnable = null;
        checkForExpiredLocations(false);
    }

    public static class HeaderCellProgress extends HeaderCell {
        private RadialProgressView progressView;

        public HeaderCellProgress(Context context) {
            super(context);
            setClipChildren(false);
            RadialProgressView radialProgressView = new RadialProgressView(context);
            this.progressView = radialProgressView;
            radialProgressView.setSize(AndroidUtilities.dp(14.0f));
            this.progressView.setStrokeWidth(2.0f);
            this.progressView.setAlpha(0.0f);
            this.progressView.setProgressColor(Theme.getColor("windowBackgroundWhiteBlueHeader"));
            RadialProgressView radialProgressView2 = this.progressView;
            boolean z = LocaleController.isRTL;
            addView(radialProgressView2, LayoutHelper.createFrame(50, 40.0f, (z ? 3 : 5) | 48, z ? 2.0f : 0.0f, 3.0f, z ? 0.0f : 2.0f, 0.0f));
        }
    }

    public class HintInnerCell extends FrameLayout {
        private ImageView imageView;
        private TextView messageTextView;
        private TextView titleTextView;

        public HintInnerCell(Context context) {
            super(context);
            int currentActionBarHeight = ((int) ((ActionBar.getCurrentActionBarHeight() + (((BaseFragment) PeopleNearbyActivity.this).actionBar.getOccupyStatusBar() ? AndroidUtilities.statusBarHeight : 0)) / AndroidUtilities.density)) - 44;
            ImageView imageView = new ImageView(context);
            this.imageView = imageView;
            imageView.setBackgroundDrawable(Theme.createCircleDrawable(AndroidUtilities.dp(74.0f), Theme.getColor("chats_archiveBackground")));
            this.imageView.setImageDrawable(new ShareLocationDrawable(context, 2));
            this.imageView.setScaleType(ImageView.ScaleType.CENTER);
            addView(this.imageView, LayoutHelper.createFrame(74, 74.0f, 49, 0.0f, currentActionBarHeight + 27, 0.0f, 0.0f));
            TextView textView = new TextView(context);
            this.titleTextView = textView;
            textView.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            this.titleTextView.setTextSize(1, 24.0f);
            this.titleTextView.setGravity(17);
            this.titleTextView.setText(AndroidUtilities.replaceTags(LocaleController.formatString("PeopleNearby", R.string.PeopleNearby, new Object[0])));
            addView(this.titleTextView, LayoutHelper.createFrame(-1, -2.0f, 51, 17.0f, currentActionBarHeight + R.styleable.AppCompatTheme_windowNoTitle, 17.0f, 27.0f));
            TextView textView2 = new TextView(context);
            this.messageTextView = textView2;
            textView2.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText"));
            this.messageTextView.setTextSize(1, 15.0f);
            this.messageTextView.setGravity(17);
            this.messageTextView.setText(AndroidUtilities.replaceTags(LocaleController.formatString("PeopleNearbyInfo2", R.string.PeopleNearbyInfo2, new Object[0])));
            addView(this.messageTextView, LayoutHelper.createFrame(-1, -2.0f, 51, 40.0f, currentActionBarHeight + 161, 40.0f, 27.0f));
        }
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            int itemViewType = holder.getItemViewType();
            return itemViewType == 0 || itemViewType == 2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return PeopleNearbyActivity.this.rowCount;
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
                View manageChatTextCell = new ManageChatTextCell(this.mContext);
                manageChatTextCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                shadowSectionCell = manageChatTextCell;
            } else if (i == 3) {
                View headerCellProgress = new HeaderCellProgress(this.mContext);
                headerCellProgress.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                shadowSectionCell = headerCellProgress;
            } else if (i == 4) {
                TextView textView = new TextView(this.mContext) { // from class: ir.eitaa.ui.PeopleNearbyActivity.ListAdapter.1
                    @Override // android.widget.TextView, android.view.View
                    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(67.0f), 1073741824));
                    }
                };
                textView.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                textView.setPadding(0, 0, AndroidUtilities.dp(3.0f), 0);
                textView.setTextSize(1, 14.0f);
                textView.setGravity(17);
                textView.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText3"));
                shadowSectionCell = textView;
            } else {
                View hintInnerCell = PeopleNearbyActivity.this.new HintInnerCell(this.mContext);
                hintInnerCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                shadowSectionCell = hintInnerCell;
            }
            shadowSectionCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            return new RecyclerListView.Holder(shadowSectionCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
            if (holder.getItemViewType() != 3 || PeopleNearbyActivity.this.animatingViews.contains(holder.itemView)) {
                return;
            }
            ((HeaderCellProgress) holder.itemView).progressView.setAlpha(PeopleNearbyActivity.this.showingLoadingProgress ? 1.0f : 0.0f);
        }

        private String formatDistance(TLRPC$TL_peerLocated located) {
            return LocaleController.formatDistance(located.distance, 0);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            long j;
            int itemViewType = holder.getItemViewType();
            if (itemViewType == 0) {
                ManageChatUserCell manageChatUserCell = (ManageChatUserCell) holder.itemView;
                manageChatUserCell.setTag(Integer.valueOf(position));
                if (position < PeopleNearbyActivity.this.usersStartRow || position >= PeopleNearbyActivity.this.usersEndRow) {
                    if (position < PeopleNearbyActivity.this.chatsStartRow || position >= PeopleNearbyActivity.this.chatsEndRow) {
                        return;
                    }
                    int i = position - PeopleNearbyActivity.this.chatsStartRow;
                    TLRPC$TL_peerLocated tLRPC$TL_peerLocated = (TLRPC$TL_peerLocated) PeopleNearbyActivity.this.chats.get(i);
                    TLRPC$Peer tLRPC$Peer = tLRPC$TL_peerLocated.peer;
                    if (tLRPC$Peer instanceof TLRPC$TL_peerChat) {
                        j = tLRPC$Peer.chat_id;
                    } else {
                        j = tLRPC$Peer.channel_id;
                    }
                    TLRPC$Chat chat = PeopleNearbyActivity.this.getMessagesController().getChat(Long.valueOf(j));
                    if (chat != null) {
                        String distance = formatDistance(tLRPC$TL_peerLocated);
                        int i2 = chat.participants_count;
                        if (i2 != 0) {
                            distance = String.format("%1$s, %2$s", distance, LocaleController.formatPluralString("Members", i2));
                        }
                        manageChatUserCell.setData(chat, null, distance, i != PeopleNearbyActivity.this.chats.size() - 1);
                        return;
                    }
                    return;
                }
                TLRPC$TL_peerLocated tLRPC$TL_peerLocated2 = (TLRPC$TL_peerLocated) PeopleNearbyActivity.this.users.get(position - PeopleNearbyActivity.this.usersStartRow);
                TLRPC$User user = PeopleNearbyActivity.this.getMessagesController().getUser(Long.valueOf(tLRPC$TL_peerLocated2.peer.user_id));
                if (user != null) {
                    manageChatUserCell.setData(user, null, formatDistance(tLRPC$TL_peerLocated2), (PeopleNearbyActivity.this.showMoreRow == -1 && position == PeopleNearbyActivity.this.usersEndRow - 1) ? false : true);
                    return;
                }
                return;
            }
            if (itemViewType == 1) {
                ShadowSectionCell shadowSectionCell = (ShadowSectionCell) holder.itemView;
                if (position != PeopleNearbyActivity.this.usersSectionRow) {
                    if (position != PeopleNearbyActivity.this.chatsSectionRow) {
                        if (position == PeopleNearbyActivity.this.helpSectionRow) {
                            shadowSectionCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, "windowBackgroundGrayShadow"));
                            return;
                        }
                        return;
                    }
                    shadowSectionCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
                    return;
                }
                shadowSectionCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, "windowBackgroundGrayShadow"));
                return;
            }
            if (itemViewType != 2) {
                if (itemViewType != 3) {
                    return;
                }
                HeaderCellProgress headerCellProgress = (HeaderCellProgress) holder.itemView;
                if (position != PeopleNearbyActivity.this.usersHeaderRow) {
                    if (position == PeopleNearbyActivity.this.chatsHeaderRow) {
                        headerCellProgress.setText(LocaleController.getString("ChatsNearbyHeader", R.string.ChatsNearbyHeader));
                        return;
                    }
                    return;
                }
                headerCellProgress.setText(LocaleController.getString("PeopleNearbyHeader", R.string.PeopleNearbyHeader));
                return;
            }
            ManageChatTextCell manageChatTextCell = (ManageChatTextCell) holder.itemView;
            manageChatTextCell.setColors("windowBackgroundWhiteBlueIcon", "windowBackgroundWhiteBlueButton");
            if (position == PeopleNearbyActivity.this.chatsCreateRow) {
                manageChatTextCell.setText(LocaleController.getString("NearbyCreateGroup", R.string.NearbyCreateGroup), null, R.drawable.groups_create, PeopleNearbyActivity.this.chatsStartRow != -1);
                return;
            }
            if (position != PeopleNearbyActivity.this.showMeRow) {
                if (position == PeopleNearbyActivity.this.showMoreRow) {
                    manageChatTextCell.setText(LocaleController.formatPluralString("ShowVotes", PeopleNearbyActivity.this.users.size() - 5), null, R.drawable.arrow_more, false);
                }
            } else {
                PeopleNearbyActivity peopleNearbyActivity = PeopleNearbyActivity.this;
                if (peopleNearbyActivity.showingMe = peopleNearbyActivity.getUserConfig().sharingMyLocationUntil > PeopleNearbyActivity.this.getConnectionsManager().getCurrentTime()) {
                    manageChatTextCell.setText(LocaleController.getString("StopShowingMe", R.string.StopShowingMe), null, R.drawable.actions_nearby_off, PeopleNearbyActivity.this.usersStartRow != -1);
                    manageChatTextCell.setColors("windowBackgroundWhiteRedText5", "windowBackgroundWhiteRedText5");
                } else {
                    manageChatTextCell.setText(LocaleController.getString("MakeMyselfVisible", R.string.MakeMyselfVisible), null, R.drawable.actions_nearby_on, PeopleNearbyActivity.this.usersStartRow != -1);
                }
            }
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
            if (position == PeopleNearbyActivity.this.helpRow) {
                return 5;
            }
            if (position == PeopleNearbyActivity.this.chatsCreateRow || position == PeopleNearbyActivity.this.showMeRow || position == PeopleNearbyActivity.this.showMoreRow) {
                return 2;
            }
            if (position == PeopleNearbyActivity.this.usersHeaderRow || position == PeopleNearbyActivity.this.chatsHeaderRow) {
                return 3;
            }
            return (position == PeopleNearbyActivity.this.usersSectionRow || position == PeopleNearbyActivity.this.chatsSectionRow || position == PeopleNearbyActivity.this.helpSectionRow) ? 1 : 0;
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: ir.eitaa.ui.-$$Lambda$PeopleNearbyActivity$yiDs5wqBurcOSwbe3Fa1Q1SHW74
            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() {
                this.f$0.lambda$getThemeDescriptions$10$PeopleNearbyActivity();
            }

            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public /* synthetic */ void onAnimationProgress(float f) {
                ThemeDescription.ThemeDescriptionDelegate.CC.$default$onAnimationProgress(this, f);
            }
        };
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{ManageChatUserCell.class, ManageChatTextCell.class, HeaderCell.class, TextView.class, HintInnerCell.class}, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND | ThemeDescription.FLAG_CHECKTAG, null, null, null, null, "windowBackgroundGray"));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_CHECKTAG | ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.actionBarBackground, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, "divider"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ShadowSectionCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueHeader"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_PROGRESSBAR, new Class[]{HeaderCellProgress.class}, new String[]{"progressView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueHeader"));
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
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_USEBACKGROUNDDRAWABLE, new Class[]{HintInnerCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "chats_archiveBackground"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{HintInnerCell.class}, new String[]{"messageTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "chats_message"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{ManageChatTextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{ManageChatTextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayIcon"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{ManageChatTextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueButton"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{ManageChatTextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueIcon"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{ManageChatTextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteRedText5"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{ManageChatTextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteRedText5"));
        arrayList.add(new ThemeDescription(this.undoView, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "undo_background"));
        arrayList.add(new ThemeDescription(this.undoView, 0, new Class[]{UndoView.class}, new String[]{"undoImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "undo_cancelColor"));
        arrayList.add(new ThemeDescription(this.undoView, 0, new Class[]{UndoView.class}, new String[]{"undoTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "undo_cancelColor"));
        arrayList.add(new ThemeDescription(this.undoView, 0, new Class[]{UndoView.class}, new String[]{"infoTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "undo_infoColor"));
        arrayList.add(new ThemeDescription(this.undoView, 0, new Class[]{UndoView.class}, new String[]{"subinfoTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "undo_infoColor"));
        arrayList.add(new ThemeDescription(this.undoView, 0, new Class[]{UndoView.class}, new String[]{"textPaint"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "undo_infoColor"));
        arrayList.add(new ThemeDescription(this.undoView, 0, new Class[]{UndoView.class}, new String[]{"progressPaint"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "undo_infoColor"));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getThemeDescriptions$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getThemeDescriptions$10$PeopleNearbyActivity() {
        RecyclerListView recyclerListView = this.listView;
        if (recyclerListView != null) {
            int childCount = recyclerListView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.listView.getChildAt(i);
                if (childAt instanceof ManageChatUserCell) {
                    ((ManageChatUserCell) childAt).update(0);
                }
            }
        }
    }
}
