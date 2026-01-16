package ir.nasim;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC17858ng6;
import ir.nasim.C24270yK6;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.rr1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C20345rr1 extends VW7 {
    private final C4627Fy0 b;
    private final C14375ho5 c;
    private final Context d;
    private final AbstractC13778go1 e;
    private final int f;
    private InterfaceC9336Zm4 g;
    private final InterfaceC9336Zm4 h;
    private final InterfaceC10258bL6 i;
    private InterfaceC9336Zm4 j;
    private final InterfaceC9336Zm4 k;
    private final InterfaceC4557Fq2 l;

    /* renamed from: ir.nasim.rr1$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.rr1$a$a, reason: collision with other inner class name */
        static final class C1524a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C20345rr1 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1524a(C20345rr1 c20345rr1, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c20345rr1;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                C1524a c1524a = new C1524a(this.d, interfaceC20295rm1);
                c1524a.c = obj;
                return c1524a;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object value;
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                String str = (String) this.c;
                InterfaceC9336Zm4 interfaceC9336Zm4 = this.d.h;
                do {
                    value = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value, C19736qr1.b((C19736qr1) value, null, str, 1, null)));
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(String str, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C1524a) create(str, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C20345rr1.this.new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm4 = C20345rr1.this.j;
                C1524a c1524a = new C1524a(C20345rr1.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC9336Zm4, c1524a, this) == objE) {
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

    /* renamed from: ir.nasim.rr1$b */
    public static final class b extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        private /* synthetic */ Object c;
        /* synthetic */ Object d;
        final /* synthetic */ C20345rr1 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(InterfaceC20295rm1 interfaceC20295rm1, C20345rr1 c20345rr1) {
            super(3, interfaceC20295rm1);
            this.e = c20345rr1;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                InterfaceC4557Fq2 interfaceC4557Fq2V = AbstractC6459Nq2.V(AbstractC6459Nq2.S(AbstractC6459Nq2.S(AbstractC9395Zt0.a(new h(new g(this.e.b.s0(AbstractC9773aX7.a(this.e), (String) this.d), this.e), this.e), AbstractC9773aX7.a(this.e)), new i(this.e.g), new e(null)), this.e.l, new f(null)), C12366eV1.b());
                this.b = 1;
                if (AbstractC6459Nq2.A(interfaceC4806Gq2, interfaceC4557Fq2V, this) == objE) {
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

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = new b(interfaceC20295rm1, this.e);
            bVar.c = interfaceC4806Gq2;
            bVar.d = obj;
            return bVar.invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.rr1$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            c cVar = C20345rr1.this.new c(interfaceC20295rm1);
            cVar.c = obj;
            return cVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return AbstractC6392Nk0.a(((C22613vY) this.c).d() != C20345rr1.this.f);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(C22613vY c22613vY, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(c22613vY, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.rr1$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            d dVar = C20345rr1.this.new d(interfaceC20295rm1);
            dVar.c = obj;
            return dVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C22613vY c22613vY = (C22613vY) this.c;
            List listP1 = AbstractC15401jX0.p1((Collection) C20345rr1.this.k.getValue());
            listP1.add(AbstractC6392Nk0.d(c22613vY.d()));
            InterfaceC9336Zm4 interfaceC9336Zm4 = C20345rr1.this.k;
            do {
                value = interfaceC9336Zm4.getValue();
            } while (!interfaceC9336Zm4.f(value, listP1));
            return c22613vY;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(C22613vY c22613vY, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(c22613vY, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.rr1$e */
    static final class e extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        /* synthetic */ Object c;
        /* synthetic */ Object d;

        /* renamed from: ir.nasim.rr1$e$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ List d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(List list, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = list;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
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
                C22613vY c22613vY = (C22613vY) this.c;
                return this.d.contains(AbstractC6392Nk0.d(c22613vY.d())) ? C22613vY.b(c22613vY, 0, null, null, true, null, false, 55, null) : c22613vY;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C22613vY c22613vY, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(c22613vY, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return UT4.g((NT4) this.c, new a((List) this.d, null));
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(NT4 nt4, List list, InterfaceC20295rm1 interfaceC20295rm1) {
            e eVar = new e(interfaceC20295rm1);
            eVar.c = nt4;
            eVar.d = list;
            return eVar.invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.rr1$f */
    static final class f extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        /* synthetic */ Object c;
        /* synthetic */ Object d;

        /* renamed from: ir.nasim.rr1$f$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ List d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(List list, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = list;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object next;
                C22613vY c22613vYB;
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                C22613vY c22613vY = (C22613vY) this.c;
                Iterator it = this.d.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    XV4 xv4 = (XV4) next;
                    if (c22613vY.d() == ((Number) xv4.e()).intValue() && ((CharSequence) xv4.f()).length() > 0) {
                        break;
                    }
                }
                XV4 xv42 = (XV4) next;
                return (xv42 == null || (c22613vYB = C22613vY.b(c22613vY, 0, null, null, false, (String) xv42.f(), false, 47, null)) == null) ? c22613vY : c22613vYB;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C22613vY c22613vY, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(c22613vY, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return UT4.g((NT4) this.c, new a((List) this.d, null));
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(NT4 nt4, List list, InterfaceC20295rm1 interfaceC20295rm1) {
            f fVar = new f(interfaceC20295rm1);
            fVar.c = nt4;
            fVar.d = list;
            return fVar.invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.rr1$g */
    public static final class g implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ C20345rr1 b;

        /* renamed from: ir.nasim.rr1$g$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ C20345rr1 b;

            /* renamed from: ir.nasim.rr1$g$a$a, reason: collision with other inner class name */
            public static final class C1525a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C1525a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2, C20345rr1 c20345rr1) {
                this.a = interfaceC4806Gq2;
                this.b = c20345rr1;
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
                    boolean r0 = r8 instanceof ir.nasim.C20345rr1.g.a.C1525a
                    if (r0 == 0) goto L13
                    r0 = r8
                    ir.nasim.rr1$g$a$a r0 = (ir.nasim.C20345rr1.g.a.C1525a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.rr1$g$a$a r0 = new ir.nasim.rr1$g$a$a
                    r0.<init>(r8)
                L18:
                    java.lang.Object r8 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r8)
                    goto L4d
                L29:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L31:
                    ir.nasim.AbstractC10685c16.b(r8)
                    ir.nasim.Gq2 r8 = r6.a
                    ir.nasim.NT4 r7 = (ir.nasim.NT4) r7
                    ir.nasim.rr1$c r2 = new ir.nasim.rr1$c
                    ir.nasim.rr1 r4 = r6.b
                    r5 = 0
                    r2.<init>(r5)
                    ir.nasim.NT4 r7 = ir.nasim.TT4.a(r7, r2)
                    r0.b = r3
                    java.lang.Object r7 = r8.a(r7, r0)
                    if (r7 != r1) goto L4d
                    return r1
                L4d:
                    ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20345rr1.g.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public g(InterfaceC4557Fq2 interfaceC4557Fq2, C20345rr1 c20345rr1) {
            this.a = interfaceC4557Fq2;
            this.b = c20345rr1;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.rr1$h */
    public static final class h implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ C20345rr1 b;

        /* renamed from: ir.nasim.rr1$h$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ C20345rr1 b;

            /* renamed from: ir.nasim.rr1$h$a$a, reason: collision with other inner class name */
            public static final class C1526a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C1526a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2, C20345rr1 c20345rr1) {
                this.a = interfaceC4806Gq2;
                this.b = c20345rr1;
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
                    boolean r0 = r8 instanceof ir.nasim.C20345rr1.h.a.C1526a
                    if (r0 == 0) goto L13
                    r0 = r8
                    ir.nasim.rr1$h$a$a r0 = (ir.nasim.C20345rr1.h.a.C1526a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.rr1$h$a$a r0 = new ir.nasim.rr1$h$a$a
                    r0.<init>(r8)
                L18:
                    java.lang.Object r8 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r8)
                    goto L4d
                L29:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L31:
                    ir.nasim.AbstractC10685c16.b(r8)
                    ir.nasim.Gq2 r8 = r6.a
                    ir.nasim.NT4 r7 = (ir.nasim.NT4) r7
                    ir.nasim.rr1$d r2 = new ir.nasim.rr1$d
                    ir.nasim.rr1 r4 = r6.b
                    r5 = 0
                    r2.<init>(r5)
                    ir.nasim.NT4 r7 = ir.nasim.TT4.g(r7, r2)
                    r0.b = r3
                    java.lang.Object r7 = r8.a(r7, r0)
                    if (r7 != r1) goto L4d
                    return r1
                L4d:
                    ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20345rr1.h.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public h(InterfaceC4557Fq2 interfaceC4557Fq2, C20345rr1 c20345rr1) {
            this.a = interfaceC4557Fq2;
            this.b = c20345rr1;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.rr1$i */
    public static final class i implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        /* renamed from: ir.nasim.rr1$i$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.rr1$i$a$a, reason: collision with other inner class name */
            public static final class C1527a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C1527a(InterfaceC20295rm1 interfaceC20295rm1) {
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
            public final java.lang.Object a(java.lang.Object r6, ir.nasim.InterfaceC20295rm1 r7) {
                /*
                    r5 = this;
                    boolean r0 = r7 instanceof ir.nasim.C20345rr1.i.a.C1527a
                    if (r0 == 0) goto L13
                    r0 = r7
                    ir.nasim.rr1$i$a$a r0 = (ir.nasim.C20345rr1.i.a.C1527a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.rr1$i$a$a r0 = new ir.nasim.rr1$i$a$a
                    r0.<init>(r7)
                L18:
                    java.lang.Object r7 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r7)
                    goto L6a
                L29:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r7)
                    throw r6
                L31:
                    ir.nasim.AbstractC10685c16.b(r7)
                    ir.nasim.Gq2 r7 = r5.a
                    java.util.List r6 = (java.util.List) r6
                    java.lang.Iterable r6 = (java.lang.Iterable) r6
                    java.util.ArrayList r2 = new java.util.ArrayList
                    r4 = 10
                    int r4 = ir.nasim.ZW0.x(r6, r4)
                    r2.<init>(r4)
                    java.util.Iterator r6 = r6.iterator()
                L49:
                    boolean r4 = r6.hasNext()
                    if (r4 == 0) goto L61
                    java.lang.Object r4 = r6.next()
                    ir.nasim.vY r4 = (ir.nasim.C22613vY) r4
                    int r4 = r4.d()
                    java.lang.Integer r4 = ir.nasim.AbstractC6392Nk0.d(r4)
                    r2.add(r4)
                    goto L49
                L61:
                    r0.b = r3
                    java.lang.Object r6 = r7.a(r2, r0)
                    if (r6 != r1) goto L6a
                    return r1
                L6a:
                    ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20345rr1.i.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public i(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.rr1$j */
    public static final class j implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ C20345rr1 b;

        /* renamed from: ir.nasim.rr1$j$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ C20345rr1 b;

            /* renamed from: ir.nasim.rr1$j$a$a, reason: collision with other inner class name */
            public static final class C1528a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;
                Object c;
                Object e;
                Object f;
                Object g;
                Object h;
                int i;

                public C1528a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2, C20345rr1 c20345rr1) {
                this.a = interfaceC4806Gq2;
                this.b = c20345rr1;
            }

            /* JADX WARN: Removed duplicated region for block: B:19:0x0071  */
            /* JADX WARN: Removed duplicated region for block: B:25:0x009c  */
            /* JADX WARN: Removed duplicated region for block: B:26:0x00a9  */
            /* JADX WARN: Removed duplicated region for block: B:28:0x00ac  */
            /* JADX WARN: Removed duplicated region for block: B:30:0x00bc  */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0097 -> B:23:0x0098). Please report as a decompilation issue!!! */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r14, ir.nasim.InterfaceC20295rm1 r15) {
                /*
                    Method dump skipped, instructions count: 212
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20345rr1.j.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public j(InterfaceC4557Fq2 interfaceC4557Fq2, C20345rr1 c20345rr1) {
            this.a = interfaceC4557Fq2;
            this.b = c20345rr1;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.rr1$k */
    public static final class k implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        /* renamed from: ir.nasim.rr1$k$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.rr1$k$a$a, reason: collision with other inner class name */
            public static final class C1529a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C1529a(InterfaceC20295rm1 interfaceC20295rm1) {
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
            public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof ir.nasim.C20345rr1.k.a.C1529a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.rr1$k$a$a r0 = (ir.nasim.C20345rr1.k.a.C1529a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.rr1$k$a$a r0 = new ir.nasim.rr1$k$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L47
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    ir.nasim.AbstractC10685c16.b(r6)
                    ir.nasim.Gq2 r6 = r4.a
                    java.util.List r5 = (java.util.List) r5
                    java.lang.Iterable r5 = (java.lang.Iterable) r5
                    java.util.List r5 = ir.nasim.ZW0.T0(r5)
                    r0.b = r3
                    java.lang.Object r5 = r6.a(r5, r0)
                    if (r5 != r1) goto L47
                    return r1
                L47:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20345rr1.k.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public k(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    public C20345rr1(C4627Fy0 c4627Fy0, C14375ho5 c14375ho5, Context context, AbstractC13778go1 abstractC13778go1, int i2) {
        AbstractC13042fc3.i(c4627Fy0, "callRepository");
        AbstractC13042fc3.i(c14375ho5, "presenceModule");
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        this.b = c4627Fy0;
        this.c = c14375ho5;
        this.d = context;
        this.e = abstractC13778go1;
        this.f = i2;
        this.g = AbstractC12281eL6.a(AbstractC10360bX0.m());
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(new C19736qr1(null, null, 3, null));
        this.h = interfaceC9336Zm4A;
        this.i = AbstractC6459Nq2.c(interfaceC9336Zm4A);
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), abstractC13778go1, null, new a(null), 2, null);
        this.j = AbstractC12281eL6.a("");
        InterfaceC9336Zm4 interfaceC9336Zm4A2 = AbstractC12281eL6.a(AbstractC10360bX0.m());
        this.k = interfaceC9336Zm4A2;
        this.l = new j(interfaceC9336Zm4A2, this);
    }

    public final InterfaceC4557Fq2 Z0() {
        return AbstractC6459Nq2.s0(this.j, new b(null, this));
    }

    public final InterfaceC10258bL6 a1() {
        return AbstractC6459Nq2.o0(new k(this.g), AbstractC9773aX7.a(this), InterfaceC16863lz6.a.c(), AbstractC10360bX0.m());
    }

    public final InterfaceC10258bL6 b1() {
        return this.i;
    }

    public final void c1() {
        Object value;
        C19736qr1 c19736qr1;
        C19736qr1 c19736qr1B;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.h;
        do {
            value = interfaceC9336Zm4.getValue();
            c19736qr1 = (C19736qr1) value;
            AbstractC17858ng6 abstractC17858ng6C = c19736qr1.c();
            AbstractC17858ng6.a aVar = abstractC17858ng6C instanceof AbstractC17858ng6.a ? (AbstractC17858ng6.a) abstractC17858ng6C : null;
            if (aVar != null && (c19736qr1B = C19736qr1.b(c19736qr1, AbstractC17858ng6.a.b(aVar, true, false, false, 6, null), null, 2, null)) != null) {
                c19736qr1 = c19736qr1B;
            }
        } while (!interfaceC9336Zm4.f(value, c19736qr1));
    }

    public final void d1(AbstractC17858ng6 abstractC17858ng6) {
        Object value;
        AbstractC13042fc3.i(abstractC17858ng6, "searchFocusState");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.h;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, C19736qr1.b((C19736qr1) value, abstractC17858ng6, null, 2, null)));
    }

    public final void e1(C22042ua0 c22042ua0) {
        AbstractC13042fc3.i(c22042ua0, "fragment");
        C24270yK6.a aVar = C24270yK6.m1;
        Iterable iterable = (Iterable) a1().getValue();
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(iterable, 10));
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(C11458d25.r(((C22613vY) it.next()).d()));
        }
        C22042ua0.A9(c22042ua0, aVar.c(arrayList), false, null, 6, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f1(ir.nasim.C22613vY r8) {
        /*
            r7 = this;
            java.lang.String r0 = "contact"
            ir.nasim.AbstractC13042fc3.i(r8, r0)
            ir.nasim.Zm4 r0 = r7.g
        L7:
            java.lang.Object r1 = r0.getValue()
            r2 = r1
            java.util.List r2 = (java.util.List) r2
            r3 = r2
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            boolean r4 = r3 instanceof java.util.Collection
            if (r4 == 0) goto L1f
            r4 = r3
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L1f
            goto L5d
        L1f:
            java.util.Iterator r4 = r3.iterator()
        L23:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L5d
            java.lang.Object r5 = r4.next()
            ir.nasim.vY r5 = (ir.nasim.C22613vY) r5
            int r5 = r5.d()
            int r6 = r8.d()
            if (r5 != r6) goto L23
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r3 = r3.iterator()
        L42:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L77
            java.lang.Object r4 = r3.next()
            r5 = r4
            ir.nasim.vY r5 = (ir.nasim.C22613vY) r5
            int r5 = r5.d()
            int r6 = r8.d()
            if (r5 == r6) goto L42
            r2.add(r4)
            goto L42
        L5d:
            r3 = r2
            java.util.Collection r3 = (java.util.Collection) r3
            java.util.List r4 = ir.nasim.ZW0.e(r8)
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.List r3 = ir.nasim.ZW0.R0(r3, r4)
            r4 = r3
            java.util.Collection r4 = (java.util.Collection) r4
            int r4 = r4.size()
            r5 = 8
            if (r4 <= r5) goto L76
            goto L77
        L76:
            r2 = r3
        L77:
            boolean r1 = r0.f(r1, r2)
            if (r1 == 0) goto L7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20345rr1.f1(ir.nasim.vY):void");
    }

    public final void g1(String str) {
        Object value;
        AbstractC13042fc3.i(str, "query");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.j;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, str));
    }
}
