package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.Property;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Keep;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.R;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.Components.PipVideoView;
import ir.eitaa.ui.PhotoViewer;

/* loaded from: classes3.dex */
public class PipVideoView {
    private AnimatorSet animatorSet;
    private View controlsView;
    private DecelerateInterpolator decelerateInterpolator;
    private boolean isInAppOnly;
    private Activity parentActivity;
    private Pipable parentSheet;
    private PhotoViewer photoViewer;
    private SharedPreferences preferences;
    private int videoHeight;
    private int videoWidth;
    private WindowManager.LayoutParams windowLayoutParams;
    private WindowManager windowManager;
    private FrameLayout windowView;

    /* JADX INFO: Access modifiers changed from: private */
    class MiniControlsView extends FrameLayout {
        public ImageView _2x;
        private float bufferedPosition;
        private AnimatorSet currentAnimation;
        private Runnable hideRunnable;
        boolean is2x;
        private boolean isCompleted;
        private boolean isVisible;
        private ImageView playButton;
        private float progress;
        private Paint progressInnerPaint;
        private Paint progressPaint;
        private Runnable progressRunnable;

        static /* synthetic */ boolean lambda$new$3(View view, MotionEvent motionEvent) {
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$0$PipVideoView$MiniControlsView() {
            show(false, true);
        }

        public MiniControlsView(Context context, boolean fullControls) {
            super(context);
            this.isVisible = true;
            this.is2x = false;
            this.hideRunnable = new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$PipVideoView$MiniControlsView$C-bi40wXvIY3eTJu8zOWLtN6-GU
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$0$PipVideoView$MiniControlsView();
                }
            };
            this.progressRunnable = new Runnable() { // from class: ir.eitaa.ui.Components.PipVideoView.MiniControlsView.1
                @Override // java.lang.Runnable
                public void run() {
                    VideoPlayer videoPlayer;
                    if (PipVideoView.this.photoViewer == null || (videoPlayer = PipVideoView.this.photoViewer.getVideoPlayer()) == null) {
                        return;
                    }
                    MiniControlsView.this.setProgress(videoPlayer.getCurrentPosition() / videoPlayer.getDuration());
                    if (PipVideoView.this.photoViewer == null) {
                        MiniControlsView.this.setBufferedProgress(videoPlayer.getBufferedPosition() / videoPlayer.getDuration());
                    }
                    AndroidUtilities.runOnUIThread(MiniControlsView.this.progressRunnable, 1000L);
                }
            };
            ImageView imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            imageView.setImageResource(R.drawable.ic_outinline);
            addView(imageView, LayoutHelper.createFrame(56, 48, 53));
            imageView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$PipVideoView$MiniControlsView$WlvvW-lxr1C0DYyqAFZb1tXJG0w
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$1$PipVideoView$MiniControlsView(view);
                }
            });
            ImageView imageView2 = new ImageView(context);
            this._2x = imageView2;
            imageView2.setScaleType(ImageView.ScaleType.CENTER);
            this._2x.setImageResource(R.drawable.ic_gofullscreen);
            this._2x.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.PipVideoView.MiniControlsView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MiniControlsView.this.go2x(!r2.is2x);
                }
            });
            addView(this._2x, LayoutHelper.createFrame(56, 48, 51));
            if (fullControls) {
                Paint paint = new Paint();
                this.progressPaint = paint;
                paint.setColor(-15095832);
                Paint paint2 = new Paint();
                this.progressInnerPaint = paint2;
                paint2.setColor(-6975081);
                setWillNotDraw(false);
                ImageView imageView3 = new ImageView(context);
                this.playButton = imageView3;
                imageView3.setScaleType(ImageView.ScaleType.CENTER);
                addView(this.playButton, LayoutHelper.createFrame(48, 48, 17));
                this.playButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$PipVideoView$MiniControlsView$m-MSmdhtHFN-wL-0d8mSOOFIf24
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$new$2$PipVideoView$MiniControlsView(view);
                    }
                });
            }
            setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$PipVideoView$MiniControlsView$crBsXGxMZmX2X-ReUxoX7HfA-rc
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return PipVideoView.MiniControlsView.lambda$new$3(view, motionEvent);
                }
            });
            updatePlayButton();
            show(false, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$1$PipVideoView$MiniControlsView(View view) {
            if (PipVideoView.this.parentSheet != null) {
                PipVideoView.this.parentSheet.exitFromPip();
            } else if (PipVideoView.this.photoViewer != null) {
                PipVideoView.this.photoViewer.exitFromPip();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$2$PipVideoView$MiniControlsView(View view) {
            VideoPlayer videoPlayer;
            if (PipVideoView.this.photoViewer == null || (videoPlayer = PipVideoView.this.photoViewer.getVideoPlayer()) == null) {
                return;
            }
            if (videoPlayer.isPlaying()) {
                videoPlayer.pause();
            } else {
                videoPlayer.play();
            }
            updatePlayButton();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void go2x(boolean is2x) {
            float f;
            float f2;
            float f3;
            float f4;
            this.is2x = is2x;
            PipVideoView.this.preferences.edit().putBoolean("is2x", is2x).apply();
            ImageView imageView = this._2x;
            if (imageView != null) {
                imageView.setImageResource(is2x ? R.drawable.ic_outfullscreen : R.drawable.ic_gofullscreen);
            }
            WindowManager.LayoutParams layoutParams = PipVideoView.this.windowLayoutParams;
            float f5 = layoutParams.width;
            float f6 = layoutParams.height;
            float f7 = layoutParams.x;
            float f8 = layoutParams.y;
            if (is2x) {
                f = f7 - (f5 / 2.0f);
                f2 = f8 - (f6 / 2.0f);
                f3 = f5 * 2.0f;
                f4 = f6 * 2.0f;
                int iDp = AndroidUtilities.dp(10.0f);
                int currentActionBarHeight = ActionBar.getCurrentActionBarHeight();
                android.graphics.Point point = AndroidUtilities.displaySize;
                int i = point.x;
                int i2 = iDp * 2;
                int i3 = i - i2;
                int i4 = point.y;
                int i5 = (i4 - i2) - currentActionBarHeight;
                float f9 = i3;
                if (f3 > f9) {
                    f4 *= f9 / f3;
                    f3 = f9;
                }
                float f10 = i5;
                if (f4 > f10) {
                    f3 *= f10 / f4;
                    f4 = f10;
                }
                float f11 = iDp;
                if (f < f11) {
                    f = f11;
                } else if (f + f3 + f11 > i) {
                    f = (i - f3) - f11;
                }
                float f12 = iDp + currentActionBarHeight;
                if (f2 < f12) {
                    f2 = f12;
                } else if (f2 + f4 + f11 > i4) {
                    f2 = (i4 - f4) - f11;
                }
            } else {
                f = f7 + (f5 / 4.0f);
                f2 = f8 + (f6 / 4.0f);
                f3 = f5 / 2.0f;
                f4 = f6 / 2.0f;
            }
            PipVideoView.this.videoWidth = (int) f3;
            PipVideoView.this.videoHeight = (int) f4;
            layoutParams.width = PipVideoView.this.videoWidth;
            layoutParams.height = PipVideoView.this.videoHeight;
            layoutParams.x = (int) f;
            layoutParams.y = (int) f2;
            PipVideoView.this.windowManager.updateViewLayout(PipVideoView.this.windowView, PipVideoView.this.windowLayoutParams);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updatePlayButton() {
            VideoPlayer videoPlayer;
            if (PipVideoView.this.photoViewer == null || (videoPlayer = PipVideoView.this.photoViewer.getVideoPlayer()) == null) {
                return;
            }
            AndroidUtilities.cancelRunOnUIThread(this.progressRunnable);
            if (!videoPlayer.isPlaying()) {
                if (this.isCompleted) {
                    this.playButton.setImageResource(R.drawable.ic_againinline);
                    return;
                } else {
                    this.playButton.setImageResource(R.drawable.ic_playinline);
                    return;
                }
            }
            this.playButton.setImageResource(R.drawable.ic_pauseinline);
            AndroidUtilities.runOnUIThread(this.progressRunnable, 500L);
        }

        public void setBufferedProgress(float position) {
            this.bufferedPosition = position;
            invalidate();
        }

        public void setProgress(float value) {
            this.progress = value;
            invalidate();
        }

        public void show(boolean value, boolean animated) {
            if (this.isVisible == value) {
                return;
            }
            this.isVisible = value;
            AnimatorSet animatorSet = this.currentAnimation;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            if (this.isVisible) {
                if (animated) {
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    this.currentAnimation = animatorSet2;
                    animatorSet2.playTogether(ObjectAnimator.ofFloat(this, (Property<MiniControlsView, Float>) View.ALPHA, 1.0f));
                    this.currentAnimation.setDuration(150L);
                    this.currentAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.PipVideoView.MiniControlsView.3
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            MiniControlsView.this.currentAnimation = null;
                        }
                    });
                    this.currentAnimation.start();
                } else {
                    setAlpha(1.0f);
                }
            } else if (animated) {
                AnimatorSet animatorSet3 = new AnimatorSet();
                this.currentAnimation = animatorSet3;
                animatorSet3.playTogether(ObjectAnimator.ofFloat(this, (Property<MiniControlsView, Float>) View.ALPHA, 0.0f));
                this.currentAnimation.setDuration(150L);
                this.currentAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.PipVideoView.MiniControlsView.4
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        MiniControlsView.this.currentAnimation = null;
                    }
                });
                this.currentAnimation.start();
            } else {
                setAlpha(0.0f);
            }
            checkNeedHide();
        }

        private void checkNeedHide() {
            AndroidUtilities.cancelRunOnUIThread(this.hideRunnable);
            if (this.isVisible) {
                AndroidUtilities.runOnUIThread(this.hideRunnable, 3000L);
            }
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent ev) {
            if (ev.getAction() == 0) {
                if (!this.isVisible) {
                    show(true, true);
                    return true;
                }
                checkNeedHide();
            }
            return super.onInterceptTouchEvent(ev);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent event) {
            if (this.currentAnimation != null) {
                return true;
            }
            return super.onTouchEvent(event);
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
            super.requestDisallowInterceptTouchEvent(disallowIntercept);
            checkNeedHide();
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            checkNeedHide();
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight() - AndroidUtilities.dp(3.0f);
            AndroidUtilities.dp(7.0f);
            float f = measuredWidth - 0;
            int i = ((int) (this.progress * f)) + 0;
            float f2 = this.bufferedPosition;
            if (f2 != 0.0f) {
                float f3 = 0;
                canvas.drawRect(f3, measuredHeight, f3 + (f * f2), AndroidUtilities.dp(3.0f) + measuredHeight, this.progressInnerPaint);
            }
            canvas.drawRect(0, measuredHeight, i, measuredHeight + AndroidUtilities.dp(3.0f), this.progressPaint);
        }
    }

    public PipVideoView(boolean inAppOnly) {
        this.isInAppOnly = inAppOnly;
    }

    public TextureView show(Activity activity, Pipable sheet, View controls, float aspectRatio, int rotation, View innerView) {
        return show(activity, null, sheet, controls, aspectRatio, rotation, innerView);
    }

    public TextureView show(Activity activity, PhotoViewer viewer, float aspectRatio, int rotation, WebView webview) {
        return show(activity, viewer, null, null, aspectRatio, rotation, webview);
    }

    public TextureView show(Activity activity, PhotoViewer viewer, float aspectRatio, int rotation) {
        return show(activity, viewer, null, null, aspectRatio, rotation, null);
    }

    public TextureView show(Activity activity, PhotoViewer viewer, Pipable sheet, View controls, float aspectRatio, int rotation, View innerView) {
        TextureView textureView;
        this.parentSheet = sheet;
        this.parentActivity = activity;
        this.photoViewer = viewer;
        this.windowView = new FrameLayout(activity) { // from class: ir.eitaa.ui.Components.PipVideoView.1
            private boolean dragging;
            private float startX;
            private float startY;

            @Override // android.view.ViewGroup, android.view.View
            public boolean dispatchTouchEvent(MotionEvent event) {
                float rawX = event.getRawX();
                float rawY = event.getRawY();
                if (event.getAction() == 0) {
                    this.startX = rawX;
                    this.startY = rawY;
                } else if (event.getAction() == 2 && !this.dragging && (Math.abs(this.startX - rawX) >= AndroidUtilities.getPixelsInCM(0.3f, true) || Math.abs(this.startY - rawY) >= AndroidUtilities.getPixelsInCM(0.3f, false))) {
                    this.dragging = true;
                    this.startX = rawX;
                    this.startY = rawY;
                    if (PipVideoView.this.controlsView != null) {
                        ((ViewParent) PipVideoView.this.controlsView).requestDisallowInterceptTouchEvent(true);
                    }
                    return true;
                }
                if (this.dragging) {
                    if (event.getAction() == 2) {
                        float f = rawX - this.startX;
                        float f2 = rawY - this.startY;
                        PipVideoView.this.windowLayoutParams.x = (int) (r6.x + f);
                        PipVideoView.this.windowLayoutParams.y = (int) (r10.y + f2);
                        int i = PipVideoView.this.videoWidth / 2;
                        int i2 = -i;
                        if (PipVideoView.this.windowLayoutParams.x < i2) {
                            PipVideoView.this.windowLayoutParams.x = i2;
                        } else if (PipVideoView.this.windowLayoutParams.x > (AndroidUtilities.displaySize.x - PipVideoView.this.windowLayoutParams.width) + i) {
                            PipVideoView.this.windowLayoutParams.x = (AndroidUtilities.displaySize.x - PipVideoView.this.windowLayoutParams.width) + i;
                        }
                        float f3 = 1.0f;
                        if (PipVideoView.this.windowLayoutParams.x < 0) {
                            f3 = 1.0f + ((PipVideoView.this.windowLayoutParams.x / i) * 0.5f);
                        } else if (PipVideoView.this.windowLayoutParams.x > AndroidUtilities.displaySize.x - PipVideoView.this.windowLayoutParams.width) {
                            f3 = 1.0f - ((((PipVideoView.this.windowLayoutParams.x - AndroidUtilities.displaySize.x) + PipVideoView.this.windowLayoutParams.width) / i) * 0.5f);
                        }
                        if (PipVideoView.this.windowView.getAlpha() != f3) {
                            PipVideoView.this.windowView.setAlpha(f3);
                        }
                        if (PipVideoView.this.windowLayoutParams.y < 0) {
                            PipVideoView.this.windowLayoutParams.y = 0;
                        } else if (PipVideoView.this.windowLayoutParams.y > (AndroidUtilities.displaySize.y - PipVideoView.this.windowLayoutParams.height) + 0) {
                            PipVideoView.this.windowLayoutParams.y = (AndroidUtilities.displaySize.y - PipVideoView.this.windowLayoutParams.height) + 0;
                        }
                        PipVideoView.this.windowManager.updateViewLayout(PipVideoView.this.windowView, PipVideoView.this.windowLayoutParams);
                        this.startX = rawX;
                        this.startY = rawY;
                    } else if (event.getAction() == 1 || event.getAction() == 3) {
                        this.dragging = false;
                        PipVideoView.this.animateToBoundsMaybe();
                    }
                    return true;
                }
                return super.dispatchTouchEvent(event);
            }

            @Override // android.view.ViewGroup, android.view.View
            protected void onDetachedFromWindow() {
                super.onDetachedFromWindow();
                if (PipVideoView.this.animatorSet != null) {
                    PipVideoView.this.animatorSet.cancel();
                    PipVideoView.this.animatorSet = null;
                }
            }
        };
        if (aspectRatio > 1.0f) {
            int iDp = AndroidUtilities.dp(192.0f);
            this.videoWidth = iDp;
            this.videoHeight = (int) (iDp / aspectRatio);
        } else {
            int iDp2 = AndroidUtilities.dp(192.0f);
            this.videoHeight = iDp2;
            this.videoWidth = (int) (iDp2 * aspectRatio);
        }
        AspectRatioFrameLayout aspectRatioFrameLayout = new AspectRatioFrameLayout(activity);
        aspectRatioFrameLayout.setAspectRatio(aspectRatio, rotation);
        this.windowView.addView(aspectRatioFrameLayout, LayoutHelper.createFrame(-1, -1, 17));
        if (innerView != null) {
            ViewGroup viewGroup = (ViewGroup) innerView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(innerView);
            }
            aspectRatioFrameLayout.addView(innerView, LayoutHelper.createFrame(-1, -1.0f));
            textureView = null;
        } else {
            textureView = new TextureView(activity);
            aspectRatioFrameLayout.addView(textureView, LayoutHelper.createFrame(-1, -1.0f));
        }
        if (controls == null) {
            this.controlsView = new MiniControlsView(activity, viewer != null);
        } else {
            this.controlsView = controls;
        }
        this.windowView.addView(this.controlsView, LayoutHelper.createFrame(-1, -1.0f));
        if (this.isInAppOnly) {
            this.windowManager = activity.getWindowManager();
        } else {
            this.windowManager = (WindowManager) ApplicationLoader.applicationContext.getSystemService("window");
        }
        SharedPreferences sharedPreferences = ApplicationLoader.applicationContext.getSharedPreferences("pipconfig", 0);
        this.preferences = sharedPreferences;
        int i = sharedPreferences.getInt("sidex", 1);
        int i2 = this.preferences.getInt("sidey", 0);
        float f = this.preferences.getFloat("px", 0.0f);
        float f2 = this.preferences.getFloat("py", 0.0f);
        try {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            this.windowLayoutParams = layoutParams;
            int i3 = this.videoWidth;
            layoutParams.width = i3;
            layoutParams.height = this.videoHeight;
            layoutParams.x = getSideCoord(true, i, f, i3);
            this.windowLayoutParams.y = getSideCoord(false, i2, f2, this.videoHeight);
            WindowManager.LayoutParams layoutParams2 = this.windowLayoutParams;
            layoutParams2.format = -3;
            layoutParams2.gravity = 51;
            if (this.isInAppOnly) {
                layoutParams2.type = 99;
            } else if (Build.VERSION.SDK_INT >= 26) {
                layoutParams2.type = 2038;
            } else {
                layoutParams2.type = 2003;
            }
            layoutParams2.flags = 16777992;
            this.windowManager.addView(this.windowView, layoutParams2);
            return textureView;
        } catch (Exception e) {
            FileLog.e(e);
            return null;
        }
    }

    public void onVideoCompleted() {
        View view = this.controlsView;
        if (view instanceof MiniControlsView) {
            MiniControlsView miniControlsView = (MiniControlsView) view;
            miniControlsView.isCompleted = true;
            miniControlsView.progress = 0.0f;
            miniControlsView.bufferedPosition = 0.0f;
            miniControlsView.updatePlayButton();
            miniControlsView.invalidate();
            miniControlsView.show(true, true);
        }
    }

    public void setBufferedProgress(float progress) {
        View view = this.controlsView;
        if (view instanceof MiniControlsView) {
            ((MiniControlsView) view).setBufferedProgress(progress);
        }
    }

    public void updatePlayButton() {
        View view = this.controlsView;
        if (view instanceof MiniControlsView) {
            MiniControlsView miniControlsView = (MiniControlsView) view;
            miniControlsView.updatePlayButton();
            miniControlsView.invalidate();
        }
    }

    private static int getSideCoord(boolean isX, int side, float p, int sideSize) {
        int i;
        int iRound;
        if (isX) {
            i = AndroidUtilities.displaySize.x;
        } else {
            i = AndroidUtilities.displaySize.y - sideSize;
            sideSize = ActionBar.getCurrentActionBarHeight() + AndroidUtilities.statusBarHeight;
        }
        int i2 = i - sideSize;
        if (side == 0) {
            iRound = AndroidUtilities.dp(10.0f);
        } else if (side == 1) {
            iRound = i2 - AndroidUtilities.dp(10.0f);
        } else {
            iRound = Math.round((i2 - AndroidUtilities.dp(20.0f)) * p) + AndroidUtilities.dp(10.0f);
        }
        return !isX ? iRound + ActionBar.getCurrentActionBarHeight() + AndroidUtilities.statusBarHeight : iRound;
    }

    public void close() {
        try {
            this.windowManager.removeView(this.windowView);
        } catch (Exception unused) {
        }
        this.parentSheet = null;
        this.photoViewer = null;
        this.parentActivity = null;
    }

    public void onConfigurationChanged() {
        int i = this.preferences.getInt("sidex", 1);
        int i2 = this.preferences.getInt("sidey", 0);
        float f = this.preferences.getFloat("px", 0.0f);
        float f2 = this.preferences.getFloat("py", 0.0f);
        this.windowLayoutParams.x = getSideCoord(true, i, f, this.videoWidth);
        this.windowLayoutParams.y = getSideCoord(false, i2, f2, this.videoHeight);
        this.windowManager.updateViewLayout(this.windowView, this.windowLayoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void animateToBoundsMaybe() {
        /*
            Method dump skipped, instructions count: 448
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.PipVideoView.animateToBoundsMaybe():void");
    }

    public static Rect getPipRect(float aspectRatio) {
        int iDp;
        int i;
        SharedPreferences sharedPreferences = ApplicationLoader.applicationContext.getSharedPreferences("pipconfig", 0);
        int i2 = sharedPreferences.getInt("sidex", 1);
        int i3 = sharedPreferences.getInt("sidey", 0);
        float f = sharedPreferences.getFloat("px", 0.0f);
        float f2 = sharedPreferences.getFloat("py", 0.0f);
        if (aspectRatio > 1.0f) {
            iDp = AndroidUtilities.dp(192.0f);
            i = (int) (iDp / aspectRatio);
        } else {
            int iDp2 = AndroidUtilities.dp(192.0f);
            iDp = (int) (iDp2 * aspectRatio);
            i = iDp2;
        }
        return new Rect(getSideCoord(true, i2, f, iDp), getSideCoord(false, i3, f2, i), iDp, i);
    }

    @Keep
    public int getX() {
        return this.windowLayoutParams.x;
    }

    @Keep
    public int getY() {
        return this.windowLayoutParams.y;
    }

    @Keep
    public void setX(int value) {
        WindowManager.LayoutParams layoutParams = this.windowLayoutParams;
        layoutParams.x = value;
        try {
            this.windowManager.updateViewLayout(this.windowView, layoutParams);
        } catch (Exception unused) {
        }
    }

    @Keep
    public void setY(int value) {
        WindowManager.LayoutParams layoutParams = this.windowLayoutParams;
        layoutParams.y = value;
        try {
            this.windowManager.updateViewLayout(this.windowView, layoutParams);
        } catch (Exception unused) {
        }
    }

    @Keep
    public int getWidth() {
        return this.windowLayoutParams.width;
    }

    @Keep
    public int getHeight() {
        return this.windowLayoutParams.height;
    }

    @Keep
    public void setWidth(int value) {
        WindowManager.LayoutParams layoutParams = this.windowLayoutParams;
        this.videoWidth = value;
        layoutParams.width = value;
        this.windowManager.updateViewLayout(this.windowView, layoutParams);
    }

    @Keep
    public void setHeight(int value) {
        WindowManager.LayoutParams layoutParams = this.windowLayoutParams;
        this.videoHeight = value;
        layoutParams.height = value;
        this.windowManager.updateViewLayout(this.windowView, layoutParams);
    }
}
