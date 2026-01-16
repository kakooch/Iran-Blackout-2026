package ir.nasim;

import ir.nasim.core.modules.file.entity.FileReference;

/* renamed from: ir.nasim.p16, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C18656p16 {
    private final C14970in2 a;

    public C18656p16(C14970in2 c14970in2) {
        AbstractC13042fc3.i(c14970in2, "filesModule");
        this.a = c14970in2;
    }

    public final Object b(FileReference fileReference, InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC10533bm0.b(interfaceC20315ro1, null, null, new a(fileReference, interfaceC20315ro1, null), 3, null).y(interfaceC20295rm1);
    }

    /* renamed from: ir.nasim.p16$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        int e;
        final /* synthetic */ FileReference g;
        final /* synthetic */ InterfaceC20315ro1 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(FileReference fileReference, InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.g = fileReference;
            this.h = interfaceC20315ro1;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C18656p16.this.new a(this.g, this.h, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.e;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C18656p16 c18656p16 = C18656p16.this;
                FileReference fileReference = this.g;
                InterfaceC20315ro1 interfaceC20315ro1 = this.h;
                this.b = c18656p16;
                this.c = fileReference;
                this.d = interfaceC20315ro1;
                this.e = 1;
                IE0 ie0 = new IE0(AbstractC14251hc3.c(this), 1);
                ie0.w();
                C14970in2.K(c18656p16.a, fileReference, new C1431a(ie0, interfaceC20315ro1), false, false, 12, null);
                obj = ie0.t();
                if (obj == AbstractC14862ic3.e()) {
                    WA1.c(this);
                }
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return obj;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }

        /* renamed from: ir.nasim.p16$a$a, reason: collision with other inner class name */
        public static final class C1431a implements InterfaceC8807Xk2 {
            final /* synthetic */ HE0 a;
            final /* synthetic */ InterfaceC20315ro1 b;

            /* renamed from: ir.nasim.p16$a$a$a, reason: collision with other inner class name */
            static final class C1432a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                Object b;
                int c;
                final /* synthetic */ HE0 d;
                final /* synthetic */ InterfaceC3346Am2 e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1432a(HE0 he0, InterfaceC3346Am2 interfaceC3346Am2, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = he0;
                    this.e = interfaceC3346Am2;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new C1432a(this.d, this.e, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    HE0 he0;
                    Object objE = AbstractC14862ic3.e();
                    int i = this.c;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        HE0 he02 = this.d;
                        String descriptor = this.e.getDescriptor();
                        this.b = he02;
                        this.c = 1;
                        Object objB = QI2.b(descriptor, this);
                        if (objB == objE) {
                            return objE;
                        }
                        he0 = he02;
                        obj = objB;
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        he0 = (HE0) this.b;
                        AbstractC10685c16.b(obj);
                    }
                    AbstractC24549yo1.c(he0, obj);
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C1432a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            C1431a(HE0 he0, InterfaceC20315ro1 interfaceC20315ro1) {
                this.a = he0;
                this.b = interfaceC20315ro1;
            }

            @Override // ir.nasim.InterfaceC8807Xk2
            public void d(InterfaceC3346Am2 interfaceC3346Am2) {
                AbstractC13042fc3.i(interfaceC3346Am2, "reference");
                AbstractC10533bm0.d(this.b, null, null, new C1432a(this.a, interfaceC3346Am2, null), 3, null);
            }

            @Override // ir.nasim.InterfaceC8807Xk2
            public void g(DX1 dx1) {
                AbstractC24549yo1.c(this.a, null);
            }

            @Override // ir.nasim.InterfaceC8807Xk2
            public void c(float f) {
            }
        }
    }
}
