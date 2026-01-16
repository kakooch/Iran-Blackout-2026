package ir.nasim;

import ir.nasim.InterfaceC14371ho1;
import ir.nasim.InterfaceC19228pz7;
import java.util.List;

/* renamed from: ir.nasim.ju2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C15630ju2 {
    public static final a c = new a(null);
    public static final int d = 8;
    private static final C17403mu2 e = new C17403mu2();
    private static final InterfaceC14371ho1 f = new c(InterfaceC14371ho1.h0);
    private final FL a;
    private InterfaceC20315ro1 b;

    /* renamed from: ir.nasim.ju2$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.ju2$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ EK c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(EK ek, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = ek;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.c, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                EK ek = this.c;
                this.b = 1;
                if (ek.j(this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C15630ju2(FL fl, InterfaceC11938do1 interfaceC11938do1) {
        this.a = fl;
        this.b = AbstractC20906so1.a(f.X(AbstractC9749aV1.a()).X(interfaceC11938do1).X(P17.a((InterfaceC13730gj3) interfaceC11938do1.a(InterfaceC13730gj3.n0))));
    }

    public InterfaceC19228pz7 a(C18046nz7 c18046nz7, InterfaceC9848af5 interfaceC9848af5, UA2 ua2, UA2 ua22) {
        if (!(c18046nz7.c() instanceof C15039iu2)) {
            return null;
        }
        XV4 xv4B = AbstractC16221ku2.b(e.a(((C15039iu2) c18046nz7.c()).v(), c18046nz7.f(), c18046nz7.d()), c18046nz7, this.a, interfaceC9848af5, ua22);
        List list = (List) xv4B.a();
        Object objB = xv4B.b();
        if (list == null) {
            return new InterfaceC19228pz7.b(objB, false, 2, null);
        }
        EK ek = new EK(list, objB, c18046nz7, this.a, ua2, interfaceC9848af5);
        AbstractC10533bm0.d(this.b, null, EnumC23959xo1.UNDISPATCHED, new b(ek, null), 1, null);
        return new InterfaceC19228pz7.a(ek);
    }

    public /* synthetic */ C15630ju2(FL fl, InterfaceC11938do1 interfaceC11938do1, int i, ED1 ed1) {
        this((i & 1) != 0 ? new FL() : fl, (i & 2) != 0 ? C18712p72.a : interfaceC11938do1);
    }

    /* renamed from: ir.nasim.ju2$c */
    public static final class c extends L0 implements InterfaceC14371ho1 {
        public c(InterfaceC14371ho1.a aVar) {
            super(aVar);
        }

        @Override // ir.nasim.InterfaceC14371ho1
        public void m(InterfaceC11938do1 interfaceC11938do1, Throwable th) {
        }
    }
}
