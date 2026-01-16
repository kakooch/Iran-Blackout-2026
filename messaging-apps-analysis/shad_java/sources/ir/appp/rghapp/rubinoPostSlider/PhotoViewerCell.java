package ir.appp.rghapp.rubinoPostSlider;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Property;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Scroller;
import android.widget.TextView;
import androidx.annotation.Keep;
import com.facebook.stetho.common.Utf8Charset;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import ir.appp.rghapp.rubinoPostSlider.GestureDetector2;
import ir.appp.rghapp.rubinoPostSlider.RGHPostTagView;
import ir.appp.rghapp.rubinoPostSlider.VideoPlayer;
import ir.medu.shad.R;
import ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx;
import ir.resaneh1.iptv.dialog.LoadingDialog;
import ir.resaneh1.iptv.fragment.rubino.RubinoController;
import ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity;
import ir.resaneh1.iptv.fragment.rubino.rbtv.RBTVFragment;
import ir.resaneh1.iptv.fragment.rubino.rbtv.interfaces.UpdateVideoTime;
import ir.resaneh1.iptv.fragment.rubino.shop.ProductsBottomSheet;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.model.Rubino;
import ir.resaneh1.iptv.model.RubinoPostObject;
import ir.resaneh1.iptv.model.RubinoProfileObject;
import ir.resaneh1.iptv.model.ShopModels;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.ImageReceiver;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.UserConfig;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.LaunchActivity;

/* loaded from: classes3.dex */
public class PhotoViewerCell extends FrameLayout implements GestureDetector2.OnGestureListener, GestureDetector2.OnDoubleTapListener, NotificationCenter.NotificationCenterDelegate {
    private Context activityContext;
    private boolean allowTogglingTags;
    private float animateToScale;
    private float animateToX;
    private float animateToY;
    private long animationStartTime;
    private float animationValue;
    public boolean attachedToWindow;
    private final Paint blackPaint;
    private boolean canZoom;
    private int cellStaticHeight;
    private ImageReceiver centerImage;
    private boolean changingPage;
    private final Runnable checkIgtvRunnable;
    private FrameLayoutDrawer containerView;
    public int currentAccount;
    public int currentIndex;
    public PhotoViewerObject currentObject;
    private int currentPageVisualIndex;
    private String currentPathObject;
    public PhotoSlideObject currentPhotoSlideObject;
    private RubinoPostObject currentPostObject;
    private PhotoViewerCellDelegate delegate;
    private boolean discardTap;
    private boolean doubleTap;
    private boolean doubleTapEnabled;
    private float dragY;
    private int durationToComplete;
    private GestureDetector2 gestureDetector;
    private DisposableObserver<Rubino.ProfileListObject> getProfileIdsObservable;
    private PhotoViewerHeartView heartView;
    private int hidingMediaIndexAnimationState;
    private AnimatorSet imageMoveAnimation;
    Runnable imageTimer;
    private int indicatorIndex;
    private DecelerateInterpolator interpolator;
    private boolean invalidCoords;
    private boolean isAutoScrollEnable;
    private boolean isBlinkingAnimationIsRunning;
    private boolean isCurrentVideo;
    private boolean isPhotoViewerDestroyed;
    private boolean isPlaying;
    private boolean isTagsAddedToContainer;
    private boolean isTagsVisible;
    private boolean isVisible;
    private FrameLayout keepWatchingView;
    private ImageReceiver leftImage;
    private float maxX;
    private float maxY;
    private AnimatorSet mediaIndexAnimation;
    private TextView mediaIndexTextView;
    private FrameLayout mediaInfoContainer;
    private MentionedProfilesBottomSheet mentionedProfilesBottomSheet;
    private float minX;
    private float minY;
    private float moveStartX;
    private float moveStartY;
    private boolean moving;
    private boolean needToHideMediaIndexAfterAttach;
    private boolean needToHideMuteStatusImageAfterAttach;
    private boolean needToHideTagExistenceViewAfterAttach;
    private int ownerClassGuid;
    private ScrollingPagerIndicator pagerIndicator;
    private Activity parentActivity;
    private boolean parentShouldHandleTouch;
    private float pinchCenterX;
    private float pinchCenterY;
    private float pinchStartDistance;
    private float pinchStartScale;
    private float pinchStartX;
    private float pinchStartY;
    private PlayerDelegate playerDelegate;
    private PhotoViewerObject playingObject;
    private float prevTranslationY;
    private float rbtvSeekProgress;
    private ImageReceiver rightImage;
    private float scale;
    private Scroller scroller;
    private float seekToProgressPending;
    private float seekToProgressPending2;
    private PhotoViewerShoppingView shoppingView;
    private boolean shouldCancelProgressUpdateRunnable;
    private boolean shouldCancelVideoCheckRunnable;
    private boolean shouldDrawOverlays;
    private boolean showMediaIndex;
    private ImageReceiver sideImage;
    private int switchImageAfterAnimation;
    private int switchingToIndex;
    private AnimatorSet tagExistenceAnimation;
    private int tagExistenceAnimationState;
    private ImageView tagExistenceImageView;
    private ImageView textureImageView;
    private boolean textureUploaded;
    private int touchSlop;
    private float translationX;
    private float translationY;
    private final Runnable updateProgressRunnable;
    private VelocityTracker velocityTracker;
    private FrameLayout videoContainerFrameLayout;
    private AnimatorSet videoMuteStatusAnimation;
    private int videoMuteStatusAnimationState;
    private ImageView videoMuteStatusImageView;
    private AnimatorSet videoOverlayAnimation;
    private int videoOverlayAnimationState;
    private ImageView videoPlayImageView;
    private VideoPlayer videoPlayer;
    private TextureView videoTextureView;
    private TextView videoTimeTextView;
    private Animation videoTimerBlinkAnimation;
    private boolean zoomAnimation;
    private boolean zooming;
    private boolean zoomingLimitPassed;

    public interface PhotoViewerCellDelegate {
        void onUpdateTransitionZ(boolean z);
    }

    public interface PlayerDelegate {
        void onVideoEnded();
    }

    @Override // ir.appp.rghapp.rubinoPostSlider.GestureDetector2.OnDoubleTapListener
    public boolean canDoubleTap(MotionEvent motionEvent) {
        return true;
    }

    @Override // ir.appp.rghapp.rubinoPostSlider.GestureDetector2.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // ir.appp.rghapp.rubinoPostSlider.GestureDetector2.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // ir.appp.rghapp.rubinoPostSlider.GestureDetector2.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // ir.appp.rghapp.rubinoPostSlider.GestureDetector2.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // ir.appp.rghapp.rubinoPostSlider.GestureDetector2.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // ir.appp.rghapp.rubinoPostSlider.GestureDetector2.OnGestureListener
    public void onUp(MotionEvent motionEvent) {
    }

    public void setPlayerDelegate(PlayerDelegate playerDelegate) {
        this.playerDelegate = playerDelegate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkIgtvVideo() {
        PhotoViewerObject photoViewerObject;
        if (this.videoPlayer != null && (photoViewerObject = this.currentObject) != null && photoViewerObject.isIGTV()) {
            boolean igtvEndToResumeTime = getIgtvEndToResumeTime();
            showKeepWatching(igtvEndToResumeTime);
            if (igtvEndToResumeTime) {
                this.videoPlayer.pause();
                this.shouldCancelVideoCheckRunnable = true;
                AndroidUtilities.cancelRunOnUIThread(this.checkIgtvRunnable);
                return;
            }
            return;
        }
        this.shouldCancelVideoCheckRunnable = true;
        AndroidUtilities.cancelRunOnUIThread(this.checkIgtvRunnable);
    }

    private boolean getIgtvEndToResumeTime() {
        long currentPosition = this.videoPlayer.getCurrentPosition() / 1000;
        long j = RGHAddPostActivity.minIGTVDuration;
        int i = this.currentObject.duration;
        if (i >= 60 && i < 71) {
            j = i - 10;
        }
        return currentPosition >= j;
    }

    private void showKeepWatching(boolean z) {
        PhotoViewerObject photoViewerObject;
        int i = 8;
        if (this.videoPlayer != null && (photoViewerObject = this.currentObject) != null && photoViewerObject.isIGTV() && z) {
            i = 0;
        }
        if (i == 0 && this.keepWatchingView == null) {
            createKeepWatchingView();
        }
        FrameLayout frameLayout = this.keepWatchingView;
        if (frameLayout != null) {
            frameLayout.setVisibility(i);
            this.mediaInfoContainer.setBackgroundColor(i == 0 ? 1744830464 : 0);
        }
    }

    private void createKeepWatchingView() {
        FrameLayout frameLayout = new FrameLayout(this.activityContext);
        this.keepWatchingView = frameLayout;
        frameLayout.setBackgroundResource(R.drawable.rubino_shape_rectangle_grey_alpha);
        this.keepWatchingView.setPadding(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f));
        TextView textView = new TextView(this.activityContext);
        textView.setTypeface(Theme.getRubinoTypeFaceRegular());
        textView.setText(LocaleController.getString(R.string.KeepWatching));
        textView.setTextSize(18.0f);
        textView.setTextColor(-1);
        this.keepWatchingView.addView(textView, LayoutHelper.createFrame(-2, -2.0f, 3, 0.0f, 0.0f, 24.0f, 0.0f));
        ImageView imageView = new ImageView(this.activityContext);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setImageResource(R.drawable.rubino_play_filled_32);
        imageView.setPadding(4, 0, 0, 4);
        this.keepWatchingView.addView(imageView, LayoutHelper.createFrame(24, 24.0f, 5, 0.0f, 0.0f, 0.0f, 0.0f));
        this.mediaInfoContainer.addView(this.keepWatchingView, LayoutHelper.createFrame(-2, -2, 17));
    }

    public class FrameLayoutDrawer extends FrameLayout {
        private boolean ignoreLayout;
        private final Paint paint;

        public FrameLayoutDrawer(Context context) {
            super(context);
            Paint paint = new Paint();
            this.paint = paint;
            setWillNotDraw(false);
            paint.setColor(855638016);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            setMeasuredDimension(size, size2);
            if (!PhotoViewerCell.this.isCurrentVideo) {
                this.ignoreLayout = false;
            }
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() != 8) {
                    if (childAt == PhotoViewerCell.this.videoContainerFrameLayout || childAt == PhotoViewerCell.this.mediaInfoContainer) {
                        childAt.measure(i, View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
                    } else {
                        measureChildWithMargins(childAt, i, 0, i2, 0);
                    }
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x0075  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0084  */
        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected void onLayout(boolean r14, int r15, int r16, int r17, int r18) {
            /*
                r13 = this;
                r0 = r13
                int r1 = r13.getChildCount()
                r2 = 0
            L6:
                if (r2 >= r1) goto L9d
                android.view.View r3 = r13.getChildAt(r2)
                int r4 = r3.getVisibility()
                r5 = 8
                if (r4 != r5) goto L16
                goto L99
            L16:
                ir.appp.rghapp.rubinoPostSlider.PhotoViewerCell r4 = ir.appp.rghapp.rubinoPostSlider.PhotoViewerCell.this
                android.widget.FrameLayout r4 = ir.appp.rghapp.rubinoPostSlider.PhotoViewerCell.access$900(r4)
                if (r3 == r4) goto L39
                ir.appp.rghapp.rubinoPostSlider.PhotoViewerCell r4 = ir.appp.rghapp.rubinoPostSlider.PhotoViewerCell.this
                android.widget.FrameLayout r4 = ir.appp.rghapp.rubinoPostSlider.PhotoViewerCell.access$1000(r4)
                if (r3 != r4) goto L27
                goto L39
            L27:
                int r4 = r13.getPaddingLeft()
                int r4 = r4 + r15
                int r5 = r13.getPaddingRight()
                int r5 = r17 - r5
                int r6 = r13.getPaddingBottom()
                int r6 = r18 - r6
                goto L3e
            L39:
                r4 = r15
                r5 = r17
                r6 = r18
            L3e:
                android.view.ViewGroup$LayoutParams r7 = r3.getLayoutParams()
                android.widget.FrameLayout$LayoutParams r7 = (android.widget.FrameLayout.LayoutParams) r7
                int r8 = r3.getMeasuredWidth()
                int r9 = r3.getMeasuredHeight()
                int r10 = r7.gravity
                r11 = -1
                if (r10 != r11) goto L53
                r10 = 51
            L53:
                r11 = r10 & 7
                r10 = r10 & 112(0x70, float:1.57E-43)
                r11 = r11 & 7
                r12 = 1
                if (r11 == r12) goto L67
                r12 = 5
                if (r11 == r12) goto L62
                int r5 = r7.leftMargin
                goto L71
            L62:
                int r5 = r5 - r4
                int r5 = r5 - r8
                int r11 = r7.rightMargin
                goto L70
            L67:
                int r5 = r5 - r4
                int r5 = r5 - r8
                int r5 = r5 / 2
                int r11 = r7.leftMargin
                int r5 = r5 + r11
                int r11 = r7.rightMargin
            L70:
                int r5 = r5 - r11
            L71:
                r11 = 16
                if (r10 == r11) goto L84
                r11 = 80
                if (r10 == r11) goto L7c
                int r6 = r7.topMargin
                goto L91
            L7c:
                int r6 = r6 + 0
                int r6 = r6 - r16
                int r6 = r6 - r9
                int r7 = r7.bottomMargin
                goto L90
            L84:
                int r6 = r6 + 0
                int r6 = r6 - r16
                int r6 = r6 - r9
                int r6 = r6 / 2
                int r10 = r7.topMargin
                int r6 = r6 + r10
                int r7 = r7.bottomMargin
            L90:
                int r6 = r6 - r7
            L91:
                int r7 = r5 + r4
                int r5 = r5 + r8
                int r5 = r5 + r4
                int r9 = r9 + r6
                r3.layout(r7, r6, r5, r9)
            L99:
                int r2 = r2 + 1
                goto L6
            L9d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.appp.rghapp.rubinoPostSlider.PhotoViewerCell.FrameLayoutDrawer.onLayout(boolean, int, int, int, int):void");
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            PhotoViewerCell.this.internalOnDraw(canvas);
        }

        @Override // android.view.ViewGroup
        protected boolean drawChild(Canvas canvas, View view, long j) {
            try {
                if (view != PhotoViewerCell.this.videoContainerFrameLayout && view != PhotoViewerCell.this.mediaInfoContainer) {
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
    }

    public PhotoViewerCell(Context context, final ScrollingPagerIndicator scrollingPagerIndicator, boolean z) {
        super(context);
        this.currentAccount = UserConfig.selectedAccount;
        this.durationToComplete = 10;
        this.ownerClassGuid = 0;
        this.cellStaticHeight = 0;
        Paint paint = new Paint();
        this.blackPaint = paint;
        this.rbtvSeekProgress = 0.0f;
        this.updateProgressRunnable = new Runnable() { // from class: ir.appp.rghapp.rubinoPostSlider.PhotoViewerCell.1
            @Override // java.lang.Runnable
            public void run() {
                if (PhotoViewerCell.this.videoPlayer != null && PhotoViewerCell.this.isCurrentVideo) {
                    PhotoViewerCell.this.updateVideoPlayerTime(false);
                }
                if (!PhotoViewerCell.this.isPlaying || PhotoViewerCell.this.shouldCancelProgressUpdateRunnable) {
                    return;
                }
                AndroidUtilities.runOnUIThread(PhotoViewerCell.this.updateProgressRunnable, 200L);
            }
        };
        this.checkIgtvRunnable = new Runnable() { // from class: ir.appp.rghapp.rubinoPostSlider.PhotoViewerCell.2
            @Override // java.lang.Runnable
            public void run() {
                PhotoViewerCell.this.checkIgtvVideo();
                if (!PhotoViewerCell.this.isPlaying || PhotoViewerCell.this.shouldCancelVideoCheckRunnable) {
                    return;
                }
                AndroidUtilities.runOnUIThread(PhotoViewerCell.this.checkIgtvRunnable, 200L);
            }
        };
        this.leftImage = new ImageReceiver();
        this.centerImage = new ImageReceiver();
        this.rightImage = new ImageReceiver();
        this.scale = 1.0f;
        this.pinchStartScale = 1.0f;
        this.showMediaIndex = false;
        this.canZoom = true;
        this.needToHideMediaIndexAfterAttach = false;
        this.needToHideMuteStatusImageAfterAttach = false;
        this.needToHideTagExistenceViewAfterAttach = false;
        this.isBlinkingAnimationIsRunning = false;
        this.shouldCancelProgressUpdateRunnable = false;
        this.shouldCancelVideoCheckRunnable = false;
        this.hidingMediaIndexAnimationState = 0;
        this.videoOverlayAnimationState = 0;
        this.videoMuteStatusAnimationState = 0;
        this.tagExistenceAnimationState = 0;
        this.currentPageVisualIndex = 0;
        this.parentShouldHandleTouch = false;
        this.isTagsAddedToContainer = false;
        this.allowTogglingTags = false;
        this.isTagsVisible = false;
        new Paint();
        this.indicatorIndex = 0;
        this.prevTranslationY = 0.0f;
        this.imageTimer = new Runnable() { // from class: ir.appp.rghapp.rubinoPostSlider.PhotoViewerCell$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.considerImageTimer();
            }
        };
        paint.setColor(-16777216);
        this.isAutoScrollEnable = z;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            this.parentActivity = activity;
            this.activityContext = context;
            this.touchSlop = ViewConfiguration.get(activity).getScaledTouchSlop();
            setClipChildren(false);
            setClipToPadding(false);
            setFocusable(false);
            FrameLayoutDrawer frameLayoutDrawer = new FrameLayoutDrawer(this.parentActivity);
            this.containerView = frameLayoutDrawer;
            frameLayoutDrawer.setFocusable(false);
            this.containerView.setClipChildren(false);
            this.containerView.setClipToPadding(false);
            this.containerView.setPadding(0, 0, 0, 0);
            this.scroller = new Scroller(this.parentActivity);
            this.pagerIndicator = scrollingPagerIndicator;
            this.interpolator = new DecelerateInterpolator(1.5f) { // from class: ir.appp.rghapp.rubinoPostSlider.PhotoViewerCell.3
                @Override // android.view.animation.DecelerateInterpolator, android.animation.TimeInterpolator
                public float getInterpolation(float f) {
                    if (f < 1.0d) {
                        if (PhotoViewerCell.this.switchImageAfterAnimation == 2) {
                            if (PhotoViewerCell.this.indicatorIndex > 0) {
                                scrollingPagerIndicator.onPageScrolled(PhotoViewerCell.this.indicatorIndex, 1.0f - f);
                            } else {
                                scrollingPagerIndicator.onPageScrolled(0, 1.0f - f);
                            }
                        } else if (PhotoViewerCell.this.switchImageAfterAnimation == 1 && PhotoViewerCell.this.indicatorIndex - 1 < PhotoViewerCell.this.currentPhotoSlideObject.getPhotos().size() && PhotoViewerCell.this.indicatorIndex > 0) {
                            scrollingPagerIndicator.onPageScrolled(PhotoViewerCell.this.indicatorIndex - 1, f);
                        }
                    }
                    return super.getInterpolation(f);
                }
            };
            addView(this.containerView, LayoutHelper.createFrame(-1, -1, 17));
            FrameLayout frameLayout = new FrameLayout(context);
            this.mediaInfoContainer = frameLayout;
            this.containerView.addView(frameLayout, 0, LayoutHelper.createFrame(-1, -1, 17));
            TextView textView = new TextView(context);
            this.videoTimeTextView = textView;
            textView.setShadowLayer(20.0f, 1.0f, 1.0f, -1728053248);
            this.videoTimeTextView.setTextColor(-1);
            this.videoTimeTextView.setTypeface(Theme.getRubinoTypeFaceRegular());
            this.videoTimeTextView.setTextSize(1, 14.0f);
            this.videoTimeTextView.setText("0:00");
            this.videoTimeTextView.setPadding(4, 0, 4, 0);
            this.mediaInfoContainer.addView(this.videoTimeTextView, LayoutHelper.createFrame(-2, -2.0f, 53, 0.0f, 11.0f, 7.0f, 0.0f));
            ImageView imageView = new ImageView(context);
            this.videoPlayImageView = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.videoPlayImageView.setImageResource(R.drawable.rubino_play_filled_32);
            this.videoPlayImageView.setPadding(4, 0, 0, 4);
            this.mediaInfoContainer.addView(this.videoPlayImageView, LayoutHelper.createFrame(39, 45.0f, 53, 0.0f, 1.0f, 3.5f, 0.0f));
            this.videoPlayImageView.setVisibility(8);
            ImageView imageView2 = new ImageView(this, context) { // from class: ir.appp.rghapp.rubinoPostSlider.PhotoViewerCell.4
                private final RectF rect = new RectF();

                @Override // android.widget.ImageView, android.view.View
                protected void onDraw(Canvas canvas) {
                    this.rect.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
                    canvas.drawRoundRect(this.rect, AndroidUtilities.dp(14.0f), AndroidUtilities.dp(14.0f), Theme.rubino_mediaIndexPaint);
                    super.onDraw(canvas);
                }
            };
            this.videoMuteStatusImageView = imageView2;
            imageView2.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.mediaInfoContainer.addView(this.videoMuteStatusImageView, LayoutHelper.createFrame(28, 28.0f, 85, 0.0f, 0.0f, 14.0f, 14.0f));
            this.videoTimeTextView.setVisibility(8);
            this.videoMuteStatusImageView.setVisibility(8);
            TextView textView2 = new TextView(this, context) { // from class: ir.appp.rghapp.rubinoPostSlider.PhotoViewerCell.5
                private final RectF rect = new RectF();

                @Override // android.widget.TextView, android.view.View
                protected void onDraw(Canvas canvas) {
                    this.rect.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
                    canvas.drawRoundRect(this.rect, AndroidUtilities.dp(14.0f), AndroidUtilities.dp(14.0f), Theme.rubino_mediaIndexPaint);
                    super.onDraw(canvas);
                }
            };
            this.mediaIndexTextView = textView2;
            textView2.setTextColor(-1);
            this.mediaIndexTextView.setPadding(AndroidUtilities.dp(10.5f), AndroidUtilities.dp(5.25f), AndroidUtilities.dp(10.5f), AndroidUtilities.dp(5.25f));
            this.mediaIndexTextView.setTypeface(Theme.getRubinoTypeFaceMedium());
            this.mediaIndexTextView.setTextSize(1, 13.0f);
            this.mediaIndexTextView.setText("1/1");
            this.containerView.addView(this.mediaIndexTextView, LayoutHelper.createFrame(-2, -2.0f, 53, 0.0f, 14.0f, 14.0f, 0.0f));
            PhotoViewerHeartView photoViewerHeartView = new PhotoViewerHeartView(context);
            this.heartView = photoViewerHeartView;
            this.containerView.addView(photoViewerHeartView, LayoutHelper.createFrame(140, 140, 17));
            PhotoViewerShoppingView photoViewerShoppingView = new PhotoViewerShoppingView(context);
            this.shoppingView = photoViewerShoppingView;
            photoViewerShoppingView.setShoppingText(LocaleController.getString(R.string.shop_view_products));
            this.containerView.addView(this.shoppingView, LayoutHelper.createFrame(-2, 27.0f, 83, 14.0f, 0.0f, 0.0f, 14.0f));
            this.shoppingView.setOnClickListener(new View.OnClickListener() { // from class: ir.appp.rghapp.rubinoPostSlider.PhotoViewerCell$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$0(view);
                }
            });
            ImageView imageView3 = new ImageView(this, context) { // from class: ir.appp.rghapp.rubinoPostSlider.PhotoViewerCell.6
                private final RectF rect = new RectF();

                @Override // android.widget.ImageView, android.view.View
                protected void onDraw(Canvas canvas) {
                    this.rect.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
                    canvas.drawRoundRect(this.rect, AndroidUtilities.dp(14.0f), AndroidUtilities.dp(14.0f), Theme.rubino_mediaIndexPaint);
                    super.onDraw(canvas);
                }
            };
            this.tagExistenceImageView = imageView3;
            imageView3.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.tagExistenceImageView.setImageResource(R.drawable.ic_account_circle_filled);
            GestureDetector2 gestureDetector2 = new GestureDetector2(context, this);
            this.gestureDetector = gestureDetector2;
            gestureDetector2.setIsLongpressEnabled(false);
            setDoubleTapEnabled(true);
            this.centerImage.setParentView(this.containerView);
            this.centerImage.setCrossfadeAlpha((byte) 0);
            this.centerImage.setInvalidateAll(true);
            this.leftImage.setParentView(this.containerView);
            this.leftImage.setCrossfadeAlpha((byte) 0);
            this.leftImage.setInvalidateAll(true);
            this.rightImage.setParentView(this.containerView);
            this.rightImage.setCrossfadeAlpha((byte) 0);
            this.rightImage.setInvalidateAll(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view) {
        this.shoppingView.toggleShoppingViewState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTranslationZ() {
        PhotoViewerCellDelegate photoViewerCellDelegate = this.delegate;
        if (photoViewerCellDelegate != null) {
            photoViewerCellDelegate.onUpdateTransitionZ(this.zooming);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            setTranslationZ(this.zooming ? 10.0f : 0.0f);
        }
    }

    public void setPhotoSlideObject(PhotoSlideObject photoSlideObject, RubinoPostObject rubinoPostObject, int i) {
        this.ownerClassGuid = i;
        this.currentPhotoSlideObject = photoSlideObject;
        this.currentPostObject = rubinoPostObject;
        this.cellStaticHeight = photoSlideObject.getReqCellHeight();
        this.pagerIndicator.setDotCount(photoSlideObject.getPhotos().size());
        this.pagerIndicator.setCurrentPosition(photoSlideObject.getCurrentIndex());
        openPhoto(photoSlideObject.getCurrentIndex(), false);
    }

    public void setPhotoViewerCellDelegate(PhotoViewerCellDelegate photoViewerCellDelegate) {
        this.delegate = photoViewerCellDelegate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toggleTagExistenceView(final boolean z, boolean z2) {
        if (this.isTagsAddedToContainer) {
            if (!z2) {
                AnimatorSet animatorSet = this.tagExistenceAnimation;
                if (animatorSet != null) {
                    animatorSet.cancel();
                }
                if (z) {
                    this.tagExistenceImageView.setAlpha(0.0f);
                    return;
                }
                this.tagExistenceImageView.setAlpha(1.0f);
                if (!this.attachedToWindow) {
                    this.needToHideTagExistenceViewAfterAttach = true;
                    return;
                } else {
                    toggleTagExistenceView(true, true);
                    return;
                }
            }
            AnimatorSet animatorSet2 = this.tagExistenceAnimation;
            if (animatorSet2 != null && this.tagExistenceAnimationState == 1 && z) {
                return;
            }
            if (animatorSet2 == null || this.tagExistenceAnimationState != 2 || z) {
                if (animatorSet2 != null) {
                    animatorSet2.cancel();
                }
                this.tagExistenceAnimationState = z ? 1 : 2;
                AnimatorSet animatorSet3 = new AnimatorSet();
                this.tagExistenceAnimation = animatorSet3;
                ImageView imageView = this.tagExistenceImageView;
                Property property = View.ALPHA;
                float[] fArr = new float[1];
                fArr[0] = z ? 0.0f : 1.0f;
                animatorSet3.play(ObjectAnimator.ofFloat(imageView, (Property<ImageView, Float>) property, fArr));
                this.tagExistenceAnimation.setInterpolator(new DecelerateInterpolator(1.5f));
                this.tagExistenceAnimation.setDuration(200L);
                this.tagExistenceAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.appp.rghapp.rubinoPostSlider.PhotoViewerCell.7
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        PhotoViewerCell.this.tagExistenceAnimation = null;
                        PhotoViewerCell.this.tagExistenceAnimationState = 0;
                        if (!z) {
                            PhotoViewerCell.this.tagExistenceImageView.setAlpha(1.0f);
                        } else {
                            PhotoViewerCell.this.tagExistenceImageView.setAlpha(0.0f);
                        }
                    }
                });
                this.tagExistenceAnimation.start();
            }
        }
    }

    private void toggleBlinkingVideoTimerTextView(boolean z) {
        if (this.videoTimerBlinkAnimation == null || z) {
            if (this.isBlinkingAnimationIsRunning && z) {
                TextView textView = this.videoTimeTextView;
                if (textView != null) {
                    if (textView.getAnimation() != null) {
                        this.videoTimeTextView.getAnimation().cancel();
                    }
                    this.videoTimeTextView.clearAnimation();
                    this.videoTimeTextView.setAlpha(0.0f);
                }
                Animation animation = this.videoTimerBlinkAnimation;
                if (animation != null) {
                    animation.cancel();
                }
                this.videoTimerBlinkAnimation = null;
                this.isBlinkingAnimationIsRunning = false;
                return;
            }
            if (z || this.videoTimeTextView == null) {
                return;
            }
            this.isBlinkingAnimationIsRunning = true;
            updateVideoPlayerTime(true);
            this.videoTimeTextView.setVisibility(0);
            this.videoTimeTextView.setAlpha(1.0f);
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.2f);
            this.videoTimerBlinkAnimation = alphaAnimation;
            alphaAnimation.setDuration(450L);
            this.videoTimerBlinkAnimation.setRepeatMode(2);
            this.videoTimerBlinkAnimation.setRepeatCount(-1);
            this.videoTimeTextView.startAnimation(this.videoTimerBlinkAnimation);
        }
    }

    private void toggleVideoTimeProgress(boolean z, boolean z2) {
        FrameLayout frameLayout = this.videoContainerFrameLayout;
        if (frameLayout == null || frameLayout.getVisibility() != 0) {
            return;
        }
        if (!z2) {
            AnimatorSet animatorSet = this.videoOverlayAnimation;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            if (z) {
                this.videoTimeTextView.setAlpha(0.0f);
                this.videoTimeTextView.setVisibility(8);
                this.isBlinkingAnimationIsRunning = false;
                this.shouldCancelProgressUpdateRunnable = true;
                return;
            }
            this.videoTimeTextView.setVisibility(0);
            this.videoTimeTextView.setAlpha(1.0f);
            return;
        }
        AnimatorSet animatorSet2 = this.videoOverlayAnimation;
        if (animatorSet2 != null && this.videoOverlayAnimationState == 1 && z) {
            return;
        }
        if (animatorSet2 == null || this.videoOverlayAnimationState != 2 || z) {
            if (animatorSet2 != null) {
                animatorSet2.cancel();
            }
            this.videoOverlayAnimationState = z ? 1 : 2;
            AnimatorSet animatorSet3 = new AnimatorSet();
            this.videoOverlayAnimation = animatorSet3;
            TextView textView = this.videoTimeTextView;
            Property property = View.ALPHA;
            float[] fArr = new float[1];
            fArr[0] = z ? 0.0f : 1.0f;
            animatorSet3.play(ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) property, fArr));
            this.videoOverlayAnimation.setInterpolator(new DecelerateInterpolator(1.5f));
            this.videoOverlayAnimation.setDuration(200L);
            this.videoOverlayAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.appp.rghapp.rubinoPostSlider.PhotoViewerCell.8
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    PhotoViewerCell.this.videoOverlayAnimation = null;
                    PhotoViewerCell.this.videoOverlayAnimationState = 0;
                }
            });
            this.videoOverlayAnimation.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toggleVideoMuteStatusIcon(final boolean z, boolean z2) {
        if (!z2) {
            AnimatorSet animatorSet = this.videoMuteStatusAnimation;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            if (z) {
                this.videoMuteStatusImageView.setAlpha(0.0f);
                return;
            }
            this.videoMuteStatusImageView.setAlpha(1.0f);
            if (!this.attachedToWindow) {
                this.needToHideMuteStatusImageAfterAttach = true;
                return;
            } else {
                toggleVideoMuteStatusIcon(true, true);
                return;
            }
        }
        AnimatorSet animatorSet2 = this.videoMuteStatusAnimation;
        if (animatorSet2 != null) {
            int i = this.videoMuteStatusAnimationState;
            if (i == 1 && z) {
                return;
            }
            if (i == 2 && !z) {
                return;
            } else {
                animatorSet2.cancel();
            }
        }
        this.videoMuteStatusAnimationState = z ? 1 : 2;
        AnimatorSet animatorSet3 = new AnimatorSet();
        this.videoMuteStatusAnimation = animatorSet3;
        ImageView imageView = this.videoMuteStatusImageView;
        Property property = View.ALPHA;
        float[] fArr = new float[1];
        fArr[0] = z ? 0.0f : 1.0f;
        animatorSet3.play(ObjectAnimator.ofFloat(imageView, (Property<ImageView, Float>) property, fArr));
        this.videoMuteStatusAnimation.setInterpolator(new DecelerateInterpolator(1.5f));
        this.videoMuteStatusAnimation.setDuration(200L);
        if (z) {
            this.videoMuteStatusAnimation.setStartDelay(5000L);
        }
        this.videoMuteStatusAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.appp.rghapp.rubinoPostSlider.PhotoViewerCell.9
            boolean canceled = false;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                this.canceled = true;
                super.onAnimationCancel(animator);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PhotoViewerCell.this.videoMuteStatusAnimation = null;
                PhotoViewerCell.this.videoMuteStatusAnimationState = 0;
                if (this.canceled) {
                    return;
                }
                if (!z) {
                    PhotoViewerCell.this.videoMuteStatusImageView.setAlpha(1.0f);
                    PhotoViewerCell.this.toggleVideoMuteStatusIcon(true, true);
                } else {
                    PhotoViewerCell.this.videoMuteStatusImageView.setAlpha(0.0f);
                }
            }
        });
        this.videoMuteStatusAnimation.start();
    }

    private void setVideoPlayerSound(boolean z) {
        VideoPlayer videoPlayer = this.videoPlayer;
        if (videoPlayer == null) {
            return;
        }
        RubinoPostListActivity.isSoundOn = z;
        videoPlayer.setMute(!z);
        updateVideoMuteStatusImage();
        toggleVideoMuteStatusIcon(false, true);
    }

    private void updateVideoMuteStatusImage() {
        this.videoMuteStatusImageView.setVisibility(0);
        toggleVideoMuteStatusIcon(false, true);
        this.videoMuteStatusImageView.setImageResource(RubinoPostListActivity.isSoundOn ? R.drawable.ic_unmute_insta : R.drawable.ic_mute_insta);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toggleMediaIndexText(final boolean z, boolean z2) {
        if (!z2) {
            AnimatorSet animatorSet = this.mediaIndexAnimation;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            if (z) {
                this.mediaIndexTextView.setAlpha(0.0f);
                return;
            }
            this.mediaIndexTextView.setAlpha(1.0f);
            if (!this.attachedToWindow) {
                this.needToHideMediaIndexAfterAttach = true;
                return;
            } else {
                toggleMediaIndexText(true, true);
                return;
            }
        }
        AnimatorSet animatorSet2 = this.mediaIndexAnimation;
        if (animatorSet2 != null && this.hidingMediaIndexAnimationState == 1 && z) {
            return;
        }
        if (animatorSet2 == null || this.hidingMediaIndexAnimationState != 2 || z) {
            if (animatorSet2 != null) {
                animatorSet2.cancel();
            }
            this.hidingMediaIndexAnimationState = z ? 1 : 2;
            AnimatorSet animatorSet3 = new AnimatorSet();
            this.mediaIndexAnimation = animatorSet3;
            TextView textView = this.mediaIndexTextView;
            Property property = View.ALPHA;
            float[] fArr = new float[1];
            fArr[0] = z ? 0.0f : 1.0f;
            animatorSet3.play(ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) property, fArr));
            this.mediaIndexAnimation.setInterpolator(new DecelerateInterpolator(1.5f));
            this.mediaIndexAnimation.setDuration(200L);
            if (z) {
                this.mediaIndexAnimation.setStartDelay(5000L);
            }
            this.mediaIndexAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.appp.rghapp.rubinoPostSlider.PhotoViewerCell.10
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    PhotoViewerCell.this.mediaIndexAnimation = null;
                    PhotoViewerCell.this.hidingMediaIndexAnimationState = 0;
                    if (!z) {
                        PhotoViewerCell.this.mediaIndexTextView.setAlpha(1.0f);
                        PhotoViewerCell.this.toggleMediaIndexText(true, true);
                    } else {
                        PhotoViewerCell.this.mediaIndexTextView.setAlpha(0.0f);
                    }
                }
            });
            this.mediaIndexAnimation.start();
        }
    }

    private void updateMediaIndexTextView(int i, boolean z) {
        this.currentPageVisualIndex = i;
        this.mediaIndexTextView.setText(String.format(Locale.US, "%d/%d", Integer.valueOf(i), Integer.valueOf(this.currentPhotoSlideObject.getPhotos().size())));
        if (z) {
            toggleMediaIndexText(false, true);
            if (this.currentObject.isVideo) {
                toggleVideoMuteStatusIcon(false, true);
                return;
            }
            return;
        }
        toggleMediaIndexText(false, false);
        if (this.currentObject.isVideo) {
            toggleVideoMuteStatusIcon(false, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateVideoPlayerTime(boolean z) {
        String duration;
        long currentPosition = this.videoPlayer.getCurrentPosition();
        long duration2 = this.videoPlayer.getDuration();
        if (this.videoPlayer == null) {
            duration = formatDuration(0);
        } else {
            if (duration2 < 0) {
                if (z) {
                    return;
                } else {
                    duration2 = 0;
                }
            }
            if (currentPosition < 0) {
                currentPosition = 0;
            }
            if (currentPosition != -9223372036854775807L) {
                currentPosition /= 1000;
                duration = formatDuration((int) ((duration2 / 1000) - currentPosition));
            } else {
                duration = formatDuration(0);
            }
        }
        if (!z && currentPosition > 4) {
            this.shouldCancelProgressUpdateRunnable = true;
            AndroidUtilities.cancelRunOnUIThread(this.updateProgressRunnable);
            if (!this.isBlinkingAnimationIsRunning) {
                toggleVideoTimeProgress(true, true);
            }
        }
        this.videoTimeTextView.setText(duration);
    }

    private String formatDuration(int i) {
        int i2 = i / 3600;
        int i3 = (i / 60) % 60;
        int i4 = i % 60;
        return i2 == 0 ? String.format(Locale.US, "%d:%02d", Integer.valueOf(i3), Integer.valueOf(i4)) : String.format(Locale.US, "%d:%02d:%02d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
    }

    public VideoPlayer getVideoPlayer() {
        return this.videoPlayer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePlayerState(boolean z, int i) {
        MyLog.e("UpdatePlayerState", "state = " + i + " - playWhenReady = " + z);
        if (this.videoPlayer == null) {
            return;
        }
        ImageView imageView = this.videoPlayImageView;
        if (imageView != null && imageView.getVisibility() == 0) {
            this.videoPlayImageView.setVisibility(8);
        }
        if ((i == 3 || i == 1) && this.seekToProgressPending != 0.0f) {
            this.videoPlayer.getDuration();
            this.videoPlayer.seekTo((long) this.seekToProgressPending);
            this.seekToProgressPending = 0.0f;
            this.rbtvSeekProgress = 0.0f;
        }
        if (i == 3 || i == 2) {
            if (this.videoContainerFrameLayout.getVisibility() != 0) {
                this.videoContainerFrameLayout.setVisibility(0);
            }
            if (i == 2) {
                this.shouldCancelProgressUpdateRunnable = true;
                this.shouldCancelVideoCheckRunnable = true;
                AndroidUtilities.cancelRunOnUIThread(this.updateProgressRunnable);
                AndroidUtilities.cancelRunOnUIThread(this.checkIgtvRunnable);
                toggleBlinkingVideoTimerTextView(false);
            } else if (z) {
                this.shouldCancelProgressUpdateRunnable = false;
                this.shouldCancelVideoCheckRunnable = false;
                toggleBlinkingVideoTimerTextView(true);
                toggleVideoTimeProgress(false, false);
                AndroidUtilities.runOnUIThread(this.updateProgressRunnable);
                PhotoViewerObject photoViewerObject = this.currentObject;
                if (photoViewerObject != null && photoViewerObject.isIGTV()) {
                    AndroidUtilities.runOnUIThread(this.checkIgtvRunnable);
                }
            }
        } else {
            toggleVideoTimeProgress(true, false);
            this.shouldCancelProgressUpdateRunnable = true;
            this.shouldCancelVideoCheckRunnable = true;
            AndroidUtilities.cancelRunOnUIThread(this.updateProgressRunnable);
            AndroidUtilities.cancelRunOnUIThread(this.checkIgtvRunnable);
            if (this.videoContainerFrameLayout.getVisibility() != 4) {
                this.videoContainerFrameLayout.setVisibility(4);
            }
        }
        if (i == 4 && z) {
            long duration = this.videoPlayer.getDuration() / 1000;
            int i2 = this.durationToComplete;
            if (duration >= i2) {
                PlayerDelegate playerDelegate = this.playerDelegate;
                if (playerDelegate != null) {
                    playerDelegate.onVideoEnded();
                    return;
                } else {
                    this.videoPlayer.seekTo(0L);
                    return;
                }
            }
            this.durationToComplete = (int) (i2 - (this.videoPlayer.getDuration() / 1000));
            this.videoPlayer.seekTo((int) (this.videoPlayer.getDuration() * this.seekToProgressPending));
            this.seekToProgressPending = 0.0f;
        }
    }

    private void preparePlayer(PhotoViewerObject photoViewerObject, Uri uri, boolean z) {
        PhotoViewerObject photoViewerObject2;
        boolean z2 = false;
        releasePlayer(false);
        if (RubinoController.shouldReleasePlayers.size() > 5) {
            RubinoController.getInstance(this.currentAccount).releaseExistingCachedPlayers();
        }
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.playersShouldPause);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.playerAdjustVolume);
        if (this.parentActivity == null) {
            return;
        }
        if (!this.currentPhotoSlideObject.getPhotos().isEmpty()) {
            createVideoTextureView();
            TextView textView = this.videoTimeTextView;
            if (textView != null && (photoViewerObject2 = this.currentObject) != null) {
                textView.setText(formatDuration(photoViewerObject2.getDuration()));
            }
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
        this.textureUploaded = false;
        if (this.videoPlayer == null) {
            VideoPlayer videoPlayer = new VideoPlayer(this) { // from class: ir.appp.rghapp.rubinoPostSlider.PhotoViewerCell.11
                @Override // ir.appp.rghapp.rubinoPostSlider.VideoPlayer
                public void play() {
                    super.play();
                }

                @Override // ir.appp.rghapp.rubinoPostSlider.VideoPlayer
                public void pause() {
                    super.pause();
                }
            };
            this.videoPlayer = videoPlayer;
            TextureView textureView = this.videoTextureView;
            if (textureView != null) {
                videoPlayer.setTextureView(textureView);
            }
            this.videoPlayer.setDelegate(new VideoPlayer.VideoPlayerDelegate() { // from class: ir.appp.rghapp.rubinoPostSlider.PhotoViewerCell.12
                @Override // ir.appp.rghapp.rubinoPostSlider.VideoPlayer.VideoPlayerDelegate
                public void onStateChanged(boolean z3, int i, boolean z4) {
                    if (MyLog.isDebugAble && i == 3) {
                        MyLog.e("RubinoDownload1 video response", "RubinoDownload1 video response Play Ready");
                    }
                    if (z4 || i == 1) {
                        if (i == 1 && PhotoViewerCell.this.playingObject != null) {
                            try {
                                RubinoController.getInstance(PhotoViewerCell.this.currentAccount).releaseExistingCachedPlayers();
                                PhotoViewerCell.this.playingObject.getDownloadFile().delete();
                                PhotoViewerCell.this.playingObject.isFileExist = false;
                                PhotoViewerCell.this.playingObject.checkIsFileExist();
                            } catch (Exception unused) {
                            }
                        }
                        PhotoViewerCell.this.releasePlayer(false);
                        PhotoViewerCell.this.resetOverIconsToDefaultState();
                        return;
                    }
                    PhotoViewerCell.this.updatePlayerState(z3, i);
                }

                @Override // ir.appp.rghapp.rubinoPostSlider.VideoPlayer.VideoPlayerDelegate
                public void onError(VideoPlayer videoPlayer2, Exception exc) {
                    if (exc.getCause() == null || exc.getCause().getMessage() == null || exc.getCause().getMessage().contains("Unable to connect") || !exc.getCause().getMessage().contains("not zero")) {
                        VideoPlayer unused = PhotoViewerCell.this.videoPlayer;
                    } else if (PhotoViewerCell.this.isAutoScrollEnable) {
                        PhotoViewerCell.this.playerDelegate.onVideoEnded();
                    }
                }

                @Override // ir.appp.rghapp.rubinoPostSlider.VideoPlayer.VideoPlayerDelegate
                public void onVideoSizeChanged(int i, int i2, int i3, float f) {
                    PhotoViewerCell.this.scaleVideoTextureIfNeeded(i, i2, i3);
                    if (PhotoViewerCell.this.videoTextureView != null) {
                        PhotoViewerCell.this.videoTextureView.setAlpha(1.0f);
                    }
                }

                @Override // ir.appp.rghapp.rubinoPostSlider.VideoPlayer.VideoPlayerDelegate
                public void onRenderedFirstFrame() {
                    if (PhotoViewerCell.this.textureUploaded) {
                        return;
                    }
                    PhotoViewerCell.this.textureUploaded = true;
                    PhotoViewerCell.this.containerView.invalidate();
                }
            });
            z2 = true;
        }
        if (!this.currentPhotoSlideObject.getPhotos().isEmpty()) {
            createVideoTextureView();
        }
        if (z2) {
            float f = this.rbtvSeekProgress;
            float f2 = this.seekToProgressPending2;
            if (f > f2) {
                this.seekToProgressPending = f;
            } else {
                this.seekToProgressPending = f2;
            }
            this.videoPlayer.preparePlayer(uri, "rubino");
            this.videoPlayer.setPlayWhenReady(z);
        }
        this.videoPlayer.setLooping(!this.isAutoScrollEnable);
        this.isPlaying = true;
        this.playingObject = photoViewerObject;
        updateVideoMuteStatusImage();
        this.videoPlayer.setMute(!RubinoPostListActivity.isSoundOn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scaleVideoTextureIfNeeded(int i, int i2, int i3) {
        if (this.videoTextureView == null) {
            return;
        }
        if (i3 != 90 && i3 != 270) {
            i2 = i;
            i = i2;
        }
        float f = AndroidUtilities.displaySize.x;
        float f2 = this.cellStaticHeight;
        int i4 = (int) (f / 2.0f);
        int i5 = (int) (f2 / 2.0f);
        float f3 = i / i2;
        if (f2 / f <= f3) {
            float f4 = (f3 * f) / f2;
            if (f4 >= 1.0f) {
                Matrix matrix = new Matrix();
                matrix.setScale(1.0f, f4, i4, i5);
                this.videoTextureView.setTransform(matrix);
                this.videoTextureView.invalidate();
                return;
            }
            return;
        }
        float f5 = (f2 / f3) / f;
        if (f5 >= 1.0f) {
            Matrix matrix2 = new Matrix();
            matrix2.setScale(f5, 1.0f, i4, i5);
            this.videoTextureView.setTransform(matrix2);
            this.videoTextureView.invalidate();
        }
    }

    private void createVideoTextureView() {
        if (this.videoTextureView != null) {
            return;
        }
        FrameLayout frameLayout = new FrameLayout(this.parentActivity) { // from class: ir.appp.rghapp.rubinoPostSlider.PhotoViewerCell.13
            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int i, int i2) {
                super.onMeasure(i, i2);
                if (PhotoViewerCell.this.textureImageView != null) {
                    ViewGroup.LayoutParams layoutParams = PhotoViewerCell.this.textureImageView.getLayoutParams();
                    layoutParams.width = getMeasuredWidth();
                    layoutParams.height = getMeasuredHeight();
                }
            }
        };
        this.videoContainerFrameLayout = frameLayout;
        frameLayout.setVisibility(4);
        this.containerView.addView(this.videoContainerFrameLayout, 0, LayoutHelper.createFrame(-1, -1, 17));
        TextureView textureView = new TextureView(this.parentActivity);
        this.videoTextureView = textureView;
        textureView.setPivotX(0.0f);
        this.videoTextureView.setPivotY(0.0f);
        this.videoTextureView.setOpaque(false);
        this.videoTextureView.setAlpha(0.0f);
        this.videoContainerFrameLayout.addView(this.videoTextureView, LayoutHelper.createFrame(-1, -1, 17));
    }

    public void startImageTimer() {
        AndroidUtilities.cancelRunOnUIThread(this.imageTimer);
        AndroidUtilities.runOnUIThread(this.imageTimer, 10000L);
    }

    public void cancelImageTimer() {
        Runnable runnable = this.imageTimer;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
        }
    }

    public void considerImageTimer() {
        PlayerDelegate playerDelegate;
        if (this.currentObject.isVideo || Build.VERSION.SDK_INT < 19 || !this.containerView.isAttachedToWindow() || (playerDelegate = this.playerDelegate) == null) {
            return;
        }
        playerDelegate.onVideoEnded();
    }

    public void considerAutoPlayingCurrentVideo() {
        if (this.isPhotoViewerDestroyed) {
            openPhoto(this.currentPhotoSlideObject.getCurrentIndex(), true);
            this.indicatorIndex = this.currentPhotoSlideObject.getCurrentIndex();
        }
        if (this.isPlaying) {
            return;
        }
        PhotoViewerObject photoViewerObject = this.currentObject;
        if (photoViewerObject.isVideo) {
            if (photoViewerObject.checkIsFileExist()) {
                preparePlayer(this.currentObject, Uri.fromFile(this.currentObject.getDownloadFile()), true);
                MyLog.e("autoPlay", "autoPlay Video offline " + this.currentObject.postId);
                return;
            }
            try {
                callViewCount();
                FileLoaderRubinoPost.getInstance(this.currentAccount).loadFile(this.currentObject, null, 4, 0);
                this.currentObject.size = 400000000;
                try {
                    URLEncoder.encode(this.currentObject.filePath, Utf8Charset.NAME);
                    URLEncoder.encode(this.currentObject.postId, Utf8Charset.NAME);
                    int i = this.currentObject.size;
                } catch (UnsupportedEncodingException unused) {
                }
                Uri uri = Uri.parse(this.currentObject.filePath);
                MyLog.e("autoPlay", "autoPlay Video OnLine " + this.currentObject.postId);
                preparePlayer(this.currentObject, uri, true);
            } catch (Exception unused2) {
            }
        }
    }

    private void callViewCount() {
        try {
            CompositeDisposable compositeDisposable = ApplicationLoader.applicationActivity.mainCompositeDisposable;
            ApiRequestMessangerRx apiRequestMessangerRx = ApiRequestMessangerRx.getInstance(this.currentAccount);
            Rubino.PostObjectFromServer postObjectFromServer = this.currentPostObject.post;
            compositeDisposable.add((Disposable) apiRequestMessangerRx.addPostViewCount(new Rubino.AddPostViewCountInput(postObjectFromServer.id, postObjectFromServer.profile_id)).subscribeWith(new DisposableObserver<MessangerOutput>(this) { // from class: ir.appp.rghapp.rubinoPostSlider.PhotoViewerCell.14
                @Override // io.reactivex.Observer
                public void onComplete() {
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                }

                @Override // io.reactivex.Observer
                public void onNext(MessangerOutput messangerOutput) {
                }
            }));
        } catch (Exception e) {
            MyLog.handleException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releasePlayer(boolean z) {
        VideoPlayer videoPlayer = this.videoPlayer;
        if (videoPlayer == null) {
            return;
        }
        PhotoViewerObject photoViewerObject = this.playingObject;
        if (photoViewerObject != null && photoViewerObject.isVideo) {
            photoViewerObject.lastPlayedPosition = videoPlayer.getCurrentPosition();
        }
        if (z) {
            this.videoPlayer.releasePlayer();
        } else {
            this.videoPlayer.setDelegate(null);
            this.videoPlayer.pause();
            RubinoController.shouldReleasePlayers.add(this.videoPlayer);
        }
        if (this.playingObject != null) {
            FileLoaderRubinoPost.getInstance(this.currentAccount).cancelLoadFile(this.playingObject);
        }
        this.videoPlayer.setTextureView(null);
        this.videoPlayer = null;
        this.videoContainerFrameLayout.setVisibility(4);
        this.videoTextureView.setAlpha(0.0f);
        if (this.isPlaying) {
            this.isPlaying = false;
            this.shouldCancelProgressUpdateRunnable = true;
            this.shouldCancelVideoCheckRunnable = true;
            AndroidUtilities.cancelRunOnUIThread(this.updateProgressRunnable);
            AndroidUtilities.cancelRunOnUIThread(this.checkIgtvRunnable);
        }
        this.playingObject = null;
        resetOverIconsToDefaultState();
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.playersShouldPause);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.playerAdjustVolume);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetOverIconsToDefaultState() {
        removeExistingAnimations();
        ImageView imageView = this.videoPlayImageView;
        if (imageView != null) {
            PhotoViewerObject photoViewerObject = this.currentObject;
            if (photoViewerObject != null && photoViewerObject.isVideo) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
        TextView textView = this.videoTimeTextView;
        if (textView != null) {
            this.isBlinkingAnimationIsRunning = false;
            this.shouldCancelProgressUpdateRunnable = true;
            textView.setVisibility(8);
        }
        ImageView imageView2 = this.videoMuteStatusImageView;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
    }

    private void removeExistingAnimations() {
        TextView textView = this.videoTimeTextView;
        if (textView != null) {
            if (textView.getAnimation() != null) {
                this.videoTimeTextView.getAnimation().cancel();
            }
            this.videoTimeTextView.clearAnimation();
        }
        Animation animation = this.videoTimerBlinkAnimation;
        if (animation != null) {
            animation.cancel();
            this.videoTimerBlinkAnimation = null;
        }
        AnimatorSet animatorSet = this.mediaIndexAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.mediaIndexAnimation = null;
        }
        AnimatorSet animatorSet2 = this.videoOverlayAnimation;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
            this.videoOverlayAnimation = null;
        }
        AnimatorSet animatorSet3 = this.videoMuteStatusAnimation;
        if (animatorSet3 != null) {
            animatorSet3.cancel();
            this.videoMuteStatusAnimation = null;
        }
        AnimatorSet animatorSet4 = this.tagExistenceAnimation;
        if (animatorSet4 != null) {
            animatorSet4.cancel();
            this.tagExistenceAnimation = null;
        }
        this.videoOverlayAnimationState = 0;
        this.videoMuteStatusAnimationState = 0;
        this.hidingMediaIndexAnimationState = 0;
        this.tagExistenceAnimationState = 0;
    }

    private void setDoubleTapEnabled(boolean z) {
        this.doubleTapEnabled = z;
        this.gestureDetector.setOnDoubleTapListener(z ? this : null);
    }

    private void setImages() {
        setIndexToImage(this.centerImage, this.currentIndex);
        setIndexToImage(this.rightImage, this.currentIndex + 1);
        setIndexToImage(this.leftImage, this.currentIndex - 1);
    }

    private void setIsAboutToSwitchToIndex(int i, boolean z) {
        if (z && this.switchingToIndex == i) {
            return;
        }
        this.switchingToIndex = i;
        if (this.currentPhotoSlideObject.getPhotos().isEmpty() || i < 0 || i >= this.currentPhotoSlideObject.getPhotos().size()) {
            return;
        }
        this.isCurrentVideo = this.currentObject.isVideo();
        if (this.showMediaIndex) {
            updateMediaIndexTextView(this.switchingToIndex + 1, z);
        }
    }

    private void setImageIndex(int i) {
        setImageIndex(i, false);
    }

    private void setImageIndex(int i, boolean z) {
        if (this.currentIndex == i || i < 0) {
            return;
        }
        if (this.currentPhotoSlideObject.getPhotos().isEmpty() || i < this.currentPhotoSlideObject.getPhotos().size()) {
            int i2 = this.currentIndex;
            this.currentIndex = i;
            this.indicatorIndex = i;
            this.currentPageVisualIndex = i + 1;
            removeExistingAnimations();
            this.mentionedProfilesBottomSheet = null;
            removeMediaTags();
            addMediaTags();
            this.translationX = 0.0f;
            this.translationY = 0.0f;
            this.scale = 1.0f;
            this.animateToX = 0.0f;
            this.animateToY = 0.0f;
            this.animateToScale = 1.0f;
            this.animationStartTime = 0L;
            this.imageMoveAnimation = null;
            FrameLayout frameLayout = this.videoContainerFrameLayout;
            if (frameLayout != null) {
                frameLayout.setVisibility(4);
            }
            this.pinchStartDistance = 0.0f;
            this.pinchStartScale = 1.0f;
            this.pinchCenterX = 0.0f;
            this.pinchCenterY = 0.0f;
            this.pinchStartX = 0.0f;
            this.pinchStartY = 0.0f;
            this.moveStartX = 0.0f;
            this.moveStartY = 0.0f;
            this.zooming = false;
            updateTranslationZ();
            this.moving = false;
            this.doubleTap = false;
            this.invalidCoords = false;
            this.changingPage = false;
            this.zoomingLimitPassed = false;
            this.needToHideMediaIndexAfterAttach = false;
            this.needToHideMuteStatusImageAfterAttach = false;
            this.needToHideTagExistenceViewAfterAttach = false;
            this.isBlinkingAnimationIsRunning = false;
            this.shouldCancelProgressUpdateRunnable = false;
            this.switchImageAfterAnimation = 0;
            this.canZoom = !this.currentPhotoSlideObject.getPhotos().isEmpty();
            updateMinMax(this.scale);
            releasePlayer(false);
            AndroidUtilities.cancelRunOnUIThread(this.updateProgressRunnable);
            AndroidUtilities.cancelRunOnUIThread(this.checkIgtvRunnable);
            PhotoViewerObject photoViewerObject = this.currentPhotoSlideObject.getPhotos().get(this.currentIndex);
            this.currentPathObject = photoViewerObject.getFilePath();
            this.currentObject = photoViewerObject;
            setIsAboutToSwitchToIndex(this.currentIndex, z);
            String str = this.currentPathObject;
            if (str == null || str.isEmpty()) {
                return;
            }
            FrameLayout frameLayout2 = this.keepWatchingView;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(8);
            }
            this.mediaInfoContainer.setBackgroundColor(0);
            PhotoViewerObject photoViewerObject2 = this.currentObject;
            if (photoViewerObject2 != null && photoViewerObject2.isVideo() && this.currentObject.isIGTV()) {
                AndroidUtilities.runOnUIThread(this.checkIgtvRunnable);
                this.shouldCancelVideoCheckRunnable = false;
            }
            resetOverIconsToDefaultState();
            if (i2 == -1) {
                setImages();
            } else {
                int i3 = this.currentIndex;
                if (i2 > i3) {
                    ImageReceiver imageReceiver = this.rightImage;
                    this.rightImage = this.centerImage;
                    this.centerImage = this.leftImage;
                    this.leftImage = imageReceiver;
                    setIndexToImage(imageReceiver, i3 - 1);
                } else if (i2 < i3) {
                    ImageReceiver imageReceiver2 = this.leftImage;
                    this.leftImage = this.centerImage;
                    this.centerImage = this.rightImage;
                    this.rightImage = imageReceiver2;
                    setIndexToImage(imageReceiver2, i3 + 1);
                }
            }
            if (z) {
                considerAutoPlayingCurrentVideo();
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.rghapp.rubinoPostSlider.PhotoViewerCell.15
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (RubinoPostListActivity.preloadEnabled) {
                                PhotoViewerObject photoViewerObject3 = PhotoViewerCell.this.currentPhotoSlideObject.getPhotos().get(PhotoViewerCell.this.currentIndex + 1);
                                if (photoViewerObject3.isVideo) {
                                    RubinoPostListActivity.preloadVideo(PhotoViewerCell.this.currentAccount, photoViewerObject3);
                                    RubinoPostListActivity.preloadPhoto(PhotoViewerCell.this.currentAccount, photoViewerObject3.imageObject);
                                } else {
                                    RubinoPostListActivity.preloadPhoto(PhotoViewerCell.this.currentAccount, photoViewerObject3);
                                }
                                PhotoViewerObject photoViewerObject4 = PhotoViewerCell.this.currentPhotoSlideObject.getPhotos().get(PhotoViewerCell.this.currentIndex + 2);
                                if (photoViewerObject4.isVideo) {
                                    RubinoPostListActivity.preloadPhoto(PhotoViewerCell.this.currentAccount, photoViewerObject4.imageObject);
                                } else {
                                    RubinoPostListActivity.preloadPhoto(PhotoViewerCell.this.currentAccount, photoViewerObject4);
                                }
                            }
                        } catch (Exception unused) {
                        }
                    }
                }, 130L);
            }
        }
    }

    private void setIndexToImage(ImageReceiver imageReceiver, int i) {
        imageReceiver.setOrientation(0, false);
        if (this.currentPhotoSlideObject.getPhotos().isEmpty()) {
            return;
        }
        if (i >= 0 && i < this.currentPhotoSlideObject.getPhotos().size()) {
            imageReceiver.setImage(this.currentPhotoSlideObject.getPhotos().get(i).imageObject, (String) null, (Drawable) null, (String) null, 0);
        } else {
            imageReceiver.setImageBitmap((Bitmap) null);
        }
    }

    private void addMediaTags() {
        if (this.isTagsAddedToContainer || this.currentPhotoSlideObject.getPhotos() == null || this.currentPhotoSlideObject.getPhotos().isEmpty()) {
            return;
        }
        int size = this.currentPhotoSlideObject.getPhotos().size();
        int i = this.currentIndex;
        if (size < i || i < 0 || this.currentPhotoSlideObject.getPhotos().get(this.currentIndex).postTags == null || this.currentPhotoSlideObject.getPhotos().get(this.currentIndex).postTags.isEmpty()) {
            return;
        }
        if (!this.currentPhotoSlideObject.getPhotos().get(this.currentIndex).isVideo) {
            for (PostTagObject postTagObject : this.currentPhotoSlideObject.getPhotos().get(this.currentIndex).postTags) {
                if (postTagObject.tagType != PostTagType.USER) {
                    return;
                }
                postTagObject.profileObject = RubinoController.getInstance(this.currentAccount).getTaggedRubinoProfileObject(postTagObject.profileId);
                RGHPostTagView rGHPostTagView = new RGHPostTagView(this.activityContext, postTagObject, this.cellStaticHeight);
                rGHPostTagView.setTag(Integer.valueOf(postTagObject.tagId));
                this.mediaInfoContainer.addView(rGHPostTagView, LayoutHelper.createFrame(-2, -2, 51));
                rGHPostTagView.setTagViewDelegate(new RGHPostTagView.TagViewDelegate() { // from class: ir.appp.rghapp.rubinoPostSlider.PhotoViewerCell$$ExternalSyntheticLambda1
                    @Override // ir.appp.rghapp.rubinoPostSlider.RGHPostTagView.TagViewDelegate
                    public final void onAnimationEnd() {
                        this.f$0.lambda$addMediaTags$1();
                    }
                });
                rGHPostTagView.setVisibility(8);
                this.allowTogglingTags = false;
            }
        } else if (this.mentionedProfilesBottomSheet == null) {
            this.mentionedProfilesBottomSheet = new MentionedProfilesBottomSheet(getContext(), false);
        }
        this.isTagsAddedToContainer = true;
        this.tagExistenceImageView.setAlpha(1.0f);
        this.mediaInfoContainer.addView(this.tagExistenceImageView, LayoutHelper.createFrame(28, 28.0f, 83, 14.0f, 0.0f, 0.0f, 14.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addMediaTags$1() {
        this.allowTogglingTags = (this.moving || this.zooming) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toggleMediaTags() {
        if (this.isTagsAddedToContainer) {
            if (!this.isTagsVisible && this.currentObject.postTags != null) {
                DisposableObserver<Rubino.ProfileListObject> disposableObserver = this.getProfileIdsObservable;
                if ((disposableObserver != null && !disposableObserver.isDisposed()) || this.currentPhotoSlideObject.getPhotos() == null || this.currentPhotoSlideObject.getPhotos().isEmpty()) {
                    return;
                }
                int size = this.currentPhotoSlideObject.getPhotos().size();
                int i = this.currentIndex;
                if (size < i || i < 0) {
                    return;
                }
                ArrayList<String> arrayList = new ArrayList<>();
                for (PostTagObject postTagObject : this.currentPhotoSlideObject.getPhotos().get(this.currentIndex).postTags) {
                    if (postTagObject.profileObject == null && !TextUtils.isEmpty(postTagObject.profileId) && RubinoController.getInstance(this.currentAccount).getTaggedRubinoProfileObject(postTagObject.profileId) == null) {
                        arrayList.add(postTagObject.profileId);
                    }
                }
                if (!arrayList.isEmpty()) {
                    loadProfileIds(arrayList);
                    return;
                }
                updateMediaTags();
            }
            this.isTagsVisible = !this.isTagsVisible;
            for (int i2 = 0; i2 < this.mediaInfoContainer.getChildCount(); i2++) {
                View childAt = this.mediaInfoContainer.getChildAt(i2);
                if (childAt instanceof RGHPostTagView) {
                    this.allowTogglingTags = ((RGHPostTagView) childAt).toggleVisibility();
                }
            }
            toggleTagExistenceView(this.isTagsVisible, true);
        }
    }

    private void loadProfileIds(ArrayList<String> arrayList) {
        DisposableObserver<Rubino.ProfileListObject> disposableObserver = this.getProfileIdsObservable;
        if (disposableObserver == null || disposableObserver.isDisposed()) {
            this.getProfileIdsObservable = (DisposableObserver) RubinoController.getInstance(this.currentAccount).getProfileByIdsObservable(arrayList).subscribeWith(new DisposableObserver<Rubino.ProfileListObject>() { // from class: ir.appp.rghapp.rubinoPostSlider.PhotoViewerCell.16
                @Override // io.reactivex.Observer
                public void onNext(Rubino.ProfileListObject profileListObject) {
                    if (PhotoViewerCell.this.getProfileIdsObservable != null) {
                        PhotoViewerCell.this.getProfileIdsObservable.dispose();
                    }
                    PhotoViewerCell photoViewerCell = PhotoViewerCell.this;
                    PhotoViewerObject photoViewerObject = photoViewerCell.currentObject;
                    if (photoViewerObject != null) {
                        if (photoViewerObject.isVideo) {
                            photoViewerCell.updateMentionedProfilesBottomSheet();
                            ApplicationLoader.applicationActivity.getLastFragment().showDialog(PhotoViewerCell.this.mentionedProfilesBottomSheet);
                        } else {
                            photoViewerCell.updateMediaTags();
                            PhotoViewerCell.this.toggleMediaTags();
                        }
                    }
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                    if (PhotoViewerCell.this.getProfileIdsObservable != null) {
                        PhotoViewerCell.this.getProfileIdsObservable.dispose();
                    }
                }

                @Override // io.reactivex.Observer
                public void onComplete() {
                    if (PhotoViewerCell.this.getProfileIdsObservable != null) {
                        PhotoViewerCell.this.getProfileIdsObservable.dispose();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMentionedProfilesBottomSheet() {
        ArrayList<RubinoProfileObject> arrayList = new ArrayList<>();
        Iterator<PostTagObject> it = this.currentPhotoSlideObject.getPhotos().get(this.currentIndex).postTags.iterator();
        while (it.hasNext()) {
            arrayList.add(RubinoController.getInstance(this.currentAccount).getTaggedRubinoProfileObject(it.next().profileId));
        }
        this.mentionedProfilesBottomSheet.setTaggedProfiles(arrayList);
    }

    private void removeMediaTags() {
        this.mediaInfoContainer.removeView(this.tagExistenceImageView);
        int i = 0;
        while (i < this.mediaInfoContainer.getChildCount()) {
            View childAt = this.mediaInfoContainer.getChildAt(i);
            if (childAt instanceof RGHPostTagView) {
                this.mediaInfoContainer.removeView(childAt);
                i--;
            }
            i++;
        }
        this.isTagsVisible = false;
        this.isTagsAddedToContainer = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMediaTags() {
        for (int i = 0; i < this.mediaInfoContainer.getChildCount(); i++) {
            View childAt = this.mediaInfoContainer.getChildAt(i);
            if (childAt instanceof RGHPostTagView) {
                RGHPostTagView rGHPostTagView = (RGHPostTagView) childAt;
                if (rGHPostTagView.getPostTagObject() != null && rGHPostTagView.getPostTagObject().profileObject == null && !TextUtils.isEmpty(rGHPostTagView.getPostTagObject().profileId)) {
                    rGHPostTagView.getPostTagObject().profileObject = RubinoController.getInstance(this.currentAccount).getTaggedRubinoProfileObject(rGHPostTagView.getPostTagObject().profileId);
                    rGHPostTagView.updateName();
                }
            }
        }
    }

    private boolean openPhoto(int i, boolean z) {
        ArrayList<String> arrayList;
        TextView textView;
        if (this.parentActivity == null) {
            return false;
        }
        setFocusable(true);
        this.containerView.setFocusable(true);
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.showMediaIndex = this.currentPhotoSlideObject.getPhotos().size() > 1;
        RubinoPostObject rubinoPostObject = this.currentPostObject;
        Rubino.PostObjectFromServer postObjectFromServer = rubinoPostObject.post;
        if (postObjectFromServer.is_for_sale && rubinoPostObject.shopStaticLayout != null) {
            this.shoppingView.setVisibility(0);
            this.shoppingView.setShoppingTextStaticLayout(this.currentPostObject.shopStaticLayout);
        } else if (postObjectFromServer.profile_store_id != null && (arrayList = postObjectFromServer.store_product_ids) != null && arrayList.size() > 0) {
            this.shoppingView.setVisibility(0);
        } else {
            this.shoppingView.setVisibility(8);
        }
        if (!z) {
            removeExistingAnimations();
            if (this.showMediaIndex && (textView = this.mediaIndexTextView) != null) {
                textView.setAlpha(1.0f);
                this.mediaIndexTextView.setVisibility(0);
            }
            this.indicatorIndex = 0;
            this.currentPageVisualIndex = 1;
            this.currentPathObject = null;
            this.currentObject = null;
        }
        TextView textView2 = this.mediaIndexTextView;
        if (textView2 != null) {
            if (this.showMediaIndex) {
                textView2.setVisibility(0);
            } else {
                textView2.setVisibility(8);
            }
        }
        this.seekToProgressPending2 = 0.0f;
        this.currentIndex = -1;
        this.containerView.setTag(1);
        this.isCurrentVideo = false;
        this.isPhotoViewerDestroyed = false;
        this.isVisible = true;
        this.containerView.setTag(null);
        setImageIndex(i);
        return true;
    }

    public void closePhoto() {
        releasePlayer(false);
        this.centerImage.clearImage();
        this.leftImage.clearImage();
        this.rightImage.clearImage();
        FrameLayout frameLayout = this.videoContainerFrameLayout;
        if (frameLayout != null) {
            try {
                this.containerView.removeView(frameLayout);
            } catch (Throwable unused) {
            }
            this.videoContainerFrameLayout = null;
        }
        if (this.videoTextureView != null) {
            this.videoTextureView = null;
        }
    }

    public void destroyPhotoViewer() {
        PhotoSlideObject photoSlideObject;
        if (this.parentActivity == null || (photoSlideObject = this.currentPhotoSlideObject) == null) {
            return;
        }
        photoSlideObject.setCurrentIndex(this.currentIndex);
        this.isPhotoViewerDestroyed = true;
        this.parentShouldHandleTouch = true;
        closePhoto();
    }

    private void updateMinMax(float f) {
        int imageWidth = ((int) ((this.centerImage.getImageWidth() * f) - this.containerView.getWidth())) / 2;
        int imageHeight = ((int) ((this.centerImage.getImageHeight() * f) - getContainerViewHeight(0))) / 2;
        if (imageWidth > 0) {
            this.minX = -imageWidth;
            this.maxX = imageWidth;
        } else {
            this.maxX = 0.0f;
            this.minX = 0.0f;
        }
        if (imageHeight > 0) {
            this.minY = -imageHeight;
            this.maxY = imageHeight;
        } else {
            this.maxY = 0.0f;
            this.minY = 0.0f;
        }
    }

    private int getContainerViewHeight(int i) {
        return getContainerViewHeight(false, i);
    }

    private int getContainerViewHeight(boolean z, int i) {
        return this.containerView.getMeasuredHeight();
    }

    /* JADX WARN: Removed duplicated region for block: B:134:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x039d A[PHI: r2
      0x039d: PHI (r2v14 float) = (r2v9 float), (r2v10 float) binds: [B:188:0x039b, B:191:0x03a3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x03ae A[PHI: r2
      0x03ae: PHI (r2v13 float) = (r2v11 float), (r2v12 float) binds: [B:194:0x03ac, B:197:0x03b4] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:196:0x03b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean internalOnTouchEvent(android.view.MotionEvent r15) {
        /*
            Method dump skipped, instructions count: 1095
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.appp.rghapp.rubinoPostSlider.PhotoViewerCell.internalOnTouchEvent(android.view.MotionEvent):boolean");
    }

    private boolean hasRightImage() {
        return this.currentPageVisualIndex < this.currentPhotoSlideObject.getPhotos().size();
    }

    private boolean hasLeftImage() {
        return this.currentPageVisualIndex - 1 > 0;
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
        throw new UnsupportedOperationException("Method not decompiled: ir.appp.rghapp.rubinoPostSlider.PhotoViewerCell.checkMinMax(boolean):void");
    }

    private void goToNext() {
        float width = this.scale != 1.0f ? ((this.containerView.getWidth() - this.centerImage.getImageWidth()) / 2.0f) * this.scale : 0.0f;
        this.switchImageAfterAnimation = 1;
        this.indicatorIndex++;
        animateTo(this.scale, (this.minX - this.containerView.getWidth()) - width, this.translationY, false);
    }

    private void goToPrev() {
        float width = this.scale != 1.0f ? ((this.containerView.getWidth() - this.centerImage.getImageWidth()) / 2.0f) * this.scale : 0.0f;
        this.switchImageAfterAnimation = 2;
        this.indicatorIndex--;
        animateTo(this.scale, this.maxX + this.containerView.getWidth() + width, this.translationY, false);
    }

    private void animateTo(float f, float f2, float f3, boolean z) {
        animateTo(f, f2, f3, z, 300);
    }

    private void animateTo(float f, float f2, float f3, final boolean z, int i) {
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
        animatorSet.play(ObjectAnimator.ofFloat(this, AnimationProperties.RGH_PHOTO_VIEWER_CELL_ANIMATION_VALUE, 0.0f, 1.0f));
        this.imageMoveAnimation.setInterpolator(this.interpolator);
        this.imageMoveAnimation.setDuration(i);
        this.imageMoveAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.appp.rghapp.rubinoPostSlider.PhotoViewerCell.17
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PhotoViewerCell.this.imageMoveAnimation = null;
                if (z) {
                    PhotoViewerCell.this.shouldDrawOverlays = true;
                    PhotoViewerCell.this.allowTogglingTags = true;
                    PhotoViewerCell.this.toggleMediaIndexText(false, true);
                    PhotoViewerCell.this.toggleTagExistenceView(false, true);
                    if (PhotoViewerCell.this.currentPostObject.post.is_for_sale && PhotoViewerCell.this.shoppingView != null && PhotoViewerCell.this.shoppingView.getVisibility() == 8) {
                        PhotoViewerCell.this.shoppingView.toggleVisibility(false);
                    }
                    PhotoViewerCell.this.updateTranslationZ();
                }
                PhotoViewerCell.this.containerView.invalidate();
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

    private void switchToNextIndex(int i) {
        setImageIndex(this.currentIndex + i, true);
    }

    @Override // ir.appp.rghapp.rubinoPostSlider.GestureDetector2.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.canZoom || this.doubleTapEnabled) {
            return false;
        }
        return onSingleTapConfirmed(motionEvent);
    }

    @Override // ir.appp.rghapp.rubinoPostSlider.GestureDetector2.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.scale == 1.0f) {
            return false;
        }
        this.scroller.abortAnimation();
        this.scroller.fling(Math.round(this.translationX), Math.round(this.translationY), Math.round(f), Math.round(f2), (int) this.minX, (int) this.maxX, (int) this.minY, (int) this.maxY);
        this.containerView.postInvalidate();
        return false;
    }

    @Override // ir.appp.rghapp.rubinoPostSlider.GestureDetector2.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        PhotoViewerObject photoViewerObject;
        ArrayList<String> arrayList;
        if (this.discardTap) {
            return false;
        }
        if (this.isTagsAddedToContainer && !this.zooming && !this.moving) {
            Rect rect = new Rect(this.tagExistenceImageView.getLeft(), this.tagExistenceImageView.getTop(), this.tagExistenceImageView.getRight(), this.tagExistenceImageView.getBottom());
            if (this.currentObject.isVideo && rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                MentionedProfilesBottomSheet mentionedProfilesBottomSheet = this.mentionedProfilesBottomSheet;
                if (mentionedProfilesBottomSheet != null) {
                    if (mentionedProfilesBottomSheet.hasSetTaggedProfiles()) {
                        ApplicationLoader.applicationActivity.getLastFragment().showDialog(this.mentionedProfilesBottomSheet);
                    } else {
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        for (PostTagObject postTagObject : this.currentObject.postTags) {
                            if (postTagObject.profileObject == null && !TextUtils.isEmpty(postTagObject.profileId) && RubinoController.getInstance(this.currentAccount).getTaggedRubinoProfileObject(postTagObject.profileId) == null) {
                                arrayList2.add(postTagObject.profileId);
                            }
                        }
                        if (!arrayList2.isEmpty()) {
                            loadProfileIds(arrayList2);
                        } else {
                            updateMentionedProfilesBottomSheet();
                        }
                    }
                }
                return true;
            }
            if (!this.currentObject.isVideo) {
                if (this.isTagsVisible) {
                    MyLog.e("RGHTag", "consider possible click on tags");
                    for (int i = 0; i < this.mediaInfoContainer.getChildCount(); i++) {
                        View childAt = this.mediaInfoContainer.getChildAt(i);
                        if (childAt instanceof RGHPostTagView) {
                            RGHPostTagView rGHPostTagView = (RGHPostTagView) childAt;
                            Rect rect2 = new Rect();
                            childAt.getHitRect(rect2);
                            if (rect2.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                                ((Integer) childAt.getTag()).intValue();
                                if (rGHPostTagView.getPostTagObject() != null && rGHPostTagView.getPostTagObject().profileObject != null) {
                                    new MainClickHandler().onRubinoProfileClick(rGHPostTagView.getPostTagObject().profileObject);
                                }
                                return true;
                            }
                        }
                    }
                }
                toggleMediaTags();
            }
        }
        if (this.shoppingView.getVisibility() == 0) {
            Rubino.PostObjectFromServer postObjectFromServer = this.currentPostObject.post;
            if (postObjectFromServer.profile_store_id != null && (arrayList = postObjectFromServer.store_product_ids) != null && arrayList.size() > 0) {
                if (new Rect(this.shoppingView.getLeft(), this.shoppingView.getTop(), this.shoppingView.getRight(), this.shoppingView.getBottom()).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    callGetProducts();
                }
                return true;
            }
        }
        if (!new Rect(this.videoMuteStatusImageView.getLeft(), this.videoMuteStatusImageView.getTop(), this.videoMuteStatusImageView.getRight(), this.videoMuteStatusImageView.getBottom()).contains((int) motionEvent.getX(), (int) motionEvent.getY()) && (photoViewerObject = this.currentObject) != null && photoViewerObject.isVideo() && this.currentObject.isIGTV()) {
            if (this.videoPlayer == null) {
                return true;
            }
            String str = this.currentObject.filePath;
            ((LaunchActivity) this.parentActivity).lambda$runLinkRequest$40(new RBTVFragment(this.currentPostObject, this.videoPlayer.getCurrentPosition(), this.videoPlayer.getDuration(), new UpdateVideoTime() { // from class: ir.appp.rghapp.rubinoPostSlider.PhotoViewerCell.18
                @Override // ir.resaneh1.iptv.fragment.rubino.rbtv.interfaces.UpdateVideoTime
                public void updateVideo(long j) {
                    PhotoViewerCell.this.rbtvSeekProgress = j;
                    PhotoViewerCell.this.considerAutoPlayingCurrentVideo();
                }
            }));
            return true;
        }
        if (!this.isPlaying) {
            considerAutoPlayingCurrentVideo();
        } else {
            setVideoPlayerSound(!RubinoPostListActivity.isSoundOn);
        }
        return true;
    }

    private void callGetProducts() {
        final LoadingDialog loadingDialog = new LoadingDialog(ApplicationLoader.applicationActivity);
        loadingDialog.show();
        ShopModels.GetPostLinkedProductsInput getPostLinkedProductsInput = new ShopModels.GetPostLinkedProductsInput();
        Rubino.PostObjectFromServer postObjectFromServer = this.currentPostObject.post;
        getPostLinkedProductsInput.store_id = postObjectFromServer.profile_store_id;
        getPostLinkedProductsInput.product_ids = postObjectFromServer.store_product_ids;
        final DisposableObserver disposableObserver = (DisposableObserver) ApiRequestMessangerRx.getInstance(this.currentAccount).getPostLinkedProducts(getPostLinkedProductsInput).subscribeWith(new DisposableObserver<MessangerOutput<ShopModels.GetPostLinkedProductsOutput>>() { // from class: ir.appp.rghapp.rubinoPostSlider.PhotoViewerCell.19
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput<ShopModels.GetPostLinkedProductsOutput> messangerOutput) {
                loadingDialog.dismiss();
                ShopModels.GetPostLinkedProductsOutput getPostLinkedProductsOutput = messangerOutput.data;
                if (getPostLinkedProductsOutput == null || getPostLinkedProductsOutput.products == null || getPostLinkedProductsOutput.products.size() <= 0) {
                    return;
                }
                PhotoViewerCell.this.showProductsBottomSheet(messangerOutput.data.products);
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                loadingDialog.dismiss();
            }
        });
        loadingDialog.show();
        loadingDialog.setOnCancelListener(new DialogInterface.OnCancelListener(this) { // from class: ir.appp.rghapp.rubinoPostSlider.PhotoViewerCell.20
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                disposableObserver.dispose();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showProductsBottomSheet(ArrayList<ShopModels.ProductSummaryObject> arrayList) {
        ProductsBottomSheet productsBottomSheet = new ProductsBottomSheet(this.parentActivity, arrayList);
        if (ApplicationLoader.applicationActivity != null) {
            ApplicationLoader.applicationActivity.getLastFragment().showDialog(productsBottomSheet);
        }
    }

    @Override // ir.appp.rghapp.rubinoPostSlider.GestureDetector2.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        if (!this.canZoom || ((this.scale == 1.0f && !(this.translationY == 0.0f && this.translationX == 0.0f)) || this.animationStartTime != 0)) {
            return false;
        }
        this.doubleTap = true;
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        internalOnTouchEvent(motionEvent);
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(!this.parentShouldHandleTouch);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
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
        int size = View.MeasureSpec.getSize(i);
        setMeasuredDimension(size, this.cellStaticHeight);
        this.containerView.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(this.cellStaticHeight, 1073741824));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = this.containerView.getMeasuredWidth();
        this.containerView.layout(0, 0, measuredWidth + 0, this.containerView.getMeasuredHeight());
        if (z) {
            this.scale = 1.0f;
            this.translationX = 0.0f;
            this.translationY = 0.0f;
            updateMinMax(1.0f);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.attachedToWindow = true;
        if (this.needToHideMediaIndexAfterAttach) {
            this.needToHideMediaIndexAfterAttach = false;
            toggleMediaIndexText(true, true);
        }
        if (this.needToHideMuteStatusImageAfterAttach) {
            this.needToHideMuteStatusImageAfterAttach = false;
            toggleVideoMuteStatusIcon(true, true);
        }
        if (this.needToHideTagExistenceViewAfterAttach) {
            this.needToHideTagExistenceViewAfterAttach = false;
            toggleTagExistenceView(true, true);
        }
        if (this.isPhotoViewerDestroyed) {
            openPhoto(this.currentPhotoSlideObject.getCurrentIndex(), true);
            this.indicatorIndex = this.currentPhotoSlideObject.getCurrentIndex();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        PhotoViewerHeartView photoViewerHeartView = this.heartView;
        if (photoViewerHeartView != null) {
            photoViewerHeartView.stopAnimating();
        }
        this.attachedToWindow = false;
        destroyPhotoViewer();
        cancelImageTimer();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.blackPaint.setAlpha(255);
        canvas.drawRect(0.0f, getMeasuredHeight(), getMeasuredWidth(), getMeasuredHeight(), this.blackPaint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void internalOnDraw(android.graphics.Canvas r20) {
        /*
            Method dump skipped, instructions count: 845
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.appp.rghapp.rubinoPostSlider.PhotoViewerCell.internalOnDraw(android.graphics.Canvas):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$internalOnDraw$2() {
        switchToNextIndex(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$internalOnDraw$3() {
        switchToNextIndex(-1);
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        if (i == NotificationCenter.playersShouldPause) {
            if (((Integer) objArr[0]).intValue() == this.ownerClassGuid) {
                releasePlayer(false);
            }
        } else if (i == NotificationCenter.playerAdjustVolume) {
            setVideoPlayerSound(((Boolean) objArr[0]).booleanValue());
        }
    }
}
