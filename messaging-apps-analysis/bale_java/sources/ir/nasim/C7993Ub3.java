package ir.nasim;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* renamed from: ir.nasim.Ub3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C7993Ub3 implements InterfaceC13882gy7, InterfaceC8227Vb3 {
    private AbstractC4099Dr3 a;
    private final LinkedHashSet b;
    private final int c;

    /* renamed from: ir.nasim.Ub3$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final XC6 invoke(AbstractC5284Ir3 abstractC5284Ir3) {
            AbstractC13042fc3.i(abstractC5284Ir3, "kotlinTypeRefiner");
            return C7993Ub3.this.a(abstractC5284Ir3).g();
        }
    }

    /* renamed from: ir.nasim.Ub3$b */
    public static final class b implements Comparator {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return AbstractC18050o01.d(((AbstractC4099Dr3) obj).toString(), ((AbstractC4099Dr3) obj2).toString());
        }
    }

    public C7993Ub3(Collection collection) {
        AbstractC13042fc3.i(collection, "typesToIntersect");
        collection.isEmpty();
        LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
        this.b = linkedHashSet;
        this.c = linkedHashSet.hashCode();
    }

    private final String i(Iterable iterable) {
        return AbstractC15401jX0.A0(AbstractC15401jX0.a1(iterable, new b()), " & ", "{", "}", 0, null, null, 56, null);
    }

    @Override // ir.nasim.InterfaceC13882gy7
    public Collection b() {
        return this.b;
    }

    @Override // ir.nasim.InterfaceC13882gy7
    /* renamed from: d */
    public MU0 t() {
        return null;
    }

    @Override // ir.nasim.InterfaceC13882gy7
    public boolean e() {
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C7993Ub3) {
            return AbstractC13042fc3.d(this.b, ((C7993Ub3) obj).b);
        }
        return false;
    }

    public final W24 f() {
        return C18628oy7.d.a("member scope for intersection type", this.b);
    }

    public final XC6 g() {
        C4567Fr3 c4567Fr3 = C4567Fr3.a;
        return C4567Fr3.k(InterfaceC4356Eu.W.b(), this, AbstractC10360bX0.m(), false, f(), new a());
    }

    @Override // ir.nasim.InterfaceC13882gy7
    public List getParameters() {
        return AbstractC10360bX0.m();
    }

    public final AbstractC4099Dr3 h() {
        return this.a;
    }

    public int hashCode() {
        return this.c;
    }

    @Override // ir.nasim.InterfaceC13882gy7
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C7993Ub3 a(AbstractC5284Ir3 abstractC5284Ir3) {
        AbstractC13042fc3.i(abstractC5284Ir3, "kotlinTypeRefiner");
        Collection collectionB = b();
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(collectionB, 10));
        Iterator it = collectionB.iterator();
        boolean z = false;
        while (it.hasNext()) {
            arrayList.add(((AbstractC4099Dr3) it.next()).U0(abstractC5284Ir3));
            z = true;
        }
        C7993Ub3 c7993Ub3K = null;
        if (z) {
            AbstractC4099Dr3 abstractC4099Dr3H = h();
            c7993Ub3K = new C7993Ub3(arrayList).k(abstractC4099Dr3H != null ? abstractC4099Dr3H.U0(abstractC5284Ir3) : null);
        }
        return c7993Ub3K == null ? this : c7993Ub3K;
    }

    public final C7993Ub3 k(AbstractC4099Dr3 abstractC4099Dr3) {
        return new C7993Ub3(this.b, abstractC4099Dr3);
    }

    @Override // ir.nasim.InterfaceC13882gy7
    public AbstractC19738qr3 n() {
        AbstractC19738qr3 abstractC19738qr3N = ((AbstractC4099Dr3) this.b.iterator().next()).K0().n();
        AbstractC13042fc3.h(abstractC19738qr3N, "intersectedTypes.iterator().next().constructor.builtIns");
        return abstractC19738qr3N;
    }

    public String toString() {
        return i(this.b);
    }

    private C7993Ub3(Collection collection, AbstractC4099Dr3 abstractC4099Dr3) {
        this(collection);
        this.a = abstractC4099Dr3;
    }
}
