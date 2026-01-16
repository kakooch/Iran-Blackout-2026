package ir.nasim;

import ir.nasim.AbstractC10266bM5;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Rm3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C7385Rm3 implements InterfaceC6907Pm3 {
    static final /* synthetic */ InterfaceC5239Im3[] d = {AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(C7385Rm3.class), "upperBounds", "getUpperBounds()Ljava/util/List;"))};
    private final AbstractC10266bM5.a a;
    private final InterfaceC7619Sm3 b;
    private final InterfaceC22882vy7 c;

    /* renamed from: ir.nasim.Rm3$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        public final List invoke() {
            List upperBounds = C7385Rm3.this.b().getUpperBounds();
            AbstractC13042fc3.h(upperBounds, "descriptor.upperBounds");
            List list = upperBounds;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new C6673Om3((AbstractC4099Dr3) it.next(), null, 2, null));
            }
            return arrayList;
        }
    }

    public C7385Rm3(InterfaceC7619Sm3 interfaceC7619Sm3, InterfaceC22882vy7 interfaceC22882vy7) {
        C12533em3 c12533em3C;
        Object objQ0;
        AbstractC13042fc3.i(interfaceC22882vy7, "descriptor");
        this.c = interfaceC22882vy7;
        this.a = AbstractC10266bM5.c(new a());
        if (interfaceC7619Sm3 == null) {
            InterfaceC12795fB1 interfaceC12795fB1B = b().b();
            AbstractC13042fc3.h(interfaceC12795fB1B, "descriptor.containingDeclaration");
            if (interfaceC12795fB1B instanceof InterfaceC21331tU0) {
                objQ0 = c((InterfaceC21331tU0) interfaceC12795fB1B);
            } else {
                if (!(interfaceC12795fB1B instanceof InterfaceC15194jA0)) {
                    throw new C25175zr3("Unknown type parameter container: " + interfaceC12795fB1B);
                }
                InterfaceC12795fB1 interfaceC12795fB1B2 = ((InterfaceC15194jA0) interfaceC12795fB1B).b();
                AbstractC13042fc3.h(interfaceC12795fB1B2, "declaration.containingDeclaration");
                if (interfaceC12795fB1B2 instanceof InterfaceC21331tU0) {
                    c12533em3C = c((InterfaceC21331tU0) interfaceC12795fB1B2);
                } else {
                    InterfaceC13485gJ1 interfaceC13485gJ1 = (InterfaceC13485gJ1) (!(interfaceC12795fB1B instanceof InterfaceC13485gJ1) ? null : interfaceC12795fB1B);
                    if (interfaceC13485gJ1 == null) {
                        throw new C25175zr3("Non-class callable descriptor must be deserialized: " + interfaceC12795fB1B);
                    }
                    InterfaceC11299cm3 interfaceC11299cm3E = AbstractC4762Gl3.e(a(interfaceC13485gJ1));
                    if (interfaceC11299cm3E == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
                    }
                    c12533em3C = (C12533em3) interfaceC11299cm3E;
                }
                objQ0 = interfaceC12795fB1B.q0(new C7428Rr1(c12533em3C), C19938rB7.a);
            }
            AbstractC13042fc3.h(objQ0, "when (val declaration = … $declaration\")\n        }");
            interfaceC7619Sm3 = (InterfaceC7619Sm3) objQ0;
        }
        this.b = interfaceC7619Sm3;
    }

    private final Class a(InterfaceC13485gJ1 interfaceC13485gJ1) {
        Class clsD;
        InterfaceC12258eJ1 interfaceC12258eJ1L = interfaceC13485gJ1.L();
        if (!(interfaceC12258eJ1L instanceof C6898Pl3)) {
            interfaceC12258eJ1L = null;
        }
        C6898Pl3 c6898Pl3 = (C6898Pl3) interfaceC12258eJ1L;
        InterfaceC22805vr3 interfaceC22805vr3F = c6898Pl3 != null ? c6898Pl3.f() : null;
        WL5 wl5 = (WL5) (interfaceC22805vr3F instanceof WL5 ? interfaceC22805vr3F : null);
        if (wl5 != null && (clsD = wl5.d()) != null) {
            return clsD;
        }
        throw new C25175zr3("Container of deserialized member is not resolved: " + interfaceC13485gJ1);
    }

    private final C12533em3 c(InterfaceC21331tU0 interfaceC21331tU0) {
        Class clsM = AbstractC14729iN7.m(interfaceC21331tU0);
        C12533em3 c12533em3 = (C12533em3) (clsM != null ? AbstractC4762Gl3.e(clsM) : null);
        if (c12533em3 != null) {
            return c12533em3;
        }
        throw new C25175zr3("Type parameter container is not resolved: " + interfaceC21331tU0.b());
    }

    public InterfaceC22882vy7 b() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C7385Rm3) {
            C7385Rm3 c7385Rm3 = (C7385Rm3) obj;
            if (AbstractC13042fc3.d(this.b, c7385Rm3.b) && AbstractC13042fc3.d(getName(), c7385Rm3.getName())) {
                return true;
            }
        }
        return false;
    }

    @Override // ir.nasim.InterfaceC6907Pm3
    public String getName() {
        String strH = b().getName().h();
        AbstractC13042fc3.h(strH, "descriptor.name.asString()");
        return strH;
    }

    @Override // ir.nasim.InterfaceC6907Pm3
    public List getUpperBounds() {
        return (List) this.a.b(this, d[0]);
    }

    public int hashCode() {
        return (this.b.hashCode() * 31) + getName().hashCode();
    }

    @Override // ir.nasim.InterfaceC6907Pm3
    public EnumC8326Vm3 m() {
        int i = AbstractC7151Qm3.a[b().m().ordinal()];
        if (i == 1) {
            return EnumC8326Vm3.a;
        }
        if (i == 2) {
            return EnumC8326Vm3.b;
        }
        if (i == 3) {
            return EnumC8326Vm3.c;
        }
        throw new NoWhenBranchMatchedException();
    }

    public String toString() {
        return AbstractC24652yy7.a.a(this);
    }
}
