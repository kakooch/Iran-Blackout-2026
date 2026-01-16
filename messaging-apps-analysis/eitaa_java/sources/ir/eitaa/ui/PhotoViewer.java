package ir.eitaa.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
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
import android.view.ViewPropertyAnimator;
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
import android.widget.Toast;
import android.widget.ViewSwitcher;
import androidx.annotation.Keep;
import androidx.collection.ArrayMap;
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
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;
import ir.eitaa.messenger.AccountInstance;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.Bitmaps;
import ir.eitaa.messenger.BringAppForegroundService;
import ir.eitaa.messenger.BuildVars;
import ir.eitaa.messenger.ChatObject;
import ir.eitaa.messenger.DialogObject;
import ir.eitaa.messenger.DispatchQueue;
import ir.eitaa.messenger.DownloadController;
import ir.eitaa.messenger.Emoji;
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
import ir.eitaa.messenger.SecureDocument;
import ir.eitaa.messenger.SendMessagesHelper;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.UserObject;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.messenger.VideoEditedInfo;
import ir.eitaa.messenger.WebFile;
import ir.eitaa.messenger.video.VideoPlayerRewinder;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$BotInlineResult;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$Document;
import ir.eitaa.tgnet.TLRPC$DocumentAttribute;
import ir.eitaa.tgnet.TLRPC$EncryptedChat;
import ir.eitaa.tgnet.TLRPC$FileLocation;
import ir.eitaa.tgnet.TLRPC$Message;
import ir.eitaa.tgnet.TLRPC$MessageAction;
import ir.eitaa.tgnet.TLRPC$MessageEntity;
import ir.eitaa.tgnet.TLRPC$MessageMedia;
import ir.eitaa.tgnet.TLRPC$PageBlock;
import ir.eitaa.tgnet.TLRPC$Photo;
import ir.eitaa.tgnet.TLRPC$PhotoSize;
import ir.eitaa.tgnet.TLRPC$TL_documentAttributeVideo;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_fileLocationToBeDeprecated;
import ir.eitaa.tgnet.TLRPC$TL_fileLocationUnavailable;
import ir.eitaa.tgnet.TLRPC$TL_inputPhoto;
import ir.eitaa.tgnet.TLRPC$TL_message;
import ir.eitaa.tgnet.TLRPC$TL_messageActionEmpty;
import ir.eitaa.tgnet.TLRPC$TL_messageActionUserUpdatedPhoto;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaEmpty;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaInvoice;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaPhoto;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaWebPage;
import ir.eitaa.tgnet.TLRPC$TL_messageService;
import ir.eitaa.tgnet.TLRPC$TL_photo;
import ir.eitaa.tgnet.TLRPC$TL_photoEmpty;
import ir.eitaa.tgnet.TLRPC$TL_photos_photo;
import ir.eitaa.tgnet.TLRPC$TL_webDocument;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$VideoSize;
import ir.eitaa.tgnet.TLRPC$WebDocument;
import ir.eitaa.tgnet.TLRPC$WebPage;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.ActionBarMenu;
import ir.eitaa.ui.ActionBar.ActionBarMenuItem;
import ir.eitaa.ui.ActionBar.ActionBarMenuSubItem;
import ir.eitaa.ui.ActionBar.ActionBarPopupWindow;
import ir.eitaa.ui.ActionBar.AdjustPanLayoutHelper;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.BottomSheet;
import ir.eitaa.ui.ActionBar.SimpleTextView;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Adapters.MentionsAdapter;
import ir.eitaa.ui.Cells.CheckBoxCell;
import ir.eitaa.ui.Cells.PhotoPickerPhotoCell;
import ir.eitaa.ui.Components.AlertsCreator;
import ir.eitaa.ui.Components.AnimatedFileDrawable;
import ir.eitaa.ui.Components.AnimationProperties;
import ir.eitaa.ui.Components.BackupImageView;
import ir.eitaa.ui.Components.Bulletin;
import ir.eitaa.ui.Components.BulletinFactory;
import ir.eitaa.ui.Components.ChatAttachAlert;
import ir.eitaa.ui.Components.CheckBox;
import ir.eitaa.ui.Components.ClippingImageView;
import ir.eitaa.ui.Components.CombinedDrawable;
import ir.eitaa.ui.Components.Crop.CropTransform;
import ir.eitaa.ui.Components.CubicBezierInterpolator;
import ir.eitaa.ui.Components.FadingTextViewLayout;
import ir.eitaa.ui.Components.FilterGLThread;
import ir.eitaa.ui.Components.FilterShaders;
import ir.eitaa.ui.Components.FloatSeekBarAccessibilityDelegate;
import ir.eitaa.ui.Components.GestureDetector2;
import ir.eitaa.ui.Components.GroupedPhotosListView;
import ir.eitaa.ui.Components.HideViewAfterAnimation;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.NumberPicker;
import ir.eitaa.ui.Components.OtherDocumentPlaceholderDrawable;
import ir.eitaa.ui.Components.Paint.Views.ColorPicker;
import ir.eitaa.ui.Components.PaintingOverlay;
import ir.eitaa.ui.Components.PhotoCropView;
import ir.eitaa.ui.Components.PhotoFilterView;
import ir.eitaa.ui.Components.PhotoPaintView;
import ir.eitaa.ui.Components.PhotoViewerCaptionEnterView;
import ir.eitaa.ui.Components.PhotoViewerWebView;
import ir.eitaa.ui.Components.PickerBottomLayoutViewer;
import ir.eitaa.ui.Components.PipVideoView;
import ir.eitaa.ui.Components.PlayPauseDrawable;
import ir.eitaa.ui.Components.RLottieDrawable;
import ir.eitaa.ui.Components.RadialProgressView;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.Components.SizeNotifierFrameLayoutPhoto;
import ir.eitaa.ui.Components.StickersAlert;
import ir.eitaa.ui.Components.TextViewSwitcher;
import ir.eitaa.ui.Components.Tooltip;
import ir.eitaa.ui.Components.URLSpanReplacement;
import ir.eitaa.ui.Components.URLSpanUserMentionPhotoViewer;
import ir.eitaa.ui.Components.UndoView;
import ir.eitaa.ui.Components.VideoEditTextureView;
import ir.eitaa.ui.Components.VideoForwardDrawable;
import ir.eitaa.ui.Components.VideoPlayer;
import ir.eitaa.ui.Components.VideoPlayerSeekBar;
import ir.eitaa.ui.Components.VideoSeekPreviewImage;
import ir.eitaa.ui.Components.VideoTimelinePlayView;
import ir.eitaa.ui.Components.ViewHelper;
import java.io.File;
import java.io.FileOutputStream;
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
import org.linphone.mediastream.Factory;
import org.webrtc.MediaStreamTrack;

/* loaded from: classes3.dex */
public class PhotoViewer implements NotificationCenter.NotificationCenterDelegate, GestureDetector2.OnGestureListener, GestureDetector2.OnDoubleTapListener {

    @SuppressLint({"StaticFieldLeak"})
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
    private long avatarsDialogId;
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
    private float currentVideoSpeed;
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
    private boolean isEmbedVideo;
    private boolean isEvent;
    private boolean isFirstLoading;
    private boolean isInline;
    private boolean isPhotosListViewVisible;
    private boolean isPlaying;
    private boolean isStreaming;
    private boolean isVisible;
    private LinearLayout itemsLayout;
    private boolean keepScreenOnFlagSet;
    boolean keyboardAnimationEnabled;
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
    private ActionBarMenuItem menuItemSpeed;
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
    private PhotoViewerWebView photoViewerWebView;
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
    private Theme.ResourcesProvider resourcesProvider;
    private int resultHeight;
    private int resultWidth;
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
    private int slideshowMessageId;
    private View speedGap;
    private ActionBarMenuSubItem speedItem;
    private long startTime;
    private long startedPlayTime;
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
    private ObjectAnimator videoTimelineAnimator;
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
    private Runnable miniProgressShowRunnable = new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$Zf2VqYBNrpJzrt2Pr_aOpd_irdg
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.lambda$new$0$PhotoViewer();
        }
    };
    private boolean isActionBarVisible = true;
    private ActionBarMenuSubItem[] speedItems = new ActionBarMenuSubItem[5];
    private Map<View, Boolean> actionBarItemsVisibility = new HashMap(3);
    private BackgroundDrawable backgroundDrawable = new BackgroundDrawable(-16777216);
    private Paint blackPaint = new Paint();
    private PhotoProgressView[] photoProgressViews = new PhotoProgressView[3];
    private GradientDrawable[] pressedDrawable = new GradientDrawable[2];
    private boolean[] drawPressedDrawable = new boolean[2];
    private float[] pressedDrawableAlpha = new float[2];
    private CropTransform cropTransform = new CropTransform();
    private Paint bitmapPaint = new Paint(2);
    private OnPhotoCloseListener onPhotoCloseListener = null;
    private Runnable setLoadingRunnable = new Runnable() { // from class: ir.eitaa.ui.PhotoViewer.1
        @Override // java.lang.Runnable
        public void run() {
            if (PhotoViewer.this.currentMessageObject == null) {
                return;
            }
            FileLoader.getInstance(PhotoViewer.this.currentMessageObject.currentAccount).setLoadingVideo(PhotoViewer.this.currentMessageObject.getDocument(), true, false);
        }
    };
    private Runnable hideActionBarRunnable = new Runnable() { // from class: ir.eitaa.ui.PhotoViewer.2
        @Override // java.lang.Runnable
        public void run() {
            if (PhotoViewer.this.videoPlayerControlVisible && PhotoViewer.this.isPlaying && !ApplicationLoader.mainInterfacePaused) {
                if (PhotoViewer.this.menuItem == null || !PhotoViewer.this.menuItem.isSubMenuShowing()) {
                    if (PhotoViewer.this.menuItemSpeed == null || !PhotoViewer.this.menuItemSpeed.isSubMenuShowing()) {
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
    VideoPlayerRewinder videoPlayerRewinder = new VideoPlayerRewinder() { // from class: ir.eitaa.ui.PhotoViewer.3
        @Override // ir.eitaa.messenger.video.VideoPlayerRewinder
        protected void onRewindCanceled() throws Resources.NotFoundException {
            PhotoViewer.this.onTouchEvent(MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0));
            PhotoViewer.this.videoForwardDrawable.setShowing(false);
        }

        @Override // ir.eitaa.messenger.video.VideoPlayerRewinder
        protected void updateRewindProgressUi(long timeDiff, float progress, boolean rewindByBackSeek) {
            PhotoViewer.this.videoForwardDrawable.setTime(Math.abs(timeDiff));
            if (rewindByBackSeek) {
                PhotoViewer.this.videoPlayerSeekbar.setProgress(progress);
                PhotoViewer.this.videoPlayerSeekbarView.invalidate();
            }
        }

        @Override // ir.eitaa.messenger.video.VideoPlayerRewinder
        protected void onRewindStart(boolean rewindForward) {
            PhotoViewer.this.videoForwardDrawable.setOneShootAnimation(false);
            PhotoViewer.this.videoForwardDrawable.setLeftSide(!rewindForward);
            PhotoViewer.this.videoForwardDrawable.setShowing(true);
            PhotoViewer.this.containerView.invalidate();
        }
    };
    public final Property<View, Float> FLASH_VIEW_VALUE = new AnimationProperties.FloatProperty<View>("flashViewAlpha") { // from class: ir.eitaa.ui.PhotoViewer.4
        @Override // ir.eitaa.ui.Components.AnimationProperties.FloatProperty
        public void setValue(View object, float value) {
            object.setAlpha(value);
            if (PhotoViewer.this.photoCropView != null) {
                PhotoViewer.this.photoCropView.setVideoThumbFlashAlpha(value);
            }
        }

        @Override // android.util.Property
        public Float get(View object) {
            return Float.valueOf(object.getAlpha());
        }
    };
    private Runnable updateProgressRunnable = new AnonymousClass5();
    private Runnable switchToInlineRunnable = new Runnable() { // from class: ir.eitaa.ui.PhotoViewer.6
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
    private TextureView.SurfaceTextureListener surfaceTextureListener = new TextureView.SurfaceTextureListener() { // from class: ir.eitaa.ui.PhotoViewer.7
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
            if (PhotoViewer.this.videoTextureView == null || !PhotoViewer.this.changingTextureView) {
                return true;
            }
            if (PhotoViewer.this.switchingInlineMode) {
                PhotoViewer.this.waitingForFirstTextureUpload = 2;
            }
            PhotoViewer.this.videoTextureView.setSurfaceTexture(surface);
            PhotoViewer.this.videoTextureView.setVisibility(0);
            PhotoViewer.this.changingTextureView = false;
            PhotoViewer.this.containerView.invalidate();
            return false;
        }

        /* renamed from: ir.eitaa.ui.PhotoViewer$7$1, reason: invalid class name */
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
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$7$1$SkcqgkslYxcjNL3ro-4Uai-y6gc
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onPreDraw$0$PhotoViewer$7$1();
                    }
                });
                PhotoViewer.this.waitingForFirstTextureUpload = 0;
                return true;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: lambda$onPreDraw$0, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void lambda$onPreDraw$0$PhotoViewer$7$1() {
                if (PhotoViewer.this.isInline) {
                    PhotoViewer.this.dismissInternal();
                }
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surface) {
            if (PhotoViewer.this.waitingForFirstTextureUpload == 1) {
                PhotoViewer.this.changedTextureView.getViewTreeObserver().addOnPreDrawListener(new AnonymousClass1());
                PhotoViewer.this.changedTextureView.invalidate();
            }
        }
    };
    private float[][] animationValues = (float[][]) Array.newInstance((Class<?>) float.class, 2, 13);
    private final Runnable updateContainerFlagsRunnable = new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$tKKgfZRP2xSY3Tel2e_UQgmFRIU
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.lambda$new$1$PhotoViewer();
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
    private SparseArray<MessageObject>[] imagesByIdsTemp = {new SparseArray<>(), new SparseArray<>()};
    private ArrayList<MessageObject> imagesArr = new ArrayList<>();
    private SparseArray<MessageObject>[] imagesByIds = {new SparseArray<>(), new SparseArray<>()};
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
    Runnable longPressRunnable = new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$-JeEDsgNzzPh-SQpII1vDE9DEMk
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.onLongPress();
        }
    };
    private long captureFrameAtTime = -1;
    private long captureFrameReadyAtTime = -1;
    private long needCaptureFrameReadyAtTime = -1;
    private int compressionsCount = -1;

    public static class EmptyPhotoViewerProvider implements PhotoViewerProvider {
        @Override // ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public boolean allowCaption() {
            return true;
        }

        @Override // ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public boolean allowSendingSubmenu() {
            return true;
        }

        @Override // ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public boolean canCaptureMorePhotos() {
            return true;
        }

        @Override // ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public boolean canReplace(int index) {
            return false;
        }

        @Override // ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public boolean canScrollAway() {
            return true;
        }

        @Override // ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public boolean cancelButtonPressed() {
            return true;
        }

        @Override // ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public boolean closeKeyboard() {
            return false;
        }

        @Override // ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public void deleteImageAtIndex(int index) {
        }

        @Override // ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public String getDeleteMessageString() {
            return null;
        }

        @Override // ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public MessageObject getEditingMessageObject() {
            return null;
        }

        @Override // ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public PlaceProviderObject getPlaceForPhoto(MessageObject messageObject, TLRPC$FileLocation fileLocation, int index, boolean needPreview) {
            return null;
        }

        @Override // ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public int getSelectedCount() {
            return 0;
        }

        @Override // ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public HashMap<Object, Object> getSelectedPhotos() {
            return null;
        }

        @Override // ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public ArrayList<Object> getSelectedPhotosOrder() {
            return null;
        }

        @Override // ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public CharSequence getSubtitleFor(int i) {
            return null;
        }

        @Override // ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public ImageReceiver.BitmapHolder getThumbForPhoto(MessageObject messageObject, TLRPC$FileLocation fileLocation, int index) {
            return null;
        }

        @Override // ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public CharSequence getTitleFor(int i) {
            return null;
        }

        @Override // ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public int getTotalImageCount() {
            return -1;
        }

        @Override // ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public boolean isPhotoChecked(int index) {
            return false;
        }

        @Override // ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public boolean loadMore() {
            return false;
        }

        @Override // ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public void needAddMorePhotos() {
        }

        @Override // ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public void onCaptionChanged(CharSequence caption) {
        }

        @Override // ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public void openPhotoForEdit(String file, String thumb, boolean isVideo) {
        }

        @Override // ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public void replaceButtonPressed(int index, VideoEditedInfo videoEditedInfo) {
        }

        @Override // ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public boolean scaleToFill() {
            return false;
        }

        @Override // ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public void sendButtonPressed(int index, VideoEditedInfo videoEditedInfo, boolean notify, int scheduleDate, boolean forceDocument) {
        }

        @Override // ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public int setPhotoChecked(int index, VideoEditedInfo videoEditedInfo) {
            return -1;
        }

        @Override // ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public int setPhotoUnchecked(Object photoEntry) {
            return -1;
        }

        @Override // ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public void updatePhotoAtIndex(int index) {
        }

        @Override // ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public boolean validateGroupId(long groupId) {
            return true;
        }

        @Override // ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public void willHidePhotoViewer() {
        }

        @Override // ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
        public void willSwitchFromPhoto(MessageObject messageObject, TLRPC$FileLocation fileLocation, int index) {
        }
    }

    public interface OnPhotoCloseListener {
        void onClose();
    }

    public interface PageBlocksAdapter {
        TLRPC$PageBlock get(int index);

        List<TLRPC$PageBlock> getAll();

        CharSequence getCaption(int index);

        File getFile(int index);

        TLRPC$PhotoSize getFileLocation(TLObject media, int[] size);

        String getFileName(int index);

        int getItemsCount();

        TLObject getMedia(int index);

        Object getParentObject();

        boolean isVideo(int index);

        void updateSlideshowCell(TLRPC$PageBlock currentPageBlock);
    }

    public interface PhotoViewerProvider {
        boolean allowCaption();

        boolean allowSendingSubmenu();

        boolean canCaptureMorePhotos();

        boolean canReplace(int index);

        boolean canScrollAway();

        boolean cancelButtonPressed();

        boolean closeKeyboard();

        void deleteImageAtIndex(int index);

        String getDeleteMessageString();

        MessageObject getEditingMessageObject();

        PlaceProviderObject getPlaceForPhoto(MessageObject messageObject, TLRPC$FileLocation fileLocation, int index, boolean needPreview);

        int getSelectedCount();

        HashMap<Object, Object> getSelectedPhotos();

        ArrayList<Object> getSelectedPhotosOrder();

        CharSequence getSubtitleFor(int index);

        ImageReceiver.BitmapHolder getThumbForPhoto(MessageObject messageObject, TLRPC$FileLocation fileLocation, int index);

        CharSequence getTitleFor(int index);

        int getTotalImageCount();

        boolean isPhotoChecked(int index);

        boolean loadMore();

        void needAddMorePhotos();

        void onCaptionChanged(CharSequence caption);

        void openPhotoForEdit(String file, String thumb, boolean isVideo);

        void replaceButtonPressed(int index, VideoEditedInfo videoEditedInfo);

        boolean scaleToFill();

        void sendButtonPressed(int index, VideoEditedInfo videoEditedInfo, boolean notify, int scheduleDate, boolean forceDocument);

        int setPhotoChecked(int index, VideoEditedInfo videoEditedInfo);

        int setPhotoUnchecked(Object photoEntry);

        void updatePhotoAtIndex(int index);

        boolean validateGroupId(long groupId);

        void willHidePhotoViewer();

        void willSwitchFromPhoto(MessageObject messageObject, TLRPC$FileLocation fileLocation, int index);
    }

    public static class PlaceProviderObject {
        public ClippingImageView animatingImageView;
        public int animatingImageViewYOffset;
        public boolean canEdit;
        public int clipBottomAddition;
        public int clipTopAddition;
        public long dialogId;
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

    static /* synthetic */ boolean lambda$setParentActivity$23(View view, MotionEvent motionEvent) {
        return true;
    }

    static /* synthetic */ boolean lambda$setParentActivity$24(View view, MotionEvent motionEvent) {
        return true;
    }

    @Override // ir.eitaa.ui.Components.GestureDetector2.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent e) {
        return false;
    }

    @Override // ir.eitaa.ui.Components.GestureDetector2.OnGestureListener
    public void onLongPress(MotionEvent ev) {
    }

    @Override // ir.eitaa.ui.Components.GestureDetector2.OnGestureListener
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override // ir.eitaa.ui.Components.GestureDetector2.OnGestureListener
    public void onShowPress(MotionEvent e) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$PhotoViewer() {
        toggleMiniProgressInternal(true);
    }

    public void addPhoto(MessageObject message, int classGuid) throws Resources.NotFoundException {
        if (classGuid != this.classGuid) {
            return;
        }
        if (this.imagesByIds[0].indexOfKey(message.getId()) < 0) {
            if (this.opennedFromMedia) {
                this.imagesArr.add(message);
            } else {
                this.imagesArr.add(0, message);
            }
            this.imagesByIds[0].put(message.getId(), message);
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

        public SavedVideoPosition(float position, long timestamp) {
            this.position = position;
            this.timestamp = timestamp;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class CaptionLinkMovementMethod extends LinkMovementMethod {
        Runnable longPressRunnable;
        ClickableSpan selectedLink;
        TextView selectedWidget;

        private CaptionLinkMovementMethod() {
            this.longPressRunnable = new Runnable() { // from class: ir.eitaa.ui.PhotoViewer.CaptionLinkMovementMethod.1
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
        public boolean onTouchEvent(TextView widget, Spannable buffer, MotionEvent event) {
            boolean z;
            try {
                if (!PhotoViewer.this.imagesArrLocals.isEmpty()) {
                    return false;
                }
                int action = event.getAction();
                if (action == 3) {
                    AndroidUtilities.cancelRunOnUIThread(this.longPressRunnable);
                    this.selectedLink = null;
                }
                if (action == 1 || action == 0) {
                    int x = (int) event.getX();
                    int y = (int) event.getY();
                    int totalPaddingLeft = x - widget.getTotalPaddingLeft();
                    int totalPaddingTop = y - widget.getTotalPaddingTop();
                    int scrollX = totalPaddingLeft + widget.getScrollX();
                    int scrollY = totalPaddingTop + widget.getScrollY();
                    Layout layout = widget.getLayout();
                    int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
                    ClickableSpan[] clickableSpanArr = (ClickableSpan[]) buffer.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
                    if (clickableSpanArr.length != 0) {
                        ClickableSpan clickableSpan = clickableSpanArr[0];
                        if (action == 1) {
                            if (this.selectedLink != clickableSpan) {
                                this.selectedLink = null;
                                return false;
                            }
                            onClick(clickableSpan, widget);
                            AndroidUtilities.cancelRunOnUIThread(this.longPressRunnable);
                            this.selectedLink = null;
                        } else {
                            Selection.setSelection(buffer, buffer.getSpanStart(clickableSpan), buffer.getSpanEnd(clickableSpan));
                            AndroidUtilities.runOnUIThread(this.longPressRunnable, ViewConfiguration.getLongPressTimeout());
                            this.selectedLink = clickableSpan;
                            this.selectedWidget = widget;
                        }
                        z = true;
                    } else {
                        Selection.removeSelection(buffer);
                        AndroidUtilities.cancelRunOnUIThread(this.longPressRunnable);
                        this.selectedLink = null;
                        z = false;
                    }
                } else {
                    z = false;
                }
                return z || Touch.onTouchEvent(widget, buffer, event);
            } catch (Exception e) {
                FileLog.e(e);
                return false;
            }
        }

        private void onClick(ClickableSpan link, TextView widget) {
            if (widget != null && (link instanceof URLSpan)) {
                String url = ((URLSpan) link).getURL();
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
                        DialogsActivity dialogsActivity = new DialogsActivity(null);
                        dialogsActivity.setSearchString(url);
                        ((LaunchActivity) PhotoViewer.this.parentActivity).presentFragment(dialogsActivity, false, true);
                        PhotoViewer.this.closePhoto(false, false);
                        return;
                    }
                    return;
                }
                if (PhotoViewer.this.parentChatActivity != null && ((link instanceof URLSpanReplacement) || AndroidUtilities.shouldShowUrlInAlert(url))) {
                    AlertsCreator.showOpenUrlAlert(PhotoViewer.this.parentChatActivity, url, true, true);
                    return;
                } else {
                    link.onClick(widget);
                    return;
                }
            }
            link.onClick(widget);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onLongClick(final URLSpan link) {
            final int i;
            BottomSheet.Builder builder = new BottomSheet.Builder(PhotoViewer.this.parentActivity, false, PhotoViewer.this.resourcesProvider);
            if (link.getURL().startsWith("video?")) {
                try {
                    i = Integer.parseInt(link.getURL().substring(link.getURL().indexOf(63) + 1));
                } catch (Throwable unused) {
                }
            } else {
                i = -1;
            }
            if (i >= 0) {
                builder.setTitle(AndroidUtilities.formatDuration(i, false));
            } else {
                builder.setTitle(link.getURL());
            }
            builder.setItems(new CharSequence[]{LocaleController.getString("Open", R.string.Open), LocaleController.getString("Copy", R.string.Copy)}, new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$CaptionLinkMovementMethod$wqbG5_e-EfLrKNsAblH5EUI9SmY
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$onLongClick$0$PhotoViewer$CaptionLinkMovementMethod(link, i, dialogInterface, i2);
                }
            });
            BottomSheet bottomSheetCreate = builder.create();
            bottomSheetCreate.show();
            bottomSheetCreate.setItemColor(0, -1, -1);
            bottomSheetCreate.setItemColor(1, -1, -1);
            bottomSheetCreate.setBackgroundColor(-14933463);
            bottomSheetCreate.setTitleColor(-7697782);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:54:0x013b  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x0145  */
        /* renamed from: lambda$onLongClick$0, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public /* synthetic */ void lambda$onLongClick$0$PhotoViewer$CaptionLinkMovementMethod(android.text.style.URLSpan r7, int r8, android.content.DialogInterface r9, int r10) {
            /*
                Method dump skipped, instructions count: 397
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.PhotoViewer.CaptionLinkMovementMethod.lambda$onLongClick$0$PhotoViewer$CaptionLinkMovementMethod(android.text.style.URLSpan, int, android.content.DialogInterface, int):void");
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

    /* renamed from: ir.eitaa.ui.PhotoViewer$5, reason: invalid class name */
    class AnonymousClass5 implements Runnable {
        AnonymousClass5() {
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
                        if (PhotoViewer.this.seekToProgressPending == 0.0f) {
                            PhotoViewer photoViewer = PhotoViewer.this;
                            VideoPlayerRewinder videoPlayerRewinder = photoViewer.videoPlayerRewinder;
                            if (videoPlayerRewinder.rewindCount == 0 || !videoPlayerRewinder.rewindByBackSeek) {
                                photoViewer.videoPlayerSeekbar.setProgress(currentPosition2, false);
                            }
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
                        Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$5$qM6qj8tR68n5QGUl984FbYl8jQs
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$run$0$PhotoViewer$5(currentPosition2);
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
        /* renamed from: lambda$run$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$run$0$PhotoViewer$5(float f) {
            ApplicationLoader.applicationContext.getSharedPreferences("media_saved_pos", 0).edit().putFloat(PhotoViewer.this.shouldSavePositionForCurrentVideo, f).commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$1$PhotoViewer() {
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

        public SavedState(int index, ArrayList<MessageObject> messages, PhotoViewerProvider provider) {
            this.messages = messages;
            this.index = index;
            this.provider = provider;
        }

        public void restore() throws InterruptedException, Resources.NotFoundException {
            PhotoViewer.this.placeProvider = this.provider;
            if (Build.VERSION.SDK_INT >= 21) {
                PhotoViewer.this.windowLayoutParams.flags = -2147286784;
            } else {
                PhotoViewer.this.windowLayoutParams.flags = 131072;
            }
            PhotoViewer.this.windowLayoutParams.softInputMode = (PhotoViewer.this.useSmoothKeyboard ? 32 : 16) | Factory.DEVICE_HAS_CRAPPY_OPENSLES;
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

        public BackgroundDrawable(int color) {
            super(color);
            this.rect = new RectF();
            this.visibleRect = new RectF();
            Paint paint = new Paint(1);
            this.paint = paint;
            paint.setColor(color);
        }

        @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
        @Keep
        public void setAlpha(int alpha) {
            if (PhotoViewer.this.parentActivity instanceof LaunchActivity) {
                this.allowDrawContent = (PhotoViewer.this.isVisible && alpha == 255) ? false : true;
                ((LaunchActivity) PhotoViewer.this.parentActivity).drawerLayoutContainer.setAllowDrawContent(this.allowDrawContent);
                if (PhotoViewer.this.parentAlert != null) {
                    if (this.allowDrawContent) {
                        PhotoViewer.this.parentAlert.setAllowDrawContent(true);
                    } else {
                        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$BackgroundDrawable$rX81TbGwh7SWGOE3fjdjAfMXb7M
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$setAlpha$0$PhotoViewer$BackgroundDrawable();
                            }
                        }, 50L);
                    }
                }
            }
            super.setAlpha(alpha);
            this.paint.setAlpha(alpha);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$setAlpha$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$setAlpha$0$PhotoViewer$BackgroundDrawable() {
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
            DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator() { // from class: ir.eitaa.ui.PhotoViewer.SelectedPhotosListView.1
                @Override // androidx.recyclerview.widget.DefaultItemAnimator
                protected void onMoveAnimationUpdate(RecyclerView.ViewHolder holder) {
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
        public void onDraw(Canvas c) {
            super.onDraw(c);
            int childCount = getChildCount();
            if (childCount > 0) {
                int measuredWidth = getMeasuredWidth() - AndroidUtilities.dp(87.0f);
                Drawable drawable = this.arrowDrawable;
                drawable.setBounds(measuredWidth, 0, drawable.getIntrinsicWidth() + measuredWidth, AndroidUtilities.dp(6.0f));
                this.arrowDrawable.draw(c);
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
                c.drawRoundRect(this.rect, AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), this.paint);
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
            this.textPaint.setTypeface(AndroidUtilities.getFontFamily(true));
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
        public void setScaleX(float scaleX) {
            super.setScaleX(scaleX);
            invalidate();
        }

        @Override // android.view.View
        @Keep
        public void setRotationX(float rotationX) {
            this.rotation = rotationX;
            invalidate();
        }

        @Override // android.view.View
        public float getRotationX() {
            return this.rotation;
        }

        public void setCount(int value) {
            StaticLayout staticLayout = new StaticLayout("" + Math.max(1, value), this.textPaint, AndroidUtilities.dp(100.0f), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            this.staticLayout = staticLayout;
            this.width = (int) Math.ceil((double) staticLayout.getLineWidth(0));
            this.height = this.staticLayout.getLineBottom(0);
            AnimatorSet animatorSet = new AnimatorSet();
            if (value == 0) {
                Paint paint = this.paint;
                Property<Paint, Integer> property = AnimationProperties.PAINT_ALPHA;
                animatorSet.playTogether(ObjectAnimator.ofFloat(this, (Property<CounterView, Float>) View.SCALE_X, 0.0f), ObjectAnimator.ofFloat(this, (Property<CounterView, Float>) View.SCALE_Y, 0.0f), ObjectAnimator.ofInt(paint, property, 0), ObjectAnimator.ofInt(this.textPaint, (Property<TextPaint, Integer>) property, 0));
                animatorSet.setInterpolator(new DecelerateInterpolator());
            } else {
                int i = this.currentCount;
                if (i == 0) {
                    Paint paint2 = this.paint;
                    Property<Paint, Integer> property2 = AnimationProperties.PAINT_ALPHA;
                    animatorSet.playTogether(ObjectAnimator.ofFloat(this, (Property<CounterView, Float>) View.SCALE_X, 0.0f, 1.0f), ObjectAnimator.ofFloat(this, (Property<CounterView, Float>) View.SCALE_Y, 0.0f, 1.0f), ObjectAnimator.ofInt(paint2, property2, 0, 255), ObjectAnimator.ofInt(this.textPaint, (Property<TextPaint, Integer>) property2, 0, 255));
                    animatorSet.setInterpolator(new DecelerateInterpolator());
                } else if (value < i) {
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
            this.currentCount = value;
        }

        @Override // android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
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

        protected void onBackgroundStateUpdated(int state) {
            throw null;
        }

        protected void onVisibilityChanged(boolean visible) {
            throw null;
        }

        public PhotoProgressView(View parentView) {
            if (PhotoViewer.decelerateInterpolator == null) {
                DecelerateInterpolator unused = PhotoViewer.decelerateInterpolator = new DecelerateInterpolator(1.5f);
                Paint unused2 = PhotoViewer.progressPaint = new Paint(1);
                PhotoViewer.progressPaint.setStyle(Paint.Style.STROKE);
                PhotoViewer.progressPaint.setStrokeCap(Paint.Cap.ROUND);
                PhotoViewer.progressPaint.setStrokeWidth(AndroidUtilities.dp(3.0f));
                PhotoViewer.progressPaint.setColor(-1);
            }
            this.parent = parentView;
            resetAlphas();
            PlayPauseDrawable playPauseDrawable = new PlayPauseDrawable(28);
            this.playPauseDrawable = playPauseDrawable;
            playPauseDrawable.setDuration(200);
            this.playDrawable = new CombinedDrawable(ContextCompat.getDrawable(PhotoViewer.this.parentActivity, R.drawable.circle_big).mutate(), playPauseDrawable);
        }

        private void updateAnimation(boolean withProgressAnimation) {
            boolean z;
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = jCurrentTimeMillis - this.lastUpdateTime;
            if (j > 18) {
                j = 18;
            }
            this.lastUpdateTime = jCurrentTimeMillis;
            int i = 0;
            if (withProgressAnimation) {
                if (this.animatedProgressValue == 1.0f && this.currentProgress == 1.0f) {
                    z = false;
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
                    z = true;
                }
                float f3 = this.animatedAlphaValue;
                if (f3 > 0.0f && this.previousBackgroundState != -2) {
                    float f4 = f3 - (j / 200.0f);
                    this.animatedAlphaValue = f4;
                    if (f4 <= 0.0f) {
                        this.animatedAlphaValue = 0.0f;
                        this.previousBackgroundState = -2;
                    }
                    z = true;
                }
            } else {
                z = false;
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
                z = true;
                i++;
            }
            if (z) {
                this.parent.postInvalidateOnAnimation();
            }
        }

        public void setProgress(float value, boolean animated) {
            if (!animated) {
                this.animatedProgressValue = value;
                this.animationProgressStart = value;
            } else {
                this.animationProgressStart = this.animatedProgressValue;
            }
            this.currentProgress = value;
            this.currentProgressTime = 0L;
            this.parent.invalidate();
        }

        public void setBackgroundState(int state, boolean animated, boolean animateIcon) {
            int i;
            int i2 = this.backgroundState;
            if (i2 == state) {
                return;
            }
            PlayPauseDrawable playPauseDrawable = this.playPauseDrawable;
            if (playPauseDrawable != null) {
                boolean z = animateIcon && (i2 == 3 || i2 == 4);
                if (state == 3) {
                    playPauseDrawable.setPause(false, z);
                } else if (state == 4) {
                    playPauseDrawable.setPause(true, z);
                }
                this.playPauseDrawable.setParent(this.parent);
                this.playPauseDrawable.invalidateSelf();
            }
            this.lastUpdateTime = System.currentTimeMillis();
            if (animated && (i = this.backgroundState) != state) {
                this.previousBackgroundState = i;
                this.animatedAlphaValue = 1.0f;
            } else {
                this.previousBackgroundState = -2;
            }
            this.backgroundState = state;
            onBackgroundStateUpdated(state);
            this.parent.invalidate();
        }

        public void setAlpha(float value) {
            setIndexedAlpha(0, value, false);
        }

        public void setScale(float value) {
            this.scale = value;
        }

        public void setIndexedAlpha(int index, float alpha, boolean animated) {
            float[] fArr = this.alphas;
            if (fArr[index] != alpha) {
                fArr[index] = alpha;
                if (!animated) {
                    this.animAlphas[index] = alpha;
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
            this.adjustPanLayoutHelper = new AdjustPanLayoutHelper(this) { // from class: ir.eitaa.ui.PhotoViewer.FrameLayoutDrawer.1
                @Override // ir.eitaa.ui.ActionBar.AdjustPanLayoutHelper
                protected void onPanTranslationUpdate(float y, float progress, boolean keyboardVisible) {
                    PhotoViewer.this.currentPanTranslationY = y;
                    if (PhotoViewer.this.currentEditMode != 3) {
                        PhotoViewer.this.actionBar.setTranslationY(y);
                    }
                    if (PhotoViewer.this.miniProgressView != null) {
                        PhotoViewer.this.miniProgressView.setTranslationY(y);
                    }
                    if (PhotoViewer.this.progressView != null) {
                        PhotoViewer.this.progressView.setTranslationY(y);
                    }
                    if (PhotoViewer.this.checkImageView != null) {
                        PhotoViewer.this.checkImageView.setTranslationY(y);
                    }
                    if (PhotoViewer.this.photosCounterView != null) {
                        PhotoViewer.this.photosCounterView.setTranslationY(y);
                    }
                    if (PhotoViewer.this.selectedPhotosListView != null) {
                        PhotoViewer.this.selectedPhotosListView.setTranslationY(y);
                    }
                    if (PhotoViewer.this.aspectRatioFrameLayout != null) {
                        PhotoViewer.this.aspectRatioFrameLayout.setTranslationY(y);
                    }
                    if (PhotoViewer.this.textureImageView != null) {
                        PhotoViewer.this.textureImageView.setTranslationY(y);
                    }
                    if (PhotoViewer.this.photoCropView != null) {
                        PhotoViewer.this.photoCropView.setTranslationY(y);
                    }
                    if (PhotoViewer.this.photoFilterView != null) {
                        PhotoViewer.this.photoFilterView.setTranslationY(y);
                    }
                    if (PhotoViewer.this.pickerView != null) {
                        PhotoViewer.this.pickerView.setTranslationY(y);
                    }
                    if (PhotoViewer.this.pickerViewSendButton != null) {
                        PhotoViewer.this.pickerViewSendButton.setTranslationY(y);
                    }
                    if (PhotoViewer.this.currentEditMode == 3) {
                        if (PhotoViewer.this.captionEditText != null) {
                            PhotoViewer.this.captionEditText.setTranslationY(y);
                        }
                        if (PhotoViewer.this.photoPaintView != null) {
                            PhotoViewer.this.photoPaintView.setTranslationY(0.0f);
                            PhotoViewer.this.photoPaintView.getColorPicker().setTranslationY(y);
                            PhotoViewer.this.photoPaintView.getToolsView().setTranslationY(y);
                            PhotoViewer.this.photoPaintView.getCurtainView().setTranslationY(y);
                        }
                    } else {
                        if (PhotoViewer.this.photoPaintView != null) {
                            PhotoViewer.this.photoPaintView.setTranslationY(y);
                        }
                        if (PhotoViewer.this.captionEditText != null) {
                            PhotoViewer.this.captionEditText.setAlpha(progress >= 0.5f ? (progress - 0.5f) / 0.5f : 0.0f);
                            PhotoViewer.this.captionEditText.setTranslationY((y - this.keyboardSize) + (AndroidUtilities.dp(r0 / 2.0f) * (1.0f - progress)));
                        }
                    }
                    if (PhotoViewer.this.muteItem != null) {
                        PhotoViewer.this.muteItem.setTranslationY(y);
                    }
                    if (PhotoViewer.this.cameraItem != null) {
                        PhotoViewer.this.cameraItem.setTranslationY(y);
                    }
                    if (PhotoViewer.this.captionLimitView != null) {
                        PhotoViewer.this.captionLimitView.setTranslationY(y);
                    }
                    FrameLayoutDrawer.this.invalidate();
                }

                @Override // ir.eitaa.ui.ActionBar.AdjustPanLayoutHelper
                protected void onTransitionStart(boolean keyboardVisible, int contentHeight) {
                    int i;
                    String str;
                    PhotoViewer.this.windowView.setClipChildren(false);
                    if (PhotoViewer.this.captionEditText.getTag() == null || !keyboardVisible) {
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
                            i = R.string.GifCaption;
                            str = "GifCaption";
                        } else {
                            i = R.string.VideoCaption;
                            str = "VideoCaption";
                        }
                        PhotoViewer.this.actionBar.setTitleAnimated(LocaleController.getString(str, i), true, 220L);
                    } else {
                        PhotoViewer.this.actionBar.setTitleAnimated(LocaleController.getString("PhotoCaption", R.string.PhotoCaption), true, 220L);
                    }
                    PhotoViewer.this.captionEditText.setAlpha(0.0f);
                    PhotoViewer.this.checkImageView.animate().alpha(0.0f).setDuration(220L).start();
                    PhotoViewer.this.photosCounterView.animate().alpha(0.0f).setDuration(220L).start();
                    PhotoViewer.this.selectedPhotosListView.animate().alpha(0.0f).translationY(-AndroidUtilities.dp(10.0f)).setDuration(220L).start();
                }

                @Override // ir.eitaa.ui.ActionBar.AdjustPanLayoutHelper
                protected void onTransitionEnd() {
                    super.onTransitionEnd();
                    PhotoViewer.this.windowView.setClipChildren(true);
                    if (PhotoViewer.this.captionEditText.getTag() == null) {
                        PhotoViewer.this.captionEditText.setVisibility(8);
                    }
                    PhotoViewer.this.captionEditText.setTranslationY(0.0f);
                }

                @Override // ir.eitaa.ui.ActionBar.AdjustPanLayoutHelper
                protected boolean heightAnimationEnabled() {
                    return !PhotoViewer.this.captionEditText.isPopupShowing() && PhotoViewer.this.keyboardAnimationEnabled;
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
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.PhotoViewer.FrameLayoutDrawer.onMeasure(int, int):void");
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x008f  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x009d  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00b1  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00be  */
        @Override // ir.eitaa.ui.Components.SizeNotifierFrameLayoutPhoto, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected void onLayout(boolean r16, int r17, int r18, int r19, int r20) {
            /*
                Method dump skipped, instructions count: 437
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.PhotoViewer.FrameLayoutDrawer.onLayout(boolean, int, int, int, int):void");
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
        protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
            if (child == PhotoViewer.this.mentionListView || child == PhotoViewer.this.captionEditText) {
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
                if (child == PhotoViewer.this.mentionListView) {
                    canvas.save();
                    canvas.clipRect(child.getX(), child.getY(), child.getX() + child.getWidth(), child.getY() + child.getHeight());
                    boolean zDrawChild = super.drawChild(canvas, child, drawingTime);
                    canvas.restore();
                    return zDrawChild;
                }
            } else if (child == PhotoViewer.this.cameraItem || child == PhotoViewer.this.muteItem || child == PhotoViewer.this.pickerView || child == PhotoViewer.this.videoTimelineView || child == PhotoViewer.this.pickerViewSendButton || child == PhotoViewer.this.captionLimitView || child == PhotoViewer.this.captionTextViewSwitcher || (PhotoViewer.this.muteItem.getVisibility() == 0 && child == PhotoViewer.this.bottomLayout)) {
                if (PhotoViewer.this.captionEditText.isPopupAnimatig()) {
                    child.setTranslationY(PhotoViewer.this.captionEditText.getEmojiPadding());
                    PhotoViewer.this.bottomTouchEnabled = false;
                } else {
                    int emojiPadding = (getKeyboardHeight() > AndroidUtilities.dp(20.0f) || AndroidUtilities.isInMultiwindow) ? 0 : PhotoViewer.this.captionEditText.getEmojiPadding();
                    if (PhotoViewer.this.captionEditText.isPopupShowing() || (((AndroidUtilities.isInMultiwindow || AndroidUtilities.usingHardwareInput) && PhotoViewer.this.captionEditText.getTag() != null) || getKeyboardHeight() > AndroidUtilities.dp(80.0f) || emojiPadding != 0)) {
                        PhotoViewer.this.bottomTouchEnabled = false;
                        return false;
                    }
                    PhotoViewer.this.bottomTouchEnabled = true;
                }
            } else if (child == PhotoViewer.this.checkImageView || child == PhotoViewer.this.photosCounterView) {
                if (PhotoViewer.this.captionEditText.getTag() != null) {
                    PhotoViewer.this.bottomTouchEnabled = false;
                    return child.getAlpha() > 0.0f;
                }
                PhotoViewer.this.bottomTouchEnabled = true;
            } else if (child == PhotoViewer.this.miniProgressView) {
                return false;
            }
            if (child != PhotoViewer.this.videoTimelineView || PhotoViewer.this.videoTimelineView.getTranslationY() <= 0.0f || PhotoViewer.this.pickerView.getTranslationY() != 0.0f) {
                try {
                    if (child != PhotoViewer.this.aspectRatioFrameLayout && child != PhotoViewer.this.paintingOverlay) {
                        if (super.drawChild(canvas, child, drawingTime)) {
                            return true;
                        }
                    }
                    return false;
                } catch (Throwable unused) {
                    return true;
                }
            }
            canvas.save();
            canvas.clipRect(PhotoViewer.this.videoTimelineView.getX(), PhotoViewer.this.videoTimelineView.getY(), PhotoViewer.this.videoTimelineView.getX() + PhotoViewer.this.videoTimelineView.getMeasuredWidth(), PhotoViewer.this.videoTimelineView.getBottom());
            boolean zDrawChild2 = super.drawChild(canvas, child, drawingTime);
            canvas.restore();
            return zDrawChild2;
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
            Bulletin.addDelegate(this, new Bulletin.Delegate() { // from class: ir.eitaa.ui.PhotoViewer.FrameLayoutDrawer.2
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

        @Override // ir.eitaa.ui.Components.SizeNotifierFrameLayoutPhoto
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
            VPC_PROGRESS = new FloatProperty<VideoPlayerControlFrameLayout>(str) { // from class: ir.eitaa.ui.PhotoViewer.8
                @Override // android.util.FloatProperty
                public void setValue(VideoPlayerControlFrameLayout object, float value) {
                    object.setProgress(value);
                }

                @Override // android.util.Property
                public Float get(VideoPlayerControlFrameLayout object) {
                    return Float.valueOf(object.getProgress());
                }
            };
        } else {
            VPC_PROGRESS = new Property<VideoPlayerControlFrameLayout, Float>(Float.class, str) { // from class: ir.eitaa.ui.PhotoViewer.9
                @Override // android.util.Property
                public void set(VideoPlayerControlFrameLayout object, Float value) {
                    object.setProgress(value.floatValue());
                }

                @Override // android.util.Property
                public Float get(VideoPlayerControlFrameLayout object) {
                    return Float.valueOf(object.getProgress());
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
        public boolean onTouchEvent(MotionEvent event) {
            if (this.progress < 1.0f) {
                return false;
            }
            if (PhotoViewer.this.videoPlayerSeekbar.onTouch(event.getAction(), event.getX() - AndroidUtilities.dp(2.0f), event.getY())) {
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
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
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
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
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
        protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
            super.onLayout(changed, left, top, right, bottom);
            float currentPosition = PhotoViewer.this.videoPlayer != null ? PhotoViewer.this.videoPlayer.getCurrentPosition() / PhotoViewer.this.videoPlayer.getDuration() : 0.0f;
            if (PhotoViewer.this.playerWasReady) {
                PhotoViewer.this.videoPlayerSeekbar.setProgress(currentPosition);
            }
            PhotoViewer.this.videoTimelineView.setProgress(currentPosition);
        }

        public float getProgress() {
            return this.progress;
        }

        public void setProgress(float progress) {
            if (this.progress != progress) {
                this.progress = progress;
                onProgressChanged(progress);
            }
        }

        private void onProgressChanged(float progress) {
            PhotoViewer.this.videoPlayerTime.setAlpha(progress);
            PhotoViewer.this.exitFullscreenButton.setAlpha(progress);
            if (this.seekBarTransitionEnabled) {
                PhotoViewer.this.videoPlayerTime.setPivotX(PhotoViewer.this.videoPlayerTime.getWidth());
                PhotoViewer.this.videoPlayerTime.setPivotY(PhotoViewer.this.videoPlayerTime.getHeight());
                float f = 1.0f - progress;
                float f2 = 1.0f - (0.1f * f);
                PhotoViewer.this.videoPlayerTime.setScaleX(f2);
                PhotoViewer.this.videoPlayerTime.setScaleY(f2);
                PhotoViewer.this.videoPlayerSeekbar.setTransitionProgress(f);
                return;
            }
            if (this.translationYAnimationEnabled) {
                setTranslationY(AndroidUtilities.dpf2(24.0f) * (1.0f - progress));
            }
            PhotoViewer.this.videoPlayerSeekbarView.setAlpha(progress);
        }

        public void setSeekBarTransitionEnabled(boolean seekBarTransitionEnabled) {
            if (this.seekBarTransitionEnabled != seekBarTransitionEnabled) {
                this.seekBarTransitionEnabled = seekBarTransitionEnabled;
                if (!seekBarTransitionEnabled) {
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

        public void setTranslationYAnimationEnabled(boolean translationYAnimationEnabled) {
            if (this.translationYAnimationEnabled != translationYAnimationEnabled) {
                this.translationYAnimationEnabled = translationYAnimationEnabled;
                if (!translationYAnimationEnabled) {
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
        public void setVisibility(int visibility) {
            setVisibility(visibility, true);
        }

        public void setVisibility(int visibility, boolean withScrollView) {
            super.setVisibility(visibility);
            if (this.inScrollView && withScrollView) {
                PhotoViewer.this.captionScrollView.setVisibility(visibility);
            }
        }

        @Override // android.view.View
        public void setAlpha(float alpha) {
            this.alpha = alpha;
            if (this.inScrollView) {
                PhotoViewer.this.captionScrollView.setAlpha(alpha);
            } else {
                super.setAlpha(alpha);
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
        public void setTranslationY(float translationY) {
            super.setTranslationY(translationY);
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

        public CaptionScrollView(Context context) throws NoSuchFieldException, NoSuchMethodException, SecurityException {
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
            springAnimation.addUpdateListener(new DynamicAnimation.OnAnimationUpdateListener() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$CaptionScrollView$4wh_suOpk3xjm6TX5rJYAGlPgpI
                @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
                public final void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f2) {
                    this.f$0.lambda$new$0$PhotoViewer$CaptionScrollView(dynamicAnimation, f, f2);
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
        /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$0$PhotoViewer$CaptionScrollView(DynamicAnimation dynamicAnimation, float f, float f2) {
            this.overScrollY = f;
            this.velocityY = f2;
        }

        @Override // androidx.core.widget.NestedScrollView, android.view.View
        public boolean onTouchEvent(MotionEvent ev) {
            if (ev.getAction() != 0 || ev.getY() >= (PhotoViewer.this.captionContainer.getTop() - getScrollY()) + PhotoViewer.this.captionTextViewSwitcher.getTranslationY()) {
                return super.onTouchEvent(ev);
            }
            return false;
        }

        @Override // androidx.core.widget.NestedScrollView, android.widget.FrameLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            updateTopMargin(View.MeasureSpec.getSize(widthMeasureSpec), View.MeasureSpec.getSize(heightMeasureSpec));
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
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

        private void updateTopMargin(int width, int height) {
            int iCalculateNewContainerMarginTop = calculateNewContainerMarginTop(width, height);
            if (iCalculateNewContainerMarginTop >= 0) {
                if (!this.dontChangeTopMargin) {
                    ((ViewGroup.MarginLayoutParams) PhotoViewer.this.captionContainer.getLayoutParams()).topMargin = iCalculateNewContainerMarginTop;
                    this.pendingTopMargin = -1;
                } else {
                    this.pendingTopMargin = iCalculateNewContainerMarginTop;
                }
            }
        }

        public int calculateNewContainerMarginTop(int width, int height) {
            int iDp;
            if (width == 0 || height == 0) {
                return -1;
            }
            TextView currentView = PhotoViewer.this.captionTextViewSwitcher.getCurrentView();
            CharSequence text = currentView.getText();
            int iHashCode = text.hashCode();
            Point point = AndroidUtilities.displaySize;
            boolean z = point.x > point.y;
            if (this.textHash == iHashCode && this.isLandscape == z && this.prevHeight == height) {
                return -1;
            }
            this.textHash = iHashCode;
            this.isLandscape = z;
            this.prevHeight = height;
            currentView.measure(View.MeasureSpec.makeMeasureSpec(width, 1073741824), View.MeasureSpec.makeMeasureSpec(height, Integer.MIN_VALUE));
            Layout layout = currentView.getLayout();
            int lineCount = layout.getLineCount();
            if ((z && lineCount <= 2) || (!z && lineCount <= 5)) {
                iDp = currentView.getMeasuredHeight();
            } else {
                int iMin = Math.min(z ? 2 : 5, lineCount);
                loop0: while (iMin > 1) {
                    int i = iMin - 1;
                    for (int lineStart = layout.getLineStart(i); lineStart < layout.getLineEnd(i); lineStart++) {
                        if (Character.isLetterOrDigit(text.charAt(lineStart))) {
                            break loop0;
                        }
                    }
                    iMin--;
                }
                height -= currentView.getPaint().getFontMetricsInt(null) * iMin;
                iDp = AndroidUtilities.dp(8.0f);
            }
            return height - iDp;
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
        public void fling(int velocityY) {
            super.fling(velocityY);
            this.velocitySign = Math.signum(velocityY);
            this.velocityY = 0.0f;
        }

        @Override // androidx.core.widget.NestedScrollView
        public boolean dispatchNestedPreScroll(int dx, int dy, int[] consumed, int[] offsetInWindow, int type) {
            consumed[1] = 0;
            if (this.nestedScrollStarted) {
                float f = this.overScrollY;
                if ((f > 0.0f && dy > 0) || (f < 0.0f && dy < 0)) {
                    float f2 = dy;
                    float f3 = f - f2;
                    if (f > 0.0f) {
                        if (f3 < 0.0f) {
                            this.overScrollY = 0.0f;
                            consumed[1] = (int) (consumed[1] + f2 + f3);
                        } else {
                            this.overScrollY = f3;
                            consumed[1] = consumed[1] + dy;
                        }
                    } else if (f3 > 0.0f) {
                        this.overScrollY = 0.0f;
                        consumed[1] = (int) (consumed[1] + f2 + f3);
                    } else {
                        this.overScrollY = f3;
                        consumed[1] = consumed[1] + dy;
                    }
                    PhotoViewer.this.captionTextViewSwitcher.setTranslationY(this.overScrollY);
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.core.widget.NestedScrollView
        public void dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow, int type, int[] consumed) {
            float f;
            if (dyUnconsumed != 0) {
                int iRound = Math.round(dyUnconsumed * (1.0f - Math.abs((-this.overScrollY) / (PhotoViewer.this.captionContainer.getTop() - ((PhotoViewer.this.isStatusBarVisible() ? AndroidUtilities.statusBarHeight : 0) + ActionBar.getCurrentActionBarHeight())))));
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

        private void startSpringAnimationIfNotRunning(float velocityY) {
            if (this.springAnimation.isRunning()) {
                return;
            }
            this.springAnimation.setStartVelocity(velocityY);
            this.springAnimation.start();
        }

        @Override // androidx.core.widget.NestedScrollView
        public boolean startNestedScroll(int axes, int type) {
            if (type == 0) {
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
        public void stopNestedScroll(int type) {
            OverScroller overScroller;
            if (this.nestedScrollStarted && type == 0) {
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
                boolean z2 = scrollY == 0 && translationY == 0.0f;
                if (!z) {
                    int y = PhotoViewer.this.photoProgressViews[0].getY() + PhotoViewer.this.photoProgressViews[0].size;
                    int top = (((PhotoViewer.this.captionContainer.getTop() + ((int) translationY)) - scrollY) + ((PhotoViewer.this.isStatusBarVisible() ? AndroidUtilities.statusBarHeight : 0) + ActionBar.getCurrentActionBarHeight())) - AndroidUtilities.dp(12.0f);
                    z2 = top > ((int) PhotoViewer.this.fullscreenButton[0].getY()) + AndroidUtilities.dp(32.0f);
                    z = top > y;
                }
                if (PhotoViewer.this.allowShowFullscreenButton) {
                    if (PhotoViewer.this.fullscreenButton[0].getTag() == null || ((Integer) PhotoViewer.this.fullscreenButton[0].getTag()).intValue() != 3 || !z2) {
                        if (PhotoViewer.this.fullscreenButton[0].getTag() == null && !z2) {
                            PhotoViewer.this.fullscreenButton[0].setTag(3);
                            PhotoViewer.this.fullscreenButton[0].animate().alpha(0.0f).setListener(null).setDuration(150L).start();
                        }
                    } else {
                        PhotoViewer.this.fullscreenButton[0].setTag(2);
                        PhotoViewer.this.fullscreenButton[0].animate().alpha(1.0f).setDuration(150L).setListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.PhotoViewer.CaptionScrollView.1
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animation) {
                                PhotoViewer.this.fullscreenButton[0].setTag(null);
                            }
                        }).start();
                    }
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

    /* JADX WARN: Removed duplicated region for block: B:154:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x0611  */
    /* JADX WARN: Removed duplicated region for block: B:426:0x02af A[SYNTHETIC] */
    @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void didReceivedNotification(int r21, int r22, java.lang.Object... r23) throws java.lang.InterruptedException, android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 2094
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.PhotoViewer.didReceivedNotification(int, int, java.lang.Object[]):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDownloadAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.parentActivity, this.resourcesProvider);
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
                        intent.putExtra("android.intent.extra.STREAM", FileProvider.getUriForFile(this.parentActivity, "ir.eitaa.messenger.provider", file));
                        intent.setFlags(1);
                    } catch (Exception unused) {
                        intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(file));
                    }
                } else {
                    intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(file));
                }
                this.parentActivity.startActivityForResult(Intent.createChooser(intent, LocaleController.getString("ShareFile", R.string.ShareFile)), 500);
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

    public void setParentAlert(ChatAttachAlert alert) {
        this.parentAlert = alert;
    }

    public void setParentActivity(final Activity activity) throws Resources.NotFoundException {
        setParentActivity(activity, null);
    }

    public void setParentActivity(final Activity activity, final Theme.ResourcesProvider resourcesProvider) throws Resources.NotFoundException {
        int i = 0;
        Theme.createChatResources(activity, false);
        this.resourcesProvider = resourcesProvider;
        int i2 = UserConfig.selectedAccount;
        this.currentAccount = i2;
        this.centerImage.setCurrentAccount(i2);
        this.leftImage.setCurrentAccount(this.currentAccount);
        this.rightImage.setCurrentAccount(this.currentAccount);
        if (this.parentActivity == activity || activity == null) {
            return;
        }
        this.inBubbleMode = activity instanceof BubbleActivity;
        this.parentActivity = activity;
        this.activityContext = new ContextThemeWrapper(this.parentActivity, R.style.Theme_TMessages);
        this.touchSlop = ViewConfiguration.get(this.parentActivity).getScaledTouchSlop();
        boolean z = true;
        if (progressDrawables == null) {
            progressDrawables = new Drawable[]{ContextCompat.getDrawable(this.parentActivity, R.drawable.circle_big), ContextCompat.getDrawable(this.parentActivity, R.drawable.cancel_big), ContextCompat.getDrawable(this.parentActivity, R.drawable.load_big)};
        }
        this.scroller = new Scroller(activity);
        AnonymousClass10 anonymousClass10 = new AnonymousClass10(activity);
        this.windowView = anonymousClass10;
        anonymousClass10.setBackgroundDrawable(this.backgroundDrawable);
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
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 21) {
            this.containerView.setFitsSystemWindows(true);
            this.containerView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$FQkM4HZcC8I3I_sC_hRlO__999c
                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    return this.f$0.lambda$setParentActivity$2$PhotoViewer(view, windowInsets);
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
        if (i3 >= 28) {
            layoutParams.layoutInDisplayCutoutMode = 1;
        }
        if (i3 >= 21) {
            layoutParams.flags = -2147286784;
        } else {
            layoutParams.flags = 131072;
        }
        PaintingOverlay paintingOverlay = new PaintingOverlay(this.parentActivity);
        this.paintingOverlay = paintingOverlay;
        this.containerView.addView(paintingOverlay, LayoutHelper.createFrame(-2, -2.0f));
        ActionBar actionBar = new ActionBar(activity) { // from class: ir.eitaa.ui.PhotoViewer.11
            @Override // android.view.View
            public void setAlpha(float alpha) {
                super.setAlpha(alpha);
                PhotoViewer.this.containerView.invalidate();
            }
        };
        this.actionBar = actionBar;
        actionBar.setOverlayTitleAnimation(true);
        this.actionBar.setTitleColor(-1);
        this.actionBar.setSubtitleColor(-1);
        this.actionBar.setBackgroundColor(2130706432);
        this.actionBar.setOccupyStatusBar(isStatusBarVisible());
        this.actionBar.setItemsBackgroundColor(1090519039, false);
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setTitle(LocaleController.formatString("Of", R.string.Of, 1, 1));
        this.containerView.addView(this.actionBar, LayoutHelper.createFrame(-1, -2.0f));
        this.actionBar.setActionBarMenuOnItemClick(new AnonymousClass12(resourcesProvider));
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
        this.menuItem = actionBarMenuCreateMenu.addItem(0, R.drawable.ic_ab_other);
        ActionBarMenuItem actionBarMenuItem = new ActionBarMenuItem(this.parentActivity, (ActionBarMenu) null, 0, 0, resourcesProvider);
        this.menuItemSpeed = actionBarMenuItem;
        actionBarMenuItem.setDelegate(new ActionBarMenuItem.ActionBarMenuItemDelegate() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$OiUC76yf4pJOBvEy7CF6ncrFgs8
            @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemDelegate
            public final void onItemClick(int i4) {
                this.f$0.lambda$setParentActivity$3$PhotoViewer(i4);
            }
        });
        this.menuItem.addView(this.menuItemSpeed);
        this.menuItemSpeed.setVisibility(4);
        ActionBarMenuSubItem actionBarMenuSubItemAddSubItem = this.menuItem.addSubItem(19, R.drawable.msg_speed, null, LocaleController.getString("Speed", R.string.Speed), true, false);
        this.speedItem = actionBarMenuSubItemAddSubItem;
        actionBarMenuSubItemAddSubItem.setSubtext(LocaleController.getString("SpeedNormal", R.string.SpeedNormal));
        this.speedItem.setItemHeight(56);
        this.speedItem.setTag(R.id.width_tag, 240);
        this.speedItem.setColors(-328966, -328966);
        this.speedItem.setRightIcon(R.drawable.msg_arrowright);
        this.speedGap = this.menuItem.addGap(20);
        this.menuItem.getPopupLayout().setFitItems(true);
        this.speedItems[0] = this.menuItemSpeed.addSubItem(21, R.drawable.msg_speed_0_2, LocaleController.getString("SpeedVerySlow", R.string.SpeedVerySlow)).setColors(-328966, -328966);
        this.speedItems[1] = this.menuItemSpeed.addSubItem(22, R.drawable.msg_speed_0_5, LocaleController.getString("SpeedSlow", R.string.SpeedSlow)).setColors(-328966, -328966);
        this.speedItems[2] = this.menuItemSpeed.addSubItem(23, R.drawable.msg_speed_1, LocaleController.getString("SpeedNormal", R.string.SpeedNormal)).setColors(-328966, -328966);
        this.speedItems[3] = this.menuItemSpeed.addSubItem(24, R.drawable.msg_speed_1_5, LocaleController.getString("SpeedFast", R.string.SpeedFast)).setColors(-328966, -328966);
        this.speedItems[4] = this.menuItemSpeed.addSubItem(25, R.drawable.msg_speed_2, LocaleController.getString("SpeedVeryFast", R.string.SpeedVeryFast)).setColors(-328966, -328966);
        this.menuItem.addSubItem(11, R.drawable.msg_openin, LocaleController.getString("OpenInExternalApp", R.string.OpenInExternalApp)).setColors(-328966, -328966);
        this.menuItem.setContentDescription(LocaleController.getString("AccDescrMoreOptions", R.string.AccDescrMoreOptions));
        ActionBarMenuSubItem actionBarMenuSubItemAddSubItem2 = this.menuItem.addSubItem(2, R.drawable.msg_media, LocaleController.getString("ShowAllMedia", R.string.ShowAllMedia));
        this.allMediaItem = actionBarMenuSubItemAddSubItem2;
        actionBarMenuSubItemAddSubItem2.setColors(-328966, -328966);
        this.menuItem.addSubItem(14, R.drawable.msg_gif, LocaleController.getString("SaveToGIFs", R.string.SaveToGIFs)).setColors(-328966, -328966);
        this.menuItem.addSubItem(4, R.drawable.msg_message, LocaleController.getString("ShowInChat", R.string.ShowInChat)).setColors(-328966, -328966);
        this.menuItem.addSubItem(15, R.drawable.msg_sticker, LocaleController.getString("ShowStickers", R.string.ShowStickers)).setColors(-328966, -328966);
        this.menuItem.addSubItem(10, R.drawable.msg_shareout, LocaleController.getString("ShareFile", R.string.ShareFile)).setColors(-328966, -328966);
        this.menuItem.addSubItem(1, R.drawable.msg_gallery, LocaleController.getString("SaveToGallery", R.string.SaveToGallery)).setColors(-328966, -328966);
        this.menuItem.addSubItem(16, R.drawable.menu_private, LocaleController.getString("SetAsMain", R.string.SetAsMain)).setColors(-328966, -328966);
        this.menuItem.addSubItem(6, R.drawable.msg_delete, LocaleController.getString("Delete", R.string.Delete)).setColors(-328966, -328966);
        this.menuItem.addSubItem(7, R.drawable.msg_cancel, LocaleController.getString("StopDownload", R.string.StopDownload)).setColors(-328966, -328966);
        this.menuItem.redrawPopup(-115203550);
        this.menuItemSpeed.redrawPopup(-115203550);
        setMenuItemIcon();
        this.menuItem.setSubMenuDelegate(new ActionBarMenuItem.ActionBarSubMenuItemDelegate() { // from class: ir.eitaa.ui.PhotoViewer.13
            @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarSubMenuItemDelegate
            public void onShowSubMenu() {
                if (PhotoViewer.this.videoPlayerControlVisible && PhotoViewer.this.isPlaying) {
                    AndroidUtilities.cancelRunOnUIThread(PhotoViewer.this.hideActionBarRunnable);
                }
            }

            @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarSubMenuItemDelegate
            public void onHideSubMenu() {
                if (PhotoViewer.this.videoPlayerControlVisible && PhotoViewer.this.isPlaying) {
                    PhotoViewer.this.scheduleActionBarHide();
                }
            }
        });
        FrameLayout frameLayout = new FrameLayout(this.activityContext) { // from class: ir.eitaa.ui.PhotoViewer.14
            @Override // android.view.ViewGroup
            protected void measureChildWithMargins(View child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) {
                if (child == PhotoViewer.this.nameTextView || child == PhotoViewer.this.dateTextView) {
                    widthUsed = PhotoViewer.this.bottomButtonsLayout.getMeasuredWidth();
                }
                super.measureChildWithMargins(child, parentWidthMeasureSpec, widthUsed, parentHeightMeasureSpec, heightUsed);
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
        this.groupedPhotosListView.setDelegate(new GroupedPhotosListView.GroupedPhotosListViewDelegate() { // from class: ir.eitaa.ui.PhotoViewer.15
            @Override // ir.eitaa.ui.Components.GroupedPhotosListView.GroupedPhotosListViewDelegate
            public int getCurrentIndex() {
                return PhotoViewer.this.currentIndex;
            }

            @Override // ir.eitaa.ui.Components.GroupedPhotosListView.GroupedPhotosListViewDelegate
            public int getCurrentAccount() {
                return PhotoViewer.this.currentAccount;
            }

            @Override // ir.eitaa.ui.Components.GroupedPhotosListView.GroupedPhotosListViewDelegate
            public long getAvatarsDialogId() {
                return PhotoViewer.this.avatarsDialogId;
            }

            @Override // ir.eitaa.ui.Components.GroupedPhotosListView.GroupedPhotosListViewDelegate
            public int getSlideshowMessageId() {
                return PhotoViewer.this.slideshowMessageId;
            }

            @Override // ir.eitaa.ui.Components.GroupedPhotosListView.GroupedPhotosListViewDelegate
            public ArrayList<ImageLocation> getImagesArrLocations() {
                return PhotoViewer.this.imagesArrLocations;
            }

            @Override // ir.eitaa.ui.Components.GroupedPhotosListView.GroupedPhotosListViewDelegate
            public ArrayList<MessageObject> getImagesArr() {
                return PhotoViewer.this.imagesArr;
            }

            @Override // ir.eitaa.ui.Components.GroupedPhotosListView.GroupedPhotosListViewDelegate
            public List<TLRPC$PageBlock> getPageBlockArr() {
                if (PhotoViewer.this.pageBlocksAdapter != null) {
                    return PhotoViewer.this.pageBlocksAdapter.getAll();
                }
                return null;
            }

            @Override // ir.eitaa.ui.Components.GroupedPhotosListView.GroupedPhotosListViewDelegate
            public Object getParentObject() {
                if (PhotoViewer.this.pageBlocksAdapter != null) {
                    return PhotoViewer.this.pageBlocksAdapter.getParentObject();
                }
                return null;
            }

            @Override // ir.eitaa.ui.Components.GroupedPhotosListView.GroupedPhotosListViewDelegate
            public void setCurrentIndex(int index) throws InterruptedException, Resources.NotFoundException {
                PhotoViewer.this.currentIndex = -1;
                if (PhotoViewer.this.currentThumb != null) {
                    PhotoViewer.this.currentThumb.release();
                    PhotoViewer.this.currentThumb = null;
                }
                PhotoViewer.this.dontAutoPlay = true;
                PhotoViewer.this.setImageIndex(index);
                PhotoViewer.this.dontAutoPlay = false;
            }

            @Override // ir.eitaa.ui.Components.GroupedPhotosListView.GroupedPhotosListViewDelegate
            public void onShowAnimationStart() {
                PhotoViewer.this.containerView.requestLayout();
            }

            @Override // ir.eitaa.ui.Components.GroupedPhotosListView.GroupedPhotosListViewDelegate
            public void onStopScrolling() {
                PhotoViewer photoViewer = PhotoViewer.this;
                if (photoViewer.shouldMessageObjectAutoPlayed(photoViewer.currentMessageObject)) {
                    PhotoViewer.this.playerAutoStarted = true;
                    PhotoViewer.this.onActionClick(true);
                    PhotoViewer.this.checkProgress(0, false, true);
                }
            }

            @Override // ir.eitaa.ui.Components.GroupedPhotosListView.GroupedPhotosListViewDelegate
            public boolean validGroupId(long groupId) {
                if (PhotoViewer.this.placeProvider != null) {
                    return PhotoViewer.this.placeProvider.validateGroupId(groupId);
                }
                return true;
            }
        });
        for (int i4 = 0; i4 < 3; i4++) {
            this.fullscreenButton[i4] = new ImageView(this.parentActivity);
            this.fullscreenButton[i4].setImageResource(R.drawable.msg_maxvideo);
            this.fullscreenButton[i4].setContentDescription(LocaleController.getString("AccSwitchToFullscreen", R.string.AccSwitchToFullscreen));
            this.fullscreenButton[i4].setScaleType(ImageView.ScaleType.CENTER);
            this.fullscreenButton[i4].setBackground(Theme.createSelectorDrawable(1090519039));
            this.fullscreenButton[i4].setVisibility(4);
            this.fullscreenButton[i4].setAlpha(1.0f);
            this.containerView.addView(this.fullscreenButton[i4], LayoutHelper.createFrame(48, 48.0f));
            this.fullscreenButton[i4].setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$cUYliumviLd_nc2J759fdHH871c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setParentActivity$4$PhotoViewer(view);
                }
            });
        }
        final CaptionLinkMovementMethod captionLinkMovementMethod = new CaptionLinkMovementMethod();
        CaptionTextViewSwitcher captionTextViewSwitcher = new CaptionTextViewSwitcher(this.containerView.getContext());
        this.captionTextViewSwitcher = captionTextViewSwitcher;
        captionTextViewSwitcher.setFactory(new ViewSwitcher.ViewFactory() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$cEklstpb7ge3zMON3I5a1BdekfA
            @Override // android.widget.ViewSwitcher.ViewFactory
            public final View makeView() {
                return this.f$0.lambda$setParentActivity$5$PhotoViewer(captionLinkMovementMethod);
            }
        });
        this.captionTextViewSwitcher.setVisibility(4);
        setCaptionHwLayerEnabled(true);
        for (int i5 = 0; i5 < 3; i5++) {
            this.photoProgressViews[i5] = new PhotoProgressView(this.containerView) { // from class: ir.eitaa.ui.PhotoViewer.16
                @Override // ir.eitaa.ui.PhotoViewer.PhotoProgressView
                protected void onBackgroundStateUpdated(int state) {
                    if (this == PhotoViewer.this.photoProgressViews[0]) {
                        PhotoViewer.this.updateAccessibilityOverlayVisibility();
                    }
                }

                @Override // ir.eitaa.ui.PhotoViewer.PhotoProgressView
                protected void onVisibilityChanged(boolean visible) {
                    if (this == PhotoViewer.this.photoProgressViews[0]) {
                        PhotoViewer.this.updateAccessibilityOverlayVisibility();
                    }
                }
            };
            this.photoProgressViews[i5].setBackgroundState(0, false, true);
        }
        RadialProgressView radialProgressView = new RadialProgressView(this.activityContext, resourcesProvider) { // from class: ir.eitaa.ui.PhotoViewer.17
            @Override // ir.eitaa.ui.Components.RadialProgressView, android.view.View
            public void setAlpha(float alpha) {
                super.setAlpha(alpha);
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
        this.paintButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$ZZQwFD11JrR42N9RilVcwg8L9vo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setParentActivity$6$PhotoViewer(view);
            }
        });
        this.paintButton.setContentDescription(LocaleController.getString("AccDescrPhotoEditor", R.string.AccDescrPhotoEditor));
        ImageView imageView2 = new ImageView(this.containerView.getContext());
        this.shareButton = imageView2;
        imageView2.setImageResource(R.drawable.share);
        this.shareButton.setScaleType(ImageView.ScaleType.CENTER);
        this.shareButton.setBackgroundDrawable(Theme.createSelectorDrawable(1090519039));
        this.bottomButtonsLayout.addView(this.shareButton, LayoutHelper.createFrame(50, -1.0f));
        this.shareButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$6_qWLIs_-T0LorQUoO22tk4WC8w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setParentActivity$7$PhotoViewer(view);
            }
        });
        this.shareButton.setContentDescription(LocaleController.getString("ShareFile", R.string.ShareFile));
        FadingTextViewLayout fadingTextViewLayout = new FadingTextViewLayout(this.containerView.getContext()) { // from class: ir.eitaa.ui.PhotoViewer.18
            @Override // ir.eitaa.ui.Components.FadingTextViewLayout
            protected void onTextViewCreated(TextView textView) {
                super.onTextViewCreated(textView);
                textView.setTextSize(1, 14.0f);
                textView.setTypeface(AndroidUtilities.getFontFamily(true));
                textView.setEllipsize(TextUtils.TruncateAt.END);
                textView.setTextColor(-1);
                textView.setGravity(3);
            }
        };
        this.nameTextView = fadingTextViewLayout;
        this.bottomLayout.addView(fadingTextViewLayout, LayoutHelper.createFrame(-1, -2.0f, 51, 16.0f, 5.0f, 8.0f, 0.0f));
        FadingTextViewLayout fadingTextViewLayout2 = new FadingTextViewLayout(this.containerView.getContext(), z) { // from class: ir.eitaa.ui.PhotoViewer.19
            private LocaleController.LocaleInfo lastLocaleInfo = null;
            private int staticCharsCount = 0;

            @Override // ir.eitaa.ui.Components.FadingTextViewLayout
            protected void onTextViewCreated(TextView textView) {
                super.onTextViewCreated(textView);
                textView.setTextSize(1, 13.0f);
                textView.setEllipsize(TextUtils.TruncateAt.END);
                textView.setTextColor(-1);
                textView.setTypeface(AndroidUtilities.getFontFamily(true));
                textView.setGravity(3);
            }

            @Override // ir.eitaa.ui.Components.FadingTextViewLayout
            protected int getStaticCharsCount() {
                LocaleController.LocaleInfo currentLocaleInfo = LocaleController.getInstance().getCurrentLocaleInfo();
                if (this.lastLocaleInfo != currentLocaleInfo) {
                    this.lastLocaleInfo = currentLocaleInfo;
                    this.staticCharsCount = LocaleController.formatString("formatDateAtTime", R.string.formatDateAtTime, LocaleController.getInstance().formatterYear.format(new Date()), LocaleController.getInstance().formatterDay.format(new Date())).length();
                }
                return this.staticCharsCount;
            }

            @Override // ir.eitaa.ui.Components.FadingTextViewLayout
            public void setText(CharSequence text, boolean animated) {
                int staticCharsCount;
                boolean z2 = false;
                if (animated) {
                    if (!LocaleController.isRTL || (staticCharsCount = getStaticCharsCount()) <= 0 || (text.length() == staticCharsCount && getText() != null && getText().length() == staticCharsCount)) {
                        z2 = true;
                    }
                    setText(text, true, z2);
                    return;
                }
                setText(text, false, false);
            }
        };
        this.dateTextView = fadingTextViewLayout2;
        this.bottomLayout.addView(fadingTextViewLayout2, LayoutHelper.createFrame(-1, -2.0f, 51, 16.0f, 25.0f, 8.0f, 0.0f));
        createVideoControlsInterface();
        RadialProgressView radialProgressView2 = new RadialProgressView(this.parentActivity, resourcesProvider);
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
        this.qualityPicker.doneButton.setTextColor(getThemedColor("dialogFloatingButton"));
        this.containerView.addView(this.qualityPicker, LayoutHelper.createFrame(-1, 48, 83));
        this.qualityPicker.cancelButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$XK7hWmOxs5PM9hYyT0AGQM7JBDU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setParentActivity$8$PhotoViewer(view);
            }
        });
        this.qualityPicker.doneButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$PZe4tZ_rChSlgrT8CPxB7J7T7-Q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setParentActivity$9$PhotoViewer(view);
            }
        });
        VideoForwardDrawable videoForwardDrawable = new VideoForwardDrawable(false);
        this.videoForwardDrawable = videoForwardDrawable;
        videoForwardDrawable.setDelegate(new VideoForwardDrawable.VideoForwardDrawableDelegate() { // from class: ir.eitaa.ui.PhotoViewer.20
            @Override // ir.eitaa.ui.Components.VideoForwardDrawable.VideoForwardDrawableDelegate
            public void onAnimationEnd() {
            }

            @Override // ir.eitaa.ui.Components.VideoForwardDrawable.VideoForwardDrawableDelegate
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
        FrameLayout frameLayout2 = new FrameLayout(this.activityContext) { // from class: ir.eitaa.ui.PhotoViewer.21
            @Override // android.view.ViewGroup, android.view.View
            public boolean dispatchTouchEvent(MotionEvent ev) {
                return PhotoViewer.this.bottomTouchEnabled && super.dispatchTouchEvent(ev);
            }

            @Override // android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent ev) {
                return PhotoViewer.this.bottomTouchEnabled && super.onInterceptTouchEvent(ev);
            }

            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent event) {
                return PhotoViewer.this.bottomTouchEnabled && super.onTouchEvent(event);
            }

            @Override // android.view.View
            public void setTranslationY(float translationY) {
                super.setTranslationY(translationY);
                if (PhotoViewer.this.videoTimelineView != null && PhotoViewer.this.videoTimelineView.getVisibility() != 8) {
                    PhotoViewer.this.videoTimelineView.setTranslationY(translationY);
                    PhotoViewer.this.videoAvatarTooltip.setTranslationY(translationY);
                }
                if (PhotoViewer.this.videoAvatarTooltip == null || PhotoViewer.this.videoAvatarTooltip.getVisibility() == 8) {
                    return;
                }
                PhotoViewer.this.videoAvatarTooltip.setTranslationY(translationY);
            }

            @Override // android.view.View
            public void setAlpha(float alpha) {
                super.setAlpha(alpha);
                if (PhotoViewer.this.videoTimelineView == null || PhotoViewer.this.videoTimelineView.getVisibility() == 8) {
                    return;
                }
                PhotoViewer.this.videoTimelineView.setAlpha(alpha);
            }

            @Override // android.view.View
            public void setVisibility(int visibility) {
                super.setVisibility(visibility);
                if (PhotoViewer.this.videoTimelineView == null || PhotoViewer.this.videoTimelineView.getVisibility() == 8) {
                    return;
                }
                PhotoViewer.this.videoTimelineView.setVisibility(visibility == 0 ? 0 : 4);
            }

            @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
                super.onLayout(changed, left, top, right, bottom);
                if (PhotoViewer.this.itemsLayout.getVisibility() != 8) {
                    int iDp = (((right - left) - AndroidUtilities.dp(70.0f)) - PhotoViewer.this.itemsLayout.getMeasuredWidth()) / 2;
                    PhotoViewer.this.itemsLayout.layout(iDp, PhotoViewer.this.itemsLayout.getTop(), PhotoViewer.this.itemsLayout.getMeasuredWidth() + iDp, PhotoViewer.this.itemsLayout.getTop() + PhotoViewer.this.itemsLayout.getMeasuredHeight());
                }
            }
        };
        this.pickerView = frameLayout2;
        frameLayout2.setBackgroundColor(2130706432);
        this.containerView.addView(this.pickerView, LayoutHelper.createFrame(-1, -2, 83));
        TextView textView = new TextView(this.containerView.getContext());
        this.docNameTextView = textView;
        textView.setTextSize(1, 15.0f);
        this.docNameTextView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.docNameTextView.setSingleLine(true);
        this.docNameTextView.setMaxLines(1);
        this.docNameTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.docNameTextView.setTextColor(-1);
        this.docNameTextView.setGravity(3);
        this.pickerView.addView(this.docNameTextView, LayoutHelper.createFrame(-1, -2.0f, 51, 20.0f, 23.0f, 84.0f, 0.0f));
        TextView textView2 = new TextView(this.containerView.getContext());
        this.docInfoTextView = textView2;
        textView2.setTextSize(1, 14.0f);
        this.docInfoTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.docInfoTextView.setSingleLine(true);
        this.docInfoTextView.setMaxLines(1);
        this.docInfoTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.docInfoTextView.setTextColor(-1);
        this.docInfoTextView.setGravity(3);
        this.pickerView.addView(this.docInfoTextView, LayoutHelper.createFrame(-1, -2.0f, 51, 20.0f, 46.0f, 84.0f, 0.0f));
        VideoTimelinePlayView videoTimelinePlayView = new VideoTimelinePlayView(this.parentActivity) { // from class: ir.eitaa.ui.PhotoViewer.22
            @Override // android.view.View
            public void setTranslationY(float translationY) {
                if (getTranslationY() != translationY) {
                    super.setTranslationY(translationY);
                    PhotoViewer.this.containerView.invalidate();
                }
            }
        };
        this.videoTimelineView = videoTimelinePlayView;
        videoTimelinePlayView.setDelegate(new AnonymousClass23());
        showVideoTimeline(false, false);
        this.videoTimelineView.setBackgroundColor(2130706432);
        this.containerView.addView(this.videoTimelineView, LayoutHelper.createFrame(-1, 58.0f, 83, 0.0f, 8.0f, 0.0f, 0.0f));
        TextView textView3 = new TextView(this.parentActivity);
        this.videoAvatarTooltip = textView3;
        textView3.setSingleLine(true);
        this.videoAvatarTooltip.setVisibility(8);
        this.videoAvatarTooltip.setText(LocaleController.getString("ChooseCover", R.string.ChooseCover));
        this.videoAvatarTooltip.setGravity(1);
        this.videoAvatarTooltip.setTextSize(1, 14.0f);
        this.videoAvatarTooltip.setTypeface(AndroidUtilities.getFontFamily(false));
        this.videoAvatarTooltip.setTextColor(-7566196);
        this.containerView.addView(this.videoAvatarTooltip, LayoutHelper.createFrame(-1, -2.0f, 83, 0.0f, 8.0f, 0.0f, 0.0f));
        ImageView imageView3 = new ImageView(this.parentActivity) { // from class: ir.eitaa.ui.PhotoViewer.24
            @Override // android.view.View
            public boolean dispatchTouchEvent(MotionEvent ev) {
                return PhotoViewer.this.bottomTouchEnabled && super.dispatchTouchEvent(ev);
            }

            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent event) {
                return PhotoViewer.this.bottomTouchEnabled && super.onTouchEvent(event);
            }

            @Override // android.widget.ImageView, android.view.View
            public void setVisibility(int visibility) {
                super.setVisibility(visibility);
                if (PhotoViewer.this.captionEditText.getCaptionLimitOffset() < 0) {
                    PhotoViewer.this.captionLimitView.setVisibility(visibility);
                } else {
                    PhotoViewer.this.captionLimitView.setVisibility(8);
                }
            }

            @Override // android.view.View
            public void setTranslationY(float translationY) {
                super.setTranslationY(translationY);
                PhotoViewer.this.captionLimitView.setTranslationY(translationY);
            }

            @Override // android.view.View
            public void setAlpha(float alpha) {
                super.setAlpha(alpha);
                PhotoViewer.this.captionLimitView.setAlpha(alpha);
            }
        };
        this.pickerViewSendButton = imageView3;
        imageView3.setScaleType(ImageView.ScaleType.CENTER);
        int iDp = AndroidUtilities.dp(56.0f);
        int themedColor = getThemedColor("dialogFloatingButton");
        int i6 = Build.VERSION.SDK_INT;
        Drawable drawableCreateSimpleSelectorCircleDrawable = Theme.createSimpleSelectorCircleDrawable(iDp, themedColor, getThemedColor(i6 >= 21 ? "dialogFloatingButtonPressed" : "dialogFloatingButton"));
        this.pickerViewSendDrawable = drawableCreateSimpleSelectorCircleDrawable;
        this.pickerViewSendButton.setBackgroundDrawable(drawableCreateSimpleSelectorCircleDrawable);
        this.pickerViewSendButton.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.MULTIPLY));
        this.pickerViewSendButton.setImageResource(R.drawable.attach_send);
        this.pickerViewSendButton.setColorFilter(new PorterDuffColorFilter(getThemedColor("dialogFloatingIcon"), PorterDuff.Mode.MULTIPLY));
        this.containerView.addView(this.pickerViewSendButton, LayoutHelper.createFrame(56, 56.0f, 85, 0.0f, 0.0f, 14.0f, 14.0f));
        this.pickerViewSendButton.setContentDescription(LocaleController.getString("Send", R.string.Send));
        this.pickerViewSendButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$QKKjmjtIpsGhlg8cEbmre2DKGZ4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setParentActivity$10$PhotoViewer(view);
            }
        });
        this.pickerViewSendButton.setOnLongClickListener(new View.OnLongClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$WeU00DamJYvOxdmcPrE4SXpbLAY
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f$0.lambda$setParentActivity$14$PhotoViewer(resourcesProvider, view);
            }
        });
        TextView textView4 = new TextView(this.parentActivity);
        this.captionLimitView = textView4;
        textView4.setTextSize(1, 15.0f);
        this.captionLimitView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.captionLimitView.setTextColor(-1280137);
        this.captionLimitView.setGravity(17);
        this.captionLimitView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.containerView.addView(this.captionLimitView, LayoutHelper.createFrame(56, 20.0f, 85, 3.0f, 0.0f, 14.0f, 78.0f));
        LinearLayout linearLayout2 = new LinearLayout(this.parentActivity) { // from class: ir.eitaa.ui.PhotoViewer.25
            boolean ignoreLayout;

            @Override // android.widget.LinearLayout, android.view.View
            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                int childCount = getChildCount();
                int i7 = 0;
                for (int i8 = 0; i8 < childCount; i8++) {
                    if (getChildAt(i8).getVisibility() == 0) {
                        i7++;
                    }
                }
                int size = View.MeasureSpec.getSize(widthMeasureSpec);
                int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
                if (i7 != 0) {
                    int iMin = Math.min(AndroidUtilities.dp(70.0f), size / i7);
                    if (PhotoViewer.this.compressItem.getVisibility() == 0) {
                        this.ignoreLayout = true;
                        int iMax = Math.max(0, (iMin - AndroidUtilities.dp(PhotoViewer.this.selectedCompression < 2 ? 48 : 64)) / 2);
                        PhotoViewer.this.compressItem.setPadding(iMax, 0, iMax, 0);
                        this.ignoreLayout = false;
                    }
                    for (int i9 = 0; i9 < childCount; i9++) {
                        View childAt = getChildAt(i9);
                        if (childAt.getVisibility() != 8) {
                            childAt.measure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
                        }
                    }
                    setMeasuredDimension(iMin * i7, size2);
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
        this.cropItem.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$e3LIOGUCdwMCtLVp7OaQtFq8_Vs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setParentActivity$15$PhotoViewer(view);
            }
        });
        this.cropItem.setContentDescription(LocaleController.getString("CropImage", R.string.CropImage));
        ImageView imageView5 = new ImageView(this.parentActivity);
        this.rotateItem = imageView5;
        imageView5.setScaleType(ImageView.ScaleType.CENTER);
        this.rotateItem.setImageResource(R.drawable.tool_rotate);
        this.rotateItem.setBackgroundDrawable(Theme.createSelectorDrawable(1090519039));
        this.itemsLayout.addView(this.rotateItem, LayoutHelper.createLinear(48, 48));
        this.rotateItem.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$4Wf8Bnmv5dSM4r3qFdFaAQK0K8g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setParentActivity$16$PhotoViewer(view);
            }
        });
        this.rotateItem.setContentDescription(LocaleController.getString("AccDescrRotate", R.string.AccDescrRotate));
        ImageView imageView6 = new ImageView(this.parentActivity);
        this.mirrorItem = imageView6;
        imageView6.setScaleType(ImageView.ScaleType.CENTER);
        this.mirrorItem.setImageResource(R.drawable.photo_flip);
        this.mirrorItem.setBackgroundDrawable(Theme.createSelectorDrawable(1090519039));
        this.itemsLayout.addView(this.mirrorItem, LayoutHelper.createLinear(48, 48));
        this.mirrorItem.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$iORCBDRYyqwmH7Xf55yp4R7bggA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setParentActivity$17$PhotoViewer(view);
            }
        });
        this.mirrorItem.setContentDescription(LocaleController.getString("AccDescrMirror", R.string.AccDescrMirror));
        ImageView imageView7 = new ImageView(this.parentActivity);
        this.paintItem = imageView7;
        imageView7.setScaleType(ImageView.ScaleType.CENTER);
        this.paintItem.setImageResource(R.drawable.photo_paint);
        this.paintItem.setBackgroundDrawable(Theme.createSelectorDrawable(1090519039));
        this.itemsLayout.addView(this.paintItem, LayoutHelper.createLinear(48, 48));
        this.paintItem.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$7Sz-Dnsb-nVPORhC8mQXvXz6_JQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setParentActivity$18$PhotoViewer(view);
            }
        });
        this.paintItem.setContentDescription(LocaleController.getString("AccDescrPhotoEditor", R.string.AccDescrPhotoEditor));
        ImageView imageView8 = new ImageView(this.parentActivity);
        this.muteItem = imageView8;
        imageView8.setScaleType(ImageView.ScaleType.CENTER);
        this.muteItem.setBackgroundDrawable(Theme.createSelectorDrawable(1090519039));
        this.containerView.addView(this.muteItem, LayoutHelper.createFrame(48, 48.0f, 83, 16.0f, 0.0f, 0.0f, 0.0f));
        this.muteItem.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$7OEkrnrOVu1gJ5lqx4oG6RF72Tg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setParentActivity$19$PhotoViewer(view);
            }
        });
        ImageView imageView9 = new ImageView(this.parentActivity);
        this.cameraItem = imageView9;
        imageView9.setScaleType(ImageView.ScaleType.CENTER);
        this.cameraItem.setImageResource(R.drawable.photo_add);
        this.cameraItem.setBackgroundDrawable(Theme.createSelectorDrawable(1090519039));
        this.cameraItem.setContentDescription(LocaleController.getString("AccDescrTakeMorePics", R.string.AccDescrTakeMorePics));
        this.containerView.addView(this.cameraItem, LayoutHelper.createFrame(48, 48.0f, 85, 0.0f, 0.0f, 16.0f, 0.0f));
        this.cameraItem.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$IF14BGzHryj6BTxGg7iDZ58xImw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setParentActivity$20$PhotoViewer(view);
            }
        });
        ImageView imageView10 = new ImageView(this.parentActivity);
        this.tuneItem = imageView10;
        imageView10.setScaleType(ImageView.ScaleType.CENTER);
        this.tuneItem.setImageResource(R.drawable.photo_tools);
        this.tuneItem.setBackgroundDrawable(Theme.createSelectorDrawable(1090519039));
        this.itemsLayout.addView(this.tuneItem, LayoutHelper.createLinear(48, 48));
        this.tuneItem.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$vTKxIHW_e1B1OBoRH6LFnoufRHU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setParentActivity$21$PhotoViewer(view);
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
        this.compressItem.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$GJtJYtYlVINsNHWaYym7LZUcO-g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setParentActivity$22$PhotoViewer(activity, view);
            }
        });
        ImageView imageView12 = new ImageView(this.parentActivity);
        this.timeItem = imageView12;
        imageView12.setScaleType(ImageView.ScaleType.CENTER);
        this.timeItem.setImageResource(R.drawable.photo_timer);
        this.timeItem.setBackgroundDrawable(Theme.createSelectorDrawable(1090519039));
        this.timeItem.setContentDescription(LocaleController.getString("SetTimer", R.string.SetTimer));
        this.itemsLayout.addView(this.timeItem, LayoutHelper.createLinear(48, 48));
        this.timeItem.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$bxTKttY2MtGfKFNvpiLMHD0WoSU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setParentActivity$28$PhotoViewer(resourcesProvider, view);
            }
        });
        PickerBottomLayoutViewer pickerBottomLayoutViewer2 = new PickerBottomLayoutViewer(this.activityContext);
        this.editorDoneLayout = pickerBottomLayoutViewer2;
        pickerBottomLayoutViewer2.setBackgroundColor(-872415232);
        this.editorDoneLayout.updateSelectedCount(0, false);
        this.editorDoneLayout.setVisibility(8);
        this.containerView.addView(this.editorDoneLayout, LayoutHelper.createFrame(-1, 48, 83));
        this.editorDoneLayout.cancelButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$YsP3ZRH5o6sqxrdXsIRqhYGz9W0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setParentActivity$29$PhotoViewer(view);
            }
        });
        this.editorDoneLayout.doneButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$l9jrzCHOdh-OXzOw2Zn0P7lVCXc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setParentActivity$30$PhotoViewer(view);
            }
        });
        TextView textView5 = new TextView(this.activityContext);
        this.resetButton = textView5;
        textView5.setVisibility(8);
        this.resetButton.setTextSize(1, 14.0f);
        this.resetButton.setTextColor(-1);
        this.resetButton.setGravity(17);
        this.resetButton.setBackgroundDrawable(Theme.createSelectorDrawable(-12763843, 0));
        this.resetButton.setPadding(AndroidUtilities.dp(20.0f), 0, AndroidUtilities.dp(20.0f), 0);
        this.resetButton.setText(LocaleController.getString("Reset", R.string.CropReset).toUpperCase());
        this.resetButton.setTypeface(AndroidUtilities.getFontFamily(true));
        this.editorDoneLayout.addView(this.resetButton, LayoutHelper.createFrame(-2, -1, 49));
        this.resetButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$YBIsT93AMQo52KKziRjHTBSHO58
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setParentActivity$31$PhotoViewer(view);
            }
        });
        GestureDetector2 gestureDetector2 = new GestureDetector2(this.containerView.getContext(), this);
        this.gestureDetector = gestureDetector2;
        gestureDetector2.setIsLongpressEnabled(false);
        setDoubleTapEnabled(true);
        ImageReceiver.ImageReceiverDelegate imageReceiverDelegate = new ImageReceiver.ImageReceiverDelegate() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$JfkVIQu6M2XPEB8-LONbwciw1h8
            @Override // ir.eitaa.messenger.ImageReceiver.ImageReceiverDelegate
            public final void didSetImage(ImageReceiver imageReceiver, boolean z2, boolean z3, boolean z4) {
                this.f$0.lambda$setParentActivity$32$PhotoViewer(imageReceiver, z2, z3, z4);
            }

            @Override // ir.eitaa.messenger.ImageReceiver.ImageReceiverDelegate
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
        CheckBox checkBox = new CheckBox(this.containerView.getContext(), R.drawable.selectphoto_large) { // from class: ir.eitaa.ui.PhotoViewer.27
            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent event) {
                return PhotoViewer.this.bottomTouchEnabled && super.onTouchEvent(event);
            }
        };
        this.checkImageView = checkBox;
        checkBox.setDrawBackground(true);
        this.checkImageView.setHasBorder(true);
        this.checkImageView.setSize(34);
        this.checkImageView.setCheckOffset(AndroidUtilities.dp(1.0f));
        this.checkImageView.setColor(getThemedColor("dialogFloatingButton"), -1);
        this.checkImageView.setVisibility(8);
        this.containerView.addView(this.checkImageView, LayoutHelper.createFrame(34, 34.0f, 53, 0.0f, (rotation == 3 || rotation == 1) ? 61.0f : 71.0f, 11.0f, 0.0f));
        if (isStatusBarVisible()) {
            ((FrameLayout.LayoutParams) this.checkImageView.getLayoutParams()).topMargin += AndroidUtilities.statusBarHeight;
        }
        this.checkImageView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$ywhOD5H1YjZpBphof2DC2C4Oymg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setParentActivity$33$PhotoViewer(view);
            }
        });
        CounterView counterView = new CounterView(this.parentActivity);
        this.photosCounterView = counterView;
        this.containerView.addView(counterView, LayoutHelper.createFrame(40, 40.0f, 53, 0.0f, (rotation == 3 || rotation == 1) ? 58.0f : 68.0f, 64.0f, 0.0f));
        if (isStatusBarVisible()) {
            ((FrameLayout.LayoutParams) this.photosCounterView.getLayoutParams()).topMargin += AndroidUtilities.statusBarHeight;
        }
        this.photosCounterView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$t2fYXt0ASwjoqygUur1T5jYbELE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setParentActivity$34$PhotoViewer(view);
            }
        });
        SelectedPhotosListView selectedPhotosListView = new SelectedPhotosListView(this.parentActivity);
        this.selectedPhotosListView = selectedPhotosListView;
        selectedPhotosListView.setVisibility(8);
        this.selectedPhotosListView.setAlpha(0.0f);
        this.selectedPhotosListView.setLayoutManager(new LinearLayoutManager(this.parentActivity, i, z) { // from class: ir.eitaa.ui.PhotoViewer.28
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
                LinearSmoothScrollerEnd linearSmoothScrollerEnd = new LinearSmoothScrollerEnd(recyclerView.getContext()) { // from class: ir.eitaa.ui.PhotoViewer.28.1
                    @Override // androidx.recyclerview.widget.LinearSmoothScrollerEnd
                    protected int calculateTimeForDeceleration(int dx) {
                        return Math.max(180, super.calculateTimeForDeceleration(dx));
                    }
                };
                linearSmoothScrollerEnd.setTargetPosition(position);
                startSmoothScroll(linearSmoothScrollerEnd);
            }
        });
        SelectedPhotosListView selectedPhotosListView2 = this.selectedPhotosListView;
        ListAdapter listAdapter = new ListAdapter(this.parentActivity);
        this.selectedPhotosAdapter = listAdapter;
        selectedPhotosListView2.setAdapter(listAdapter);
        this.containerView.addView(this.selectedPhotosListView, LayoutHelper.createFrame(-1, R.styleable.AppCompatTheme_textAppearanceSmallPopupMenu, 51));
        this.selectedPhotosListView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$R4ZSG_ssCN-hj2X6ROiSxNjrEYU
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i7) throws InterruptedException, Resources.NotFoundException {
                this.f$0.lambda$setParentActivity$35$PhotoViewer(view, i7);
            }
        });
        PhotoViewerCaptionEnterView photoViewerCaptionEnterView = new PhotoViewerCaptionEnterView(this.activityContext, this.containerView, this.windowView, resourcesProvider) { // from class: ir.eitaa.ui.PhotoViewer.29
            @Override // android.view.ViewGroup, android.view.View
            public boolean dispatchTouchEvent(MotionEvent ev) {
                try {
                    if (PhotoViewer.this.bottomTouchEnabled) {
                        return false;
                    }
                    return super.dispatchTouchEvent(ev);
                } catch (Exception e) {
                    FileLog.e(e);
                    return false;
                }
            }

            @Override // android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent ev) {
                try {
                    if (PhotoViewer.this.bottomTouchEnabled) {
                        return false;
                    }
                    return super.onInterceptTouchEvent(ev);
                } catch (Exception e) {
                    FileLog.e(e);
                    return false;
                }
            }

            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent event) {
                if (PhotoViewer.this.bottomTouchEnabled && event.getAction() == 0) {
                    PhotoViewer.this.keyboardAnimationEnabled = true;
                }
                return !PhotoViewer.this.bottomTouchEnabled && super.onTouchEvent(event);
            }

            @Override // ir.eitaa.ui.Components.PhotoViewerCaptionEnterView
            protected void extendActionMode(ActionMode actionMode, Menu menu) {
                if (PhotoViewer.this.parentChatActivity != null) {
                    PhotoViewer.this.parentChatActivity.extendActionMode(menu);
                }
            }
        };
        this.captionEditText = photoViewerCaptionEnterView;
        photoViewerCaptionEnterView.setDelegate(new PhotoViewerCaptionEnterView.PhotoViewerCaptionEnterViewDelegate() { // from class: ir.eitaa.ui.PhotoViewer.30
            @Override // ir.eitaa.ui.Components.PhotoViewerCaptionEnterView.PhotoViewerCaptionEnterViewDelegate
            public void onCaptionEnter() throws Resources.NotFoundException {
                PhotoViewer.this.closeCaptionEnter(true);
            }

            @Override // ir.eitaa.ui.Components.PhotoViewerCaptionEnterView.PhotoViewerCaptionEnterViewDelegate
            public void onTextChanged(CharSequence text) {
                if (PhotoViewer.this.mentionsAdapter != null && PhotoViewer.this.captionEditText != null && PhotoViewer.this.parentChatActivity != null && text != null) {
                    PhotoViewer.this.mentionsAdapter.searchUsernameOrHashtag(text.toString(), PhotoViewer.this.captionEditText.getCursorPosition(), PhotoViewer.this.parentChatActivity.messages, false, false);
                }
                int themedColor2 = PhotoViewer.this.getThemedColor("dialogFloatingIcon");
                if (PhotoViewer.this.captionEditText.getCaptionLimitOffset() < 0) {
                    PhotoViewer.this.captionLimitView.setText(Integer.toString(PhotoViewer.this.captionEditText.getCaptionLimitOffset()));
                    PhotoViewer.this.captionLimitView.setVisibility(PhotoViewer.this.pickerViewSendButton.getVisibility());
                    PhotoViewer.this.pickerViewSendButton.setColorFilter(new PorterDuffColorFilter(ColorUtils.setAlphaComponent(themedColor2, (int) (Color.alpha(themedColor2) * 0.58f)), PorterDuff.Mode.MULTIPLY));
                } else {
                    PhotoViewer.this.pickerViewSendButton.setColorFilter(new PorterDuffColorFilter(themedColor2, PorterDuff.Mode.MULTIPLY));
                    PhotoViewer.this.captionLimitView.setVisibility(8);
                }
                if (PhotoViewer.this.placeProvider != null) {
                    PhotoViewer.this.placeProvider.onCaptionChanged(text);
                }
            }

            @Override // ir.eitaa.ui.Components.PhotoViewerCaptionEnterView.PhotoViewerCaptionEnterViewDelegate
            public void onWindowSizeChanged(int size) {
                if (size - (ActionBar.getCurrentActionBarHeight() * 2) < AndroidUtilities.dp((Math.min(3, PhotoViewer.this.mentionsAdapter.getItemCount()) * 36) + (PhotoViewer.this.mentionsAdapter.getItemCount() > 3 ? 18 : 0))) {
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

            @Override // ir.eitaa.ui.Components.PhotoViewerCaptionEnterView.PhotoViewerCaptionEnterViewDelegate
            public void onEmojiViewCloseStart() {
                int i7;
                String str;
                setOffset(PhotoViewer.this.captionEditText.getEmojiPadding());
                if (PhotoViewer.this.captionEditText.getTag() != null) {
                    if (PhotoViewer.this.isCurrentVideo) {
                        ActionBar actionBar2 = PhotoViewer.this.actionBar;
                        if (PhotoViewer.this.muteVideo) {
                            i7 = R.string.GifCaption;
                            str = "GifCaption";
                        } else {
                            i7 = R.string.VideoCaption;
                            str = "VideoCaption";
                        }
                        actionBar2.setTitleAnimated(LocaleController.getString(str, i7), true, 220L);
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

            @Override // ir.eitaa.ui.Components.PhotoViewerCaptionEnterView.PhotoViewerCaptionEnterViewDelegate
            public void onEmojiViewCloseEnd() {
                setOffset(0);
                PhotoViewer.this.captionEditText.setVisibility(8);
            }

            private void setOffset(int offset) {
                for (int i7 = 0; i7 < PhotoViewer.this.containerView.getChildCount(); i7++) {
                    View childAt = PhotoViewer.this.containerView.getChildAt(i7);
                    if (childAt == PhotoViewer.this.cameraItem || childAt == PhotoViewer.this.muteItem || childAt == PhotoViewer.this.pickerView || childAt == PhotoViewer.this.videoTimelineView || childAt == PhotoViewer.this.pickerViewSendButton || childAt == PhotoViewer.this.captionTextViewSwitcher || (PhotoViewer.this.muteItem.getVisibility() == 0 && childAt == PhotoViewer.this.bottomLayout)) {
                        childAt.setTranslationY(offset);
                    }
                }
            }
        });
        if (i6 >= 19) {
            this.captionEditText.setImportantForAccessibility(4);
        }
        this.captionEditText.setVisibility(8);
        this.containerView.addView(this.captionEditText, LayoutHelper.createFrame(-1, -2, 83));
        RecyclerListView recyclerListView = new RecyclerListView(this.activityContext, resourcesProvider) { // from class: ir.eitaa.ui.PhotoViewer.31
            @Override // ir.eitaa.ui.Components.RecyclerListView, android.view.ViewGroup, android.view.View
            public boolean dispatchTouchEvent(MotionEvent ev) {
                return !PhotoViewer.this.bottomTouchEnabled && super.dispatchTouchEvent(ev);
            }

            @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent ev) {
                return !PhotoViewer.this.bottomTouchEnabled && super.onInterceptTouchEvent(ev);
            }

            @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.View
            public boolean onTouchEvent(MotionEvent event) {
                return !PhotoViewer.this.bottomTouchEnabled && super.onTouchEvent(event);
            }
        };
        this.mentionListView = recyclerListView;
        recyclerListView.setTag(5);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.activityContext) { // from class: ir.eitaa.ui.PhotoViewer.32
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
        this.containerView.addView(this.mentionListView, LayoutHelper.createFrame(-1, R.styleable.AppCompatTheme_viewInflaterClass, 83));
        RecyclerListView recyclerListView2 = this.mentionListView;
        MentionsAdapter mentionsAdapter = new MentionsAdapter(this.activityContext, true, 0L, 0, new MentionsAdapter.MentionsAdapterDelegate() { // from class: ir.eitaa.ui.PhotoViewer.33
            @Override // ir.eitaa.ui.Adapters.MentionsAdapter.MentionsAdapterDelegate
            public void onContextClick(TLRPC$BotInlineResult result) {
            }

            @Override // ir.eitaa.ui.Adapters.MentionsAdapter.MentionsAdapterDelegate
            public void onContextSearch(boolean searching) {
            }

            @Override // ir.eitaa.ui.Adapters.MentionsAdapter.MentionsAdapterDelegate
            public void needChangePanelVisibility(boolean show) {
                if (show) {
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
                        PhotoViewer.this.mentionListAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.PhotoViewer.33.1
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animation) {
                                if (PhotoViewer.this.mentionListAnimation == null || !PhotoViewer.this.mentionListAnimation.equals(animation)) {
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
                    PhotoViewer.this.mentionListAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.PhotoViewer.33.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animation) {
                            if (PhotoViewer.this.mentionListAnimation == null || !PhotoViewer.this.mentionListAnimation.equals(animation)) {
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
        }, resourcesProvider);
        this.mentionsAdapter = mentionsAdapter;
        recyclerListView2.setAdapter(mentionsAdapter);
        this.mentionListView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$ymfXfwVtLnGfnij_NmT7T3_l7OQ
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i7) {
                this.f$0.lambda$setParentActivity$36$PhotoViewer(view, i7);
            }
        });
        this.mentionListView.setOnItemLongClickListener(new RecyclerListView.OnItemLongClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$kaGQ1wJLY_4eMje__n6PwngaviU
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemLongClickListener
            public final boolean onItemClick(View view, int i7) {
                return this.f$0.lambda$setParentActivity$38$PhotoViewer(resourcesProvider, view, i7);
            }
        });
        UndoView undoView = new UndoView(this.activityContext, null, false, resourcesProvider);
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

    /* renamed from: ir.eitaa.ui.PhotoViewer$10, reason: invalid class name */
    class AnonymousClass10 extends FrameLayout {
        AnonymousClass10(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent ev) {
            return PhotoViewer.this.isVisible && super.onInterceptTouchEvent(ev);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent event) {
            return PhotoViewer.this.isVisible && PhotoViewer.this.onTouchEvent(event);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent event) {
            event.getKeyCode();
            if (!PhotoViewer.this.muteVideo && PhotoViewer.this.sendPhotoType != 1 && PhotoViewer.this.isCurrentVideo && PhotoViewer.this.videoPlayer != null && event.getRepeatCount() == 0 && event.getAction() == 0 && (event.getKeyCode() == 24 || event.getKeyCode() == 25)) {
                PhotoViewer.this.videoPlayer.setVolume(1.0f);
            }
            return super.dispatchKeyEvent(event);
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
                ir.eitaa.ui.PhotoViewer r0 = ir.eitaa.ui.PhotoViewer.this
                boolean r0 = ir.eitaa.ui.PhotoViewer.access$100(r0)
                if (r0 == 0) goto L32
                ir.eitaa.ui.PhotoViewer r0 = ir.eitaa.ui.PhotoViewer.this
                boolean r0 = ir.eitaa.ui.PhotoViewer.access$200(r0)
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
                ir.eitaa.ui.PhotoViewer r0 = ir.eitaa.ui.PhotoViewer.this
                ir.eitaa.ui.PhotoViewer.access$10800(r0)
                goto L32
            L29:
                ir.eitaa.ui.PhotoViewer r0 = ir.eitaa.ui.PhotoViewer.this
                java.lang.Runnable r0 = ir.eitaa.ui.PhotoViewer.access$10700(r0)
                ir.eitaa.messenger.AndroidUtilities.cancelRunOnUIThread(r0)
            L32:
                boolean r3 = super.dispatchTouchEvent(r3)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.PhotoViewer.AnonymousClass10.dispatchTouchEvent(android.view.MotionEvent):boolean");
        }

        @Override // android.view.ViewGroup
        protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
            try {
                return super.drawChild(canvas, child, drawingTime);
            } catch (Throwable unused) {
                return false;
            }
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            int i;
            int stableInsetBottom;
            int size = View.MeasureSpec.getSize(widthMeasureSpec);
            int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
            if (Build.VERSION.SDK_INT >= 21 && PhotoViewer.this.lastInsets != null) {
                WindowInsets windowInsets = (WindowInsets) PhotoViewer.this.lastInsets;
                if (!PhotoViewer.this.inBubbleMode) {
                    if (AndroidUtilities.incorrectDisplaySizeFix) {
                        int i2 = AndroidUtilities.displaySize.y;
                        if (size2 > i2) {
                            size2 = i2;
                        }
                        size2 += AndroidUtilities.statusBarHeight;
                    } else if (windowInsets.getStableInsetBottom() >= 0 && (i = AndroidUtilities.statusBarHeight) >= 0 && (stableInsetBottom = (size2 - i) - windowInsets.getStableInsetBottom()) > 0 && stableInsetBottom < 4096) {
                        AndroidUtilities.displaySize.y = stableInsetBottom;
                    }
                }
                int systemWindowInsetBottom = windowInsets.getSystemWindowInsetBottom();
                if (PhotoViewer.this.captionEditText.isPopupShowing()) {
                    systemWindowInsetBottom -= PhotoViewer.this.containerView.getKeyboardHeight();
                }
                size2 -= systemWindowInsetBottom;
            } else {
                int i3 = AndroidUtilities.displaySize.y;
                if (size2 > i3) {
                    size2 = i3;
                }
            }
            setMeasuredDimension(size, size2);
            ViewGroup.LayoutParams layoutParams = PhotoViewer.this.animatingImageView.getLayoutParams();
            PhotoViewer.this.animatingImageView.measure(View.MeasureSpec.makeMeasureSpec(layoutParams.width, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(layoutParams.height, Integer.MIN_VALUE));
            PhotoViewer.this.containerView.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
            PhotoViewer.this.animatingImageView.layout(0, 0, PhotoViewer.this.animatingImageView.getMeasuredWidth(), PhotoViewer.this.animatingImageView.getMeasuredHeight());
            PhotoViewer.this.containerView.layout(0, 0, PhotoViewer.this.containerView.getMeasuredWidth(), PhotoViewer.this.containerView.getMeasuredHeight());
            PhotoViewer.this.wasLayout = true;
            if (changed) {
                if (!PhotoViewer.this.dontResetZoomOnFirstLayout) {
                    PhotoViewer.this.scale = 1.0f;
                    PhotoViewer.this.translationX = 0.0f;
                    PhotoViewer.this.translationY = 0.0f;
                    PhotoViewer photoViewer = PhotoViewer.this;
                    photoViewer.updateMinMax(photoViewer.scale);
                }
                if (PhotoViewer.this.checkImageView != null) {
                    PhotoViewer.this.checkImageView.post(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$10$QGxjBo8e18M0dbyMqSd7xQOXeDc
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onLayout$0$PhotoViewer$10();
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
        /* renamed from: lambda$onLayout$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onLayout$0$PhotoViewer$10() {
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
            PhotoViewer.this.attachedToWindow = true;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            PhotoViewer.this.attachedToWindow = false;
            PhotoViewer.this.wasLayout = false;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEventPreIme(KeyEvent event) throws Resources.NotFoundException {
            if (event != null && event.getKeyCode() == 4 && event.getAction() == 1) {
                if (PhotoViewer.this.captionEditText.isPopupShowing() || PhotoViewer.this.captionEditText.isKeyboardVisible()) {
                    PhotoViewer.this.closeCaptionEnter(true);
                    return false;
                }
                PhotoViewer.getInstance().closePhoto(true, false);
                return true;
            }
            return super.dispatchKeyEventPreIme(event);
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
    /* renamed from: lambda$setParentActivity$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ WindowInsets lambda$setParentActivity$2$PhotoViewer(View view, WindowInsets windowInsets) {
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

    /* renamed from: ir.eitaa.ui.PhotoViewer$12, reason: invalid class name */
    class AnonymousClass12 extends ActionBar.ActionBarMenuOnItemClick {
        final /* synthetic */ Theme.ResourcesProvider val$resourcesProvider;

        AnonymousClass12(final Theme.ResourcesProvider val$resourcesProvider) {
            this.val$resourcesProvider = val$resourcesProvider;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onItemClick$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onItemClick$0$PhotoViewer$12(boolean z) {
            BulletinFactory.createSaveToGalleryBulletin(PhotoViewer.this.containerView, z, -115203550, -1).show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onItemClick$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onItemClick$1$PhotoViewer$12(ArrayList arrayList, ChatActivity chatActivity, DialogsActivity dialogsActivity, ArrayList arrayList2, CharSequence charSequence, boolean z) {
            if (arrayList2.size() > 1 || ((Long) arrayList2.get(0)).longValue() == UserConfig.getInstance(PhotoViewer.this.currentAccount).getClientUserId() || charSequence != null) {
                for (int i = 0; i < arrayList2.size(); i++) {
                    long jLongValue = ((Long) arrayList2.get(i)).longValue();
                    if (charSequence != null) {
                        SendMessagesHelper.getInstance(PhotoViewer.this.currentAccount).sendMessage(charSequence.toString(), jLongValue, null, null, null, true, null, null, null, true, 0, null);
                    }
                    SendMessagesHelper.getInstance(PhotoViewer.this.currentAccount).sendMessage((ArrayList<MessageObject>) arrayList, jLongValue, false, false, true, 0);
                }
                dialogsActivity.finishFragment();
                if (chatActivity != null) {
                    if (arrayList2.size() == 1) {
                        chatActivity.getUndoView().showWithAction(((Long) arrayList2.get(0)).longValue(), 53, Integer.valueOf(arrayList.size()));
                        return;
                    } else {
                        chatActivity.getUndoView().showWithAction(0L, 53, Integer.valueOf(arrayList.size()), Integer.valueOf(arrayList2.size()), (Runnable) null, (Runnable) null);
                        return;
                    }
                }
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
            NotificationCenter.getInstance(PhotoViewer.this.currentAccount).postNotificationName(NotificationCenter.closeChats, new Object[0]);
            ChatActivity chatActivity2 = new ChatActivity(bundle);
            if (((LaunchActivity) PhotoViewer.this.parentActivity).presentFragment(chatActivity2, true, false)) {
                chatActivity2.showFieldPanelForForward(true, arrayList);
            } else {
                dialogsActivity.finishFragment();
            }
        }

        static /* synthetic */ void lambda$onItemClick$2(boolean[] zArr, View view) {
            zArr[0] = !zArr[0];
            ((CheckBoxCell) view).setChecked(zArr[0], true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onItemClick$3, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onItemClick$3$PhotoViewer$12(boolean[] zArr, DialogInterface dialogInterface, int i) throws InterruptedException, Resources.NotFoundException {
            TLRPC$EncryptedChat encryptedChat = null;
            if (!PhotoViewer.this.imagesArr.isEmpty()) {
                if (PhotoViewer.this.currentIndex < 0 || PhotoViewer.this.currentIndex >= PhotoViewer.this.imagesArr.size()) {
                    return;
                }
                MessageObject messageObject = (MessageObject) PhotoViewer.this.imagesArr.get(PhotoViewer.this.currentIndex);
                if (messageObject.isSent()) {
                    PhotoViewer.this.closePhoto(false, false);
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    ArrayList<Long> arrayList2 = new ArrayList<>();
                    if (PhotoViewer.this.slideshowMessageId != 0) {
                        arrayList.add(Integer.valueOf(PhotoViewer.this.slideshowMessageId));
                    } else {
                        arrayList.add(Integer.valueOf(messageObject.getId()));
                    }
                    arrayList2.add(Long.valueOf(messageObject.getDialogId()));
                    if (DialogObject.isEncryptedDialog(messageObject.getDialogId()) && messageObject.messageOwner.random_id != 0) {
                        new ArrayList().add(Long.valueOf(messageObject.messageOwner.random_id));
                        encryptedChat = MessagesController.getInstance(PhotoViewer.this.currentAccount).getEncryptedChat(Integer.valueOf(DialogObject.getEncryptedChatId(messageObject.getDialogId())));
                    }
                    MessagesController.getInstance(PhotoViewer.this.currentAccount).deleteMessages(arrayList, arrayList2, encryptedChat, messageObject.getDialogId(), zArr[0], messageObject.scheduled);
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
                    ArrayList<Integer> arrayList3 = new ArrayList<>();
                    arrayList3.add(Integer.valueOf(tLRPC$Message.id));
                    MessagesController.getInstance(PhotoViewer.this.currentAccount).deleteMessages(arrayList3, null, null, MessageObject.getDialogId(tLRPC$Message), true, false);
                    NotificationCenter.getInstance(PhotoViewer.this.currentAccount).postNotificationName(NotificationCenter.reloadDialogPhotos, new Object[0]);
                }
                if (!PhotoViewer.this.isCurrentAvatarSet()) {
                    TLRPC$Photo tLRPC$Photo = (TLRPC$Photo) PhotoViewer.this.avatarsArr.get(PhotoViewer.this.currentIndex);
                    if (tLRPC$Photo == null) {
                        return;
                    }
                    TLRPC$TL_inputPhoto tLRPC$TL_inputPhoto = new TLRPC$TL_inputPhoto();
                    tLRPC$TL_inputPhoto.id = tLRPC$Photo.id;
                    tLRPC$TL_inputPhoto.access_hash = tLRPC$Photo.access_hash;
                    byte[] bArr = tLRPC$Photo.file_reference;
                    tLRPC$TL_inputPhoto.file_reference = bArr;
                    if (bArr == null) {
                        tLRPC$TL_inputPhoto.file_reference = new byte[0];
                    }
                    if (PhotoViewer.this.avatarsDialogId > 0) {
                        MessagesController.getInstance(PhotoViewer.this.currentAccount).deleteUserPhoto(tLRPC$TL_inputPhoto);
                    }
                    MessagesStorage.getInstance(PhotoViewer.this.currentAccount).clearUserPhoto(PhotoViewer.this.avatarsDialogId, tLRPC$Photo.id);
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
                if (PhotoViewer.this.avatarsDialogId > 0) {
                    MessagesController.getInstance(PhotoViewer.this.currentAccount).deleteUserPhoto(null);
                } else {
                    MessagesController.getInstance(PhotoViewer.this.currentAccount).changeChatAvatar(-PhotoViewer.this.avatarsDialogId, null, null, null, 0.0d, null, null, null, null);
                }
                PhotoViewer.this.closePhoto(false, false);
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

        /* JADX WARN: Removed duplicated region for block: B:117:0x032b  */
        /* JADX WARN: Type inference failed for: r12v21 */
        /* JADX WARN: Type inference failed for: r12v22, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r12v23 */
        @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onItemClick(int r23) throws java.lang.InterruptedException, android.content.res.Resources.NotFoundException {
            /*
                Method dump skipped, instructions count: 2946
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.PhotoViewer.AnonymousClass12.onItemClick(int):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onItemClick$5, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onItemClick$5$PhotoViewer$12(final UserConfig userConfig, final TLRPC$Photo tLRPC$Photo, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$12$-QiKGDnYjh6jrFhLyWVykuTHwDQ
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onItemClick$4$PhotoViewer$12(tLObject, userConfig, tLRPC$Photo);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onItemClick$4, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onItemClick$4$PhotoViewer$12(TLObject tLObject, UserConfig userConfig, TLRPC$Photo tLRPC$Photo) {
            if (tLObject instanceof TLRPC$TL_photos_photo) {
                TLRPC$TL_photos_photo tLRPC$TL_photos_photo = (TLRPC$TL_photos_photo) tLObject;
                MessagesController.getInstance(PhotoViewer.this.currentAccount).putUsers(tLRPC$TL_photos_photo.users, false);
                TLRPC$User user = MessagesController.getInstance(PhotoViewer.this.currentAccount).getUser(Long.valueOf(userConfig.clientUserId));
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
        /* renamed from: lambda$onItemClick$6, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onItemClick$6$PhotoViewer$12() {
            if (PhotoViewer.this.menuItem == null) {
                return;
            }
            PhotoViewer.this.menuItem.hideSubItem(16);
        }

        @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
        public boolean canOpenMenu() {
            PhotoViewer.this.menuItemSpeed.setVisibility(4);
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
    /* renamed from: lambda$setParentActivity$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setParentActivity$3$PhotoViewer(int i) {
        if (i < 21 || i > 25) {
            return;
        }
        switch (i) {
            case 21:
                this.currentVideoSpeed = 0.25f;
                break;
            case 22:
                this.currentVideoSpeed = 0.5f;
                break;
            case 23:
                this.currentVideoSpeed = 1.0f;
                break;
            case 24:
                this.currentVideoSpeed = 1.5f;
                break;
            case 25:
                this.currentVideoSpeed = 2.0f;
                break;
        }
        if (this.currentMessageObject != null) {
            SharedPreferences sharedPreferences = ApplicationLoader.applicationContext.getSharedPreferences("playback_speed", 0);
            if (Math.abs(this.currentVideoSpeed - 1.0f) < 0.001f) {
                sharedPreferences.edit().remove("speed" + this.currentMessageObject.getDialogId() + "_" + this.currentMessageObject.getId()).commit();
            } else {
                sharedPreferences.edit().putFloat("speed" + this.currentMessageObject.getDialogId() + "_" + this.currentMessageObject.getId(), this.currentVideoSpeed).commit();
            }
        }
        VideoPlayer videoPlayer = this.videoPlayer;
        if (videoPlayer != null) {
            videoPlayer.setPlaybackSpeed(this.currentVideoSpeed);
        }
        PhotoViewerWebView photoViewerWebView = this.photoViewerWebView;
        if (photoViewerWebView != null) {
            photoViewerWebView.setPlaybackSpeed(this.currentVideoSpeed);
        }
        setMenuItemIcon();
        this.menuItemSpeed.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setParentActivity$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setParentActivity$4$PhotoViewer(View view) {
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
    /* renamed from: lambda$setParentActivity$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setParentActivity$6$PhotoViewer(View view) {
        openCurrentPhotoInPaintModeForSelect();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setParentActivity$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setParentActivity$7$PhotoViewer(View view) {
        onSharePressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setParentActivity$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setParentActivity$8$PhotoViewer(View view) {
        this.selectedCompression = this.previousCompression;
        didChangedCompressionLevel(false);
        showQualityView(false);
        requestVideoPreview(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setParentActivity$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setParentActivity$9$PhotoViewer(View view) {
        showQualityView(false);
        requestVideoPreview(2);
    }

    /* renamed from: ir.eitaa.ui.PhotoViewer$23, reason: invalid class name */
    class AnonymousClass23 implements VideoTimelinePlayView.VideoTimelineViewDelegate {
        private int seekTo;
        private Runnable seekToRunnable;
        private boolean wasPlaying;

        AnonymousClass23() {
        }

        @Override // ir.eitaa.ui.Components.VideoTimelinePlayView.VideoTimelineViewDelegate
        public void onLeftProgressChanged(float progress) {
            if (PhotoViewer.this.videoPlayer == null) {
                return;
            }
            if (PhotoViewer.this.videoPlayer.isPlaying()) {
                PhotoViewer.this.manuallyPaused = false;
                PhotoViewer.this.videoPlayer.pause();
                PhotoViewer.this.containerView.invalidate();
            }
            updateAvatarStartTime(1);
            seekTo(progress);
            PhotoViewer.this.videoPlayerSeekbar.setProgress(0.0f);
            PhotoViewer.this.videoTimelineView.setProgress(progress);
            PhotoViewer.this.updateVideoInfo();
        }

        @Override // ir.eitaa.ui.Components.VideoTimelinePlayView.VideoTimelineViewDelegate
        public void onRightProgressChanged(float progress) {
            if (PhotoViewer.this.videoPlayer == null) {
                return;
            }
            if (PhotoViewer.this.videoPlayer.isPlaying()) {
                PhotoViewer.this.manuallyPaused = false;
                PhotoViewer.this.videoPlayer.pause();
                PhotoViewer.this.containerView.invalidate();
            }
            updateAvatarStartTime(2);
            seekTo(progress);
            PhotoViewer.this.videoPlayerSeekbar.setProgress(1.0f);
            PhotoViewer.this.videoTimelineView.setProgress(progress);
            PhotoViewer.this.updateVideoInfo();
        }

        @Override // ir.eitaa.ui.Components.VideoTimelinePlayView.VideoTimelineViewDelegate
        public void onPlayProgressChanged(float progress) {
            if (PhotoViewer.this.videoPlayer == null) {
                return;
            }
            if (PhotoViewer.this.sendPhotoType == 1) {
                updateAvatarStartTime(0);
            }
            seekTo(progress);
        }

        private void seekTo(float progress) {
            this.seekTo = (int) (PhotoViewer.this.videoDuration * progress);
            if (this.seekToRunnable == null) {
                Runnable runnable = new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$23$LMQmu-ptulAO6t_Oh0NzP-DRc4E
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$seekTo$0$PhotoViewer$23();
                    }
                };
                this.seekToRunnable = runnable;
                AndroidUtilities.runOnUIThread(runnable, 100L);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$seekTo$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$seekTo$0$PhotoViewer$23() {
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

        private void updateAvatarStartTime(int fix) {
            if (PhotoViewer.this.sendPhotoType != 1) {
                return;
            }
            if (fix != 0) {
                if (PhotoViewer.this.photoCropView != null) {
                    if (PhotoViewer.this.videoTimelineView.getLeftProgress() > PhotoViewer.this.avatarStartProgress || PhotoViewer.this.videoTimelineView.getRightProgress() < PhotoViewer.this.avatarStartProgress) {
                        PhotoViewer.this.photoCropView.setVideoThumbVisible(false);
                        if (fix == 1) {
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

        @Override // ir.eitaa.ui.Components.VideoTimelinePlayView.VideoTimelineViewDelegate
        public void didStartDragging(int type) {
            if (type == VideoTimelinePlayView.TYPE_PROGRESS) {
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

        @Override // ir.eitaa.ui.Components.VideoTimelinePlayView.VideoTimelineViewDelegate
        public void didStopDragging(int type) {
            Runnable runnable = this.seekToRunnable;
            if (runnable != null) {
                AndroidUtilities.cancelRunOnUIThread(runnable);
                this.seekToRunnable.run();
            }
            PhotoViewer.this.cancelVideoPlayRunnable();
            if (PhotoViewer.this.sendPhotoType != 1 || PhotoViewer.this.flashView == null || type != VideoTimelinePlayView.TYPE_PROGRESS) {
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
    /* renamed from: lambda$setParentActivity$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setParentActivity$10$PhotoViewer(View view) {
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
    /* JADX WARN: Removed duplicated region for block: B:32:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ee  */
    /* renamed from: lambda$setParentActivity$14, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ boolean lambda$setParentActivity$14$PhotoViewer(ir.eitaa.ui.ActionBar.Theme.ResourcesProvider r17, android.view.View r18) {
        /*
            Method dump skipped, instructions count: 566
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.PhotoViewer.lambda$setParentActivity$14$PhotoViewer(ir.eitaa.ui.ActionBar.Theme$ResourcesProvider, android.view.View):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setParentActivity$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$setParentActivity$11$PhotoViewer(View view, MotionEvent motionEvent) {
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
    /* renamed from: lambda$setParentActivity$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setParentActivity$12$PhotoViewer(KeyEvent keyEvent) {
        ActionBarPopupWindow actionBarPopupWindow;
        if (keyEvent.getKeyCode() == 4 && keyEvent.getRepeatCount() == 0 && (actionBarPopupWindow = this.sendPopupWindow) != null && actionBarPopupWindow.isShowing()) {
            this.sendPopupWindow.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setParentActivity$13, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setParentActivity$13$PhotoViewer(int i, View view) {
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
            return;
        }
        if (i == 2) {
            replacePressed();
        } else if (i == 3) {
            sendPressed(true, 0);
        } else if (i == 4) {
            sendPressed(true, 0, false, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setParentActivity$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setParentActivity$15$PhotoViewer(View view) {
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
    /* renamed from: lambda$setParentActivity$16, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setParentActivity$16$PhotoViewer(View view) {
        PhotoCropView photoCropView = this.photoCropView;
        if (photoCropView == null) {
            return;
        }
        if (photoCropView.rotate()) {
            this.rotateItem.setColorFilter(new PorterDuffColorFilter(getThemedColor("dialogFloatingButton"), PorterDuff.Mode.MULTIPLY));
        } else {
            this.rotateItem.setColorFilter((ColorFilter) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setParentActivity$17, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setParentActivity$17$PhotoViewer(View view) {
        PhotoCropView photoCropView = this.photoCropView;
        if (photoCropView == null) {
            return;
        }
        if (photoCropView.mirror()) {
            this.mirrorItem.setColorFilter(new PorterDuffColorFilter(getThemedColor("dialogFloatingButton"), PorterDuff.Mode.MULTIPLY));
        } else {
            this.mirrorItem.setColorFilter((ColorFilter) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setParentActivity$18, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setParentActivity$18$PhotoViewer(View view) {
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
    /* renamed from: lambda$setParentActivity$19, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setParentActivity$19$PhotoViewer(View view) {
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
    /* renamed from: lambda$setParentActivity$20, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setParentActivity$20$PhotoViewer(View view) {
        if (this.placeProvider == null || this.captionEditText.getTag() != null) {
            return;
        }
        this.placeProvider.needAddMorePhotos();
        closePhoto(true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setParentActivity$21, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setParentActivity$21$PhotoViewer(View view) {
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
    /* renamed from: lambda$setParentActivity$22, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setParentActivity$22$PhotoViewer(Activity activity, View view) {
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
    /* renamed from: lambda$setParentActivity$28, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setParentActivity$28$PhotoViewer(Theme.ResourcesProvider resourcesProvider, View view) {
        int i;
        String str;
        int i2;
        if (this.parentActivity == null || this.captionEditText.getTag() != null) {
            return;
        }
        BottomSheet.Builder builder = new BottomSheet.Builder(this.parentActivity, false, resourcesProvider);
        builder.setUseHardwareLayer(false);
        LinearLayout linearLayout = new LinearLayout(this.parentActivity);
        linearLayout.setOrientation(1);
        builder.setCustomView(linearLayout);
        TextView textView = new TextView(this.parentActivity);
        textView.setLines(1);
        textView.setSingleLine(true);
        textView.setText(LocaleController.getString("MessageLifetime", R.string.MessageLifetime));
        textView.setTextColor(-1);
        textView.setTypeface(AndroidUtilities.getFontFamily(true));
        textView.setTextSize(1, 20.0f);
        textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        textView.setPadding(AndroidUtilities.dp(21.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(21.0f), AndroidUtilities.dp(4.0f));
        textView.setGravity(16);
        linearLayout.addView(textView, LayoutHelper.createFrame(-1, -2.0f));
        textView.setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$ymVQbxmRL2jcaSkGTguUGxSjavI
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return PhotoViewer.lambda$setParentActivity$23(view2, motionEvent);
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
        textView2.setTypeface(AndroidUtilities.getFontFamily(false));
        textView2.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        textView2.setPadding(AndroidUtilities.dp(21.0f), 0, AndroidUtilities.dp(21.0f), AndroidUtilities.dp(8.0f));
        textView2.setGravity(16);
        linearLayout.addView(textView2, LayoutHelper.createFrame(-1, -2.0f));
        textView2.setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$-B2UZ7GJK9mlSHEFoBaDF1svKP4
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return PhotoViewer.lambda$setParentActivity$24(view2, motionEvent);
            }
        });
        final BottomSheet bottomSheetCreate = builder.create();
        final NumberPicker numberPicker = new NumberPicker(this.parentActivity, resourcesProvider);
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
        numberPicker.setFormatter(new NumberPicker.Formatter() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$cyeGSlIGRhgVAM-XHmMaEsQnqn0
            @Override // ir.eitaa.ui.Components.NumberPicker.Formatter
            public final String format(int i3) {
                return PhotoViewer.lambda$setParentActivity$25(i3);
            }
        });
        linearLayout.addView(numberPicker, LayoutHelper.createLinear(-1, -2));
        FrameLayout frameLayout = new FrameLayout(this.parentActivity) { // from class: ir.eitaa.ui.PhotoViewer.26
            @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
                int childCount = getChildCount();
                int i3 = right - left;
                for (int i4 = 0; i4 < childCount; i4++) {
                    View childAt = getChildAt(i4);
                    if (((Integer) childAt.getTag()).intValue() == -1) {
                        childAt.layout((i3 - getPaddingRight()) - childAt.getMeasuredWidth(), getPaddingTop(), i3 - getPaddingRight(), getPaddingTop() + childAt.getMeasuredHeight());
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
        textView3.setTextColor(getThemedColor("dialogFloatingButton"));
        textView3.setGravity(17);
        textView3.setTypeface(AndroidUtilities.getFontFamily(true));
        textView3.setText(LocaleController.getString("Done", R.string.Done).toUpperCase());
        textView3.setBackgroundDrawable(Theme.getRoundRectSelectorDrawable(-11944718));
        textView3.setPadding(AndroidUtilities.dp(10.0f), 0, AndroidUtilities.dp(10.0f), 0);
        frameLayout.addView(textView3, LayoutHelper.createFrame(-2, 36, 53));
        textView3.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$TjRzeJupJQXIh8gwUyMMYGQE7RE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$setParentActivity$26$PhotoViewer(numberPicker, bottomSheetCreate, view2);
            }
        });
        TextView textView4 = new TextView(this.parentActivity);
        textView4.setMinWidth(AndroidUtilities.dp(64.0f));
        textView4.setTag(-2);
        textView4.setTextSize(1, 14.0f);
        textView4.setTextColor(-1);
        textView4.setGravity(17);
        textView4.setTypeface(AndroidUtilities.getFontFamily(true));
        textView4.setText(LocaleController.getString("Cancel", R.string.Cancel).toUpperCase());
        textView4.setBackgroundDrawable(Theme.getRoundRectSelectorDrawable(-1));
        textView4.setPadding(AndroidUtilities.dp(10.0f), 0, AndroidUtilities.dp(10.0f), 0);
        frameLayout.addView(textView4, LayoutHelper.createFrame(-2, 36, 53));
        textView4.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$rh5UOWeXMgFiol-MhmOukDCfr7w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                bottomSheetCreate.dismiss();
            }
        });
        bottomSheetCreate.show();
        bottomSheetCreate.setBackgroundColor(-16777216);
    }

    static /* synthetic */ String lambda$setParentActivity$25(int i) {
        if (i == 0) {
            return LocaleController.getString("ShortMessageLifetimeForever", R.string.ShortMessageLifetimeForever);
        }
        if (i >= 1 && i < 21) {
            return LocaleController.formatTTLString(i);
        }
        return LocaleController.formatTTLString((i - 16) * 5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setParentActivity$26, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setParentActivity$26$PhotoViewer(NumberPicker numberPicker, BottomSheet bottomSheet, View view) {
        int value = numberPicker.getValue();
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putInt("self_destruct", value);
        editorEdit.commit();
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
        this.timeItem.setColorFilter(value != 0 ? new PorterDuffColorFilter(getThemedColor("dialogFloatingButton"), PorterDuff.Mode.MULTIPLY) : null);
        if (this.checkImageView.isChecked()) {
            return;
        }
        this.checkImageView.callOnClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setParentActivity$29, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setParentActivity$29$PhotoViewer(View view) {
        this.cropTransform.setViewTransform(this.previousHasTransform, this.previousCropPx, this.previousCropPy, this.previousCropRotation, this.previousCropOrientation, this.previousCropScale, 1.0f, 1.0f, this.previousCropPw, this.previousCropPh, 0.0f, 0.0f, this.previousCropMirrored);
        switchToEditMode(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setParentActivity$30, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setParentActivity$30$PhotoViewer(View view) {
        if (this.currentEditMode != 1 || this.photoCropView.isReady()) {
            applyCurrentEditMode();
            switchToEditMode(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setParentActivity$31, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setParentActivity$31$PhotoViewer(View view) {
        this.photoCropView.reset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setParentActivity$32, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setParentActivity$32$PhotoViewer(ImageReceiver imageReceiver, boolean z, boolean z2, boolean z3) {
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
    /* renamed from: lambda$setParentActivity$33, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setParentActivity$33$PhotoViewer(View view) {
        if (this.captionEditText.getTag() != null) {
            return;
        }
        setPhotoChecked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setParentActivity$34, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setParentActivity$34$PhotoViewer(View view) {
        PhotoViewerProvider photoViewerProvider;
        if (this.captionEditText.getTag() != null || (photoViewerProvider = this.placeProvider) == null || photoViewerProvider.getSelectedPhotosOrder() == null || this.placeProvider.getSelectedPhotosOrder().isEmpty()) {
            return;
        }
        togglePhotosListView(!this.isPhotosListViewVisible, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setParentActivity$35, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setParentActivity$35$PhotoViewer(View view, int i) throws InterruptedException, Resources.NotFoundException {
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
    /* renamed from: lambda$setParentActivity$36, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setParentActivity$36$PhotoViewer(View view, int i) {
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
            spannableString.setSpan(new URLSpanUserMentionPhotoViewer("" + tLRPC$User.id, true), 0, spannableString.length(), 33);
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
    /* renamed from: lambda$setParentActivity$38, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$setParentActivity$38$PhotoViewer(Theme.ResourcesProvider resourcesProvider, View view, int i) {
        if (!(this.mentionsAdapter.getItem(i) instanceof String)) {
            return false;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.parentActivity, resourcesProvider);
        builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
        builder.setMessage(LocaleController.getString("ClearSearch", R.string.ClearSearch));
        builder.setPositiveButton(LocaleController.getString("ClearButton", R.string.ClearButton).toUpperCase(), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$564mDQ6-zcFKQWorQL_IizGjwOI
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.f$0.lambda$setParentActivity$37$PhotoViewer(dialogInterface, i2);
            }
        });
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        showAlertDialog(builder);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setParentActivity$37, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setParentActivity$37$PhotoViewer(DialogInterface dialogInterface, int i) {
        this.mentionsAdapter.clearRecentHashtags();
    }

    private void showScheduleDatePickerDialog() {
        if (this.parentChatActivity == null) {
            return;
        }
        AlertsCreator.createScheduleDatePickerDialog(this.parentActivity, this.parentChatActivity.getDialogId(), new AlertsCreator.ScheduleDatePickerDelegate() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$xOOv9LnUMzprLsrXSqLZpCqFJw8
            @Override // ir.eitaa.ui.Components.AlertsCreator.ScheduleDatePickerDelegate
            public final void didSelectDate(boolean z, int i) {
                this.f$0.sendPressed(z, i);
            }
        }, new AlertsCreator.ScheduleDatePickerColors(-1, -14342875, -1, 520093695, -1, -115203550, 620756991));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendPressed(boolean notify, int scheduleDate) {
        sendPressed(notify, scheduleDate, false, false);
    }

    private void replacePressed() {
        sendPressed(false, 0, true, false);
    }

    private void sendPressed(boolean notify, int scheduleDate, boolean replace, boolean forceDocument) {
        int i;
        ChatActivity chatActivity;
        if (this.captionEditText.getTag() != null || this.placeProvider == null || this.doneButtonPressed) {
            return;
        }
        if (this.sendPhotoType == 1) {
            applyCurrentEditMode();
        }
        if (!replace && (chatActivity = this.parentChatActivity) != null) {
            TLRPC$Chat currentChat = chatActivity.getCurrentChat();
            if (this.parentChatActivity.getCurrentUser() != null || ((ChatObject.isChannel(currentChat) && currentChat.megagroup) || !ChatObject.isChannel(currentChat))) {
                MessagesController.getNotificationsSettings(this.currentAccount).edit().putBoolean("silent_" + this.parentChatActivity.getDialogId(), !notify).commit();
            }
        }
        VideoEditedInfo currentVideoEditedInfo = getCurrentVideoEditedInfo();
        if (!this.imagesArrLocals.isEmpty() && (i = this.currentIndex) >= 0 && i < this.imagesArrLocals.size()) {
            Object obj = this.imagesArrLocals.get(this.currentIndex);
            if (obj instanceof MediaController.MediaEditState) {
                ((MediaController.MediaEditState) obj).editedInfo = currentVideoEditedInfo;
            }
        }
        this.doneButtonPressed = true;
        if (!replace) {
            this.placeProvider.sendButtonPressed(this.currentIndex, currentVideoEditedInfo, notify, scheduleDate, forceDocument);
        } else {
            this.placeProvider.replaceButtonPressed(this.currentIndex, currentVideoEditedInfo);
        }
        closePhoto(false, false);
    }

    private void setMenuItemIcon() {
        if (this.speedItem.getVisibility() != 0) {
            this.menuItem.setIcon(R.drawable.ic_ab_other);
            return;
        }
        if (Math.abs(this.currentVideoSpeed - 0.25f) < 0.001f) {
            this.menuItem.setIcon(R.drawable.msg_more_0_2);
            this.speedItem.setSubtext(LocaleController.getString("SpeedVerySlow", R.string.SpeedVerySlow));
            return;
        }
        if (Math.abs(this.currentVideoSpeed - 0.5f) < 0.001f) {
            this.menuItem.setIcon(R.drawable.msg_more_0_5);
            this.speedItem.setSubtext(LocaleController.getString("SpeedSlow", R.string.SpeedSlow));
        } else if (Math.abs(this.currentVideoSpeed - 1.0f) < 0.001f) {
            this.menuItem.setIcon(R.drawable.ic_ab_other);
            this.speedItem.setSubtext(LocaleController.getString("SpeedNormal", R.string.SpeedNormal));
        } else if (Math.abs(this.currentVideoSpeed - 1.5f) < 0.001f) {
            this.menuItem.setIcon(R.drawable.msg_more_1_5);
            this.speedItem.setSubtext(LocaleController.getString("SpeedFast", R.string.SpeedFast));
        } else {
            this.menuItem.setIcon(R.drawable.msg_more_2);
            this.speedItem.setSubtext(LocaleController.getString("SpeedVeryFast", R.string.SpeedVeryFast));
        }
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
        this.flashView.animate().alpha(1.0f).setInterpolator(CubicBezierInterpolator.EASE_BOTH).setDuration(85L).setListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.PhotoViewer.34
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                PhotoViewer.this.photoCropView.setVideoThumb(bitmap, 0);
                PhotoViewer.this.flashAnimator = new AnimatorSet();
                PhotoViewer.this.flashAnimator.playTogether(ObjectAnimator.ofFloat(PhotoViewer.this.flashView, PhotoViewer.this.FLASH_VIEW_VALUE, 0.0f));
                PhotoViewer.this.flashAnimator.setDuration(85L);
                PhotoViewer.this.flashAnimator.setInterpolator(CubicBezierInterpolator.EASE_OUT);
                PhotoViewer.this.flashAnimator.addListener(new AnonymousClass1());
                PhotoViewer.this.flashAnimator.start();
            }

            /* renamed from: ir.eitaa.ui.PhotoViewer$34$1, reason: invalid class name */
            class AnonymousClass1 extends AnimatorListenerAdapter {
                AnonymousClass1() {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    if (PhotoViewer.this.flashAnimator == null) {
                        return;
                    }
                    AndroidUtilities.runOnUIThread(PhotoViewer.this.videoPlayRunnable = new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$34$1$fYA7t2lSAva6R3A8Xp_MilA8UD0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onAnimationEnd$0$PhotoViewer$34$1();
                        }
                    }, 860L);
                }

                /* JADX INFO: Access modifiers changed from: private */
                /* renamed from: lambda$onAnimationEnd$0, reason: merged with bridge method [inline-methods] */
                public /* synthetic */ void lambda$onAnimationEnd$0$PhotoViewer$34$1() {
                    PhotoViewer.this.manuallyPaused = false;
                    if (PhotoViewer.this.videoPlayer != null) {
                        PhotoViewer.this.videoPlayer.play();
                    }
                    PhotoViewer.this.videoPlayRunnable = null;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    PhotoViewer.this.flashAnimator = null;
                }
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: createCaptionTextView, reason: merged with bridge method [inline-methods] */
    public TextView lambda$setParentActivity$5$PhotoViewer(LinkMovementMethod linkMovementMethod) {
        TextView textView = new TextView(this.activityContext) { // from class: ir.eitaa.ui.PhotoViewer.35
            private boolean handleClicks;

            @Override // android.widget.TextView, android.view.View
            public boolean onTouchEvent(MotionEvent event) {
                if (event.getActionMasked() == 0) {
                    this.handleClicks = PhotoViewer.this.needCaptionLayout;
                }
                return PhotoViewer.this.bottomTouchEnabled && super.onTouchEvent(event);
            }

            @Override // android.view.View
            public void scrollTo(int x, int y) {
                if (getParent().getParent() == PhotoViewer.this.pickerView) {
                    super.scrollTo(x, y);
                    this.handleClicks = false;
                }
            }

            @Override // android.view.View
            public boolean performClick() {
                return this.handleClicks && super.performClick();
            }

            @Override // android.view.View
            public void setPressed(boolean pressed) {
                boolean z = pressed != isPressed();
                super.setPressed(pressed);
                if (z) {
                    invalidate();
                }
            }
        };
        ViewHelper.setPadding(textView, 16.0f, 8.0f, 16.0f, 8.0f);
        textView.setLinkTextColor(-8994063);
        textView.setTextColor(-1);
        textView.setHighlightColor(872415231);
        textView.setGravity(LayoutHelper.getAbsoluteGravityStart() | 16);
        textView.setTextSize(1, 16.0f);
        textView.setTypeface(AndroidUtilities.getFontFamily(false));
        textView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$_d6EqksVdXcBLMSuifbqii3cBs8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createCaptionTextView$39$PhotoViewer(view);
            }
        });
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createCaptionTextView$39, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createCaptionTextView$39$PhotoViewer(View view) {
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
    public void switchToPip(boolean fromGesture) {
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
                if (fromGesture) {
                    this.currentPlaceObject.imageReceiver.setAlpha(0.0f);
                    final ImageReceiver imageReceiver = this.currentPlaceObject.imageReceiver;
                    ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                    valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$cZjugwnLjBSZXf97u9LHqfmt34I
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            imageReceiver.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        }
                    });
                    valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.PhotoViewer.36
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animation2) {
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
            ir.eitaa.ui.Components.Rect pipRect = PipVideoView.getPipRect(this.aspectRatioFrameLayout.getAspectRatio());
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
            if (fromGesture) {
                if (translationY < y) {
                    cubicBezierInterpolator = new CubicBezierInterpolator(0.5d, 0.0d, 0.9d, 0.9d);
                } else {
                    cubicBezierInterpolator = new CubicBezierInterpolator(0.0d, 0.5d, 0.9d, 0.9d);
                }
            }
            final CubicBezierInterpolator cubicBezierInterpolator2 = cubicBezierInterpolator;
            valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$McQdqUw4bf7648vM_UMEosa3GhA
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f$0.lambda$switchToPip$41$PhotoViewer(cubicBezierInterpolator2, translationX, f, translationY2, f2, x, translationY, y, valueAnimator);
                }
            });
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ObjectAnimator.ofFloat(this.textureImageView, (Property<ImageView, Float>) View.SCALE_X, width), ObjectAnimator.ofFloat(this.textureImageView, (Property<ImageView, Float>) View.SCALE_Y, width), ObjectAnimator.ofFloat(this.videoTextureView, (Property<TextureView, Float>) View.SCALE_X, width), ObjectAnimator.ofFloat(this.videoTextureView, (Property<TextureView, Float>) View.SCALE_Y, width), ObjectAnimator.ofInt(this.backgroundDrawable, (Property<BackgroundDrawable, Integer>) AnimationProperties.COLOR_DRAWABLE_ALPHA, 0), valueAnimatorOfFloat2);
            if (fromGesture) {
                animatorSet.setInterpolator(CubicBezierInterpolator.EASE_OUT);
                animatorSet.setDuration(300L);
            } else {
                animatorSet.setInterpolator(new DecelerateInterpolator());
                animatorSet.setDuration(250L);
            }
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.PhotoViewer.37
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation2) {
                    PhotoViewer.this.pipAnimationInProgress = false;
                    PhotoViewer.this.switchToInlineRunnable.run();
                }
            });
            animatorSet.start();
            if (!fromGesture) {
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
    /* renamed from: lambda$switchToPip$41, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$switchToPip$41$PhotoViewer(CubicBezierInterpolator cubicBezierInterpolator, float f, float f2, float f3, float f4, float f5, float f6, float f7, ValueAnimator valueAnimator) {
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
        TextureView textureView;
        if (this.isInline) {
            if (Instance != null) {
                Instance.closePhoto(false, true);
            }
            PhotoViewerWebView photoViewerWebView = this.photoViewerWebView;
            if (photoViewerWebView != null) {
                photoViewerWebView.exitFromPip();
            }
            Instance = PipInstance;
            PipInstance = null;
            if (this.photoViewerWebView == null) {
                this.switchingInlineMode = true;
                Bitmap bitmap = this.currentBitmap;
                if (bitmap != null) {
                    bitmap.recycle();
                    this.currentBitmap = null;
                }
                this.changingTextureView = true;
            }
            this.isInline = false;
            if (this.photoViewerWebView == null && (textureView = this.videoTextureView) != null) {
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
            if (this.photoViewerWebView == null) {
                if (Build.VERSION.SDK_INT >= 21 && this.videoTextureView != null) {
                    this.pipAnimationInProgress = true;
                    ir.eitaa.ui.Components.Rect pipRect = PipVideoView.getPipRect(this.aspectRatioFrameLayout.getAspectRatio());
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
    public void showVideoSeekPreviewPosition(boolean show) {
        if (!show || this.videoPreviewFrame.getTag() == null) {
            if (show || this.videoPreviewFrame.getTag() != null) {
                if (show && !this.videoPreviewFrame.isReady()) {
                    this.needShowOnReady = true;
                    return;
                }
                AnimatorSet animatorSet = this.videoPreviewFrameAnimation;
                if (animatorSet != null) {
                    animatorSet.cancel();
                }
                this.videoPreviewFrame.setTag(show ? 1 : null);
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.videoPreviewFrameAnimation = animatorSet2;
                Animator[] animatorArr = new Animator[1];
                VideoSeekPreviewImage videoSeekPreviewImage = this.videoPreviewFrame;
                Property property = View.ALPHA;
                float[] fArr = new float[1];
                fArr[0] = show ? 1.0f : 0.0f;
                animatorArr[0] = ObjectAnimator.ofFloat(videoSeekPreviewImage, (Property<VideoSeekPreviewImage, Float>) property, fArr);
                animatorSet2.playTogether(animatorArr);
                this.videoPreviewFrameAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.PhotoViewer.38
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
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
        final VideoPlayerSeekBar.SeekBarDelegate seekBarDelegate = new VideoPlayerSeekBar.SeekBarDelegate() { // from class: ir.eitaa.ui.PhotoViewer.39
            @Override // ir.eitaa.ui.Components.VideoPlayerSeekBar.SeekBarDelegate
            public void onSeekBarDrag(float progress) {
                if (PhotoViewer.this.videoPlayer != null) {
                    if (!PhotoViewer.this.inPreview && PhotoViewer.this.videoTimelineView.getVisibility() == 0) {
                        progress = PhotoViewer.this.videoTimelineView.getLeftProgress() + ((PhotoViewer.this.videoTimelineView.getRightProgress() - PhotoViewer.this.videoTimelineView.getLeftProgress()) * progress);
                    }
                    if (PhotoViewer.this.videoPlayer.getDuration() == -9223372036854775807L) {
                        PhotoViewer.this.seekToProgressPending = progress;
                    } else {
                        PhotoViewer.this.videoPlayer.seekTo((int) (progress * r0));
                    }
                    PhotoViewer.this.showVideoSeekPreviewPosition(false);
                    PhotoViewer.this.needShowOnReady = false;
                }
            }

            @Override // ir.eitaa.ui.Components.VideoPlayerSeekBar.SeekBarDelegate
            public void onSeekBarContinuousDrag(float progress) {
                if (PhotoViewer.this.videoPlayer != null && PhotoViewer.this.videoPreviewFrame != null) {
                    PhotoViewer.this.videoPreviewFrame.setProgress(progress, PhotoViewer.this.videoPlayerSeekbar.getWidth());
                }
                PhotoViewer.this.showVideoSeekPreviewPosition(true);
                PhotoViewer.this.updateVideoSeekPreviewPosition();
            }
        };
        FloatSeekBarAccessibilityDelegate floatSeekBarAccessibilityDelegate = new FloatSeekBarAccessibilityDelegate() { // from class: ir.eitaa.ui.PhotoViewer.40
            @Override // ir.eitaa.ui.Components.FloatSeekBarAccessibilityDelegate
            public float getProgress() {
                return PhotoViewer.this.videoPlayerSeekbar.getProgress();
            }

            @Override // ir.eitaa.ui.Components.FloatSeekBarAccessibilityDelegate
            public void setProgress(float progress) {
                seekBarDelegate.onSeekBarDrag(progress);
                PhotoViewer.this.videoPlayerSeekbar.setProgress(progress);
                PhotoViewer.this.videoPlayerSeekbarView.invalidate();
            }

            @Override // ir.eitaa.ui.Components.SeekBarAccessibilityDelegate
            public String getContentDescription(View host) {
                return LocaleController.formatString("AccDescrPlayerDuration", R.string.AccDescrPlayerDuration, LocaleController.formatPluralString("Minutes", PhotoViewer.this.videoPlayerCurrentTime[0]) + ' ' + LocaleController.formatPluralString("Seconds", PhotoViewer.this.videoPlayerCurrentTime[1]), LocaleController.formatPluralString("Minutes", PhotoViewer.this.videoPlayerTotalTime[0]) + ' ' + LocaleController.formatPluralString("Seconds", PhotoViewer.this.videoPlayerTotalTime[1]));
            }
        };
        View view = new View(this.containerView.getContext()) { // from class: ir.eitaa.ui.PhotoViewer.41
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
        VideoSeekPreviewImage videoSeekPreviewImage = new VideoSeekPreviewImage(this.containerView.getContext(), new VideoSeekPreviewImage.VideoSeekPreviewImageDelegate() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$-ACr34igJtQQc2tUroJ3zlf7Nqg
            @Override // ir.eitaa.ui.Components.VideoSeekPreviewImage.VideoSeekPreviewImageDelegate
            public final void onReady() {
                this.f$0.lambda$createVideoControlsInterface$42$PhotoViewer();
            }
        }) { // from class: ir.eitaa.ui.PhotoViewer.42
            @Override // android.view.View
            protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
                super.onLayout(changed, left, top, right, bottom);
                PhotoViewer.this.updateVideoSeekPreviewPosition();
            }

            @Override // android.view.View
            public void setVisibility(int visibility) {
                super.setVisibility(visibility);
                if (visibility == 0) {
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
        this.videoPlayerTime.setTypeface(AndroidUtilities.getFontFamily(false));
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
        this.exitFullscreenButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$So1pLS7HC6mCfzaXOExvE97ivGM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$createVideoControlsInterface$43$PhotoViewer(view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createVideoControlsInterface$42, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createVideoControlsInterface$42$PhotoViewer() {
        if (this.needShowOnReady) {
            showVideoSeekPreviewPosition(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createVideoControlsInterface$43, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createVideoControlsInterface$43$PhotoViewer(View view) {
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
        this.keyboardAnimationEnabled = true;
        this.selectedPhotosListView.setEnabled(false);
        this.photosCounterView.setRotationX(0.0f);
        this.isPhotosListViewVisible = false;
        this.captionEditText.setTag(1);
        this.captionEditText.openKeyboard();
        this.captionEditText.setImportantForAccessibility(0);
        this.lastTitle = this.actionBar.getTitle();
        this.captionEditText.setVisibility(0);
    }

    private int[] fixVideoWidthHeight(int w, int h) {
        int[] iArr = {w, h};
        if (Build.VERSION.SDK_INT >= 21) {
            MediaCodec mediaCodecCreateEncoderByType = null;
            try {
                mediaCodecCreateEncoderByType = MediaCodec.createEncoderByType(MediaController.VIDEO_MIME_TYPE);
                MediaCodecInfo.VideoCapabilities videoCapabilities = mediaCodecCreateEncoderByType.getCodecInfo().getCapabilitiesForType(MediaController.VIDEO_MIME_TYPE).getVideoCapabilities();
                Range<Integer> supportedWidths = videoCapabilities.getSupportedWidths();
                Range<Integer> supportedHeights = videoCapabilities.getSupportedHeights();
                iArr[0] = Math.max(((Integer) supportedWidths.getLower()).intValue(), Math.round(w / 16.0f) * 16);
                iArr[1] = Math.max(((Integer) supportedHeights.getLower()).intValue(), Math.round(h / 16.0f) * 16);
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
                    cropState5.transformWidth = 800;
                }
                if (cropState5.transformHeight > 800) {
                    cropState5.transformHeight = 800;
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
    public void closeCaptionEnter(boolean apply) throws Resources.NotFoundException {
        int i = this.currentIndex;
        if (i < 0 || i >= this.imagesArrLocals.size() || this.captionEditText.getTag() == null) {
            return;
        }
        Object obj = this.imagesArrLocals.get(this.currentIndex);
        if (apply) {
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

    private void checkBufferedProgress(float progress) {
        MessageObject messageObject;
        TLRPC$Document document;
        if (!this.isStreaming || this.parentActivity == null || this.streamingAlertShown || this.videoPlayer == null || (messageObject = this.currentMessageObject) == null || (document = messageObject.getDocument()) == null || this.currentMessageObject.getDuration() < 20 || progress >= 0.9f) {
            return;
        }
        int i = document.size;
        if ((i * progress >= 5242880.0f || (progress >= 0.5f && i >= 2097152)) && Math.abs(SystemClock.elapsedRealtime() - this.startedPlayTime) >= 2000) {
            if (this.videoPlayer.getDuration() == -9223372036854775807L) {
                Toast.makeText(this.parentActivity, LocaleController.getString("VideoDoesNotSupportStreaming", R.string.VideoDoesNotSupportStreaming), 1).show();
            }
            this.streamingAlertShown = true;
        }
    }

    public void updateColors() {
        int themedColor = getThemedColor("dialogFloatingButton");
        ImageView imageView = this.pickerViewSendButton;
        if (imageView != null) {
            Drawable background = imageView.getBackground();
            Theme.setSelectorDrawableColor(background, themedColor, false);
            Theme.setSelectorDrawableColor(background, getThemedColor(Build.VERSION.SDK_INT >= 21 ? "dialogFloatingButtonPressed" : "dialogFloatingButton"), true);
            this.pickerViewSendButton.setColorFilter(new PorterDuffColorFilter(getThemedColor("dialogFloatingIcon"), PorterDuff.Mode.MULTIPLY));
        }
        CheckBox checkBox = this.checkImageView;
        if (checkBox != null) {
            checkBox.setColor(getThemedColor("dialogFloatingButton"), -1);
        }
        PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(themedColor, PorterDuff.Mode.MULTIPLY);
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
            pickerBottomLayoutViewer.doneButton.setTextColor(themedColor);
        }
        PickerBottomLayoutViewer pickerBottomLayoutViewer2 = this.qualityPicker;
        if (pickerBottomLayoutViewer2 != null) {
            pickerBottomLayoutViewer2.doneButton.setTextColor(themedColor);
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
            for (int i = 0; i < childCount; i++) {
                View childAt = this.selectedPhotosListView.getChildAt(i);
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

    public void injectVideoPlayer(VideoPlayer player) {
        this.injectingVideoPlayer = player;
    }

    public void injectVideoPlayerSurface(SurfaceTexture surface) {
        this.injectingVideoPlayerSurface = surface;
    }

    public boolean isInjectingVideoPlayer() {
        return this.injectingVideoPlayer != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleActionBarHide() {
        scheduleActionBarHide(3000);
    }

    private void scheduleActionBarHide(int delay) {
        if (isAccessibilityEnabled()) {
            return;
        }
        AndroidUtilities.cancelRunOnUIThread(this.hideActionBarRunnable);
        AndroidUtilities.runOnUIThread(this.hideActionBarRunnable, delay);
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
    public void updatePlayerState(boolean playWhenReady, int playbackState) {
        MessageObject messageObject;
        if (this.videoPlayer == null) {
            return;
        }
        float f = 0.0f;
        if (this.isStreaming) {
            if (playbackState != 2 || !this.skipFirstBufferingProgress) {
                boolean z = this.seekToProgressPending != 0.0f || playbackState == 2;
                if (z) {
                    AndroidUtilities.cancelRunOnUIThread(this.hideActionBarRunnable);
                } else {
                    scheduleActionBarHide();
                }
                toggleMiniProgress(z, true);
            } else if (playWhenReady) {
                this.skipFirstBufferingProgress = false;
            }
        }
        AspectRatioFrameLayout aspectRatioFrameLayout = this.aspectRatioFrameLayout;
        if (aspectRatioFrameLayout != null) {
            aspectRatioFrameLayout.setKeepScreenOn((!playWhenReady || playbackState == 4 || playbackState == 1) ? false : true);
        }
        if (playWhenReady && playbackState != 4 && playbackState != 1) {
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
        if (playbackState == 3 || playbackState == 1) {
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
        if (playbackState == 3) {
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
        } else if (playbackState == 2 && playWhenReady && (messageObject = this.currentMessageObject) != null && messageObject.isVideo()) {
            if (this.playerWasReady) {
                this.setLoadingRunnable.run();
            } else {
                AndroidUtilities.runOnUIThread(this.setLoadingRunnable, 1000L);
            }
        }
        if (this.videoPlayer.isPlaying() && playbackState != 4) {
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
        } else if (this.isPlaying || playbackState == 4) {
            if (this.currentEditMode != 3) {
                this.photoProgressViews[0].setIndexedAlpha(1, 1.0f, playbackState == 4);
                PhotoProgressView[] photoProgressViewArr = this.photoProgressViews;
                photoProgressViewArr[0].setBackgroundState(3, false, photoProgressViewArr[0].animAlphas[1] > 0.0f);
            }
            this.isPlaying = false;
            AndroidUtilities.cancelRunOnUIThread(this.updateProgressRunnable);
            if (playbackState == 4) {
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

    private void preparePlayer(Uri uri, boolean playWhenReady, boolean preview) {
        preparePlayer(uri, playWhenReady, preview, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void preparePlayer(android.net.Uri r22, boolean r23, boolean r24, ir.eitaa.messenger.MediaController.SavedFilterState r25) {
        /*
            Method dump skipped, instructions count: 824
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.PhotoViewer.preparePlayer(android.net.Uri, boolean, boolean, ir.eitaa.messenger.MediaController$SavedFilterState):void");
    }

    /* renamed from: ir.eitaa.ui.PhotoViewer$45, reason: invalid class name */
    class AnonymousClass45 implements VideoPlayer.VideoPlayerDelegate {
        @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
        public /* synthetic */ void onSeekFinished(AnalyticsListener.EventTime eventTime) {
            VideoPlayer.VideoPlayerDelegate.CC.$default$onSeekFinished(this, eventTime);
        }

        @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
        public /* synthetic */ void onSeekStarted(AnalyticsListener.EventTime eventTime) {
            VideoPlayer.VideoPlayerDelegate.CC.$default$onSeekStarted(this, eventTime);
        }

        AnonymousClass45() {
        }

        @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
        public void onStateChanged(boolean playWhenReady, int playbackState) {
            PhotoViewer.this.updatePlayerState(playWhenReady, playbackState);
        }

        @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
        public void onError(VideoPlayer player, Exception e) {
            if (PhotoViewer.this.videoPlayer != player) {
                return;
            }
            FileLog.e(e);
            if (PhotoViewer.this.menuItem.isSubItemVisible(11)) {
                AlertDialog.Builder builder = new AlertDialog.Builder(PhotoViewer.this.parentActivity, PhotoViewer.this.resourcesProvider);
                builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
                builder.setMessage(LocaleController.getString("CantPlayVideo", R.string.CantPlayVideo));
                builder.setPositiveButton(LocaleController.getString("Open", R.string.Open), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$45$Qz2fgkr6SH493vX7pF5RhydRwws
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onError$0$PhotoViewer$45(dialogInterface, i);
                    }
                });
                builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                PhotoViewer.this.showAlertDialog(builder);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onError$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onError$0$PhotoViewer$45(DialogInterface dialogInterface, int i) {
            try {
                AndroidUtilities.openForView(PhotoViewer.this.currentMessageObject, PhotoViewer.this.parentActivity, PhotoViewer.this.resourcesProvider);
                PhotoViewer.this.closePhoto(false, false);
            } catch (Exception e) {
                FileLog.e(e);
            }
        }

        @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
        public void onVideoSizeChanged(int width, int height, int unappliedRotationDegrees, float pixelWidthHeightRatio) {
            if (PhotoViewer.this.aspectRatioFrameLayout != null) {
                if (unappliedRotationDegrees != 90 && unappliedRotationDegrees != 270) {
                    height = width;
                    width = height;
                }
                PhotoViewer.this.aspectRatioFrameLayout.setAspectRatio(width == 0 ? 1.0f : (height * pixelWidthHeightRatio) / width, unappliedRotationDegrees);
                if (PhotoViewer.this.videoTextureView instanceof VideoEditTextureView) {
                    ((VideoEditTextureView) PhotoViewer.this.videoTextureView).setVideoSize((int) (height * pixelWidthHeightRatio), width);
                    if (PhotoViewer.this.sendPhotoType == 1) {
                        PhotoViewer.this.setCropBitmap();
                    }
                }
                PhotoViewer.this.videoSizeSet = true;
            }
        }

        @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
        public void onRenderedFirstFrame() {
            if (PhotoViewer.this.textureUploaded) {
                return;
            }
            PhotoViewer.this.textureUploaded = true;
            PhotoViewer.this.containerView.invalidate();
        }

        @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
        public void onRenderedFirstFrame(AnalyticsListener.EventTime eventTime) {
            if (eventTime.eventPlaybackPositionMs == PhotoViewer.this.needCaptureFrameReadyAtTime) {
                PhotoViewer.this.captureFrameReadyAtTime = eventTime.eventPlaybackPositionMs;
                PhotoViewer.this.needCaptureFrameReadyAtTime = -1L;
                PhotoViewer.this.captureCurrentFrame();
            }
        }

        @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
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

        @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
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
                    animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.PhotoViewer.45.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animation) {
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
                if (!messageObject.isVideo()) {
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
        AspectRatioFrameLayout aspectRatioFrameLayout = new AspectRatioFrameLayout(this.parentActivity) { // from class: ir.eitaa.ui.PhotoViewer.50
            @Override // com.google.android.exoplayer2.ui.AspectRatioFrameLayout, android.widget.FrameLayout, android.view.View
            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
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
                videoEditTextureView.setDelegate(new VideoEditTextureView.VideoEditTextureViewDelegate() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$xQ8d4Ob-3sI89XkIXCBOVPogPds
                    @Override // ir.eitaa.ui.Components.VideoEditTextureView.VideoEditTextureViewDelegate
                    public final void onEGLThreadAvailable(FilterGLThread filterGLThread) {
                        filterGLThread.setFilterGLThreadDelegate(FilterShaders.getFilterShadersDelegate(savedFilterState));
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
    public void releasePlayer(boolean onClose) {
        if (this.videoPlayer != null) {
            if (this.currentPlayingVideoFile != null) {
                ApplicationLoader.applicationContext.getSharedPreferences("VideoPlayerConfig", 0).edit().putLong("current_position" + this.currentPlayingVideoFile.toString(), this.videoPlayer.getCurrentPosition()).apply();
            }
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
        if (!onClose && !this.inPreview && !this.requestingPreview) {
            setVideoPlayerControlVisible(false, true);
        }
        this.photoProgressViews[0].resetAlphas();
    }

    private void setVideoPlayerControlVisible(final boolean visible, boolean animated) {
        if (this.videoPlayerControlVisible != visible) {
            Animator animator = this.videoPlayerControlAnimator;
            if (animator != null) {
                animator.cancel();
            }
            this.videoPlayerControlVisible = visible;
            if (animated) {
                if (visible) {
                    this.videoPlayerControlFrameLayout.setVisibility(0);
                } else {
                    this.dateTextView.setVisibility(0);
                    this.nameTextView.setVisibility(0);
                    if (this.allowShare) {
                        this.bottomButtonsLayout.setVisibility(0);
                    }
                }
                final boolean z = this.allowShare;
                float[] fArr = new float[2];
                fArr[0] = this.videoPlayerControlFrameLayout.getAlpha();
                fArr[1] = visible ? 1.0f : 0.0f;
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
                valueAnimatorOfFloat.setDuration(200L);
                valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$p62egucvMl59H9Kvx2nh5VWuw04
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        this.f$0.lambda$setVideoPlayerControlVisible$45$PhotoViewer(z, valueAnimator);
                    }
                });
                valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.PhotoViewer.51
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        if (!visible) {
                            PhotoViewer.this.videoPlayerControlFrameLayout.setVisibility(8);
                            return;
                        }
                        PhotoViewer.this.dateTextView.setVisibility(8);
                        PhotoViewer.this.nameTextView.setVisibility(8);
                        if (z) {
                            PhotoViewer.this.bottomButtonsLayout.setVisibility(8);
                        }
                    }
                });
                this.videoPlayerControlAnimator = valueAnimatorOfFloat;
                valueAnimatorOfFloat.start();
            } else {
                this.videoPlayerControlFrameLayout.setVisibility(visible ? 0 : 8);
                this.videoPlayerControlFrameLayout.setAlpha(visible ? 1.0f : 0.0f);
                this.dateTextView.setVisibility(visible ? 8 : 0);
                this.dateTextView.setAlpha(visible ? 0.0f : 1.0f);
                this.nameTextView.setVisibility(visible ? 8 : 0);
                this.nameTextView.setAlpha(visible ? 0.0f : 1.0f);
                if (this.allowShare) {
                    this.bottomButtonsLayout.setVisibility(visible ? 8 : 0);
                    this.bottomButtonsLayout.setAlpha(visible ? 0.0f : 1.0f);
                }
            }
            if (this.allowShare && this.pageBlocksAdapter == null) {
                if (visible) {
                    this.menuItem.showSubItem(10);
                } else {
                    this.menuItem.hideSubItem(10);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setVideoPlayerControlVisible$45, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setVideoPlayerControlVisible$45$PhotoViewer(boolean z, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.videoPlayerControlFrameLayout.setAlpha(fFloatValue);
        float f = 1.0f - fFloatValue;
        this.dateTextView.setAlpha(f);
        this.nameTextView.setAlpha(f);
        if (z) {
            this.bottomButtonsLayout.setAlpha(f);
        }
    }

    private void updateCaptionTextForCurrentPhoto(Object object) {
        CharSequence charSequence;
        if (object instanceof MediaController.PhotoEntry) {
            charSequence = ((MediaController.PhotoEntry) object).caption;
        } else {
            charSequence = (!(object instanceof TLRPC$BotInlineResult) && (object instanceof MediaController.SearchImage)) ? ((MediaController.SearchImage) object).caption : null;
        }
        if (TextUtils.isEmpty(charSequence)) {
            this.captionEditText.setFieldText("");
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
            this.visibleDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$GWJHBD6Lvz8KBD2xJaInT7AWr3U
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    this.f$0.lambda$showAlertDialog$46$PhotoViewer(dialogInterface);
                }
            });
        } catch (Exception e2) {
            FileLog.e(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showAlertDialog$46, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showAlertDialog$46$PhotoViewer(DialogInterface dialogInterface) {
        this.visibleDialog = null;
    }

    private void mergeImages(String finalPath, String thumbPath, Bitmap thumb, Bitmap bitmap, float size, boolean reverse) {
        boolean z;
        if (thumb == null) {
            try {
                thumb = BitmapFactory.decodeFile(thumbPath);
                z = true;
            } catch (Throwable th) {
                FileLog.e(th);
                return;
            }
        } else {
            z = false;
        }
        int width = thumb.getWidth();
        int height = thumb.getHeight();
        float f = width;
        if (f > size || height > size) {
            float fMax = Math.max(width, height) / size;
            height = (int) (height / fMax);
            width = (int) (f / fMax);
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Rect rect = new Rect(0, 0, width, height);
        if (reverse) {
            canvas.drawBitmap(bitmap, (Rect) null, rect, this.bitmapPaint);
            canvas.drawBitmap(thumb, (Rect) null, rect, this.bitmapPaint);
        } else {
            canvas.drawBitmap(thumb, (Rect) null, rect, this.bitmapPaint);
            canvas.drawBitmap(bitmap, (Rect) null, rect, this.bitmapPaint);
        }
        FileOutputStream fileOutputStream = new FileOutputStream(new File(finalPath));
        bitmapCreateBitmap.compress(Bitmap.CompressFormat.JPEG, size == 512.0f ? 83 : 87, fileOutputStream);
        try {
            fileOutputStream.close();
        } catch (Exception e) {
            FileLog.e(e);
        }
        if (z) {
            thumb.recycle();
        }
        bitmapCreateBitmap.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void seekAnimatedStickersTo(long ms) {
        RLottieDrawable lottieAnimation;
        ArrayList<VideoEditedInfo.MediaEntity> arrayList = this.editState.mediaEntities;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                VideoEditedInfo.MediaEntity mediaEntity = this.editState.mediaEntities.get(i);
                if (mediaEntity.type == 0 && (mediaEntity.subType & 1) != 0) {
                    View view = mediaEntity.view;
                    if ((view instanceof BackupImageView) && (lottieAnimation = ((BackupImageView) view).getImageReceiver().getLottieAnimation()) != null) {
                        long j = this.startTime;
                        lottieAnimation.setProgressMs(ms - (j > 0 ? j / 1000 : 0L));
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playOrStopAnimatedStickers(boolean play) {
        RLottieDrawable lottieAnimation;
        ArrayList<VideoEditedInfo.MediaEntity> arrayList = this.editState.mediaEntities;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                VideoEditedInfo.MediaEntity mediaEntity = this.editState.mediaEntities.get(i);
                if (mediaEntity.type == 0 && (mediaEntity.subType & 1) != 0) {
                    View view = mediaEntity.view;
                    if ((view instanceof BackupImageView) && (lottieAnimation = ((BackupImageView) view).getImageReceiver().getLottieAnimation()) != null) {
                        if (play) {
                            lottieAnimation.start();
                        } else {
                            lottieAnimation.stop();
                        }
                    }
                }
            }
        }
    }

    private int getAnimatedMediaEntitiesCount(boolean single) {
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
                if (single) {
                    break;
                }
            }
        }
        return i;
    }

    private boolean hasAnimatedMediaEntities() {
        return getAnimatedMediaEntitiesCount(true) != 0;
    }

    private Bitmap createCroppedBitmap(Bitmap bitmap, MediaController.CropState cropState, int[] extraTransform, boolean mirror) {
        int i;
        int i2;
        try {
            int i3 = cropState.transformRotation + (extraTransform != null ? extraTransform[0] : 0);
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
            if (mirror && cropState.mirrored) {
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
    /* JADX WARN: Type inference failed for: r12v2, types: [ir.eitaa.messenger.MediaController$SavedFilterState] */
    /* JADX WARN: Type inference failed for: r5v11, types: [java.util.ArrayList<ir.eitaa.tgnet.TLRPC$InputDocument>] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void applyCurrentEditMode() {
        /*
            Method dump skipped, instructions count: 2063
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.PhotoViewer.applyCurrentEditMode():void");
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
        PhotoCropView photoCropView = new PhotoCropView(this.activityContext, this.resourcesProvider);
        this.photoCropView = photoCropView;
        photoCropView.setVisibility(8);
        this.photoCropView.onDisappear();
        this.containerView.addView(this.photoCropView, this.containerView.indexOfChild(this.videoTimelineView) - 1, LayoutHelper.createFrame(-1, -1.0f, 51, 0.0f, 0.0f, 0.0f, 48.0f));
        this.photoCropView.setDelegate(new AnonymousClass52());
    }

    /* renamed from: ir.eitaa.ui.PhotoViewer$52, reason: invalid class name */
    class AnonymousClass52 implements PhotoCropView.PhotoCropViewDelegate {
        AnonymousClass52() {
        }

        @Override // ir.eitaa.ui.Components.PhotoCropView.PhotoCropViewDelegate
        public void onChange(boolean reset) {
            PhotoViewer.this.resetButton.setVisibility(reset ? 8 : 0);
        }

        @Override // ir.eitaa.ui.Components.PhotoCropView.PhotoCropViewDelegate
        public void onUpdate() {
            PhotoViewer.this.containerView.invalidate();
        }

        @Override // ir.eitaa.ui.Components.PhotoCropView.PhotoCropViewDelegate
        public void onTapUp() {
            if (PhotoViewer.this.sendPhotoType == 1) {
                PhotoViewer.this.manuallyPaused = true;
                PhotoViewer.this.toggleVideoPlayer();
            }
        }

        @Override // ir.eitaa.ui.Components.PhotoCropView.PhotoCropViewDelegate
        public void onVideoThumbClick() {
            if (PhotoViewer.this.videoPlayer == null) {
                return;
            }
            PhotoViewer.this.videoPlayer.seekTo((long) (PhotoViewer.this.videoPlayer.getDuration() * PhotoViewer.this.avatarStartProgress));
            PhotoViewer.this.videoPlayer.pause();
            PhotoViewer.this.videoTimelineView.setProgress(PhotoViewer.this.avatarStartProgress);
            PhotoViewer.this.cancelVideoPlayRunnable();
            AndroidUtilities.runOnUIThread(PhotoViewer.this.videoPlayRunnable = new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$52$QQWsii9wpaslYzQOZEhyAup27h4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onVideoThumbClick$0$PhotoViewer$52();
                }
            }, 860L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onVideoThumbClick$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onVideoThumbClick$0$PhotoViewer$52() {
            PhotoViewer.this.manuallyPaused = false;
            if (PhotoViewer.this.videoPlayer != null) {
                PhotoViewer.this.videoPlayer.play();
            }
            PhotoViewer.this.videoPlayRunnable = null;
        }

        @Override // ir.eitaa.ui.Components.PhotoCropView.PhotoCropViewDelegate
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

    private void detectFaces(final String key, final ImageReceiver.BitmapHolder bitmap, final int orientation) {
        if (key == null || bitmap == null || bitmap.bitmap == null) {
            return;
        }
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$glSEfIUFzKKs8xPPQe9BbGdftw0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$detectFaces$49$PhotoViewer(bitmap, orientation, key);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$detectFaces$49, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$detectFaces$49$PhotoViewer(final ImageReceiver.BitmapHolder bitmapHolder, int i, final String str) {
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
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$D9fb3oLA8UQFjcVErzfp-OTF3PM
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$detectFaces$47$PhotoViewer(str, z);
                        }
                    });
                } else {
                    if (BuildVars.LOGS_ENABLED) {
                        FileLog.e("face detection is not operational");
                    }
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$fGwCl1YEdL4vZoGay1BrSCpWwh4
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$detectFaces$48$PhotoViewer(bitmapHolder, str);
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
    /* renamed from: lambda$detectFaces$47, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$detectFaces$47$PhotoViewer(String str, boolean z) {
        if (str.equals(this.centerImage.getImageKey())) {
            this.currentImageHasFace = z ? 1 : 0;
            this.currentImageFaceKey = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$detectFaces$48, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$detectFaces$48$PhotoViewer(ImageReceiver.BitmapHolder bitmapHolder, String str) {
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
    private void switchToEditMode(final int r29) {
        /*
            Method dump skipped, instructions count: 2158
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.PhotoViewer.switchToEditMode(int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$switchToEditMode$50, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$switchToEditMode$50$PhotoViewer(View view) {
        applyCurrentEditMode();
        switchToEditMode(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$switchToEditMode$52, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$switchToEditMode$52$PhotoViewer(View view) {
        if (this.photoFilterView.hasChanges()) {
            Activity activity = this.parentActivity;
            if (activity == null) {
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(activity, this.resourcesProvider);
            builder.setMessage(LocaleController.getString("DiscardChanges", R.string.DiscardChanges));
            builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
            builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$RvpW4brg8Tr4qH0G4uV-D92Sv_0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$switchToEditMode$51$PhotoViewer(dialogInterface, i);
                }
            });
            builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            showAlertDialog(builder);
            return;
        }
        switchToEditMode(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$switchToEditMode$51, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$switchToEditMode$51$PhotoViewer(DialogInterface dialogInterface, int i) {
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
            PhotoPaintView photoPaintView = new PhotoPaintView(this.parentActivity, bitmap2, this.isCurrentVideo ? null : this.centerImage.getBitmap(), this.centerImage.getOrientation(), this.editState.mediaEntities, cropState, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$ToaV3UpNluo7k-688g7DRkNvZkM
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$createPaintView$53$PhotoViewer();
                }
            }, this.resourcesProvider) { // from class: ir.eitaa.ui.PhotoViewer.57
                @Override // ir.eitaa.ui.Components.PhotoPaintView
                protected void onOpenCloseStickersAlert(boolean open) {
                    if (PhotoViewer.this.videoPlayer == null) {
                        return;
                    }
                    PhotoViewer.this.manuallyPaused = false;
                    PhotoViewer.this.cancelVideoPlayRunnable();
                    if (open) {
                        PhotoViewer.this.videoPlayer.pause();
                    } else {
                        PhotoViewer.this.videoPlayer.play();
                    }
                }

                @Override // ir.eitaa.ui.Components.PhotoPaintView
                protected void didSetAnimatedSticker(RLottieDrawable drawable) {
                    if (PhotoViewer.this.videoPlayer == null) {
                        return;
                    }
                    drawable.setProgressMs(PhotoViewer.this.videoPlayer.getCurrentPosition() - (PhotoViewer.this.startTime > 0 ? PhotoViewer.this.startTime / 1000 : 0L));
                }

                @Override // ir.eitaa.ui.Components.PhotoPaintView
                protected void onTextAdd() {
                    if (PhotoViewer.this.windowView.isFocusable()) {
                        return;
                    }
                    PhotoViewer.this.makeFocusable();
                }
            };
            this.photoPaintView = photoPaintView;
            this.containerView.addView(photoPaintView, LayoutHelper.createFrame(-1, -1.0f));
            this.photoPaintView.getDoneTextView().setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$b8k_HD10TfLlCASBGHvuhDsnNMw
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$createPaintView$54$PhotoViewer(view);
                }
            });
            this.photoPaintView.getCancelTextView().setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$j09E_ef7eWZk3InwOURl2-p4tic
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$createPaintView$55$PhotoViewer(view);
                }
            });
            this.photoPaintView.getColorPicker().setTranslationY(AndroidUtilities.dp(126.0f));
            this.photoPaintView.getToolsView().setTranslationY(AndroidUtilities.dp(126.0f));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createPaintView$53, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createPaintView$53$PhotoViewer() {
        this.paintingOverlay.hideBitmap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createPaintView$54, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createPaintView$54$PhotoViewer(View view) {
        this.savedState = null;
        applyCurrentEditMode();
        switchToEditMode(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createPaintView$55, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createPaintView$55$PhotoViewer(View view) {
        closePaintMode();
    }

    private void closePaintMode() {
        this.photoPaintView.maybeShowDismissalAlert(this, this.parentActivity, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$MORNovlPOtmf4-ML5yablWTjLzc
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$closePaintMode$56$PhotoViewer();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$closePaintMode$56, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$closePaintMode$56$PhotoViewer() {
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
        this.imageMoveAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.PhotoViewer.58
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
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

    private void toggleCheckImageView(boolean show) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        float fDpf2 = AndroidUtilities.dpf2(24.0f);
        FrameLayout frameLayout = this.pickerView;
        Property property = View.ALPHA;
        float[] fArr = new float[1];
        fArr[0] = show ? 1.0f : 0.0f;
        arrayList.add(ObjectAnimator.ofFloat(frameLayout, (Property<FrameLayout, Float>) property, fArr));
        FrameLayout frameLayout2 = this.pickerView;
        Property property2 = View.TRANSLATION_Y;
        float[] fArr2 = new float[1];
        fArr2[0] = show ? 0.0f : fDpf2;
        arrayList.add(ObjectAnimator.ofFloat(frameLayout2, (Property<FrameLayout, Float>) property2, fArr2));
        ImageView imageView = this.pickerViewSendButton;
        Property property3 = View.ALPHA;
        float[] fArr3 = new float[1];
        fArr3[0] = show ? 1.0f : 0.0f;
        arrayList.add(ObjectAnimator.ofFloat(imageView, (Property<ImageView, Float>) property3, fArr3));
        ImageView imageView2 = this.pickerViewSendButton;
        Property property4 = View.TRANSLATION_Y;
        float[] fArr4 = new float[1];
        fArr4[0] = show ? 0.0f : fDpf2;
        arrayList.add(ObjectAnimator.ofFloat(imageView2, (Property<ImageView, Float>) property4, fArr4));
        int i = this.sendPhotoType;
        if (i == 0 || i == 4) {
            CheckBox checkBox = this.checkImageView;
            Property property5 = View.ALPHA;
            float[] fArr5 = new float[1];
            fArr5[0] = show ? 1.0f : 0.0f;
            arrayList.add(ObjectAnimator.ofFloat(checkBox, (Property<CheckBox, Float>) property5, fArr5));
            CheckBox checkBox2 = this.checkImageView;
            Property property6 = View.TRANSLATION_Y;
            float[] fArr6 = new float[1];
            fArr6[0] = show ? 0.0f : -fDpf2;
            arrayList.add(ObjectAnimator.ofFloat(checkBox2, (Property<CheckBox, Float>) property6, fArr6));
            CounterView counterView = this.photosCounterView;
            Property property7 = View.ALPHA;
            float[] fArr7 = new float[1];
            fArr7[0] = show ? 1.0f : 0.0f;
            arrayList.add(ObjectAnimator.ofFloat(counterView, (Property<CounterView, Float>) property7, fArr7));
            CounterView counterView2 = this.photosCounterView;
            Property property8 = View.TRANSLATION_Y;
            float[] fArr8 = new float[1];
            fArr8[0] = show ? 0.0f : -fDpf2;
            arrayList.add(ObjectAnimator.ofFloat(counterView2, (Property<CounterView, Float>) property8, fArr8));
        }
        animatorSet.playTogether(arrayList);
        animatorSet.setDuration(200L);
        animatorSet.start();
    }

    private void toggleMiniProgressInternal(final boolean show) {
        if (show) {
            this.miniProgressView.setVisibility(0);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        this.miniProgressAnimator = animatorSet;
        Animator[] animatorArr = new Animator[1];
        RadialProgressView radialProgressView = this.miniProgressView;
        Property property = View.ALPHA;
        float[] fArr = new float[1];
        fArr[0] = show ? 1.0f : 0.0f;
        animatorArr[0] = ObjectAnimator.ofFloat(radialProgressView, (Property<RadialProgressView, Float>) property, fArr);
        animatorSet.playTogether(animatorArr);
        this.miniProgressAnimator.setDuration(200L);
        this.miniProgressAnimator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.PhotoViewer.59
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                if (animation.equals(PhotoViewer.this.miniProgressAnimator)) {
                    if (!show) {
                        PhotoViewer.this.miniProgressView.setVisibility(4);
                    }
                    PhotoViewer.this.miniProgressAnimator = null;
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                if (animation.equals(PhotoViewer.this.miniProgressAnimator)) {
                    PhotoViewer.this.miniProgressAnimator = null;
                }
            }
        });
        this.miniProgressAnimator.start();
    }

    private void toggleMiniProgress(final boolean show, final boolean animated) {
        AndroidUtilities.cancelRunOnUIThread(this.miniProgressShowRunnable);
        if (animated) {
            toggleMiniProgressInternal(show);
            if (show) {
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
        this.miniProgressView.setAlpha(show ? 1.0f : 0.0f);
        this.miniProgressView.setVisibility(show ? 0 : 4);
    }

    private void updateContainerFlags(boolean actionBarVisible) {
        FrameLayoutDrawer frameLayoutDrawer;
        if (Build.VERSION.SDK_INT < 21 || this.sendPhotoType == 1 || (frameLayoutDrawer = this.containerView) == null) {
            return;
        }
        int i = 1792;
        if (!actionBarVisible) {
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

        public ActionBarToggleParams enableStatusBarAnimation(boolean val) {
            this.enableStatusBarAnimation = val;
            return this;
        }

        public ActionBarToggleParams enableTranslationAnimation(boolean val) {
            this.enableTranslationAnimation = val;
            return this;
        }

        public ActionBarToggleParams animationDuration(int val) {
            this.animationDuration = val;
            return this;
        }

        public ActionBarToggleParams animationInterpolator(Interpolator val) {
            this.animationInterpolator = val;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toggleActionBar(final boolean show, final boolean animated) {
        toggleActionBar(show, animated, ActionBarToggleParams.DEFAULT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toggleActionBar(final boolean show, final boolean animated, final ActionBarToggleParams params) {
        CaptionScrollView captionScrollView;
        CaptionScrollView captionScrollView2;
        AnimatorSet animatorSet = this.actionBarAnimator;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        if (show) {
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
        this.isActionBarVisible = show;
        if (params.enableStatusBarAnimation) {
            updateContainerFlags(show);
        }
        if (this.videoPlayerControlVisible && this.isPlaying && show) {
            scheduleActionBarHide();
        } else {
            AndroidUtilities.cancelRunOnUIThread(this.hideActionBarRunnable);
        }
        if (!show) {
            Bulletin.hide(this.containerView);
        }
        float fDpf2 = AndroidUtilities.dpf2(24.0f);
        this.videoPlayerControlFrameLayout.setSeekBarTransitionEnabled(params.enableTranslationAnimation && this.playerLooping);
        this.videoPlayerControlFrameLayout.setTranslationYAnimationEnabled(params.enableTranslationAnimation);
        if (animated) {
            ArrayList arrayList = new ArrayList();
            ActionBar actionBar = this.actionBar;
            Property property = View.ALPHA;
            float[] fArr = new float[1];
            fArr[0] = show ? 1.0f : 0.0f;
            arrayList.add(ObjectAnimator.ofFloat(actionBar, (Property<ActionBar, Float>) property, fArr));
            if (params.enableTranslationAnimation) {
                ActionBar actionBar2 = this.actionBar;
                Property property2 = View.TRANSLATION_Y;
                float[] fArr2 = new float[1];
                fArr2[0] = show ? 0.0f : -fDpf2;
                arrayList.add(ObjectAnimator.ofFloat(actionBar2, (Property<ActionBar, Float>) property2, fArr2));
            } else {
                this.actionBar.setTranslationY(0.0f);
            }
            if (this.allowShowFullscreenButton) {
                ImageView imageView = this.fullscreenButton[0];
                Property property3 = View.ALPHA;
                float[] fArr3 = new float[1];
                fArr3[0] = show ? 1.0f : 0.0f;
                arrayList.add(ObjectAnimator.ofFloat(imageView, (Property<ImageView, Float>) property3, fArr3));
            }
            for (int i = 1; i < 3; i++) {
                this.fullscreenButton[i].setTranslationY(show ? 0.0f : fDpf2);
            }
            if (params.enableTranslationAnimation) {
                ImageView imageView2 = this.fullscreenButton[0];
                Property property4 = View.TRANSLATION_Y;
                float[] fArr4 = new float[1];
                fArr4[0] = show ? 0.0f : fDpf2;
                arrayList.add(ObjectAnimator.ofFloat(imageView2, (Property<ImageView, Float>) property4, fArr4));
            } else {
                this.fullscreenButton[0].setTranslationY(0.0f);
            }
            FrameLayout frameLayout = this.bottomLayout;
            if (frameLayout != null) {
                Property property5 = View.ALPHA;
                float[] fArr5 = new float[1];
                fArr5[0] = show ? 1.0f : 0.0f;
                arrayList.add(ObjectAnimator.ofFloat(frameLayout, (Property<FrameLayout, Float>) property5, fArr5));
                if (params.enableTranslationAnimation) {
                    FrameLayout frameLayout2 = this.bottomLayout;
                    Property property6 = View.TRANSLATION_Y;
                    float[] fArr6 = new float[1];
                    fArr6[0] = show ? 0.0f : fDpf2;
                    arrayList.add(ObjectAnimator.ofFloat(frameLayout2, (Property<FrameLayout, Float>) property6, fArr6));
                } else {
                    this.bottomLayout.setTranslationY(0.0f);
                }
            }
            if (this.videoPlayerControlVisible) {
                VideoPlayerControlFrameLayout videoPlayerControlFrameLayout = this.videoPlayerControlFrameLayout;
                Property<VideoPlayerControlFrameLayout, Float> property7 = VPC_PROGRESS;
                float[] fArr7 = new float[1];
                fArr7[0] = show ? 1.0f : 0.0f;
                arrayList.add(ObjectAnimator.ofFloat(videoPlayerControlFrameLayout, property7, fArr7));
            } else {
                this.videoPlayerControlFrameLayout.setProgress(show ? 1.0f : 0.0f);
            }
            GroupedPhotosListView groupedPhotosListView = this.groupedPhotosListView;
            Property property8 = View.ALPHA;
            float[] fArr8 = new float[1];
            fArr8[0] = show ? 1.0f : 0.0f;
            arrayList.add(ObjectAnimator.ofFloat(groupedPhotosListView, (Property<GroupedPhotosListView, Float>) property8, fArr8));
            if (params.enableTranslationAnimation) {
                GroupedPhotosListView groupedPhotosListView2 = this.groupedPhotosListView;
                Property property9 = View.TRANSLATION_Y;
                float[] fArr9 = new float[1];
                fArr9[0] = show ? 0.0f : fDpf2;
                arrayList.add(ObjectAnimator.ofFloat(groupedPhotosListView2, (Property<GroupedPhotosListView, Float>) property9, fArr9));
            } else {
                this.groupedPhotosListView.setTranslationY(0.0f);
            }
            if (!this.needCaptionLayout && (captionScrollView2 = this.captionScrollView) != null) {
                Property property10 = View.ALPHA;
                float[] fArr10 = new float[1];
                fArr10[0] = show ? 1.0f : 0.0f;
                arrayList.add(ObjectAnimator.ofFloat(captionScrollView2, (Property<CaptionScrollView, Float>) property10, fArr10));
                if (params.enableTranslationAnimation) {
                    CaptionScrollView captionScrollView3 = this.captionScrollView;
                    Property property11 = View.TRANSLATION_Y;
                    float[] fArr11 = new float[1];
                    if (show) {
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
                fArr12[1] = show ? 1.0f : 0.0f;
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr12);
                valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$-nDexKdAoFPqyqMP562AhDOVchE
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        this.f$0.lambda$toggleActionBar$57$PhotoViewer(valueAnimator);
                    }
                });
                arrayList.add(valueAnimatorOfFloat);
            }
            if (this.muteItem.getTag() != null) {
                ImageView imageView3 = this.muteItem;
                Property property12 = View.ALPHA;
                float[] fArr13 = new float[1];
                fArr13[0] = show ? 1.0f : 0.0f;
                arrayList.add(ObjectAnimator.ofFloat(imageView3, (Property<ImageView, Float>) property12, fArr13));
            }
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.actionBarAnimator = animatorSet2;
            animatorSet2.playTogether(arrayList);
            this.actionBarAnimator.setDuration(params.animationDuration);
            this.actionBarAnimator.setInterpolator(params.animationInterpolator);
            this.actionBarAnimator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.PhotoViewer.60
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    if (animation.equals(PhotoViewer.this.actionBarAnimator)) {
                        if (!show) {
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
                public void onAnimationCancel(Animator animation) {
                    if (animation.equals(PhotoViewer.this.actionBarAnimator)) {
                        PhotoViewer.this.actionBarAnimator = null;
                    }
                }
            });
            this.actionBarAnimator.start();
            return;
        }
        this.actionBar.setAlpha(show ? 1.0f : 0.0f);
        if (this.fullscreenButton[0].getTranslationX() != 0.0f && this.allowShowFullscreenButton) {
            this.fullscreenButton[0].setAlpha(show ? 1.0f : 0.0f);
        }
        for (int i2 = 0; i2 < 3; i2++) {
            this.fullscreenButton[i2].setTranslationY(show ? 0.0f : fDpf2);
        }
        this.actionBar.setTranslationY(show ? 0.0f : -fDpf2);
        this.bottomLayout.setAlpha(show ? 1.0f : 0.0f);
        this.bottomLayout.setTranslationY(show ? 0.0f : fDpf2);
        this.groupedPhotosListView.setAlpha(show ? 1.0f : 0.0f);
        this.groupedPhotosListView.setTranslationY(show ? 0.0f : fDpf2);
        if (!this.needCaptionLayout && (captionScrollView = this.captionScrollView) != null) {
            captionScrollView.setAlpha(show ? 1.0f : 0.0f);
            CaptionScrollView captionScrollView4 = this.captionScrollView;
            if (show) {
                fDpf2 = 0.0f;
            }
            captionScrollView4.setTranslationY(fDpf2);
        }
        this.videoPlayerControlFrameLayout.setProgress(show ? 1.0f : 0.0f);
        if (this.muteItem.getTag() != null) {
            this.muteItem.setAlpha(show ? 1.0f : 0.0f);
        }
        if (this.videoPlayerControlVisible && this.isPlaying) {
            this.photoProgressViews[0].setIndexedAlpha(1, show ? 1.0f : 0.0f, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$toggleActionBar$57, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$toggleActionBar$57$PhotoViewer(ValueAnimator valueAnimator) {
        this.photoProgressViews[0].setIndexedAlpha(1, ((Float) valueAnimator.getAnimatedValue()).floatValue(), false);
    }

    private void togglePhotosListView(boolean show, final boolean animated) {
        if (show == this.isPhotosListViewVisible) {
            return;
        }
        if (show) {
            this.selectedPhotosListView.setVisibility(0);
        }
        this.isPhotosListViewVisible = show;
        this.selectedPhotosListView.setEnabled(show);
        if (animated) {
            ArrayList arrayList = new ArrayList();
            SelectedPhotosListView selectedPhotosListView = this.selectedPhotosListView;
            Property property = View.ALPHA;
            float[] fArr = new float[1];
            fArr[0] = show ? 1.0f : 0.0f;
            arrayList.add(ObjectAnimator.ofFloat(selectedPhotosListView, (Property<SelectedPhotosListView, Float>) property, fArr));
            SelectedPhotosListView selectedPhotosListView2 = this.selectedPhotosListView;
            Property property2 = View.TRANSLATION_Y;
            float[] fArr2 = new float[1];
            fArr2[0] = show ? 0.0f : -AndroidUtilities.dp(10.0f);
            arrayList.add(ObjectAnimator.ofFloat(selectedPhotosListView2, (Property<SelectedPhotosListView, Float>) property2, fArr2));
            CounterView counterView = this.photosCounterView;
            Property property3 = View.ROTATION_X;
            float[] fArr3 = new float[1];
            fArr3[0] = show ? 1.0f : 0.0f;
            arrayList.add(ObjectAnimator.ofFloat(counterView, (Property<CounterView, Float>) property3, fArr3));
            AnimatorSet animatorSet = new AnimatorSet();
            this.currentListViewAnimation = animatorSet;
            animatorSet.playTogether(arrayList);
            if (!show) {
                this.currentListViewAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.PhotoViewer.61
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        if (PhotoViewer.this.currentListViewAnimation == null || !PhotoViewer.this.currentListViewAnimation.equals(animation)) {
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
        this.selectedPhotosListView.setAlpha(show ? 1.0f : 0.0f);
        this.selectedPhotosListView.setTranslationY(show ? 0.0f : -AndroidUtilities.dp(10.0f));
        this.photosCounterView.setRotationX(show ? 1.0f : 0.0f);
        if (show) {
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

    private String getFileName(int index) {
        if (index < 0) {
            return null;
        }
        if (!this.secureDocuments.isEmpty()) {
            if (index >= this.secureDocuments.size()) {
                return null;
            }
            SecureDocument secureDocument = this.secureDocuments.get(index);
            return secureDocument.secureFile.dc_id + "_" + secureDocument.secureFile.id + ".jpg";
        }
        if (!this.imagesArrLocations.isEmpty() || !this.imagesArr.isEmpty()) {
            if (!this.imagesArrLocations.isEmpty()) {
                if (index >= this.imagesArrLocations.size()) {
                    return null;
                }
                ImageLocation imageLocation = this.imagesArrLocations.get(index);
                ImageLocation imageLocation2 = this.imagesArrLocationsVideo.get(index);
                if (imageLocation == null) {
                    return null;
                }
                if (imageLocation2 != imageLocation) {
                    return imageLocation2.location.volume_id + "_" + imageLocation2.location.local_id + ".mp4";
                }
                return imageLocation.location.volume_id + "_" + imageLocation.location.local_id + ".jpg";
            }
            if (index >= this.imagesArr.size()) {
                return null;
            }
            return FileLoader.getMessageFileName(this.imagesArr.get(index).messageOwner);
        }
        if (!this.imagesArrLocals.isEmpty()) {
            if (index >= this.imagesArrLocals.size()) {
                return null;
            }
            Object obj = this.imagesArrLocals.get(index);
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
                return pageBlocksAdapter.getFileName(index);
            }
        }
        return null;
    }

    private ImageLocation getImageLocation(int index, int[] size) {
        if (index < 0) {
            return null;
        }
        if (!this.secureDocuments.isEmpty()) {
            if (index >= this.secureDocuments.size()) {
                return null;
            }
            if (size != null) {
                size[0] = this.secureDocuments.get(index).secureFile.size;
            }
            return ImageLocation.getForSecureDocument(this.secureDocuments.get(index));
        }
        if (!this.imagesArrLocations.isEmpty()) {
            if (index >= this.imagesArrLocations.size()) {
                return null;
            }
            if (size != null) {
                size[0] = this.imagesArrLocationsSizes.get(index).intValue();
            }
            return this.imagesArrLocationsVideo.get(index);
        }
        if (this.imagesArr.isEmpty() || index >= this.imagesArr.size()) {
            return null;
        }
        MessageObject messageObject = this.imagesArr.get(index);
        TLRPC$Message tLRPC$Message = messageObject.messageOwner;
        if (tLRPC$Message instanceof TLRPC$TL_messageService) {
            if (tLRPC$Message.action instanceof TLRPC$TL_messageActionUserUpdatedPhoto) {
                return null;
            }
            TLRPC$PhotoSize closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(messageObject.photoThumbs, AndroidUtilities.getPhotoSize());
            if (closestPhotoSizeWithSize != null) {
                if (size != null) {
                    size[0] = closestPhotoSizeWithSize.size;
                    if (size[0] == 0) {
                        size[0] = -1;
                    }
                }
                return ImageLocation.getForObject(closestPhotoSizeWithSize, messageObject.photoThumbsObject);
            }
            if (size != null) {
                size[0] = -1;
            }
        } else {
            TLRPC$MessageMedia tLRPC$MessageMedia = tLRPC$Message.media;
            if (((tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaPhoto) && tLRPC$MessageMedia.photo != null) || ((tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaWebPage) && tLRPC$MessageMedia.webpage != null)) {
                if (messageObject.isGif()) {
                    return ImageLocation.getForDocument(messageObject.getDocument());
                }
                TLRPC$PhotoSize closestPhotoSizeWithSize2 = FileLoader.getClosestPhotoSizeWithSize(messageObject.photoThumbs, AndroidUtilities.getPhotoSize(), false, null, true);
                if (closestPhotoSizeWithSize2 != null) {
                    if (size != null) {
                        size[0] = closestPhotoSizeWithSize2.size;
                        if (size[0] == 0) {
                            size[0] = -1;
                        }
                    }
                    return ImageLocation.getForObject(closestPhotoSizeWithSize2, messageObject.photoThumbsObject);
                }
                if (size != null) {
                    size[0] = -1;
                }
            } else {
                if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaInvoice) {
                    return ImageLocation.getForWebFile(WebFile.createWithWebDocument(((TLRPC$TL_messageMediaInvoice) tLRPC$MessageMedia).photo));
                }
                if (messageObject.getDocument() != null) {
                    TLRPC$Document document = messageObject.getDocument();
                    if (this.sharedMediaType == 5) {
                        return ImageLocation.getForDocument(document);
                    }
                    if (MessageObject.isDocumentHasThumb(messageObject.getDocument())) {
                        TLRPC$PhotoSize closestPhotoSizeWithSize3 = FileLoader.getClosestPhotoSizeWithSize(document.thumbs, 90);
                        if (size != null) {
                            size[0] = closestPhotoSizeWithSize3.size;
                            if (size[0] == 0) {
                                size[0] = -1;
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
    public TLObject getFileLocation(int index, int[] size) {
        if (index < 0) {
            return null;
        }
        if (!this.secureDocuments.isEmpty()) {
            if (index >= this.secureDocuments.size()) {
                return null;
            }
            if (size != null) {
                size[0] = this.secureDocuments.get(index).secureFile.size;
            }
            return this.secureDocuments.get(index);
        }
        if (!this.imagesArrLocations.isEmpty()) {
            if (index >= this.imagesArrLocations.size()) {
                return null;
            }
            if (size != null) {
                size[0] = this.imagesArrLocationsSizes.get(index).intValue();
            }
            return this.imagesArrLocationsVideo.get(index).location;
        }
        if (this.imagesArr.isEmpty() || index >= this.imagesArr.size()) {
            return null;
        }
        MessageObject messageObject = this.imagesArr.get(index);
        TLRPC$Message tLRPC$Message = messageObject.messageOwner;
        if (tLRPC$Message instanceof TLRPC$TL_messageService) {
            TLRPC$MessageAction tLRPC$MessageAction = tLRPC$Message.action;
            if (tLRPC$MessageAction instanceof TLRPC$TL_messageActionUserUpdatedPhoto) {
                return tLRPC$MessageAction.newUserPhoto.photo_big;
            }
            TLRPC$PhotoSize closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(messageObject.photoThumbs, AndroidUtilities.getPhotoSize());
            if (closestPhotoSizeWithSize != null) {
                if (size != null) {
                    size[0] = closestPhotoSizeWithSize.size;
                    if (size[0] == 0) {
                        size[0] = -1;
                    }
                }
                return closestPhotoSizeWithSize;
            }
            if (size != null) {
                size[0] = -1;
            }
        } else {
            TLRPC$MessageMedia tLRPC$MessageMedia = tLRPC$Message.media;
            if (((tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaPhoto) && tLRPC$MessageMedia.photo != null) || ((tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaWebPage) && tLRPC$MessageMedia.webpage != null)) {
                TLRPC$PhotoSize closestPhotoSizeWithSize2 = FileLoader.getClosestPhotoSizeWithSize(messageObject.photoThumbs, AndroidUtilities.getPhotoSize(), false, null, true);
                if (closestPhotoSizeWithSize2 != null) {
                    if (size != null) {
                        size[0] = closestPhotoSizeWithSize2.size;
                        if (size[0] == 0) {
                            size[0] = -1;
                        }
                    }
                    return closestPhotoSizeWithSize2;
                }
                if (size != null) {
                    size[0] = -1;
                }
            } else {
                if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaInvoice) {
                    return ((TLRPC$TL_messageMediaInvoice) tLRPC$MessageMedia).photo;
                }
                if (messageObject.getDocument() != null && MessageObject.isDocumentHasThumb(messageObject.getDocument())) {
                    TLRPC$PhotoSize closestPhotoSizeWithSize3 = FileLoader.getClosestPhotoSizeWithSize(messageObject.getDocument().thumbs, 90);
                    if (size != null) {
                        size[0] = closestPhotoSizeWithSize3.size;
                        if (size[0] == 0) {
                            size[0] = -1;
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

    private void setItemVisible(View itemView, boolean visible, boolean animate) {
        setItemVisible(itemView, visible, animate, 1.0f);
    }

    private void setItemVisible(final View itemView, final boolean visible, boolean animate, float maxAlpha) {
        Boolean bool = this.actionBarItemsVisibility.get(itemView);
        if (bool == null || bool.booleanValue() != visible) {
            this.actionBarItemsVisibility.put(itemView, Boolean.valueOf(visible));
            itemView.animate().cancel();
            float f = (visible ? 1.0f : 0.0f) * maxAlpha;
            if (animate && bool != null) {
                if (visible) {
                    itemView.setVisibility(0);
                }
                itemView.animate().alpha(f).setDuration(100L).setInterpolator(new LinearInterpolator()).withEndAction(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$jUGVSLmstAFUA_DANpsdqJNiS_s
                    @Override // java.lang.Runnable
                    public final void run() {
                        PhotoViewer.lambda$setItemVisible$58(visible, itemView);
                    }
                }).start();
            } else {
                itemView.setVisibility(visible ? 0 : 8);
                itemView.setAlpha(f);
            }
        }
    }

    static /* synthetic */ void lambda$setItemVisible$58(boolean z, View view) {
        if (z) {
            return;
        }
        view.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:125:0x040f  */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v2, types: [android.animation.AnimatorSet, java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v21 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onPhotoShow(final ir.eitaa.messenger.MessageObject r18, final ir.eitaa.tgnet.TLRPC$FileLocation r19, ir.eitaa.messenger.ImageLocation r20, ir.eitaa.messenger.ImageLocation r21, final java.util.ArrayList<ir.eitaa.messenger.MessageObject> r22, final java.util.ArrayList<ir.eitaa.messenger.SecureDocument> r23, final java.util.List<java.lang.Object> r24, int r25, final ir.eitaa.ui.PhotoViewer.PlaceProviderObject r26) throws java.lang.InterruptedException, android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 2104
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.PhotoViewer.onPhotoShow(ir.eitaa.messenger.MessageObject, ir.eitaa.tgnet.TLRPC$FileLocation, ir.eitaa.messenger.ImageLocation, ir.eitaa.messenger.ImageLocation, java.util.ArrayList, java.util.ArrayList, java.util.List, int, ir.eitaa.ui.PhotoViewer$PlaceProviderObject):void");
    }

    private boolean canSendMediaToParentChatActivity() {
        TLRPC$Chat tLRPC$Chat;
        ChatActivity chatActivity = this.parentChatActivity;
        return (chatActivity == null || (chatActivity.currentUser == null && ((tLRPC$Chat = chatActivity.currentChat) == null || ChatObject.isNotInChat(tLRPC$Chat) || !ChatObject.canSendMedia(this.parentChatActivity.currentChat)))) ? false : true;
    }

    private void setDoubleTapEnabled(boolean value) {
        this.doubleTapEnabled = value;
        this.gestureDetector.setOnDoubleTapListener(value ? this : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImages() throws Resources.NotFoundException {
        if (this.animationInProgress == 0) {
            setIndexToImage(this.centerImage, this.currentIndex);
            setIndexToImage(this.rightImage, this.currentIndex + 1);
            setIndexToImage(this.leftImage, this.currentIndex - 1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:154:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0690  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x06bd  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x06c4  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x07bc  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x08cd  */
    /* JADX WARN: Removed duplicated region for block: B:386:0x0992  */
    /* JADX WARN: Removed duplicated region for block: B:395:0x09ba  */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v20 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void setIsAboutToSwitchToIndex(int r30, boolean r31, boolean r32) throws java.lang.InterruptedException, android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 3061
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.PhotoViewer.setIsAboutToSwitchToIndex(int, boolean, boolean):void");
    }

    private void showVideoTimeline(boolean show, boolean animated) {
        if (!animated) {
            this.videoTimelineView.animate().setListener(null).cancel();
            this.videoTimelineView.setVisibility(show ? 0 : 8);
            this.videoTimelineView.setTranslationY(0.0f);
            this.videoTimelineView.setAlpha(this.pickerView.getAlpha());
        } else if (show && this.videoTimelineView.getTag() == null) {
            if (this.videoTimelineView.getVisibility() != 0) {
                this.videoTimelineView.setVisibility(0);
                this.videoTimelineView.setAlpha(this.pickerView.getAlpha());
                this.videoTimelineView.setTranslationY(AndroidUtilities.dp(58.0f));
            }
            ObjectAnimator objectAnimator = this.videoTimelineAnimator;
            if (objectAnimator != null) {
                objectAnimator.removeAllListeners();
                this.videoTimelineAnimator.cancel();
            }
            VideoTimelinePlayView videoTimelinePlayView = this.videoTimelineView;
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(videoTimelinePlayView, (Property<VideoTimelinePlayView, Float>) View.TRANSLATION_Y, videoTimelinePlayView.getTranslationY(), 0.0f);
            this.videoTimelineAnimator = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(220L);
            this.videoTimelineAnimator.setInterpolator(CubicBezierInterpolator.DEFAULT);
            this.videoTimelineAnimator.start();
        } else if (!show && this.videoTimelineView.getTag() != null) {
            ObjectAnimator objectAnimator2 = this.videoTimelineAnimator;
            if (objectAnimator2 != null) {
                objectAnimator2.removeAllListeners();
                this.videoTimelineAnimator.cancel();
            }
            VideoTimelinePlayView videoTimelinePlayView2 = this.videoTimelineView;
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(videoTimelinePlayView2, (Property<VideoTimelinePlayView, Float>) View.TRANSLATION_Y, videoTimelinePlayView2.getTranslationY(), AndroidUtilities.dp(58.0f));
            this.videoTimelineAnimator = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.addListener(new HideViewAfterAnimation(this.videoTimelineView));
            this.videoTimelineAnimator.setDuration(220L);
            this.videoTimelineAnimator.setInterpolator(CubicBezierInterpolator.DEFAULT);
            this.videoTimelineAnimator.start();
        }
        this.videoTimelineView.setTag(show ? 1 : null);
    }

    public static TLRPC$FileLocation getFileLocation(ImageLocation location) {
        if (location == null) {
            return null;
        }
        return location.location;
    }

    public static String getFileLocationExt(ImageLocation location) {
        if (location == null || location.imageType != 2) {
            return null;
        }
        return "mp4";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImageIndex(int index) throws InterruptedException, Resources.NotFoundException {
        setImageIndex(index, true, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x012b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void setImageIndex(int r45, boolean r46, boolean r47) throws java.lang.InterruptedException, android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 1254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.PhotoViewer.setImageIndex(int, boolean, boolean):void");
    }

    private void setCurrentCaption(MessageObject messageObject, final CharSequence caption, boolean animated) throws Resources.NotFoundException {
        int i;
        boolean z;
        CharSequence charSequenceReplaceEmoji;
        int i2;
        boolean z2 = true;
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
        boolean zIsEmpty = TextUtils.isEmpty(caption);
        boolean zIsEmpty2 = TextUtils.isEmpty(this.captionTextViewSwitcher.getCurrentView().getText());
        CaptionTextViewSwitcher captionTextViewSwitcher = this.captionTextViewSwitcher;
        TextView nextView = animated ? captionTextViewSwitcher.getNextView() : captionTextViewSwitcher.getCurrentView();
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
        boolean z3 = this.needCaptionLayout;
        this.dontChangeCaptionPosition = !z3 && animated && zIsEmpty;
        if (!z3) {
            this.captionScrollView.dontChangeTopMargin = false;
        }
        if (animated && (i2 = Build.VERSION.SDK_INT) >= 19) {
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
                TransitionSet duration = new TransitionSet().addTransition(new AnonymousClass63(2, zIsEmpty2, zIsEmpty)).addTransition(new AnonymousClass62(1, zIsEmpty2, zIsEmpty)).setDuration(200L);
                if (!zIsEmpty2) {
                    this.captionScrollView.dontChangeTopMargin = true;
                    duration.addTransition(new AnonymousClass64());
                }
                if (zIsEmpty2 && !zIsEmpty) {
                    duration.addTarget((View) this.captionTextViewSwitcher);
                }
                TransitionManager.beginDelayedTransition(this.captionScrollView, duration);
            }
            z = true;
        } else {
            this.captionTextViewSwitcher.getCurrentView().setText((CharSequence) null);
            CaptionScrollView captionScrollView = this.captionScrollView;
            if (captionScrollView != null) {
                captionScrollView.scrollTo(0, 0);
            }
            z = false;
        }
        if (!zIsEmpty) {
            Theme.createChatResources(null, true);
            if (messageObject != null && !messageObject.messageOwner.entities.isEmpty()) {
                SpannableString spannableStringValueOf = SpannableString.valueOf(caption.toString());
                messageObject.addEntitiesToText(spannableStringValueOf, true, false);
                if (messageObject.isVideo()) {
                    MessageObject.addUrlsByPattern(messageObject.isOutOwner(), spannableStringValueOf, false, 3, messageObject.getDuration(), false);
                }
                charSequenceReplaceEmoji = Emoji.replaceEmoji(spannableStringValueOf, nextView.getPaint().getFontMetricsInt(), AndroidUtilities.dp(20.0f), false);
            } else {
                charSequenceReplaceEmoji = Emoji.replaceEmoji(new SpannableStringBuilder(caption), nextView.getPaint().getFontMetricsInt(), AndroidUtilities.dp(20.0f), false);
            }
            this.captionTextViewSwitcher.setTag(charSequenceReplaceEmoji);
            try {
                this.captionTextViewSwitcher.setText(charSequenceReplaceEmoji, animated);
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
                z2 = false;
            }
            this.captionTextViewSwitcher.setVisibility(z2 ? 0 : 4);
            return;
        }
        if (this.needCaptionLayout) {
            this.captionTextViewSwitcher.setText(LocaleController.getString("AddCaption", R.string.AddCaption), animated);
            this.captionTextViewSwitcher.getCurrentView().setTextColor(-1291845633);
            this.captionTextViewSwitcher.setTag("empty");
            this.captionTextViewSwitcher.setVisibility(0);
            return;
        }
        this.captionTextViewSwitcher.setText(null, animated);
        this.captionTextViewSwitcher.getCurrentView().setTextColor(-1);
        CaptionTextViewSwitcher captionTextViewSwitcher2 = this.captionTextViewSwitcher;
        if (z && !zIsEmpty2) {
            z2 = false;
        }
        captionTextViewSwitcher2.setVisibility(4, z2);
        this.captionTextViewSwitcher.setTag(null);
    }

    /* renamed from: ir.eitaa.ui.PhotoViewer$63, reason: invalid class name */
    class AnonymousClass63 extends Fade {
        final /* synthetic */ boolean val$isCaptionEmpty;
        final /* synthetic */ boolean val$isCurrentCaptionEmpty;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass63(int fadingMode, final boolean val$isCurrentCaptionEmpty, final boolean val$isCaptionEmpty) {
            super(fadingMode);
            this.val$isCurrentCaptionEmpty = val$isCurrentCaptionEmpty;
            this.val$isCaptionEmpty = val$isCaptionEmpty;
        }

        @Override // android.transition.Fade, android.transition.Visibility
        public Animator onDisappear(ViewGroup sceneRoot, View view, TransitionValues startValues, TransitionValues endValues) {
            Animator animatorOnDisappear = super.onDisappear(sceneRoot, view, startValues, endValues);
            if (!this.val$isCurrentCaptionEmpty && this.val$isCaptionEmpty && view == PhotoViewer.this.captionTextViewSwitcher) {
                animatorOnDisappear.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.PhotoViewer.63.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        PhotoViewer.this.captionScrollView.setVisibility(4);
                        PhotoViewer.this.captionScrollView.backgroundAlpha = 1.0f;
                    }
                });
                ((ObjectAnimator) animatorOnDisappear).addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$63$R_VEjCHEmyi4ZDDs8nUCHiO_ei8
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        this.f$0.lambda$onDisappear$0$PhotoViewer$63(valueAnimator);
                    }
                });
            }
            return animatorOnDisappear;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onDisappear$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onDisappear$0$PhotoViewer$63(ValueAnimator valueAnimator) {
            PhotoViewer.this.captionScrollView.backgroundAlpha = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            PhotoViewer.this.captionScrollView.invalidate();
        }
    }

    /* renamed from: ir.eitaa.ui.PhotoViewer$62, reason: invalid class name */
    class AnonymousClass62 extends Fade {
        final /* synthetic */ boolean val$isCaptionEmpty;
        final /* synthetic */ boolean val$isCurrentCaptionEmpty;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass62(int fadingMode, final boolean val$isCurrentCaptionEmpty, final boolean val$isCaptionEmpty) {
            super(fadingMode);
            this.val$isCurrentCaptionEmpty = val$isCurrentCaptionEmpty;
            this.val$isCaptionEmpty = val$isCaptionEmpty;
        }

        @Override // android.transition.Fade, android.transition.Visibility
        public Animator onAppear(ViewGroup sceneRoot, View view, TransitionValues startValues, TransitionValues endValues) {
            Animator animatorOnAppear = super.onAppear(sceneRoot, view, startValues, endValues);
            if (this.val$isCurrentCaptionEmpty && !this.val$isCaptionEmpty && view == PhotoViewer.this.captionTextViewSwitcher) {
                animatorOnAppear.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.PhotoViewer.62.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        PhotoViewer.this.captionScrollView.backgroundAlpha = 1.0f;
                    }
                });
                ((ObjectAnimator) animatorOnAppear).addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$62$uhhIm_X1S-hRv1CQ0WomoKB0iPc
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        this.f$0.lambda$onAppear$0$PhotoViewer$62(valueAnimator);
                    }
                });
            }
            return animatorOnAppear;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onAppear$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onAppear$0$PhotoViewer$62(ValueAnimator valueAnimator) {
            PhotoViewer.this.captionScrollView.backgroundAlpha = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            PhotoViewer.this.captionScrollView.invalidate();
        }
    }

    /* renamed from: ir.eitaa.ui.PhotoViewer$64, reason: invalid class name */
    class AnonymousClass64 extends Transition {
        AnonymousClass64() {
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
        public Animator createAnimator(ViewGroup sceneRoot, TransitionValues startValues, TransitionValues endValues) {
            int iIntValue;
            if (startValues.view != PhotoViewer.this.captionScrollView) {
                if (endValues.view != PhotoViewer.this.captionTextViewSwitcher || (iIntValue = ((Integer) endValues.values.get("translationY")).intValue()) == 0) {
                    return null;
                }
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(PhotoViewer.this.captionTextViewSwitcher, (Property<CaptionTextViewSwitcher, Float>) View.TRANSLATION_Y, 0.0f, iIntValue);
                objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.PhotoViewer.64.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        PhotoViewer.this.captionTextViewSwitcher.setTranslationY(0.0f);
                    }
                });
                return objectAnimatorOfFloat;
            }
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(((Integer) startValues.values.get("scrollY")).intValue(), 0);
            valueAnimatorOfInt.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.PhotoViewer.64.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    PhotoViewer.this.captionTextViewSwitcher.getNextView().setText((CharSequence) null);
                    PhotoViewer.this.captionScrollView.applyPendingTopMargin();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                    PhotoViewer.this.captionScrollView.stopScrolling();
                }
            });
            valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$64$5Wz-4kqdswIGXB0kEAVp_QnXdP4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f$0.lambda$createAnimator$0$PhotoViewer$64(valueAnimator);
                }
            });
            return valueAnimatorOfInt;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$createAnimator$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$createAnimator$0$PhotoViewer$64(ValueAnimator valueAnimator) {
            PhotoViewer.this.captionScrollView.scrollTo(0, ((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCaptionHwLayerEnabled(boolean enabled) {
        if (this.captionHwLayerEnabled != enabled) {
            this.captionHwLayerEnabled = enabled;
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
                if (messageObject3.isVideo()) {
                    z4 = SharedConfig.streamMedia && messageObject3.canStreamVideo() && !DialogObject.isEncryptedDialog(messageObject3.getDialogId());
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
            Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$Au-E9DK3SFWVwpctynkfWbka7iY
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$checkProgress$60$PhotoViewer(file, r3, i, messageObject2, z7, z8, z9, z2);
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
    /* renamed from: lambda$checkProgress$60, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkProgress$60$PhotoViewer(final File file, final File file2, final int i, MessageObject messageObject, final boolean z, final boolean z2, final boolean z3, final boolean z4) {
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
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$MXLfjBcusimP6URSrzcsibaasjg
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$checkProgress$59$PhotoViewer(file, file2, z5, z, i, z2, z3, z4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkProgress$59, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkProgress$59$PhotoViewer(File file, File file2, boolean z, boolean z2, int i, boolean z3, boolean z4, boolean z5) {
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
            if (this.isEmbedVideo || (this.imagesArrLocals.isEmpty() && (this.currentFileNames[0] == null || this.photoProgressViews[0].backgroundState == 0))) {
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
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v13 */
    /* JADX WARN: Type inference failed for: r15v31 */
    /* JADX WARN: Type inference failed for: r16v11 */
    /* JADX WARN: Type inference failed for: r16v12 */
    /* JADX WARN: Type inference failed for: r16v13 */
    /* JADX WARN: Type inference failed for: r16v14 */
    /* JADX WARN: Type inference failed for: r16v15 */
    /* JADX WARN: Type inference failed for: r16v18 */
    /* JADX WARN: Type inference failed for: r16v19 */
    /* JADX WARN: Type inference failed for: r16v20 */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v10 */
    /* JADX WARN: Type inference failed for: r17v11 */
    /* JADX WARN: Type inference failed for: r17v12 */
    /* JADX WARN: Type inference failed for: r17v2 */
    /* JADX WARN: Type inference failed for: r17v3 */
    /* JADX WARN: Type inference failed for: r17v4 */
    /* JADX WARN: Type inference failed for: r17v5 */
    /* JADX WARN: Type inference failed for: r17v6 */
    /* JADX WARN: Type inference failed for: r17v7 */
    /* JADX WARN: Type inference failed for: r17v8 */
    /* JADX WARN: Type inference failed for: r17v9 */
    /* JADX WARN: Type inference failed for: r2v47, types: [ir.eitaa.tgnet.TLRPC$PhotoSize] */
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
        String str2;
        String str3;
        ImageLocation forDocument2;
        Object obj2;
        int i2;
        int i3;
        boolean z;
        TLRPC$Photo tLRPC$Photo;
        TLRPC$Document tLRPC$Document2;
        int i4;
        Object obj3;
        TLRPC$Document tLRPC$Document3;
        WebFile webFile2;
        int i5;
        ?? r15;
        TLObject tLObject2;
        TLObject tLObject3;
        Object obj4;
        ?? r16;
        Object obj5;
        int i6;
        WebFile webFileCreateWithWebDocument;
        WebFile webFile3;
        Object obj6;
        ImageLocation forWebFile;
        Object obj7;
        WebFile webFileCreateWithWebDocument2;
        TLRPC$Document tLRPC$Document4;
        Drawable drawable;
        Activity activity;
        Drawable drawable2;
        Drawable drawable3;
        Activity activity2;
        Drawable drawable4;
        String str4;
        imageReceiver.setOrientation(0, false);
        TLObject tLObject4 = null;
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
            SecureDocument secureDocument = this.secureDocuments.get(i);
            imageReceiver.setImage(ImageLocation.getForSecureDocument(secureDocument), "d", null, null, thumbForPhoto != null ? new BitmapDrawable(thumbForPhoto.bitmap) : null, secureDocument.secureFile.size, null, null, 0);
            return;
        }
        if (!this.imagesArrLocals.isEmpty()) {
            if (i >= 0 && i < this.imagesArrLocals.size()) {
                Object obj8 = this.imagesArrLocals.get(i);
                int photoSize = (int) (AndroidUtilities.getPhotoSize() / AndroidUtilities.density);
                ImageReceiver.BitmapHolder bitmapHolder = this.currentThumb;
                if (bitmapHolder == null || imageReceiver != this.centerImage) {
                    bitmapHolder = null;
                }
                if (bitmapHolder == null) {
                    bitmapHolder = this.placeProvider.getThumbForPhoto(null, null, i);
                }
                Object obj9 = "d";
                if (obj8 instanceof MediaController.PhotoEntry) {
                    MediaController.PhotoEntry photoEntry = (MediaController.PhotoEntry) obj8;
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
                                str4 = null;
                                str2 = null;
                            }
                        } else {
                            str2 = "vthumb://" + photoEntry.imageId + ":" + photoEntry.path;
                        }
                        str4 = null;
                    } else {
                        str2 = photoEntry.filterPath;
                        if (str2 == null) {
                            imageReceiver.setOrientation(photoEntry.orientation, false);
                            str2 = photoEntry.path;
                        }
                        str4 = String.format(Locale.US, "%d_%d", Integer.valueOf(photoSize), Integer.valueOf(photoSize));
                    }
                    str3 = str4;
                    webFile = null;
                    tLRPC$Document = null;
                    forDocument2 = null;
                    obj2 = null;
                    z = z2;
                    i2 = 0;
                    i3 = 0;
                } else {
                    if (obj8 instanceof TLRPC$BotInlineResult) {
                        TLRPC$BotInlineResult tLRPC$BotInlineResult = (TLRPC$BotInlineResult) obj8;
                        if (tLRPC$BotInlineResult.type.equals(MediaStreamTrack.VIDEO_TRACK_KIND) || MessageObject.isVideoDocument(tLRPC$BotInlineResult.document)) {
                            TLRPC$Document tLRPC$Document5 = tLRPC$BotInlineResult.document;
                            if (tLRPC$Document5 != null) {
                                Object closestPhotoSizeWithSize2 = FileLoader.getClosestPhotoSizeWithSize(tLRPC$Document5.thumbs, 90);
                                tLObject3 = tLRPC$BotInlineResult.document;
                                obj4 = null;
                                r16 = null;
                                forDocument2 = null;
                                obj5 = closestPhotoSizeWithSize2;
                                i6 = 0;
                                tLObject2 = tLObject3;
                                webFile3 = forDocument2;
                                obj6 = obj4;
                                obj2 = obj5;
                                tLRPC$Document3 = r16;
                                i3 = 1;
                                z = false;
                                i5 = i6;
                                str2 = null;
                                tLObject4 = tLObject2;
                                webFile2 = webFile3;
                                r15 = obj6;
                            } else {
                                TLRPC$WebDocument tLRPC$WebDocument = tLRPC$BotInlineResult.thumb;
                                if (tLRPC$WebDocument instanceof TLRPC$TL_webDocument) {
                                    tLObject2 = null;
                                    webFileCreateWithWebDocument = WebFile.createWithWebDocument(tLRPC$WebDocument);
                                } else {
                                    webFileCreateWithWebDocument = null;
                                    tLObject2 = null;
                                }
                                obj5 = tLObject2;
                                Object obj10 = obj5;
                                r16 = obj10;
                                forDocument2 = r16;
                                i6 = 0;
                                webFile3 = webFileCreateWithWebDocument;
                                obj6 = obj10;
                                obj2 = obj5;
                                tLRPC$Document3 = r16;
                                i3 = 1;
                                z = false;
                                i5 = i6;
                                str2 = null;
                                tLObject4 = tLObject2;
                                webFile2 = webFile3;
                                r15 = obj6;
                            }
                        } else {
                            if (tLRPC$BotInlineResult.type.equals("gif") && (tLRPC$Document4 = tLRPC$BotInlineResult.document) != null) {
                                int i7 = tLRPC$Document4.size;
                                TLRPC$VideoSize documentVideoThumb = MessageObject.getDocumentVideoThumb(tLRPC$Document4);
                                obj7 = "d";
                                r16 = tLRPC$Document4;
                                forDocument2 = documentVideoThumb != null ? ImageLocation.getForDocument(documentVideoThumb, tLRPC$Document4) : null;
                                i6 = i7;
                                webFileCreateWithWebDocument2 = null;
                                tLObject2 = null;
                            } else {
                                TLRPC$Photo tLRPC$Photo2 = tLRPC$BotInlineResult.photo;
                                if (tLRPC$Photo2 != null) {
                                    TLRPC$PhotoSize closestPhotoSizeWithSize3 = FileLoader.getClosestPhotoSizeWithSize(tLRPC$Photo2.sizes, AndroidUtilities.getPhotoSize());
                                    tLObject3 = tLRPC$BotInlineResult.photo;
                                    i6 = closestPhotoSizeWithSize3.size;
                                    r16 = null;
                                    forDocument2 = null;
                                    obj4 = String.format(Locale.US, "%d_%d", Integer.valueOf(photoSize), Integer.valueOf(photoSize));
                                    obj5 = closestPhotoSizeWithSize3;
                                    tLObject2 = tLObject3;
                                    webFile3 = forDocument2;
                                    obj6 = obj4;
                                    obj2 = obj5;
                                    tLRPC$Document3 = r16;
                                    i3 = 1;
                                    z = false;
                                    i5 = i6;
                                    str2 = null;
                                    tLObject4 = tLObject2;
                                    webFile2 = webFile3;
                                    r15 = obj6;
                                } else {
                                    if (tLRPC$BotInlineResult.content instanceof TLRPC$TL_webDocument) {
                                        if (tLRPC$BotInlineResult.type.equals("gif")) {
                                            TLRPC$WebDocument tLRPC$WebDocument2 = tLRPC$BotInlineResult.thumb;
                                            if ((tLRPC$WebDocument2 instanceof TLRPC$TL_webDocument) && "video/mp4".equals(tLRPC$WebDocument2.mime_type)) {
                                                forWebFile = ImageLocation.getForWebFile(WebFile.createWithWebDocument(tLRPC$BotInlineResult.thumb));
                                            }
                                            r16 = null;
                                            obj7 = obj9;
                                            forDocument2 = forWebFile;
                                            i6 = 0;
                                            tLObject2 = null;
                                            webFileCreateWithWebDocument2 = WebFile.createWithWebDocument(tLRPC$BotInlineResult.content);
                                        } else {
                                            obj9 = String.format(Locale.US, "%d_%d", Integer.valueOf(photoSize), Integer.valueOf(photoSize));
                                        }
                                        forWebFile = null;
                                        r16 = null;
                                        obj7 = obj9;
                                        forDocument2 = forWebFile;
                                        i6 = 0;
                                        tLObject2 = null;
                                        webFileCreateWithWebDocument2 = WebFile.createWithWebDocument(tLRPC$BotInlineResult.content);
                                    }
                                    webFileCreateWithWebDocument = null;
                                    tLObject2 = null;
                                    obj5 = tLObject2;
                                    Object obj102 = obj5;
                                    r16 = obj102;
                                    forDocument2 = r16;
                                    i6 = 0;
                                    webFile3 = webFileCreateWithWebDocument;
                                    obj6 = obj102;
                                    obj2 = obj5;
                                    tLRPC$Document3 = r16;
                                    i3 = 1;
                                    z = false;
                                    i5 = i6;
                                    str2 = null;
                                    tLObject4 = tLObject2;
                                    webFile2 = webFile3;
                                    r15 = obj6;
                                }
                            }
                            obj5 = tLObject2;
                            webFile3 = webFileCreateWithWebDocument2;
                            obj6 = obj7;
                            obj2 = obj5;
                            tLRPC$Document3 = r16;
                            i3 = 1;
                            z = false;
                            i5 = i6;
                            str2 = null;
                            tLObject4 = tLObject2;
                            webFile2 = webFile3;
                            r15 = obj6;
                        }
                    } else if (obj8 instanceof MediaController.SearchImage) {
                        MediaController.SearchImage searchImage = (MediaController.SearchImage) obj8;
                        TLRPC$PhotoSize tLRPC$PhotoSize = searchImage.photoSize;
                        if (tLRPC$PhotoSize != null) {
                            tLRPC$Photo = searchImage.photo;
                            tLRPC$Document2 = null;
                            i4 = tLRPC$PhotoSize.size;
                            obj3 = tLRPC$PhotoSize;
                            str2 = null;
                        } else {
                            str2 = searchImage.filterPath;
                            if (str2 != null) {
                                tLRPC$Photo = null;
                                obj3 = null;
                                tLRPC$Document2 = null;
                                i4 = 0;
                            } else {
                                TLRPC$Document tLRPC$Document6 = searchImage.document;
                                if (tLRPC$Document6 != null) {
                                    tLRPC$Photo = null;
                                    tLRPC$Document2 = tLRPC$Document6;
                                    i4 = tLRPC$Document6.size;
                                    str2 = null;
                                    obj3 = null;
                                } else {
                                    str2 = searchImage.imageUrl;
                                    int i8 = searchImage.size;
                                    tLRPC$Photo = null;
                                    tLRPC$Document2 = null;
                                    i4 = i8;
                                    obj3 = null;
                                }
                            }
                        }
                        forDocument2 = null;
                        obj2 = obj3;
                        tLRPC$Document3 = tLRPC$Document2;
                        i3 = 1;
                        z = false;
                        tLObject4 = tLRPC$Photo;
                        webFile2 = null;
                        i5 = i4;
                        r15 = "d";
                    } else {
                        webFile = null;
                        tLRPC$Document = null;
                        str2 = null;
                        str3 = null;
                        forDocument2 = null;
                        obj2 = null;
                        i2 = 0;
                        i3 = 0;
                        z = false;
                    }
                    i2 = i5;
                    webFile = webFile2;
                    tLRPC$Document = tLRPC$Document3;
                    str3 = r15;
                }
                if (tLRPC$Document != null) {
                    TLRPC$PhotoSize closestPhotoSizeWithSize4 = FileLoader.getClosestPhotoSizeWithSize(tLRPC$Document.thumbs, 90);
                    if (forDocument2 != null) {
                        imageReceiver.setImage(ImageLocation.getForDocument(tLRPC$Document), "d", forDocument2, null, bitmapHolder == null ? ImageLocation.getForDocument(closestPhotoSizeWithSize4, tLRPC$Document) : null, String.format(Locale.US, "%d_%d", Integer.valueOf(photoSize), Integer.valueOf(photoSize)), bitmapHolder != null ? new BitmapDrawable(bitmapHolder.bitmap) : null, i2, null, obj8, i3);
                        return;
                    } else {
                        imageReceiver.setImage(ImageLocation.getForDocument(tLRPC$Document), "d", bitmapHolder == null ? ImageLocation.getForDocument(closestPhotoSizeWithSize4, tLRPC$Document) : null, String.format(Locale.US, "%d_%d", Integer.valueOf(photoSize), Integer.valueOf(photoSize)), bitmapHolder != null ? new BitmapDrawable(bitmapHolder.bitmap) : null, i2, null, obj8, i3);
                        return;
                    }
                }
                ?? r2 = obj2;
                if (r2 != 0) {
                    imageReceiver.setImage(ImageLocation.getForObject(r2, tLObject4), str3, bitmapHolder != null ? new BitmapDrawable(bitmapHolder.bitmap) : null, i2, (String) null, obj8, i3);
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
                    imageReceiver.setImage(ImageLocation.getForWebFile(webFile), str3, forDocument2, (String) null, (Drawable) null, obj8, i3);
                    return;
                }
                ImageLocation forWebFile2 = ImageLocation.getForWebFile(webFile);
                if (bitmapHolder != null) {
                    drawable4 = new BitmapDrawable(bitmapHolder.bitmap);
                } else {
                    if (!z || (activity2 = this.parentActivity) == null) {
                        drawable3 = null;
                        imageReceiver.setImage(forWebFile2, str3, drawable3, null, obj8, i3);
                        return;
                    }
                    drawable4 = activity2.getResources().getDrawable(R.drawable.nophotos);
                }
                drawable3 = drawable4;
                imageReceiver.setImage(forWebFile2, str3, drawable3, null, obj8, i3);
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
                        imageReceiver.setImage(null, null, bitmapHolder3 == null ? ImageLocation.getForDocument(fileLocation, (TLRPC$Document) media) : null, "b", bitmapHolder3 != null ? new BitmapDrawable(bitmapHolder3.bitmap) : null, 0, null, this.pageBlocksAdapter.getParentObject(), 1);
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
            if (messageObject.isVideo()) {
                ArrayList<TLRPC$PhotoSize> arrayList = messageObject.photoThumbs;
                if (arrayList != null && !arrayList.isEmpty()) {
                    ImageReceiver.BitmapHolder bitmapHolder4 = this.currentThumb;
                    if (bitmapHolder4 == null || imageReceiver != this.centerImage) {
                        bitmapHolder4 = null;
                    }
                    TLRPC$PhotoSize closestPhotoSizeWithSize5 = FileLoader.getClosestPhotoSizeWithSize(messageObject.photoThumbs, 320);
                    imageReceiver.setNeedsQualityThumb(closestPhotoSizeWithSize5.w < 100 && closestPhotoSizeWithSize5.h < 100);
                    imageReceiver.setImage(null, null, bitmapHolder4 == null ? ImageLocation.getForObject(closestPhotoSizeWithSize5, messageObject.photoThumbsObject) : null, "b", bitmapHolder4 != null ? new BitmapDrawable(bitmapHolder4.bitmap) : null, 0, null, messageObject, 1);
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
                    int i9 = (int) (2048.0f / AndroidUtilities.density);
                    imageReceiver.setImage(ImageLocation.getForDocument(document), String.format(Locale.US, "%d_%d", Integer.valueOf(i9), Integer.valueOf(i9)), bitmapHolder6 == null ? ImageLocation.getForDocument(closestPhotoSizeWithSize6, document) : null, "b", bitmapHolder6 != null ? new BitmapDrawable(bitmapHolder6.bitmap) : null, document.size, null, messageObject, 0);
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
            TLRPC$PhotoSize tLRPC$PhotoSize2 = (closestPhotoSizeWithSize == null || closestPhotoSizeWithSize != fileLocation2) ? closestPhotoSizeWithSize : null;
            int i10 = ((messageObject == null || !messageObject.isWebpage()) && this.avatarsDialogId == 0 && !this.isEvent) ? 0 : 1;
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
                long j = this.avatarsDialogId;
                if (j != 0) {
                    if (j > 0) {
                        chat = MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(this.avatarsDialogId));
                    } else {
                        chat = MessagesController.getInstance(this.currentAccount).getChat(Long.valueOf(-this.avatarsDialogId));
                    }
                    obj = chat;
                    forDocument = null;
                } else {
                    forDocument = null;
                    obj = null;
                }
            }
            if (forDocument != null) {
                imageReceiver.setImage(imageLocation, null, forDocument, null, bitmapHolder7 == null ? ImageLocation.getForObject(tLRPC$PhotoSize2, tLObject) : null, "b", bitmapHolder7 != null ? new BitmapDrawable(bitmapHolder7.bitmap) : null, iArr2[0], null, obj, i10);
                return;
            }
            if (this.avatarsDialogId != 0) {
                str = imageLocation.imageType == 2 ? ImageLoader.AUTOPLAY_FILTER : null;
            } else {
                str = null;
            }
            imageReceiver.setImage(imageLocation, str, bitmapHolder7 == null ? ImageLocation.getForObject(tLRPC$PhotoSize2, tLObject) : null, "b", bitmapHolder7 != null ? new BitmapDrawable(bitmapHolder7.bitmap) : null, iArr2[0], null, obj, i10);
            return;
        }
        if (iArr2[0] == 0) {
            imageReceiver.setImageBitmap((Bitmap) null);
        } else {
            imageReceiver.setImageBitmap(this.parentActivity.getResources().getDrawable(R.drawable.photoview_placeholder));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean isShowingImage(ir.eitaa.messenger.MessageObject r7) {
        /*
            ir.eitaa.ui.PhotoViewer r0 = ir.eitaa.ui.PhotoViewer.Instance
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L48
            ir.eitaa.ui.PhotoViewer r0 = ir.eitaa.ui.PhotoViewer.Instance
            boolean r0 = r0.pipAnimationInProgress
            if (r0 != 0) goto L48
            ir.eitaa.ui.PhotoViewer r0 = ir.eitaa.ui.PhotoViewer.Instance
            boolean r0 = r0.isVisible
            if (r0 == 0) goto L48
            ir.eitaa.ui.PhotoViewer r0 = ir.eitaa.ui.PhotoViewer.Instance
            boolean r0 = r0.disableShowCheck
            if (r0 != 0) goto L48
            if (r7 == 0) goto L48
            ir.eitaa.ui.PhotoViewer r0 = ir.eitaa.ui.PhotoViewer.Instance
            ir.eitaa.messenger.MessageObject r0 = r0.currentMessageObject
            if (r0 != 0) goto L2e
            ir.eitaa.ui.PhotoViewer r3 = ir.eitaa.ui.PhotoViewer.Instance
            ir.eitaa.ui.PhotoViewer$PhotoViewerProvider r3 = r3.placeProvider
            if (r3 == 0) goto L2e
            ir.eitaa.ui.PhotoViewer r0 = ir.eitaa.ui.PhotoViewer.Instance
            ir.eitaa.ui.PhotoViewer$PhotoViewerProvider r0 = r0.placeProvider
            ir.eitaa.messenger.MessageObject r0 = r0.getEditingMessageObject()
        L2e:
            if (r0 == 0) goto L48
            int r3 = r0.getId()
            int r4 = r7.getId()
            if (r3 != r4) goto L48
            long r3 = r0.getDialogId()
            long r5 = r7.getDialogId()
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 != 0) goto L48
            r0 = 1
            goto L49
        L48:
            r0 = 0
        L49:
            if (r0 != 0) goto L84
            ir.eitaa.ui.PhotoViewer r3 = ir.eitaa.ui.PhotoViewer.PipInstance
            if (r3 == 0) goto L84
            ir.eitaa.ui.PhotoViewer r0 = ir.eitaa.ui.PhotoViewer.PipInstance
            boolean r0 = r0.isVisible
            if (r0 == 0) goto L82
            ir.eitaa.ui.PhotoViewer r0 = ir.eitaa.ui.PhotoViewer.PipInstance
            boolean r0 = r0.disableShowCheck
            if (r0 != 0) goto L82
            if (r7 == 0) goto L82
            ir.eitaa.ui.PhotoViewer r0 = ir.eitaa.ui.PhotoViewer.PipInstance
            ir.eitaa.messenger.MessageObject r0 = r0.currentMessageObject
            if (r0 == 0) goto L82
            ir.eitaa.ui.PhotoViewer r0 = ir.eitaa.ui.PhotoViewer.PipInstance
            ir.eitaa.messenger.MessageObject r0 = r0.currentMessageObject
            int r0 = r0.getId()
            int r3 = r7.getId()
            if (r0 != r3) goto L82
            ir.eitaa.ui.PhotoViewer r0 = ir.eitaa.ui.PhotoViewer.PipInstance
            ir.eitaa.messenger.MessageObject r0 = r0.currentMessageObject
            long r3 = r0.getDialogId()
            long r5 = r7.getDialogId()
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L82
            goto L83
        L82:
            r1 = 0
        L83:
            r0 = r1
        L84:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.PhotoViewer.isShowingImage(ir.eitaa.messenger.MessageObject):boolean");
    }

    public static boolean isPlayingMessageInPip(MessageObject object) {
        return (PipInstance == null || object == null || PipInstance.currentMessageObject == null || PipInstance.currentMessageObject.getId() != object.getId() || PipInstance.currentMessageObject.getDialogId() != object.getDialogId()) ? false : true;
    }

    public static boolean isPlayingMessage(MessageObject object) {
        return (Instance == null || Instance.pipAnimationInProgress || !Instance.isVisible || object == null || Instance.currentMessageObject == null || Instance.currentMessageObject.getId() != object.getId() || Instance.currentMessageObject.getDialogId() != object.getDialogId()) ? false : true;
    }

    public static boolean isShowingImage(TLRPC$FileLocation object) {
        if (Instance == null || !Instance.isVisible || Instance.disableShowCheck || object == null) {
            return false;
        }
        return (Instance.currentFileLocation != null && object.local_id == Instance.currentFileLocation.location.local_id && object.volume_id == Instance.currentFileLocation.location.volume_id && object.dc_id == Instance.currentFileLocation.dc_id) || (Instance.currentFileLocationVideo != null && object.local_id == Instance.currentFileLocationVideo.location.local_id && object.volume_id == Instance.currentFileLocationVideo.location.volume_id && object.dc_id == Instance.currentFileLocationVideo.dc_id);
    }

    public static boolean isShowingImage(TLRPC$BotInlineResult object) {
        return (Instance == null || !Instance.isVisible || Instance.disableShowCheck || object == null || Instance.currentBotInlineResult == null || object.id != Instance.currentBotInlineResult.id) ? false : true;
    }

    public static boolean isShowingImage(String object) {
        return (Instance == null || !Instance.isVisible || Instance.disableShowCheck || object == null || !object.equals(Instance.currentPathObject)) ? false : true;
    }

    public void setParentChatActivity(ChatActivity chatActivity) {
        this.parentChatActivity = chatActivity;
    }

    public void setMaxSelectedPhotos(int value, boolean order) {
        this.maxSelectedPhotos = value;
        this.allowOrder = order;
    }

    public void checkCurrentImageVisibility() {
        PlaceProviderObject placeProviderObject = this.currentPlaceObject;
        if (placeProviderObject != null) {
            placeProviderObject.imageReceiver.setVisible(true, true);
        }
        PhotoViewerProvider photoViewerProvider = this.placeProvider;
        PlaceProviderObject placeForPhoto = photoViewerProvider == null ? null : photoViewerProvider.getPlaceForPhoto(this.currentMessageObject, getFileLocation(this.currentFileLocation), this.currentIndex, false);
        this.currentPlaceObject = placeForPhoto;
        if (placeForPhoto != null) {
            placeForPhoto.imageReceiver.setVisible(false, true);
        }
    }

    public boolean openPhoto(final MessageObject messageObject, ChatActivity chatActivity, long dialogId, long mergeDialogId, final PhotoViewerProvider provider) {
        return openPhoto(messageObject, null, null, null, null, null, null, 0, provider, chatActivity, dialogId, mergeDialogId, true, null, null);
    }

    public boolean openPhoto(final MessageObject messageObject, int embedSeekTime, ChatActivity chatActivity, long dialogId, long mergeDialogId, final PhotoViewerProvider provider) {
        return openPhoto(messageObject, null, null, null, null, null, null, 0, provider, chatActivity, dialogId, mergeDialogId, true, null, Integer.valueOf(embedSeekTime));
    }

    public boolean openPhoto(final MessageObject messageObject, long dialogId, long mergeDialogId, final PhotoViewerProvider provider, boolean fullScreenVideo) {
        return openPhoto(messageObject, null, null, null, null, null, null, 0, provider, null, dialogId, mergeDialogId, fullScreenVideo, null, null);
    }

    public boolean openPhoto(final TLRPC$FileLocation fileLocation, final PhotoViewerProvider provider) {
        return openPhoto(null, fileLocation, null, null, null, null, null, 0, provider, null, 0L, 0L, true, null, null);
    }

    public boolean openPhotoWithVideo(final TLRPC$FileLocation fileLocation, ImageLocation videoLocation, final PhotoViewerProvider provider) {
        return openPhoto(null, fileLocation, null, videoLocation, null, null, null, 0, provider, null, 0L, 0L, true, null, null);
    }

    public boolean openPhoto(final TLRPC$FileLocation fileLocation, final ImageLocation imageLocation, final PhotoViewerProvider provider) {
        return openPhoto(null, fileLocation, imageLocation, null, null, null, null, 0, provider, null, 0L, 0L, true, null, null);
    }

    public boolean openPhoto(final ArrayList<MessageObject> messages, final int index, long dialogId, long mergeDialogId, final PhotoViewerProvider provider) {
        return openPhoto(messages.get(index), null, null, null, messages, null, null, index, provider, null, dialogId, mergeDialogId, true, null, null);
    }

    public boolean openPhoto(final ArrayList<SecureDocument> documents, final int index, final PhotoViewerProvider provider) {
        return openPhoto(null, null, null, null, null, documents, null, index, provider, null, 0L, 0L, true, null, null);
    }

    public boolean openPhoto(int index, PageBlocksAdapter pageBlocksAdapter, PhotoViewerProvider provider) {
        return openPhoto(null, null, null, null, null, null, null, index, provider, null, 0L, 0L, true, pageBlocksAdapter, null);
    }

    public boolean openPhotoForSelect(final ArrayList<Object> photos, final int index, int type, boolean documentsPicker, final PhotoViewerProvider provider, ChatActivity chatActivity) throws InterruptedException, Resources.NotFoundException {
        this.isDocumentsPicker = documentsPicker;
        ImageView imageView = this.pickerViewSendButton;
        if (imageView != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
            if (type == 4 || type == 5) {
                this.pickerViewSendButton.setImageResource(R.drawable.attach_send);
                layoutParams.bottomMargin = AndroidUtilities.dp(19.0f);
            } else if (type == 1 || type == 3 || type == 10) {
                this.pickerViewSendButton.setImageResource(R.drawable.floating_check);
                this.pickerViewSendButton.setPadding(0, AndroidUtilities.dp(1.0f), 0, 0);
                layoutParams.bottomMargin = AndroidUtilities.dp(19.0f);
            } else {
                this.pickerViewSendButton.setImageResource(R.drawable.attach_send);
                layoutParams.bottomMargin = AndroidUtilities.dp(14.0f);
            }
            this.pickerViewSendButton.setLayoutParams(layoutParams);
        }
        if (this.sendPhotoType != 1 && type == 1 && this.isVisible) {
            this.sendPhotoType = type;
            this.doneButtonPressed = false;
            this.actionBar.setTitle(LocaleController.formatString("Of", R.string.Of, 1, 1));
            this.placeProvider = provider;
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
            onPhotoShow(null, null, null, null, null, null, photos, index, null);
            initCropView();
            setCropBitmap();
            return true;
        }
        this.sendPhotoType = type;
        return openPhoto(null, null, null, null, null, null, photos, index, provider, chatActivity, 0L, 0L, true, null, null);
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
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$Z7uCZGN2CSingaktqaZsUKbUslo
                    @Override // java.lang.Runnable
                    public final void run() throws InterruptedException, Resources.NotFoundException {
                        this.f$0.lambda$openCurrentPhotoInPaintModeForSelect$61$PhotoViewer(file, z, messageObject, z2);
                    }
                }, r0.animationDuration);
                return;
            }
            showDownloadAlert();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$openCurrentPhotoInPaintModeForSelect$61, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$openCurrentPhotoInPaintModeForSelect$61$PhotoViewer(File file, boolean z, final MessageObject messageObject, final boolean z2) throws InterruptedException, Resources.NotFoundException {
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
        this.placeProvider = new EmptyPhotoViewerProvider() { // from class: ir.eitaa.ui.PhotoViewer.65
            private final ImageReceiver.BitmapHolder thumbHolder;

            @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
            public boolean canCaptureMorePhotos() {
                return false;
            }

            {
                this.thumbHolder = PhotoViewer.this.centerImage.getBitmapSafe();
            }

            @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
            public PlaceProviderObject getPlaceForPhoto(MessageObject messageObject2, TLRPC$FileLocation fileLocation, int index, boolean needPreview) {
                PhotoViewerProvider photoViewerProvider2 = photoViewerProvider;
                if (photoViewerProvider2 != null) {
                    return photoViewerProvider2.getPlaceForPhoto(messageObject, null, 0, needPreview);
                }
                return null;
            }

            @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
            public ImageReceiver.BitmapHolder getThumbForPhoto(MessageObject messageObject2, TLRPC$FileLocation fileLocation, int index) {
                return this.thumbHolder;
            }

            @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
            public void sendButtonPressed(int index, VideoEditedInfo videoEditedInfo, boolean notify, int scheduleDate, boolean forceDocument) {
                sendMedia(videoEditedInfo, notify, scheduleDate, false, forceDocument);
            }

            @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
            public void replaceButtonPressed(int index, VideoEditedInfo videoEditedInfo) {
                MediaController.PhotoEntry photoEntry2 = photoEntry;
                if (photoEntry2.isCropped || photoEntry2.isPainted || photoEntry2.isFiltered || videoEditedInfo != null || !TextUtils.isEmpty(photoEntry2.caption)) {
                    sendMedia(videoEditedInfo, false, 0, true, false);
                }
            }

            @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
            public boolean canReplace(int index) {
                return photoViewerProvider != null && z2;
            }

            @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
            public MessageObject getEditingMessageObject() {
                return messageObject;
            }

            private void sendMedia(VideoEditedInfo videoEditedInfo, boolean notify, int scheduleDate, boolean replace, boolean forceDocument) {
                if (PhotoViewer.this.parentChatActivity != null) {
                    MessageObject messageObject2 = replace ? messageObject : null;
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
                            SendMessagesHelper.prepareSendingVideo(accountInstance, str, videoEditedInfo, dialogId, replyMessage, threadMessage, photoEntry4.caption, photoEntry4.entities, photoEntry4.ttl, messageObject2, notify, scheduleDate, forceDocument);
                            return;
                        }
                        AccountInstance accountInstance2 = PhotoViewer.this.parentChatActivity.getAccountInstance();
                        String str2 = photoEntry.path;
                        long dialogId2 = PhotoViewer.this.parentChatActivity.getDialogId();
                        MessageObject replyMessage2 = PhotoViewer.this.parentChatActivity.getReplyMessage();
                        MessageObject threadMessage2 = PhotoViewer.this.parentChatActivity.getThreadMessage();
                        MediaController.PhotoEntry photoEntry5 = photoEntry;
                        SendMessagesHelper.prepareSendingVideo(accountInstance2, str2, null, dialogId2, replyMessage2, threadMessage2, photoEntry5.caption, photoEntry5.entities, photoEntry5.ttl, messageObject2, notify, scheduleDate, forceDocument);
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
                        SendMessagesHelper.prepareSendingPhoto(accountInstance3, str3, str4, null, dialogId3, replyMessage3, threadMessage3, photoEntry7.caption, photoEntry7.entities, photoEntry7.stickers, null, photoEntry7.ttl, messageObject2, videoEditedInfo, notify, scheduleDate, forceDocument);
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
                        SendMessagesHelper.prepareSendingPhoto(accountInstance4, str5, str6, null, dialogId4, replyMessage4, threadMessage4, photoEntry9.caption, photoEntry9.entities, photoEntry9.stickers, null, photoEntry9.ttl, messageObject2, videoEditedInfo, notify, scheduleDate, forceDocument);
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

    public boolean openPhoto(final MessageObject messageObject, final TLRPC$FileLocation fileLocation, final ImageLocation imageLocation, final ImageLocation videoLocation, final ArrayList<MessageObject> messages, final ArrayList<SecureDocument> documents, final ArrayList<Object> photos, final int index, final PhotoViewerProvider provider, ChatActivity chatActivity, long dialogId, long mDialogId, boolean fullScreenVideo, PageBlocksAdapter pageBlocksAdapter, final Integer embedSeekTime) throws InterruptedException, Resources.NotFoundException {
        PhotoViewerProvider photoViewerProvider;
        int i = 0;
        if (this.parentActivity != null && !this.isVisible && ((provider != null || !checkAnimation()) && (messageObject != null || fileLocation != null || messages != null || photos != null || documents != null || imageLocation != null || pageBlocksAdapter != null))) {
            PlaceProviderObject placeForPhoto = provider.getPlaceForPhoto(messageObject, fileLocation, index, true);
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
                    layoutParams.flags = 131072;
                }
                if (chatActivity == null || chatActivity.getCurrentEncryptedChat() == null) {
                    this.windowLayoutParams.flags &= -8193;
                } else {
                    this.windowLayoutParams.flags |= 8192;
                }
                this.windowLayoutParams.softInputMode = (this.useSmoothKeyboard ? 32 : 16) | Factory.DEVICE_HAS_CRAPPY_OPENSLES;
                this.windowView.setFocusable(false);
                this.containerView.setFocusable(false);
                windowManager.addView(this.windowView, this.windowLayoutParams);
                this.doneButtonPressed = false;
                this.allowShowFullscreenButton = true;
                this.parentChatActivity = chatActivity;
                this.lastTitle = null;
                this.isEmbedVideo = embedSeekTime != null;
                this.actionBar.setTitle(LocaleController.formatString("Of", R.string.Of, 1, 1));
                this.actionBar.setTitleScrollNonFitText(false);
                NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.fileLoadFailed);
                NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.fileLoaded);
                NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.fileLoadProgressChanged);
                NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.mediaCountDidLoad);
                NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.mediaDidLoad);
                NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.dialogPhotosLoaded);
                NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.messagesDeleted);
                NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.emojiLoaded);
                NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.filePreparingFailed);
                NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.fileNewChunkAvailable);
                this.placeProvider = provider;
                this.mergeDialogId = mDialogId;
                this.currentDialogId = dialogId;
                this.selectedPhotosAdapter.notifyDataSetChanged();
                this.pageBlocksAdapter = pageBlocksAdapter;
                if (this.velocityTracker == null) {
                    this.velocityTracker = VelocityTracker.obtain();
                }
                this.isVisible = true;
                togglePhotosListView(false, false);
                boolean z = !fullScreenVideo;
                this.openedFullScreenVideo = z;
                if (z) {
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
                    float f = 0.0f;
                    onPhotoShow(messageObject, fileLocation, imageLocation, videoLocation, messages, documents, photos, index, placeForPhoto);
                    if (this.sendPhotoType == 1) {
                        this.photoCropView.setVisibility(0);
                        this.photoCropView.setAlpha(0.0f);
                        this.photoCropView.setFreeform(false);
                    }
                    RectF drawRegion = placeForPhoto.imageReceiver.getDrawRegion();
                    float f2 = drawRegion.left;
                    float f3 = drawRegion.top;
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
                    while (i < animatingImageViews.length) {
                        if (animatingImageViews.length > 1) {
                            animatingImageViews[i].setAlpha(f);
                        } else {
                            animatingImageViews[i].setAlpha(1.0f);
                        }
                        animatingImageViews[i].setPivotX(f);
                        animatingImageViews[i].setPivotY(f);
                        animatingImageViews[i].setScaleX(placeForPhoto.scale);
                        animatingImageViews[i].setScaleY(placeForPhoto.scale);
                        animatingImageViews[i].setTranslationX(placeForPhoto.viewX + (drawRegion.left * placeForPhoto.scale));
                        animatingImageViews[i].setTranslationY(placeForPhoto.viewY + (drawRegion.top * placeForPhoto.scale));
                        animatingImageViews[i].setLayoutParams(layoutParams2);
                        i++;
                        f = 0.0f;
                    }
                    this.windowView.getViewTreeObserver().addOnPreDrawListener(new AnonymousClass66(animatingImageViews, layoutParams2, f2, placeForPhoto, f3, pageBlocksAdapter, photos, embedSeekTime));
                } else {
                    if (photos != null && this.sendPhotoType != 3 && ((photoViewerProvider = this.placeProvider) == null || !photoViewerProvider.closeKeyboard())) {
                        makeFocusable();
                    }
                    this.containerView.setAlpha(1.0f);
                    onPhotoShow(messageObject, fileLocation, imageLocation, videoLocation, messages, documents, photos, index, placeForPhoto);
                    initCropView();
                    setCropBitmap();
                    ChatActivity chatActivity2 = this.parentChatActivity;
                    if (chatActivity2 != null) {
                        chatActivity2.getUndoView().hide(false, 1);
                        this.parentChatActivity.getFragmentView().invalidate();
                    }
                    this.windowView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: ir.eitaa.ui.PhotoViewer.67
                        @Override // android.view.ViewTreeObserver.OnPreDrawListener
                        public boolean onPreDraw() {
                            PhotoViewer.this.windowView.getViewTreeObserver().removeOnPreDrawListener(this);
                            PhotoViewer.this.actionBar.setTranslationY(-AndroidUtilities.dp(32.0f));
                            ViewPropertyAnimator duration = PhotoViewer.this.actionBar.animate().alpha(1.0f).translationY(0.0f).setDuration(150L);
                            CubicBezierInterpolator cubicBezierInterpolator = CubicBezierInterpolator.DEFAULT;
                            duration.setInterpolator(cubicBezierInterpolator).start();
                            PhotoViewer.this.checkImageView.setTranslationY(-AndroidUtilities.dp(32.0f));
                            PhotoViewer.this.checkImageView.animate().alpha(1.0f).translationY(0.0f).setDuration(150L).setInterpolator(cubicBezierInterpolator).start();
                            PhotoViewer.this.photosCounterView.setTranslationY(-AndroidUtilities.dp(32.0f));
                            PhotoViewer.this.photosCounterView.animate().alpha(1.0f).translationY(0.0f).setDuration(150L).setInterpolator(cubicBezierInterpolator).start();
                            PhotoViewer.this.pickerView.setTranslationY(AndroidUtilities.dp(32.0f));
                            PhotoViewer.this.pickerView.animate().alpha(1.0f).setDuration(150L).setInterpolator(cubicBezierInterpolator).start();
                            PhotoViewer.this.pickerViewSendButton.setTranslationY(AndroidUtilities.dp(32.0f));
                            PhotoViewer.this.pickerViewSendButton.setAlpha(0.0f);
                            PhotoViewer.this.pickerViewSendButton.animate().alpha(1.0f).translationY(0.0f).setDuration(150L).setInterpolator(cubicBezierInterpolator).start();
                            PhotoViewer.this.cameraItem.setTranslationY(AndroidUtilities.dp(32.0f));
                            PhotoViewer.this.cameraItem.animate().alpha(1.0f).translationY(0.0f).setDuration(150L).setInterpolator(cubicBezierInterpolator).start();
                            PhotoViewer.this.videoPreviewFrame.setTranslationY(AndroidUtilities.dp(32.0f));
                            PhotoViewer.this.videoPreviewFrame.animate().alpha(1.0f).translationY(0.0f).setDuration(150L).setInterpolator(cubicBezierInterpolator).start();
                            PhotoViewer.this.containerView.setAlpha(0.0f);
                            PhotoViewer.this.backgroundDrawable.setAlpha(0);
                            PhotoViewer.this.animationInProgress = 4;
                            PhotoViewer.this.containerView.invalidate();
                            AnimatorSet animatorSet = new AnimatorSet();
                            ObjectAnimator duration2 = ObjectAnimator.ofFloat(PhotoViewer.this.containerView, (Property<FrameLayoutDrawer, Float>) View.ALPHA, 0.0f, 1.0f).setDuration(220L);
                            ObjectAnimator duration3 = ObjectAnimator.ofFloat(PhotoViewer.this.pickerView, (Property<FrameLayout, Float>) View.TRANSLATION_Y, PhotoViewer.this.pickerView.getTranslationY(), 0.0f).setDuration(220L);
                            duration3.setInterpolator(cubicBezierInterpolator);
                            animatorSet.playTogether(duration2, duration3);
                            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.PhotoViewer.67.1
                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animation2) {
                                    super.onAnimationEnd(animation2);
                                    PhotoViewer.this.animationInProgress = 0;
                                    PhotoViewer.this.backgroundDrawable.setAlpha(255);
                                    PhotoViewer.this.containerView.invalidate();
                                    PhotoViewer.this.pickerView.setTranslationY(0.0f);
                                    if (PhotoViewer.this.isEmbedVideo) {
                                        AnonymousClass67 anonymousClass67 = AnonymousClass67.this;
                                        PhotoViewer.this.initEmbedVideo(embedSeekTime.intValue());
                                    }
                                }
                            });
                            animatorSet.start();
                            return true;
                        }
                    });
                }
                AccessibilityManager accessibilityManager = (AccessibilityManager) this.parentActivity.getSystemService("accessibility");
                if (accessibilityManager.isTouchExplorationEnabled()) {
                    AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                    accessibilityEventObtain.setEventType(16384);
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

    /* renamed from: ir.eitaa.ui.PhotoViewer$66, reason: invalid class name */
    class AnonymousClass66 implements ViewTreeObserver.OnPreDrawListener {
        final /* synthetic */ ClippingImageView[] val$animatingImageViews;
        final /* synthetic */ Integer val$embedSeekTime;
        final /* synthetic */ ViewGroup.LayoutParams val$layoutParams;
        final /* synthetic */ float val$left;
        final /* synthetic */ PlaceProviderObject val$object;
        final /* synthetic */ PageBlocksAdapter val$pageBlocksAdapter;
        final /* synthetic */ ArrayList val$photos;
        final /* synthetic */ float val$top;

        AnonymousClass66(final ClippingImageView[] val$animatingImageViews, final ViewGroup.LayoutParams val$layoutParams, final float val$left, final PlaceProviderObject val$object, final float val$top, final PageBlocksAdapter val$pageBlocksAdapter, final ArrayList val$photos, final Integer val$embedSeekTime) {
            this.val$animatingImageViews = val$animatingImageViews;
            this.val$layoutParams = val$layoutParams;
            this.val$left = val$left;
            this.val$object = val$object;
            this.val$top = val$top;
            this.val$pageBlocksAdapter = val$pageBlocksAdapter;
            this.val$photos = val$photos;
            this.val$embedSeekTime = val$embedSeekTime;
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
            final Integer num = this.val$embedSeekTime;
            photoViewer.animationEndRunnable = new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$66$6dMKicFBuGQL2qC1UHWhr4HooUI
                @Override // java.lang.Runnable
                public final void run() throws Resources.NotFoundException {
                    this.f$0.lambda$onPreDraw$0$PhotoViewer$66(clippingImageViewArr5, arrayList, num);
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
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$66$devi2pTbDZM7NtD8UpRg8BqoJcQ
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onPreDraw$1$PhotoViewer$66(i12, animatorSet);
                    }
                });
            }
            BackgroundDrawable backgroundDrawable = PhotoViewer.this.backgroundDrawable;
            final PlaceProviderObject placeProviderObject = this.val$object;
            backgroundDrawable.drawRunnable = new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$66$QFW_AgW10nwT82bL6833RjFqf4k
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onPreDraw$2$PhotoViewer$66(placeProviderObject);
                }
            };
            if (PhotoViewer.this.parentChatActivity != null) {
                PhotoViewer.this.parentChatActivity.getUndoView().hide(false, 1);
                PhotoViewer.this.parentChatActivity.getFragmentView().invalidate();
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onPreDraw$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onPreDraw$0$PhotoViewer$66(ClippingImageView[] clippingImageViewArr, ArrayList arrayList, Integer num) throws Resources.NotFoundException {
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
            if (PhotoViewer.this.videoPlayer != null && PhotoViewer.this.videoPlayer.isPlaying() && PhotoViewer.this.isCurrentVideo && !PhotoViewer.this.imagesArrLocals.isEmpty()) {
                PhotoViewer photoViewer = PhotoViewer.this;
                photoViewer.seekAnimatedStickersTo(photoViewer.videoPlayer.getCurrentPosition());
                PhotoViewer.this.playOrStopAnimatedStickers(true);
            }
            if (PhotoViewer.this.isEmbedVideo) {
                PhotoViewer.this.initEmbedVideo(num.intValue());
            }
        }

        /* renamed from: ir.eitaa.ui.PhotoViewer$66$1, reason: invalid class name */
        class AnonymousClass1 extends AnimatorListenerAdapter {
            final /* synthetic */ int val$account;

            AnonymousClass1(final int val$account) {
                this.val$account = val$account;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                final int i = this.val$account;
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$66$1$PP8VffuBe6MDZGiU9HaDp6FiJyE
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onAnimationEnd$0$PhotoViewer$66$1(i);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: lambda$onAnimationEnd$0, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void lambda$onAnimationEnd$0$PhotoViewer$66$1(int i) {
                NotificationCenter.getInstance(i).onAnimationFinish(PhotoViewer.this.transitionIndex);
                if (PhotoViewer.this.animationEndRunnable != null) {
                    PhotoViewer.this.animationEndRunnable.run();
                    PhotoViewer.this.animationEndRunnable = null;
                }
                PhotoViewer.this.setCaptionHwLayerEnabled(true);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onPreDraw$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onPreDraw$1$PhotoViewer$66(int i, AnimatorSet animatorSet) {
            PhotoViewer.this.transitionIndex = NotificationCenter.getInstance(i).setAnimationInProgress(PhotoViewer.this.transitionIndex, new int[]{NotificationCenter.dialogsNeedReload, NotificationCenter.closeChats, NotificationCenter.mediaCountDidLoad, NotificationCenter.mediaDidLoad, NotificationCenter.dialogPhotosLoaded});
            animatorSet.start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onPreDraw$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onPreDraw$2$PhotoViewer$66(PlaceProviderObject placeProviderObject) {
            PhotoViewer.this.disableShowCheck = false;
            placeProviderObject.imageReceiver.setVisible(false, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initEmbedVideo(int embedSeekTime) {
        if (this.isEmbedVideo) {
            PhotoViewerWebView photoViewerWebView = new PhotoViewerWebView(this.parentActivity, this.pipItem) { // from class: ir.eitaa.ui.PhotoViewer.68
                Rect rect = new Rect();

                @Override // ir.eitaa.ui.Components.PhotoViewerWebView
                protected void drawBlackBackground(Canvas canvas, int w, int h) {
                    Bitmap bitmap = PhotoViewer.this.centerImage.getBitmap();
                    if (bitmap != null) {
                        float fMin = Math.min(w / bitmap.getWidth(), h / bitmap.getHeight());
                        int width = (int) (bitmap.getWidth() * fMin);
                        int height = (int) (bitmap.getHeight() * fMin);
                        int i = (h - height) / 2;
                        int i2 = (w - width) / 2;
                        this.rect.set(i2, i, width + i2, height + i);
                        canvas.drawBitmap(bitmap, (Rect) null, this.rect, (Paint) null);
                    }
                }

                @Override // ir.eitaa.ui.Components.PhotoViewerWebView
                protected void processTouch(MotionEvent event) {
                    PhotoViewer.this.gestureDetector.onTouchEvent(event);
                }
            };
            this.photoViewerWebView = photoViewerWebView;
            photoViewerWebView.init(embedSeekTime, this.currentMessageObject.messageOwner.media.webpage);
            this.photoViewerWebView.setPlaybackSpeed(this.currentVideoSpeed);
            this.containerView.addView(this.photoViewerWebView, 0, LayoutHelper.createFrame(-1, -1.0f));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void makeFocusable() {
        if (Build.VERSION.SDK_INT >= 21) {
            this.windowLayoutParams.flags = -2147417856;
        } else {
            this.windowLayoutParams.flags = 0;
        }
        this.windowLayoutParams.softInputMode = (this.useSmoothKeyboard ? 32 : 16) | Factory.DEVICE_HAS_CRAPPY_OPENSLES;
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

    public void closePhoto(boolean animated, boolean fromEditMode) {
        AnimatedFileDrawable animatedFileDrawable;
        RectF drawRegion;
        float fMin;
        float measuredHeight;
        AnimatedFileDrawable animation;
        Bitmap animatedBitmap;
        int i;
        int i2;
        OnPhotoCloseListener onPhotoCloseListener = this.onPhotoCloseListener;
        if (onPhotoCloseListener != null) {
            onPhotoCloseListener.onClose();
        }
        if (!fromEditMode && (i2 = this.currentEditMode) != 0) {
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
            if (!this.captionEditText.hideActionMode() || fromEditMode) {
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
                PhotoViewerWebView photoViewerWebView = this.photoViewerWebView;
                if (photoViewerWebView != null) {
                    photoViewerWebView.release();
                    this.containerView.removeView(this.photoViewerWebView);
                    this.photoViewerWebView = null;
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
                if (animated) {
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
                    this.animationEndRunnable = new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$eZ13UcbY2JUEo8vVOT9ntwNuC1c
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$closePhoto$62$PhotoViewer(placeForPhoto);
                        }
                    };
                    animatorSet.setDuration(200L);
                    animatorSet.addListener(new AnonymousClass69());
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
                    this.animationEndRunnable = new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$W0SnGzwf6p4HhMcrvRMLsu7Zjbs
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$closePhoto$63$PhotoViewer(placeForPhoto);
                        }
                    };
                    animatorSet2.setDuration(200L);
                    animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.PhotoViewer.70
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animation2) {
                            if (PhotoViewer.this.animationEndRunnable != null) {
                                ChatActivity chatActivity2 = PhotoViewer.this.parentChatActivity;
                                if (chatActivity2 == null && PhotoViewer.this.parentAlert != null) {
                                    BaseFragment baseFragment = PhotoViewer.this.parentAlert.getBaseFragment();
                                    if (baseFragment instanceof ChatActivity) {
                                        chatActivity2 = (ChatActivity) baseFragment;
                                    }
                                }
                                if (chatActivity2 != null) {
                                    chatActivity2.lambda$openDiscussionMessageChat$149(PhotoViewer.this.animationEndRunnable);
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
    /* renamed from: lambda$closePhoto$62, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$closePhoto$62$PhotoViewer(PlaceProviderObject placeProviderObject) {
        this.animationEndRunnable = null;
        if (Build.VERSION.SDK_INT >= 18) {
            this.containerView.setLayerType(0, null);
        }
        this.animationInProgress = 0;
        onPhotoClosed(placeProviderObject);
    }

    /* renamed from: ir.eitaa.ui.PhotoViewer$69, reason: invalid class name */
    class AnonymousClass69 extends AnimatorListenerAdapter {
        AnonymousClass69() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$69$kDW_NvBlc7kn446r4pnvSVqmzWY
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onAnimationEnd$0$PhotoViewer$69();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onAnimationEnd$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onAnimationEnd$0$PhotoViewer$69() {
            if (PhotoViewer.this.animationEndRunnable != null) {
                PhotoViewer.this.animationEndRunnable.run();
                PhotoViewer.this.animationEndRunnable = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$closePhoto$63, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$closePhoto$63$PhotoViewer(PlaceProviderObject placeProviderObject) {
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

    private ClippingImageView[] getAnimatingImageViews(PlaceProviderObject object) {
        int i = (AndroidUtilities.isTablet() || object == null || object.animatingImageView == null) ? 0 : 1;
        ClippingImageView[] clippingImageViewArr = new ClippingImageView[i + 1];
        clippingImageViewArr[0] = this.animatingImageView;
        if (i != 0) {
            ClippingImageView clippingImageView = object.animatingImageView;
            clippingImageViewArr[1] = clippingImageView;
            clippingImageView.setAdditionalTranslationY(object.animatingImageViewYOffset);
        }
        return clippingImageViewArr;
    }

    private void removeObservers() {
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.fileLoadFailed);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.fileLoaded);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.fileLoadProgressChanged);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.mediaCountDidLoad);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.mediaDidLoad);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.dialogPhotosLoaded);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.messagesDeleted);
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.emojiLoaded);
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

    private void onPhotoClosed(final PlaceProviderObject object) {
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
        this.containerView.post(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$XrO8FBG9k28aV3SJiIJrCX3nfUE
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onPhotoClosed$64$PhotoViewer(object);
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
        if (object != null) {
            object.imageReceiver.setVisible(true, true);
        }
        ChatActivity chatActivity = this.parentChatActivity;
        if (chatActivity != null) {
            chatActivity.getFragmentView().invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onPhotoClosed$64, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onPhotoClosed$64$PhotoViewer(PlaceProviderObject placeProviderObject) {
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

    private void redraw(final int count) {
        FrameLayoutDrawer frameLayoutDrawer;
        if (count >= 6 || (frameLayoutDrawer = this.containerView) == null) {
            return;
        }
        frameLayoutDrawer.invalidate();
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$1dnXCYfSbL_Qpk6roRMWpUvxt8k
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$redraw$65$PhotoViewer(count);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$redraw$65, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$redraw$65$PhotoViewer(int i) {
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

    public void onConfigurationChanged(Configuration newConfig) {
        PipVideoView pipVideoView = this.pipVideoView;
        if (pipVideoView != null) {
            pipVideoView.onConfigurationChanged();
        }
    }

    public void onPause() throws Resources.NotFoundException {
        if (this.currentAnimation != null) {
            closePhoto(false, false);
            return;
        }
        if (this.lastTitle != null) {
            closeCaptionEnter(true);
        }
        if (this.videoPlayer != null && this.currentPlayingVideoFile != null) {
            ApplicationLoader.applicationContext.getSharedPreferences("VideoPlayerConfig", 0).edit().putLong("current_position" + this.currentPlayingVideoFile.toString(), this.videoPlayer.getCurrentPosition()).apply();
        }
        VideoPlayer videoPlayer = this.videoPlayer;
        if (videoPlayer == null || !this.playerLooping) {
            return;
        }
        videoPlayer.setLooping(false);
    }

    public boolean isVisible() {
        return this.isVisible && this.placeProvider != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMinMax(float scale) {
        AspectRatioFrameLayout aspectRatioFrameLayout;
        if (this.currentEditMode == 3 && (aspectRatioFrameLayout = this.aspectRatioFrameLayout) != null && aspectRatioFrameLayout.getVisibility() == 0 && this.textureUploaded) {
            scale *= Math.min(getContainerViewWidth() / this.videoTextureView.getMeasuredWidth(), getContainerViewHeight() / this.videoTextureView.getMeasuredHeight());
        }
        float imageWidth = this.centerImage.getImageWidth();
        float imageHeight = this.centerImage.getImageHeight();
        MediaController.CropState cropState = this.editState.cropState;
        if (cropState != null) {
            imageWidth *= cropState.cropPw;
            imageHeight *= cropState.cropPh;
        }
        int containerViewWidth = ((int) ((imageWidth * scale) - getContainerViewWidth())) / 2;
        int containerViewHeight = ((int) ((imageHeight * scale) - getContainerViewHeight())) / 2;
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
    public int getContainerViewWidth(int mode) {
        int iDp;
        int width = this.containerView.getWidth();
        if (mode == 1 || (mode == 0 && this.sendPhotoType == 1)) {
            iDp = AndroidUtilities.dp(32.0f);
        } else {
            if (mode == 0 || mode == 3) {
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
    public int getContainerViewHeight(int mode) {
        return getContainerViewHeight(false, mode);
    }

    private int getContainerViewHeight(boolean trueHeight, int mode) {
        int measuredHeight;
        int iDp;
        if (trueHeight || this.inBubbleMode) {
            measuredHeight = this.containerView.getMeasuredHeight();
        } else {
            measuredHeight = AndroidUtilities.displaySize.y;
            if (mode == 0 && this.sendPhotoType != 1 && isStatusBarVisible()) {
                measuredHeight += AndroidUtilities.statusBarHeight;
            }
        }
        if ((mode == 0 && this.sendPhotoType == 1) || mode == 1) {
            iDp = AndroidUtilities.dp(144.0f);
        } else if (mode == 2) {
            iDp = AndroidUtilities.dp(214.0f);
        } else {
            if (mode != 3) {
                return measuredHeight;
            }
            iDp = AndroidUtilities.dp(48.0f) + ActionBar.getCurrentActionBarHeight();
        }
        return measuredHeight - iDp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x041f A[PHI: r4
      0x041f: PHI (r4v47 float) = (r4v42 float), (r4v43 float) binds: [B:214:0x041d, B:217:0x0425] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:221:0x042e A[PHI: r4
      0x042e: PHI (r4v46 float) = (r4v44 float), (r4v45 float) binds: [B:220:0x042c, B:223:0x0434] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0430  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0453 A[PHI: r4
      0x0453: PHI (r4v28 float) = (r4v23 float), (r4v24 float) binds: [B:229:0x0451, B:232:0x0459] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0464 A[PHI: r4
      0x0464: PHI (r4v27 float) = (r4v25 float), (r4v26 float) binds: [B:235:0x0462, B:238:0x046a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0466  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x0543 A[PHI: r4
      0x0543: PHI (r4v14 float) = (r4v9 float), (r4v10 float) binds: [B:285:0x0541, B:288:0x0549] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0554 A[PHI: r4
      0x0554: PHI (r4v13 float) = (r4v11 float), (r4v12 float) binds: [B:291:0x0552, B:294:0x055a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:293:0x0556  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r20) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 1667
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.PhotoViewer.onTouchEvent(android.view.MotionEvent):boolean");
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
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.PhotoViewer.checkMinMax(boolean):void");
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

    private void animateTo(float newScale, float newTx, float newTy, boolean isZoom) {
        animateTo(newScale, newTx, newTy, isZoom, 250);
    }

    private void animateTo(float newScale, float newTx, float newTy, boolean isZoom, int duration) {
        if (this.scale == newScale && this.translationX == newTx && this.translationY == newTy) {
            return;
        }
        this.zoomAnimation = isZoom;
        this.animateToScale = newScale;
        this.animateToX = newTx;
        this.animateToY = newTy;
        this.animationStartTime = System.currentTimeMillis();
        AnimatorSet animatorSet = new AnimatorSet();
        this.imageMoveAnimation = animatorSet;
        animatorSet.playTogether(ObjectAnimator.ofFloat(this, AnimationProperties.PHOTO_VIEWER_ANIMATION_VALUE, 0.0f, 1.0f));
        this.imageMoveAnimation.setInterpolator(this.interpolator);
        this.imageMoveAnimation.setDuration(duration);
        this.imageMoveAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.PhotoViewer.71
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                PhotoViewer.this.imageMoveAnimation = null;
                PhotoViewer.this.containerView.invalidate();
            }
        });
        this.imageMoveAnimation.start();
    }

    @Keep
    public void setAnimationValue(float value) {
        this.animationValue = value;
        this.containerView.invalidate();
    }

    @Keep
    public float getAnimationValue() {
        return this.animationValue;
    }

    private void switchToNextIndex(int add, boolean init) throws InterruptedException, Resources.NotFoundException {
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
        setImageIndex(this.currentIndex + add, init, true);
        if (shouldMessageObjectAutoPlayed(this.currentMessageObject) || shouldIndexAutoPlayed(this.currentIndex)) {
            this.playerAutoStarted = true;
            onActionClick(true);
            checkProgress(0, false, true);
        }
        checkFullscreenButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean shouldMessageObjectAutoPlayed(MessageObject messageObject) {
        return messageObject != null && messageObject.isVideo() && (messageObject.mediaExists || messageObject.attachPathExists || (messageObject.canStreamVideo() && SharedConfig.streamMedia)) && SharedConfig.autoplayVideo;
    }

    private boolean shouldIndexAutoPlayed(int index) {
        File file;
        PageBlocksAdapter pageBlocksAdapter = this.pageBlocksAdapter;
        return pageBlocksAdapter != null && pageBlocksAdapter.isVideo(index) && SharedConfig.autoplayVideo && (file = this.pageBlocksAdapter.getFile(index)) != null && file.exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getCropFillScale(boolean rotated) {
        ImageReceiver imageReceiver = this.centerImage;
        int bitmapHeight = rotated ? imageReceiver.getBitmapHeight() : imageReceiver.getBitmapWidth();
        int bitmapWidth = rotated ? this.centerImage.getBitmapWidth() : this.centerImage.getBitmapHeight();
        float fMin = Math.min(this.photoCropView.getMeasuredWidth(), (this.photoCropView.getMeasuredHeight() - AndroidUtilities.dp(64.0f)) - (isStatusBarVisible() ? AndroidUtilities.statusBarHeight : 0)) - (AndroidUtilities.dp(16.0f) * 2);
        return Math.max(fMin / bitmapHeight, fMin / bitmapWidth);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isStatusBarVisible() {
        return Build.VERSION.SDK_INT >= 21 && !this.inBubbleMode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x04c7  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x04cd  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x04eb  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0521  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0556  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x055d  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x05ef  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x05fa  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x0612  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x0634  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x064d  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x0685  */
    /* JADX WARN: Removed duplicated region for block: B:343:0x0689  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x06b3  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x06bd  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x071f  */
    /* JADX WARN: Removed duplicated region for block: B:373:0x0734  */
    /* JADX WARN: Removed duplicated region for block: B:375:0x073e  */
    /* JADX WARN: Removed duplicated region for block: B:378:0x074f  */
    /* JADX WARN: Removed duplicated region for block: B:384:0x077b  */
    /* JADX WARN: Removed duplicated region for block: B:397:0x07a0  */
    /* JADX WARN: Removed duplicated region for block: B:399:0x07a3  */
    /* JADX WARN: Removed duplicated region for block: B:404:0x07b7  */
    /* JADX WARN: Removed duplicated region for block: B:406:0x07be  */
    /* JADX WARN: Removed duplicated region for block: B:409:0x07d1  */
    /* JADX WARN: Removed duplicated region for block: B:411:0x07d9  */
    /* JADX WARN: Removed duplicated region for block: B:413:0x07de  */
    /* JADX WARN: Removed duplicated region for block: B:434:0x085c  */
    /* JADX WARN: Removed duplicated region for block: B:436:0x0866  */
    /* JADX WARN: Removed duplicated region for block: B:449:0x089e  */
    /* JADX WARN: Removed duplicated region for block: B:506:0x0996  */
    /* JADX WARN: Removed duplicated region for block: B:567:0x0b63  */
    /* JADX WARN: Removed duplicated region for block: B:584:0x094f A[EDGE_INSN: B:584:0x094f->B:476:0x094f BREAK  A[LOOP:1: B:447:0x0899->B:475:0x094b], SYNTHETIC] */
    @android.annotation.SuppressLint({"NewApi", "DrawAllocation"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onDraw(android.graphics.Canvas r40) {
        /*
            Method dump skipped, instructions count: 3004
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.PhotoViewer.onDraw(android.graphics.Canvas):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onDraw$66, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onDraw$66$PhotoViewer() throws InterruptedException, Resources.NotFoundException {
        switchToNextIndex(1, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onDraw$67, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onDraw$67$PhotoViewer() throws InterruptedException, Resources.NotFoundException {
        switchToNextIndex(-1, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x012f A[PHI: r1
      0x012f: PHI (r1v7 java.io.File) = 
      (r1v3 java.io.File)
      (r1v3 java.io.File)
      (r1v5 java.io.File)
      (r1v6 java.io.File)
      (r1v20 java.io.File)
      (r1v23 java.io.File)
     binds: [B:59:0x019b, B:61:0x01a1, B:51:0x0181, B:46:0x0142, B:20:0x003c, B:22:0x004a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onActionClick(boolean r11) {
        /*
            Method dump skipped, instructions count: 702
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.PhotoViewer.onActionClick(boolean):void");
    }

    @Override // ir.eitaa.ui.Components.GestureDetector2.OnGestureListener
    public boolean onDown(MotionEvent e) {
        if (!this.doubleTap && this.checkImageView.getVisibility() != 0) {
            boolean[] zArr = this.drawPressedDrawable;
            if (!zArr[0] && !zArr[1]) {
                float x = e.getX();
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

    @Override // ir.eitaa.ui.Components.GestureDetector2.OnDoubleTapListener
    public boolean canDoubleTap(MotionEvent e) {
        MessageObject messageObject;
        if (this.checkImageView.getVisibility() == 0) {
            return true;
        }
        boolean[] zArr = this.drawPressedDrawable;
        if (zArr[0] || zArr[1]) {
            return true;
        }
        float x = e.getX();
        if ((x < Math.min(135, this.containerView.getMeasuredWidth() / 8) || x > this.containerView.getMeasuredWidth() - r3) && (messageObject = this.currentMessageObject) != null) {
            return messageObject.isVideo() && SystemClock.elapsedRealtime() - this.lastPhotoSetTime >= 500 && canDoubleTapSeekVideo(e);
        }
        return true;
    }

    private void hidePressedDrawables() {
        boolean[] zArr = this.drawPressedDrawable;
        zArr[1] = false;
        zArr[0] = false;
        this.containerView.invalidate();
    }

    @Override // ir.eitaa.ui.Components.GestureDetector2.OnGestureListener
    public void onUp(MotionEvent e) {
        hidePressedDrawables();
    }

    @Override // ir.eitaa.ui.Components.GestureDetector2.OnGestureListener
    public boolean onSingleTapUp(MotionEvent e) {
        if (!this.canZoom && !this.doubleTapEnabled) {
            return onSingleTapConfirmed(e);
        }
        if (this.containerView.getTag() != null && this.photoProgressViews[0] != null && this.containerView != null) {
            float x = e.getX();
            float y = e.getY();
            if ((x < ((float) (getContainerViewWidth() - AndroidUtilities.dp(100.0f))) / 2.0f || x > ((float) (getContainerViewWidth() + AndroidUtilities.dp(100.0f))) / 2.0f || y < ((float) (getContainerViewHeight() - AndroidUtilities.dp(100.0f))) / 2.0f || y > ((float) (getContainerViewHeight() + AndroidUtilities.dp(100.0f))) / 2.0f) ? false : onSingleTapConfirmed(e)) {
                this.discardTap = true;
                return true;
            }
        }
        return false;
    }

    public void onLongPress() {
        boolean z;
        VideoPlayer videoPlayer = this.videoPlayer;
        if (videoPlayer == null || !this.videoPlayerControlVisible || this.scale > 1.1f) {
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
        this.videoPlayerRewinder.startRewind(this.videoPlayer, z, this.currentVideoSpeed);
    }

    @Override // ir.eitaa.ui.Components.GestureDetector2.OnGestureListener
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if (this.scale == 1.0f) {
            return false;
        }
        this.scroller.abortAnimation();
        this.scroller.fling(Math.round(this.translationX), Math.round(this.translationY), Math.round(velocityX), Math.round(velocityY), (int) this.minX, (int) this.maxX, (int) this.minY, (int) this.maxY);
        this.containerView.postInvalidate();
        return false;
    }

    @Override // ir.eitaa.ui.Components.GestureDetector2.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent e) throws InterruptedException, Resources.NotFoundException {
        MessageObject messageObject;
        if (this.discardTap) {
            return false;
        }
        float x = e.getX();
        float y = e.getY();
        if (this.checkImageView.getVisibility() != 0 && y > ActionBar.getCurrentActionBarHeight() + AndroidUtilities.statusBarHeight + AndroidUtilities.dp(40.0f)) {
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
                    if (i3 > 0 && i3 <= 3 && x >= (getContainerViewWidth() - AndroidUtilities.dp(100.0f)) / 2.0f && x <= (getContainerViewWidth() + AndroidUtilities.dp(100.0f)) / 2.0f && y >= (getContainerViewHeight() - AndroidUtilities.dp(100.0f)) / 2.0f && y <= (getContainerViewHeight() + AndroidUtilities.dp(100.0f)) / 2.0f) {
                        onActionClick(true);
                        checkProgress(0, false, true);
                        return true;
                    }
                } else if (this.sendPhotoType == 2 && this.isCurrentVideo) {
                    this.manuallyPaused = true;
                    toggleVideoPlayer();
                }
            }
        }
        return true;
    }

    private boolean canDoubleTapSeekVideo(MotionEvent e) {
        if (this.videoPlayer == null) {
            return false;
        }
        boolean z = e.getX() >= ((float) ((getContainerViewWidth() / 3) * 2));
        long currentPosition = this.videoPlayer.getCurrentPosition();
        long duration = this.videoPlayer.getDuration();
        if (currentPosition == -9223372036854775807L || duration <= 15000) {
            return false;
        }
        return !z || duration - currentPosition > 10000;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0100 A[PHI: r3
      0x0100: PHI (r3v18 float) = (r3v13 float), (r3v14 float) binds: [B:50:0x00fe, B:53:0x0106] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x010f A[PHI: r3
      0x010f: PHI (r3v17 float) = (r3v15 float), (r3v16 float) binds: [B:56:0x010d, B:59:0x0115] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0111  */
    @Override // ir.eitaa.ui.Components.GestureDetector2.OnDoubleTapListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onDoubleTap(android.view.MotionEvent r17) {
        /*
            Method dump skipped, instructions count: 294
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.PhotoViewer.onDoubleTap(android.view.MotionEvent):boolean");
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
            this.textPaint.setTypeface(AndroidUtilities.getFontFamily(false));
            this.textPaint.setColor(-3289651);
            this.lowQualityDescription = LocaleController.getString("AccDescrVideoCompressLow", R.string.AccDescrVideoCompressLow);
            this.hightQualityDescription = LocaleController.getString("AccDescrVideoCompressHigh", R.string.AccDescrVideoCompressHigh);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent event) {
            float x = event.getX();
            if (event.getAction() == 0) {
                this.startMovingQuality = PhotoViewer.this.selectedCompression;
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            if (event.getAction() == 0 || event.getAction() == 2) {
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
            } else if (event.getAction() == 1 || event.getAction() == 3) {
                if (PhotoViewer.this.selectedCompression != this.startMovingQuality) {
                    PhotoViewer.this.requestVideoPreview(1);
                }
                PhotoViewer.this.moving = false;
            }
            return true;
        }

        @Override // android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
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
        this.videoTimelineView.setMaxProgressDiff(1.0f);
        this.videoTimelineView.setMode(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void didChangedCompressionLevel(boolean request) {
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putInt(String.format("compress_video_%d", Integer.valueOf(this.compressionsCount)), this.selectedCompression);
        editorEdit.commit();
        updateWidthHeightBitrateForCompression();
        updateVideoInfo();
        if (request) {
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
        this.currentSubtitle = String.format("%s, %s", String.format("%dx%d", Integer.valueOf(i), Integer.valueOf(i2)), String.format("%s, ~%s", AndroidUtilities.formatShortDuration((int) (this.estimatedDuration / 1000)), AndroidUtilities.formatFileSize(this.estimatedSize)));
        this.actionBar.beginDelayedTransition();
        this.actionBar.setSubtitle(this.muteVideo ? LocaleController.getString("SoundMuted", R.string.SoundMuted) : this.currentSubtitle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestVideoPreview(int request) {
        if (this.videoPreviewMessageObject != null) {
            MediaController.getInstance().cancelVideoConvert(this.videoPreviewMessageObject);
        }
        boolean z = this.requestingPreview && !this.tryStartRequestPreviewOnFinish;
        this.requestingPreview = false;
        this.loadInitialVideo = false;
        this.progressView.setVisibility(4);
        if (request == 1) {
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
                    tLRPC$TL_message.id = 0;
                    tLRPC$TL_message.message = "";
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
                if (j == -1) {
                    j = 0;
                }
                if (j2 == -1) {
                    j2 = (long) (this.videoDuration * 1000.0f);
                }
                if (j2 - j > 5000000) {
                    videoEditedInfo2.endTime = j + 5000000;
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
            if (request == 2) {
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

    private void showQualityView(final boolean show) {
        if (show) {
            this.previousCompression = this.selectedCompression;
        }
        AnimatorSet animatorSet = this.qualityChooseViewAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.qualityChooseViewAnimation = new AnimatorSet();
        if (show) {
            this.qualityChooseView.setTag(1);
            this.qualityChooseViewAnimation.playTogether(ObjectAnimator.ofFloat(this.pickerView, (Property<FrameLayout, Float>) View.TRANSLATION_Y, 0.0f, AndroidUtilities.dp(152.0f)), ObjectAnimator.ofFloat(this.pickerViewSendButton, (Property<ImageView, Float>) View.TRANSLATION_Y, 0.0f, AndroidUtilities.dp(152.0f)), ObjectAnimator.ofFloat(this.bottomLayout, (Property<FrameLayout, Float>) View.TRANSLATION_Y, -AndroidUtilities.dp(48.0f), AndroidUtilities.dp(104.0f)));
        } else {
            this.qualityChooseView.setTag(null);
            this.qualityChooseViewAnimation.playTogether(ObjectAnimator.ofFloat(this.qualityChooseView, (Property<QualityChooseView, Float>) View.TRANSLATION_Y, 0.0f, AndroidUtilities.dp(166.0f)), ObjectAnimator.ofFloat(this.qualityPicker, (Property<PickerBottomLayoutViewer, Float>) View.TRANSLATION_Y, 0.0f, AndroidUtilities.dp(166.0f)), ObjectAnimator.ofFloat(this.bottomLayout, (Property<FrameLayout, Float>) View.TRANSLATION_Y, -AndroidUtilities.dp(48.0f), AndroidUtilities.dp(118.0f)));
        }
        this.qualityChooseViewAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.PhotoViewer.74
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                if (animation.equals(PhotoViewer.this.qualityChooseViewAnimation)) {
                    PhotoViewer.this.qualityChooseViewAnimation = new AnimatorSet();
                    if (show) {
                        PhotoViewer.this.qualityChooseView.setVisibility(0);
                        PhotoViewer.this.qualityPicker.setVisibility(0);
                        PhotoViewer.this.qualityChooseViewAnimation.playTogether(ObjectAnimator.ofFloat(PhotoViewer.this.qualityChooseView, (Property<QualityChooseView, Float>) View.TRANSLATION_Y, 0.0f), ObjectAnimator.ofFloat(PhotoViewer.this.qualityPicker, (Property<PickerBottomLayoutViewer, Float>) View.TRANSLATION_Y, 0.0f), ObjectAnimator.ofFloat(PhotoViewer.this.bottomLayout, (Property<FrameLayout, Float>) View.TRANSLATION_Y, -AndroidUtilities.dp(48.0f)));
                    } else {
                        PhotoViewer.this.qualityChooseView.setVisibility(4);
                        PhotoViewer.this.qualityPicker.setVisibility(4);
                        PhotoViewer.this.qualityChooseViewAnimation.playTogether(ObjectAnimator.ofFloat(PhotoViewer.this.pickerView, (Property<FrameLayout, Float>) View.TRANSLATION_Y, 0.0f), ObjectAnimator.ofFloat(PhotoViewer.this.pickerViewSendButton, (Property<ImageView, Float>) View.TRANSLATION_Y, 0.0f), ObjectAnimator.ofFloat(PhotoViewer.this.bottomLayout, (Property<FrameLayout, Float>) View.TRANSLATION_Y, -AndroidUtilities.dp(48.0f)));
                    }
                    PhotoViewer.this.qualityChooseViewAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.PhotoViewer.74.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animation2) {
                            if (animation2.equals(PhotoViewer.this.qualityChooseViewAnimation)) {
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
            public void onAnimationCancel(Animator animation) {
                PhotoViewer.this.qualityChooseViewAnimation = null;
            }
        });
        this.qualityChooseViewAnimation.setDuration(200L);
        this.qualityChooseViewAnimation.setInterpolator(AndroidUtilities.accelerateInterpolator);
        this.qualityChooseViewAnimation.start();
        if (this.cameraItem.getVisibility() == 0) {
            this.cameraItem.animate().scaleX(show ? 0.25f : 1.0f).scaleY(show ? 0.25f : 1.0f).alpha(show ? 0.0f : 1.0f).setDuration(200L);
        }
        if (this.muteItem.getVisibility() == 0) {
            this.muteItem.animate().scaleX(show ? 0.25f : 1.0f).scaleY(show ? 0.25f : 1.0f).alpha(show ? 0.0f : 1.0f).setDuration(200L);
        }
    }

    private void processOpenVideo(final String videoPath, boolean muted, float start, float end) throws InterruptedException {
        if (this.currentLoadingVideoRunnable != null) {
            Utilities.globalQueue.cancelRunnable(this.currentLoadingVideoRunnable);
            this.currentLoadingVideoRunnable = null;
        }
        this.videoTimelineView.setVideoPath(videoPath, start, end);
        this.videoPreviewMessageObject = null;
        boolean z = true;
        if (!muted && this.sendPhotoType != 1) {
            z = false;
        }
        this.muteVideo = z;
        this.compressionsCount = -1;
        this.rotationValue = 0;
        this.videoFramerate = 25;
        this.originalSize = new File(videoPath).length();
        DispatchQueue dispatchQueue = Utilities.globalQueue;
        AnonymousClass75 anonymousClass75 = new AnonymousClass75(videoPath);
        this.currentLoadingVideoRunnable = anonymousClass75;
        dispatchQueue.postRunnable(anonymousClass75);
    }

    /* renamed from: ir.eitaa.ui.PhotoViewer$75, reason: invalid class name */
    class AnonymousClass75 implements Runnable {
        final /* synthetic */ String val$videoPath;

        AnonymousClass75(final String val$videoPath) {
            this.val$videoPath = val$videoPath;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (PhotoViewer.this.currentLoadingVideoRunnable != this) {
                return;
            }
            final int videoBitrate = MediaController.getVideoBitrate(this.val$videoPath);
            final int[] iArr = new int[11];
            AnimatedFileDrawable.getVideoInfo(this.val$videoPath, iArr);
            if (PhotoViewer.this.currentLoadingVideoRunnable != this) {
                return;
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$75$axjGJNo_WOwPdtXPVZHLPcJMBUE
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$run$0$PhotoViewer$75(this, iArr, videoBitrate);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$run$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$run$0$PhotoViewer$75(Runnable runnable, int[] iArr, int i) {
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
                return Math.min(i2, 2);
            }
            i++;
        }
        return Math.min(2, Math.round(DownloadController.getInstance(this.currentAccount).getMaxVideoBitrate() / (100.0f / i)) - 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCompressionsCount(int h, int w) {
        int iMax = Math.max(h, w);
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
    public void setCompressItemEnabled(boolean enabled, boolean animated) {
        ImageView imageView = this.compressItem;
        if (imageView == null) {
            return;
        }
        if (!enabled || imageView.getTag() == null) {
            if (enabled || this.compressItem.getTag() != null) {
                this.compressItem.setTag(enabled ? 1 : null);
                AnimatorSet animatorSet = this.compressItemAnimation;
                if (animatorSet != null) {
                    animatorSet.cancel();
                    this.compressItemAnimation = null;
                }
                if (animated) {
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    this.compressItemAnimation = animatorSet2;
                    Animator[] animatorArr = new Animator[4];
                    ImageView imageView2 = this.compressItem;
                    Property property = View.ALPHA;
                    float[] fArr = new float[1];
                    fArr[0] = enabled ? 1.0f : 0.5f;
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
                this.compressItem.setAlpha(enabled ? 1.0f : 0.5f);
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

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
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
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            PhotoPickerPhotoCell photoPickerPhotoCell = new PhotoPickerPhotoCell(this.mContext);
            photoPickerPhotoCell.checkFrame.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PhotoViewer$ListAdapter$RLr8P1REpJfQjLK5brWyIFgg5CU
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onCreateViewHolder$0$PhotoViewer$ListAdapter(view);
                }
            });
            return new RecyclerListView.Holder(photoPickerPhotoCell);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onCreateViewHolder$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onCreateViewHolder$0$PhotoViewer$ListAdapter(View view) {
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
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            PhotoPickerPhotoCell photoPickerPhotoCell = (PhotoPickerPhotoCell) holder.itemView;
            photoPickerPhotoCell.setItemWidth(AndroidUtilities.dp(85.0f), position != 0 ? AndroidUtilities.dp(6.0f) : 0);
            BackupImageView backupImageView = photoPickerPhotoCell.imageView;
            backupImageView.setOrientation(0, true);
            Object obj = PhotoViewer.this.placeProvider.getSelectedPhotos().get(PhotoViewer.this.placeProvider.getSelectedPhotosOrder().get(position));
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

    /* JADX INFO: Access modifiers changed from: private */
    public int getThemedColor(String key) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
        return color != null ? color.intValue() : Theme.getColor(key);
    }

    public void setOnCloseListener(OnPhotoCloseListener listener) {
        this.onPhotoCloseListener = listener;
    }
}
