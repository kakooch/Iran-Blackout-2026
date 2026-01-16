package ir.nasim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import java.util.ArrayList;

/* renamed from: ir.nasim.gL6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C13508gL6 {
    private final ArrayList a = new ArrayList();
    private b b = null;
    ValueAnimator c = null;
    private final Animator.AnimatorListener d = new a();

    /* renamed from: ir.nasim.gL6$a */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            C13508gL6 c13508gL6 = C13508gL6.this;
            if (c13508gL6.c == animator) {
                c13508gL6.c = null;
            }
        }
    }

    /* renamed from: ir.nasim.gL6$b */
    static class b {
        final int[] a;
        final ValueAnimator b;

        b(int[] iArr, ValueAnimator valueAnimator) {
            this.a = iArr;
            this.b = valueAnimator;
        }
    }

    public void a(int[] iArr, ValueAnimator valueAnimator) {
        b bVar = new b(iArr, valueAnimator);
        valueAnimator.addListener(this.d);
        this.a.add(bVar);
    }
}
