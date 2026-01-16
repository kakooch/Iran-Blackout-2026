package org.rbmain.ui;

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
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Property;
import android.util.SparseArray;
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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidMessenger.proxy.IdStorage;
import androidMessenger.utilites.AppFavorUtils;
import androidx.annotation.Keep;
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
import com.facebook.stetho.server.http.HttpStatus;
import com.facebook.stetho.websocket.CloseCodes;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.aaap.messengercore.LoadListener;
import ir.aaap.messengercore.model.SettingItem2;
import ir.aaap.messengercore.model.api.GetProfileLinkItemsOutputs;
import ir.aaap.messengercore.model.api.ProfileLinkItemObject;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.FirebaseEventSender;
import ir.resaneh1.iptv.model.ChildLockCheck;
import ir.resaneh1.iptv.model.RubinoProfileObject;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import java.io.File;
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
import org.rbmain.PhoneFormat.PhoneFormat;
import org.rbmain.messenger.AccountInstance;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.ChatObject;
import org.rbmain.messenger.ContactsController;
import org.rbmain.messenger.FileLoader;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.ImageLoader;
import org.rbmain.messenger.ImageLocation;
import org.rbmain.messenger.ImageReceiver;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MediaController;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.MessagesStorage;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.NotificationsSettingsFacade;
import org.rbmain.messenger.SharedConfig;
import org.rbmain.messenger.UserConfig;
import org.rbmain.messenger.UserObject;
import org.rbmain.messenger.Utilities;
import org.rbmain.messenger.browser.Browser;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.SerializedData;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$BotInfo;
import org.rbmain.tgnet.TLRPC$ChannelLocation;
import org.rbmain.tgnet.TLRPC$ChannelParticipant;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$ChatFull;
import org.rbmain.tgnet.TLRPC$ChatParticipant;
import org.rbmain.tgnet.TLRPC$ChatParticipants;
import org.rbmain.tgnet.TLRPC$ChatPhoto;
import org.rbmain.tgnet.TLRPC$DecryptedMessageAction;
import org.rbmain.tgnet.TLRPC$Dialog;
import org.rbmain.tgnet.TLRPC$EncryptedChat;
import org.rbmain.tgnet.TLRPC$FileLocation;
import org.rbmain.tgnet.TLRPC$InputFile;
import org.rbmain.tgnet.TLRPC$MessageAction;
import org.rbmain.tgnet.TLRPC$MessageEntity;
import org.rbmain.tgnet.TLRPC$Page;
import org.rbmain.tgnet.TLRPC$PageBlock;
import org.rbmain.tgnet.TLRPC$PageListItem;
import org.rbmain.tgnet.TLRPC$Peer;
import org.rbmain.tgnet.TLRPC$Photo;
import org.rbmain.tgnet.TLRPC$PhotoSize;
import org.rbmain.tgnet.TLRPC$ReplyMarkup;
import org.rbmain.tgnet.TLRPC$TL_channelFull;
import org.rbmain.tgnet.TLRPC$TL_channelLocation;
import org.rbmain.tgnet.TLRPC$TL_channelParticipant;
import org.rbmain.tgnet.TLRPC$TL_channelParticipantAdmin;
import org.rbmain.tgnet.TLRPC$TL_channelParticipantCreator;
import org.rbmain.tgnet.TLRPC$TL_channelParticipantsRecent;
import org.rbmain.tgnet.TLRPC$TL_channels_channelParticipant;
import org.rbmain.tgnet.TLRPC$TL_channels_channelParticipants;
import org.rbmain.tgnet.TLRPC$TL_channels_getParticipant;
import org.rbmain.tgnet.TLRPC$TL_channels_getParticipants;
import org.rbmain.tgnet.TLRPC$TL_chatAdminRights;
import org.rbmain.tgnet.TLRPC$TL_chatBannedRights;
import org.rbmain.tgnet.TLRPC$TL_chatChannelParticipant;
import org.rbmain.tgnet.TLRPC$TL_chatFull;
import org.rbmain.tgnet.TLRPC$TL_chatParticipant;
import org.rbmain.tgnet.TLRPC$TL_chatParticipantAdmin;
import org.rbmain.tgnet.TLRPC$TL_chatParticipantCreator;
import org.rbmain.tgnet.TLRPC$TL_chatParticipants;
import org.rbmain.tgnet.TLRPC$TL_decryptedMessageActionSetMessageTTL;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_inputGroupCall;
import org.rbmain.tgnet.TLRPC$TL_inputPhoto;
import org.rbmain.tgnet.TLRPC$TL_messageEncryptedAction;
import org.rbmain.tgnet.TLRPC$TL_messages_getWebPage;
import org.rbmain.tgnet.TLRPC$TL_pageBlockAnchor;
import org.rbmain.tgnet.TLRPC$TL_pageBlockList;
import org.rbmain.tgnet.TLRPC$TL_pageBlockParagraph;
import org.rbmain.tgnet.TLRPC$TL_pageListItemText;
import org.rbmain.tgnet.TLRPC$TL_peerNotifySettings;
import org.rbmain.tgnet.TLRPC$TL_peerUser;
import org.rbmain.tgnet.TLRPC$TL_photo;
import org.rbmain.tgnet.TLRPC$TL_photos_photo;
import org.rbmain.tgnet.TLRPC$TL_photos_updateProfilePhoto;
import org.rbmain.tgnet.TLRPC$TL_photos_uploadProfilePhoto;
import org.rbmain.tgnet.TLRPC$TL_userEmpty;
import org.rbmain.tgnet.TLRPC$TL_userProfilePhoto;
import org.rbmain.tgnet.TLRPC$TL_userProfilePhotoEmpty;
import org.rbmain.tgnet.TLRPC$Tl_settings_parts;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.tgnet.TLRPC$UserFull;
import org.rbmain.tgnet.TLRPC$UserProfilePhoto;
import org.rbmain.tgnet.TLRPC$UserStatus;
import org.rbmain.tgnet.TLRPC$VideoSize;
import org.rbmain.tgnet.TLRPC$WebPage;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.ActionBarMenu;
import org.rbmain.ui.ActionBar.ActionBarMenuItem;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BackDrawable;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.SimpleTextView;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.Cells.AboutLinkCell;
import org.rbmain.ui.Cells.DividerCell;
import org.rbmain.ui.Cells.GraySectionCell;
import org.rbmain.ui.Cells.HeaderCell;
import org.rbmain.ui.Cells.NotificationsCheckCell;
import org.rbmain.ui.Cells.SettingsSearchCell;
import org.rbmain.ui.Cells.ShadowSectionCell;
import org.rbmain.ui.Cells.TextCell;
import org.rbmain.ui.Cells.TextDetailCell;
import org.rbmain.ui.Cells.TextInfoPrivacyCell;
import org.rbmain.ui.Cells.UserCell;
import org.rbmain.ui.ChatRightsEditActivity;
import org.rbmain.ui.Components.AlertsCreator;
import org.rbmain.ui.Components.AnimatedFileDrawable;
import org.rbmain.ui.Components.AnimationProperties;
import org.rbmain.ui.Components.AudioPlayerAlert;
import org.rbmain.ui.Components.AvatarDrawable;
import org.rbmain.ui.Components.BackupImageView;
import org.rbmain.ui.Components.BulletinFactory;
import org.rbmain.ui.Components.CombinedDrawable;
import org.rbmain.ui.Components.CrossfadeDrawable;
import org.rbmain.ui.Components.CubicBezierInterpolator;
import org.rbmain.ui.Components.FragmentContextView;
import org.rbmain.ui.Components.IdenticonDrawable;
import org.rbmain.ui.Components.ImageUpdater;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.ProfileGalleryView;
import org.rbmain.ui.Components.RLottieDrawable;
import org.rbmain.ui.Components.RLottieImageView;
import org.rbmain.ui.Components.RadialProgressView;
import org.rbmain.ui.Components.RecyclerListView;
import org.rbmain.ui.Components.ScamDrawable;
import org.rbmain.ui.Components.SharedMediaLayout;
import org.rbmain.ui.Components.StickerEmptyView;
import org.rbmain.ui.Components.TimerDrawable;
import org.rbmain.ui.Components.UndoView;
import org.rbmain.ui.Components.voip.VoIPHelper;
import org.rbmain.ui.DialogsActivity;
import org.rbmain.ui.GroupCreateActivity;
import org.rbmain.ui.PhotoViewer;
import org.rbmain.ui.PinchToZoomHelper;
import org.rbmain.ui.ProfileActivity;

/* loaded from: classes4.dex */
public class ProfileActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate, DialogsActivity.DialogsActivityDelegate, SharedMediaLayout.SharedMediaPreloaderDelegate, ImageUpdater.ImageUpdaterDelegate {
    private Property<ActionBar, Float> ACTIONBAR_HEADER_PROGRESS;
    private final Property<ProfileActivity, Float> HEADER_SHADOW;
    private int addMemberRow;
    private int administratorsRow;
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
    private int banFromGroup;
    private int bioRow;
    private int blockedUsersRow;
    private TLRPC$BotInfo botInfo;
    private int bottomPaddingRow;
    private ActionBarMenuItem callItem;
    private boolean callItemVisible;
    private RLottieDrawable cameraDrawable;
    private boolean canSearchMembers;
    private int channelInfoRow;
    private TLRPC$ChatFull chatInfo;
    private int chatRow;
    private int chat_id;
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
    private long dialog_id;
    private boolean doNotSetForeground;
    private ActionBarMenuItem editItem;
    private boolean editItemVisible;
    private int emptyRow;
    private int emptyRow2;
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
    private boolean hasRubino;
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
    private boolean isMyUser;
    private boolean isOneTimeCheckedItemLinks;
    private boolean isOneTimeCheckedRubino;
    private boolean[] isOnline;
    private boolean isPulledDown;
    int itemLinksEndRow;
    int itemLinksStartRow;
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
    private boolean needSendMessage;
    private String nextStartId;
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
    private int otherPartsEndRow;
    private int otherPartsStartRow;
    private int overlayCountVisible;
    private OverlaysView overlaysView;
    private SparseArray<TLRPC$ChatParticipant> participantsMap;
    private int phoneRow;
    PinchToZoomHelper pinchToZoomHelper;
    private int playProfileAnimation;
    private int policyRow;
    private HashMap<Integer, Integer> positionToOffset;
    private int privacyRow;
    private ArrayList<ProfileLinkItemObject> profileItems;
    boolean profileTransitionInProgress;
    private PhotoViewer.PhotoViewerProvider provider;
    private int questionRow;
    private boolean recreateMenuAfterAnimation;
    private Rect rect;
    private int reportRow;
    private boolean reportSpam;
    private int rowCount;
    private RubinoProfileObject rubinoProfile;
    private int rubinoRow;
    int savedScrollOffset;
    int savedScrollPosition;
    private ScamDrawable scamDrawable;
    private boolean scrolling;
    private SearchAdapter searchAdapter;
    private ActionBarMenuItem searchItem;
    private RecyclerListView searchListView;
    private boolean searchMode;
    private int searchTransitionOffset;
    private int secretSettingsSectionRow;
    private int selectedUser;
    private int sendLogsRow;
    private int sendMessageRow;
    private int setAvatarRow;
    private int setAvatarSectionRow;
    private int setUsernameRow;
    private int settingsKeyRow;
    private ArrayList<SettingItem2> settingsParts;
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
    private int unblockRow;
    private UndoView undoView;
    private ImageLocation uploadingImageLocation;
    private boolean userBlocked;
    private TLRPC$UserFull userInfo;
    private int userInfoRow;
    private int user_id;
    private int usernameRow;
    private boolean usersEndReached;
    private int usersForceShowingIn;
    private Drawable verifiedCheckDrawable;
    private CrossfadeDrawable verifiedCrossfadeDrawable;
    private Drawable verifiedDrawable;
    private int versionRow;
    private ActionBarMenuItem videoCallItem;
    private boolean videoCallItemVisible;
    private final ArrayList<TLRPC$ChatParticipant> visibleChatParticipants;
    private final ArrayList<Integer> visibleSortedUsers;
    private Paint whitePaint;
    private RLottieImageView writeButton;
    private AnimatorSet writeButtonAnimation;

    @Override // org.rbmain.ui.Components.ImageUpdater.ImageUpdaterDelegate
    public /* synthetic */ String getInitialSearchString() {
        return ImageUpdater.ImageUpdaterDelegate.CC.$default$getInitialSearchString(this);
    }

    static /* synthetic */ int access$7212(ProfileActivity profileActivity, int i) {
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

        public void setAvatarsViewPager(ProfileGalleryView profileGalleryView) {
            this.avatarsViewPager = profileGalleryView;
        }

        public AvatarImageView(Context context) {
            super(context);
            this.rect = new RectF();
            this.foregroundImageReceiver = new ImageReceiver(this);
            Paint paint = new Paint(1);
            this.placeholderPaint = paint;
            paint.setColor(-16777216);
        }

        public void setForegroundImage(ImageLocation imageLocation, String str, Drawable drawable) {
            this.foregroundImageReceiver.setImage(imageLocation, str, drawable, 0L, (String) null, (Object) null, 0);
            ImageReceiver.BitmapHolder bitmapHolder = this.drawableHolder;
            if (bitmapHolder != null) {
                bitmapHolder.release();
                this.drawableHolder = null;
            }
        }

        public void setForegroundImageDrawable(ImageReceiver.BitmapHolder bitmapHolder) {
            if (bitmapHolder != null) {
                this.foregroundImageReceiver.setImageBitmap(bitmapHolder.drawable);
            }
            ImageReceiver.BitmapHolder bitmapHolder2 = this.drawableHolder;
            if (bitmapHolder2 != null) {
                bitmapHolder2.release();
                this.drawableHolder = null;
            }
            this.drawableHolder = bitmapHolder;
        }

        public float getForegroundAlpha() {
            return this.foregroundAlpha;
        }

        public void setForegroundAlpha(float f) {
            this.foregroundAlpha = f;
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

        @Override // org.rbmain.ui.Components.BackupImageView, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            this.foregroundImageReceiver.onDetachedFromWindow();
            ImageReceiver.BitmapHolder bitmapHolder = this.drawableHolder;
            if (bitmapHolder != null) {
                bitmapHolder.release();
                this.drawableHolder = null;
            }
        }

        @Override // org.rbmain.ui.Components.BackupImageView, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            this.foregroundImageReceiver.onAttachedToWindow();
        }

        @Override // org.rbmain.ui.Components.BackupImageView
        public void setRoundRadius(int i) {
            super.setRoundRadius(i);
            this.foregroundImageReceiver.setRoundRadius(i);
        }

        @Override // org.rbmain.ui.Components.BackupImageView, android.view.View
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
        protected void onMeasure(int i, int i2) {
            setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i) + AndroidUtilities.dp(3.0f));
        }

        @Override // android.view.View
        public void setBackgroundColor(int i) {
            if (i != this.currentColor) {
                this.currentColor = i;
                this.paint.setColor(i);
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
                this.paint.setColor(Theme.getColor(Theme.key_windowBackgroundWhite));
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
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.ProfileActivity$OverlaysView$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f$0.lambda$new$0(valueAnimator);
                }
            });
            valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter(ProfileActivity.this) { // from class: org.rbmain.ui.ProfileActivity.OverlaysView.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (OverlaysView.this.isOverlaysVisible) {
                        return;
                    }
                    OverlaysView.this.setVisibility(8);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    OverlaysView.this.setVisibility(0);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0(ValueAnimator valueAnimator) {
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

        public void setAlphaValue(float f, boolean z) {
            if (Build.VERSION.SDK_INT > 18) {
                int i = (int) (255.0f * f);
                this.topOverlayGradient.setAlpha(i);
                this.bottomOverlayGradient.setAlpha(i);
                this.backgroundPaint.setAlpha((int) (66.0f * f));
                this.barPaint.setAlpha((int) (85.0f * f));
                this.selectedBarPaint.setAlpha(i);
                this.alpha = f;
            } else {
                setAlpha(f);
            }
            if (!z) {
                this.currentAnimationValue = f;
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

        public void setOverlaysVisible(boolean z, float f) {
            if (z != this.isOverlaysVisible) {
                this.isOverlaysVisible = z;
                this.animator.cancel();
                float fLerp = AndroidUtilities.lerp(this.animatorValues, this.currentAnimationValue);
                if (z) {
                    this.animator.setDuration((long) (((1.0f - fLerp) * 250.0f) / f));
                } else {
                    this.animator.setDuration((long) ((250.0f * fLerp) / f));
                }
                float[] fArr = this.animatorValues;
                fArr[0] = fLerp;
                fArr[1] = z ? 1.0f : 0.0f;
                this.animator.start();
            }
        }

        @Override // android.view.View
        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            int currentActionBarHeight = this.statusBarHeight + ActionBar.getCurrentActionBarHeight();
            this.topOverlayRect.set(0, 0, i, (int) (currentActionBarHeight * 0.5f));
            this.bottomOverlayRect.set(0, (int) (i2 - (AndroidUtilities.dp(72.0f) * 0.5f)), i, i2);
            this.topOverlayGradient.setBounds(0, this.topOverlayRect.bottom, i, currentActionBarHeight + AndroidUtilities.dp(16.0f));
            this.bottomOverlayGradient.setBounds(0, (i2 - AndroidUtilities.dp(72.0f)) - AndroidUtilities.dp(24.0f), i, this.bottomOverlayRect.top);
            int i5 = i / 5;
            this.pressedOverlayGradient[0].setBounds(0, 0, i5, i2);
            this.pressedOverlayGradient[1].setBounds(i - i5, 0, i, i2);
        }

        /* JADX WARN: Removed duplicated region for block: B:68:0x0222  */
        /* JADX WARN: Removed duplicated region for block: B:71:0x0247  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x025f  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x0262  */
        @Override // android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected void onDraw(android.graphics.Canvas r23) {
            /*
                Method dump skipped, instructions count: 815
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.ProfileActivity.OverlaysView.onDraw(android.graphics.Canvas):void");
        }

        @Override // org.rbmain.ui.Components.ProfileGalleryView.Callback
        public void onDown(boolean z) {
            this.pressedOverlayVisible[!z ? 1 : 0] = true;
            postInvalidateOnAnimation();
        }

        @Override // org.rbmain.ui.Components.ProfileGalleryView.Callback
        public void onRelease() {
            Arrays.fill(this.pressedOverlayVisible, false);
            postInvalidateOnAnimation();
        }

        @Override // org.rbmain.ui.Components.ProfileGalleryView.Callback
        public void onPhotosLoaded() {
            ProfileActivity.this.updateProfileData();
        }

        @Override // org.rbmain.ui.Components.ProfileGalleryView.Callback
        public void onVideoSet() {
            invalidate();
        }
    }

    private class NestedFrameLayout extends FrameLayout implements NestedScrollingParent3 {
        private NestedScrollingParentHelper nestedScrollingParentHelper;

        @Override // androidx.core.view.NestedScrollingParent2
        public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
        }

        @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
        public void onStopNestedScroll(View view) {
        }

        public NestedFrameLayout(Context context) {
            super(context);
            this.nestedScrollingParentHelper = new NestedScrollingParentHelper(this);
        }

        @Override // androidx.core.view.NestedScrollingParent3
        public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
            if (view == ProfileActivity.this.listView && ProfileActivity.this.sharedMediaLayoutAttached) {
                RecyclerListView currentListView = ProfileActivity.this.sharedMediaLayout.getCurrentListView();
                if (ProfileActivity.this.sharedMediaLayout.getTop() == 0) {
                    iArr[1] = i4;
                    currentListView.scrollBy(0, i4);
                }
            }
        }

        @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
        public boolean onNestedPreFling(View view, float f, float f2) {
            return super.onNestedPreFling(view, f, f2);
        }

        @Override // androidx.core.view.NestedScrollingParent2
        public void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
            if (view == ProfileActivity.this.listView) {
                if (ProfileActivity.this.sharedMediaRow == -1 || !ProfileActivity.this.sharedMediaLayoutAttached) {
                    return;
                }
                boolean zIsSearchFieldVisible = ((BaseFragment) ProfileActivity.this).actionBar.isSearchFieldVisible();
                int top = ProfileActivity.this.sharedMediaLayout.getTop();
                boolean z = false;
                if (i2 >= 0) {
                    if (zIsSearchFieldVisible) {
                        RecyclerListView currentListView = ProfileActivity.this.sharedMediaLayout.getCurrentListView();
                        iArr[1] = i2;
                        if (top > 0) {
                            iArr[1] = iArr[1] - Math.min(iArr[1], i2);
                        }
                        if (iArr[1] > 0) {
                            currentListView.scrollBy(0, iArr[1]);
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
                            iArr[1] = iFindFirstVisibleItemPosition != 0 ? i2 : Math.max(i2, top2 - paddingTop);
                            currentListView2.scrollBy(0, i2);
                            z = true;
                        }
                    }
                }
                if (zIsSearchFieldVisible) {
                    if (!z && top < 0) {
                        iArr[1] = i2 - Math.max(top, i2);
                    } else {
                        iArr[1] = i2;
                    }
                }
            }
        }

        @Override // androidx.core.view.NestedScrollingParent2
        public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
            return ProfileActivity.this.sharedMediaRow != -1 && i == 2;
        }

        @Override // androidx.core.view.NestedScrollingParent2
        public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
            this.nestedScrollingParentHelper.onNestedScrollAccepted(view, view2, i);
        }

        @Override // androidx.core.view.NestedScrollingParent2
        public void onStopNestedScroll(View view, int i) {
            this.nestedScrollingParentHelper.onStopNestedScroll(view);
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
            textPaint.setTypeface(Typeface.SANS_SERIF);
            textPaint.setTextAlign(Paint.Align.CENTER);
            textPaint.setTextSize(AndroidUtilities.dpf2(15.0f));
            Paint paint = new Paint(1);
            this.backgroundPaint = paint;
            paint.setColor(637534208);
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.animator = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setInterpolator(CubicBezierInterpolator.EASE_BOTH);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.ProfileActivity$PagerIndicatorView$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f$0.lambda$new$0(valueAnimator);
                }
            });
            valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter(ProfileActivity.this, ProfileActivity.this.expandPhoto) { // from class: org.rbmain.ui.ProfileActivity.PagerIndicatorView.1
                final /* synthetic */ boolean val$expanded;

                {
                    this.val$expanded = z;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
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
                public void onAnimationStart(Animator animator) {
                    if (ProfileActivity.this.searchItem != null && !this.val$expanded) {
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
            ProfileActivity.this.avatarsViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener(ProfileActivity.this) { // from class: org.rbmain.ui.ProfileActivity.PagerIndicatorView.2
                private int prevPage;

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrolled(int i, float f, int i2) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int i) {
                    int realPosition = ProfileActivity.this.avatarsViewPager.getRealPosition(i);
                    PagerIndicatorView.this.invalidateIndicatorRect(this.prevPage != realPosition);
                    this.prevPage = realPosition;
                    PagerIndicatorView.this.updateAvatarItems();
                }
            });
            adapter.registerDataSetObserver(new DataSetObserver(ProfileActivity.this) { // from class: org.rbmain.ui.ProfileActivity.PagerIndicatorView.3
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
        public /* synthetic */ void lambda$new$0(ValueAnimator valueAnimator) {
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
                ProfileActivity.this.otherItem.hideSubItem(33);
                ProfileActivity.this.otherItem.showSubItem(36);
            } else {
                ProfileActivity.this.otherItem.showSubItem(33);
                ProfileActivity.this.otherItem.hideSubItem(36);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateAvatarItems() {
            if (ProfileActivity.this.imageUpdater == null) {
                return;
            }
            if (ProfileActivity.this.otherItem.isSubMenuShowing()) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ProfileActivity$PagerIndicatorView$$ExternalSyntheticLambda1
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

        public void setIndicatorVisible(boolean z, float f) {
            if (z != this.isIndicatorVisible) {
                this.isIndicatorVisible = z;
                this.animator.cancel();
                float fLerp = AndroidUtilities.lerp(this.animatorValues, this.animator.getAnimatedFraction());
                if (f <= 0.0f) {
                    this.animator.setDuration(0L);
                } else if (z) {
                    this.animator.setDuration((long) (((1.0f - fLerp) * 250.0f) / f));
                } else {
                    this.animator.setDuration((long) ((250.0f * fLerp) / f));
                }
                float[] fArr = this.animatorValues;
                fArr[0] = fLerp;
                fArr[1] = z ? 1.0f : 0.0f;
                this.animator.start();
            }
        }

        public void refreshVisibility(float f) {
            setIndicatorVisible(ProfileActivity.this.isPulledDown && ProfileActivity.this.avatarsViewPager.getRealCount() > 20, f);
        }

        @Override // android.view.View
        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            invalidateIndicatorRect(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void invalidateIndicatorRect(boolean z) {
            if (z) {
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

    public ProfileActivity(Bundle bundle) {
        this(bundle, null);
    }

    public ProfileActivity(Bundle bundle, SharedMediaLayout.SharedMediaPreloader sharedMediaPreloader) {
        super(bundle);
        this.nameTextView = new SimpleTextView[2];
        this.onlineTextView = new SimpleTextView[2];
        this.isOnline = new boolean[1];
        this.headerShadowAlpha = 1.0f;
        this.participantsMap = new SparseArray<>();
        this.allowProfileAnimation = true;
        this.positionToOffset = new HashMap<>();
        this.profileItems = new ArrayList<>();
        this.expandAnimatorValues = new float[]{0.0f, 1.0f};
        this.whitePaint = new Paint();
        this.onlineCount = -1;
        this.rect = new Rect();
        this.itemLinksEndRow = -1;
        this.visibleChatParticipants = new ArrayList<>();
        this.visibleSortedUsers = new ArrayList<>();
        this.usersForceShowingIn = 0;
        this.firstLayout = true;
        this.invalidateScroll = true;
        this.HEADER_SHADOW = new AnimationProperties.FloatProperty<ProfileActivity>("headerShadow") { // from class: org.rbmain.ui.ProfileActivity.1
            @Override // org.rbmain.ui.Components.AnimationProperties.FloatProperty
            public void setValue(ProfileActivity profileActivity, float f) {
                ProfileActivity profileActivity2 = ProfileActivity.this;
                profileActivity2.headerShadowAlpha = f;
                profileActivity2.topView.invalidate();
            }

            @Override // android.util.Property
            public Float get(ProfileActivity profileActivity) {
                return Float.valueOf(ProfileActivity.this.headerShadowAlpha);
            }
        };
        this.provider = new PhotoViewer.EmptyPhotoViewerProvider() { // from class: org.rbmain.ui.ProfileActivity.2
            @Override // org.rbmain.ui.PhotoViewer.EmptyPhotoViewerProvider, org.rbmain.ui.PhotoViewer.PhotoViewerProvider
            public PhotoViewer.PlaceProviderObject getPlaceForPhoto(MessageObject messageObject, TLRPC$FileLocation tLRPC$FileLocation, int i, boolean z) {
                TLRPC$Chat chat;
                TLRPC$ChatPhoto tLRPC$ChatPhoto;
                TLRPC$FileLocation tLRPC$FileLocation2;
                TLRPC$User user;
                TLRPC$UserProfilePhoto tLRPC$UserProfilePhoto;
                if (tLRPC$FileLocation == null) {
                    return null;
                }
                if (ProfileActivity.this.user_id == 0 ? ProfileActivity.this.chat_id == 0 || (chat = ProfileActivity.this.getMessagesController().getChat(Integer.valueOf(ProfileActivity.this.chat_id))) == null || (tLRPC$ChatPhoto = chat.photo) == null || (tLRPC$FileLocation2 = tLRPC$ChatPhoto.photo_big) == null : (user = ProfileActivity.this.getMessagesController().getUser(Integer.valueOf(ProfileActivity.this.user_id))) == null || (tLRPC$UserProfilePhoto = user.photo) == null || (tLRPC$FileLocation2 = tLRPC$UserProfilePhoto.photo_big) == null) {
                    tLRPC$FileLocation2 = null;
                }
                if (tLRPC$FileLocation2 == null || tLRPC$FileLocation2.local_id != tLRPC$FileLocation.local_id || tLRPC$FileLocation2.volume_id != tLRPC$FileLocation.volume_id || tLRPC$FileLocation2.dc_id != tLRPC$FileLocation.dc_id) {
                    return null;
                }
                int[] iArr = new int[2];
                ProfileActivity.this.avatarImage.getLocationInWindow(iArr);
                PhotoViewer.PlaceProviderObject placeProviderObject = new PhotoViewer.PlaceProviderObject();
                placeProviderObject.viewX = iArr[0];
                placeProviderObject.viewY = iArr[1] - (Build.VERSION.SDK_INT >= 21 ? 0 : AndroidUtilities.statusBarHeight);
                placeProviderObject.parentView = ProfileActivity.this.avatarImage;
                placeProviderObject.imageReceiver = ProfileActivity.this.avatarImage.getImageReceiver();
                if (ProfileActivity.this.user_id != 0) {
                    placeProviderObject.dialogId = ProfileActivity.this.user_id;
                } else if (ProfileActivity.this.chat_id != 0) {
                    placeProviderObject.dialogId = -ProfileActivity.this.chat_id;
                }
                placeProviderObject.thumb = placeProviderObject.imageReceiver.getBitmapSafe();
                placeProviderObject.size = -1;
                placeProviderObject.radius = ProfileActivity.this.avatarImage.getImageReceiver().getRoundRadius();
                placeProviderObject.scale = ProfileActivity.this.avatarContainer.getScaleX();
                placeProviderObject.canEdit = ProfileActivity.this.user_id == ProfileActivity.this.getUserConfig().clientUserId;
                return placeProviderObject;
            }

            @Override // org.rbmain.ui.PhotoViewer.EmptyPhotoViewerProvider, org.rbmain.ui.PhotoViewer.PhotoViewerProvider
            public void willHidePhotoViewer() {
                ProfileActivity.this.avatarImage.getImageReceiver().setVisible(true, true);
            }

            @Override // org.rbmain.ui.PhotoViewer.EmptyPhotoViewerProvider, org.rbmain.ui.PhotoViewer.PhotoViewerProvider
            public void openPhotoForEdit(String str, String str2, boolean z) throws IllegalAccessException, NoSuchFieldException, Resources.NotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException {
                ProfileActivity.this.imageUpdater.openPhotoForEdit(str, str2, 0, z);
            }
        };
        this.nextStartId = null;
        this.ACTIONBAR_HEADER_PROGRESS = new AnimationProperties.FloatProperty<ActionBar>("animationProgress") { // from class: org.rbmain.ui.ProfileActivity.26
            @Override // org.rbmain.ui.Components.AnimationProperties.FloatProperty
            public void setValue(ActionBar actionBar, float f) {
                ProfileActivity.this.mediaHeaderAnimationProgress = f;
                ProfileActivity.this.topView.invalidate();
                int color = Theme.getColor(Theme.key_profile_title);
                int i = Theme.key_player_actionBarTitle;
                int color2 = Theme.getColor(i);
                int offsetColor = AndroidUtilities.getOffsetColor(color, color2, f, 1.0f);
                ProfileActivity.this.nameTextView[1].setTextColor(offsetColor);
                if (ProfileActivity.this.lockIconDrawable != null) {
                    ProfileActivity.this.lockIconDrawable.setColorFilter(offsetColor, PorterDuff.Mode.MULTIPLY);
                }
                if (ProfileActivity.this.scamDrawable != null) {
                    ProfileActivity.this.scamDrawable.setColor(AndroidUtilities.getOffsetColor(Theme.getColor(Theme.key_avatar_subtitleInProfileBlue), color2, f, 1.0f));
                }
                int i2 = Theme.key_actionBarDefaultIcon;
                ((BaseFragment) ProfileActivity.this).actionBar.setItemsColor(AndroidUtilities.getOffsetColor(Theme.getColor(i2), Theme.getColor(Theme.key_windowBackgroundWhiteGrayText2), f, 1.0f), false);
                ((BaseFragment) ProfileActivity.this).actionBar.setItemsBackgroundColor(AndroidUtilities.getOffsetColor(Theme.getColor(Theme.key_avatar_actionBarSelectorBlue), Theme.getColor(Theme.key_actionBarActionModeDefaultSelector), f, 1.0f), false);
                ProfileActivity.this.topView.invalidate();
                ProfileActivity.this.otherItem.setIconColor(Theme.getColor(i2));
                ProfileActivity.this.callItem.setIconColor(Theme.getColor(i2));
                ProfileActivity.this.videoCallItem.setIconColor(Theme.getColor(i2));
                ProfileActivity.this.editItem.setIconColor(Theme.getColor(i2));
                if (ProfileActivity.this.verifiedDrawable != null) {
                    ProfileActivity.this.verifiedDrawable.setColorFilter(AndroidUtilities.getOffsetColor(Theme.getColor(Theme.key_chats_verifiedBackground), Theme.getColor(i), f, 1.0f), PorterDuff.Mode.MULTIPLY);
                }
                if (ProfileActivity.this.verifiedCheckDrawable != null) {
                    ProfileActivity.this.verifiedCheckDrawable.setColorFilter(AndroidUtilities.getOffsetColor(Theme.getColor(Theme.key_chats_verifiedCheck), Theme.getColor(Theme.key_windowBackgroundWhite), f, 1.0f), PorterDuff.Mode.MULTIPLY);
                }
                if (ProfileActivity.this.avatarsViewPagerIndicatorView.getSecondaryMenuItem() != null) {
                    if (ProfileActivity.this.videoCallItemVisible || ProfileActivity.this.editItemVisible || ProfileActivity.this.callItemVisible) {
                        ProfileActivity profileActivity = ProfileActivity.this;
                        profileActivity.needLayoutText(Math.min(1.0f, profileActivity.extraHeight / AndroidUtilities.dp(88.0f)));
                    }
                }
            }

            @Override // android.util.Property
            public Float get(ActionBar actionBar) {
                return Float.valueOf(ProfileActivity.this.mediaHeaderAnimationProgress);
            }
        };
        this.savedScrollPosition = -1;
        this.hasRubino = false;
        this.isOneTimeCheckedRubino = false;
        this.fragmentName = "ProfileActivity";
        this.sharedMediaPreloader = sharedMediaPreloader;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() throws InterruptedException {
        TLRPC$Chat tLRPC$Chat;
        this.user_id = this.arguments.getInt("user_id", 0);
        this.chat_id = this.arguments.getInt("chat_id", 0);
        this.banFromGroup = this.arguments.getInt("ban_chat_id", 0);
        this.reportSpam = this.arguments.getBoolean("reportSpam", false);
        if (!this.expandPhoto) {
            boolean z = this.arguments.getBoolean("expandPhoto", false);
            this.expandPhoto = z;
            if (z) {
                this.needSendMessage = true;
            }
        }
        if (this.user_id != 0) {
            long j = this.arguments.getLong("dialog_id", 0L);
            this.dialog_id = j;
            if (j != 0) {
                this.currentEncryptedChat = getMessagesController().getEncryptedChat(Integer.valueOf((int) (this.dialog_id >> 32)));
            }
            TLRPC$User user = getMessagesController().getUser(Integer.valueOf(this.user_id));
            if (user == null) {
                return false;
            }
            getNotificationCenter().addObserver(this, NotificationCenter.contactsDidLoad);
            getNotificationCenter().addObserver(this, NotificationCenter.encryptedChatCreated);
            getNotificationCenter().addObserver(this, NotificationCenter.encryptedChatUpdated);
            getNotificationCenter().addObserver(this, NotificationCenter.blockedUsersDidLoad);
            getNotificationCenter().addObserver(this, NotificationCenter.botInfoDidLoad);
            getNotificationCenter().addObserver(this, NotificationCenter.userInfoDidLoad);
            NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.reloadInterface);
            this.userBlocked = getMessagesController().blockePeers.indexOfKey(this.user_id) >= 0;
            if (user.bot) {
                this.isBot = true;
                getMediaDataController().loadBotInfo(user.id, true, this.classGuid);
            }
            this.userInfo = getMessagesController().getUserFull(this.user_id);
            getMessagesController().loadFullUser(getMessagesController().getUser(Integer.valueOf(this.user_id)), this.classGuid, true);
            this.participantsMap = null;
            if (UserObject.isUserSelf(user)) {
                this.isMyUser = true;
                ImageUpdater imageUpdater = new ImageUpdater(false);
                this.imageUpdater = imageUpdater;
                imageUpdater.setOpenWithFrontfaceCamera(true);
                this.imageUpdater.setSearchAvailable(false);
                ImageUpdater imageUpdater2 = this.imageUpdater;
                imageUpdater2.parentFragment = this;
                imageUpdater2.setDelegate(this);
                getMessagesController().loadUserInfo(getUserConfig().getCurrentUser(), true, this.classGuid);
                callGetSettings();
                ActionBar actionBar = this.actionBar;
                if (actionBar != null) {
                    actionBar.setBackButtonDrawable(null);
                }
            }
        } else {
            if (this.chat_id == 0) {
                return false;
            }
            TLRPC$Chat chat = getMessagesController().getChat(Integer.valueOf(this.chat_id));
            this.currentChat = chat;
            if (chat == null) {
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: org.rbmain.ui.ProfileActivity$$ExternalSyntheticLambda16
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onFragmentCreate$0(countDownLatch);
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
                this.chatInfo = getMessagesController().getChatFull(this.chat_id);
            }
            if (ChatObject.isChannel(this.currentChat)) {
                getMessagesController().loadFullChat(this.chat_id, this.classGuid, true);
            } else if (this.chatInfo == null) {
                this.chatInfo = getMessagesStorage().loadChatInfo(this.chat_id, false, null, false, false);
            }
        }
        if (this.sharedMediaPreloader == null) {
            this.sharedMediaPreloader = new SharedMediaLayout.SharedMediaPreloader(this);
        }
        getNotificationCenter().addObserver(this, NotificationCenter.updateInterfaces);
        getNotificationCenter().addObserver(this, NotificationCenter.didReceiveNewMessages);
        getNotificationCenter().addObserver(this, NotificationCenter.closeChats);
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.emojiDidLoad);
        updateRowsIds();
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
        if (this.arguments.containsKey("preload_messages")) {
            getMessagesController().ensureMessagesLoaded(this.user_id, 0L, null);
        }
        if (!this.isMyUser) {
            if (!this.hasRubino && !this.isBot && ((tLRPC$Chat = this.currentChat) == null || !tLRPC$Chat.megagroup)) {
                checkHasRubinoPage();
            }
            checkHasItemLinks();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onFragmentCreate$0(CountDownLatch countDownLatch) {
        this.currentChat = getMessagesStorage().getChat(this.chat_id);
        countDownLatch.countDown();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
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
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.emojiDidLoad);
        ProfileGalleryView profileGalleryView = this.avatarsViewPager;
        if (profileGalleryView != null) {
            profileGalleryView.onDestroy();
        }
        if (this.user_id != 0) {
            getNotificationCenter().removeObserver(this, NotificationCenter.contactsDidLoad);
            getNotificationCenter().removeObserver(this, NotificationCenter.encryptedChatCreated);
            getNotificationCenter().removeObserver(this, NotificationCenter.encryptedChatUpdated);
            getNotificationCenter().removeObserver(this, NotificationCenter.blockedUsersDidLoad);
            getNotificationCenter().removeObserver(this, NotificationCenter.botInfoDidLoad);
            getNotificationCenter().removeObserver(this, NotificationCenter.userInfoDidLoad);
            NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.reloadInterface);
            getMessagesController().cancelLoadFullUser(this.user_id);
        } else if (this.chat_id != 0) {
            getNotificationCenter().removeObserver(this, NotificationCenter.chatInfoDidLoad);
            getNotificationCenter().removeObserver(this, NotificationCenter.chatOnlineCountDidLoad);
            getNotificationCenter().removeObserver(this, NotificationCenter.groupCallUpdated);
            getMessagesController().cancelLoadFullChat(this.chat_id);
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

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    protected ActionBar createActionBar(Context context) {
        ActionBar actionBar = new ActionBar(context) { // from class: org.rbmain.ui.ProfileActivity.3
            @Override // org.rbmain.ui.ActionBar.ActionBar, android.view.View
            public boolean onTouchEvent(MotionEvent motionEvent) {
                ProfileActivity.this.avatarContainer.getHitRect(ProfileActivity.this.rect);
                if (ProfileActivity.this.rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    return false;
                }
                return super.onTouchEvent(motionEvent);
            }
        };
        actionBar.setBackgroundColor(0);
        actionBar.setItemsBackgroundColor(AvatarDrawable.getButtonColorForId((this.user_id != 0 || (ChatObject.isChannel(this.chat_id, this.currentAccount) && !this.currentChat.megagroup)) ? 5L : this.chat_id), false);
        actionBar.setItemsColor(Theme.getColor(Theme.key_actionBarDefaultIcon), false);
        actionBar.setBackButtonDrawable(new BackDrawable(false));
        actionBar.setCastShadows(false);
        actionBar.setAddToContainer(false);
        actionBar.setClipContent(true);
        actionBar.setOccupyStatusBar(false);
        return actionBar;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(final Context context) {
        Object tag;
        int i;
        float f;
        float f2;
        float f3;
        float f4;
        Theme.createProfileResources(context);
        this.rtlLayout = true;
        this.actionBar.setRtlLayout(true);
        this.searchTransitionOffset = 0;
        this.searchMode = false;
        this.hasOwnBackground = true;
        this.extraHeight = AndroidUtilities.dp(88.0f);
        this.actionBar.setActionBarMenuOnItemClick(new AnonymousClass4());
        SharedMediaLayout sharedMediaLayout = this.sharedMediaLayout;
        if (sharedMediaLayout != null) {
            sharedMediaLayout.onDestroy();
        }
        long j = this.dialog_id;
        if (j == 0) {
            int i2 = this.user_id;
            if (i2 == 0) {
                i2 = -this.chat_id;
            }
            j = i2;
        }
        final long j2 = j;
        if (this.sharedMediaPreloader == null) {
            this.sharedMediaPreloader = new SharedMediaLayout.SharedMediaPreloader(this);
        }
        this.sharedMediaPreloader.addDelegate(this);
        SharedMediaLayout.SharedMediaPreloader sharedMediaPreloader = this.sharedMediaPreloader;
        TLRPC$UserFull tLRPC$UserFull = this.userInfo;
        int i3 = tLRPC$UserFull != null ? tLRPC$UserFull.common_chats_count : 0;
        ArrayList<Integer> arrayList = this.sortedUsers;
        TLRPC$ChatFull tLRPC$ChatFull = this.chatInfo;
        TLRPC$Chat tLRPC$Chat = this.currentChat;
        SharedMediaLayout sharedMediaLayout2 = new SharedMediaLayout(context, j2, sharedMediaPreloader, i3, arrayList, tLRPC$ChatFull, tLRPC$Chat != null && tLRPC$Chat.megagroup && tLRPC$ChatFull != null && getDialogsProxy().canSeeMembers(this.chatInfo.id) && this.chatInfo.participants_count > 5, this) { // from class: org.rbmain.ui.ProfileActivity.5
            @Override // org.rbmain.ui.Components.SharedMediaLayout
            protected void onSelectedTabChanged() {
                ProfileActivity.this.updateSelectedMediaTabText();
            }

            @Override // org.rbmain.ui.Components.SharedMediaLayout
            protected boolean canShowSearchItem() {
                return ProfileActivity.this.mediaHeaderVisible;
            }

            @Override // org.rbmain.ui.Components.SharedMediaLayout
            protected void onSearchStateChanged(boolean z) {
                if (SharedConfig.smoothKeyboard) {
                    AndroidUtilities.removeAdjustResize(ProfileActivity.this.getParentActivity(), ((BaseFragment) ProfileActivity.this).classGuid);
                }
                ProfileActivity.this.listView.stopScroll();
                ProfileActivity.this.avatarContainer2.setPivotY(ProfileActivity.this.avatarContainer.getPivotY() + (ProfileActivity.this.avatarContainer.getMeasuredHeight() / 2.0f));
                ProfileActivity.this.avatarContainer2.setPivotX(ProfileActivity.this.avatarContainer2.getMeasuredWidth() / 2.0f);
                AndroidUtilities.updateViewVisibilityAnimated(ProfileActivity.this.avatarContainer2, !z, 0.95f, true);
                ProfileActivity.this.callItem.setVisibility((z || !ProfileActivity.this.callItemVisible) ? 8 : 4);
                ProfileActivity.this.videoCallItem.setVisibility((z || !ProfileActivity.this.videoCallItemVisible) ? 8 : 4);
                ProfileActivity.this.editItem.setVisibility((z || !ProfileActivity.this.editItemVisible) ? 8 : 4);
                ProfileActivity.this.otherItem.setVisibility(z ? 8 : 4);
            }

            @Override // org.rbmain.ui.Components.SharedMediaLayout
            protected boolean onMemberClick(TLRPC$ChatParticipant tLRPC$ChatParticipant, boolean z) {
                return ProfileActivity.this.onMemberClick(tLRPC$ChatParticipant, z);
            }
        };
        this.sharedMediaLayout = sharedMediaLayout2;
        sharedMediaLayout2.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
        ActionBarMenu actionBarMenuCreateMenu = this.actionBar.createMenu();
        ActionBarMenuItem actionBarMenuItemAddItem = actionBarMenuCreateMenu.addItem(16, R.drawable.profile_video);
        this.videoCallItem = actionBarMenuItemAddItem;
        actionBarMenuItemAddItem.setContentDescription(LocaleController.getString("VideoCall", R.string.VideoCall));
        if (this.chat_id != 0) {
            ActionBarMenuItem actionBarMenuItemAddItem2 = actionBarMenuCreateMenu.addItem(15, R.drawable.msg_voicechat2);
            this.callItem = actionBarMenuItemAddItem2;
            actionBarMenuItemAddItem2.setContentDescription(LocaleController.getString("VoipGroupVoiceChat", R.string.VoipGroupVoiceChat));
        } else {
            ActionBarMenuItem actionBarMenuItemAddItem3 = actionBarMenuCreateMenu.addItem(15, R.drawable.ic_call);
            this.callItem = actionBarMenuItemAddItem3;
            actionBarMenuItemAddItem3.setContentDescription(LocaleController.getString("Call", R.string.Call));
        }
        ActionBarMenuItem actionBarMenuItemAddItem4 = actionBarMenuCreateMenu.addItem(12, R.drawable.group_edit_profile);
        this.editItem = actionBarMenuItemAddItem4;
        actionBarMenuItemAddItem4.setContentDescription(LocaleController.getString("Edit", R.string.Edit));
        ActionBarMenuItem actionBarMenuItemAddItem5 = actionBarMenuCreateMenu.addItem(10, R.drawable.ic_ab_other);
        this.otherItem = actionBarMenuItemAddItem5;
        actionBarMenuItemAddItem5.setContentDescription(LocaleController.getString("AccDescrMoreOptions", R.string.AccDescrMoreOptions));
        if (this.listView == null || this.imageUpdater == null) {
            tag = null;
            i = -1;
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
        RecyclerListView recyclerListView = new RecyclerListView(context) { // from class: org.rbmain.ui.ProfileActivity.8
            private VelocityTracker velocityTracker;

            @Override // org.rbmain.ui.Components.RecyclerListView, android.view.View
            public boolean hasOverlappingRendering() {
                return false;
            }

            @Override // androidx.recyclerview.widget.RecyclerView
            protected void requestChildOnScreen(View view, View view2) {
            }

            @Override // org.rbmain.ui.Components.RecyclerListView
            protected boolean allowSelectChildAtPosition(View view) {
                return view != ProfileActivity.this.sharedMediaLayout;
            }

            @Override // android.view.View
            public void invalidate() {
                super.invalidate();
                View view = ProfileActivity.this.fragmentView;
                if (view != null) {
                    view.invalidate();
                }
            }

            @Override // org.rbmain.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.View
            public boolean onTouchEvent(MotionEvent motionEvent) {
                VelocityTracker velocityTracker;
                View viewFindViewByPosition2;
                int action = motionEvent.getAction();
                if (action == 0) {
                    VelocityTracker velocityTracker2 = this.velocityTracker;
                    if (velocityTracker2 == null) {
                        this.velocityTracker = VelocityTracker.obtain();
                    } else {
                        velocityTracker2.clear();
                    }
                    this.velocityTracker.addMovement(motionEvent);
                } else if (action == 2) {
                    VelocityTracker velocityTracker3 = this.velocityTracker;
                    if (velocityTracker3 != null) {
                        velocityTracker3.addMovement(motionEvent);
                        this.velocityTracker.computeCurrentVelocity(CloseCodes.NORMAL_CLOSURE);
                        ProfileActivity.this.listViewVelocityY = this.velocityTracker.getYVelocity(motionEvent.getPointerId(motionEvent.getActionIndex()));
                    }
                } else if ((action == 1 || action == 3) && (velocityTracker = this.velocityTracker) != null) {
                    velocityTracker.recycle();
                    this.velocityTracker = null;
                }
                boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
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
            public boolean drawChild(Canvas canvas, View view, long j3) {
                if (getItemAnimator().isRunning() && view.getBackground() == null && view.getTranslationY() != 0.0f) {
                    boolean z = ProfileActivity.this.listView.getChildAdapterPosition(view) == ProfileActivity.this.sharedMediaRow && view.getAlpha() != 1.0f;
                    if (z) {
                        ProfileActivity.this.whitePaint.setAlpha((int) (ProfileActivity.this.listView.getAlpha() * 255.0f * view.getAlpha()));
                    }
                    canvas.drawRect(ProfileActivity.this.listView.getX(), view.getY(), ProfileActivity.this.listView.getX() + ProfileActivity.this.listView.getMeasuredWidth(), view.getY() + view.getHeight(), ProfileActivity.this.whitePaint);
                    if (z) {
                        ProfileActivity.this.whitePaint.setAlpha((int) (ProfileActivity.this.listView.getAlpha() * 255.0f));
                    }
                }
                return super.drawChild(canvas, view, j3);
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
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context) { // from class: org.rbmain.ui.ProfileActivity.10
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean supportsPredictiveItemAnimations() {
                return ProfileActivity.this.imageUpdater != null;
            }

            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public int scrollVerticallyBy(int i4, RecyclerView.Recycler recycler, RecyclerView.State state) {
                View viewFindViewByPosition2 = ProfileActivity.this.layoutManager.findViewByPosition(0);
                if (viewFindViewByPosition2 != null && !ProfileActivity.this.openingAvatar) {
                    int top = viewFindViewByPosition2.getTop() - AndroidUtilities.dp(88.0f);
                    if (ProfileActivity.this.allowPullingDown || top <= i4) {
                        if (ProfileActivity.this.allowPullingDown) {
                            if (i4 >= top) {
                                ProfileActivity.this.allowPullingDown = false;
                            } else if (ProfileActivity.this.listView.getScrollState() == 1 && !ProfileActivity.this.isPulledDown) {
                                i4 /= 2;
                            }
                        }
                    } else if (ProfileActivity.this.avatarsViewPager.hasImages() && ProfileActivity.this.avatarImage.getImageReceiver().hasNotThumb() && !ProfileActivity.this.isInLandscapeMode && !AndroidUtilities.isTablet()) {
                        ProfileActivity profileActivity = ProfileActivity.this;
                        profileActivity.allowPullingDown = profileActivity.avatarBig == null;
                    }
                    i4 = top;
                }
                return super.scrollVerticallyBy(i4, recycler, state);
            }
        };
        this.layoutManager = linearLayoutManager;
        linearLayoutManager.setOrientation(1);
        this.listView.setLayoutManager(this.layoutManager);
        this.listView.setGlowColor(0);
        this.listView.setAdapter(this.listAdapter);
        frameLayout.addView(this.listView, LayoutHelper.createFrame(-1, -1, 51));
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListenerExtended() { // from class: org.rbmain.ui.ProfileActivity$$ExternalSyntheticLambda34
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListenerExtended
            public /* synthetic */ boolean hasDoubleTap(View view, int i4) {
                return RecyclerListView.OnItemClickListenerExtended.CC.$default$hasDoubleTap(this, view, i4);
            }

            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListenerExtended
            public /* synthetic */ void onDoubleTap(View view, int i4, float f5, float f6) {
                RecyclerListView.OnItemClickListenerExtended.CC.$default$onDoubleTap(this, view, i4, f5, f6);
            }

            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListenerExtended
            public final void onItemClick(View view, int i4, float f5, float f6) throws IOException {
                this.f$0.lambda$createView$2(j2, view, i4, f5, f6);
            }
        });
        this.listView.setOnItemLongClickListener(new RecyclerListView.OnItemLongClickListener() { // from class: org.rbmain.ui.ProfileActivity.11
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemLongClickListener
            public boolean onItemClick(View view, int i4) {
                if (i4 < ProfileActivity.this.membersStartRow || i4 >= ProfileActivity.this.membersEndRow) {
                    return ProfileActivity.this.processOnClickOrPress(i4);
                }
                return ProfileActivity.this.onMemberClick(!ProfileActivity.this.sortedUsers.isEmpty() ? (TLRPC$ChatParticipant) ProfileActivity.this.visibleChatParticipants.get(((Integer) ProfileActivity.this.sortedUsers.get(i4 - ProfileActivity.this.membersStartRow)).intValue()) : (TLRPC$ChatParticipant) ProfileActivity.this.visibleChatParticipants.get(i4 - ProfileActivity.this.membersStartRow), true);
            }
        });
        if (this.searchItem != null) {
            RecyclerListView recyclerListView2 = new RecyclerListView(context);
            this.searchListView = recyclerListView2;
            recyclerListView2.setVerticalScrollBarEnabled(false);
            this.searchListView.setLayoutManager(new LinearLayoutManager(context, 1, false));
            this.searchListView.setGlowColor(Theme.getColor(Theme.key_avatar_backgroundActionBarBlue));
            this.searchListView.setAdapter(this.searchAdapter);
            this.searchListView.setItemAnimator(null);
            this.searchListView.setVisibility(8);
            this.searchListView.setLayoutAnimation(null);
            this.searchListView.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
            frameLayout.addView(this.searchListView, LayoutHelper.createFrame(-1, -1, 51));
            this.searchListView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: org.rbmain.ui.ProfileActivity$$ExternalSyntheticLambda33
                @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
                public final void onItemClick(View view, int i4) {
                    this.f$0.lambda$createView$3(view, i4);
                }
            });
            this.searchListView.setOnItemLongClickListener(new RecyclerListView.OnItemLongClickListener() { // from class: org.rbmain.ui.ProfileActivity$$ExternalSyntheticLambda35
                @Override // org.rbmain.ui.Components.RecyclerListView.OnItemLongClickListener
                public final boolean onItemClick(View view, int i4) {
                    return this.f$0.lambda$createView$5(view, i4);
                }
            });
            this.searchListView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: org.rbmain.ui.ProfileActivity.12
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int i4) {
                    if (i4 == 1) {
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
            final TLRPC$Chat chat = getMessagesController().getChat(Integer.valueOf(this.banFromGroup));
            if (this.currentChannelParticipant == null) {
                TLRPC$TL_channels_getParticipant tLRPC$TL_channels_getParticipant = new TLRPC$TL_channels_getParticipant();
                tLRPC$TL_channels_getParticipant.channel = MessagesController.getInputChannel(chat);
                tLRPC$TL_channels_getParticipant.participant = getMessagesController().getInputPeer(this.user_id);
                getConnectionsManager().sendRequest(tLRPC$TL_channels_getParticipant, new RequestDelegate() { // from class: org.rbmain.ui.ProfileActivity$$ExternalSyntheticLambda29
                    @Override // org.rbmain.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$createView$7(tLObject, tLRPC$TL_error);
                    }
                });
            }
            FrameLayout frameLayout2 = new FrameLayout(this, context) { // from class: org.rbmain.ui.ProfileActivity.13
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
            frameLayout2.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.ProfileActivity$$ExternalSyntheticLambda12
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$createView$8(chat, view);
                }
            });
            TextView textView = new TextView(context);
            textView.setTextColor(Theme.getColor(Theme.key_text_RedRegular));
            textView.setTextSize(1, 15.0f);
            textView.setGravity(17);
            textView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
            textView.setText(LocaleController.getString("BanFromTheGroup", R.string.BanFromTheGroup));
            frameLayout2.addView(textView, LayoutHelper.createFrame(-2, -2.0f, 17, 0.0f, 1.0f, 0.0f, 0.0f));
            this.listView.setPadding(0, AndroidUtilities.dp(88.0f), 0, AndroidUtilities.dp(48.0f));
            this.listView.setBottomGlowOffset(AndroidUtilities.dp(48.0f));
        } else {
            this.listView.setPadding(0, AndroidUtilities.dp(88.0f), 0, 0);
        }
        TopView topView = new TopView(context);
        this.topView = topView;
        topView.setBackgroundColor(Theme.getColor(Theme.key_avatar_backgroundActionBarBlue));
        frameLayout.addView(this.topView);
        this.avatarContainer = new FrameLayout(context) { // from class: org.rbmain.ui.ProfileActivity.15
            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int i4, int i5) {
                int size = View.MeasureSpec.getSize(i4);
                super.onMeasure(i4, i5);
                if (ProfileActivity.this.isRtlLayout()) {
                    ProfileActivity.this.avatarContainer.setPivotX(size);
                }
            }
        };
        FrameLayout frameLayout3 = new FrameLayout(context) { // from class: org.rbmain.ui.ProfileActivity.16
            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int i4, int i5) {
                int size = View.MeasureSpec.getSize(i4);
                super.onMeasure(i4, i5);
                if (ProfileActivity.this.isRtlLayout()) {
                    ProfileActivity.this.avatarContainer2.setPivotX(size / 2.0f);
                }
            }
        };
        this.avatarContainer2 = frameLayout3;
        AndroidUtilities.updateViewVisibilityAnimated(frameLayout3, true, 1.0f, false);
        if (isRtlLayout()) {
            frameLayout.addView(this.avatarContainer2, LayoutHelper.createFrame(-1, -1, 5));
        } else {
            frameLayout.addView(this.avatarContainer2, LayoutHelper.createFrame(-1, -1.0f));
        }
        this.avatarContainer.setPivotX(0.0f);
        this.avatarContainer.setPivotY(0.0f);
        this.avatarContainer2.addView(this.avatarContainer, LayoutHelper.createFrame(42, 42.0f, (isRtlLayout() ? 5 : 3) | 48, isRtlLayout() ? 0.0f : 64.0f, 0.0f, isRtlLayout() ? 64.0f : 0.0f, 0.0f));
        AvatarImageView avatarImageView = new AvatarImageView(this, context) { // from class: org.rbmain.ui.ProfileActivity.17
            @Override // android.view.View
            public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
                super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
                if (getImageReceiver().hasNotThumb()) {
                    accessibilityNodeInfo.setText(LocaleController.getString("AccDescrProfilePicture", R.string.AccDescrProfilePicture));
                    if (Build.VERSION.SDK_INT >= 21) {
                        accessibilityNodeInfo.addAction(new AccessibilityNodeInfo.AccessibilityAction(16, LocaleController.getString("Open", R.string.Open)));
                        accessibilityNodeInfo.addAction(new AccessibilityNodeInfo.AccessibilityAction(32, LocaleController.getString("AccDescrOpenInPhotoViewer", R.string.AccDescrOpenInPhotoViewer)));
                        return;
                    }
                    return;
                }
                accessibilityNodeInfo.setVisibleToUser(false);
            }
        };
        this.avatarImage = avatarImageView;
        avatarImageView.setRoundRadius(AndroidUtilities.dp(21.0f));
        this.avatarImage.setPivotX(0.0f);
        this.avatarImage.setPivotY(0.0f);
        this.avatarContainer.addView(this.avatarImage, LayoutHelper.createFrame(-1, -1.0f));
        this.avatarImage.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.ProfileActivity$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createView$9(view);
            }
        });
        this.avatarImage.setOnLongClickListener(new View.OnLongClickListener() { // from class: org.rbmain.ui.ProfileActivity$$ExternalSyntheticLambda13
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f$0.lambda$createView$10(view);
            }
        });
        RadialProgressView radialProgressView = new RadialProgressView(context) { // from class: org.rbmain.ui.ProfileActivity.18
            private Paint paint;

            {
                Paint paint = new Paint(1);
                this.paint = paint;
                paint.setColor(1426063360);
            }

            @Override // org.rbmain.ui.Components.RadialProgressView, android.view.View
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
        ImageView imageView2 = this.timeItem;
        TimerDrawable timerDrawable = new TimerDrawable(context, null);
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
        int i4 = this.user_id;
        if (i4 == 0) {
            i4 = -this.chat_id;
        }
        ProfileGalleryView profileGalleryView2 = new ProfileGalleryView(context, i4, this.actionBar, this.listView, this.avatarImage, getClassGuid(), this.overlaysView);
        this.avatarsViewPager = profileGalleryView2;
        profileGalleryView2.setChatInfo(this.chatInfo);
        this.avatarContainer2.addView(this.avatarsViewPager);
        this.avatarContainer2.addView(this.overlaysView);
        this.avatarImage.setAvatarsViewPager(this.avatarsViewPager);
        PagerIndicatorView pagerIndicatorView = new PagerIndicatorView(context);
        this.avatarsViewPagerIndicatorView = pagerIndicatorView;
        this.avatarContainer2.addView(pagerIndicatorView, LayoutHelper.createFrame(-1, -1.0f));
        frameLayout.addView(this.actionBar);
        int i5 = 0;
        while (true) {
            SimpleTextView[] simpleTextViewArr = this.nameTextView;
            if (i5 >= simpleTextViewArr.length) {
                break;
            }
            if (this.playProfileAnimation != 0 || i5 != 0) {
                simpleTextViewArr[i5] = new SimpleTextView(context);
                if (i5 == 1) {
                    this.nameTextView[i5].setTextColor(Theme.getColor(Theme.key_profile_title));
                } else {
                    this.nameTextView[i5].setTextColor(Theme.getColor(Theme.key_actionBarDefaultTitle));
                }
                this.nameTextView[i5].setTextSize(18);
                this.nameTextView[i5].setGravity(3);
                this.nameTextView[i5].setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
                this.nameTextView[i5].setLeftDrawableTopPadding(-AndroidUtilities.dp(1.3f));
                this.nameTextView[i5].setPivotX(0.0f);
                this.nameTextView[i5].setPivotY(0.0f);
                this.nameTextView[i5].setAlpha(i5 == 0 ? 0.0f : 1.0f);
                if (i5 == 1) {
                    this.nameTextView[i5].setScrollNonFitText(true);
                    this.nameTextView[i5].setImportantForAccessibility(2);
                }
                FrameLayout frameLayout4 = this.avatarContainer2;
                SimpleTextView simpleTextView = this.nameTextView[i5];
                int i6 = (isRtlLayout() ? 5 : 3) | 48;
                if (isRtlLayout()) {
                    f3 = i5 == 0 ? 48 : 0;
                } else {
                    f3 = 118.0f;
                }
                if (isRtlLayout()) {
                    f4 = 118.0f;
                } else {
                    f4 = i5 == 0 ? 48 : 0;
                }
                frameLayout4.addView(simpleTextView, LayoutHelper.createFrame(-2, -2.0f, i6, f3, 0.0f, f4, 0.0f));
            }
            i5++;
        }
        int i7 = 0;
        while (true) {
            SimpleTextView[] simpleTextViewArr2 = this.onlineTextView;
            if (i7 >= simpleTextViewArr2.length) {
                break;
            }
            simpleTextViewArr2[i7] = new SimpleTextView(context);
            this.onlineTextView[i7].setTextColor(Theme.getColor(Theme.key_avatar_subtitleInProfileBlue));
            this.onlineTextView[i7].setTextSize(14);
            this.onlineTextView[i7].setGravity(isRtlLayout() ? 5 : 3);
            this.onlineTextView[i7].setAlpha((i7 == 0 || i7 == 2) ? 0.0f : 1.0f);
            if (i7 > 0) {
                this.onlineTextView[i7].setImportantForAccessibility(2);
            }
            FrameLayout frameLayout5 = this.avatarContainer2;
            SimpleTextView simpleTextView2 = this.onlineTextView[i7];
            int i8 = (isRtlLayout() ? 5 : 3) | 48;
            if (isRtlLayout()) {
                f = i7 == 0 ? 48 : 8;
            } else {
                f = 118.0f;
            }
            if (isRtlLayout()) {
                f2 = 118.0f;
            } else {
                f2 = i7 == 0 ? 48 : 8;
            }
            frameLayout5.addView(simpleTextView2, LayoutHelper.createFrame(-2, -2.0f, i8, f, 0.0f, f2, 0.0f));
            i7++;
        }
        AudioPlayerAlert.ClippingTextViewSwitcher clippingTextViewSwitcher = new AudioPlayerAlert.ClippingTextViewSwitcher(this, context) { // from class: org.rbmain.ui.ProfileActivity.19
            @Override // org.rbmain.ui.Components.AudioPlayerAlert.ClippingTextViewSwitcher
            protected TextView createTextView() {
                TextView textView2 = new TextView(context);
                textView2.setTextColor(Theme.getColor(Theme.key_player_actionBarSubtitle));
                textView2.setTextSize(1, 14.0f);
                textView2.setSingleLine(true);
                textView2.setEllipsize(TextUtils.TruncateAt.END);
                textView2.setGravity(3);
                return textView2;
            }
        };
        this.mediaCounterTextView = clippingTextViewSwitcher;
        clippingTextViewSwitcher.setAlpha(0.0f);
        this.avatarContainer2.addView(this.mediaCounterTextView, LayoutHelper.createFrame(-2, -2.0f, (isRtlLayout() ? 5 : 3) | 48, isRtlLayout() ? 0.0f : 118.0f, 0.0f, isRtlLayout() ? 126.0f : 8.0f, 0.0f));
        updateProfileData();
        this.writeButton = new RLottieImageView(context);
        Drawable drawableMutate = context.getResources().getDrawable(R.drawable.floating_shadow_profile).mutate();
        drawableMutate.setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.MULTIPLY));
        CombinedDrawable combinedDrawable = new CombinedDrawable(drawableMutate, Theme.createSimpleSelectorCircleDrawable(AndroidUtilities.dp(56.0f), Theme.getColor(Theme.key_profile_actionBackground), Theme.getColor(Theme.key_profile_actionPressedBackground)), 0, 0);
        combinedDrawable.setIconSize(AndroidUtilities.dp(56.0f), AndroidUtilities.dp(56.0f));
        this.writeButton.setBackgroundDrawable(combinedDrawable);
        if (this.user_id != 0) {
            if (this.imageUpdater != null) {
                RLottieDrawable rLottieDrawable = new RLottieDrawable(R.raw.camera_outline, "2131820556", AndroidUtilities.dp(56.0f), AndroidUtilities.dp(56.0f), false, null);
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
        this.writeButton.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_profile_actionIcon), PorterDuff.Mode.MULTIPLY));
        this.writeButton.setScaleType(ImageView.ScaleType.CENTER);
        frameLayout.addView(this.writeButton, LayoutHelper.createFrame(60, 60.0f, (isRtlLayout() ? 3 : 5) | 48, isRtlLayout() ? 16.0f : 0.0f, 0.0f, isRtlLayout() ? 0.0f : 16.0f, 0.0f));
        this.writeButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.ProfileActivity$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createView$11(view);
            }
        });
        needLayout(false);
        if (i != -1 && tag != null) {
            this.writeButton.setTag(0);
            this.writeButton.setScaleX(0.2f);
            this.writeButton.setScaleY(0.2f);
            this.writeButton.setAlpha(0.0f);
        }
        this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: org.rbmain.ui.ProfileActivity.20
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i9) {
                if (i9 == 1) {
                    AndroidUtilities.hideKeyboard(ProfileActivity.this.getParentActivity().getCurrentFocus());
                }
                if (ProfileActivity.this.openingAvatar && i9 != 2) {
                    ProfileActivity.this.openingAvatar = false;
                }
                if (ProfileActivity.this.searchItem != null) {
                    ProfileActivity.this.scrolling = i9 != 0;
                    ProfileActivity.this.searchItem.setEnabled((ProfileActivity.this.scrolling || ProfileActivity.this.isPulledDown) ? false : true);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i9, int i10) {
                ProfileActivity.this.checkListViewScroll();
                if (ProfileActivity.this.participantsMap == null || ProfileActivity.this.usersEndReached || ProfileActivity.this.layoutManager.findLastVisibleItemPosition() <= ProfileActivity.this.membersEndRow - 8) {
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
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.ProfileActivity$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.lambda$createView$12(valueAnimator);
            }
        });
        this.expandAnimator.setInterpolator(CubicBezierInterpolator.EASE_BOTH);
        this.expandAnimator.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.ProfileActivity.21
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ((BaseFragment) ProfileActivity.this).actionBar.setItemsBackgroundColor(ProfileActivity.this.isPulledDown ? 1090519039 : Theme.getColor(Theme.key_avatar_actionBarSelectorBlue), false);
                ProfileActivity.this.avatarImage.clearForeground();
                ProfileActivity.this.doNotSetForeground = false;
            }
        });
        updateRowsIds();
        updateSelectedMediaTabText();
        PinchToZoomHelper pinchToZoomHelper = new PinchToZoomHelper(Build.VERSION.SDK_INT >= 21 ? (ViewGroup) getParentActivity().getWindow().getDecorView() : frameLayout, frameLayout) { // from class: org.rbmain.ui.ProfileActivity.22
            Paint statusBarPaint;

            @Override // org.rbmain.ui.PinchToZoomHelper
            protected void invalidateViews() {
                super.invalidateViews();
                ProfileActivity.this.fragmentView.invalidate();
                for (int i9 = 0; i9 < ProfileActivity.this.avatarsViewPager.getChildCount(); i9++) {
                    ProfileActivity.this.avatarsViewPager.getChildAt(i9).invalidate();
                }
                if (ProfileActivity.this.writeButton != null) {
                    ProfileActivity.this.writeButton.invalidate();
                }
            }

            @Override // org.rbmain.ui.PinchToZoomHelper
            protected void drawOverlays(Canvas canvas, float f5, float f6, float f7, float f8, float f9) {
                if (f5 > 0.0f) {
                    RectF rectF = AndroidUtilities.rectTmp;
                    rectF.set(0.0f, 0.0f, ProfileActivity.this.avatarsViewPager.getMeasuredWidth(), ProfileActivity.this.avatarsViewPager.getMeasuredHeight() + AndroidUtilities.dp(30.0f));
                    canvas.saveLayerAlpha(rectF, (int) (255.0f * f5), 31);
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
                        float f10 = (f5 * 0.5f) + 0.5f;
                        canvas.scale(f10, f10, ProfileActivity.this.writeButton.getX() + (ProfileActivity.this.writeButton.getMeasuredWidth() / 2.0f), ProfileActivity.this.writeButton.getY() + (ProfileActivity.this.writeButton.getMeasuredHeight() / 2.0f));
                        canvas.translate(ProfileActivity.this.writeButton.getX(), ProfileActivity.this.writeButton.getY());
                        ProfileActivity.this.writeButton.draw(canvas);
                        canvas.restore();
                    }
                    canvas.restore();
                }
            }

            @Override // org.rbmain.ui.PinchToZoomHelper
            protected boolean zoomEnabled(View view, ImageReceiver imageReceiver) {
                return super.zoomEnabled(view, imageReceiver) && ProfileActivity.this.listView.getScrollState() != 1;
            }
        };
        this.pinchToZoomHelper = pinchToZoomHelper;
        pinchToZoomHelper.setCallback(new PinchToZoomHelper.Callback() { // from class: org.rbmain.ui.ProfileActivity.23
            @Override // org.rbmain.ui.PinchToZoomHelper.Callback
            public /* synthetic */ TextureView getCurrentTextureView() {
                return PinchToZoomHelper.Callback.CC.$default$getCurrentTextureView(this);
            }

            @Override // org.rbmain.ui.PinchToZoomHelper.Callback
            public /* synthetic */ void onZoomFinished(MessageObject messageObject) {
                PinchToZoomHelper.Callback.CC.$default$onZoomFinished(this, messageObject);
            }

            @Override // org.rbmain.ui.PinchToZoomHelper.Callback
            public void onZoomStarted(MessageObject messageObject) {
                ProfileActivity.this.listView.cancelClickRunnables(true);
                if (ProfileActivity.this.sharedMediaLayout != null && ProfileActivity.this.sharedMediaLayout.getCurrentListView() != null) {
                    ProfileActivity.this.sharedMediaLayout.getCurrentListView().cancelClickRunnables(true);
                }
                Bitmap bitmap = ProfileActivity.this.pinchToZoomHelper.getPhotoImage() == null ? null : ProfileActivity.this.pinchToZoomHelper.getPhotoImage().getBitmap();
                if (bitmap != null) {
                    ProfileActivity.this.topView.setBackgroundColor(ColorUtils.blendARGB(AndroidUtilities.calcBitmapColor(bitmap), Theme.getColor(Theme.key_windowBackgroundWhite), 0.1f));
                }
            }
        });
        this.avatarsViewPager.setPinchToZoomHelper(this.pinchToZoomHelper);
        return this.fragmentView;
    }

    /* renamed from: org.rbmain.ui.ProfileActivity$4, reason: invalid class name */
    class AnonymousClass4 extends ActionBar.ActionBarMenuOnItemClick {
        AnonymousClass4() {
        }

        @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
        public void onItemClick(int i) throws IllegalAccessException, NoSuchFieldException, Resources.NotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException {
            String str;
            int i2;
            long j;
            if (ProfileActivity.this.getParentActivity() == null) {
                return;
            }
            if (i == -1) {
                ProfileActivity.this.finishFragment();
                return;
            }
            String str2 = null;
            String absolutePath = null;
            if (i == 2) {
                TLRPC$User user = ProfileActivity.this.getMessagesController().getUser(Integer.valueOf(ProfileActivity.this.user_id));
                if (user == null) {
                    return;
                }
                if (!ProfileActivity.this.isBot || MessagesController.isSupportUser(user)) {
                    if (ProfileActivity.this.userBlocked) {
                        ProfileActivity.this.getMessagesController().unblockPeer(ProfileActivity.this.user_id);
                        if (BulletinFactory.canShowBulletin(ProfileActivity.this)) {
                            BulletinFactory.createBanBulletin(ProfileActivity.this, false).show();
                            return;
                        }
                        return;
                    }
                    if (ProfileActivity.this.reportSpam) {
                        AlertsCreator.showBlockReportSpamAlert(ProfileActivity.this, r9.user_id, user, null, ProfileActivity.this.currentEncryptedChat, false, null, new MessagesStorage.IntCallback() { // from class: org.rbmain.ui.ProfileActivity$4$$ExternalSyntheticLambda6
                            @Override // org.rbmain.messenger.MessagesStorage.IntCallback
                            public final void run(int i3) {
                                this.f$0.lambda$onItemClick$0(i3);
                            }
                        });
                        return;
                    }
                    AlertDialog.Builder builder = new AlertDialog.Builder(ProfileActivity.this.getParentActivity());
                    builder.setTitle(LocaleController.getString("BlockUser", R.string.BlockUser));
                    builder.setMessage(AndroidUtilities.replaceTags(LocaleController.formatString("AreYouSureBlockContact2", R.string.AreYouSureBlockContact2, ContactsController.formatName(user.first_name, user.last_name))));
                    builder.setPositiveButton(LocaleController.getString("BlockContact", R.string.BlockContact), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.ProfileActivity$4$$ExternalSyntheticLambda1
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i3) {
                            this.f$0.lambda$onItemClick$1(dialogInterface, i3);
                        }
                    });
                    builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                    AlertDialog alertDialogCreate = builder.create();
                    ProfileActivity.this.showDialog(alertDialogCreate);
                    TextView textView = (TextView) alertDialogCreate.getButton(-1);
                    if (textView != null) {
                        textView.setTextColor(Theme.getColor(Theme.key_text_RedBold));
                        return;
                    }
                    return;
                }
                if (!ProfileActivity.this.userBlocked) {
                    ProfileActivity.this.getMessagesController().blockPeer(ProfileActivity.this.user_id);
                    return;
                }
                ProfileActivity.this.getMessagesController().unblockPeer(ProfileActivity.this.user_id);
                ProfileActivity.this.getSendMessagesHelper().sendMessage("/start", ProfileActivity.this.user_id, (MessageObject) null, (MessageObject) null, (TLRPC$WebPage) null, false, (ArrayList<TLRPC$MessageEntity>) null, (TLRPC$ReplyMarkup) null, (HashMap<String, String>) null, true, 0);
                ProfileActivity.this.finishFragment();
                return;
            }
            if (i == 1) {
                TLRPC$User user2 = ProfileActivity.this.getMessagesController().getUser(Integer.valueOf(ProfileActivity.this.user_id));
                Bundle bundle = new Bundle();
                bundle.putInt("user_id", user2.id);
                bundle.putBoolean("addContact", true);
                ProfileActivity.this.presentFragment(new ContactAddActivity(bundle));
                return;
            }
            if (i == 3) {
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
            if (i == 4) {
                Bundle bundle3 = new Bundle();
                bundle3.putInt("user_id", ProfileActivity.this.user_id);
                ProfileActivity.this.presentFragment(new ContactAddActivity(bundle3));
                return;
            }
            if (i == 5) {
                final TLRPC$User user3 = ProfileActivity.this.getMessagesController().getUser(Integer.valueOf(ProfileActivity.this.user_id));
                if (user3 == null || ProfileActivity.this.getParentActivity() == null) {
                    return;
                }
                AlertDialog.Builder builder2 = new AlertDialog.Builder(ProfileActivity.this.getParentActivity());
                builder2.setTitle(LocaleController.getString("DeleteContact", R.string.DeleteContact));
                builder2.setMessage(LocaleController.getString("AreYouSureDeleteContact", R.string.AreYouSureDeleteContact));
                builder2.setPositiveButton(LocaleController.getString("Delete", R.string.Delete), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.ProfileActivity$4$$ExternalSyntheticLambda3
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        this.f$0.lambda$onItemClick$2(user3, dialogInterface, i3);
                    }
                });
                builder2.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                AlertDialog alertDialogCreate2 = builder2.create();
                ProfileActivity.this.showDialog(alertDialogCreate2);
                TextView textView2 = (TextView) alertDialogCreate2.getButton(-1);
                if (textView2 != null) {
                    textView2.setTextColor(Theme.getColor(Theme.key_text_RedBold));
                    return;
                }
                return;
            }
            if (i == 7) {
                ProfileActivity.this.leaveChatPressed();
                return;
            }
            if (i == 12) {
                Bundle bundle4 = new Bundle();
                bundle4.putInt("chat_id", ProfileActivity.this.chat_id);
                ChatEditActivity chatEditActivity = new ChatEditActivity(bundle4);
                chatEditActivity.setInfo(ProfileActivity.this.chatInfo);
                ProfileActivity.this.presentFragment(chatEditActivity);
                return;
            }
            if (i == 9) {
                final TLRPC$User user4 = ProfileActivity.this.getMessagesController().getUser(Integer.valueOf(ProfileActivity.this.user_id));
                if (user4 == null) {
                    return;
                }
                Bundle bundle5 = new Bundle();
                bundle5.putBoolean("onlySelect", true);
                bundle5.putInt("dialogsType", 2);
                bundle5.putString("addToGroupAlertString", LocaleController.formatString("AddToTheGroupAlertText", R.string.AddToTheGroupAlertText, UserObject.getUserName(user4), "%1$s"));
                DialogsActivity dialogsActivity2 = new DialogsActivity(bundle5);
                dialogsActivity2.setDelegate(new DialogsActivity.DialogsActivityDelegate() { // from class: org.rbmain.ui.ProfileActivity$4$$ExternalSyntheticLambda8
                    @Override // org.rbmain.ui.DialogsActivity.DialogsActivityDelegate
                    public final void didSelectDialogs(DialogsActivity dialogsActivity3, ArrayList arrayList, CharSequence charSequence, boolean z) {
                        this.f$0.lambda$onItemClick$3(user4, dialogsActivity3, arrayList, charSequence, z);
                    }
                });
                ProfileActivity.this.presentFragment(dialogsActivity2);
                return;
            }
            if (i == 10) {
                try {
                    if (ProfileActivity.this.user_id != 0) {
                        TLRPC$User user5 = ProfileActivity.this.getMessagesController().getUser(Integer.valueOf(ProfileActivity.this.user_id));
                        if (user5 == null) {
                            return;
                        }
                        if (ProfileActivity.this.botInfo != null && ProfileActivity.this.userInfo != null && !TextUtils.isEmpty(ProfileActivity.this.userInfo.about)) {
                            str = String.format("%s https://" + ProfileActivity.this.getMessagesController().linkPrefix + "/%s", ProfileActivity.this.userInfo.about, user5.username);
                        } else {
                            str = String.format("https://" + ProfileActivity.this.getMessagesController().linkPrefix + "/%s", user5.username);
                        }
                        str2 = str;
                    } else if (ProfileActivity.this.chat_id != 0) {
                        TLRPC$Chat chat = ProfileActivity.this.getMessagesController().getChat(Integer.valueOf(ProfileActivity.this.chat_id));
                        if (chat == null) {
                            return;
                        }
                        if (ProfileActivity.this.chatInfo != null && !TextUtils.isEmpty(ProfileActivity.this.chatInfo.about)) {
                            str2 = String.format("%s\nhttps://" + ProfileActivity.this.getMessagesController().linkPrefix + "/%s", ProfileActivity.this.chatInfo.about, chat.username);
                        } else {
                            str2 = String.format("https://" + ProfileActivity.this.getMessagesController().linkPrefix + "/%s", chat.username);
                        }
                    }
                    if (TextUtils.isEmpty(str2)) {
                        return;
                    }
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.setType("text/plain");
                    intent.putExtra("android.intent.extra.TEXT", str2);
                    ProfileActivity.this.startActivityForResult(Intent.createChooser(intent, LocaleController.getString("BotShare", R.string.BotShare)), HttpStatus.HTTP_INTERNAL_SERVER_ERROR);
                    return;
                } catch (Exception e) {
                    FileLog.e(e);
                    return;
                }
            }
            if (i == 14) {
                try {
                    if (ProfileActivity.this.currentEncryptedChat != null) {
                        j = ProfileActivity.this.currentEncryptedChat.id << 32;
                    } else {
                        if (ProfileActivity.this.user_id != 0) {
                            i2 = ProfileActivity.this.user_id;
                        } else if (ProfileActivity.this.chat_id == 0) {
                            return;
                        } else {
                            i2 = -ProfileActivity.this.chat_id;
                        }
                        j = i2;
                    }
                    ProfileActivity.this.getMediaDataController().installShortcut(j);
                    return;
                } catch (Exception e2) {
                    FileLog.e(e2);
                    return;
                }
            }
            if (i == 15 || i == 16) {
                if (ProfileActivity.this.user_id != 0) {
                    TLRPC$User user6 = ProfileActivity.this.getMessagesController().getUser(Integer.valueOf(ProfileActivity.this.user_id));
                    if (user6 != null) {
                        VoIPHelper.startCall(user6, i == 16, ProfileActivity.this.userInfo != null && ProfileActivity.this.userInfo.video_calls_available, ProfileActivity.this.getParentActivity(), ProfileActivity.this.userInfo, ProfileActivity.this.getAccountInstance());
                        return;
                    }
                    return;
                }
                if (ProfileActivity.this.chat_id != 0) {
                    if (ProfileActivity.this.getMessagesController().getGroupCall(ProfileActivity.this.chat_id, false) != null) {
                        TLRPC$Chat tLRPC$Chat = ProfileActivity.this.currentChat;
                        Activity parentActivity = ProfileActivity.this.getParentActivity();
                        ProfileActivity profileActivity = ProfileActivity.this;
                        VoIPHelper.startCall(tLRPC$Chat, null, null, false, parentActivity, profileActivity, profileActivity.getAccountInstance());
                        return;
                    }
                    ProfileActivity profileActivity2 = ProfileActivity.this;
                    VoIPHelper.showGroupCallAlert(profileActivity2, profileActivity2.currentChat, null, false, ProfileActivity.this.getAccountInstance());
                    return;
                }
                return;
            }
            if (i == 17) {
                Bundle bundle6 = new Bundle();
                bundle6.putInt("chat_id", ProfileActivity.this.chat_id);
                bundle6.putInt("type", 2);
                bundle6.putBoolean("open_search", true);
                ChatUsersActivity chatUsersActivity = new ChatUsersActivity(bundle6);
                chatUsersActivity.setInfo(ProfileActivity.this.chatInfo);
                ProfileActivity.this.presentFragment(chatUsersActivity);
                return;
            }
            if (i == 18) {
                ProfileActivity.this.openAddMember();
                return;
            }
            if (i == 19) {
                TLRPC$Chat chat2 = ProfileActivity.this.getMessagesController().getChat(Integer.valueOf(ProfileActivity.this.chat_id));
                Bundle bundle7 = new Bundle();
                bundle7.putInt("chat_id", ProfileActivity.this.chat_id);
                bundle7.putBoolean("is_megagroup", chat2.megagroup);
                ProfileActivity.this.presentFragment(new StatisticActivity(bundle7));
                return;
            }
            if (i == 22) {
                ProfileActivity.this.openDiscussion();
                return;
            }
            if (i == 20) {
                AlertDialog.Builder builder3 = new AlertDialog.Builder(ProfileActivity.this.getParentActivity());
                builder3.setTitle(LocaleController.getString("AreYouSureSecretChatTitle", R.string.AreYouSureSecretChatTitle));
                builder3.setMessage(LocaleController.getString("AreYouSureSecretChat", R.string.AreYouSureSecretChat));
                builder3.setPositiveButton(LocaleController.getString("Start", R.string.Start), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.ProfileActivity$4$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        this.f$0.lambda$onItemClick$4(dialogInterface, i3);
                    }
                });
                builder3.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                ProfileActivity.this.showDialog(builder3.create());
                return;
            }
            if (i == 21) {
                if (ProfileActivity.this.getParentActivity() == null) {
                    return;
                }
                if (Build.VERSION.SDK_INT < 23 || ProfileActivity.this.getParentActivity().checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                    ImageLocation imageLocation = ProfileActivity.this.avatarsViewPager.getImageLocation(ProfileActivity.this.avatarsViewPager.getRealPosition());
                    if (imageLocation == null) {
                        return;
                    }
                    final boolean z = imageLocation.imageType == 2;
                    File pathToAttach = FileLoader.getPathToAttach(imageLocation.location, z ? "mp4" : null, true);
                    if (pathToAttach.exists()) {
                        MediaController.saveFile(pathToAttach.toString(), ProfileActivity.this.getParentActivity(), 0, null, null, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$4$$ExternalSyntheticLambda5
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$onItemClick$5(z);
                            }
                        });
                        return;
                    }
                    return;
                }
                ProfileActivity.this.getParentActivity().requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 4);
                return;
            }
            if (i == 30) {
                ProfileActivity.this.presentFragment(new ChangeNameActivity());
                return;
            }
            if (i == 38) {
                ProfileActivity.this.presentFragment(new LanguageSelectActivity());
                return;
            }
            if (i == 31) {
                ProfileActivity.this.presentFragment(new LogoutActivity());
                return;
            }
            if (i == 37) {
                ProfileActivity.this.presentFragment(new AccountsActivity());
                return;
            }
            if (i == 33) {
                int realPosition = ProfileActivity.this.avatarsViewPager.getRealPosition();
                final TLRPC$Photo photo = ProfileActivity.this.avatarsViewPager.getPhoto(realPosition);
                if (photo == null) {
                    return;
                }
                ProfileActivity.this.avatarsViewPager.startMovePhotoToBegin(realPosition);
                TLRPC$TL_photos_updateProfilePhoto tLRPC$TL_photos_updateProfilePhoto = new TLRPC$TL_photos_updateProfilePhoto();
                TLRPC$TL_inputPhoto tLRPC$TL_inputPhoto = new TLRPC$TL_inputPhoto();
                tLRPC$TL_photos_updateProfilePhoto.id = tLRPC$TL_inputPhoto;
                tLRPC$TL_inputPhoto.id = photo.id;
                tLRPC$TL_inputPhoto.access_hash = photo.access_hash;
                tLRPC$TL_inputPhoto.file_reference = photo.file_reference;
                long j2 = photo.main_file_id;
                tLRPC$TL_inputPhoto.main_id = j2;
                tLRPC$TL_inputPhoto.thumb_id = j2;
                final UserConfig userConfig = ProfileActivity.this.getUserConfig();
                ProfileActivity.this.getFileProxy().setAsMainAvatar(tLRPC$TL_photos_updateProfilePhoto, new RequestDelegate() { // from class: org.rbmain.ui.ProfileActivity$4$$ExternalSyntheticLambda7
                    @Override // org.rbmain.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$onItemClick$7(userConfig, photo, tLObject, tLRPC$TL_error);
                    }
                });
                ProfileActivity.this.undoView.showWithAction(ProfileActivity.this.user_id, 22, photo.video_sizes.isEmpty() ? null : 1);
                TLRPC$User user7 = ProfileActivity.this.getMessagesController().getUser(Integer.valueOf(userConfig.clientUserId));
                TLRPC$PhotoSize closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(photo.sizes, MediaController.MAX_WIDTH_HEIGHT_SIZE);
                if (user7 != null) {
                    TLRPC$PhotoSize closestPhotoSizeWithSize2 = FileLoader.getClosestPhotoSizeWithSize(photo.sizes, 90);
                    TLRPC$UserProfilePhoto tLRPC$UserProfilePhoto = user7.photo;
                    tLRPC$UserProfilePhoto.photo_id = photo.id;
                    tLRPC$UserProfilePhoto.photo_small = closestPhotoSizeWithSize2.location;
                    tLRPC$UserProfilePhoto.photo_big = closestPhotoSizeWithSize.location;
                    userConfig.setCurrentUser(user7);
                    userConfig.saveConfig(true);
                    NotificationCenter.getInstance(((BaseFragment) ProfileActivity.this).currentAccount).postNotificationName(NotificationCenter.mainUserInfoChanged, new Object[0]);
                    ProfileActivity.this.updateProfileData();
                }
                ProfileActivity.this.avatarsViewPager.commitMoveToBegin();
                return;
            }
            if (i == 34) {
                int realPosition2 = ProfileActivity.this.avatarsViewPager.getRealPosition();
                ImageLocation imageLocation2 = ProfileActivity.this.avatarsViewPager.getImageLocation(realPosition2);
                if (imageLocation2 == null) {
                    return;
                }
                File pathToAttach2 = FileLoader.getPathToAttach(PhotoViewer.getFileLocation(imageLocation2), PhotoViewer.getFileLocationExt(imageLocation2), true);
                boolean z2 = imageLocation2.imageType == 2;
                if (z2) {
                    ImageLocation realImageLocation = ProfileActivity.this.avatarsViewPager.getRealImageLocation(realPosition2);
                    absolutePath = FileLoader.getPathToAttach(PhotoViewer.getFileLocation(realImageLocation), PhotoViewer.getFileLocationExt(realImageLocation), true).getAbsolutePath();
                }
                ProfileActivity.this.imageUpdater.openPhotoForEdit(pathToAttach2.getAbsolutePath(), absolutePath, 0, z2);
                return;
            }
            if (i != 35) {
                if (i == 36) {
                    ProfileActivity.this.onWriteButtonClick();
                    return;
                }
                return;
            }
            AlertDialog.Builder builder4 = new AlertDialog.Builder(ProfileActivity.this.getParentActivity());
            ImageLocation imageLocation3 = ProfileActivity.this.avatarsViewPager.getImageLocation(ProfileActivity.this.avatarsViewPager.getRealPosition());
            if (imageLocation3 == null) {
                return;
            }
            if (imageLocation3.imageType == 2) {
                builder4.setTitle(LocaleController.getString("AreYouSureDeleteVideoTitle", R.string.AreYouSureDeleteVideoTitle));
                builder4.setMessage(LocaleController.formatString("AreYouSureDeleteVideo", R.string.AreYouSureDeleteVideo, new Object[0]));
            } else {
                builder4.setTitle(LocaleController.getString("AreYouSureDeletePhotoTitle", R.string.AreYouSureDeletePhotoTitle));
                builder4.setMessage(LocaleController.formatString("AreYouSureDeletePhoto", R.string.AreYouSureDeletePhoto, new Object[0]));
            }
            builder4.setPositiveButton(LocaleController.getString("Delete", R.string.Delete), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.ProfileActivity$4$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    this.f$0.lambda$onItemClick$8(dialogInterface, i3);
                }
            });
            builder4.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            AlertDialog alertDialogCreate3 = builder4.create();
            ProfileActivity.this.showDialog(alertDialogCreate3);
            TextView textView3 = (TextView) alertDialogCreate3.getButton(-1);
            if (textView3 != null) {
                textView3.setTextColor(Theme.getColor(Theme.key_text_RedBold));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onItemClick$0(int i) {
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
            ProfileActivity.this.getNotificationCenter().postNotificationName(NotificationCenter.peerSettingsDidLoad, Long.valueOf(ProfileActivity.this.user_id));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onItemClick$1(DialogInterface dialogInterface, int i) {
            ProfileActivity.this.getMessagesController().blockPeer(ProfileActivity.this.user_id);
            if (BulletinFactory.canShowBulletin(ProfileActivity.this)) {
                BulletinFactory.createBanBulletin(ProfileActivity.this, true).show();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onItemClick$2(TLRPC$User tLRPC$User, DialogInterface dialogInterface, int i) {
            ArrayList<TLRPC$User> arrayList = new ArrayList<>();
            arrayList.add(tLRPC$User);
            ProfileActivity.this.getContactsController().deleteContact(arrayList, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onItemClick$3(TLRPC$User tLRPC$User, DialogsActivity dialogsActivity, ArrayList arrayList, CharSequence charSequence, boolean z) {
            long jLongValue = ((Long) arrayList.get(0)).longValue();
            Bundle bundle = new Bundle();
            bundle.putBoolean("scrollToTopOnResume", true);
            int i = -((int) jLongValue);
            bundle.putInt("chat_id", i);
            if (ProfileActivity.this.getMessagesController().checkCanOpenChat(bundle, dialogsActivity)) {
                NotificationCenter notificationCenter = ProfileActivity.this.getNotificationCenter();
                ProfileActivity profileActivity = ProfileActivity.this;
                int i2 = NotificationCenter.closeChats;
                notificationCenter.removeObserver(profileActivity, i2);
                ProfileActivity.this.getNotificationCenter().postNotificationName(i2, new Object[0]);
                ProfileActivity.this.getMessagesController().addUserToChat(i, tLRPC$User, 0, null, ProfileActivity.this, null);
                ProfileActivity.this.presentFragment(new ChatActivity(bundle), true);
                ProfileActivity.this.removeSelfFromStack();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onItemClick$4(DialogInterface dialogInterface, int i) {
            ProfileActivity.this.creatingChat = true;
            ProfileActivity.this.getSecretChatHelper().startSecretChat(ProfileActivity.this.getParentActivity(), ProfileActivity.this.getMessagesController().getUser(Integer.valueOf(ProfileActivity.this.user_id)));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onItemClick$5(boolean z) {
            if (ProfileActivity.this.getParentActivity() == null) {
                return;
            }
            BulletinFactory.createSaveToGalleryBulletin(ProfileActivity.this, z).show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onItemClick$7(final UserConfig userConfig, final TLRPC$Photo tLRPC$Photo, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ProfileActivity$4$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onItemClick$6(tLObject, userConfig, tLRPC$Photo);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onItemClick$6(TLObject tLObject, UserConfig userConfig, TLRPC$Photo tLRPC$Photo) {
            ProfileActivity.this.avatarsViewPager.finishSettingMainPhoto();
            if (tLObject instanceof TLRPC$TL_photos_photo) {
                TLRPC$TL_photos_photo tLRPC$TL_photos_photo = (TLRPC$TL_photos_photo) tLObject;
                ProfileActivity.this.getMessagesController().putUsers(tLRPC$TL_photos_photo.users, false);
                TLRPC$User user = ProfileActivity.this.getMessagesController().getUser(Integer.valueOf(userConfig.clientUserId));
                if (tLRPC$TL_photos_photo.photo instanceof TLRPC$TL_photo) {
                    ProfileActivity.this.avatarsViewPager.replaceFirstPhoto(tLRPC$Photo, tLRPC$TL_photos_photo.photo);
                    if (user != null) {
                        user.photo.photo_id = tLRPC$TL_photos_photo.photo.id;
                        userConfig.setCurrentUser(user);
                        userConfig.saveConfig(true);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onItemClick$8(DialogInterface dialogInterface, int i) {
            int realPosition = ProfileActivity.this.avatarsViewPager.getRealPosition();
            TLRPC$Photo photo = ProfileActivity.this.avatarsViewPager.getPhoto(realPosition);
            if (ProfileActivity.this.avatarsViewPager.getRealCount() == 1) {
                ProfileActivity.this.setForegroundImage(true);
            }
            if (photo == null) {
                ProfileActivity.this.getMessagesController().deleteUserPhoto(null, false);
            } else {
                TLRPC$TL_inputPhoto tLRPC$TL_inputPhoto = new TLRPC$TL_inputPhoto();
                tLRPC$TL_inputPhoto.id = photo.id;
                tLRPC$TL_inputPhoto.access_hash = photo.access_hash;
                byte[] bArr = photo.file_reference;
                tLRPC$TL_inputPhoto.file_reference = bArr;
                tLRPC$TL_inputPhoto.avatar_id = photo.avatr_id;
                if (bArr == null) {
                    tLRPC$TL_inputPhoto.file_reference = new byte[0];
                }
                ProfileActivity.this.getMessagesController().deleteUserPhoto(tLRPC$TL_inputPhoto, ProfileActivity.this.avatarsViewPager.getRealPosition() == 0);
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

    /* renamed from: org.rbmain.ui.ProfileActivity$7, reason: invalid class name */
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
            this.viewComparator = new Comparator() { // from class: org.rbmain.ui.ProfileActivity$7$$ExternalSyntheticLambda0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return ProfileActivity.AnonymousClass7.lambda$$0((View) obj, (View) obj2);
                }
            };
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            if (ProfileActivity.this.pinchToZoomHelper.isInOverlayMode()) {
                return ProfileActivity.this.pinchToZoomHelper.onTouchEvent(motionEvent);
            }
            return super.dispatchTouchEvent(motionEvent);
        }

        /* JADX WARN: Removed duplicated region for block: B:130:0x0461  */
        /* JADX WARN: Removed duplicated region for block: B:132:0x046c  */
        @Override // android.widget.FrameLayout, android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected void onMeasure(int r17, int r18) {
            /*
                Method dump skipped, instructions count: 1187
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.ProfileActivity.AnonymousClass7.onMeasure(int, int):void");
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
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

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int lambda$$0(View view, View view2) {
            return (int) (view.getY() - view2.getY());
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            FragmentContextView fragmentContextView;
            boolean z;
            int i;
            ProfileActivity.this.whitePaint.setColor(Theme.getColor(Theme.key_windowBackgroundWhite));
            if (ProfileActivity.this.listView.getVisibility() != 0) {
                canvas.drawRect(0.0f, ProfileActivity.this.searchListView.getTop() + ProfileActivity.this.extraHeight + ProfileActivity.this.searchTransitionOffset, getMeasuredWidth(), r1 + getMeasuredHeight(), ProfileActivity.this.whitePaint);
            } else {
                this.grayPaint.setColor(Theme.getColor(Theme.key_windowBackgroundGray));
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
        protected boolean drawChild(Canvas canvas, View view, long j) {
            if (ProfileActivity.this.pinchToZoomHelper.isInOverlayMode() && (view == ProfileActivity.this.avatarContainer2 || view == ((BaseFragment) ProfileActivity.this).actionBar || view == ProfileActivity.this.writeButton)) {
                return true;
            }
            return super.drawChild(canvas, view, j);
        }
    }

    /* renamed from: org.rbmain.ui.ProfileActivity$9, reason: invalid class name */
    class AnonymousClass9 extends DefaultItemAnimator {
        int animationIndex = -1;

        @Override // androidx.recyclerview.widget.DefaultItemAnimator
        protected long getAddAnimationDelay(long j, long j2, long j3) {
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
                valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.ProfileActivity$9$$ExternalSyntheticLambda0
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        this.f$0.lambda$runPendingAnimations$0(valueAnimator);
                    }
                });
                valueAnimatorOfFloat.setDuration(getMoveDuration());
                valueAnimatorOfFloat.start();
                this.animationIndex = ProfileActivity.this.getNotificationCenter().setAnimationInProgress(this.animationIndex, null);
            }
            super.runPendingAnimations();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$runPendingAnimations$0(ValueAnimator valueAnimator) {
            ProfileActivity.this.listView.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$2(long j, View view, int i, float f, float f2) throws IOException {
        TLRPC$ChatParticipant tLRPC$ChatParticipant;
        if (getParentActivity() == null) {
            return;
        }
        if (i == this.settingsKeyRow) {
            Bundle bundle = new Bundle();
            bundle.putInt("chat_id", (int) (this.dialog_id >> 32));
            presentFragment(new IdenticonActivity(bundle));
            return;
        }
        if (i == this.settingsTimerRow) {
            showDialog(AlertsCreator.createTTLAlert(getParentActivity(), this.currentEncryptedChat).create());
            return;
        }
        if (i == this.notificationsRow) {
            if (view instanceof NotificationsCheckCell) {
                String dialogId = IdStorage.getInstance().getDialogId(j);
                NotificationsCheckCell notificationsCheckCell = (NotificationsCheckCell) view;
                boolean z = !notificationsCheckCell.isChecked();
                boolean zIsGlobalNotificationsEnabled = getNotificationsController().isGlobalNotificationsEnabled(j);
                long j2 = 0;
                if (z) {
                    SharedPreferences.Editor editorEdit = MessagesController.getNotificationsSettings(this.currentAccount).edit();
                    if (zIsGlobalNotificationsEnabled) {
                        editorEdit.remove(NotificationsSettingsFacade.PROPERTY_NOTIFY + j);
                        editorEdit.remove(NotificationsSettingsFacade.PROPERTY_NOTIFY + dialogId);
                    } else {
                        editorEdit.putInt(NotificationsSettingsFacade.PROPERTY_NOTIFY + j, 0);
                        editorEdit.putInt(NotificationsSettingsFacade.PROPERTY_NOTIFY + dialogId, 0);
                    }
                    getMessagesStorage().setDialogFlags(j, 0L);
                    editorEdit.apply();
                    TLRPC$Dialog tLRPC$Dialog = getMessagesController().dialogs_dict.get(j);
                    if (tLRPC$Dialog != null) {
                        tLRPC$Dialog.notify_settings = new TLRPC$TL_peerNotifySettings();
                    }
                } else {
                    SharedPreferences.Editor editorEdit2 = MessagesController.getNotificationsSettings(this.currentAccount).edit();
                    if (!zIsGlobalNotificationsEnabled) {
                        editorEdit2.remove(NotificationsSettingsFacade.PROPERTY_NOTIFY + j);
                        editorEdit2.remove(NotificationsSettingsFacade.PROPERTY_NOTIFY + dialogId);
                    } else {
                        editorEdit2.putInt(NotificationsSettingsFacade.PROPERTY_NOTIFY + j, 2);
                        editorEdit2.putInt(NotificationsSettingsFacade.PROPERTY_NOTIFY + dialogId, 2);
                        j2 = 1;
                    }
                    getNotificationsController().removeNotificationsForDialog(j);
                    getMessagesStorage().setDialogFlags(j, j2);
                    editorEdit2.apply();
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
            return;
        }
        if (i == this.unblockRow) {
            getMessagesController().unblockPeer(this.user_id);
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
            AlertsCreator.createReportAlert(getParentActivity(), getDialogId(), 0L, this, null);
            return;
        }
        if (i >= this.membersStartRow && i < this.membersEndRow) {
            if (!this.visibleSortedUsers.isEmpty()) {
                tLRPC$ChatParticipant = this.chatInfo.participants.participants.get(this.visibleSortedUsers.get(i - this.membersStartRow).intValue());
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
                    intent.putExtra("android.intent.extra.TEXT", "https://" + getMessagesController().linkPrefix + "/" + this.currentChat.username);
                    getParentActivity().startActivityForResult(Intent.createChooser(intent, LocaleController.getString("BotShare", R.string.BotShare)), HttpStatus.HTTP_INTERNAL_SERVER_ERROR);
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
                LocationActivity locationActivity = new LocationActivity(5);
                locationActivity.setChatLocation(this.chat_id, (TLRPC$TL_channelLocation) this.chatInfo.location);
                presentFragment(locationActivity);
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
            bundle2.putInt("chat_id", this.chat_id);
            bundle2.putInt("type", 2);
            ChatUsersActivity chatUsersActivity = new ChatUsersActivity(bundle2);
            chatUsersActivity.setInfo(this.chatInfo);
            presentFragment(chatUsersActivity);
            return;
        }
        if (i == this.administratorsRow) {
            Bundle bundle3 = new Bundle();
            bundle3.putInt("chat_id", this.chat_id);
            bundle3.putInt("type", 1);
            ChatUsersActivity chatUsersActivity2 = new ChatUsersActivity(bundle3);
            chatUsersActivity2.setInfo(this.chatInfo);
            presentFragment(chatUsersActivity2);
            return;
        }
        if (i == this.blockedUsersRow) {
            Bundle bundle4 = new Bundle();
            bundle4.putInt("chat_id", this.chat_id);
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
            return;
        }
        if (i == this.faqRow) {
            Browser.openUrl(getParentActivity(), LocaleController.getString("RubikaFaqUrl", R.string.RubikaFaqUrl));
            return;
        }
        if (i == this.policyRow) {
            Browser.openUrl(getParentActivity(), LocaleController.getString("PrivacyPolicyUrl", R.string.PrivacyPolicyUrl));
            return;
        }
        if (i == this.sendLogsRow) {
            sendLogs();
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
            builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.ProfileActivity$$ExternalSyntheticLambda3
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$createView$1(dialogInterface, i2);
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
                return;
            }
            return;
        }
        if (i == this.numberRow) {
            presentFragment(new ActionIntroActivity(3));
            return;
        }
        if (i == this.setAvatarRow) {
            onWriteButtonClick();
            return;
        }
        int i2 = this.itemLinksStartRow;
        if (i >= i2 && i < this.itemLinksEndRow) {
            int i3 = i - i2;
            ArrayList<ProfileLinkItemObject> arrayList = this.profileItems;
            if (arrayList == null || arrayList.size() <= i3) {
                return;
            }
            AccountInstance.getInstance(this.currentAccount).getMessengerLinkHandler().onLinkClick(this.profileItems.get(i3).link);
            return;
        }
        int i4 = this.otherPartsStartRow;
        if (i >= i4 && i <= this.otherPartsEndRow) {
            try {
                SettingItem2 settingItem2 = this.settingsParts.get(i - i4);
                if (settingItem2 == null || settingItem2.type != SettingItem2.TypeEnum.Simple || settingItem2.link == null) {
                    return;
                }
                getMessengerLinkHandler().onLinkClick((BaseFragment) null, settingItem2.link);
                return;
            } catch (Exception unused) {
                return;
            }
        }
        if (i == this.rubinoRow) {
            if (this.rubinoProfile == null || !ChildLockCheck.canOpenRubinoWithAlert()) {
                return;
            }
            new MainClickHandler().onRubinoProfileClick(this.rubinoProfile);
            return;
        }
        processOnClickOrPress(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$1(DialogInterface dialogInterface, int i) {
        SharedConfig.pushAuthKey = null;
        SharedConfig.pushAuthKeyId = null;
        SharedConfig.saveConfig();
        getConnectionsManager().switchBackend();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$createView$3(android.view.View r8, int r9) {
        /*
            r7 = this;
            if (r9 >= 0) goto L3
            return
        L3:
            int r8 = r7.numberRow
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            org.rbmain.ui.ProfileActivity$SearchAdapter r0 = r7.searchAdapter
            boolean r0 = org.rbmain.ui.ProfileActivity.SearchAdapter.access$22700(r0)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L50
            org.rbmain.ui.ProfileActivity$SearchAdapter r0 = r7.searchAdapter
            java.util.ArrayList r0 = org.rbmain.ui.ProfileActivity.SearchAdapter.access$22800(r0)
            int r0 = r0.size()
            if (r9 >= r0) goto L2b
            org.rbmain.ui.ProfileActivity$SearchAdapter r8 = r7.searchAdapter
            java.util.ArrayList r8 = org.rbmain.ui.ProfileActivity.SearchAdapter.access$22800(r8)
            java.lang.Object r8 = r8.get(r9)
            goto L9d
        L2b:
            org.rbmain.ui.ProfileActivity$SearchAdapter r0 = r7.searchAdapter
            java.util.ArrayList r0 = org.rbmain.ui.ProfileActivity.SearchAdapter.access$22800(r0)
            int r0 = r0.size()
            int r0 = r0 + r2
            int r9 = r9 - r0
            if (r9 < 0) goto L9d
            org.rbmain.ui.ProfileActivity$SearchAdapter r0 = r7.searchAdapter
            java.util.ArrayList r0 = org.rbmain.ui.ProfileActivity.SearchAdapter.access$22900(r0)
            int r0 = r0.size()
            if (r9 >= r0) goto L9d
            org.rbmain.ui.ProfileActivity$SearchAdapter r8 = r7.searchAdapter
            java.util.ArrayList r8 = org.rbmain.ui.ProfileActivity.SearchAdapter.access$22900(r8)
            java.lang.Object r8 = r8.get(r9)
            goto L9d
        L50:
            org.rbmain.ui.ProfileActivity$SearchAdapter r0 = r7.searchAdapter
            java.util.ArrayList r0 = org.rbmain.ui.ProfileActivity.SearchAdapter.access$22600(r0)
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L5e
            int r9 = r9 + (-1)
        L5e:
            if (r9 < 0) goto L77
            org.rbmain.ui.ProfileActivity$SearchAdapter r0 = r7.searchAdapter
            java.util.ArrayList r0 = org.rbmain.ui.ProfileActivity.SearchAdapter.access$22600(r0)
            int r0 = r0.size()
            if (r9 >= r0) goto L77
            org.rbmain.ui.ProfileActivity$SearchAdapter r8 = r7.searchAdapter
            java.util.ArrayList r8 = org.rbmain.ui.ProfileActivity.SearchAdapter.access$22600(r8)
            java.lang.Object r8 = r8.get(r9)
            goto L9d
        L77:
            org.rbmain.ui.ProfileActivity$SearchAdapter r0 = r7.searchAdapter
            java.util.ArrayList r0 = org.rbmain.ui.ProfileActivity.SearchAdapter.access$22600(r0)
            int r0 = r0.size()
            int r0 = r0 + r2
            int r9 = r9 - r0
            if (r9 < 0) goto L9d
            org.rbmain.ui.ProfileActivity$SearchAdapter r0 = r7.searchAdapter
            java.util.ArrayList r0 = org.rbmain.ui.ProfileActivity.SearchAdapter.access$23000(r0)
            int r0 = r0.size()
            if (r9 >= r0) goto L9d
            org.rbmain.ui.ProfileActivity$SearchAdapter r8 = r7.searchAdapter
            java.util.ArrayList r8 = org.rbmain.ui.ProfileActivity.SearchAdapter.access$23000(r8)
            java.lang.Object r8 = r8.get(r9)
            r9 = 0
            goto L9e
        L9d:
            r9 = 1
        L9e:
            boolean r0 = r8 instanceof org.rbmain.ui.ProfileActivity.SearchAdapter.SearchResult
            if (r0 == 0) goto La9
            r0 = r8
            org.rbmain.ui.ProfileActivity$SearchAdapter$SearchResult r0 = (org.rbmain.ui.ProfileActivity.SearchAdapter.SearchResult) r0
            org.rbmain.ui.ProfileActivity.SearchAdapter.SearchResult.access$23100(r0)
            goto Lca
        La9:
            boolean r0 = r8 instanceof org.rbmain.messenger.MessagesController.FaqSearchResult
            if (r0 == 0) goto Lca
            r0 = r8
            org.rbmain.messenger.MessagesController$FaqSearchResult r0 = (org.rbmain.messenger.MessagesController.FaqSearchResult) r0
            int r3 = r7.currentAccount
            org.rbmain.messenger.NotificationCenter r3 = org.rbmain.messenger.NotificationCenter.getInstance(r3)
            int r4 = org.rbmain.messenger.NotificationCenter.openArticle
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]
            org.rbmain.ui.ProfileActivity$SearchAdapter r6 = r7.searchAdapter
            org.rbmain.tgnet.TLRPC$WebPage r6 = org.rbmain.ui.ProfileActivity.SearchAdapter.access$23200(r6)
            r5[r1] = r6
            java.lang.String r0 = r0.url
            r5[r2] = r0
            r3.postNotificationName(r4, r5)
        Lca:
            if (r9 == 0) goto Ld3
            if (r8 == 0) goto Ld3
            org.rbmain.ui.ProfileActivity$SearchAdapter r9 = r7.searchAdapter
            r9.addRecent(r8)
        Ld3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.ProfileActivity.lambda$createView$3(android.view.View, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$createView$5(View view, int i) {
        if (this.searchAdapter.isSearchWas() || this.searchAdapter.recentSearches.isEmpty()) {
            return false;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
        builder.setMessage(LocaleController.getString("ClearSearch", R.string.ClearSearch));
        builder.setPositiveButton(LocaleController.getString("ClearButton", R.string.ClearButton).toUpperCase(), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.ProfileActivity$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.f$0.lambda$createView$4(dialogInterface, i2);
            }
        });
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        showDialog(builder.create());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$4(DialogInterface dialogInterface, int i) {
        this.searchAdapter.clearRecent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$6(TLObject tLObject) {
        this.currentChannelParticipant = ((TLRPC$TL_channels_channelParticipant) tLObject).participant;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$7(final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ProfileActivity$$ExternalSyntheticLambda17
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$createView$6(tLObject);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$8(TLRPC$Chat tLRPC$Chat, View view) {
        int i = this.user_id;
        int i2 = this.banFromGroup;
        TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights = tLRPC$Chat.default_banned_rights;
        TLRPC$ChannelParticipant tLRPC$ChannelParticipant = this.currentChannelParticipant;
        ChatRightsEditActivity chatRightsEditActivity = new ChatRightsEditActivity(i, i2, null, tLRPC$TL_chatBannedRights, tLRPC$ChannelParticipant != null ? tLRPC$ChannelParticipant.banned_rights : null, BuildConfig.FLAVOR, 1, true, false);
        chatRightsEditActivity.setDelegate(new ChatRightsEditActivity.ChatRightsEditActivityDelegate() { // from class: org.rbmain.ui.ProfileActivity.14
            @Override // org.rbmain.ui.ChatRightsEditActivity.ChatRightsEditActivityDelegate
            public void didSetRights(int i3, TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights, TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights2, String str) {
                ProfileActivity.this.removeSelfFromStack();
            }
        });
        presentFragment(chatRightsEditActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$9(View view) {
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
    public /* synthetic */ boolean lambda$createView$10(View view) {
        if (this.avatarBig != null) {
            return false;
        }
        openAvatar();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$11(View view) {
        if (this.writeButton.getTag() != null) {
            return;
        }
        onWriteButtonClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$12(ValueAnimator valueAnimator) {
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
            scamDrawable.setColor(ColorUtils.blendARGB(Theme.getColor(Theme.key_avatar_subtitleInProfileBlue), Color.argb(179, 255, 255, 255), fLerp));
        }
        Drawable drawable = this.lockIconDrawable;
        if (drawable != null) {
            drawable.setColorFilter(ColorUtils.blendARGB(Theme.getColor(Theme.key_chat_lockIcon), -1, fLerp), PorterDuff.Mode.MULTIPLY);
        }
        CrossfadeDrawable crossfadeDrawable = this.verifiedCrossfadeDrawable;
        if (crossfadeDrawable != null) {
            crossfadeDrawable.setProgress(fLerp);
        }
        float fDpf2 = AndroidUtilities.dpf2(8.0f);
        float fDpf22 = AndroidUtilities.dpf2(16.0f) - this.nameTextView[1].getLeft();
        if (isRtlLayout()) {
            fDpf22 = ((this.avatarContainer2.getMeasuredWidth() - AndroidUtilities.dpf2(16.0f)) - this.nameTextView[1].getRight()) - ((this.nameTextView[1].getPaint().measureText(this.nameTextView[1].getText().toString()) + this.nameTextView[1].getSideDrawablesSize()) * 0.5f);
        }
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
        if (isRtlLayout()) {
            fDpf24 = ((this.avatarContainer2.getMeasuredWidth() - AndroidUtilities.dpf2(16.0f)) - this.onlineTextView[1].getRight()) - ((this.onlineTextView[1].getPaint().measureText(this.onlineTextView[1].getText().toString()) + this.onlineTextView[1].getSideDrawablesSize()) * 0.5f);
        }
        float fDpf25 = ((this.extraHeight + f) - AndroidUtilities.dpf2(18.0f)) - this.onlineTextView[1].getBottom();
        float f10 = this.onlineX;
        float f11 = this.onlineY;
        float f12 = (f10 * f5) + ((fDpf2 + f10 + ((fDpf24 - f10) / 2.0f)) * f6) + (fDpf24 * f7);
        float f13 = (f5 * f11) + (f6 * (fDpf2 + f11 + ((fDpf25 - f11) / 2.0f))) + (f7 * fDpf25);
        this.nameTextView[1].setTranslationX(f8);
        this.onlineTextView[1].setTranslationX(f12);
        this.nameTextView[1].setTranslationY(f9);
        this.onlineTextView[1].setTranslationY(f13);
        this.mediaCounterTextView.setTranslationX(f12);
        this.mediaCounterTextView.setTranslationY(f13);
        Object tag = this.onlineTextView[1].getTag();
        if (tag instanceof Integer) {
            color = Theme.getColor(((Integer) tag).intValue());
        } else {
            color = Theme.getColor(Theme.key_avatar_subtitleInProfileBlue);
        }
        this.onlineTextView[1].setTextColor(ColorUtils.blendARGB(color, Color.argb(179, 255, 255, 255), fLerp));
        if (this.extraHeight > AndroidUtilities.dp(88.0f)) {
            this.nameTextView[1].setPivotY(AndroidUtilities.lerp(0, r4[1].getMeasuredHeight(), fLerp));
            this.nameTextView[1].setScaleX(AndroidUtilities.lerp(1.12f, 1.67f, fLerp));
            this.nameTextView[1].setScaleY(AndroidUtilities.lerp(1.12f, 1.67f, fLerp));
        }
        needLayoutText(Math.min(1.0f, this.extraHeight / AndroidUtilities.dp(88.0f)));
        this.nameTextView[1].setTextColor(ColorUtils.blendARGB(Theme.getColor(Theme.key_profile_title), -1, fLerp));
        this.actionBar.setItemsColor(ColorUtils.blendARGB(Theme.getColor(Theme.key_actionBarDefaultIcon), -1, fLerp), false);
        this.avatarImage.setForegroundAlpha(fLerp);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.avatarContainer.getLayoutParams();
        layoutParams.width = (int) AndroidUtilities.lerp(AndroidUtilities.dpf2(42.0f), this.listView.getMeasuredWidth() / this.avatarScale, fLerp);
        layoutParams.height = (int) AndroidUtilities.lerp(AndroidUtilities.dpf2(42.0f), (this.extraHeight + f) / this.avatarScale, fLerp);
        if (isRtlLayout()) {
            layoutParams.rightMargin = (int) AndroidUtilities.lerp(AndroidUtilities.dpf2(64.0f), 0.0f, fLerp);
        } else {
            layoutParams.leftMargin = (int) AndroidUtilities.lerp(AndroidUtilities.dpf2(64.0f), 0.0f, fLerp);
        }
        this.avatarContainer.requestLayout();
    }

    public long getDialogId() {
        long j = this.dialog_id;
        if (j != 0) {
            return j;
        }
        int i = this.user_id;
        return i != 0 ? i : -this.chat_id;
    }

    public TLRPC$Chat getCurrentChat() {
        return this.currentChat;
    }

    public TLRPC$UserFull getUserInfo() {
        return this.userInfo;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void openAvatar() {
        /*
            r4 = this;
            org.rbmain.ui.Components.RecyclerListView r0 = r4.listView
            int r0 = r0.getScrollState()
            r1 = 1
            if (r0 != r1) goto La
            return
        La:
            int r0 = r4.user_id
            if (r0 == 0) goto L47
            org.rbmain.messenger.MessagesController r0 = r4.getMessagesController()
            int r1 = r4.user_id
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            org.rbmain.tgnet.TLRPC$User r0 = r0.getUser(r1)
            org.rbmain.tgnet.TLRPC$UserProfilePhoto r1 = r0.photo
            if (r1 == 0) goto Lac
            org.rbmain.tgnet.TLRPC$FileLocation r1 = r1.photo_big
            if (r1 == 0) goto Lac
            org.rbmain.ui.PhotoViewer r1 = org.rbmain.ui.PhotoViewer.getInstance()
            android.app.Activity r2 = r4.getParentActivity()
            r1.setParentActivity(r2)
            org.rbmain.tgnet.TLRPC$UserProfilePhoto r1 = r0.photo
            int r2 = r1.dc_id
            if (r2 == 0) goto L39
            org.rbmain.tgnet.TLRPC$FileLocation r1 = r1.photo_big
            r1.dc_id = r2
        L39:
            org.rbmain.ui.PhotoViewer r1 = org.rbmain.ui.PhotoViewer.getInstance()
            org.rbmain.tgnet.TLRPC$UserProfilePhoto r0 = r0.photo
            org.rbmain.tgnet.TLRPC$FileLocation r0 = r0.photo_big
            org.rbmain.ui.PhotoViewer$PhotoViewerProvider r2 = r4.provider
            r1.openPhoto(r0, r2)
            goto Lac
        L47:
            int r0 = r4.chat_id
            if (r0 == 0) goto Lac
            org.rbmain.messenger.MessagesController r0 = r4.getMessagesController()
            int r1 = r4.chat_id
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            org.rbmain.tgnet.TLRPC$Chat r0 = r0.getChat(r1)
            org.rbmain.tgnet.TLRPC$ChatPhoto r1 = r0.photo
            if (r1 == 0) goto Lac
            org.rbmain.tgnet.TLRPC$FileLocation r1 = r1.photo_big
            if (r1 == 0) goto Lac
            org.rbmain.ui.PhotoViewer r1 = org.rbmain.ui.PhotoViewer.getInstance()
            android.app.Activity r2 = r4.getParentActivity()
            r1.setParentActivity(r2)
            org.rbmain.tgnet.TLRPC$ChatPhoto r1 = r0.photo
            int r2 = r1.dc_id
            if (r2 == 0) goto L76
            org.rbmain.tgnet.TLRPC$FileLocation r1 = r1.photo_big
            r1.dc_id = r2
        L76:
            org.rbmain.tgnet.TLRPC$ChatFull r1 = r4.chatInfo
            if (r1 == 0) goto L9e
            org.rbmain.tgnet.TLRPC$Photo r1 = r1.chat_photo
            boolean r2 = r1 instanceof org.rbmain.tgnet.TLRPC$TL_photo
            if (r2 == 0) goto L9e
            java.util.ArrayList<org.rbmain.tgnet.TLRPC$VideoSize> r1 = r1.video_sizes
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L9e
            org.rbmain.tgnet.TLRPC$ChatFull r1 = r4.chatInfo
            org.rbmain.tgnet.TLRPC$Photo r1 = r1.chat_photo
            java.util.ArrayList<org.rbmain.tgnet.TLRPC$VideoSize> r1 = r1.video_sizes
            r2 = 0
            java.lang.Object r1 = r1.get(r2)
            org.rbmain.tgnet.TLRPC$VideoSize r1 = (org.rbmain.tgnet.TLRPC$VideoSize) r1
            org.rbmain.tgnet.TLRPC$ChatFull r2 = r4.chatInfo
            org.rbmain.tgnet.TLRPC$Photo r2 = r2.chat_photo
            org.rbmain.messenger.ImageLocation r1 = org.rbmain.messenger.ImageLocation.getForPhoto(r1, r2)
            goto L9f
        L9e:
            r1 = 0
        L9f:
            org.rbmain.ui.PhotoViewer r2 = org.rbmain.ui.PhotoViewer.getInstance()
            org.rbmain.tgnet.TLRPC$ChatPhoto r0 = r0.photo
            org.rbmain.tgnet.TLRPC$FileLocation r0 = r0.photo_big
            org.rbmain.ui.PhotoViewer$PhotoViewerProvider r3 = r4.provider
            r2.openPhotoWithVideo(r0, r1, r3)
        Lac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.ProfileActivity.openAvatar():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onWriteButtonClick() {
        if (this.user_id != 0) {
            if (this.imageUpdater != null) {
                TLRPC$User user = MessagesController.getInstance(this.currentAccount).getUser(Integer.valueOf(UserConfig.getInstance(this.currentAccount).getClientUserId()));
                if (user == null) {
                    user = UserConfig.getInstance(this.currentAccount).getCurrentUser();
                }
                if (user == null) {
                    return;
                }
                ImageUpdater imageUpdater = this.imageUpdater;
                TLRPC$UserProfilePhoto tLRPC$UserProfilePhoto = user.photo;
                imageUpdater.openMenu((tLRPC$UserProfilePhoto == null || tLRPC$UserProfilePhoto.photo_big == null || (tLRPC$UserProfilePhoto instanceof TLRPC$TL_userProfilePhotoEmpty)) ? false : true, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$$ExternalSyntheticLambda15
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onWriteButtonClick$13();
                    }
                }, new DialogInterface.OnDismissListener() { // from class: org.rbmain.ui.ProfileActivity$$ExternalSyntheticLambda9
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        this.f$0.lambda$onWriteButtonClick$14(dialogInterface);
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
            TLRPC$User user2 = getMessagesController().getUser(Integer.valueOf(this.user_id));
            if (user2 == null || (user2 instanceof TLRPC$TL_userEmpty)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("user_id", this.user_id);
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
    public /* synthetic */ void lambda$onWriteButtonClick$13() {
        MessagesController.getInstance(this.currentAccount).deleteUserPhoto(null, false);
        this.cameraDrawable.setCurrentFrame(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onWriteButtonClick$14(DialogInterface dialogInterface) {
        this.cameraDrawable.setCustomEndFrame(86);
        this.writeButton.playAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openDiscussion() {
        TLRPC$ChatFull tLRPC$ChatFull = this.chatInfo;
        if (tLRPC$ChatFull == null || tLRPC$ChatFull.linked_chat_id == 0) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("chat_id", this.chatInfo.linked_chat_id);
        if (getMessagesController().checkCanOpenChat(bundle, this)) {
            presentFragment(new ChatActivity(bundle));
        }
    }

    public boolean onMemberClick(TLRPC$ChatParticipant tLRPC$ChatParticipant, boolean z) {
        return onMemberClick(tLRPC$ChatParticipant, z, false);
    }

    public boolean onMemberClick(final TLRPC$ChatParticipant tLRPC$ChatParticipant, boolean z, boolean z2) {
        boolean zCanAddAdmins;
        boolean z3;
        boolean z4;
        TLRPC$ChannelParticipant tLRPC$ChannelParticipant;
        boolean z5;
        int i;
        String str;
        if (getParentActivity() == null) {
            return false;
        }
        if (z) {
            final TLRPC$User user = getMessagesController().getUser(Integer.valueOf(tLRPC$ChatParticipant.user_id));
            if (user == null || tLRPC$ChatParticipant.user_id == getUserConfig().getClientUserId()) {
                return false;
            }
            this.selectedUser = tLRPC$ChatParticipant.user_id;
            if (ChatObject.isChannel(this.currentChat)) {
                TLRPC$ChannelParticipant tLRPC$ChannelParticipant2 = ((TLRPC$TL_chatChannelParticipant) tLRPC$ChatParticipant).channelParticipant;
                getMessagesController().getUser(Integer.valueOf(tLRPC$ChatParticipant.user_id));
                zCanAddAdmins = ChatObject.canAddAdmins(this.currentChat);
                if (zCanAddAdmins && ((tLRPC$ChannelParticipant2 instanceof TLRPC$TL_channelParticipantCreator) || ((tLRPC$ChannelParticipant2 instanceof TLRPC$TL_channelParticipantAdmin) && !tLRPC$ChannelParticipant2.can_edit))) {
                    zCanAddAdmins = false;
                }
                boolean z6 = ChatObject.canBlockUsers(this.currentChat) && (!((tLRPC$ChannelParticipant2 instanceof TLRPC$TL_channelParticipantAdmin) || (tLRPC$ChannelParticipant2 instanceof TLRPC$TL_channelParticipantCreator)) || tLRPC$ChannelParticipant2.can_edit);
                boolean z7 = this.currentChat.gigagroup;
                z3 = tLRPC$ChannelParticipant2 instanceof TLRPC$TL_channelParticipantAdmin;
                boolean z8 = z6;
                tLRPC$ChannelParticipant = tLRPC$ChannelParticipant2;
                z4 = z8;
            } else {
                TLRPC$Chat tLRPC$Chat = this.currentChat;
                boolean z9 = tLRPC$Chat.creator || ((tLRPC$ChatParticipant instanceof TLRPC$TL_chatParticipant) && (ChatObject.canBlockUsers(tLRPC$Chat) || tLRPC$ChatParticipant.inviter_id == getUserConfig().getClientUserId()));
                zCanAddAdmins = this.currentChat.creator;
                z3 = tLRPC$ChatParticipant instanceof TLRPC$TL_chatParticipantAdmin;
                z4 = z9;
                tLRPC$ChannelParticipant = null;
            }
            ArrayList arrayList = z2 ? null : new ArrayList();
            ArrayList arrayList2 = z2 ? null : new ArrayList();
            final ArrayList arrayList3 = z2 ? null : new ArrayList();
            if (zCanAddAdmins) {
                if (z2) {
                    return true;
                }
                if (z3) {
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
            if (!z4) {
                z5 = false;
            } else {
                if (z2) {
                    return true;
                }
                arrayList.add(LocaleController.getString("KickFromGroup", R.string.KickFromGroup));
                arrayList2.add(Integer.valueOf(R.drawable.actions_remove_user));
                arrayList3.add(2);
                z5 = true;
            }
            if (z2 || arrayList.isEmpty()) {
                return false;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
            final TLRPC$ChannelParticipant tLRPC$ChannelParticipant3 = tLRPC$ChannelParticipant;
            final boolean z10 = z3;
            builder.setItems((CharSequence[]) arrayList.toArray(new CharSequence[0]), AndroidUtilities.toIntArray(arrayList2), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.ProfileActivity$$ExternalSyntheticLambda6
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$onMemberClick$16(arrayList3, tLRPC$ChatParticipant, tLRPC$ChannelParticipant3, user, z10, dialogInterface, i2);
                }
            });
            AlertDialog alertDialogCreate = builder.create();
            showDialog(alertDialogCreate);
            if (z5) {
                alertDialogCreate.setItemColor(arrayList.size() - 1, Theme.getColor(Theme.key_text_RedBold), Theme.getColor(Theme.key_text_RedRegular));
            }
        } else {
            if (tLRPC$ChatParticipant.user_id == getUserConfig().getClientUserId()) {
                return false;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("user_id", tLRPC$ChatParticipant.user_id);
            bundle.putBoolean("preload_messages", true);
            presentFragment(new ProfileActivity(bundle));
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMemberClick$16(ArrayList arrayList, final TLRPC$ChatParticipant tLRPC$ChatParticipant, final TLRPC$ChannelParticipant tLRPC$ChannelParticipant, final TLRPC$User tLRPC$User, final boolean z, DialogInterface dialogInterface, int i) {
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
                openRightsEdit(iIntValue, tLRPC$User, tLRPC$ChatParticipant, null, null, BuildConfig.FLAVOR, z);
                return;
            }
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
        builder.setMessage(LocaleController.formatString("AdminWillBeRemoved", R.string.AdminWillBeRemoved, ContactsController.formatName(tLRPC$User.first_name, tLRPC$User.last_name)));
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.ProfileActivity$$ExternalSyntheticLambda8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface2, int i2) {
                this.f$0.lambda$onMemberClick$15(tLRPC$ChannelParticipant, iIntValue, tLRPC$User, tLRPC$ChatParticipant, z, dialogInterface2, i2);
            }
        });
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        showDialog(builder.create());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMemberClick$15(TLRPC$ChannelParticipant tLRPC$ChannelParticipant, int i, TLRPC$User tLRPC$User, TLRPC$ChatParticipant tLRPC$ChatParticipant, boolean z, DialogInterface dialogInterface, int i2) {
        if (tLRPC$ChannelParticipant != null) {
            openRightsEdit(i, tLRPC$User, tLRPC$ChatParticipant, tLRPC$ChannelParticipant.admin_rights, tLRPC$ChannelParticipant.banned_rights, tLRPC$ChannelParticipant.rank, z);
        } else {
            openRightsEdit(i, tLRPC$User, tLRPC$ChatParticipant, null, null, BuildConfig.FLAVOR, z);
        }
    }

    private void openRightsEdit(final int i, final TLRPC$User tLRPC$User, final TLRPC$ChatParticipant tLRPC$ChatParticipant, TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights, TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights, String str, final boolean z) {
        final boolean[] zArr = new boolean[1];
        ChatRightsEditActivity chatRightsEditActivity = new ChatRightsEditActivity(tLRPC$User.id, this.chat_id, tLRPC$TL_chatAdminRights, this.currentChat.default_banned_rights, tLRPC$TL_chatBannedRights, str, i, true, false) { // from class: org.rbmain.ui.ProfileActivity.24
            @Override // org.rbmain.ui.ActionBar.BaseFragment
            protected void onTransitionAnimationEnd(boolean z2, boolean z3) {
                if (!z2 && z3 && zArr[0] && BulletinFactory.canShowBulletin(ProfileActivity.this)) {
                    BulletinFactory.createPromoteToAdminBulletin(ProfileActivity.this, tLRPC$User.first_name).show();
                }
            }
        };
        chatRightsEditActivity.setDelegate(new ChatRightsEditActivity.ChatRightsEditActivityDelegate() { // from class: org.rbmain.ui.ProfileActivity.25
            @Override // org.rbmain.ui.ChatRightsEditActivity.ChatRightsEditActivityDelegate
            public void didSetRights(int i2, TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights2, TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights2, String str2) {
                boolean z2;
                TLRPC$ChatParticipant tLRPC$TL_chatParticipant;
                int i3 = i;
                int i4 = 0;
                if (i3 != 0) {
                    if (i3 == 1 && i2 == 0 && ProfileActivity.this.currentChat.megagroup && ProfileActivity.this.chatInfo != null && ProfileActivity.this.chatInfo.participants != null) {
                        int i5 = 0;
                        while (true) {
                            if (i5 >= ProfileActivity.this.chatInfo.participants.participants.size()) {
                                z2 = false;
                                break;
                            } else {
                                if (MessageObject.getPeerId(((TLRPC$TL_chatChannelParticipant) ProfileActivity.this.chatInfo.participants.participants.get(i5)).channelParticipant.peer) == tLRPC$ChatParticipant.user_id) {
                                    ProfileActivity.this.chatInfo.participants_count--;
                                    ProfileActivity.this.chatInfo.participants.participants.remove(i5);
                                    z2 = true;
                                    break;
                                }
                                i5++;
                            }
                        }
                        if (ProfileActivity.this.chatInfo != null && ProfileActivity.this.chatInfo.participants != null) {
                            while (true) {
                                if (i4 >= ProfileActivity.this.chatInfo.participants.participants.size()) {
                                    break;
                                }
                                if (ProfileActivity.this.chatInfo.participants.participants.get(i4).user_id == tLRPC$ChatParticipant.user_id) {
                                    ProfileActivity.this.chatInfo.participants.participants.remove(i4);
                                    z2 = true;
                                    break;
                                }
                                i4++;
                            }
                        }
                        if (z2) {
                            ProfileActivity.this.updateOnlineCount(true);
                            ProfileActivity.this.updateRowsIds();
                            ProfileActivity.this.listAdapter.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    return;
                }
                TLRPC$ChatParticipant tLRPC$ChatParticipant2 = tLRPC$ChatParticipant;
                if (tLRPC$ChatParticipant2 instanceof TLRPC$TL_chatChannelParticipant) {
                    TLRPC$TL_chatChannelParticipant tLRPC$TL_chatChannelParticipant = (TLRPC$TL_chatChannelParticipant) tLRPC$ChatParticipant2;
                    if (i2 == 1) {
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
                    TLRPC$ChatParticipant tLRPC$ChatParticipant3 = tLRPC$ChatParticipant;
                    tLRPC$Peer.user_id = tLRPC$ChatParticipant3.user_id;
                    tLRPC$ChannelParticipant.date = tLRPC$ChatParticipant3.date;
                    tLRPC$ChannelParticipant.banned_rights = tLRPC$TL_chatBannedRights2;
                    tLRPC$ChannelParticipant.admin_rights = tLRPC$TL_chatAdminRights2;
                    tLRPC$ChannelParticipant.rank = str2;
                } else if (tLRPC$ChatParticipant2 != null) {
                    if (i2 == 1) {
                        tLRPC$TL_chatParticipant = new TLRPC$TL_chatParticipantAdmin();
                    } else {
                        tLRPC$TL_chatParticipant = new TLRPC$TL_chatParticipant();
                    }
                    TLRPC$ChatParticipant tLRPC$ChatParticipant4 = tLRPC$ChatParticipant;
                    tLRPC$TL_chatParticipant.user_id = tLRPC$ChatParticipant4.user_id;
                    tLRPC$TL_chatParticipant.date = tLRPC$ChatParticipant4.date;
                    tLRPC$TL_chatParticipant.inviter_id = tLRPC$ChatParticipant4.inviter_id;
                    int iIndexOf = ProfileActivity.this.chatInfo.participants.participants.indexOf(tLRPC$ChatParticipant);
                    if (iIndexOf >= 0) {
                        ProfileActivity.this.chatInfo.participants.participants.set(iIndexOf, tLRPC$TL_chatParticipant);
                    }
                }
                if (i2 != 1 || z) {
                    return;
                }
                zArr[0] = true;
            }
        });
        presentFragment(chatRightsEditActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean processOnClickOrPress(final int i) {
        TLRPC$Chat chat;
        final String str;
        String str2;
        TLRPC$UserFull tLRPC$UserFull;
        if (i == this.usernameRow || i == this.setUsernameRow) {
            if (this.user_id != 0) {
                TLRPC$User user = getMessagesController().getUser(Integer.valueOf(this.user_id));
                if (user == null || (str = user.username) == null) {
                    return false;
                }
            } else if (this.chat_id == 0 || (chat = getMessagesController().getChat(Integer.valueOf(this.chat_id))) == null || (str = chat.username) == null) {
                return false;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
            builder.setItems(new CharSequence[]{LocaleController.getString("Copy", R.string.Copy)}, new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.ProfileActivity$$ExternalSyntheticLambda5
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$processOnClickOrPress$17(str, dialogInterface, i2);
                }
            });
            showDialog(builder.create());
            return true;
        }
        if (i == this.phoneRow || i == this.numberRow) {
            final TLRPC$User user2 = getMessagesController().getUser(Integer.valueOf(this.user_id));
            if (user2 == null || (str2 = user2.phone) == null || str2.length() == 0 || getParentActivity() == null) {
                return false;
            }
            AlertDialog.Builder builder2 = new AlertDialog.Builder(getParentActivity());
            ArrayList arrayList = new ArrayList();
            final ArrayList arrayList2 = new ArrayList();
            if (i == this.phoneRow) {
                TLRPC$UserFull tLRPC$UserFull2 = this.userInfo;
                if (tLRPC$UserFull2 != null && tLRPC$UserFull2.phone_calls_available) {
                    arrayList.add(LocaleController.getString("CallViaRubika", R.string.CallViaRubika));
                    arrayList2.add(2);
                    if (Build.VERSION.SDK_INT >= 18 && this.userInfo.video_calls_available) {
                        arrayList.add(LocaleController.getString("VideoCallViaRubika", R.string.VideoCallViaRubika));
                        arrayList2.add(3);
                    }
                }
                arrayList.add(LocaleController.getString("Call", R.string.Call));
                arrayList2.add(0);
            }
            arrayList.add(LocaleController.getString("Copy", R.string.Copy));
            arrayList2.add(1);
            builder2.setItems((CharSequence[]) arrayList.toArray(new CharSequence[0]), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.ProfileActivity$$ExternalSyntheticLambda7
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$processOnClickOrPress$18(arrayList2, user2, dialogInterface, i2);
                }
            });
            showDialog(builder2.create());
            return true;
        }
        if (i != this.channelInfoRow && i != this.userInfoRow && i != this.locationRow && i != this.bioRow) {
            return false;
        }
        if (i == this.bioRow && ((tLRPC$UserFull = this.userInfo) == null || TextUtils.isEmpty(tLRPC$UserFull.about))) {
            return false;
        }
        AlertDialog.Builder builder3 = new AlertDialog.Builder(getParentActivity());
        builder3.setItems(new CharSequence[]{LocaleController.getString("Copy", R.string.Copy)}, new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.ProfileActivity$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.f$0.lambda$processOnClickOrPress$19(i, dialogInterface, i2);
            }
        });
        showDialog(builder3.create());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processOnClickOrPress$17(String str, DialogInterface dialogInterface, int i) {
        String str2;
        if (i == 0) {
            try {
                ClipboardManager clipboardManager = (ClipboardManager) ApplicationLoader.applicationContext.getSystemService("clipboard");
                if (this.user_id != 0) {
                    str2 = "@" + str;
                    BulletinFactory.of(this).createCopyBulletin(LocaleController.getString("UsernameCopied", R.string.UsernameCopied)).show();
                } else {
                    str2 = "@" + str;
                    BulletinFactory.of(this).createCopyBulletin(LocaleController.getString("LinkCopied", R.string.LinkCopied)).show();
                }
                clipboardManager.setPrimaryClip(ClipData.newPlainText("label", str2));
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processOnClickOrPress$18(ArrayList arrayList, TLRPC$User tLRPC$User, DialogInterface dialogInterface, int i) {
        int iIntValue = ((Integer) arrayList.get(i)).intValue();
        if (iIntValue == 0) {
            try {
                Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:+" + tLRPC$User.phone));
                intent.addFlags(268435456);
                getParentActivity().startActivityForResult(intent, HttpStatus.HTTP_INTERNAL_SERVER_ERROR);
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
    public /* synthetic */ void lambda$processOnClickOrPress$19(int i, DialogInterface dialogInterface, int i2) {
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
        AlertsCreator.createClearOrDeleteDialogAlert(this, false, this.currentChat, null, false, true, new MessagesStorage.BooleanCallback() { // from class: org.rbmain.ui.ProfileActivity$$ExternalSyntheticLambda26
            @Override // org.rbmain.messenger.MessagesStorage.BooleanCallback
            public final void run(boolean z) {
                this.f$0.lambda$leaveChatPressed$20(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$leaveChatPressed$20(boolean z) {
        this.playProfileAnimation = 0;
        NotificationCenter notificationCenter = getNotificationCenter();
        int i = NotificationCenter.closeChats;
        notificationCenter.removeObserver(this, i);
        getNotificationCenter().postNotificationName(i, new Object[0]);
        finishFragment();
        getNotificationCenter().postNotificationName(NotificationCenter.needDeleteDialog, Long.valueOf(-this.currentChat.id), null, this.currentChat, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getChannelParticipants(boolean z) {
        if (this.loadingUsers || this.participantsMap == null || this.chatInfo == null) {
            return;
        }
        this.loadingUsers = true;
        TLRPC$TL_channels_getParticipants tLRPC$TL_channels_getParticipants = new TLRPC$TL_channels_getParticipants();
        tLRPC$TL_channels_getParticipants.channel = getMessagesController().getInputChannel(this.chat_id);
        tLRPC$TL_channels_getParticipants.filter = new TLRPC$TL_channelParticipantsRecent();
        tLRPC$TL_channels_getParticipants.limit = 200;
        this.nextStartId = z ? null : this.nextStartId;
        getDialogsProxy().getChatMembers(IdStorage.getInstance().getDialogId(-this.chat_id), this.nextStartId, null, new RequestDelegate() { // from class: org.rbmain.ui.ProfileActivity$$ExternalSyntheticLambda30
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$getChannelParticipants$22(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getChannelParticipants$22(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ProfileActivity$$ExternalSyntheticLambda19
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getChannelParticipants$21(tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getChannelParticipants$21(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
        if (tLRPC$TL_error == null) {
            TLRPC$TL_channels_channelParticipants tLRPC$TL_channels_channelParticipants = (TLRPC$TL_channels_channelParticipants) tLObject;
            getMessagesController().putUsers(tLRPC$TL_channels_channelParticipants.users, false);
            getMessagesController().putChats(tLRPC$TL_channels_channelParticipants.chats, false);
            this.usersEndReached = !tLRPC$TL_channels_channelParticipants.hasContinue;
            if (this.nextStartId == null) {
                this.participantsMap.clear();
                this.chatInfo.participants = new TLRPC$TL_chatParticipants();
                getMessagesStorage().putUsersAndChats(tLRPC$TL_channels_channelParticipants.users, tLRPC$TL_channels_channelParticipants.chats, true, true);
                getMessagesStorage().updateChannelUsers(this.chat_id, tLRPC$TL_channels_channelParticipants.participants);
            }
            this.nextStartId = tLRPC$TL_channels_channelParticipants.nextStartId;
            for (int i = 0; i < tLRPC$TL_channels_channelParticipants.participants.size(); i++) {
                TLRPC$TL_chatChannelParticipant tLRPC$TL_chatChannelParticipant = new TLRPC$TL_chatChannelParticipant();
                TLRPC$ChannelParticipant tLRPC$ChannelParticipant = tLRPC$TL_channels_channelParticipants.participants.get(i);
                tLRPC$TL_chatChannelParticipant.channelParticipant = tLRPC$ChannelParticipant;
                tLRPC$TL_chatChannelParticipant.inviter_id = tLRPC$ChannelParticipant.inviter_id;
                int peerId = MessageObject.getPeerId(tLRPC$ChannelParticipant.peer);
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

    private void setMediaHeaderVisible(boolean z) {
        if (this.mediaHeaderVisible == z) {
            return;
        }
        this.mediaHeaderVisible = z;
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
        fArr[0] = z ? 0.0f : 1.0f;
        arrayList.add(ObjectAnimator.ofFloat(actionBarMenuItem, (Property<ActionBarMenuItem, Float>) property, fArr));
        ActionBarMenuItem actionBarMenuItem2 = this.videoCallItem;
        Property property2 = View.ALPHA;
        float[] fArr2 = new float[1];
        fArr2[0] = z ? 0.0f : 1.0f;
        arrayList.add(ObjectAnimator.ofFloat(actionBarMenuItem2, (Property<ActionBarMenuItem, Float>) property2, fArr2));
        ActionBarMenuItem actionBarMenuItem3 = this.otherItem;
        Property property3 = View.ALPHA;
        float[] fArr3 = new float[1];
        fArr3[0] = z ? 0.0f : 1.0f;
        arrayList.add(ObjectAnimator.ofFloat(actionBarMenuItem3, (Property<ActionBarMenuItem, Float>) property3, fArr3));
        ActionBarMenuItem actionBarMenuItem4 = this.editItem;
        Property property4 = View.ALPHA;
        float[] fArr4 = new float[1];
        fArr4[0] = z ? 0.0f : 1.0f;
        arrayList.add(ObjectAnimator.ofFloat(actionBarMenuItem4, (Property<ActionBarMenuItem, Float>) property4, fArr4));
        ActionBarMenuItem actionBarMenuItem5 = this.callItem;
        Property property5 = View.TRANSLATION_Y;
        float[] fArr5 = new float[1];
        fArr5[0] = z ? -AndroidUtilities.dp(10.0f) : 0.0f;
        arrayList.add(ObjectAnimator.ofFloat(actionBarMenuItem5, (Property<ActionBarMenuItem, Float>) property5, fArr5));
        ActionBarMenuItem actionBarMenuItem6 = this.videoCallItem;
        Property property6 = View.TRANSLATION_Y;
        float[] fArr6 = new float[1];
        fArr6[0] = z ? -AndroidUtilities.dp(10.0f) : 0.0f;
        arrayList.add(ObjectAnimator.ofFloat(actionBarMenuItem6, (Property<ActionBarMenuItem, Float>) property6, fArr6));
        ActionBarMenuItem actionBarMenuItem7 = this.otherItem;
        Property property7 = View.TRANSLATION_Y;
        float[] fArr7 = new float[1];
        fArr7[0] = z ? -AndroidUtilities.dp(10.0f) : 0.0f;
        arrayList.add(ObjectAnimator.ofFloat(actionBarMenuItem7, (Property<ActionBarMenuItem, Float>) property7, fArr7));
        ActionBarMenuItem actionBarMenuItem8 = this.editItem;
        Property property8 = View.TRANSLATION_Y;
        float[] fArr8 = new float[1];
        fArr8[0] = z ? -AndroidUtilities.dp(10.0f) : 0.0f;
        arrayList.add(ObjectAnimator.ofFloat(actionBarMenuItem8, (Property<ActionBarMenuItem, Float>) property8, fArr8));
        Property property9 = View.ALPHA;
        float[] fArr9 = new float[1];
        fArr9[0] = z ? 1.0f : 0.0f;
        arrayList.add(ObjectAnimator.ofFloat(searchItem, (Property<ActionBarMenuItem, Float>) property9, fArr9));
        Property property10 = View.TRANSLATION_Y;
        float[] fArr10 = new float[1];
        fArr10[0] = z ? 0.0f : AndroidUtilities.dp(10.0f);
        arrayList.add(ObjectAnimator.ofFloat(searchItem, (Property<ActionBarMenuItem, Float>) property10, fArr10));
        ActionBar actionBar = this.actionBar;
        Property<ActionBar, Float> property11 = this.ACTIONBAR_HEADER_PROGRESS;
        float[] fArr11 = new float[1];
        fArr11[0] = z ? 1.0f : 0.0f;
        arrayList.add(ObjectAnimator.ofFloat(actionBar, property11, fArr11));
        SimpleTextView simpleTextView = this.onlineTextView[1];
        Property property12 = View.ALPHA;
        float[] fArr12 = new float[1];
        fArr12[0] = z ? 0.0f : 1.0f;
        arrayList.add(ObjectAnimator.ofFloat(simpleTextView, (Property<SimpleTextView, Float>) property12, fArr12));
        AudioPlayerAlert.ClippingTextViewSwitcher clippingTextViewSwitcher = this.mediaCounterTextView;
        Property property13 = View.ALPHA;
        float[] fArr13 = new float[1];
        fArr13[0] = z ? 1.0f : 0.0f;
        arrayList.add(ObjectAnimator.ofFloat(clippingTextViewSwitcher, (Property<AudioPlayerAlert.ClippingTextViewSwitcher, Float>) property13, fArr13));
        if (z) {
            arrayList.add(ObjectAnimator.ofFloat(this, this.HEADER_SHADOW, 0.0f));
        }
        AnimatorSet animatorSet3 = new AnimatorSet();
        this.headerAnimatorSet = animatorSet3;
        animatorSet3.playTogether(arrayList);
        this.headerAnimatorSet.setInterpolator(CubicBezierInterpolator.DEFAULT);
        this.headerAnimatorSet.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.ProfileActivity.27
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
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
                            searchItem.setVisibility(4);
                        }
                        ProfileActivity.this.headerShadowAnimatorSet = new AnimatorSet();
                        AnimatorSet animatorSet4 = ProfileActivity.this.headerShadowAnimatorSet;
                        ProfileActivity profileActivity = ProfileActivity.this;
                        animatorSet4.playTogether(ObjectAnimator.ofFloat(profileActivity, (Property<ProfileActivity, Float>) profileActivity.HEADER_SHADOW, 1.0f));
                        ProfileActivity.this.headerShadowAnimatorSet.setDuration(100L);
                        ProfileActivity.this.headerShadowAnimatorSet.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.ProfileActivity.27.1
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator2) {
                                ProfileActivity.this.headerShadowAnimatorSet = null;
                            }
                        });
                        ProfileActivity.this.headerShadowAnimatorSet.start();
                    }
                }
                ProfileActivity.this.headerAnimatorSet = null;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
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
        bundle.putInt("chatId", this.currentChat.id);
        GroupCreateActivity groupCreateActivity = new GroupCreateActivity(bundle);
        groupCreateActivity.setInfo(this.chatInfo);
        TLRPC$ChatFull tLRPC$ChatFull = this.chatInfo;
        if (tLRPC$ChatFull != null && tLRPC$ChatFull.participants != null) {
            SparseArray<TLObject> sparseArray = new SparseArray<>();
            for (int i = 0; i < this.chatInfo.participants.participants.size(); i++) {
                sparseArray.put(this.chatInfo.participants.participants.get(i).user_id, null);
            }
            groupCreateActivity.setIgnoreUsers(sparseArray);
        }
        groupCreateActivity.setDelegate(new GroupCreateActivity.ContactsAddActivityDelegate() { // from class: org.rbmain.ui.ProfileActivity$$ExternalSyntheticLambda36
            @Override // org.rbmain.ui.GroupCreateActivity.ContactsAddActivityDelegate
            public final void didSelectUsers(ArrayList arrayList, int i2) {
                this.f$0.lambda$openAddMember$24(arrayList, i2);
            }

            @Override // org.rbmain.ui.GroupCreateActivity.ContactsAddActivityDelegate
            public /* synthetic */ void needAddBot(TLRPC$User tLRPC$User) {
                GroupCreateActivity.ContactsAddActivityDelegate.CC.$default$needAddBot(this, tLRPC$User);
            }
        });
        presentFragment(groupCreateActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openAddMember$24(ArrayList arrayList, int i) {
        final HashSet hashSet = new HashSet();
        TLRPC$ChatParticipants tLRPC$ChatParticipants = this.chatInfo.participants;
        if (tLRPC$ChatParticipants != null && tLRPC$ChatParticipants.participants != null) {
            for (int i2 = 0; i2 < this.chatInfo.participants.participants.size(); i2++) {
                hashSet.add(Integer.valueOf(this.chatInfo.participants.participants.get(i2).user_id));
            }
        }
        getMessagesController().addUsersToChat(this.chat_id, arrayList, i, null, this, new Utilities.CallBack() { // from class: org.rbmain.ui.ProfileActivity$$ExternalSyntheticLambda27
            @Override // org.rbmain.messenger.Utilities.CallBack
            public final void run(Object obj) {
                this.f$0.lambda$openAddMember$23(hashSet, (ArrayList) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openAddMember$23(HashSet hashSet, ArrayList arrayList) {
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            TLRPC$User tLRPC$User = (TLRPC$User) arrayList.get(i);
            if (!hashSet.contains(Integer.valueOf(tLRPC$User.id))) {
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
        this.sharedMediaPreloader.getLastMediaCount();
        if (closestTab == 0) {
            this.mediaCounterTextView.setText(LocaleController.getString("SharedMediaTab2", R.string.SharedMediaTab2));
            return;
        }
        if (closestTab == 1) {
            this.mediaCounterTextView.setText(LocaleController.getString("SharedMediaTab2", R.string.SharedFilesTab2));
            return;
        }
        if (closestTab == 2) {
            this.mediaCounterTextView.setText(LocaleController.getString("SharedMediaTab2", R.string.SharedVoiceTab2));
            return;
        }
        if (closestTab == 3) {
            this.mediaCounterTextView.setText(LocaleController.getString("SharedMediaTab2", R.string.SharedLinksTab2));
            return;
        }
        if (closestTab == 4) {
            this.mediaCounterTextView.setText(LocaleController.getString("SharedMediaTab2", R.string.SharedMusicTab2));
            return;
        }
        if (closestTab == 5) {
            this.mediaCounterTextView.setText(LocaleController.getString("SharedMediaTab2", R.string.SharedGIFsTab2));
        } else if (closestTab == 6) {
            this.mediaCounterTextView.setText(LocaleController.formatPluralString("CommonGroups", this.userInfo.common_chats_count));
        } else if (closestTab == 7) {
            this.mediaCounterTextView.setText(this.onlineTextView[1].getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void needLayout(boolean z) {
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
                    boolean z2 = fMin > 0.2f && !this.searchMode && (this.imageUpdater == null || this.setAvatarRow == -1);
                    if (z2 && this.chat_id != 0) {
                        z2 = (!ChatObject.isChannel(this.currentChat) || this.currentChat.megagroup || (tLRPC$ChatFull = this.chatInfo) == null || tLRPC$ChatFull.linked_chat_id == 0 || this.infoHeaderRow == -1) ? false : true;
                    }
                    if (z2 != (this.writeButton.getTag() == null)) {
                        if (z2) {
                            this.writeButton.setTag(null);
                        } else {
                            this.writeButton.setTag(0);
                        }
                        AnimatorSet animatorSet = this.writeButtonAnimation;
                        if (animatorSet != null) {
                            this.writeButtonAnimation = null;
                            animatorSet.cancel();
                        }
                        if (z) {
                            AnimatorSet animatorSet2 = new AnimatorSet();
                            this.writeButtonAnimation = animatorSet2;
                            if (z2) {
                                animatorSet2.setInterpolator(new DecelerateInterpolator());
                                this.writeButtonAnimation.playTogether(ObjectAnimator.ofFloat(this.writeButton, (Property<RLottieImageView, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.writeButton, (Property<RLottieImageView, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.writeButton, (Property<RLottieImageView, Float>) View.ALPHA, 1.0f));
                            } else {
                                animatorSet2.setInterpolator(new AccelerateInterpolator());
                                this.writeButtonAnimation.playTogether(ObjectAnimator.ofFloat(this.writeButton, (Property<RLottieImageView, Float>) View.SCALE_X, 0.2f), ObjectAnimator.ofFloat(this.writeButton, (Property<RLottieImageView, Float>) View.SCALE_Y, 0.2f), ObjectAnimator.ofFloat(this.writeButton, (Property<RLottieImageView, Float>) View.ALPHA, 0.0f));
                            }
                            this.writeButtonAnimation.setDuration(150L);
                            this.writeButtonAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.ProfileActivity.28
                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (ProfileActivity.this.writeButtonAnimation == null || !ProfileActivity.this.writeButtonAnimation.equals(animator)) {
                                        return;
                                    }
                                    ProfileActivity.this.writeButtonAnimation = null;
                                }
                            });
                            this.writeButtonAnimation.start();
                        } else {
                            this.writeButton.setScaleX(z2 ? 1.0f : 0.2f);
                            this.writeButton.setScaleY(z2 ? 1.0f : 0.2f);
                            this.writeButton.setAlpha(z2 ? 1.0f : 0.0f);
                        }
                    }
                }
            }
            this.avatarX = (-AndroidUtilities.dpf2(47.0f)) * fMin * (isRtlLayout() ? -1 : 1);
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
                                this.otherItem.hideSubItem(33);
                                this.otherItem.hideSubItem(31);
                                this.otherItem.hideSubItem(37);
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
                        this.expandAnimator.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.ProfileActivity.29
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator) {
                                ProfileActivity.this.setForegroundImage(false);
                                ProfileActivity.this.avatarsViewPager.setAnimatedFileMaybe(ProfileActivity.this.avatarImage.getImageReceiver().getAnimation());
                                ProfileActivity.this.avatarsViewPager.resetCurrentItem();
                            }

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
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
                        if (isRtlLayout()) {
                            this.nameTextView[1].setTranslationX(((this.avatarContainer2.getMeasuredWidth() - AndroidUtilities.dpf2(16.0f)) - this.nameTextView[1].getRight()) - ((this.nameTextView[1].getPaint().measureText(this.nameTextView[1].getText().toString()) + this.nameTextView[1].getSideDrawablesSize()) * 0.5f));
                        } else {
                            this.nameTextView[1].setTranslationX(AndroidUtilities.dpf2(16.0f) - this.nameTextView[1].getLeft());
                        }
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
                                this.otherItem.hideSubItem(33);
                                this.otherItem.hideSubItem(34);
                                this.otherItem.hideSubItem(35);
                                this.otherItem.showSubItem(36);
                                this.otherItem.showSubItem(31);
                                this.otherItem.showSubItem(37);
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
                        this.topView.setBackgroundColor(Theme.getColor(Theme.key_avatar_backgroundActionBarBlue));
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
                        this.onlineTextView[1].setTranslationX(this.onlineX);
                        this.nameTextView[1].setTranslationY(this.nameY);
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
                this.actionBar.setItemsColor(ColorUtils.blendARGB(Theme.getColor(Theme.key_actionBarDefaultIcon), -1, this.animationProgress), false);
                ScamDrawable scamDrawable = this.scamDrawable;
                if (scamDrawable != null) {
                    scamDrawable.setColor(ColorUtils.blendARGB(Theme.getColor(Theme.key_avatar_subtitleInProfileBlue), Color.argb(179, 255, 255, 255), this.animationProgress));
                }
                Drawable drawable = this.lockIconDrawable;
                if (drawable != null) {
                    drawable.setColorFilter(ColorUtils.blendARGB(Theme.getColor(Theme.key_chat_lockIcon), -1, this.animationProgress), PorterDuff.Mode.MULTIPLY);
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
                if (isRtlLayout()) {
                    layoutParams3.rightMargin = (int) AndroidUtilities.lerp(AndroidUtilities.dpf2(64.0f), 0.0f, this.animationProgress);
                } else {
                    layoutParams3.leftMargin = (int) AndroidUtilities.lerp(AndroidUtilities.dpf2(64.0f), 0.0f, this.animationProgress);
                }
                this.avatarContainer.requestLayout();
            } else if (this.extraHeight <= AndroidUtilities.dp(88.0f)) {
                this.avatarScale = ((18.0f * fMin) + 42.0f) / 42.0f;
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
                this.nameX = AndroidUtilities.density * (-21.0f) * fMin * (isRtlLayout() ? -1 : 1);
                this.nameY = ((float) Math.floor(this.avatarY)) + AndroidUtilities.dp(1.3f) + (AndroidUtilities.dp(7.0f) * fMin);
                this.onlineX = AndroidUtilities.density * (-21.0f) * fMin * (isRtlLayout() ? -1 : 1);
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
    public void setForegroundImage(boolean z) {
        Drawable drawable = this.avatarImage.getImageReceiver().getDrawable();
        String str = null;
        if (drawable instanceof AnimatedFileDrawable) {
            AnimatedFileDrawable animatedFileDrawable = (AnimatedFileDrawable) drawable;
            this.avatarImage.setForegroundImage(null, null, animatedFileDrawable);
            if (z) {
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
        this.nameX = ((isRtlLayout() ? -1 : 1) * AndroidUtilities.dp(-21.0f)) + ((isRtlLayout() ? -1 : 1) * this.avatarContainer.getMeasuredWidth() * (this.avatarScale - 1.4285715f));
        this.nameY = ((float) Math.floor(this.avatarY)) + AndroidUtilities.dp(1.3f) + AndroidUtilities.dp(7.0f) + ((this.avatarContainer.getMeasuredHeight() * (this.avatarScale - 1.4285715f)) / 2.0f);
        this.onlineX = ((isRtlLayout() ? -1 : 1) * AndroidUtilities.dp(-21.0f)) + ((isRtlLayout() ? -1 : 1) * this.avatarContainer.getMeasuredWidth() * (this.avatarScale - 1.4285715f));
        this.onlineY = ((float) Math.floor(this.avatarY)) + AndroidUtilities.dp(24.0f) + ((float) Math.floor(AndroidUtilities.density * 11.0f)) + ((this.avatarContainer.getMeasuredHeight() * (this.avatarScale - 1.4285715f)) / 2.0f);
    }

    public RecyclerListView getListView() {
        return this.listView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void needLayoutText(float f) {
        float scaleX = this.nameTextView[1].getScaleX();
        float f2 = this.extraHeight > ((float) AndroidUtilities.dp(88.0f)) ? 1.67f : 1.12f;
        if (this.extraHeight <= AndroidUtilities.dp(88.0f) || scaleX == f2) {
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
            float f3 = iDp;
            int iMax = (int) ((f3 - (iDp2 * Math.max(0.0f, 1.0f - (f != 1.0f ? (0.15f * f) / (1.0f - f) : 1.0f)))) - this.nameTextView[1].getTranslationX());
            float fMeasureText = (this.nameTextView[1].getPaint().measureText(this.nameTextView[1].getText().toString()) * scaleX) + this.nameTextView[1].getSideDrawablesSize();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nameTextView[1].getLayoutParams();
            int i3 = layoutParams.width;
            float f4 = iMax;
            if (f4 < fMeasureText) {
                layoutParams.width = Math.max(i2, (int) Math.ceil((iMax - AndroidUtilities.dp(24.0f)) / (((f2 - scaleX) * 7.0f) + scaleX)));
            } else {
                layoutParams.width = (int) Math.ceil(fMeasureText);
            }
            layoutParams.width = (int) Math.min(((f3 - this.nameTextView[1].getX()) / scaleX) - AndroidUtilities.dp(8.0f), layoutParams.width);
            if (isRtlLayout()) {
                SimpleTextView[] simpleTextViewArr = this.nameTextView;
                if (simpleTextViewArr[0] != null && simpleTextViewArr[0].getLayoutParams() != null) {
                    this.nameTextView[0].getLayoutParams().width = layoutParams.width;
                }
            }
            if (layoutParams.width != i3) {
                this.nameTextView[1].requestLayout();
            }
            float fMeasureText2 = this.onlineTextView[1].getPaint().measureText(this.onlineTextView[1].getText().toString());
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.onlineTextView[1].getLayoutParams();
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.mediaCounterTextView.getLayoutParams();
            int i4 = layoutParams2.width;
            if (!isRtlLayout()) {
                int iCeil = (int) Math.ceil(this.onlineTextView[1].getTranslationX() + AndroidUtilities.dp(8.0f) + (AndroidUtilities.dp(40.0f) * (1.0f - f)));
                layoutParams2.rightMargin = iCeil;
                layoutParams3.rightMargin = iCeil;
            }
            if (f4 < fMeasureText2) {
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
        view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: org.rbmain.ui.ProfileActivity.30
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                ProfileActivity profileActivity = ProfileActivity.this;
                if (profileActivity.fragmentView != null) {
                    profileActivity.checkListViewScroll();
                    ProfileActivity.this.needLayout(true);
                    ProfileActivity.this.fragmentView.getViewTreeObserver().removeOnPreDrawListener(this);
                }
                return true;
            }
        });
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onConfigurationChanged(Configuration configuration) {
        View viewFindViewByPosition;
        super.onConfigurationChanged(configuration);
        SharedMediaLayout sharedMediaLayout = this.sharedMediaLayout;
        if (sharedMediaLayout != null) {
            sharedMediaLayout.onConfigurationChanged(configuration);
        }
        invalidateIsInLandscapeMode();
        if (this.isInLandscapeMode && this.isPulledDown && (viewFindViewByPosition = this.layoutManager.findViewByPosition(0)) != null) {
            this.listView.scrollBy(0, viewFindViewByPosition.getTop() - AndroidUtilities.dp(88.0f));
        }
        fixLayout();
    }

    private void invalidateIsInLandscapeMode() {
        Point point = new Point();
        Activity parentActivity = getParentActivity();
        if (parentActivity == null) {
            parentActivity = ApplicationLoader.applicationActivity;
        }
        if (parentActivity != null) {
            parentActivity.getWindowManager().getDefaultDisplay().getSize(point);
            this.isInLandscapeMode = point.x > point.y;
        }
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, final Object... objArr) {
        int i3;
        int i4;
        TLRPC$Chat tLRPC$Chat;
        RecyclerListView recyclerListView;
        RecyclerListView recyclerListView2;
        RecyclerListView.Holder holder;
        int i5 = 0;
        if (i == NotificationCenter.updateInterfaces) {
            int iIntValue = ((Integer) objArr[0]).intValue();
            boolean z = ((iIntValue & 2) == 0 && (iIntValue & 1) == 0 && (iIntValue & 4) == 0) ? false : true;
            if (this.user_id != 0) {
                if (z) {
                    updateProfileData();
                }
                if ((iIntValue & 1024) == 0 || (recyclerListView2 = this.listView) == null || (holder = (RecyclerListView.Holder) recyclerListView2.findViewHolderForPosition(this.phoneRow)) == null) {
                    return;
                }
                this.listAdapter.onBindViewHolder(holder, this.phoneRow);
                return;
            }
            if (this.chat_id != 0) {
                int i6 = iIntValue & 8192;
                if (i6 != 0 || (iIntValue & 8) != 0 || (iIntValue & 16) != 0 || (iIntValue & 32) != 0 || (iIntValue & 4) != 0) {
                    if (objArr.length == 2 && (objArr[1] instanceof Boolean) && ((Boolean) objArr[1]).booleanValue()) {
                        this.avatarsViewPager.addImage(ImageLocation.getForUserOrChat(this.currentChat, 0), ImageLocation.getForUserOrChat(this.currentChat, 1));
                    }
                    if (i6 != 0) {
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
                while (i5 < childCount) {
                    View childAt = this.listView.getChildAt(i5);
                    if (childAt instanceof UserCell) {
                        ((UserCell) childAt).update(iIntValue);
                    }
                    i5++;
                }
                return;
            }
            return;
        }
        if (i == NotificationCenter.chatOnlineCountDidLoad) {
            Integer num = (Integer) objArr[0];
            if (this.chatInfo == null || (tLRPC$Chat = this.currentChat) == null || tLRPC$Chat.id != num.intValue()) {
                return;
            }
            this.chatInfo.online_count = ((Integer) objArr[1]).intValue();
            updateOnlineCount(true);
            updateProfileData();
            return;
        }
        if (i == NotificationCenter.contactsDidLoad) {
            createActionBarMenu(true);
            return;
        }
        if (i == NotificationCenter.encryptedChatCreated) {
            if (this.creatingChat) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ProfileActivity$$ExternalSyntheticLambda24
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$didReceivedNotification$25(objArr);
                    }
                });
                return;
            }
            return;
        }
        if (i == NotificationCenter.encryptedChatUpdated) {
            TLRPC$EncryptedChat tLRPC$EncryptedChat = (TLRPC$EncryptedChat) objArr[0];
            TLRPC$EncryptedChat tLRPC$EncryptedChat2 = this.currentEncryptedChat;
            if (tLRPC$EncryptedChat2 == null || tLRPC$EncryptedChat.id != tLRPC$EncryptedChat2.id) {
                return;
            }
            this.currentEncryptedChat = tLRPC$EncryptedChat;
            updateListAnimated(false);
            updateTimeItem();
            return;
        }
        if (i == NotificationCenter.blockedUsersDidLoad) {
            boolean z2 = this.userBlocked;
            boolean z3 = getMessagesController().blockePeers.indexOfKey(this.user_id) >= 0;
            this.userBlocked = z3;
            if (z2 != z3) {
                createActionBarMenu(true);
                updateListAnimated(false);
                return;
            }
            return;
        }
        if (i == NotificationCenter.groupCallUpdated) {
            Integer num2 = (Integer) objArr[0];
            if (this.currentChat != null) {
                int iIntValue2 = num2.intValue();
                TLRPC$Chat tLRPC$Chat2 = this.currentChat;
                if (iIntValue2 == tLRPC$Chat2.id && ChatObject.canManageCalls(tLRPC$Chat2)) {
                    TLRPC$ChatFull chatFull = MessagesController.getInstance(this.currentAccount).getChatFull(num2.intValue());
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
        if (i == NotificationCenter.chatInfoDidLoad) {
            TLRPC$ChatFull tLRPC$ChatFull3 = (TLRPC$ChatFull) objArr[0];
            if (tLRPC$ChatFull3.id == this.chat_id) {
                ((Boolean) objArr[2]).booleanValue();
                TLRPC$ChatFull tLRPC$ChatFull4 = this.chatInfo;
                if ((tLRPC$ChatFull4 instanceof TLRPC$TL_channelFull) && tLRPC$ChatFull3.participants == null) {
                    tLRPC$ChatFull3.participants = tLRPC$ChatFull4.participants;
                }
                if (tLRPC$ChatFull4 == null && (tLRPC$ChatFull3 instanceof TLRPC$TL_channelFull)) {
                    i5 = 1;
                }
                this.chatInfo = tLRPC$ChatFull3;
                if (this.mergeDialogId == 0 && (i4 = tLRPC$ChatFull3.migrated_from_chat_id) != 0) {
                    this.mergeDialogId = -i4;
                    getMediaDataController().getMediaCount(this.mergeDialogId, 0, this.classGuid, true);
                }
                fetchUsersFromChannelInfo();
                ProfileGalleryView profileGalleryView = this.avatarsViewPager;
                if (profileGalleryView != null) {
                    profileGalleryView.setChatInfo(this.chatInfo);
                }
                updateListAnimated(true);
                TLRPC$Chat chat = getMessagesController().getChat(Integer.valueOf(this.chat_id));
                if (chat != null) {
                    this.currentChat = chat;
                    createActionBarMenu(true);
                    updateProfileData();
                }
                if (this.currentChat.megagroup && i5 != 0) {
                    getChannelParticipants(true);
                }
                updateTimeItem();
                return;
            }
            return;
        }
        if (i == NotificationCenter.closeChats) {
            if (this.isMyUser) {
                return;
            }
            removeSelfFromStack();
            return;
        }
        if (i == NotificationCenter.botInfoDidLoad) {
            TLRPC$BotInfo tLRPC$BotInfo = (TLRPC$BotInfo) objArr[0];
            if (tLRPC$BotInfo.user_id == this.user_id) {
                this.botInfo = tLRPC$BotInfo;
                updateListAnimated(false);
                return;
            }
            return;
        }
        if (i == NotificationCenter.userInfoDidLoad) {
            if (((Integer) objArr[0]).intValue() == this.user_id) {
                TLRPC$UserFull tLRPC$UserFull = (TLRPC$UserFull) objArr[1];
                this.userInfo = tLRPC$UserFull;
                if (this.imageUpdater != null) {
                    if (!TextUtils.equals(tLRPC$UserFull.about, this.currentBio)) {
                        this.listAdapter.notifyItemChanged(this.bioRow);
                    }
                } else {
                    if (!this.openAnimationInProgress) {
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
        if (i == NotificationCenter.didReceiveNewMessages) {
            if (!((Boolean) objArr[2]).booleanValue() && getDialogId() == ((Long) objArr[0]).longValue()) {
                ArrayList arrayList = (ArrayList) objArr[1];
                while (i5 < arrayList.size()) {
                    MessageObject messageObject = (MessageObject) arrayList.get(i5);
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
                    i5++;
                }
                return;
            }
            return;
        }
        if (i == NotificationCenter.emojiDidLoad) {
            RecyclerListView recyclerListView3 = this.listView;
            if (recyclerListView3 != null) {
                recyclerListView3.invalidateViews();
                return;
            }
            return;
        }
        if (i == NotificationCenter.reloadInterface) {
            int i7 = this.emptyRow;
            updateRowsIds();
            ListAdapter listAdapter2 = this.listAdapter;
            if (listAdapter2 == null || i7 == (i3 = this.emptyRow)) {
                return;
            }
            if (i3 == -1) {
                listAdapter2.notifyItemRemoved(i3);
            } else {
                listAdapter2.notifyItemInserted(i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$didReceivedNotification$25(Object[] objArr) {
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
            if (this.userInfo.ttl_period != 0) {
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
            if (this.chatInfo.ttl_period != 0) {
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

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean needDelayOpenAnimation() {
        return this.playProfileAnimation == 0;
    }

    @Override // org.rbmain.ui.Components.SharedMediaLayout.SharedMediaPreloaderDelegate
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

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        SharedMediaLayout sharedMediaLayout = this.sharedMediaLayout;
        if (sharedMediaLayout != null) {
            sharedMediaLayout.onResume();
        }
        invalidateIsInLandscapeMode();
        if (this.listAdapter != null) {
            this.firstLayout = true;
            if (this.listView != null) {
                FirebaseEventSender.setKey("recyclerViewState", this.listView.getScrollState() + " " + this.listView.isComputingLayout());
                this.listView.stopScroll();
            } else {
                FirebaseEventSender.setKey("recyclerViewState", "null");
            }
            this.listAdapter.notifyDataSetChanged();
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
        TLRPC$User user = getMessagesController().getUser(Integer.valueOf(this.user_id));
        if (user != null && UserObject.isUserSelf(user)) {
            callGetSettings();
        }
        TopView topView = this.topView;
        if (topView != null) {
            topView.requestLayout();
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
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

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean isSwipeBackEnabled(MotionEvent motionEvent) {
        SharedMediaLayout sharedMediaLayout;
        if (this.sharedMediaRow == -1 || (sharedMediaLayout = this.sharedMediaLayout) == null) {
            return true;
        }
        sharedMediaLayout.getHitRect(this.rect);
        if (this.rect.contains((int) motionEvent.getX(), ((int) motionEvent.getY()) - this.actionBar.getMeasuredHeight())) {
            return this.sharedMediaLayout.isCurrentTabFirst();
        }
        return true;
    }

    public UndoView getUndoView() {
        return this.undoView;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onBackPressed() {
        SharedMediaLayout sharedMediaLayout;
        return this.actionBar.isEnabled() && (this.sharedMediaRow == -1 || (sharedMediaLayout = this.sharedMediaLayout) == null || !sharedMediaLayout.closeActionMode());
    }

    public boolean isSettings() {
        return this.imageUpdater != null;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    protected void onBecomeFullyHidden() {
        UndoView undoView = this.undoView;
        if (undoView != null) {
            undoView.hide(true, 0);
        }
    }

    public void setPlayProfileAnimation(int i) {
        SharedPreferences globalMainSettings = MessagesController.getGlobalMainSettings();
        if (AndroidUtilities.isTablet()) {
            return;
        }
        if (globalMainSettings.getBoolean("view_animations", true)) {
            this.playProfileAnimation = i;
        } else if (i == 2) {
            this.expandPhoto = true;
        }
    }

    private void updateSharedMediaRows() {
        if (this.listAdapter == null) {
            return;
        }
        updateListAnimated(false);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    protected void onTransitionAnimationStart(boolean z, boolean z2) {
        this.isFragmentOpened = z;
        if (((!z && z2) || (z && !z2)) && this.playProfileAnimation != 0 && this.allowProfileAnimation && !this.isPulledDown) {
            this.openAnimationInProgress = true;
        }
        if (z) {
            if (this.imageUpdater != null) {
                this.transitionIndex = getNotificationCenter().setAnimationInProgress(this.transitionIndex, new int[]{NotificationCenter.dialogsNeedReload, NotificationCenter.closeChats, NotificationCenter.mediaCountDidLoad, NotificationCenter.mediaCountsDidLoad, NotificationCenter.userInfoDidLoad});
            } else {
                this.transitionIndex = getNotificationCenter().setAnimationInProgress(this.transitionIndex, new int[]{NotificationCenter.dialogsNeedReload, NotificationCenter.closeChats, NotificationCenter.mediaCountDidLoad, NotificationCenter.mediaCountsDidLoad});
            }
        }
        this.transitionAnimationInProress = true;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    protected void onTransitionAnimationEnd(boolean z, boolean z2) {
        if (z) {
            if (!z2) {
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
    public void setAnimationProgress(float f) {
        int profileBackColorForId;
        int i;
        int profileTextColorForId;
        this.animationProgress = f;
        this.listView.setAlpha(f);
        this.listView.setTranslationX(AndroidUtilities.dp(48.0f) - (AndroidUtilities.dp(48.0f) * f));
        int i2 = 2;
        if (this.playProfileAnimation != 2 || (profileBackColorForId = this.avatarColor) == 0) {
            profileBackColorForId = AvatarDrawable.getProfileBackColorForId((this.user_id != 0 || (ChatObject.isChannel(this.chat_id, this.currentAccount) && !this.currentChat.megagroup)) ? 5L : this.chat_id);
        }
        int color = Theme.getColor(Theme.key_actionBarDefault);
        this.topView.setBackgroundColor(Color.rgb(Color.red(color) + ((int) ((Color.red(profileBackColorForId) - r7) * f)), Color.green(color) + ((int) ((Color.green(profileBackColorForId) - r8) * f)), Color.blue(color) + ((int) ((Color.blue(profileBackColorForId) - r6) * f))));
        int iconColorForId = AvatarDrawable.getIconColorForId((this.user_id != 0 || (ChatObject.isChannel(this.chat_id, this.currentAccount) && !this.currentChat.megagroup)) ? 5L : this.chat_id);
        int color2 = Theme.getColor(Theme.key_actionBarDefaultIcon);
        Color.red(color2);
        Color.green(color2);
        Color.blue(color2);
        Color.red(iconColorForId);
        Color.green(iconColorForId);
        Color.blue(iconColorForId);
        int color3 = Theme.getColor(Theme.key_profile_title);
        int color4 = Theme.getColor(Theme.key_actionBarDefaultTitle);
        int iRed = Color.red(color4);
        int iGreen = Color.green(color4);
        int iBlue = Color.blue(color4);
        int iAlpha = Color.alpha(color4);
        int iRed2 = (int) ((Color.red(color3) - iRed) * f);
        int iGreen2 = (int) ((Color.green(color3) - iGreen) * f);
        int iBlue2 = (int) ((Color.blue(color3) - iBlue) * f);
        int iAlpha2 = (int) ((Color.alpha(color3) - iAlpha) * f);
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
            profileTextColorForId = Theme.getColor(Theme.key_profile_status);
        } else {
            profileTextColorForId = AvatarDrawable.getProfileTextColorForId((this.user_id != 0 || (ChatObject.isChannel(this.chat_id, this.currentAccount) && !this.currentChat.megagroup)) ? 5L : this.chat_id);
        }
        int color5 = Theme.getColor(this.isOnline[0] ? Theme.key_chat_status : Theme.key_actionBarDefaultSubtitle);
        int iRed3 = Color.red(color5);
        int iGreen3 = Color.green(color5);
        int iBlue3 = Color.blue(color5);
        int iAlpha3 = Color.alpha(color5);
        int iRed4 = (int) ((Color.red(profileTextColorForId) - iRed3) * f);
        int iGreen4 = (int) ((Color.green(profileTextColorForId) - iGreen3) * f);
        int iBlue4 = (int) ((Color.blue(profileTextColorForId) - iBlue3) * f);
        int iAlpha4 = (int) ((Color.alpha(profileTextColorForId) - iAlpha3) * f);
        int i4 = 2;
        int i5 = 0;
        while (i5 < i4) {
            SimpleTextView[] simpleTextViewArr2 = this.onlineTextView;
            if (simpleTextViewArr2[i5] != null && (i5 != i || this.playProfileAnimation != i4)) {
                simpleTextViewArr2[i5].setTextColor(Color.argb(iAlpha3 + iAlpha4, iRed3 + iRed4, iGreen3 + iGreen4, iBlue3 + iBlue4));
            }
            i5++;
            i4 = 2;
            i = 1;
        }
        this.extraHeight = this.initialAnimationExtraHeight * f;
        int i6 = this.user_id;
        if (i6 == 0) {
            i6 = this.chat_id;
        }
        int profileColorForId = AvatarDrawable.getProfileColorForId(i6);
        int i7 = this.user_id;
        if (i7 == 0) {
            i7 = this.chat_id;
        }
        int colorForId = AvatarDrawable.getColorForId(i7);
        if (profileColorForId != colorForId) {
            this.avatarDrawable.setColor(Color.rgb(Color.red(colorForId) + ((int) ((Color.red(profileColorForId) - Color.red(colorForId)) * f)), Color.green(colorForId) + ((int) ((Color.green(profileColorForId) - Color.green(colorForId)) * f)), Color.blue(colorForId) + ((int) ((Color.blue(profileColorForId) - Color.blue(colorForId)) * f))));
            this.avatarImage.invalidate();
        }
        this.topView.invalidate();
        needLayout(true);
        this.fragmentView.invalidate();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    protected AnimatorSet onCustomTransitionAnimation(boolean z, final Runnable runnable) {
        if (this.playProfileAnimation == 0 || !this.allowProfileAnimation || this.isPulledDown) {
            return null;
        }
        final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(this.playProfileAnimation == 2 ? 250L : 180L);
        this.listView.setLayerType(2, null);
        ActionBarMenu actionBarMenuCreateMenu = this.actionBar.createMenu();
        if (actionBarMenuCreateMenu.getItem(10) == null && this.animatingItem == null) {
            this.animatingItem = actionBarMenuCreateMenu.addItem(10, R.drawable.ic_ab_other);
        }
        if (z) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.onlineTextView[1].getLayoutParams();
            if (!isRtlLayout()) {
                layoutParams.rightMargin = (int) ((AndroidUtilities.density * (-21.0f)) + AndroidUtilities.dp(8.0f));
            }
            this.onlineTextView[1].setLayoutParams(layoutParams);
            if (this.playProfileAnimation != 2) {
                if (!isRtlLayout()) {
                    int iCeil = (int) Math.ceil((AndroidUtilities.displaySize.x - AndroidUtilities.dp(126.0f)) + (AndroidUtilities.density * 21.0f));
                    float fMeasureText = (this.nameTextView[1].getPaint().measureText(this.nameTextView[1].getText().toString()) * 1.12f) + this.nameTextView[1].getSideDrawablesSize();
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.nameTextView[1].getLayoutParams();
                    if (iCeil < fMeasureText) {
                        layoutParams2.width = (int) Math.ceil(r12 / 1.12f);
                    } else {
                        layoutParams2.width = -2;
                    }
                    this.nameTextView[1].setLayoutParams(layoutParams2);
                }
                this.initialAnimationExtraHeight = AndroidUtilities.dp(88.0f);
            } else if (!isRtlLayout()) {
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.nameTextView[1].getLayoutParams();
                layoutParams3.width = (int) ((AndroidUtilities.displaySize.x - AndroidUtilities.dp(32.0f)) / 1.67f);
                this.nameTextView[1].setLayoutParams(layoutParams3);
            }
            this.fragmentView.setBackgroundColor(0);
            setAnimationProgress(0.0f);
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this, "animationProgress", 0.0f, 1.0f));
            RLottieImageView rLottieImageView = this.writeButton;
            if (rLottieImageView != null && rLottieImageView.getTag() == null) {
                this.writeButton.setScaleX(0.2f);
                this.writeButton.setScaleY(0.2f);
                this.writeButton.setAlpha(0.0f);
                arrayList.add(ObjectAnimator.ofFloat(this.writeButton, (Property<RLottieImageView, Float>) View.SCALE_X, 1.0f));
                arrayList.add(ObjectAnimator.ofFloat(this.writeButton, (Property<RLottieImageView, Float>) View.SCALE_Y, 1.0f));
                arrayList.add(ObjectAnimator.ofFloat(this.writeButton, (Property<RLottieImageView, Float>) View.ALPHA, 1.0f));
            }
            if (this.playProfileAnimation == 2) {
                this.avatarColor = AndroidUtilities.calcBitmapColor(this.avatarImage.getImageReceiver().getBitmap());
                this.nameTextView[1].setTextColor(-1);
                this.onlineTextView[1].setTextColor(Color.argb(179, 255, 255, 255));
                this.actionBar.setItemsBackgroundColor(1090519039, false);
                this.overlaysView.setOverlaysVisible();
            }
            int i = 0;
            while (i < 2) {
                this.onlineTextView[i].setAlpha(i == 0 ? 1.0f : 0.0f);
                this.nameTextView[i].setAlpha(i == 0 ? 1.0f : 0.0f);
                SimpleTextView simpleTextView = this.onlineTextView[i];
                Property property = View.ALPHA;
                float[] fArr = new float[1];
                fArr[0] = i == 0 ? 0.0f : 1.0f;
                arrayList.add(ObjectAnimator.ofFloat(simpleTextView, (Property<SimpleTextView, Float>) property, fArr));
                SimpleTextView simpleTextView2 = this.nameTextView[i];
                Property property2 = View.ALPHA;
                float[] fArr2 = new float[1];
                fArr2[0] = i == 0 ? 0.0f : 1.0f;
                arrayList.add(ObjectAnimator.ofFloat(simpleTextView2, (Property<SimpleTextView, Float>) property2, fArr2));
                i++;
            }
            if (this.timeItem.getTag() != null) {
                arrayList.add(ObjectAnimator.ofFloat(this.timeItem, (Property<ImageView, Float>) View.ALPHA, 0.0f));
                arrayList.add(ObjectAnimator.ofFloat(this.timeItem, (Property<ImageView, Float>) View.SCALE_X, 0.0f));
                arrayList.add(ObjectAnimator.ofFloat(this.timeItem, (Property<ImageView, Float>) View.SCALE_Y, 0.0f));
            }
            ActionBarMenuItem actionBarMenuItem = this.animatingItem;
            if (actionBarMenuItem != null) {
                actionBarMenuItem.setAlpha(1.0f);
                arrayList.add(ObjectAnimator.ofFloat(this.animatingItem, (Property<ActionBarMenuItem, Float>) View.ALPHA, 0.0f));
            }
            if (this.callItemVisible) {
                this.callItem.setAlpha(0.0f);
                arrayList.add(ObjectAnimator.ofFloat(this.callItem, (Property<ActionBarMenuItem, Float>) View.ALPHA, 1.0f));
            }
            if (this.videoCallItemVisible) {
                this.videoCallItem.setAlpha(0.0f);
                arrayList.add(ObjectAnimator.ofFloat(this.videoCallItem, (Property<ActionBarMenuItem, Float>) View.ALPHA, 1.0f));
            }
            if (this.editItemVisible) {
                this.editItem.setAlpha(0.0f);
                arrayList.add(ObjectAnimator.ofFloat(this.editItem, (Property<ActionBarMenuItem, Float>) View.ALPHA, 1.0f));
            }
            animatorSet.playTogether(arrayList);
        } else {
            this.initialAnimationExtraHeight = this.extraHeight;
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(ObjectAnimator.ofFloat(this, "animationProgress", 1.0f, 0.0f));
            RLottieImageView rLottieImageView2 = this.writeButton;
            if (rLottieImageView2 != null) {
                arrayList2.add(ObjectAnimator.ofFloat(rLottieImageView2, (Property<RLottieImageView, Float>) View.SCALE_X, 0.2f));
                arrayList2.add(ObjectAnimator.ofFloat(this.writeButton, (Property<RLottieImageView, Float>) View.SCALE_Y, 0.2f));
                arrayList2.add(ObjectAnimator.ofFloat(this.writeButton, (Property<RLottieImageView, Float>) View.ALPHA, 0.0f));
            }
            int i2 = 0;
            while (i2 < 2) {
                SimpleTextView simpleTextView3 = this.onlineTextView[i2];
                Property property3 = View.ALPHA;
                float[] fArr3 = new float[1];
                fArr3[0] = i2 == 0 ? 1.0f : 0.0f;
                arrayList2.add(ObjectAnimator.ofFloat(simpleTextView3, (Property<SimpleTextView, Float>) property3, fArr3));
                SimpleTextView simpleTextView4 = this.nameTextView[i2];
                Property property4 = View.ALPHA;
                float[] fArr4 = new float[1];
                fArr4[0] = i2 == 0 ? 1.0f : 0.0f;
                arrayList2.add(ObjectAnimator.ofFloat(simpleTextView4, (Property<SimpleTextView, Float>) property4, fArr4));
                i2++;
            }
            if (this.timeItem.getTag() != null) {
                arrayList2.add(ObjectAnimator.ofFloat(this.timeItem, (Property<ImageView, Float>) View.ALPHA, 1.0f));
                arrayList2.add(ObjectAnimator.ofFloat(this.timeItem, (Property<ImageView, Float>) View.SCALE_X, 1.0f));
                arrayList2.add(ObjectAnimator.ofFloat(this.timeItem, (Property<ImageView, Float>) View.SCALE_Y, 1.0f));
            }
            ActionBarMenuItem actionBarMenuItem2 = this.animatingItem;
            if (actionBarMenuItem2 != null) {
                actionBarMenuItem2.setAlpha(0.0f);
                arrayList2.add(ObjectAnimator.ofFloat(this.animatingItem, (Property<ActionBarMenuItem, Float>) View.ALPHA, 1.0f));
            }
            if (this.callItemVisible) {
                this.callItem.setAlpha(1.0f);
                arrayList2.add(ObjectAnimator.ofFloat(this.callItem, (Property<ActionBarMenuItem, Float>) View.ALPHA, 0.0f));
            }
            if (this.videoCallItemVisible) {
                this.videoCallItem.setAlpha(1.0f);
                arrayList2.add(ObjectAnimator.ofFloat(this.videoCallItem, (Property<ActionBarMenuItem, Float>) View.ALPHA, 0.0f));
            }
            if (this.editItemVisible) {
                this.editItem.setAlpha(1.0f);
                arrayList2.add(ObjectAnimator.ofFloat(this.editItem, (Property<ActionBarMenuItem, Float>) View.ALPHA, 0.0f));
            }
            animatorSet.playTogether(arrayList2);
        }
        this.profileTransitionInProgress = true;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.ProfileActivity$$ExternalSyntheticLambda1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.lambda$onCustomTransitionAnimation$26(valueAnimator);
            }
        });
        animatorSet.playTogether(valueAnimatorOfFloat);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.ProfileActivity.31
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ProfileActivity.this.listView.setLayerType(0, null);
                if (ProfileActivity.this.animatingItem != null) {
                    ((BaseFragment) ProfileActivity.this).actionBar.createMenu().clearItems();
                    ProfileActivity.this.animatingItem = null;
                }
                runnable.run();
                if (ProfileActivity.this.playProfileAnimation == 2) {
                    ProfileActivity.this.playProfileAnimation = 1;
                    ProfileActivity.this.avatarImage.setForegroundAlpha(1.0f);
                    ProfileActivity.this.avatarContainer.setVisibility(8);
                    ProfileActivity.this.avatarsViewPager.resetCurrentItem();
                    ProfileActivity.this.avatarsViewPager.setVisibility(0);
                }
                ProfileActivity profileActivity = ProfileActivity.this;
                profileActivity.profileTransitionInProgress = false;
                profileActivity.fragmentView.invalidate();
            }
        });
        animatorSet.setInterpolator(this.playProfileAnimation == 2 ? CubicBezierInterpolator.DEFAULT : new DecelerateInterpolator());
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ProfileActivity$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                animatorSet.start();
            }
        }, 50L);
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCustomTransitionAnimation$26(ValueAnimator valueAnimator) {
        this.fragmentView.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateOnlineCount(boolean z) {
        TLRPC$UserStatus tLRPC$UserStatus;
        this.onlineCount = 0;
        final int currentTime = getConnectionsManager().getCurrentTime();
        this.sortedUsers.clear();
        TLRPC$ChatFull tLRPC$ChatFull = this.chatInfo;
        if ((tLRPC$ChatFull instanceof TLRPC$TL_chatFull) || ((tLRPC$ChatFull instanceof TLRPC$TL_channelFull) && tLRPC$ChatFull.participants_count <= 200 && tLRPC$ChatFull.participants != null)) {
            for (int i = 0; i < this.chatInfo.participants.participants.size(); i++) {
                TLRPC$User user = getMessagesController().getUser(Integer.valueOf(this.chatInfo.participants.participants.get(i).user_id));
                if (user != null && (tLRPC$UserStatus = user.status) != null && ((tLRPC$UserStatus.expires > currentTime || user.id == getUserConfig().getClientUserId()) && user.status.expires > 10000)) {
                    this.onlineCount++;
                }
                this.sortedUsers.add(Integer.valueOf(i));
            }
            try {
                Collections.sort(this.sortedUsers, new Comparator() { // from class: org.rbmain.ui.ProfileActivity$$ExternalSyntheticLambda25
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return this.f$0.lambda$updateOnlineCount$27(currentTime, (Integer) obj, (Integer) obj2);
                    }
                });
            } catch (Exception e) {
                FileLog.e(e);
            }
            if (z && this.listAdapter != null && this.membersStartRow > 0) {
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ int lambda$updateOnlineCount$27(int r5, java.lang.Integer r6, java.lang.Integer r7) {
        /*
            r4 = this;
            org.rbmain.messenger.MessagesController r0 = r4.getMessagesController()
            org.rbmain.tgnet.TLRPC$ChatFull r1 = r4.chatInfo
            org.rbmain.tgnet.TLRPC$ChatParticipants r1 = r1.participants
            java.util.ArrayList<org.rbmain.tgnet.TLRPC$ChatParticipant> r1 = r1.participants
            int r7 = r7.intValue()
            java.lang.Object r7 = r1.get(r7)
            org.rbmain.tgnet.TLRPC$ChatParticipant r7 = (org.rbmain.tgnet.TLRPC$ChatParticipant) r7
            int r7 = r7.user_id
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            org.rbmain.tgnet.TLRPC$User r7 = r0.getUser(r7)
            org.rbmain.messenger.MessagesController r0 = r4.getMessagesController()
            org.rbmain.tgnet.TLRPC$ChatFull r1 = r4.chatInfo
            org.rbmain.tgnet.TLRPC$ChatParticipants r1 = r1.participants
            java.util.ArrayList<org.rbmain.tgnet.TLRPC$ChatParticipant> r1 = r1.participants
            int r6 = r6.intValue()
            java.lang.Object r6 = r1.get(r6)
            org.rbmain.tgnet.TLRPC$ChatParticipant r6 = (org.rbmain.tgnet.TLRPC$ChatParticipant) r6
            int r6 = r6.user_id
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            org.rbmain.tgnet.TLRPC$User r6 = r0.getUser(r6)
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
            org.rbmain.tgnet.TLRPC$UserStatus r7 = r7.status
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
            org.rbmain.tgnet.TLRPC$UserStatus r5 = r6.status
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
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.ProfileActivity.lambda$updateOnlineCount$27(int, java.lang.Integer, java.lang.Integer):int");
    }

    public void setChatInfo(TLRPC$ChatFull tLRPC$ChatFull) {
        int i;
        this.chatInfo = tLRPC$ChatFull;
        if (tLRPC$ChatFull != null && (i = tLRPC$ChatFull.migrated_from_chat_id) != 0 && this.mergeDialogId == 0) {
            this.mergeDialogId = -i;
            getMediaDataController().getMediaCounts(this.mergeDialogId, this.classGuid);
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

    public void setUserInfo(TLRPC$UserFull tLRPC$UserFull) {
        this.userInfo = tLRPC$UserFull;
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

    private void kickUser(int i, TLRPC$ChatParticipant tLRPC$ChatParticipant) {
        if (i != 0) {
            TLRPC$User user = getMessagesController().getUser(Integer.valueOf(i));
            getMessagesController().deleteParticipantFromChat(this.chat_id, user, this.chatInfo);
            if (this.currentChat != null && user != null && BulletinFactory.canShowBulletin(this)) {
                BulletinFactory.createRemoveFromChatBulletin(this, user, this.currentChat.title).show();
            }
            if (this.chatInfo.participants.participants.remove(tLRPC$ChatParticipant)) {
                updateListAnimated(true);
                return;
            }
            return;
        }
        NotificationCenter notificationCenter = getNotificationCenter();
        int i2 = NotificationCenter.closeChats;
        notificationCenter.removeObserver(this, i2);
        if (AndroidUtilities.isTablet()) {
            getNotificationCenter().postNotificationName(i2, Long.valueOf(-this.chat_id));
        } else {
            getNotificationCenter().postNotificationName(i2, new Object[0]);
        }
        getMessagesController().deleteParticipantFromChat(this.chat_id, getMessagesController().getUser(Integer.valueOf(getUserConfig().getClientUserId())), this.chatInfo);
        this.playProfileAnimation = 0;
        finishFragment();
    }

    public boolean isChat() {
        return this.chat_id != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void updateRowsIds() {
        /*
            Method dump skipped, instructions count: 1305
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.ProfileActivity.updateRowsIds():void");
    }

    private Drawable getScamDrawable(int i) {
        if (this.scamDrawable == null) {
            ScamDrawable scamDrawable = new ScamDrawable(11, i);
            this.scamDrawable = scamDrawable;
            scamDrawable.setColor(Theme.getColor(Theme.key_avatar_subtitleInProfileBlue));
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
        if (this.verifiedDrawable != null) {
            this.verifiedDrawable.setColorFilter(AndroidUtilities.getOffsetColor(Theme.getColor(Theme.key_chats_verifiedBackground), Theme.getColor(Theme.key_player_actionBarTitle), 0.0f, 1.0f), PorterDuff.Mode.MULTIPLY);
        }
        if (this.verifiedCheckDrawable != null) {
            this.verifiedCheckDrawable.setColorFilter(AndroidUtilities.getOffsetColor(Theme.getColor(Theme.key_chats_verifiedCheck), Theme.getColor(Theme.key_windowBackgroundWhite), 1.0f, 1.0f), PorterDuff.Mode.MULTIPLY);
        }
        return this.verifiedCrossfadeDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0401  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x051c  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0538  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x060b  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x0618  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x061b  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x0633  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x063a  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x063d  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x067d  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x0685  */
    /* JADX WARN: Removed duplicated region for block: B:333:0x068a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void updateProfileData() {
        /*
            Method dump skipped, instructions count: 1736
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.ProfileActivity.updateProfileData():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:154:0x0376  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x03ad  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x03cc  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x03ef  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x04a8  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x04bf  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x04d6  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x04ed  */
    /* JADX WARN: Removed duplicated region for block: B:211:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void createActionBarMenu(boolean r17) {
        /*
            Method dump skipped, instructions count: 1269
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.ProfileActivity.createActionBarMenu(boolean):void");
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    protected void onDialogDismiss(Dialog dialog) {
        RecyclerListView recyclerListView = this.listView;
        if (recyclerListView != null) {
            recyclerListView.invalidateViews();
        }
    }

    @Override // org.rbmain.ui.DialogsActivity.DialogsActivityDelegate
    public void didSelectDialogs(DialogsActivity dialogsActivity, ArrayList<Long> arrayList, CharSequence charSequence, boolean z) {
        long jLongValue = arrayList.get(0).longValue();
        Bundle bundle = new Bundle();
        bundle.putBoolean("scrollToTopOnResume", true);
        int i = (int) jLongValue;
        if (i == 0) {
            bundle.putInt("enc_id", (int) (jLongValue >> 32));
        } else if (i > 0) {
            bundle.putInt("user_id", i);
        } else {
            bundle.putInt("chat_id", -i);
        }
        if (getMessagesController().checkCanOpenChat(bundle, dialogsActivity)) {
            NotificationCenter notificationCenter = getNotificationCenter();
            int i2 = NotificationCenter.closeChats;
            notificationCenter.removeObserver(this, i2);
            getNotificationCenter().postNotificationName(i2, new Object[0]);
            presentFragment(new ChatActivity(bundle), true);
            removeSelfFromStack();
            getSendMessagesHelper().sendMessage(getMessagesController().getUser(Integer.valueOf(this.user_id)), jLongValue, (MessageObject) null, (MessageObject) null, (TLRPC$ReplyMarkup) null, (HashMap<String, String>) null, true, 0);
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onRequestPermissionsResultFragment(int i, String[] strArr, int[] iArr) {
        boolean z;
        ImageUpdater imageUpdater = this.imageUpdater;
        if (imageUpdater != null) {
            imageUpdater.onRequestPermissionsResultFragment(i, strArr, iArr);
        }
        boolean z2 = false;
        if (i == 101 || i == 102) {
            TLRPC$User user = getMessagesController().getUser(Integer.valueOf(this.user_id));
            if (user == null) {
                return;
            }
            int i2 = 0;
            while (true) {
                if (i2 >= iArr.length) {
                    z = true;
                    break;
                } else {
                    if (iArr[i2] != 0) {
                        z = false;
                        break;
                    }
                    i2++;
                }
            }
            if (iArr.length > 0 && z) {
                boolean z3 = i == 102;
                TLRPC$UserFull tLRPC$UserFull = this.userInfo;
                VoIPHelper.startCall(user, z3, tLRPC$UserFull != null && tLRPC$UserFull.video_calls_available, getParentActivity(), this.userInfo, getAccountInstance());
                return;
            }
            VoIPHelper.permissionDenied(getParentActivity(), null, i);
            return;
        }
        if (i != 103 || this.currentChat == null) {
            return;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= iArr.length) {
                z2 = true;
                break;
            } else if (iArr[i3] != 0) {
                break;
            } else {
                i3++;
            }
        }
        if (iArr.length > 0 && z2) {
            VoIPHelper.startCall(this.currentChat, null, null, true, getParentActivity(), this, getAccountInstance());
        } else {
            VoIPHelper.permissionDenied(getParentActivity(), null, i);
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void dismissCurrentDialog() {
        ImageUpdater imageUpdater = this.imageUpdater;
        if (imageUpdater == null || !imageUpdater.dismissCurrentDialog(this.visibleDialog)) {
            super.dismissCurrentDialog();
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean dismissDialogOnPause(Dialog dialog) {
        ImageUpdater imageUpdater = this.imageUpdater;
        return (imageUpdater == null || imageUpdater.dismissDialogOnPause(dialog)) && super.dismissDialogOnPause(dialog);
    }

    @Override // org.rbmain.ui.Components.ImageUpdater.ImageUpdaterDelegate
    public void onUploadProgressChanged(float f) {
        RadialProgressView radialProgressView = this.avatarProgressView;
        if (radialProgressView == null) {
            return;
        }
        radialProgressView.setProgress(f);
        this.avatarsViewPager.setUploadProgress(this.uploadingImageLocation, f);
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
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ProfileActivity$$ExternalSyntheticLambda18
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$didUploadPhoto$31(tLRPC$InputFile, tLRPC$InputFile2, tLRPC$InputFile3, d, str, tLRPC$PhotoSize2, tLRPC$PhotoSize);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$didUploadPhoto$31(TLRPC$InputFile tLRPC$InputFile, TLRPC$InputFile tLRPC$InputFile2, TLRPC$InputFile tLRPC$InputFile3, double d, final String str, TLRPC$PhotoSize tLRPC$PhotoSize, TLRPC$PhotoSize tLRPC$PhotoSize2) {
        if ((tLRPC$InputFile != null && tLRPC$InputFile2 != null) || tLRPC$InputFile3 != null) {
            TLRPC$TL_photos_uploadProfilePhoto tLRPC$TL_photos_uploadProfilePhoto = new TLRPC$TL_photos_uploadProfilePhoto();
            if (tLRPC$InputFile != null && tLRPC$InputFile2 != null) {
                tLRPC$TL_photos_uploadProfilePhoto.file = tLRPC$InputFile;
                tLRPC$TL_photos_uploadProfilePhoto.smallFile = tLRPC$InputFile2;
                tLRPC$TL_photos_uploadProfilePhoto.flags |= 1;
            }
            if (tLRPC$InputFile3 != null) {
                tLRPC$TL_photos_uploadProfilePhoto.video = tLRPC$InputFile3;
                int i = tLRPC$TL_photos_uploadProfilePhoto.flags | 2;
                tLRPC$TL_photos_uploadProfilePhoto.flags = i;
                tLRPC$TL_photos_uploadProfilePhoto.video_start_ts = d;
                tLRPC$TL_photos_uploadProfilePhoto.flags = i | 4;
            }
            getAccountInstance().getFileProxy().sendUploadPhotoReq(tLRPC$TL_photos_uploadProfilePhoto, new RequestDelegate() { // from class: org.rbmain.ui.ProfileActivity$$ExternalSyntheticLambda31
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$didUploadPhoto$30(str, tLObject, tLRPC$TL_error);
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

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$didUploadPhoto$30(final String str, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ProfileActivity$$ExternalSyntheticLambda21
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$didUploadPhoto$29(tLRPC$TL_error, tLObject, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$didUploadPhoto$29(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, String str) {
        this.avatarsViewPager.removeUploadingImage(this.uploadingImageLocation);
        if (tLRPC$TL_error == null) {
            TLRPC$User user = getMessagesController().getUser(Integer.valueOf(getUserConfig().getClientUserId()));
            if (user == null) {
                user = getUserConfig().getCurrentUser();
                if (user == null) {
                    return;
                } else {
                    getMessagesController().putUser(user, false);
                }
            } else {
                user.access_hash = this.user_id;
                getUserConfig().setCurrentUser(user);
            }
            TLRPC$TL_photos_photo tLRPC$TL_photos_photo = (TLRPC$TL_photos_photo) tLObject;
            ArrayList<TLRPC$PhotoSize> arrayList = tLRPC$TL_photos_photo.photo.sizes;
            TLRPC$PhotoSize closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(arrayList, ImageReceiver.DEFAULT_CROSSFADE_DURATION);
            TLRPC$PhotoSize closestPhotoSizeWithSize2 = FileLoader.getClosestPhotoSizeWithSize(arrayList, MediaController.MAX_WIDTH_HEIGHT_SIZE);
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

    private void showAvatarProgress(final boolean z, boolean z2) {
        if (this.avatarProgressView == null) {
            return;
        }
        AnimatorSet animatorSet = this.avatarAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.avatarAnimation = null;
        }
        if (!z2) {
            if (z) {
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
        if (z) {
            this.avatarProgressView.setVisibility(0);
            this.avatarAnimation.playTogether(ObjectAnimator.ofFloat(this.avatarProgressView, (Property<RadialProgressView, Float>) View.ALPHA, 1.0f));
        } else {
            animatorSet2.playTogether(ObjectAnimator.ofFloat(this.avatarProgressView, (Property<RadialProgressView, Float>) View.ALPHA, 0.0f));
        }
        this.avatarAnimation.setDuration(180L);
        this.avatarAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.ProfileActivity.33
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (ProfileActivity.this.avatarAnimation == null || ProfileActivity.this.avatarProgressView == null) {
                    return;
                }
                if (!z) {
                    ProfileActivity.this.avatarProgressView.setVisibility(4);
                }
                ProfileActivity.this.avatarAnimation = null;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                ProfileActivity.this.avatarAnimation = null;
            }
        });
        this.avatarAnimation.start();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onActivityResultFragment(int i, int i2, Intent intent) throws IllegalAccessException, NoSuchFieldException, Resources.NotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException {
        ImageUpdater imageUpdater = this.imageUpdater;
        if (imageUpdater != null) {
            imageUpdater.onActivityResult(i, i2, intent);
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void saveSelfArgs(Bundle bundle) {
        String str;
        ImageUpdater imageUpdater = this.imageUpdater;
        if (imageUpdater == null || (str = imageUpdater.currentPicturePath) == null) {
            return;
        }
        bundle.putString("path", str);
    }

    public void restoreSelfArgs(Bundle bundle) {
        ImageUpdater imageUpdater = this.imageUpdater;
        if (imageUpdater != null) {
            imageUpdater.currentPicturePath = bundle.getString("path");
        }
    }

    private void sendLogs() {
        if (getParentActivity() == null) {
            return;
        }
        final AlertDialog alertDialog = new AlertDialog(getParentActivity(), 3);
        alertDialog.setCanCancel(false);
        alertDialog.show();
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.ui.ProfileActivity$$ExternalSyntheticLambda22
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f$0.lambda$sendLogs$33(alertDialog);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x00a4: MOVE (r1 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]), block:B:39:0x00a4 */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0094 A[Catch: Exception -> 0x00b0, TRY_ENTER, TryCatch #0 {Exception -> 0x00b0, blocks: (B:2:0x0000, B:4:0x002e, B:5:0x0031, B:34:0x0094, B:21:0x007f, B:37:0x009a, B:41:0x00a7, B:43:0x00ac, B:44:0x00af), top: B:48:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$sendLogs$33(final org.rbmain.ui.ActionBar.AlertDialog r14) throws java.lang.Throwable {
        /*
            r13 = this;
            android.content.Context r0 = org.rbmain.messenger.ApplicationLoader.applicationContext     // Catch: java.lang.Exception -> Lb0
            r1 = 0
            java.io.File r0 = r0.getExternalFilesDir(r1)     // Catch: java.lang.Exception -> Lb0
            java.io.File r2 = new java.io.File     // Catch: java.lang.Exception -> Lb0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lb0
            r3.<init>()     // Catch: java.lang.Exception -> Lb0
            java.lang.String r0 = r0.getAbsolutePath()     // Catch: java.lang.Exception -> Lb0
            r3.append(r0)     // Catch: java.lang.Exception -> Lb0
            java.lang.String r0 = "/logs"
            r3.append(r0)     // Catch: java.lang.Exception -> Lb0
            java.lang.String r0 = r3.toString()     // Catch: java.lang.Exception -> Lb0
            r2.<init>(r0)     // Catch: java.lang.Exception -> Lb0
            java.io.File r0 = new java.io.File     // Catch: java.lang.Exception -> Lb0
            java.lang.String r3 = "logs.zip"
            r0.<init>(r2, r3)     // Catch: java.lang.Exception -> Lb0
            boolean r3 = r0.exists()     // Catch: java.lang.Exception -> Lb0
            if (r3 == 0) goto L31
            r0.delete()     // Catch: java.lang.Exception -> Lb0
        L31:
            java.io.File[] r2 = r2.listFiles()     // Catch: java.lang.Exception -> Lb0
            r3 = 1
            boolean[] r4 = new boolean[r3]     // Catch: java.lang.Exception -> Lb0
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L88 java.lang.Exception -> L8b
            r5.<init>(r0)     // Catch: java.lang.Throwable -> L88 java.lang.Exception -> L8b
            java.util.zip.ZipOutputStream r6 = new java.util.zip.ZipOutputStream     // Catch: java.lang.Throwable -> L88 java.lang.Exception -> L8b
            java.io.BufferedOutputStream r7 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L88 java.lang.Exception -> L8b
            r7.<init>(r5)     // Catch: java.lang.Throwable -> L88 java.lang.Exception -> L8b
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L88 java.lang.Exception -> L8b
            r5 = 65536(0x10000, float:9.1835E-41)
            byte[] r7 = new byte[r5]     // Catch: java.lang.Throwable -> L83 java.lang.Exception -> L85
            r8 = 0
            r9 = 0
        L4d:
            int r10 = r2.length     // Catch: java.lang.Throwable -> L83 java.lang.Exception -> L85
            if (r9 >= r10) goto L7d
            java.io.FileInputStream r10 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L83 java.lang.Exception -> L85
            r11 = r2[r9]     // Catch: java.lang.Throwable -> L83 java.lang.Exception -> L85
            r10.<init>(r11)     // Catch: java.lang.Throwable -> L83 java.lang.Exception -> L85
            java.io.BufferedInputStream r11 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L83 java.lang.Exception -> L85
            r11.<init>(r10, r5)     // Catch: java.lang.Throwable -> L83 java.lang.Exception -> L85
            java.util.zip.ZipEntry r10 = new java.util.zip.ZipEntry     // Catch: java.lang.Exception -> L7b java.lang.Throwable -> La3
            r12 = r2[r9]     // Catch: java.lang.Exception -> L7b java.lang.Throwable -> La3
            java.lang.String r12 = r12.getName()     // Catch: java.lang.Exception -> L7b java.lang.Throwable -> La3
            r10.<init>(r12)     // Catch: java.lang.Exception -> L7b java.lang.Throwable -> La3
            r6.putNextEntry(r10)     // Catch: java.lang.Exception -> L7b java.lang.Throwable -> La3
        L6a:
            int r10 = r11.read(r7, r8, r5)     // Catch: java.lang.Exception -> L7b java.lang.Throwable -> La3
            r12 = -1
            if (r10 == r12) goto L75
            r6.write(r7, r8, r10)     // Catch: java.lang.Exception -> L7b java.lang.Throwable -> La3
            goto L6a
        L75:
            r11.close()     // Catch: java.lang.Exception -> L7b java.lang.Throwable -> La3
            int r9 = r9 + 1
            goto L4d
        L7b:
            r1 = move-exception
            goto L8f
        L7d:
            r4[r8] = r3     // Catch: java.lang.Throwable -> L83 java.lang.Exception -> L85
        L7f:
            r6.close()     // Catch: java.lang.Exception -> Lb0
            goto L9a
        L83:
            r14 = move-exception
            goto La5
        L85:
            r2 = move-exception
            r11 = r1
            goto L8e
        L88:
            r14 = move-exception
            r6 = r1
            goto La5
        L8b:
            r2 = move-exception
            r6 = r1
            r11 = r6
        L8e:
            r1 = r2
        L8f:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> La3
            if (r11 == 0) goto L97
            r11.close()     // Catch: java.lang.Exception -> Lb0
        L97:
            if (r6 == 0) goto L9a
            goto L7f
        L9a:
            org.rbmain.ui.ProfileActivity$$ExternalSyntheticLambda23 r1 = new org.rbmain.ui.ProfileActivity$$ExternalSyntheticLambda23     // Catch: java.lang.Exception -> Lb0
            r1.<init>()     // Catch: java.lang.Exception -> Lb0
            org.rbmain.messenger.AndroidUtilities.runOnUIThread(r1)     // Catch: java.lang.Exception -> Lb0
            goto Lb4
        La3:
            r14 = move-exception
            r1 = r11
        La5:
            if (r1 == 0) goto Laa
            r1.close()     // Catch: java.lang.Exception -> Lb0
        Laa:
            if (r6 == 0) goto Laf
            r6.close()     // Catch: java.lang.Exception -> Lb0
        Laf:
            throw r14     // Catch: java.lang.Exception -> Lb0
        Lb0:
            r14 = move-exception
            r14.printStackTrace()
        Lb4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.ProfileActivity.lambda$sendLogs$33(org.rbmain.ui.ActionBar.AlertDialog):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendLogs$32(AlertDialog alertDialog, boolean[] zArr, File file) {
        Uri uriFromFile;
        try {
            alertDialog.dismiss();
        } catch (Exception unused) {
        }
        if (zArr[0]) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 24) {
                uriFromFile = FileProvider.getUriForFile(getParentActivity(), "ir.medu.shad.provider", file);
            } else {
                uriFromFile = Uri.fromFile(file);
            }
            Intent intent = new Intent("android.intent.action.SEND");
            if (i >= 24) {
                intent.addFlags(1);
            }
            intent.setType("message/rfc822");
            intent.putExtra("android.intent.extra.EMAIL", BuildConfig.FLAVOR);
            intent.putExtra("android.intent.extra.SUBJECT", "Logs from " + LocaleController.getInstance().formatterStats.format(System.currentTimeMillis()));
            intent.putExtra("android.intent.extra.STREAM", uriFromFile);
            if (getParentActivity() != null) {
                try {
                    getParentActivity().startActivityForResult(Intent.createChooser(intent, "Select email application."), HttpStatus.HTTP_INTERNAL_SERVER_ERROR);
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

    private class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) throws PackageManager.NameNotFoundException {
            View headerCell = null;
            switch (i) {
                case 1:
                    headerCell = new HeaderCell(this.mContext, 23);
                    break;
                case 2:
                    TextDetailCell textDetailCell = new TextDetailCell(this.mContext);
                    textDetailCell.setContentDescriptionValueFirst(true);
                    headerCell = textDetailCell;
                    break;
                case 3:
                    headerCell = new AboutLinkCell(this.mContext, ProfileActivity.this) { // from class: org.rbmain.ui.ProfileActivity.ListAdapter.1
                        @Override // org.rbmain.ui.Cells.AboutLinkCell
                        protected void didPressUrl(String str) {
                            if (str.startsWith("@")) {
                                ProfileActivity.this.getMessagesController().openByUserName(str.substring(1), ProfileActivity.this, 0);
                                return;
                            }
                            if (!str.startsWith("#") && str.startsWith("/") && ((BaseFragment) ProfileActivity.this).parentLayout.fragmentsStack.size() > 1) {
                                BaseFragment baseFragment = ((BaseFragment) ProfileActivity.this).parentLayout.fragmentsStack.get(((BaseFragment) ProfileActivity.this).parentLayout.fragmentsStack.size() - 2);
                                if (baseFragment instanceof ChatActivity) {
                                    ProfileActivity.this.finishFragment();
                                    ((ChatActivity) baseFragment).chatActivityEnterView.setCommand(null, str, false, false);
                                }
                            }
                        }
                    };
                    break;
                case 4:
                    headerCell = new TextCell(this.mContext);
                    break;
                case 5:
                    DividerCell dividerCell = new DividerCell(this.mContext);
                    dividerCell.setPadding(AndroidUtilities.dp(20.0f), AndroidUtilities.dp(4.0f), 0, 0);
                    headerCell = dividerCell;
                    break;
                case 6:
                    headerCell = new NotificationsCheckCell(this.mContext, 23, 70, false);
                    break;
                case 7:
                    headerCell = new ShadowSectionCell(this.mContext);
                    break;
                case 8:
                    headerCell = new UserCell(this.mContext, ProfileActivity.this.addMemberRow == -1 ? 9 : 6, 0, true);
                    break;
                case 11:
                    headerCell = new View(this, this.mContext) { // from class: org.rbmain.ui.ProfileActivity.ListAdapter.2
                        @Override // android.view.View
                        protected void onMeasure(int i2, int i3) {
                            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(32.0f), 1073741824));
                        }
                    };
                    break;
                case 12:
                    View view = new View(this.mContext) { // from class: org.rbmain.ui.ProfileActivity.ListAdapter.3
                        private int lastPaddingHeight = 0;
                        private int lastListViewHeight = 0;

                        @Override // android.view.View
                        protected void onMeasure(int i2, int i3) {
                            if (this.lastListViewHeight != ProfileActivity.this.listView.getMeasuredHeight()) {
                                this.lastPaddingHeight = 0;
                            }
                            this.lastListViewHeight = ProfileActivity.this.listView.getMeasuredHeight();
                            int childCount = ProfileActivity.this.listView.getChildCount();
                            if (childCount != ProfileActivity.this.listAdapter.getItemCount()) {
                                setMeasuredDimension(ProfileActivity.this.listView.getMeasuredWidth(), this.lastPaddingHeight);
                                return;
                            }
                            int measuredHeight = 0;
                            for (int i4 = 0; i4 < childCount; i4++) {
                                int childAdapterPosition = ProfileActivity.this.listView.getChildAdapterPosition(ProfileActivity.this.listView.getChildAt(i4));
                                if (childAdapterPosition >= 0 && childAdapterPosition != ProfileActivity.this.bottomPaddingRow) {
                                    measuredHeight += ProfileActivity.this.listView.getChildAt(i4).getMeasuredHeight();
                                }
                            }
                            int measuredHeight2 = ((ProfileActivity.this.fragmentView.getMeasuredHeight() - ActionBar.getCurrentActionBarHeight()) - AndroidUtilities.statusBarHeight) - measuredHeight;
                            if (measuredHeight2 > AndroidUtilities.dp(88.0f)) {
                                measuredHeight2 = 0;
                            }
                            int i5 = measuredHeight2 > 0 ? measuredHeight2 : 0;
                            int measuredWidth = ProfileActivity.this.listView.getMeasuredWidth();
                            this.lastPaddingHeight = i5;
                            setMeasuredDimension(measuredWidth, i5);
                        }
                    };
                    view.setBackground(new ColorDrawable(0));
                    headerCell = view;
                    break;
                case 13:
                    if (ProfileActivity.this.sharedMediaLayout.getParent() != null) {
                        ((ViewGroup) ProfileActivity.this.sharedMediaLayout.getParent()).removeView(ProfileActivity.this.sharedMediaLayout);
                    }
                    headerCell = ProfileActivity.this.sharedMediaLayout;
                    break;
                case 14:
                    TextInfoPrivacyCell textInfoPrivacyCell = new TextInfoPrivacyCell(this.mContext, 10);
                    textInfoPrivacyCell.getTextView().setGravity(1);
                    textInfoPrivacyCell.getTextView().setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteGrayText3));
                    textInfoPrivacyCell.getTextView().setMovementMethod(null);
                    try {
                        PackageInfo packageInfo = ApplicationLoader.applicationContext.getPackageManager().getPackageInfo(ApplicationLoader.applicationContext.getPackageName(), 0);
                        int i2 = packageInfo.versionCode / 10;
                        textInfoPrivacyCell.setText(LocaleController.formatString("RubikaVersion", R.string.RubikaVersion, String.format(Locale.US, "v%s (%s)", packageInfo.versionName, "universal " + Build.CPU_ABI + " " + Build.CPU_ABI2)));
                    } catch (Exception e) {
                        FileLog.e(e);
                    }
                    textInfoPrivacyCell.getTextView().setPadding(0, AndroidUtilities.dp(14.0f), 0, AndroidUtilities.dp(14.0f));
                    textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, Theme.key_windowBackgroundGrayShadow));
                    headerCell = textInfoPrivacyCell;
                    break;
            }
            if (i != 13) {
                headerCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            }
            return new RecyclerListView.Holder(headerCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
            if (viewHolder.itemView == ProfileActivity.this.sharedMediaLayout) {
                ProfileActivity.this.sharedMediaLayoutAttached = true;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
            if (viewHolder.itemView == ProfileActivity.this.sharedMediaLayout) {
                ProfileActivity.this.sharedMediaLayoutAttached = false;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            String str;
            String string;
            String string2;
            String str2;
            String str3;
            String string3;
            SettingItem2 settingItem2;
            String str4;
            String tTLString;
            long j;
            String string4;
            TLRPC$ChatParticipant tLRPC$ChatParticipant;
            String string5;
            int itemViewType = viewHolder.getItemViewType();
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
                                if (i != ProfileActivity.this.debugHeaderRow) {
                                    if (i < ProfileActivity.this.otherPartsStartRow || i > ProfileActivity.this.otherPartsEndRow) {
                                        return;
                                    }
                                    SettingItem2 settingItem22 = (SettingItem2) ProfileActivity.this.settingsParts.get(i - ProfileActivity.this.otherPartsStartRow);
                                    if (settingItem22.type != SettingItem2.TypeEnum.Header || (str = settingItem22.title) == null) {
                                        return;
                                    }
                                    headerCell.setText(str);
                                    return;
                                }
                                headerCell.setText(LocaleController.getString("SettingsDebug", R.string.SettingsDebug));
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
            String str5 = BuildConfig.FLAVOR;
            if (itemViewType == 2) {
                TextDetailCell textDetailCell = (TextDetailCell) viewHolder.itemView;
                if (i == ProfileActivity.this.phoneRow) {
                    TLRPC$User user = ProfileActivity.this.getMessagesController().getUser(Integer.valueOf(ProfileActivity.this.user_id));
                    if (user != null && !TextUtils.isEmpty(user.phone)) {
                        string3 = PhoneFormat.getInstance().format("+" + user.phone);
                    } else {
                        string3 = LocaleController.getString("PhoneHidden", R.string.PhoneHidden);
                    }
                    textDetailCell.setTextAndValue(string3, LocaleController.getString("PhoneMobile", R.string.PhoneMobile), false);
                    return;
                }
                if (i == ProfileActivity.this.usernameRow) {
                    if (ProfileActivity.this.user_id != 0) {
                        TLRPC$User user2 = ProfileActivity.this.getMessagesController().getUser(Integer.valueOf(ProfileActivity.this.user_id));
                        if (user2 == null || TextUtils.isEmpty(user2.username)) {
                            str3 = "-";
                        } else {
                            str3 = "@" + user2.username;
                        }
                        textDetailCell.setTextAndValue(str3, LocaleController.getString("Username", R.string.Username), false);
                        return;
                    }
                    if (ProfileActivity.this.currentChat != null) {
                        TLRPC$Chat chat = ProfileActivity.this.getMessagesController().getChat(Integer.valueOf(ProfileActivity.this.chat_id));
                        if (chat != null && (str5 = chat.shareLink) == null) {
                            str5 = ProfileActivity.this.getMessagesController().linkPrefix + chat.username;
                        }
                        textDetailCell.setTextAndValue(str5, LocaleController.getString("InviteLink", R.string.InviteLink), false);
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
                    if (currentUser != null && (str2 = currentUser.phone) != null && str2.length() != 0) {
                        string2 = PhoneFormat.getInstance().format("+" + currentUser.phone);
                    } else {
                        string2 = LocaleController.getString("NumberUnknown", R.string.NumberUnknown);
                    }
                    textDetailCell.setTextAndValue(string2, LocaleController.getString("TapToChangePhone", R.string.TapToChangePhone), true);
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
            if (itemViewType != 4) {
                if (itemViewType != 6) {
                    if (itemViewType == 7) {
                        View view = viewHolder.itemView;
                        view.setTag(Integer.valueOf(i));
                        if ((i == ProfileActivity.this.infoSectionRow && ProfileActivity.this.lastSectionRow == -1 && ProfileActivity.this.secretSettingsSectionRow == -1 && ProfileActivity.this.sharedMediaRow == -1 && ProfileActivity.this.membersSectionRow == -1) || i == ProfileActivity.this.secretSettingsSectionRow || i == ProfileActivity.this.lastSectionRow || (i == ProfileActivity.this.membersSectionRow && ProfileActivity.this.lastSectionRow == -1 && ProfileActivity.this.sharedMediaRow == -1)) {
                            view.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, Theme.key_windowBackgroundGrayShadow));
                            return;
                        } else {
                            view.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, Theme.key_windowBackgroundGrayShadow));
                            return;
                        }
                    }
                    if (itemViewType != 8) {
                        if (itemViewType != 12) {
                            return;
                        }
                        viewHolder.itemView.requestLayout();
                        return;
                    }
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
                        userCell.setData(ProfileActivity.this.getMessagesController().getUser(Integer.valueOf(tLRPC$ChatParticipant.user_id)), null, null, 0, i != ProfileActivity.this.membersEndRow - 1);
                        return;
                    }
                    return;
                }
                NotificationsCheckCell notificationsCheckCell = (NotificationsCheckCell) viewHolder.itemView;
                if (i == ProfileActivity.this.notificationsRow) {
                    SharedPreferences notificationsSettings = MessagesController.getNotificationsSettings(((BaseFragment) ProfileActivity.this).currentAccount);
                    if (ProfileActivity.this.dialog_id != 0) {
                        j = ProfileActivity.this.dialog_id;
                    } else {
                        j = ProfileActivity.this.user_id != 0 ? ProfileActivity.this.user_id : -ProfileActivity.this.chat_id;
                    }
                    IdStorage.getInstance().getDialogId(j);
                    boolean z = notificationsSettings.getBoolean(NotificationsSettingsFacade.PROPERTY_CUSTOM + j, false);
                    boolean zContains = notificationsSettings.contains(NotificationsSettingsFacade.PROPERTY_NOTIFY + j);
                    int i2 = notificationsSettings.getInt(NotificationsSettingsFacade.PROPERTY_NOTIFY + j, 0);
                    int i3 = notificationsSettings.getInt(NotificationsSettingsFacade.PROPERTY_NOTIFY_UNTIL + j, 0);
                    if (i2 != 3 || i3 == Integer.MAX_VALUE) {
                        if (i2 == 0) {
                            if (!zContains) {
                                zIsGlobalNotificationsEnabled = ProfileActivity.this.getNotificationsController().isGlobalNotificationsEnabled(j);
                            }
                        } else if (i2 != 1) {
                            zIsGlobalNotificationsEnabled = false;
                        }
                        if (zIsGlobalNotificationsEnabled && z) {
                            string = LocaleController.getString("NotificationsCustom", R.string.NotificationsCustom);
                        } else {
                            string4 = zIsGlobalNotificationsEnabled ? LocaleController.getString("NotificationsOn", R.string.NotificationsOn) : LocaleController.getString("NotificationsOff", R.string.NotificationsOff);
                            string = string4;
                        }
                    } else {
                        int currentTime = i3 - ProfileActivity.this.getConnectionsManager().getCurrentTime();
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
            TextCell textCell = (TextCell) viewHolder.itemView;
            int i4 = Theme.key_windowBackgroundWhiteGrayIcon;
            int i5 = Theme.key_windowBackgroundWhiteBlackText;
            textCell.setColors(i4, i5);
            textCell.setTag(Integer.valueOf(i5));
            if (i == ProfileActivity.this.rubinoRow) {
                textCell.setTextAndValue(LocaleController.formatString(R.string.rubinoPage, LocaleController.getString(AppFavorUtils.rubinoNameId)).toString(), BuildConfig.FLAVOR, false);
                return;
            }
            ProfileActivity profileActivity2 = ProfileActivity.this;
            if (i < profileActivity2.itemLinksStartRow || i >= profileActivity2.itemLinksEndRow) {
                if (i != profileActivity2.settingsTimerRow) {
                    if (i != ProfileActivity.this.unblockRow) {
                        if (i != ProfileActivity.this.settingsKeyRow) {
                            if (i != ProfileActivity.this.joinRow) {
                                if (i == ProfileActivity.this.subscribersRow) {
                                    if (ProfileActivity.this.chatInfo != null) {
                                        if (!ChatObject.isChannel(ProfileActivity.this.currentChat) || ProfileActivity.this.currentChat.megagroup) {
                                            textCell.setTextAndValueAndIcon(LocaleController.getString("ChannelMembers", R.string.ChannelMembers), String.format("%d", Integer.valueOf(ProfileActivity.this.chatInfo.participants_count)), R.drawable.actions_viewmembers, i != ProfileActivity.this.membersSectionRow - 1);
                                            return;
                                        } else {
                                            textCell.setTextAndValueAndIcon(LocaleController.getString("ChannelSubscribers", R.string.ChannelSubscribers), String.format("%d", Integer.valueOf(ProfileActivity.this.chatInfo.participants_count)), R.drawable.actions_viewmembers, i != ProfileActivity.this.membersSectionRow - 1);
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
                                        textCell.setTextAndIcon(LocaleController.getString("ChannelAdministrators", R.string.ChannelAdministrators), R.drawable.actions_addadmin, i != ProfileActivity.this.membersSectionRow - 1);
                                        return;
                                    } else {
                                        textCell.setTextAndIcon(LocaleController.getString("ChannelAdministrators", R.string.ChannelAdministrators), R.drawable.actions_addadmin, i != ProfileActivity.this.membersSectionRow - 1);
                                        return;
                                    }
                                }
                                if (i == ProfileActivity.this.blockedUsersRow) {
                                    if (ProfileActivity.this.chatInfo != null) {
                                        textCell.setTextAndIcon(LocaleController.getString("ChannelBlacklist", R.string.ChannelBlacklist), R.drawable.actions_removed, i != ProfileActivity.this.membersSectionRow - 1);
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
                                                                                    if (i == ProfileActivity.this.clearLogsRow) {
                                                                                        textCell.setText(LocaleController.getString("DebugClearLogs", R.string.DebugClearLogs), ProfileActivity.this.switchBackendRow != -1);
                                                                                        return;
                                                                                    }
                                                                                    if (i != ProfileActivity.this.switchBackendRow) {
                                                                                        if (i != ProfileActivity.this.devicesRow) {
                                                                                            if (i != ProfileActivity.this.setAvatarRow) {
                                                                                                if (i < ProfileActivity.this.otherPartsStartRow || i > ProfileActivity.this.otherPartsEndRow || (settingItem2 = (SettingItem2) ProfileActivity.this.settingsParts.get(i - ProfileActivity.this.otherPartsStartRow)) == null || settingItem2.type != SettingItem2.TypeEnum.Simple || (str4 = settingItem2.title) == null) {
                                                                                                    return;
                                                                                                }
                                                                                                textCell.setText(str4, true);
                                                                                                return;
                                                                                            }
                                                                                            textCell.setColors(Theme.key_windowBackgroundWhiteBlueIcon, Theme.key_windowBackgroundWhiteBlueButton);
                                                                                            textCell.setTextAndIcon(LocaleController.getString("SetProfilePhoto", R.string.SetProfilePhoto), R.drawable.msg_addphoto, false);
                                                                                            return;
                                                                                        }
                                                                                        textCell.setTextAndIcon(LocaleController.getString("Devices", R.string.Devices), R.drawable.menu_devices, true);
                                                                                        return;
                                                                                    }
                                                                                    textCell.setText("Switch Backend", false);
                                                                                    return;
                                                                                }
                                                                                textCell.setText(LocaleController.getString("DebugSendLogs", R.string.DebugSendLogs), true);
                                                                                return;
                                                                            }
                                                                            textCell.setTextAndIcon(LocaleController.getString("PrivacyPolicy", R.string.PrivacyPolicy), R.drawable.menu_policy, false);
                                                                            return;
                                                                        }
                                                                        textCell.setTextAndIcon(LocaleController.getString("RubikaFAQ", R.string.RubikaFAQ), R.drawable.menu_help, true);
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
                                        textCell.setColors(-1, Theme.key_text_RedRegular);
                                        return;
                                    }
                                    textCell.setText(LocaleController.getString("SendMessageLocation", R.string.SendMessageLocation), true);
                                    return;
                                }
                                textCell.setColors(Theme.key_windowBackgroundWhiteBlueIcon, Theme.key_windowBackgroundWhiteBlueButton);
                                textCell.setTextAndIcon(LocaleController.getString("AddMember", R.string.AddMember), R.drawable.actions_addmember2, ProfileActivity.this.membersSectionRow == -1);
                                return;
                            }
                            textCell.setColors(-1, Theme.key_windowBackgroundWhiteBlueText2);
                            if (ProfileActivity.this.currentChat.megagroup) {
                                textCell.setText(LocaleController.getString("ProfileJoinGroup", R.string.ProfileJoinGroup), false);
                                return;
                            } else {
                                textCell.setText(LocaleController.getString("ProfileJoinChannel", R.string.ProfileJoinChannel), false);
                                return;
                            }
                        }
                        IdenticonDrawable identiconDrawable = new IdenticonDrawable();
                        identiconDrawable.setEncryptedChat(ProfileActivity.this.getMessagesController().getEncryptedChat(Integer.valueOf((int) (ProfileActivity.this.dialog_id >> 32))));
                        textCell.setTextAndValueDrawable(LocaleController.getString("EncryptionKey", R.string.EncryptionKey), identiconDrawable, false);
                        return;
                    }
                    textCell.setText(LocaleController.getString("Unblock", R.string.Unblock), false);
                    textCell.setColors(-1, Theme.key_text_RedRegular);
                    return;
                }
                int i6 = ProfileActivity.this.getMessagesController().getEncryptedChat(Integer.valueOf((int) (ProfileActivity.this.dialog_id >> 32))).ttl;
                if (i6 == 0) {
                    tTLString = LocaleController.getString("ShortMessageLifetimeForever", R.string.ShortMessageLifetimeForever);
                } else {
                    tTLString = LocaleController.formatTTLString(i6);
                }
                textCell.setTextAndValue(LocaleController.getString("MessageLifetime", R.string.MessageLifetime), tTLString, false);
                return;
            }
            textCell.setTextAndValue(((ProfileLinkItemObject) profileActivity2.profileItems.get(i - ProfileActivity.this.itemLinksStartRow)).title, BuildConfig.FLAVOR, false);
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            if (ProfileActivity.this.notificationRow != -1) {
                int adapterPosition = viewHolder.getAdapterPosition();
                if (adapterPosition < ProfileActivity.this.otherPartsStartRow || adapterPosition > ProfileActivity.this.otherPartsEndRow) {
                    return adapterPosition == ProfileActivity.this.notificationRow || adapterPosition == ProfileActivity.this.numberRow || adapterPosition == ProfileActivity.this.privacyRow || adapterPosition == ProfileActivity.this.languageRow || adapterPosition == ProfileActivity.this.setUsernameRow || adapterPosition == ProfileActivity.this.bioRow || adapterPosition == ProfileActivity.this.versionRow || adapterPosition == ProfileActivity.this.dataRow || adapterPosition == ProfileActivity.this.chatRow || adapterPosition == ProfileActivity.this.questionRow || adapterPosition == ProfileActivity.this.devicesRow || adapterPosition == ProfileActivity.this.filtersRow || adapterPosition == ProfileActivity.this.faqRow || adapterPosition == ProfileActivity.this.policyRow || adapterPosition == ProfileActivity.this.sendLogsRow || adapterPosition == ProfileActivity.this.clearLogsRow || adapterPosition == ProfileActivity.this.switchBackendRow || adapterPosition == ProfileActivity.this.setAvatarRow;
                }
                try {
                    SettingItem2 settingItem2 = (SettingItem2) ProfileActivity.this.settingsParts.get(adapterPosition - ProfileActivity.this.otherPartsStartRow);
                    if (settingItem2 != null && settingItem2.type == SettingItem2.TypeEnum.Simple) {
                        return settingItem2.link != null;
                    }
                } catch (Exception unused) {
                }
                return false;
            }
            View view = viewHolder.itemView;
            if (view instanceof UserCell) {
                Object currentObject = ((UserCell) view).getCurrentObject();
                if ((currentObject instanceof TLRPC$User) && UserObject.isUserSelf((TLRPC$User) currentObject)) {
                    return false;
                }
            }
            int itemViewType = viewHolder.getItemViewType();
            return (itemViewType == 1 || itemViewType == 5 || itemViewType == 7 || itemViewType == 9 || itemViewType == 10 || itemViewType == 11 || itemViewType == 12 || itemViewType == 13) ? false : true;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return ProfileActivity.this.rowCount;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i == ProfileActivity.this.infoHeaderRow || i == ProfileActivity.this.membersHeaderRow || i == ProfileActivity.this.settingsSectionRow2 || i == ProfileActivity.this.numberSectionRow || i == ProfileActivity.this.helpHeaderRow || i == ProfileActivity.this.debugHeaderRow) {
                return 1;
            }
            if (i == ProfileActivity.this.phoneRow || i == ProfileActivity.this.usernameRow || i == ProfileActivity.this.locationRow || i == ProfileActivity.this.numberRow || i == ProfileActivity.this.setUsernameRow || i == ProfileActivity.this.bioRow) {
                return 2;
            }
            if (i == ProfileActivity.this.userInfoRow || i == ProfileActivity.this.channelInfoRow) {
                return 3;
            }
            if (i != ProfileActivity.this.settingsTimerRow && i != ProfileActivity.this.settingsKeyRow && i != ProfileActivity.this.reportRow && i != ProfileActivity.this.subscribersRow && i != ProfileActivity.this.administratorsRow && i != ProfileActivity.this.blockedUsersRow && i != ProfileActivity.this.addMemberRow && i != ProfileActivity.this.joinRow && i != ProfileActivity.this.unblockRow && i != ProfileActivity.this.sendMessageRow && i != ProfileActivity.this.notificationRow && i != ProfileActivity.this.privacyRow && i != ProfileActivity.this.languageRow && i != ProfileActivity.this.dataRow && i != ProfileActivity.this.chatRow && i != ProfileActivity.this.questionRow && i != ProfileActivity.this.devicesRow && i != ProfileActivity.this.filtersRow && i != ProfileActivity.this.faqRow && i != ProfileActivity.this.policyRow && i != ProfileActivity.this.sendLogsRow && i != ProfileActivity.this.clearLogsRow && i != ProfileActivity.this.switchBackendRow && i != ProfileActivity.this.setAvatarRow) {
                ProfileActivity profileActivity = ProfileActivity.this;
                if ((i < profileActivity.itemLinksStartRow || i >= profileActivity.itemLinksEndRow) && i != profileActivity.rubinoRow) {
                    if (i == ProfileActivity.this.notificationsDividerRow) {
                        return 5;
                    }
                    if (i == ProfileActivity.this.notificationsRow) {
                        return 6;
                    }
                    if (i == ProfileActivity.this.infoSectionRow || i == ProfileActivity.this.lastSectionRow || i == ProfileActivity.this.membersSectionRow || i == ProfileActivity.this.secretSettingsSectionRow || i == ProfileActivity.this.settingsSectionRow || i == ProfileActivity.this.devicesSectionRow || i == ProfileActivity.this.helpSectionCell || i == ProfileActivity.this.setAvatarSectionRow || i == ProfileActivity.this.emptyRow2) {
                        return 7;
                    }
                    if (i >= ProfileActivity.this.membersStartRow && i < ProfileActivity.this.membersEndRow) {
                        return 8;
                    }
                    if (i == ProfileActivity.this.emptyRow) {
                        return 11;
                    }
                    if (i == ProfileActivity.this.bottomPaddingRow) {
                        return 12;
                    }
                    if (i == ProfileActivity.this.sharedMediaRow) {
                        return 13;
                    }
                    if (i == ProfileActivity.this.versionRow) {
                        return 14;
                    }
                    if (i < ProfileActivity.this.otherPartsStartRow || i > ProfileActivity.this.otherPartsEndRow) {
                        return 0;
                    }
                    if (((SettingItem2) ProfileActivity.this.settingsParts.get(i - ProfileActivity.this.otherPartsStartRow)).type == SettingItem2.TypeEnum.Header) {
                        return 1;
                    }
                    return ((SettingItem2) ProfileActivity.this.settingsParts.get(i - ProfileActivity.this.otherPartsStartRow)).type == SettingItem2.TypeEnum.Empty ? 7 : 4;
                }
            }
            return 4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class SearchAdapter extends RecyclerListView.SelectionAdapter {
        private ArrayList<MessagesController.FaqSearchResult> faqSearchArray;
        private ArrayList<MessagesController.FaqSearchResult> faqSearchResults;
        private TLRPC$WebPage faqWebPage;
        private boolean loadingFaqPage;
        private Context mContext;
        private ArrayList<Object> recentSearches;
        private ArrayList<CharSequence> resultNames;
        private SearchResult[] searchArray;
        private ArrayList<SearchResult> searchResults;
        private boolean searchWas;

        private class SearchResult {
            private int guid;
            private int iconResId;
            private int num;
            private Runnable openRunnable;
            private String[] path;
            private String rowName;
            private String searchTitle;

            public SearchResult(SearchAdapter searchAdapter, int i, String str, int i2, Runnable runnable) {
                this(i, str, null, null, null, i2, runnable);
            }

            public SearchResult(SearchAdapter searchAdapter, int i, String str, String str2, int i2, Runnable runnable) {
                this(i, str, null, str2, null, i2, runnable);
            }

            public SearchResult(SearchAdapter searchAdapter, int i, String str, String str2, String str3, int i2, Runnable runnable) {
                this(i, str, str2, str3, null, i2, runnable);
            }

            public SearchResult(int i, String str, String str2, String str3, String str4, int i2, Runnable runnable) {
                this.guid = i;
                this.searchTitle = str;
                this.rowName = str2;
                this.openRunnable = runnable;
                this.iconResId = i2;
                if (str3 != null && str4 != null) {
                    this.path = new String[]{str3, str4};
                } else if (str3 != null) {
                    this.path = new String[]{str3};
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
        public /* synthetic */ void lambda$new$0() {
            ProfileActivity.this.presentFragment(new ChangeNameActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$1() {
            ProfileActivity.this.presentFragment(new ActionIntroActivity(3));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$2() {
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
                ProfileActivity.this.presentFragment(new LoginActivityAppp(i));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$3() {
            if (ProfileActivity.this.userInfo != null) {
                ProfileActivity.this.presentFragment(new ChangeBioActivity());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$4() {
            ProfileActivity.this.presentFragment(new NotificationsSettingsActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$5() {
            ProfileActivity.this.presentFragment(new NotificationsCustomSettingsActivity(1, new ArrayList(), true));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$6() {
            ProfileActivity.this.presentFragment(new NotificationsCustomSettingsActivity(0, new ArrayList(), true));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$7() {
            ProfileActivity.this.presentFragment(new NotificationsCustomSettingsActivity(2, new ArrayList(), true));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$8() {
            ProfileActivity.this.presentFragment(new NotificationsSettingsActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$9() {
            ProfileActivity.this.presentFragment(new NotificationsSettingsActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$10() {
            ProfileActivity.this.presentFragment(new NotificationsSettingsActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$11() {
            ProfileActivity.this.presentFragment(new NotificationsSettingsActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$12() {
            ProfileActivity.this.presentFragment(new NotificationsSettingsActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$13() {
            ProfileActivity.this.presentFragment(new NotificationsSettingsActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$14() {
            ProfileActivity.this.presentFragment(new PrivacySettingsActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$15() {
            ProfileActivity.this.presentFragment(new PrivacyUsersActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$16() {
            ProfileActivity.this.presentFragment(new PrivacyControlActivity(6, true));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$17() {
            ProfileActivity.this.presentFragment(new PrivacyControlActivity(0, true));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$18() {
            ProfileActivity.this.presentFragment(new PrivacyControlActivity(4, true));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$19() {
            ProfileActivity.this.presentFragment(new PrivacyControlActivity(5, true));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$20() {
            ProfileActivity.this.presentFragment(new PrivacyControlActivity(3, true));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$21() {
            ProfileActivity.this.presentFragment(new PrivacyControlActivity(2, true));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$22() {
            ProfileActivity.this.presentFragment(new PrivacyControlActivity(1, true));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$23() {
            ProfileActivity.this.presentFragment(new PasscodeActivity(SharedConfig.passcodeHash.length() > 0 ? 2 : 0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$24() {
            ProfileActivity.this.presentFragment(new TwoStepVerificationActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$25() {
            ProfileActivity.this.presentFragment(new SessionsActivity(0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$26() {
            ProfileActivity.this.presentFragment(new PrivacySettingsActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$27() {
            ProfileActivity.this.presentFragment(new PrivacySettingsActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$28() {
            ProfileActivity.this.presentFragment(new PrivacySettingsActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$29() {
            ProfileActivity.this.presentFragment(new SessionsActivity(1));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$30() {
            ProfileActivity.this.presentFragment(new PrivacySettingsActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$31() {
            ProfileActivity.this.presentFragment(new PrivacySettingsActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$32() {
            ProfileActivity.this.presentFragment(new PrivacySettingsActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$33() {
            ProfileActivity.this.presentFragment(new PrivacySettingsActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$34() {
            ProfileActivity.this.presentFragment(new PrivacySettingsActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$35() {
            ProfileActivity.this.presentFragment(new SessionsActivity(0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$36() {
            ProfileActivity.this.presentFragment(new DataSettingsActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$37() {
            ProfileActivity.this.presentFragment(new DataSettingsActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$38() {
            ProfileActivity.this.presentFragment(new CacheControlActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$39() {
            ProfileActivity.this.presentFragment(new CacheControlActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$40() {
            ProfileActivity.this.presentFragment(new CacheControlActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$41() {
            ProfileActivity.this.presentFragment(new CacheControlActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$42() {
            ProfileActivity.this.presentFragment(new DataUsageActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$43() {
            ProfileActivity.this.presentFragment(new DataSettingsActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$44() {
            ProfileActivity.this.presentFragment(new DataAutoDownloadActivity(0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$45() {
            ProfileActivity.this.presentFragment(new DataAutoDownloadActivity(1));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$46() {
            ProfileActivity.this.presentFragment(new DataAutoDownloadActivity(2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$47() {
            ProfileActivity.this.presentFragment(new DataSettingsActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$48() {
            ProfileActivity.this.presentFragment(new DataSettingsActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$49() {
            ProfileActivity.this.presentFragment(new DataSettingsActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$50() {
            ProfileActivity.this.presentFragment(new DataSettingsActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$51() {
            ProfileActivity.this.presentFragment(new DataSettingsActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$52() {
            ProfileActivity.this.presentFragment(new DataSettingsActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$53() {
            ProfileActivity.this.presentFragment(new DataSettingsActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$54() {
            ProfileActivity.this.presentFragment(new DataSettingsActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$55() {
            ProfileActivity.this.presentFragment(new DataSettingsActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$56() {
            ProfileActivity.this.presentFragment(new ProxyListActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$57() {
            ProfileActivity.this.presentFragment(new ProxyListActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$58() {
            ProfileActivity.this.presentFragment(new DataSettingsActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$59() {
            ProfileActivity.this.presentFragment(new ThemeActivity(0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$60() {
            ProfileActivity.this.presentFragment(new ThemeActivity(0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$61() {
            ProfileActivity.this.presentFragment(new WallpapersListActivity(0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$62() {
            ProfileActivity.this.presentFragment(new WallpapersListActivity(1));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$63() {
            ProfileActivity.this.presentFragment(new WallpapersListActivity(0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$64() {
            ProfileActivity.this.presentFragment(new ThemeActivity(1));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$65() {
            ProfileActivity.this.presentFragment(new ThemeActivity(0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$66() {
            ProfileActivity.this.presentFragment(new ThemeActivity(0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$67() {
            ProfileActivity.this.presentFragment(new ThemeActivity(0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$68() {
            ProfileActivity.this.presentFragment(new ThemeActivity(0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$69() {
            ProfileActivity.this.presentFragment(new ThemeActivity(0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$70() {
            ProfileActivity.this.presentFragment(new ThemeActivity(0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$71() {
            ProfileActivity.this.presentFragment(new ThemeActivity(0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$72() {
            ProfileActivity.this.presentFragment(new ThemeActivity(0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$73() {
            ProfileActivity.this.presentFragment(new StickersActivity(0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$74() {
            ProfileActivity.this.presentFragment(new StickersActivity(0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$75() {
            ProfileActivity.this.presentFragment(new FeaturedStickersActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$76() {
            ProfileActivity.this.presentFragment(new StickersActivity(1));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$77() {
            ProfileActivity.this.presentFragment(new ArchivedStickersActivity(0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$78() {
            ProfileActivity.this.presentFragment(new ArchivedStickersActivity(1));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$79() {
            ProfileActivity.this.presentFragment(new LanguageSelectActivity());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$80() {
            Browser.openUrl(ProfileActivity.this.getParentActivity(), LocaleController.getString("RubikaFaqUrl", R.string.RubikaFaqUrl));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$81() {
            Browser.openUrl(ProfileActivity.this.getParentActivity(), LocaleController.getString("PrivacyPolicyUrl", R.string.PrivacyPolicyUrl));
        }

        public SearchAdapter(Context context) {
            SerializedData serializedData;
            boolean z;
            int int32;
            int int322;
            String[] strArr;
            SearchResult[] searchResultArr = new SearchResult[82];
            searchResultArr[0] = new SearchResult(this, HttpStatus.HTTP_INTERNAL_SERVER_ERROR, LocaleController.getString("EditName", R.string.EditName), 0, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda11
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$0();
                }
            });
            searchResultArr[1] = new SearchResult(this, HttpStatus.HTTP_NOT_IMPLEMENTED, LocaleController.getString("ChangePhoneNumber", R.string.ChangePhoneNumber), 0, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$1();
                }
            });
            searchResultArr[2] = new SearchResult(this, 502, LocaleController.getString("AddAnotherAccount", R.string.AddAnotherAccount), 0, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda30
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$2();
                }
            });
            searchResultArr[3] = new SearchResult(this, 503, LocaleController.getString("UserBio", R.string.UserBio), 0, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda12
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$3();
                }
            });
            searchResultArr[4] = new SearchResult(this, 1, LocaleController.getString("NotificationsAndSounds", R.string.NotificationsAndSounds), R.drawable.menu_notifications, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda63
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$4();
                }
            });
            searchResultArr[5] = new SearchResult(this, 2, LocaleController.getString("NotificationsPrivateChats", R.string.NotificationsPrivateChats), LocaleController.getString("NotificationsAndSounds", R.string.NotificationsAndSounds), R.drawable.menu_notifications, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda67
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$5();
                }
            });
            searchResultArr[6] = new SearchResult(this, 3, LocaleController.getString("NotificationsGroups", R.string.NotificationsGroups), LocaleController.getString("NotificationsAndSounds", R.string.NotificationsAndSounds), R.drawable.menu_notifications, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda43
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$6();
                }
            });
            searchResultArr[7] = new SearchResult(this, 4, LocaleController.getString("NotificationsChannels", R.string.NotificationsChannels), LocaleController.getString("NotificationsAndSounds", R.string.NotificationsAndSounds), R.drawable.menu_notifications, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda81
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$7();
                }
            });
            searchResultArr[8] = new SearchResult(this, 5, LocaleController.getString("VoipNotificationSettings", R.string.VoipNotificationSettings), "callsSectionRow", LocaleController.getString("NotificationsAndSounds", R.string.NotificationsAndSounds), R.drawable.menu_notifications, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$8();
                }
            });
            searchResultArr[9] = new SearchResult(this, 6, LocaleController.getString("BadgeNumber", R.string.BadgeNumber), "badgeNumberSection", LocaleController.getString("NotificationsAndSounds", R.string.NotificationsAndSounds), R.drawable.menu_notifications, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda38
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$9();
                }
            });
            searchResultArr[10] = new SearchResult(this, 7, LocaleController.getString("InAppNotifications", R.string.InAppNotifications), "inappSectionRow", LocaleController.getString("NotificationsAndSounds", R.string.NotificationsAndSounds), R.drawable.menu_notifications, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda52
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$10();
                }
            });
            searchResultArr[11] = new SearchResult(this, 8, LocaleController.getString("ContactJoined", R.string.ContactJoined), "contactJoinedRow", LocaleController.getString("NotificationsAndSounds", R.string.NotificationsAndSounds), R.drawable.menu_notifications, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda80
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$11();
                }
            });
            searchResultArr[12] = new SearchResult(this, 9, LocaleController.getString("PinnedMessages", R.string.PinnedMessages), "pinnedMessageRow", LocaleController.getString("NotificationsAndSounds", R.string.NotificationsAndSounds), R.drawable.menu_notifications, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda45
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$12();
                }
            });
            searchResultArr[13] = new SearchResult(this, 10, LocaleController.getString("ResetAllNotifications", R.string.ResetAllNotifications), "resetNotificationsRow", LocaleController.getString("NotificationsAndSounds", R.string.NotificationsAndSounds), R.drawable.menu_notifications, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda50
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$13();
                }
            });
            searchResultArr[14] = new SearchResult(this, 100, LocaleController.getString("PrivacySettings", R.string.PrivacySettings), R.drawable.menu_secret, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda56
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$14();
                }
            });
            searchResultArr[15] = new SearchResult(this, 101, LocaleController.getString("BlockedUsers", R.string.BlockedUsers), LocaleController.getString("PrivacySettings", R.string.PrivacySettings), R.drawable.menu_secret, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda28
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$15();
                }
            });
            searchResultArr[16] = new SearchResult(this, 105, LocaleController.getString("PrivacyPhone", R.string.PrivacyPhone), LocaleController.getString("PrivacySettings", R.string.PrivacySettings), R.drawable.menu_secret, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda23
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$16();
                }
            });
            searchResultArr[17] = new SearchResult(this, 102, LocaleController.getString("PrivacyLastSeen", R.string.PrivacyLastSeen), LocaleController.getString("PrivacySettings", R.string.PrivacySettings), R.drawable.menu_secret, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda66
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$17();
                }
            });
            searchResultArr[18] = new SearchResult(this, 103, LocaleController.getString("PrivacyProfilePhoto", R.string.PrivacyProfilePhoto), LocaleController.getString("PrivacySettings", R.string.PrivacySettings), R.drawable.menu_secret, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda17
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$18();
                }
            });
            searchResultArr[19] = new SearchResult(this, 104, LocaleController.getString("PrivacyForwards", R.string.PrivacyForwards), LocaleController.getString("PrivacySettings", R.string.PrivacySettings), R.drawable.menu_secret, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda39
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$19();
                }
            });
            searchResultArr[20] = new SearchResult(this, 105, LocaleController.getString("PrivacyP2P", R.string.PrivacyP2P), LocaleController.getString("PrivacySettings", R.string.PrivacySettings), R.drawable.menu_secret, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda79
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$20();
                }
            });
            searchResultArr[21] = new SearchResult(this, 106, LocaleController.getString("Calls", R.string.Calls), LocaleController.getString("PrivacySettings", R.string.PrivacySettings), R.drawable.menu_secret, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda78
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$21();
                }
            });
            searchResultArr[22] = new SearchResult(this, 107, LocaleController.getString("GroupsAndChannels", R.string.GroupsAndChannels), LocaleController.getString("PrivacySettings", R.string.PrivacySettings), R.drawable.menu_secret, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda25
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$22();
                }
            });
            searchResultArr[23] = new SearchResult(this, 108, LocaleController.getString("Passcode", R.string.Passcode), LocaleController.getString("PrivacySettings", R.string.PrivacySettings), R.drawable.menu_secret, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda41
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$23();
                }
            });
            searchResultArr[24] = new SearchResult(this, 109, LocaleController.getString("TwoStepVerification", R.string.TwoStepVerification), LocaleController.getString("PrivacySettings", R.string.PrivacySettings), R.drawable.menu_secret, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda73
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$24();
                }
            });
            searchResultArr[25] = new SearchResult(this, 110, LocaleController.getString("SessionsTitle", R.string.SessionsTitle), R.drawable.menu_secret, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda44
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$25();
                }
            });
            searchResultArr[26] = ProfileActivity.this.getMessagesController().autoarchiveAvailable ? new SearchResult(this, 121, LocaleController.getString("ArchiveAndMute", R.string.ArchiveAndMute), "newChatsRow", LocaleController.getString("PrivacySettings", R.string.PrivacySettings), R.drawable.menu_secret, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$26();
                }
            }) : null;
            searchResultArr[27] = new SearchResult(this, 112, LocaleController.getString("DeleteAccountIfAwayFor2", R.string.DeleteAccountIfAwayFor2), "deleteAccountRow", LocaleController.getString("PrivacySettings", R.string.PrivacySettings), R.drawable.menu_secret, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda15
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$27();
                }
            });
            searchResultArr[28] = new SearchResult(this, 113, LocaleController.getString("PrivacyPaymentsClear", R.string.PrivacyPaymentsClear), "paymentsClearRow", LocaleController.getString("PrivacySettings", R.string.PrivacySettings), R.drawable.menu_secret, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda53
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$28();
                }
            });
            searchResultArr[29] = new SearchResult(this, 114, LocaleController.getString("WebSessionsTitle", R.string.WebSessionsTitle), LocaleController.getString("PrivacySettings", R.string.PrivacySettings), R.drawable.menu_secret, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda57
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$29();
                }
            });
            searchResultArr[30] = new SearchResult(this, 115, LocaleController.getString("SyncContactsDelete", R.string.SyncContactsDelete), "contactsDeleteRow", LocaleController.getString("PrivacySettings", R.string.PrivacySettings), R.drawable.menu_secret, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda76
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$30();
                }
            });
            searchResultArr[31] = new SearchResult(this, 116, LocaleController.getString("SyncContacts", R.string.SyncContacts), "contactsSyncRow", LocaleController.getString("PrivacySettings", R.string.PrivacySettings), R.drawable.menu_secret, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda31
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$31();
                }
            });
            searchResultArr[32] = new SearchResult(this, 117, LocaleController.getString("SuggestContacts", R.string.SuggestContacts), "contactsSuggestRow", LocaleController.getString("PrivacySettings", R.string.PrivacySettings), R.drawable.menu_secret, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda13
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$32();
                }
            });
            searchResultArr[33] = new SearchResult(this, 118, LocaleController.getString("MapPreviewProvider", R.string.MapPreviewProvider), "secretMapRow", LocaleController.getString("PrivacySettings", R.string.PrivacySettings), R.drawable.menu_secret, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda36
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$33();
                }
            });
            searchResultArr[34] = new SearchResult(this, 119, LocaleController.getString("SecretWebPage", R.string.SecretWebPage), "secretWebpageRow", LocaleController.getString("PrivacySettings", R.string.PrivacySettings), R.drawable.menu_secret, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda34
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$34();
                }
            });
            searchResultArr[35] = new SearchResult(this, 120, LocaleController.getString("Devices", R.string.Devices), R.drawable.menu_secret, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda33
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$35();
                }
            });
            searchResultArr[36] = new SearchResult(this, 200, LocaleController.getString("DataSettings", R.string.DataSettings), R.drawable.menu_data, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda22
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$36();
                }
            });
            searchResultArr[37] = new SearchResult(this, 201, LocaleController.getString("DataUsage", R.string.DataUsage), "usageSectionRow", LocaleController.getString("DataSettings", R.string.DataSettings), R.drawable.menu_data, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda64
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$37();
                }
            });
            searchResultArr[38] = new SearchResult(this, 202, LocaleController.getString("StorageUsage", R.string.StorageUsage), LocaleController.getString("DataSettings", R.string.DataSettings), R.drawable.menu_data, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda77
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$38();
                }
            });
            searchResultArr[39] = new SearchResult(203, LocaleController.getString("KeepMedia", R.string.KeepMedia), "keepMediaRow", LocaleController.getString("DataSettings", R.string.DataSettings), LocaleController.getString("StorageUsage", R.string.StorageUsage), R.drawable.menu_data, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda19
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$39();
                }
            });
            searchResultArr[40] = new SearchResult(204, LocaleController.getString("ClearMediaCache", R.string.ClearMediaCache), "cacheRow", LocaleController.getString("DataSettings", R.string.DataSettings), LocaleController.getString("StorageUsage", R.string.StorageUsage), R.drawable.menu_data, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda18
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$40();
                }
            });
            searchResultArr[41] = new SearchResult(205, LocaleController.getString("LocalDatabase", R.string.LocalDatabase), "databaseRow", LocaleController.getString("DataSettings", R.string.DataSettings), LocaleController.getString("StorageUsage", R.string.StorageUsage), R.drawable.menu_data, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$41();
                }
            });
            searchResultArr[42] = new SearchResult(this, 206, LocaleController.getString("NetworkUsage", R.string.NetworkUsage), LocaleController.getString("DataSettings", R.string.DataSettings), R.drawable.menu_data, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda21
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$42();
                }
            });
            searchResultArr[43] = new SearchResult(this, 207, LocaleController.getString("AutomaticMediaDownload", R.string.AutomaticMediaDownload), "mediaDownloadSectionRow", LocaleController.getString("DataSettings", R.string.DataSettings), R.drawable.menu_data, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda16
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$43();
                }
            });
            searchResultArr[44] = new SearchResult(this, 208, LocaleController.getString("WhenUsingMobileData", R.string.WhenUsingMobileData), LocaleController.getString("DataSettings", R.string.DataSettings), R.drawable.menu_data, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda14
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$44();
                }
            });
            searchResultArr[45] = new SearchResult(this, 209, LocaleController.getString("WhenConnectedOnWiFi", R.string.WhenConnectedOnWiFi), LocaleController.getString("DataSettings", R.string.DataSettings), R.drawable.menu_data, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$45();
                }
            });
            searchResultArr[46] = new SearchResult(this, 210, LocaleController.getString("WhenRoaming", R.string.WhenRoaming), LocaleController.getString("DataSettings", R.string.DataSettings), R.drawable.menu_data, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$46();
                }
            });
            searchResultArr[47] = new SearchResult(this, 211, LocaleController.getString("ResetAutomaticMediaDownload", R.string.ResetAutomaticMediaDownload), "resetDownloadRow", LocaleController.getString("DataSettings", R.string.DataSettings), R.drawable.menu_data, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda74
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$47();
                }
            });
            searchResultArr[48] = new SearchResult(this, 212, LocaleController.getString("AutoplayMedia", R.string.AutoplayMedia), "autoplayHeaderRow", LocaleController.getString("DataSettings", R.string.DataSettings), R.drawable.menu_data, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$48();
                }
            });
            searchResultArr[49] = new SearchResult(this, 213, LocaleController.getString("AutoplayGIF", R.string.AutoplayGIF), "autoplayGifsRow", LocaleController.getString("DataSettings", R.string.DataSettings), R.drawable.menu_data, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$49();
                }
            });
            searchResultArr[50] = new SearchResult(this, 214, LocaleController.getString("AutoplayVideo", R.string.AutoplayVideo), "autoplayVideoRow", LocaleController.getString("DataSettings", R.string.DataSettings), R.drawable.menu_data, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda32
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$50();
                }
            });
            searchResultArr[51] = new SearchResult(this, 215, LocaleController.getString("Streaming", R.string.Streaming), "streamSectionRow", LocaleController.getString("DataSettings", R.string.DataSettings), R.drawable.menu_data, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda27
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$51();
                }
            });
            searchResultArr[52] = new SearchResult(this, 216, LocaleController.getString("EnableStreaming", R.string.EnableStreaming), "enableStreamRow", LocaleController.getString("DataSettings", R.string.DataSettings), R.drawable.menu_data, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda71
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$52();
                }
            });
            searchResultArr[53] = new SearchResult(this, 217, LocaleController.getString("Calls", R.string.Calls), "callsSectionRow", LocaleController.getString("DataSettings", R.string.DataSettings), R.drawable.menu_data, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda69
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$53();
                }
            });
            searchResultArr[54] = new SearchResult(this, 218, LocaleController.getString("VoipUseLessData", R.string.VoipUseLessData), "useLessDataForCallsRow", LocaleController.getString("DataSettings", R.string.DataSettings), R.drawable.menu_data, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda49
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$54();
                }
            });
            searchResultArr[55] = new SearchResult(this, 219, LocaleController.getString("VoipQuickReplies", R.string.VoipQuickReplies), "quickRepliesRow", LocaleController.getString("DataSettings", R.string.DataSettings), R.drawable.menu_data, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda24
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$55();
                }
            });
            searchResultArr[56] = new SearchResult(this, 220, LocaleController.getString("ProxySettings", R.string.ProxySettings), LocaleController.getString("DataSettings", R.string.DataSettings), R.drawable.menu_data, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda47
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$56();
                }
            });
            searchResultArr[57] = new SearchResult(221, LocaleController.getString("UseProxyForCalls", R.string.UseProxyForCalls), "callsRow", LocaleController.getString("DataSettings", R.string.DataSettings), LocaleController.getString("ProxySettings", R.string.ProxySettings), R.drawable.menu_data, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda37
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$57();
                }
            });
            searchResultArr[58] = new SearchResult(this, 111, LocaleController.getString("PrivacyDeleteCloudDrafts", R.string.PrivacyDeleteCloudDrafts), "clearDraftsRow", LocaleController.getString("DataSettings", R.string.DataSettings), R.drawable.menu_data, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda65
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$58();
                }
            });
            searchResultArr[59] = new SearchResult(this, 300, LocaleController.getString("ChatSettings", R.string.ChatSettings), R.drawable.menu_chats, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda42
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$59();
                }
            });
            searchResultArr[60] = new SearchResult(this, 301, LocaleController.getString("TextSizeHeader", R.string.TextSizeHeader), "textSizeHeaderRow", LocaleController.getString("ChatSettings", R.string.ChatSettings), R.drawable.menu_chats, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda72
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$60();
                }
            });
            searchResultArr[61] = new SearchResult(this, 302, LocaleController.getString("ChatBackground", R.string.ChatBackground), LocaleController.getString("ChatSettings", R.string.ChatSettings), R.drawable.menu_chats, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda51
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$61();
                }
            });
            searchResultArr[62] = new SearchResult(303, LocaleController.getString("SetColor", R.string.SetColor), null, LocaleController.getString("ChatSettings", R.string.ChatSettings), LocaleController.getString("ChatBackground", R.string.ChatBackground), R.drawable.menu_chats, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda26
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$62();
                }
            });
            searchResultArr[63] = new SearchResult(304, LocaleController.getString("ResetChatBackgrounds", R.string.ResetChatBackgrounds), "resetRow", LocaleController.getString("ChatSettings", R.string.ChatSettings), LocaleController.getString("ChatBackground", R.string.ChatBackground), R.drawable.menu_chats, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda48
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$63();
                }
            });
            searchResultArr[64] = new SearchResult(this, 305, LocaleController.getString("AutoNightTheme", R.string.AutoNightTheme), LocaleController.getString("ChatSettings", R.string.ChatSettings), R.drawable.menu_chats, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda35
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$64();
                }
            });
            searchResultArr[65] = new SearchResult(this, 306, LocaleController.getString("ColorTheme", R.string.ColorTheme), "themeHeaderRow", LocaleController.getString("ChatSettings", R.string.ChatSettings), R.drawable.menu_chats, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda29
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$65();
                }
            });
            searchResultArr[66] = new SearchResult(this, 307, LocaleController.getString("ChromeCustomTabs", R.string.ChromeCustomTabs), "customTabsRow", LocaleController.getString("ChatSettings", R.string.ChatSettings), R.drawable.menu_chats, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda61
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$66();
                }
            });
            searchResultArr[67] = new SearchResult(this, 308, LocaleController.getString("DirectShare", R.string.DirectShare), "directShareRow", LocaleController.getString("ChatSettings", R.string.ChatSettings), R.drawable.menu_chats, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda70
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$67();
                }
            });
            searchResultArr[68] = new SearchResult(this, 309, LocaleController.getString("EnableAnimations", R.string.EnableAnimations), "enableAnimationsRow", LocaleController.getString("ChatSettings", R.string.ChatSettings), R.drawable.menu_chats, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda10
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$68();
                }
            });
            searchResultArr[69] = new SearchResult(this, 310, LocaleController.getString("RaiseToSpeak", R.string.RaiseToSpeak), "raiseToSpeakRow", LocaleController.getString("ChatSettings", R.string.ChatSettings), R.drawable.menu_chats, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda55
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$69();
                }
            });
            searchResultArr[70] = new SearchResult(this, 311, LocaleController.getString("SendByEnter", R.string.SendByEnter), "sendByEnterRow", LocaleController.getString("ChatSettings", R.string.ChatSettings), R.drawable.menu_chats, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$70();
                }
            });
            searchResultArr[71] = new SearchResult(this, 312, LocaleController.getString("SaveToGallerySettings", R.string.SaveToGallerySettings), "saveToGalleryRow", LocaleController.getString("ChatSettings", R.string.ChatSettings), R.drawable.menu_chats, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda40
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$71();
                }
            });
            searchResultArr[72] = new SearchResult(this, 312, LocaleController.getString("DistanceUnits", R.string.DistanceUnits), "distanceRow", LocaleController.getString("ChatSettings", R.string.ChatSettings), R.drawable.menu_chats, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda20
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$72();
                }
            });
            searchResultArr[73] = new SearchResult(this, 313, LocaleController.getString("StickersAndMasks", R.string.StickersAndMasks), LocaleController.getString("ChatSettings", R.string.ChatSettings), R.drawable.menu_chats, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$73();
                }
            });
            searchResultArr[74] = new SearchResult(314, LocaleController.getString("SuggestStickers", R.string.SuggestStickers), "suggestRow", LocaleController.getString("ChatSettings", R.string.ChatSettings), LocaleController.getString("StickersAndMasks", R.string.StickersAndMasks), R.drawable.menu_chats, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda75
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$74();
                }
            });
            searchResultArr[75] = new SearchResult(315, LocaleController.getString("FeaturedStickers", R.string.FeaturedStickers), null, LocaleController.getString("ChatSettings", R.string.ChatSettings), LocaleController.getString("StickersAndMasks", R.string.StickersAndMasks), R.drawable.menu_chats, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda59
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$75();
                }
            });
            searchResultArr[76] = new SearchResult(316, LocaleController.getString("Masks", R.string.Masks), null, LocaleController.getString("ChatSettings", R.string.ChatSettings), LocaleController.getString("StickersAndMasks", R.string.StickersAndMasks), R.drawable.menu_chats, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda60
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$76();
                }
            });
            searchResultArr[77] = new SearchResult(317, LocaleController.getString("ArchivedStickers", R.string.ArchivedStickers), null, LocaleController.getString("ChatSettings", R.string.ChatSettings), LocaleController.getString("StickersAndMasks", R.string.StickersAndMasks), R.drawable.menu_chats, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda62
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$77();
                }
            });
            searchResultArr[78] = new SearchResult(317, LocaleController.getString("ArchivedMasks", R.string.ArchivedMasks), null, LocaleController.getString("ChatSettings", R.string.ChatSettings), LocaleController.getString("StickersAndMasks", R.string.StickersAndMasks), R.drawable.menu_chats, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda58
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$78();
                }
            });
            searchResultArr[79] = new SearchResult(this, 400, LocaleController.getString("Language", R.string.Language), R.drawable.menu_language, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda54
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$79();
                }
            });
            searchResultArr[80] = new SearchResult(this, 403, LocaleController.getString("RubikaFAQ", R.string.RubikaFAQ), LocaleController.getString("SettingsHelp", R.string.SettingsHelp), R.drawable.menu_help, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda68
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$80();
                }
            });
            searchResultArr[81] = new SearchResult(this, HttpStatus.HTTP_NOT_FOUND, LocaleController.getString("PrivacyPolicy", R.string.PrivacyPolicy), LocaleController.getString("SettingsHelp", R.string.SettingsHelp), R.drawable.menu_help, new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda46
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$81();
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
                        serializedData = new SerializedData(Utilities.hexToBytes(it.next()));
                        z = false;
                        int32 = serializedData.readInt32(false);
                        int322 = serializedData.readInt32(false);
                    } catch (Exception unused) {
                    }
                    if (int322 == 0) {
                        String string = serializedData.readString(false);
                        int int323 = serializedData.readInt32(false);
                        if (int323 > 0) {
                            strArr = new String[int323];
                            int i2 = 0;
                            while (i2 < int323) {
                                strArr[i2] = serializedData.readString(z);
                                i2++;
                                z = false;
                            }
                        } else {
                            strArr = null;
                        }
                        MessagesController.FaqSearchResult faqSearchResult = new MessagesController.FaqSearchResult(string, strArr, serializedData.readString(z));
                        faqSearchResult.num = int32;
                        this.recentSearches.add(faqSearchResult);
                    } else if (int322 == 1) {
                        try {
                            SearchResult searchResult = (SearchResult) map.get(Integer.valueOf(serializedData.readInt32(false)));
                            if (searchResult != null) {
                                searchResult.num = int32;
                                this.recentSearches.add(searchResult);
                            }
                        } catch (Exception unused2) {
                        }
                    }
                }
            }
            Collections.sort(this.recentSearches, new Comparator() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda83
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return this.f$0.lambda$new$82(obj, obj2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ int lambda$new$82(Object obj, Object obj2) {
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
            tLRPC$TL_messages_getWebPage.url = LocaleController.getString("RubikaFaqUrl", R.string.RubikaFaqUrl);
            tLRPC$TL_messages_getWebPage.hash = 0;
            ProfileActivity.this.getConnectionsManager().sendRequest(tLRPC$TL_messages_getWebPage, new RequestDelegate() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda84
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$loadFaqWebPage$84(tLObject, tLRPC$TL_error);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$loadFaqWebPage$84(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
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
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ProfileActivity$SearchAdapter$$ExternalSyntheticLambda82
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$loadFaqWebPage$83(arrayList);
                    }
                });
            }
            this.loadingFaqPage = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$loadFaqWebPage$83(ArrayList arrayList) {
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

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return viewHolder.getItemViewType() == 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            int itemViewType = viewHolder.getItemViewType();
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    ((GraySectionCell) viewHolder.itemView).setText(LocaleController.getString("SettingsFaqSearchTitle", R.string.SettingsFaqSearchTitle));
                    return;
                } else {
                    if (itemViewType != 2) {
                        return;
                    }
                    ((HeaderCell) viewHolder.itemView).setText(LocaleController.getString("SettingsRecent", R.string.SettingsRecent));
                    return;
                }
            }
            SettingsSearchCell settingsSearchCell = (SettingsSearchCell) viewHolder.itemView;
            if (this.searchWas) {
                if (i < this.searchResults.size()) {
                    SearchResult searchResult = this.searchResults.get(i);
                    SearchResult searchResult2 = i > 0 ? this.searchResults.get(i - 1) : null;
                    settingsSearchCell.setTextAndValueAndIcon(this.resultNames.get(i), searchResult.path, (searchResult2 == null || searchResult2.iconResId != searchResult.iconResId) ? searchResult.iconResId : 0, i < this.searchResults.size() - 1);
                    return;
                } else {
                    int size = i - (this.searchResults.size() + 1);
                    settingsSearchCell.setTextAndValue(this.resultNames.get(this.searchResults.size() + size), this.faqSearchResults.get(size).path, true, size < this.searchResults.size() - 1);
                    return;
                }
            }
            if (!this.recentSearches.isEmpty()) {
                i--;
            }
            if (i < this.recentSearches.size()) {
                Object obj = this.recentSearches.get(i);
                if (obj instanceof SearchResult) {
                    SearchResult searchResult3 = (SearchResult) obj;
                    settingsSearchCell.setTextAndValue(searchResult3.searchTitle, searchResult3.path, false, i < this.recentSearches.size() - 1);
                    return;
                } else {
                    if (obj instanceof MessagesController.FaqSearchResult) {
                        MessagesController.FaqSearchResult faqSearchResult = (MessagesController.FaqSearchResult) obj;
                        settingsSearchCell.setTextAndValue(faqSearchResult.title, faqSearchResult.path, true, i < this.recentSearches.size() - 1);
                        return;
                    }
                    return;
                }
            }
            int size2 = i - (this.recentSearches.size() + 1);
            MessagesController.FaqSearchResult faqSearchResult2 = this.faqSearchArray.get(size2);
            settingsSearchCell.setTextAndValue(faqSearchResult2.title, faqSearchResult2.path, true, size2 < this.recentSearches.size() - 1);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View settingsSearchCell;
            if (i == 0) {
                settingsSearchCell = new SettingsSearchCell(this.mContext);
            } else if (i == 1) {
                settingsSearchCell = new GraySectionCell(this.mContext);
            } else {
                settingsSearchCell = new HeaderCell(this.mContext, 16);
            }
            settingsSearchCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            return new RecyclerListView.Holder(settingsSearchCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (this.searchWas) {
                if (i >= this.searchResults.size() && i == this.searchResults.size()) {
                    return 1;
                }
            } else {
                if (i == 0) {
                    return !this.recentSearches.isEmpty() ? 2 : 1;
                }
                if (!this.recentSearches.isEmpty() && i == this.recentSearches.size() + 1) {
                    return 1;
                }
            }
            return 0;
        }

        public void addRecent(Object obj) {
            int iIndexOf = this.recentSearches.indexOf(obj);
            if (iIndexOf >= 0) {
                this.recentSearches.remove(iIndexOf);
            }
            this.recentSearches.add(0, obj);
            if (!this.searchWas) {
                notifyDataSetChanged();
            }
            if (this.recentSearches.size() > 20) {
                this.recentSearches.remove(r5.size() - 1);
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int size = this.recentSearches.size();
            for (int i = 0; i < size; i++) {
                Object obj2 = this.recentSearches.get(i);
                if (obj2 instanceof SearchResult) {
                    ((SearchResult) obj2).num = i;
                } else if (obj2 instanceof MessagesController.FaqSearchResult) {
                    ((MessagesController.FaqSearchResult) obj2).num = i;
                }
                linkedHashSet.add(obj2.toString());
            }
            MessagesController.getGlobalMainSettings().edit().putStringSet("settingsSearchRecent2", linkedHashSet).apply();
        }

        public void clearRecent() {
            this.recentSearches.clear();
            MessagesController.getGlobalMainSettings().edit().remove("settingsSearchRecent2").apply();
            notifyDataSetChanged();
        }

        private int getNum(Object obj) {
            if (obj instanceof SearchResult) {
                return ((SearchResult) obj).num;
            }
            if (obj instanceof MessagesController.FaqSearchResult) {
                return ((MessagesController.FaqSearchResult) obj).num;
            }
            return 0;
        }

        public boolean isSearchWas() {
            return this.searchWas;
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: org.rbmain.ui.ProfileActivity$$ExternalSyntheticLambda32
            @Override // org.rbmain.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() {
                this.f$0.lambda$getThemeDescriptions$34();
            }
        };
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        SharedMediaLayout sharedMediaLayout = this.sharedMediaLayout;
        if (sharedMediaLayout != null) {
            arrayList.addAll(sharedMediaLayout.getThemeDescriptions());
        }
        RecyclerListView recyclerListView = this.listView;
        int i = Theme.key_windowBackgroundWhite;
        arrayList.add(new ThemeDescription(recyclerListView, 0, null, null, null, null, i));
        arrayList.add(new ThemeDescription(this.searchListView, 0, null, null, null, null, i));
        arrayList.add(new ThemeDescription(this.listView, 0, null, null, null, null, Theme.key_windowBackgroundGray));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SUBMENUBACKGROUND, null, null, null, null, Theme.key_actionBarDefaultSubmenuBackground));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SUBMENUITEM, null, null, null, null, Theme.key_actionBarDefaultSubmenuItem));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SUBMENUITEM | ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, Theme.key_actionBarDefaultSubmenuItemIcon));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_actionBarDefaultIcon));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_actionBarSelectorBlue));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_chat_lockIcon));
        int i2 = Theme.key_avatar_subtitleInProfileBlue;
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, i2));
        int i3 = Theme.key_avatar_backgroundActionBarBlue;
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, i3));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_profile_title));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_profile_status));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, i2));
        if (this.mediaCounterTextView != null) {
            TextView textView = this.mediaCounterTextView.getTextView();
            int i4 = ThemeDescription.FLAG_TEXTCOLOR;
            int i5 = Theme.key_player_actionBarSubtitle;
            arrayList.add(new ThemeDescription(textView, i4, null, null, null, themeDescriptionDelegate, i5));
            arrayList.add(new ThemeDescription(this.mediaCounterTextView.getNextTextView(), ThemeDescription.FLAG_TEXTCOLOR, null, null, null, themeDescriptionDelegate, i5));
        }
        arrayList.add(new ThemeDescription(this.topView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, i3));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, Theme.key_listSelector));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, Theme.key_divider));
        AvatarImageView avatarImageView = this.avatarImage;
        Drawable[] drawableArr = Theme.avatarDrawables;
        int i6 = Theme.key_avatar_text;
        arrayList.add(new ThemeDescription(avatarImageView, 0, null, null, drawableArr, null, i6));
        arrayList.add(new ThemeDescription(this.avatarImage, 0, null, null, new Drawable[]{this.avatarDrawable}, null, Theme.key_avatar_backgroundInProfileBlue));
        arrayList.add(new ThemeDescription(this.writeButton, ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, Theme.key_profile_actionIcon));
        arrayList.add(new ThemeDescription(this.writeButton, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, Theme.key_profile_actionBackground));
        arrayList.add(new ThemeDescription(this.writeButton, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, null, null, null, null, Theme.key_profile_actionPressedBackground));
        int i7 = Theme.key_windowBackgroundWhiteBlackText;
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i7));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteGreenText2));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_text_RedRegular));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteBlueText2));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteBlueButton));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteValueText));
        int i8 = Theme.key_windowBackgroundWhiteGrayIcon;
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i8));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteBlueIcon));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextDetailCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i7));
        int i9 = Theme.key_windowBackgroundWhiteGrayText2;
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextDetailCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i9));
        int i10 = Theme.key_windowBackgroundWhiteBlueHeader;
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i10));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{NotificationsCheckCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i7));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{NotificationsCheckCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i9));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{NotificationsCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_switchTrack));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{NotificationsCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_switchTrackChecked));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{UserCell.class}, new String[]{"adminTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_profile_creatorIcon));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{UserCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i8));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{UserCell.class}, new String[]{"nameTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i7));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{UserCell.class}, new String[]{"statusColor"}, (Paint[]) null, (Drawable[]) null, themeDescriptionDelegate, Theme.key_windowBackgroundWhiteGrayText));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{UserCell.class}, new String[]{"statusOnlineColor"}, (Paint[]) null, (Drawable[]) null, themeDescriptionDelegate, Theme.key_windowBackgroundWhiteBlueText));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{UserCell.class}, null, Theme.avatarDrawables, null, i6));
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
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{AboutLinkCell.class}, Theme.profile_aboutTextPaint, null, null, i7));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LINKCOLOR, new Class[]{AboutLinkCell.class}, Theme.profile_aboutTextPaint, null, null, Theme.key_windowBackgroundWhiteLinkText));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{AboutLinkCell.class}, Theme.linkSelectionPaint, null, null, Theme.key_windowBackgroundWhiteLinkSelection));
        int i13 = Theme.key_windowBackgroundGrayShadow;
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ShadowSectionCell.class}, null, null, null, i13));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, i13));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteGrayText4));
        arrayList.add(new ThemeDescription(this.searchListView, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i10));
        arrayList.add(new ThemeDescription(this.searchListView, 0, new Class[]{GraySectionCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_graySectionText));
        arrayList.add(new ThemeDescription(this.searchListView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{GraySectionCell.class}, null, null, null, Theme.key_graySection));
        arrayList.add(new ThemeDescription(this.searchListView, 0, new Class[]{SettingsSearchCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i7));
        arrayList.add(new ThemeDescription(this.searchListView, 0, new Class[]{SettingsSearchCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i9));
        arrayList.add(new ThemeDescription(this.searchListView, 0, new Class[]{SettingsSearchCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i8));
        if (this.mediaHeaderVisible) {
            arrayList.add(new ThemeDescription(this.nameTextView[1], 0, null, null, new Drawable[]{this.verifiedCheckDrawable}, null, Theme.key_player_actionBarTitle));
            arrayList.add(new ThemeDescription(this.nameTextView[1], 0, null, null, new Drawable[]{this.verifiedDrawable}, null, i));
        } else {
            arrayList.add(new ThemeDescription(this.nameTextView[1], 0, null, null, new Drawable[]{this.verifiedCheckDrawable}, null, Theme.key_chats_verifiedCheck));
            arrayList.add(new ThemeDescription(this.nameTextView[1], 0, null, null, new Drawable[]{this.verifiedDrawable}, null, Theme.key_chats_verifiedBackground));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getThemeDescriptions$34() {
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
            if (tag instanceof Integer) {
                this.onlineTextView[1].setTextColor(Theme.getColor(((Integer) tag).intValue()));
            } else {
                this.onlineTextView[1].setTextColor(Theme.getColor(Theme.key_avatar_subtitleInProfileBlue));
            }
        }
        Drawable drawable = this.lockIconDrawable;
        if (drawable != null) {
            drawable.setColorFilter(Theme.getColor(Theme.key_chat_lockIcon), PorterDuff.Mode.MULTIPLY);
        }
        ScamDrawable scamDrawable = this.scamDrawable;
        if (scamDrawable != null) {
            scamDrawable.setColor(Theme.getColor(Theme.key_avatar_subtitleInProfileBlue));
        }
        this.nameTextView[1].setTextColor(Theme.getColor(Theme.key_profile_title));
        this.actionBar.setItemsColor(Theme.getColor(Theme.key_actionBarDefaultIcon), false);
        this.actionBar.setItemsBackgroundColor(Theme.getColor(Theme.key_avatar_actionBarSelectorBlue), false);
    }

    public void updateListAnimated(boolean z) {
        if (this.listAdapter == null) {
            if (z) {
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
        if (z) {
            updateOnlineCount(false);
        }
        saveScrollPosition();
        updateRowsIds();
        diffCallback.fillPositions(diffCallback.newPositionToItem);
        try {
            DiffUtil.calculateDiff(diffCallback).dispatchUpdatesTo(this.listAdapter);
        } catch (Exception unused) {
            this.listAdapter.notifyDataSetChanged();
        }
        int i = this.savedScrollPosition;
        if (i >= 0) {
            this.layoutManager.scrollToPositionWithOffset(i, this.savedScrollOffset - this.listView.getPaddingTop());
        }
        AndroidUtilities.updateVisibleRows(this.listView);
    }

    private void saveScrollPosition() {
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
        public boolean areItemsTheSame(int i, int i2) {
            TLRPC$ChatParticipant tLRPC$ChatParticipant;
            if (i2 >= ProfileActivity.this.membersStartRow && i2 < ProfileActivity.this.membersEndRow && i >= this.oldMembersStartRow && i < this.oldMembersEndRow) {
                if (!this.oldChatParticipantSorted.isEmpty()) {
                    tLRPC$ChatParticipant = this.oldChatParticipant.get(this.oldChatParticipantSorted.get(i - this.oldMembersStartRow).intValue());
                } else {
                    ArrayList<TLRPC$ChatParticipant> arrayList = this.oldChatParticipant;
                    if (arrayList == null || arrayList.isEmpty()) {
                        return false;
                    }
                    tLRPC$ChatParticipant = this.oldChatParticipant.get(i - this.oldMembersStartRow);
                }
                return tLRPC$ChatParticipant.user_id == (!ProfileActivity.this.sortedUsers.isEmpty() ? (TLRPC$ChatParticipant) ProfileActivity.this.visibleChatParticipants.get(((Integer) ProfileActivity.this.visibleSortedUsers.get(i2 - ProfileActivity.this.membersStartRow)).intValue()) : (TLRPC$ChatParticipant) ProfileActivity.this.visibleChatParticipants.get(i2 - ProfileActivity.this.membersStartRow)).user_id;
            }
            int i3 = this.oldPositionToItem.get(i, -1);
            return i3 == this.newPositionToItem.get(i2, -1) && i3 >= 0;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areContentsTheSame(int i, int i2) {
            return areItemsTheSame(i, i2);
        }

        public void fillPositions(SparseIntArray sparseIntArray) {
            sparseIntArray.clear();
            put(1, ProfileActivity.this.setAvatarRow, sparseIntArray);
            put(2, ProfileActivity.this.setAvatarSectionRow, sparseIntArray);
            put(3, ProfileActivity.this.numberSectionRow, sparseIntArray);
            put(4, ProfileActivity.this.numberRow, sparseIntArray);
            put(5, ProfileActivity.this.setUsernameRow, sparseIntArray);
            put(6, ProfileActivity.this.bioRow, sparseIntArray);
            put(7, ProfileActivity.this.settingsSectionRow, sparseIntArray);
            put(8, ProfileActivity.this.settingsSectionRow2, sparseIntArray);
            put(9, ProfileActivity.this.notificationRow, sparseIntArray);
            put(10, ProfileActivity.this.languageRow, sparseIntArray);
            put(11, ProfileActivity.this.privacyRow, sparseIntArray);
            put(12, ProfileActivity.this.dataRow, sparseIntArray);
            put(13, ProfileActivity.this.chatRow, sparseIntArray);
            put(14, ProfileActivity.this.filtersRow, sparseIntArray);
            put(15, ProfileActivity.this.devicesRow, sparseIntArray);
            put(16, ProfileActivity.this.devicesSectionRow, sparseIntArray);
            put(17, ProfileActivity.this.helpHeaderRow, sparseIntArray);
            put(18, ProfileActivity.this.questionRow, sparseIntArray);
            put(19, ProfileActivity.this.faqRow, sparseIntArray);
            put(20, ProfileActivity.this.policyRow, sparseIntArray);
            put(21, ProfileActivity.this.helpSectionCell, sparseIntArray);
            put(22, ProfileActivity.this.debugHeaderRow, sparseIntArray);
            put(23, ProfileActivity.this.sendLogsRow, sparseIntArray);
            put(24, ProfileActivity.this.clearLogsRow, sparseIntArray);
            put(25, ProfileActivity.this.switchBackendRow, sparseIntArray);
            put(26, ProfileActivity.this.versionRow, sparseIntArray);
            put(27, ProfileActivity.this.emptyRow, sparseIntArray);
            put(28, ProfileActivity.this.bottomPaddingRow, sparseIntArray);
            put(29, ProfileActivity.this.infoHeaderRow, sparseIntArray);
            put(30, ProfileActivity.this.phoneRow, sparseIntArray);
            put(31, ProfileActivity.this.locationRow, sparseIntArray);
            put(32, ProfileActivity.this.userInfoRow, sparseIntArray);
            put(33, ProfileActivity.this.channelInfoRow, sparseIntArray);
            put(34, ProfileActivity.this.usernameRow, sparseIntArray);
            put(35, ProfileActivity.this.notificationsDividerRow, sparseIntArray);
            put(36, ProfileActivity.this.notificationsRow, sparseIntArray);
            put(37, ProfileActivity.this.infoSectionRow, sparseIntArray);
            put(38, ProfileActivity.this.sendMessageRow, sparseIntArray);
            put(39, ProfileActivity.this.reportRow, sparseIntArray);
            put(40, ProfileActivity.this.settingsTimerRow, sparseIntArray);
            put(41, ProfileActivity.this.settingsKeyRow, sparseIntArray);
            put(42, ProfileActivity.this.secretSettingsSectionRow, sparseIntArray);
            put(43, ProfileActivity.this.membersHeaderRow, sparseIntArray);
            put(44, ProfileActivity.this.addMemberRow, sparseIntArray);
            put(45, ProfileActivity.this.subscribersRow, sparseIntArray);
            put(46, ProfileActivity.this.administratorsRow, sparseIntArray);
            put(47, ProfileActivity.this.blockedUsersRow, sparseIntArray);
            put(48, ProfileActivity.this.membersSectionRow, sparseIntArray);
            put(49, ProfileActivity.this.sharedMediaRow, sparseIntArray);
            put(50, ProfileActivity.this.unblockRow, sparseIntArray);
            put(51, ProfileActivity.this.joinRow, sparseIntArray);
            put(52, ProfileActivity.this.lastSectionRow, sparseIntArray);
        }

        private void put(int i, int i2, SparseIntArray sparseIntArray) {
            if (i2 >= 0) {
                sparseIntArray.put(i2, i);
            }
        }
    }

    void checkHasItemLinks() {
        String dialogId;
        if (this.isOneTimeCheckedItemLinks) {
            return;
        }
        this.isOneTimeCheckedItemLinks = true;
        if (this.user_id != 0) {
            dialogId = IdStorage.getInstance().getDialogId(this.user_id);
        } else {
            dialogId = IdStorage.getInstance().getDialogId(-this.chat_id);
        }
        AccountInstance.getInstance(this.currentAccount).getDialogsProxy().getProfileLinkItems(dialogId, new AnonymousClass34());
    }

    /* renamed from: org.rbmain.ui.ProfileActivity$34, reason: invalid class name */
    class AnonymousClass34 implements LoadListener<GetProfileLinkItemsOutputs> {
        @Override // ir.aaap.messengercore.LoadListener
        public void onError(Exception exc) {
        }

        AnonymousClass34() {
        }

        @Override // ir.aaap.messengercore.LoadListener
        public void onDidLoad(final GetProfileLinkItemsOutputs getProfileLinkItemsOutputs) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ProfileActivity$34$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onDidLoad$0(getProfileLinkItemsOutputs);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onDidLoad$0(GetProfileLinkItemsOutputs getProfileLinkItemsOutputs) {
            ProfileActivity.this.profileItems = getProfileLinkItemsOutputs.link_items;
            ProfileActivity.this.updateRowsIds();
            if (ProfileActivity.this.listAdapter != null) {
                ProfileActivity.this.listAdapter.notifyDataSetChanged();
            }
        }
    }

    private void callGetSettings() {
        ArrayList<SettingItem2> arrayList = this.settingsParts;
        if (arrayList == null || arrayList.isEmpty()) {
            getContactProxy().getSettings(new RequestDelegate() { // from class: org.rbmain.ui.ProfileActivity$$ExternalSyntheticLambda28
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$callGetSettings$36(tLObject, tLRPC$TL_error);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$callGetSettings$36(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ProfileActivity$$ExternalSyntheticLambda20
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$callGetSettings$35(tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$callGetSettings$35(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
        if (tLRPC$TL_error == null) {
            this.settingsParts = ((TLRPC$Tl_settings_parts) tLObject).parts;
            updateListAnimated(false);
        } else {
            AlertsCreator.showSimpleToast(this, tLRPC$TL_error.text);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void checkHasRubinoPage() {
        /*
            r3 = this;
            boolean r0 = r3.isOneTimeCheckedRubino
            if (r0 == 0) goto L5
            return
        L5:
            int r0 = r3.user_id
            java.lang.String r1 = ""
            if (r0 == 0) goto L1e
            org.rbmain.messenger.MessagesController r0 = r3.getMessagesController()
            int r2 = r3.user_id
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            org.rbmain.tgnet.TLRPC$User r0 = r0.getUser(r2)
            if (r0 == 0) goto L35
            java.lang.String r0 = r0.username
            goto L36
        L1e:
            org.rbmain.tgnet.TLRPC$Chat r0 = r3.currentChat
            if (r0 == 0) goto L35
            org.rbmain.messenger.MessagesController r0 = r3.getMessagesController()
            int r2 = r3.chat_id
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            org.rbmain.tgnet.TLRPC$Chat r0 = r0.getChat(r2)
            if (r0 == 0) goto L35
            java.lang.String r0 = r0.username
            goto L36
        L35:
            r0 = r1
        L36:
            if (r0 == 0) goto L64
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto L64
            java.lang.String r2 = "@"
            java.lang.String r0 = r0.replace(r2, r1)
            r1 = 1
            r3.isOneTimeCheckedRubino = r1
            ir.resaneh1.iptv.model.Rubino$IsExistUsernameInput r1 = new ir.resaneh1.iptv.model.Rubino$IsExistUsernameInput
            r1.<init>(r0)
            ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx r0 = r3.getApiRequestMessangerRx()
            io.reactivex.Observable r0 = r0.rubinoIsExistUsername(r1)
            org.rbmain.ui.ProfileActivity$35 r1 = new org.rbmain.ui.ProfileActivity$35
            r1.<init>()
            io.reactivex.Observer r0 = r0.subscribeWith(r1)
            io.reactivex.observers.DisposableObserver r0 = (io.reactivex.observers.DisposableObserver) r0
            io.reactivex.disposables.CompositeDisposable r1 = r3.compositeDisposable
            r1.add(r0)
        L64:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.ProfileActivity.checkHasRubinoPage():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isRtlLayout() {
        return LocaleController.isRTL && this.rtlLayout;
    }
}
