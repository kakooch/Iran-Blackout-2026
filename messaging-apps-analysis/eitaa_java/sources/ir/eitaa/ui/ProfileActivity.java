package ir.eitaa.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Property;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Keep;
import androidx.collection.LongSparseArray;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import ir.eitaa.PhoneFormat.PhoneFormat;
import ir.eitaa.features.CallOut.test.CertSettingView;
import ir.eitaa.features.CallOut.test.TransportTypeSettingView;
import ir.eitaa.features.ChatLock.ChatLockHelper;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.BuildVars;
import ir.eitaa.messenger.ChatObject;
import ir.eitaa.messenger.ChatThemeController;
import ir.eitaa.messenger.ContactsController;
import ir.eitaa.messenger.DialogObject;
import ir.eitaa.messenger.DispatchQueue;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.ImageLoader;
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
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.UserObject;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.messenger.browser.Browser;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.SerializedData;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Ads_Ad;
import ir.eitaa.tgnet.TLRPC$BotInfo;
import ir.eitaa.tgnet.TLRPC$ChannelLocation;
import ir.eitaa.tgnet.TLRPC$ChannelParticipant;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$ChatFull;
import ir.eitaa.tgnet.TLRPC$ChatParticipant;
import ir.eitaa.tgnet.TLRPC$ChatParticipants;
import ir.eitaa.tgnet.TLRPC$ChatPhoto;
import ir.eitaa.tgnet.TLRPC$DecryptedMessageAction;
import ir.eitaa.tgnet.TLRPC$Dialog;
import ir.eitaa.tgnet.TLRPC$EncryptedChat;
import ir.eitaa.tgnet.TLRPC$FileLocation;
import ir.eitaa.tgnet.TLRPC$InputFile;
import ir.eitaa.tgnet.TLRPC$InputPeer;
import ir.eitaa.tgnet.TLRPC$MessageAction;
import ir.eitaa.tgnet.TLRPC$Page;
import ir.eitaa.tgnet.TLRPC$PageBlock;
import ir.eitaa.tgnet.TLRPC$PageListItem;
import ir.eitaa.tgnet.TLRPC$Peer;
import ir.eitaa.tgnet.TLRPC$Photo;
import ir.eitaa.tgnet.TLRPC$PhotoSize;
import ir.eitaa.tgnet.TLRPC$ReplyMarkup;
import ir.eitaa.tgnet.TLRPC$TL_ads_AdPack;
import ir.eitaa.tgnet.TLRPC$TL_ads_getAdsPack;
import ir.eitaa.tgnet.TLRPC$TL_ads_inputAdsLocationChatMembers;
import ir.eitaa.tgnet.TLRPC$TL_channelFull;
import ir.eitaa.tgnet.TLRPC$TL_channelLocation;
import ir.eitaa.tgnet.TLRPC$TL_channelParticipant;
import ir.eitaa.tgnet.TLRPC$TL_channelParticipantAdmin;
import ir.eitaa.tgnet.TLRPC$TL_channelParticipantCreator;
import ir.eitaa.tgnet.TLRPC$TL_channelParticipantsRecent;
import ir.eitaa.tgnet.TLRPC$TL_channels_channelParticipant;
import ir.eitaa.tgnet.TLRPC$TL_channels_channelParticipants;
import ir.eitaa.tgnet.TLRPC$TL_channels_getParticipant;
import ir.eitaa.tgnet.TLRPC$TL_channels_getParticipants;
import ir.eitaa.tgnet.TLRPC$TL_chatAdminRights;
import ir.eitaa.tgnet.TLRPC$TL_chatBannedRights;
import ir.eitaa.tgnet.TLRPC$TL_chatChannelParticipant;
import ir.eitaa.tgnet.TLRPC$TL_chatFull;
import ir.eitaa.tgnet.TLRPC$TL_chatParticipant;
import ir.eitaa.tgnet.TLRPC$TL_chatParticipantAdmin;
import ir.eitaa.tgnet.TLRPC$TL_chatParticipantCreator;
import ir.eitaa.tgnet.TLRPC$TL_chatParticipants;
import ir.eitaa.tgnet.TLRPC$TL_decryptedMessageActionSetMessageTTL;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_inputGroupCall;
import ir.eitaa.tgnet.TLRPC$TL_inputPeerChannel;
import ir.eitaa.tgnet.TLRPC$TL_inputPeerChat;
import ir.eitaa.tgnet.TLRPC$TL_inputPhoto;
import ir.eitaa.tgnet.TLRPC$TL_messageEncryptedAction;
import ir.eitaa.tgnet.TLRPC$TL_messages_getWebPage;
import ir.eitaa.tgnet.TLRPC$TL_pageBlockAnchor;
import ir.eitaa.tgnet.TLRPC$TL_pageBlockList;
import ir.eitaa.tgnet.TLRPC$TL_pageBlockParagraph;
import ir.eitaa.tgnet.TLRPC$TL_pageListItemText;
import ir.eitaa.tgnet.TLRPC$TL_peerNotifySettings;
import ir.eitaa.tgnet.TLRPC$TL_peerUser;
import ir.eitaa.tgnet.TLRPC$TL_photos_photo;
import ir.eitaa.tgnet.TLRPC$TL_photos_uploadProfilePhoto;
import ir.eitaa.tgnet.TLRPC$TL_userEmpty;
import ir.eitaa.tgnet.TLRPC$TL_userProfilePhoto;
import ir.eitaa.tgnet.TLRPC$TL_userProfilePhotoEmpty;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$UserFull;
import ir.eitaa.tgnet.TLRPC$UserProfilePhoto;
import ir.eitaa.tgnet.TLRPC$UserStatus;
import ir.eitaa.tgnet.TLRPC$VideoSize;
import ir.eitaa.tgnet.TLRPC$WebPage;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.ActionBarLayout;
import ir.eitaa.ui.ActionBar.ActionBarMenu;
import ir.eitaa.ui.ActionBar.ActionBarMenuItem;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BackDrawable;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.SimpleTextView;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Cells.AboutLinkCell;
import ir.eitaa.ui.Cells.DividerCell;
import ir.eitaa.ui.Cells.EmptyCell;
import ir.eitaa.ui.Cells.GraySectionCell;
import ir.eitaa.ui.Cells.HeaderCell;
import ir.eitaa.ui.Cells.NotificationsCheckCell;
import ir.eitaa.ui.Cells.SettingsSearchCell;
import ir.eitaa.ui.Cells.SettingsSuggestionCell;
import ir.eitaa.ui.Cells.ShadowSectionCell;
import ir.eitaa.ui.Cells.TextCell;
import ir.eitaa.ui.Cells.TextDetailCell;
import ir.eitaa.ui.Cells.TextInfoPrivacyCell;
import ir.eitaa.ui.Cells.UserCell;
import ir.eitaa.ui.ChatRightsEditActivity;
import ir.eitaa.ui.Components.AlertsCreator;
import ir.eitaa.ui.Components.AnimatedFileDrawable;
import ir.eitaa.ui.Components.AnimationProperties;
import ir.eitaa.ui.Components.AudioPlayerAlert;
import ir.eitaa.ui.Components.AvatarDrawable;
import ir.eitaa.ui.Components.BackupImageView;
import ir.eitaa.ui.Components.BulletinFactory;
import ir.eitaa.ui.Components.CombinedDrawable;
import ir.eitaa.ui.Components.CrossfadeDrawable;
import ir.eitaa.ui.Components.CubicBezierInterpolator;
import ir.eitaa.ui.Components.FragmentContextView;
import ir.eitaa.ui.Components.IdenticonDrawable;
import ir.eitaa.ui.Components.ImageUpdater;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.ProfileGalleryView;
import ir.eitaa.ui.Components.RLottieDrawable;
import ir.eitaa.ui.Components.RLottieImageView;
import ir.eitaa.ui.Components.RadialProgressView;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.Components.ScamDrawable;
import ir.eitaa.ui.Components.SharedMediaLayout;
import ir.eitaa.ui.Components.SimpleAdsList;
import ir.eitaa.ui.Components.StickerEmptyView;
import ir.eitaa.ui.Components.TimerDrawable;
import ir.eitaa.ui.Components.UndoView;
import ir.eitaa.ui.Components.voip.VoIPHelper;
import ir.eitaa.ui.DialogsActivity;
import ir.eitaa.ui.GroupCreateActivity;
import ir.eitaa.ui.PhotoViewer;
import ir.eitaa.ui.PinchToZoomHelper;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* loaded from: classes3.dex */
public class ProfileActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate, DialogsActivity.DialogsActivityDelegate, SharedMediaLayout.SharedMediaPreloaderDelegate, ImageUpdater.ImageUpdaterDelegate {
    private Property<ActionBar, Float> ACTIONBAR_HEADER_PROGRESS;
    private final Property<ProfileActivity, Float> HEADER_SHADOW;
    private int actionBarAnimationColorFrom;
    private int adRow;
    private int adSectionRow;
    private int addMemberRow;
    private int administratorsRow;
    ArrayList<TLRPC$Ads_Ad> ads;
    String adsTitle;
    private boolean allowProfileAnimation;
    private boolean allowPullingDown;
    private ActionBarMenuItem animatingItem;
    private float animationProgress;
    private TLRPC$FileLocation avatar;
    private AnimatorSet avatarAnimation;
    private TLRPC$FileLocation avatarBig;
    private int avatarColor;
    private FrameLayout avatarContainer;
    private FrameLayout avatarContainer2;
    private AvatarDrawable avatarDrawable;
    private AvatarImageView avatarImage;
    private RadialProgressView avatarProgressView;
    private float avatarScale;
    private float avatarX;
    private float avatarY;
    private ProfileGalleryView avatarsViewPager;
    private PagerIndicatorView avatarsViewPagerIndicatorView;
    private long banFromGroup;
    private int bioRow;
    private int blockedUsersRow;
    private TLRPC$BotInfo botInfo;
    private int bottomPaddingRow;
    private ActionBarMenuItem callItem;
    private boolean callItemVisible;
    private RLottieDrawable cameraDrawable;
    private boolean canSearchMembers;
    private int certRow;
    private int channelInfoRow;
    private long chatId;
    private TLRPC$ChatFull chatInfo;
    private int chatRow;
    private int clearLogsRow;
    private boolean creatingChat;
    private String currentBio;
    private TLRPC$ChannelParticipant currentChannelParticipant;
    private TLRPC$Chat currentChat;
    private TLRPC$EncryptedChat currentEncryptedChat;
    private float currentExpanAnimatorFracture;
    private int dataRow;
    private int debugHeaderRow;
    private int devicesRow;
    private int devicesSectionRow;
    private long dialogId;
    private boolean doNotSetForeground;
    private ActionBarMenuItem editItem;
    private boolean editItemVisible;
    private int emptyRow;
    private int emptyRowChat;
    private StickerEmptyView emptyView;
    private ValueAnimator expandAnimator;
    private float[] expandAnimatorValues;
    private boolean expandPhoto;
    private float expandProgress;
    private float extraHeight;
    private int faqRow;
    private int filtersRow;
    private boolean firstLayout;
    private boolean fragmentOpened;
    private boolean hasAds;
    private boolean hasVoiceChatItem;
    private AnimatorSet headerAnimatorSet;
    protected float headerShadowAlpha;
    private AnimatorSet headerShadowAnimatorSet;
    private int helpHeaderRow;
    private int helpSectionCell;
    private ImageUpdater imageUpdater;
    private int infoHeaderRow;
    private int infoSectionRow;
    private float initialAnimationExtraHeight;
    private boolean invalidateScroll;
    private boolean isBot;
    public boolean isFragmentOpened;
    private boolean isInLandscapeMode;
    private boolean[] isOnline;
    private boolean isPulledDown;
    private int joinRow;
    private int languageRow;
    private int lastMeasuredContentHeight;
    private int lastMeasuredContentWidth;
    private int lastSectionRow;
    private LinearLayoutManager layoutManager;
    private ListAdapter listAdapter;
    private int listContentHeight;
    private RecyclerListView listView;
    private float listViewVelocityY;
    private boolean loadingUsers;
    private int locationRow;
    private Drawable lockIconDrawable;
    private AudioPlayerAlert.ClippingTextViewSwitcher mediaCounterTextView;
    private float mediaHeaderAnimationProgress;
    private boolean mediaHeaderVisible;
    private int membersEndRow;
    private int membersHeaderRow;
    private int membersSectionRow;
    private int membersStartRow;
    private long mergeDialogId;
    private SimpleTextView[] nameTextView;
    private float nameX;
    private float nameY;
    private int navigationBarAnimationColorFrom;
    private boolean needSendMessage;
    private boolean needTimerImage;
    private int notificationRow;
    private int notificationsDividerRow;
    private int notificationsRow;
    private int numberRow;
    private int numberSectionRow;
    private int onlineCount;
    private SimpleTextView[] onlineTextView;
    private float onlineX;
    private float onlineY;
    private boolean openAnimationInProgress;
    private boolean openingAvatar;
    private ActionBarMenuItem otherItem;
    private int overlayCountVisible;
    private OverlaysView overlaysView;
    private LongSparseArray<TLRPC$ChatParticipant> participantsMap;
    private int passwordSuggestionRow;
    private int passwordSuggestionSectionRow;
    private int phoneRow;
    private int phoneSuggestionRow;
    private int phoneSuggestionSectionRow;
    PinchToZoomHelper pinchToZoomHelper;
    private int playProfileAnimation;
    private int policyRow;
    private HashMap<Integer, Integer> positionToOffset;
    private ImageLocation prevLoadedImageLocation;
    private int privacyRow;
    boolean profileTransitionInProgress;
    private PhotoViewer.PhotoViewerProvider provider;
    private int questionRow;
    private boolean recreateMenuAfterAnimation;
    private Rect rect;
    private int reportRow;
    private boolean reportSpam;
    private int rowCount;
    int savedScrollOffset;
    int savedScrollPosition;
    private ScamDrawable scamDrawable;
    private boolean scrolling;
    private SearchAdapter searchAdapter;
    private ActionBarMenuItem searchItem;
    private RecyclerListView searchListView;
    private boolean searchMode;
    private int searchTransitionOffset;
    private float searchTransitionProgress;
    private Animator searchViewTransition;
    private int secretSettingsSectionRow;
    private ArrayList<Long> selectedDialogs;
    private long selectedUser;
    private int sendLastLogsRow;
    private int sendLogsRow;
    private int sendMessageRow;
    private int setAvatarRow;
    private int setAvatarSectionRow;
    private int setUsernameRow;
    private int settingsKeyRow;
    private int settingsSectionRow;
    private int settingsSectionRow2;
    private int settingsTimerRow;
    private SharedMediaLayout sharedMediaLayout;
    private boolean sharedMediaLayoutAttached;
    private SharedMediaLayout.SharedMediaPreloader sharedMediaPreloader;
    private int sharedMediaRow;
    private ArrayList<Integer> sortedUsers;
    private int subscribersRow;
    private int switchBackendRow;
    private ImageView timeItem;
    private TimerDrawable timerDrawable;
    private TopView topView;
    private boolean transitionAnimationInProress;
    private int transitionIndex;
    private View transitionOnlineText;
    private int transportTypeRow;
    private int transportTypeSectionRow;
    private int unblockRow;
    private UndoView undoView;
    private ImageLocation uploadingImageLocation;
    private boolean userBlocked;
    private long userId;
    private TLRPC$UserFull userInfo;
    private int userInfoRow;
    private int usernameRow;
    private boolean usersEndReached;
    private int usersForceShowingIn;
    private Drawable verifiedCheckDrawable;
    private CrossfadeDrawable verifiedCrossfadeDrawable;
    private Drawable verifiedDrawable;
    private int versionRow;
    private ActionBarMenuItem videoCallItem;
    private boolean videoCallItemVisible;
    private int viewParticipantsBannedHelpRow;
    private int viewParticipantsDefaultBannedHelpRow;
    private final ArrayList<TLRPC$ChatParticipant> visibleChatParticipants;
    private final ArrayList<Integer> visibleSortedUsers;
    private Paint whitePaint;
    private RLottieImageView writeButton;
    private AnimatorSet writeButtonAnimation;

    @Override // ir.eitaa.ui.Components.ImageUpdater.ImageUpdaterDelegate
    public /* synthetic */ String getInitialSearchString() {
        return ImageUpdater.ImageUpdaterDelegate.CC.$default$getInitialSearchString(this);
    }

    static /* synthetic */ int access$7912(ProfileActivity profileActivity, int i) {
        int i2 = profileActivity.listContentHeight + i;
        profileActivity.listContentHeight = i2;
        return i2;
    }

    public static class AvatarImageView extends BackupImageView {
        ProfileGalleryView avatarsViewPager;
        private ImageReceiver.BitmapHolder drawableHolder;
        private float foregroundAlpha;
        private ImageReceiver foregroundImageReceiver;
        private final Paint placeholderPaint;
        private final RectF rect;

        public void setAvatarsViewPager(ProfileGalleryView avatarsViewPager) {
            this.avatarsViewPager = avatarsViewPager;
        }

        public AvatarImageView(Context context) {
            super(context);
            this.rect = new RectF();
            this.foregroundImageReceiver = new ImageReceiver(this);
            Paint paint = new Paint(1);
            this.placeholderPaint = paint;
            paint.setColor(-16777216);
        }

        public void setForegroundImage(ImageLocation imageLocation, String imageFilter, Drawable thumb) {
            this.foregroundImageReceiver.setImage(imageLocation, imageFilter, thumb, 0, (String) null, (Object) null, 0);
            ImageReceiver.BitmapHolder bitmapHolder = this.drawableHolder;
            if (bitmapHolder != null) {
                bitmapHolder.release();
                this.drawableHolder = null;
            }
        }

        public void setForegroundImageDrawable(ImageReceiver.BitmapHolder holder) {
            if (holder != null) {
                this.foregroundImageReceiver.setImageBitmap(holder.drawable);
            }
            ImageReceiver.BitmapHolder bitmapHolder = this.drawableHolder;
            if (bitmapHolder != null) {
                bitmapHolder.release();
                this.drawableHolder = null;
            }
            this.drawableHolder = holder;
        }

        public float getForegroundAlpha() {
            return this.foregroundAlpha;
        }

        public void setForegroundAlpha(float value) {
            this.foregroundAlpha = value;
            invalidate();
        }

        public void clearForeground() {
            AnimatedFileDrawable animation = this.foregroundImageReceiver.getAnimation();
            if (animation != null) {
                animation.removeSecondParentView(this);
            }
            this.foregroundImageReceiver.clearImage();
            ImageReceiver.BitmapHolder bitmapHolder = this.drawableHolder;
            if (bitmapHolder != null) {
                bitmapHolder.release();
                this.drawableHolder = null;
            }
            this.foregroundAlpha = 0.0f;
            invalidate();
        }

        @Override // ir.eitaa.ui.Components.BackupImageView, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            this.foregroundImageReceiver.onDetachedFromWindow();
            ImageReceiver.BitmapHolder bitmapHolder = this.drawableHolder;
            if (bitmapHolder != null) {
                bitmapHolder.release();
                this.drawableHolder = null;
            }
        }

        @Override // ir.eitaa.ui.Components.BackupImageView, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            this.foregroundImageReceiver.onAttachedToWindow();
        }

        @Override // ir.eitaa.ui.Components.BackupImageView
        public void setRoundRadius(int value) {
            super.setRoundRadius(value);
            this.foregroundImageReceiver.setRoundRadius(value);
        }

        @Override // ir.eitaa.ui.Components.BackupImageView, android.view.View
        protected void onDraw(Canvas canvas) {
            if (this.foregroundAlpha < 1.0f) {
                this.imageReceiver.setImageCoords(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
                this.imageReceiver.draw(canvas);
            }
            if (this.foregroundAlpha > 0.0f) {
                if (this.foregroundImageReceiver.getDrawable() != null) {
                    this.foregroundImageReceiver.setImageCoords(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
                    this.foregroundImageReceiver.setAlpha(this.foregroundAlpha);
                    this.foregroundImageReceiver.draw(canvas);
                } else {
                    this.rect.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
                    this.placeholderPaint.setAlpha((int) (this.foregroundAlpha * 255.0f));
                    float f = this.foregroundImageReceiver.getRoundRadius()[0];
                    canvas.drawRoundRect(this.rect, f, f, this.placeholderPaint);
                }
            }
        }

        @Override // android.view.View
        public void invalidate() {
            super.invalidate();
            ProfileGalleryView profileGalleryView = this.avatarsViewPager;
            if (profileGalleryView != null) {
                profileGalleryView.invalidate();
            }
        }
    }

    private class TopView extends View {
        private int currentColor;
        private Paint paint;

        public TopView(Context context) {
            super(context);
            this.paint = new Paint();
        }

        @Override // android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), View.MeasureSpec.getSize(widthMeasureSpec) + AndroidUtilities.dp(3.0f));
        }

        @Override // android.view.View
        public void setBackgroundColor(int color) {
            if (color != this.currentColor) {
                this.currentColor = color;
                this.paint.setColor(color);
                invalidate();
            }
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            float currentActionBarHeight = ProfileActivity.this.extraHeight + ActionBar.getCurrentActionBarHeight() + (((BaseFragment) ProfileActivity.this).actionBar.getOccupyStatusBar() ? AndroidUtilities.statusBarHeight : 0) + ProfileActivity.this.searchTransitionOffset;
            int i = (int) ((1.0f - ProfileActivity.this.mediaHeaderAnimationProgress) * currentActionBarHeight);
            if (i != 0) {
                this.paint.setColor(this.currentColor);
                canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), i, this.paint);
            }
            float f = i;
            if (f != currentActionBarHeight) {
                this.paint.setColor(Theme.getColor("windowBackgroundWhite"));
                canvas.drawRect(0.0f, f, getMeasuredWidth(), currentActionBarHeight, this.paint);
            }
            if (((BaseFragment) ProfileActivity.this).parentLayout != null) {
                ((BaseFragment) ProfileActivity.this).parentLayout.drawHeaderShadow(canvas, (int) (ProfileActivity.this.headerShadowAlpha * 255.0f), (int) currentActionBarHeight);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class OverlaysView extends View implements ProfileGalleryView.Callback {
        private float alpha;
        private float[] alphas;
        private final ValueAnimator animator;
        private final float[] animatorValues;
        private final Paint backgroundPaint;
        private final Paint barPaint;
        private final GradientDrawable bottomOverlayGradient;
        private final Rect bottomOverlayRect;
        private float currentAnimationValue;
        private int currentLoadingAnimationDirection;
        private float currentLoadingAnimationProgress;
        private float currentProgress;
        private boolean isOverlaysVisible;
        private long lastTime;
        private final float[] pressedOverlayAlpha;
        private final GradientDrawable[] pressedOverlayGradient;
        private final boolean[] pressedOverlayVisible;
        private int previousSelectedPotision;
        private float previousSelectedProgress;
        private final RectF rect;
        private final Paint selectedBarPaint;
        private int selectedPosition;
        private final int statusBarHeight;
        private final GradientDrawable topOverlayGradient;
        private final Rect topOverlayRect;

        public OverlaysView(Context context) {
            super(context);
            this.statusBarHeight = (!((BaseFragment) ProfileActivity.this).actionBar.getOccupyStatusBar() || ((BaseFragment) ProfileActivity.this).inBubbleMode) ? 0 : AndroidUtilities.statusBarHeight;
            this.topOverlayRect = new Rect();
            this.bottomOverlayRect = new Rect();
            this.rect = new RectF();
            this.animatorValues = new float[]{0.0f, 1.0f};
            this.pressedOverlayGradient = new GradientDrawable[2];
            this.pressedOverlayVisible = new boolean[2];
            this.pressedOverlayAlpha = new float[2];
            this.alpha = 0.0f;
            this.alphas = null;
            this.previousSelectedPotision = -1;
            this.currentLoadingAnimationDirection = 1;
            setVisibility(8);
            Paint paint = new Paint(1);
            this.barPaint = paint;
            paint.setColor(1442840575);
            Paint paint2 = new Paint(1);
            this.selectedBarPaint = paint2;
            paint2.setColor(-1);
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{1107296256, 0});
            this.topOverlayGradient = gradientDrawable;
            gradientDrawable.setShape(0);
            GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{1107296256, 0});
            this.bottomOverlayGradient = gradientDrawable2;
            gradientDrawable2.setShape(0);
            int i = 0;
            while (i < 2) {
                this.pressedOverlayGradient[i] = new GradientDrawable(i == 0 ? GradientDrawable.Orientation.LEFT_RIGHT : GradientDrawable.Orientation.RIGHT_LEFT, new int[]{838860800, 0});
                this.pressedOverlayGradient[i].setShape(0);
                i++;
            }
            Paint paint3 = new Paint(1);
            this.backgroundPaint = paint3;
            paint3.setColor(-16777216);
            paint3.setAlpha(66);
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.animator = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration(250L);
            valueAnimatorOfFloat.setInterpolator(CubicBezierInterpolator.EASE_BOTH);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$OverlaysView$-fU83Bqs_8hUSzmBXeiisplo88c
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f$0.lambda$new$0$ProfileActivity$OverlaysView(valueAnimator);
                }
            });
            valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.ProfileActivity.OverlaysView.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    if (OverlaysView.this.isOverlaysVisible) {
                        return;
                    }
                    OverlaysView.this.setVisibility(8);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                    OverlaysView.this.setVisibility(0);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$0$ProfileActivity$OverlaysView(ValueAnimator valueAnimator) {
            float[] fArr = this.animatorValues;
            float animatedFraction = valueAnimator.getAnimatedFraction();
            this.currentAnimationValue = animatedFraction;
            setAlphaValue(AndroidUtilities.lerp(fArr, animatedFraction), true);
        }

        public void saveCurrentPageProgress() {
            this.previousSelectedProgress = this.currentProgress;
            this.previousSelectedPotision = this.selectedPosition;
            this.currentLoadingAnimationProgress = 0.0f;
            this.currentLoadingAnimationDirection = 1;
        }

        public void setAlphaValue(float value, boolean self) {
            if (Build.VERSION.SDK_INT > 18) {
                int i = (int) (255.0f * value);
                this.topOverlayGradient.setAlpha(i);
                this.bottomOverlayGradient.setAlpha(i);
                this.backgroundPaint.setAlpha((int) (66.0f * value));
                this.barPaint.setAlpha((int) (85.0f * value));
                this.selectedBarPaint.setAlpha(i);
                this.alpha = value;
            } else {
                setAlpha(value);
            }
            if (!self) {
                this.currentAnimationValue = value;
            }
            invalidate();
        }

        public boolean isOverlaysVisible() {
            return this.isOverlaysVisible;
        }

        public void setOverlaysVisible() {
            this.isOverlaysVisible = true;
            setVisibility(0);
        }

        public void setOverlaysVisible(boolean overlaysVisible, float durationFactor) {
            if (overlaysVisible != this.isOverlaysVisible) {
                this.isOverlaysVisible = overlaysVisible;
                this.animator.cancel();
                float fLerp = AndroidUtilities.lerp(this.animatorValues, this.currentAnimationValue);
                if (overlaysVisible) {
                    this.animator.setDuration((long) (((1.0f - fLerp) * 250.0f) / durationFactor));
                } else {
                    this.animator.setDuration((long) ((250.0f * fLerp) / durationFactor));
                }
                float[] fArr = this.animatorValues;
                fArr[0] = fLerp;
                fArr[1] = overlaysVisible ? 1.0f : 0.0f;
                this.animator.start();
            }
        }

        @Override // android.view.View
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            int currentActionBarHeight = this.statusBarHeight + ActionBar.getCurrentActionBarHeight();
            this.topOverlayRect.set(0, 0, w, (int) (currentActionBarHeight * 0.5f));
            this.bottomOverlayRect.set(0, (int) (h - (AndroidUtilities.dp(72.0f) * 0.5f)), w, h);
            this.topOverlayGradient.setBounds(0, this.topOverlayRect.bottom, w, currentActionBarHeight + AndroidUtilities.dp(16.0f));
            this.bottomOverlayGradient.setBounds(0, (h - AndroidUtilities.dp(72.0f)) - AndroidUtilities.dp(24.0f), w, this.bottomOverlayRect.top);
            int i = w / 5;
            this.pressedOverlayGradient[0].setBounds(0, 0, i, h);
            this.pressedOverlayGradient[1].setBounds(w - i, 0, w, h);
        }

        /* JADX WARN: Removed duplicated region for block: B:70:0x0222  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x024a  */
        /* JADX WARN: Removed duplicated region for block: B:77:0x0264  */
        /* JADX WARN: Removed duplicated region for block: B:78:0x0267  */
        @Override // android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected void onDraw(android.graphics.Canvas r22) {
            /*
                Method dump skipped, instructions count: 816
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ProfileActivity.OverlaysView.onDraw(android.graphics.Canvas):void");
        }

        @Override // ir.eitaa.ui.Components.ProfileGalleryView.Callback
        public void onDown(boolean z) {
            this.pressedOverlayVisible[!z ? 1 : 0] = true;
            postInvalidateOnAnimation();
        }

        @Override // ir.eitaa.ui.Components.ProfileGalleryView.Callback
        public void onRelease() {
            Arrays.fill(this.pressedOverlayVisible, false);
            postInvalidateOnAnimation();
        }

        @Override // ir.eitaa.ui.Components.ProfileGalleryView.Callback
        public void onPhotosLoaded() {
            ProfileActivity.this.updateProfileData();
        }

        @Override // ir.eitaa.ui.Components.ProfileGalleryView.Callback
        public void onVideoSet() {
            invalidate();
        }
    }

    private class NestedFrameLayout extends FrameLayout implements NestedScrollingParent3 {
        private NestedScrollingParentHelper nestedScrollingParentHelper;

        @Override // androidx.core.view.NestedScrollingParent2
        public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        }

        @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
        public void onStopNestedScroll(View child) {
        }

        public NestedFrameLayout(Context context) {
            super(context);
            this.nestedScrollingParentHelper = new NestedScrollingParentHelper(this);
        }

        @Override // androidx.core.view.NestedScrollingParent3
        public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type, int[] consumed) {
            if (target == ProfileActivity.this.listView && ProfileActivity.this.sharedMediaLayoutAttached) {
                RecyclerListView currentListView = ProfileActivity.this.sharedMediaLayout.getCurrentListView();
                if (ProfileActivity.this.sharedMediaLayout.getTop() == 0) {
                    consumed[1] = dyUnconsumed;
                    currentListView.scrollBy(0, dyUnconsumed);
                }
            }
        }

        @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
        public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
            return super.onNestedPreFling(target, velocityX, velocityY);
        }

        @Override // androidx.core.view.NestedScrollingParent2
        public void onNestedPreScroll(View target, int dx, int dy, int[] consumed, int type) {
            if (target == ProfileActivity.this.listView) {
                if (ProfileActivity.this.sharedMediaRow == -1 || !ProfileActivity.this.sharedMediaLayoutAttached) {
                    return;
                }
                boolean zIsSearchFieldVisible = ((BaseFragment) ProfileActivity.this).actionBar.isSearchFieldVisible();
                int top = ProfileActivity.this.sharedMediaLayout.getTop();
                boolean z = false;
                if (dy >= 0) {
                    if (zIsSearchFieldVisible) {
                        RecyclerListView currentListView = ProfileActivity.this.sharedMediaLayout.getCurrentListView();
                        consumed[1] = dy;
                        if (top > 0) {
                            consumed[1] = consumed[1] - dy;
                        }
                        if (consumed[1] > 0) {
                            currentListView.scrollBy(0, consumed[1]);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (top <= 0) {
                    RecyclerListView currentListView2 = ProfileActivity.this.sharedMediaLayout.getCurrentListView();
                    int iFindFirstVisibleItemPosition = ((LinearLayoutManager) currentListView2.getLayoutManager()).findFirstVisibleItemPosition();
                    if (iFindFirstVisibleItemPosition != -1) {
                        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = currentListView2.findViewHolderForAdapterPosition(iFindFirstVisibleItemPosition);
                        int top2 = viewHolderFindViewHolderForAdapterPosition != null ? viewHolderFindViewHolderForAdapterPosition.itemView.getTop() : -1;
                        int paddingTop = currentListView2.getPaddingTop();
                        if (top2 != paddingTop || iFindFirstVisibleItemPosition != 0) {
                            consumed[1] = iFindFirstVisibleItemPosition != 0 ? dy : Math.max(dy, top2 - paddingTop);
                            currentListView2.scrollBy(0, dy);
                            z = true;
                        }
                    }
                }
                if (zIsSearchFieldVisible) {
                    if (!z && top < 0) {
                        consumed[1] = dy - Math.max(top, dy);
                    } else {
                        consumed[1] = dy;
                    }
                }
            }
        }

        @Override // androidx.core.view.NestedScrollingParent2
        public boolean onStartNestedScroll(View child, View target, int axes, int type) {
            return ProfileActivity.this.sharedMediaRow != -1 && axes == 2;
        }

        @Override // androidx.core.view.NestedScrollingParent2
        public void onNestedScrollAccepted(View child, View target, int axes, int type) {
            this.nestedScrollingParentHelper.onNestedScrollAccepted(child, target, axes);
        }

        @Override // androidx.core.view.NestedScrollingParent2
        public void onStopNestedScroll(View target, int type) {
            this.nestedScrollingParentHelper.onStopNestedScroll(target);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class PagerIndicatorView extends View {
        private final PagerAdapter adapter;
        private final ValueAnimator animator;
        private final float[] animatorValues;
        private final Paint backgroundPaint;
        private final RectF indicatorRect;
        private boolean isIndicatorVisible;
        private final TextPaint textPaint;

        public PagerIndicatorView(Context context) {
            super(context);
            this.indicatorRect = new RectF();
            this.animatorValues = new float[]{0.0f, 1.0f};
            PagerAdapter adapter = ProfileActivity.this.avatarsViewPager.getAdapter();
            this.adapter = adapter;
            setVisibility(8);
            TextPaint textPaint = new TextPaint(1);
            this.textPaint = textPaint;
            textPaint.setColor(-1);
            textPaint.setTypeface(AndroidUtilities.getFontFamily(false));
            textPaint.setTextAlign(Paint.Align.CENTER);
            textPaint.setTextSize(AndroidUtilities.dpf2(15.0f));
            Paint paint = new Paint(1);
            this.backgroundPaint = paint;
            paint.setColor(637534208);
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.animator = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setInterpolator(CubicBezierInterpolator.EASE_BOTH);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$PagerIndicatorView$Fma-72cJQDPexCEO9knBUMs6esY
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f$0.lambda$new$0$ProfileActivity$PagerIndicatorView(valueAnimator);
                }
            });
            final boolean z = ProfileActivity.this.expandPhoto;
            valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.ProfileActivity.PagerIndicatorView.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    if (PagerIndicatorView.this.isIndicatorVisible) {
                        if (ProfileActivity.this.searchItem != null) {
                            ProfileActivity.this.searchItem.setVisibility(8);
                        }
                        if (ProfileActivity.this.editItemVisible) {
                            ProfileActivity.this.editItem.setVisibility(8);
                        }
                        if (ProfileActivity.this.callItemVisible) {
                            ProfileActivity.this.callItem.setVisibility(8);
                        }
                        if (ProfileActivity.this.videoCallItemVisible) {
                            ProfileActivity.this.videoCallItem.setVisibility(8);
                            return;
                        }
                        return;
                    }
                    PagerIndicatorView.this.setVisibility(8);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                    if (ProfileActivity.this.searchItem != null && !z) {
                        ProfileActivity.this.searchItem.setVisibility(0);
                    }
                    if (ProfileActivity.this.editItemVisible) {
                        ProfileActivity.this.editItem.setVisibility(0);
                    }
                    if (ProfileActivity.this.callItemVisible) {
                        ProfileActivity.this.callItem.setVisibility(0);
                    }
                    if (ProfileActivity.this.videoCallItemVisible) {
                        ProfileActivity.this.videoCallItem.setVisibility(0);
                    }
                    PagerIndicatorView.this.setVisibility(0);
                }
            });
            ProfileActivity.this.avatarsViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: ir.eitaa.ui.ProfileActivity.PagerIndicatorView.2
                private int prevPage;

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int state) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int position) {
                    int realPosition = ProfileActivity.this.avatarsViewPager.getRealPosition(position);
                    PagerIndicatorView.this.invalidateIndicatorRect(this.prevPage != realPosition);
                    this.prevPage = realPosition;
                    PagerIndicatorView.this.updateAvatarItems();
                }
            });
            adapter.registerDataSetObserver(new DataSetObserver() { // from class: ir.eitaa.ui.ProfileActivity.PagerIndicatorView.3
                @Override // android.database.DataSetObserver
                public void onChanged() {
                    int realCount = ProfileActivity.this.avatarsViewPager.getRealCount();
                    if (ProfileActivity.this.overlayCountVisible == 0 && realCount > 1 && realCount <= 20 && ProfileActivity.this.overlaysView.isOverlaysVisible()) {
                        ProfileActivity.this.overlayCountVisible = 1;
                    }
                    PagerIndicatorView.this.invalidateIndicatorRect(false);
                    PagerIndicatorView.this.refreshVisibility(1.0f);
                    PagerIndicatorView.this.updateAvatarItems();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$0$ProfileActivity$PagerIndicatorView(ValueAnimator valueAnimator) {
            float fLerp = AndroidUtilities.lerp(this.animatorValues, valueAnimator.getAnimatedFraction());
            if (ProfileActivity.this.searchItem != null && !ProfileActivity.this.isPulledDown) {
                float f = 1.0f - fLerp;
                ProfileActivity.this.searchItem.setScaleX(f);
                ProfileActivity.this.searchItem.setScaleY(f);
                ProfileActivity.this.searchItem.setAlpha(f);
            }
            if (ProfileActivity.this.editItemVisible) {
                float f2 = 1.0f - fLerp;
                ProfileActivity.this.editItem.setScaleX(f2);
                ProfileActivity.this.editItem.setScaleY(f2);
                ProfileActivity.this.editItem.setAlpha(f2);
            }
            if (ProfileActivity.this.callItemVisible) {
                float f3 = 1.0f - fLerp;
                ProfileActivity.this.callItem.setScaleX(f3);
                ProfileActivity.this.callItem.setScaleY(f3);
                ProfileActivity.this.callItem.setAlpha(f3);
            }
            if (ProfileActivity.this.videoCallItemVisible) {
                float f4 = 1.0f - fLerp;
                ProfileActivity.this.videoCallItem.setScaleX(f4);
                ProfileActivity.this.videoCallItem.setScaleY(f4);
                ProfileActivity.this.videoCallItem.setAlpha(f4);
            }
            setScaleX(fLerp);
            setScaleY(fLerp);
            setAlpha(fLerp);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateAvatarItemsInternal() {
            if (ProfileActivity.this.otherItem == null || ProfileActivity.this.avatarsViewPager == null || !ProfileActivity.this.isPulledDown) {
                return;
            }
            if (ProfileActivity.this.avatarsViewPager.getRealPosition() == 0) {
                ProfileActivity.this.otherItem.showSubItem(36);
            } else {
                ProfileActivity.this.otherItem.hideSubItem(36);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateAvatarItems() {
            if (ProfileActivity.this.imageUpdater == null) {
                return;
            }
            if (ProfileActivity.this.otherItem.isSubMenuShowing()) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$PagerIndicatorView$nof-UyZ-KqLmTUMu3Q00DXvVCXc
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.updateAvatarItemsInternal();
                    }
                }, 500L);
            } else {
                updateAvatarItemsInternal();
            }
        }

        public boolean isIndicatorFullyVisible() {
            return this.isIndicatorVisible && !this.animator.isRunning();
        }

        public void setIndicatorVisible(boolean indicatorVisible, float durationFactor) {
            if (indicatorVisible != this.isIndicatorVisible) {
                this.isIndicatorVisible = indicatorVisible;
                this.animator.cancel();
                float fLerp = AndroidUtilities.lerp(this.animatorValues, this.animator.getAnimatedFraction());
                if (durationFactor <= 0.0f) {
                    this.animator.setDuration(0L);
                } else if (indicatorVisible) {
                    this.animator.setDuration((long) (((1.0f - fLerp) * 250.0f) / durationFactor));
                } else {
                    this.animator.setDuration((long) ((250.0f * fLerp) / durationFactor));
                }
                float[] fArr = this.animatorValues;
                fArr[0] = fLerp;
                fArr[1] = indicatorVisible ? 1.0f : 0.0f;
                this.animator.start();
            }
        }

        public void refreshVisibility(float durationFactor) {
            setIndicatorVisible(ProfileActivity.this.isPulledDown && ProfileActivity.this.avatarsViewPager.getRealCount() > 20, durationFactor);
        }

        @Override // android.view.View
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            invalidateIndicatorRect(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void invalidateIndicatorRect(boolean pageChanged) {
            if (pageChanged) {
                ProfileActivity.this.overlaysView.saveCurrentPageProgress();
            }
            ProfileActivity.this.overlaysView.invalidate();
            float fMeasureText = this.textPaint.measureText(getCurrentTitle());
            this.indicatorRect.right = getMeasuredWidth() - AndroidUtilities.dp(54.0f);
            RectF rectF = this.indicatorRect;
            rectF.left = rectF.right - (fMeasureText + AndroidUtilities.dpf2(16.0f));
            this.indicatorRect.top = (((BaseFragment) ProfileActivity.this).actionBar.getOccupyStatusBar() ? AndroidUtilities.statusBarHeight : 0) + AndroidUtilities.dp(15.0f);
            RectF rectF2 = this.indicatorRect;
            rectF2.bottom = rectF2.top + AndroidUtilities.dp(26.0f);
            setPivotX(this.indicatorRect.centerX());
            setPivotY(this.indicatorRect.centerY());
            invalidate();
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            float fDpf2 = AndroidUtilities.dpf2(12.0f);
            canvas.drawRoundRect(this.indicatorRect, fDpf2, fDpf2, this.backgroundPaint);
            canvas.drawText(getCurrentTitle(), this.indicatorRect.centerX(), this.indicatorRect.top + AndroidUtilities.dpf2(18.5f), this.textPaint);
        }

        private String getCurrentTitle() {
            return this.adapter.getPageTitle(ProfileActivity.this.avatarsViewPager.getCurrentItem()).toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ActionBarMenuItem getSecondaryMenuItem() {
            if (ProfileActivity.this.callItemVisible) {
                return ProfileActivity.this.callItem;
            }
            if (ProfileActivity.this.editItemVisible) {
                return ProfileActivity.this.editItem;
            }
            if (ProfileActivity.this.searchItem != null) {
                return ProfileActivity.this.searchItem;
            }
            return null;
        }
    }

    public ProfileActivity(Bundle args) {
        this(args, null);
    }

    public ProfileActivity(Bundle args, SharedMediaLayout.SharedMediaPreloader preloader) {
        super(args);
        this.nameTextView = new SimpleTextView[2];
        this.onlineTextView = new SimpleTextView[2];
        this.isOnline = new boolean[1];
        this.headerShadowAlpha = 1.0f;
        this.selectedDialogs = new ArrayList<>();
        this.participantsMap = new LongSparseArray<>();
        this.allowProfileAnimation = true;
        this.positionToOffset = new HashMap<>();
        this.expandAnimatorValues = new float[]{0.0f, 1.0f};
        this.whitePaint = new Paint();
        this.onlineCount = -1;
        this.rect = new Rect();
        this.visibleChatParticipants = new ArrayList<>();
        this.visibleSortedUsers = new ArrayList<>();
        this.usersForceShowingIn = 0;
        this.firstLayout = true;
        this.invalidateScroll = true;
        this.actionBarAnimationColorFrom = 0;
        this.navigationBarAnimationColorFrom = 0;
        this.HEADER_SHADOW = new AnimationProperties.FloatProperty<ProfileActivity>("headerShadow") { // from class: ir.eitaa.ui.ProfileActivity.1
            @Override // ir.eitaa.ui.Components.AnimationProperties.FloatProperty
            public void setValue(ProfileActivity object, float value) {
                ProfileActivity profileActivity = ProfileActivity.this;
                profileActivity.headerShadowAlpha = value;
                profileActivity.topView.invalidate();
            }

            @Override // android.util.Property
            public Float get(ProfileActivity object) {
                return Float.valueOf(ProfileActivity.this.headerShadowAlpha);
            }
        };
        this.provider = new PhotoViewer.EmptyPhotoViewerProvider() { // from class: ir.eitaa.ui.ProfileActivity.2
            @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
            public PhotoViewer.PlaceProviderObject getPlaceForPhoto(MessageObject messageObject, TLRPC$FileLocation fileLocation, int index, boolean needPreview) {
                TLRPC$Chat chat;
                TLRPC$ChatPhoto tLRPC$ChatPhoto;
                TLRPC$FileLocation tLRPC$FileLocation;
                TLRPC$User user;
                TLRPC$UserProfilePhoto tLRPC$UserProfilePhoto;
                if (fileLocation == null) {
                    return null;
                }
                if (ProfileActivity.this.userId == 0 ? ProfileActivity.this.chatId == 0 || (chat = ProfileActivity.this.getMessagesController().getChat(Long.valueOf(ProfileActivity.this.chatId))) == null || (tLRPC$ChatPhoto = chat.photo) == null || (tLRPC$FileLocation = tLRPC$ChatPhoto.photo_big) == null : (user = ProfileActivity.this.getMessagesController().getUser(Long.valueOf(ProfileActivity.this.userId))) == null || (tLRPC$UserProfilePhoto = user.photo) == null || (tLRPC$FileLocation = tLRPC$UserProfilePhoto.photo_big) == null) {
                    tLRPC$FileLocation = null;
                }
                if (tLRPC$FileLocation == null || tLRPC$FileLocation.local_id != fileLocation.local_id || tLRPC$FileLocation.volume_id != fileLocation.volume_id || tLRPC$FileLocation.dc_id != fileLocation.dc_id) {
                    return null;
                }
                int[] iArr = new int[2];
                ProfileActivity.this.avatarImage.getLocationInWindow(iArr);
                PhotoViewer.PlaceProviderObject placeProviderObject = new PhotoViewer.PlaceProviderObject();
                placeProviderObject.viewX = iArr[0];
                placeProviderObject.viewY = iArr[1] - (Build.VERSION.SDK_INT >= 21 ? 0 : AndroidUtilities.statusBarHeight);
                placeProviderObject.parentView = ProfileActivity.this.avatarImage;
                placeProviderObject.imageReceiver = ProfileActivity.this.avatarImage.getImageReceiver();
                if (ProfileActivity.this.userId != 0) {
                    placeProviderObject.dialogId = ProfileActivity.this.userId;
                } else if (ProfileActivity.this.chatId != 0) {
                    placeProviderObject.dialogId = -ProfileActivity.this.chatId;
                }
                placeProviderObject.thumb = placeProviderObject.imageReceiver.getBitmapSafe();
                placeProviderObject.size = -1;
                placeProviderObject.radius = ProfileActivity.this.avatarImage.getImageReceiver().getRoundRadius();
                placeProviderObject.scale = ProfileActivity.this.avatarContainer.getScaleX();
                placeProviderObject.canEdit = ProfileActivity.this.userId == ProfileActivity.this.getUserConfig().clientUserId;
                return placeProviderObject;
            }

            @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
            public void willHidePhotoViewer() {
                ProfileActivity.this.avatarImage.getImageReceiver().setVisible(true, true);
            }

            @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
            public void openPhotoForEdit(String file, String thumb, boolean isVideo) throws InterruptedException, Resources.NotFoundException {
                ProfileActivity.this.imageUpdater.openPhotoForEdit(file, thumb, 0, isVideo);
            }
        };
        this.ACTIONBAR_HEADER_PROGRESS = new AnimationProperties.FloatProperty<ActionBar>("animationProgress") { // from class: ir.eitaa.ui.ProfileActivity.25
            @Override // ir.eitaa.ui.Components.AnimationProperties.FloatProperty
            public void setValue(ActionBar object, float value) {
                ProfileActivity.this.mediaHeaderAnimationProgress = value;
                ProfileActivity.this.topView.invalidate();
                int color = Theme.getColor("profile_title");
                int color2 = Theme.getColor("player_actionBarTitle");
                int offsetColor = AndroidUtilities.getOffsetColor(color, color2, value, 1.0f);
                ProfileActivity.this.nameTextView[1].setTextColor(offsetColor);
                if (ProfileActivity.this.lockIconDrawable != null) {
                    ProfileActivity.this.lockIconDrawable.setColorFilter(offsetColor, PorterDuff.Mode.MULTIPLY);
                }
                if (ProfileActivity.this.scamDrawable != null) {
                    ProfileActivity.this.scamDrawable.setColor(AndroidUtilities.getOffsetColor(Theme.getColor("avatar_subtitleInProfileBlue"), color2, value, 1.0f));
                }
                ((BaseFragment) ProfileActivity.this).actionBar.setItemsColor(AndroidUtilities.getOffsetColor(Theme.getColor("actionBarDefaultIcon"), Theme.getColor("windowBackgroundWhiteGrayText2"), value, 1.0f), false);
                ((BaseFragment) ProfileActivity.this).actionBar.setItemsBackgroundColor(AndroidUtilities.getOffsetColor(Theme.getColor("avatar_actionBarSelectorBlue"), Theme.getColor("actionBarActionModeDefaultSelector"), value, 1.0f), false);
                ProfileActivity.this.topView.invalidate();
                ProfileActivity.this.otherItem.setIconColor(Theme.getColor("actionBarDefaultIcon"));
                ProfileActivity.this.callItem.setIconColor(Theme.getColor("actionBarDefaultIcon"));
                ProfileActivity.this.videoCallItem.setIconColor(Theme.getColor("actionBarDefaultIcon"));
                ProfileActivity.this.editItem.setIconColor(Theme.getColor("actionBarDefaultIcon"));
                if (ProfileActivity.this.verifiedDrawable != null) {
                    ProfileActivity.this.verifiedDrawable.setColorFilter(AndroidUtilities.getOffsetColor(Theme.getColor("profile_verifiedBackground"), Theme.getColor("player_actionBarTitle"), value, 1.0f), PorterDuff.Mode.MULTIPLY);
                }
                if (ProfileActivity.this.verifiedCheckDrawable != null) {
                    ProfileActivity.this.verifiedCheckDrawable.setColorFilter(AndroidUtilities.getOffsetColor(Theme.getColor("profile_verifiedCheck"), Theme.getColor("windowBackgroundWhite"), value, 1.0f), PorterDuff.Mode.MULTIPLY);
                }
                if (ProfileActivity.this.avatarsViewPagerIndicatorView.getSecondaryMenuItem() != null) {
                    if (ProfileActivity.this.videoCallItemVisible || ProfileActivity.this.editItemVisible || ProfileActivity.this.callItemVisible) {
                        ProfileActivity profileActivity = ProfileActivity.this;
                        profileActivity.needLayoutText(Math.min(1.0f, profileActivity.extraHeight / AndroidUtilities.dp(88.0f)));
                    }
                }
            }

            @Override // android.util.Property
            public Float get(ActionBar object) {
                return Float.valueOf(ProfileActivity.this.mediaHeaderAnimationProgress);
            }
        };
        this.savedScrollPosition = -1;
        this.sharedMediaPreloader = preloader;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() throws InterruptedException {
        this.userId = this.arguments.getLong("user_id", 0L);
        long j = this.arguments.getLong("chat_id", 0L);
        this.chatId = j;
        ArrayList<Long> arrayList = this.selectedDialogs;
        long j2 = this.userId;
        if (j2 == 0) {
            j2 = -j;
        }
        arrayList.add(Long.valueOf(j2));
        this.banFromGroup = this.arguments.getLong("ban_chat_id", 0L);
        this.reportSpam = this.arguments.getBoolean("reportSpam", false);
        if (!this.expandPhoto) {
            boolean z = this.arguments.getBoolean("expandPhoto", false);
            this.expandPhoto = z;
            if (z) {
                this.needSendMessage = true;
            }
        }
        if (this.userId != 0) {
            long j3 = this.arguments.getLong("dialog_id", 0L);
            this.dialogId = j3;
            if (j3 != 0) {
                this.currentEncryptedChat = getMessagesController().getEncryptedChat(Integer.valueOf(DialogObject.getEncryptedChatId(this.dialogId)));
            }
            TLRPC$User user = getMessagesController().getUser(Long.valueOf(this.userId));
            if (user == null) {
                return false;
            }
            getNotificationCenter().addObserver(this, NotificationCenter.contactsDidLoad);
            getNotificationCenter().addObserver(this, NotificationCenter.newSuggestionsAvailable);
            getNotificationCenter().addObserver(this, NotificationCenter.encryptedChatCreated);
            getNotificationCenter().addObserver(this, NotificationCenter.encryptedChatUpdated);
            getNotificationCenter().addObserver(this, NotificationCenter.blockedUsersDidLoad);
            getNotificationCenter().addObserver(this, NotificationCenter.botInfoDidLoad);
            getNotificationCenter().addObserver(this, NotificationCenter.userInfoDidLoad);
            NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.reloadInterface);
            this.userBlocked = getMessagesController().blockePeers.indexOfKey(this.userId) >= 0;
            if (user.bot) {
                this.isBot = true;
                MediaDataController mediaDataController = getMediaDataController();
                long j4 = user.id;
                mediaDataController.loadBotInfo(j4, j4, true, this.classGuid);
            }
            this.userInfo = getMessagesController().getUserFull(this.userId);
            getMessagesController().loadFullUser(getMessagesController().getUser(Long.valueOf(this.userId)), this.classGuid, true);
            this.participantsMap = null;
            if (UserObject.isUserSelf(user)) {
                ImageUpdater imageUpdater = new ImageUpdater(true);
                this.imageUpdater = imageUpdater;
                imageUpdater.setOpenWithFrontfaceCamera(true);
                ImageUpdater imageUpdater2 = this.imageUpdater;
                imageUpdater2.parentFragment = this;
                imageUpdater2.setDelegate(this);
                getMediaDataController().checkFeaturedStickers();
                getMessagesController().loadSuggestedFilters();
                getMessagesController().loadUserInfo(getUserConfig().getCurrentUser(), true, this.classGuid);
                UserConfig.getInstance(UserConfig.selectedAccount).setMxbState(getMessagesController().getUser(Long.valueOf(this.userId)).MXB_REGISTERED_USER);
            }
            this.actionBarAnimationColorFrom = this.arguments.getInt("actionBarColor", 0);
        } else {
            if (this.chatId == 0) {
                return false;
            }
            TLRPC$Chat chat = getMessagesController().getChat(Long.valueOf(this.chatId));
            this.currentChat = chat;
            if (chat == null) {
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$Z5vyrGvNVLifM2GE-RUvzxCBnj0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onFragmentCreate$0$ProfileActivity(countDownLatch);
                    }
                });
                try {
                    countDownLatch.await();
                } catch (Exception e) {
                    FileLog.e(e);
                }
                if (this.currentChat == null) {
                    return false;
                }
                getMessagesController().putChat(this.currentChat, true);
            }
            if (this.currentChat.megagroup) {
                getChannelParticipants(true);
            } else {
                this.participantsMap = null;
            }
            getNotificationCenter().addObserver(this, NotificationCenter.chatInfoDidLoad);
            getNotificationCenter().addObserver(this, NotificationCenter.chatOnlineCountDidLoad);
            getNotificationCenter().addObserver(this, NotificationCenter.groupCallUpdated);
            this.sortedUsers = new ArrayList<>();
            updateOnlineCount(true);
            if (this.chatInfo == null) {
                this.chatInfo = getMessagesController().getChatFull(this.chatId);
            }
            if (ChatObject.isChannel(this.currentChat)) {
                getMessagesController().loadFullChat(this.chatId, this.classGuid, true);
            } else if (this.chatInfo == null) {
                this.chatInfo = getMessagesStorage().loadChatInfo(this.chatId, false, null, false, false);
            }
        }
        if (this.sharedMediaPreloader == null) {
            this.sharedMediaPreloader = new SharedMediaLayout.SharedMediaPreloader(this);
        }
        this.sharedMediaPreloader.addDelegate(this);
        getNotificationCenter().addObserver(this, NotificationCenter.updateInterfaces);
        getNotificationCenter().addObserver(this, NotificationCenter.didReceiveNewMessages);
        getNotificationCenter().addObserver(this, NotificationCenter.closeChats);
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.emojiLoaded);
        updateRowsIds();
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
        if (this.arguments.containsKey("preload_messages")) {
            getMessagesController().ensureMessagesLoaded(this.userId, 0, null);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onFragmentCreate$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onFragmentCreate$0$ProfileActivity(CountDownLatch countDownLatch) {
        this.currentChat = getMessagesStorage().getChat(this.chatId);
        countDownLatch.countDown();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    protected void setParentLayout(ActionBarLayout layout) {
        super.setParentLayout(layout);
        Activity parentActivity = getParentActivity();
        if (parentActivity == null || Build.VERSION.SDK_INT < 21) {
            return;
        }
        this.navigationBarAnimationColorFrom = parentActivity.getWindow().getNavigationBarColor();
    }

    private boolean isChatActivity() {
        if (this.parentLayout.fragmentsStack.size() == 1 && (this.parentLayout.fragmentsStack.get(0) instanceof ChatActivity)) {
            return true;
        }
        if (this.parentLayout.fragmentsStack.size() > 1) {
            ArrayList<BaseFragment> arrayList = this.parentLayout.fragmentsStack;
            if (arrayList.get(arrayList.size() - (isLastFragment() ? 2 : 1)) instanceof ChatActivity) {
                return true;
            }
        }
        return false;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() throws InterruptedException {
        super.onFragmentDestroy();
        if (isChatActivity()) {
            ArrayList<BaseFragment> arrayList = this.parentLayout.fragmentsStack;
            if (((ChatActivity) arrayList.get(arrayList.size() - (isLastFragment() ? 2 : 1))).getDialogId() != getDialogId()) {
                ChatLockHelper.removeFromUnlockedChats(Long.valueOf(getDialogId()));
            }
        } else {
            ChatLockHelper.removeFromUnlockedChats(Long.valueOf(getDialogId()));
        }
        SharedMediaLayout sharedMediaLayout = this.sharedMediaLayout;
        if (sharedMediaLayout != null) {
            sharedMediaLayout.onDestroy();
        }
        SharedMediaLayout.SharedMediaPreloader sharedMediaPreloader = this.sharedMediaPreloader;
        if (sharedMediaPreloader != null) {
            sharedMediaPreloader.onDestroy(this);
        }
        SharedMediaLayout.SharedMediaPreloader sharedMediaPreloader2 = this.sharedMediaPreloader;
        if (sharedMediaPreloader2 != null) {
            sharedMediaPreloader2.removeDelegate(this);
        }
        getNotificationCenter().removeObserver(this, NotificationCenter.updateInterfaces);
        getNotificationCenter().removeObserver(this, NotificationCenter.closeChats);
        getNotificationCenter().removeObserver(this, NotificationCenter.didReceiveNewMessages);
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.emojiLoaded);
        ProfileGalleryView profileGalleryView = this.avatarsViewPager;
        if (profileGalleryView != null) {
            profileGalleryView.onDestroy();
        }
        if (this.userId != 0) {
            getNotificationCenter().removeObserver(this, NotificationCenter.newSuggestionsAvailable);
            getNotificationCenter().removeObserver(this, NotificationCenter.contactsDidLoad);
            getNotificationCenter().removeObserver(this, NotificationCenter.encryptedChatCreated);
            getNotificationCenter().removeObserver(this, NotificationCenter.encryptedChatUpdated);
            getNotificationCenter().removeObserver(this, NotificationCenter.blockedUsersDidLoad);
            getNotificationCenter().removeObserver(this, NotificationCenter.botInfoDidLoad);
            getNotificationCenter().removeObserver(this, NotificationCenter.userInfoDidLoad);
            NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.reloadInterface);
            getMessagesController().cancelLoadFullUser(this.userId);
        } else if (this.chatId != 0) {
            getNotificationCenter().removeObserver(this, NotificationCenter.chatInfoDidLoad);
            getNotificationCenter().removeObserver(this, NotificationCenter.chatOnlineCountDidLoad);
            getNotificationCenter().removeObserver(this, NotificationCenter.groupCallUpdated);
        }
        AvatarImageView avatarImageView = this.avatarImage;
        if (avatarImageView != null) {
            avatarImageView.setImageDrawable(null);
        }
        ImageUpdater imageUpdater = this.imageUpdater;
        if (imageUpdater != null) {
            imageUpdater.clear();
        }
        PinchToZoomHelper pinchToZoomHelper = this.pinchToZoomHelper;
        if (pinchToZoomHelper != null) {
            pinchToZoomHelper.clear();
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    protected ActionBar createActionBar(Context context) {
        ActionBar actionBar = new ActionBar(context) { // from class: ir.eitaa.ui.ProfileActivity.3
            @Override // ir.eitaa.ui.ActionBar.ActionBar, android.view.View
            public boolean onTouchEvent(MotionEvent event) {
                ProfileActivity.this.avatarContainer.getHitRect(ProfileActivity.this.rect);
                if (ProfileActivity.this.rect.contains((int) event.getX(), (int) event.getY())) {
                    return false;
                }
                return super.onTouchEvent(event);
            }
        };
        boolean z = false;
        actionBar.setBackgroundColor(0);
        actionBar.setItemsBackgroundColor(AvatarDrawable.getButtonColorForId((this.userId != 0 || (ChatObject.isChannel(this.chatId, this.currentAccount) && !this.currentChat.megagroup)) ? 5L : this.chatId), false);
        actionBar.setItemsColor(Theme.getColor("actionBarDefaultIcon"), false);
        actionBar.isProfile = true;
        actionBar.setBackButtonDrawable(new BackDrawable(false));
        actionBar.setCastShadows(false);
        actionBar.setAddToContainer(false);
        actionBar.setClipContent(true);
        if (Build.VERSION.SDK_INT >= 21 && !AndroidUtilities.isTablet() && !this.inBubbleMode) {
            z = true;
        }
        actionBar.setOccupyStatusBar(z);
        return actionBar;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(final Context context) throws Resources.NotFoundException {
        int i;
        Object tag;
        int i2;
        TLRPC$ChatParticipants tLRPC$ChatParticipants;
        Theme.createProfileResources(context);
        Theme.createChatResources(context, false);
        this.searchTransitionOffset = 0;
        this.searchTransitionProgress = 1.0f;
        this.searchMode = false;
        this.hasOwnBackground = true;
        this.extraHeight = AndroidUtilities.dp(88.0f);
        this.actionBar.setActionBarMenuOnItemClick(new AnonymousClass4());
        SharedMediaLayout sharedMediaLayout = this.sharedMediaLayout;
        if (sharedMediaLayout != null) {
            sharedMediaLayout.onDestroy();
        }
        long j = this.dialogId;
        if (j == 0) {
            j = this.userId;
            if (j == 0) {
                j = -this.chatId;
            }
        }
        final long j2 = j;
        TLRPC$ChatFull tLRPC$ChatFull = this.chatInfo;
        ArrayList<Integer> arrayList = (tLRPC$ChatFull == null || (tLRPC$ChatParticipants = tLRPC$ChatFull.participants) == null || tLRPC$ChatParticipants.participants.size() <= 5) ? null : this.sortedUsers;
        SharedMediaLayout.SharedMediaPreloader sharedMediaPreloader = this.sharedMediaPreloader;
        TLRPC$UserFull tLRPC$UserFull = this.userInfo;
        SharedMediaLayout sharedMediaLayout2 = new SharedMediaLayout(context, j2, sharedMediaPreloader, tLRPC$UserFull != null ? tLRPC$UserFull.common_chats_count : 0, this.sortedUsers, this.chatInfo, arrayList != null, this) { // from class: ir.eitaa.ui.ProfileActivity.5
            @Override // ir.eitaa.ui.Components.SharedMediaLayout
            protected void onSelectedTabChanged() {
                ProfileActivity.this.updateSelectedMediaTabText();
            }

            @Override // ir.eitaa.ui.Components.SharedMediaLayout
            protected boolean canShowSearchItem() {
                return ProfileActivity.this.mediaHeaderVisible;
            }

            @Override // ir.eitaa.ui.Components.SharedMediaLayout
            protected void onSearchStateChanged(boolean expanded) {
                if (SharedConfig.smoothKeyboard) {
                    AndroidUtilities.removeAdjustResize(ProfileActivity.this.getParentActivity(), ((BaseFragment) ProfileActivity.this).classGuid);
                }
                ProfileActivity.this.listView.stopScroll();
                ProfileActivity.this.avatarContainer2.setPivotY(ProfileActivity.this.avatarContainer.getPivotY() + (ProfileActivity.this.avatarContainer.getMeasuredHeight() / 2.0f));
                ProfileActivity.this.avatarContainer2.setPivotX(ProfileActivity.this.avatarContainer2.getMeasuredWidth() / 2.0f);
                AndroidUtilities.updateViewVisibilityAnimated(ProfileActivity.this.avatarContainer2, !expanded, 0.95f, true);
                ProfileActivity.this.callItem.setVisibility((expanded || !ProfileActivity.this.callItemVisible) ? 8 : 4);
                ProfileActivity.this.videoCallItem.setVisibility((expanded || !ProfileActivity.this.videoCallItemVisible) ? 8 : 4);
                ProfileActivity.this.editItem.setVisibility((expanded || !ProfileActivity.this.editItemVisible) ? 8 : 4);
                ProfileActivity.this.otherItem.setVisibility(expanded ? 8 : 4);
            }

            @Override // ir.eitaa.ui.Components.SharedMediaLayout
            protected boolean onMemberClick(TLRPC$ChatParticipant participant, boolean isLong) {
                return ProfileActivity.this.onMemberClick(participant, isLong);
            }
        };
        this.sharedMediaLayout = sharedMediaLayout2;
        sharedMediaLayout2.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
        ActionBarMenu actionBarMenuCreateMenu = this.actionBar.createMenu();
        if (this.imageUpdater != null) {
            ActionBarMenuItem actionBarMenuItemSearchListener = actionBarMenuCreateMenu.addItem(32, R.drawable.ic_ab_search).setIsSearchField(true).setActionBarMenuItemSearchListener(new ActionBarMenuItem.ActionBarMenuItemSearchListener() { // from class: ir.eitaa.ui.ProfileActivity.6
                @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
                public Animator getCustomToggleTransition() {
                    ProfileActivity.this.searchMode = !r0.searchMode;
                    if (!ProfileActivity.this.searchMode) {
                        ProfileActivity.this.searchItem.clearFocusOnSearchView();
                    }
                    if (ProfileActivity.this.searchMode) {
                        ProfileActivity.this.searchItem.getSearchField().setText("");
                    }
                    ProfileActivity profileActivity = ProfileActivity.this;
                    return profileActivity.searchExpandTransition(profileActivity.searchMode);
                }

                @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
                public void onTextChanged(EditText editText) throws InterruptedException {
                    ProfileActivity.this.searchAdapter.search(editText.getText().toString().toLowerCase());
                }
            });
            this.searchItem = actionBarMenuItemSearchListener;
            actionBarMenuItemSearchListener.setContentDescription(LocaleController.getString("SearchInSettings", R.string.SearchInSettings));
            this.searchItem.setSearchFieldHint(LocaleController.getString("SearchInSettings", R.string.SearchInSettings));
            this.sharedMediaLayout.getSearchItem().setVisibility(8);
            if (this.expandPhoto) {
                this.searchItem.setVisibility(8);
            }
        }
        ActionBarMenuItem actionBarMenuItemAddItem = actionBarMenuCreateMenu.addItem(16, R.drawable.profile_video);
        this.videoCallItem = actionBarMenuItemAddItem;
        actionBarMenuItemAddItem.setContentDescription(LocaleController.getString("VideoCall", R.string.VideoCall));
        if (this.chatId != 0) {
            this.callItem = actionBarMenuCreateMenu.addItem(15, R.drawable.msg_voicechat2);
            if (ChatObject.isChannelOrGiga(this.currentChat)) {
                this.callItem.setContentDescription(LocaleController.getString("VoipChannelVoiceChat", R.string.VoipChannelVoiceChat));
            } else {
                this.callItem.setContentDescription(LocaleController.getString("VoipGroupVoiceChat", R.string.VoipGroupVoiceChat));
            }
        } else {
            ActionBarMenuItem actionBarMenuItemAddItem2 = actionBarMenuCreateMenu.addItem(15, R.drawable.ic_call);
            this.callItem = actionBarMenuItemAddItem2;
            actionBarMenuItemAddItem2.setContentDescription(LocaleController.getString("Call", R.string.Call));
        }
        ActionBarMenuItem actionBarMenuItemAddItem3 = actionBarMenuCreateMenu.addItem(12, R.drawable.group_edit_profile);
        this.editItem = actionBarMenuItemAddItem3;
        actionBarMenuItemAddItem3.setContentDescription(LocaleController.getString("Edit", R.string.Edit));
        ActionBarMenuItem actionBarMenuItemAddItem4 = actionBarMenuCreateMenu.addItem(10, R.drawable.ic_ab_other);
        this.otherItem = actionBarMenuItemAddItem4;
        actionBarMenuItemAddItem4.setContentDescription(LocaleController.getString("AccDescrMoreOptions", R.string.AccDescrMoreOptions));
        if (this.listView == null || this.imageUpdater == null) {
            i = -1;
            tag = null;
        } else {
            int iFindFirstVisibleItemPosition = this.layoutManager.findFirstVisibleItemPosition();
            View viewFindViewByPosition = this.layoutManager.findViewByPosition(iFindFirstVisibleItemPosition);
            if (viewFindViewByPosition != null) {
                viewFindViewByPosition.getTop();
                this.listView.getPaddingTop();
            } else {
                iFindFirstVisibleItemPosition = -1;
            }
            i = iFindFirstVisibleItemPosition;
            tag = this.writeButton.getTag();
        }
        createActionBarMenu(false);
        this.listAdapter = new ListAdapter(context);
        this.searchAdapter = new SearchAdapter(context);
        AvatarDrawable avatarDrawable = new AvatarDrawable();
        this.avatarDrawable = avatarDrawable;
        avatarDrawable.setProfile(true);
        AnonymousClass7 anonymousClass7 = new AnonymousClass7(context);
        this.fragmentView = anonymousClass7;
        anonymousClass7.setWillNotDraw(false);
        FrameLayout frameLayout = (FrameLayout) this.fragmentView;
        RecyclerListView recyclerListView = new RecyclerListView(context) { // from class: ir.eitaa.ui.ProfileActivity.8
            private VelocityTracker velocityTracker;

            @Override // ir.eitaa.ui.Components.RecyclerListView, android.view.View
            public boolean hasOverlappingRendering() {
                return false;
            }

            @Override // androidx.recyclerview.widget.RecyclerView
            protected void requestChildOnScreen(View child, View focused) {
            }

            @Override // ir.eitaa.ui.Components.RecyclerListView
            protected boolean allowSelectChildAtPosition(View child) {
                return child != ProfileActivity.this.sharedMediaLayout;
            }

            @Override // android.view.View
            public void invalidate() {
                super.invalidate();
                if (((BaseFragment) ProfileActivity.this).fragmentView != null) {
                    ((BaseFragment) ProfileActivity.this).fragmentView.invalidate();
                }
            }

            @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.View
            public boolean onTouchEvent(MotionEvent e) {
                VelocityTracker velocityTracker;
                View viewFindViewByPosition2;
                int action = e.getAction();
                if (action == 0) {
                    VelocityTracker velocityTracker2 = this.velocityTracker;
                    if (velocityTracker2 == null) {
                        this.velocityTracker = VelocityTracker.obtain();
                    } else {
                        velocityTracker2.clear();
                    }
                    this.velocityTracker.addMovement(e);
                } else if (action == 2) {
                    VelocityTracker velocityTracker3 = this.velocityTracker;
                    if (velocityTracker3 != null) {
                        velocityTracker3.addMovement(e);
                        this.velocityTracker.computeCurrentVelocity(1000);
                        ProfileActivity.this.listViewVelocityY = this.velocityTracker.getYVelocity(e.getPointerId(e.getActionIndex()));
                    }
                } else if ((action == 1 || action == 3) && (velocityTracker = this.velocityTracker) != null) {
                    velocityTracker.recycle();
                    this.velocityTracker = null;
                }
                boolean zOnTouchEvent = super.onTouchEvent(e);
                if ((action == 1 || action == 3) && ProfileActivity.this.allowPullingDown && (viewFindViewByPosition2 = ProfileActivity.this.layoutManager.findViewByPosition(0)) != null) {
                    if (ProfileActivity.this.isPulledDown) {
                        ProfileActivity.this.listView.smoothScrollBy(0, (viewFindViewByPosition2.getTop() - ProfileActivity.this.listView.getMeasuredWidth()) + ActionBar.getCurrentActionBarHeight() + (((BaseFragment) ProfileActivity.this).actionBar.getOccupyStatusBar() ? AndroidUtilities.statusBarHeight : 0), CubicBezierInterpolator.EASE_OUT_QUINT);
                    } else {
                        ProfileActivity.this.listView.smoothScrollBy(0, viewFindViewByPosition2.getTop() - AndroidUtilities.dp(88.0f), CubicBezierInterpolator.EASE_OUT_QUINT);
                    }
                }
                return zOnTouchEvent;
            }

            @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
            public boolean drawChild(Canvas canvas, View child, long drawingTime) {
                if (getItemAnimator().isRunning() && child.getBackground() == null && child.getTranslationY() != 0.0f) {
                    boolean z = ProfileActivity.this.listView.getChildAdapterPosition(child) == ProfileActivity.this.sharedMediaRow && child.getAlpha() != 1.0f;
                    if (z) {
                        ProfileActivity.this.whitePaint.setAlpha((int) (ProfileActivity.this.listView.getAlpha() * 255.0f * child.getAlpha()));
                    }
                    canvas.drawRect(ProfileActivity.this.listView.getX(), child.getY(), ProfileActivity.this.listView.getX() + ProfileActivity.this.listView.getMeasuredWidth(), child.getY() + child.getHeight(), ProfileActivity.this.whitePaint);
                    if (z) {
                        ProfileActivity.this.whitePaint.setAlpha((int) (ProfileActivity.this.listView.getAlpha() * 255.0f));
                    }
                }
                return super.drawChild(canvas, child, drawingTime);
            }
        };
        this.listView = recyclerListView;
        recyclerListView.setVerticalScrollBarEnabled(false);
        AnonymousClass9 anonymousClass9 = new AnonymousClass9();
        this.listView.setItemAnimator(anonymousClass9);
        anonymousClass9.setSupportsChangeAnimations(false);
        anonymousClass9.setDelayAnimations(false);
        this.listView.setClipToPadding(false);
        this.listView.setHideIfEmpty(false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context) { // from class: ir.eitaa.ui.ProfileActivity.10
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean supportsPredictiveItemAnimations() {
                return ProfileActivity.this.imageUpdater != null;
            }

            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
                View viewFindViewByPosition2 = ProfileActivity.this.layoutManager.findViewByPosition(0);
                if (viewFindViewByPosition2 != null && !ProfileActivity.this.openingAvatar) {
                    int top = viewFindViewByPosition2.getTop() - AndroidUtilities.dp(88.0f);
                    if (ProfileActivity.this.allowPullingDown || top <= dy) {
                        if (ProfileActivity.this.allowPullingDown) {
                            if (dy >= top) {
                                ProfileActivity.this.allowPullingDown = false;
                            } else if (ProfileActivity.this.listView.getScrollState() == 1 && !ProfileActivity.this.isPulledDown) {
                                dy /= 2;
                            }
                        }
                    } else if (ProfileActivity.this.avatarsViewPager.hasImages() && ProfileActivity.this.avatarImage.getImageReceiver().hasNotThumb() && !ProfileActivity.this.isInLandscapeMode && !AndroidUtilities.isTablet()) {
                        ProfileActivity profileActivity = ProfileActivity.this;
                        profileActivity.allowPullingDown = profileActivity.avatarBig == null;
                    }
                    dy = top;
                }
                return super.scrollVerticallyBy(dy, recycler, state);
            }
        };
        this.layoutManager = linearLayoutManager;
        linearLayoutManager.setOrientation(1);
        this.listView.setLayoutManager(this.layoutManager);
        this.listView.setGlowColor(0);
        this.listView.setAdapter(this.listAdapter);
        frameLayout.addView(this.listView, LayoutHelper.createFrame(-1, -1, 51));
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListenerExtended() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$fjStZdCWRqmLmkmeZlA_cjEr37U
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListenerExtended
            public final void onItemClick(View view, int i3, float f, float f2) throws Resources.NotFoundException, IOException {
                this.f$0.lambda$createView$3$ProfileActivity(j2, view, i3, f, f2);
            }
        });
        this.listView.setOnItemLongClickListener(new AnonymousClass11());
        if (this.searchItem != null) {
            RecyclerListView recyclerListView2 = new RecyclerListView(context);
            this.searchListView = recyclerListView2;
            recyclerListView2.setVerticalScrollBarEnabled(false);
            this.searchListView.setLayoutManager(new LinearLayoutManager(context, 1, false));
            this.searchListView.setGlowColor(Theme.getColor("avatar_backgroundActionBarBlue"));
            this.searchListView.setAdapter(this.searchAdapter);
            this.searchListView.setItemAnimator(null);
            this.searchListView.setVisibility(8);
            this.searchListView.setLayoutAnimation(null);
            this.searchListView.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
            frameLayout.addView(this.searchListView, LayoutHelper.createFrame(-1, -1, 51));
            this.searchListView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$kwV4tSaagh_rn9p5ZtEidwsZTQo
                @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
                public final void onItemClick(View view, int i3) {
                    this.f$0.lambda$createView$4$ProfileActivity(view, i3);
                }
            });
            this.searchListView.setOnItemLongClickListener(new RecyclerListView.OnItemLongClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$kO-T1uc4t3kTtsDdrr3j5zIQqRc
                @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemLongClickListener
                public final boolean onItemClick(View view, int i3) {
                    return this.f$0.lambda$createView$6$ProfileActivity(view, i3);
                }
            });
            this.searchListView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.eitaa.ui.ProfileActivity.12
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                    if (newState == 1) {
                        AndroidUtilities.hideKeyboard(ProfileActivity.this.getParentActivity().getCurrentFocus());
                    }
                }
            });
            this.searchListView.setAnimateEmptyView(true, 1);
            StickerEmptyView stickerEmptyView = new StickerEmptyView(context, null, 1);
            this.emptyView = stickerEmptyView;
            stickerEmptyView.setAnimateLayoutChange(true);
            this.emptyView.subtitle.setVisibility(8);
            this.emptyView.setVisibility(8);
            frameLayout.addView(this.emptyView);
            this.searchAdapter.loadFaqWebPage();
        }
        if (this.banFromGroup != 0) {
            final TLRPC$Chat chat = getMessagesController().getChat(Long.valueOf(this.banFromGroup));
            if (this.currentChannelParticipant == null) {
                TLRPC$TL_channels_getParticipant tLRPC$TL_channels_getParticipant = new TLRPC$TL_channels_getParticipant();
                tLRPC$TL_channels_getParticipant.channel = MessagesController.getInputChannel(chat);
                tLRPC$TL_channels_getParticipant.participant = getMessagesController().getInputPeer(this.userId);
                getConnectionsManager().sendRequest(tLRPC$TL_channels_getParticipant, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$t8TOwIWCtGEnlosMzDrk09xzPmk
                    @Override // ir.eitaa.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$createView$8$ProfileActivity(tLObject, tLRPC$TL_error);
                    }
                });
            }
            FrameLayout frameLayout2 = new FrameLayout(context) { // from class: ir.eitaa.ui.ProfileActivity.13
                @Override // android.view.View
                protected void onDraw(Canvas canvas) {
                    int intrinsicHeight = Theme.chat_composeShadowDrawable.getIntrinsicHeight();
                    Theme.chat_composeShadowDrawable.setBounds(0, 0, getMeasuredWidth(), intrinsicHeight);
                    Theme.chat_composeShadowDrawable.draw(canvas);
                    canvas.drawRect(0.0f, intrinsicHeight, getMeasuredWidth(), getMeasuredHeight(), Theme.chat_composeBackgroundPaint);
                }
            };
            frameLayout2.setWillNotDraw(false);
            frameLayout.addView(frameLayout2, LayoutHelper.createFrame(-1, 51, 83));
            frameLayout2.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$NM6fcPHuGNPYUHjAh_I5uC9wORs
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$createView$9$ProfileActivity(chat, view);
                }
            });
            TextView textView = new TextView(context);
            textView.setTextColor(Theme.getColor("windowBackgroundWhiteRedText"));
            textView.setTextSize(1, 15.0f);
            textView.setGravity(17);
            textView.setTypeface(AndroidUtilities.getFontFamily(true));
            textView.setText(LocaleController.getString("BanFromTheGroup", R.string.BanFromTheGroup));
            frameLayout2.addView(textView, LayoutHelper.createFrame(-2, -2.0f, 17, 0.0f, 1.0f, 0.0f, 0.0f));
            this.listView.setPadding(0, AndroidUtilities.dp(88.0f), 0, AndroidUtilities.dp(48.0f));
            this.listView.setBottomGlowOffset(AndroidUtilities.dp(48.0f));
        } else {
            this.listView.setPadding(0, AndroidUtilities.dp(88.0f), 0, 0);
        }
        TopView topView = new TopView(context);
        this.topView = topView;
        topView.setBackgroundColor(Theme.getColor("avatar_backgroundActionBarBlue"));
        frameLayout.addView(this.topView);
        this.avatarContainer = new FrameLayout(context);
        FrameLayout frameLayout3 = new FrameLayout(context) { // from class: ir.eitaa.ui.ProfileActivity.15
            @Override // android.view.ViewGroup, android.view.View
            protected void dispatchDraw(Canvas canvas) {
                super.dispatchDraw(canvas);
                if (ProfileActivity.this.transitionOnlineText != null) {
                    canvas.save();
                    canvas.translate(ProfileActivity.this.onlineTextView[0].getX(), ProfileActivity.this.onlineTextView[0].getY());
                    canvas.saveLayerAlpha(0.0f, 0.0f, ProfileActivity.this.transitionOnlineText.getMeasuredWidth(), ProfileActivity.this.transitionOnlineText.getMeasuredHeight(), (int) ((1.0f - ProfileActivity.this.animationProgress) * 255.0f), 31);
                    ProfileActivity.this.transitionOnlineText.draw(canvas);
                    canvas.restore();
                    canvas.restore();
                    invalidate();
                }
            }
        };
        this.avatarContainer2 = frameLayout3;
        AndroidUtilities.updateViewVisibilityAnimated(frameLayout3, true, 1.0f, false);
        frameLayout.addView(this.avatarContainer2, LayoutHelper.createFrame(-1, -1.0f, 8388611, 0.0f, 0.0f, 0.0f, 0.0f));
        this.avatarContainer.setPivotX(0.0f);
        this.avatarContainer.setPivotY(0.0f);
        this.avatarContainer2.addView(this.avatarContainer, LayoutHelper.createFrame(42, 42.0f, 51, 64.0f, 0.0f, 0.0f, 0.0f));
        AvatarImageView avatarImageView = new AvatarImageView(context) { // from class: ir.eitaa.ui.ProfileActivity.16
            @Override // android.view.View
            public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
                super.onInitializeAccessibilityNodeInfo(info);
                if (getImageReceiver().hasNotThumb()) {
                    info.setText(LocaleController.getString("AccDescrProfilePicture", R.string.AccDescrProfilePicture));
                    if (Build.VERSION.SDK_INT >= 21) {
                        info.addAction(new AccessibilityNodeInfo.AccessibilityAction(16, LocaleController.getString("Open", R.string.Open)));
                        info.addAction(new AccessibilityNodeInfo.AccessibilityAction(32, LocaleController.getString("AccDescrOpenInPhotoViewer", R.string.AccDescrOpenInPhotoViewer)));
                        return;
                    }
                    return;
                }
                info.setVisibleToUser(false);
            }
        };
        this.avatarImage = avatarImageView;
        avatarImageView.getImageReceiver().setAllowDecodeSingleFrame(true);
        this.avatarImage.setRoundRadius(AndroidUtilities.dp(21.0f));
        this.avatarImage.setPivotX(0.0f);
        this.avatarImage.setPivotY(0.0f);
        this.avatarContainer.addView(this.avatarImage, LayoutHelper.createFrame(-1, -1.0f));
        this.avatarImage.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$TYNV5Y-wdzH8RteZowG6TgN4lCo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                this.f$0.lambda$createView$10$ProfileActivity(view);
            }
        });
        this.avatarImage.setOnLongClickListener(new View.OnLongClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$fLy3b83qbcdWVTy9Wk-yraMAmgc
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f$0.lambda$createView$11$ProfileActivity(view);
            }
        });
        RadialProgressView radialProgressView = new RadialProgressView(context) { // from class: ir.eitaa.ui.ProfileActivity.17
            private Paint paint;

            {
                Paint paint = new Paint(1);
                this.paint = paint;
                paint.setColor(1426063360);
            }

            @Override // ir.eitaa.ui.Components.RadialProgressView, android.view.View
            protected void onDraw(Canvas canvas) {
                if (ProfileActivity.this.avatarImage != null && ProfileActivity.this.avatarImage.getImageReceiver().hasNotThumb()) {
                    this.paint.setAlpha((int) (ProfileActivity.this.avatarImage.getImageReceiver().getCurrentAlpha() * 85.0f));
                    canvas.drawCircle(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f, getMeasuredWidth() / 2.0f, this.paint);
                }
                super.onDraw(canvas);
            }
        };
        this.avatarProgressView = radialProgressView;
        radialProgressView.setSize(AndroidUtilities.dp(26.0f));
        this.avatarProgressView.setProgressColor(-1);
        this.avatarProgressView.setNoProgress(false);
        this.avatarContainer.addView(this.avatarProgressView, LayoutHelper.createFrame(-1, -1.0f));
        ImageView imageView = new ImageView(context);
        this.timeItem = imageView;
        imageView.setPadding(AndroidUtilities.dp(10.0f), AndroidUtilities.dp(10.0f), AndroidUtilities.dp(5.0f), AndroidUtilities.dp(5.0f));
        this.timeItem.setScaleType(ImageView.ScaleType.CENTER);
        this.timeItem.setAlpha(0.0f);
        ImageView imageView2 = this.timeItem;
        TimerDrawable timerDrawable = new TimerDrawable(context);
        this.timerDrawable = timerDrawable;
        imageView2.setImageDrawable(timerDrawable);
        frameLayout.addView(this.timeItem, LayoutHelper.createFrame(34, 34, 51));
        updateTimeItem();
        showAvatarProgress(false, false);
        ProfileGalleryView profileGalleryView = this.avatarsViewPager;
        if (profileGalleryView != null) {
            profileGalleryView.onDestroy();
        }
        this.overlaysView = new OverlaysView(context);
        long j3 = this.userId;
        if (j3 == 0) {
            j3 = -this.chatId;
        }
        ProfileGalleryView profileGalleryView2 = new ProfileGalleryView(context, j3, this.actionBar, this.listView, this.avatarImage, getClassGuid(), this.overlaysView);
        this.avatarsViewPager = profileGalleryView2;
        profileGalleryView2.setChatInfo(this.chatInfo);
        this.avatarContainer2.addView(this.avatarsViewPager);
        this.avatarContainer2.addView(this.overlaysView);
        this.avatarImage.setAvatarsViewPager(this.avatarsViewPager);
        PagerIndicatorView pagerIndicatorView = new PagerIndicatorView(context);
        this.avatarsViewPagerIndicatorView = pagerIndicatorView;
        this.avatarContainer2.addView(pagerIndicatorView, LayoutHelper.createFrame(-1, -1.0f));
        frameLayout.addView(this.actionBar);
        int i3 = 0;
        while (true) {
            SimpleTextView[] simpleTextViewArr = this.nameTextView;
            if (i3 >= simpleTextViewArr.length) {
                break;
            }
            if (this.playProfileAnimation != 0 || i3 != 0) {
                simpleTextViewArr[i3] = new SimpleTextView(context);
                if (i3 == 1) {
                    this.nameTextView[i3].setTextColor(Theme.getColor("profile_title"));
                } else {
                    this.nameTextView[i3].setTextColor(Theme.getColor("actionBarDefaultTitle"));
                }
                this.nameTextView[i3].setTextSize(18);
                this.nameTextView[i3].setGravity(3);
                this.nameTextView[i3].setTypeface(AndroidUtilities.getFontFamily(true));
                this.nameTextView[i3].setLeftDrawableTopPadding(-AndroidUtilities.dp(1.3f));
                this.nameTextView[i3].setPivotX(0.0f);
                this.nameTextView[i3].setPivotY(0.0f);
                this.nameTextView[i3].setAlpha(i3 == 0 ? 0.0f : 1.0f);
                if (i3 == 1) {
                    this.nameTextView[i3].setScrollNonFitText(true);
                    this.nameTextView[i3].setImportantForAccessibility(2);
                }
                if (i3 == 0) {
                    i2 = 48 + ((!this.callItemVisible || this.userId == 0) ? 0 : 48);
                } else {
                    i2 = 0;
                }
                this.avatarContainer2.addView(this.nameTextView[i3], LayoutHelper.createFrame(-2, -2.0f, 51, 118.0f, 0.0f, i2, 0.0f));
            }
            i3++;
        }
        int i4 = 0;
        while (true) {
            SimpleTextView[] simpleTextViewArr2 = this.onlineTextView;
            if (i4 >= simpleTextViewArr2.length) {
                break;
            }
            simpleTextViewArr2[i4] = new SimpleTextView(context);
            this.onlineTextView[i4].setTextColor(Theme.getColor("avatar_subtitleInProfileBlue"));
            this.onlineTextView[i4].setTextSize(14);
            this.onlineTextView[i4].setTypeface(AndroidUtilities.getFontFamily(false));
            this.onlineTextView[i4].setGravity(3);
            this.onlineTextView[i4].setAlpha((i4 == 0 || i4 == 2) ? 0.0f : 1.0f);
            if (i4 > 0) {
                this.onlineTextView[i4].setImportantForAccessibility(2);
            }
            this.avatarContainer2.addView(this.onlineTextView[i4], LayoutHelper.createFrame(-2, -2.0f, 51, 118.0f, 0.0f, i4 == 0 ? 48.0f : 8.0f, 0.0f));
            i4++;
        }
        AudioPlayerAlert.ClippingTextViewSwitcher clippingTextViewSwitcher = new AudioPlayerAlert.ClippingTextViewSwitcher(context) { // from class: ir.eitaa.ui.ProfileActivity.18
            @Override // ir.eitaa.ui.Components.AudioPlayerAlert.ClippingTextViewSwitcher
            protected TextView createTextView() {
                TextView textView2 = new TextView(context);
                textView2.setTextColor(Theme.getColor("player_actionBarSubtitle"));
                textView2.setTextSize(1, 14.0f);
                textView2.setTypeface(AndroidUtilities.getFontFamily(false));
                textView2.setSingleLine(true);
                textView2.setEllipsize(TextUtils.TruncateAt.END);
                textView2.setGravity(3);
                return textView2;
            }
        };
        this.mediaCounterTextView = clippingTextViewSwitcher;
        clippingTextViewSwitcher.setAlpha(0.0f);
        this.avatarContainer2.addView(this.mediaCounterTextView, LayoutHelper.createFrame(-2, -2.0f, 51, 118.0f, 0.0f, 8.0f, 0.0f));
        updateProfileData();
        this.writeButton = new RLottieImageView(context);
        Drawable drawableMutate = context.getResources().getDrawable(R.drawable.floating_shadow_profile).mutate();
        drawableMutate.setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.MULTIPLY));
        CombinedDrawable combinedDrawable = new CombinedDrawable(drawableMutate, Theme.createSimpleSelectorCircleDrawable(AndroidUtilities.dp(56.0f), Theme.getColor("profile_actionBackground"), Theme.getColor("profile_actionPressedBackground")), 0, 0);
        combinedDrawable.setIconSize(AndroidUtilities.dp(56.0f), AndroidUtilities.dp(56.0f));
        this.writeButton.setBackgroundDrawable(combinedDrawable);
        if (this.userId != 0) {
            if (this.imageUpdater != null) {
                RLottieDrawable rLottieDrawable = new RLottieDrawable(R.raw.camera_outline, "2131623946", AndroidUtilities.dp(56.0f), AndroidUtilities.dp(56.0f), false, (int[]) null);
                this.cameraDrawable = rLottieDrawable;
                this.writeButton.setAnimation(rLottieDrawable);
                this.writeButton.setContentDescription(LocaleController.getString("AccDescrChangeProfilePicture", R.string.AccDescrChangeProfilePicture));
                this.writeButton.setPadding(AndroidUtilities.dp(2.0f), 0, 0, AndroidUtilities.dp(2.0f));
            } else {
                this.writeButton.setImageResource(R.drawable.profile_newmsg);
                this.writeButton.setContentDescription(LocaleController.getString("AccDescrOpenChat", R.string.AccDescrOpenChat));
            }
        } else {
            this.writeButton.setImageResource(R.drawable.profile_discuss);
            this.writeButton.setContentDescription(LocaleController.getString("ViewDiscussion", R.string.ViewDiscussion));
        }
        this.writeButton.setColorFilter(new PorterDuffColorFilter(Theme.getColor("profile_actionIcon"), PorterDuff.Mode.MULTIPLY));
        this.writeButton.setScaleType(ImageView.ScaleType.CENTER);
        frameLayout.addView(this.writeButton, LayoutHelper.createFrame(60, 60.0f, 53, 0.0f, 0.0f, 16.0f, 0.0f));
        this.writeButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$v_Sgzty6aCpHPlnv9MzDW1dXaIw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createView$12$ProfileActivity(view);
            }
        });
        needLayout(false);
        if (i != -1 && tag != null) {
            this.writeButton.setTag(0);
            this.writeButton.setScaleX(0.2f);
            this.writeButton.setScaleY(0.2f);
            this.writeButton.setAlpha(0.0f);
        }
        this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.eitaa.ui.ProfileActivity.19
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == 1) {
                    AndroidUtilities.hideKeyboard(ProfileActivity.this.getParentActivity().getCurrentFocus());
                }
                if (ProfileActivity.this.openingAvatar && newState != 2) {
                    ProfileActivity.this.openingAvatar = false;
                }
                if (ProfileActivity.this.searchItem != null) {
                    ProfileActivity.this.scrolling = newState != 0;
                    ProfileActivity.this.searchItem.setEnabled((ProfileActivity.this.scrolling || ProfileActivity.this.isPulledDown) ? false : true);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                ProfileActivity.this.checkListViewScroll();
                if (ProfileActivity.this.participantsMap == null || ProfileActivity.this.usersEndReached || ProfileActivity.this.layoutManager.findLastVisibleItemPosition() <= ProfileActivity.this.membersEndRow - 8 || ProfileActivity.this.currentChat.default_banned_rights.view_participants) {
                    return;
                }
                ProfileActivity.this.getChannelParticipants(false);
            }
        });
        UndoView undoView = new UndoView(context);
        this.undoView = undoView;
        frameLayout.addView(undoView, LayoutHelper.createFrame(-1, -2.0f, 83, 8.0f, 0.0f, 8.0f, 8.0f));
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.expandAnimator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$PqRIUKIZI9nqB77V5wgOt3BpKPU
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.lambda$createView$13$ProfileActivity(valueAnimator);
            }
        });
        this.expandAnimator.setInterpolator(CubicBezierInterpolator.EASE_BOTH);
        this.expandAnimator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.ProfileActivity.20
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                ((BaseFragment) ProfileActivity.this).actionBar.setItemsBackgroundColor(ProfileActivity.this.isPulledDown ? 1090519039 : Theme.getColor("avatar_actionBarSelectorBlue"), false);
                ProfileActivity.this.avatarImage.clearForeground();
                ProfileActivity.this.doNotSetForeground = false;
            }
        });
        updateRowsIds();
        updateSelectedMediaTabText();
        PinchToZoomHelper pinchToZoomHelper = new PinchToZoomHelper(Build.VERSION.SDK_INT >= 21 ? (ViewGroup) getParentActivity().getWindow().getDecorView() : frameLayout) { // from class: ir.eitaa.ui.ProfileActivity.21
            Paint statusBarPaint;

            @Override // ir.eitaa.ui.PinchToZoomHelper
            protected void invalidateViews() {
                super.invalidateViews();
                ((BaseFragment) ProfileActivity.this).fragmentView.invalidate();
                for (int i5 = 0; i5 < ProfileActivity.this.avatarsViewPager.getChildCount(); i5++) {
                    ProfileActivity.this.avatarsViewPager.getChildAt(i5).invalidate();
                }
                if (ProfileActivity.this.writeButton != null) {
                    ProfileActivity.this.writeButton.invalidate();
                }
            }

            @Override // ir.eitaa.ui.PinchToZoomHelper
            protected void drawOverlays(Canvas canvas, float alpha, float parentOffsetX, float parentOffsetY, float clipTop, float clipBottom) {
                if (alpha > 0.0f) {
                    RectF rectF = AndroidUtilities.rectTmp;
                    rectF.set(0.0f, 0.0f, ProfileActivity.this.avatarsViewPager.getMeasuredWidth(), ProfileActivity.this.avatarsViewPager.getMeasuredHeight() + AndroidUtilities.dp(30.0f));
                    canvas.saveLayerAlpha(rectF, (int) (255.0f * alpha), 31);
                    ProfileActivity.this.avatarContainer2.draw(canvas);
                    if (((BaseFragment) ProfileActivity.this).actionBar.getOccupyStatusBar()) {
                        if (this.statusBarPaint == null) {
                            Paint paint = new Paint();
                            this.statusBarPaint = paint;
                            paint.setColor(ColorUtils.setAlphaComponent(-16777216, 51));
                        }
                        canvas.drawRect(((BaseFragment) ProfileActivity.this).actionBar.getX(), ((BaseFragment) ProfileActivity.this).actionBar.getY(), ((BaseFragment) ProfileActivity.this).actionBar.getX() + ((BaseFragment) ProfileActivity.this).actionBar.getMeasuredWidth(), ((BaseFragment) ProfileActivity.this).actionBar.getY() + AndroidUtilities.statusBarHeight, this.statusBarPaint);
                    }
                    canvas.save();
                    canvas.translate(((BaseFragment) ProfileActivity.this).actionBar.getX(), ((BaseFragment) ProfileActivity.this).actionBar.getY());
                    ((BaseFragment) ProfileActivity.this).actionBar.draw(canvas);
                    canvas.restore();
                    if (ProfileActivity.this.writeButton != null && ProfileActivity.this.writeButton.getVisibility() == 0 && ProfileActivity.this.writeButton.getAlpha() > 0.0f) {
                        canvas.save();
                        float f = (alpha * 0.5f) + 0.5f;
                        canvas.scale(f, f, ProfileActivity.this.writeButton.getX() + (ProfileActivity.this.writeButton.getMeasuredWidth() / 2.0f), ProfileActivity.this.writeButton.getY() + (ProfileActivity.this.writeButton.getMeasuredHeight() / 2.0f));
                        canvas.translate(ProfileActivity.this.writeButton.getX(), ProfileActivity.this.writeButton.getY());
                        ProfileActivity.this.writeButton.draw(canvas);
                        canvas.restore();
                    }
                    canvas.restore();
                }
            }

            @Override // ir.eitaa.ui.PinchToZoomHelper
            protected boolean zoomEnabled(View child, ImageReceiver receiver) {
                return super.zoomEnabled(child, receiver) && ProfileActivity.this.listView.getScrollState() != 1;
            }
        };
        this.pinchToZoomHelper = pinchToZoomHelper;
        pinchToZoomHelper.setCallback(new PinchToZoomHelper.Callback() { // from class: ir.eitaa.ui.ProfileActivity.22
            @Override // ir.eitaa.ui.PinchToZoomHelper.Callback
            public /* synthetic */ TextureView getCurrentTextureView() {
                return PinchToZoomHelper.Callback.CC.$default$getCurrentTextureView(this);
            }

            @Override // ir.eitaa.ui.PinchToZoomHelper.Callback
            public /* synthetic */ void onZoomFinished(MessageObject messageObject) {
                PinchToZoomHelper.Callback.CC.$default$onZoomFinished(this, messageObject);
            }

            @Override // ir.eitaa.ui.PinchToZoomHelper.Callback
            public void onZoomStarted(MessageObject messageObject) {
                ProfileActivity.this.listView.cancelClickRunnables(true);
                if (ProfileActivity.this.sharedMediaLayout != null && ProfileActivity.this.sharedMediaLayout.getCurrentListView() != null) {
                    ProfileActivity.this.sharedMediaLayout.getCurrentListView().cancelClickRunnables(true);
                }
                Bitmap bitmap = ProfileActivity.this.pinchToZoomHelper.getPhotoImage() == null ? null : ProfileActivity.this.pinchToZoomHelper.getPhotoImage().getBitmap();
                if (bitmap != null) {
                    ProfileActivity.this.topView.setBackgroundColor(ColorUtils.blendARGB(AndroidUtilities.calcBitmapColor(bitmap), Theme.getColor("windowBackgroundWhite"), 0.1f));
                }
            }
        });
        this.avatarsViewPager.setPinchToZoomHelper(this.pinchToZoomHelper);
        loadAds();
        return this.fragmentView;
    }

    /* renamed from: ir.eitaa.ui.ProfileActivity$4, reason: invalid class name */
    class AnonymousClass4 extends ActionBar.ActionBarMenuOnItemClick {
        AnonymousClass4() {
        }

        @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
        public void onItemClick(final int id) throws InterruptedException, Resources.NotFoundException {
            String str;
            long jMakeEncryptedDialogId;
            MessagesController messagesController;
            long j;
            if (ProfileActivity.this.getParentActivity() == null) {
                return;
            }
            if (id == -1) {
                ProfileActivity.this.finishFragment();
                return;
            }
            if (id == 2) {
                TLRPC$User user = ProfileActivity.this.getMessagesController().getUser(Long.valueOf(ProfileActivity.this.userId));
                if (user == null) {
                    return;
                }
                if (!ProfileActivity.this.isBot || MessagesController.isSupportUser(user)) {
                    if (ProfileActivity.this.userBlocked) {
                        ProfileActivity.this.getMessagesController().unblockPeer(ProfileActivity.this.userId);
                        if (BulletinFactory.canShowBulletin(ProfileActivity.this)) {
                            BulletinFactory.createBanBulletin(ProfileActivity.this, false).show();
                            return;
                        }
                        return;
                    }
                    if (ProfileActivity.this.reportSpam) {
                        ProfileActivity profileActivity = ProfileActivity.this;
                        AlertsCreator.showBlockReportSpamAlert(profileActivity, profileActivity.userId, user, null, ProfileActivity.this.currentEncryptedChat, false, null, new MessagesStorage.IntCallback() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$4$ozfSoMAqotzTuetJcO2gMTzx9Eg
                            @Override // ir.eitaa.messenger.MessagesStorage.IntCallback
                            public final void run(int i) {
                                this.f$0.lambda$onItemClick$0$ProfileActivity$4(i);
                            }
                        }, null);
                        return;
                    }
                    AlertDialog.Builder builder = new AlertDialog.Builder(ProfileActivity.this.getParentActivity());
                    builder.setTitle(LocaleController.getString("BlockUser", R.string.BlockUser));
                    builder.setMessage(AndroidUtilities.replaceTags(LocaleController.formatString("AreYouSureBlockContact2", R.string.AreYouSureBlockContact2, ContactsController.formatName(user.first_name, user.last_name))));
                    builder.setPositiveButton(LocaleController.getString("BlockContact", R.string.BlockContact), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$4$ime5wMDFySV6NwwlDfXbwb5fCi8
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.f$0.lambda$onItemClick$1$ProfileActivity$4(dialogInterface, i);
                        }
                    });
                    builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                    AlertDialog alertDialogCreate = builder.create();
                    ProfileActivity.this.showDialog(alertDialogCreate);
                    TextView textView = (TextView) alertDialogCreate.getButton(-1);
                    if (textView != null) {
                        textView.setTextColor(Theme.getColor("dialogTextRed2"));
                        return;
                    }
                    return;
                }
                if (!ProfileActivity.this.userBlocked) {
                    ProfileActivity.this.getMessagesController().blockPeer(ProfileActivity.this.userId);
                    return;
                }
                ProfileActivity.this.getMessagesController().unblockPeer(ProfileActivity.this.userId);
                ProfileActivity.this.getSendMessagesHelper().sendMessage("/start", ProfileActivity.this.userId, null, null, null, false, null, null, null, true, 0, null);
                ProfileActivity.this.finishFragment();
                return;
            }
            if (id == 1) {
                TLRPC$User user2 = ProfileActivity.this.getMessagesController().getUser(Long.valueOf(ProfileActivity.this.userId));
                Bundle bundle = new Bundle();
                bundle.putLong("user_id", user2.id);
                bundle.putBoolean("addContact", true);
                ProfileActivity.this.presentFragment(new ContactAddActivity(bundle));
                return;
            }
            if (id == 3) {
                Bundle bundle2 = new Bundle();
                bundle2.putBoolean("onlySelect", true);
                bundle2.putInt("dialogsType", 3);
                bundle2.putString("selectAlertString", LocaleController.getString("SendContactToText", R.string.SendContactToText));
                bundle2.putString("selectAlertStringGroup", LocaleController.getString("SendContactToGroupText", R.string.SendContactToGroupText));
                DialogsActivity dialogsActivity = new DialogsActivity(bundle2);
                dialogsActivity.setDelegate(ProfileActivity.this);
                ProfileActivity.this.presentFragment(dialogsActivity);
                return;
            }
            if (id == 4) {
                Bundle bundle3 = new Bundle();
                bundle3.putLong("user_id", ProfileActivity.this.userId);
                ProfileActivity.this.presentFragment(new ContactAddActivity(bundle3));
                return;
            }
            if (id == 5) {
                final TLRPC$User user3 = ProfileActivity.this.getMessagesController().getUser(Long.valueOf(ProfileActivity.this.userId));
                if (user3 == null || ProfileActivity.this.getParentActivity() == null) {
                    return;
                }
                AlertDialog.Builder builder2 = new AlertDialog.Builder(ProfileActivity.this.getParentActivity());
                builder2.setTitle(LocaleController.getString("DeleteContact", R.string.DeleteContact));
                builder2.setMessage(LocaleController.getString("AreYouSureDeleteContact", R.string.AreYouSureDeleteContact));
                builder2.setPositiveButton(LocaleController.getString("Delete", R.string.Delete), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$4$-2lVTm3pw_GSOczZwxinaeg9OOc
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onItemClick$2$ProfileActivity$4(user3, dialogInterface, i);
                    }
                });
                builder2.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                AlertDialog alertDialogCreate2 = builder2.create();
                ProfileActivity.this.showDialog(alertDialogCreate2);
                TextView textView2 = (TextView) alertDialogCreate2.getButton(-1);
                if (textView2 != null) {
                    textView2.setTextColor(Theme.getColor("dialogTextRed2"));
                    return;
                }
                return;
            }
            if (id == 7) {
                ProfileActivity.this.leaveChatPressed();
                return;
            }
            if (id == 12) {
                if (ProfileActivity.this.currentChat != null && !ChatObject.isChannel(ProfileActivity.this.currentChat) && !ProfileActivity.this.currentChat.megagroup && ProfileActivity.this.currentChat.creator) {
                    MessagesController.getInstance(((BaseFragment) ProfileActivity.this).currentAccount).convertToMegaGroup(ProfileActivity.this.getParentActivity(), ProfileActivity.this.chatId, ProfileActivity.this, null);
                }
                Bundle bundle4 = new Bundle();
                bundle4.putLong("chat_id", ProfileActivity.this.chatId);
                ChatEditActivity chatEditActivity = new ChatEditActivity(bundle4);
                chatEditActivity.setInfo(ProfileActivity.this.chatInfo);
                ProfileActivity.this.presentFragment(chatEditActivity);
                return;
            }
            if (id == 9) {
                final TLRPC$User user4 = ProfileActivity.this.getMessagesController().getUser(Long.valueOf(ProfileActivity.this.userId));
                if (user4 == null) {
                    return;
                }
                Bundle bundle5 = new Bundle();
                bundle5.putBoolean("onlySelect", true);
                bundle5.putInt("dialogsType", 2);
                bundle5.putString("addToGroupAlertString", LocaleController.formatString("AddToTheGroupAlertText", R.string.AddToTheGroupAlertText, UserObject.getUserName(user4), "%1$s"));
                DialogsActivity dialogsActivity2 = new DialogsActivity(bundle5);
                dialogsActivity2.setDelegate(new DialogsActivity.DialogsActivityDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$4$RKlJi45hz4lloQdYCOQ3okfKqk8
                    @Override // ir.eitaa.ui.DialogsActivity.DialogsActivityDelegate
                    public final void didSelectDialogs(DialogsActivity dialogsActivity3, ArrayList arrayList, CharSequence charSequence, boolean z) {
                        this.f$0.lambda$onItemClick$3$ProfileActivity$4(user4, dialogsActivity3, arrayList, charSequence, z);
                    }
                });
                ProfileActivity.this.presentFragment(dialogsActivity2);
                return;
            }
            if (id == 10) {
                try {
                    if (ProfileActivity.this.userId != 0) {
                        TLRPC$User user5 = ProfileActivity.this.getMessagesController().getUser(Long.valueOf(ProfileActivity.this.userId));
                        if (user5 == null) {
                            return;
                        }
                        if (ProfileActivity.this.botInfo != null && ProfileActivity.this.userInfo != null && !TextUtils.isEmpty(ProfileActivity.this.userInfo.about)) {
                            str = String.format("%s https://" + ProfileActivity.this.getMessagesController().linkPrefix + "/%s", ProfileActivity.this.userInfo.about, user5.username);
                        } else {
                            str = String.format("https://" + ProfileActivity.this.getMessagesController().linkPrefix + "/%s", user5.username);
                        }
                        absolutePath = str;
                    } else if (ProfileActivity.this.chatId != 0) {
                        TLRPC$Chat chat = ProfileActivity.this.getMessagesController().getChat(Long.valueOf(ProfileActivity.this.chatId));
                        if (chat == null) {
                            return;
                        }
                        if (ProfileActivity.this.chatInfo != null && !TextUtils.isEmpty(ProfileActivity.this.chatInfo.about)) {
                            absolutePath = String.format("%s\nhttps://" + ProfileActivity.this.getMessagesController().linkPrefix + "/%s", ProfileActivity.this.chatInfo.about, chat.username);
                        } else {
                            absolutePath = String.format("https://" + ProfileActivity.this.getMessagesController().linkPrefix + "/%s", chat.username);
                        }
                    }
                    if (TextUtils.isEmpty(absolutePath)) {
                        return;
                    }
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.setType("text/plain");
                    intent.putExtra("android.intent.extra.TEXT", absolutePath);
                    ProfileActivity.this.startActivityForResult(Intent.createChooser(intent, LocaleController.getString("BotShare", R.string.BotShare)), 500);
                    return;
                } catch (Exception e) {
                    FileLog.e(e);
                    return;
                }
            }
            if (id == 14) {
                try {
                    if (ProfileActivity.this.currentEncryptedChat != null) {
                        jMakeEncryptedDialogId = DialogObject.makeEncryptedDialogId(ProfileActivity.this.currentEncryptedChat.id);
                    } else if (ProfileActivity.this.userId != 0) {
                        jMakeEncryptedDialogId = ProfileActivity.this.userId;
                    } else if (ProfileActivity.this.chatId == 0) {
                        return;
                    } else {
                        jMakeEncryptedDialogId = -ProfileActivity.this.chatId;
                    }
                    ProfileActivity.this.getMediaDataController().installShortcut(jMakeEncryptedDialogId);
                    return;
                } catch (Exception e2) {
                    FileLog.e(e2);
                    return;
                }
            }
            if (id == 37) {
                if (MessagesController.getInstance(((BaseFragment) ProfileActivity.this).currentAccount).isDialogFavorite(ProfileActivity.this.selectedDialogs)) {
                    MessagesController.getInstance(((BaseFragment) ProfileActivity.this).currentAccount).setDialogFavorites(ProfileActivity.this.selectedDialogs, false);
                    MessagesController.getInstance(((BaseFragment) ProfileActivity.this).currentAccount).sortDialogs(null);
                    ProfileActivity.this.getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, Boolean.TRUE);
                    new Handler().postDelayed(new Runnable() { // from class: ir.eitaa.ui.ProfileActivity.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ProfileActivity.this.createActionBarMenu(false);
                        }
                    }, 1000L);
                    return;
                }
                MessagesController.getInstance(((BaseFragment) ProfileActivity.this).currentAccount).setDialogFavorites(ProfileActivity.this.selectedDialogs, true);
                MessagesController.getInstance(((BaseFragment) ProfileActivity.this).currentAccount).sortDialogs(null);
                ProfileActivity.this.getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, Boolean.TRUE);
                new Handler().postDelayed(new Runnable() { // from class: ir.eitaa.ui.ProfileActivity.4.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ProfileActivity.this.createActionBarMenu(false);
                    }
                }, 1000L);
                return;
            }
            if (id == 15 || id == 16) {
                if (ProfileActivity.this.userId != 0) {
                    TLRPC$User user6 = ProfileActivity.this.getMessagesController().getUser(Long.valueOf(ProfileActivity.this.userId));
                    if (user6 != null) {
                        VoIPHelper.startCall(user6, id == 16, ProfileActivity.this.userInfo != null && ProfileActivity.this.userInfo.video_calls_available, ProfileActivity.this.getParentActivity(), ProfileActivity.this.userInfo, ProfileActivity.this.getAccountInstance());
                        return;
                    }
                    return;
                }
                if (ProfileActivity.this.chatId != 0) {
                    if (ProfileActivity.this.getMessagesController().getGroupCall(ProfileActivity.this.chatId, false) != null) {
                        TLRPC$Chat tLRPC$Chat = ProfileActivity.this.currentChat;
                        Activity parentActivity = ProfileActivity.this.getParentActivity();
                        ProfileActivity profileActivity2 = ProfileActivity.this;
                        VoIPHelper.startCall(tLRPC$Chat, null, null, false, parentActivity, profileActivity2, profileActivity2.getAccountInstance());
                        return;
                    }
                    ProfileActivity profileActivity3 = ProfileActivity.this;
                    VoIPHelper.showGroupCallAlert(profileActivity3, profileActivity3.currentChat, null, false, ProfileActivity.this.getAccountInstance());
                    return;
                }
                return;
            }
            if (id == 17) {
                Bundle bundle6 = new Bundle();
                bundle6.putLong("chat_id", ProfileActivity.this.chatId);
                bundle6.putInt("type", 2);
                bundle6.putBoolean("open_search", true);
                ChatUsersActivity chatUsersActivity = new ChatUsersActivity(bundle6);
                chatUsersActivity.setInfo(ProfileActivity.this.chatInfo);
                ProfileActivity.this.presentFragment(chatUsersActivity);
                return;
            }
            if (id == 1373) {
                AlertDialog.Builder builder3 = new AlertDialog.Builder(ProfileActivity.this.getParentActivity());
                builder3.setMessage(LocaleController.getString("ConvertGroupAlert", R.string.ConvertGroupAlert));
                builder3.setTitle(LocaleController.getString("ConvertGroupAlertWarning", R.string.ConvertGroupAlertWarning));
                builder3.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.ProfileActivity.4.3
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MessagesController.getInstance(((BaseFragment) ProfileActivity.this).currentAccount).convertToMegaGroup(ProfileActivity.this.getParentActivity(), ProfileActivity.this.chatId, ProfileActivity.this, null);
                    }
                });
                builder3.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                ProfileActivity.this.showDialog(builder3.create());
                return;
            }
            if (id == 18) {
                ProfileActivity.this.openAddMember();
                return;
            }
            if (id == 19) {
                TLRPC$Chat chat2 = ProfileActivity.this.getMessagesController().getChat(Long.valueOf(ProfileActivity.this.chatId));
                Bundle bundle7 = new Bundle();
                bundle7.putLong("chat_id", ProfileActivity.this.chatId);
                bundle7.putBoolean("is_megagroup", chat2.megagroup);
                ProfileActivity.this.presentFragment(new StatisticActivity(bundle7));
                return;
            }
            if (id == 22) {
                ProfileActivity.this.openDiscussion();
                return;
            }
            if (id == 20) {
                AlertDialog.Builder builder4 = new AlertDialog.Builder(ProfileActivity.this.getParentActivity());
                builder4.setTitle(LocaleController.getString("AreYouSureSecretChatTitle", R.string.AreYouSureSecretChatTitle));
                builder4.setMessage(LocaleController.getString("AreYouSureSecretChat", R.string.AreYouSureSecretChat));
                builder4.setPositiveButton(LocaleController.getString("Start", R.string.Start), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$4$rUdKMvdkRx33UsnJdpspxVp5WGo
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onItemClick$4$ProfileActivity$4(dialogInterface, i);
                    }
                });
                builder4.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                ProfileActivity.this.showDialog(builder4.create());
                return;
            }
            if (id == 21) {
                if (ProfileActivity.this.getParentActivity() == null) {
                    return;
                }
                int i = Build.VERSION.SDK_INT;
                if (i < 23 || ((i > 28 && !BuildVars.NO_SCOPED_STORAGE) || ProfileActivity.this.getParentActivity().checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0)) {
                    ImageLocation imageLocation = ProfileActivity.this.avatarsViewPager.getImageLocation(ProfileActivity.this.avatarsViewPager.getRealPosition());
                    if (imageLocation == null) {
                        return;
                    }
                    final boolean z = imageLocation.imageType == 2;
                    File pathToAttach = FileLoader.getPathToAttach(imageLocation.location, z ? "mp4" : null, true);
                    if (pathToAttach.exists()) {
                        MediaController.saveFile(pathToAttach.toString(), ProfileActivity.this.getParentActivity(), 0, null, null, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$4$MWYMWM8mbF0_83W2-Uy8tVDL0Oc
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$onItemClick$5$ProfileActivity$4(z);
                            }
                        });
                        return;
                    }
                    return;
                }
                ProfileActivity.this.getParentActivity().requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 4);
                return;
            }
            if (id == 30) {
                ProfileActivity.this.presentFragment(new ChangeNameActivity());
                return;
            }
            if (id == 31) {
                ProfileActivity.this.presentFragment(new LogoutActivity());
                return;
            }
            if (id == 34) {
                int realPosition = ProfileActivity.this.avatarsViewPager.getRealPosition();
                ImageLocation imageLocation2 = ProfileActivity.this.avatarsViewPager.getImageLocation(realPosition);
                if (imageLocation2 == null) {
                    return;
                }
                File pathToAttach2 = FileLoader.getPathToAttach(PhotoViewer.getFileLocation(imageLocation2), PhotoViewer.getFileLocationExt(imageLocation2), true);
                boolean z2 = imageLocation2.imageType == 2;
                if (z2) {
                    ImageLocation realImageLocation = ProfileActivity.this.avatarsViewPager.getRealImageLocation(realPosition);
                    absolutePath = FileLoader.getPathToAttach(PhotoViewer.getFileLocation(realImageLocation), PhotoViewer.getFileLocationExt(realImageLocation), true).getAbsolutePath();
                }
                ProfileActivity.this.imageUpdater.openPhotoForEdit(pathToAttach2.getAbsolutePath(), absolutePath, 0, z2);
                return;
            }
            if (id == 35) {
                AlertDialog.Builder builder5 = new AlertDialog.Builder(ProfileActivity.this.getParentActivity());
                ImageLocation imageLocation3 = ProfileActivity.this.avatarsViewPager.getImageLocation(ProfileActivity.this.avatarsViewPager.getRealPosition());
                if (imageLocation3 == null) {
                    return;
                }
                if (imageLocation3.imageType == 2) {
                    builder5.setTitle(LocaleController.getString("AreYouSureDeleteVideoTitle", R.string.AreYouSureDeleteVideoTitle));
                    builder5.setMessage(LocaleController.formatString("AreYouSureDeleteVideo", R.string.AreYouSureDeleteVideo, new Object[0]));
                } else {
                    builder5.setTitle(LocaleController.getString("AreYouSureDeletePhotoTitle", R.string.AreYouSureDeletePhotoTitle));
                    builder5.setMessage(LocaleController.formatString("AreYouSureDeletePhoto", R.string.AreYouSureDeletePhoto, new Object[0]));
                }
                builder5.setPositiveButton(LocaleController.getString("Delete", R.string.Delete), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$4$uowFlyoHJFdxmbWpD1xbf-8xdU8
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onItemClick$6$ProfileActivity$4(dialogInterface, i2);
                    }
                });
                builder5.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                AlertDialog alertDialogCreate3 = builder5.create();
                ProfileActivity.this.showDialog(alertDialogCreate3);
                TextView textView3 = (TextView) alertDialogCreate3.getButton(-1);
                if (textView3 != null) {
                    textView3.setTextColor(Theme.getColor("dialogTextRed2"));
                    return;
                }
                return;
            }
            if (id == 36) {
                ProfileActivity.this.onWriteButtonClick();
                return;
            }
            if (id == 44) {
                Bundle bundle8 = new Bundle();
                bundle8.putString("link", "https://pay.eitaa.com/report");
                if (ProfileActivity.this.currentChat != null) {
                    messagesController = ProfileActivity.this.getMessagesController();
                    j = -ProfileActivity.this.currentChat.id;
                } else {
                    messagesController = ProfileActivity.this.getMessagesController();
                    long j2 = ProfileActivity.this.chatId;
                    ProfileActivity profileActivity4 = ProfileActivity.this;
                    j = j2 == 0 ? profileActivity4.userId : profileActivity4.chatId;
                }
                TLRPC$Peer peer = messagesController.getPeer(j);
                SerializedData serializedData = new SerializedData(peer.getObjectSize());
                peer.serializeToStream(serializedData);
                bundle8.putByteArray("peer", serializedData.toByteArray());
                ProfileActivity.this.presentFragment(new PaymentActivity(bundle8));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onItemClick$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onItemClick$0$ProfileActivity$4(int i) {
            if (i == 1) {
                NotificationCenter notificationCenter = ProfileActivity.this.getNotificationCenter();
                ProfileActivity profileActivity = ProfileActivity.this;
                int i2 = NotificationCenter.closeChats;
                notificationCenter.removeObserver(profileActivity, i2);
                ProfileActivity.this.getNotificationCenter().postNotificationName(i2, new Object[0]);
                ProfileActivity.this.playProfileAnimation = 0;
                ProfileActivity.this.finishFragment();
                return;
            }
            ProfileActivity.this.getNotificationCenter().postNotificationName(NotificationCenter.peerSettingsDidLoad, Long.valueOf(ProfileActivity.this.userId));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onItemClick$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onItemClick$1$ProfileActivity$4(DialogInterface dialogInterface, int i) {
            ProfileActivity.this.getMessagesController().blockPeer(ProfileActivity.this.userId);
            if (BulletinFactory.canShowBulletin(ProfileActivity.this)) {
                BulletinFactory.createBanBulletin(ProfileActivity.this, true).show();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onItemClick$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onItemClick$2$ProfileActivity$4(TLRPC$User tLRPC$User, DialogInterface dialogInterface, int i) {
            ArrayList<TLRPC$User> arrayList = new ArrayList<>();
            arrayList.add(tLRPC$User);
            ProfileActivity.this.getContactsController().deleteContact(arrayList, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onItemClick$3, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onItemClick$3$ProfileActivity$4(TLRPC$User tLRPC$User, DialogsActivity dialogsActivity, ArrayList arrayList, CharSequence charSequence, boolean z) {
            long jLongValue = ((Long) arrayList.get(0)).longValue();
            Bundle bundle = new Bundle();
            bundle.putBoolean("scrollToTopOnResume", true);
            long j = -jLongValue;
            bundle.putLong("chat_id", j);
            if (ProfileActivity.this.getMessagesController().checkCanOpenChat(bundle, dialogsActivity)) {
                NotificationCenter notificationCenter = ProfileActivity.this.getNotificationCenter();
                ProfileActivity profileActivity = ProfileActivity.this;
                int i = NotificationCenter.closeChats;
                notificationCenter.removeObserver(profileActivity, i);
                ProfileActivity.this.getNotificationCenter().postNotificationName(i, new Object[0]);
                ProfileActivity.this.getMessagesController().addUserToChat(j, tLRPC$User, 0, null, ProfileActivity.this, null);
                ProfileActivity.this.presentFragment(new ChatActivity(bundle), true);
                ProfileActivity.this.removeSelfFromStack();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onItemClick$4, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onItemClick$4$ProfileActivity$4(DialogInterface dialogInterface, int i) {
            ProfileActivity.this.creatingChat = true;
            ProfileActivity.this.getSecretChatHelper().startSecretChat(ProfileActivity.this.getParentActivity(), ProfileActivity.this.getMessagesController().getUser(Long.valueOf(ProfileActivity.this.userId)));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onItemClick$5, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onItemClick$5$ProfileActivity$4(boolean z) {
            if (ProfileActivity.this.getParentActivity() == null) {
                return;
            }
            BulletinFactory.createSaveToGalleryBulletin(ProfileActivity.this, z, null).show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onItemClick$6, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onItemClick$6$ProfileActivity$4(DialogInterface dialogInterface, int i) {
            int realPosition = ProfileActivity.this.avatarsViewPager.getRealPosition();
            TLRPC$Photo photo = ProfileActivity.this.avatarsViewPager.getPhoto(realPosition);
            if (ProfileActivity.this.avatarsViewPager.getRealCount() == 1) {
                ProfileActivity.this.setForegroundImage(true);
            }
            if (photo == null || ProfileActivity.this.avatarsViewPager.getRealPosition() == 0) {
                ProfileActivity.this.getMessagesController().deleteUserPhoto(null);
            } else {
                TLRPC$TL_inputPhoto tLRPC$TL_inputPhoto = new TLRPC$TL_inputPhoto();
                tLRPC$TL_inputPhoto.id = photo.id;
                tLRPC$TL_inputPhoto.access_hash = photo.access_hash;
                byte[] bArr = photo.file_reference;
                tLRPC$TL_inputPhoto.file_reference = bArr;
                if (bArr == null) {
                    tLRPC$TL_inputPhoto.file_reference = new byte[0];
                }
                ProfileActivity.this.getMessagesController().deleteUserPhoto(tLRPC$TL_inputPhoto);
                ProfileActivity.this.getMessagesStorage().clearUserPhoto(ProfileActivity.this.userId, photo.id);
            }
            if (ProfileActivity.this.avatarsViewPager.removePhotoAtIndex(realPosition)) {
                ProfileActivity.this.avatarsViewPager.setVisibility(8);
                ProfileActivity.this.avatarImage.setForegroundAlpha(1.0f);
                ProfileActivity.this.avatarContainer.setVisibility(0);
                ProfileActivity.this.doNotSetForeground = true;
                View viewFindViewByPosition = ProfileActivity.this.layoutManager.findViewByPosition(0);
                if (viewFindViewByPosition != null) {
                    ProfileActivity.this.listView.smoothScrollBy(0, viewFindViewByPosition.getTop() - AndroidUtilities.dp(88.0f), CubicBezierInterpolator.EASE_OUT_QUINT);
                }
            }
        }
    }

    /* renamed from: ir.eitaa.ui.ProfileActivity$7, reason: invalid class name */
    class AnonymousClass7 extends NestedFrameLayout {
        private Paint grayPaint;
        private boolean ignoreLayout;
        private final ArrayList<View> sortedChildren;
        private final Comparator<View> viewComparator;

        @Override // android.view.View
        public boolean hasOverlappingRendering() {
            return false;
        }

        AnonymousClass7(Context context) {
            super(context);
            this.grayPaint = new Paint();
            this.sortedChildren = new ArrayList<>();
            this.viewComparator = $$Lambda$ProfileActivity$7$FLeEkuv7xx7Pf4IVAWRG2cZ7bcY.INSTANCE;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent ev) {
            if (ProfileActivity.this.pinchToZoomHelper.isInOverlayMode()) {
                return ProfileActivity.this.pinchToZoomHelper.onTouchEvent(ev);
            }
            return super.dispatchTouchEvent(ev);
        }

        /* JADX WARN: Removed duplicated region for block: B:130:0x045c  */
        /* JADX WARN: Removed duplicated region for block: B:132:0x0467  */
        @Override // android.widget.FrameLayout, android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected void onMeasure(int r18, int r19) {
            /*
                Method dump skipped, instructions count: 1182
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ProfileActivity.AnonymousClass7.onMeasure(int, int):void");
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
            super.onLayout(changed, left, top, right, bottom);
            ProfileActivity profileActivity = ProfileActivity.this;
            profileActivity.savedScrollPosition = -1;
            profileActivity.firstLayout = false;
            ProfileActivity.this.invalidateScroll = false;
            ProfileActivity.this.checkListViewScroll();
        }

        @Override // android.view.View, android.view.ViewParent
        public void requestLayout() {
            if (this.ignoreLayout) {
                return;
            }
            super.requestLayout();
        }

        static /* synthetic */ int lambda$$0(View view, View view2) {
            return (int) (view.getY() - view2.getY());
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            FragmentContextView fragmentContextView;
            boolean z;
            int i;
            ProfileActivity.this.whitePaint.setColor(Theme.getColor("windowBackgroundWhite"));
            if (ProfileActivity.this.listView.getVisibility() != 0) {
                canvas.drawRect(0.0f, ProfileActivity.this.searchListView.getTop() + ProfileActivity.this.extraHeight + ProfileActivity.this.searchTransitionOffset, getMeasuredWidth(), r1 + getMeasuredHeight(), ProfileActivity.this.whitePaint);
            } else {
                this.grayPaint.setColor(Theme.getColor("windowBackgroundGray"));
                if (ProfileActivity.this.transitionAnimationInProress) {
                    ProfileActivity.this.whitePaint.setAlpha((int) (ProfileActivity.this.listView.getAlpha() * 255.0f));
                }
                if (ProfileActivity.this.transitionAnimationInProress) {
                    this.grayPaint.setAlpha((int) (ProfileActivity.this.listView.getAlpha() * 255.0f));
                }
                int childCount = ProfileActivity.this.listView.getChildCount();
                this.sortedChildren.clear();
                boolean z2 = false;
                for (int i2 = 0; i2 < childCount; i2++) {
                    if (ProfileActivity.this.listView.getChildAdapterPosition(ProfileActivity.this.listView.getChildAt(i2)) != -1) {
                        this.sortedChildren.add(ProfileActivity.this.listView.getChildAt(i2));
                    } else {
                        z2 = true;
                    }
                }
                Collections.sort(this.sortedChildren, this.viewComparator);
                float y = ProfileActivity.this.listView.getY();
                int size = this.sortedChildren.size();
                if (!ProfileActivity.this.openAnimationInProgress && size > 0 && !z2) {
                    y += this.sortedChildren.get(0).getY();
                }
                float f = y;
                boolean z3 = false;
                float alpha = 1.0f;
                for (int i3 = 0; i3 < size; i3++) {
                    View view = this.sortedChildren.get(i3);
                    boolean z4 = view.getBackground() != null;
                    int y2 = (int) (ProfileActivity.this.listView.getY() + view.getY());
                    if (z3 != z4) {
                        if (z3) {
                            z = z4;
                            canvas.drawRect(ProfileActivity.this.listView.getX(), f, ProfileActivity.this.listView.getX() + ProfileActivity.this.listView.getMeasuredWidth(), y2, this.grayPaint);
                            i = y2;
                        } else {
                            z = z4;
                            if (alpha != 1.0f) {
                                float f2 = y2;
                                i = y2;
                                canvas.drawRect(ProfileActivity.this.listView.getX(), f, ProfileActivity.this.listView.getX() + ProfileActivity.this.listView.getMeasuredWidth(), f2, this.grayPaint);
                                ProfileActivity.this.whitePaint.setAlpha((int) (alpha * 255.0f));
                                canvas.drawRect(ProfileActivity.this.listView.getX(), f, ProfileActivity.this.listView.getX() + ProfileActivity.this.listView.getMeasuredWidth(), f2, ProfileActivity.this.whitePaint);
                                ProfileActivity.this.whitePaint.setAlpha(255);
                            } else {
                                i = y2;
                                canvas.drawRect(ProfileActivity.this.listView.getX(), f, ProfileActivity.this.listView.getX() + ProfileActivity.this.listView.getMeasuredWidth(), i, ProfileActivity.this.whitePaint);
                            }
                        }
                        f = i;
                        alpha = view.getAlpha();
                        z3 = z;
                    } else if (view.getAlpha() == 1.0f) {
                        alpha = 1.0f;
                    }
                }
                if (z3) {
                    canvas.drawRect(ProfileActivity.this.listView.getX(), f, ProfileActivity.this.listView.getX() + ProfileActivity.this.listView.getMeasuredWidth(), ProfileActivity.this.listView.getBottom(), this.grayPaint);
                } else if (alpha != 1.0f) {
                    canvas.drawRect(ProfileActivity.this.listView.getX(), f, ProfileActivity.this.listView.getX() + ProfileActivity.this.listView.getMeasuredWidth(), ProfileActivity.this.listView.getBottom(), this.grayPaint);
                    ProfileActivity.this.whitePaint.setAlpha((int) (alpha * 255.0f));
                    canvas.drawRect(ProfileActivity.this.listView.getX(), f, ProfileActivity.this.listView.getX() + ProfileActivity.this.listView.getMeasuredWidth(), ProfileActivity.this.listView.getBottom(), ProfileActivity.this.whitePaint);
                    ProfileActivity.this.whitePaint.setAlpha(255);
                } else {
                    canvas.drawRect(ProfileActivity.this.listView.getX(), f, ProfileActivity.this.listView.getX() + ProfileActivity.this.listView.getMeasuredWidth(), ProfileActivity.this.listView.getBottom(), ProfileActivity.this.whitePaint);
                }
            }
            super.dispatchDraw(canvas);
            ProfileActivity profileActivity = ProfileActivity.this;
            if (!profileActivity.profileTransitionInProgress || ((BaseFragment) profileActivity).parentLayout.fragmentsStack.size() <= 1) {
                return;
            }
            BaseFragment baseFragment = ((BaseFragment) ProfileActivity.this).parentLayout.fragmentsStack.get(((BaseFragment) ProfileActivity.this).parentLayout.fragmentsStack.size() - 2);
            if ((baseFragment instanceof ChatActivity) && (fragmentContextView = ((ChatActivity) baseFragment).getFragmentContextView()) != null && fragmentContextView.isCallStyle()) {
                float fDpf2 = ProfileActivity.this.extraHeight / AndroidUtilities.dpf2(fragmentContextView.getStyleHeight());
                float f3 = fDpf2 <= 1.0f ? fDpf2 : 1.0f;
                canvas.save();
                canvas.translate(fragmentContextView.getX(), fragmentContextView.getY());
                fragmentContextView.setDrawOverlay(true);
                fragmentContextView.setCollapseTransition(true, ProfileActivity.this.extraHeight, f3);
                fragmentContextView.draw(canvas);
                fragmentContextView.setCollapseTransition(false, ProfileActivity.this.extraHeight, f3);
                fragmentContextView.setDrawOverlay(false);
                canvas.restore();
            }
        }

        @Override // android.view.ViewGroup
        protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
            if (ProfileActivity.this.pinchToZoomHelper.isInOverlayMode() && (child == ProfileActivity.this.avatarContainer2 || child == ((BaseFragment) ProfileActivity.this).actionBar || child == ProfileActivity.this.writeButton)) {
                return true;
            }
            return super.drawChild(canvas, child, drawingTime);
        }
    }

    /* renamed from: ir.eitaa.ui.ProfileActivity$9, reason: invalid class name */
    class AnonymousClass9 extends DefaultItemAnimator {
        int animationIndex = -1;

        @Override // androidx.recyclerview.widget.DefaultItemAnimator
        protected long getAddAnimationDelay(long removeDuration, long moveDuration, long changeDuration) {
            return 0L;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
        public long getAddDuration() {
            return 220L;
        }

        @Override // androidx.recyclerview.widget.DefaultItemAnimator
        protected long getMoveAnimationDelay() {
            return 0L;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
        public long getMoveDuration() {
            return 220L;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
        public long getRemoveDuration() {
            return 220L;
        }

        AnonymousClass9() {
        }

        @Override // androidx.recyclerview.widget.DefaultItemAnimator
        protected void onAllAnimationsDone() {
            super.onAllAnimationsDone();
            ProfileActivity.this.getNotificationCenter().onAnimationFinish(this.animationIndex);
        }

        @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.RecyclerView.ItemAnimator
        public void runPendingAnimations() {
            boolean z = !this.mPendingRemovals.isEmpty();
            boolean z2 = !this.mPendingMoves.isEmpty();
            boolean z3 = !this.mPendingChanges.isEmpty();
            boolean z4 = !this.mPendingAdditions.isEmpty();
            if (z || z2 || z4 || z3) {
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$9$eUnfc9qtYKeYjZkUZWSv5eMeSdk
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        this.f$0.lambda$runPendingAnimations$0$ProfileActivity$9(valueAnimator);
                    }
                });
                valueAnimatorOfFloat.setDuration(getMoveDuration());
                valueAnimatorOfFloat.start();
                this.animationIndex = ProfileActivity.this.getNotificationCenter().setAnimationInProgress(this.animationIndex, null);
            }
            super.runPendingAnimations();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$runPendingAnimations$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$runPendingAnimations$0$ProfileActivity$9(ValueAnimator valueAnimator) {
            ProfileActivity.this.listView.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$3$ProfileActivity(long j, View view, int i, float f, float f2) throws Resources.NotFoundException, IOException {
        TLRPC$ChatParticipant tLRPC$ChatParticipant;
        if (getParentActivity() == null) {
            return;
        }
        if (i == this.settingsKeyRow) {
            Bundle bundle = new Bundle();
            bundle.putInt("chat_id", DialogObject.getEncryptedChatId(this.dialogId));
            presentFragment(new IdenticonActivity(bundle));
            return;
        }
        if (i == this.settingsTimerRow) {
            showDialog(AlertsCreator.createTTLAlert(getParentActivity(), this.currentEncryptedChat, null).create());
            return;
        }
        if (i == this.notificationsRow) {
            if ((LocaleController.isRTL && f <= AndroidUtilities.dp(76.0f)) || (!LocaleController.isRTL && f >= view.getMeasuredWidth() - AndroidUtilities.dp(76.0f))) {
                NotificationsCheckCell notificationsCheckCell = (NotificationsCheckCell) view;
                boolean z = !notificationsCheckCell.isChecked();
                boolean zIsGlobalNotificationsEnabled = getNotificationsController().isGlobalNotificationsEnabled(j);
                long j2 = 0;
                if (z) {
                    SharedPreferences.Editor editorEdit = MessagesController.getNotificationsSettings(this.currentAccount).edit();
                    if (zIsGlobalNotificationsEnabled) {
                        editorEdit.remove("notify2_" + j);
                    } else {
                        editorEdit.putInt("notify2_" + j, 0);
                    }
                    getMessagesStorage().setDialogNotificationFlags(j, 0L);
                    editorEdit.commit();
                    TLRPC$Dialog tLRPC$Dialog = getMessagesController().dialogs_dict.get(j);
                    if (tLRPC$Dialog != null) {
                        tLRPC$Dialog.notify_settings = new TLRPC$TL_peerNotifySettings();
                    }
                } else {
                    SharedPreferences.Editor editorEdit2 = MessagesController.getNotificationsSettings(this.currentAccount).edit();
                    if (!zIsGlobalNotificationsEnabled) {
                        editorEdit2.remove("notify2_" + j);
                    } else {
                        editorEdit2.putInt("notify2_" + j, 2);
                        j2 = 1;
                    }
                    getNotificationsController().removeNotificationsForDialog(j);
                    getMessagesStorage().setDialogNotificationFlags(j, j2);
                    editorEdit2.commit();
                    TLRPC$Dialog tLRPC$Dialog2 = getMessagesController().dialogs_dict.get(j);
                    if (tLRPC$Dialog2 != null) {
                        TLRPC$TL_peerNotifySettings tLRPC$TL_peerNotifySettings = new TLRPC$TL_peerNotifySettings();
                        tLRPC$Dialog2.notify_settings = tLRPC$TL_peerNotifySettings;
                        if (zIsGlobalNotificationsEnabled) {
                            tLRPC$TL_peerNotifySettings.mute_until = ConnectionsManager.DEFAULT_DATACENTER_ID;
                        }
                    }
                }
                getNotificationsController().updateServerNotificationsSettings(j);
                notificationsCheckCell.setChecked(z);
                RecyclerListView.Holder holder = (RecyclerListView.Holder) this.listView.findViewHolderForPosition(this.notificationsRow);
                if (holder != null) {
                    this.listAdapter.onBindViewHolder(holder, this.notificationsRow);
                    return;
                }
                return;
            }
            AlertsCreator.showCustomNotificationsDialog(this, j, -1, null, this.currentAccount, new MessagesStorage.IntCallback() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$CG17h69sodv2eTyvBMKmkaqQEz4
                @Override // ir.eitaa.messenger.MessagesStorage.IntCallback
                public final void run(int i2) {
                    this.f$0.lambda$createView$1$ProfileActivity(i2);
                }
            });
            return;
        }
        if (i == this.unblockRow) {
            getMessagesController().unblockPeer(this.userId);
            if (BulletinFactory.canShowBulletin(this)) {
                BulletinFactory.createBanBulletin(this, false).show();
                return;
            }
            return;
        }
        if (i == this.sendMessageRow) {
            onWriteButtonClick();
            return;
        }
        if (i == this.reportRow) {
            AlertsCreator.createEitaaReportAlert(getParentActivity(), getDialogId(), 0, this);
            return;
        }
        if (i >= this.membersStartRow && i < this.membersEndRow) {
            if (!this.sortedUsers.isEmpty()) {
                tLRPC$ChatParticipant = this.chatInfo.participants.participants.get(this.sortedUsers.get(i - this.membersStartRow).intValue());
            } else {
                tLRPC$ChatParticipant = this.chatInfo.participants.participants.get(i - this.membersStartRow);
            }
            onMemberClick(tLRPC$ChatParticipant, false);
            return;
        }
        if (i == this.addMemberRow) {
            openAddMember();
            return;
        }
        if (i == this.usernameRow) {
            if (this.currentChat != null) {
                try {
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.setType("text/plain");
                    if (!TextUtils.isEmpty(this.chatInfo.about)) {
                        intent.putExtra("android.intent.extra.TEXT", this.currentChat.title + "\n" + this.chatInfo.about + "\nhttps://" + getMessagesController().linkPrefix + "/" + this.currentChat.username);
                    } else {
                        intent.putExtra("android.intent.extra.TEXT", this.currentChat.title + "\nhttps://" + getMessagesController().linkPrefix + "/" + this.currentChat.username);
                    }
                    getParentActivity().startActivityForResult(Intent.createChooser(intent, LocaleController.getString("BotShare", R.string.BotShare)), 500);
                    return;
                } catch (Exception e) {
                    FileLog.e(e);
                    return;
                }
            }
            return;
        }
        if (i == this.locationRow) {
            if (this.chatInfo.location instanceof TLRPC$TL_channelLocation) {
                presentFragment(new LocationActivity(5));
                return;
            }
            return;
        }
        if (i == this.joinRow) {
            getMessagesController().addUserToChat(this.currentChat.id, getUserConfig().getCurrentUser(), 0, null, this, null);
            NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.closeSearchByActiveAction, new Object[0]);
            return;
        }
        if (i == this.subscribersRow) {
            Bundle bundle2 = new Bundle();
            bundle2.putLong("chat_id", this.chatId);
            bundle2.putInt("type", 2);
            ChatUsersActivity chatUsersActivity = new ChatUsersActivity(bundle2);
            chatUsersActivity.setInfo(this.chatInfo);
            presentFragment(chatUsersActivity);
            return;
        }
        if (i == this.administratorsRow) {
            Bundle bundle3 = new Bundle();
            bundle3.putLong("chat_id", this.chatId);
            bundle3.putInt("type", 1);
            ChatUsersActivity chatUsersActivity2 = new ChatUsersActivity(bundle3);
            chatUsersActivity2.setInfo(this.chatInfo);
            presentFragment(chatUsersActivity2);
            return;
        }
        if (i == this.blockedUsersRow) {
            Bundle bundle4 = new Bundle();
            bundle4.putLong("chat_id", this.chatId);
            bundle4.putInt("type", 0);
            ChatUsersActivity chatUsersActivity3 = new ChatUsersActivity(bundle4);
            chatUsersActivity3.setInfo(this.chatInfo);
            presentFragment(chatUsersActivity3);
            return;
        }
        if (i == this.notificationRow) {
            presentFragment(new NotificationsSettingsActivity());
            return;
        }
        if (i == this.privacyRow) {
            presentFragment(new PrivacySettingsActivity());
            return;
        }
        if (i == this.dataRow) {
            presentFragment(new DataSettingsActivity());
            return;
        }
        if (i == this.chatRow) {
            presentFragment(new ThemeActivity(0));
            return;
        }
        if (i == this.filtersRow) {
            presentFragment(new FiltersSetupActivity());
            return;
        }
        if (i == this.devicesRow) {
            presentFragment(new SessionsActivity(0));
            return;
        }
        if (i == this.questionRow) {
            Browser.openUrl(getParentActivity(), "https://eitaa.com/Eitaa_FAQ/3");
            return;
        }
        if (i == this.faqRow) {
            Browser.openUrl(getParentActivity(), LocaleController.getString("EitaaFaqUrl", R.string.EitaaFaqUrl));
            return;
        }
        if (i == this.policyRow) {
            Browser.openUrl(getParentActivity(), LocaleController.getString("PrivacyPolicyUrl", R.string.PrivacyPolicyUrl));
            return;
        }
        if (i == this.sendLogsRow) {
            sendLogs(false);
            return;
        }
        if (i == this.sendLastLogsRow) {
            sendLogs(true);
            return;
        }
        if (i == this.clearLogsRow) {
            FileLog.cleanupLogs();
            return;
        }
        if (i == this.switchBackendRow) {
            if (getParentActivity() == null) {
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
            builder.setMessage(LocaleController.getString("AreYouSure", R.string.AreYouSure));
            builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
            builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$LWouFvmEBKiExahTkSVFnm4YWwk
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) throws IOException {
                    this.f$0.lambda$createView$2$ProfileActivity(dialogInterface, i2);
                }
            });
            builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            showDialog(builder.create());
            return;
        }
        if (i == this.languageRow) {
            presentFragment(new LanguageSelectActivity());
            return;
        }
        if (i == this.setUsernameRow) {
            presentFragment(new ChangeUsernameActivity());
            return;
        }
        if (i == this.bioRow) {
            if (this.userInfo != null) {
                presentFragment(new ChangeBioActivity());
            }
        } else if (i == this.setAvatarRow) {
            onWriteButtonClick();
        } else {
            processOnClickOrPress(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$1$ProfileActivity(int i) {
        this.listAdapter.notifyItemChanged(this.notificationsRow);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$2$ProfileActivity(DialogInterface dialogInterface, int i) throws IOException {
        SharedConfig.pushAuthKey = null;
        SharedConfig.pushAuthKeyId = null;
        SharedConfig.saveConfig();
        getConnectionsManager().switchBackend(true);
    }

    /* renamed from: ir.eitaa.ui.ProfileActivity$11, reason: invalid class name */
    class AnonymousClass11 implements RecyclerListView.OnItemLongClickListener {
        private int pressCount = 0;

        AnonymousClass11() {
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemLongClickListener
        public boolean onItemClick(View view, int position) {
            int i;
            String str;
            String string;
            int i2;
            String str2;
            int i3;
            String str3;
            String string2;
            int i4;
            String str4;
            if (position != ProfileActivity.this.versionRow) {
                if (position < ProfileActivity.this.membersStartRow || position >= ProfileActivity.this.membersEndRow) {
                    return ProfileActivity.this.processOnClickOrPress(position);
                }
                return ProfileActivity.this.onMemberClick(!ProfileActivity.this.sortedUsers.isEmpty() ? (TLRPC$ChatParticipant) ProfileActivity.this.visibleChatParticipants.get(((Integer) ProfileActivity.this.sortedUsers.get(position - ProfileActivity.this.membersStartRow)).intValue()) : (TLRPC$ChatParticipant) ProfileActivity.this.visibleChatParticipants.get(position - ProfileActivity.this.membersStartRow), true);
            }
            int i5 = this.pressCount + 1;
            this.pressCount = i5;
            if (i5 >= 2 || BuildVars.DEBUG_PRIVATE_VERSION) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ProfileActivity.this.getParentActivity());
                builder.setTitle(LocaleController.getString("DebugMenu", R.string.DebugMenu));
                CharSequence[] charSequenceArr = new CharSequence[17];
                charSequenceArr[0] = LocaleController.getString("DebugMenuImportContacts", R.string.DebugMenuImportContacts);
                charSequenceArr[1] = LocaleController.getString("DebugMenuReloadContacts", R.string.DebugMenuReloadContacts);
                charSequenceArr[2] = LocaleController.getString("DebugMenuResetContacts", R.string.DebugMenuResetContacts);
                charSequenceArr[3] = LocaleController.getString("DebugMenuResetDialogs", R.string.DebugMenuResetDialogs);
                if (BuildVars.DEBUG_VERSION) {
                    string = null;
                } else {
                    if (BuildVars.LOGS_ENABLED) {
                        i = R.string.DebugMenuDisableLogs;
                        str = "DebugMenuDisableLogs";
                    } else {
                        i = R.string.DebugMenuEnableLogs;
                        str = "DebugMenuEnableLogs";
                    }
                    string = LocaleController.getString(str, i);
                }
                charSequenceArr[4] = string;
                if (SharedConfig.inappCamera) {
                    i2 = R.string.DebugMenuDisableCamera;
                    str2 = "DebugMenuDisableCamera";
                } else {
                    i2 = R.string.DebugMenuEnableCamera;
                    str2 = "DebugMenuEnableCamera";
                }
                charSequenceArr[5] = LocaleController.getString(str2, i2);
                charSequenceArr[6] = LocaleController.getString("DebugMenuClearMediaCache", R.string.DebugMenuClearMediaCache);
                charSequenceArr[7] = null;
                charSequenceArr[8] = null;
                charSequenceArr[9] = (BuildVars.DEBUG_PRIVATE_VERSION || BuildVars.isStandaloneApp()) ? LocaleController.getString("DebugMenuCheckAppUpdate", R.string.DebugMenuCheckAppUpdate) : null;
                charSequenceArr[10] = LocaleController.getString("DebugMenuReadAllDialogs", R.string.DebugMenuReadAllDialogs);
                if (SharedConfig.pauseMusicOnRecord) {
                    i3 = R.string.DebugMenuDisablePauseMusic;
                    str3 = "DebugMenuDisablePauseMusic";
                } else {
                    i3 = R.string.DebugMenuEnablePauseMusic;
                    str3 = "DebugMenuEnablePauseMusic";
                }
                charSequenceArr[11] = LocaleController.getString(str3, i3);
                if (!BuildVars.DEBUG_VERSION || AndroidUtilities.isTablet() || Build.VERSION.SDK_INT < 23) {
                    string2 = null;
                } else {
                    if (SharedConfig.smoothKeyboard) {
                        i4 = R.string.DebugMenuDisableSmoothKeyboard;
                        str4 = "DebugMenuDisableSmoothKeyboard";
                    } else {
                        i4 = R.string.DebugMenuEnableSmoothKeyboard;
                        str4 = "DebugMenuEnableSmoothKeyboard";
                    }
                    string2 = LocaleController.getString(str4, i4);
                }
                charSequenceArr[12] = string2;
                charSequenceArr[13] = BuildVars.DEBUG_PRIVATE_VERSION ? SharedConfig.disableVoiceAudioEffects ? "Enable voip audio effects" : "Disable voip audio effects" : null;
                charSequenceArr[14] = Build.VERSION.SDK_INT >= 21 ? SharedConfig.noStatusBar ? "Show status bar background" : "Hide status bar background" : null;
                boolean z = BuildVars.DEBUG_PRIVATE_VERSION;
                charSequenceArr[15] = z ? "Clean app update" : null;
                charSequenceArr[16] = z ? "Reset suggestions" : null;
                builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$11$tGNzBYcsXZCrBJOURKzrnvAwLb4
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i6) {
                        this.f$0.lambda$onItemClick$0$ProfileActivity$11(dialogInterface, i6);
                    }
                });
                builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                ProfileActivity.this.showDialog(builder.create());
            } else {
                try {
                    Toast.makeText(ProfileActivity.this.getParentActivity(), "¯\\_(ツ)_/¯", 0).show();
                } catch (Exception e) {
                    FileLog.e(e);
                }
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onItemClick$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onItemClick$0$ProfileActivity$11(DialogInterface dialogInterface, int i) {
            if (i == 0) {
                ProfileActivity.this.getUserConfig().syncContacts = true;
                ProfileActivity.this.getUserConfig().saveConfig(false);
                ProfileActivity.this.getContactsController().forceImportContacts();
                return;
            }
            if (i == 1) {
                ProfileActivity.this.getContactsController().loadContacts(false, 0L);
                return;
            }
            if (i == 2) {
                ProfileActivity.this.getContactsController().resetImportedContacts();
                return;
            }
            if (i == 3) {
                ProfileActivity.this.getMessagesController().forceResetDialogs();
                return;
            }
            if (i == 4) {
                BuildVars.LOGS_ENABLED = true ^ BuildVars.LOGS_ENABLED;
                ApplicationLoader.applicationContext.getSharedPreferences("systemConfig", 0).edit().putBoolean("logsEnabled", BuildVars.LOGS_ENABLED).commit();
                ProfileActivity.this.updateRowsIds();
                ProfileActivity.this.listAdapter.notifyDataSetChanged();
                return;
            }
            if (i == 5) {
                SharedConfig.toggleInappCamera();
                return;
            }
            if (i == 6) {
                ProfileActivity.this.getMessagesStorage().clearSentMedia();
                SharedConfig.setNoSoundHintShowed(false);
                MessagesController.getGlobalMainSettings().edit().remove("archivehint").remove("proximityhint").remove("archivehint_l").remove("gifhint").remove("reminderhint").remove("soundHint").remove("themehint").remove("bganimationhint").remove("filterhint").commit();
                MessagesController.getEmojiSettings(((BaseFragment) ProfileActivity.this).currentAccount).edit().remove("featured_hidden").commit();
                SharedConfig.textSelectionHintShows = 0;
                SharedConfig.lockRecordAudioVideoHint = 0;
                SharedConfig.stickersReorderingHintUsed = false;
                SharedConfig.forwardingOptionsHintShown = false;
                SharedConfig.messageSeenHintCount = 3;
                SharedConfig.emojiInteractionsHintCount = 3;
                SharedConfig.dayNightThemeSwitchHintCount = 3;
                ChatThemeController.getInstance(((BaseFragment) ProfileActivity.this).currentAccount).clearCache();
                return;
            }
            if (i == 7) {
                VoIPHelper.showCallDebugSettings(ProfileActivity.this.getParentActivity());
                return;
            }
            if (i == 8) {
                SharedConfig.toggleRoundCamera16to9();
                return;
            }
            if (i == 9) {
                ((LaunchActivity) ProfileActivity.this.getParentActivity()).checkAppUpdate(true);
                return;
            }
            if (i == 10) {
                ProfileActivity.this.getMessagesStorage().readAllDialogs(-1);
                return;
            }
            if (i == 11) {
                SharedConfig.togglePauseMusicOnRecord();
                return;
            }
            if (i == 12) {
                SharedConfig.toggleSmoothKeyboard();
                if (!SharedConfig.smoothKeyboard || ProfileActivity.this.getParentActivity() == null) {
                    return;
                }
                ProfileActivity.this.getParentActivity().getWindow().setSoftInputMode(16);
                return;
            }
            if (i == 13) {
                SharedConfig.toggleDisableVoiceAudioEffects();
                return;
            }
            if (i == 14) {
                SharedConfig.toggleNoStatusBar();
                if (ProfileActivity.this.getParentActivity() == null || Build.VERSION.SDK_INT < 21) {
                    return;
                }
                if (SharedConfig.noStatusBar) {
                    ProfileActivity.this.getParentActivity().getWindow().setStatusBarColor(0);
                    return;
                } else {
                    ProfileActivity.this.getParentActivity().getWindow().setStatusBarColor(855638016);
                    return;
                }
            }
            if (i == 15) {
                SharedConfig.pendingAppUpdate = null;
                SharedConfig.saveConfig();
                NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.appUpdateAvailable, new Object[0]);
            } else if (i == 16) {
                Set<String> set = ProfileActivity.this.getMessagesController().pendingSuggestions;
                set.add("VALIDATE_PHONE_NUMBER");
                set.add("VALIDATE_PASSWORD");
                ProfileActivity.this.getNotificationCenter().postNotificationName(NotificationCenter.newSuggestionsAvailable, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a9  */
    /* renamed from: lambda$createView$4, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$createView$4$ProfileActivity(android.view.View r8, int r9) {
        /*
            r7 = this;
            if (r9 >= 0) goto L3
            return
        L3:
            int r8 = r7.numberRow
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            ir.eitaa.ui.ProfileActivity$SearchAdapter r0 = r7.searchAdapter
            boolean r0 = ir.eitaa.ui.ProfileActivity.SearchAdapter.access$25500(r0)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L50
            ir.eitaa.ui.ProfileActivity$SearchAdapter r0 = r7.searchAdapter
            java.util.ArrayList r0 = ir.eitaa.ui.ProfileActivity.SearchAdapter.access$25600(r0)
            int r0 = r0.size()
            if (r9 >= r0) goto L2b
            ir.eitaa.ui.ProfileActivity$SearchAdapter r8 = r7.searchAdapter
            java.util.ArrayList r8 = ir.eitaa.ui.ProfileActivity.SearchAdapter.access$25600(r8)
            java.lang.Object r8 = r8.get(r9)
            goto L9d
        L2b:
            ir.eitaa.ui.ProfileActivity$SearchAdapter r0 = r7.searchAdapter
            java.util.ArrayList r0 = ir.eitaa.ui.ProfileActivity.SearchAdapter.access$25600(r0)
            int r0 = r0.size()
            int r0 = r0 + r2
            int r9 = r9 - r0
            if (r9 < 0) goto L9d
            ir.eitaa.ui.ProfileActivity$SearchAdapter r0 = r7.searchAdapter
            java.util.ArrayList r0 = ir.eitaa.ui.ProfileActivity.SearchAdapter.access$25700(r0)
            int r0 = r0.size()
            if (r9 >= r0) goto L9d
            ir.eitaa.ui.ProfileActivity$SearchAdapter r8 = r7.searchAdapter
            java.util.ArrayList r8 = ir.eitaa.ui.ProfileActivity.SearchAdapter.access$25700(r8)
            java.lang.Object r8 = r8.get(r9)
            goto L9d
        L50:
            ir.eitaa.ui.ProfileActivity$SearchAdapter r0 = r7.searchAdapter
            java.util.ArrayList r0 = ir.eitaa.ui.ProfileActivity.SearchAdapter.access$25400(r0)
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L5e
            int r9 = r9 + (-1)
        L5e:
            if (r9 < 0) goto L77
            ir.eitaa.ui.ProfileActivity$SearchAdapter r0 = r7.searchAdapter
            java.util.ArrayList r0 = ir.eitaa.ui.ProfileActivity.SearchAdapter.access$25400(r0)
            int r0 = r0.size()
            if (r9 >= r0) goto L77
            ir.eitaa.ui.ProfileActivity$SearchAdapter r8 = r7.searchAdapter
            java.util.ArrayList r8 = ir.eitaa.ui.ProfileActivity.SearchAdapter.access$25400(r8)
            java.lang.Object r8 = r8.get(r9)
            goto L9d
        L77:
            ir.eitaa.ui.ProfileActivity$SearchAdapter r0 = r7.searchAdapter
            java.util.ArrayList r0 = ir.eitaa.ui.ProfileActivity.SearchAdapter.access$25400(r0)
            int r0 = r0.size()
            int r0 = r0 + r2
            int r9 = r9 - r0
            if (r9 < 0) goto L9d
            ir.eitaa.ui.ProfileActivity$SearchAdapter r0 = r7.searchAdapter
            java.util.ArrayList r0 = ir.eitaa.ui.ProfileActivity.SearchAdapter.access$25800(r0)
            int r0 = r0.size()
            if (r9 >= r0) goto L9d
            ir.eitaa.ui.ProfileActivity$SearchAdapter r8 = r7.searchAdapter
            java.util.ArrayList r8 = ir.eitaa.ui.ProfileActivity.SearchAdapter.access$25800(r8)
            java.lang.Object r8 = r8.get(r9)
            r9 = 0
            goto L9e
        L9d:
            r9 = 1
        L9e:
            boolean r0 = r8 instanceof ir.eitaa.ui.ProfileActivity.SearchAdapter.SearchResult
            if (r0 == 0) goto La9
            r0 = r8
            ir.eitaa.ui.ProfileActivity$SearchAdapter$SearchResult r0 = (ir.eitaa.ui.ProfileActivity.SearchAdapter.SearchResult) r0
            ir.eitaa.ui.ProfileActivity.SearchAdapter.SearchResult.access$25900(r0)
            goto Lca
        La9:
            boolean r0 = r8 instanceof ir.eitaa.messenger.MessagesController.FaqSearchResult
            if (r0 == 0) goto Lca
            r0 = r8
            ir.eitaa.messenger.MessagesController$FaqSearchResult r0 = (ir.eitaa.messenger.MessagesController.FaqSearchResult) r0
            int r3 = r7.currentAccount
            ir.eitaa.messenger.NotificationCenter r3 = ir.eitaa.messenger.NotificationCenter.getInstance(r3)
            int r4 = ir.eitaa.messenger.NotificationCenter.openArticle
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]
            ir.eitaa.ui.ProfileActivity$SearchAdapter r6 = r7.searchAdapter
            ir.eitaa.tgnet.TLRPC$WebPage r6 = ir.eitaa.ui.ProfileActivity.SearchAdapter.access$26000(r6)
            r5[r1] = r6
            java.lang.String r0 = r0.url
            r5[r2] = r0
            r3.postNotificationName(r4, r5)
        Lca:
            if (r9 == 0) goto Ld3
            if (r8 == 0) goto Ld3
            ir.eitaa.ui.ProfileActivity$SearchAdapter r9 = r7.searchAdapter
            r9.addRecent(r8)
        Ld3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ProfileActivity.lambda$createView$4$ProfileActivity(android.view.View, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$createView$6$ProfileActivity(View view, int i) {
        if (this.searchAdapter.isSearchWas() || this.searchAdapter.recentSearches.isEmpty()) {
            return false;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
        builder.setMessage(LocaleController.getString("ClearSearch", R.string.ClearSearch));
        builder.setPositiveButton(LocaleController.getString("ClearButton", R.string.ClearButton).toUpperCase(), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$t6owdK4tlE16dGnQPgiiLy6OnWY
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.f$0.lambda$createView$5$ProfileActivity(dialogInterface, i2);
            }
        });
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        showDialog(builder.create());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$5$ProfileActivity(DialogInterface dialogInterface, int i) {
        this.searchAdapter.clearRecent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$7$ProfileActivity(TLObject tLObject) {
        this.currentChannelParticipant = ((TLRPC$TL_channels_channelParticipant) tLObject).participant;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$8$ProfileActivity(final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$R-I3JlDSrYzayxfeRUl1lCZjwDY
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$createView$7$ProfileActivity(tLObject);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$9$ProfileActivity(TLRPC$Chat tLRPC$Chat, View view) {
        long j = this.userId;
        long j2 = this.banFromGroup;
        TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights = tLRPC$Chat.default_banned_rights;
        TLRPC$ChannelParticipant tLRPC$ChannelParticipant = this.currentChannelParticipant;
        ChatRightsEditActivity chatRightsEditActivity = new ChatRightsEditActivity(j, j2, null, tLRPC$TL_chatBannedRights, tLRPC$ChannelParticipant != null ? tLRPC$ChannelParticipant.banned_rights : null, "", 1, true, false);
        chatRightsEditActivity.setDelegate(new ChatRightsEditActivity.ChatRightsEditActivityDelegate() { // from class: ir.eitaa.ui.ProfileActivity.14
            @Override // ir.eitaa.ui.ChatRightsEditActivity.ChatRightsEditActivityDelegate
            public void didSetRights(int rights, TLRPC$TL_chatAdminRights rightsAdmin, TLRPC$TL_chatBannedRights rightsBanned, String rank) {
                ProfileActivity.this.removeSelfFromStack();
            }

            @Override // ir.eitaa.ui.ChatRightsEditActivity.ChatRightsEditActivityDelegate
            public void didChangeOwner(TLRPC$User user) {
                ProfileActivity.this.undoView.showWithAction(-ProfileActivity.this.chatId, ProfileActivity.this.currentChat.megagroup ? 10 : 9, user);
            }
        });
        presentFragment(chatRightsEditActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$10$ProfileActivity(View view) throws Resources.NotFoundException {
        RecyclerView.ViewHolder viewHolderFindContainingViewHolder;
        Integer num;
        if (this.avatarBig != null) {
            return;
        }
        if (!AndroidUtilities.isTablet() && !this.isInLandscapeMode && this.avatarImage.getImageReceiver().hasNotThumb()) {
            this.openingAvatar = true;
            this.allowPullingDown = true;
            View childAt = null;
            int i = 0;
            while (true) {
                if (i >= this.listView.getChildCount()) {
                    break;
                }
                RecyclerListView recyclerListView = this.listView;
                if (recyclerListView.getChildAdapterPosition(recyclerListView.getChildAt(i)) == 0) {
                    childAt = this.listView.getChildAt(i);
                    break;
                }
                i++;
            }
            if (childAt != null && (viewHolderFindContainingViewHolder = this.listView.findContainingViewHolder(childAt)) != null && (num = this.positionToOffset.get(Integer.valueOf(viewHolderFindContainingViewHolder.getAdapterPosition()))) != null) {
                this.listView.smoothScrollBy(0, -(num.intValue() + ((this.listView.getPaddingTop() - childAt.getTop()) - this.actionBar.getMeasuredHeight())), CubicBezierInterpolator.EASE_OUT_QUINT);
                return;
            }
        }
        openAvatar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$createView$11$ProfileActivity(View view) throws Resources.NotFoundException {
        if (this.avatarBig != null) {
            return false;
        }
        openAvatar();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$12$ProfileActivity(View view) {
        if (this.writeButton.getTag() != null) {
            return;
        }
        onWriteButtonClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$13, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$13$ProfileActivity(ValueAnimator valueAnimator) {
        int color;
        int currentActionBarHeight = ActionBar.getCurrentActionBarHeight() + (this.actionBar.getOccupyStatusBar() ? AndroidUtilities.statusBarHeight : 0);
        float[] fArr = this.expandAnimatorValues;
        float animatedFraction = valueAnimator.getAnimatedFraction();
        this.currentExpanAnimatorFracture = animatedFraction;
        float fLerp = AndroidUtilities.lerp(fArr, animatedFraction);
        this.avatarContainer.setScaleX(this.avatarScale);
        this.avatarContainer.setScaleY(this.avatarScale);
        this.avatarContainer.setTranslationX(AndroidUtilities.lerp(this.avatarX, 0.0f, fLerp));
        this.avatarContainer.setTranslationY(AndroidUtilities.lerp((float) Math.ceil(this.avatarY), 0.0f, fLerp));
        this.avatarImage.setRoundRadius((int) AndroidUtilities.lerp(AndroidUtilities.dpf2(21.0f), 0.0f, fLerp));
        ActionBarMenuItem actionBarMenuItem = this.searchItem;
        if (actionBarMenuItem != null) {
            actionBarMenuItem.setAlpha(1.0f - fLerp);
        }
        if (this.extraHeight > AndroidUtilities.dp(88.0f) && this.expandProgress < 0.33f) {
            refreshNameAndOnlineXY();
        }
        ScamDrawable scamDrawable = this.scamDrawable;
        if (scamDrawable != null) {
            scamDrawable.setColor(ColorUtils.blendARGB(Theme.getColor("avatar_subtitleInProfileBlue"), Color.argb(179, 255, 255, 255), fLerp));
        }
        Drawable drawable = this.lockIconDrawable;
        if (drawable != null) {
            drawable.setColorFilter(ColorUtils.blendARGB(Theme.getColor("chat_lockIcon"), -1, fLerp), PorterDuff.Mode.MULTIPLY);
        }
        CrossfadeDrawable crossfadeDrawable = this.verifiedCrossfadeDrawable;
        if (crossfadeDrawable != null) {
            crossfadeDrawable.setProgress(fLerp);
        }
        float fDpf2 = AndroidUtilities.dpf2(8.0f);
        float fDpf22 = AndroidUtilities.dpf2(16.0f) - this.nameTextView[1].getLeft();
        float f = currentActionBarHeight;
        float fDpf23 = ((this.extraHeight + f) - AndroidUtilities.dpf2(38.0f)) - this.nameTextView[1].getBottom();
        float f2 = this.nameX;
        float f3 = this.nameY;
        float f4 = 1.0f - fLerp;
        float f5 = f4 * f4;
        float f6 = f4 * 2.0f * fLerp;
        float f7 = fLerp * fLerp;
        float f8 = (f2 * f5) + ((fDpf2 + f2 + ((fDpf22 - f2) / 2.0f)) * f6) + (fDpf22 * f7);
        float f9 = (f3 * f5) + ((fDpf2 + f3 + ((fDpf23 - f3) / 2.0f)) * f6) + (fDpf23 * f7);
        float fDpf24 = AndroidUtilities.dpf2(16.0f) - this.onlineTextView[1].getLeft();
        float fDpf25 = ((this.extraHeight + f) - AndroidUtilities.dpf2(18.0f)) - this.onlineTextView[1].getBottom();
        float f10 = this.onlineX;
        float f11 = this.onlineY;
        float f12 = (f10 * f5) + ((fDpf2 + f10 + ((fDpf24 - f10) / 2.0f)) * f6) + (fDpf24 * f7);
        float f13 = (f5 * f11) + (f6 * (fDpf2 + f11 + ((fDpf25 - f11) / 2.0f))) + (f7 * fDpf25);
        this.nameTextView[1].setTranslationX(f8);
        this.nameTextView[1].setTranslationY(f9);
        this.onlineTextView[1].setTranslationX(f12);
        this.onlineTextView[1].setTranslationY(f13);
        this.mediaCounterTextView.setTranslationX(f12);
        this.mediaCounterTextView.setTranslationY(f13);
        Object tag = this.onlineTextView[1].getTag();
        if (tag instanceof String) {
            color = Theme.getColor((String) tag);
        } else {
            color = Theme.getColor("avatar_subtitleInProfileBlue");
        }
        this.onlineTextView[1].setTextColor(ColorUtils.blendARGB(color, Color.argb(179, 255, 255, 255), fLerp));
        if (this.extraHeight > AndroidUtilities.dp(88.0f)) {
            this.nameTextView[1].setPivotY(AndroidUtilities.lerp(0.0f, r3[1].getMeasuredHeight(), fLerp));
            this.nameTextView[1].setScaleX(AndroidUtilities.lerp(1.12f, 1.67f, fLerp));
            this.nameTextView[1].setScaleY(AndroidUtilities.lerp(1.12f, 1.67f, fLerp));
        }
        needLayoutText(Math.min(1.0f, this.extraHeight / AndroidUtilities.dp(88.0f)));
        this.nameTextView[1].setTextColor(ColorUtils.blendARGB(Theme.getColor("profile_title"), -1, fLerp));
        this.actionBar.setItemsColor(ColorUtils.blendARGB(Theme.getColor("actionBarDefaultIcon"), -1, fLerp), false);
        this.avatarImage.setForegroundAlpha(fLerp);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.avatarContainer.getLayoutParams();
        layoutParams.width = (int) AndroidUtilities.lerp(AndroidUtilities.dpf2(42.0f), this.listView.getMeasuredWidth() / this.avatarScale, fLerp);
        layoutParams.height = (int) AndroidUtilities.lerp(AndroidUtilities.dpf2(42.0f), (this.extraHeight + f) / this.avatarScale, fLerp);
        layoutParams.leftMargin = (int) AndroidUtilities.lerp(AndroidUtilities.dpf2(64.0f), 0.0f, fLerp);
        this.avatarContainer.requestLayout();
    }

    public long getDialogId() {
        long j = this.dialogId;
        if (j != 0) {
            return j;
        }
        long j2 = this.userId;
        return j2 != 0 ? j2 : -this.chatId;
    }

    public TLRPC$Chat getCurrentChat() {
        return this.currentChat;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void openAvatar() throws android.content.res.Resources.NotFoundException {
        /*
            r5 = this;
            ir.eitaa.ui.Components.RecyclerListView r0 = r5.listView
            int r0 = r0.getScrollState()
            r1 = 1
            if (r0 != r1) goto La
            return
        La:
            long r0 = r5.userId
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L4b
            ir.eitaa.messenger.MessagesController r0 = r5.getMessagesController()
            long r1 = r5.userId
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            ir.eitaa.tgnet.TLRPC$User r0 = r0.getUser(r1)
            ir.eitaa.tgnet.TLRPC$UserProfilePhoto r1 = r0.photo
            if (r1 == 0) goto Lb2
            ir.eitaa.tgnet.TLRPC$FileLocation r1 = r1.photo_big
            if (r1 == 0) goto Lb2
            ir.eitaa.ui.PhotoViewer r1 = ir.eitaa.ui.PhotoViewer.getInstance()
            android.app.Activity r2 = r5.getParentActivity()
            r1.setParentActivity(r2)
            ir.eitaa.tgnet.TLRPC$UserProfilePhoto r1 = r0.photo
            int r2 = r1.dc_id
            if (r2 == 0) goto L3d
            ir.eitaa.tgnet.TLRPC$FileLocation r1 = r1.photo_big
            r1.dc_id = r2
        L3d:
            ir.eitaa.ui.PhotoViewer r1 = ir.eitaa.ui.PhotoViewer.getInstance()
            ir.eitaa.tgnet.TLRPC$UserProfilePhoto r0 = r0.photo
            ir.eitaa.tgnet.TLRPC$FileLocation r0 = r0.photo_big
            ir.eitaa.ui.PhotoViewer$PhotoViewerProvider r2 = r5.provider
            r1.openPhoto(r0, r2)
            goto Lb2
        L4b:
            long r0 = r5.chatId
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto Lb2
            ir.eitaa.messenger.MessagesController r0 = r5.getMessagesController()
            long r1 = r5.chatId
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            ir.eitaa.tgnet.TLRPC$Chat r0 = r0.getChat(r1)
            ir.eitaa.tgnet.TLRPC$ChatPhoto r1 = r0.photo
            if (r1 == 0) goto Lb2
            ir.eitaa.tgnet.TLRPC$FileLocation r1 = r1.photo_big
            if (r1 == 0) goto Lb2
            ir.eitaa.ui.PhotoViewer r1 = ir.eitaa.ui.PhotoViewer.getInstance()
            android.app.Activity r2 = r5.getParentActivity()
            r1.setParentActivity(r2)
            ir.eitaa.tgnet.TLRPC$ChatPhoto r1 = r0.photo
            int r2 = r1.dc_id
            if (r2 == 0) goto L7c
            ir.eitaa.tgnet.TLRPC$FileLocation r1 = r1.photo_big
            r1.dc_id = r2
        L7c:
            ir.eitaa.tgnet.TLRPC$ChatFull r1 = r5.chatInfo
            if (r1 == 0) goto La4
            ir.eitaa.tgnet.TLRPC$Photo r1 = r1.chat_photo
            boolean r2 = r1 instanceof ir.eitaa.tgnet.TLRPC$TL_photo
            if (r2 == 0) goto La4
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$VideoSize> r1 = r1.video_sizes
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto La4
            ir.eitaa.tgnet.TLRPC$ChatFull r1 = r5.chatInfo
            ir.eitaa.tgnet.TLRPC$Photo r1 = r1.chat_photo
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$VideoSize> r1 = r1.video_sizes
            r2 = 0
            java.lang.Object r1 = r1.get(r2)
            ir.eitaa.tgnet.TLRPC$VideoSize r1 = (ir.eitaa.tgnet.TLRPC$VideoSize) r1
            ir.eitaa.tgnet.TLRPC$ChatFull r2 = r5.chatInfo
            ir.eitaa.tgnet.TLRPC$Photo r2 = r2.chat_photo
            ir.eitaa.messenger.ImageLocation r1 = ir.eitaa.messenger.ImageLocation.getForPhoto(r1, r2)
            goto La5
        La4:
            r1 = 0
        La5:
            ir.eitaa.ui.PhotoViewer r2 = ir.eitaa.ui.PhotoViewer.getInstance()
            ir.eitaa.tgnet.TLRPC$ChatPhoto r0 = r0.photo
            ir.eitaa.tgnet.TLRPC$FileLocation r0 = r0.photo_big
            ir.eitaa.ui.PhotoViewer$PhotoViewerProvider r3 = r5.provider
            r2.openPhotoWithVideo(r0, r1, r3)
        Lb2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ProfileActivity.openAvatar():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onWriteButtonClick() {
        if (this.userId != 0) {
            if (this.imageUpdater != null) {
                TLRPC$User user = MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(UserConfig.getInstance(this.currentAccount).getClientUserId()));
                if (user == null) {
                    user = UserConfig.getInstance(this.currentAccount).getCurrentUser();
                }
                if (user == null) {
                    return;
                }
                ImageUpdater imageUpdater = this.imageUpdater;
                TLRPC$UserProfilePhoto tLRPC$UserProfilePhoto = user.photo;
                imageUpdater.openMenu((tLRPC$UserProfilePhoto == null || tLRPC$UserProfilePhoto.photo_big == null || (tLRPC$UserProfilePhoto instanceof TLRPC$TL_userProfilePhotoEmpty)) ? false : true, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$oRvgT2BwLgl5isfLn-i6C_LP6s8
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onWriteButtonClick$14$ProfileActivity();
                    }
                }, new DialogInterface.OnDismissListener() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$5aTbmwcHGmib68u8E4RDlWRckoM
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) throws InterruptedException {
                        this.f$0.lambda$onWriteButtonClick$15$ProfileActivity(dialogInterface);
                    }
                });
                this.cameraDrawable.setCurrentFrame(0);
                this.cameraDrawable.setCustomEndFrame(43);
                this.writeButton.playAnimation();
                return;
            }
            if (this.playProfileAnimation != 0) {
                if (this.parentLayout.fragmentsStack.get(r0.size() - 2) instanceof ChatActivity) {
                    finishFragment();
                    return;
                }
            }
            TLRPC$User user2 = getMessagesController().getUser(Long.valueOf(this.userId));
            if (user2 == null || (user2 instanceof TLRPC$TL_userEmpty)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putLong("user_id", this.userId);
            if (getMessagesController().checkCanOpenChat(bundle, this)) {
                if (!AndroidUtilities.isTablet()) {
                    NotificationCenter notificationCenter = getNotificationCenter();
                    int i = NotificationCenter.closeChats;
                    notificationCenter.removeObserver(this, i);
                    getNotificationCenter().postNotificationName(i, new Object[0]);
                }
                int i2 = getArguments().getInt("nearby_distance", -1);
                if (i2 >= 0) {
                    bundle.putInt("nearby_distance", i2);
                }
                ChatActivity chatActivity = new ChatActivity(bundle);
                chatActivity.setPreloadedSticker(getMediaDataController().getGreetingsSticker(), false);
                presentFragment(chatActivity, true);
                if (AndroidUtilities.isTablet()) {
                    finishFragment();
                    return;
                }
                return;
            }
            return;
        }
        openDiscussion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onWriteButtonClick$14, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onWriteButtonClick$14$ProfileActivity() {
        MessagesController.getInstance(this.currentAccount).deleteUserPhoto(null);
        this.cameraDrawable.setCurrentFrame(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onWriteButtonClick$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onWriteButtonClick$15$ProfileActivity(DialogInterface dialogInterface) throws InterruptedException {
        if (!this.imageUpdater.isUploadingImage()) {
            this.cameraDrawable.setCustomEndFrame(86);
            this.writeButton.playAnimation();
        } else {
            this.cameraDrawable.setCurrentFrame(0, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openDiscussion() {
        TLRPC$ChatFull tLRPC$ChatFull = this.chatInfo;
        if (tLRPC$ChatFull == null || tLRPC$ChatFull.linked_chat_id == 0) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("chat_id", this.chatInfo.linked_chat_id);
        if (getMessagesController().checkCanOpenChat(bundle, this)) {
            presentFragment(new ChatActivity(bundle));
        }
    }

    public boolean onMemberClick(TLRPC$ChatParticipant participant, boolean isLong) {
        return onMemberClick(participant, isLong, false);
    }

    public boolean onMemberClick(final TLRPC$ChatParticipant participant, boolean isLong, boolean resultOnly) {
        boolean z;
        boolean zCanAddAdmins;
        boolean z2;
        TLRPC$ChannelParticipant tLRPC$ChannelParticipant;
        boolean z3;
        boolean z4;
        int i;
        String str;
        if (getParentActivity() == null) {
            return false;
        }
        TLRPC$Chat tLRPC$Chat = this.currentChat;
        if (tLRPC$Chat != null && !ChatObject.isChannel(tLRPC$Chat)) {
            TLRPC$Chat tLRPC$Chat2 = this.currentChat;
            if (!tLRPC$Chat2.megagroup && tLRPC$Chat2.creator) {
                MessagesController.getInstance(this.currentAccount).convertToMegaGroup(getParentActivity(), this.chatId, this, null);
            }
        }
        if (isLong) {
            final TLRPC$User user = getMessagesController().getUser(Long.valueOf(participant.user_id));
            if (user == null || participant.user_id == getUserConfig().getClientUserId()) {
                return false;
            }
            this.selectedUser = participant.user_id;
            if (ChatObject.isChannel(this.currentChat)) {
                TLRPC$ChannelParticipant tLRPC$ChannelParticipant2 = ((TLRPC$TL_chatChannelParticipant) participant).channelParticipant;
                getMessagesController().getUser(Long.valueOf(participant.user_id));
                zCanAddAdmins = ChatObject.canAddAdmins(this.currentChat);
                if (zCanAddAdmins && ((tLRPC$ChannelParticipant2 instanceof TLRPC$TL_channelParticipantCreator) || ((tLRPC$ChannelParticipant2 instanceof TLRPC$TL_channelParticipantAdmin) && !tLRPC$ChannelParticipant2.can_edit))) {
                    zCanAddAdmins = false;
                }
                z = ChatObject.canBlockUsers(this.currentChat) && (!((tLRPC$ChannelParticipant2 instanceof TLRPC$TL_channelParticipantAdmin) || (tLRPC$ChannelParticipant2 instanceof TLRPC$TL_channelParticipantCreator)) || tLRPC$ChannelParticipant2.can_edit);
                z3 = this.currentChat.gigagroup ? false : z;
                z2 = tLRPC$ChannelParticipant2 instanceof TLRPC$TL_channelParticipantAdmin;
                tLRPC$ChannelParticipant = tLRPC$ChannelParticipant2;
            } else {
                TLRPC$Chat tLRPC$Chat3 = this.currentChat;
                z = tLRPC$Chat3.creator || ((participant instanceof TLRPC$TL_chatParticipant) && (ChatObject.canBlockUsers(tLRPC$Chat3) || participant.inviter_id == getUserConfig().getClientUserId()));
                zCanAddAdmins = this.currentChat.creator;
                z2 = participant instanceof TLRPC$TL_chatParticipantAdmin;
                tLRPC$ChannelParticipant = null;
                z3 = zCanAddAdmins;
            }
            ArrayList arrayList = resultOnly ? null : new ArrayList();
            ArrayList arrayList2 = resultOnly ? null : new ArrayList();
            final ArrayList arrayList3 = resultOnly ? null : new ArrayList();
            if (zCanAddAdmins) {
                if (resultOnly) {
                    return true;
                }
                if (z2) {
                    i = R.string.EditAdminRights;
                    str = "EditAdminRights";
                } else {
                    i = R.string.SetAsAdmin;
                    str = "SetAsAdmin";
                }
                arrayList.add(LocaleController.getString(str, i));
                arrayList2.add(Integer.valueOf(R.drawable.actions_addadmin));
                arrayList3.add(0);
            }
            if (z3 && this.currentChat.megagroup && this.chatInfo != null) {
                if (resultOnly) {
                    return true;
                }
                arrayList.add(LocaleController.getString("ChangePermissions", R.string.ChangePermissions));
                arrayList2.add(Integer.valueOf(R.drawable.actions_permissions));
                arrayList3.add(1);
            }
            if (!z) {
                z4 = false;
            } else {
                if (resultOnly) {
                    return true;
                }
                arrayList.add(LocaleController.getString("KickFromGroup", R.string.KickFromGroup));
                arrayList2.add(Integer.valueOf(R.drawable.actions_remove_user));
                arrayList3.add(2);
                z4 = true;
            }
            if (resultOnly || arrayList.isEmpty()) {
                return false;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
            final TLRPC$ChannelParticipant tLRPC$ChannelParticipant3 = tLRPC$ChannelParticipant;
            final boolean z5 = z2;
            builder.setItems((CharSequence[]) arrayList.toArray(new CharSequence[0]), AndroidUtilities.toIntArray(arrayList2), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$1XhhON8JZz7Nl4bo9hGTx5YocFo
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$onMemberClick$17$ProfileActivity(arrayList3, participant, tLRPC$ChannelParticipant3, user, z5, dialogInterface, i2);
                }
            });
            AlertDialog alertDialogCreate = builder.create();
            showDialog(alertDialogCreate);
            if (z4) {
                alertDialogCreate.setItemColor(arrayList.size() - 1, Theme.getColor("dialogTextRed2"), Theme.getColor("dialogRedIcon"));
            }
        } else {
            if (participant.user_id == getUserConfig().getClientUserId()) {
                return false;
            }
            Bundle bundle = new Bundle();
            bundle.putLong("user_id", participant.user_id);
            bundle.putBoolean("preload_messages", true);
            presentFragment(new ProfileActivity(bundle));
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onMemberClick$17, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onMemberClick$17$ProfileActivity(ArrayList arrayList, final TLRPC$ChatParticipant tLRPC$ChatParticipant, final TLRPC$ChannelParticipant tLRPC$ChannelParticipant, final TLRPC$User tLRPC$User, final boolean z, DialogInterface dialogInterface, int i) {
        if (((Integer) arrayList.get(i)).intValue() == 2) {
            kickUser(this.selectedUser, tLRPC$ChatParticipant);
            return;
        }
        final int iIntValue = ((Integer) arrayList.get(i)).intValue();
        if (iIntValue != 1 || (!(tLRPC$ChannelParticipant instanceof TLRPC$TL_channelParticipantAdmin) && !(tLRPC$ChatParticipant instanceof TLRPC$TL_chatParticipantAdmin))) {
            if (tLRPC$ChannelParticipant != null) {
                openRightsEdit(iIntValue, tLRPC$User, tLRPC$ChatParticipant, tLRPC$ChannelParticipant.admin_rights, tLRPC$ChannelParticipant.banned_rights, tLRPC$ChannelParticipant.rank, z);
                return;
            } else {
                openRightsEdit(iIntValue, tLRPC$User, tLRPC$ChatParticipant, null, null, "", z);
                return;
            }
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
        builder.setMessage(LocaleController.formatString("AdminWillBeRemoved", R.string.AdminWillBeRemoved, ContactsController.formatName(tLRPC$User.first_name, tLRPC$User.last_name)));
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$sPX1Oxgz507X2Z7DvQUj7WbjmGU
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface2, int i2) {
                this.f$0.lambda$onMemberClick$16$ProfileActivity(tLRPC$ChannelParticipant, iIntValue, tLRPC$User, tLRPC$ChatParticipant, z, dialogInterface2, i2);
            }
        });
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        showDialog(builder.create());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onMemberClick$16, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onMemberClick$16$ProfileActivity(TLRPC$ChannelParticipant tLRPC$ChannelParticipant, int i, TLRPC$User tLRPC$User, TLRPC$ChatParticipant tLRPC$ChatParticipant, boolean z, DialogInterface dialogInterface, int i2) {
        if (tLRPC$ChannelParticipant != null) {
            openRightsEdit(i, tLRPC$User, tLRPC$ChatParticipant, tLRPC$ChannelParticipant.admin_rights, tLRPC$ChannelParticipant.banned_rights, tLRPC$ChannelParticipant.rank, z);
        } else {
            openRightsEdit(i, tLRPC$User, tLRPC$ChatParticipant, null, null, "", z);
        }
    }

    private void openRightsEdit(final int action, final TLRPC$User user, final TLRPC$ChatParticipant participant, TLRPC$TL_chatAdminRights adminRights, TLRPC$TL_chatBannedRights bannedRights, String rank, final boolean editingAdmin) {
        final boolean[] zArr = new boolean[1];
        ChatRightsEditActivity chatRightsEditActivity = new ChatRightsEditActivity(user.id, this.chatId, adminRights, this.currentChat.default_banned_rights, bannedRights, rank, action, true, false) { // from class: ir.eitaa.ui.ProfileActivity.23
            @Override // ir.eitaa.ui.ActionBar.BaseFragment
            protected void onTransitionAnimationEnd(boolean isOpen, boolean backward) {
                if (!isOpen && backward && zArr[0] && BulletinFactory.canShowBulletin(ProfileActivity.this)) {
                    BulletinFactory.createPromoteToAdminBulletin(ProfileActivity.this, user.first_name).show();
                }
            }
        };
        chatRightsEditActivity.setDelegate(new ChatRightsEditActivity.ChatRightsEditActivityDelegate() { // from class: ir.eitaa.ui.ProfileActivity.24
            @Override // ir.eitaa.ui.ChatRightsEditActivity.ChatRightsEditActivityDelegate
            public void didSetRights(int rights, TLRPC$TL_chatAdminRights rightsAdmin, TLRPC$TL_chatBannedRights rightsBanned, String rank2) {
                boolean z;
                TLRPC$ChatParticipant tLRPC$TL_chatParticipant;
                int i = action;
                int i2 = 0;
                if (i != 0) {
                    if (i == 1 && rights == 0 && ProfileActivity.this.currentChat.megagroup && ProfileActivity.this.chatInfo != null && ProfileActivity.this.chatInfo.participants != null) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= ProfileActivity.this.chatInfo.participants.participants.size()) {
                                z = false;
                                break;
                            } else {
                                if (MessageObject.getPeerId(((TLRPC$TL_chatChannelParticipant) ProfileActivity.this.chatInfo.participants.participants.get(i3)).channelParticipant.peer) == participant.user_id) {
                                    ProfileActivity.this.chatInfo.participants_count--;
                                    ProfileActivity.this.chatInfo.participants.participants.remove(i3);
                                    z = true;
                                    break;
                                }
                                i3++;
                            }
                        }
                        if (ProfileActivity.this.chatInfo != null && ProfileActivity.this.chatInfo.participants != null) {
                            while (true) {
                                if (i2 >= ProfileActivity.this.chatInfo.participants.participants.size()) {
                                    break;
                                }
                                if (ProfileActivity.this.chatInfo.participants.participants.get(i2).user_id == participant.user_id) {
                                    ProfileActivity.this.chatInfo.participants.participants.remove(i2);
                                    z = true;
                                    break;
                                }
                                i2++;
                            }
                        }
                        if (z) {
                            ProfileActivity.this.updateOnlineCount(true);
                            ProfileActivity.this.updateRowsIds();
                            ProfileActivity.this.listAdapter.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    return;
                }
                TLRPC$ChatParticipant tLRPC$ChatParticipant = participant;
                if (tLRPC$ChatParticipant instanceof TLRPC$TL_chatChannelParticipant) {
                    TLRPC$TL_chatChannelParticipant tLRPC$TL_chatChannelParticipant = (TLRPC$TL_chatChannelParticipant) tLRPC$ChatParticipant;
                    if (rights == 1) {
                        TLRPC$TL_channelParticipantAdmin tLRPC$TL_channelParticipantAdmin = new TLRPC$TL_channelParticipantAdmin();
                        tLRPC$TL_chatChannelParticipant.channelParticipant = tLRPC$TL_channelParticipantAdmin;
                        tLRPC$TL_channelParticipantAdmin.flags |= 4;
                    } else {
                        tLRPC$TL_chatChannelParticipant.channelParticipant = new TLRPC$TL_channelParticipant();
                    }
                    tLRPC$TL_chatChannelParticipant.channelParticipant.inviter_id = ProfileActivity.this.getUserConfig().getClientUserId();
                    tLRPC$TL_chatChannelParticipant.channelParticipant.peer = new TLRPC$TL_peerUser();
                    TLRPC$ChannelParticipant tLRPC$ChannelParticipant = tLRPC$TL_chatChannelParticipant.channelParticipant;
                    TLRPC$Peer tLRPC$Peer = tLRPC$ChannelParticipant.peer;
                    TLRPC$ChatParticipant tLRPC$ChatParticipant2 = participant;
                    tLRPC$Peer.user_id = tLRPC$ChatParticipant2.user_id;
                    tLRPC$ChannelParticipant.date = tLRPC$ChatParticipant2.date;
                    tLRPC$ChannelParticipant.banned_rights = rightsBanned;
                    tLRPC$ChannelParticipant.admin_rights = rightsAdmin;
                    tLRPC$ChannelParticipant.rank = rank2;
                } else if (tLRPC$ChatParticipant != null) {
                    if (rights == 1) {
                        tLRPC$TL_chatParticipant = new TLRPC$TL_chatParticipantAdmin();
                    } else {
                        tLRPC$TL_chatParticipant = new TLRPC$TL_chatParticipant();
                    }
                    TLRPC$ChatParticipant tLRPC$ChatParticipant3 = participant;
                    tLRPC$TL_chatParticipant.user_id = tLRPC$ChatParticipant3.user_id;
                    tLRPC$TL_chatParticipant.date = tLRPC$ChatParticipant3.date;
                    tLRPC$TL_chatParticipant.inviter_id = tLRPC$ChatParticipant3.inviter_id;
                    int iIndexOf = ProfileActivity.this.chatInfo.participants.participants.indexOf(participant);
                    if (iIndexOf >= 0) {
                        ProfileActivity.this.chatInfo.participants.participants.set(iIndexOf, tLRPC$TL_chatParticipant);
                    }
                }
                if (rights != 1 || editingAdmin) {
                    return;
                }
                zArr[0] = true;
            }

            @Override // ir.eitaa.ui.ChatRightsEditActivity.ChatRightsEditActivityDelegate
            public void didChangeOwner(TLRPC$User user2) {
                ProfileActivity.this.undoView.showWithAction(-ProfileActivity.this.chatId, ProfileActivity.this.currentChat.megagroup ? 10 : 9, user2);
            }
        });
        presentFragment(chatRightsEditActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean processOnClickOrPress(final int position) {
        TLRPC$Chat chat;
        final String str;
        String str2;
        TLRPC$UserFull tLRPC$UserFull;
        if (position == this.usernameRow || position == this.setUsernameRow) {
            if (this.userId != 0) {
                TLRPC$User user = getMessagesController().getUser(Long.valueOf(this.userId));
                if (user == null || (str = user.username) == null) {
                    return false;
                }
            } else if (this.chatId == 0 || (chat = getMessagesController().getChat(Long.valueOf(this.chatId))) == null || (str = chat.username) == null) {
                return false;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
            builder.setItems(new CharSequence[]{LocaleController.getString("Copy", R.string.Copy)}, new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$TvfnWXwCS5_NXf4vWvBwVB7rloI
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$processOnClickOrPress$18$ProfileActivity(str, dialogInterface, i);
                }
            });
            showDialog(builder.create());
            return true;
        }
        if (position == this.phoneRow || position == this.numberRow) {
            final TLRPC$User user2 = getMessagesController().getUser(Long.valueOf(this.userId));
            if (user2 == null || (str2 = user2.phone) == null || str2.length() == 0 || getParentActivity() == null) {
                return false;
            }
            AlertDialog.Builder builder2 = new AlertDialog.Builder(getParentActivity());
            ArrayList arrayList = new ArrayList();
            final ArrayList arrayList2 = new ArrayList();
            if (position == this.phoneRow) {
                TLRPC$UserFull tLRPC$UserFull2 = this.userInfo;
                if (tLRPC$UserFull2 != null && tLRPC$UserFull2.phone_calls_available && ConnectionsManager.getInstance(this.currentAccount).socketconnectionState == 3) {
                    arrayList.add(LocaleController.getString("CallViaEitaa ", R.string.CallViaEitaa));
                    arrayList2.add(2);
                    if (Build.VERSION.SDK_INT >= 18 && this.userInfo.video_calls_available) {
                        arrayList.add(LocaleController.getString("VideoCallViaEitaa ", R.string.VideoCallViaEitaa));
                        arrayList2.add(3);
                    }
                }
                arrayList.add(LocaleController.getString("Call", R.string.Call));
                arrayList2.add(0);
            }
            arrayList.add(LocaleController.getString("Copy", R.string.Copy));
            arrayList2.add(1);
            builder2.setItems((CharSequence[]) arrayList.toArray(new CharSequence[0]), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$ElPyF3UApXsYwKaNYSj6qpLQnvY
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$processOnClickOrPress$19$ProfileActivity(arrayList2, user2, dialogInterface, i);
                }
            });
            showDialog(builder2.create());
            return true;
        }
        if (position != this.channelInfoRow && position != this.userInfoRow && position != this.locationRow && position != this.bioRow) {
            return false;
        }
        if (position == this.bioRow && ((tLRPC$UserFull = this.userInfo) == null || TextUtils.isEmpty(tLRPC$UserFull.about))) {
            return false;
        }
        AlertDialog.Builder builder3 = new AlertDialog.Builder(getParentActivity());
        builder3.setItems(new CharSequence[]{LocaleController.getString("Copy", R.string.Copy)}, new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$lPBdHjlb3yrA2lqDCWqJbFFzPE4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$processOnClickOrPress$20$ProfileActivity(position, dialogInterface, i);
            }
        });
        showDialog(builder3.create());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processOnClickOrPress$18, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processOnClickOrPress$18$ProfileActivity(String str, DialogInterface dialogInterface, int i) {
        String str2;
        if (i == 0) {
            try {
                ClipboardManager clipboardManager = (ClipboardManager) ApplicationLoader.applicationContext.getSystemService("clipboard");
                if (this.userId != 0) {
                    str2 = "@" + str;
                    BulletinFactory.of(this).createCopyBulletin(LocaleController.getString("UsernameCopied", R.string.UsernameCopied)).show();
                } else {
                    str2 = "https://" + MessagesController.getInstance(UserConfig.selectedAccount).linkPrefix + "/" + str;
                    BulletinFactory.of(this).createCopyBulletin(LocaleController.getString("LinkCopied", R.string.LinkCopied)).show();
                }
                clipboardManager.setPrimaryClip(ClipData.newPlainText("label", str2));
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processOnClickOrPress$19, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processOnClickOrPress$19$ProfileActivity(ArrayList arrayList, TLRPC$User tLRPC$User, DialogInterface dialogInterface, int i) {
        int iIntValue = ((Integer) arrayList.get(i)).intValue();
        if (iIntValue == 0) {
            try {
                Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:+" + tLRPC$User.phone));
                intent.addFlags(268435456);
                getParentActivity().startActivityForResult(intent, 500);
                return;
            } catch (Exception e) {
                FileLog.e(e);
                return;
            }
        }
        if (iIntValue != 1) {
            if (iIntValue == 2 || iIntValue == 3) {
                boolean z = iIntValue == 3;
                TLRPC$UserFull tLRPC$UserFull = this.userInfo;
                VoIPHelper.startCall(tLRPC$User, z, tLRPC$UserFull != null && tLRPC$UserFull.video_calls_available, getParentActivity(), this.userInfo, getAccountInstance());
                return;
            }
            return;
        }
        try {
            ((ClipboardManager) ApplicationLoader.applicationContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("label", "+" + tLRPC$User.phone));
            BulletinFactory.of(this).createCopyBulletin(LocaleController.getString("PhoneCopied", R.string.PhoneCopied)).show();
        } catch (Exception e2) {
            FileLog.e(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processOnClickOrPress$20, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processOnClickOrPress$20$ProfileActivity(int i, DialogInterface dialogInterface, int i2) {
        try {
            String str = null;
            if (i == this.locationRow) {
                TLRPC$ChatFull tLRPC$ChatFull = this.chatInfo;
                if (tLRPC$ChatFull != null) {
                    TLRPC$ChannelLocation tLRPC$ChannelLocation = tLRPC$ChatFull.location;
                    if (tLRPC$ChannelLocation instanceof TLRPC$TL_channelLocation) {
                        str = ((TLRPC$TL_channelLocation) tLRPC$ChannelLocation).address;
                    }
                }
            } else if (i == this.channelInfoRow) {
                TLRPC$ChatFull tLRPC$ChatFull2 = this.chatInfo;
                if (tLRPC$ChatFull2 != null) {
                    str = tLRPC$ChatFull2.about;
                }
            } else {
                TLRPC$UserFull tLRPC$UserFull = this.userInfo;
                if (tLRPC$UserFull != null) {
                    str = tLRPC$UserFull.about;
                }
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            AndroidUtilities.addToClipboard(str);
            if (i == this.bioRow) {
                BulletinFactory.of(this).createCopyBulletin(LocaleController.getString("BioCopied", R.string.BioCopied)).show();
            } else {
                BulletinFactory.of(this).createCopyBulletin(LocaleController.getString("TextCopied", R.string.TextCopied)).show();
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void leaveChatPressed() {
        AlertsCreator.createClearOrDeleteDialogAlert(this, false, this.currentChat, null, false, true, new MessagesStorage.BooleanCallback() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$_daCi0VfHzbquDti5c3BQU-sh8k
            @Override // ir.eitaa.messenger.MessagesStorage.BooleanCallback
            public final void run(boolean z) {
                this.f$0.lambda$leaveChatPressed$21$ProfileActivity(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$leaveChatPressed$21, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$leaveChatPressed$21$ProfileActivity(boolean z) {
        this.playProfileAnimation = 0;
        NotificationCenter notificationCenter = getNotificationCenter();
        int i = NotificationCenter.closeChats;
        notificationCenter.removeObserver(this, i);
        getNotificationCenter().postNotificationName(i, new Object[0]);
        finishFragment();
        getNotificationCenter().postNotificationName(NotificationCenter.needDeleteDialog, Long.valueOf(-this.currentChat.id), null, this.currentChat, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getChannelParticipants(boolean reload) {
        LongSparseArray<TLRPC$ChatParticipant> longSparseArray;
        if (this.loadingUsers || (longSparseArray = this.participantsMap) == null || this.chatInfo == null) {
            return;
        }
        this.loadingUsers = true;
        final int i = (longSparseArray.size() == 0 || !reload) ? 0 : 300;
        final TLRPC$TL_channels_getParticipants tLRPC$TL_channels_getParticipants = new TLRPC$TL_channels_getParticipants();
        tLRPC$TL_channels_getParticipants.channel = getMessagesController().getInputChannel(this.chatId);
        tLRPC$TL_channels_getParticipants.filter = new TLRPC$TL_channelParticipantsRecent();
        tLRPC$TL_channels_getParticipants.offset = reload ? 0 : this.participantsMap.size();
        tLRPC$TL_channels_getParticipants.limit = 200;
        getConnectionsManager().bindRequestToGuid(getConnectionsManager().sendRequest(tLRPC$TL_channels_getParticipants, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$q78R2_v1qZvPBOqptfs2RP5-JqU
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$getChannelParticipants$23$ProfileActivity(tLRPC$TL_channels_getParticipants, i, tLObject, tLRPC$TL_error);
            }
        }), this.classGuid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getChannelParticipants$23, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getChannelParticipants$23$ProfileActivity(final TLRPC$TL_channels_getParticipants tLRPC$TL_channels_getParticipants, int i, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$oPObzxA6HSANG87hg3an_DuZ0mA
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getChannelParticipants$22$ProfileActivity(tLRPC$TL_error, tLObject, tLRPC$TL_channels_getParticipants);
            }
        }, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getChannelParticipants$22, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getChannelParticipants$22$ProfileActivity(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, TLRPC$TL_channels_getParticipants tLRPC$TL_channels_getParticipants) {
        if (tLRPC$TL_error == null) {
            TLRPC$TL_channels_channelParticipants tLRPC$TL_channels_channelParticipants = (TLRPC$TL_channels_channelParticipants) tLObject;
            getMessagesController().putUsers(tLRPC$TL_channels_channelParticipants.users, false);
            getMessagesController().putChats(tLRPC$TL_channels_channelParticipants.chats, false);
            if (tLRPC$TL_channels_channelParticipants.users.size() < 200) {
                this.usersEndReached = true;
            }
            if (tLRPC$TL_channels_getParticipants.offset == 0) {
                this.participantsMap.clear();
                this.chatInfo.participants = new TLRPC$TL_chatParticipants();
                getMessagesStorage().putUsersAndChats(tLRPC$TL_channels_channelParticipants.users, tLRPC$TL_channels_channelParticipants.chats, true, true);
                getMessagesStorage().updateChannelUsers(this.chatId, tLRPC$TL_channels_channelParticipants.participants);
            }
            for (int i = 0; i < tLRPC$TL_channels_channelParticipants.participants.size(); i++) {
                TLRPC$TL_chatChannelParticipant tLRPC$TL_chatChannelParticipant = new TLRPC$TL_chatChannelParticipant();
                TLRPC$ChannelParticipant tLRPC$ChannelParticipant = tLRPC$TL_channels_channelParticipants.participants.get(i);
                tLRPC$TL_chatChannelParticipant.channelParticipant = tLRPC$ChannelParticipant;
                tLRPC$TL_chatChannelParticipant.inviter_id = tLRPC$ChannelParticipant.inviter_id;
                long peerId = MessageObject.getPeerId(tLRPC$ChannelParticipant.peer);
                tLRPC$TL_chatChannelParticipant.user_id = peerId;
                tLRPC$TL_chatChannelParticipant.date = tLRPC$TL_chatChannelParticipant.channelParticipant.date;
                if (this.participantsMap.indexOfKey(peerId) < 0) {
                    TLRPC$ChatFull tLRPC$ChatFull = this.chatInfo;
                    if (tLRPC$ChatFull.participants == null) {
                        tLRPC$ChatFull.participants = new TLRPC$TL_chatParticipants();
                    }
                    this.chatInfo.participants.participants.add(tLRPC$TL_chatChannelParticipant);
                    this.participantsMap.put(tLRPC$TL_chatChannelParticipant.user_id, tLRPC$TL_chatChannelParticipant);
                }
            }
        }
        this.loadingUsers = false;
        updateListAnimated(true);
    }

    private void setMediaHeaderVisible(boolean visible) {
        if (this.mediaHeaderVisible == visible) {
            return;
        }
        this.mediaHeaderVisible = visible;
        AnimatorSet animatorSet = this.headerAnimatorSet;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = this.headerShadowAnimatorSet;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        final ActionBarMenuItem searchItem = this.sharedMediaLayout.getSearchItem();
        if (!this.mediaHeaderVisible) {
            if (this.callItemVisible) {
                this.callItem.setVisibility(0);
            }
            if (this.videoCallItemVisible) {
                this.videoCallItem.setVisibility(0);
            }
            if (this.editItemVisible) {
                this.editItem.setVisibility(0);
            }
            this.otherItem.setVisibility(0);
        } else if (this.sharedMediaLayout.isSearchItemVisible()) {
            searchItem.setVisibility(0);
        }
        ArrayList arrayList = new ArrayList();
        ActionBarMenuItem actionBarMenuItem = this.callItem;
        Property property = View.ALPHA;
        float[] fArr = new float[1];
        fArr[0] = visible ? 0.0f : 1.0f;
        arrayList.add(ObjectAnimator.ofFloat(actionBarMenuItem, (Property<ActionBarMenuItem, Float>) property, fArr));
        ActionBarMenuItem actionBarMenuItem2 = this.videoCallItem;
        Property property2 = View.ALPHA;
        float[] fArr2 = new float[1];
        fArr2[0] = visible ? 0.0f : 1.0f;
        arrayList.add(ObjectAnimator.ofFloat(actionBarMenuItem2, (Property<ActionBarMenuItem, Float>) property2, fArr2));
        ActionBarMenuItem actionBarMenuItem3 = this.otherItem;
        Property property3 = View.ALPHA;
        float[] fArr3 = new float[1];
        fArr3[0] = visible ? 0.0f : 1.0f;
        arrayList.add(ObjectAnimator.ofFloat(actionBarMenuItem3, (Property<ActionBarMenuItem, Float>) property3, fArr3));
        ActionBarMenuItem actionBarMenuItem4 = this.editItem;
        Property property4 = View.ALPHA;
        float[] fArr4 = new float[1];
        fArr4[0] = visible ? 0.0f : 1.0f;
        arrayList.add(ObjectAnimator.ofFloat(actionBarMenuItem4, (Property<ActionBarMenuItem, Float>) property4, fArr4));
        ActionBarMenuItem actionBarMenuItem5 = this.callItem;
        Property property5 = View.TRANSLATION_Y;
        float[] fArr5 = new float[1];
        fArr5[0] = visible ? -AndroidUtilities.dp(10.0f) : 0.0f;
        arrayList.add(ObjectAnimator.ofFloat(actionBarMenuItem5, (Property<ActionBarMenuItem, Float>) property5, fArr5));
        ActionBarMenuItem actionBarMenuItem6 = this.videoCallItem;
        Property property6 = View.TRANSLATION_Y;
        float[] fArr6 = new float[1];
        fArr6[0] = visible ? -AndroidUtilities.dp(10.0f) : 0.0f;
        arrayList.add(ObjectAnimator.ofFloat(actionBarMenuItem6, (Property<ActionBarMenuItem, Float>) property6, fArr6));
        ActionBarMenuItem actionBarMenuItem7 = this.otherItem;
        Property property7 = View.TRANSLATION_Y;
        float[] fArr7 = new float[1];
        fArr7[0] = visible ? -AndroidUtilities.dp(10.0f) : 0.0f;
        arrayList.add(ObjectAnimator.ofFloat(actionBarMenuItem7, (Property<ActionBarMenuItem, Float>) property7, fArr7));
        ActionBarMenuItem actionBarMenuItem8 = this.editItem;
        Property property8 = View.TRANSLATION_Y;
        float[] fArr8 = new float[1];
        fArr8[0] = visible ? -AndroidUtilities.dp(10.0f) : 0.0f;
        arrayList.add(ObjectAnimator.ofFloat(actionBarMenuItem8, (Property<ActionBarMenuItem, Float>) property8, fArr8));
        Property property9 = View.ALPHA;
        float[] fArr9 = new float[1];
        fArr9[0] = visible ? 1.0f : 0.0f;
        arrayList.add(ObjectAnimator.ofFloat(searchItem, (Property<ActionBarMenuItem, Float>) property9, fArr9));
        Property property10 = View.TRANSLATION_Y;
        float[] fArr10 = new float[1];
        fArr10[0] = visible ? 0.0f : AndroidUtilities.dp(10.0f);
        arrayList.add(ObjectAnimator.ofFloat(searchItem, (Property<ActionBarMenuItem, Float>) property10, fArr10));
        ActionBar actionBar = this.actionBar;
        Property<ActionBar, Float> property11 = this.ACTIONBAR_HEADER_PROGRESS;
        float[] fArr11 = new float[1];
        fArr11[0] = visible ? 1.0f : 0.0f;
        arrayList.add(ObjectAnimator.ofFloat(actionBar, property11, fArr11));
        SimpleTextView simpleTextView = this.onlineTextView[1];
        Property property12 = View.ALPHA;
        float[] fArr12 = new float[1];
        fArr12[0] = visible ? 0.0f : 1.0f;
        arrayList.add(ObjectAnimator.ofFloat(simpleTextView, (Property<SimpleTextView, Float>) property12, fArr12));
        AudioPlayerAlert.ClippingTextViewSwitcher clippingTextViewSwitcher = this.mediaCounterTextView;
        Property property13 = View.ALPHA;
        float[] fArr13 = new float[1];
        fArr13[0] = visible ? 1.0f : 0.0f;
        arrayList.add(ObjectAnimator.ofFloat(clippingTextViewSwitcher, (Property<AudioPlayerAlert.ClippingTextViewSwitcher, Float>) property13, fArr13));
        if (visible) {
            arrayList.add(ObjectAnimator.ofFloat(this, this.HEADER_SHADOW, 0.0f));
        }
        AnimatorSet animatorSet3 = new AnimatorSet();
        this.headerAnimatorSet = animatorSet3;
        animatorSet3.playTogether(arrayList);
        this.headerAnimatorSet.setInterpolator(CubicBezierInterpolator.DEFAULT);
        this.headerAnimatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.ProfileActivity.26
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                if (ProfileActivity.this.headerAnimatorSet != null) {
                    if (ProfileActivity.this.mediaHeaderVisible) {
                        if (ProfileActivity.this.callItemVisible) {
                            ProfileActivity.this.callItem.setVisibility(4);
                        }
                        if (ProfileActivity.this.videoCallItemVisible) {
                            ProfileActivity.this.videoCallItem.setVisibility(4);
                        }
                        if (ProfileActivity.this.editItemVisible) {
                            ProfileActivity.this.editItem.setVisibility(4);
                        }
                        ProfileActivity.this.otherItem.setVisibility(4);
                    } else {
                        if (ProfileActivity.this.sharedMediaLayout.isSearchItemVisible()) {
                            searchItem.setVisibility(0);
                        }
                        ProfileActivity.this.headerShadowAnimatorSet = new AnimatorSet();
                        AnimatorSet animatorSet4 = ProfileActivity.this.headerShadowAnimatorSet;
                        ProfileActivity profileActivity = ProfileActivity.this;
                        animatorSet4.playTogether(ObjectAnimator.ofFloat(profileActivity, (Property<ProfileActivity, Float>) profileActivity.HEADER_SHADOW, 1.0f));
                        ProfileActivity.this.headerShadowAnimatorSet.setDuration(100L);
                        ProfileActivity.this.headerShadowAnimatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.ProfileActivity.26.1
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animation2) {
                                ProfileActivity.this.headerShadowAnimatorSet = null;
                            }
                        });
                        ProfileActivity.this.headerShadowAnimatorSet.start();
                    }
                }
                ProfileActivity.this.headerAnimatorSet = null;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                ProfileActivity.this.headerAnimatorSet = null;
            }
        });
        this.headerAnimatorSet.setDuration(150L);
        this.headerAnimatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openAddMember() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("addToGroup", true);
        bundle.putLong("chatId", this.currentChat.id);
        GroupCreateActivity groupCreateActivity = new GroupCreateActivity(bundle);
        groupCreateActivity.setInfo(this.chatInfo);
        TLRPC$ChatFull tLRPC$ChatFull = this.chatInfo;
        if (tLRPC$ChatFull != null && tLRPC$ChatFull.participants != null) {
            LongSparseArray<TLObject> longSparseArray = new LongSparseArray<>();
            for (int i = 0; i < this.chatInfo.participants.participants.size(); i++) {
                longSparseArray.put(this.chatInfo.participants.participants.get(i).user_id, null);
            }
            groupCreateActivity.setIgnoreUsers(longSparseArray);
        }
        groupCreateActivity.setDelegate(new GroupCreateActivity.ContactsAddActivityDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$tkKP5s5FlKWPIK6TbsyXxrGHcuQ
            @Override // ir.eitaa.ui.GroupCreateActivity.ContactsAddActivityDelegate
            public final void didSelectUsers(ArrayList arrayList, int i2) {
                this.f$0.lambda$openAddMember$24$ProfileActivity(arrayList, i2);
            }

            @Override // ir.eitaa.ui.GroupCreateActivity.ContactsAddActivityDelegate
            public /* synthetic */ void needAddBot(TLRPC$User tLRPC$User) {
                GroupCreateActivity.ContactsAddActivityDelegate.CC.$default$needAddBot(this, tLRPC$User);
            }
        });
        presentFragment(groupCreateActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$openAddMember$24, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$openAddMember$24$ProfileActivity(ArrayList arrayList, int i) {
        HashSet hashSet = new HashSet();
        if (this.chatInfo.participants.participants != null) {
            for (int i2 = 0; i2 < this.chatInfo.participants.participants.size(); i2++) {
                hashSet.add(Long.valueOf(this.chatInfo.participants.participants.get(i2).user_id));
            }
        }
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            TLRPC$User tLRPC$User = (TLRPC$User) arrayList.get(i3);
            getMessagesController().addUserToChat(this.chatId, tLRPC$User, i, null, this, null);
            if (!hashSet.contains(Long.valueOf(tLRPC$User.id))) {
                TLRPC$ChatFull tLRPC$ChatFull = this.chatInfo;
                if (tLRPC$ChatFull.participants == null) {
                    tLRPC$ChatFull.participants = new TLRPC$TL_chatParticipants();
                }
                if (ChatObject.isChannel(this.currentChat)) {
                    TLRPC$TL_chatChannelParticipant tLRPC$TL_chatChannelParticipant = new TLRPC$TL_chatChannelParticipant();
                    TLRPC$TL_channelParticipant tLRPC$TL_channelParticipant = new TLRPC$TL_channelParticipant();
                    tLRPC$TL_chatChannelParticipant.channelParticipant = tLRPC$TL_channelParticipant;
                    tLRPC$TL_channelParticipant.inviter_id = getUserConfig().getClientUserId();
                    tLRPC$TL_chatChannelParticipant.channelParticipant.peer = new TLRPC$TL_peerUser();
                    TLRPC$ChannelParticipant tLRPC$ChannelParticipant = tLRPC$TL_chatChannelParticipant.channelParticipant;
                    tLRPC$ChannelParticipant.peer.user_id = tLRPC$User.id;
                    tLRPC$ChannelParticipant.date = getConnectionsManager().getCurrentTime();
                    tLRPC$TL_chatChannelParticipant.user_id = tLRPC$User.id;
                    this.chatInfo.participants.participants.add(tLRPC$TL_chatChannelParticipant);
                } else {
                    TLRPC$TL_chatParticipant tLRPC$TL_chatParticipant = new TLRPC$TL_chatParticipant();
                    tLRPC$TL_chatParticipant.user_id = tLRPC$User.id;
                    tLRPC$TL_chatParticipant.inviter_id = getAccountInstance().getUserConfig().clientUserId;
                    this.chatInfo.participants.participants.add(tLRPC$TL_chatParticipant);
                }
                this.chatInfo.participants_count++;
                getMessagesController().putUser(tLRPC$User, false);
            }
        }
        updateListAnimated(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkListViewScroll() {
        View childAt;
        if (this.listView.getVisibility() != 0) {
            return;
        }
        if (this.sharedMediaLayoutAttached) {
            this.sharedMediaLayout.setVisibleHeight(this.listView.getMeasuredHeight() - this.sharedMediaLayout.getTop());
        }
        if (this.listView.getChildCount() <= 0 || this.openAnimationInProgress) {
            return;
        }
        int i = 0;
        while (true) {
            if (i >= this.listView.getChildCount()) {
                childAt = null;
                break;
            }
            RecyclerListView recyclerListView = this.listView;
            if (recyclerListView.getChildAdapterPosition(recyclerListView.getChildAt(i)) == 0) {
                childAt = this.listView.getChildAt(i);
                break;
            }
            i++;
        }
        RecyclerListView.Holder holder = childAt != null ? (RecyclerListView.Holder) this.listView.findContainingViewHolder(childAt) : null;
        int top = childAt == null ? 0 : childAt.getTop();
        int adapterPosition = holder != null ? holder.getAdapterPosition() : -1;
        if (top < 0 || adapterPosition != 0) {
            top = 0;
        }
        boolean z = this.imageUpdater == null && this.actionBar.isSearchFieldVisible();
        int i2 = this.sharedMediaRow;
        if (i2 != -1 && !z) {
            RecyclerListView.Holder holder2 = (RecyclerListView.Holder) this.listView.findViewHolderForAdapterPosition(i2);
            z = holder2 != null && holder2.itemView.getTop() <= 0;
        }
        setMediaHeaderVisible(z);
        float f = top;
        if (this.extraHeight != f) {
            this.extraHeight = f;
            this.topView.invalidate();
            if (this.playProfileAnimation != 0) {
                this.allowProfileAnimation = this.extraHeight != 0.0f;
            }
            needLayout(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSelectedMediaTabText() {
        SharedMediaLayout sharedMediaLayout = this.sharedMediaLayout;
        if (sharedMediaLayout == null || this.mediaCounterTextView == null) {
            return;
        }
        int closestTab = sharedMediaLayout.getClosestTab();
        int[] lastMediaCount = this.sharedMediaPreloader.getLastMediaCount();
        if (closestTab == 0) {
            this.mediaCounterTextView.setText(LocaleController.formatPluralString("Media", lastMediaCount[0]));
            return;
        }
        if (closestTab == 1) {
            this.mediaCounterTextView.setText(LocaleController.formatPluralString("Files", lastMediaCount[1]));
            return;
        }
        if (closestTab == 2) {
            this.mediaCounterTextView.setText(LocaleController.formatPluralString("Voice", lastMediaCount[2]));
            return;
        }
        if (closestTab == 3) {
            this.mediaCounterTextView.setText(LocaleController.getString("SharedLinksTab2", R.string.SharedLinksTab2));
            return;
        }
        if (closestTab == 4) {
            this.mediaCounterTextView.setText(LocaleController.formatPluralString("MusicFiles", lastMediaCount[4]));
            return;
        }
        if (closestTab == 5) {
            this.mediaCounterTextView.setText(LocaleController.formatPluralString("GIFs", lastMediaCount[5]));
        } else if (closestTab == 6) {
            this.mediaCounterTextView.setText(LocaleController.formatPluralString("CommonGroups", this.userInfo.common_chats_count));
        } else if (closestTab == 7) {
            this.mediaCounterTextView.setText(this.onlineTextView[1].getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void needLayout(boolean animated) {
        BackupImageView currentItemView;
        ValueAnimator valueAnimator;
        TLRPC$ChatFull tLRPC$ChatFull;
        int i = 0;
        int currentActionBarHeight = (this.actionBar.getOccupyStatusBar() ? AndroidUtilities.statusBarHeight : 0) + ActionBar.getCurrentActionBarHeight();
        RecyclerListView recyclerListView = this.listView;
        if (recyclerListView != null && !this.openAnimationInProgress) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) recyclerListView.getLayoutParams();
            if (layoutParams.topMargin != currentActionBarHeight) {
                layoutParams.topMargin = currentActionBarHeight;
                this.listView.setLayoutParams(layoutParams);
            }
        }
        if (this.avatarContainer != null) {
            float fMin = Math.min(1.0f, this.extraHeight / AndroidUtilities.dp(88.0f));
            this.listView.setTopGlowOffset((int) this.extraHeight);
            this.listView.setOverScrollMode((this.extraHeight <= ((float) AndroidUtilities.dp(88.0f)) || this.extraHeight >= ((float) (this.listView.getMeasuredWidth() - currentActionBarHeight))) ? 0 : 2);
            RLottieImageView rLottieImageView = this.writeButton;
            if (rLottieImageView != null) {
                rLottieImageView.setTranslationY(((((this.actionBar.getOccupyStatusBar() ? AndroidUtilities.statusBarHeight : 0) + ActionBar.getCurrentActionBarHeight()) + this.extraHeight) + this.searchTransitionOffset) - AndroidUtilities.dp(29.5f));
                if (!this.openAnimationInProgress) {
                    boolean z = fMin > 0.2f && !this.searchMode && (this.imageUpdater == null || this.setAvatarRow == -1);
                    if (z && this.chatId != 0) {
                        z = (!ChatObject.isChannel(this.currentChat) || this.currentChat.megagroup || (tLRPC$ChatFull = this.chatInfo) == null || tLRPC$ChatFull.linked_chat_id == 0 || this.infoHeaderRow == -1) ? false : true;
                    }
                    if (z != (this.writeButton.getTag() == null)) {
                        if (z) {
                            this.writeButton.setTag(null);
                        } else {
                            this.writeButton.setTag(0);
                        }
                        AnimatorSet animatorSet = this.writeButtonAnimation;
                        if (animatorSet != null) {
                            this.writeButtonAnimation = null;
                            animatorSet.cancel();
                        }
                        if (animated) {
                            AnimatorSet animatorSet2 = new AnimatorSet();
                            this.writeButtonAnimation = animatorSet2;
                            if (z) {
                                animatorSet2.setInterpolator(new DecelerateInterpolator());
                                this.writeButtonAnimation.playTogether(ObjectAnimator.ofFloat(this.writeButton, (Property<RLottieImageView, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.writeButton, (Property<RLottieImageView, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.writeButton, (Property<RLottieImageView, Float>) View.ALPHA, 1.0f));
                            } else {
                                animatorSet2.setInterpolator(new AccelerateInterpolator());
                                this.writeButtonAnimation.playTogether(ObjectAnimator.ofFloat(this.writeButton, (Property<RLottieImageView, Float>) View.SCALE_X, 0.2f), ObjectAnimator.ofFloat(this.writeButton, (Property<RLottieImageView, Float>) View.SCALE_Y, 0.2f), ObjectAnimator.ofFloat(this.writeButton, (Property<RLottieImageView, Float>) View.ALPHA, 0.0f));
                            }
                            this.writeButtonAnimation.setDuration(150L);
                            this.writeButtonAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.ProfileActivity.27
                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animation) {
                                    if (ProfileActivity.this.writeButtonAnimation == null || !ProfileActivity.this.writeButtonAnimation.equals(animation)) {
                                        return;
                                    }
                                    ProfileActivity.this.writeButtonAnimation = null;
                                }
                            });
                            this.writeButtonAnimation.start();
                        } else {
                            this.writeButton.setScaleX(z ? 1.0f : 0.2f);
                            this.writeButton.setScaleY(z ? 1.0f : 0.2f);
                            this.writeButton.setAlpha(z ? 1.0f : 0.0f);
                        }
                    }
                }
            }
            this.avatarX = (-AndroidUtilities.dpf2(47.0f)) * fMin;
            float f = AndroidUtilities.density;
            this.avatarY = (((this.actionBar.getOccupyStatusBar() ? AndroidUtilities.statusBarHeight : 0) + ((ActionBar.getCurrentActionBarHeight() / 2.0f) * (fMin + 1.0f))) - (f * 21.0f)) + (f * 27.0f * fMin) + this.actionBar.getTranslationY();
            float f2 = this.openAnimationInProgress ? this.initialAnimationExtraHeight : this.extraHeight;
            if (f2 > AndroidUtilities.dp(88.0f) || this.isPulledDown) {
                float fMax = Math.max(0.0f, Math.min(1.0f, (f2 - AndroidUtilities.dp(88.0f)) / ((this.listView.getMeasuredWidth() - currentActionBarHeight) - AndroidUtilities.dp(88.0f))));
                this.expandProgress = fMax;
                this.avatarScale = AndroidUtilities.lerp(1.4285715f, 2.4285715f, Math.min(1.0f, fMax * 3.0f));
                float fMin2 = Math.min(AndroidUtilities.dpf2(2000.0f), Math.max(AndroidUtilities.dpf2(1100.0f), Math.abs(this.listViewVelocityY))) / AndroidUtilities.dpf2(1100.0f);
                if (this.allowPullingDown && (this.openingAvatar || this.expandProgress >= 0.33f)) {
                    if (!this.isPulledDown) {
                        ActionBarMenuItem actionBarMenuItem = this.otherItem;
                        if (actionBarMenuItem != null) {
                            actionBarMenuItem.showSubItem(21);
                            if (this.imageUpdater != null) {
                                this.otherItem.showSubItem(36);
                                this.otherItem.showSubItem(34);
                                this.otherItem.showSubItem(35);
                                this.otherItem.hideSubItem(31);
                            }
                        }
                        ActionBarMenuItem actionBarMenuItem2 = this.searchItem;
                        if (actionBarMenuItem2 != null) {
                            actionBarMenuItem2.setEnabled(false);
                        }
                        this.isPulledDown = true;
                        this.overlaysView.setOverlaysVisible(true, fMin2);
                        this.avatarsViewPagerIndicatorView.refreshVisibility(fMin2);
                        this.avatarsViewPager.setCreateThumbFromParent(true);
                        this.avatarsViewPager.getAdapter().notifyDataSetChanged();
                        this.expandAnimator.cancel();
                        float fLerp = AndroidUtilities.lerp(this.expandAnimatorValues, this.currentExpanAnimatorFracture);
                        float[] fArr = this.expandAnimatorValues;
                        fArr[0] = fLerp;
                        fArr[1] = 1.0f;
                        this.expandAnimator.setDuration((long) (((1.0f - fLerp) * 250.0f) / fMin2));
                        this.expandAnimator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.ProfileActivity.28
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animation) {
                                ProfileActivity.this.setForegroundImage(false);
                                ProfileActivity.this.avatarsViewPager.setAnimatedFileMaybe(ProfileActivity.this.avatarImage.getImageReceiver().getAnimation());
                                ProfileActivity.this.avatarsViewPager.resetCurrentItem();
                            }

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animation) {
                                ProfileActivity.this.expandAnimator.removeListener(this);
                                ProfileActivity.this.topView.setBackgroundColor(-16777216);
                                ProfileActivity.this.avatarContainer.setVisibility(8);
                                ProfileActivity.this.avatarsViewPager.setVisibility(0);
                            }
                        });
                        this.expandAnimator.start();
                    }
                    ViewGroup.LayoutParams layoutParams2 = this.avatarsViewPager.getLayoutParams();
                    layoutParams2.width = this.listView.getMeasuredWidth();
                    float f3 = f2 + currentActionBarHeight;
                    layoutParams2.height = (int) f3;
                    this.avatarsViewPager.requestLayout();
                    if (!this.expandAnimator.isRunning()) {
                        float fDp = (this.openAnimationInProgress && this.playProfileAnimation == 2) ? (-(1.0f - this.animationProgress)) * AndroidUtilities.dp(50.0f) : 0.0f;
                        this.nameTextView[1].setTranslationX(AndroidUtilities.dpf2(16.0f) - this.nameTextView[1].getLeft());
                        this.nameTextView[1].setTranslationY(((f3 - AndroidUtilities.dpf2(38.0f)) - this.nameTextView[1].getBottom()) + fDp);
                        this.onlineTextView[1].setTranslationX(AndroidUtilities.dpf2(16.0f) - this.onlineTextView[1].getLeft());
                        this.onlineTextView[1].setTranslationY(((f3 - AndroidUtilities.dpf2(18.0f)) - this.onlineTextView[1].getBottom()) + fDp);
                        this.mediaCounterTextView.setTranslationX(this.onlineTextView[1].getTranslationX());
                        this.mediaCounterTextView.setTranslationY(this.onlineTextView[1].getTranslationY());
                    }
                } else {
                    if (this.isPulledDown) {
                        this.isPulledDown = false;
                        ActionBarMenuItem actionBarMenuItem3 = this.otherItem;
                        if (actionBarMenuItem3 != null) {
                            actionBarMenuItem3.hideSubItem(21);
                            if (this.imageUpdater != null) {
                                this.otherItem.hideSubItem(34);
                                this.otherItem.hideSubItem(35);
                                this.otherItem.showSubItem(36);
                                this.otherItem.showSubItem(31);
                                this.otherItem.showSubItem(30);
                            }
                        }
                        ActionBarMenuItem actionBarMenuItem4 = this.searchItem;
                        if (actionBarMenuItem4 != null) {
                            actionBarMenuItem4.setEnabled(!this.scrolling);
                        }
                        this.overlaysView.setOverlaysVisible(false, fMin2);
                        this.avatarsViewPagerIndicatorView.refreshVisibility(fMin2);
                        this.expandAnimator.cancel();
                        this.avatarImage.getImageReceiver().setAllowStartAnimation(true);
                        this.avatarImage.getImageReceiver().startAnimation();
                        float fLerp2 = AndroidUtilities.lerp(this.expandAnimatorValues, this.currentExpanAnimatorFracture);
                        float[] fArr2 = this.expandAnimatorValues;
                        fArr2[0] = fLerp2;
                        fArr2[1] = 0.0f;
                        if (!this.isInLandscapeMode) {
                            this.expandAnimator.setDuration((long) ((fLerp2 * 250.0f) / fMin2));
                        } else {
                            this.expandAnimator.setDuration(0L);
                        }
                        this.topView.setBackgroundColor(Theme.getColor("avatar_backgroundActionBarBlue"));
                        if (!this.doNotSetForeground && (currentItemView = this.avatarsViewPager.getCurrentItemView()) != null) {
                            this.avatarImage.setForegroundImageDrawable(currentItemView.getImageReceiver().getDrawableSafe());
                        }
                        this.avatarImage.setForegroundAlpha(1.0f);
                        this.avatarContainer.setVisibility(0);
                        this.avatarsViewPager.setVisibility(8);
                        this.expandAnimator.start();
                    }
                    this.avatarContainer.setScaleX(this.avatarScale);
                    this.avatarContainer.setScaleY(this.avatarScale);
                    ValueAnimator valueAnimator2 = this.expandAnimator;
                    if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
                        refreshNameAndOnlineXY();
                        this.nameTextView[1].setTranslationX(this.nameX);
                        this.nameTextView[1].setTranslationY(this.nameY);
                        this.onlineTextView[1].setTranslationX(this.onlineX);
                        this.onlineTextView[1].setTranslationY(this.onlineY);
                        this.mediaCounterTextView.setTranslationX(this.onlineX);
                        this.mediaCounterTextView.setTranslationY(this.onlineY);
                    }
                }
            }
            if (this.openAnimationInProgress && this.playProfileAnimation == 2) {
                float currentActionBarHeight2 = (((this.actionBar.getOccupyStatusBar() ? AndroidUtilities.statusBarHeight : 0) + (ActionBar.getCurrentActionBarHeight() / 2.0f)) - (AndroidUtilities.density * 21.0f)) + this.actionBar.getTranslationY();
                this.nameTextView[0].setTranslationX(0.0f);
                double d = currentActionBarHeight2;
                this.nameTextView[0].setTranslationY(((float) Math.floor(d)) + AndroidUtilities.dp(1.3f));
                this.onlineTextView[0].setTranslationX(0.0f);
                this.onlineTextView[0].setTranslationY(((float) Math.floor(d)) + AndroidUtilities.dp(24.0f));
                this.nameTextView[0].setScaleX(1.0f);
                this.nameTextView[0].setScaleY(1.0f);
                this.nameTextView[1].setPivotY(r4[1].getMeasuredHeight());
                this.nameTextView[1].setScaleX(1.67f);
                this.nameTextView[1].setScaleY(1.67f);
                this.avatarScale = AndroidUtilities.lerp(1.0f, 2.4285715f, this.animationProgress);
                this.avatarImage.setRoundRadius((int) AndroidUtilities.lerp(AndroidUtilities.dpf2(21.0f), 0.0f, this.animationProgress));
                this.avatarContainer.setTranslationX(AndroidUtilities.lerp(0.0f, 0.0f, this.animationProgress));
                this.avatarContainer.setTranslationY(AndroidUtilities.lerp((float) Math.ceil(d), 0.0f, this.animationProgress));
                float measuredWidth = (this.avatarContainer.getMeasuredWidth() - AndroidUtilities.dp(42.0f)) * this.avatarScale;
                this.timeItem.setTranslationX(this.avatarContainer.getX() + AndroidUtilities.dp(16.0f) + measuredWidth);
                this.timeItem.setTranslationY(this.avatarContainer.getY() + AndroidUtilities.dp(15.0f) + measuredWidth);
                this.avatarContainer.setScaleX(this.avatarScale);
                this.avatarContainer.setScaleY(this.avatarScale);
                this.overlaysView.setAlphaValue(this.animationProgress, false);
                this.actionBar.setItemsColor(ColorUtils.blendARGB(Theme.getColor("actionBarDefaultIcon"), -1, this.animationProgress), false);
                ScamDrawable scamDrawable = this.scamDrawable;
                if (scamDrawable != null) {
                    scamDrawable.setColor(ColorUtils.blendARGB(Theme.getColor("avatar_subtitleInProfileBlue"), Color.argb(179, 255, 255, 255), this.animationProgress));
                }
                Drawable drawable = this.lockIconDrawable;
                if (drawable != null) {
                    drawable.setColorFilter(ColorUtils.blendARGB(Theme.getColor("chat_lockIcon"), -1, this.animationProgress), PorterDuff.Mode.MULTIPLY);
                }
                CrossfadeDrawable crossfadeDrawable = this.verifiedCrossfadeDrawable;
                if (crossfadeDrawable != null) {
                    crossfadeDrawable.setProgress(this.animationProgress);
                    this.nameTextView[1].invalidate();
                }
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.avatarContainer.getLayoutParams();
                int iLerp = (int) AndroidUtilities.lerp(AndroidUtilities.dpf2(42.0f), (this.extraHeight + currentActionBarHeight) / this.avatarScale, this.animationProgress);
                layoutParams3.height = iLerp;
                layoutParams3.width = iLerp;
                layoutParams3.leftMargin = (int) AndroidUtilities.lerp(AndroidUtilities.dpf2(64.0f), 0.0f, this.animationProgress);
                this.avatarContainer.requestLayout();
            } else if (this.extraHeight <= AndroidUtilities.dp(88.0f)) {
                this.avatarScale = ((fMin * 18.0f) + 42.0f) / 42.0f;
                float f4 = (0.12f * fMin) + 1.0f;
                ValueAnimator valueAnimator3 = this.expandAnimator;
                if (valueAnimator3 == null || !valueAnimator3.isRunning()) {
                    this.avatarContainer.setScaleX(this.avatarScale);
                    this.avatarContainer.setScaleY(this.avatarScale);
                    this.avatarContainer.setTranslationX(this.avatarX);
                    this.avatarContainer.setTranslationY((float) Math.ceil(this.avatarY));
                    float fDp2 = (AndroidUtilities.dp(42.0f) * this.avatarScale) - AndroidUtilities.dp(42.0f);
                    this.timeItem.setTranslationX(this.avatarContainer.getX() + AndroidUtilities.dp(16.0f) + fDp2);
                    this.timeItem.setTranslationY(this.avatarContainer.getY() + AndroidUtilities.dp(15.0f) + fDp2);
                }
                this.nameX = AndroidUtilities.density * (-21.0f) * fMin;
                this.nameY = ((float) Math.floor(this.avatarY)) + AndroidUtilities.dp(1.3f) + (AndroidUtilities.dp(7.0f) * fMin);
                this.onlineX = AndroidUtilities.density * (-21.0f) * fMin;
                this.onlineY = ((float) Math.floor(this.avatarY)) + AndroidUtilities.dp(24.0f) + (((float) Math.floor(AndroidUtilities.density * 11.0f)) * fMin);
                while (true) {
                    SimpleTextView[] simpleTextViewArr = this.nameTextView;
                    if (i >= simpleTextViewArr.length) {
                        break;
                    }
                    if (simpleTextViewArr[i] != null) {
                        ValueAnimator valueAnimator4 = this.expandAnimator;
                        if (valueAnimator4 == null || !valueAnimator4.isRunning()) {
                            this.nameTextView[i].setTranslationX(this.nameX);
                            this.nameTextView[i].setTranslationY(this.nameY);
                            this.onlineTextView[i].setTranslationX(this.onlineX);
                            this.onlineTextView[i].setTranslationY(this.onlineY);
                            if (i == 1) {
                                this.mediaCounterTextView.setTranslationX(this.onlineX);
                                this.mediaCounterTextView.setTranslationY(this.onlineY);
                            }
                        }
                        this.nameTextView[i].setScaleX(f4);
                        this.nameTextView[i].setScaleY(f4);
                    }
                    i++;
                }
            }
            if (!this.openAnimationInProgress && ((valueAnimator = this.expandAnimator) == null || !valueAnimator.isRunning())) {
                needLayoutText(fMin);
            }
        }
        if (this.isPulledDown || (this.overlaysView.animator != null && this.overlaysView.animator.isRunning())) {
            ViewGroup.LayoutParams layoutParams4 = this.overlaysView.getLayoutParams();
            layoutParams4.width = this.listView.getMeasuredWidth();
            layoutParams4.height = (int) (this.extraHeight + currentActionBarHeight);
            this.overlaysView.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setForegroundImage(boolean secondParent) {
        Drawable drawable = this.avatarImage.getImageReceiver().getDrawable();
        String str = null;
        if (drawable instanceof AnimatedFileDrawable) {
            AnimatedFileDrawable animatedFileDrawable = (AnimatedFileDrawable) drawable;
            this.avatarImage.setForegroundImage(null, null, animatedFileDrawable);
            if (secondParent) {
                animatedFileDrawable.addSecondParentView(this.avatarImage);
                return;
            }
            return;
        }
        ImageLocation imageLocation = this.avatarsViewPager.getImageLocation(0);
        if (imageLocation != null && imageLocation.imageType == 2) {
            str = ImageLoader.AUTOPLAY_FILTER;
        }
        this.avatarImage.setForegroundImage(imageLocation, str, drawable);
    }

    private void refreshNameAndOnlineXY() {
        this.nameX = AndroidUtilities.dp(-21.0f) + (this.avatarContainer.getMeasuredWidth() * (this.avatarScale - 1.4285715f));
        this.nameY = ((float) Math.floor(this.avatarY)) + AndroidUtilities.dp(1.3f) + AndroidUtilities.dp(7.0f) + ((this.avatarContainer.getMeasuredHeight() * (this.avatarScale - 1.4285715f)) / 2.0f);
        this.onlineX = AndroidUtilities.dp(-21.0f) + (this.avatarContainer.getMeasuredWidth() * (this.avatarScale - 1.4285715f));
        this.onlineY = ((float) Math.floor(this.avatarY)) + AndroidUtilities.dp(24.0f) + ((float) Math.floor(AndroidUtilities.density * 11.0f)) + ((this.avatarContainer.getMeasuredHeight() * (this.avatarScale - 1.4285715f)) / 2.0f);
    }

    public RecyclerListView getListView() {
        return this.listView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void needLayoutText(float diff) {
        float scaleX = this.nameTextView[1].getScaleX();
        float f = this.extraHeight > ((float) AndroidUtilities.dp(88.0f)) ? 1.67f : 1.12f;
        if (this.extraHeight <= AndroidUtilities.dp(88.0f) || scaleX == f) {
            int iDp = AndroidUtilities.isTablet() ? AndroidUtilities.dp(490.0f) : AndroidUtilities.displaySize.x;
            this.avatarsViewPagerIndicatorView.getSecondaryMenuItem();
            int i = this.editItemVisible ? 48 : 0;
            if (this.callItemVisible) {
                i += 48;
            }
            if (this.videoCallItemVisible) {
                i += 48;
            }
            if (this.searchItem != null) {
                i += 48;
            }
            int iDp2 = AndroidUtilities.dp((i * (1.0f - this.mediaHeaderAnimationProgress)) + 40.0f + 126.0f);
            int i2 = iDp - iDp2;
            float f2 = iDp;
            int iMax = (int) ((f2 - (iDp2 * Math.max(0.0f, 1.0f - (diff != 1.0f ? (0.15f * diff) / (1.0f - diff) : 1.0f)))) - this.nameTextView[1].getTranslationX());
            float fMeasureText = (this.nameTextView[1].getPaint().measureText(this.nameTextView[1].getText().toString()) * scaleX) + this.nameTextView[1].getSideDrawablesSize();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nameTextView[1].getLayoutParams();
            int i3 = layoutParams.width;
            float f3 = iMax;
            if (f3 < fMeasureText) {
                layoutParams.width = Math.max(i2, (int) Math.ceil((iMax - AndroidUtilities.dp(24.0f)) / (((f - scaleX) * 7.0f) + scaleX)));
            } else {
                layoutParams.width = (int) Math.ceil(fMeasureText);
            }
            int iMin = (int) Math.min(((f2 - this.nameTextView[1].getX()) / scaleX) - AndroidUtilities.dp(8.0f), layoutParams.width);
            layoutParams.width = iMin;
            if (iMin != i3) {
                this.nameTextView[1].requestLayout();
            }
            float fMeasureText2 = this.onlineTextView[1].getPaint().measureText(this.onlineTextView[1].getText().toString());
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.onlineTextView[1].getLayoutParams();
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.mediaCounterTextView.getLayoutParams();
            int i4 = layoutParams2.width;
            int iCeil = (int) Math.ceil(this.onlineTextView[1].getTranslationX() + AndroidUtilities.dp(8.0f) + (AndroidUtilities.dp(40.0f) * (1.0f - diff)));
            layoutParams2.rightMargin = iCeil;
            layoutParams3.rightMargin = iCeil;
            if (f3 < fMeasureText2) {
                int iCeil2 = (int) Math.ceil(iMax);
                layoutParams2.width = iCeil2;
                layoutParams3.width = iCeil2;
            } else {
                layoutParams2.width = -2;
                layoutParams3.width = -2;
            }
            if (i4 != layoutParams2.width) {
                this.onlineTextView[1].requestLayout();
                this.mediaCounterTextView.requestLayout();
            }
        }
    }

    private void fixLayout() {
        View view = this.fragmentView;
        if (view == null) {
            return;
        }
        view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: ir.eitaa.ui.ProfileActivity.29
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (((BaseFragment) ProfileActivity.this).fragmentView != null) {
                    ProfileActivity.this.checkListViewScroll();
                    ProfileActivity.this.needLayout(true);
                    ((BaseFragment) ProfileActivity.this).fragmentView.getViewTreeObserver().removeOnPreDrawListener(this);
                }
                return true;
            }
        });
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onConfigurationChanged(Configuration newConfig) {
        View viewFindViewByPosition;
        super.onConfigurationChanged(newConfig);
        SharedMediaLayout sharedMediaLayout = this.sharedMediaLayout;
        if (sharedMediaLayout != null) {
            sharedMediaLayout.onConfigurationChanged(newConfig);
        }
        invalidateIsInLandscapeMode();
        if (this.isInLandscapeMode && this.isPulledDown && (viewFindViewByPosition = this.layoutManager.findViewByPosition(0)) != null) {
            this.listView.scrollBy(0, viewFindViewByPosition.getTop() - AndroidUtilities.dp(88.0f));
        }
        fixLayout();
    }

    private void invalidateIsInLandscapeMode() {
        Point point = new Point();
        getParentActivity().getWindowManager().getDefaultDisplay().getSize(point);
        this.isInLandscapeMode = point.x > point.y;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment, ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, final Object... args) {
        TLRPC$Chat tLRPC$Chat;
        RecyclerListView recyclerListView;
        RecyclerListView recyclerListView2;
        RecyclerListView.Holder holder;
        int i = 0;
        if (id == NotificationCenter.updateInterfaces) {
            int iIntValue = ((Integer) args[0]).intValue();
            boolean z = ((MessagesController.UPDATE_MASK_AVATAR & iIntValue) == 0 && (MessagesController.UPDATE_MASK_NAME & iIntValue) == 0 && (MessagesController.UPDATE_MASK_STATUS & iIntValue) == 0) ? false : true;
            if (this.userId != 0) {
                if (z) {
                    updateProfileData();
                }
                if ((iIntValue & MessagesController.UPDATE_MASK_PHONE) == 0 || (recyclerListView2 = this.listView) == null || (holder = (RecyclerListView.Holder) recyclerListView2.findViewHolderForPosition(this.phoneRow)) == null) {
                    return;
                }
                this.listAdapter.onBindViewHolder(holder, this.phoneRow);
                return;
            }
            if (this.chatId != 0) {
                if ((MessagesController.UPDATE_MASK_CHAT & iIntValue) != 0 || (MessagesController.UPDATE_MASK_CHAT_AVATAR & iIntValue) != 0 || (MessagesController.UPDATE_MASK_CHAT_NAME & iIntValue) != 0 || (MessagesController.UPDATE_MASK_CHAT_MEMBERS & iIntValue) != 0 || (MessagesController.UPDATE_MASK_STATUS & iIntValue) != 0) {
                    if ((MessagesController.UPDATE_MASK_CHAT & iIntValue) != 0) {
                        updateListAnimated(true);
                    } else {
                        updateOnlineCount(true);
                    }
                    updateProfileData();
                }
                if (!z || (recyclerListView = this.listView) == null) {
                    return;
                }
                int childCount = recyclerListView.getChildCount();
                while (i < childCount) {
                    View childAt = this.listView.getChildAt(i);
                    if (childAt instanceof UserCell) {
                        ((UserCell) childAt).update(iIntValue);
                    }
                    i++;
                }
                return;
            }
            return;
        }
        if (id == NotificationCenter.chatOnlineCountDidLoad) {
            Long l = (Long) args[0];
            if (this.chatInfo == null || (tLRPC$Chat = this.currentChat) == null || tLRPC$Chat.id != l.longValue()) {
                return;
            }
            this.chatInfo.online_count = ((Integer) args[1]).intValue();
            updateOnlineCount(true);
            updateProfileData();
            return;
        }
        if (id == NotificationCenter.contactsDidLoad) {
            createActionBarMenu(true);
            return;
        }
        if (id == NotificationCenter.encryptedChatCreated) {
            if (this.creatingChat) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$8HMbDhzcD5x_NSmg1tv0G9ASA0M
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$didReceivedNotification$25$ProfileActivity(args);
                    }
                });
                return;
            }
            return;
        }
        if (id == NotificationCenter.encryptedChatUpdated) {
            TLRPC$EncryptedChat tLRPC$EncryptedChat = (TLRPC$EncryptedChat) args[0];
            TLRPC$EncryptedChat tLRPC$EncryptedChat2 = this.currentEncryptedChat;
            if (tLRPC$EncryptedChat2 == null || tLRPC$EncryptedChat.id != tLRPC$EncryptedChat2.id) {
                return;
            }
            this.currentEncryptedChat = tLRPC$EncryptedChat;
            updateListAnimated(false);
            updateTimeItem();
            return;
        }
        if (id == NotificationCenter.blockedUsersDidLoad) {
            boolean z2 = this.userBlocked;
            boolean z3 = getMessagesController().blockePeers.indexOfKey(this.userId) >= 0;
            this.userBlocked = z3;
            if (z2 != z3) {
                createActionBarMenu(true);
                updateListAnimated(false);
                return;
            }
            return;
        }
        if (id == NotificationCenter.groupCallUpdated) {
            Long l2 = (Long) args[0];
            if (this.currentChat != null) {
                long jLongValue = l2.longValue();
                TLRPC$Chat tLRPC$Chat2 = this.currentChat;
                if (jLongValue == tLRPC$Chat2.id && ChatObject.canManageCalls(tLRPC$Chat2)) {
                    TLRPC$ChatFull chatFull = MessagesController.getInstance(this.currentAccount).getChatFull(l2.longValue());
                    if (chatFull != null) {
                        TLRPC$ChatFull tLRPC$ChatFull = this.chatInfo;
                        if (tLRPC$ChatFull != null) {
                            chatFull.participants = tLRPC$ChatFull.participants;
                        }
                        this.chatInfo = chatFull;
                    }
                    TLRPC$ChatFull tLRPC$ChatFull2 = this.chatInfo;
                    if (tLRPC$ChatFull2 != null) {
                        TLRPC$TL_inputGroupCall tLRPC$TL_inputGroupCall = tLRPC$ChatFull2.call;
                        if ((tLRPC$TL_inputGroupCall != null || this.hasVoiceChatItem) && (tLRPC$TL_inputGroupCall == null || !this.hasVoiceChatItem)) {
                            return;
                        }
                        createActionBarMenu(false);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (id == NotificationCenter.chatInfoDidLoad) {
            TLRPC$ChatFull tLRPC$ChatFull3 = (TLRPC$ChatFull) args[0];
            if (tLRPC$ChatFull3.id == this.chatId) {
                boolean zBooleanValue = ((Boolean) args[2]).booleanValue();
                TLRPC$ChatFull tLRPC$ChatFull4 = this.chatInfo;
                if ((tLRPC$ChatFull4 instanceof TLRPC$TL_channelFull) && tLRPC$ChatFull3.participants == null) {
                    tLRPC$ChatFull3.participants = tLRPC$ChatFull4.participants;
                }
                if (tLRPC$ChatFull4 == null && (tLRPC$ChatFull3 instanceof TLRPC$TL_channelFull)) {
                    i = 1;
                }
                this.chatInfo = tLRPC$ChatFull3;
                if (this.mergeDialogId == 0) {
                    long j = tLRPC$ChatFull3.migrated_from_chat_id;
                    if (j != 0) {
                        this.mergeDialogId = -j;
                        getMediaDataController().getMediaCount(this.mergeDialogId, 0, this.classGuid, true);
                    }
                }
                fetchUsersFromChannelInfo();
                ProfileGalleryView profileGalleryView = this.avatarsViewPager;
                if (profileGalleryView != null) {
                    profileGalleryView.setChatInfo(this.chatInfo);
                }
                updateListAnimated(true);
                TLRPC$Chat chat = getMessagesController().getChat(Long.valueOf(this.chatId));
                if (chat != null) {
                    this.currentChat = chat;
                    createActionBarMenu(true);
                }
                if (this.currentChat.megagroup && (i != 0 || !zBooleanValue)) {
                    getChannelParticipants(true);
                }
                updateTimeItem();
                return;
            }
            return;
        }
        if (id == NotificationCenter.closeChats) {
            removeSelfFromStack();
            return;
        }
        if (id == NotificationCenter.botInfoDidLoad) {
            TLRPC$BotInfo tLRPC$BotInfo = (TLRPC$BotInfo) args[0];
            if (tLRPC$BotInfo.user_id == this.userId) {
                this.botInfo = tLRPC$BotInfo;
                updateListAnimated(false);
                return;
            }
            return;
        }
        if (id == NotificationCenter.userInfoDidLoad) {
            if (((Long) args[0]).longValue() == this.userId) {
                TLRPC$UserFull tLRPC$UserFull = (TLRPC$UserFull) args[1];
                this.userInfo = tLRPC$UserFull;
                if (this.imageUpdater != null) {
                    if (!TextUtils.equals(tLRPC$UserFull.about, this.currentBio)) {
                        this.listAdapter.notifyItemChanged(this.bioRow);
                    }
                } else {
                    if (!this.openAnimationInProgress && !this.callItemVisible) {
                        createActionBarMenu(true);
                    } else {
                        this.recreateMenuAfterAnimation = true;
                    }
                    updateListAnimated(false);
                    this.sharedMediaLayout.setCommonGroupsCount(this.userInfo.common_chats_count);
                    updateSelectedMediaTabText();
                    SharedMediaLayout.SharedMediaPreloader sharedMediaPreloader = this.sharedMediaPreloader;
                    if (sharedMediaPreloader == null || sharedMediaPreloader.isMediaWasLoaded()) {
                        resumeDelayedFragmentAnimation();
                        needLayout(true);
                    }
                }
                updateTimeItem();
                return;
            }
            return;
        }
        if (id == NotificationCenter.didReceiveNewMessages) {
            if (((Boolean) args[2]).booleanValue()) {
                return;
            }
            long dialogId = getDialogId();
            if (dialogId == ((Long) args[0]).longValue()) {
                DialogObject.isEncryptedDialog(dialogId);
                ArrayList arrayList = (ArrayList) args[1];
                while (i < arrayList.size()) {
                    MessageObject messageObject = (MessageObject) arrayList.get(i);
                    if (this.currentEncryptedChat != null) {
                        TLRPC$MessageAction tLRPC$MessageAction = messageObject.messageOwner.action;
                        if (tLRPC$MessageAction instanceof TLRPC$TL_messageEncryptedAction) {
                            TLRPC$DecryptedMessageAction tLRPC$DecryptedMessageAction = tLRPC$MessageAction.encryptedAction;
                            if (tLRPC$DecryptedMessageAction instanceof TLRPC$TL_decryptedMessageActionSetMessageTTL) {
                                ListAdapter listAdapter = this.listAdapter;
                                if (listAdapter != null) {
                                    listAdapter.notifyDataSetChanged();
                                }
                            }
                        }
                    }
                    i++;
                }
                return;
            }
            return;
        }
        if (id == NotificationCenter.emojiLoaded) {
            RecyclerListView recyclerListView3 = this.listView;
            if (recyclerListView3 != null) {
                recyclerListView3.invalidateViews();
                return;
            }
            return;
        }
        if (id == NotificationCenter.reloadInterface) {
            updateListAnimated(false);
            return;
        }
        if (id == NotificationCenter.newSuggestionsAvailable) {
            int i2 = this.passwordSuggestionRow;
            int i3 = this.phoneSuggestionRow;
            updateRowsIds();
            if (i2 == this.passwordSuggestionRow && i3 == this.phoneSuggestionRow) {
                return;
            }
            this.listAdapter.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$didReceivedNotification$25, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$didReceivedNotification$25$ProfileActivity(Object[] objArr) {
        NotificationCenter notificationCenter = getNotificationCenter();
        int i = NotificationCenter.closeChats;
        notificationCenter.removeObserver(this, i);
        getNotificationCenter().postNotificationName(i, new Object[0]);
        TLRPC$EncryptedChat tLRPC$EncryptedChat = (TLRPC$EncryptedChat) objArr[0];
        Bundle bundle = new Bundle();
        bundle.putInt("enc_id", tLRPC$EncryptedChat.id);
        presentFragment(new ChatActivity(bundle), true);
    }

    private void updateTimeItem() {
        TimerDrawable timerDrawable = this.timerDrawable;
        if (timerDrawable == null) {
            return;
        }
        TLRPC$EncryptedChat tLRPC$EncryptedChat = this.currentEncryptedChat;
        if (tLRPC$EncryptedChat != null) {
            timerDrawable.setTime(tLRPC$EncryptedChat.ttl);
            this.timeItem.setTag(1);
            this.timeItem.setVisibility(0);
            return;
        }
        TLRPC$UserFull tLRPC$UserFull = this.userInfo;
        if (tLRPC$UserFull != null) {
            timerDrawable.setTime(tLRPC$UserFull.ttl_period);
            if (this.needTimerImage && this.userInfo.ttl_period != 0) {
                this.timeItem.setTag(1);
                this.timeItem.setVisibility(0);
                return;
            } else {
                this.timeItem.setTag(null);
                this.timeItem.setVisibility(8);
                return;
            }
        }
        TLRPC$ChatFull tLRPC$ChatFull = this.chatInfo;
        if (tLRPC$ChatFull != null) {
            timerDrawable.setTime(tLRPC$ChatFull.ttl_period);
            if (this.needTimerImage && this.chatInfo.ttl_period != 0) {
                this.timeItem.setTag(1);
                this.timeItem.setVisibility(0);
                return;
            } else {
                this.timeItem.setTag(null);
                this.timeItem.setVisibility(8);
                return;
            }
        }
        this.timeItem.setTag(null);
        this.timeItem.setVisibility(8);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean needDelayOpenAnimation() {
        return this.playProfileAnimation == 0;
    }

    @Override // ir.eitaa.ui.Components.SharedMediaLayout.SharedMediaPreloaderDelegate
    public void mediaCountUpdated() {
        SharedMediaLayout.SharedMediaPreloader sharedMediaPreloader;
        SharedMediaLayout sharedMediaLayout = this.sharedMediaLayout;
        if (sharedMediaLayout != null && (sharedMediaPreloader = this.sharedMediaPreloader) != null) {
            sharedMediaLayout.setNewMediaCounts(sharedMediaPreloader.getLastMediaCount());
        }
        updateSharedMediaRows();
        updateSelectedMediaTabText();
        if (this.userInfo != null) {
            resumeDelayedFragmentAnimation();
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        SharedMediaLayout sharedMediaLayout = this.sharedMediaLayout;
        if (sharedMediaLayout != null) {
            sharedMediaLayout.onResume();
        }
        invalidateIsInLandscapeMode();
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            this.firstLayout = true;
            listAdapter.notifyDataSetChanged();
        }
        ImageUpdater imageUpdater = this.imageUpdater;
        if (imageUpdater != null) {
            imageUpdater.onResume();
            setParentActivityTitle(LocaleController.getString("Settings", R.string.Settings));
        }
        updateProfileData();
        fixLayout();
        SimpleTextView[] simpleTextViewArr = this.nameTextView;
        if (simpleTextViewArr[1] != null) {
            setParentActivityTitle(simpleTextViewArr[1].getText());
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
        UndoView undoView = this.undoView;
        if (undoView != null) {
            undoView.hide(true, 0);
        }
        ImageUpdater imageUpdater = this.imageUpdater;
        if (imageUpdater != null) {
            imageUpdater.onPause();
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean isSwipeBackEnabled(MotionEvent event) {
        SharedMediaLayout sharedMediaLayout;
        if (this.sharedMediaRow == -1 || (sharedMediaLayout = this.sharedMediaLayout) == null) {
            return true;
        }
        sharedMediaLayout.getHitRect(this.rect);
        if (this.rect.contains((int) event.getX(), ((int) event.getY()) - this.actionBar.getMeasuredHeight())) {
            return this.sharedMediaLayout.isCurrentTabFirst();
        }
        return true;
    }

    public UndoView getUndoView() {
        return this.undoView;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onBackPressed() {
        SharedMediaLayout sharedMediaLayout;
        return this.actionBar.isEnabled() && (this.sharedMediaRow == -1 || (sharedMediaLayout = this.sharedMediaLayout) == null || !sharedMediaLayout.closeActionMode());
    }

    public boolean isSettings() {
        return this.imageUpdater != null;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    protected void onBecomeFullyHidden() {
        UndoView undoView = this.undoView;
        if (undoView != null) {
            undoView.hide(true, 0);
        }
    }

    public void setPlayProfileAnimation(int type) {
        SharedPreferences globalMainSettings = MessagesController.getGlobalMainSettings();
        if (AndroidUtilities.isTablet()) {
            return;
        }
        this.needTimerImage = type != 0;
        if (globalMainSettings.getBoolean("view_animations", true)) {
            this.playProfileAnimation = type;
        } else if (type == 2) {
            this.expandPhoto = true;
        }
    }

    private void updateSharedMediaRows() {
        if (this.listAdapter == null) {
            return;
        }
        updateListAnimated(false);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    protected void onTransitionAnimationStart(boolean isOpen, boolean backward) {
        this.isFragmentOpened = isOpen;
        if (((!isOpen && backward) || (isOpen && !backward)) && this.playProfileAnimation != 0 && this.allowProfileAnimation && !this.isPulledDown) {
            this.openAnimationInProgress = true;
        }
        if (isOpen) {
            if (this.imageUpdater != null) {
                this.transitionIndex = getNotificationCenter().setAnimationInProgress(this.transitionIndex, new int[]{NotificationCenter.dialogsNeedReload, NotificationCenter.closeChats, NotificationCenter.mediaCountDidLoad, NotificationCenter.mediaCountsDidLoad, NotificationCenter.userInfoDidLoad});
            } else {
                this.transitionIndex = getNotificationCenter().setAnimationInProgress(this.transitionIndex, new int[]{NotificationCenter.dialogsNeedReload, NotificationCenter.closeChats, NotificationCenter.mediaCountDidLoad, NotificationCenter.mediaCountsDidLoad});
            }
        }
        this.transitionAnimationInProress = true;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    protected void onTransitionAnimationEnd(boolean isOpen, boolean backward) {
        if (isOpen) {
            if (!backward) {
                if (this.playProfileAnimation != 0 && this.allowProfileAnimation) {
                    this.openAnimationInProgress = false;
                    checkListViewScroll();
                    if (this.recreateMenuAfterAnimation) {
                        createActionBarMenu(true);
                    }
                }
                if (!this.fragmentOpened) {
                    this.fragmentOpened = true;
                    this.invalidateScroll = true;
                    this.fragmentView.requestLayout();
                }
            }
            getNotificationCenter().onAnimationFinish(this.transitionIndex);
        }
        this.transitionAnimationInProress = false;
    }

    @Keep
    public float getAnimationProgress() {
        return this.animationProgress;
    }

    @Keep
    public void setAnimationProgress(float progress) {
        int profileBackColorForId;
        int i;
        int profileTextColorForId;
        this.animationProgress = progress;
        this.listView.setAlpha(progress);
        this.listView.setTranslationX(AndroidUtilities.dp(48.0f) - (AndroidUtilities.dp(48.0f) * progress));
        int i2 = 2;
        if (this.playProfileAnimation != 2 || (profileBackColorForId = this.avatarColor) == 0) {
            profileBackColorForId = AvatarDrawable.getProfileBackColorForId((this.userId != 0 || (ChatObject.isChannel(this.chatId, this.currentAccount) && !this.currentChat.megagroup)) ? 5L : this.chatId);
        }
        int color = this.actionBarAnimationColorFrom;
        if (color == 0) {
            color = Theme.getColor("actionBarDefault");
        }
        this.topView.setBackgroundColor(Color.rgb(Color.red(color) + ((int) ((Color.red(profileBackColorForId) - r9) * progress)), Color.green(color) + ((int) ((Color.green(profileBackColorForId) - r10) * progress)), Color.blue(color) + ((int) ((Color.blue(profileBackColorForId) - r8) * progress))));
        int iconColorForId = AvatarDrawable.getIconColorForId((this.userId != 0 || (ChatObject.isChannel(this.chatId, this.currentAccount) && !this.currentChat.megagroup)) ? 5L : this.chatId);
        int color2 = Theme.getColor("actionBarDefaultIcon");
        this.actionBar.setItemsColor(Color.rgb(Color.red(color2) + ((int) ((Color.red(iconColorForId) - r9) * progress)), Color.green(color2) + ((int) ((Color.green(iconColorForId) - r10) * progress)), Color.blue(color2) + ((int) ((Color.blue(iconColorForId) - r8) * progress))), false);
        int color3 = Theme.getColor("profile_title");
        int color4 = Theme.getColor("actionBarDefaultTitle");
        int iRed = Color.red(color4);
        int iGreen = Color.green(color4);
        int iBlue = Color.blue(color4);
        int iAlpha = Color.alpha(color4);
        int iRed2 = (int) ((Color.red(color3) - iRed) * progress);
        int iGreen2 = (int) ((Color.green(color3) - iGreen) * progress);
        int iBlue2 = (int) ((Color.blue(color3) - iBlue) * progress);
        int iAlpha2 = (int) ((Color.alpha(color3) - iAlpha) * progress);
        int i3 = 0;
        while (true) {
            i = 1;
            if (i3 >= i2) {
                break;
            }
            SimpleTextView[] simpleTextViewArr = this.nameTextView;
            if (simpleTextViewArr[i3] != null && (i3 != 1 || this.playProfileAnimation != i2)) {
                simpleTextViewArr[i3].setTextColor(Color.argb(iAlpha + iAlpha2, iRed + iRed2, iGreen + iGreen2, iBlue + iBlue2));
            }
            i3++;
            i2 = 2;
        }
        if (this.isOnline[0]) {
            profileTextColorForId = Theme.getColor("profile_status");
        } else {
            profileTextColorForId = AvatarDrawable.getProfileTextColorForId((this.userId != 0 || (ChatObject.isChannel(this.chatId, this.currentAccount) && !this.currentChat.megagroup)) ? 5L : this.chatId);
        }
        int i4 = 0;
        int color5 = Theme.getColor(this.isOnline[0] ? "chat_status" : "actionBarDefaultSubtitle");
        int iRed3 = Color.red(color5);
        int iGreen3 = Color.green(color5);
        int iBlue3 = Color.blue(color5);
        int iAlpha3 = Color.alpha(color5);
        int iRed4 = (int) ((Color.red(profileTextColorForId) - iRed3) * progress);
        int iGreen4 = (int) ((Color.green(profileTextColorForId) - iGreen3) * progress);
        int iBlue4 = (int) ((Color.blue(profileTextColorForId) - iBlue3) * progress);
        int iAlpha4 = (int) ((Color.alpha(profileTextColorForId) - iAlpha3) * progress);
        while (i4 < 2) {
            SimpleTextView[] simpleTextViewArr2 = this.onlineTextView;
            if (simpleTextViewArr2[i4] != null && (i4 != i || this.playProfileAnimation != 2)) {
                simpleTextViewArr2[i4].setTextColor(Color.argb(iAlpha3 + iAlpha4, iRed3 + iRed4, iGreen3 + iGreen4, iBlue3 + iBlue4));
            }
            i4++;
            i = 1;
        }
        this.extraHeight = this.initialAnimationExtraHeight * progress;
        long j = this.userId;
        if (j == 0) {
            j = this.chatId;
        }
        int profileColorForId = AvatarDrawable.getProfileColorForId(j);
        long j2 = this.userId;
        if (j2 == 0) {
            j2 = this.chatId;
        }
        int colorForId = AvatarDrawable.getColorForId(j2);
        if (profileColorForId != colorForId) {
            this.avatarDrawable.setColor(Color.rgb(Color.red(colorForId) + ((int) ((Color.red(profileColorForId) - Color.red(colorForId)) * progress)), Color.green(colorForId) + ((int) ((Color.green(profileColorForId) - Color.green(colorForId)) * progress)), Color.blue(colorForId) + ((int) ((Color.blue(profileColorForId) - Color.blue(colorForId)) * progress))));
            this.avatarImage.invalidate();
        }
        int i5 = this.navigationBarAnimationColorFrom;
        if (i5 != 0) {
            setNavigationBarColor(ColorUtils.blendARGB(i5, getNavigationBarColor(), progress));
        }
        this.topView.invalidate();
        needLayout(true);
        this.fragmentView.invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x044e  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02c3  */
    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected android.animation.AnimatorSet onCustomTransitionAnimation(final boolean r17, final java.lang.Runnable r18) {
        /*
            Method dump skipped, instructions count: 1272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ProfileActivity.onCustomTransitionAnimation(boolean, java.lang.Runnable):android.animation.AnimatorSet");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onCustomTransitionAnimation$26, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onCustomTransitionAnimation$26$ProfileActivity(ValueAnimator valueAnimator) {
        this.fragmentView.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateOnlineCount(boolean notify) {
        TLRPC$UserStatus tLRPC$UserStatus;
        this.onlineCount = 0;
        int currentTime = getConnectionsManager().getCurrentTime();
        this.sortedUsers.clear();
        TLRPC$ChatFull tLRPC$ChatFull = this.chatInfo;
        if ((tLRPC$ChatFull instanceof TLRPC$TL_chatFull) || ((tLRPC$ChatFull instanceof TLRPC$TL_channelFull) && tLRPC$ChatFull.participants_count <= 200 && tLRPC$ChatFull.participants != null)) {
            for (int i = 0; i < this.chatInfo.participants.participants.size(); i++) {
                TLRPC$User user = getMessagesController().getUser(Long.valueOf(this.chatInfo.participants.participants.get(i).user_id));
                if (user != null && (tLRPC$UserStatus = user.status) != null && ((tLRPC$UserStatus.expires > currentTime || user.id == getUserConfig().getClientUserId()) && user.status.expires > 10000)) {
                    this.onlineCount++;
                }
                this.sortedUsers.add(Integer.valueOf(i));
            }
            try {
                Collections.sort(this.sortedUsers, new $$Lambda$ProfileActivity$1AuBj7jj3XKuuZkC3UdWeclxJIc(this, currentTime));
            } catch (Exception e) {
                FileLog.e(e);
            }
            if (notify && this.listAdapter != null && this.membersStartRow > 0) {
                AndroidUtilities.updateVisibleRows(this.listView);
            }
            if (this.sharedMediaLayout == null || this.sharedMediaRow == -1) {
                return;
            }
            if ((this.sortedUsers.size() > 5 || this.usersForceShowingIn == 2) && this.usersForceShowingIn != 1) {
                this.sharedMediaLayout.setChatUsers(this.sortedUsers, this.chatInfo);
                return;
            }
            return;
        }
        if (!(tLRPC$ChatFull instanceof TLRPC$TL_channelFull) || tLRPC$ChatFull.participants_count <= 200) {
            return;
        }
        this.onlineCount = tLRPC$ChatFull.online_count;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006f  */
    /* renamed from: lambda$updateOnlineCount$27, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ int lambda$updateOnlineCount$27$ProfileActivity(int r5, java.lang.Integer r6, java.lang.Integer r7) {
        /*
            r4 = this;
            ir.eitaa.messenger.MessagesController r0 = r4.getMessagesController()
            ir.eitaa.tgnet.TLRPC$ChatFull r1 = r4.chatInfo
            ir.eitaa.tgnet.TLRPC$ChatParticipants r1 = r1.participants
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$ChatParticipant> r1 = r1.participants
            int r7 = r7.intValue()
            java.lang.Object r7 = r1.get(r7)
            ir.eitaa.tgnet.TLRPC$ChatParticipant r7 = (ir.eitaa.tgnet.TLRPC$ChatParticipant) r7
            long r1 = r7.user_id
            java.lang.Long r7 = java.lang.Long.valueOf(r1)
            ir.eitaa.tgnet.TLRPC$User r7 = r0.getUser(r7)
            ir.eitaa.messenger.MessagesController r0 = r4.getMessagesController()
            ir.eitaa.tgnet.TLRPC$ChatFull r1 = r4.chatInfo
            ir.eitaa.tgnet.TLRPC$ChatParticipants r1 = r1.participants
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$ChatParticipant> r1 = r1.participants
            int r6 = r6.intValue()
            java.lang.Object r6 = r1.get(r6)
            ir.eitaa.tgnet.TLRPC$ChatParticipant r6 = (ir.eitaa.tgnet.TLRPC$ChatParticipant) r6
            long r1 = r6.user_id
            java.lang.Long r6 = java.lang.Long.valueOf(r1)
            ir.eitaa.tgnet.TLRPC$User r6 = r0.getUser(r6)
            r0 = 50000(0xc350, float:7.0065E-41)
            r1 = -110(0xffffffffffffff92, float:NaN)
            r2 = 0
            if (r7 == 0) goto L59
            boolean r3 = r7.bot
            if (r3 == 0) goto L4b
            r7 = -110(0xffffffffffffff92, float:NaN)
            goto L5a
        L4b:
            boolean r3 = r7.self
            if (r3 == 0) goto L52
            int r7 = r5 + r0
            goto L5a
        L52:
            ir.eitaa.tgnet.TLRPC$UserStatus r7 = r7.status
            if (r7 == 0) goto L59
            int r7 = r7.expires
            goto L5a
        L59:
            r7 = 0
        L5a:
            if (r6 == 0) goto L6f
            boolean r3 = r6.bot
            if (r3 == 0) goto L61
            goto L70
        L61:
            boolean r1 = r6.self
            if (r1 == 0) goto L68
            int r1 = r5 + r0
            goto L70
        L68:
            ir.eitaa.tgnet.TLRPC$UserStatus r5 = r6.status
            if (r5 == 0) goto L6f
            int r1 = r5.expires
            goto L70
        L6f:
            r1 = 0
        L70:
            r5 = -1
            r6 = 1
            if (r7 <= 0) goto L7d
            if (r1 <= 0) goto L7d
            if (r7 <= r1) goto L79
            return r6
        L79:
            if (r7 >= r1) goto L7c
            return r5
        L7c:
            return r2
        L7d:
            if (r7 >= 0) goto L88
            if (r1 >= 0) goto L88
            if (r7 <= r1) goto L84
            return r6
        L84:
            if (r7 >= r1) goto L87
            return r5
        L87:
            return r2
        L88:
            if (r7 >= 0) goto L8c
            if (r1 > 0) goto L90
        L8c:
            if (r7 != 0) goto L91
            if (r1 == 0) goto L91
        L90:
            return r5
        L91:
            if (r1 >= 0) goto L95
            if (r7 > 0) goto L99
        L95:
            if (r1 != 0) goto L9a
            if (r7 == 0) goto L9a
        L99:
            return r6
        L9a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ProfileActivity.lambda$updateOnlineCount$27$ProfileActivity(int, java.lang.Integer, java.lang.Integer):int");
    }

    public void setChatInfo(TLRPC$ChatFull value) {
        this.chatInfo = value;
        if (value != null) {
            long j = value.migrated_from_chat_id;
            if (j != 0 && this.mergeDialogId == 0) {
                this.mergeDialogId = -j;
                getMediaDataController().getMediaCounts(this.mergeDialogId, this.classGuid);
            }
        }
        SharedMediaLayout sharedMediaLayout = this.sharedMediaLayout;
        if (sharedMediaLayout != null) {
            sharedMediaLayout.setChatInfo(this.chatInfo);
        }
        ProfileGalleryView profileGalleryView = this.avatarsViewPager;
        if (profileGalleryView != null) {
            profileGalleryView.setChatInfo(this.chatInfo);
        }
        fetchUsersFromChannelInfo();
    }

    public void setUserInfo(TLRPC$UserFull value) {
        this.userInfo = value;
    }

    public boolean canSearchMembers() {
        return this.canSearchMembers;
    }

    private void fetchUsersFromChannelInfo() {
        TLRPC$Chat tLRPC$Chat = this.currentChat;
        if (tLRPC$Chat == null || !tLRPC$Chat.megagroup) {
            return;
        }
        TLRPC$ChatFull tLRPC$ChatFull = this.chatInfo;
        if (!(tLRPC$ChatFull instanceof TLRPC$TL_channelFull) || tLRPC$ChatFull.participants == null) {
            return;
        }
        for (int i = 0; i < this.chatInfo.participants.participants.size(); i++) {
            TLRPC$ChatParticipant tLRPC$ChatParticipant = this.chatInfo.participants.participants.get(i);
            this.participantsMap.put(tLRPC$ChatParticipant.user_id, tLRPC$ChatParticipant);
        }
    }

    private void kickUser(long uid, TLRPC$ChatParticipant participant) {
        if (uid != 0) {
            TLRPC$User user = getMessagesController().getUser(Long.valueOf(uid));
            getMessagesController().deleteParticipantFromChat(this.chatId, user, this.chatInfo);
            if (this.currentChat != null && user != null && BulletinFactory.canShowBulletin(this)) {
                BulletinFactory.createRemoveFromChatBulletin(this, user, this.currentChat.title).show();
            }
            if (this.chatInfo.participants.participants.remove(participant)) {
                updateListAnimated(true);
                return;
            }
            return;
        }
        NotificationCenter notificationCenter = getNotificationCenter();
        int i = NotificationCenter.closeChats;
        notificationCenter.removeObserver(this, i);
        if (AndroidUtilities.isTablet()) {
            getNotificationCenter().postNotificationName(i, Long.valueOf(-this.chatId));
        } else {
            getNotificationCenter().postNotificationName(i, new Object[0]);
        }
        getMessagesController().deleteParticipantFromChat(this.chatId, getMessagesController().getUser(Long.valueOf(getUserConfig().getClientUserId())), this.chatInfo);
        this.playProfileAnimation = 0;
        finishFragment();
    }

    public boolean isChat() {
        return this.chatId != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void updateRowsIds() {
        /*
            Method dump skipped, instructions count: 1478
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ProfileActivity.updateRowsIds():void");
    }

    private Drawable getScamDrawable(int type) {
        if (this.scamDrawable == null) {
            ScamDrawable scamDrawable = new ScamDrawable(11, type);
            this.scamDrawable = scamDrawable;
            scamDrawable.setColor(Theme.getColor("avatar_subtitleInProfileBlue"));
        }
        return this.scamDrawable;
    }

    private Drawable getLockIconDrawable() {
        if (this.lockIconDrawable == null) {
            this.lockIconDrawable = Theme.chat_lockIconDrawable.getConstantState().newDrawable().mutate();
        }
        return this.lockIconDrawable;
    }

    private Drawable getVerifiedCrossfadeDrawable() {
        if (this.verifiedCrossfadeDrawable == null) {
            this.verifiedDrawable = Theme.profile_verifiedDrawable.getConstantState().newDrawable().mutate();
            this.verifiedCheckDrawable = Theme.profile_verifiedCheckDrawable.getConstantState().newDrawable().mutate();
            this.verifiedCrossfadeDrawable = new CrossfadeDrawable(new CombinedDrawable(this.verifiedDrawable, this.verifiedCheckDrawable), ContextCompat.getDrawable(getParentActivity(), R.drawable.verified_profile));
        }
        return this.verifiedCrossfadeDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x043f  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0492  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x04d9  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x05f4  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x061f  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x0626  */
    /* JADX WARN: Removed duplicated region for block: B:333:0x062a  */
    /* JADX WARN: Removed duplicated region for block: B:346:0x0671  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x0676  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void updateProfileData() {
        /*
            Method dump skipped, instructions count: 1713
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ProfileActivity.updateProfileData():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:168:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x03df  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x03ea  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x03fe  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x041c  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x04d2  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x04e9  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0500  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0517  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void createActionBarMenu(boolean r17) {
        /*
            Method dump skipped, instructions count: 1350
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ProfileActivity.createActionBarMenu(boolean):void");
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    protected void onDialogDismiss(Dialog dialog) {
        RecyclerListView recyclerListView = this.listView;
        if (recyclerListView != null) {
            recyclerListView.invalidateViews();
        }
    }

    @Override // ir.eitaa.ui.DialogsActivity.DialogsActivityDelegate
    public void didSelectDialogs(DialogsActivity fragment, ArrayList<Long> dids, CharSequence message, boolean param) {
        long jLongValue = dids.get(0).longValue();
        Bundle bundle = new Bundle();
        bundle.putBoolean("scrollToTopOnResume", true);
        if (DialogObject.isEncryptedDialog(jLongValue)) {
            bundle.putInt("enc_id", DialogObject.getEncryptedChatId(jLongValue));
        } else if (DialogObject.isUserDialog(jLongValue)) {
            bundle.putLong("user_id", jLongValue);
        } else if (DialogObject.isChatDialog(jLongValue)) {
            bundle.putLong("chat_id", -jLongValue);
        }
        if (getMessagesController().checkCanOpenChat(bundle, fragment)) {
            NotificationCenter notificationCenter = getNotificationCenter();
            int i = NotificationCenter.closeChats;
            notificationCenter.removeObserver(this, i);
            getNotificationCenter().postNotificationName(i, new Object[0]);
            presentFragment(new ChatActivity(bundle), true);
            removeSelfFromStack();
            getSendMessagesHelper().sendMessage(getMessagesController().getUser(Long.valueOf(this.userId)), jLongValue, (MessageObject) null, (MessageObject) null, (TLRPC$ReplyMarkup) null, (HashMap<String, String>) null, true, 0);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onRequestPermissionsResultFragment(int requestCode, String[] permissions, int[] grantResults) {
        boolean z;
        boolean z2;
        ImageUpdater imageUpdater = this.imageUpdater;
        if (imageUpdater != null) {
            imageUpdater.onRequestPermissionsResultFragment(requestCode, permissions, grantResults);
        }
        if (requestCode == 101 || requestCode == 102) {
            TLRPC$User user = getMessagesController().getUser(Long.valueOf(this.userId));
            if (user == null) {
                return;
            }
            int i = 0;
            while (true) {
                if (i >= grantResults.length) {
                    z = true;
                    break;
                } else {
                    if (grantResults[i] != 0) {
                        z = false;
                        break;
                    }
                    i++;
                }
            }
            if (grantResults.length > 0 && z) {
                boolean z3 = requestCode == 102;
                TLRPC$UserFull tLRPC$UserFull = this.userInfo;
                VoIPHelper.startCall(user, z3, tLRPC$UserFull != null && tLRPC$UserFull.video_calls_available, getParentActivity(), this.userInfo, getAccountInstance());
                return;
            }
            VoIPHelper.permissionDenied(getParentActivity(), null, requestCode);
            return;
        }
        if (requestCode != 103 || this.currentChat == null) {
            return;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= grantResults.length) {
                z2 = true;
                break;
            } else {
                if (grantResults[i2] != 0) {
                    z2 = false;
                    break;
                }
                i2++;
            }
        }
        if (grantResults.length > 0 && z2) {
            VoIPHelper.startCall(this.currentChat, null, null, getMessagesController().getGroupCall(this.chatId, false) == null, getParentActivity(), this, getAccountInstance());
        } else {
            VoIPHelper.permissionDenied(getParentActivity(), null, requestCode);
        }
    }

    private void loadAds() {
        TLRPC$InputPeer tLRPC$TL_inputPeerChat;
        if (this.currentChat == null) {
            return;
        }
        TLRPC$TL_ads_getAdsPack tLRPC$TL_ads_getAdsPack = new TLRPC$TL_ads_getAdsPack();
        tLRPC$TL_ads_getAdsPack.location = new TLRPC$TL_ads_inputAdsLocationChatMembers();
        if (ChatObject.isChannel(this.currentChat)) {
            tLRPC$TL_inputPeerChat = new TLRPC$TL_inputPeerChannel();
            TLRPC$Chat tLRPC$Chat = this.currentChat;
            tLRPC$TL_inputPeerChat.channel_id = tLRPC$Chat.id;
            tLRPC$TL_inputPeerChat.access_hash = tLRPC$Chat.access_hash;
        } else {
            tLRPC$TL_inputPeerChat = new TLRPC$TL_inputPeerChat();
            tLRPC$TL_inputPeerChat.chat_id = this.currentChat.id;
        }
        tLRPC$TL_ads_getAdsPack.location.peer = tLRPC$TL_inputPeerChat;
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_ads_getAdsPack, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$EqRKlDTIemnwLOSSnBhxK6fN5Hg
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadAds$30$ProfileActivity(tLObject, tLRPC$TL_error);
            }
        }, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadAds$30, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadAds$30$ProfileActivity(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$GopD6-NusBiwgHkuU05VKTrZyi4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadAds$29$ProfileActivity(tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadAds$29, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadAds$29$ProfileActivity(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
        if (tLRPC$TL_error == null) {
            TLRPC$TL_ads_AdPack tLRPC$TL_ads_AdPack = (TLRPC$TL_ads_AdPack) tLObject;
            this.ads = new ArrayList<>();
            this.adsTitle = tLRPC$TL_ads_AdPack.title;
            Iterator<TLRPC$Ads_Ad> it = tLRPC$TL_ads_AdPack.ads.iterator();
            while (it.hasNext()) {
                this.ads.add(it.next());
            }
            ImageLoader.saveAdsThumbs(this.ads);
            if (this.ads.size() != 0) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$3X6gVEgLjRxppidJTZakAZxyGjA
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$loadAds$28$ProfileActivity();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadAds$28, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadAds$28$ProfileActivity() {
        this.hasAds = true;
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            listAdapter.notifyItemChanged(this.adRow);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void dismissCurrentDialog() {
        ImageUpdater imageUpdater = this.imageUpdater;
        if (imageUpdater == null || !imageUpdater.dismissCurrentDialog(this.visibleDialog)) {
            super.dismissCurrentDialog();
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean dismissDialogOnPause(Dialog dialog) {
        ImageUpdater imageUpdater = this.imageUpdater;
        return (imageUpdater == null || imageUpdater.dismissDialogOnPause(dialog)) && super.dismissDialogOnPause(dialog);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator searchExpandTransition(final boolean enter) {
        if (enter) {
            AndroidUtilities.requestAdjustResize(getParentActivity(), this.classGuid);
            AndroidUtilities.setAdjustResizeToNothing(getParentActivity(), this.classGuid);
        }
        Animator animator = this.searchViewTransition;
        if (animator != null) {
            animator.removeAllListeners();
            this.searchViewTransition.cancel();
        }
        float[] fArr = new float[2];
        fArr[0] = this.searchTransitionProgress;
        fArr[1] = enter ? 0.0f : 1.0f;
        final ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        final float f = this.extraHeight;
        this.searchListView.setTranslationY(f);
        this.searchListView.setVisibility(0);
        this.searchItem.setVisibility(0);
        this.listView.setVisibility(0);
        needLayout(true);
        this.avatarContainer.setVisibility(0);
        this.nameTextView[1].setVisibility(0);
        this.onlineTextView[1].setVisibility(0);
        this.actionBar.onSearchFieldVisibilityChanged(this.searchTransitionProgress > 0.5f);
        ActionBarMenuItem actionBarMenuItem = this.otherItem;
        if (actionBarMenuItem != null) {
            actionBarMenuItem.setVisibility(this.searchTransitionProgress > 0.5f ? 0 : 8);
        }
        this.searchItem.setVisibility(this.searchTransitionProgress > 0.5f ? 0 : 8);
        this.searchItem.getSearchContainer().setVisibility(this.searchTransitionProgress <= 0.5f ? 0 : 8);
        this.searchListView.setEmptyView(this.emptyView);
        this.avatarContainer.setClickable(false);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$FE2JnCKXxramBocS6KYblsbOvVI
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.lambda$searchExpandTransition$31$ProfileActivity(valueAnimatorOfFloat, f, enter, valueAnimator);
            }
        });
        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.ProfileActivity.31
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                ProfileActivity.this.updateSearchViewState(enter);
                ProfileActivity.this.avatarContainer.setClickable(true);
                if (enter) {
                    ProfileActivity.this.searchItem.requestFocusOnSearchView();
                }
                ProfileActivity.this.needLayout(true);
                ProfileActivity.this.searchViewTransition = null;
                ((BaseFragment) ProfileActivity.this).fragmentView.invalidate();
                if (enter) {
                    ProfileActivity.this.invalidateScroll = true;
                    ProfileActivity.this.saveScrollPosition();
                    AndroidUtilities.requestAdjustResize(ProfileActivity.this.getParentActivity(), ((BaseFragment) ProfileActivity.this).classGuid);
                    ProfileActivity.this.emptyView.setPreventMoving(false);
                }
            }
        });
        if (!enter) {
            this.invalidateScroll = true;
            saveScrollPosition();
            AndroidUtilities.requestAdjustNothing(getParentActivity(), this.classGuid);
            this.emptyView.setPreventMoving(true);
        }
        valueAnimatorOfFloat.setDuration(220L);
        valueAnimatorOfFloat.setInterpolator(CubicBezierInterpolator.DEFAULT);
        this.searchViewTransition = valueAnimatorOfFloat;
        return valueAnimatorOfFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$searchExpandTransition$31, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$searchExpandTransition$31$ProfileActivity(ValueAnimator valueAnimator, float f, boolean z, ValueAnimator valueAnimator2) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.searchTransitionProgress = fFloatValue;
        float f2 = (fFloatValue - 0.5f) / 0.5f;
        float f3 = (0.5f - fFloatValue) / 0.5f;
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        float f4 = -f;
        this.searchTransitionOffset = (int) ((1.0f - fFloatValue) * f4);
        this.searchListView.setTranslationY(fFloatValue * f);
        this.emptyView.setTranslationY(f * this.searchTransitionProgress);
        this.listView.setTranslationY(f4 * (1.0f - this.searchTransitionProgress));
        this.listView.setScaleX(1.0f - ((1.0f - this.searchTransitionProgress) * 0.01f));
        this.listView.setScaleY(1.0f - ((1.0f - this.searchTransitionProgress) * 0.01f));
        this.listView.setAlpha(this.searchTransitionProgress);
        needLayout(true);
        this.listView.setAlpha(f2);
        this.searchListView.setAlpha(1.0f - this.searchTransitionProgress);
        this.searchListView.setScaleX((this.searchTransitionProgress * 0.05f) + 1.0f);
        this.searchListView.setScaleY((this.searchTransitionProgress * 0.05f) + 1.0f);
        this.emptyView.setAlpha(1.0f - f2);
        this.avatarContainer.setAlpha(f2);
        this.nameTextView[1].setAlpha(f2);
        this.onlineTextView[1].setAlpha(f2);
        this.searchItem.getSearchField().setAlpha(f3);
        if (z && this.searchTransitionProgress < 0.7f) {
            this.searchItem.requestFocusOnSearchView();
        }
        this.searchItem.getSearchContainer().setVisibility(this.searchTransitionProgress < 0.5f ? 0 : 8);
        ActionBarMenuItem actionBarMenuItem = this.otherItem;
        if (actionBarMenuItem != null) {
            actionBarMenuItem.setVisibility(this.searchTransitionProgress > 0.5f ? 0 : 8);
        }
        this.searchItem.setVisibility(this.searchTransitionProgress > 0.5f ? 0 : 8);
        this.actionBar.onSearchFieldVisibilityChanged(this.searchTransitionProgress < 0.5f);
        ActionBarMenuItem actionBarMenuItem2 = this.otherItem;
        if (actionBarMenuItem2 != null) {
            actionBarMenuItem2.setAlpha(f2);
        }
        this.searchItem.setAlpha(f2);
        this.topView.invalidate();
        this.fragmentView.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSearchViewState(boolean enter) {
        int i = enter ? 8 : 0;
        this.listView.setVisibility(i);
        this.searchListView.setVisibility(enter ? 0 : 8);
        this.searchItem.getSearchContainer().setVisibility(enter ? 0 : 8);
        this.actionBar.onSearchFieldVisibilityChanged(enter);
        this.avatarContainer.setVisibility(i);
        this.nameTextView[1].setVisibility(i);
        this.onlineTextView[1].setVisibility(i);
        ActionBarMenuItem actionBarMenuItem = this.otherItem;
        if (actionBarMenuItem != null) {
            actionBarMenuItem.setAlpha(1.0f);
            this.otherItem.setVisibility(i);
        }
        this.searchItem.setVisibility(i);
        this.avatarContainer.setAlpha(1.0f);
        this.nameTextView[1].setAlpha(1.0f);
        this.onlineTextView[1].setAlpha(1.0f);
        this.searchItem.setAlpha(1.0f);
        this.listView.setAlpha(1.0f);
        this.searchListView.setAlpha(1.0f);
        this.emptyView.setAlpha(1.0f);
        if (enter) {
            this.searchListView.setEmptyView(this.emptyView);
        } else {
            this.emptyView.setVisibility(8);
        }
    }

    @Override // ir.eitaa.ui.Components.ImageUpdater.ImageUpdaterDelegate
    public void onUploadProgressChanged(float progress) {
        RadialProgressView radialProgressView = this.avatarProgressView;
        if (radialProgressView == null) {
            return;
        }
        radialProgressView.setProgress(progress);
        this.avatarsViewPager.setUploadProgress(this.uploadingImageLocation, progress);
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
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$VF-o_vin7H3K0-tSGJG4AdrbMy4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$didUploadPhoto$34$ProfileActivity(photo, video, videoStartTimestamp, videoPath, smallSize, bigSize);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$didUploadPhoto$33, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$didUploadPhoto$33$ProfileActivity(final String str, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SgiXmutiAhTidHeQw51bsgqMnkM
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$didUploadPhoto$32$ProfileActivity(tLRPC$TL_error, tLObject, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$didUploadPhoto$32, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$didUploadPhoto$32$ProfileActivity(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, String str) {
        this.avatarsViewPager.removeUploadingImage(this.uploadingImageLocation);
        if (tLRPC$TL_error == null) {
            TLRPC$User user = getMessagesController().getUser(Long.valueOf(getUserConfig().getClientUserId()));
            if (user == null) {
                user = getUserConfig().getCurrentUser();
                if (user == null) {
                    return;
                } else {
                    getMessagesController().putUser(user, false);
                }
            } else {
                getUserConfig().setCurrentUser(user);
            }
            TLRPC$TL_photos_photo tLRPC$TL_photos_photo = (TLRPC$TL_photos_photo) tLObject;
            ArrayList<TLRPC$PhotoSize> arrayList = tLRPC$TL_photos_photo.photo.sizes;
            TLRPC$PhotoSize closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(arrayList, ImageReceiver.DEFAULT_CROSSFADE_DURATION);
            TLRPC$PhotoSize closestPhotoSizeWithSize2 = FileLoader.getClosestPhotoSizeWithSize(arrayList, 800);
            TLRPC$VideoSize tLRPC$VideoSize = tLRPC$TL_photos_photo.photo.video_sizes.isEmpty() ? null : tLRPC$TL_photos_photo.photo.video_sizes.get(0);
            TLRPC$TL_userProfilePhoto tLRPC$TL_userProfilePhoto = new TLRPC$TL_userProfilePhoto();
            user.photo = tLRPC$TL_userProfilePhoto;
            tLRPC$TL_userProfilePhoto.photo_id = tLRPC$TL_photos_photo.photo.id;
            if (closestPhotoSizeWithSize != null) {
                tLRPC$TL_userProfilePhoto.photo_small = closestPhotoSizeWithSize.location;
            }
            if (closestPhotoSizeWithSize2 != null) {
                tLRPC$TL_userProfilePhoto.photo_big = closestPhotoSizeWithSize2.location;
            }
            if (closestPhotoSizeWithSize != null && this.avatar != null) {
                FileLoader.getPathToAttach(this.avatar, true).renameTo(FileLoader.getPathToAttach(closestPhotoSizeWithSize, true));
                ImageLoader.getInstance().replaceImageInCache(this.avatar.volume_id + "_" + this.avatar.local_id + "@50_50", closestPhotoSizeWithSize.location.volume_id + "_" + closestPhotoSizeWithSize.location.local_id + "@50_50", ImageLocation.getForUserOrChat(user, 1), false);
            }
            if (closestPhotoSizeWithSize2 != null && this.avatarBig != null) {
                FileLoader.getPathToAttach(this.avatarBig, true).renameTo(FileLoader.getPathToAttach(closestPhotoSizeWithSize2, true));
            }
            if (tLRPC$VideoSize != null && str != null) {
                new File(str).renameTo(FileLoader.getPathToAttach(tLRPC$VideoSize, "mp4", true));
            }
            getMessagesStorage().clearUserPhotos(user.id);
            ArrayList<TLRPC$User> arrayList2 = new ArrayList<>();
            arrayList2.add(user);
            getMessagesStorage().putUsersAndChats(arrayList2, null, false, true);
        }
        this.allowPullingDown = (AndroidUtilities.isTablet() || this.isInLandscapeMode || !this.avatarImage.getImageReceiver().hasNotThumb()) ? false : true;
        this.avatar = null;
        this.avatarBig = null;
        this.avatarsViewPager.setCreateThumbFromParent(false);
        updateProfileData();
        showAvatarProgress(false, true);
        getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, Integer.valueOf(MessagesController.UPDATE_MASK_ALL));
        getNotificationCenter().postNotificationName(NotificationCenter.mainUserInfoChanged, new Object[0]);
        getUserConfig().saveConfig(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$didUploadPhoto$34, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$didUploadPhoto$34$ProfileActivity(TLRPC$InputFile tLRPC$InputFile, TLRPC$InputFile tLRPC$InputFile2, double d, final String str, TLRPC$PhotoSize tLRPC$PhotoSize, TLRPC$PhotoSize tLRPC$PhotoSize2) {
        if (tLRPC$InputFile != null || tLRPC$InputFile2 != null) {
            TLRPC$TL_photos_uploadProfilePhoto tLRPC$TL_photos_uploadProfilePhoto = new TLRPC$TL_photos_uploadProfilePhoto();
            if (tLRPC$InputFile != null) {
                tLRPC$TL_photos_uploadProfilePhoto.file = tLRPC$InputFile;
                tLRPC$TL_photos_uploadProfilePhoto.flags |= 1;
            }
            if (tLRPC$InputFile2 != null) {
                tLRPC$TL_photos_uploadProfilePhoto.video = tLRPC$InputFile2;
                int i = tLRPC$TL_photos_uploadProfilePhoto.flags | 2;
                tLRPC$TL_photos_uploadProfilePhoto.flags = i;
                tLRPC$TL_photos_uploadProfilePhoto.video_start_ts = d;
                tLRPC$TL_photos_uploadProfilePhoto.flags = i | 4;
            }
            getConnectionsManager().sendRequest(tLRPC$TL_photos_uploadProfilePhoto, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$NKAcBfTOQyB6l-vBH4c6IuFJ9ps
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$didUploadPhoto$33$ProfileActivity(str, tLObject, tLRPC$TL_error);
                }
            });
        } else {
            TLRPC$FileLocation tLRPC$FileLocation = tLRPC$PhotoSize.location;
            this.avatar = tLRPC$FileLocation;
            this.avatarBig = tLRPC$PhotoSize2.location;
            this.avatarImage.setImage(ImageLocation.getForLocal(tLRPC$FileLocation), "50_50", this.avatarDrawable, (Object) null);
            if (this.setAvatarRow != -1) {
                updateRowsIds();
                ListAdapter listAdapter = this.listAdapter;
                if (listAdapter != null) {
                    listAdapter.notifyDataSetChanged();
                }
                needLayout(true);
            }
            ProfileGalleryView profileGalleryView = this.avatarsViewPager;
            ImageLocation forLocal = ImageLocation.getForLocal(this.avatarBig);
            this.uploadingImageLocation = forLocal;
            profileGalleryView.addUploadingImage(forLocal, ImageLocation.getForLocal(this.avatar));
            showAvatarProgress(true, false);
        }
        this.actionBar.createMenu().requestLayout();
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
        if (!animated) {
            if (show) {
                this.avatarProgressView.setAlpha(1.0f);
                this.avatarProgressView.setVisibility(0);
                return;
            } else {
                this.avatarProgressView.setAlpha(0.0f);
                this.avatarProgressView.setVisibility(4);
                return;
            }
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.avatarAnimation = animatorSet2;
        if (show) {
            this.avatarProgressView.setVisibility(0);
            this.avatarAnimation.playTogether(ObjectAnimator.ofFloat(this.avatarProgressView, (Property<RadialProgressView, Float>) View.ALPHA, 1.0f));
        } else {
            animatorSet2.playTogether(ObjectAnimator.ofFloat(this.avatarProgressView, (Property<RadialProgressView, Float>) View.ALPHA, 0.0f));
        }
        this.avatarAnimation.setDuration(180L);
        this.avatarAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.ProfileActivity.32
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                if (ProfileActivity.this.avatarAnimation == null || ProfileActivity.this.avatarProgressView == null) {
                    return;
                }
                if (!show) {
                    ProfileActivity.this.avatarProgressView.setVisibility(4);
                }
                ProfileActivity.this.avatarAnimation = null;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                ProfileActivity.this.avatarAnimation = null;
            }
        });
        this.avatarAnimation.start();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onActivityResultFragment(int requestCode, int resultCode, Intent data) throws InterruptedException, Resources.NotFoundException {
        ImageUpdater imageUpdater = this.imageUpdater;
        if (imageUpdater != null) {
            imageUpdater.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void saveSelfArgs(Bundle args) {
        String str;
        ImageUpdater imageUpdater = this.imageUpdater;
        if (imageUpdater == null || (str = imageUpdater.currentPicturePath) == null) {
            return;
        }
        args.putString("path", str);
    }

    public void restoreSelfArgs(Bundle args) {
        ImageUpdater imageUpdater = this.imageUpdater;
        if (imageUpdater != null) {
            imageUpdater.currentPicturePath = args.getString("path");
        }
    }

    private void sendLogs(final boolean last) {
        if (getParentActivity() == null) {
            return;
        }
        final AlertDialog alertDialog = new AlertDialog(getParentActivity(), 3);
        alertDialog.setCanCacnel(false);
        alertDialog.show();
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$qt9NRArE-UEEewamFwS0s7943yw
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f$0.lambda$sendLogs$36$ProfileActivity(last, alertDialog);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$sendLogs$36, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$sendLogs$36$ProfileActivity(boolean z, final AlertDialog alertDialog) throws Throwable {
        ZipOutputStream zipOutputStream;
        try {
            BufferedInputStream bufferedInputStream = null;
            File file = new File(ApplicationLoader.applicationContext.getExternalFilesDir(null).getAbsolutePath() + "/logs");
            final File file2 = new File(file, "logs.zip");
            if (file2.exists()) {
                file2.delete();
            }
            try {
                try {
                    File[] fileArrListFiles = file.listFiles();
                    final boolean[] zArr = new boolean[1];
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    try {
                        zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file2)));
                        try {
                            byte[] bArr = new byte[65536];
                            for (int i = 0; i < fileArrListFiles.length; i++) {
                                if (!z || jCurrentTimeMillis - fileArrListFiles[i].lastModified() <= 86400000) {
                                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(fileArrListFiles[i]), 65536);
                                    try {
                                        zipOutputStream.putNextEntry(new ZipEntry(fileArrListFiles[i].getName()));
                                        while (true) {
                                            int i2 = bufferedInputStream2.read(bArr, 0, 65536);
                                            if (i2 == -1) {
                                                break;
                                            } else {
                                                zipOutputStream.write(bArr, 0, i2);
                                            }
                                        }
                                        bufferedInputStream2.close();
                                    } catch (Exception e) {
                                        e = e;
                                        bufferedInputStream = bufferedInputStream2;
                                        e.printStackTrace();
                                        if (bufferedInputStream != null) {
                                            bufferedInputStream.close();
                                        }
                                        if (zipOutputStream != null) {
                                            zipOutputStream.close();
                                        }
                                        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$yXD7UF1rPHgBmapjT0rJKEisWrY
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                this.f$0.lambda$sendLogs$35$ProfileActivity(alertDialog, zArr, file2);
                                            }
                                        });
                                    } catch (Throwable th) {
                                        th = th;
                                        bufferedInputStream = bufferedInputStream2;
                                        if (bufferedInputStream != null) {
                                            bufferedInputStream.close();
                                        }
                                        if (zipOutputStream != null) {
                                            zipOutputStream.close();
                                        }
                                        throw th;
                                    }
                                }
                            }
                            zArr[0] = true;
                        } catch (Exception e2) {
                            e = e2;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        zipOutputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        zipOutputStream = null;
                    }
                    zipOutputStream.close();
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$yXD7UF1rPHgBmapjT0rJKEisWrY
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$sendLogs$35$ProfileActivity(alertDialog, zArr, file2);
                        }
                    });
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Exception e4) {
                e = e4;
                e.printStackTrace();
            }
        } catch (Exception e5) {
            e = e5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$sendLogs$35, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$sendLogs$35$ProfileActivity(AlertDialog alertDialog, boolean[] zArr, File file) {
        Uri uriFromFile;
        try {
            alertDialog.dismiss();
        } catch (Exception unused) {
        }
        if (zArr[0]) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 24) {
                uriFromFile = FileProvider.getUriForFile(getParentActivity(), "ir.eitaa.messenger.provider", file);
            } else {
                uriFromFile = Uri.fromFile(file);
            }
            Intent intent = new Intent("android.intent.action.SEND");
            if (i >= 24) {
                intent.addFlags(1);
            }
            intent.setType("message/rfc822");
            intent.putExtra("android.intent.extra.EMAIL", "support@eitaa.com");
            intent.putExtra("android.intent.extra.SUBJECT", "Logs from " + LocaleController.getInstance().formatterStats.format(System.currentTimeMillis()));
            intent.putExtra("android.intent.extra.STREAM", uriFromFile);
            if (getParentActivity() != null) {
                try {
                    getParentActivity().startActivityForResult(Intent.createChooser(intent, "Select email application."), 500);
                    return;
                } catch (Exception e) {
                    FileLog.e(e);
                    return;
                }
            }
            return;
        }
        if (getParentActivity() != null) {
            Toast.makeText(getParentActivity(), LocaleController.getString("ErrorOccurred", R.string.ErrorOccurred), 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onCreateViewHolder$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onCreateViewHolder$0$ProfileActivity$ListAdapter(TLRPC$Ads_Ad tLRPC$Ads_Ad) {
            Browser.performAdAction(ProfileActivity.this.getParentActivity(), tLRPC$Ads_Ad, ProfileActivity.this);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) throws PackageManager.NameNotFoundException {
            View certSettingView;
            View headerCell;
            if (i == 15) {
                certSettingView = new SettingsSuggestionCell(this.mContext) { // from class: ir.eitaa.ui.ProfileActivity.ListAdapter.4
                    @Override // ir.eitaa.ui.Cells.SettingsSuggestionCell
                    protected void onYesClick(int type) {
                        NotificationCenter notificationCenter = ProfileActivity.this.getNotificationCenter();
                        ProfileActivity profileActivity = ProfileActivity.this;
                        int i2 = NotificationCenter.newSuggestionsAvailable;
                        notificationCenter.removeObserver(profileActivity, i2);
                        ProfileActivity.this.getMessagesController().removeSuggestion(0L, type == 0 ? "VALIDATE_PHONE_NUMBER" : "VALIDATE_PASSWORD");
                        ProfileActivity.this.getNotificationCenter().addObserver(ProfileActivity.this, i2);
                        if (type == 0) {
                            int unused = ProfileActivity.this.phoneSuggestionRow;
                        } else {
                            int unused2 = ProfileActivity.this.passwordSuggestionRow;
                        }
                        ProfileActivity.this.updateListAnimated(false);
                    }

                    @Override // ir.eitaa.ui.Cells.SettingsSuggestionCell
                    protected void onNoClick(int type) {
                        if (type == 0) {
                            ProfileActivity.this.presentFragment(new ActionIntroActivity(3));
                        } else {
                            ProfileActivity.this.presentFragment(new TwoStepVerificationSetupActivity(8, null));
                        }
                    }
                };
            } else if (i == 1399) {
                SimpleAdsList simpleAdsList = new SimpleAdsList(ProfileActivity.this.getParentActivity());
                simpleAdsList.setDelegate(new SimpleAdsList.Delegate() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$ListAdapter$wz97WSIFCZtJY_CEB4q4hTqry2M
                    @Override // ir.eitaa.ui.Components.SimpleAdsList.Delegate
                    public final void onAdClicked(TLRPC$Ads_Ad tLRPC$Ads_Ad) {
                        this.f$0.lambda$onCreateViewHolder$0$ProfileActivity$ListAdapter(tLRPC$Ads_Ad);
                    }
                });
                certSettingView = simpleAdsList;
            } else if (i == 1401) {
                TextInfoPrivacyCell textInfoPrivacyCell = new TextInfoPrivacyCell(this.mContext);
                CombinedDrawable combinedDrawable = new CombinedDrawable(new ColorDrawable(Theme.getColor("windowBackgroundGray")), Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, "windowBackgroundGrayShadow"));
                combinedDrawable.setFullsize(true);
                textInfoPrivacyCell.setBackgroundDrawable(combinedDrawable);
                textInfoPrivacyCell.setText(AndroidUtilities.replaceTags(LocaleController.formatString("ConvertGroupInfo", R.string.ConvertGroupInfo, LocaleController.formatPluralString("Members", MessagesController.getInstance(((BaseFragment) ProfileActivity.this).currentAccount).maxMegagroupCount))));
                certSettingView = textInfoPrivacyCell;
            } else if (i == 1382) {
                certSettingView = new CertSettingView(this.mContext, new CertSettingView.OnCertSelectListener() { // from class: ir.eitaa.ui.ProfileActivity.ListAdapter.5
                });
            } else if (i != 1383) {
                switch (i) {
                    case 0:
                        certSettingView = new EmptyCell(this.mContext);
                        break;
                    case 1:
                        headerCell = new HeaderCell(this.mContext, 23);
                        certSettingView = headerCell;
                        break;
                    case 2:
                        TextDetailCell textDetailCell = new TextDetailCell(this.mContext);
                        textDetailCell.setContentDescriptionValueFirst(true);
                        certSettingView = textDetailCell;
                        break;
                    case 3:
                        certSettingView = new AboutLinkCell(this.mContext, ProfileActivity.this) { // from class: ir.eitaa.ui.ProfileActivity.ListAdapter.1
                            @Override // ir.eitaa.ui.Cells.AboutLinkCell
                            protected void didPressUrl(String url) {
                                if (url.startsWith("@")) {
                                    ProfileActivity.this.getMessagesController().openByUserName(url.substring(1), ProfileActivity.this, 0);
                                    return;
                                }
                                if (url.startsWith("#")) {
                                    DialogsActivity dialogsActivity = new DialogsActivity(null);
                                    dialogsActivity.setSearchString(url);
                                    ProfileActivity.this.presentFragment(dialogsActivity);
                                } else {
                                    if (!url.startsWith("/") || ((BaseFragment) ProfileActivity.this).parentLayout.fragmentsStack.size() <= 1) {
                                        return;
                                    }
                                    BaseFragment baseFragment = ((BaseFragment) ProfileActivity.this).parentLayout.fragmentsStack.get(((BaseFragment) ProfileActivity.this).parentLayout.fragmentsStack.size() - 2);
                                    if (baseFragment instanceof ChatActivity) {
                                        ProfileActivity.this.finishFragment();
                                        ((ChatActivity) baseFragment).chatActivityEnterView.setCommand(null, url, false, false);
                                    }
                                }
                            }
                        };
                        break;
                    case 4:
                        certSettingView = new TextCell(this.mContext);
                        break;
                    case 5:
                        View dividerCell = new DividerCell(this.mContext);
                        dividerCell.setPadding(AndroidUtilities.dp(20.0f), AndroidUtilities.dp(4.0f), 0, 0);
                        certSettingView = dividerCell;
                        break;
                    case 6:
                        headerCell = new NotificationsCheckCell(this.mContext, 23, 70, false);
                        certSettingView = headerCell;
                        break;
                    case 7:
                        certSettingView = new ShadowSectionCell(this.mContext);
                        break;
                    case 8:
                        certSettingView = new UserCell(this.mContext, ProfileActivity.this.addMemberRow == -1 ? 9 : 6, 0, true);
                        break;
                    default:
                        switch (i) {
                            case 11:
                                certSettingView = new View(this.mContext) { // from class: ir.eitaa.ui.ProfileActivity.ListAdapter.2
                                    @Override // android.view.View
                                    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                                        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(32.0f), 1073741824));
                                    }
                                };
                                break;
                            case 12:
                                View view = new View(this.mContext) { // from class: ir.eitaa.ui.ProfileActivity.ListAdapter.3
                                    private int lastPaddingHeight = 0;
                                    private int lastListViewHeight = 0;

                                    @Override // android.view.View
                                    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                                        if (this.lastListViewHeight != ProfileActivity.this.listView.getMeasuredHeight()) {
                                            this.lastPaddingHeight = 0;
                                        }
                                        this.lastListViewHeight = ProfileActivity.this.listView.getMeasuredHeight();
                                        int childCount = ProfileActivity.this.listView.getChildCount();
                                        if (childCount == ProfileActivity.this.listAdapter.getItemCount()) {
                                            int measuredHeight = 0;
                                            for (int i2 = 0; i2 < childCount; i2++) {
                                                int childAdapterPosition = ProfileActivity.this.listView.getChildAdapterPosition(ProfileActivity.this.listView.getChildAt(i2));
                                                if (childAdapterPosition >= 0 && childAdapterPosition != ProfileActivity.this.bottomPaddingRow) {
                                                    measuredHeight += ProfileActivity.this.listView.getChildAt(i2).getMeasuredHeight();
                                                }
                                            }
                                            int measuredHeight2 = ((((BaseFragment) ProfileActivity.this).fragmentView.getMeasuredHeight() - ActionBar.getCurrentActionBarHeight()) - AndroidUtilities.statusBarHeight) - measuredHeight;
                                            if (measuredHeight2 > AndroidUtilities.dp(88.0f)) {
                                                measuredHeight2 = 0;
                                            }
                                            int i3 = measuredHeight2 > 0 ? measuredHeight2 : 0;
                                            int measuredWidth = ProfileActivity.this.listView.getMeasuredWidth();
                                            this.lastPaddingHeight = i3;
                                            setMeasuredDimension(measuredWidth, i3);
                                            return;
                                        }
                                        setMeasuredDimension(ProfileActivity.this.listView.getMeasuredWidth(), this.lastPaddingHeight);
                                    }
                                };
                                view.setBackground(new ColorDrawable(0));
                                certSettingView = view;
                                break;
                            case 13:
                                if (ProfileActivity.this.sharedMediaLayout.getParent() != null) {
                                    ((ViewGroup) ProfileActivity.this.sharedMediaLayout.getParent()).removeView(ProfileActivity.this.sharedMediaLayout);
                                }
                                certSettingView = ProfileActivity.this.sharedMediaLayout;
                                break;
                            default:
                                TextInfoPrivacyCell textInfoPrivacyCell2 = new TextInfoPrivacyCell(this.mContext, 10);
                                textInfoPrivacyCell2.getTextView().setGravity(1);
                                textInfoPrivacyCell2.getTextView().setTextColor(Theme.getColor("windowBackgroundWhiteGrayText3"));
                                textInfoPrivacyCell2.getTextView().setMovementMethod(null);
                                try {
                                    PackageInfo packageInfo = ApplicationLoader.applicationContext.getPackageManager().getPackageInfo(ApplicationLoader.applicationContext.getPackageName(), 0);
                                    int i2 = packageInfo.versionCode;
                                    int i3 = i2 / 10;
                                    String str = "";
                                    switch (i2 % 10) {
                                        case 0:
                                        case 9:
                                            if (BuildVars.isStandaloneApp()) {
                                                str = "direct " + Build.CPU_ABI + " " + Build.CPU_ABI2;
                                                break;
                                            } else {
                                                str = "universal " + Build.CPU_ABI + " " + Build.CPU_ABI2;
                                                break;
                                            }
                                        case 1:
                                        case 3:
                                            str = "arm-v7a";
                                            break;
                                        case 2:
                                        case 4:
                                            str = "x86";
                                            break;
                                        case 5:
                                        case 7:
                                            str = "arm64-v8a";
                                            break;
                                        case 6:
                                        case 8:
                                            str = "x86_64";
                                            break;
                                    }
                                    textInfoPrivacyCell2.setText(String.format(LocaleController.getString("EitaaVersion", R.string.EitaaVersion), String.format(Locale.US, "v%s (%d) %s", packageInfo.versionName, Integer.valueOf(i3), str)));
                                } catch (Exception e) {
                                    FileLog.e(e);
                                }
                                textInfoPrivacyCell2.getTextView().setPadding(0, AndroidUtilities.dp(14.0f), 0, AndroidUtilities.dp(14.0f));
                                textInfoPrivacyCell2.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
                                certSettingView = textInfoPrivacyCell2;
                                break;
                        }
                }
            } else {
                certSettingView = new TransportTypeSettingView(this.mContext);
            }
            if (i != 13) {
                certSettingView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            }
            return new RecyclerListView.Holder(certSettingView);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
            if (holder.itemView == ProfileActivity.this.sharedMediaLayout) {
                ProfileActivity.this.sharedMediaLayoutAttached = true;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewDetachedFromWindow(RecyclerView.ViewHolder holder) {
            if (holder.itemView == ProfileActivity.this.sharedMediaLayout) {
                ProfileActivity.this.sharedMediaLayoutAttached = false;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            String string;
            String string2;
            String str;
            String str2;
            String string3;
            String tTLString;
            int i2;
            String str3;
            String string4;
            TLRPC$ChatParticipant tLRPC$ChatParticipant;
            String string5;
            int itemViewType = viewHolder.getItemViewType();
            zIsGlobalNotificationsEnabled = true;
            zIsGlobalNotificationsEnabled = true;
            zIsGlobalNotificationsEnabled = true;
            boolean zIsGlobalNotificationsEnabled = true;
            if (itemViewType == 1) {
                HeaderCell headerCell = (HeaderCell) viewHolder.itemView;
                if (i == ProfileActivity.this.infoHeaderRow) {
                    if (ChatObject.isChannel(ProfileActivity.this.currentChat) && !ProfileActivity.this.currentChat.megagroup && ProfileActivity.this.channelInfoRow != -1) {
                        headerCell.setText(LocaleController.getString("ReportChatDescription", R.string.ReportChatDescription));
                        return;
                    } else {
                        headerCell.setText(LocaleController.getString("Info", R.string.Info));
                        return;
                    }
                }
                if (i != ProfileActivity.this.membersHeaderRow) {
                    if (i != ProfileActivity.this.settingsSectionRow2) {
                        if (i != ProfileActivity.this.numberSectionRow) {
                            if (i != ProfileActivity.this.helpHeaderRow) {
                                if (i == ProfileActivity.this.debugHeaderRow) {
                                    headerCell.setText(LocaleController.getString("SettingsDebug", R.string.SettingsDebug));
                                    return;
                                }
                                return;
                            }
                            headerCell.setText(LocaleController.getString("SettingsHelp", R.string.SettingsHelp));
                            return;
                        }
                        headerCell.setText(LocaleController.getString("Account", R.string.Account));
                        return;
                    }
                    headerCell.setText(LocaleController.getString("SETTINGS", R.string.SETTINGS));
                    return;
                }
                headerCell.setText(LocaleController.getString("ChannelMembers", R.string.ChannelMembers));
                return;
            }
            if (itemViewType == 2) {
                TextDetailCell textDetailCell = (TextDetailCell) viewHolder.itemView;
                if (i == ProfileActivity.this.phoneRow) {
                    TLRPC$User user = ProfileActivity.this.getMessagesController().getUser(Long.valueOf(ProfileActivity.this.userId));
                    if (!TextUtils.isEmpty(user.phone)) {
                        string3 = PhoneFormat.getInstance().format("+" + user.phone);
                    } else {
                        string3 = LocaleController.getString("PhoneHidden", R.string.PhoneHidden);
                    }
                    textDetailCell.setTextAndValue(string3, LocaleController.getString("PhoneMobile", R.string.PhoneMobile), false);
                    return;
                }
                if (i == ProfileActivity.this.usernameRow) {
                    if (ProfileActivity.this.userId != 0) {
                        TLRPC$User user2 = ProfileActivity.this.getMessagesController().getUser(Long.valueOf(ProfileActivity.this.userId));
                        if (user2 == null || TextUtils.isEmpty(user2.username)) {
                            str2 = "-";
                        } else {
                            str2 = "@" + user2.username;
                        }
                        textDetailCell.setTextAndValue(str2, LocaleController.getString("Username", R.string.Username), false);
                        return;
                    }
                    if (ProfileActivity.this.currentChat != null) {
                        textDetailCell.setTextAndValue(ProfileActivity.this.getMessagesController().linkPrefix + "/" + ProfileActivity.this.getMessagesController().getChat(Long.valueOf(ProfileActivity.this.chatId)).username, LocaleController.getString("InviteLink", R.string.InviteLink), false);
                        return;
                    }
                    return;
                }
                if (i == ProfileActivity.this.locationRow) {
                    if (ProfileActivity.this.chatInfo == null || !(ProfileActivity.this.chatInfo.location instanceof TLRPC$TL_channelLocation)) {
                        return;
                    }
                    textDetailCell.setTextAndValue(((TLRPC$TL_channelLocation) ProfileActivity.this.chatInfo.location).address, LocaleController.getString("AttachLocation", R.string.AttachLocation), false);
                    return;
                }
                if (i == ProfileActivity.this.numberRow) {
                    TLRPC$User currentUser = UserConfig.getInstance(((BaseFragment) ProfileActivity.this).currentAccount).getCurrentUser();
                    if (currentUser != null && (str = currentUser.phone) != null && str.length() != 0) {
                        string2 = PhoneFormat.getInstance().format("+" + currentUser.phone);
                    } else {
                        string2 = LocaleController.getString("NumberUnknown", R.string.NumberUnknown);
                    }
                    textDetailCell.setTextAndValue(string2, LocaleController.getString("TapToChangePhone", R.string.TapToChangePhone), true);
                    textDetailCell.disableValueTextView();
                    textDetailCell.setContentDescriptionValueFirst(false);
                    return;
                }
                if (i == ProfileActivity.this.setUsernameRow) {
                    TLRPC$User currentUser2 = UserConfig.getInstance(((BaseFragment) ProfileActivity.this).currentAccount).getCurrentUser();
                    if (currentUser2 != null && !TextUtils.isEmpty(currentUser2.username)) {
                        string = "@" + currentUser2.username;
                    } else {
                        string = LocaleController.getString("UsernameEmpty", R.string.UsernameEmpty);
                    }
                    textDetailCell.setTextAndValue(string, LocaleController.getString("Username", R.string.Username), true);
                    textDetailCell.setContentDescriptionValueFirst(true);
                    return;
                }
                if (i == ProfileActivity.this.bioRow) {
                    if (ProfileActivity.this.userInfo == null || !TextUtils.isEmpty(ProfileActivity.this.userInfo.about)) {
                        textDetailCell.setTextWithEmojiAndValue(ProfileActivity.this.userInfo == null ? LocaleController.getString("Loading", R.string.Loading) : ProfileActivity.this.userInfo.about, LocaleController.getString("UserBio", R.string.UserBio), false);
                        textDetailCell.setContentDescriptionValueFirst(true);
                        ProfileActivity profileActivity = ProfileActivity.this;
                        profileActivity.currentBio = profileActivity.userInfo != null ? ProfileActivity.this.userInfo.about : null;
                        return;
                    }
                    textDetailCell.setTextAndValue(LocaleController.getString("UserBio", R.string.UserBio), LocaleController.getString("UserBioDetail", R.string.UserBioDetail), false);
                    textDetailCell.setContentDescriptionValueFirst(false);
                    ProfileActivity.this.currentBio = null;
                    return;
                }
                return;
            }
            if (itemViewType == 3) {
                AboutLinkCell aboutLinkCell = (AboutLinkCell) viewHolder.itemView;
                if (i == ProfileActivity.this.userInfoRow) {
                    aboutLinkCell.setTextAndValue(ProfileActivity.this.userInfo.about, LocaleController.getString("UserBio", R.string.UserBio), ProfileActivity.this.isBot);
                    return;
                } else {
                    if (i == ProfileActivity.this.channelInfoRow) {
                        String strReplace = ProfileActivity.this.chatInfo.about;
                        while (strReplace.contains("\n\n\n")) {
                            strReplace = strReplace.replace("\n\n\n", "\n\n");
                        }
                        aboutLinkCell.setText(strReplace, ChatObject.isChannel(ProfileActivity.this.currentChat) && !ProfileActivity.this.currentChat.megagroup);
                        return;
                    }
                    return;
                }
            }
            if (itemViewType == 4) {
                TextCell textCell = (TextCell) viewHolder.itemView;
                textCell.setColors("windowBackgroundWhiteGrayIcon", "windowBackgroundWhiteBlackText");
                textCell.setTag("windowBackgroundWhiteBlackText");
                if (i != ProfileActivity.this.settingsTimerRow) {
                    if (i != ProfileActivity.this.unblockRow) {
                        if (i != ProfileActivity.this.settingsKeyRow) {
                            if (i != ProfileActivity.this.joinRow) {
                                if (i == ProfileActivity.this.subscribersRow) {
                                    if (ProfileActivity.this.chatInfo != null) {
                                        if (!ChatObject.isChannel(ProfileActivity.this.currentChat) || ProfileActivity.this.currentChat.megagroup) {
                                            textCell.setTextAndValueAndIcon(LocaleController.getString("ChannelMembers", R.string.ChannelMembers), AndroidUtilities.fixNumbers(String.format("%d", Integer.valueOf(ProfileActivity.this.chatInfo.participants_count))), R.drawable.actions_viewmembers, i != ProfileActivity.this.membersSectionRow - 1);
                                            return;
                                        } else {
                                            textCell.setTextAndValueAndIcon(LocaleController.getString("ChannelSubscribers", R.string.ChannelSubscribers), AndroidUtilities.fixNumbers(String.format("%d", Integer.valueOf(ProfileActivity.this.chatInfo.participants_count))), R.drawable.actions_viewmembers, i != ProfileActivity.this.membersSectionRow - 1);
                                            return;
                                        }
                                    }
                                    if (!ChatObject.isChannel(ProfileActivity.this.currentChat) || ProfileActivity.this.currentChat.megagroup) {
                                        textCell.setTextAndIcon(LocaleController.getString("ChannelMembers", R.string.ChannelMembers), R.drawable.actions_viewmembers, i != ProfileActivity.this.membersSectionRow - 1);
                                        return;
                                    } else {
                                        textCell.setTextAndIcon(LocaleController.getString("ChannelSubscribers", R.string.ChannelSubscribers), R.drawable.actions_viewmembers, i != ProfileActivity.this.membersSectionRow - 1);
                                        return;
                                    }
                                }
                                if (i == ProfileActivity.this.administratorsRow) {
                                    if (ProfileActivity.this.chatInfo != null) {
                                        textCell.setTextAndValueAndIcon(LocaleController.getString("ChannelAdministrators", R.string.ChannelAdministrators), String.format("%d", Integer.valueOf(ProfileActivity.this.chatInfo.admins_count)), R.drawable.actions_addadmin, i != ProfileActivity.this.membersSectionRow - 1);
                                        return;
                                    } else {
                                        textCell.setTextAndIcon(LocaleController.getString("ChannelAdministrators", R.string.ChannelAdministrators), R.drawable.actions_addadmin, i != ProfileActivity.this.membersSectionRow - 1);
                                        return;
                                    }
                                }
                                if (i == ProfileActivity.this.blockedUsersRow) {
                                    if (ProfileActivity.this.chatInfo != null) {
                                        textCell.setTextAndValueAndIcon(LocaleController.getString("ChannelBlacklist", R.string.ChannelBlacklist), String.format("%d", Integer.valueOf(Math.max(ProfileActivity.this.chatInfo.banned_count, ProfileActivity.this.chatInfo.kicked_count))), R.drawable.actions_removed, i != ProfileActivity.this.membersSectionRow - 1);
                                        return;
                                    } else {
                                        textCell.setTextAndIcon(LocaleController.getString("ChannelBlacklist", R.string.ChannelBlacklist), R.drawable.actions_removed, i != ProfileActivity.this.membersSectionRow - 1);
                                        return;
                                    }
                                }
                                if (i != ProfileActivity.this.addMemberRow) {
                                    if (i != ProfileActivity.this.sendMessageRow) {
                                        if (i != ProfileActivity.this.reportRow) {
                                            if (i != ProfileActivity.this.languageRow) {
                                                if (i != ProfileActivity.this.notificationRow) {
                                                    if (i != ProfileActivity.this.privacyRow) {
                                                        if (i != ProfileActivity.this.dataRow) {
                                                            if (i != ProfileActivity.this.chatRow) {
                                                                if (i != ProfileActivity.this.filtersRow) {
                                                                    if (i != ProfileActivity.this.questionRow) {
                                                                        if (i != ProfileActivity.this.faqRow) {
                                                                            if (i != ProfileActivity.this.policyRow) {
                                                                                if (i != ProfileActivity.this.sendLogsRow) {
                                                                                    if (i != ProfileActivity.this.sendLastLogsRow) {
                                                                                        if (i == ProfileActivity.this.clearLogsRow) {
                                                                                            textCell.setText(LocaleController.getString("DebugClearLogs", R.string.DebugClearLogs), ProfileActivity.this.switchBackendRow != -1);
                                                                                            return;
                                                                                        }
                                                                                        if (i != ProfileActivity.this.switchBackendRow) {
                                                                                            if (i != ProfileActivity.this.devicesRow) {
                                                                                                if (i == ProfileActivity.this.setAvatarRow) {
                                                                                                    textCell.setColors("windowBackgroundWhiteBlueIcon", "windowBackgroundWhiteBlueButton");
                                                                                                    textCell.setTextAndIcon(LocaleController.getString("SetProfilePhoto", R.string.SetProfilePhoto), R.drawable.msg_addphoto, false);
                                                                                                    return;
                                                                                                }
                                                                                                return;
                                                                                            }
                                                                                            textCell.setTextAndIcon(LocaleController.getString("Devices", R.string.Devices), R.drawable.menu_devices, true);
                                                                                            return;
                                                                                        }
                                                                                        textCell.setText("Switch Backend", false);
                                                                                        return;
                                                                                    }
                                                                                    textCell.setText(LocaleController.getString("DebugSendLastLogs", R.string.DebugSendLastLogs), true);
                                                                                    return;
                                                                                }
                                                                                textCell.setText(LocaleController.getString("DebugSendLogs", R.string.DebugSendLogs), true);
                                                                                return;
                                                                            }
                                                                            textCell.setTextAndIcon(LocaleController.getString("PrivacyPolicy", R.string.PrivacyPolicy), R.drawable.menu_policy, false);
                                                                            return;
                                                                        }
                                                                        textCell.setTextAndIcon(LocaleController.getString("EitaaFAQ", R.string.EitaaFAQ), R.drawable.menu_help, true);
                                                                        return;
                                                                    }
                                                                    textCell.setTextAndIcon(LocaleController.getString("AskAQuestion", R.string.AskAQuestion), R.drawable.menu_support2, true);
                                                                    return;
                                                                }
                                                                textCell.setTextAndIcon(LocaleController.getString("Filters", R.string.Filters), R.drawable.menu_folders, true);
                                                                return;
                                                            }
                                                            textCell.setTextAndIcon(LocaleController.getString("ChatSettings", R.string.ChatSettings), R.drawable.menu_chats, true);
                                                            return;
                                                        }
                                                        textCell.setTextAndIcon(LocaleController.getString("DataSettings", R.string.DataSettings), R.drawable.menu_data, true);
                                                        return;
                                                    }
                                                    textCell.setTextAndIcon(LocaleController.getString("PrivacySettings", R.string.PrivacySettings), R.drawable.menu_secret, true);
                                                    return;
                                                }
                                                textCell.setTextAndIcon(LocaleController.getString("NotificationsAndSounds", R.string.NotificationsAndSounds), R.drawable.menu_notifications, true);
                                                return;
                                            }
                                            textCell.setTextAndIcon(LocaleController.getString("Language", R.string.Language), R.drawable.menu_language, false);
                                            return;
                                        }
                                        textCell.setText(LocaleController.getString("ReportUserLocation", R.string.ReportUserLocation), false);
                                        textCell.setColors(null, "windowBackgroundWhiteRedText5");
                                        return;
                                    }
                                    textCell.setText(LocaleController.getString("SendMessageLocation", R.string.SendMessageLocation), true);
                                    return;
                                }
                                textCell.setColors("windowBackgroundWhiteBlueIcon", "windowBackgroundWhiteBlueButton");
                                textCell.setTextAndIcon(LocaleController.getString("AddMember", R.string.AddMember), R.drawable.actions_addmember2, ProfileActivity.this.membersSectionRow == -1);
                                return;
                            }
                            textCell.setColors(null, "windowBackgroundWhiteBlueText2");
                            if (ProfileActivity.this.currentChat.megagroup) {
                                textCell.setText(LocaleController.getString("ProfileJoinGroup", R.string.ProfileJoinGroup), false);
                                return;
                            } else {
                                textCell.setText(LocaleController.getString("ProfileJoinChannel", R.string.ProfileJoinChannel), false);
                                return;
                            }
                        }
                        IdenticonDrawable identiconDrawable = new IdenticonDrawable();
                        identiconDrawable.setEncryptedChat(ProfileActivity.this.getMessagesController().getEncryptedChat(Integer.valueOf(DialogObject.getEncryptedChatId(ProfileActivity.this.dialogId))));
                        textCell.setTextAndValueDrawable(LocaleController.getString("EncryptionKey", R.string.EncryptionKey), identiconDrawable, false);
                        return;
                    }
                    textCell.setText(LocaleController.getString("Unblock", R.string.Unblock), false);
                    textCell.setColors(null, "windowBackgroundWhiteRedText5");
                    return;
                }
                int i3 = ProfileActivity.this.getMessagesController().getEncryptedChat(Integer.valueOf(DialogObject.getEncryptedChatId(ProfileActivity.this.dialogId))).ttl;
                if (i3 == 0) {
                    tTLString = LocaleController.getString("ShortMessageLifetimeForever", R.string.ShortMessageLifetimeForever);
                } else {
                    tTLString = LocaleController.formatTTLString(i3);
                }
                textCell.setTextAndValue(LocaleController.getString("MessageLifetime", R.string.MessageLifetime), tTLString, false);
                return;
            }
            if (itemViewType == 6) {
                NotificationsCheckCell notificationsCheckCell = (NotificationsCheckCell) viewHolder.itemView;
                if (i == ProfileActivity.this.notificationsRow) {
                    SharedPreferences notificationsSettings = MessagesController.getNotificationsSettings(((BaseFragment) ProfileActivity.this).currentAccount);
                    long j = ProfileActivity.this.dialogId != 0 ? ProfileActivity.this.dialogId : ProfileActivity.this.userId != 0 ? ProfileActivity.this.userId : -ProfileActivity.this.chatId;
                    boolean z = notificationsSettings.getBoolean("custom_" + j, false);
                    boolean zContains = notificationsSettings.contains("notify2_" + j);
                    int i4 = notificationsSettings.getInt("notify2_" + j, 0);
                    int i5 = notificationsSettings.getInt("notifyuntil_" + j, 0);
                    if (i4 != 3 || i5 == Integer.MAX_VALUE) {
                        if (i4 == 0) {
                            if (!zContains) {
                                zIsGlobalNotificationsEnabled = ProfileActivity.this.getNotificationsController().isGlobalNotificationsEnabled(j);
                            }
                        } else if (i4 != 1) {
                            zIsGlobalNotificationsEnabled = false;
                        }
                        if (zIsGlobalNotificationsEnabled && z) {
                            string = LocaleController.getString("NotificationsCustom", R.string.NotificationsCustom);
                        } else {
                            if (zIsGlobalNotificationsEnabled) {
                                i2 = R.string.NotificationsOn;
                                str3 = "NotificationsOn";
                            } else {
                                i2 = R.string.NotificationsOff;
                                str3 = "NotificationsOff";
                            }
                            string4 = LocaleController.getString(str3, i2);
                            string = string4;
                        }
                    } else {
                        int currentTime = i5 - ProfileActivity.this.getConnectionsManager().getCurrentTime();
                        if (currentTime <= 0) {
                            if (z) {
                                string4 = LocaleController.getString("NotificationsCustom", R.string.NotificationsCustom);
                            } else {
                                string4 = LocaleController.getString("NotificationsOn", R.string.NotificationsOn);
                            }
                            string = string4;
                        } else {
                            if (currentTime < 3600) {
                                string = LocaleController.formatString("WillUnmuteIn", R.string.WillUnmuteIn, LocaleController.formatPluralString("Minutes", currentTime / 60));
                            } else if (currentTime < 86400) {
                                string = LocaleController.formatString("WillUnmuteIn", R.string.WillUnmuteIn, LocaleController.formatPluralString("Hours", (int) Math.ceil((currentTime / 60.0f) / 60.0f)));
                            } else if (currentTime < 31536000) {
                                string = LocaleController.formatString("WillUnmuteIn", R.string.WillUnmuteIn, LocaleController.formatPluralString("Days", (int) Math.ceil(((currentTime / 60.0f) / 60.0f) / 24.0f)));
                            }
                            zIsGlobalNotificationsEnabled = false;
                        }
                    }
                    if (string == null) {
                        string = LocaleController.getString("NotificationsOff", R.string.NotificationsOff);
                    }
                    notificationsCheckCell.setTextAndValueAndCheck(LocaleController.getString("Notifications", R.string.Notifications), string, zIsGlobalNotificationsEnabled, false);
                    return;
                }
                return;
            }
            if (itemViewType == 7) {
                View view = viewHolder.itemView;
                view.setTag(Integer.valueOf(i));
                if ((i == ProfileActivity.this.infoSectionRow && ProfileActivity.this.lastSectionRow == -1 && ProfileActivity.this.secretSettingsSectionRow == -1 && ProfileActivity.this.sharedMediaRow == -1 && ProfileActivity.this.membersSectionRow == -1) || i == ProfileActivity.this.secretSettingsSectionRow || i == ProfileActivity.this.lastSectionRow || (i == ProfileActivity.this.membersSectionRow && ProfileActivity.this.lastSectionRow == -1 && ProfileActivity.this.sharedMediaRow == -1)) {
                    view.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
                    return;
                } else {
                    view.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, "windowBackgroundGrayShadow"));
                    return;
                }
            }
            if (itemViewType == 8) {
                UserCell userCell = (UserCell) viewHolder.itemView;
                try {
                    tLRPC$ChatParticipant = !ProfileActivity.this.visibleSortedUsers.isEmpty() ? (TLRPC$ChatParticipant) ProfileActivity.this.visibleChatParticipants.get(((Integer) ProfileActivity.this.visibleSortedUsers.get(i - ProfileActivity.this.membersStartRow)).intValue()) : (TLRPC$ChatParticipant) ProfileActivity.this.visibleChatParticipants.get(i - ProfileActivity.this.membersStartRow);
                } catch (Exception e) {
                    FileLog.e(e);
                    tLRPC$ChatParticipant = null;
                }
                if (tLRPC$ChatParticipant != null) {
                    if (tLRPC$ChatParticipant instanceof TLRPC$TL_chatChannelParticipant) {
                        TLRPC$ChannelParticipant tLRPC$ChannelParticipant = ((TLRPC$TL_chatChannelParticipant) tLRPC$ChatParticipant).channelParticipant;
                        if (!TextUtils.isEmpty(tLRPC$ChannelParticipant.rank)) {
                            string5 = tLRPC$ChannelParticipant.rank;
                        } else if (tLRPC$ChannelParticipant instanceof TLRPC$TL_channelParticipantCreator) {
                            string5 = LocaleController.getString("ChannelCreator", R.string.ChannelCreator);
                        } else if (tLRPC$ChannelParticipant instanceof TLRPC$TL_channelParticipantAdmin) {
                            string5 = LocaleController.getString("ChannelAdmin", R.string.ChannelAdmin);
                        }
                        string = string5;
                    } else if (tLRPC$ChatParticipant instanceof TLRPC$TL_chatParticipantCreator) {
                        string = LocaleController.getString("ChannelCreator", R.string.ChannelCreator);
                    } else if (tLRPC$ChatParticipant instanceof TLRPC$TL_chatParticipantAdmin) {
                        string = LocaleController.getString("ChannelAdmin", R.string.ChannelAdmin);
                    }
                    userCell.setAdminRole(string);
                    userCell.setData(ProfileActivity.this.getMessagesController().getUser(Long.valueOf(tLRPC$ChatParticipant.user_id)), null, null, 0, i != ProfileActivity.this.membersEndRow - 1);
                    return;
                }
                return;
            }
            if (itemViewType == 12) {
                viewHolder.itemView.requestLayout();
                return;
            }
            if (itemViewType == 15) {
                ((SettingsSuggestionCell) viewHolder.itemView).setType(i != ProfileActivity.this.passwordSuggestionRow ? 0 : 1);
                return;
            }
            if (itemViewType != 1399) {
                if (itemViewType != 1401) {
                    return;
                }
                TextInfoPrivacyCell textInfoPrivacyCell = (TextInfoPrivacyCell) viewHolder.itemView;
                if (i != ProfileActivity.this.viewParticipantsDefaultBannedHelpRow) {
                    if (i == ProfileActivity.this.viewParticipantsBannedHelpRow) {
                        textInfoPrivacyCell.setText(LocaleController.getString("ViewParticipantsRestricted", R.string.ViewParticipantsRestricted));
                        return;
                    }
                    return;
                }
                textInfoPrivacyCell.setText(LocaleController.getString("GlobalViewParticipantsRestricted", R.string.GlobalViewParticipantsRestricted));
                return;
            }
            if (ProfileActivity.this.chatId != 0) {
                SimpleAdsList simpleAdsList = (SimpleAdsList) viewHolder.itemView;
                TLRPC$TL_ads_inputAdsLocationChatMembers tLRPC$TL_ads_inputAdsLocationChatMembers = new TLRPC$TL_ads_inputAdsLocationChatMembers();
                simpleAdsList.location = tLRPC$TL_ads_inputAdsLocationChatMembers;
                tLRPC$TL_ads_inputAdsLocationChatMembers.peer = MessagesController.getInstance(((BaseFragment) ProfileActivity.this).currentAccount).getInputPeer(-ProfileActivity.this.chatId);
                ArrayList<TLRPC$Ads_Ad> arrayList = ProfileActivity.this.ads;
                if (arrayList != null) {
                    simpleAdsList.showAds(arrayList);
                    simpleAdsList.setTitle(ProfileActivity.this.adsTitle);
                }
            }
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            if (ProfileActivity.this.notificationRow != -1) {
                int adapterPosition = holder.getAdapterPosition();
                return adapterPosition == ProfileActivity.this.notificationRow || adapterPosition == ProfileActivity.this.numberRow || adapterPosition == ProfileActivity.this.privacyRow || adapterPosition == ProfileActivity.this.languageRow || adapterPosition == ProfileActivity.this.setUsernameRow || adapterPosition == ProfileActivity.this.bioRow || adapterPosition == ProfileActivity.this.versionRow || adapterPosition == ProfileActivity.this.dataRow || adapterPosition == ProfileActivity.this.chatRow || adapterPosition == ProfileActivity.this.questionRow || adapterPosition == ProfileActivity.this.devicesRow || adapterPosition == ProfileActivity.this.filtersRow || adapterPosition == ProfileActivity.this.faqRow || adapterPosition == ProfileActivity.this.policyRow || adapterPosition == ProfileActivity.this.sendLogsRow || adapterPosition == ProfileActivity.this.sendLastLogsRow || adapterPosition == ProfileActivity.this.clearLogsRow || adapterPosition == ProfileActivity.this.switchBackendRow || adapterPosition == ProfileActivity.this.setAvatarRow;
            }
            View view = holder.itemView;
            if (view instanceof UserCell) {
                Object currentObject = ((UserCell) view).getCurrentObject();
                if ((currentObject instanceof TLRPC$User) && UserObject.isUserSelf((TLRPC$User) currentObject)) {
                    return false;
                }
            }
            int itemViewType = holder.getItemViewType();
            return (itemViewType == 1 || itemViewType == 5 || itemViewType == 7 || itemViewType == 9 || itemViewType == 10 || itemViewType == 11 || itemViewType == 12 || itemViewType == 13) ? false : true;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return ProfileActivity.this.rowCount;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            if (position == ProfileActivity.this.infoHeaderRow || position == ProfileActivity.this.membersHeaderRow || position == ProfileActivity.this.settingsSectionRow2 || position == ProfileActivity.this.numberSectionRow || position == ProfileActivity.this.helpHeaderRow || position == ProfileActivity.this.debugHeaderRow) {
                return 1;
            }
            if (position == ProfileActivity.this.phoneRow || position == ProfileActivity.this.usernameRow || position == ProfileActivity.this.locationRow || position == ProfileActivity.this.numberRow || position == ProfileActivity.this.setUsernameRow || position == ProfileActivity.this.bioRow) {
                return 2;
            }
            if (position == ProfileActivity.this.userInfoRow || position == ProfileActivity.this.channelInfoRow) {
                return 3;
            }
            if (position == ProfileActivity.this.settingsTimerRow || position == ProfileActivity.this.settingsKeyRow || position == ProfileActivity.this.reportRow || position == ProfileActivity.this.subscribersRow || position == ProfileActivity.this.administratorsRow || position == ProfileActivity.this.blockedUsersRow || position == ProfileActivity.this.addMemberRow || position == ProfileActivity.this.joinRow || position == ProfileActivity.this.unblockRow || position == ProfileActivity.this.sendMessageRow || position == ProfileActivity.this.notificationRow || position == ProfileActivity.this.privacyRow || position == ProfileActivity.this.languageRow || position == ProfileActivity.this.dataRow || position == ProfileActivity.this.chatRow || position == ProfileActivity.this.questionRow || position == ProfileActivity.this.devicesRow || position == ProfileActivity.this.filtersRow || position == ProfileActivity.this.faqRow || position == ProfileActivity.this.policyRow || position == ProfileActivity.this.sendLogsRow || position == ProfileActivity.this.sendLastLogsRow || position == ProfileActivity.this.clearLogsRow || position == ProfileActivity.this.switchBackendRow || position == ProfileActivity.this.setAvatarRow) {
                return 4;
            }
            if (position == ProfileActivity.this.notificationsDividerRow) {
                return 5;
            }
            if (position == ProfileActivity.this.notificationsRow) {
                return 6;
            }
            if (position == ProfileActivity.this.infoSectionRow || position == ProfileActivity.this.lastSectionRow || position == ProfileActivity.this.membersSectionRow || position == ProfileActivity.this.adSectionRow || position == ProfileActivity.this.secretSettingsSectionRow || position == ProfileActivity.this.settingsSectionRow || position == ProfileActivity.this.devicesSectionRow || position == ProfileActivity.this.helpSectionCell || position == ProfileActivity.this.setAvatarSectionRow || position == ProfileActivity.this.passwordSuggestionSectionRow || position == ProfileActivity.this.phoneSuggestionSectionRow || position == ProfileActivity.this.transportTypeSectionRow) {
                return 7;
            }
            if (position >= ProfileActivity.this.membersStartRow && position < ProfileActivity.this.membersEndRow) {
                return 8;
            }
            if (position == ProfileActivity.this.emptyRow) {
                return 11;
            }
            if (position == ProfileActivity.this.bottomPaddingRow) {
                return 12;
            }
            if (position == ProfileActivity.this.sharedMediaRow) {
                return 13;
            }
            if (position == ProfileActivity.this.versionRow) {
                return 14;
            }
            if (position == ProfileActivity.this.passwordSuggestionRow || position == ProfileActivity.this.phoneSuggestionRow) {
                return 15;
            }
            if (position == ProfileActivity.this.adRow) {
                return 1399;
            }
            if (position == ProfileActivity.this.viewParticipantsDefaultBannedHelpRow || position == ProfileActivity.this.viewParticipantsBannedHelpRow) {
                return 1401;
            }
            if (position == ProfileActivity.this.certRow) {
                return 1382;
            }
            return position == ProfileActivity.this.transportTypeRow ? 1383 : 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class SearchAdapter extends RecyclerListView.SelectionAdapter {
        private ArrayList<MessagesController.FaqSearchResult> faqSearchArray;
        private ArrayList<MessagesController.FaqSearchResult> faqSearchResults;
        private TLRPC$WebPage faqWebPage;
        private String lastSearchString;
        private boolean loadingFaqPage;
        private Context mContext;
        private ArrayList<Object> recentSearches;
        private ArrayList<CharSequence> resultNames;
        private SearchResult[] searchArray;
        private ArrayList<SearchResult> searchResults;
        private Runnable searchRunnable;
        private boolean searchWas;

        private class SearchResult {
            private int guid;
            private int iconResId;
            private int num;
            private Runnable openRunnable;
            private String[] path;
            private String rowName;
            private String searchTitle;

            public SearchResult(final SearchAdapter this$1, int g, String search, int icon, Runnable open) {
                this(g, search, null, null, null, icon, open);
            }

            public SearchResult(final SearchAdapter this$1, int g, String search, String pathArg1, int icon, Runnable open) {
                this(g, search, null, pathArg1, null, icon, open);
            }

            public SearchResult(final SearchAdapter this$1, int g, String search, String row, String pathArg1, int icon, Runnable open) {
                this(g, search, row, pathArg1, null, icon, open);
            }

            public SearchResult(int g, String search, String row, String pathArg1, String pathArg2, int icon, Runnable open) {
                this.guid = g;
                this.searchTitle = search;
                this.rowName = row;
                this.openRunnable = open;
                this.iconResId = icon;
                if (pathArg1 != null && pathArg2 != null) {
                    this.path = new String[]{pathArg1, pathArg2};
                } else if (pathArg1 != null) {
                    this.path = new String[]{pathArg1};
                }
            }

            public boolean equals(Object obj) {
                return (obj instanceof SearchResult) && this.guid == ((SearchResult) obj).guid;
            }

            public String toString() {
                SerializedData serializedData = new SerializedData();
                serializedData.writeInt32(this.num);
                serializedData.writeInt32(1);
                serializedData.writeInt32(this.guid);
                return Utilities.bytesToHex(serializedData.toByteArray());
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void open() {
                this.openRunnable.run();
                AndroidUtilities.scrollToFragmentRow(((BaseFragment) ProfileActivity.this).parentLayout, this.rowName);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$0$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new ChangeNameActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$1$ProfileActivity$SearchAdapter() {
            int i = 0;
            while (true) {
                if (i >= 3) {
                    i = -1;
                    break;
                } else if (!UserConfig.getInstance(i).isClientActivated()) {
                    break;
                } else {
                    i++;
                }
            }
            if (i >= 0) {
                ProfileActivity.this.presentFragment(new LoginActivity(i));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$2$ProfileActivity$SearchAdapter() {
            if (ProfileActivity.this.userInfo != null) {
                ProfileActivity.this.presentFragment(new ChangeBioActivity());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$3, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$3$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new NotificationsSettingsActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$4, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$4$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new NotificationsCustomSettingsActivity(1, new ArrayList(), true));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$5, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$5$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new NotificationsCustomSettingsActivity(0, new ArrayList(), true));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$6, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$6$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new NotificationsCustomSettingsActivity(2, new ArrayList(), true));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$7, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$7$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new NotificationsSettingsActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$8, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$8$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new NotificationsSettingsActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$9, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$9$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new NotificationsSettingsActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$10, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$10$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new NotificationsSettingsActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$11, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$11$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new NotificationsSettingsActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$12, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$12$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new NotificationsSettingsActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$13, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$13$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new PrivacySettingsActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$14, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$14$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new PrivacyUsersActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$15, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$15$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new PrivacyControlActivity(0, true));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$16, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$16$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new PrivacyControlActivity(1, true));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$17, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$17$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new PasscodeActivity(SharedConfig.passcodeHash.length() > 0 ? 2 : 0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$18, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$18$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new TwoStepVerificationActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$19, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$19$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new SessionsActivity(0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$20, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$20$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new PrivacySettingsActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$21, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$21$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new PrivacySettingsActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$22, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$22$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new PrivacySettingsActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$23, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$23$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new PrivacySettingsActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$24, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$24$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new SessionsActivity(0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$25, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$25$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new PrivacySettingsActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$26, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$26$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new PrivacySettingsActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$27, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$27$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new PrivacySettingsActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$28, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$28$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new DataSettingsActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$29, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$29$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new DataSettingsActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$30, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$30$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new CacheControlActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$31, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$31$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new CacheControlActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$32, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$32$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new CacheControlActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$33, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$33$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new CacheControlActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$34, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$34$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new DataUsageActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$35, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$35$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new DataSettingsActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$36, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$36$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new DataAutoDownloadActivity(0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$37, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$37$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new DataAutoDownloadActivity(1));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$38, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$38$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new DataAutoDownloadActivity(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$39, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$39$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new DataSettingsActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$40, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$40$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new DataSettingsActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$41, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$41$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new DataSettingsActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$42, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$42$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new DataSettingsActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$43, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$43$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new DataSettingsActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$44, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$44$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new DataSettingsActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$45, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$45$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new DataSettingsActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$46, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$46$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new DataSettingsActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$47, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$47$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new DataSettingsActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$48, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$48$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new ThemeActivity(0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$49, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$49$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new ThemeActivity(0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$50, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$50$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new WallpapersListActivity(0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$51, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$51$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new WallpapersListActivity(1));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$52, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$52$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new ThemeActivity(1));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$53, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$53$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new ThemeActivity(0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$54, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$54$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new ThemeActivity(0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$55, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$55$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new ThemeActivity(0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$56, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$56$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new ThemeActivity(0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$57, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$57$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new ThemeActivity(0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$58, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$58$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new ThemeActivity(0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$59, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$59$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new ThemeActivity(0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$60, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$60$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new ThemeActivity(0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$61, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$61$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new ThemeActivity(0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$62, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$62$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new ThemeActivity(0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$63, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$63$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new FiltersSetupActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$64, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$64$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new FiltersSetupActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$65, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$65$ProfileActivity$SearchAdapter() {
            ProfileActivity.this.presentFragment(new LanguageSelectActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$66, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$66$ProfileActivity$SearchAdapter() {
            ProfileActivity profileActivity = ProfileActivity.this;
            profileActivity.showDialog(AlertsCreator.createSupportAlert(profileActivity));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$67, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$67$ProfileActivity$SearchAdapter() {
            Browser.openUrl(ProfileActivity.this.getParentActivity(), LocaleController.getString("EitaaFaqUrl", R.string.EitaaFaqUrl));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$68, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$68$ProfileActivity$SearchAdapter() {
            Browser.openUrl(ProfileActivity.this.getParentActivity(), LocaleController.getString("PrivacyPolicyUrl", R.string.PrivacyPolicyUrl));
        }

        public SearchAdapter(Context context) {
            String[] strArr;
            SearchResult searchResult;
            SearchResult[] searchResultArr = new SearchResult[69];
            searchResultArr[0] = new SearchResult(this, 500, LocaleController.getString("EditName", R.string.EditName), 0, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$yELmXacG7Cdf1fPANYtI5biCNo4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$0$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[1] = new SearchResult(this, 502, LocaleController.getString("AddAnotherAccount", R.string.AddAnotherAccount), 0, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$5g44pLMAkT-X-bo3TT1UyRO13Bg
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$1$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[2] = new SearchResult(this, 503, LocaleController.getString("UserBio", R.string.UserBio), 0, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$NzQIJlRImdUe8w-ju0wAOnHUuqg
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$2$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[3] = new SearchResult(this, 1, LocaleController.getString("NotificationsAndSounds", R.string.NotificationsAndSounds), R.drawable.menu_notifications, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$ZxTF0kGQrGebauDFG2zKARMpnps
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$3$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[4] = new SearchResult(this, 2, LocaleController.getString("NotificationsPrivateChats", R.string.NotificationsPrivateChats), LocaleController.getString("NotificationsAndSounds", R.string.NotificationsAndSounds), R.drawable.menu_notifications, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$LBv5f6AGYun-XzlHi3VuZQdFOb4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$4$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[5] = new SearchResult(this, 3, LocaleController.getString("NotificationsGroups", R.string.NotificationsGroups), LocaleController.getString("NotificationsAndSounds", R.string.NotificationsAndSounds), R.drawable.menu_notifications, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$yecv1jQbhxQViVq7RwvVX4wTjGo
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$5$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[6] = new SearchResult(this, 4, LocaleController.getString("NotificationsChannels", R.string.NotificationsChannels), LocaleController.getString("NotificationsAndSounds", R.string.NotificationsAndSounds), R.drawable.menu_notifications, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$4fLsRJJIASdTABo-UchX7GZuWqo
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$6$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[7] = new SearchResult(this, 6, LocaleController.getString("BadgeNumber", R.string.BadgeNumber), "badgeNumberSection", LocaleController.getString("NotificationsAndSounds", R.string.NotificationsAndSounds), R.drawable.menu_notifications, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$jZXmysJ5-KOMp1vUlWl39fHFass
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$7$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[8] = new SearchResult(this, 7, LocaleController.getString("InAppNotifications", R.string.InAppNotifications), "inappSectionRow", LocaleController.getString("NotificationsAndSounds", R.string.NotificationsAndSounds), R.drawable.menu_notifications, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$MNfXPH_EcQaZMOxVTadAfXAx-lM
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$8$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[9] = new SearchResult(this, 8, LocaleController.getString("ContactJoined", R.string.ContactJoined), "contactJoinedRow", LocaleController.getString("NotificationsAndSounds", R.string.NotificationsAndSounds), R.drawable.menu_notifications, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$vWGSHRtTwhZDOMBb39De3zoQNSk
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$9$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[10] = new SearchResult(this, 9, LocaleController.getString("PinnedMessages", R.string.PinnedMessages), "pinnedMessageRow", LocaleController.getString("NotificationsAndSounds", R.string.NotificationsAndSounds), R.drawable.menu_notifications, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$1FZy-UHhzprkhZvQ1U1jKA2g9Tw
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$10$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[11] = new SearchResult(this, 10, LocaleController.getString("ResetAllNotifications", R.string.ResetAllNotifications), "resetNotificationsRow", LocaleController.getString("NotificationsAndSounds", R.string.NotificationsAndSounds), R.drawable.menu_notifications, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$9f2nQ3v77BpgVQOnO3tfl_EI2_g
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$11$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[12] = new SearchResult(this, 11, LocaleController.getString("NotificationsForegroundConnection", R.string.NotificationsForegroundConnection), "notificationsForegroundConnectionRow", LocaleController.getString("NotificationsAndSounds", R.string.NotificationsAndSounds), R.drawable.menu_notifications, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$ghPs8OOd8-qZF7RS-savdNoylZc
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$12$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[13] = new SearchResult(this, 100, LocaleController.getString("PrivacySettings", R.string.PrivacySettings), R.drawable.menu_secret, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$lBuBPlnalZXRDkc96qQoTbpERAY
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$13$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[14] = new SearchResult(this, R.styleable.AppCompatTheme_textAppearanceSearchResultSubtitle, LocaleController.getString("BlockedUsers", R.string.BlockedUsers), LocaleController.getString("PrivacySettings", R.string.PrivacySettings), R.drawable.menu_secret, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$xQR2QN9H-AZ08EtBetjR5pIcozU
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$14$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[15] = new SearchResult(this, R.styleable.AppCompatTheme_textAppearanceSearchResultTitle, LocaleController.getString("PrivacyLastSeen", R.string.PrivacyLastSeen), LocaleController.getString("PrivacySettings", R.string.PrivacySettings), R.drawable.menu_secret, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$ieruxrdhHDiLkdJbNDkyDk_OV-E
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$15$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[16] = new SearchResult(this, R.styleable.AppCompatTheme_toolbarStyle, LocaleController.getString("GroupsAndChannels", R.string.GroupsAndChannels), LocaleController.getString("PrivacySettings", R.string.PrivacySettings), R.drawable.menu_secret, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$p2WGlYJTjZMAkpoqjXYGDLXzSPA
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$16$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[17] = new SearchResult(this, R.styleable.AppCompatTheme_tooltipForegroundColor, LocaleController.getString("Passcode", R.string.Passcode), LocaleController.getString("PrivacySettings", R.string.PrivacySettings), R.drawable.menu_secret, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$65K6-BtmYJcxHddlxTRyaLJP8D4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$17$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[18] = new SearchResult(this, R.styleable.AppCompatTheme_tooltipFrameBackground, LocaleController.getString("TwoStepVerification", R.string.TwoStepVerification), LocaleController.getString("PrivacySettings", R.string.PrivacySettings), R.drawable.menu_secret, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$k5ihFGBVRYdcll4CwgaHBzynR6o
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$18$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[19] = new SearchResult(this, R.styleable.AppCompatTheme_viewInflaterClass, LocaleController.getString("SessionsTitle", R.string.SessionsTitle), R.drawable.menu_secret, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$JGX7HHE0R78120E_0bZYArlPq7Y
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$19$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[20] = ProfileActivity.this.getMessagesController().autoarchiveAvailable ? new SearchResult(this, 121, LocaleController.getString("ArchiveAndMute", R.string.ArchiveAndMute), "newChatsRow", LocaleController.getString("PrivacySettings", R.string.PrivacySettings), R.drawable.menu_secret, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$0gQewz5G5t9EP3z81WQz8iENUSw
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$20$ProfileActivity$SearchAdapter();
                }
            }) : null;
            searchResultArr[21] = new SearchResult(this, R.styleable.AppCompatTheme_windowFixedHeightMinor, LocaleController.getString("SyncContactsDelete", R.string.SyncContactsDelete), "contactsDeleteRow", LocaleController.getString("PrivacySettings", R.string.PrivacySettings), R.drawable.menu_secret, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$l74ikdDuY0oj_Fl_Dob0SVMt-24
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$21$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[22] = new SearchResult(this, R.styleable.AppCompatTheme_windowFixedWidthMajor, LocaleController.getString("SyncContacts", R.string.SyncContacts), "contactsSyncRow", LocaleController.getString("PrivacySettings", R.string.PrivacySettings), R.drawable.menu_secret, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$FGq77lvvMrKxZMn7g9SXUpf0wzY
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$22$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[23] = new SearchResult(this, R.styleable.AppCompatTheme_windowFixedWidthMinor, LocaleController.getString("SuggestContacts", R.string.SuggestContacts), "contactsSuggestRow", LocaleController.getString("PrivacySettings", R.string.PrivacySettings), R.drawable.menu_secret, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$bz2tPE57tOSOTEPd1uS3aTkjLhI
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$23$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[24] = new SearchResult(this, R.styleable.AppCompatTheme_windowNoTitle, LocaleController.getString("Devices", R.string.Devices), R.drawable.menu_secret, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$B_uECA0pDw8ODDx0cFN252RK7zQ
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$24$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[25] = new SearchResult(this, 121, LocaleController.getString("DebugMenuImportContacts", R.string.DebugMenuImportContacts), "importContactRow", LocaleController.getString("PrivacySettings", R.string.PrivacySettings), R.drawable.menu_secret, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$d02-1dNpRQuXwSSKds6K3ChVsno
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$25$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[26] = new SearchResult(this, 122, LocaleController.getString("DebugMenuReloadContacts", R.string.DebugMenuReloadContacts), "reloadContactRow", LocaleController.getString("PrivacySettings", R.string.PrivacySettings), R.drawable.menu_secret, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$YS7QrpZIkHcXW0Ubqu4oVpJTf3c
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$26$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[27] = new SearchResult(this, 125, LocaleController.getString("BlockAds", R.string.BlockAds), "blockExternalAdsRow", LocaleController.getString("PrivacySettings", R.string.PrivacySettings), R.drawable.menu_secret, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$I9E5kobQyMgtx2TstBqjLEJwLjo
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$27$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[28] = new SearchResult(this, 200, LocaleController.getString("DataSettings", R.string.DataSettings), R.drawable.menu_data, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$J7ugnr-BvqqxP0COuhGjqgh9RbI
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$28$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[29] = new SearchResult(this, 201, LocaleController.getString("DataUsage", R.string.DataUsage), "usageSectionRow", LocaleController.getString("DataSettings", R.string.DataSettings), R.drawable.menu_data, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$gNROuzo8vrzL6bfVa55GdqxyUTA
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$29$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[30] = new SearchResult(this, 202, LocaleController.getString("StorageUsage", R.string.StorageUsage), LocaleController.getString("DataSettings", R.string.DataSettings), R.drawable.menu_data, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$7ZAqpuSluWMhO0BxeYTzeSLD0_o
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$30$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[31] = new SearchResult(203, LocaleController.getString("KeepMedia", R.string.KeepMedia), "keepMediaRow", LocaleController.getString("DataSettings", R.string.DataSettings), LocaleController.getString("StorageUsage", R.string.StorageUsage), R.drawable.menu_data, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$kSlGucM6vFIhsr7aAouBQ7j0k1E
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$31$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[32] = new SearchResult(204, LocaleController.getString("ClearMediaCache", R.string.ClearMediaCache), "cacheRow", LocaleController.getString("DataSettings", R.string.DataSettings), LocaleController.getString("StorageUsage", R.string.StorageUsage), R.drawable.menu_data, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$Pi7ZNw95Kkq1s3dhrU6PMjvtf8E
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$32$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[33] = new SearchResult(205, LocaleController.getString("LocalDatabase", R.string.LocalDatabase), "databaseRow", LocaleController.getString("DataSettings", R.string.DataSettings), LocaleController.getString("StorageUsage", R.string.StorageUsage), R.drawable.menu_data, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$X7GM83tRPDchnzH6ygwOTgFzm28
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$33$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[34] = new SearchResult(this, 206, LocaleController.getString("NetworkUsage", R.string.NetworkUsage), LocaleController.getString("DataSettings", R.string.DataSettings), R.drawable.menu_data, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$Vlgg4eo2ufVy1KVb6v5HwlaV3A0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$34$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[35] = new SearchResult(this, 207, LocaleController.getString("AutomaticMediaDownload", R.string.AutomaticMediaDownload), "mediaDownloadSectionRow", LocaleController.getString("DataSettings", R.string.DataSettings), R.drawable.menu_data, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$w0_m_DRY4C38ek2uI6xydr9n4Qk
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$35$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[36] = new SearchResult(this, 208, LocaleController.getString("WhenUsingMobileData", R.string.WhenUsingMobileData), LocaleController.getString("DataSettings", R.string.DataSettings), R.drawable.menu_data, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$Yfyl8IFh26fN4tqlH_94kMVaCd8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$36$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[37] = new SearchResult(this, 209, LocaleController.getString("WhenConnectedOnWiFi", R.string.WhenConnectedOnWiFi), LocaleController.getString("DataSettings", R.string.DataSettings), R.drawable.menu_data, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$dMSIf_veXM1qxmBojAQ-e6gOKtA
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$37$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[38] = new SearchResult(this, 210, LocaleController.getString("WhenRoaming", R.string.WhenRoaming), LocaleController.getString("DataSettings", R.string.DataSettings), R.drawable.menu_data, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$0498O878ikIz6FDptLIyhq1Lmgg
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$38$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[39] = new SearchResult(this, 211, LocaleController.getString("ResetAutomaticMediaDownload", R.string.ResetAutomaticMediaDownload), "resetDownloadRow", LocaleController.getString("DataSettings", R.string.DataSettings), R.drawable.menu_data, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$cBi4NyYb002hoUZrEaF3gQdpx5M
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$39$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[40] = new SearchResult(this, 212, LocaleController.getString("AutoplayMedia", R.string.AutoplayMedia), "autoplayHeaderRow", LocaleController.getString("DataSettings", R.string.DataSettings), R.drawable.menu_data, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$PlwYYVEPCwcYZJioAqSJm2g8IEI
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$40$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[41] = new SearchResult(this, 213, LocaleController.getString("AutoplayGIF", R.string.AutoplayGIF), "autoplayGifsRow", LocaleController.getString("DataSettings", R.string.DataSettings), R.drawable.menu_data, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$q8OUrpe-bHJvSz7du028MTO_GXE
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$41$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[42] = new SearchResult(this, 214, LocaleController.getString("AutoplayVideo", R.string.AutoplayVideo), "autoplayVideoRow", LocaleController.getString("DataSettings", R.string.DataSettings), R.drawable.menu_data, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$dea9w8tTOHya6yCZD2xPzW8OKjY
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$42$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[43] = new SearchResult(this, 215, LocaleController.getString("Streaming", R.string.Streaming), "streamSectionRow", LocaleController.getString("DataSettings", R.string.DataSettings), R.drawable.menu_data, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$nYWR1RYcYhBz6a65hsnIZ6YcLzE
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$43$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[44] = new SearchResult(this, 216, LocaleController.getString("EnableStreaming", R.string.EnableStreaming), "enableStreamRow", LocaleController.getString("DataSettings", R.string.DataSettings), R.drawable.menu_data, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$C09Ps8rKM5Qd42l5tb0Hw_rFKSA
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$44$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[45] = new SearchResult(this, R.styleable.AppCompatTheme_windowActionBar, LocaleController.getString("PrivacyDeleteCloudDrafts", R.string.PrivacyDeleteCloudDrafts), "clearDraftsRow", LocaleController.getString("DataSettings", R.string.DataSettings), R.drawable.menu_data, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$cLN-WesmU-vU6N_3mjjEwVqaOr8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$45$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[46] = new SearchResult(this, 123, LocaleController.getString("VideoPlayerResumeOption", R.string.VideoPlayerResumeOption), "videoPlayResumeRow", LocaleController.getString("DataSettings", R.string.DataSettings), R.drawable.menu_data, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$Sj68FXRTAZ643tAqJ40JTk84rl8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$46$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[47] = new SearchResult(this, 124, LocaleController.getString("AudioPlayerResumeOption", R.string.AudioPlayerResumeOption), "audioPlayResumeRow", LocaleController.getString("DataSettings", R.string.DataSettings), R.drawable.menu_data, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$Bi9XKGiNd8-zja_kuUI_q_a1r7Q
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$47$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[48] = new SearchResult(this, 300, LocaleController.getString("ChatSettings", R.string.ChatSettings), R.drawable.menu_chats, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$-lA3qGtQMkvTEKe_5sCRAwssCzo
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$48$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[49] = new SearchResult(this, 301, LocaleController.getString("TextSizeHeader", R.string.TextSizeHeader), "textSizeHeaderRow", LocaleController.getString("ChatSettings", R.string.ChatSettings), R.drawable.menu_chats, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$obnD6e33RKFxp0wjuMA6hJ_iqvo
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$49$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[50] = new SearchResult(this, 302, LocaleController.getString("ChatBackground", R.string.ChatBackground), LocaleController.getString("ChatSettings", R.string.ChatSettings), R.drawable.menu_chats, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$SufVMiaLVw4BYy-tKlyCLPZIWp4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$50$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[51] = new SearchResult(303, LocaleController.getString("SetColor", R.string.SetColor), null, LocaleController.getString("ChatSettings", R.string.ChatSettings), LocaleController.getString("ChatBackground", R.string.ChatBackground), R.drawable.menu_chats, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$cCwJkdT6C39FlVD-Oc4rQLDXwUI
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$51$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[52] = new SearchResult(this, 305, LocaleController.getString("AutoNightTheme", R.string.AutoNightTheme), LocaleController.getString("ChatSettings", R.string.ChatSettings), R.drawable.menu_chats, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$75JfxeyPsnXOI0CArEGsF5LJ66A
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$52$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[53] = new SearchResult(this, 306, LocaleController.getString("ColorTheme", R.string.ColorTheme), "themeHeaderRow", LocaleController.getString("ChatSettings", R.string.ChatSettings), R.drawable.menu_chats, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$uRM0QtLSPfNKvdNAblooYj3YgkI
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$53$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[54] = new SearchResult(this, 307, LocaleController.getString("ChromeCustomTabs", R.string.ChromeCustomTabs), "customTabsRow", LocaleController.getString("ChatSettings", R.string.ChatSettings), R.drawable.menu_chats, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$NAdiWpy1FKOBbRmkKk5jaPxSaTk
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$54$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[55] = new SearchResult(this, 308, LocaleController.getString("DirectShare", R.string.DirectShare), "directShareRow", LocaleController.getString("ChatSettings", R.string.ChatSettings), R.drawable.menu_chats, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$xFtAVT7ib8kxPkZAhmQrNo-J0cM
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$55$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[56] = new SearchResult(this, 309, LocaleController.getString("EnableAnimations", R.string.EnableAnimations), "enableAnimationsRow", LocaleController.getString("ChatSettings", R.string.ChatSettings), R.drawable.menu_chats, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$TCBew2tOsAoxQ3Skoev_1gzwSNk
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$56$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[57] = new SearchResult(this, 310, LocaleController.getString("RaiseToSpeak", R.string.RaiseToSpeak), "raiseToSpeakRow", LocaleController.getString("ChatSettings", R.string.ChatSettings), R.drawable.menu_chats, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$wL0G3oHvB9FpWkxNCHCqjyYeOkg
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$57$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[58] = new SearchResult(this, 311, LocaleController.getString("SendByEnter", R.string.SendByEnter), "sendByEnterRow", LocaleController.getString("ChatSettings", R.string.ChatSettings), R.drawable.menu_chats, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$Gl83M7Qtsxly0Zqm_Ar1Vh6qTwc
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$58$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[59] = new SearchResult(this, 312, LocaleController.getString("SaveToGallerySettings", R.string.SaveToGallerySettings), "saveToGalleryRow", LocaleController.getString("ChatSettings", R.string.ChatSettings), R.drawable.menu_chats, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$k8ozY1T1_cP8FwS79m-_pP79SIc
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$59$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[60] = new SearchResult(this, 318, LocaleController.getString("DistanceUnits", R.string.DistanceUnits), "distanceRow", LocaleController.getString("ChatSettings", R.string.ChatSettings), R.drawable.menu_chats, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$vISbr06yEdcSsbD0pYeNH8H0VYI
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$60$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[61] = new SearchResult(this, 319, LocaleController.getString("Font", R.string.Font), "fontRow", LocaleController.getString("ChatSettings", R.string.ChatSettings), R.drawable.menu_chats, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$nyCo7a452ZRqWSLulNspO_8PtqM
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$61$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[62] = new SearchResult(this, 320, LocaleController.getString("ProximitySensor", R.string.ProximitySensor), "proximitySensorRow", LocaleController.getString("ChatSettings", R.string.ChatSettings), R.drawable.menu_chats, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$_gQ1PRelzq0TyLo_RPcLqpdf4OE
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$62$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[63] = new SearchResult(this, 320, LocaleController.getString("FoldersVisibility", R.string.FoldersVisibility), LocaleController.getString("Filters", R.string.Filters), R.drawable.menu_folders, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$BSKqkSzHBuwYJVYoNGh57jjkaL0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$63$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[64] = new SearchResult(this, 320, LocaleController.getString("ResetAllFolders", R.string.ResetAllFolders), LocaleController.getString("Filters", R.string.Filters), R.drawable.menu_folders, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$WYfttKu7QBsih-bZgQX-eKSO4pc
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$64$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[65] = new SearchResult(this, 400, LocaleController.getString("Language", R.string.Language), R.drawable.menu_language, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$XwiIY34WCXVN_yzI0epEGqseh9Q
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$65$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[66] = new SearchResult(this, 402, LocaleController.getString("AskAQuestion", R.string.AskAQuestion), LocaleController.getString("SettingsHelp", R.string.SettingsHelp), R.drawable.menu_help, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$NTbMp4EQPsvfFnFIGJfwCOS9bqY
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$66$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[67] = new SearchResult(this, 403, LocaleController.getString("EitaaFAQ", R.string.EitaaFAQ), LocaleController.getString("SettingsHelp", R.string.SettingsHelp), R.drawable.menu_help, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$oKMLBCnnWYhQRTdQzLzIHdYdluc
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$67$ProfileActivity$SearchAdapter();
                }
            });
            searchResultArr[68] = new SearchResult(this, 404, LocaleController.getString("PrivacyPolicy", R.string.PrivacyPolicy), LocaleController.getString("SettingsHelp", R.string.SettingsHelp), R.drawable.menu_help, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$a9jRTj9_BAAqe_-JTPtCVH2ozdU
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$68$ProfileActivity$SearchAdapter();
                }
            });
            this.searchArray = searchResultArr;
            this.faqSearchArray = new ArrayList<>();
            this.resultNames = new ArrayList<>();
            this.searchResults = new ArrayList<>();
            this.faqSearchResults = new ArrayList<>();
            this.recentSearches = new ArrayList<>();
            this.mContext = context;
            HashMap map = new HashMap();
            int i = 0;
            while (true) {
                SearchResult[] searchResultArr2 = this.searchArray;
                if (i >= searchResultArr2.length) {
                    break;
                }
                if (searchResultArr2[i] != null) {
                    map.put(Integer.valueOf(searchResultArr2[i].guid), this.searchArray[i]);
                }
                i++;
            }
            Set<String> stringSet = MessagesController.getGlobalMainSettings().getStringSet("settingsSearchRecent2", null);
            if (stringSet != null) {
                Iterator<String> it = stringSet.iterator();
                while (it.hasNext()) {
                    try {
                        SerializedData serializedData = new SerializedData(Utilities.hexToBytes(it.next()));
                        int int32 = serializedData.readInt32(false);
                        int int322 = serializedData.readInt32(false);
                        if (int322 == 0) {
                            String string = serializedData.readString(false);
                            int int323 = serializedData.readInt32(false);
                            if (int323 > 0) {
                                strArr = new String[int323];
                                for (int i2 = 0; i2 < int323; i2++) {
                                    strArr[i2] = serializedData.readString(false);
                                }
                            } else {
                                strArr = null;
                            }
                            MessagesController.FaqSearchResult faqSearchResult = new MessagesController.FaqSearchResult(string, strArr, serializedData.readString(false));
                            faqSearchResult.num = int32;
                            this.recentSearches.add(faqSearchResult);
                        } else if (int322 == 1 && (searchResult = (SearchResult) map.get(Integer.valueOf(serializedData.readInt32(false)))) != null) {
                            searchResult.num = int32;
                            this.recentSearches.add(searchResult);
                        }
                    } catch (Exception unused) {
                    }
                }
            }
            Collections.sort(this.recentSearches, new $$Lambda$ProfileActivity$SearchAdapter$AGCGLIs0hLv9ZJz80YINbAH65MI(this));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$69, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ int lambda$new$69$ProfileActivity$SearchAdapter(Object obj, Object obj2) {
            int num = getNum(obj);
            int num2 = getNum(obj2);
            if (num < num2) {
                return -1;
            }
            return num > num2 ? 1 : 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void loadFaqWebPage() {
            TLRPC$WebPage tLRPC$WebPage = ProfileActivity.this.getMessagesController().faqWebPage;
            this.faqWebPage = tLRPC$WebPage;
            if (tLRPC$WebPage != null) {
                this.faqSearchArray.addAll(ProfileActivity.this.getMessagesController().faqSearchArray);
            }
            if (this.faqWebPage != null || this.loadingFaqPage) {
                return;
            }
            this.loadingFaqPage = true;
            TLRPC$TL_messages_getWebPage tLRPC$TL_messages_getWebPage = new TLRPC$TL_messages_getWebPage();
            tLRPC$TL_messages_getWebPage.url = LocaleController.getString("EitaaFaqUrl", R.string.EitaaFaqUrl);
            tLRPC$TL_messages_getWebPage.hash = 0;
            ProfileActivity.this.getConnectionsManager().sendRequest(tLRPC$TL_messages_getWebPage, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$PAoWnc0ugnAXLgrmowmK1UzxR-k
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$loadFaqWebPage$71$ProfileActivity$SearchAdapter(tLObject, tLRPC$TL_error);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$loadFaqWebPage$71, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$loadFaqWebPage$71$ProfileActivity$SearchAdapter(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
            if (tLObject instanceof TLRPC$WebPage) {
                final ArrayList arrayList = new ArrayList();
                TLRPC$WebPage tLRPC$WebPage = (TLRPC$WebPage) tLObject;
                TLRPC$Page tLRPC$Page = tLRPC$WebPage.cached_page;
                if (tLRPC$Page != null) {
                    int size = tLRPC$Page.blocks.size();
                    for (int i = 0; i < size; i++) {
                        TLRPC$PageBlock tLRPC$PageBlock = tLRPC$WebPage.cached_page.blocks.get(i);
                        if (tLRPC$PageBlock instanceof TLRPC$TL_pageBlockList) {
                            String string = null;
                            if (i != 0) {
                                TLRPC$PageBlock tLRPC$PageBlock2 = tLRPC$WebPage.cached_page.blocks.get(i - 1);
                                if (tLRPC$PageBlock2 instanceof TLRPC$TL_pageBlockParagraph) {
                                    string = ArticleViewer.getPlainText(((TLRPC$TL_pageBlockParagraph) tLRPC$PageBlock2).text).toString();
                                }
                            }
                            TLRPC$TL_pageBlockList tLRPC$TL_pageBlockList = (TLRPC$TL_pageBlockList) tLRPC$PageBlock;
                            int size2 = tLRPC$TL_pageBlockList.items.size();
                            for (int i2 = 0; i2 < size2; i2++) {
                                TLRPC$PageListItem tLRPC$PageListItem = tLRPC$TL_pageBlockList.items.get(i2);
                                if (tLRPC$PageListItem instanceof TLRPC$TL_pageListItemText) {
                                    TLRPC$TL_pageListItemText tLRPC$TL_pageListItemText = (TLRPC$TL_pageListItemText) tLRPC$PageListItem;
                                    String url = ArticleViewer.getUrl(tLRPC$TL_pageListItemText.text);
                                    String string2 = ArticleViewer.getPlainText(tLRPC$TL_pageListItemText.text).toString();
                                    if (!TextUtils.isEmpty(url) && !TextUtils.isEmpty(string2)) {
                                        arrayList.add(new MessagesController.FaqSearchResult(string2, string != null ? new String[]{LocaleController.getString("SettingsSearchFaq", R.string.SettingsSearchFaq), string} : new String[]{LocaleController.getString("SettingsSearchFaq", R.string.SettingsSearchFaq)}, url));
                                    }
                                }
                            }
                        } else if (tLRPC$PageBlock instanceof TLRPC$TL_pageBlockAnchor) {
                            break;
                        }
                    }
                    this.faqWebPage = tLRPC$WebPage;
                }
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$ztbd_awNRWxU8cxyS83C2wrVnP4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$loadFaqWebPage$70$ProfileActivity$SearchAdapter(arrayList);
                    }
                });
            }
            this.loadingFaqPage = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$loadFaqWebPage$70, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$loadFaqWebPage$70$ProfileActivity$SearchAdapter(ArrayList arrayList) {
            this.faqSearchArray.addAll(arrayList);
            ProfileActivity.this.getMessagesController().faqSearchArray = arrayList;
            ProfileActivity.this.getMessagesController().faqWebPage = this.faqWebPage;
            if (this.searchWas) {
                return;
            }
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (this.searchWas) {
                return this.searchResults.size() + (this.faqSearchResults.isEmpty() ? 0 : this.faqSearchResults.size() + 1);
            }
            return (this.recentSearches.isEmpty() ? 0 : this.recentSearches.size() + 1) + (this.faqSearchArray.isEmpty() ? 0 : this.faqSearchArray.size() + 1);
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            return holder.getItemViewType() == 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            int itemViewType = holder.getItemViewType();
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    ((GraySectionCell) holder.itemView).setText(LocaleController.getString("SettingsFaqSearchTitle", R.string.SettingsFaqSearchTitle));
                    return;
                } else {
                    if (itemViewType != 2) {
                        return;
                    }
                    ((HeaderCell) holder.itemView).setText(LocaleController.getString("SettingsRecent", R.string.SettingsRecent));
                    return;
                }
            }
            SettingsSearchCell settingsSearchCell = (SettingsSearchCell) holder.itemView;
            if (this.searchWas) {
                if (position < this.searchResults.size()) {
                    SearchResult searchResult = this.searchResults.get(position);
                    SearchResult searchResult2 = position > 0 ? this.searchResults.get(position - 1) : null;
                    settingsSearchCell.setTextAndValueAndIcon(this.resultNames.get(position), searchResult.path, (searchResult2 == null || searchResult2.iconResId != searchResult.iconResId) ? searchResult.iconResId : 0, position < this.searchResults.size() - 1);
                    return;
                } else {
                    int size = position - (this.searchResults.size() + 1);
                    settingsSearchCell.setTextAndValue(this.resultNames.get(this.searchResults.size() + size), this.faqSearchResults.get(size).path, true, size < this.searchResults.size() - 1);
                    return;
                }
            }
            if (!this.recentSearches.isEmpty()) {
                position--;
            }
            if (position < this.recentSearches.size()) {
                Object obj = this.recentSearches.get(position);
                if (obj instanceof SearchResult) {
                    SearchResult searchResult3 = (SearchResult) obj;
                    settingsSearchCell.setTextAndValue(searchResult3.searchTitle, searchResult3.path, false, position < this.recentSearches.size() - 1);
                    return;
                } else {
                    if (obj instanceof MessagesController.FaqSearchResult) {
                        MessagesController.FaqSearchResult faqSearchResult = (MessagesController.FaqSearchResult) obj;
                        settingsSearchCell.setTextAndValue(faqSearchResult.title, faqSearchResult.path, true, position < this.recentSearches.size() - 1);
                        return;
                    }
                    return;
                }
            }
            int size2 = position - (this.recentSearches.size() + 1);
            MessagesController.FaqSearchResult faqSearchResult2 = this.faqSearchArray.get(size2);
            settingsSearchCell.setTextAndValue(faqSearchResult2.title, faqSearchResult2.path, true, size2 < this.recentSearches.size() - 1);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View settingsSearchCell;
            if (viewType == 0) {
                settingsSearchCell = new SettingsSearchCell(this.mContext);
            } else if (viewType == 1) {
                settingsSearchCell = new GraySectionCell(this.mContext);
            } else {
                settingsSearchCell = new HeaderCell(this.mContext, 16);
            }
            settingsSearchCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            return new RecyclerListView.Holder(settingsSearchCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            if (this.searchWas) {
                if (position >= this.searchResults.size() && position == this.searchResults.size()) {
                    return 1;
                }
            } else {
                if (position == 0) {
                    return !this.recentSearches.isEmpty() ? 2 : 1;
                }
                if (!this.recentSearches.isEmpty() && position == this.recentSearches.size() + 1) {
                    return 1;
                }
            }
            return 0;
        }

        public void addRecent(Object object) {
            int iIndexOf = this.recentSearches.indexOf(object);
            if (iIndexOf >= 0) {
                this.recentSearches.remove(iIndexOf);
            }
            this.recentSearches.add(0, object);
            if (!this.searchWas) {
                notifyDataSetChanged();
            }
            if (this.recentSearches.size() > 20) {
                this.recentSearches.remove(r5.size() - 1);
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int size = this.recentSearches.size();
            for (int i = 0; i < size; i++) {
                Object obj = this.recentSearches.get(i);
                if (obj instanceof SearchResult) {
                    ((SearchResult) obj).num = i;
                } else if (obj instanceof MessagesController.FaqSearchResult) {
                    ((MessagesController.FaqSearchResult) obj).num = i;
                }
                linkedHashSet.add(obj.toString());
            }
            MessagesController.getGlobalMainSettings().edit().putStringSet("settingsSearchRecent2", linkedHashSet).commit();
        }

        public void clearRecent() {
            this.recentSearches.clear();
            MessagesController.getGlobalMainSettings().edit().remove("settingsSearchRecent2").commit();
            notifyDataSetChanged();
        }

        private int getNum(Object o) {
            if (o instanceof SearchResult) {
                return ((SearchResult) o).num;
            }
            if (o instanceof MessagesController.FaqSearchResult) {
                return ((MessagesController.FaqSearchResult) o).num;
            }
            return 0;
        }

        public void search(final String text) throws InterruptedException {
            this.lastSearchString = text;
            if (this.searchRunnable != null) {
                Utilities.searchQueue.cancelRunnable(this.searchRunnable);
                this.searchRunnable = null;
            }
            if (TextUtils.isEmpty(text)) {
                this.searchWas = false;
                this.searchResults.clear();
                this.searchResults.clear();
                this.faqSearchResults.clear();
                this.resultNames.clear();
                ProfileActivity.this.emptyView.stickerView.getImageReceiver().startAnimation();
                ProfileActivity.this.emptyView.title.setText(LocaleController.getString("SettingsNoRecent", R.string.SettingsNoRecent));
                notifyDataSetChanged();
                return;
            }
            DispatchQueue dispatchQueue = Utilities.searchQueue;
            Runnable runnable = new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$SearchAdapter$EY5td8CjAOVx0QFRs0NmUj1Mak0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$search$73$ProfileActivity$SearchAdapter(text);
                }
            };
            this.searchRunnable = runnable;
            dispatchQueue.postRunnable(runnable, 300L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:45:0x00ef  */
        /* renamed from: lambda$search$73, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public /* synthetic */ void lambda$search$73$ProfileActivity$SearchAdapter(final java.lang.String r20) {
            /*
                Method dump skipped, instructions count: 458
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ProfileActivity.SearchAdapter.lambda$search$73$ProfileActivity$SearchAdapter(java.lang.String):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$search$72, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$search$72$ProfileActivity$SearchAdapter(String str, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3) {
            if (str.equals(this.lastSearchString)) {
                if (!this.searchWas) {
                    ProfileActivity.this.emptyView.stickerView.getImageReceiver().startAnimation();
                    ProfileActivity.this.emptyView.title.setText(LocaleController.getString("SettingsNoResults", R.string.SettingsNoResults));
                }
                this.searchWas = true;
                this.searchResults = arrayList;
                this.faqSearchResults = arrayList2;
                this.resultNames = arrayList3;
                notifyDataSetChanged();
                ProfileActivity.this.emptyView.stickerView.getImageReceiver().startAnimation();
            }
        }

        public boolean isSearchWas() {
            return this.searchWas;
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ProfileActivity$iH554eadL96ncIeXwrhdcOS-Qc4
            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() {
                this.f$0.lambda$getThemeDescriptions$37$ProfileActivity();
            }

            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public /* synthetic */ void onAnimationProgress(float f) {
                ThemeDescription.ThemeDescriptionDelegate.CC.$default$onAnimationProgress(this, f);
            }
        };
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        SharedMediaLayout sharedMediaLayout = this.sharedMediaLayout;
        if (sharedMediaLayout != null) {
            arrayList.addAll(sharedMediaLayout.getThemeDescriptions());
        }
        arrayList.add(new ThemeDescription(this.listView, 0, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.searchListView, 0, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.listView, 0, null, null, null, null, "windowBackgroundGray"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SUBMENUBACKGROUND, null, null, null, null, "actionBarDefaultSubmenuBackground"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SUBMENUITEM, null, null, null, null, "actionBarDefaultSubmenuItem"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SUBMENUITEM | ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, "actionBarDefaultSubmenuItemIcon"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "actionBarDefaultIcon"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_actionBarSelectorBlue"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "chat_lockIcon"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_subtitleInProfileBlue"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundActionBarBlue"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "profile_title"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "profile_status"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_subtitleInProfileBlue"));
        if (this.mediaCounterTextView != null) {
            arrayList.add(new ThemeDescription(this.mediaCounterTextView.getTextView(), ThemeDescription.FLAG_TEXTCOLOR, null, null, null, themeDescriptionDelegate, "player_actionBarSubtitle"));
            arrayList.add(new ThemeDescription(this.mediaCounterTextView.getNextTextView(), ThemeDescription.FLAG_TEXTCOLOR, null, null, null, themeDescriptionDelegate, "player_actionBarSubtitle"));
        }
        arrayList.add(new ThemeDescription(this.topView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "avatar_backgroundActionBarBlue"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, "divider"));
        arrayList.add(new ThemeDescription(this.avatarImage, 0, null, null, Theme.avatarDrawables, null, "avatar_text"));
        arrayList.add(new ThemeDescription(this.avatarImage, 0, null, null, new Drawable[]{this.avatarDrawable}, null, "avatar_backgroundInProfileBlue"));
        arrayList.add(new ThemeDescription(this.writeButton, ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, "profile_actionIcon"));
        arrayList.add(new ThemeDescription(this.writeButton, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "profile_actionBackground"));
        arrayList.add(new ThemeDescription(this.writeButton, ThemeDescription.FLAG_DRAWABLESELECTEDSTATE | ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "profile_actionPressedBackground"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGreenText2"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteRedText5"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueText2"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueButton"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteValueText"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayIcon"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueIcon"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextDetailCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextDetailCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText2"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueHeader"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{SettingsSuggestionCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueHeader"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{SettingsSuggestionCell.class}, new String[]{"detailTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText2"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LINKCOLOR, new Class[]{SettingsSuggestionCell.class}, new String[]{"detailTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteLinkText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{SettingsSuggestionCell.class}, new String[]{"yesButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "featuredStickers_buttonText"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_USEBACKGROUNDDRAWABLE, new Class[]{SettingsSuggestionCell.class}, new String[]{"yesButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "featuredStickers_addButton"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_USEBACKGROUNDDRAWABLE | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, new Class[]{SettingsSuggestionCell.class}, new String[]{"yesButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "featuredStickers_addButtonPressed"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{SettingsSuggestionCell.class}, new String[]{"noButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "featuredStickers_buttonText"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_USEBACKGROUNDDRAWABLE, new Class[]{SettingsSuggestionCell.class}, new String[]{"noButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "featuredStickers_addButton"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_USEBACKGROUNDDRAWABLE | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, new Class[]{SettingsSuggestionCell.class}, new String[]{"noButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "featuredStickers_addButtonPressed"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{NotificationsCheckCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{NotificationsCheckCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText2"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{NotificationsCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "switchTrack"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{NotificationsCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "switchTrackChecked"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{UserCell.class}, new String[]{"adminTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "profile_creatorIcon"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{UserCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayIcon"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{UserCell.class}, new String[]{"nameTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{UserCell.class}, new String[]{"statusColor"}, (Paint[]) null, (Drawable[]) null, themeDescriptionDelegate, "windowBackgroundWhiteGrayText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{UserCell.class}, new String[]{"statusOnlineColor"}, (Paint[]) null, (Drawable[]) null, themeDescriptionDelegate, "windowBackgroundWhiteBlueText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{UserCell.class}, null, Theme.avatarDrawables, null, "avatar_text"));
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
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{AboutLinkCell.class}, Theme.profile_aboutTextPaint, null, null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LINKCOLOR, new Class[]{AboutLinkCell.class}, Theme.profile_aboutTextPaint, null, null, "windowBackgroundWhiteLinkText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{AboutLinkCell.class}, Theme.linkSelectionPaint, null, null, "windowBackgroundWhiteLinkSelection"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ShadowSectionCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText4"));
        arrayList.add(new ThemeDescription(this.searchListView, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueHeader"));
        arrayList.add(new ThemeDescription(this.searchListView, 0, new Class[]{GraySectionCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "key_graySectionText"));
        arrayList.add(new ThemeDescription(this.searchListView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{GraySectionCell.class}, null, null, null, "graySection"));
        arrayList.add(new ThemeDescription(this.searchListView, 0, new Class[]{SettingsSearchCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.searchListView, 0, new Class[]{SettingsSearchCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText2"));
        arrayList.add(new ThemeDescription(this.searchListView, 0, new Class[]{SettingsSearchCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayIcon"));
        if (this.mediaHeaderVisible) {
            arrayList.add(new ThemeDescription(this.nameTextView[1], 0, null, null, new Drawable[]{this.verifiedCheckDrawable}, null, "player_actionBarTitle"));
            arrayList.add(new ThemeDescription(this.nameTextView[1], 0, null, null, new Drawable[]{this.verifiedDrawable}, null, "windowBackgroundWhite"));
        } else {
            arrayList.add(new ThemeDescription(this.nameTextView[1], 0, null, null, new Drawable[]{this.verifiedCheckDrawable}, null, "profile_verifiedCheck"));
            arrayList.add(new ThemeDescription(this.nameTextView[1], 0, null, null, new Drawable[]{this.verifiedDrawable}, null, "profile_verifiedBackground"));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getThemeDescriptions$37, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getThemeDescriptions$37$ProfileActivity() {
        RecyclerListView recyclerListView = this.listView;
        if (recyclerListView != null) {
            int childCount = recyclerListView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.listView.getChildAt(i);
                if (childAt instanceof UserCell) {
                    ((UserCell) childAt).update(0);
                }
            }
        }
        if (this.isPulledDown) {
            return;
        }
        SimpleTextView[] simpleTextViewArr = this.onlineTextView;
        if (simpleTextViewArr[1] != null) {
            Object tag = simpleTextViewArr[1].getTag();
            if (tag instanceof String) {
                this.onlineTextView[1].setTextColor(Theme.getColor((String) tag));
            } else {
                this.onlineTextView[1].setTextColor(Theme.getColor("avatar_subtitleInProfileBlue"));
            }
        }
        Drawable drawable = this.lockIconDrawable;
        if (drawable != null) {
            drawable.setColorFilter(Theme.getColor("chat_lockIcon"), PorterDuff.Mode.MULTIPLY);
        }
        ScamDrawable scamDrawable = this.scamDrawable;
        if (scamDrawable != null) {
            scamDrawable.setColor(Theme.getColor("avatar_subtitleInProfileBlue"));
        }
        SimpleTextView[] simpleTextViewArr2 = this.nameTextView;
        if (simpleTextViewArr2[1] != null) {
            simpleTextViewArr2[1].setTextColor(Theme.getColor("profile_title"));
        }
        ActionBar actionBar = this.actionBar;
        if (actionBar != null) {
            actionBar.setItemsColor(Theme.getColor("actionBarDefaultIcon"), false);
            this.actionBar.setItemsBackgroundColor(Theme.getColor("avatar_actionBarSelectorBlue"), false);
        }
    }

    public void updateListAnimated(boolean updateOnlineCount) {
        if (this.listAdapter == null) {
            if (updateOnlineCount) {
                updateOnlineCount(false);
            }
            updateRowsIds();
            return;
        }
        DiffCallback diffCallback = new DiffCallback();
        diffCallback.oldRowCount = this.rowCount;
        diffCallback.fillPositions(diffCallback.oldPositionToItem);
        diffCallback.oldChatParticipant.clear();
        diffCallback.oldChatParticipantSorted.clear();
        diffCallback.oldChatParticipant.addAll(this.visibleChatParticipants);
        diffCallback.oldChatParticipantSorted.addAll(this.visibleSortedUsers);
        diffCallback.oldMembersStartRow = this.membersStartRow;
        diffCallback.oldMembersEndRow = this.membersEndRow;
        if (updateOnlineCount) {
            updateOnlineCount(false);
        }
        saveScrollPosition();
        updateRowsIds();
        diffCallback.fillPositions(diffCallback.newPositionToItem);
        DiffUtil.calculateDiff(diffCallback).dispatchUpdatesTo(this.listAdapter);
        int i = this.savedScrollPosition;
        if (i >= 0) {
            this.layoutManager.scrollToPositionWithOffset(i, this.savedScrollOffset - this.listView.getPaddingTop());
        }
        AndroidUtilities.updateVisibleRows(this.listView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveScrollPosition() {
        RecyclerListView recyclerListView = this.listView;
        if (recyclerListView == null || this.layoutManager == null || recyclerListView.getChildCount() <= 0) {
            return;
        }
        View view = null;
        int top = ConnectionsManager.DEFAULT_DATACENTER_ID;
        int i = -1;
        for (int i2 = 0; i2 < this.listView.getChildCount(); i2++) {
            RecyclerListView recyclerListView2 = this.listView;
            int childAdapterPosition = recyclerListView2.getChildAdapterPosition(recyclerListView2.getChildAt(i2));
            View childAt = this.listView.getChildAt(i2);
            if (childAdapterPosition != -1 && childAt.getTop() < top) {
                top = childAt.getTop();
                i = childAdapterPosition;
                view = childAt;
            }
        }
        if (view != null) {
            this.savedScrollPosition = i;
            int top2 = view.getTop();
            this.savedScrollOffset = top2;
            if (this.savedScrollPosition == 0 && !this.allowPullingDown && top2 > AndroidUtilities.dp(88.0f)) {
                this.savedScrollOffset = AndroidUtilities.dp(88.0f);
            }
            this.layoutManager.scrollToPositionWithOffset(i, view.getTop() - this.listView.getPaddingTop());
        }
    }

    public void scrollToSharedMedia() {
        this.layoutManager.scrollToPositionWithOffset(this.sharedMediaRow, -this.listView.getPaddingTop());
    }

    private class DiffCallback extends DiffUtil.Callback {
        SparseIntArray newPositionToItem;
        ArrayList<TLRPC$ChatParticipant> oldChatParticipant;
        ArrayList<Integer> oldChatParticipantSorted;
        int oldMembersEndRow;
        int oldMembersStartRow;
        SparseIntArray oldPositionToItem;
        int oldRowCount;

        private DiffCallback() {
            this.oldPositionToItem = new SparseIntArray();
            this.newPositionToItem = new SparseIntArray();
            this.oldChatParticipant = new ArrayList<>();
            this.oldChatParticipantSorted = new ArrayList<>();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getOldListSize() {
            return this.oldRowCount;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getNewListSize() {
            return ProfileActivity.this.rowCount;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            TLRPC$ChatParticipant tLRPC$ChatParticipant;
            if (newItemPosition >= ProfileActivity.this.membersStartRow && newItemPosition < ProfileActivity.this.membersEndRow && oldItemPosition >= this.oldMembersStartRow && oldItemPosition < this.oldMembersEndRow) {
                if (!this.oldChatParticipantSorted.isEmpty()) {
                    tLRPC$ChatParticipant = this.oldChatParticipant.get(this.oldChatParticipantSorted.get(oldItemPosition - this.oldMembersStartRow).intValue());
                } else {
                    tLRPC$ChatParticipant = this.oldChatParticipant.get(oldItemPosition - this.oldMembersStartRow);
                }
                return tLRPC$ChatParticipant.user_id == (!ProfileActivity.this.sortedUsers.isEmpty() ? (TLRPC$ChatParticipant) ProfileActivity.this.visibleChatParticipants.get(((Integer) ProfileActivity.this.visibleSortedUsers.get(newItemPosition - ProfileActivity.this.membersStartRow)).intValue()) : (TLRPC$ChatParticipant) ProfileActivity.this.visibleChatParticipants.get(newItemPosition - ProfileActivity.this.membersStartRow)).user_id;
            }
            int i = this.oldPositionToItem.get(oldItemPosition, -1);
            return i == this.newPositionToItem.get(newItemPosition, -1) && i >= 0;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            return areItemsTheSame(oldItemPosition, newItemPosition);
        }

        public void fillPositions(SparseIntArray sparseIntArray) {
            sparseIntArray.clear();
            put(1, ProfileActivity.this.setAvatarRow, sparseIntArray);
            put(2, ProfileActivity.this.setAvatarSectionRow, sparseIntArray);
            put(3, ProfileActivity.this.numberSectionRow, sparseIntArray);
            put(4, ProfileActivity.this.numberRow, sparseIntArray);
            put(5, ProfileActivity.this.setUsernameRow, sparseIntArray);
            put(6, ProfileActivity.this.bioRow, sparseIntArray);
            put(7, ProfileActivity.this.phoneSuggestionRow, sparseIntArray);
            put(8, ProfileActivity.this.phoneSuggestionSectionRow, sparseIntArray);
            put(9, ProfileActivity.this.passwordSuggestionRow, sparseIntArray);
            put(10, ProfileActivity.this.passwordSuggestionSectionRow, sparseIntArray);
            put(11, ProfileActivity.this.settingsSectionRow, sparseIntArray);
            put(12, ProfileActivity.this.settingsSectionRow2, sparseIntArray);
            put(13, ProfileActivity.this.notificationRow, sparseIntArray);
            put(14, ProfileActivity.this.languageRow, sparseIntArray);
            put(15, ProfileActivity.this.privacyRow, sparseIntArray);
            put(16, ProfileActivity.this.dataRow, sparseIntArray);
            put(17, ProfileActivity.this.chatRow, sparseIntArray);
            put(18, ProfileActivity.this.filtersRow, sparseIntArray);
            put(19, ProfileActivity.this.devicesRow, sparseIntArray);
            put(20, ProfileActivity.this.devicesSectionRow, sparseIntArray);
            put(21, ProfileActivity.this.helpHeaderRow, sparseIntArray);
            put(22, ProfileActivity.this.questionRow, sparseIntArray);
            put(23, ProfileActivity.this.faqRow, sparseIntArray);
            put(24, ProfileActivity.this.policyRow, sparseIntArray);
            put(25, ProfileActivity.this.helpSectionCell, sparseIntArray);
            put(26, ProfileActivity.this.debugHeaderRow, sparseIntArray);
            put(27, ProfileActivity.this.sendLogsRow, sparseIntArray);
            put(28, ProfileActivity.this.sendLastLogsRow, sparseIntArray);
            put(29, ProfileActivity.this.clearLogsRow, sparseIntArray);
            put(30, ProfileActivity.this.switchBackendRow, sparseIntArray);
            put(31, ProfileActivity.this.versionRow, sparseIntArray);
            put(32, ProfileActivity.this.emptyRow, sparseIntArray);
            put(33, ProfileActivity.this.bottomPaddingRow, sparseIntArray);
            put(34, ProfileActivity.this.infoHeaderRow, sparseIntArray);
            put(35, ProfileActivity.this.phoneRow, sparseIntArray);
            put(36, ProfileActivity.this.locationRow, sparseIntArray);
            put(37, ProfileActivity.this.userInfoRow, sparseIntArray);
            put(38, ProfileActivity.this.channelInfoRow, sparseIntArray);
            put(39, ProfileActivity.this.usernameRow, sparseIntArray);
            put(40, ProfileActivity.this.notificationsDividerRow, sparseIntArray);
            put(41, ProfileActivity.this.notificationsRow, sparseIntArray);
            put(42, ProfileActivity.this.infoSectionRow, sparseIntArray);
            put(43, ProfileActivity.this.sendMessageRow, sparseIntArray);
            put(44, ProfileActivity.this.reportRow, sparseIntArray);
            put(45, ProfileActivity.this.settingsTimerRow, sparseIntArray);
            put(46, ProfileActivity.this.settingsKeyRow, sparseIntArray);
            put(47, ProfileActivity.this.secretSettingsSectionRow, sparseIntArray);
            put(48, ProfileActivity.this.membersHeaderRow, sparseIntArray);
            put(49, ProfileActivity.this.addMemberRow, sparseIntArray);
            put(50, ProfileActivity.this.subscribersRow, sparseIntArray);
            put(51, ProfileActivity.this.administratorsRow, sparseIntArray);
            put(52, ProfileActivity.this.blockedUsersRow, sparseIntArray);
            put(53, ProfileActivity.this.membersSectionRow, sparseIntArray);
            put(54, ProfileActivity.this.sharedMediaRow, sparseIntArray);
            put(55, ProfileActivity.this.unblockRow, sparseIntArray);
            put(56, ProfileActivity.this.joinRow, sparseIntArray);
            put(57, ProfileActivity.this.lastSectionRow, sparseIntArray);
        }

        private void put(int id, int position, SparseIntArray sparseIntArray) {
            if (position >= 0) {
                sparseIntArray.put(position, id);
            }
        }
    }
}
