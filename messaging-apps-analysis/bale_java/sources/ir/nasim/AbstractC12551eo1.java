package ir.nasim;

import ir.nasim.InterfaceC11938do1;

/* renamed from: ir.nasim.eo1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC12551eo1 {

    /* renamed from: ir.nasim.eo1$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final a e = new a();

        a() {
            super(2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC11938do1 invoke(InterfaceC11938do1 interfaceC11938do1, InterfaceC11938do1.b bVar) {
            if (!(bVar instanceof InterfaceC6914Pn1)) {
                return interfaceC11938do1.X(bVar);
            }
            ((InterfaceC6914Pn1) bVar).M();
            return interfaceC11938do1.X(null);
        }
    }

    /* renamed from: ir.nasim.eo1$b */
    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ C12889fL5 e;
        final /* synthetic */ boolean f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C12889fL5 c12889fL5, boolean z) {
            super(2);
            this.e = c12889fL5;
            this.f = z;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC11938do1 invoke(InterfaceC11938do1 interfaceC11938do1, InterfaceC11938do1.b bVar) {
            if (!(bVar instanceof InterfaceC6914Pn1)) {
                return interfaceC11938do1.X(bVar);
            }
            InterfaceC11938do1.b bVarA = ((InterfaceC11938do1) this.e.a).a(bVar.getKey());
            if (bVarA != null) {
                C12889fL5 c12889fL5 = this.e;
                c12889fL5.a = ((InterfaceC11938do1) c12889fL5.a).l(bVar.getKey());
                return interfaceC11938do1.X(((InterfaceC6914Pn1) bVar).P(bVarA));
            }
            InterfaceC6914Pn1 interfaceC6914Pn1 = (InterfaceC6914Pn1) bVar;
            if (this.f) {
                interfaceC6914Pn1.M();
                interfaceC6914Pn1 = null;
            }
            return interfaceC11938do1.X(interfaceC6914Pn1);
        }
    }

    /* renamed from: ir.nasim.eo1$c */
    static final class c extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final c e = new c();

        c() {
            super(2);
        }

        public final Boolean a(boolean z, InterfaceC11938do1.b bVar) {
            return Boolean.valueOf(z || (bVar instanceof InterfaceC6914Pn1));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a(((Boolean) obj).booleanValue(), (InterfaceC11938do1.b) obj2);
        }
    }

    private static final InterfaceC11938do1 a(InterfaceC11938do1 interfaceC11938do1, InterfaceC11938do1 interfaceC11938do12, boolean z) {
        boolean zC = c(interfaceC11938do1);
        boolean zC2 = c(interfaceC11938do12);
        if (!zC && !zC2) {
            return interfaceC11938do1.X(interfaceC11938do12);
        }
        C12889fL5 c12889fL5 = new C12889fL5();
        c12889fL5.a = interfaceC11938do12;
        C18712p72 c18712p72 = C18712p72.a;
        InterfaceC11938do1 interfaceC11938do13 = (InterfaceC11938do1) interfaceC11938do1.f0(c18712p72, new b(c12889fL5, z));
        if (zC2) {
            c12889fL5.a = ((InterfaceC11938do1) c12889fL5.a).f0(c18712p72, a.e);
        }
        return interfaceC11938do13.X((InterfaceC11938do1) c12889fL5.a);
    }

    public static final String b(InterfaceC11938do1 interfaceC11938do1) {
        return null;
    }

    private static final boolean c(InterfaceC11938do1 interfaceC11938do1) {
        return ((Boolean) interfaceC11938do1.f0(Boolean.FALSE, c.e)).booleanValue();
    }

    public static final InterfaceC11938do1 d(InterfaceC11938do1 interfaceC11938do1, InterfaceC11938do1 interfaceC11938do12) {
        return !c(interfaceC11938do12) ? interfaceC11938do1.X(interfaceC11938do12) : a(interfaceC11938do1, interfaceC11938do12, false);
    }

    public static final InterfaceC11938do1 e(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC11938do1 interfaceC11938do1) {
        InterfaceC11938do1 interfaceC11938do1A = a(interfaceC20315ro1.getCoroutineContext(), interfaceC11938do1, true);
        return (interfaceC11938do1A == C12366eV1.a() || interfaceC11938do1A.a(InterfaceC22753vm1.g0) != null) ? interfaceC11938do1A : interfaceC11938do1A.X(C12366eV1.a());
    }

    public static final C12801fB7 f(InterfaceC23369wo1 interfaceC23369wo1) {
        while (!(interfaceC23369wo1 instanceof VU1) && (interfaceC23369wo1 = interfaceC23369wo1.getCallerFrame()) != null) {
            if (interfaceC23369wo1 instanceof C12801fB7) {
                return (C12801fB7) interfaceC23369wo1;
            }
        }
        return null;
    }

    public static final C12801fB7 g(InterfaceC20295rm1 interfaceC20295rm1, InterfaceC11938do1 interfaceC11938do1, Object obj) {
        if (!(interfaceC20295rm1 instanceof InterfaceC23369wo1) || interfaceC11938do1.a(C14010hB7.a) == null) {
            return null;
        }
        C12801fB7 c12801fB7F = f((InterfaceC23369wo1) interfaceC20295rm1);
        if (c12801fB7F != null) {
            c12801fB7F.i1(interfaceC11938do1, obj);
        }
        return c12801fB7F;
    }
}
