package ir.nasim;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC12895fM2;
import ir.nasim.AbstractC17643nJ4;
import ir.nasim.AbstractC7031Pz0;
import ir.nasim.C17448mz0;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Mu0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6243Mu0 extends VW7 {
    private final C4627Fy0 b;
    private final C10299bQ2 c;
    private final Context d;
    private final InterfaceC10258bL6 e;

    /* renamed from: ir.nasim.Mu0$a */
    static final class a extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return C6243Mu0.this.V0(null, null, this);
        }
    }

    /* renamed from: ir.nasim.Mu0$b */
    static final class b extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        /* synthetic */ Object c;
        /* synthetic */ Object d;
        final /* synthetic */ C11458d25 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C11458d25 c11458d25, InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
            this.f = c11458d25;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object next;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC6009Lu0 interfaceC6009Lu0 = (InterfaceC6009Lu0) this.c;
                List list = (List) this.d;
                C11458d25 c11458d25 = this.f;
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    AbstractC17643nJ4 abstractC17643nJ4 = (AbstractC17643nJ4) next;
                    AbstractC17643nJ4.a aVar = abstractC17643nJ4 instanceof AbstractC17643nJ4.a ? (AbstractC17643nJ4.a) abstractC17643nJ4 : null;
                    if (aVar != null && aVar.c() == c11458d25.getPeerId()) {
                        break;
                    }
                }
                AbstractC17643nJ4 abstractC17643nJ42 = (AbstractC17643nJ4) next;
                if (!(interfaceC6009Lu0 instanceof J03) || abstractC17643nJ42 == null) {
                    return interfaceC6009Lu0;
                }
                C6243Mu0 c6243Mu0 = C6243Mu0.this;
                C10299bQ2 c10299bQ2 = c6243Mu0.c;
                this.c = null;
                this.b = 1;
                obj = c6243Mu0.V0(abstractC17643nJ42, c10299bQ2, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return (InterfaceC6009Lu0) obj;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(InterfaceC6009Lu0 interfaceC6009Lu0, List list, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = C6243Mu0.this.new b(this.f, interfaceC20295rm1);
            bVar.c = interfaceC6009Lu0;
            bVar.d = list;
            return bVar.invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Mu0$c */
    public static final class c implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        /* renamed from: ir.nasim.Mu0$c$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.Mu0$c$a$a, reason: collision with other inner class name */
            public static final class C0522a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0522a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                this.a = interfaceC4806Gq2;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r7, ir.nasim.InterfaceC20295rm1 r8) {
                /*
                    r6 = this;
                    boolean r0 = r8 instanceof ir.nasim.C6243Mu0.c.a.C0522a
                    if (r0 == 0) goto L13
                    r0 = r8
                    ir.nasim.Mu0$c$a$a r0 = (ir.nasim.C6243Mu0.c.a.C0522a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.Mu0$c$a$a r0 = new ir.nasim.Mu0$c$a$a
                    r0.<init>(r8)
                L18:
                    java.lang.Object r8 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r8)
                    goto L4f
                L29:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L31:
                    ir.nasim.AbstractC10685c16.b(r8)
                    ir.nasim.Gq2 r8 = r6.a
                    java.lang.Number r7 = (java.lang.Number) r7
                    double r4 = r7.doubleValue()
                    ir.nasim.nq7 r7 = ir.nasim.C17959nq7.a
                    java.lang.String r7 = r7.d(r4)
                    java.lang.String r7 = ir.nasim.XY6.v(r7)
                    r0.b = r3
                    java.lang.Object r7 = r8.a(r7, r0)
                    if (r7 != r1) goto L4f
                    return r1
                L4f:
                    ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6243Mu0.c.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public c(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Mu0$d */
    public static final class d implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        /* renamed from: ir.nasim.Mu0$d$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.Mu0$d$a$a, reason: collision with other inner class name */
            public static final class C0523a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0523a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                this.a = interfaceC4806Gq2;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r7, ir.nasim.InterfaceC20295rm1 r8) {
                /*
                    r6 = this;
                    boolean r0 = r8 instanceof ir.nasim.C6243Mu0.d.a.C0523a
                    if (r0 == 0) goto L13
                    r0 = r8
                    ir.nasim.Mu0$d$a$a r0 = (ir.nasim.C6243Mu0.d.a.C0523a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.Mu0$d$a$a r0 = new ir.nasim.Mu0$d$a$a
                    r0.<init>(r8)
                L18:
                    java.lang.Object r8 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r8)
                    goto L4f
                L29:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L31:
                    ir.nasim.AbstractC10685c16.b(r8)
                    ir.nasim.Gq2 r8 = r6.a
                    java.lang.Number r7 = (java.lang.Number) r7
                    double r4 = r7.doubleValue()
                    ir.nasim.nq7 r7 = ir.nasim.C17959nq7.a
                    java.lang.String r7 = r7.d(r4)
                    java.lang.String r7 = ir.nasim.XY6.v(r7)
                    r0.b = r3
                    java.lang.Object r7 = r8.a(r7, r0)
                    if (r7 != r1) goto L4f
                    return r1
                L4f:
                    ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6243Mu0.d.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public d(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Mu0$e */
    public static final class e implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        /* renamed from: ir.nasim.Mu0$e$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.Mu0$e$a$a, reason: collision with other inner class name */
            public static final class C0524a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0524a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                this.a = interfaceC4806Gq2;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r7, ir.nasim.InterfaceC20295rm1 r8) {
                /*
                    r6 = this;
                    boolean r0 = r8 instanceof ir.nasim.C6243Mu0.e.a.C0524a
                    if (r0 == 0) goto L13
                    r0 = r8
                    ir.nasim.Mu0$e$a$a r0 = (ir.nasim.C6243Mu0.e.a.C0524a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.Mu0$e$a$a r0 = new ir.nasim.Mu0$e$a$a
                    r0.<init>(r8)
                L18:
                    java.lang.Object r8 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r8)
                    goto L4f
                L29:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L31:
                    ir.nasim.AbstractC10685c16.b(r8)
                    ir.nasim.Gq2 r8 = r6.a
                    java.lang.Number r7 = (java.lang.Number) r7
                    double r4 = r7.doubleValue()
                    ir.nasim.nq7 r7 = ir.nasim.C17959nq7.a
                    java.lang.String r7 = r7.d(r4)
                    java.lang.String r7 = ir.nasim.XY6.v(r7)
                    r0.b = r3
                    java.lang.Object r7 = r8.a(r7, r0)
                    if (r7 != r1) goto L4f
                    return r1
                L4f:
                    ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6243Mu0.e.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public e(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Mu0$f */
    static final class f extends AbstractC22163um1 {
        Object a;
        long b;
        /* synthetic */ Object c;
        int e;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return C6243Mu0.this.b1(null, null, this);
        }
    }

    /* renamed from: ir.nasim.Mu0$g */
    public static final class g implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ C6243Mu0 b;

        /* renamed from: ir.nasim.Mu0$g$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ C6243Mu0 b;

            /* renamed from: ir.nasim.Mu0$g$a$a, reason: collision with other inner class name */
            public static final class C0525a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0525a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2, C6243Mu0 c6243Mu0) {
                this.a = interfaceC4806Gq2;
                this.b = c6243Mu0;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r6, ir.nasim.InterfaceC20295rm1 r7) {
                /*
                    r5 = this;
                    boolean r0 = r7 instanceof ir.nasim.C6243Mu0.g.a.C0525a
                    if (r0 == 0) goto L13
                    r0 = r7
                    ir.nasim.Mu0$g$a$a r0 = (ir.nasim.C6243Mu0.g.a.C0525a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.Mu0$g$a$a r0 = new ir.nasim.Mu0$g$a$a
                    r0.<init>(r7)
                L18:
                    java.lang.Object r7 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r7)
                    goto L50
                L29:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r7)
                    throw r6
                L31:
                    ir.nasim.AbstractC10685c16.b(r7)
                    ir.nasim.Gq2 r7 = r5.a
                    ir.nasim.mz0 r6 = (ir.nasim.C17448mz0) r6
                    ir.nasim.Mu0 r2 = r5.b
                    ir.nasim.C6243Mu0.R0(r2)
                    ir.nasim.nz0 r4 = ir.nasim.C18039nz0.a
                    ir.nasim.Zm4 r4 = r4.a()
                    ir.nasim.Lu0 r6 = ir.nasim.C6243Mu0.T0(r2, r6, r4)
                    r0.b = r3
                    java.lang.Object r6 = r7.a(r6, r0)
                    if (r6 != r1) goto L50
                    return r1
                L50:
                    ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6243Mu0.g.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public g(InterfaceC4557Fq2 interfaceC4557Fq2, C6243Mu0 c6243Mu0) {
            this.a = interfaceC4557Fq2;
            this.b = c6243Mu0;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    public C6243Mu0(C4627Fy0 c4627Fy0, C10299bQ2 c10299bQ2, Context context) {
        AbstractC13042fc3.i(c4627Fy0, "callRepository");
        AbstractC13042fc3.i(c10299bQ2, "groupsModule");
        AbstractC13042fc3.i(context, "context");
        this.b = c4627Fy0;
        this.c = c10299bQ2;
        this.d = context;
        C18039nz0 c18039nz0 = C18039nz0.a;
        this.e = AbstractC6459Nq2.o0(new g(c18039nz0.d(), this), AbstractC9773aX7.a(this), InterfaceC16863lz6.a.c(), Z0((C17448mz0) c18039nz0.d().getValue(), c18039nz0.a()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object V0(ir.nasim.AbstractC17643nJ4 r5, ir.nasim.C10299bQ2 r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ir.nasim.C6243Mu0.a
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.Mu0$a r0 = (ir.nasim.C6243Mu0.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.Mu0$a r0 = new ir.nasim.Mu0$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r7)
            goto L3d
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            ir.nasim.AbstractC10685c16.b(r7)
            r0.c = r3
            java.lang.Object r7 = r4.b1(r5, r6, r0)
            if (r7 != r1) goto L3d
            return r1
        L3d:
            ir.nasim.Ku0 r7 = (ir.nasim.C5776Ku0) r7
            ir.nasim.yU r5 = new ir.nasim.yU
            r5.<init>(r7)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6243Mu0.V0(ir.nasim.nJ4, ir.nasim.bQ2, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC6009Lu0 Z0(C17448mz0 c17448mz0, InterfaceC4557Fq2 interfaceC4557Fq2) {
        boolean z = false;
        int i = -1;
        if (!c17448mz0.m()) {
            C17448mz0.a aVarE = c17448mz0.e();
            int[] iArr = AbstractC6503Nu0.a;
            switch (iArr[aVarE.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    z = true;
                    break;
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            if (!z) {
                if (z) {
                    throw new NoWhenBranchMatchedException();
                }
                return J03.a;
            }
            if (iArr[c17448mz0.e().ordinal()] == 4) {
                return new C13947h53(a1(c17448mz0), new e(interfaceC4557Fq2));
            }
            C5776Ku0 c5776Ku0A1 = a1(c17448mz0);
            switch (iArr[c17448mz0.e().ordinal()]) {
                case 1:
                case 2:
                    i = AbstractC12217eE5.voice_call_state_outgoing_requested;
                    break;
                case 3:
                    i = AbstractC12217eE5.voice_call_state_outgoing_recieved;
                    break;
                case 4:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                    break;
                case 5:
                    if (!AbstractC13042fc3.d(c17448mz0.f(), AbstractC7031Pz0.c.b)) {
                        i = AbstractC12217eE5.voice_call_state_incoming;
                        break;
                    } else {
                        i = AbstractC12217eE5.video_call_state_incoming;
                        break;
                    }
                case 6:
                    i = AbstractC12217eE5.voice_call_state_reconnecting;
                    break;
                case 7:
                    i = AbstractC12217eE5.voice_call_state_incoming_accepted;
                    break;
                case 8:
                    i = AbstractC12217eE5.voice_call_state_on_hold;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            return new C19266q35(c5776Ku0A1, i);
        }
        C17448mz0.a aVarE2 = c17448mz0.e();
        int[] iArr2 = AbstractC6503Nu0.a;
        switch (iArr2[aVarE2.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                z = true;
                break;
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        if (!z) {
            if (z) {
                throw new NoWhenBranchMatchedException();
            }
            return J03.a;
        }
        if (((c17448mz0.f() instanceof AbstractC7031Pz0.b) && AbstractC13042fc3.d(((AbstractC7031Pz0.b) c17448mz0.f()).d(), AbstractC12895fM2.a.a)) || (((c17448mz0.f() instanceof AbstractC7031Pz0.h) && AbstractC13042fc3.d(((AbstractC7031Pz0.h) c17448mz0.f()).d(), AbstractC12895fM2.a.a)) || (((c17448mz0.f() instanceof AbstractC7031Pz0.d) && AbstractC13042fc3.d(((AbstractC7031Pz0.d) c17448mz0.f()).d(), AbstractC12895fM2.a.a)) || ((c17448mz0.f() instanceof AbstractC7031Pz0.f) && AbstractC13042fc3.d(((AbstractC7031Pz0.f) c17448mz0.f()).g(), AbstractC12895fM2.a.a))))) {
            if (iArr2[c17448mz0.e().ordinal()] == 4) {
                return new C7124Qj3(a1(c17448mz0), new c(interfaceC4557Fq2));
            }
            C5776Ku0 c5776Ku0A12 = a1(c17448mz0);
            switch (iArr2[c17448mz0.e().ordinal()]) {
                case 1:
                case 2:
                    i = AbstractC12217eE5.voice_call_state_outgoing_requested;
                    break;
                case 3:
                    i = AbstractC12217eE5.voice_call_state_outgoing_recieved;
                    break;
                case 4:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                    break;
                case 5:
                    if (!AbstractC13042fc3.d(c17448mz0.f(), AbstractC7031Pz0.c.b)) {
                        i = AbstractC12217eE5.voice_call_state_incoming;
                        break;
                    } else {
                        i = AbstractC12217eE5.video_call_state_incoming;
                        break;
                    }
                case 6:
                    i = AbstractC12217eE5.voice_call_state_reconnecting;
                    break;
                case 7:
                    i = AbstractC12217eE5.voice_call_state_incoming_accepted;
                    break;
                case 8:
                    i = AbstractC12217eE5.voice_call_state_on_hold;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            return new C16943m76(c5776Ku0A12, i);
        }
        if (iArr2[c17448mz0.e().ordinal()] == 4) {
            return new C6147Mj3(a1(c17448mz0), new d(interfaceC4557Fq2));
        }
        C5776Ku0 c5776Ku0A13 = a1(c17448mz0);
        switch (iArr2[c17448mz0.e().ordinal()]) {
            case 1:
            case 2:
                i = AbstractC12217eE5.voice_call_state_outgoing_requested;
                break;
            case 3:
                i = AbstractC12217eE5.voice_call_state_outgoing_recieved;
                break;
            case 4:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                break;
            case 5:
                if (!AbstractC13042fc3.d(c17448mz0.f(), AbstractC7031Pz0.c.b)) {
                    i = AbstractC12217eE5.voice_call_state_incoming;
                    break;
                } else {
                    i = AbstractC12217eE5.video_call_state_incoming;
                    break;
                }
            case 6:
                i = AbstractC12217eE5.voice_call_state_reconnecting;
                break;
            case 7:
                i = AbstractC12217eE5.voice_call_state_incoming_accepted;
                break;
            case 8:
                i = AbstractC12217eE5.voice_call_state_on_hold;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return new C16943m76(c5776Ku0A13, i);
    }

    private final C5776Ku0 a1(C17448mz0 c17448mz0) {
        String string;
        AbstractC7031Pz0 abstractC7031Pz0F = c17448mz0.f();
        long jB = c17448mz0.d() != null ? r1.b() : 0L;
        if (abstractC7031Pz0F instanceof AbstractC7031Pz0.f) {
            string = ((AbstractC7031Pz0.f) abstractC7031Pz0F).f();
            if (!(true ^ (string == null || AbstractC20762sZ6.n0(string)))) {
                string = null;
            }
            if (string == null) {
                string = c17448mz0.o() ? this.d.getString(AbstractC12217eE5.nasim_call_link_share_template_default_title) : this.d.getString(AbstractC12217eE5.nasim_group_call);
                AbstractC13042fc3.f(string);
            }
        } else {
            C8942Xx0 c8942Xx0D = c17448mz0.d();
            if (c8942Xx0D == null || (string = c8942Xx0D.c()) == null) {
                string = this.d.getString(AbstractC12217eE5.nasim_group_call);
                AbstractC13042fc3.h(string, "getString(...)");
            }
        }
        return new C5776Ku0(jB, string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b1(ir.nasim.AbstractC17643nJ4 r11, ir.nasim.C10299bQ2 r12, ir.nasim.InterfaceC20295rm1 r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof ir.nasim.C6243Mu0.f
            if (r0 == 0) goto L13
            r0 = r13
            ir.nasim.Mu0$f r0 = (ir.nasim.C6243Mu0.f) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.Mu0$f r0 = new ir.nasim.Mu0$f
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            java.lang.String r3 = "getString(...)"
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L41
            if (r2 != r5) goto L39
            long r11 = r0.b
            java.lang.Object r0 = r0.a
            ir.nasim.Mu0 r0 = (ir.nasim.C6243Mu0) r0
            ir.nasim.AbstractC10685c16.b(r13)
            ir.nasim.a16 r13 = (ir.nasim.C9475a16) r13
            java.lang.Object r13 = r13.l()
            goto La7
        L39:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L41:
            ir.nasim.AbstractC10685c16.b(r13)
            long r6 = r11.a()
            boolean r13 = r11 instanceof ir.nasim.AbstractC17643nJ4.c
            if (r13 == 0) goto L80
            boolean r12 = r11 instanceof ir.nasim.AbstractC17643nJ4.b
            if (r12 == 0) goto L74
            ir.nasim.nJ4$b r11 = (ir.nasim.AbstractC17643nJ4.b) r11
            java.lang.String r11 = r11.e()
            if (r11 == 0) goto L61
            boolean r12 = ir.nasim.AbstractC14836iZ6.n0(r11)
            if (r12 == 0) goto L5f
            goto L61
        L5f:
            r12 = 0
            goto L62
        L61:
            r12 = r5
        L62:
            r12 = r12 ^ r5
            if (r12 == 0) goto L66
            r4 = r11
        L66:
            if (r4 != 0) goto Lc8
            android.content.Context r11 = r10.d
            int r12 = ir.nasim.AbstractC12217eE5.nasim_call_link_share_template_default_title
            java.lang.String r4 = r11.getString(r12)
            ir.nasim.AbstractC13042fc3.h(r4, r3)
            goto Lc8
        L74:
            android.content.Context r11 = r10.d
            int r12 = ir.nasim.AbstractC12217eE5.nasim_group_call
            java.lang.String r4 = r11.getString(r12)
            ir.nasim.AbstractC13042fc3.f(r4)
            goto Lc8
        L80:
            boolean r13 = r11 instanceof ir.nasim.AbstractC17643nJ4.a
            if (r13 == 0) goto Lce
            ir.nasim.Vo3 r12 = r12.X1()
            ir.nasim.nJ4$a r11 = (ir.nasim.AbstractC17643nJ4.a) r11
            int r11 = r11.c()
            long r8 = (long) r11
            ir.nasim.Nv5 r11 = r12.a(r8)
            java.lang.String r12 = "getValue(...)"
            ir.nasim.AbstractC13042fc3.h(r11, r12)
            r0.a = r10
            r0.b = r6
            r0.e = r5
            java.lang.Object r13 = ir.nasim.AbstractC6756Ov5.d(r11, r4, r0, r5, r4)
            if (r13 != r1) goto La5
            return r1
        La5:
            r0 = r10
            r11 = r6
        La7:
            boolean r1 = ir.nasim.C9475a16.g(r13)
            if (r1 == 0) goto Lae
            goto Laf
        Lae:
            r4 = r13
        Laf:
            ir.nasim.iL2 r4 = (ir.nasim.C14697iL2) r4
            if (r4 == 0) goto Lbc
            java.lang.String r4 = r4.G0()
            if (r4 != 0) goto Lba
            goto Lbc
        Lba:
            r6 = r11
            goto Lc8
        Lbc:
            android.content.Context r13 = r0.d
            int r0 = ir.nasim.AbstractC12217eE5.nasim_group_call
            java.lang.String r4 = r13.getString(r0)
            ir.nasim.AbstractC13042fc3.h(r4, r3)
            goto Lba
        Lc8:
            ir.nasim.Ku0 r11 = new ir.nasim.Ku0
            r11.<init>(r6, r4)
            return r11
        Lce:
            kotlin.NoWhenBranchMatchedException r11 = new kotlin.NoWhenBranchMatchedException
            r11.<init>()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6243Mu0.b1(ir.nasim.nJ4, ir.nasim.bQ2, ir.nasim.rm1):java.lang.Object");
    }

    public final InterfaceC10258bL6 W0() {
        return this.e;
    }

    public final InterfaceC10258bL6 X0(C11458d25 c11458d25) {
        AbstractC13042fc3.i(c11458d25, "currentPeer");
        if (!c11458d25.z()) {
            return this.e;
        }
        InterfaceC4557Fq2 interfaceC4557Fq2P = AbstractC6459Nq2.p(this.e, C10263bM2.a.b(), new b(c11458d25, null));
        InterfaceC20315ro1 interfaceC20315ro1A = AbstractC9773aX7.a(this);
        InterfaceC16863lz6 interfaceC16863lz6C = InterfaceC16863lz6.a.c();
        C18039nz0 c18039nz0 = C18039nz0.a;
        return AbstractC6459Nq2.o0(interfaceC4557Fq2P, interfaceC20315ro1A, interfaceC16863lz6C, Z0((C17448mz0) c18039nz0.d().getValue(), c18039nz0.a()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Y0(long j) {
        AbstractC17643nJ4.a aVar;
        Iterator it = ((Iterable) C10263bM2.a.b().getValue()).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            AbstractC17643nJ4 abstractC17643nJ4 = (AbstractC17643nJ4) next;
            aVar = abstractC17643nJ4 instanceof AbstractC17643nJ4.a ? (AbstractC17643nJ4.a) abstractC17643nJ4 : null;
            if (aVar != null && aVar.a() == j) {
                aVar = next;
                break;
            }
        }
        AbstractC17643nJ4.a aVar2 = aVar;
        if (aVar2 != null) {
            if (((C17448mz0) C18039nz0.a.d().getValue()).e() == C17448mz0.a.e) {
                InterfaceC5110Hy0.c(this.b, true, 0L, 2, null);
            } else {
                AbstractC17643nJ4.a aVar3 = aVar2;
                C20384rv0.a.O(aVar3.c(), aVar3.a(), aVar3.b());
            }
        }
    }
}
