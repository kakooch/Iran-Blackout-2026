package ir.nasim;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public class AQ7 extends GQ7 implements InterfaceC24919zQ7 {
    public static final a l = new a(null);
    private final int f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final AbstractC4099Dr3 j;
    private final InterfaceC24919zQ7 k;

    public static final class a {
        private a() {
        }

        public final AQ7 a(InterfaceC14592iA0 interfaceC14592iA0, InterfaceC24919zQ7 interfaceC24919zQ7, int i, InterfaceC4356Eu interfaceC4356Eu, C6432No4 c6432No4, AbstractC4099Dr3 abstractC4099Dr3, boolean z, boolean z2, boolean z3, AbstractC4099Dr3 abstractC4099Dr32, JH6 jh6, SA2 sa2) {
            AbstractC13042fc3.i(interfaceC14592iA0, "containingDeclaration");
            AbstractC13042fc3.i(interfaceC4356Eu, "annotations");
            AbstractC13042fc3.i(c6432No4, "name");
            AbstractC13042fc3.i(abstractC4099Dr3, "outType");
            AbstractC13042fc3.i(jh6, "source");
            return sa2 == null ? new AQ7(interfaceC14592iA0, interfaceC24919zQ7, i, interfaceC4356Eu, c6432No4, abstractC4099Dr3, z, z2, z3, abstractC4099Dr32, jh6) : new b(interfaceC14592iA0, interfaceC24919zQ7, i, interfaceC4356Eu, c6432No4, abstractC4099Dr3, z, z2, z3, abstractC4099Dr32, jh6, sa2);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public static final class b extends AQ7 {
        private final InterfaceC9173Yu3 m;

        static final class a extends AbstractC8614Ws3 implements SA2 {
            a() {
                super(0);
            }

            @Override // ir.nasim.SA2
            public final List invoke() {
                return b.this.M0();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(InterfaceC14592iA0 interfaceC14592iA0, InterfaceC24919zQ7 interfaceC24919zQ7, int i, InterfaceC4356Eu interfaceC4356Eu, C6432No4 c6432No4, AbstractC4099Dr3 abstractC4099Dr3, boolean z, boolean z2, boolean z3, AbstractC4099Dr3 abstractC4099Dr32, JH6 jh6, SA2 sa2) {
            super(interfaceC14592iA0, interfaceC24919zQ7, i, interfaceC4356Eu, c6432No4, abstractC4099Dr3, z, z2, z3, abstractC4099Dr32, jh6);
            AbstractC13042fc3.i(interfaceC14592iA0, "containingDeclaration");
            AbstractC13042fc3.i(interfaceC4356Eu, "annotations");
            AbstractC13042fc3.i(c6432No4, "name");
            AbstractC13042fc3.i(abstractC4099Dr3, "outType");
            AbstractC13042fc3.i(jh6, "source");
            AbstractC13042fc3.i(sa2, "destructuringVariables");
            this.m = AbstractC13269fw3.a(sa2);
        }

        public final List M0() {
            return (List) this.m.getValue();
        }

        @Override // ir.nasim.AQ7, ir.nasim.InterfaceC24919zQ7
        public InterfaceC24919zQ7 Z(InterfaceC14592iA0 interfaceC14592iA0, C6432No4 c6432No4, int i) {
            AbstractC13042fc3.i(interfaceC14592iA0, "newOwner");
            AbstractC13042fc3.i(c6432No4, "newName");
            InterfaceC4356Eu annotations = getAnnotations();
            AbstractC13042fc3.h(annotations, "annotations");
            AbstractC4099Dr3 type = getType();
            AbstractC13042fc3.h(type, "type");
            boolean zY0 = y0();
            boolean zR0 = r0();
            boolean zP0 = p0();
            AbstractC4099Dr3 abstractC4099Dr3U0 = u0();
            JH6 jh6 = JH6.a;
            AbstractC13042fc3.h(jh6, "NO_SOURCE");
            return new b(interfaceC14592iA0, null, i, annotations, c6432No4, type, zY0, zR0, zP0, abstractC4099Dr3U0, jh6, new a());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AQ7(InterfaceC14592iA0 interfaceC14592iA0, InterfaceC24919zQ7 interfaceC24919zQ7, int i, InterfaceC4356Eu interfaceC4356Eu, C6432No4 c6432No4, AbstractC4099Dr3 abstractC4099Dr3, boolean z, boolean z2, boolean z3, AbstractC4099Dr3 abstractC4099Dr32, JH6 jh6) {
        super(interfaceC14592iA0, interfaceC4356Eu, c6432No4, abstractC4099Dr3, jh6);
        AbstractC13042fc3.i(interfaceC14592iA0, "containingDeclaration");
        AbstractC13042fc3.i(interfaceC4356Eu, "annotations");
        AbstractC13042fc3.i(c6432No4, "name");
        AbstractC13042fc3.i(abstractC4099Dr3, "outType");
        AbstractC13042fc3.i(jh6, "source");
        this.f = i;
        this.g = z;
        this.h = z2;
        this.i = z3;
        this.j = abstractC4099Dr32;
        this.k = interfaceC24919zQ7 == null ? this : interfaceC24919zQ7;
    }

    public static final AQ7 J0(InterfaceC14592iA0 interfaceC14592iA0, InterfaceC24919zQ7 interfaceC24919zQ7, int i, InterfaceC4356Eu interfaceC4356Eu, C6432No4 c6432No4, AbstractC4099Dr3 abstractC4099Dr3, boolean z, boolean z2, boolean z3, AbstractC4099Dr3 abstractC4099Dr32, JH6 jh6, SA2 sa2) {
        return l.a(interfaceC14592iA0, interfaceC24919zQ7, i, interfaceC4356Eu, c6432No4, abstractC4099Dr3, z, z2, z3, abstractC4099Dr32, jh6, sa2);
    }

    public Void K0() {
        return null;
    }

    @Override // ir.nasim.InterfaceC19829r07
    /* renamed from: L0, reason: merged with bridge method [inline-methods] */
    public InterfaceC24919zQ7 c(C5585Jy7 c5585Jy7) {
        AbstractC13042fc3.i(c5585Jy7, "substitutor");
        if (c5585Jy7.k()) {
            return this;
        }
        throw new UnsupportedOperationException();
    }

    @Override // ir.nasim.FQ7
    public boolean P() {
        return false;
    }

    @Override // ir.nasim.InterfaceC24919zQ7
    public InterfaceC24919zQ7 Z(InterfaceC14592iA0 interfaceC14592iA0, C6432No4 c6432No4, int i) {
        AbstractC13042fc3.i(interfaceC14592iA0, "newOwner");
        AbstractC13042fc3.i(c6432No4, "newName");
        InterfaceC4356Eu annotations = getAnnotations();
        AbstractC13042fc3.h(annotations, "annotations");
        AbstractC4099Dr3 type = getType();
        AbstractC13042fc3.h(type, "type");
        boolean zY0 = y0();
        boolean zR0 = r0();
        boolean zP0 = p0();
        AbstractC4099Dr3 abstractC4099Dr3U0 = u0();
        JH6 jh6 = JH6.a;
        AbstractC13042fc3.h(jh6, "NO_SOURCE");
        return new AQ7(interfaceC14592iA0, null, i, annotations, c6432No4, type, zY0, zR0, zP0, abstractC4099Dr3U0, jh6);
    }

    @Override // ir.nasim.InterfaceC14592iA0
    public Collection d() {
        Collection collectionD = b().d();
        AbstractC13042fc3.h(collectionD, "containingDeclaration.overriddenDescriptors");
        Collection collection = collectionD;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(collection, 10));
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add((InterfaceC24919zQ7) ((InterfaceC14592iA0) it.next()).h().get(getIndex()));
        }
        return arrayList;
    }

    @Override // ir.nasim.InterfaceC24919zQ7
    public int getIndex() {
        return this.f;
    }

    @Override // ir.nasim.InterfaceC16977mB1
    public RI1 getVisibility() {
        RI1 ri1 = QI1.f;
        AbstractC13042fc3.h(ri1, "LOCAL");
        return ri1;
    }

    @Override // ir.nasim.FQ7
    public /* bridge */ /* synthetic */ AbstractC7068Qd1 o0() {
        return (AbstractC7068Qd1) K0();
    }

    @Override // ir.nasim.InterfaceC24919zQ7
    public boolean p0() {
        return this.i;
    }

    @Override // ir.nasim.InterfaceC12795fB1
    public Object q0(InterfaceC15204jB1 interfaceC15204jB1, Object obj) {
        AbstractC13042fc3.i(interfaceC15204jB1, "visitor");
        return interfaceC15204jB1.m(this, obj);
    }

    @Override // ir.nasim.InterfaceC24919zQ7
    public boolean r0() {
        return this.h;
    }

    @Override // ir.nasim.InterfaceC24919zQ7
    public AbstractC4099Dr3 u0() {
        return this.j;
    }

    @Override // ir.nasim.InterfaceC24919zQ7
    public boolean y0() {
        return this.g && ((InterfaceC15194jA0) b()).f().a();
    }

    @Override // ir.nasim.AbstractC14602iB1, ir.nasim.InterfaceC12795fB1
    public InterfaceC14592iA0 b() {
        return (InterfaceC14592iA0) super.b();
    }

    @Override // ir.nasim.AbstractC14602iB1
    public InterfaceC24919zQ7 a() {
        InterfaceC24919zQ7 interfaceC24919zQ7 = this.k;
        return interfaceC24919zQ7 == this ? this : interfaceC24919zQ7.a();
    }
}
