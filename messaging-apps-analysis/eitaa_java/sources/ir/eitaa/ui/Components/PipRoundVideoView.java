package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Property;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Keep;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.Bitmaps;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.MediaController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.Theme;
import java.io.IOException;

/* loaded from: classes3.dex */
public class PipRoundVideoView implements NotificationCenter.NotificationCenterDelegate {

    @SuppressLint({"StaticFieldLeak"})
    private static PipRoundVideoView instance;
    private AspectRatioFrameLayout aspectRatioFrameLayout;
    private Bitmap bitmap;
    private int currentAccount;
    private DecelerateInterpolator decelerateInterpolator;
    private AnimatorSet hideShowAnimation;
    private ImageView imageView;
    private Runnable onCloseRunnable;
    private Activity parentActivity;
    private SharedPreferences preferences;
    private RectF rect = new RectF();
    private TextureView textureView;
    private int videoHeight;
    private int videoWidth;
    private WindowManager.LayoutParams windowLayoutParams;
    private WindowManager windowManager;
    private FrameLayout windowView;

    public void show(Activity activity, Runnable closeRunnable) {
        if (activity == null) {
            return;
        }
        instance = this;
        this.onCloseRunnable = closeRunnable;
        FrameLayout frameLayout = new FrameLayout(activity) { // from class: ir.eitaa.ui.Components.PipRoundVideoView.1
            private boolean dragging;
            private boolean startDragging;
            private float startX;
            private float startY;

            @Override // android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent event) {
                if (event.getAction() == 0) {
                    this.startX = event.getRawX();
                    this.startY = event.getRawY();
                    this.startDragging = true;
                }
                return true;
            }

            @Override // android.view.ViewGroup, android.view.ViewParent
            public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
                super.requestDisallowInterceptTouchEvent(disallowIntercept);
            }

            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent event) throws IOException {
                MessageObject playingMessageObject;
                if (!this.startDragging && !this.dragging) {
                    return false;
                }
                float rawX = event.getRawX();
                float rawY = event.getRawY();
                if (event.getAction() == 2) {
                    float f = rawX - this.startX;
                    float f2 = rawY - this.startY;
                    if (this.startDragging) {
                        if (Math.abs(f) >= AndroidUtilities.getPixelsInCM(0.3f, true) || Math.abs(f2) >= AndroidUtilities.getPixelsInCM(0.3f, false)) {
                            this.dragging = true;
                            this.startDragging = false;
                        }
                    } else if (this.dragging) {
                        PipRoundVideoView.this.windowLayoutParams.x = (int) (r6.x + f);
                        PipRoundVideoView.this.windowLayoutParams.y = (int) (r10.y + f2);
                        int i = PipRoundVideoView.this.videoWidth / 2;
                        int i2 = -i;
                        if (PipRoundVideoView.this.windowLayoutParams.x < i2) {
                            PipRoundVideoView.this.windowLayoutParams.x = i2;
                        } else if (PipRoundVideoView.this.windowLayoutParams.x > (AndroidUtilities.displaySize.x - PipRoundVideoView.this.windowLayoutParams.width) + i) {
                            PipRoundVideoView.this.windowLayoutParams.x = (AndroidUtilities.displaySize.x - PipRoundVideoView.this.windowLayoutParams.width) + i;
                        }
                        float f3 = 1.0f;
                        if (PipRoundVideoView.this.windowLayoutParams.x < 0) {
                            f3 = 1.0f + ((PipRoundVideoView.this.windowLayoutParams.x / i) * 0.5f);
                        } else if (PipRoundVideoView.this.windowLayoutParams.x > AndroidUtilities.displaySize.x - PipRoundVideoView.this.windowLayoutParams.width) {
                            f3 = 1.0f - ((((PipRoundVideoView.this.windowLayoutParams.x - AndroidUtilities.displaySize.x) + PipRoundVideoView.this.windowLayoutParams.width) / i) * 0.5f);
                        }
                        if (PipRoundVideoView.this.windowView.getAlpha() != f3) {
                            PipRoundVideoView.this.windowView.setAlpha(f3);
                        }
                        if (PipRoundVideoView.this.windowLayoutParams.y < 0) {
                            PipRoundVideoView.this.windowLayoutParams.y = 0;
                        } else if (PipRoundVideoView.this.windowLayoutParams.y > (AndroidUtilities.displaySize.y - PipRoundVideoView.this.windowLayoutParams.height) + 0) {
                            PipRoundVideoView.this.windowLayoutParams.y = (AndroidUtilities.displaySize.y - PipRoundVideoView.this.windowLayoutParams.height) + 0;
                        }
                        PipRoundVideoView.this.windowManager.updateViewLayout(PipRoundVideoView.this.windowView, PipRoundVideoView.this.windowLayoutParams);
                        this.startX = rawX;
                        this.startY = rawY;
                    }
                } else if (event.getAction() == 1) {
                    if (this.startDragging && !this.dragging && (playingMessageObject = MediaController.getInstance().getPlayingMessageObject()) != null) {
                        if (MediaController.getInstance().isMessagePaused()) {
                            MediaController.getInstance().playMessage(playingMessageObject);
                        } else {
                            MediaController.getInstance().lambda$startAudioAgain$7$MediaController(playingMessageObject);
                        }
                    }
                    this.dragging = false;
                    this.startDragging = false;
                    PipRoundVideoView.this.animateToBoundsMaybe();
                }
                return true;
            }

            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                Drawable drawable = Theme.chat_roundVideoShadow;
                if (drawable != null) {
                    drawable.setAlpha((int) (getAlpha() * 255.0f));
                    Theme.chat_roundVideoShadow.setBounds(AndroidUtilities.dp(1.0f), AndroidUtilities.dp(2.0f), AndroidUtilities.dp(125.0f), AndroidUtilities.dp(125.0f));
                    Theme.chat_roundVideoShadow.draw(canvas);
                    Theme.chat_docBackPaint.setColor(Theme.getColor("chat_inBubble"));
                    Theme.chat_docBackPaint.setAlpha((int) (getAlpha() * 255.0f));
                    canvas.drawCircle(AndroidUtilities.dp(63.0f), AndroidUtilities.dp(63.0f), AndroidUtilities.dp(59.5f), Theme.chat_docBackPaint);
                }
            }
        };
        this.windowView = frameLayout;
        frameLayout.setWillNotDraw(false);
        this.videoWidth = AndroidUtilities.dp(126.0f);
        this.videoHeight = AndroidUtilities.dp(126.0f);
        if (Build.VERSION.SDK_INT >= 21) {
            AspectRatioFrameLayout aspectRatioFrameLayout = new AspectRatioFrameLayout(activity) { // from class: ir.eitaa.ui.Components.PipRoundVideoView.2
                @Override // android.view.ViewGroup
                protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
                    MessageObject playingMessageObject;
                    boolean zDrawChild = super.drawChild(canvas, child, drawingTime);
                    if (child == PipRoundVideoView.this.textureView && (playingMessageObject = MediaController.getInstance().getPlayingMessageObject()) != null) {
                        PipRoundVideoView.this.rect.set(AndroidUtilities.dpf2(1.5f), AndroidUtilities.dpf2(1.5f), getMeasuredWidth() - AndroidUtilities.dpf2(1.5f), getMeasuredHeight() - AndroidUtilities.dpf2(1.5f));
                        canvas.drawArc(PipRoundVideoView.this.rect, -90.0f, playingMessageObject.audioProgress * 360.0f, false, Theme.chat_radialProgressPaint);
                    }
                    return zDrawChild;
                }
            };
            this.aspectRatioFrameLayout = aspectRatioFrameLayout;
            aspectRatioFrameLayout.setOutlineProvider(new ViewOutlineProvider() { // from class: ir.eitaa.ui.Components.PipRoundVideoView.3
                @Override // android.view.ViewOutlineProvider
                @TargetApi(21)
                public void getOutline(View view, Outline outline) {
                    outline.setOval(0, 0, AndroidUtilities.dp(120.0f), AndroidUtilities.dp(120.0f));
                }
            });
            this.aspectRatioFrameLayout.setClipToOutline(true);
        } else {
            final Paint paint = new Paint(1);
            paint.setColor(-16777216);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            AspectRatioFrameLayout aspectRatioFrameLayout2 = new AspectRatioFrameLayout(activity) { // from class: ir.eitaa.ui.Components.PipRoundVideoView.4
                private Path aspectPath = new Path();

                @Override // android.view.View
                protected void onSizeChanged(int w, int h, int oldw, int oldh) {
                    super.onSizeChanged(w, h, oldw, oldh);
                    this.aspectPath.reset();
                    float f = w / 2;
                    this.aspectPath.addCircle(f, h / 2, f, Path.Direction.CW);
                    this.aspectPath.toggleInverseFillType();
                }

                @Override // android.view.ViewGroup, android.view.View
                protected void dispatchDraw(Canvas canvas) {
                    super.dispatchDraw(canvas);
                    canvas.drawPath(this.aspectPath, paint);
                }

                @Override // android.view.ViewGroup
                protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
                    boolean zDrawChild;
                    MessageObject playingMessageObject;
                    try {
                        zDrawChild = super.drawChild(canvas, child, drawingTime);
                    } catch (Throwable unused) {
                        zDrawChild = false;
                    }
                    if (child == PipRoundVideoView.this.textureView && (playingMessageObject = MediaController.getInstance().getPlayingMessageObject()) != null) {
                        PipRoundVideoView.this.rect.set(AndroidUtilities.dpf2(1.5f), AndroidUtilities.dpf2(1.5f), getMeasuredWidth() - AndroidUtilities.dpf2(1.5f), getMeasuredHeight() - AndroidUtilities.dpf2(1.5f));
                        canvas.drawArc(PipRoundVideoView.this.rect, -90.0f, playingMessageObject.audioProgress * 360.0f, false, Theme.chat_radialProgressPaint);
                    }
                    return zDrawChild;
                }
            };
            this.aspectRatioFrameLayout = aspectRatioFrameLayout2;
            aspectRatioFrameLayout2.setLayerType(2, null);
        }
        this.aspectRatioFrameLayout.setAspectRatio(1.0f, 0);
        this.windowView.addView(this.aspectRatioFrameLayout, LayoutHelper.createFrame(R.styleable.AppCompatTheme_windowNoTitle, 120.0f, 51, 3.0f, 3.0f, 0.0f, 0.0f));
        this.windowView.setAlpha(1.0f);
        this.windowView.setScaleX(0.8f);
        this.windowView.setScaleY(0.8f);
        this.textureView = new TextureView(activity);
        float fDpf2 = (AndroidUtilities.dpf2(120.0f) + AndroidUtilities.dpf2(2.0f)) / AndroidUtilities.dpf2(120.0f);
        this.textureView.setScaleX(fDpf2);
        this.textureView.setScaleY(fDpf2);
        this.aspectRatioFrameLayout.addView(this.textureView, LayoutHelper.createFrame(-1, -1.0f));
        ImageView imageView = new ImageView(activity);
        this.imageView = imageView;
        this.aspectRatioFrameLayout.addView(imageView, LayoutHelper.createFrame(-1, -1.0f));
        this.imageView.setVisibility(4);
        this.windowManager = (WindowManager) activity.getSystemService("window");
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
            layoutParams2.type = 99;
            layoutParams2.flags = 16777736;
            this.windowManager.addView(this.windowView, layoutParams2);
            this.parentActivity = activity;
            int i4 = UserConfig.selectedAccount;
            this.currentAccount = i4;
            NotificationCenter.getInstance(i4).addObserver(this, NotificationCenter.messagePlayingProgressDidChanged);
            runShowHideAnimation(true);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    private static int getSideCoord(boolean isX, int side, float p, int sideSize) {
        int i;
        int iRound;
        if (isX) {
            i = AndroidUtilities.displaySize.x;
        } else {
            i = AndroidUtilities.displaySize.y - sideSize;
            sideSize = ActionBar.getCurrentActionBarHeight();
        }
        int i2 = i - sideSize;
        if (side == 0) {
            iRound = AndroidUtilities.dp(10.0f);
        } else if (side == 1) {
            iRound = i2 - AndroidUtilities.dp(10.0f);
        } else {
            iRound = Math.round((i2 - AndroidUtilities.dp(20.0f)) * p) + AndroidUtilities.dp(10.0f);
        }
        return !isX ? iRound + ActionBar.getCurrentActionBarHeight() : iRound;
    }

    @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        AspectRatioFrameLayout aspectRatioFrameLayout;
        if (id != NotificationCenter.messagePlayingProgressDidChanged || (aspectRatioFrameLayout = this.aspectRatioFrameLayout) == null) {
            return;
        }
        aspectRatioFrameLayout.invalidate();
    }

    public TextureView getTextureView() {
        return this.textureView;
    }

    public void close(boolean animated) {
        if (animated) {
            TextureView textureView = this.textureView;
            if (textureView == null || textureView.getParent() == null) {
                return;
            }
            if (this.textureView.getWidth() > 0 && this.textureView.getHeight() > 0) {
                this.bitmap = Bitmaps.createBitmap(this.textureView.getWidth(), this.textureView.getHeight(), Bitmap.Config.ARGB_8888);
            }
            try {
                this.textureView.getBitmap(this.bitmap);
            } catch (Throwable unused) {
                this.bitmap = null;
            }
            this.imageView.setImageBitmap(this.bitmap);
            try {
                this.aspectRatioFrameLayout.removeView(this.textureView);
            } catch (Exception unused2) {
            }
            this.imageView.setVisibility(0);
            runShowHideAnimation(false);
            return;
        }
        if (this.bitmap != null) {
            this.imageView.setImageDrawable(null);
            this.bitmap.recycle();
            this.bitmap = null;
        }
        try {
            this.windowManager.removeView(this.windowView);
        } catch (Exception unused3) {
        }
        if (instance == this) {
            instance = null;
        }
        this.parentActivity = null;
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.messagePlayingProgressDidChanged);
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

    public void showTemporary(boolean show) {
        AnimatorSet animatorSet = this.hideShowAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.hideShowAnimation = animatorSet2;
        Animator[] animatorArr = new Animator[3];
        FrameLayout frameLayout = this.windowView;
        Property property = View.ALPHA;
        float[] fArr = new float[1];
        fArr[0] = show ? 1.0f : 0.0f;
        animatorArr[0] = ObjectAnimator.ofFloat(frameLayout, (Property<FrameLayout, Float>) property, fArr);
        FrameLayout frameLayout2 = this.windowView;
        Property property2 = View.SCALE_X;
        float[] fArr2 = new float[1];
        fArr2[0] = show ? 1.0f : 0.8f;
        animatorArr[1] = ObjectAnimator.ofFloat(frameLayout2, (Property<FrameLayout, Float>) property2, fArr2);
        FrameLayout frameLayout3 = this.windowView;
        Property property3 = View.SCALE_Y;
        float[] fArr3 = new float[1];
        fArr3[0] = show ? 1.0f : 0.8f;
        animatorArr[2] = ObjectAnimator.ofFloat(frameLayout3, (Property<FrameLayout, Float>) property3, fArr3);
        animatorSet2.playTogether(animatorArr);
        this.hideShowAnimation.setDuration(150L);
        if (this.decelerateInterpolator == null) {
            this.decelerateInterpolator = new DecelerateInterpolator();
        }
        this.hideShowAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.PipRoundVideoView.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                if (animation.equals(PipRoundVideoView.this.hideShowAnimation)) {
                    PipRoundVideoView.this.hideShowAnimation = null;
                }
            }
        });
        this.hideShowAnimation.setInterpolator(this.decelerateInterpolator);
        this.hideShowAnimation.start();
    }

    private void runShowHideAnimation(final boolean show) {
        AnimatorSet animatorSet = this.hideShowAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.hideShowAnimation = animatorSet2;
        Animator[] animatorArr = new Animator[3];
        FrameLayout frameLayout = this.windowView;
        Property property = View.ALPHA;
        float[] fArr = new float[1];
        fArr[0] = show ? 1.0f : 0.0f;
        animatorArr[0] = ObjectAnimator.ofFloat(frameLayout, (Property<FrameLayout, Float>) property, fArr);
        FrameLayout frameLayout2 = this.windowView;
        Property property2 = View.SCALE_X;
        float[] fArr2 = new float[1];
        fArr2[0] = show ? 1.0f : 0.8f;
        animatorArr[1] = ObjectAnimator.ofFloat(frameLayout2, (Property<FrameLayout, Float>) property2, fArr2);
        FrameLayout frameLayout3 = this.windowView;
        Property property3 = View.SCALE_Y;
        float[] fArr3 = new float[1];
        fArr3[0] = show ? 1.0f : 0.8f;
        animatorArr[2] = ObjectAnimator.ofFloat(frameLayout3, (Property<FrameLayout, Float>) property3, fArr3);
        animatorSet2.playTogether(animatorArr);
        this.hideShowAnimation.setDuration(150L);
        if (this.decelerateInterpolator == null) {
            this.decelerateInterpolator = new DecelerateInterpolator();
        }
        this.hideShowAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.PipRoundVideoView.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                if (animation.equals(PipRoundVideoView.this.hideShowAnimation)) {
                    if (!show) {
                        PipRoundVideoView.this.close(false);
                    }
                    PipRoundVideoView.this.hideShowAnimation = null;
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                if (animation.equals(PipRoundVideoView.this.hideShowAnimation)) {
                    PipRoundVideoView.this.hideShowAnimation = null;
                }
            }
        });
        this.hideShowAnimation.setInterpolator(this.decelerateInterpolator);
        this.hideShowAnimation.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void animateToBoundsMaybe() {
        /*
            Method dump skipped, instructions count: 435
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.PipRoundVideoView.animateToBoundsMaybe():void");
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

    public static PipRoundVideoView getInstance() {
        return instance;
    }
}
