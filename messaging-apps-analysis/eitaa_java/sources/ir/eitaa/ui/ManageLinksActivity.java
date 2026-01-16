package ir.eitaa.ui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.ChatObject;
import ir.eitaa.messenger.DocumentObject;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MediaDataController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$ChatFull;
import ir.eitaa.tgnet.TLRPC$Document;
import ir.eitaa.tgnet.TLRPC$ExportedChatInvite;
import ir.eitaa.tgnet.TLRPC$TL_chatAdminWithInvites;
import ir.eitaa.tgnet.TLRPC$TL_chatInviteExported;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_messages_chatAdminsWithInvites;
import ir.eitaa.tgnet.TLRPC$TL_messages_deleteExportedChatInvite;
import ir.eitaa.tgnet.TLRPC$TL_messages_deleteRevokedExportedChatInvites;
import ir.eitaa.tgnet.TLRPC$TL_messages_editExportedChatInvite;
import ir.eitaa.tgnet.TLRPC$TL_messages_exportChatInvite;
import ir.eitaa.tgnet.TLRPC$TL_messages_exportedChatInvite;
import ir.eitaa.tgnet.TLRPC$TL_messages_exportedChatInviteReplaced;
import ir.eitaa.tgnet.TLRPC$TL_messages_getAdminsWithInvites;
import ir.eitaa.tgnet.TLRPC$TL_messages_getExportedChatInvites;
import ir.eitaa.tgnet.TLRPC$TL_messages_stickerSet;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.SimpleTextView;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Cells.HeaderCell;
import ir.eitaa.ui.Cells.ManageChatTextCell;
import ir.eitaa.ui.Cells.ManageChatUserCell;
import ir.eitaa.ui.Cells.ShadowSectionCell;
import ir.eitaa.ui.Cells.TextInfoPrivacyCell;
import ir.eitaa.ui.Cells.TextSettingsCell;
import ir.eitaa.ui.Components.BackupImageView;
import ir.eitaa.ui.Components.BulletinFactory;
import ir.eitaa.ui.Components.DotDividerSpan;
import ir.eitaa.ui.Components.FlickerLoadingView;
import ir.eitaa.ui.Components.InviteLinkBottomSheet;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.LinkActionView;
import ir.eitaa.ui.Components.RecyclerItemsEnterAnimator;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.Components.TimerParticles;
import ir.eitaa.ui.LinkEditActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

/* loaded from: classes3.dex */
public class ManageLinksActivity extends BaseFragment {
    private long adminId;
    private int adminsDividerRow;
    private int adminsEndRow;
    private int adminsHeaderRow;
    boolean adminsLoaded;
    private int adminsStartRow;
    private boolean canEdit;
    private int createLinkHelpRow;
    private int createNewLinkRow;
    private int creatorDividerRow;
    private int creatorRow;
    private TLRPC$Chat currentChat;
    private long currentChatId;
    boolean deletingRevokedLinks;
    private int dividerRow;
    boolean hasMore;
    private int helpRow;
    private TLRPC$ChatFull info;
    private TLRPC$TL_chatInviteExported invite;
    private InviteLinkBottomSheet inviteLinkBottomSheet;
    private int invitesCount;
    private boolean isChannel;
    private boolean isOpened;
    private boolean isPublic;
    private int lastDivider;
    Drawable linkIcon;
    Drawable linkIconRevoked;
    private int linksEndRow;
    private int linksHeaderRow;
    boolean linksLoading;
    private int linksLoadingRow;
    private int linksStartRow;
    private RecyclerListView listView;
    private ListAdapter listViewAdapter;
    boolean loadAdmins;
    private int permanentLinkHeaderRow;
    private int permanentLinkRow;
    private RecyclerItemsEnterAnimator recyclerItemsEnterAnimator;
    private int revokeAllDivider;
    private int revokeAllRow;
    private int revokedDivider;
    private int revokedHeader;
    private int revokedLinksEndRow;
    private int revokedLinksStartRow;
    private int rowCount;
    long timeDif;
    private ArrayList<TLRPC$TL_chatInviteExported> invites = new ArrayList<>();
    private ArrayList<TLRPC$TL_chatInviteExported> revokedInvites = new ArrayList<>();
    private HashMap<Long, TLRPC$User> users = new HashMap<>();
    private ArrayList<TLRPC$TL_chatAdminWithInvites> admins = new ArrayList<>();
    Runnable updateTimerRunnable = new Runnable() { // from class: ir.eitaa.ui.ManageLinksActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (ManageLinksActivity.this.listView == null) {
                return;
            }
            for (int i = 0; i < ManageLinksActivity.this.listView.getChildCount(); i++) {
                View childAt = ManageLinksActivity.this.listView.getChildAt(i);
                if (childAt instanceof LinkCell) {
                    LinkCell linkCell = (LinkCell) childAt;
                    if (linkCell.timerRunning) {
                        linkCell.setLink(linkCell.invite, linkCell.position);
                    }
                }
            }
            AndroidUtilities.runOnUIThread(this, 500L);
        }
    };
    boolean loadRevoked = false;
    private final LinkEditActivity.Callback linkEditActivityCallback = new AnonymousClass6();
    int animationIndex = -1;

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean needDelayOpenAnimation() {
        return true;
    }

    private static class EmptyView extends LinearLayout implements NotificationCenter.NotificationCenterDelegate {
        private final int currentAccount;
        private BackupImageView stickerView;

        public EmptyView(Context context) {
            super(context);
            this.currentAccount = UserConfig.selectedAccount;
            setPadding(0, AndroidUtilities.dp(12.0f), 0, AndroidUtilities.dp(12.0f));
            setOrientation(1);
            BackupImageView backupImageView = new BackupImageView(context);
            this.stickerView = backupImageView;
            addView(backupImageView, LayoutHelper.createLinear(R.styleable.AppCompatTheme_textColorAlertDialogListItem, R.styleable.AppCompatTheme_textColorAlertDialogListItem, 49, 0, 2, 0, 0));
        }

        private void setSticker() {
            TLRPC$TL_messages_stickerSet stickerSetByName = MediaDataController.getInstance(this.currentAccount).getStickerSetByName(AndroidUtilities.STICKERS_PLACEHOLDER_PACK_NAME);
            if (stickerSetByName == null) {
                stickerSetByName = MediaDataController.getInstance(this.currentAccount).getStickerSetByEmojiOrName(AndroidUtilities.STICKERS_PLACEHOLDER_PACK_NAME);
            }
            TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet = stickerSetByName;
            if (tLRPC$TL_messages_stickerSet != null && tLRPC$TL_messages_stickerSet.documents.size() >= 4) {
                TLRPC$Document tLRPC$Document = tLRPC$TL_messages_stickerSet.documents.get(3);
                this.stickerView.setImage(ImageLocation.getForDocument(tLRPC$Document), "104_104", "tgs", DocumentObject.getSvgThumb(tLRPC$Document, "windowBackgroundGray", 1.0f), tLRPC$TL_messages_stickerSet);
            } else {
                MediaDataController.getInstance(this.currentAccount).loadStickersByEmojiOrName(AndroidUtilities.STICKERS_PLACEHOLDER_PACK_NAME, false, tLRPC$TL_messages_stickerSet == null);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            setSticker();
            NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.diceStickersDidLoad);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.diceStickersDidLoad);
        }

        @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
        public void didReceivedNotification(int id, int account, Object... args) {
            if (id == NotificationCenter.diceStickersDidLoad && AndroidUtilities.STICKERS_PLACEHOLDER_PACK_NAME.equals((String) args[0])) {
                setSticker();
            }
        }
    }

    public ManageLinksActivity(long chatId, long adminId, int invitesCount) {
        boolean z = false;
        this.currentChatId = chatId;
        this.invitesCount = invitesCount;
        TLRPC$Chat chat = MessagesController.getInstance(this.currentAccount).getChat(Long.valueOf(chatId));
        this.currentChat = chat;
        this.isChannel = ChatObject.isChannel(chat) && !this.currentChat.megagroup;
        if (adminId == 0) {
            this.adminId = getAccountInstance().getUserConfig().clientUserId;
        } else {
            this.adminId = adminId;
        }
        TLRPC$User user = getMessagesController().getUser(Long.valueOf(this.adminId));
        if (this.adminId == getAccountInstance().getUserConfig().clientUserId || (user != null && !user.bot)) {
            z = true;
        }
        this.canEdit = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadLinks(boolean notify) {
        if (this.loadAdmins && !this.adminsLoaded) {
            this.linksLoading = true;
            TLRPC$TL_messages_getAdminsWithInvites tLRPC$TL_messages_getAdminsWithInvites = new TLRPC$TL_messages_getAdminsWithInvites();
            tLRPC$TL_messages_getAdminsWithInvites.peer = getMessagesController().getInputPeer(-this.currentChatId);
            getConnectionsManager().bindRequestToGuid(getConnectionsManager().sendRequest(tLRPC$TL_messages_getAdminsWithInvites, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ManageLinksActivity$MBdBTuiYttHc-ERQQqBS2ALHxOg
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$loadLinks$2$ManageLinksActivity(tLObject, tLRPC$TL_error);
                }
            }), getClassGuid());
        } else {
            TLRPC$TL_messages_getExportedChatInvites tLRPC$TL_messages_getExportedChatInvites = new TLRPC$TL_messages_getExportedChatInvites();
            tLRPC$TL_messages_getExportedChatInvites.peer = getMessagesController().getInputPeer(-this.currentChatId);
            if (this.adminId == getUserConfig().getClientUserId()) {
                tLRPC$TL_messages_getExportedChatInvites.admin_id = getMessagesController().getInputUser(getUserConfig().getCurrentUser());
            } else {
                tLRPC$TL_messages_getExportedChatInvites.admin_id = getMessagesController().getInputUser(this.adminId);
            }
            final boolean z = this.loadRevoked;
            if (z) {
                tLRPC$TL_messages_getExportedChatInvites.revoked = true;
                if (!this.revokedInvites.isEmpty()) {
                    tLRPC$TL_messages_getExportedChatInvites.flags |= 4;
                    ArrayList<TLRPC$TL_chatInviteExported> arrayList = this.revokedInvites;
                    tLRPC$TL_messages_getExportedChatInvites.offset_link = arrayList.get(arrayList.size() - 1).link;
                    ArrayList<TLRPC$TL_chatInviteExported> arrayList2 = this.revokedInvites;
                    tLRPC$TL_messages_getExportedChatInvites.offset_date = arrayList2.get(arrayList2.size() - 1).date;
                }
            } else if (!this.invites.isEmpty()) {
                tLRPC$TL_messages_getExportedChatInvites.flags |= 4;
                ArrayList<TLRPC$TL_chatInviteExported> arrayList3 = this.invites;
                tLRPC$TL_messages_getExportedChatInvites.offset_link = arrayList3.get(arrayList3.size() - 1).link;
                ArrayList<TLRPC$TL_chatInviteExported> arrayList4 = this.invites;
                tLRPC$TL_messages_getExportedChatInvites.offset_date = arrayList4.get(arrayList4.size() - 1).date;
            }
            this.linksLoading = true;
            final TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported = this.isPublic ? null : this.invite;
            getConnectionsManager().bindRequestToGuid(getConnectionsManager().sendRequest(tLRPC$TL_messages_getExportedChatInvites, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ManageLinksActivity$vCvKTcRoq7g1qWx4iQEL0iGE8tE
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$loadLinks$5$ManageLinksActivity(tLRPC$TL_chatInviteExported, z, tLObject, tLRPC$TL_error);
                }
            }), getClassGuid());
        }
        if (notify) {
            updateRows(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadLinks$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadLinks$1$ManageLinksActivity(final TLRPC$TL_error tLRPC$TL_error, final TLObject tLObject) {
        getNotificationCenter().doOnIdle(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ManageLinksActivity$jTGfOdFK1eMah_mMVwicsdNOCF4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadLinks$0$ManageLinksActivity(tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadLinks$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadLinks$2$ManageLinksActivity(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ManageLinksActivity$l3FmqOHB_nqo2LLLCcPrERF3cFo
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadLinks$1$ManageLinksActivity(tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadLinks$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadLinks$0$ManageLinksActivity(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
        RecyclerItemsEnterAnimator recyclerItemsEnterAnimator;
        this.linksLoading = false;
        if (tLRPC$TL_error == null) {
            TLRPC$TL_messages_chatAdminsWithInvites tLRPC$TL_messages_chatAdminsWithInvites = (TLRPC$TL_messages_chatAdminsWithInvites) tLObject;
            for (int i = 0; i < tLRPC$TL_messages_chatAdminsWithInvites.admins.size(); i++) {
                TLRPC$TL_chatAdminWithInvites tLRPC$TL_chatAdminWithInvites = tLRPC$TL_messages_chatAdminsWithInvites.admins.get(i);
                if (tLRPC$TL_chatAdminWithInvites.admin_id != getAccountInstance().getUserConfig().clientUserId) {
                    this.admins.add(tLRPC$TL_chatAdminWithInvites);
                }
            }
            for (int i2 = 0; i2 < tLRPC$TL_messages_chatAdminsWithInvites.users.size(); i2++) {
                TLRPC$User tLRPC$User = tLRPC$TL_messages_chatAdminsWithInvites.users.get(i2);
                this.users.put(Long.valueOf(tLRPC$User.id), tLRPC$User);
            }
        }
        int i3 = this.rowCount;
        this.adminsLoaded = true;
        this.hasMore = false;
        if (this.admins.size() > 0 && (recyclerItemsEnterAnimator = this.recyclerItemsEnterAnimator) != null && !this.isPaused && this.isOpened) {
            recyclerItemsEnterAnimator.showItemsAnimated(i3 + 1);
        }
        if (!this.hasMore || this.invites.size() + this.revokedInvites.size() + this.admins.size() >= 5) {
            resumeDelayedFragmentAnimation();
        }
        if (!this.hasMore && !this.loadRevoked) {
            this.hasMore = true;
            this.loadRevoked = true;
            loadLinks(false);
        }
        updateRows(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    /* renamed from: lambda$loadLinks$5, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$loadLinks$5$ManageLinksActivity(ir.eitaa.tgnet.TLRPC$TL_chatInviteExported r7, final boolean r8, final ir.eitaa.tgnet.TLObject r9, final ir.eitaa.tgnet.TLRPC$TL_error r10) {
        /*
            r6 = this;
            if (r10 != 0) goto L36
            r0 = r9
            ir.eitaa.tgnet.TLRPC$TL_messages_exportedChatInvites r0 = (ir.eitaa.tgnet.TLRPC$TL_messages_exportedChatInvites) r0
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$ExportedChatInvite> r1 = r0.invites
            int r1 = r1.size()
            if (r1 <= 0) goto L36
            if (r7 == 0) goto L36
            r1 = 0
        L10:
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$ExportedChatInvite> r2 = r0.invites
            int r2 = r2.size()
            if (r1 >= r2) goto L36
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$ExportedChatInvite> r2 = r0.invites
            java.lang.Object r2 = r2.get(r1)
            ir.eitaa.tgnet.TLRPC$TL_chatInviteExported r2 = (ir.eitaa.tgnet.TLRPC$TL_chatInviteExported) r2
            java.lang.String r2 = r2.link
            java.lang.String r3 = r7.link
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L33
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$ExportedChatInvite> r7 = r0.invites
            java.lang.Object r7 = r7.remove(r1)
            ir.eitaa.tgnet.TLRPC$TL_chatInviteExported r7 = (ir.eitaa.tgnet.TLRPC$TL_chatInviteExported) r7
            goto L37
        L33:
            int r1 = r1 + 1
            goto L10
        L36:
            r7 = 0
        L37:
            r2 = r7
            ir.eitaa.ui.-$$Lambda$ManageLinksActivity$H-cMecXEkguCCKhFWGfofO6aF-U r7 = new ir.eitaa.ui.-$$Lambda$ManageLinksActivity$H-cMecXEkguCCKhFWGfofO6aF-U
            r0 = r7
            r1 = r6
            r3 = r10
            r4 = r9
            r5 = r8
            r0.<init>()
            ir.eitaa.messenger.AndroidUtilities.runOnUIThread(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ManageLinksActivity.lambda$loadLinks$5$ManageLinksActivity(ir.eitaa.tgnet.TLRPC$TL_chatInviteExported, boolean, ir.eitaa.tgnet.TLObject, ir.eitaa.tgnet.TLRPC$TL_error):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadLinks$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadLinks$4$ManageLinksActivity(final TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported, final TLRPC$TL_error tLRPC$TL_error, final TLObject tLObject, final boolean z) {
        getNotificationCenter().doOnIdle(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ManageLinksActivity$CWjvtGbD05ruLLFG7oquGhDIU_Q
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadLinks$3$ManageLinksActivity(tLRPC$TL_chatInviteExported, tLRPC$TL_error, tLObject, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x015a  */
    /* renamed from: lambda$loadLinks$3, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$loadLinks$3$ManageLinksActivity(ir.eitaa.tgnet.TLRPC$TL_chatInviteExported r7, ir.eitaa.tgnet.TLRPC$TL_error r8, ir.eitaa.tgnet.TLObject r9, boolean r10) {
        /*
            Method dump skipped, instructions count: 371
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ManageLinksActivity.lambda$loadLinks$3$ManageLinksActivity(ir.eitaa.tgnet.TLRPC$TL_chatInviteExported, ir.eitaa.tgnet.TLRPC$TL_error, ir.eitaa.tgnet.TLObject, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRows(boolean notify) {
        TLRPC$Chat chat = MessagesController.getInstance(this.currentAccount).getChat(Long.valueOf(this.currentChatId));
        this.currentChat = chat;
        if (chat == null) {
            return;
        }
        this.creatorRow = -1;
        this.creatorDividerRow = -1;
        this.linksStartRow = -1;
        this.linksEndRow = -1;
        this.linksLoadingRow = -1;
        this.revokedLinksStartRow = -1;
        this.revokedLinksEndRow = -1;
        this.revokedHeader = -1;
        this.revokedDivider = -1;
        this.lastDivider = -1;
        this.revokeAllRow = -1;
        this.revokeAllDivider = -1;
        this.createLinkHelpRow = -1;
        this.helpRow = -1;
        this.createNewLinkRow = -1;
        this.adminsEndRow = -1;
        this.adminsStartRow = -1;
        this.adminsDividerRow = -1;
        this.adminsHeaderRow = -1;
        this.linksHeaderRow = -1;
        this.dividerRow = -1;
        this.rowCount = 0;
        boolean z = this.adminId != getAccountInstance().getUserConfig().clientUserId;
        if (z) {
            int i = this.rowCount;
            int i2 = i + 1;
            this.rowCount = i2;
            this.creatorRow = i;
            this.rowCount = i2 + 1;
            this.creatorDividerRow = i2;
        } else {
            int i3 = this.rowCount;
            this.rowCount = i3 + 1;
            this.helpRow = i3;
        }
        int i4 = this.rowCount;
        int i5 = i4 + 1;
        this.rowCount = i5;
        this.permanentLinkHeaderRow = i4;
        int i6 = i5 + 1;
        this.rowCount = i6;
        this.permanentLinkRow = i5;
        if (!z) {
            int i7 = i6 + 1;
            this.rowCount = i7;
            this.dividerRow = i6;
            this.rowCount = i7 + 1;
            this.createNewLinkRow = i7;
        } else if (!this.invites.isEmpty()) {
            int i8 = this.rowCount;
            int i9 = i8 + 1;
            this.rowCount = i9;
            this.dividerRow = i8;
            this.rowCount = i9 + 1;
            this.linksHeaderRow = i9;
        }
        if (!this.invites.isEmpty()) {
            int i10 = this.rowCount;
            this.linksStartRow = i10;
            int size = i10 + this.invites.size();
            this.rowCount = size;
            this.linksEndRow = size;
        }
        if (!z && this.invites.isEmpty() && this.createNewLinkRow >= 0 && (!this.linksLoading || this.loadAdmins || this.loadRevoked)) {
            int i11 = this.rowCount;
            this.rowCount = i11 + 1;
            this.createLinkHelpRow = i11;
        }
        if (!z && this.admins.size() > 0) {
            if ((!this.invites.isEmpty() || this.createNewLinkRow >= 0) && this.createLinkHelpRow == -1) {
                int i12 = this.rowCount;
                this.rowCount = i12 + 1;
                this.adminsDividerRow = i12;
            }
            int i13 = this.rowCount;
            int i14 = i13 + 1;
            this.rowCount = i14;
            this.adminsHeaderRow = i13;
            this.adminsStartRow = i14;
            int size2 = i14 + this.admins.size();
            this.rowCount = size2;
            this.adminsEndRow = size2;
        }
        if (!this.revokedInvites.isEmpty()) {
            if (this.adminsStartRow >= 0) {
                int i15 = this.rowCount;
                this.rowCount = i15 + 1;
                this.revokedDivider = i15;
            } else if ((!this.invites.isEmpty() || this.createNewLinkRow >= 0) && this.createLinkHelpRow == -1) {
                int i16 = this.rowCount;
                this.rowCount = i16 + 1;
                this.revokedDivider = i16;
            } else if (z && this.linksStartRow == -1) {
                int i17 = this.rowCount;
                this.rowCount = i17 + 1;
                this.revokedDivider = i17;
            }
            int i18 = this.rowCount;
            int i19 = i18 + 1;
            this.rowCount = i19;
            this.revokedHeader = i18;
            this.revokedLinksStartRow = i19;
            int size3 = i19 + this.revokedInvites.size();
            this.rowCount = size3;
            this.revokedLinksEndRow = size3;
            int i20 = size3 + 1;
            this.rowCount = i20;
            this.revokeAllDivider = size3;
            this.rowCount = i20 + 1;
            this.revokeAllRow = i20;
        }
        if (!this.loadAdmins && !this.loadRevoked && ((this.linksLoading || this.hasMore) && !z)) {
            int i21 = this.rowCount;
            this.rowCount = i21 + 1;
            this.linksLoadingRow = i21;
        }
        if (!this.invites.isEmpty() || !this.revokedInvites.isEmpty()) {
            int i22 = this.rowCount;
            this.rowCount = i22 + 1;
            this.lastDivider = i22;
        }
        ListAdapter listAdapter = this.listViewAdapter;
        if (listAdapter == null || !notify) {
            return;
        }
        listAdapter.notifyDataSetChanged();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(final Context context) {
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setAllowOverlayTitle(true);
        this.actionBar.setTitle(LocaleController.getString("InviteLinks", R.string.InviteLinks));
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.eitaa.ui.ManageLinksActivity.2
            @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int id) {
                if (id == -1) {
                    ManageLinksActivity.this.finishFragment();
                }
            }
        });
        FrameLayout frameLayout = new FrameLayout(context) { // from class: ir.eitaa.ui.ManageLinksActivity.3
            @Override // android.view.ViewGroup, android.view.View
            protected void onAttachedToWindow() {
                super.onAttachedToWindow();
                AndroidUtilities.runOnUIThread(ManageLinksActivity.this.updateTimerRunnable, 500L);
            }

            @Override // android.view.ViewGroup, android.view.View
            protected void onDetachedFromWindow() {
                super.onDetachedFromWindow();
                AndroidUtilities.cancelRunOnUIThread(ManageLinksActivity.this.updateTimerRunnable);
            }
        };
        this.fragmentView = frameLayout;
        frameLayout.setBackgroundColor(Theme.getColor("windowBackgroundGray"));
        this.fragmentView.setTag("windowBackgroundGray");
        FrameLayout frameLayout2 = (FrameLayout) this.fragmentView;
        this.listView = new RecyclerListView(context) { // from class: ir.eitaa.ui.ManageLinksActivity.4
            @Override // ir.eitaa.ui.Components.RecyclerListView, android.view.ViewGroup, android.view.View
            protected void dispatchDraw(Canvas canvas) {
                ManageLinksActivity.this.recyclerItemsEnterAnimator.dispatchDraw();
                super.dispatchDraw(canvas);
            }

            @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
            protected void onDetachedFromWindow() {
                super.onDetachedFromWindow();
                ManageLinksActivity.this.recyclerItemsEnterAnimator.onDetached();
            }
        };
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, 1, false);
        this.listView.setLayoutManager(linearLayoutManager);
        RecyclerListView recyclerListView = this.listView;
        ListAdapter listAdapter = new ListAdapter(context);
        this.listViewAdapter = listAdapter;
        recyclerListView.setAdapter(listAdapter);
        this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.eitaa.ui.ManageLinksActivity.5
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                ManageLinksActivity manageLinksActivity = ManageLinksActivity.this;
                if (!manageLinksActivity.hasMore || manageLinksActivity.linksLoading) {
                    return;
                }
                if (ManageLinksActivity.this.rowCount - linearLayoutManager.findLastVisibleItemPosition() < 10) {
                    ManageLinksActivity.this.loadLinks(true);
                }
            }
        });
        this.recyclerItemsEnterAnimator = new RecyclerItemsEnterAnimator(this.listView, false);
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setDelayAnimations(false);
        defaultItemAnimator.setSupportsChangeAnimations(false);
        this.listView.setItemAnimator(defaultItemAnimator);
        this.listView.setVerticalScrollbarPosition(LocaleController.isRTL ? 1 : 2);
        frameLayout2.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f));
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ManageLinksActivity$9mzSxfuuQx-spRRPsWa6BpgmsPg
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i) {
                this.f$0.lambda$createView$9$ManageLinksActivity(context, view, i);
            }
        });
        this.listView.setOnItemLongClickListener(new RecyclerListView.OnItemLongClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ManageLinksActivity$gvz2ZE94rPuEltYBPy8Rm5Yd5Eo
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemLongClickListener
            public final boolean onItemClick(View view, int i) {
                return this.f$0.lambda$createView$10$ManageLinksActivity(view, i);
            }
        });
        this.linkIcon = ContextCompat.getDrawable(context, R.drawable.msg_link_1);
        this.linkIconRevoked = ContextCompat.getDrawable(context, R.drawable.msg_link_2);
        this.linkIcon.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.MULTIPLY));
        updateRows(true);
        this.timeDif = getConnectionsManager().getCurrentTime() - (System.currentTimeMillis() / 1000);
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$9$ManageLinksActivity(Context context, View view, int i) {
        if (i == this.creatorRow) {
            TLRPC$User tLRPC$User = this.users.get(Long.valueOf(this.invite.admin_id));
            if (tLRPC$User != null) {
                Bundle bundle = new Bundle();
                bundle.putLong("user_id", tLRPC$User.id);
                MessagesController.getInstance(UserConfig.selectedAccount).putUser(tLRPC$User, false);
                presentFragment(new ProfileActivity(bundle));
                return;
            }
            return;
        }
        if (i == this.createNewLinkRow) {
            LinkEditActivity linkEditActivity = new LinkEditActivity(0, this.currentChatId);
            linkEditActivity.setCallback(this.linkEditActivityCallback);
            presentFragment(linkEditActivity);
            return;
        }
        int i2 = this.linksStartRow;
        if (i >= i2 && i < this.linksEndRow) {
            InviteLinkBottomSheet inviteLinkBottomSheet = new InviteLinkBottomSheet(context, this.invites.get(i - i2), this.info, this.users, this, this.currentChatId, false, this.isChannel);
            this.inviteLinkBottomSheet = inviteLinkBottomSheet;
            inviteLinkBottomSheet.setCanEdit(this.canEdit);
            this.inviteLinkBottomSheet.show();
            return;
        }
        int i3 = this.revokedLinksStartRow;
        if (i >= i3 && i < this.revokedLinksEndRow) {
            InviteLinkBottomSheet inviteLinkBottomSheet2 = new InviteLinkBottomSheet(context, this.revokedInvites.get(i - i3), this.info, this.users, this, this.currentChatId, false, this.isChannel);
            this.inviteLinkBottomSheet = inviteLinkBottomSheet2;
            inviteLinkBottomSheet2.show();
            return;
        }
        if (i == this.revokeAllRow) {
            if (this.deletingRevokedLinks) {
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
            builder.setTitle(LocaleController.getString("DeleteAllRevokedLinks", R.string.DeleteAllRevokedLinks));
            builder.setMessage(LocaleController.getString("DeleteAllRevokedLinkHelp", R.string.DeleteAllRevokedLinkHelp));
            builder.setPositiveButton(LocaleController.getString("Delete", R.string.Delete), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ManageLinksActivity$baNqcwT8CLKspKQX3b1At7fx2j0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    this.f$0.lambda$createView$8$ManageLinksActivity(dialogInterface, i4);
                }
            });
            builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            showDialog(builder.create());
            return;
        }
        int i4 = this.adminsStartRow;
        if (i < i4 || i >= this.adminsEndRow) {
            return;
        }
        TLRPC$TL_chatAdminWithInvites tLRPC$TL_chatAdminWithInvites = this.admins.get(i - i4);
        if (this.users.containsKey(Long.valueOf(tLRPC$TL_chatAdminWithInvites.admin_id))) {
            getMessagesController().putUser(this.users.get(Long.valueOf(tLRPC$TL_chatAdminWithInvites.admin_id)), false);
        }
        ManageLinksActivity manageLinksActivity = new ManageLinksActivity(this.currentChatId, tLRPC$TL_chatAdminWithInvites.admin_id, tLRPC$TL_chatAdminWithInvites.invites_count);
        manageLinksActivity.setInfo(this.info, null);
        presentFragment(manageLinksActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$8$ManageLinksActivity(DialogInterface dialogInterface, int i) {
        TLRPC$TL_messages_deleteRevokedExportedChatInvites tLRPC$TL_messages_deleteRevokedExportedChatInvites = new TLRPC$TL_messages_deleteRevokedExportedChatInvites();
        tLRPC$TL_messages_deleteRevokedExportedChatInvites.peer = getMessagesController().getInputPeer(-this.currentChatId);
        if (this.adminId == getUserConfig().getClientUserId()) {
            tLRPC$TL_messages_deleteRevokedExportedChatInvites.admin_id = getMessagesController().getInputUser(getUserConfig().getCurrentUser());
        } else {
            tLRPC$TL_messages_deleteRevokedExportedChatInvites.admin_id = getMessagesController().getInputUser(this.adminId);
        }
        this.deletingRevokedLinks = true;
        getConnectionsManager().sendRequest(tLRPC$TL_messages_deleteRevokedExportedChatInvites, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ManageLinksActivity$GwUV-ymSSFMflU2KftdVF9E_ag8
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$createView$7$ManageLinksActivity(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$7$ManageLinksActivity(TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ManageLinksActivity$yPU1vYXcmcN2JQLQWz2sjeil5EA
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createView$6$ManageLinksActivity(tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$6$ManageLinksActivity(TLRPC$TL_error tLRPC$TL_error) {
        this.deletingRevokedLinks = false;
        if (tLRPC$TL_error == null) {
            DiffCallback diffCallbackSaveListState = saveListState();
            this.revokedInvites.clear();
            updateRecyclerViewAnimated(diffCallbackSaveListState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$createView$10$ManageLinksActivity(View view, int i) {
        if ((i < this.linksStartRow || i >= this.linksEndRow) && (i < this.revokedLinksStartRow || i >= this.revokedLinksEndRow)) {
            return false;
        }
        ((LinkCell) view).optionsView.callOnClick();
        view.performHapticFeedback(0, 2);
        return true;
    }

    public void setInfo(TLRPC$ChatFull chatFull, TLRPC$ExportedChatInvite invite) {
        this.info = chatFull;
        this.invite = (TLRPC$TL_chatInviteExported) invite;
        this.isPublic = !TextUtils.isEmpty(this.currentChat.username);
        loadLinks(true);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        ListAdapter listAdapter = this.listViewAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    public class HintInnerCell extends FrameLayout {
        private EmptyView emptyView;
        private TextView messageTextView;

        public HintInnerCell(Context context) {
            int i;
            String str;
            super(context);
            EmptyView emptyView = new EmptyView(context);
            this.emptyView = emptyView;
            addView(emptyView, LayoutHelper.createFrame(-2, -2.0f, 49, 0.0f, 10.0f, 0.0f, 0.0f));
            TextView textView = new TextView(context);
            this.messageTextView = textView;
            textView.setTextColor(Theme.getColor("chats_message"));
            this.messageTextView.setTextSize(1, 14.0f);
            this.messageTextView.setGravity(17);
            TextView textView2 = this.messageTextView;
            if (ManageLinksActivity.this.isChannel) {
                i = R.string.PrimaryLinkHelpChannel;
                str = "PrimaryLinkHelpChannel";
            } else {
                i = R.string.PrimaryLinkHelp;
                str = "PrimaryLinkHelp";
            }
            textView2.setText(LocaleController.getString(str, i));
            addView(this.messageTextView, LayoutHelper.createFrame(-1, -2.0f, 51, 52.0f, 143.0f, 52.0f, 18.0f));
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), heightMeasureSpec);
        }
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            int adapterPosition = holder.getAdapterPosition();
            if (ManageLinksActivity.this.creatorRow == adapterPosition || ManageLinksActivity.this.createNewLinkRow == adapterPosition) {
                return true;
            }
            if (adapterPosition >= ManageLinksActivity.this.linksStartRow && adapterPosition < ManageLinksActivity.this.linksEndRow) {
                return true;
            }
            if ((adapterPosition < ManageLinksActivity.this.revokedLinksStartRow || adapterPosition >= ManageLinksActivity.this.revokedLinksEndRow) && adapterPosition != ManageLinksActivity.this.revokeAllRow) {
                return adapterPosition >= ManageLinksActivity.this.adminsStartRow && adapterPosition < ManageLinksActivity.this.adminsEndRow;
            }
            return true;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return ManageLinksActivity.this.rowCount;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view;
            View shadowSectionCell;
            switch (i) {
                case 1:
                    View headerCell = new HeaderCell(this.mContext, 23);
                    headerCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                    shadowSectionCell = headerCell;
                    break;
                case 2:
                    Context context = this.mContext;
                    ManageLinksActivity manageLinksActivity = ManageLinksActivity.this;
                    final LinkActionView linkActionView = new LinkActionView(context, manageLinksActivity, null, manageLinksActivity.currentChatId, true, ManageLinksActivity.this.isChannel);
                    linkActionView.setPermanent(true);
                    linkActionView.setDelegate(new LinkActionView.Delegate() { // from class: ir.eitaa.ui.ManageLinksActivity.ListAdapter.1
                        @Override // ir.eitaa.ui.Components.LinkActionView.Delegate
                        public /* synthetic */ void editLink() {
                            LinkActionView.Delegate.CC.$default$editLink(this);
                        }

                        @Override // ir.eitaa.ui.Components.LinkActionView.Delegate
                        public /* synthetic */ void removeLink() {
                            LinkActionView.Delegate.CC.$default$removeLink(this);
                        }

                        @Override // ir.eitaa.ui.Components.LinkActionView.Delegate
                        public void revokeLink() {
                            ManageLinksActivity.this.revokePermanent();
                        }

                        @Override // ir.eitaa.ui.Components.LinkActionView.Delegate
                        public void showUsersForPermanentLink() {
                            ManageLinksActivity manageLinksActivity2 = ManageLinksActivity.this;
                            Context context2 = linkActionView.getContext();
                            TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported = ManageLinksActivity.this.invite;
                            TLRPC$ChatFull tLRPC$ChatFull = ManageLinksActivity.this.info;
                            HashMap map = ManageLinksActivity.this.users;
                            ManageLinksActivity manageLinksActivity3 = ManageLinksActivity.this;
                            manageLinksActivity2.inviteLinkBottomSheet = new InviteLinkBottomSheet(context2, tLRPC$TL_chatInviteExported, tLRPC$ChatFull, map, manageLinksActivity3, manageLinksActivity3.currentChatId, true, ManageLinksActivity.this.isChannel);
                            ManageLinksActivity.this.inviteLinkBottomSheet.show();
                        }
                    });
                    linkActionView.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                    shadowSectionCell = linkActionView;
                    break;
                case 3:
                    View textCell = new TextCell(this.mContext);
                    textCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                    shadowSectionCell = textCell;
                    break;
                case 4:
                    shadowSectionCell = new ShadowSectionCell(this.mContext);
                    break;
                case 5:
                    shadowSectionCell = ManageLinksActivity.this.new LinkCell(this.mContext);
                    break;
                case 6:
                    FlickerLoadingView flickerLoadingView = new FlickerLoadingView(this.mContext);
                    flickerLoadingView.setIsSingleCell(true);
                    flickerLoadingView.setViewType(9);
                    flickerLoadingView.showDate(false);
                    flickerLoadingView.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                    shadowSectionCell = flickerLoadingView;
                    break;
                case 7:
                    View shadowSectionCell2 = new ShadowSectionCell(this.mContext);
                    shadowSectionCell2.setBackground(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
                    view = shadowSectionCell2;
                    shadowSectionCell = view;
                    break;
                case 8:
                    TextSettingsCell textSettingsCell = new TextSettingsCell(this.mContext);
                    textSettingsCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                    textSettingsCell.setText(LocaleController.getString("DeleteAllRevokedLinks", R.string.DeleteAllRevokedLinks), false);
                    textSettingsCell.setTextColor(Theme.getColor("windowBackgroundWhiteRedText5"));
                    shadowSectionCell = textSettingsCell;
                    break;
                case 9:
                    TextInfoPrivacyCell textInfoPrivacyCell = new TextInfoPrivacyCell(this.mContext);
                    textInfoPrivacyCell.setText(LocaleController.getString("CreateNewLinkHelp", R.string.CreateNewLinkHelp));
                    textInfoPrivacyCell.setBackground(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
                    view = textInfoPrivacyCell;
                    shadowSectionCell = view;
                    break;
                case 10:
                    FrameLayout manageChatUserCell = new ManageChatUserCell(this.mContext, 8, 6, false);
                    manageChatUserCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                    shadowSectionCell = manageChatUserCell;
                    break;
                default:
                    View hintInnerCell = ManageLinksActivity.this.new HintInnerCell(this.mContext);
                    hintInnerCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, "windowBackgroundWhite"));
                    shadowSectionCell = hintInnerCell;
                    break;
            }
            shadowSectionCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            return new RecyclerListView.Holder(shadowSectionCell);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0075  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00d3 A[PHI: r0
          0x00d3: PHI (r0v36 ir.eitaa.tgnet.TLRPC$TL_chatInviteExported) = (r0v35 ir.eitaa.tgnet.TLRPC$TL_chatInviteExported), (r0v43 ir.eitaa.tgnet.TLRPC$TL_chatInviteExported) binds: [B:31:0x00d1, B:28:0x00b3] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder r9, int r10) throws android.content.res.Resources.NotFoundException {
            /*
                Method dump skipped, instructions count: 645
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ManageLinksActivity.ListAdapter.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
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
            if (position == ManageLinksActivity.this.helpRow) {
                return 0;
            }
            if (position == ManageLinksActivity.this.permanentLinkHeaderRow || position == ManageLinksActivity.this.revokedHeader || position == ManageLinksActivity.this.adminsHeaderRow || position == ManageLinksActivity.this.linksHeaderRow) {
                return 1;
            }
            if (position == ManageLinksActivity.this.permanentLinkRow) {
                return 2;
            }
            if (position == ManageLinksActivity.this.createNewLinkRow) {
                return 3;
            }
            if (position == ManageLinksActivity.this.dividerRow || position == ManageLinksActivity.this.revokedDivider || position == ManageLinksActivity.this.revokeAllDivider || position == ManageLinksActivity.this.creatorDividerRow || position == ManageLinksActivity.this.adminsDividerRow) {
                return 4;
            }
            if (position >= ManageLinksActivity.this.linksStartRow && position < ManageLinksActivity.this.linksEndRow) {
                return 5;
            }
            if (position >= ManageLinksActivity.this.revokedLinksStartRow && position < ManageLinksActivity.this.revokedLinksEndRow) {
                return 5;
            }
            if (position == ManageLinksActivity.this.linksLoadingRow) {
                return 6;
            }
            if (position == ManageLinksActivity.this.lastDivider) {
                return 7;
            }
            if (position == ManageLinksActivity.this.revokeAllRow) {
                return 8;
            }
            if (position == ManageLinksActivity.this.createLinkHelpRow) {
                return 9;
            }
            if (position != ManageLinksActivity.this.creatorRow) {
                return (position < ManageLinksActivity.this.adminsStartRow || position >= ManageLinksActivity.this.adminsEndRow) ? 1 : 10;
            }
            return 10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void revokePermanent() {
        if (this.adminId == getAccountInstance().getUserConfig().clientUserId) {
            TLRPC$TL_messages_exportChatInvite tLRPC$TL_messages_exportChatInvite = new TLRPC$TL_messages_exportChatInvite();
            tLRPC$TL_messages_exportChatInvite.peer = getMessagesController().getInputPeer(-this.currentChatId);
            tLRPC$TL_messages_exportChatInvite.legacy_revoke_permanent = true;
            final TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported = this.invite;
            this.invite = null;
            this.info.exported_invite = null;
            int iSendRequest = getConnectionsManager().sendRequest(tLRPC$TL_messages_exportChatInvite, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ManageLinksActivity$zhNVyOj825AiG-x2uF3dc44P9_c
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$revokePermanent$12$ManageLinksActivity(tLRPC$TL_chatInviteExported, tLObject, tLRPC$TL_error);
                }
            });
            AndroidUtilities.updateVisibleRows(this.listView);
            getConnectionsManager().bindRequestToGuid(iSendRequest, this.classGuid);
            return;
        }
        revokeLink(this.invite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$revokePermanent$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$revokePermanent$12$ManageLinksActivity(final TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ManageLinksActivity$3zQzBC0VKL1atXfgqwgr0vD3iFw
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$revokePermanent$11$ManageLinksActivity(tLRPC$TL_error, tLObject, tLRPC$TL_chatInviteExported);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$revokePermanent$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$revokePermanent$11$ManageLinksActivity(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported) {
        if (tLRPC$TL_error == null) {
            TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported2 = (TLRPC$TL_chatInviteExported) tLObject;
            this.invite = tLRPC$TL_chatInviteExported2;
            TLRPC$ChatFull tLRPC$ChatFull = this.info;
            if (tLRPC$ChatFull != null) {
                tLRPC$ChatFull.exported_invite = tLRPC$TL_chatInviteExported2;
            }
            if (getParentActivity() == null) {
                return;
            }
            tLRPC$TL_chatInviteExported.revoked = true;
            DiffCallback diffCallbackSaveListState = saveListState();
            this.revokedInvites.add(0, tLRPC$TL_chatInviteExported);
            updateRecyclerViewAnimated(diffCallbackSaveListState);
            BulletinFactory.of(this).createSimpleBulletin(R.raw.linkbroken, LocaleController.getString("InviteRevokedHint", R.string.InviteRevokedHint)).show();
        }
    }

    public static class TextCell extends FrameLayout {
        boolean divider;
        private ImageView imageView;
        private SimpleTextView textView;

        public TextCell(Context context) {
            super(context);
            SimpleTextView simpleTextView = new SimpleTextView(context);
            this.textView = simpleTextView;
            simpleTextView.setTextSize(16);
            this.textView.setGravity(LocaleController.isRTL ? 5 : 3);
            this.textView.setTextColor(-25564);
            this.textView.setTag("windowBackgroundWhiteBlueText2");
            addView(this.textView);
            ImageView imageView = new ImageView(context);
            this.imageView = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            addView(this.imageView);
            setWillNotDraw(false);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            int size = View.MeasureSpec.getSize(widthMeasureSpec);
            AndroidUtilities.dp(48.0f);
            this.textView.measure(View.MeasureSpec.makeMeasureSpec(size - AndroidUtilities.dp(94.0f), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(20.0f), 1073741824));
            this.imageView.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(50.0f), 1073741824));
            setMeasuredDimension(size, AndroidUtilities.dp(50.0f));
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
            int iDp;
            int i = right - left;
            int textHeight = ((bottom - top) - this.textView.getTextHeight()) / 2;
            if (LocaleController.isRTL) {
                iDp = (getMeasuredWidth() - this.textView.getMeasuredWidth()) - AndroidUtilities.dp(this.imageView.getVisibility() == 0 ? 70.0f : 25.0f);
            } else {
                iDp = AndroidUtilities.dp(this.imageView.getVisibility() == 0 ? 70.0f : 25.0f);
            }
            SimpleTextView simpleTextView = this.textView;
            simpleTextView.layout(iDp, textHeight, simpleTextView.getMeasuredWidth() + iDp, this.textView.getMeasuredHeight() + textHeight);
            int iDp2 = !LocaleController.isRTL ? (AndroidUtilities.dp(70.0f) - this.imageView.getMeasuredWidth()) / 2 : (i - this.imageView.getMeasuredWidth()) - AndroidUtilities.dp(25.0f);
            ImageView imageView = this.imageView;
            imageView.layout(iDp2, 0, imageView.getMeasuredWidth() + iDp2, this.imageView.getMeasuredHeight());
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (this.divider) {
                canvas.drawLine(AndroidUtilities.dp(70.0f), getMeasuredHeight() - 1, getMeasuredWidth() + AndroidUtilities.dp(23.0f), getMeasuredHeight(), Theme.dividerPaint);
            }
        }

        public void setTextAndIcon(String text, Drawable icon, boolean divider) {
            this.textView.setText(text);
            this.imageView.setImageDrawable(icon);
            this.divider = divider;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class LinkCell extends FrameLayout {
        int animateFromState;
        boolean animateHideExpiring;
        float animateToStateProgress;
        boolean drawDivider;
        TLRPC$TL_chatInviteExported invite;
        float lastDrawExpringProgress;
        int lastDrawingState;
        ImageView optionsView;
        Paint paint;
        Paint paint2;
        int position;
        RectF rectF;
        TextView subtitleView;
        private TimerParticles timerParticles;
        boolean timerRunning;
        TextView titleView;

        private boolean hasProgress(int state) {
            return state == 2 || state == 1;
        }

        public LinkCell(Context context) {
            super(context);
            this.paint = new Paint(1);
            this.paint2 = new Paint(1);
            this.rectF = new RectF();
            this.animateToStateProgress = 1.0f;
            this.timerParticles = new TimerParticles();
            this.paint2.setStyle(Paint.Style.STROKE);
            this.paint2.setStrokeCap(Paint.Cap.ROUND);
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            addView(linearLayout, LayoutHelper.createFrame(-1, -2.0f, 16, 70.0f, 0.0f, 30.0f, 0.0f));
            TextView textView = new TextView(context);
            this.titleView = textView;
            textView.setTextSize(1, 16.0f);
            this.titleView.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            this.titleView.setLines(1);
            this.titleView.setEllipsize(TextUtils.TruncateAt.END);
            TextView textView2 = new TextView(context);
            this.subtitleView = textView2;
            textView2.setTextSize(1, 13.0f);
            this.subtitleView.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText"));
            linearLayout.addView(this.titleView, LayoutHelper.createLinear(-1, -2));
            linearLayout.addView(this.subtitleView, LayoutHelper.createLinear(-1, -2, 0.0f, 6.0f, 0.0f, 0.0f));
            ImageView imageView = new ImageView(context);
            this.optionsView = imageView;
            imageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_ab_other));
            this.optionsView.setScaleType(ImageView.ScaleType.CENTER);
            this.optionsView.setColorFilter(Theme.getColor("stickers_menu"));
            this.optionsView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ManageLinksActivity$LinkCell$7eS-SjGNla5YbxYY4fcb2Paocms
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$3$ManageLinksActivity$LinkCell(view);
                }
            });
            this.optionsView.setBackground(Theme.createSelectorDrawable(Theme.getColor("listSelectorSDK21"), 1));
            addView(this.optionsView, LayoutHelper.createFrame(40, 48, 21));
            setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
            setWillNotDraw(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:20:0x00fd  */
        /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
        /* renamed from: lambda$new$3, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public /* synthetic */ void lambda$new$3$ManageLinksActivity$LinkCell(android.view.View r8) {
            /*
                r7 = this;
                ir.eitaa.tgnet.TLRPC$TL_chatInviteExported r8 = r7.invite
                if (r8 != 0) goto L5
                return
            L5:
                java.util.ArrayList r8 = new java.util.ArrayList
                r8.<init>()
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>()
                ir.eitaa.tgnet.TLRPC$TL_chatInviteExported r2 = r7.invite
                boolean r2 = r2.revoked
                r3 = 2131231392(0x7f0802a0, float:1.8078864E38)
                r4 = 0
                r5 = 1
                if (r2 == 0) goto L3d
                r2 = 2131690980(0x7f0f05e4, float:1.9011019E38)
                java.lang.String r6 = "Delete"
                java.lang.String r2 = ir.eitaa.messenger.LocaleController.getString(r6, r2)
                r8.add(r2)
                java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
                r0.add(r2)
                r2 = 4
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                r1.add(r2)
            L3a:
                r2 = 1
                goto Lc9
            L3d:
                r2 = 2131690864(0x7f0f0570, float:1.9010784E38)
                java.lang.String r6 = "CopyLink"
                java.lang.String r2 = ir.eitaa.messenger.LocaleController.getString(r6, r2)
                r8.add(r2)
                r2 = 2131231390(0x7f08029e, float:1.807886E38)
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                r0.add(r2)
                java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
                r1.add(r2)
                r2 = 2131694143(0x7f0f123f, float:1.9017434E38)
                java.lang.String r6 = "ShareLink"
                java.lang.String r2 = ir.eitaa.messenger.LocaleController.getString(r6, r2)
                r8.add(r2)
                r2 = 2131231493(0x7f080305, float:1.8079069E38)
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                r0.add(r2)
                java.lang.Integer r2 = java.lang.Integer.valueOf(r5)
                r1.add(r2)
                ir.eitaa.tgnet.TLRPC$TL_chatInviteExported r2 = r7.invite
                boolean r2 = r2.permanent
                if (r2 != 0) goto La3
                ir.eitaa.ui.ManageLinksActivity r2 = ir.eitaa.ui.ManageLinksActivity.this
                boolean r2 = ir.eitaa.ui.ManageLinksActivity.access$2300(r2)
                if (r2 == 0) goto La3
                r2 = 2131691197(0x7f0f06bd, float:1.901146E38)
                java.lang.String r6 = "EditLink"
                java.lang.String r2 = ir.eitaa.messenger.LocaleController.getString(r6, r2)
                r8.add(r2)
                r2 = 2131231401(0x7f0802a9, float:1.8078882E38)
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                r0.add(r2)
                r2 = 2
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                r1.add(r2)
            La3:
                ir.eitaa.ui.ManageLinksActivity r2 = ir.eitaa.ui.ManageLinksActivity.this
                boolean r2 = ir.eitaa.ui.ManageLinksActivity.access$2300(r2)
                if (r2 == 0) goto Lc8
                r2 = 2131693875(0x7f0f1133, float:1.901689E38)
                java.lang.String r6 = "RevokeLink"
                java.lang.String r2 = ir.eitaa.messenger.LocaleController.getString(r6, r2)
                r8.add(r2)
                java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
                r0.add(r2)
                r2 = 3
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                r1.add(r2)
                goto L3a
            Lc8:
                r2 = 0
            Lc9:
                ir.eitaa.ui.ActionBar.AlertDialog$Builder r3 = new ir.eitaa.ui.ActionBar.AlertDialog$Builder
                ir.eitaa.ui.ManageLinksActivity r6 = ir.eitaa.ui.ManageLinksActivity.this
                android.app.Activity r6 = r6.getParentActivity()
                r3.<init>(r6)
                java.lang.CharSequence[] r4 = new java.lang.CharSequence[r4]
                java.lang.Object[] r4 = r8.toArray(r4)
                java.lang.CharSequence[] r4 = (java.lang.CharSequence[]) r4
                int[] r0 = ir.eitaa.messenger.AndroidUtilities.toIntArray(r0)
                ir.eitaa.ui.-$$Lambda$ManageLinksActivity$LinkCell$Hpzuvl75I8JBqM5ltHJ_KH0oGXE r6 = new ir.eitaa.ui.-$$Lambda$ManageLinksActivity$LinkCell$Hpzuvl75I8JBqM5ltHJ_KH0oGXE
                r6.<init>()
                r3.setItems(r4, r0, r6)
                r0 = 2131691950(0x7f0f09ae, float:1.9012986E38)
                java.lang.String r1 = "InviteLink"
                java.lang.String r0 = ir.eitaa.messenger.LocaleController.getString(r1, r0)
                r3.setTitle(r0)
                ir.eitaa.ui.ActionBar.AlertDialog r0 = r3.create()
                r3.show()
                if (r2 == 0) goto L111
                int r8 = r8.size()
                int r8 = r8 - r5
                java.lang.String r1 = "dialogTextRed2"
                int r1 = ir.eitaa.ui.ActionBar.Theme.getColor(r1)
                java.lang.String r2 = "dialogRedIcon"
                int r2 = ir.eitaa.ui.ActionBar.Theme.getColor(r2)
                r0.setItemColor(r8, r1, r2)
            L111:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ManageLinksActivity.LinkCell.lambda$new$3$ManageLinksActivity$LinkCell(android.view.View):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$2$ManageLinksActivity$LinkCell(ArrayList arrayList, DialogInterface dialogInterface, int i) {
            int iIntValue = ((Integer) arrayList.get(i)).intValue();
            if (iIntValue == 0) {
                try {
                    if (this.invite.link == null) {
                        return;
                    }
                    ((ClipboardManager) ApplicationLoader.applicationContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("label", this.invite.link));
                    BulletinFactory.createCopyLinkBulletin(ManageLinksActivity.this).show();
                    return;
                } catch (Exception e) {
                    FileLog.e(e);
                    return;
                }
            }
            if (iIntValue == 1) {
                try {
                    if (this.invite.link == null) {
                        return;
                    }
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.setType("text/plain");
                    intent.putExtra("android.intent.extra.TEXT", this.invite.link);
                    ManageLinksActivity.this.startActivityForResult(Intent.createChooser(intent, LocaleController.getString("InviteToGroupByLink", R.string.InviteToGroupByLink)), 500);
                    return;
                } catch (Exception e2) {
                    FileLog.e(e2);
                    return;
                }
            }
            if (iIntValue == 2) {
                ManageLinksActivity.this.editLink(this.invite);
                return;
            }
            if (iIntValue == 3) {
                final TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported = this.invite;
                AlertDialog.Builder builder = new AlertDialog.Builder(ManageLinksActivity.this.getParentActivity());
                builder.setMessage(LocaleController.getString("RevokeAlert", R.string.RevokeAlert));
                builder.setTitle(LocaleController.getString("RevokeLink", R.string.RevokeLink));
                builder.setPositiveButton(LocaleController.getString("RevokeButton", R.string.RevokeButton), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ManageLinksActivity$LinkCell$LuF3BVsATd3GkUTR5b7li6C3paQ
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface2, int i2) {
                        this.f$0.lambda$new$0$ManageLinksActivity$LinkCell(tLRPC$TL_chatInviteExported, dialogInterface2, i2);
                    }
                });
                builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                ManageLinksActivity.this.showDialog(builder.create());
                return;
            }
            if (iIntValue != 4) {
                return;
            }
            final TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported2 = this.invite;
            AlertDialog.Builder builder2 = new AlertDialog.Builder(ManageLinksActivity.this.getParentActivity());
            builder2.setTitle(LocaleController.getString("DeleteLink", R.string.DeleteLink));
            builder2.setMessage(LocaleController.getString("DeleteLinkHelp", R.string.DeleteLinkHelp));
            builder2.setPositiveButton(LocaleController.getString("Delete", R.string.Delete), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ManageLinksActivity$LinkCell$FZCwyo6NdsptyMdFXKqFPdzIia4
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface2, int i2) {
                    this.f$0.lambda$new$1$ManageLinksActivity$LinkCell(tLRPC$TL_chatInviteExported2, dialogInterface2, i2);
                }
            });
            builder2.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            ManageLinksActivity.this.showDialog(builder2.create());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$0$ManageLinksActivity$LinkCell(TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported, DialogInterface dialogInterface, int i) {
            ManageLinksActivity.this.revokeLink(tLRPC$TL_chatInviteExported);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$1$ManageLinksActivity$LinkCell(TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported, DialogInterface dialogInterface, int i) {
            ManageLinksActivity.this.deleteLink(tLRPC$TL_chatInviteExported);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(64.0f), 1073741824));
            this.paint2.setStrokeWidth(AndroidUtilities.dp(2.0f));
        }

        /* JADX WARN: Removed duplicated region for block: B:62:0x0107  */
        @Override // android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected void onDraw(android.graphics.Canvas r16) {
            /*
                Method dump skipped, instructions count: 575
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ManageLinksActivity.LinkCell.onDraw(android.graphics.Canvas):void");
        }

        private int getColor(int state, float progress) {
            if (state == 3) {
                return Theme.getColor("chat_attachAudioBackground");
            }
            if (state == 1) {
                if (progress > 0.5f) {
                    return ColorUtils.blendARGB(Theme.getColor("chat_attachLocationBackground"), Theme.getColor("chat_attachPollBackground"), 1.0f - ((progress - 0.5f) / 0.5f));
                }
                return ColorUtils.blendARGB(Theme.getColor("chat_attachPollBackground"), Theme.getColor("chat_attachAudioBackground"), 1.0f - (progress / 0.5f));
            }
            if (state == 2) {
                return Theme.getColor("chat_attachPollBackground");
            }
            if (state == 4) {
                return Theme.getColor("chats_unreadCounterMuted");
            }
            return Theme.getColor("featuredStickers_addButton");
        }

        public void setLink(TLRPC$TL_chatInviteExported invite, int position) {
            String pluralString;
            int i;
            String str;
            int i2;
            this.timerRunning = false;
            TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported = this.invite;
            if (tLRPC$TL_chatInviteExported == null || invite == null || !tLRPC$TL_chatInviteExported.link.equals(invite.link)) {
                this.lastDrawingState = -1;
                this.animateToStateProgress = 1.0f;
            }
            this.invite = invite;
            this.position = position;
            if (invite == null) {
                return;
            }
            if (invite.link.startsWith("https://eitaa.com/+")) {
                this.titleView.setText(invite.link.substring(19));
            } else if (invite.link.startsWith("https://eitaa.com/joinchat/")) {
                this.titleView.setText(invite.link.substring(27));
            } else if (invite.link.startsWith("https://")) {
                this.titleView.setText(invite.link.substring(8));
            } else {
                this.titleView.setText(invite.link);
            }
            int i3 = invite.usage;
            if (i3 == 0 && invite.usage_limit == 0) {
                pluralString = LocaleController.getString("NoOneJoinedYet", R.string.NoOneJoinedYet);
            } else {
                int i4 = invite.usage_limit;
                if (i4 > 0 && i3 == 0 && !invite.expired && !invite.revoked) {
                    pluralString = LocaleController.formatPluralString("CanJoin", i4);
                } else if (i4 > 0 && invite.expired && invite.revoked) {
                    pluralString = LocaleController.formatPluralString("PeopleJoined", invite.usage) + ", " + LocaleController.formatPluralString("PeopleJoinedRemaining", invite.usage_limit - invite.usage);
                } else {
                    pluralString = LocaleController.formatPluralString("PeopleJoined", i3);
                }
            }
            if (invite.permanent && !invite.revoked) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(pluralString);
                DotDividerSpan dotDividerSpan = new DotDividerSpan();
                dotDividerSpan.setTopPadding(AndroidUtilities.dp(1.5f));
                spannableStringBuilder.append((CharSequence) "  .  ").setSpan(dotDividerSpan, spannableStringBuilder.length() - 3, spannableStringBuilder.length() - 2, 0);
                spannableStringBuilder.append((CharSequence) LocaleController.getString("Permanent", R.string.Permanent));
                this.subtitleView.setText(spannableStringBuilder);
                return;
            }
            if (invite.expired || invite.revoked) {
                if (invite.revoked && invite.usage == 0) {
                    pluralString = LocaleController.getString("NoOneJoined", R.string.NoOneJoined);
                }
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(pluralString);
                DotDividerSpan dotDividerSpan2 = new DotDividerSpan();
                dotDividerSpan2.setTopPadding(AndroidUtilities.dp(1.5f));
                spannableStringBuilder2.append((CharSequence) "  .  ").setSpan(dotDividerSpan2, spannableStringBuilder2.length() - 3, spannableStringBuilder2.length() - 2, 0);
                boolean z = invite.revoked;
                if (!z && (i2 = invite.usage_limit) > 0 && invite.usage >= i2) {
                    spannableStringBuilder2.append((CharSequence) LocaleController.getString("LinkLimitReached", R.string.LinkLimitReached));
                } else {
                    if (z) {
                        i = R.string.Revoked;
                        str = "Revoked";
                    } else {
                        i = R.string.Expired;
                        str = "Expired";
                    }
                    spannableStringBuilder2.append((CharSequence) LocaleController.getString(str, i));
                }
                this.subtitleView.setText(spannableStringBuilder2);
                return;
            }
            if (invite.expire_date > 0) {
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(pluralString);
                DotDividerSpan dotDividerSpan3 = new DotDividerSpan();
                dotDividerSpan3.setTopPadding(AndroidUtilities.dp(1.5f));
                spannableStringBuilder3.append((CharSequence) "  .  ").setSpan(dotDividerSpan3, spannableStringBuilder3.length() - 3, spannableStringBuilder3.length() - 2, 0);
                long jCurrentTimeMillis = (invite.expire_date * 1000) - (System.currentTimeMillis() + (ManageLinksActivity.this.timeDif * 1000));
                if (jCurrentTimeMillis < 0) {
                    jCurrentTimeMillis = 0;
                }
                if (jCurrentTimeMillis > 86400000) {
                    spannableStringBuilder3.append((CharSequence) LocaleController.formatPluralString("DaysLeft", (int) (jCurrentTimeMillis / 86400000)));
                } else {
                    long j = jCurrentTimeMillis / 1000;
                    int i5 = (int) (j % 60);
                    long j2 = j / 60;
                    int i6 = (int) (j2 % 60);
                    int i7 = (int) (j2 / 60);
                    Locale locale = Locale.ENGLISH;
                    spannableStringBuilder3.append((CharSequence) String.format(locale, "%02d", Integer.valueOf(i7))).append((CharSequence) String.format(locale, ":%02d", Integer.valueOf(i6))).append((CharSequence) String.format(locale, ":%02d", Integer.valueOf(i5)));
                    this.timerRunning = true;
                }
                this.subtitleView.setText(spannableStringBuilder3);
                return;
            }
            this.subtitleView.setText(pluralString);
        }
    }

    public void deleteLink(final TLRPC$TL_chatInviteExported invite) {
        TLRPC$TL_messages_deleteExportedChatInvite tLRPC$TL_messages_deleteExportedChatInvite = new TLRPC$TL_messages_deleteExportedChatInvite();
        tLRPC$TL_messages_deleteExportedChatInvite.link = invite.link;
        tLRPC$TL_messages_deleteExportedChatInvite.peer = getMessagesController().getInputPeer(-this.currentChatId);
        getConnectionsManager().sendRequest(tLRPC$TL_messages_deleteExportedChatInvite, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ManageLinksActivity$XjhWI4V_YwYFzter5SOL645oIh4
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$deleteLink$14$ManageLinksActivity(invite, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$deleteLink$14, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$deleteLink$14$ManageLinksActivity(final TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ManageLinksActivity$uK7LiHZ_1CodfITaphfy16CL_Dk
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$deleteLink$13$ManageLinksActivity(tLRPC$TL_error, tLRPC$TL_chatInviteExported);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$deleteLink$13, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$deleteLink$13$ManageLinksActivity(TLRPC$TL_error tLRPC$TL_error, TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported) {
        if (tLRPC$TL_error == null) {
            this.linkEditActivityCallback.onLinkRemoved(tLRPC$TL_chatInviteExported);
        }
    }

    public void editLink(TLRPC$TL_chatInviteExported invite) {
        LinkEditActivity linkEditActivity = new LinkEditActivity(1, this.currentChatId);
        linkEditActivity.setCallback(this.linkEditActivityCallback);
        linkEditActivity.setInviteToEdit(invite);
        presentFragment(linkEditActivity);
    }

    public void revokeLink(final TLRPC$TL_chatInviteExported invite) {
        TLRPC$TL_messages_editExportedChatInvite tLRPC$TL_messages_editExportedChatInvite = new TLRPC$TL_messages_editExportedChatInvite();
        tLRPC$TL_messages_editExportedChatInvite.link = invite.link;
        tLRPC$TL_messages_editExportedChatInvite.revoked = true;
        tLRPC$TL_messages_editExportedChatInvite.peer = getMessagesController().getInputPeer(-this.currentChatId);
        getConnectionsManager().sendRequest(tLRPC$TL_messages_editExportedChatInvite, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ManageLinksActivity$6c5reWsFpHeM9hsudrQzS-R6RS8
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$revokeLink$16$ManageLinksActivity(invite, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$revokeLink$16, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$revokeLink$16$ManageLinksActivity(final TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ManageLinksActivity$DgNhK7566nL7H65Hf0wHG-NCn4o
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$revokeLink$15$ManageLinksActivity(tLRPC$TL_error, tLObject, tLRPC$TL_chatInviteExported);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$revokeLink$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$revokeLink$15$ManageLinksActivity(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported) {
        if (tLRPC$TL_error == null) {
            if (tLObject instanceof TLRPC$TL_messages_exportedChatInviteReplaced) {
                TLRPC$TL_messages_exportedChatInviteReplaced tLRPC$TL_messages_exportedChatInviteReplaced = (TLRPC$TL_messages_exportedChatInviteReplaced) tLObject;
                if (!this.isPublic) {
                    this.invite = (TLRPC$TL_chatInviteExported) tLRPC$TL_messages_exportedChatInviteReplaced.new_invite;
                }
                tLRPC$TL_chatInviteExported.revoked = true;
                DiffCallback diffCallbackSaveListState = saveListState();
                if (this.isPublic && this.adminId == getAccountInstance().getUserConfig().getClientUserId()) {
                    this.invites.remove(tLRPC$TL_chatInviteExported);
                    this.invites.add(0, (TLRPC$TL_chatInviteExported) tLRPC$TL_messages_exportedChatInviteReplaced.new_invite);
                } else if (this.invite != null) {
                    this.invite = (TLRPC$TL_chatInviteExported) tLRPC$TL_messages_exportedChatInviteReplaced.new_invite;
                }
                this.revokedInvites.add(0, tLRPC$TL_chatInviteExported);
                updateRecyclerViewAnimated(diffCallbackSaveListState);
            } else {
                this.linkEditActivityCallback.onLinkEdited(tLRPC$TL_chatInviteExported, tLObject);
                TLRPC$ChatFull tLRPC$ChatFull = this.info;
                if (tLRPC$ChatFull != null) {
                    int i = tLRPC$ChatFull.invitesCount - 1;
                    tLRPC$ChatFull.invitesCount = i;
                    if (i < 0) {
                        tLRPC$ChatFull.invitesCount = 0;
                    }
                    getMessagesStorage().saveChatLinksCount(this.currentChatId, this.info.invitesCount);
                }
            }
            if (getParentActivity() != null) {
                BulletinFactory.of(this).createSimpleBulletin(R.raw.linkbroken, LocaleController.getString("InviteRevokedHint", R.string.InviteRevokedHint)).show();
            }
        }
    }

    /* renamed from: ir.eitaa.ui.ManageLinksActivity$6, reason: invalid class name */
    class AnonymousClass6 implements LinkEditActivity.Callback {
        AnonymousClass6() {
        }

        @Override // ir.eitaa.ui.LinkEditActivity.Callback
        public void onLinkCreated(final TLObject response) {
            if (response instanceof TLRPC$TL_chatInviteExported) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ManageLinksActivity$6$wl4cwR8qvZLGe3CWtG2na-vZJCk
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onLinkCreated$0$ManageLinksActivity$6(response);
                    }
                }, 200L);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onLinkCreated$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onLinkCreated$0$ManageLinksActivity$6(TLObject tLObject) {
            DiffCallback diffCallbackSaveListState = ManageLinksActivity.this.saveListState();
            ManageLinksActivity.this.invites.add(0, (TLRPC$TL_chatInviteExported) tLObject);
            ManageLinksActivity.this.updateRecyclerViewAnimated(diffCallbackSaveListState);
            if (ManageLinksActivity.this.info != null) {
                ManageLinksActivity.this.info.invitesCount++;
                ManageLinksActivity.this.getMessagesStorage().saveChatLinksCount(ManageLinksActivity.this.currentChatId, ManageLinksActivity.this.info.invitesCount);
            }
        }

        @Override // ir.eitaa.ui.LinkEditActivity.Callback
        public void onLinkEdited(TLRPC$TL_chatInviteExported inviteToEdit, TLObject response) {
            if (response instanceof TLRPC$TL_messages_exportedChatInvite) {
                TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported = (TLRPC$TL_chatInviteExported) ((TLRPC$TL_messages_exportedChatInvite) response).invite;
                ManageLinksActivity.this.fixDate(tLRPC$TL_chatInviteExported);
                for (int i = 0; i < ManageLinksActivity.this.invites.size(); i++) {
                    if (((TLRPC$TL_chatInviteExported) ManageLinksActivity.this.invites.get(i)).link.equals(inviteToEdit.link)) {
                        if (tLRPC$TL_chatInviteExported.revoked) {
                            DiffCallback diffCallbackSaveListState = ManageLinksActivity.this.saveListState();
                            ManageLinksActivity.this.invites.remove(i);
                            ManageLinksActivity.this.revokedInvites.add(0, tLRPC$TL_chatInviteExported);
                            ManageLinksActivity.this.updateRecyclerViewAnimated(diffCallbackSaveListState);
                            return;
                        }
                        ManageLinksActivity.this.invites.set(i, tLRPC$TL_chatInviteExported);
                        ManageLinksActivity.this.updateRows(true);
                        return;
                    }
                }
            }
        }

        @Override // ir.eitaa.ui.LinkEditActivity.Callback
        public void onLinkRemoved(TLRPC$TL_chatInviteExported removedInvite) {
            for (int i = 0; i < ManageLinksActivity.this.revokedInvites.size(); i++) {
                if (((TLRPC$TL_chatInviteExported) ManageLinksActivity.this.revokedInvites.get(i)).link.equals(removedInvite.link)) {
                    DiffCallback diffCallbackSaveListState = ManageLinksActivity.this.saveListState();
                    ManageLinksActivity.this.revokedInvites.remove(i);
                    ManageLinksActivity.this.updateRecyclerViewAnimated(diffCallbackSaveListState);
                    return;
                }
            }
        }

        @Override // ir.eitaa.ui.LinkEditActivity.Callback
        public void revokeLink(TLRPC$TL_chatInviteExported inviteFinal) {
            ManageLinksActivity.this.revokeLink(inviteFinal);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRecyclerViewAnimated(DiffCallback callback) {
        if (this.isPaused || this.listViewAdapter == null || this.listView == null) {
            updateRows(true);
            return;
        }
        updateRows(false);
        callback.fillPositions(callback.newPositionToItem);
        DiffUtil.calculateDiff(callback).dispatchUpdatesTo(this.listViewAdapter);
        AndroidUtilities.updateVisibleRows(this.listView);
    }

    private class DiffCallback extends DiffUtil.Callback {
        SparseIntArray newPositionToItem;
        int oldAdminsEndRow;
        int oldAdminsStartRow;
        ArrayList<TLRPC$TL_chatInviteExported> oldLinks;
        int oldLinksEndRow;
        int oldLinksStartRow;
        SparseIntArray oldPositionToItem;
        ArrayList<TLRPC$TL_chatInviteExported> oldRevokedLinks;
        int oldRevokedLinksEndRow;
        int oldRevokedLinksStartRow;
        int oldRowCount;

        private DiffCallback() {
            this.oldPositionToItem = new SparseIntArray();
            this.newPositionToItem = new SparseIntArray();
            this.oldLinks = new ArrayList<>();
            this.oldRevokedLinks = new ArrayList<>();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getOldListSize() {
            return this.oldRowCount;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getNewListSize() {
            return ManageLinksActivity.this.rowCount;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported;
            if (((oldItemPosition >= this.oldLinksStartRow && oldItemPosition < this.oldLinksEndRow) || (oldItemPosition >= this.oldRevokedLinksStartRow && oldItemPosition < this.oldRevokedLinksEndRow)) && ((newItemPosition >= ManageLinksActivity.this.linksStartRow && newItemPosition < ManageLinksActivity.this.linksEndRow) || (newItemPosition >= ManageLinksActivity.this.revokedLinksStartRow && newItemPosition < ManageLinksActivity.this.revokedLinksEndRow))) {
                TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported2 = (newItemPosition < ManageLinksActivity.this.linksStartRow || newItemPosition >= ManageLinksActivity.this.linksEndRow) ? (TLRPC$TL_chatInviteExported) ManageLinksActivity.this.revokedInvites.get(newItemPosition - ManageLinksActivity.this.revokedLinksStartRow) : (TLRPC$TL_chatInviteExported) ManageLinksActivity.this.invites.get(newItemPosition - ManageLinksActivity.this.linksStartRow);
                int i = this.oldLinksStartRow;
                if (oldItemPosition >= i && oldItemPosition < this.oldLinksEndRow) {
                    tLRPC$TL_chatInviteExported = this.oldLinks.get(oldItemPosition - i);
                } else {
                    tLRPC$TL_chatInviteExported = this.oldRevokedLinks.get(oldItemPosition - this.oldRevokedLinksStartRow);
                }
                return tLRPC$TL_chatInviteExported.link.equals(tLRPC$TL_chatInviteExported2.link);
            }
            if (oldItemPosition >= this.oldAdminsStartRow && oldItemPosition < this.oldAdminsEndRow && newItemPosition >= ManageLinksActivity.this.adminsStartRow && newItemPosition < ManageLinksActivity.this.adminsEndRow) {
                return oldItemPosition - this.oldAdminsStartRow == newItemPosition - ManageLinksActivity.this.adminsStartRow;
            }
            int i2 = this.oldPositionToItem.get(oldItemPosition, -1);
            return i2 >= 0 && i2 == this.newPositionToItem.get(newItemPosition, -1);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            return areItemsTheSame(oldItemPosition, newItemPosition);
        }

        public void fillPositions(SparseIntArray sparseIntArray) {
            sparseIntArray.clear();
            put(1, ManageLinksActivity.this.helpRow, sparseIntArray);
            put(2, ManageLinksActivity.this.permanentLinkHeaderRow, sparseIntArray);
            put(3, ManageLinksActivity.this.permanentLinkRow, sparseIntArray);
            put(4, ManageLinksActivity.this.dividerRow, sparseIntArray);
            put(5, ManageLinksActivity.this.createNewLinkRow, sparseIntArray);
            put(6, ManageLinksActivity.this.revokedHeader, sparseIntArray);
            put(7, ManageLinksActivity.this.revokeAllRow, sparseIntArray);
            put(8, ManageLinksActivity.this.createLinkHelpRow, sparseIntArray);
            put(9, ManageLinksActivity.this.creatorRow, sparseIntArray);
            put(10, ManageLinksActivity.this.creatorDividerRow, sparseIntArray);
            put(11, ManageLinksActivity.this.adminsHeaderRow, sparseIntArray);
            put(12, ManageLinksActivity.this.linksHeaderRow, sparseIntArray);
            put(13, ManageLinksActivity.this.linksLoadingRow, sparseIntArray);
        }

        private void put(int id, int position, SparseIntArray sparseIntArray) {
            if (position >= 0) {
                sparseIntArray.put(position, id);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DiffCallback saveListState() {
        DiffCallback diffCallback = new DiffCallback();
        diffCallback.fillPositions(diffCallback.oldPositionToItem);
        diffCallback.oldLinksStartRow = this.linksStartRow;
        diffCallback.oldLinksEndRow = this.linksEndRow;
        diffCallback.oldRevokedLinksStartRow = this.revokedLinksStartRow;
        diffCallback.oldRevokedLinksEndRow = this.revokedLinksEndRow;
        diffCallback.oldAdminsStartRow = this.adminsStartRow;
        diffCallback.oldAdminsEndRow = this.adminsEndRow;
        diffCallback.oldRowCount = this.rowCount;
        diffCallback.oldLinks.clear();
        diffCallback.oldLinks.addAll(this.invites);
        diffCallback.oldRevokedLinks.clear();
        diffCallback.oldRevokedLinks.addAll(this.revokedInvites);
        return diffCallback;
    }

    public void fixDate(TLRPC$TL_chatInviteExported edited) {
        if (edited.expire_date > 0) {
            edited.expired = getConnectionsManager().getCurrentTime() >= edited.expire_date;
            return;
        }
        int i = edited.usage_limit;
        if (i > 0) {
            edited.expired = edited.usage >= i;
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ManageLinksActivity$NN7SHafsfF8J0A35tPgOpyTGaB0
            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() {
                this.f$0.lambda$getThemeDescriptions$17$ManageLinksActivity();
            }

            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public /* synthetic */ void onAnimationProgress(float f) {
                ThemeDescription.ThemeDescriptionDelegate.CC.$default$onAnimationProgress(this, f);
            }
        };
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{HeaderCell.class, TextCell.class, LinkActionView.class, LinkCell.class}, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND | ThemeDescription.FLAG_CHECKTAG, null, null, null, null, "windowBackgroundGray"));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_CHECKTAG | ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "actionBarDefaultIcon"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, "actionBarDefaultTitle"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "actionBarDefaultSelector"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, "divider"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText4"));
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
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{HintInnerCell.class}, new String[]{"messageTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "chats_message"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{ManageChatTextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{ManageChatTextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "chats_unreadCounterMuted"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{ManageChatTextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueButton"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{ManageChatTextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueIcon"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueText2"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "switchTrackChecked"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "checkboxCheck"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueHeader"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{LinkCell.class}, new String[]{"titleView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{LinkCell.class}, new String[]{"subtitleView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_IMAGECOLOR, new Class[]{LinkCell.class}, new String[]{"optionsView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "stickers_menu"));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getThemeDescriptions$17, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getThemeDescriptions$17$ManageLinksActivity() {
        RecyclerListView recyclerListView = this.listView;
        if (recyclerListView != null) {
            int childCount = recyclerListView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.listView.getChildAt(i);
                if (childAt instanceof ManageChatUserCell) {
                    ((ManageChatUserCell) childAt).update(0);
                }
                if (childAt instanceof LinkActionView) {
                    ((LinkActionView) childAt).updateColors();
                }
            }
        }
        InviteLinkBottomSheet inviteLinkBottomSheet = this.inviteLinkBottomSheet;
        if (inviteLinkBottomSheet != null) {
            inviteLinkBottomSheet.updateColors();
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    protected void onTransitionAnimationEnd(boolean isOpen, boolean backward) {
        super.onTransitionAnimationEnd(isOpen, backward);
        if (isOpen) {
            this.isOpened = true;
        }
        NotificationCenter.getInstance(this.currentAccount).onAnimationFinish(this.animationIndex);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    protected void onTransitionAnimationStart(boolean isOpen, boolean backward) {
        super.onTransitionAnimationStart(isOpen, backward);
        this.animationIndex = NotificationCenter.getInstance(this.currentAccount).setAnimationInProgress(this.animationIndex, null);
    }
}
