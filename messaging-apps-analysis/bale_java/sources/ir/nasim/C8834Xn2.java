package ir.nasim;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import ir.nasim.AbstractC24408ya0;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.Xn2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C8834Xn2 implements V02, AbstractC24408ya0.b, InterfaceC5491Jo3 {
    private final Path a;
    private final Paint b;
    private final AbstractC3236Aa0 c;
    private final String d;
    private final boolean e;
    private final List f;
    private final AbstractC24408ya0 g;
    private final AbstractC24408ya0 h;
    private AbstractC24408ya0 i;
    private final com.airbnb.lottie.q j;
    private AbstractC24408ya0 k;
    float l;

    public C8834Xn2(com.airbnb.lottie.q qVar, AbstractC3236Aa0 abstractC3236Aa0, C19209px6 c19209px6) {
        Path path = new Path();
        this.a = path;
        this.b = new C7430Rr3(1);
        this.f = new ArrayList();
        this.c = abstractC3236Aa0;
        this.d = c19209px6.d();
        this.e = c19209px6.f();
        this.j = qVar;
        if (abstractC3236Aa0.x() != null) {
            C11959dq2 c11959dq2J = abstractC3236Aa0.x().a().j();
            this.k = c11959dq2J;
            c11959dq2J.a(this);
            abstractC3236Aa0.j(this.k);
        }
        if (c19209px6.b() == null || c19209px6.e() == null) {
            this.g = null;
            this.h = null;
            return;
        }
        path.setFillType(c19209px6.c());
        AbstractC24408ya0 abstractC24408ya0J = c19209px6.b().j();
        this.g = abstractC24408ya0J;
        abstractC24408ya0J.a(this);
        abstractC3236Aa0.j(abstractC24408ya0J);
        AbstractC24408ya0 abstractC24408ya0J2 = c19209px6.e().j();
        this.h = abstractC24408ya0J2;
        abstractC24408ya0J2.a(this);
        abstractC3236Aa0.j(abstractC24408ya0J2);
    }

    @Override // ir.nasim.AbstractC24408ya0.b
    public void a() {
        this.j.invalidateSelf();
    }

    @Override // ir.nasim.InterfaceC14939ik1
    public void b(List list, List list2) {
        for (int i = 0; i < list2.size(); i++) {
            InterfaceC14939ik1 interfaceC14939ik1 = (InterfaceC14939ik1) list2.get(i);
            if (interfaceC14939ik1 instanceof InterfaceC13318g15) {
                this.f.add((InterfaceC13318g15) interfaceC14939ik1);
            }
        }
    }

    @Override // ir.nasim.InterfaceC5257Io3
    public void c(Object obj, C13505gL3 c13505gL3) {
        if (obj == InterfaceC9661aL3.a) {
            this.g.o(c13505gL3);
            return;
        }
        if (obj == InterfaceC9661aL3.d) {
            this.h.o(c13505gL3);
            return;
        }
        if (obj == InterfaceC9661aL3.K) {
            AbstractC24408ya0 abstractC24408ya0 = this.i;
            if (abstractC24408ya0 != null) {
                this.c.J(abstractC24408ya0);
            }
            if (c13505gL3 == null) {
                this.i = null;
                return;
            }
            C14145hQ7 c14145hQ7 = new C14145hQ7(c13505gL3);
            this.i = c14145hQ7;
            c14145hQ7.a(this);
            this.c.j(this.i);
            return;
        }
        if (obj == InterfaceC9661aL3.j) {
            AbstractC24408ya0 abstractC24408ya02 = this.k;
            if (abstractC24408ya02 != null) {
                abstractC24408ya02.o(c13505gL3);
                return;
            }
            C14145hQ7 c14145hQ72 = new C14145hQ7(c13505gL3);
            this.k = c14145hQ72;
            c14145hQ72.a(this);
            this.c.j(this.k);
        }
    }

    @Override // ir.nasim.InterfaceC5257Io3
    public void f(C5023Ho3 c5023Ho3, int i, List list, C5023Ho3 c5023Ho32) {
        AbstractC7323Rf4.k(c5023Ho3, i, list, c5023Ho32, this);
    }

    @Override // ir.nasim.V02
    public void g(RectF rectF, Matrix matrix, boolean z) {
        this.a.reset();
        for (int i = 0; i < this.f.size(); i++) {
            this.a.addPath(((InterfaceC13318g15) this.f.get(i)).A(), matrix);
        }
        this.a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // ir.nasim.InterfaceC14939ik1
    public String getName() {
        return this.d;
    }

    @Override // ir.nasim.V02
    public void i(Canvas canvas, Matrix matrix, int i, C17470n12 c17470n12) {
        if (this.e) {
            return;
        }
        if (AbstractC6219Mr3.h()) {
            AbstractC6219Mr3.b("FillContent#draw");
        }
        float fIntValue = ((Integer) this.h.h()).intValue() / 100.0f;
        this.b.setColor((AbstractC7323Rf4.c((int) (i * fIntValue), 0, 255) << 24) | (((CX0) this.g).r() & 16777215));
        AbstractC24408ya0 abstractC24408ya0 = this.i;
        if (abstractC24408ya0 != null) {
            this.b.setColorFilter((ColorFilter) abstractC24408ya0.h());
        }
        AbstractC24408ya0 abstractC24408ya02 = this.k;
        if (abstractC24408ya02 != null) {
            float fFloatValue = ((Float) abstractC24408ya02.h()).floatValue();
            if (fFloatValue == 0.0f) {
                this.b.setMaskFilter(null);
            } else if (fFloatValue != this.l) {
                this.b.setMaskFilter(this.c.y(fFloatValue));
            }
            this.l = fFloatValue;
        }
        if (c17470n12 != null) {
            c17470n12.c((int) (fIntValue * 255.0f), this.b);
        } else {
            this.b.clearShadowLayer();
        }
        this.a.reset();
        for (int i2 = 0; i2 < this.f.size(); i2++) {
            this.a.addPath(((InterfaceC13318g15) this.f.get(i2)).A(), matrix);
        }
        canvas.drawPath(this.a, this.b);
        if (AbstractC6219Mr3.h()) {
            AbstractC6219Mr3.c("FillContent#draw");
        }
    }
}
