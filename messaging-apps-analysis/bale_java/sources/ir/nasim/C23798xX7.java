package ir.nasim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* renamed from: ir.nasim.xX7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C23798xX7 {
    private final WeakReference a;

    /* renamed from: ir.nasim.xX7$a */
    class a extends AnimatorListenerAdapter {
        final /* synthetic */ InterfaceC24982zX7 a;
        final /* synthetic */ View b;

        a(InterfaceC24982zX7 interfaceC24982zX7, View view) {
            this.a = interfaceC24982zX7;
            this.b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.a.a(this.b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.b(this.b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.a.c(this.b);
        }
    }

    C23798xX7(View view) {
        this.a = new WeakReference(view);
    }

    private void i(View view, InterfaceC24982zX7 interfaceC24982zX7) {
        if (interfaceC24982zX7 != null) {
            view.animate().setListener(new a(interfaceC24982zX7, view));
        } else {
            view.animate().setListener(null);
        }
    }

    public C23798xX7 b(float f) {
        View view = (View) this.a.get();
        if (view != null) {
            view.animate().alpha(f);
        }
        return this;
    }

    public void c() {
        View view = (View) this.a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public long d() {
        View view = (View) this.a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    public C23798xX7 f(long j) {
        View view = (View) this.a.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    public C23798xX7 g(Interpolator interpolator) {
        View view = (View) this.a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public C23798xX7 h(InterfaceC24982zX7 interfaceC24982zX7) {
        View view = (View) this.a.get();
        if (view != null) {
            i(view, interfaceC24982zX7);
        }
        return this;
    }

    public C23798xX7 j(long j) {
        View view = (View) this.a.get();
        if (view != null) {
            view.animate().setStartDelay(j);
        }
        return this;
    }

    public C23798xX7 k(final BX7 bx7) {
        final View view = (View) this.a.get();
        if (view != null) {
            view.animate().setUpdateListener(bx7 != null ? new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.wX7
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    bx7.a(view);
                }
            } : null);
        }
        return this;
    }

    public void l() {
        View view = (View) this.a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public C23798xX7 m(float f) {
        View view = (View) this.a.get();
        if (view != null) {
            view.animate().translationY(f);
        }
        return this;
    }
}
