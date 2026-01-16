package ir.eitaa.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
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
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ChatObject;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.MessagesStorage;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$ChannelLocation;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$ChatFull;
import ir.eitaa.tgnet.TLRPC$ChatParticipant;
import ir.eitaa.tgnet.TLRPC$ChatPhoto;
import ir.eitaa.tgnet.TLRPC$FileLocation;
import ir.eitaa.tgnet.TLRPC$InputFile;
import ir.eitaa.tgnet.TLRPC$PhotoSize;
import ir.eitaa.tgnet.TLRPC$TL_channelLocation;
import ir.eitaa.tgnet.TLRPC$TL_chatBannedRights;
import ir.eitaa.tgnet.TLRPC$TL_chatParticipantAdmin;
import ir.eitaa.tgnet.TLRPC$TL_chatParticipantCreator;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_messages_exportedChatInvites;
import ir.eitaa.tgnet.TLRPC$TL_messages_getExportedChatInvites;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Cells.ShadowSectionCell;
import ir.eitaa.ui.Cells.TextCell;
import ir.eitaa.ui.Cells.TextCheckCell;
import ir.eitaa.ui.Cells.TextDetailCell;
import ir.eitaa.ui.Cells.TextInfoPrivacyCell;
import ir.eitaa.ui.Cells.TextSettingsCell;
import ir.eitaa.ui.Components.AlertsCreator;
import ir.eitaa.ui.Components.AvatarDrawable;
import ir.eitaa.ui.Components.BackupImageView;
import ir.eitaa.ui.Components.EditTextBoldCursor;
import ir.eitaa.ui.Components.EditTextEmoji;
import ir.eitaa.ui.Components.ImageUpdater;
import ir.eitaa.ui.Components.RLottieDrawable;
import ir.eitaa.ui.Components.RadialProgressView;
import ir.eitaa.ui.Components.UndoView;
import ir.eitaa.ui.LocationActivity;
import ir.eitaa.ui.PhotoViewer;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class ChatEditActivity extends BaseFragment implements ImageUpdater.ImageUpdaterDelegate, NotificationCenter.NotificationCenterDelegate {
    private TextCell adminCell;
    private TLRPC$FileLocation avatar;
    private AnimatorSet avatarAnimation;
    private LinearLayout avatarContainer;
    private AvatarDrawable avatarDrawable;
    private BackupImageView avatarImage;
    private View avatarOverlay;
    private RadialProgressView avatarProgressView;
    private TextCell blockCell;
    RLottieDrawable cameraDrawable;
    private long chatId;
    private FrameLayout container5;
    private boolean contentTypeIsMedia;
    private boolean createAfterUpload;
    private TLRPC$Chat currentChat;
    private TextSettingsCell deleteCell;
    private FrameLayout deleteContainer;
    private ShadowSectionCell deleteInfoCell;
    private EditTextBoldCursor descriptionTextView;
    private View doneButton;
    private boolean donePressed;
    private TextDetailCell historyCell;
    private boolean historyHidden;
    private ImageUpdater imageUpdater;
    private TLRPC$ChatFull info;
    private TextInfoPrivacyCell infoCheckCell2;
    private LinearLayout infoContainer;
    private ShadowSectionCell infoSectionCell;
    private TextCell inviteLinksCell;
    private boolean isChannel;
    private TextDetailCell linkedCell;
    private TextDetailCell locationCell;
    private TextCell logCell;
    private TextCell membersCell;
    private EditTextEmoji nameTextView;
    private AlertDialog progressDialog;
    private PhotoViewer.PhotoViewerProvider provider;
    private TextCell setAvatarCell;
    private LinearLayout settingsContainer;
    private ShadowSectionCell settingsSectionCell;
    private ShadowSectionCell settingsTopSectionCell;
    private TextCheckCell signCell;
    private boolean signMessages;
    private TextSettingsCell stickersCell;
    private FrameLayout stickersContainer;
    private TextInfoPrivacyCell stickersInfoCell3;
    private TextCheckCell textCheckCell2;
    private TextDetailCell typeCell;
    private LinearLayout typeEditContainer;
    private UndoView undoView;

    static /* synthetic */ boolean lambda$createView$2(View view, MotionEvent motionEvent) {
        return true;
    }

    public ChatEditActivity(Bundle args) {
        super(args);
        this.provider = new PhotoViewer.EmptyPhotoViewerProvider() { // from class: ir.eitaa.ui.ChatEditActivity.1
            @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
            public PhotoViewer.PlaceProviderObject getPlaceForPhoto(MessageObject messageObject, TLRPC$FileLocation fileLocation, int index, boolean needPreview) {
                TLRPC$FileLocation tLRPC$FileLocation;
                TLRPC$ChatPhoto tLRPC$ChatPhoto;
                if (fileLocation == null) {
                    return null;
                }
                TLRPC$Chat chat = ChatEditActivity.this.getMessagesController().getChat(Long.valueOf(ChatEditActivity.this.chatId));
                if (chat == null || (tLRPC$ChatPhoto = chat.photo) == null || (tLRPC$FileLocation = tLRPC$ChatPhoto.photo_big) == null) {
                    tLRPC$FileLocation = null;
                }
                if (tLRPC$FileLocation == null || tLRPC$FileLocation.local_id != fileLocation.local_id || tLRPC$FileLocation.volume_id != fileLocation.volume_id || tLRPC$FileLocation.dc_id != fileLocation.dc_id) {
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

            @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
            public void willHidePhotoViewer() {
                ChatEditActivity.this.avatarImage.getImageReceiver().setVisible(true, true);
            }

            @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
            public void openPhotoForEdit(String file, String thumb, boolean isVideo) throws InterruptedException, Resources.NotFoundException {
                ChatEditActivity.this.imageUpdater.openPhotoForEdit(file, thumb, 0, isVideo);
            }
        };
        this.avatarDrawable = new AvatarDrawable();
        this.imageUpdater = new ImageUpdater(true);
        this.chatId = args.getLong("chat_id", 0L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x004c, code lost:
    
        if (r0 == null) goto L10;
     */
    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onFragmentCreate() {
        /*
            r10 = this;
            ir.eitaa.messenger.MessagesController r0 = r10.getMessagesController()
            long r1 = r10.chatId
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            ir.eitaa.tgnet.TLRPC$Chat r0 = r0.getChat(r1)
            r10.currentChat = r0
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L4f
            int r0 = r10.currentAccount
            ir.eitaa.messenger.MessagesStorage r0 = ir.eitaa.messenger.MessagesStorage.getInstance(r0)
            long r3 = r10.chatId
            ir.eitaa.tgnet.TLRPC$Chat r0 = r0.getChatSync(r3)
            r10.currentChat = r0
            if (r0 == 0) goto L4e
            ir.eitaa.messenger.MessagesController r0 = r10.getMessagesController()
            ir.eitaa.tgnet.TLRPC$Chat r3 = r10.currentChat
            r0.putChat(r3, r1)
            ir.eitaa.tgnet.TLRPC$ChatFull r0 = r10.info
            if (r0 != 0) goto L4f
            int r0 = r10.currentAccount
            ir.eitaa.messenger.MessagesStorage r3 = ir.eitaa.messenger.MessagesStorage.getInstance(r0)
            long r4 = r10.chatId
            ir.eitaa.tgnet.TLRPC$Chat r0 = r10.currentChat
            boolean r6 = ir.eitaa.messenger.ChatObject.isChannel(r0)
            java.util.concurrent.CountDownLatch r7 = new java.util.concurrent.CountDownLatch
            r7.<init>(r1)
            r8 = 0
            r9 = 0
            ir.eitaa.tgnet.TLRPC$ChatFull r0 = r3.loadChatInfo(r4, r6, r7, r8, r9)
            r10.info = r0
            if (r0 != 0) goto L4f
        L4e:
            return r2
        L4f:
            ir.eitaa.ui.Components.AvatarDrawable r0 = r10.avatarDrawable
            r3 = 5
            ir.eitaa.tgnet.TLRPC$Chat r5 = r10.currentChat
            java.lang.String r5 = r5.title
            r6 = 0
            r0.setInfo(r3, r5, r6)
            ir.eitaa.tgnet.TLRPC$Chat r0 = r10.currentChat
            boolean r0 = ir.eitaa.messenger.ChatObject.isChannel(r0)
            if (r0 == 0) goto L6a
            ir.eitaa.tgnet.TLRPC$Chat r0 = r10.currentChat
            boolean r0 = r0.megagroup
            if (r0 != 0) goto L6a
            goto L6b
        L6a:
            r1 = 0
        L6b:
            r10.isChannel = r1
            ir.eitaa.ui.Components.ImageUpdater r0 = r10.imageUpdater
            r0.parentFragment = r10
            r0.setDelegate(r10)
            ir.eitaa.tgnet.TLRPC$Chat r0 = r10.currentChat
            boolean r1 = r0.signatures
            r10.signMessages = r1
            boolean r0 = r0.isMediaContent
            r10.contentTypeIsMedia = r0
            int r0 = r10.currentAccount
            ir.eitaa.messenger.NotificationCenter r0 = ir.eitaa.messenger.NotificationCenter.getInstance(r0)
            int r1 = ir.eitaa.messenger.NotificationCenter.chatInfoDidLoad
            r0.addObserver(r10, r1)
            int r0 = r10.currentAccount
            ir.eitaa.messenger.NotificationCenter r0 = ir.eitaa.messenger.NotificationCenter.getInstance(r0)
            int r1 = ir.eitaa.messenger.NotificationCenter.updateInterfaces
            r0.addObserver(r10, r1)
            ir.eitaa.tgnet.TLRPC$ChatFull r0 = r10.info
            if (r0 == 0) goto L9b
            r10.loadLinksCount()
        L9b:
            boolean r0 = super.onFragmentCreate()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ChatEditActivity.onFragmentCreate():boolean");
    }

    private void loadLinksCount() {
        TLRPC$TL_messages_getExportedChatInvites tLRPC$TL_messages_getExportedChatInvites = new TLRPC$TL_messages_getExportedChatInvites();
        tLRPC$TL_messages_getExportedChatInvites.peer = getMessagesController().getInputPeer(-this.chatId);
        tLRPC$TL_messages_getExportedChatInvites.admin_id = getMessagesController().getInputUser(getUserConfig().getCurrentUser());
        tLRPC$TL_messages_getExportedChatInvites.limit = 0;
        getConnectionsManager().sendRequest(tLRPC$TL_messages_getExportedChatInvites, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ChatEditActivity$Gw26xD_aZXrpRCgi5ziUPsgaFbk
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadLinksCount$1$ChatEditActivity(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadLinksCount$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadLinksCount$1$ChatEditActivity(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ChatEditActivity$HfZ_iRgfJPxroSE3Lf3cFT76_no
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadLinksCount$0$ChatEditActivity(tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadLinksCount$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadLinksCount$0$ChatEditActivity(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
        if (tLRPC$TL_error == null) {
            this.info.invitesCount = ((TLRPC$TL_messages_exportedChatInvites) tLObject).count;
            getMessagesStorage().saveChatLinksCount(this.chatId, this.info.invitesCount);
            updateFields(false);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() throws InterruptedException {
        super.onFragmentDestroy();
        ImageUpdater imageUpdater = this.imageUpdater;
        if (imageUpdater != null) {
            imageUpdater.clear();
        }
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.chatInfoDidLoad);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.updateInterfaces);
        EditTextEmoji editTextEmoji = this.nameTextView;
        if (editTextEmoji != null) {
            editTextEmoji.onDestroy();
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        EditTextEmoji editTextEmoji = this.nameTextView;
        if (editTextEmoji != null) {
            editTextEmoji.onResume();
            this.nameTextView.getEditText().requestFocus();
        }
        AndroidUtilities.requestAdjustResize(getParentActivity(), this.classGuid);
        updateFields(true);
        this.imageUpdater.onResume();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
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

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    protected void onBecomeFullyHidden() {
        UndoView undoView = this.undoView;
        if (undoView != null) {
            undoView.hide(true, 0);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void dismissCurrentDialog() {
        if (this.imageUpdater.dismissCurrentDialog(this.visibleDialog)) {
            return;
        }
        super.dismissCurrentDialog();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean dismissDialogOnPause(Dialog dialog) {
        return this.imageUpdater.dismissDialogOnPause(dialog) && super.dismissDialogOnPause(dialog);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onRequestPermissionsResultFragment(int requestCode, String[] permissions, int[] grantResults) {
        this.imageUpdater.onRequestPermissionsResultFragment(requestCode, permissions, grantResults);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onBackPressed() {
        EditTextEmoji editTextEmoji = this.nameTextView;
        if (editTextEmoji != null && editTextEmoji.isPopupShowing()) {
            this.nameTextView.hidePopup(true);
            return false;
        }
        return checkDiscard();
    }

    /* JADX WARN: Removed duplicated region for block: B:141:0x05a6  */
    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View createView(android.content.Context r24) {
        /*
            Method dump skipped, instructions count: 2033
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ChatEditActivity.createView(android.content.Context):android.view.View");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005c  */
    /* renamed from: lambda$createView$3, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$createView$3$ChatEditActivity(android.view.View r4) throws android.content.res.Resources.NotFoundException {
        /*
            r3 = this;
            ir.eitaa.ui.Components.ImageUpdater r4 = r3.imageUpdater
            boolean r4 = r4.isUploadingImage()
            if (r4 == 0) goto L9
            return
        L9:
            ir.eitaa.messenger.MessagesController r4 = r3.getMessagesController()
            long r0 = r3.chatId
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            ir.eitaa.tgnet.TLRPC$Chat r4 = r4.getChat(r0)
            ir.eitaa.tgnet.TLRPC$ChatPhoto r0 = r4.photo
            if (r0 == 0) goto L6a
            ir.eitaa.tgnet.TLRPC$FileLocation r0 = r0.photo_big
            if (r0 == 0) goto L6a
            ir.eitaa.ui.PhotoViewer r0 = ir.eitaa.ui.PhotoViewer.getInstance()
            android.app.Activity r1 = r3.getParentActivity()
            r0.setParentActivity(r1)
            ir.eitaa.tgnet.TLRPC$ChatPhoto r0 = r4.photo
            int r1 = r0.dc_id
            if (r1 == 0) goto L34
            ir.eitaa.tgnet.TLRPC$FileLocation r0 = r0.photo_big
            r0.dc_id = r1
        L34:
            ir.eitaa.tgnet.TLRPC$ChatFull r0 = r3.info
            if (r0 == 0) goto L5c
            ir.eitaa.tgnet.TLRPC$Photo r0 = r0.chat_photo
            boolean r1 = r0 instanceof ir.eitaa.tgnet.TLRPC$TL_photo
            if (r1 == 0) goto L5c
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$VideoSize> r0 = r0.video_sizes
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L5c
            ir.eitaa.tgnet.TLRPC$ChatFull r0 = r3.info
            ir.eitaa.tgnet.TLRPC$Photo r0 = r0.chat_photo
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$VideoSize> r0 = r0.video_sizes
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            ir.eitaa.tgnet.TLRPC$VideoSize r0 = (ir.eitaa.tgnet.TLRPC$VideoSize) r0
            ir.eitaa.tgnet.TLRPC$ChatFull r1 = r3.info
            ir.eitaa.tgnet.TLRPC$Photo r1 = r1.chat_photo
            ir.eitaa.messenger.ImageLocation r0 = ir.eitaa.messenger.ImageLocation.getForPhoto(r0, r1)
            goto L5d
        L5c:
            r0 = 0
        L5d:
            ir.eitaa.ui.PhotoViewer r1 = ir.eitaa.ui.PhotoViewer.getInstance()
            ir.eitaa.tgnet.TLRPC$ChatPhoto r4 = r4.photo
            ir.eitaa.tgnet.TLRPC$FileLocation r4 = r4.photo_big
            ir.eitaa.ui.PhotoViewer$PhotoViewerProvider r2 = r3.provider
            r1.openPhotoWithVideo(r4, r0, r2)
        L6a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ChatEditActivity.lambda$createView$3$ChatEditActivity(android.view.View):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$6$ChatEditActivity(View view) {
        this.imageUpdater.openMenu(this.avatar != null, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ChatEditActivity$cbmx0YQfLnQH1UGMGy1ZrTLzVVw
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createView$4$ChatEditActivity();
            }
        }, new DialogInterface.OnDismissListener() { // from class: ir.eitaa.ui.-$$Lambda$ChatEditActivity$5SvYyF8x4SlgPj9RNT8j2ABnR8c
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) throws InterruptedException {
                this.f$0.lambda$createView$5$ChatEditActivity(dialogInterface);
            }
        });
        this.cameraDrawable.setCurrentFrame(0);
        this.cameraDrawable.setCustomEndFrame(43);
        this.setAvatarCell.imageView.playAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$4$ChatEditActivity() {
        this.avatar = null;
        MessagesController.getInstance(this.currentAccount).changeChatAvatar(this.chatId, null, null, null, 0.0d, null, null, null, null);
        showAvatarProgress(false, true);
        this.avatarImage.setImage((ImageLocation) null, (String) null, this.avatarDrawable, this.currentChat);
        this.cameraDrawable.setCurrentFrame(0);
        this.setAvatarCell.imageView.playAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$5$ChatEditActivity(DialogInterface dialogInterface) throws InterruptedException {
        if (!this.imageUpdater.isUploadingImage()) {
            this.cameraDrawable.setCustomEndFrame(86);
            this.setAvatarCell.imageView.playAnimation();
        } else {
            this.cameraDrawable.setCurrentFrame(0, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$createView$7$ChatEditActivity(TextView textView, int i, KeyEvent keyEvent) {
        View view;
        if (i != 6 || (view = this.doneButton) == null) {
            return false;
        }
        view.performClick();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$9$ChatEditActivity(View view) {
        if (AndroidUtilities.isGoogleMapsInstalled(this)) {
            LocationActivity locationActivity = new LocationActivity(4);
            locationActivity.setDialogId(-this.chatId);
            locationActivity.setDelegate(new LocationActivity.LocationActivityDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ChatEditActivity$6BO-rRMlZEGj5cJdBJGDwBNVgEQ
            });
            presentFragment(locationActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$10$ChatEditActivity(View view) {
        long j = this.chatId;
        TextDetailCell textDetailCell = this.locationCell;
        ChatEditTypeActivity chatEditTypeActivity = new ChatEditTypeActivity(j, textDetailCell != null && textDetailCell.getVisibility() == 0);
        chatEditTypeActivity.setInfo(this.info);
        presentFragment(chatEditTypeActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$11$ChatEditActivity(View view) {
        ChatLinkActivity chatLinkActivity = new ChatLinkActivity(this.chatId);
        chatLinkActivity.setInfo(this.info);
        presentFragment(chatLinkActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$14, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$14$ChatEditActivity(View view) {
        boolean z = !this.signMessages;
        this.signMessages = z;
        ((TextCheckCell) view).setChecked(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$15$ChatEditActivity(View view) {
        boolean z = !this.contentTypeIsMedia;
        this.contentTypeIsMedia = z;
        ((TextCheckCell) view).setChecked(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$16, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$16$ChatEditActivity(View view) {
        Bundle bundle = new Bundle();
        bundle.putLong("chat_id", this.chatId);
        bundle.putInt("type", (this.isChannel || this.currentChat.gigagroup) ? 0 : 3);
        ChatUsersActivity chatUsersActivity = new ChatUsersActivity(bundle);
        chatUsersActivity.setInfo(this.info);
        presentFragment(chatUsersActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$17, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$17$ChatEditActivity(View view) {
        ManageLinksActivity manageLinksActivity = new ManageLinksActivity(this.chatId, 0L, 0);
        TLRPC$ChatFull tLRPC$ChatFull = this.info;
        manageLinksActivity.setInfo(tLRPC$ChatFull, tLRPC$ChatFull.exported_invite);
        presentFragment(manageLinksActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$18, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$18$ChatEditActivity(View view) {
        Bundle bundle = new Bundle();
        bundle.putLong("chat_id", this.chatId);
        bundle.putInt("type", 1);
        ChatUsersActivity chatUsersActivity = new ChatUsersActivity(bundle);
        chatUsersActivity.setInfo(this.info);
        presentFragment(chatUsersActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$19, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$19$ChatEditActivity(View view) {
        Bundle bundle = new Bundle();
        bundle.putLong("chat_id", this.chatId);
        bundle.putInt("type", 2);
        ChatUsersActivity chatUsersActivity = new ChatUsersActivity(bundle);
        chatUsersActivity.setInfo(this.info);
        presentFragment(chatUsersActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$20, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$20$ChatEditActivity(View view) {
        presentFragment(new ChannelAdminLogActivity(this.currentChat));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$21, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$21$ChatEditActivity(View view) {
        GroupStickersActivity groupStickersActivity = new GroupStickersActivity(this.currentChat.id);
        groupStickersActivity.setInfo(this.info);
        presentFragment(groupStickersActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$23, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$23$ChatEditActivity(View view) {
        AlertsCreator.createClearOrDeleteDialogAlert(this, false, true, false, this.currentChat, null, false, true, new MessagesStorage.BooleanCallback() { // from class: ir.eitaa.ui.-$$Lambda$ChatEditActivity$KKDrM1a1GJD64glYiefcBFIJdlA
            @Override // ir.eitaa.messenger.MessagesStorage.BooleanCallback
            public final void run(boolean z) {
                this.f$0.lambda$createView$22$ChatEditActivity(z);
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$22, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$22$ChatEditActivity(boolean z) {
        if (AndroidUtilities.isTablet()) {
            getNotificationCenter().postNotificationName(NotificationCenter.closeChats, Long.valueOf(-this.chatId));
        } else {
            getNotificationCenter().postNotificationName(NotificationCenter.closeChats, new Object[0]);
        }
        finishFragment();
        getNotificationCenter().postNotificationName(NotificationCenter.needDeleteDialog, Long.valueOf(-this.currentChat.id), null, this.currentChat, Boolean.valueOf(z));
    }

    private void setAvatar() {
        TLRPC$Chat chat;
        if (this.avatarImage == null || (chat = getMessagesController().getChat(Long.valueOf(this.chatId))) == null) {
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
                this.setAvatarCell.setTextAndIcon(LocaleController.getString("ChatSetPhotoOrVideo", R.string.ChatSetPhotoOrVideo), R.drawable.menu_camera2, true);
            }
            if (this.cameraDrawable == null) {
                this.cameraDrawable = new RLottieDrawable(R.raw.camera_outline, "2131623946", AndroidUtilities.dp(50.0f), AndroidUtilities.dp(50.0f), false, (int[]) null);
            }
            this.setAvatarCell.imageView.setTranslationY(-AndroidUtilities.dp(9.0f));
            this.setAvatarCell.imageView.setTranslationX(-AndroidUtilities.dp(8.0f));
            this.setAvatarCell.imageView.setAnimation(this.cameraDrawable);
        }
        if (PhotoViewer.hasInstance() && PhotoViewer.getInstance().isVisible()) {
            PhotoViewer.getInstance().checkCurrentImageVisibility();
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment, ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        EditTextBoldCursor editTextBoldCursor;
        if (id == NotificationCenter.chatInfoDidLoad) {
            TLRPC$ChatFull tLRPC$ChatFull = (TLRPC$ChatFull) args[0];
            if (tLRPC$ChatFull.id == this.chatId) {
                if (this.info == null && (editTextBoldCursor = this.descriptionTextView) != null) {
                    editTextBoldCursor.setText(tLRPC$ChatFull.about);
                }
                boolean z = true;
                boolean z2 = this.info == null;
                this.info = tLRPC$ChatFull;
                if (ChatObject.isChannel(this.currentChat) && !this.info.hidden_prehistory) {
                    z = false;
                }
                this.historyHidden = z;
                updateFields(false);
                if (z2) {
                    loadLinksCount();
                    return;
                }
                return;
            }
            return;
        }
        if (id != NotificationCenter.updateInterfaces || (((Integer) args[0]).intValue() & MessagesController.UPDATE_MASK_AVATAR) == 0) {
            return;
        }
        setAvatar();
    }

    @Override // ir.eitaa.ui.Components.ImageUpdater.ImageUpdaterDelegate
    public void onUploadProgressChanged(float progress) {
        RadialProgressView radialProgressView = this.avatarProgressView;
        if (radialProgressView == null) {
            return;
        }
        radialProgressView.setProgress(progress);
    }

    @Override // ir.eitaa.ui.Components.ImageUpdater.ImageUpdaterDelegate
    public void didStartUpload(boolean isVideo) {
        RadialProgressView radialProgressView = this.avatarProgressView;
        if (radialProgressView == null) {
            return;
        }
        radialProgressView.setProgress(0.0f);
    }

    @Override // ir.eitaa.ui.Components.ImageUpdater.ImageUpdaterDelegate
    public void didUploadPhoto(final TLRPC$InputFile photo, final TLRPC$InputFile video, final double videoStartTimestamp, final String videoPath, final TLRPC$PhotoSize bigSize, final TLRPC$PhotoSize smallSize) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ChatEditActivity$vTYZ7pD3HF6sKxcRU7xcBWyT9d4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$didUploadPhoto$24$ChatEditActivity(smallSize, photo, video, videoStartTimestamp, videoPath, bigSize);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$didUploadPhoto$24, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$didUploadPhoto$24$ChatEditActivity(TLRPC$PhotoSize tLRPC$PhotoSize, TLRPC$InputFile tLRPC$InputFile, TLRPC$InputFile tLRPC$InputFile2, double d, String str, TLRPC$PhotoSize tLRPC$PhotoSize2) {
        TLRPC$FileLocation tLRPC$FileLocation = tLRPC$PhotoSize.location;
        this.avatar = tLRPC$FileLocation;
        if (tLRPC$InputFile != null || tLRPC$InputFile2 != null) {
            getMessagesController().changeChatAvatar(this.chatId, null, tLRPC$InputFile, tLRPC$InputFile2, d, str, tLRPC$PhotoSize.location, tLRPC$PhotoSize2.location, null);
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
        if (this.cameraDrawable == null) {
            this.cameraDrawable = new RLottieDrawable(R.raw.camera_outline, "2131623946", AndroidUtilities.dp(50.0f), AndroidUtilities.dp(50.0f), false, (int[]) null);
        }
        this.setAvatarCell.imageView.setTranslationY(-AndroidUtilities.dp(9.0f));
        this.setAvatarCell.imageView.setTranslationX(-AndroidUtilities.dp(8.0f));
        this.setAvatarCell.imageView.setAnimation(this.cameraDrawable);
        showAvatarProgress(true, false);
    }

    @Override // ir.eitaa.ui.Components.ImageUpdater.ImageUpdaterDelegate
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
        EditTextBoldCursor editTextBoldCursor;
        TLRPC$ChatFull tLRPC$ChatFull = this.info;
        if (tLRPC$ChatFull == null || (str = tLRPC$ChatFull.about) == null) {
            str = "";
        }
        if ((tLRPC$ChatFull == null || !ChatObject.isChannel(this.currentChat) || this.info.hidden_prehistory == this.historyHidden) && (((editTextEmoji = this.nameTextView) == null || this.currentChat.title.equals(editTextEmoji.getText().toString())) && (((editTextBoldCursor = this.descriptionTextView) == null || str.equals(editTextBoldCursor.getText().toString())) && this.signMessages == this.currentChat.signatures))) {
            return true;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setTitle(LocaleController.getString("UserRestrictionsApplyChanges", R.string.UserRestrictionsApplyChanges));
        if (this.isChannel) {
            builder.setMessage(LocaleController.getString("ChannelSettingsChangedAlert", R.string.ChannelSettingsChangedAlert));
        } else {
            builder.setMessage(LocaleController.getString("GroupSettingsChangedAlert", R.string.GroupSettingsChangedAlert));
        }
        builder.setPositiveButton(LocaleController.getString("ApplyTheme", R.string.ApplyTheme), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ChatEditActivity$DxI_IggkzUwY9ReRMxKZFZUCVUI
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$checkDiscard$25$ChatEditActivity(dialogInterface, i);
            }
        });
        builder.setNegativeButton(LocaleController.getString("PassportDiscard", R.string.PassportDiscard), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ChatEditActivity$7oAlLTHC2H5UxH8ZxoAoCTtnh9Q
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$checkDiscard$26$ChatEditActivity(dialogInterface, i);
            }
        });
        showDialog(builder.create());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkDiscard$25, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkDiscard$25$ChatEditActivity(DialogInterface dialogInterface, int i) {
        processDone();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkDiscard$26, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkDiscard$26$ChatEditActivity(DialogInterface dialogInterface, int i) {
        finishFragment();
    }

    private int getAdminCount() {
        TLRPC$ChatFull tLRPC$ChatFull = this.info;
        if (tLRPC$ChatFull == null) {
            return 1;
        }
        int size = tLRPC$ChatFull.participants.participants.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            TLRPC$ChatParticipant tLRPC$ChatParticipant = this.info.participants.participants.get(i2);
            if ((tLRPC$ChatParticipant instanceof TLRPC$TL_chatParticipantAdmin) || (tLRPC$ChatParticipant instanceof TLRPC$TL_chatParticipantCreator)) {
                i++;
            }
        }
        return i;
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
            getMessagesController().convertToMegaGroup(getParentActivity(), this.chatId, this, new MessagesStorage.LongCallback() { // from class: ir.eitaa.ui.-$$Lambda$ChatEditActivity$cuL9RynYYLrFJ--kSzYv3_AqTKA
                @Override // ir.eitaa.messenger.MessagesStorage.LongCallback
                public final void run(long j) {
                    this.f$0.lambda$processDone$27$ChatEditActivity(j);
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
                getMessagesController().toogleChannelInvitesHistory(this.chatId, this.historyHidden);
            }
        }
        if (this.imageUpdater.isUploadingImage()) {
            this.createAfterUpload = true;
            AlertDialog alertDialog = new AlertDialog(getParentActivity(), 3);
            this.progressDialog = alertDialog;
            alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: ir.eitaa.ui.-$$Lambda$ChatEditActivity$TmHYNWP1fJk7KN6GtiSbM_s5ak0
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    this.f$0.lambda$processDone$28$ChatEditActivity(dialogInterface);
                }
            });
            this.progressDialog.show();
            return;
        }
        if (!this.currentChat.title.equals(this.nameTextView.getText().toString())) {
            getMessagesController().changeChatTitle(this.chatId, this.nameTextView.getText().toString());
        }
        TLRPC$ChatFull tLRPC$ChatFull2 = this.info;
        if (tLRPC$ChatFull2 == null || (str = tLRPC$ChatFull2.about) == null) {
            str = "";
        }
        EditTextBoldCursor editTextBoldCursor = this.descriptionTextView;
        if (editTextBoldCursor != null && !str.equals(editTextBoldCursor.getText().toString())) {
            getMessagesController().updateChatAbout(this.chatId, this.descriptionTextView.getText().toString(), this.info);
        }
        boolean z3 = this.signMessages;
        TLRPC$Chat tLRPC$Chat = this.currentChat;
        if (z3 != tLRPC$Chat.signatures) {
            tLRPC$Chat.signatures = true;
            getMessagesController().toogleChannelSignatures(this.chatId, this.signMessages);
        }
        boolean z4 = this.contentTypeIsMedia;
        TLRPC$Chat tLRPC$Chat2 = this.currentChat;
        if (z4 != tLRPC$Chat2.isMediaContent) {
            tLRPC$Chat2.isMediaContent = z4;
            MessagesController.getInstance(this.currentAccount).toggleChannelContentType((int) this.chatId, this.contentTypeIsMedia);
        }
        finishFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processDone$27, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processDone$27$ChatEditActivity(long j) {
        if (j == 0) {
            this.donePressed = false;
            return;
        }
        this.chatId = j;
        this.currentChat = getMessagesController().getChat(Long.valueOf(j));
        this.donePressed = false;
        TLRPC$ChatFull tLRPC$ChatFull = this.info;
        if (tLRPC$ChatFull != null) {
            tLRPC$ChatFull.hidden_prehistory = true;
        }
        processDone();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processDone$28, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processDone$28$ChatEditActivity(DialogInterface dialogInterface) {
        this.createAfterUpload = false;
        this.progressDialog = null;
        this.donePressed = false;
    }

    private void showAvatarProgress(final boolean show, boolean animated) {
        if (this.avatarProgressView == null) {
            return;
        }
        AnimatorSet animatorSet = this.avatarAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.avatarAnimation = null;
        }
        if (animated) {
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.avatarAnimation = animatorSet2;
            if (show) {
                this.avatarProgressView.setVisibility(0);
                this.avatarOverlay.setVisibility(0);
                this.avatarAnimation.playTogether(ObjectAnimator.ofFloat(this.avatarProgressView, (Property<RadialProgressView, Float>) View.ALPHA, 1.0f), ObjectAnimator.ofFloat(this.avatarOverlay, (Property<View, Float>) View.ALPHA, 1.0f));
            } else {
                animatorSet2.playTogether(ObjectAnimator.ofFloat(this.avatarProgressView, (Property<RadialProgressView, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.avatarOverlay, (Property<View, Float>) View.ALPHA, 0.0f));
            }
            this.avatarAnimation.setDuration(180L);
            this.avatarAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.ChatEditActivity.9
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    if (ChatEditActivity.this.avatarAnimation == null || ChatEditActivity.this.avatarProgressView == null) {
                        return;
                    }
                    if (!show) {
                        ChatEditActivity.this.avatarProgressView.setVisibility(4);
                        ChatEditActivity.this.avatarOverlay.setVisibility(4);
                    }
                    ChatEditActivity.this.avatarAnimation = null;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    ChatEditActivity.this.avatarAnimation = null;
                }
            });
            this.avatarAnimation.start();
            return;
        }
        if (show) {
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

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onActivityResultFragment(int requestCode, int resultCode, Intent data) throws InterruptedException, Resources.NotFoundException {
        this.imageUpdater.onActivityResult(requestCode, resultCode, data);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void saveSelfArgs(Bundle args) {
        String str;
        ImageUpdater imageUpdater = this.imageUpdater;
        if (imageUpdater != null && (str = imageUpdater.currentPicturePath) != null) {
            args.putString("path", str);
        }
        EditTextEmoji editTextEmoji = this.nameTextView;
        if (editTextEmoji != null) {
            String string = editTextEmoji.getText().toString();
            if (string.length() != 0) {
                args.putString("nameTextView", string);
            }
        }
    }

    public void setInfo(TLRPC$ChatFull chatFull) {
        this.info = chatFull;
        if (chatFull != null) {
            if (this.currentChat == null) {
                this.currentChat = getMessagesController().getChat(Long.valueOf(this.chatId));
            }
            this.historyHidden = !ChatObject.isChannel(this.currentChat) || this.info.hidden_prehistory;
        }
    }

    private void updateFields(boolean updateChat) {
        TLRPC$ChatFull tLRPC$ChatFull;
        int i;
        int i2;
        String str;
        int i3;
        String str2;
        String string;
        TextDetailCell textDetailCell;
        TextDetailCell textDetailCell2;
        int i4;
        String str3;
        String string2;
        TextDetailCell textDetailCell3;
        TLRPC$ChatFull tLRPC$ChatFull2;
        TextDetailCell textDetailCell4;
        TextDetailCell textDetailCell5;
        TextDetailCell textDetailCell6;
        TLRPC$Chat chat;
        if (updateChat && (chat = getMessagesController().getChat(Long.valueOf(this.chatId))) != null) {
            this.currentChat = chat;
        }
        boolean zIsEmpty = TextUtils.isEmpty(this.currentChat.username);
        TextDetailCell textDetailCell7 = this.historyCell;
        if (textDetailCell7 != null) {
            TLRPC$ChatFull tLRPC$ChatFull3 = this.info;
            if (tLRPC$ChatFull3 == null || !(tLRPC$ChatFull3.location instanceof TLRPC$TL_channelLocation)) {
                textDetailCell7.setVisibility((zIsEmpty && (tLRPC$ChatFull3 == null || tLRPC$ChatFull3.linked_chat_id == 0)) ? 0 : 8);
            } else {
                textDetailCell7.setVisibility(8);
            }
        }
        ShadowSectionCell shadowSectionCell = this.settingsSectionCell;
        if (shadowSectionCell != null) {
            shadowSectionCell.setVisibility((this.signCell == null && this.typeCell == null && ((textDetailCell4 = this.linkedCell) == null || textDetailCell4.getVisibility() != 0) && (((textDetailCell5 = this.historyCell) == null || textDetailCell5.getVisibility() != 0) && ((textDetailCell6 = this.locationCell) == null || textDetailCell6.getVisibility() != 0))) ? 8 : 0);
        }
        TextCell textCell = this.logCell;
        if (textCell != null) {
            TLRPC$Chat tLRPC$Chat = this.currentChat;
            textCell.setVisibility((!tLRPC$Chat.megagroup || tLRPC$Chat.gigagroup || ((tLRPC$ChatFull2 = this.info) != null && tLRPC$ChatFull2.participants_count > 200)) ? 0 : 8);
        }
        TextDetailCell textDetailCell8 = this.linkedCell;
        if (textDetailCell8 != null) {
            textDetailCell8.setVisibility(8);
        }
        TextDetailCell textDetailCell9 = this.locationCell;
        if (textDetailCell9 != null) {
            TLRPC$ChatFull tLRPC$ChatFull4 = this.info;
            if (tLRPC$ChatFull4 != null && tLRPC$ChatFull4.can_set_location) {
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
            TLRPC$ChatFull tLRPC$ChatFull5 = this.info;
            if (tLRPC$ChatFull5 != null && (tLRPC$ChatFull5.location instanceof TLRPC$TL_channelLocation)) {
                if (zIsEmpty) {
                    string2 = LocaleController.getString("TypeLocationGroupEdit", R.string.TypeLocationGroupEdit);
                } else {
                    string2 = String.format("https://" + getMessagesController().linkPrefix + "/%s", this.currentChat.username);
                }
                TextDetailCell textDetailCell10 = this.typeCell;
                String string3 = LocaleController.getString("TypeLocationGroup", R.string.TypeLocationGroup);
                TextDetailCell textDetailCell11 = this.historyCell;
                textDetailCell10.setTextAndValue(string3, string2, (textDetailCell11 != null && textDetailCell11.getVisibility() == 0) || ((textDetailCell3 = this.linkedCell) != null && textDetailCell3.getVisibility() == 0));
            } else {
                if (this.isChannel) {
                    if (zIsEmpty) {
                        i4 = R.string.TypePrivate;
                        str3 = "TypePrivate";
                    } else {
                        i4 = R.string.TypePublic;
                        str3 = "TypePublic";
                    }
                    string = LocaleController.getString(str3, i4);
                } else {
                    if (zIsEmpty) {
                        i3 = R.string.TypePrivateGroup;
                        str2 = "TypePrivateGroup";
                    } else {
                        i3 = R.string.TypePublicGroup;
                        str2 = "TypePublicGroup";
                    }
                    string = LocaleController.getString(str2, i3);
                }
                if (this.isChannel) {
                    TextDetailCell textDetailCell12 = this.typeCell;
                    String string4 = LocaleController.getString("ChannelType", R.string.ChannelType);
                    TextDetailCell textDetailCell13 = this.historyCell;
                    textDetailCell12.setTextAndValue(string4, string, (textDetailCell13 != null && textDetailCell13.getVisibility() == 0) || ((textDetailCell2 = this.linkedCell) != null && textDetailCell2.getVisibility() == 0));
                } else {
                    TextDetailCell textDetailCell14 = this.typeCell;
                    String string5 = LocaleController.getString("GroupType", R.string.GroupType);
                    TextDetailCell textDetailCell15 = this.historyCell;
                    textDetailCell14.setTextAndValue(string5, string, (textDetailCell15 != null && textDetailCell15.getVisibility() == 0) || ((textDetailCell = this.linkedCell) != null && textDetailCell.getVisibility() == 0));
                }
            }
        }
        if (this.historyCell != null) {
            if (this.historyHidden) {
                i2 = R.string.ChatHistoryHidden;
                str = "ChatHistoryHidden";
            } else {
                i2 = R.string.ChatHistoryVisible;
                str = "ChatHistoryVisible";
            }
            this.historyCell.setTextAndValue(LocaleController.getString("ChatHistory", R.string.ChatHistory), LocaleController.getString(str, i2), false);
        }
        TextSettingsCell textSettingsCell = this.stickersCell;
        if (textSettingsCell != null) {
            TLRPC$ChatFull tLRPC$ChatFull6 = this.info;
            if (tLRPC$ChatFull6 != null && tLRPC$ChatFull6.stickerset != null) {
                textSettingsCell.setTextAndValue(LocaleController.getString("GroupStickers", R.string.GroupStickers), this.info.stickerset.title, false);
            } else {
                textSettingsCell.setText(LocaleController.getString("GroupStickers", R.string.GroupStickers), false);
            }
        }
        TextCell textCell2 = this.membersCell;
        if (textCell2 != null) {
            if (this.info != null) {
                if (this.isChannel) {
                    textCell2.setTextAndValueAndIcon(LocaleController.getString("ChannelSubscribers", R.string.ChannelSubscribers), String.format("%d", Integer.valueOf(this.info.participants_count)), R.drawable.actions_viewmembers, true);
                    TextCell textCell3 = this.blockCell;
                    String string6 = LocaleController.getString("ChannelBlacklist", R.string.ChannelBlacklist);
                    TLRPC$ChatFull tLRPC$ChatFull7 = this.info;
                    String str4 = String.format("%d", Integer.valueOf(Math.max(tLRPC$ChatFull7.banned_count, tLRPC$ChatFull7.kicked_count)));
                    TextCell textCell4 = this.logCell;
                    textCell3.setTextAndValueAndIcon(string6, str4, R.drawable.actions_removed, textCell4 != null && textCell4.getVisibility() == 0);
                } else {
                    if (ChatObject.isChannel(this.currentChat)) {
                        TextCell textCell5 = this.membersCell;
                        String string7 = LocaleController.getString("ChannelMembers", R.string.ChannelMembers);
                        String str5 = String.format("%d", Integer.valueOf(this.info.participants_count));
                        TextCell textCell6 = this.logCell;
                        textCell5.setTextAndValueAndIcon(string7, str5, R.drawable.actions_viewmembers, textCell6 != null && textCell6.getVisibility() == 0);
                    } else {
                        TextCell textCell7 = this.membersCell;
                        String string8 = LocaleController.getString("ChannelMembers", R.string.ChannelMembers);
                        String str6 = String.format("%d", Integer.valueOf(this.info.participants.participants.size()));
                        TextCell textCell8 = this.logCell;
                        textCell7.setTextAndValueAndIcon(string8, str6, R.drawable.actions_viewmembers, textCell8 != null && textCell8.getVisibility() == 0);
                    }
                    TLRPC$Chat tLRPC$Chat2 = this.currentChat;
                    if (tLRPC$Chat2.gigagroup) {
                        TextCell textCell9 = this.blockCell;
                        String string9 = LocaleController.getString("ChannelBlacklist", R.string.ChannelBlacklist);
                        TLRPC$ChatFull tLRPC$ChatFull8 = this.info;
                        String str7 = String.format("%d", Integer.valueOf(Math.max(tLRPC$ChatFull8.banned_count, tLRPC$ChatFull8.kicked_count)));
                        TextCell textCell10 = this.logCell;
                        textCell9.setTextAndValueAndIcon(string9, str7, R.drawable.actions_removed, textCell10 != null && textCell10.getVisibility() == 0);
                    } else {
                        TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights = tLRPC$Chat2.default_banned_rights;
                        if (tLRPC$TL_chatBannedRights != null) {
                            i = !tLRPC$TL_chatBannedRights.send_messages ? 1 : 0;
                            if (!tLRPC$TL_chatBannedRights.send_forwarded_messages) {
                                i++;
                            }
                            if (!tLRPC$TL_chatBannedRights.send_media) {
                                i++;
                            }
                            if (!tLRPC$TL_chatBannedRights.send_stickers) {
                                i++;
                            }
                            if (!tLRPC$TL_chatBannedRights.embed_links) {
                                i++;
                            }
                            if (!tLRPC$TL_chatBannedRights.view_participants) {
                                i++;
                            }
                            if (!tLRPC$TL_chatBannedRights.invite_users) {
                                i++;
                            }
                        } else {
                            i = 7;
                        }
                        this.blockCell.setTextAndValueAndIcon(LocaleController.getString("ChannelPermissions", R.string.ChannelPermissions), String.format("%d/%d", Integer.valueOf(i), 7), R.drawable.actions_permissions, true);
                    }
                }
                TextCell textCell11 = this.adminCell;
                String string10 = LocaleController.getString("ChannelAdministrators", R.string.ChannelAdministrators);
                Object[] objArr = new Object[1];
                objArr[0] = Integer.valueOf(ChatObject.isChannel(this.currentChat) ? this.info.admins_count : getAdminCount());
                textCell11.setTextAndValueAndIcon(string10, String.format("%d", objArr), R.drawable.actions_addadmin, true);
            } else {
                if (this.isChannel) {
                    textCell2.setTextAndIcon(LocaleController.getString("ChannelSubscribers", R.string.ChannelSubscribers), R.drawable.actions_viewmembers, true);
                    TextCell textCell12 = this.blockCell;
                    String string11 = LocaleController.getString("ChannelBlacklist", R.string.ChannelBlacklist);
                    TextCell textCell13 = this.logCell;
                    textCell12.setTextAndIcon(string11, R.drawable.actions_removed, textCell13 != null && textCell13.getVisibility() == 0);
                } else {
                    String string12 = LocaleController.getString("ChannelMembers", R.string.ChannelMembers);
                    TextCell textCell14 = this.logCell;
                    textCell2.setTextAndIcon(string12, R.drawable.actions_viewmembers, textCell14 != null && textCell14.getVisibility() == 0);
                    if (this.currentChat.gigagroup) {
                        TextCell textCell15 = this.blockCell;
                        String string13 = LocaleController.getString("ChannelBlacklist", R.string.ChannelBlacklist);
                        TextCell textCell16 = this.logCell;
                        textCell15.setTextAndIcon(string13, R.drawable.actions_removed, textCell16 != null && textCell16.getVisibility() == 0);
                    } else {
                        this.blockCell.setTextAndIcon(LocaleController.getString("ChannelPermissions", R.string.ChannelPermissions), R.drawable.actions_permissions, true);
                    }
                }
                this.adminCell.setTextAndIcon(LocaleController.getString("ChannelAdministrators", R.string.ChannelAdministrators), R.drawable.actions_addadmin, true);
            }
            if (this.info == null || !ChatObject.canUserDoAdminAction(this.currentChat, 3) || (!zIsEmpty && this.currentChat.creator)) {
                this.inviteLinksCell.setVisibility(8);
            } else if (this.info.invitesCount > 0) {
                this.inviteLinksCell.setTextAndValueAndIcon(LocaleController.getString("InviteLinks", R.string.InviteLinks), Integer.toString(this.info.invitesCount), R.drawable.actions_link, true);
            } else {
                this.inviteLinksCell.setTextAndValueAndIcon(LocaleController.getString("InviteLinks", R.string.InviteLinks), "1", R.drawable.actions_link, true);
            }
        }
        TextSettingsCell textSettingsCell2 = this.stickersCell;
        if (textSettingsCell2 == null || (tLRPC$ChatFull = this.info) == null) {
            return;
        }
        if (tLRPC$ChatFull.stickerset != null) {
            textSettingsCell2.setTextAndValue(LocaleController.getString("GroupStickers", R.string.GroupStickers), this.info.stickerset.title, false);
        } else {
            textSettingsCell2.setText(LocaleController.getString("GroupStickers", R.string.GroupStickers), false);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ChatEditActivity$lO_smlhG3eKybGnPv4wJ5lyjHQI
            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() {
                this.f$0.lambda$getThemeDescriptions$29$ChatEditActivity();
            }

            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public /* synthetic */ void onAnimationProgress(float f) {
                ThemeDescription.ThemeDescriptionDelegate.CC.$default$onAnimationProgress(this, f);
            }
        };
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundGray"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "actionBarDefaultIcon"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, "actionBarDefaultTitle"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "actionBarDefaultSelector"));
        arrayList.add(new ThemeDescription(this.setAvatarCell, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.setAvatarCell, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{TextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueButton"));
        arrayList.add(new ThemeDescription(this.setAvatarCell, 0, new Class[]{TextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueIcon"));
        arrayList.add(new ThemeDescription(this.membersCell, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.membersCell, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{TextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.membersCell, 0, new Class[]{TextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayIcon"));
        arrayList.add(new ThemeDescription(this.adminCell, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.adminCell, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{TextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.adminCell, 0, new Class[]{TextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayIcon"));
        arrayList.add(new ThemeDescription(this.inviteLinksCell, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.inviteLinksCell, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{TextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.inviteLinksCell, 0, new Class[]{TextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayIcon"));
        arrayList.add(new ThemeDescription(this.blockCell, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.blockCell, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{TextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.blockCell, 0, new Class[]{TextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayIcon"));
        arrayList.add(new ThemeDescription(this.logCell, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.logCell, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{TextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.logCell, 0, new Class[]{TextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayIcon"));
        arrayList.add(new ThemeDescription(this.typeCell, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.typeCell, 0, new Class[]{TextDetailCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.typeCell, 0, new Class[]{TextDetailCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText2"));
        arrayList.add(new ThemeDescription(this.historyCell, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.historyCell, 0, new Class[]{TextDetailCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.historyCell, 0, new Class[]{TextDetailCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText2"));
        arrayList.add(new ThemeDescription(this.locationCell, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.locationCell, 0, new Class[]{TextDetailCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.locationCell, 0, new Class[]{TextDetailCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText2"));
        arrayList.add(new ThemeDescription(this.nameTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.nameTextView, ThemeDescription.FLAG_HINTTEXTCOLOR, null, null, null, null, "windowBackgroundWhiteHintText"));
        arrayList.add(new ThemeDescription(this.nameTextView, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "windowBackgroundWhiteInputField"));
        arrayList.add(new ThemeDescription(this.nameTextView, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, null, null, null, null, "windowBackgroundWhiteInputFieldActivated"));
        arrayList.add(new ThemeDescription(this.descriptionTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.descriptionTextView, ThemeDescription.FLAG_HINTTEXTCOLOR, null, null, null, null, "windowBackgroundWhiteHintText"));
        arrayList.add(new ThemeDescription(this.avatarContainer, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.settingsContainer, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.typeEditContainer, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.deleteContainer, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.stickersContainer, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.infoContainer, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.settingsTopSectionCell, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ShadowSectionCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.settingsSectionCell, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ShadowSectionCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.deleteInfoCell, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ShadowSectionCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.infoSectionCell, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ShadowSectionCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.container5, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.signCell, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.signCell, 0, new Class[]{TextCheckCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.signCell, 0, new Class[]{TextCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "switchTrack"));
        arrayList.add(new ThemeDescription(this.signCell, 0, new Class[]{TextCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "switchTrackChecked"));
        arrayList.add(new ThemeDescription(this.textCheckCell2, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.textCheckCell2, 0, new Class[]{TextCheckCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.textCheckCell2, 0, new Class[]{TextCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "switchThumb"));
        arrayList.add(new ThemeDescription(this.textCheckCell2, 0, new Class[]{TextCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "switchTrack"));
        arrayList.add(new ThemeDescription(this.textCheckCell2, 0, new Class[]{TextCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "switchThumbChecked"));
        arrayList.add(new ThemeDescription(this.textCheckCell2, 0, new Class[]{TextCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "switchTrackChecked"));
        arrayList.add(new ThemeDescription(this.infoCheckCell2, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.infoCheckCell2, 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText4"));
        arrayList.add(new ThemeDescription(this.deleteCell, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.deleteCell, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteRedText5"));
        arrayList.add(new ThemeDescription(this.stickersCell, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.stickersCell, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.stickersInfoCell3, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.stickersInfoCell3, 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText4"));
        arrayList.add(new ThemeDescription(null, 0, null, null, Theme.avatarDrawables, themeDescriptionDelegate, "avatar_text"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundRed"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundOrange"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundViolet"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundGreen"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundCyan"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundBlue"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundPink"));
        arrayList.add(new ThemeDescription(this.undoView, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "undo_background"));
        arrayList.add(new ThemeDescription(this.undoView, 0, new Class[]{UndoView.class}, new String[]{"undoImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "undo_cancelColor"));
        arrayList.add(new ThemeDescription(this.undoView, 0, new Class[]{UndoView.class}, new String[]{"undoTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "undo_cancelColor"));
        arrayList.add(new ThemeDescription(this.undoView, 0, new Class[]{UndoView.class}, new String[]{"infoTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "undo_infoColor"));
        arrayList.add(new ThemeDescription(this.undoView, 0, new Class[]{UndoView.class}, new String[]{"textPaint"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "undo_infoColor"));
        arrayList.add(new ThemeDescription(this.undoView, 0, new Class[]{UndoView.class}, new String[]{"progressPaint"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "undo_infoColor"));
        arrayList.add(new ThemeDescription(this.undoView, ThemeDescription.FLAG_IMAGECOLOR, new Class[]{UndoView.class}, new String[]{"leftImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "undo_infoColor"));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getThemeDescriptions$29, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getThemeDescriptions$29$ChatEditActivity() {
        BackupImageView backupImageView = this.avatarImage;
        if (backupImageView != null) {
            backupImageView.invalidate();
        }
    }
}
