package ir.nasim;

/* loaded from: classes.dex */
final class VE1 implements InterfaceC11049ce6 {
    private final UA2 a;
    private final InterfaceC8748Xd6 b = new b();
    private final C17335mn4 c = new C17335mn4();
    private final InterfaceC9102Ym4 d;
    private final InterfaceC9102Ym4 e;
    private final InterfaceC9102Ym4 f;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ EnumC15562jn4 d;
        final /* synthetic */ InterfaceC14603iB2 e;

        /* renamed from: ir.nasim.VE1$a$a, reason: collision with other inner class name */
        static final class C0696a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            private /* synthetic */ Object c;
            final /* synthetic */ VE1 d;
            final /* synthetic */ InterfaceC14603iB2 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0696a(VE1 ve1, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = ve1;
                this.e = interfaceC14603iB2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                C0696a c0696a = new C0696a(this.d, this.e, interfaceC20295rm1);
                c0696a.c = obj;
                return c0696a;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                try {
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        InterfaceC8748Xd6 interfaceC8748Xd6 = (InterfaceC8748Xd6) this.c;
                        this.d.d.setValue(AbstractC6392Nk0.a(true));
                        InterfaceC14603iB2 interfaceC14603iB2 = this.e;
                        this.b = 1;
                        if (interfaceC14603iB2.invoke(interfaceC8748Xd6, this) == objE) {
                            return objE;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                    }
                    this.d.d.setValue(AbstractC6392Nk0.a(false));
                    return C19938rB7.a;
                } catch (Throwable th) {
                    this.d.d.setValue(AbstractC6392Nk0.a(false));
                    throw th;
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC8748Xd6 interfaceC8748Xd6, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C0696a) create(interfaceC8748Xd6, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(EnumC15562jn4 enumC15562jn4, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = enumC15562jn4;
            this.e = interfaceC14603iB2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return VE1.this.new a(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C17335mn4 c17335mn4 = VE1.this.c;
                InterfaceC8748Xd6 interfaceC8748Xd6 = VE1.this.b;
                EnumC15562jn4 enumC15562jn4 = this.d;
                C0696a c0696a = new C0696a(VE1.this, this.e, null);
                this.b = 1;
                if (c17335mn4.f(interfaceC8748Xd6, enumC15562jn4, c0696a, this) == objE) {
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

    public static final class b implements InterfaceC8748Xd6 {
        b() {
        }

        @Override // ir.nasim.InterfaceC8748Xd6
        public float e(float f) {
            if (Float.isNaN(f)) {
                return 0.0f;
            }
            float fFloatValue = ((Number) VE1.this.l().invoke(Float.valueOf(f))).floatValue();
            VE1.this.e.setValue(Boolean.valueOf(fFloatValue > 0.0f));
            VE1.this.f.setValue(Boolean.valueOf(fFloatValue < 0.0f));
            return fFloatValue;
        }
    }

    public VE1(UA2 ua2) {
        this.a = ua2;
        Boolean bool = Boolean.FALSE;
        this.d = AbstractC13472gH6.d(bool, null, 2, null);
        this.e = AbstractC13472gH6.d(bool, null, 2, null);
        this.f = AbstractC13472gH6.d(bool, null, 2, null);
    }

    @Override // ir.nasim.InterfaceC11049ce6
    public Object b(EnumC15562jn4 enumC15562jn4, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objE = AbstractC20906so1.e(new a(enumC15562jn4, interfaceC14603iB2, null), interfaceC20295rm1);
        return objE == AbstractC14862ic3.e() ? objE : C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC11049ce6
    public boolean c() {
        return ((Boolean) this.d.getValue()).booleanValue();
    }

    @Override // ir.nasim.InterfaceC11049ce6
    public float f(float f) {
        return ((Number) this.a.invoke(Float.valueOf(f))).floatValue();
    }

    public final UA2 l() {
        return this.a;
    }
}
