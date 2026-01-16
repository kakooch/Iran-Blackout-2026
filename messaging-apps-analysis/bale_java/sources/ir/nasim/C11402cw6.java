package ir.nasim;

import ir.nasim.AbstractC23562x78;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.core.runtime.logger.EmptyException;

/* renamed from: ir.nasim.cw6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C11402cw6 extends VW7 {
    public static final b h = new b(null);
    public static final int i = 8;
    private final InterfaceC3570Bk5 b;
    private final SettingsModule c;
    private final AbstractC13778go1 d;
    private final YA6 e;
    private InterfaceC13730gj3 f;
    private final InterfaceC9336Zm4 g;

    /* renamed from: ir.nasim.cw6$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        Object e;
        Object f;
        Object g;
        Object h;
        Object i;
        boolean j;
        int k;
        final /* synthetic */ NJ1 m;

        /* renamed from: ir.nasim.cw6$a$a, reason: collision with other inner class name */
        static final class C1000a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;

            C1000a(InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C1000a(interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                return PH3.d();
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C1000a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(NJ1 nj1, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.m = nj1;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C11402cw6.this.new a(this.m, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x00cd A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x00ce  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00f5 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:24:0x00f6  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0127  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00f6 -> B:8:0x0041). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r28) {
            /*
                Method dump skipped, instructions count: 298
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C11402cw6.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.cw6$b */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.cw6$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C11402cw6.this.new c(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objO;
            Object value;
            C10639bw6 c10639bw6;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C11402cw6.this.w1();
                C6164Ml2 c6164Ml2 = C6164Ml2.a;
                this.b = 1;
                objO = c6164Ml2.o(this);
                if (objO == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objO = obj;
            }
            if (((Boolean) objO).booleanValue()) {
                InterfaceC9336Zm4 interfaceC9336Zm4 = C11402cw6.this.g;
                do {
                    value = interfaceC9336Zm4.getValue();
                    c10639bw6 = (C10639bw6) value;
                } while (!interfaceC9336Zm4.f(value, c10639bw6.b((224 & 1) != 0 ? c10639bw6.a : null, (224 & 2) != 0 ? c10639bw6.b : null, (224 & 4) != 0 ? c10639bw6.c : false, (224 & 8) != 0 ? c10639bw6.d : false, (224 & 16) != 0 ? c10639bw6.e : null, (224 & 32) != 0 ? c10639bw6.f : false, (224 & 64) != 0 ? c10639bw6.g : null, (224 & 128) != 0 ? c10639bw6.h : new H07(null, 1, null), (224 & 256) != 0 ? c10639bw6.i : false)));
                C11402cw6.this.v1(CI3.a);
            } else {
                C11402cw6.this.v1(CI3.b);
            }
            C11402cw6.this.x1();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.cw6$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ NJ1 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(NJ1 nj1, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = nj1;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C11402cw6.this.new d(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            boolean z = true;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                if (!AbstractC21784u76.c()) {
                    C11402cw6 c11402cw6 = C11402cw6.this;
                    this.b = 1;
                    obj = c11402cw6.l1(this);
                    if (obj == objE) {
                        return objE;
                    }
                }
                return AbstractC6392Nk0.a(z);
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            if (!((Boolean) obj).booleanValue() || !this.d.a()) {
                z = false;
            }
            return AbstractC6392Nk0.a(z);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.cw6$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C11402cw6.this.new e(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            C10639bw6 c10639bw6;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C11402cw6 c11402cw6 = C11402cw6.this;
                this.b = 1;
                if (c11402cw6.q1(false, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            C6164Ml2.p();
            InterfaceC9336Zm4 interfaceC9336Zm4 = C11402cw6.this.g;
            do {
                value = interfaceC9336Zm4.getValue();
                c10639bw6 = (C10639bw6) value;
            } while (!interfaceC9336Zm4.f(value, c10639bw6.b((224 & 1) != 0 ? c10639bw6.a : null, (224 & 2) != 0 ? c10639bw6.b : null, (224 & 4) != 0 ? c10639bw6.c : false, (224 & 8) != 0 ? c10639bw6.d : false, (224 & 16) != 0 ? c10639bw6.e : null, (224 & 32) != 0 ? c10639bw6.f : false, (224 & 64) != 0 ? c10639bw6.g : null, (224 & 128) != 0 ? c10639bw6.h : null, (224 & 256) != 0 ? c10639bw6.i : false)));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.cw6$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C11402cw6.this.new f(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            C10639bw6 c10639bw6;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C11402cw6 c11402cw6 = C11402cw6.this;
                this.b = 1;
                if (c11402cw6.q1(true, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            C6164Ml2.a.w();
            InterfaceC9336Zm4 interfaceC9336Zm4 = C11402cw6.this.g;
            do {
                value = interfaceC9336Zm4.getValue();
                c10639bw6 = (C10639bw6) value;
            } while (!interfaceC9336Zm4.f(value, c10639bw6.b((224 & 1) != 0 ? c10639bw6.a : null, (224 & 2) != 0 ? c10639bw6.b : null, (224 & 4) != 0 ? c10639bw6.c : true, (224 & 8) != 0 ? c10639bw6.d : false, (224 & 16) != 0 ? c10639bw6.e : null, (224 & 32) != 0 ? c10639bw6.f : false, (224 & 64) != 0 ? c10639bw6.g : null, (224 & 128) != 0 ? c10639bw6.h : null, (224 & 256) != 0 ? c10639bw6.i : false)));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.cw6$g */
    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C11402cw6.this.new g(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            C11402cw6 c11402cw6;
            Object objL;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C11402cw6.this.w1();
                C11402cw6 c11402cw62 = C11402cw6.this;
                C6164Ml2 c6164Ml2 = C6164Ml2.a;
                this.b = c11402cw62;
                this.c = 1;
                Object objT = c6164Ml2.t(this);
                if (objT == objE) {
                    return objE;
                }
                c11402cw6 = c11402cw62;
                objL = objT;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                c11402cw6 = (C11402cw6) this.b;
                AbstractC10685c16.b(obj);
                objL = ((C9475a16) obj).l();
            }
            c11402cw6.z1(objL);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.cw6$h */
    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C11402cw6.this.new h(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            C11402cw6 c11402cw6;
            Object objL;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C11402cw6.this.w1();
                C11402cw6 c11402cw62 = C11402cw6.this;
                C6164Ml2 c6164Ml2 = C6164Ml2.a;
                this.b = c11402cw62;
                this.c = 1;
                Object objS = c6164Ml2.s(this);
                if (objS == objE) {
                    return objE;
                }
                c11402cw6 = c11402cw62;
                objL = objS;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                c11402cw6 = (C11402cw6) this.b;
                AbstractC10685c16.b(obj);
                objL = ((C9475a16) obj).l();
            }
            c11402cw6.z1(objL);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.cw6$i */
    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        i(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C11402cw6.this.new i(interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0020  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r3) {
            /*
                r2 = this;
                ir.nasim.AbstractC13660gc3.e()
                int r0 = r2.b
                if (r0 != 0) goto L26
                ir.nasim.AbstractC10685c16.b(r3)
                boolean r3 = ir.nasim.C8386Vt0.fa()
                if (r3 != 0) goto L20
                ir.nasim.cw6 r3 = ir.nasim.C11402cw6.this
                ir.nasim.Bk5 r3 = ir.nasim.C11402cw6.T0(r3)
                java.lang.String r0 = "ENABLED_SEND_LOG"
                r1 = 1
                boolean r3 = r3.h(r0, r1)
                if (r3 == 0) goto L20
                goto L21
            L20:
                r1 = 0
            L21:
                java.lang.Boolean r3 = ir.nasim.AbstractC6392Nk0.a(r1)
                return r3
            L26:
                java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r3.<init>(r0)
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C11402cw6.i.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.cw6$j */
    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        j(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C11402cw6.this.new j(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            C10639bw6 c10639bw6;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            InterfaceC13730gj3 interfaceC13730gj3 = C11402cw6.this.f;
            if (interfaceC13730gj3 != null) {
                InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
            }
            InterfaceC9336Zm4 interfaceC9336Zm4 = C11402cw6.this.g;
            do {
                value = interfaceC9336Zm4.getValue();
                c10639bw6 = (C10639bw6) value;
            } while (!interfaceC9336Zm4.f(value, c10639bw6.b((224 & 1) != 0 ? c10639bw6.a : null, (224 & 2) != 0 ? c10639bw6.b : null, (224 & 4) != 0 ? c10639bw6.c : false, (224 & 8) != 0 ? c10639bw6.d : false, (224 & 16) != 0 ? c10639bw6.e : null, (224 & 32) != 0 ? c10639bw6.f : false, (224 & 64) != 0 ? c10639bw6.g : null, (224 & 128) != 0 ? c10639bw6.h : C10639bw6.j.a().e(), (224 & 256) != 0 ? c10639bw6.i : false)));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.cw6$k */
    static final class k extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        k(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C11402cw6.this.new k(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            C10639bw6 c10639bw6;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            InterfaceC9336Zm4 interfaceC9336Zm4 = C11402cw6.this.g;
            do {
                value = interfaceC9336Zm4.getValue();
                c10639bw6 = (C10639bw6) value;
            } while (!interfaceC9336Zm4.f(value, c10639bw6.b((224 & 1) != 0 ? c10639bw6.a : null, (224 & 2) != 0 ? c10639bw6.b : null, (224 & 4) != 0 ? c10639bw6.c : false, (224 & 8) != 0 ? c10639bw6.d : false, (224 & 16) != 0 ? c10639bw6.e : null, (224 & 32) != 0 ? c10639bw6.f : false, (224 & 64) != 0 ? c10639bw6.g : C10639bw6.j.a().h(), (224 & 128) != 0 ? c10639bw6.h : null, (224 & 256) != 0 ? c10639bw6.i : false)));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((k) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.cw6$l */
    static final class l extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ boolean d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = z;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C11402cw6.this.new l(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C11402cw6.this.b.g("ENABLED_SEND_LOG", this.d);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((l) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.cw6$m */
    static final class m extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ boolean d;

        /* renamed from: ir.nasim.cw6$m$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C11402cw6 c;
            final /* synthetic */ boolean d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C11402cw6 c11402cw6, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c11402cw6;
                this.d = z;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.c.b.g("PREF_KEY_WEB_VIEW_DEBUG_OPTION", this.d);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = z;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C11402cw6.this.new m(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                AbstractC13778go1 abstractC13778go1 = C11402cw6.this.d;
                a aVar = new a(C11402cw6.this, this.d, null);
                this.b = 1;
                if (AbstractC9323Zl0.g(abstractC13778go1, aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            C11402cw6.this.v1(this.d ? CI3.e : CI3.d);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((m) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.cw6$n */
    static final class n extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.cw6$n$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;

            a(InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                return PH3.d();
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        n(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C11402cw6.this.new n(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            C10639bw6 c10639bw6;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                AbstractC13778go1 abstractC13778go1 = C11402cw6.this.d;
                a aVar = new a(null);
                this.b = 1;
                obj = AbstractC9323Zl0.g(abstractC13778go1, aVar, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            String str = (String) obj;
            InterfaceC9336Zm4 interfaceC9336Zm4 = C11402cw6.this.g;
            do {
                value = interfaceC9336Zm4.getValue();
                c10639bw6 = (C10639bw6) value;
            } while (!interfaceC9336Zm4.f(value, c10639bw6.b((224 & 1) != 0 ? c10639bw6.a : str, (224 & 2) != 0 ? c10639bw6.b : null, (224 & 4) != 0 ? c10639bw6.c : false, (224 & 8) != 0 ? c10639bw6.d : false, (224 & 16) != 0 ? c10639bw6.e : null, (224 & 32) != 0 ? c10639bw6.f : false, (224 & 64) != 0 ? c10639bw6.g : null, (224 & 128) != 0 ? c10639bw6.h : null, (224 & 256) != 0 ? c10639bw6.i : false)));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((n) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C11402cw6(NJ1 nj1, InterfaceC3570Bk5 interfaceC3570Bk5, SettingsModule settingsModule, AbstractC13778go1 abstractC13778go1, YA6 ya6) {
        AbstractC13042fc3.i(nj1, "developerModeEnableUseCase");
        AbstractC13042fc3.i(interfaceC3570Bk5, "preferences");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(ya6, "shouldShowFoldersBadgeUseCase");
        this.b = interfaceC3570Bk5;
        this.c = settingsModule;
        this.d = abstractC13778go1;
        this.e = ya6;
        this.g = AbstractC12281eL6.a(C10639bw6.j.a());
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new a(nj1, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AbstractC23562x78 A1() {
        return C8386Vt0.Ga() ? new AbstractC23562x78.b(this.b.h("PREF_KEY_WEB_VIEW_DEBUG_OPTION", false)) : AbstractC23562x78.a.a;
    }

    private final boolean d1() {
        InterfaceC13730gj3 interfaceC13730gj3 = this.f;
        if (interfaceC13730gj3 == null) {
            return false;
        }
        AbstractC13042fc3.f(interfaceC13730gj3);
        if (!interfaceC13730gj3.b()) {
            return false;
        }
        v1(CI3.b);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object f1(NJ1 nj1, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.d, new d(nj1, null), interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object l1(InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.d, new i(null), interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object q1(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objG = AbstractC9323Zl0.g(this.d, new l(z, null), interfaceC20295rm1);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }

    private final void s1(Object obj) {
        Object value;
        C10639bw6 c10639bw6;
        if (C9475a16.g(obj)) {
            obj = null;
        }
        String str = (String) obj;
        if (str == null || str.length() == 0) {
            v1(CI3.b);
            return;
        }
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.g;
        do {
            value = interfaceC9336Zm4.getValue();
            c10639bw6 = (C10639bw6) value;
        } while (!interfaceC9336Zm4.f(value, c10639bw6.b((224 & 1) != 0 ? c10639bw6.a : null, (224 & 2) != 0 ? c10639bw6.b : null, (224 & 4) != 0 ? c10639bw6.c : false, (224 & 8) != 0 ? c10639bw6.d : false, (224 & 16) != 0 ? c10639bw6.e : null, (224 & 32) != 0 ? c10639bw6.f : false, (224 & 64) != 0 ? c10639bw6.g : null, (224 & 128) != 0 ? c10639bw6.h : new H07(str), (224 & 256) != 0 ? c10639bw6.i : false)));
    }

    private final void t1(Object obj) {
        if (C9475a16.e(obj) instanceof EmptyException) {
            v1(CI3.c);
        } else {
            v1(CI3.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v1(CI3 ci3) {
        Object value;
        C10639bw6 c10639bw6;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.g;
        do {
            value = interfaceC9336Zm4.getValue();
            c10639bw6 = (C10639bw6) value;
        } while (!interfaceC9336Zm4.f(value, c10639bw6.b((224 & 1) != 0 ? c10639bw6.a : null, (224 & 2) != 0 ? c10639bw6.b : null, (224 & 4) != 0 ? c10639bw6.c : false, (224 & 8) != 0 ? c10639bw6.d : false, (224 & 16) != 0 ? c10639bw6.e : null, (224 & 32) != 0 ? c10639bw6.f : false, (224 & 64) != 0 ? c10639bw6.g : new C9619aG6(ci3), (224 & 128) != 0 ? c10639bw6.h : null, (224 & 256) != 0 ? c10639bw6.i : false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w1() {
        Object value;
        C10639bw6 c10639bw6;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.g;
        do {
            value = interfaceC9336Zm4.getValue();
            c10639bw6 = (C10639bw6) value;
        } while (!interfaceC9336Zm4.f(value, c10639bw6.b((224 & 1) != 0 ? c10639bw6.a : null, (224 & 2) != 0 ? c10639bw6.b : null, (224 & 4) != 0 ? c10639bw6.c : false, (224 & 8) != 0 ? c10639bw6.d : false, (224 & 16) != 0 ? c10639bw6.e : null, (224 & 32) != 0 ? c10639bw6.f : true, (224 & 64) != 0 ? c10639bw6.g : null, (224 & 128) != 0 ? c10639bw6.h : null, (224 & 256) != 0 ? c10639bw6.i : false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x1() {
        Object value;
        C10639bw6 c10639bw6;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.g;
        do {
            value = interfaceC9336Zm4.getValue();
            c10639bw6 = (C10639bw6) value;
        } while (!interfaceC9336Zm4.f(value, c10639bw6.b((224 & 1) != 0 ? c10639bw6.a : null, (224 & 2) != 0 ? c10639bw6.b : null, (224 & 4) != 0 ? c10639bw6.c : false, (224 & 8) != 0 ? c10639bw6.d : false, (224 & 16) != 0 ? c10639bw6.e : null, (224 & 32) != 0 ? c10639bw6.f : false, (224 & 64) != 0 ? c10639bw6.g : null, (224 & 128) != 0 ? c10639bw6.h : null, (224 & 256) != 0 ? c10639bw6.i : false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z1(Object obj) {
        if (C9475a16.j(obj)) {
            s1(obj);
        } else {
            t1(obj);
        }
        x1();
    }

    public final void e1() {
        if (d1()) {
            return;
        }
        this.f = AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new c(null), 3, null);
    }

    public final void g1() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new e(null), 3, null);
    }

    public final void h1() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new f(null), 3, null);
    }

    public final void i1() {
        if (d1()) {
            return;
        }
        this.f = AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new g(null), 3, null);
    }

    public final void j1() {
        if (d1()) {
            return;
        }
        this.f = AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new h(null), 3, null);
    }

    public final InterfaceC10258bL6 k1() {
        return this.g;
    }

    public final void m1() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new j(null), 3, null);
    }

    public final void o1() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new k(null), 3, null);
    }

    public final void p1() {
        Object value;
        C10639bw6 c10639bw6;
        if (((C10639bw6) this.g.getValue()).f()) {
            this.c.A7(false);
            if (C8386Vt0.a.Pb()) {
                this.c.F7(false);
            }
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.g;
            do {
                value = interfaceC9336Zm4.getValue();
                c10639bw6 = (C10639bw6) value;
            } while (!interfaceC9336Zm4.f(value, c10639bw6.b((224 & 1) != 0 ? c10639bw6.a : null, (224 & 2) != 0 ? c10639bw6.b : null, (224 & 4) != 0 ? c10639bw6.c : false, (224 & 8) != 0 ? c10639bw6.d : false, (224 & 16) != 0 ? c10639bw6.e : null, (224 & 32) != 0 ? c10639bw6.f : false, (224 & 64) != 0 ? c10639bw6.g : null, (224 & 128) != 0 ? c10639bw6.h : null, (224 & 256) != 0 ? c10639bw6.i : false)));
        }
    }

    public final void u1(boolean z) {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new m(z, null), 3, null);
    }

    public final void y1() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new n(null), 3, null);
    }
}
