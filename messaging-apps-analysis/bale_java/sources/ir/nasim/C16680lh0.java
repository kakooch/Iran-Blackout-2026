package ir.nasim;

import ir.nasim.InterfaceC13730gj3;

/* renamed from: ir.nasim.lh0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C16680lh0 {
    private final C17342mo1 a;
    private final InterfaceC14603iB2 b;
    private final long c;
    private final InterfaceC20315ro1 d;
    private final SA2 e;
    private InterfaceC13730gj3 f;
    private InterfaceC13730gj3 g;

    /* renamed from: ir.nasim.lh0$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C16680lh0.this.new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                long j = C16680lh0.this.c;
                this.b = 1;
                if (HG1.b(j, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            if (!C16680lh0.this.a.h()) {
                InterfaceC13730gj3 interfaceC13730gj3 = C16680lh0.this.f;
                if (interfaceC13730gj3 != null) {
                    InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
                }
                C16680lh0.this.f = null;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.lh0$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = C16680lh0.this.new b(interfaceC20295rm1);
            bVar.c = obj;
            return bVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                RC3 rc3 = new RC3(C16680lh0.this.a, ((InterfaceC20315ro1) this.c).getCoroutineContext());
                InterfaceC14603iB2 interfaceC14603iB2 = C16680lh0.this.b;
                this.b = 1;
                if (interfaceC14603iB2.invoke(rc3, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            C16680lh0.this.e.invoke();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C16680lh0(C17342mo1 c17342mo1, InterfaceC14603iB2 interfaceC14603iB2, long j, InterfaceC20315ro1 interfaceC20315ro1, SA2 sa2) {
        AbstractC13042fc3.i(c17342mo1, "liveData");
        AbstractC13042fc3.i(interfaceC14603iB2, "block");
        AbstractC13042fc3.i(interfaceC20315ro1, "scope");
        AbstractC13042fc3.i(sa2, "onDone");
        this.a = c17342mo1;
        this.b = interfaceC14603iB2;
        this.c = j;
        this.d = interfaceC20315ro1;
        this.e = sa2;
    }

    public final void g() {
        if (this.g != null) {
            throw new IllegalStateException("Cancel call cannot happen without a maybeRun".toString());
        }
        this.g = AbstractC10533bm0.d(this.d, C12366eV1.c().F0(), null, new a(null), 2, null);
    }

    public final void h() {
        InterfaceC13730gj3 interfaceC13730gj3 = this.g;
        if (interfaceC13730gj3 != null) {
            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
        }
        this.g = null;
        if (this.f != null) {
            return;
        }
        this.f = AbstractC10533bm0.d(this.d, null, null, new b(null), 3, null);
    }
}
