package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.GJ0;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.flow.internal.ChildCancelledException;

/* renamed from: ir.nasim.Sq2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
abstract /* synthetic */ class AbstractC7654Sq2 {

    /* renamed from: ir.nasim.Sq2$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ long e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(long j) {
            super(1);
            this.e = j;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Long invoke(Object obj) {
            return Long.valueOf(this.e);
        }
    }

    /* renamed from: ir.nasim.Sq2$b */
    static final class b extends AbstractC19859r37 implements InterfaceC15796kB2 {
        Object b;
        Object c;
        int d;
        private /* synthetic */ Object e;
        /* synthetic */ Object f;
        final /* synthetic */ UA2 g;
        final /* synthetic */ InterfaceC4557Fq2 h;

        /* renamed from: ir.nasim.Sq2$b$a */
        static final class a extends AbstractC19859r37 implements UA2 {
            int b;
            final /* synthetic */ InterfaceC4806Gq2 c;
            final /* synthetic */ C12889fL5 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC4806Gq2 interfaceC4806Gq2, C12889fL5 c12889fL5, InterfaceC20295rm1 interfaceC20295rm1) {
                super(1, interfaceC20295rm1);
                this.c = interfaceC4806Gq2;
                this.d = c12889fL5;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4806Gq2 interfaceC4806Gq2 = this.c;
                    C14539i47 c14539i47 = AbstractC12225eF4.a;
                    Object obj2 = this.d.a;
                    if (obj2 == c14539i47) {
                        obj2 = null;
                    }
                    this.b = 1;
                    if (interfaceC4806Gq2.a(obj2, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                this.d.a = null;
                return C19938rB7.a;
            }

            @Override // ir.nasim.UA2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.Sq2$b$b, reason: collision with other inner class name */
        static final class C0630b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            Object b;
            int c;
            /* synthetic */ Object d;
            final /* synthetic */ C12889fL5 e;
            final /* synthetic */ InterfaceC4806Gq2 f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0630b(C12889fL5 c12889fL5, InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.e = c12889fL5;
                this.f = interfaceC4806Gq2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                C0630b c0630b = new C0630b(this.e, this.f, interfaceC20295rm1);
                c0630b.d = obj;
                return c0630b;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return n(((GJ0) obj).k(), (InterfaceC20295rm1) obj2);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) throws Throwable {
                C12889fL5 c12889fL5;
                C12889fL5 c12889fL52;
                Object objE = AbstractC14862ic3.e();
                int i = this.c;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    Object objK = ((GJ0) this.d).k();
                    c12889fL5 = this.e;
                    boolean z = objK instanceof GJ0.c;
                    if (!z) {
                        c12889fL5.a = objK;
                    }
                    InterfaceC4806Gq2 interfaceC4806Gq2 = this.f;
                    if (z) {
                        Throwable thE = GJ0.e(objK);
                        if (thE != null) {
                            throw thE;
                        }
                        Object obj2 = c12889fL5.a;
                        if (obj2 != null) {
                            if (obj2 == AbstractC12225eF4.a) {
                                obj2 = null;
                            }
                            this.d = objK;
                            this.b = c12889fL5;
                            this.c = 1;
                            if (interfaceC4806Gq2.a(obj2, this) == objE) {
                                return objE;
                            }
                            c12889fL52 = c12889fL5;
                        }
                        c12889fL5.a = AbstractC12225eF4.c;
                    }
                    return C19938rB7.a;
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                c12889fL52 = (C12889fL5) this.b;
                AbstractC10685c16.b(obj);
                c12889fL5 = c12889fL52;
                c12889fL5.a = AbstractC12225eF4.c;
                return C19938rB7.a;
            }

            public final Object n(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C0630b) create(GJ0.b(obj), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.Sq2$b$c */
        static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            private /* synthetic */ Object c;
            final /* synthetic */ InterfaceC4557Fq2 d;

            /* renamed from: ir.nasim.Sq2$b$c$a */
            static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC16204ks5 a;

                /* renamed from: ir.nasim.Sq2$b$c$a$a, reason: collision with other inner class name */
                static final class C0631a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int c;

                    C0631a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.c |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                a(InterfaceC16204ks5 interfaceC16204ks5) {
                    this.a = interfaceC16204ks5;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof ir.nasim.AbstractC7654Sq2.b.c.a.C0631a
                        if (r0 == 0) goto L13
                        r0 = r6
                        ir.nasim.Sq2$b$c$a$a r0 = (ir.nasim.AbstractC7654Sq2.b.c.a.C0631a) r0
                        int r1 = r0.c
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.c = r1
                        goto L18
                    L13:
                        ir.nasim.Sq2$b$c$a$a r0 = new ir.nasim.Sq2$b$c$a$a
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.c
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r6)
                        goto L43
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        ir.nasim.AbstractC10685c16.b(r6)
                        ir.nasim.ks5 r6 = r4.a
                        if (r5 != 0) goto L3a
                        ir.nasim.i47 r5 = ir.nasim.AbstractC12225eF4.a
                    L3a:
                        r0.c = r3
                        java.lang.Object r5 = r6.o(r5, r0)
                        if (r5 != r1) goto L43
                        return r1
                    L43:
                        ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC7654Sq2.b.c.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = interfaceC4557Fq2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                c cVar = new c(this.d, interfaceC20295rm1);
                cVar.c = obj;
                return cVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC16204ks5 interfaceC16204ks5 = (InterfaceC16204ks5) this.c;
                    InterfaceC4557Fq2 interfaceC4557Fq2 = this.d;
                    a aVar = new a(interfaceC16204ks5);
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
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((c) create(interfaceC16204ks5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(UA2 ua2, InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
            this.g = ua2;
            this.h = interfaceC4557Fq2;
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0066  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00c2  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00e8 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:39:0x00e9  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00e6 -> B:7:0x001e). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                Method dump skipped, instructions count: 236
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC7654Sq2.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = new b(this.g, this.h, interfaceC20295rm1);
            bVar.e = interfaceC20315ro1;
            bVar.f = interfaceC4806Gq2;
            return bVar.invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Sq2$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ long d;
        final /* synthetic */ long e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(long j, long j2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
            this.e = j2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            c cVar = new c(this.d, this.e, interfaceC20295rm1);
            cVar.c = obj;
            return cVar;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        /* JADX WARN: Removed duplicated region for block: B:17:0x004f A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x005c A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x005a -> B:15:0x003f). Please report as a decompilation issue!!! */
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
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L2a
                if (r1 == r4) goto L22
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                goto L22
            L12:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L1a:
                java.lang.Object r1 = r7.c
                ir.nasim.ks5 r1 = (ir.nasim.InterfaceC16204ks5) r1
                ir.nasim.AbstractC10685c16.b(r8)
                goto L50
            L22:
                java.lang.Object r1 = r7.c
                ir.nasim.ks5 r1 = (ir.nasim.InterfaceC16204ks5) r1
                ir.nasim.AbstractC10685c16.b(r8)
                goto L3f
            L2a:
                ir.nasim.AbstractC10685c16.b(r8)
                java.lang.Object r8 = r7.c
                r1 = r8
                ir.nasim.ks5 r1 = (ir.nasim.InterfaceC16204ks5) r1
                long r5 = r7.d
                r7.c = r1
                r7.b = r4
                java.lang.Object r8 = ir.nasim.HG1.b(r5, r7)
                if (r8 != r0) goto L3f
                return r0
            L3f:
                ir.nasim.lo6 r8 = r1.j()
                ir.nasim.rB7 r4 = ir.nasim.C19938rB7.a
                r7.c = r1
                r7.b = r3
                java.lang.Object r8 = r8.o(r4, r7)
                if (r8 != r0) goto L50
                return r0
            L50:
                long r4 = r7.e
                r7.c = r1
                r7.b = r2
                java.lang.Object r8 = ir.nasim.HG1.b(r4, r7)
                if (r8 != r0) goto L3f
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC7654Sq2.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC16204ks5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Sq2$d */
    static final class d extends AbstractC19859r37 implements InterfaceC15796kB2 {
        Object b;
        Object c;
        int d;
        private /* synthetic */ Object e;
        /* synthetic */ Object f;
        final /* synthetic */ long g;
        final /* synthetic */ InterfaceC4557Fq2 h;

        /* renamed from: ir.nasim.Sq2$d$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C12889fL5 d;
            final /* synthetic */ VI5 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C12889fL5 c12889fL5, VI5 vi5, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c12889fL5;
                this.e = vi5;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, this.e, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return n(((GJ0) obj).k(), (InterfaceC20295rm1) obj2);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) throws Throwable {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                Object objK = ((GJ0) this.c).k();
                C12889fL5 c12889fL5 = this.d;
                boolean z = objK instanceof GJ0.c;
                if (!z) {
                    c12889fL5.a = objK;
                }
                VI5 vi5 = this.e;
                if (z) {
                    Throwable thE = GJ0.e(objK);
                    if (thE != null) {
                        throw thE;
                    }
                    vi5.g(new ChildCancelledException());
                    c12889fL5.a = AbstractC12225eF4.c;
                }
                return C19938rB7.a;
            }

            public final Object n(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(GJ0.b(obj), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.Sq2$d$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C12889fL5 c;
            final /* synthetic */ InterfaceC4806Gq2 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C12889fL5 c12889fL5, InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c12889fL5;
                this.d = interfaceC4806Gq2;
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
                    C12889fL5 c12889fL5 = this.c;
                    Object obj2 = c12889fL5.a;
                    if (obj2 == null) {
                        return C19938rB7.a;
                    }
                    c12889fL5.a = null;
                    InterfaceC4806Gq2 interfaceC4806Gq2 = this.d;
                    if (obj2 == AbstractC12225eF4.a) {
                        obj2 = null;
                    }
                    this.b = 1;
                    if (interfaceC4806Gq2.a(obj2, this) == objE) {
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
            public final Object invoke(C19938rB7 c19938rB7, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(c19938rB7, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.Sq2$d$c */
        static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            private /* synthetic */ Object c;
            final /* synthetic */ InterfaceC4557Fq2 d;

            /* renamed from: ir.nasim.Sq2$d$c$a */
            static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC16204ks5 a;

                /* renamed from: ir.nasim.Sq2$d$c$a$a, reason: collision with other inner class name */
                static final class C0632a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int c;

                    C0632a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.c |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                a(InterfaceC16204ks5 interfaceC16204ks5) {
                    this.a = interfaceC16204ks5;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof ir.nasim.AbstractC7654Sq2.d.c.a.C0632a
                        if (r0 == 0) goto L13
                        r0 = r6
                        ir.nasim.Sq2$d$c$a$a r0 = (ir.nasim.AbstractC7654Sq2.d.c.a.C0632a) r0
                        int r1 = r0.c
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.c = r1
                        goto L18
                    L13:
                        ir.nasim.Sq2$d$c$a$a r0 = new ir.nasim.Sq2$d$c$a$a
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.c
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r6)
                        goto L43
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        ir.nasim.AbstractC10685c16.b(r6)
                        ir.nasim.ks5 r6 = r4.a
                        if (r5 != 0) goto L3a
                        ir.nasim.i47 r5 = ir.nasim.AbstractC12225eF4.a
                    L3a:
                        r0.c = r3
                        java.lang.Object r5 = r6.o(r5, r0)
                        if (r5 != r1) goto L43
                        return r1
                    L43:
                        ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC7654Sq2.d.c.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = interfaceC4557Fq2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                c cVar = new c(this.d, interfaceC20295rm1);
                cVar.c = obj;
                return cVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC16204ks5 interfaceC16204ks5 = (InterfaceC16204ks5) this.c;
                    InterfaceC4557Fq2 interfaceC4557Fq2 = this.d;
                    a aVar = new a(interfaceC16204ks5);
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
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((c) create(interfaceC16204ks5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(long j, InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
            this.g = j;
            this.h = interfaceC4557Fq2;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC4806Gq2 interfaceC4806Gq2;
            VI5 vi5;
            C12889fL5 c12889fL5;
            VI5 vi5F;
            Object objE = AbstractC14862ic3.e();
            int i = this.d;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.e;
                InterfaceC4806Gq2 interfaceC4806Gq22 = (InterfaceC4806Gq2) this.f;
                VI5 vi5F2 = AbstractC13822gs5.f(interfaceC20315ro1, null, -1, new c(this.h, null), 1, null);
                C12889fL5 c12889fL52 = new C12889fL5();
                interfaceC4806Gq2 = interfaceC4806Gq22;
                vi5 = vi5F2;
                c12889fL5 = c12889fL52;
                vi5F = AbstractC7654Sq2.f(interfaceC20315ro1, this.g, 0L, 2, null);
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                vi5F = (VI5) this.c;
                c12889fL5 = (C12889fL5) this.b;
                vi5 = (VI5) this.f;
                interfaceC4806Gq2 = (InterfaceC4806Gq2) this.e;
                AbstractC10685c16.b(obj);
            }
            while (c12889fL5.a != AbstractC12225eF4.c) {
                C15554jm6 c15554jm6 = new C15554jm6(getContext());
                c15554jm6.h(vi5.t(), new a(c12889fL5, vi5F, null));
                c15554jm6.h(vi5F.r(), new b(c12889fL5, interfaceC4806Gq2, null));
                this.e = interfaceC4806Gq2;
                this.f = vi5;
                this.b = c12889fL5;
                this.c = vi5F;
                this.d = 1;
                if (c15554jm6.x(this) == objE) {
                    return objE;
                }
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            d dVar = new d(this.g, this.h, interfaceC20295rm1);
            dVar.e = interfaceC20315ro1;
            dVar.f = interfaceC4806Gq2;
            return dVar.invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Sq2$e */
    static final class e extends AbstractC19859r37 implements InterfaceC15796kB2 {
        long b;
        int c;
        private /* synthetic */ Object d;
        /* synthetic */ Object e;
        final /* synthetic */ long f;
        final /* synthetic */ InterfaceC4557Fq2 g;

        /* renamed from: ir.nasim.Sq2$e$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ InterfaceC4806Gq2 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = interfaceC4806Gq2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return n(((GJ0) obj).k(), (InterfaceC20295rm1) obj2);
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x003c  */
            /* JADX WARN: Removed duplicated region for block: B:19:0x0045  */
            @Override // ir.nasim.E90
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r5) {
                /*
                    r4 = this;
                    java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                    int r1 = r4.b
                    r2 = 1
                    if (r1 == 0) goto L19
                    if (r1 != r2) goto L11
                    java.lang.Object r0 = r4.c
                    ir.nasim.AbstractC10685c16.b(r5)
                    goto L36
                L11:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r0)
                    throw r5
                L19:
                    ir.nasim.AbstractC10685c16.b(r5)
                    java.lang.Object r5 = r4.c
                    ir.nasim.GJ0 r5 = (ir.nasim.GJ0) r5
                    java.lang.Object r5 = r5.k()
                    ir.nasim.Gq2 r1 = r4.d
                    boolean r3 = r5 instanceof ir.nasim.GJ0.c
                    if (r3 != 0) goto L37
                    r4.c = r5
                    r4.b = r2
                    java.lang.Object r1 = r1.a(r5, r4)
                    if (r1 != r0) goto L35
                    return r0
                L35:
                    r0 = r5
                L36:
                    r5 = r0
                L37:
                    boolean r0 = r5 instanceof ir.nasim.GJ0.a
                    if (r0 == 0) goto L45
                    ir.nasim.GJ0.e(r5)
                    r5 = 0
                    java.lang.Boolean r5 = ir.nasim.AbstractC6392Nk0.a(r5)
                    return r5
                L45:
                    java.lang.Boolean r5 = ir.nasim.AbstractC6392Nk0.a(r2)
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC7654Sq2.e.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            public final Object n(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(GJ0.b(obj), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.Sq2$e$b */
        static final class b extends AbstractC19859r37 implements UA2 {
            int b;
            final /* synthetic */ long c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(long j, InterfaceC20295rm1 interfaceC20295rm1) {
                super(1, interfaceC20295rm1);
                this.c = j;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
                return new b(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                throw new TimeoutCancellationException("Timed out waiting for " + ((Object) Q12.S(this.c)));
            }

            @Override // ir.nasim.UA2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(long j, InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
            this.f = j;
            this.g = interfaceC4557Fq2;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0076 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:16:0x007f  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0074 -> B:14:0x0077). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r9.c
                r2 = 1
                r3 = 0
                if (r1 == 0) goto L22
                if (r1 != r2) goto L1a
                long r4 = r9.b
                java.lang.Object r1 = r9.e
                ir.nasim.VI5 r1 = (ir.nasim.VI5) r1
                java.lang.Object r6 = r9.d
                ir.nasim.Gq2 r6 = (ir.nasim.InterfaceC4806Gq2) r6
                ir.nasim.AbstractC10685c16.b(r10)
                goto L77
            L1a:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L22:
                ir.nasim.AbstractC10685c16.b(r10)
                java.lang.Object r10 = r9.d
                ir.nasim.ro1 r10 = (ir.nasim.InterfaceC20315ro1) r10
                java.lang.Object r1 = r9.e
                ir.nasim.Gq2 r1 = (ir.nasim.InterfaceC4806Gq2) r1
                long r4 = r9.f
                ir.nasim.Q12$a r6 = ir.nasim.Q12.b
                long r6 = r6.c()
                int r4 = ir.nasim.Q12.r(r4, r6)
                if (r4 <= 0) goto L82
                ir.nasim.Fq2 r4 = r9.g
                r5 = 0
                r6 = 2
                ir.nasim.Fq2 r4 = ir.nasim.AbstractC6459Nq2.e(r4, r5, r3, r6, r3)
                ir.nasim.VI5 r10 = ir.nasim.AbstractC6459Nq2.e0(r4, r10)
                long r4 = r9.f
                r6 = r1
                r1 = r10
            L4b:
                ir.nasim.jm6 r10 = new ir.nasim.jm6
                ir.nasim.do1 r7 = r9.getContext()
                r10.<init>(r7)
                ir.nasim.gm6 r7 = r1.t()
                ir.nasim.Sq2$e$a r8 = new ir.nasim.Sq2$e$a
                r8.<init>(r6, r3)
                r10.h(r7, r8)
                ir.nasim.Sq2$e$b r7 = new ir.nasim.Sq2$e$b
                r7.<init>(r4, r3)
                ir.nasim.AbstractC15288jK4.b(r10, r4, r7)
                r9.d = r6
                r9.e = r1
                r9.b = r4
                r9.c = r2
                java.lang.Object r10 = r10.x(r9)
                if (r10 != r0) goto L77
                return r0
            L77:
                java.lang.Boolean r10 = (java.lang.Boolean) r10
                boolean r10 = r10.booleanValue()
                if (r10 != 0) goto L4b
                ir.nasim.rB7 r10 = ir.nasim.C19938rB7.a
                return r10
            L82:
                kotlinx.coroutines.TimeoutCancellationException r10 = new kotlinx.coroutines.TimeoutCancellationException
                java.lang.String r0 = "Timed out immediately"
                r10.<init>(r0)
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC7654Sq2.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            e eVar = new e(this.f, this.g, interfaceC20295rm1);
            eVar.d = interfaceC20315ro1;
            eVar.e = interfaceC4806Gq2;
            return eVar.invokeSuspend(C19938rB7.a);
        }
    }

    public static final InterfaceC4557Fq2 a(InterfaceC4557Fq2 interfaceC4557Fq2, long j) {
        if (j >= 0) {
            return j == 0 ? interfaceC4557Fq2 : d(interfaceC4557Fq2, new a(j));
        }
        throw new IllegalArgumentException("Debounce timeout should not be negative".toString());
    }

    public static final InterfaceC4557Fq2 b(InterfaceC4557Fq2 interfaceC4557Fq2, UA2 ua2) {
        return d(interfaceC4557Fq2, ua2);
    }

    public static final InterfaceC4557Fq2 c(InterfaceC4557Fq2 interfaceC4557Fq2, long j) {
        return AbstractC6459Nq2.s(interfaceC4557Fq2, HG1.e(j));
    }

    private static final InterfaceC4557Fq2 d(InterfaceC4557Fq2 interfaceC4557Fq2, UA2 ua2) {
        return AbstractC5274Iq2.b(new b(ua2, interfaceC4557Fq2, null));
    }

    public static final VI5 e(InterfaceC20315ro1 interfaceC20315ro1, long j, long j2) {
        if (j < 0) {
            throw new IllegalArgumentException(("Expected non-negative delay, but has " + j + " ms").toString());
        }
        if (j2 >= 0) {
            return AbstractC13822gs5.f(interfaceC20315ro1, null, 0, new c(j2, j, null), 1, null);
        }
        throw new IllegalArgumentException(("Expected non-negative initial delay, but has " + j2 + " ms").toString());
    }

    public static /* synthetic */ VI5 f(InterfaceC20315ro1 interfaceC20315ro1, long j, long j2, int i, Object obj) {
        if ((i & 2) != 0) {
            j2 = j;
        }
        return AbstractC6459Nq2.K(interfaceC20315ro1, j, j2);
    }

    public static final InterfaceC4557Fq2 g(InterfaceC4557Fq2 interfaceC4557Fq2, long j) {
        if (j > 0) {
            return AbstractC5274Iq2.b(new d(j, interfaceC4557Fq2, null));
        }
        throw new IllegalArgumentException("Sample period should be positive".toString());
    }

    public static final InterfaceC4557Fq2 h(InterfaceC4557Fq2 interfaceC4557Fq2, long j) {
        return i(interfaceC4557Fq2, j);
    }

    private static final InterfaceC4557Fq2 i(InterfaceC4557Fq2 interfaceC4557Fq2, long j) {
        return AbstractC5274Iq2.b(new e(j, interfaceC4557Fq2, null));
    }
}
