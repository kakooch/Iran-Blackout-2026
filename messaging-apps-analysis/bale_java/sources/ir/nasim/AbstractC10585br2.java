package ir.nasim;

/* renamed from: ir.nasim.br2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
abstract /* synthetic */ class AbstractC10585br2 {

    /* renamed from: ir.nasim.br2$a */
    public static final class a implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2[] a;
        final /* synthetic */ InterfaceC16978mB2 b;

        /* renamed from: ir.nasim.br2$a$a, reason: collision with other inner class name */
        public static final class C0921a extends AbstractC19859r37 implements InterfaceC15796kB2 {
            int b;
            private /* synthetic */ Object c;
            /* synthetic */ Object d;
            final /* synthetic */ InterfaceC16978mB2 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0921a(InterfaceC20295rm1 interfaceC20295rm1, InterfaceC16978mB2 interfaceC16978mB2) {
                super(3, interfaceC20295rm1);
                this.e = interfaceC16978mB2;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                InterfaceC4806Gq2 interfaceC4806Gq2;
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                    Object[] objArr = (Object[]) this.d;
                    InterfaceC16978mB2 interfaceC16978mB2 = this.e;
                    Object obj2 = objArr[0];
                    Object obj3 = objArr[1];
                    Object obj4 = objArr[2];
                    this.c = interfaceC4806Gq2;
                    this.b = 1;
                    Y73.c(6);
                    obj = interfaceC16978mB2.e(obj2, obj3, obj4, this);
                    Y73.c(7);
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                        return C19938rB7.a;
                    }
                    interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                    AbstractC10685c16.b(obj);
                }
                this.c = null;
                this.b = 2;
                if (interfaceC4806Gq2.a(obj, this) == objE) {
                    return objE;
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC15796kB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Object[] objArr, InterfaceC20295rm1 interfaceC20295rm1) {
                C0921a c0921a = new C0921a(interfaceC20295rm1, this.e);
                c0921a.c = interfaceC4806Gq2;
                c0921a.d = objArr;
                return c0921a.invokeSuspend(C19938rB7.a);
            }
        }

        public a(InterfaceC4557Fq2[] interfaceC4557Fq2Arr, InterfaceC16978mB2 interfaceC16978mB2) {
            this.a = interfaceC4557Fq2Arr;
            this.b = interfaceC16978mB2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objA = AbstractC10404bZ0.a(interfaceC4806Gq2, this.a, AbstractC10585br2.g(), new C0921a(null, this.b), interfaceC20295rm1);
            return objA == AbstractC14862ic3.e() ? objA : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.br2$b */
    public static final class b implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2[] a;
        final /* synthetic */ InterfaceC18160oB2 b;

        /* renamed from: ir.nasim.br2$b$a */
        public static final class a extends AbstractC19859r37 implements InterfaceC15796kB2 {
            int b;
            private /* synthetic */ Object c;
            /* synthetic */ Object d;
            final /* synthetic */ InterfaceC18160oB2 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(InterfaceC20295rm1 interfaceC20295rm1, InterfaceC18160oB2 interfaceC18160oB2) {
                super(3, interfaceC20295rm1);
                this.e = interfaceC18160oB2;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                InterfaceC4806Gq2 interfaceC4806Gq2;
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                    Object[] objArr = (Object[]) this.d;
                    InterfaceC18160oB2 interfaceC18160oB2 = this.e;
                    Object obj2 = objArr[0];
                    Object obj3 = objArr[1];
                    Object obj4 = objArr[2];
                    Object obj5 = objArr[3];
                    this.c = interfaceC4806Gq2;
                    this.b = 1;
                    Y73.c(6);
                    obj = interfaceC18160oB2.s(obj2, obj3, obj4, obj5, this);
                    Y73.c(7);
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                        return C19938rB7.a;
                    }
                    interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                    AbstractC10685c16.b(obj);
                }
                this.c = null;
                this.b = 2;
                if (interfaceC4806Gq2.a(obj, this) == objE) {
                    return objE;
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC15796kB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Object[] objArr, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(interfaceC20295rm1, this.e);
                aVar.c = interfaceC4806Gq2;
                aVar.d = objArr;
                return aVar.invokeSuspend(C19938rB7.a);
            }
        }

        public b(InterfaceC4557Fq2[] interfaceC4557Fq2Arr, InterfaceC18160oB2 interfaceC18160oB2) {
            this.a = interfaceC4557Fq2Arr;
            this.b = interfaceC18160oB2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objA = AbstractC10404bZ0.a(interfaceC4806Gq2, this.a, AbstractC10585br2.g(), new a(null, this.b), interfaceC20295rm1);
            return objA == AbstractC14862ic3.e() ? objA : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.br2$c */
    public static final class c implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2[] a;
        final /* synthetic */ InterfaceC19342qB2 b;

        /* renamed from: ir.nasim.br2$c$a */
        public static final class a extends AbstractC19859r37 implements InterfaceC15796kB2 {
            int b;
            private /* synthetic */ Object c;
            /* synthetic */ Object d;
            final /* synthetic */ InterfaceC19342qB2 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(InterfaceC20295rm1 interfaceC20295rm1, InterfaceC19342qB2 interfaceC19342qB2) {
                super(3, interfaceC20295rm1);
                this.e = interfaceC19342qB2;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                InterfaceC4806Gq2 interfaceC4806Gq2;
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                    Object[] objArr = (Object[]) this.d;
                    InterfaceC19342qB2 interfaceC19342qB2 = this.e;
                    Object obj2 = objArr[0];
                    Object obj3 = objArr[1];
                    Object obj4 = objArr[2];
                    Object obj5 = objArr[3];
                    Object obj6 = objArr[4];
                    this.c = interfaceC4806Gq2;
                    this.b = 1;
                    Y73.c(6);
                    obj = interfaceC19342qB2.j(obj2, obj3, obj4, obj5, obj6, this);
                    Y73.c(7);
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                        return C19938rB7.a;
                    }
                    interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                    AbstractC10685c16.b(obj);
                }
                this.c = null;
                this.b = 2;
                if (interfaceC4806Gq2.a(obj, this) == objE) {
                    return objE;
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC15796kB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Object[] objArr, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(interfaceC20295rm1, this.e);
                aVar.c = interfaceC4806Gq2;
                aVar.d = objArr;
                return aVar.invokeSuspend(C19938rB7.a);
            }
        }

        public c(InterfaceC4557Fq2[] interfaceC4557Fq2Arr, InterfaceC19342qB2 interfaceC19342qB2) {
            this.a = interfaceC4557Fq2Arr;
            this.b = interfaceC19342qB2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objA = AbstractC10404bZ0.a(interfaceC4806Gq2, this.a, AbstractC10585br2.g(), new a(null, this.b), interfaceC20295rm1);
            return objA == AbstractC14862ic3.e() ? objA : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.br2$d */
    public static final class d implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ InterfaceC4557Fq2 b;
        final /* synthetic */ InterfaceC15796kB2 c;

        public d(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC4557Fq2 interfaceC4557Fq22, InterfaceC15796kB2 interfaceC15796kB2) {
            this.a = interfaceC4557Fq2;
            this.b = interfaceC4557Fq22;
            this.c = interfaceC15796kB2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objA = AbstractC10404bZ0.a(interfaceC4806Gq2, new InterfaceC4557Fq2[]{this.a, this.b}, AbstractC10585br2.g(), new e(this.c, null), interfaceC20295rm1);
            return objA == AbstractC14862ic3.e() ? objA : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.br2$e */
    static final class e extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        private /* synthetic */ Object c;
        /* synthetic */ Object d;
        final /* synthetic */ InterfaceC15796kB2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(InterfaceC15796kB2 interfaceC15796kB2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
            this.e = interfaceC15796kB2;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC4806Gq2 interfaceC4806Gq2;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                Object[] objArr = (Object[]) this.d;
                InterfaceC15796kB2 interfaceC15796kB2 = this.e;
                Object obj2 = objArr[0];
                Object obj3 = objArr[1];
                this.c = interfaceC4806Gq2;
                this.b = 1;
                obj = interfaceC15796kB2.q(obj2, obj3, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return C19938rB7.a;
                }
                interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                AbstractC10685c16.b(obj);
            }
            this.c = null;
            this.b = 2;
            if (interfaceC4806Gq2.a(obj, this) == objE) {
                return objE;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Object[] objArr, InterfaceC20295rm1 interfaceC20295rm1) {
            e eVar = new e(this.e, interfaceC20295rm1);
            eVar.c = interfaceC4806Gq2;
            eVar.d = objArr;
            return eVar.invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.br2$f */
    static final class f extends AbstractC8614Ws3 implements SA2 {
        public static final f e = new f();

        f() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke() {
            return null;
        }
    }

    public static final InterfaceC4557Fq2 b(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC4557Fq2 interfaceC4557Fq22, InterfaceC4557Fq2 interfaceC4557Fq23, InterfaceC4557Fq2 interfaceC4557Fq24, InterfaceC4557Fq2 interfaceC4557Fq25, InterfaceC19342qB2 interfaceC19342qB2) {
        return new c(new InterfaceC4557Fq2[]{interfaceC4557Fq2, interfaceC4557Fq22, interfaceC4557Fq23, interfaceC4557Fq24, interfaceC4557Fq25}, interfaceC19342qB2);
    }

    public static final InterfaceC4557Fq2 c(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC4557Fq2 interfaceC4557Fq22, InterfaceC4557Fq2 interfaceC4557Fq23, InterfaceC4557Fq2 interfaceC4557Fq24, InterfaceC18160oB2 interfaceC18160oB2) {
        return new b(new InterfaceC4557Fq2[]{interfaceC4557Fq2, interfaceC4557Fq22, interfaceC4557Fq23, interfaceC4557Fq24}, interfaceC18160oB2);
    }

    public static final InterfaceC4557Fq2 d(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC4557Fq2 interfaceC4557Fq22, InterfaceC4557Fq2 interfaceC4557Fq23, InterfaceC16978mB2 interfaceC16978mB2) {
        return new a(new InterfaceC4557Fq2[]{interfaceC4557Fq2, interfaceC4557Fq22, interfaceC4557Fq23}, interfaceC16978mB2);
    }

    public static final InterfaceC4557Fq2 e(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC4557Fq2 interfaceC4557Fq22, InterfaceC15796kB2 interfaceC15796kB2) {
        return AbstractC6459Nq2.S(interfaceC4557Fq2, interfaceC4557Fq22, interfaceC15796kB2);
    }

    public static final InterfaceC4557Fq2 f(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC4557Fq2 interfaceC4557Fq22, InterfaceC15796kB2 interfaceC15796kB2) {
        return new d(interfaceC4557Fq2, interfaceC4557Fq22, interfaceC15796kB2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SA2 g() {
        return f.e;
    }
}
