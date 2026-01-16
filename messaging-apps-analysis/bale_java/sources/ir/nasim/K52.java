package ir.nasim;

import android.graphics.Path;
import android.graphics.PointF;
import ir.nasim.AbstractC24408ya0;
import ir.nasim.C4156Dx6;
import java.util.List;

/* loaded from: classes2.dex */
public class K52 implements InterfaceC13318g15, AbstractC24408ya0.b, InterfaceC5491Jo3 {
    private final String b;
    private final com.airbnb.lottie.q c;
    private final AbstractC24408ya0 d;
    private final AbstractC24408ya0 e;
    private final C10949cU0 f;
    private boolean h;
    private final Path a = new Path();
    private final C17813nc1 g = new C17813nc1();

    public K52(com.airbnb.lottie.q qVar, AbstractC3236Aa0 abstractC3236Aa0, C10949cU0 c10949cU0) {
        this.b = c10949cU0.b();
        this.c = qVar;
        AbstractC24408ya0 abstractC24408ya0J = c10949cU0.d().j();
        this.d = abstractC24408ya0J;
        AbstractC24408ya0 abstractC24408ya0J2 = c10949cU0.c().j();
        this.e = abstractC24408ya0J2;
        this.f = c10949cU0;
        abstractC3236Aa0.j(abstractC24408ya0J);
        abstractC3236Aa0.j(abstractC24408ya0J2);
        abstractC24408ya0J.a(this);
        abstractC24408ya0J2.a(this);
    }

    private void h() {
        this.h = false;
        this.c.invalidateSelf();
    }

    @Override // ir.nasim.InterfaceC13318g15
    public Path A() {
        if (this.h) {
            return this.a;
        }
        this.a.reset();
        if (this.f.e()) {
            this.h = true;
            return this.a;
        }
        PointF pointF = (PointF) this.d.h();
        float f = pointF.x / 2.0f;
        float f2 = pointF.y / 2.0f;
        float f3 = f * 0.55228f;
        float f4 = 0.55228f * f2;
        this.a.reset();
        if (this.f.f()) {
            float f5 = -f2;
            this.a.moveTo(0.0f, f5);
            float f6 = 0.0f - f3;
            float f7 = -f;
            float f8 = 0.0f - f4;
            this.a.cubicTo(f6, f5, f7, f8, f7, 0.0f);
            float f9 = f4 + 0.0f;
            this.a.cubicTo(f7, f9, f6, f2, 0.0f, f2);
            float f10 = f3 + 0.0f;
            this.a.cubicTo(f10, f2, f, f9, f, 0.0f);
            this.a.cubicTo(f, f8, f10, f5, 0.0f, f5);
        } else {
            float f11 = -f2;
            this.a.moveTo(0.0f, f11);
            float f12 = f3 + 0.0f;
            float f13 = 0.0f - f4;
            this.a.cubicTo(f12, f11, f, f13, f, 0.0f);
            float f14 = f4 + 0.0f;
            this.a.cubicTo(f, f14, f12, f2, 0.0f, f2);
            float f15 = 0.0f - f3;
            float f16 = -f;
            this.a.cubicTo(f15, f2, f16, f14, f16, 0.0f);
            this.a.cubicTo(f16, f13, f15, f11, 0.0f, f11);
        }
        PointF pointF2 = (PointF) this.e.h();
        this.a.offset(pointF2.x, pointF2.y);
        this.a.close();
        this.g.b(this.a);
        this.h = true;
        return this.a;
    }

    @Override // ir.nasim.AbstractC24408ya0.b
    public void a() {
        h();
    }

    @Override // ir.nasim.InterfaceC14939ik1
    public void b(List list, List list2) {
        for (int i = 0; i < list.size(); i++) {
            InterfaceC14939ik1 interfaceC14939ik1 = (InterfaceC14939ik1) list.get(i);
            if (interfaceC14939ik1 instanceof C16837lw7) {
                C16837lw7 c16837lw7 = (C16837lw7) interfaceC14939ik1;
                if (c16837lw7.k() == C4156Dx6.a.SIMULTANEOUSLY) {
                    this.g.a(c16837lw7);
                    c16837lw7.c(this);
                }
            }
        }
    }

    @Override // ir.nasim.InterfaceC5257Io3
    public void c(Object obj, C13505gL3 c13505gL3) {
        if (obj == InterfaceC9661aL3.k) {
            this.d.o(c13505gL3);
        } else if (obj == InterfaceC9661aL3.n) {
            this.e.o(c13505gL3);
        }
    }

    @Override // ir.nasim.InterfaceC5257Io3
    public void f(C5023Ho3 c5023Ho3, int i, List list, C5023Ho3 c5023Ho32) {
        AbstractC7323Rf4.k(c5023Ho3, i, list, c5023Ho32, this);
    }

    @Override // ir.nasim.InterfaceC14939ik1
    public String getName() {
        return this.b;
    }
}
