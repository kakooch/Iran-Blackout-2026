package ir.nasim;

/* renamed from: ir.nasim.kJ3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC15869kJ3 {

    /* renamed from: ir.nasim.kJ3$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ InterfaceC9049Yg5 d;
        final /* synthetic */ InterfaceC4766Gl7 e;

        /* renamed from: ir.nasim.kJ3$a$a, reason: collision with other inner class name */
        static final class C1351a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ InterfaceC9049Yg5 c;
            final /* synthetic */ InterfaceC4766Gl7 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1351a(InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC4766Gl7 interfaceC4766Gl7, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = interfaceC9049Yg5;
                this.d = interfaceC4766Gl7;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C1351a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC9049Yg5 interfaceC9049Yg5 = this.c;
                    InterfaceC4766Gl7 interfaceC4766Gl7 = this.d;
                    this.b = 1;
                    if (AbstractC15869kJ3.e(interfaceC9049Yg5, interfaceC4766Gl7, this) == objE) {
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
                return ((C1351a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.kJ3$a$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ InterfaceC9049Yg5 c;
            final /* synthetic */ InterfaceC4766Gl7 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC4766Gl7 interfaceC4766Gl7, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = interfaceC9049Yg5;
                this.d = interfaceC4766Gl7;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new b(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC9049Yg5 interfaceC9049Yg5 = this.c;
                    InterfaceC4766Gl7 interfaceC4766Gl7 = this.d;
                    this.b = 1;
                    if (AbstractC15869kJ3.d(interfaceC9049Yg5, interfaceC4766Gl7, this) == objE) {
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC4766Gl7 interfaceC4766Gl7, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC9049Yg5;
            this.e = interfaceC4766Gl7;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = new a(this.d, this.e, interfaceC20295rm1);
            aVar.c = obj;
            return aVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
            EnumC23959xo1 enumC23959xo1 = EnumC23959xo1.UNDISPATCHED;
            AbstractC10533bm0.d(interfaceC20315ro1, null, enumC23959xo1, new C1351a(this.d, this.e, null), 1, null);
            return AbstractC10533bm0.d(interfaceC20315ro1, null, enumC23959xo1, new b(this.d, this.e, null), 1, null);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.kJ3$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ InterfaceC4766Gl7 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC4766Gl7 interfaceC4766Gl7) {
            super(1);
            this.e = interfaceC4766Gl7;
        }

        public final void a(long j) {
            this.e.b(j);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((ZG4) obj).t());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.kJ3$c */
    static final class c extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC4766Gl7 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(InterfaceC4766Gl7 interfaceC4766Gl7) {
            super(0);
            this.e = interfaceC4766Gl7;
        }

        public final void a() {
            this.e.i();
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.kJ3$d */
    static final class d extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC4766Gl7 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(InterfaceC4766Gl7 interfaceC4766Gl7) {
            super(0);
            this.e = interfaceC4766Gl7;
        }

        public final void a() {
            this.e.onCancel();
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.kJ3$e */
    static final class e extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC4766Gl7 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(InterfaceC4766Gl7 interfaceC4766Gl7) {
            super(2);
            this.e = interfaceC4766Gl7;
        }

        public final void a(C6616Og5 c6616Og5, long j) {
            this.e.d(j);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((C6616Og5) obj, ((ZG4) obj2).t());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.kJ3$f */
    static final class f extends V06 implements InterfaceC14603iB2 {
        Object a;
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ InterfaceC4766Gl7 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(InterfaceC4766Gl7 interfaceC4766Gl7, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC4766Gl7;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            f fVar = new f(this.d, interfaceC20295rm1);
            fVar.c = obj;
            return fVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x005d A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:19:0x006e  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x005b -> B:17:0x005e). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                r12 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r12.b
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L2a
                if (r1 == r3) goto L22
                if (r1 != r2) goto L1a
                java.lang.Object r1 = r12.a
                ir.nasim.Og5 r1 = (ir.nasim.C6616Og5) r1
                java.lang.Object r4 = r12.c
                ir.nasim.EV r4 = (ir.nasim.EV) r4
                ir.nasim.AbstractC10685c16.b(r13)
                goto L5e
            L1a:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L22:
                java.lang.Object r1 = r12.c
                ir.nasim.EV r1 = (ir.nasim.EV) r1
                ir.nasim.AbstractC10685c16.b(r13)
                goto L43
            L2a:
                ir.nasim.AbstractC10685c16.b(r13)
                java.lang.Object r13 = r12.c
                r1 = r13
                ir.nasim.EV r1 = (ir.nasim.EV) r1
                r12.c = r1
                r12.b = r3
                r5 = 0
                r6 = 0
                r8 = 2
                r9 = 0
                r4 = r1
                r7 = r12
                java.lang.Object r13 = ir.nasim.AbstractC20271rj7.f(r4, r5, r6, r7, r8, r9)
                if (r13 != r0) goto L43
                return r0
            L43:
                ir.nasim.Og5 r13 = (ir.nasim.C6616Og5) r13
                ir.nasim.Gl7 r4 = r12.d
                long r5 = r13.h()
                r4.a(r5)
                r4 = r1
                r1 = r13
            L50:
                r12.c = r4
                r12.a = r1
                r12.b = r2
                r13 = 0
                java.lang.Object r13 = ir.nasim.EV.D0(r4, r13, r12, r3, r13)
                if (r13 != r0) goto L5e
                return r0
            L5e:
                ir.nasim.Bg5 r13 = (ir.nasim.C3534Bg5) r13
                java.util.List r13 = r13.c()
                r5 = r13
                java.util.Collection r5 = (java.util.Collection) r5
                int r5 = r5.size()
                r6 = 0
            L6c:
                if (r6 >= r5) goto L8c
                java.lang.Object r7 = r13.get(r6)
                ir.nasim.Og5 r7 = (ir.nasim.C6616Og5) r7
                long r8 = r7.f()
                long r10 = r1.f()
                boolean r8 = ir.nasim.AbstractC6122Mg5.b(r8, r10)
                if (r8 == 0) goto L89
                boolean r7 = r7.i()
                if (r7 == 0) goto L89
                goto L50
            L89:
                int r6 = r6 + 1
                goto L6c
            L8c:
                ir.nasim.Gl7 r13 = r12.d
                r13.c()
                ir.nasim.rB7 r13 = ir.nasim.C19938rB7.a
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC15869kJ3.f.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(EV ev, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(ev, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final Object c(InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC4766Gl7 interfaceC4766Gl7, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objE = AbstractC20906so1.e(new a(interfaceC9049Yg5, interfaceC4766Gl7, null), interfaceC20295rm1);
        return objE == AbstractC14862ic3.e() ? objE : C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object d(InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC4766Gl7 interfaceC4766Gl7, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objD = EZ1.d(interfaceC9049Yg5, new b(interfaceC4766Gl7), new c(interfaceC4766Gl7), new d(interfaceC4766Gl7), new e(interfaceC4766Gl7), interfaceC20295rm1);
        return objD == AbstractC14862ic3.e() ? objD : C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object e(InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC4766Gl7 interfaceC4766Gl7, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objD = AbstractC8163Uu2.d(interfaceC9049Yg5, new f(interfaceC4766Gl7, null), interfaceC20295rm1);
        return objD == AbstractC14862ic3.e() ? objD : C19938rB7.a;
    }
}
