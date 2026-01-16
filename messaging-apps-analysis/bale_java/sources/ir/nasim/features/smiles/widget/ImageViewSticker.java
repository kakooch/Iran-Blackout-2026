package ir.nasim.features.smiles.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC4310Eo7;
import ir.nasim.ED1;
import ir.nasim.features.smiles.widget.ImageViewSticker;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lir/nasim/features/smiles/widget/ImageViewSticker;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "widthMeasureSpec", "heightMeasureSpec", "Lir/nasim/rB7;", "onMeasure", "(II)V", "", "pressed", "setPressed", "(Z)V", "Landroid/animation/ValueAnimator;", "d", "Landroid/animation/ValueAnimator;", "backAnimator", "", "e", TokenNames.F, "pressedProgress", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class ImageViewSticker extends AppCompatImageView {

    /* renamed from: d, reason: from kotlin metadata */
    private ValueAnimator backAnimator;

    /* renamed from: e, reason: from kotlin metadata */
    private float pressedProgress;

    public static final class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AbstractC13042fc3.i(animator, "animation");
            super.onAnimationEnd(animator);
            ImageViewSticker.this.backAnimator = null;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImageViewSticker(Context context) {
        this(context, null, 0, 6, null);
        AbstractC13042fc3.i(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(ImageViewSticker imageViewSticker, ValueAnimator valueAnimator) {
        AbstractC13042fc3.i(imageViewSticker, "this$0");
        AbstractC13042fc3.i(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        AbstractC13042fc3.g(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        imageViewSticker.pressedProgress = ((Float) animatedValue).floatValue();
        imageViewSticker.invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), View.MeasureSpec.getSize(widthMeasureSpec));
    }

    @Override // android.view.View
    public void setPressed(boolean pressed) {
        ValueAnimator valueAnimator;
        if (isPressed() != pressed) {
            super.setPressed(pressed);
            invalidate();
            if (pressed && (valueAnimator = this.backAnimator) != null) {
                valueAnimator.removeAllListeners();
                valueAnimator.cancel();
            }
            if (pressed) {
                return;
            }
            float f = this.pressedProgress;
            if (f == 0.0f) {
                return;
            }
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, 0.0f);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.l33
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    ImageViewSticker.e(this.a, valueAnimator2);
                }
            });
            valueAnimatorOfFloat.addListener(new a());
            valueAnimatorOfFloat.setInterpolator(new OvershootInterpolator(5.0f));
            valueAnimatorOfFloat.setDuration(350L);
            valueAnimatorOfFloat.start();
            this.backAnimator = valueAnimatorOfFloat;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImageViewSticker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        AbstractC13042fc3.i(context, "context");
    }

    public /* synthetic */ ImageViewSticker(Context context, AttributeSet attributeSet, int i, int i2, ED1 ed1) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageViewSticker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        setScaleType(ImageView.ScaleType.CENTER);
        setBackground(AbstractC4310Eo7.h(4.0f));
    }
}
