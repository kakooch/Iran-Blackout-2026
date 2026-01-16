package org.rbmain.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.os.Vibrator;
import android.provider.Settings;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.method.Touch;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.transition.TransitionValues;
import android.util.FloatProperty;
import android.util.Property;
import android.util.Range;
import android.util.SparseArray;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.TextureView;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.OverScroller;
import android.widget.Scroller;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import androidMessenger.proxy.DialogsProxy;
import androidx.annotation.Keep;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.core.graphics.ColorUtils;
import androidx.core.widget.NestedScrollView;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScrollerEnd;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.stetho.server.http.HttpStatus;
import com.facebook.stetho.websocket.CloseCodes;
import com.google.android.exoplayer2t.analytics.AnalyticsListener;
import com.google.android.exoplayer2t.ui.AspectRatioFrameLayout;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.rbmain.messenger.AccountInstance;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.Bitmaps;
import org.rbmain.messenger.BringAppForegroundService;
import org.rbmain.messenger.BuildVars;
import org.rbmain.messenger.ChatObject;
import org.rbmain.messenger.DispatchQueue;
import org.rbmain.messenger.DownloadController;
import org.rbmain.messenger.Emoji;
import org.rbmain.messenger.FileLoader;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.ImageLoader;
import org.rbmain.messenger.ImageLocation;
import org.rbmain.messenger.ImageReceiver;
import org.rbmain.messenger.LiteMode;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MediaController;
import org.rbmain.messenger.MediaDataController;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.NotificationsSettingsFacade;
import org.rbmain.messenger.SecureDocument;
import org.rbmain.messenger.SendMessagesHelper;
import org.rbmain.messenger.SharedConfig;
import org.rbmain.messenger.UserConfig;
import org.rbmain.messenger.UserObject;
import org.rbmain.messenger.Utilities;
import org.rbmain.messenger.VideoEditedInfo;
import org.rbmain.messenger.WebFile;
import org.rbmain.messenger.browser.Browser;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$BotInlineResult;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$ChatPhoto;
import org.rbmain.tgnet.TLRPC$Document;
import org.rbmain.tgnet.TLRPC$DocumentAttribute;
import org.rbmain.tgnet.TLRPC$EncryptedChat;
import org.rbmain.tgnet.TLRPC$FileLocation;
import org.rbmain.tgnet.TLRPC$Message;
import org.rbmain.tgnet.TLRPC$MessageAction;
import org.rbmain.tgnet.TLRPC$MessageEntity;
import org.rbmain.tgnet.TLRPC$MessageMedia;
import org.rbmain.tgnet.TLRPC$PageBlock;
import org.rbmain.tgnet.TLRPC$Photo;
import org.rbmain.tgnet.TLRPC$PhotoSize;
import org.rbmain.tgnet.TLRPC$ReplyMarkup;
import org.rbmain.tgnet.TLRPC$TL_documentAttributeVideo;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_fileLocationToBeDeprecated;
import org.rbmain.tgnet.TLRPC$TL_fileLocationUnavailable;
import org.rbmain.tgnet.TLRPC$TL_inputChatPhoto;
import org.rbmain.tgnet.TLRPC$TL_inputPhoto;
import org.rbmain.tgnet.TLRPC$TL_message;
import org.rbmain.tgnet.TLRPC$TL_messageActionEmpty;
import org.rbmain.tgnet.TLRPC$TL_messageActionUserUpdatedPhoto;
import org.rbmain.tgnet.TLRPC$TL_messageMediaDocument;
import org.rbmain.tgnet.TLRPC$TL_messageMediaEmpty;
import org.rbmain.tgnet.TLRPC$TL_messageMediaInvoice;
import org.rbmain.tgnet.TLRPC$TL_messageMediaPhoto;
import org.rbmain.tgnet.TLRPC$TL_messageMediaWebPage;
import org.rbmain.tgnet.TLRPC$TL_messageService;
import org.rbmain.tgnet.TLRPC$TL_photo;
import org.rbmain.tgnet.TLRPC$TL_photoEmpty;
import org.rbmain.tgnet.TLRPC$TL_photos_photo;
import org.rbmain.tgnet.TLRPC$TL_photos_updateProfilePhoto;
import org.rbmain.tgnet.TLRPC$TL_webDocument;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.tgnet.TLRPC$UserProfilePhoto;
import org.rbmain.tgnet.TLRPC$VideoSize;
import org.rbmain.tgnet.TLRPC$WebDocument;
import org.rbmain.tgnet.TLRPC$WebPage;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.ActionBarMenu;
import org.rbmain.ui.ActionBar.ActionBarMenuItem;
import org.rbmain.ui.ActionBar.ActionBarMenuSubItem;
import org.rbmain.ui.ActionBar.ActionBarPopupWindow;
import org.rbmain.ui.ActionBar.AdjustPanLayoutHelper;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.BottomSheet;
import org.rbmain.ui.ActionBar.SimpleTextView;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Adapters.MentionsAdapter;
import org.rbmain.ui.Cells.CheckBoxCell;
import org.rbmain.ui.Cells.PhotoPickerPhotoCell;
import org.rbmain.ui.Components.AlertsCreator;
import org.rbmain.ui.Components.AnimatedFileDrawable;
import org.rbmain.ui.Components.AnimationProperties;
import org.rbmain.ui.Components.BackupImageView;
import org.rbmain.ui.Components.Bulletin;
import org.rbmain.ui.Components.BulletinFactory;
import org.rbmain.ui.Components.ChatAttachAlert;
import org.rbmain.ui.Components.CheckBox;
import org.rbmain.ui.Components.ClippingImageView;
import org.rbmain.ui.Components.CombinedDrawable;
import org.rbmain.ui.Components.Crop.CropTransform;
import org.rbmain.ui.Components.CubicBezierInterpolator;
import org.rbmain.ui.Components.FadingTextViewLayout;
import org.rbmain.ui.Components.FilterGLThread;
import org.rbmain.ui.Components.FilterShaders;
import org.rbmain.ui.Components.FloatSeekBarAccessibilityDelegate;
import org.rbmain.ui.Components.GestureDetector2;
import org.rbmain.ui.Components.GroupedPhotosListView;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.NumberPicker;
import org.rbmain.ui.Components.OtherDocumentPlaceholderDrawable;
import org.rbmain.ui.Components.Paint.Views.ColorPicker;
import org.rbmain.ui.Components.PaintingOverlay;
import org.rbmain.ui.Components.PhotoCropView;
import org.rbmain.ui.Components.PhotoFilterView;
import org.rbmain.ui.Components.PhotoPaintView;
import org.rbmain.ui.Components.PhotoViewerCaptionEnterView;
import org.rbmain.ui.Components.PickerBottomLayoutViewer;
import org.rbmain.ui.Components.PipVideoView;
import org.rbmain.ui.Components.PlayPauseDrawable;
import org.rbmain.ui.Components.RLottieDrawable;
import org.rbmain.ui.Components.RadialProgressView;
import org.rbmain.ui.Components.RecyclerListView;
import org.rbmain.ui.Components.SizeNotifierFrameLayoutPhoto;
import org.rbmain.ui.Components.StickersAlert;
import org.rbmain.ui.Components.TextViewSwitcher;
import org.rbmain.ui.Components.Tooltip;
import org.rbmain.ui.Components.URLSpanBrowser;
import org.rbmain.ui.Components.URLSpanNoUnderline;
import org.rbmain.ui.Components.URLSpanNoUnderlineRubino;
import org.rbmain.ui.Components.URLSpanReplacement;
import org.rbmain.ui.Components.URLSpanUserMentionPhotoViewer;
import org.rbmain.ui.Components.UndoView;
import org.rbmain.ui.Components.VideoEditTextureView;
import org.rbmain.ui.Components.VideoForwardDrawable;
import org.rbmain.ui.Components.VideoPlayer;
import org.rbmain.ui.Components.VideoPlayerSeekBar;
import org.rbmain.ui.Components.VideoSeekPreviewImage;
import org.rbmain.ui.Components.VideoTimelinePlayView;
import org.rbmain.ui.Components.ViewHelper;
import org.rbmain.ui.DialogsActivity;
import org.rbmain.ui.PhotoViewer;
import org.webrtc.MediaStreamTrack;

/* loaded from: classes4.dex */
public class PhotoViewer implements NotificationCenter.NotificationCenterDelegate, GestureDetector2.OnGestureListener, GestureDetector2.OnDoubleTapListener {
    private static volatile PhotoViewer Instance;
    private static volatile PhotoViewer PipInstance;
    private static final Property<VideoPlayerControlFrameLayout, Float> VPC_PROGRESS;
    private static DecelerateInterpolator decelerateInterpolator;
    private static Drawable[] progressDrawables;
    private static Paint progressPaint;
    private ActionBar actionBar;
    private AnimatorSet actionBarAnimator;
    private Context activityContext;
    private ActionBarMenuSubItem allMediaItem;
    private boolean allowMentions;
    private boolean allowShare;
    private boolean allowShowFullscreenButton;
    private float animateToScale;
    private float animateToX;
    private float animateToY;
    private ClippingImageView animatingImageView;
    private Runnable animationEndRunnable;
    private int animationInProgress;
    private long animationStartTime;
    private float animationValue;
    private boolean applying;
    private AspectRatioFrameLayout aspectRatioFrameLayout;
    private boolean attachedToWindow;
    private long audioFramesSize;
    private float avatarStartProgress;
    private long avatarStartTime;
    private int avatarsDialogId;
    private int bitrate;
    private LinearLayout bottomButtonsLayout;
    private FrameLayout bottomLayout;
    private ImageView cameraItem;
    private boolean canEditAvatar;
    private FrameLayout captionContainer;
    private PhotoViewerCaptionEnterView captionEditText;
    private boolean captionHwLayerEnabled;
    private TextView captionLimitView;
    private CaptionScrollView captionScrollView;
    private CaptionTextViewSwitcher captionTextViewSwitcher;
    private AnimatorSet changeModeAnimation;
    private TextureView changedTextureView;
    private boolean changingPage;
    private boolean changingTextureView;
    private CheckBox checkImageView;
    private int classGuid;
    private ImageView compressItem;
    private AnimatorSet compressItemAnimation;
    private FrameLayoutDrawer containerView;
    private boolean cropInitied;
    private ImageView cropItem;
    private int currentAccount;
    private AnimatedFileDrawable currentAnimation;
    private Bitmap currentBitmap;
    private TLRPC$BotInlineResult currentBotInlineResult;
    private long currentDialogId;
    private int currentEditMode;
    private ImageLocation currentFileLocation;
    private ImageLocation currentFileLocationVideo;
    private String currentImageFaceKey;
    private int currentImageHasFace;
    private String currentImagePath;
    private int currentIndex;
    private AnimatorSet currentListViewAnimation;
    private Runnable currentLoadingVideoRunnable;
    private MessageObject currentMessageObject;
    private TLRPC$PageBlock currentPageBlock;
    private float currentPanTranslationY;
    private String currentPathObject;
    private PlaceProviderObject currentPlaceObject;
    private Uri currentPlayingVideoFile;
    private SecureDocument currentSecureDocument;
    private String currentSubtitle;
    private ImageReceiver.BitmapHolder currentThumb;
    private boolean currentVideoFinishedLoading;
    private int dateOverride;
    private FadingTextViewLayout dateTextView;
    private boolean disableShowCheck;
    private boolean discardTap;
    private TextView docInfoTextView;
    private TextView docNameTextView;
    private boolean doneButtonPressed;
    private boolean dontAutoPlay;
    private boolean dontChangeCaptionPosition;
    private boolean dontResetZoomOnFirstLayout;
    private boolean doubleTap;
    private boolean doubleTapEnabled;
    private float dragY;
    private boolean draggingDown;
    private PickerBottomLayoutViewer editorDoneLayout;
    private long endTime;
    private long estimatedDuration;
    private long estimatedSize;
    private ImageView exitFullscreenButton;
    private boolean firstAnimationDelay;
    private AnimatorSet flashAnimator;
    private View flashView;
    boolean fromCamera;
    private int fullscreenedByButton;
    private GestureDetector2 gestureDetector;
    private GroupedPhotosListView groupedPhotosListView;
    private PlaceProviderObject hideAfterAnimation;
    private UndoView hintView;
    private boolean ignoreDidSetImage;
    private AnimatorSet imageMoveAnimation;
    private boolean inBubbleMode;
    private boolean inPreview;
    private VideoPlayer injectingVideoPlayer;
    private SurfaceTexture injectingVideoPlayerSurface;
    private boolean invalidCoords;
    private boolean isCurrentVideo;
    private boolean isDocumentsPicker;
    private boolean isEvent;
    private boolean isFirstLoading;
    private boolean isInline;
    private boolean isPhotosListViewVisible;
    private boolean isPlaying;
    private boolean isStreaming;
    private boolean isVisible;
    private LinearLayout itemsLayout;
    private boolean keepScreenOnFlagSet;
    private int keyboardSize;
    private long lastBufferedPositionCheck;
    private Object lastInsets;
    private long lastPhotoSetTime;
    private long lastSaveTime;
    private String lastTitle;
    private boolean loadInitialVideo;
    private boolean loadingMoreImages;
    float longPressX;
    private boolean manuallyPaused;
    private StickersAlert masksAlert;
    private ActionBarMenuItem masksItem;
    private float maxX;
    private float maxY;
    private LinearLayoutManager mentionLayoutManager;
    private AnimatorSet mentionListAnimation;
    private RecyclerListView mentionListView;
    private MentionsAdapter mentionsAdapter;
    private ActionBarMenuItem menuItem;
    private long mergeDialogId;
    private float minX;
    private float minY;
    private AnimatorSet miniProgressAnimator;
    private RadialProgressView miniProgressView;
    private ImageView mirrorItem;
    private float moveStartX;
    private float moveStartY;
    private boolean moving;
    private ImageView muteItem;
    private boolean muteVideo;
    private String nameOverride;
    private FadingTextViewLayout nameTextView;
    private boolean needCaptionLayout;
    private boolean needSearchImageInArr;
    private boolean needShowOnReady;
    private boolean openedFullScreenVideo;
    private boolean opennedFromMedia;
    private OrientationEventListener orientationEventListener;
    private int originalBitrate;
    private int originalHeight;
    private long originalSize;
    private int originalWidth;
    private boolean padImageForHorizontalInsets;
    private PageBlocksAdapter pageBlocksAdapter;
    private ImageView paintButton;
    private ImageView paintItem;
    private int paintViewTouched;
    private PaintingOverlay paintingOverlay;
    private Activity parentActivity;
    private ChatAttachAlert parentAlert;
    private ChatActivity parentChatActivity;
    private PhotoCropView photoCropView;
    private PhotoFilterView photoFilterView;
    private PhotoPaintView photoPaintView;
    private CounterView photosCounterView;
    private FrameLayout pickerView;
    private ImageView pickerViewSendButton;
    private Drawable pickerViewSendDrawable;
    private float pinchCenterX;
    private float pinchCenterY;
    private float pinchStartDistance;
    private float pinchStartX;
    private float pinchStartY;
    private boolean pipAnimationInProgress;
    private boolean pipAvailable;
    private ActionBarMenuItem pipItem;
    private PipVideoView pipVideoView;
    private PhotoViewerProvider placeProvider;
    private View playButtonAccessibilityOverlay;
    private boolean playerAutoStarted;
    private boolean playerInjected;
    private boolean playerLooping;
    private boolean playerWasPlaying;
    private boolean playerWasReady;
    private int previousCompression;
    private boolean previousCropMirrored;
    private int previousCropOrientation;
    private float previousCropPh;
    private float previousCropPw;
    private float previousCropPx;
    private float previousCropPy;
    private float previousCropRotation;
    private float previousCropScale;
    private boolean previousHasTransform;
    private RadialProgressView progressView;
    private QualityChooseView qualityChooseView;
    private AnimatorSet qualityChooseViewAnimation;
    private PickerBottomLayoutViewer qualityPicker;
    private boolean requestingPreview;
    private TextView resetButton;
    private int resultHeight;
    private int resultWidth;
    private long rewindBackSeekPlayerPosition;
    private boolean rewindByBackSeek;
    private int rewindCount;
    private boolean rewindForward;
    private long rewindLastTime;
    private long rewindLastUpdatePlayerTime;
    private ImageView rotateItem;
    private int rotationValue;
    private Scroller scroller;
    private float seekToProgressPending;
    private float seekToProgressPending2;
    private int selectedCompression;
    private ListAdapter selectedPhotosAdapter;
    private SelectedPhotosListView selectedPhotosListView;
    private ActionBarMenuItem sendItem;
    private int sendPhotoType;
    private ActionBarPopupWindow.ActionBarPopupWindowLayout sendPopupLayout;
    private ActionBarPopupWindow sendPopupWindow;
    private ImageView shareButton;
    private ActionBarMenuItem shareItem;
    private int sharedMediaType;
    private String shouldSavePositionForCurrentVideo;
    private String shouldSavePositionForCurrentVideoShortTerm;
    private PlaceProviderObject showAfterAnimation;
    private ImageReceiver sideImage;
    private boolean skipFirstBufferingProgress;
    private Long slideshowMessageId;
    private long startRewindFrom;
    private long startTime;
    private boolean streamingAlertShown;
    private int switchImageAfterAnimation;
    private boolean switchingInlineMode;
    private int switchingToIndex;
    private ImageView textureImageView;
    private boolean textureUploaded;
    private ImageView timeItem;
    private Tooltip tooltip;
    private int totalImagesCount;
    private int totalImagesCountMerge;
    private int touchSlop;
    private long transitionAnimationStartTime;
    private int transitionIndex;
    private float translationX;
    private float translationY;
    private boolean tryStartRequestPreviewOnFinish;
    private ImageView tuneItem;
    private Runnable updateRewindRunnable;
    private boolean useSmoothKeyboard;
    private VelocityTracker velocityTracker;
    private TextView videoAvatarTooltip;
    private boolean videoConvertSupported;
    private float videoCrossfadeAlpha;
    private long videoCrossfadeAlphaLastTime;
    private boolean videoCrossfadeStarted;
    private float videoCutEnd;
    private float videoCutStart;
    private float videoDuration;
    private VideoForwardDrawable videoForwardDrawable;
    private int videoFramerate;
    private long videoFramesSize;
    private Runnable videoPlayRunnable;
    private VideoPlayer videoPlayer;
    private Animator videoPlayerControlAnimator;
    private VideoPlayerControlFrameLayout videoPlayerControlFrameLayout;
    private VideoPlayerSeekBar videoPlayerSeekbar;
    private View videoPlayerSeekbarView;
    private SimpleTextView videoPlayerTime;
    private VideoSeekPreviewImage videoPreviewFrame;
    private AnimatorSet videoPreviewFrameAnimation;
    private MessageObject videoPreviewMessageObject;
    private boolean videoSizeSet;
    private TextureView videoTextureView;
    private VideoTimelinePlayView videoTimelineView;
    private AlertDialog visibleDialog;
    private int waitingForDraw;
    private int waitingForFirstTextureUpload;
    private boolean wasLayout;
    private boolean wasRotated;
    private WindowManager.LayoutParams windowLayoutParams;
    private FrameLayout windowView;
    private boolean zoomAnimation;
    private boolean zooming;
    private int maxSelectedPhotos = -1;
    private boolean allowOrder = true;
    private Runnable miniProgressShowRunnable = new Runnable() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda43
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.lambda$new$0();
        }
    };
    private boolean isActionBarVisible = true;
    private Map<View, Boolean> actionBarItemsVisibility = new HashMap(3);
    private BackgroundDrawable backgroundDrawable = new BackgroundDrawable(-16777216);
    private Paint blackPaint = new Paint();
    private PhotoProgressView[] photoProgressViews = new PhotoProgressView[3];
    private GradientDrawable[] pressedDrawable = new GradientDrawable[2];
    private boolean[] drawPressedDrawable = new boolean[2];
    private float[] pressedDrawableAlpha = new float[2];
    private CropTransform cropTransform = new CropTransform();
    private Paint bitmapPaint = new Paint(2);
    private Runnable setLoadingRunnable = new Runnable() { // from class: org.rbmain.ui.PhotoViewer.1
        @Override // java.lang.Runnable
        public void run() {
            if (PhotoViewer.this.currentMessageObject == null) {
                return;
            }
            FileLoader.getInstance(PhotoViewer.this.currentMessageObject.currentAccount).setLoadingVideo(PhotoViewer.this.currentMessageObject.getDocument(), true, false);
        }
    };
    private Runnable hideActionBarRunnable = new Runnable() { // from class: org.rbmain.ui.PhotoViewer.2
        @Override // java.lang.Runnable
        public void run() {
            if (PhotoViewer.this.videoPlayerControlVisible && PhotoViewer.this.isPlaying && !ApplicationLoader.mainInterfacePaused) {
                if (PhotoViewer.this.menuItem == null || !PhotoViewer.this.menuItem.isSubMenuShowing()) {
                    if (PhotoViewer.this.captionScrollView == null || PhotoViewer.this.captionScrollView.getScrollY() == 0) {
                        if (PhotoViewer.this.miniProgressView == null || PhotoViewer.this.miniProgressView.getVisibility() != 0) {
                            PhotoViewer photoViewer = PhotoViewer.PipInstance;
                            PhotoViewer photoViewer2 = PhotoViewer.this;
                            if (photoViewer == photoViewer2) {
                                return;
                            }
                            photoViewer2.toggleActionBar(false, true);
                        }
                    }
                }
            }
        }
    };
    private ArrayMap<String, SavedVideoPosition> savedVideoPositions = new ArrayMap<>();
    private boolean videoPlayerControlVisible = true;
    private int[] videoPlayerCurrentTime = new int[2];
    private int[] videoPlayerTotalTime = new int[2];
    private ImageView[] fullscreenButton = new ImageView[3];
    private int[] pipPosition = new int[2];
    private int lastImageId = -1;
    private int prevOrientation = -10;
    public final Property<View, Float> FLASH_VIEW_VALUE = new AnimationProperties.FloatProperty<View>("flashViewAlpha") { // from class: org.rbmain.ui.PhotoViewer.3
        @Override // org.rbmain.ui.Components.AnimationProperties.FloatProperty
        public void setValue(View view, float f) {
            view.setAlpha(f);
            if (PhotoViewer.this.photoCropView != null) {
                PhotoViewer.this.photoCropView.setVideoThumbFlashAlpha(f);
            }
        }

        @Override // android.util.Property
        public Float get(View view) {
            return Float.valueOf(view.getAlpha());
        }
    };
    private long limitedVideoTime = 0;
    private boolean rtlLayout = true;
    private Runnable updateProgressRunnable = new AnonymousClass4();
    private Runnable switchToInlineRunnable = new Runnable() { // from class: org.rbmain.ui.PhotoViewer.5
        @Override // java.lang.Runnable
        public void run() {
            PhotoViewer.this.switchingInlineMode = false;
            if (PhotoViewer.this.currentBitmap != null) {
                PhotoViewer.this.currentBitmap.recycle();
                PhotoViewer.this.currentBitmap = null;
            }
            PhotoViewer.this.changingTextureView = true;
            if (PhotoViewer.this.textureImageView != null) {
                try {
                    PhotoViewer photoViewer = PhotoViewer.this;
                    photoViewer.currentBitmap = Bitmaps.createBitmap(photoViewer.videoTextureView.getWidth(), PhotoViewer.this.videoTextureView.getHeight(), Bitmap.Config.ARGB_8888);
                    PhotoViewer.this.videoTextureView.getBitmap(PhotoViewer.this.currentBitmap);
                } catch (Throwable th) {
                    if (PhotoViewer.this.currentBitmap != null) {
                        PhotoViewer.this.currentBitmap.recycle();
                        PhotoViewer.this.currentBitmap = null;
                    }
                    FileLog.e(th);
                }
                if (PhotoViewer.this.currentBitmap != null) {
                    PhotoViewer.this.textureImageView.setVisibility(0);
                    PhotoViewer.this.textureImageView.setImageBitmap(PhotoViewer.this.currentBitmap);
                } else {
                    PhotoViewer.this.textureImageView.setImageDrawable(null);
                }
            }
            PhotoViewer.this.isInline = true;
            PhotoViewer.this.pipVideoView = new PipVideoView(false);
            PhotoViewer photoViewer2 = PhotoViewer.this;
            PipVideoView pipVideoView = photoViewer2.pipVideoView;
            Activity activity = PhotoViewer.this.parentActivity;
            PhotoViewer photoViewer3 = PhotoViewer.this;
            photoViewer2.changedTextureView = pipVideoView.show(activity, photoViewer3, photoViewer3.aspectRatioFrameLayout.getAspectRatio(), PhotoViewer.this.aspectRatioFrameLayout.getVideoRotation());
            PhotoViewer.this.changedTextureView.setVisibility(4);
            PhotoViewer.this.aspectRatioFrameLayout.removeView(PhotoViewer.this.videoTextureView);
        }
    };
    private TextureView.SurfaceTextureListener surfaceTextureListener = new TextureView.SurfaceTextureListener() { // from class: org.rbmain.ui.PhotoViewer.6
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            if (PhotoViewer.this.videoTextureView == null || !PhotoViewer.this.changingTextureView) {
                return true;
            }
            if (PhotoViewer.this.switchingInlineMode) {
                PhotoViewer.this.waitingForFirstTextureUpload = 2;
            }
            PhotoViewer.this.videoTextureView.setSurfaceTexture(surfaceTexture);
            PhotoViewer.this.videoTextureView.setVisibility(0);
            PhotoViewer.this.changingTextureView = false;
            PhotoViewer.this.containerView.invalidate();
            return false;
        }

        /* renamed from: org.rbmain.ui.PhotoViewer$6$1, reason: invalid class name */
        class AnonymousClass1 implements ViewTreeObserver.OnPreDrawListener {
            AnonymousClass1() {
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                PhotoViewer.this.changedTextureView.getViewTreeObserver().removeOnPreDrawListener(this);
                if (PhotoViewer.this.textureImageView != null) {
                    PhotoViewer.this.textureImageView.setVisibility(4);
                    PhotoViewer.this.textureImageView.setImageDrawable(null);
                    if (PhotoViewer.this.currentBitmap != null) {
                        PhotoViewer.this.currentBitmap.recycle();
                        PhotoViewer.this.currentBitmap = null;
                    }
                }
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.PhotoViewer$6$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onPreDraw$0();
                    }
                });
                PhotoViewer.this.waitingForFirstTextureUpload = 0;
                return true;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onPreDraw$0() {
                if (PhotoViewer.this.isInline) {
                    PhotoViewer.this.dismissInternal();
                }
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            if (PhotoViewer.this.waitingForFirstTextureUpload == 1) {
                PhotoViewer.this.changedTextureView.getViewTreeObserver().addOnPreDrawListener(new AnonymousClass1());
                PhotoViewer.this.changedTextureView.invalidate();
            }
        }
    };
    private float[][] animationValues = (float[][]) Array.newInstance((Class<?>) float.class, 2, 13);
    private final Runnable updateContainerFlagsRunnable = new Runnable() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda48
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.lambda$new$1();
        }
    };
    private ImageReceiver leftImage = new ImageReceiver();
    private ImageReceiver centerImage = new ImageReceiver();
    private ImageReceiver rightImage = new ImageReceiver();
    private EditState editState = new EditState();
    private String[] currentFileNames = new String[3];
    private boolean[] endReached = {false, true};
    private float scale = 1.0f;
    private int switchingToMode = -1;
    private DecelerateInterpolator interpolator = new DecelerateInterpolator(1.5f);
    private float pinchStartScale = 1.0f;
    private boolean canZoom = true;
    private boolean canDragDown = true;
    private boolean bottomTouchEnabled = true;
    private ArrayList<MessageObject> imagesArrTemp = new ArrayList<>();
    private LongSparseArray<MessageObject>[] imagesByIdsTemp = {new LongSparseArray<>(), new LongSparseArray<>()};
    private ArrayList<MessageObject> imagesArr = new ArrayList<>();
    private LongSparseArray<MessageObject>[] imagesByIds = {new LongSparseArray<>(), new LongSparseArray<>()};
    private ArrayList<ImageLocation> imagesArrLocations = new ArrayList<>();
    private ArrayList<ImageLocation> imagesArrLocationsVideo = new ArrayList<>();
    private ArrayList<Integer> imagesArrLocationsSizes = new ArrayList<>();
    private ArrayList<TLRPC$Message> imagesArrMessages = new ArrayList<>();
    private ArrayList<SecureDocument> secureDocuments = new ArrayList<>();
    private ArrayList<TLRPC$Photo> avatarsArr = new ArrayList<>();
    private ArrayList<Object> imagesArrLocals = new ArrayList<>();
    private ImageLocation currentAvatarLocation = null;
    private SavedState savedState = null;
    private Rect hitRect = new Rect();
    Runnable longPressRunnable = new Runnable() { // from class: org.rbmain.ui.PhotoViewer.63
        @Override // java.lang.Runnable
        public void run() {
            PhotoViewer.this.onLongPress();
        }
    };
    private final Runnable backSeek = new Runnable() { // from class: org.rbmain.ui.PhotoViewer.67
        @Override // java.lang.Runnable
        public void run() throws IllegalAccessException, NoSuchFieldException, Resources.NotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException {
            long j;
            long duration = PhotoViewer.this.videoPlayer.getDuration();
            if (duration == 0 || duration == -9223372036854775807L) {
                PhotoViewer.this.rewindLastTime = System.currentTimeMillis();
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j2 = jCurrentTimeMillis - PhotoViewer.this.rewindLastTime;
            PhotoViewer.this.rewindLastTime = jCurrentTimeMillis;
            if (PhotoViewer.this.rewindCount == 1) {
                j = 3;
            } else {
                j = PhotoViewer.this.rewindCount == 2 ? 6L : 12L;
            }
            long j3 = j2 * j;
            if (PhotoViewer.this.rewindForward) {
                PhotoViewer.access$24714(PhotoViewer.this, j3);
            } else {
                PhotoViewer.access$24722(PhotoViewer.this, j3);
            }
            if (PhotoViewer.this.rewindBackSeekPlayerPosition < 0) {
                PhotoViewer.this.rewindBackSeekPlayerPosition = 0L;
            } else if (PhotoViewer.this.rewindBackSeekPlayerPosition > duration) {
                PhotoViewer.this.rewindBackSeekPlayerPosition = duration;
            }
            if (PhotoViewer.this.rewindByBackSeek && PhotoViewer.this.videoPlayer != null && PhotoViewer.this.rewindLastTime - PhotoViewer.this.rewindLastUpdatePlayerTime > 350) {
                PhotoViewer photoViewer = PhotoViewer.this;
                photoViewer.rewindLastUpdatePlayerTime = photoViewer.rewindLastTime;
                PhotoViewer.this.videoPlayer.seekTo(PhotoViewer.this.rewindBackSeekPlayerPosition);
            }
            if (PhotoViewer.this.videoPlayer != null) {
                PhotoViewer.this.videoForwardDrawable.setTime(Math.abs(PhotoViewer.this.rewindBackSeekPlayerPosition - PhotoViewer.this.startRewindFrom));
                if (PhotoViewer.this.rewindByBackSeek) {
                    PhotoViewer.this.videoPlayerSeekbar.setProgress(PhotoViewer.this.rewindBackSeekPlayerPosition / PhotoViewer.this.videoPlayer.getDuration());
                    PhotoViewer.this.videoPlayerSeekbarView.invalidate();
                }
            }
            if (PhotoViewer.this.rewindBackSeekPlayerPosition == 0 || PhotoViewer.this.rewindBackSeekPlayerPosition >= duration) {
                if (PhotoViewer.this.rewindByBackSeek && PhotoViewer.this.videoPlayer != null) {
                    PhotoViewer photoViewer2 = PhotoViewer.this;
                    photoViewer2.rewindLastUpdatePlayerTime = photoViewer2.rewindLastTime;
                    PhotoViewer.this.videoPlayer.seekTo(PhotoViewer.this.rewindBackSeekPlayerPosition);
                }
                PhotoViewer.this.cancelRewind();
                PhotoViewer.this.onTouchEvent(MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0));
            }
            if (PhotoViewer.this.rewindCount > 0) {
                AndroidUtilities.runOnUIThread(PhotoViewer.this.backSeek, 16L);
            }
        }
    };
    private long captureFrameAtTime = -1;
    private long captureFrameReadyAtTime = -1;
    private long needCaptureFrameReadyAtTime = -1;
    private int compressionsCount = -1;

    public static class EmptyPhotoViewerProvider implements PhotoViewerProvider {
        @Override // org.rbmain.ui.PhotoViewer.PhotoViewerProvider
        public boolean allowCaption() {
            return true;
        }

        @Override // org.rbmain.ui.PhotoViewer.PhotoViewerProvider
        public boolean allowSendingSubmenu() {
            return true;
        }

        @Override // org.rbmain.ui.PhotoViewer.PhotoViewerProvider
        public boolean canCaptureMorePhotos() {
            return true;
        }

        @Override // org.rbmain.ui.PhotoViewer.PhotoViewerProvider
        public boolean canReplace(int i) {
            return false;
        }

        @Override // org.rbmain.ui.PhotoViewer.PhotoViewerProvider
        public boolean canScrollAway() {
            return true;
        }

        @Override // org.rbmain.ui.PhotoViewer.PhotoViewerProvider
        public boolean cancelButtonPressed() {
            return true;
        }

        @Override // org.rbmain.ui.PhotoViewer.PhotoViewerProvider
        public boolean closeKeyboard() {
            return false;
        }

        @Override // org.rbmain.ui.PhotoViewer.PhotoViewerProvider
        public void deleteImageAtIndex(int i) {
        }

        @Override // org.rbmain.ui.PhotoViewer.PhotoViewerProvider
        public String getDeleteMessageString() {
            return null;
        }

        @Override // org.rbmain.ui.PhotoViewer.PhotoViewerProvider
        public MessageObject getEditingMessageObject() {
            return null;
        }

        @Override // org.rbmain.ui.PhotoViewer.PhotoViewerProvider
        public PlaceProviderObject getPlaceForPhoto(MessageObject messageObject, TLRPC$FileLocation tLRPC$FileLocation, int i, boolean z) {
            return null;
        }

        @Override // org.rbmain.ui.PhotoViewer.PhotoViewerProvider
        public int getSelectedCount() {
            return 0;
        }

        @Override // org.rbmain.ui.PhotoViewer.PhotoViewerProvider
        public HashMap<Object, Object> getSelectedPhotos() {
            return null;
        }

        @Override // org.rbmain.ui.PhotoViewer.PhotoViewerProvider
        public ArrayList<Object> getSelectedPhotosOrder() {
            return null;
        }

        @Override // org.rbmain.ui.PhotoViewer.PhotoViewerProvider
        public CharSequence getSubtitleFor(int i) {
            return null;
        }

        @Override // org.rbmain.ui.PhotoViewer.PhotoViewerProvider
        public ImageReceiver.BitmapHolder getThumbForPhoto(MessageObject messageObject, TLRPC$FileLocation tLRPC$FileLocation, int i) {
            return null;
        }

        @Override // org.rbmain.ui.PhotoViewer.PhotoViewerProvider
        public CharSequence getTitleFor(int i) {
            return null;
        }

        @Override // org.rbmain.ui.PhotoViewer.PhotoViewerProvider
        public int getTotalImageCount() {
            return -1;
        }

        @Override // org.rbmain.ui.PhotoViewer.PhotoViewerProvider
        public boolean isPhotoChecked(int i) {
            return false;
        }

        @Override // org.rbmain.ui.PhotoViewer.PhotoViewerProvider
        public boolean loadMore() {
            return false;
        }

        @Override // org.rbmain.ui.PhotoViewer.PhotoViewerProvider
        public void needAddMorePhotos() {
        }

        @Override // org.rbmain.ui.PhotoViewer.PhotoViewerProvider
        public void onCaptionChanged(CharSequence charSequence) {
        }

        @Override // org.rbmain.ui.PhotoViewer.PhotoViewerProvider
        public void openPhotoForEdit(String str, String str2, boolean z) {
        }

        @Override // org.rbmain.ui.PhotoViewer.PhotoViewerProvider
        public void replaceButtonPressed(int i, VideoEditedInfo videoEditedInfo) {
        }

        @Override // org.rbmain.ui.PhotoViewer.PhotoViewerProvider
        public boolean scaleToFill() {
            return false;
        }

        @Override // org.rbmain.ui.PhotoViewer.PhotoViewerProvider
        public void sendButtonPressed(int i, VideoEditedInfo videoEditedInfo, boolean z, int i2, boolean z2) {
        }

        @Override // org.rbmain.ui.PhotoViewer.PhotoViewerProvider
        public int setPhotoChecked(int i, VideoEditedInfo videoEditedInfo) {
            return -1;
        }

        @Override // org.rbmain.ui.PhotoViewer.PhotoViewerProvider
        public int setPhotoUnchecked(Object obj) {
            return -1;
        }

        @Override // org.rbmain.ui.PhotoViewer.PhotoViewerProvider
        public void updatePhotoAtIndex(int i) {
        }

        @Override // org.rbmain.ui.PhotoViewer.PhotoViewerProvider
        public void willHidePhotoViewer() {
        }

        @Override // org.rbmain.ui.PhotoViewer.PhotoViewerProvider
        public void willSwitchFromPhoto(MessageObject messageObject, TLRPC$FileLocation tLRPC$FileLocation, int i) {
        }
    }

    public interface PageBlocksAdapter {
        TLRPC$PageBlock get(int i);

        List<TLRPC$PageBlock> getAll();

        CharSequence getCaption(int i);

        File getFile(int i);

        TLRPC$PhotoSize getFileLocation(TLObject tLObject, int[] iArr);

        String getFileName(int i);

        int getItemsCount();

        TLObject getMedia(int i);

        Object getParentObject();

        boolean isVideo(int i);

        void updateSlideshowCell(TLRPC$PageBlock tLRPC$PageBlock);
    }

    public interface PhotoViewerProvider {
        boolean allowCaption();

        boolean allowSendingSubmenu();

        boolean canCaptureMorePhotos();

        boolean canReplace(int i);

        boolean canScrollAway();

        boolean cancelButtonPressed();

        boolean closeKeyboard();

        void deleteImageAtIndex(int i);

        String getDeleteMessageString();

        MessageObject getEditingMessageObject();

        PlaceProviderObject getPlaceForPhoto(MessageObject messageObject, TLRPC$FileLocation tLRPC$FileLocation, int i, boolean z);

        int getSelectedCount();

        HashMap<Object, Object> getSelectedPhotos();

        ArrayList<Object> getSelectedPhotosOrder();

        CharSequence getSubtitleFor(int i);

        ImageReceiver.BitmapHolder getThumbForPhoto(MessageObject messageObject, TLRPC$FileLocation tLRPC$FileLocation, int i);

        CharSequence getTitleFor(int i);

        int getTotalImageCount();

        boolean isPhotoChecked(int i);

        boolean loadMore();

        void needAddMorePhotos();

        void onCaptionChanged(CharSequence charSequence);

        void openPhotoForEdit(String str, String str2, boolean z);

        void replaceButtonPressed(int i, VideoEditedInfo videoEditedInfo);

        boolean scaleToFill();

        void sendButtonPressed(int i, VideoEditedInfo videoEditedInfo, boolean z, int i2, boolean z2);

        int setPhotoChecked(int i, VideoEditedInfo videoEditedInfo);

        int setPhotoUnchecked(Object obj);

        void updatePhotoAtIndex(int i);

        void willHidePhotoViewer();

        void willSwitchFromPhoto(MessageObject messageObject, TLRPC$FileLocation tLRPC$FileLocation, int i);
    }

    public static class PlaceProviderObject {
        public ClippingImageView animatingImageView;
        public int animatingImageViewYOffset;
        public boolean canEdit;
        public int clipBottomAddition;
        public int clipTopAddition;
        public int dialogId;
        public ImageReceiver imageReceiver;
        public boolean isEvent;
        public View parentView;
        public int[] radius;
        public int size;
        public ImageReceiver.BitmapHolder thumb;
        public int viewX;
        public int viewY;
        public float scale = 1.0f;
        public boolean allowTakeAnimation = true;
    }

    private void checkBufferedProgress(float f) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$setParentActivity$22(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$setParentActivity$23(View view, MotionEvent motionEvent) {
        return true;
    }

    @Override // org.rbmain.ui.Components.GestureDetector2.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // org.rbmain.ui.Components.GestureDetector2.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // org.rbmain.ui.Components.GestureDetector2.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // org.rbmain.ui.Components.GestureDetector2.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    public void setTitle(CharSequence charSequence) {
    }

    static /* synthetic */ long access$24714(PhotoViewer photoViewer, long j) {
        long j2 = photoViewer.rewindBackSeekPlayerPosition + j;
        photoViewer.rewindBackSeekPlayerPosition = j2;
        return j2;
    }

    static /* synthetic */ long access$24722(PhotoViewer photoViewer, long j) {
        long j2 = photoViewer.rewindBackSeekPlayerPosition - j;
        photoViewer.rewindBackSeekPlayerPosition = j2;
        return j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        toggleMiniProgressInternal(true);
    }

    public void addPhoto(MessageObject messageObject, int i) throws Resources.NotFoundException {
        if (i != this.classGuid) {
            return;
        }
        if (this.imagesByIds[0].indexOfKey(messageObject.getId()) < 0) {
            if (this.opennedFromMedia) {
                this.imagesArr.add(messageObject);
            } else {
                this.imagesArr.add(0, messageObject);
            }
            this.imagesByIds[0].put(messageObject.getId(), messageObject);
        }
        this.endReached[0] = this.imagesArr.size() == this.totalImagesCount;
        setImages();
    }

    public int getClassGuid() {
        return this.classGuid;
    }

    private static class SavedVideoPosition {
        public final float position;
        public final long timestamp;

        public SavedVideoPosition(float f, long j) {
            this.position = f;
            this.timestamp = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class CaptionLinkMovementMethod extends LinkMovementMethod {
        Runnable longPressRunnable;
        ClickableSpan selectedLink;
        TextView selectedWidget;

        private CaptionLinkMovementMethod() {
            this.longPressRunnable = new Runnable() { // from class: org.rbmain.ui.PhotoViewer.CaptionLinkMovementMethod.1
                @Override // java.lang.Runnable
                public void run() {
                    CaptionLinkMovementMethod captionLinkMovementMethod = CaptionLinkMovementMethod.this;
                    if (captionLinkMovementMethod.selectedWidget != null) {
                        ClickableSpan clickableSpan = captionLinkMovementMethod.selectedLink;
                        if (clickableSpan instanceof URLSpan) {
                            captionLinkMovementMethod.onLongClick((URLSpan) clickableSpan);
                            CaptionLinkMovementMethod.this.selectedLink = null;
                        }
                    }
                }
            };
        }

        @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
            boolean z;
            try {
                if (!PhotoViewer.this.imagesArrLocals.isEmpty()) {
                    return false;
                }
                int action = motionEvent.getAction();
                if (action == 3) {
                    AndroidUtilities.cancelRunOnUIThread(this.longPressRunnable);
                    this.selectedLink = null;
                }
                if (action == 1 || action == 0) {
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    int totalPaddingLeft = x - textView.getTotalPaddingLeft();
                    int totalPaddingTop = y - textView.getTotalPaddingTop();
                    int scrollX = totalPaddingLeft + textView.getScrollX();
                    int scrollY = totalPaddingTop + textView.getScrollY();
                    Layout layout = textView.getLayout();
                    int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
                    ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
                    if (clickableSpanArr.length != 0) {
                        ClickableSpan clickableSpan = clickableSpanArr[0];
                        if (action == 1) {
                            if (this.selectedLink != clickableSpan) {
                                this.selectedLink = null;
                                return false;
                            }
                            onClick(clickableSpan, textView);
                            AndroidUtilities.cancelRunOnUIThread(this.longPressRunnable);
                            this.selectedLink = null;
                        } else {
                            Selection.setSelection(spannable, spannable.getSpanStart(clickableSpan), spannable.getSpanEnd(clickableSpan));
                            AndroidUtilities.runOnUIThread(this.longPressRunnable, ViewConfiguration.getLongPressTimeout());
                            this.selectedLink = clickableSpan;
                            this.selectedWidget = textView;
                        }
                        z = true;
                    } else {
                        Selection.removeSelection(spannable);
                        AndroidUtilities.cancelRunOnUIThread(this.longPressRunnable);
                        this.selectedLink = null;
                        z = false;
                    }
                } else {
                    z = false;
                }
                return z || Touch.onTouchEvent(textView, spannable, motionEvent);
            } catch (Exception e) {
                FileLog.e(e);
                return false;
            }
        }

        private void onClick(ClickableSpan clickableSpan, TextView textView) {
            if (textView != null && (clickableSpan instanceof URLSpan)) {
                String url = ((URLSpan) clickableSpan).getURL();
                if (url.startsWith(MediaStreamTrack.VIDEO_TRACK_KIND)) {
                    if (PhotoViewer.this.videoPlayer == null || PhotoViewer.this.currentMessageObject == null) {
                        return;
                    }
                    int iIntValue = Utilities.parseInt(url).intValue();
                    if (PhotoViewer.this.videoPlayer.getDuration() != -9223372036854775807L) {
                        long j = iIntValue * 1000;
                        PhotoViewer.this.videoPlayer.seekTo(j);
                        PhotoViewer.this.videoPlayerSeekbar.setProgress(j / PhotoViewer.this.videoPlayer.getDuration(), true);
                        PhotoViewer.this.videoPlayerSeekbarView.invalidate();
                        return;
                    }
                    PhotoViewer.this.seekToProgressPending = iIntValue / r7.currentMessageObject.getDuration();
                    return;
                }
                if (url.startsWith("#")) {
                    if (PhotoViewer.this.parentActivity instanceof LaunchActivity) {
                        if (((LaunchActivity) PhotoViewer.this.parentActivity).getLastFragment() instanceof ChatActivity) {
                            ((ChatActivity) ((LaunchActivity) PhotoViewer.this.parentActivity).getLastFragment()).openSearchWithText(url);
                        }
                        PhotoViewer.this.closePhoto(false, false);
                        return;
                    }
                    return;
                }
                if (PhotoViewer.this.parentChatActivity != null && ((clickableSpan instanceof URLSpanReplacement) || AndroidUtilities.shouldShowUrlInAlert(url))) {
                    AlertsCreator.showOpenUrlAlert(PhotoViewer.this.parentChatActivity, url, true, true);
                    return;
                }
                if ((clickableSpan instanceof URLSpanBrowser) || (clickableSpan instanceof URLSpanNoUnderline) || (clickableSpan instanceof URLSpanNoUnderlineRubino) || (clickableSpan instanceof URLSpanReplacement)) {
                    clickableSpan.onClick(textView);
                    return;
                } else {
                    Browser.openUrl(textView.getContext(), url);
                    return;
                }
            }
            clickableSpan.onClick(textView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onLongClick(final URLSpan uRLSpan) {
            BottomSheet.Builder builder = new BottomSheet.Builder(PhotoViewer.this.parentActivity);
            builder.setTitle(uRLSpan.getURL());
            builder.setItems(new CharSequence[]{LocaleController.getString("Open", R.string.Open), LocaleController.getString("Copy", R.string.Copy)}, new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.PhotoViewer$CaptionLinkMovementMethod$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$onLongClick$0(uRLSpan, dialogInterface, i);
                }
            });
            builder.create().show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x003e  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0071  */
        /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public /* synthetic */ void lambda$onLongClick$0(android.text.style.URLSpan r2, android.content.DialogInterface r3, int r4) {
            /*
                r1 = this;
                if (r4 != 0) goto L9
                android.widget.TextView r3 = r1.selectedWidget
                r1.onClick(r2, r3)
                goto L86
            L9:
                r3 = 1
                if (r4 != r3) goto L86
                java.lang.String r2 = r2.getURL()
                r4 = 0
                java.lang.String r0 = "mailto:"
                boolean r0 = r2.startsWith(r0)
                if (r0 == 0) goto L1f
                r3 = 7
                java.lang.String r2 = r2.substring(r3)
                goto L2e
            L1f:
                java.lang.String r0 = "tel:"
                boolean r0 = r2.startsWith(r0)
                if (r0 == 0) goto L2e
                r4 = 4
                java.lang.String r2 = r2.substring(r4)
                goto L2f
            L2e:
                r3 = 0
            L2f:
                org.rbmain.messenger.AndroidUtilities.addToClipboard(r2)
                if (r3 == 0) goto L3e
                r2 = 2131890588(0x7f12119c, float:1.9415872E38)
                java.lang.String r3 = "PhoneCopied"
                java.lang.String r2 = org.rbmain.messenger.LocaleController.getString(r3, r2)
                goto L6b
            L3e:
                java.lang.String r3 = "#"
                boolean r3 = r2.startsWith(r3)
                if (r3 == 0) goto L50
                r2 = 2131888940(0x7f120b2c, float:1.941253E38)
                java.lang.String r3 = "HashtagCopied"
                java.lang.String r2 = org.rbmain.messenger.LocaleController.getString(r3, r2)
                goto L6b
            L50:
                java.lang.String r3 = "@"
                boolean r2 = r2.startsWith(r3)
                if (r2 == 0) goto L62
                r2 = 2131892385(0x7f1218a1, float:1.9419517E38)
                java.lang.String r3 = "UsernameCopied"
                java.lang.String r2 = org.rbmain.messenger.LocaleController.getString(r3, r2)
                goto L6b
            L62:
                r2 = 2131889313(0x7f120ca1, float:1.9413286E38)
                java.lang.String r3 = "LinkCopied"
                java.lang.String r2 = org.rbmain.messenger.LocaleController.getString(r3, r2)
            L6b:
                boolean r3 = org.rbmain.messenger.AndroidUtilities.shouldShowClipboardToast()
                if (r3 == 0) goto L86
                org.rbmain.ui.PhotoViewer r3 = org.rbmain.ui.PhotoViewer.this
                org.rbmain.ui.PhotoViewer$FrameLayoutDrawer r3 = org.rbmain.ui.PhotoViewer.access$1700(r3)
                r4 = 0
                org.rbmain.ui.Components.BulletinFactory r3 = org.rbmain.ui.Components.BulletinFactory.of(r3, r4)
                r4 = 2131820697(0x7f110099, float:1.9274116E38)
                org.rbmain.ui.Components.Bulletin r2 = r3.createSimpleBulletin(r4, r2)
                r2.show()
            L86:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.PhotoViewer.CaptionLinkMovementMethod.lambda$onLongClick$0(android.text.style.URLSpan, android.content.DialogInterface, int):void");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelFlashAnimations() {
        View view = this.flashView;
        if (view != null) {
            view.animate().setListener(null).cancel();
            this.flashView.setAlpha(0.0f);
        }
        AnimatorSet animatorSet = this.flashAnimator;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.flashAnimator = null;
        }
        PhotoCropView photoCropView = this.photoCropView;
        if (photoCropView != null) {
            photoCropView.cancelThumbAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelVideoPlayRunnable() {
        Runnable runnable = this.videoPlayRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
            this.videoPlayRunnable = null;
        }
    }

    /* renamed from: org.rbmain.ui.PhotoViewer$4, reason: invalid class name */
    class AnonymousClass4 implements Runnable {
        AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            float bufferedProgressFromPosition;
            if (PhotoViewer.this.videoPlayer != null) {
                if (PhotoViewer.this.isCurrentVideo) {
                    if (!PhotoViewer.this.videoTimelineView.isDragging()) {
                        float currentPosition = PhotoViewer.this.videoPlayer.getCurrentPosition() / PhotoViewer.this.videoPlayer.getDuration();
                        if (PhotoViewer.this.inPreview || (PhotoViewer.this.currentEditMode == 0 && PhotoViewer.this.videoTimelineView.getVisibility() != 0)) {
                            if (PhotoViewer.this.sendPhotoType != 1) {
                                PhotoViewer.this.videoTimelineView.setProgress(currentPosition);
                            }
                        } else if (currentPosition >= PhotoViewer.this.videoTimelineView.getRightProgress()) {
                            PhotoViewer.this.videoTimelineView.setProgress(PhotoViewer.this.videoTimelineView.getLeftProgress());
                            PhotoViewer.this.videoPlayer.seekTo((int) (PhotoViewer.this.videoTimelineView.getLeftProgress() * PhotoViewer.this.videoPlayer.getDuration()));
                            PhotoViewer.this.manuallyPaused = false;
                            PhotoViewer.this.cancelVideoPlayRunnable();
                            if (PhotoViewer.this.muteVideo || PhotoViewer.this.sendPhotoType == 1 || PhotoViewer.this.currentEditMode != 0 || PhotoViewer.this.switchingToMode > 0) {
                                PhotoViewer.this.videoPlayer.play();
                            } else {
                                PhotoViewer.this.videoPlayer.pause();
                            }
                            PhotoViewer.this.containerView.invalidate();
                        } else {
                            PhotoViewer.this.videoTimelineView.setProgress(currentPosition);
                        }
                        PhotoViewer.this.updateVideoPlayerTime();
                    }
                } else {
                    final float currentPosition2 = PhotoViewer.this.videoPlayer.getCurrentPosition() / PhotoViewer.this.videoPlayer.getDuration();
                    if (PhotoViewer.this.currentVideoFinishedLoading) {
                        bufferedProgressFromPosition = 1.0f;
                    } else {
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        if (Math.abs(jElapsedRealtime - PhotoViewer.this.lastBufferedPositionCheck) >= 500) {
                            if (PhotoViewer.this.isStreaming) {
                                bufferedProgressFromPosition = FileLoader.getInstance(PhotoViewer.this.currentAccount).getBufferedProgressFromPosition(PhotoViewer.this.seekToProgressPending != 0.0f ? PhotoViewer.this.seekToProgressPending : currentPosition2, PhotoViewer.this.currentFileNames[0]);
                            } else {
                                bufferedProgressFromPosition = 1.0f;
                            }
                            PhotoViewer.this.lastBufferedPositionCheck = jElapsedRealtime;
                        } else {
                            bufferedProgressFromPosition = -1.0f;
                        }
                    }
                    if (PhotoViewer.this.inPreview || PhotoViewer.this.videoTimelineView.getVisibility() != 0) {
                        if (PhotoViewer.this.seekToProgressPending == 0.0f && (PhotoViewer.this.rewindCount == 0 || !PhotoViewer.this.rewindByBackSeek)) {
                            PhotoViewer.this.videoPlayerSeekbar.setProgress(currentPosition2, false);
                        }
                        if (bufferedProgressFromPosition != -1.0f) {
                            PhotoViewer.this.videoPlayerSeekbar.setBufferedProgress(bufferedProgressFromPosition);
                            if (PhotoViewer.this.pipVideoView != null) {
                                PhotoViewer.this.pipVideoView.setBufferedProgress(bufferedProgressFromPosition);
                            }
                        }
                    } else if (currentPosition2 >= PhotoViewer.this.videoTimelineView.getRightProgress()) {
                        PhotoViewer.this.manuallyPaused = false;
                        PhotoViewer.this.videoPlayer.pause();
                        PhotoViewer.this.videoPlayerSeekbar.setProgress(0.0f);
                        PhotoViewer.this.videoPlayer.seekTo((int) (PhotoViewer.this.videoTimelineView.getLeftProgress() * PhotoViewer.this.videoPlayer.getDuration()));
                        PhotoViewer.this.containerView.invalidate();
                    } else {
                        float leftProgress = currentPosition2 - PhotoViewer.this.videoTimelineView.getLeftProgress();
                        if (leftProgress < 0.0f) {
                            leftProgress = 0.0f;
                        }
                        currentPosition2 = leftProgress / (PhotoViewer.this.videoTimelineView.getRightProgress() - PhotoViewer.this.videoTimelineView.getLeftProgress());
                        if (currentPosition2 > 1.0f) {
                            currentPosition2 = 1.0f;
                        }
                        PhotoViewer.this.videoPlayerSeekbar.setProgress(currentPosition2);
                    }
                    PhotoViewer.this.videoPlayerSeekbarView.invalidate();
                    if (PhotoViewer.this.shouldSavePositionForCurrentVideo != null && currentPosition2 >= 0.0f && SystemClock.elapsedRealtime() - PhotoViewer.this.lastSaveTime >= 1000) {
                        String unused = PhotoViewer.this.shouldSavePositionForCurrentVideo;
                        PhotoViewer.this.lastSaveTime = SystemClock.elapsedRealtime();
                        Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.ui.PhotoViewer$4$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$run$0(currentPosition2);
                            }
                        });
                    }
                    PhotoViewer.this.updateVideoPlayerTime();
                }
            }
            if (PhotoViewer.this.isPlaying) {
                AndroidUtilities.runOnUIThread(PhotoViewer.this.updateProgressRunnable, 17L);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$0(float f) {
            ApplicationLoader.applicationContext.getSharedPreferences("media_saved_pos", 0).edit().putFloat(PhotoViewer.this.shouldSavePositionForCurrentVideo, f).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1() {
        if (this.isVisible && this.animationInProgress == 0) {
            updateContainerFlags(this.isActionBarVisible);
        }
    }

    private static class EditState {
        public long averageDuration;
        public MediaController.CropState cropState;
        public ArrayList<VideoEditedInfo.MediaEntity> croppedMediaEntities;
        public String croppedPaintPath;
        public ArrayList<VideoEditedInfo.MediaEntity> mediaEntities;
        public String paintPath;
        public MediaController.SavedFilterState savedFilterState;

        private EditState() {
        }

        public void reset() {
            this.paintPath = null;
            this.cropState = null;
            this.savedFilterState = null;
            this.mediaEntities = null;
            this.croppedPaintPath = null;
            this.croppedMediaEntities = null;
            this.averageDuration = 0L;
        }
    }

    private class SavedState {
        private int index;
        private ArrayList<MessageObject> messages;
        private PhotoViewerProvider provider;

        public SavedState(int i, ArrayList<MessageObject> arrayList, PhotoViewerProvider photoViewerProvider) {
            this.messages = arrayList;
            this.index = i;
            this.provider = photoViewerProvider;
        }

        public void restore() throws IllegalAccessException, NoSuchFieldException, Resources.NotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException {
            PhotoViewer.this.placeProvider = this.provider;
            if (Build.VERSION.SDK_INT >= 21) {
                PhotoViewer.this.windowLayoutParams.flags = -2147286784;
            } else {
                PhotoViewer.this.windowLayoutParams.flags = MessagesController.UPDATE_MASK_REORDER;
            }
            PhotoViewer.this.windowLayoutParams.softInputMode = (PhotoViewer.this.useSmoothKeyboard ? 32 : 16) | 256;
            PhotoViewer.this.windowView.setFocusable(false);
            PhotoViewer.this.containerView.setFocusable(false);
            PhotoViewer.this.backgroundDrawable.setAlpha(255);
            PhotoViewer.this.containerView.setAlpha(1.0f);
            PhotoViewer photoViewer = PhotoViewer.this;
            ArrayList<MessageObject> arrayList = this.messages;
            int i = this.index;
            photoViewer.onPhotoShow(null, null, null, null, arrayList, null, null, i, this.provider.getPlaceForPhoto(arrayList.get(i), null, this.index, true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class BackgroundDrawable extends ColorDrawable {
        private boolean allowDrawContent;
        private Runnable drawRunnable;
        private final Paint paint;
        private final RectF rect;
        private final RectF visibleRect;

        public BackgroundDrawable(int i) {
            super(i);
            this.rect = new RectF();
            this.visibleRect = new RectF();
            Paint paint = new Paint(1);
            this.paint = paint;
            paint.setColor(i);
        }

        @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
        @Keep
        public void setAlpha(int i) {
            if (PhotoViewer.this.parentActivity instanceof LaunchActivity) {
                this.allowDrawContent = (PhotoViewer.this.isVisible && i == 255) ? false : true;
                ((LaunchActivity) PhotoViewer.this.parentActivity).drawerLayoutContainer.setAllowDrawContent(this.allowDrawContent);
                if (PhotoViewer.this.parentAlert != null) {
                    if (this.allowDrawContent) {
                        PhotoViewer.this.parentAlert.setAllowDrawContent(true);
                    } else {
                        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.PhotoViewer$BackgroundDrawable$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$setAlpha$0();
                            }
                        }, 50L);
                    }
                }
            }
            super.setAlpha(i);
            this.paint.setAlpha(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setAlpha$0() {
            if (PhotoViewer.this.parentAlert != null) {
                PhotoViewer.this.parentAlert.setAllowDrawContent(this.allowDrawContent);
            }
        }

        @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            Runnable runnable;
            if (PhotoViewer.this.animationInProgress != 0 && !AndroidUtilities.isTablet() && PhotoViewer.this.currentPlaceObject != null && PhotoViewer.this.currentPlaceObject.animatingImageView != null) {
                PhotoViewer.this.animatingImageView.getClippedVisibleRect(this.visibleRect);
                if (!this.visibleRect.isEmpty()) {
                    this.visibleRect.inset(AndroidUtilities.dp(1.0f), AndroidUtilities.dp(1.0f));
                    Rect bounds = getBounds();
                    float f = bounds.right;
                    float f2 = bounds.bottom;
                    for (int i = 0; i < 4; i++) {
                        if (i == 0) {
                            RectF rectF = this.rect;
                            RectF rectF2 = this.visibleRect;
                            rectF.set(0.0f, rectF2.top, rectF2.left, rectF2.bottom);
                        } else if (i == 1) {
                            this.rect.set(0.0f, 0.0f, f, this.visibleRect.top);
                        } else if (i == 2) {
                            RectF rectF3 = this.rect;
                            RectF rectF4 = this.visibleRect;
                            rectF3.set(rectF4.right, rectF4.top, f, rectF4.bottom);
                        } else if (i == 3) {
                            this.rect.set(0.0f, this.visibleRect.bottom, f, f2);
                        }
                        canvas.drawRect(this.rect, this.paint);
                    }
                }
            } else {
                super.draw(canvas);
            }
            if (getAlpha() == 0 || (runnable = this.drawRunnable) == null) {
                return;
            }
            AndroidUtilities.runOnUIThread(runnable);
            this.drawRunnable = null;
        }
    }

    private static class SelectedPhotosListView extends RecyclerListView {
        private Drawable arrowDrawable;
        private Paint paint;
        private RectF rect;

        public SelectedPhotosListView(Context context) {
            super(context);
            this.paint = new Paint(1);
            this.rect = new RectF();
            setWillNotDraw(false);
            setClipToPadding(false);
            setTranslationY(-AndroidUtilities.dp(10.0f));
            DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator() { // from class: org.rbmain.ui.PhotoViewer.SelectedPhotosListView.1
                @Override // androidx.recyclerview.widget.DefaultItemAnimator
                protected void onMoveAnimationUpdate(RecyclerView.ViewHolder viewHolder) {
                    SelectedPhotosListView.this.invalidate();
                }
            };
            setItemAnimator(defaultItemAnimator);
            defaultItemAnimator.setDelayAnimations(false);
            defaultItemAnimator.setSupportsChangeAnimations(false);
            setPadding(AndroidUtilities.dp(12.0f), AndroidUtilities.dp(12.0f), AndroidUtilities.dp(12.0f), AndroidUtilities.dp(6.0f));
            this.paint.setColor(2130706432);
            this.arrowDrawable = context.getResources().getDrawable(R.drawable.photo_tooltip2).mutate();
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            int childCount = getChildCount();
            if (childCount > 0) {
                int measuredWidth = getMeasuredWidth() - AndroidUtilities.dp(87.0f);
                Drawable drawable = this.arrowDrawable;
                drawable.setBounds(measuredWidth, 0, drawable.getIntrinsicWidth() + measuredWidth, AndroidUtilities.dp(6.0f));
                this.arrowDrawable.draw(canvas);
                int iMin = ConnectionsManager.DEFAULT_DATACENTER_ID;
                int iMax = Integer.MIN_VALUE;
                for (int i = 0; i < childCount; i++) {
                    View childAt = getChildAt(i);
                    iMin = (int) Math.min(iMin, Math.floor(childAt.getX()));
                    iMax = (int) Math.max(iMax, Math.ceil(childAt.getX() + childAt.getMeasuredWidth()));
                }
                if (iMin == Integer.MAX_VALUE || iMax == Integer.MIN_VALUE) {
                    return;
                }
                this.rect.set(iMin - AndroidUtilities.dp(6.0f), AndroidUtilities.dp(6.0f), iMax + AndroidUtilities.dp(6.0f), AndroidUtilities.dp(103.0f));
                canvas.drawRoundRect(this.rect, AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), this.paint);
            }
        }
    }

    private static class CounterView extends View {
        private int currentCount;
        private int height;
        private Paint paint;
        private RectF rect;
        private float rotation;
        private StaticLayout staticLayout;
        private TextPaint textPaint;
        private int width;

        public CounterView(Context context) {
            super(context);
            this.currentCount = 0;
            TextPaint textPaint = new TextPaint(1);
            this.textPaint = textPaint;
            textPaint.setTextSize(AndroidUtilities.dp(15.0f));
            this.textPaint.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
            this.textPaint.setColor(-1);
            Paint paint = new Paint(1);
            this.paint = paint;
            paint.setColor(-1);
            this.paint.setStrokeWidth(AndroidUtilities.dp(2.0f));
            this.paint.setStyle(Paint.Style.STROKE);
            this.paint.setStrokeJoin(Paint.Join.ROUND);
            this.rect = new RectF();
            setCount(0);
        }

        @Override // android.view.View
        @Keep
        public void setScaleX(float f) {
            super.setScaleX(f);
            invalidate();
        }

        @Override // android.view.View
        @Keep
        public void setRotationX(float f) {
            this.rotation = f;
            invalidate();
        }

        @Override // android.view.View
        public float getRotationX() {
            return this.rotation;
        }

        public void setCount(int i) {
            StaticLayout staticLayout = new StaticLayout(BuildConfig.FLAVOR + Math.max(1, i), this.textPaint, AndroidUtilities.dp(100.0f), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            this.staticLayout = staticLayout;
            this.width = (int) Math.ceil((double) staticLayout.getLineWidth(0));
            this.height = this.staticLayout.getLineBottom(0);
            AnimatorSet animatorSet = new AnimatorSet();
            if (i == 0) {
                Paint paint = this.paint;
                Property<Paint, Integer> property = AnimationProperties.PAINT_ALPHA;
                animatorSet.playTogether(ObjectAnimator.ofFloat(this, (Property<CounterView, Float>) View.SCALE_X, 0.0f), ObjectAnimator.ofFloat(this, (Property<CounterView, Float>) View.SCALE_Y, 0.0f), ObjectAnimator.ofInt(paint, property, 0), ObjectAnimator.ofInt(this.textPaint, (Property<TextPaint, Integer>) property, 0));
                animatorSet.setInterpolator(new DecelerateInterpolator());
            } else {
                int i2 = this.currentCount;
                if (i2 == 0) {
                    Paint paint2 = this.paint;
                    Property<Paint, Integer> property2 = AnimationProperties.PAINT_ALPHA;
                    animatorSet.playTogether(ObjectAnimator.ofFloat(this, (Property<CounterView, Float>) View.SCALE_X, 0.0f, 1.0f), ObjectAnimator.ofFloat(this, (Property<CounterView, Float>) View.SCALE_Y, 0.0f, 1.0f), ObjectAnimator.ofInt(paint2, property2, 0, 255), ObjectAnimator.ofInt(this.textPaint, (Property<TextPaint, Integer>) property2, 0, 255));
                    animatorSet.setInterpolator(new DecelerateInterpolator());
                } else if (i < i2) {
                    animatorSet.playTogether(ObjectAnimator.ofFloat(this, (Property<CounterView, Float>) View.SCALE_X, 1.1f, 1.0f), ObjectAnimator.ofFloat(this, (Property<CounterView, Float>) View.SCALE_Y, 1.1f, 1.0f));
                    animatorSet.setInterpolator(new OvershootInterpolator());
                } else {
                    animatorSet.playTogether(ObjectAnimator.ofFloat(this, (Property<CounterView, Float>) View.SCALE_X, 0.9f, 1.0f), ObjectAnimator.ofFloat(this, (Property<CounterView, Float>) View.SCALE_Y, 0.9f, 1.0f));
                    animatorSet.setInterpolator(new OvershootInterpolator());
                }
            }
            animatorSet.setDuration(180L);
            animatorSet.start();
            requestLayout();
            this.currentCount = i;
        }

        @Override // android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.max(this.width + AndroidUtilities.dp(20.0f), AndroidUtilities.dp(30.0f)), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(40.0f), 1073741824));
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            int measuredHeight = getMeasuredHeight() / 2;
            this.paint.setAlpha(255);
            this.rect.set(AndroidUtilities.dp(1.0f), measuredHeight - AndroidUtilities.dp(14.0f), getMeasuredWidth() - AndroidUtilities.dp(1.0f), measuredHeight + AndroidUtilities.dp(14.0f));
            canvas.drawRoundRect(this.rect, AndroidUtilities.dp(15.0f), AndroidUtilities.dp(15.0f), this.paint);
            if (this.staticLayout != null) {
                this.textPaint.setAlpha((int) ((1.0f - this.rotation) * 255.0f));
                canvas.save();
                canvas.translate((getMeasuredWidth() - this.width) / 2, ((getMeasuredHeight() - this.height) / 2) + AndroidUtilities.dpf2(0.2f) + (this.rotation * AndroidUtilities.dp(5.0f)));
                this.staticLayout.draw(canvas);
                canvas.restore();
                this.paint.setAlpha((int) (this.rotation * 255.0f));
                int iCenterX = (int) this.rect.centerX();
                int iCenterY = (int) (((int) this.rect.centerY()) - (AndroidUtilities.dp(5.0f) * (1.0f - this.rotation)));
                canvas.drawLine(AndroidUtilities.dp(5.0f) + iCenterX, iCenterY - AndroidUtilities.dp(5.0f), iCenterX - AndroidUtilities.dp(5.0f), AndroidUtilities.dp(5.0f) + iCenterY, this.paint);
                canvas.drawLine(iCenterX - AndroidUtilities.dp(5.0f), iCenterY - AndroidUtilities.dp(5.0f), iCenterX + AndroidUtilities.dp(5.0f), iCenterY + AndroidUtilities.dp(5.0f), this.paint);
            }
        }
    }

    private class PhotoProgressView {
        private View parent;
        private final CombinedDrawable playDrawable;
        private final PlayPauseDrawable playPauseDrawable;
        private boolean visible;
        private long lastUpdateTime = 0;
        private float radOffset = 0.0f;
        private float currentProgress = 0.0f;
        private float animationProgressStart = 0.0f;
        private long currentProgressTime = 0;
        private float animatedProgressValue = 0.0f;
        private RectF progressRect = new RectF();
        private int backgroundState = -1;
        private int size = AndroidUtilities.dp(64.0f);
        private int previousBackgroundState = -2;
        private float animatedAlphaValue = 1.0f;
        private float[] animAlphas = new float[3];
        private float[] alphas = new float[3];
        private float scale = 1.0f;

        protected void onBackgroundStateUpdated(int i) {
            throw null;
        }

        protected void onVisibilityChanged(boolean z) {
            throw null;
        }

        public PhotoProgressView(View view) {
            if (PhotoViewer.decelerateInterpolator == null) {
                DecelerateInterpolator unused = PhotoViewer.decelerateInterpolator = new DecelerateInterpolator(1.5f);
                Paint unused2 = PhotoViewer.progressPaint = new Paint(1);
                PhotoViewer.progressPaint.setStyle(Paint.Style.STROKE);
                PhotoViewer.progressPaint.setStrokeCap(Paint.Cap.ROUND);
                PhotoViewer.progressPaint.setStrokeWidth(AndroidUtilities.dp(3.0f));
                PhotoViewer.progressPaint.setColor(-1);
            }
            this.parent = view;
            resetAlphas();
            PlayPauseDrawable playPauseDrawable = new PlayPauseDrawable(28);
            this.playPauseDrawable = playPauseDrawable;
            playPauseDrawable.setDuration(200);
            this.playDrawable = new CombinedDrawable(ContextCompat.getDrawable(PhotoViewer.this.parentActivity, R.drawable.circle_big).mutate(), playPauseDrawable);
        }

        private void updateAnimation(boolean z) {
            boolean z2;
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = jCurrentTimeMillis - this.lastUpdateTime;
            if (j > 18) {
                j = 18;
            }
            this.lastUpdateTime = jCurrentTimeMillis;
            int i = 0;
            if (z) {
                if (this.animatedProgressValue == 1.0f && this.currentProgress == 1.0f) {
                    z2 = false;
                } else {
                    this.radOffset += (360 * j) / 3000.0f;
                    float f = this.currentProgress - this.animationProgressStart;
                    if (Math.abs(f) > 0.0f) {
                        long j2 = this.currentProgressTime + j;
                        this.currentProgressTime = j2;
                        if (j2 < 300) {
                            this.animatedProgressValue = this.animationProgressStart + (f * PhotoViewer.decelerateInterpolator.getInterpolation(this.currentProgressTime / 300.0f));
                        } else {
                            float f2 = this.currentProgress;
                            this.animatedProgressValue = f2;
                            this.animationProgressStart = f2;
                            this.currentProgressTime = 0L;
                        }
                    }
                    z2 = true;
                }
                float f3 = this.animatedAlphaValue;
                if (f3 > 0.0f && this.previousBackgroundState != -2) {
                    float f4 = f3 - (j / 200.0f);
                    this.animatedAlphaValue = f4;
                    if (f4 <= 0.0f) {
                        this.animatedAlphaValue = 0.0f;
                        this.previousBackgroundState = -2;
                    }
                    z2 = true;
                }
            } else {
                z2 = false;
            }
            while (true) {
                float[] fArr = this.alphas;
                if (i >= fArr.length) {
                    break;
                }
                float f5 = fArr[i];
                float[] fArr2 = this.animAlphas;
                if (f5 > fArr2[i]) {
                    fArr2[i] = Math.min(1.0f, fArr2[i] + (j / 200.0f));
                } else if (fArr[i] < fArr2[i]) {
                    fArr2[i] = Math.max(0.0f, fArr2[i] - (j / 200.0f));
                } else {
                    i++;
                }
                z2 = true;
                i++;
            }
            if (z2) {
                this.parent.postInvalidateOnAnimation();
            }
        }

        public void setProgress(float f, boolean z) {
            if (!z) {
                this.animatedProgressValue = f;
                this.animationProgressStart = f;
            } else {
                this.animationProgressStart = this.animatedProgressValue;
            }
            this.currentProgress = f;
            this.currentProgressTime = 0L;
            this.parent.invalidate();
        }

        public void setBackgroundState(int i, boolean z, boolean z2) {
            int i2;
            int i3 = this.backgroundState;
            if (i3 == i) {
                return;
            }
            PlayPauseDrawable playPauseDrawable = this.playPauseDrawable;
            if (playPauseDrawable != null) {
                boolean z3 = z2 && (i3 == 3 || i3 == 4);
                if (i == 3) {
                    playPauseDrawable.setPause(false, z3);
                } else if (i == 4) {
                    playPauseDrawable.setPause(true, z3);
                }
                this.playPauseDrawable.setParent(this.parent);
                this.playPauseDrawable.invalidateSelf();
            }
            this.lastUpdateTime = System.currentTimeMillis();
            if (z && (i2 = this.backgroundState) != i) {
                this.previousBackgroundState = i2;
                this.animatedAlphaValue = 1.0f;
            } else {
                this.previousBackgroundState = -2;
            }
            this.backgroundState = i;
            onBackgroundStateUpdated(i);
            this.parent.invalidate();
        }

        public void setAlpha(float f) {
            setIndexedAlpha(0, f, false);
        }

        public void setScale(float f) {
            this.scale = f;
        }

        public void setIndexedAlpha(int i, float f, boolean z) {
            float[] fArr = this.alphas;
            if (fArr[i] != f) {
                fArr[i] = f;
                if (!z) {
                    this.animAlphas[i] = f;
                }
                checkVisibility();
                this.parent.invalidate();
            }
        }

        public void resetAlphas() {
            int i = 0;
            while (true) {
                float[] fArr = this.alphas;
                if (i < fArr.length) {
                    this.animAlphas[i] = 1.0f;
                    fArr[i] = 1.0f;
                    i++;
                } else {
                    checkVisibility();
                    return;
                }
            }
        }

        private float calculateAlpha() {
            float interpolation;
            float f = 1.0f;
            int i = 0;
            while (true) {
                float[] fArr = this.animAlphas;
                if (i >= fArr.length) {
                    return f;
                }
                if (i == 2) {
                    interpolation = AndroidUtilities.accelerateInterpolator.getInterpolation(fArr[i]);
                } else {
                    interpolation = fArr[i];
                }
                f *= interpolation;
                i++;
            }
        }

        private void checkVisibility() {
            boolean z = false;
            int i = 0;
            while (true) {
                float[] fArr = this.alphas;
                if (i >= fArr.length) {
                    z = true;
                    break;
                } else if (fArr[i] != 1.0f) {
                    break;
                } else {
                    i++;
                }
            }
            if (z != this.visible) {
                this.visible = z;
                onVisibilityChanged(z);
            }
        }

        public boolean isVisible() {
            return this.visible;
        }

        public int getX() {
            return (PhotoViewer.this.containerView.getWidth() - ((int) (this.size * this.scale))) / 2;
        }

        public int getY() {
            int i = (int) ((((AndroidUtilities.displaySize.y + (PhotoViewer.this.isStatusBarVisible() ? AndroidUtilities.statusBarHeight : 0)) - ((int) (this.size * this.scale))) / 2) + PhotoViewer.this.currentPanTranslationY);
            return PhotoViewer.this.sendPhotoType == 1 ? i - AndroidUtilities.dp(38.0f) : i;
        }

        public void onDraw(Canvas canvas) {
            int i;
            Drawable drawable;
            Drawable drawable2;
            int i2 = (int) (this.size * this.scale);
            int x = getX();
            int y = getY();
            float fCalculateAlpha = calculateAlpha();
            int i3 = this.previousBackgroundState;
            if (i3 >= 0 && i3 < PhotoViewer.progressDrawables.length + 2) {
                if (this.previousBackgroundState < PhotoViewer.progressDrawables.length) {
                    drawable2 = PhotoViewer.progressDrawables[this.previousBackgroundState];
                } else {
                    drawable2 = this.playDrawable;
                }
                if (drawable2 != null) {
                    drawable2.setAlpha((int) (this.animatedAlphaValue * 255.0f * fCalculateAlpha));
                    drawable2.setBounds(x, y, x + i2, y + i2);
                    drawable2.draw(canvas);
                }
            }
            int i4 = this.backgroundState;
            if (i4 >= 0 && i4 < PhotoViewer.progressDrawables.length + 2) {
                if (this.backgroundState < PhotoViewer.progressDrawables.length) {
                    drawable = PhotoViewer.progressDrawables[this.backgroundState];
                } else {
                    drawable = this.playDrawable;
                }
                if (drawable != null) {
                    if (this.previousBackgroundState != -2) {
                        drawable.setAlpha((int) ((1.0f - this.animatedAlphaValue) * 255.0f * fCalculateAlpha));
                    } else {
                        drawable.setAlpha((int) (fCalculateAlpha * 255.0f));
                    }
                    drawable.setBounds(x, y, x + i2, y + i2);
                    drawable.draw(canvas);
                }
            }
            int i5 = this.backgroundState;
            if (i5 == 0 || i5 == 1 || (i = this.previousBackgroundState) == 0 || i == 1) {
                int iDp = AndroidUtilities.dp(4.0f);
                if (this.previousBackgroundState != -2) {
                    PhotoViewer.progressPaint.setAlpha((int) (this.animatedAlphaValue * 255.0f * fCalculateAlpha));
                } else {
                    PhotoViewer.progressPaint.setAlpha((int) (fCalculateAlpha * 255.0f));
                }
                this.progressRect.set(x + iDp, y + iDp, (x + i2) - iDp, (y + i2) - iDp);
                canvas.drawArc(this.progressRect, this.radOffset - 90.0f, Math.max(4.0f, this.animatedProgressValue * 360.0f), false, PhotoViewer.progressPaint);
                updateAnimation(true);
                return;
            }
            updateAnimation(false);
        }
    }

    private class FrameLayoutDrawer extends SizeNotifierFrameLayoutPhoto {
        AdjustPanLayoutHelper adjustPanLayoutHelper;
        private boolean captionAbove;
        private boolean ignoreLayout;
        private Paint paint;

        public FrameLayoutDrawer(Context context) {
            super(context, false);
            this.paint = new Paint();
            this.adjustPanLayoutHelper = new AdjustPanLayoutHelper(this) { // from class: org.rbmain.ui.PhotoViewer.FrameLayoutDrawer.1
                @Override // org.rbmain.ui.ActionBar.AdjustPanLayoutHelper
                protected void onPanTranslationUpdate(float f, float f2, boolean z) {
                    PhotoViewer.this.currentPanTranslationY = f;
                    if (PhotoViewer.this.currentEditMode != 3) {
                        PhotoViewer.this.actionBar.setTranslationY(f);
                    }
                    if (PhotoViewer.this.miniProgressView != null) {
                        PhotoViewer.this.miniProgressView.setTranslationY(f);
                    }
                    if (PhotoViewer.this.progressView != null) {
                        PhotoViewer.this.progressView.setTranslationY(f);
                    }
                    if (PhotoViewer.this.checkImageView != null) {
                        PhotoViewer.this.checkImageView.setTranslationY(f);
                    }
                    if (PhotoViewer.this.photosCounterView != null) {
                        PhotoViewer.this.photosCounterView.setTranslationY(f);
                    }
                    if (PhotoViewer.this.selectedPhotosListView != null) {
                        PhotoViewer.this.selectedPhotosListView.setTranslationY(f);
                    }
                    if (PhotoViewer.this.aspectRatioFrameLayout != null) {
                        PhotoViewer.this.aspectRatioFrameLayout.setTranslationY(f);
                    }
                    if (PhotoViewer.this.textureImageView != null) {
                        PhotoViewer.this.textureImageView.setTranslationY(f);
                    }
                    if (PhotoViewer.this.photoCropView != null) {
                        PhotoViewer.this.photoCropView.setTranslationY(f);
                    }
                    if (PhotoViewer.this.photoFilterView != null) {
                        PhotoViewer.this.photoFilterView.setTranslationY(f);
                    }
                    if (PhotoViewer.this.pickerView != null) {
                        PhotoViewer.this.pickerView.setTranslationY(f);
                    }
                    if (PhotoViewer.this.pickerViewSendButton != null) {
                        PhotoViewer.this.pickerViewSendButton.setTranslationY(f);
                    }
                    if (PhotoViewer.this.currentEditMode == 3) {
                        if (PhotoViewer.this.captionEditText != null) {
                            PhotoViewer.this.captionEditText.setTranslationY(f);
                        }
                        if (PhotoViewer.this.photoPaintView != null) {
                            PhotoViewer.this.photoPaintView.setTranslationY(0.0f);
                            PhotoViewer.this.photoPaintView.getColorPicker().setTranslationY(f);
                            PhotoViewer.this.photoPaintView.getToolsView().setTranslationY(f);
                            PhotoViewer.this.photoPaintView.getCurtainView().setTranslationY(f);
                        }
                    } else {
                        if (PhotoViewer.this.photoPaintView != null) {
                            PhotoViewer.this.photoPaintView.setTranslationY(f);
                        }
                        if (PhotoViewer.this.captionEditText != null) {
                            PhotoViewer.this.captionEditText.setAlpha(f2 >= 0.5f ? (f2 - 0.5f) / 0.5f : 0.0f);
                            PhotoViewer.this.captionEditText.setTranslationY((f - this.keyboardSize) + (AndroidUtilities.dp(r0 / 2.0f) * (1.0f - f2)));
                        }
                    }
                    if (PhotoViewer.this.muteItem != null) {
                        PhotoViewer.this.muteItem.setTranslationY(f);
                    }
                    if (PhotoViewer.this.cameraItem != null) {
                        PhotoViewer.this.cameraItem.setTranslationY(f);
                    }
                    if (PhotoViewer.this.captionLimitView != null) {
                        PhotoViewer.this.captionLimitView.setTranslationY(f);
                    }
                    FrameLayoutDrawer.this.invalidate();
                }

                @Override // org.rbmain.ui.ActionBar.AdjustPanLayoutHelper
                protected void onTransitionStart(boolean z, int i) {
                    int i2;
                    String str;
                    PhotoViewer.this.windowView.setClipChildren(false);
                    if (PhotoViewer.this.captionEditText.getTag() == null || !z) {
                        PhotoViewer.this.checkImageView.animate().alpha(1.0f).setDuration(220L).start();
                        PhotoViewer.this.photosCounterView.animate().alpha(1.0f).setDuration(220L).start();
                        if (PhotoViewer.this.lastTitle == null || PhotoViewer.this.isCurrentVideo) {
                            return;
                        }
                        PhotoViewer.this.actionBar.setTitleAnimated(PhotoViewer.this.lastTitle, false, 220L);
                        PhotoViewer.this.lastTitle = null;
                        return;
                    }
                    if (PhotoViewer.this.isCurrentVideo) {
                        if (PhotoViewer.this.muteVideo) {
                            i2 = R.string.GifCaption;
                            str = "GifCaption";
                        } else {
                            i2 = R.string.VideoCaption;
                            str = "VideoCaption";
                        }
                        PhotoViewer.this.actionBar.setTitleAnimated(LocaleController.getString(str, i2), true, 220L);
                    } else {
                        PhotoViewer.this.actionBar.setTitleAnimated(LocaleController.getString("PhotoCaption", R.string.PhotoCaption), true, 220L);
                    }
                    PhotoViewer.this.captionEditText.setAlpha(0.0f);
                    PhotoViewer.this.checkImageView.animate().alpha(0.0f).setDuration(220L).start();
                    PhotoViewer.this.photosCounterView.animate().alpha(0.0f).setDuration(220L).start();
                    PhotoViewer.this.selectedPhotosListView.animate().alpha(0.0f).translationY(-AndroidUtilities.dp(10.0f)).setDuration(220L).start();
                }

                @Override // org.rbmain.ui.ActionBar.AdjustPanLayoutHelper
                protected void onTransitionEnd() {
                    super.onTransitionEnd();
                    PhotoViewer.this.windowView.setClipChildren(true);
                    if (PhotoViewer.this.captionEditText.getTag() == null) {
                        PhotoViewer.this.captionEditText.setVisibility(8);
                    }
                    PhotoViewer.this.captionEditText.setTranslationY(0.0f);
                }

                @Override // org.rbmain.ui.ActionBar.AdjustPanLayoutHelper
                protected boolean heightAnimationEnabled() {
                    return !PhotoViewer.this.captionEditText.isPopupShowing();
                }
            };
            setWillNotDraw(false);
            setClipChildren(false);
            setClipToPadding(false);
            this.paint.setColor(855638016);
        }

        /* JADX WARN: Removed duplicated region for block: B:95:0x029c  */
        /* JADX WARN: Removed duplicated region for block: B:96:0x029f  */
        @Override // android.widget.FrameLayout, android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected void onMeasure(int r19, int r20) {
            /*
                Method dump skipped, instructions count: 730
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.PhotoViewer.FrameLayoutDrawer.onMeasure(int, int):void");
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x008f  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x009d  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00b1  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00be  */
        @Override // org.rbmain.ui.Components.SizeNotifierFrameLayoutPhoto, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected void onLayout(boolean r16, int r17, int r18, int r19, int r20) {
            /*
                Method dump skipped, instructions count: 437
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.PhotoViewer.FrameLayoutDrawer.onLayout(boolean, int, int, int, int):void");
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            PhotoViewer.this.onDraw(canvas);
            if (!PhotoViewer.this.isStatusBarVisible() || AndroidUtilities.statusBarHeight == 0 || PhotoViewer.this.actionBar == null) {
                return;
            }
            this.paint.setAlpha((int) (PhotoViewer.this.actionBar.getAlpha() * 255.0f * 0.2f));
            canvas.drawRect(0.0f, PhotoViewer.this.currentPanTranslationY, getMeasuredWidth(), PhotoViewer.this.currentPanTranslationY + AndroidUtilities.statusBarHeight, this.paint);
            this.paint.setAlpha((int) (PhotoViewer.this.actionBar.getAlpha() * 255.0f * 0.498f));
            if (getPaddingRight() > 0) {
                canvas.drawRect(getMeasuredWidth() - getPaddingRight(), 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.paint);
            }
            if (getPaddingLeft() > 0) {
                canvas.drawRect(0.0f, 0.0f, getPaddingLeft(), getMeasuredHeight(), this.paint);
            }
        }

        @Override // android.view.ViewGroup
        protected boolean drawChild(Canvas canvas, View view, long j) {
            if (view == PhotoViewer.this.mentionListView || view == PhotoViewer.this.captionEditText) {
                if (PhotoViewer.this.currentEditMode != 0 && PhotoViewer.this.currentPanTranslationY == 0.0f) {
                    return false;
                }
                if (AndroidUtilities.isInMultiwindow || AndroidUtilities.usingHardwareInput) {
                    if (!PhotoViewer.this.captionEditText.isPopupShowing() && PhotoViewer.this.captionEditText.getEmojiPadding() == 0 && PhotoViewer.this.captionEditText.getTag() == null) {
                        return false;
                    }
                } else if (!PhotoViewer.this.captionEditText.isPopupShowing() && PhotoViewer.this.captionEditText.getEmojiPadding() == 0 && getKeyboardHeight() == 0 && PhotoViewer.this.currentPanTranslationY == 0.0f) {
                    return false;
                }
                if (view == PhotoViewer.this.mentionListView) {
                    canvas.save();
                    canvas.clipRect(view.getX(), view.getY(), view.getX() + view.getWidth(), view.getY() + view.getHeight());
                    boolean zDrawChild = super.drawChild(canvas, view, j);
                    canvas.restore();
                    return zDrawChild;
                }
            } else if (view == PhotoViewer.this.cameraItem || view == PhotoViewer.this.muteItem || view == PhotoViewer.this.pickerView || view == PhotoViewer.this.videoTimelineView || view == PhotoViewer.this.pickerViewSendButton || view == PhotoViewer.this.captionLimitView || view == PhotoViewer.this.captionTextViewSwitcher || (PhotoViewer.this.muteItem.getVisibility() == 0 && view == PhotoViewer.this.bottomLayout)) {
                if (PhotoViewer.this.captionEditText.isPopupAnimatig()) {
                    view.setTranslationY(PhotoViewer.this.captionEditText.getEmojiPadding());
                    PhotoViewer.this.bottomTouchEnabled = false;
                } else {
                    int emojiPadding = (getKeyboardHeight() > AndroidUtilities.dp(20.0f) || AndroidUtilities.isInMultiwindow) ? 0 : PhotoViewer.this.captionEditText.getEmojiPadding();
                    if (PhotoViewer.this.captionEditText.isPopupShowing() || (((AndroidUtilities.isInMultiwindow || AndroidUtilities.usingHardwareInput) && PhotoViewer.this.captionEditText.getTag() != null) || getKeyboardHeight() > AndroidUtilities.dp(80.0f) || emojiPadding != 0)) {
                        PhotoViewer.this.bottomTouchEnabled = false;
                        return false;
                    }
                    PhotoViewer.this.bottomTouchEnabled = true;
                }
            } else if (view == PhotoViewer.this.checkImageView || view == PhotoViewer.this.photosCounterView) {
                if (PhotoViewer.this.captionEditText.getTag() != null) {
                    PhotoViewer.this.bottomTouchEnabled = false;
                    return view.getAlpha() > 0.0f;
                }
                PhotoViewer.this.bottomTouchEnabled = true;
            } else if (view == PhotoViewer.this.miniProgressView) {
                return false;
            }
            try {
                if (view != PhotoViewer.this.aspectRatioFrameLayout && view != PhotoViewer.this.paintingOverlay) {
                    if (super.drawChild(canvas, view, j)) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable unused) {
                return true;
            }
        }

        @Override // android.view.View, android.view.ViewParent
        public void requestLayout() {
            if (this.ignoreLayout) {
                return;
            }
            super.requestLayout();
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            this.adjustPanLayoutHelper.setResizableView(PhotoViewer.this.windowView);
            this.adjustPanLayoutHelper.onAttach();
            Bulletin.addDelegate(this, new Bulletin.Delegate() { // from class: org.rbmain.ui.PhotoViewer.FrameLayoutDrawer.2
                @Override // org.rbmain.ui.Components.Bulletin.Delegate
                public /* synthetic */ boolean allowLayoutChanges() {
                    return Bulletin.Delegate.CC.$default$allowLayoutChanges(this);
                }

                @Override // org.rbmain.ui.Components.Bulletin.Delegate
                public /* synthetic */ int getTopOffset(int i) {
                    return Bulletin.Delegate.CC.$default$getTopOffset(this, i);
                }

                @Override // org.rbmain.ui.Components.Bulletin.Delegate
                public /* synthetic */ void onBottomOffsetChange(float f) {
                    Bulletin.Delegate.CC.$default$onBottomOffsetChange(this, f);
                }

                @Override // org.rbmain.ui.Components.Bulletin.Delegate
                public /* synthetic */ void onHide(Bulletin bulletin) {
                    Bulletin.Delegate.CC.$default$onHide(this, bulletin);
                }

                @Override // org.rbmain.ui.Components.Bulletin.Delegate
                public /* synthetic */ void onShow(Bulletin bulletin) {
                    Bulletin.Delegate.CC.$default$onShow(this, bulletin);
                }

                @Override // org.rbmain.ui.Components.Bulletin.Delegate
                public int getBottomOffset(int i) {
                    int height = 0;
                    if (PhotoViewer.this.bottomLayout != null && PhotoViewer.this.bottomLayout.getVisibility() == 0) {
                        height = 0 + PhotoViewer.this.bottomLayout.getHeight();
                    }
                    return (PhotoViewer.this.groupedPhotosListView == null || !PhotoViewer.this.groupedPhotosListView.hasPhotos()) ? height : (AndroidUtilities.isTablet() || PhotoViewer.this.containerView.getMeasuredHeight() > PhotoViewer.this.containerView.getMeasuredWidth()) ? height + PhotoViewer.this.groupedPhotosListView.getHeight() : height;
                }
            });
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            this.adjustPanLayoutHelper.onDetach();
            Bulletin.removeDelegate(this);
        }

        @Override // org.rbmain.ui.Components.SizeNotifierFrameLayoutPhoto
        public void notifyHeightChanged() {
            super.notifyHeightChanged();
            if (PhotoViewer.this.isCurrentVideo) {
                PhotoViewer.this.photoProgressViews[0].setIndexedAlpha(2, getKeyboardHeight() <= AndroidUtilities.dp(20.0f) ? 1.0f : 0.0f, true);
            }
        }
    }

    static {
        String str = "progress";
        if (Build.VERSION.SDK_INT >= 24) {
            VPC_PROGRESS = new FloatProperty<VideoPlayerControlFrameLayout>(str) { // from class: org.rbmain.ui.PhotoViewer.7
                @Override // android.util.FloatProperty
                public void setValue(VideoPlayerControlFrameLayout videoPlayerControlFrameLayout, float f) {
                    videoPlayerControlFrameLayout.setProgress(f);
                }

                @Override // android.util.Property
                public Float get(VideoPlayerControlFrameLayout videoPlayerControlFrameLayout) {
                    return Float.valueOf(videoPlayerControlFrameLayout.getProgress());
                }
            };
        } else {
            VPC_PROGRESS = new Property<VideoPlayerControlFrameLayout, Float>(Float.class, str) { // from class: org.rbmain.ui.PhotoViewer.8
                @Override // android.util.Property
                public void set(VideoPlayerControlFrameLayout videoPlayerControlFrameLayout, Float f) {
                    videoPlayerControlFrameLayout.setProgress(f.floatValue());
                }

                @Override // android.util.Property
                public Float get(VideoPlayerControlFrameLayout videoPlayerControlFrameLayout) {
                    return Float.valueOf(videoPlayerControlFrameLayout.getProgress());
                }
            };
        }
        Instance = null;
        PipInstance = null;
    }

    private class VideoPlayerControlFrameLayout extends FrameLayout {
        private boolean ignoreLayout;
        private int parentHeight;
        private int parentWidth;
        private float progress;
        private boolean seekBarTransitionEnabled;
        private boolean translationYAnimationEnabled;

        public VideoPlayerControlFrameLayout(Context context) {
            super(context);
            this.progress = 1.0f;
            this.translationYAnimationEnabled = true;
            setWillNotDraw(false);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (this.progress < 1.0f) {
                return false;
            }
            if (PhotoViewer.this.videoPlayerSeekbar.onTouch(motionEvent.getAction(), motionEvent.getX() - AndroidUtilities.dp(2.0f), motionEvent.getY())) {
                getParent().requestDisallowInterceptTouchEvent(true);
                PhotoViewer.this.videoPlayerSeekbarView.invalidate();
            }
            return true;
        }

        @Override // android.view.View, android.view.ViewParent
        public void requestLayout() {
            if (this.ignoreLayout) {
                return;
            }
            super.requestLayout();
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            int iDp;
            this.ignoreLayout = true;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) PhotoViewer.this.videoPlayerTime.getLayoutParams();
            if (this.parentWidth > this.parentHeight) {
                if (PhotoViewer.this.exitFullscreenButton.getVisibility() != 0) {
                    PhotoViewer.this.exitFullscreenButton.setVisibility(0);
                }
                iDp = AndroidUtilities.dp(48.0f);
                layoutParams.rightMargin = AndroidUtilities.dp(47.0f);
            } else {
                if (PhotoViewer.this.exitFullscreenButton.getVisibility() != 4) {
                    PhotoViewer.this.exitFullscreenButton.setVisibility(4);
                }
                layoutParams.rightMargin = AndroidUtilities.dp(12.0f);
                iDp = 0;
            }
            this.ignoreLayout = false;
            super.onMeasure(i, i2);
            long j = 0;
            if (PhotoViewer.this.videoPlayer != null) {
                long duration = PhotoViewer.this.videoPlayer.getDuration();
                if (duration != -9223372036854775807L) {
                    j = duration;
                }
            }
            long j2 = j / 1000;
            long j3 = j2 / 60;
            long j4 = j2 % 60;
            PhotoViewer.this.videoPlayerSeekbar.setSize(((getMeasuredWidth() - AndroidUtilities.dp(16.0f)) - ((int) Math.ceil(PhotoViewer.this.videoPlayerTime.getPaint().measureText(String.format(Locale.ROOT, "%02d:%02d / %02d:%02d", Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j3), Long.valueOf(j4)))))) - iDp, getMeasuredHeight());
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            float currentPosition = PhotoViewer.this.videoPlayer != null ? PhotoViewer.this.videoPlayer.getCurrentPosition() / PhotoViewer.this.videoPlayer.getDuration() : 0.0f;
            if (PhotoViewer.this.playerWasReady) {
                PhotoViewer.this.videoPlayerSeekbar.setProgress(currentPosition);
            }
            PhotoViewer.this.videoTimelineView.setProgress(currentPosition);
        }

        public float getProgress() {
            return this.progress;
        }

        public void setProgress(float f) {
            if (this.progress != f) {
                this.progress = f;
                onProgressChanged(f);
            }
        }

        private void onProgressChanged(float f) {
            PhotoViewer.this.videoPlayerTime.setAlpha(f);
            PhotoViewer.this.exitFullscreenButton.setAlpha(f);
            if (this.seekBarTransitionEnabled) {
                PhotoViewer.this.videoPlayerTime.setPivotX(PhotoViewer.this.videoPlayerTime.getWidth());
                PhotoViewer.this.videoPlayerTime.setPivotY(PhotoViewer.this.videoPlayerTime.getHeight());
                float f2 = 1.0f - f;
                float f3 = 1.0f - (0.1f * f2);
                PhotoViewer.this.videoPlayerTime.setScaleX(f3);
                PhotoViewer.this.videoPlayerTime.setScaleY(f3);
                PhotoViewer.this.videoPlayerSeekbar.setTransitionProgress(f2);
                return;
            }
            if (this.translationYAnimationEnabled) {
                setTranslationY(AndroidUtilities.dpf2(24.0f) * (1.0f - f));
            }
            PhotoViewer.this.videoPlayerSeekbarView.setAlpha(f);
        }

        public void setSeekBarTransitionEnabled(boolean z) {
            if (this.seekBarTransitionEnabled != z) {
                this.seekBarTransitionEnabled = z;
                if (!z) {
                    PhotoViewer.this.videoPlayerTime.setScaleX(1.0f);
                    PhotoViewer.this.videoPlayerTime.setScaleY(1.0f);
                    PhotoViewer.this.videoPlayerSeekbar.setTransitionProgress(0.0f);
                } else {
                    setTranslationY(0.0f);
                    PhotoViewer.this.videoPlayerSeekbarView.setAlpha(1.0f);
                }
                onProgressChanged(this.progress);
            }
        }

        public void setTranslationYAnimationEnabled(boolean z) {
            if (this.translationYAnimationEnabled != z) {
                this.translationYAnimationEnabled = z;
                if (!z) {
                    setTranslationY(0.0f);
                }
                onProgressChanged(this.progress);
            }
        }
    }

    private class CaptionTextViewSwitcher extends TextViewSwitcher {
        private float alpha;
        private boolean inScrollView;

        public CaptionTextViewSwitcher(Context context) {
            super(context);
            this.inScrollView = false;
            this.alpha = 1.0f;
        }

        @Override // android.view.View
        public void setVisibility(int i) {
            setVisibility(i, true);
        }

        public void setVisibility(int i, boolean z) {
            super.setVisibility(i);
            if (this.inScrollView && z) {
                PhotoViewer.this.captionScrollView.setVisibility(i);
            }
        }

        @Override // android.view.View
        public void setAlpha(float f) {
            this.alpha = f;
            if (this.inScrollView) {
                PhotoViewer.this.captionScrollView.setAlpha(f);
            } else {
                super.setAlpha(f);
            }
        }

        @Override // android.view.View
        public float getAlpha() {
            if (this.inScrollView) {
                return this.alpha;
            }
            return super.getAlpha();
        }

        @Override // android.view.View
        public void setTranslationY(float f) {
            super.setTranslationY(f);
            if (this.inScrollView) {
                PhotoViewer.this.captionScrollView.invalidate();
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            if (PhotoViewer.this.captionContainer == null || getParent() != PhotoViewer.this.captionContainer) {
                return;
            }
            this.inScrollView = true;
            PhotoViewer.this.captionScrollView.setVisibility(getVisibility());
            PhotoViewer.this.captionScrollView.setAlpha(this.alpha);
            super.setAlpha(1.0f);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (this.inScrollView) {
                this.inScrollView = false;
                PhotoViewer.this.captionScrollView.setVisibility(8);
                super.setAlpha(this.alpha);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class CaptionScrollView extends NestedScrollView {
        private Method abortAnimatedScrollMethod;
        private float backgroundAlpha;
        private boolean dontChangeTopMargin;
        private boolean isLandscape;
        private boolean nestedScrollStarted;
        private float overScrollY;
        private final Paint paint;
        private int pendingTopMargin;
        private int prevHeight;
        private OverScroller scroller;
        private final SpringAnimation springAnimation;
        private int textHash;
        private float velocitySign;
        private float velocityY;

        @Override // androidx.core.widget.NestedScrollView, android.view.View
        protected float getBottomFadingEdgeStrength() {
            return 1.0f;
        }

        @Override // androidx.core.widget.NestedScrollView, android.view.View
        protected float getTopFadingEdgeStrength() {
            return 1.0f;
        }

        public CaptionScrollView(Context context) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException {
            super(context);
            Paint paint = new Paint(1);
            this.paint = paint;
            this.backgroundAlpha = 1.0f;
            this.pendingTopMargin = -1;
            setClipChildren(false);
            setOverScrollMode(2);
            paint.setColor(-16777216);
            setFadingEdgeLength(AndroidUtilities.dp(12.0f));
            setVerticalFadingEdgeEnabled(true);
            setWillNotDraw(false);
            SpringAnimation springAnimation = new SpringAnimation(PhotoViewer.this.captionTextViewSwitcher, DynamicAnimation.TRANSLATION_Y, 0.0f);
            this.springAnimation = springAnimation;
            springAnimation.getSpring().setStiffness(100.0f);
            springAnimation.setMinimumVisibleChange(1.0f);
            springAnimation.addUpdateListener(new DynamicAnimation.OnAnimationUpdateListener() { // from class: org.rbmain.ui.PhotoViewer$CaptionScrollView$$ExternalSyntheticLambda0
                @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
                public final void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f2) {
                    this.f$0.lambda$new$0(dynamicAnimation, f, f2);
                }
            });
            springAnimation.getSpring().setDampingRatio(1.0f);
            try {
                Method declaredMethod = NestedScrollView.class.getDeclaredMethod("abortAnimatedScroll", new Class[0]);
                this.abortAnimatedScrollMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Exception e) {
                this.abortAnimatedScrollMethod = null;
                FileLog.e(e);
            }
            try {
                Field declaredField = NestedScrollView.class.getDeclaredField("mScroller");
                declaredField.setAccessible(true);
                this.scroller = (OverScroller) declaredField.get(this);
            } catch (Exception e2) {
                this.scroller = null;
                FileLog.e(e2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0(DynamicAnimation dynamicAnimation, float f, float f2) {
            this.overScrollY = f;
            this.velocityY = f2;
        }

        @Override // androidx.core.widget.NestedScrollView, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || motionEvent.getY() >= (PhotoViewer.this.captionContainer.getTop() - getScrollY()) + PhotoViewer.this.captionTextViewSwitcher.getTranslationY()) {
                return super.onTouchEvent(motionEvent);
            }
            return false;
        }

        @Override // androidx.core.widget.NestedScrollView, android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            updateTopMargin(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
            super.onMeasure(i, i2);
        }

        public void applyPendingTopMargin() {
            this.dontChangeTopMargin = false;
            if (this.pendingTopMargin >= 0) {
                ((ViewGroup.MarginLayoutParams) PhotoViewer.this.captionContainer.getLayoutParams()).topMargin = this.pendingTopMargin;
                this.pendingTopMargin = -1;
                requestLayout();
            }
        }

        public int getPendingMarginTopDiff() {
            int i = this.pendingTopMargin;
            if (i >= 0) {
                return i - ((ViewGroup.MarginLayoutParams) PhotoViewer.this.captionContainer.getLayoutParams()).topMargin;
            }
            return 0;
        }

        public void updateTopMargin() {
            updateTopMargin(getWidth(), getHeight());
        }

        private void updateTopMargin(int i, int i2) {
            int iCalculateNewContainerMarginTop = calculateNewContainerMarginTop(i, i2);
            if (iCalculateNewContainerMarginTop >= 0) {
                if (!this.dontChangeTopMargin) {
                    ((ViewGroup.MarginLayoutParams) PhotoViewer.this.captionContainer.getLayoutParams()).topMargin = iCalculateNewContainerMarginTop;
                    this.pendingTopMargin = -1;
                } else {
                    this.pendingTopMargin = iCalculateNewContainerMarginTop;
                }
            }
        }

        public int calculateNewContainerMarginTop(int i, int i2) {
            int iDp;
            if (i == 0 || i2 == 0) {
                return -1;
            }
            TextView currentView = PhotoViewer.this.captionTextViewSwitcher.getCurrentView();
            CharSequence text = currentView.getText();
            int iHashCode = text.hashCode();
            Point point = AndroidUtilities.displaySize;
            boolean z = point.x > point.y;
            if (this.textHash == iHashCode && this.isLandscape == z && this.prevHeight == i2) {
                return -1;
            }
            this.textHash = iHashCode;
            this.isLandscape = z;
            this.prevHeight = i2;
            currentView.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE));
            Layout layout = currentView.getLayout();
            int lineCount = layout.getLineCount();
            if ((z && lineCount <= 2) || (!z && lineCount <= 5)) {
                iDp = currentView.getMeasuredHeight();
            } else {
                int iMin = Math.min(z ? 2 : 5, lineCount);
                loop0: while (iMin > 1) {
                    int i3 = iMin - 1;
                    for (int lineStart = layout.getLineStart(i3); lineStart < layout.getLineEnd(i3); lineStart++) {
                        if (Character.isLetterOrDigit(text.charAt(lineStart))) {
                            break loop0;
                        }
                    }
                    iMin--;
                }
                i2 -= currentView.getPaint().getFontMetricsInt(null) * iMin;
                iDp = AndroidUtilities.dp(8.0f);
            }
            return i2 - iDp;
        }

        public void reset() {
            scrollTo(0, 0);
        }

        public void stopScrolling() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            Method method = this.abortAnimatedScrollMethod;
            if (method != null) {
                try {
                    method.invoke(this, new Object[0]);
                } catch (Exception e) {
                    FileLog.e(e);
                }
            }
        }

        @Override // androidx.core.widget.NestedScrollView
        public void fling(int i) {
            super.fling(i);
            this.velocitySign = Math.signum(i);
            this.velocityY = 0.0f;
        }

        @Override // androidx.core.widget.NestedScrollView
        public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2, int i3) {
            iArr[1] = 0;
            if (this.nestedScrollStarted) {
                float f = this.overScrollY;
                if ((f > 0.0f && i2 > 0) || (f < 0.0f && i2 < 0)) {
                    float f2 = i2;
                    float f3 = f - f2;
                    if (f > 0.0f) {
                        if (f3 < 0.0f) {
                            this.overScrollY = 0.0f;
                            iArr[1] = (int) (iArr[1] + f2 + f3);
                        } else {
                            this.overScrollY = f3;
                            iArr[1] = iArr[1] + i2;
                        }
                    } else if (f3 > 0.0f) {
                        this.overScrollY = 0.0f;
                        iArr[1] = (int) (iArr[1] + f2 + f3);
                    } else {
                        this.overScrollY = f3;
                        iArr[1] = iArr[1] + i2;
                    }
                    PhotoViewer.this.captionTextViewSwitcher.setTranslationY(this.overScrollY);
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.core.widget.NestedScrollView
        public void dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
            float f;
            if (i4 != 0) {
                int iRound = Math.round(i4 * (1.0f - Math.abs((-this.overScrollY) / (PhotoViewer.this.captionContainer.getTop() - ((PhotoViewer.this.isStatusBarVisible() ? AndroidUtilities.statusBarHeight : 0) + ActionBar.getCurrentActionBarHeight())))));
                if (iRound != 0) {
                    if (!this.nestedScrollStarted) {
                        if (this.springAnimation.isRunning()) {
                            return;
                        }
                        OverScroller overScroller = this.scroller;
                        float currVelocity = overScroller != null ? overScroller.getCurrVelocity() : Float.NaN;
                        if (Float.isNaN(currVelocity)) {
                            f = 0.0f;
                        } else {
                            Point point = AndroidUtilities.displaySize;
                            float fMin = Math.min(point.x > point.y ? 3000.0f : 5000.0f, currVelocity);
                            iRound = (int) ((iRound * fMin) / currVelocity);
                            f = fMin * (-this.velocitySign);
                        }
                        if (iRound != 0) {
                            this.overScrollY -= iRound;
                            PhotoViewer.this.captionTextViewSwitcher.setTranslationY(this.overScrollY);
                        }
                        startSpringAnimationIfNotRunning(f);
                        return;
                    }
                    this.overScrollY -= iRound;
                    PhotoViewer.this.captionTextViewSwitcher.setTranslationY(this.overScrollY);
                }
            }
        }

        private void startSpringAnimationIfNotRunning(float f) {
            if (this.springAnimation.isRunning()) {
                return;
            }
            this.springAnimation.setStartVelocity(f);
            this.springAnimation.start();
        }

        @Override // androidx.core.widget.NestedScrollView
        public boolean startNestedScroll(int i, int i2) {
            if (i2 == 0) {
                this.springAnimation.cancel();
                this.nestedScrollStarted = true;
                this.overScrollY = PhotoViewer.this.captionTextViewSwitcher.getTranslationY();
            }
            return true;
        }

        @Override // androidx.core.widget.NestedScrollView, android.view.View
        public void computeScroll() {
            OverScroller overScroller;
            super.computeScroll();
            if (this.nestedScrollStarted || this.overScrollY == 0.0f || (overScroller = this.scroller) == null || !overScroller.isFinished()) {
                return;
            }
            startSpringAnimationIfNotRunning(0.0f);
        }

        @Override // androidx.core.widget.NestedScrollView, androidx.core.view.NestedScrollingChild2
        public void stopNestedScroll(int i) {
            OverScroller overScroller;
            if (this.nestedScrollStarted && i == 0) {
                this.nestedScrollStarted = false;
                if (this.overScrollY == 0.0f || (overScroller = this.scroller) == null || !overScroller.isFinished()) {
                    return;
                }
                startSpringAnimationIfNotRunning(this.velocityY);
            }
        }

        @Override // androidx.core.widget.NestedScrollView, android.view.View
        public void draw(Canvas canvas) {
            int width = getWidth();
            int height = getHeight();
            int scrollY = getScrollY();
            int iSave = canvas.save();
            int i = height + scrollY;
            canvas.clipRect(0, scrollY, width, i);
            this.paint.setAlpha((int) (this.backgroundAlpha * 127.0f));
            canvas.drawRect(0.0f, PhotoViewer.this.captionContainer.getTop() + PhotoViewer.this.captionTextViewSwitcher.getTranslationY(), width, i, this.paint);
            super.draw(canvas);
            canvas.restoreToCount(iSave);
        }

        @Override // android.view.View
        public void invalidate() {
            super.invalidate();
            if (PhotoViewer.this.isActionBarVisible) {
                int scrollY = getScrollY();
                float translationY = PhotoViewer.this.captionTextViewSwitcher.getTranslationY();
                boolean z = scrollY == 0 && translationY == 0.0f;
                if (!z) {
                    z = (((PhotoViewer.this.captionContainer.getTop() + ((int) translationY)) - scrollY) + ((PhotoViewer.this.isStatusBarVisible() ? AndroidUtilities.statusBarHeight : 0) + ActionBar.getCurrentActionBarHeight())) - AndroidUtilities.dp(12.0f) > PhotoViewer.this.photoProgressViews[0].getY() + PhotoViewer.this.photoProgressViews[0].size;
                }
                PhotoViewer.this.photoProgressViews[0].setIndexedAlpha(2, z ? 1.0f : 0.0f, true);
            }
        }
    }

    public static PhotoViewer getPipInstance() {
        return PipInstance;
    }

    public static PhotoViewer getInstance() {
        PhotoViewer photoViewer = Instance;
        if (photoViewer == null) {
            synchronized (PhotoViewer.class) {
                photoViewer = Instance;
                if (photoViewer == null) {
                    photoViewer = new PhotoViewer();
                    Instance = photoViewer;
                }
            }
        }
        return photoViewer;
    }

    public boolean isOpenedFullScreenVideo() {
        return this.openedFullScreenVideo;
    }

    public static boolean hasInstance() {
        return Instance != null;
    }

    public PhotoViewer() {
        this.blackPaint.setColor(-16777216);
    }

    /* JADX WARN: Removed duplicated region for block: B:154:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x059c  */
    /* JADX WARN: Removed duplicated region for block: B:421:0x02ad A[SYNTHETIC] */
    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void didReceivedNotification(int r22, int r23, java.lang.Object... r24) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException, android.content.res.Resources.NotFoundException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException {
        /*
            Method dump skipped, instructions count: 1957
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.PhotoViewer.didReceivedNotification(int, int, java.lang.Object[]):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDownloadAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.parentActivity);
        builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
        MessageObject messageObject = this.currentMessageObject;
        boolean z = false;
        if (messageObject != null && messageObject.isVideo() && FileLoader.getInstance(this.currentMessageObject.currentAccount).isLoadingFile(this.currentFileNames[0])) {
            z = true;
        }
        if (z) {
            builder.setMessage(LocaleController.getString("PleaseStreamDownload", R.string.PleaseStreamDownload));
        } else {
            builder.setMessage(LocaleController.getString("PleaseDownload", R.string.PleaseDownload));
        }
        showAlertDialog(builder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSharePressed() {
        if (this.parentActivity == null || !this.allowShare) {
            return;
        }
        try {
            MessageObject messageObject = this.currentMessageObject;
            boolean zIsVideo = false;
            File file = null;
            if (messageObject != null) {
                zIsVideo = messageObject.isVideo();
                if (!TextUtils.isEmpty(this.currentMessageObject.messageOwner.attachPath)) {
                    File file2 = new File(this.currentMessageObject.messageOwner.attachPath);
                    if (file2.exists()) {
                        file = file2;
                    }
                }
                if (file == null) {
                    file = FileLoader.getPathToMessage(this.currentMessageObject.messageOwner);
                }
            } else {
                ImageLocation imageLocation = this.currentFileLocationVideo;
                if (imageLocation != null) {
                    file = FileLoader.getPathToAttach(getFileLocation(imageLocation), getFileLocationExt(this.currentFileLocationVideo), this.avatarsDialogId != 0 || this.isEvent);
                } else {
                    PageBlocksAdapter pageBlocksAdapter = this.pageBlocksAdapter;
                    if (pageBlocksAdapter != null) {
                        file = pageBlocksAdapter.getFile(this.currentIndex);
                    }
                }
            }
            if (file != null && file.exists()) {
                Intent intent = new Intent("android.intent.action.SEND");
                if (zIsVideo) {
                    intent.setType("video/mp4");
                } else {
                    MessageObject messageObject2 = this.currentMessageObject;
                    if (messageObject2 != null) {
                        intent.setType(messageObject2.getMimeType());
                    } else {
                        intent.setType("image/jpeg");
                    }
                }
                if (Build.VERSION.SDK_INT >= 24) {
                    try {
                        intent.putExtra("android.intent.extra.STREAM", FileProvider.getUriForFile(this.parentActivity, "ir.medu.shad.provider", file));
                        intent.setFlags(1);
                    } catch (Exception unused) {
                        intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(file));
                    }
                } else {
                    intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(file));
                }
                this.parentActivity.startActivityForResult(Intent.createChooser(intent, LocaleController.getString("ShareFile", R.string.ShareFile)), HttpStatus.HTTP_INTERNAL_SERVER_ERROR);
                return;
            }
            showDownloadAlert();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScaleToFill() {
        float bitmapWidth = this.centerImage.getBitmapWidth();
        float bitmapHeight = this.centerImage.getBitmapHeight();
        if (bitmapWidth == 0.0f || bitmapHeight == 0.0f) {
            return;
        }
        float containerViewWidth = getContainerViewWidth();
        float containerViewHeight = getContainerViewHeight();
        float fMin = Math.min(containerViewHeight / bitmapHeight, containerViewWidth / bitmapWidth);
        float fMax = Math.max(containerViewWidth / ((int) (bitmapWidth * fMin)), containerViewHeight / ((int) (bitmapHeight * fMin)));
        this.scale = fMax;
        updateMinMax(fMax);
    }

    public void setParentAlert(ChatAttachAlert chatAttachAlert) {
        this.parentAlert = chatAttachAlert;
    }

    private boolean isRTLLayout() {
        return LocaleController.isRTL && this.rtlLayout;
    }

    public void setParentActivity(final Activity activity) {
        int i;
        float f;
        int i2;
        float f2;
        int i3 = UserConfig.selectedAccount;
        this.currentAccount = i3;
        this.centerImage.setCurrentAccount(i3);
        this.leftImage.setCurrentAccount(this.currentAccount);
        this.rightImage.setCurrentAccount(this.currentAccount);
        if (this.parentActivity == activity || activity == null) {
            return;
        }
        this.inBubbleMode = activity instanceof BubbleActivity;
        this.parentActivity = activity;
        this.activityContext = new ContextThemeWrapper(this.parentActivity, 2131952293);
        this.touchSlop = ViewConfiguration.get(this.parentActivity).getScaledTouchSlop();
        int i4 = 0;
        boolean z = true;
        if (progressDrawables == null) {
            progressDrawables = new Drawable[]{ContextCompat.getDrawable(this.parentActivity, R.drawable.circle_big), ContextCompat.getDrawable(this.parentActivity, R.drawable.cancel_big), ContextCompat.getDrawable(this.parentActivity, R.drawable.load_big)};
        }
        this.scroller = new Scroller(activity);
        AnonymousClass9 anonymousClass9 = new AnonymousClass9(activity);
        this.windowView = anonymousClass9;
        anonymousClass9.setBackgroundDrawable(this.backgroundDrawable);
        this.windowView.setClipChildren(true);
        this.windowView.setFocusable(false);
        ClippingImageView clippingImageView = new ClippingImageView(activity);
        this.animatingImageView = clippingImageView;
        clippingImageView.setAnimationValues(this.animationValues);
        this.windowView.addView(this.animatingImageView, LayoutHelper.createFrame(40, 40.0f));
        FrameLayoutDrawer frameLayoutDrawer = new FrameLayoutDrawer(activity);
        this.containerView = frameLayoutDrawer;
        frameLayoutDrawer.setFocusable(false);
        this.windowView.addView(this.containerView, LayoutHelper.createFrame(-1, -1, 51));
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 21) {
            this.containerView.setFitsSystemWindows(true);
            this.containerView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda7
                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    return this.f$0.lambda$setParentActivity$2(view, windowInsets);
                }
            });
            this.containerView.setSystemUiVisibility(1792);
        }
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.windowLayoutParams = layoutParams;
        layoutParams.height = -1;
        layoutParams.format = -3;
        layoutParams.width = -1;
        layoutParams.gravity = 51;
        layoutParams.type = 99;
        if (i5 >= 28) {
            layoutParams.layoutInDisplayCutoutMode = 1;
        }
        if (i5 >= 21) {
            layoutParams.flags = -2147286784;
        } else {
            layoutParams.flags = MessagesController.UPDATE_MASK_REORDER;
        }
        PaintingOverlay paintingOverlay = new PaintingOverlay(this.parentActivity);
        this.paintingOverlay = paintingOverlay;
        this.containerView.addView(paintingOverlay, LayoutHelper.createFrame(-2, -2.0f));
        ActionBar actionBar = new ActionBar(activity) { // from class: org.rbmain.ui.PhotoViewer.10
            @Override // android.view.View
            public void setAlpha(float f3) {
                super.setAlpha(f3);
                PhotoViewer.this.containerView.invalidate();
            }
        };
        this.actionBar = actionBar;
        actionBar.setRtlLayout(true);
        this.actionBar.setOverlayTitleAnimation(true);
        this.actionBar.setTitleColor(-1);
        this.actionBar.setSubtitleColor(-1);
        this.actionBar.setBackgroundColor(2130706432);
        this.actionBar.setOccupyStatusBar(isStatusBarVisible());
        this.actionBar.setItemsBackgroundColor(1090519039, false);
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setTitle(LocaleController.formatString("Of", R.string.Of, 1, 1));
        this.containerView.addView(this.actionBar, LayoutHelper.createFrame(-1, -2.0f));
        this.actionBar.setActionBarMenuOnItemClick(new AnonymousClass11());
        ActionBarMenu actionBarMenuCreateMenu = this.actionBar.createMenu();
        ActionBarMenuItem actionBarMenuItemAddItem = actionBarMenuCreateMenu.addItem(13, R.drawable.msg_mask);
        this.masksItem = actionBarMenuItemAddItem;
        actionBarMenuItemAddItem.setContentDescription(LocaleController.getString("Masks", R.string.Masks));
        ActionBarMenuItem actionBarMenuItemAddItem2 = actionBarMenuCreateMenu.addItem(5, R.drawable.ic_goinline);
        this.pipItem = actionBarMenuItemAddItem2;
        actionBarMenuItemAddItem2.setContentDescription(LocaleController.getString("AccDescrPipMode", R.string.AccDescrPipMode));
        ActionBarMenuItem actionBarMenuItemAddItem3 = actionBarMenuCreateMenu.addItem(3, R.drawable.msg_forward);
        this.sendItem = actionBarMenuItemAddItem3;
        actionBarMenuItemAddItem3.setContentDescription(LocaleController.getString("Forward", R.string.Forward));
        ActionBarMenuItem actionBarMenuItemAddItem4 = actionBarMenuCreateMenu.addItem(18, R.drawable.share);
        this.shareItem = actionBarMenuItemAddItem4;
        actionBarMenuItemAddItem4.setContentDescription(LocaleController.getString("ShareFile", R.string.ShareFile));
        ActionBarMenuItem actionBarMenuItemAddItem5 = actionBarMenuCreateMenu.addItem(0, R.drawable.ic_ab_other);
        this.menuItem = actionBarMenuItemAddItem5;
        actionBarMenuItemAddItem5.addSubItem(11, R.drawable.msg_openin, LocaleController.getString("OpenInExternalApp", R.string.OpenInExternalApp)).setColors(-328966, -328966);
        this.menuItem.setContentDescription(LocaleController.getString("AccDescrMoreOptions", R.string.AccDescrMoreOptions));
        ActionBarMenuSubItem actionBarMenuSubItemAddSubItem = this.menuItem.addSubItem(2, R.drawable.msg_media, LocaleController.getString("ShowAllMedia", R.string.ShowAllMedia));
        this.allMediaItem = actionBarMenuSubItemAddSubItem;
        actionBarMenuSubItemAddSubItem.setColors(-328966, -328966);
        this.menuItem.addSubItem(14, R.drawable.msg_gif, LocaleController.getString("SaveToGIFs", R.string.SaveToGIFs)).setColors(-328966, -328966);
        this.menuItem.addSubItem(4, R.drawable.msg_message, LocaleController.getString("ShowInChat", R.string.ShowInChat)).setColors(-328966, -328966);
        this.menuItem.addSubItem(15, R.drawable.msg_sticker, LocaleController.getString("ShowStickers", R.string.ShowStickers)).setColors(-328966, -328966);
        this.menuItem.addSubItem(10, R.drawable.msg_shareout, LocaleController.getString("ShareFile", R.string.ShareFile)).setColors(-328966, -328966);
        this.menuItem.addSubItem(1, R.drawable.msg_gallery, LocaleController.getString("SaveToGallery", R.string.SaveToGallery)).setColors(-328966, -328966);
        this.menuItem.addSubItem(16, R.drawable.menu_private, LocaleController.getString("SetAsMain", R.string.SetAsMain)).setColors(-328966, -328966);
        this.menuItem.addSubItem(6, R.drawable.msg_delete, LocaleController.getString("Delete", R.string.Delete)).setColors(-328966, -328966);
        this.menuItem.addSubItem(7, R.drawable.msg_cancel, LocaleController.getString("StopDownload", R.string.StopDownload)).setColors(-328966, -328966);
        this.menuItem.redrawPopup(-115203550);
        this.menuItem.setSubMenuDelegate(new ActionBarMenuItem.ActionBarSubMenuItemDelegate() { // from class: org.rbmain.ui.PhotoViewer.12
            @Override // org.rbmain.ui.ActionBar.ActionBarMenuItem.ActionBarSubMenuItemDelegate
            public void onShowSubMenu() {
                if (PhotoViewer.this.videoPlayerControlVisible && PhotoViewer.this.isPlaying) {
                    AndroidUtilities.cancelRunOnUIThread(PhotoViewer.this.hideActionBarRunnable);
                }
            }

            @Override // org.rbmain.ui.ActionBar.ActionBarMenuItem.ActionBarSubMenuItemDelegate
            public void onHideSubMenu() {
                if (PhotoViewer.this.videoPlayerControlVisible && PhotoViewer.this.isPlaying) {
                    PhotoViewer.this.scheduleActionBarHide();
                }
            }
        });
        FrameLayout frameLayout = new FrameLayout(this.activityContext) { // from class: org.rbmain.ui.PhotoViewer.13
            @Override // android.view.ViewGroup
            protected void measureChildWithMargins(View view, int i6, int i7, int i8, int i9) {
                if (view == PhotoViewer.this.nameTextView || view == PhotoViewer.this.dateTextView) {
                    i7 = PhotoViewer.this.bottomButtonsLayout.getMeasuredWidth();
                }
                super.measureChildWithMargins(view, i6, i7, i8, i9);
            }
        };
        this.bottomLayout = frameLayout;
        frameLayout.setBackgroundColor(2130706432);
        this.containerView.addView(this.bottomLayout, LayoutHelper.createFrame(-1, 48, 83));
        this.pressedDrawable[0] = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{838860800, 0});
        this.pressedDrawable[0].setShape(0);
        this.pressedDrawable[1] = new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, new int[]{838860800, 0});
        this.pressedDrawable[1].setShape(0);
        GroupedPhotosListView groupedPhotosListView = new GroupedPhotosListView(this.activityContext, AndroidUtilities.dp(10.0f));
        this.groupedPhotosListView = groupedPhotosListView;
        this.containerView.addView(groupedPhotosListView, LayoutHelper.createFrame(-1, 68, 83));
        this.groupedPhotosListView.setDelegate(new GroupedPhotosListView.GroupedPhotosListViewDelegate() { // from class: org.rbmain.ui.PhotoViewer.14
            @Override // org.rbmain.ui.Components.GroupedPhotosListView.GroupedPhotosListViewDelegate
            public int getCurrentIndex() {
                return PhotoViewer.this.currentIndex;
            }

            @Override // org.rbmain.ui.Components.GroupedPhotosListView.GroupedPhotosListViewDelegate
            public int getCurrentAccount() {
                return PhotoViewer.this.currentAccount;
            }

            @Override // org.rbmain.ui.Components.GroupedPhotosListView.GroupedPhotosListViewDelegate
            public int getAvatarsDialogId() {
                return PhotoViewer.this.avatarsDialogId;
            }

            @Override // org.rbmain.ui.Components.GroupedPhotosListView.GroupedPhotosListViewDelegate
            public long getSlideshowMessageId() {
                return PhotoViewer.this.slideshowMessageId.longValue();
            }

            @Override // org.rbmain.ui.Components.GroupedPhotosListView.GroupedPhotosListViewDelegate
            public ArrayList<ImageLocation> getImagesArrLocations() {
                return PhotoViewer.this.imagesArrLocations;
            }

            @Override // org.rbmain.ui.Components.GroupedPhotosListView.GroupedPhotosListViewDelegate
            public ArrayList<MessageObject> getImagesArr() {
                return PhotoViewer.this.imagesArr;
            }

            @Override // org.rbmain.ui.Components.GroupedPhotosListView.GroupedPhotosListViewDelegate
            public List<TLRPC$PageBlock> getPageBlockArr() {
                if (PhotoViewer.this.pageBlocksAdapter != null) {
                    return PhotoViewer.this.pageBlocksAdapter.getAll();
                }
                return null;
            }

            @Override // org.rbmain.ui.Components.GroupedPhotosListView.GroupedPhotosListViewDelegate
            public Object getParentObject() {
                if (PhotoViewer.this.pageBlocksAdapter != null) {
                    return PhotoViewer.this.pageBlocksAdapter.getParentObject();
                }
                return null;
            }

            @Override // org.rbmain.ui.Components.GroupedPhotosListView.GroupedPhotosListViewDelegate
            public void setCurrentIndex(int i6) throws IllegalAccessException, NoSuchFieldException, Resources.NotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException {
                PhotoViewer.this.currentIndex = -1;
                if (PhotoViewer.this.currentThumb != null) {
                    PhotoViewer.this.currentThumb.release();
                    PhotoViewer.this.currentThumb = null;
                }
                PhotoViewer.this.dontAutoPlay = true;
                PhotoViewer.this.setImageIndex(i6);
                PhotoViewer.this.dontAutoPlay = false;
            }

            @Override // org.rbmain.ui.Components.GroupedPhotosListView.GroupedPhotosListViewDelegate
            public void onShowAnimationStart() {
                PhotoViewer.this.containerView.requestLayout();
            }

            @Override // org.rbmain.ui.Components.GroupedPhotosListView.GroupedPhotosListViewDelegate
            public void onStopScrolling() {
                PhotoViewer photoViewer = PhotoViewer.this;
                if (photoViewer.shouldMessageObjectAutoPlayed(photoViewer.currentMessageObject)) {
                    PhotoViewer.this.playerAutoStarted = true;
                    PhotoViewer.this.onActionClick(true);
                    PhotoViewer.this.checkProgress(0, false, true);
                }
            }
        });
        for (int i6 = 0; i6 < 3; i6++) {
            this.fullscreenButton[i6] = new ImageView(this.parentActivity);
            this.fullscreenButton[i6].setImageResource(R.drawable.msg_maxvideo);
            this.fullscreenButton[i6].setContentDescription(LocaleController.getString("AccSwitchToFullscreen", R.string.AccSwitchToFullscreen));
            this.fullscreenButton[i6].setScaleType(ImageView.ScaleType.CENTER);
            this.fullscreenButton[i6].setBackground(Theme.createSelectorDrawable(1090519039));
            this.fullscreenButton[i6].setVisibility(4);
            this.fullscreenButton[i6].setAlpha(1.0f);
            this.containerView.addView(this.fullscreenButton[i6], LayoutHelper.createFrame(48, 48.0f));
            this.fullscreenButton[i6].setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda31
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setParentActivity$3(view);
                }
            });
        }
        final CaptionLinkMovementMethod captionLinkMovementMethod = new CaptionLinkMovementMethod();
        CaptionTextViewSwitcher captionTextViewSwitcher = new CaptionTextViewSwitcher(this.containerView.getContext());
        this.captionTextViewSwitcher = captionTextViewSwitcher;
        captionTextViewSwitcher.setFactory(new ViewSwitcher.ViewFactory() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda41
            @Override // android.widget.ViewSwitcher.ViewFactory
            public final View makeView() {
                return this.f$0.lambda$setParentActivity$4(captionLinkMovementMethod);
            }
        });
        this.captionTextViewSwitcher.setVisibility(4);
        setCaptionHwLayerEnabled(true);
        for (int i7 = 0; i7 < 3; i7++) {
            this.photoProgressViews[i7] = new PhotoProgressView(this.containerView) { // from class: org.rbmain.ui.PhotoViewer.15
                @Override // org.rbmain.ui.PhotoViewer.PhotoProgressView
                protected void onBackgroundStateUpdated(int i8) {
                    if (this == PhotoViewer.this.photoProgressViews[0]) {
                        PhotoViewer.this.updateAccessibilityOverlayVisibility();
                    }
                }

                @Override // org.rbmain.ui.PhotoViewer.PhotoProgressView
                protected void onVisibilityChanged(boolean z2) {
                    if (this == PhotoViewer.this.photoProgressViews[0]) {
                        PhotoViewer.this.updateAccessibilityOverlayVisibility();
                    }
                }
            };
            this.photoProgressViews[i7].setBackgroundState(0, false, true);
        }
        RadialProgressView radialProgressView = new RadialProgressView(this.activityContext) { // from class: org.rbmain.ui.PhotoViewer.16
            @Override // org.rbmain.ui.Components.RadialProgressView, android.view.View
            public void setAlpha(float f3) {
                super.setAlpha(f3);
                if (PhotoViewer.this.containerView != null) {
                    PhotoViewer.this.containerView.invalidate();
                }
            }

            @Override // android.view.View
            public void invalidate() {
                super.invalidate();
                if (PhotoViewer.this.containerView != null) {
                    PhotoViewer.this.containerView.invalidate();
                }
            }
        };
        this.miniProgressView = radialProgressView;
        radialProgressView.setUseSelfAlpha(true);
        this.miniProgressView.setProgressColor(-1);
        this.miniProgressView.setSize(AndroidUtilities.dp(54.0f));
        this.miniProgressView.setBackgroundResource(R.drawable.circle_big);
        this.miniProgressView.setVisibility(4);
        this.miniProgressView.setAlpha(0.0f);
        this.containerView.addView(this.miniProgressView, LayoutHelper.createFrame(64, 64, 17));
        LinearLayout linearLayout = new LinearLayout(this.containerView.getContext());
        this.bottomButtonsLayout = linearLayout;
        linearLayout.setOrientation(0);
        this.bottomLayout.addView(this.bottomButtonsLayout, LayoutHelper.createFrame(-2, -1, 53));
        ImageView imageView = new ImageView(this.containerView.getContext());
        this.paintButton = imageView;
        imageView.setImageResource(R.drawable.photo_paint);
        this.paintButton.setScaleType(ImageView.ScaleType.CENTER);
        this.paintButton.setBackgroundDrawable(Theme.createSelectorDrawable(1090519039));
        this.bottomButtonsLayout.addView(this.paintButton, LayoutHelper.createFrame(50, -1.0f));
        this.paintButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda26
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setParentActivity$5(view);
            }
        });
        this.paintButton.setContentDescription(LocaleController.getString("AccDescrPhotoEditor", R.string.AccDescrPhotoEditor));
        ImageView imageView2 = new ImageView(this.containerView.getContext());
        this.shareButton = imageView2;
        imageView2.setImageResource(R.drawable.share);
        this.shareButton.setScaleType(ImageView.ScaleType.CENTER);
        this.shareButton.setBackgroundDrawable(Theme.createSelectorDrawable(1090519039));
        this.bottomButtonsLayout.addView(this.shareButton, LayoutHelper.createFrame(50, -1.0f));
        this.shareButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setParentActivity$6(view);
            }
        });
        this.shareButton.setContentDescription(LocaleController.getString("ShareFile", R.string.ShareFile));
        FadingTextViewLayout fadingTextViewLayout = new FadingTextViewLayout(this, this.containerView.getContext()) { // from class: org.rbmain.ui.PhotoViewer.17
            @Override // org.rbmain.ui.Components.FadingTextViewLayout
            protected void onTextViewCreated(TextView textView) {
                super.onTextViewCreated(textView);
                textView.setTextSize(1, 14.0f);
                textView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
                textView.setEllipsize(TextUtils.TruncateAt.END);
                textView.setTextColor(-1);
                textView.setGravity(3);
            }
        };
        this.nameTextView = fadingTextViewLayout;
        this.bottomLayout.addView(fadingTextViewLayout, LayoutHelper.createFrame(-1, -2.0f, 51, 16.0f, 5.0f, 8.0f, 0.0f));
        FadingTextViewLayout fadingTextViewLayout2 = new FadingTextViewLayout(this, this.containerView.getContext(), z) { // from class: org.rbmain.ui.PhotoViewer.18
            private LocaleController.LocaleInfo lastLocaleInfo = null;
            private int staticCharsCount = 0;

            @Override // org.rbmain.ui.Components.FadingTextViewLayout
            protected void onTextViewCreated(TextView textView) {
                super.onTextViewCreated(textView);
                textView.setTextSize(1, 13.0f);
                textView.setEllipsize(TextUtils.TruncateAt.END);
                textView.setTextColor(-1);
                textView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
                textView.setGravity(3);
            }

            @Override // org.rbmain.ui.Components.FadingTextViewLayout
            protected int getStaticCharsCount() {
                LocaleController.LocaleInfo currentLocaleInfo = LocaleController.getInstance().getCurrentLocaleInfo();
                if (this.lastLocaleInfo != currentLocaleInfo) {
                    this.lastLocaleInfo = currentLocaleInfo;
                    this.staticCharsCount = LocaleController.formatString("formatDateAtTime", R.string.formatDateAtTime, LocaleController.getInstance().formatterYear.format(new Date()), LocaleController.getInstance().formatterDay.format(new Date())).length();
                }
                return this.staticCharsCount;
            }

            @Override // org.rbmain.ui.Components.FadingTextViewLayout
            public void setText(CharSequence charSequence, boolean z2) {
                int staticCharsCount;
                boolean z3 = false;
                if (z2) {
                    if (!LocaleController.isRTL || (staticCharsCount = getStaticCharsCount()) <= 0 || (charSequence.length() == staticCharsCount && getText() != null && getText().length() == staticCharsCount)) {
                        z3 = true;
                    }
                    setText(charSequence, true, z3);
                    return;
                }
                setText(charSequence, false, false);
            }
        };
        this.dateTextView = fadingTextViewLayout2;
        this.bottomLayout.addView(fadingTextViewLayout2, LayoutHelper.createFrame(-1, -2.0f, 51, 16.0f, 25.0f, 8.0f, 0.0f));
        createVideoControlsInterface();
        RadialProgressView radialProgressView2 = new RadialProgressView(this.parentActivity);
        this.progressView = radialProgressView2;
        radialProgressView2.setProgressColor(-1);
        this.progressView.setBackgroundResource(R.drawable.circle_big);
        this.progressView.setVisibility(4);
        this.containerView.addView(this.progressView, LayoutHelper.createFrame(54, 54, 17));
        PickerBottomLayoutViewer pickerBottomLayoutViewer = new PickerBottomLayoutViewer(this.parentActivity);
        this.qualityPicker = pickerBottomLayoutViewer;
        pickerBottomLayoutViewer.setBackgroundColor(2130706432);
        this.qualityPicker.updateSelectedCount(0, false);
        this.qualityPicker.setTranslationY(AndroidUtilities.dp(120.0f));
        this.qualityPicker.doneButton.setText(LocaleController.getString("Done", R.string.Done).toUpperCase());
        TextView textView = this.qualityPicker.doneButton;
        int i8 = Theme.key_dialogFloatingButton;
        textView.setTextColor(Theme.getColor(i8));
        this.containerView.addView(this.qualityPicker, LayoutHelper.createFrame(-1, 48, 83));
        this.qualityPicker.cancelButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda25
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setParentActivity$7(view);
            }
        });
        this.qualityPicker.doneButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setParentActivity$8(view);
            }
        });
        VideoForwardDrawable videoForwardDrawable = new VideoForwardDrawable();
        this.videoForwardDrawable = videoForwardDrawable;
        videoForwardDrawable.setDelegate(new VideoForwardDrawable.VideoForwardDrawableDelegate() { // from class: org.rbmain.ui.PhotoViewer.19
            @Override // org.rbmain.ui.Components.VideoForwardDrawable.VideoForwardDrawableDelegate
            public void onAnimationEnd() {
            }

            @Override // org.rbmain.ui.Components.VideoForwardDrawable.VideoForwardDrawableDelegate
            public void invalidate() {
                PhotoViewer.this.containerView.invalidate();
            }
        });
        QualityChooseView qualityChooseView = new QualityChooseView(this.parentActivity);
        this.qualityChooseView = qualityChooseView;
        qualityChooseView.setTranslationY(AndroidUtilities.dp(120.0f));
        this.qualityChooseView.setVisibility(4);
        this.qualityChooseView.setBackgroundColor(2130706432);
        this.containerView.addView(this.qualityChooseView, LayoutHelper.createFrame(-1, 70.0f, 83, 0.0f, 0.0f, 0.0f, 48.0f));
        FrameLayout frameLayout2 = new FrameLayout(this.activityContext) { // from class: org.rbmain.ui.PhotoViewer.20
            @Override // android.view.ViewGroup, android.view.View
            public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                return PhotoViewer.this.bottomTouchEnabled && super.dispatchTouchEvent(motionEvent);
            }

            @Override // android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
                return PhotoViewer.this.bottomTouchEnabled && super.onInterceptTouchEvent(motionEvent);
            }

            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent motionEvent) {
                return PhotoViewer.this.bottomTouchEnabled && super.onTouchEvent(motionEvent);
            }

            @Override // android.view.View
            public void setTranslationY(float f3) {
                super.setTranslationY(f3);
                if (PhotoViewer.this.videoTimelineView != null && PhotoViewer.this.videoTimelineView.getVisibility() != 8) {
                    PhotoViewer.this.videoTimelineView.setTranslationY(f3);
                    PhotoViewer.this.videoAvatarTooltip.setTranslationY(f3);
                }
                if (PhotoViewer.this.videoAvatarTooltip == null || PhotoViewer.this.videoAvatarTooltip.getVisibility() == 8) {
                    return;
                }
                PhotoViewer.this.videoAvatarTooltip.setTranslationY(f3);
            }

            @Override // android.view.View
            public void setAlpha(float f3) {
                super.setAlpha(f3);
                if (PhotoViewer.this.videoTimelineView == null || PhotoViewer.this.videoTimelineView.getVisibility() == 8) {
                    return;
                }
                PhotoViewer.this.videoTimelineView.setAlpha(f3);
            }

            @Override // android.view.View
            public void setVisibility(int i9) {
                super.setVisibility(i9);
                if (PhotoViewer.this.videoTimelineView == null || PhotoViewer.this.videoTimelineView.getVisibility() == 8) {
                    return;
                }
                PhotoViewer.this.videoTimelineView.setVisibility(i9 == 0 ? 0 : 4);
            }

            @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean z2, int i9, int i10, int i11, int i12) {
                super.onLayout(z2, i9, i10, i11, i12);
                if (PhotoViewer.this.itemsLayout.getVisibility() != 8) {
                    int iDp = (((i11 - i9) - AndroidUtilities.dp(70.0f)) - PhotoViewer.this.itemsLayout.getMeasuredWidth()) / 2;
                    PhotoViewer.this.itemsLayout.layout(iDp, PhotoViewer.this.itemsLayout.getTop(), PhotoViewer.this.itemsLayout.getMeasuredWidth() + iDp, PhotoViewer.this.itemsLayout.getTop() + PhotoViewer.this.itemsLayout.getMeasuredHeight());
                }
            }
        };
        this.pickerView = frameLayout2;
        frameLayout2.setBackgroundColor(2130706432);
        this.containerView.addView(this.pickerView, LayoutHelper.createFrame(-1, -2, 83));
        TextView textView2 = new TextView(this.containerView.getContext());
        this.docNameTextView = textView2;
        textView2.setTextSize(1, 15.0f);
        this.docNameTextView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        this.docNameTextView.setSingleLine(true);
        this.docNameTextView.setMaxLines(1);
        this.docNameTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.docNameTextView.setTextColor(-1);
        this.docNameTextView.setGravity(3);
        this.pickerView.addView(this.docNameTextView, LayoutHelper.createFrame(-1, -2.0f, 51, 20.0f, 23.0f, 84.0f, 0.0f));
        TextView textView3 = new TextView(this.containerView.getContext());
        this.docInfoTextView = textView3;
        textView3.setTextSize(1, 14.0f);
        this.docInfoTextView.setSingleLine(true);
        this.docInfoTextView.setMaxLines(1);
        this.docInfoTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.docInfoTextView.setTextColor(-1);
        this.docInfoTextView.setGravity(3);
        this.pickerView.addView(this.docInfoTextView, LayoutHelper.createFrame(-1, -2.0f, 51, 20.0f, 46.0f, 84.0f, 0.0f));
        VideoTimelinePlayView videoTimelinePlayView = new VideoTimelinePlayView(this.parentActivity);
        this.videoTimelineView = videoTimelinePlayView;
        videoTimelinePlayView.setDelegate(new AnonymousClass21());
        this.videoTimelineView.setVisibility(8);
        this.videoTimelineView.setBackgroundColor(2130706432);
        long j = this.limitedVideoTime;
        if (j != 0) {
            this.videoTimelineView.setLimitedVideo(true, j);
        }
        this.containerView.addView(this.videoTimelineView, LayoutHelper.createFrame(-1, 58.0f, 83, 0.0f, 8.0f, 0.0f, 0.0f));
        TextView textView4 = new TextView(this.parentActivity);
        this.videoAvatarTooltip = textView4;
        textView4.setSingleLine(true);
        this.videoAvatarTooltip.setVisibility(8);
        this.videoAvatarTooltip.setText(LocaleController.getString("ChooseCover", R.string.ChooseCover));
        this.videoAvatarTooltip.setGravity(1);
        this.videoAvatarTooltip.setTextSize(1, 14.0f);
        this.videoAvatarTooltip.setTextColor(-7566196);
        this.containerView.addView(this.videoAvatarTooltip, LayoutHelper.createFrame(-1, -2.0f, 83, 0.0f, 8.0f, 0.0f, 0.0f));
        ImageView imageView3 = new ImageView(this.parentActivity) { // from class: org.rbmain.ui.PhotoViewer.22
            @Override // android.view.View
            public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                return PhotoViewer.this.bottomTouchEnabled && super.dispatchTouchEvent(motionEvent);
            }

            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent motionEvent) {
                return PhotoViewer.this.bottomTouchEnabled && super.onTouchEvent(motionEvent);
            }

            @Override // android.widget.ImageView, android.view.View
            public void setVisibility(int i9) {
                super.setVisibility(i9);
                if (PhotoViewer.this.captionEditText.getCaptionLimitOffset() < 0) {
                    PhotoViewer.this.captionLimitView.setVisibility(i9);
                } else {
                    PhotoViewer.this.captionLimitView.setVisibility(8);
                }
            }

            @Override // android.view.View
            public void setTranslationY(float f3) {
                super.setTranslationY(f3);
                PhotoViewer.this.captionLimitView.setTranslationY(f3);
            }

            @Override // android.view.View
            public void setAlpha(float f3) {
                super.setAlpha(f3);
                PhotoViewer.this.captionLimitView.setAlpha(f3);
            }
        };
        this.pickerViewSendButton = imageView3;
        imageView3.setScaleType(ImageView.ScaleType.CENTER);
        int iDp = AndroidUtilities.dp(56.0f);
        int color = Theme.getColor(i8);
        int i9 = Build.VERSION.SDK_INT;
        Drawable drawableCreateSimpleSelectorCircleDrawable = Theme.createSimpleSelectorCircleDrawable(iDp, color, Theme.getColor(i9 >= 21 ? Theme.key_dialogFloatingButtonPressed : i8));
        this.pickerViewSendDrawable = drawableCreateSimpleSelectorCircleDrawable;
        this.pickerViewSendButton.setBackgroundDrawable(drawableCreateSimpleSelectorCircleDrawable);
        this.pickerViewSendButton.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.MULTIPLY));
        this.pickerViewSendButton.setImageResource(R.drawable.attach_send);
        this.pickerViewSendButton.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_dialogFloatingIcon), PorterDuff.Mode.MULTIPLY));
        this.containerView.addView(this.pickerViewSendButton, LayoutHelper.createFrame(56, 56.0f, 85, 0.0f, 0.0f, 14.0f, 14.0f));
        this.pickerViewSendButton.setContentDescription(LocaleController.getString("Send", R.string.Send));
        this.pickerViewSendButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda27
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setParentActivity$9(view);
            }
        });
        this.pickerViewSendButton.setOnLongClickListener(new View.OnLongClickListener() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda37
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f$0.lambda$setParentActivity$13(view);
            }
        });
        TextView textView5 = new TextView(this.parentActivity);
        this.captionLimitView = textView5;
        textView5.setTextSize(1, 15.0f);
        this.captionLimitView.setTextColor(-1280137);
        this.captionLimitView.setGravity(17);
        this.captionLimitView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        this.containerView.addView(this.captionLimitView, LayoutHelper.createFrame(56, 20.0f, 85, 3.0f, 0.0f, 14.0f, 78.0f));
        LinearLayout linearLayout2 = new LinearLayout(this.parentActivity) { // from class: org.rbmain.ui.PhotoViewer.23
            @Override // android.widget.LinearLayout, android.view.View
            protected void onMeasure(int i10, int i11) {
                int childCount = getChildCount();
                int i12 = 0;
                for (int i13 = 0; i13 < childCount; i13++) {
                    if (getChildAt(i13).getVisibility() == 0) {
                        i12++;
                    }
                }
                int size = View.MeasureSpec.getSize(i10);
                int size2 = View.MeasureSpec.getSize(i11);
                if (i12 != 0) {
                    int iMin = Math.min(AndroidUtilities.dp(70.0f), size / i12);
                    if (PhotoViewer.this.compressItem.getVisibility() == 0) {
                        int iMax = Math.max(0, (iMin - AndroidUtilities.dp(PhotoViewer.this.selectedCompression < 2 ? 48 : 64)) / 2);
                        PhotoViewer.this.compressItem.setPadding(iMax, 0, iMax, 0);
                    }
                    for (int i14 = 0; i14 < childCount; i14++) {
                        View childAt = getChildAt(i14);
                        if (childAt.getVisibility() != 8) {
                            childAt.measure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
                        }
                    }
                    setMeasuredDimension(iMin * i12, size2);
                    return;
                }
                setMeasuredDimension(size, size2);
            }
        };
        this.itemsLayout = linearLayout2;
        linearLayout2.setOrientation(0);
        this.pickerView.addView(this.itemsLayout, LayoutHelper.createFrame(-2, 48.0f, 81, 0.0f, 0.0f, 70.0f, 0.0f));
        ImageView imageView4 = new ImageView(this.parentActivity);
        this.cropItem = imageView4;
        imageView4.setScaleType(ImageView.ScaleType.CENTER);
        this.cropItem.setImageResource(R.drawable.photo_crop);
        this.cropItem.setBackgroundDrawable(Theme.createSelectorDrawable(1090519039));
        this.itemsLayout.addView(this.cropItem, LayoutHelper.createLinear(48, 48));
        this.cropItem.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setParentActivity$14(view);
            }
        });
        this.cropItem.setContentDescription(LocaleController.getString("CropImage", R.string.CropImage));
        ImageView imageView5 = new ImageView(this.parentActivity);
        this.rotateItem = imageView5;
        imageView5.setScaleType(ImageView.ScaleType.CENTER);
        this.rotateItem.setImageResource(R.drawable.tool_rotate);
        this.rotateItem.setBackgroundDrawable(Theme.createSelectorDrawable(1090519039));
        this.itemsLayout.addView(this.rotateItem, LayoutHelper.createLinear(48, 48));
        this.rotateItem.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda33
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setParentActivity$15(view);
            }
        });
        this.rotateItem.setContentDescription(LocaleController.getString("AccDescrRotate", R.string.AccDescrRotate));
        ImageView imageView6 = new ImageView(this.parentActivity);
        this.mirrorItem = imageView6;
        imageView6.setScaleType(ImageView.ScaleType.CENTER);
        this.mirrorItem.setImageResource(R.drawable.photo_flip);
        this.mirrorItem.setBackgroundDrawable(Theme.createSelectorDrawable(1090519039));
        this.itemsLayout.addView(this.mirrorItem, LayoutHelper.createLinear(48, 48));
        this.mirrorItem.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda30
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setParentActivity$16(view);
            }
        });
        this.mirrorItem.setContentDescription(LocaleController.getString("AccDescrMirror", R.string.AccDescrMirror));
        ImageView imageView7 = new ImageView(this.parentActivity);
        this.paintItem = imageView7;
        imageView7.setScaleType(ImageView.ScaleType.CENTER);
        this.paintItem.setImageResource(R.drawable.photo_paint);
        this.paintItem.setBackgroundDrawable(Theme.createSelectorDrawable(1090519039));
        this.itemsLayout.addView(this.paintItem, LayoutHelper.createLinear(48, 48));
        this.paintItem.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda23
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setParentActivity$17(view);
            }
        });
        this.paintItem.setContentDescription(LocaleController.getString("AccDescrPhotoEditor", R.string.AccDescrPhotoEditor));
        ImageView imageView8 = new ImageView(this.parentActivity);
        this.muteItem = imageView8;
        imageView8.setScaleType(ImageView.ScaleType.CENTER);
        this.muteItem.setBackgroundDrawable(Theme.createSelectorDrawable(1090519039));
        this.containerView.addView(this.muteItem, LayoutHelper.createFrame(48, 48.0f, 83, 16.0f, 0.0f, 0.0f, 0.0f));
        this.muteItem.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda21
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setParentActivity$18(view);
            }
        });
        ImageView imageView9 = new ImageView(this.parentActivity);
        this.cameraItem = imageView9;
        imageView9.setScaleType(ImageView.ScaleType.CENTER);
        this.cameraItem.setImageResource(R.drawable.photo_add);
        this.cameraItem.setBackgroundDrawable(Theme.createSelectorDrawable(1090519039));
        this.cameraItem.setContentDescription(LocaleController.getString("AccDescrTakeMorePics", R.string.AccDescrTakeMorePics));
        this.containerView.addView(this.cameraItem, LayoutHelper.createFrame(48, 48.0f, 85, 0.0f, 0.0f, 16.0f, 0.0f));
        this.cameraItem.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda20
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setParentActivity$19(view);
            }
        });
        ImageView imageView10 = new ImageView(this.parentActivity);
        this.tuneItem = imageView10;
        imageView10.setScaleType(ImageView.ScaleType.CENTER);
        this.tuneItem.setImageResource(R.drawable.photo_tools);
        this.tuneItem.setBackgroundDrawable(Theme.createSelectorDrawable(1090519039));
        this.itemsLayout.addView(this.tuneItem, LayoutHelper.createLinear(48, 48));
        this.tuneItem.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setParentActivity$20(view);
            }
        });
        this.tuneItem.setContentDescription(LocaleController.getString("AccDescrPhotoAdjust", R.string.AccDescrPhotoAdjust));
        ImageView imageView11 = new ImageView(this.parentActivity);
        this.compressItem = imageView11;
        imageView11.setTag(1);
        this.compressItem.setScaleType(ImageView.ScaleType.CENTER);
        this.compressItem.setBackgroundDrawable(Theme.createSelectorDrawable(1090519039));
        int iSelectCompression = selectCompression();
        this.selectedCompression = iSelectCompression;
        if (iSelectCompression <= 1) {
            this.compressItem.setImageResource(R.drawable.video_quality1);
        } else if (iSelectCompression == 2) {
            this.compressItem.setImageResource(R.drawable.video_quality2);
        } else {
            this.selectedCompression = this.compressionsCount - 1;
            this.compressItem.setImageResource(R.drawable.video_quality3);
        }
        this.compressItem.setContentDescription(LocaleController.getString("AccDescrVideoQuality", R.string.AccDescrVideoQuality));
        this.itemsLayout.addView(this.compressItem, LayoutHelper.createLinear(48, 48));
        this.compressItem.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda35
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setParentActivity$21(activity, view);
            }
        });
        ImageView imageView12 = new ImageView(this.parentActivity);
        this.timeItem = imageView12;
        imageView12.setScaleType(ImageView.ScaleType.CENTER);
        this.timeItem.setImageResource(R.drawable.photo_timer);
        this.timeItem.setBackgroundDrawable(Theme.createSelectorDrawable(1090519039));
        this.timeItem.setContentDescription(LocaleController.getString("SetTimer", R.string.SetTimer));
        this.itemsLayout.addView(this.timeItem, LayoutHelper.createLinear(48, 48));
        this.timeItem.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda24
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setParentActivity$27(view);
            }
        });
        PickerBottomLayoutViewer pickerBottomLayoutViewer2 = new PickerBottomLayoutViewer(this.activityContext);
        this.editorDoneLayout = pickerBottomLayoutViewer2;
        pickerBottomLayoutViewer2.setBackgroundColor(-872415232);
        this.editorDoneLayout.updateSelectedCount(0, false);
        this.editorDoneLayout.setVisibility(8);
        this.containerView.addView(this.editorDoneLayout, LayoutHelper.createFrame(-1, 48, 83));
        this.editorDoneLayout.cancelButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setParentActivity$28(view);
            }
        });
        this.editorDoneLayout.doneButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setParentActivity$29(view);
            }
        });
        TextView textView6 = new TextView(this.activityContext);
        this.resetButton = textView6;
        textView6.setVisibility(8);
        this.resetButton.setTextSize(1, 14.0f);
        this.resetButton.setTextColor(-1);
        this.resetButton.setGravity(17);
        this.resetButton.setBackgroundDrawable(Theme.createSelectorDrawable(-12763843, 0));
        this.resetButton.setPadding(AndroidUtilities.dp(20.0f), 0, AndroidUtilities.dp(20.0f), 0);
        this.resetButton.setText(LocaleController.getString("Reset", R.string.CropReset).toUpperCase());
        this.resetButton.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        this.editorDoneLayout.addView(this.resetButton, LayoutHelper.createFrame(-2, -1, 49));
        this.resetButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setParentActivity$30(view);
            }
        });
        GestureDetector2 gestureDetector2 = new GestureDetector2(this.containerView.getContext(), this);
        this.gestureDetector = gestureDetector2;
        gestureDetector2.setIsLongpressEnabled(false);
        setDoubleTapEnabled(true);
        ImageReceiver.ImageReceiverDelegate imageReceiverDelegate = new ImageReceiver.ImageReceiverDelegate() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda60
            @Override // org.rbmain.messenger.ImageReceiver.ImageReceiverDelegate
            public final void didSetImage(ImageReceiver imageReceiver, boolean z2, boolean z3, boolean z4) {
                this.f$0.lambda$setParentActivity$31(imageReceiver, z2, z3, z4);
            }

            @Override // org.rbmain.messenger.ImageReceiver.ImageReceiverDelegate
            public /* synthetic */ void onAnimationReady(ImageReceiver imageReceiver) {
                ImageReceiver.ImageReceiverDelegate.CC.$default$onAnimationReady(this, imageReceiver);
            }
        };
        this.centerImage.setParentView(this.containerView);
        this.centerImage.setCrossfadeAlpha((byte) 2);
        this.centerImage.setInvalidateAll(true);
        this.centerImage.setDelegate(imageReceiverDelegate);
        this.leftImage.setParentView(this.containerView);
        this.leftImage.setCrossfadeAlpha((byte) 2);
        this.leftImage.setInvalidateAll(true);
        this.leftImage.setDelegate(imageReceiverDelegate);
        this.rightImage.setParentView(this.containerView);
        this.rightImage.setCrossfadeAlpha((byte) 2);
        this.rightImage.setInvalidateAll(true);
        this.rightImage.setDelegate(imageReceiverDelegate);
        int rotation = ((WindowManager) ApplicationLoader.applicationContext.getSystemService("window")).getDefaultDisplay().getRotation();
        CheckBox checkBox = new CheckBox(this.containerView.getContext(), R.drawable.selectphoto_large) { // from class: org.rbmain.ui.PhotoViewer.25
            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent motionEvent) {
                return PhotoViewer.this.bottomTouchEnabled && super.onTouchEvent(motionEvent);
            }
        };
        this.checkImageView = checkBox;
        checkBox.setDrawBackground(true);
        this.checkImageView.setHasBorder(true);
        this.checkImageView.setSize(34);
        this.checkImageView.setCheckOffset(AndroidUtilities.dp(1.0f));
        this.checkImageView.setColor(Theme.getColor(i8), -1);
        this.checkImageView.setVisibility(8);
        FrameLayoutDrawer frameLayoutDrawer2 = this.containerView;
        CheckBox checkBox2 = this.checkImageView;
        int i10 = isRTLLayout() ? 3 : 53;
        if (isRTLLayout()) {
            i = 3;
            f = 11.0f;
        } else {
            i = 3;
            f = 0.0f;
        }
        frameLayoutDrawer2.addView(checkBox2, LayoutHelper.createFrame(34, 34.0f, i10, f, (rotation == i || rotation == 1) ? 61.0f : 71.0f, isRTLLayout() ? 0.0f : 11.0f, 0.0f));
        if (isStatusBarVisible()) {
            ((FrameLayout.LayoutParams) this.checkImageView.getLayoutParams()).topMargin += AndroidUtilities.statusBarHeight;
        }
        this.checkImageView.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda19
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setParentActivity$32(view);
            }
        });
        CounterView counterView = new CounterView(this.parentActivity);
        this.photosCounterView = counterView;
        FrameLayoutDrawer frameLayoutDrawer3 = this.containerView;
        int i11 = isRTLLayout() ? 3 : 53;
        if (isRTLLayout()) {
            i2 = 3;
            f2 = 64.0f;
        } else {
            i2 = 3;
            f2 = 0.0f;
        }
        frameLayoutDrawer3.addView(counterView, LayoutHelper.createFrame(40, 40.0f, i11, f2, (rotation == i2 || rotation == 1) ? 58.0f : 68.0f, isRTLLayout() ? 0.0f : 64.0f, 0.0f));
        if (isStatusBarVisible()) {
            ((FrameLayout.LayoutParams) this.photosCounterView.getLayoutParams()).topMargin += AndroidUtilities.statusBarHeight;
        }
        this.photosCounterView.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setParentActivity$33(view);
            }
        });
        SelectedPhotosListView selectedPhotosListView = new SelectedPhotosListView(this.parentActivity);
        this.selectedPhotosListView = selectedPhotosListView;
        selectedPhotosListView.setVisibility(8);
        this.selectedPhotosListView.setAlpha(0.0f);
        this.selectedPhotosListView.setLayoutManager(new LinearLayoutManager(this, this.parentActivity, i4, z) { // from class: org.rbmain.ui.PhotoViewer.26
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i12) {
                LinearSmoothScrollerEnd linearSmoothScrollerEnd = new LinearSmoothScrollerEnd(this, recyclerView.getContext()) { // from class: org.rbmain.ui.PhotoViewer.26.1
                    @Override // androidx.recyclerview.widget.LinearSmoothScrollerEnd
                    protected int calculateTimeForDeceleration(int i13) {
                        return Math.max(180, super.calculateTimeForDeceleration(i13));
                    }
                };
                linearSmoothScrollerEnd.setTargetPosition(i12);
                startSmoothScroll(linearSmoothScrollerEnd);
            }
        });
        SelectedPhotosListView selectedPhotosListView2 = this.selectedPhotosListView;
        ListAdapter listAdapter = new ListAdapter(this.parentActivity);
        this.selectedPhotosAdapter = listAdapter;
        selectedPhotosListView2.setAdapter(listAdapter);
        this.containerView.addView(this.selectedPhotosListView, LayoutHelper.createFrame(-1, 103, 51));
        this.selectedPhotosListView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda64
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i12) throws IllegalAccessException, NoSuchFieldException, Resources.NotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException {
                this.f$0.lambda$setParentActivity$34(view, i12);
            }
        });
        PhotoViewerCaptionEnterView photoViewerCaptionEnterView = new PhotoViewerCaptionEnterView(this.activityContext, this.containerView, this.windowView) { // from class: org.rbmain.ui.PhotoViewer.27
            @Override // android.view.ViewGroup, android.view.View
            public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                try {
                    if (PhotoViewer.this.bottomTouchEnabled) {
                        return false;
                    }
                    return super.dispatchTouchEvent(motionEvent);
                } catch (Exception e) {
                    FileLog.e(e);
                    return false;
                }
            }

            @Override // android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
                try {
                    if (PhotoViewer.this.bottomTouchEnabled) {
                        return false;
                    }
                    return super.onInterceptTouchEvent(motionEvent);
                } catch (Exception e) {
                    FileLog.e(e);
                    return false;
                }
            }

            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent motionEvent) {
                return !PhotoViewer.this.bottomTouchEnabled && super.onTouchEvent(motionEvent);
            }

            @Override // org.rbmain.ui.Components.PhotoViewerCaptionEnterView
            protected void extendActionMode(ActionMode actionMode, Menu menu) {
                if (PhotoViewer.this.parentChatActivity != null) {
                    PhotoViewer.this.parentChatActivity.extendActionMode(menu);
                }
            }
        };
        this.captionEditText = photoViewerCaptionEnterView;
        photoViewerCaptionEnterView.setDelegate(new PhotoViewerCaptionEnterView.PhotoViewerCaptionEnterViewDelegate() { // from class: org.rbmain.ui.PhotoViewer.28
            @Override // org.rbmain.ui.Components.PhotoViewerCaptionEnterView.PhotoViewerCaptionEnterViewDelegate
            public void onCaptionEnter() throws IllegalAccessException, NoSuchFieldException, Resources.NotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException {
                PhotoViewer.this.closeCaptionEnter(true);
            }

            @Override // org.rbmain.ui.Components.PhotoViewerCaptionEnterView.PhotoViewerCaptionEnterViewDelegate
            public void onTextChanged(CharSequence charSequence) {
                if (PhotoViewer.this.mentionsAdapter != null && PhotoViewer.this.captionEditText != null && PhotoViewer.this.parentChatActivity != null && charSequence != null) {
                    PhotoViewer.this.mentionsAdapter.searchUsernameOrHashtag(charSequence.toString(), PhotoViewer.this.captionEditText.getCursorPosition(), PhotoViewer.this.parentChatActivity.messages, false, false);
                }
                int color2 = Theme.getColor(Theme.key_dialogFloatingIcon);
                if (PhotoViewer.this.captionEditText.getCaptionLimitOffset() < 0) {
                    PhotoViewer.this.captionLimitView.setText(Integer.toString(PhotoViewer.this.captionEditText.getCaptionLimitOffset()));
                    PhotoViewer.this.captionLimitView.setVisibility(PhotoViewer.this.pickerViewSendButton.getVisibility());
                    PhotoViewer.this.pickerViewSendButton.setColorFilter(new PorterDuffColorFilter(ColorUtils.setAlphaComponent(color2, (int) (Color.alpha(color2) * 0.58f)), PorterDuff.Mode.MULTIPLY));
                } else {
                    PhotoViewer.this.pickerViewSendButton.setColorFilter(new PorterDuffColorFilter(color2, PorterDuff.Mode.MULTIPLY));
                    PhotoViewer.this.captionLimitView.setVisibility(8);
                }
                if (PhotoViewer.this.placeProvider != null) {
                    PhotoViewer.this.placeProvider.onCaptionChanged(charSequence);
                }
            }

            @Override // org.rbmain.ui.Components.PhotoViewerCaptionEnterView.PhotoViewerCaptionEnterViewDelegate
            public void onWindowSizeChanged(int i12) {
                if (i12 - (ActionBar.getCurrentActionBarHeight() * 2) < AndroidUtilities.dp((Math.min(3, PhotoViewer.this.mentionsAdapter.getItemCount()) * 36) + (PhotoViewer.this.mentionsAdapter.getItemCount() > 3 ? 18 : 0))) {
                    PhotoViewer.this.allowMentions = false;
                    if (PhotoViewer.this.mentionListView == null || PhotoViewer.this.mentionListView.getVisibility() != 0) {
                        return;
                    }
                    PhotoViewer.this.mentionListView.setVisibility(4);
                    return;
                }
                PhotoViewer.this.allowMentions = true;
                if (PhotoViewer.this.mentionListView == null || PhotoViewer.this.mentionListView.getVisibility() != 4) {
                    return;
                }
                PhotoViewer.this.mentionListView.setVisibility(0);
            }

            @Override // org.rbmain.ui.Components.PhotoViewerCaptionEnterView.PhotoViewerCaptionEnterViewDelegate
            public void onEmojiViewCloseStart() {
                int i12;
                String str;
                setOffset(PhotoViewer.this.captionEditText.getEmojiPadding());
                if (PhotoViewer.this.captionEditText.getTag() != null) {
                    if (PhotoViewer.this.isCurrentVideo) {
                        ActionBar actionBar2 = PhotoViewer.this.actionBar;
                        if (PhotoViewer.this.muteVideo) {
                            i12 = R.string.GifCaption;
                            str = "GifCaption";
                        } else {
                            i12 = R.string.VideoCaption;
                            str = "VideoCaption";
                        }
                        actionBar2.setTitleAnimated(LocaleController.getString(str, i12), true, 220L);
                    } else {
                        PhotoViewer.this.actionBar.setTitleAnimated(LocaleController.getString("PhotoCaption", R.string.PhotoCaption), true, 220L);
                    }
                    PhotoViewer.this.checkImageView.animate().alpha(0.0f).setDuration(220L).start();
                    PhotoViewer.this.photosCounterView.animate().alpha(0.0f).setDuration(220L).start();
                    PhotoViewer.this.selectedPhotosListView.animate().alpha(0.0f).translationY(-AndroidUtilities.dp(10.0f)).setDuration(220L).start();
                    return;
                }
                PhotoViewer.this.checkImageView.animate().alpha(1.0f).setDuration(220L).start();
                PhotoViewer.this.photosCounterView.animate().alpha(1.0f).setDuration(220L).start();
                if (PhotoViewer.this.lastTitle != null) {
                    PhotoViewer.this.actionBar.setTitleAnimated(PhotoViewer.this.lastTitle, false, 220L);
                    PhotoViewer.this.lastTitle = null;
                }
            }

            @Override // org.rbmain.ui.Components.PhotoViewerCaptionEnterView.PhotoViewerCaptionEnterViewDelegate
            public void onEmojiViewCloseEnd() {
                setOffset(0);
                PhotoViewer.this.captionEditText.setVisibility(8);
            }

            private void setOffset(int i12) {
                for (int i13 = 0; i13 < PhotoViewer.this.containerView.getChildCount(); i13++) {
                    View childAt = PhotoViewer.this.containerView.getChildAt(i13);
                    if (childAt == PhotoViewer.this.cameraItem || childAt == PhotoViewer.this.muteItem || childAt == PhotoViewer.this.pickerView || childAt == PhotoViewer.this.videoTimelineView || childAt == PhotoViewer.this.pickerViewSendButton || childAt == PhotoViewer.this.captionTextViewSwitcher || (PhotoViewer.this.muteItem.getVisibility() == 0 && childAt == PhotoViewer.this.bottomLayout)) {
                        childAt.setTranslationY(i12);
                    }
                }
            }
        });
        if (i9 >= 19) {
            this.captionEditText.setImportantForAccessibility(4);
        }
        this.captionEditText.setVisibility(8);
        this.containerView.addView(this.captionEditText, LayoutHelper.createFrame(-1, -2, 83));
        RecyclerListView recyclerListView = new RecyclerListView(this.activityContext) { // from class: org.rbmain.ui.PhotoViewer.29
            @Override // org.rbmain.ui.Components.RecyclerListView, android.view.ViewGroup, android.view.View
            public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                return !PhotoViewer.this.bottomTouchEnabled && super.dispatchTouchEvent(motionEvent);
            }

            @Override // org.rbmain.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
                return !PhotoViewer.this.bottomTouchEnabled && super.onInterceptTouchEvent(motionEvent);
            }

            @Override // org.rbmain.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.View
            public boolean onTouchEvent(MotionEvent motionEvent) {
                return !PhotoViewer.this.bottomTouchEnabled && super.onTouchEvent(motionEvent);
            }
        };
        this.mentionListView = recyclerListView;
        recyclerListView.setTag(5);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, this.activityContext) { // from class: org.rbmain.ui.PhotoViewer.30
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean supportsPredictiveItemAnimations() {
                return false;
            }
        };
        this.mentionLayoutManager = linearLayoutManager;
        linearLayoutManager.setOrientation(1);
        this.mentionListView.setLayoutManager(this.mentionLayoutManager);
        this.mentionListView.setBackgroundColor(2130706432);
        this.mentionListView.setVisibility(8);
        this.mentionListView.setClipToPadding(true);
        this.mentionListView.setOverScrollMode(2);
        this.containerView.addView(this.mentionListView, LayoutHelper.createFrame(-1, 110, 83));
        RecyclerListView recyclerListView2 = this.mentionListView;
        MentionsAdapter mentionsAdapter = new MentionsAdapter(this.activityContext, true, 0L, 0L, new MentionsAdapter.MentionsAdapterDelegate() { // from class: org.rbmain.ui.PhotoViewer.31
            @Override // org.rbmain.ui.Adapters.MentionsAdapter.MentionsAdapterDelegate
            public void onContextClick(TLRPC$BotInlineResult tLRPC$BotInlineResult) {
            }

            @Override // org.rbmain.ui.Adapters.MentionsAdapter.MentionsAdapterDelegate
            public void onContextSearch(boolean z2) {
            }

            @Override // org.rbmain.ui.Adapters.MentionsAdapter.MentionsAdapterDelegate
            public void onItemCountUpdate(int i12, int i13) {
            }

            @Override // org.rbmain.ui.Adapters.MentionsAdapter.MentionsAdapterDelegate
            public void needChangePanelVisibility(boolean z2) {
                if (z2) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) PhotoViewer.this.mentionListView.getLayoutParams();
                    float fMin = (Math.min(3, PhotoViewer.this.mentionsAdapter.getItemCount()) * 36) + (PhotoViewer.this.mentionsAdapter.getItemCount() > 3 ? 18 : 0);
                    layoutParams2.height = AndroidUtilities.dp(fMin);
                    layoutParams2.topMargin = -AndroidUtilities.dp(fMin);
                    PhotoViewer.this.mentionListView.setLayoutParams(layoutParams2);
                    if (PhotoViewer.this.mentionListAnimation != null) {
                        PhotoViewer.this.mentionListAnimation.cancel();
                        PhotoViewer.this.mentionListAnimation = null;
                    }
                    if (PhotoViewer.this.mentionListView.getVisibility() == 0) {
                        PhotoViewer.this.mentionListView.setAlpha(1.0f);
                        return;
                    }
                    PhotoViewer.this.mentionLayoutManager.scrollToPositionWithOffset(0, 10000);
                    if (PhotoViewer.this.allowMentions) {
                        PhotoViewer.this.mentionListView.setVisibility(0);
                        PhotoViewer.this.mentionListAnimation = new AnimatorSet();
                        PhotoViewer.this.mentionListAnimation.playTogether(ObjectAnimator.ofFloat(PhotoViewer.this.mentionListView, (Property<RecyclerListView, Float>) View.ALPHA, 0.0f, 1.0f));
                        PhotoViewer.this.mentionListAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.PhotoViewer.31.1
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                if (PhotoViewer.this.mentionListAnimation == null || !PhotoViewer.this.mentionListAnimation.equals(animator)) {
                                    return;
                                }
                                PhotoViewer.this.mentionListAnimation = null;
                            }
                        });
                        PhotoViewer.this.mentionListAnimation.setDuration(200L);
                        PhotoViewer.this.mentionListAnimation.start();
                        return;
                    }
                    PhotoViewer.this.mentionListView.setAlpha(1.0f);
                    PhotoViewer.this.mentionListView.setVisibility(4);
                    return;
                }
                if (PhotoViewer.this.mentionListAnimation != null) {
                    PhotoViewer.this.mentionListAnimation.cancel();
                    PhotoViewer.this.mentionListAnimation = null;
                }
                if (PhotoViewer.this.mentionListView.getVisibility() == 8) {
                    return;
                }
                if (PhotoViewer.this.allowMentions) {
                    PhotoViewer.this.mentionListAnimation = new AnimatorSet();
                    PhotoViewer.this.mentionListAnimation.playTogether(ObjectAnimator.ofFloat(PhotoViewer.this.mentionListView, (Property<RecyclerListView, Float>) View.ALPHA, 0.0f));
                    PhotoViewer.this.mentionListAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.PhotoViewer.31.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            if (PhotoViewer.this.mentionListAnimation == null || !PhotoViewer.this.mentionListAnimation.equals(animator)) {
                                return;
                            }
                            PhotoViewer.this.mentionListView.setVisibility(8);
                            PhotoViewer.this.mentionListAnimation = null;
                        }
                    });
                    PhotoViewer.this.mentionListAnimation.setDuration(200L);
                    PhotoViewer.this.mentionListAnimation.start();
                    return;
                }
                PhotoViewer.this.mentionListView.setVisibility(8);
            }
        }, null);
        this.mentionsAdapter = mentionsAdapter;
        recyclerListView2.setAdapter(mentionsAdapter);
        this.mentionListView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda65
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i12) {
                this.f$0.lambda$setParentActivity$35(view, i12);
            }
        });
        this.mentionListView.setOnItemLongClickListener(new RecyclerListView.OnItemLongClickListener() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda66
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemLongClickListener
            public final boolean onItemClick(View view, int i12) {
                return this.f$0.lambda$setParentActivity$37(view, i12);
            }
        });
        UndoView undoView = new UndoView(this.activityContext);
        this.hintView = undoView;
        undoView.setAdditionalTranslationY(AndroidUtilities.dp(112.0f));
        this.hintView.setColors(-115203550, -1);
        this.containerView.addView(this.hintView, LayoutHelper.createFrame(-1, -2.0f, 83, 8.0f, 0.0f, 8.0f, 8.0f));
        if (((AccessibilityManager) this.activityContext.getSystemService("accessibility")).isEnabled()) {
            View view = new View(this.activityContext);
            this.playButtonAccessibilityOverlay = view;
            view.setContentDescription(LocaleController.getString("AccActionPlay", R.string.AccActionPlay));
            this.playButtonAccessibilityOverlay.setFocusable(true);
            this.containerView.addView(this.playButtonAccessibilityOverlay, LayoutHelper.createFrame(64, 64, 17));
        }
    }

    /* renamed from: org.rbmain.ui.PhotoViewer$9, reason: invalid class name */
    class AnonymousClass9 extends FrameLayout {
        AnonymousClass9(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return PhotoViewer.this.isVisible && super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return PhotoViewer.this.isVisible && PhotoViewer.this.onTouchEvent(motionEvent);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            keyEvent.getKeyCode();
            if (!PhotoViewer.this.muteVideo && PhotoViewer.this.sendPhotoType != 1 && PhotoViewer.this.isCurrentVideo && PhotoViewer.this.videoPlayer != null && keyEvent.getRepeatCount() == 0 && keyEvent.getAction() == 0 && (keyEvent.getKeyCode() == 24 || keyEvent.getKeyCode() == 25)) {
                PhotoViewer.this.videoPlayer.setVolume(1.0f);
            }
            return super.dispatchKeyEvent(keyEvent);
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0023  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0029  */
        @Override // android.view.ViewGroup, android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean dispatchTouchEvent(android.view.MotionEvent r3) {
            /*
                r2 = this;
                org.rbmain.ui.PhotoViewer r0 = org.rbmain.ui.PhotoViewer.this
                boolean r0 = org.rbmain.ui.PhotoViewer.access$100(r0)
                if (r0 == 0) goto L32
                org.rbmain.ui.PhotoViewer r0 = org.rbmain.ui.PhotoViewer.this
                boolean r0 = org.rbmain.ui.PhotoViewer.access$200(r0)
                if (r0 == 0) goto L32
                int r0 = r3.getActionMasked()
                if (r0 == 0) goto L29
                r1 = 1
                if (r0 == r1) goto L23
                r1 = 3
                if (r0 == r1) goto L23
                r1 = 5
                if (r0 == r1) goto L29
                r1 = 6
                if (r0 == r1) goto L23
                goto L32
            L23:
                org.rbmain.ui.PhotoViewer r0 = org.rbmain.ui.PhotoViewer.this
                org.rbmain.ui.PhotoViewer.access$10500(r0)
                goto L32
            L29:
                org.rbmain.ui.PhotoViewer r0 = org.rbmain.ui.PhotoViewer.this
                java.lang.Runnable r0 = org.rbmain.ui.PhotoViewer.access$10400(r0)
                org.rbmain.messenger.AndroidUtilities.cancelRunOnUIThread(r0)
            L32:
                boolean r3 = super.dispatchTouchEvent(r3)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.PhotoViewer.AnonymousClass9.dispatchTouchEvent(android.view.MotionEvent):boolean");
        }

        @Override // android.view.ViewGroup
        protected boolean drawChild(Canvas canvas, View view, long j) {
            try {
                return super.drawChild(canvas, view, j);
            } catch (Throwable unused) {
                return false;
            }
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            int i3;
            int stableInsetBottom;
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            if (Build.VERSION.SDK_INT >= 21 && PhotoViewer.this.lastInsets != null) {
                WindowInsets windowInsets = (WindowInsets) PhotoViewer.this.lastInsets;
                if (!PhotoViewer.this.inBubbleMode) {
                    if (AndroidUtilities.incorrectDisplaySizeFix) {
                        int i4 = AndroidUtilities.displaySize.y;
                        if (size2 > i4) {
                            size2 = i4;
                        }
                        size2 += AndroidUtilities.statusBarHeight;
                    } else if (windowInsets.getStableInsetBottom() >= 0 && (i3 = AndroidUtilities.statusBarHeight) >= 0 && (stableInsetBottom = (size2 - i3) - windowInsets.getStableInsetBottom()) > 0 && stableInsetBottom < 4096) {
                        AndroidUtilities.displaySize.y = stableInsetBottom;
                    }
                }
                int systemWindowInsetBottom = windowInsets.getSystemWindowInsetBottom();
                if (PhotoViewer.this.captionEditText.isPopupShowing()) {
                    systemWindowInsetBottom -= PhotoViewer.this.containerView.getKeyboardHeight();
                }
                size2 -= systemWindowInsetBottom;
            } else {
                int i5 = AndroidUtilities.displaySize.y;
                if (size2 > i5) {
                    size2 = i5;
                }
            }
            setMeasuredDimension(size, size2);
            ViewGroup.LayoutParams layoutParams = PhotoViewer.this.animatingImageView.getLayoutParams();
            PhotoViewer.this.animatingImageView.measure(View.MeasureSpec.makeMeasureSpec(layoutParams.width, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(layoutParams.height, Integer.MIN_VALUE));
            PhotoViewer.this.containerView.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            PhotoViewer.this.animatingImageView.layout(0, 0, PhotoViewer.this.animatingImageView.getMeasuredWidth(), PhotoViewer.this.animatingImageView.getMeasuredHeight());
            PhotoViewer.this.containerView.layout(0, 0, PhotoViewer.this.containerView.getMeasuredWidth(), PhotoViewer.this.containerView.getMeasuredHeight());
            PhotoViewer.this.wasLayout = true;
            if (z) {
                if (!PhotoViewer.this.dontResetZoomOnFirstLayout) {
                    PhotoViewer.this.scale = 1.0f;
                    PhotoViewer.this.translationX = 0.0f;
                    PhotoViewer.this.translationY = 0.0f;
                    PhotoViewer photoViewer = PhotoViewer.this;
                    photoViewer.updateMinMax(photoViewer.scale);
                }
                if (PhotoViewer.this.checkImageView != null) {
                    PhotoViewer.this.checkImageView.post(new Runnable() { // from class: org.rbmain.ui.PhotoViewer$9$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onLayout$0();
                        }
                    });
                }
            }
            if (PhotoViewer.this.dontResetZoomOnFirstLayout) {
                PhotoViewer.this.setScaleToFill();
                PhotoViewer.this.dontResetZoomOnFirstLayout = false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onLayout$0() {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) PhotoViewer.this.checkImageView.getLayoutParams();
            ((WindowManager) ApplicationLoader.applicationContext.getSystemService("window")).getDefaultDisplay().getRotation();
            int currentActionBarHeight = ((ActionBar.getCurrentActionBarHeight() - AndroidUtilities.dp(34.0f)) / 2) + (PhotoViewer.this.isStatusBarVisible() ? AndroidUtilities.statusBarHeight : 0);
            if (currentActionBarHeight != layoutParams.topMargin) {
                layoutParams.topMargin = currentActionBarHeight;
                PhotoViewer.this.checkImageView.setLayoutParams(layoutParams);
            }
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) PhotoViewer.this.photosCounterView.getLayoutParams();
            int currentActionBarHeight2 = ((ActionBar.getCurrentActionBarHeight() - AndroidUtilities.dp(40.0f)) / 2) + (PhotoViewer.this.isStatusBarVisible() ? AndroidUtilities.statusBarHeight : 0);
            if (layoutParams2.topMargin != currentActionBarHeight2) {
                layoutParams2.topMargin = currentActionBarHeight2;
                PhotoViewer.this.photosCounterView.setLayoutParams(layoutParams2);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            PhotoViewer.this.centerImage.onAttachedToWindow();
            PhotoViewer.this.leftImage.onAttachedToWindow();
            PhotoViewer.this.rightImage.onAttachedToWindow();
            PhotoViewer.this.attachedToWindow = true;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            PhotoViewer.this.centerImage.onDetachedFromWindow();
            PhotoViewer.this.leftImage.onDetachedFromWindow();
            PhotoViewer.this.rightImage.onDetachedFromWindow();
            PhotoViewer.this.attachedToWindow = false;
            PhotoViewer.this.wasLayout = false;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEventPreIme(KeyEvent keyEvent) throws IllegalAccessException, NoSuchFieldException, Resources.NotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException {
            if (keyEvent != null && keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1) {
                if (PhotoViewer.this.captionEditText.isPopupShowing() || PhotoViewer.this.captionEditText.isKeyboardVisible()) {
                    PhotoViewer.this.closeCaptionEnter(true);
                    return false;
                }
                PhotoViewer.getInstance().closePhoto(true, false);
                return true;
            }
            return super.dispatchKeyEventPreIme(keyEvent);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            if (Build.VERSION.SDK_INT < 21 || !PhotoViewer.this.isVisible || PhotoViewer.this.lastInsets == null) {
                return;
            }
            WindowInsets windowInsets = (WindowInsets) PhotoViewer.this.lastInsets;
            if (PhotoViewer.this.animationInProgress == 1) {
                PhotoViewer.this.blackPaint.setAlpha((int) (PhotoViewer.this.animatingImageView.getAnimationProgress() * 255.0f));
            } else if (PhotoViewer.this.animationInProgress == 3) {
                PhotoViewer.this.blackPaint.setAlpha((int) ((1.0f - PhotoViewer.this.animatingImageView.getAnimationProgress()) * 255.0f));
            } else {
                PhotoViewer.this.blackPaint.setAlpha(PhotoViewer.this.backgroundDrawable.getAlpha());
            }
            canvas.drawRect(0.0f, getMeasuredHeight(), getMeasuredWidth(), getMeasuredHeight() + windowInsets.getSystemWindowInsetBottom(), PhotoViewer.this.blackPaint);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            super.dispatchDraw(canvas);
            if (PhotoViewer.this.parentChatActivity != null) {
                UndoView undoView = PhotoViewer.this.parentChatActivity.getUndoView();
                if (undoView.getVisibility() == 0) {
                    canvas.save();
                    View view = (View) undoView.getParent();
                    canvas.clipRect(view.getX(), view.getY(), view.getX() + view.getWidth(), view.getY() + view.getHeight());
                    canvas.translate(undoView.getX(), undoView.getY());
                    undoView.draw(canvas);
                    canvas.restore();
                    invalidate();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ WindowInsets lambda$setParentActivity$2(View view, WindowInsets windowInsets) {
        int systemWindowInsetTop = windowInsets.getSystemWindowInsetTop();
        Activity activity = this.parentActivity;
        if ((activity instanceof LaunchActivity) && ((systemWindowInsetTop != 0 || AndroidUtilities.isInMultiwindow) && !this.inBubbleMode && AndroidUtilities.statusBarHeight != systemWindowInsetTop)) {
            AndroidUtilities.statusBarHeight = systemWindowInsetTop;
            ((LaunchActivity) activity).drawerLayoutContainer.requestLayout();
        }
        WindowInsets windowInsets2 = (WindowInsets) this.lastInsets;
        this.lastInsets = windowInsets;
        if (windowInsets2 == null || !windowInsets2.toString().equals(windowInsets.toString())) {
            int i = this.animationInProgress;
            if (i == 1 || i == 3) {
                ClippingImageView clippingImageView = this.animatingImageView;
                clippingImageView.setTranslationX(clippingImageView.getTranslationX() - getLeftInset());
                this.animationValues[0][2] = this.animatingImageView.getTranslationX();
            }
            FrameLayout frameLayout = this.windowView;
            if (frameLayout != null) {
                frameLayout.requestLayout();
            }
        }
        this.containerView.setPadding(windowInsets.getSystemWindowInsetLeft(), 0, windowInsets.getSystemWindowInsetRight(), 0);
        if (this.actionBar != null) {
            AndroidUtilities.cancelRunOnUIThread(this.updateContainerFlagsRunnable);
            if (this.isVisible && this.animationInProgress == 0) {
                AndroidUtilities.runOnUIThread(this.updateContainerFlagsRunnable, 200L);
            }
        }
        if (Build.VERSION.SDK_INT >= 30) {
            return WindowInsets.CONSUMED;
        }
        return windowInsets.consumeSystemWindowInsets();
    }

    /* renamed from: org.rbmain.ui.PhotoViewer$11, reason: invalid class name */
    class AnonymousClass11 extends ActionBar.ActionBarMenuOnItemClick {
        AnonymousClass11() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onItemClick$0(boolean z) {
            BulletinFactory.createSaveToGalleryBulletin(PhotoViewer.this.containerView, z, -115203550, -1).show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onItemClick$1(ArrayList arrayList, ChatActivity chatActivity, DialogsActivity dialogsActivity, ArrayList arrayList2, CharSequence charSequence, boolean z) {
            if (arrayList2.size() > 1 || ((Long) arrayList2.get(0)).longValue() == UserConfig.getInstance(PhotoViewer.this.currentAccount).getClientUserId() || charSequence != null) {
                for (int i = 0; i < arrayList2.size(); i++) {
                    long jLongValue = ((Long) arrayList2.get(i)).longValue();
                    if (charSequence != null) {
                        SendMessagesHelper.getInstance(PhotoViewer.this.currentAccount).sendMessage(charSequence.toString(), jLongValue, (MessageObject) null, (MessageObject) null, (TLRPC$WebPage) null, true, (ArrayList<TLRPC$MessageEntity>) null, (TLRPC$ReplyMarkup) null, (HashMap<String, String>) null, true, 0);
                    }
                    SendMessagesHelper.getInstance(PhotoViewer.this.currentAccount).sendMessage(arrayList, jLongValue, true, 0);
                }
                dialogsActivity.finishFragment();
                if (chatActivity != null) {
                    if (arrayList2.size() == 1) {
                        chatActivity.getUndoView().showWithAction(((Long) arrayList2.get(0)).longValue(), 53, Integer.valueOf(arrayList.size()));
                        return;
                    } else {
                        chatActivity.getUndoView().showWithAction(0L, 53, Integer.valueOf(arrayList.size()), Integer.valueOf(arrayList2.size()), null, null);
                        return;
                    }
                }
                return;
            }
            long jLongValue2 = ((Long) arrayList2.get(0)).longValue();
            int i2 = (int) jLongValue2;
            int i3 = (int) (jLongValue2 >> 32);
            Bundle bundle = new Bundle();
            bundle.putBoolean("scrollToTopOnResume", true);
            if (i2 == 0) {
                bundle.putInt("enc_id", i3);
            } else if (i2 > 0) {
                bundle.putInt("user_id", i2);
            } else {
                bundle.putInt("chat_id", -i2);
            }
            NotificationCenter.getInstance(PhotoViewer.this.currentAccount).postNotificationName(NotificationCenter.closeChats, new Object[0]);
            ChatActivity chatActivity2 = new ChatActivity(bundle);
            if (((LaunchActivity) PhotoViewer.this.parentActivity).presentFragment(chatActivity2, true, false)) {
                chatActivity2.showFieldPanelForForward(true, arrayList);
            } else {
                dialogsActivity.finishFragment();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onItemClick$2(boolean[] zArr, View view) {
            zArr[0] = !zArr[0];
            ((CheckBoxCell) view).setChecked(zArr[0], true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onItemClick$3(boolean[] zArr, DialogInterface dialogInterface, int i) throws IllegalAccessException, NoSuchFieldException, Resources.NotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException {
            ArrayList<Long> arrayList;
            TLRPC$EncryptedChat encryptedChat;
            if (!PhotoViewer.this.imagesArr.isEmpty()) {
                if (PhotoViewer.this.currentIndex < 0 || PhotoViewer.this.currentIndex >= PhotoViewer.this.imagesArr.size()) {
                    return;
                }
                MessageObject messageObject = (MessageObject) PhotoViewer.this.imagesArr.get(PhotoViewer.this.currentIndex);
                if (messageObject.isSent()) {
                    PhotoViewer.this.closePhoto(false, false);
                    ArrayList<Long> arrayList2 = new ArrayList<>();
                    if (PhotoViewer.this.slideshowMessageId.longValue() != 0) {
                        arrayList2.add(PhotoViewer.this.slideshowMessageId);
                    } else {
                        arrayList2.add(Long.valueOf(messageObject.getId()));
                    }
                    if (((int) messageObject.getDialogId()) != 0 || messageObject.messageOwner.random_id == 0) {
                        arrayList = null;
                        encryptedChat = null;
                    } else {
                        ArrayList<Long> arrayList3 = new ArrayList<>();
                        arrayList3.add(Long.valueOf(messageObject.messageOwner.random_id));
                        arrayList = arrayList3;
                        encryptedChat = MessagesController.getInstance(PhotoViewer.this.currentAccount).getEncryptedChat(Integer.valueOf((int) (messageObject.getDialogId() >> 32)));
                    }
                    MessagesController.getInstance(PhotoViewer.this.currentAccount).deleteMessages(arrayList2, arrayList, encryptedChat, messageObject.getDialogId(), messageObject.messageOwner.peer_id.channel_id, zArr[0], messageObject.scheduled);
                    return;
                }
                return;
            }
            if (!PhotoViewer.this.avatarsArr.isEmpty()) {
                if (PhotoViewer.this.currentIndex < 0 || PhotoViewer.this.currentIndex >= PhotoViewer.this.avatarsArr.size()) {
                    return;
                }
                TLRPC$Message tLRPC$Message = (TLRPC$Message) PhotoViewer.this.imagesArrMessages.get(PhotoViewer.this.currentIndex);
                if (tLRPC$Message != null) {
                    ArrayList<Long> arrayList4 = new ArrayList<>();
                    arrayList4.add(Long.valueOf(tLRPC$Message.id));
                    MessagesController.getInstance(PhotoViewer.this.currentAccount).deleteMessages(arrayList4, null, null, MessageObject.getDialogId(tLRPC$Message), tLRPC$Message.peer_id.channel_id, true, false);
                    NotificationCenter.getInstance(PhotoViewer.this.currentAccount).postNotificationName(NotificationCenter.reloadDialogPhotos, new Object[0]);
                }
                if (PhotoViewer.this.isCurrentAvatarSet()) {
                    if (PhotoViewer.this.avatarsDialogId > 0) {
                        MessagesController.getInstance(PhotoViewer.this.currentAccount).deleteUserPhoto(null, false);
                    } else {
                        MessagesController.getInstance(PhotoViewer.this.currentAccount).changeChatAvatar(-PhotoViewer.this.avatarsDialogId, null, null, null, null, 0.0d, null, null, null, null);
                    }
                    PhotoViewer.this.closePhoto(false, false);
                    return;
                }
                TLRPC$Photo tLRPC$Photo = (TLRPC$Photo) PhotoViewer.this.avatarsArr.get(PhotoViewer.this.currentIndex);
                if (tLRPC$Photo == null) {
                    return;
                }
                TLRPC$TL_inputPhoto tLRPC$TL_inputPhoto = new TLRPC$TL_inputPhoto();
                tLRPC$TL_inputPhoto.id = tLRPC$Photo.id;
                tLRPC$TL_inputPhoto.access_hash = tLRPC$Photo.access_hash;
                byte[] bArr = tLRPC$Photo.file_reference;
                tLRPC$TL_inputPhoto.file_reference = bArr;
                tLRPC$TL_inputPhoto.avatar_id = tLRPC$Photo.avatr_id;
                if (bArr == null) {
                    tLRPC$TL_inputPhoto.file_reference = new byte[0];
                }
                if (PhotoViewer.this.avatarsDialogId > 0) {
                    MessagesController.getInstance(PhotoViewer.this.currentAccount).deleteUserPhoto(tLRPC$TL_inputPhoto, false);
                } else {
                    MessagesController.getInstance(PhotoViewer.this.currentAccount).deleteChatPhoto(PhotoViewer.this.avatarsDialogId, tLRPC$TL_inputPhoto);
                }
                PhotoViewer.this.imagesArrLocations.remove(PhotoViewer.this.currentIndex);
                PhotoViewer.this.imagesArrLocationsSizes.remove(PhotoViewer.this.currentIndex);
                PhotoViewer.this.imagesArrLocationsVideo.remove(PhotoViewer.this.currentIndex);
                PhotoViewer.this.imagesArrMessages.remove(PhotoViewer.this.currentIndex);
                PhotoViewer.this.avatarsArr.remove(PhotoViewer.this.currentIndex);
                if (!PhotoViewer.this.imagesArrLocations.isEmpty()) {
                    int size = PhotoViewer.this.currentIndex;
                    if (size >= PhotoViewer.this.avatarsArr.size()) {
                        size = PhotoViewer.this.avatarsArr.size() - 1;
                    }
                    PhotoViewer.this.currentIndex = -1;
                    PhotoViewer.this.setImageIndex(size);
                } else {
                    PhotoViewer.this.closePhoto(false, false);
                }
                if (tLRPC$Message == null) {
                    NotificationCenter.getInstance(PhotoViewer.this.currentAccount).postNotificationName(NotificationCenter.reloadDialogPhotos, new Object[0]);
                    return;
                }
                return;
            }
            if (PhotoViewer.this.secureDocuments.isEmpty() || PhotoViewer.this.placeProvider == null) {
                return;
            }
            PhotoViewer.this.secureDocuments.remove(PhotoViewer.this.currentIndex);
            PhotoViewer.this.placeProvider.deleteImageAtIndex(PhotoViewer.this.currentIndex);
            if (!PhotoViewer.this.secureDocuments.isEmpty()) {
                int size2 = PhotoViewer.this.currentIndex;
                if (size2 >= PhotoViewer.this.secureDocuments.size()) {
                    size2 = PhotoViewer.this.secureDocuments.size() - 1;
                }
                PhotoViewer.this.currentIndex = -1;
                PhotoViewer.this.setImageIndex(size2);
                return;
            }
            PhotoViewer.this.closePhoto(false, false);
        }

        /* JADX WARN: Type inference failed for: r10v15 */
        /* JADX WARN: Type inference failed for: r10v16, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r10v17 */
        @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
        public void onItemClick(int i) throws IllegalAccessException, NoSuchFieldException, Resources.NotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException {
            TLObject tLObject;
            boolean zCanRevokeMessageForAll;
            int dialogId;
            TLRPC$Chat chat;
            TLRPC$User user;
            boolean zIsVideo;
            final ?? r10;
            File pathToMessage;
            boolean z = true;
            if (i == -1) {
                if (PhotoViewer.this.needCaptionLayout && (PhotoViewer.this.captionEditText.isPopupShowing() || PhotoViewer.this.captionEditText.isKeyboardVisible())) {
                    PhotoViewer.this.closeCaptionEnter(false);
                    return;
                } else {
                    PhotoViewer.this.closePhoto(true, false);
                    return;
                }
            }
            File file = null;
            if (i == 1) {
                if (Build.VERSION.SDK_INT < 23 || PhotoViewer.this.parentActivity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                    if (PhotoViewer.this.currentMessageObject != null) {
                        if (!(PhotoViewer.this.currentMessageObject.messageOwner.media instanceof TLRPC$TL_messageMediaWebPage) || PhotoViewer.this.currentMessageObject.messageOwner.media.webpage == null || PhotoViewer.this.currentMessageObject.messageOwner.media.webpage.document != null) {
                            pathToMessage = FileLoader.getPathToMessage(PhotoViewer.this.currentMessageObject.messageOwner);
                        } else {
                            PhotoViewer photoViewer = PhotoViewer.this;
                            pathToMessage = FileLoader.getPathToAttach(photoViewer.getFileLocation(photoViewer.currentIndex, null), true);
                        }
                        file = pathToMessage;
                        zIsVideo = PhotoViewer.this.currentMessageObject.isVideo();
                    } else {
                        if (PhotoViewer.this.currentFileLocationVideo != null) {
                            TLRPC$FileLocation fileLocation = PhotoViewer.getFileLocation(PhotoViewer.this.currentFileLocationVideo);
                            String fileLocationExt = PhotoViewer.getFileLocationExt(PhotoViewer.this.currentFileLocationVideo);
                            if (PhotoViewer.this.avatarsDialogId == 0 && !PhotoViewer.this.isEvent) {
                                z = false;
                            }
                            file = FileLoader.getPathToAttach(fileLocation, fileLocationExt, z);
                        } else if (PhotoViewer.this.pageBlocksAdapter != null) {
                            file = PhotoViewer.this.pageBlocksAdapter.getFile(PhotoViewer.this.currentIndex);
                            zIsVideo = PhotoViewer.this.pageBlocksAdapter.isVideo(PhotoViewer.this.currentIndex);
                        }
                        r10 = 0;
                        if (file != null || !file.exists()) {
                            PhotoViewer.this.showDownloadAlert();
                            return;
                        } else {
                            MediaController.saveFile(file.toString(), PhotoViewer.this.parentActivity, r10, null, null, new Runnable() { // from class: org.rbmain.ui.PhotoViewer$11$$ExternalSyntheticLambda4
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f$0.lambda$onItemClick$0(r10);
                                }
                            });
                            return;
                        }
                    }
                    r10 = zIsVideo;
                    if (file != null) {
                    }
                    PhotoViewer.this.showDownloadAlert();
                    return;
                }
                PhotoViewer.this.parentActivity.requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 4);
                return;
            }
            if (i == 2) {
                if (PhotoViewer.this.currentDialogId != 0) {
                    PhotoViewer.this.disableShowCheck = true;
                    Bundle bundle = new Bundle();
                    bundle.putLong("dialog_id", PhotoViewer.this.currentDialogId);
                    int[] iArr = new int[6];
                    Arrays.fill(iArr, 1);
                    iArr[3] = 0;
                    MediaActivity mediaActivity = new MediaActivity(bundle, iArr, null, PhotoViewer.this.sharedMediaType);
                    if (PhotoViewer.this.parentChatActivity != null) {
                        mediaActivity.setChatInfo(PhotoViewer.this.parentChatActivity.getCurrentChatInfo());
                    }
                    PhotoViewer.this.closePhoto(false, false);
                    if (PhotoViewer.this.parentActivity instanceof LaunchActivity) {
                        ((LaunchActivity) PhotoViewer.this.parentActivity).presentFragment(mediaActivity, false, true);
                        return;
                    }
                    return;
                }
                return;
            }
            if (i == 4) {
                if (PhotoViewer.this.currentMessageObject == null) {
                    return;
                }
                Bundle bundle2 = new Bundle();
                long dialogId2 = PhotoViewer.this.currentDialogId;
                if (PhotoViewer.this.currentMessageObject != null) {
                    dialogId2 = PhotoViewer.this.currentMessageObject.getDialogId();
                }
                int i2 = (int) dialogId2;
                int i3 = (int) (dialogId2 >> 32);
                if (i2 == 0) {
                    bundle2.putInt("enc_id", i3);
                } else if (i2 <= 0) {
                    TLRPC$Chat chat2 = MessagesController.getInstance(PhotoViewer.this.currentAccount).getChat(Integer.valueOf(-i2));
                    if (chat2 != null && chat2.migrated_to != null) {
                        bundle2.putInt("migrated_to", i2);
                        i2 = -chat2.migrated_to.channel_id;
                    }
                    bundle2.putInt("chat_id", -i2);
                } else {
                    bundle2.putInt("user_id", i2);
                }
                bundle2.putLong("message_id", PhotoViewer.this.currentMessageObject.getId());
                NotificationCenter.getInstance(PhotoViewer.this.currentAccount).postNotificationName(NotificationCenter.closeChats, new Object[0]);
                if (PhotoViewer.this.parentActivity instanceof LaunchActivity) {
                    LaunchActivity launchActivity = (LaunchActivity) PhotoViewer.this.parentActivity;
                    launchActivity.presentFragment(new ChatActivity(bundle2), launchActivity.getMainFragmentsCount() > 1 || AndroidUtilities.isTablet(), true);
                }
                PhotoViewer.this.closePhoto(false, false);
                PhotoViewer.this.currentMessageObject = null;
                return;
            }
            if (i == 3) {
                if (PhotoViewer.this.currentMessageObject == null || !(PhotoViewer.this.parentActivity instanceof LaunchActivity)) {
                    return;
                }
                ((LaunchActivity) PhotoViewer.this.parentActivity).switchToAccount(PhotoViewer.this.currentMessageObject.currentAccount, true);
                Bundle bundle3 = new Bundle();
                bundle3.putBoolean("onlySelect", true);
                bundle3.putInt("dialogsType", 3);
                DialogsActivity dialogsActivity = new DialogsActivity(bundle3);
                final ArrayList arrayList = new ArrayList();
                arrayList.add(PhotoViewer.this.currentMessageObject);
                final ChatActivity chatActivity = PhotoViewer.this.parentChatActivity;
                dialogsActivity.setDelegate(new DialogsActivity.DialogsActivityDelegate() { // from class: org.rbmain.ui.PhotoViewer$11$$ExternalSyntheticLambda6
                    @Override // org.rbmain.ui.DialogsActivity.DialogsActivityDelegate
                    public final void didSelectDialogs(DialogsActivity dialogsActivity2, ArrayList arrayList2, CharSequence charSequence, boolean z2) {
                        this.f$0.lambda$onItemClick$1(arrayList, chatActivity, dialogsActivity2, arrayList2, charSequence, z2);
                    }
                });
                ((LaunchActivity) PhotoViewer.this.parentActivity).presentFragment(dialogsActivity, false, true);
                PhotoViewer.this.closePhoto(false, false);
                return;
            }
            if (i == 6) {
                if (PhotoViewer.this.parentActivity == null || PhotoViewer.this.placeProvider == null) {
                    return;
                }
                if (PhotoViewer.this.currentMessageObject == null || PhotoViewer.this.currentMessageObject.scheduled) {
                    zCanRevokeMessageForAll = false;
                } else {
                    int dialogId3 = (int) PhotoViewer.this.currentMessageObject.getDialogId();
                    if (dialogId3 < 0) {
                        ChatObject.isChannelAndNotMegaGroup(MessagesController.getInstance(PhotoViewer.this.currentAccount).getChat(Integer.valueOf(-dialogId3)));
                    }
                    zCanRevokeMessageForAll = DialogsProxy.getInstance(PhotoViewer.this.currentAccount).canRevokeMessageForAll(dialogId3, PhotoViewer.this.currentMessageObject);
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(PhotoViewer.this.parentActivity);
                CharSequence deleteMessageString = PhotoViewer.this.placeProvider.getDeleteMessageString();
                if (deleteMessageString == null) {
                    if ((PhotoViewer.this.currentFileLocationVideo == null || PhotoViewer.this.currentFileLocationVideo == PhotoViewer.this.currentFileLocation) && (PhotoViewer.this.currentMessageObject == null || !PhotoViewer.this.currentMessageObject.isVideo())) {
                        if (PhotoViewer.this.currentMessageObject != null && PhotoViewer.this.currentMessageObject.isGif()) {
                            builder.setTitle(LocaleController.getString("AreYouSureDeleteGIFTitle", R.string.AreYouSureDeleteGIFTitle));
                            builder.setMessage(LocaleController.formatString("AreYouSureDeleteGIF", R.string.AreYouSureDeleteGIF, new Object[0]));
                        } else {
                            builder.setTitle(LocaleController.getString("AreYouSureDeletePhotoTitle", R.string.AreYouSureDeletePhotoTitle));
                            builder.setMessage(LocaleController.formatString("AreYouSureDeletePhoto", R.string.AreYouSureDeletePhoto, new Object[0]));
                        }
                    } else {
                        builder.setTitle(LocaleController.getString("AreYouSureDeleteVideoTitle", R.string.AreYouSureDeleteVideoTitle));
                        builder.setMessage(LocaleController.formatString("AreYouSureDeleteVideo", R.string.AreYouSureDeleteVideo, new Object[0]));
                    }
                } else {
                    builder.setTitle(LocaleController.getString("AreYouSureDeletePhotoTitle", R.string.AreYouSureDeletePhotoTitle));
                    builder.setMessage(deleteMessageString);
                }
                final boolean[] zArr = new boolean[1];
                if (PhotoViewer.this.currentMessageObject != null && !PhotoViewer.this.currentMessageObject.scheduled && (dialogId = (int) PhotoViewer.this.currentMessageObject.getDialogId()) != 0) {
                    if (dialogId > 0) {
                        user = MessagesController.getInstance(PhotoViewer.this.currentAccount).getUser(Integer.valueOf(dialogId));
                        chat = null;
                    } else {
                        chat = MessagesController.getInstance(PhotoViewer.this.currentAccount).getChat(Integer.valueOf(-dialogId));
                        user = null;
                    }
                    if ((user != null || chat != null) && (((user != null && user.id != UserConfig.getInstance(PhotoViewer.this.currentAccount).getClientUserId()) || chat != null) && zCanRevokeMessageForAll)) {
                        FrameLayout frameLayout = new FrameLayout(PhotoViewer.this.parentActivity);
                        CheckBoxCell checkBoxCell = new CheckBoxCell(PhotoViewer.this.parentActivity, 1);
                        checkBoxCell.setBackgroundDrawable(Theme.getSelectorDrawable(false));
                        if (chat != null) {
                            checkBoxCell.setText(LocaleController.getString("DeleteForAll", R.string.DeleteForAll), BuildConfig.FLAVOR, false, false);
                        } else {
                            checkBoxCell.setText(LocaleController.formatString("DeleteForUser", R.string.DeleteForUser, UserObject.getFirstName(user)), BuildConfig.FLAVOR, false, false);
                        }
                        checkBoxCell.setPadding(LocaleController.isRTL ? AndroidUtilities.dp(16.0f) : AndroidUtilities.dp(8.0f), 0, LocaleController.isRTL ? AndroidUtilities.dp(8.0f) : AndroidUtilities.dp(16.0f), 0);
                        frameLayout.addView(checkBoxCell, LayoutHelper.createFrame(-1, 48.0f, 51, 0.0f, 0.0f, 0.0f, 0.0f));
                        checkBoxCell.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.PhotoViewer$11$$ExternalSyntheticLambda1
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                PhotoViewer.AnonymousClass11.lambda$onItemClick$2(zArr, view);
                            }
                        });
                        builder.setView(frameLayout);
                        builder.setCustomViewOffset(9);
                    }
                }
                builder.setPositiveButton(LocaleController.getString("Delete", R.string.Delete), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.PhotoViewer$11$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i4) throws IllegalAccessException, NoSuchFieldException, Resources.NotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException {
                        this.f$0.lambda$onItemClick$3(zArr, dialogInterface, i4);
                    }
                });
                builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                AlertDialog alertDialogCreate = builder.create();
                PhotoViewer.this.showAlertDialog(builder);
                TextView textView = (TextView) alertDialogCreate.getButton(-1);
                if (textView != null) {
                    textView.setTextColor(Theme.getColor(Theme.key_text_RedBold));
                    return;
                }
                return;
            }
            if (i == 10 || i == 18) {
                PhotoViewer.this.onSharePressed();
                return;
            }
            if (i == 11) {
                try {
                    if (PhotoViewer.this.currentMessageObject != null) {
                        if (!AndroidUtilities.openForView(PhotoViewer.this.currentMessageObject, PhotoViewer.this.parentActivity)) {
                            PhotoViewer.this.showDownloadAlert();
                        } else {
                            PhotoViewer.this.closePhoto(false, false);
                        }
                    } else if (PhotoViewer.this.pageBlocksAdapter != null) {
                        if (!AndroidUtilities.openForView(PhotoViewer.this.pageBlocksAdapter.getMedia(PhotoViewer.this.currentIndex), PhotoViewer.this.parentActivity)) {
                            PhotoViewer.this.showDownloadAlert();
                        } else {
                            PhotoViewer.this.closePhoto(false, false);
                        }
                    }
                    return;
                } catch (Exception e) {
                    FileLog.e(e);
                    return;
                }
            }
            if (i == 13 || i == 15) {
                if (PhotoViewer.this.parentActivity == null || PhotoViewer.this.currentMessageObject == null) {
                    return;
                }
                if (PhotoViewer.this.currentMessageObject.messageOwner.media instanceof TLRPC$TL_messageMediaPhoto) {
                    tLObject = PhotoViewer.this.currentMessageObject.messageOwner.media.photo;
                } else if (!(PhotoViewer.this.currentMessageObject.messageOwner.media instanceof TLRPC$TL_messageMediaDocument)) {
                    return;
                } else {
                    tLObject = PhotoViewer.this.currentMessageObject.messageOwner.media.document;
                }
                PhotoViewer.this.masksAlert = new StickersAlert(PhotoViewer.this.parentActivity, PhotoViewer.this.currentMessageObject, tLObject) { // from class: org.rbmain.ui.PhotoViewer.11.1
                    @Override // org.rbmain.ui.Components.StickersAlert, org.rbmain.ui.ActionBar.BottomSheet, android.app.Dialog, android.content.DialogInterface
                    public void dismiss() {
                        super.dismiss();
                        if (PhotoViewer.this.masksAlert == this) {
                            PhotoViewer.this.masksAlert = null;
                        }
                    }
                };
                PhotoViewer.this.masksAlert.show();
                return;
            }
            if (i == 5) {
                if (PhotoViewer.this.pipItem.getAlpha() != 1.0f) {
                    return;
                }
                PhotoViewer.this.switchToPip(false);
                return;
            }
            if (i == 7) {
                if (PhotoViewer.this.currentMessageObject == null) {
                    return;
                }
                FileLoader.getInstance(PhotoViewer.this.currentAccount).cancelLoadFile(PhotoViewer.this.currentMessageObject.getDocument());
                PhotoViewer.this.releasePlayer(false);
                PhotoViewer.this.bottomLayout.setTag(num);
                PhotoViewer.this.bottomLayout.setVisibility(0);
                return;
            }
            if (i == 14) {
                if (PhotoViewer.this.currentMessageObject != null) {
                    TLRPC$Document document = PhotoViewer.this.currentMessageObject.getDocument();
                    if (PhotoViewer.this.parentChatActivity == null || PhotoViewer.this.parentChatActivity.chatActivityEnterView == null) {
                        MediaDataController.getInstance(PhotoViewer.this.currentAccount).addRecentGif(document, (int) (System.currentTimeMillis() / 1000));
                    } else {
                        PhotoViewer.this.parentChatActivity.chatActivityEnterView.addRecentGif(document);
                    }
                    MessagesController.getInstance(PhotoViewer.this.currentAccount).saveGif(PhotoViewer.this.currentMessageObject, document);
                    return;
                }
                if (PhotoViewer.this.pageBlocksAdapter != null) {
                    TLObject media = PhotoViewer.this.pageBlocksAdapter.getMedia(PhotoViewer.this.currentIndex);
                    if (media instanceof TLRPC$Document) {
                        TLRPC$Document tLRPC$Document = (TLRPC$Document) media;
                        MediaDataController.getInstance(PhotoViewer.this.currentAccount).addRecentGif(tLRPC$Document, (int) (System.currentTimeMillis() / 1000));
                        MessagesController.getInstance(PhotoViewer.this.currentAccount).saveGif(PhotoViewer.this.pageBlocksAdapter.getParentObject(), tLRPC$Document);
                        return;
                    }
                    return;
                }
                return;
            }
            if (i != 16) {
                if (i == 17) {
                    File pathToAttach = FileLoader.getPathToAttach(PhotoViewer.getFileLocation(PhotoViewer.this.currentFileLocationVideo), PhotoViewer.getFileLocationExt(PhotoViewer.this.currentFileLocationVideo), true);
                    boolean z2 = PhotoViewer.this.currentFileLocationVideo.imageType == 2;
                    PhotoViewer.this.placeProvider.openPhotoForEdit(pathToAttach.getAbsolutePath(), z2 ? FileLoader.getPathToAttach(PhotoViewer.getFileLocation(PhotoViewer.this.currentFileLocation), PhotoViewer.getFileLocationExt(PhotoViewer.this.currentFileLocation), true).getAbsolutePath() : null, z2);
                    return;
                }
                return;
            }
            final TLRPC$Photo tLRPC$Photo = (TLRPC$Photo) PhotoViewer.this.avatarsArr.get(PhotoViewer.this.currentIndex);
            if (tLRPC$Photo == null || tLRPC$Photo.sizes.isEmpty()) {
                return;
            }
            TLRPC$PhotoSize closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(tLRPC$Photo.sizes, MediaController.MAX_WIDTH_HEIGHT_SIZE);
            TLRPC$PhotoSize closestPhotoSizeWithSize2 = FileLoader.getClosestPhotoSizeWithSize(tLRPC$Photo.sizes, 90);
            final UserConfig userConfig = UserConfig.getInstance(PhotoViewer.this.currentAccount);
            if (PhotoViewer.this.avatarsDialogId != userConfig.clientUserId) {
                TLRPC$Chat chat3 = MessagesController.getInstance(PhotoViewer.this.currentAccount).getChat(Integer.valueOf(-PhotoViewer.this.avatarsDialogId));
                if (chat3 == null) {
                    return;
                }
                TLRPC$TL_inputChatPhoto tLRPC$TL_inputChatPhoto = new TLRPC$TL_inputChatPhoto();
                TLRPC$TL_inputPhoto tLRPC$TL_inputPhoto = new TLRPC$TL_inputPhoto();
                tLRPC$TL_inputChatPhoto.id = tLRPC$TL_inputPhoto;
                tLRPC$TL_inputPhoto.id = tLRPC$Photo.id;
                tLRPC$TL_inputPhoto.access_hash = tLRPC$Photo.access_hash;
                tLRPC$TL_inputPhoto.file_reference = tLRPC$Photo.file_reference;
                MessagesController.getInstance(PhotoViewer.this.currentAccount).changeChatAvatar(-PhotoViewer.this.avatarsDialogId, tLRPC$TL_inputChatPhoto, null, null, null, 0.0d, null, null, null, null);
                TLRPC$ChatPhoto tLRPC$ChatPhoto = chat3.photo;
                tLRPC$ChatPhoto.dc_id = tLRPC$Photo.dc_id;
                tLRPC$ChatPhoto.photo_small = closestPhotoSizeWithSize2.location;
                tLRPC$ChatPhoto.photo_big = closestPhotoSizeWithSize.location;
                NotificationCenter.getInstance(PhotoViewer.this.currentAccount).postNotificationName(NotificationCenter.updateInterfaces, 2);
            } else {
                TLRPC$TL_photos_updateProfilePhoto tLRPC$TL_photos_updateProfilePhoto = new TLRPC$TL_photos_updateProfilePhoto();
                TLRPC$TL_inputPhoto tLRPC$TL_inputPhoto2 = new TLRPC$TL_inputPhoto();
                tLRPC$TL_photos_updateProfilePhoto.id = tLRPC$TL_inputPhoto2;
                tLRPC$TL_inputPhoto2.id = tLRPC$Photo.id;
                tLRPC$TL_inputPhoto2.access_hash = tLRPC$Photo.access_hash;
                tLRPC$TL_inputPhoto2.file_reference = tLRPC$Photo.file_reference;
                long j = tLRPC$Photo.main_file_id;
                tLRPC$TL_inputPhoto2.main_id = j;
                tLRPC$TL_inputPhoto2.thumb_id = j;
                AccountInstance.getInstance(PhotoViewer.this.currentAccount).getFileProxy().setAsMainAvatar(tLRPC$TL_photos_updateProfilePhoto, new RequestDelegate() { // from class: org.rbmain.ui.PhotoViewer$11$$ExternalSyntheticLambda5
                    @Override // org.rbmain.tgnet.RequestDelegate
                    public final void run(TLObject tLObject2, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$onItemClick$5(userConfig, tLRPC$Photo, tLObject2, tLRPC$TL_error);
                    }
                });
                TLRPC$User user2 = MessagesController.getInstance(PhotoViewer.this.currentAccount).getUser(Integer.valueOf(userConfig.clientUserId));
                if (user2 != null) {
                    TLRPC$UserProfilePhoto tLRPC$UserProfilePhoto = user2.photo;
                    tLRPC$UserProfilePhoto.photo_id = tLRPC$Photo.id;
                    tLRPC$UserProfilePhoto.dc_id = tLRPC$Photo.dc_id;
                    tLRPC$UserProfilePhoto.photo_small = closestPhotoSizeWithSize2.location;
                    tLRPC$UserProfilePhoto.photo_big = closestPhotoSizeWithSize.location;
                    userConfig.setCurrentUser(user2);
                    userConfig.saveConfig(true);
                    NotificationCenter.getInstance(PhotoViewer.this.currentAccount).postNotificationName(NotificationCenter.mainUserInfoChanged, new Object[0]);
                }
            }
            PhotoViewer.this.currentAvatarLocation = ImageLocation.getForPhoto(closestPhotoSizeWithSize, tLRPC$Photo);
            PhotoViewer.this.avatarsArr.remove(PhotoViewer.this.currentIndex);
            PhotoViewer.this.avatarsArr.add(0, tLRPC$Photo);
            ImageLocation imageLocation = (ImageLocation) PhotoViewer.this.imagesArrLocations.get(PhotoViewer.this.currentIndex);
            PhotoViewer.this.imagesArrLocations.remove(PhotoViewer.this.currentIndex);
            PhotoViewer.this.imagesArrLocations.add(0, imageLocation);
            ImageLocation imageLocation2 = (ImageLocation) PhotoViewer.this.imagesArrLocationsVideo.get(PhotoViewer.this.currentIndex);
            PhotoViewer.this.imagesArrLocationsVideo.remove(PhotoViewer.this.currentIndex);
            PhotoViewer.this.imagesArrLocationsVideo.add(0, imageLocation2);
            Integer num = (Integer) PhotoViewer.this.imagesArrLocationsSizes.get(PhotoViewer.this.currentIndex);
            PhotoViewer.this.imagesArrLocationsSizes.remove(PhotoViewer.this.currentIndex);
            PhotoViewer.this.imagesArrLocationsSizes.add(0, num);
            TLRPC$Message tLRPC$Message = (TLRPC$Message) PhotoViewer.this.imagesArrMessages.get(PhotoViewer.this.currentIndex);
            PhotoViewer.this.imagesArrMessages.remove(PhotoViewer.this.currentIndex);
            PhotoViewer.this.imagesArrMessages.add(0, tLRPC$Message);
            PhotoViewer.this.currentIndex = -1;
            PhotoViewer.this.setImageIndex(0);
            PhotoViewer.this.groupedPhotosListView.clear();
            PhotoViewer.this.groupedPhotosListView.fillList();
            PhotoViewer.this.hintView.showWithAction(PhotoViewer.this.avatarsDialogId, 22, PhotoViewer.this.currentFileLocationVideo == PhotoViewer.this.currentFileLocation ? null : 1);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.PhotoViewer$11$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onItemClick$6();
                }
            }, 300L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onItemClick$5(final UserConfig userConfig, final TLRPC$Photo tLRPC$Photo, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.PhotoViewer$11$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onItemClick$4(tLObject, userConfig, tLRPC$Photo);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onItemClick$4(TLObject tLObject, UserConfig userConfig, TLRPC$Photo tLRPC$Photo) {
            if (tLObject instanceof TLRPC$TL_photos_photo) {
                TLRPC$TL_photos_photo tLRPC$TL_photos_photo = (TLRPC$TL_photos_photo) tLObject;
                MessagesController.getInstance(PhotoViewer.this.currentAccount).putUsers(tLRPC$TL_photos_photo.users, false);
                TLRPC$User user = MessagesController.getInstance(PhotoViewer.this.currentAccount).getUser(Integer.valueOf(userConfig.clientUserId));
                if (tLRPC$TL_photos_photo.photo instanceof TLRPC$TL_photo) {
                    int iIndexOf = PhotoViewer.this.avatarsArr.indexOf(tLRPC$Photo);
                    if (iIndexOf >= 0) {
                        PhotoViewer.this.avatarsArr.set(iIndexOf, tLRPC$TL_photos_photo.photo);
                    }
                    if (user != null) {
                        user.photo.photo_id = tLRPC$TL_photos_photo.photo.id;
                        userConfig.setCurrentUser(user);
                        userConfig.saveConfig(true);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onItemClick$6() {
            if (PhotoViewer.this.menuItem == null) {
                return;
            }
            PhotoViewer.this.menuItem.hideSubItem(16);
        }

        @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
        public boolean canOpenMenu() {
            boolean z = true;
            if (PhotoViewer.this.currentMessageObject != null || PhotoViewer.this.currentSecureDocument != null) {
                return true;
            }
            if (PhotoViewer.this.currentFileLocationVideo == null) {
                return PhotoViewer.this.pageBlocksAdapter != null;
            }
            TLRPC$FileLocation fileLocation = PhotoViewer.getFileLocation(PhotoViewer.this.currentFileLocationVideo);
            String fileLocationExt = PhotoViewer.getFileLocationExt(PhotoViewer.this.currentFileLocationVideo);
            if (PhotoViewer.this.avatarsDialogId == 0 && !PhotoViewer.this.isEvent) {
                z = false;
            }
            return FileLoader.getPathToAttach(fileLocation, fileLocationExt, z).exists();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setParentActivity$3(View view) {
        Activity activity = this.parentActivity;
        if (activity == null) {
            return;
        }
        this.wasRotated = false;
        this.fullscreenedByButton = 1;
        if (this.prevOrientation == -10) {
            this.prevOrientation = activity.getRequestedOrientation();
        }
        if (((WindowManager) this.parentActivity.getSystemService("window")).getDefaultDisplay().getRotation() == 3) {
            this.parentActivity.setRequestedOrientation(8);
        } else {
            this.parentActivity.setRequestedOrientation(0);
        }
        toggleActionBar(false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setParentActivity$5(View view) {
        openCurrentPhotoInPaintModeForSelect();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setParentActivity$6(View view) {
        onSharePressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setParentActivity$7(View view) {
        this.selectedCompression = this.previousCompression;
        didChangedCompressionLevel(false);
        showQualityView(false);
        requestVideoPreview(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setParentActivity$8(View view) {
        showQualityView(false);
        requestVideoPreview(2);
    }

    /* renamed from: org.rbmain.ui.PhotoViewer$21, reason: invalid class name */
    class AnonymousClass21 implements VideoTimelinePlayView.VideoTimelineViewDelegate {
        private int seekTo;
        private Runnable seekToRunnable;
        private boolean wasPlaying;

        AnonymousClass21() {
        }

        @Override // org.rbmain.ui.Components.VideoTimelinePlayView.VideoTimelineViewDelegate
        public void onLeftProgressChanged(float f) {
            if (PhotoViewer.this.videoPlayer == null) {
                return;
            }
            if (PhotoViewer.this.videoPlayer.isPlaying()) {
                PhotoViewer.this.manuallyPaused = false;
                PhotoViewer.this.videoPlayer.pause();
                PhotoViewer.this.containerView.invalidate();
            }
            updateAvatarStartTime(1);
            seekTo(f);
            PhotoViewer.this.videoPlayerSeekbar.setProgress(0.0f);
            PhotoViewer.this.videoTimelineView.setProgress(f);
            PhotoViewer.this.updateVideoInfo();
        }

        @Override // org.rbmain.ui.Components.VideoTimelinePlayView.VideoTimelineViewDelegate
        public void onRightProgressChanged(float f) {
            if (PhotoViewer.this.videoPlayer == null) {
                return;
            }
            if (PhotoViewer.this.videoPlayer.isPlaying()) {
                PhotoViewer.this.manuallyPaused = false;
                PhotoViewer.this.videoPlayer.pause();
                PhotoViewer.this.containerView.invalidate();
            }
            updateAvatarStartTime(2);
            seekTo(f);
            PhotoViewer.this.videoPlayerSeekbar.setProgress(1.0f);
            PhotoViewer.this.videoTimelineView.setProgress(f);
            PhotoViewer.this.updateVideoInfo();
        }

        @Override // org.rbmain.ui.Components.VideoTimelinePlayView.VideoTimelineViewDelegate
        public void onPlayProgressChanged(float f) {
            if (PhotoViewer.this.videoPlayer == null) {
                return;
            }
            if (PhotoViewer.this.sendPhotoType == 1) {
                updateAvatarStartTime(0);
            }
            seekTo(f);
        }

        private void seekTo(float f) {
            this.seekTo = (int) (PhotoViewer.this.videoDuration * f);
            if (this.seekToRunnable == null) {
                Runnable runnable = new Runnable() { // from class: org.rbmain.ui.PhotoViewer$21$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$seekTo$0();
                    }
                };
                this.seekToRunnable = runnable;
                AndroidUtilities.runOnUIThread(runnable, 100L);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$seekTo$0() {
            if (PhotoViewer.this.videoPlayer != null) {
                PhotoViewer.this.videoPlayer.seekTo(this.seekTo);
            }
            if (PhotoViewer.this.sendPhotoType == 1) {
                PhotoViewer.this.needCaptureFrameReadyAtTime = this.seekTo;
                if (PhotoViewer.this.captureFrameReadyAtTime != PhotoViewer.this.needCaptureFrameReadyAtTime) {
                    PhotoViewer.this.captureFrameReadyAtTime = -1L;
                }
            }
            this.seekToRunnable = null;
        }

        private void updateAvatarStartTime(int i) {
            if (PhotoViewer.this.sendPhotoType != 1) {
                return;
            }
            if (i != 0) {
                if (PhotoViewer.this.photoCropView != null) {
                    if (PhotoViewer.this.videoTimelineView.getLeftProgress() > PhotoViewer.this.avatarStartProgress || PhotoViewer.this.videoTimelineView.getRightProgress() < PhotoViewer.this.avatarStartProgress) {
                        PhotoViewer.this.photoCropView.setVideoThumbVisible(false);
                        if (i == 1) {
                            PhotoViewer photoViewer = PhotoViewer.this;
                            photoViewer.avatarStartTime = (long) (photoViewer.videoDuration * 1000.0f * PhotoViewer.this.videoTimelineView.getLeftProgress());
                        } else {
                            PhotoViewer photoViewer2 = PhotoViewer.this;
                            photoViewer2.avatarStartTime = (long) (photoViewer2.videoDuration * 1000.0f * PhotoViewer.this.videoTimelineView.getRightProgress());
                        }
                        PhotoViewer.this.captureFrameAtTime = -1L;
                        return;
                    }
                    return;
                }
                return;
            }
            PhotoViewer photoViewer3 = PhotoViewer.this;
            photoViewer3.avatarStartProgress = photoViewer3.videoTimelineView.getProgress();
            PhotoViewer photoViewer4 = PhotoViewer.this;
            photoViewer4.avatarStartTime = (long) (photoViewer4.videoDuration * 1000.0f * PhotoViewer.this.avatarStartProgress);
        }

        @Override // org.rbmain.ui.Components.VideoTimelinePlayView.VideoTimelineViewDelegate
        public void didStartDragging(int i) {
            if (i == VideoTimelinePlayView.TYPE_PROGRESS) {
                PhotoViewer.this.cancelVideoPlayRunnable();
                if (PhotoViewer.this.sendPhotoType == 1) {
                    PhotoViewer.this.cancelFlashAnimations();
                    PhotoViewer.this.captureFrameAtTime = -1L;
                }
                boolean z = PhotoViewer.this.videoPlayer != null && PhotoViewer.this.videoPlayer.isPlaying();
                this.wasPlaying = z;
                if (z) {
                    PhotoViewer.this.manuallyPaused = false;
                    PhotoViewer.this.videoPlayer.pause();
                    PhotoViewer.this.containerView.invalidate();
                }
            }
        }

        @Override // org.rbmain.ui.Components.VideoTimelinePlayView.VideoTimelineViewDelegate
        public void didStopDragging(int i) {
            Runnable runnable = this.seekToRunnable;
            if (runnable != null) {
                AndroidUtilities.cancelRunOnUIThread(runnable);
                this.seekToRunnable.run();
            }
            PhotoViewer.this.cancelVideoPlayRunnable();
            if (PhotoViewer.this.sendPhotoType != 1 || PhotoViewer.this.flashView == null || i != VideoTimelinePlayView.TYPE_PROGRESS) {
                if (PhotoViewer.this.sendPhotoType == 1 || this.wasPlaying) {
                    PhotoViewer.this.manuallyPaused = false;
                    if (PhotoViewer.this.videoPlayer != null) {
                        PhotoViewer.this.videoPlayer.play();
                        return;
                    }
                    return;
                }
                return;
            }
            PhotoViewer.this.cancelFlashAnimations();
            PhotoViewer photoViewer = PhotoViewer.this;
            photoViewer.captureFrameAtTime = photoViewer.avatarStartTime;
            if (PhotoViewer.this.captureFrameReadyAtTime == this.seekTo) {
                PhotoViewer.this.captureCurrentFrame();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setParentActivity$9(View view) {
        if (this.captionEditText.getCaptionLimitOffset() < 0) {
            AndroidUtilities.shakeView(this.captionLimitView, 2.0f, 0);
            Vibrator vibrator = (Vibrator) this.captionLimitView.getContext().getSystemService("vibrator");
            if (vibrator != null) {
                vibrator.vibrate(200L);
                return;
            }
            return;
        }
        ChatActivity chatActivity = this.parentChatActivity;
        if (chatActivity != null && chatActivity.isInScheduleMode() && !this.parentChatActivity.isEditingMessageMedia()) {
            showScheduleDatePickerDialog();
        } else {
            sendPressed(true, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ boolean lambda$setParentActivity$13(android.view.View r15) {
        /*
            Method dump skipped, instructions count: 522
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.PhotoViewer.lambda$setParentActivity$13(android.view.View):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$setParentActivity$10(View view, MotionEvent motionEvent) {
        ActionBarPopupWindow actionBarPopupWindow;
        if (motionEvent.getActionMasked() != 0 || (actionBarPopupWindow = this.sendPopupWindow) == null || !actionBarPopupWindow.isShowing()) {
            return false;
        }
        view.getHitRect(this.hitRect);
        if (this.hitRect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        this.sendPopupWindow.dismiss();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setParentActivity$11(KeyEvent keyEvent) {
        ActionBarPopupWindow actionBarPopupWindow;
        if (keyEvent.getKeyCode() == 4 && keyEvent.getRepeatCount() == 0 && (actionBarPopupWindow = this.sendPopupWindow) != null && actionBarPopupWindow.isShowing()) {
            this.sendPopupWindow.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setParentActivity$12(int i, View view) {
        ActionBarPopupWindow actionBarPopupWindow = this.sendPopupWindow;
        if (actionBarPopupWindow != null && actionBarPopupWindow.isShowing()) {
            this.sendPopupWindow.dismiss();
        }
        if (i == 0) {
            showScheduleDatePickerDialog();
            return;
        }
        if (i == 1) {
            sendPressed(false, 0);
        } else if (i == 2) {
            replacePressed();
        } else if (i == 3) {
            sendPressed(true, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setParentActivity$14(View view) {
        if (this.captionEditText.getTag() != null) {
            return;
        }
        if (this.isCurrentVideo) {
            if (!this.videoConvertSupported) {
                return;
            }
            TextureView textureView = this.videoTextureView;
            if (!(textureView instanceof VideoEditTextureView)) {
                return;
            }
            VideoEditTextureView videoEditTextureView = (VideoEditTextureView) textureView;
            if (videoEditTextureView.getVideoWidth() <= 0 || videoEditTextureView.getVideoHeight() <= 0) {
                return;
            }
        }
        switchToEditMode(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setParentActivity$15(View view) {
        PhotoCropView photoCropView = this.photoCropView;
        if (photoCropView == null) {
            return;
        }
        if (photoCropView.rotate()) {
            this.rotateItem.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_dialogFloatingButton), PorterDuff.Mode.MULTIPLY));
        } else {
            this.rotateItem.setColorFilter((ColorFilter) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setParentActivity$16(View view) {
        PhotoCropView photoCropView = this.photoCropView;
        if (photoCropView == null) {
            return;
        }
        if (photoCropView.mirror()) {
            this.mirrorItem.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_dialogFloatingButton), PorterDuff.Mode.MULTIPLY));
        } else {
            this.mirrorItem.setColorFilter((ColorFilter) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setParentActivity$17(View view) {
        if (this.captionEditText.getTag() != null) {
            return;
        }
        if (this.isCurrentVideo) {
            if (!this.videoConvertSupported) {
                return;
            }
            TextureView textureView = this.videoTextureView;
            if (!(textureView instanceof VideoEditTextureView)) {
                return;
            }
            VideoEditTextureView videoEditTextureView = (VideoEditTextureView) textureView;
            if (videoEditTextureView.getVideoWidth() <= 0 || videoEditTextureView.getVideoHeight() <= 0) {
                return;
            }
        }
        switchToEditMode(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setParentActivity$18(View view) {
        if (this.captionEditText.getTag() != null) {
            return;
        }
        this.muteVideo = !this.muteVideo;
        updateMuteButton();
        updateVideoInfo();
        if (this.muteVideo && !this.checkImageView.isChecked()) {
            this.checkImageView.callOnClick();
            return;
        }
        Object obj = this.imagesArrLocals.get(this.currentIndex);
        if (obj instanceof MediaController.MediaEditState) {
            ((MediaController.MediaEditState) obj).editedInfo = getCurrentVideoEditedInfo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setParentActivity$19(View view) {
        if (this.placeProvider == null || this.captionEditText.getTag() != null) {
            return;
        }
        this.placeProvider.needAddMorePhotos();
        closePhoto(true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setParentActivity$20(View view) {
        if (this.captionEditText.getTag() != null) {
            return;
        }
        if (this.isCurrentVideo) {
            if (!this.videoConvertSupported) {
                return;
            }
            TextureView textureView = this.videoTextureView;
            if (!(textureView instanceof VideoEditTextureView)) {
                return;
            }
            VideoEditTextureView videoEditTextureView = (VideoEditTextureView) textureView;
            if (videoEditTextureView.getVideoWidth() <= 0 || videoEditTextureView.getVideoHeight() <= 0) {
                return;
            }
        }
        switchToEditMode(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setParentActivity$21(Activity activity, View view) {
        if (this.captionEditText.getTag() != null || this.muteVideo) {
            return;
        }
        if (this.compressItem.getTag() == null) {
            if (this.videoConvertSupported) {
                if (this.tooltip == null) {
                    this.tooltip = new Tooltip(activity, this.containerView, -871296751, -1);
                }
                this.tooltip.setText(LocaleController.getString("VideoQualityIsTooLow", R.string.VideoQualityIsTooLow));
                this.tooltip.show(this.compressItem);
                return;
            }
            return;
        }
        showQualityView(true);
        requestVideoPreview(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setParentActivity$27(View view) {
        int i;
        String str;
        int i2;
        if (this.parentActivity == null || this.captionEditText.getTag() != null) {
            return;
        }
        BottomSheet.Builder builder = new BottomSheet.Builder(this.parentActivity);
        builder.setUseHardwareLayer(false);
        LinearLayout linearLayout = new LinearLayout(this.parentActivity);
        linearLayout.setOrientation(1);
        builder.setCustomView(linearLayout);
        TextView textView = new TextView(this.parentActivity);
        textView.setLines(1);
        textView.setSingleLine(true);
        textView.setText(LocaleController.getString("MessageLifetime", R.string.MessageLifetime));
        textView.setTextColor(-1);
        textView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        textView.setTextSize(1, 20.0f);
        textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        textView.setPadding(AndroidUtilities.dp(21.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(21.0f), AndroidUtilities.dp(4.0f));
        textView.setGravity(16);
        linearLayout.addView(textView, LayoutHelper.createFrame(-1, -2.0f));
        textView.setOnTouchListener(new View.OnTouchListener() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda40
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return PhotoViewer.lambda$setParentActivity$22(view2, motionEvent);
            }
        });
        TextView textView2 = new TextView(this.parentActivity);
        if (this.isCurrentVideo) {
            i = R.string.MessageLifetimeVideo;
            str = "MessageLifetimeVideo";
        } else {
            i = R.string.MessageLifetimePhoto;
            str = "MessageLifetimePhoto";
        }
        textView2.setText(LocaleController.getString(str, i));
        textView2.setTextColor(-8355712);
        textView2.setTextSize(1, 14.0f);
        textView2.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        textView2.setPadding(AndroidUtilities.dp(21.0f), 0, AndroidUtilities.dp(21.0f), AndroidUtilities.dp(8.0f));
        textView2.setGravity(16);
        linearLayout.addView(textView2, LayoutHelper.createFrame(-1, -2.0f));
        textView2.setOnTouchListener(new View.OnTouchListener() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda39
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return PhotoViewer.lambda$setParentActivity$23(view2, motionEvent);
            }
        });
        final BottomSheet bottomSheetCreate = builder.create();
        final NumberPicker numberPicker = new NumberPicker(this.parentActivity);
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(28);
        Object obj = this.imagesArrLocals.get(this.currentIndex);
        if (obj instanceof MediaController.PhotoEntry) {
            i2 = ((MediaController.PhotoEntry) obj).ttl;
        } else {
            i2 = obj instanceof MediaController.SearchImage ? ((MediaController.SearchImage) obj).ttl : 0;
        }
        if (i2 == 0) {
            numberPicker.setValue(MessagesController.getGlobalMainSettings().getInt("self_destruct", 7));
        } else if (i2 >= 0 && i2 < 21) {
            numberPicker.setValue(i2);
        } else {
            numberPicker.setValue(((i2 / 5) + 21) - 5);
        }
        numberPicker.setTextColor(-1);
        numberPicker.setSelectorColor(-11711155);
        numberPicker.setFormatter(new NumberPicker.Formatter() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda63
            @Override // org.rbmain.ui.Components.NumberPicker.Formatter
            public final String format(int i3) {
                return PhotoViewer.lambda$setParentActivity$24(i3);
            }
        });
        linearLayout.addView(numberPicker, LayoutHelper.createLinear(-1, -2));
        FrameLayout frameLayout = new FrameLayout(this, this.parentActivity) { // from class: org.rbmain.ui.PhotoViewer.24
            @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean z, int i3, int i4, int i5, int i6) {
                int childCount = getChildCount();
                int i7 = i5 - i3;
                for (int i8 = 0; i8 < childCount; i8++) {
                    View childAt = getChildAt(i8);
                    if (((Integer) childAt.getTag()).intValue() == -1) {
                        childAt.layout((i7 - getPaddingRight()) - childAt.getMeasuredWidth(), getPaddingTop(), i7 - getPaddingRight(), getPaddingTop() + childAt.getMeasuredHeight());
                    } else if (((Integer) childAt.getTag()).intValue() == -2) {
                        int paddingLeft = getPaddingLeft();
                        childAt.layout(paddingLeft, getPaddingTop(), childAt.getMeasuredWidth() + paddingLeft, getPaddingTop() + childAt.getMeasuredHeight());
                    } else {
                        childAt.layout(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + childAt.getMeasuredWidth(), getPaddingTop() + childAt.getMeasuredHeight());
                    }
                }
            }
        };
        frameLayout.setPadding(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f));
        linearLayout.addView(frameLayout, LayoutHelper.createLinear(-1, 52));
        TextView textView3 = new TextView(this.parentActivity);
        textView3.setMinWidth(AndroidUtilities.dp(64.0f));
        textView3.setTag(-1);
        textView3.setTextSize(1, 14.0f);
        textView3.setTextColor(Theme.getColor(Theme.key_dialogFloatingButton));
        textView3.setGravity(17);
        textView3.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        textView3.setText(LocaleController.getString("Done", R.string.Done).toUpperCase());
        textView3.setBackgroundDrawable(Theme.getRoundRectSelectorDrawable(-11944718));
        textView3.setPadding(AndroidUtilities.dp(10.0f), 0, AndroidUtilities.dp(10.0f), 0);
        frameLayout.addView(textView3, LayoutHelper.createFrame(-2, 36, 53));
        textView3.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda36
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$setParentActivity$25(numberPicker, bottomSheetCreate, view2);
            }
        });
        TextView textView4 = new TextView(this.parentActivity);
        textView4.setMinWidth(AndroidUtilities.dp(64.0f));
        textView4.setTag(-2);
        textView4.setTextSize(1, 14.0f);
        textView4.setTextColor(-1);
        textView4.setGravity(17);
        textView4.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        textView4.setText(LocaleController.getString("Cancel", R.string.Cancel).toUpperCase());
        textView4.setBackgroundDrawable(Theme.getRoundRectSelectorDrawable(-1));
        textView4.setPadding(AndroidUtilities.dp(10.0f), 0, AndroidUtilities.dp(10.0f), 0);
        frameLayout.addView(textView4, LayoutHelper.createFrame(-2, 36, 53));
        textView4.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                bottomSheetCreate.dismiss();
            }
        });
        bottomSheetCreate.show();
        bottomSheetCreate.setBackgroundColor(-16777216);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$setParentActivity$24(int i) {
        if (i == 0) {
            return LocaleController.getString("ShortMessageLifetimeForever", R.string.ShortMessageLifetimeForever);
        }
        if (i >= 1 && i < 21) {
            return LocaleController.formatTTLString(i);
        }
        return LocaleController.formatTTLString((i - 16) * 5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setParentActivity$25(NumberPicker numberPicker, BottomSheet bottomSheet, View view) {
        int value = numberPicker.getValue();
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putInt("self_destruct", value);
        editorEdit.apply();
        bottomSheet.dismiss();
        if (value < 0 || value >= 21) {
            value = (value - 16) * 5;
        }
        Object obj = this.imagesArrLocals.get(this.currentIndex);
        if (obj instanceof MediaController.PhotoEntry) {
            ((MediaController.PhotoEntry) obj).ttl = value;
        } else if (obj instanceof MediaController.SearchImage) {
            ((MediaController.SearchImage) obj).ttl = value;
        }
        this.timeItem.setColorFilter(value != 0 ? new PorterDuffColorFilter(Theme.getColor(Theme.key_dialogFloatingButton), PorterDuff.Mode.MULTIPLY) : null);
        if (this.checkImageView.isChecked()) {
            return;
        }
        this.checkImageView.callOnClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setParentActivity$28(View view) {
        this.cropTransform.setViewTransform(this.previousHasTransform, this.previousCropPx, this.previousCropPy, this.previousCropRotation, this.previousCropOrientation, this.previousCropScale, 1.0f, 1.0f, this.previousCropPw, this.previousCropPh, 0.0f, 0.0f, this.previousCropMirrored);
        switchToEditMode(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setParentActivity$29(View view) {
        if (this.currentEditMode != 1 || this.photoCropView.isReady()) {
            applyCurrentEditMode();
            switchToEditMode(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setParentActivity$30(View view) {
        this.photoCropView.reset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setParentActivity$31(ImageReceiver imageReceiver, boolean z, boolean z2, boolean z3) {
        PhotoViewerProvider photoViewerProvider;
        Bitmap bitmap;
        if (imageReceiver == this.centerImage && z && !z2) {
            if (!this.isCurrentVideo && ((this.currentEditMode == 1 || this.sendPhotoType == 1) && this.photoCropView != null && (bitmap = imageReceiver.getBitmap()) != null)) {
                this.photoCropView.setBitmap(bitmap, imageReceiver.getOrientation(), this.sendPhotoType != 1, true, this.paintingOverlay, this.cropTransform, null, null);
            }
            if (this.paintingOverlay.getVisibility() == 0) {
                this.containerView.requestLayout();
            }
            detectFaces();
        }
        if (imageReceiver != this.centerImage || !z || (photoViewerProvider = this.placeProvider) == null || !photoViewerProvider.scaleToFill() || this.ignoreDidSetImage || this.sendPhotoType == 1) {
            return;
        }
        if (!this.wasLayout) {
            this.dontResetZoomOnFirstLayout = true;
        } else {
            setScaleToFill();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setParentActivity$32(View view) {
        if (this.captionEditText.getTag() != null) {
            return;
        }
        setPhotoChecked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setParentActivity$33(View view) {
        PhotoViewerProvider photoViewerProvider;
        if (this.captionEditText.getTag() != null || (photoViewerProvider = this.placeProvider) == null || photoViewerProvider.getSelectedPhotosOrder() == null || this.placeProvider.getSelectedPhotosOrder().isEmpty()) {
            return;
        }
        togglePhotosListView(!this.isPhotosListViewVisible, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setParentActivity$34(View view, int i) throws IllegalAccessException, NoSuchFieldException, Resources.NotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException {
        int i2;
        if (!this.imagesArrLocals.isEmpty() && (i2 = this.currentIndex) >= 0 && i2 < this.imagesArrLocals.size()) {
            Object obj = this.imagesArrLocals.get(this.currentIndex);
            if (obj instanceof MediaController.MediaEditState) {
                ((MediaController.MediaEditState) obj).editedInfo = getCurrentVideoEditedInfo();
            }
        }
        this.ignoreDidSetImage = true;
        int iIndexOf = this.imagesArrLocals.indexOf(view.getTag());
        if (iIndexOf >= 0) {
            this.currentIndex = -1;
            setImageIndex(iIndexOf);
        }
        this.ignoreDidSetImage = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setParentActivity$35(View view, int i) {
        Object item = this.mentionsAdapter.getItem(i);
        int resultStartPosition = this.mentionsAdapter.getResultStartPosition();
        int resultLength = this.mentionsAdapter.getResultLength();
        if (item instanceof TLRPC$User) {
            TLRPC$User tLRPC$User = (TLRPC$User) item;
            if (tLRPC$User.username != null) {
                this.captionEditText.replaceWithText(resultStartPosition, resultLength, "@" + tLRPC$User.username + " ", false);
                return;
            }
            SpannableString spannableString = new SpannableString(UserObject.getFirstName(tLRPC$User) + " ");
            spannableString.setSpan(new URLSpanUserMentionPhotoViewer(BuildConfig.FLAVOR + tLRPC$User.id, true), 0, spannableString.length(), 33);
            this.captionEditText.replaceWithText(resultStartPosition, resultLength, spannableString, false);
            return;
        }
        if (item instanceof String) {
            this.captionEditText.replaceWithText(resultStartPosition, resultLength, item + " ", false);
            return;
        }
        if (item instanceof MediaDataController.KeywordResult) {
            String str = ((MediaDataController.KeywordResult) item).emoji;
            this.captionEditText.addEmojiToRecent(str);
            this.captionEditText.replaceWithText(resultStartPosition, resultLength, str, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$setParentActivity$37(View view, int i) {
        if (!(this.mentionsAdapter.getItem(i) instanceof String)) {
            return false;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.parentActivity);
        builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
        builder.setMessage(LocaleController.getString("ClearSearch", R.string.ClearSearch));
        builder.setPositiveButton(LocaleController.getString("ClearButton", R.string.ClearButton).toUpperCase(), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.f$0.lambda$setParentActivity$36(dialogInterface, i2);
            }
        });
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        showAlertDialog(builder);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setParentActivity$36(DialogInterface dialogInterface, int i) {
        this.mentionsAdapter.clearRecentHashtags();
    }

    private void showScheduleDatePickerDialog() {
        if (this.parentChatActivity == null) {
            return;
        }
        AlertsCreator.createScheduleDatePickerDialog(this.parentActivity, this.parentChatActivity.getDialogId(), new AlertsCreator.ScheduleDatePickerDelegate() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda62
            @Override // org.rbmain.ui.Components.AlertsCreator.ScheduleDatePickerDelegate
            public final void didSelectDate(boolean z, int i) {
                this.f$0.sendPressed(z, i);
            }
        }, new AlertsCreator.ScheduleDatePickerColors(-1, -14342875, -1, 520093695, -1, -115203550, 620756991));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendPressed(boolean z, int i) {
        sendPressed(z, i, false);
    }

    private void replacePressed() {
        sendPressed(false, 0, true);
    }

    private void sendPressed(boolean z, int i, boolean z2) {
        int i2;
        ChatActivity chatActivity;
        if (this.captionEditText.getTag() != null || this.placeProvider == null || this.doneButtonPressed) {
            return;
        }
        if (this.sendPhotoType == 1) {
            applyCurrentEditMode();
        }
        if (!z2 && (chatActivity = this.parentChatActivity) != null) {
            TLRPC$Chat currentChat = chatActivity.getCurrentChat();
            if (this.parentChatActivity.getCurrentUser() != null || ((ChatObject.isChannel(currentChat) && currentChat.megagroup) || !ChatObject.isChannel(currentChat))) {
                MessagesController.getNotificationsSettings(this.currentAccount).edit().putBoolean(NotificationsSettingsFacade.PROPERTY_SILENT + this.parentChatActivity.getDialogId(), !z).apply();
            }
        }
        VideoEditedInfo currentVideoEditedInfo = getCurrentVideoEditedInfo();
        if (!this.imagesArrLocals.isEmpty() && (i2 = this.currentIndex) >= 0 && i2 < this.imagesArrLocals.size()) {
            Object obj = this.imagesArrLocals.get(this.currentIndex);
            if (obj instanceof MediaController.MediaEditState) {
                ((MediaController.MediaEditState) obj).editedInfo = currentVideoEditedInfo;
            }
        }
        this.doneButtonPressed = true;
        if (!z2) {
            this.placeProvider.sendButtonPressed(this.currentIndex, currentVideoEditedInfo, z, i, false);
        } else {
            this.placeProvider.replaceButtonPressed(this.currentIndex, currentVideoEditedInfo);
        }
        closePhoto(false, false);
    }

    private boolean checkInlinePermissions() {
        Activity activity = this.parentActivity;
        if (activity == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 23 || Settings.canDrawOverlays(activity)) {
            return true;
        }
        AlertsCreator.createDrawOverlayPermissionDialog(this.parentActivity, null).show();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void captureCurrentFrame() {
        TextureView textureView;
        if (this.captureFrameAtTime == -1 || (textureView = this.videoTextureView) == null) {
            return;
        }
        this.captureFrameAtTime = -1L;
        final Bitmap bitmap = textureView.getBitmap();
        this.flashView.animate().alpha(1.0f).setInterpolator(CubicBezierInterpolator.EASE_BOTH).setDuration(85L).setListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.PhotoViewer.32
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PhotoViewer.this.photoCropView.setVideoThumb(bitmap, 0);
                PhotoViewer.this.flashAnimator = new AnimatorSet();
                PhotoViewer.this.flashAnimator.playTogether(ObjectAnimator.ofFloat(PhotoViewer.this.flashView, PhotoViewer.this.FLASH_VIEW_VALUE, 0.0f));
                PhotoViewer.this.flashAnimator.setDuration(85L);
                PhotoViewer.this.flashAnimator.setInterpolator(CubicBezierInterpolator.EASE_OUT);
                PhotoViewer.this.flashAnimator.addListener(new AnonymousClass1());
                PhotoViewer.this.flashAnimator.start();
            }

            /* renamed from: org.rbmain.ui.PhotoViewer$32$1, reason: invalid class name */
            class AnonymousClass1 extends AnimatorListenerAdapter {
                AnonymousClass1() {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (PhotoViewer.this.flashAnimator == null) {
                        return;
                    }
                    AndroidUtilities.runOnUIThread(PhotoViewer.this.videoPlayRunnable = new Runnable() { // from class: org.rbmain.ui.PhotoViewer$32$1$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onAnimationEnd$0();
                        }
                    }, 860L);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public /* synthetic */ void lambda$onAnimationEnd$0() {
                    PhotoViewer.this.manuallyPaused = false;
                    if (PhotoViewer.this.videoPlayer != null) {
                        PhotoViewer.this.videoPlayer.play();
                    }
                    PhotoViewer.this.videoPlayRunnable = null;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    PhotoViewer.this.flashAnimator = null;
                }
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: createCaptionTextView, reason: merged with bridge method [inline-methods] */
    public TextView lambda$setParentActivity$4(LinkMovementMethod linkMovementMethod) {
        TextView textView = new TextView(this.activityContext) { // from class: org.rbmain.ui.PhotoViewer.33
            private boolean handleClicks;

            @Override // android.widget.TextView, android.view.View
            public boolean onTouchEvent(MotionEvent motionEvent) {
                if (motionEvent.getActionMasked() == 0) {
                    this.handleClicks = PhotoViewer.this.needCaptionLayout;
                }
                return PhotoViewer.this.bottomTouchEnabled && super.onTouchEvent(motionEvent);
            }

            @Override // android.view.View
            public void scrollTo(int i, int i2) {
                if (getParent().getParent() == PhotoViewer.this.pickerView) {
                    super.scrollTo(i, i2);
                    this.handleClicks = false;
                }
            }

            @Override // android.view.View
            public boolean performClick() {
                return this.handleClicks && super.performClick();
            }

            @Override // android.view.View
            public void setPressed(boolean z) {
                boolean z2 = z != isPressed();
                super.setPressed(z);
                if (z2) {
                    invalidate();
                }
            }
        };
        textView.setMovementMethod(linkMovementMethod);
        ViewHelper.setPadding(textView, 16.0f, 8.0f, 16.0f, 8.0f);
        textView.setLinkTextColor(-8994063);
        textView.setTextColor(-1);
        textView.setHighlightColor(872415231);
        textView.setGravity(LayoutHelper.getAbsoluteGravityStart() | 16);
        textView.setTextSize(1, 16.0f);
        textView.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createCaptionTextView$38(view);
            }
        });
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createCaptionTextView$38(View view) {
        openCaptionEnter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getLeftInset() {
        Object obj = this.lastInsets;
        if (obj == null || Build.VERSION.SDK_INT < 21) {
            return 0;
        }
        return ((WindowInsets) obj).getSystemWindowInsetLeft();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRightInset() {
        Object obj = this.lastInsets;
        if (obj == null || Build.VERSION.SDK_INT < 21) {
            return 0;
        }
        return ((WindowInsets) obj).getSystemWindowInsetRight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissInternal() {
        try {
            if (this.windowView.getParent() != null) {
                Activity activity = this.parentActivity;
                if (activity instanceof LaunchActivity) {
                    ((LaunchActivity) activity).drawerLayoutContainer.setAllowDrawContent(true);
                }
                ((WindowManager) this.parentActivity.getSystemService("window")).removeView(this.windowView);
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchToPip(boolean z) {
        if (this.videoPlayer == null || !this.textureUploaded || !checkInlinePermissions() || this.changingTextureView || this.switchingInlineMode || this.isInline) {
            return;
        }
        if (PipInstance != null) {
            PipInstance.destroyPhotoViewer();
        }
        this.openedFullScreenVideo = false;
        PipInstance = Instance;
        CubicBezierInterpolator cubicBezierInterpolator = null;
        Instance = null;
        this.switchingInlineMode = true;
        this.isVisible = false;
        AndroidUtilities.cancelRunOnUIThread(this.hideActionBarRunnable);
        PlaceProviderObject placeProviderObject = this.currentPlaceObject;
        if (placeProviderObject != null && !placeProviderObject.imageReceiver.getVisible()) {
            this.currentPlaceObject.imageReceiver.setVisible(true, true);
            AnimatedFileDrawable animation = this.currentPlaceObject.imageReceiver.getAnimation();
            if (animation != null) {
                Bitmap animatedBitmap = animation.getAnimatedBitmap();
                if (animatedBitmap != null) {
                    try {
                        Bitmap bitmap = this.videoTextureView.getBitmap(animatedBitmap.getWidth(), animatedBitmap.getHeight());
                        new Canvas(animatedBitmap).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
                        bitmap.recycle();
                    } catch (Throwable th) {
                        FileLog.e(th);
                    }
                }
                animation.seekTo(this.videoPlayer.getCurrentPosition(), true);
                if (z) {
                    this.currentPlaceObject.imageReceiver.setAlpha(0.0f);
                    final ImageReceiver imageReceiver = this.currentPlaceObject.imageReceiver;
                    ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                    valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda0
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            PhotoViewer.lambda$switchToPip$39(imageReceiver, valueAnimator);
                        }
                    });
                    valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter(this) { // from class: org.rbmain.ui.PhotoViewer.34
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            imageReceiver.setAlpha(1.0f);
                        }
                    });
                    valueAnimatorOfFloat.setDuration(250L);
                    valueAnimatorOfFloat.start();
                }
                this.currentPlaceObject.imageReceiver.setAllowStartAnimation(true);
                this.currentPlaceObject.imageReceiver.startAnimation();
            }
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.pipAnimationInProgress = true;
            org.rbmain.ui.Components.Rect pipRect = PipVideoView.getPipRect(this.aspectRatioFrameLayout.getAspectRatio());
            float width = pipRect.width / this.videoTextureView.getWidth();
            ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
            final float translationX = this.videoTextureView.getTranslationX();
            final float translationY = this.videoTextureView.getTranslationY() + this.translationY;
            final float translationY2 = this.textureImageView.getTranslationY() + this.translationY;
            final float f = pipRect.x;
            final float x = (f - this.aspectRatioFrameLayout.getX()) + getLeftInset();
            final float f2 = pipRect.y;
            final float y = f2 - this.aspectRatioFrameLayout.getY();
            this.textureImageView.setTranslationY(translationY2);
            this.videoTextureView.setTranslationY(translationY);
            this.translationY = 0.0f;
            this.containerView.invalidate();
            if (z) {
                if (translationY < y) {
                    cubicBezierInterpolator = new CubicBezierInterpolator(0.5d, 0.0d, 0.9d, 0.9d);
                } else {
                    cubicBezierInterpolator = new CubicBezierInterpolator(0.0d, 0.5d, 0.9d, 0.9d);
                }
            }
            final CubicBezierInterpolator cubicBezierInterpolator2 = cubicBezierInterpolator;
            valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f$0.lambda$switchToPip$40(cubicBezierInterpolator2, translationX, f, translationY2, f2, x, translationY, y, valueAnimator);
                }
            });
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ObjectAnimator.ofFloat(this.textureImageView, (Property<ImageView, Float>) View.SCALE_X, width), ObjectAnimator.ofFloat(this.textureImageView, (Property<ImageView, Float>) View.SCALE_Y, width), ObjectAnimator.ofFloat(this.videoTextureView, (Property<TextureView, Float>) View.SCALE_X, width), ObjectAnimator.ofFloat(this.videoTextureView, (Property<TextureView, Float>) View.SCALE_Y, width), ObjectAnimator.ofInt(this.backgroundDrawable, (Property<BackgroundDrawable, Integer>) AnimationProperties.COLOR_DRAWABLE_ALPHA, 0), valueAnimatorOfFloat2);
            if (z) {
                animatorSet.setInterpolator(CubicBezierInterpolator.EASE_OUT);
                animatorSet.setDuration(300L);
            } else {
                animatorSet.setInterpolator(new DecelerateInterpolator());
                animatorSet.setDuration(250L);
            }
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.PhotoViewer.35
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    PhotoViewer.this.pipAnimationInProgress = false;
                    PhotoViewer.this.switchToInlineRunnable.run();
                }
            });
            animatorSet.start();
            if (!z) {
                toggleActionBar(false, true, new ActionBarToggleParams().enableStatusBarAnimation(false).enableTranslationAnimation(false).animationDuration(250).animationInterpolator(new DecelerateInterpolator()));
            }
        } else {
            this.switchToInlineRunnable.run();
            dismissInternal();
        }
        ChatActivity chatActivity = this.parentChatActivity;
        if (chatActivity != null) {
            chatActivity.getFragmentView().invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$switchToPip$39(ImageReceiver imageReceiver, ValueAnimator valueAnimator) {
        imageReceiver.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$switchToPip$40(CubicBezierInterpolator cubicBezierInterpolator, float f, float f2, float f3, float f4, float f5, float f6, float f7, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        float interpolation = cubicBezierInterpolator == null ? fFloatValue : cubicBezierInterpolator.getInterpolation(fFloatValue);
        float f8 = f * (1.0f - fFloatValue);
        this.textureImageView.setTranslationX((f2 * fFloatValue) + f8);
        float f9 = 1.0f - interpolation;
        this.textureImageView.setTranslationY((f3 * f9) + (f4 * interpolation));
        this.videoTextureView.setTranslationX(f8 + (f5 * fFloatValue));
        this.videoTextureView.setTranslationY((f6 * f9) + (f7 * interpolation));
    }

    public VideoPlayer getVideoPlayer() {
        return this.videoPlayer;
    }

    public void exitFromPip() {
        if (this.isInline) {
            if (Instance != null) {
                Instance.closePhoto(false, true);
            }
            Instance = PipInstance;
            PipInstance = null;
            this.switchingInlineMode = true;
            Bitmap bitmap = this.currentBitmap;
            if (bitmap != null) {
                bitmap.recycle();
                this.currentBitmap = null;
            }
            this.changingTextureView = true;
            this.isInline = false;
            TextureView textureView = this.videoTextureView;
            if (textureView != null) {
                textureView.setVisibility(4);
                this.aspectRatioFrameLayout.addView(this.videoTextureView);
            }
            if (ApplicationLoader.mainInterfacePaused) {
                try {
                    this.parentActivity.startService(new Intent(ApplicationLoader.applicationContext, (Class<?>) BringAppForegroundService.class));
                } catch (Throwable th) {
                    FileLog.e(th);
                }
            }
            if (Build.VERSION.SDK_INT >= 21 && this.videoTextureView != null) {
                this.pipAnimationInProgress = true;
                org.rbmain.ui.Components.Rect pipRect = PipVideoView.getPipRect(this.aspectRatioFrameLayout.getAspectRatio());
                float f = pipRect.width / this.textureImageView.getLayoutParams().width;
                this.textureImageView.setScaleX(f);
                this.textureImageView.setScaleY(f);
                this.textureImageView.setTranslationX(pipRect.x);
                this.textureImageView.setTranslationY(pipRect.y);
                this.videoTextureView.setScaleX(f);
                this.videoTextureView.setScaleY(f);
                this.videoTextureView.setTranslationX(pipRect.x - this.aspectRatioFrameLayout.getX());
                this.videoTextureView.setTranslationY(pipRect.y - this.aspectRatioFrameLayout.getY());
            } else {
                this.pipVideoView.close();
                this.pipVideoView = null;
            }
            try {
                this.isVisible = true;
                ((WindowManager) this.parentActivity.getSystemService("window")).addView(this.windowView, this.windowLayoutParams);
                PlaceProviderObject placeProviderObject = this.currentPlaceObject;
                if (placeProviderObject != null) {
                    placeProviderObject.imageReceiver.setVisible(false, false);
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                this.waitingForDraw = 4;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateVideoSeekPreviewPosition() {
        int thumbX = (this.videoPlayerSeekbar.getThumbX() + AndroidUtilities.dp(2.0f)) - (this.videoPreviewFrame.getMeasuredWidth() / 2);
        int iDp = AndroidUtilities.dp(10.0f);
        int measuredWidth = (this.videoPlayerControlFrameLayout.getMeasuredWidth() - AndroidUtilities.dp(10.0f)) - (this.videoPreviewFrame.getMeasuredWidth() / 2);
        if (thumbX < iDp) {
            thumbX = iDp;
        } else if (thumbX >= measuredWidth) {
            thumbX = measuredWidth;
        }
        this.videoPreviewFrame.setTranslationX(thumbX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showVideoSeekPreviewPosition(boolean z) {
        if (!z || this.videoPreviewFrame.getTag() == null) {
            if (z || this.videoPreviewFrame.getTag() != null) {
                if (z && !this.videoPreviewFrame.isReady()) {
                    this.needShowOnReady = z;
                    return;
                }
                AnimatorSet animatorSet = this.videoPreviewFrameAnimation;
                if (animatorSet != null) {
                    animatorSet.cancel();
                }
                this.videoPreviewFrame.setTag(z ? 1 : null);
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.videoPreviewFrameAnimation = animatorSet2;
                Animator[] animatorArr = new Animator[1];
                VideoSeekPreviewImage videoSeekPreviewImage = this.videoPreviewFrame;
                Property property = View.ALPHA;
                float[] fArr = new float[1];
                fArr[0] = z ? 1.0f : 0.0f;
                animatorArr[0] = ObjectAnimator.ofFloat(videoSeekPreviewImage, (Property<VideoSeekPreviewImage, Float>) property, fArr);
                animatorSet2.playTogether(animatorArr);
                this.videoPreviewFrameAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.PhotoViewer.36
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        PhotoViewer.this.videoPreviewFrameAnimation = null;
                    }
                });
                this.videoPreviewFrameAnimation.setDuration(180L);
                this.videoPreviewFrameAnimation.start();
            }
        }
    }

    private void createVideoControlsInterface() {
        VideoPlayerControlFrameLayout videoPlayerControlFrameLayout = new VideoPlayerControlFrameLayout(this.containerView.getContext());
        this.videoPlayerControlFrameLayout = videoPlayerControlFrameLayout;
        this.containerView.addView(videoPlayerControlFrameLayout, LayoutHelper.createFrame(-1, 48, 83));
        final VideoPlayerSeekBar.SeekBarDelegate seekBarDelegate = new VideoPlayerSeekBar.SeekBarDelegate() { // from class: org.rbmain.ui.PhotoViewer.37
            @Override // org.rbmain.ui.Components.VideoPlayerSeekBar.SeekBarDelegate
            public void onSeekBarDrag(float f) {
                if (PhotoViewer.this.videoPlayer != null) {
                    if (!PhotoViewer.this.inPreview && PhotoViewer.this.videoTimelineView.getVisibility() == 0) {
                        f = PhotoViewer.this.videoTimelineView.getLeftProgress() + ((PhotoViewer.this.videoTimelineView.getRightProgress() - PhotoViewer.this.videoTimelineView.getLeftProgress()) * f);
                    }
                    if (PhotoViewer.this.videoPlayer.getDuration() == -9223372036854775807L) {
                        PhotoViewer.this.seekToProgressPending = f;
                    } else {
                        PhotoViewer.this.videoPlayer.seekTo((int) (f * r0));
                    }
                    PhotoViewer.this.showVideoSeekPreviewPosition(false);
                    PhotoViewer.this.needShowOnReady = false;
                }
            }

            @Override // org.rbmain.ui.Components.VideoPlayerSeekBar.SeekBarDelegate
            public void onSeekBarContinuousDrag(float f) {
                if (PhotoViewer.this.videoPlayer != null && PhotoViewer.this.videoPreviewFrame != null) {
                    PhotoViewer.this.videoPreviewFrame.setProgress(f, PhotoViewer.this.videoPlayerSeekbar.getWidth());
                }
                PhotoViewer.this.showVideoSeekPreviewPosition(true);
                PhotoViewer.this.updateVideoSeekPreviewPosition();
            }
        };
        FloatSeekBarAccessibilityDelegate floatSeekBarAccessibilityDelegate = new FloatSeekBarAccessibilityDelegate() { // from class: org.rbmain.ui.PhotoViewer.38
            @Override // org.rbmain.ui.Components.FloatSeekBarAccessibilityDelegate
            public float getProgress() {
                return PhotoViewer.this.videoPlayerSeekbar.getProgress();
            }

            @Override // org.rbmain.ui.Components.FloatSeekBarAccessibilityDelegate
            public void setProgress(float f) {
                seekBarDelegate.onSeekBarDrag(f);
                PhotoViewer.this.videoPlayerSeekbar.setProgress(f);
                PhotoViewer.this.videoPlayerSeekbarView.invalidate();
            }

            @Override // org.rbmain.ui.Components.SeekBarAccessibilityDelegate
            public String getContentDescription(View view) {
                return LocaleController.formatString("AccDescrPlayerDuration", R.string.AccDescrPlayerDuration, LocaleController.formatPluralString("Minutes", PhotoViewer.this.videoPlayerCurrentTime[0]) + ' ' + LocaleController.formatPluralString("Seconds", PhotoViewer.this.videoPlayerCurrentTime[1]), LocaleController.formatPluralString("Minutes", PhotoViewer.this.videoPlayerTotalTime[0]) + ' ' + LocaleController.formatPluralString("Seconds", PhotoViewer.this.videoPlayerTotalTime[1]));
            }
        };
        View view = new View(this.containerView.getContext()) { // from class: org.rbmain.ui.PhotoViewer.39
            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                PhotoViewer.this.videoPlayerSeekbar.draw(canvas, this);
            }
        };
        this.videoPlayerSeekbarView = view;
        view.setAccessibilityDelegate(floatSeekBarAccessibilityDelegate);
        this.videoPlayerSeekbarView.setImportantForAccessibility(1);
        this.videoPlayerControlFrameLayout.addView(this.videoPlayerSeekbarView, LayoutHelper.createFrame(-1, -1.0f));
        VideoPlayerSeekBar videoPlayerSeekBar = new VideoPlayerSeekBar(this.videoPlayerSeekbarView);
        this.videoPlayerSeekbar = videoPlayerSeekBar;
        videoPlayerSeekBar.setHorizontalPadding(AndroidUtilities.dp(2.0f));
        this.videoPlayerSeekbar.setColors(872415231, 872415231, -1, -1, -1, 1509949439);
        this.videoPlayerSeekbar.setDelegate(seekBarDelegate);
        VideoSeekPreviewImage videoSeekPreviewImage = new VideoSeekPreviewImage(this.containerView.getContext(), new VideoSeekPreviewImage.VideoSeekPreviewImageDelegate() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda68
            @Override // org.rbmain.ui.Components.VideoSeekPreviewImage.VideoSeekPreviewImageDelegate
            public final void onReady() {
                this.f$0.lambda$createVideoControlsInterface$41();
            }
        }) { // from class: org.rbmain.ui.PhotoViewer.40
            @Override // android.view.View
            protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
                super.onLayout(z, i, i2, i3, i4);
                PhotoViewer.this.updateVideoSeekPreviewPosition();
            }

            @Override // android.view.View
            public void setVisibility(int i) {
                super.setVisibility(i);
                if (i == 0) {
                    PhotoViewer.this.updateVideoSeekPreviewPosition();
                }
            }
        };
        this.videoPreviewFrame = videoSeekPreviewImage;
        videoSeekPreviewImage.setAlpha(0.0f);
        this.containerView.addView(this.videoPreviewFrame, LayoutHelper.createFrame(-2, -2.0f, 83, 0.0f, 0.0f, 0.0f, 58.0f));
        SimpleTextView simpleTextView = new SimpleTextView(this.containerView.getContext());
        this.videoPlayerTime = simpleTextView;
        simpleTextView.setTextColor(-1);
        this.videoPlayerTime.setGravity(53);
        this.videoPlayerTime.setTextSize(14);
        this.videoPlayerTime.setImportantForAccessibility(2);
        this.videoPlayerControlFrameLayout.addView(this.videoPlayerTime, LayoutHelper.createFrame(-2, -2.0f, 53, 0.0f, 15.0f, 12.0f, 0.0f));
        ImageView imageView = new ImageView(this.containerView.getContext());
        this.exitFullscreenButton = imageView;
        imageView.setImageResource(R.drawable.msg_minvideo);
        this.exitFullscreenButton.setContentDescription(LocaleController.getString("AccExitFullscreen", R.string.AccExitFullscreen));
        this.exitFullscreenButton.setScaleType(ImageView.ScaleType.CENTER);
        this.exitFullscreenButton.setBackground(Theme.createSelectorDrawable(1090519039));
        this.exitFullscreenButton.setVisibility(4);
        this.videoPlayerControlFrameLayout.addView(this.exitFullscreenButton, LayoutHelper.createFrame(48, 48, 53));
        this.exitFullscreenButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda28
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$createVideoControlsInterface$42(view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createVideoControlsInterface$41() {
        if (this.needShowOnReady) {
            showVideoSeekPreviewPosition(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createVideoControlsInterface$42(View view) {
        Activity activity = this.parentActivity;
        if (activity == null) {
            return;
        }
        this.wasRotated = false;
        this.fullscreenedByButton = 2;
        if (this.prevOrientation == -10) {
            this.prevOrientation = activity.getRequestedOrientation();
        }
        this.parentActivity.setRequestedOrientation(1);
    }

    private void openCaptionEnter() {
        int i;
        if (this.imageMoveAnimation != null || this.changeModeAnimation != null || this.currentEditMode != 0 || (i = this.sendPhotoType) == 1 || i == 3 || i == 10) {
            return;
        }
        if (!this.windowView.isFocusable()) {
            makeFocusable();
        }
        this.selectedPhotosListView.setEnabled(false);
        this.photosCounterView.setRotationX(0.0f);
        this.isPhotosListViewVisible = false;
        this.captionEditText.setTag(1);
        this.captionEditText.openKeyboard();
        this.captionEditText.setImportantForAccessibility(0);
        this.lastTitle = this.actionBar.getTitle();
        this.captionEditText.setVisibility(0);
    }

    private int[] fixVideoWidthHeight(int i, int i2) {
        int[] iArr = {i, i2};
        if (Build.VERSION.SDK_INT >= 21) {
            MediaCodec mediaCodecCreateEncoderByType = null;
            try {
                mediaCodecCreateEncoderByType = MediaCodec.createEncoderByType(MediaController.VIDEO_MIME_TYPE);
                MediaCodecInfo.VideoCapabilities videoCapabilities = mediaCodecCreateEncoderByType.getCodecInfo().getCapabilitiesForType(MediaController.VIDEO_MIME_TYPE).getVideoCapabilities();
                Range<Integer> supportedWidths = videoCapabilities.getSupportedWidths();
                Range<Integer> supportedHeights = videoCapabilities.getSupportedHeights();
                iArr[0] = Math.max(((Integer) supportedWidths.getLower()).intValue(), Math.round(i / 16.0f) * 16);
                iArr[1] = Math.max(((Integer) supportedHeights.getLower()).intValue(), Math.round(i2 / 16.0f) * 16);
            } catch (Exception unused) {
                if (mediaCodecCreateEncoderByType != null) {
                }
            } catch (Throwable th) {
                if (mediaCodecCreateEncoderByType != null) {
                    try {
                        mediaCodecCreateEncoderByType.release();
                    } catch (Exception unused2) {
                    }
                }
                throw th;
            }
            try {
                mediaCodecCreateEncoderByType.release();
            } catch (Exception unused3) {
            }
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VideoEditedInfo getCurrentVideoEditedInfo() {
        int i;
        long j;
        ArrayList<VideoEditedInfo.MediaEntity> arrayList = null;
        if (!this.isCurrentVideo && hasAnimatedMediaEntities() && this.centerImage.getBitmapWidth() > 0) {
            float f = this.sendPhotoType == 1 ? 800.0f : 854.0f;
            VideoEditedInfo videoEditedInfo = new VideoEditedInfo();
            videoEditedInfo.startTime = 0L;
            videoEditedInfo.start = 0L;
            videoEditedInfo.endTime = Math.min(3000L, this.editState.averageDuration);
            while (true) {
                j = videoEditedInfo.endTime;
                if (j <= 0 || j >= 1000) {
                    break;
                }
                videoEditedInfo.endTime = j * 2;
            }
            videoEditedInfo.end = j;
            videoEditedInfo.rotationValue = 0;
            videoEditedInfo.originalPath = this.currentImagePath;
            videoEditedInfo.estimatedSize = (int) ((j / 1000.0f) * 115200.0f);
            videoEditedInfo.estimatedDuration = j;
            videoEditedInfo.framerate = 30;
            videoEditedInfo.originalDuration = j;
            EditState editState = this.editState;
            videoEditedInfo.filterState = editState.savedFilterState;
            String str = editState.croppedPaintPath;
            if (str != null) {
                videoEditedInfo.paintPath = str;
                ArrayList<VideoEditedInfo.MediaEntity> arrayList2 = editState.croppedMediaEntities;
                if (arrayList2 != null && !arrayList2.isEmpty()) {
                    arrayList = this.editState.croppedMediaEntities;
                }
                videoEditedInfo.mediaEntities = arrayList;
            } else {
                videoEditedInfo.paintPath = editState.paintPath;
                videoEditedInfo.mediaEntities = editState.mediaEntities;
            }
            videoEditedInfo.isPhoto = true;
            int bitmapWidth = this.centerImage.getBitmapWidth();
            int bitmapHeight = this.centerImage.getBitmapHeight();
            MediaController.CropState cropState = this.editState.cropState;
            if (cropState != null) {
                int i2 = cropState.transformRotation;
                if (i2 == 90 || i2 == 270) {
                    bitmapHeight = bitmapWidth;
                    bitmapWidth = bitmapHeight;
                }
                bitmapWidth = (int) (bitmapWidth * cropState.cropPw);
                bitmapHeight = (int) (bitmapHeight * cropState.cropPh);
            }
            if (this.sendPhotoType == 1) {
                bitmapWidth = bitmapHeight;
            }
            float f2 = bitmapWidth;
            float f3 = bitmapHeight;
            float fMax = Math.max(f2 / f, f3 / f);
            if (fMax < 1.0f) {
                fMax = 1.0f;
            }
            int iMax = (int) (f2 / fMax);
            int iMax2 = (int) (f3 / fMax);
            if (iMax % 16 != 0) {
                iMax = Math.max(1, Math.round(iMax / 16.0f)) * 16;
            }
            if (iMax2 % 16 != 0) {
                iMax2 = Math.max(1, Math.round(iMax2 / 16.0f)) * 16;
            }
            videoEditedInfo.resultWidth = iMax;
            videoEditedInfo.originalWidth = iMax;
            videoEditedInfo.resultHeight = iMax2;
            videoEditedInfo.originalHeight = iMax2;
            videoEditedInfo.bitrate = -1;
            videoEditedInfo.muted = true;
            videoEditedInfo.avatarStartTime = 0L;
            return videoEditedInfo;
        }
        if (!this.isCurrentVideo || this.currentPlayingVideoFile == null || this.compressionsCount == 0) {
            return null;
        }
        VideoEditedInfo videoEditedInfo2 = new VideoEditedInfo();
        videoEditedInfo2.startTime = this.startTime;
        videoEditedInfo2.endTime = this.endTime;
        videoEditedInfo2.start = this.videoCutStart;
        videoEditedInfo2.end = this.videoCutEnd;
        videoEditedInfo2.rotationValue = this.rotationValue;
        videoEditedInfo2.originalWidth = this.originalWidth;
        videoEditedInfo2.originalHeight = this.originalHeight;
        videoEditedInfo2.bitrate = this.bitrate;
        videoEditedInfo2.originalPath = this.currentPathObject;
        long j2 = this.estimatedSize;
        if (j2 == 0) {
            j2 = 1;
        }
        videoEditedInfo2.estimatedSize = j2;
        videoEditedInfo2.estimatedDuration = this.estimatedDuration;
        videoEditedInfo2.framerate = this.videoFramerate;
        videoEditedInfo2.originalDuration = (long) (this.videoDuration * 1000.0f);
        EditState editState2 = this.editState;
        videoEditedInfo2.filterState = editState2.savedFilterState;
        String str2 = editState2.croppedPaintPath;
        if (str2 != null) {
            videoEditedInfo2.paintPath = str2;
            ArrayList<VideoEditedInfo.MediaEntity> arrayList3 = editState2.croppedMediaEntities;
            if (arrayList3 != null && !arrayList3.isEmpty()) {
                arrayList = this.editState.croppedMediaEntities;
            }
            videoEditedInfo2.mediaEntities = arrayList;
        } else {
            videoEditedInfo2.paintPath = editState2.paintPath;
            ArrayList<VideoEditedInfo.MediaEntity> arrayList4 = editState2.mediaEntities;
            if (arrayList4 != null && !arrayList4.isEmpty()) {
                arrayList = this.editState.mediaEntities;
            }
            videoEditedInfo2.mediaEntities = arrayList;
        }
        if (this.sendPhotoType != 1 && !this.muteVideo && (this.compressItem.getTag() == null || (videoEditedInfo2.resultWidth == this.originalWidth && videoEditedInfo2.resultHeight == this.originalHeight))) {
            videoEditedInfo2.resultWidth = this.originalWidth;
            videoEditedInfo2.resultHeight = this.originalHeight;
            videoEditedInfo2.bitrate = this.muteVideo ? -1 : this.originalBitrate;
        } else {
            if (this.muteVideo || this.sendPhotoType == 1) {
                this.selectedCompression = 1;
                updateWidthHeightBitrateForCompression();
            }
            videoEditedInfo2.resultWidth = this.resultWidth;
            videoEditedInfo2.resultHeight = this.resultHeight;
            if (!this.muteVideo && this.sendPhotoType != 1) {
                i = this.bitrate;
            }
            videoEditedInfo2.bitrate = i;
        }
        MediaController.CropState cropState2 = this.editState.cropState;
        videoEditedInfo2.cropState = cropState2;
        if (cropState2 != null) {
            videoEditedInfo2.rotationValue += cropState2.transformRotation;
            while (true) {
                i = videoEditedInfo2.rotationValue;
                if (i < 360) {
                    break;
                }
                videoEditedInfo2.rotationValue = i - 360;
            }
            if (i == 90 || i == 270) {
                MediaController.CropState cropState3 = videoEditedInfo2.cropState;
                cropState3.transformWidth = (int) (videoEditedInfo2.resultWidth * cropState3.cropPh);
                cropState3.transformHeight = (int) (videoEditedInfo2.resultHeight * cropState3.cropPw);
            } else {
                MediaController.CropState cropState4 = videoEditedInfo2.cropState;
                cropState4.transformWidth = (int) (videoEditedInfo2.resultWidth * cropState4.cropPw);
                cropState4.transformHeight = (int) (videoEditedInfo2.resultHeight * cropState4.cropPh);
            }
            if (this.sendPhotoType == 1) {
                MediaController.CropState cropState5 = videoEditedInfo2.cropState;
                if (cropState5.transformWidth > 800) {
                    cropState5.transformWidth = MediaController.MAX_WIDTH_HEIGHT_SIZE;
                }
                if (cropState5.transformHeight > 800) {
                    cropState5.transformHeight = MediaController.MAX_WIDTH_HEIGHT_SIZE;
                }
                int iMin = Math.min(cropState5.transformWidth, cropState5.transformHeight);
                cropState5.transformHeight = iMin;
                cropState5.transformWidth = iMin;
            }
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("original transformed w = " + videoEditedInfo2.cropState.transformWidth + " h = " + videoEditedInfo2.cropState.transformHeight + " r = " + videoEditedInfo2.rotationValue);
            }
            MediaController.CropState cropState6 = videoEditedInfo2.cropState;
            int[] iArrFixVideoWidthHeight = fixVideoWidthHeight(cropState6.transformWidth, cropState6.transformHeight);
            MediaController.CropState cropState7 = videoEditedInfo2.cropState;
            cropState7.transformWidth = iArrFixVideoWidthHeight[0];
            cropState7.transformHeight = iArrFixVideoWidthHeight[1];
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("fixed transformed w = " + videoEditedInfo2.cropState.transformWidth + " h = " + videoEditedInfo2.cropState.transformHeight);
            }
        }
        int i3 = this.sendPhotoType;
        if (i3 == 1) {
            videoEditedInfo2.avatarStartTime = this.avatarStartTime;
            videoEditedInfo2.originalBitrate = this.originalBitrate;
        }
        videoEditedInfo2.muted = this.muteVideo || i3 == 1;
        return videoEditedInfo2;
    }

    private boolean supportsSendingNewEntities() {
        TLRPC$EncryptedChat tLRPC$EncryptedChat;
        ChatActivity chatActivity = this.parentChatActivity;
        return chatActivity != null && ((tLRPC$EncryptedChat = chatActivity.currentEncryptedChat) == null || AndroidUtilities.getPeerLayerVersion(tLRPC$EncryptedChat.layer) >= 101);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeCaptionEnter(boolean z) throws IllegalAccessException, NoSuchFieldException, Resources.NotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException {
        int i = this.currentIndex;
        if (i < 0 || i >= this.imagesArrLocals.size() || this.captionEditText.getTag() == null) {
            return;
        }
        Object obj = this.imagesArrLocals.get(this.currentIndex);
        if (z) {
            CharSequence[] charSequenceArr = {this.captionEditText.getFieldCharSequence()};
            ArrayList<TLRPC$MessageEntity> entities = MediaDataController.getInstance(this.currentAccount).getEntities(charSequenceArr, supportsSendingNewEntities());
            if (obj instanceof MediaController.PhotoEntry) {
                MediaController.PhotoEntry photoEntry = (MediaController.PhotoEntry) obj;
                photoEntry.caption = charSequenceArr[0];
                photoEntry.entities = entities;
            } else if (obj instanceof MediaController.SearchImage) {
                MediaController.SearchImage searchImage = (MediaController.SearchImage) obj;
                searchImage.caption = charSequenceArr[0];
                searchImage.entities = entities;
            }
            if (this.captionEditText.getFieldCharSequence().length() != 0 && !this.placeProvider.isPhotoChecked(this.currentIndex)) {
                setPhotoChecked();
            }
            setCurrentCaption(null, charSequenceArr[0], false);
        }
        this.captionEditText.setTag(null);
        if (this.isCurrentVideo) {
            this.actionBar.setTitleAnimated(this.lastTitle, false, 220L);
            this.actionBar.setSubtitle(this.muteVideo ? LocaleController.getString("SoundMuted", R.string.SoundMuted) : this.currentSubtitle);
        }
        updateCaptionTextForCurrentPhoto(obj);
        if (this.captionEditText.isPopupShowing()) {
            this.captionEditText.hidePopup();
        }
        this.captionEditText.closeKeyboard();
        if (Build.VERSION.SDK_INT >= 19) {
            this.captionEditText.setImportantForAccessibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateVideoPlayerTime() {
        Arrays.fill(this.videoPlayerCurrentTime, 0);
        Arrays.fill(this.videoPlayerTotalTime, 0);
        VideoPlayer videoPlayer = this.videoPlayer;
        if (videoPlayer != null) {
            long jMax = Math.max(0L, videoPlayer.getCurrentPosition());
            long jMax2 = Math.max(0L, this.videoPlayer.getDuration());
            if (!this.inPreview && this.videoTimelineView.getVisibility() == 0) {
                jMax2 = (long) (jMax2 * (this.videoTimelineView.getRightProgress() - this.videoTimelineView.getLeftProgress()));
                jMax = (long) (jMax - (this.videoTimelineView.getLeftProgress() * jMax2));
                if (jMax > jMax2) {
                    jMax = jMax2;
                }
            }
            long j = jMax / 1000;
            long j2 = jMax2 / 1000;
            int[] iArr = this.videoPlayerCurrentTime;
            iArr[0] = (int) (j / 60);
            iArr[1] = (int) (j % 60);
            int[] iArr2 = this.videoPlayerTotalTime;
            iArr2[0] = (int) (j2 / 60);
            iArr2[1] = (int) (j2 % 60);
        }
        this.videoPlayerTime.setText(String.format(Locale.ROOT, "%02d:%02d / %02d:%02d", Integer.valueOf(this.videoPlayerCurrentTime[0]), Integer.valueOf(this.videoPlayerCurrentTime[1]), Integer.valueOf(this.videoPlayerTotalTime[0]), Integer.valueOf(this.videoPlayerTotalTime[1])));
    }

    public void updateColors() {
        int i = Theme.key_dialogFloatingButton;
        int color = Theme.getColor(i);
        ImageView imageView = this.pickerViewSendButton;
        if (imageView != null) {
            Drawable background = imageView.getBackground();
            Theme.setSelectorDrawableColor(background, color, false);
            Theme.setSelectorDrawableColor(background, Theme.getColor(Build.VERSION.SDK_INT >= 21 ? Theme.key_dialogFloatingButtonPressed : i), true);
            this.pickerViewSendButton.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_dialogFloatingIcon), PorterDuff.Mode.MULTIPLY));
        }
        CheckBox checkBox = this.checkImageView;
        if (checkBox != null) {
            checkBox.setColor(Theme.getColor(i), -1);
        }
        PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(color, PorterDuff.Mode.MULTIPLY);
        ImageView imageView2 = this.timeItem;
        if (imageView2 != null && imageView2.getColorFilter() != null) {
            this.timeItem.setColorFilter(porterDuffColorFilter);
        }
        ImageView imageView3 = this.paintItem;
        if (imageView3 != null && imageView3.getColorFilter() != null) {
            this.paintItem.setColorFilter(porterDuffColorFilter);
        }
        ImageView imageView4 = this.cropItem;
        if (imageView4 != null && imageView4.getColorFilter() != null) {
            this.cropItem.setColorFilter(porterDuffColorFilter);
        }
        ImageView imageView5 = this.tuneItem;
        if (imageView5 != null && imageView5.getColorFilter() != null) {
            this.tuneItem.setColorFilter(porterDuffColorFilter);
        }
        ImageView imageView6 = this.rotateItem;
        if (imageView6 != null && imageView6.getColorFilter() != null) {
            this.rotateItem.setColorFilter(porterDuffColorFilter);
        }
        ImageView imageView7 = this.mirrorItem;
        if (imageView7 != null && imageView7.getColorFilter() != null) {
            this.mirrorItem.setColorFilter(porterDuffColorFilter);
        }
        PickerBottomLayoutViewer pickerBottomLayoutViewer = this.editorDoneLayout;
        if (pickerBottomLayoutViewer != null) {
            pickerBottomLayoutViewer.doneButton.setTextColor(color);
        }
        PickerBottomLayoutViewer pickerBottomLayoutViewer2 = this.qualityPicker;
        if (pickerBottomLayoutViewer2 != null) {
            pickerBottomLayoutViewer2.doneButton.setTextColor(color);
        }
        PhotoPaintView photoPaintView = this.photoPaintView;
        if (photoPaintView != null) {
            photoPaintView.updateColors();
        }
        PhotoFilterView photoFilterView = this.photoFilterView;
        if (photoFilterView != null) {
            photoFilterView.updateColors();
        }
        PhotoViewerCaptionEnterView photoViewerCaptionEnterView = this.captionEditText;
        if (photoViewerCaptionEnterView != null) {
            photoViewerCaptionEnterView.updateColors();
        }
        VideoTimelinePlayView videoTimelinePlayView = this.videoTimelineView;
        if (videoTimelinePlayView != null) {
            videoTimelinePlayView.invalidate();
        }
        SelectedPhotosListView selectedPhotosListView = this.selectedPhotosListView;
        if (selectedPhotosListView != null) {
            int childCount = selectedPhotosListView.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.selectedPhotosListView.getChildAt(i2);
                if (childAt instanceof PhotoPickerPhotoCell) {
                    ((PhotoPickerPhotoCell) childAt).updateColors();
                }
            }
        }
        StickersAlert stickersAlert = this.masksAlert;
        if (stickersAlert != null) {
            stickersAlert.updateColors(true);
        }
    }

    public void injectVideoPlayer(VideoPlayer videoPlayer) {
        this.injectingVideoPlayer = videoPlayer;
    }

    public void injectVideoPlayerSurface(SurfaceTexture surfaceTexture) {
        this.injectingVideoPlayerSurface = surfaceTexture;
    }

    public boolean isInjectingVideoPlayer() {
        return this.injectingVideoPlayer != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleActionBarHide() {
        scheduleActionBarHide(3000);
    }

    private void scheduleActionBarHide(int i) {
        if (isAccessibilityEnabled()) {
            return;
        }
        AndroidUtilities.cancelRunOnUIThread(this.hideActionBarRunnable);
        AndroidUtilities.runOnUIThread(this.hideActionBarRunnable, i);
    }

    private boolean isAccessibilityEnabled() {
        try {
            AccessibilityManager accessibilityManager = (AccessibilityManager) this.activityContext.getSystemService("accessibility");
            if (accessibilityManager.isEnabled()) {
                return accessibilityManager.isTouchExplorationEnabled();
            }
            return false;
        } catch (Exception e) {
            FileLog.e(e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePlayerState(boolean z, int i) {
        MessageObject messageObject;
        if (this.videoPlayer == null) {
            return;
        }
        float f = 0.0f;
        if (this.isStreaming) {
            if (i != 2 || !this.skipFirstBufferingProgress) {
                boolean z2 = this.seekToProgressPending != 0.0f || i == 2;
                if (z2) {
                    AndroidUtilities.cancelRunOnUIThread(this.hideActionBarRunnable);
                } else {
                    scheduleActionBarHide();
                }
                toggleMiniProgress(z2, true);
            } else if (z) {
                this.skipFirstBufferingProgress = false;
            }
        }
        if (z && i != 4 && i != 1) {
            try {
                this.parentActivity.getWindow().addFlags(128);
                this.keepScreenOnFlagSet = true;
            } catch (Exception e) {
                FileLog.e(e);
            }
        } else {
            try {
                this.parentActivity.getWindow().clearFlags(128);
                this.keepScreenOnFlagSet = false;
            } catch (Exception e2) {
                FileLog.e(e2);
            }
        }
        if (i == 3 || i == 1) {
            if (this.currentMessageObject != null) {
                this.videoPreviewFrame.open(this.videoPlayer.getCurrentUri());
            }
            if (this.seekToProgressPending != 0.0f) {
                this.videoPlayer.seekTo((int) (this.videoPlayer.getDuration() * this.seekToProgressPending));
                this.seekToProgressPending = 0.0f;
                MessageObject messageObject2 = this.currentMessageObject;
                if (messageObject2 != null && !FileLoader.getInstance(messageObject2.currentAccount).isLoadingVideoAny(this.currentMessageObject.getDocument())) {
                    this.skipFirstBufferingProgress = true;
                }
            }
        }
        if (i == 3) {
            if (this.aspectRatioFrameLayout.getVisibility() != 0) {
                this.aspectRatioFrameLayout.setVisibility(0);
            }
            if (!this.pipItem.isEnabled() && this.pipItem.getVisibility() == 0) {
                this.pipAvailable = true;
                this.pipItem.setEnabled(true);
                this.pipItem.animate().alpha(1.0f).setDuration(175L).withEndAction(null).start();
            }
            this.playerWasReady = true;
            MessageObject messageObject3 = this.currentMessageObject;
            if (messageObject3 != null && messageObject3.isVideo()) {
                AndroidUtilities.cancelRunOnUIThread(this.setLoadingRunnable);
                FileLoader.getInstance(this.currentMessageObject.currentAccount).removeLoadingVideo(this.currentMessageObject.getDocument(), true, false);
            }
        } else if (i == 2 && z && (messageObject = this.currentMessageObject) != null && messageObject.isVideo()) {
            if (this.playerWasReady) {
                this.setLoadingRunnable.run();
            } else {
                AndroidUtilities.runOnUIThread(this.setLoadingRunnable, 1000L);
            }
        }
        if (this.videoPlayer.isPlaying() && i != 4) {
            if (!this.isPlaying) {
                this.isPlaying = true;
                this.photoProgressViews[0].setBackgroundState(this.isCurrentVideo ? -1 : 4, false, true);
                PhotoProgressView photoProgressView = this.photoProgressViews[0];
                if (this.isCurrentVideo || ((isAccessibilityEnabled() && !this.playerWasPlaying) || ((!this.playerAutoStarted || this.playerWasPlaying) && this.isActionBarVisible))) {
                    f = 1.0f;
                }
                photoProgressView.setIndexedAlpha(1, f, false);
                this.playerWasPlaying = true;
                AndroidUtilities.runOnUIThread(this.updateProgressRunnable);
            }
        } else if (this.isPlaying || i == 4) {
            if (this.currentEditMode != 3) {
                this.photoProgressViews[0].setIndexedAlpha(1, 1.0f, false);
                this.photoProgressViews[0].setBackgroundState(3, false, this.isPlaying);
            }
            this.isPlaying = false;
            AndroidUtilities.cancelRunOnUIThread(this.updateProgressRunnable);
            if (i == 4) {
                if (this.isCurrentVideo) {
                    if (!this.videoTimelineView.isDragging()) {
                        VideoTimelinePlayView videoTimelinePlayView = this.videoTimelineView;
                        videoTimelinePlayView.setProgress(videoTimelinePlayView.getLeftProgress());
                        if (!this.inPreview && (this.currentEditMode != 0 || this.videoTimelineView.getVisibility() == 0)) {
                            this.videoPlayer.seekTo((int) (this.videoTimelineView.getLeftProgress() * this.videoPlayer.getDuration()));
                        } else {
                            this.videoPlayer.seekTo(0L);
                        }
                        this.manuallyPaused = false;
                        cancelVideoPlayRunnable();
                        if (this.sendPhotoType != 1 && this.currentEditMode == 0 && this.switchingToMode <= 0) {
                            this.videoPlayer.pause();
                        } else {
                            this.videoPlayer.play();
                        }
                        this.containerView.invalidate();
                    }
                } else {
                    this.videoPlayerSeekbar.setProgress(0.0f);
                    this.videoPlayerSeekbarView.invalidate();
                    if (!this.inPreview && this.videoTimelineView.getVisibility() == 0) {
                        this.videoPlayer.seekTo((int) (this.videoTimelineView.getLeftProgress() * this.videoPlayer.getDuration()));
                    } else {
                        this.videoPlayer.seekTo(0L);
                    }
                    this.manuallyPaused = false;
                    this.videoPlayer.pause();
                    if (!this.isActionBarVisible) {
                        toggleActionBar(true, true);
                    }
                }
                PipVideoView pipVideoView = this.pipVideoView;
                if (pipVideoView != null) {
                    pipVideoView.onVideoCompleted();
                }
            }
        }
        PipVideoView pipVideoView2 = this.pipVideoView;
        if (pipVideoView2 != null) {
            pipVideoView2.updatePlayButton();
        }
        updateVideoPlayerTime();
    }

    private void preparePlayer(Uri uri, boolean z, boolean z2) {
        preparePlayer(uri, z, z2, null);
    }

    private void preparePlayer(Uri uri, boolean z, boolean z2, MediaController.SavedFilterState savedFilterState) {
        boolean z3;
        if (!z2) {
            this.currentPlayingVideoFile = uri;
        }
        if (this.parentActivity == null) {
            return;
        }
        this.streamingAlertShown = false;
        SystemClock.elapsedRealtime();
        this.currentVideoFinishedLoading = false;
        this.lastBufferedPositionCheck = 0L;
        this.firstAnimationDelay = true;
        this.inPreview = z2;
        releasePlayer(false);
        SavedVideoPosition savedVideoPosition = null;
        if (this.imagesArrLocals.isEmpty()) {
            createVideoTextureView(null);
        }
        if (Build.VERSION.SDK_INT >= 21 && this.textureImageView == null) {
            ImageView imageView = new ImageView(this.parentActivity);
            this.textureImageView = imageView;
            imageView.setBackgroundColor(-65536);
            this.textureImageView.setPivotX(0.0f);
            this.textureImageView.setPivotY(0.0f);
            this.textureImageView.setVisibility(4);
            this.containerView.addView(this.textureImageView);
        }
        checkFullscreenButton();
        if (this.orientationEventListener == null) {
            OrientationEventListener orientationEventListener = new OrientationEventListener(ApplicationLoader.applicationContext) { // from class: org.rbmain.ui.PhotoViewer.41
                @Override // android.view.OrientationEventListener
                public void onOrientationChanged(int i) {
                    if (PhotoViewer.this.orientationEventListener == null || PhotoViewer.this.aspectRatioFrameLayout == null || PhotoViewer.this.aspectRatioFrameLayout.getVisibility() != 0) {
                        return;
                    }
                    FileLog.d("orientation = " + i);
                    if (PhotoViewer.this.parentActivity == null || PhotoViewer.this.fullscreenedByButton == 0) {
                        return;
                    }
                    if (PhotoViewer.this.fullscreenedByButton != 1) {
                        if (i <= 0 || (i < 330 && i > 30)) {
                            if (!PhotoViewer.this.wasRotated || i < 240 || i > 300) {
                                return;
                            }
                            PhotoViewer.this.parentActivity.setRequestedOrientation(PhotoViewer.this.prevOrientation);
                            PhotoViewer.this.fullscreenedByButton = 0;
                            PhotoViewer.this.wasRotated = false;
                            return;
                        }
                        PhotoViewer.this.wasRotated = true;
                        return;
                    }
                    if (i < 240 || i > 300) {
                        if (!PhotoViewer.this.wasRotated || i <= 0) {
                            return;
                        }
                        if (i >= 330 || i <= 30) {
                            PhotoViewer.this.parentActivity.setRequestedOrientation(PhotoViewer.this.prevOrientation);
                            PhotoViewer.this.fullscreenedByButton = 0;
                            PhotoViewer.this.wasRotated = false;
                            return;
                        }
                        return;
                    }
                    PhotoViewer.this.wasRotated = true;
                }
            };
            this.orientationEventListener = orientationEventListener;
            if (orientationEventListener.canDetectOrientation()) {
                this.orientationEventListener.enable();
            } else {
                this.orientationEventListener.disable();
                this.orientationEventListener = null;
            }
        }
        this.textureUploaded = false;
        this.videoSizeSet = false;
        this.videoCrossfadeStarted = false;
        this.playerWasReady = false;
        this.playerWasPlaying = false;
        this.captureFrameReadyAtTime = -1L;
        this.captureFrameAtTime = -1L;
        this.needCaptureFrameReadyAtTime = -1L;
        if (this.videoPlayer == null) {
            VideoPlayer videoPlayer = this.injectingVideoPlayer;
            if (videoPlayer != null) {
                this.videoPlayer = videoPlayer;
                this.injectingVideoPlayer = null;
                this.playerInjected = true;
                updatePlayerState(videoPlayer.getPlayWhenReady(), this.videoPlayer.getPlaybackState());
                z3 = false;
            } else {
                this.videoPlayer = new VideoPlayer() { // from class: org.rbmain.ui.PhotoViewer.42
                    @Override // org.rbmain.ui.Components.VideoPlayer
                    public void play() {
                        super.play();
                        PhotoViewer.this.playOrStopAnimatedStickers(true);
                    }

                    @Override // org.rbmain.ui.Components.VideoPlayer
                    public void pause() {
                        super.pause();
                        if (PhotoViewer.this.currentEditMode == 0) {
                            PhotoViewer.this.playOrStopAnimatedStickers(false);
                        }
                    }

                    @Override // org.rbmain.ui.Components.VideoPlayer
                    public void seekTo(long j) {
                        super.seekTo(j);
                        if (PhotoViewer.this.isCurrentVideo) {
                            PhotoViewer.this.seekAnimatedStickersTo(j);
                        }
                    }
                };
                z3 = true;
            }
            TextureView textureView = this.videoTextureView;
            if (textureView != null) {
                this.videoPlayer.setTextureView(textureView);
            }
            this.videoPlayer.setDelegate(new AnonymousClass43());
        } else {
            z3 = false;
        }
        if (!this.imagesArrLocals.isEmpty()) {
            createVideoTextureView(savedFilterState);
        }
        TextureView textureView2 = this.videoTextureView;
        this.videoCrossfadeAlpha = 0.0f;
        textureView2.setAlpha(0.0f);
        PaintingOverlay paintingOverlay = this.paintingOverlay;
        if (paintingOverlay != null) {
            paintingOverlay.setAlpha(this.videoCrossfadeAlpha);
        }
        this.shouldSavePositionForCurrentVideo = null;
        this.shouldSavePositionForCurrentVideoShortTerm = null;
        this.lastSaveTime = 0L;
        if (z3) {
            this.seekToProgressPending = this.seekToProgressPending2;
            this.videoPlayerSeekbar.setProgress(0.0f);
            this.videoTimelineView.setProgress(0.0f);
            this.videoPlayerSeekbar.setBufferedProgress(0.0f);
            MessageObject messageObject = this.currentMessageObject;
            if (messageObject != null) {
                int duration = messageObject.getDuration();
                String fileName = this.currentMessageObject.getFileName();
                if (!TextUtils.isEmpty(fileName)) {
                    if (duration >= 1200) {
                        if (this.currentMessageObject.forceSeekTo < 0.0f) {
                            float f = ApplicationLoader.applicationContext.getSharedPreferences("media_saved_pos", 0).getFloat(fileName, -1.0f);
                            if (f > 0.0f && f < 0.999f) {
                                this.currentMessageObject.forceSeekTo = f;
                                this.videoPlayerSeekbar.setProgress(f);
                            }
                        }
                        this.shouldSavePositionForCurrentVideo = fileName;
                    } else if (duration >= 10) {
                        for (int size = this.savedVideoPositions.size() - 1; size >= 0; size--) {
                            SavedVideoPosition savedVideoPositionValueAt = this.savedVideoPositions.valueAt(size);
                            if (savedVideoPositionValueAt.timestamp < SystemClock.elapsedRealtime() - 5000) {
                                this.savedVideoPositions.removeAt(size);
                            } else if (savedVideoPosition == null && this.savedVideoPositions.keyAt(size).equals(fileName)) {
                                savedVideoPosition = savedVideoPositionValueAt;
                            }
                        }
                        MessageObject messageObject2 = this.currentMessageObject;
                        if (messageObject2.forceSeekTo < 0.0f && savedVideoPosition != null) {
                            float f2 = savedVideoPosition.position;
                            if (f2 > 0.0f && f2 < 0.999f) {
                                messageObject2.forceSeekTo = f2;
                                this.videoPlayerSeekbar.setProgress(f2);
                            }
                        }
                        this.shouldSavePositionForCurrentVideoShortTerm = fileName;
                    }
                }
            }
            this.videoPlayer.preparePlayer(uri, "other");
            this.videoPlayer.setPlayWhenReady(z);
        }
        MessageObject messageObject3 = this.currentMessageObject;
        boolean z4 = messageObject3 != null && messageObject3.getDuration() <= 30;
        this.playerLooping = z4;
        this.videoPlayerControlFrameLayout.setSeekBarTransitionEnabled(z4);
        this.videoPlayer.setLooping(this.playerLooping);
        MessageObject messageObject4 = this.currentMessageObject;
        if (messageObject4 != null) {
            float f3 = messageObject4.forceSeekTo;
            if (f3 >= 0.0f) {
                this.seekToProgressPending = f3;
                messageObject4.forceSeekTo = -1.0f;
            }
        }
        TLRPC$BotInlineResult tLRPC$BotInlineResult = this.currentBotInlineResult;
        if (tLRPC$BotInlineResult != null && (tLRPC$BotInlineResult.type.equals(MediaStreamTrack.VIDEO_TRACK_KIND) || MessageObject.isVideoDocument(this.currentBotInlineResult.document))) {
            this.bottomLayout.setVisibility(0);
            this.bottomLayout.setPadding(0, 0, AndroidUtilities.dp(84.0f), 0);
            this.pickerView.setVisibility(8);
        } else {
            this.bottomLayout.setPadding(0, 0, 0, 0);
        }
        if (this.pageBlocksAdapter != null) {
            this.bottomLayout.setVisibility(0);
        }
        setVideoPlayerControlVisible(!this.isCurrentVideo, true);
        if (!this.isCurrentVideo) {
            scheduleActionBarHide(this.playerAutoStarted ? 3000 : CloseCodes.NORMAL_CLOSURE);
        }
        this.inPreview = z2;
    }

    /* renamed from: org.rbmain.ui.PhotoViewer$43, reason: invalid class name */
    class AnonymousClass43 implements VideoPlayer.VideoPlayerDelegate {
        @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
        public /* synthetic */ void onSeekFinished(AnalyticsListener.EventTime eventTime) {
            VideoPlayer.VideoPlayerDelegate.CC.$default$onSeekFinished(this, eventTime);
        }

        @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
        public /* synthetic */ void onSeekStarted(AnalyticsListener.EventTime eventTime) {
            VideoPlayer.VideoPlayerDelegate.CC.$default$onSeekStarted(this, eventTime);
        }

        AnonymousClass43() {
        }

        @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
        public void onStateChanged(boolean z, int i) {
            PhotoViewer.this.updatePlayerState(z, i);
        }

        @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
        public void onError(VideoPlayer videoPlayer, Exception exc) {
            if (PhotoViewer.this.videoPlayer != videoPlayer) {
                return;
            }
            FileLog.e(exc);
            if (PhotoViewer.this.menuItem.isSubItemVisible(11)) {
                AlertDialog.Builder builder = new AlertDialog.Builder(PhotoViewer.this.parentActivity);
                builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
                builder.setMessage(LocaleController.getString("CantPlayVideo", R.string.CantPlayVideo));
                builder.setPositiveButton(LocaleController.getString("Open", R.string.Open), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.PhotoViewer$43$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onError$0(dialogInterface, i);
                    }
                });
                builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                PhotoViewer.this.showAlertDialog(builder);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onError$0(DialogInterface dialogInterface, int i) {
            try {
                AndroidUtilities.openForView(PhotoViewer.this.currentMessageObject, PhotoViewer.this.parentActivity);
                PhotoViewer.this.closePhoto(false, false);
            } catch (Exception e) {
                FileLog.e(e);
            }
        }

        @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
        public void onVideoSizeChanged(int i, int i2, int i3, float f) {
            if (PhotoViewer.this.aspectRatioFrameLayout != null) {
                if (i3 != 90 && i3 != 270) {
                    i2 = i;
                    i = i2;
                }
                PhotoViewer.this.aspectRatioFrameLayout.setAspectRatio(i == 0 ? 1.0f : (i2 * f) / i, i3);
                if (PhotoViewer.this.videoTextureView instanceof VideoEditTextureView) {
                    ((VideoEditTextureView) PhotoViewer.this.videoTextureView).setVideoSize((int) (i2 * f), i);
                    if (PhotoViewer.this.sendPhotoType == 1) {
                        PhotoViewer.this.setCropBitmap();
                    }
                }
                PhotoViewer.this.videoSizeSet = true;
            }
        }

        @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
        public void onRenderedFirstFrame() {
            if (PhotoViewer.this.textureUploaded) {
                return;
            }
            PhotoViewer.this.textureUploaded = true;
            PhotoViewer.this.containerView.invalidate();
        }

        @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
        public void onRenderedFirstFrame(AnalyticsListener.EventTime eventTime) {
            if (eventTime.eventPlaybackPositionMs == PhotoViewer.this.needCaptureFrameReadyAtTime) {
                PhotoViewer.this.captureFrameReadyAtTime = eventTime.eventPlaybackPositionMs;
                PhotoViewer.this.needCaptureFrameReadyAtTime = -1L;
                PhotoViewer.this.captureCurrentFrame();
            }
        }

        @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
        public boolean onSurfaceDestroyed(SurfaceTexture surfaceTexture) {
            if (PhotoViewer.this.changingTextureView) {
                PhotoViewer.this.changingTextureView = false;
                if (PhotoViewer.this.isInline) {
                    PhotoViewer.this.waitingForFirstTextureUpload = 1;
                    PhotoViewer.this.changedTextureView.setSurfaceTexture(surfaceTexture);
                    PhotoViewer.this.changedTextureView.setSurfaceTextureListener(PhotoViewer.this.surfaceTextureListener);
                    PhotoViewer.this.changedTextureView.setVisibility(0);
                    return true;
                }
            }
            return false;
        }

        @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            if (PhotoViewer.this.waitingForFirstTextureUpload == 2) {
                if (PhotoViewer.this.textureImageView != null) {
                    PhotoViewer.this.textureImageView.setVisibility(4);
                    PhotoViewer.this.textureImageView.setImageDrawable(null);
                    if (PhotoViewer.this.currentBitmap != null) {
                        PhotoViewer.this.currentBitmap.recycle();
                        PhotoViewer.this.currentBitmap = null;
                    }
                }
                PhotoViewer.this.switchingInlineMode = false;
                if (Build.VERSION.SDK_INT >= 21) {
                    PhotoViewer.this.aspectRatioFrameLayout.getLocationInWindow(PhotoViewer.this.pipPosition);
                    PhotoViewer.this.pipPosition[1] = (int) (r11[1] - PhotoViewer.this.containerView.getTranslationY());
                    PhotoViewer.this.textureImageView.setTranslationX(PhotoViewer.this.textureImageView.getTranslationX() + PhotoViewer.this.getLeftInset());
                    PhotoViewer.this.videoTextureView.setTranslationX((PhotoViewer.this.videoTextureView.getTranslationX() + PhotoViewer.this.getLeftInset()) - PhotoViewer.this.aspectRatioFrameLayout.getX());
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(ObjectAnimator.ofFloat(PhotoViewer.this.textureImageView, (Property<ImageView, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(PhotoViewer.this.textureImageView, (Property<ImageView, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(PhotoViewer.this.textureImageView, (Property<ImageView, Float>) View.TRANSLATION_X, PhotoViewer.this.pipPosition[0]), ObjectAnimator.ofFloat(PhotoViewer.this.textureImageView, (Property<ImageView, Float>) View.TRANSLATION_Y, PhotoViewer.this.pipPosition[1]), ObjectAnimator.ofFloat(PhotoViewer.this.videoTextureView, (Property<TextureView, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(PhotoViewer.this.videoTextureView, (Property<TextureView, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(PhotoViewer.this.videoTextureView, (Property<TextureView, Float>) View.TRANSLATION_X, PhotoViewer.this.pipPosition[0] - PhotoViewer.this.aspectRatioFrameLayout.getX()), ObjectAnimator.ofFloat(PhotoViewer.this.videoTextureView, (Property<TextureView, Float>) View.TRANSLATION_Y, PhotoViewer.this.pipPosition[1] - PhotoViewer.this.aspectRatioFrameLayout.getY()), ObjectAnimator.ofInt(PhotoViewer.this.backgroundDrawable, (Property<BackgroundDrawable, Integer>) AnimationProperties.COLOR_DRAWABLE_ALPHA, 255));
                    DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
                    animatorSet.setInterpolator(decelerateInterpolator);
                    animatorSet.setDuration(250L);
                    animatorSet.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.PhotoViewer.43.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            PhotoViewer.this.pipAnimationInProgress = false;
                        }
                    });
                    animatorSet.start();
                    PhotoViewer.this.toggleActionBar(true, true, new ActionBarToggleParams().enableStatusBarAnimation(false).enableTranslationAnimation(false).animationDuration(250).animationInterpolator(decelerateInterpolator));
                } else {
                    PhotoViewer.this.toggleActionBar(true, false);
                }
                PhotoViewer.this.waitingForFirstTextureUpload = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkFullscreenButton() {
        float f;
        TextureView textureView;
        TextureView textureView2;
        if (this.imagesArr.isEmpty()) {
            for (int i = 0; i < 3; i++) {
                this.fullscreenButton[i].setVisibility(4);
            }
            return;
        }
        int i2 = 0;
        while (i2 < 3) {
            int i3 = this.currentIndex;
            if (i2 == 1) {
                i3++;
            } else if (i2 == 2) {
                i3--;
            }
            if (i3 < 0 || i3 >= this.imagesArr.size()) {
                this.fullscreenButton[i2].setVisibility(4);
            } else {
                MessageObject messageObject = this.imagesArr.get(i3);
                if (!messageObject.isVideo() && !messageObject.isVideoFile()) {
                    this.fullscreenButton[i2].setVisibility(4);
                } else {
                    int measuredWidth = (i2 != 0 || (textureView2 = this.videoTextureView) == null) ? 0 : textureView2.getMeasuredWidth();
                    int measuredHeight = (i2 != 0 || (textureView = this.videoTextureView) == null) ? 0 : textureView.getMeasuredHeight();
                    TLRPC$Document document = messageObject.getDocument();
                    int size = document.attributes.size();
                    int i4 = 0;
                    while (true) {
                        if (i4 >= size) {
                            break;
                        }
                        TLRPC$DocumentAttribute tLRPC$DocumentAttribute = document.attributes.get(i4);
                        if (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeVideo) {
                            measuredWidth = tLRPC$DocumentAttribute.w;
                            measuredHeight = tLRPC$DocumentAttribute.h;
                            break;
                        }
                        i4++;
                    }
                    Point point = AndroidUtilities.displaySize;
                    if (point.y > point.x && !(this.videoTextureView instanceof VideoEditTextureView) && measuredWidth > measuredHeight) {
                        if (this.fullscreenButton[i2].getVisibility() != 0) {
                            this.fullscreenButton[i2].setVisibility(0);
                        }
                        ((FrameLayout.LayoutParams) this.fullscreenButton[i2].getLayoutParams()).topMargin = ((this.containerView.getMeasuredHeight() + ((int) (measuredHeight / (measuredWidth / this.containerView.getMeasuredWidth())))) / 2) - AndroidUtilities.dp(48.0f);
                    } else if (this.fullscreenButton[i2].getVisibility() != 4) {
                        this.fullscreenButton[i2].setVisibility(4);
                    }
                    if (this.imageMoveAnimation != null) {
                        float f2 = this.translationX;
                        f = f2 + ((this.animateToX - f2) * this.animationValue);
                    } else {
                        f = this.translationX;
                    }
                    float fDp = 0.0f;
                    if (i2 != 1) {
                        if (i2 == 2) {
                            fDp = ((-AndroidUtilities.displaySize.x) - AndroidUtilities.dp(15.0f)) + (f - this.maxX);
                        } else {
                            float f3 = this.minX;
                            if (f < f3) {
                                fDp = f - f3;
                            }
                        }
                    }
                    this.fullscreenButton[i2].setTranslationX((fDp + AndroidUtilities.displaySize.x) - AndroidUtilities.dp(48.0f));
                }
            }
            i2++;
        }
    }

    private void createVideoTextureView(final MediaController.SavedFilterState savedFilterState) {
        if (this.videoTextureView != null) {
            return;
        }
        AspectRatioFrameLayout aspectRatioFrameLayout = new AspectRatioFrameLayout(this.parentActivity) { // from class: org.rbmain.ui.PhotoViewer.44
            @Override // com.google.android.exoplayer2t.ui.AspectRatioFrameLayout, android.widget.FrameLayout, android.view.View
            protected void onMeasure(int i, int i2) {
                super.onMeasure(i, i2);
                if (PhotoViewer.this.textureImageView != null) {
                    ViewGroup.LayoutParams layoutParams = PhotoViewer.this.textureImageView.getLayoutParams();
                    layoutParams.width = getMeasuredWidth();
                    layoutParams.height = getMeasuredHeight();
                }
                if (PhotoViewer.this.videoTextureView instanceof VideoEditTextureView) {
                    PhotoViewer.this.videoTextureView.setPivotX(PhotoViewer.this.videoTextureView.getMeasuredWidth() / 2);
                } else {
                    PhotoViewer.this.videoTextureView.setPivotX(0.0f);
                }
                PhotoViewer.this.checkFullscreenButton();
            }
        };
        this.aspectRatioFrameLayout = aspectRatioFrameLayout;
        aspectRatioFrameLayout.setVisibility(4);
        this.containerView.addView(this.aspectRatioFrameLayout, 0, LayoutHelper.createFrame(-1, -1, 17));
        if (this.imagesArrLocals.isEmpty()) {
            this.videoTextureView = new TextureView(this.parentActivity);
        } else {
            VideoEditTextureView videoEditTextureView = new VideoEditTextureView(this.parentActivity, this.videoPlayer);
            if (savedFilterState != null) {
                videoEditTextureView.setDelegate(new VideoEditTextureView.VideoEditTextureViewDelegate() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda67
                    @Override // org.rbmain.ui.Components.VideoEditTextureView.VideoEditTextureViewDelegate
                    public final void onEGLThreadAvailable(FilterGLThread filterGLThread) {
                        PhotoViewer.lambda$createVideoTextureView$43(savedFilterState, filterGLThread);
                    }
                });
            }
            this.videoTextureView = videoEditTextureView;
        }
        SurfaceTexture surfaceTexture = this.injectingVideoPlayerSurface;
        if (surfaceTexture != null) {
            this.videoTextureView.setSurfaceTexture(surfaceTexture);
            this.textureUploaded = true;
            this.videoSizeSet = true;
            this.injectingVideoPlayerSurface = null;
        }
        this.videoTextureView.setPivotX(0.0f);
        this.videoTextureView.setPivotY(0.0f);
        this.videoTextureView.setOpaque(false);
        this.aspectRatioFrameLayout.addView(this.videoTextureView, LayoutHelper.createFrame(-1, -1, 17));
        if (this.sendPhotoType == 1) {
            View view = new View(this.parentActivity);
            this.flashView = view;
            view.setBackgroundColor(-1);
            this.flashView.setAlpha(0.0f);
            this.aspectRatioFrameLayout.addView(this.flashView, LayoutHelper.createFrame(-1, -1, 17));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createVideoTextureView$43(MediaController.SavedFilterState savedFilterState, FilterGLThread filterGLThread) {
        filterGLThread.setFilterGLThreadDelegate(FilterShaders.getFilterShadersDelegate(savedFilterState));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releasePlayer(boolean z) {
        if (this.videoPlayer != null) {
            cancelVideoPlayRunnable();
            AndroidUtilities.cancelRunOnUIThread(this.setLoadingRunnable);
            AndroidUtilities.cancelRunOnUIThread(this.hideActionBarRunnable);
            if (this.shouldSavePositionForCurrentVideoShortTerm != null) {
                this.savedVideoPositions.put(this.shouldSavePositionForCurrentVideoShortTerm, new SavedVideoPosition(this.videoPlayer.getCurrentPosition() / this.videoPlayer.getDuration(), SystemClock.elapsedRealtime()));
            }
            this.videoPlayer.releasePlayer(true);
            this.videoPlayer = null;
        } else {
            this.playerWasPlaying = false;
        }
        OrientationEventListener orientationEventListener = this.orientationEventListener;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
            this.orientationEventListener = null;
        }
        this.videoPreviewFrame.close();
        toggleMiniProgress(false, false);
        this.pipAvailable = false;
        this.playerInjected = false;
        if (this.pipItem.isEnabled()) {
            this.pipItem.setEnabled(false);
            this.pipItem.animate().alpha(0.5f).setDuration(175L).withEndAction(null).start();
        }
        if (this.keepScreenOnFlagSet) {
            try {
                this.parentActivity.getWindow().clearFlags(128);
                this.keepScreenOnFlagSet = false;
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
        AspectRatioFrameLayout aspectRatioFrameLayout = this.aspectRatioFrameLayout;
        if (aspectRatioFrameLayout != null) {
            try {
                this.containerView.removeView(aspectRatioFrameLayout);
            } catch (Throwable unused) {
            }
            this.aspectRatioFrameLayout = null;
        }
        cancelFlashAnimations();
        this.flashView = null;
        TextureView textureView = this.videoTextureView;
        if (textureView != null) {
            if (textureView instanceof VideoEditTextureView) {
                ((VideoEditTextureView) textureView).release();
            }
            this.videoTextureView = null;
        }
        if (this.isPlaying) {
            this.isPlaying = false;
            AndroidUtilities.cancelRunOnUIThread(this.updateProgressRunnable);
        }
        if (!z && !this.inPreview && !this.requestingPreview) {
            setVideoPlayerControlVisible(false, true);
        }
        this.photoProgressViews[0].resetAlphas();
    }

    private void setVideoPlayerControlVisible(final boolean z, boolean z2) {
        if (this.videoPlayerControlVisible != z) {
            Animator animator = this.videoPlayerControlAnimator;
            if (animator != null) {
                animator.cancel();
            }
            this.videoPlayerControlVisible = z;
            if (z2) {
                if (z) {
                    this.videoPlayerControlFrameLayout.setVisibility(0);
                } else {
                    this.dateTextView.setVisibility(0);
                    this.nameTextView.setVisibility(0);
                    if (this.allowShare) {
                        this.bottomButtonsLayout.setVisibility(0);
                    }
                }
                final boolean z3 = this.allowShare;
                float[] fArr = new float[2];
                fArr[0] = this.videoPlayerControlFrameLayout.getAlpha();
                fArr[1] = z ? 1.0f : 0.0f;
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
                valueAnimatorOfFloat.setDuration(200L);
                valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        this.f$0.lambda$setVideoPlayerControlVisible$44(z3, valueAnimator);
                    }
                });
                valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.PhotoViewer.45
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator2) {
                        if (!z) {
                            PhotoViewer.this.videoPlayerControlFrameLayout.setVisibility(8);
                            return;
                        }
                        PhotoViewer.this.dateTextView.setVisibility(8);
                        PhotoViewer.this.nameTextView.setVisibility(8);
                        if (z3) {
                            PhotoViewer.this.bottomButtonsLayout.setVisibility(8);
                        }
                    }
                });
                this.videoPlayerControlAnimator = valueAnimatorOfFloat;
                valueAnimatorOfFloat.start();
            } else {
                this.videoPlayerControlFrameLayout.setVisibility(z ? 0 : 8);
                this.videoPlayerControlFrameLayout.setAlpha(z ? 1.0f : 0.0f);
                this.dateTextView.setVisibility(z ? 8 : 0);
                this.dateTextView.setAlpha(z ? 0.0f : 1.0f);
                this.nameTextView.setVisibility(z ? 8 : 0);
                this.nameTextView.setAlpha(z ? 0.0f : 1.0f);
                if (this.allowShare) {
                    this.bottomButtonsLayout.setVisibility(z ? 8 : 0);
                    this.bottomButtonsLayout.setAlpha(z ? 0.0f : 1.0f);
                }
            }
            if (this.allowShare && this.pageBlocksAdapter == null) {
                if (z) {
                    this.menuItem.showSubItem(10);
                } else {
                    this.menuItem.hideSubItem(10);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setVideoPlayerControlVisible$44(boolean z, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.videoPlayerControlFrameLayout.setAlpha(fFloatValue);
        float f = 1.0f - fFloatValue;
        this.dateTextView.setAlpha(f);
        this.nameTextView.setAlpha(f);
        if (z) {
            this.bottomButtonsLayout.setAlpha(f);
        }
    }

    private void updateCaptionTextForCurrentPhoto(Object obj) {
        CharSequence charSequence;
        if (obj instanceof MediaController.PhotoEntry) {
            charSequence = ((MediaController.PhotoEntry) obj).caption;
        } else {
            charSequence = (!(obj instanceof TLRPC$BotInlineResult) && (obj instanceof MediaController.SearchImage)) ? ((MediaController.SearchImage) obj).caption : null;
        }
        if (TextUtils.isEmpty(charSequence)) {
            this.captionEditText.setFieldText(BuildConfig.FLAVOR);
        } else {
            this.captionEditText.setFieldText(charSequence);
        }
        this.captionEditText.setAllowTextEntitiesIntersection(supportsSendingNewEntities());
    }

    public void showAlertDialog(AlertDialog.Builder builder) {
        if (this.parentActivity == null) {
            return;
        }
        try {
            AlertDialog alertDialog = this.visibleDialog;
            if (alertDialog != null) {
                alertDialog.dismiss();
                this.visibleDialog = null;
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
        try {
            AlertDialog alertDialogShow = builder.show();
            this.visibleDialog = alertDialogShow;
            alertDialogShow.setCanceledOnTouchOutside(true);
            this.visibleDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda6
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    this.f$0.lambda$showAlertDialog$45(dialogInterface);
                }
            });
        } catch (Exception e2) {
            FileLog.e(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAlertDialog$45(DialogInterface dialogInterface) {
        this.visibleDialog = null;
    }

    private void mergeImages(String str, String str2, Bitmap bitmap, Bitmap bitmap2, float f, boolean z) {
        boolean z2;
        if (bitmap == null) {
            try {
                bitmap = BitmapFactory.decodeFile(str2);
                z2 = true;
            } catch (Throwable th) {
                FileLog.e(th);
                return;
            }
        } else {
            z2 = false;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f2 = width;
        if (f2 > f || height > f) {
            float fMax = Math.max(width, height) / f;
            height = (int) (height / fMax);
            width = (int) (f2 / fMax);
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Rect rect = new Rect(0, 0, width, height);
        if (z) {
            canvas.drawBitmap(bitmap2, (Rect) null, rect, this.bitmapPaint);
            canvas.drawBitmap(bitmap, (Rect) null, rect, this.bitmapPaint);
        } else {
            canvas.drawBitmap(bitmap, (Rect) null, rect, this.bitmapPaint);
            canvas.drawBitmap(bitmap2, (Rect) null, rect, this.bitmapPaint);
        }
        FileOutputStream fileOutputStream = new FileOutputStream(new File(str));
        bitmapCreateBitmap.compress(Bitmap.CompressFormat.JPEG, f == 512.0f ? 83 : 87, fileOutputStream);
        try {
            fileOutputStream.close();
        } catch (Exception e) {
            FileLog.e(e);
        }
        if (z2) {
            bitmap.recycle();
        }
        bitmapCreateBitmap.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void seekAnimatedStickersTo(long j) {
        RLottieDrawable lottieAnimation;
        ArrayList<VideoEditedInfo.MediaEntity> arrayList = this.editState.mediaEntities;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                VideoEditedInfo.MediaEntity mediaEntity = this.editState.mediaEntities.get(i);
                if (mediaEntity.type == 0 && (mediaEntity.subType & 1) != 0) {
                    View view = mediaEntity.view;
                    if ((view instanceof BackupImageView) && (lottieAnimation = ((BackupImageView) view).getImageReceiver().getLottieAnimation()) != null) {
                        long j2 = this.startTime;
                        lottieAnimation.setProgressMs(j - (j2 > 0 ? j2 / 1000 : 0L));
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playOrStopAnimatedStickers(boolean z) {
        RLottieDrawable lottieAnimation;
        ArrayList<VideoEditedInfo.MediaEntity> arrayList = this.editState.mediaEntities;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                VideoEditedInfo.MediaEntity mediaEntity = this.editState.mediaEntities.get(i);
                if (mediaEntity.type == 0 && (mediaEntity.subType & 1) != 0) {
                    View view = mediaEntity.view;
                    if ((view instanceof BackupImageView) && (lottieAnimation = ((BackupImageView) view).getImageReceiver().getLottieAnimation()) != null) {
                        if (z) {
                            lottieAnimation.start();
                        } else {
                            lottieAnimation.stop();
                        }
                    }
                }
            }
        }
    }

    private int getAnimatedMediaEntitiesCount(boolean z) {
        ArrayList<VideoEditedInfo.MediaEntity> arrayList = this.editState.mediaEntities;
        if (arrayList == null) {
            return 0;
        }
        int size = arrayList.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            VideoEditedInfo.MediaEntity mediaEntity = this.editState.mediaEntities.get(i2);
            if (mediaEntity.type == 0 && (mediaEntity.subType & 1) != 0) {
                i++;
                if (z) {
                    break;
                }
            }
        }
        return i;
    }

    private boolean hasAnimatedMediaEntities() {
        return getAnimatedMediaEntitiesCount(true) != 0;
    }

    private Bitmap createCroppedBitmap(Bitmap bitmap, MediaController.CropState cropState, int[] iArr, boolean z) {
        int i;
        int i2;
        try {
            int i3 = cropState.transformRotation + (iArr != null ? iArr[0] : 0);
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (i3 == 90 || i3 == 270) {
                i = width;
                i2 = height;
            } else {
                i2 = width;
                i = height;
            }
            float f = i2;
            float f2 = i;
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) (cropState.cropPw * f), (int) (cropState.cropPh * f2), Bitmap.Config.ARGB_8888);
            Matrix matrix = new Matrix();
            matrix.postTranslate((-width) / 2, (-height) / 2);
            if (z && cropState.mirrored) {
                if (i3 == 90 || i3 == 270) {
                    matrix.postScale(1.0f, -1.0f);
                } else {
                    matrix.postScale(-1.0f, 1.0f);
                }
            }
            matrix.postRotate(cropState.cropRotate + i3);
            matrix.postTranslate(cropState.cropPx * f, cropState.cropPy * f2);
            float f3 = cropState.cropScale;
            matrix.postScale(f3, f3);
            matrix.postTranslate(r6 / 2, r7 / 2);
            new Canvas(bitmapCreateBitmap).drawBitmap(bitmap, matrix, new Paint(2));
            return bitmapCreateBitmap;
        } catch (Throwable th) {
            FileLog.e(th);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:169:0x04e4  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x054b  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x057d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0584 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x058e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x029b  */
    /* JADX WARN: Type inference failed for: r12v2, types: [org.rbmain.messenger.MediaController$SavedFilterState] */
    /* JADX WARN: Type inference failed for: r5v11, types: [java.util.ArrayList<org.rbmain.tgnet.TLRPC$InputDocument>] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void applyCurrentEditMode() {
        /*
            Method dump skipped, instructions count: 2065
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.PhotoViewer.applyCurrentEditMode():void");
    }

    private void setPhotoChecked() {
        ChatActivity chatActivity;
        TLRPC$Chat currentChat;
        PhotoViewerProvider photoViewerProvider = this.placeProvider;
        if (photoViewerProvider != null) {
            if (photoViewerProvider.getSelectedPhotos() != null && this.maxSelectedPhotos > 0 && this.placeProvider.getSelectedPhotos().size() >= this.maxSelectedPhotos && !this.placeProvider.isPhotoChecked(this.currentIndex)) {
                if (!this.allowOrder || (chatActivity = this.parentChatActivity) == null || (currentChat = chatActivity.getCurrentChat()) == null || ChatObject.hasAdminRights(currentChat) || !currentChat.slowmode_enabled) {
                    return;
                }
                AlertsCreator.createSimpleAlert(this.parentActivity, LocaleController.getString("Slowmode", R.string.Slowmode), LocaleController.getString("SlowmodeSelectSendError", R.string.SlowmodeSelectSendError)).show();
                return;
            }
            int photoChecked = this.placeProvider.setPhotoChecked(this.currentIndex, getCurrentVideoEditedInfo());
            boolean zIsPhotoChecked = this.placeProvider.isPhotoChecked(this.currentIndex);
            this.checkImageView.setChecked(zIsPhotoChecked, true);
            if (photoChecked >= 0) {
                if (zIsPhotoChecked) {
                    this.selectedPhotosAdapter.notifyItemInserted(photoChecked);
                    this.selectedPhotosListView.smoothScrollToPosition(photoChecked);
                } else {
                    this.selectedPhotosAdapter.notifyItemRemoved(photoChecked);
                    if (photoChecked == 0) {
                        this.selectedPhotosAdapter.notifyItemChanged(0);
                    }
                }
            }
            updateSelectedCount();
        }
    }

    private void createCropView() {
        if (this.photoCropView != null) {
            return;
        }
        PhotoCropView photoCropView = new PhotoCropView(this.activityContext);
        this.photoCropView = photoCropView;
        photoCropView.setVisibility(8);
        this.photoCropView.onDisappear();
        this.containerView.addView(this.photoCropView, this.containerView.indexOfChild(this.videoTimelineView) - 1, LayoutHelper.createFrame(-1, -1.0f, 51, 0.0f, 0.0f, 0.0f, 48.0f));
        this.photoCropView.setDelegate(new AnonymousClass46());
    }

    /* renamed from: org.rbmain.ui.PhotoViewer$46, reason: invalid class name */
    class AnonymousClass46 implements PhotoCropView.PhotoCropViewDelegate {
        AnonymousClass46() {
        }

        @Override // org.rbmain.ui.Components.PhotoCropView.PhotoCropViewDelegate
        public void onChange(boolean z) {
            PhotoViewer.this.resetButton.setVisibility(z ? 8 : 0);
        }

        @Override // org.rbmain.ui.Components.PhotoCropView.PhotoCropViewDelegate
        public void onUpdate() {
            PhotoViewer.this.containerView.invalidate();
        }

        @Override // org.rbmain.ui.Components.PhotoCropView.PhotoCropViewDelegate
        public void onTapUp() {
            if (PhotoViewer.this.sendPhotoType == 1) {
                PhotoViewer.this.manuallyPaused = true;
                PhotoViewer.this.toggleVideoPlayer();
            }
        }

        @Override // org.rbmain.ui.Components.PhotoCropView.PhotoCropViewDelegate
        public void onVideoThumbClick() {
            if (PhotoViewer.this.videoPlayer == null) {
                return;
            }
            PhotoViewer.this.videoPlayer.seekTo((long) (PhotoViewer.this.videoPlayer.getDuration() * PhotoViewer.this.avatarStartProgress));
            PhotoViewer.this.videoPlayer.pause();
            PhotoViewer.this.videoTimelineView.setProgress(PhotoViewer.this.avatarStartProgress);
            PhotoViewer.this.cancelVideoPlayRunnable();
            AndroidUtilities.runOnUIThread(PhotoViewer.this.videoPlayRunnable = new Runnable() { // from class: org.rbmain.ui.PhotoViewer$46$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onVideoThumbClick$0();
                }
            }, 860L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onVideoThumbClick$0() {
            PhotoViewer.this.manuallyPaused = false;
            if (PhotoViewer.this.videoPlayer != null) {
                PhotoViewer.this.videoPlayer.play();
            }
            PhotoViewer.this.videoPlayRunnable = null;
        }

        @Override // org.rbmain.ui.Components.PhotoCropView.PhotoCropViewDelegate
        public int getVideoThumbX() {
            return (int) (AndroidUtilities.dp(16.0f) + ((PhotoViewer.this.videoTimelineView.getMeasuredWidth() - AndroidUtilities.dp(32.0f)) * PhotoViewer.this.avatarStartProgress));
        }
    }

    private void startVideoPlayer() {
        VideoPlayer videoPlayer;
        if (!this.isCurrentVideo || (videoPlayer = this.videoPlayer) == null || videoPlayer.isPlaying()) {
            return;
        }
        if (!this.muteVideo || this.sendPhotoType == 1) {
            this.videoPlayer.setVolume(0.0f);
        }
        this.manuallyPaused = false;
        toggleVideoPlayer();
    }

    private void detectFaces() {
        if (this.centerImage.getAnimation() != null || this.imagesArrLocals.isEmpty() || this.sendPhotoType == 1) {
            return;
        }
        String imageKey = this.centerImage.getImageKey();
        String str = this.currentImageFaceKey;
        if (str == null || !str.equals(imageKey)) {
            this.currentImageHasFace = 0;
            detectFaces(imageKey, this.centerImage.getBitmapSafe(), this.centerImage.getOrientation());
        }
    }

    private void detectFaces(final String str, final ImageReceiver.BitmapHolder bitmapHolder, final int i) {
        if (str == null || bitmapHolder == null || bitmapHolder.bitmap == null) {
            return;
        }
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda54
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$detectFaces$48(bitmapHolder, i, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$detectFaces$48(final ImageReceiver.BitmapHolder bitmapHolder, int i, final String str) {
        FaceDetector faceDetectorBuild = null;
        try {
            try {
                final boolean z = false;
                faceDetectorBuild = new FaceDetector.Builder(ApplicationLoader.applicationContext).setMode(0).setLandmarkType(0).setTrackingEnabled(false).build();
                if (faceDetectorBuild.isOperational()) {
                    SparseArray<Face> sparseArrayDetect = faceDetectorBuild.detect(new Frame.Builder().setBitmap(bitmapHolder.bitmap).setRotation(i).build());
                    if (sparseArrayDetect != null && sparseArrayDetect.size() != 0) {
                        z = true;
                    }
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda53
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$detectFaces$46(str, z);
                        }
                    });
                } else {
                    if (BuildVars.LOGS_ENABLED) {
                        FileLog.e("face detection is not operational");
                    }
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda55
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$detectFaces$47(bitmapHolder, str);
                        }
                    });
                }
            } catch (Exception e) {
                FileLog.e(e);
                if (0 == 0) {
                    return;
                }
            }
            faceDetectorBuild.release();
        } catch (Throwable th) {
            if (0 != 0) {
                faceDetectorBuild.release();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$detectFaces$46(String str, boolean z) {
        if (str.equals(this.centerImage.getImageKey())) {
            this.currentImageHasFace = z ? 1 : 0;
            this.currentImageFaceKey = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$detectFaces$47(ImageReceiver.BitmapHolder bitmapHolder, String str) {
        bitmapHolder.release();
        if (str.equals(this.centerImage.getImageKey())) {
            this.currentImageHasFace = 2;
            this.currentImageFaceKey = str;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void switchToEditMode(final int r28) {
        /*
            Method dump skipped, instructions count: 2154
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.PhotoViewer.switchToEditMode(int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$switchToEditMode$49(View view) {
        applyCurrentEditMode();
        switchToEditMode(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$switchToEditMode$51(View view) {
        if (this.photoFilterView.hasChanges()) {
            Activity activity = this.parentActivity;
            if (activity == null) {
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setMessage(LocaleController.getString("DiscardChanges", R.string.DiscardChanges));
            builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
            builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda5
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$switchToEditMode$50(dialogInterface, i);
                }
            });
            builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            showAlertDialog(builder);
            return;
        }
        switchToEditMode(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$switchToEditMode$50(DialogInterface dialogInterface, int i) {
        switchToEditMode(0);
    }

    private void createPaintView() {
        int bitmapWidth;
        int bitmapHeight;
        MediaController.CropState cropState;
        if (this.photoPaintView == null) {
            TextureView textureView = this.videoTextureView;
            if (textureView != null) {
                VideoEditTextureView videoEditTextureView = (VideoEditTextureView) textureView;
                bitmapWidth = videoEditTextureView.getVideoWidth();
                bitmapHeight = videoEditTextureView.getVideoHeight();
                while (true) {
                    if (bitmapWidth <= 1280 && bitmapHeight <= 1280) {
                        break;
                    }
                    bitmapWidth /= 2;
                    bitmapHeight /= 2;
                }
            } else {
                bitmapWidth = this.centerImage.getBitmapWidth();
                bitmapHeight = this.centerImage.getBitmapHeight();
            }
            Bitmap bitmap = this.paintingOverlay.getBitmap();
            if (bitmap == null) {
                bitmap = Bitmap.createBitmap(bitmapWidth, bitmapHeight, Bitmap.Config.ARGB_8888);
            }
            Bitmap bitmap2 = bitmap;
            if (this.sendPhotoType == 1) {
                cropState = new MediaController.CropState();
                cropState.transformRotation = this.cropTransform.getOrientation();
            } else {
                cropState = this.editState.cropState;
            }
            PhotoPaintView photoPaintView = new PhotoPaintView(this.parentActivity, bitmap2, this.isCurrentVideo ? null : this.centerImage.getBitmap(), this.centerImage.getOrientation(), this.editState.mediaEntities, cropState, new Runnable() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda47
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$createPaintView$52();
                }
            }) { // from class: org.rbmain.ui.PhotoViewer.51
                @Override // org.rbmain.ui.Components.PhotoPaintView
                protected void onOpenCloseStickersAlert(boolean z) {
                    if (PhotoViewer.this.videoPlayer == null) {
                        return;
                    }
                    PhotoViewer.this.manuallyPaused = false;
                    PhotoViewer.this.cancelVideoPlayRunnable();
                    if (z) {
                        PhotoViewer.this.videoPlayer.pause();
                    } else {
                        PhotoViewer.this.videoPlayer.play();
                    }
                }

                @Override // org.rbmain.ui.Components.PhotoPaintView
                protected void didSetAnimatedSticker(RLottieDrawable rLottieDrawable) {
                    if (PhotoViewer.this.videoPlayer == null) {
                        return;
                    }
                    rLottieDrawable.setProgressMs(PhotoViewer.this.videoPlayer.getCurrentPosition() - (PhotoViewer.this.startTime > 0 ? PhotoViewer.this.startTime / 1000 : 0L));
                }

                @Override // org.rbmain.ui.Components.PhotoPaintView
                protected void onTextAdd() {
                    if (PhotoViewer.this.windowView.isFocusable()) {
                        return;
                    }
                    PhotoViewer.this.makeFocusable();
                }
            };
            this.photoPaintView = photoPaintView;
            this.containerView.addView(photoPaintView, LayoutHelper.createFrame(-1, -1.0f));
            this.photoPaintView.getDoneTextView().setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda29
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$createPaintView$53(view);
                }
            });
            this.photoPaintView.getCancelTextView().setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$createPaintView$54(view);
                }
            });
            this.photoPaintView.getColorPicker().setTranslationY(AndroidUtilities.dp(126.0f));
            this.photoPaintView.getToolsView().setTranslationY(AndroidUtilities.dp(126.0f));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createPaintView$52() {
        this.paintingOverlay.hideBitmap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createPaintView$53(View view) {
        this.savedState = null;
        applyCurrentEditMode();
        switchToEditMode(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createPaintView$54(View view) {
        closePaintMode();
    }

    private void closePaintMode() {
        this.photoPaintView.maybeShowDismissalAlert(this, this.parentActivity, new Runnable() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda46
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$closePaintMode$55();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$closePaintMode$55() {
        switchToEditMode(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchToPaintMode() {
        this.changeModeAnimation = null;
        this.pickerView.setVisibility(8);
        this.pickerViewSendButton.setVisibility(8);
        this.cameraItem.setVisibility(8);
        this.muteItem.setVisibility(8);
        PhotoCropView photoCropView = this.photoCropView;
        if (photoCropView != null) {
            photoCropView.setVisibility(4);
        }
        this.selectedPhotosListView.setVisibility(8);
        this.selectedPhotosListView.setAlpha(0.0f);
        this.selectedPhotosListView.setTranslationY(-AndroidUtilities.dp(10.0f));
        this.photosCounterView.setRotationX(0.0f);
        this.selectedPhotosListView.setEnabled(false);
        this.isPhotosListViewVisible = false;
        if (this.needCaptionLayout) {
            this.captionTextViewSwitcher.setVisibility(4);
        }
        int i = this.sendPhotoType;
        if (i == 0 || i == 4 || ((i == 2 || i == 5) && this.imagesArrLocals.size() > 1)) {
            this.checkImageView.setVisibility(8);
            this.photosCounterView.setVisibility(8);
        }
        if (this.centerImage.getBitmap() != null) {
            int bitmapWidth = this.centerImage.getBitmapWidth();
            int bitmapHeight = this.centerImage.getBitmapHeight();
            if (this.sendPhotoType == 1) {
                this.animateToY = AndroidUtilities.dp(12.0f);
                if (this.cropTransform.getOrientation() == 90 || this.cropTransform.getOrientation() == 270) {
                    bitmapHeight = bitmapWidth;
                    bitmapWidth = bitmapHeight;
                }
            } else {
                this.animateToY = (-AndroidUtilities.dp(44.0f)) + (isStatusBarVisible() ? AndroidUtilities.statusBarHeight / 2 : 0);
                MediaController.CropState cropState = this.editState.cropState;
                if (cropState != null) {
                    int i2 = cropState.transformRotation;
                    if (i2 == 90 || i2 == 270) {
                        bitmapHeight = bitmapWidth;
                        bitmapWidth = bitmapHeight;
                    }
                    bitmapWidth = (int) (bitmapWidth * cropState.cropPw);
                    bitmapHeight = (int) (bitmapHeight * cropState.cropPh);
                }
            }
            float f = bitmapWidth;
            float f2 = bitmapHeight;
            this.animateToScale = Math.min(getContainerViewWidth(3) / f, getContainerViewHeight(3) / f2) / Math.min(getContainerViewWidth() / f, getContainerViewHeight() / f2);
            this.animateToX = (getLeftInset() / 2) - (getRightInset() / 2);
            this.animationStartTime = System.currentTimeMillis();
            this.zoomAnimation = true;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        this.imageMoveAnimation = animatorSet;
        animatorSet.playTogether(ObjectAnimator.ofFloat(this, AnimationProperties.PHOTO_VIEWER_ANIMATION_VALUE, 0.0f, 1.0f), ObjectAnimator.ofFloat(this.photoPaintView.getColorPicker(), (Property<ColorPicker, Float>) View.TRANSLATION_Y, AndroidUtilities.dp(126.0f), 0.0f), ObjectAnimator.ofFloat(this.photoPaintView.getToolsView(), (Property<FrameLayout, Float>) View.TRANSLATION_Y, AndroidUtilities.dp(126.0f), 0.0f));
        this.imageMoveAnimation.setDuration(200L);
        this.imageMoveAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.PhotoViewer.52
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PhotoViewer.this.photoPaintView.init();
                PhotoViewer.this.paintingOverlay.hideEntities();
                PhotoViewer.this.imageMoveAnimation = null;
                PhotoViewer.this.currentEditMode = 3;
                PhotoViewer.this.switchingToMode = -1;
                PhotoViewer.this.animateToScale = 1.0f;
                PhotoViewer.this.animateToX = 0.0f;
                PhotoViewer.this.animateToY = 0.0f;
                PhotoViewer.this.scale = 1.0f;
                PhotoViewer photoViewer = PhotoViewer.this;
                photoViewer.updateMinMax(photoViewer.scale);
                PhotoViewer.this.padImageForHorizontalInsets = true;
                PhotoViewer.this.containerView.invalidate();
            }
        });
        this.imageMoveAnimation.start();
    }

    private void toggleCheckImageView(boolean z) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        float fDpf2 = AndroidUtilities.dpf2(24.0f);
        FrameLayout frameLayout = this.pickerView;
        Property property = View.ALPHA;
        float[] fArr = new float[1];
        fArr[0] = z ? 1.0f : 0.0f;
        arrayList.add(ObjectAnimator.ofFloat(frameLayout, (Property<FrameLayout, Float>) property, fArr));
        FrameLayout frameLayout2 = this.pickerView;
        Property property2 = View.TRANSLATION_Y;
        float[] fArr2 = new float[1];
        fArr2[0] = z ? 0.0f : fDpf2;
        arrayList.add(ObjectAnimator.ofFloat(frameLayout2, (Property<FrameLayout, Float>) property2, fArr2));
        ImageView imageView = this.pickerViewSendButton;
        Property property3 = View.ALPHA;
        float[] fArr3 = new float[1];
        fArr3[0] = z ? 1.0f : 0.0f;
        arrayList.add(ObjectAnimator.ofFloat(imageView, (Property<ImageView, Float>) property3, fArr3));
        ImageView imageView2 = this.pickerViewSendButton;
        Property property4 = View.TRANSLATION_Y;
        float[] fArr4 = new float[1];
        fArr4[0] = z ? 0.0f : fDpf2;
        arrayList.add(ObjectAnimator.ofFloat(imageView2, (Property<ImageView, Float>) property4, fArr4));
        int i = this.sendPhotoType;
        if (i == 0 || i == 4) {
            CheckBox checkBox = this.checkImageView;
            Property property5 = View.ALPHA;
            float[] fArr5 = new float[1];
            fArr5[0] = z ? 1.0f : 0.0f;
            arrayList.add(ObjectAnimator.ofFloat(checkBox, (Property<CheckBox, Float>) property5, fArr5));
            CheckBox checkBox2 = this.checkImageView;
            Property property6 = View.TRANSLATION_Y;
            float[] fArr6 = new float[1];
            fArr6[0] = z ? 0.0f : -fDpf2;
            arrayList.add(ObjectAnimator.ofFloat(checkBox2, (Property<CheckBox, Float>) property6, fArr6));
            CounterView counterView = this.photosCounterView;
            Property property7 = View.ALPHA;
            float[] fArr7 = new float[1];
            fArr7[0] = z ? 1.0f : 0.0f;
            arrayList.add(ObjectAnimator.ofFloat(counterView, (Property<CounterView, Float>) property7, fArr7));
            CounterView counterView2 = this.photosCounterView;
            Property property8 = View.TRANSLATION_Y;
            float[] fArr8 = new float[1];
            fArr8[0] = z ? 0.0f : -fDpf2;
            arrayList.add(ObjectAnimator.ofFloat(counterView2, (Property<CounterView, Float>) property8, fArr8));
        }
        animatorSet.playTogether(arrayList);
        animatorSet.setDuration(200L);
        animatorSet.start();
    }

    private void toggleMiniProgressInternal(final boolean z) {
        if (z) {
            this.miniProgressView.setVisibility(0);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        this.miniProgressAnimator = animatorSet;
        Animator[] animatorArr = new Animator[1];
        RadialProgressView radialProgressView = this.miniProgressView;
        Property property = View.ALPHA;
        float[] fArr = new float[1];
        fArr[0] = z ? 1.0f : 0.0f;
        animatorArr[0] = ObjectAnimator.ofFloat(radialProgressView, (Property<RadialProgressView, Float>) property, fArr);
        animatorSet.playTogether(animatorArr);
        this.miniProgressAnimator.setDuration(200L);
        this.miniProgressAnimator.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.PhotoViewer.53
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (animator.equals(PhotoViewer.this.miniProgressAnimator)) {
                    if (!z) {
                        PhotoViewer.this.miniProgressView.setVisibility(4);
                    }
                    PhotoViewer.this.miniProgressAnimator = null;
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (animator.equals(PhotoViewer.this.miniProgressAnimator)) {
                    PhotoViewer.this.miniProgressAnimator = null;
                }
            }
        });
        this.miniProgressAnimator.start();
    }

    private void toggleMiniProgress(boolean z, boolean z2) {
        AndroidUtilities.cancelRunOnUIThread(this.miniProgressShowRunnable);
        if (z2) {
            toggleMiniProgressInternal(z);
            if (z) {
                AnimatorSet animatorSet = this.miniProgressAnimator;
                if (animatorSet != null) {
                    animatorSet.cancel();
                    this.miniProgressAnimator = null;
                }
                if (this.firstAnimationDelay) {
                    this.firstAnimationDelay = false;
                    toggleMiniProgressInternal(true);
                    return;
                } else {
                    AndroidUtilities.runOnUIThread(this.miniProgressShowRunnable, 500L);
                    return;
                }
            }
            AnimatorSet animatorSet2 = this.miniProgressAnimator;
            if (animatorSet2 != null) {
                animatorSet2.cancel();
                toggleMiniProgressInternal(false);
                return;
            }
            return;
        }
        AnimatorSet animatorSet3 = this.miniProgressAnimator;
        if (animatorSet3 != null) {
            animatorSet3.cancel();
            this.miniProgressAnimator = null;
        }
        this.miniProgressView.setAlpha(z ? 1.0f : 0.0f);
        this.miniProgressView.setVisibility(z ? 0 : 4);
    }

    private void updateContainerFlags(boolean z) {
        FrameLayoutDrawer frameLayoutDrawer;
        if (Build.VERSION.SDK_INT < 21 || this.sendPhotoType == 1 || (frameLayoutDrawer = this.containerView) == null) {
            return;
        }
        int i = 1792;
        if (!z) {
            i = 1796;
            if (frameLayoutDrawer.getPaddingLeft() > 0 || this.containerView.getPaddingRight() > 0) {
                i = 5894;
            }
        }
        this.containerView.setSystemUiVisibility(i);
    }

    private static class ActionBarToggleParams {
        public static final ActionBarToggleParams DEFAULT = new ActionBarToggleParams();
        public Interpolator animationInterpolator;
        public int animationDuration = 200;
        public boolean enableStatusBarAnimation = true;
        public boolean enableTranslationAnimation = true;

        public ActionBarToggleParams enableStatusBarAnimation(boolean z) {
            this.enableStatusBarAnimation = z;
            return this;
        }

        public ActionBarToggleParams enableTranslationAnimation(boolean z) {
            this.enableTranslationAnimation = z;
            return this;
        }

        public ActionBarToggleParams animationDuration(int i) {
            this.animationDuration = i;
            return this;
        }

        public ActionBarToggleParams animationInterpolator(Interpolator interpolator) {
            this.animationInterpolator = interpolator;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toggleActionBar(boolean z, boolean z2) {
        toggleActionBar(z, z2, ActionBarToggleParams.DEFAULT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toggleActionBar(final boolean z, boolean z2, ActionBarToggleParams actionBarToggleParams) {
        CaptionScrollView captionScrollView;
        CaptionScrollView captionScrollView2;
        AnimatorSet animatorSet = this.actionBarAnimator;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        if (z) {
            this.actionBar.setVisibility(0);
            if (this.bottomLayout.getTag() != null) {
                this.bottomLayout.setVisibility(0);
            }
            if (this.captionTextViewSwitcher.getTag() != null) {
                this.captionTextViewSwitcher.setVisibility(0);
                VideoSeekPreviewImage videoSeekPreviewImage = this.videoPreviewFrame;
                if (videoSeekPreviewImage != null) {
                    videoSeekPreviewImage.requestLayout();
                }
            }
        }
        this.isActionBarVisible = z;
        if (actionBarToggleParams.enableStatusBarAnimation) {
            updateContainerFlags(z);
        }
        if (this.videoPlayerControlVisible && this.isPlaying && z) {
            scheduleActionBarHide();
        } else {
            AndroidUtilities.cancelRunOnUIThread(this.hideActionBarRunnable);
        }
        if (!z) {
            Bulletin.hide(this.containerView);
        }
        float fDpf2 = AndroidUtilities.dpf2(24.0f);
        this.videoPlayerControlFrameLayout.setSeekBarTransitionEnabled(actionBarToggleParams.enableTranslationAnimation && this.playerLooping);
        this.videoPlayerControlFrameLayout.setTranslationYAnimationEnabled(actionBarToggleParams.enableTranslationAnimation);
        if (z2) {
            ArrayList arrayList = new ArrayList();
            ActionBar actionBar = this.actionBar;
            Property property = View.ALPHA;
            float[] fArr = new float[1];
            fArr[0] = z ? 1.0f : 0.0f;
            arrayList.add(ObjectAnimator.ofFloat(actionBar, (Property<ActionBar, Float>) property, fArr));
            if (actionBarToggleParams.enableTranslationAnimation) {
                ActionBar actionBar2 = this.actionBar;
                Property property2 = View.TRANSLATION_Y;
                float[] fArr2 = new float[1];
                fArr2[0] = z ? 0.0f : -fDpf2;
                arrayList.add(ObjectAnimator.ofFloat(actionBar2, (Property<ActionBar, Float>) property2, fArr2));
            } else {
                this.actionBar.setTranslationY(0.0f);
            }
            if (this.allowShowFullscreenButton) {
                ImageView imageView = this.fullscreenButton[0];
                Property property3 = View.ALPHA;
                float[] fArr3 = new float[1];
                fArr3[0] = z ? 1.0f : 0.0f;
                arrayList.add(ObjectAnimator.ofFloat(imageView, (Property<ImageView, Float>) property3, fArr3));
            }
            for (int i = 1; i < 3; i++) {
                this.fullscreenButton[i].setTranslationY(z ? 0.0f : fDpf2);
            }
            if (actionBarToggleParams.enableTranslationAnimation) {
                ImageView imageView2 = this.fullscreenButton[0];
                Property property4 = View.TRANSLATION_Y;
                float[] fArr4 = new float[1];
                fArr4[0] = z ? 0.0f : fDpf2;
                arrayList.add(ObjectAnimator.ofFloat(imageView2, (Property<ImageView, Float>) property4, fArr4));
            } else {
                this.fullscreenButton[0].setTranslationY(0.0f);
            }
            FrameLayout frameLayout = this.bottomLayout;
            if (frameLayout != null) {
                Property property5 = View.ALPHA;
                float[] fArr5 = new float[1];
                fArr5[0] = z ? 1.0f : 0.0f;
                arrayList.add(ObjectAnimator.ofFloat(frameLayout, (Property<FrameLayout, Float>) property5, fArr5));
                if (actionBarToggleParams.enableTranslationAnimation) {
                    FrameLayout frameLayout2 = this.bottomLayout;
                    Property property6 = View.TRANSLATION_Y;
                    float[] fArr6 = new float[1];
                    fArr6[0] = z ? 0.0f : fDpf2;
                    arrayList.add(ObjectAnimator.ofFloat(frameLayout2, (Property<FrameLayout, Float>) property6, fArr6));
                } else {
                    this.bottomLayout.setTranslationY(0.0f);
                }
            }
            if (this.videoPlayerControlVisible) {
                VideoPlayerControlFrameLayout videoPlayerControlFrameLayout = this.videoPlayerControlFrameLayout;
                Property<VideoPlayerControlFrameLayout, Float> property7 = VPC_PROGRESS;
                float[] fArr7 = new float[1];
                fArr7[0] = z ? 1.0f : 0.0f;
                arrayList.add(ObjectAnimator.ofFloat(videoPlayerControlFrameLayout, property7, fArr7));
            } else {
                this.videoPlayerControlFrameLayout.setProgress(z ? 1.0f : 0.0f);
            }
            GroupedPhotosListView groupedPhotosListView = this.groupedPhotosListView;
            Property property8 = View.ALPHA;
            float[] fArr8 = new float[1];
            fArr8[0] = z ? 1.0f : 0.0f;
            arrayList.add(ObjectAnimator.ofFloat(groupedPhotosListView, (Property<GroupedPhotosListView, Float>) property8, fArr8));
            if (actionBarToggleParams.enableTranslationAnimation) {
                GroupedPhotosListView groupedPhotosListView2 = this.groupedPhotosListView;
                Property property9 = View.TRANSLATION_Y;
                float[] fArr9 = new float[1];
                fArr9[0] = z ? 0.0f : fDpf2;
                arrayList.add(ObjectAnimator.ofFloat(groupedPhotosListView2, (Property<GroupedPhotosListView, Float>) property9, fArr9));
            } else {
                this.groupedPhotosListView.setTranslationY(0.0f);
            }
            if (!this.needCaptionLayout && (captionScrollView2 = this.captionScrollView) != null) {
                Property property10 = View.ALPHA;
                float[] fArr10 = new float[1];
                fArr10[0] = z ? 1.0f : 0.0f;
                arrayList.add(ObjectAnimator.ofFloat(captionScrollView2, (Property<CaptionScrollView, Float>) property10, fArr10));
                if (actionBarToggleParams.enableTranslationAnimation) {
                    CaptionScrollView captionScrollView3 = this.captionScrollView;
                    Property property11 = View.TRANSLATION_Y;
                    float[] fArr11 = new float[1];
                    if (z) {
                        fDpf2 = 0.0f;
                    }
                    fArr11[0] = fDpf2;
                    arrayList.add(ObjectAnimator.ofFloat(captionScrollView3, (Property<CaptionScrollView, Float>) property11, fArr11));
                } else {
                    this.captionScrollView.setTranslationY(0.0f);
                }
            }
            if (this.videoPlayerControlVisible && this.isPlaying) {
                float[] fArr12 = new float[2];
                fArr12[0] = this.photoProgressViews[0].animAlphas[1];
                fArr12[1] = z ? 1.0f : 0.0f;
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr12);
                valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        this.f$0.lambda$toggleActionBar$56(valueAnimator);
                    }
                });
                arrayList.add(valueAnimatorOfFloat);
            }
            if (this.muteItem.getTag() != null) {
                ImageView imageView3 = this.muteItem;
                Property property12 = View.ALPHA;
                float[] fArr13 = new float[1];
                fArr13[0] = z ? 1.0f : 0.0f;
                arrayList.add(ObjectAnimator.ofFloat(imageView3, (Property<ImageView, Float>) property12, fArr13));
            }
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.actionBarAnimator = animatorSet2;
            animatorSet2.playTogether(arrayList);
            this.actionBarAnimator.setDuration(actionBarToggleParams.animationDuration);
            this.actionBarAnimator.setInterpolator(actionBarToggleParams.animationInterpolator);
            this.actionBarAnimator.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.PhotoViewer.54
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (animator.equals(PhotoViewer.this.actionBarAnimator)) {
                        if (!z) {
                            PhotoViewer.this.actionBar.setVisibility(4);
                            if (PhotoViewer.this.bottomLayout.getTag() != null) {
                                PhotoViewer.this.bottomLayout.setVisibility(4);
                            }
                            if (PhotoViewer.this.captionTextViewSwitcher.getTag() != null) {
                                PhotoViewer.this.captionTextViewSwitcher.setVisibility(4);
                            }
                        }
                        PhotoViewer.this.actionBarAnimator = null;
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    if (animator.equals(PhotoViewer.this.actionBarAnimator)) {
                        PhotoViewer.this.actionBarAnimator = null;
                    }
                }
            });
            this.actionBarAnimator.start();
            return;
        }
        this.actionBar.setAlpha(z ? 1.0f : 0.0f);
        if (this.fullscreenButton[0].getTranslationX() != 0.0f && this.allowShowFullscreenButton) {
            this.fullscreenButton[0].setAlpha(z ? 1.0f : 0.0f);
        }
        for (int i2 = 0; i2 < 3; i2++) {
            this.fullscreenButton[i2].setTranslationY(z ? 0.0f : fDpf2);
        }
        this.actionBar.setTranslationY(z ? 0.0f : -fDpf2);
        this.bottomLayout.setAlpha(z ? 1.0f : 0.0f);
        this.bottomLayout.setTranslationY(z ? 0.0f : fDpf2);
        this.groupedPhotosListView.setAlpha(z ? 1.0f : 0.0f);
        this.groupedPhotosListView.setTranslationY(z ? 0.0f : fDpf2);
        if (!this.needCaptionLayout && (captionScrollView = this.captionScrollView) != null) {
            captionScrollView.setAlpha(z ? 1.0f : 0.0f);
            CaptionScrollView captionScrollView4 = this.captionScrollView;
            if (z) {
                fDpf2 = 0.0f;
            }
            captionScrollView4.setTranslationY(fDpf2);
        }
        this.videoPlayerControlFrameLayout.setProgress(z ? 1.0f : 0.0f);
        if (this.muteItem.getTag() != null) {
            this.muteItem.setAlpha(z ? 1.0f : 0.0f);
        }
        if (this.videoPlayerControlVisible && this.isPlaying) {
            this.photoProgressViews[0].setIndexedAlpha(1, z ? 1.0f : 0.0f, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$toggleActionBar$56(ValueAnimator valueAnimator) {
        this.photoProgressViews[0].setIndexedAlpha(1, ((Float) valueAnimator.getAnimatedValue()).floatValue(), false);
    }

    private void togglePhotosListView(boolean z, boolean z2) {
        if (z == this.isPhotosListViewVisible) {
            return;
        }
        if (z) {
            this.selectedPhotosListView.setVisibility(0);
        }
        this.isPhotosListViewVisible = z;
        this.selectedPhotosListView.setEnabled(z);
        if (z2) {
            ArrayList arrayList = new ArrayList();
            SelectedPhotosListView selectedPhotosListView = this.selectedPhotosListView;
            Property property = View.ALPHA;
            float[] fArr = new float[1];
            fArr[0] = z ? 1.0f : 0.0f;
            arrayList.add(ObjectAnimator.ofFloat(selectedPhotosListView, (Property<SelectedPhotosListView, Float>) property, fArr));
            SelectedPhotosListView selectedPhotosListView2 = this.selectedPhotosListView;
            Property property2 = View.TRANSLATION_Y;
            float[] fArr2 = new float[1];
            fArr2[0] = z ? 0.0f : -AndroidUtilities.dp(10.0f);
            arrayList.add(ObjectAnimator.ofFloat(selectedPhotosListView2, (Property<SelectedPhotosListView, Float>) property2, fArr2));
            CounterView counterView = this.photosCounterView;
            Property property3 = View.ROTATION_X;
            float[] fArr3 = new float[1];
            fArr3[0] = z ? 1.0f : 0.0f;
            arrayList.add(ObjectAnimator.ofFloat(counterView, (Property<CounterView, Float>) property3, fArr3));
            AnimatorSet animatorSet = new AnimatorSet();
            this.currentListViewAnimation = animatorSet;
            animatorSet.playTogether(arrayList);
            if (!z) {
                this.currentListViewAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.PhotoViewer.55
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (PhotoViewer.this.currentListViewAnimation == null || !PhotoViewer.this.currentListViewAnimation.equals(animator)) {
                            return;
                        }
                        PhotoViewer.this.selectedPhotosListView.setVisibility(8);
                        PhotoViewer.this.currentListViewAnimation = null;
                    }
                });
            }
            this.currentListViewAnimation.setDuration(200L);
            this.currentListViewAnimation.start();
            return;
        }
        this.selectedPhotosListView.setAlpha(z ? 1.0f : 0.0f);
        this.selectedPhotosListView.setTranslationY(z ? 0.0f : -AndroidUtilities.dp(10.0f));
        this.photosCounterView.setRotationX(z ? 1.0f : 0.0f);
        if (z) {
            return;
        }
        this.selectedPhotosListView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toggleVideoPlayer() {
        if (this.videoPlayer == null) {
            return;
        }
        cancelVideoPlayRunnable();
        AndroidUtilities.cancelRunOnUIThread(this.hideActionBarRunnable);
        if (this.isPlaying) {
            this.videoPlayer.pause();
        } else {
            if (!this.isCurrentVideo) {
                if (Math.abs(this.videoPlayerSeekbar.getProgress() - this.videoTimelineView.getRightProgress()) < 0.01f || this.videoPlayer.getCurrentPosition() == this.videoPlayer.getDuration()) {
                    this.videoPlayer.seekTo(0L);
                }
                scheduleActionBarHide();
            } else if (Math.abs(this.videoTimelineView.getProgress() - this.videoTimelineView.getRightProgress()) < 0.01f || this.videoPlayer.getCurrentPosition() == this.videoPlayer.getDuration()) {
                this.videoPlayer.seekTo((int) (this.videoTimelineView.getLeftProgress() * this.videoPlayer.getDuration()));
            }
            this.videoPlayer.play();
        }
        this.containerView.invalidate();
    }

    private String getFileName(int i) {
        if (i < 0) {
            return null;
        }
        if (!this.secureDocuments.isEmpty()) {
            if (i >= this.secureDocuments.size()) {
                return null;
            }
            SecureDocument secureDocument = this.secureDocuments.get(i);
            return secureDocument.secureFile.dc_id + "_" + secureDocument.secureFile.id + ".jpg";
        }
        if (!this.imagesArrLocations.isEmpty() || !this.imagesArr.isEmpty()) {
            if (!this.imagesArrLocations.isEmpty()) {
                if (i >= this.imagesArrLocations.size()) {
                    return null;
                }
                ImageLocation imageLocation = this.imagesArrLocations.get(i);
                ImageLocation imageLocation2 = this.imagesArrLocationsVideo.get(i);
                if (imageLocation == null) {
                    return null;
                }
                if (imageLocation2 != imageLocation) {
                    return imageLocation2.location.volume_id + "_" + imageLocation2.location.local_id + ".mp4";
                }
                return imageLocation.location.volume_id + "_" + imageLocation.location.local_id + ".jpg";
            }
            if (i >= this.imagesArr.size()) {
                return null;
            }
            return FileLoader.getMessageFileName(this.imagesArr.get(i).messageOwner);
        }
        if (!this.imagesArrLocals.isEmpty()) {
            if (i >= this.imagesArrLocals.size()) {
                return null;
            }
            Object obj = this.imagesArrLocals.get(i);
            if (obj instanceof MediaController.SearchImage) {
                return ((MediaController.SearchImage) obj).getAttachName();
            }
            if (obj instanceof TLRPC$BotInlineResult) {
                TLRPC$BotInlineResult tLRPC$BotInlineResult = (TLRPC$BotInlineResult) obj;
                TLRPC$Document tLRPC$Document = tLRPC$BotInlineResult.document;
                if (tLRPC$Document != null) {
                    return FileLoader.getAttachFileName(tLRPC$Document);
                }
                TLRPC$Photo tLRPC$Photo = tLRPC$BotInlineResult.photo;
                if (tLRPC$Photo != null) {
                    return FileLoader.getAttachFileName(FileLoader.getClosestPhotoSizeWithSize(tLRPC$Photo.sizes, AndroidUtilities.getPhotoSize()));
                }
                if (tLRPC$BotInlineResult.content instanceof TLRPC$TL_webDocument) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(Utilities.MD5(tLRPC$BotInlineResult.content.url));
                    sb.append(".");
                    TLRPC$WebDocument tLRPC$WebDocument = tLRPC$BotInlineResult.content;
                    sb.append(ImageLoader.getHttpUrlExtension(tLRPC$WebDocument.url, FileLoader.getMimeTypePart(tLRPC$WebDocument.mime_type)));
                    return sb.toString();
                }
            }
        } else {
            PageBlocksAdapter pageBlocksAdapter = this.pageBlocksAdapter;
            if (pageBlocksAdapter != null) {
                return pageBlocksAdapter.getFileName(i);
            }
        }
        return null;
    }

    private ImageLocation getImageLocation(int i, int[] iArr) {
        if (i < 0) {
            return null;
        }
        if (!this.secureDocuments.isEmpty()) {
            if (i >= this.secureDocuments.size()) {
                return null;
            }
            if (iArr != null) {
                iArr[0] = this.secureDocuments.get(i).secureFile.size;
            }
            return ImageLocation.getForSecureDocument(this.secureDocuments.get(i));
        }
        if (!this.imagesArrLocations.isEmpty()) {
            if (i >= this.imagesArrLocations.size()) {
                return null;
            }
            if (iArr != null) {
                iArr[0] = this.imagesArrLocationsSizes.get(i).intValue();
            }
            return this.imagesArrLocationsVideo.get(i);
        }
        if (this.imagesArr.isEmpty() || i >= this.imagesArr.size()) {
            return null;
        }
        MessageObject messageObject = this.imagesArr.get(i);
        TLRPC$Message tLRPC$Message = messageObject.messageOwner;
        if (tLRPC$Message instanceof TLRPC$TL_messageService) {
            if (tLRPC$Message.action instanceof TLRPC$TL_messageActionUserUpdatedPhoto) {
                return null;
            }
            TLRPC$PhotoSize closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(messageObject.photoThumbs, AndroidUtilities.getPhotoSize());
            if (closestPhotoSizeWithSize != null) {
                if (iArr != null) {
                    iArr[0] = closestPhotoSizeWithSize.size;
                    if (iArr[0] == 0) {
                        iArr[0] = -1;
                    }
                }
                return ImageLocation.getForObject(closestPhotoSizeWithSize, messageObject.photoThumbsObject);
            }
            if (iArr != null) {
                iArr[0] = -1;
            }
        } else {
            TLRPC$MessageMedia tLRPC$MessageMedia = tLRPC$Message.media;
            if (((tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaPhoto) && tLRPC$MessageMedia.photo != null) || ((tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaWebPage) && tLRPC$MessageMedia.webpage != null)) {
                if (messageObject.isGif()) {
                    return ImageLocation.getForDocument(messageObject.getDocument());
                }
                TLRPC$PhotoSize closestPhotoSizeWithSize2 = FileLoader.getClosestPhotoSizeWithSize(messageObject.photoThumbs, AndroidUtilities.getPhotoSize(), false, null, true);
                if (closestPhotoSizeWithSize2 != null) {
                    if (iArr != null) {
                        iArr[0] = closestPhotoSizeWithSize2.size;
                        if (iArr[0] == 0) {
                            iArr[0] = -1;
                        }
                    }
                    return ImageLocation.getForObject(closestPhotoSizeWithSize2, messageObject.photoThumbsObject);
                }
                if (iArr != null) {
                    iArr[0] = -1;
                }
            } else {
                if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaInvoice) {
                    return ImageLocation.getForWebFile(WebFile.createWithWebDocument(((TLRPC$TL_messageMediaInvoice) tLRPC$MessageMedia).webPhoto));
                }
                if (messageObject.getDocument() != null) {
                    TLRPC$Document document = messageObject.getDocument();
                    if (this.sharedMediaType == 5) {
                        return ImageLocation.getForDocument(document);
                    }
                    if (MessageObject.isDocumentHasThumb(messageObject.getDocument())) {
                        TLRPC$PhotoSize closestPhotoSizeWithSize3 = FileLoader.getClosestPhotoSizeWithSize(document.thumbs, 90);
                        if (iArr != null) {
                            iArr[0] = closestPhotoSizeWithSize3.size;
                            if (iArr[0] == 0) {
                                iArr[0] = -1;
                            }
                        }
                        return ImageLocation.getForDocument(closestPhotoSizeWithSize3, document);
                    }
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TLObject getFileLocation(int i, int[] iArr) {
        if (i < 0) {
            return null;
        }
        if (!this.secureDocuments.isEmpty()) {
            if (i >= this.secureDocuments.size()) {
                return null;
            }
            if (iArr != null) {
                iArr[0] = this.secureDocuments.get(i).secureFile.size;
            }
            return this.secureDocuments.get(i);
        }
        if (!this.imagesArrLocations.isEmpty()) {
            if (i >= this.imagesArrLocations.size()) {
                return null;
            }
            if (iArr != null) {
                iArr[0] = this.imagesArrLocationsSizes.get(i).intValue();
            }
            return this.imagesArrLocationsVideo.get(i).location;
        }
        if (this.imagesArr.isEmpty() || i >= this.imagesArr.size()) {
            return null;
        }
        MessageObject messageObject = this.imagesArr.get(i);
        TLRPC$Message tLRPC$Message = messageObject.messageOwner;
        if (tLRPC$Message instanceof TLRPC$TL_messageService) {
            TLRPC$MessageAction tLRPC$MessageAction = tLRPC$Message.action;
            if (tLRPC$MessageAction instanceof TLRPC$TL_messageActionUserUpdatedPhoto) {
                return tLRPC$MessageAction.newUserPhoto.photo_big;
            }
            TLRPC$PhotoSize closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(messageObject.photoThumbs, AndroidUtilities.getPhotoSize());
            if (closestPhotoSizeWithSize != null) {
                if (iArr != null) {
                    iArr[0] = closestPhotoSizeWithSize.size;
                    if (iArr[0] == 0) {
                        iArr[0] = -1;
                    }
                }
                return closestPhotoSizeWithSize;
            }
            if (iArr != null) {
                iArr[0] = -1;
            }
        } else {
            TLRPC$MessageMedia tLRPC$MessageMedia = tLRPC$Message.media;
            if (((tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaPhoto) && tLRPC$MessageMedia.photo != null) || ((tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaWebPage) && tLRPC$MessageMedia.webpage != null)) {
                TLRPC$PhotoSize closestPhotoSizeWithSize2 = FileLoader.getClosestPhotoSizeWithSize(messageObject.photoThumbs, AndroidUtilities.getPhotoSize(), false, null, true);
                if (closestPhotoSizeWithSize2 != null) {
                    if (iArr != null) {
                        iArr[0] = closestPhotoSizeWithSize2.size;
                        if (iArr[0] == 0) {
                            iArr[0] = -1;
                        }
                    }
                    return closestPhotoSizeWithSize2;
                }
                if (iArr != null) {
                    iArr[0] = -1;
                }
            } else {
                if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaInvoice) {
                    return ((TLRPC$TL_messageMediaInvoice) tLRPC$MessageMedia).webPhoto;
                }
                if (messageObject.getDocument() != null && MessageObject.isDocumentHasThumb(messageObject.getDocument())) {
                    TLRPC$PhotoSize closestPhotoSizeWithSize3 = FileLoader.getClosestPhotoSizeWithSize(messageObject.getDocument().thumbs, 90);
                    if (iArr != null) {
                        iArr[0] = closestPhotoSizeWithSize3.size;
                        if (iArr[0] == 0) {
                            iArr[0] = -1;
                        }
                    }
                    return closestPhotoSizeWithSize3;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSelectedCount() {
        PhotoViewerProvider photoViewerProvider = this.placeProvider;
        if (photoViewerProvider == null) {
            return;
        }
        int selectedCount = photoViewerProvider.getSelectedCount();
        this.photosCounterView.setCount(selectedCount);
        if (selectedCount == 0) {
            togglePhotosListView(false, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isCurrentAvatarSet() {
        int i;
        if (this.currentAvatarLocation != null && (i = this.currentIndex) >= 0 && i < this.avatarsArr.size()) {
            TLRPC$Photo tLRPC$Photo = this.avatarsArr.get(this.currentIndex);
            ImageLocation imageLocation = this.imagesArrLocations.get(this.currentIndex);
            if (tLRPC$Photo instanceof TLRPC$TL_photoEmpty) {
                tLRPC$Photo = null;
            }
            if (tLRPC$Photo != null) {
                int size = tLRPC$Photo.sizes.size();
                for (int i2 = 0; i2 < size; i2++) {
                    TLRPC$FileLocation tLRPC$FileLocation = tLRPC$Photo.sizes.get(i2).location;
                    if (tLRPC$FileLocation != null) {
                        int i3 = tLRPC$FileLocation.local_id;
                        TLRPC$TL_fileLocationToBeDeprecated tLRPC$TL_fileLocationToBeDeprecated = this.currentAvatarLocation.location;
                        if (i3 == tLRPC$TL_fileLocationToBeDeprecated.local_id && tLRPC$FileLocation.volume_id == tLRPC$TL_fileLocationToBeDeprecated.volume_id) {
                            return true;
                        }
                    }
                }
            } else {
                TLRPC$TL_fileLocationToBeDeprecated tLRPC$TL_fileLocationToBeDeprecated2 = imageLocation.location;
                int i4 = tLRPC$TL_fileLocationToBeDeprecated2.local_id;
                TLRPC$TL_fileLocationToBeDeprecated tLRPC$TL_fileLocationToBeDeprecated3 = this.currentAvatarLocation.location;
                if (i4 == tLRPC$TL_fileLocationToBeDeprecated3.local_id && tLRPC$TL_fileLocationToBeDeprecated2.volume_id == tLRPC$TL_fileLocationToBeDeprecated3.volume_id) {
                    return true;
                }
            }
        }
        return false;
    }

    private void setItemVisible(View view, boolean z, boolean z2) {
        setItemVisible(view, z, z2, 1.0f);
    }

    private void setItemVisible(final View view, final boolean z, boolean z2, float f) {
        Boolean bool = this.actionBarItemsVisibility.get(view);
        if (bool == null || bool.booleanValue() != z) {
            this.actionBarItemsVisibility.put(view, Boolean.valueOf(z));
            view.animate().cancel();
            float f2 = (z ? 1.0f : 0.0f) * f;
            if (z2 && bool != null) {
                if (z) {
                    view.setVisibility(0);
                }
                view.animate().alpha(f2).setDuration(100L).setInterpolator(new LinearInterpolator()).withEndAction(new Runnable() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda59
                    @Override // java.lang.Runnable
                    public final void run() {
                        PhotoViewer.lambda$setItemVisible$57(z, view);
                    }
                }).start();
            } else {
                view.setVisibility(z ? 0 : 8);
                view.setAlpha(f2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setItemVisible$57(boolean z, View view) {
        if (z) {
            return;
        }
        view.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0747  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x07a6  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x07aa  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x07cc  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x07dd  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x0813  */
    /* JADX WARN: Type inference failed for: r13v19 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5, types: [android.animation.AnimatorSet, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onPhotoShow(org.rbmain.messenger.MessageObject r19, org.rbmain.tgnet.TLRPC$FileLocation r20, org.rbmain.messenger.ImageLocation r21, org.rbmain.messenger.ImageLocation r22, java.util.ArrayList<org.rbmain.messenger.MessageObject> r23, java.util.ArrayList<org.rbmain.messenger.SecureDocument> r24, java.util.List<java.lang.Object> r25, int r26, org.rbmain.ui.PhotoViewer.PlaceProviderObject r27) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException, android.content.res.Resources.NotFoundException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException {
        /*
            Method dump skipped, instructions count: 2165
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.PhotoViewer.onPhotoShow(org.rbmain.messenger.MessageObject, org.rbmain.tgnet.TLRPC$FileLocation, org.rbmain.messenger.ImageLocation, org.rbmain.messenger.ImageLocation, java.util.ArrayList, java.util.ArrayList, java.util.List, int, org.rbmain.ui.PhotoViewer$PlaceProviderObject):void");
    }

    private boolean canSendMediaToParentChatActivity() {
        TLRPC$Chat tLRPC$Chat;
        ChatActivity chatActivity = this.parentChatActivity;
        return chatActivity != null && (chatActivity.currentUser != null || ((tLRPC$Chat = chatActivity.currentChat) != null && ChatObject.canSendMedia(tLRPC$Chat)));
    }

    private void setDoubleTapEnabled(boolean z) {
        this.doubleTapEnabled = z;
        this.gestureDetector.setOnDoubleTapListener(z ? this : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImages() throws Resources.NotFoundException {
        if (this.animationInProgress == 0) {
            setIndexToImage(this.centerImage, this.currentIndex);
            setIndexToImage(this.rightImage, this.currentIndex + 1);
            setIndexToImage(this.leftImage, this.currentIndex - 1);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:151:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x0737  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x0860  */
    /* JADX WARN: Removed duplicated region for block: B:369:0x0925  */
    /* JADX WARN: Removed duplicated region for block: B:378:0x094a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void setIsAboutToSwitchToIndex(int r31, boolean r32, boolean r33) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException, android.content.res.Resources.NotFoundException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException {
        /*
            Method dump skipped, instructions count: 2951
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.PhotoViewer.setIsAboutToSwitchToIndex(int, boolean, boolean):void");
    }

    public static TLRPC$FileLocation getFileLocation(ImageLocation imageLocation) {
        if (imageLocation == null) {
            return null;
        }
        return imageLocation.location;
    }

    public static String getFileLocationExt(ImageLocation imageLocation) {
        if (imageLocation == null || imageLocation.imageType != 2) {
            return null;
        }
        return "mp4";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImageIndex(int i) throws IllegalAccessException, NoSuchFieldException, Resources.NotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException {
        setImageIndex(i, true, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x0120  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void setImageIndex(int r45, boolean r46, boolean r47) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException, android.content.res.Resources.NotFoundException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException {
        /*
            Method dump skipped, instructions count: 1238
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.PhotoViewer.setImageIndex(int, boolean, boolean):void");
    }

    private void setCurrentCaption(MessageObject messageObject, CharSequence charSequence, boolean z) throws IllegalAccessException, NoSuchFieldException, Resources.NotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException {
        int i;
        boolean z2;
        CharSequence charSequenceReplaceEmoji;
        int i2;
        boolean z3 = true;
        if (this.needCaptionLayout) {
            if (this.captionTextViewSwitcher.getParent() != this.pickerView) {
                FrameLayout frameLayout = this.captionContainer;
                if (frameLayout != null) {
                    frameLayout.removeView(this.captionTextViewSwitcher);
                }
                this.captionTextViewSwitcher.setMeasureAllChildren(false);
                this.pickerView.addView(this.captionTextViewSwitcher, LayoutHelper.createFrame(-1, -2.0f, 83, 0.0f, 0.0f, 76.0f, 48.0f));
            }
        } else {
            if (this.captionScrollView == null) {
                this.captionScrollView = new CaptionScrollView(this.containerView.getContext());
                FrameLayout frameLayout2 = new FrameLayout(this.containerView.getContext());
                this.captionContainer = frameLayout2;
                frameLayout2.setClipChildren(false);
                this.captionScrollView.addView(this.captionContainer, new ViewGroup.LayoutParams(-1, -2));
                this.containerView.addView(this.captionScrollView, LayoutHelper.createFrame(-1, -1, 80));
            }
            if (this.captionTextViewSwitcher.getParent() != this.captionContainer) {
                this.pickerView.removeView(this.captionTextViewSwitcher);
                this.captionTextViewSwitcher.setMeasureAllChildren(true);
                this.captionContainer.addView(this.captionTextViewSwitcher, -1, -2);
                this.videoPreviewFrame.bringToFront();
            }
        }
        boolean zIsEmpty = TextUtils.isEmpty(charSequence);
        boolean zIsEmpty2 = TextUtils.isEmpty(this.captionTextViewSwitcher.getCurrentView().getText());
        CaptionTextViewSwitcher captionTextViewSwitcher = this.captionTextViewSwitcher;
        TextView nextView = z ? captionTextViewSwitcher.getNextView() : captionTextViewSwitcher.getCurrentView();
        if (this.isCurrentVideo) {
            if (nextView.getMaxLines() != 1) {
                this.captionTextViewSwitcher.getCurrentView().setMaxLines(1);
                this.captionTextViewSwitcher.getNextView().setMaxLines(1);
                this.captionTextViewSwitcher.getCurrentView().setSingleLine(true);
                this.captionTextViewSwitcher.getNextView().setSingleLine(true);
                this.captionTextViewSwitcher.getCurrentView().setEllipsize(TextUtils.TruncateAt.END);
                this.captionTextViewSwitcher.getNextView().setEllipsize(TextUtils.TruncateAt.END);
            }
        } else {
            int maxLines = nextView.getMaxLines();
            if (maxLines == 1) {
                this.captionTextViewSwitcher.getCurrentView().setSingleLine(false);
                this.captionTextViewSwitcher.getNextView().setSingleLine(false);
            }
            if (this.needCaptionLayout) {
                Point point = AndroidUtilities.displaySize;
                i = point.x > point.y ? 5 : 10;
            } else {
                i = ConnectionsManager.DEFAULT_DATACENTER_ID;
            }
            if (maxLines != i) {
                this.captionTextViewSwitcher.getCurrentView().setMaxLines(i);
                this.captionTextViewSwitcher.getNextView().setMaxLines(i);
                this.captionTextViewSwitcher.getCurrentView().setEllipsize(null);
                this.captionTextViewSwitcher.getNextView().setEllipsize(null);
            }
        }
        nextView.setScrollX(0);
        boolean z4 = this.needCaptionLayout;
        this.dontChangeCaptionPosition = !z4 && z && zIsEmpty;
        if (!z4) {
            this.captionScrollView.dontChangeTopMargin = false;
        }
        if (z && (i2 = Build.VERSION.SDK_INT) >= 19) {
            if (i2 >= 23) {
                TransitionManager.endTransitions(this.needCaptionLayout ? this.pickerView : this.captionScrollView);
            }
            if (this.needCaptionLayout) {
                TransitionSet transitionSet = new TransitionSet();
                transitionSet.setOrdering(0);
                transitionSet.addTransition(new ChangeBounds());
                transitionSet.addTransition(new Fade(2));
                transitionSet.addTransition(new Fade(1));
                transitionSet.setDuration(200L);
                TransitionManager.beginDelayedTransition(this.pickerView, transitionSet);
            } else {
                TransitionSet duration = new TransitionSet().addTransition(new AnonymousClass57(2, zIsEmpty2, zIsEmpty)).addTransition(new AnonymousClass56(1, zIsEmpty2, zIsEmpty)).setDuration(200L);
                if (!zIsEmpty2) {
                    this.captionScrollView.dontChangeTopMargin = true;
                    duration.addTransition(new AnonymousClass58());
                }
                if (zIsEmpty2 && !zIsEmpty) {
                    duration.addTarget((View) this.captionTextViewSwitcher);
                }
                TransitionManager.beginDelayedTransition(this.captionScrollView, duration);
            }
            z2 = true;
        } else {
            this.captionTextViewSwitcher.getCurrentView().setText((CharSequence) null);
            CaptionScrollView captionScrollView = this.captionScrollView;
            if (captionScrollView != null) {
                captionScrollView.scrollTo(0, 0);
            }
            z2 = false;
        }
        if (!zIsEmpty) {
            Theme.createChatResources(null, true);
            if (messageObject != null && !messageObject.messageOwner.entities.isEmpty()) {
                SpannableString spannableStringValueOf = SpannableString.valueOf(charSequence.toString());
                messageObject.addEntitiesToText(spannableStringValueOf, true, false);
                if (messageObject.isVideo()) {
                    MessageObject.addUrlsByPattern(messageObject.isOutOwner(), spannableStringValueOf, false, 3, messageObject.getDuration(), false);
                }
                charSequenceReplaceEmoji = Emoji.replaceEmoji(spannableStringValueOf, nextView.getPaint().getFontMetricsInt(), AndroidUtilities.dp(20.0f), false);
            } else {
                charSequenceReplaceEmoji = Emoji.replaceEmoji(new SpannableStringBuilder(charSequence), nextView.getPaint().getFontMetricsInt(), AndroidUtilities.dp(20.0f), false);
            }
            this.captionTextViewSwitcher.setTag(charSequenceReplaceEmoji);
            try {
                this.captionTextViewSwitcher.setText(charSequenceReplaceEmoji, z);
                CaptionScrollView captionScrollView2 = this.captionScrollView;
                if (captionScrollView2 != null) {
                    captionScrollView2.updateTopMargin();
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
            nextView.setScrollY(0);
            nextView.setTextColor(-1);
            if (!this.isActionBarVisible || (this.bottomLayout.getVisibility() != 0 && this.pickerView.getVisibility() != 0 && this.pageBlocksAdapter == null)) {
                z3 = false;
            }
            this.captionTextViewSwitcher.setVisibility(z3 ? 0 : 4);
            return;
        }
        if (this.needCaptionLayout) {
            this.captionTextViewSwitcher.setText(LocaleController.getString("AddCaption", R.string.AddCaption), z);
            this.captionTextViewSwitcher.getCurrentView().setTextColor(-1291845633);
            this.captionTextViewSwitcher.setTag("empty");
            this.captionTextViewSwitcher.setVisibility(0);
        } else {
            this.captionTextViewSwitcher.setText(null, z);
            this.captionTextViewSwitcher.getCurrentView().setTextColor(-1);
            CaptionTextViewSwitcher captionTextViewSwitcher2 = this.captionTextViewSwitcher;
            if (z2 && !zIsEmpty2) {
                z3 = false;
            }
            captionTextViewSwitcher2.setVisibility(4, z3);
            this.captionTextViewSwitcher.setTag(null);
        }
        this.captionTextViewSwitcher.getCurrentView().setGravity(3);
        this.captionTextViewSwitcher.getNextView().setGravity(3);
    }

    /* renamed from: org.rbmain.ui.PhotoViewer$57, reason: invalid class name */
    class AnonymousClass57 extends Fade {
        final /* synthetic */ boolean val$isCaptionEmpty;
        final /* synthetic */ boolean val$isCurrentCaptionEmpty;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass57(int i, boolean z, boolean z2) {
            super(i);
            this.val$isCurrentCaptionEmpty = z;
            this.val$isCaptionEmpty = z2;
        }

        @Override // android.transition.Fade, android.transition.Visibility
        public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
            Animator animatorOnDisappear = super.onDisappear(viewGroup, view, transitionValues, transitionValues2);
            if (!this.val$isCurrentCaptionEmpty && this.val$isCaptionEmpty && view == PhotoViewer.this.captionTextViewSwitcher) {
                animatorOnDisappear.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.PhotoViewer.57.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        PhotoViewer.this.captionScrollView.setVisibility(4);
                        PhotoViewer.this.captionScrollView.backgroundAlpha = 1.0f;
                    }
                });
                ((ObjectAnimator) animatorOnDisappear).addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.PhotoViewer$57$$ExternalSyntheticLambda0
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        this.f$0.lambda$onDisappear$0(valueAnimator);
                    }
                });
            }
            return animatorOnDisappear;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onDisappear$0(ValueAnimator valueAnimator) {
            PhotoViewer.this.captionScrollView.backgroundAlpha = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            PhotoViewer.this.captionScrollView.invalidate();
        }
    }

    /* renamed from: org.rbmain.ui.PhotoViewer$56, reason: invalid class name */
    class AnonymousClass56 extends Fade {
        final /* synthetic */ boolean val$isCaptionEmpty;
        final /* synthetic */ boolean val$isCurrentCaptionEmpty;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass56(int i, boolean z, boolean z2) {
            super(i);
            this.val$isCurrentCaptionEmpty = z;
            this.val$isCaptionEmpty = z2;
        }

        @Override // android.transition.Fade, android.transition.Visibility
        public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
            Animator animatorOnAppear = super.onAppear(viewGroup, view, transitionValues, transitionValues2);
            if (this.val$isCurrentCaptionEmpty && !this.val$isCaptionEmpty && view == PhotoViewer.this.captionTextViewSwitcher) {
                animatorOnAppear.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.PhotoViewer.56.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        PhotoViewer.this.captionScrollView.backgroundAlpha = 1.0f;
                    }
                });
                ((ObjectAnimator) animatorOnAppear).addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.PhotoViewer$56$$ExternalSyntheticLambda0
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        this.f$0.lambda$onAppear$0(valueAnimator);
                    }
                });
            }
            return animatorOnAppear;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onAppear$0(ValueAnimator valueAnimator) {
            PhotoViewer.this.captionScrollView.backgroundAlpha = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            PhotoViewer.this.captionScrollView.invalidate();
        }
    }

    /* renamed from: org.rbmain.ui.PhotoViewer$58, reason: invalid class name */
    class AnonymousClass58 extends Transition {
        AnonymousClass58() {
        }

        @Override // android.transition.Transition
        public void captureStartValues(TransitionValues transitionValues) {
            if (transitionValues.view == PhotoViewer.this.captionScrollView) {
                transitionValues.values.put("scrollY", Integer.valueOf(PhotoViewer.this.captionScrollView.getScrollY()));
            }
        }

        @Override // android.transition.Transition
        public void captureEndValues(TransitionValues transitionValues) {
            if (transitionValues.view == PhotoViewer.this.captionTextViewSwitcher) {
                transitionValues.values.put("translationY", Integer.valueOf(PhotoViewer.this.captionScrollView.getPendingMarginTopDiff()));
            }
        }

        @Override // android.transition.Transition
        public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
            int iIntValue;
            if (transitionValues.view != PhotoViewer.this.captionScrollView) {
                if (transitionValues2.view != PhotoViewer.this.captionTextViewSwitcher || (iIntValue = ((Integer) transitionValues2.values.get("translationY")).intValue()) == 0) {
                    return null;
                }
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(PhotoViewer.this.captionTextViewSwitcher, (Property<CaptionTextViewSwitcher, Float>) View.TRANSLATION_Y, 0.0f, iIntValue);
                objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.PhotoViewer.58.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        PhotoViewer.this.captionTextViewSwitcher.setTranslationY(0.0f);
                    }
                });
                return objectAnimatorOfFloat;
            }
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(((Integer) transitionValues.values.get("scrollY")).intValue(), 0);
            valueAnimatorOfInt.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.PhotoViewer.58.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    PhotoViewer.this.captionTextViewSwitcher.getNextView().setText((CharSequence) null);
                    PhotoViewer.this.captionScrollView.applyPendingTopMargin();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                    PhotoViewer.this.captionScrollView.stopScrolling();
                }
            });
            valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.PhotoViewer$58$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f$0.lambda$createAnimator$0(valueAnimator);
                }
            });
            return valueAnimatorOfInt;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$createAnimator$0(ValueAnimator valueAnimator) {
            PhotoViewer.this.captionScrollView.scrollTo(0, ((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCaptionHwLayerEnabled(boolean z) {
        if (this.captionHwLayerEnabled != z) {
            this.captionHwLayerEnabled = z;
            this.captionTextViewSwitcher.setLayerType(2, null);
            this.captionTextViewSwitcher.getCurrentView().setLayerType(2, null);
            this.captionTextViewSwitcher.getNextView().setLayerType(2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v23, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v4 */
    public void checkProgress(final int i, boolean z, final boolean z2) {
        final File file;
        MessageObject messageObject;
        boolean zShouldIndexAutoPlayed;
        boolean z3;
        final ?? r3;
        final MessageObject messageObject2;
        boolean z4;
        File file2;
        File file3;
        File pathToAttach;
        boolean z5;
        File pathToMessage;
        TLRPC$WebPage tLRPC$WebPage;
        int i2 = this.currentIndex;
        if (i == 1) {
            i2++;
        } else if (i == 2) {
            i2--;
        }
        boolean z6 = false;
        if (this.currentFileNames[i] != null) {
            if (this.currentMessageObject != null) {
                if (i2 < 0 || i2 >= this.imagesArr.size()) {
                    this.photoProgressViews[i].setBackgroundState(-1, z2, true);
                    return;
                }
                MessageObject messageObject3 = this.imagesArr.get(i2);
                boolean zShouldMessageObjectAutoPlayed = shouldMessageObjectAutoPlayed(messageObject3);
                if (this.sharedMediaType == 1 && !messageObject3.canPreviewDocument()) {
                    this.photoProgressViews[i].setBackgroundState(-1, z2, true);
                    return;
                }
                File file4 = !TextUtils.isEmpty(messageObject3.messageOwner.attachPath) ? new File(messageObject3.messageOwner.attachPath) : null;
                TLRPC$Message tLRPC$Message = messageObject3.messageOwner;
                TLRPC$MessageMedia tLRPC$MessageMedia = tLRPC$Message.media;
                if ((tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaWebPage) && (tLRPC$WebPage = tLRPC$MessageMedia.webpage) != null && tLRPC$WebPage.document == null) {
                    pathToMessage = FileLoader.getPathToAttach(getFileLocation(i2, null), true);
                } else {
                    pathToMessage = FileLoader.getPathToMessage(tLRPC$Message);
                }
                if (messageObject3.isVideo() || messageObject3.isVideoFile()) {
                    z4 = SharedConfig.streamMedia && messageObject3.canStreamVideo() && ((int) messageObject3.getDialogId()) != 0;
                    z3 = true;
                } else {
                    z4 = false;
                    z3 = false;
                }
                r3 = pathToMessage;
                zShouldIndexAutoPlayed = zShouldMessageObjectAutoPlayed;
                File file5 = file4;
                messageObject2 = messageObject3;
                file = file5;
            } else {
                if (this.currentBotInlineResult != null) {
                    if (i2 < 0 || i2 >= this.imagesArrLocals.size()) {
                        this.photoProgressViews[i].setBackgroundState(-1, z2, true);
                        return;
                    }
                    TLRPC$BotInlineResult tLRPC$BotInlineResult = (TLRPC$BotInlineResult) this.imagesArrLocals.get(i2);
                    if (tLRPC$BotInlineResult.type.equals(MediaStreamTrack.VIDEO_TRACK_KIND) || MessageObject.isVideoDocument(tLRPC$BotInlineResult.document)) {
                        TLRPC$Document tLRPC$Document = tLRPC$BotInlineResult.document;
                        if (tLRPC$Document != null) {
                            file2 = FileLoader.getPathToAttach(tLRPC$Document);
                        } else if (tLRPC$BotInlineResult.content instanceof TLRPC$TL_webDocument) {
                            file2 = new File(FileLoader.getDirectory(4), Utilities.MD5(tLRPC$BotInlineResult.content.url) + "." + ImageLoader.getHttpUrlExtension(tLRPC$BotInlineResult.content.url, "mp4"));
                        } else {
                            file2 = null;
                        }
                        z5 = true;
                    } else {
                        if (tLRPC$BotInlineResult.document != null) {
                            file2 = new File(FileLoader.getDirectory(3), this.currentFileNames[i]);
                        } else {
                            file2 = tLRPC$BotInlineResult.photo != null ? new File(FileLoader.getDirectory(0), this.currentFileNames[i]) : null;
                        }
                        z5 = false;
                    }
                    z3 = z5;
                    messageObject2 = null;
                    z4 = false;
                    file3 = new File(FileLoader.getDirectory(4), this.currentFileNames[i]);
                } else {
                    if (this.currentFileLocation != null) {
                        if (i2 < 0 || i2 >= this.imagesArrLocationsVideo.size()) {
                            this.photoProgressViews[i].setBackgroundState(-1, z2, true);
                            return;
                        } else {
                            ImageLocation imageLocation = this.imagesArrLocationsVideo.get(i2);
                            pathToAttach = FileLoader.getPathToAttach(imageLocation.location, getFileLocationExt(imageLocation), this.avatarsDialogId != 0 || this.isEvent);
                        }
                    } else if (this.currentSecureDocument != null) {
                        if (i2 < 0 || i2 >= this.secureDocuments.size()) {
                            this.photoProgressViews[i].setBackgroundState(-1, z2, true);
                            return;
                        }
                        pathToAttach = FileLoader.getPathToAttach(this.secureDocuments.get(i2), true);
                    } else if (this.currentPathObject != null) {
                        file2 = new File(FileLoader.getDirectory(3), this.currentFileNames[i]);
                        file3 = new File(FileLoader.getDirectory(4), this.currentFileNames[i]);
                        messageObject2 = null;
                        z4 = false;
                        z3 = false;
                    } else {
                        PageBlocksAdapter pageBlocksAdapter = this.pageBlocksAdapter;
                        if (pageBlocksAdapter != null) {
                            file = pageBlocksAdapter.getFile(i2);
                            boolean zIsVideo = this.pageBlocksAdapter.isVideo(i2);
                            zShouldIndexAutoPlayed = shouldIndexAutoPlayed(i2);
                            z3 = zIsVideo;
                            r3 = 0;
                            messageObject2 = null;
                            z4 = false;
                        } else {
                            file = null;
                            messageObject = null;
                            messageObject2 = messageObject;
                            zShouldIndexAutoPlayed = false;
                            z4 = false;
                            z3 = false;
                            r3 = messageObject;
                        }
                    }
                    file = pathToAttach;
                    messageObject = null;
                    messageObject2 = messageObject;
                    zShouldIndexAutoPlayed = false;
                    z4 = false;
                    z3 = false;
                    r3 = messageObject;
                }
                file = file2;
                zShouldIndexAutoPlayed = false;
                r3 = file3;
            }
            final boolean z7 = z4;
            final boolean z8 = z3;
            final boolean z9 = !(i == 0 && this.dontAutoPlay) && zShouldIndexAutoPlayed;
            Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda50
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$checkProgress$59(file, r3, i, messageObject2, z7, z8, z9, z2);
                }
            });
            return;
        }
        if (!this.imagesArrLocals.isEmpty() && i2 >= 0 && i2 < this.imagesArrLocals.size()) {
            Object obj = this.imagesArrLocals.get(i2);
            if (obj instanceof MediaController.PhotoEntry) {
                z6 = ((MediaController.PhotoEntry) obj).isVideo;
            }
        }
        if (z6) {
            this.photoProgressViews[i].setBackgroundState(3, z2, true);
        } else {
            this.photoProgressViews[i].setBackgroundState(-1, z2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkProgress$59(final File file, final File file2, final int i, MessageObject messageObject, final boolean z, final boolean z2, final boolean z3, final boolean z4) {
        ChatActivity chatActivity;
        TLRPC$Document document;
        boolean zExists = file != null ? file.exists() : false;
        if (!zExists && file2 != null) {
            zExists = file2.exists();
        }
        final boolean z5 = zExists;
        if (!z5 && i != 0 && messageObject != null && z && DownloadController.getInstance(this.currentAccount).canDownloadMedia(messageObject.messageOwner) != 0 && (((chatActivity = this.parentChatActivity) == null || chatActivity.getCurrentEncryptedChat() == null) && !messageObject.shouldEncryptPhotoOrVideo() && (document = messageObject.getDocument()) != null)) {
            FileLoader.getInstance(this.currentAccount).loadFile(document, messageObject, 0, 10);
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda51
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$checkProgress$58(file, file2, z5, z, i, z2, z3, z4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkProgress$58(File file, File file2, boolean z, boolean z2, int i, boolean z3, boolean z4, boolean z5) {
        boolean z6 = true;
        if ((file != null || file2 != null) && (z || z2)) {
            if (i != 0 || !this.isPlaying) {
                if (z3 && (!z4 || (i == 0 && this.playerWasPlaying))) {
                    this.photoProgressViews[i].setBackgroundState(3, z5, true);
                } else {
                    this.photoProgressViews[i].setBackgroundState(-1, z5, true);
                }
            }
            if (i == 0) {
                if (z || !FileLoader.getInstance(this.currentAccount).isLoadingFile(this.currentFileNames[i])) {
                    this.menuItem.hideSubItem(7);
                } else {
                    this.menuItem.showSubItem(7);
                }
            }
        } else {
            if (z3) {
                if (!FileLoader.getInstance(this.currentAccount).isLoadingFile(this.currentFileNames[i])) {
                    this.photoProgressViews[i].setBackgroundState(2, false, true);
                } else {
                    this.photoProgressViews[i].setBackgroundState(1, false, true);
                }
            } else {
                this.photoProgressViews[i].setBackgroundState(0, z5, true);
            }
            Float fileProgress = ImageLoader.getInstance().getFileProgress(this.currentFileNames[i]);
            if (fileProgress == null) {
                fileProgress = Float.valueOf(0.0f);
            }
            this.photoProgressViews[i].setProgress(fileProgress.floatValue(), false);
        }
        if (i == 0) {
            if (this.imagesArrLocals.isEmpty() && (this.currentFileNames[0] == null || this.photoProgressViews[0].backgroundState == 0)) {
                z6 = false;
            }
            this.canZoom = z6;
        }
    }

    public int getSelectiongLength() {
        PhotoViewerCaptionEnterView photoViewerCaptionEnterView = this.captionEditText;
        if (photoViewerCaptionEnterView != null) {
            return photoViewerCaptionEnterView.getSelectionLength();
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v11, types: [org.rbmain.tgnet.TLRPC$PhotoSize] */
    /* JADX WARN: Type inference failed for: r16v10 */
    /* JADX WARN: Type inference failed for: r16v11 */
    /* JADX WARN: Type inference failed for: r16v13 */
    /* JADX WARN: Type inference failed for: r16v16 */
    /* JADX WARN: Type inference failed for: r16v17 */
    /* JADX WARN: Type inference failed for: r16v18 */
    /* JADX WARN: Type inference failed for: r16v8 */
    /* JADX WARN: Type inference failed for: r16v9 */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v10 */
    /* JADX WARN: Type inference failed for: r17v11 */
    /* JADX WARN: Type inference failed for: r17v2 */
    /* JADX WARN: Type inference failed for: r17v3 */
    /* JADX WARN: Type inference failed for: r17v4 */
    /* JADX WARN: Type inference failed for: r17v5 */
    /* JADX WARN: Type inference failed for: r17v6 */
    /* JADX WARN: Type inference failed for: r17v7 */
    /* JADX WARN: Type inference failed for: r17v8 */
    /* JADX WARN: Type inference failed for: r17v9 */
    /* JADX WARN: Type inference failed for: r2v63, types: [org.rbmain.tgnet.TLRPC$PhotoSize] */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v19, types: [org.rbmain.tgnet.TLRPC$PhotoSize] */
    /* JADX WARN: Type inference failed for: r9v30, types: [org.rbmain.tgnet.TLRPC$PhotoSize] */
    /* JADX WARN: Type inference failed for: r9v33, types: [org.rbmain.tgnet.TLObject] */
    /* JADX WARN: Type inference failed for: r9v42 */
    /* JADX WARN: Type inference failed for: r9v44 */
    private void setIndexToImage(ImageReceiver imageReceiver, int i) throws Resources.NotFoundException {
        MessageObject messageObject;
        TLRPC$PhotoSize closestPhotoSizeWithSize;
        TLObject tLObject;
        ImageLocation forDocument;
        Object obj;
        Object chat;
        String str;
        WebFile webFile;
        TLRPC$Document tLRPC$Document;
        ?? r9;
        String str2;
        String str3;
        ImageLocation forDocument2;
        String str4;
        int i2;
        boolean z;
        int i3;
        int i4;
        TLRPC$Photo tLRPC$Photo;
        String str5;
        TLRPC$Document tLRPC$Document2;
        String str6;
        Object obj2;
        ?? r16;
        String str7;
        int i5;
        WebFile webFileCreateWithWebDocument;
        Object obj3;
        WebFile webFile2;
        ImageLocation forWebFile;
        String str8;
        WebFile webFileCreateWithWebDocument2;
        TLRPC$Document tLRPC$Document3;
        Drawable drawable;
        Activity activity;
        Drawable drawable2;
        Drawable drawable3;
        Activity activity2;
        Drawable drawable4;
        String str9;
        imageReceiver.setOrientation(0, false);
        if (!this.secureDocuments.isEmpty()) {
            if (i < 0 || i >= this.secureDocuments.size()) {
                return;
            }
            this.secureDocuments.get(i);
            AndroidUtilities.getPhotoSize();
            float f = AndroidUtilities.density;
            ImageReceiver.BitmapHolder thumbForPhoto = this.currentThumb;
            if (thumbForPhoto == null || imageReceiver != this.centerImage) {
                thumbForPhoto = null;
            }
            if (thumbForPhoto == null) {
                thumbForPhoto = this.placeProvider.getThumbForPhoto(null, null, i);
            }
            imageReceiver.setImage(ImageLocation.getForSecureDocument(this.secureDocuments.get(i)), "d", null, null, thumbForPhoto != null ? new BitmapDrawable(thumbForPhoto.bitmap) : null, r1.secureFile.size, null, null, 0);
            return;
        }
        if (!this.imagesArrLocals.isEmpty()) {
            if (i >= 0 && i < this.imagesArrLocals.size()) {
                Object obj4 = this.imagesArrLocals.get(i);
                int photoSize = (int) (AndroidUtilities.getPhotoSize() / AndroidUtilities.density);
                ImageReceiver.BitmapHolder bitmapHolder = this.currentThumb;
                if (bitmapHolder == null || imageReceiver != this.centerImage) {
                    bitmapHolder = null;
                }
                if (bitmapHolder == null) {
                    bitmapHolder = this.placeProvider.getThumbForPhoto(null, null, i);
                }
                String str10 = "d";
                if (obj4 instanceof MediaController.PhotoEntry) {
                    MediaController.PhotoEntry photoEntry = (MediaController.PhotoEntry) obj4;
                    boolean z2 = photoEntry.isVideo;
                    if (z2) {
                        str2 = photoEntry.thumbPath;
                        if (str2 != null) {
                            if (this.fromCamera) {
                                Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str2);
                                if (bitmapDecodeFile != null) {
                                    bitmapHolder = new ImageReceiver.BitmapHolder(bitmapDecodeFile);
                                    photoEntry.thumbPath = null;
                                }
                                str9 = null;
                                str2 = null;
                            }
                        } else {
                            str2 = "vthumb://" + photoEntry.imageId + ":" + photoEntry.path;
                        }
                        str9 = null;
                    } else {
                        str2 = photoEntry.filterPath;
                        if (str2 == null) {
                            imageReceiver.setOrientation(photoEntry.orientation, false);
                            str2 = photoEntry.path;
                        }
                        str9 = String.format(Locale.US, "%d_%d", Integer.valueOf(photoSize), Integer.valueOf(photoSize));
                    }
                    str3 = str9;
                    webFile = null;
                    tLRPC$Document = null;
                    forDocument2 = null;
                    str4 = null;
                    z = z2;
                    i3 = 0;
                    r9 = 0;
                    i2 = 0;
                } else if (obj4 instanceof TLRPC$BotInlineResult) {
                    TLRPC$BotInlineResult tLRPC$BotInlineResult = (TLRPC$BotInlineResult) obj4;
                    if (tLRPC$BotInlineResult.type.equals(MediaStreamTrack.VIDEO_TRACK_KIND) || MessageObject.isVideoDocument(tLRPC$BotInlineResult.document)) {
                        TLRPC$Document tLRPC$Document4 = tLRPC$BotInlineResult.document;
                        if (tLRPC$Document4 != null) {
                            ?? closestPhotoSizeWithSize2 = FileLoader.getClosestPhotoSizeWithSize(tLRPC$Document4.thumbs, 90);
                            obj2 = tLRPC$BotInlineResult.document;
                            str3 = null;
                            r16 = null;
                            forDocument2 = null;
                            str7 = closestPhotoSizeWithSize2;
                            i5 = 0;
                            obj3 = obj2;
                            webFile2 = forDocument2;
                            str4 = str7;
                            tLRPC$Document = r16;
                            z = false;
                            i3 = 1;
                            int i6 = i5;
                            str2 = null;
                            i2 = i6;
                            webFile = webFile2;
                            r9 = obj3;
                        } else {
                            TLRPC$WebDocument tLRPC$WebDocument = tLRPC$BotInlineResult.thumb;
                            if (tLRPC$WebDocument instanceof TLRPC$TL_webDocument) {
                                str6 = null;
                                webFileCreateWithWebDocument = WebFile.createWithWebDocument(tLRPC$WebDocument);
                            } else {
                                webFileCreateWithWebDocument = null;
                                str6 = null;
                            }
                            str7 = str6;
                            str3 = str7;
                            r16 = str3;
                            forDocument2 = r16;
                            i5 = 0;
                            webFile2 = webFileCreateWithWebDocument;
                            obj3 = str6;
                            str4 = str7;
                            tLRPC$Document = r16;
                            z = false;
                            i3 = 1;
                            int i62 = i5;
                            str2 = null;
                            i2 = i62;
                            webFile = webFile2;
                            r9 = obj3;
                        }
                    } else {
                        if (tLRPC$BotInlineResult.type.equals("gif") && (tLRPC$Document3 = tLRPC$BotInlineResult.document) != null) {
                            int i7 = tLRPC$Document3.size;
                            TLRPC$VideoSize documentVideoThumb = MessageObject.getDocumentVideoThumb(tLRPC$Document3);
                            str3 = "d";
                            r16 = tLRPC$Document3;
                            forDocument2 = documentVideoThumb != null ? ImageLocation.getForDocument(documentVideoThumb, tLRPC$Document3) : null;
                            i5 = i7;
                            webFileCreateWithWebDocument2 = null;
                            str8 = null;
                        } else {
                            TLRPC$Photo tLRPC$Photo2 = tLRPC$BotInlineResult.photo;
                            if (tLRPC$Photo2 != null) {
                                ?? closestPhotoSizeWithSize3 = FileLoader.getClosestPhotoSizeWithSize(tLRPC$Photo2.sizes, AndroidUtilities.getPhotoSize());
                                obj2 = tLRPC$BotInlineResult.photo;
                                i5 = closestPhotoSizeWithSize3.size;
                                r16 = null;
                                forDocument2 = null;
                                str3 = String.format(Locale.US, "%d_%d", Integer.valueOf(photoSize), Integer.valueOf(photoSize));
                                str7 = closestPhotoSizeWithSize3;
                                obj3 = obj2;
                                webFile2 = forDocument2;
                                str4 = str7;
                                tLRPC$Document = r16;
                                z = false;
                                i3 = 1;
                                int i622 = i5;
                                str2 = null;
                                i2 = i622;
                                webFile = webFile2;
                                r9 = obj3;
                            } else {
                                if (tLRPC$BotInlineResult.content instanceof TLRPC$TL_webDocument) {
                                    if (tLRPC$BotInlineResult.type.equals("gif")) {
                                        TLRPC$WebDocument tLRPC$WebDocument2 = tLRPC$BotInlineResult.thumb;
                                        if ((tLRPC$WebDocument2 instanceof TLRPC$TL_webDocument) && "video/mp4".equals(tLRPC$WebDocument2.mime_type)) {
                                            forWebFile = ImageLocation.getForWebFile(WebFile.createWithWebDocument(tLRPC$BotInlineResult.thumb));
                                        }
                                        r16 = null;
                                        str3 = str10;
                                        forDocument2 = forWebFile;
                                        i5 = 0;
                                        str8 = null;
                                        webFileCreateWithWebDocument2 = WebFile.createWithWebDocument(tLRPC$BotInlineResult.content);
                                    } else {
                                        str10 = String.format(Locale.US, "%d_%d", Integer.valueOf(photoSize), Integer.valueOf(photoSize));
                                    }
                                    forWebFile = null;
                                    r16 = null;
                                    str3 = str10;
                                    forDocument2 = forWebFile;
                                    i5 = 0;
                                    str8 = null;
                                    webFileCreateWithWebDocument2 = WebFile.createWithWebDocument(tLRPC$BotInlineResult.content);
                                }
                                webFileCreateWithWebDocument = null;
                                str6 = null;
                                str7 = str6;
                                str3 = str7;
                                r16 = str3;
                                forDocument2 = r16;
                                i5 = 0;
                                webFile2 = webFileCreateWithWebDocument;
                                obj3 = str6;
                                str4 = str7;
                                tLRPC$Document = r16;
                                z = false;
                                i3 = 1;
                                int i6222 = i5;
                                str2 = null;
                                i2 = i6222;
                                webFile = webFile2;
                                r9 = obj3;
                            }
                        }
                        str7 = str8;
                        webFile2 = webFileCreateWithWebDocument2;
                        obj3 = str8;
                        str4 = str7;
                        tLRPC$Document = r16;
                        z = false;
                        i3 = 1;
                        int i62222 = i5;
                        str2 = null;
                        i2 = i62222;
                        webFile = webFile2;
                        r9 = obj3;
                    }
                } else if (obj4 instanceof MediaController.SearchImage) {
                    MediaController.SearchImage searchImage = (MediaController.SearchImage) obj4;
                    ?? r10 = searchImage.photoSize;
                    if (r10 != 0) {
                        tLRPC$Photo = searchImage.photo;
                        i4 = r10.size;
                        tLRPC$Document2 = null;
                        str5 = r10;
                        str2 = null;
                    } else {
                        str2 = searchImage.filterPath;
                        if (str2 != null) {
                            tLRPC$Photo = null;
                            str5 = null;
                            tLRPC$Document2 = null;
                            i4 = 0;
                        } else {
                            TLRPC$Document tLRPC$Document5 = searchImage.document;
                            if (tLRPC$Document5 != null) {
                                i4 = tLRPC$Document5.size;
                                tLRPC$Photo = null;
                                str5 = null;
                                tLRPC$Document2 = tLRPC$Document5;
                                str2 = null;
                            } else {
                                str2 = searchImage.imageUrl;
                                i4 = searchImage.size;
                                tLRPC$Photo = null;
                                str5 = null;
                                tLRPC$Document2 = null;
                            }
                        }
                    }
                    forDocument2 = null;
                    str4 = str5;
                    tLRPC$Document = tLRPC$Document2;
                    i3 = 1;
                    str3 = "d";
                    i2 = i4;
                    z = false;
                    r9 = tLRPC$Photo;
                    webFile = null;
                } else {
                    webFile = null;
                    tLRPC$Document = null;
                    r9 = 0;
                    str2 = null;
                    str3 = null;
                    forDocument2 = null;
                    str4 = null;
                    i2 = 0;
                    z = false;
                    i3 = 0;
                }
                if (tLRPC$Document != null) {
                    TLRPC$PhotoSize closestPhotoSizeWithSize4 = FileLoader.getClosestPhotoSizeWithSize(tLRPC$Document.thumbs, 90);
                    if (forDocument2 != null) {
                        imageReceiver.setImage(ImageLocation.getForDocument(tLRPC$Document), "d", forDocument2, null, bitmapHolder == null ? ImageLocation.getForDocument(closestPhotoSizeWithSize4, tLRPC$Document) : null, String.format(Locale.US, "%d_%d", Integer.valueOf(photoSize), Integer.valueOf(photoSize)), bitmapHolder != null ? new BitmapDrawable(bitmapHolder.bitmap) : null, i2, null, obj4, i3);
                        return;
                    } else {
                        imageReceiver.setImage(ImageLocation.getForDocument(tLRPC$Document), "d", bitmapHolder == null ? ImageLocation.getForDocument(closestPhotoSizeWithSize4, tLRPC$Document) : null, String.format(Locale.US, "%d_%d", Integer.valueOf(photoSize), Integer.valueOf(photoSize)), bitmapHolder != null ? new BitmapDrawable(bitmapHolder.bitmap) : null, i2, null, obj4, i3);
                        return;
                    }
                }
                ?? r2 = str4;
                if (r2 != 0) {
                    imageReceiver.setImage(ImageLocation.getForObject(r2, r9), str3, bitmapHolder != null ? new BitmapDrawable(bitmapHolder.bitmap) : null, i2, (String) null, obj4, i3);
                    return;
                }
                if (webFile == null) {
                    if (bitmapHolder != null) {
                        drawable2 = new BitmapDrawable(bitmapHolder.bitmap);
                    } else {
                        if (!z || (activity = this.parentActivity) == null) {
                            drawable = null;
                            imageReceiver.setImage(str2, str3, drawable, (String) null, i2);
                            return;
                        }
                        drawable2 = activity.getResources().getDrawable(R.drawable.nophotos);
                    }
                    drawable = drawable2;
                    imageReceiver.setImage(str2, str3, drawable, (String) null, i2);
                    return;
                }
                if (forDocument2 != null) {
                    imageReceiver.setImage(ImageLocation.getForWebFile(webFile), str3, forDocument2, (String) null, (Drawable) null, obj4, i3);
                    return;
                }
                ImageLocation forWebFile2 = ImageLocation.getForWebFile(webFile);
                if (bitmapHolder != null) {
                    drawable4 = new BitmapDrawable(bitmapHolder.bitmap);
                } else {
                    if (!z || (activity2 = this.parentActivity) == null) {
                        drawable3 = null;
                        imageReceiver.setImage(forWebFile2, str3, drawable3, null, obj4, i3);
                        return;
                    }
                    drawable4 = activity2.getResources().getDrawable(R.drawable.nophotos);
                }
                drawable3 = drawable4;
                imageReceiver.setImage(forWebFile2, str3, drawable3, null, obj4, i3);
                return;
            }
            imageReceiver.setImageBitmap((Bitmap) null);
            return;
        }
        PageBlocksAdapter pageBlocksAdapter = this.pageBlocksAdapter;
        if (pageBlocksAdapter != null) {
            int[] iArr = new int[1];
            TLObject media = pageBlocksAdapter.getMedia(i);
            TLRPC$PhotoSize fileLocation = this.pageBlocksAdapter.getFileLocation(media, iArr);
            if (fileLocation != null) {
                if (media instanceof TLRPC$Photo) {
                    TLRPC$Photo tLRPC$Photo3 = (TLRPC$Photo) media;
                    ImageReceiver.BitmapHolder bitmapHolder2 = this.currentThumb;
                    if (bitmapHolder2 == null || imageReceiver != this.centerImage) {
                        bitmapHolder2 = null;
                    }
                    if (iArr[0] == 0) {
                        iArr[0] = -1;
                    }
                    imageReceiver.setImage(ImageLocation.getForPhoto(fileLocation, tLRPC$Photo3), null, ImageLocation.getForPhoto(FileLoader.getClosestPhotoSizeWithSize(tLRPC$Photo3.sizes, 80), tLRPC$Photo3), "b", bitmapHolder2 != null ? new BitmapDrawable(bitmapHolder2.bitmap) : null, iArr[0], null, this.pageBlocksAdapter.getParentObject(), 1);
                    return;
                }
                if (this.pageBlocksAdapter.isVideo(i)) {
                    if (!(fileLocation.location instanceof TLRPC$TL_fileLocationUnavailable)) {
                        ImageReceiver.BitmapHolder bitmapHolder3 = this.currentThumb;
                        if (bitmapHolder3 == null || imageReceiver != this.centerImage) {
                            bitmapHolder3 = null;
                        }
                        imageReceiver.setImage(null, null, bitmapHolder3 == null ? ImageLocation.getForDocument(fileLocation, (TLRPC$Document) media) : null, "b", bitmapHolder3 != null ? new BitmapDrawable(bitmapHolder3.bitmap) : null, 0L, null, this.pageBlocksAdapter.getParentObject(), 1);
                        return;
                    }
                    imageReceiver.setImageBitmap(this.parentActivity.getResources().getDrawable(R.drawable.photoview_placeholder));
                    return;
                }
                AnimatedFileDrawable animatedFileDrawable = this.currentAnimation;
                if (animatedFileDrawable != null) {
                    imageReceiver.setImageBitmap(animatedFileDrawable);
                    this.currentAnimation.addSecondParentView(this.containerView);
                    return;
                }
                return;
            }
            if (iArr[0] == 0) {
                imageReceiver.setImageBitmap((Bitmap) null);
                return;
            } else {
                imageReceiver.setImageBitmap(this.parentActivity.getResources().getDrawable(R.drawable.photoview_placeholder));
                return;
            }
        }
        if (this.imagesArr.isEmpty() || i < 0 || i >= this.imagesArr.size()) {
            messageObject = null;
        } else {
            MessageObject messageObject2 = this.imagesArr.get(i);
            imageReceiver.setShouldGenerateQualityThumb(true);
            messageObject = messageObject2;
        }
        if (messageObject != null) {
            if (!TextUtils.isEmpty(MessagesController.getRestrictionReason(messageObject.messageOwner.restriction_reason))) {
                imageReceiver.setImageBitmap(this.parentActivity.getResources().getDrawable(R.drawable.photoview_placeholder));
                return;
            }
            if (messageObject.isVideo() || messageObject.isVideoFile()) {
                ArrayList<TLRPC$PhotoSize> arrayList = messageObject.photoThumbs;
                if (arrayList != null && !arrayList.isEmpty()) {
                    ImageReceiver.BitmapHolder bitmapHolder4 = this.currentThumb;
                    if (bitmapHolder4 == null || imageReceiver != this.centerImage) {
                        bitmapHolder4 = null;
                    }
                    TLRPC$PhotoSize closestPhotoSizeWithSize5 = FileLoader.getClosestPhotoSizeWithSize(messageObject.photoThumbs, 320);
                    imageReceiver.setNeedsQualityThumb(closestPhotoSizeWithSize5.w < 100 && closestPhotoSizeWithSize5.h < 100);
                    imageReceiver.setImage(null, null, bitmapHolder4 == null ? ImageLocation.getForObject(closestPhotoSizeWithSize5, messageObject.photoThumbsObject) : null, "b", bitmapHolder4 != null ? new BitmapDrawable(bitmapHolder4.bitmap) : null, 0L, null, messageObject, 1);
                    ImageReceiver.BitmapHolder bitmapHolder5 = this.currentThumb;
                    if (bitmapHolder5 != null) {
                        imageReceiver.setOrientation(bitmapHolder5.orientation, false);
                        return;
                    }
                    return;
                }
                imageReceiver.setImageBitmap(this.parentActivity.getResources().getDrawable(R.drawable.photoview_placeholder));
                return;
            }
            AnimatedFileDrawable animatedFileDrawable2 = this.currentAnimation;
            if (animatedFileDrawable2 != null) {
                animatedFileDrawable2.addSecondParentView(this.containerView);
                imageReceiver.setImageBitmap(this.currentAnimation);
                return;
            }
            if (this.sharedMediaType == 1) {
                if (messageObject.canPreviewDocument()) {
                    TLRPC$Document document = messageObject.getDocument();
                    imageReceiver.setNeedsQualityThumb(true);
                    ImageReceiver.BitmapHolder bitmapHolder6 = this.currentThumb;
                    if (bitmapHolder6 == null || imageReceiver != this.centerImage) {
                        bitmapHolder6 = null;
                    }
                    TLRPC$PhotoSize closestPhotoSizeWithSize6 = FileLoader.getClosestPhotoSizeWithSize(messageObject.photoThumbs, 100);
                    int i8 = (int) (2048.0f / AndroidUtilities.density);
                    imageReceiver.setImage(ImageLocation.getForDocument(document), String.format(Locale.US, "%d_%d", Integer.valueOf(i8), Integer.valueOf(i8)), bitmapHolder6 == null ? ImageLocation.getForDocument(closestPhotoSizeWithSize6, document) : null, "b", bitmapHolder6 != null ? new BitmapDrawable(bitmapHolder6.bitmap) : null, document.size, null, messageObject, 0);
                    return;
                }
                imageReceiver.setImageBitmap(new OtherDocumentPlaceholderDrawable(this.parentActivity, this.containerView, messageObject));
                return;
            }
        }
        int[] iArr2 = new int[1];
        ImageLocation imageLocation = getImageLocation(i, iArr2);
        TLObject fileLocation2 = getFileLocation(i, iArr2);
        imageReceiver.setNeedsQualityThumb(true);
        if (imageLocation != null) {
            ImageReceiver.BitmapHolder bitmapHolder7 = this.currentThumb;
            if (bitmapHolder7 == null || imageReceiver != this.centerImage) {
                bitmapHolder7 = null;
            }
            if (iArr2[0] == 0) {
                iArr2[0] = -1;
            }
            if (messageObject != null) {
                closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(messageObject.photoThumbs, 100);
                tLObject = messageObject.photoThumbsObject;
            } else {
                closestPhotoSizeWithSize = null;
                tLObject = null;
            }
            TLRPC$PhotoSize tLRPC$PhotoSize = (closestPhotoSizeWithSize == null || closestPhotoSizeWithSize != fileLocation2) ? closestPhotoSizeWithSize : null;
            int i9 = ((messageObject == null || !messageObject.isWebpage()) && this.avatarsDialogId == 0 && !this.isEvent) ? 0 : 1;
            if (messageObject != null) {
                if (this.sharedMediaType == 5) {
                    TLRPC$Document document2 = messageObject.getDocument();
                    TLRPC$VideoSize documentVideoThumb2 = MessageObject.getDocumentVideoThumb(document2);
                    forDocument = documentVideoThumb2 != null ? ImageLocation.getForDocument(documentVideoThumb2, document2) : null;
                    obj = messageObject;
                } else {
                    obj = messageObject;
                    forDocument = null;
                }
            } else {
                int i10 = this.avatarsDialogId;
                if (i10 != 0) {
                    if (i10 > 0) {
                        chat = MessagesController.getInstance(this.currentAccount).getUser(Integer.valueOf(this.avatarsDialogId));
                    } else {
                        chat = MessagesController.getInstance(this.currentAccount).getChat(Integer.valueOf(-this.avatarsDialogId));
                    }
                    obj = chat;
                    forDocument = null;
                } else {
                    forDocument = null;
                    obj = null;
                }
            }
            if (forDocument != null) {
                imageReceiver.setImage(imageLocation, null, forDocument, null, bitmapHolder7 == null ? ImageLocation.getForObject(tLRPC$PhotoSize, tLObject) : null, "b", bitmapHolder7 != null ? new BitmapDrawable(bitmapHolder7.bitmap) : null, iArr2[0], null, obj, i9);
                return;
            }
            if (this.avatarsDialogId != 0) {
                str = imageLocation.imageType == 2 ? ImageLoader.AUTOPLAY_FILTER : null;
            } else {
                str = null;
            }
            imageReceiver.setImage(imageLocation, str, bitmapHolder7 == null ? ImageLocation.getForObject(tLRPC$PhotoSize, tLObject) : null, "b", bitmapHolder7 != null ? new BitmapDrawable(bitmapHolder7.bitmap) : null, iArr2[0], null, obj, i9);
            return;
        }
        if (iArr2[0] == 0) {
            imageReceiver.setImageBitmap((Bitmap) null);
        } else {
            imageReceiver.setImageBitmap(this.parentActivity.getResources().getDrawable(R.drawable.photoview_placeholder));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean isShowingImage(org.rbmain.messenger.MessageObject r8) {
        /*
            org.rbmain.ui.PhotoViewer r0 = org.rbmain.ui.PhotoViewer.Instance
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L4a
            org.rbmain.ui.PhotoViewer r0 = org.rbmain.ui.PhotoViewer.Instance
            boolean r0 = r0.pipAnimationInProgress
            if (r0 != 0) goto L4a
            org.rbmain.ui.PhotoViewer r0 = org.rbmain.ui.PhotoViewer.Instance
            boolean r0 = r0.isVisible
            if (r0 == 0) goto L4a
            org.rbmain.ui.PhotoViewer r0 = org.rbmain.ui.PhotoViewer.Instance
            boolean r0 = r0.disableShowCheck
            if (r0 != 0) goto L4a
            if (r8 == 0) goto L4a
            org.rbmain.ui.PhotoViewer r0 = org.rbmain.ui.PhotoViewer.Instance
            org.rbmain.messenger.MessageObject r0 = r0.currentMessageObject
            if (r0 != 0) goto L2e
            org.rbmain.ui.PhotoViewer r3 = org.rbmain.ui.PhotoViewer.Instance
            org.rbmain.ui.PhotoViewer$PhotoViewerProvider r3 = r3.placeProvider
            if (r3 == 0) goto L2e
            org.rbmain.ui.PhotoViewer r0 = org.rbmain.ui.PhotoViewer.Instance
            org.rbmain.ui.PhotoViewer$PhotoViewerProvider r0 = r0.placeProvider
            org.rbmain.messenger.MessageObject r0 = r0.getEditingMessageObject()
        L2e:
            if (r0 == 0) goto L4a
            long r3 = r0.getId()
            long r5 = r8.getId()
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L4a
            long r3 = r0.getDialogId()
            long r5 = r8.getDialogId()
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 != 0) goto L4a
            r0 = 1
            goto L4b
        L4a:
            r0 = 0
        L4b:
            if (r0 != 0) goto L88
            org.rbmain.ui.PhotoViewer r3 = org.rbmain.ui.PhotoViewer.PipInstance
            if (r3 == 0) goto L88
            org.rbmain.ui.PhotoViewer r0 = org.rbmain.ui.PhotoViewer.PipInstance
            boolean r0 = r0.isVisible
            if (r0 == 0) goto L86
            org.rbmain.ui.PhotoViewer r0 = org.rbmain.ui.PhotoViewer.PipInstance
            boolean r0 = r0.disableShowCheck
            if (r0 != 0) goto L86
            if (r8 == 0) goto L86
            org.rbmain.ui.PhotoViewer r0 = org.rbmain.ui.PhotoViewer.PipInstance
            org.rbmain.messenger.MessageObject r0 = r0.currentMessageObject
            if (r0 == 0) goto L86
            org.rbmain.ui.PhotoViewer r0 = org.rbmain.ui.PhotoViewer.PipInstance
            org.rbmain.messenger.MessageObject r0 = r0.currentMessageObject
            long r3 = r0.getId()
            long r5 = r8.getId()
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 != 0) goto L86
            org.rbmain.ui.PhotoViewer r0 = org.rbmain.ui.PhotoViewer.PipInstance
            org.rbmain.messenger.MessageObject r0 = r0.currentMessageObject
            long r3 = r0.getDialogId()
            long r5 = r8.getDialogId()
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 != 0) goto L86
            goto L87
        L86:
            r1 = 0
        L87:
            r0 = r1
        L88:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.PhotoViewer.isShowingImage(org.rbmain.messenger.MessageObject):boolean");
    }

    public static boolean isPlayingMessageInPip(MessageObject messageObject) {
        return (PipInstance == null || messageObject == null || PipInstance.currentMessageObject == null || PipInstance.currentMessageObject.getId() != messageObject.getId() || PipInstance.currentMessageObject.getDialogId() != messageObject.getDialogId()) ? false : true;
    }

    public static boolean isPlayingMessage(MessageObject messageObject) {
        return (Instance == null || Instance.pipAnimationInProgress || !Instance.isVisible || messageObject == null || Instance.currentMessageObject == null || Instance.currentMessageObject.getId() != messageObject.getId() || Instance.currentMessageObject.getDialogId() != messageObject.getDialogId()) ? false : true;
    }

    public static boolean isShowingImage(TLRPC$FileLocation tLRPC$FileLocation) {
        if (Instance == null || !Instance.isVisible || Instance.disableShowCheck || tLRPC$FileLocation == null) {
            return false;
        }
        return (Instance.currentFileLocation != null && tLRPC$FileLocation.local_id == Instance.currentFileLocation.location.local_id && tLRPC$FileLocation.volume_id == Instance.currentFileLocation.location.volume_id && tLRPC$FileLocation.dc_id == Instance.currentFileLocation.dc_id) || (Instance.currentFileLocationVideo != null && tLRPC$FileLocation.local_id == Instance.currentFileLocationVideo.location.local_id && tLRPC$FileLocation.volume_id == Instance.currentFileLocationVideo.location.volume_id && tLRPC$FileLocation.dc_id == Instance.currentFileLocationVideo.dc_id);
    }

    public static boolean isShowingImage(TLRPC$BotInlineResult tLRPC$BotInlineResult) {
        return (Instance == null || !Instance.isVisible || Instance.disableShowCheck || tLRPC$BotInlineResult == null || Instance.currentBotInlineResult == null || tLRPC$BotInlineResult.id != Instance.currentBotInlineResult.id) ? false : true;
    }

    public static boolean isShowingImage(String str) {
        return (Instance == null || !Instance.isVisible || Instance.disableShowCheck || str == null || !str.equals(Instance.currentPathObject)) ? false : true;
    }

    public void setParentChatActivity(ChatActivity chatActivity) {
        this.parentChatActivity = chatActivity;
    }

    public void setMaxSelectedPhotos(int i, boolean z) {
        this.maxSelectedPhotos = i;
        this.allowOrder = z;
    }

    public void checkCurrentImageVisibility() {
        PlaceProviderObject placeProviderObject = this.currentPlaceObject;
        if (placeProviderObject != null) {
            placeProviderObject.imageReceiver.setVisible(true, true);
        }
        PlaceProviderObject placeForPhoto = this.placeProvider.getPlaceForPhoto(this.currentMessageObject, getFileLocation(this.currentFileLocation), this.currentIndex, false);
        this.currentPlaceObject = placeForPhoto;
        if (placeForPhoto != null) {
            placeForPhoto.imageReceiver.setVisible(false, true);
        }
    }

    public boolean openPhoto(MessageObject messageObject, ChatActivity chatActivity, long j, long j2, PhotoViewerProvider photoViewerProvider) {
        return openPhoto(messageObject, null, null, null, null, null, null, 0, photoViewerProvider, chatActivity, j, j2, true, null);
    }

    public boolean openPhoto(MessageObject messageObject, long j, long j2, PhotoViewerProvider photoViewerProvider, boolean z) {
        return openPhoto(messageObject, null, null, null, null, null, null, 0, photoViewerProvider, null, j, j2, z, null);
    }

    public boolean openPhoto(TLRPC$FileLocation tLRPC$FileLocation, PhotoViewerProvider photoViewerProvider) {
        return openPhoto(null, tLRPC$FileLocation, null, null, null, null, null, 0, photoViewerProvider, null, 0L, 0L, true, null);
    }

    public boolean openPhotoWithVideo(TLRPC$FileLocation tLRPC$FileLocation, ImageLocation imageLocation, PhotoViewerProvider photoViewerProvider) {
        return openPhoto(null, tLRPC$FileLocation, null, imageLocation, null, null, null, 0, photoViewerProvider, null, 0L, 0L, true, null);
    }

    public boolean openPhoto(TLRPC$FileLocation tLRPC$FileLocation, ImageLocation imageLocation, PhotoViewerProvider photoViewerProvider) {
        return openPhoto(null, tLRPC$FileLocation, imageLocation, null, null, null, null, 0, photoViewerProvider, null, 0L, 0L, true, null);
    }

    public boolean openPhoto(ArrayList<MessageObject> arrayList, int i, long j, long j2, PhotoViewerProvider photoViewerProvider) {
        return openPhoto(arrayList.get(i), null, null, null, arrayList, null, null, i, photoViewerProvider, null, j, j2, true, null);
    }

    public boolean openPhoto(ArrayList<SecureDocument> arrayList, int i, PhotoViewerProvider photoViewerProvider) {
        return openPhoto(null, null, null, null, null, arrayList, null, i, photoViewerProvider, null, 0L, 0L, true, null);
    }

    public boolean openPhoto(int i, PageBlocksAdapter pageBlocksAdapter, PhotoViewerProvider photoViewerProvider) {
        return openPhoto(null, null, null, null, null, null, null, i, photoViewerProvider, null, 0L, 0L, true, pageBlocksAdapter);
    }

    public boolean openPhotoForSelect(ArrayList<Object> arrayList, int i, int i2, boolean z, PhotoViewerProvider photoViewerProvider, ChatActivity chatActivity) throws IllegalAccessException, NoSuchFieldException, Resources.NotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException {
        this.isDocumentsPicker = z;
        ImageView imageView = this.pickerViewSendButton;
        if (imageView != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
            if (i2 == 4 || i2 == 5) {
                this.pickerViewSendButton.setImageResource(R.drawable.attach_send);
                layoutParams.bottomMargin = AndroidUtilities.dp(19.0f);
            } else if (i2 == 1 || i2 == 3 || i2 == 10) {
                this.pickerViewSendButton.setImageResource(R.drawable.floating_check);
                this.pickerViewSendButton.setPadding(0, AndroidUtilities.dp(1.0f), 0, 0);
                layoutParams.bottomMargin = AndroidUtilities.dp(19.0f);
            } else {
                this.pickerViewSendButton.setImageResource(R.drawable.attach_send);
                layoutParams.bottomMargin = AndroidUtilities.dp(14.0f);
            }
            this.pickerViewSendButton.setLayoutParams(layoutParams);
        }
        if (this.sendPhotoType != 1 && i2 == 1 && this.isVisible) {
            this.sendPhotoType = i2;
            this.doneButtonPressed = false;
            this.actionBar.setTitle(LocaleController.formatString("Of", R.string.Of, 1, 1));
            this.placeProvider = photoViewerProvider;
            this.mergeDialogId = 0L;
            this.currentDialogId = 0L;
            this.selectedPhotosAdapter.notifyDataSetChanged();
            this.pageBlocksAdapter = null;
            if (this.velocityTracker == null) {
                this.velocityTracker = VelocityTracker.obtain();
            }
            this.isVisible = true;
            togglePhotosListView(false, false);
            this.openedFullScreenVideo = false;
            createCropView();
            toggleActionBar(false, false);
            this.seekToProgressPending2 = 0.0f;
            this.skipFirstBufferingProgress = false;
            this.playerInjected = false;
            makeFocusable();
            this.backgroundDrawable.setAlpha(255);
            this.containerView.setAlpha(1.0f);
            onPhotoShow(null, null, null, null, null, null, arrayList, i, null);
            initCropView();
            setCropBitmap();
            return true;
        }
        this.sendPhotoType = i2;
        return openPhoto(null, null, null, null, null, null, arrayList, i, photoViewerProvider, chatActivity, 0L, 0L, true, null);
    }

    private void openCurrentPhotoInPaintModeForSelect() {
        final File file;
        final MessageObject messageObject;
        final boolean z;
        final boolean z2;
        if (canSendMediaToParentChatActivity()) {
            MessageObject messageObject2 = this.currentMessageObject;
            File pathToMessage = null;
            if (messageObject2 != null) {
                boolean z3 = messageObject2.canEditMedia() && !this.currentMessageObject.isDocument();
                boolean zIsVideo = this.currentMessageObject.isVideo();
                if (!TextUtils.isEmpty(this.currentMessageObject.messageOwner.attachPath)) {
                    File file2 = new File(this.currentMessageObject.messageOwner.attachPath);
                    if (file2.exists()) {
                        pathToMessage = file2;
                    }
                }
                if (pathToMessage == null) {
                    pathToMessage = FileLoader.getPathToMessage(this.currentMessageObject.messageOwner);
                }
                messageObject = messageObject2;
                file = pathToMessage;
                z2 = z3;
                z = zIsVideo;
            } else {
                file = null;
                messageObject = null;
                z = false;
                z2 = false;
            }
            if (file != null && file.exists()) {
                this.savedState = new SavedState(this.currentIndex, new ArrayList(this.imagesArr), this.placeProvider);
                toggleActionBar(false, true, new ActionBarToggleParams().enableStatusBarAnimation(false));
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda52
                    @Override // java.lang.Runnable
                    public final void run() throws IllegalAccessException, NoSuchFieldException, Resources.NotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException {
                        this.f$0.lambda$openCurrentPhotoInPaintModeForSelect$60(file, z, messageObject, z2);
                    }
                }, r0.animationDuration);
                return;
            }
            showDownloadAlert();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openCurrentPhotoInPaintModeForSelect$60(File file, boolean z, final MessageObject messageObject, final boolean z2) throws IllegalAccessException, NoSuchFieldException, Resources.NotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException {
        int i;
        try {
            int attributeInt = new ExifInterface(file.getAbsolutePath()).getAttributeInt("Orientation", 1);
            i = attributeInt != 3 ? attributeInt != 6 ? attributeInt != 8 ? 0 : 270 : 90 : 180;
        } catch (Exception e) {
            FileLog.e(e);
            i = 0;
        }
        int i2 = this.lastImageId;
        this.lastImageId = i2 - 1;
        final MediaController.PhotoEntry photoEntry = new MediaController.PhotoEntry(0, i2, 0L, file.getAbsolutePath(), i, z, 0, 0, 0L);
        this.sendPhotoType = 2;
        this.doneButtonPressed = false;
        final PhotoViewerProvider photoViewerProvider = this.placeProvider;
        this.placeProvider = new EmptyPhotoViewerProvider() { // from class: org.rbmain.ui.PhotoViewer.59
            private final ImageReceiver.BitmapHolder thumbHolder;

            @Override // org.rbmain.ui.PhotoViewer.EmptyPhotoViewerProvider, org.rbmain.ui.PhotoViewer.PhotoViewerProvider
            public boolean canCaptureMorePhotos() {
                return false;
            }

            {
                this.thumbHolder = PhotoViewer.this.centerImage.getBitmapSafe();
            }

            @Override // org.rbmain.ui.PhotoViewer.EmptyPhotoViewerProvider, org.rbmain.ui.PhotoViewer.PhotoViewerProvider
            public PlaceProviderObject getPlaceForPhoto(MessageObject messageObject2, TLRPC$FileLocation tLRPC$FileLocation, int i3, boolean z3) {
                PhotoViewerProvider photoViewerProvider2 = photoViewerProvider;
                if (photoViewerProvider2 != null) {
                    return photoViewerProvider2.getPlaceForPhoto(messageObject, null, 0, z3);
                }
                return null;
            }

            @Override // org.rbmain.ui.PhotoViewer.EmptyPhotoViewerProvider, org.rbmain.ui.PhotoViewer.PhotoViewerProvider
            public ImageReceiver.BitmapHolder getThumbForPhoto(MessageObject messageObject2, TLRPC$FileLocation tLRPC$FileLocation, int i3) {
                return this.thumbHolder;
            }

            @Override // org.rbmain.ui.PhotoViewer.EmptyPhotoViewerProvider, org.rbmain.ui.PhotoViewer.PhotoViewerProvider
            public void sendButtonPressed(int i3, VideoEditedInfo videoEditedInfo, boolean z3, int i4, boolean z4) {
                sendMedia(videoEditedInfo, z3, i4, false);
            }

            @Override // org.rbmain.ui.PhotoViewer.EmptyPhotoViewerProvider, org.rbmain.ui.PhotoViewer.PhotoViewerProvider
            public void replaceButtonPressed(int i3, VideoEditedInfo videoEditedInfo) {
                MediaController.PhotoEntry photoEntry2 = photoEntry;
                if (photoEntry2.isCropped || photoEntry2.isPainted || photoEntry2.isFiltered || videoEditedInfo != null || !TextUtils.isEmpty(photoEntry2.caption)) {
                    sendMedia(videoEditedInfo, false, 0, true);
                }
            }

            @Override // org.rbmain.ui.PhotoViewer.EmptyPhotoViewerProvider, org.rbmain.ui.PhotoViewer.PhotoViewerProvider
            public boolean canReplace(int i3) {
                return photoViewerProvider != null && z2;
            }

            @Override // org.rbmain.ui.PhotoViewer.EmptyPhotoViewerProvider, org.rbmain.ui.PhotoViewer.PhotoViewerProvider
            public MessageObject getEditingMessageObject() {
                return messageObject;
            }

            private void sendMedia(VideoEditedInfo videoEditedInfo, boolean z3, int i3, boolean z4) {
                if (PhotoViewer.this.parentChatActivity != null) {
                    MessageObject messageObject2 = z4 ? messageObject : null;
                    if (messageObject2 != null && !TextUtils.isEmpty(photoEntry.caption)) {
                        MediaController.PhotoEntry photoEntry2 = photoEntry;
                        messageObject2.editingMessage = photoEntry2.caption;
                        messageObject2.editingMessageEntities = photoEntry2.entities;
                    }
                    MediaController.PhotoEntry photoEntry3 = photoEntry;
                    if (photoEntry3.isVideo) {
                        if (videoEditedInfo != null) {
                            AccountInstance accountInstance = PhotoViewer.this.parentChatActivity.getAccountInstance();
                            String str = photoEntry.path;
                            long dialogId = PhotoViewer.this.parentChatActivity.getDialogId();
                            MessageObject replyMessage = PhotoViewer.this.parentChatActivity.getReplyMessage();
                            MessageObject threadMessage = PhotoViewer.this.parentChatActivity.getThreadMessage();
                            MediaController.PhotoEntry photoEntry4 = photoEntry;
                            SendMessagesHelper.prepareSendingVideo(accountInstance, str, videoEditedInfo, dialogId, replyMessage, threadMessage, photoEntry4.caption, photoEntry4.entities, photoEntry4.ttl, messageObject2, z3, i3);
                            return;
                        }
                        AccountInstance accountInstance2 = PhotoViewer.this.parentChatActivity.getAccountInstance();
                        String str2 = photoEntry.path;
                        long dialogId2 = PhotoViewer.this.parentChatActivity.getDialogId();
                        MessageObject replyMessage2 = PhotoViewer.this.parentChatActivity.getReplyMessage();
                        MessageObject threadMessage2 = PhotoViewer.this.parentChatActivity.getThreadMessage();
                        MediaController.PhotoEntry photoEntry5 = photoEntry;
                        SendMessagesHelper.prepareSendingVideo(accountInstance2, str2, null, dialogId2, replyMessage2, threadMessage2, photoEntry5.caption, photoEntry5.entities, photoEntry5.ttl, messageObject2, z3, i3);
                        return;
                    }
                    if (photoEntry3.imagePath != null) {
                        AccountInstance accountInstance3 = PhotoViewer.this.parentChatActivity.getAccountInstance();
                        MediaController.PhotoEntry photoEntry6 = photoEntry;
                        String str3 = photoEntry6.imagePath;
                        String str4 = photoEntry6.thumbPath;
                        long dialogId3 = PhotoViewer.this.parentChatActivity.getDialogId();
                        MessageObject replyMessage3 = PhotoViewer.this.parentChatActivity.getReplyMessage();
                        MessageObject threadMessage3 = PhotoViewer.this.parentChatActivity.getThreadMessage();
                        MediaController.PhotoEntry photoEntry7 = photoEntry;
                        SendMessagesHelper.prepareSendingPhoto(accountInstance3, str3, str4, null, dialogId3, replyMessage3, threadMessage3, photoEntry7.caption, photoEntry7.entities, photoEntry7.stickers, null, photoEntry7.ttl, messageObject2, videoEditedInfo, z3, i3);
                        return;
                    }
                    if (photoEntry3.path != null) {
                        AccountInstance accountInstance4 = PhotoViewer.this.parentChatActivity.getAccountInstance();
                        MediaController.PhotoEntry photoEntry8 = photoEntry;
                        String str5 = photoEntry8.path;
                        String str6 = photoEntry8.thumbPath;
                        long dialogId4 = PhotoViewer.this.parentChatActivity.getDialogId();
                        MessageObject replyMessage4 = PhotoViewer.this.parentChatActivity.getReplyMessage();
                        MessageObject threadMessage4 = PhotoViewer.this.parentChatActivity.getThreadMessage();
                        MediaController.PhotoEntry photoEntry9 = photoEntry;
                        SendMessagesHelper.prepareSendingPhoto(accountInstance4, str5, str6, null, dialogId4, replyMessage4, threadMessage4, photoEntry9.caption, photoEntry9.entities, photoEntry9.stickers, null, photoEntry9.ttl, messageObject2, videoEditedInfo, z3, i3);
                    }
                }
            }
        };
        this.selectedPhotosAdapter.notifyDataSetChanged();
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        togglePhotosListView(false, false);
        toggleActionBar(true, false);
        ChatActivity chatActivity = this.parentChatActivity;
        if (chatActivity != null && chatActivity.getChatActivityEnterView() != null && this.parentChatActivity.isKeyboardVisible()) {
            this.parentChatActivity.getChatActivityEnterView().closeKeyboard();
        } else {
            makeFocusable();
        }
        this.backgroundDrawable.setAlpha(255);
        this.containerView.setAlpha(1.0f);
        onPhotoShow(null, null, null, null, null, null, Collections.singletonList(photoEntry), 0, null);
        this.pickerView.setTranslationY(AndroidUtilities.dp(this.isCurrentVideo ? 154.0f : 96.0f));
        this.pickerViewSendButton.setTranslationY(AndroidUtilities.dp(this.isCurrentVideo ? 154.0f : 96.0f));
        this.actionBar.setTranslationY(-r0.getHeight());
        this.captionTextViewSwitcher.setTranslationY(AndroidUtilities.dp(this.isCurrentVideo ? 154.0f : 96.0f));
        createPaintView();
        switchToPaintMode();
    }

    private boolean checkAnimation() {
        if (this.animationInProgress != 0 && Math.abs(this.transitionAnimationStartTime - System.currentTimeMillis()) >= 500) {
            Runnable runnable = this.animationEndRunnable;
            if (runnable != null) {
                runnable.run();
                this.animationEndRunnable = null;
            }
            this.animationInProgress = 0;
        }
        return this.animationInProgress != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCropBitmap() {
        VideoEditTextureView videoEditTextureView;
        if (this.cropInitied || this.sendPhotoType != 1) {
            return;
        }
        if (!this.isCurrentVideo || ((videoEditTextureView = (VideoEditTextureView) this.videoTextureView) != null && videoEditTextureView.getVideoWidth() > 0 && videoEditTextureView.getVideoHeight() > 0)) {
            this.cropInitied = true;
            Bitmap bitmap = this.centerImage.getBitmap();
            int orientation = this.centerImage.getOrientation();
            if (bitmap == null) {
                bitmap = this.animatingImageView.getBitmap();
                orientation = this.animatingImageView.getOrientation();
            }
            Bitmap bitmap2 = bitmap;
            int i = orientation;
            if (bitmap2 == null && this.videoTextureView == null) {
                return;
            }
            this.photoCropView.setBitmap(bitmap2, i, false, false, this.paintingOverlay, this.cropTransform, this.isCurrentVideo ? (VideoEditTextureView) this.videoTextureView : null, this.editState.cropState);
        }
    }

    private void initCropView() {
        PhotoCropView photoCropView = this.photoCropView;
        if (photoCropView == null) {
            return;
        }
        photoCropView.setBitmap(null, 0, false, false, null, null, null, null);
        if (this.sendPhotoType != 1) {
            return;
        }
        this.photoCropView.onAppear();
        this.photoCropView.setVisibility(0);
        this.photoCropView.setAlpha(1.0f);
        this.photoCropView.onAppeared();
        this.padImageForHorizontalInsets = true;
    }

    public boolean openPhoto(MessageObject messageObject, TLRPC$FileLocation tLRPC$FileLocation, ImageLocation imageLocation, ImageLocation imageLocation2, ArrayList<MessageObject> arrayList, ArrayList<SecureDocument> arrayList2, ArrayList<Object> arrayList3, int i, PhotoViewerProvider photoViewerProvider, ChatActivity chatActivity, long j, long j2, boolean z, PageBlocksAdapter pageBlocksAdapter) throws IllegalAccessException, NoSuchFieldException, Resources.NotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException {
        PhotoViewerProvider photoViewerProvider2;
        if (this.parentActivity != null && !this.isVisible && ((photoViewerProvider != null || !checkAnimation()) && (messageObject != null || tLRPC$FileLocation != null || arrayList != null || arrayList3 != null || arrayList2 != null || imageLocation != null || pageBlocksAdapter != null))) {
            PlaceProviderObject placeForPhoto = photoViewerProvider.getPlaceForPhoto(messageObject, tLRPC$FileLocation, i, true);
            this.lastInsets = null;
            WindowManager windowManager = (WindowManager) this.parentActivity.getSystemService("window");
            if (this.attachedToWindow) {
                try {
                    windowManager.removeView(this.windowView);
                } catch (Exception unused) {
                }
            }
            try {
                WindowManager.LayoutParams layoutParams = this.windowLayoutParams;
                layoutParams.type = 99;
                if (Build.VERSION.SDK_INT >= 21) {
                    layoutParams.flags = -2147286784;
                } else {
                    layoutParams.flags = MessagesController.UPDATE_MASK_REORDER;
                }
                if (chatActivity == null || chatActivity.getCurrentEncryptedChat() == null) {
                    this.windowLayoutParams.flags &= -8193;
                } else {
                    this.windowLayoutParams.flags |= 8192;
                }
                this.windowLayoutParams.softInputMode = (this.useSmoothKeyboard ? 32 : 16) | 256;
                this.windowView.setFocusable(false);
                this.containerView.setFocusable(false);
                windowManager.addView(this.windowView, this.windowLayoutParams);
                this.doneButtonPressed = false;
                this.allowShowFullscreenButton = true;
                this.parentChatActivity = chatActivity;
                this.lastTitle = null;
                this.actionBar.setTitle(LocaleController.formatString("Of", R.string.Of, 1, 1));
                this.actionBar.setTitleScrollNonFitText(false);
                NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.fileDidFailToLoad);
                NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.fileDidLoad);
                NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.FileLoadProgressChanged);
                NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.mediaCountDidLoad);
                NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.mediaDidLoad);
                NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.dialogPhotosLoaded);
                NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.messagesDeleted);
                NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.emojiDidLoad);
                NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.filePreparingFailed);
                NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.fileNewChunkAvailable);
                this.placeProvider = photoViewerProvider;
                this.mergeDialogId = j2;
                this.currentDialogId = j;
                this.selectedPhotosAdapter.notifyDataSetChanged();
                this.pageBlocksAdapter = pageBlocksAdapter;
                if (this.velocityTracker == null) {
                    this.velocityTracker = VelocityTracker.obtain();
                }
                this.isVisible = true;
                togglePhotosListView(false, false);
                boolean z2 = !z;
                this.openedFullScreenVideo = z2;
                if (z2) {
                    toggleActionBar(false, false);
                } else if (this.sendPhotoType == 1) {
                    createCropView();
                    toggleActionBar(false, false);
                } else {
                    toggleActionBar(true, false);
                }
                this.seekToProgressPending2 = 0.0f;
                this.skipFirstBufferingProgress = false;
                this.playerInjected = false;
                if (placeForPhoto != null) {
                    this.disableShowCheck = true;
                    this.animationInProgress = 1;
                    if (messageObject != null) {
                        AnimatedFileDrawable animation = placeForPhoto.allowTakeAnimation ? placeForPhoto.imageReceiver.getAnimation() : null;
                        this.currentAnimation = animation;
                        if (animation != null) {
                            if (messageObject.isVideo()) {
                                placeForPhoto.imageReceiver.setAllowStartAnimation(false);
                                placeForPhoto.imageReceiver.stopAnimation();
                                if (MediaController.getInstance().isPlayingMessage(messageObject)) {
                                    this.seekToProgressPending2 = messageObject.audioProgress;
                                }
                                this.skipFirstBufferingProgress = this.injectingVideoPlayer == null && !FileLoader.getInstance(messageObject.currentAccount).isLoadingVideo(messageObject.getDocument(), true) && (this.currentAnimation.hasBitmap() || !FileLoader.getInstance(messageObject.currentAccount).isLoadingVideo(messageObject.getDocument(), false));
                                this.currentAnimation = null;
                            } else if (messageObject.getWebPagePhotos(null, null).size() > 1) {
                                this.currentAnimation = null;
                            }
                        }
                    } else if (pageBlocksAdapter != null) {
                        this.currentAnimation = placeForPhoto.imageReceiver.getAnimation();
                    }
                    onPhotoShow(messageObject, tLRPC$FileLocation, imageLocation, imageLocation2, arrayList, arrayList2, arrayList3, i, placeForPhoto);
                    if (this.sendPhotoType == 1) {
                        this.photoCropView.setVisibility(0);
                        this.photoCropView.setAlpha(0.0f);
                        this.photoCropView.setFreeform(false);
                    }
                    RectF drawRegion = placeForPhoto.imageReceiver.getDrawRegion();
                    float f = drawRegion.left;
                    float f2 = drawRegion.top;
                    int orientation = placeForPhoto.imageReceiver.getOrientation();
                    int animatedOrientation = placeForPhoto.imageReceiver.getAnimatedOrientation();
                    if (animatedOrientation != 0) {
                        orientation = animatedOrientation;
                    }
                    ClippingImageView[] animatingImageViews = getAnimatingImageViews(placeForPhoto);
                    for (int i2 = 0; i2 < animatingImageViews.length; i2++) {
                        animatingImageViews[i2].setAnimationValues(this.animationValues);
                        animatingImageViews[i2].setVisibility(0);
                        animatingImageViews[i2].setRadius(placeForPhoto.radius);
                        animatingImageViews[i2].setOrientation(orientation);
                        animatingImageViews[i2].setImageBitmap(placeForPhoto.thumb);
                    }
                    initCropView();
                    if (this.sendPhotoType == 1) {
                        this.photoCropView.setAspectRatio(1.0f);
                    }
                    ViewGroup.LayoutParams layoutParams2 = this.animatingImageView.getLayoutParams();
                    layoutParams2.width = (int) drawRegion.width();
                    int iHeight = (int) drawRegion.height();
                    layoutParams2.height = iHeight;
                    if (layoutParams2.width <= 0) {
                        layoutParams2.width = 100;
                    }
                    if (iHeight <= 0) {
                        layoutParams2.height = 100;
                    }
                    for (int i3 = 0; i3 < animatingImageViews.length; i3++) {
                        if (animatingImageViews.length > 1) {
                            animatingImageViews[i3].setAlpha(0.0f);
                        } else {
                            animatingImageViews[i3].setAlpha(1.0f);
                        }
                        animatingImageViews[i3].setPivotX(0.0f);
                        animatingImageViews[i3].setPivotY(0.0f);
                        animatingImageViews[i3].setScaleX(placeForPhoto.scale);
                        animatingImageViews[i3].setScaleY(placeForPhoto.scale);
                        animatingImageViews[i3].setTranslationX(placeForPhoto.viewX + (drawRegion.left * placeForPhoto.scale));
                        animatingImageViews[i3].setTranslationY(placeForPhoto.viewY + (drawRegion.top * placeForPhoto.scale));
                        animatingImageViews[i3].setLayoutParams(layoutParams2);
                    }
                    this.windowView.getViewTreeObserver().addOnPreDrawListener(new AnonymousClass60(animatingImageViews, layoutParams2, f, placeForPhoto, f2, pageBlocksAdapter, arrayList3));
                } else {
                    if (arrayList3 != null && this.sendPhotoType != 3 && ((photoViewerProvider2 = this.placeProvider) == null || !photoViewerProvider2.closeKeyboard())) {
                        makeFocusable();
                    }
                    this.backgroundDrawable.setAlpha(255);
                    this.containerView.setAlpha(1.0f);
                    onPhotoShow(messageObject, tLRPC$FileLocation, imageLocation, imageLocation2, arrayList, arrayList2, arrayList3, i, placeForPhoto);
                    initCropView();
                    setCropBitmap();
                    ChatActivity chatActivity2 = this.parentChatActivity;
                    if (chatActivity2 != null) {
                        chatActivity2.getUndoView().hide(false, 1);
                        this.parentChatActivity.getFragmentView().invalidate();
                    }
                }
                AccessibilityManager accessibilityManager = (AccessibilityManager) this.parentActivity.getSystemService("accessibility");
                if (accessibilityManager.isTouchExplorationEnabled()) {
                    AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                    accessibilityEventObtain.setEventType(LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM);
                    accessibilityEventObtain.getText().add(LocaleController.getString("AccDescrPhotoViewer", R.string.AccDescrPhotoViewer));
                    accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain);
                }
                return true;
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
        return false;
    }

    /* renamed from: org.rbmain.ui.PhotoViewer$60, reason: invalid class name */
    class AnonymousClass60 implements ViewTreeObserver.OnPreDrawListener {
        final /* synthetic */ ClippingImageView[] val$animatingImageViews;
        final /* synthetic */ ViewGroup.LayoutParams val$layoutParams;
        final /* synthetic */ float val$left;
        final /* synthetic */ PlaceProviderObject val$object;
        final /* synthetic */ PageBlocksAdapter val$pageBlocksAdapter;
        final /* synthetic */ ArrayList val$photos;
        final /* synthetic */ float val$top;

        AnonymousClass60(ClippingImageView[] clippingImageViewArr, ViewGroup.LayoutParams layoutParams, float f, PlaceProviderObject placeProviderObject, float f2, PageBlocksAdapter pageBlocksAdapter, ArrayList arrayList) {
            this.val$animatingImageViews = clippingImageViewArr;
            this.val$layoutParams = layoutParams;
            this.val$left = f;
            this.val$object = placeProviderObject;
            this.val$top = f2;
            this.val$pageBlocksAdapter = pageBlocksAdapter;
            this.val$photos = arrayList;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            float fMin;
            float f;
            float measuredWidth;
            ClippingImageView[] clippingImageViewArr;
            int i;
            ClippingImageView[] clippingImageViewArr2 = this.val$animatingImageViews;
            if (clippingImageViewArr2.length > 1) {
                clippingImageViewArr2[1].setAlpha(1.0f);
                this.val$animatingImageViews[1].setAdditionalTranslationX(-PhotoViewer.this.getLeftInset());
            }
            ClippingImageView[] clippingImageViewArr3 = this.val$animatingImageViews;
            clippingImageViewArr3[0].setTranslationX(clippingImageViewArr3[0].getTranslationX() + PhotoViewer.this.getLeftInset());
            PhotoViewer.this.windowView.getViewTreeObserver().removeOnPreDrawListener(this);
            if (PhotoViewer.this.sendPhotoType == 1) {
                float f2 = PhotoViewer.this.isStatusBarVisible() ? AndroidUtilities.statusBarHeight : 0;
                float measuredHeight = (PhotoViewer.this.photoCropView.getMeasuredHeight() - AndroidUtilities.dp(64.0f)) - f2;
                float measuredWidth2 = PhotoViewer.this.photoCropView.getMeasuredWidth() / 2.0f;
                float f3 = f2 + (measuredHeight / 2.0f);
                float fMin2 = (Math.min(PhotoViewer.this.photoCropView.getMeasuredWidth(), measuredHeight) - (AndroidUtilities.dp(16.0f) * 2)) / 2.0f;
                float f4 = f3 - fMin2;
                ViewGroup.LayoutParams layoutParams = this.val$layoutParams;
                float f5 = (f3 + fMin2) - f4;
                fMin = Math.max(((measuredWidth2 + fMin2) - (measuredWidth2 - fMin2)) / layoutParams.width, f5 / layoutParams.height);
                f = f4 + ((f5 - (this.val$layoutParams.height * fMin)) / 2.0f);
                measuredWidth = ((((PhotoViewer.this.windowView.getMeasuredWidth() - PhotoViewer.this.getLeftInset()) - PhotoViewer.this.getRightInset()) - (this.val$layoutParams.width * fMin)) / 2.0f) + PhotoViewer.this.getLeftInset();
            } else {
                fMin = Math.min(PhotoViewer.this.windowView.getMeasuredWidth() / this.val$layoutParams.width, (AndroidUtilities.displaySize.y + (PhotoViewer.this.isStatusBarVisible() ? AndroidUtilities.statusBarHeight : 0)) / this.val$layoutParams.height);
                f = ((AndroidUtilities.displaySize.y + (PhotoViewer.this.isStatusBarVisible() ? AndroidUtilities.statusBarHeight : 0)) - (this.val$layoutParams.height * fMin)) / 2.0f;
                measuredWidth = (PhotoViewer.this.windowView.getMeasuredWidth() - (this.val$layoutParams.width * fMin)) / 2.0f;
            }
            int iAbs = (int) Math.abs(this.val$left - this.val$object.imageReceiver.getImageX());
            int iAbs2 = (int) Math.abs(this.val$top - this.val$object.imageReceiver.getImageY());
            if (this.val$pageBlocksAdapter != null && this.val$object.imageReceiver.isAspectFit()) {
                iAbs = 0;
            }
            int[] iArr = new int[2];
            this.val$object.parentView.getLocationInWindow(iArr);
            int i2 = iArr[1];
            int i3 = Build.VERSION.SDK_INT;
            float f6 = i2 - ((i3 >= 21 || PhotoViewer.this.inBubbleMode) ? 0 : AndroidUtilities.statusBarHeight);
            int i4 = this.val$object.viewY;
            float f7 = this.val$top;
            int i5 = (int) ((f6 - (i4 + f7)) + r14.clipTopAddition);
            if (i5 < 0) {
                i5 = 0;
            }
            int height = (int) ((((i4 + f7) + this.val$layoutParams.height) - ((iArr[1] + r14.parentView.getHeight()) - ((i3 >= 21 || PhotoViewer.this.inBubbleMode) ? 0 : AndroidUtilities.statusBarHeight))) + this.val$object.clipBottomAddition);
            if (height < 0) {
                height = 0;
            }
            int iMax = Math.max(i5, iAbs2);
            int iMax2 = Math.max(height, iAbs2);
            PhotoViewer.this.animationValues[0][0] = PhotoViewer.this.animatingImageView.getScaleX();
            PhotoViewer.this.animationValues[0][1] = PhotoViewer.this.animatingImageView.getScaleY();
            PhotoViewer.this.animationValues[0][2] = PhotoViewer.this.animatingImageView.getTranslationX();
            PhotoViewer.this.animationValues[0][3] = PhotoViewer.this.animatingImageView.getTranslationY();
            float f8 = iAbs;
            PhotoViewer.this.animationValues[0][4] = this.val$object.scale * f8;
            PhotoViewer.this.animationValues[0][5] = iMax * this.val$object.scale;
            PhotoViewer.this.animationValues[0][6] = iMax2 * this.val$object.scale;
            int[] radius = PhotoViewer.this.animatingImageView.getRadius();
            int i6 = 0;
            while (true) {
                float f9 = 0.0f;
                if (i6 >= 4) {
                    break;
                }
                float[] fArr = PhotoViewer.this.animationValues[0];
                int i7 = i6 + 7;
                if (radius != null) {
                    f9 = radius[i6];
                }
                fArr[i7] = f9;
                i6++;
            }
            PhotoViewer.this.animationValues[0][11] = iAbs2 * this.val$object.scale;
            PhotoViewer.this.animationValues[0][12] = f8 * this.val$object.scale;
            PhotoViewer.this.animationValues[1][0] = fMin;
            PhotoViewer.this.animationValues[1][1] = fMin;
            PhotoViewer.this.animationValues[1][2] = measuredWidth;
            PhotoViewer.this.animationValues[1][3] = f;
            PhotoViewer.this.animationValues[1][4] = 0.0f;
            PhotoViewer.this.animationValues[1][5] = 0.0f;
            PhotoViewer.this.animationValues[1][6] = 0.0f;
            PhotoViewer.this.animationValues[1][7] = 0.0f;
            PhotoViewer.this.animationValues[1][8] = 0.0f;
            PhotoViewer.this.animationValues[1][9] = 0.0f;
            PhotoViewer.this.animationValues[1][10] = 0.0f;
            PhotoViewer.this.animationValues[1][11] = 0.0f;
            PhotoViewer.this.animationValues[1][12] = 0.0f;
            int i8 = 0;
            while (true) {
                ClippingImageView[] clippingImageViewArr4 = this.val$animatingImageViews;
                if (i8 >= clippingImageViewArr4.length) {
                    break;
                }
                clippingImageViewArr4[i8].setAnimationProgress(0.0f);
                i8++;
            }
            PhotoViewer.this.backgroundDrawable.setAlpha(0);
            PhotoViewer.this.containerView.setAlpha(0.0f);
            PhotoViewer photoViewer = PhotoViewer.this;
            final ClippingImageView[] clippingImageViewArr5 = this.val$animatingImageViews;
            final ArrayList arrayList = this.val$photos;
            photoViewer.animationEndRunnable = new Runnable() { // from class: org.rbmain.ui.PhotoViewer$60$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() throws Resources.NotFoundException {
                    this.f$0.lambda$onPreDraw$0(clippingImageViewArr5, arrayList);
                }
            };
            if (PhotoViewer.this.openedFullScreenVideo) {
                if (PhotoViewer.this.animationEndRunnable != null) {
                    PhotoViewer.this.animationEndRunnable.run();
                    PhotoViewer.this.animationEndRunnable = null;
                }
                PhotoViewer.this.containerView.setAlpha(1.0f);
                PhotoViewer.this.backgroundDrawable.setAlpha(255);
                int i9 = 0;
                while (true) {
                    ClippingImageView[] clippingImageViewArr6 = this.val$animatingImageViews;
                    if (i9 >= clippingImageViewArr6.length) {
                        break;
                    }
                    clippingImageViewArr6[i9].setAnimationProgress(1.0f);
                    i9++;
                }
                if (PhotoViewer.this.sendPhotoType == 1) {
                    PhotoViewer.this.photoCropView.setAlpha(1.0f);
                }
            } else {
                final AnimatorSet animatorSet = new AnimatorSet();
                int i10 = PhotoViewer.this.sendPhotoType != 1 ? 2 : 3;
                ClippingImageView[] clippingImageViewArr7 = this.val$animatingImageViews;
                ArrayList arrayList2 = new ArrayList(i10 + clippingImageViewArr7.length + (clippingImageViewArr7.length > 1 ? 1 : 0));
                int i11 = 0;
                while (true) {
                    clippingImageViewArr = this.val$animatingImageViews;
                    if (i11 >= clippingImageViewArr.length) {
                        break;
                    }
                    arrayList2.add(ObjectAnimator.ofFloat(clippingImageViewArr[i11], AnimationProperties.CLIPPING_IMAGE_VIEW_PROGRESS, 0.0f, 1.0f));
                    i11++;
                }
                if (clippingImageViewArr.length > 1) {
                    i = 2;
                    arrayList2.add(ObjectAnimator.ofFloat(PhotoViewer.this.animatingImageView, (Property<ClippingImageView, Float>) View.ALPHA, 0.0f, 1.0f));
                } else {
                    i = 2;
                }
                int[] iArr2 = new int[i];
                // fill-array-data instruction
                iArr2[0] = 0;
                iArr2[1] = 255;
                arrayList2.add(ObjectAnimator.ofInt(PhotoViewer.this.backgroundDrawable, (Property<BackgroundDrawable, Integer>) AnimationProperties.COLOR_DRAWABLE_ALPHA, iArr2));
                float[] fArr2 = new float[i];
                // fill-array-data instruction
                fArr2[0] = 0.0f;
                fArr2[1] = 1.0f;
                arrayList2.add(ObjectAnimator.ofFloat(PhotoViewer.this.containerView, (Property<FrameLayoutDrawer, Float>) View.ALPHA, fArr2));
                if (PhotoViewer.this.sendPhotoType == 1) {
                    float[] fArr3 = new float[i];
                    // fill-array-data instruction
                    fArr3[0] = 0.0f;
                    fArr3[1] = 1.0f;
                    arrayList2.add(ObjectAnimator.ofFloat(PhotoViewer.this.photoCropView, (Property<PhotoCropView, Float>) View.ALPHA, fArr3));
                }
                animatorSet.playTogether(arrayList2);
                animatorSet.setDuration(200L);
                final int i12 = PhotoViewer.this.currentAccount;
                animatorSet.addListener(new AnonymousClass1(i12));
                if (Build.VERSION.SDK_INT >= 18) {
                    PhotoViewer.this.containerView.setLayerType(2, null);
                }
                PhotoViewer.this.setCaptionHwLayerEnabled(false);
                PhotoViewer.this.transitionAnimationStartTime = System.currentTimeMillis();
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.PhotoViewer$60$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onPreDraw$1(i12, animatorSet);
                    }
                });
            }
            BackgroundDrawable backgroundDrawable = PhotoViewer.this.backgroundDrawable;
            final PlaceProviderObject placeProviderObject = this.val$object;
            backgroundDrawable.drawRunnable = new Runnable() { // from class: org.rbmain.ui.PhotoViewer$60$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onPreDraw$2(placeProviderObject);
                }
            };
            if (PhotoViewer.this.parentChatActivity != null) {
                PhotoViewer.this.parentChatActivity.getUndoView().hide(false, 1);
                PhotoViewer.this.parentChatActivity.getFragmentView().invalidate();
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onPreDraw$0(ClippingImageView[] clippingImageViewArr, ArrayList arrayList) throws Resources.NotFoundException {
            PhotoViewer.this.animationEndRunnable = null;
            if (PhotoViewer.this.containerView == null || PhotoViewer.this.windowView == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 18) {
                PhotoViewer.this.containerView.setLayerType(0, null);
            }
            PhotoViewer.this.animationInProgress = 0;
            PhotoViewer.this.transitionAnimationStartTime = 0L;
            PhotoViewer.this.setImages();
            PhotoViewer.this.setCropBitmap();
            PhotoViewer.this.containerView.invalidate();
            for (ClippingImageView clippingImageView : clippingImageViewArr) {
                clippingImageView.setVisibility(8);
            }
            if (PhotoViewer.this.showAfterAnimation != null) {
                PhotoViewer.this.showAfterAnimation.imageReceiver.setVisible(true, true);
            }
            if (PhotoViewer.this.hideAfterAnimation != null) {
                PhotoViewer.this.hideAfterAnimation.imageReceiver.setVisible(false, true);
            }
            if (arrayList != null && PhotoViewer.this.sendPhotoType != 3 && (PhotoViewer.this.placeProvider == null || !PhotoViewer.this.placeProvider.closeKeyboard())) {
                PhotoViewer.this.makeFocusable();
            }
            if (PhotoViewer.this.videoPlayer == null || !PhotoViewer.this.videoPlayer.isPlaying() || !PhotoViewer.this.isCurrentVideo || PhotoViewer.this.imagesArrLocals.isEmpty()) {
                return;
            }
            PhotoViewer photoViewer = PhotoViewer.this;
            photoViewer.seekAnimatedStickersTo(photoViewer.videoPlayer.getCurrentPosition());
            PhotoViewer.this.playOrStopAnimatedStickers(true);
        }

        /* renamed from: org.rbmain.ui.PhotoViewer$60$1, reason: invalid class name */
        class AnonymousClass1 extends AnimatorListenerAdapter {
            final /* synthetic */ int val$account;

            AnonymousClass1(int i) {
                this.val$account = i;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                final int i = this.val$account;
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.PhotoViewer$60$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onAnimationEnd$0(i);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onAnimationEnd$0(int i) {
                NotificationCenter.getInstance(i).onAnimationFinish(PhotoViewer.this.transitionIndex);
                if (PhotoViewer.this.animationEndRunnable != null) {
                    PhotoViewer.this.animationEndRunnable.run();
                    PhotoViewer.this.animationEndRunnable = null;
                }
                PhotoViewer.this.setCaptionHwLayerEnabled(true);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onPreDraw$1(int i, AnimatorSet animatorSet) {
            PhotoViewer.this.transitionIndex = NotificationCenter.getInstance(i).setAnimationInProgress(PhotoViewer.this.transitionIndex, new int[]{NotificationCenter.dialogsNeedReload, NotificationCenter.closeChats, NotificationCenter.mediaCountDidLoad, NotificationCenter.mediaDidLoad, NotificationCenter.dialogPhotosLoaded});
            animatorSet.start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onPreDraw$2(PlaceProviderObject placeProviderObject) {
            PhotoViewer.this.disableShowCheck = false;
            placeProviderObject.imageReceiver.setVisible(false, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void makeFocusable() {
        if (Build.VERSION.SDK_INT >= 21) {
            this.windowLayoutParams.flags = -2147417856;
        } else {
            this.windowLayoutParams.flags = 0;
        }
        this.windowLayoutParams.softInputMode = (this.useSmoothKeyboard ? 32 : 16) | 256;
        try {
            ((WindowManager) this.parentActivity.getSystemService("window")).updateViewLayout(this.windowView, this.windowLayoutParams);
        } catch (Exception e) {
            FileLog.e(e);
        }
        this.windowView.setFocusable(true);
        this.containerView.setFocusable(true);
    }

    public void injectVideoPlayerToMediaController() {
        if (this.videoPlayer.isPlaying()) {
            if (this.playerLooping) {
                this.videoPlayer.setLooping(false);
            }
            MediaController.getInstance().injectVideoPlayer(this.videoPlayer, this.currentMessageObject);
            this.videoPlayer = null;
        }
    }

    public void closePhoto(boolean z, boolean z2) {
        AnimatedFileDrawable animatedFileDrawable;
        RectF drawRegion;
        float fMin;
        float measuredHeight;
        AnimatedFileDrawable animation;
        Bitmap animatedBitmap;
        int i;
        int i2;
        if (!z2 && (i2 = this.currentEditMode) != 0) {
            if (i2 == 3 && this.photoPaintView != null) {
                closePaintMode();
                return;
            }
            if (i2 == 1) {
                this.cropTransform.setViewTransform(this.previousHasTransform, this.previousCropPx, this.previousCropPy, this.previousCropRotation, this.previousCropOrientation, this.previousCropScale, 1.0f, 1.0f, this.previousCropPw, this.previousCropPh, 0.0f, 0.0f, this.previousCropMirrored);
            }
            switchToEditMode(0);
            return;
        }
        QualityChooseView qualityChooseView = this.qualityChooseView;
        if (qualityChooseView != null && qualityChooseView.getTag() != null) {
            this.qualityPicker.cancelButton.callOnClick();
            return;
        }
        this.openedFullScreenVideo = false;
        try {
            AlertDialog alertDialog = this.visibleDialog;
            if (alertDialog != null) {
                alertDialog.dismiss();
                this.visibleDialog = null;
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
        if (Build.VERSION.SDK_INT >= 21 && this.containerView != null) {
            AndroidUtilities.cancelRunOnUIThread(this.updateContainerFlagsRunnable);
            updateContainerFlags(true);
        }
        int i3 = this.currentEditMode;
        if (i3 != 0) {
            if (i3 == 2) {
                this.photoFilterView.shutdown();
                this.containerView.removeView(this.photoFilterView);
                this.photoFilterView = null;
            } else if (i3 == 1) {
                this.editorDoneLayout.setVisibility(8);
                this.photoCropView.setVisibility(8);
            } else if (i3 == 3) {
                this.photoPaintView.shutdown();
                this.containerView.removeView(this.photoPaintView);
                this.photoPaintView = null;
                this.savedState = null;
            }
            this.currentEditMode = 0;
        }
        if (this.parentActivity != null) {
            if ((!this.isInline && !this.isVisible) || checkAnimation() || this.placeProvider == null) {
                return;
            }
            if (!this.captionEditText.hideActionMode() || z2) {
                Activity activity = this.parentActivity;
                if (activity != null && this.fullscreenedByButton != 0) {
                    activity.setRequestedOrientation(this.prevOrientation);
                    this.fullscreenedByButton = 0;
                    this.wasRotated = false;
                }
                if (!this.doneButtonPressed && !this.imagesArrLocals.isEmpty() && (i = this.currentIndex) >= 0 && i < this.imagesArrLocals.size()) {
                    Object obj = this.imagesArrLocals.get(this.currentIndex);
                    if (obj instanceof MediaController.MediaEditState) {
                        ((MediaController.MediaEditState) obj).editedInfo = getCurrentVideoEditedInfo();
                    }
                }
                final PlaceProviderObject placeForPhoto = this.placeProvider.getPlaceForPhoto(this.currentMessageObject, getFileLocation(this.currentFileLocation), this.currentIndex, true);
                if (this.videoPlayer != null && placeForPhoto != null && (animation = placeForPhoto.imageReceiver.getAnimation()) != null) {
                    if (this.textureUploaded && (animatedBitmap = animation.getAnimatedBitmap()) != null) {
                        try {
                            Bitmap bitmap = this.videoTextureView.getBitmap(animatedBitmap.getWidth(), animatedBitmap.getHeight());
                            new Canvas(animatedBitmap).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
                            bitmap.recycle();
                        } catch (Throwable th) {
                            FileLog.e(th);
                        }
                    }
                    if (this.currentMessageObject != null) {
                        long startTime = animation.getStartTime();
                        long currentPosition = this.videoPlayer.getCurrentPosition();
                        if (startTime <= 0) {
                            startTime = 0;
                        }
                        animation.seekTo(currentPosition + startTime, !FileLoader.getInstance(this.currentMessageObject.currentAccount).isLoadingVideo(this.currentMessageObject.getDocument(), true));
                    }
                    placeForPhoto.imageReceiver.setAllowStartAnimation(true);
                    placeForPhoto.imageReceiver.startAnimation();
                }
                if (!this.doneButtonPressed) {
                    releasePlayer(true);
                }
                this.captionEditText.onDestroy();
                ChatActivity chatActivity = this.parentChatActivity;
                if (chatActivity != null && chatActivity.getFragmentView() != null) {
                    this.parentChatActivity.getFragmentView().invalidate();
                }
                this.parentChatActivity = null;
                removeObservers();
                this.isActionBarVisible = false;
                VelocityTracker velocityTracker = this.velocityTracker;
                if (velocityTracker != null) {
                    velocityTracker.recycle();
                    this.velocityTracker = null;
                }
                if (this.isInline) {
                    this.isInline = false;
                    this.animationInProgress = 0;
                    onPhotoClosed(placeForPhoto);
                    this.containerView.setScaleX(1.0f);
                    this.containerView.setScaleY(1.0f);
                    return;
                }
                if (z) {
                    ClippingImageView[] animatingImageViews = getAnimatingImageViews(placeForPhoto);
                    for (int i4 = 0; i4 < animatingImageViews.length; i4++) {
                        animatingImageViews[i4].setAnimationValues(this.animationValues);
                        animatingImageViews[i4].setVisibility(0);
                    }
                    this.animationInProgress = 3;
                    this.containerView.invalidate();
                    AnimatorSet animatorSet = new AnimatorSet();
                    ViewGroup.LayoutParams layoutParams = this.animatingImageView.getLayoutParams();
                    if (placeForPhoto != null) {
                        drawRegion = placeForPhoto.imageReceiver.getDrawRegion();
                        layoutParams.width = (int) drawRegion.width();
                        layoutParams.height = (int) drawRegion.height();
                        int orientation = placeForPhoto.imageReceiver.getOrientation();
                        int animatedOrientation = placeForPhoto.imageReceiver.getAnimatedOrientation();
                        if (animatedOrientation != 0) {
                            orientation = animatedOrientation;
                        }
                        for (int i5 = 0; i5 < animatingImageViews.length; i5++) {
                            animatingImageViews[i5].setOrientation(orientation);
                            animatingImageViews[i5].setImageBitmap(placeForPhoto.thumb);
                        }
                    } else {
                        layoutParams.width = (int) this.centerImage.getImageWidth();
                        layoutParams.height = (int) this.centerImage.getImageHeight();
                        for (int i6 = 0; i6 < animatingImageViews.length; i6++) {
                            animatingImageViews[i6].setOrientation(this.centerImage.getOrientation());
                            animatingImageViews[i6].setImageBitmap(this.centerImage.getBitmapSafe());
                        }
                        drawRegion = null;
                    }
                    if (layoutParams.width <= 0) {
                        layoutParams.width = 100;
                    }
                    if (layoutParams.height <= 0) {
                        layoutParams.height = 100;
                    }
                    if (this.sendPhotoType == 1) {
                        float fMin2 = Math.min(this.photoCropView.getMeasuredWidth(), (this.photoCropView.getMeasuredHeight() - AndroidUtilities.dp(64.0f)) - (isStatusBarVisible() ? AndroidUtilities.statusBarHeight : 0)) - (AndroidUtilities.dp(16.0f) * 2);
                        fMin = Math.max(fMin2 / layoutParams.width, fMin2 / layoutParams.height);
                    } else {
                        fMin = Math.min(this.windowView.getMeasuredWidth() / layoutParams.width, (AndroidUtilities.displaySize.y + (isStatusBarVisible() ? AndroidUtilities.statusBarHeight : 0)) / layoutParams.height);
                    }
                    float f = layoutParams.width;
                    float f2 = this.scale;
                    float f3 = layoutParams.height * f2 * fMin;
                    float measuredWidth = (this.windowView.getMeasuredWidth() - ((f * f2) * fMin)) / 2.0f;
                    if (this.sendPhotoType == 1) {
                        measuredHeight = this.photoCropView.getMeasuredHeight() - (isStatusBarVisible() ? AndroidUtilities.statusBarHeight : 0);
                    } else {
                        measuredHeight = AndroidUtilities.displaySize.y + (isStatusBarVisible() ? AndroidUtilities.statusBarHeight : 0);
                    }
                    float f4 = (measuredHeight - f3) / 2.0f;
                    for (int i7 = 0; i7 < animatingImageViews.length; i7++) {
                        animatingImageViews[i7].setLayoutParams(layoutParams);
                        animatingImageViews[i7].setTranslationX(this.translationX + measuredWidth);
                        animatingImageViews[i7].setTranslationY(this.translationY + f4);
                        animatingImageViews[i7].setScaleX(this.scale * fMin);
                        animatingImageViews[i7].setScaleY(this.scale * fMin);
                    }
                    if (placeForPhoto != null) {
                        placeForPhoto.imageReceiver.setVisible(false, true);
                        int iAbs = (int) Math.abs(drawRegion.left - placeForPhoto.imageReceiver.getImageX());
                        int iAbs2 = (int) Math.abs(drawRegion.top - placeForPhoto.imageReceiver.getImageY());
                        if (this.pageBlocksAdapter != null && placeForPhoto.imageReceiver.isAspectFit()) {
                            iAbs = 0;
                        }
                        int[] iArr = new int[2];
                        placeForPhoto.parentView.getLocationInWindow(iArr);
                        int i8 = iArr[1];
                        int i9 = Build.VERSION.SDK_INT;
                        float f5 = i8 - (i9 >= 21 ? 0 : AndroidUtilities.statusBarHeight);
                        int i10 = placeForPhoto.viewY;
                        float f6 = drawRegion.top;
                        int i11 = (int) ((f5 - (i10 + f6)) + placeForPhoto.clipTopAddition);
                        if (i11 < 0) {
                            i11 = 0;
                        }
                        int height = (int) ((((i10 + f6) + (drawRegion.bottom - f6)) - ((iArr[1] + placeForPhoto.parentView.getHeight()) - (i9 >= 21 ? 0 : AndroidUtilities.statusBarHeight))) + placeForPhoto.clipBottomAddition);
                        if (height < 0) {
                            height = 0;
                        }
                        int iMax = Math.max(i11, iAbs2);
                        int iMax2 = Math.max(height, iAbs2);
                        this.animationValues[0][0] = this.animatingImageView.getScaleX();
                        this.animationValues[0][1] = this.animatingImageView.getScaleY();
                        this.animationValues[0][2] = this.animatingImageView.getTranslationX();
                        this.animationValues[0][3] = this.animatingImageView.getTranslationY();
                        float[][] fArr = this.animationValues;
                        fArr[0][4] = 0.0f;
                        fArr[0][5] = 0.0f;
                        fArr[0][6] = 0.0f;
                        fArr[0][7] = 0.0f;
                        fArr[0][8] = 0.0f;
                        fArr[0][9] = 0.0f;
                        fArr[0][10] = 0.0f;
                        fArr[0][11] = 0.0f;
                        fArr[0][12] = 0.0f;
                        float[] fArr2 = fArr[1];
                        float f7 = placeForPhoto.scale;
                        fArr2[0] = f7;
                        fArr[1][1] = f7;
                        fArr[1][2] = placeForPhoto.viewX + (drawRegion.left * f7);
                        fArr[1][3] = placeForPhoto.viewY + (drawRegion.top * f7);
                        float f8 = iAbs;
                        fArr[1][4] = f8 * f7;
                        fArr[1][5] = iMax * f7;
                        fArr[1][6] = iMax2 * f7;
                        int i12 = 0;
                        for (int i13 = 4; i12 < i13; i13 = 4) {
                            this.animationValues[1][i12 + 7] = placeForPhoto.radius != null ? r8[i12] : 0.0f;
                            i12++;
                        }
                        float[][] fArr3 = this.animationValues;
                        float[] fArr4 = fArr3[1];
                        float f9 = placeForPhoto.scale;
                        fArr4[11] = iAbs2 * f9;
                        fArr3[1][12] = f8 * f9;
                        ArrayList arrayList = new ArrayList((this.sendPhotoType == 1 ? 3 : 2) + animatingImageViews.length + (animatingImageViews.length > 1 ? 1 : 0));
                        for (ClippingImageView clippingImageView : animatingImageViews) {
                            arrayList.add(ObjectAnimator.ofFloat(clippingImageView, AnimationProperties.CLIPPING_IMAGE_VIEW_PROGRESS, 0.0f, 1.0f));
                        }
                        if (animatingImageViews.length > 1) {
                            arrayList.add(ObjectAnimator.ofFloat(this.animatingImageView, (Property<ClippingImageView, Float>) View.ALPHA, 0.0f));
                            animatingImageViews[1].setAdditionalTranslationX(-getLeftInset());
                        }
                        arrayList.add(ObjectAnimator.ofInt(this.backgroundDrawable, (Property<BackgroundDrawable, Integer>) AnimationProperties.COLOR_DRAWABLE_ALPHA, 0));
                        arrayList.add(ObjectAnimator.ofFloat(this.containerView, (Property<FrameLayoutDrawer, Float>) View.ALPHA, 0.0f));
                        if (this.sendPhotoType == 1) {
                            arrayList.add(ObjectAnimator.ofFloat(this.photoCropView, (Property<PhotoCropView, Float>) View.ALPHA, 0.0f));
                        }
                        animatorSet.playTogether(arrayList);
                    } else {
                        int i14 = AndroidUtilities.displaySize.y + (isStatusBarVisible() ? AndroidUtilities.statusBarHeight : 0);
                        Animator[] animatorArr = new Animator[4];
                        animatorArr[0] = ObjectAnimator.ofInt(this.backgroundDrawable, (Property<BackgroundDrawable, Integer>) AnimationProperties.COLOR_DRAWABLE_ALPHA, 0);
                        animatorArr[1] = ObjectAnimator.ofFloat(this.animatingImageView, (Property<ClippingImageView, Float>) View.ALPHA, 0.0f);
                        ClippingImageView clippingImageView2 = this.animatingImageView;
                        Property property = View.TRANSLATION_Y;
                        float[] fArr5 = new float[1];
                        if (this.translationY < 0.0f) {
                            i14 = -i14;
                        }
                        fArr5[0] = i14;
                        animatorArr[2] = ObjectAnimator.ofFloat(clippingImageView2, (Property<ClippingImageView, Float>) property, fArr5);
                        animatorArr[3] = ObjectAnimator.ofFloat(this.containerView, (Property<FrameLayoutDrawer, Float>) View.ALPHA, 0.0f);
                        animatorSet.playTogether(animatorArr);
                    }
                    this.animationEndRunnable = new Runnable() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda58
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$closePhoto$61(placeForPhoto);
                        }
                    };
                    animatorSet.setDuration(200L);
                    animatorSet.addListener(new AnonymousClass61());
                    this.transitionAnimationStartTime = System.currentTimeMillis();
                    if (Build.VERSION.SDK_INT >= 18) {
                        this.containerView.setLayerType(2, null);
                    }
                    animatorSet.start();
                    animatedFileDrawable = null;
                } else {
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    animatorSet2.playTogether(ObjectAnimator.ofFloat(this.containerView, (Property<FrameLayoutDrawer, Float>) View.SCALE_X, 0.9f), ObjectAnimator.ofFloat(this.containerView, (Property<FrameLayoutDrawer, Float>) View.SCALE_Y, 0.9f), ObjectAnimator.ofInt(this.backgroundDrawable, (Property<BackgroundDrawable, Integer>) AnimationProperties.COLOR_DRAWABLE_ALPHA, 0), ObjectAnimator.ofFloat(this.containerView, (Property<FrameLayoutDrawer, Float>) View.ALPHA, 0.0f));
                    this.animationInProgress = 2;
                    this.animationEndRunnable = new Runnable() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda56
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$closePhoto$62(placeForPhoto);
                        }
                    };
                    animatorSet2.setDuration(200L);
                    animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.PhotoViewer.62
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            if (PhotoViewer.this.animationEndRunnable != null) {
                                ChatActivity chatActivity2 = PhotoViewer.this.parentChatActivity;
                                if (chatActivity2 == null && PhotoViewer.this.parentAlert != null) {
                                    BaseFragment baseFragment = PhotoViewer.this.parentAlert.getBaseFragment();
                                    if (baseFragment instanceof ChatActivity) {
                                        chatActivity2 = (ChatActivity) baseFragment;
                                    }
                                }
                                if (chatActivity2 != null) {
                                    chatActivity2.lambda$openDiscussionMessageChat$229(PhotoViewer.this.animationEndRunnable);
                                } else {
                                    PhotoViewer.this.animationEndRunnable.run();
                                    PhotoViewer.this.animationEndRunnable = null;
                                }
                            }
                        }
                    });
                    this.transitionAnimationStartTime = System.currentTimeMillis();
                    if (Build.VERSION.SDK_INT >= 18) {
                        animatedFileDrawable = null;
                        this.containerView.setLayerType(2, null);
                    } else {
                        animatedFileDrawable = null;
                    }
                    animatorSet2.start();
                }
                AnimatedFileDrawable animatedFileDrawable2 = this.currentAnimation;
                if (animatedFileDrawable2 != null) {
                    animatedFileDrawable2.removeSecondParentView(this.containerView);
                    this.currentAnimation = animatedFileDrawable;
                    this.centerImage.setImageBitmap(animatedFileDrawable);
                }
                PhotoViewerProvider photoViewerProvider = this.placeProvider;
                if (photoViewerProvider == null || photoViewerProvider.canScrollAway()) {
                    return;
                }
                this.placeProvider.cancelButtonPressed();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$closePhoto$61(PlaceProviderObject placeProviderObject) {
        this.animationEndRunnable = null;
        if (Build.VERSION.SDK_INT >= 18) {
            this.containerView.setLayerType(0, null);
        }
        this.animationInProgress = 0;
        onPhotoClosed(placeProviderObject);
    }

    /* renamed from: org.rbmain.ui.PhotoViewer$61, reason: invalid class name */
    class AnonymousClass61 extends AnimatorListenerAdapter {
        AnonymousClass61() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.PhotoViewer$61$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onAnimationEnd$0();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onAnimationEnd$0() {
            if (PhotoViewer.this.animationEndRunnable != null) {
                PhotoViewer.this.animationEndRunnable.run();
                PhotoViewer.this.animationEndRunnable = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$closePhoto$62(PlaceProviderObject placeProviderObject) {
        this.animationEndRunnable = null;
        FrameLayoutDrawer frameLayoutDrawer = this.containerView;
        if (frameLayoutDrawer == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 18) {
            frameLayoutDrawer.setLayerType(0, null);
        }
        this.animationInProgress = 0;
        onPhotoClosed(placeProviderObject);
        this.containerView.setScaleX(1.0f);
        this.containerView.setScaleY(1.0f);
    }

    private ClippingImageView[] getAnimatingImageViews(PlaceProviderObject placeProviderObject) {
        int i = (AndroidUtilities.isTablet() || placeProviderObject == null || placeProviderObject.animatingImageView == null) ? 0 : 1;
        ClippingImageView[] clippingImageViewArr = new ClippingImageView[i + 1];
        clippingImageViewArr[0] = this.animatingImageView;
        if (i != 0) {
            ClippingImageView clippingImageView = placeProviderObject.animatingImageView;
            clippingImageViewArr[1] = clippingImageView;
            clippingImageView.setAdditionalTranslationY(placeProviderObject.animatingImageViewYOffset);
        }
        return clippingImageViewArr;
    }

    private void removeObservers() {
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.fileDidFailToLoad);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.fileDidLoad);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.FileLoadProgressChanged);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.mediaCountDidLoad);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.mediaDidLoad);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.dialogPhotosLoaded);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.messagesDeleted);
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.emojiDidLoad);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.filePreparingFailed);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.fileNewChunkAvailable);
        ConnectionsManager.getInstance(this.currentAccount).cancelRequestsForGuid(this.classGuid);
    }

    public void destroyPhotoViewer() {
        if (this.parentActivity == null || this.windowView == null) {
            return;
        }
        PipVideoView pipVideoView = this.pipVideoView;
        if (pipVideoView != null) {
            pipVideoView.close();
            this.pipVideoView = null;
        }
        removeObservers();
        releasePlayer(false);
        try {
            if (this.windowView.getParent() != null) {
                ((WindowManager) this.parentActivity.getSystemService("window")).removeViewImmediate(this.windowView);
            }
            this.windowView = null;
        } catch (Exception e) {
            FileLog.e(e);
        }
        ImageReceiver.BitmapHolder bitmapHolder = this.currentThumb;
        if (bitmapHolder != null) {
            bitmapHolder.release();
            this.currentThumb = null;
        }
        this.animatingImageView.setImageBitmap(null);
        PhotoViewerCaptionEnterView photoViewerCaptionEnterView = this.captionEditText;
        if (photoViewerCaptionEnterView != null) {
            photoViewerCaptionEnterView.onDestroy();
        }
        if (this == PipInstance) {
            PipInstance = null;
        } else {
            Instance = null;
        }
    }

    private void onPhotoClosed(final PlaceProviderObject placeProviderObject) {
        if (this.doneButtonPressed) {
            releasePlayer(true);
        }
        this.isVisible = false;
        this.cropInitied = false;
        this.disableShowCheck = true;
        this.currentMessageObject = null;
        this.currentBotInlineResult = null;
        this.currentFileLocation = null;
        this.currentFileLocationVideo = null;
        this.currentSecureDocument = null;
        this.currentPageBlock = null;
        this.currentPathObject = null;
        if (this.videoPlayerControlFrameLayout != null) {
            setVideoPlayerControlVisible(false, false);
        }
        CaptionScrollView captionScrollView = this.captionScrollView;
        if (captionScrollView != null) {
            captionScrollView.reset();
        }
        this.sendPhotoType = 0;
        this.isDocumentsPicker = false;
        ImageReceiver.BitmapHolder bitmapHolder = this.currentThumb;
        if (bitmapHolder != null) {
            bitmapHolder.release();
            this.currentThumb = null;
        }
        this.parentAlert = null;
        AnimatedFileDrawable animatedFileDrawable = this.currentAnimation;
        if (animatedFileDrawable != null) {
            animatedFileDrawable.removeSecondParentView(this.containerView);
            this.currentAnimation = null;
        }
        for (int i = 0; i < 3; i++) {
            PhotoProgressView[] photoProgressViewArr = this.photoProgressViews;
            if (photoProgressViewArr[i] != null) {
                photoProgressViewArr[i].setBackgroundState(-1, false, true);
            }
        }
        requestVideoPreview(0);
        VideoTimelinePlayView videoTimelinePlayView = this.videoTimelineView;
        if (videoTimelinePlayView != null) {
            videoTimelinePlayView.setBackgroundColor(2130706432);
            this.videoTimelineView.destroy();
        }
        this.hintView.hide(false, 0);
        this.centerImage.setImageBitmap((Bitmap) null);
        this.leftImage.setImageBitmap((Bitmap) null);
        this.rightImage.setImageBitmap((Bitmap) null);
        this.containerView.post(new Runnable() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda57
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onPhotoClosed$63(placeProviderObject);
            }
        });
        PhotoViewerProvider photoViewerProvider = this.placeProvider;
        if (photoViewerProvider != null) {
            photoViewerProvider.willHidePhotoViewer();
        }
        this.groupedPhotosListView.clear();
        this.placeProvider = null;
        this.selectedPhotosAdapter.notifyDataSetChanged();
        this.pageBlocksAdapter = null;
        this.disableShowCheck = false;
        this.videoCutStart = 0.0f;
        this.videoCutEnd = 1.0f;
        if (placeProviderObject != null) {
            placeProviderObject.imageReceiver.setVisible(true, true);
        }
        ChatActivity chatActivity = this.parentChatActivity;
        if (chatActivity != null) {
            chatActivity.getFragmentView().invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onPhotoClosed$63(PlaceProviderObject placeProviderObject) {
        ClippingImageView clippingImageView;
        this.animatingImageView.setImageBitmap(null);
        if (placeProviderObject != null && !AndroidUtilities.isTablet() && (clippingImageView = placeProviderObject.animatingImageView) != null) {
            clippingImageView.setImageBitmap(null);
        }
        try {
            if (this.windowView.getParent() != null) {
                ((WindowManager) this.parentActivity.getSystemService("window")).removeView(this.windowView);
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    private void redraw(final int i) {
        FrameLayoutDrawer frameLayoutDrawer;
        if (i >= 6 || (frameLayoutDrawer = this.containerView) == null) {
            return;
        }
        frameLayoutDrawer.invalidate();
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda49
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$redraw$64(i);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$redraw$64(int i) {
        redraw(i + 1);
    }

    public void onResume() {
        redraw(0);
        VideoPlayer videoPlayer = this.videoPlayer;
        if (videoPlayer != null) {
            videoPlayer.seekTo(videoPlayer.getCurrentPosition() + 1);
            if (this.playerLooping) {
                this.videoPlayer.setLooping(true);
            }
        }
        PhotoPaintView photoPaintView = this.photoPaintView;
        if (photoPaintView != null) {
            photoPaintView.onResume();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        PipVideoView pipVideoView = this.pipVideoView;
        if (pipVideoView != null) {
            pipVideoView.onConfigurationChanged();
        }
    }

    public void onPause() throws IllegalAccessException, NoSuchFieldException, Resources.NotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException {
        if (this.currentAnimation != null) {
            closePhoto(false, false);
            return;
        }
        if (this.lastTitle != null) {
            closeCaptionEnter(true);
        }
        VideoPlayer videoPlayer = this.videoPlayer;
        if (videoPlayer != null && this.playerLooping) {
            videoPlayer.setLooping(false);
        }
        VideoPlayer videoPlayer2 = this.videoPlayer;
        if (videoPlayer2 != null) {
            videoPlayer2.pause();
        }
    }

    public boolean isVisible() {
        return this.isVisible && this.placeProvider != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMinMax(float f) {
        AspectRatioFrameLayout aspectRatioFrameLayout;
        if (this.currentEditMode == 3 && (aspectRatioFrameLayout = this.aspectRatioFrameLayout) != null && aspectRatioFrameLayout.getVisibility() == 0 && this.textureUploaded) {
            f *= Math.min(getContainerViewWidth() / this.videoTextureView.getMeasuredWidth(), getContainerViewHeight() / this.videoTextureView.getMeasuredHeight());
        }
        float imageWidth = this.centerImage.getImageWidth();
        float imageHeight = this.centerImage.getImageHeight();
        MediaController.CropState cropState = this.editState.cropState;
        if (cropState != null) {
            imageWidth *= cropState.cropPw;
            imageHeight *= cropState.cropPh;
        }
        int containerViewWidth = ((int) ((imageWidth * f) - getContainerViewWidth())) / 2;
        int containerViewHeight = ((int) ((imageHeight * f) - getContainerViewHeight())) / 2;
        if (containerViewWidth > 0) {
            this.minX = -containerViewWidth;
            this.maxX = containerViewWidth;
        } else {
            this.maxX = 0.0f;
            this.minX = 0.0f;
        }
        if (containerViewHeight > 0) {
            this.minY = -containerViewHeight;
            this.maxY = containerViewHeight;
        } else {
            this.maxY = 0.0f;
            this.minY = 0.0f;
        }
    }

    private int getAdditionX() {
        int i = this.currentEditMode;
        if (i == 1 || (i == 0 && this.sendPhotoType == 1)) {
            return AndroidUtilities.dp(16.0f);
        }
        if (i == 0 || i == 3) {
            return 0;
        }
        return AndroidUtilities.dp(14.0f);
    }

    private int getAdditionY() {
        int i = this.currentEditMode;
        if (i == 1 || (i == 0 && this.sendPhotoType == 1)) {
            return AndroidUtilities.dp(16.0f) + (isStatusBarVisible() ? AndroidUtilities.statusBarHeight : 0);
        }
        if (i == 3) {
            return AndroidUtilities.dp(8.0f) + (isStatusBarVisible() ? AndroidUtilities.statusBarHeight : 0);
        }
        if (i != 0) {
            return AndroidUtilities.dp(14.0f) + (isStatusBarVisible() ? AndroidUtilities.statusBarHeight : 0);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getContainerViewWidth() {
        return getContainerViewWidth(this.currentEditMode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getContainerViewWidth(int i) {
        int iDp;
        int width = this.containerView.getWidth();
        if (i == 1 || (i == 0 && this.sendPhotoType == 1)) {
            iDp = AndroidUtilities.dp(32.0f);
        } else {
            if (i == 0 || i == 3) {
                return width;
            }
            iDp = AndroidUtilities.dp(28.0f);
        }
        return width - iDp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getContainerViewHeight() {
        return getContainerViewHeight(this.currentEditMode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getContainerViewHeight(int i) {
        return getContainerViewHeight(false, i);
    }

    private int getContainerViewHeight(boolean z, int i) {
        int measuredHeight;
        int iDp;
        if (z || this.inBubbleMode) {
            measuredHeight = this.containerView.getMeasuredHeight();
        } else {
            measuredHeight = AndroidUtilities.displaySize.y;
            if (i == 0 && this.sendPhotoType != 1 && isStatusBarVisible()) {
                measuredHeight += AndroidUtilities.statusBarHeight;
            }
        }
        if ((i == 0 && this.sendPhotoType == 1) || i == 1) {
            iDp = AndroidUtilities.dp(144.0f);
        } else if (i == 2) {
            iDp = AndroidUtilities.dp(214.0f);
        } else {
            if (i != 3) {
                return measuredHeight;
            }
            iDp = AndroidUtilities.dp(48.0f) + ActionBar.getCurrentActionBarHeight();
        }
        return measuredHeight - iDp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x041b A[PHI: r4
      0x041b: PHI (r4v47 float) = (r4v42 float), (r4v43 float) binds: [B:214:0x0419, B:217:0x0421] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:221:0x042a A[PHI: r4
      0x042a: PHI (r4v46 float) = (r4v44 float), (r4v45 float) binds: [B:220:0x0428, B:223:0x0430] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:222:0x042c  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x044f A[PHI: r4
      0x044f: PHI (r4v28 float) = (r4v23 float), (r4v24 float) binds: [B:229:0x044d, B:232:0x0455] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0460 A[PHI: r4
      0x0460: PHI (r4v27 float) = (r4v25 float), (r4v26 float) binds: [B:235:0x045e, B:238:0x0466] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0462  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x053f A[PHI: r4
      0x053f: PHI (r4v14 float) = (r4v9 float), (r4v10 float) binds: [B:285:0x053d, B:288:0x0545] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0550 A[PHI: r4
      0x0550: PHI (r4v13 float) = (r4v11 float), (r4v12 float) binds: [B:291:0x054e, B:294:0x0556] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:293:0x0552  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r20) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException, android.content.res.Resources.NotFoundException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException {
        /*
            Method dump skipped, instructions count: 1663
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.PhotoViewer.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0022 A[PHI: r3
      0x0022: PHI (r3v4 float) = (r3v2 float), (r3v3 float) binds: [B:9:0x0020, B:12:0x0028] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0011 A[PHI: r3
      0x0011: PHI (r3v5 float) = (r3v0 float), (r3v1 float) binds: [B:3:0x000f, B:6:0x0017] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void checkMinMax(boolean r6) {
        /*
            r5 = this;
            float r0 = r5.translationX
            float r1 = r5.translationY
            float r2 = r5.scale
            r5.updateMinMax(r2)
            float r2 = r5.translationX
            float r3 = r5.minX
            int r4 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r4 >= 0) goto L13
        L11:
            r0 = r3
            goto L1a
        L13:
            float r3 = r5.maxX
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 <= 0) goto L1a
            goto L11
        L1a:
            float r2 = r5.translationY
            float r3 = r5.minY
            int r4 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r4 >= 0) goto L24
        L22:
            r1 = r3
            goto L2b
        L24:
            float r3 = r5.maxY
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 <= 0) goto L2b
            goto L22
        L2b:
            float r2 = r5.scale
            r5.animateTo(r2, r0, r1, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.PhotoViewer.checkMinMax(boolean):void");
    }

    private void goToNext() {
        float containerViewWidth = this.scale != 1.0f ? ((getContainerViewWidth() - this.centerImage.getImageWidth()) / 2.0f) * this.scale : 0.0f;
        this.switchImageAfterAnimation = 1;
        animateTo(this.scale, ((this.minX - getContainerViewWidth()) - containerViewWidth) - (AndroidUtilities.dp(30.0f) / 2), this.translationY, false);
    }

    private void goToPrev() {
        float containerViewWidth = this.scale != 1.0f ? ((getContainerViewWidth() - this.centerImage.getImageWidth()) / 2.0f) * this.scale : 0.0f;
        this.switchImageAfterAnimation = 2;
        animateTo(this.scale, this.maxX + getContainerViewWidth() + containerViewWidth + (AndroidUtilities.dp(30.0f) / 2), this.translationY, false);
    }

    private void cancelMoveZoomAnimation() {
        AnimatorSet animatorSet = this.imageMoveAnimation;
        if (animatorSet == null) {
            return;
        }
        float f = this.scale;
        float f2 = this.animateToScale - f;
        float f3 = this.animationValue;
        float f4 = f + (f2 * f3);
        float f5 = this.translationX;
        float f6 = f5 + ((this.animateToX - f5) * f3);
        float f7 = this.translationY;
        float f8 = f7 + ((this.animateToY - f7) * f3);
        animatorSet.cancel();
        this.scale = f4;
        this.translationX = f6;
        this.translationY = f8;
        this.animationStartTime = 0L;
        updateMinMax(f4);
        this.zoomAnimation = false;
        this.containerView.invalidate();
    }

    private void animateTo(float f, float f2, float f3, boolean z) {
        animateTo(f, f2, f3, z, 250);
    }

    private void animateTo(float f, float f2, float f3, boolean z, int i) {
        if (this.scale == f && this.translationX == f2 && this.translationY == f3) {
            return;
        }
        this.zoomAnimation = z;
        this.animateToScale = f;
        this.animateToX = f2;
        this.animateToY = f3;
        this.animationStartTime = System.currentTimeMillis();
        AnimatorSet animatorSet = new AnimatorSet();
        this.imageMoveAnimation = animatorSet;
        animatorSet.playTogether(ObjectAnimator.ofFloat(this, AnimationProperties.PHOTO_VIEWER_ANIMATION_VALUE, 0.0f, 1.0f));
        this.imageMoveAnimation.setInterpolator(this.interpolator);
        this.imageMoveAnimation.setDuration(i);
        this.imageMoveAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.PhotoViewer.64
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PhotoViewer.this.imageMoveAnimation = null;
                PhotoViewer.this.containerView.invalidate();
            }
        });
        this.imageMoveAnimation.start();
    }

    @Keep
    public void setAnimationValue(float f) {
        this.animationValue = f;
        this.containerView.invalidate();
    }

    @Keep
    public float getAnimationValue() {
        return this.animationValue;
    }

    private void switchToNextIndex(int i, boolean z) throws IllegalAccessException, NoSuchFieldException, Resources.NotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException {
        if (this.currentMessageObject != null) {
            releasePlayer(false);
            FileLoader.getInstance(this.currentAccount).cancelLoadFile(this.currentMessageObject.getDocument());
        } else if (this.currentPageBlock != null) {
            TLObject media = this.pageBlocksAdapter.getMedia(this.currentIndex);
            if (media instanceof TLRPC$Document) {
                releasePlayer(false);
                FileLoader.getInstance(this.currentAccount).cancelLoadFile((TLRPC$Document) media);
            }
        }
        GroupedPhotosListView groupedPhotosListView = this.groupedPhotosListView;
        if (groupedPhotosListView != null) {
            groupedPhotosListView.setAnimateBackground(true);
        }
        this.playerAutoStarted = false;
        setImageIndex(this.currentIndex + i, z, true);
        if (shouldMessageObjectAutoPlayed(this.currentMessageObject) || shouldIndexAutoPlayed(this.currentIndex)) {
            this.playerAutoStarted = true;
            onActionClick(true);
            checkProgress(0, false, true);
        }
        checkFullscreenButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean shouldMessageObjectAutoPlayed(MessageObject messageObject) {
        return messageObject != null && (messageObject.isVideo() || messageObject.isVideoFile()) && ((messageObject.mediaExists || messageObject.attachPathExists || (messageObject.canStreamVideo() && SharedConfig.streamMedia)) && SharedConfig.autoplayVideo);
    }

    private boolean shouldIndexAutoPlayed(int i) {
        File file;
        PageBlocksAdapter pageBlocksAdapter = this.pageBlocksAdapter;
        return pageBlocksAdapter != null && pageBlocksAdapter.isVideo(i) && SharedConfig.autoplayVideo && (file = this.pageBlocksAdapter.getFile(i)) != null && file.exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getCropFillScale(boolean z) {
        ImageReceiver imageReceiver = this.centerImage;
        int bitmapHeight = z ? imageReceiver.getBitmapHeight() : imageReceiver.getBitmapWidth();
        int bitmapWidth = z ? this.centerImage.getBitmapWidth() : this.centerImage.getBitmapHeight();
        float fMin = Math.min(this.photoCropView.getMeasuredWidth(), (this.photoCropView.getMeasuredHeight() - AndroidUtilities.dp(64.0f)) - (isStatusBarVisible() ? AndroidUtilities.statusBarHeight : 0)) - (AndroidUtilities.dp(16.0f) * 2);
        return Math.max(fMin / bitmapHeight, fMin / bitmapWidth);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isStatusBarVisible() {
        return Build.VERSION.SDK_INT >= 21 && !this.inBubbleMode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x04aa  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x04b0  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x04ce  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0504  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0539  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0540  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x05d2  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x05dd  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x05f5  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x0617  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x0630  */
    /* JADX WARN: Removed duplicated region for block: B:333:0x0668  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x066c  */
    /* JADX WARN: Removed duplicated region for block: B:342:0x0696  */
    /* JADX WARN: Removed duplicated region for block: B:345:0x06a0  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x0702  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x0717  */
    /* JADX WARN: Removed duplicated region for block: B:367:0x0721  */
    /* JADX WARN: Removed duplicated region for block: B:370:0x0732  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x075e  */
    /* JADX WARN: Removed duplicated region for block: B:389:0x0783  */
    /* JADX WARN: Removed duplicated region for block: B:391:0x0786  */
    /* JADX WARN: Removed duplicated region for block: B:394:0x0797  */
    /* JADX WARN: Removed duplicated region for block: B:397:0x07aa  */
    /* JADX WARN: Removed duplicated region for block: B:399:0x07b2  */
    /* JADX WARN: Removed duplicated region for block: B:401:0x07b7  */
    /* JADX WARN: Removed duplicated region for block: B:422:0x0835  */
    /* JADX WARN: Removed duplicated region for block: B:424:0x083f  */
    /* JADX WARN: Removed duplicated region for block: B:437:0x0877  */
    /* JADX WARN: Removed duplicated region for block: B:494:0x096f  */
    /* JADX WARN: Removed duplicated region for block: B:555:0x0b3c  */
    /* JADX WARN: Removed duplicated region for block: B:572:0x0928 A[EDGE_INSN: B:572:0x0928->B:464:0x0928 BREAK  A[LOOP:1: B:435:0x0872->B:463:0x0924], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onDraw(android.graphics.Canvas r40) {
        /*
            Method dump skipped, instructions count: 2965
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.PhotoViewer.onDraw(android.graphics.Canvas):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onDraw$65() throws IllegalAccessException, NoSuchFieldException, Resources.NotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException {
        switchToNextIndex(1, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onDraw$66() throws IllegalAccessException, NoSuchFieldException, Resources.NotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException {
        switchToNextIndex(-1, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x012d A[PHI: r1
      0x012d: PHI (r1v7 java.io.File) = 
      (r1v3 java.io.File)
      (r1v3 java.io.File)
      (r1v5 java.io.File)
      (r1v6 java.io.File)
      (r1v20 java.io.File)
      (r1v23 java.io.File)
     binds: [B:59:0x0199, B:61:0x019f, B:51:0x017f, B:46:0x0140, B:20:0x003c, B:22:0x004a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onActionClick(boolean r11) {
        /*
            Method dump skipped, instructions count: 700
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.PhotoViewer.onActionClick(boolean):void");
    }

    @Override // org.rbmain.ui.Components.GestureDetector2.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (!this.doubleTap && this.checkImageView.getVisibility() != 0) {
            boolean[] zArr = this.drawPressedDrawable;
            if (!zArr[0] && !zArr[1]) {
                float x = motionEvent.getX();
                if (x < Math.min(135, this.containerView.getMeasuredWidth() / 8)) {
                    if (this.leftImage.hasImageSet()) {
                        this.drawPressedDrawable[0] = true;
                        this.containerView.invalidate();
                    }
                } else if (x > this.containerView.getMeasuredWidth() - r0 && this.rightImage.hasImageSet()) {
                    this.drawPressedDrawable[1] = true;
                    this.containerView.invalidate();
                }
            }
        }
        return false;
    }

    @Override // org.rbmain.ui.Components.GestureDetector2.OnDoubleTapListener
    public boolean canDoubleTap(MotionEvent motionEvent) {
        MessageObject messageObject;
        if (this.checkImageView.getVisibility() == 0) {
            return true;
        }
        boolean[] zArr = this.drawPressedDrawable;
        if (zArr[0] || zArr[1]) {
            return true;
        }
        float x = motionEvent.getX();
        if ((x < Math.min(135, this.containerView.getMeasuredWidth() / 8) || x > this.containerView.getMeasuredWidth() - r3) && (messageObject = this.currentMessageObject) != null) {
            return messageObject.isVideo() && SystemClock.elapsedRealtime() - this.lastPhotoSetTime >= 500 && canDoubleTapSeekVideo(motionEvent);
        }
        return true;
    }

    private void hidePressedDrawables() {
        boolean[] zArr = this.drawPressedDrawable;
        zArr[1] = false;
        zArr[0] = false;
        this.containerView.invalidate();
    }

    @Override // org.rbmain.ui.Components.GestureDetector2.OnGestureListener
    public void onUp(MotionEvent motionEvent) {
        hidePressedDrawables();
    }

    @Override // org.rbmain.ui.Components.GestureDetector2.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (!this.canZoom && !this.doubleTapEnabled) {
            return onSingleTapConfirmed(motionEvent);
        }
        if (this.containerView.getTag() != null && this.photoProgressViews[0] != null && this.containerView != null) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if ((x < ((float) (getContainerViewWidth() - AndroidUtilities.dp(100.0f))) / 2.0f || x > ((float) (getContainerViewWidth() + AndroidUtilities.dp(100.0f))) / 2.0f || y < ((float) (getContainerViewHeight() - AndroidUtilities.dp(100.0f))) / 2.0f || y > ((float) (getContainerViewHeight() + AndroidUtilities.dp(100.0f))) / 2.0f) ? false : onSingleTapConfirmed(motionEvent)) {
                this.discardTap = true;
                return true;
            }
        }
        return false;
    }

    public void onLongPress() {
        boolean z;
        VideoPlayer videoPlayer = this.videoPlayer;
        if (videoPlayer == null || !this.videoPlayerControlVisible) {
            return;
        }
        long currentPosition = videoPlayer.getCurrentPosition();
        long duration = this.videoPlayer.getDuration();
        if (currentPosition == -9223372036854775807L || duration < 15000) {
            return;
        }
        float f = this.longPressX;
        int containerViewWidth = getContainerViewWidth() / 3;
        if (f >= containerViewWidth * 2) {
            z = true;
        } else if (f >= containerViewWidth) {
            return;
        } else {
            z = false;
        }
        this.rewindForward = z;
        cancelRewind();
        incrementRewindCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelRewind() {
        if (this.rewindCount != 0) {
            this.rewindCount = 0;
            VideoPlayer videoPlayer = this.videoPlayer;
            if (videoPlayer != null) {
                if (this.rewindByBackSeek) {
                    videoPlayer.seekTo(this.rewindBackSeekPlayerPosition);
                } else {
                    this.videoPlayer.seekTo(videoPlayer.getCurrentPosition());
                }
                this.videoPlayer.setPlaybackSpeed(1.0f);
            }
        }
        AndroidUtilities.cancelRunOnUIThread(this.backSeek);
        Runnable runnable = this.updateRewindRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
            this.updateRewindRunnable = null;
        }
        this.videoForwardDrawable.setShowing(false);
    }

    void incrementRewindCount() {
        boolean z;
        VideoPlayer videoPlayer = this.videoPlayer;
        if (videoPlayer == null) {
            return;
        }
        int i = this.rewindCount + 1;
        this.rewindCount = i;
        if (i == 1) {
            if (this.rewindForward && videoPlayer.isPlaying()) {
                this.rewindByBackSeek = false;
            } else {
                this.rewindByBackSeek = true;
            }
        }
        if (this.rewindForward && !this.rewindByBackSeek) {
            int i2 = this.rewindCount;
            if (i2 == 1) {
                this.videoPlayer.setPlaybackSpeed(4.0f);
            } else if (i2 == 2) {
                this.videoPlayer.setPlaybackSpeed(7.0f);
            } else {
                this.videoPlayer.setPlaybackSpeed(13.0f);
            }
        } else {
            int i3 = this.rewindCount;
            z = i3 == 1 || i3 == 2;
        }
        if (this.rewindCount == 1) {
            this.rewindBackSeekPlayerPosition = this.videoPlayer.getCurrentPosition();
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.rewindLastTime = jCurrentTimeMillis;
            this.rewindLastUpdatePlayerTime = jCurrentTimeMillis;
            this.startRewindFrom = this.videoPlayer.getCurrentPosition();
            this.videoForwardDrawable.setOneShootAnimation(false);
            this.videoForwardDrawable.setLeftSide(!this.rewindForward);
            this.videoForwardDrawable.setShowing(true);
            this.containerView.invalidate();
        }
        AndroidUtilities.cancelRunOnUIThread(this.backSeek);
        AndroidUtilities.runOnUIThread(this.backSeek);
        if (z) {
            Runnable runnable = this.updateRewindRunnable;
            if (runnable != null) {
                AndroidUtilities.cancelRunOnUIThread(runnable);
            }
            Runnable runnable2 = new Runnable() { // from class: org.rbmain.ui.PhotoViewer$$ExternalSyntheticLambda45
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$incrementRewindCount$67();
                }
            };
            this.updateRewindRunnable = runnable2;
            AndroidUtilities.runOnUIThread(runnable2, 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$incrementRewindCount$67() {
        this.updateRewindRunnable = null;
        incrementRewindCount();
    }

    @Override // org.rbmain.ui.Components.GestureDetector2.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.scale == 1.0f) {
            return false;
        }
        this.scroller.abortAnimation();
        this.scroller.fling(Math.round(this.translationX), Math.round(this.translationY), Math.round(f), Math.round(f2), (int) this.minX, (int) this.maxX, (int) this.minY, (int) this.maxY);
        this.containerView.postInvalidate();
        return false;
    }

    @Override // org.rbmain.ui.Components.GestureDetector2.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) throws IllegalAccessException, NoSuchFieldException, Resources.NotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException {
        MessageObject messageObject;
        if (this.discardTap) {
            return false;
        }
        float x = motionEvent.getX();
        if (this.checkImageView.getVisibility() != 0) {
            if (x < Math.min(135, this.containerView.getMeasuredWidth() / 8)) {
                if (this.leftImage.hasImageSet()) {
                    switchToNextIndex(-1, true);
                    return true;
                }
            } else if (x > this.containerView.getMeasuredWidth() - r2 && this.rightImage.hasImageSet()) {
                switchToNextIndex(1, true);
                return true;
            }
        }
        if (this.containerView.getTag() != null) {
            AspectRatioFrameLayout aspectRatioFrameLayout = this.aspectRatioFrameLayout;
            boolean z = aspectRatioFrameLayout != null && aspectRatioFrameLayout.getVisibility() == 0;
            float y = motionEvent.getY();
            if (this.sharedMediaType == 1 && (messageObject = this.currentMessageObject) != null) {
                if (!messageObject.canPreviewDocument()) {
                    float containerViewHeight = (getContainerViewHeight() - AndroidUtilities.dp(360.0f)) / 2.0f;
                    if (y >= containerViewHeight && y <= containerViewHeight + AndroidUtilities.dp(360.0f)) {
                        onActionClick(true);
                        return true;
                    }
                }
            } else {
                PhotoProgressView[] photoProgressViewArr = this.photoProgressViews;
                if (photoProgressViewArr[0] != null && this.containerView != null) {
                    int i = photoProgressViewArr[0].backgroundState;
                    if (x >= (getContainerViewWidth() - AndroidUtilities.dp(100.0f)) / 2.0f && x <= (getContainerViewWidth() + AndroidUtilities.dp(100.0f)) / 2.0f && y >= (getContainerViewHeight() - AndroidUtilities.dp(100.0f)) / 2.0f && y <= (getContainerViewHeight() + AndroidUtilities.dp(100.0f)) / 2.0f) {
                        if (z) {
                            if ((i == 3 || i == 4) && this.photoProgressViews[0].isVisible()) {
                                this.manuallyPaused = true;
                                toggleVideoPlayer();
                                return true;
                            }
                        } else if (i > 0 && i <= 3) {
                            onActionClick(true);
                            checkProgress(0, false, true);
                            return true;
                        }
                    }
                }
            }
            toggleActionBar(!this.isActionBarVisible, true);
        } else {
            int i2 = this.sendPhotoType;
            if (i2 == 0 || i2 == 4) {
                if (this.isCurrentVideo) {
                    VideoPlayer videoPlayer = this.videoPlayer;
                    if (videoPlayer != null && !this.muteVideo && i2 != 1) {
                        videoPlayer.setVolume(1.0f);
                    }
                    this.manuallyPaused = true;
                    toggleVideoPlayer();
                } else {
                    this.checkImageView.performClick();
                }
            } else {
                TLRPC$BotInlineResult tLRPC$BotInlineResult = this.currentBotInlineResult;
                if (tLRPC$BotInlineResult != null && (tLRPC$BotInlineResult.type.equals(MediaStreamTrack.VIDEO_TRACK_KIND) || MessageObject.isVideoDocument(this.currentBotInlineResult.document))) {
                    int i3 = this.photoProgressViews[0].backgroundState;
                    if (i3 > 0 && i3 <= 3) {
                        float y2 = motionEvent.getY();
                        if (x >= (getContainerViewWidth() - AndroidUtilities.dp(100.0f)) / 2.0f && x <= (getContainerViewWidth() + AndroidUtilities.dp(100.0f)) / 2.0f && y2 >= (getContainerViewHeight() - AndroidUtilities.dp(100.0f)) / 2.0f && y2 <= (getContainerViewHeight() + AndroidUtilities.dp(100.0f)) / 2.0f) {
                            onActionClick(true);
                            checkProgress(0, false, true);
                            return true;
                        }
                    }
                } else if (this.sendPhotoType == 2 && this.isCurrentVideo) {
                    this.manuallyPaused = true;
                    toggleVideoPlayer();
                }
            }
        }
        return true;
    }

    private boolean canDoubleTapSeekVideo(MotionEvent motionEvent) {
        if (this.videoPlayer == null) {
            return false;
        }
        boolean z = motionEvent.getX() >= ((float) ((getContainerViewWidth() / 3) * 2));
        long currentPosition = this.videoPlayer.getCurrentPosition();
        long duration = this.videoPlayer.getDuration();
        if (currentPosition == -9223372036854775807L || duration <= 15000) {
            return false;
        }
        return !z || duration - currentPosition > 10000;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00fe A[PHI: r3
      0x00fe: PHI (r3v18 float) = (r3v13 float), (r3v14 float) binds: [B:50:0x00fc, B:53:0x0104] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x010d A[PHI: r3
      0x010d: PHI (r3v17 float) = (r3v15 float), (r3v16 float) binds: [B:56:0x010b, B:59:0x0113] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x010f  */
    @Override // org.rbmain.ui.Components.GestureDetector2.OnDoubleTapListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onDoubleTap(android.view.MotionEvent r17) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.PhotoViewer.onDoubleTap(android.view.MotionEvent):boolean");
    }

    private boolean enableSwipeToPiP() {
        VideoPlayer videoPlayer;
        if (BuildVars.DEBUG_PRIVATE_VERSION) {
            return this.pipAvailable && this.textureUploaded && (videoPlayer = this.videoPlayer) != null && videoPlayer.getRepeatCount() == 0 && (Build.VERSION.SDK_INT < 23 || Settings.canDrawOverlays(this.parentActivity)) && !this.changingTextureView && !this.switchingInlineMode && !this.isInline;
        }
        return false;
    }

    private class QualityChooseView extends View {
        private int circleSize;
        private int gapSize;
        private String hightQualityDescription;
        private int lineSize;
        private String lowQualityDescription;
        private Paint paint;
        private int sideSide;
        private int startMovingQuality;
        private TextPaint textPaint;

        public QualityChooseView(Context context) {
            super(context);
            this.paint = new Paint(1);
            TextPaint textPaint = new TextPaint(1);
            this.textPaint = textPaint;
            textPaint.setTextSize(AndroidUtilities.dp(14.0f));
            this.textPaint.setColor(-3289651);
            this.lowQualityDescription = LocaleController.getString("AccDescrVideoCompressLow", R.string.AccDescrVideoCompressLow);
            this.hightQualityDescription = LocaleController.getString("AccDescrVideoCompressHigh", R.string.AccDescrVideoCompressHigh);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            float x = motionEvent.getX();
            if (motionEvent.getAction() == 0) {
                this.startMovingQuality = PhotoViewer.this.selectedCompression;
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
                int i = 0;
                while (true) {
                    if (i >= PhotoViewer.this.compressionsCount) {
                        break;
                    }
                    int i2 = this.sideSide;
                    int i3 = this.lineSize;
                    int i4 = this.gapSize;
                    int i5 = this.circleSize;
                    int i6 = i2 + (((i4 * 2) + i3 + i5) * i) + (i5 / 2);
                    int i7 = (i3 / 2) + (i5 / 2) + i4;
                    if (x <= i6 - i7 || x >= i6 + i7) {
                        i++;
                    } else if (PhotoViewer.this.selectedCompression != i) {
                        PhotoViewer.this.selectedCompression = i;
                        PhotoViewer.this.didChangedCompressionLevel(false);
                        invalidate();
                    }
                }
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                if (PhotoViewer.this.selectedCompression != this.startMovingQuality) {
                    PhotoViewer.this.requestVideoPreview(1);
                }
                PhotoViewer.this.moving = false;
            }
            return true;
        }

        @Override // android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            this.circleSize = AndroidUtilities.dp(8.0f);
            this.gapSize = AndroidUtilities.dp(2.0f);
            this.sideSide = AndroidUtilities.dp(18.0f);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            if (PhotoViewer.this.compressionsCount != 1) {
                this.lineSize = (((getMeasuredWidth() - (this.circleSize * PhotoViewer.this.compressionsCount)) - (this.gapSize * ((PhotoViewer.this.compressionsCount * 2) - 2))) - (this.sideSide * 2)) / (PhotoViewer.this.compressionsCount - 1);
            } else {
                this.lineSize = ((getMeasuredWidth() - (this.circleSize * PhotoViewer.this.compressionsCount)) - (this.gapSize * 2)) - (this.sideSide * 2);
            }
            int measuredHeight = (getMeasuredHeight() / 2) + AndroidUtilities.dp(6.0f);
            int i = 0;
            while (i < PhotoViewer.this.compressionsCount) {
                int i2 = this.sideSide;
                int i3 = this.lineSize + (this.gapSize * 2);
                int i4 = this.circleSize;
                int i5 = i2 + ((i3 + i4) * i) + (i4 / 2);
                if (i <= PhotoViewer.this.selectedCompression) {
                    this.paint.setColor(-11292945);
                } else {
                    this.paint.setColor(1728053247);
                }
                canvas.drawCircle(i5, measuredHeight, i == PhotoViewer.this.selectedCompression ? AndroidUtilities.dp(6.0f) : this.circleSize / 2, this.paint);
                if (i != 0) {
                    canvas.drawRect((i == PhotoViewer.this.selectedCompression + 1 ? AndroidUtilities.dpf2(2.0f) : 0.0f) + (((i5 - (this.circleSize / 2)) - this.gapSize) - this.lineSize), measuredHeight - AndroidUtilities.dp(1.0f), (r0 + this.lineSize) - (i == PhotoViewer.this.selectedCompression ? AndroidUtilities.dpf2(2.0f) : 0.0f), AndroidUtilities.dp(2.0f) + measuredHeight, this.paint);
                }
                i++;
            }
            canvas.drawText(this.lowQualityDescription, this.sideSide, measuredHeight - AndroidUtilities.dp(16.0f), this.textPaint);
            canvas.drawText(this.hightQualityDescription, (getMeasuredWidth() - this.sideSide) - this.textPaint.measureText(this.hightQualityDescription), measuredHeight - AndroidUtilities.dp(16.0f), this.textPaint);
        }
    }

    public void updateMuteButton() {
        VideoPlayer videoPlayer = this.videoPlayer;
        if (videoPlayer != null) {
            videoPlayer.setMute(this.muteVideo);
        }
        if (!this.videoConvertSupported) {
            this.muteItem.setEnabled(false);
            this.muteItem.setClickable(false);
            this.muteItem.animate().alpha(0.5f).setDuration(180L).start();
            this.videoTimelineView.setMode(0);
            return;
        }
        this.muteItem.setEnabled(true);
        this.muteItem.setClickable(true);
        this.muteItem.animate().alpha(1.0f).setDuration(180L).start();
        if (this.muteVideo) {
            this.actionBar.setSubtitle(LocaleController.getString("SoundMuted", R.string.SoundMuted));
            this.muteItem.setImageResource(R.drawable.video_send_mute);
            if (this.compressItem.getTag() != null) {
                this.compressItem.setAlpha(0.5f);
                this.compressItem.setEnabled(false);
            }
            if (this.sendPhotoType == 1) {
                this.videoTimelineView.setMaxProgressDiff(9600.0f / this.videoDuration);
                this.videoTimelineView.setMode(1);
                updateVideoInfo();
            } else {
                this.videoTimelineView.setMaxProgressDiff(1.0f);
                this.videoTimelineView.setMode(0);
            }
            this.muteItem.setContentDescription(LocaleController.getString("NoSound", R.string.NoSound));
            return;
        }
        this.actionBar.setSubtitle(this.currentSubtitle);
        this.muteItem.setImageResource(R.drawable.video_send_unmute);
        this.muteItem.setContentDescription(LocaleController.getString("Sound", R.string.Sound));
        if (this.compressItem.getTag() != null) {
            this.compressItem.setAlpha(1.0f);
            this.compressItem.setEnabled(true);
        }
        long j = this.limitedVideoTime;
        if (j > 0) {
            this.videoTimelineView.setMaxProgressDiff(j / this.videoDuration);
        } else {
            this.videoTimelineView.setMaxProgressDiff(1.0f);
        }
        this.videoTimelineView.setMode(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void didChangedCompressionLevel(boolean z) {
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putInt(String.format("compress_video_%d", Integer.valueOf(this.compressionsCount)), this.selectedCompression);
        editorEdit.apply();
        updateWidthHeightBitrateForCompression();
        updateVideoInfo();
        if (z) {
            requestVideoPreview(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateVideoInfo() {
        int i;
        int i2;
        ActionBar actionBar = this.actionBar;
        if (actionBar == null) {
            return;
        }
        if (this.compressionsCount == 0) {
            actionBar.setSubtitle(null);
            return;
        }
        int i3 = this.selectedCompression;
        if (i3 < 2) {
            this.compressItem.setImageResource(R.drawable.video_quality1);
        } else if (i3 == 2) {
            this.compressItem.setImageResource(R.drawable.video_quality2);
        } else if (i3 == 3) {
            this.compressItem.setImageResource(R.drawable.video_quality3);
        }
        this.itemsLayout.requestLayout();
        long jCeil = (long) Math.ceil((this.videoTimelineView.getRightProgress() - this.videoTimelineView.getLeftProgress()) * this.videoDuration);
        this.estimatedDuration = jCeil;
        if (this.muteVideo) {
            int i4 = this.rotationValue;
            i = (i4 == 90 || i4 == 270) ? this.resultHeight : this.resultWidth;
            i2 = (i4 == 90 || i4 == 270) ? this.resultWidth : this.resultHeight;
            long j = (long) (((this.sendPhotoType == 1 ? jCeil <= 2000 ? 2600000 : jCeil <= 5000 ? 2200000 : 1560000 : 921600) / 8) * (jCeil / 1000.0f));
            this.estimatedSize = j;
            this.estimatedSize = j + ((j / 32768) * 16);
        } else if (this.compressItem.getTag() == null) {
            int i5 = this.rotationValue;
            i = (i5 == 90 || i5 == 270) ? this.originalHeight : this.originalWidth;
            i2 = (i5 == 90 || i5 == 270) ? this.originalWidth : this.originalHeight;
            this.estimatedSize = (long) (this.originalSize * (this.estimatedDuration / this.videoDuration));
        } else {
            int i6 = this.rotationValue;
            i = (i6 == 90 || i6 == 270) ? this.resultHeight : this.resultWidth;
            i2 = (i6 == 90 || i6 == 270) ? this.resultWidth : this.resultHeight;
            long j2 = (long) (((this.sendPhotoType == 1 ? 0L : this.audioFramesSize) + this.videoFramesSize) * (this.estimatedDuration / this.videoDuration));
            this.estimatedSize = j2;
            this.estimatedSize = j2 + ((j2 / 32768) * 16);
        }
        this.videoCutStart = this.videoTimelineView.getLeftProgress();
        float rightProgress = this.videoTimelineView.getRightProgress();
        this.videoCutEnd = rightProgress;
        float f = this.videoCutStart;
        if (f == 0.0f) {
            this.startTime = -1L;
        } else {
            this.startTime = ((long) (f * this.videoDuration)) * 1000;
        }
        if (rightProgress == 1.0f) {
            this.endTime = -1L;
        } else {
            this.endTime = ((long) (rightProgress * this.videoDuration)) * 1000;
        }
        String string = String.format("%s, %s", String.format("%dx%d", Integer.valueOf(i), Integer.valueOf(i2)), String.format("%s, ~%s", AndroidUtilities.formatShortDuration((int) (this.estimatedDuration / 1000)), AndroidUtilities.formatFileSize(this.estimatedSize)));
        this.currentSubtitle = string;
        ActionBar actionBar2 = this.actionBar;
        if (this.muteVideo) {
            string = LocaleController.getString("SoundMuted", R.string.SoundMuted);
        }
        actionBar2.setSubtitle(string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestVideoPreview(int i) {
        if (this.videoPreviewMessageObject != null) {
            MediaController.getInstance().cancelVideoConvert(this.videoPreviewMessageObject);
        }
        boolean z = this.requestingPreview && !this.tryStartRequestPreviewOnFinish;
        this.requestingPreview = false;
        this.loadInitialVideo = false;
        this.progressView.setVisibility(4);
        if (i == 1) {
            if (this.resultHeight == this.originalHeight && this.resultWidth == this.originalWidth) {
                this.tryStartRequestPreviewOnFinish = false;
                PhotoProgressView[] photoProgressViewArr = this.photoProgressViews;
                photoProgressViewArr[0].setProgress(0.0f, photoProgressViewArr[0].backgroundState == 0 || this.photoProgressViews[0].previousBackgroundState == 0);
                this.photoProgressViews[0].setBackgroundState(3, false, true);
                if (!z) {
                    preparePlayer(this.currentPlayingVideoFile, false, false, this.editState.savedFilterState);
                    this.videoPlayer.seekTo((long) (this.videoTimelineView.getLeftProgress() * this.videoDuration));
                } else {
                    this.loadInitialVideo = true;
                }
            } else {
                releasePlayer(false);
                if (this.videoPreviewMessageObject == null) {
                    TLRPC$TL_message tLRPC$TL_message = new TLRPC$TL_message();
                    tLRPC$TL_message.id = 0L;
                    tLRPC$TL_message.message = BuildConfig.FLAVOR;
                    tLRPC$TL_message.media = new TLRPC$TL_messageMediaEmpty();
                    tLRPC$TL_message.action = new TLRPC$TL_messageActionEmpty();
                    tLRPC$TL_message.dialog_id = this.currentDialogId;
                    MessageObject messageObject = new MessageObject(UserConfig.selectedAccount, tLRPC$TL_message, false, false);
                    this.videoPreviewMessageObject = messageObject;
                    messageObject.messageOwner.attachPath = new File(FileLoader.getDirectory(4), "video_preview.mp4").getAbsolutePath();
                    this.videoPreviewMessageObject.videoEditedInfo = new VideoEditedInfo();
                    VideoEditedInfo videoEditedInfo = this.videoPreviewMessageObject.videoEditedInfo;
                    videoEditedInfo.rotationValue = this.rotationValue;
                    videoEditedInfo.originalWidth = this.originalWidth;
                    videoEditedInfo.originalHeight = this.originalHeight;
                    videoEditedInfo.framerate = this.videoFramerate;
                    videoEditedInfo.originalPath = this.currentPlayingVideoFile.getPath();
                }
                VideoEditedInfo videoEditedInfo2 = this.videoPreviewMessageObject.videoEditedInfo;
                long j = this.startTime;
                videoEditedInfo2.startTime = j;
                long j2 = this.endTime;
                videoEditedInfo2.endTime = j2;
                long j3 = j != -1 ? j : 0L;
                if (j2 == -1) {
                    j2 = (long) (this.videoDuration * 1000.0f);
                }
                if (j2 - j3 > 5000000) {
                    videoEditedInfo2.endTime = j3 + 5000000;
                }
                videoEditedInfo2.bitrate = this.bitrate;
                videoEditedInfo2.resultWidth = this.resultWidth;
                videoEditedInfo2.resultHeight = this.resultHeight;
                videoEditedInfo2.needUpdateProgress = true;
                videoEditedInfo2.originalDuration = (long) (this.videoDuration * 1000.0f);
                if (!MediaController.getInstance().scheduleVideoConvert(this.videoPreviewMessageObject, true)) {
                    this.tryStartRequestPreviewOnFinish = true;
                }
                this.requestingPreview = true;
                PhotoProgressView[] photoProgressViewArr2 = this.photoProgressViews;
                photoProgressViewArr2[0].setProgress(0.0f, photoProgressViewArr2[0].backgroundState == 0 || this.photoProgressViews[0].previousBackgroundState == 0);
                this.photoProgressViews[0].setBackgroundState(0, false, true);
            }
        } else {
            this.tryStartRequestPreviewOnFinish = false;
            this.photoProgressViews[0].setBackgroundState(3, false, true);
            if (i == 2) {
                preparePlayer(this.currentPlayingVideoFile, false, false, this.editState.savedFilterState);
                this.videoPlayer.seekTo((long) (this.videoTimelineView.getLeftProgress() * this.videoDuration));
            }
        }
        this.containerView.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateWidthHeightBitrateForCompression() {
        int i = this.compressionsCount;
        if (i <= 0) {
            return;
        }
        if (this.selectedCompression >= i) {
            this.selectedCompression = i - 1;
        }
        if (this.sendPhotoType == 1) {
            float fMax = Math.max(800.0f / this.originalWidth, 800.0f / this.originalHeight);
            this.resultWidth = Math.round((this.originalWidth * fMax) / 2.0f) * 2;
            this.resultHeight = Math.round((this.originalHeight * fMax) / 2.0f) * 2;
        } else {
            int i2 = this.selectedCompression;
            float f = i2 != 0 ? i2 != 1 ? i2 != 2 ? 1920.0f : 1280.0f : 854.0f : 480.0f;
            int i3 = this.originalWidth;
            int i4 = this.originalHeight;
            float f2 = f / (i3 > i4 ? i3 : i4);
            if (i2 == i - 1 && f2 >= 1.0f) {
                this.resultWidth = i3;
                this.resultHeight = i4;
            } else {
                this.resultWidth = Math.round((i3 * f2) / 2.0f) * 2;
                this.resultHeight = Math.round((this.originalHeight * f2) / 2.0f) * 2;
            }
        }
        if (this.bitrate != 0) {
            if (this.sendPhotoType == 1) {
                this.bitrate = 1560000;
            } else {
                int i5 = this.resultWidth;
                int i6 = this.originalWidth;
                if (i5 == i6 && this.resultHeight == this.originalHeight) {
                    this.bitrate = this.originalBitrate;
                } else {
                    this.bitrate = MediaController.makeVideoBitrate(this.originalHeight, i6, this.originalBitrate, this.resultHeight, i5);
                }
            }
            this.videoFramesSize = (long) (((this.bitrate / 8) * this.videoDuration) / 1000.0f);
        }
    }

    private void showQualityView(final boolean z) {
        if (z) {
            this.previousCompression = this.selectedCompression;
        }
        AnimatorSet animatorSet = this.qualityChooseViewAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.qualityChooseViewAnimation = new AnimatorSet();
        if (z) {
            this.qualityChooseView.setTag(1);
            this.qualityChooseViewAnimation.playTogether(ObjectAnimator.ofFloat(this.pickerView, (Property<FrameLayout, Float>) View.TRANSLATION_Y, 0.0f, AndroidUtilities.dp(152.0f)), ObjectAnimator.ofFloat(this.pickerViewSendButton, (Property<ImageView, Float>) View.TRANSLATION_Y, 0.0f, AndroidUtilities.dp(152.0f)), ObjectAnimator.ofFloat(this.bottomLayout, (Property<FrameLayout, Float>) View.TRANSLATION_Y, -AndroidUtilities.dp(48.0f), AndroidUtilities.dp(104.0f)));
        } else {
            this.qualityChooseView.setTag(null);
            this.qualityChooseViewAnimation.playTogether(ObjectAnimator.ofFloat(this.qualityChooseView, (Property<QualityChooseView, Float>) View.TRANSLATION_Y, 0.0f, AndroidUtilities.dp(166.0f)), ObjectAnimator.ofFloat(this.qualityPicker, (Property<PickerBottomLayoutViewer, Float>) View.TRANSLATION_Y, 0.0f, AndroidUtilities.dp(166.0f)), ObjectAnimator.ofFloat(this.bottomLayout, (Property<FrameLayout, Float>) View.TRANSLATION_Y, -AndroidUtilities.dp(48.0f), AndroidUtilities.dp(118.0f)));
        }
        this.qualityChooseViewAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.PhotoViewer.68
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (animator.equals(PhotoViewer.this.qualityChooseViewAnimation)) {
                    PhotoViewer.this.qualityChooseViewAnimation = new AnimatorSet();
                    if (z) {
                        PhotoViewer.this.qualityChooseView.setVisibility(0);
                        PhotoViewer.this.qualityPicker.setVisibility(0);
                        PhotoViewer.this.qualityChooseViewAnimation.playTogether(ObjectAnimator.ofFloat(PhotoViewer.this.qualityChooseView, (Property<QualityChooseView, Float>) View.TRANSLATION_Y, 0.0f), ObjectAnimator.ofFloat(PhotoViewer.this.qualityPicker, (Property<PickerBottomLayoutViewer, Float>) View.TRANSLATION_Y, 0.0f), ObjectAnimator.ofFloat(PhotoViewer.this.bottomLayout, (Property<FrameLayout, Float>) View.TRANSLATION_Y, -AndroidUtilities.dp(48.0f)));
                    } else {
                        PhotoViewer.this.qualityChooseView.setVisibility(4);
                        PhotoViewer.this.qualityPicker.setVisibility(4);
                        PhotoViewer.this.qualityChooseViewAnimation.playTogether(ObjectAnimator.ofFloat(PhotoViewer.this.pickerView, (Property<FrameLayout, Float>) View.TRANSLATION_Y, 0.0f), ObjectAnimator.ofFloat(PhotoViewer.this.pickerViewSendButton, (Property<ImageView, Float>) View.TRANSLATION_Y, 0.0f), ObjectAnimator.ofFloat(PhotoViewer.this.bottomLayout, (Property<FrameLayout, Float>) View.TRANSLATION_Y, -AndroidUtilities.dp(48.0f)));
                    }
                    PhotoViewer.this.qualityChooseViewAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.PhotoViewer.68.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator2) {
                            if (animator2.equals(PhotoViewer.this.qualityChooseViewAnimation)) {
                                PhotoViewer.this.qualityChooseViewAnimation = null;
                            }
                        }
                    });
                    PhotoViewer.this.qualityChooseViewAnimation.setDuration(200L);
                    PhotoViewer.this.qualityChooseViewAnimation.setInterpolator(AndroidUtilities.decelerateInterpolator);
                    PhotoViewer.this.qualityChooseViewAnimation.start();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                PhotoViewer.this.qualityChooseViewAnimation = null;
            }
        });
        this.qualityChooseViewAnimation.setDuration(200L);
        this.qualityChooseViewAnimation.setInterpolator(AndroidUtilities.accelerateInterpolator);
        this.qualityChooseViewAnimation.start();
        if (this.cameraItem.getVisibility() == 0) {
            this.cameraItem.animate().scaleX(z ? 0.25f : 1.0f).scaleY(z ? 0.25f : 1.0f).alpha(z ? 0.0f : 1.0f).setDuration(200L);
        }
        if (this.muteItem.getVisibility() == 0) {
            this.muteItem.animate().scaleX(z ? 0.25f : 1.0f).scaleY(z ? 0.25f : 1.0f).alpha(z ? 0.0f : 1.0f).setDuration(200L);
        }
    }

    private void processOpenVideo(String str, boolean z, float f, float f2) {
        if (this.currentLoadingVideoRunnable != null) {
            Utilities.globalQueue.cancelRunnable(this.currentLoadingVideoRunnable);
            this.currentLoadingVideoRunnable = null;
        }
        this.videoTimelineView.setVideoPath(str, f, f2);
        this.videoPreviewMessageObject = null;
        boolean z2 = true;
        if (!z && this.sendPhotoType != 1) {
            z2 = false;
        }
        this.muteVideo = z2;
        this.compressionsCount = -1;
        this.rotationValue = 0;
        this.videoFramerate = 25;
        this.originalSize = new File(str).length();
        DispatchQueue dispatchQueue = Utilities.globalQueue;
        AnonymousClass69 anonymousClass69 = new AnonymousClass69(str);
        this.currentLoadingVideoRunnable = anonymousClass69;
        dispatchQueue.postRunnable(anonymousClass69);
    }

    /* renamed from: org.rbmain.ui.PhotoViewer$69, reason: invalid class name */
    class AnonymousClass69 implements Runnable {
        final /* synthetic */ String val$videoPath;

        AnonymousClass69(String str) {
            this.val$videoPath = str;
        }

        @Override // java.lang.Runnable
        public void run() throws IOException, IllegalArgumentException {
            if (PhotoViewer.this.currentLoadingVideoRunnable != this) {
                return;
            }
            final int videoBitrate = MediaController.getVideoBitrate(this.val$videoPath);
            final int[] iArr = new int[11];
            AnimatedFileDrawable.getVideoInfo(this.val$videoPath, iArr);
            if (PhotoViewer.this.currentLoadingVideoRunnable != this) {
                return;
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.PhotoViewer$69$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$run$0(this, iArr, videoBitrate);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$0(Runnable runnable, int[] iArr, int i) {
            if (PhotoViewer.this.parentActivity == null || runnable != PhotoViewer.this.currentLoadingVideoRunnable) {
                return;
            }
            PhotoViewer.this.currentLoadingVideoRunnable = null;
            PhotoViewer.this.videoConvertSupported = (iArr[0] == 0 || ((iArr[10] != 0) && iArr[9] == 0)) ? false : true;
            PhotoViewer.this.audioFramesSize = iArr[5];
            PhotoViewer.this.videoDuration = iArr[4];
            if (i == -1) {
                PhotoViewer photoViewer = PhotoViewer.this;
                photoViewer.originalBitrate = photoViewer.bitrate = iArr[3];
            } else {
                PhotoViewer photoViewer2 = PhotoViewer.this;
                photoViewer2.originalBitrate = photoViewer2.bitrate = i;
            }
            PhotoViewer.this.videoFramerate = iArr[7];
            PhotoViewer.this.videoFramesSize = (long) (((r6.bitrate / 8) * PhotoViewer.this.videoDuration) / 1000.0f);
            if (PhotoViewer.this.videoConvertSupported) {
                PhotoViewer.this.rotationValue = iArr[8];
                PhotoViewer photoViewer3 = PhotoViewer.this;
                photoViewer3.resultWidth = photoViewer3.originalWidth = iArr[1];
                PhotoViewer photoViewer4 = PhotoViewer.this;
                photoViewer4.resultHeight = photoViewer4.originalHeight = iArr[2];
                PhotoViewer photoViewer5 = PhotoViewer.this;
                photoViewer5.updateCompressionsCount(photoViewer5.originalWidth, PhotoViewer.this.originalHeight);
                PhotoViewer photoViewer6 = PhotoViewer.this;
                photoViewer6.selectedCompression = photoViewer6.selectCompression();
                PhotoViewer.this.updateWidthHeightBitrateForCompression();
                if (PhotoViewer.this.selectedCompression > PhotoViewer.this.compressionsCount - 1) {
                    PhotoViewer photoViewer7 = PhotoViewer.this;
                    photoViewer7.selectedCompression = photoViewer7.compressionsCount - 1;
                }
                PhotoViewer photoViewer8 = PhotoViewer.this;
                photoViewer8.setCompressItemEnabled(photoViewer8.compressionsCount > 1, true);
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("compressionsCount = " + PhotoViewer.this.compressionsCount + " w = " + PhotoViewer.this.originalWidth + " h = " + PhotoViewer.this.originalHeight + " r = " + PhotoViewer.this.rotationValue);
                }
                if (Build.VERSION.SDK_INT < 18 && PhotoViewer.this.compressItem.getTag() != null) {
                    PhotoViewer.this.videoConvertSupported = false;
                    PhotoViewer.this.setCompressItemEnabled(false, true);
                }
                PhotoViewer.this.qualityChooseView.invalidate();
            } else {
                PhotoViewer.this.setCompressItemEnabled(false, true);
                PhotoViewer.this.compressionsCount = 0;
            }
            PhotoViewer.this.updateVideoInfo();
            PhotoViewer.this.updateMuteButton();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int selectCompression() {
        SharedPreferences globalMainSettings = MessagesController.getGlobalMainSettings();
        int i = this.compressionsCount;
        while (i < 5) {
            int i2 = globalMainSettings.getInt(String.format(Locale.US, "compress_video_%d", Integer.valueOf(i)), -1);
            if (i2 >= 0) {
                return i2;
            }
            i++;
        }
        return Math.round(DownloadController.getInstance(this.currentAccount).getMaxVideoBitrate() / (100.0f / i)) - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCompressionsCount(int i, int i2) {
        int iMax = Math.max(i, i2);
        if (iMax > 1280) {
            this.compressionsCount = 4;
            return;
        }
        if (iMax > 854) {
            this.compressionsCount = 3;
        } else if (iMax > 640) {
            this.compressionsCount = 2;
        } else {
            this.compressionsCount = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCompressItemEnabled(boolean z, boolean z2) {
        ImageView imageView = this.compressItem;
        if (imageView == null) {
            return;
        }
        if (!z || imageView.getTag() == null) {
            if (z || this.compressItem.getTag() != null) {
                this.compressItem.setTag(z ? 1 : null);
                AnimatorSet animatorSet = this.compressItemAnimation;
                if (animatorSet != null) {
                    animatorSet.cancel();
                    this.compressItemAnimation = null;
                }
                if (z2) {
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    this.compressItemAnimation = animatorSet2;
                    Animator[] animatorArr = new Animator[4];
                    ImageView imageView2 = this.compressItem;
                    Property property = View.ALPHA;
                    float[] fArr = new float[1];
                    fArr[0] = z ? 1.0f : 0.5f;
                    animatorArr[0] = ObjectAnimator.ofFloat(imageView2, (Property<ImageView, Float>) property, fArr);
                    ImageView imageView3 = this.paintItem;
                    Property property2 = View.ALPHA;
                    float[] fArr2 = new float[1];
                    fArr2[0] = this.videoConvertSupported ? 1.0f : 0.5f;
                    animatorArr[1] = ObjectAnimator.ofFloat(imageView3, (Property<ImageView, Float>) property2, fArr2);
                    ImageView imageView4 = this.tuneItem;
                    Property property3 = View.ALPHA;
                    float[] fArr3 = new float[1];
                    fArr3[0] = this.videoConvertSupported ? 1.0f : 0.5f;
                    animatorArr[2] = ObjectAnimator.ofFloat(imageView4, (Property<ImageView, Float>) property3, fArr3);
                    ImageView imageView5 = this.cropItem;
                    Property property4 = View.ALPHA;
                    float[] fArr4 = new float[1];
                    fArr4[0] = this.videoConvertSupported ? 1.0f : 0.5f;
                    animatorArr[3] = ObjectAnimator.ofFloat(imageView5, (Property<ImageView, Float>) property4, fArr4);
                    animatorSet2.playTogether(animatorArr);
                    this.compressItemAnimation.setDuration(180L);
                    this.compressItemAnimation.setInterpolator(decelerateInterpolator);
                    this.compressItemAnimation.start();
                    return;
                }
                this.compressItem.setAlpha(z ? 1.0f : 0.5f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAccessibilityOverlayVisibility() {
        if (this.playButtonAccessibilityOverlay != null) {
            int i = this.photoProgressViews[0].backgroundState;
            if (this.photoProgressViews[0].isVisible() && (i == 3 || i == 4)) {
                if (i == 3) {
                    this.playButtonAccessibilityOverlay.setContentDescription(LocaleController.getString("AccActionPlay", R.string.AccActionPlay));
                } else {
                    this.playButtonAccessibilityOverlay.setContentDescription(LocaleController.getString("AccActionPause", R.string.AccActionPause));
                }
                this.playButtonAccessibilityOverlay.setVisibility(0);
                return;
            }
            this.playButtonAccessibilityOverlay.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return 0;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return false;
        }

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (PhotoViewer.this.placeProvider == null || PhotoViewer.this.placeProvider.getSelectedPhotosOrder() == null) {
                return 0;
            }
            return PhotoViewer.this.placeProvider.getSelectedPhotosOrder().size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            PhotoPickerPhotoCell photoPickerPhotoCell = new PhotoPickerPhotoCell(this.mContext);
            photoPickerPhotoCell.checkFrame.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.PhotoViewer$ListAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onCreateViewHolder$0(view);
                }
            });
            return new RecyclerListView.Holder(photoPickerPhotoCell);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCreateViewHolder$0(View view) {
            Object tag = ((View) view.getParent()).getTag();
            int iIndexOf = PhotoViewer.this.imagesArrLocals.indexOf(tag);
            if (iIndexOf >= 0) {
                int photoChecked = PhotoViewer.this.placeProvider.setPhotoChecked(iIndexOf, PhotoViewer.this.getCurrentVideoEditedInfo());
                PhotoViewer.this.placeProvider.isPhotoChecked(iIndexOf);
                if (iIndexOf == PhotoViewer.this.currentIndex) {
                    PhotoViewer.this.checkImageView.setChecked(-1, false, true);
                }
                if (photoChecked >= 0) {
                    PhotoViewer.this.selectedPhotosAdapter.notifyItemRemoved(photoChecked);
                    if (photoChecked == 0) {
                        PhotoViewer.this.selectedPhotosAdapter.notifyItemChanged(0);
                    }
                }
                PhotoViewer.this.updateSelectedCount();
                return;
            }
            int photoUnchecked = PhotoViewer.this.placeProvider.setPhotoUnchecked(tag);
            if (photoUnchecked >= 0) {
                PhotoViewer.this.selectedPhotosAdapter.notifyItemRemoved(photoUnchecked);
                if (photoUnchecked == 0) {
                    PhotoViewer.this.selectedPhotosAdapter.notifyItemChanged(0);
                }
                PhotoViewer.this.updateSelectedCount();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            PhotoPickerPhotoCell photoPickerPhotoCell = (PhotoPickerPhotoCell) viewHolder.itemView;
            photoPickerPhotoCell.setItemWidth(AndroidUtilities.dp(85.0f), i != 0 ? AndroidUtilities.dp(6.0f) : 0);
            BackupImageView backupImageView = photoPickerPhotoCell.imageView;
            backupImageView.setOrientation(0, true);
            Object obj = PhotoViewer.this.placeProvider.getSelectedPhotos().get(PhotoViewer.this.placeProvider.getSelectedPhotosOrder().get(i));
            if (obj instanceof MediaController.PhotoEntry) {
                MediaController.PhotoEntry photoEntry = (MediaController.PhotoEntry) obj;
                photoPickerPhotoCell.setTag(photoEntry);
                photoPickerPhotoCell.videoInfoContainer.setVisibility(4);
                String str = photoEntry.thumbPath;
                if (str != null) {
                    backupImageView.setImage(str, null, this.mContext.getResources().getDrawable(R.drawable.nophotos));
                } else if (photoEntry.path != null) {
                    backupImageView.setOrientation(photoEntry.orientation, true);
                    if (photoEntry.isVideo) {
                        photoPickerPhotoCell.videoInfoContainer.setVisibility(0);
                        photoPickerPhotoCell.videoTextView.setText(AndroidUtilities.formatShortDuration(photoEntry.duration));
                        backupImageView.setImage("vthumb://" + photoEntry.imageId + ":" + photoEntry.path, null, this.mContext.getResources().getDrawable(R.drawable.nophotos));
                    } else {
                        backupImageView.setImage("thumb://" + photoEntry.imageId + ":" + photoEntry.path, null, this.mContext.getResources().getDrawable(R.drawable.nophotos));
                    }
                } else {
                    backupImageView.setImageResource(R.drawable.nophotos);
                }
                photoPickerPhotoCell.setChecked(-1, true, false);
                photoPickerPhotoCell.checkBox.setVisibility(0);
                return;
            }
            if (obj instanceof MediaController.SearchImage) {
                MediaController.SearchImage searchImage = (MediaController.SearchImage) obj;
                photoPickerPhotoCell.setTag(searchImage);
                photoPickerPhotoCell.setImage(searchImage);
                photoPickerPhotoCell.videoInfoContainer.setVisibility(4);
                photoPickerPhotoCell.setChecked(-1, true, false);
                photoPickerPhotoCell.checkBox.setVisibility(0);
            }
        }
    }
}
