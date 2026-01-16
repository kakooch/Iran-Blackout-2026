package org.rbmain.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.Property;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidMessenger.proxy.DialogsProxy;
import androidMessenger.proxy.IdStorage;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.aaap.messengercore.model.Chat;
import ir.medu.shad.R;
import java.util.ArrayList;
import java.util.HashSet;
import org.rbmain.messenger.AccountInstance;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ChatObject;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.ImageLocation;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.MessagesStorage;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$ChannelLocation;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$ChatFull;
import org.rbmain.tgnet.TLRPC$ChatPhoto;
import org.rbmain.tgnet.TLRPC$ChatReactions;
import org.rbmain.tgnet.TLRPC$FileLocation;
import org.rbmain.tgnet.TLRPC$InputFile;
import org.rbmain.tgnet.TLRPC$MessageMedia;
import org.rbmain.tgnet.TLRPC$PhotoSize;
import org.rbmain.tgnet.TLRPC$Reaction;
import org.rbmain.tgnet.TLRPC$TL_availableReaction;
import org.rbmain.tgnet.TLRPC$TL_channelLocation;
import org.rbmain.tgnet.TLRPC$TL_chatBannedRights;
import org.rbmain.tgnet.TLRPC$TL_chatReactionsNone;
import org.rbmain.tgnet.TLRPC$TL_chatReactionsSome;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_messages_exportedChatInvites;
import org.rbmain.tgnet.TLRPC$TL_messages_getExportedChatInvites;
import org.rbmain.tgnet.TLRPC$TL_reactionEmoji;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.BottomSheet;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.Cells.HeaderCell;
import org.rbmain.ui.Cells.RadioButtonCell;
import org.rbmain.ui.Cells.ShadowSectionCell;
import org.rbmain.ui.Cells.TextCell;
import org.rbmain.ui.Cells.TextCheckCell;
import org.rbmain.ui.Cells.TextDetailCell;
import org.rbmain.ui.Cells.TextInfoPrivacyCell;
import org.rbmain.ui.Cells.TextSettingsCell;
import org.rbmain.ui.ChatEditActivity;
import org.rbmain.ui.Components.AlertsCreator;
import org.rbmain.ui.Components.AvatarDrawable;
import org.rbmain.ui.Components.BackupImageView;
import org.rbmain.ui.Components.EditTextBoldCursor;
import org.rbmain.ui.Components.EditTextEmoji;
import org.rbmain.ui.Components.ImageUpdater;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RadialProgressView;
import org.rbmain.ui.Components.UndoView;
import org.rbmain.ui.LocationActivity;
import org.rbmain.ui.PhotoViewer;

/* loaded from: classes4.dex */
public class ChatEditActivity extends BaseFragment implements ImageUpdater.ImageUpdaterDelegate, NotificationCenter.NotificationCenterDelegate {
    private TextCell acceptOwnerCell;
    private TextCell adminCell;
    private TLRPC$ChatReactions availableReactions;
    private TLRPC$FileLocation avatar;
    private AnimatorSet avatarAnimation;
    private LinearLayout avatarContainer;
    private AvatarDrawable avatarDrawable;
    private BackupImageView avatarImage;
    private View avatarOverlay;
    private RadialProgressView avatarProgressView;
    private TextCell blockCell;
    private int chatId;
    private boolean createAfterUpload;
    private TLRPC$Chat currentChat;
    private TextSettingsCell deleteCell;
    private FrameLayout deleteContainer;
    private ShadowSectionCell deleteInfoCell;
    private EditTextBoldCursor descriptionTextView;
    private View doneButton;
    private boolean donePressed;
    private TextCheckCell eventCell;
    private boolean eventMessages;
    private TextDetailCell historyCell;
    private boolean historyHidden;
    private ImageUpdater imageUpdater;
    private TLRPC$ChatFull info;
    private LinearLayout infoContainer;
    private ShadowSectionCell infoSectionCell;
    private TextCell inviteLinksCell;
    private boolean isChannel;
    private TextDetailCell linkedCell;
    private TextDetailCell locationCell;
    private TextCell logCell;
    private TextCell membersCell;
    private EditTextEmoji nameTextView;
    private TextCell permissionsCell;
    private AlertDialog progressDialog;
    private PhotoViewer.PhotoViewerProvider provider;
    private TextCell reactionsCell;
    private TextCell setAvatarCell;
    private LinearLayout settingsContainer;
    private ShadowSectionCell settingsSectionCell;
    private ShadowSectionCell settingsTopSectionCell;
    private TextCheckCell signCell;
    private boolean signMessages;
    private TextSettingsCell stickersCell;
    private FrameLayout stickersContainer;
    private TextInfoPrivacyCell stickersInfoCell3;
    private TextDetailCell typeCell;
    private LinearLayout typeEditContainer;
    private UndoView undoView;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$createView$2(View view, MotionEvent motionEvent) {
        return true;
    }

    public ChatEditActivity(Bundle bundle) {
        super(bundle);
        this.provider = new PhotoViewer.EmptyPhotoViewerProvider() { // from class: org.rbmain.ui.ChatEditActivity.1
            @Override // org.rbmain.ui.PhotoViewer.EmptyPhotoViewerProvider, org.rbmain.ui.PhotoViewer.PhotoViewerProvider
            public PhotoViewer.PlaceProviderObject getPlaceForPhoto(MessageObject messageObject, TLRPC$FileLocation tLRPC$FileLocation, int i, boolean z) {
                TLRPC$FileLocation tLRPC$FileLocation2;
                TLRPC$ChatPhoto tLRPC$ChatPhoto;
                if (tLRPC$FileLocation == null) {
                    return null;
                }
                TLRPC$Chat chat = ChatEditActivity.this.getMessagesController().getChat(Integer.valueOf(ChatEditActivity.this.chatId));
                if (chat == null || (tLRPC$ChatPhoto = chat.photo) == null || (tLRPC$FileLocation2 = tLRPC$ChatPhoto.photo_big) == null) {
                    tLRPC$FileLocation2 = null;
                }
                if (tLRPC$FileLocation2 == null || tLRPC$FileLocation2.local_id != tLRPC$FileLocation.local_id || tLRPC$FileLocation2.volume_id != tLRPC$FileLocation.volume_id || tLRPC$FileLocation2.dc_id != tLRPC$FileLocation.dc_id) {
                    return null;
                }
                int[] iArr = new int[2];
                ChatEditActivity.this.avatarImage.getLocationInWindow(iArr);
                PhotoViewer.PlaceProviderObject placeProviderObject = new PhotoViewer.PlaceProviderObject();
                placeProviderObject.viewX = iArr[0];
                placeProviderObject.viewY = iArr[1] - (Build.VERSION.SDK_INT < 21 ? AndroidUtilities.statusBarHeight : 0);
                placeProviderObject.parentView = ChatEditActivity.this.avatarImage;
                placeProviderObject.imageReceiver = ChatEditActivity.this.avatarImage.getImageReceiver();
                placeProviderObject.dialogId = -ChatEditActivity.this.chatId;
                placeProviderObject.thumb = placeProviderObject.imageReceiver.getBitmapSafe();
                placeProviderObject.size = -1;
                placeProviderObject.radius = ChatEditActivity.this.avatarImage.getImageReceiver().getRoundRadius();
                placeProviderObject.scale = ChatEditActivity.this.avatarContainer.getScaleX();
                placeProviderObject.canEdit = true;
                return placeProviderObject;
            }

            @Override // org.rbmain.ui.PhotoViewer.EmptyPhotoViewerProvider, org.rbmain.ui.PhotoViewer.PhotoViewerProvider
            public void willHidePhotoViewer() {
                ChatEditActivity.this.avatarImage.getImageReceiver().setVisible(true, true);
            }

            @Override // org.rbmain.ui.PhotoViewer.EmptyPhotoViewerProvider, org.rbmain.ui.PhotoViewer.PhotoViewerProvider
            public void openPhotoForEdit(String str, String str2, boolean z) throws IllegalAccessException, NoSuchFieldException, Resources.NotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException {
                ChatEditActivity.this.imageUpdater.openPhotoForEdit(str, str2, 0, z);
            }
        };
        this.fragmentName = "ChatEditActivity";
        this.avatarDrawable = new AvatarDrawable();
        this.imageUpdater = new ImageUpdater(false);
        this.chatId = bundle.getInt("chat_id", 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0050, code lost:
    
        if (r0 == null) goto L10;
     */
    @Override // org.rbmain.ui.ActionBar.BaseFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onFragmentCreate() {
        /*
            r9 = this;
            int r0 = r9.currentAccount
            org.rbmain.messenger.MessagesController r0 = org.rbmain.messenger.MessagesController.getInstance(r0)
            int r1 = r9.chatId
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            org.rbmain.tgnet.TLRPC$Chat r0 = r0.getChat(r1)
            r9.currentChat = r0
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L53
            int r0 = r9.currentAccount
            org.rbmain.messenger.MessagesStorage r0 = org.rbmain.messenger.MessagesStorage.getInstance(r0)
            int r3 = r9.chatId
            org.rbmain.tgnet.TLRPC$Chat r0 = r0.getChatSync(r3)
            r9.currentChat = r0
            if (r0 == 0) goto L52
            int r0 = r9.currentAccount
            org.rbmain.messenger.MessagesController r0 = org.rbmain.messenger.MessagesController.getInstance(r0)
            org.rbmain.tgnet.TLRPC$Chat r3 = r9.currentChat
            r0.putChat(r3, r1)
            org.rbmain.tgnet.TLRPC$ChatFull r0 = r9.info
            if (r0 != 0) goto L53
            int r0 = r9.currentAccount
            org.rbmain.messenger.MessagesStorage r3 = org.rbmain.messenger.MessagesStorage.getInstance(r0)
            int r4 = r9.chatId
            org.rbmain.tgnet.TLRPC$Chat r0 = r9.currentChat
            boolean r5 = org.rbmain.messenger.ChatObject.isChannel(r0)
            java.util.concurrent.CountDownLatch r6 = new java.util.concurrent.CountDownLatch
            r6.<init>(r1)
            r7 = 0
            r8 = 0
            org.rbmain.tgnet.TLRPC$ChatFull r0 = r3.loadChatInfo(r4, r5, r6, r7, r8)
            r9.info = r0
            if (r0 != 0) goto L53
        L52:
            return r2
        L53:
            org.rbmain.ui.Components.AvatarDrawable r0 = r9.avatarDrawable
            r3 = 5
            org.rbmain.tgnet.TLRPC$Chat r5 = r9.currentChat
            java.lang.String r5 = r5.title
            r6 = 0
            r0.setInfo(r3, r5, r6)
            org.rbmain.tgnet.TLRPC$Chat r0 = r9.currentChat
            boolean r0 = org.rbmain.messenger.ChatObject.isChannel(r0)
            if (r0 == 0) goto L6e
            org.rbmain.tgnet.TLRPC$Chat r0 = r9.currentChat
            boolean r0 = r0.megagroup
            if (r0 != 0) goto L6e
            goto L6f
        L6e:
            r1 = 0
        L6f:
            r9.isChannel = r1
            org.rbmain.ui.Components.ImageUpdater r0 = r9.imageUpdater
            r0.parentFragment = r9
            r0.setDelegate(r9)
            org.rbmain.tgnet.TLRPC$Chat r0 = r9.currentChat
            boolean r0 = r0.signatures
            r9.signMessages = r0
            int r0 = r9.currentAccount
            org.rbmain.messenger.NotificationCenter r0 = org.rbmain.messenger.NotificationCenter.getInstance(r0)
            int r1 = org.rbmain.messenger.NotificationCenter.chatInfoDidLoad
            r0.addObserver(r9, r1)
            int r0 = r9.currentAccount
            org.rbmain.messenger.NotificationCenter r0 = org.rbmain.messenger.NotificationCenter.getInstance(r0)
            int r1 = org.rbmain.messenger.NotificationCenter.updateInterfaces
            r0.addObserver(r9, r1)
            int r0 = r9.currentAccount
            org.rbmain.messenger.NotificationCenter r0 = org.rbmain.messenger.NotificationCenter.getInstance(r0)
            int r1 = org.rbmain.messenger.NotificationCenter.chatAvailableReactionsUpdated
            r0.addObserver(r9, r1)
            org.rbmain.tgnet.TLRPC$ChatFull r0 = r9.info
            if (r0 == 0) goto La6
            r9.loadLinksCount()
        La6:
            boolean r0 = super.onFragmentCreate()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.ChatEditActivity.onFragmentCreate():boolean");
    }

    private void loadLinksCount() {
        TLRPC$TL_messages_getExportedChatInvites tLRPC$TL_messages_getExportedChatInvites = new TLRPC$TL_messages_getExportedChatInvites();
        tLRPC$TL_messages_getExportedChatInvites.peer = getMessagesController().getInputPeer(-this.chatId);
        tLRPC$TL_messages_getExportedChatInvites.admin_id = getMessagesController().getInputUser(getUserConfig().getCurrentUser());
        tLRPC$TL_messages_getExportedChatInvites.limit = 0;
        getConnectionsManager().sendRequest(tLRPC$TL_messages_getExportedChatInvites, new RequestDelegate() { // from class: org.rbmain.ui.ChatEditActivity$$ExternalSyntheticLambda29
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadLinksCount$1(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadLinksCount$1(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ChatEditActivity$$ExternalSyntheticLambda26
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadLinksCount$0(tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadLinksCount$0(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
        if (tLRPC$TL_error == null) {
            this.info.invitesCount = ((TLRPC$TL_messages_exportedChatInvites) tLObject).count;
            getMessagesStorage().saveChatLinksCount(this.chatId, this.info.invitesCount);
            updateFields(false, false);
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
        ImageUpdater imageUpdater = this.imageUpdater;
        if (imageUpdater != null) {
            imageUpdater.clear();
        }
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.chatInfoDidLoad);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.updateInterfaces);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.chatAvailableReactionsUpdated);
        EditTextEmoji editTextEmoji = this.nameTextView;
        if (editTextEmoji != null) {
            editTextEmoji.onDestroy();
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        EditTextEmoji editTextEmoji = this.nameTextView;
        if (editTextEmoji != null) {
            editTextEmoji.onResume();
            this.nameTextView.getEditText().requestFocus();
        }
        AndroidUtilities.requestAdjustResize(getParentActivity(), this.classGuid);
        updateFields(true, true);
        this.imageUpdater.onResume();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
        EditTextEmoji editTextEmoji = this.nameTextView;
        if (editTextEmoji != null) {
            editTextEmoji.onPause();
        }
        UndoView undoView = this.undoView;
        if (undoView != null) {
            undoView.hide(true, 0);
        }
        this.imageUpdater.onPause();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    protected void onBecomeFullyHidden() {
        UndoView undoView = this.undoView;
        if (undoView != null) {
            undoView.hide(true, 0);
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void dismissCurrentDialog() {
        if (this.imageUpdater.dismissCurrentDialog(this.visibleDialog)) {
            return;
        }
        super.dismissCurrentDialog();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean dismissDialogOnPause(Dialog dialog) {
        return this.imageUpdater.dismissDialogOnPause(dialog) && super.dismissDialogOnPause(dialog);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onRequestPermissionsResultFragment(int i, String[] strArr, int[] iArr) {
        this.imageUpdater.onRequestPermissionsResultFragment(i, strArr, iArr);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onBackPressed() {
        EditTextEmoji editTextEmoji = this.nameTextView;
        if (editTextEmoji != null && editTextEmoji.isPopupShowing()) {
            this.nameTextView.hidePopup(true);
            return false;
        }
        return checkDiscard();
    }

    /* JADX WARN: Removed duplicated region for block: B:155:0x059f  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x05dd  */
    @Override // org.rbmain.ui.ActionBar.BaseFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View createView(final android.content.Context r24) {
        /*
            Method dump skipped, instructions count: 2253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.ChatEditActivity.createView(android.content.Context):android.view.View");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$createView$3(android.view.View r4) {
        /*
            r3 = this;
            org.rbmain.ui.Components.ImageUpdater r4 = r3.imageUpdater
            boolean r4 = r4.isUploadingImage()
            if (r4 == 0) goto L9
            return
        L9:
            org.rbmain.messenger.MessagesController r4 = r3.getMessagesController()
            int r0 = r3.chatId
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            org.rbmain.tgnet.TLRPC$Chat r4 = r4.getChat(r0)
            org.rbmain.tgnet.TLRPC$ChatPhoto r0 = r4.photo
            if (r0 == 0) goto L6a
            org.rbmain.tgnet.TLRPC$FileLocation r0 = r0.photo_big
            if (r0 == 0) goto L6a
            org.rbmain.ui.PhotoViewer r0 = org.rbmain.ui.PhotoViewer.getInstance()
            android.app.Activity r1 = r3.getParentActivity()
            r0.setParentActivity(r1)
            org.rbmain.tgnet.TLRPC$ChatPhoto r0 = r4.photo
            int r1 = r0.dc_id
            if (r1 == 0) goto L34
            org.rbmain.tgnet.TLRPC$FileLocation r0 = r0.photo_big
            r0.dc_id = r1
        L34:
            org.rbmain.tgnet.TLRPC$ChatFull r0 = r3.info
            if (r0 == 0) goto L5c
            org.rbmain.tgnet.TLRPC$Photo r0 = r0.chat_photo
            boolean r1 = r0 instanceof org.rbmain.tgnet.TLRPC$TL_photo
            if (r1 == 0) goto L5c
            java.util.ArrayList<org.rbmain.tgnet.TLRPC$VideoSize> r0 = r0.video_sizes
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L5c
            org.rbmain.tgnet.TLRPC$ChatFull r0 = r3.info
            org.rbmain.tgnet.TLRPC$Photo r0 = r0.chat_photo
            java.util.ArrayList<org.rbmain.tgnet.TLRPC$VideoSize> r0 = r0.video_sizes
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            org.rbmain.tgnet.TLRPC$VideoSize r0 = (org.rbmain.tgnet.TLRPC$VideoSize) r0
            org.rbmain.tgnet.TLRPC$ChatFull r1 = r3.info
            org.rbmain.tgnet.TLRPC$Photo r1 = r1.chat_photo
            org.rbmain.messenger.ImageLocation r0 = org.rbmain.messenger.ImageLocation.getForPhoto(r0, r1)
            goto L5d
        L5c:
            r0 = 0
        L5d:
            org.rbmain.ui.PhotoViewer r1 = org.rbmain.ui.PhotoViewer.getInstance()
            org.rbmain.tgnet.TLRPC$ChatPhoto r4 = r4.photo
            org.rbmain.tgnet.TLRPC$FileLocation r4 = r4.photo_big
            org.rbmain.ui.PhotoViewer$PhotoViewerProvider r2 = r3.provider
            r1.openPhotoWithVideo(r4, r0, r2)
        L6a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.ChatEditActivity.lambda$createView$3(android.view.View):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$5(View view) {
        this.imageUpdater.openMenu(this.avatar != null, new Runnable() { // from class: org.rbmain.ui.ChatEditActivity$$ExternalSyntheticLambda23
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createView$4();
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$4() {
        this.avatar = null;
        MessagesController.getInstance(this.currentAccount).changeChatAvatar(this.chatId, null, null, null, null, 0.0d, null, null, null, null);
        showAvatarProgress(false, true);
        this.avatarImage.setImage((ImageLocation) null, (String) null, this.avatarDrawable, this.currentChat);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$createView$6(TextView textView, int i, KeyEvent keyEvent) {
        View view;
        if (i != 6 || (view = this.doneButton) == null) {
            return false;
        }
        view.performClick();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$8(View view) {
        if (AndroidUtilities.isGoogleMapsInstalled(this)) {
            LocationActivity locationActivity = new LocationActivity(4);
            locationActivity.setDialogId(-this.chatId);
            TLRPC$ChatFull tLRPC$ChatFull = this.info;
            if (tLRPC$ChatFull != null) {
                TLRPC$ChannelLocation tLRPC$ChannelLocation = tLRPC$ChatFull.location;
                if (tLRPC$ChannelLocation instanceof TLRPC$TL_channelLocation) {
                    locationActivity.setInitialLocation((TLRPC$TL_channelLocation) tLRPC$ChannelLocation);
                }
            }
            locationActivity.setDelegate(new LocationActivity.LocationActivityDelegate() { // from class: org.rbmain.ui.ChatEditActivity$$ExternalSyntheticLambda32
                @Override // org.rbmain.ui.LocationActivity.LocationActivityDelegate
                public final void didSelectLocation(TLRPC$MessageMedia tLRPC$MessageMedia, int i, boolean z, int i2) {
                    this.f$0.lambda$createView$7(tLRPC$MessageMedia, i, z, i2);
                }
            });
            presentFragment(locationActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$7(TLRPC$MessageMedia tLRPC$MessageMedia, int i, boolean z, int i2) {
        TLRPC$TL_channelLocation tLRPC$TL_channelLocation = new TLRPC$TL_channelLocation();
        tLRPC$TL_channelLocation.address = tLRPC$MessageMedia.address;
        tLRPC$TL_channelLocation.geo_point = tLRPC$MessageMedia.geo;
        TLRPC$ChatFull tLRPC$ChatFull = this.info;
        tLRPC$ChatFull.location = tLRPC$TL_channelLocation;
        tLRPC$ChatFull.flags |= 32768;
        updateFields(false, true);
        getMessagesController().loadFullChat(this.chatId, 0, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$9(View view) {
        ChatEditTypeActivity chatEditTypeActivity = new ChatEditTypeActivity(this.chatId, false, (this.isChannel && getDialogsProxy().canSetType((long) (-this.chatId))) ? false : true);
        chatEditTypeActivity.setInfo(this.info);
        presentFragment(chatEditTypeActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$12(Context context, View view) {
        final BottomSheet.Builder builder = new BottomSheet.Builder(context);
        builder.setApplyTopPadding(false);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        HeaderCell headerCell = new HeaderCell(context, Theme.key_dialogTextBlue2, 23, 15, false);
        headerCell.setHeight(47);
        headerCell.setText(LocaleController.getString("ChatHistory", R.string.ChatHistory));
        linearLayout.addView(headerCell);
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(1);
        linearLayout.addView(linearLayout2, LayoutHelper.createLinear(-1, -2));
        final RadioButtonCell[] radioButtonCellArr = new RadioButtonCell[2];
        for (int i = 0; i < 2; i++) {
            radioButtonCellArr[i] = new RadioButtonCell(context, true);
            radioButtonCellArr[i].setTag(Integer.valueOf(i));
            radioButtonCellArr[i].setBackgroundDrawable(Theme.getSelectorDrawable(false));
            if (i == 0) {
                radioButtonCellArr[i].setTextAndValue(LocaleController.getString("ChatHistoryVisible", R.string.ChatHistoryVisible), LocaleController.getString("ChatHistoryVisibleInfo", R.string.ChatHistoryVisibleInfo), true, !this.historyHidden);
            } else if (ChatObject.isChannel(this.currentChat)) {
                radioButtonCellArr[i].setTextAndValue(LocaleController.getString("ChatHistoryHidden", R.string.ChatHistoryHidden), LocaleController.getString("ChatHistoryHiddenInfo", R.string.ChatHistoryHiddenInfo), false, this.historyHidden);
            } else {
                radioButtonCellArr[i].setTextAndValue(LocaleController.getString("ChatHistoryHidden", R.string.ChatHistoryHidden), LocaleController.getString("ChatHistoryHiddenInfo2", R.string.ChatHistoryHiddenInfo2), false, this.historyHidden);
            }
            linearLayout2.addView(radioButtonCellArr[i], LayoutHelper.createLinear(-1, -2));
            radioButtonCellArr[i].setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.ChatEditActivity$$ExternalSyntheticLambda20
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$createView$11(radioButtonCellArr, builder, view2);
                }
            });
        }
        builder.setCustomView(linearLayout);
        showDialog(builder.create());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$11(RadioButtonCell[] radioButtonCellArr, BottomSheet.Builder builder, View view) {
        Integer num = (Integer) view.getTag();
        radioButtonCellArr[0].setChecked(num.intValue() == 0, true);
        radioButtonCellArr[1].setChecked(num.intValue() == 1, true);
        this.historyHidden = num.intValue() == 1;
        builder.getDismissRunnable().run();
        updateFields(true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$13(View view) {
        boolean z = !this.eventMessages;
        this.eventMessages = z;
        this.eventCell.setChecked(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$14(View view) {
        boolean z = !this.signMessages;
        this.signMessages = z;
        ((TextCheckCell) view).setChecked(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$15(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("chat_id", this.chatId);
        bundle.putInt("type", 0);
        ChatUsersActivity chatUsersActivity = new ChatUsersActivity(bundle);
        chatUsersActivity.setInfo(this.info);
        presentFragment(chatUsersActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$16(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("chat_id", this.chatId);
        bundle.putInt("type", 3);
        ChatUsersActivity chatUsersActivity = new ChatUsersActivity(bundle);
        chatUsersActivity.setInfo(this.info);
        presentFragment(chatUsersActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$17(View view) {
        ManageLinksActivity manageLinksActivity = new ManageLinksActivity(this.chatId, 0, 0);
        TLRPC$ChatFull tLRPC$ChatFull = this.info;
        manageLinksActivity.setInfo(tLRPC$ChatFull, tLRPC$ChatFull.exported_invite);
        presentFragment(manageLinksActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$18(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("chat_id", this.chatId);
        ChatReactionsEditActivity chatReactionsEditActivity = new ChatReactionsEditActivity(bundle);
        chatReactionsEditActivity.setInfo(this.info);
        presentFragment(chatReactionsEditActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$19(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("chat_id", this.chatId);
        bundle.putInt("type", 1);
        ChatUsersActivity chatUsersActivity = new ChatUsersActivity(bundle);
        chatUsersActivity.setInfo(this.info);
        presentFragment(chatUsersActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$20(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("chat_id", this.chatId);
        bundle.putInt("type", 2);
        ChatUsersActivity chatUsersActivity = new ChatUsersActivity(bundle);
        chatUsersActivity.setInfo(this.info);
        presentFragment(chatUsersActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$22(View view) {
        GroupStickersActivity groupStickersActivity = new GroupStickersActivity(this.currentChat.id);
        groupStickersActivity.setInfo(this.info);
        presentFragment(groupStickersActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$23(View view) {
        showAcceptOwnerDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$25(View view) {
        AlertsCreator.createClearOrDeleteDialogAlert((BaseFragment) this, false, true, false, this.currentChat, (TLRPC$User) null, false, true, new MessagesStorage.BooleanCallback() { // from class: org.rbmain.ui.ChatEditActivity$$ExternalSyntheticLambda27
            @Override // org.rbmain.messenger.MessagesStorage.BooleanCallback
            public final void run(boolean z) {
                this.f$0.lambda$createView$24(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$24(boolean z) {
        if (AndroidUtilities.isTablet()) {
            getNotificationCenter().postNotificationName(NotificationCenter.closeChats, Long.valueOf(-this.chatId));
        } else {
            getNotificationCenter().postNotificationName(NotificationCenter.closeChats, new Object[0]);
        }
        finishFragment();
        getNotificationCenter().postNotificationName(NotificationCenter.needDeleteDialog, Long.valueOf(-this.currentChat.id), null, this.currentChat, Boolean.valueOf(z));
    }

    private void showAcceptOwnerDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setTitle(AndroidUtilities.replaceTags(LocaleController.formatString("AcceptOwner", R.string.AcceptOwner, new Object[0])));
        if (this.isChannel) {
            builder.setMessage(LocaleController.getString("AreYouSureAcceptChannelOwner", R.string.AreYouSureAcceptChannelOwner));
        } else {
            builder.setMessage(LocaleController.getString("AreYouSureAcceptGroupOwner", R.string.AreYouSureAcceptGroupOwner));
        }
        builder.setPositiveButton(LocaleController.getString("Accept", R.string.Accept), new AnonymousClass9());
        builder.setNegativeButton(LocaleController.getString("Reject", R.string.Reject), new AnonymousClass10());
        showDialog(builder.create());
    }

    /* renamed from: org.rbmain.ui.ChatEditActivity$9, reason: invalid class name */
    class AnonymousClass9 implements DialogInterface.OnClickListener {
        AnonymousClass9() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            final AlertDialog alertDialog = new AlertDialog(ChatEditActivity.this.getParentActivity(), 1);
            alertDialog.setCanceledOnTouchOutside(false);
            alertDialog.setCancelable(false);
            AccountInstance.getInstance(((BaseFragment) ChatEditActivity.this).currentAccount).getDialogsProxy().acceptRequestObjectOwner(-ChatEditActivity.this.chatId, new RequestDelegate() { // from class: org.rbmain.ui.ChatEditActivity$9$$ExternalSyntheticLambda1
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    ChatEditActivity.AnonymousClass9.lambda$onClick$1(alertDialog, tLObject, tLRPC$TL_error);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onClick$1(final AlertDialog alertDialog, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ChatEditActivity$9$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ChatEditActivity.AnonymousClass9.lambda$onClick$0(alertDialog);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onClick$0(AlertDialog alertDialog) {
            try {
                alertDialog.dismiss();
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: org.rbmain.ui.ChatEditActivity$10, reason: invalid class name */
    class AnonymousClass10 implements DialogInterface.OnClickListener {
        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onClick$0() {
        }

        AnonymousClass10() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            AlertDialog alertDialog = new AlertDialog(ChatEditActivity.this.getParentActivity(), 1);
            alertDialog.setCanceledOnTouchOutside(false);
            alertDialog.setCancelable(false);
            AccountInstance.getInstance(((BaseFragment) ChatEditActivity.this).currentAccount).getDialogsProxy().rejectRequestObjectOwner(-ChatEditActivity.this.chatId, new RequestDelegate() { // from class: org.rbmain.ui.ChatEditActivity$10$$ExternalSyntheticLambda1
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    ChatEditActivity.AnonymousClass10.lambda$onClick$1(tLObject, tLRPC$TL_error);
                }
            });
            try {
                alertDialog.dismiss();
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onClick$1(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ChatEditActivity$10$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ChatEditActivity.AnonymousClass10.lambda$onClick$0();
                }
            });
        }
    }

    private void setAvatar() {
        TLRPC$Chat chat;
        if (this.avatarImage == null || (chat = MessagesController.getInstance(this.currentAccount).getChat(Integer.valueOf(this.chatId))) == null) {
            return;
        }
        this.currentChat = chat;
        TLRPC$ChatPhoto tLRPC$ChatPhoto = chat.photo;
        boolean z = false;
        if (tLRPC$ChatPhoto != null) {
            this.avatar = tLRPC$ChatPhoto.photo_small;
            ImageLocation forUserOrChat = ImageLocation.getForUserOrChat(chat, 1);
            this.avatarImage.setForUserOrChat(this.currentChat, this.avatarDrawable);
            if (forUserOrChat != null) {
                z = true;
            }
        } else {
            this.avatarImage.setImageDrawable(this.avatarDrawable);
        }
        if (this.setAvatarCell != null) {
            if (z || this.imageUpdater.isUploadingImage()) {
                this.setAvatarCell.setTextAndIcon(LocaleController.getString("ChatSetNewPhoto", R.string.ChatSetNewPhoto), R.drawable.menu_camera2, true);
            } else {
                this.setAvatarCell.setTextAndIcon(LocaleController.getString("ChatSetPhoto", R.string.ChatSetPhoto), R.drawable.menu_camera2, true);
            }
        }
        if (PhotoViewer.hasInstance() && PhotoViewer.getInstance().isVisible()) {
            PhotoViewer.getInstance().checkCurrentImageVisibility();
        }
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        int iIntValue;
        EditTextBoldCursor editTextBoldCursor;
        if (i == NotificationCenter.chatInfoDidLoad) {
            TLRPC$ChatFull tLRPC$ChatFull = (TLRPC$ChatFull) objArr[0];
            if (tLRPC$ChatFull.id == this.chatId) {
                if (this.info == null && (editTextBoldCursor = this.descriptionTextView) != null) {
                    editTextBoldCursor.setText(tLRPC$ChatFull.about);
                }
                boolean z = this.info == null;
                this.info = tLRPC$ChatFull;
                this.historyHidden = !ChatObject.isChannel(this.currentChat) || this.info.hidden_prehistory;
                this.eventMessages = !ChatObject.isChannel(this.currentChat) || this.info.event_messages;
                this.availableReactions = this.info.available_reactions;
                updateReactionsCell(true);
                updateFields(true, false);
                if (z) {
                    loadLinksCount();
                    return;
                }
                return;
            }
            return;
        }
        if (i == NotificationCenter.updateInterfaces) {
            if ((((Integer) objArr[0]).intValue() & 2) != 0) {
                setAvatar();
            }
        } else if (i == NotificationCenter.chatAvailableReactionsUpdated && (iIntValue = ((Integer) objArr[0]).intValue()) == this.chatId) {
            TLRPC$ChatFull chatFull = getMessagesController().getChatFull(iIntValue);
            this.info = chatFull;
            if (chatFull != null) {
                this.availableReactions = chatFull.available_reactions;
            }
            updateReactionsCell(true);
        }
    }

    @Override // org.rbmain.ui.Components.ImageUpdater.ImageUpdaterDelegate
    public void onUploadProgressChanged(float f) {
        RadialProgressView radialProgressView = this.avatarProgressView;
        if (radialProgressView == null) {
            return;
        }
        radialProgressView.setProgress(f);
    }

    @Override // org.rbmain.ui.Components.ImageUpdater.ImageUpdaterDelegate
    public void didStartUpload(boolean z) {
        RadialProgressView radialProgressView = this.avatarProgressView;
        if (radialProgressView == null) {
            return;
        }
        radialProgressView.setProgress(0.0f);
    }

    @Override // org.rbmain.ui.Components.ImageUpdater.ImageUpdaterDelegate
    public void didUploadPhoto(final TLRPC$InputFile tLRPC$InputFile, final TLRPC$InputFile tLRPC$InputFile2, final TLRPC$InputFile tLRPC$InputFile3, final double d, final String str, final TLRPC$PhotoSize tLRPC$PhotoSize, final TLRPC$PhotoSize tLRPC$PhotoSize2) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ChatEditActivity$$ExternalSyntheticLambda24
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$didUploadPhoto$26(tLRPC$PhotoSize2, tLRPC$InputFile, tLRPC$InputFile2, tLRPC$InputFile3, d, str, tLRPC$PhotoSize);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$didUploadPhoto$26(TLRPC$PhotoSize tLRPC$PhotoSize, TLRPC$InputFile tLRPC$InputFile, TLRPC$InputFile tLRPC$InputFile2, TLRPC$InputFile tLRPC$InputFile3, double d, String str, TLRPC$PhotoSize tLRPC$PhotoSize2) {
        TLRPC$FileLocation tLRPC$FileLocation = tLRPC$PhotoSize.location;
        this.avatar = tLRPC$FileLocation;
        if ((tLRPC$InputFile != null && tLRPC$InputFile2 != null) || tLRPC$InputFile3 != null) {
            MessagesController.getInstance(this.currentAccount).changeChatAvatar(this.chatId, null, tLRPC$InputFile, tLRPC$InputFile3, tLRPC$InputFile2, d, str, tLRPC$PhotoSize.location, tLRPC$PhotoSize2.location, null);
            if (this.createAfterUpload) {
                try {
                    AlertDialog alertDialog = this.progressDialog;
                    if (alertDialog != null && alertDialog.isShowing()) {
                        this.progressDialog.dismiss();
                        this.progressDialog = null;
                    }
                } catch (Exception e) {
                    FileLog.e(e);
                }
                this.donePressed = false;
                this.doneButton.performClick();
            }
            showAvatarProgress(false, true);
            return;
        }
        this.avatarImage.setImage(ImageLocation.getForLocal(tLRPC$FileLocation), "50_50", this.avatarDrawable, this.currentChat);
        this.setAvatarCell.setTextAndIcon(LocaleController.getString("ChatSetNewPhoto", R.string.ChatSetNewPhoto), R.drawable.menu_camera2, true);
        showAvatarProgress(true, false);
    }

    @Override // org.rbmain.ui.Components.ImageUpdater.ImageUpdaterDelegate
    public String getInitialSearchString() {
        return this.nameTextView.getText().toString();
    }

    public void showConvertTooltip() {
        this.undoView.showWithAction(0L, 76, (Runnable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkDiscard() {
        String str;
        EditTextEmoji editTextEmoji;
        String str2;
        EditTextBoldCursor editTextBoldCursor;
        TLRPC$ChatFull tLRPC$ChatFull = this.info;
        if (tLRPC$ChatFull == null || (str = tLRPC$ChatFull.about) == null) {
            str = BuildConfig.FLAVOR;
        }
        if ((tLRPC$ChatFull == null || !ChatObject.isChannel(this.currentChat) || this.info.hidden_prehistory == this.historyHidden) && (((editTextEmoji = this.nameTextView) == null || this.currentChat.title != null || editTextEmoji.getText().toString().length() <= 0) && (((str2 = this.currentChat.title) == null || str2.equals(this.nameTextView.getText().toString())) && (((editTextBoldCursor = this.descriptionTextView) == null || str.equals(editTextBoldCursor.getText().toString())) && this.signMessages == this.currentChat.signatures)))) {
            return true;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setTitle(LocaleController.getString("UserRestrictionsApplyChanges", R.string.UserRestrictionsApplyChanges));
        if (this.isChannel) {
            builder.setMessage(LocaleController.getString("ChannelSettingsChangedAlert", R.string.ChannelSettingsChangedAlert));
        } else {
            builder.setMessage(LocaleController.getString("GroupSettingsChangedAlert", R.string.GroupSettingsChangedAlert));
        }
        builder.setPositiveButton(LocaleController.getString("ApplyTheme", R.string.ApplyTheme), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.ChatEditActivity$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$checkDiscard$27(dialogInterface, i);
            }
        });
        builder.setNegativeButton(LocaleController.getString("PassportDiscard", R.string.PassportDiscard), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.ChatEditActivity$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$checkDiscard$28(dialogInterface, i);
            }
        });
        showDialog(builder.create());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkDiscard$27(DialogInterface dialogInterface, int i) {
        processDone();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkDiscard$28(DialogInterface dialogInterface, int i) {
        finishFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processDone() {
        EditTextEmoji editTextEmoji;
        String str;
        if (this.donePressed || (editTextEmoji = this.nameTextView) == null) {
            return;
        }
        if (editTextEmoji.length() == 0) {
            Vibrator vibrator = (Vibrator) getParentActivity().getSystemService("vibrator");
            if (vibrator != null) {
                vibrator.vibrate(200L);
            }
            AndroidUtilities.shakeView(this.nameTextView, 2.0f, 0);
            return;
        }
        this.donePressed = true;
        if (!ChatObject.isChannel(this.currentChat) && !this.historyHidden) {
            MessagesController.getInstance(this.currentAccount).convertToMegaGroup(getParentActivity(), this.chatId, this, new MessagesStorage.IntCallback() { // from class: org.rbmain.ui.ChatEditActivity$$ExternalSyntheticLambda28
                @Override // org.rbmain.messenger.MessagesStorage.IntCallback
                public final void run(int i) {
                    this.f$0.lambda$processDone$29(i);
                }
            });
            return;
        }
        if (this.info != null && ChatObject.isChannel(this.currentChat)) {
            TLRPC$ChatFull tLRPC$ChatFull = this.info;
            boolean z = tLRPC$ChatFull.hidden_prehistory;
            boolean z2 = this.historyHidden;
            if (z != z2) {
                tLRPC$ChatFull.hidden_prehistory = z2;
            }
        }
        if (this.imageUpdater.isUploadingImage()) {
            this.createAfterUpload = true;
            AlertDialog alertDialog = new AlertDialog(getParentActivity(), 3);
            this.progressDialog = alertDialog;
            alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: org.rbmain.ui.ChatEditActivity$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    this.f$0.lambda$processDone$30(dialogInterface);
                }
            });
            this.progressDialog.show();
            return;
        }
        this.currentChat.title.equals(this.nameTextView.getText().toString());
        TLRPC$ChatFull tLRPC$ChatFull2 = this.info;
        if (tLRPC$ChatFull2 == null || (str = tLRPC$ChatFull2.about) == null) {
            str = BuildConfig.FLAVOR;
        }
        EditTextBoldCursor editTextBoldCursor = this.descriptionTextView;
        if (editTextBoldCursor != null) {
            str.equals(editTextBoldCursor.getText().toString());
        }
        boolean z3 = this.signMessages;
        TLRPC$Chat tLRPC$Chat = this.currentChat;
        if (z3 != tLRPC$Chat.signatures) {
            tLRPC$Chat.signatures = true;
        }
        AlertDialog alertDialog2 = new AlertDialog(getParentActivity(), 3);
        this.progressDialog = alertDialog2;
        alertDialog2.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: org.rbmain.ui.ChatEditActivity$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                this.f$0.lambda$processDone$31(dialogInterface);
            }
        });
        this.progressDialog.show();
        DialogsProxy dialogsProxy = getDialogsProxy();
        int i = this.chatId;
        String string = this.nameTextView.getText().toString();
        EditTextBoldCursor editTextBoldCursor2 = this.descriptionTextView;
        dialogsProxy.changeChat(i, string, editTextBoldCursor2 != null ? editTextBoldCursor2.getText().toString() : null, this.historyHidden, this.signMessages, this.eventMessages, this.isChannel, new RequestDelegate() { // from class: org.rbmain.ui.ChatEditActivity$$ExternalSyntheticLambda30
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$processDone$33(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processDone$29(int i) {
        if (i == 0) {
            this.donePressed = false;
            return;
        }
        this.chatId = i;
        this.currentChat = MessagesController.getInstance(this.currentAccount).getChat(Integer.valueOf(i));
        this.donePressed = false;
        TLRPC$ChatFull tLRPC$ChatFull = this.info;
        if (tLRPC$ChatFull != null) {
            tLRPC$ChatFull.hidden_prehistory = true;
        }
        processDone();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processDone$30(DialogInterface dialogInterface) {
        this.createAfterUpload = false;
        this.progressDialog = null;
        this.donePressed = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processDone$31(DialogInterface dialogInterface) {
        this.progressDialog = null;
        this.donePressed = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processDone$33(TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ChatEditActivity$$ExternalSyntheticLambda25
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processDone$32(tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processDone$32(TLRPC$TL_error tLRPC$TL_error) {
        try {
            this.progressDialog.dismiss();
        } catch (Exception unused) {
        }
        this.progressDialog = null;
        this.donePressed = false;
        if (tLRPC$TL_error != null) {
            AlertsCreator.showSimpleAlert(this, LocaleController.getString("Failed", R.string.Failed));
            this.donePressed = false;
        } else {
            finishFragment();
        }
    }

    private void showAvatarProgress(final boolean z, boolean z2) {
        if (this.avatarProgressView == null) {
            return;
        }
        AnimatorSet animatorSet = this.avatarAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.avatarAnimation = null;
        }
        if (z2) {
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.avatarAnimation = animatorSet2;
            if (z) {
                this.avatarProgressView.setVisibility(0);
                this.avatarOverlay.setVisibility(0);
                this.avatarAnimation.playTogether(ObjectAnimator.ofFloat(this.avatarProgressView, (Property<RadialProgressView, Float>) View.ALPHA, 1.0f), ObjectAnimator.ofFloat(this.avatarOverlay, (Property<View, Float>) View.ALPHA, 1.0f));
            } else {
                animatorSet2.playTogether(ObjectAnimator.ofFloat(this.avatarProgressView, (Property<RadialProgressView, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.avatarOverlay, (Property<View, Float>) View.ALPHA, 0.0f));
            }
            this.avatarAnimation.setDuration(180L);
            this.avatarAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.ChatEditActivity.11
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (ChatEditActivity.this.avatarAnimation == null || ChatEditActivity.this.avatarProgressView == null) {
                        return;
                    }
                    if (!z) {
                        ChatEditActivity.this.avatarProgressView.setVisibility(4);
                        ChatEditActivity.this.avatarOverlay.setVisibility(4);
                    }
                    ChatEditActivity.this.avatarAnimation = null;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    ChatEditActivity.this.avatarAnimation = null;
                }
            });
            this.avatarAnimation.start();
            return;
        }
        if (z) {
            this.avatarProgressView.setAlpha(1.0f);
            this.avatarProgressView.setVisibility(0);
            this.avatarOverlay.setAlpha(1.0f);
            this.avatarOverlay.setVisibility(0);
            return;
        }
        this.avatarProgressView.setAlpha(0.0f);
        this.avatarProgressView.setVisibility(4);
        this.avatarOverlay.setAlpha(0.0f);
        this.avatarOverlay.setVisibility(4);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onActivityResultFragment(int i, int i2, Intent intent) throws IllegalAccessException, NoSuchFieldException, Resources.NotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException {
        this.imageUpdater.onActivityResult(i, i2, intent);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void saveSelfArgs(Bundle bundle) {
        String str;
        ImageUpdater imageUpdater = this.imageUpdater;
        if (imageUpdater != null && (str = imageUpdater.currentPicturePath) != null) {
            bundle.putString("path", str);
        }
        EditTextEmoji editTextEmoji = this.nameTextView;
        if (editTextEmoji != null) {
            String string = editTextEmoji.getText().toString();
            if (string.length() != 0) {
                bundle.putString("nameTextView", string);
            }
        }
    }

    public void setInfo(TLRPC$ChatFull tLRPC$ChatFull) {
        this.info = tLRPC$ChatFull;
        if (tLRPC$ChatFull != null) {
            if (this.currentChat == null) {
                this.currentChat = MessagesController.getInstance(this.currentAccount).getChat(Integer.valueOf(this.chatId));
            }
            this.historyHidden = !ChatObject.isChannel(this.currentChat) || this.info.hidden_prehistory;
            this.eventMessages = !ChatObject.isChannel(this.currentChat) || this.info.event_messages;
        }
    }

    private void updateFields(boolean z, boolean z2) {
        HashSet<Chat.ChatAccessEnum> hashSet;
        TLRPC$ChatFull tLRPC$ChatFull;
        int i;
        String str;
        int i2;
        String str2;
        String string;
        TextDetailCell textDetailCell;
        TextDetailCell textDetailCell2;
        int i3;
        String str3;
        String string2;
        TextDetailCell textDetailCell3;
        TLRPC$ChatFull tLRPC$ChatFull2;
        TextDetailCell textDetailCell4;
        TextDetailCell textDetailCell5;
        TextCheckCell textCheckCell;
        TextDetailCell textDetailCell6;
        TLRPC$Chat chat;
        if (z && (chat = MessagesController.getInstance(this.currentAccount).getChat(Integer.valueOf(this.chatId))) != null) {
            this.currentChat = chat;
        }
        boolean zIsChannelPrivate = getCoreMainClass().isChannelPrivate(IdStorage.getInstance().getDialogId(-this.currentChat.id));
        TextDetailCell textDetailCell7 = this.historyCell;
        if (textDetailCell7 != null) {
            TLRPC$ChatFull tLRPC$ChatFull3 = this.info;
            if (tLRPC$ChatFull3 != null && (tLRPC$ChatFull3.location instanceof TLRPC$TL_channelLocation)) {
                textDetailCell7.setVisibility(8);
            } else {
                textDetailCell7.setVisibility((zIsChannelPrivate && (tLRPC$ChatFull3 == null || tLRPC$ChatFull3.linked_chat_id == 0)) ? 0 : 8);
            }
        }
        ShadowSectionCell shadowSectionCell = this.settingsSectionCell;
        if (shadowSectionCell != null) {
            shadowSectionCell.setVisibility((this.signCell == null && this.typeCell == null && ((textDetailCell4 = this.linkedCell) == null || textDetailCell4.getVisibility() != 0) && (((textDetailCell5 = this.historyCell) == null || textDetailCell5.getVisibility() != 0) && (((textCheckCell = this.eventCell) == null || textCheckCell.getVisibility() != 0) && ((textDetailCell6 = this.locationCell) == null || textDetailCell6.getVisibility() != 0)))) ? 8 : 0);
        }
        TextCell textCell = this.logCell;
        if (textCell != null) {
            TLRPC$Chat tLRPC$Chat = this.currentChat;
            textCell.setVisibility((!tLRPC$Chat.megagroup || tLRPC$Chat.gigagroup || ((tLRPC$ChatFull2 = this.info) != null && tLRPC$ChatFull2.participants_count > 200)) ? 0 : 8);
        }
        TextDetailCell textDetailCell8 = this.linkedCell;
        if (textDetailCell8 != null) {
            TLRPC$ChatFull tLRPC$ChatFull4 = this.info;
            if (tLRPC$ChatFull4 == null || (!this.isChannel && tLRPC$ChatFull4.linked_chat_id == 0)) {
                textDetailCell8.setVisibility(8);
            } else {
                textDetailCell8.setVisibility(0);
                if (this.info.linked_chat_id == 0) {
                    this.linkedCell.setTextAndValue(LocaleController.getString("Discussion", R.string.Discussion), LocaleController.getString("DiscussionInfo", R.string.DiscussionInfo), true);
                } else {
                    TLRPC$Chat chat2 = getMessagesController().getChat(Integer.valueOf(this.info.linked_chat_id));
                    if (chat2 == null) {
                        this.linkedCell.setVisibility(8);
                    } else if (this.isChannel) {
                        if (TextUtils.isEmpty(chat2.username)) {
                            this.linkedCell.setTextAndValue(LocaleController.getString("Discussion", R.string.Discussion), chat2.title, true);
                        } else {
                            this.linkedCell.setTextAndValue(LocaleController.getString("Discussion", R.string.Discussion), "@" + chat2.username, true);
                        }
                    } else if (TextUtils.isEmpty(chat2.username)) {
                        this.linkedCell.setTextAndValue(LocaleController.getString("LinkedChannel", R.string.LinkedChannel), chat2.title, false);
                    } else {
                        this.linkedCell.setTextAndValue(LocaleController.getString("LinkedChannel", R.string.LinkedChannel), "@" + chat2.username, false);
                    }
                }
            }
        }
        TextDetailCell textDetailCell9 = this.locationCell;
        if (textDetailCell9 != null) {
            TLRPC$ChatFull tLRPC$ChatFull5 = this.info;
            if (tLRPC$ChatFull5 != null && tLRPC$ChatFull5.can_set_location) {
                textDetailCell9.setVisibility(0);
                TLRPC$ChannelLocation tLRPC$ChannelLocation = this.info.location;
                if (tLRPC$ChannelLocation instanceof TLRPC$TL_channelLocation) {
                    this.locationCell.setTextAndValue(LocaleController.getString("AttachLocation", R.string.AttachLocation), ((TLRPC$TL_channelLocation) tLRPC$ChannelLocation).address, true);
                } else {
                    this.locationCell.setTextAndValue(LocaleController.getString("AttachLocation", R.string.AttachLocation), "Unknown address", true);
                }
            } else {
                textDetailCell9.setVisibility(8);
            }
        }
        if (this.typeCell != null) {
            TLRPC$ChatFull tLRPC$ChatFull6 = this.info;
            if (tLRPC$ChatFull6 != null && (tLRPC$ChatFull6.location instanceof TLRPC$TL_channelLocation)) {
                if (zIsChannelPrivate) {
                    string2 = LocaleController.getString("TypeLocationGroupEdit", R.string.TypeLocationGroupEdit);
                } else {
                    string2 = String.format("https://" + MessagesController.getInstance(this.currentAccount).linkPrefix + "/%s", this.currentChat.username);
                }
                TextDetailCell textDetailCell10 = this.typeCell;
                String string3 = LocaleController.getString("TypeLocationGroup", R.string.TypeLocationGroup);
                TextCheckCell textCheckCell2 = this.eventCell;
                textDetailCell10.setTextAndValue(string3, string2, (textCheckCell2 != null && textCheckCell2.getVisibility() == 0) || ((textDetailCell3 = this.linkedCell) != null && textDetailCell3.getVisibility() == 0));
            } else {
                if (this.isChannel) {
                    if (zIsChannelPrivate) {
                        i3 = R.string.TypePrivate;
                        str3 = "TypePrivate";
                    } else {
                        i3 = R.string.TypePublic;
                        str3 = "TypePublic";
                    }
                    string = LocaleController.getString(str3, i3);
                } else {
                    if (zIsChannelPrivate) {
                        i2 = R.string.TypePrivateGroup;
                        str2 = "TypePrivateGroup";
                    } else {
                        i2 = R.string.TypePublicGroup;
                        str2 = "TypePublicGroup";
                    }
                    string = LocaleController.getString(str2, i2);
                }
                if (this.isChannel && getDialogsProxy().canSetType(-this.chatId)) {
                    TextDetailCell textDetailCell11 = this.typeCell;
                    String string4 = LocaleController.getString("ChannelType", R.string.ChannelType);
                    TextCheckCell textCheckCell3 = this.eventCell;
                    textDetailCell11.setTextAndValue(string4, string, (textCheckCell3 != null && textCheckCell3.getVisibility() == 0) || ((textDetailCell2 = this.linkedCell) != null && textDetailCell2.getVisibility() == 0));
                } else if (getDialogsProxy().canSetLink(-this.chatId)) {
                    TextDetailCell textDetailCell12 = this.typeCell;
                    String string5 = LocaleController.getString("ManageInviteLink", R.string.ManageInviteLink);
                    String string6 = LocaleController.getString("ChangeOrCreateLink", R.string.ChangeOrCreateLink);
                    TextCheckCell textCheckCell4 = this.eventCell;
                    textDetailCell12.setTextAndValue(string5, string6, (textCheckCell4 != null && textCheckCell4.getVisibility() == 0) || ((textDetailCell = this.linkedCell) != null && textDetailCell.getVisibility() == 0));
                }
            }
        }
        if (this.historyCell != null) {
            if (this.historyHidden) {
                i = R.string.ChatHistoryHidden;
                str = "ChatHistoryHidden";
            } else {
                i = R.string.ChatHistoryVisible;
                str = "ChatHistoryVisible";
            }
            this.historyCell.setTextAndValue(LocaleController.getString("ChatHistory", R.string.ChatHistory), LocaleController.getString(str, i), this.eventCell != null);
        }
        TextCheckCell textCheckCell5 = this.eventCell;
        if (textCheckCell5 != null) {
            textCheckCell5.setTextAndCheck(LocaleController.getString("GlassMessage", R.string.GlassMessage), this.eventMessages, false);
            this.eventCell.setChecked(this.eventMessages);
        }
        TextSettingsCell textSettingsCell = this.stickersCell;
        if (textSettingsCell != null) {
            TLRPC$ChatFull tLRPC$ChatFull7 = this.info;
            if (tLRPC$ChatFull7 != null && tLRPC$ChatFull7.stickerset != null) {
                textSettingsCell.setTextAndValue(LocaleController.getString("GroupStickers", R.string.GroupStickers), this.info.stickerset.title, false);
            } else {
                textSettingsCell.setText(LocaleController.getString("GroupStickers", R.string.GroupStickers), false);
            }
        }
        TextCell textCell2 = this.membersCell;
        if (textCell2 != null) {
            if (this.info != null) {
                if (this.isChannel) {
                    textCell2.setTextAndValueAndIcon(LocaleController.getString("ChannelSubscribers", R.string.ChannelSubscribers), BuildConfig.FLAVOR, R.drawable.actions_viewmembers, true);
                    this.blockCell.setTextAndValueAndIcon(LocaleController.getString("ChannelBlacklist", R.string.ChannelBlacklist), BuildConfig.FLAVOR, R.drawable.actions_removed, true);
                } else {
                    if (ChatObject.isChannel(this.currentChat)) {
                        TextCell textCell3 = this.membersCell;
                        String string7 = LocaleController.getString("ChannelMembers", R.string.ChannelMembers);
                        TextCell textCell4 = this.logCell;
                        textCell3.setTextAndValueAndIcon(string7, BuildConfig.FLAVOR, R.drawable.actions_viewmembers, textCell4 != null && textCell4.getVisibility() == 0);
                    } else {
                        TextCell textCell5 = this.membersCell;
                        String string8 = LocaleController.getString("ChannelMembers", R.string.ChannelMembers);
                        TextCell textCell6 = this.logCell;
                        textCell5.setTextAndValueAndIcon(string8, BuildConfig.FLAVOR, R.drawable.actions_viewmembers, textCell6 != null && textCell6.getVisibility() == 0);
                    }
                    this.blockCell.setTextAndValueAndIcon(LocaleController.getString("ChannelBlacklist", R.string.ChannelBlacklist), BuildConfig.FLAVOR, R.drawable.actions_removed, true);
                    TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights = this.currentChat.default_banned_rights;
                    if (tLRPC$TL_chatBannedRights != null) {
                        boolean z3 = tLRPC$TL_chatBannedRights.send_stickers;
                        boolean z4 = tLRPC$TL_chatBannedRights.send_media;
                        boolean z5 = tLRPC$TL_chatBannedRights.embed_links;
                        boolean z6 = tLRPC$TL_chatBannedRights.send_messages;
                        boolean z7 = tLRPC$TL_chatBannedRights.pin_messages;
                        boolean z8 = tLRPC$TL_chatBannedRights.send_polls;
                        boolean z9 = tLRPC$TL_chatBannedRights.invite_users;
                        boolean z10 = tLRPC$TL_chatBannedRights.change_info;
                    }
                    this.permissionsCell.setTextAndValueAndIcon(LocaleController.getString("ChannelPermissions", R.string.ChannelPermissions), BuildConfig.FLAVOR, R.drawable.actions_permissions, true);
                }
                this.adminCell.setTextAndValueAndIcon(LocaleController.getString("ChannelAdministrators", R.string.ChannelAdministrators), BuildConfig.FLAVOR, R.drawable.actions_addadmin, true);
            } else {
                if (this.isChannel) {
                    textCell2.setTextAndIcon(LocaleController.getString("ChannelSubscribers", R.string.ChannelSubscribers), R.drawable.actions_viewmembers, true);
                    TextCell textCell7 = this.blockCell;
                    String string9 = LocaleController.getString("ChannelBlacklist", R.string.ChannelBlacklist);
                    TextCell textCell8 = this.logCell;
                    textCell7.setTextAndIcon(string9, R.drawable.actions_removed, textCell8 != null && textCell8.getVisibility() == 0);
                } else {
                    String string10 = LocaleController.getString("ChannelMembers", R.string.ChannelMembers);
                    TextCell textCell9 = this.logCell;
                    textCell2.setTextAndIcon(string10, R.drawable.actions_viewmembers, textCell9 != null && textCell9.getVisibility() == 0);
                    TextCell textCell10 = this.blockCell;
                    String string11 = LocaleController.getString("ChannelBlacklist", R.string.ChannelBlacklist);
                    TextCell textCell11 = this.logCell;
                    textCell10.setTextAndIcon(string11, R.drawable.actions_removed, textCell11 != null && textCell11.getVisibility() == 0);
                    this.permissionsCell.setTextAndIcon(LocaleController.getString("ChannelPermissions", R.string.ChannelPermissions), R.drawable.actions_permissions, true);
                }
                this.adminCell.setTextAndIcon(LocaleController.getString("ChannelAdministrators", R.string.ChannelAdministrators), R.drawable.actions_addadmin, true);
            }
            this.reactionsCell.setVisibility(ChatObject.canChangeChatInfo(this.currentChat) ? 0 : 8);
            updateReactionsCell(z2);
            if (this.info != null && ChatObject.canUserDoAdminAction(this.currentChat, 3) && !zIsChannelPrivate) {
                boolean z11 = this.currentChat.creator;
            }
            this.inviteLinksCell.setVisibility(8);
        }
        TextSettingsCell textSettingsCell2 = this.stickersCell;
        if (textSettingsCell2 != null && (tLRPC$ChatFull = this.info) != null) {
            if (tLRPC$ChatFull.stickerset != null) {
                textSettingsCell2.setTextAndValue(LocaleController.getString("GroupStickers", R.string.GroupStickers), this.info.stickerset.title, false);
            } else {
                textSettingsCell2.setText(LocaleController.getString("GroupStickers", R.string.GroupStickers), false);
            }
        }
        TLRPC$Chat tLRPC$Chat2 = this.currentChat;
        if (tLRPC$Chat2 != null && (hashSet = tLRPC$Chat2.accessEnumHashSet) != null && hashSet.contains(Chat.ChatAccessEnum.AcceptOwner)) {
            this.acceptOwnerCell.setVisibility(0);
        } else {
            this.acceptOwnerCell.setVisibility(8);
        }
    }

    private void updateReactionsCell(boolean z) {
        String string;
        TLRPC$TL_availableReaction tLRPC$TL_availableReaction;
        TLRPC$ChatReactions tLRPC$ChatReactions = this.availableReactions;
        if (tLRPC$ChatReactions == null || (tLRPC$ChatReactions instanceof TLRPC$TL_chatReactionsNone)) {
            string = LocaleController.getString("ReactionsOff", R.string.ReactionsOff);
        } else if (tLRPC$ChatReactions instanceof TLRPC$TL_chatReactionsSome) {
            TLRPC$TL_chatReactionsSome tLRPC$TL_chatReactionsSome = (TLRPC$TL_chatReactionsSome) tLRPC$ChatReactions;
            int i = 0;
            for (int i2 = 0; i2 < tLRPC$TL_chatReactionsSome.reactions.size(); i2++) {
                TLRPC$Reaction tLRPC$Reaction = tLRPC$TL_chatReactionsSome.reactions.get(i2);
                if ((tLRPC$Reaction instanceof TLRPC$TL_reactionEmoji) && (tLRPC$TL_availableReaction = getMediaDataController().getReactionsMap().get(((TLRPC$TL_reactionEmoji) tLRPC$Reaction).emoticon)) != null && !tLRPC$TL_availableReaction.inactive) {
                    i++;
                }
            }
            int iMin = Math.min(getMediaDataController().getEnabledReactionsList().size(), i);
            string = iMin == 0 ? LocaleController.getString("ReactionsOff", R.string.ReactionsOff) : LocaleController.formatString("ReactionsCount", R.string.ReactionsCount, Integer.valueOf(iMin), Integer.valueOf(getMediaDataController().getEnabledReactionsList().size()));
        } else {
            string = LocaleController.getString("ReactionsAll", R.string.ReactionsAll);
        }
        this.reactionsCell.setTextAndValueAndIcon(LocaleController.getString("Reactions", R.string.Reactions), string, z, R.drawable.msg_reactions, true);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: org.rbmain.ui.ChatEditActivity$$ExternalSyntheticLambda31
            @Override // org.rbmain.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() {
                this.f$0.lambda$getThemeDescriptions$34();
            }
        };
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, Theme.key_windowBackgroundGray));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, Theme.key_actionBarDefault));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, Theme.key_actionBarDefaultIcon));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, Theme.key_actionBarDefaultTitle));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, Theme.key_actionBarDefaultSelector));
        TextCell textCell = this.setAvatarCell;
        int i = ThemeDescription.FLAG_SELECTOR;
        int i2 = Theme.key_listSelector;
        arrayList.add(new ThemeDescription(textCell, i, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.setAvatarCell, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{TextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteBlueButton));
        arrayList.add(new ThemeDescription(this.setAvatarCell, 0, new Class[]{TextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteBlueIcon));
        arrayList.add(new ThemeDescription(this.membersCell, ThemeDescription.FLAG_SELECTOR, null, null, null, null, i2));
        int i3 = Theme.key_windowBackgroundWhiteBlackText;
        arrayList.add(new ThemeDescription(this.membersCell, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{TextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i3));
        int i4 = Theme.key_windowBackgroundWhiteGrayIcon;
        arrayList.add(new ThemeDescription(this.membersCell, 0, new Class[]{TextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i4));
        arrayList.add(new ThemeDescription(this.adminCell, ThemeDescription.FLAG_SELECTOR, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.adminCell, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{TextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i3));
        arrayList.add(new ThemeDescription(this.adminCell, 0, new Class[]{TextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i4));
        arrayList.add(new ThemeDescription(this.inviteLinksCell, ThemeDescription.FLAG_SELECTOR, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.inviteLinksCell, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{TextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i3));
        arrayList.add(new ThemeDescription(this.inviteLinksCell, 0, new Class[]{TextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i4));
        arrayList.add(new ThemeDescription(this.permissionsCell, ThemeDescription.FLAG_SELECTOR, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.permissionsCell, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{TextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i3));
        arrayList.add(new ThemeDescription(this.permissionsCell, 0, new Class[]{TextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i4));
        arrayList.add(new ThemeDescription(this.blockCell, ThemeDescription.FLAG_SELECTOR, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.blockCell, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{TextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i3));
        arrayList.add(new ThemeDescription(this.blockCell, 0, new Class[]{TextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i4));
        arrayList.add(new ThemeDescription(this.logCell, ThemeDescription.FLAG_SELECTOR, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.logCell, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{TextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i3));
        arrayList.add(new ThemeDescription(this.logCell, 0, new Class[]{TextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i4));
        arrayList.add(new ThemeDescription(this.typeCell, ThemeDescription.FLAG_SELECTOR, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.typeCell, 0, new Class[]{TextDetailCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i3));
        int i5 = Theme.key_windowBackgroundWhiteGrayText2;
        arrayList.add(new ThemeDescription(this.typeCell, 0, new Class[]{TextDetailCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i5));
        arrayList.add(new ThemeDescription(this.historyCell, ThemeDescription.FLAG_SELECTOR, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.historyCell, 0, new Class[]{TextDetailCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i3));
        arrayList.add(new ThemeDescription(this.historyCell, 0, new Class[]{TextDetailCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i5));
        arrayList.add(new ThemeDescription(this.eventCell, ThemeDescription.FLAG_SELECTOR, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.eventCell, 0, new Class[]{TextDetailCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i3));
        arrayList.add(new ThemeDescription(this.eventCell, 0, new Class[]{TextDetailCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i5));
        arrayList.add(new ThemeDescription(this.locationCell, ThemeDescription.FLAG_SELECTOR, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.locationCell, 0, new Class[]{TextDetailCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i3));
        arrayList.add(new ThemeDescription(this.locationCell, 0, new Class[]{TextDetailCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i5));
        arrayList.add(new ThemeDescription(this.nameTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i3));
        EditTextEmoji editTextEmoji = this.nameTextView;
        int i6 = ThemeDescription.FLAG_HINTTEXTCOLOR;
        int i7 = Theme.key_windowBackgroundWhiteHintText;
        arrayList.add(new ThemeDescription(editTextEmoji, i6, null, null, null, null, i7));
        arrayList.add(new ThemeDescription(this.nameTextView, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, Theme.key_windowBackgroundWhiteInputField));
        arrayList.add(new ThemeDescription(this.nameTextView, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, null, null, null, null, Theme.key_windowBackgroundWhiteInputFieldActivated));
        arrayList.add(new ThemeDescription(this.descriptionTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i3));
        arrayList.add(new ThemeDescription(this.descriptionTextView, ThemeDescription.FLAG_HINTTEXTCOLOR, null, null, null, null, i7));
        LinearLayout linearLayout = this.avatarContainer;
        int i8 = ThemeDescription.FLAG_BACKGROUND;
        int i9 = Theme.key_windowBackgroundWhite;
        arrayList.add(new ThemeDescription(linearLayout, i8, null, null, null, null, i9));
        arrayList.add(new ThemeDescription(this.settingsContainer, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, i9));
        arrayList.add(new ThemeDescription(this.typeEditContainer, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, i9));
        arrayList.add(new ThemeDescription(this.deleteContainer, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, i9));
        arrayList.add(new ThemeDescription(this.stickersContainer, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, i9));
        arrayList.add(new ThemeDescription(this.infoContainer, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, i9));
        int i10 = Theme.key_windowBackgroundGrayShadow;
        arrayList.add(new ThemeDescription(this.settingsTopSectionCell, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ShadowSectionCell.class}, null, null, null, i10));
        arrayList.add(new ThemeDescription(this.settingsSectionCell, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ShadowSectionCell.class}, null, null, null, i10));
        arrayList.add(new ThemeDescription(this.deleteInfoCell, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ShadowSectionCell.class}, null, null, null, i10));
        arrayList.add(new ThemeDescription(this.infoSectionCell, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ShadowSectionCell.class}, null, null, null, i10));
        arrayList.add(new ThemeDescription(this.signCell, ThemeDescription.FLAG_SELECTOR, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.signCell, 0, new Class[]{TextCheckCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i3));
        arrayList.add(new ThemeDescription(this.signCell, 0, new Class[]{TextCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_switchTrack));
        arrayList.add(new ThemeDescription(this.signCell, 0, new Class[]{TextCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_switchTrackChecked));
        arrayList.add(new ThemeDescription(this.deleteCell, ThemeDescription.FLAG_SELECTOR, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.deleteCell, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_text_RedRegular));
        arrayList.add(new ThemeDescription(this.stickersCell, ThemeDescription.FLAG_SELECTOR, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.stickersCell, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i3));
        arrayList.add(new ThemeDescription(this.stickersInfoCell3, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, i10));
        arrayList.add(new ThemeDescription(this.stickersInfoCell3, 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteGrayText4));
        arrayList.add(new ThemeDescription(null, 0, null, null, Theme.avatarDrawables, themeDescriptionDelegate, Theme.key_avatar_text));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundRed));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundOrange));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundViolet));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundGreen));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundCyan));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundBlue));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundPink));
        arrayList.add(new ThemeDescription(this.undoView, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, Theme.key_undo_background));
        int i11 = Theme.key_undo_cancelColor;
        arrayList.add(new ThemeDescription(this.undoView, 0, new Class[]{UndoView.class}, new String[]{"undoImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i11));
        arrayList.add(new ThemeDescription(this.undoView, 0, new Class[]{UndoView.class}, new String[]{"undoTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i11));
        int i12 = Theme.key_undo_infoColor;
        arrayList.add(new ThemeDescription(this.undoView, 0, new Class[]{UndoView.class}, new String[]{"infoTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i12));
        arrayList.add(new ThemeDescription(this.undoView, 0, new Class[]{UndoView.class}, new String[]{"textPaint"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i12));
        arrayList.add(new ThemeDescription(this.undoView, 0, new Class[]{UndoView.class}, new String[]{"progressPaint"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i12));
        arrayList.add(new ThemeDescription(this.undoView, ThemeDescription.FLAG_IMAGECOLOR, new Class[]{UndoView.class}, new String[]{"leftImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i12));
        arrayList.add(new ThemeDescription(this.reactionsCell, ThemeDescription.FLAG_SELECTOR, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.reactionsCell, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{TextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i3));
        arrayList.add(new ThemeDescription(this.reactionsCell, 0, new Class[]{TextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i4));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getThemeDescriptions$34() {
        BackupImageView backupImageView = this.avatarImage;
        if (backupImageView != null) {
            backupImageView.invalidate();
        }
    }
}
