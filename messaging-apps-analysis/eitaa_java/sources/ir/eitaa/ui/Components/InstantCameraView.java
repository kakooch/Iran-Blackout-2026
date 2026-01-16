package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.media.AudioRecord;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.net.Uri;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Property;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.graphics.ColorUtils;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.BuildVars;
import ir.eitaa.messenger.DispatchQueue;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MediaController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.messenger.VideoEditedInfo;
import ir.eitaa.messenger.camera.CameraController;
import ir.eitaa.messenger.camera.CameraInfo;
import ir.eitaa.messenger.camera.CameraSession;
import ir.eitaa.messenger.video.MP4Builder;
import ir.eitaa.messenger.video.Mp4Movie;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.TLRPC$InputEncryptedFile;
import ir.eitaa.tgnet.TLRPC$InputFile;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ChatActivity;
import ir.eitaa.ui.Components.AlertsCreator;
import ir.eitaa.ui.Components.VideoPlayer;
import ir.eitaa.ui.Components.voip.CellFlickerDrawable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import org.linphone.mediastream.Factory;
import org.webrtc.EglBase;

@TargetApi(18)
/* loaded from: classes3.dex */
public class InstantCameraView extends FrameLayout implements NotificationCenter.NotificationCenterDelegate {
    private float animationTranslationY;
    private AnimatorSet animatorSet;
    private ir.eitaa.messenger.camera.Size aspectRatio;
    private ChatActivity baseFragment;
    private BlurBehindDrawable blurBehindDrawable;
    private InstantViewCameraContainer cameraContainer;
    private File cameraFile;
    private volatile boolean cameraReady;
    private CameraSession cameraSession;
    private int[] cameraTexture;
    private float cameraTextureAlpha;
    private CameraGLThread cameraThread;
    private boolean cancelled;
    private int currentAccount;
    private TLRPC$InputEncryptedFile encryptedFile;
    private TLRPC$InputFile file;
    ValueAnimator finishZoomTransition;
    private boolean isFrontface;
    boolean isInPinchToZoomTouchMode;
    private boolean isMessageTransition;
    private boolean isSecretChat;
    private byte[] iv;
    private byte[] key;
    private Bitmap lastBitmap;
    private float[] mMVPMatrix;
    private float[] mSTMatrix;
    boolean maybePinchToZoomTouchMode;
    private float[] moldSTMatrix;
    private AnimatorSet muteAnimation;
    private ImageView muteImageView;
    private boolean needDrawFlickerStub;
    private int[] oldCameraTexture;
    public boolean opened;
    private Paint paint;
    private float panTranslationY;
    private View parentView;
    private ir.eitaa.messenger.camera.Size pictureSize;
    float pinchScale;
    float pinchStartDistance;
    private int pointerId1;
    private int pointerId2;
    private int[] position;
    private ir.eitaa.messenger.camera.Size previewSize;
    private float progress;
    private Timer progressTimer;
    private long recordStartTime;
    private long recordedTime;
    private boolean recording;
    private int recordingGuid;
    private RectF rect;
    private final Theme.ResourcesProvider resourcesProvider;
    private float scaleX;
    private float scaleY;
    private CameraInfo selectedCamera;
    private long size;
    private ImageView switchCameraButton;
    private FloatBuffer textureBuffer;
    private BackupImageView textureOverlayView;
    private TextureView textureView;
    private int textureViewSize;
    private boolean updateTextureViewSize;
    private FloatBuffer vertexBuffer;
    private VideoEditedInfo videoEditedInfo;
    private VideoPlayer videoPlayer;

    static /* synthetic */ float access$2216(InstantCameraView instantCameraView, float f) {
        float f2 = instantCameraView.cameraTextureAlpha + f;
        instantCameraView.cameraTextureAlpha = f2;
        return f2;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public InstantCameraView(Context context, ChatActivity parentFragment, Theme.ResourcesProvider resourcesProvider) {
        super(context);
        this.currentAccount = UserConfig.selectedAccount;
        int i = 1;
        this.isFrontface = true;
        this.position = new int[2];
        this.cameraTexture = new int[1];
        this.oldCameraTexture = new int[1];
        this.cameraTextureAlpha = 1.0f;
        this.aspectRatio = SharedConfig.roundCamera16to9 ? new ir.eitaa.messenger.camera.Size(16, 9) : new ir.eitaa.messenger.camera.Size(4, 3);
        this.mMVPMatrix = new float[16];
        this.mSTMatrix = new float[16];
        this.moldSTMatrix = new float[16];
        this.resourcesProvider = resourcesProvider;
        this.parentView = parentFragment.getFragmentView();
        setWillNotDraw(false);
        this.baseFragment = parentFragment;
        this.recordingGuid = parentFragment.getClassGuid();
        this.isSecretChat = this.baseFragment.getCurrentEncryptedChat() != null;
        Paint paint = new Paint(i) { // from class: ir.eitaa.ui.Components.InstantCameraView.1
            @Override // android.graphics.Paint
            public void setAlpha(int a) {
                super.setAlpha(a);
                InstantCameraView.this.invalidate();
            }
        };
        this.paint = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        this.paint.setStrokeWidth(AndroidUtilities.dp(3.0f));
        this.paint.setColor(-1);
        this.rect = new RectF();
        if (Build.VERSION.SDK_INT >= 21) {
            InstantViewCameraContainer instantViewCameraContainer = new InstantViewCameraContainer(context) { // from class: ir.eitaa.ui.Components.InstantCameraView.2
                @Override // android.view.View
                public void setScaleX(float scaleX) {
                    super.setScaleX(scaleX);
                    InstantCameraView.this.invalidate();
                }

                @Override // android.view.View
                public void setAlpha(float alpha) {
                    super.setAlpha(alpha);
                    InstantCameraView.this.invalidate();
                }
            };
            this.cameraContainer = instantViewCameraContainer;
            instantViewCameraContainer.setOutlineProvider(new ViewOutlineProvider() { // from class: ir.eitaa.ui.Components.InstantCameraView.3
                @Override // android.view.ViewOutlineProvider
                @TargetApi(21)
                public void getOutline(View view, Outline outline) {
                    outline.setOval(0, 0, InstantCameraView.this.textureViewSize, InstantCameraView.this.textureViewSize);
                }
            });
            this.cameraContainer.setClipToOutline(true);
            this.cameraContainer.setWillNotDraw(false);
        } else {
            final Path path = new Path();
            final Paint paint2 = new Paint(1);
            paint2.setColor(-16777216);
            paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            InstantViewCameraContainer instantViewCameraContainer2 = new InstantViewCameraContainer(context) { // from class: ir.eitaa.ui.Components.InstantCameraView.4
                @Override // android.view.View
                public void setScaleX(float scaleX) {
                    super.setScaleX(scaleX);
                    InstantCameraView.this.invalidate();
                }

                @Override // android.view.View
                protected void onSizeChanged(int w, int h, int oldw, int oldh) {
                    super.onSizeChanged(w, h, oldw, oldh);
                    path.reset();
                    float f = w / 2;
                    path.addCircle(f, h / 2, f, Path.Direction.CW);
                    path.toggleInverseFillType();
                }

                @Override // ir.eitaa.ui.Components.InstantCameraView.InstantViewCameraContainer, android.view.ViewGroup, android.view.View
                protected void dispatchDraw(Canvas canvas) {
                    try {
                        super.dispatchDraw(canvas);
                        canvas.drawPath(path, paint2);
                    } catch (Exception unused) {
                    }
                }
            };
            this.cameraContainer = instantViewCameraContainer2;
            instantViewCameraContainer2.setWillNotDraw(false);
            this.cameraContainer.setLayerType(2, null);
        }
        View view = this.cameraContainer;
        int i2 = AndroidUtilities.roundPlayingMessageSize;
        addView(view, new FrameLayout.LayoutParams(i2, i2, 17));
        ImageView imageView = new ImageView(context);
        this.switchCameraButton = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        this.switchCameraButton.setContentDescription(LocaleController.getString("AccDescrSwitchCamera", R.string.AccDescrSwitchCamera));
        addView(this.switchCameraButton, LayoutHelper.createFrame(62, 62.0f, 83, 8.0f, 0.0f, 0.0f, 0.0f));
        this.switchCameraButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$InstantCameraView$HVvPFdlxQ6INqJJiANvSmnhU_e4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) throws InterruptedException {
                this.f$0.lambda$new$0$InstantCameraView(view2);
            }
        });
        ImageView imageView2 = new ImageView(context);
        this.muteImageView = imageView2;
        imageView2.setScaleType(ImageView.ScaleType.CENTER);
        this.muteImageView.setImageResource(R.drawable.video_mute);
        this.muteImageView.setAlpha(0.0f);
        addView(this.muteImageView, LayoutHelper.createFrame(48, 48, 17));
        final Paint paint3 = new Paint(1);
        paint3.setColor(ColorUtils.setAlphaComponent(-16777216, 40));
        BackupImageView backupImageView = new BackupImageView(getContext()) { // from class: ir.eitaa.ui.Components.InstantCameraView.6
            CellFlickerDrawable flickerDrawable = new CellFlickerDrawable();

            @Override // ir.eitaa.ui.Components.BackupImageView, android.view.View
            protected void onDraw(Canvas canvas) {
                super.onDraw(canvas);
                if (InstantCameraView.this.needDrawFlickerStub) {
                    this.flickerDrawable.setParentWidth(InstantCameraView.this.textureViewSize);
                    RectF rectF = AndroidUtilities.rectTmp;
                    rectF.set(0.0f, 0.0f, InstantCameraView.this.textureViewSize, InstantCameraView.this.textureViewSize);
                    float fWidth = rectF.width() / 2.0f;
                    canvas.drawRoundRect(rectF, fWidth, fWidth, paint3);
                    rectF.inset(AndroidUtilities.dp(1.0f), AndroidUtilities.dp(1.0f));
                    this.flickerDrawable.draw(canvas, rectF, fWidth);
                    invalidate();
                }
            }
        };
        this.textureOverlayView = backupImageView;
        int i3 = AndroidUtilities.roundPlayingMessageSize;
        addView(backupImageView, new FrameLayout.LayoutParams(i3, i3, 17));
        setVisibility(4);
        this.blurBehindDrawable = new BlurBehindDrawable(this.parentView, this, 0, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$InstantCameraView(View view) throws InterruptedException {
        CameraSession cameraSession;
        if (!this.cameraReady || (cameraSession = this.cameraSession) == null || !cameraSession.isInitied() || this.cameraThread == null) {
            return;
        }
        switchCamera();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.switchCameraButton, (Property<ImageView, Float>) View.SCALE_X, 0.0f).setDuration(100L);
        duration.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.InstantCameraView.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                InstantCameraView.this.switchCameraButton.setImageResource(InstantCameraView.this.isFrontface ? R.drawable.camera_revert1 : R.drawable.camera_revert2);
                ObjectAnimator.ofFloat(InstantCameraView.this.switchCameraButton, (Property<ImageView, Float>) View.SCALE_X, 1.0f).setDuration(100L).start();
            }
        });
        duration.start();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i;
        if (this.updateTextureViewSize) {
            if (View.MeasureSpec.getSize(heightMeasureSpec) > View.MeasureSpec.getSize(widthMeasureSpec) * 1.3f) {
                i = AndroidUtilities.roundPlayingMessageSize;
            } else {
                i = AndroidUtilities.roundMessageSize;
            }
            if (i != this.textureViewSize) {
                this.textureViewSize = i;
                ViewGroup.LayoutParams layoutParams = this.textureOverlayView.getLayoutParams();
                ViewGroup.LayoutParams layoutParams2 = this.textureOverlayView.getLayoutParams();
                int i2 = this.textureViewSize;
                layoutParams2.height = i2;
                layoutParams.width = i2;
                ViewGroup.LayoutParams layoutParams3 = this.cameraContainer.getLayoutParams();
                ViewGroup.LayoutParams layoutParams4 = this.cameraContainer.getLayoutParams();
                int i3 = this.textureViewSize;
                layoutParams4.height = i3;
                layoutParams3.width = i3;
                ((FrameLayout.LayoutParams) this.muteImageView.getLayoutParams()).topMargin = (this.textureViewSize / 2) - AndroidUtilities.dp(24.0f);
                this.textureOverlayView.setRoundRadius(this.textureViewSize / 2);
                if (Build.VERSION.SDK_INT >= 21) {
                    this.cameraContainer.invalidateOutline();
                }
            }
            this.updateTextureViewSize = false;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    private boolean checkPointerIds(MotionEvent ev) {
        if (ev.getPointerCount() < 2) {
            return false;
        }
        if (this.pointerId1 == ev.getPointerId(0) && this.pointerId2 == ev.getPointerId(1)) {
            return true;
        }
        return this.pointerId1 == ev.getPointerId(1) && this.pointerId2 == ev.getPointerId(0);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(ev);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) throws InterruptedException {
        super.onSizeChanged(w, h, oldw, oldh);
        if (getVisibility() != 0) {
            this.animationTranslationY = getMeasuredHeight() / 2;
            updateTranslationY();
        }
        this.blurBehindDrawable.checkSizes();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.fileUploaded);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.fileUploaded);
    }

    @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        if (id == NotificationCenter.fileUploaded) {
            String str = (String) args[0];
            File file = this.cameraFile;
            if (file == null || !file.getAbsolutePath().equals(str)) {
                return;
            }
            this.file = (TLRPC$InputFile) args[1];
            this.encryptedFile = (TLRPC$InputEncryptedFile) args[2];
            this.size = ((Long) args[5]).longValue();
            if (this.encryptedFile != null) {
                this.key = (byte[]) args[3];
                this.iv = (byte[]) args[4];
            }
        }
    }

    public void destroy(boolean async, final Runnable beforeDestroyRunnable) {
        CameraSession cameraSession = this.cameraSession;
        if (cameraSession != null) {
            cameraSession.destroy();
            CameraController.getInstance().close(this.cameraSession, !async ? new CountDownLatch(1) : null, beforeDestroyRunnable);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) throws InterruptedException {
        this.blurBehindDrawable.draw(canvas);
        float x = this.cameraContainer.getX();
        float y = this.cameraContainer.getY();
        this.rect.set(x - AndroidUtilities.dp(8.0f), y - AndroidUtilities.dp(8.0f), this.cameraContainer.getMeasuredWidth() + x + AndroidUtilities.dp(8.0f), this.cameraContainer.getMeasuredHeight() + y + AndroidUtilities.dp(8.0f));
        if (this.recording) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.recordStartTime;
            this.recordedTime = jCurrentTimeMillis;
            this.progress = Math.min(1.0f, jCurrentTimeMillis / 60000.0f);
            invalidate();
        }
        if (this.progress != 0.0f) {
            canvas.save();
            canvas.scale(this.cameraContainer.getScaleX(), this.cameraContainer.getScaleY(), this.rect.centerX(), this.rect.centerY());
            canvas.drawArc(this.rect, -90.0f, this.progress * 360.0f, false, this.paint);
            canvas.restore();
        }
        if (Theme.chat_roundVideoShadow != null) {
            int iDp = ((int) x) - AndroidUtilities.dp(3.0f);
            int iDp2 = ((int) y) - AndroidUtilities.dp(2.0f);
            canvas.save();
            if (this.isMessageTransition) {
                canvas.scale(this.cameraContainer.getScaleX(), this.cameraContainer.getScaleY(), x, y);
            } else {
                float scaleX = this.cameraContainer.getScaleX();
                float scaleY = this.cameraContainer.getScaleY();
                int i = this.textureViewSize;
                canvas.scale(scaleX, scaleY, x + (i / 2.0f), y + (i / 2.0f));
            }
            Theme.chat_roundVideoShadow.setAlpha((int) (this.cameraContainer.getAlpha() * 255.0f));
            Theme.chat_roundVideoShadow.setBounds(iDp, iDp2, this.textureViewSize + iDp + AndroidUtilities.dp(6.0f), this.textureViewSize + iDp2 + AndroidUtilities.dp(6.0f));
            Theme.chat_roundVideoShadow.draw(canvas);
            canvas.restore();
        }
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        BlurBehindDrawable blurBehindDrawable;
        super.setVisibility(visibility);
        if (visibility != 0 && (blurBehindDrawable = this.blurBehindDrawable) != null) {
            blurBehindDrawable.clear();
        }
        this.switchCameraButton.setAlpha(0.0f);
        this.cameraContainer.setAlpha(0.0f);
        this.textureOverlayView.setAlpha(0.0f);
        this.muteImageView.setAlpha(0.0f);
        this.muteImageView.setScaleX(1.0f);
        this.muteImageView.setScaleY(1.0f);
        this.cameraContainer.setScaleX(0.1f);
        this.cameraContainer.setScaleY(0.1f);
        this.textureOverlayView.setScaleX(0.1f);
        this.textureOverlayView.setScaleY(0.1f);
        if (this.cameraContainer.getMeasuredWidth() != 0) {
            this.cameraContainer.setPivotX(r0.getMeasuredWidth() / 2);
            this.cameraContainer.setPivotY(r0.getMeasuredHeight() / 2);
            this.textureOverlayView.setPivotX(r0.getMeasuredWidth() / 2);
            this.textureOverlayView.setPivotY(r0.getMeasuredHeight() / 2);
        }
        try {
            if (visibility == 0) {
                ((Activity) getContext()).getWindow().addFlags(128);
            } else {
                ((Activity) getContext()).getWindow().clearFlags(128);
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void showCamera() {
        if (this.textureView != null) {
            return;
        }
        this.switchCameraButton.setImageResource(R.drawable.camera_revert1);
        this.textureOverlayView.setAlpha(1.0f);
        this.textureOverlayView.invalidate();
        if (this.lastBitmap == null) {
            try {
                this.lastBitmap = BitmapFactory.decodeFile(new File(ApplicationLoader.getFilesDirFixed(), "icthumb.jpg").getAbsolutePath());
            } catch (Throwable unused) {
            }
        }
        Bitmap bitmap = this.lastBitmap;
        if (bitmap != null) {
            this.textureOverlayView.setImageBitmap(bitmap);
        } else {
            this.textureOverlayView.setImageResource(R.drawable.icplaceholder);
        }
        this.cameraReady = false;
        this.isFrontface = true;
        this.selectedCamera = null;
        this.recordedTime = 0L;
        this.progress = 0.0f;
        this.cancelled = false;
        this.file = null;
        this.encryptedFile = null;
        this.key = null;
        this.iv = null;
        this.needDrawFlickerStub = true;
        if (initCamera()) {
            MediaController.getInstance().lambda$startAudioAgain$7(MediaController.getInstance().getPlayingMessageObject());
            this.cameraFile = new File(FileLoader.getDirectory(4), SharedConfig.getLastLocalId() + ".mp4");
            SharedConfig.saveConfig();
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("show round camera");
            }
            TextureView textureView = new TextureView(getContext());
            this.textureView = textureView;
            textureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: ir.eitaa.ui.Components.InstantCameraView.7
                @Override // android.view.TextureView.SurfaceTextureListener
                public void onSurfaceTextureSizeChanged(SurfaceTexture surface, final int width, final int height) {
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public void onSurfaceTextureUpdated(SurfaceTexture surface) {
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
                    if (BuildVars.LOGS_ENABLED) {
                        FileLog.d("camera surface available");
                    }
                    if (InstantCameraView.this.cameraThread != null || surface == null || InstantCameraView.this.cancelled) {
                        return;
                    }
                    if (BuildVars.LOGS_ENABLED) {
                        FileLog.d("start create thread");
                    }
                    InstantCameraView.this.cameraThread = InstantCameraView.this.new CameraGLThread(surface, width, height);
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) throws InterruptedException {
                    if (InstantCameraView.this.cameraThread != null) {
                        InstantCameraView.this.cameraThread.shutdown(0);
                        InstantCameraView.this.cameraThread = null;
                    }
                    if (InstantCameraView.this.cameraSession == null) {
                        return true;
                    }
                    CameraController.getInstance().close(InstantCameraView.this.cameraSession, null, null);
                    return true;
                }
            });
            this.cameraContainer.addView(this.textureView, LayoutHelper.createFrame(-1, -1.0f));
            this.updateTextureViewSize = true;
            setVisibility(0);
            startAnimation(true);
            MediaController.getInstance().requestAudioFocus(true);
        }
    }

    public InstantViewCameraContainer getCameraContainer() {
        return this.cameraContainer;
    }

    public void startAnimation(boolean open) {
        AnimatorSet animatorSet = this.animatorSet;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
            this.animatorSet.cancel();
        }
        PipRoundVideoView pipRoundVideoView = PipRoundVideoView.getInstance();
        if (pipRoundVideoView != null) {
            pipRoundVideoView.showTemporary(!open);
        }
        if (open && !this.opened) {
            this.cameraContainer.setTranslationX(0.0f);
            this.textureOverlayView.setTranslationX(0.0f);
            this.animationTranslationY = getMeasuredHeight() / 2.0f;
            updateTranslationY();
        }
        this.opened = open;
        View view = this.parentView;
        if (view != null) {
            view.invalidate();
        }
        this.blurBehindDrawable.show(open);
        this.animatorSet = new AnimatorSet();
        float fDp = (open || this.recordedTime <= 300) ? 0.0f : AndroidUtilities.dp(24.0f) - (getMeasuredWidth() / 2.0f);
        float[] fArr = new float[2];
        fArr[0] = open ? 1.0f : 0.0f;
        fArr[1] = open ? 0.0f : 1.0f;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$InstantCameraView$vyWEKyVnNRDgLshGmHD6NzShLmY
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.lambda$startAnimation$1$InstantCameraView(valueAnimator);
            }
        });
        AnimatorSet animatorSet2 = this.animatorSet;
        Animator[] animatorArr = new Animator[12];
        ImageView imageView = this.switchCameraButton;
        Property property = View.ALPHA;
        float[] fArr2 = new float[1];
        fArr2[0] = open ? 1.0f : 0.0f;
        animatorArr[0] = ObjectAnimator.ofFloat(imageView, (Property<ImageView, Float>) property, fArr2);
        animatorArr[1] = ObjectAnimator.ofFloat(this.muteImageView, (Property<ImageView, Float>) View.ALPHA, 0.0f);
        Paint paint = this.paint;
        Property<Paint, Integer> property2 = AnimationProperties.PAINT_ALPHA;
        int[] iArr = new int[1];
        iArr[0] = open ? 255 : 0;
        animatorArr[2] = ObjectAnimator.ofInt(paint, property2, iArr);
        InstantViewCameraContainer instantViewCameraContainer = this.cameraContainer;
        Property property3 = View.ALPHA;
        float[] fArr3 = new float[1];
        fArr3[0] = open ? 1.0f : 0.0f;
        animatorArr[3] = ObjectAnimator.ofFloat(instantViewCameraContainer, (Property<InstantViewCameraContainer, Float>) property3, fArr3);
        InstantViewCameraContainer instantViewCameraContainer2 = this.cameraContainer;
        Property property4 = View.SCALE_X;
        float[] fArr4 = new float[1];
        fArr4[0] = open ? 1.0f : 0.1f;
        animatorArr[4] = ObjectAnimator.ofFloat(instantViewCameraContainer2, (Property<InstantViewCameraContainer, Float>) property4, fArr4);
        InstantViewCameraContainer instantViewCameraContainer3 = this.cameraContainer;
        Property property5 = View.SCALE_Y;
        float[] fArr5 = new float[1];
        fArr5[0] = open ? 1.0f : 0.1f;
        animatorArr[5] = ObjectAnimator.ofFloat(instantViewCameraContainer3, (Property<InstantViewCameraContainer, Float>) property5, fArr5);
        animatorArr[6] = ObjectAnimator.ofFloat(this.cameraContainer, (Property<InstantViewCameraContainer, Float>) View.TRANSLATION_X, fDp);
        BackupImageView backupImageView = this.textureOverlayView;
        Property property6 = View.ALPHA;
        float[] fArr6 = new float[1];
        fArr6[0] = open ? 1.0f : 0.0f;
        animatorArr[7] = ObjectAnimator.ofFloat(backupImageView, (Property<BackupImageView, Float>) property6, fArr6);
        BackupImageView backupImageView2 = this.textureOverlayView;
        Property property7 = View.SCALE_X;
        float[] fArr7 = new float[1];
        fArr7[0] = open ? 1.0f : 0.1f;
        animatorArr[8] = ObjectAnimator.ofFloat(backupImageView2, (Property<BackupImageView, Float>) property7, fArr7);
        BackupImageView backupImageView3 = this.textureOverlayView;
        Property property8 = View.SCALE_Y;
        float[] fArr8 = new float[1];
        fArr8[0] = open ? 1.0f : 0.1f;
        animatorArr[9] = ObjectAnimator.ofFloat(backupImageView3, (Property<BackupImageView, Float>) property8, fArr8);
        animatorArr[10] = ObjectAnimator.ofFloat(this.textureOverlayView, (Property<BackupImageView, Float>) View.TRANSLATION_X, fDp);
        animatorArr[11] = valueAnimatorOfFloat;
        animatorSet2.playTogether(animatorArr);
        if (!open) {
            this.animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.InstantCameraView.8
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    if (animation.equals(InstantCameraView.this.animatorSet)) {
                        InstantCameraView.this.hideCamera(true);
                        InstantCameraView.this.setVisibility(4);
                    }
                }
            });
        } else {
            setTranslationX(0.0f);
        }
        this.animatorSet.setDuration(180L);
        this.animatorSet.setInterpolator(new DecelerateInterpolator());
        this.animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startAnimation$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$startAnimation$1$InstantCameraView(ValueAnimator valueAnimator) {
        this.animationTranslationY = (getMeasuredHeight() / 2.0f) * ((Float) valueAnimator.getAnimatedValue()).floatValue();
        updateTranslationY();
    }

    private void updateTranslationY() {
        this.textureOverlayView.setTranslationY(this.animationTranslationY + this.panTranslationY);
        this.cameraContainer.setTranslationY(this.animationTranslationY + this.panTranslationY);
    }

    public Rect getCameraRect() {
        this.cameraContainer.getLocationOnScreen(this.position);
        int[] iArr = this.position;
        return new Rect(iArr[0], iArr[1], this.cameraContainer.getWidth(), this.cameraContainer.getHeight());
    }

    public void changeVideoPreviewState(int state, float progress) {
        VideoPlayer videoPlayer = this.videoPlayer;
        if (videoPlayer == null) {
            return;
        }
        if (state == 0) {
            startProgressTimer();
            this.videoPlayer.play();
        } else if (state == 1) {
            stopProgressTimer();
            this.videoPlayer.pause();
        } else if (state == 2) {
            videoPlayer.seekTo((long) (progress * videoPlayer.getDuration()));
        }
    }

    public void send(int state, boolean notify, int scheduleDate) {
        if (this.textureView == null) {
            return;
        }
        stopProgressTimer();
        VideoPlayer videoPlayer = this.videoPlayer;
        if (videoPlayer != null) {
            videoPlayer.releasePlayer(true);
            this.videoPlayer = null;
        }
        if (state == 4) {
            if (this.videoEditedInfo.needConvert()) {
                this.file = null;
                this.encryptedFile = null;
                this.key = null;
                this.iv = null;
                VideoEditedInfo videoEditedInfo = this.videoEditedInfo;
                long j = videoEditedInfo.estimatedDuration;
                double d = j;
                long j2 = videoEditedInfo.startTime;
                if (j2 < 0) {
                    j2 = 0;
                }
                long j3 = videoEditedInfo.endTime;
                if (j3 >= 0) {
                    j = j3;
                }
                long j4 = j - j2;
                videoEditedInfo.estimatedDuration = j4;
                double d2 = this.size;
                double d3 = j4;
                Double.isNaN(d3);
                Double.isNaN(d);
                Double.isNaN(d2);
                videoEditedInfo.estimatedSize = Math.max(1L, (long) (d2 * (d3 / d)));
                VideoEditedInfo videoEditedInfo2 = this.videoEditedInfo;
                videoEditedInfo2.bitrate = MediaController.VIDEO_BITRATE_480;
                long j5 = videoEditedInfo2.startTime;
                if (j5 > 0) {
                    videoEditedInfo2.startTime = j5 * 1000;
                }
                long j6 = videoEditedInfo2.endTime;
                if (j6 > 0) {
                    videoEditedInfo2.endTime = j6 * 1000;
                }
                FileLoader.getInstance(this.currentAccount).cancelFileUpload(this.cameraFile.getAbsolutePath(), false);
            } else {
                this.videoEditedInfo.estimatedSize = Math.max(1L, this.size);
            }
            VideoEditedInfo videoEditedInfo3 = this.videoEditedInfo;
            videoEditedInfo3.file = this.file;
            videoEditedInfo3.encryptedFile = this.encryptedFile;
            videoEditedInfo3.key = this.key;
            videoEditedInfo3.iv = this.iv;
            this.baseFragment.sendMedia(new MediaController.PhotoEntry(0, 0, 0L, this.cameraFile.getAbsolutePath(), 0, true, 0, 0, 0L), this.videoEditedInfo, notify, scheduleDate, false);
            if (scheduleDate != 0) {
                startAnimation(false);
            }
            MediaController.getInstance().requestAudioFocus(false);
            return;
        }
        boolean z = this.recordedTime < 800;
        this.cancelled = z;
        this.recording = false;
        int i = z ? 4 : state == 3 ? 2 : 5;
        if (this.cameraThread != null) {
            NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.recordStopped, Integer.valueOf(this.recordingGuid), Integer.valueOf(i));
            int i2 = this.cancelled ? 0 : state == 3 ? 2 : 1;
            saveLastCameraBitmap();
            this.cameraThread.shutdown(i2);
            this.cameraThread = null;
        }
        if (this.cancelled) {
            NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.audioRecordTooShort, Integer.valueOf(this.recordingGuid), Boolean.TRUE, Integer.valueOf((int) this.recordedTime));
            startAnimation(false);
            MediaController.getInstance().requestAudioFocus(false);
        }
    }

    private void saveLastCameraBitmap() {
        Bitmap bitmap = this.textureView.getBitmap();
        if (bitmap == null || bitmap.getPixel(0, 0) == 0) {
            return;
        }
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(this.textureView.getBitmap(), 50, 50, true);
        this.lastBitmap = bitmapCreateScaledBitmap;
        if (bitmapCreateScaledBitmap != null) {
            Utilities.blurBitmap(bitmapCreateScaledBitmap, 7, 1, bitmapCreateScaledBitmap.getWidth(), this.lastBitmap.getHeight(), this.lastBitmap.getRowBytes());
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(new File(ApplicationLoader.getFilesDirFixed(), "icthumb.jpg"));
                this.lastBitmap.compress(Bitmap.CompressFormat.JPEG, 87, fileOutputStream);
                fileOutputStream.close();
            } catch (Throwable unused) {
            }
        }
    }

    public void cancel(boolean byGesture) {
        stopProgressTimer();
        VideoPlayer videoPlayer = this.videoPlayer;
        if (videoPlayer != null) {
            videoPlayer.releasePlayer(true);
            this.videoPlayer = null;
        }
        if (this.textureView == null) {
            return;
        }
        this.cancelled = true;
        this.recording = false;
        NotificationCenter notificationCenter = NotificationCenter.getInstance(this.currentAccount);
        int i = NotificationCenter.recordStopped;
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(this.recordingGuid);
        objArr[1] = Integer.valueOf(byGesture ? 0 : 6);
        notificationCenter.postNotificationName(i, objArr);
        if (this.cameraThread != null) {
            saveLastCameraBitmap();
            this.cameraThread.shutdown(0);
            this.cameraThread = null;
        }
        File file = this.cameraFile;
        if (file != null) {
            file.delete();
            this.cameraFile = null;
        }
        MediaController.getInstance().requestAudioFocus(false);
        startAnimation(false);
        this.blurBehindDrawable.show(false);
        invalidate();
    }

    public View getSwitchButtonView() {
        return this.switchCameraButton;
    }

    public View getMuteImageView() {
        return this.muteImageView;
    }

    public Paint getPaint() {
        return this.paint;
    }

    public void hideCamera(boolean async) {
        ViewGroup viewGroup;
        destroy(async, null);
        this.cameraContainer.setTranslationX(0.0f);
        this.textureOverlayView.setTranslationX(0.0f);
        this.animationTranslationY = 0.0f;
        updateTranslationY();
        MediaController.getInstance().playMessage(MediaController.getInstance().getPlayingMessageObject());
        TextureView textureView = this.textureView;
        if (textureView != null && (viewGroup = (ViewGroup) textureView.getParent()) != null) {
            viewGroup.removeView(this.textureView);
        }
        this.textureView = null;
        this.cameraContainer.setImageReceiver(null);
    }

    private void switchCamera() throws InterruptedException {
        saveLastCameraBitmap();
        Bitmap bitmap = this.lastBitmap;
        if (bitmap != null) {
            this.needDrawFlickerStub = false;
            this.textureOverlayView.setImageBitmap(bitmap);
            this.textureOverlayView.setAlpha(1.0f);
        }
        CameraSession cameraSession = this.cameraSession;
        if (cameraSession != null) {
            cameraSession.destroy();
            CameraController.getInstance().close(this.cameraSession, null, null);
            this.cameraSession = null;
        }
        this.isFrontface = !this.isFrontface;
        initCamera();
        this.cameraReady = false;
        this.cameraThread.reinitForNewCamera();
    }

    private boolean initCamera() {
        int i;
        int i2;
        ArrayList<CameraInfo> cameras = CameraController.getInstance().getCameras();
        boolean z = false;
        if (cameras == null) {
            return false;
        }
        CameraInfo cameraInfo = null;
        int i3 = 0;
        while (i3 < cameras.size()) {
            CameraInfo cameraInfo2 = cameras.get(i3);
            if (!cameraInfo2.isFrontface()) {
                cameraInfo = cameraInfo2;
            }
            if ((this.isFrontface && cameraInfo2.isFrontface()) || (!this.isFrontface && !cameraInfo2.isFrontface())) {
                this.selectedCamera = cameraInfo2;
                break;
            }
            i3++;
            cameraInfo = cameraInfo2;
        }
        if (this.selectedCamera == null) {
            this.selectedCamera = cameraInfo;
        }
        CameraInfo cameraInfo3 = this.selectedCamera;
        if (cameraInfo3 == null) {
            return false;
        }
        ArrayList<ir.eitaa.messenger.camera.Size> previewSizes = cameraInfo3.getPreviewSizes();
        ArrayList<ir.eitaa.messenger.camera.Size> pictureSizes = this.selectedCamera.getPictureSizes();
        this.previewSize = CameraController.chooseOptimalSize(previewSizes, 480, 270, this.aspectRatio);
        ir.eitaa.messenger.camera.Size sizeChooseOptimalSize = CameraController.chooseOptimalSize(pictureSizes, 480, 270, this.aspectRatio);
        this.pictureSize = sizeChooseOptimalSize;
        if (this.previewSize.mWidth != sizeChooseOptimalSize.mWidth) {
            for (int size = previewSizes.size() - 1; size >= 0; size--) {
                ir.eitaa.messenger.camera.Size size2 = previewSizes.get(size);
                int size3 = pictureSizes.size() - 1;
                while (true) {
                    if (size3 < 0) {
                        break;
                    }
                    ir.eitaa.messenger.camera.Size size4 = pictureSizes.get(size3);
                    int i4 = size2.mWidth;
                    ir.eitaa.messenger.camera.Size size5 = this.pictureSize;
                    if (i4 >= size5.mWidth && (i2 = size2.mHeight) >= size5.mHeight && i4 == size4.mWidth && i2 == size4.mHeight) {
                        this.previewSize = size2;
                        this.pictureSize = size4;
                        z = true;
                        break;
                    }
                    size3--;
                }
                if (z) {
                    break;
                }
            }
            if (!z) {
                for (int size6 = previewSizes.size() - 1; size6 >= 0; size6--) {
                    ir.eitaa.messenger.camera.Size size7 = previewSizes.get(size6);
                    int size8 = pictureSizes.size() - 1;
                    while (true) {
                        if (size8 < 0) {
                            break;
                        }
                        ir.eitaa.messenger.camera.Size size9 = pictureSizes.get(size8);
                        int i5 = size7.mWidth;
                        if (i5 >= 360 && (i = size7.mHeight) >= 360 && i5 == size9.mWidth && i == size9.mHeight) {
                            this.previewSize = size7;
                            this.pictureSize = size9;
                            z = true;
                            break;
                        }
                        size8--;
                    }
                    if (z) {
                        break;
                    }
                }
            }
        }
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("preview w = " + this.previewSize.mWidth + " h = " + this.previewSize.mHeight);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createCamera(final SurfaceTexture surfaceTexture) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$InstantCameraView$MpaklFj9UgMIb3H5riFe3--ku_M
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                this.f$0.lambda$createCamera$4$InstantCameraView(surfaceTexture);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createCamera$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createCamera$4$InstantCameraView(SurfaceTexture surfaceTexture) throws InterruptedException {
        if (this.cameraThread == null) {
            return;
        }
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("create camera session");
        }
        surfaceTexture.setDefaultBufferSize(this.previewSize.getWidth(), this.previewSize.getHeight());
        CameraSession cameraSession = new CameraSession(this.selectedCamera, this.previewSize, this.pictureSize, Factory.DEVICE_HAS_CRAPPY_OPENSLES, true);
        this.cameraSession = cameraSession;
        this.cameraThread.setCurrentSession(cameraSession);
        CameraController.getInstance().openRound(this.cameraSession, surfaceTexture, new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$InstantCameraView$M7-DQzvgBlyTziuq0tez-jmKOKo
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createCamera$2$InstantCameraView();
            }
        }, new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$InstantCameraView$S_ducYPkganfm719CpwZlrj5Mhs
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                this.f$0.lambda$createCamera$3$InstantCameraView();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createCamera$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createCamera$2$InstantCameraView() {
        if (this.cameraSession != null) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("camera initied");
            }
            this.cameraSession.setInitied();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createCamera$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createCamera$3$InstantCameraView() throws InterruptedException {
        this.cameraThread.setCurrentSession(this.cameraSession);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int loadShader(int type, String shaderCode) {
        int iGlCreateShader = GLES20.glCreateShader(type);
        GLES20.glShaderSource(iGlCreateShader, shaderCode);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return iGlCreateShader;
        }
        if (BuildVars.LOGS_ENABLED) {
            FileLog.e(GLES20.glGetShaderInfoLog(iGlCreateShader));
        }
        GLES20.glDeleteShader(iGlCreateShader);
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startProgressTimer() {
        Timer timer = this.progressTimer;
        if (timer != null) {
            try {
                timer.cancel();
                this.progressTimer = null;
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
        Timer timer2 = new Timer();
        this.progressTimer = timer2;
        timer2.schedule(new AnonymousClass9(), 0L, 17L);
    }

    /* renamed from: ir.eitaa.ui.Components.InstantCameraView$9, reason: invalid class name */
    class AnonymousClass9 extends TimerTask {
        AnonymousClass9() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$InstantCameraView$9$kHB830K2HET_jbPrhgycbgw_580
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$run$0$InstantCameraView$9();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$run$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$run$0$InstantCameraView$9() {
            try {
                if (InstantCameraView.this.videoPlayer == null || InstantCameraView.this.videoEditedInfo == null) {
                    return;
                }
                if (InstantCameraView.this.videoEditedInfo.endTime <= 0 || InstantCameraView.this.videoPlayer.getCurrentPosition() < InstantCameraView.this.videoEditedInfo.endTime) {
                    return;
                }
                InstantCameraView.this.videoPlayer.seekTo(InstantCameraView.this.videoEditedInfo.startTime > 0 ? InstantCameraView.this.videoEditedInfo.startTime : 0L);
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
    }

    private void stopProgressTimer() {
        Timer timer = this.progressTimer;
        if (timer != null) {
            try {
                timer.cancel();
                this.progressTimer = null;
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
    }

    public boolean blurFullyDrawing() {
        BlurBehindDrawable blurBehindDrawable = this.blurBehindDrawable;
        return blurBehindDrawable != null && blurBehindDrawable.isFullyDrawing() && this.opened;
    }

    public void invalidateBlur() {
        BlurBehindDrawable blurBehindDrawable = this.blurBehindDrawable;
        if (blurBehindDrawable != null) {
            blurBehindDrawable.invalidate();
        }
    }

    public void cancelBlur() {
        this.blurBehindDrawable.show(false);
        invalidate();
    }

    public void onPanTranslationUpdate(float y) {
        this.panTranslationY = y / 2.0f;
        updateTranslationY();
        this.blurBehindDrawable.onPanTranslationUpdate(y);
    }

    public TextureView getTextureView() {
        return this.textureView;
    }

    public void setIsMessageTransition(boolean isMessageTransition) {
        this.isMessageTransition = isMessageTransition;
    }

    public class CameraGLThread extends DispatchQueue {
        private final int DO_REINIT_MESSAGE;
        private final int DO_RENDER_MESSAGE;
        private final int DO_SETSESSION_MESSAGE;
        private final int DO_SHUTDOWN_MESSAGE;
        private Integer cameraId;
        private SurfaceTexture cameraSurface;
        private CameraSession currentSession;
        private int drawProgram;
        private EGL10 egl10;
        private EGLContext eglContext;
        private EGLDisplay eglDisplay;
        private EGLSurface eglSurface;
        private boolean initied;
        private int positionHandle;
        private boolean recording;
        private SurfaceTexture surfaceTexture;
        private int textureHandle;
        private int textureMatrixHandle;
        private int vertexMatrixHandle;
        private VideoRecorder videoEncoder;

        public CameraGLThread(SurfaceTexture surface, int surfaceWidth, int surfaceHeight) {
            super("CameraGLThread");
            this.DO_RENDER_MESSAGE = 0;
            this.DO_SHUTDOWN_MESSAGE = 1;
            this.DO_REINIT_MESSAGE = 2;
            this.DO_SETSESSION_MESSAGE = 3;
            this.cameraId = 0;
            this.surfaceTexture = surface;
            int width = InstantCameraView.this.previewSize.getWidth();
            float f = surfaceWidth;
            float fMin = f / Math.min(width, r0);
            int i = (int) (width * fMin);
            int height = (int) (InstantCameraView.this.previewSize.getHeight() * fMin);
            if (i > height) {
                InstantCameraView.this.scaleX = 1.0f;
                InstantCameraView.this.scaleY = i / surfaceHeight;
            } else {
                InstantCameraView.this.scaleX = height / f;
                InstantCameraView.this.scaleY = 1.0f;
            }
        }

        private boolean initGL() {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("start init gl");
            }
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.egl10 = egl10;
            EGLDisplay eGLDisplayEglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.eglDisplay = eGLDisplayEglGetDisplay;
            if (eGLDisplayEglGetDisplay == EGL10.EGL_NO_DISPLAY) {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.e("eglGetDisplay failed " + GLUtils.getEGLErrorString(this.egl10.eglGetError()));
                }
                finish();
                return false;
            }
            if (!this.egl10.eglInitialize(eGLDisplayEglGetDisplay, new int[2])) {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.e("eglInitialize failed " + GLUtils.getEGLErrorString(this.egl10.eglGetError()));
                }
                finish();
                return false;
            }
            int[] iArr = new int[1];
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (!this.egl10.eglChooseConfig(this.eglDisplay, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 0, 12325, 0, 12326, 0, 12344}, eGLConfigArr, 1, iArr)) {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.e("eglChooseConfig failed " + GLUtils.getEGLErrorString(this.egl10.eglGetError()));
                }
                finish();
                return false;
            }
            if (iArr[0] > 0) {
                EGLConfig eGLConfig = eGLConfigArr[0];
                EGLContext eGLContextEglCreateContext = this.egl10.eglCreateContext(this.eglDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
                this.eglContext = eGLContextEglCreateContext;
                if (eGLContextEglCreateContext == null) {
                    if (BuildVars.LOGS_ENABLED) {
                        FileLog.e("eglCreateContext failed " + GLUtils.getEGLErrorString(this.egl10.eglGetError()));
                    }
                    finish();
                    return false;
                }
                SurfaceTexture surfaceTexture = this.surfaceTexture;
                if (surfaceTexture instanceof SurfaceTexture) {
                    EGLSurface eGLSurfaceEglCreateWindowSurface = this.egl10.eglCreateWindowSurface(this.eglDisplay, eGLConfig, surfaceTexture, null);
                    this.eglSurface = eGLSurfaceEglCreateWindowSurface;
                    if (eGLSurfaceEglCreateWindowSurface == null || eGLSurfaceEglCreateWindowSurface == EGL10.EGL_NO_SURFACE) {
                        if (BuildVars.LOGS_ENABLED) {
                            FileLog.e("createWindowSurface failed " + GLUtils.getEGLErrorString(this.egl10.eglGetError()));
                        }
                        finish();
                        return false;
                    }
                    if (!this.egl10.eglMakeCurrent(this.eglDisplay, eGLSurfaceEglCreateWindowSurface, eGLSurfaceEglCreateWindowSurface, this.eglContext)) {
                        if (BuildVars.LOGS_ENABLED) {
                            FileLog.e("eglMakeCurrent failed " + GLUtils.getEGLErrorString(this.egl10.eglGetError()));
                        }
                        finish();
                        return false;
                    }
                    this.eglContext.getGL();
                    float f = (1.0f / InstantCameraView.this.scaleX) / 2.0f;
                    float f2 = (1.0f / InstantCameraView.this.scaleY) / 2.0f;
                    float f3 = 0.5f - f;
                    float f4 = 0.5f - f2;
                    float f5 = f + 0.5f;
                    float f6 = f2 + 0.5f;
                    this.videoEncoder = new VideoRecorder();
                    InstantCameraView.this.vertexBuffer = ByteBuffer.allocateDirect(48).order(ByteOrder.nativeOrder()).asFloatBuffer();
                    InstantCameraView.this.vertexBuffer.put(new float[]{-1.0f, -1.0f, 0.0f, 1.0f, -1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f}).position(0);
                    InstantCameraView.this.textureBuffer = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
                    InstantCameraView.this.textureBuffer.put(new float[]{f3, f4, f5, f4, f3, f6, f5, f6}).position(0);
                    Matrix.setIdentityM(InstantCameraView.this.mSTMatrix, 0);
                    int iLoadShader = InstantCameraView.this.loadShader(35633, "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n   gl_Position = uMVPMatrix * aPosition;\n   vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n");
                    int iLoadShader2 = InstantCameraView.this.loadShader(35632, "#extension GL_OES_EGL_image_external : require\nprecision lowp float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n   gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
                    if (iLoadShader != 0 && iLoadShader2 != 0) {
                        int iGlCreateProgram = GLES20.glCreateProgram();
                        this.drawProgram = iGlCreateProgram;
                        GLES20.glAttachShader(iGlCreateProgram, iLoadShader);
                        GLES20.glAttachShader(this.drawProgram, iLoadShader2);
                        GLES20.glLinkProgram(this.drawProgram);
                        int[] iArr2 = new int[1];
                        GLES20.glGetProgramiv(this.drawProgram, 35714, iArr2, 0);
                        if (iArr2[0] == 0) {
                            if (BuildVars.LOGS_ENABLED) {
                                FileLog.e("failed link shader");
                            }
                            GLES20.glDeleteProgram(this.drawProgram);
                            this.drawProgram = 0;
                        } else {
                            this.positionHandle = GLES20.glGetAttribLocation(this.drawProgram, "aPosition");
                            this.textureHandle = GLES20.glGetAttribLocation(this.drawProgram, "aTextureCoord");
                            this.vertexMatrixHandle = GLES20.glGetUniformLocation(this.drawProgram, "uMVPMatrix");
                            this.textureMatrixHandle = GLES20.glGetUniformLocation(this.drawProgram, "uSTMatrix");
                        }
                        GLES20.glGenTextures(1, InstantCameraView.this.cameraTexture, 0);
                        GLES20.glBindTexture(36197, InstantCameraView.this.cameraTexture[0]);
                        GLES20.glTexParameteri(36197, 10241, 9729);
                        GLES20.glTexParameteri(36197, 10240, 9729);
                        GLES20.glTexParameteri(36197, 10242, 33071);
                        GLES20.glTexParameteri(36197, 10243, 33071);
                        Matrix.setIdentityM(InstantCameraView.this.mMVPMatrix, 0);
                        SurfaceTexture surfaceTexture2 = new SurfaceTexture(InstantCameraView.this.cameraTexture[0]);
                        this.cameraSurface = surfaceTexture2;
                        surfaceTexture2.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$InstantCameraView$CameraGLThread$qaOh0pdThEmjzUzC9xR4GOZQpEs
                            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
                            public final void onFrameAvailable(SurfaceTexture surfaceTexture3) throws InterruptedException {
                                this.f$0.lambda$initGL$0$InstantCameraView$CameraGLThread(surfaceTexture3);
                            }
                        });
                        InstantCameraView.this.createCamera(this.cameraSurface);
                        if (BuildVars.LOGS_ENABLED) {
                            FileLog.e("gl initied");
                        }
                        return true;
                    }
                    if (BuildVars.LOGS_ENABLED) {
                        FileLog.e("failed creating shader");
                    }
                    finish();
                    return false;
                }
                finish();
                return false;
            }
            if (BuildVars.LOGS_ENABLED) {
                FileLog.e("eglConfig not initialized");
            }
            finish();
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$initGL$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$initGL$0$InstantCameraView$CameraGLThread(SurfaceTexture surfaceTexture) throws InterruptedException {
            requestRender();
        }

        public void reinitForNewCamera() throws InterruptedException {
            Handler handler = InstantCameraView.this.getHandler();
            if (handler != null) {
                sendMessage(handler.obtainMessage(2), 0);
            }
        }

        public void finish() {
            if (this.eglSurface != null) {
                EGL10 egl10 = this.egl10;
                EGLDisplay eGLDisplay = this.eglDisplay;
                EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
                egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
                this.egl10.eglDestroySurface(this.eglDisplay, this.eglSurface);
                this.eglSurface = null;
            }
            EGLContext eGLContext = this.eglContext;
            if (eGLContext != null) {
                this.egl10.eglDestroyContext(this.eglDisplay, eGLContext);
                this.eglContext = null;
            }
            EGLDisplay eGLDisplay2 = this.eglDisplay;
            if (eGLDisplay2 != null) {
                this.egl10.eglTerminate(eGLDisplay2);
                this.eglDisplay = null;
            }
        }

        public void setCurrentSession(CameraSession session) throws InterruptedException {
            Handler handler = InstantCameraView.this.getHandler();
            if (handler != null) {
                sendMessage(handler.obtainMessage(3, session), 0);
            }
        }

        private void onDraw(Integer cameraId) throws InterruptedException {
            if (this.initied) {
                if (!this.eglContext.equals(this.egl10.eglGetCurrentContext()) || !this.eglSurface.equals(this.egl10.eglGetCurrentSurface(12377))) {
                    EGL10 egl10 = this.egl10;
                    EGLDisplay eGLDisplay = this.eglDisplay;
                    EGLSurface eGLSurface = this.eglSurface;
                    if (!egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.eglContext)) {
                        if (BuildVars.LOGS_ENABLED) {
                            FileLog.e("eglMakeCurrent failed " + GLUtils.getEGLErrorString(this.egl10.eglGetError()));
                            return;
                        }
                        return;
                    }
                }
                this.cameraSurface.updateTexImage();
                if (!this.recording) {
                    this.videoEncoder.startRecording(InstantCameraView.this.cameraFile, EGL14.eglGetCurrentContext());
                    this.recording = true;
                    int currentOrientation = this.currentSession.getCurrentOrientation();
                    if (currentOrientation == 90 || currentOrientation == 270) {
                        float f = InstantCameraView.this.scaleX;
                        InstantCameraView instantCameraView = InstantCameraView.this;
                        instantCameraView.scaleX = instantCameraView.scaleY;
                        InstantCameraView.this.scaleY = f;
                    }
                }
                this.videoEncoder.frameAvailable(this.cameraSurface, cameraId, System.nanoTime());
                this.cameraSurface.getTransformMatrix(InstantCameraView.this.mSTMatrix);
                GLES20.glUseProgram(this.drawProgram);
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(36197, InstantCameraView.this.cameraTexture[0]);
                GLES20.glVertexAttribPointer(this.positionHandle, 3, 5126, false, 12, (Buffer) InstantCameraView.this.vertexBuffer);
                GLES20.glEnableVertexAttribArray(this.positionHandle);
                GLES20.glVertexAttribPointer(this.textureHandle, 2, 5126, false, 8, (Buffer) InstantCameraView.this.textureBuffer);
                GLES20.glEnableVertexAttribArray(this.textureHandle);
                GLES20.glUniformMatrix4fv(this.textureMatrixHandle, 1, false, InstantCameraView.this.mSTMatrix, 0);
                GLES20.glUniformMatrix4fv(this.vertexMatrixHandle, 1, false, InstantCameraView.this.mMVPMatrix, 0);
                GLES20.glDrawArrays(5, 0, 4);
                GLES20.glDisableVertexAttribArray(this.positionHandle);
                GLES20.glDisableVertexAttribArray(this.textureHandle);
                GLES20.glBindTexture(36197, 0);
                GLES20.glUseProgram(0);
                this.egl10.eglSwapBuffers(this.eglDisplay, this.eglSurface);
            }
        }

        @Override // ir.eitaa.messenger.DispatchQueue, java.lang.Thread, java.lang.Runnable
        public void run() {
            this.initied = initGL();
            super.run();
        }

        @Override // ir.eitaa.messenger.DispatchQueue
        public void handleMessage(Message inputMessage) throws InterruptedException {
            int i = inputMessage.what;
            if (i == 0) {
                onDraw((Integer) inputMessage.obj);
                return;
            }
            if (i == 1) {
                finish();
                if (this.recording) {
                    this.videoEncoder.stopRecording(inputMessage.arg1);
                }
                Looper looperMyLooper = Looper.myLooper();
                if (looperMyLooper != null) {
                    looperMyLooper.quit();
                    return;
                }
                return;
            }
            if (i != 2) {
                if (i != 3) {
                    return;
                }
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("set gl rednderer session");
                }
                CameraSession cameraSession = (CameraSession) inputMessage.obj;
                CameraSession cameraSession2 = this.currentSession;
                if (cameraSession2 == cameraSession) {
                    int worldAngle = cameraSession2.getWorldAngle();
                    Matrix.setIdentityM(InstantCameraView.this.mMVPMatrix, 0);
                    if (worldAngle != 0) {
                        Matrix.rotateM(InstantCameraView.this.mMVPMatrix, 0, worldAngle, 0.0f, 0.0f, 1.0f);
                        return;
                    }
                    return;
                }
                this.currentSession = cameraSession;
                return;
            }
            EGL10 egl10 = this.egl10;
            EGLDisplay eGLDisplay = this.eglDisplay;
            EGLSurface eGLSurface = this.eglSurface;
            if (!egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.eglContext)) {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("eglMakeCurrent failed " + GLUtils.getEGLErrorString(this.egl10.eglGetError()));
                    return;
                }
                return;
            }
            SurfaceTexture surfaceTexture = this.cameraSurface;
            if (surfaceTexture != null) {
                surfaceTexture.getTransformMatrix(InstantCameraView.this.moldSTMatrix);
                this.cameraSurface.setOnFrameAvailableListener(null);
                this.cameraSurface.release();
                InstantCameraView.this.oldCameraTexture[0] = InstantCameraView.this.cameraTexture[0];
                InstantCameraView.this.cameraTextureAlpha = 0.0f;
                InstantCameraView.this.cameraTexture[0] = 0;
            }
            this.cameraId = Integer.valueOf(this.cameraId.intValue() + 1);
            InstantCameraView.this.cameraReady = false;
            GLES20.glGenTextures(1, InstantCameraView.this.cameraTexture, 0);
            GLES20.glBindTexture(36197, InstantCameraView.this.cameraTexture[0]);
            GLES20.glTexParameteri(36197, 10241, 9729);
            GLES20.glTexParameteri(36197, 10240, 9729);
            GLES20.glTexParameteri(36197, 10242, 33071);
            GLES20.glTexParameteri(36197, 10243, 33071);
            SurfaceTexture surfaceTexture2 = new SurfaceTexture(InstantCameraView.this.cameraTexture[0]);
            this.cameraSurface = surfaceTexture2;
            surfaceTexture2.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$InstantCameraView$CameraGLThread$4ZNqIR-unjI171P9rZ8KO7mDqbQ
                @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
                public final void onFrameAvailable(SurfaceTexture surfaceTexture3) throws InterruptedException {
                    this.f$0.lambda$handleMessage$1$InstantCameraView$CameraGLThread(surfaceTexture3);
                }
            });
            InstantCameraView.this.createCamera(this.cameraSurface);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$handleMessage$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$handleMessage$1$InstantCameraView$CameraGLThread(SurfaceTexture surfaceTexture) throws InterruptedException {
            requestRender();
        }

        public void shutdown(int send) throws InterruptedException {
            Handler handler = InstantCameraView.this.getHandler();
            if (handler != null) {
                sendMessage(handler.obtainMessage(1, send, 0), 0);
            }
        }

        public void requestRender() throws InterruptedException {
            Handler handler = InstantCameraView.this.getHandler();
            if (handler != null) {
                sendMessage(handler.obtainMessage(0, this.cameraId), 0);
            }
        }
    }

    private static class EncoderHandler extends Handler {
        private WeakReference<VideoRecorder> mWeakEncoder;

        public EncoderHandler(VideoRecorder encoder) {
            this.mWeakEncoder = new WeakReference<>(encoder);
        }

        @Override // android.os.Handler
        public void handleMessage(Message inputMessage) throws InterruptedException {
            int i = inputMessage.what;
            VideoRecorder videoRecorder = this.mWeakEncoder.get();
            if (videoRecorder == null) {
                return;
            }
            if (i == 0) {
                try {
                    if (BuildVars.LOGS_ENABLED) {
                        FileLog.e("start encoder");
                    }
                    videoRecorder.prepareEncoder();
                    return;
                } catch (Exception e) {
                    FileLog.e(e);
                    videoRecorder.handleStopRecording(0);
                    Looper.myLooper().quit();
                    return;
                }
            }
            if (i == 1) {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.e("stop encoder");
                }
                videoRecorder.handleStopRecording(inputMessage.arg1);
            } else if (i == 2) {
                videoRecorder.handleVideoFrameAvailable((inputMessage.arg1 << 32) | (inputMessage.arg2 & 4294967295L), (Integer) inputMessage.obj);
            } else {
                if (i != 3) {
                    return;
                }
                videoRecorder.handleAudioFrameAvailable((AudioBufferInfo) inputMessage.obj);
            }
        }

        public void exit() {
            Looper.myLooper().quit();
        }
    }

    public static class AudioBufferInfo {
        public boolean last;
        public int lastWroteBuffer;
        public int results;
        public ByteBuffer[] buffer = new ByteBuffer[10];
        public long[] offset = new long[10];
        public int[] read = new int[10];

        public AudioBufferInfo() {
            for (int i = 0; i < 10; i++) {
                this.buffer[i] = ByteBuffer.allocateDirect(Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS);
                this.buffer[i].order(ByteOrder.nativeOrder());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class VideoRecorder implements Runnable {
        private int alphaHandle;
        private MediaCodec.BufferInfo audioBufferInfo;
        private MediaCodec audioEncoder;
        private long audioFirst;
        private AudioRecord audioRecorder;
        private long audioStartTime;
        private boolean audioStopedByTime;
        private int audioTrackIndex;
        private boolean blendEnabled;
        private ArrayBlockingQueue<AudioBufferInfo> buffers;
        private ArrayList<AudioBufferInfo> buffersToWrite;
        private long currentTimestamp;
        private long desyncTime;
        private int drawProgram;
        private android.opengl.EGLConfig eglConfig;
        private android.opengl.EGLContext eglContext;
        private android.opengl.EGLDisplay eglDisplay;
        private android.opengl.EGLSurface eglSurface;
        private boolean firstEncode;
        private int frameCount;
        private DispatchQueue generateKeyframeThumbsQueue;
        private volatile EncoderHandler handler;
        private ArrayList<Bitmap> keyframeThumbs;
        private Integer lastCameraId;
        private long lastCommitedFrameTime;
        private long lastTimestamp;
        private MP4Builder mediaMuxer;
        private int positionHandle;
        private int prependHeaderSize;
        private boolean ready;
        private Runnable recorderRunnable;
        private volatile boolean running;
        private int scaleXHandle;
        private int scaleYHandle;
        private volatile int sendWhenDone;
        private android.opengl.EGLContext sharedEglContext;
        private boolean skippedFirst;
        private long skippedTime;
        private Surface surface;
        private final Object sync;
        private int textureHandle;
        private int textureMatrixHandle;
        private int vertexMatrixHandle;
        private int videoBitrate;
        private MediaCodec.BufferInfo videoBufferInfo;
        private boolean videoConvertFirstWrite;
        private MediaCodec videoEncoder;
        private File videoFile;
        private long videoFirst;
        private int videoHeight;
        private long videoLast;
        private int videoTrackIndex;
        private int videoWidth;
        private int zeroTimeStamps;

        private VideoRecorder() {
            this.videoConvertFirstWrite = true;
            this.eglDisplay = EGL14.EGL_NO_DISPLAY;
            this.eglContext = EGL14.EGL_NO_CONTEXT;
            this.eglSurface = EGL14.EGL_NO_SURFACE;
            this.buffersToWrite = new ArrayList<>();
            this.videoTrackIndex = -5;
            this.audioTrackIndex = -5;
            this.audioStartTime = -1L;
            this.currentTimestamp = 0L;
            this.lastTimestamp = -1L;
            this.sync = new Object();
            this.videoFirst = -1L;
            this.audioFirst = -1L;
            this.lastCameraId = 0;
            this.buffers = new ArrayBlockingQueue<>(10);
            this.keyframeThumbs = new ArrayList<>();
            this.recorderRunnable = new AnonymousClass1();
        }

        /* renamed from: ir.eitaa.ui.Components.InstantCameraView$VideoRecorder$1, reason: invalid class name */
        class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            /* JADX WARN: Code restructure failed: missing block: B:13:0x002f, code lost:
            
                if (r16.this$1.sendWhenDone == 0) goto L67;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void run() throws java.lang.IllegalStateException, java.lang.InterruptedException {
                /*
                    Method dump skipped, instructions count: 324
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.InstantCameraView.VideoRecorder.AnonymousClass1.run():void");
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: lambda$run$0, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void lambda$run$0$InstantCameraView$VideoRecorder$1(double d) {
                NotificationCenter.getInstance(InstantCameraView.this.currentAccount).postNotificationName(NotificationCenter.recordProgressChanged, Integer.valueOf(InstantCameraView.this.recordingGuid), Double.valueOf(d));
            }
        }

        public void startRecording(File outputFile, android.opengl.EGLContext sharedContext) throws InterruptedException {
            int i = MessagesController.getInstance(InstantCameraView.this.currentAccount).roundVideoSize;
            int i2 = MessagesController.getInstance(InstantCameraView.this.currentAccount).roundVideoBitrate * Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV;
            this.videoFile = outputFile;
            this.videoWidth = i;
            this.videoHeight = i;
            this.videoBitrate = i2;
            this.sharedEglContext = sharedContext;
            synchronized (this.sync) {
                if (this.running) {
                    return;
                }
                this.running = true;
                Thread thread = new Thread(this, "TextureMovieEncoder");
                thread.setPriority(10);
                thread.start();
                while (!this.ready) {
                    try {
                        this.sync.wait();
                    } catch (InterruptedException unused) {
                    }
                }
                this.keyframeThumbs.clear();
                this.frameCount = 0;
                DispatchQueue dispatchQueue = this.generateKeyframeThumbsQueue;
                if (dispatchQueue != null) {
                    dispatchQueue.cleanupQueue();
                    this.generateKeyframeThumbsQueue.recycle();
                }
                this.generateKeyframeThumbsQueue = new DispatchQueue("keyframes_thumb_queque");
                this.handler.sendMessage(this.handler.obtainMessage(0));
            }
        }

        public void stopRecording(int send) {
            this.handler.sendMessage(this.handler.obtainMessage(1, send, 0));
        }

        public void frameAvailable(SurfaceTexture st, Integer cameraId, long timestampInternal) {
            synchronized (this.sync) {
                if (this.ready) {
                    long timestamp = st.getTimestamp();
                    if (timestamp == 0) {
                        int i = this.zeroTimeStamps + 1;
                        this.zeroTimeStamps = i;
                        if (i <= 1) {
                            return;
                        }
                        if (BuildVars.LOGS_ENABLED) {
                            FileLog.d("fix timestamp enabled");
                        }
                    } else {
                        this.zeroTimeStamps = 0;
                        timestampInternal = timestamp;
                    }
                    this.handler.sendMessage(this.handler.obtainMessage(2, (int) (timestampInternal >> 32), (int) timestampInternal, cameraId));
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Looper.prepare();
            synchronized (this.sync) {
                this.handler = new EncoderHandler(this);
                this.ready = true;
                this.sync.notify();
            }
            Looper.loop();
            synchronized (this.sync) {
                this.ready = false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:105:0x00fb A[EDGE_INSN: B:105:0x00fb->B:41:0x00fb BREAK  A[LOOP:0: B:13:0x0028->B:39:0x00ef], SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00c8  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void handleAudioFrameAvailable(ir.eitaa.ui.Components.InstantCameraView.AudioBufferInfo r17) {
            /*
                Method dump skipped, instructions count: 525
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.InstantCameraView.VideoRecorder.handleAudioFrameAvailable(ir.eitaa.ui.Components.InstantCameraView$AudioBufferInfo):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0050  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x006a  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00f4  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x01c8  */
        /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void handleVideoFrameAvailable(long r19, java.lang.Integer r21) {
            /*
                Method dump skipped, instructions count: 470
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.InstantCameraView.VideoRecorder.handleVideoFrameAvailable(long, java.lang.Integer):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$handleVideoFrameAvailable$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$handleVideoFrameAvailable$0$InstantCameraView$VideoRecorder() {
            InstantCameraView.this.textureOverlayView.animate().setDuration(120L).alpha(0.0f).setInterpolator(new DecelerateInterpolator()).start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$handleVideoFrameAvailable$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$handleVideoFrameAvailable$1$InstantCameraView$VideoRecorder() {
            InstantCameraView.this.textureOverlayView.animate().setDuration(120L).alpha(0.0f).setInterpolator(new DecelerateInterpolator()).start();
        }

        private void createKeyframeThumb() {
            if (Build.VERSION.SDK_INT < 21 || SharedConfig.getDevicePerformanceClass() == 0 || this.frameCount % 33 != 0) {
                return;
            }
            this.generateKeyframeThumbsQueue.postRunnable(new GenerateKeyframeThumbTask());
        }

        /* JADX INFO: Access modifiers changed from: private */
        class GenerateKeyframeThumbTask implements Runnable {
            private GenerateKeyframeThumbTask() {
            }

            @Override // java.lang.Runnable
            public void run() {
                TextureView textureView = InstantCameraView.this.textureView;
                if (textureView != null) {
                    final Bitmap bitmap = textureView.getBitmap(AndroidUtilities.dp(56.0f), AndroidUtilities.dp(56.0f));
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$InstantCameraView$VideoRecorder$GenerateKeyframeThumbTask$sk9bjvf6d8qXbBHKjRyAw7vWwLE
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$run$0$InstantCameraView$VideoRecorder$GenerateKeyframeThumbTask(bitmap);
                        }
                    });
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: lambda$run$0, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void lambda$run$0$InstantCameraView$VideoRecorder$GenerateKeyframeThumbTask(Bitmap bitmap) {
                if ((bitmap == null || bitmap.getPixel(0, 0) == 0) && VideoRecorder.this.keyframeThumbs.size() > 1) {
                    VideoRecorder.this.keyframeThumbs.add((Bitmap) VideoRecorder.this.keyframeThumbs.get(VideoRecorder.this.keyframeThumbs.size() - 1));
                } else {
                    VideoRecorder.this.keyframeThumbs.add(bitmap);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void handleStopRecording(final int send) throws InterruptedException {
            if (this.running) {
                this.sendWhenDone = send;
                this.running = false;
                return;
            }
            try {
                drainEncoder(true);
            } catch (Exception e) {
                FileLog.e(e);
            }
            MediaCodec mediaCodec = this.videoEncoder;
            if (mediaCodec != null) {
                try {
                    mediaCodec.stop();
                    this.videoEncoder.release();
                    this.videoEncoder = null;
                } catch (Exception e2) {
                    FileLog.e(e2);
                }
            }
            MediaCodec mediaCodec2 = this.audioEncoder;
            if (mediaCodec2 != null) {
                try {
                    mediaCodec2.stop();
                    this.audioEncoder.release();
                    this.audioEncoder = null;
                } catch (Exception e3) {
                    FileLog.e(e3);
                }
            }
            MP4Builder mP4Builder = this.mediaMuxer;
            if (mP4Builder != null) {
                try {
                    mP4Builder.finishMovie();
                } catch (Exception e4) {
                    FileLog.e(e4);
                }
            }
            DispatchQueue dispatchQueue = this.generateKeyframeThumbsQueue;
            if (dispatchQueue != null) {
                dispatchQueue.cleanupQueue();
                this.generateKeyframeThumbsQueue.recycle();
                this.generateKeyframeThumbsQueue = null;
            }
            if (send == 0) {
                FileLoader.getInstance(InstantCameraView.this.currentAccount).cancelFileUpload(this.videoFile.getAbsolutePath(), false);
                this.videoFile.delete();
            } else {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$InstantCameraView$VideoRecorder$q0iy0UFW6mo7Xho_0Z7LrcdP8dg
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$handleStopRecording$4$InstantCameraView$VideoRecorder(send);
                    }
                });
            }
            EGL14.eglDestroySurface(this.eglDisplay, this.eglSurface);
            this.eglSurface = EGL14.EGL_NO_SURFACE;
            Surface surface = this.surface;
            if (surface != null) {
                surface.release();
                this.surface = null;
            }
            android.opengl.EGLDisplay eGLDisplay = this.eglDisplay;
            if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
                android.opengl.EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
                EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
                EGL14.eglDestroyContext(this.eglDisplay, this.eglContext);
                EGL14.eglReleaseThread();
                EGL14.eglTerminate(this.eglDisplay);
            }
            this.eglDisplay = EGL14.EGL_NO_DISPLAY;
            this.eglContext = EGL14.EGL_NO_CONTEXT;
            this.eglConfig = null;
            this.handler.exit();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$handleStopRecording$4, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$handleStopRecording$4$InstantCameraView$VideoRecorder(int i) {
            InstantCameraView.this.videoEditedInfo = new VideoEditedInfo();
            InstantCameraView.this.videoEditedInfo.roundVideo = true;
            InstantCameraView.this.videoEditedInfo.startTime = -1L;
            InstantCameraView.this.videoEditedInfo.endTime = -1L;
            InstantCameraView.this.videoEditedInfo.file = InstantCameraView.this.file;
            InstantCameraView.this.videoEditedInfo.encryptedFile = InstantCameraView.this.encryptedFile;
            InstantCameraView.this.videoEditedInfo.key = InstantCameraView.this.key;
            InstantCameraView.this.videoEditedInfo.iv = InstantCameraView.this.iv;
            InstantCameraView.this.videoEditedInfo.estimatedSize = Math.max(1L, InstantCameraView.this.size);
            InstantCameraView.this.videoEditedInfo.framerate = 25;
            VideoEditedInfo videoEditedInfo = InstantCameraView.this.videoEditedInfo;
            InstantCameraView.this.videoEditedInfo.originalWidth = 360;
            videoEditedInfo.resultWidth = 360;
            VideoEditedInfo videoEditedInfo2 = InstantCameraView.this.videoEditedInfo;
            InstantCameraView.this.videoEditedInfo.originalHeight = 360;
            videoEditedInfo2.resultHeight = 360;
            InstantCameraView.this.videoEditedInfo.originalPath = this.videoFile.getAbsolutePath();
            if (i == 1) {
                if (!InstantCameraView.this.baseFragment.isInScheduleMode()) {
                    InstantCameraView.this.baseFragment.sendMedia(new MediaController.PhotoEntry(0, 0, 0L, this.videoFile.getAbsolutePath(), 0, true, 0, 0, 0L), InstantCameraView.this.videoEditedInfo, true, 0, false);
                } else {
                    AlertsCreator.createScheduleDatePickerDialog(InstantCameraView.this.baseFragment.getParentActivity(), InstantCameraView.this.baseFragment.getDialogId(), new AlertsCreator.ScheduleDatePickerDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$InstantCameraView$VideoRecorder$Ts5mUluewTX15G3D0y-D83cCRog
                        @Override // ir.eitaa.ui.Components.AlertsCreator.ScheduleDatePickerDelegate
                        public final void didSelectDate(boolean z, int i2) {
                            this.f$0.lambda$handleStopRecording$2$InstantCameraView$VideoRecorder(z, i2);
                        }
                    }, new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$InstantCameraView$VideoRecorder$S-siAVfcezBtdz7ipfvCApskQYM
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$handleStopRecording$3$InstantCameraView$VideoRecorder();
                        }
                    }, InstantCameraView.this.resourcesProvider);
                }
            } else {
                InstantCameraView.this.videoPlayer = new VideoPlayer();
                InstantCameraView.this.videoPlayer.setDelegate(new VideoPlayer.VideoPlayerDelegate() { // from class: ir.eitaa.ui.Components.InstantCameraView.VideoRecorder.2
                    @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
                    public void onRenderedFirstFrame() {
                    }

                    @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
                    public /* synthetic */ void onRenderedFirstFrame(AnalyticsListener.EventTime eventTime) {
                        VideoPlayer.VideoPlayerDelegate.CC.$default$onRenderedFirstFrame(this, eventTime);
                    }

                    @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
                    public /* synthetic */ void onSeekFinished(AnalyticsListener.EventTime eventTime) {
                        VideoPlayer.VideoPlayerDelegate.CC.$default$onSeekFinished(this, eventTime);
                    }

                    @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
                    public /* synthetic */ void onSeekStarted(AnalyticsListener.EventTime eventTime) {
                        VideoPlayer.VideoPlayerDelegate.CC.$default$onSeekStarted(this, eventTime);
                    }

                    @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
                    public boolean onSurfaceDestroyed(SurfaceTexture surfaceTexture) {
                        return false;
                    }

                    @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
                    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                    }

                    @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
                    public void onVideoSizeChanged(int width, int height, int unappliedRotationDegrees, float pixelWidthHeightRatio) {
                    }

                    @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
                    public void onStateChanged(boolean playWhenReady, int playbackState) {
                        if (InstantCameraView.this.videoPlayer != null && InstantCameraView.this.videoPlayer.isPlaying() && playbackState == 4) {
                            InstantCameraView.this.videoPlayer.seekTo(InstantCameraView.this.videoEditedInfo.startTime > 0 ? InstantCameraView.this.videoEditedInfo.startTime : 0L);
                        }
                    }

                    @Override // ir.eitaa.ui.Components.VideoPlayer.VideoPlayerDelegate
                    public void onError(VideoPlayer player, Exception e) {
                        FileLog.e(e);
                    }
                });
                InstantCameraView.this.videoPlayer.setTextureView(InstantCameraView.this.textureView);
                InstantCameraView.this.videoPlayer.preparePlayer(Uri.fromFile(this.videoFile), "other");
                InstantCameraView.this.videoPlayer.play();
                InstantCameraView.this.videoPlayer.setMute(true);
                InstantCameraView.this.startProgressTimer();
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(ObjectAnimator.ofFloat(InstantCameraView.this.switchCameraButton, (Property<ImageView, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofInt(InstantCameraView.this.paint, AnimationProperties.PAINT_ALPHA, 0), ObjectAnimator.ofFloat(InstantCameraView.this.muteImageView, (Property<ImageView, Float>) View.ALPHA, 1.0f));
                animatorSet.setDuration(180L);
                animatorSet.setInterpolator(new DecelerateInterpolator());
                animatorSet.start();
                InstantCameraView.this.videoEditedInfo.estimatedDuration = InstantCameraView.this.recordedTime;
                NotificationCenter.getInstance(InstantCameraView.this.currentAccount).postNotificationName(NotificationCenter.audioDidSent, Integer.valueOf(InstantCameraView.this.recordingGuid), InstantCameraView.this.videoEditedInfo, this.videoFile.getAbsolutePath(), this.keyframeThumbs);
            }
            didWriteData(this.videoFile, 0L, true);
            MediaController.getInstance().requestAudioFocus(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$handleStopRecording$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$handleStopRecording$2$InstantCameraView$VideoRecorder(boolean z, int i) {
            InstantCameraView.this.baseFragment.sendMedia(new MediaController.PhotoEntry(0, 0, 0L, this.videoFile.getAbsolutePath(), 0, true, 0, 0, 0L), InstantCameraView.this.videoEditedInfo, z, i, false);
            InstantCameraView.this.startAnimation(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$handleStopRecording$3, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$handleStopRecording$3$InstantCameraView$VideoRecorder() {
            InstantCameraView.this.startAnimation(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void prepareEncoder() throws IllegalStateException, IOException {
            try {
                int minBufferSize = AudioRecord.getMinBufferSize(44100, 16, 2);
                if (minBufferSize <= 0) {
                    minBufferSize = 3584;
                }
                int i = 49152 < minBufferSize ? ((minBufferSize / Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) + 1) * Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS * 2 : 49152;
                for (int i2 = 0; i2 < 3; i2++) {
                    this.buffers.add(new AudioBufferInfo());
                }
                AudioRecord audioRecord = new AudioRecord(0, 44100, 16, 2, i);
                this.audioRecorder = audioRecord;
                audioRecord.startRecording();
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("initied audio record with channels " + this.audioRecorder.getChannelCount() + " sample rate = " + this.audioRecorder.getSampleRate() + " bufferSize = " + i);
                }
                Thread thread = new Thread(this.recorderRunnable);
                thread.setPriority(10);
                thread.start();
                this.audioBufferInfo = new MediaCodec.BufferInfo();
                this.videoBufferInfo = new MediaCodec.BufferInfo();
                MediaFormat mediaFormat = new MediaFormat();
                mediaFormat.setString("mime", MediaController.AUIDO_MIME_TYPE);
                mediaFormat.setInteger("sample-rate", 44100);
                mediaFormat.setInteger("channel-count", 1);
                mediaFormat.setInteger("bitrate", MessagesController.getInstance(InstantCameraView.this.currentAccount).roundAudioBitrate * Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV);
                mediaFormat.setInteger("max-input-size", 20480);
                MediaCodec mediaCodecCreateEncoderByType = MediaCodec.createEncoderByType(MediaController.AUIDO_MIME_TYPE);
                this.audioEncoder = mediaCodecCreateEncoderByType;
                mediaCodecCreateEncoderByType.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
                this.audioEncoder.start();
                this.videoEncoder = MediaCodec.createEncoderByType(MediaController.VIDEO_MIME_TYPE);
                this.firstEncode = true;
                MediaFormat mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat(MediaController.VIDEO_MIME_TYPE, this.videoWidth, this.videoHeight);
                mediaFormatCreateVideoFormat.setInteger("color-format", 2130708361);
                mediaFormatCreateVideoFormat.setInteger("bitrate", this.videoBitrate);
                mediaFormatCreateVideoFormat.setInteger("frame-rate", 30);
                mediaFormatCreateVideoFormat.setInteger("i-frame-interval", 1);
                this.videoEncoder.configure(mediaFormatCreateVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                this.surface = this.videoEncoder.createInputSurface();
                this.videoEncoder.start();
                Mp4Movie mp4Movie = new Mp4Movie();
                mp4Movie.setCacheFile(this.videoFile);
                mp4Movie.setRotation(0);
                mp4Movie.setSize(this.videoWidth, this.videoHeight);
                this.mediaMuxer = new MP4Builder().createMovie(mp4Movie, InstantCameraView.this.isSecretChat);
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$InstantCameraView$VideoRecorder$uecRAhH3Jz_ogd6oV6mdns5Cz4Q
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$prepareEncoder$5$InstantCameraView$VideoRecorder();
                    }
                });
                if (this.eglDisplay != EGL14.EGL_NO_DISPLAY) {
                    throw new RuntimeException("EGL already set up");
                }
                android.opengl.EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
                this.eglDisplay = eGLDisplayEglGetDisplay;
                if (eGLDisplayEglGetDisplay == EGL14.EGL_NO_DISPLAY) {
                    throw new RuntimeException("unable to get EGL14 display");
                }
                int[] iArr = new int[2];
                if (!EGL14.eglInitialize(eGLDisplayEglGetDisplay, iArr, 0, iArr, 1)) {
                    this.eglDisplay = null;
                    throw new RuntimeException("unable to initialize EGL14");
                }
                if (this.eglContext == EGL14.EGL_NO_CONTEXT) {
                    android.opengl.EGLConfig[] eGLConfigArr = new android.opengl.EGLConfig[1];
                    if (!EGL14.eglChooseConfig(this.eglDisplay, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, EglBase.EGL_RECORDABLE_ANDROID, 1, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
                        throw new RuntimeException("Unable to find a suitable EGLConfig");
                    }
                    this.eglContext = EGL14.eglCreateContext(this.eglDisplay, eGLConfigArr[0], this.sharedEglContext, new int[]{12440, 2, 12344}, 0);
                    this.eglConfig = eGLConfigArr[0];
                }
                EGL14.eglQueryContext(this.eglDisplay, this.eglContext, 12440, new int[1], 0);
                if (this.eglSurface != EGL14.EGL_NO_SURFACE) {
                    throw new IllegalStateException("surface already created");
                }
                android.opengl.EGLSurface eGLSurfaceEglCreateWindowSurface = EGL14.eglCreateWindowSurface(this.eglDisplay, this.eglConfig, this.surface, new int[]{12344}, 0);
                this.eglSurface = eGLSurfaceEglCreateWindowSurface;
                if (eGLSurfaceEglCreateWindowSurface == null) {
                    throw new RuntimeException("surface was null");
                }
                if (!EGL14.eglMakeCurrent(this.eglDisplay, eGLSurfaceEglCreateWindowSurface, eGLSurfaceEglCreateWindowSurface, this.eglContext)) {
                    if (BuildVars.LOGS_ENABLED) {
                        FileLog.e("eglMakeCurrent failed " + GLUtils.getEGLErrorString(EGL14.eglGetError()));
                    }
                    throw new RuntimeException("eglMakeCurrent failed");
                }
                GLES20.glBlendFunc(770, 771);
                int iLoadShader = InstantCameraView.this.loadShader(35633, "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n   gl_Position = uMVPMatrix * aPosition;\n   vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n");
                int iLoadShader2 = InstantCameraView.this.loadShader(35632, "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying vec2 vTextureCoord;\nuniform float scaleX;\nuniform float scaleY;\nuniform float alpha;\nuniform samplerExternalOES sTexture;\nvoid main() {\n   vec2 coord = vec2((vTextureCoord.x - 0.5) * scaleX, (vTextureCoord.y - 0.5) * scaleY);\n   float coef = ceil(clamp(0.2601 - dot(coord, coord), 0.0, 1.0));\n   vec3 color = texture2D(sTexture, vTextureCoord).rgb * coef + (1.0 - step(0.001, coef));\n   gl_FragColor = vec4(color * alpha, alpha);\n}\n");
                if (iLoadShader == 0 || iLoadShader2 == 0) {
                    return;
                }
                int iGlCreateProgram = GLES20.glCreateProgram();
                this.drawProgram = iGlCreateProgram;
                GLES20.glAttachShader(iGlCreateProgram, iLoadShader);
                GLES20.glAttachShader(this.drawProgram, iLoadShader2);
                GLES20.glLinkProgram(this.drawProgram);
                int[] iArr2 = new int[1];
                GLES20.glGetProgramiv(this.drawProgram, 35714, iArr2, 0);
                if (iArr2[0] == 0) {
                    GLES20.glDeleteProgram(this.drawProgram);
                    this.drawProgram = 0;
                    return;
                }
                this.positionHandle = GLES20.glGetAttribLocation(this.drawProgram, "aPosition");
                this.textureHandle = GLES20.glGetAttribLocation(this.drawProgram, "aTextureCoord");
                this.scaleXHandle = GLES20.glGetUniformLocation(this.drawProgram, "scaleX");
                this.scaleYHandle = GLES20.glGetUniformLocation(this.drawProgram, "scaleY");
                this.alphaHandle = GLES20.glGetUniformLocation(this.drawProgram, "alpha");
                this.vertexMatrixHandle = GLES20.glGetUniformLocation(this.drawProgram, "uMVPMatrix");
                this.textureMatrixHandle = GLES20.glGetUniformLocation(this.drawProgram, "uSTMatrix");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$prepareEncoder$5, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$prepareEncoder$5$InstantCameraView$VideoRecorder() {
            if (InstantCameraView.this.cancelled) {
                return;
            }
            try {
                InstantCameraView.this.performHapticFeedback(3, 2);
            } catch (Exception unused) {
            }
            AndroidUtilities.lockOrientation(InstantCameraView.this.baseFragment.getParentActivity());
            InstantCameraView.this.recording = true;
            InstantCameraView.this.recordStartTime = System.currentTimeMillis();
            InstantCameraView.this.invalidate();
            NotificationCenter.getInstance(InstantCameraView.this.currentAccount).postNotificationName(NotificationCenter.recordStarted, Integer.valueOf(InstantCameraView.this.recordingGuid), Boolean.FALSE);
        }

        private void didWriteData(File file, long availableSize, boolean last) {
            if (this.videoConvertFirstWrite) {
                FileLoader.getInstance(InstantCameraView.this.currentAccount).uploadFile(file.toString(), InstantCameraView.this.isSecretChat, false, 1, ConnectionsManager.FileTypeVideo, false);
                this.videoConvertFirstWrite = false;
                if (last) {
                    FileLoader.getInstance(InstantCameraView.this.currentAccount).checkUploadNewDataAvailable(file.toString(), InstantCameraView.this.isSecretChat, availableSize, last ? file.length() : 0L);
                    return;
                }
                return;
            }
            FileLoader.getInstance(InstantCameraView.this.currentAccount).checkUploadNewDataAvailable(file.toString(), InstantCameraView.this.isSecretChat, availableSize, last ? file.length() : 0L);
        }

        public void drainEncoder(boolean endOfStream) throws Exception {
            ByteBuffer outputBuffer;
            ByteBuffer byteBufferAllocate;
            ByteBuffer byteBufferAllocate2;
            ByteBuffer outputBuffer2;
            if (endOfStream) {
                this.videoEncoder.signalEndOfInputStream();
            }
            int i = 21;
            ByteBuffer[] outputBuffers = Build.VERSION.SDK_INT < 21 ? this.videoEncoder.getOutputBuffers() : null;
            while (true) {
                int iDequeueOutputBuffer = this.videoEncoder.dequeueOutputBuffer(this.videoBufferInfo, 10000L);
                byte b = 1;
                if (iDequeueOutputBuffer == -1) {
                    if (!endOfStream) {
                        break;
                    }
                    i = 21;
                } else {
                    if (iDequeueOutputBuffer == -3) {
                        if (Build.VERSION.SDK_INT < i) {
                            outputBuffers = this.videoEncoder.getOutputBuffers();
                        }
                    } else if (iDequeueOutputBuffer == -2) {
                        MediaFormat outputFormat = this.videoEncoder.getOutputFormat();
                        if (this.videoTrackIndex == -5) {
                            this.videoTrackIndex = this.mediaMuxer.addTrack(outputFormat, false);
                            if (outputFormat.containsKey("prepend-sps-pps-to-idr-frames") && outputFormat.getInteger("prepend-sps-pps-to-idr-frames") == 1) {
                                this.prependHeaderSize = outputFormat.getByteBuffer("csd-0").limit() + outputFormat.getByteBuffer("csd-1").limit();
                            }
                        }
                    } else if (iDequeueOutputBuffer >= 0) {
                        if (Build.VERSION.SDK_INT < i) {
                            outputBuffer = outputBuffers[iDequeueOutputBuffer];
                        } else {
                            outputBuffer = this.videoEncoder.getOutputBuffer(iDequeueOutputBuffer);
                        }
                        if (outputBuffer == null) {
                            throw new RuntimeException("encoderOutputBuffer " + iDequeueOutputBuffer + " was null");
                        }
                        MediaCodec.BufferInfo bufferInfo = this.videoBufferInfo;
                        int i2 = bufferInfo.size;
                        if (i2 > 1) {
                            int i3 = bufferInfo.flags;
                            if ((i3 & 2) == 0) {
                                int i4 = this.prependHeaderSize;
                                if (i4 != 0 && (i3 & 1) != 0) {
                                    bufferInfo.offset += i4;
                                    bufferInfo.size = i2 - i4;
                                }
                                if (this.firstEncode && (i3 & 1) != 0) {
                                    if (bufferInfo.size > 100) {
                                        outputBuffer.position(bufferInfo.offset);
                                        byte[] bArr = new byte[100];
                                        outputBuffer.get(bArr);
                                        int i5 = 0;
                                        int i6 = 0;
                                        while (true) {
                                            if (i5 < 96) {
                                                if (bArr[i5] == 0 && bArr[i5 + 1] == 0 && bArr[i5 + 2] == 0 && bArr[i5 + 3] == 1 && (i6 = i6 + 1) > 1) {
                                                    MediaCodec.BufferInfo bufferInfo2 = this.videoBufferInfo;
                                                    bufferInfo2.offset += i5;
                                                    bufferInfo2.size -= i5;
                                                    break;
                                                }
                                                i5++;
                                            } else {
                                                break;
                                            }
                                        }
                                    }
                                    this.firstEncode = false;
                                }
                                long jWriteSampleData = this.mediaMuxer.writeSampleData(this.videoTrackIndex, outputBuffer, this.videoBufferInfo, true);
                                if (jWriteSampleData != 0) {
                                    didWriteData(this.videoFile, jWriteSampleData, false);
                                }
                            } else if (this.videoTrackIndex == -5) {
                                byte[] bArr2 = new byte[i2];
                                outputBuffer.limit(bufferInfo.offset + i2);
                                outputBuffer.position(this.videoBufferInfo.offset);
                                outputBuffer.get(bArr2);
                                int i7 = this.videoBufferInfo.size - 1;
                                while (i7 >= 0 && i7 > 3) {
                                    if (bArr2[i7] == b && bArr2[i7 - 1] == 0 && bArr2[i7 - 2] == 0) {
                                        int i8 = i7 - 3;
                                        if (bArr2[i8] == 0) {
                                            byteBufferAllocate = ByteBuffer.allocate(i8);
                                            byteBufferAllocate2 = ByteBuffer.allocate(this.videoBufferInfo.size - i8);
                                            byteBufferAllocate.put(bArr2, 0, i8).position(0);
                                            byteBufferAllocate2.put(bArr2, i8, this.videoBufferInfo.size - i8).position(0);
                                            break;
                                        }
                                    }
                                    i7--;
                                    b = 1;
                                }
                                byteBufferAllocate = null;
                                byteBufferAllocate2 = null;
                                MediaFormat mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat(MediaController.VIDEO_MIME_TYPE, this.videoWidth, this.videoHeight);
                                if (byteBufferAllocate != null && byteBufferAllocate2 != null) {
                                    mediaFormatCreateVideoFormat.setByteBuffer("csd-0", byteBufferAllocate);
                                    mediaFormatCreateVideoFormat.setByteBuffer("csd-1", byteBufferAllocate2);
                                }
                                this.videoTrackIndex = this.mediaMuxer.addTrack(mediaFormatCreateVideoFormat, false);
                            }
                        }
                        this.videoEncoder.releaseOutputBuffer(iDequeueOutputBuffer, false);
                        if ((this.videoBufferInfo.flags & 4) != 0) {
                            break;
                        }
                    }
                    i = 21;
                }
            }
            if (Build.VERSION.SDK_INT < 21) {
                outputBuffers = this.audioEncoder.getOutputBuffers();
            }
            while (true) {
                int iDequeueOutputBuffer2 = this.audioEncoder.dequeueOutputBuffer(this.audioBufferInfo, 0L);
                if (iDequeueOutputBuffer2 == -1) {
                    if (!endOfStream) {
                        return;
                    }
                    if (!this.running && this.sendWhenDone == 0) {
                        return;
                    }
                } else if (iDequeueOutputBuffer2 == -3) {
                    if (Build.VERSION.SDK_INT < 21) {
                        outputBuffers = this.audioEncoder.getOutputBuffers();
                    }
                } else if (iDequeueOutputBuffer2 == -2) {
                    MediaFormat outputFormat2 = this.audioEncoder.getOutputFormat();
                    if (this.audioTrackIndex == -5) {
                        this.audioTrackIndex = this.mediaMuxer.addTrack(outputFormat2, true);
                    }
                } else if (iDequeueOutputBuffer2 >= 0) {
                    if (Build.VERSION.SDK_INT < 21) {
                        outputBuffer2 = outputBuffers[iDequeueOutputBuffer2];
                    } else {
                        outputBuffer2 = this.audioEncoder.getOutputBuffer(iDequeueOutputBuffer2);
                    }
                    if (outputBuffer2 == null) {
                        throw new RuntimeException("encoderOutputBuffer " + iDequeueOutputBuffer2 + " was null");
                    }
                    MediaCodec.BufferInfo bufferInfo3 = this.audioBufferInfo;
                    if ((bufferInfo3.flags & 2) != 0) {
                        bufferInfo3.size = 0;
                    }
                    if (bufferInfo3.size != 0) {
                        long jWriteSampleData2 = this.mediaMuxer.writeSampleData(this.audioTrackIndex, outputBuffer2, bufferInfo3, false);
                        if (jWriteSampleData2 != 0) {
                            didWriteData(this.videoFile, jWriteSampleData2, false);
                        }
                    }
                    this.audioEncoder.releaseOutputBuffer(iDequeueOutputBuffer2, false);
                    if ((this.audioBufferInfo.flags & 4) != 0) {
                        return;
                    }
                }
            }
        }

        protected void finalize() throws Throwable {
            try {
                android.opengl.EGLDisplay eGLDisplay = this.eglDisplay;
                if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
                    android.opengl.EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
                    EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
                    EGL14.eglDestroyContext(this.eglDisplay, this.eglContext);
                    EGL14.eglReleaseThread();
                    EGL14.eglTerminate(this.eglDisplay);
                    this.eglDisplay = EGL14.EGL_NO_DISPLAY;
                    this.eglContext = EGL14.EGL_NO_CONTEXT;
                    this.eglConfig = null;
                }
            } finally {
                super.finalize();
            }
        }
    }

    public class InstantViewCameraContainer extends FrameLayout {
        float imageProgress;
        ImageReceiver imageReceiver;

        public InstantViewCameraContainer(Context context) {
            super(context);
            InstantCameraView.this.setWillNotDraw(false);
        }

        public void setImageReceiver(ImageReceiver imageReceiver) {
            if (this.imageReceiver == null) {
                this.imageProgress = 0.0f;
            }
            this.imageReceiver = imageReceiver;
            invalidate();
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            super.dispatchDraw(canvas);
            float f = this.imageProgress;
            if (f != 1.0f) {
                float f2 = f + 0.064f;
                this.imageProgress = f2;
                if (f2 > 1.0f) {
                    this.imageProgress = 1.0f;
                }
                invalidate();
            }
            if (this.imageReceiver != null) {
                canvas.save();
                if (this.imageReceiver.getImageWidth() != InstantCameraView.this.textureViewSize) {
                    float imageWidth = InstantCameraView.this.textureViewSize / this.imageReceiver.getImageWidth();
                    canvas.scale(imageWidth, imageWidth);
                }
                canvas.translate(-this.imageReceiver.getImageX(), -this.imageReceiver.getImageY());
                float alpha = this.imageReceiver.getAlpha();
                this.imageReceiver.setAlpha(this.imageProgress);
                this.imageReceiver.draw(canvas);
                this.imageReceiver.setAlpha(alpha);
                canvas.restore();
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        VideoPlayer videoPlayer;
        if (ev.getAction() == 0 && this.baseFragment != null && (videoPlayer = this.videoPlayer) != null) {
            boolean z = !videoPlayer.isMuted();
            this.videoPlayer.setMute(z);
            AnimatorSet animatorSet = this.muteAnimation;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.muteAnimation = animatorSet2;
            Animator[] animatorArr = new Animator[3];
            ImageView imageView = this.muteImageView;
            Property property = View.ALPHA;
            float[] fArr = new float[1];
            fArr[0] = z ? 1.0f : 0.0f;
            animatorArr[0] = ObjectAnimator.ofFloat(imageView, (Property<ImageView, Float>) property, fArr);
            ImageView imageView2 = this.muteImageView;
            Property property2 = View.SCALE_X;
            float[] fArr2 = new float[1];
            fArr2[0] = z ? 1.0f : 0.5f;
            animatorArr[1] = ObjectAnimator.ofFloat(imageView2, (Property<ImageView, Float>) property2, fArr2);
            ImageView imageView3 = this.muteImageView;
            Property property3 = View.SCALE_Y;
            float[] fArr3 = new float[1];
            fArr3[0] = z ? 1.0f : 0.5f;
            animatorArr[2] = ObjectAnimator.ofFloat(imageView3, (Property<ImageView, Float>) property3, fArr3);
            animatorSet2.playTogether(animatorArr);
            this.muteAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.InstantCameraView.10
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    if (animation.equals(InstantCameraView.this.muteAnimation)) {
                        InstantCameraView.this.muteAnimation = null;
                    }
                }
            });
            this.muteAnimation.setDuration(180L);
            this.muteAnimation.setInterpolator(new DecelerateInterpolator());
            this.muteAnimation.start();
        }
        if (ev.getActionMasked() == 0 || ev.getActionMasked() == 5) {
            if (this.maybePinchToZoomTouchMode && !this.isInPinchToZoomTouchMode && ev.getPointerCount() == 2 && this.finishZoomTransition == null && this.recording) {
                this.pinchStartDistance = (float) Math.hypot(ev.getX(1) - ev.getX(0), ev.getY(1) - ev.getY(0));
                this.pinchScale = 1.0f;
                this.pointerId1 = ev.getPointerId(0);
                this.pointerId2 = ev.getPointerId(1);
                this.isInPinchToZoomTouchMode = true;
            }
            if (ev.getActionMasked() == 0) {
                RectF rectF = AndroidUtilities.rectTmp;
                rectF.set(this.cameraContainer.getX(), this.cameraContainer.getY(), this.cameraContainer.getX() + this.cameraContainer.getMeasuredWidth(), this.cameraContainer.getY() + this.cameraContainer.getMeasuredHeight());
                this.maybePinchToZoomTouchMode = rectF.contains(ev.getX(), ev.getY());
            }
            return true;
        }
        if (ev.getActionMasked() == 2 && this.isInPinchToZoomTouchMode) {
            int i = -1;
            int i2 = -1;
            for (int i3 = 0; i3 < ev.getPointerCount(); i3++) {
                if (this.pointerId1 == ev.getPointerId(i3)) {
                    i = i3;
                }
                if (this.pointerId2 == ev.getPointerId(i3)) {
                    i2 = i3;
                }
            }
            if (i == -1 || i2 == -1) {
                this.isInPinchToZoomTouchMode = false;
                finishZoom();
                return false;
            }
            float fHypot = ((float) Math.hypot(ev.getX(i2) - ev.getX(i), ev.getY(i2) - ev.getY(i))) / this.pinchStartDistance;
            this.pinchScale = fHypot;
            this.cameraSession.setZoom(Math.min(1.0f, Math.max(0.0f, fHypot - 1.0f)));
        } else if ((ev.getActionMasked() == 1 || ((ev.getActionMasked() == 6 && checkPointerIds(ev)) || ev.getActionMasked() == 3)) && this.isInPinchToZoomTouchMode) {
            this.isInPinchToZoomTouchMode = false;
            finishZoom();
        }
        return true;
    }

    public void finishZoom() {
        if (this.finishZoomTransition != null) {
            return;
        }
        float fMin = Math.min(1.0f, Math.max(0.0f, this.pinchScale - 1.0f));
        if (fMin > 0.0f) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fMin, 0.0f);
            this.finishZoomTransition = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$InstantCameraView$sANLoMsfd0NI1CuzHiMlWkifwB8
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f$0.lambda$finishZoom$5$InstantCameraView(valueAnimator);
                }
            });
            this.finishZoomTransition.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.InstantCameraView.11
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    InstantCameraView instantCameraView = InstantCameraView.this;
                    if (instantCameraView.finishZoomTransition != null) {
                        instantCameraView.finishZoomTransition = null;
                    }
                }
            });
            this.finishZoomTransition.setDuration(350L);
            this.finishZoomTransition.setInterpolator(CubicBezierInterpolator.DEFAULT);
            this.finishZoomTransition.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$finishZoom$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$finishZoom$5$InstantCameraView(ValueAnimator valueAnimator) {
        this.cameraSession.setZoom(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
