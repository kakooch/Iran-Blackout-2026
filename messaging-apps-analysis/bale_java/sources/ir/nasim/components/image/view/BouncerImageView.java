package ir.nasim.components.image.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;
import ir.nasim.components.image.view.BouncerImageView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0017\u0018\u0000 *2\u00020\u0001:\u0001+B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001cH\u0014¢\u0006\u0004\b\u001e\u0010\u001fR\"\u0010&\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010!R\u0018\u0010)\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010(¨\u0006,"}, d2 = {"Lir/nasim/components/image/view/BouncerImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/animation/ValueAnimator;", "f", "()Landroid/animation/ValueAnimator;", "", "x", "e", "(F)F", "Lir/nasim/rB7;", "h", "()V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "", "pressed", "setPressed", "(Z)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "d", TokenNames.F, "getPaddingRatio", "()F", "setPaddingRatio", "(F)V", "paddingRatio", "pressedProgress", "Landroid/animation/ValueAnimator;", "backAnimator", "g", "a", "ui_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes4.dex */
public class BouncerImageView extends AppCompatImageView {
    private static final a g = new a(null);
    public static final int h = 8;

    /* renamed from: d, reason: from kotlin metadata */
    private float paddingRatio;

    /* renamed from: e, reason: from kotlin metadata */
    private float pressedProgress;

    /* renamed from: f, reason: from kotlin metadata */
    private ValueAnimator backAnimator;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public static final class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AbstractC13042fc3.i(animator, "animation");
            super.onAnimationEnd(animator);
            BouncerImageView.this.backAnimator = null;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BouncerImageView(Context context) {
        this(context, null, 0, 6, null);
        AbstractC13042fc3.i(context, "context");
    }

    private final float e(float x) {
        float f = 1.0f;
        if (x >= 1.0f) {
            f = 0.0f;
            if (x <= 0.0f) {
                return x;
            }
        }
        return f;
    }

    private final ValueAnimator f() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.pressedProgress, 0.0f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.tk0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                BouncerImageView.g(this.a, valueAnimator);
            }
        });
        valueAnimatorOfFloat.addListener(new b());
        valueAnimatorOfFloat.setInterpolator(new OvershootInterpolator(5.0f));
        valueAnimatorOfFloat.setDuration(350L);
        AbstractC13042fc3.h(valueAnimatorOfFloat, "apply(...)");
        return valueAnimatorOfFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(BouncerImageView bouncerImageView, ValueAnimator valueAnimator) {
        AbstractC13042fc3.i(bouncerImageView, "this$0");
        AbstractC13042fc3.i(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        AbstractC13042fc3.g(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        bouncerImageView.pressedProgress = ((Float) animatedValue).floatValue();
        bouncerImageView.invalidate();
    }

    public final float getPaddingRatio() {
        return this.paddingRatio;
    }

    public final void h() {
        setPressed(true);
        this.pressedProgress = 1.0f;
        setPressed(false);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        AbstractC13042fc3.i(canvas, "canvas");
        if (isPressed()) {
            float f = this.pressedProgress;
            if (f != 1.0f) {
                float f2 = f + 0.4f;
                this.pressedProgress = f2;
                this.pressedProgress = e(f2);
                invalidate();
            }
        }
        float f3 = ((1.0f - this.pressedProgress) * 0.2f) + 0.8f;
        canvas.save();
        float f4 = 1;
        float f5 = this.paddingRatio;
        canvas.scale((f4 - f5) * f3, (f4 - f5) * f3, getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f);
        super.onDraw(canvas);
        canvas.restore();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), View.MeasureSpec.getSize(widthMeasureSpec));
    }

    public final void setPaddingRatio(float f) {
        this.paddingRatio = f;
    }

    @Override // android.view.View
    public void setPressed(boolean pressed) {
        ValueAnimator valueAnimator;
        if (isClickable() && isPressed() != pressed) {
            super.setPressed(pressed);
            invalidate();
            if (pressed && (valueAnimator = this.backAnimator) != null) {
                valueAnimator.removeAllListeners();
                valueAnimator.cancel();
            }
            if (pressed || this.pressedProgress == 0.0f) {
                return;
            }
            ValueAnimator valueAnimatorF = f();
            valueAnimatorF.start();
            this.backAnimator = valueAnimatorF;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BouncerImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        AbstractC13042fc3.i(context, "context");
    }

    public /* synthetic */ BouncerImageView(Context context, AttributeSet attributeSet, int i, int i2, ED1 ed1) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BouncerImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        setScaleType(ImageView.ScaleType.CENTER);
    }
}
