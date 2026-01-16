package ir.nasim;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: ir.nasim.Zq2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract /* synthetic */ class AbstractC9370Zq2 {

    /* renamed from: ir.nasim.Zq2$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC16863lz6 c;
        final /* synthetic */ InterfaceC4557Fq2 d;
        final /* synthetic */ InterfaceC8327Vm4 e;
        final /* synthetic */ Object f;

        /* renamed from: ir.nasim.Zq2$a$a, reason: collision with other inner class name */
        static final class C0816a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ int c;

            C0816a(InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                C0816a c0816a = new C0816a(interfaceC20295rm1);
                c0816a.c = ((Number) obj).intValue();
                return c0816a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return n(((Number) obj).intValue(), (InterfaceC20295rm1) obj2);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                return AbstractC6392Nk0.a(this.c > 0);
            }

            public final Object n(int i, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C0816a) create(Integer.valueOf(i), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.Zq2$a$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ InterfaceC4557Fq2 d;
            final /* synthetic */ InterfaceC8327Vm4 e;
            final /* synthetic */ Object f;

            /* renamed from: ir.nasim.Zq2$a$b$a, reason: collision with other inner class name */
            public /* synthetic */ class C0817a {
                public static final /* synthetic */ int[] a;

                static {
                    int[] iArr = new int[EnumC15090iz6.values().length];
                    try {
                        iArr[EnumC15090iz6.START.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[EnumC15090iz6.STOP.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[EnumC15090iz6.STOP_AND_RESET_REPLAY_CACHE.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    a = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC8327Vm4 interfaceC8327Vm4, Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = interfaceC4557Fq2;
                this.e = interfaceC8327Vm4;
                this.f = obj;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                b bVar = new b(this.d, this.e, this.f, interfaceC20295rm1);
                bVar.c = obj;
                return bVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    int i2 = C0817a.a[((EnumC15090iz6) this.c).ordinal()];
                    if (i2 == 1) {
                        InterfaceC4557Fq2 interfaceC4557Fq2 = this.d;
                        InterfaceC8327Vm4 interfaceC8327Vm4 = this.e;
                        this.b = 1;
                        if (interfaceC4557Fq2.b(interfaceC8327Vm4, this) == objE) {
                            return objE;
                        }
                    } else if (i2 == 3) {
                        Object obj2 = this.f;
                        if (obj2 == AbstractC11420cy6.a) {
                            this.e.k();
                        } else {
                            this.e.c(obj2);
                        }
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
            public final Object invoke(EnumC15090iz6 enumC15090iz6, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(enumC15090iz6, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC16863lz6 interfaceC16863lz6, InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC8327Vm4 interfaceC8327Vm4, Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC16863lz6;
            this.d = interfaceC4557Fq2;
            this.e = interfaceC8327Vm4;
            this.f = obj;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, this.d, this.e, this.f, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x006a A[RETURN] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r7.b
                r2 = 4
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L25
                if (r1 == r5) goto L21
                if (r1 == r4) goto L1d
                if (r1 == r3) goto L21
                if (r1 != r2) goto L15
                goto L21
            L15:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L1d:
                ir.nasim.AbstractC10685c16.b(r8)
                goto L5e
            L21:
                ir.nasim.AbstractC10685c16.b(r8)
                goto L8f
            L25:
                ir.nasim.AbstractC10685c16.b(r8)
                ir.nasim.lz6 r8 = r7.c
                ir.nasim.lz6$a r1 = ir.nasim.InterfaceC16863lz6.a
                ir.nasim.lz6 r6 = r1.c()
                if (r8 != r6) goto L3f
                ir.nasim.Fq2 r8 = r7.d
                ir.nasim.Vm4 r1 = r7.e
                r7.b = r5
                java.lang.Object r8 = r8.b(r1, r7)
                if (r8 != r0) goto L8f
                return r0
            L3f:
                ir.nasim.lz6 r8 = r7.c
                ir.nasim.lz6 r1 = r1.d()
                r5 = 0
                if (r8 != r1) goto L6b
                ir.nasim.Vm4 r8 = r7.e
                ir.nasim.bL6 r8 = r8.d()
                ir.nasim.Fq2 r8 = (ir.nasim.InterfaceC4557Fq2) r8
                ir.nasim.Zq2$a$a r1 = new ir.nasim.Zq2$a$a
                r1.<init>(r5)
                r7.b = r4
                java.lang.Object r8 = ir.nasim.AbstractC6459Nq2.H(r8, r1, r7)
                if (r8 != r0) goto L5e
                return r0
            L5e:
                ir.nasim.Fq2 r8 = r7.d
                ir.nasim.Vm4 r1 = r7.e
                r7.b = r3
                java.lang.Object r8 = r8.b(r1, r7)
                if (r8 != r0) goto L8f
                return r0
            L6b:
                ir.nasim.lz6 r8 = r7.c
                ir.nasim.Vm4 r1 = r7.e
                ir.nasim.bL6 r1 = r1.d()
                ir.nasim.Fq2 r8 = r8.a(r1)
                ir.nasim.Fq2 r8 = ir.nasim.AbstractC6459Nq2.v(r8)
                ir.nasim.Zq2$a$b r1 = new ir.nasim.Zq2$a$b
                ir.nasim.Fq2 r3 = r7.d
                ir.nasim.Vm4 r4 = r7.e
                java.lang.Object r6 = r7.f
                r1.<init>(r3, r4, r6, r5)
                r7.b = r2
                java.lang.Object r8 = ir.nasim.AbstractC6459Nq2.l(r8, r1, r7)
                if (r8 != r0) goto L8f
                return r0
            L8f:
                ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC9370Zq2.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Zq2$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ InterfaceC4557Fq2 d;
        final /* synthetic */ InterfaceC22299v01 e;

        /* renamed from: ir.nasim.Zq2$b$a */
        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ C12889fL5 a;
            final /* synthetic */ InterfaceC20315ro1 b;
            final /* synthetic */ InterfaceC22299v01 c;

            a(C12889fL5 c12889fL5, InterfaceC20315ro1 interfaceC20315ro1, InterfaceC22299v01 interfaceC22299v01) {
                this.a = c12889fL5;
                this.b = interfaceC20315ro1;
                this.c = interfaceC22299v01;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            public final Object a(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                C19938rB7 c19938rB7;
                InterfaceC9336Zm4 interfaceC9336Zm4 = (InterfaceC9336Zm4) this.a.a;
                if (interfaceC9336Zm4 != null) {
                    interfaceC9336Zm4.setValue(obj);
                    c19938rB7 = C19938rB7.a;
                } else {
                    c19938rB7 = null;
                }
                if (c19938rB7 == null) {
                    InterfaceC20315ro1 interfaceC20315ro1 = this.b;
                    C12889fL5 c12889fL5 = this.a;
                    InterfaceC22299v01 interfaceC22299v01 = this.c;
                    InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(obj);
                    interfaceC22299v01.U(new DI5(interfaceC9336Zm4A, AbstractC19067pj3.p(interfaceC20315ro1.getCoroutineContext())));
                    c12889fL5.a = interfaceC9336Zm4A;
                }
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC22299v01 interfaceC22299v01, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC4557Fq2;
            this.e = interfaceC22299v01;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = new b(this.d, this.e, interfaceC20295rm1);
            bVar.c = obj;
            return bVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            try {
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                    C12889fL5 c12889fL5 = new C12889fL5();
                    InterfaceC4557Fq2 interfaceC4557Fq2 = this.d;
                    a aVar = new a(c12889fL5, interfaceC20315ro1, this.e);
                    this.b = 1;
                    if (interfaceC4557Fq2.b(aVar, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                return C19938rB7.a;
            } catch (Throwable th) {
                this.e.e(th);
                throw th;
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final InterfaceC10040ay6 a(InterfaceC8327Vm4 interfaceC8327Vm4) {
        return new CI5(interfaceC8327Vm4, null);
    }

    public static final InterfaceC10258bL6 b(InterfaceC9336Zm4 interfaceC9336Zm4) {
        return new DI5(interfaceC9336Zm4, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final ir.nasim.C15681jz6 c(ir.nasim.InterfaceC4557Fq2 r7, int r8) {
        /*
            ir.nasim.nJ0$a r0 = ir.nasim.InterfaceC17639nJ0.c0
            int r0 = r0.a()
            int r0 = ir.nasim.AbstractC21867uG5.e(r8, r0)
            int r0 = r0 - r8
            boolean r1 = r7 instanceof ir.nasim.AbstractC20003rJ0
            if (r1 == 0) goto L3c
            r1 = r7
            ir.nasim.rJ0 r1 = (ir.nasim.AbstractC20003rJ0) r1
            ir.nasim.Fq2 r2 = r1.m()
            if (r2 == 0) goto L3c
            ir.nasim.jz6 r7 = new ir.nasim.jz6
            int r3 = r1.b
            r4 = -3
            if (r3 == r4) goto L26
            r4 = -2
            if (r3 == r4) goto L26
            if (r3 == 0) goto L26
            r0 = r3
            goto L34
        L26:
            ir.nasim.Ml0 r4 = r1.c
            ir.nasim.Ml0 r5 = ir.nasim.EnumC6162Ml0.SUSPEND
            r6 = 0
            if (r4 != r5) goto L31
            if (r3 != 0) goto L34
        L2f:
            r0 = r6
            goto L34
        L31:
            if (r8 != 0) goto L2f
            r0 = 1
        L34:
            ir.nasim.Ml0 r8 = r1.c
            ir.nasim.do1 r1 = r1.a
            r7.<init>(r2, r0, r8, r1)
            return r7
        L3c:
            ir.nasim.jz6 r8 = new ir.nasim.jz6
            ir.nasim.Ml0 r1 = ir.nasim.EnumC6162Ml0.SUSPEND
            ir.nasim.p72 r2 = ir.nasim.C18712p72.a
            r8.<init>(r7, r0, r1, r2)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC9370Zq2.c(ir.nasim.Fq2, int):ir.nasim.jz6");
    }

    private static final InterfaceC13730gj3 d(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC11938do1 interfaceC11938do1, InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC8327Vm4 interfaceC8327Vm4, InterfaceC16863lz6 interfaceC16863lz6, Object obj) {
        return AbstractC9323Zl0.c(interfaceC20315ro1, interfaceC11938do1, AbstractC13042fc3.d(interfaceC16863lz6, InterfaceC16863lz6.a.c()) ? EnumC23959xo1.DEFAULT : EnumC23959xo1.UNDISPATCHED, new a(interfaceC16863lz6, interfaceC4557Fq2, interfaceC8327Vm4, obj, null));
    }

    private static final void e(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC11938do1 interfaceC11938do1, InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC22299v01 interfaceC22299v01) {
        AbstractC10533bm0.d(interfaceC20315ro1, interfaceC11938do1, null, new b(interfaceC4557Fq2, interfaceC22299v01, null), 2, null);
    }

    public static final InterfaceC10040ay6 f(InterfaceC10040ay6 interfaceC10040ay6, InterfaceC14603iB2 interfaceC14603iB2) {
        return new C16874m07(interfaceC10040ay6, interfaceC14603iB2);
    }

    public static final InterfaceC10040ay6 g(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC20315ro1 interfaceC20315ro1, InterfaceC16863lz6 interfaceC16863lz6, int i) {
        C15681jz6 c15681jz6C = c(interfaceC4557Fq2, i);
        InterfaceC8327Vm4 interfaceC8327Vm4A = AbstractC11420cy6.a(i, c15681jz6C.b, c15681jz6C.c);
        return new CI5(interfaceC8327Vm4A, d(interfaceC20315ro1, c15681jz6C.d, c15681jz6C.a, interfaceC8327Vm4A, interfaceC16863lz6, AbstractC11420cy6.a));
    }

    public static /* synthetic */ InterfaceC10040ay6 h(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC20315ro1 interfaceC20315ro1, InterfaceC16863lz6 interfaceC16863lz6, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return AbstractC6459Nq2.m0(interfaceC4557Fq2, interfaceC20315ro1, interfaceC16863lz6, i);
    }

    public static final InterfaceC10258bL6 i(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC20315ro1 interfaceC20315ro1, InterfaceC16863lz6 interfaceC16863lz6, Object obj) {
        C15681jz6 c15681jz6C = c(interfaceC4557Fq2, 1);
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(obj);
        return new DI5(interfaceC9336Zm4A, d(interfaceC20315ro1, c15681jz6C.d, c15681jz6C.a, interfaceC9336Zm4A, interfaceC16863lz6, obj));
    }

    public static final Object j(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
        C15681jz6 c15681jz6C = c(interfaceC4557Fq2, 1);
        InterfaceC22299v01 interfaceC22299v01C = AbstractC23485x01.c(null, 1, null);
        e(interfaceC20315ro1, c15681jz6C.d, c15681jz6C.a, interfaceC22299v01C);
        return interfaceC22299v01C.y(interfaceC20295rm1);
    }
}
