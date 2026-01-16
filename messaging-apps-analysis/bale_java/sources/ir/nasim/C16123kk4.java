package ir.nasim;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

/* renamed from: ir.nasim.kk4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C16123kk4 {
    private long a;
    private long b;
    private TimeInterpolator c;
    private int d;
    private int e;

    public C16123kk4(long j, long j2) {
        this.c = null;
        this.d = 0;
        this.e = 1;
        this.a = j;
        this.b = j2;
    }

    static C16123kk4 b(ValueAnimator valueAnimator) {
        C16123kk4 c16123kk4 = new C16123kk4(valueAnimator.getStartDelay(), valueAnimator.getDuration(), f(valueAnimator));
        c16123kk4.d = valueAnimator.getRepeatCount();
        c16123kk4.e = valueAnimator.getRepeatMode();
        return c16123kk4;
    }

    private static TimeInterpolator f(ValueAnimator valueAnimator) {
        TimeInterpolator interpolator = valueAnimator.getInterpolator();
        return ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) ? AbstractC6732Ot.b : interpolator instanceof AccelerateInterpolator ? AbstractC6732Ot.c : interpolator instanceof DecelerateInterpolator ? AbstractC6732Ot.d : interpolator;
    }

    public void a(Animator animator) {
        animator.setStartDelay(c());
        animator.setDuration(d());
        animator.setInterpolator(e());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(g());
            valueAnimator.setRepeatMode(h());
        }
    }

    public long c() {
        return this.a;
    }

    public long d() {
        return this.b;
    }

    public TimeInterpolator e() {
        TimeInterpolator timeInterpolator = this.c;
        return timeInterpolator != null ? timeInterpolator : AbstractC6732Ot.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C16123kk4)) {
            return false;
        }
        C16123kk4 c16123kk4 = (C16123kk4) obj;
        if (c() == c16123kk4.c() && d() == c16123kk4.d() && g() == c16123kk4.g() && h() == c16123kk4.h()) {
            return e().getClass().equals(c16123kk4.e().getClass());
        }
        return false;
    }

    public int g() {
        return this.d;
    }

    public int h() {
        return this.e;
    }

    public int hashCode() {
        return (((((((((int) (c() ^ (c() >>> 32))) * 31) + ((int) (d() ^ (d() >>> 32)))) * 31) + e().getClass().hashCode()) * 31) + g()) * 31) + h();
    }

    public String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + c() + " duration: " + d() + " interpolator: " + e().getClass() + " repeatCount: " + g() + " repeatMode: " + h() + "}\n";
    }

    public C16123kk4(long j, long j2, TimeInterpolator timeInterpolator) {
        this.d = 0;
        this.e = 1;
        this.a = j;
        this.b = j2;
        this.c = timeInterpolator;
    }
}
