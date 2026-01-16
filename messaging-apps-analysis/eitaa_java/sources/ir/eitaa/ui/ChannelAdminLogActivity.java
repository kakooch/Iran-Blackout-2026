package ir.eitaa.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.text.style.URLSpan;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.collection.LongSparseArray;
import androidx.recyclerview.widget.ChatListItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScrollerCustom;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.BuildVars;
import ir.eitaa.messenger.ChatObject;
import ir.eitaa.messenger.ContactsController;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MediaController;
import ir.eitaa.messenger.MediaDataController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.MessagesStorage;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SendMessagesHelper;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.messenger.browser.Browser;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$ChannelParticipant;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$ChatFull;
import ir.eitaa.tgnet.TLRPC$FileLocation;
import ir.eitaa.tgnet.TLRPC$InputStickerSet;
import ir.eitaa.tgnet.TLRPC$KeyboardButton;
import ir.eitaa.tgnet.TLRPC$Message;
import ir.eitaa.tgnet.TLRPC$MessageMedia;
import ir.eitaa.tgnet.TLRPC$PhotoSize;
import ir.eitaa.tgnet.TLRPC$TL_channelAdminLogEvent;
import ir.eitaa.tgnet.TLRPC$TL_channelAdminLogEventActionExportedInviteDelete;
import ir.eitaa.tgnet.TLRPC$TL_channelAdminLogEventActionExportedInviteEdit;
import ir.eitaa.tgnet.TLRPC$TL_channelAdminLogEventActionExportedInviteRevoke;
import ir.eitaa.tgnet.TLRPC$TL_channelAdminLogEventsFilter;
import ir.eitaa.tgnet.TLRPC$TL_channelParticipantsAdmins;
import ir.eitaa.tgnet.TLRPC$TL_channels_adminLogResults;
import ir.eitaa.tgnet.TLRPC$TL_channels_channelParticipants;
import ir.eitaa.tgnet.TLRPC$TL_channels_getAdminLog;
import ir.eitaa.tgnet.TLRPC$TL_channels_getParticipants;
import ir.eitaa.tgnet.TLRPC$TL_chatInviteExported;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_inputStickerSetID;
import ir.eitaa.tgnet.TLRPC$TL_inputStickerSetShortName;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaPhoto;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaWebPage;
import ir.eitaa.tgnet.TLRPC$TL_messages_exportedChatInvite;
import ir.eitaa.tgnet.TLRPC$TL_messages_getExportedChatInvite;
import ir.eitaa.tgnet.TLRPC$TL_reactionCount;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$UserFull;
import ir.eitaa.tgnet.TLRPC$WebPage;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.ActionBarMenuItem;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BackDrawable;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.BottomSheet;
import ir.eitaa.ui.ActionBar.SimpleTextView;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.AvatarPreviewer;
import ir.eitaa.ui.Cells.ChatActionCell;
import ir.eitaa.ui.Cells.ChatLoadingCell;
import ir.eitaa.ui.Cells.ChatMessageCell;
import ir.eitaa.ui.Cells.ChatUnreadCell;
import ir.eitaa.ui.Cells.TextSelectionHelper;
import ir.eitaa.ui.Components.AdminLogFilterAlert;
import ir.eitaa.ui.Components.AlertsCreator;
import ir.eitaa.ui.Components.BulletinFactory;
import ir.eitaa.ui.Components.ChatAvatarContainer;
import ir.eitaa.ui.Components.EmbedBottomSheet;
import ir.eitaa.ui.Components.InviteLinkBottomSheet;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.PhonebookShareAlert;
import ir.eitaa.ui.Components.PipRoundVideoView;
import ir.eitaa.ui.Components.RadialProgressView;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.Components.ShareAlert;
import ir.eitaa.ui.Components.SizeNotifierFrameLayout;
import ir.eitaa.ui.Components.URLSpanMono;
import ir.eitaa.ui.Components.URLSpanNoUnderline;
import ir.eitaa.ui.Components.URLSpanReplacement;
import ir.eitaa.ui.Components.URLSpanUserMention;
import ir.eitaa.ui.Components.UndoView;
import ir.eitaa.ui.PhotoViewer;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class ChannelAdminLogActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private ArrayList<TLRPC$ChannelParticipant> admins;
    private int allowAnimationIndex;
    private Paint aspectPaint;
    private Path aspectPath;
    private AspectRatioFrameLayout aspectRatioFrameLayout;
    private ChatAvatarContainer avatarContainer;
    private FrameLayout bottomOverlayChat;
    private TextView bottomOverlayChatText;
    private ImageView bottomOverlayImage;
    private ChatActivityAdapter chatAdapter;
    private LinearLayoutManager chatLayoutManager;
    private ChatListItemAnimator chatListItemAnimator;
    private RecyclerListView chatListView;
    private boolean checkTextureViewPosition;
    private SizeNotifierFrameLayout contentView;
    protected TLRPC$Chat currentChat;
    private boolean currentFloatingDateOnScreen;
    private boolean currentFloatingTopIsNotMessage;
    private TextView emptyView;
    private FrameLayout emptyViewContainer;
    private boolean endReached;
    private AnimatorSet floatingDateAnimation;
    private ChatActionCell floatingDateView;
    private boolean linviteLoading;
    private boolean loading;
    private int loadsCount;
    private long minEventId;
    private boolean openAnimationEnded;
    private RadialProgressView progressBar;
    private FrameLayout progressView;
    private View progressView2;
    private FrameLayout roundVideoContainer;
    private boolean scrollingFloatingDate;
    private ImageView searchCalendarButton;
    private FrameLayout searchContainer;
    private SimpleTextView searchCountText;
    private ActionBarMenuItem searchItem;
    private boolean searchWas;
    private LongSparseArray<TLRPC$User> selectedAdmins;
    private MessageObject selectedObject;
    private UndoView undoView;
    private HashMap<Long, TLRPC$User> usersMap;
    private TextureView videoTextureView;
    private ArrayList<ChatMessageCell> chatMessageCellsCache = new ArrayList<>();
    private int[] mid = {2};
    private int scrollToPositionOnRecreate = -1;
    private int scrollToOffsetOnRecreate = 0;
    private boolean paused = true;
    private boolean wasPaused = false;
    private LongSparseArray<MessageObject> messagesDict = new LongSparseArray<>();
    private HashMap<String, ArrayList<MessageObject>> messagesByDays = new HashMap<>();
    protected ArrayList<MessageObject> messages = new ArrayList<>();
    private TLRPC$TL_channelAdminLogEventsFilter currentFilter = null;
    private String searchQuery = "";
    private HashMap<String, Object> invitesCache = new HashMap<>();
    private PhotoViewer.PhotoViewerProvider provider = new PhotoViewer.EmptyPhotoViewerProvider() { // from class: ir.eitaa.ui.ChannelAdminLogActivity.1
        @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public PhotoViewer.PlaceProviderObject getPlaceForPhoto(MessageObject messageObject, TLRPC$FileLocation fileLocation, int index, boolean needPreview) {
            ChatActionCell chatActionCell;
            MessageObject messageObject2;
            ChatMessageCell chatMessageCell;
            MessageObject messageObject3;
            int childCount = ChannelAdminLogActivity.this.chatListView.getChildCount();
            int i = 0;
            while (true) {
                ImageReceiver photoImage = null;
                if (i >= childCount) {
                    return null;
                }
                View childAt = ChannelAdminLogActivity.this.chatListView.getChildAt(i);
                if (childAt instanceof ChatMessageCell) {
                    if (messageObject != null && (messageObject3 = (chatMessageCell = (ChatMessageCell) childAt).getMessageObject()) != null && messageObject3.getId() == messageObject.getId()) {
                        photoImage = chatMessageCell.getPhotoImage();
                    }
                } else if ((childAt instanceof ChatActionCell) && (messageObject2 = (chatActionCell = (ChatActionCell) childAt).getMessageObject()) != null) {
                    if (messageObject != null) {
                        if (messageObject2.getId() == messageObject.getId()) {
                            photoImage = chatActionCell.getPhotoImage();
                        }
                    } else if (fileLocation != null && messageObject2.photoThumbs != null) {
                        int i2 = 0;
                        while (true) {
                            if (i2 >= messageObject2.photoThumbs.size()) {
                                break;
                            }
                            TLRPC$FileLocation tLRPC$FileLocation = messageObject2.photoThumbs.get(i2).location;
                            if (tLRPC$FileLocation.volume_id == fileLocation.volume_id && tLRPC$FileLocation.local_id == fileLocation.local_id) {
                                photoImage = chatActionCell.getPhotoImage();
                                break;
                            }
                            i2++;
                        }
                    }
                }
                if (photoImage != null) {
                    int[] iArr = new int[2];
                    childAt.getLocationInWindow(iArr);
                    PhotoViewer.PlaceProviderObject placeProviderObject = new PhotoViewer.PlaceProviderObject();
                    placeProviderObject.viewX = iArr[0];
                    placeProviderObject.viewY = iArr[1] - (Build.VERSION.SDK_INT < 21 ? AndroidUtilities.statusBarHeight : 0);
                    placeProviderObject.parentView = ChannelAdminLogActivity.this.chatListView;
                    placeProviderObject.imageReceiver = photoImage;
                    placeProviderObject.thumb = photoImage.getBitmapSafe();
                    placeProviderObject.radius = photoImage.getRoundRadius();
                    placeProviderObject.isEvent = true;
                    return placeProviderObject;
                }
                i++;
            }
        }
    };

    static /* synthetic */ boolean lambda$createView$2(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBottomOverlay() {
    }

    public ChannelAdminLogActivity(TLRPC$Chat chat) {
        this.currentChat = chat;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        super.onFragmentCreate();
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.emojiLoaded);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.messagePlayingDidStart);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.messagePlayingPlayStateChanged);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.messagePlayingDidReset);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.messagePlayingProgressDidChanged);
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.didSetNewWallpapper);
        loadMessages(true);
        loadAdmins();
        return true;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() throws InterruptedException {
        super.onFragmentDestroy();
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.emojiLoaded);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.messagePlayingDidStart);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.messagePlayingPlayStateChanged);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.messagePlayingDidReset);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.messagePlayingProgressDidChanged);
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.didSetNewWallpapper);
        getNotificationCenter().onAnimationFinish(this.allowAnimationIndex);
    }

    private void updateEmptyPlaceholder() {
        if (this.emptyView == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.searchQuery)) {
            this.emptyView.setPadding(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(5.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(5.0f));
            this.emptyView.setText(AndroidUtilities.replaceTags(LocaleController.formatString("EventLogEmptyTextSearch", R.string.EventLogEmptyTextSearch, this.searchQuery)));
        } else {
            if (this.selectedAdmins != null || this.currentFilter != null) {
                this.emptyView.setPadding(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(5.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(5.0f));
                this.emptyView.setText(AndroidUtilities.replaceTags(LocaleController.getString("EventLogEmptySearch", R.string.EventLogEmptySearch)));
                return;
            }
            this.emptyView.setPadding(AndroidUtilities.dp(16.0f), AndroidUtilities.dp(16.0f), AndroidUtilities.dp(16.0f), AndroidUtilities.dp(16.0f));
            if (this.currentChat.megagroup) {
                this.emptyView.setText(AndroidUtilities.replaceTags(LocaleController.getString("EventLogEmpty", R.string.EventLogEmpty)));
            } else {
                this.emptyView.setText(AndroidUtilities.replaceTags(LocaleController.getString("EventLogEmptyChannel", R.string.EventLogEmptyChannel)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadMessages(boolean reset) {
        ChatActivityAdapter chatActivityAdapter;
        if (this.loading) {
            return;
        }
        if (reset) {
            this.minEventId = Long.MAX_VALUE;
            FrameLayout frameLayout = this.progressView;
            if (frameLayout != null) {
                AndroidUtilities.updateViewVisibilityAnimated(frameLayout, true, 0.3f, true);
                this.emptyViewContainer.setVisibility(4);
                this.chatListView.setEmptyView(null);
            }
            this.messagesDict.clear();
            this.messages.clear();
            this.messagesByDays.clear();
        }
        this.loading = true;
        TLRPC$TL_channels_getAdminLog tLRPC$TL_channels_getAdminLog = new TLRPC$TL_channels_getAdminLog();
        tLRPC$TL_channels_getAdminLog.channel = MessagesController.getInputChannel(this.currentChat);
        tLRPC$TL_channels_getAdminLog.q = this.searchQuery;
        tLRPC$TL_channels_getAdminLog.limit = 50;
        if (!reset && !this.messages.isEmpty()) {
            tLRPC$TL_channels_getAdminLog.max_id = this.minEventId;
        } else {
            tLRPC$TL_channels_getAdminLog.max_id = 0L;
        }
        tLRPC$TL_channels_getAdminLog.min_id = 0L;
        TLRPC$TL_channelAdminLogEventsFilter tLRPC$TL_channelAdminLogEventsFilter = this.currentFilter;
        if (tLRPC$TL_channelAdminLogEventsFilter != null) {
            tLRPC$TL_channels_getAdminLog.flags = 1 | tLRPC$TL_channels_getAdminLog.flags;
            tLRPC$TL_channels_getAdminLog.events_filter = tLRPC$TL_channelAdminLogEventsFilter;
        }
        if (this.selectedAdmins != null) {
            tLRPC$TL_channels_getAdminLog.flags |= 2;
            for (int i = 0; i < this.selectedAdmins.size(); i++) {
                tLRPC$TL_channels_getAdminLog.admins.add(MessagesController.getInstance(this.currentAccount).getInputUser(this.selectedAdmins.valueAt(i)));
            }
        }
        updateEmptyPlaceholder();
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_channels_getAdminLog, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ChannelAdminLogActivity$f0Kx8Mriq1FkySQuWDMLl1L6xN0
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadMessages$1$ChannelAdminLogActivity(tLObject, tLRPC$TL_error);
            }
        });
        if (!reset || (chatActivityAdapter = this.chatAdapter) == null) {
            return;
        }
        chatActivityAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadMessages$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadMessages$1$ChannelAdminLogActivity(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            final TLRPC$TL_channels_adminLogResults tLRPC$TL_channels_adminLogResults = (TLRPC$TL_channels_adminLogResults) tLObject;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ChannelAdminLogActivity$DQGfhJc8ohIQHVsqrWaUR3EQ7I8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadMessages$0$ChannelAdminLogActivity(tLRPC$TL_channels_adminLogResults);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0055  */
    /* renamed from: lambda$loadMessages$0, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$loadMessages$0$ChannelAdminLogActivity(ir.eitaa.tgnet.TLRPC$TL_channels_adminLogResults r15) {
        /*
            Method dump skipped, instructions count: 238
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ChannelAdminLogActivity.lambda$loadMessages$0$ChannelAdminLogActivity(ir.eitaa.tgnet.TLRPC$TL_channels_adminLogResults):void");
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment, ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        ChatMessageCell chatMessageCell;
        MessageObject messageObject;
        ChatMessageCell chatMessageCell2;
        MessageObject messageObject2;
        ChatMessageCell chatMessageCell3;
        MessageObject messageObject3;
        if (id == NotificationCenter.emojiLoaded) {
            RecyclerListView recyclerListView = this.chatListView;
            if (recyclerListView != null) {
                recyclerListView.invalidateViews();
                return;
            }
            return;
        }
        if (id == NotificationCenter.messagePlayingDidStart) {
            if (((MessageObject) args[0]).isRoundVideo()) {
                MediaController.getInstance().setTextureView(createTextureView(true), this.aspectRatioFrameLayout, this.roundVideoContainer, true);
                updateTextureViewPosition();
            }
            RecyclerListView recyclerListView2 = this.chatListView;
            if (recyclerListView2 != null) {
                int childCount = recyclerListView2.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.chatListView.getChildAt(i);
                    if ((childAt instanceof ChatMessageCell) && (messageObject3 = (chatMessageCell3 = (ChatMessageCell) childAt).getMessageObject()) != null) {
                        if (messageObject3.isVoice() || messageObject3.isMusic()) {
                            chatMessageCell3.updateButtonState(false, true, false);
                        } else if (messageObject3.isRoundVideo()) {
                            chatMessageCell3.checkVideoPlayback(false, null);
                            if (!MediaController.getInstance().isPlayingMessage(messageObject3) && messageObject3.audioProgress != 0.0f) {
                                messageObject3.resetPlayingProgress();
                                chatMessageCell3.invalidate();
                            }
                        }
                    }
                }
                return;
            }
            return;
        }
        if (id == NotificationCenter.messagePlayingDidReset || id == NotificationCenter.messagePlayingPlayStateChanged) {
            RecyclerListView recyclerListView3 = this.chatListView;
            if (recyclerListView3 != null) {
                int childCount2 = recyclerListView3.getChildCount();
                for (int i2 = 0; i2 < childCount2; i2++) {
                    View childAt2 = this.chatListView.getChildAt(i2);
                    if ((childAt2 instanceof ChatMessageCell) && (messageObject = (chatMessageCell = (ChatMessageCell) childAt2).getMessageObject()) != null) {
                        if (messageObject.isVoice() || messageObject.isMusic()) {
                            chatMessageCell.updateButtonState(false, true, false);
                        } else if (messageObject.isRoundVideo() && !MediaController.getInstance().isPlayingMessage(messageObject)) {
                            chatMessageCell.checkVideoPlayback(true, null);
                        }
                    }
                }
                return;
            }
            return;
        }
        if (id == NotificationCenter.messagePlayingProgressDidChanged) {
            Integer num = (Integer) args[0];
            RecyclerListView recyclerListView4 = this.chatListView;
            if (recyclerListView4 != null) {
                int childCount3 = recyclerListView4.getChildCount();
                for (int i3 = 0; i3 < childCount3; i3++) {
                    View childAt3 = this.chatListView.getChildAt(i3);
                    if ((childAt3 instanceof ChatMessageCell) && (messageObject2 = (chatMessageCell2 = (ChatMessageCell) childAt3).getMessageObject()) != null && messageObject2.getId() == num.intValue()) {
                        MessageObject playingMessageObject = MediaController.getInstance().getPlayingMessageObject();
                        if (playingMessageObject != null) {
                            messageObject2.audioProgress = playingMessageObject.audioProgress;
                            messageObject2.audioProgressSec = playingMessageObject.audioProgressSec;
                            messageObject2.audioPlayerDuration = playingMessageObject.audioPlayerDuration;
                            chatMessageCell2.updatePlayingMessageProgress();
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            return;
        }
        if (id != NotificationCenter.didSetNewWallpapper || this.fragmentView == null) {
            return;
        }
        this.contentView.setBackgroundImage(Theme.getCachedWallpaper(), Theme.isWallpaperMotion());
        this.progressView2.invalidate();
        TextView textView = this.emptyView;
        if (textView != null) {
            textView.invalidate();
        }
        this.chatListView.invalidateViews();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(Context context) throws Resources.NotFoundException {
        if (this.chatMessageCellsCache.isEmpty()) {
            for (int i = 0; i < 8; i++) {
                this.chatMessageCellsCache.add(new ChatMessageCell(context));
            }
        }
        this.searchWas = false;
        this.hasOwnBackground = true;
        Theme.createChatResources(context, false);
        this.actionBar.setAddToContainer(false);
        this.actionBar.setOccupyStatusBar(Build.VERSION.SDK_INT >= 21 && !AndroidUtilities.isTablet());
        this.actionBar.setBackButtonDrawable(new BackDrawable(false));
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.eitaa.ui.ChannelAdminLogActivity.2
            @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(final int id) {
                if (id == -1) {
                    ChannelAdminLogActivity.this.finishFragment();
                }
            }
        });
        ChatAvatarContainer chatAvatarContainer = new ChatAvatarContainer(context, null, false);
        this.avatarContainer = chatAvatarContainer;
        chatAvatarContainer.setOccupyStatusBar(!AndroidUtilities.isTablet());
        this.actionBar.addView(this.avatarContainer, 0, LayoutHelper.createFrame(-2, -1.0f, 51, 56.0f, 0.0f, 40.0f, 0.0f));
        ActionBarMenuItem actionBarMenuItemSearchListener = this.actionBar.createMenu().addItem(0, R.drawable.ic_ab_search).setIsSearchField(true).setActionBarMenuItemSearchListener(new ActionBarMenuItem.ActionBarMenuItemSearchListener() { // from class: ir.eitaa.ui.ChannelAdminLogActivity.3
            @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
            public void onSearchCollapse() {
                ChannelAdminLogActivity.this.searchQuery = "";
                ChannelAdminLogActivity.this.avatarContainer.setVisibility(0);
                if (ChannelAdminLogActivity.this.searchWas) {
                    ChannelAdminLogActivity.this.searchWas = false;
                    ChannelAdminLogActivity.this.loadMessages(true);
                }
                ChannelAdminLogActivity.this.updateBottomOverlay();
            }

            @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
            public void onSearchExpand() {
                ChannelAdminLogActivity.this.avatarContainer.setVisibility(8);
                ChannelAdminLogActivity.this.updateBottomOverlay();
            }

            @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
            public void onSearchPressed(EditText editText) {
                ChannelAdminLogActivity.this.searchWas = true;
                ChannelAdminLogActivity.this.searchQuery = editText.getText().toString();
                ChannelAdminLogActivity.this.loadMessages(true);
            }
        });
        this.searchItem = actionBarMenuItemSearchListener;
        actionBarMenuItemSearchListener.setSearchFieldHint(LocaleController.getString("Search", R.string.Search));
        this.avatarContainer.setEnabled(false);
        this.avatarContainer.setTitle(this.currentChat.title);
        this.avatarContainer.setSubtitle(LocaleController.getString("EventLogAllEvents", R.string.EventLogAllEvents));
        this.avatarContainer.setChatAvatar(this.currentChat);
        SizeNotifierFrameLayout sizeNotifierFrameLayout = new SizeNotifierFrameLayout(context) { // from class: ir.eitaa.ui.ChannelAdminLogActivity.4
            @Override // android.view.ViewGroup, android.view.View
            protected void onAttachedToWindow() {
                super.onAttachedToWindow();
                MessageObject playingMessageObject = MediaController.getInstance().getPlayingMessageObject();
                if (playingMessageObject == null || !playingMessageObject.isRoundVideo() || playingMessageObject.eventId == 0 || playingMessageObject.getDialogId() != (-ChannelAdminLogActivity.this.currentChat.id)) {
                    return;
                }
                MediaController.getInstance().setTextureView(ChannelAdminLogActivity.this.createTextureView(false), ChannelAdminLogActivity.this.aspectRatioFrameLayout, ChannelAdminLogActivity.this.roundVideoContainer, true);
            }

            @Override // android.view.ViewGroup
            protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
                boolean zDrawChild = super.drawChild(canvas, child, drawingTime);
                if (child == ((BaseFragment) ChannelAdminLogActivity.this).actionBar && ((BaseFragment) ChannelAdminLogActivity.this).parentLayout != null) {
                    ((BaseFragment) ChannelAdminLogActivity.this).parentLayout.drawHeaderShadow(canvas, ((BaseFragment) ChannelAdminLogActivity.this).actionBar.getVisibility() == 0 ? ((BaseFragment) ChannelAdminLogActivity.this).actionBar.getMeasuredHeight() : 0);
                }
                return zDrawChild;
            }

            @Override // ir.eitaa.ui.Components.SizeNotifierFrameLayout
            protected boolean isActionBarVisible() {
                return ((BaseFragment) ChannelAdminLogActivity.this).actionBar.getVisibility() == 0;
            }

            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                int size = View.MeasureSpec.getSize(widthMeasureSpec);
                int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
                setMeasuredDimension(size, size2);
                int paddingTop = size2 - getPaddingTop();
                measureChildWithMargins(((BaseFragment) ChannelAdminLogActivity.this).actionBar, widthMeasureSpec, 0, heightMeasureSpec, 0);
                int measuredHeight = ((BaseFragment) ChannelAdminLogActivity.this).actionBar.getMeasuredHeight();
                if (((BaseFragment) ChannelAdminLogActivity.this).actionBar.getVisibility() == 0) {
                    paddingTop -= measuredHeight;
                }
                int childCount = getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = getChildAt(i2);
                    if (childAt != null && childAt.getVisibility() != 8 && childAt != ((BaseFragment) ChannelAdminLogActivity.this).actionBar) {
                        if (childAt != ChannelAdminLogActivity.this.chatListView && childAt != ChannelAdminLogActivity.this.progressView) {
                            if (childAt == ChannelAdminLogActivity.this.emptyViewContainer) {
                                childAt.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824));
                            } else {
                                measureChildWithMargins(childAt, widthMeasureSpec, 0, heightMeasureSpec, 0);
                            }
                        } else {
                            childAt.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(Math.max(AndroidUtilities.dp(10.0f), paddingTop - AndroidUtilities.dp(50.0f)), 1073741824));
                        }
                    }
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:20:0x004e  */
            /* JADX WARN: Removed duplicated region for block: B:31:0x0086  */
            /* JADX WARN: Removed duplicated region for block: B:35:0x009a  */
            /* JADX WARN: Removed duplicated region for block: B:40:0x00bc  */
            @Override // ir.eitaa.ui.Components.SizeNotifierFrameLayout, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
                /*
                    Method dump skipped, instructions count: 219
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ChannelAdminLogActivity.AnonymousClass4.onLayout(boolean, int, int, int, int):void");
            }

            @Override // android.view.ViewGroup, android.view.View
            public boolean dispatchTouchEvent(MotionEvent ev) {
                if (AvatarPreviewer.hasVisibleInstance()) {
                    AvatarPreviewer.getInstance().onTouchEvent(ev);
                    return true;
                }
                return super.dispatchTouchEvent(ev);
            }
        };
        this.fragmentView = sizeNotifierFrameLayout;
        SizeNotifierFrameLayout sizeNotifierFrameLayout2 = sizeNotifierFrameLayout;
        this.contentView = sizeNotifierFrameLayout2;
        sizeNotifierFrameLayout2.setOccupyStatusBar(!AndroidUtilities.isTablet());
        this.contentView.setBackgroundImage(Theme.getCachedWallpaper(), Theme.isWallpaperMotion());
        FrameLayout frameLayout = new FrameLayout(context);
        this.emptyViewContainer = frameLayout;
        frameLayout.setVisibility(4);
        this.contentView.addView(this.emptyViewContainer, LayoutHelper.createFrame(-1, -2, 17));
        this.emptyViewContainer.setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.-$$Lambda$ChannelAdminLogActivity$fLPxZiShjdhhbeJiZa87ZtcgNl0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return ChannelAdminLogActivity.lambda$createView$2(view, motionEvent);
            }
        });
        TextView textView = new TextView(context);
        this.emptyView = textView;
        textView.setTextSize(1, 14.0f);
        this.emptyView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.emptyView.setGravity(17);
        this.emptyView.setTextColor(Theme.getColor("chat_serviceText"));
        this.emptyView.setBackground(Theme.createServiceDrawable(AndroidUtilities.dp(6.0f), this.emptyView, this.contentView));
        this.emptyView.setPadding(AndroidUtilities.dp(16.0f), AndroidUtilities.dp(16.0f), AndroidUtilities.dp(16.0f), AndroidUtilities.dp(16.0f));
        this.emptyViewContainer.addView(this.emptyView, LayoutHelper.createFrame(-2, -2.0f, 17, 16.0f, 0.0f, 16.0f, 0.0f));
        RecyclerListView recyclerListView = new RecyclerListView(context) { // from class: ir.eitaa.ui.ChannelAdminLogActivity.5
            @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
            public boolean drawChild(Canvas canvas, View child, long drawingTime) {
                ChatMessageCell chatMessageCell;
                ImageReceiver avatarImage;
                int y;
                int adapterPosition;
                boolean zDrawChild = super.drawChild(canvas, child, drawingTime);
                if ((child instanceof ChatMessageCell) && (avatarImage = (chatMessageCell = (ChatMessageCell) child).getAvatarImage()) != null) {
                    if (chatMessageCell.getMessageObject().deleted) {
                        avatarImage.setVisible(false, false);
                        return zDrawChild;
                    }
                    int y2 = (int) child.getY();
                    if (chatMessageCell.drawPinnedBottom() && (adapterPosition = ChannelAdminLogActivity.this.chatListView.getChildViewHolder(child).getAdapterPosition()) >= 0) {
                        if (ChannelAdminLogActivity.this.chatListView.findViewHolderForAdapterPosition(adapterPosition + 1) != null) {
                            avatarImage.setVisible(false, false);
                            return zDrawChild;
                        }
                    }
                    float slidingOffsetX = chatMessageCell.getSlidingOffsetX() + chatMessageCell.getCheckBoxTranslation();
                    int y3 = ((int) child.getY()) + chatMessageCell.getLayoutHeight();
                    int measuredHeight = ChannelAdminLogActivity.this.chatListView.getMeasuredHeight() - ChannelAdminLogActivity.this.chatListView.getPaddingBottom();
                    if (y3 > measuredHeight) {
                        y3 = measuredHeight;
                    }
                    if (chatMessageCell.drawPinnedTop() && (adapterPosition = ChannelAdminLogActivity.this.chatListView.getChildViewHolder(child).getAdapterPosition()) >= 0) {
                        int i2 = 0;
                        while (i2 < 20) {
                            i2++;
                            int adapterPosition2 = adapterPosition2 - 1;
                            RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = ChannelAdminLogActivity.this.chatListView.findViewHolderForAdapterPosition(adapterPosition2);
                            if (viewHolderFindViewHolderForAdapterPosition == null) {
                                break;
                            }
                            y2 = viewHolderFindViewHolderForAdapterPosition.itemView.getTop();
                            View view = viewHolderFindViewHolderForAdapterPosition.itemView;
                            if (!(view instanceof ChatMessageCell)) {
                                break;
                            }
                            chatMessageCell = (ChatMessageCell) view;
                            if (!chatMessageCell.drawPinnedTop()) {
                                break;
                            }
                        }
                    }
                    if (y3 - AndroidUtilities.dp(48.0f) < y2) {
                        y3 = y2 + AndroidUtilities.dp(48.0f);
                    }
                    if (!chatMessageCell.drawPinnedBottom() && y3 > (y = (int) (chatMessageCell.getY() + chatMessageCell.getMeasuredHeight()))) {
                        y3 = y;
                    }
                    canvas.save();
                    if (slidingOffsetX != 0.0f) {
                        canvas.translate(slidingOffsetX, 0.0f);
                    }
                    if (chatMessageCell.getCurrentMessagesGroup() != null && chatMessageCell.getCurrentMessagesGroup().transitionParams.backgroundChangeBounds) {
                        y3 = (int) (y3 - chatMessageCell.getTranslationY());
                    }
                    avatarImage.setImageY(y3 - AndroidUtilities.dp(44.0f));
                    if (chatMessageCell.shouldDrawAlphaLayer()) {
                        avatarImage.setAlpha(chatMessageCell.getAlpha());
                        canvas.scale(chatMessageCell.getScaleX(), chatMessageCell.getScaleY(), chatMessageCell.getX() + chatMessageCell.getPivotX(), chatMessageCell.getY() + (chatMessageCell.getHeight() >> 1));
                    } else {
                        avatarImage.setAlpha(1.0f);
                    }
                    avatarImage.setVisible(true, false);
                    avatarImage.draw(canvas);
                    canvas.restore();
                }
                return zDrawChild;
            }
        };
        this.chatListView = recyclerListView;
        recyclerListView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ChannelAdminLogActivity$xgCe6FLm22JGzF7x8VshJzZoEP8
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i2) {
                this.f$0.lambda$createView$3$ChannelAdminLogActivity(view, i2);
            }
        });
        this.chatListView.setTag(1);
        this.chatListView.setVerticalScrollBarEnabled(true);
        RecyclerListView recyclerListView2 = this.chatListView;
        ChatActivityAdapter chatActivityAdapter = new ChatActivityAdapter(context);
        this.chatAdapter = chatActivityAdapter;
        recyclerListView2.setAdapter(chatActivityAdapter);
        this.chatListView.setClipToPadding(false);
        this.chatListView.setPadding(0, AndroidUtilities.dp(4.0f), 0, AndroidUtilities.dp(3.0f));
        RecyclerListView recyclerListView3 = this.chatListView;
        AnonymousClass6 anonymousClass6 = new AnonymousClass6(null, this.chatListView, null);
        this.chatListItemAnimator = anonymousClass6;
        recyclerListView3.setItemAnimator(anonymousClass6);
        this.chatListItemAnimator.setReversePositions(true);
        this.chatListView.setLayoutAnimation(null);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context) { // from class: ir.eitaa.ui.ChannelAdminLogActivity.7
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean supportsPredictiveItemAnimations() {
                return true;
            }

            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
                LinearSmoothScrollerCustom linearSmoothScrollerCustom = new LinearSmoothScrollerCustom(recyclerView.getContext(), 0);
                linearSmoothScrollerCustom.setTargetPosition(position);
                startSmoothScroll(linearSmoothScrollerCustom);
            }
        };
        this.chatLayoutManager = linearLayoutManager;
        linearLayoutManager.setOrientation(1);
        this.chatLayoutManager.setStackFromEnd(true);
        this.chatListView.setLayoutManager(this.chatLayoutManager);
        this.contentView.addView(this.chatListView, LayoutHelper.createFrame(-1, -1.0f));
        this.chatListView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.eitaa.ui.ChannelAdminLogActivity.8
            private float totalDy = 0.0f;
            private final int scrollValue = AndroidUtilities.dp(100.0f);

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == 1) {
                    ChannelAdminLogActivity.this.scrollingFloatingDate = true;
                    ChannelAdminLogActivity.this.checkTextureViewPosition = true;
                } else if (newState == 0) {
                    ChannelAdminLogActivity.this.scrollingFloatingDate = false;
                    ChannelAdminLogActivity.this.checkTextureViewPosition = false;
                    ChannelAdminLogActivity.this.hideFloatingDateView(true);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                ChannelAdminLogActivity.this.chatListView.invalidate();
                if (dy != 0 && ChannelAdminLogActivity.this.scrollingFloatingDate && !ChannelAdminLogActivity.this.currentFloatingTopIsNotMessage && ChannelAdminLogActivity.this.floatingDateView.getTag() == null) {
                    if (ChannelAdminLogActivity.this.floatingDateAnimation != null) {
                        ChannelAdminLogActivity.this.floatingDateAnimation.cancel();
                    }
                    ChannelAdminLogActivity.this.floatingDateView.setTag(1);
                    ChannelAdminLogActivity.this.floatingDateAnimation = new AnimatorSet();
                    ChannelAdminLogActivity.this.floatingDateAnimation.setDuration(150L);
                    ChannelAdminLogActivity.this.floatingDateAnimation.playTogether(ObjectAnimator.ofFloat(ChannelAdminLogActivity.this.floatingDateView, "alpha", 1.0f));
                    ChannelAdminLogActivity.this.floatingDateAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.ChannelAdminLogActivity.8.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animation) {
                            if (animation.equals(ChannelAdminLogActivity.this.floatingDateAnimation)) {
                                ChannelAdminLogActivity.this.floatingDateAnimation = null;
                            }
                        }
                    });
                    ChannelAdminLogActivity.this.floatingDateAnimation.start();
                }
                ChannelAdminLogActivity.this.checkScrollForLoad(true);
                ChannelAdminLogActivity.this.updateMessagesVisisblePart();
            }
        });
        int i2 = this.scrollToPositionOnRecreate;
        if (i2 != -1) {
            this.chatLayoutManager.scrollToPositionWithOffset(i2, this.scrollToOffsetOnRecreate);
            this.scrollToPositionOnRecreate = -1;
        }
        FrameLayout frameLayout2 = new FrameLayout(context);
        this.progressView = frameLayout2;
        frameLayout2.setVisibility(4);
        this.contentView.addView(this.progressView, LayoutHelper.createFrame(-1, -1, 51));
        View view = new View(context);
        this.progressView2 = view;
        view.setBackground(Theme.createServiceDrawable(AndroidUtilities.dp(18.0f), this.progressView2, this.contentView));
        this.progressView.addView(this.progressView2, LayoutHelper.createFrame(36, 36, 17));
        RadialProgressView radialProgressView = new RadialProgressView(context);
        this.progressBar = radialProgressView;
        radialProgressView.setSize(AndroidUtilities.dp(28.0f));
        this.progressBar.setProgressColor(Theme.getColor("chat_serviceText"));
        this.progressView.addView(this.progressBar, LayoutHelper.createFrame(32, 32, 17));
        ChatActionCell chatActionCell = new ChatActionCell(context);
        this.floatingDateView = chatActionCell;
        chatActionCell.setAlpha(0.0f);
        this.floatingDateView.setImportantForAccessibility(2);
        this.contentView.addView(this.floatingDateView, LayoutHelper.createFrame(-2, -2.0f, 49, 0.0f, 4.0f, 0.0f, 0.0f));
        this.contentView.addView(this.actionBar);
        FrameLayout frameLayout3 = new FrameLayout(context) { // from class: ir.eitaa.ui.ChannelAdminLogActivity.9
            @Override // android.view.View
            public void onDraw(Canvas canvas) {
                int intrinsicHeight = Theme.chat_composeShadowDrawable.getIntrinsicHeight();
                Theme.chat_composeShadowDrawable.setBounds(0, 0, getMeasuredWidth(), intrinsicHeight);
                Theme.chat_composeShadowDrawable.draw(canvas);
                canvas.drawRect(0.0f, intrinsicHeight, getMeasuredWidth(), getMeasuredHeight(), Theme.chat_composeBackgroundPaint);
            }
        };
        this.bottomOverlayChat = frameLayout3;
        frameLayout3.setWillNotDraw(false);
        this.bottomOverlayChat.setPadding(0, AndroidUtilities.dp(3.0f), 0, 0);
        this.contentView.addView(this.bottomOverlayChat, LayoutHelper.createFrame(-1, 51, 80));
        this.bottomOverlayChat.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ChannelAdminLogActivity$e9ZbouSaQzhQwS8cDDBf7wiQ5wU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$createView$5$ChannelAdminLogActivity(view2);
            }
        });
        TextView textView2 = new TextView(context);
        this.bottomOverlayChatText = textView2;
        textView2.setTextSize(1, 15.0f);
        this.bottomOverlayChatText.setTypeface(AndroidUtilities.getFontFamily(true));
        this.bottomOverlayChatText.setTextColor(Theme.getColor("chat_fieldOverlayText"));
        this.bottomOverlayChatText.setText(LocaleController.getString("SETTINGS", R.string.SETTINGS).toUpperCase());
        this.bottomOverlayChat.addView(this.bottomOverlayChatText, LayoutHelper.createFrame(-2, -2, 17));
        ImageView imageView = new ImageView(context);
        this.bottomOverlayImage = imageView;
        imageView.setImageResource(R.drawable.log_info);
        this.bottomOverlayImage.setColorFilter(new PorterDuffColorFilter(Theme.getColor("chat_fieldOverlayText"), PorterDuff.Mode.MULTIPLY));
        this.bottomOverlayImage.setScaleType(ImageView.ScaleType.CENTER);
        this.bottomOverlayChat.addView(this.bottomOverlayImage, LayoutHelper.createFrame(48, 48.0f, 53, 3.0f, 0.0f, 0.0f, 0.0f));
        this.bottomOverlayImage.setContentDescription(LocaleController.getString("BotHelp", R.string.BotHelp));
        this.bottomOverlayImage.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ChannelAdminLogActivity$K-Nc4a9PlFm9ete16R1rGFJ6eBQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$createView$6$ChannelAdminLogActivity(view2);
            }
        });
        FrameLayout frameLayout4 = new FrameLayout(context) { // from class: ir.eitaa.ui.ChannelAdminLogActivity.10
            @Override // android.view.View
            public void onDraw(Canvas canvas) {
                int intrinsicHeight = Theme.chat_composeShadowDrawable.getIntrinsicHeight();
                Theme.chat_composeShadowDrawable.setBounds(0, 0, getMeasuredWidth(), intrinsicHeight);
                Theme.chat_composeShadowDrawable.draw(canvas);
                canvas.drawRect(0.0f, intrinsicHeight, getMeasuredWidth(), getMeasuredHeight(), Theme.chat_composeBackgroundPaint);
            }
        };
        this.searchContainer = frameLayout4;
        frameLayout4.setWillNotDraw(false);
        this.searchContainer.setVisibility(4);
        this.searchContainer.setFocusable(true);
        this.searchContainer.setFocusableInTouchMode(true);
        this.searchContainer.setClickable(true);
        this.searchContainer.setPadding(0, AndroidUtilities.dp(3.0f), 0, 0);
        this.contentView.addView(this.searchContainer, LayoutHelper.createFrame(-1, 51, 80));
        ImageView imageView2 = new ImageView(context);
        this.searchCalendarButton = imageView2;
        imageView2.setScaleType(ImageView.ScaleType.CENTER);
        this.searchCalendarButton.setImageResource(R.drawable.msg_calendar);
        this.searchCalendarButton.setColorFilter(new PorterDuffColorFilter(Theme.getColor("chat_searchPanelIcons"), PorterDuff.Mode.MULTIPLY));
        this.searchContainer.addView(this.searchCalendarButton, LayoutHelper.createFrame(48, 48, 53));
        this.searchCalendarButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ChannelAdminLogActivity$XK6lmVFveqfP655GKh7KRI7EBoo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$createView$8$ChannelAdminLogActivity(view2);
            }
        });
        SimpleTextView simpleTextView = new SimpleTextView(context);
        this.searchCountText = simpleTextView;
        simpleTextView.setTextColor(Theme.getColor("chat_searchPanelText"));
        this.searchCountText.setTextSize(15);
        this.searchCountText.setTypeface(AndroidUtilities.getFontFamily(true));
        this.searchContainer.addView(this.searchCountText, LayoutHelper.createFrame(-1, -2.0f, 19, 108.0f, 0.0f, 0.0f, 0.0f));
        this.chatAdapter.updateRows();
        if (this.loading && this.messages.isEmpty()) {
            AndroidUtilities.updateViewVisibilityAnimated(this.progressView, true, 0.3f, true);
            this.chatListView.setEmptyView(null);
        } else {
            AndroidUtilities.updateViewVisibilityAnimated(this.progressView, false, 0.3f, true);
            this.chatListView.setEmptyView(this.emptyViewContainer);
        }
        this.chatListView.setAnimateEmptyView(true, 1);
        UndoView undoView = new UndoView(context);
        this.undoView = undoView;
        undoView.setAdditionalTranslationY(AndroidUtilities.dp(51.0f));
        this.contentView.addView(this.undoView, LayoutHelper.createFrame(-1, -2.0f, 83, 8.0f, 0.0f, 8.0f, 8.0f));
        updateEmptyPlaceholder();
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$3$ChannelAdminLogActivity(View view, int i) {
        createMenu(view);
    }

    /* renamed from: ir.eitaa.ui.ChannelAdminLogActivity$6, reason: invalid class name */
    class AnonymousClass6 extends ChatListItemAnimator {
        Runnable finishRunnable;
        int scrollAnimationIndex;

        AnonymousClass6(ChatActivity activity, RecyclerListView listView, Theme.ResourcesProvider resourcesProvider) {
            super(activity, listView, resourcesProvider);
            this.scrollAnimationIndex = -1;
        }

        @Override // androidx.recyclerview.widget.ChatListItemAnimator
        public void onAnimationStart() {
            if (this.scrollAnimationIndex == -1) {
                this.scrollAnimationIndex = ChannelAdminLogActivity.this.getNotificationCenter().setAnimationInProgress(this.scrollAnimationIndex, null, false);
            }
            Runnable runnable = this.finishRunnable;
            if (runnable != null) {
                AndroidUtilities.cancelRunOnUIThread(runnable);
                this.finishRunnable = null;
            }
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("admin logs chatItemAnimator disable notifications");
            }
        }

        @Override // androidx.recyclerview.widget.ChatListItemAnimator, androidx.recyclerview.widget.DefaultItemAnimator
        protected void onAllAnimationsDone() {
            super.onAllAnimationsDone();
            Runnable runnable = this.finishRunnable;
            if (runnable != null) {
                AndroidUtilities.cancelRunOnUIThread(runnable);
            }
            Runnable runnable2 = new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ChannelAdminLogActivity$6$onGYTJXPig6VwnKzvkzmpYvW9bQ
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onAllAnimationsDone$0$ChannelAdminLogActivity$6();
                }
            };
            this.finishRunnable = runnable2;
            AndroidUtilities.runOnUIThread(runnable2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onAllAnimationsDone$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onAllAnimationsDone$0$ChannelAdminLogActivity$6() {
            if (this.scrollAnimationIndex != -1) {
                ChannelAdminLogActivity.this.getNotificationCenter().onAnimationFinish(this.scrollAnimationIndex);
                this.scrollAnimationIndex = -1;
            }
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("admin logs chatItemAnimator enable notifications");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$5$ChannelAdminLogActivity(View view) {
        if (getParentActivity() == null) {
            return;
        }
        AdminLogFilterAlert adminLogFilterAlert = new AdminLogFilterAlert(getParentActivity(), this.currentFilter, this.selectedAdmins, this.currentChat.megagroup);
        adminLogFilterAlert.setCurrentAdmins(this.admins);
        adminLogFilterAlert.setAdminLogFilterAlertDelegate(new AdminLogFilterAlert.AdminLogFilterAlertDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ChannelAdminLogActivity$Q1IRS0uH9p5sRVdFE8CqUf1sd9g
            @Override // ir.eitaa.ui.Components.AdminLogFilterAlert.AdminLogFilterAlertDelegate
            public final void didSelectRights(TLRPC$TL_channelAdminLogEventsFilter tLRPC$TL_channelAdminLogEventsFilter, LongSparseArray longSparseArray) {
                this.f$0.lambda$createView$4$ChannelAdminLogActivity(tLRPC$TL_channelAdminLogEventsFilter, longSparseArray);
            }
        });
        showDialog(adminLogFilterAlert);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$4$ChannelAdminLogActivity(TLRPC$TL_channelAdminLogEventsFilter tLRPC$TL_channelAdminLogEventsFilter, LongSparseArray longSparseArray) {
        this.currentFilter = tLRPC$TL_channelAdminLogEventsFilter;
        this.selectedAdmins = longSparseArray;
        if (tLRPC$TL_channelAdminLogEventsFilter != null || longSparseArray != null) {
            this.avatarContainer.setSubtitle(LocaleController.getString("EventLogSelectedEvents", R.string.EventLogSelectedEvents));
        } else {
            this.avatarContainer.setSubtitle(LocaleController.getString("EventLogAllEvents", R.string.EventLogAllEvents));
        }
        loadMessages(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$6$ChannelAdminLogActivity(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        if (this.currentChat.megagroup) {
            builder.setMessage(AndroidUtilities.replaceTags(LocaleController.getString("EventLogInfoDetail", R.string.EventLogInfoDetail)));
        } else {
            builder.setMessage(AndroidUtilities.replaceTags(LocaleController.getString("EventLogInfoDetailChannel", R.string.EventLogInfoDetailChannel)));
        }
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
        builder.setTitle(LocaleController.getString("EventLogInfoTitle", R.string.EventLogInfoTitle));
        showDialog(builder.create());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$8$ChannelAdminLogActivity(View view) {
        if (getParentActivity() == null) {
            return;
        }
        AndroidUtilities.hideKeyboard(this.searchItem.getSearchField());
        showDialog(AlertsCreator.createCalendarPickerDialog(getParentActivity(), 1490041801000L, new MessagesStorage.IntCallback() { // from class: ir.eitaa.ui.-$$Lambda$ChannelAdminLogActivity$KuvuQzbS3L9kfzlbdVh4Lf_5Ebs
            @Override // ir.eitaa.messenger.MessagesStorage.IntCallback
            public final void run(int i) {
                this.f$0.lambda$createView$7$ChannelAdminLogActivity(i);
            }
        }, null).create());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$7$ChannelAdminLogActivity(int i) {
        loadMessages(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void createMenu(android.view.View r17) {
        /*
            Method dump skipped, instructions count: 806
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ChannelAdminLogActivity.createMenu(android.view.View):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createMenu$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createMenu$9$ChannelAdminLogActivity(ArrayList arrayList, DialogInterface dialogInterface, int i) {
        if (this.selectedObject == null || i < 0 || i >= arrayList.size()) {
            return;
        }
        processSelectedOption(((Integer) arrayList.get(i)).intValue());
    }

    private String getMessageContent(MessageObject messageObject, int previousUid, boolean name) {
        TLRPC$Chat chat;
        String str = "";
        if (name) {
            long fromChatId = messageObject.getFromChatId();
            if (previousUid != fromChatId) {
                if (fromChatId > 0) {
                    TLRPC$User user = MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(fromChatId));
                    if (user != null) {
                        str = ContactsController.formatName(user.first_name, user.last_name) + ":\n";
                    }
                } else if (fromChatId < 0 && (chat = MessagesController.getInstance(this.currentAccount).getChat(Long.valueOf(-fromChatId))) != null) {
                    str = chat.title + ":\n";
                }
            }
        }
        if (messageObject.type == 0 && messageObject.messageOwner.message != null) {
            return str + messageObject.messageOwner.message;
        }
        TLRPC$Message tLRPC$Message = messageObject.messageOwner;
        if (tLRPC$Message.media != null && tLRPC$Message.message != null) {
            return str + messageObject.messageOwner.message;
        }
        return str + ((Object) messageObject.messageText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TextureView createTextureView(boolean add) {
        if (this.parentLayout == null) {
            return null;
        }
        if (this.roundVideoContainer == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                FrameLayout frameLayout = new FrameLayout(getParentActivity()) { // from class: ir.eitaa.ui.ChannelAdminLogActivity.12
                    @Override // android.view.View
                    public void setTranslationY(float translationY) {
                        super.setTranslationY(translationY);
                        ChannelAdminLogActivity.this.contentView.invalidate();
                    }
                };
                this.roundVideoContainer = frameLayout;
                frameLayout.setOutlineProvider(new ViewOutlineProvider() { // from class: ir.eitaa.ui.ChannelAdminLogActivity.13
                    @Override // android.view.ViewOutlineProvider
                    @TargetApi(21)
                    public void getOutline(View view, Outline outline) {
                        int i = AndroidUtilities.roundMessageSize;
                        outline.setOval(0, 0, i, i);
                    }
                });
                this.roundVideoContainer.setClipToOutline(true);
            } else {
                this.roundVideoContainer = new FrameLayout(getParentActivity()) { // from class: ir.eitaa.ui.ChannelAdminLogActivity.14
                    @Override // android.view.View
                    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
                        super.onSizeChanged(w, h, oldw, oldh);
                        ChannelAdminLogActivity.this.aspectPath.reset();
                        float f = w / 2;
                        ChannelAdminLogActivity.this.aspectPath.addCircle(f, h / 2, f, Path.Direction.CW);
                        ChannelAdminLogActivity.this.aspectPath.toggleInverseFillType();
                    }

                    @Override // android.view.View
                    public void setTranslationY(float translationY) {
                        super.setTranslationY(translationY);
                        ChannelAdminLogActivity.this.contentView.invalidate();
                    }

                    @Override // android.view.View
                    public void setVisibility(int visibility) {
                        super.setVisibility(visibility);
                        if (visibility == 0) {
                            setLayerType(2, null);
                        }
                    }

                    @Override // android.view.ViewGroup, android.view.View
                    protected void dispatchDraw(Canvas canvas) {
                        super.dispatchDraw(canvas);
                        canvas.drawPath(ChannelAdminLogActivity.this.aspectPath, ChannelAdminLogActivity.this.aspectPaint);
                    }
                };
                this.aspectPath = new Path();
                Paint paint = new Paint(1);
                this.aspectPaint = paint;
                paint.setColor(-16777216);
                this.aspectPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            }
            this.roundVideoContainer.setWillNotDraw(false);
            this.roundVideoContainer.setVisibility(4);
            AspectRatioFrameLayout aspectRatioFrameLayout = new AspectRatioFrameLayout(getParentActivity());
            this.aspectRatioFrameLayout = aspectRatioFrameLayout;
            aspectRatioFrameLayout.setBackgroundColor(0);
            if (add) {
                this.roundVideoContainer.addView(this.aspectRatioFrameLayout, LayoutHelper.createFrame(-1, -1.0f));
            }
            TextureView textureView = new TextureView(getParentActivity());
            this.videoTextureView = textureView;
            textureView.setOpaque(false);
            this.aspectRatioFrameLayout.addView(this.videoTextureView, LayoutHelper.createFrame(-1, -1.0f));
        }
        if (this.roundVideoContainer.getParent() == null) {
            SizeNotifierFrameLayout sizeNotifierFrameLayout = this.contentView;
            FrameLayout frameLayout2 = this.roundVideoContainer;
            int i = AndroidUtilities.roundMessageSize;
            sizeNotifierFrameLayout.addView(frameLayout2, 1, new FrameLayout.LayoutParams(i, i));
        }
        this.roundVideoContainer.setVisibility(4);
        this.aspectRatioFrameLayout.setDrawingReady(false);
        return this.videoTextureView;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0240  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void processSelectedOption(int r11) {
        /*
            Method dump skipped, instructions count: 966
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ChannelAdminLogActivity.processSelectedOption(int):void");
    }

    private int getMessageType(MessageObject messageObject) {
        int i;
        String str;
        if (messageObject == null || (i = messageObject.type) == 6) {
            return -1;
        }
        if (i == 10 || i == 11 || i == 16) {
            return messageObject.getId() == 0 ? -1 : 1;
        }
        if (messageObject.isVoice()) {
            return 2;
        }
        if (messageObject.isSticker() || messageObject.isAnimatedSticker()) {
            TLRPC$InputStickerSet inputStickerSet = messageObject.getInputStickerSet();
            if (inputStickerSet instanceof TLRPC$TL_inputStickerSetID) {
                if (!MediaDataController.getInstance(this.currentAccount).isStickerPackInstalled(inputStickerSet.id)) {
                    return 7;
                }
            } else if ((inputStickerSet instanceof TLRPC$TL_inputStickerSetShortName) && !MediaDataController.getInstance(this.currentAccount).isStickerPackInstalled(inputStickerSet.short_name)) {
                return 7;
            }
        } else if ((!messageObject.isRoundVideo() || (messageObject.isRoundVideo() && BuildVars.DEBUG_VERSION)) && ((messageObject.messageOwner.media instanceof TLRPC$TL_messageMediaPhoto) || messageObject.getDocument() != null || messageObject.isMusic() || messageObject.isVideo())) {
            boolean z = false;
            String str2 = messageObject.messageOwner.attachPath;
            if (str2 != null && str2.length() != 0 && new File(messageObject.messageOwner.attachPath).exists()) {
                z = true;
            }
            if ((z || !FileLoader.getPathToMessage(messageObject.messageOwner).exists()) ? z : true) {
                if (messageObject.getDocument() == null || (str = messageObject.getDocument().mime_type) == null) {
                    return 4;
                }
                if (messageObject.getDocumentName().toLowerCase().endsWith("attheme")) {
                    return 10;
                }
                if (str.endsWith("/xml")) {
                    return 5;
                }
                return (str.endsWith("/png") || str.endsWith("/jpg") || str.endsWith("/jpeg")) ? 6 : 4;
            }
        } else {
            if (messageObject.type == 12) {
                return 8;
            }
            if (messageObject.isMediaEmpty()) {
                return 3;
            }
        }
        return 2;
    }

    private void loadAdmins() {
        TLRPC$TL_channels_getParticipants tLRPC$TL_channels_getParticipants = new TLRPC$TL_channels_getParticipants();
        tLRPC$TL_channels_getParticipants.channel = MessagesController.getInputChannel(this.currentChat);
        tLRPC$TL_channels_getParticipants.filter = new TLRPC$TL_channelParticipantsAdmins();
        tLRPC$TL_channels_getParticipants.offset = 0;
        tLRPC$TL_channels_getParticipants.limit = 200;
        ConnectionsManager.getInstance(this.currentAccount).bindRequestToGuid(ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_channels_getParticipants, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ChannelAdminLogActivity$WAzYEDy0GMe_lKc7SihCkDIfgMU
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadAdmins$11$ChannelAdminLogActivity(tLObject, tLRPC$TL_error);
            }
        }), this.classGuid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadAdmins$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadAdmins$11$ChannelAdminLogActivity(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ChannelAdminLogActivity$ECFgWZgI-C-82O5SMrUlCFGMFes
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadAdmins$10$ChannelAdminLogActivity(tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadAdmins$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadAdmins$10$ChannelAdminLogActivity(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
        if (tLRPC$TL_error == null) {
            TLRPC$TL_channels_channelParticipants tLRPC$TL_channels_channelParticipants = (TLRPC$TL_channels_channelParticipants) tLObject;
            getMessagesController().putUsers(tLRPC$TL_channels_channelParticipants.users, false);
            getMessagesController().putChats(tLRPC$TL_channels_channelParticipants.chats, false);
            ArrayList<TLRPC$ChannelParticipant> arrayList = tLRPC$TL_channels_channelParticipants.participants;
            this.admins = arrayList;
            Dialog dialog = this.visibleDialog;
            if (dialog instanceof AdminLogFilterAlert) {
                ((AdminLogFilterAlert) dialog).setCurrentAdmins(arrayList);
            }
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    protected void onRemoveFromParent() {
        MediaController.getInstance().setTextureView(this.videoTextureView, null, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideFloatingDateView(boolean animated) {
        if (this.floatingDateView.getTag() == null || this.currentFloatingDateOnScreen) {
            return;
        }
        if (!this.scrollingFloatingDate || this.currentFloatingTopIsNotMessage) {
            this.floatingDateView.setTag(null);
            if (animated) {
                AnimatorSet animatorSet = new AnimatorSet();
                this.floatingDateAnimation = animatorSet;
                animatorSet.setDuration(150L);
                this.floatingDateAnimation.playTogether(ObjectAnimator.ofFloat(this.floatingDateView, "alpha", 0.0f));
                this.floatingDateAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.ChannelAdminLogActivity.15
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        if (animation.equals(ChannelAdminLogActivity.this.floatingDateAnimation)) {
                            ChannelAdminLogActivity.this.floatingDateAnimation = null;
                        }
                    }
                });
                this.floatingDateAnimation.setStartDelay(500L);
                this.floatingDateAnimation.start();
                return;
            }
            AnimatorSet animatorSet2 = this.floatingDateAnimation;
            if (animatorSet2 != null) {
                animatorSet2.cancel();
                this.floatingDateAnimation = null;
            }
            this.floatingDateView.setAlpha(0.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkScrollForLoad(boolean scroll) {
        LinearLayoutManager linearLayoutManager = this.chatLayoutManager;
        if (linearLayoutManager == null || this.paused) {
            return;
        }
        int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        if ((iFindFirstVisibleItemPosition == -1 ? 0 : Math.abs(this.chatLayoutManager.findLastVisibleItemPosition() - iFindFirstVisibleItemPosition) + 1) > 0) {
            this.chatAdapter.getItemCount();
            if (iFindFirstVisibleItemPosition > (scroll ? 25 : 5) || this.loading || this.endReached) {
                return;
            }
            loadMessages(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveScrollToLastMessage() {
        if (this.chatListView == null || this.messages.isEmpty()) {
            return;
        }
        this.chatLayoutManager.scrollToPositionWithOffset(this.messages.size() - 1, (-100000) - this.chatListView.getPaddingTop());
    }

    private void updateTextureViewPosition() {
        boolean z;
        int childCount = this.chatListView.getChildCount();
        int i = 0;
        while (true) {
            if (i >= childCount) {
                z = false;
                break;
            }
            View childAt = this.chatListView.getChildAt(i);
            if (childAt instanceof ChatMessageCell) {
                ChatMessageCell chatMessageCell = (ChatMessageCell) childAt;
                MessageObject messageObject = chatMessageCell.getMessageObject();
                if (this.roundVideoContainer != null && messageObject.isRoundVideo() && MediaController.getInstance().isPlayingMessage(messageObject)) {
                    ImageReceiver photoImage = chatMessageCell.getPhotoImage();
                    this.roundVideoContainer.setTranslationX(photoImage.getImageX());
                    this.roundVideoContainer.setTranslationY(this.fragmentView.getPaddingTop() + chatMessageCell.getTop() + photoImage.getImageY());
                    this.fragmentView.invalidate();
                    this.roundVideoContainer.invalidate();
                    z = true;
                    break;
                }
            }
            i++;
        }
        if (this.roundVideoContainer != null) {
            MessageObject playingMessageObject = MediaController.getInstance().getPlayingMessageObject();
            if (!z) {
                this.roundVideoContainer.setTranslationY((-AndroidUtilities.roundMessageSize) - 100);
                this.fragmentView.invalidate();
                if (playingMessageObject == null || !playingMessageObject.isRoundVideo()) {
                    return;
                }
                if (this.checkTextureViewPosition || PipRoundVideoView.getInstance() != null) {
                    MediaController.getInstance().setCurrentVideoVisible(false);
                    return;
                }
                return;
            }
            MediaController.getInstance().setCurrentVideoVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMessagesVisisblePart() {
        boolean z;
        MessageObject messageObject;
        RecyclerListView recyclerListView = this.chatListView;
        if (recyclerListView == null) {
            return;
        }
        int childCount = recyclerListView.getChildCount();
        int measuredHeight = this.chatListView.getMeasuredHeight();
        int i = ConnectionsManager.DEFAULT_DATACENTER_ID;
        int i2 = ConnectionsManager.DEFAULT_DATACENTER_ID;
        boolean z2 = false;
        View view = null;
        View view2 = null;
        View view3 = null;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.chatListView.getChildAt(i3);
            if (childAt instanceof ChatMessageCell) {
                ChatMessageCell chatMessageCell = (ChatMessageCell) childAt;
                int top = chatMessageCell.getTop();
                chatMessageCell.getBottom();
                int i4 = top >= 0 ? 0 : -top;
                int measuredHeight2 = chatMessageCell.getMeasuredHeight();
                if (measuredHeight2 > measuredHeight) {
                    measuredHeight2 = i4 + measuredHeight;
                }
                chatMessageCell.setVisiblePart(i4, measuredHeight2 - i4, (this.contentView.getHeightWithKeyboard() - AndroidUtilities.dp(48.0f)) - this.chatListView.getTop(), 0.0f, (childAt.getY() + this.actionBar.getMeasuredHeight()) - this.contentView.getBackgroundTranslationY(), this.contentView.getMeasuredWidth(), this.contentView.getBackgroundSizeY());
                MessageObject messageObject2 = chatMessageCell.getMessageObject();
                if (this.roundVideoContainer != null && messageObject2.isRoundVideo() && MediaController.getInstance().isPlayingMessage(messageObject2)) {
                    ImageReceiver photoImage = chatMessageCell.getPhotoImage();
                    this.roundVideoContainer.setTranslationX(photoImage.getImageX());
                    this.roundVideoContainer.setTranslationY(this.fragmentView.getPaddingTop() + top + photoImage.getImageY());
                    this.fragmentView.invalidate();
                    this.roundVideoContainer.invalidate();
                    z2 = true;
                }
            } else if (childAt instanceof ChatActionCell) {
                ((ChatActionCell) childAt).setVisiblePart((childAt.getY() + this.actionBar.getMeasuredHeight()) - this.contentView.getBackgroundTranslationY(), this.contentView.getBackgroundSizeY());
            }
            if (childAt.getBottom() > this.chatListView.getPaddingTop()) {
                int bottom = childAt.getBottom();
                if (bottom < i) {
                    if ((childAt instanceof ChatMessageCell) || (childAt instanceof ChatActionCell)) {
                        view = childAt;
                    }
                    i = bottom;
                    view3 = childAt;
                }
                ChatListItemAnimator chatListItemAnimator = this.chatListItemAnimator;
                if ((chatListItemAnimator == null || (!chatListItemAnimator.willRemoved(childAt) && !this.chatListItemAnimator.willAddedFromAlpha(childAt))) && (childAt instanceof ChatActionCell) && ((ChatActionCell) childAt).getMessageObject().isDateObject) {
                    if (childAt.getAlpha() != 1.0f) {
                        childAt.setAlpha(1.0f);
                    }
                    if (bottom < i2) {
                        i2 = bottom;
                        view2 = childAt;
                    }
                }
            }
        }
        FrameLayout frameLayout = this.roundVideoContainer;
        if (frameLayout != null) {
            if (!z2) {
                frameLayout.setTranslationY((-AndroidUtilities.roundMessageSize) - 100);
                this.fragmentView.invalidate();
                MessageObject playingMessageObject = MediaController.getInstance().getPlayingMessageObject();
                if (playingMessageObject != null && playingMessageObject.isRoundVideo() && this.checkTextureViewPosition) {
                    MediaController.getInstance().setCurrentVideoVisible(false);
                }
            } else {
                MediaController.getInstance().setCurrentVideoVisible(true);
            }
        }
        if (view != null) {
            if (view instanceof ChatMessageCell) {
                messageObject = ((ChatMessageCell) view).getMessageObject();
            } else {
                messageObject = ((ChatActionCell) view).getMessageObject();
            }
            z = false;
            this.floatingDateView.setCustomDate(messageObject.messageOwner.date, false, true);
        } else {
            z = false;
        }
        this.currentFloatingDateOnScreen = z;
        this.currentFloatingTopIsNotMessage = ((view3 instanceof ChatMessageCell) || (view3 instanceof ChatActionCell)) ? false : true;
        if (view2 != null) {
            if (view2.getTop() > this.chatListView.getPaddingTop() || this.currentFloatingTopIsNotMessage) {
                if (view2.getAlpha() != 1.0f) {
                    view2.setAlpha(1.0f);
                }
                hideFloatingDateView(!this.currentFloatingTopIsNotMessage);
            } else {
                if (view2.getAlpha() != 0.0f) {
                    view2.setAlpha(0.0f);
                }
                AnimatorSet animatorSet = this.floatingDateAnimation;
                if (animatorSet != null) {
                    animatorSet.cancel();
                    this.floatingDateAnimation = null;
                }
                if (this.floatingDateView.getTag() == null) {
                    this.floatingDateView.setTag(1);
                }
                if (this.floatingDateView.getAlpha() != 1.0f) {
                    this.floatingDateView.setAlpha(1.0f);
                }
                this.currentFloatingDateOnScreen = true;
            }
            int bottom2 = view2.getBottom() - this.chatListView.getPaddingTop();
            if (bottom2 > this.floatingDateView.getMeasuredHeight() && bottom2 < this.floatingDateView.getMeasuredHeight() * 2) {
                this.floatingDateView.setTranslationY(((-r1.getMeasuredHeight()) * 2) + bottom2);
                return;
            } else {
                this.floatingDateView.setTranslationY(0.0f);
                return;
            }
        }
        hideFloatingDateView(true);
        this.floatingDateView.setTranslationY(0.0f);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onTransitionAnimationStart(boolean isOpen, boolean backward) {
        if (isOpen) {
            this.allowAnimationIndex = getNotificationCenter().setAnimationInProgress(this.allowAnimationIndex, new int[]{NotificationCenter.chatInfoDidLoad, NotificationCenter.dialogsNeedReload, NotificationCenter.closeChats, NotificationCenter.messagesDidLoad, NotificationCenter.botKeyboardDidLoad});
            this.openAnimationEnded = false;
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onTransitionAnimationEnd(boolean isOpen, boolean backward) {
        if (isOpen) {
            getNotificationCenter().onAnimationFinish(this.allowAnimationIndex);
            this.openAnimationEnded = true;
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        SizeNotifierFrameLayout sizeNotifierFrameLayout = this.contentView;
        if (sizeNotifierFrameLayout != null) {
            sizeNotifierFrameLayout.onResume();
        }
        this.paused = false;
        checkScrollForLoad(false);
        if (this.wasPaused) {
            this.wasPaused = false;
            ChatActivityAdapter chatActivityAdapter = this.chatAdapter;
            if (chatActivityAdapter != null) {
                chatActivityAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
        SizeNotifierFrameLayout sizeNotifierFrameLayout = this.contentView;
        if (sizeNotifierFrameLayout != null) {
            sizeNotifierFrameLayout.onPause();
        }
        UndoView undoView = this.undoView;
        if (undoView != null) {
            undoView.hide(true, 0);
        }
        this.paused = true;
        this.wasPaused = true;
        if (AvatarPreviewer.hasVisibleInstance()) {
            AvatarPreviewer.getInstance().close();
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    protected void onBecomeFullyHidden() {
        UndoView undoView = this.undoView;
        if (undoView != null) {
            undoView.hide(true, 0);
        }
    }

    public void openVCard(TLRPC$User user, String vcard, String first_name, String last_name) throws IOException {
        try {
            File sharingDirectory = AndroidUtilities.getSharingDirectory();
            sharingDirectory.mkdirs();
            File file = new File(sharingDirectory, "vcard.vcf");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(vcard);
            bufferedWriter.close();
            showDialog(new PhonebookShareAlert(this, null, user, null, file, first_name, last_name));
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onConfigurationChanged(Configuration newConfig) {
        Dialog dialog = this.visibleDialog;
        if (dialog instanceof DatePickerDialog) {
            dialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alertUserOpenError(MessageObject message) {
        if (getParentActivity() == null) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
        if (message.type == 3) {
            builder.setMessage(LocaleController.getString("NoPlayerInstalled", R.string.NoPlayerInstalled));
        } else {
            builder.setMessage(LocaleController.formatString("NoHandleAppInstalled", R.string.NoHandleAppInstalled, message.getDocument().mime_type));
        }
        showDialog(builder.create());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addCanBanUser(Bundle bundle, long uid) {
        TLRPC$Chat tLRPC$Chat = this.currentChat;
        if (tLRPC$Chat.megagroup && this.admins != null && ChatObject.canBlockUsers(tLRPC$Chat)) {
            int i = 0;
            while (true) {
                if (i >= this.admins.size()) {
                    break;
                }
                TLRPC$ChannelParticipant tLRPC$ChannelParticipant = this.admins.get(i);
                if (MessageObject.getPeerId(tLRPC$ChannelParticipant.peer) != uid) {
                    i++;
                } else if (!tLRPC$ChannelParticipant.can_edit) {
                    return;
                }
            }
            bundle.putLong("ban_chat_id", this.currentChat.id);
        }
    }

    public void showOpenUrlAlert(final String url, boolean ask) {
        if (Browser.isInternalUrl(url, null) || !ask) {
            Browser.openUrl((Context) getParentActivity(), url, true);
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setTitle(LocaleController.getString("OpenUrlTitle", R.string.OpenUrlTitle));
        builder.setMessage(LocaleController.formatString("OpenUrlAlert2", R.string.OpenUrlAlert2, url));
        builder.setPositiveButton(LocaleController.getString("Open", R.string.Open), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ChannelAdminLogActivity$hgYi4tdBSS0BPRLBCcl2X5euIJg
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showOpenUrlAlert$12$ChannelAdminLogActivity(url, dialogInterface, i);
            }
        });
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        showDialog(builder.create());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showOpenUrlAlert$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showOpenUrlAlert$12$ChannelAdminLogActivity(String str, DialogInterface dialogInterface, int i) {
        Browser.openUrl((Context) getParentActivity(), str, true);
    }

    public class ChatActivityAdapter extends RecyclerView.Adapter {
        private int loadingUpRow;
        private Context mContext;
        private int messagesEndRow;
        private int messagesStartRow;
        private int rowCount;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            return -1L;
        }

        public ChatActivityAdapter(Context context) {
            this.mContext = context;
        }

        public void updateRows() {
            this.rowCount = 0;
            if (!ChannelAdminLogActivity.this.messages.isEmpty()) {
                if (!ChannelAdminLogActivity.this.endReached) {
                    int i = this.rowCount;
                    this.rowCount = i + 1;
                    this.loadingUpRow = i;
                } else {
                    this.loadingUpRow = -1;
                }
                int i2 = this.rowCount;
                this.messagesStartRow = i2;
                int size = i2 + ChannelAdminLogActivity.this.messages.size();
                this.rowCount = size;
                this.messagesEndRow = size;
                return;
            }
            this.loadingUpRow = -1;
            this.messagesStartRow = -1;
            this.messagesEndRow = -1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.rowCount;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v13, types: [android.view.View] */
        /* JADX WARN: Type inference failed for: r4v3, types: [ir.eitaa.ui.Cells.ChatActionCell, ir.eitaa.ui.ChannelAdminLogActivity$ChatActivityAdapter$2] */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            ViewGroup chatLoadingCell;
            ViewGroup chatMessageCell;
            if (i == 0) {
                if (!ChannelAdminLogActivity.this.chatMessageCellsCache.isEmpty()) {
                    ?? r4 = (View) ChannelAdminLogActivity.this.chatMessageCellsCache.get(0);
                    ChannelAdminLogActivity.this.chatMessageCellsCache.remove(0);
                    chatMessageCell = r4;
                } else {
                    chatMessageCell = new ChatMessageCell(this.mContext);
                }
                ChatMessageCell chatMessageCell2 = (ChatMessageCell) chatMessageCell;
                chatMessageCell2.setDelegate(new AnonymousClass1());
                chatMessageCell2.setAllowAssistant(true);
                chatLoadingCell = chatMessageCell;
            } else if (i == 1) {
                ?? r42 = new ChatActionCell(this.mContext) { // from class: ir.eitaa.ui.ChannelAdminLogActivity.ChatActivityAdapter.2
                    @Override // ir.eitaa.ui.Cells.ChatActionCell, android.view.View
                    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
                        super.onInitializeAccessibilityNodeInfo(info);
                        info.setVisibleToUser(true);
                    }
                };
                r42.setDelegate(new AnonymousClass3());
                chatLoadingCell = r42;
            } else if (i == 2) {
                chatLoadingCell = new ChatUnreadCell(this.mContext, null);
            } else {
                chatLoadingCell = new ChatLoadingCell(this.mContext, ChannelAdminLogActivity.this.contentView, null);
            }
            chatLoadingCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            return new RecyclerListView.Holder(chatLoadingCell);
        }

        /* renamed from: ir.eitaa.ui.ChannelAdminLogActivity$ChatActivityAdapter$1, reason: invalid class name */
        class AnonymousClass1 implements ChatMessageCell.ChatMessageCellDelegate {
            @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
            public boolean canPerformActions() {
                return true;
            }

            @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
            public /* synthetic */ boolean didLongPressChannelAvatar(ChatMessageCell chatMessageCell, TLRPC$Chat tLRPC$Chat, int i, float f, float f2) {
                return ChatMessageCell.ChatMessageCellDelegate.CC.$default$didLongPressChannelAvatar(this, chatMessageCell, tLRPC$Chat, i, f, f2);
            }

            @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
            public /* synthetic */ void didPressBotButton(ChatMessageCell chatMessageCell, TLRPC$KeyboardButton tLRPC$KeyboardButton) {
                ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressBotButton(this, chatMessageCell, tLRPC$KeyboardButton);
            }

            @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
            public void didPressCancelSendButton(ChatMessageCell cell) {
            }

            @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
            public /* synthetic */ void didPressCommentButton(ChatMessageCell chatMessageCell) {
                ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressCommentButton(this, chatMessageCell);
            }

            @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
            public /* synthetic */ void didPressHiddenForward(ChatMessageCell chatMessageCell) {
                ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressHiddenForward(this, chatMessageCell);
            }

            @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
            public /* synthetic */ void didPressHint(ChatMessageCell chatMessageCell, int i) {
                ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressHint(this, chatMessageCell, i);
            }

            @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
            public /* synthetic */ void didPressReaction(ChatMessageCell chatMessageCell, TLRPC$TL_reactionCount tLRPC$TL_reactionCount) {
                ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressReaction(this, chatMessageCell, tLRPC$TL_reactionCount);
            }

            @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
            public void didPressReplyMessage(ChatMessageCell cell, int id) {
            }

            @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
            public /* synthetic */ void didPressTime(ChatMessageCell chatMessageCell) {
                ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressTime(this, chatMessageCell);
            }

            @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
            public void didPressViaBot(ChatMessageCell cell, String username) {
            }

            @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
            public /* synthetic */ void didPressVoteButtons(ChatMessageCell chatMessageCell, ArrayList arrayList, int i, int i2, int i3) {
                ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressVoteButtons(this, chatMessageCell, arrayList, i, i2, i3);
            }

            @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
            public /* synthetic */ void didStartVideoStream(MessageObject messageObject) {
                ChatMessageCell.ChatMessageCellDelegate.CC.$default$didStartVideoStream(this, messageObject);
            }

            @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
            public /* synthetic */ String getAdminRank(long j) {
                return ChatMessageCell.ChatMessageCellDelegate.CC.$default$getAdminRank(this, j);
            }

            @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
            public /* synthetic */ PinchToZoomHelper getPinchToZoomHelper() {
                return ChatMessageCell.ChatMessageCellDelegate.CC.$default$getPinchToZoomHelper(this);
            }

            @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
            public /* synthetic */ TextSelectionHelper.ChatListTextSelectionHelper getTextSelectionHelper() {
                return ChatMessageCell.ChatMessageCellDelegate.CC.$default$getTextSelectionHelper(this);
            }

            @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
            public /* synthetic */ boolean hasSelectedMessages() {
                return ChatMessageCell.ChatMessageCellDelegate.CC.$default$hasSelectedMessages(this);
            }

            @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
            public /* synthetic */ boolean isLandscape() {
                return ChatMessageCell.ChatMessageCellDelegate.CC.$default$isLandscape(this);
            }

            @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
            public /* synthetic */ boolean keyboardIsOpened() {
                return ChatMessageCell.ChatMessageCellDelegate.CC.$default$keyboardIsOpened(this);
            }

            @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
            public /* synthetic */ void needReloadPolls() {
                ChatMessageCell.ChatMessageCellDelegate.CC.$default$needReloadPolls(this);
            }

            @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
            public /* synthetic */ void onDiceFinished() {
                ChatMessageCell.ChatMessageCellDelegate.CC.$default$onDiceFinished(this);
            }

            @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
            public /* synthetic */ void setShouldNotRepeatSticker(MessageObject messageObject) {
                ChatMessageCell.ChatMessageCellDelegate.CC.$default$setShouldNotRepeatSticker(this, messageObject);
            }

            @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
            public /* synthetic */ boolean shouldDrawThreadProgress(ChatMessageCell chatMessageCell) {
                return ChatMessageCell.ChatMessageCellDelegate.CC.$default$shouldDrawThreadProgress(this, chatMessageCell);
            }

            @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
            public /* synthetic */ boolean shouldRepeatSticker(MessageObject messageObject) {
                return ChatMessageCell.ChatMessageCellDelegate.CC.$default$shouldRepeatSticker(this, messageObject);
            }

            @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
            public /* synthetic */ void videoTimerReached() {
                ChatMessageCell.ChatMessageCellDelegate.CC.$default$videoTimerReached(this);
            }

            AnonymousClass1() {
            }

            @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
            public void didPressSideButton(ChatMessageCell cell) {
                if (ChannelAdminLogActivity.this.getParentActivity() == null) {
                    return;
                }
                ChatActivityAdapter chatActivityAdapter = ChatActivityAdapter.this;
                ChannelAdminLogActivity.this.showDialog(ShareAlert.createShareAlert(chatActivityAdapter.mContext, cell.getMessageObject(), null, ChatObject.isChannel(ChannelAdminLogActivity.this.currentChat) && !ChannelAdminLogActivity.this.currentChat.megagroup, null, false));
            }

            @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
            public void didPressedShareToMine(ChatMessageCell cell) {
                if (ChannelAdminLogActivity.this.getParentActivity() == null) {
                    return;
                }
                ArrayList<MessageObject> arrayList = new ArrayList<>();
                arrayList.add(cell.getMessageObject());
                SendMessagesHelper.getInstance(((BaseFragment) ChannelAdminLogActivity.this).currentAccount).sendMessage(arrayList, UserConfig.getInstance(((BaseFragment) ChannelAdminLogActivity.this).currentAccount).getClientUserId(), false, false, false, 0);
            }

            @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
            public boolean needPlayMessage(MessageObject messageObject) throws IOException {
                if (messageObject.isVoice() || messageObject.isRoundVideo()) {
                    boolean zPlayMessage = MediaController.getInstance().playMessage(messageObject);
                    MediaController.getInstance().setVoiceMessagesPlaylist(null, false);
                    return zPlayMessage;
                }
                if (messageObject.isMusic()) {
                    return MediaController.getInstance().setPlaylist(ChannelAdminLogActivity.this.messages, messageObject, 0L);
                }
                return false;
            }

            @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
            public void didPressChannelAvatar(ChatMessageCell cell, TLRPC$Chat chat, int postId, float touchX, float touchY) {
                if (chat == null || chat == ChannelAdminLogActivity.this.currentChat) {
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putLong("chat_id", chat.id);
                if (postId != 0) {
                    bundle.putInt("message_id", postId);
                }
                if (MessagesController.getInstance(((BaseFragment) ChannelAdminLogActivity.this).currentAccount).checkCanOpenChat(bundle, ChannelAdminLogActivity.this)) {
                    ChannelAdminLogActivity.this.presentFragment(new ChatActivity(bundle), true);
                }
            }

            @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
            public void didPressOther(ChatMessageCell cell, float x, float y) {
                ChannelAdminLogActivity.this.createMenu(cell);
            }

            @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
            public void didPressUserAvatar(ChatMessageCell cell, TLRPC$User user, float touchX, float touchY) {
                if (user == null || user.id == UserConfig.getInstance(((BaseFragment) ChannelAdminLogActivity.this).currentAccount).getClientUserId()) {
                    return;
                }
                openProfile(user);
            }

            @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
            public boolean didLongPressUserAvatar(final ChatMessageCell cell, final TLRPC$User user, float touchX, float touchY) {
                AvatarPreviewer.Data dataOf;
                if (user != null && user.id != UserConfig.getInstance(((BaseFragment) ChannelAdminLogActivity.this).currentAccount).getClientUserId()) {
                    AvatarPreviewer.MenuItem[] menuItemArr = {AvatarPreviewer.MenuItem.OPEN_PROFILE, AvatarPreviewer.MenuItem.SEND_MESSAGE};
                    TLRPC$UserFull userFull = ChannelAdminLogActivity.this.getMessagesController().getUserFull(user.id);
                    if (userFull == null) {
                        dataOf = AvatarPreviewer.Data.of(user, ((BaseFragment) ChannelAdminLogActivity.this).classGuid, menuItemArr);
                    } else {
                        dataOf = AvatarPreviewer.Data.of(userFull, menuItemArr);
                    }
                    if (AvatarPreviewer.canPreview(dataOf)) {
                        AvatarPreviewer.getInstance().show((ViewGroup) ((BaseFragment) ChannelAdminLogActivity.this).fragmentView, dataOf, new AvatarPreviewer.Callback() { // from class: ir.eitaa.ui.-$$Lambda$ChannelAdminLogActivity$ChatActivityAdapter$1$sA34RmKl6u2W8Vk7oYkBLqDeLrE
                            @Override // ir.eitaa.ui.AvatarPreviewer.Callback
                            public final void onMenuClick(AvatarPreviewer.MenuItem menuItem) {
                                this.f$0.lambda$didLongPressUserAvatar$0$ChannelAdminLogActivity$ChatActivityAdapter$1(cell, user, menuItem);
                            }
                        });
                        return true;
                    }
                }
                return false;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: lambda$didLongPressUserAvatar$0, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void lambda$didLongPressUserAvatar$0$ChannelAdminLogActivity$ChatActivityAdapter$1(ChatMessageCell chatMessageCell, TLRPC$User tLRPC$User, AvatarPreviewer.MenuItem menuItem) {
                int i = AnonymousClass17.$SwitchMap$ir$eitaa$ui$AvatarPreviewer$MenuItem[menuItem.ordinal()];
                if (i == 1) {
                    openDialog(chatMessageCell, tLRPC$User);
                } else {
                    if (i != 2) {
                        return;
                    }
                    openProfile(tLRPC$User);
                }
            }

            private void openProfile(TLRPC$User user) {
                Bundle bundle = new Bundle();
                bundle.putLong("user_id", user.id);
                ChannelAdminLogActivity.this.addCanBanUser(bundle, user.id);
                ProfileActivity profileActivity = new ProfileActivity(bundle);
                profileActivity.setPlayProfileAnimation(0);
                ChannelAdminLogActivity.this.presentFragment(profileActivity);
            }

            private void openDialog(ChatMessageCell cell, TLRPC$User user) {
                if (user != null) {
                    Bundle bundle = new Bundle();
                    bundle.putLong("user_id", user.id);
                    if (ChannelAdminLogActivity.this.getMessagesController().checkCanOpenChat(bundle, ChannelAdminLogActivity.this)) {
                        ChannelAdminLogActivity.this.presentFragment(new ChatActivity(bundle));
                    }
                }
            }

            @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
            public void didLongPress(ChatMessageCell cell, float x, float y) {
                ChannelAdminLogActivity.this.createMenu(cell);
            }

            @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
            public void didPressUrl(ChatMessageCell cell, final CharacterStyle url, boolean longPress) throws NoSuchFieldException, Resources.NotFoundException {
                TLRPC$WebPage tLRPC$WebPage;
                if (url == null) {
                    return;
                }
                MessageObject messageObject = cell.getMessageObject();
                if (url instanceof URLSpanMono) {
                    ((URLSpanMono) url).copyToClipboard();
                    Toast.makeText(ChannelAdminLogActivity.this.getParentActivity(), LocaleController.getString("TextCopied", R.string.TextCopied), 0).show();
                    return;
                }
                if (url instanceof URLSpanUserMention) {
                    long jIntValue = Utilities.parseInt(((URLSpanUserMention) url).getURL()).intValue();
                    if (jIntValue > 0) {
                        TLRPC$User user = MessagesController.getInstance(((BaseFragment) ChannelAdminLogActivity.this).currentAccount).getUser(Long.valueOf(jIntValue));
                        if (user != null) {
                            MessagesController.openChatOrProfileWith(user, null, ChannelAdminLogActivity.this, 0, false);
                            return;
                        }
                        return;
                    }
                    TLRPC$Chat chat = MessagesController.getInstance(((BaseFragment) ChannelAdminLogActivity.this).currentAccount).getChat(Long.valueOf(-jIntValue));
                    if (chat != null) {
                        MessagesController.openChatOrProfileWith(null, chat, ChannelAdminLogActivity.this, 0, false);
                        return;
                    }
                    return;
                }
                if (url instanceof URLSpanNoUnderline) {
                    String url2 = ((URLSpanNoUnderline) url).getURL();
                    if (url2.startsWith("@")) {
                        MessagesController.getInstance(((BaseFragment) ChannelAdminLogActivity.this).currentAccount).openByUserName(url2.substring(1), ChannelAdminLogActivity.this, 0);
                        return;
                    } else {
                        if (url2.startsWith("#")) {
                            DialogsActivity dialogsActivity = new DialogsActivity(null);
                            dialogsActivity.setSearchString(url2);
                            ChannelAdminLogActivity.this.presentFragment(dialogsActivity);
                            return;
                        }
                        return;
                    }
                }
                final String url3 = ((URLSpan) url).getURL();
                if (longPress) {
                    BottomSheet.Builder builder = new BottomSheet.Builder(ChannelAdminLogActivity.this.getParentActivity());
                    builder.setTitle(url3);
                    builder.setItems(new CharSequence[]{LocaleController.getString("Open", R.string.Open), LocaleController.getString("Copy", R.string.Copy)}, new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ChannelAdminLogActivity$ChatActivityAdapter$1$_z--RAyNpuCfR-_9SsfzBPFnEKE
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.f$0.lambda$didPressUrl$1$ChannelAdminLogActivity$ChatActivityAdapter$1(url3, dialogInterface, i);
                        }
                    });
                    ChannelAdminLogActivity.this.showDialog(builder.create());
                    return;
                }
                if (url instanceof URLSpanReplacement) {
                    ChannelAdminLogActivity.this.showOpenUrlAlert(((URLSpanReplacement) url).getURL(), true);
                    return;
                }
                TLRPC$MessageMedia tLRPC$MessageMedia = messageObject.messageOwner.media;
                if ((tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaWebPage) && (tLRPC$WebPage = tLRPC$MessageMedia.webpage) != null && tLRPC$WebPage.cached_page != null) {
                    String lowerCase = url3.toLowerCase();
                    String lowerCase2 = messageObject.messageOwner.media.webpage.url.toLowerCase();
                    if (lowerCase.contains("eitaa.com/iv") && (lowerCase.contains(lowerCase2) || lowerCase2.contains(lowerCase))) {
                        ArticleViewer.getInstance().setParentActivity(ChannelAdminLogActivity.this.getParentActivity(), ChannelAdminLogActivity.this);
                        ArticleViewer.getInstance().open(messageObject);
                        return;
                    }
                }
                Browser.openUrl((Context) ChannelAdminLogActivity.this.getParentActivity(), url3, true);
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: lambda$didPressUrl$1, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void lambda$didPressUrl$1$ChannelAdminLogActivity$ChatActivityAdapter$1(String str, DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    Browser.openUrl((Context) ChannelAdminLogActivity.this.getParentActivity(), str, true);
                    return;
                }
                if (i == 1) {
                    if (str.startsWith("mailto:")) {
                        str = str.substring(7);
                    } else if (str.startsWith("tel:")) {
                        str = str.substring(4);
                    }
                    AndroidUtilities.addToClipboard(str);
                }
            }

            @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
            public void needOpenWebView(MessageObject message, String url, String title, String description, String originalUrl, int w, int h) {
                EmbedBottomSheet.show(ChannelAdminLogActivity.this.getParentActivity(), message, ChannelAdminLogActivity.this.provider, title, description, originalUrl, url, w, h, false);
            }

            /* JADX WARN: Removed duplicated region for block: B:52:0x0104  */
            /* JADX WARN: Removed duplicated region for block: B:54:0x0107  */
            /* JADX WARN: Removed duplicated region for block: B:59:0x011f  */
            /* JADX WARN: Removed duplicated region for block: B:68:0x0188  */
            /* JADX WARN: Removed duplicated region for block: B:70:0x0195  */
            @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void didPressImage(ir.eitaa.ui.Cells.ChatMessageCell r9, float r10, float r11) throws android.content.res.Resources.NotFoundException {
                /*
                    Method dump skipped, instructions count: 468
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ChannelAdminLogActivity.ChatActivityAdapter.AnonymousClass1.didPressImage(ir.eitaa.ui.Cells.ChatMessageCell, float, float):void");
            }

            @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
            public void didPressInstantButton(ChatMessageCell cell, int type) throws NoSuchFieldException, Resources.NotFoundException, IOException {
                TLRPC$WebPage tLRPC$WebPage;
                MessageObject messageObject = cell.getMessageObject();
                if (type == 0) {
                    TLRPC$MessageMedia tLRPC$MessageMedia = messageObject.messageOwner.media;
                    if (tLRPC$MessageMedia == null || (tLRPC$WebPage = tLRPC$MessageMedia.webpage) == null || tLRPC$WebPage.cached_page == null) {
                        return;
                    }
                    ArticleViewer.getInstance().setParentActivity(ChannelAdminLogActivity.this.getParentActivity(), ChannelAdminLogActivity.this);
                    ArticleViewer.getInstance().open(messageObject);
                    return;
                }
                if (type == 5) {
                    ChannelAdminLogActivity channelAdminLogActivity = ChannelAdminLogActivity.this;
                    TLRPC$User user = channelAdminLogActivity.getMessagesController().getUser(Long.valueOf(messageObject.messageOwner.media.user_id));
                    TLRPC$MessageMedia tLRPC$MessageMedia2 = messageObject.messageOwner.media;
                    channelAdminLogActivity.openVCard(user, tLRPC$MessageMedia2.vcard, tLRPC$MessageMedia2.first_name, tLRPC$MessageMedia2.last_name);
                    return;
                }
                TLRPC$MessageMedia tLRPC$MessageMedia3 = messageObject.messageOwner.media;
                if (tLRPC$MessageMedia3 == null || tLRPC$MessageMedia3.webpage == null) {
                    return;
                }
                Browser.openUrl(ChannelAdminLogActivity.this.getParentActivity(), messageObject.messageOwner.media.webpage.url);
            }
        }

        /* renamed from: ir.eitaa.ui.ChannelAdminLogActivity$ChatActivityAdapter$3, reason: invalid class name */
        class AnonymousClass3 implements ChatActionCell.ChatActionCellDelegate {
            @Override // ir.eitaa.ui.Cells.ChatActionCell.ChatActionCellDelegate
            public void didPressReplyMessage(ChatActionCell cell, int id) {
            }

            AnonymousClass3() {
            }

            @Override // ir.eitaa.ui.Cells.ChatActionCell.ChatActionCellDelegate
            public void didClickImage(ChatActionCell cell) throws Resources.NotFoundException {
                MessageObject messageObject = cell.getMessageObject();
                PhotoViewer.getInstance().setParentActivity(ChannelAdminLogActivity.this.getParentActivity());
                TLRPC$PhotoSize closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(messageObject.photoThumbs, 640);
                if (closestPhotoSizeWithSize == null) {
                    PhotoViewer.getInstance().openPhoto(messageObject, (ChatActivity) null, 0L, 0L, ChannelAdminLogActivity.this.provider);
                } else {
                    PhotoViewer.getInstance().openPhoto(closestPhotoSizeWithSize.location, ImageLocation.getForPhoto(closestPhotoSizeWithSize, messageObject.messageOwner.action.photo), ChannelAdminLogActivity.this.provider);
                }
            }

            @Override // ir.eitaa.ui.Cells.ChatActionCell.ChatActionCellDelegate
            public void didLongPress(ChatActionCell cell, float x, float y) {
                ChannelAdminLogActivity.this.createMenu(cell);
            }

            @Override // ir.eitaa.ui.Cells.ChatActionCell.ChatActionCellDelegate
            public void needOpenUserProfile(long uid) {
                if (uid < 0) {
                    Bundle bundle = new Bundle();
                    bundle.putLong("chat_id", -uid);
                    if (MessagesController.getInstance(((BaseFragment) ChannelAdminLogActivity.this).currentAccount).checkCanOpenChat(bundle, ChannelAdminLogActivity.this)) {
                        ChannelAdminLogActivity.this.presentFragment(new ChatActivity(bundle), true);
                        return;
                    }
                    return;
                }
                if (uid != UserConfig.getInstance(((BaseFragment) ChannelAdminLogActivity.this).currentAccount).getClientUserId()) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putLong("user_id", uid);
                    ChannelAdminLogActivity.this.addCanBanUser(bundle2, uid);
                    ProfileActivity profileActivity = new ProfileActivity(bundle2);
                    profileActivity.setPlayProfileAnimation(0);
                    ChannelAdminLogActivity.this.presentFragment(profileActivity);
                }
            }

            @Override // ir.eitaa.ui.Cells.ChatActionCell.ChatActionCellDelegate
            public void needOpenInviteLink(final TLRPC$TL_chatInviteExported invite) {
                if (ChannelAdminLogActivity.this.linviteLoading) {
                    return;
                }
                Object obj = ChannelAdminLogActivity.this.invitesCache.containsKey(invite.link) ? ChannelAdminLogActivity.this.invitesCache.get(invite.link) : null;
                if (obj == null) {
                    TLRPC$TL_messages_getExportedChatInvite tLRPC$TL_messages_getExportedChatInvite = new TLRPC$TL_messages_getExportedChatInvite();
                    tLRPC$TL_messages_getExportedChatInvite.peer = ChannelAdminLogActivity.this.getMessagesController().getInputPeer(-ChannelAdminLogActivity.this.currentChat.id);
                    tLRPC$TL_messages_getExportedChatInvite.link = invite.link;
                    ChannelAdminLogActivity.this.linviteLoading = true;
                    final boolean[] zArr = new boolean[1];
                    final AlertDialog alertDialog = new AlertDialog(ChannelAdminLogActivity.this.getParentActivity(), 3);
                    alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: ir.eitaa.ui.-$$Lambda$ChannelAdminLogActivity$ChatActivityAdapter$3$IfG254oUPCe9oV9MO2yOCE--LU8
                        @Override // android.content.DialogInterface.OnCancelListener
                        public final void onCancel(DialogInterface dialogInterface) {
                            this.f$0.lambda$needOpenInviteLink$0$ChannelAdminLogActivity$ChatActivityAdapter$3(zArr, dialogInterface);
                        }
                    });
                    alertDialog.showDelayed(300L);
                    ChannelAdminLogActivity.this.getConnectionsManager().bindRequestToGuid(ChannelAdminLogActivity.this.getConnectionsManager().sendRequest(tLRPC$TL_messages_getExportedChatInvite, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ChannelAdminLogActivity$ChatActivityAdapter$3$SdASbF0VGgeDunQb-76Zcv0Sk2Y
                        @Override // ir.eitaa.tgnet.RequestDelegate
                        public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            this.f$0.lambda$needOpenInviteLink$2$ChannelAdminLogActivity$ChatActivityAdapter$3(invite, zArr, alertDialog, tLObject, tLRPC$TL_error);
                        }
                    }), ((BaseFragment) ChannelAdminLogActivity.this).classGuid);
                    return;
                }
                if (obj instanceof TLRPC$TL_messages_exportedChatInvite) {
                    ChannelAdminLogActivity channelAdminLogActivity = ChannelAdminLogActivity.this;
                    channelAdminLogActivity.showInviteLinkBottomSheet((TLRPC$TL_messages_exportedChatInvite) obj, channelAdminLogActivity.usersMap);
                } else {
                    BulletinFactory.of(ChannelAdminLogActivity.this).createSimpleBulletin(R.raw.linkbroken, LocaleController.getString("LinkHashExpired", R.string.LinkHashExpired)).show();
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: lambda$needOpenInviteLink$0, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void lambda$needOpenInviteLink$0$ChannelAdminLogActivity$ChatActivityAdapter$3(boolean[] zArr, DialogInterface dialogInterface) {
                ChannelAdminLogActivity.this.linviteLoading = false;
                zArr[0] = true;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: lambda$needOpenInviteLink$2, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void lambda$needOpenInviteLink$2$ChannelAdminLogActivity$ChatActivityAdapter$3(final TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported, final boolean[] zArr, final AlertDialog alertDialog, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                TLRPC$TL_messages_exportedChatInvite tLRPC$TL_messages_exportedChatInvite;
                if (tLRPC$TL_error == null) {
                    tLRPC$TL_messages_exportedChatInvite = (TLRPC$TL_messages_exportedChatInvite) tLObject;
                    for (int i = 0; i < tLRPC$TL_messages_exportedChatInvite.users.size(); i++) {
                        TLRPC$User tLRPC$User = tLRPC$TL_messages_exportedChatInvite.users.get(i);
                        if (ChannelAdminLogActivity.this.usersMap == null) {
                            ChannelAdminLogActivity.this.usersMap = new HashMap();
                        }
                        ChannelAdminLogActivity.this.usersMap.put(Long.valueOf(tLRPC$User.id), tLRPC$User);
                    }
                } else {
                    tLRPC$TL_messages_exportedChatInvite = null;
                }
                final TLRPC$TL_messages_exportedChatInvite tLRPC$TL_messages_exportedChatInvite2 = tLRPC$TL_messages_exportedChatInvite;
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ChannelAdminLogActivity$ChatActivityAdapter$3$U9BKROe44SNP5tFDDROxQ1Whoug
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$needOpenInviteLink$1$ChannelAdminLogActivity$ChatActivityAdapter$3(tLRPC$TL_chatInviteExported, tLRPC$TL_messages_exportedChatInvite2, zArr, alertDialog);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: lambda$needOpenInviteLink$1, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void lambda$needOpenInviteLink$1$ChannelAdminLogActivity$ChatActivityAdapter$3(TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported, TLRPC$TL_messages_exportedChatInvite tLRPC$TL_messages_exportedChatInvite, boolean[] zArr, AlertDialog alertDialog) {
                ChannelAdminLogActivity.this.linviteLoading = false;
                ChannelAdminLogActivity.this.invitesCache.put(tLRPC$TL_chatInviteExported.link, tLRPC$TL_messages_exportedChatInvite == null ? 0 : tLRPC$TL_messages_exportedChatInvite);
                if (zArr[0]) {
                    return;
                }
                alertDialog.dismiss();
                if (tLRPC$TL_messages_exportedChatInvite != null) {
                    ChannelAdminLogActivity channelAdminLogActivity = ChannelAdminLogActivity.this;
                    channelAdminLogActivity.showInviteLinkBottomSheet(tLRPC$TL_messages_exportedChatInvite, channelAdminLogActivity.usersMap);
                } else {
                    BulletinFactory.of(ChannelAdminLogActivity.this).createSimpleBulletin(R.raw.linkbroken, LocaleController.getString("LinkHashExpired", R.string.LinkHashExpired)).show();
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x0094  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00db  */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder r14, int r15) throws android.content.res.Resources.NotFoundException, java.lang.NumberFormatException {
            /*
                Method dump skipped, instructions count: 246
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ChannelAdminLogActivity.ChatActivityAdapter.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            if (position < this.messagesStartRow || position >= this.messagesEndRow) {
                return 4;
            }
            return ChannelAdminLogActivity.this.messages.get((r0.size() - (position - this.messagesStartRow)) - 1).contentType;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewAttachedToWindow(final RecyclerView.ViewHolder holder) {
            final View view = holder.itemView;
            if ((view instanceof ChatMessageCell) || (view instanceof ChatActionCell)) {
                view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: ir.eitaa.ui.ChannelAdminLogActivity.ChatActivityAdapter.4
                    @Override // android.view.ViewTreeObserver.OnPreDrawListener
                    public boolean onPreDraw() {
                        view.getViewTreeObserver().removeOnPreDrawListener(this);
                        int measuredHeight = ChannelAdminLogActivity.this.chatListView.getMeasuredHeight();
                        int top = view.getTop();
                        view.getBottom();
                        int i = top >= 0 ? 0 : -top;
                        int measuredHeight2 = view.getMeasuredHeight();
                        if (measuredHeight2 > measuredHeight) {
                            measuredHeight2 = i + measuredHeight;
                        }
                        View view2 = holder.itemView;
                        if (view2 instanceof ChatMessageCell) {
                            ((ChatMessageCell) view).setVisiblePart(i, measuredHeight2 - i, (ChannelAdminLogActivity.this.contentView.getHeightWithKeyboard() - AndroidUtilities.dp(48.0f)) - ChannelAdminLogActivity.this.chatListView.getTop(), 0.0f, (view.getY() + ((BaseFragment) ChannelAdminLogActivity.this).actionBar.getMeasuredHeight()) - ChannelAdminLogActivity.this.contentView.getBackgroundTranslationY(), ChannelAdminLogActivity.this.contentView.getMeasuredWidth(), ChannelAdminLogActivity.this.contentView.getBackgroundSizeY());
                            return true;
                        }
                        if (!(view2 instanceof ChatActionCell) || ((BaseFragment) ChannelAdminLogActivity.this).actionBar == null || ChannelAdminLogActivity.this.contentView == null) {
                            return true;
                        }
                        View view3 = view;
                        ((ChatActionCell) view3).setVisiblePart((view3.getY() + ((BaseFragment) ChannelAdminLogActivity.this).actionBar.getMeasuredHeight()) - ChannelAdminLogActivity.this.contentView.getBackgroundTranslationY(), ChannelAdminLogActivity.this.contentView.getBackgroundSizeY());
                        return true;
                    }
                });
            }
            View view2 = holder.itemView;
            if (view2 instanceof ChatMessageCell) {
                ChatMessageCell chatMessageCell = (ChatMessageCell) view2;
                chatMessageCell.getMessageObject();
                chatMessageCell.setBackgroundDrawable(null);
                chatMessageCell.setCheckPressed(true, false);
                chatMessageCell.setHighlighted(false);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyDataSetChanged() {
            updateRows();
            try {
                super.notifyDataSetChanged();
            } catch (Exception e) {
                FileLog.e(e);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyItemChanged(int position) {
            updateRows();
            try {
                super.notifyItemChanged(position);
            } catch (Exception e) {
                FileLog.e(e);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyItemRangeChanged(int positionStart, int itemCount) {
            updateRows();
            try {
                super.notifyItemRangeChanged(positionStart, itemCount);
            } catch (Exception e) {
                FileLog.e(e);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyItemMoved(int fromPosition, int toPosition) {
            updateRows();
            try {
                super.notifyItemMoved(fromPosition, toPosition);
            } catch (Exception e) {
                FileLog.e(e);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyItemRangeInserted(int positionStart, int itemCount) {
            updateRows();
            try {
                super.notifyItemRangeInserted(positionStart, itemCount);
            } catch (Exception e) {
                FileLog.e(e);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyItemRemoved(int position) {
            updateRows();
            try {
                super.notifyItemRemoved(position);
            } catch (Exception e) {
                FileLog.e(e);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyItemRangeRemoved(int positionStart, int itemCount) {
            updateRows();
            try {
                super.notifyItemRangeRemoved(positionStart, itemCount);
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
    }

    /* renamed from: ir.eitaa.ui.ChannelAdminLogActivity$17, reason: invalid class name */
    static /* synthetic */ class AnonymousClass17 {
        static final /* synthetic */ int[] $SwitchMap$ir$eitaa$ui$AvatarPreviewer$MenuItem;

        static {
            int[] iArr = new int[AvatarPreviewer.MenuItem.values().length];
            $SwitchMap$ir$eitaa$ui$AvatarPreviewer$MenuItem = iArr;
            try {
                iArr[AvatarPreviewer.MenuItem.SEND_MESSAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$ir$eitaa$ui$AvatarPreviewer$MenuItem[AvatarPreviewer.MenuItem.OPEN_PROFILE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showInviteLinkBottomSheet(TLRPC$TL_messages_exportedChatInvite invite, HashMap<Long, TLRPC$User> usersMap) {
        TLRPC$ChatFull chatFull = getMessagesController().getChatFull(this.currentChat.id);
        InviteLinkBottomSheet inviteLinkBottomSheet = new InviteLinkBottomSheet(this.contentView.getContext(), (TLRPC$TL_chatInviteExported) invite.invite, chatFull, usersMap, this, chatFull.id, false, ChatObject.isChannel(this.currentChat));
        inviteLinkBottomSheet.setInviteDelegate(new InviteLinkBottomSheet.InviteDelegate() { // from class: ir.eitaa.ui.ChannelAdminLogActivity.16
            @Override // ir.eitaa.ui.Components.InviteLinkBottomSheet.InviteDelegate
            public void linkRevoked(TLRPC$TL_chatInviteExported invite2) {
                TLRPC$TL_channelAdminLogEvent tLRPC$TL_channelAdminLogEvent = new TLRPC$TL_channelAdminLogEvent();
                int size = ChannelAdminLogActivity.this.messages.size();
                invite2.revoked = true;
                TLRPC$TL_channelAdminLogEventActionExportedInviteRevoke tLRPC$TL_channelAdminLogEventActionExportedInviteRevoke = new TLRPC$TL_channelAdminLogEventActionExportedInviteRevoke();
                tLRPC$TL_channelAdminLogEventActionExportedInviteRevoke.invite = invite2;
                tLRPC$TL_channelAdminLogEvent.action = tLRPC$TL_channelAdminLogEventActionExportedInviteRevoke;
                tLRPC$TL_channelAdminLogEvent.date = (int) (System.currentTimeMillis() / 1000);
                tLRPC$TL_channelAdminLogEvent.user_id = ChannelAdminLogActivity.this.getAccountInstance().getUserConfig().clientUserId;
                int i = ((BaseFragment) ChannelAdminLogActivity.this).currentAccount;
                ChannelAdminLogActivity channelAdminLogActivity = ChannelAdminLogActivity.this;
                ArrayList<MessageObject> arrayList = channelAdminLogActivity.messages;
                HashMap map = channelAdminLogActivity.messagesByDays;
                ChannelAdminLogActivity channelAdminLogActivity2 = ChannelAdminLogActivity.this;
                if (new MessageObject(i, tLRPC$TL_channelAdminLogEvent, arrayList, (HashMap<String, ArrayList<MessageObject>>) map, channelAdminLogActivity2.currentChat, channelAdminLogActivity2.mid, true).contentType < 0) {
                    return;
                }
                int size2 = ChannelAdminLogActivity.this.messages.size() - size;
                if (size2 > 0) {
                    ChannelAdminLogActivity.this.chatListItemAnimator.setShouldAnimateEnterFromBottom(true);
                    ChannelAdminLogActivity.this.chatAdapter.notifyItemRangeInserted(ChannelAdminLogActivity.this.chatAdapter.messagesEndRow, size2);
                    ChannelAdminLogActivity.this.moveScrollToLastMessage();
                }
                ChannelAdminLogActivity.this.invitesCache.remove(invite2.link);
            }

            @Override // ir.eitaa.ui.Components.InviteLinkBottomSheet.InviteDelegate
            public void onLinkDeleted(TLRPC$TL_chatInviteExported invite2) {
                int size = ChannelAdminLogActivity.this.messages.size();
                int unused = ChannelAdminLogActivity.this.chatAdapter.messagesEndRow;
                TLRPC$TL_channelAdminLogEvent tLRPC$TL_channelAdminLogEvent = new TLRPC$TL_channelAdminLogEvent();
                TLRPC$TL_channelAdminLogEventActionExportedInviteDelete tLRPC$TL_channelAdminLogEventActionExportedInviteDelete = new TLRPC$TL_channelAdminLogEventActionExportedInviteDelete();
                tLRPC$TL_channelAdminLogEventActionExportedInviteDelete.invite = invite2;
                tLRPC$TL_channelAdminLogEvent.action = tLRPC$TL_channelAdminLogEventActionExportedInviteDelete;
                tLRPC$TL_channelAdminLogEvent.date = (int) (System.currentTimeMillis() / 1000);
                tLRPC$TL_channelAdminLogEvent.user_id = ChannelAdminLogActivity.this.getAccountInstance().getUserConfig().clientUserId;
                int i = ((BaseFragment) ChannelAdminLogActivity.this).currentAccount;
                ChannelAdminLogActivity channelAdminLogActivity = ChannelAdminLogActivity.this;
                ArrayList<MessageObject> arrayList = channelAdminLogActivity.messages;
                HashMap map = channelAdminLogActivity.messagesByDays;
                ChannelAdminLogActivity channelAdminLogActivity2 = ChannelAdminLogActivity.this;
                if (new MessageObject(i, tLRPC$TL_channelAdminLogEvent, arrayList, (HashMap<String, ArrayList<MessageObject>>) map, channelAdminLogActivity2.currentChat, channelAdminLogActivity2.mid, true).contentType < 0) {
                    return;
                }
                int size2 = ChannelAdminLogActivity.this.messages.size() - size;
                if (size2 > 0) {
                    ChannelAdminLogActivity.this.chatListItemAnimator.setShouldAnimateEnterFromBottom(true);
                    ChannelAdminLogActivity.this.chatAdapter.notifyItemRangeInserted(ChannelAdminLogActivity.this.chatAdapter.messagesEndRow, size2);
                    ChannelAdminLogActivity.this.moveScrollToLastMessage();
                }
                ChannelAdminLogActivity.this.invitesCache.remove(invite2.link);
            }

            @Override // ir.eitaa.ui.Components.InviteLinkBottomSheet.InviteDelegate
            public void onLinkEdited(TLRPC$TL_chatInviteExported invite2) {
                TLRPC$TL_channelAdminLogEvent tLRPC$TL_channelAdminLogEvent = new TLRPC$TL_channelAdminLogEvent();
                TLRPC$TL_channelAdminLogEventActionExportedInviteEdit tLRPC$TL_channelAdminLogEventActionExportedInviteEdit = new TLRPC$TL_channelAdminLogEventActionExportedInviteEdit();
                tLRPC$TL_channelAdminLogEventActionExportedInviteEdit.new_invite = invite2;
                tLRPC$TL_channelAdminLogEventActionExportedInviteEdit.prev_invite = invite2;
                tLRPC$TL_channelAdminLogEvent.action = tLRPC$TL_channelAdminLogEventActionExportedInviteEdit;
                tLRPC$TL_channelAdminLogEvent.date = (int) (System.currentTimeMillis() / 1000);
                tLRPC$TL_channelAdminLogEvent.user_id = ChannelAdminLogActivity.this.getAccountInstance().getUserConfig().clientUserId;
                int i = ((BaseFragment) ChannelAdminLogActivity.this).currentAccount;
                ChannelAdminLogActivity channelAdminLogActivity = ChannelAdminLogActivity.this;
                ArrayList<MessageObject> arrayList = channelAdminLogActivity.messages;
                HashMap map = channelAdminLogActivity.messagesByDays;
                ChannelAdminLogActivity channelAdminLogActivity2 = ChannelAdminLogActivity.this;
                if (new MessageObject(i, tLRPC$TL_channelAdminLogEvent, arrayList, (HashMap<String, ArrayList<MessageObject>>) map, channelAdminLogActivity2.currentChat, channelAdminLogActivity2.mid, true).contentType < 0) {
                    return;
                }
                ChannelAdminLogActivity.this.chatAdapter.notifyDataSetChanged();
                ChannelAdminLogActivity.this.moveScrollToLastMessage();
            }
        });
        inviteLinkBottomSheet.show();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.fragmentView, 0, null, null, null, null, "chat_wallpaper"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.chatListView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "actionBarDefaultIcon"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "actionBarDefaultSelector"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SUBMENUBACKGROUND, null, null, null, null, "actionBarDefaultSubmenuBackground"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SUBMENUITEM, null, null, null, null, "actionBarDefaultSubmenuItem"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SUBMENUITEM | ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, "actionBarDefaultSubmenuItemIcon"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.chatListView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "actionBarDefaultIcon"));
        arrayList.add(new ThemeDescription(this.avatarContainer.getTitleTextView(), ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "actionBarDefaultTitle"));
        arrayList.add(new ThemeDescription(this.avatarContainer.getSubtitleTextView(), ThemeDescription.FLAG_TEXTCOLOR, (Class[]) null, new Paint[]{Theme.chat_statusPaint, Theme.chat_statusRecordPaint}, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "actionBarDefaultSubtitle", (Object) null));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "actionBarDefaultSelector"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, Theme.avatarDrawables, null, "avatar_text"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "avatar_backgroundRed"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "avatar_backgroundOrange"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "avatar_backgroundViolet"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "avatar_backgroundGreen"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "avatar_backgroundCyan"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "avatar_backgroundBlue"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "avatar_backgroundPink"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "avatar_nameInMessageRed"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "avatar_nameInMessageOrange"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "avatar_nameInMessageViolet"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "avatar_nameInMessageGreen"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "avatar_nameInMessageCyan"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "avatar_nameInMessageBlue"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "avatar_nameInMessagePink"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, new Drawable[]{Theme.chat_msgInDrawable, Theme.chat_msgInMediaDrawable}, null, "chat_inBubble"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, new Drawable[]{Theme.chat_msgInSelectedDrawable, Theme.chat_msgInMediaSelectedDrawable}, null, "chat_inBubbleSelected"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, Theme.chat_msgInDrawable.getShadowDrawables(), null, "chat_inBubbleShadow"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, Theme.chat_msgInMediaDrawable.getShadowDrawables(), null, "chat_inBubbleShadow"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, Theme.chat_msgOutDrawable.getShadowDrawables(), null, "chat_outBubbleShadow"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, Theme.chat_msgOutMediaDrawable.getShadowDrawables(), null, "chat_outBubbleShadow"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, new Drawable[]{Theme.chat_msgOutDrawable, Theme.chat_msgOutMediaDrawable}, null, "chat_outBubble"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, new Drawable[]{Theme.chat_msgOutDrawable, Theme.chat_msgOutMediaDrawable}, null, "chat_outBubbleGradient"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, new Drawable[]{Theme.chat_msgOutDrawable, Theme.chat_msgOutMediaDrawable}, null, "chat_outBubbleGradient2"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, new Drawable[]{Theme.chat_msgOutDrawable, Theme.chat_msgOutMediaDrawable}, null, "chat_outBubbleGradient3"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, new Drawable[]{Theme.chat_msgOutSelectedDrawable, Theme.chat_msgOutMediaSelectedDrawable}, null, "chat_outBubbleSelected"));
        arrayList.add(new ThemeDescription(this.chatListView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{ChatActionCell.class}, Theme.chat_actionTextPaint, null, null, "chat_serviceText"));
        arrayList.add(new ThemeDescription(this.chatListView, ThemeDescription.FLAG_LINKCOLOR, new Class[]{ChatActionCell.class}, Theme.chat_actionTextPaint, null, null, "chat_serviceLink"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, new Drawable[]{Theme.chat_botCardDrawalbe, Theme.chat_shareIconDrawable, Theme.chat_botInlineDrawable, Theme.chat_botLinkDrawalbe, Theme.chat_goIconDrawable, Theme.chat_commentStickerDrawable}, null, "chat_serviceIcon"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class, ChatActionCell.class}, null, null, null, "chat_serviceBackground"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class, ChatActionCell.class}, null, null, null, "chat_serviceBackgroundSelected"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_messageTextIn"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_messageTextOut"));
        arrayList.add(new ThemeDescription(this.chatListView, ThemeDescription.FLAG_LINKCOLOR, new Class[]{ChatMessageCell.class}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "chat_messageLinkIn", (Object) null));
        arrayList.add(new ThemeDescription(this.chatListView, ThemeDescription.FLAG_LINKCOLOR, new Class[]{ChatMessageCell.class}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "chat_messageLinkOut", (Object) null));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, new Drawable[]{Theme.chat_msgOutCheckDrawable}, null, "chat_outSentCheck"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, new Drawable[]{Theme.chat_msgOutCheckSelectedDrawable}, null, "chat_outSentCheckSelected"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, new Drawable[]{Theme.chat_msgOutCheckReadDrawable, Theme.chat_msgOutHalfCheckDrawable}, null, "chat_outSentCheckRead"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, new Drawable[]{Theme.chat_msgOutCheckReadSelectedDrawable, Theme.chat_msgOutHalfCheckSelectedDrawable}, null, "chat_outSentCheckReadSelected"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, new Drawable[]{Theme.chat_msgMediaCheckDrawable, Theme.chat_msgMediaHalfCheckDrawable}, null, "chat_mediaSentCheck"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, new Drawable[]{Theme.chat_msgOutViewsDrawable, Theme.chat_msgOutRepliesDrawable, Theme.chat_msgOutPinnedDrawable}, null, "chat_outViews"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, new Drawable[]{Theme.chat_msgOutViewsSelectedDrawable, Theme.chat_msgOutRepliesSelectedDrawable, Theme.chat_msgOutPinnedSelectedDrawable}, null, "chat_outViewsSelected"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, new Drawable[]{Theme.chat_msgInViewsDrawable, Theme.chat_msgInRepliesDrawable, Theme.chat_msgInPinnedDrawable}, null, "chat_inViews"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, new Drawable[]{Theme.chat_msgInViewsSelectedDrawable, Theme.chat_msgInRepliesSelectedDrawable, Theme.chat_msgInPinnedSelectedDrawable}, null, "chat_inViewsSelected"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, new Drawable[]{Theme.chat_msgMediaViewsDrawable, Theme.chat_msgMediaRepliesDrawable, Theme.chat_msgMediaPinnedDrawable}, null, "chat_mediaViews"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, new Drawable[]{Theme.chat_msgOutMenuDrawable}, null, "chat_outMenu"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, new Drawable[]{Theme.chat_msgOutMenuSelectedDrawable}, null, "chat_outMenuSelected"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, new Drawable[]{Theme.chat_msgInMenuDrawable}, null, "chat_inMenu"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, new Drawable[]{Theme.chat_msgInMenuSelectedDrawable}, null, "chat_inMenuSelected"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, new Drawable[]{Theme.chat_msgMediaMenuDrawable}, null, "chat_mediaMenu"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, new Drawable[]{Theme.chat_msgOutInstantDrawable}, null, "chat_outInstant"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, new Drawable[]{Theme.chat_msgInInstantDrawable, Theme.chat_commentDrawable, Theme.chat_commentArrowDrawable}, null, "chat_inInstant"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, Theme.chat_msgOutCallDrawable, null, "chat_outInstant"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, Theme.chat_msgOutCallSelectedDrawable, null, "chat_outInstantSelected"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, Theme.chat_msgInCallDrawable, null, "chat_inInstant"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, Theme.chat_msgInCallSelectedDrawable, null, "chat_inInstantSelected"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, new Drawable[]{Theme.chat_msgCallUpGreenDrawable}, null, "chat_outUpCall"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, new Drawable[]{Theme.chat_msgCallDownRedDrawable}, null, "chat_inUpCall"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, new Drawable[]{Theme.chat_msgCallDownGreenDrawable}, null, "chat_inDownCall"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, Theme.chat_msgErrorPaint, null, null, "chat_sentError"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, new Drawable[]{Theme.chat_msgErrorDrawable}, null, "chat_sentErrorIcon"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, Theme.chat_durationPaint, null, null, "chat_previewDurationText"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, Theme.chat_gamePaint, null, null, "chat_previewGameText"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_inPreviewInstantText"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_outPreviewInstantText"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_inPreviewInstantSelectedText"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_outPreviewInstantSelectedText"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, Theme.chat_deleteProgressPaint, null, null, "chat_secretTimeText"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_stickerNameText"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, Theme.chat_botButtonPaint, null, null, "chat_botButtonText"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, Theme.chat_botProgressPaint, null, null, "chat_botProgress"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_inForwardedNameText"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_outForwardedNameText"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_inViaBotNameText"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_outViaBotNameText"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_stickerViaBotNameText"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_inReplyLine"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_outReplyLine"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_stickerReplyLine"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_inReplyNameText"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_outReplyNameText"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_stickerReplyNameText"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_inReplyMessageText"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_outReplyMessageText"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_inReplyMediaMessageText"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_outReplyMediaMessageText"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_inReplyMediaMessageSelectedText"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_outReplyMediaMessageSelectedText"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_stickerReplyMessageText"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_inPreviewLine"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_outPreviewLine"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_inSiteNameText"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_outSiteNameText"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_inContactNameText"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_outContactNameText"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_inContactPhoneText"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_outContactPhoneText"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_mediaProgress"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_inAudioProgress"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_outAudioProgress"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_inAudioSelectedProgress"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_outAudioSelectedProgress"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_mediaTimeText"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_inTimeText"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_outTimeText"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_inTimeSelectedText"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_outTimeSelectedText"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_inAudioPerfomerText"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_outAudioPerfomerText"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_inAudioTitleText"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_outAudioTitleText"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_inAudioDurationText"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_outAudioDurationText"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_inAudioDurationSelectedText"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_outAudioDurationSelectedText"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_inAudioSeekbar"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_outAudioSeekbar"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_inAudioSeekbarSelected"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_outAudioSeekbarSelected"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_inAudioSeekbarFill"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_inAudioCacheSeekbar"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_outAudioSeekbarFill"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_outAudioCacheSeekbar"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_inVoiceSeekbar"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_outVoiceSeekbar"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_inVoiceSeekbarSelected"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_outVoiceSeekbarSelected"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_inVoiceSeekbarFill"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_outVoiceSeekbarFill"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_inFileProgress"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_outFileProgress"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_inFileProgressSelected"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_outFileProgressSelected"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_inFileNameText"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_outFileNameText"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_inFileInfoText"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_outFileInfoText"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_inFileInfoSelectedText"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_outFileInfoSelectedText"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_inFileBackground"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_outFileBackground"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_inFileBackgroundSelected"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_outFileBackgroundSelected"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_inVenueInfoText"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_outVenueInfoText"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_inVenueInfoSelectedText"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_outVenueInfoSelectedText"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_mediaInfoText"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, Theme.chat_urlPaint, null, null, "chat_linkSelectBackground"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, Theme.chat_textSearchSelectionPaint, null, null, "chat_textSelectBackground"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_outLoader"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_outMediaIcon"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_outLoaderSelected"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_outMediaIconSelected"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_inLoader"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_inMediaIcon"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_inLoaderSelected"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_inMediaIconSelected"));
        Drawable[][] drawableArr = Theme.chat_photoStatesDrawables;
        arrayList.add(new ThemeDescription(this.chatListView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ChatMessageCell.class}, null, new Drawable[]{drawableArr[0][0], drawableArr[1][0], drawableArr[2][0], drawableArr[3][0]}, null, "chat_mediaLoaderPhoto"));
        Drawable[][] drawableArr2 = Theme.chat_photoStatesDrawables;
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, new Drawable[]{drawableArr2[0][0], drawableArr2[1][0], drawableArr2[2][0], drawableArr2[3][0]}, null, "chat_mediaLoaderPhotoIcon"));
        Drawable[][] drawableArr3 = Theme.chat_photoStatesDrawables;
        arrayList.add(new ThemeDescription(this.chatListView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ChatMessageCell.class}, null, new Drawable[]{drawableArr3[0][1], drawableArr3[1][1], drawableArr3[2][1], drawableArr3[3][1]}, null, "chat_mediaLoaderPhotoSelected"));
        Drawable[][] drawableArr4 = Theme.chat_photoStatesDrawables;
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, new Drawable[]{drawableArr4[0][1], drawableArr4[1][1], drawableArr4[2][1], drawableArr4[3][1]}, null, "chat_mediaLoaderPhotoIconSelected"));
        Drawable[][] drawableArr5 = Theme.chat_photoStatesDrawables;
        arrayList.add(new ThemeDescription(this.chatListView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ChatMessageCell.class}, null, new Drawable[]{drawableArr5[7][0], drawableArr5[8][0]}, null, "chat_outLoaderPhoto"));
        Drawable[][] drawableArr6 = Theme.chat_photoStatesDrawables;
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, new Drawable[]{drawableArr6[7][0], drawableArr6[8][0]}, null, "chat_outLoaderPhotoIcon"));
        Drawable[][] drawableArr7 = Theme.chat_photoStatesDrawables;
        arrayList.add(new ThemeDescription(this.chatListView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ChatMessageCell.class}, null, new Drawable[]{drawableArr7[7][1], drawableArr7[8][1]}, null, "chat_outLoaderPhotoSelected"));
        Drawable[][] drawableArr8 = Theme.chat_photoStatesDrawables;
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, new Drawable[]{drawableArr8[7][1], drawableArr8[8][1]}, null, "chat_outLoaderPhotoIconSelected"));
        Drawable[][] drawableArr9 = Theme.chat_photoStatesDrawables;
        arrayList.add(new ThemeDescription(this.chatListView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ChatMessageCell.class}, null, new Drawable[]{drawableArr9[10][0], drawableArr9[11][0]}, null, "chat_inLoaderPhoto"));
        Drawable[][] drawableArr10 = Theme.chat_photoStatesDrawables;
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, new Drawable[]{drawableArr10[10][0], drawableArr10[11][0]}, null, "chat_inLoaderPhotoIcon"));
        Drawable[][] drawableArr11 = Theme.chat_photoStatesDrawables;
        arrayList.add(new ThemeDescription(this.chatListView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ChatMessageCell.class}, null, new Drawable[]{drawableArr11[10][1], drawableArr11[11][1]}, null, "chat_inLoaderPhotoSelected"));
        Drawable[][] drawableArr12 = Theme.chat_photoStatesDrawables;
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, new Drawable[]{drawableArr12[10][1], drawableArr12[11][1]}, null, "chat_inLoaderPhotoIconSelected"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, new Drawable[]{Theme.chat_photoStatesDrawables[9][0]}, null, "chat_outFileIcon"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, new Drawable[]{Theme.chat_photoStatesDrawables[9][1]}, null, "chat_outFileSelectedIcon"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, new Drawable[]{Theme.chat_photoStatesDrawables[12][0]}, null, "chat_inFileIcon"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, new Drawable[]{Theme.chat_photoStatesDrawables[12][1]}, null, "chat_inFileSelectedIcon"));
        arrayList.add(new ThemeDescription(this.chatListView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ChatMessageCell.class}, null, new Drawable[]{Theme.chat_contactDrawable[0]}, null, "chat_inContactBackground"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, new Drawable[]{Theme.chat_contactDrawable[0]}, null, "chat_inContactIcon"));
        arrayList.add(new ThemeDescription(this.chatListView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ChatMessageCell.class}, null, new Drawable[]{Theme.chat_contactDrawable[1]}, null, "chat_outContactBackground"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, new Drawable[]{Theme.chat_contactDrawable[1]}, null, "chat_outContactIcon"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_inLocationBackground"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, new Drawable[]{Theme.chat_locationDrawable[0]}, null, "chat_inLocationIcon"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_outLocationBackground"));
        arrayList.add(new ThemeDescription(this.chatListView, 0, new Class[]{ChatMessageCell.class}, null, new Drawable[]{Theme.chat_locationDrawable[1]}, null, "chat_outLocationIcon"));
        arrayList.add(new ThemeDescription(this.bottomOverlayChat, 0, null, Theme.chat_composeBackgroundPaint, null, null, "chat_messagePanelBackground"));
        arrayList.add(new ThemeDescription(this.bottomOverlayChat, 0, null, null, new Drawable[]{Theme.chat_composeShadowDrawable}, null, "chat_messagePanelShadow"));
        arrayList.add(new ThemeDescription(this.bottomOverlayChatText, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "chat_fieldOverlayText"));
        arrayList.add(new ThemeDescription(this.emptyView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "chat_serviceText"));
        arrayList.add(new ThemeDescription(this.progressBar, ThemeDescription.FLAG_PROGRESSBAR, null, null, null, null, "chat_serviceText"));
        arrayList.add(new ThemeDescription(this.chatListView, ThemeDescription.FLAG_USEBACKGROUNDDRAWABLE, new Class[]{ChatUnreadCell.class}, new String[]{"backgroundLayout"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "chat_unreadMessagesStartBackground"));
        arrayList.add(new ThemeDescription(this.chatListView, ThemeDescription.FLAG_IMAGECOLOR, new Class[]{ChatUnreadCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "chat_unreadMessagesStartArrowIcon"));
        arrayList.add(new ThemeDescription(this.chatListView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{ChatUnreadCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "chat_unreadMessagesStartText"));
        arrayList.add(new ThemeDescription(this.progressView2, ThemeDescription.FLAG_SERVICEBACKGROUND, null, null, null, null, "chat_serviceBackground"));
        arrayList.add(new ThemeDescription(this.emptyView, ThemeDescription.FLAG_SERVICEBACKGROUND, null, null, null, null, "chat_serviceBackground"));
        arrayList.add(new ThemeDescription(this.chatListView, ThemeDescription.FLAG_SERVICEBACKGROUND, new Class[]{ChatLoadingCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "chat_serviceBackground"));
        arrayList.add(new ThemeDescription(this.chatListView, ThemeDescription.FLAG_PROGRESSBAR, new Class[]{ChatLoadingCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "chat_serviceText"));
        ChatAvatarContainer chatAvatarContainer = this.avatarContainer;
        arrayList.add(new ThemeDescription(chatAvatarContainer != null ? chatAvatarContainer.getTimeItem() : null, 0, null, null, null, null, "chat_secretTimerBackground"));
        ChatAvatarContainer chatAvatarContainer2 = this.avatarContainer;
        arrayList.add(new ThemeDescription(chatAvatarContainer2 != null ? chatAvatarContainer2.getTimeItem() : null, 0, null, null, null, null, "chat_secretTimerText"));
        arrayList.add(new ThemeDescription(this.undoView, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "undo_background"));
        arrayList.add(new ThemeDescription(this.undoView, 0, new Class[]{UndoView.class}, new String[]{"undoImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "undo_cancelColor"));
        arrayList.add(new ThemeDescription(this.undoView, 0, new Class[]{UndoView.class}, new String[]{"undoTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "undo_cancelColor"));
        arrayList.add(new ThemeDescription(this.undoView, 0, new Class[]{UndoView.class}, new String[]{"infoTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "undo_infoColor"));
        arrayList.add(new ThemeDescription(this.undoView, 0, new Class[]{UndoView.class}, new String[]{"textPaint"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "undo_infoColor"));
        arrayList.add(new ThemeDescription(this.undoView, 0, new Class[]{UndoView.class}, new String[]{"progressPaint"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "undo_infoColor"));
        arrayList.add(new ThemeDescription(this.undoView, ThemeDescription.FLAG_IMAGECOLOR, new Class[]{UndoView.class}, new String[]{"leftImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "undo_infoColor"));
        return arrayList;
    }
}
