package ir.nasim;

/* loaded from: classes.dex */
final class JD1 implements OZ1 {
    private final UA2 a;
    private final IZ1 b = new b();
    private final C17335mn4 c = new C17335mn4();

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ EnumC15562jn4 d;
        final /* synthetic */ InterfaceC14603iB2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(EnumC15562jn4 enumC15562jn4, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = enumC15562jn4;
            this.e = interfaceC14603iB2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return JD1.this.new a(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C17335mn4 c17335mn4 = JD1.this.c;
                IZ1 iz1 = JD1.this.b;
                EnumC15562jn4 enumC15562jn4 = this.d;
                InterfaceC14603iB2 interfaceC14603iB2 = this.e;
                this.b = 1;
                if (c17335mn4.f(iz1, enumC15562jn4, interfaceC14603iB2, this) == objE) {
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

    public static final class b implements IZ1 {
        b() {
        }

        @Override // ir.nasim.IZ1
        public void a(float f) {
            JD1.this.d().invoke(Float.valueOf(f));
        }
    }

    public JD1(UA2 ua2) {
        this.a = ua2;
    }

    @Override // ir.nasim.OZ1
    public Object a(EnumC15562jn4 enumC15562jn4, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objE = AbstractC20906so1.e(new a(enumC15562jn4, interfaceC14603iB2, null), interfaceC20295rm1);
        return objE == AbstractC14862ic3.e() ? objE : C19938rB7.a;
    }

    public final UA2 d() {
        return this.a;
    }
}
