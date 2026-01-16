package ir.nasim;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import ir.nasim.AbstractC12098e22;

/* renamed from: ir.nasim.lJ6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C16463lJ6 extends AbstractC12098e22 {
    private C17645nJ6 A;
    private float B;
    private boolean C;

    public C16463lJ6(C19136pq2 c19136pq2) {
        super(c19136pq2);
        this.A = null;
        this.B = Float.MAX_VALUE;
        this.C = false;
    }

    private void z() {
        C17645nJ6 c17645nJ6 = this.A;
        if (c17645nJ6 == null) {
            throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
        }
        double dA = c17645nJ6.a();
        if (dA > this.g) {
            throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
        }
        if (dA < this.h) {
            throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
        }
    }

    public C16463lJ6 A(C17645nJ6 c17645nJ6) {
        this.A = c17645nJ6;
        return this;
    }

    public void B() {
        if (!w()) {
            throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        }
        if (this.f) {
            this.C = true;
        }
    }

    @Override // ir.nasim.AbstractC12098e22
    public void s() {
        z();
        this.A.g(g());
        super.s();
    }

    @Override // ir.nasim.AbstractC12098e22
    boolean u(long j) {
        if (this.C) {
            float f = this.B;
            if (f != Float.MAX_VALUE) {
                this.A.e(f);
                this.B = Float.MAX_VALUE;
            }
            this.b = this.A.a();
            this.a = 0.0f;
            this.C = false;
            return true;
        }
        if (this.B != Float.MAX_VALUE) {
            this.A.a();
            long j2 = j / 2;
            AbstractC12098e22.p pVarH = this.A.h(this.b, this.a, j2);
            this.A.e(this.B);
            this.B = Float.MAX_VALUE;
            AbstractC12098e22.p pVarH2 = this.A.h(pVarH.a, pVarH.b, j2);
            this.b = pVarH2.a;
            this.a = pVarH2.b;
        } else {
            AbstractC12098e22.p pVarH3 = this.A.h(this.b, this.a, j);
            this.b = pVarH3.a;
            this.a = pVarH3.b;
        }
        float fMax = Math.max(this.b, this.h);
        this.b = fMax;
        float fMin = Math.min(fMax, this.g);
        this.b = fMin;
        if (!y(fMin, this.a)) {
            return false;
        }
        this.b = this.A.a();
        this.a = 0.0f;
        return true;
    }

    public void v(float f) {
        if (h()) {
            this.B = f;
            return;
        }
        if (this.A == null) {
            this.A = new C17645nJ6(f);
        }
        this.A.e(f);
        s();
    }

    public boolean w() {
        return this.A.b > 0.0d;
    }

    public C17645nJ6 x() {
        return this.A;
    }

    boolean y(float f, float f2) {
        return this.A.c(f, f2);
    }

    public C16463lJ6(Object obj, AbstractC13799gq2 abstractC13799gq2) {
        super(obj, abstractC13799gq2);
        this.A = null;
        this.B = Float.MAX_VALUE;
        this.C = false;
    }

    public C16463lJ6(Object obj, AbstractC13799gq2 abstractC13799gq2, float f) {
        super(obj, abstractC13799gq2);
        this.A = null;
        this.B = Float.MAX_VALUE;
        this.C = false;
        this.A = new C17645nJ6(f);
    }

    @Override // ir.nasim.AbstractC12098e22
    void r(float f) {
    }
}
