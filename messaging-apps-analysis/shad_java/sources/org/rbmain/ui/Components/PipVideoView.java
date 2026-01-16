package org.rbmain.ui.Components;

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
import com.google.android.exoplayer2t.ui.AspectRatioFrameLayout;
import ir.medu.shad.R;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.FileLog;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.Components.PipVideoView;
import org.rbmain.ui.PhotoViewer;

/* loaded from: classes5.dex */
public class PipVideoView {
    private AnimatorSet animatorSet;
    private View controlsView;
    private DecelerateInterpolator decelerateInterpolator;
    private boolean isInAppOnly;
    private EmbedBottomSheet parentSheet;
    private PhotoViewer photoViewer;
    private SharedPreferences preferences;
    private int videoHeight;
    private int videoWidth;
    private WindowManager.LayoutParams windowLayoutParams;
    private WindowManager windowManager;
    private FrameLayout windowView;

    /* JADX INFO: Access modifiers changed from: private */
    class MiniControlsView extends FrameLayout {
        private float bufferedPosition;
        private AnimatorSet currentAnimation;
        private Runnable hideRunnable;
        private boolean isCompleted;
        private boolean isVisible;
        private ImageView playButton;
        private float progress;
        private Paint progressInnerPaint;
        private Paint progressPaint;
        private Runnable progressRunnable;

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$new$3(View view, MotionEvent motionEvent) {
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0() {
            show(false, true);
        }

        public MiniControlsView(Context context, boolean z) {
            super(context);
            this.isVisible = true;
            this.hideRunnable = new Runnable() { // from class: org.rbmain.ui.Components.PipVideoView$MiniControlsView$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$0();
                }
            };
            this.progressRunnable = new Runnable() { // from class: org.rbmain.ui.Components.PipVideoView.MiniControlsView.1
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
            imageView.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.PipVideoView$MiniControlsView$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$1(view);
                }
            });
            if (z) {
                Paint paint = new Paint();
                this.progressPaint = paint;
                paint.setColor(-15095832);
                Paint paint2 = new Paint();
                this.progressInnerPaint = paint2;
                paint2.setColor(-6975081);
                setWillNotDraw(false);
                ImageView imageView2 = new ImageView(context);
                this.playButton = imageView2;
                imageView2.setScaleType(ImageView.ScaleType.CENTER);
                addView(this.playButton, LayoutHelper.createFrame(48, 48, 17));
                this.playButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.PipVideoView$MiniControlsView$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$new$2(view);
                    }
                });
            }
            setOnTouchListener(new View.OnTouchListener() { // from class: org.rbmain.ui.Components.PipVideoView$MiniControlsView$$ExternalSyntheticLambda2
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return PipVideoView.MiniControlsView.lambda$new$3(view, motionEvent);
                }
            });
            updatePlayButton();
            show(false, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$1(View view) {
            if (PipVideoView.this.parentSheet != null) {
                PipVideoView.this.parentSheet.exitFromPip();
            } else if (PipVideoView.this.photoViewer != null) {
                PipVideoView.this.photoViewer.exitFromPip();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$2(View view) {
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

        public void setBufferedProgress(float f) {
            this.bufferedPosition = f;
            invalidate();
        }

        public void setProgress(float f) {
            this.progress = f;
            invalidate();
        }

        public void show(boolean z, boolean z2) {
            if (this.isVisible == z) {
                return;
            }
            this.isVisible = z;
            AnimatorSet animatorSet = this.currentAnimation;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            if (this.isVisible) {
                if (z2) {
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    this.currentAnimation = animatorSet2;
                    animatorSet2.playTogether(ObjectAnimator.ofFloat(this, (Property<MiniControlsView, Float>) View.ALPHA, 1.0f));
                    this.currentAnimation.setDuration(150L);
                    this.currentAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.PipVideoView.MiniControlsView.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            MiniControlsView.this.currentAnimation = null;
                        }
                    });
                    this.currentAnimation.start();
                } else {
                    setAlpha(1.0f);
                }
            } else if (z2) {
                AnimatorSet animatorSet3 = new AnimatorSet();
                this.currentAnimation = animatorSet3;
                animatorSet3.playTogether(ObjectAnimator.ofFloat(this, (Property<MiniControlsView, Float>) View.ALPHA, 0.0f));
                this.currentAnimation.setDuration(150L);
                this.currentAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.PipVideoView.MiniControlsView.3
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
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                if (!this.isVisible) {
                    show(true, true);
                    return true;
                }
                checkNeedHide();
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (this.currentAnimation != null) {
                return true;
            }
            return super.onTouchEvent(motionEvent);
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public void requestDisallowInterceptTouchEvent(boolean z) {
            super.requestDisallowInterceptTouchEvent(z);
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

    public PipVideoView(boolean z) {
        this.isInAppOnly = z;
    }

    public TextureView show(Activity activity, EmbedBottomSheet embedBottomSheet, View view, float f, int i, WebView webView) {
        return show(activity, null, embedBottomSheet, view, f, i, webView);
    }

    public TextureView show(Activity activity, PhotoViewer photoViewer, float f, int i) {
        return show(activity, photoViewer, null, null, f, i, null);
    }

    public TextureView show(Activity activity, PhotoViewer photoViewer, EmbedBottomSheet embedBottomSheet, View view, float f, int i, WebView webView) {
        TextureView textureView;
        this.parentSheet = embedBottomSheet;
        this.photoViewer = photoViewer;
        this.windowView = new FrameLayout(activity) { // from class: org.rbmain.ui.Components.PipVideoView.1
            private boolean dragging;
            private float startX;
            private float startY;

            @Override // android.view.ViewGroup, android.view.View
            public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                if (motionEvent.getAction() == 0) {
                    this.startX = rawX;
                    this.startY = rawY;
                } else if (motionEvent.getAction() == 2 && !this.dragging && (Math.abs(this.startX - rawX) >= AndroidUtilities.getPixelsInCM(0.3f, true) || Math.abs(this.startY - rawY) >= AndroidUtilities.getPixelsInCM(0.3f, false))) {
                    this.dragging = true;
                    this.startX = rawX;
                    this.startY = rawY;
                    if (PipVideoView.this.controlsView != null) {
                        ((ViewParent) PipVideoView.this.controlsView).requestDisallowInterceptTouchEvent(true);
                    }
                    return true;
                }
                if (this.dragging) {
                    if (motionEvent.getAction() == 2) {
                        float f2 = rawX - this.startX;
                        float f3 = rawY - this.startY;
                        PipVideoView.this.windowLayoutParams.x = (int) (r6.x + f2);
                        PipVideoView.this.windowLayoutParams.y = (int) (r10.y + f3);
                        int i2 = PipVideoView.this.videoWidth / 2;
                        int i3 = -i2;
                        if (PipVideoView.this.windowLayoutParams.x < i3) {
                            PipVideoView.this.windowLayoutParams.x = i3;
                        } else if (PipVideoView.this.windowLayoutParams.x > (AndroidUtilities.displaySize.x - PipVideoView.this.windowLayoutParams.width) + i2) {
                            PipVideoView.this.windowLayoutParams.x = (AndroidUtilities.displaySize.x - PipVideoView.this.windowLayoutParams.width) + i2;
                        }
                        float f4 = 1.0f;
                        if (PipVideoView.this.windowLayoutParams.x < 0) {
                            f4 = 1.0f + ((PipVideoView.this.windowLayoutParams.x / i2) * 0.5f);
                        } else if (PipVideoView.this.windowLayoutParams.x > AndroidUtilities.displaySize.x - PipVideoView.this.windowLayoutParams.width) {
                            f4 = 1.0f - ((((PipVideoView.this.windowLayoutParams.x - AndroidUtilities.displaySize.x) + PipVideoView.this.windowLayoutParams.width) / i2) * 0.5f);
                        }
                        if (PipVideoView.this.windowView.getAlpha() != f4) {
                            PipVideoView.this.windowView.setAlpha(f4);
                        }
                        if (PipVideoView.this.windowLayoutParams.y < 0) {
                            PipVideoView.this.windowLayoutParams.y = 0;
                        } else if (PipVideoView.this.windowLayoutParams.y > (AndroidUtilities.displaySize.y - PipVideoView.this.windowLayoutParams.height) + 0) {
                            PipVideoView.this.windowLayoutParams.y = (AndroidUtilities.displaySize.y - PipVideoView.this.windowLayoutParams.height) + 0;
                        }
                        PipVideoView.this.windowManager.updateViewLayout(PipVideoView.this.windowView, PipVideoView.this.windowLayoutParams);
                        this.startX = rawX;
                        this.startY = rawY;
                    } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                        this.dragging = false;
                        PipVideoView.this.animateToBoundsMaybe();
                    }
                    return true;
                }
                return super.dispatchTouchEvent(motionEvent);
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
        if (f > 1.0f) {
            int iDp = AndroidUtilities.dp(192.0f);
            this.videoWidth = iDp;
            this.videoHeight = (int) (iDp / f);
        } else {
            int iDp2 = AndroidUtilities.dp(192.0f);
            this.videoHeight = iDp2;
            this.videoWidth = (int) (iDp2 * f);
        }
        AspectRatioFrameLayout aspectRatioFrameLayout = new AspectRatioFrameLayout(activity);
        aspectRatioFrameLayout.setAspectRatio(f, i);
        this.windowView.addView(aspectRatioFrameLayout, LayoutHelper.createFrame(-1, -1, 17));
        if (webView != null) {
            ViewGroup viewGroup = (ViewGroup) webView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(webView);
            }
            aspectRatioFrameLayout.addView(webView, LayoutHelper.createFrame(-1, -1.0f));
            textureView = null;
        } else {
            textureView = new TextureView(activity);
            aspectRatioFrameLayout.addView(textureView, LayoutHelper.createFrame(-1, -1.0f));
        }
        if (view == null) {
            this.controlsView = new MiniControlsView(activity, photoViewer != null);
        } else {
            this.controlsView = view;
        }
        this.windowView.addView(this.controlsView, LayoutHelper.createFrame(-1, -1.0f));
        if (this.isInAppOnly) {
            this.windowManager = activity.getWindowManager();
        } else {
            this.windowManager = (WindowManager) ApplicationLoader.applicationContext.getSystemService("window");
        }
        SharedPreferences sharedPreferences = ApplicationLoader.applicationContext.getSharedPreferences("pipconfig", 0);
        this.preferences = sharedPreferences;
        int i2 = sharedPreferences.getInt("sidex", 1);
        int i3 = this.preferences.getInt("sidey", 0);
        float f2 = this.preferences.getFloat("px", 0.0f);
        float f3 = this.preferences.getFloat("py", 0.0f);
        try {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            this.windowLayoutParams = layoutParams;
            int i4 = this.videoWidth;
            layoutParams.width = i4;
            layoutParams.height = this.videoHeight;
            layoutParams.x = getSideCoord(true, i2, f2, i4);
            this.windowLayoutParams.y = getSideCoord(false, i3, f3, this.videoHeight);
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

    public void setBufferedProgress(float f) {
        View view = this.controlsView;
        if (view instanceof MiniControlsView) {
            ((MiniControlsView) view).setBufferedProgress(f);
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

    private static int getSideCoord(boolean z, int i, float f, int i2) {
        int i3;
        int iRound;
        if (z) {
            i3 = AndroidUtilities.displaySize.x;
        } else {
            i3 = AndroidUtilities.displaySize.y - i2;
            i2 = ActionBar.getCurrentActionBarHeight() + AndroidUtilities.statusBarHeight;
        }
        int i4 = i3 - i2;
        if (i == 0) {
            iRound = AndroidUtilities.dp(10.0f);
        } else if (i == 1) {
            iRound = i4 - AndroidUtilities.dp(10.0f);
        } else {
            iRound = Math.round((i4 - AndroidUtilities.dp(20.0f)) * f) + AndroidUtilities.dp(10.0f);
        }
        return !z ? iRound + ActionBar.getCurrentActionBarHeight() + AndroidUtilities.statusBarHeight : iRound;
    }

    public void close() {
        try {
            this.windowManager.removeView(this.windowView);
        } catch (Exception unused) {
        }
        this.parentSheet = null;
        this.photoViewer = null;
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
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.PipVideoView.animateToBoundsMaybe():void");
    }

    public static Rect getPipRect(float f) {
        int iDp;
        int i;
        SharedPreferences sharedPreferences = ApplicationLoader.applicationContext.getSharedPreferences("pipconfig", 0);
        int i2 = sharedPreferences.getInt("sidex", 1);
        int i3 = sharedPreferences.getInt("sidey", 0);
        float f2 = sharedPreferences.getFloat("px", 0.0f);
        float f3 = sharedPreferences.getFloat("py", 0.0f);
        if (f > 1.0f) {
            iDp = AndroidUtilities.dp(192.0f);
            i = (int) (iDp / f);
        } else {
            int iDp2 = AndroidUtilities.dp(192.0f);
            iDp = (int) (iDp2 * f);
            i = iDp2;
        }
        return new Rect(getSideCoord(true, i2, f2, iDp), getSideCoord(false, i3, f3, i), iDp, i);
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
    public void setX(int i) {
        WindowManager.LayoutParams layoutParams = this.windowLayoutParams;
        layoutParams.x = i;
        try {
            this.windowManager.updateViewLayout(this.windowView, layoutParams);
        } catch (Exception unused) {
        }
    }

    @Keep
    public void setY(int i) {
        WindowManager.LayoutParams layoutParams = this.windowLayoutParams;
        layoutParams.y = i;
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
    public void setWidth(int i) {
        WindowManager.LayoutParams layoutParams = this.windowLayoutParams;
        this.videoWidth = i;
        layoutParams.width = i;
        this.windowManager.updateViewLayout(this.windowView, layoutParams);
    }

    @Keep
    public void setHeight(int i) {
        WindowManager.LayoutParams layoutParams = this.windowLayoutParams;
        this.videoHeight = i;
        layoutParams.height = i;
        this.windowManager.updateViewLayout(this.windowView, layoutParams);
    }
}
