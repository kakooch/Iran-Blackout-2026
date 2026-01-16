package ir.nasim;

import android.graphics.Path;
import ir.nasim.E44;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes2.dex */
public class F44 implements InterfaceC13318g15, ZK2 {
    private final String d;
    private final E44 f;
    private final Path a = new Path();
    private final Path b = new Path();
    private final Path c = new Path();
    private final List e = new ArrayList();

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[E44.a.values().length];
            a = iArr;
            try {
                iArr[E44.a.MERGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[E44.a.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[E44.a.SUBTRACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[E44.a.INTERSECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[E44.a.EXCLUDE_INTERSECTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public F44(E44 e44) {
        this.d = e44.c();
        this.f = e44;
    }

    private void a() {
        for (int i = 0; i < this.e.size(); i++) {
            this.c.addPath(((InterfaceC13318g15) this.e.get(i)).A());
        }
    }

    private void c(Path.Op op) {
        this.b.reset();
        this.a.reset();
        for (int size = this.e.size() - 1; size >= 1; size--) {
            InterfaceC13318g15 interfaceC13318g15 = (InterfaceC13318g15) this.e.get(size);
            if (interfaceC13318g15 instanceof C4502Fk1) {
                C4502Fk1 c4502Fk1 = (C4502Fk1) interfaceC13318g15;
                List listL = c4502Fk1.l();
                for (int size2 = listL.size() - 1; size2 >= 0; size2--) {
                    Path pathA = ((InterfaceC13318g15) listL.get(size2)).A();
                    pathA.transform(c4502Fk1.m());
                    this.b.addPath(pathA);
                }
            } else {
                this.b.addPath(interfaceC13318g15.A());
            }
        }
        InterfaceC13318g15 interfaceC13318g152 = (InterfaceC13318g15) this.e.get(0);
        if (interfaceC13318g152 instanceof C4502Fk1) {
            C4502Fk1 c4502Fk12 = (C4502Fk1) interfaceC13318g152;
            List listL2 = c4502Fk12.l();
            for (int i = 0; i < listL2.size(); i++) {
                Path pathA2 = ((InterfaceC13318g15) listL2.get(i)).A();
                pathA2.transform(c4502Fk12.m());
                this.a.addPath(pathA2);
            }
        } else {
            this.a.set(interfaceC13318g152.A());
        }
        this.c.op(this.a, this.b, op);
    }

    @Override // ir.nasim.InterfaceC13318g15
    public Path A() {
        this.c.reset();
        if (this.f.d()) {
            return this.c;
        }
        int i = a.a[this.f.b().ordinal()];
        if (i == 1) {
            a();
        } else if (i == 2) {
            c(Path.Op.UNION);
        } else if (i == 3) {
            c(Path.Op.REVERSE_DIFFERENCE);
        } else if (i == 4) {
            c(Path.Op.INTERSECT);
        } else if (i == 5) {
            c(Path.Op.XOR);
        }
        return this.c;
    }

    @Override // ir.nasim.InterfaceC14939ik1
    public void b(List list, List list2) {
        for (int i = 0; i < this.e.size(); i++) {
            ((InterfaceC13318g15) this.e.get(i)).b(list, list2);
        }
    }

    @Override // ir.nasim.ZK2
    public void h(ListIterator listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            InterfaceC14939ik1 interfaceC14939ik1 = (InterfaceC14939ik1) listIterator.previous();
            if (interfaceC14939ik1 instanceof InterfaceC13318g15) {
                this.e.add((InterfaceC13318g15) interfaceC14939ik1);
                listIterator.remove();
            }
        }
    }
}
