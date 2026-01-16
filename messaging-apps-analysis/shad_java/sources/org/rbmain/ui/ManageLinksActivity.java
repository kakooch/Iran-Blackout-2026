package org.rbmain.ui;

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
import com.facebook.stetho.server.http.HttpStatus;
import ir.medu.shad.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.ChatObject;
import org.rbmain.messenger.DocumentObject;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.ImageLocation;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MediaDataController;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.UserConfig;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$ChatFull;
import org.rbmain.tgnet.TLRPC$Document;
import org.rbmain.tgnet.TLRPC$ExportedChatInvite;
import org.rbmain.tgnet.TLRPC$TL_chatAdminWithInvites;
import org.rbmain.tgnet.TLRPC$TL_chatInviteExported;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_messages_chatAdminsWithInvites;
import org.rbmain.tgnet.TLRPC$TL_messages_deleteExportedChatInvite;
import org.rbmain.tgnet.TLRPC$TL_messages_deleteRevokedExportedChatInvites;
import org.rbmain.tgnet.TLRPC$TL_messages_editExportedChatInvite;
import org.rbmain.tgnet.TLRPC$TL_messages_exportChatInvite;
import org.rbmain.tgnet.TLRPC$TL_messages_exportedChatInvite;
import org.rbmain.tgnet.TLRPC$TL_messages_exportedChatInviteReplaced;
import org.rbmain.tgnet.TLRPC$TL_messages_getAdminsWithInvites;
import org.rbmain.tgnet.TLRPC$TL_messages_getExportedChatInvites;
import org.rbmain.tgnet.TLRPC$TL_messages_stickerSet;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.SimpleTextView;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.Cells.HeaderCell;
import org.rbmain.ui.Cells.ManageChatTextCell;
import org.rbmain.ui.Cells.ManageChatUserCell;
import org.rbmain.ui.Cells.ShadowSectionCell;
import org.rbmain.ui.Cells.TextInfoPrivacyCell;
import org.rbmain.ui.Cells.TextSettingsCell;
import org.rbmain.ui.Components.BackupImageView;
import org.rbmain.ui.Components.BulletinFactory;
import org.rbmain.ui.Components.DotDividerSpan;
import org.rbmain.ui.Components.FlickerLoadingView;
import org.rbmain.ui.Components.InviteLinkBottomSheet;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.LinkActionView;
import org.rbmain.ui.Components.RecyclerItemsEnterAnimator;
import org.rbmain.ui.Components.RecyclerListView;
import org.rbmain.ui.Components.TimerParticles;
import org.rbmain.ui.LinkEditActivity;

/* loaded from: classes4.dex */
public class ManageLinksActivity extends BaseFragment {
    private int adminId;
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
    private int currentChatId;
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
    private HashMap<Integer, TLRPC$User> users = new HashMap<>();
    private ArrayList<TLRPC$TL_chatAdminWithInvites> admins = new ArrayList<>();
    Runnable updateTimerRunnable = new Runnable() { // from class: org.rbmain.ui.ManageLinksActivity.1
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
    private final LinkEditActivity.Callback linkEditActivityCallback = new AnonymousClass5();
    int animationIndex = -1;

    @Override // org.rbmain.ui.ActionBar.BaseFragment
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
            addView(backupImageView, LayoutHelper.createLinear(104, 104, 49, 0, 2, 0, 0));
        }

        private void setSticker() {
            TLRPC$TL_messages_stickerSet stickerSetByName = MediaDataController.getInstance(this.currentAccount).getStickerSetByName("tg_placeholders");
            if (stickerSetByName == null) {
                stickerSetByName = MediaDataController.getInstance(this.currentAccount).getStickerSetByEmojiOrName("tg_placeholders");
            }
            TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet = stickerSetByName;
            if (tLRPC$TL_messages_stickerSet != null && tLRPC$TL_messages_stickerSet.documents.size() >= 4) {
                TLRPC$Document tLRPC$Document = tLRPC$TL_messages_stickerSet.documents.get(3);
                this.stickerView.setImage(ImageLocation.getForDocument(tLRPC$Document), "104_104", "tgs", DocumentObject.getSvgThumb(tLRPC$Document, Theme.key_windowBackgroundGray, 1.0f), tLRPC$TL_messages_stickerSet);
            } else {
                MediaDataController.getInstance(this.currentAccount).loadStickersByEmojiOrName("tg_placeholders", false, tLRPC$TL_messages_stickerSet == null);
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

        @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
        public void didReceivedNotification(int i, int i2, Object... objArr) {
            if (i == NotificationCenter.diceStickersDidLoad && "tg_placeholders".equals((String) objArr[0])) {
                setSticker();
            }
        }
    }

    public ManageLinksActivity(int i, int i2, int i3) {
        boolean z = false;
        this.currentChatId = i;
        this.invitesCount = i3;
        TLRPC$Chat chat = MessagesController.getInstance(this.currentAccount).getChat(Integer.valueOf(i));
        this.currentChat = chat;
        this.isChannel = ChatObject.isChannel(chat) && !this.currentChat.megagroup;
        if (i2 == 0) {
            this.adminId = getAccountInstance().getUserConfig().clientUserId;
        } else {
            this.adminId = i2;
        }
        TLRPC$User user = getMessagesController().getUser(Integer.valueOf(this.adminId));
        if (this.adminId == getAccountInstance().getUserConfig().clientUserId || (user != null && !user.bot)) {
            z = true;
        }
        this.canEdit = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadLinks(boolean z) {
        if (this.loadAdmins && !this.adminsLoaded) {
            this.linksLoading = true;
            TLRPC$TL_messages_getAdminsWithInvites tLRPC$TL_messages_getAdminsWithInvites = new TLRPC$TL_messages_getAdminsWithInvites();
            tLRPC$TL_messages_getAdminsWithInvites.peer = getMessagesController().getInputPeer(-this.currentChatId);
            getConnectionsManager().bindRequestToGuid(getConnectionsManager().sendRequest(tLRPC$TL_messages_getAdminsWithInvites, new RequestDelegate() { // from class: org.rbmain.ui.ManageLinksActivity$$ExternalSyntheticLambda10
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$loadLinks$2(tLObject, tLRPC$TL_error);
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
            final boolean z2 = this.loadRevoked;
            if (z2) {
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
            getDialogsProxy().getGroupLinks(tLRPC$TL_messages_getExportedChatInvites, new RequestDelegate() { // from class: org.rbmain.ui.ManageLinksActivity$$ExternalSyntheticLambda14
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$loadLinks$5(z2, tLObject, tLRPC$TL_error);
                }
            });
        }
        if (z) {
            updateRows(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadLinks$2(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ManageLinksActivity$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadLinks$1(tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadLinks$1(final TLRPC$TL_error tLRPC$TL_error, final TLObject tLObject) {
        getNotificationCenter().doOnIdle(new Runnable() { // from class: org.rbmain.ui.ManageLinksActivity$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadLinks$0(tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadLinks$0(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
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
                this.users.put(Integer.valueOf(tLRPC$User.id), tLRPC$User);
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
    /* JADX WARN: Removed duplicated region for block: B:6:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$loadLinks$5(final boolean r8, final org.rbmain.tgnet.TLObject r9, final org.rbmain.tgnet.TLRPC$TL_error r10) {
        /*
            r7 = this;
            if (r10 != 0) goto L17
            r0 = r9
            org.rbmain.tgnet.TLRPC$TL_messages_exportedChatInvites r0 = (org.rbmain.tgnet.TLRPC$TL_messages_exportedChatInvites) r0
            java.util.ArrayList<org.rbmain.tgnet.TLRPC$ExportedChatInvite> r1 = r0.invites
            int r1 = r1.size()
            if (r1 <= 0) goto L17
            java.util.ArrayList<org.rbmain.tgnet.TLRPC$ExportedChatInvite> r0 = r0.invites
            r1 = 0
            java.lang.Object r0 = r0.remove(r1)
            org.rbmain.tgnet.TLRPC$TL_chatInviteExported r0 = (org.rbmain.tgnet.TLRPC$TL_chatInviteExported) r0
            goto L18
        L17:
            r0 = 0
        L18:
            r3 = r0
            org.rbmain.ui.ManageLinksActivity$$ExternalSyntheticLambda2 r0 = new org.rbmain.ui.ManageLinksActivity$$ExternalSyntheticLambda2
            r1 = r0
            r2 = r7
            r4 = r10
            r5 = r9
            r6 = r8
            r1.<init>()
            org.rbmain.messenger.AndroidUtilities.runOnUIThread(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.ManageLinksActivity.lambda$loadLinks$5(boolean, org.rbmain.tgnet.TLObject, org.rbmain.tgnet.TLRPC$TL_error):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadLinks$4(final TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported, final TLRPC$TL_error tLRPC$TL_error, final TLObject tLObject, final boolean z) {
        getNotificationCenter().doOnIdle(new Runnable() { // from class: org.rbmain.ui.ManageLinksActivity$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadLinks$3(tLRPC$TL_chatInviteExported, tLRPC$TL_error, tLObject, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0156  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$loadLinks$3(org.rbmain.tgnet.TLRPC$TL_chatInviteExported r6, org.rbmain.tgnet.TLRPC$TL_error r7, org.rbmain.tgnet.TLObject r8, boolean r9) {
        /*
            Method dump skipped, instructions count: 367
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.ManageLinksActivity.lambda$loadLinks$3(org.rbmain.tgnet.TLRPC$TL_chatInviteExported, org.rbmain.tgnet.TLRPC$TL_error, org.rbmain.tgnet.TLObject, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRows(boolean z) {
        TLRPC$Chat chat = MessagesController.getInstance(this.currentAccount).getChat(Integer.valueOf(this.currentChatId));
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
        boolean z2 = this.adminId != getAccountInstance().getUserConfig().clientUserId;
        if (z2) {
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
        this.rowCount = i5 + 1;
        this.permanentLinkRow = i5;
        if (z2 && !this.invites.isEmpty()) {
            int i6 = this.rowCount;
            int i7 = i6 + 1;
            this.rowCount = i7;
            this.dividerRow = i6;
            this.rowCount = i7 + 1;
            this.linksHeaderRow = i7;
        }
        if (!this.invites.isEmpty()) {
            int i8 = this.rowCount;
            this.linksStartRow = i8;
            int size = i8 + this.invites.size();
            this.rowCount = size;
            this.linksEndRow = size;
        }
        if (!z2 && this.invites.isEmpty() && this.createNewLinkRow >= 0 && (!this.linksLoading || this.loadAdmins || this.loadRevoked)) {
            int i9 = this.rowCount;
            this.rowCount = i9 + 1;
            this.createLinkHelpRow = i9;
        }
        if (!z2 && this.admins.size() > 0) {
            if ((!this.invites.isEmpty() || this.createNewLinkRow >= 0) && this.createLinkHelpRow == -1) {
                int i10 = this.rowCount;
                this.rowCount = i10 + 1;
                this.adminsDividerRow = i10;
            }
            int i11 = this.rowCount;
            int i12 = i11 + 1;
            this.rowCount = i12;
            this.adminsHeaderRow = i11;
            this.adminsStartRow = i12;
            int size2 = i12 + this.admins.size();
            this.rowCount = size2;
            this.adminsEndRow = size2;
        }
        if (!this.revokedInvites.isEmpty()) {
            if (this.adminsStartRow >= 0) {
                int i13 = this.rowCount;
                this.rowCount = i13 + 1;
                this.revokedDivider = i13;
            } else if ((!this.invites.isEmpty() || this.createNewLinkRow >= 0) && this.createLinkHelpRow == -1) {
                int i14 = this.rowCount;
                this.rowCount = i14 + 1;
                this.revokedDivider = i14;
            } else if (z2 && this.linksStartRow == -1) {
                int i15 = this.rowCount;
                this.rowCount = i15 + 1;
                this.revokedDivider = i15;
            }
            int i16 = this.rowCount;
            int i17 = i16 + 1;
            this.rowCount = i17;
            this.revokedHeader = i16;
            this.revokedLinksStartRow = i17;
            int size3 = i17 + this.revokedInvites.size();
            this.rowCount = size3;
            this.revokedLinksEndRow = size3;
            int i18 = size3 + 1;
            this.rowCount = i18;
            this.revokeAllDivider = size3;
            this.rowCount = i18 + 1;
            this.revokeAllRow = i18;
        }
        if (!this.loadAdmins && !this.loadRevoked && ((this.linksLoading || this.hasMore) && !z2)) {
            int i19 = this.rowCount;
            this.rowCount = i19 + 1;
            this.linksLoadingRow = i19;
        }
        if (!this.invites.isEmpty() || !this.revokedInvites.isEmpty()) {
            int i20 = this.rowCount;
            this.rowCount = i20 + 1;
            this.lastDivider = i20;
        }
        ListAdapter listAdapter = this.listViewAdapter;
        if (listAdapter == null || !z) {
            return;
        }
        listAdapter.notifyDataSetChanged();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(final Context context) {
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setAllowOverlayTitle(true);
        this.actionBar.setTitle(LocaleController.getString("InviteLinks", R.string.InviteLinks));
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: org.rbmain.ui.ManageLinksActivity.2
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i) {
                if (i == -1) {
                    ManageLinksActivity.this.finishFragment();
                }
            }
        });
        FrameLayout frameLayout = new FrameLayout(context) { // from class: org.rbmain.ui.ManageLinksActivity.3
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
        int i = Theme.key_windowBackgroundGray;
        frameLayout.setBackgroundColor(Theme.getColor(i));
        this.fragmentView.setTag(Integer.valueOf(i));
        FrameLayout frameLayout2 = (FrameLayout) this.fragmentView;
        this.listView = new RecyclerListView(context);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, 1, false);
        this.listView.setLayoutManager(linearLayoutManager);
        RecyclerListView recyclerListView = this.listView;
        ListAdapter listAdapter = new ListAdapter(context);
        this.listViewAdapter = listAdapter;
        recyclerListView.setAdapter(listAdapter);
        this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: org.rbmain.ui.ManageLinksActivity.4
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
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
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: org.rbmain.ui.ManageLinksActivity$$ExternalSyntheticLambda16
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i2) {
                this.f$0.lambda$createView$9(context, view, i2);
            }
        });
        this.listView.setOnItemLongClickListener(new RecyclerListView.OnItemLongClickListener() { // from class: org.rbmain.ui.ManageLinksActivity$$ExternalSyntheticLambda17
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemLongClickListener
            public final boolean onItemClick(View view, int i2) {
                return this.f$0.lambda$createView$10(view, i2);
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
    public /* synthetic */ void lambda$createView$9(Context context, View view, int i) {
        if (i == this.creatorRow) {
            TLRPC$User tLRPC$User = this.users.get(Integer.valueOf(this.invite.admin_id));
            if (tLRPC$User != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("user_id", tLRPC$User.id);
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
            builder.setPositiveButton(LocaleController.getString("Delete", R.string.Delete), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.ManageLinksActivity$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    this.f$0.lambda$createView$8(dialogInterface, i4);
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
        if (this.users.containsKey(Integer.valueOf(tLRPC$TL_chatAdminWithInvites.admin_id))) {
            getMessagesController().putUser(this.users.get(Integer.valueOf(tLRPC$TL_chatAdminWithInvites.admin_id)), false);
        }
        ManageLinksActivity manageLinksActivity = new ManageLinksActivity(this.currentChatId, tLRPC$TL_chatAdminWithInvites.admin_id, tLRPC$TL_chatAdminWithInvites.invites_count);
        manageLinksActivity.setInfo(this.info, null);
        presentFragment(manageLinksActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$8(DialogInterface dialogInterface, int i) {
        TLRPC$TL_messages_deleteRevokedExportedChatInvites tLRPC$TL_messages_deleteRevokedExportedChatInvites = new TLRPC$TL_messages_deleteRevokedExportedChatInvites();
        tLRPC$TL_messages_deleteRevokedExportedChatInvites.peer = getMessagesController().getInputPeer(-this.currentChatId);
        if (this.adminId == getUserConfig().getClientUserId()) {
            tLRPC$TL_messages_deleteRevokedExportedChatInvites.admin_id = getMessagesController().getInputUser(getUserConfig().getCurrentUser());
        } else {
            tLRPC$TL_messages_deleteRevokedExportedChatInvites.admin_id = getMessagesController().getInputUser(this.adminId);
        }
        this.deletingRevokedLinks = true;
        getConnectionsManager().sendRequest(tLRPC$TL_messages_deleteRevokedExportedChatInvites, new RequestDelegate() { // from class: org.rbmain.ui.ManageLinksActivity$$ExternalSyntheticLambda9
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$createView$7(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$7(TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ManageLinksActivity$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createView$6(tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$6(TLRPC$TL_error tLRPC$TL_error) {
        this.deletingRevokedLinks = false;
        if (tLRPC$TL_error == null) {
            DiffCallback diffCallbackSaveListState = saveListState();
            this.revokedInvites.clear();
            updateRecyclerViewAnimated(diffCallbackSaveListState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$createView$10(View view, int i) {
        if ((i < this.linksStartRow || i >= this.linksEndRow) && (i < this.revokedLinksStartRow || i >= this.revokedLinksEndRow)) {
            return false;
        }
        ((LinkCell) view).optionsView.callOnClick();
        view.performHapticFeedback(0, 2);
        return true;
    }

    public void setInfo(TLRPC$ChatFull tLRPC$ChatFull, TLRPC$ExportedChatInvite tLRPC$ExportedChatInvite) {
        this.info = tLRPC$ChatFull;
        this.invite = (TLRPC$TL_chatInviteExported) tLRPC$ExportedChatInvite;
        this.isPublic = !TextUtils.isEmpty(this.currentChat.username);
        loadLinks(true);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
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

        public HintInnerCell(ManageLinksActivity manageLinksActivity, Context context) {
            int i;
            String str;
            super(context);
            EmptyView emptyView = new EmptyView(context);
            this.emptyView = emptyView;
            addView(emptyView, LayoutHelper.createFrame(-2, -2.0f, 49, 0.0f, 10.0f, 0.0f, 0.0f));
            TextView textView = new TextView(context);
            this.messageTextView = textView;
            textView.setTextColor(Theme.getColor(Theme.key_chats_message));
            this.messageTextView.setTextSize(1, 14.0f);
            this.messageTextView.setGravity(17);
            TextView textView2 = this.messageTextView;
            if (manageLinksActivity.isChannel) {
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
        protected void onMeasure(int i, int i2) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), i2);
        }
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            int adapterPosition = viewHolder.getAdapterPosition();
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

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            FlickerLoadingView flickerLoadingView;
            View shadowSectionCell;
            switch (i) {
                case 1:
                    View headerCell = new HeaderCell(this.mContext, 23);
                    headerCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                    shadowSectionCell = headerCell;
                    break;
                case 2:
                    Context context = this.mContext;
                    ManageLinksActivity manageLinksActivity = ManageLinksActivity.this;
                    final LinkActionView linkActionView = new LinkActionView(context, manageLinksActivity, null, manageLinksActivity.currentChatId, true, ManageLinksActivity.this.isChannel);
                    linkActionView.setPermanent(true);
                    linkActionView.setDelegate(new LinkActionView.Delegate() { // from class: org.rbmain.ui.ManageLinksActivity.ListAdapter.1
                        @Override // org.rbmain.ui.Components.LinkActionView.Delegate
                        public /* synthetic */ void editLink() {
                            LinkActionView.Delegate.CC.$default$editLink(this);
                        }

                        @Override // org.rbmain.ui.Components.LinkActionView.Delegate
                        public /* synthetic */ void removeLink() {
                            LinkActionView.Delegate.CC.$default$removeLink(this);
                        }

                        @Override // org.rbmain.ui.Components.LinkActionView.Delegate
                        public void revokeLink() {
                            ManageLinksActivity.this.revokePermanent();
                        }

                        @Override // org.rbmain.ui.Components.LinkActionView.Delegate
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
                    linkActionView.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                    flickerLoadingView = linkActionView;
                    shadowSectionCell = flickerLoadingView;
                    break;
                case 3:
                    View textCell = new TextCell(this.mContext);
                    textCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                    shadowSectionCell = textCell;
                    break;
                case 4:
                    shadowSectionCell = new ShadowSectionCell(this.mContext);
                    break;
                case 5:
                    shadowSectionCell = ManageLinksActivity.this.new LinkCell(this.mContext);
                    break;
                case 6:
                    FlickerLoadingView flickerLoadingView2 = new FlickerLoadingView(this.mContext);
                    flickerLoadingView2.setIsSingleCell(true);
                    flickerLoadingView2.setViewType(9);
                    flickerLoadingView2.showDate(false);
                    flickerLoadingView2.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                    flickerLoadingView = flickerLoadingView2;
                    shadowSectionCell = flickerLoadingView;
                    break;
                case 7:
                    View shadowSectionCell2 = new ShadowSectionCell(this.mContext);
                    shadowSectionCell2.setBackground(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, Theme.key_windowBackgroundGrayShadow));
                    shadowSectionCell = shadowSectionCell2;
                    break;
                case 8:
                    TextSettingsCell textSettingsCell = new TextSettingsCell(this.mContext);
                    textSettingsCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                    textSettingsCell.setText(LocaleController.getString("DeleteAllRevokedLinks", R.string.DeleteAllRevokedLinks), false);
                    textSettingsCell.setTextColor(Theme.getColor(Theme.key_text_RedRegular));
                    shadowSectionCell = textSettingsCell;
                    break;
                case 9:
                    TextInfoPrivacyCell textInfoPrivacyCell = new TextInfoPrivacyCell(this.mContext);
                    textInfoPrivacyCell.setText(LocaleController.getString("CreateNewLinkHelp", R.string.CreateNewLinkHelp));
                    textInfoPrivacyCell.setBackground(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, Theme.key_windowBackgroundGrayShadow));
                    shadowSectionCell = textInfoPrivacyCell;
                    break;
                case 10:
                    FrameLayout manageChatUserCell = new ManageChatUserCell(this.mContext, 8, 6, false);
                    manageChatUserCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                    shadowSectionCell = manageChatUserCell;
                    break;
                default:
                    View hintInnerCell = new HintInnerCell(ManageLinksActivity.this, this.mContext);
                    hintInnerCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, Theme.key_windowBackgroundWhite));
                    shadowSectionCell = hintInnerCell;
                    break;
            }
            shadowSectionCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            return new RecyclerListView.Holder(shadowSectionCell);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0075  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00d3 A[PHI: r0
          0x00d3: PHI (r0v46 org.rbmain.tgnet.TLRPC$TL_chatInviteExported) = (r0v45 org.rbmain.tgnet.TLRPC$TL_chatInviteExported), (r0v53 org.rbmain.tgnet.TLRPC$TL_chatInviteExported) binds: [B:31:0x00d1, B:28:0x00b3] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder r6, int r7) throws android.content.res.Resources.NotFoundException {
            /*
                Method dump skipped, instructions count: 641
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.ManageLinksActivity.ListAdapter.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view = viewHolder.itemView;
            if (view instanceof ManageChatUserCell) {
                ((ManageChatUserCell) view).recycle();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i == ManageLinksActivity.this.helpRow) {
                return 0;
            }
            if (i == ManageLinksActivity.this.permanentLinkHeaderRow || i == ManageLinksActivity.this.revokedHeader || i == ManageLinksActivity.this.adminsHeaderRow || i == ManageLinksActivity.this.linksHeaderRow) {
                return 1;
            }
            if (i == ManageLinksActivity.this.permanentLinkRow) {
                return 2;
            }
            if (i == ManageLinksActivity.this.createNewLinkRow) {
                return 3;
            }
            if (i == ManageLinksActivity.this.dividerRow || i == ManageLinksActivity.this.revokedDivider || i == ManageLinksActivity.this.revokeAllDivider || i == ManageLinksActivity.this.creatorDividerRow || i == ManageLinksActivity.this.adminsDividerRow) {
                return 4;
            }
            if (i >= ManageLinksActivity.this.linksStartRow && i < ManageLinksActivity.this.linksEndRow) {
                return 5;
            }
            if (i >= ManageLinksActivity.this.revokedLinksStartRow && i < ManageLinksActivity.this.revokedLinksEndRow) {
                return 5;
            }
            if (i == ManageLinksActivity.this.linksLoadingRow) {
                return 6;
            }
            if (i == ManageLinksActivity.this.lastDivider) {
                return 7;
            }
            if (i == ManageLinksActivity.this.revokeAllRow) {
                return 8;
            }
            if (i == ManageLinksActivity.this.createLinkHelpRow) {
                return 9;
            }
            if (i != ManageLinksActivity.this.creatorRow) {
                return (i < ManageLinksActivity.this.adminsStartRow || i >= ManageLinksActivity.this.adminsEndRow) ? 1 : 10;
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
            getDialogsProxy().setGroupOrChannelLinks(tLRPC$TL_messages_exportChatInvite, new RequestDelegate() { // from class: org.rbmain.ui.ManageLinksActivity$$ExternalSyntheticLambda13
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$revokePermanent$12(tLRPC$TL_chatInviteExported, tLObject, tLRPC$TL_error);
                }
            });
            AndroidUtilities.updateVisibleRows(this.listView);
            return;
        }
        revokeLink(this.invite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$revokePermanent$12(final TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ManageLinksActivity$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$revokePermanent$11(tLRPC$TL_error, tLObject, tLRPC$TL_chatInviteExported);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$revokePermanent$11(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported) {
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
            updateRecyclerViewAnimated(saveListState());
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
            SimpleTextView simpleTextView2 = this.textView;
            int i = Theme.key_windowBackgroundWhiteBlueText2;
            simpleTextView2.setTextColor(Theme.getColor(i));
            this.textView.setTag(Integer.valueOf(i));
            addView(this.textView);
            ImageView imageView = new ImageView(context);
            this.imageView = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            addView(this.imageView);
            setWillNotDraw(false);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            int size = View.MeasureSpec.getSize(i);
            AndroidUtilities.dp(48.0f);
            this.textView.measure(View.MeasureSpec.makeMeasureSpec(size - AndroidUtilities.dp(94.0f), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(20.0f), 1073741824));
            this.imageView.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(50.0f), 1073741824));
            setMeasuredDimension(size, AndroidUtilities.dp(50.0f));
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            int iDp;
            int i5 = i3 - i;
            int textHeight = ((i4 - i2) - this.textView.getTextHeight()) / 2;
            if (LocaleController.isRTL) {
                iDp = (getMeasuredWidth() - this.textView.getMeasuredWidth()) - AndroidUtilities.dp(this.imageView.getVisibility() == 0 ? 70.0f : 25.0f);
            } else {
                iDp = AndroidUtilities.dp(this.imageView.getVisibility() == 0 ? 70.0f : 25.0f);
            }
            SimpleTextView simpleTextView = this.textView;
            simpleTextView.layout(iDp, textHeight, simpleTextView.getMeasuredWidth() + iDp, this.textView.getMeasuredHeight() + textHeight);
            int iDp2 = !LocaleController.isRTL ? (AndroidUtilities.dp(70.0f) - this.imageView.getMeasuredWidth()) / 2 : (i5 - this.imageView.getMeasuredWidth()) - AndroidUtilities.dp(25.0f);
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

        public void setTextAndIcon(String str, Drawable drawable, boolean z) {
            this.textView.setText(str);
            this.imageView.setImageDrawable(drawable);
            this.divider = z;
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

        private boolean hasProgress(int i) {
            return i == 2 || i == 1;
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
            this.titleView.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteBlackText));
            this.titleView.setLines(1);
            this.titleView.setEllipsize(TextUtils.TruncateAt.END);
            TextView textView2 = new TextView(context);
            this.subtitleView = textView2;
            textView2.setTextSize(1, 13.0f);
            this.subtitleView.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteGrayText));
            linearLayout.addView(this.titleView, LayoutHelper.createLinear(-1, -2));
            linearLayout.addView(this.subtitleView, LayoutHelper.createLinear(-1, -2, 0.0f, 6.0f, 0.0f, 0.0f));
            ImageView imageView = new ImageView(context);
            this.optionsView = imageView;
            imageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_ab_other));
            this.optionsView.setScaleType(ImageView.ScaleType.CENTER);
            this.optionsView.setColorFilter(Theme.getColor(Theme.key_stickers_menu));
            this.optionsView.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.ManageLinksActivity$LinkCell$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$3(view);
                }
            });
            this.optionsView.setBackground(Theme.createSelectorDrawable(Theme.getColor(Theme.key_listSelector), 1));
            addView(this.optionsView, LayoutHelper.createFrame(40, 48, 21));
            setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
            setWillNotDraw(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:20:0x00fd  */
        /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public /* synthetic */ void lambda$new$3(android.view.View r8) {
            /*
                r7 = this;
                org.rbmain.tgnet.TLRPC$TL_chatInviteExported r8 = r7.invite
                if (r8 != 0) goto L5
                return
            L5:
                java.util.ArrayList r8 = new java.util.ArrayList
                r8.<init>()
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>()
                org.rbmain.tgnet.TLRPC$TL_chatInviteExported r2 = r7.invite
                boolean r2 = r2.revoked
                r3 = 2131231972(0x7f0804e4, float:1.808004E38)
                r4 = 0
                r5 = 1
                if (r2 == 0) goto L3d
                r2 = 2131887839(0x7f1206df, float:1.9410296E38)
                java.lang.String r6 = "Delete"
                java.lang.String r2 = org.rbmain.messenger.LocaleController.getString(r6, r2)
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
                r2 = 2131887693(0x7f12064d, float:1.941E38)
                java.lang.String r6 = "CopyLink"
                java.lang.String r2 = org.rbmain.messenger.LocaleController.getString(r6, r2)
                r8.add(r2)
                r2 = 2131231969(0x7f0804e1, float:1.8080034E38)
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                r0.add(r2)
                java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
                r1.add(r2)
                r2 = 2131891659(0x7f1215cb, float:1.9418044E38)
                java.lang.String r6 = "ShareLink"
                java.lang.String r2 = org.rbmain.messenger.LocaleController.getString(r6, r2)
                r8.add(r2)
                r2 = 2131232104(0x7f080568, float:1.8080308E38)
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                r0.add(r2)
                java.lang.Integer r2 = java.lang.Integer.valueOf(r5)
                r1.add(r2)
                org.rbmain.tgnet.TLRPC$TL_chatInviteExported r2 = r7.invite
                boolean r2 = r2.permanent
                if (r2 != 0) goto La3
                org.rbmain.ui.ManageLinksActivity r2 = org.rbmain.ui.ManageLinksActivity.this
                boolean r2 = org.rbmain.ui.ManageLinksActivity.access$2200(r2)
                if (r2 == 0) goto La3
                r2 = 2131888091(0x7f1207db, float:1.9410808E38)
                java.lang.String r6 = "EditLink"
                java.lang.String r2 = org.rbmain.messenger.LocaleController.getString(r6, r2)
                r8.add(r2)
                r2 = 2131231982(0x7f0804ee, float:1.808006E38)
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                r0.add(r2)
                r2 = 2
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                r1.add(r2)
            La3:
                org.rbmain.ui.ManageLinksActivity r2 = org.rbmain.ui.ManageLinksActivity.this
                boolean r2 = org.rbmain.ui.ManageLinksActivity.access$2200(r2)
                if (r2 == 0) goto Lc8
                r2 = 2131891257(0x7f121439, float:1.9417229E38)
                java.lang.String r6 = "RevokeLink"
                java.lang.String r2 = org.rbmain.messenger.LocaleController.getString(r6, r2)
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
                org.rbmain.ui.ActionBar.AlertDialog$Builder r3 = new org.rbmain.ui.ActionBar.AlertDialog$Builder
                org.rbmain.ui.ManageLinksActivity r6 = org.rbmain.ui.ManageLinksActivity.this
                android.app.Activity r6 = r6.getParentActivity()
                r3.<init>(r6)
                java.lang.CharSequence[] r4 = new java.lang.CharSequence[r4]
                java.lang.Object[] r4 = r8.toArray(r4)
                java.lang.CharSequence[] r4 = (java.lang.CharSequence[]) r4
                int[] r0 = org.rbmain.messenger.AndroidUtilities.toIntArray(r0)
                org.rbmain.ui.ManageLinksActivity$LinkCell$$ExternalSyntheticLambda0 r6 = new org.rbmain.ui.ManageLinksActivity$LinkCell$$ExternalSyntheticLambda0
                r6.<init>()
                r3.setItems(r4, r0, r6)
                r0 = 2131889101(0x7f120bcd, float:1.9412856E38)
                java.lang.String r1 = "InviteLink"
                java.lang.String r0 = org.rbmain.messenger.LocaleController.getString(r1, r0)
                r3.setTitle(r0)
                org.rbmain.ui.ActionBar.AlertDialog r0 = r3.create()
                r3.show()
                if (r2 == 0) goto L111
                int r8 = r8.size()
                int r8 = r8 - r5
                int r1 = org.rbmain.ui.ActionBar.Theme.key_text_RedBold
                int r1 = org.rbmain.ui.ActionBar.Theme.getColor(r1)
                int r2 = org.rbmain.ui.ActionBar.Theme.key_text_RedRegular
                int r2 = org.rbmain.ui.ActionBar.Theme.getColor(r2)
                r0.setItemColor(r8, r1, r2)
            L111:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.ManageLinksActivity.LinkCell.lambda$new$3(android.view.View):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$2(ArrayList arrayList, DialogInterface dialogInterface, int i) {
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
                    ManageLinksActivity.this.startActivityForResult(Intent.createChooser(intent, LocaleController.getString("InviteToGroupByLink", R.string.InviteToGroupByLink)), HttpStatus.HTTP_INTERNAL_SERVER_ERROR);
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
                builder.setPositiveButton(LocaleController.getString("RevokeButton", R.string.RevokeButton), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.ManageLinksActivity$LinkCell$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface2, int i2) {
                        this.f$0.lambda$new$0(tLRPC$TL_chatInviteExported, dialogInterface2, i2);
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
            builder2.setPositiveButton(LocaleController.getString("Delete", R.string.Delete), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.ManageLinksActivity$LinkCell$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface2, int i2) {
                    this.f$0.lambda$new$1(tLRPC$TL_chatInviteExported2, dialogInterface2, i2);
                }
            });
            builder2.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            ManageLinksActivity.this.showDialog(builder2.create());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0(TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported, DialogInterface dialogInterface, int i) {
            ManageLinksActivity.this.revokeLink(tLRPC$TL_chatInviteExported);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$1(TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported, DialogInterface dialogInterface, int i) {
            ManageLinksActivity.this.deleteLink(tLRPC$TL_chatInviteExported);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(64.0f), 1073741824));
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
                Method dump skipped, instructions count: 573
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.ManageLinksActivity.LinkCell.onDraw(android.graphics.Canvas):void");
        }

        private int getColor(int i, float f) {
            if (i == 3) {
                return Theme.getColor(Theme.key_chat_attachAudioBackground);
            }
            if (i == 1) {
                if (f > 0.5f) {
                    return ColorUtils.blendARGB(Theme.getColor(Theme.key_chat_attachLocationBackground), Theme.getColor(Theme.key_chat_attachPollBackground), 1.0f - ((f - 0.5f) / 0.5f));
                }
                return ColorUtils.blendARGB(Theme.getColor(Theme.key_chat_attachPollBackground), Theme.getColor(Theme.key_chat_attachAudioBackground), 1.0f - (f / 0.5f));
            }
            if (i == 2) {
                return Theme.getColor(Theme.key_chat_attachPollBackground);
            }
            if (i == 4) {
                return Theme.getColor(Theme.key_chats_unreadCounterMuted);
            }
            return Theme.getColor(Theme.key_featuredStickers_addButton);
        }

        public void setLink(TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported, int i) {
            String pluralString;
            int i2;
            String str;
            int i3;
            this.timerRunning = false;
            TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported2 = this.invite;
            if (tLRPC$TL_chatInviteExported2 == null || tLRPC$TL_chatInviteExported == null || !tLRPC$TL_chatInviteExported2.link.equals(tLRPC$TL_chatInviteExported.link)) {
                this.lastDrawingState = -1;
                this.animateToStateProgress = 1.0f;
            }
            this.invite = tLRPC$TL_chatInviteExported;
            this.position = i;
            if (tLRPC$TL_chatInviteExported == null) {
                return;
            }
            if (tLRPC$TL_chatInviteExported.link.startsWith("https://rubika.ir/+")) {
                this.titleView.setText(tLRPC$TL_chatInviteExported.link.substring(19));
            } else if (tLRPC$TL_chatInviteExported.link.startsWith("https://rubika.ir/joinchat/")) {
                this.titleView.setText(tLRPC$TL_chatInviteExported.link.substring(27));
            } else if (tLRPC$TL_chatInviteExported.link.startsWith("https://")) {
                this.titleView.setText(tLRPC$TL_chatInviteExported.link.substring(8));
            } else {
                this.titleView.setText(tLRPC$TL_chatInviteExported.link);
            }
            int i4 = tLRPC$TL_chatInviteExported.usage;
            if (i4 == 0 && tLRPC$TL_chatInviteExported.usage_limit == 0) {
                pluralString = LocaleController.getString("NoOneJoinedYet", R.string.NoOneJoinedYet);
            } else {
                int i5 = tLRPC$TL_chatInviteExported.usage_limit;
                if (i5 > 0 && i4 == 0 && !tLRPC$TL_chatInviteExported.expired && !tLRPC$TL_chatInviteExported.revoked) {
                    pluralString = LocaleController.formatPluralString("CanJoin", i5);
                } else if (i5 > 0 && tLRPC$TL_chatInviteExported.expired && tLRPC$TL_chatInviteExported.revoked) {
                    pluralString = LocaleController.formatPluralString("PeopleJoined", tLRPC$TL_chatInviteExported.usage) + ", " + LocaleController.formatPluralString("PeopleJoinedRemaining", tLRPC$TL_chatInviteExported.usage_limit - tLRPC$TL_chatInviteExported.usage);
                } else {
                    pluralString = LocaleController.formatPluralString("PeopleJoined", i4);
                }
            }
            if (tLRPC$TL_chatInviteExported.permanent && !tLRPC$TL_chatInviteExported.revoked) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(pluralString);
                DotDividerSpan dotDividerSpan = new DotDividerSpan();
                dotDividerSpan.setTopPadding(AndroidUtilities.dp(1.5f));
                spannableStringBuilder.append((CharSequence) "  .  ").setSpan(dotDividerSpan, spannableStringBuilder.length() - 3, spannableStringBuilder.length() - 2, 0);
                spannableStringBuilder.append((CharSequence) LocaleController.getString("Permanent", R.string.Permanent));
                this.subtitleView.setText(spannableStringBuilder);
                return;
            }
            if (tLRPC$TL_chatInviteExported.expired || tLRPC$TL_chatInviteExported.revoked) {
                if (tLRPC$TL_chatInviteExported.revoked && tLRPC$TL_chatInviteExported.usage == 0) {
                    pluralString = LocaleController.getString("NoOneJoined", R.string.NoOneJoined);
                }
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(pluralString);
                DotDividerSpan dotDividerSpan2 = new DotDividerSpan();
                dotDividerSpan2.setTopPadding(AndroidUtilities.dp(1.5f));
                spannableStringBuilder2.append((CharSequence) "  .  ").setSpan(dotDividerSpan2, spannableStringBuilder2.length() - 3, spannableStringBuilder2.length() - 2, 0);
                boolean z = tLRPC$TL_chatInviteExported.revoked;
                if (!z && (i3 = tLRPC$TL_chatInviteExported.usage_limit) > 0 && tLRPC$TL_chatInviteExported.usage >= i3) {
                    spannableStringBuilder2.append((CharSequence) LocaleController.getString("LinkLimitReached", R.string.LinkLimitReached));
                } else {
                    if (z) {
                        i2 = R.string.Revoked;
                        str = "Revoked";
                    } else {
                        i2 = R.string.Expired;
                        str = "Expired";
                    }
                    spannableStringBuilder2.append((CharSequence) LocaleController.getString(str, i2));
                }
                this.subtitleView.setText(spannableStringBuilder2);
                return;
            }
            if (tLRPC$TL_chatInviteExported.expire_date > 0) {
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(pluralString);
                DotDividerSpan dotDividerSpan3 = new DotDividerSpan();
                dotDividerSpan3.setTopPadding(AndroidUtilities.dp(1.5f));
                spannableStringBuilder3.append((CharSequence) "  .  ").setSpan(dotDividerSpan3, spannableStringBuilder3.length() - 3, spannableStringBuilder3.length() - 2, 0);
                long jCurrentTimeMillis = (tLRPC$TL_chatInviteExported.expire_date * 1000) - (System.currentTimeMillis() + (ManageLinksActivity.this.timeDif * 1000));
                if (jCurrentTimeMillis < 0) {
                    jCurrentTimeMillis = 0;
                }
                if (jCurrentTimeMillis > 86400000) {
                    spannableStringBuilder3.append((CharSequence) LocaleController.formatPluralString("DaysLeft", (int) (jCurrentTimeMillis / 86400000)));
                } else {
                    long j = jCurrentTimeMillis / 1000;
                    int i6 = (int) (j % 60);
                    long j2 = j / 60;
                    int i7 = (int) (j2 % 60);
                    int i8 = (int) (j2 / 60);
                    Locale locale = Locale.ENGLISH;
                    spannableStringBuilder3.append((CharSequence) String.format(locale, "%02d", Integer.valueOf(i8))).append((CharSequence) String.format(locale, ":%02d", Integer.valueOf(i7))).append((CharSequence) String.format(locale, ":%02d", Integer.valueOf(i6)));
                    this.timerRunning = true;
                }
                this.subtitleView.setText(spannableStringBuilder3);
                return;
            }
            this.subtitleView.setText(pluralString);
        }
    }

    public void deleteLink(final TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported) {
        TLRPC$TL_messages_deleteExportedChatInvite tLRPC$TL_messages_deleteExportedChatInvite = new TLRPC$TL_messages_deleteExportedChatInvite();
        tLRPC$TL_messages_deleteExportedChatInvite.link = tLRPC$TL_chatInviteExported.link;
        tLRPC$TL_messages_deleteExportedChatInvite.peer = getMessagesController().getInputPeer(-this.currentChatId);
        getConnectionsManager().sendRequest(tLRPC$TL_messages_deleteExportedChatInvite, new RequestDelegate() { // from class: org.rbmain.ui.ManageLinksActivity$$ExternalSyntheticLambda11
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$deleteLink$14(tLRPC$TL_chatInviteExported, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteLink$14(final TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ManageLinksActivity$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$deleteLink$13(tLRPC$TL_error, tLRPC$TL_chatInviteExported);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteLink$13(TLRPC$TL_error tLRPC$TL_error, TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported) {
        if (tLRPC$TL_error == null) {
            this.linkEditActivityCallback.onLinkRemoved(tLRPC$TL_chatInviteExported);
        }
    }

    public void editLink(TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported) {
        LinkEditActivity linkEditActivity = new LinkEditActivity(1, this.currentChatId);
        linkEditActivity.setCallback(this.linkEditActivityCallback);
        linkEditActivity.setInviteToEdit(tLRPC$TL_chatInviteExported);
        presentFragment(linkEditActivity);
    }

    public void revokeLink(final TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported) {
        TLRPC$TL_messages_editExportedChatInvite tLRPC$TL_messages_editExportedChatInvite = new TLRPC$TL_messages_editExportedChatInvite();
        tLRPC$TL_messages_editExportedChatInvite.link = tLRPC$TL_chatInviteExported.link;
        tLRPC$TL_messages_editExportedChatInvite.revoked = true;
        tLRPC$TL_messages_editExportedChatInvite.peer = getMessagesController().getInputPeer(-this.currentChatId);
        getConnectionsManager().sendRequest(tLRPC$TL_messages_editExportedChatInvite, new RequestDelegate() { // from class: org.rbmain.ui.ManageLinksActivity$$ExternalSyntheticLambda12
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$revokeLink$16(tLRPC$TL_chatInviteExported, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$revokeLink$16(final TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ManageLinksActivity$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$revokeLink$15(tLRPC$TL_error, tLObject, tLRPC$TL_chatInviteExported);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$revokeLink$15(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported) {
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

    /* renamed from: org.rbmain.ui.ManageLinksActivity$5, reason: invalid class name */
    class AnonymousClass5 implements LinkEditActivity.Callback {
        AnonymousClass5() {
        }

        @Override // org.rbmain.ui.LinkEditActivity.Callback
        public void onLinkCreated(final TLObject tLObject) {
            if (tLObject instanceof TLRPC$TL_chatInviteExported) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ManageLinksActivity$5$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onLinkCreated$0(tLObject);
                    }
                }, 200L);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onLinkCreated$0(TLObject tLObject) {
            DiffCallback diffCallbackSaveListState = ManageLinksActivity.this.saveListState();
            ManageLinksActivity.this.invites.add(0, (TLRPC$TL_chatInviteExported) tLObject);
            ManageLinksActivity.this.updateRecyclerViewAnimated(diffCallbackSaveListState);
            if (ManageLinksActivity.this.info != null) {
                ManageLinksActivity.this.info.invitesCount++;
                ManageLinksActivity.this.getMessagesStorage().saveChatLinksCount(ManageLinksActivity.this.currentChatId, ManageLinksActivity.this.info.invitesCount);
            }
        }

        @Override // org.rbmain.ui.LinkEditActivity.Callback
        public void onLinkEdited(TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported, TLObject tLObject) {
            if (tLObject instanceof TLRPC$TL_messages_exportedChatInvite) {
                TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported2 = (TLRPC$TL_chatInviteExported) ((TLRPC$TL_messages_exportedChatInvite) tLObject).invite;
                ManageLinksActivity.this.fixDate(tLRPC$TL_chatInviteExported2);
                for (int i = 0; i < ManageLinksActivity.this.invites.size(); i++) {
                    if (((TLRPC$TL_chatInviteExported) ManageLinksActivity.this.invites.get(i)).link.equals(tLRPC$TL_chatInviteExported.link)) {
                        if (tLRPC$TL_chatInviteExported2.revoked) {
                            DiffCallback diffCallbackSaveListState = ManageLinksActivity.this.saveListState();
                            ManageLinksActivity.this.invites.remove(i);
                            ManageLinksActivity.this.revokedInvites.add(0, tLRPC$TL_chatInviteExported2);
                            ManageLinksActivity.this.updateRecyclerViewAnimated(diffCallbackSaveListState);
                            return;
                        }
                        ManageLinksActivity.this.invites.set(i, tLRPC$TL_chatInviteExported2);
                        ManageLinksActivity.this.updateRows(true);
                        return;
                    }
                }
            }
        }

        @Override // org.rbmain.ui.LinkEditActivity.Callback
        public void onLinkRemoved(TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported) {
            for (int i = 0; i < ManageLinksActivity.this.revokedInvites.size(); i++) {
                if (((TLRPC$TL_chatInviteExported) ManageLinksActivity.this.revokedInvites.get(i)).link.equals(tLRPC$TL_chatInviteExported.link)) {
                    DiffCallback diffCallbackSaveListState = ManageLinksActivity.this.saveListState();
                    ManageLinksActivity.this.revokedInvites.remove(i);
                    ManageLinksActivity.this.updateRecyclerViewAnimated(diffCallbackSaveListState);
                    return;
                }
            }
        }

        @Override // org.rbmain.ui.LinkEditActivity.Callback
        public void revokeLink(TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported) {
            ManageLinksActivity.this.revokeLink(tLRPC$TL_chatInviteExported);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRecyclerViewAnimated(DiffCallback diffCallback) {
        if (this.isPaused || this.listViewAdapter == null || this.listView == null) {
            updateRows(true);
            return;
        }
        updateRows(false);
        diffCallback.fillPositions(diffCallback.newPositionToItem);
        DiffUtil.calculateDiff(diffCallback).dispatchUpdatesTo(this.listViewAdapter);
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
        public boolean areItemsTheSame(int i, int i2) {
            TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported;
            if (((i >= this.oldLinksStartRow && i < this.oldLinksEndRow) || (i >= this.oldRevokedLinksStartRow && i < this.oldRevokedLinksEndRow)) && ((i2 >= ManageLinksActivity.this.linksStartRow && i2 < ManageLinksActivity.this.linksEndRow) || (i2 >= ManageLinksActivity.this.revokedLinksStartRow && i2 < ManageLinksActivity.this.revokedLinksEndRow))) {
                TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported2 = (i2 < ManageLinksActivity.this.linksStartRow || i2 >= ManageLinksActivity.this.linksEndRow) ? (TLRPC$TL_chatInviteExported) ManageLinksActivity.this.revokedInvites.get(i2 - ManageLinksActivity.this.revokedLinksStartRow) : (TLRPC$TL_chatInviteExported) ManageLinksActivity.this.invites.get(i2 - ManageLinksActivity.this.linksStartRow);
                int i3 = this.oldLinksStartRow;
                if (i >= i3 && i < this.oldLinksEndRow) {
                    tLRPC$TL_chatInviteExported = this.oldLinks.get(i - i3);
                } else {
                    tLRPC$TL_chatInviteExported = this.oldRevokedLinks.get(i - this.oldRevokedLinksStartRow);
                }
                return tLRPC$TL_chatInviteExported.link.equals(tLRPC$TL_chatInviteExported2.link);
            }
            if (i >= this.oldAdminsStartRow && i < this.oldAdminsEndRow && i2 >= ManageLinksActivity.this.adminsStartRow && i2 < ManageLinksActivity.this.adminsEndRow) {
                return i - this.oldAdminsStartRow == i2 - ManageLinksActivity.this.adminsStartRow;
            }
            int i4 = this.oldPositionToItem.get(i, -1);
            return i4 >= 0 && i4 == this.newPositionToItem.get(i2, -1);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areContentsTheSame(int i, int i2) {
            return areItemsTheSame(i, i2);
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

        private void put(int i, int i2, SparseIntArray sparseIntArray) {
            if (i2 >= 0) {
                sparseIntArray.put(i2, i);
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

    public void fixDate(TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported) {
        if (tLRPC$TL_chatInviteExported.expire_date > 0) {
            tLRPC$TL_chatInviteExported.expired = getConnectionsManager().getCurrentTime() >= tLRPC$TL_chatInviteExported.expire_date;
            return;
        }
        int i = tLRPC$TL_chatInviteExported.usage_limit;
        if (i > 0) {
            tLRPC$TL_chatInviteExported.expired = tLRPC$TL_chatInviteExported.usage >= i;
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: org.rbmain.ui.ManageLinksActivity$$ExternalSyntheticLambda15
            @Override // org.rbmain.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() {
                this.f$0.lambda$getThemeDescriptions$17();
            }
        };
        int i = Theme.key_windowBackgroundWhite;
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{HeaderCell.class, TextCell.class, LinkActionView.class, LinkCell.class}, null, null, null, i));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND | ThemeDescription.FLAG_CHECKTAG, null, null, null, null, Theme.key_windowBackgroundGray));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND | ThemeDescription.FLAG_CHECKTAG, null, null, null, null, i));
        ActionBar actionBar = this.actionBar;
        int i2 = ThemeDescription.FLAG_BACKGROUND;
        int i3 = Theme.key_actionBarDefault;
        arrayList.add(new ThemeDescription(actionBar, i2, null, null, null, null, i3));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, i3));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, Theme.key_actionBarDefaultIcon));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, Theme.key_actionBarDefaultTitle));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, Theme.key_actionBarDefaultSelector));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, Theme.key_listSelector));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, Theme.key_divider));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, Theme.key_windowBackgroundGrayShadow));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteGrayText4));
        int i4 = Theme.key_windowBackgroundWhiteBlackText;
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{ManageChatUserCell.class}, new String[]{"nameTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i4));
        int i5 = Theme.key_windowBackgroundWhiteGrayText;
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{ManageChatUserCell.class}, new String[]{"statusColor"}, (Paint[]) null, (Drawable[]) null, themeDescriptionDelegate, i5));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{ManageChatUserCell.class}, new String[]{"statusOnlineColor"}, (Paint[]) null, (Drawable[]) null, themeDescriptionDelegate, Theme.key_windowBackgroundWhiteBlueText));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{ManageChatUserCell.class}, null, Theme.avatarDrawables, null, Theme.key_avatar_text));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundRed));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundOrange));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundViolet));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundGreen));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundCyan));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundBlue));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundPink));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{HintInnerCell.class}, new String[]{"messageTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_chats_message));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{ManageChatTextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i4));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{ManageChatTextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_chats_unreadCounterMuted));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{ManageChatTextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteBlueButton));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{ManageChatTextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteBlueIcon));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteBlueText2));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_switchTrackChecked));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_checkboxCheck));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteBlueHeader));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{LinkCell.class}, new String[]{"titleView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i4));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{LinkCell.class}, new String[]{"subtitleView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i5));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_IMAGECOLOR, new Class[]{LinkCell.class}, new String[]{"optionsView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_stickers_menu));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getThemeDescriptions$17() {
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

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    protected void onTransitionAnimationEnd(boolean z, boolean z2) {
        super.onTransitionAnimationEnd(z, z2);
        if (z) {
            this.isOpened = true;
        }
        NotificationCenter.getInstance(this.currentAccount).onAnimationFinish(this.animationIndex);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    protected void onTransitionAnimationStart(boolean z, boolean z2) {
        super.onTransitionAnimationStart(z, z2);
        this.animationIndex = NotificationCenter.getInstance(this.currentAccount).setAnimationInProgress(this.animationIndex, null);
    }
}
