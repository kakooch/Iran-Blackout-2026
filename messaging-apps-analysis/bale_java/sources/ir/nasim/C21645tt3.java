package ir.nasim;

/* renamed from: ir.nasim.tt3, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C21645tt3 extends VW7 {
    private final InterfaceC9336Zm4 b;

    /* renamed from: ir.nasim.tt3$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21645tt3.this.new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            Object value2;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm4 = C21645tt3.this.b;
                do {
                    value = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value, C19758qt3.c((C19758qt3) value, null, false, true, 3, null)));
                this.b = 1;
                if (HG1.b(1000L, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            InterfaceC9336Zm4 interfaceC9336Zm42 = C21645tt3.this.b;
            do {
                value2 = interfaceC9336Zm42.getValue();
            } while (!interfaceC9336Zm42.f(value2, C19758qt3.c((C19758qt3) value2, null, false, false, 3, null)));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C21645tt3() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(C19758qt3.d.a());
        this.b = interfaceC9336Zm4A;
        do {
            value = interfaceC9336Zm4A.getValue();
        } while (!interfaceC9336Zm4A.f(value, C19758qt3.c((C19758qt3) value, AbstractC19167pt3.a(PH3.d()), false, false, 6, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 W0(C21645tt3 c21645tt3, EnumC18576ot3 enumC18576ot3) {
        Object value;
        AbstractC13042fc3.i(c21645tt3, "this$0");
        AbstractC13042fc3.i(enumC18576ot3, "$languageState");
        InterfaceC9336Zm4 interfaceC9336Zm4 = c21645tt3.b;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, C19758qt3.c((C19758qt3) value, enumC18576ot3, true, false, 4, null)));
        return C19938rB7.a;
    }

    private final void X0(final SA2 sa2) {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.d(), null, new a(null), 2, null).s(new UA2() { // from class: ir.nasim.st3
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C21645tt3.Y0(sa2, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Y0(SA2 sa2, Throwable th) {
        AbstractC13042fc3.i(sa2, "$invokeOnCompletion");
        sa2.invoke();
        return C19938rB7.a;
    }

    public final InterfaceC10258bL6 T0() {
        return this.b;
    }

    public final void U0() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.b;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, C19758qt3.c((C19758qt3) value, null, false, false, 5, null)));
    }

    public final void V0(final EnumC18576ot3 enumC18576ot3) {
        AbstractC13042fc3.i(enumC18576ot3, "languageState");
        if (enumC18576ot3 != ((C19758qt3) this.b.getValue()).d()) {
            PH3.i(C5721Ko.a.d(), enumC18576ot3.j());
            FH3.w().P(enumC18576ot3.j());
            X0(new SA2() { // from class: ir.nasim.rt3
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C21645tt3.W0(this.a, enumC18576ot3);
                }
            });
        }
    }
}
