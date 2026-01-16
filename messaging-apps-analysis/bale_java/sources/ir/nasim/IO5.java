package ir.nasim;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import ir.nasim.AbstractC24408ya0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes2.dex */
public class IO5 implements V02, InterfaceC13318g15, ZK2, AbstractC24408ya0.b, InterfaceC5491Jo3 {
    private final Matrix a = new Matrix();
    private final Path b = new Path();
    private final com.airbnb.lottie.q c;
    private final AbstractC3236Aa0 d;
    private final String e;
    private final boolean f;
    private final AbstractC24408ya0 g;
    private final AbstractC24408ya0 h;
    private final C13263fv7 i;
    private C4502Fk1 j;

    public IO5(com.airbnb.lottie.q qVar, AbstractC3236Aa0 abstractC3236Aa0, HO5 ho5) {
        this.c = qVar;
        this.d = abstractC3236Aa0;
        this.e = ho5.c();
        this.f = ho5.f();
        C11959dq2 c11959dq2J = ho5.b().j();
        this.g = c11959dq2J;
        abstractC3236Aa0.j(c11959dq2J);
        c11959dq2J.a(this);
        C11959dq2 c11959dq2J2 = ho5.d().j();
        this.h = c11959dq2J2;
        abstractC3236Aa0.j(c11959dq2J2);
        c11959dq2J2.a(this);
        C13263fv7 c13263fv7B = ho5.e().b();
        this.i = c13263fv7B;
        c13263fv7B.a(abstractC3236Aa0);
        c13263fv7B.b(this);
    }

    @Override // ir.nasim.InterfaceC13318g15
    public Path A() {
        Path pathA = this.j.A();
        this.b.reset();
        float fFloatValue = ((Float) this.g.h()).floatValue();
        float fFloatValue2 = ((Float) this.h.h()).floatValue();
        for (int i = ((int) fFloatValue) - 1; i >= 0; i--) {
            this.a.set(this.i.g(i + fFloatValue2));
            this.b.addPath(pathA, this.a);
        }
        return this.b;
    }

    @Override // ir.nasim.AbstractC24408ya0.b
    public void a() {
        this.c.invalidateSelf();
    }

    @Override // ir.nasim.InterfaceC14939ik1
    public void b(List list, List list2) {
        this.j.b(list, list2);
    }

    @Override // ir.nasim.InterfaceC5257Io3
    public void c(Object obj, C13505gL3 c13505gL3) {
        if (this.i.c(obj, c13505gL3)) {
            return;
        }
        if (obj == InterfaceC9661aL3.u) {
            this.g.o(c13505gL3);
        } else if (obj == InterfaceC9661aL3.v) {
            this.h.o(c13505gL3);
        }
    }

    @Override // ir.nasim.InterfaceC5257Io3
    public void f(C5023Ho3 c5023Ho3, int i, List list, C5023Ho3 c5023Ho32) {
        AbstractC7323Rf4.k(c5023Ho3, i, list, c5023Ho32, this);
        for (int i2 = 0; i2 < this.j.k().size(); i2++) {
            InterfaceC14939ik1 interfaceC14939ik1 = (InterfaceC14939ik1) this.j.k().get(i2);
            if (interfaceC14939ik1 instanceof InterfaceC5491Jo3) {
                AbstractC7323Rf4.k(c5023Ho3, i, list, c5023Ho32, (InterfaceC5491Jo3) interfaceC14939ik1);
            }
        }
    }

    @Override // ir.nasim.V02
    public void g(RectF rectF, Matrix matrix, boolean z) {
        this.j.g(rectF, matrix, z);
    }

    @Override // ir.nasim.InterfaceC14939ik1
    public String getName() {
        return this.e;
    }

    @Override // ir.nasim.ZK2
    public void h(ListIterator listIterator) {
        if (this.j != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add((InterfaceC14939ik1) listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.j = new C4502Fk1(this.c, this.d, "Repeater", this.f, arrayList, null);
    }

    @Override // ir.nasim.V02
    public void i(Canvas canvas, Matrix matrix, int i, C17470n12 c17470n12) {
        float fFloatValue = ((Float) this.g.h()).floatValue();
        float fFloatValue2 = ((Float) this.h.h()).floatValue();
        float fFloatValue3 = ((Float) this.i.i().h()).floatValue() / 100.0f;
        float fFloatValue4 = ((Float) this.i.e().h()).floatValue() / 100.0f;
        for (int i2 = ((int) fFloatValue) - 1; i2 >= 0; i2--) {
            this.a.set(matrix);
            float f = i2;
            this.a.preConcat(this.i.g(f + fFloatValue2));
            this.j.i(canvas, this.a, (int) (i * AbstractC7323Rf4.i(fFloatValue3, fFloatValue4, f / fFloatValue)), c17470n12);
        }
    }
}
