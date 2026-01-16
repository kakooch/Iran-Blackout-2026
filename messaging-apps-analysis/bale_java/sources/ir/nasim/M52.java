package ir.nasim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.view.View;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class M52 {
    private final b[] a;
    private final AnimatorSet b;
    boolean c;
    public ArrayList d;

    class a extends AnimatorListenerAdapter {
        private Runnable a = new RunnableC0493a();
        final /* synthetic */ View b;

        /* renamed from: ir.nasim.M52$a$a, reason: collision with other inner class name */
        class RunnableC0493a implements Runnable {
            RunnableC0493a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                M52 m52 = M52.this;
                if (!m52.c || m52.d.isEmpty() || M52.this.b.isRunning()) {
                    return;
                }
                try {
                    M52.this.b.start();
                } catch (Exception unused) {
                }
            }
        }

        a(View view) {
            this.b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (M52.this.c) {
                this.b.postDelayed(this.a, 300L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class b extends CharacterStyle {
        private int a = 0;

        public void a(int i) {
            this.a = i;
        }

        @Override // android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setAlpha((int) (textPaint.getAlpha() * (this.a / 255.0f)));
        }
    }

    public M52(View view) {
        b[] bVarArr = {new b(), new b(), new b()};
        this.a = bVarArr;
        this.d = new ArrayList();
        AnimatorSet animatorSet = new AnimatorSet();
        this.b = animatorSet;
        animatorSet.playTogether(c(bVarArr[0], 0, 255, 0, 300), c(bVarArr[1], 0, 255, 150, 300), c(bVarArr[2], 0, 255, 300, 300), c(bVarArr[0], 255, 0, AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT, 400), c(bVarArr[1], 255, 0, AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT, 400), c(bVarArr[2], 255, 0, AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT, 400));
        animatorSet.addListener(new a(view));
    }

    private Animator c(final b bVar, int i, int i2, int i3, int i4) {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i, i2);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.L52
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.a.d(bVar, valueAnimator);
            }
        });
        valueAnimatorOfInt.setDuration(i4);
        valueAnimatorOfInt.setStartDelay(i3);
        valueAnimatorOfInt.setInterpolator(InterpolatorC12631ew1.f);
        return valueAnimatorOfInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(b bVar, ValueAnimator valueAnimator) {
        bVar.a(((Integer) valueAnimator.getAnimatedValue()).intValue());
        for (int i = 0; i < this.d.size(); i++) {
        }
    }

    public void e() {
        this.c = true;
        if (this.b.isRunning()) {
            return;
        }
        this.b.start();
    }

    public void f() {
        this.c = false;
        this.b.cancel();
    }
}
