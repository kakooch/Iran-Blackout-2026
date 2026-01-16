package ir.nasim;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.view.View;

/* loaded from: classes5.dex */
public final class AV2 {
    private static final a d = new a(null);
    public static final int e = 8;
    private static final int f = TA5.secondary_a15;
    private final View a;
    private final int b;
    private ValueAnimator c;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public static final class b implements Animator.AnimatorListener {
        final /* synthetic */ boolean b;

        b(boolean z) {
            this.b = z;
        }

        private final void a() {
            if (!this.b) {
                AV2.this.a.setBackground(null);
            }
            AV2.this.c = null;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            AbstractC13042fc3.i(animator, "animation");
            a();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AbstractC13042fc3.i(animator, "animation");
            a();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            AbstractC13042fc3.i(animator, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            AbstractC13042fc3.i(animator, "animation");
            AV2.this.a.setBackgroundColor(AV2.this.b);
        }
    }

    public AV2(View view, int i) {
        AbstractC13042fc3.i(view, "targetView");
        this.a = view;
        this.b = i;
    }

    private final void e() {
        ValueAnimator valueAnimator = this.c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.c = null;
    }

    private final void f(boolean z) {
        XV4 xv4A = z ? AbstractC4616Fw7.a(0, 255) : AbstractC4616Fw7.a(255, 0);
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(((Number) xv4A.a()).intValue(), ((Number) xv4A.b()).intValue());
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.zV2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AV2.g(this.a, valueAnimator);
            }
        });
        valueAnimatorOfInt.addListener(new b(z));
        valueAnimatorOfInt.setDuration(300L);
        valueAnimatorOfInt.start();
        this.c = valueAnimatorOfInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(AV2 av2, ValueAnimator valueAnimator) {
        AbstractC13042fc3.i(av2, "this$0");
        AbstractC13042fc3.i(valueAnimator, "it");
        Drawable background = av2.a.getBackground();
        if (background != null) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            AbstractC13042fc3.g(animatedValue, "null cannot be cast to non-null type kotlin.Int");
            background.setAlpha(((Integer) animatedValue).intValue());
        }
    }

    public final void h(boolean z, boolean z2) {
        e();
        if (z2) {
            f(z);
        } else if (z) {
            this.a.setBackgroundColor(this.b);
        } else {
            this.a.setBackground(null);
        }
    }

    public final void i() {
        this.a.setBackground(null);
        e();
    }

    public /* synthetic */ AV2(View view, int i, int i2, ED1 ed1) {
        this(view, (i2 & 2) != 0 ? AbstractC4043Dl1.c(view.getContext(), f) : i);
    }
}
