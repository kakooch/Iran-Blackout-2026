package ir.appp.rghapp.rubinoPostSlider;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.hardware.Camera;
import android.util.Property;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import ir.appp.rghapp.RGHMediaHelper$PhotoEntry;
import ir.appp.rghapp.Utils;
import ir.appp.rghapp.rubinoPostSlider.AddPostCameraView;
import ir.appp.rghapp.rubinoPostSlider.AddPostCaptureButton;
import ir.appp.rghapp.rubinoPostSlider.AddPostPermissionView;
import ir.medu.shad.R;
import java.io.File;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.camera.CameraController;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.Size;

/* loaded from: classes3.dex */
public class AddPostCaptureLayout extends FrameLayout {
    private final FrameLayout bottomContainer;
    private AddPostCameraView cameraView;
    private final AddPostCaptureButton captureButton;
    private CaptureLayoutDelegate captureLayoutDelegate;
    private CaptureState captureState;
    private boolean flashAnimationInProgress;
    private final ImageView[] flashModeButton;
    private final FrameLayout iconsContainer;
    private final Context mContext;
    private final RGHAddPostActivity parentActivity;
    private final AddPostPermissionView permissionView;
    private final RecordDot recordDot;
    private final LinearLayout recordTimeContainer;
    private final TextView recordTimeTextView;
    private final Paint redDotPaint;
    private final AddPostPermissionView.PermissionType[] requiredPermissions;
    private final ImageView switchCameraButton;
    private boolean takingPhoto;
    private final FrameLayout topContainer;
    private final VideoRecordProgressView videoRecordProgress;
    private Runnable videoRecordRunnable;
    private int videoRecordTime;

    public interface CaptureLayoutDelegate {
        void onCaptureMedia(RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry);

        void onStartRecording();

        void onStateChangedFromPhotoToVideo();
    }

    public enum CaptureState {
        PHOTO,
        VIDEO,
        RECORDING
    }

    static /* synthetic */ int access$708(AddPostCaptureLayout addPostCaptureLayout) {
        int i = addPostCaptureLayout.videoRecordTime;
        addPostCaptureLayout.videoRecordTime = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class VideoRecordProgressView extends View {
        private float endX;
        private final Paint paint;
        private long progressStartTime;
        private boolean progressStarted;
        private boolean reachedEnd;
        private final Runnable updateProgressRunnable;

        public VideoRecordProgressView(Context context) {
            super(context);
            this.updateProgressRunnable = new Runnable() { // from class: ir.appp.rghapp.rubinoPostSlider.AddPostCaptureLayout$VideoRecordProgressView$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.updateProgress();
                }
            };
            Paint paint = new Paint();
            this.paint = paint;
            paint.setColor(Theme.getColor(Theme.key_rubinoBlackColor));
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(AndroidUtilities.dp(4.0f));
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            canvas.drawLine(0.0f, 0.0f, this.endX, 0.0f, this.paint);
            if (!this.progressStarted || this.reachedEnd) {
                return;
            }
            AndroidUtilities.runOnUIThread(this.updateProgressRunnable, 50L);
        }

        public void startProgress() {
            this.progressStartTime = System.currentTimeMillis();
            this.progressStarted = true;
            AndroidUtilities.runOnUIThread(this.updateProgressRunnable, 50L);
        }

        public void stopProgress() {
            AndroidUtilities.cancelRunOnUIThread(this.updateProgressRunnable);
            this.progressStarted = false;
            this.progressStartTime = 0L;
            updateProgress();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateProgress() {
            if (this.progressStarted) {
                float fCurrentTimeMillis = (System.currentTimeMillis() - this.progressStartTime) / 60000.0f;
                if (fCurrentTimeMillis <= 1.0f) {
                    this.endX = getMeasuredWidth() * fCurrentTimeMillis;
                } else {
                    this.endX = getMeasuredWidth();
                    this.reachedEnd = true;
                }
            } else {
                this.endX = 0.0f;
            }
            invalidate();
        }

        @Override // android.view.View
        protected void onDetachedFromWindow() {
            AndroidUtilities.cancelRunOnUIThread(this.updateProgressRunnable);
            super.onDetachedFromWindow();
        }
    }

    private class RecordDot extends View {
        private float alpha;
        private boolean isIncr;
        private long lastUpdateTime;

        public RecordDot(Context context) {
            super(context);
            AddPostCaptureLayout.this.redDotPaint.setColor(Theme.getColor(Theme.key_chat_recordedVoiceDot));
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            AddPostCaptureLayout.this.redDotPaint.setAlpha((int) (this.alpha * 255.0f));
            long jCurrentTimeMillis = System.currentTimeMillis() - this.lastUpdateTime;
            if (!this.isIncr) {
                float f = this.alpha - (jCurrentTimeMillis / 400.0f);
                this.alpha = f;
                if (f <= 0.0f) {
                    this.alpha = 0.0f;
                    this.isIncr = true;
                }
            } else {
                float f2 = this.alpha + (jCurrentTimeMillis / 400.0f);
                this.alpha = f2;
                if (f2 >= 1.0f) {
                    this.alpha = 1.0f;
                    this.isIncr = false;
                }
            }
            this.lastUpdateTime = System.currentTimeMillis();
            canvas.drawCircle(AndroidUtilities.dp(5.0f), AndroidUtilities.dp(5.0f), AndroidUtilities.dp(5.0f), AddPostCaptureLayout.this.redDotPaint);
            invalidate();
        }
    }

    public AddPostCaptureLayout(Context context, RGHAddPostActivity rGHAddPostActivity) {
        super(context);
        this.flashModeButton = new ImageView[2];
        this.redDotPaint = new Paint(1);
        this.captureState = CaptureState.PHOTO;
        setBackgroundColor(Theme.getColor(Theme.key_actionBarDefault));
        this.mContext = context;
        this.parentActivity = rGHAddPostActivity;
        this.requiredPermissions = new AddPostPermissionView.PermissionType[]{AddPostPermissionView.PermissionType.CAMERA, AddPostPermissionView.PermissionType.AUDIO};
        FrameLayout frameLayout = new FrameLayout(context);
        this.iconsContainer = frameLayout;
        FrameLayout frameLayout2 = new FrameLayout(this, context) { // from class: ir.appp.rghapp.rubinoPostSlider.AddPostCaptureLayout.1
            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int i, int i2) {
                super.onMeasure(i, i);
            }
        };
        this.topContainer = frameLayout2;
        FrameLayout frameLayout3 = new FrameLayout(context) { // from class: ir.appp.rghapp.rubinoPostSlider.AddPostCaptureLayout.2
            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int i, int i2) {
                int size = View.MeasureSpec.getSize(i2);
                int size2 = View.MeasureSpec.getSize(i);
                int i3 = size - size2;
                if (AddPostCaptureLayout.this.recordTimeContainer != null) {
                    int i4 = (int) (i3 / 5.0f);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) AddPostCaptureLayout.this.recordTimeContainer.getLayoutParams();
                    if (layoutParams.topMargin != i4) {
                        layoutParams.topMargin = i4;
                    }
                }
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(size2, 1073741824), View.MeasureSpec.makeMeasureSpec(i3, 1073741824));
            }
        };
        this.bottomContainer = frameLayout3;
        addView(frameLayout2, LayoutHelper.createFrame(-1, -2, 48));
        addView(frameLayout3, LayoutHelper.createFrame(-1, -1, 80));
        AddPostCaptureButton addPostCaptureButton = new AddPostCaptureButton(context);
        this.captureButton = addPostCaptureButton;
        addPostCaptureButton.setDelegate(new AnonymousClass3());
        frameLayout3.addView(addPostCaptureButton, LayoutHelper.createFrame(76, 76, 17));
        ImageView imageView = new ImageView(context);
        this.switchCameraButton = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        frameLayout.addView(imageView, LayoutHelper.createFrame(48, 48.0f, 83, 6.0f, 0.0f, 0.0f, 4.0f));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: ir.appp.rghapp.rubinoPostSlider.AddPostCaptureLayout$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$0(view);
            }
        });
        for (int i = 0; i < 2; i++) {
            this.flashModeButton[i] = new ImageView(context);
            this.flashModeButton[i].setScaleType(ImageView.ScaleType.CENTER);
            this.flashModeButton[i].setVisibility(4);
            this.iconsContainer.addView(this.flashModeButton[i], LayoutHelper.createFrame(48, 48.0f, 85, 0.0f, 0.0f, 6.0f, 4.0f));
            this.flashModeButton[i].setOnClickListener(new View.OnClickListener() { // from class: ir.appp.rghapp.rubinoPostSlider.AddPostCaptureLayout$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$1(view);
                }
            });
            this.flashModeButton[i].setContentDescription("flash mode " + i);
        }
        VideoRecordProgressView videoRecordProgressView = new VideoRecordProgressView(context);
        this.videoRecordProgress = videoRecordProgressView;
        this.bottomContainer.addView(videoRecordProgressView, LayoutHelper.createFrame(-1, 2.0f, 48, 0.0f, 1.0f, 0.0f, 0.0f));
        ViewCompat.setLayoutDirection(videoRecordProgressView, 0);
        LinearLayout linearLayout = new LinearLayout(context);
        this.recordTimeContainer = linearLayout;
        linearLayout.setOrientation(0);
        this.bottomContainer.addView(linearLayout, LayoutHelper.createFrame(-2, -2.0f, 49, 0.0f, 24.0f, 0.0f, 0.0f));
        ViewCompat.setLayoutDirection(linearLayout, 0);
        RecordDot recordDot = new RecordDot(context);
        this.recordDot = recordDot;
        linearLayout.addView(recordDot, LayoutHelper.createLinear(11, 11, 16, 0, 1, 0, 0));
        TextView textView = new TextView(context);
        this.recordTimeTextView = textView;
        textView.setTextColor(Theme.getColor(Theme.key_chat_recordTime));
        textView.setPadding(AndroidUtilities.dp(2.0f), 0, 0, 0);
        textView.setTextSize(1, 16.0f);
        linearLayout.addView(textView, LayoutHelper.createLinear(-2, -2, 16, 6, 0, 0, 0));
        AddPostPermissionView addPostPermissionView = new AddPostPermissionView(context);
        this.permissionView = addPostPermissionView;
        addPostPermissionView.setRequestForPermissions(this.requiredPermissions);
        addPostPermissionView.setPermissionDescription(LocaleController.formatString(R.string.rubinoAddPostCameraMicPermissionDesc, LocaleController.getString(R.string.AppName)).toString());
        addPostPermissionView.setDelegate(new AddPostPermissionView.AddPostPermissionDelegate() { // from class: ir.appp.rghapp.rubinoPostSlider.AddPostCaptureLayout$$ExternalSyntheticLambda2
            @Override // ir.appp.rghapp.rubinoPostSlider.AddPostPermissionView.AddPostPermissionDelegate
            public final void didRequestPermission(AddPostPermissionView.PermissionType[] permissionTypeArr) {
                this.f$0.lambda$new$2(permissionTypeArr);
            }
        });
        this.topContainer.addView(addPostPermissionView);
        addPostPermissionView.setVisibility(8);
        linearLayout.setVisibility(8);
        RGHAddPostActivity rGHAddPostActivity2 = this.parentActivity;
        if (!rGHAddPostActivity2.noCameraPermissions && !rGHAddPostActivity2.noMicrophonePermissions) {
            initCameraAndCameraView();
        } else {
            addPostPermissionView.setVisibility(0);
        }
    }

    /* renamed from: ir.appp.rghapp.rubinoPostSlider.AddPostCaptureLayout$3, reason: invalid class name */
    class AnonymousClass3 implements AddPostCaptureButton.AddPostCaptureButtonDelegate {
        private File outputFile;

        AnonymousClass3() {
        }

        @Override // ir.appp.rghapp.rubinoPostSlider.AddPostCaptureButton.AddPostCaptureButtonDelegate
        public boolean captureLongPressed() {
            if (AddPostCaptureLayout.this.getParent() != null) {
                AddPostCaptureLayout.this.getParent().requestDisallowInterceptTouchEvent(false);
            }
            if (AddPostCaptureLayout.this.parentActivity.noCameraPermissions || AddPostCaptureLayout.this.parentActivity.noMicrophonePermissions) {
                AddPostCaptureLayout.this.requestRequiredPermissions();
                return false;
            }
            if (AddPostCaptureLayout.this.parentActivity.bottomTabBarScrollProgress != 0.0f) {
                return false;
            }
            AddPostCaptureLayout.this.toggleCameraOptionIcons(true);
            if (AddPostCaptureLayout.this.captureState == CaptureState.PHOTO && AddPostCaptureLayout.this.captureLayoutDelegate != null) {
                AddPostCaptureLayout.this.captureLayoutDelegate.onStateChangedFromPhotoToVideo();
            }
            this.outputFile = new File(Utils.getVideoOutputFilePath());
            if (AddPostCaptureLayout.this.captureLayoutDelegate != null) {
                AddPostCaptureLayout.this.captureLayoutDelegate.onStartRecording();
            }
            AddPostCaptureLayout.this.recordTimeContainer.setVisibility(0);
            AddPostCaptureLayout.this.recordTimeTextView.setText(AndroidUtilities.formatDuration(0, false));
            AddPostCaptureLayout.this.videoRecordTime = 0;
            AddPostCaptureLayout.this.videoRecordRunnable = new Runnable() { // from class: ir.appp.rghapp.rubinoPostSlider.AddPostCaptureLayout$3$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$captureLongPressed$0();
                }
            };
            AddPostCaptureLayout.this.videoRecordProgress.startProgress();
            AddPostCaptureLayout.this.captureState = CaptureState.RECORDING;
            CameraController.getInstance().recordVideo(AddPostCaptureLayout.this.cameraView.getCameraSession(), this.outputFile, false, new CameraController.VideoTakeCallback() { // from class: ir.appp.rghapp.rubinoPostSlider.AddPostCaptureLayout$3$$ExternalSyntheticLambda3
                @Override // org.rbmain.messenger.camera.CameraController.VideoTakeCallback
                public final void onFinishVideoRecording(String str, long j) {
                    this.f$0.lambda$captureLongPressed$1(str, j);
                }
            }, new Runnable() { // from class: ir.appp.rghapp.rubinoPostSlider.AddPostCaptureLayout$3$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$captureLongPressed$2();
                }
            });
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$captureLongPressed$0() {
            if (AddPostCaptureLayout.this.videoRecordRunnable == null) {
                return;
            }
            AddPostCaptureLayout.access$708(AddPostCaptureLayout.this);
            AddPostCaptureLayout.this.captureState = CaptureState.RECORDING;
            AddPostCaptureLayout.this.recordTimeTextView.setText(AndroidUtilities.formatDuration(AddPostCaptureLayout.this.videoRecordTime, false));
            AndroidUtilities.runOnUIThread(AddPostCaptureLayout.this.videoRecordRunnable, 1000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$captureLongPressed$1(String str, long j) {
            if (this.outputFile == null || AddPostCaptureLayout.this.cameraView == null || j < 3) {
                return;
            }
            RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry = new RGHMediaHelper$PhotoEntry(0, 1111, 0L, this.outputFile.getAbsolutePath(), 0L, true, 0, 0, 0L);
            rGHMediaHelper$PhotoEntry.duration = (int) j;
            rGHMediaHelper$PhotoEntry.thumbPath = str;
            if (AddPostCaptureLayout.this.captureLayoutDelegate != null) {
                AddPostCaptureLayout.this.captureLayoutDelegate.onCaptureMedia(rGHMediaHelper$PhotoEntry);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$captureLongPressed$2() {
            AndroidUtilities.runOnUIThread(AddPostCaptureLayout.this.videoRecordRunnable, 1000L);
        }

        @Override // ir.appp.rghapp.rubinoPostSlider.AddPostCaptureButton.AddPostCaptureButtonDelegate
        public void captureReleased() {
            if (AddPostCaptureLayout.this.getParent() != null) {
                AddPostCaptureLayout.this.getParent().requestDisallowInterceptTouchEvent(false);
            }
            if (!AddPostCaptureLayout.this.parentActivity.noCameraPermissions && !AddPostCaptureLayout.this.parentActivity.noMicrophonePermissions) {
                AddPostCaptureLayout.this.toggleCameraOptionIcons(false);
                if (AddPostCaptureLayout.this.takingPhoto || AddPostCaptureLayout.this.cameraView == null || AddPostCaptureLayout.this.cameraView.getCameraSession() == null) {
                    return;
                }
                if (AddPostCaptureLayout.this.captureState == CaptureState.RECORDING) {
                    AddPostCaptureLayout.this.endRecordingAndResetState();
                    return;
                }
                File file = new File(Utils.getCameraImageOutputFilePath());
                AddPostCaptureLayout.this.takingPhoto = CameraController.getInstance().takePicture(file, AddPostCaptureLayout.this.cameraView.getCameraSession(), new CameraController.OnImageCaptured() { // from class: ir.appp.rghapp.rubinoPostSlider.AddPostCaptureLayout$3$$ExternalSyntheticLambda2
                    @Override // org.rbmain.messenger.camera.CameraController.OnImageCaptured
                    public final void onImageCaptured(RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry) {
                        this.f$0.lambda$captureReleased$3(rGHMediaHelper$PhotoEntry);
                    }
                });
                return;
            }
            AddPostCaptureLayout.this.requestRequiredPermissions();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$captureReleased$3(RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry) {
            AddPostCaptureLayout.this.takingPhoto = false;
            if (AddPostCaptureLayout.this.captureLayoutDelegate != null) {
                AddPostCaptureLayout.this.captureLayoutDelegate.onCaptureMedia(rGHMediaHelper$PhotoEntry);
            }
        }

        @Override // ir.appp.rghapp.rubinoPostSlider.AddPostCaptureButton.AddPostCaptureButtonDelegate
        public void didTouchShutterButton() {
            if (AddPostCaptureLayout.this.getParent() != null) {
                AddPostCaptureLayout.this.getParent().requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view) {
        AddPostCameraView addPostCameraView;
        if (this.takingPhoto || (addPostCameraView = this.cameraView) == null || !addPostCameraView.isInitied()) {
            return;
        }
        this.cameraView.switchCamera();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.switchCameraButton, (Property<ImageView, Float>) View.SCALE_X, 0.0f).setDuration(100L);
        duration.addListener(new AnimatorListenerAdapter() { // from class: ir.appp.rghapp.rubinoPostSlider.AddPostCaptureLayout.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AddPostCaptureLayout.this.switchCameraButton.setImageResource((AddPostCaptureLayout.this.cameraView == null || !AddPostCaptureLayout.this.cameraView.isFrontface()) ? R.drawable.camera_revert2 : R.drawable.camera_revert1);
                ObjectAnimator.ofFloat(AddPostCaptureLayout.this.switchCameraButton, (Property<ImageView, Float>) View.SCALE_X, 1.0f).setDuration(100L).start();
            }
        });
        duration.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(final View view) {
        AddPostCameraView addPostCameraView;
        if (this.flashAnimationInProgress || (addPostCameraView = this.cameraView) == null || !addPostCameraView.isInitied()) {
            return;
        }
        String currentFlashMode = this.cameraView.getCameraSession().getCurrentFlashMode();
        String nextFlashMode = this.cameraView.getCameraSession().getNextFlashMode();
        if (currentFlashMode.equals(nextFlashMode)) {
            return;
        }
        this.cameraView.getCameraSession().setCurrentFlashMode(nextFlashMode);
        this.flashAnimationInProgress = true;
        ImageView[] imageViewArr = this.flashModeButton;
        final ImageView imageView = imageViewArr[0] == view ? imageViewArr[1] : imageViewArr[0];
        imageView.setVisibility(0);
        setCameraFlashModeIcon(imageView, nextFlashMode);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_Y, 0.0f, AndroidUtilities.dp(48.0f)), ObjectAnimator.ofFloat(imageView, (Property<ImageView, Float>) View.TRANSLATION_Y, -AndroidUtilities.dp(48.0f), 0.0f), ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 1.0f, 0.0f), ObjectAnimator.ofFloat(imageView, (Property<ImageView, Float>) View.ALPHA, 0.0f, 1.0f));
        animatorSet.setDuration(200L);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.appp.rghapp.rubinoPostSlider.AddPostCaptureLayout.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AddPostCaptureLayout.this.flashAnimationInProgress = false;
                view.setVisibility(4);
                imageView.sendAccessibilityEvent(8);
            }
        });
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2(AddPostPermissionView.PermissionType[] permissionTypeArr) {
        requestRequiredPermissions();
    }

    public void setCaptureLayoutDelegate(CaptureLayoutDelegate captureLayoutDelegate) {
        this.captureLayoutDelegate = captureLayoutDelegate;
    }

    public void setCaptureState(CaptureState captureState) {
        this.captureState = captureState;
    }

    public CaptureState getCaptureState() {
        return this.captureState;
    }

    public void togglePermissionView(boolean z) {
        if (z) {
            this.permissionView.setVisibility(0);
        } else {
            this.permissionView.setVisibility(8);
            initCameraAndCameraView();
        }
    }

    public Size getCameraViewSize() {
        if (this.cameraView != null) {
            return new Size(r0.getMeasuredWidth(), this.cameraView.getMeasuredHeight());
        }
        return new Size(AndroidUtilities.getScreenWidth(), AndroidUtilities.getScreenWidth());
    }

    protected void requestRequiredPermissions() {
        RGHAddPostActivity rGHAddPostActivity = this.parentActivity;
        boolean z = rGHAddPostActivity.noCameraPermissions;
        if (z && rGHAddPostActivity.noMicrophonePermissions) {
            rGHAddPostActivity.requestPermission(this.requiredPermissions);
        } else if (z) {
            rGHAddPostActivity.requestPermission(new AddPostPermissionView.PermissionType[]{this.requiredPermissions[0]});
        } else {
            rGHAddPostActivity.requestPermission(new AddPostPermissionView.PermissionType[]{this.requiredPermissions[1]});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toggleCameraOptionIcons(boolean z) {
        float f = z ? 0.0f : 1.0f;
        this.switchCameraButton.setAlpha(f);
        for (int i = 0; i < 2; i++) {
            this.flashModeButton[i].setAlpha(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCameraFlashModeIcon(ImageView imageView, String str) {
        str.hashCode();
        switch (str) {
            case "on":
                imageView.setImageResource(R.drawable.flash_on);
                break;
            case "off":
                imageView.setImageResource(R.drawable.flash_off);
                break;
            case "auto":
                imageView.setImageResource(R.drawable.flash_auto);
                break;
        }
    }

    private void initCameraAndCameraView() {
        this.permissionView.setVisibility(8);
        if (this.cameraView != null) {
            return;
        }
        if (!CameraController.getInstance().isCameraInitied()) {
            CameraController.getInstance().initCamera(new Runnable() { // from class: ir.appp.rghapp.rubinoPostSlider.AddPostCaptureLayout$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.addCameraViewToContainer();
                }
            });
        } else {
            addCameraViewToContainer();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addCameraViewToContainer() {
        try {
            if (this.cameraView != null) {
                return;
            }
            AddPostCameraView addPostCameraView = new AddPostCameraView(this.mContext, false);
            this.cameraView = addPostCameraView;
            addPostCameraView.setDelegate(new AddPostCameraView.CameraViewDelegate() { // from class: ir.appp.rghapp.rubinoPostSlider.AddPostCaptureLayout.6
                @Override // ir.appp.rghapp.rubinoPostSlider.AddPostCameraView.CameraViewDelegate
                public void onCameraCreated(Camera camera) {
                }

                @Override // ir.appp.rghapp.rubinoPostSlider.AddPostCameraView.CameraViewDelegate
                public void onCameraInit() {
                    if (AddPostCaptureLayout.this.cameraView.getCameraSession().getCurrentFlashMode().equals(AddPostCaptureLayout.this.cameraView.getCameraSession().getNextFlashMode())) {
                        for (int i = 0; i < 2; i++) {
                            AddPostCaptureLayout.this.flashModeButton[i].setVisibility(4);
                            AddPostCaptureLayout.this.flashModeButton[i].setAlpha(0.0f);
                            AddPostCaptureLayout.this.flashModeButton[i].setTranslationY(0.0f);
                        }
                    } else {
                        AddPostCaptureLayout addPostCaptureLayout = AddPostCaptureLayout.this;
                        addPostCaptureLayout.setCameraFlashModeIcon(addPostCaptureLayout.flashModeButton[0], AddPostCaptureLayout.this.cameraView.getCameraSession().getCurrentFlashMode());
                        int i2 = 0;
                        while (i2 < 2) {
                            AddPostCaptureLayout.this.flashModeButton[i2].setVisibility(i2 == 0 ? 0 : 4);
                            AddPostCaptureLayout.this.flashModeButton[i2].setAlpha(i2 == 0 ? 1.0f : 0.0f);
                            AddPostCaptureLayout.this.flashModeButton[i2].setTranslationY(0.0f);
                            i2++;
                        }
                    }
                    AddPostCaptureLayout.this.switchCameraButton.setImageResource(AddPostCaptureLayout.this.cameraView.isFrontface() ? R.drawable.camera_revert1 : R.drawable.camera_revert2);
                    AddPostCaptureLayout.this.switchCameraButton.setVisibility(AddPostCaptureLayout.this.cameraView.hasFrontFaceCamera() ? 0 : 4);
                }
            });
            this.topContainer.removeView(this.cameraView);
            this.topContainer.removeView(this.iconsContainer);
            this.topContainer.addView(this.cameraView, LayoutHelper.createFrame(-1, -1.0f));
            this.topContainer.addView(this.iconsContainer, LayoutHelper.createFrame(-1, -2, 80));
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void endRecordingAndResetState() {
        CameraController.getInstance().stopVideoRecording(this.cameraView.getCameraSession(), false);
        Runnable runnable = this.videoRecordRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
        }
        this.videoRecordProgress.stopProgress();
        this.recordTimeContainer.setVisibility(8);
        this.captureState = CaptureState.VIDEO;
    }

    protected void onPause() {
        if (this.cameraView == null) {
            return;
        }
        if (this.captureState == CaptureState.RECORDING) {
            endRecordingAndResetState();
        }
        this.cameraView.destroy(true, null);
        this.topContainer.removeView(this.cameraView);
        this.topContainer.removeView(this.iconsContainer);
        this.cameraView.setDelegate(null);
        this.cameraView = null;
    }

    protected void onResume() {
        RGHAddPostActivity rGHAddPostActivity = this.parentActivity;
        if (!rGHAddPostActivity.noCameraPermissions && !rGHAddPostActivity.noMicrophonePermissions) {
            if (this.topContainer == null || this.cameraView != null) {
                return;
            }
            initCameraAndCameraView();
            return;
        }
        this.permissionView.setVisibility(0);
    }

    protected void onDestroy() {
        AddPostCameraView addPostCameraView = this.cameraView;
        if (addPostCameraView != null) {
            addPostCameraView.destroy(true, null);
            this.cameraView.setDelegate(null);
            this.cameraView = null;
        }
    }
}
