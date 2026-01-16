package ir.nasim;

import android.view.Choreographer;

/* renamed from: ir.nasim.fL3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class ChoreographerFrameCallbackC12887fL3 extends AbstractC3943Da0 implements Choreographer.FrameCallback {
    private C23677xK3 l;
    private float d = 1.0f;
    private boolean e = false;
    private long f = 0;
    private float g = 0.0f;
    private float h = 0.0f;
    private int i = 0;
    private float j = -2.1474836E9f;
    private float k = 2.1474836E9f;
    protected boolean m = false;
    private boolean n = false;

    private void I() {
        if (this.l == null) {
            return;
        }
        float f = this.h;
        if (f < this.j || f > this.k) {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.j), Float.valueOf(this.k), Float.valueOf(this.h)));
        }
    }

    private void k(float f) {
        if (this.n && this.g == f) {
            return;
        }
        i();
    }

    private float p() {
        C23677xK3 c23677xK3 = this.l;
        if (c23677xK3 == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / c23677xK3.i()) / Math.abs(this.d);
    }

    private boolean t() {
        return s() < 0.0f;
    }

    public void A() {
        G(-s());
    }

    public void B(C23677xK3 c23677xK3) {
        boolean z = this.l == null;
        this.l = c23677xK3;
        if (z) {
            E(Math.max(this.j, c23677xK3.p()), Math.min(this.k, c23677xK3.f()));
        } else {
            E((int) c23677xK3.p(), (int) c23677xK3.f());
        }
        float f = this.h;
        this.h = 0.0f;
        this.g = 0.0f;
        C((int) f);
        i();
    }

    public void C(float f) {
        if (this.g == f) {
            return;
        }
        float fB = AbstractC7323Rf4.b(f, r(), q());
        this.g = fB;
        if (this.n) {
            fB = (float) Math.floor(fB);
        }
        this.h = fB;
        this.f = 0L;
        i();
    }

    public void D(float f) {
        E(this.j, f);
    }

    public void E(float f, float f2) {
        if (f > f2) {
            throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f), Float.valueOf(f2)));
        }
        C23677xK3 c23677xK3 = this.l;
        float fP = c23677xK3 == null ? -3.4028235E38f : c23677xK3.p();
        C23677xK3 c23677xK32 = this.l;
        float f3 = c23677xK32 == null ? Float.MAX_VALUE : c23677xK32.f();
        float fB = AbstractC7323Rf4.b(f, fP, f3);
        float fB2 = AbstractC7323Rf4.b(f2, fP, f3);
        if (fB == this.j && fB2 == this.k) {
            return;
        }
        this.j = fB;
        this.k = fB2;
        C((int) AbstractC7323Rf4.b(this.h, fB, fB2));
    }

    public void F(int i) {
        E(i, (int) this.k);
    }

    public void G(float f) {
        this.d = f;
    }

    public void H(boolean z) {
        this.n = z;
    }

    @Override // ir.nasim.AbstractC3943Da0
    void b() {
        super.b();
        c(t());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void cancel() {
        b();
        x();
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        w();
        if (this.l == null || !isRunning()) {
            return;
        }
        if (AbstractC6219Mr3.h()) {
            AbstractC6219Mr3.b("LottieValueAnimator#doFrame");
        }
        float fP = (this.f != 0 ? j - r2 : 0L) / p();
        float f = this.g;
        if (t()) {
            fP = -fP;
        }
        float f2 = f + fP;
        boolean z = !AbstractC7323Rf4.d(f2, r(), q());
        float f3 = this.g;
        float fB = AbstractC7323Rf4.b(f2, r(), q());
        this.g = fB;
        if (this.n) {
            fB = (float) Math.floor(fB);
        }
        this.h = fB;
        this.f = j;
        if (!z) {
            k(f3);
        } else if (getRepeatCount() == -1 || this.i < getRepeatCount()) {
            if (getRepeatMode() == 2) {
                this.e = !this.e;
                A();
            } else {
                float fQ = t() ? q() : r();
                this.g = fQ;
                this.h = fQ;
            }
            this.f = j;
            k(f3);
            e();
            this.i++;
        } else {
            float fR = this.d < 0.0f ? r() : q();
            this.g = fR;
            this.h = fR;
            x();
            k(f3);
            c(t());
        }
        I();
        if (AbstractC6219Mr3.h()) {
            AbstractC6219Mr3.c("LottieValueAnimator#doFrame");
        }
    }

    @Override // android.animation.ValueAnimator
    public float getAnimatedFraction() {
        float fR;
        float fQ;
        float fR2;
        if (this.l == null) {
            return 0.0f;
        }
        if (t()) {
            fR = q() - this.h;
            fQ = q();
            fR2 = r();
        } else {
            fR = this.h - r();
            fQ = q();
            fR2 = r();
        }
        return fR / (fQ - fR2);
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(n());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        C23677xK3 c23677xK3 = this.l;
        if (c23677xK3 == null) {
            return 0L;
        }
        return (long) c23677xK3.d();
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.m;
    }

    public void l() {
        this.l = null;
        this.j = -2.1474836E9f;
        this.k = 2.1474836E9f;
    }

    public void m() {
        x();
        c(t());
    }

    public float n() {
        C23677xK3 c23677xK3 = this.l;
        if (c23677xK3 == null) {
            return 0.0f;
        }
        return (this.h - c23677xK3.p()) / (this.l.f() - this.l.p());
    }

    public float o() {
        return this.h;
    }

    public float q() {
        C23677xK3 c23677xK3 = this.l;
        if (c23677xK3 == null) {
            return 0.0f;
        }
        float f = this.k;
        return f == 2.1474836E9f ? c23677xK3.f() : f;
    }

    public float r() {
        C23677xK3 c23677xK3 = this.l;
        if (c23677xK3 == null) {
            return 0.0f;
        }
        float f = this.j;
        return f == -2.1474836E9f ? c23677xK3.p() : f;
    }

    public float s() {
        return this.d;
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i) {
        super.setRepeatMode(i);
        if (i == 2 || !this.e) {
            return;
        }
        this.e = false;
        A();
    }

    public void u() {
        x();
        d();
    }

    public void v() {
        this.m = true;
        h(t());
        C((int) (t() ? q() : r()));
        this.f = 0L;
        this.i = 0;
        w();
    }

    protected void w() {
        if (isRunning()) {
            y(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    protected void x() {
        y(true);
    }

    protected void y(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.m = false;
        }
    }

    public void z() {
        this.m = true;
        w();
        this.f = 0L;
        if (t() && o() == r()) {
            C(q());
        } else if (!t() && o() == q()) {
            C(r());
        }
        f();
    }
}
