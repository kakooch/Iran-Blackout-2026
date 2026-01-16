package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;

/* loaded from: classes3.dex */
public class ReplaceableIconDrawable extends Drawable implements Animator.AnimatorListener {
    private ValueAnimator animation;
    private ColorFilter colorFilter;
    private Context context;
    private Drawable currentDrawable;
    private Drawable outDrawable;
    private int currentResId = 0;
    private float progress = 1.0f;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animation) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animation) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animation) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
    }

    public ReplaceableIconDrawable(Context context) {
        this.context = context;
    }

    public void setIcon(int resId, boolean animated) {
        if (this.currentResId == resId) {
            return;
        }
        setIcon(ContextCompat.getDrawable(this.context, resId).mutate(), animated);
        this.currentResId = resId;
    }

    public void setIcon(Drawable drawable, boolean animated) {
        if (drawable == null) {
            this.currentDrawable = null;
            this.outDrawable = null;
            invalidateSelf();
            return;
        }
        if (getBounds() == null || getBounds().isEmpty()) {
            animated = false;
        }
        Drawable drawable2 = this.currentDrawable;
        if (drawable == drawable2) {
            drawable2.setColorFilter(this.colorFilter);
            return;
        }
        this.currentResId = 0;
        this.outDrawable = drawable2;
        this.currentDrawable = drawable;
        drawable.setColorFilter(this.colorFilter);
        updateBounds(this.currentDrawable, getBounds());
        updateBounds(this.outDrawable, getBounds());
        ValueAnimator valueAnimator = this.animation;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.animation.cancel();
        }
        if (!animated) {
            this.progress = 1.0f;
            this.outDrawable = null;
            return;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.animation = valueAnimatorOfFloat;
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ReplaceableIconDrawable$r8BGDs7aOel0K2KCvS9xLb9OCAo
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                this.f$0.lambda$setIcon$0$ReplaceableIconDrawable(valueAnimator2);
            }
        });
        this.animation.addListener(this);
        this.animation.setDuration(150L);
        this.animation.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setIcon$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setIcon$0$ReplaceableIconDrawable(ValueAnimator valueAnimator) {
        this.progress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(android.graphics.Rect bounds) {
        super.onBoundsChange(bounds);
        updateBounds(this.currentDrawable, bounds);
        updateBounds(this.outDrawable, bounds);
    }

    private void updateBounds(Drawable d, android.graphics.Rect bounds) {
        int intrinsicHeight;
        int i;
        int intrinsicWidth;
        int i2;
        if (d == null) {
            return;
        }
        if (d.getIntrinsicHeight() < 0) {
            i = bounds.top;
            intrinsicHeight = bounds.bottom;
        } else {
            int iHeight = (bounds.height() - d.getIntrinsicHeight()) / 2;
            int i3 = bounds.top;
            int i4 = i3 + iHeight;
            intrinsicHeight = i3 + iHeight + d.getIntrinsicHeight();
            i = i4;
        }
        if (d.getIntrinsicWidth() < 0) {
            i2 = bounds.left;
            intrinsicWidth = bounds.right;
        } else {
            int iWidth = (bounds.width() - d.getIntrinsicWidth()) / 2;
            int i5 = bounds.left;
            int i6 = i5 + iWidth;
            intrinsicWidth = i5 + iWidth + d.getIntrinsicWidth();
            i2 = i6;
        }
        d.setBounds(i2, i, intrinsicWidth, intrinsicHeight);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int iCenterX = getBounds().centerX();
        int iCenterY = getBounds().centerY();
        if (this.progress != 1.0f && this.currentDrawable != null) {
            canvas.save();
            float f = this.progress;
            canvas.scale(f, f, iCenterX, iCenterY);
            this.currentDrawable.setAlpha((int) (this.progress * 255.0f));
            this.currentDrawable.draw(canvas);
            canvas.restore();
        } else {
            Drawable drawable = this.currentDrawable;
            if (drawable != null) {
                drawable.setAlpha(255);
                this.currentDrawable.draw(canvas);
            }
        }
        float f2 = this.progress;
        if (f2 != 1.0f && this.outDrawable != null) {
            float f3 = 1.0f - f2;
            canvas.save();
            canvas.scale(f3, f3, iCenterX, iCenterY);
            this.outDrawable.setAlpha((int) (f3 * 255.0f));
            this.outDrawable.draw(canvas);
            canvas.restore();
            return;
        }
        Drawable drawable2 = this.outDrawable;
        if (drawable2 != null) {
            drawable2.setAlpha(255);
            this.outDrawable.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.colorFilter = colorFilter;
        Drawable drawable = this.currentDrawable;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
        Drawable drawable2 = this.outDrawable;
        if (drawable2 != null) {
            drawable2.setColorFilter(colorFilter);
        }
        invalidateSelf();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animation) {
        this.outDrawable = null;
        invalidateSelf();
    }
}
