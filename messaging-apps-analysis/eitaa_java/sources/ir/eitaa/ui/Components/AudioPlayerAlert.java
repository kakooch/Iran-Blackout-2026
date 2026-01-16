package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ContactsController;
import ir.eitaa.messenger.DialogObject;
import ir.eitaa.messenger.DispatchQueue;
import ir.eitaa.messenger.DownloadController;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.ImageLoader;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MediaController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SendMessagesHelper;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.messenger.audioinfo.AudioInfo;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$Document;
import ir.eitaa.tgnet.TLRPC$DocumentAttribute;
import ir.eitaa.tgnet.TLRPC$EncryptedChat;
import ir.eitaa.tgnet.TLRPC$PhotoSize;
import ir.eitaa.tgnet.TLRPC$TL_documentAttributeAudio;
import ir.eitaa.tgnet.TLRPC$TL_photoSize;
import ir.eitaa.tgnet.TLRPC$TL_photoSizeProgressive;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.ActionBarMenuItem;
import ir.eitaa.ui.ActionBar.ActionBarMenuSubItem;
import ir.eitaa.ui.ActionBar.BottomSheet;
import ir.eitaa.ui.ActionBar.SimpleTextView;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Cells.AudioPlayerCell;
import ir.eitaa.ui.ChatActivity;
import ir.eitaa.ui.Components.AudioPlayerAlert;
import ir.eitaa.ui.Components.Bulletin;
import ir.eitaa.ui.Components.BulletinFactory;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.Components.SeekBarView;
import ir.eitaa.ui.DialogsActivity;
import ir.eitaa.ui.LaunchActivity;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class AudioPlayerAlert extends BottomSheet implements NotificationCenter.NotificationCenterDelegate, DownloadController.FileDownloadProgressListener {
    private int TAG;
    private ActionBar actionBar;
    private AnimatorSet actionBarAnimation;
    private View actionBarShadow;
    private ClippingTextViewSwitcher authorTextView;
    private BackupImageView bigAlbumConver;
    private boolean blurredAnimationInProgress;
    private FrameLayout blurredView;
    private View[] buttons;
    private CoverContainer coverContainer;
    private boolean currentAudioFinishedLoading;
    private String currentFile;
    private boolean draggingSeekBar;
    private TextView durationTextView;
    private ImageView emptyImageView;
    private TextView emptySubtitleTextView;
    private TextView emptyTitleTextView;
    private LinearLayout emptyView;
    private final Runnable forwardSeek;
    private boolean inFullSize;
    private long lastBufferedPositionCheck;
    private int lastDuration;
    private MessageObject lastMessageObject;
    long lastRewindingTime;
    private int lastTime;
    long lastUpdateRewindingPlayerTime;
    private LinearLayoutManager layoutManager;
    private ListAdapter listAdapter;
    private RecyclerListView listView;
    private RLottieImageView nextButton;
    private ActionBarMenuItem optionsButton;
    private LaunchActivity parentActivity;
    private ImageView playButton;
    private PlayPauseDrawable playPauseDrawable;
    private ActionBarMenuItem playbackSpeedButton;
    private FrameLayout playerLayout;
    private View playerShadow;
    private ArrayList<MessageObject> playlist;
    private RLottieImageView prevButton;
    private LineProgressView progressView;
    private ActionBarMenuItem repeatButton;
    private ActionBarMenuSubItem repeatListItem;
    private ActionBarMenuSubItem repeatSongItem;
    private ActionBarMenuSubItem reverseOrderItem;
    int rewindingForwardPressedCount;
    float rewindingProgress;
    int rewindingState;
    private int scrollOffsetY;
    private boolean scrollToSong;
    private ActionBarMenuItem searchItem;
    private int searchOpenOffset;
    private int searchOpenPosition;
    private boolean searchWas;
    private boolean searching;
    private SeekBarView seekBarView;
    private ActionBarMenuSubItem shuffleListItem;
    private ActionBarMenuSubItem[] speedItems;
    private SimpleTextView timeTextView;
    private ClippingTextViewSwitcher titleTextView;

    static /* synthetic */ boolean lambda$new$7(View view, MotionEvent motionEvent) {
        return true;
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet
    protected boolean canDismissWithSwipe() {
        return false;
    }

    @Override // ir.eitaa.messenger.DownloadController.FileDownloadProgressListener
    public void onFailedDownload(String fileName, boolean canceled) {
    }

    @Override // ir.eitaa.messenger.DownloadController.FileDownloadProgressListener
    public void onProgressUpload(String fileName, long uploadedSize, long totalSize, boolean isEncrypted) {
    }

    @Override // ir.eitaa.messenger.DownloadController.FileDownloadProgressListener
    public void onSuccessDownload(String fileName) {
    }

    public AudioPlayerAlert(final Context context, Theme.ResourcesProvider resourcesProvider) {
        TLRPC$User user;
        super(context, true, resourcesProvider);
        this.speedItems = new ActionBarMenuSubItem[4];
        this.buttons = new View[5];
        this.scrollToSong = true;
        this.searchOpenPosition = -1;
        this.scrollOffsetY = ConnectionsManager.DEFAULT_DATACENTER_ID;
        this.rewindingProgress = -1.0f;
        this.forwardSeek = new Runnable() { // from class: ir.eitaa.ui.Components.AudioPlayerAlert.1
            @Override // java.lang.Runnable
            public void run() {
                long duration = MediaController.getInstance().getDuration();
                if (duration == 0 || duration == -9223372036854775807L) {
                    AudioPlayerAlert.this.lastRewindingTime = System.currentTimeMillis();
                    return;
                }
                float f = AudioPlayerAlert.this.rewindingProgress;
                long jCurrentTimeMillis = System.currentTimeMillis();
                AudioPlayerAlert audioPlayerAlert = AudioPlayerAlert.this;
                long j = jCurrentTimeMillis - audioPlayerAlert.lastRewindingTime;
                audioPlayerAlert.lastRewindingTime = jCurrentTimeMillis;
                long j2 = jCurrentTimeMillis - audioPlayerAlert.lastUpdateRewindingPlayerTime;
                int i = audioPlayerAlert.rewindingForwardPressedCount;
                float f2 = ((long) ((f * r0) + (((i == 1 ? 3L : i == 2 ? 6L : 12L) * j) - j))) / duration;
                if (f2 < 0.0f) {
                    f2 = 0.0f;
                }
                audioPlayerAlert.rewindingProgress = f2;
                MessageObject playingMessageObject = MediaController.getInstance().getPlayingMessageObject();
                if (playingMessageObject != null && playingMessageObject.isMusic()) {
                    if (!MediaController.getInstance().isMessagePaused()) {
                        MediaController.getInstance().getPlayingMessageObject().audioProgress = AudioPlayerAlert.this.rewindingProgress;
                    }
                    AudioPlayerAlert.this.updateProgress(playingMessageObject);
                }
                AudioPlayerAlert audioPlayerAlert2 = AudioPlayerAlert.this;
                if (audioPlayerAlert2.rewindingState == 1 && audioPlayerAlert2.rewindingForwardPressedCount > 0 && MediaController.getInstance().isMessagePaused()) {
                    if (j2 > 200 || AudioPlayerAlert.this.rewindingProgress == 0.0f) {
                        AudioPlayerAlert.this.lastUpdateRewindingPlayerTime = jCurrentTimeMillis;
                        MediaController.getInstance().seekToProgress(MediaController.getInstance().getPlayingMessageObject(), f2);
                    }
                    AudioPlayerAlert audioPlayerAlert3 = AudioPlayerAlert.this;
                    if (audioPlayerAlert3.rewindingForwardPressedCount <= 0 || audioPlayerAlert3.rewindingProgress <= 0.0f) {
                        return;
                    }
                    AndroidUtilities.runOnUIThread(audioPlayerAlert3.forwardSeek, 16L);
                }
            }
        };
        MessageObject playingMessageObject = MediaController.getInstance().getPlayingMessageObject();
        if (playingMessageObject != null) {
            this.currentAccount = playingMessageObject.currentAccount;
        } else {
            this.currentAccount = UserConfig.selectedAccount;
        }
        this.parentActivity = (LaunchActivity) context;
        this.TAG = DownloadController.getInstance(this.currentAccount).generateObserverTag();
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.messagePlayingDidReset);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.messagePlayingPlayStateChanged);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.messagePlayingDidStart);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.messagePlayingProgressDidChanged);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.fileLoaded);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.fileLoadProgressChanged);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.musicDidLoad);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.moreMusicDidLoad);
        FrameLayout frameLayout = new FrameLayout(context) { // from class: ir.eitaa.ui.Components.AudioPlayerAlert.2
            private int lastMeasturedHeight;
            private int lastMeasturedWidth;
            private RectF rect = new RectF();
            private boolean ignoreLayout = false;

            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent e) {
                return !AudioPlayerAlert.this.isDismissed() && super.onTouchEvent(e);
            }

            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                int iDp;
                int size = View.MeasureSpec.getSize(heightMeasureSpec);
                int size2 = View.MeasureSpec.getSize(widthMeasureSpec);
                if (size != this.lastMeasturedHeight || size2 != this.lastMeasturedWidth) {
                    if (AudioPlayerAlert.this.blurredView.getTag() != null) {
                        AudioPlayerAlert.this.showAlbumCover(false, false);
                    }
                    this.lastMeasturedWidth = size2;
                    this.lastMeasturedHeight = size;
                }
                this.ignoreLayout = true;
                if (Build.VERSION.SDK_INT >= 21 && !((BottomSheet) AudioPlayerAlert.this).isFullscreen) {
                    setPadding(((BottomSheet) AudioPlayerAlert.this).backgroundPaddingLeft, AndroidUtilities.statusBarHeight, ((BottomSheet) AudioPlayerAlert.this).backgroundPaddingLeft, 0);
                }
                AudioPlayerAlert.this.playerLayout.setVisibility((AudioPlayerAlert.this.searchWas || ((BottomSheet) AudioPlayerAlert.this).keyboardVisible) ? 4 : 0);
                AudioPlayerAlert.this.playerShadow.setVisibility(AudioPlayerAlert.this.playerLayout.getVisibility());
                int paddingTop = size - getPaddingTop();
                ((FrameLayout.LayoutParams) AudioPlayerAlert.this.listView.getLayoutParams()).topMargin = ActionBar.getCurrentActionBarHeight();
                ((FrameLayout.LayoutParams) AudioPlayerAlert.this.actionBarShadow.getLayoutParams()).topMargin = ActionBar.getCurrentActionBarHeight();
                ((FrameLayout.LayoutParams) AudioPlayerAlert.this.blurredView.getLayoutParams()).topMargin = -getPaddingTop();
                int iDp2 = AndroidUtilities.dp(179.0f);
                if (AudioPlayerAlert.this.playlist.size() > 1) {
                    iDp2 += ((BottomSheet) AudioPlayerAlert.this).backgroundPaddingTop + (AudioPlayerAlert.this.playlist.size() * AndroidUtilities.dp(56.0f));
                }
                if (AudioPlayerAlert.this.searching || ((BottomSheet) AudioPlayerAlert.this).keyboardVisible) {
                    iDp = AndroidUtilities.dp(8.0f);
                } else {
                    if (iDp2 >= paddingTop) {
                        iDp2 = (int) ((paddingTop / 5) * 3.5f);
                    }
                    iDp = (paddingTop - iDp2) + AndroidUtilities.dp(8.0f);
                    if (iDp > paddingTop - AndroidUtilities.dp(329.0f)) {
                        iDp = paddingTop - AndroidUtilities.dp(329.0f);
                    }
                    if (iDp < 0) {
                        iDp = 0;
                    }
                }
                if (AudioPlayerAlert.this.listView.getPaddingTop() != iDp) {
                    AudioPlayerAlert.this.listView.setPadding(0, iDp, 0, (AudioPlayerAlert.this.searching && ((BottomSheet) AudioPlayerAlert.this).keyboardVisible) ? 0 : AudioPlayerAlert.this.listView.getPaddingBottom());
                }
                this.ignoreLayout = false;
                super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(size, 1073741824));
                AudioPlayerAlert.this.inFullSize = getMeasuredHeight() >= size;
            }

            @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
                super.onLayout(changed, left, top, right, bottom);
                AudioPlayerAlert.this.updateLayout();
                AudioPlayerAlert.this.updateEmptyViewPosition();
            }

            @Override // android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent ev) {
                if (ev.getAction() == 0 && AudioPlayerAlert.this.scrollOffsetY != 0 && AudioPlayerAlert.this.actionBar.getAlpha() == 0.0f) {
                    boolean z = false;
                    if (AudioPlayerAlert.this.listAdapter.getItemCount() <= 0 ? ev.getY() < getMeasuredHeight() - AndroidUtilities.dp(191.0f) : ev.getY() < AudioPlayerAlert.this.scrollOffsetY + AndroidUtilities.dp(12.0f)) {
                        z = true;
                    }
                    if (z) {
                        AudioPlayerAlert.this.dismiss();
                        return true;
                    }
                }
                return super.onInterceptTouchEvent(ev);
            }

            @Override // android.view.View, android.view.ViewParent
            public void requestLayout() {
                if (this.ignoreLayout) {
                    return;
                }
                super.requestLayout();
            }

            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                float f;
                if (AudioPlayerAlert.this.playlist.size() <= 1) {
                    ((BottomSheet) AudioPlayerAlert.this).shadowDrawable.setBounds(0, (getMeasuredHeight() - AudioPlayerAlert.this.playerLayout.getMeasuredHeight()) - ((BottomSheet) AudioPlayerAlert.this).backgroundPaddingTop, getMeasuredWidth(), getMeasuredHeight());
                    ((BottomSheet) AudioPlayerAlert.this).shadowDrawable.draw(canvas);
                    return;
                }
                int iDp = AndroidUtilities.dp(13.0f);
                int translationY = (AudioPlayerAlert.this.scrollOffsetY - ((BottomSheet) AudioPlayerAlert.this).backgroundPaddingTop) - iDp;
                if (((BottomSheet) AudioPlayerAlert.this).currentSheetAnimationType == 1) {
                    translationY = (int) (translationY + AudioPlayerAlert.this.listView.getTranslationY());
                }
                int iDp2 = AndroidUtilities.dp(20.0f) + translationY;
                int measuredHeight = getMeasuredHeight() + AndroidUtilities.dp(15.0f) + ((BottomSheet) AudioPlayerAlert.this).backgroundPaddingTop;
                if (((BottomSheet) AudioPlayerAlert.this).backgroundPaddingTop + translationY < ActionBar.getCurrentActionBarHeight()) {
                    float fDp = iDp + AndroidUtilities.dp(4.0f);
                    float fMin = Math.min(1.0f, ((ActionBar.getCurrentActionBarHeight() - translationY) - ((BottomSheet) AudioPlayerAlert.this).backgroundPaddingTop) / fDp);
                    int currentActionBarHeight = (int) ((ActionBar.getCurrentActionBarHeight() - fDp) * fMin);
                    translationY -= currentActionBarHeight;
                    iDp2 -= currentActionBarHeight;
                    measuredHeight += currentActionBarHeight;
                    f = 1.0f - fMin;
                } else {
                    f = 1.0f;
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    int i = AndroidUtilities.statusBarHeight;
                    translationY += i;
                    iDp2 += i;
                }
                ((BottomSheet) AudioPlayerAlert.this).shadowDrawable.setBounds(0, translationY, getMeasuredWidth(), measuredHeight);
                ((BottomSheet) AudioPlayerAlert.this).shadowDrawable.draw(canvas);
                if (f != 1.0f) {
                    Theme.dialogs_onlineCirclePaint.setColor(AudioPlayerAlert.this.getThemedColor("dialogBackground"));
                    this.rect.set(((BottomSheet) AudioPlayerAlert.this).backgroundPaddingLeft, ((BottomSheet) AudioPlayerAlert.this).backgroundPaddingTop + translationY, getMeasuredWidth() - ((BottomSheet) AudioPlayerAlert.this).backgroundPaddingLeft, ((BottomSheet) AudioPlayerAlert.this).backgroundPaddingTop + translationY + AndroidUtilities.dp(24.0f));
                    canvas.drawRoundRect(this.rect, AndroidUtilities.dp(12.0f) * f, AndroidUtilities.dp(12.0f) * f, Theme.dialogs_onlineCirclePaint);
                }
                if (f != 0.0f) {
                    int iDp3 = AndroidUtilities.dp(36.0f);
                    this.rect.set((getMeasuredWidth() - iDp3) / 2, iDp2, (getMeasuredWidth() + iDp3) / 2, iDp2 + AndroidUtilities.dp(4.0f));
                    int themedColor = AudioPlayerAlert.this.getThemedColor("key_sheet_scrollUp");
                    int iAlpha = Color.alpha(themedColor);
                    Theme.dialogs_onlineCirclePaint.setColor(themedColor);
                    Theme.dialogs_onlineCirclePaint.setAlpha((int) (iAlpha * 1.0f * f));
                    canvas.drawRoundRect(this.rect, AndroidUtilities.dp(2.0f), AndroidUtilities.dp(2.0f), Theme.dialogs_onlineCirclePaint);
                }
                int themedColor2 = AudioPlayerAlert.this.getThemedColor("dialogBackground");
                Theme.dialogs_onlineCirclePaint.setColor(Color.argb((int) (AudioPlayerAlert.this.actionBar.getAlpha() * 255.0f), (int) (Color.red(themedColor2) * 0.8f), (int) (Color.green(themedColor2) * 0.8f), (int) (Color.blue(themedColor2) * 0.8f)));
                canvas.drawRect(((BottomSheet) AudioPlayerAlert.this).backgroundPaddingLeft, 0.0f, getMeasuredWidth() - ((BottomSheet) AudioPlayerAlert.this).backgroundPaddingLeft, AndroidUtilities.statusBarHeight, Theme.dialogs_onlineCirclePaint);
            }

            @Override // android.view.ViewGroup, android.view.View
            protected void onAttachedToWindow() {
                super.onAttachedToWindow();
                Bulletin.addDelegate(this, new Bulletin.Delegate() { // from class: ir.eitaa.ui.Components.AudioPlayerAlert.2.1
                    @Override // ir.eitaa.ui.Components.Bulletin.Delegate
                    public /* synthetic */ void onHide(Bulletin bulletin) {
                        Bulletin.Delegate.CC.$default$onHide(this, bulletin);
                    }

                    @Override // ir.eitaa.ui.Components.Bulletin.Delegate
                    public /* synthetic */ void onOffsetChange(float f) {
                        Bulletin.Delegate.CC.$default$onOffsetChange(this, f);
                    }

                    @Override // ir.eitaa.ui.Components.Bulletin.Delegate
                    public /* synthetic */ void onShow(Bulletin bulletin) {
                        Bulletin.Delegate.CC.$default$onShow(this, bulletin);
                    }

                    @Override // ir.eitaa.ui.Components.Bulletin.Delegate
                    public int getBottomOffset(int tag) {
                        return AudioPlayerAlert.this.playerLayout.getHeight();
                    }
                });
            }

            @Override // android.view.ViewGroup, android.view.View
            protected void onDetachedFromWindow() {
                super.onDetachedFromWindow();
                Bulletin.removeDelegate(this);
            }
        };
        this.containerView = frameLayout;
        frameLayout.setWillNotDraw(false);
        ViewGroup viewGroup = this.containerView;
        int i = this.backgroundPaddingLeft;
        viewGroup.setPadding(i, 0, i, 0);
        ActionBar actionBar = new ActionBar(context, resourcesProvider) { // from class: ir.eitaa.ui.Components.AudioPlayerAlert.3
            @Override // android.view.View
            public void setAlpha(float alpha) {
                super.setAlpha(alpha);
                ((BottomSheet) AudioPlayerAlert.this).containerView.invalidate();
            }
        };
        this.actionBar = actionBar;
        actionBar.setBackgroundColor(getThemedColor("player_actionBar"));
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setItemsColor(getThemedColor("player_actionBarTitle"), false);
        this.actionBar.setItemsBackgroundColor(getThemedColor("player_actionBarSelector"), false);
        this.actionBar.setTitleColor(getThemedColor("player_actionBarTitle"));
        this.actionBar.setTitle(LocaleController.getString("AttachMusic", R.string.AttachMusic));
        this.actionBar.setSubtitleColor(getThemedColor("player_actionBarSubtitle"));
        this.actionBar.setOccupyStatusBar(false);
        this.actionBar.setAlpha(0.0f);
        if (playingMessageObject != null && !MediaController.getInstance().currentPlaylistIsGlobalSearch()) {
            long dialogId = playingMessageObject.getDialogId();
            if (DialogObject.isEncryptedDialog(dialogId)) {
                TLRPC$EncryptedChat encryptedChat = MessagesController.getInstance(this.currentAccount).getEncryptedChat(Integer.valueOf(DialogObject.getEncryptedChatId(dialogId)));
                if (encryptedChat != null && (user = MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(encryptedChat.user_id))) != null) {
                    this.actionBar.setTitle(ContactsController.formatName(user.first_name, user.last_name));
                }
            } else if (DialogObject.isUserDialog(dialogId)) {
                TLRPC$User user2 = MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(dialogId));
                if (user2 != null) {
                    this.actionBar.setTitle(ContactsController.formatName(user2.first_name, user2.last_name));
                }
            } else {
                TLRPC$Chat chat = MessagesController.getInstance(this.currentAccount).getChat(Long.valueOf(-dialogId));
                if (chat != null) {
                    this.actionBar.setTitle(chat.title);
                }
            }
        }
        ActionBarMenuItem actionBarMenuItemSearchListener = this.actionBar.createMenu().addItem(0, R.drawable.ic_ab_search).setIsSearchField(true).setActionBarMenuItemSearchListener(new ActionBarMenuItem.ActionBarMenuItemSearchListener() { // from class: ir.eitaa.ui.Components.AudioPlayerAlert.4
            @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
            public void onSearchCollapse() throws InterruptedException {
                if (AudioPlayerAlert.this.searching) {
                    AudioPlayerAlert.this.searchWas = false;
                    AudioPlayerAlert.this.searching = false;
                    AudioPlayerAlert.this.setAllowNestedScroll(true);
                    AudioPlayerAlert.this.listAdapter.search(null);
                }
            }

            @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
            public void onSearchExpand() {
                AudioPlayerAlert audioPlayerAlert = AudioPlayerAlert.this;
                audioPlayerAlert.searchOpenPosition = audioPlayerAlert.layoutManager.findLastVisibleItemPosition();
                View viewFindViewByPosition = AudioPlayerAlert.this.layoutManager.findViewByPosition(AudioPlayerAlert.this.searchOpenPosition);
                AudioPlayerAlert.this.searchOpenOffset = viewFindViewByPosition == null ? 0 : viewFindViewByPosition.getTop();
                AudioPlayerAlert.this.searching = true;
                AudioPlayerAlert.this.setAllowNestedScroll(false);
                AudioPlayerAlert.this.listAdapter.notifyDataSetChanged();
            }

            @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
            public void onTextChanged(EditText editText) throws InterruptedException {
                if (editText.length() > 0) {
                    AudioPlayerAlert.this.listAdapter.search(editText.getText().toString());
                } else {
                    AudioPlayerAlert.this.searchWas = false;
                    AudioPlayerAlert.this.listAdapter.search(null);
                }
            }
        });
        this.searchItem = actionBarMenuItemSearchListener;
        actionBarMenuItemSearchListener.setContentDescription(LocaleController.getString("Search", R.string.Search));
        EditTextBoldCursor searchField = this.searchItem.getSearchField();
        searchField.setHint(LocaleController.getString("Search", R.string.Search));
        searchField.setTextColor(getThemedColor("player_actionBarTitle"));
        searchField.setHintTextColor(getThemedColor("player_time"));
        searchField.setCursorColor(getThemedColor("player_actionBarTitle"));
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.eitaa.ui.Components.AudioPlayerAlert.5
            @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int id) {
                if (id != -1) {
                    AudioPlayerAlert.this.onSubItemClick(id);
                } else {
                    AudioPlayerAlert.this.dismiss();
                }
            }
        });
        View view = new View(context);
        this.actionBarShadow = view;
        view.setAlpha(0.0f);
        this.actionBarShadow.setBackgroundResource(R.drawable.header_shadow);
        View view2 = new View(context);
        this.playerShadow = view2;
        view2.setBackgroundColor(getThemedColor("dialogShadowLine"));
        this.playerLayout = new FrameLayout(context) { // from class: ir.eitaa.ui.Components.AudioPlayerAlert.6
            @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
                super.onLayout(changed, left, top, right, bottom);
                if (AudioPlayerAlert.this.playbackSpeedButton == null || AudioPlayerAlert.this.durationTextView == null) {
                    return;
                }
                int left2 = (AudioPlayerAlert.this.durationTextView.getLeft() - AndroidUtilities.dp(4.0f)) - AudioPlayerAlert.this.playbackSpeedButton.getMeasuredWidth();
                AudioPlayerAlert.this.playbackSpeedButton.layout(left2, AudioPlayerAlert.this.playbackSpeedButton.getTop(), AudioPlayerAlert.this.playbackSpeedButton.getMeasuredWidth() + left2, AudioPlayerAlert.this.playbackSpeedButton.getBottom());
            }
        };
        CoverContainer coverContainer = new CoverContainer(context) { // from class: ir.eitaa.ui.Components.AudioPlayerAlert.7
            private long pressTime;

            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent event) {
                int action = event.getAction();
                if (action == 0) {
                    if (getImageReceiver().hasBitmapImage()) {
                        AudioPlayerAlert.this.showAlbumCover(true, true);
                        this.pressTime = SystemClock.elapsedRealtime();
                    }
                } else if (action != 2 && SystemClock.elapsedRealtime() - this.pressTime >= 400) {
                    AudioPlayerAlert.this.showAlbumCover(false, true);
                }
                return true;
            }

            @Override // ir.eitaa.ui.Components.AudioPlayerAlert.CoverContainer
            protected void onImageUpdated(ImageReceiver imageReceiver) {
                if (AudioPlayerAlert.this.blurredView.getTag() != null) {
                    AudioPlayerAlert.this.bigAlbumConver.setImageBitmap(imageReceiver.getBitmap());
                }
            }
        };
        this.coverContainer = coverContainer;
        this.playerLayout.addView(coverContainer, LayoutHelper.createFrame(44, 44.0f, 53, 0.0f, 20.0f, 20.0f, 0.0f));
        ClippingTextViewSwitcher clippingTextViewSwitcher = new ClippingTextViewSwitcher(context) { // from class: ir.eitaa.ui.Components.AudioPlayerAlert.8
            @Override // ir.eitaa.ui.Components.AudioPlayerAlert.ClippingTextViewSwitcher
            protected TextView createTextView() {
                TextView textView = new TextView(context);
                textView.setTextColor(AudioPlayerAlert.this.getThemedColor("player_actionBarTitle"));
                textView.setTextSize(1, 17.0f);
                textView.setTypeface(AndroidUtilities.getFontFamily(true));
                textView.setEllipsize(TextUtils.TruncateAt.END);
                textView.setSingleLine(true);
                return textView;
            }
        };
        this.titleTextView = clippingTextViewSwitcher;
        this.playerLayout.addView(clippingTextViewSwitcher, LayoutHelper.createFrame(-1, -2.0f, 51, 20.0f, 20.0f, 72.0f, 0.0f));
        AnonymousClass9 anonymousClass9 = new AnonymousClass9(context, context);
        this.authorTextView = anonymousClass9;
        this.playerLayout.addView(anonymousClass9, LayoutHelper.createFrame(-1, -2.0f, 51, 14.0f, 47.0f, 72.0f, 0.0f));
        SeekBarView seekBarView = new SeekBarView(context, resourcesProvider) { // from class: ir.eitaa.ui.Components.AudioPlayerAlert.10
            @Override // ir.eitaa.ui.Components.SeekBarView
            boolean onTouch(MotionEvent ev) {
                if (AudioPlayerAlert.this.rewindingState != 0) {
                    return false;
                }
                return super.onTouch(ev);
            }
        };
        this.seekBarView = seekBarView;
        seekBarView.setDelegate(new SeekBarView.SeekBarViewDelegate() { // from class: ir.eitaa.ui.Components.AudioPlayerAlert.11
            @Override // ir.eitaa.ui.Components.SeekBarView.SeekBarViewDelegate
            public /* synthetic */ int getStepsCount() {
                return SeekBarView.SeekBarViewDelegate.CC.$default$getStepsCount(this);
            }

            @Override // ir.eitaa.ui.Components.SeekBarView.SeekBarViewDelegate
            public void onSeekBarDrag(boolean stop, float progress) {
                if (stop) {
                    MediaController.getInstance().seekToProgress(MediaController.getInstance().getPlayingMessageObject(), progress);
                }
                MessageObject playingMessageObject2 = MediaController.getInstance().getPlayingMessageObject();
                if (playingMessageObject2 == null || !playingMessageObject2.isMusic()) {
                    return;
                }
                AudioPlayerAlert.this.updateProgress(playingMessageObject2);
            }

            @Override // ir.eitaa.ui.Components.SeekBarView.SeekBarViewDelegate
            public void onSeekBarPressed(boolean pressed) {
                AudioPlayerAlert.this.draggingSeekBar = pressed;
            }

            @Override // ir.eitaa.ui.Components.SeekBarView.SeekBarViewDelegate
            public CharSequence getContentDescription() {
                return LocaleController.formatString("AccDescrPlayerDuration", R.string.AccDescrPlayerDuration, LocaleController.formatPluralString("Minutes", AudioPlayerAlert.this.lastTime / 60) + ' ' + LocaleController.formatPluralString("Seconds", AudioPlayerAlert.this.lastTime % 60), LocaleController.formatPluralString("Minutes", AudioPlayerAlert.this.lastDuration / 60) + ' ' + LocaleController.formatPluralString("Seconds", AudioPlayerAlert.this.lastDuration % 60));
            }
        });
        this.seekBarView.setReportChanges(true);
        this.playerLayout.addView(this.seekBarView, LayoutHelper.createFrame(-1, 38.0f, 51, 5.0f, 70.0f, 5.0f, 0.0f));
        LineProgressView lineProgressView = new LineProgressView(context);
        this.progressView = lineProgressView;
        lineProgressView.setVisibility(4);
        this.progressView.setBackgroundColor(getThemedColor("player_progressBackground"));
        this.progressView.setProgressColor(getThemedColor("player_progress"));
        this.playerLayout.addView(this.progressView, LayoutHelper.createFrame(-1, 2.0f, 51, 21.0f, 90.0f, 21.0f, 0.0f));
        SimpleTextView simpleTextView = new SimpleTextView(context);
        this.timeTextView = simpleTextView;
        simpleTextView.setTextSize(12);
        this.timeTextView.setText("0:00");
        this.timeTextView.setTextColor(getThemedColor("player_time"));
        this.timeTextView.setImportantForAccessibility(2);
        this.playerLayout.addView(this.timeTextView, LayoutHelper.createFrame(100, -2.0f, 51, 20.0f, 98.0f, 0.0f, 0.0f));
        TextView textView = new TextView(context);
        this.durationTextView = textView;
        textView.setTextSize(1, 12.0f);
        this.durationTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.durationTextView.setTextColor(getThemedColor("player_time"));
        this.durationTextView.setGravity(17);
        this.durationTextView.setImportantForAccessibility(2);
        this.playerLayout.addView(this.durationTextView, LayoutHelper.createFrame(-2, -2.0f, 53, 0.0f, 96.0f, 20.0f, 0.0f));
        ActionBarMenuItem actionBarMenuItem = new ActionBarMenuItem(context, null, 0, getThemedColor("dialogTextBlack"), false, resourcesProvider);
        this.playbackSpeedButton = actionBarMenuItem;
        actionBarMenuItem.setLongClickEnabled(false);
        this.playbackSpeedButton.setShowSubmenuByMove(false);
        this.playbackSpeedButton.setAdditionalYOffset(-AndroidUtilities.dp(224.0f));
        this.playbackSpeedButton.setContentDescription(LocaleController.getString("AccDescrPlayerSpeed", R.string.AccDescrPlayerSpeed));
        this.playbackSpeedButton.setDelegate(new ActionBarMenuItem.ActionBarMenuItemDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$AudioPlayerAlert$ABmREfs4Us3TkrW0E4lvAKLbt0s
            @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemDelegate
            public final void onItemClick(int i2) {
                this.f$0.lambda$new$0$AudioPlayerAlert(i2);
            }
        });
        this.speedItems[0] = this.playbackSpeedButton.addSubItem(1, R.drawable.msg_speed_0_5, LocaleController.getString("SpeedSlow", R.string.SpeedSlow));
        this.speedItems[1] = this.playbackSpeedButton.addSubItem(2, R.drawable.msg_speed_1, LocaleController.getString("SpeedNormal", R.string.SpeedNormal));
        this.speedItems[2] = this.playbackSpeedButton.addSubItem(3, R.drawable.msg_speed_1_5, LocaleController.getString("SpeedFast", R.string.SpeedFast));
        this.speedItems[3] = this.playbackSpeedButton.addSubItem(4, R.drawable.msg_speed_2, LocaleController.getString("SpeedVeryFast", R.string.SpeedVeryFast));
        if (AndroidUtilities.density >= 3.0f) {
            this.playbackSpeedButton.setPadding(0, 1, 0, 0);
        }
        this.playbackSpeedButton.setAdditionalXOffset(AndroidUtilities.dp(8.0f));
        this.playbackSpeedButton.setShowedFromBottom(true);
        this.playerLayout.addView(this.playbackSpeedButton, LayoutHelper.createFrame(36, 36.0f, 53, 0.0f, 86.0f, 20.0f, 0.0f));
        this.playbackSpeedButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AudioPlayerAlert$jtIdakciiML0MuroBFL3fU2kVSM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                this.f$0.lambda$new$1$AudioPlayerAlert(view3);
            }
        });
        this.playbackSpeedButton.setOnLongClickListener(new View.OnLongClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AudioPlayerAlert$7xG5gvp7m6QIj6Ogfezr5a7U6fA
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view3) {
                return this.f$0.lambda$new$2$AudioPlayerAlert(view3);
            }
        });
        updatePlaybackButton();
        FrameLayout frameLayout2 = new FrameLayout(context) { // from class: ir.eitaa.ui.Components.AudioPlayerAlert.12
            @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
                int iDp = ((right - left) - AndroidUtilities.dp(248.0f)) / 4;
                for (int i2 = 0; i2 < 5; i2++) {
                    int iDp2 = AndroidUtilities.dp((i2 * 48) + 4) + (iDp * i2);
                    int iDp3 = AndroidUtilities.dp(9.0f);
                    AudioPlayerAlert.this.buttons[i2].layout(iDp2, iDp3, AudioPlayerAlert.this.buttons[i2].getMeasuredWidth() + iDp2, AudioPlayerAlert.this.buttons[i2].getMeasuredHeight() + iDp3);
                }
            }
        };
        this.playerLayout.addView(frameLayout2, LayoutHelper.createFrame(-1, 66.0f, 51, 0.0f, 111.0f, 0.0f, 0.0f));
        View[] viewArr = this.buttons;
        ActionBarMenuItem actionBarMenuItem2 = new ActionBarMenuItem(context, null, 0, 0, false, resourcesProvider);
        this.repeatButton = actionBarMenuItem2;
        viewArr[0] = actionBarMenuItem2;
        actionBarMenuItem2.setLongClickEnabled(false);
        this.repeatButton.setShowSubmenuByMove(false);
        this.repeatButton.setAdditionalYOffset(-AndroidUtilities.dp(166.0f));
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            this.repeatButton.setBackgroundDrawable(Theme.createSelectorDrawable(getThemedColor("listSelectorSDK21"), 1, AndroidUtilities.dp(18.0f)));
        }
        frameLayout2.addView(this.repeatButton, LayoutHelper.createFrame(48, 48, 51));
        this.repeatButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AudioPlayerAlert$sMJWYOet4f_3muB-Y41UdvRs0nE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                this.f$0.lambda$new$3$AudioPlayerAlert(view3);
            }
        });
        this.repeatSongItem = this.repeatButton.addSubItem(3, R.drawable.player_new_repeatone, LocaleController.getString("RepeatSong", R.string.RepeatSong));
        this.repeatListItem = this.repeatButton.addSubItem(4, R.drawable.player_new_repeatall, LocaleController.getString("RepeatList", R.string.RepeatList));
        this.shuffleListItem = this.repeatButton.addSubItem(2, R.drawable.player_new_shuffle, LocaleController.getString("ShuffleList", R.string.ShuffleList));
        this.reverseOrderItem = this.repeatButton.addSubItem(1, R.drawable.player_new_order, LocaleController.getString("ReverseOrder", R.string.ReverseOrder));
        this.repeatButton.setShowedFromBottom(true);
        this.repeatButton.setDelegate(new ActionBarMenuItem.ActionBarMenuItemDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$AudioPlayerAlert$ccTCYeHCb7PKsVhu7w-CS__19Lo
            @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemDelegate
            public final void onItemClick(int i3) throws InterruptedException, IOException {
                this.f$0.lambda$new$4$AudioPlayerAlert(i3);
            }
        });
        int themedColor = getThemedColor("player_button");
        float scaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        View[] viewArr2 = this.buttons;
        AnonymousClass13 anonymousClass13 = new AnonymousClass13(context, scaledTouchSlop);
        this.prevButton = anonymousClass13;
        viewArr2[1] = anonymousClass13;
        anonymousClass13.setScaleType(ImageView.ScaleType.CENTER);
        this.prevButton.setAnimation(R.raw.player_prev, 20, 20);
        this.prevButton.setLayerColor("Triangle 3.**", themedColor);
        this.prevButton.setLayerColor("Triangle 4.**", themedColor);
        this.prevButton.setLayerColor("Rectangle 4.**", themedColor);
        if (i2 >= 21) {
            this.prevButton.setBackgroundDrawable(Theme.createSelectorDrawable(getThemedColor("listSelectorSDK21"), 1, AndroidUtilities.dp(22.0f)));
        }
        frameLayout2.addView(this.prevButton, LayoutHelper.createFrame(48, 48, 51));
        this.prevButton.setContentDescription(LocaleController.getString("AccDescrPrevious", R.string.AccDescrPrevious));
        View[] viewArr3 = this.buttons;
        ImageView imageView = new ImageView(context);
        this.playButton = imageView;
        viewArr3[2] = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        ImageView imageView2 = this.playButton;
        PlayPauseDrawable playPauseDrawable = new PlayPauseDrawable(28);
        this.playPauseDrawable = playPauseDrawable;
        imageView2.setImageDrawable(playPauseDrawable);
        this.playPauseDrawable.setPause(!MediaController.getInstance().isMessagePaused(), false);
        this.playButton.setColorFilter(new PorterDuffColorFilter(getThemedColor("player_button"), PorterDuff.Mode.MULTIPLY));
        if (i2 >= 21) {
            this.playButton.setBackgroundDrawable(Theme.createSelectorDrawable(getThemedColor("listSelectorSDK21"), 1, AndroidUtilities.dp(24.0f)));
        }
        frameLayout2.addView(this.playButton, LayoutHelper.createFrame(48, 48, 51));
        this.playButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AudioPlayerAlert$fwaMOom4pI6tmukYSTZeK_j6B7Q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) throws IOException {
                AudioPlayerAlert.lambda$new$5(view3);
            }
        });
        View[] viewArr4 = this.buttons;
        AnonymousClass14 anonymousClass14 = new AnonymousClass14(context, scaledTouchSlop);
        this.nextButton = anonymousClass14;
        viewArr4[3] = anonymousClass14;
        anonymousClass14.setScaleType(ImageView.ScaleType.CENTER);
        this.nextButton.setAnimation(R.raw.player_prev, 20, 20);
        this.nextButton.setLayerColor("Triangle 3.**", themedColor);
        this.nextButton.setLayerColor("Triangle 4.**", themedColor);
        this.nextButton.setLayerColor("Rectangle 4.**", themedColor);
        this.nextButton.setRotation(180.0f);
        if (i2 >= 21) {
            this.nextButton.setBackgroundDrawable(Theme.createSelectorDrawable(getThemedColor("listSelectorSDK21"), 1, AndroidUtilities.dp(22.0f)));
        }
        frameLayout2.addView(this.nextButton, LayoutHelper.createFrame(48, 48, 51));
        this.nextButton.setContentDescription(LocaleController.getString("Next", R.string.Next));
        View[] viewArr5 = this.buttons;
        ActionBarMenuItem actionBarMenuItem3 = new ActionBarMenuItem(context, null, 0, themedColor, false, resourcesProvider);
        this.optionsButton = actionBarMenuItem3;
        viewArr5[4] = actionBarMenuItem3;
        actionBarMenuItem3.setLongClickEnabled(false);
        this.optionsButton.setShowSubmenuByMove(false);
        this.optionsButton.setIcon(R.drawable.ic_ab_other);
        this.optionsButton.setSubMenuOpenSide(2);
        this.optionsButton.setAdditionalYOffset(-AndroidUtilities.dp(157.0f));
        if (i2 >= 21) {
            this.optionsButton.setBackgroundDrawable(Theme.createSelectorDrawable(getThemedColor("listSelectorSDK21"), 1, AndroidUtilities.dp(18.0f)));
        }
        frameLayout2.addView(this.optionsButton, LayoutHelper.createFrame(48, 48, 51));
        this.optionsButton.addSubItem(1, R.drawable.msg_forward, LocaleController.getString("Forward", R.string.Forward));
        this.optionsButton.addSubItem(2, R.drawable.msg_shareout, LocaleController.getString("ShareFile", R.string.ShareFile));
        this.optionsButton.addSubItem(5, R.drawable.msg_download, LocaleController.getString("SaveToMusic", R.string.SaveToMusic));
        this.optionsButton.addSubItem(4, R.drawable.msg_message, LocaleController.getString("ShowInChat", R.string.ShowInChat));
        this.optionsButton.setShowedFromBottom(true);
        this.optionsButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AudioPlayerAlert$mL6x6k1GRbPuNxyM7G6AO4DlBxg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                this.f$0.lambda$new$6$AudioPlayerAlert(view3);
            }
        });
        this.optionsButton.setDelegate(new ActionBarMenuItem.ActionBarMenuItemDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$AudioPlayerAlert$h9npNooHIMr56dxJ5aHKFsfYaOA
            @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemDelegate
            public final void onItemClick(int i3) {
                this.f$0.onSubItemClick(i3);
            }
        });
        this.optionsButton.setContentDescription(LocaleController.getString("AccDescrMoreOptions", R.string.AccDescrMoreOptions));
        LinearLayout linearLayout = new LinearLayout(context);
        this.emptyView = linearLayout;
        linearLayout.setOrientation(1);
        this.emptyView.setGravity(17);
        this.emptyView.setVisibility(8);
        this.containerView.addView(this.emptyView, LayoutHelper.createFrame(-1, -1.0f));
        this.emptyView.setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AudioPlayerAlert$dK4BicxkaEMFs_PiNVRPOBfRoik
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view3, MotionEvent motionEvent) {
                return AudioPlayerAlert.lambda$new$7(view3, motionEvent);
            }
        });
        ImageView imageView3 = new ImageView(context);
        this.emptyImageView = imageView3;
        imageView3.setImageResource(R.drawable.music_empty);
        this.emptyImageView.setColorFilter(new PorterDuffColorFilter(getThemedColor("dialogEmptyImage"), PorterDuff.Mode.MULTIPLY));
        this.emptyView.addView(this.emptyImageView, LayoutHelper.createLinear(-2, -2));
        TextView textView2 = new TextView(context);
        this.emptyTitleTextView = textView2;
        textView2.setTextColor(getThemedColor("dialogEmptyText"));
        this.emptyTitleTextView.setGravity(17);
        this.emptyTitleTextView.setText(LocaleController.getString("NoAudioFound", R.string.NoAudioFound));
        this.emptyTitleTextView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.emptyTitleTextView.setTextSize(1, 17.0f);
        this.emptyTitleTextView.setPadding(AndroidUtilities.dp(40.0f), 0, AndroidUtilities.dp(40.0f), 0);
        this.emptyView.addView(this.emptyTitleTextView, LayoutHelper.createLinear(-2, -2, 17, 0, 11, 0, 0));
        TextView textView3 = new TextView(context);
        this.emptySubtitleTextView = textView3;
        textView3.setTextColor(getThemedColor("dialogEmptyText"));
        this.emptySubtitleTextView.setGravity(17);
        this.emptySubtitleTextView.setTextSize(1, 15.0f);
        this.emptySubtitleTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.emptySubtitleTextView.setPadding(AndroidUtilities.dp(40.0f), 0, AndroidUtilities.dp(40.0f), 0);
        this.emptyView.addView(this.emptySubtitleTextView, LayoutHelper.createLinear(-2, -2, 17, 0, 6, 0, 0));
        RecyclerListView recyclerListView = new RecyclerListView(context) { // from class: ir.eitaa.ui.Components.AudioPlayerAlert.15
            boolean ignoreLayout;

            @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean changed, int l, int t, int r, int b) {
                super.onLayout(changed, l, t, r, b);
                if (AudioPlayerAlert.this.searchOpenPosition == -1 || AudioPlayerAlert.this.actionBar.isSearchFieldVisible()) {
                    if (AudioPlayerAlert.this.scrollToSong) {
                        AudioPlayerAlert.this.scrollToSong = false;
                        this.ignoreLayout = true;
                        if (AudioPlayerAlert.this.scrollToCurrentSong(true)) {
                            super.onLayout(false, l, t, r, b);
                        }
                        this.ignoreLayout = false;
                        return;
                    }
                    return;
                }
                this.ignoreLayout = true;
                AudioPlayerAlert.this.layoutManager.scrollToPositionWithOffset(AudioPlayerAlert.this.searchOpenPosition, AudioPlayerAlert.this.searchOpenOffset - AudioPlayerAlert.this.listView.getPaddingTop());
                super.onLayout(false, l, t, r, b);
                this.ignoreLayout = false;
                AudioPlayerAlert.this.searchOpenPosition = -1;
            }

            @Override // ir.eitaa.ui.Components.RecyclerListView
            protected boolean allowSelectChildAtPosition(float x, float y) {
                return y < AudioPlayerAlert.this.playerLayout.getY() - ((float) AudioPlayerAlert.this.listView.getTop());
            }

            @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.View, android.view.ViewParent
            public void requestLayout() {
                if (this.ignoreLayout) {
                    return;
                }
                super.requestLayout();
            }
        };
        this.listView = recyclerListView;
        recyclerListView.setClipToPadding(false);
        RecyclerListView recyclerListView2 = this.listView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 1, false);
        this.layoutManager = linearLayoutManager;
        recyclerListView2.setLayoutManager(linearLayoutManager);
        this.listView.setHorizontalScrollBarEnabled(false);
        this.listView.setVerticalScrollBarEnabled(false);
        this.containerView.addView(this.listView, LayoutHelper.createFrame(-1, -1, 51));
        RecyclerListView recyclerListView3 = this.listView;
        ListAdapter listAdapter = new ListAdapter(context);
        this.listAdapter = listAdapter;
        recyclerListView3.setAdapter(listAdapter);
        this.listView.setGlowColor(getThemedColor("dialogScrollGlow"));
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AudioPlayerAlert$-C-CVeHny_N-RWOmN8CjmUzzATQ
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view3, int i3) {
                AudioPlayerAlert.lambda$new$8(view3, i3);
            }
        });
        this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.eitaa.ui.Components.AudioPlayerAlert.16
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState != 0) {
                    if (newState == 1) {
                        AndroidUtilities.hideKeyboard(AudioPlayerAlert.this.getCurrentFocus());
                        return;
                    }
                    return;
                }
                if (((AudioPlayerAlert.this.scrollOffsetY - ((BottomSheet) AudioPlayerAlert.this).backgroundPaddingTop) - AndroidUtilities.dp(13.0f)) + ((BottomSheet) AudioPlayerAlert.this).backgroundPaddingTop >= ActionBar.getCurrentActionBarHeight() || !AudioPlayerAlert.this.listView.canScrollVertically(1)) {
                    return;
                }
                AudioPlayerAlert.this.listView.getChildAt(0);
                RecyclerListView.Holder holder = (RecyclerListView.Holder) AudioPlayerAlert.this.listView.findViewHolderForAdapterPosition(0);
                if (holder == null || holder.itemView.getTop() <= AndroidUtilities.dp(7.0f)) {
                    return;
                }
                AudioPlayerAlert.this.listView.smoothScrollBy(0, holder.itemView.getTop() - AndroidUtilities.dp(7.0f));
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                AudioPlayerAlert.this.updateLayout();
                AudioPlayerAlert.this.updateEmptyViewPosition();
                if (AudioPlayerAlert.this.searchWas) {
                    return;
                }
                int iFindFirstVisibleItemPosition = AudioPlayerAlert.this.layoutManager.findFirstVisibleItemPosition();
                int iAbs = iFindFirstVisibleItemPosition == -1 ? 0 : Math.abs(AudioPlayerAlert.this.layoutManager.findLastVisibleItemPosition() - iFindFirstVisibleItemPosition) + 1;
                int itemCount = recyclerView.getAdapter().getItemCount();
                MediaController.getInstance().getPlayingMessageObject();
                if (SharedConfig.playOrderReversed) {
                    if (iFindFirstVisibleItemPosition < 10) {
                        MediaController.getInstance().loadMoreMusic();
                    }
                } else if (iFindFirstVisibleItemPosition + iAbs > itemCount - 10) {
                    MediaController.getInstance().loadMoreMusic();
                }
            }
        });
        this.playlist = MediaController.getInstance().getPlaylist();
        this.listAdapter.notifyDataSetChanged();
        this.containerView.addView(this.playerLayout, LayoutHelper.createFrame(-1, 179, 83));
        this.containerView.addView(this.playerShadow, new FrameLayout.LayoutParams(-1, AndroidUtilities.getShadowHeight(), 83));
        ((FrameLayout.LayoutParams) this.playerShadow.getLayoutParams()).bottomMargin = AndroidUtilities.dp(179.0f);
        this.containerView.addView(this.actionBarShadow, LayoutHelper.createFrame(-1, 3.0f));
        this.containerView.addView(this.actionBar);
        FrameLayout frameLayout3 = new FrameLayout(context) { // from class: ir.eitaa.ui.Components.AudioPlayerAlert.17
            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent event) {
                if (AudioPlayerAlert.this.blurredView.getTag() != null) {
                    AudioPlayerAlert.this.showAlbumCover(false, true);
                }
                return true;
            }
        };
        this.blurredView = frameLayout3;
        frameLayout3.setAlpha(0.0f);
        this.blurredView.setVisibility(4);
        getContainer().addView(this.blurredView);
        BackupImageView backupImageView = new BackupImageView(context);
        this.bigAlbumConver = backupImageView;
        backupImageView.setAspectFit(true);
        this.bigAlbumConver.setRoundRadius(AndroidUtilities.dp(8.0f));
        this.bigAlbumConver.setScaleX(0.9f);
        this.bigAlbumConver.setScaleY(0.9f);
        this.blurredView.addView(this.bigAlbumConver, LayoutHelper.createFrame(-1, -1.0f, 51, 30.0f, 30.0f, 30.0f, 30.0f));
        updateTitle(false);
        updateRepeatButton();
        updateEmptyView();
    }

    /* renamed from: ir.eitaa.ui.Components.AudioPlayerAlert$9, reason: invalid class name */
    class AnonymousClass9 extends ClippingTextViewSwitcher {
        final /* synthetic */ Context val$context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass9(Context context, final Context val$context) {
            super(context);
            this.val$context = val$context;
        }

        @Override // ir.eitaa.ui.Components.AudioPlayerAlert.ClippingTextViewSwitcher
        protected TextView createTextView() {
            final TextView textView = new TextView(this.val$context);
            textView.setTextColor(AudioPlayerAlert.this.getThemedColor("player_time"));
            textView.setTextSize(1, 13.0f);
            textView.setTypeface(AndroidUtilities.getFontFamily(false));
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setSingleLine(true);
            textView.setPadding(AndroidUtilities.dp(6.0f), 0, AndroidUtilities.dp(6.0f), AndroidUtilities.dp(1.0f));
            textView.setBackground(Theme.createRadSelectorDrawable(AudioPlayerAlert.this.getThemedColor("listSelectorSDK21"), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f)));
            textView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AudioPlayerAlert$9$VfVIaAXiH8tLMkGSiqin-Svo_bM
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$createTextView$0$AudioPlayerAlert$9(textView, view);
                }
            });
            return textView;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$createTextView$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$createTextView$0$AudioPlayerAlert$9(TextView textView, View view) {
            if (MessagesController.getInstance(((BottomSheet) AudioPlayerAlert.this).currentAccount).getTotalDialogsCount() <= 10 || TextUtils.isEmpty(textView.getText().toString())) {
                return;
            }
            String string = textView.getText().toString();
            if (AudioPlayerAlert.this.parentActivity.getActionBarLayout().getLastFragment() instanceof DialogsActivity) {
                DialogsActivity dialogsActivity = (DialogsActivity) AudioPlayerAlert.this.parentActivity.getActionBarLayout().getLastFragment();
                if (!dialogsActivity.onlyDialogsAdapter()) {
                    dialogsActivity.setShowSearch(string, 4);
                    AudioPlayerAlert.this.dismiss();
                    return;
                }
            }
            DialogsActivity dialogsActivity2 = new DialogsActivity(null);
            dialogsActivity2.setSearchString(string);
            dialogsActivity2.setInitialSearchType(4);
            AudioPlayerAlert.this.parentActivity.presentFragment(dialogsActivity2, false, false);
            AudioPlayerAlert.this.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$AudioPlayerAlert(int i) {
        MediaController.getInstance().getPlaybackSpeed(true);
        if (i == 1) {
            MediaController.getInstance().setPlaybackSpeed(true, 0.5f);
        } else if (i == 2) {
            MediaController.getInstance().setPlaybackSpeed(true, 1.0f);
        } else if (i == 3) {
            MediaController.getInstance().setPlaybackSpeed(true, 1.5f);
        } else {
            MediaController.getInstance().setPlaybackSpeed(true, 1.8f);
        }
        updatePlaybackButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$1$AudioPlayerAlert(View view) {
        if (Math.abs(MediaController.getInstance().getPlaybackSpeed(true) - 1.0f) > 0.001f) {
            MediaController.getInstance().setPlaybackSpeed(true, 1.0f);
        } else {
            MediaController.getInstance().setPlaybackSpeed(true, MediaController.getInstance().getFastPlaybackSpeed(true));
        }
        updatePlaybackButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$new$2$AudioPlayerAlert(View view) {
        this.playbackSpeedButton.toggleSubMenu();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$3$AudioPlayerAlert(View view) {
        updateSubMenu();
        this.repeatButton.toggleSubMenu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$4$AudioPlayerAlert(int i) throws InterruptedException, IOException {
        if (i == 1 || i == 2) {
            boolean z = SharedConfig.playOrderReversed;
            if ((z && i == 1) || (SharedConfig.shuffleMusic && i == 2)) {
                MediaController.getInstance().setPlaybackOrderType(0);
            } else {
                MediaController.getInstance().setPlaybackOrderType(i);
            }
            this.listAdapter.notifyDataSetChanged();
            if (z != SharedConfig.playOrderReversed) {
                this.listView.stopScroll();
                scrollToCurrentSong(false);
            }
        } else if (i == 4) {
            if (SharedConfig.repeatMode == 1) {
                SharedConfig.setRepeatMode(0);
            } else {
                SharedConfig.setRepeatMode(1);
            }
        } else if (SharedConfig.repeatMode == 2) {
            SharedConfig.setRepeatMode(0);
        } else {
            SharedConfig.setRepeatMode(2);
        }
        updateRepeatButton();
    }

    /* renamed from: ir.eitaa.ui.Components.AudioPlayerAlert$13, reason: invalid class name */
    class AnonymousClass13 extends RLottieImageView {
        private final Runnable backSeek;
        long lastTime;
        long lastUpdateTime;
        int pressedCount;
        private final Runnable pressedRunnable;
        long startTime;
        float startX;
        float startY;
        final /* synthetic */ float val$touchSlop;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass13(Context context, final float val$touchSlop) {
            super(context);
            this.val$touchSlop = val$touchSlop;
            this.pressedCount = 0;
            this.pressedRunnable = new Runnable() { // from class: ir.eitaa.ui.Components.AudioPlayerAlert.13.1
                @Override // java.lang.Runnable
                public void run() {
                    AnonymousClass13 anonymousClass13 = AnonymousClass13.this;
                    int i = anonymousClass13.pressedCount + 1;
                    anonymousClass13.pressedCount = i;
                    if (i != 1) {
                        if (i == 2) {
                            AndroidUtilities.runOnUIThread(this, 2000L);
                            return;
                        }
                        return;
                    }
                    AudioPlayerAlert audioPlayerAlert = AudioPlayerAlert.this;
                    audioPlayerAlert.rewindingState = -1;
                    audioPlayerAlert.rewindingProgress = MediaController.getInstance().getPlayingMessageObject().audioProgress;
                    AnonymousClass13.this.lastTime = System.currentTimeMillis();
                    AndroidUtilities.runOnUIThread(this, 2000L);
                    AndroidUtilities.runOnUIThread(AnonymousClass13.this.backSeek);
                }
            };
            this.backSeek = new Runnable() { // from class: ir.eitaa.ui.Components.AudioPlayerAlert.13.2
                @Override // java.lang.Runnable
                public void run() {
                    long duration = MediaController.getInstance().getDuration();
                    if (duration == 0 || duration == -9223372036854775807L) {
                        AnonymousClass13.this.lastTime = System.currentTimeMillis();
                        return;
                    }
                    float f = AudioPlayerAlert.this.rewindingProgress;
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    AnonymousClass13 anonymousClass13 = AnonymousClass13.this;
                    long j = jCurrentTimeMillis - anonymousClass13.lastTime;
                    anonymousClass13.lastTime = jCurrentTimeMillis;
                    long j2 = jCurrentTimeMillis - anonymousClass13.lastUpdateTime;
                    int i = anonymousClass13.pressedCount;
                    float f2 = ((long) ((f * r0) - (j * (i == 1 ? 3L : i == 2 ? 6L : 12L)))) / duration;
                    if (f2 < 0.0f) {
                        f2 = 0.0f;
                    }
                    AudioPlayerAlert.this.rewindingProgress = f2;
                    MessageObject playingMessageObject = MediaController.getInstance().getPlayingMessageObject();
                    if (playingMessageObject != null && playingMessageObject.isMusic()) {
                        AudioPlayerAlert.this.updateProgress(playingMessageObject);
                    }
                    AnonymousClass13 anonymousClass132 = AnonymousClass13.this;
                    AudioPlayerAlert audioPlayerAlert = AudioPlayerAlert.this;
                    if (audioPlayerAlert.rewindingState != -1 || anonymousClass132.pressedCount <= 0) {
                        return;
                    }
                    if (j2 > 200 || audioPlayerAlert.rewindingProgress == 0.0f) {
                        anonymousClass132.lastUpdateTime = jCurrentTimeMillis;
                        if (audioPlayerAlert.rewindingProgress == 0.0f) {
                            MediaController.getInstance().seekToProgress(MediaController.getInstance().getPlayingMessageObject(), 0.0f);
                            MediaController.getInstance().pauseByRewind();
                        } else {
                            MediaController.getInstance().seekToProgress(MediaController.getInstance().getPlayingMessageObject(), f2);
                        }
                    }
                    AnonymousClass13 anonymousClass133 = AnonymousClass13.this;
                    if (anonymousClass133.pressedCount <= 0 || AudioPlayerAlert.this.rewindingProgress <= 0.0f) {
                        return;
                    }
                    AndroidUtilities.runOnUIThread(anonymousClass133.backSeek, 16L);
                }
            };
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0053  */
        @Override // android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onTouchEvent(android.view.MotionEvent r10) throws java.lang.InterruptedException, java.io.IOException {
            /*
                r9 = this;
                ir.eitaa.ui.Components.AudioPlayerAlert r0 = ir.eitaa.ui.Components.AudioPlayerAlert.this
                ir.eitaa.ui.Components.SeekBarView r0 = ir.eitaa.ui.Components.AudioPlayerAlert.access$6100(r0)
                boolean r0 = r0.isDragging()
                r1 = 0
                if (r0 != 0) goto Le0
                ir.eitaa.ui.Components.AudioPlayerAlert r0 = ir.eitaa.ui.Components.AudioPlayerAlert.this
                int r0 = r0.rewindingState
                r2 = 1
                if (r0 != r2) goto L16
                goto Le0
            L16:
                float r0 = r10.getRawX()
                float r3 = r10.getRawY()
                int r4 = r10.getAction()
                r5 = 300(0x12c, double:1.48E-321)
                if (r4 == 0) goto Lb2
                if (r4 == r2) goto L53
                r7 = 2
                if (r4 == r7) goto L30
                r0 = 3
                if (r4 == r0) goto L53
                goto Ldf
            L30:
                float r10 = r9.startX
                float r0 = r0 - r10
                float r10 = r9.startY
                float r3 = r3 - r10
                float r0 = r0 * r0
                float r3 = r3 * r3
                float r0 = r0 + r3
                float r10 = r9.val$touchSlop
                float r10 = r10 * r10
                int r10 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
                if (r10 <= 0) goto Ldf
                ir.eitaa.ui.Components.AudioPlayerAlert r10 = ir.eitaa.ui.Components.AudioPlayerAlert.this
                int r10 = r10.rewindingState
                if (r10 != 0) goto Ldf
                java.lang.Runnable r10 = r9.pressedRunnable
                ir.eitaa.messenger.AndroidUtilities.cancelRunOnUIThread(r10)
                r9.setPressed(r1)
                goto Ldf
            L53:
                java.lang.Runnable r0 = r9.pressedRunnable
                ir.eitaa.messenger.AndroidUtilities.cancelRunOnUIThread(r0)
                java.lang.Runnable r0 = r9.backSeek
                ir.eitaa.messenger.AndroidUtilities.cancelRunOnUIThread(r0)
                ir.eitaa.ui.Components.AudioPlayerAlert r0 = ir.eitaa.ui.Components.AudioPlayerAlert.this
                int r0 = r0.rewindingState
                if (r0 != 0) goto L8e
                int r10 = r10.getAction()
                if (r10 != r2) goto L8e
                long r3 = java.lang.System.currentTimeMillis()
                long r7 = r9.startTime
                long r3 = r3 - r7
                int r10 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r10 >= 0) goto L8e
                ir.eitaa.messenger.MediaController r10 = ir.eitaa.messenger.MediaController.getInstance()
                r10.playPreviousMessage()
                ir.eitaa.ui.Components.AudioPlayerAlert r10 = ir.eitaa.ui.Components.AudioPlayerAlert.this
                ir.eitaa.ui.Components.RLottieImageView r10 = ir.eitaa.ui.Components.AudioPlayerAlert.access$6200(r10)
                r0 = 0
                r10.setProgress(r0)
                ir.eitaa.ui.Components.AudioPlayerAlert r10 = ir.eitaa.ui.Components.AudioPlayerAlert.this
                ir.eitaa.ui.Components.RLottieImageView r10 = ir.eitaa.ui.Components.AudioPlayerAlert.access$6200(r10)
                r10.playAnimation()
            L8e:
                int r10 = r9.pressedCount
                if (r10 <= 0) goto La2
                r3 = 0
                r9.lastUpdateTime = r3
                java.lang.Runnable r10 = r9.backSeek
                r10.run()
                ir.eitaa.messenger.MediaController r10 = ir.eitaa.messenger.MediaController.getInstance()
                r10.resumeByRewind()
            La2:
                ir.eitaa.ui.Components.AudioPlayerAlert r10 = ir.eitaa.ui.Components.AudioPlayerAlert.this
                r0 = -1082130432(0xffffffffbf800000, float:-1.0)
                r10.rewindingProgress = r0
                r9.setPressed(r1)
                ir.eitaa.ui.Components.AudioPlayerAlert r10 = ir.eitaa.ui.Components.AudioPlayerAlert.this
                r10.rewindingState = r1
                r9.pressedCount = r1
                goto Ldf
            Lb2:
                r9.startX = r0
                r9.startY = r3
                long r3 = java.lang.System.currentTimeMillis()
                r9.startTime = r3
                ir.eitaa.ui.Components.AudioPlayerAlert r10 = ir.eitaa.ui.Components.AudioPlayerAlert.this
                r10.rewindingState = r1
                java.lang.Runnable r10 = r9.pressedRunnable
                ir.eitaa.messenger.AndroidUtilities.runOnUIThread(r10, r5)
                int r10 = android.os.Build.VERSION.SDK_INT
                r0 = 21
                if (r10 < r0) goto Ldc
                android.graphics.drawable.Drawable r10 = r9.getBackground()
                if (r10 == 0) goto Ldc
                android.graphics.drawable.Drawable r10 = r9.getBackground()
                float r0 = r9.startX
                float r1 = r9.startY
                r10.setHotspot(r0, r1)
            Ldc:
                r9.setPressed(r2)
            Ldf:
                return r2
            Le0:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.AudioPlayerAlert.AnonymousClass13.onTouchEvent(android.view.MotionEvent):boolean");
        }
    }

    static /* synthetic */ void lambda$new$5(View view) throws IOException {
        if (MediaController.getInstance().isDownloadingCurrentMessage()) {
            return;
        }
        if (MediaController.getInstance().isMessagePaused()) {
            MediaController.getInstance().playMessage(MediaController.getInstance().getPlayingMessageObject());
        } else {
            MediaController.getInstance().lambda$startAudioAgain$7$MediaController(MediaController.getInstance().getPlayingMessageObject());
        }
    }

    /* renamed from: ir.eitaa.ui.Components.AudioPlayerAlert$14, reason: invalid class name */
    class AnonymousClass14 extends RLottieImageView {
        boolean pressed;
        private final Runnable pressedRunnable;
        float startX;
        float startY;
        final /* synthetic */ float val$touchSlop;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass14(Context context, final float val$touchSlop) {
            super(context);
            this.val$touchSlop = val$touchSlop;
            this.pressedRunnable = new Runnable() { // from class: ir.eitaa.ui.Components.AudioPlayerAlert.14.1
                @Override // java.lang.Runnable
                public void run() {
                    if (MediaController.getInstance().getPlayingMessageObject() == null) {
                        return;
                    }
                    AnonymousClass14 anonymousClass14 = AnonymousClass14.this;
                    AudioPlayerAlert audioPlayerAlert = AudioPlayerAlert.this;
                    int i = audioPlayerAlert.rewindingForwardPressedCount + 1;
                    audioPlayerAlert.rewindingForwardPressedCount = i;
                    if (i != 1) {
                        if (i == 2) {
                            MediaController.getInstance().setPlaybackSpeed(true, 7.0f);
                            AndroidUtilities.runOnUIThread(this, 2000L);
                            return;
                        } else {
                            MediaController.getInstance().setPlaybackSpeed(true, 13.0f);
                            return;
                        }
                    }
                    anonymousClass14.pressed = true;
                    audioPlayerAlert.rewindingState = 1;
                    if (MediaController.getInstance().isMessagePaused()) {
                        AudioPlayerAlert.this.startForwardRewindingSeek();
                    } else {
                        AudioPlayerAlert audioPlayerAlert2 = AudioPlayerAlert.this;
                        if (audioPlayerAlert2.rewindingState == 1) {
                            AndroidUtilities.cancelRunOnUIThread(audioPlayerAlert2.forwardSeek);
                            AudioPlayerAlert.this.lastUpdateRewindingPlayerTime = 0L;
                        }
                    }
                    MediaController.getInstance().setPlaybackSpeed(true, 4.0f);
                    AndroidUtilities.runOnUIThread(this, 2000L);
                }
            };
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0050  */
        @Override // android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onTouchEvent(android.view.MotionEvent r7) throws java.lang.InterruptedException, java.io.IOException {
            /*
                r6 = this;
                ir.eitaa.ui.Components.AudioPlayerAlert r0 = ir.eitaa.ui.Components.AudioPlayerAlert.this
                ir.eitaa.ui.Components.SeekBarView r0 = ir.eitaa.ui.Components.AudioPlayerAlert.access$6100(r0)
                boolean r0 = r0.isDragging()
                r1 = 0
                if (r0 != 0) goto Ldd
                ir.eitaa.ui.Components.AudioPlayerAlert r0 = ir.eitaa.ui.Components.AudioPlayerAlert.this
                int r0 = r0.rewindingState
                r2 = -1
                if (r0 != r2) goto L16
                goto Ldd
            L16:
                float r0 = r7.getRawX()
                float r2 = r7.getRawY()
                int r3 = r7.getAction()
                r4 = 1
                if (r3 == 0) goto Lb5
                if (r3 == r4) goto L50
                r5 = 2
                if (r3 == r5) goto L2f
                r0 = 3
                if (r3 == r0) goto L50
                goto Ldc
            L2f:
                float r7 = r6.startX
                float r0 = r0 - r7
                float r7 = r6.startY
                float r2 = r2 - r7
                float r0 = r0 * r0
                float r2 = r2 * r2
                float r0 = r0 + r2
                float r7 = r6.val$touchSlop
                float r7 = r7 * r7
                int r7 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
                if (r7 <= 0) goto Ldc
                boolean r7 = r6.pressed
                if (r7 != 0) goto Ldc
                java.lang.Runnable r7 = r6.pressedRunnable
                ir.eitaa.messenger.AndroidUtilities.cancelRunOnUIThread(r7)
                r6.setPressed(r1)
                goto Ldc
            L50:
                boolean r0 = r6.pressed
                if (r0 != 0) goto L7a
                int r7 = r7.getAction()
                if (r7 != r4) goto L7a
                boolean r7 = r6.isPressed()
                if (r7 == 0) goto L7a
                ir.eitaa.messenger.MediaController r7 = ir.eitaa.messenger.MediaController.getInstance()
                r7.playNextMessage()
                ir.eitaa.ui.Components.AudioPlayerAlert r7 = ir.eitaa.ui.Components.AudioPlayerAlert.this
                ir.eitaa.ui.Components.RLottieImageView r7 = ir.eitaa.ui.Components.AudioPlayerAlert.access$6400(r7)
                r0 = 0
                r7.setProgress(r0)
                ir.eitaa.ui.Components.AudioPlayerAlert r7 = ir.eitaa.ui.Components.AudioPlayerAlert.this
                ir.eitaa.ui.Components.RLottieImageView r7 = ir.eitaa.ui.Components.AudioPlayerAlert.access$6400(r7)
                r7.playAnimation()
            L7a:
                java.lang.Runnable r7 = r6.pressedRunnable
                ir.eitaa.messenger.AndroidUtilities.cancelRunOnUIThread(r7)
                ir.eitaa.ui.Components.AudioPlayerAlert r7 = ir.eitaa.ui.Components.AudioPlayerAlert.this
                int r7 = r7.rewindingForwardPressedCount
                if (r7 <= 0) goto La5
                ir.eitaa.messenger.MediaController r7 = ir.eitaa.messenger.MediaController.getInstance()
                r0 = 1065353216(0x3f800000, float:1.0)
                r7.setPlaybackSpeed(r4, r0)
                ir.eitaa.messenger.MediaController r7 = ir.eitaa.messenger.MediaController.getInstance()
                boolean r7 = r7.isMessagePaused()
                if (r7 == 0) goto La5
                ir.eitaa.ui.Components.AudioPlayerAlert r7 = ir.eitaa.ui.Components.AudioPlayerAlert.this
                r2 = 0
                r7.lastUpdateRewindingPlayerTime = r2
                java.lang.Runnable r7 = ir.eitaa.ui.Components.AudioPlayerAlert.access$100(r7)
                r7.run()
            La5:
                ir.eitaa.ui.Components.AudioPlayerAlert r7 = ir.eitaa.ui.Components.AudioPlayerAlert.this
                r7.rewindingState = r1
                r6.setPressed(r1)
                ir.eitaa.ui.Components.AudioPlayerAlert r7 = ir.eitaa.ui.Components.AudioPlayerAlert.this
                r7.rewindingForwardPressedCount = r1
                r0 = -1082130432(0xffffffffbf800000, float:-1.0)
                r7.rewindingProgress = r0
                goto Ldc
            Lb5:
                r6.pressed = r1
                r6.startX = r0
                r6.startY = r2
                java.lang.Runnable r7 = r6.pressedRunnable
                r0 = 300(0x12c, double:1.48E-321)
                ir.eitaa.messenger.AndroidUtilities.runOnUIThread(r7, r0)
                int r7 = android.os.Build.VERSION.SDK_INT
                r0 = 21
                if (r7 < r0) goto Ld9
                android.graphics.drawable.Drawable r7 = r6.getBackground()
                if (r7 == 0) goto Ld9
                android.graphics.drawable.Drawable r7 = r6.getBackground()
                float r0 = r6.startX
                float r1 = r6.startY
                r7.setHotspot(r0, r1)
            Ld9:
                r6.setPressed(r4)
            Ldc:
                return r4
            Ldd:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.AudioPlayerAlert.AnonymousClass14.onTouchEvent(android.view.MotionEvent):boolean");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$6$AudioPlayerAlert(View view) {
        this.optionsButton.toggleSubMenu();
    }

    static /* synthetic */ void lambda$new$8(View view, int i) {
        if (view instanceof AudioPlayerCell) {
            ((AudioPlayerCell) view).didPressedButton();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startForwardRewindingSeek() {
        if (this.rewindingState == 1) {
            this.lastRewindingTime = System.currentTimeMillis();
            this.rewindingProgress = MediaController.getInstance().getPlayingMessageObject().audioProgress;
            AndroidUtilities.cancelRunOnUIThread(this.forwardSeek);
            AndroidUtilities.runOnUIThread(this.forwardSeek);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateEmptyViewPosition() {
        if (this.emptyView.getVisibility() != 0) {
            return;
        }
        int iDp = this.playerLayout.getVisibility() == 0 ? AndroidUtilities.dp(150.0f) : -AndroidUtilities.dp(30.0f);
        this.emptyView.setTranslationY(((r1.getMeasuredHeight() - this.containerView.getMeasuredHeight()) - iDp) / 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateEmptyView() {
        this.emptyView.setVisibility((this.searching && this.listAdapter.getItemCount() == 0) ? 0 : 8);
        updateEmptyViewPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean scrollToCurrentSong(boolean r7) {
        /*
            r6 = this;
            ir.eitaa.messenger.MediaController r0 = ir.eitaa.messenger.MediaController.getInstance()
            ir.eitaa.messenger.MessageObject r0 = r0.getPlayingMessageObject()
            r1 = 0
            if (r0 == 0) goto L5d
            r2 = 1
            if (r7 == 0) goto L3b
            ir.eitaa.ui.Components.RecyclerListView r7 = r6.listView
            int r7 = r7.getChildCount()
            r3 = 0
        L15:
            if (r3 >= r7) goto L3b
            ir.eitaa.ui.Components.RecyclerListView r4 = r6.listView
            android.view.View r4 = r4.getChildAt(r3)
            boolean r5 = r4 instanceof ir.eitaa.ui.Cells.AudioPlayerCell
            if (r5 == 0) goto L38
            r5 = r4
            ir.eitaa.ui.Cells.AudioPlayerCell r5 = (ir.eitaa.ui.Cells.AudioPlayerCell) r5
            ir.eitaa.messenger.MessageObject r5 = r5.getMessageObject()
            if (r5 != r0) goto L38
            int r7 = r4.getBottom()
            ir.eitaa.ui.Components.RecyclerListView r3 = r6.listView
            int r3 = r3.getMeasuredHeight()
            if (r7 > r3) goto L3b
            r7 = 1
            goto L3c
        L38:
            int r3 = r3 + 1
            goto L15
        L3b:
            r7 = 0
        L3c:
            if (r7 != 0) goto L5d
            java.util.ArrayList<ir.eitaa.messenger.MessageObject> r7 = r6.playlist
            int r7 = r7.indexOf(r0)
            if (r7 < 0) goto L5d
            boolean r0 = ir.eitaa.messenger.SharedConfig.playOrderReversed
            if (r0 == 0) goto L50
            androidx.recyclerview.widget.LinearLayoutManager r0 = r6.layoutManager
            r0.scrollToPosition(r7)
            goto L5c
        L50:
            androidx.recyclerview.widget.LinearLayoutManager r0 = r6.layoutManager
            java.util.ArrayList<ir.eitaa.messenger.MessageObject> r1 = r6.playlist
            int r1 = r1.size()
            int r1 = r1 - r7
            r0.scrollToPosition(r1)
        L5c:
            return r2
        L5d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.AudioPlayerAlert.scrollToCurrentSong(boolean):boolean");
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet
    public boolean onCustomMeasure(View view, int width, int height) {
        FrameLayout frameLayout = this.blurredView;
        if (view != frameLayout) {
            return false;
        }
        frameLayout.measure(View.MeasureSpec.makeMeasureSpec(width, 1073741824), View.MeasureSpec.makeMeasureSpec(height, 1073741824));
        return true;
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet
    protected boolean onCustomLayout(View view, int left, int top, int right, int bottom) {
        int i = right - left;
        int i2 = bottom - top;
        FrameLayout frameLayout = this.blurredView;
        if (view != frameLayout) {
            return false;
        }
        frameLayout.layout(left, 0, i + left, i2);
        return true;
    }

    private void setMenuItemChecked(ActionBarMenuSubItem item, boolean checked) {
        if (checked) {
            item.setTextColor(getThemedColor("player_buttonActive"));
            item.setIconColor(getThemedColor("player_buttonActive"));
        } else {
            item.setTextColor(getThemedColor("actionBarDefaultSubmenuItem"));
            item.setIconColor(getThemedColor("actionBarDefaultSubmenuItem"));
        }
    }

    private void updateSubMenu() {
        setMenuItemChecked(this.shuffleListItem, SharedConfig.shuffleMusic);
        setMenuItemChecked(this.reverseOrderItem, SharedConfig.playOrderReversed);
        setMenuItemChecked(this.repeatListItem, SharedConfig.repeatMode == 1);
        setMenuItemChecked(this.repeatSongItem, SharedConfig.repeatMode == 2);
    }

    private void updatePlaybackButton() {
        float playbackSpeed = MediaController.getInstance().getPlaybackSpeed(true);
        float f = playbackSpeed - 1.0f;
        String str = Math.abs(f) > 0.001f ? "inappPlayerPlayPause" : "inappPlayerClose";
        this.playbackSpeedButton.setTag(str);
        float fastPlaybackSpeed = MediaController.getInstance().getFastPlaybackSpeed(true);
        if (Math.abs(fastPlaybackSpeed - 1.8f) < 0.001f) {
            this.playbackSpeedButton.setIcon(R.drawable.voice_mini_2_0);
        } else if (Math.abs(fastPlaybackSpeed - 1.5f) < 0.001f) {
            this.playbackSpeedButton.setIcon(R.drawable.voice_mini_1_5);
        } else {
            this.playbackSpeedButton.setIcon(R.drawable.voice_mini_0_5);
        }
        this.playbackSpeedButton.setIconColor(getThemedColor(str));
        if (Build.VERSION.SDK_INT >= 21) {
            this.playbackSpeedButton.setBackgroundDrawable(Theme.createSelectorDrawable(getThemedColor(str) & 436207615, 1, AndroidUtilities.dp(14.0f)));
        }
        for (int i = 0; i < this.speedItems.length; i++) {
            if ((i == 0 && Math.abs(playbackSpeed - 0.5f) < 0.001f) || ((i == 1 && Math.abs(f) < 0.001f) || ((i == 2 && Math.abs(playbackSpeed - 1.5f) < 0.001f) || (i == 3 && Math.abs(playbackSpeed - 1.8f) < 0.001f)))) {
                this.speedItems[i].setColors(getThemedColor("inappPlayerPlayPause"), getThemedColor("inappPlayerPlayPause"));
            } else {
                this.speedItems[i].setColors(getThemedColor("actionBarDefaultSubmenuItem"), getThemedColor("actionBarDefaultSubmenuItemIcon"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onSubItemClick(int r12) {
        /*
            Method dump skipped, instructions count: 500
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.AudioPlayerAlert.onSubItemClick(int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onSubItemClick$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onSubItemClick$9$AudioPlayerAlert(ArrayList arrayList, DialogsActivity dialogsActivity, ArrayList arrayList2, CharSequence charSequence, boolean z) {
        if (arrayList2.size() > 1 || ((Long) arrayList2.get(0)).longValue() == UserConfig.getInstance(this.currentAccount).getClientUserId() || charSequence != null) {
            for (int i = 0; i < arrayList2.size(); i++) {
                long jLongValue = ((Long) arrayList2.get(i)).longValue();
                if (charSequence != null) {
                    SendMessagesHelper.getInstance(this.currentAccount).sendMessage(charSequence.toString(), jLongValue, null, null, null, true, null, null, null, true, 0, null);
                }
                SendMessagesHelper.getInstance(this.currentAccount).sendMessage((ArrayList<MessageObject>) arrayList, jLongValue, false, false, true, 0);
            }
            dialogsActivity.finishFragment();
            return;
        }
        long jLongValue2 = ((Long) arrayList2.get(0)).longValue();
        Bundle bundle = new Bundle();
        bundle.putBoolean("scrollToTopOnResume", true);
        if (DialogObject.isEncryptedDialog(jLongValue2)) {
            bundle.putInt("enc_id", DialogObject.getEncryptedChatId(jLongValue2));
        } else if (DialogObject.isUserDialog(jLongValue2)) {
            bundle.putLong("user_id", jLongValue2);
        } else {
            bundle.putLong("chat_id", -jLongValue2);
        }
        NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.closeChats, new Object[0]);
        ChatActivity chatActivity = new ChatActivity(bundle);
        if (this.parentActivity.presentFragment(chatActivity, true, false)) {
            chatActivity.showFieldPanelForForward(true, arrayList);
        } else {
            dialogsActivity.finishFragment();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onSubItemClick$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onSubItemClick$10$AudioPlayerAlert() {
        BulletinFactory.of((FrameLayout) this.containerView, this.resourcesProvider).createDownloadBulletin(BulletinFactory.FileType.AUDIO).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAlbumCover(boolean show, boolean animated) {
        if (show) {
            if (this.blurredView.getVisibility() == 0 || this.blurredAnimationInProgress) {
                return;
            }
            this.blurredView.setTag(1);
            this.bigAlbumConver.setImageBitmap(this.coverContainer.getImageReceiver().getBitmap());
            this.blurredAnimationInProgress = true;
            View fragmentView = this.parentActivity.getActionBarLayout().fragmentsStack.get(this.parentActivity.getActionBarLayout().fragmentsStack.size() - 1).getFragmentView();
            int measuredWidth = (int) (fragmentView.getMeasuredWidth() / 6.0f);
            int measuredHeight = (int) (fragmentView.getMeasuredHeight() / 6.0f);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            canvas.scale(0.16666667f, 0.16666667f);
            fragmentView.draw(canvas);
            canvas.translate(this.containerView.getLeft() - getLeftInset(), 0.0f);
            this.containerView.draw(canvas);
            Utilities.stackBlurBitmap(bitmapCreateBitmap, Math.max(7, Math.max(measuredWidth, measuredHeight) / 180));
            this.blurredView.setBackground(new BitmapDrawable(bitmapCreateBitmap));
            this.blurredView.setVisibility(0);
            this.blurredView.animate().alpha(1.0f).setDuration(180L).setListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.AudioPlayerAlert.18
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    AudioPlayerAlert.this.blurredAnimationInProgress = false;
                }
            }).start();
            this.bigAlbumConver.animate().scaleX(1.0f).scaleY(1.0f).setDuration(180L).start();
            return;
        }
        if (this.blurredView.getVisibility() != 0) {
            return;
        }
        this.blurredView.setTag(null);
        if (animated) {
            this.blurredAnimationInProgress = true;
            this.blurredView.animate().alpha(0.0f).setDuration(180L).setListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.AudioPlayerAlert.19
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    AudioPlayerAlert.this.blurredView.setVisibility(4);
                    AudioPlayerAlert.this.bigAlbumConver.setImageBitmap(null);
                    AudioPlayerAlert.this.blurredAnimationInProgress = false;
                }
            }).start();
            this.bigAlbumConver.animate().scaleX(0.9f).scaleY(0.9f).setDuration(180L).start();
        } else {
            this.blurredView.setAlpha(0.0f);
            this.blurredView.setVisibility(4);
            this.bigAlbumConver.setImageBitmap(null);
            this.bigAlbumConver.setScaleX(0.9f);
            this.bigAlbumConver.setScaleY(0.9f);
        }
    }

    @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        AudioPlayerCell audioPlayerCell;
        MessageObject messageObject;
        AudioPlayerCell audioPlayerCell2;
        MessageObject messageObject2;
        MessageObject playingMessageObject;
        if (id == NotificationCenter.messagePlayingDidStart || id == NotificationCenter.messagePlayingPlayStateChanged || id == NotificationCenter.messagePlayingDidReset) {
            int i = NotificationCenter.messagePlayingDidReset;
            updateTitle(id == i && ((Boolean) args[1]).booleanValue());
            if (id != i && id != NotificationCenter.messagePlayingPlayStateChanged) {
                if (((MessageObject) args[0]).eventId != 0) {
                    return;
                }
                int childCount = this.listView.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = this.listView.getChildAt(i2);
                    if ((childAt instanceof AudioPlayerCell) && (messageObject2 = (audioPlayerCell2 = (AudioPlayerCell) childAt).getMessageObject()) != null && (messageObject2.isVoice() || messageObject2.isMusic())) {
                        audioPlayerCell2.updateButtonState(false, true);
                    }
                }
                return;
            }
            int childCount2 = this.listView.getChildCount();
            for (int i3 = 0; i3 < childCount2; i3++) {
                View childAt2 = this.listView.getChildAt(i3);
                if ((childAt2 instanceof AudioPlayerCell) && (messageObject = (audioPlayerCell = (AudioPlayerCell) childAt2).getMessageObject()) != null && (messageObject.isVoice() || messageObject.isMusic())) {
                    audioPlayerCell.updateButtonState(false, true);
                }
            }
            if (id != NotificationCenter.messagePlayingPlayStateChanged || MediaController.getInstance().getPlayingMessageObject() == null) {
                return;
            }
            if (MediaController.getInstance().isMessagePaused()) {
                startForwardRewindingSeek();
                return;
            }
            if (this.rewindingState != 1 || this.rewindingProgress == -1.0f) {
                return;
            }
            AndroidUtilities.cancelRunOnUIThread(this.forwardSeek);
            this.lastUpdateRewindingPlayerTime = 0L;
            this.forwardSeek.run();
            this.rewindingProgress = -1.0f;
            return;
        }
        if (id == NotificationCenter.messagePlayingProgressDidChanged) {
            MessageObject playingMessageObject2 = MediaController.getInstance().getPlayingMessageObject();
            if (playingMessageObject2 == null || !playingMessageObject2.isMusic()) {
                return;
            }
            updateProgress(playingMessageObject2);
            return;
        }
        if (id == NotificationCenter.musicDidLoad) {
            this.playlist = MediaController.getInstance().getPlaylist();
            this.listAdapter.notifyDataSetChanged();
            return;
        }
        if (id == NotificationCenter.moreMusicDidLoad) {
            this.playlist = MediaController.getInstance().getPlaylist();
            this.listAdapter.notifyDataSetChanged();
            if (SharedConfig.playOrderReversed) {
                this.listView.stopScroll();
                int iIntValue = ((Integer) args[0]).intValue();
                this.layoutManager.findFirstVisibleItemPosition();
                int iFindLastVisibleItemPosition = this.layoutManager.findLastVisibleItemPosition();
                if (iFindLastVisibleItemPosition != -1) {
                    View viewFindViewByPosition = this.layoutManager.findViewByPosition(iFindLastVisibleItemPosition);
                    this.layoutManager.scrollToPositionWithOffset(iFindLastVisibleItemPosition + iIntValue, viewFindViewByPosition != null ? viewFindViewByPosition.getTop() : 0);
                    return;
                }
                return;
            }
            return;
        }
        if (id == NotificationCenter.fileLoaded) {
            if (((String) args[0]).equals(this.currentFile)) {
                updateTitle(false);
                this.currentAudioFinishedLoading = true;
                return;
            }
            return;
        }
        if (id == NotificationCenter.fileLoadProgressChanged && ((String) args[0]).equals(this.currentFile) && (playingMessageObject = MediaController.getInstance().getPlayingMessageObject()) != null) {
            if (!this.currentAudioFinishedLoading) {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                if (Math.abs(jElapsedRealtime - this.lastBufferedPositionCheck) >= 500) {
                    bufferedProgressFromPosition = MediaController.getInstance().isStreamingCurrentAudio() ? FileLoader.getInstance(this.currentAccount).getBufferedProgressFromPosition(playingMessageObject.audioProgress, this.currentFile) : 1.0f;
                    this.lastBufferedPositionCheck = jElapsedRealtime;
                } else {
                    bufferedProgressFromPosition = -1.0f;
                }
            }
            if (bufferedProgressFromPosition != -1.0f) {
                this.seekBarView.setBufferedProgress(bufferedProgressFromPosition);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLayout() {
        if (this.listView.getChildCount() <= 0) {
            RecyclerListView recyclerListView = this.listView;
            int paddingTop = recyclerListView.getPaddingTop();
            this.scrollOffsetY = paddingTop;
            recyclerListView.setTopGlowOffset(paddingTop);
            this.containerView.invalidate();
            return;
        }
        View childAt = this.listView.getChildAt(0);
        RecyclerListView.Holder holder = (RecyclerListView.Holder) this.listView.findContainingViewHolder(childAt);
        int top = childAt.getTop();
        int iDp = AndroidUtilities.dp(7.0f);
        if (top < AndroidUtilities.dp(7.0f) || holder == null || holder.getAdapterPosition() != 0) {
            top = iDp;
        }
        boolean z = top <= AndroidUtilities.dp(12.0f);
        if ((z && this.actionBar.getTag() == null) || (!z && this.actionBar.getTag() != null)) {
            this.actionBar.setTag(z ? 1 : null);
            AnimatorSet animatorSet = this.actionBarAnimation;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.actionBarAnimation = null;
            }
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.actionBarAnimation = animatorSet2;
            animatorSet2.setDuration(180L);
            AnimatorSet animatorSet3 = this.actionBarAnimation;
            Animator[] animatorArr = new Animator[2];
            ActionBar actionBar = this.actionBar;
            Property property = View.ALPHA;
            float[] fArr = new float[1];
            fArr[0] = z ? 1.0f : 0.0f;
            animatorArr[0] = ObjectAnimator.ofFloat(actionBar, (Property<ActionBar, Float>) property, fArr);
            View view = this.actionBarShadow;
            Property property2 = View.ALPHA;
            float[] fArr2 = new float[1];
            fArr2[0] = z ? 1.0f : 0.0f;
            animatorArr[1] = ObjectAnimator.ofFloat(view, (Property<View, Float>) property2, fArr2);
            animatorSet3.playTogether(animatorArr);
            this.actionBarAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.AudioPlayerAlert.20
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    AudioPlayerAlert.this.actionBarAnimation = null;
                }
            });
            this.actionBarAnimation.start();
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.listView.getLayoutParams();
        int iDp2 = top + (layoutParams.topMargin - AndroidUtilities.dp(11.0f));
        if (this.scrollOffsetY != iDp2) {
            RecyclerListView recyclerListView2 = this.listView;
            this.scrollOffsetY = iDp2;
            recyclerListView2.setTopGlowOffset(iDp2 - layoutParams.topMargin);
            this.containerView.invalidate();
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.messagePlayingDidReset);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.messagePlayingPlayStateChanged);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.messagePlayingDidStart);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.messagePlayingProgressDidChanged);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.fileLoaded);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.fileLoadProgressChanged);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.musicDidLoad);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.moreMusicDidLoad);
        DownloadController.getInstance(this.currentAccount).removeLoadingFileObserver(this);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        ActionBar actionBar = this.actionBar;
        if (actionBar != null && actionBar.isSearchFieldVisible()) {
            this.actionBar.closeSearchField();
        } else if (this.blurredView.getTag() != null) {
            showAlbumCover(false, true);
        } else {
            super.onBackPressed();
        }
    }

    @Override // ir.eitaa.messenger.DownloadController.FileDownloadProgressListener
    public void onProgressDownload(String fileName, long downloadedSize, long totalSize) {
        this.progressView.setProgress(Math.min(1.0f, downloadedSize / totalSize), true);
    }

    @Override // ir.eitaa.messenger.DownloadController.FileDownloadProgressListener
    public int getObserverTag() {
        return this.TAG;
    }

    private void updateRepeatButton() {
        int i = SharedConfig.repeatMode;
        if (i != 0 && i != 1) {
            if (i == 2) {
                this.repeatButton.setIcon(R.drawable.player_new_repeatone);
                this.repeatButton.setTag("player_buttonActive");
                this.repeatButton.setIconColor(getThemedColor("player_buttonActive"));
                Theme.setSelectorDrawableColor(this.repeatButton.getBackground(), 436207615 & getThemedColor("player_buttonActive"), true);
                this.repeatButton.setContentDescription(LocaleController.getString("AccDescrRepeatOne", R.string.AccDescrRepeatOne));
                return;
            }
            return;
        }
        if (SharedConfig.shuffleMusic) {
            if (i == 0) {
                this.repeatButton.setIcon(R.drawable.player_new_shuffle);
            } else {
                this.repeatButton.setIcon(R.drawable.player_new_repeat_shuffle);
            }
        } else if (!SharedConfig.playOrderReversed) {
            this.repeatButton.setIcon(R.drawable.player_new_repeatall);
        } else if (i == 0) {
            this.repeatButton.setIcon(R.drawable.player_new_order);
        } else {
            this.repeatButton.setIcon(R.drawable.player_new_repeat_reverse);
        }
        if (i == 0 && !SharedConfig.shuffleMusic && !SharedConfig.playOrderReversed) {
            this.repeatButton.setTag("player_button");
            this.repeatButton.setIconColor(getThemedColor("player_button"));
            Theme.setSelectorDrawableColor(this.repeatButton.getBackground(), getThemedColor("listSelectorSDK21"), true);
            this.repeatButton.setContentDescription(LocaleController.getString("AccDescrRepeatOff", R.string.AccDescrRepeatOff));
            return;
        }
        this.repeatButton.setTag("player_buttonActive");
        this.repeatButton.setIconColor(getThemedColor("player_buttonActive"));
        Theme.setSelectorDrawableColor(this.repeatButton.getBackground(), 436207615 & getThemedColor("player_buttonActive"), true);
        if (i == 0) {
            if (SharedConfig.shuffleMusic) {
                this.repeatButton.setContentDescription(LocaleController.getString("ShuffleList", R.string.ShuffleList));
                return;
            } else {
                this.repeatButton.setContentDescription(LocaleController.getString("ReverseOrder", R.string.ReverseOrder));
                return;
            }
        }
        this.repeatButton.setContentDescription(LocaleController.getString("AccDescrRepeatList", R.string.AccDescrRepeatList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateProgress(MessageObject messageObject) {
        updateProgress(messageObject, false);
    }

    private void updateProgress(MessageObject messageObject, boolean animated) {
        int duration;
        int i;
        SeekBarView seekBarView = this.seekBarView;
        if (seekBarView != null) {
            if (seekBarView.isDragging()) {
                duration = (int) (messageObject.getDuration() * this.seekBarView.getProgress());
            } else {
                boolean z = true;
                if (this.rewindingProgress < 0.0f || ((i = this.rewindingState) != -1 && (i != 1 || !MediaController.getInstance().isMessagePaused()))) {
                    z = false;
                }
                if (z) {
                    this.seekBarView.setProgress(this.rewindingProgress, animated);
                } else {
                    this.seekBarView.setProgress(messageObject.audioProgress, animated);
                }
                if (!this.currentAudioFinishedLoading) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    if (Math.abs(jElapsedRealtime - this.lastBufferedPositionCheck) >= 500) {
                        bufferedProgressFromPosition = MediaController.getInstance().isStreamingCurrentAudio() ? FileLoader.getInstance(this.currentAccount).getBufferedProgressFromPosition(messageObject.audioProgress, this.currentFile) : 1.0f;
                        this.lastBufferedPositionCheck = jElapsedRealtime;
                    } else {
                        bufferedProgressFromPosition = -1.0f;
                    }
                }
                if (bufferedProgressFromPosition != -1.0f) {
                    this.seekBarView.setBufferedProgress(bufferedProgressFromPosition);
                }
                if (z) {
                    int duration2 = (int) (messageObject.getDuration() * this.seekBarView.getProgress());
                    messageObject.audioProgressSec = duration2;
                    duration = duration2;
                } else {
                    duration = messageObject.audioProgressSec;
                }
            }
            if (this.lastTime != duration) {
                this.lastTime = duration;
                this.timeTextView.setText(AndroidUtilities.formatShortDuration(duration));
            }
        }
    }

    private void checkIfMusicDownloaded(MessageObject messageObject) {
        String str = messageObject.messageOwner.attachPath;
        File pathToMessage = null;
        if (str != null && str.length() > 0) {
            File file = new File(messageObject.messageOwner.attachPath);
            if (file.exists()) {
                pathToMessage = file;
            }
        }
        if (pathToMessage == null) {
            pathToMessage = FileLoader.getPathToMessage(messageObject.messageOwner);
        }
        boolean z = SharedConfig.streamMedia && ((int) messageObject.getDialogId()) != 0 && messageObject.isMusic();
        if (!pathToMessage.exists() && !z) {
            String fileName = messageObject.getFileName();
            DownloadController.getInstance(this.currentAccount).addLoadingFileObserver(fileName, this);
            Float fileProgress = ImageLoader.getInstance().getFileProgress(fileName);
            this.progressView.setProgress(fileProgress != null ? fileProgress.floatValue() : 0.0f, false);
            this.progressView.setVisibility(0);
            this.seekBarView.setVisibility(4);
            this.playButton.setEnabled(false);
            return;
        }
        DownloadController.getInstance(this.currentAccount).removeLoadingFileObserver(this);
        this.progressView.setVisibility(4);
        this.seekBarView.setVisibility(0);
        this.playButton.setEnabled(true);
    }

    private void updateTitle(boolean shutdown) {
        MessageObject playingMessageObject = MediaController.getInstance().getPlayingMessageObject();
        if ((playingMessageObject == null && shutdown) || (playingMessageObject != null && !playingMessageObject.isMusic())) {
            dismiss();
            return;
        }
        if (playingMessageObject == null) {
            this.lastMessageObject = null;
            return;
        }
        boolean z = playingMessageObject == this.lastMessageObject;
        this.lastMessageObject = playingMessageObject;
        if (playingMessageObject.eventId != 0 || playingMessageObject.getId() <= -2000000000) {
            this.optionsButton.setVisibility(4);
        } else {
            this.optionsButton.setVisibility(0);
        }
        checkIfMusicDownloaded(playingMessageObject);
        updateProgress(playingMessageObject, !z);
        updateCover(playingMessageObject, !z);
        if (MediaController.getInstance().isMessagePaused()) {
            this.playPauseDrawable.setPause(false);
            this.playButton.setContentDescription(LocaleController.getString("AccActionPlay", R.string.AccActionPlay));
        } else {
            this.playPauseDrawable.setPause(true);
            this.playButton.setContentDescription(LocaleController.getString("AccActionPause", R.string.AccActionPause));
        }
        String musicTitle = playingMessageObject.getMusicTitle();
        String musicAuthor = playingMessageObject.getMusicAuthor();
        this.titleTextView.setText(musicTitle);
        this.authorTextView.setText(musicAuthor);
        int duration = playingMessageObject.getDuration();
        this.lastDuration = duration;
        TextView textView = this.durationTextView;
        if (textView != null) {
            textView.setText(duration != 0 ? AndroidUtilities.formatShortDuration(duration) : "-:--");
        }
        this.playbackSpeedButton.setVisibility(0);
        if (z) {
            return;
        }
        preloadNeighboringThumbs();
    }

    private void updateCover(MessageObject messageObject, boolean animated) {
        CoverContainer coverContainer = this.coverContainer;
        BackupImageView nextImageView = animated ? coverContainer.getNextImageView() : coverContainer.getImageView();
        AudioInfo audioInfo = MediaController.getInstance().getAudioInfo();
        if (audioInfo != null && audioInfo.getCover() != null) {
            nextImageView.setImageBitmap(audioInfo.getCover());
            this.currentFile = null;
            this.currentAudioFinishedLoading = true;
        } else {
            this.currentFile = FileLoader.getAttachFileName(messageObject.getDocument());
            this.currentAudioFinishedLoading = false;
            String artworkUrl = messageObject.getArtworkUrl(false);
            ImageLocation artworkThumbImageLocation = getArtworkThumbImageLocation(messageObject);
            if (!TextUtils.isEmpty(artworkUrl)) {
                nextImageView.setImage(ImageLocation.getForPath(artworkUrl), null, artworkThumbImageLocation, null, null, 0, 1, messageObject);
            } else if (artworkThumbImageLocation != null) {
                nextImageView.setImage(null, null, artworkThumbImageLocation, null, null, 0, 1, messageObject);
            } else {
                nextImageView.setImageDrawable(null);
            }
            nextImageView.invalidate();
        }
        if (animated) {
            this.coverContainer.switchImageViews();
        }
    }

    private ImageLocation getArtworkThumbImageLocation(MessageObject messageObject) {
        TLRPC$Document document = messageObject.getDocument();
        TLRPC$PhotoSize closestPhotoSizeWithSize = document != null ? FileLoader.getClosestPhotoSizeWithSize(document.thumbs, 360) : null;
        if (!(closestPhotoSizeWithSize instanceof TLRPC$TL_photoSize) && !(closestPhotoSizeWithSize instanceof TLRPC$TL_photoSizeProgressive)) {
            closestPhotoSizeWithSize = null;
        }
        if (closestPhotoSizeWithSize != null) {
            return ImageLocation.getForDocument(closestPhotoSizeWithSize, document);
        }
        String artworkUrl = messageObject.getArtworkUrl(true);
        if (artworkUrl != null) {
            return ImageLocation.getForPath(artworkUrl);
        }
        return null;
    }

    private void preloadNeighboringThumbs() {
        MediaController mediaController = MediaController.getInstance();
        ArrayList<MessageObject> playlist = mediaController.getPlaylist();
        if (playlist.size() <= 1) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int playingMessageObjectNum = mediaController.getPlayingMessageObjectNum();
        int i = playingMessageObjectNum + 1;
        int size = playingMessageObjectNum - 1;
        if (i >= playlist.size()) {
            i = 0;
        }
        if (size <= -1) {
            size = playlist.size() - 1;
        }
        arrayList.add(playlist.get(i));
        if (i != size) {
            arrayList.add(playlist.get(size));
        }
        int size2 = arrayList.size();
        for (int i2 = 0; i2 < size2; i2++) {
            MessageObject messageObject = (MessageObject) arrayList.get(i2);
            ImageLocation artworkThumbImageLocation = getArtworkThumbImageLocation(messageObject);
            if (artworkThumbImageLocation != null) {
                if (artworkThumbImageLocation.path != null) {
                    ImageLoader.getInstance().preloadArtwork(artworkThumbImageLocation.path);
                } else {
                    FileLoader.getInstance(this.currentAccount).loadFile(artworkThumbImageLocation, messageObject, null, 0, 1);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context context;
        private ArrayList<MessageObject> searchResult = new ArrayList<>();
        private Runnable searchRunnable;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return 0;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            return true;
        }

        public ListAdapter(Context context) {
            this.context = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyDataSetChanged() {
            super.notifyDataSetChanged();
            if (AudioPlayerAlert.this.playlist.size() > 1) {
                AudioPlayerAlert.this.playerLayout.setBackgroundColor(AudioPlayerAlert.this.getThemedColor("player_background"));
                AudioPlayerAlert.this.playerShadow.setVisibility(0);
                AudioPlayerAlert.this.listView.setPadding(0, AudioPlayerAlert.this.listView.getPaddingTop(), 0, AndroidUtilities.dp(179.0f));
            } else {
                AudioPlayerAlert.this.playerLayout.setBackground(null);
                AudioPlayerAlert.this.playerShadow.setVisibility(4);
                AudioPlayerAlert.this.listView.setPadding(0, AudioPlayerAlert.this.listView.getPaddingTop(), 0, 0);
            }
            AudioPlayerAlert.this.updateEmptyView();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (!AudioPlayerAlert.this.searchWas) {
                if (AudioPlayerAlert.this.playlist.size() > 1) {
                    return AudioPlayerAlert.this.playlist.size();
                }
                return 0;
            }
            return this.searchResult.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            Context context = this.context;
            boolean zCurrentPlaylistIsGlobalSearch = MediaController.getInstance().currentPlaylistIsGlobalSearch();
            return new RecyclerListView.Holder(new AudioPlayerCell(context, zCurrentPlaylistIsGlobalSearch ? 1 : 0, ((BottomSheet) AudioPlayerAlert.this).resourcesProvider));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            AudioPlayerCell audioPlayerCell = (AudioPlayerCell) holder.itemView;
            if (AudioPlayerAlert.this.searchWas) {
                audioPlayerCell.setMessageObject(this.searchResult.get(position));
            } else if (SharedConfig.playOrderReversed) {
                audioPlayerCell.setMessageObject((MessageObject) AudioPlayerAlert.this.playlist.get(position));
            } else {
                audioPlayerCell.setMessageObject((MessageObject) AudioPlayerAlert.this.playlist.get((AudioPlayerAlert.this.playlist.size() - position) - 1));
            }
        }

        public void search(final String query) throws InterruptedException {
            if (this.searchRunnable != null) {
                Utilities.searchQueue.cancelRunnable(this.searchRunnable);
                this.searchRunnable = null;
            }
            if (query == null) {
                this.searchResult.clear();
                notifyDataSetChanged();
            } else {
                DispatchQueue dispatchQueue = Utilities.searchQueue;
                Runnable runnable = new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$AudioPlayerAlert$ListAdapter$PRB3A1dw0B8K8OgI0KK6Am1_hxY
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$search$0$AudioPlayerAlert$ListAdapter(query);
                    }
                };
                this.searchRunnable = runnable;
                dispatchQueue.postRunnable(runnable, 300L);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$search$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$search$0$AudioPlayerAlert$ListAdapter(String str) {
            this.searchRunnable = null;
            processSearch(str);
        }

        private void processSearch(final String query) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$AudioPlayerAlert$ListAdapter$IuszwwVJb-_zZfqKcGEU_OrnsQA
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processSearch$2$AudioPlayerAlert$ListAdapter(query);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$processSearch$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$processSearch$2$AudioPlayerAlert$ListAdapter(final String str) {
            final ArrayList arrayList = new ArrayList(AudioPlayerAlert.this.playlist);
            Utilities.searchQueue.postRunnable(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$AudioPlayerAlert$ListAdapter$gcAiTN93W_e8MCDEaijBjcdyMww
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processSearch$1$AudioPlayerAlert$ListAdapter(str, arrayList);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$processSearch$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$processSearch$1$AudioPlayerAlert$ListAdapter(String str, ArrayList arrayList) {
            TLRPC$Document tLRPC$Document;
            boolean zContains;
            String str2;
            String lowerCase = str.trim().toLowerCase();
            if (lowerCase.length() == 0) {
                updateSearchResults(new ArrayList<>(), str);
                return;
            }
            String translitString = LocaleController.getInstance().getTranslitString(lowerCase);
            if (lowerCase.equals(translitString) || translitString.length() == 0) {
                translitString = null;
            }
            int i = (translitString != null ? 1 : 0) + 1;
            String[] strArr = new String[i];
            strArr[0] = lowerCase;
            if (translitString != null) {
                strArr[1] = translitString;
            }
            ArrayList<MessageObject> arrayList2 = new ArrayList<>();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                MessageObject messageObject = (MessageObject) arrayList.get(i2);
                int i3 = 0;
                while (true) {
                    if (i3 < i) {
                        String str3 = strArr[i3];
                        String documentName = messageObject.getDocumentName();
                        if (documentName != null && documentName.length() != 0) {
                            if (documentName.toLowerCase().contains(str3)) {
                                arrayList2.add(messageObject);
                                break;
                            }
                            if (messageObject.type == 0) {
                                tLRPC$Document = messageObject.messageOwner.media.webpage.document;
                            } else {
                                tLRPC$Document = messageObject.messageOwner.media.document;
                            }
                            int i4 = 0;
                            while (true) {
                                if (i4 >= tLRPC$Document.attributes.size()) {
                                    zContains = false;
                                    break;
                                }
                                TLRPC$DocumentAttribute tLRPC$DocumentAttribute = tLRPC$Document.attributes.get(i4);
                                if (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeAudio) {
                                    String str4 = tLRPC$DocumentAttribute.performer;
                                    zContains = str4 != null ? str4.toLowerCase().contains(str3) : false;
                                    if (!zContains && (str2 = tLRPC$DocumentAttribute.title) != null) {
                                        zContains = str2.toLowerCase().contains(str3);
                                    }
                                } else {
                                    i4++;
                                }
                            }
                            if (zContains) {
                                arrayList2.add(messageObject);
                                break;
                            }
                        }
                        i3++;
                    }
                }
            }
            updateSearchResults(arrayList2, str);
        }

        private void updateSearchResults(final ArrayList<MessageObject> documents, final String query) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$AudioPlayerAlert$ListAdapter$JMuRnRoFKgSbdRQTBzh2EV89IyY
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$updateSearchResults$3$AudioPlayerAlert$ListAdapter(documents, query);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$updateSearchResults$3, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$updateSearchResults$3$AudioPlayerAlert$ListAdapter(ArrayList arrayList, String str) {
            if (AudioPlayerAlert.this.searching) {
                AudioPlayerAlert.this.searchWas = true;
                this.searchResult = arrayList;
                notifyDataSetChanged();
                AudioPlayerAlert.this.layoutManager.scrollToPosition(0);
                AudioPlayerAlert.this.emptySubtitleTextView.setText(AndroidUtilities.replaceTags(LocaleController.formatString("NoAudioFoundPlayerInfo", R.string.NoAudioFoundPlayerInfo, str)));
            }
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$AudioPlayerAlert$j9h81l7c22wPoq1FHnSd1zUN55g
            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() {
                this.f$0.lambda$getThemeDescriptions$11$AudioPlayerAlert();
            }

            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public /* synthetic */ void onAnimationProgress(float f) {
                ThemeDescription.ThemeDescriptionDelegate.CC.$default$onAnimationProgress(this, f);
            }
        };
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "player_actionBar"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, themeDescriptionDelegate, "player_actionBarTitle"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, "player_actionBarTitle"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SUBTITLECOLOR, null, null, null, null, "player_actionBarTitle"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "player_actionBarSelector"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SEARCH, null, null, null, null, "player_actionBarTitle"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SEARCHPLACEHOLDER, null, null, null, null, "player_time"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{AudioPlayerCell.class}, null, null, null, "chat_inLoader"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{AudioPlayerCell.class}, null, null, null, "chat_outLoader"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{AudioPlayerCell.class}, null, null, null, "chat_inLoaderSelected"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{AudioPlayerCell.class}, null, null, null, "chat_inMediaIcon"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{AudioPlayerCell.class}, null, null, null, "chat_inMediaIconSelected"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{AudioPlayerCell.class}, null, null, null, "windowBackgroundWhiteGrayText2"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{AudioPlayerCell.class}, null, null, null, "chat_inAudioSelectedProgress"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{AudioPlayerCell.class}, null, null, null, "chat_inAudioProgress"));
        arrayList.add(new ThemeDescription(this.containerView, 0, null, null, new Drawable[]{this.shadowDrawable}, null, "dialogBackground"));
        arrayList.add(new ThemeDescription(this.progressView, 0, null, null, null, null, "player_progressBackground"));
        arrayList.add(new ThemeDescription(this.progressView, 0, null, null, null, null, "player_progress"));
        arrayList.add(new ThemeDescription(this.seekBarView, 0, null, null, null, null, "player_progressBackground"));
        arrayList.add(new ThemeDescription(this.seekBarView, 0, null, null, null, null, "key_player_progressCachedBackground"));
        arrayList.add(new ThemeDescription(this.seekBarView, ThemeDescription.FLAG_PROGRESSBAR, null, null, null, null, "player_progress"));
        arrayList.add(new ThemeDescription(this.playbackSpeedButton, ThemeDescription.FLAG_CHECKTAG | ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, "inappPlayerPlayPause"));
        arrayList.add(new ThemeDescription(this.playbackSpeedButton, ThemeDescription.FLAG_CHECKTAG | ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, "inappPlayerClose"));
        arrayList.add(new ThemeDescription(this.repeatButton, 0, null, null, null, themeDescriptionDelegate, "player_button"));
        arrayList.add(new ThemeDescription(this.repeatButton, 0, null, null, null, themeDescriptionDelegate, "player_buttonActive"));
        arrayList.add(new ThemeDescription(this.repeatButton, 0, null, null, null, themeDescriptionDelegate, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.repeatButton, 0, null, null, null, themeDescriptionDelegate, "actionBarDefaultSubmenuItem"));
        arrayList.add(new ThemeDescription(this.repeatButton, 0, null, null, null, themeDescriptionDelegate, "actionBarDefaultSubmenuBackground"));
        arrayList.add(new ThemeDescription(this.optionsButton, 0, null, null, null, themeDescriptionDelegate, "player_button"));
        arrayList.add(new ThemeDescription(this.optionsButton, 0, null, null, null, themeDescriptionDelegate, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.optionsButton, 0, null, null, null, themeDescriptionDelegate, "actionBarDefaultSubmenuItem"));
        arrayList.add(new ThemeDescription(this.optionsButton, 0, null, null, null, themeDescriptionDelegate, "actionBarDefaultSubmenuBackground"));
        RLottieImageView rLottieImageView = this.prevButton;
        arrayList.add(new ThemeDescription(rLottieImageView, 0, (Class[]) null, new RLottieDrawable[]{rLottieImageView.getAnimatedDrawable()}, "Triangle 3", "player_button"));
        RLottieImageView rLottieImageView2 = this.prevButton;
        arrayList.add(new ThemeDescription(rLottieImageView2, 0, (Class[]) null, new RLottieDrawable[]{rLottieImageView2.getAnimatedDrawable()}, "Triangle 4", "player_button"));
        RLottieImageView rLottieImageView3 = this.prevButton;
        arrayList.add(new ThemeDescription(rLottieImageView3, 0, (Class[]) null, new RLottieDrawable[]{rLottieImageView3.getAnimatedDrawable()}, "Rectangle 4", "player_button"));
        arrayList.add(new ThemeDescription(this.prevButton, ThemeDescription.FLAG_IMAGECOLOR | ThemeDescription.FLAG_USEBACKGROUNDDRAWABLE, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.playButton, ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, "player_button"));
        arrayList.add(new ThemeDescription(this.playButton, ThemeDescription.FLAG_USEBACKGROUNDDRAWABLE | ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, "listSelectorSDK21"));
        RLottieImageView rLottieImageView4 = this.nextButton;
        arrayList.add(new ThemeDescription(rLottieImageView4, 0, (Class[]) null, new RLottieDrawable[]{rLottieImageView4.getAnimatedDrawable()}, "Triangle 3", "player_button"));
        RLottieImageView rLottieImageView5 = this.nextButton;
        arrayList.add(new ThemeDescription(rLottieImageView5, 0, (Class[]) null, new RLottieDrawable[]{rLottieImageView5.getAnimatedDrawable()}, "Triangle 4", "player_button"));
        RLottieImageView rLottieImageView6 = this.nextButton;
        arrayList.add(new ThemeDescription(rLottieImageView6, 0, (Class[]) null, new RLottieDrawable[]{rLottieImageView6.getAnimatedDrawable()}, "Rectangle 4", "player_button"));
        arrayList.add(new ThemeDescription(this.nextButton, ThemeDescription.FLAG_IMAGECOLOR | ThemeDescription.FLAG_USEBACKGROUNDDRAWABLE, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.playerLayout, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "player_background"));
        arrayList.add(new ThemeDescription(this.playerShadow, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "dialogShadowLine"));
        arrayList.add(new ThemeDescription(this.emptyImageView, ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, "dialogEmptyImage"));
        arrayList.add(new ThemeDescription(this.emptyTitleTextView, ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, "dialogEmptyText"));
        arrayList.add(new ThemeDescription(this.emptySubtitleTextView, ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, "dialogEmptyText"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, "dialogScrollGlow"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, "divider"));
        arrayList.add(new ThemeDescription(this.progressView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "emptyListPlaceholder"));
        arrayList.add(new ThemeDescription(this.progressView, ThemeDescription.FLAG_PROGRESSBAR, null, null, null, null, "progressCircle"));
        arrayList.add(new ThemeDescription(this.durationTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "player_time"));
        arrayList.add(new ThemeDescription(this.timeTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "player_time"));
        arrayList.add(new ThemeDescription(this.titleTextView.getTextView(), ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "player_actionBarTitle"));
        arrayList.add(new ThemeDescription(this.titleTextView.getNextTextView(), ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "player_actionBarTitle"));
        arrayList.add(new ThemeDescription(this.authorTextView.getTextView(), ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "player_time"));
        arrayList.add(new ThemeDescription(this.authorTextView.getNextTextView(), ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "player_time"));
        arrayList.add(new ThemeDescription(this.containerView, 0, null, null, null, null, "key_sheet_scrollUp"));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getThemeDescriptions$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getThemeDescriptions$11$AudioPlayerAlert() {
        this.searchItem.getSearchField().setCursorColor(getThemedColor("player_actionBarTitle"));
        ActionBarMenuItem actionBarMenuItem = this.repeatButton;
        actionBarMenuItem.setIconColor(getThemedColor((String) actionBarMenuItem.getTag()));
        Theme.setSelectorDrawableColor(this.repeatButton.getBackground(), getThemedColor("listSelectorSDK21"), true);
        this.optionsButton.setIconColor(getThemedColor("player_button"));
        Theme.setSelectorDrawableColor(this.optionsButton.getBackground(), getThemedColor("listSelectorSDK21"), true);
        this.progressView.setBackgroundColor(getThemedColor("player_progressBackground"));
        this.progressView.setProgressColor(getThemedColor("player_progress"));
        updateSubMenu();
        this.repeatButton.redrawPopup(getThemedColor("actionBarDefaultSubmenuBackground"));
        this.optionsButton.setPopupItemsColor(getThemedColor("actionBarDefaultSubmenuItem"), false);
        this.optionsButton.setPopupItemsColor(getThemedColor("actionBarDefaultSubmenuItem"), true);
        this.optionsButton.redrawPopup(getThemedColor("actionBarDefaultSubmenuBackground"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    static abstract class CoverContainer extends FrameLayout {
        private int activeIndex;
        private AnimatorSet animatorSet;
        private final BackupImageView[] imageViews;

        protected abstract void onImageUpdated(ImageReceiver imageReceiver);

        public CoverContainer(Context context) {
            super(context);
            this.imageViews = new BackupImageView[2];
            for (final int i = 0; i < 2; i++) {
                this.imageViews[i] = new BackupImageView(context);
                this.imageViews[i].getImageReceiver().setDelegate(new ImageReceiver.ImageReceiverDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$AudioPlayerAlert$CoverContainer$vN5b2qEWKS9ZxBttyFIPtKJJBhg
                    @Override // ir.eitaa.messenger.ImageReceiver.ImageReceiverDelegate
                    public final void didSetImage(ImageReceiver imageReceiver, boolean z, boolean z2, boolean z3) {
                        this.f$0.lambda$new$0$AudioPlayerAlert$CoverContainer(i, imageReceiver, z, z2, z3);
                    }

                    @Override // ir.eitaa.messenger.ImageReceiver.ImageReceiverDelegate
                    public /* synthetic */ void onAnimationReady(ImageReceiver imageReceiver) {
                        ImageReceiver.ImageReceiverDelegate.CC.$default$onAnimationReady(this, imageReceiver);
                    }
                });
                this.imageViews[i].setRoundRadius(AndroidUtilities.dp(4.0f));
                if (i == 1) {
                    this.imageViews[i].setVisibility(8);
                }
                addView(this.imageViews[i], LayoutHelper.createFrame(-1, -1.0f));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$0$AudioPlayerAlert$CoverContainer(int i, ImageReceiver imageReceiver, boolean z, boolean z2, boolean z3) {
            if (i == this.activeIndex) {
                onImageUpdated(imageReceiver);
            }
        }

        public final void switchImageViews() {
            AnimatorSet animatorSet = this.animatorSet;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            this.animatorSet = new AnimatorSet();
            int i = this.activeIndex == 0 ? 1 : 0;
            this.activeIndex = i;
            BackupImageView[] backupImageViewArr = this.imageViews;
            final BackupImageView backupImageView = backupImageViewArr[i == 0 ? (char) 1 : (char) 0];
            final BackupImageView backupImageView2 = backupImageViewArr[i];
            final boolean zHasBitmapImage = backupImageView.getImageReceiver().hasBitmapImage();
            backupImageView2.setAlpha(zHasBitmapImage ? 1.0f : 0.0f);
            backupImageView2.setScaleX(0.8f);
            backupImageView2.setScaleY(0.8f);
            backupImageView2.setVisibility(0);
            if (zHasBitmapImage) {
                backupImageView.bringToFront();
            } else {
                backupImageView.setVisibility(8);
                backupImageView.setImageDrawable(null);
            }
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
            valueAnimatorOfFloat.setDuration(125L);
            valueAnimatorOfFloat.setInterpolator(CubicBezierInterpolator.EASE_OUT);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AudioPlayerAlert$CoverContainer$PAbmvXJFsyQrQ9Ndzv7hD41EcW0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AudioPlayerAlert.CoverContainer.lambda$switchImageViews$1(backupImageView2, zHasBitmapImage, valueAnimator);
                }
            });
            if (zHasBitmapImage) {
                ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(backupImageView.getScaleX(), 0.8f);
                valueAnimatorOfFloat2.setDuration(125L);
                valueAnimatorOfFloat2.setInterpolator(CubicBezierInterpolator.EASE_IN);
                valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AudioPlayerAlert$CoverContainer$rIboi4HqUoA1PZby7m4e3Ja6xb0
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        AudioPlayerAlert.CoverContainer.lambda$switchImageViews$2(backupImageView, backupImageView2, valueAnimator);
                    }
                });
                valueAnimatorOfFloat2.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.AudioPlayerAlert.CoverContainer.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        backupImageView.setVisibility(8);
                        backupImageView.setImageDrawable(null);
                        backupImageView.setAlpha(1.0f);
                    }
                });
                this.animatorSet.playSequentially(valueAnimatorOfFloat2, valueAnimatorOfFloat);
            } else {
                this.animatorSet.play(valueAnimatorOfFloat);
            }
            this.animatorSet.start();
        }

        static /* synthetic */ void lambda$switchImageViews$1(BackupImageView backupImageView, boolean z, ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            backupImageView.setScaleX(fFloatValue);
            backupImageView.setScaleY(fFloatValue);
            if (z) {
                return;
            }
            backupImageView.setAlpha(valueAnimator.getAnimatedFraction());
        }

        static /* synthetic */ void lambda$switchImageViews$2(BackupImageView backupImageView, BackupImageView backupImageView2, ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            backupImageView.setScaleX(fFloatValue);
            backupImageView.setScaleY(fFloatValue);
            float animatedFraction = valueAnimator.getAnimatedFraction();
            if (animatedFraction <= 0.25f || backupImageView2.getImageReceiver().hasBitmapImage()) {
                return;
            }
            backupImageView.setAlpha(1.0f - ((animatedFraction - 0.25f) * 1.3333334f));
        }

        public final BackupImageView getImageView() {
            return this.imageViews[this.activeIndex];
        }

        public final BackupImageView getNextImageView() {
            return this.imageViews[this.activeIndex == 0 ? (char) 1 : (char) 0];
        }

        public final ImageReceiver getImageReceiver() {
            return getImageView().getImageReceiver();
        }
    }

    public static abstract class ClippingTextViewSwitcher extends FrameLayout {
        private int activeIndex;
        private AnimatorSet animatorSet;
        private final float[] clipProgress;
        private final Paint erasePaint;
        private final Matrix gradientMatrix;
        private final Paint gradientPaint;
        private LinearGradient gradientShader;
        private final int gradientSize;
        private final RectF rectF;
        private int stableOffest;
        private final TextView[] textViews;

        protected abstract TextView createTextView();

        public ClippingTextViewSwitcher(Context context) {
            super(context);
            this.textViews = new TextView[2];
            this.clipProgress = new float[]{0.0f, 0.75f};
            this.gradientSize = AndroidUtilities.dp(24.0f);
            this.stableOffest = -1;
            this.rectF = new RectF();
            for (int i = 0; i < 2; i++) {
                this.textViews[i] = createTextView();
                if (i == 1) {
                    this.textViews[i].setAlpha(0.0f);
                    this.textViews[i].setVisibility(8);
                }
                addView(this.textViews[i], LayoutHelper.createFrame(-2, -1.0f));
            }
            this.gradientMatrix = new Matrix();
            Paint paint = new Paint(1);
            this.gradientPaint = paint;
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            Paint paint2 = new Paint(1);
            this.erasePaint = paint2;
            paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        }

        @Override // android.view.View
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            super.onSizeChanged(w, h, oldw, oldh);
            LinearGradient linearGradient = new LinearGradient(this.gradientSize, 0.0f, 0.0f, 0.0f, 0, -16777216, Shader.TileMode.CLAMP);
            this.gradientShader = linearGradient;
            this.gradientPaint.setShader(linearGradient);
        }

        @Override // android.view.ViewGroup
        protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
            boolean z;
            TextView[] textViewArr = this.textViews;
            boolean z2 = true;
            int i = child == textViewArr[0] ? 0 : 1;
            if (this.stableOffest <= 0 || textViewArr[this.activeIndex].getAlpha() == 1.0f || this.textViews[this.activeIndex].getLayout() == null) {
                z = false;
            } else {
                float primaryHorizontal = this.textViews[this.activeIndex].getLayout().getPrimaryHorizontal(0);
                float primaryHorizontal2 = this.textViews[this.activeIndex].getLayout().getPrimaryHorizontal(this.stableOffest);
                if (primaryHorizontal == primaryHorizontal2) {
                    z2 = false;
                } else if (primaryHorizontal2 > primaryHorizontal) {
                    this.rectF.set(primaryHorizontal, 0.0f, primaryHorizontal2, getMeasuredHeight());
                } else {
                    this.rectF.set(primaryHorizontal2, 0.0f, primaryHorizontal, getMeasuredHeight());
                }
                if (z2 && i == this.activeIndex) {
                    canvas.save();
                    canvas.clipRect(this.rectF);
                    this.textViews[0].draw(canvas);
                    canvas.restore();
                }
                z = z2;
            }
            if (this.clipProgress[i] > 0.0f || z) {
                float width = child.getWidth();
                float height = child.getHeight();
                int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, width, height, null, 31);
                boolean zDrawChild = super.drawChild(canvas, child, drawingTime);
                float f = width * (1.0f - this.clipProgress[i]);
                float f2 = f + this.gradientSize;
                this.gradientMatrix.setTranslate(f, 0.0f);
                this.gradientShader.setLocalMatrix(this.gradientMatrix);
                canvas.drawRect(f, 0.0f, f2, height, this.gradientPaint);
                if (width > f2) {
                    canvas.drawRect(f2, 0.0f, width, height, this.erasePaint);
                }
                if (z) {
                    canvas.drawRect(this.rectF, this.erasePaint);
                }
                canvas.restoreToCount(iSaveLayer);
                return zDrawChild;
            }
            return super.drawChild(canvas, child, drawingTime);
        }

        public void setText(CharSequence text) {
            setText(text, true);
        }

        public void setText(CharSequence text, boolean animated) {
            CharSequence text2 = this.textViews[this.activeIndex].getText();
            if (TextUtils.isEmpty(text2) || !animated) {
                this.textViews[this.activeIndex].setText(text);
                return;
            }
            if (TextUtils.equals(text, text2)) {
                return;
            }
            this.stableOffest = 0;
            int iMin = Math.min(text.length(), text2.length());
            for (int i = 0; i < iMin && text.charAt(i) == text2.charAt(i); i++) {
                this.stableOffest++;
            }
            if (this.stableOffest <= 3) {
                this.stableOffest = -1;
            }
            final int i2 = this.activeIndex;
            final int i3 = i2 == 0 ? 1 : 0;
            this.activeIndex = i3;
            AnimatorSet animatorSet = this.animatorSet;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.animatorSet = animatorSet2;
            animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.AudioPlayerAlert.ClippingTextViewSwitcher.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    ClippingTextViewSwitcher.this.textViews[i2].setVisibility(8);
                }
            });
            this.textViews[i3].setText(text);
            this.textViews[i3].bringToFront();
            this.textViews[i3].setVisibility(0);
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.clipProgress[i2], 0.75f);
            valueAnimatorOfFloat.setDuration(200L);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AudioPlayerAlert$ClippingTextViewSwitcher$QF5GZL06wz9NZg_O_otV7CAsyPs
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f$0.lambda$setText$0$AudioPlayerAlert$ClippingTextViewSwitcher(i2, valueAnimator);
                }
            });
            ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(this.clipProgress[i3], 0.0f);
            valueAnimatorOfFloat2.setStartDelay(100L);
            valueAnimatorOfFloat2.setDuration(200L);
            valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AudioPlayerAlert$ClippingTextViewSwitcher$qvHazyRy9beEvde5t7-r-6wXFac
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f$0.lambda$setText$1$AudioPlayerAlert$ClippingTextViewSwitcher(i3, valueAnimator);
                }
            });
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.textViews[i2], (Property<TextView, Float>) View.ALPHA, 0.0f);
            objectAnimatorOfFloat.setStartDelay(75L);
            objectAnimatorOfFloat.setDuration(150L);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.textViews[i3], (Property<TextView, Float>) View.ALPHA, 1.0f);
            objectAnimatorOfFloat2.setStartDelay(75L);
            objectAnimatorOfFloat2.setDuration(150L);
            this.animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2, objectAnimatorOfFloat, objectAnimatorOfFloat2);
            this.animatorSet.start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$setText$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$setText$0$AudioPlayerAlert$ClippingTextViewSwitcher(int i, ValueAnimator valueAnimator) {
            this.clipProgress[i] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            invalidate();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$setText$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$setText$1$AudioPlayerAlert$ClippingTextViewSwitcher(int i, ValueAnimator valueAnimator) {
            this.clipProgress[i] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            invalidate();
        }

        public TextView getTextView() {
            return this.textViews[this.activeIndex];
        }

        public TextView getNextTextView() {
            return this.textViews[this.activeIndex == 0 ? (char) 1 : (char) 0];
        }
    }
}
