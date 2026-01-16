package ir.nasim;

import android.graphics.PointF;
import ir.nasim.AbstractC24408ya0;
import java.util.Collections;

/* loaded from: classes2.dex */
public class OI6 extends AbstractC24408ya0 {
    private final PointF i;
    private final PointF j;
    private final AbstractC24408ya0 k;
    private final AbstractC24408ya0 l;
    protected C13505gL3 m;
    protected C13505gL3 n;

    public OI6(AbstractC24408ya0 abstractC24408ya0, AbstractC24408ya0 abstractC24408ya02) {
        super(Collections.emptyList());
        this.i = new PointF();
        this.j = new PointF();
        this.k = abstractC24408ya0;
        this.l = abstractC24408ya02;
        n(f());
    }

    @Override // ir.nasim.AbstractC24408ya0
    public void n(float f) {
        this.k.n(f);
        this.l.n(f);
        this.i.set(((Float) this.k.h()).floatValue(), ((Float) this.l.h()).floatValue());
        for (int i = 0; i < this.a.size(); i++) {
            ((AbstractC24408ya0.b) this.a.get(i)).a();
        }
    }

    @Override // ir.nasim.AbstractC24408ya0
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public PointF h() {
        return i(null, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // ir.nasim.AbstractC24408ya0
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public PointF i(C24561yp3 c24561yp3, float f) {
        Float f2;
        C24561yp3 c24561yp3B;
        C24561yp3 c24561yp3B2;
        Float f3 = null;
        if (this.m == null || (c24561yp3B2 = this.k.b()) == null) {
            f2 = null;
        } else {
            Float f4 = c24561yp3B2.h;
            C13505gL3 c13505gL3 = this.m;
            float f5 = c24561yp3B2.g;
            f2 = (Float) c13505gL3.b(f5, f4 == null ? f5 : f4.floatValue(), (Float) c24561yp3B2.b, (Float) c24561yp3B2.c, this.k.d(), this.k.e(), this.k.f());
        }
        if (this.n != null && (c24561yp3B = this.l.b()) != null) {
            Float f6 = c24561yp3B.h;
            C13505gL3 c13505gL32 = this.n;
            float f7 = c24561yp3B.g;
            f3 = (Float) c13505gL32.b(f7, f6 == null ? f7 : f6.floatValue(), (Float) c24561yp3B.b, (Float) c24561yp3B.c, this.l.d(), this.l.e(), this.l.f());
        }
        if (f2 == null) {
            this.j.set(this.i.x, 0.0f);
        } else {
            this.j.set(f2.floatValue(), 0.0f);
        }
        if (f3 == null) {
            PointF pointF = this.j;
            pointF.set(pointF.x, this.i.y);
        } else {
            PointF pointF2 = this.j;
            pointF2.set(pointF2.x, f3.floatValue());
        }
        return this.j;
    }

    public void t(C13505gL3 c13505gL3) {
        C13505gL3 c13505gL32 = this.m;
        if (c13505gL32 != null) {
            c13505gL32.c(null);
        }
        this.m = c13505gL3;
        if (c13505gL3 != null) {
            c13505gL3.c(this);
        }
    }

    public void u(C13505gL3 c13505gL3) {
        C13505gL3 c13505gL32 = this.n;
        if (c13505gL32 != null) {
            c13505gL32.c(null);
        }
        this.n = c13505gL3;
        if (c13505gL3 != null) {
            c13505gL3.c(this);
        }
    }
}
