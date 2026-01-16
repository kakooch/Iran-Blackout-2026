package ir.eitaa.ui.Components;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import android.widget.FrameLayout;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.ActionBarLayout;
import ir.eitaa.ui.ActionBar.AdjustPanLayoutHelper;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.WallpaperParallaxEffect;

/* loaded from: classes3.dex */
public class SizeNotifierFrameLayout extends FrameLayout {
    protected AdjustPanLayoutHelper adjustPanLayoutHelper;
    private boolean animationInProgress;
    private Drawable backgroundDrawable;
    private int backgroundTranslationY;
    private float bgAngle;
    private int bottomClip;
    private SizeNotifierFrameLayoutDelegate delegate;
    private int emojiHeight;
    private float emojiOffset;
    protected int keyboardHeight;
    private boolean occupyStatusBar;
    private Drawable oldBackgroundDrawable;
    private WallpaperParallaxEffect parallaxEffect;
    private float parallaxScale;
    private ActionBarLayout parentLayout;
    private boolean paused;
    private android.graphics.Rect rect;
    private boolean skipBackgroundDrawing;
    private float translationX;
    private float translationY;

    public interface SizeNotifierFrameLayoutDelegate {
        void onSizeChanged(int keyboardHeight, boolean isWidthGreater);
    }

    protected AdjustPanLayoutHelper createAdjustPanLayoutHelper() {
        return null;
    }

    protected boolean isActionBarVisible() {
        return true;
    }

    public SizeNotifierFrameLayout(Context context) {
        this(context, null);
    }

    public SizeNotifierFrameLayout(Context context, ActionBarLayout layout) {
        super(context);
        this.rect = new android.graphics.Rect();
        this.occupyStatusBar = true;
        this.parallaxScale = 1.0f;
        this.paused = true;
        setWillNotDraw(false);
        this.parentLayout = layout;
        this.adjustPanLayoutHelper = createAdjustPanLayoutHelper();
    }

    public void setBackgroundImage(Drawable bitmap, boolean motion) {
        if (this.backgroundDrawable == bitmap) {
            return;
        }
        if (bitmap instanceof MotionBackgroundDrawable) {
            ((MotionBackgroundDrawable) bitmap).setParentView(this);
        }
        this.backgroundDrawable = bitmap;
        if (motion) {
            if (this.parallaxEffect == null) {
                WallpaperParallaxEffect wallpaperParallaxEffect = new WallpaperParallaxEffect(getContext());
                this.parallaxEffect = wallpaperParallaxEffect;
                wallpaperParallaxEffect.setCallback(new WallpaperParallaxEffect.Callback() { // from class: ir.eitaa.ui.Components.-$$Lambda$SizeNotifierFrameLayout$CzzBQus-_VBX7B7enEx3i9JSVpI
                    @Override // ir.eitaa.ui.Components.WallpaperParallaxEffect.Callback
                    public final void onOffsetsChanged(int i, int i2, float f) {
                        this.f$0.lambda$setBackgroundImage$0$SizeNotifierFrameLayout(i, i2, f);
                    }
                });
                if (getMeasuredWidth() != 0 && getMeasuredHeight() != 0) {
                    this.parallaxScale = this.parallaxEffect.getScale(getMeasuredWidth(), getMeasuredHeight());
                }
            }
            if (!this.paused) {
                this.parallaxEffect.setEnabled(true);
            }
        } else {
            WallpaperParallaxEffect wallpaperParallaxEffect2 = this.parallaxEffect;
            if (wallpaperParallaxEffect2 != null) {
                wallpaperParallaxEffect2.setEnabled(false);
                this.parallaxEffect = null;
                this.parallaxScale = 1.0f;
                this.translationX = 0.0f;
                this.translationY = 0.0f;
            }
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setBackgroundImage$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setBackgroundImage$0$SizeNotifierFrameLayout(int i, int i2, float f) {
        this.translationX = i;
        this.translationY = i2;
        this.bgAngle = f;
        invalidate();
    }

    public Drawable getBackgroundImage() {
        return this.backgroundDrawable;
    }

    public void setDelegate(SizeNotifierFrameLayoutDelegate delegate) {
        this.delegate = delegate;
    }

    public void setOccupyStatusBar(boolean value) {
        this.occupyStatusBar = value;
    }

    public void onPause() {
        WallpaperParallaxEffect wallpaperParallaxEffect = this.parallaxEffect;
        if (wallpaperParallaxEffect != null) {
            wallpaperParallaxEffect.setEnabled(false);
        }
        this.paused = true;
    }

    public void onResume() {
        WallpaperParallaxEffect wallpaperParallaxEffect = this.parallaxEffect;
        if (wallpaperParallaxEffect != null) {
            wallpaperParallaxEffect.setEnabled(true);
        }
        this.paused = false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        notifyHeightChanged();
    }

    public int measureKeyboardHeight() {
        View rootView = getRootView();
        getWindowVisibleDisplayFrame(this.rect);
        android.graphics.Rect rect = this.rect;
        if (rect.bottom == 0 && rect.top == 0) {
            return 0;
        }
        int height = (rootView.getHeight() - (this.rect.top != 0 ? AndroidUtilities.statusBarHeight : 0)) - AndroidUtilities.getViewInset(rootView);
        android.graphics.Rect rect2 = this.rect;
        int iMax = Math.max(0, height - (rect2.bottom - rect2.top));
        this.keyboardHeight = iMax;
        return iMax;
    }

    public int getKeyboardHeight() {
        return this.keyboardHeight;
    }

    public void notifyHeightChanged() {
        WallpaperParallaxEffect wallpaperParallaxEffect = this.parallaxEffect;
        if (wallpaperParallaxEffect != null) {
            this.parallaxScale = wallpaperParallaxEffect.getScale(getMeasuredWidth(), getMeasuredHeight());
        }
        if (this.delegate != null) {
            this.keyboardHeight = measureKeyboardHeight();
            android.graphics.Point point = AndroidUtilities.displaySize;
            final boolean z = point.x > point.y;
            post(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$SizeNotifierFrameLayout$K1t5vHIarJnmvZ8hIQKwQoS5zWo
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$notifyHeightChanged$1$SizeNotifierFrameLayout(z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$notifyHeightChanged$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$notifyHeightChanged$1$SizeNotifierFrameLayout(boolean z) {
        SizeNotifierFrameLayoutDelegate sizeNotifierFrameLayoutDelegate = this.delegate;
        if (sizeNotifierFrameLayoutDelegate != null) {
            sizeNotifierFrameLayoutDelegate.onSizeChanged(this.keyboardHeight, z);
        }
    }

    public void setBottomClip(int value) {
        this.bottomClip = value;
    }

    public void setBackgroundTranslation(int translation) {
        this.backgroundTranslationY = translation;
    }

    public int getBackgroundTranslationY() {
        if (!(this.backgroundDrawable instanceof MotionBackgroundDrawable)) {
            return 0;
        }
        if (this.animationInProgress) {
            return (int) this.emojiOffset;
        }
        int i = this.emojiHeight;
        return i != 0 ? i : this.backgroundTranslationY;
    }

    public int getBackgroundSizeY() {
        Drawable drawable = this.backgroundDrawable;
        int i = 0;
        if (drawable instanceof MotionBackgroundDrawable) {
            if (!((MotionBackgroundDrawable) drawable).hasPattern()) {
                if (this.animationInProgress) {
                    i = (int) this.emojiOffset;
                } else {
                    i = this.emojiHeight;
                    if (i == 0) {
                        i = this.backgroundTranslationY;
                    }
                }
            } else if (this.backgroundTranslationY == 0) {
                i = -this.keyboardHeight;
            }
        }
        return getMeasuredHeight() - i;
    }

    public int getHeightWithKeyboard() {
        return this.keyboardHeight + getMeasuredHeight();
    }

    public void setEmojiKeyboardHeight(int height) {
        this.emojiHeight = height;
    }

    public void setEmojiOffset(boolean animInProgress, float offset) {
        this.emojiOffset = offset;
        this.animationInProgress = animInProgress;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.backgroundDrawable == null || this.skipBackgroundDrawing) {
            super.onDraw(canvas);
            return;
        }
        Drawable newDrawable = getNewDrawable();
        if (newDrawable != this.backgroundDrawable && newDrawable != null) {
            if (Theme.isAnimatingColor()) {
                this.oldBackgroundDrawable = this.backgroundDrawable;
            }
            if (newDrawable instanceof MotionBackgroundDrawable) {
                ((MotionBackgroundDrawable) newDrawable).setParentView(this);
            }
            this.backgroundDrawable = newDrawable;
        }
        ActionBarLayout actionBarLayout = this.parentLayout;
        float themeAnimationValue = actionBarLayout != null ? actionBarLayout.getThemeAnimationValue() : 1.0f;
        int i = 0;
        while (i < 2) {
            Drawable drawable = i == 0 ? this.oldBackgroundDrawable : this.backgroundDrawable;
            if (drawable != null) {
                if (i == 1 && this.oldBackgroundDrawable != null && this.parentLayout != null) {
                    drawable.setAlpha((int) (255.0f * themeAnimationValue));
                } else {
                    drawable.setAlpha(255);
                }
                if (drawable instanceof MotionBackgroundDrawable) {
                    MotionBackgroundDrawable motionBackgroundDrawable = (MotionBackgroundDrawable) drawable;
                    if (motionBackgroundDrawable.hasPattern()) {
                        int currentActionBarHeight = (isActionBarVisible() ? ActionBar.getCurrentActionBarHeight() : 0) + ((Build.VERSION.SDK_INT < 21 || !this.occupyStatusBar) ? 0 : AndroidUtilities.statusBarHeight);
                        int measuredHeight = getRootView().getMeasuredHeight() - currentActionBarHeight;
                        float fMax = Math.max(getMeasuredWidth() / drawable.getIntrinsicWidth(), measuredHeight / drawable.getIntrinsicHeight());
                        int iCeil = (int) Math.ceil(drawable.getIntrinsicWidth() * fMax * this.parallaxScale);
                        int iCeil2 = (int) Math.ceil(drawable.getIntrinsicHeight() * fMax * this.parallaxScale);
                        int measuredWidth = ((getMeasuredWidth() - iCeil) / 2) + ((int) this.translationX);
                        int i2 = this.backgroundTranslationY + ((measuredHeight - iCeil2) / 2) + currentActionBarHeight + ((int) this.translationY);
                        canvas.save();
                        canvas.clipRect(0, currentActionBarHeight, iCeil, getMeasuredHeight() - this.bottomClip);
                        drawable.setBounds(measuredWidth, i2, iCeil + measuredWidth, iCeil2 + i2);
                        drawable.draw(canvas);
                        canvas.restore();
                    } else {
                        if (this.bottomClip != 0) {
                            canvas.save();
                            canvas.clipRect(0, 0, getMeasuredWidth(), getRootView().getMeasuredHeight() - this.bottomClip);
                        }
                        motionBackgroundDrawable.setTranslationY(this.backgroundTranslationY);
                        int measuredHeight2 = getMeasuredHeight() - this.backgroundTranslationY;
                        if (this.animationInProgress) {
                            measuredHeight2 = (int) (measuredHeight2 - this.emojiOffset);
                        } else {
                            int i3 = this.emojiHeight;
                            if (i3 != 0) {
                                measuredHeight2 -= i3;
                            }
                        }
                        drawable.setBounds(0, 0, getMeasuredWidth(), measuredHeight2);
                        drawable.draw(canvas);
                        if (this.bottomClip != 0) {
                            canvas.restore();
                        }
                    }
                } else if (drawable instanceof ColorDrawable) {
                    if (this.bottomClip != 0) {
                        canvas.save();
                        canvas.clipRect(0, 0, getMeasuredWidth(), getMeasuredHeight() - this.bottomClip);
                    }
                    drawable.setBounds(0, 0, getMeasuredWidth(), getRootView().getMeasuredHeight());
                    drawable.draw(canvas);
                    if (this.bottomClip != 0) {
                        canvas.restore();
                    }
                } else if (drawable instanceof GradientDrawable) {
                    if (this.bottomClip != 0) {
                        canvas.save();
                        canvas.clipRect(0, 0, getMeasuredWidth(), getRootView().getMeasuredHeight() - this.bottomClip);
                    }
                    drawable.setBounds(0, this.backgroundTranslationY, getMeasuredWidth(), this.backgroundTranslationY + getRootView().getMeasuredHeight());
                    drawable.draw(canvas);
                    if (this.bottomClip != 0) {
                        canvas.restore();
                    }
                } else if (drawable instanceof BitmapDrawable) {
                    if (((BitmapDrawable) drawable).getTileModeX() == Shader.TileMode.REPEAT) {
                        canvas.save();
                        float f = 2.0f / AndroidUtilities.density;
                        canvas.scale(f, f);
                        drawable.setBounds(0, 0, (int) Math.ceil(getMeasuredWidth() / f), (int) Math.ceil(getRootView().getMeasuredHeight() / f));
                        drawable.draw(canvas);
                        canvas.restore();
                    } else {
                        int currentActionBarHeight2 = (isActionBarVisible() ? ActionBar.getCurrentActionBarHeight() : 0) + ((Build.VERSION.SDK_INT < 21 || !this.occupyStatusBar) ? 0 : AndroidUtilities.statusBarHeight);
                        int measuredHeight3 = getRootView().getMeasuredHeight() - currentActionBarHeight2;
                        float fMax2 = Math.max(getMeasuredWidth() / drawable.getIntrinsicWidth(), measuredHeight3 / drawable.getIntrinsicHeight());
                        int iCeil3 = (int) Math.ceil(drawable.getIntrinsicWidth() * fMax2 * this.parallaxScale);
                        int iCeil4 = (int) Math.ceil(drawable.getIntrinsicHeight() * fMax2 * this.parallaxScale);
                        int measuredWidth2 = ((getMeasuredWidth() - iCeil3) / 2) + ((int) this.translationX);
                        int i4 = this.backgroundTranslationY + ((measuredHeight3 - iCeil4) / 2) + currentActionBarHeight2 + ((int) this.translationY);
                        canvas.save();
                        canvas.clipRect(0, currentActionBarHeight2, iCeil3, getMeasuredHeight() - this.bottomClip);
                        drawable.setBounds(measuredWidth2, i4, iCeil3 + measuredWidth2, iCeil4 + i4);
                        drawable.draw(canvas);
                        canvas.restore();
                    }
                }
                if (i == 0 && this.oldBackgroundDrawable != null && themeAnimationValue >= 1.0f) {
                    this.oldBackgroundDrawable = null;
                    invalidate();
                }
            }
            i++;
        }
    }

    public void setSkipBackgroundDrawing(boolean skipBackgroundDrawing) {
        this.skipBackgroundDrawing = skipBackgroundDrawing;
        invalidate();
    }

    protected Drawable getNewDrawable() {
        return Theme.getCachedWallpaperNonBlocking();
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable who) {
        return who == getBackgroundImage() || super.verifyDrawable(who);
    }
}
