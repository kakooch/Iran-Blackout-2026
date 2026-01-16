package androidx.compose.material.ripple;

import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC19153ps;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC22920w26;
import ir.nasim.AbstractC6392Nk0;
import ir.nasim.C12403eZ2;
import ir.nasim.C13012fZ2;
import ir.nasim.C15607js;
import ir.nasim.C17484n26;
import ir.nasim.C19938rB7;
import ir.nasim.C23400wr2;
import ir.nasim.C23990xr2;
import ir.nasim.C24381yX0;
import ir.nasim.FZ1;
import ir.nasim.GV0;
import ir.nasim.GZ1;
import ir.nasim.HZ1;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC17460n02;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC22645vb3;
import ir.nasim.InterfaceC5766Kt;
import ir.nasim.OD6;
import ir.nasim.SA2;
import ir.nasim.YZ1;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
final class e {
    private final boolean a;
    private final SA2 b;
    private final C15607js c = AbstractC19153ps.b(0.0f, 0.0f, 2, null);
    private final List d = new ArrayList();
    private InterfaceC22645vb3 e;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ float d;
        final /* synthetic */ InterfaceC5766Kt e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(float f, InterfaceC5766Kt interfaceC5766Kt, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = f;
            this.e = interfaceC5766Kt;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return e.this.new a(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C15607js c15607js = e.this.c;
                Float fC = AbstractC6392Nk0.c(this.d);
                InterfaceC5766Kt interfaceC5766Kt = this.e;
                this.b = 1;
                if (C15607js.h(c15607js, fC, interfaceC5766Kt, null, null, this, 12, null) == objE) {
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
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC5766Kt d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC5766Kt interfaceC5766Kt, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC5766Kt;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return e.this.new b(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C15607js c15607js = e.this.c;
                Float fC = AbstractC6392Nk0.c(0.0f);
                InterfaceC5766Kt interfaceC5766Kt = this.d;
                this.b = 1;
                if (C15607js.h(c15607js, fC, interfaceC5766Kt, null, null, this, 12, null) == objE) {
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

    public e(boolean z, SA2 sa2) {
        this.a = z;
        this.b = sa2;
    }

    public final void b(InterfaceC17460n02 interfaceC17460n02, float f, long j) throws Throwable {
        long j2;
        float fFloatValue = ((Number) this.c.q()).floatValue();
        if (fFloatValue <= 0.0f) {
            return;
        }
        long jO = C24381yX0.o(j, fFloatValue, 0.0f, 0.0f, 0.0f, 14, null);
        if (!this.a) {
            InterfaceC17460n02.L(interfaceC17460n02, jO, f, 0L, 0.0f, null, null, 0, 124, null);
            return;
        }
        float fI = OD6.i(interfaceC17460n02.d());
        float fG = OD6.g(interfaceC17460n02.d());
        int iB = GV0.a.b();
        YZ1 yz1Z1 = interfaceC17460n02.z1();
        long jD = yz1Z1.d();
        yz1Z1.e().n();
        try {
            yz1Z1.b().b(0.0f, 0.0f, fI, fG, iB);
            j2 = jD;
            try {
                InterfaceC17460n02.L(interfaceC17460n02, jO, f, 0L, 0.0f, null, null, 0, 124, null);
                yz1Z1.e().i();
                yz1Z1.g(j2);
            } catch (Throwable th) {
                th = th;
                yz1Z1.e().i();
                yz1Z1.g(j2);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            j2 = jD;
        }
    }

    public final void c(InterfaceC22645vb3 interfaceC22645vb3, InterfaceC20315ro1 interfaceC20315ro1) {
        boolean z = interfaceC22645vb3 instanceof C12403eZ2;
        if (z) {
            this.d.add(interfaceC22645vb3);
        } else if (interfaceC22645vb3 instanceof C13012fZ2) {
            this.d.remove(((C13012fZ2) interfaceC22645vb3).a());
        } else if (interfaceC22645vb3 instanceof C23400wr2) {
            this.d.add(interfaceC22645vb3);
        } else if (interfaceC22645vb3 instanceof C23990xr2) {
            this.d.remove(((C23990xr2) interfaceC22645vb3).a());
        } else if (interfaceC22645vb3 instanceof GZ1) {
            this.d.add(interfaceC22645vb3);
        } else if (interfaceC22645vb3 instanceof HZ1) {
            this.d.remove(((HZ1) interfaceC22645vb3).a());
        } else if (!(interfaceC22645vb3 instanceof FZ1)) {
            return;
        } else {
            this.d.remove(((FZ1) interfaceC22645vb3).a());
        }
        InterfaceC22645vb3 interfaceC22645vb32 = (InterfaceC22645vb3) AbstractC15401jX0.F0(this.d);
        if (AbstractC13042fc3.d(this.e, interfaceC22645vb32)) {
            return;
        }
        if (interfaceC22645vb32 != null) {
            C17484n26 c17484n26 = (C17484n26) this.b.invoke();
            AbstractC10533bm0.d(interfaceC20315ro1, null, null, new a(z ? c17484n26.c() : interfaceC22645vb3 instanceof C23400wr2 ? c17484n26.b() : interfaceC22645vb3 instanceof GZ1 ? c17484n26.a() : 0.0f, AbstractC22920w26.d(interfaceC22645vb32), null), 3, null);
        } else {
            AbstractC10533bm0.d(interfaceC20315ro1, null, null, new b(AbstractC22920w26.e(this.e), null), 3, null);
        }
        this.e = interfaceC22645vb32;
    }
}
