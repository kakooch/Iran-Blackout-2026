package ir.nasim;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class NO5 extends Drawable implements Animator.AnimatorListener {
    private Context a;
    private ColorFilter b;
    private Drawable d;
    private Drawable e;
    private ValueAnimator f;
    private int c = 0;
    private float g = 1.0f;
    ArrayList h = new ArrayList();

    public NO5(Context context) {
        this.a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(ValueAnimator valueAnimator) {
        this.g = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidateSelf();
    }

    private void e(Drawable drawable, Rect rect) {
        int intrinsicHeight;
        int i;
        int intrinsicWidth;
        int i2;
        if (drawable == null) {
            return;
        }
        if (drawable.getIntrinsicHeight() < 0) {
            i = rect.top;
            intrinsicHeight = rect.bottom;
        } else {
            int iHeight = (rect.height() - drawable.getIntrinsicHeight()) / 2;
            int i3 = rect.top;
            int i4 = i3 + iHeight;
            intrinsicHeight = i3 + iHeight + drawable.getIntrinsicHeight();
            i = i4;
        }
        if (drawable.getIntrinsicWidth() < 0) {
            i2 = rect.left;
            intrinsicWidth = rect.right;
        } else {
            int iWidth = (rect.width() - drawable.getIntrinsicWidth()) / 2;
            int i5 = rect.left;
            int i6 = i5 + iWidth;
            intrinsicWidth = i5 + iWidth + drawable.getIntrinsicWidth();
            i2 = i6;
        }
        drawable.setBounds(i2, i, intrinsicWidth, intrinsicHeight);
    }

    public void c(int i, boolean z) {
        if (this.c == i) {
            return;
        }
        d(AbstractC4043Dl1.f(this.a, i).mutate(), z);
        this.c = i;
    }

    public void d(Drawable drawable, boolean z) {
        if (drawable == null) {
            this.d = null;
            this.e = null;
            invalidateSelf();
            return;
        }
        if (getBounds() == null || getBounds().isEmpty()) {
            z = false;
        }
        Drawable drawable2 = this.d;
        if (drawable == drawable2) {
            drawable2.setColorFilter(this.b);
            return;
        }
        this.c = 0;
        this.e = drawable2;
        this.d = drawable;
        drawable.setColorFilter(this.b);
        e(this.d, getBounds());
        e(this.e, getBounds());
        ValueAnimator valueAnimator = this.f;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.f.cancel();
        }
        if (!z) {
            this.g = 1.0f;
            this.e = null;
            return;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f = valueAnimatorOfFloat;
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.MO5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                this.a.b(valueAnimator2);
            }
        });
        this.f.addListener(this);
        this.f.setDuration(150L);
        this.f.start();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int iCenterX = getBounds().centerX();
        int iCenterY = getBounds().centerY();
        if (this.g == 1.0f || this.d == null) {
            Drawable drawable = this.d;
            if (drawable != null) {
                drawable.setAlpha(255);
                this.d.draw(canvas);
            }
        } else {
            canvas.save();
            float f = this.g;
            canvas.scale(f, f, iCenterX, iCenterY);
            this.d.setAlpha((int) (this.g * 255.0f));
            this.d.draw(canvas);
            canvas.restore();
        }
        float f2 = this.g;
        if (f2 == 1.0f || this.e == null) {
            Drawable drawable2 = this.e;
            if (drawable2 != null) {
                drawable2.setAlpha(255);
                this.e.draw(canvas);
                return;
            }
            return;
        }
        float f3 = 1.0f - f2;
        canvas.save();
        canvas.scale(f3, f3, iCenterX, iCenterY);
        this.e.setAlpha((int) (f3 * 255.0f));
        this.e.draw(canvas);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        if (this.h != null) {
            for (int i = 0; i < this.h.size(); i++) {
                ((View) this.h.get(i)).invalidate();
            }
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.e = null;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        e(this.d, rect);
        e(this.e, rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.b = colorFilter;
        Drawable drawable = this.d;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
        Drawable drawable2 = this.e;
        if (drawable2 != null) {
            drawable2.setColorFilter(colorFilter);
        }
        invalidateSelf();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }
}
