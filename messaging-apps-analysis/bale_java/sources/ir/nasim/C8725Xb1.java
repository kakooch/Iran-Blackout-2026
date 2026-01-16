package ir.nasim;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import ir.nasim.C6970Pt3;
import ir.nasim.YG4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Xb1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C8725Xb1 extends AbstractC3236Aa0 {
    private AbstractC24408ya0 E;
    private final List F;
    private final RectF G;
    private final RectF H;
    private final RectF I;
    private final YG4 J;
    private final YG4.a K;
    private float L;
    private boolean M;
    private C19243q12 N;

    /* renamed from: ir.nasim.Xb1$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[C6970Pt3.b.values().length];
            a = iArr;
            try {
                iArr[C6970Pt3.b.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[C6970Pt3.b.INVERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public C8725Xb1(com.airbnb.lottie.q qVar, C6970Pt3 c6970Pt3, List list, C23677xK3 c23677xK3) {
        int i;
        AbstractC3236Aa0 abstractC3236Aa0;
        super(qVar, c6970Pt3);
        this.F = new ArrayList();
        this.G = new RectF();
        this.H = new RectF();
        this.I = new RectF();
        this.J = new YG4();
        this.K = new YG4.a();
        this.M = true;
        C17380ms c17380msV = c6970Pt3.v();
        if (c17380msV != null) {
            C11959dq2 c11959dq2J = c17380msV.j();
            this.E = c11959dq2J;
            j(c11959dq2J);
            this.E.a(this);
        } else {
            this.E = null;
        }
        C21892uJ3 c21892uJ3 = new C21892uJ3(c23677xK3.k().size());
        int size = list.size() - 1;
        AbstractC3236Aa0 abstractC3236Aa02 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            C6970Pt3 c6970Pt32 = (C6970Pt3) list.get(size);
            AbstractC3236Aa0 abstractC3236Aa0V = AbstractC3236Aa0.v(this, c6970Pt32, qVar, c23677xK3);
            if (abstractC3236Aa0V != null) {
                c21892uJ3.l(abstractC3236Aa0V.B().e(), abstractC3236Aa0V);
                if (abstractC3236Aa02 != null) {
                    abstractC3236Aa02.L(abstractC3236Aa0V);
                    abstractC3236Aa02 = null;
                } else {
                    this.F.add(0, abstractC3236Aa0V);
                    int i2 = a.a[c6970Pt32.i().ordinal()];
                    if (i2 == 1 || i2 == 2) {
                        abstractC3236Aa02 = abstractC3236Aa0V;
                    }
                }
            }
            size--;
        }
        for (i = 0; i < c21892uJ3.o(); i++) {
            AbstractC3236Aa0 abstractC3236Aa03 = (AbstractC3236Aa0) c21892uJ3.f(c21892uJ3.k(i));
            if (abstractC3236Aa03 != null && (abstractC3236Aa0 = (AbstractC3236Aa0) c21892uJ3.f(abstractC3236Aa03.B().k())) != null) {
                abstractC3236Aa03.N(abstractC3236Aa0);
            }
        }
        if (z() != null) {
            this.N = new C19243q12(this, this, z());
        }
    }

    @Override // ir.nasim.AbstractC3236Aa0
    protected void K(C5023Ho3 c5023Ho3, int i, List list, C5023Ho3 c5023Ho32) {
        for (int i2 = 0; i2 < this.F.size(); i2++) {
            ((AbstractC3236Aa0) this.F.get(i2)).f(c5023Ho3, i, list, c5023Ho32);
        }
    }

    @Override // ir.nasim.AbstractC3236Aa0
    public void M(boolean z) {
        super.M(z);
        Iterator it = this.F.iterator();
        while (it.hasNext()) {
            ((AbstractC3236Aa0) it.next()).M(z);
        }
    }

    @Override // ir.nasim.AbstractC3236Aa0
    public void O(float f) {
        if (AbstractC6219Mr3.h()) {
            AbstractC6219Mr3.b("CompositionLayer#setProgress");
        }
        this.L = f;
        super.O(f);
        if (this.E != null) {
            f = ((((Float) this.E.h()).floatValue() * this.q.c().i()) - this.q.c().p()) / (this.p.N().e() + 0.01f);
        }
        if (this.E == null) {
            f -= this.q.s();
        }
        if (this.q.w() != 0.0f && !"__container".equals(this.q.j())) {
            f /= this.q.w();
        }
        for (int size = this.F.size() - 1; size >= 0; size--) {
            ((AbstractC3236Aa0) this.F.get(size)).O(f);
        }
        if (AbstractC6219Mr3.h()) {
            AbstractC6219Mr3.c("CompositionLayer#setProgress");
        }
    }

    public float R() {
        return this.L;
    }

    public void S(boolean z) {
        this.M = z;
    }

    @Override // ir.nasim.AbstractC3236Aa0, ir.nasim.InterfaceC5257Io3
    public void c(Object obj, C13505gL3 c13505gL3) {
        C19243q12 c19243q12;
        C19243q12 c19243q122;
        C19243q12 c19243q123;
        C19243q12 c19243q124;
        C19243q12 c19243q125;
        super.c(obj, c13505gL3);
        if (obj == InterfaceC9661aL3.E) {
            if (c13505gL3 == null) {
                AbstractC24408ya0 abstractC24408ya0 = this.E;
                if (abstractC24408ya0 != null) {
                    abstractC24408ya0.o(null);
                    return;
                }
                return;
            }
            C14145hQ7 c14145hQ7 = new C14145hQ7(c13505gL3);
            this.E = c14145hQ7;
            c14145hQ7.a(this);
            j(this.E);
            return;
        }
        if (obj == InterfaceC9661aL3.e && (c19243q125 = this.N) != null) {
            c19243q125.c(c13505gL3);
            return;
        }
        if (obj == InterfaceC9661aL3.G && (c19243q124 = this.N) != null) {
            c19243q124.f(c13505gL3);
            return;
        }
        if (obj == InterfaceC9661aL3.H && (c19243q123 = this.N) != null) {
            c19243q123.d(c13505gL3);
            return;
        }
        if (obj == InterfaceC9661aL3.I && (c19243q122 = this.N) != null) {
            c19243q122.e(c13505gL3);
        } else {
            if (obj != InterfaceC9661aL3.J || (c19243q12 = this.N) == null) {
                return;
            }
            c19243q12.g(c13505gL3);
        }
    }

    @Override // ir.nasim.AbstractC3236Aa0, ir.nasim.V02
    public void g(RectF rectF, Matrix matrix, boolean z) {
        super.g(rectF, matrix, z);
        for (int size = this.F.size() - 1; size >= 0; size--) {
            this.G.set(0.0f, 0.0f, 0.0f, 0.0f);
            ((AbstractC3236Aa0) this.F.get(size)).g(this.G, this.o, true);
            rectF.union(this.G);
        }
    }

    @Override // ir.nasim.AbstractC3236Aa0
    void u(Canvas canvas, Matrix matrix, int i, C17470n12 c17470n12) {
        Canvas canvasJ;
        if (AbstractC6219Mr3.h()) {
            AbstractC6219Mr3.b("CompositionLayer#draw");
        }
        boolean z = false;
        boolean z2 = (c17470n12 == null && this.N == null) ? false : true;
        if ((this.p.j0() && this.F.size() > 1 && i != 255) || (z2 && this.p.k0())) {
            z = true;
        }
        int i2 = z ? 255 : i;
        C19243q12 c19243q12 = this.N;
        if (c19243q12 != null) {
            c17470n12 = c19243q12.b(matrix, i2);
        }
        if (this.M || !"__container".equals(this.q.j())) {
            this.H.set(0.0f, 0.0f, this.q.m(), this.q.l());
            matrix.mapRect(this.H);
        } else {
            this.H.setEmpty();
            Iterator it = this.F.iterator();
            while (it.hasNext()) {
                ((AbstractC3236Aa0) it.next()).g(this.I, matrix, true);
                this.H.union(this.I);
            }
        }
        if (z) {
            this.K.f();
            YG4.a aVar = this.K;
            aVar.a = i;
            if (c17470n12 != null) {
                c17470n12.b(aVar);
                c17470n12 = null;
            }
            canvasJ = this.J.j(canvas, this.H, this.K);
        } else {
            canvasJ = canvas;
        }
        canvas.save();
        if (canvas.clipRect(this.H)) {
            for (int size = this.F.size() - 1; size >= 0; size--) {
                ((AbstractC3236Aa0) this.F.get(size)).i(canvasJ, matrix, i2, c17470n12);
            }
        }
        if (z) {
            this.J.e();
        }
        canvas.restore();
        if (AbstractC6219Mr3.h()) {
            AbstractC6219Mr3.c("CompositionLayer#draw");
        }
    }
}
