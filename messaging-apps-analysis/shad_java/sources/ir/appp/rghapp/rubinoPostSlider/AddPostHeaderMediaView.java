package ir.appp.rghapp.rubinoPostSlider;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.Scroller;
import androidx.annotation.Keep;
import com.google.android.exoplayer2t.ui.AspectRatioFrameLayout;
import ir.appp.rghapp.RGHMediaHelper$PhotoEntry;
import ir.appp.rghapp.components.sshCrop.SSHCropView;
import ir.appp.rghapp.rubinoPostSlider.VideoPlayer;
import ir.resaneh1.iptv.fragment.rubino.RubinoController;
import java.io.File;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ImageReceiver;
import org.rbmain.messenger.MediaController;
import org.rbmain.messenger.VideoEditedInfo;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class AddPostHeaderMediaView extends FrameLayout {
    private static long mDeBounce;
    private float animateToScale;
    private float animateToX;
    private float animateToY;
    private long animationStartTime;
    private float animationValue;
    private AspectRatioFrameLayout aspectRatioFrameLayout;
    private boolean canZoom;
    private final int cellStaticHeight;
    public ImageReceiver centerImage;
    private boolean changingPage;
    private FrameLayoutDrawer containerView;
    public RGHMediaHelper$PhotoEntry currentObject;
    private AddPostHeaderMediaViewDelegate delegate;
    private int entryLockedRatio;
    private float fitScale;
    private AnimatorSet imageMoveAnimation;
    private DecelerateInterpolator interpolator;
    private boolean invalidCoords;
    private boolean invalidCoordsX;
    private boolean invalidCoordsY;
    private boolean isPlaying;
    private boolean isVisible;
    private float lockScale;
    private float maxX;
    private float maxY;
    private float minScale;
    private float minX;
    private float minY;
    private float moveStartX;
    private float moveStartY;
    private boolean moving;
    private Activity parentActivity;
    private float pinchCenterX;
    private float pinchCenterY;
    private float pinchStartDistance;
    private float pinchStartScale;
    private float pinchStartX;
    private float pinchStartY;
    private float scale;
    private Scroller scroller;
    private boolean textureUploaded;
    private float translationX;
    private float translationY;
    private VelocityTracker velocityTracker;
    private VideoPlayer videoPlayer;
    private TextureView videoTextureView;
    private boolean zooming;

    public interface AddPostHeaderMediaViewDelegate {
        void onSingleTapConfirmed();
    }

    public void destroyPhotoViewer() {
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public AddPostHeaderMediaView(Context context) {
        super(context);
        this.centerImage = new ImageReceiver();
        this.isVisible = true;
        this.scale = 1.0f;
        this.pinchStartScale = 1.0f;
        this.canZoom = true;
        this.entryLockedRatio = -1;
        this.cellStaticHeight = AndroidUtilities.displayMetrics.widthPixels;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            this.parentActivity = activity;
            ViewConfiguration.get(activity).getScaledTouchSlop();
            this.scroller = new Scroller(this.parentActivity);
            setClipChildren(false);
            setClipToPadding(false);
            setFocusable(false);
            unlockContainerRatio();
            FrameLayoutDrawer frameLayoutDrawer = new FrameLayoutDrawer(this.parentActivity);
            this.containerView = frameLayoutDrawer;
            frameLayoutDrawer.setFocusable(false);
            this.containerView.setPadding(0, 0, 0, 0);
            addView(this.containerView, LayoutHelper.createFrame(-1, -1, 17));
            this.centerImage.setParentView(this.containerView);
            this.centerImage.setInvalidateAll(true);
            this.centerImage.setAspectFit(false);
            this.interpolator = new DecelerateInterpolator(this, 1.5f) { // from class: ir.appp.rghapp.rubinoPostSlider.AddPostHeaderMediaView.1
                @Override // android.view.animation.DecelerateInterpolator, android.animation.TimeInterpolator
                public float getInterpolation(float f) {
                    return super.getInterpolation(f);
                }
            };
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void lockContainerRatio() {
        /*
            r6 = this;
            ir.appp.rghapp.RGHMediaHelper$PhotoEntry r0 = r6.currentObject
            if (r0 == 0) goto L6e
            int r0 = r0.imageId
            r6.entryLockedRatio = r0
            float r0 = r6.scale
            r6.lockScale = r0
            org.rbmain.messenger.MediaController r0 = org.rbmain.messenger.MediaController.getInstance()
            r1 = 1
            r0.setLockRatio(r1)
            float r0 = r6.scale
            float r1 = r6.fitScale
            float r0 = r0 / r1
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r1 < 0) goto L2a
            int r0 = org.rbmain.messenger.MediaController.getRubinoContainerViewWidth()
            float r0 = (float) r0
            int r1 = org.rbmain.messenger.MediaController.getRubinoContainerViewHeight()
        L28:
            float r1 = (float) r1
            goto L4e
        L2a:
            ir.appp.rghapp.RGHMediaHelper$PhotoEntry r1 = r6.currentObject
            int r2 = r1.width
            int r1 = r1.height
            if (r2 <= r1) goto L42
            int r1 = org.rbmain.messenger.MediaController.getRubinoContainerViewWidth()
            float r1 = (float) r1
            int r2 = org.rbmain.messenger.MediaController.getRubinoContainerViewHeight()
            float r2 = (float) r2
            float r0 = r0 * r2
            r5 = r1
            r1 = r0
            r0 = r5
            goto L4e
        L42:
            int r1 = org.rbmain.messenger.MediaController.getRubinoContainerViewWidth()
            float r1 = (float) r1
            float r0 = r0 * r1
            int r1 = org.rbmain.messenger.MediaController.getRubinoContainerViewHeight()
            goto L28
        L4e:
            int r2 = org.rbmain.messenger.MediaController.getRubinoContainerViewHeight()
            float r2 = (float) r2
            float r2 = r2 - r1
            r3 = 1073741824(0x40000000, float:2.0)
            float r2 = r2 / r3
            int r4 = org.rbmain.messenger.MediaController.getRubinoContainerViewWidth()
            float r4 = (float) r4
            float r4 = r4 - r0
            float r4 = r4 / r3
            org.rbmain.messenger.MediaController r3 = org.rbmain.messenger.MediaController.getInstance()
            float r0 = r0 + r4
            float r1 = r1 + r2
            r3.setAddPostCropArea(r4, r2, r0, r1)
            ir.appp.rghapp.rubinoPostSlider.AddPostHeaderMediaView$FrameLayoutDrawer r0 = r6.containerView
            if (r0 == 0) goto L6e
            r0.invalidate()
        L6e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.appp.rghapp.rubinoPostSlider.AddPostHeaderMediaView.lockContainerRatio():void");
    }

    public void unlockContainerRatio() {
        this.entryLockedRatio = -1;
        this.lockScale = 1.0f;
        MediaController.getInstance().setLockRatio(false);
        MediaController.getInstance().setAddPostCropArea(0.0f, 0.0f, MediaController.getRubinoContainerViewHeight(), MediaController.getRubinoContainerViewWidth());
        this.scale = Float.MAX_VALUE;
        FrameLayoutDrawer frameLayoutDrawer = this.containerView;
        if (frameLayoutDrawer != null) {
            frameLayoutDrawer.invalidate();
        }
    }

    public void setDelegate(AddPostHeaderMediaViewDelegate addPostHeaderMediaViewDelegate) {
        this.delegate = addPostHeaderMediaViewDelegate;
    }

    public boolean setMedia(RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry) {
        this.currentObject = rGHMediaHelper$PhotoEntry;
        return openMedia();
    }

    public VideoPlayer getVideoPlayer() {
        return this.videoPlayer;
    }

    private void preparePlayer(Uri uri, boolean z) {
        if (this.parentActivity == null) {
            return;
        }
        if (this.currentObject != null && this.videoTextureView == null) {
            createVideoTextureView();
        }
        this.textureUploaded = false;
        if (this.videoPlayer == null) {
            VideoPlayer videoPlayer = new VideoPlayer(this) { // from class: ir.appp.rghapp.rubinoPostSlider.AddPostHeaderMediaView.2
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
            videoPlayer.setDelegate(new VideoPlayer.VideoPlayerDelegate() { // from class: ir.appp.rghapp.rubinoPostSlider.AddPostHeaderMediaView.3
                @Override // ir.appp.rghapp.rubinoPostSlider.VideoPlayer.VideoPlayerDelegate
                public void onStateChanged(boolean z2, int i, boolean z3) {
                }

                @Override // ir.appp.rghapp.rubinoPostSlider.VideoPlayer.VideoPlayerDelegate
                public void onError(VideoPlayer videoPlayer2, Exception exc) {
                    VideoPlayer unused = AddPostHeaderMediaView.this.videoPlayer;
                }

                @Override // ir.appp.rghapp.rubinoPostSlider.VideoPlayer.VideoPlayerDelegate
                public void onVideoSizeChanged(int i, int i2, int i3, float f) {
                    if (AddPostHeaderMediaView.this.aspectRatioFrameLayout != null) {
                        if (i3 != 90 && i3 != 270) {
                            i2 = i;
                            i = i2;
                        }
                        AddPostHeaderMediaView.this.aspectRatioFrameLayout.setAspectRatio(i == 0 ? 1.0f : (i2 * f) / i, i3);
                        AddPostHeaderMediaView.this.containerView.postInvalidate();
                    }
                }

                @Override // ir.appp.rghapp.rubinoPostSlider.VideoPlayer.VideoPlayerDelegate
                public void onRenderedFirstFrame() {
                    if (AddPostHeaderMediaView.this.textureUploaded) {
                        return;
                    }
                    AddPostHeaderMediaView.this.textureUploaded = true;
                    AddPostHeaderMediaView.this.containerView.postInvalidate();
                }
            });
        }
        TextureView textureView = this.videoTextureView;
        if (textureView != null) {
            this.videoPlayer.setTextureView(textureView);
        }
        this.videoPlayer.preparePlayer(uri, "other");
        this.videoPlayer.setPlayWhenReady(z);
        this.videoPlayer.setLooping(true);
        this.isPlaying = true;
    }

    private void createVideoTextureView() {
        if (this.videoTextureView != null) {
            return;
        }
        AspectRatioFrameLayout aspectRatioFrameLayout = new AspectRatioFrameLayout(this.parentActivity);
        this.aspectRatioFrameLayout = aspectRatioFrameLayout;
        this.containerView.addView(aspectRatioFrameLayout, LayoutHelper.createFrame(-1, -1, 17));
        TextureView textureView = new TextureView(this.parentActivity);
        this.videoTextureView = textureView;
        textureView.setPivotX(0.0f);
        this.videoTextureView.setPivotY(0.0f);
        this.videoTextureView.setOpaque(false);
        this.aspectRatioFrameLayout.addView(this.videoTextureView, LayoutHelper.createFrame(-1, -1, 17));
    }

    private void releasePlayer(boolean z) {
        VideoPlayer videoPlayer = this.videoPlayer;
        if (videoPlayer == null) {
            return;
        }
        if (z) {
            videoPlayer.releasePlayer();
            this.aspectRatioFrameLayout.removeView(this.videoTextureView);
            this.videoTextureView = null;
            this.containerView.removeView(this.aspectRatioFrameLayout);
            this.aspectRatioFrameLayout = null;
        } else {
            videoPlayer.setDelegate(null);
            this.videoPlayer.pause();
            RubinoController.shouldReleasePlayers.add(this.videoPlayer);
        }
        this.videoPlayer = null;
        if (this.isPlaying) {
            this.isPlaying = false;
        }
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        internalOnTouchEvent(motionEvent);
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return true;
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
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        destroyPhotoViewer();
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x022d A[PHI: r3
      0x022d: PHI (r3v10 float) = (r3v4 float), (r3v5 float) binds: [B:103:0x022b, B:106:0x0233] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x023e A[PHI: r3
      0x023e: PHI (r3v9 float) = (r3v6 float), (r3v7 float) binds: [B:109:0x023c, B:112:0x0244] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0279 A[PHI: r2
      0x0279: PHI (r2v15 float) = (r2v9 float), (r2v10 float) binds: [B:125:0x0277, B:128:0x027f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x028a A[PHI: r2
      0x028a: PHI (r2v14 float) = (r2v11 float), (r2v12 float) binds: [B:131:0x0288, B:134:0x0290] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x028c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean internalOnTouchEvent(android.view.MotionEvent r13) {
        /*
            Method dump skipped, instructions count: 841
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.appp.rghapp.rubinoPostSlider.AddPostHeaderMediaView.internalOnTouchEvent(android.view.MotionEvent):boolean");
    }

    private void updateMinMax(float f) {
        int imageWidth = ((int) ((this.centerImage.getImageWidth() * f) - MediaController.getInstance().getAddPostCropArea().width())) / 2;
        int imageHeight = ((int) ((this.centerImage.getImageHeight() * f) - MediaController.getInstance().getAddPostCropArea().height())) / 2;
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

    private void animateTo(float f, float f2, float f3, boolean z) {
        animateTo(f, f2, f3, z, 300);
    }

    private void animateTo(float f, float f2, float f3, boolean z, int i) {
        if (this.scale == f && this.translationX == f2 && this.translationY == f3) {
            return;
        }
        this.animateToScale = f;
        this.animateToX = f2;
        this.animateToY = f3;
        this.animationStartTime = System.currentTimeMillis();
        AnimatorSet animatorSet = new AnimatorSet();
        this.imageMoveAnimation = animatorSet;
        animatorSet.playTogether(ObjectAnimator.ofFloat(this, "animationValue", 0.0f, 1.0f));
        this.imageMoveAnimation.setInterpolator(this.interpolator);
        this.imageMoveAnimation.setDuration(i);
        this.imageMoveAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.appp.rghapp.rubinoPostSlider.AddPostHeaderMediaView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AddPostHeaderMediaView.this.imageMoveAnimation = null;
                AddPostHeaderMediaView.this.containerView.postInvalidate();
            }
        });
        this.imageMoveAnimation.start();
    }

    @Keep
    public float getAnimationValue() {
        return this.animationValue;
    }

    @Keep
    public void setAnimationValue(float f) {
        this.animationValue = f;
        this.containerView.postInvalidate();
    }

    public void changeScale() {
        float f = this.scale;
        float f2 = this.minScale;
        if (f == f2) {
            this.scale = this.fitScale;
        } else {
            this.scale = f2;
        }
        updateMinMax(this.scale);
        this.translationX = 0.0f;
        this.translationY = 0.0f;
        RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry = this.currentObject;
        if (rGHMediaHelper$PhotoEntry != null && !rGHMediaHelper$PhotoEntry.isVideo) {
            animateTo(this.scale, 0.0f, 0.0f, true);
        }
        this.containerView.postInvalidate();
    }

    public boolean openMedia() {
        MediaController.CropState cropState;
        if (this.parentActivity != null && this.currentObject != null) {
            setFocusable(true);
            this.containerView.setFocusable(true);
            if (this.velocityTracker == null) {
                this.velocityTracker = VelocityTracker.obtain();
            }
            this.isVisible = true;
            VideoEditedInfo videoEditedInfo = this.currentObject.editedInfo;
            if (videoEditedInfo != null && (cropState = videoEditedInfo.cropState) != null) {
                this.translationX = cropState.translateX;
                this.translationY = cropState.translateY;
                this.scale = Float.MAX_VALUE;
            }
            this.animateToX = 0.0f;
            this.animateToY = 0.0f;
            this.animateToScale = 1.0f;
            this.animationStartTime = 0L;
            this.imageMoveAnimation = null;
            this.pinchStartDistance = 0.0f;
            this.pinchStartScale = 1.0f;
            this.pinchCenterX = 0.0f;
            this.pinchCenterY = 0.0f;
            this.pinchStartX = 0.0f;
            this.pinchStartY = 0.0f;
            this.moveStartX = 0.0f;
            this.moveStartY = 0.0f;
            this.zooming = false;
            this.moving = false;
            this.invalidCoords = false;
            this.changingPage = false;
            this.canZoom = !r0.isVideo;
            releasePlayer(true);
            MediaController.setMediaInfo(this.currentObject);
            RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry = this.currentObject;
            int i = rGHMediaHelper$PhotoEntry.width;
            if (i == 0 && rGHMediaHelper$PhotoEntry.height == 0) {
                return false;
            }
            if (!rGHMediaHelper$PhotoEntry.isVideo) {
                SSHCropView.SSHCropState sSHCropState = rGHMediaHelper$PhotoEntry.cropState;
                sSHCropState.width = i;
                sSHCropState.height = rGHMediaHelper$PhotoEntry.height;
                String str = rGHMediaHelper$PhotoEntry.path;
                if (str == null) {
                    this.centerImage.clearImage();
                } else {
                    this.centerImage.setImage(str, (String) null, (Drawable) null, (String) null, 0L);
                    this.centerImage.setOrientation(this.currentObject.orientation, false);
                }
                this.containerView.postInvalidate();
            } else {
                preparePlayer(Uri.fromFile(new File(this.currentObject.path)), true);
                this.aspectRatioFrameLayout.setVisibility(0);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void internalOnDraw(Canvas canvas) {
        float f;
        float f2;
        float f3;
        if (this.currentObject == null || !this.isVisible) {
            return;
        }
        canvas.clipRect(MediaController.getInstance().getAddPostCropArea());
        RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry = this.currentObject;
        if (rGHMediaHelper$PhotoEntry.isVideo) {
            if (this.aspectRatioFrameLayout == null) {
                return;
            }
            float rubinoContainerViewWidth = MediaController.getRubinoContainerViewWidth() / this.aspectRatioFrameLayout.getWidth();
            float rubinoContainerViewHeight = MediaController.getRubinoContainerViewHeight() / this.aspectRatioFrameLayout.getHeight();
            if (this.aspectRatioFrameLayout.getHeight() > this.aspectRatioFrameLayout.getWidth()) {
                if (MediaController.getInstance().isLockRatio() && this.entryLockedRatio != this.currentObject.imageId) {
                    this.fitScale = MediaController.getInstance().getAddPostCropArea().width() / ((int) (this.aspectRatioFrameLayout.getWidth() * rubinoContainerViewHeight));
                } else {
                    this.fitScale = rubinoContainerViewWidth;
                }
                this.minScale = this.fitScale * 0.834f;
            } else if (this.aspectRatioFrameLayout.getHeight() < this.aspectRatioFrameLayout.getWidth()) {
                if (MediaController.getInstance().isLockRatio() && this.entryLockedRatio != this.currentObject.imageId) {
                    this.fitScale = MediaController.getInstance().getAddPostCropArea().height() / ((int) (this.aspectRatioFrameLayout.getHeight() * rubinoContainerViewWidth));
                } else {
                    this.fitScale = rubinoContainerViewHeight;
                }
                this.minScale = this.fitScale * 0.5f;
            } else {
                this.minScale = 1.0f;
                this.fitScale = 1.0f;
            }
            if (this.minScale < 1.0f) {
                this.minScale = 1.0f;
            }
            if (MediaController.getInstance().isLockRatio() && this.entryLockedRatio == this.currentObject.imageId) {
                float f4 = this.lockScale;
                this.minScale = f4;
                if (this.scale == Float.MAX_VALUE) {
                    this.scale = f4;
                }
            }
            if (this.textureUploaded) {
                if (this.scale == Float.MAX_VALUE) {
                    this.scale = Math.max(this.minScale, this.currentObject.editedInfo.cropState.scale * this.fitScale);
                }
                canvas.translate((MediaController.getRubinoContainerViewWidth() - (this.scale * this.aspectRatioFrameLayout.getWidth())) / 2.0f, (MediaController.getRubinoContainerViewHeight() - (this.scale * this.aspectRatioFrameLayout.getHeight())) / 2.0f);
                float f5 = this.scale;
                canvas.scale(f5, f5);
                this.aspectRatioFrameLayout.draw(canvas);
                this.aspectRatioFrameLayout.setAlpha(1.0f);
            } else {
                this.aspectRatioFrameLayout.setAlpha(0.0f);
                canvas.translate((MediaController.getRubinoContainerViewWidth() - (this.fitScale * this.aspectRatioFrameLayout.getWidth())) / 2.0f, (MediaController.getRubinoContainerViewHeight() - (this.fitScale * this.aspectRatioFrameLayout.getHeight())) / 2.0f);
                float f6 = this.fitScale;
                canvas.scale(f6, f6);
                this.aspectRatioFrameLayout.draw(canvas);
            }
            float f7 = this.scale;
            if (f7 == 0.0f || f7 == Float.MAX_VALUE) {
                return;
            }
            this.currentObject.editedInfo.cropState.scale = f7 / this.fitScale;
            getSavedCropState();
            return;
        }
        if (this.centerImage == null) {
            return;
        }
        int i = rGHMediaHelper$PhotoEntry.width;
        int i2 = rGHMediaHelper$PhotoEntry.height;
        float f8 = i;
        float rubinoContainerViewWidth2 = MediaController.getRubinoContainerViewWidth() / f8;
        float f9 = i2;
        float rubinoContainerViewHeight2 = MediaController.getRubinoContainerViewHeight() / f9;
        if (i2 > i) {
            if (MediaController.getInstance().isLockRatio()) {
                float fWidth = MediaController.getInstance().getAddPostCropArea().width() / ((int) (f8 * rubinoContainerViewHeight2));
                this.fitScale = fWidth;
                this.minScale = fWidth;
            } else {
                float f10 = f9 / f8;
                this.fitScale = f10;
                this.minScale = f10 * 0.834f;
            }
        } else if (i2 < i) {
            if (MediaController.getInstance().isLockRatio()) {
                float fHeight = MediaController.getInstance().getAddPostCropArea().height() / ((int) (f9 * rubinoContainerViewWidth2));
                this.fitScale = fHeight;
                this.minScale = fHeight;
            } else {
                float f11 = f8 / f9;
                this.fitScale = f11;
                this.minScale = f11 * 0.5f;
            }
        } else {
            this.minScale = 1.0f;
            this.fitScale = 1.0f;
        }
        if (this.minScale < 1.0f) {
            this.minScale = 1.0f;
        }
        if (MediaController.getInstance().isLockRatio() && this.entryLockedRatio == this.currentObject.imageId) {
            float f12 = this.lockScale;
            this.minScale = f12;
            if (this.scale == Float.MAX_VALUE) {
                this.scale = f12;
            }
        }
        float fMin = Math.min(rubinoContainerViewWidth2, rubinoContainerViewHeight2);
        int i3 = (int) (f8 * fMin);
        int i4 = (int) (f9 * fMin);
        if (this.scale == Float.MAX_VALUE) {
            this.scale = Math.max(this.minScale, this.currentObject.editedInfo.cropState.scale * this.fitScale);
        }
        if (this.imageMoveAnimation != null) {
            if (!this.scroller.isFinished()) {
                this.scroller.abortAnimation();
            }
            float f13 = this.scale;
            float f14 = this.animateToScale - f13;
            float f15 = this.animationValue;
            f = f13 + (f14 * f15);
            float f16 = this.translationX;
            f2 = f16 + ((this.animateToX - f16) * f15);
            float f17 = this.translationY;
            f3 = f17 + ((this.animateToY - f17) * f15);
            this.containerView.postInvalidate();
        } else {
            if (this.animationStartTime != 0) {
                this.translationX = this.animateToX;
                this.translationY = this.animateToY;
                float f18 = this.animateToScale;
                this.scale = f18;
                this.animationStartTime = 0L;
                updateMinMax(f18);
            }
            if (!this.scroller.isFinished() && this.scroller.computeScrollOffset()) {
                if (this.scroller.getStartX() < this.maxX && this.scroller.getStartX() > this.minX) {
                    this.translationX = this.scroller.getCurrX();
                }
                if (this.scroller.getStartY() < this.maxY && this.scroller.getStartY() > this.minY) {
                    this.translationY = this.scroller.getCurrY();
                }
                this.containerView.postInvalidate();
            }
            f = this.scale;
            f2 = this.translationX;
            f3 = this.translationY;
        }
        canvas.translate((MediaController.getRubinoContainerViewWidth() / 2.0f) + f2, (MediaController.getRubinoContainerViewHeight() / 2.0f) + f3);
        canvas.scale(f, f);
        this.centerImage.setImageCoords((-i3) / 2, (-i4) / 2, i3, i4);
        this.centerImage.draw(canvas);
        if (f != 0.0f) {
            getSavedCropState();
        }
    }

    public void getSavedCropState() {
        int iRound;
        int i;
        int i2;
        VideoEditedInfo videoEditedInfo;
        int i3;
        RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry = this.currentObject;
        float f = 1.0f;
        if (rGHMediaHelper$PhotoEntry.isVideo) {
            int i4 = rGHMediaHelper$PhotoEntry.width;
            int i5 = rGHMediaHelper$PhotoEntry.height;
            int iMin = Math.min(MediaController.MAX_WIDTH_HEIGHT_SIZE, Math.min(i4, i5));
            float f2 = (MediaController.getInstance().isLockRatio() ? this.minScale : this.scale) / this.fitScale;
            if (iMin < 800) {
                f2 = 1.0f;
            }
            if (i4 > i5) {
                float f3 = iMin * f2;
                i2 = (int) (i4 * (f3 / i5));
                i = (int) f3;
            } else {
                float f4 = iMin * f2;
                i = (int) (i5 * (f4 / i4));
                i2 = (int) f4;
            }
            RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry2 = this.currentObject;
            VideoEditedInfo videoEditedInfo2 = rGHMediaHelper$PhotoEntry2.editedInfo;
            videoEditedInfo2.resultWidth = i2;
            videoEditedInfo2.resultHeight = i;
            if (rGHMediaHelper$PhotoEntry2.width > rGHMediaHelper$PhotoEntry2.height) {
                if (videoEditedInfo2.cropState.scale == 1.0f && !MediaController.getInstance().isLockRatio()) {
                    this.currentObject.editedInfo.cropState.cropPw = r0.resultHeight / r0.resultWidth;
                } else {
                    this.currentObject.editedInfo.cropState.cropPw = MediaController.getInstance().getAddPostCropArea().width() / (this.videoTextureView.getWidth() * this.scale);
                }
                this.currentObject.editedInfo.cropState.cropPh = 1.0f;
            } else {
                if (videoEditedInfo2.cropState.scale == 1.0f && !MediaController.getInstance().isLockRatio()) {
                    this.currentObject.editedInfo.cropState.cropPh = r0.resultWidth / r0.resultHeight;
                } else {
                    this.currentObject.editedInfo.cropState.cropPh = MediaController.getInstance().getAddPostCropArea().height() / (this.videoTextureView.getHeight() * this.scale);
                }
                this.currentObject.editedInfo.cropState.cropPw = 1.0f;
            }
            VideoEditedInfo videoEditedInfo3 = this.currentObject.editedInfo;
            videoEditedInfo3.rotationValue += videoEditedInfo3.cropState.transformRotation;
            while (true) {
                videoEditedInfo = this.currentObject.editedInfo;
                i3 = videoEditedInfo.rotationValue;
                if (i3 < 360) {
                    break;
                } else {
                    videoEditedInfo.rotationValue = i3 - 360;
                }
            }
            if (i3 == 90 || i3 == 270) {
                MediaController.CropState cropState = videoEditedInfo.cropState;
                cropState.transformWidth = (int) (videoEditedInfo.resultWidth * cropState.cropPh);
                cropState.transformHeight = (int) (videoEditedInfo.resultHeight * cropState.cropPw);
            } else {
                MediaController.CropState cropState2 = videoEditedInfo.cropState;
                cropState2.transformWidth = (int) (videoEditedInfo.resultWidth * cropState2.cropPw);
                cropState2.transformHeight = (int) (videoEditedInfo.resultHeight * cropState2.cropPh);
            }
            MediaController.CropState cropState3 = videoEditedInfo.cropState;
            int[] iArrFixVideoWidthHeight = MediaController.fixVideoWidthHeight(cropState3.transformWidth, cropState3.transformHeight);
            MediaController.CropState cropState4 = this.currentObject.editedInfo.cropState;
            cropState4.transformWidth = iArrFixVideoWidthHeight[0];
            cropState4.transformHeight = iArrFixVideoWidthHeight[1];
            return;
        }
        MediaController.CropState cropState5 = rGHMediaHelper$PhotoEntry.editedInfo.cropState;
        float f5 = this.scale;
        float f6 = this.fitScale;
        cropState5.scale = f5 / f6;
        cropState5.minScale = this.minScale / f6;
        cropState5.translateX = (int) this.translationX;
        cropState5.translateY = (int) this.translationY;
        if (MediaController.getInstance().isLockRatio()) {
            this.currentObject.cropState.reset();
            this.currentObject.cropState.reset(MediaController.getInstance().getAddPostCropArea(), Math.max(1.0f, this.currentObject.editedInfo.cropState.scale), 0.0f, false);
            RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry3 = this.currentObject;
            SSHCropView.SSHCropState sSHCropState = rGHMediaHelper$PhotoEntry3.cropState;
            MediaController.CropState cropState6 = rGHMediaHelper$PhotoEntry3.editedInfo.cropState;
            sSHCropState.translate(cropState6.translateX, cropState6.translateY);
        } else {
            this.currentObject.cropState.reset();
            RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry4 = this.currentObject;
            rGHMediaHelper$PhotoEntry4.cropState.scale(Math.max(1.0f, rGHMediaHelper$PhotoEntry4.editedInfo.cropState.scale), 0.0f, 0.0f);
            RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry5 = this.currentObject;
            SSHCropView.SSHCropState sSHCropState2 = rGHMediaHelper$PhotoEntry5.cropState;
            MediaController.CropState cropState7 = rGHMediaHelper$PhotoEntry5.editedInfo.cropState;
            sSHCropState2.translate(cropState7.translateX, cropState7.translateY);
        }
        RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry6 = this.currentObject;
        int i6 = rGHMediaHelper$PhotoEntry6.width;
        int i7 = rGHMediaHelper$PhotoEntry6.height;
        int iMin2 = Math.min(MediaController.MAX_WIDTH_HEIGHT_SIZE, Math.min(i6, i7));
        float f7 = (MediaController.getInstance().isLockRatio() ? this.minScale : this.scale) / this.fitScale;
        if (f7 >= 1.0f && !MediaController.getInstance().isLockRatio()) {
            iRound = iMin2;
        } else if (i6 > i7) {
            float f8 = iMin2;
            int iRound2 = Math.round(MediaController.getInstance().getAddPostCropArea().width() * (f8 / (MediaController.getInstance().getAddPostCropArea().height() * f7)));
            f = f8 / iRound2;
            iMin2 = iRound2;
            iRound = iMin2;
        } else {
            float f9 = iMin2;
            iRound = Math.round(MediaController.getInstance().getAddPostCropArea().height() * (f9 / (MediaController.getInstance().getAddPostCropArea().width() * f7)));
            f = f9 / iRound;
        }
        int i8 = (int) (iMin2 * f);
        int i9 = (int) (iRound * f);
        VideoEditedInfo videoEditedInfo4 = this.currentObject.editedInfo;
        videoEditedInfo4.resultWidth = i8;
        videoEditedInfo4.resultHeight = i9;
        int[] iArrFixVideoWidthHeight2 = MediaController.fixVideoWidthHeight(i8, i9);
        VideoEditedInfo videoEditedInfo5 = this.currentObject.editedInfo;
        videoEditedInfo5.resultWidth = iArrFixVideoWidthHeight2[0];
        videoEditedInfo5.resultHeight = iArrFixVideoWidthHeight2[1];
    }

    protected RGHMediaHelper$PhotoEntry getCurrentObject() {
        return this.currentObject;
    }

    protected boolean isPlaying() {
        return this.isPlaying;
    }

    protected void onPause() {
        releasePlayer(true);
    }

    protected void onResume() {
        getParent().requestDisallowInterceptTouchEvent(true);
        if (this.currentObject != null) {
            openMedia();
        }
    }

    public class FrameLayoutDrawer extends FrameLayout {
        public FrameLayoutDrawer(Context context) {
            super(context);
            setWillNotDraw(false);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            setMeasuredDimension(size, size2);
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() != 8) {
                    if (childAt == AddPostHeaderMediaView.this.aspectRatioFrameLayout) {
                        childAt.measure(i, View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
                    } else {
                        measureChildWithMargins(childAt, i, 0, i2, 0);
                    }
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x006c  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x007b  */
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
                if (r2 >= r1) goto L94
                android.view.View r3 = r13.getChildAt(r2)
                int r4 = r3.getVisibility()
                r5 = 8
                if (r4 != r5) goto L16
                goto L90
            L16:
                ir.appp.rghapp.rubinoPostSlider.AddPostHeaderMediaView r4 = ir.appp.rghapp.rubinoPostSlider.AddPostHeaderMediaView.this
                com.google.android.exoplayer2t.ui.AspectRatioFrameLayout r4 = ir.appp.rghapp.rubinoPostSlider.AddPostHeaderMediaView.access$100(r4)
                if (r3 != r4) goto L24
                r4 = r15
                r5 = r17
                r6 = r18
                goto L35
            L24:
                int r4 = r13.getPaddingLeft()
                int r4 = r4 + r15
                int r5 = r13.getPaddingRight()
                int r5 = r17 - r5
                int r6 = r13.getPaddingBottom()
                int r6 = r18 - r6
            L35:
                android.view.ViewGroup$LayoutParams r7 = r3.getLayoutParams()
                android.widget.FrameLayout$LayoutParams r7 = (android.widget.FrameLayout.LayoutParams) r7
                int r8 = r3.getMeasuredWidth()
                int r9 = r3.getMeasuredHeight()
                int r10 = r7.gravity
                r11 = -1
                if (r10 != r11) goto L4a
                r10 = 51
            L4a:
                r11 = r10 & 7
                r10 = r10 & 112(0x70, float:1.57E-43)
                r11 = r11 & 7
                r12 = 1
                if (r11 == r12) goto L5e
                r12 = 5
                if (r11 == r12) goto L59
                int r5 = r7.leftMargin
                goto L68
            L59:
                int r5 = r5 - r4
                int r5 = r5 - r8
                int r11 = r7.rightMargin
                goto L67
            L5e:
                int r5 = r5 - r4
                int r5 = r5 - r8
                int r5 = r5 / 2
                int r11 = r7.leftMargin
                int r5 = r5 + r11
                int r11 = r7.rightMargin
            L67:
                int r5 = r5 - r11
            L68:
                r11 = 16
                if (r10 == r11) goto L7b
                r11 = 80
                if (r10 == r11) goto L73
                int r6 = r7.topMargin
                goto L88
            L73:
                int r6 = r6 + 0
                int r6 = r6 - r16
                int r6 = r6 - r9
                int r7 = r7.bottomMargin
                goto L87
            L7b:
                int r6 = r6 + 0
                int r6 = r6 - r16
                int r6 = r6 - r9
                int r6 = r6 / 2
                int r10 = r7.topMargin
                int r6 = r6 + r10
                int r7 = r7.bottomMargin
            L87:
                int r6 = r6 - r7
            L88:
                int r7 = r5 + r4
                int r5 = r5 + r8
                int r5 = r5 + r4
                int r9 = r9 + r6
                r3.layout(r7, r6, r5, r9)
            L90:
                int r2 = r2 + 1
                goto L6
            L94:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.appp.rghapp.rubinoPostSlider.AddPostHeaderMediaView.FrameLayoutDrawer.onLayout(boolean, int, int, int, int):void");
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            AddPostHeaderMediaView.this.internalOnDraw(canvas);
        }

        @Override // android.view.ViewGroup
        protected boolean drawChild(Canvas canvas, View view, long j) {
            try {
                if (view != AddPostHeaderMediaView.this.aspectRatioFrameLayout) {
                    if (super.drawChild(canvas, view, j)) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable unused) {
                return true;
            }
        }
    }
}
