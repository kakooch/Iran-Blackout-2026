package ir.nasim;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.Qv3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C7232Qv3 implements InterfaceC21651tu, InterfaceC9301Zi5 {
    static final /* synthetic */ InterfaceC5239Im3[] i = {AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(C7232Qv3.class), "fqName", "getFqName()Lorg/jetbrains/kotlin/name/FqName;")), AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(C7232Qv3.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;")), AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(C7232Qv3.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    private final C9182Yv3 a;
    private final InterfaceC4009Dh3 b;
    private final InterfaceC20580sF4 c;
    private final InterfaceC23016wC4 d;
    private final InterfaceC4486Fi3 e;
    private final InterfaceC23016wC4 f;
    private final boolean g;
    private final boolean h;

    /* renamed from: ir.nasim.Qv3$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Map invoke() {
            Collection<InterfaceC4243Eh3> collectionD = C7232Qv3.this.b.d();
            C7232Qv3 c7232Qv3 = C7232Qv3.this;
            ArrayList arrayList = new ArrayList();
            for (InterfaceC4243Eh3 interfaceC4243Eh3 : collectionD) {
                C6432No4 name = interfaceC4243Eh3.getName();
                if (name == null) {
                    name = AbstractC24521yl3.c;
                }
                AbstractC7068Qd1 abstractC7068Qd1M = c7232Qv3.m(interfaceC4243Eh3);
                XV4 xv4A = abstractC7068Qd1M == null ? null : AbstractC4616Fw7.a(name, abstractC7068Qd1M);
                if (xv4A != null) {
                    arrayList.add(xv4A);
                }
            }
            return AbstractC20051rO3.w(arrayList);
        }
    }

    /* renamed from: ir.nasim.Qv3$b */
    static final class b extends AbstractC8614Ws3 implements SA2 {
        b() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C9424Zw2 invoke() {
            C24948zU0 c24948zU0F = C7232Qv3.this.b.f();
            if (c24948zU0F == null) {
                return null;
            }
            return c24948zU0F.b();
        }
    }

    /* renamed from: ir.nasim.Qv3$c */
    static final class c extends AbstractC8614Ws3 implements SA2 {
        c() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final XC6 invoke() {
            C9424Zw2 c9424Zw2E = C7232Qv3.this.e();
            if (c9424Zw2E == null) {
                return AbstractC14230ha2.j(AbstractC13042fc3.q("No fqName: ", C7232Qv3.this.b));
            }
            InterfaceC21331tU0 interfaceC21331tU0H = C5437Ji3.h(C5437Ji3.a, c9424Zw2E, C7232Qv3.this.a.d().n(), null, 4, null);
            if (interfaceC21331tU0H == null) {
                InterfaceC7106Qh3 interfaceC7106Qh3T = C7232Qv3.this.b.t();
                interfaceC21331tU0H = interfaceC7106Qh3T == null ? null : C7232Qv3.this.a.a().m().a(interfaceC7106Qh3T);
                if (interfaceC21331tU0H == null) {
                    interfaceC21331tU0H = C7232Qv3.this.f(c9424Zw2E);
                }
            }
            return interfaceC21331tU0H.p();
        }
    }

    public C7232Qv3(C9182Yv3 c9182Yv3, InterfaceC4009Dh3 interfaceC4009Dh3, boolean z) {
        AbstractC13042fc3.i(c9182Yv3, "c");
        AbstractC13042fc3.i(interfaceC4009Dh3, "javaAnnotation");
        this.a = c9182Yv3;
        this.b = interfaceC4009Dh3;
        this.c = c9182Yv3.e().g(new b());
        this.d = c9182Yv3.e().c(new c());
        this.e = c9182Yv3.a().s().a(interfaceC4009Dh3);
        this.f = c9182Yv3.e().c(new a());
        this.g = interfaceC4009Dh3.g();
        this.h = interfaceC4009Dh3.H() || z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC21331tU0 f(C9424Zw2 c9424Zw2) {
        InterfaceC8507Wg4 interfaceC8507Wg4D = this.a.d();
        C24948zU0 c24948zU0M = C24948zU0.m(c9424Zw2);
        AbstractC13042fc3.h(c24948zU0M, "topLevel(fqName)");
        return AbstractC23370wo2.c(interfaceC8507Wg4D, c24948zU0M, this.a.a().b().f().q());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AbstractC7068Qd1 m(InterfaceC4243Eh3 interfaceC4243Eh3) {
        if (interfaceC4243Eh3 instanceof InterfaceC18466oi3) {
            return C7302Rd1.a.c(((InterfaceC18466oi3) interfaceC4243Eh3).getValue());
        }
        if (interfaceC4243Eh3 instanceof InterfaceC14311hi3) {
            InterfaceC14311hi3 interfaceC14311hi3 = (InterfaceC14311hi3) interfaceC4243Eh3;
            return p(interfaceC14311hi3.d(), interfaceC14311hi3.e());
        }
        if (interfaceC4243Eh3 instanceof InterfaceC5662Kh3) {
            C6432No4 name = interfaceC4243Eh3.getName();
            if (name == null) {
                name = AbstractC24521yl3.c;
            }
            AbstractC13042fc3.h(name, "argument.name ?: DEFAULT_ANNOTATION_MEMBER_NAME");
            return o(name, ((InterfaceC5662Kh3) interfaceC4243Eh3).c());
        }
        if (interfaceC4243Eh3 instanceof InterfaceC4477Fh3) {
            return n(((InterfaceC4477Fh3) interfaceC4243Eh3).a());
        }
        if (interfaceC4243Eh3 instanceof InterfaceC8281Vh3) {
            return q(((InterfaceC8281Vh3) interfaceC4243Eh3).b());
        }
        return null;
    }

    private final AbstractC7068Qd1 n(InterfaceC4009Dh3 interfaceC4009Dh3) {
        return new C4122Du(new C7232Qv3(this.a, interfaceC4009Dh3, false, 4, null));
    }

    private final AbstractC7068Qd1 o(C6432No4 c6432No4, List list) {
        XC6 type = getType();
        AbstractC13042fc3.h(type, "type");
        if (AbstractC4816Gr3.a(type)) {
            return null;
        }
        InterfaceC21331tU0 interfaceC21331tU0F = PI1.f(this);
        AbstractC13042fc3.f(interfaceC21331tU0F);
        InterfaceC24919zQ7 interfaceC24919zQ7B = KI1.b(c6432No4, interfaceC21331tU0F);
        AbstractC4099Dr3 type2 = interfaceC24919zQ7B != null ? interfaceC24919zQ7B.getType() : null;
        if (type2 == null) {
            type2 = this.a.a().l().n().l(KQ7.INVARIANT, AbstractC14230ha2.j("Unknown array element type"));
        }
        AbstractC13042fc3.h(type2, "DescriptorResolverUtils.getAnnotationParameterByName(argumentName, annotationClass!!)?.type\n            // Try to load annotation arguments even if the annotation class is not found\n                ?: c.components.module.builtIns.getArrayType(\n                    Variance.INVARIANT,\n                    ErrorUtils.createErrorType(\"Unknown array element type\")\n                )");
        List list2 = list;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            AbstractC7068Qd1 abstractC7068Qd1M = m((InterfaceC4243Eh3) it.next());
            if (abstractC7068Qd1M == null) {
                abstractC7068Qd1M = new C12834fF4();
            }
            arrayList.add(abstractC7068Qd1M);
        }
        return C7302Rd1.a.a(arrayList, type2);
    }

    private final AbstractC7068Qd1 p(C24948zU0 c24948zU0, C6432No4 c6432No4) {
        if (c24948zU0 == null || c6432No4 == null) {
            return null;
        }
        return new N92(c24948zU0, c6432No4);
    }

    private final AbstractC7068Qd1 q(InterfaceC6138Mi3 interfaceC6138Mi3) {
        return C13760gm3.b.a(this.a.g().n(interfaceC6138Mi3, AbstractC8790Xi3.f(EnumC7263Qy7.COMMON, false, null, 3, null)));
    }

    @Override // ir.nasim.InterfaceC21651tu
    public C9424Zw2 e() {
        return (C9424Zw2) MN6.b(this.c, this, i[0]);
    }

    @Override // ir.nasim.InterfaceC9301Zi5
    public boolean g() {
        return this.g;
    }

    @Override // ir.nasim.InterfaceC21651tu
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public InterfaceC4486Fi3 i() {
        return this.e;
    }

    @Override // ir.nasim.InterfaceC21651tu
    public Map j() {
        return (Map) MN6.a(this.f, this, i[2]);
    }

    @Override // ir.nasim.InterfaceC21651tu
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public XC6 getType() {
        return (XC6) MN6.a(this.d, this, i[1]);
    }

    public final boolean l() {
        return this.h;
    }

    public String toString() {
        return FI1.t(FI1.g, this, null, 2, null);
    }

    public /* synthetic */ C7232Qv3(C9182Yv3 c9182Yv3, InterfaceC4009Dh3 interfaceC4009Dh3, boolean z, int i2, ED1 ed1) {
        this(c9182Yv3, interfaceC4009Dh3, (i2 & 4) != 0 ? false : z);
    }
}
