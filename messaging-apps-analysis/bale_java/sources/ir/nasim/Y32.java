package ir.nasim;

import ir.nasim.AbstractC22169um7;
import ir.nasim.Y32;

/* loaded from: classes7.dex */
public final class Y32 extends VW7 {
    private final DG2 b;
    private final C9057Yh4 c;
    private String d;
    private final InterfaceC9336Zm4 e;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return Y32.this.new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objA;
            C21231tK7 c21231tK7;
            Object value;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                DG2 dg2 = Y32.this.b;
                this.b = 1;
                objA = dg2.a(this);
                if (objA == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objA = ((C9475a16) obj).l();
            }
            Y32 y32 = Y32.this;
            if (C9475a16.j(objA) && (c21231tK7 = (C21231tK7) objA) != null) {
                y32.d = (String) c21231tK7.r().b();
                InterfaceC9336Zm4 interfaceC9336Zm4 = y32.e;
                do {
                    value = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value, C32.c((C32) value, y32.d, false, false, null, false, null, 62, null)));
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
        final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void D(Y32 y32, C14505i18 c14505i18) {
            Object value;
            InterfaceC9336Zm4 interfaceC9336Zm4 = y32.e;
            do {
                value = interfaceC9336Zm4.getValue();
            } while (!interfaceC9336Zm4.f(value, C32.c((C32) value, null, false, false, null, true, null, 47, null)));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void G(Y32 y32, Exception exc) {
            Object value;
            InterfaceC9336Zm4 interfaceC9336Zm4 = y32.e;
            do {
                value = interfaceC9336Zm4.getValue();
            } while (!interfaceC9336Zm4.f(value, C32.c((C32) value, null, false, false, YF6.a, false, null, 55, null)));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void H(Y32 y32, C14505i18 c14505i18, Exception exc) {
            Object value;
            InterfaceC9336Zm4 interfaceC9336Zm4 = y32.e;
            do {
                value = interfaceC9336Zm4.getValue();
            } while (!interfaceC9336Zm4.f(value, C32.c((C32) value, null, false, false, null, false, null, 59, null)));
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return Y32.this.new b(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            InterfaceC9336Zm4 interfaceC9336Zm4 = Y32.this.e;
            do {
                value = interfaceC9336Zm4.getValue();
            } while (!interfaceC9336Zm4.f(value, C32.c((C32) value, null, false, true, null, false, null, 57, null)));
            C6517Nv5 c6517Nv5D = Y32.this.c.H().D(this.d);
            final Y32 y32 = Y32.this;
            C6517Nv5 c6517Nv5M0 = c6517Nv5D.m0(new InterfaceC24449ye1() { // from class: ir.nasim.Z32
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj2) {
                    Y32.b.D(y32, (C14505i18) obj2);
                }
            });
            final Y32 y322 = Y32.this;
            C6517Nv5 c6517Nv5E = c6517Nv5M0.E(new InterfaceC24449ye1() { // from class: ir.nasim.a42
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj2) {
                    Y32.b.G(y322, (Exception) obj2);
                }
            });
            final Y32 y323 = Y32.this;
            c6517Nv5E.z(new InterfaceC3273Ae1() { // from class: ir.nasim.b42
                @Override // ir.nasim.InterfaceC3273Ae1
                public final void apply(Object obj2, Object obj3) {
                    Y32.b.H(y323, (C14505i18) obj2, (Exception) obj3);
                }
            });
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: z, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public Y32(DG2 dg2, C9057Yh4 c9057Yh4) {
        AbstractC13042fc3.i(dg2, "getUserVmUseCase");
        AbstractC13042fc3.i(c9057Yh4, "modules");
        this.b = dg2;
        this.c = c9057Yh4;
        this.d = "";
        this.e = AbstractC12281eL6.a(C32.g.a());
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new a(null), 3, null);
    }

    public final void V0(String str) {
        Object value;
        AbstractC13042fc3.i(str, "newName");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.e;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, C32.c((C32) value, str, str.length() > 0 && !AbstractC13042fc3.d(this.d, str), false, null, false, str.length() > B32.b.j() ? new AbstractC22169um7.b(EnumC9920am7.a) : AbstractC22169um7.a.a, 28, null)));
    }

    public final InterfaceC10258bL6 W0() {
        return this.e;
    }

    public final void X0() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.e;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, C32.c((C32) value, null, false, false, null, false, null, 55, null)));
    }

    public final void Y0(String str) {
        AbstractC13042fc3.i(str, "newName");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new b(str, null), 2, null);
    }
}
