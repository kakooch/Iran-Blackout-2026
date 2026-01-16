package ir.nasim;

import ir.nasim.AbstractC5416Jg0;
import ir.nasim.C6117Mg0;
import java.util.List;

/* renamed from: ir.nasim.Mg0, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C6117Mg0 extends VW7 {
    private final KM2 b;
    private final OK7 c;
    private final InterfaceC9173Yu3 d;
    private final InterfaceC9173Yu3 e;
    private final InterfaceC9336Zm4 f;
    private final InterfaceC10258bL6 g;

    /* renamed from: ir.nasim.Mg0$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        Object e;
        Object f;
        Object g;
        Object h;
        Object i;
        Object j;
        int k;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6117Mg0.this.new a(interfaceC20295rm1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Path cross not found for [B:58:0x021e, B:60:0x024c], limit reached: 91 */
        /* JADX WARN: Removed duplicated region for block: B:38:0x015d  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x01bd A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:45:0x01be  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x01cf  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x020c A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:52:0x020d  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x0218  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x024f  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x0258  */
        /* JADX WARN: Removed duplicated region for block: B:70:0x0270  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x028e  */
        /* JADX WARN: Type inference failed for: r9v15, types: [java.util.Collection] */
        /* JADX WARN: Type inference failed for: r9v17, types: [java.util.Collection] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x020d -> B:9:0x0043). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r25) {
            /*
                Method dump skipped, instructions count: 679
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6117Mg0.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Mg0$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int d;
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(int i, SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = i;
            this.e = sa2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean y(int i, C6850Pg0 c6850Pg0) {
            return c6850Pg0.d() == i;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6117Mg0.this.new b(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objF;
            Object value;
            Object objA;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                KM2 km2 = C6117Mg0.this.b;
                int i2 = this.d;
                int iX0 = C6117Mg0.this.X0();
                this.b = 1;
                objF = km2.f(i2, iX0, this);
                if (objF == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objF = ((C9475a16) obj).l();
            }
            C6117Mg0 c6117Mg0 = C6117Mg0.this;
            SA2 sa2 = this.e;
            final int i3 = this.d;
            if (C9475a16.j(objF)) {
                InterfaceC9336Zm4 interfaceC9336Zm4 = c6117Mg0.f;
                do {
                    value = interfaceC9336Zm4.getValue();
                    objA = (AbstractC5416Jg0) value;
                    if (objA instanceof AbstractC5416Jg0.d) {
                        AbstractC5416Jg0.d dVar = (AbstractC5416Jg0.d) objA;
                        List listP1 = AbstractC15401jX0.p1(dVar.b());
                        AbstractC13610gX0.K(listP1, new UA2() { // from class: ir.nasim.Ng0
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj2) {
                                return Boolean.valueOf(C6117Mg0.b.y(i3, (C6850Pg0) obj2));
                            }
                        });
                        objA = dVar.a(listP1);
                    }
                } while (!interfaceC9336Zm4.f(value, objA));
                sa2.invoke();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C6117Mg0(KM2 km2, OK7 ok7, final androidx.lifecycle.y yVar) {
        AbstractC13042fc3.i(km2, "groupRepository");
        AbstractC13042fc3.i(ok7, "usersModule");
        AbstractC13042fc3.i(yVar, "savedStateHandle");
        this.b = km2;
        this.c = ok7;
        this.d = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Kg0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Integer.valueOf(C6117Mg0.Z0(yVar));
            }
        });
        this.e = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Lg0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C6117Mg0.a1(yVar);
            }
        });
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(AbstractC5416Jg0.b.a);
        this.f = interfaceC9336Zm4A;
        this.g = AbstractC6459Nq2.c(interfaceC9336Zm4A);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int X0() {
        return ((Number) this.d.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int Z0(androidx.lifecycle.y yVar) {
        AbstractC13042fc3.i(yVar, "$savedStateHandle");
        Integer num = (Integer) yVar.c("GROUP_ID_ARGS");
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ZN2 a1(androidx.lifecycle.y yVar) {
        AbstractC13042fc3.i(yVar, "$savedStateHandle");
        ZN2 zn2 = (ZN2) yVar.c("groupTypeKey");
        return zn2 == null ? ZN2.GROUP : zn2;
    }

    public final InterfaceC10258bL6 W0() {
        return this.g;
    }

    public final ZN2 Y0() {
        return (ZN2) this.e.getValue();
    }

    public final InterfaceC13730gj3 b1() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new a(null), 3, null);
    }

    public final InterfaceC13730gj3 c1(int i, SA2 sa2) {
        AbstractC13042fc3.i(sa2, "onSuccess");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new b(i, sa2, null), 3, null);
    }
}
