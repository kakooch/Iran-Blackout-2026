package ir.nasim.jaryan.feed.ui.components;

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
import ir.nasim.jaryan.feed.ui.components.FeedEmojiImageView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u00018B;\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u000f¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001f\u0010\u0011J\u0017\u0010\"\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020 H\u0014¢\u0006\u0004\b\"\u0010#R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010\u0011R\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u00103\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0016\u00105\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u0010.R\u0018\u00107\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u00106¨\u00069"}, d2 = {"Lir/nasim/jaryan/feed/ui/components/FeedEmojiImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyleAttr", "", "goneWhenEnd", "", "duration", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;IZJ)V", "pressed", "Lir/nasim/rB7;", "i", "(Z)V", "Landroid/animation/ValueAnimator;", "f", "()Landroid/animation/ValueAnimator;", "", "x", "e", "(F)F", "h", "()V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "setPressed", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "d", "Z", "getGoneWhenEnd", "()Z", "setGoneWhenEnd", "J", "getDuration", "()J", "setDuration", "(J)V", TokenNames.F, "getPaddingRatio", "()F", "setPaddingRatio", "(F)V", "paddingRatio", "g", "pressedProgress", "Landroid/animation/ValueAnimator;", "backAnimator", "a", "jaryan_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class FeedEmojiImageView extends AppCompatImageView {
    private static final a i = new a(null);
    public static final int j = 8;

    /* renamed from: d, reason: from kotlin metadata */
    private boolean goneWhenEnd;

    /* renamed from: e, reason: from kotlin metadata */
    private long duration;

    /* renamed from: f, reason: from kotlin metadata */
    private float paddingRatio;

    /* renamed from: g, reason: from kotlin metadata */
    private float pressedProgress;

    /* renamed from: h, reason: from kotlin metadata */
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
            if (FeedEmojiImageView.this.getGoneWhenEnd()) {
                FeedEmojiImageView.this.setVisibility(8);
            }
            FeedEmojiImageView.this.backAnimator = null;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FeedEmojiImageView(Context context) {
        this(context, null, 0, false, 0L, 30, null);
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
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.th2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                FeedEmojiImageView.g(this.a, valueAnimator);
            }
        });
        valueAnimatorOfFloat.addListener(new b());
        valueAnimatorOfFloat.setInterpolator(new OvershootInterpolator(5.0f));
        valueAnimatorOfFloat.setDuration(this.duration);
        AbstractC13042fc3.h(valueAnimatorOfFloat, "apply(...)");
        return valueAnimatorOfFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(FeedEmojiImageView feedEmojiImageView, ValueAnimator valueAnimator) {
        AbstractC13042fc3.i(feedEmojiImageView, "this$0");
        AbstractC13042fc3.i(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        AbstractC13042fc3.g(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        feedEmojiImageView.pressedProgress = ((Float) animatedValue).floatValue();
        feedEmojiImageView.invalidate();
    }

    private final void i(boolean pressed) {
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

    public final long getDuration() {
        return this.duration;
    }

    public final boolean getGoneWhenEnd() {
        return this.goneWhenEnd;
    }

    public final float getPaddingRatio() {
        return this.paddingRatio;
    }

    public final void h() {
        if (this.goneWhenEnd) {
            setVisibility(0);
        }
        i(true);
        this.pressedProgress = 1.0f;
        i(false);
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

    public final void setDuration(long j2) {
        this.duration = j2;
    }

    public final void setGoneWhenEnd(boolean z) {
        this.goneWhenEnd = z;
    }

    public final void setPaddingRatio(float f) {
        this.paddingRatio = f;
    }

    @Override // android.view.View
    public void setPressed(boolean pressed) {
        if (isPressed() != pressed) {
            super.setPressed(pressed);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FeedEmojiImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, false, 0L, 28, null);
        AbstractC13042fc3.i(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FeedEmojiImageView(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, false, 0L, 24, null);
        AbstractC13042fc3.i(context, "context");
    }

    public /* synthetic */ FeedEmojiImageView(Context context, AttributeSet attributeSet, int i2, boolean z, long j2, int i3, ED1 ed1) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2, (i3 & 8) != 0 ? false : z, (i3 & 16) != 0 ? 350L : j2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedEmojiImageView(Context context, AttributeSet attributeSet, int i2, boolean z, long j2) {
        super(context, attributeSet, i2);
        AbstractC13042fc3.i(context, "context");
        this.goneWhenEnd = z;
        this.duration = j2;
        setScaleType(ImageView.ScaleType.CENTER);
    }
}
