package ir.eitaa.ui.Components.voip;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.view.TextureView;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.ui.Components.CubicBezierInterpolator;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.MotionBackgroundDrawable;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import org.webrtc.RendererCommon;
import org.webrtc.TextureViewRenderer;

/* loaded from: classes3.dex */
public class VoIPTextureView extends FrameLayout {
    public static int SCALE_TYPE_ADAPTIVE = 2;
    public static int SCALE_TYPE_FILL = 0;
    public static int SCALE_TYPE_FIT = 1;
    public static int SCALE_TYPE_NONE = 3;
    int animateFromHeight;
    float animateFromRendererH;
    float animateFromRendererW;
    float animateFromThumbScale;
    int animateFromWidth;
    float animateFromX;
    float animateFromY;
    long animateNextDuration;
    boolean animateOnNextLayout;
    ArrayList<Animator> animateOnNextLayoutAnimations;
    boolean animateWithParent;
    public float animationProgress;
    float aninateFromScale;
    float aninateFromScaleBlur;
    final boolean applyRotation;
    public View backgroundView;
    public TextureView blurRenderer;
    private View blurredView;
    public Bitmap cameraLastBitmap;
    float clipHorizontal;
    boolean clipToTexture;
    float clipVertical;
    ValueAnimator currentAnimation;
    float currentClipHorizontal;
    float currentClipVertical;
    float currentThumbScale;
    boolean ignoreLayout;
    public final ImageView imageView;
    final boolean isCamera;
    public final TextureViewRenderer renderer;
    float roundRadius;
    public float scaleTextureToFill;
    private float scaleTextureToFillBlur;
    private float scaleThumb;
    public int scaleType;
    private boolean screencast;
    private ImageView screencastImage;
    private TextView screencastText;
    private FrameLayout screencastView;
    public float stubVisibleProgress;
    private Bitmap thumb;

    public VoIPTextureView(Context context, boolean isCamera, boolean applyRotation) {
        this(context, isCamera, applyRotation, true, false);
    }

    public VoIPTextureView(Context context, boolean isCamera, boolean applyRotation, boolean applyRoundRadius, boolean blurBackground) {
        super(context);
        this.stubVisibleProgress = 1.0f;
        this.animateOnNextLayoutAnimations = new ArrayList<>();
        this.aninateFromScale = 1.0f;
        this.aninateFromScaleBlur = 1.0f;
        this.animateFromThumbScale = 1.0f;
        this.isCamera = isCamera;
        this.applyRotation = applyRotation;
        ImageView imageView = new ImageView(context);
        this.imageView = imageView;
        TextureViewRenderer textureViewRenderer = new TextureViewRenderer(context) { // from class: ir.eitaa.ui.Components.voip.VoIPTextureView.1
            @Override // org.webrtc.TextureViewRenderer, org.webrtc.RendererCommon.RendererEvents
            public void onFirstFrameRendered() {
                super.onFirstFrameRendered();
                VoIPTextureView.this.onFirstFrameRendered();
            }
        };
        this.renderer = textureViewRenderer;
        textureViewRenderer.setFpsReduction(30.0f);
        textureViewRenderer.setOpaque(false);
        textureViewRenderer.setEnableHardwareScaler(true);
        textureViewRenderer.setIsCamera(!applyRotation);
        if (!isCamera && applyRotation) {
            View view = new View(context);
            this.backgroundView = view;
            view.setBackgroundColor(-14999773);
            addView(this.backgroundView, LayoutHelper.createFrame(-1, -1.0f));
            if (blurBackground) {
                TextureView textureView = new TextureView(context);
                this.blurRenderer = textureView;
                addView(textureView, LayoutHelper.createFrame(-1, -2, 17));
            }
            textureViewRenderer.setScalingType(RendererCommon.ScalingType.SCALE_ASPECT_FIT);
            addView(textureViewRenderer, LayoutHelper.createFrame(-1, -2, 17));
        } else if (!isCamera) {
            if (blurBackground) {
                TextureView textureView2 = new TextureView(context);
                this.blurRenderer = textureView2;
                addView(textureView2, LayoutHelper.createFrame(-1, -2, 17));
            }
            addView(textureViewRenderer, LayoutHelper.createFrame(-1, -2, 17));
        } else {
            if (blurBackground) {
                TextureView textureView3 = new TextureView(context);
                this.blurRenderer = textureView3;
                addView(textureView3, LayoutHelper.createFrame(-1, -2, 17));
            }
            addView(textureViewRenderer);
        }
        addView(imageView);
        TextureView textureView4 = this.blurRenderer;
        if (textureView4 != null) {
            textureView4.setOpaque(false);
        }
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.screencastView = frameLayout;
        frameLayout.setBackground(new MotionBackgroundDrawable(-14602694, -13935795, -14395293, -14203560, true));
        addView(this.screencastView, LayoutHelper.createFrame(-1, -1.0f));
        this.screencastView.setVisibility(8);
        ImageView imageView2 = new ImageView(getContext());
        this.screencastImage = imageView2;
        imageView2.setScaleType(ImageView.ScaleType.CENTER);
        this.screencastImage.setImageResource(R.drawable.screencast_big);
        this.screencastView.addView(this.screencastImage, LayoutHelper.createFrame(82, 82.0f, 17, 0.0f, 0.0f, 0.0f, 60.0f));
        TextView textView = new TextView(getContext());
        this.screencastText = textView;
        textView.setText(LocaleController.getString("VoipVideoScreenSharing", R.string.VoipVideoScreenSharing));
        this.screencastText.setGravity(17);
        this.screencastText.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
        this.screencastText.setTextColor(-1);
        this.screencastText.setTextSize(1, 15.0f);
        this.screencastText.setTypeface(AndroidUtilities.getFontFamily(true));
        this.screencastView.addView(this.screencastText, LayoutHelper.createFrame(-1, -2.0f, 17, 21.0f, 28.0f, 21.0f, 0.0f));
        if (applyRoundRadius && Build.VERSION.SDK_INT >= 21) {
            setOutlineProvider(new ViewOutlineProvider() { // from class: ir.eitaa.ui.Components.voip.VoIPTextureView.2
                @Override // android.view.ViewOutlineProvider
                @TargetApi(21)
                public void getOutline(View view2, Outline outline) {
                    VoIPTextureView voIPTextureView = VoIPTextureView.this;
                    if (voIPTextureView.roundRadius < 1.0f) {
                        outline.setRect((int) voIPTextureView.currentClipHorizontal, (int) voIPTextureView.currentClipVertical, (int) (view2.getMeasuredWidth() - VoIPTextureView.this.currentClipHorizontal), (int) (view2.getMeasuredHeight() - VoIPTextureView.this.currentClipVertical));
                        return;
                    }
                    int i = (int) voIPTextureView.currentClipHorizontal;
                    int i2 = (int) voIPTextureView.currentClipVertical;
                    int measuredWidth = (int) (view2.getMeasuredWidth() - VoIPTextureView.this.currentClipHorizontal);
                    float measuredHeight = view2.getMeasuredHeight();
                    VoIPTextureView voIPTextureView2 = VoIPTextureView.this;
                    outline.setRoundRect(i, i2, measuredWidth, (int) (measuredHeight - voIPTextureView2.currentClipVertical), voIPTextureView2.roundRadius);
                }
            });
            setClipToOutline(true);
        }
        if (isCamera && this.cameraLastBitmap == null) {
            try {
                Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(new File(ApplicationLoader.getFilesDirFixed(), "voip_icthumb.jpg").getAbsolutePath());
                this.cameraLastBitmap = bitmapDecodeFile;
                if (bitmapDecodeFile == null) {
                    this.cameraLastBitmap = BitmapFactory.decodeFile(new File(ApplicationLoader.getFilesDirFixed(), "icthumb.jpg").getAbsolutePath());
                }
                imageView.setImageBitmap(this.cameraLastBitmap);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            } catch (Throwable unused) {
            }
        }
        if (!applyRotation) {
            this.renderer.setScreenRotation(((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getRotation());
        }
        View view2 = new View(context);
        this.blurredView = view2;
        view2.setVisibility(8);
        addView(this.blurredView, LayoutHelper.createFrame(-1, -1.0f));
    }

    public void setScreenshareMiniProgress(float progress, boolean value) {
        float f;
        if (this.screencast) {
            float scaleX = ((View) getParent()).getScaleX();
            float f2 = 1.0f;
            this.screencastText.setAlpha(1.0f - progress);
            if (value) {
                f = 0.4f * progress;
            } else {
                f2 = 1.0f / scaleX;
                f = (0.4f / scaleX) * progress;
            }
            float f3 = f2 - f;
            this.screencastImage.setScaleX(f3);
            this.screencastImage.setScaleY(f3);
            this.screencastImage.setTranslationY(AndroidUtilities.dp(60.0f) * progress);
        }
    }

    public void setIsScreencast(boolean value) {
        this.screencast = value;
        this.screencastView.setVisibility(value ? 0 : 8);
        if (this.screencast) {
            this.renderer.setVisibility(8);
            TextureView textureView = this.blurRenderer;
            if (textureView != null) {
                textureView.setVisibility(8);
            }
            this.imageView.setVisibility(8);
            return;
        }
        this.renderer.setVisibility(0);
        TextureView textureView2 = this.blurRenderer;
        if (textureView2 != null) {
            textureView2.setVisibility(0);
        }
    }

    protected void onFirstFrameRendered() {
        invalidate();
        if (this.renderer.getAlpha() != 1.0f) {
            this.renderer.animate().setDuration(300L).alpha(1.0f);
        }
        TextureView textureView = this.blurRenderer;
        if (textureView == null || textureView.getAlpha() == 1.0f) {
            return;
        }
        this.blurRenderer.animate().setDuration(300L).alpha(1.0f);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.imageView.getVisibility() == 0 && this.renderer.isFirstFrameRendered()) {
            float f = this.stubVisibleProgress - 0.10666667f;
            this.stubVisibleProgress = f;
            if (f <= 0.0f) {
                this.stubVisibleProgress = 0.0f;
                this.imageView.setVisibility(8);
            } else {
                invalidate();
                this.imageView.setAlpha(this.stubVisibleProgress);
            }
        }
    }

    public void setRoundCorners(float radius) {
        if (this.roundRadius != radius) {
            this.roundRadius = radius;
            if (Build.VERSION.SDK_INT >= 21) {
                invalidateOutline();
            } else {
                invalidate();
            }
        }
    }

    public void saveCameraLastBitmap() {
        Bitmap bitmap = this.renderer.getBitmap(ImageReceiver.DEFAULT_CROSSFADE_DURATION, ImageReceiver.DEFAULT_CROSSFADE_DURATION);
        if (bitmap == null || bitmap.getPixel(0, 0) == 0) {
            return;
        }
        Utilities.blurBitmap(bitmap, 3, 1, bitmap.getWidth(), bitmap.getHeight(), bitmap.getRowBytes());
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(ApplicationLoader.getFilesDirFixed(), "voip_icthumb.jpg"));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.close();
        } catch (Throwable unused) {
        }
    }

    public void setStub(VoIPTextureView from) {
        if (this.screencast) {
            return;
        }
        Bitmap bitmap = from.renderer.getBitmap();
        if (bitmap == null || bitmap.getPixel(0, 0) == 0) {
            this.imageView.setImageDrawable(from.imageView.getDrawable());
        } else {
            this.imageView.setImageBitmap(bitmap);
            this.imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        this.stubVisibleProgress = 1.0f;
        this.imageView.setVisibility(0);
        this.imageView.setAlpha(1.0f);
    }

    public void animateToLayout() {
        if (this.animateOnNextLayout || getMeasuredHeight() == 0 || getMeasuredWidth() == 0) {
            return;
        }
        this.animateFromHeight = getMeasuredHeight();
        this.animateFromWidth = getMeasuredWidth();
        if (this.animateWithParent && getParent() != null) {
            View view = (View) getParent();
            this.animateFromY = view.getY();
            this.animateFromX = view.getX();
        } else {
            this.animateFromY = getY();
            this.animateFromX = getX();
        }
        this.aninateFromScale = this.scaleTextureToFill;
        this.aninateFromScaleBlur = this.scaleTextureToFillBlur;
        this.animateFromThumbScale = this.scaleThumb;
        this.animateFromRendererW = this.renderer.getMeasuredWidth();
        this.animateFromRendererH = this.renderer.getMeasuredHeight();
        this.animateOnNextLayout = true;
        requestLayout();
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
        if (!this.applyRotation) {
            this.ignoreLayout = true;
            this.renderer.setScreenRotation(((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getRotation());
            this.ignoreLayout = false;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        updateRendererSize();
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    protected void updateRendererSize() {
        TextureView textureView = this.blurRenderer;
        if (textureView != null) {
            textureView.getLayoutParams().width = this.renderer.getMeasuredWidth();
            this.blurRenderer.getLayoutParams().height = this.renderer.getMeasuredHeight();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        float top2;
        float left2;
        super.onLayout(changed, left, top, right, bottom);
        if (this.blurRenderer != null) {
            this.scaleTextureToFillBlur = Math.max(getMeasuredHeight() / this.blurRenderer.getMeasuredHeight(), getMeasuredWidth() / this.blurRenderer.getMeasuredWidth());
        }
        if (this.scaleType == SCALE_TYPE_NONE) {
            TextureView textureView = this.blurRenderer;
            if (textureView != null) {
                textureView.setScaleX(this.scaleTextureToFillBlur);
                this.blurRenderer.setScaleY(this.scaleTextureToFillBlur);
                return;
            }
            return;
        }
        if (this.renderer.getMeasuredHeight() == 0 || this.renderer.getMeasuredWidth() == 0 || getMeasuredHeight() == 0 || getMeasuredWidth() == 0) {
            this.scaleTextureToFill = 1.0f;
            if (this.currentAnimation == null && !this.animateOnNextLayout) {
                this.currentClipHorizontal = 0.0f;
                this.currentClipVertical = 0.0f;
            }
        } else {
            int i = this.scaleType;
            if (i == SCALE_TYPE_FILL) {
                this.scaleTextureToFill = Math.max(getMeasuredHeight() / this.renderer.getMeasuredHeight(), getMeasuredWidth() / this.renderer.getMeasuredWidth());
            } else if (i == SCALE_TYPE_ADAPTIVE) {
                if (Math.abs((getMeasuredHeight() / getMeasuredWidth()) - 1.0f) < 0.02f) {
                    this.scaleTextureToFill = Math.max(getMeasuredHeight() / this.renderer.getMeasuredHeight(), getMeasuredWidth() / this.renderer.getMeasuredWidth());
                } else if (getMeasuredWidth() > getMeasuredHeight() && this.renderer.getMeasuredHeight() > this.renderer.getMeasuredWidth()) {
                    this.scaleTextureToFill = Math.max(getMeasuredHeight() / this.renderer.getMeasuredHeight(), (getMeasuredWidth() / 2.0f) / this.renderer.getMeasuredWidth());
                } else {
                    this.scaleTextureToFill = Math.min(getMeasuredHeight() / this.renderer.getMeasuredHeight(), getMeasuredWidth() / this.renderer.getMeasuredWidth());
                }
            } else if (i == SCALE_TYPE_FIT) {
                this.scaleTextureToFill = Math.min(getMeasuredHeight() / this.renderer.getMeasuredHeight(), getMeasuredWidth() / this.renderer.getMeasuredWidth());
                if (this.clipToTexture && !this.animateWithParent && this.currentAnimation == null && !this.animateOnNextLayout) {
                    this.currentClipHorizontal = (getMeasuredWidth() - this.renderer.getMeasuredWidth()) / 2.0f;
                    this.currentClipVertical = (getMeasuredHeight() - this.renderer.getMeasuredHeight()) / 2.0f;
                    if (Build.VERSION.SDK_INT >= 21) {
                        invalidateOutline();
                    }
                }
            }
        }
        if (this.thumb != null) {
            this.scaleThumb = Math.max(getMeasuredWidth() / this.thumb.getWidth(), getMeasuredHeight() / this.thumb.getHeight());
        }
        if (this.animateOnNextLayout) {
            this.aninateFromScale /= this.renderer.getMeasuredWidth() / this.animateFromRendererW;
            this.aninateFromScaleBlur /= this.renderer.getMeasuredWidth() / this.animateFromRendererW;
            this.animateOnNextLayout = false;
            if (this.animateWithParent && getParent() != null) {
                View view = (View) getParent();
                top2 = this.animateFromY - view.getTop();
                left2 = this.animateFromX - view.getLeft();
            } else {
                top2 = this.animateFromY - getTop();
                left2 = this.animateFromX - getLeft();
            }
            this.clipVertical = 0.0f;
            this.clipHorizontal = 0.0f;
            if (this.animateFromHeight != getMeasuredHeight()) {
                float measuredHeight = (getMeasuredHeight() - this.animateFromHeight) / 2.0f;
                this.clipVertical = measuredHeight;
                top2 -= measuredHeight;
            }
            final float f = top2;
            if (this.animateFromWidth != getMeasuredWidth()) {
                float measuredWidth = (getMeasuredWidth() - this.animateFromWidth) / 2.0f;
                this.clipHorizontal = measuredWidth;
                left2 -= measuredWidth;
            }
            final float f2 = left2;
            setTranslationY(f);
            setTranslationX(f2);
            ValueAnimator valueAnimator = this.currentAnimation;
            if (valueAnimator != null) {
                valueAnimator.removeAllListeners();
                this.currentAnimation.cancel();
            }
            this.renderer.setScaleX(this.aninateFromScale);
            this.renderer.setScaleY(this.aninateFromScale);
            TextureView textureView2 = this.blurRenderer;
            if (textureView2 != null) {
                textureView2.setScaleX(this.aninateFromScaleBlur);
                this.blurRenderer.setScaleY(this.aninateFromScaleBlur);
            }
            this.currentClipVertical = this.clipVertical;
            this.currentClipHorizontal = this.clipHorizontal;
            if (Build.VERSION.SDK_INT >= 21) {
                invalidateOutline();
            }
            invalidate();
            final float f3 = this.aninateFromScale;
            final float f4 = this.aninateFromScaleBlur;
            final float f5 = this.animateFromThumbScale;
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.currentAnimation = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.voip.-$$Lambda$VoIPTextureView$XfzaSyLNKkScd6GCQGKY72G-LPE
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    this.f$0.lambda$onLayout$0$VoIPTextureView(f3, f4, f2, f, f5, valueAnimator2);
                }
            });
            long j = this.animateNextDuration;
            if (j != 0) {
                this.currentAnimation.setDuration(j);
            } else {
                this.currentAnimation.setDuration(350L);
            }
            this.currentAnimation.setInterpolator(CubicBezierInterpolator.DEFAULT);
            this.currentAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.voip.VoIPTextureView.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    VoIPTextureView voIPTextureView = VoIPTextureView.this;
                    voIPTextureView.currentClipVertical = 0.0f;
                    voIPTextureView.currentClipHorizontal = 0.0f;
                    voIPTextureView.renderer.setScaleX(voIPTextureView.scaleTextureToFill);
                    VoIPTextureView voIPTextureView2 = VoIPTextureView.this;
                    voIPTextureView2.renderer.setScaleY(voIPTextureView2.scaleTextureToFill);
                    VoIPTextureView voIPTextureView3 = VoIPTextureView.this;
                    TextureView textureView3 = voIPTextureView3.blurRenderer;
                    if (textureView3 != null) {
                        textureView3.setScaleX(voIPTextureView3.scaleTextureToFillBlur);
                        VoIPTextureView voIPTextureView4 = VoIPTextureView.this;
                        voIPTextureView4.blurRenderer.setScaleY(voIPTextureView4.scaleTextureToFillBlur);
                    }
                    VoIPTextureView.this.setTranslationY(0.0f);
                    VoIPTextureView.this.setTranslationX(0.0f);
                    VoIPTextureView voIPTextureView5 = VoIPTextureView.this;
                    voIPTextureView5.currentThumbScale = voIPTextureView5.scaleThumb;
                    VoIPTextureView.this.currentAnimation = null;
                }
            });
            this.currentAnimation.start();
            if (!this.animateOnNextLayoutAnimations.isEmpty()) {
                for (int i2 = 0; i2 < this.animateOnNextLayoutAnimations.size(); i2++) {
                    this.animateOnNextLayoutAnimations.get(i2).start();
                }
            }
            this.animateOnNextLayoutAnimations.clear();
            this.animateNextDuration = 0L;
            return;
        }
        if (this.currentAnimation == null) {
            this.renderer.setScaleX(this.scaleTextureToFill);
            this.renderer.setScaleY(this.scaleTextureToFill);
            TextureView textureView3 = this.blurRenderer;
            if (textureView3 != null) {
                textureView3.setScaleX(this.scaleTextureToFillBlur);
                this.blurRenderer.setScaleY(this.scaleTextureToFillBlur);
            }
            this.currentThumbScale = this.scaleThumb;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onLayout$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onLayout$0$VoIPTextureView(float f, float f2, float f3, float f4, float f5, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        float f6 = 1.0f - fFloatValue;
        this.animationProgress = f6;
        this.currentClipVertical = this.clipVertical * fFloatValue;
        this.currentClipHorizontal = this.clipHorizontal * fFloatValue;
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
        invalidate();
        float f7 = (f * fFloatValue) + (this.scaleTextureToFill * f6);
        this.renderer.setScaleX(f7);
        this.renderer.setScaleY(f7);
        float f8 = (f2 * fFloatValue) + (this.scaleTextureToFillBlur * f6);
        TextureView textureView = this.blurRenderer;
        if (textureView != null) {
            textureView.setScaleX(f8);
            this.blurRenderer.setScaleY(f8);
        }
        setTranslationX(f3 * fFloatValue);
        setTranslationY(f4 * fFloatValue);
        this.currentThumbScale = (f5 * fFloatValue) + (this.scaleThumb * f6);
    }

    public void setAnimateWithParent(boolean b) {
        this.animateWithParent = b;
    }

    public void synchOrRunAnimation(Animator animator) {
        if (this.animateOnNextLayout) {
            this.animateOnNextLayoutAnimations.add(animator);
        } else {
            animator.start();
        }
    }

    public void cancelAnimation() {
        this.animateOnNextLayout = false;
        this.animateNextDuration = 0L;
    }

    public void setAnimateNextDuration(long animateNextDuration) {
        this.animateNextDuration = animateNextDuration;
    }

    public void setThumb(Bitmap thumb) {
        this.thumb = thumb;
    }

    public void attachBackgroundRenderer() {
        TextureView textureView = this.blurRenderer;
        if (textureView != null) {
            this.renderer.setBackgroundRenderer(textureView);
            if (this.renderer.isFirstFrameRendered()) {
                return;
            }
            this.blurRenderer.setAlpha(0.0f);
        }
    }

    public boolean isInAnimation() {
        return this.currentAnimation != null;
    }

    public void updateRotation() {
        if (this.applyRotation) {
            return;
        }
        this.renderer.setScreenRotation(((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getRotation());
    }

    public void setBlurState(boolean state) {
        if (state) {
            prepareBlurBitmap();
        } else {
            this.blurredView.setVisibility(8);
        }
    }

    private void prepareBlurBitmap() {
        TextureViewRenderer textureViewRenderer;
        Bitmap bitmap;
        if (this.blurredView == null || (textureViewRenderer = this.renderer) == null || (bitmap = textureViewRenderer.getBitmap()) == null) {
            return;
        }
        Bitmap bitmapScaleBitmap = Utilities.scaleBitmap(bitmap, 0.16666667f);
        Utilities.stackBlurBitmap(bitmapScaleBitmap, 100);
        this.blurredView.setBackground(new BitmapDrawable(bitmapScaleBitmap));
        this.blurredView.setAlpha(1.0f);
        this.blurredView.setVisibility(0);
    }
}
