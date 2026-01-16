package ir.nasim;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import ir.nasim.AbstractC24408ya0;
import ir.nasim.YG4;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.Fk1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C4502Fk1 implements V02, InterfaceC13318g15, AbstractC24408ya0.b, InterfaceC5257Io3 {
    private final YG4.a a;
    private final RectF b;
    private final YG4 c;
    private final Matrix d;
    private final Path e;
    private final RectF f;
    private final String g;
    private final boolean h;
    private final List i;
    private final com.airbnb.lottie.q j;
    private List k;
    private C13263fv7 l;

    public C4502Fk1(com.airbnb.lottie.q qVar, AbstractC3236Aa0 abstractC3236Aa0, C20409rx6 c20409rx6, C23677xK3 c23677xK3) {
        this(qVar, abstractC3236Aa0, c20409rx6.c(), c20409rx6.d(), h(qVar, c23677xK3, abstractC3236Aa0, c20409rx6.b()), j(c20409rx6.b()));
    }

    private static List h(com.airbnb.lottie.q qVar, C23677xK3 c23677xK3, AbstractC3236Aa0 abstractC3236Aa0, List list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            InterfaceC14939ik1 interfaceC14939ik1A = ((InterfaceC9904al1) list.get(i)).a(qVar, c23677xK3, abstractC3236Aa0);
            if (interfaceC14939ik1A != null) {
                arrayList.add(interfaceC14939ik1A);
            }
        }
        return arrayList;
    }

    static C3636Bs j(List list) {
        for (int i = 0; i < list.size(); i++) {
            InterfaceC9904al1 interfaceC9904al1 = (InterfaceC9904al1) list.get(i);
            if (interfaceC9904al1 instanceof C3636Bs) {
                return (C3636Bs) interfaceC9904al1;
            }
        }
        return null;
    }

    private boolean n() {
        int i = 0;
        for (int i2 = 0; i2 < this.i.size(); i2++) {
            if ((this.i.get(i2) instanceof V02) && (i = i + 1) >= 2) {
                return true;
            }
        }
        return false;
    }

    @Override // ir.nasim.InterfaceC13318g15
    public Path A() {
        this.d.reset();
        C13263fv7 c13263fv7 = this.l;
        if (c13263fv7 != null) {
            this.d.set(c13263fv7.f());
        }
        this.e.reset();
        if (this.h) {
            return this.e;
        }
        for (int size = this.i.size() - 1; size >= 0; size--) {
            InterfaceC14939ik1 interfaceC14939ik1 = (InterfaceC14939ik1) this.i.get(size);
            if (interfaceC14939ik1 instanceof InterfaceC13318g15) {
                this.e.addPath(((InterfaceC13318g15) interfaceC14939ik1).A(), this.d);
            }
        }
        return this.e;
    }

    @Override // ir.nasim.AbstractC24408ya0.b
    public void a() {
        this.j.invalidateSelf();
    }

    @Override // ir.nasim.InterfaceC14939ik1
    public void b(List list, List list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.i.size());
        arrayList.addAll(list);
        for (int size = this.i.size() - 1; size >= 0; size--) {
            InterfaceC14939ik1 interfaceC14939ik1 = (InterfaceC14939ik1) this.i.get(size);
            interfaceC14939ik1.b(arrayList, this.i.subList(0, size));
            arrayList.add(interfaceC14939ik1);
        }
    }

    @Override // ir.nasim.InterfaceC5257Io3
    public void c(Object obj, C13505gL3 c13505gL3) {
        C13263fv7 c13263fv7 = this.l;
        if (c13263fv7 != null) {
            c13263fv7.c(obj, c13505gL3);
        }
    }

    @Override // ir.nasim.InterfaceC5257Io3
    public void f(C5023Ho3 c5023Ho3, int i, List list, C5023Ho3 c5023Ho32) {
        if (c5023Ho3.g(getName(), i) || "__container".equals(getName())) {
            if (!"__container".equals(getName())) {
                c5023Ho32 = c5023Ho32.a(getName());
                if (c5023Ho3.c(getName(), i)) {
                    list.add(c5023Ho32.i(this));
                }
            }
            if (c5023Ho3.h(getName(), i)) {
                int iE = i + c5023Ho3.e(getName(), i);
                for (int i2 = 0; i2 < this.i.size(); i2++) {
                    InterfaceC14939ik1 interfaceC14939ik1 = (InterfaceC14939ik1) this.i.get(i2);
                    if (interfaceC14939ik1 instanceof InterfaceC5257Io3) {
                        ((InterfaceC5257Io3) interfaceC14939ik1).f(c5023Ho3, iE, list, c5023Ho32);
                    }
                }
            }
        }
    }

    @Override // ir.nasim.V02
    public void g(RectF rectF, Matrix matrix, boolean z) {
        this.d.set(matrix);
        C13263fv7 c13263fv7 = this.l;
        if (c13263fv7 != null) {
            this.d.preConcat(c13263fv7.f());
        }
        this.f.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.i.size() - 1; size >= 0; size--) {
            InterfaceC14939ik1 interfaceC14939ik1 = (InterfaceC14939ik1) this.i.get(size);
            if (interfaceC14939ik1 instanceof V02) {
                ((V02) interfaceC14939ik1).g(this.f, this.d, z);
                rectF.union(this.f);
            }
        }
    }

    @Override // ir.nasim.InterfaceC14939ik1
    public String getName() {
        return this.g;
    }

    @Override // ir.nasim.V02
    public void i(Canvas canvas, Matrix matrix, int i, C17470n12 c17470n12) {
        if (this.h) {
            return;
        }
        this.d.set(matrix);
        C13263fv7 c13263fv7 = this.l;
        if (c13263fv7 != null) {
            this.d.preConcat(c13263fv7.f());
            i = (int) (((((this.l.h() == null ? 100 : ((Integer) this.l.h().h()).intValue()) / 100.0f) * i) / 255.0f) * 255.0f);
        }
        boolean z = (this.j.j0() && n() && i != 255) || (c17470n12 != null && this.j.k0() && n());
        int i2 = z ? 255 : i;
        if (z) {
            this.b.set(0.0f, 0.0f, 0.0f, 0.0f);
            g(this.b, matrix, true);
            YG4.a aVar = this.a;
            aVar.a = i;
            if (c17470n12 != null) {
                c17470n12.b(aVar);
                c17470n12 = null;
            } else {
                aVar.d = null;
            }
            canvas = this.c.j(canvas, this.b, this.a);
        } else if (c17470n12 != null) {
            C17470n12 c17470n122 = new C17470n12(c17470n12);
            c17470n122.i(i2);
            c17470n12 = c17470n122;
        }
        for (int size = this.i.size() - 1; size >= 0; size--) {
            Object obj = this.i.get(size);
            if (obj instanceof V02) {
                ((V02) obj).i(canvas, this.d, i2, c17470n12);
            }
        }
        if (z) {
            this.c.e();
        }
    }

    public List k() {
        return this.i;
    }

    List l() {
        if (this.k == null) {
            this.k = new ArrayList();
            for (int i = 0; i < this.i.size(); i++) {
                InterfaceC14939ik1 interfaceC14939ik1 = (InterfaceC14939ik1) this.i.get(i);
                if (interfaceC14939ik1 instanceof InterfaceC13318g15) {
                    this.k.add((InterfaceC13318g15) interfaceC14939ik1);
                }
            }
        }
        return this.k;
    }

    Matrix m() {
        C13263fv7 c13263fv7 = this.l;
        if (c13263fv7 != null) {
            return c13263fv7.f();
        }
        this.d.reset();
        return this.d;
    }

    C4502Fk1(com.airbnb.lottie.q qVar, AbstractC3236Aa0 abstractC3236Aa0, String str, boolean z, List list, C3636Bs c3636Bs) {
        this.a = new YG4.a();
        this.b = new RectF();
        this.c = new YG4();
        this.d = new Matrix();
        this.e = new Path();
        this.f = new RectF();
        this.g = str;
        this.j = qVar;
        this.h = z;
        this.i = list;
        if (c3636Bs != null) {
            C13263fv7 c13263fv7B = c3636Bs.b();
            this.l = c13263fv7B;
            c13263fv7B.a(abstractC3236Aa0);
            this.l.b(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            InterfaceC14939ik1 interfaceC14939ik1 = (InterfaceC14939ik1) list.get(size);
            if (interfaceC14939ik1 instanceof ZK2) {
                arrayList.add((ZK2) interfaceC14939ik1);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((ZK2) arrayList.get(size2)).h(list.listIterator(list.size()));
        }
    }
}
