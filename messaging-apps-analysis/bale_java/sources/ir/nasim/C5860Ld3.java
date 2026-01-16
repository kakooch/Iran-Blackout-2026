package ir.nasim;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC22884vz0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Ld3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5860Ld3 extends VW7 {
    public static final int m = 8;
    private final C4627Fy0 b;
    private final C14375ho5 c;
    private final Context d;
    private final C19017pe3 e;
    private final AbstractC13778go1 f;
    private InterfaceC9336Zm4 g;
    private final InterfaceC9336Zm4 h;
    private final InterfaceC10258bL6 i;
    private InterfaceC9336Zm4 j;
    private final InterfaceC9336Zm4 k;
    private final InterfaceC4557Fq2 l;

    /* renamed from: ir.nasim.Ld3$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.Ld3$a$a, reason: collision with other inner class name */
        static final class C0478a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C5860Ld3 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0478a(C5860Ld3 c5860Ld3, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c5860Ld3;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                C0478a c0478a = new C0478a(this.d, interfaceC20295rm1);
                c0478a.c = obj;
                return c0478a;
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
                } while (!interfaceC9336Zm4.f(value, C5626Kd3.b((C5626Kd3) value, str, null, false, false, 14, null)));
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(String str, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C0478a) create(str, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C5860Ld3.this.new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm4 = C5860Ld3.this.j;
                C0478a c0478a = new C0478a(C5860Ld3.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC9336Zm4, c0478a, this) == objE) {
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

    /* renamed from: ir.nasim.Ld3$b */
    public static final class b extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        private /* synthetic */ Object c;
        /* synthetic */ Object d;
        final /* synthetic */ C5860Ld3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(InterfaceC20295rm1 interfaceC20295rm1, C5860Ld3 c5860Ld3) {
            super(3, interfaceC20295rm1);
            this.e = c5860Ld3;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                InterfaceC4557Fq2 interfaceC4557Fq2S = AbstractC6459Nq2.S(AbstractC9395Zt0.a(new m(this.e.b.s0(AbstractC9773aX7.a(this.e), (String) this.d), this.e), AbstractC9773aX7.a(this.e)), new n(this.e.g), new e(null));
                C4627Fy0 unused = this.e.b;
                C18039nz0 c18039nz0 = C18039nz0.a;
                InterfaceC4557Fq2 interfaceC4557Fq2S2 = AbstractC6459Nq2.S(interfaceC4557Fq2S, AbstractC6459Nq2.s0(AbstractC6459Nq2.s0(new i(c18039nz0.d()), new j(null)), new k(null)), new g(null));
                C4627Fy0 unused2 = this.e.b;
                InterfaceC4557Fq2 interfaceC4557Fq2V = AbstractC6459Nq2.V(AbstractC6459Nq2.S(AbstractC6459Nq2.S(interfaceC4557Fq2S2, AbstractC6459Nq2.s0(c18039nz0.d(), new l(null)), new h(null)), this.e.l, new d(null)), C12366eV1.b());
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

    /* renamed from: ir.nasim.Ld3$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            c cVar = C5860Ld3.this.new c(interfaceC20295rm1);
            cVar.c = obj;
            return cVar;
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
            List listP1 = AbstractC15401jX0.p1((Collection) C5860Ld3.this.k.getValue());
            listP1.add(AbstractC6392Nk0.d(c22613vY.d()));
            InterfaceC9336Zm4 interfaceC9336Zm4 = C5860Ld3.this.k;
            do {
                value = interfaceC9336Zm4.getValue();
            } while (!interfaceC9336Zm4.f(value, listP1));
            return c22613vY;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(C22613vY c22613vY, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(c22613vY, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ld3$d */
    static final class d extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        /* synthetic */ Object c;
        /* synthetic */ Object d;

        /* renamed from: ir.nasim.Ld3$d$a */
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

        d(InterfaceC20295rm1 interfaceC20295rm1) {
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
            d dVar = new d(interfaceC20295rm1);
            dVar.c = nt4;
            dVar.d = list;
            return dVar.invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ld3$e */
    static final class e extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        /* synthetic */ Object c;
        /* synthetic */ Object d;

        /* renamed from: ir.nasim.Ld3$e$a */
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

    /* renamed from: ir.nasim.Ld3$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            f fVar = new f(interfaceC20295rm1);
            fVar.c = obj;
            return fVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                List listM = AbstractC10360bX0.m();
                this.b = 1;
                if (interfaceC4806Gq2.a(listM, this) == objE) {
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
        public final Object invoke(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ld3$g */
    static final class g extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        /* synthetic */ Object c;
        /* synthetic */ Object d;

        /* renamed from: ir.nasim.Ld3$g$a */
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
                return AbstractC6392Nk0.a((this.d.contains(String.valueOf(c22613vY.d())) || c22613vY.d() == AbstractC5969Lp4.f()) ? false : true);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C22613vY c22613vY, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(c22613vY, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return UT4.a((NT4) this.c, new a((List) this.d, null));
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(NT4 nt4, List list, InterfaceC20295rm1 interfaceC20295rm1) {
            g gVar = new g(interfaceC20295rm1);
            gVar.c = nt4;
            gVar.d = list;
            return gVar.invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ld3$h */
    static final class h extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        /* synthetic */ Object c;
        /* synthetic */ Object d;

        /* renamed from: ir.nasim.Ld3$h$a */
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
                return AbstractC6392Nk0.a(!this.d.contains(String.valueOf(((C22613vY) this.c).d())));
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C22613vY c22613vY, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(c22613vY, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return UT4.a((NT4) this.c, new a((List) this.d, null));
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(NT4 nt4, List list, InterfaceC20295rm1 interfaceC20295rm1) {
            h hVar = new h(interfaceC20295rm1);
            hVar.c = nt4;
            hVar.d = list;
            return hVar.invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ld3$i */
    public static final class i implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        /* renamed from: ir.nasim.Ld3$i$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.Ld3$i$a$a, reason: collision with other inner class name */
            public static final class C0479a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0479a(InterfaceC20295rm1 interfaceC20295rm1) {
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
                    boolean r0 = r6 instanceof ir.nasim.C5860Ld3.i.a.C0479a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.Ld3$i$a$a r0 = (ir.nasim.C5860Ld3.i.a.C0479a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.Ld3$i$a$a r0 = new ir.nasim.Ld3$i$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L48
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    ir.nasim.AbstractC10685c16.b(r6)
                    ir.nasim.Gq2 r6 = r4.a
                    r2 = r5
                    ir.nasim.mz0 r2 = (ir.nasim.C17448mz0) r2
                    ir.nasim.Fq2 r2 = r2.k()
                    if (r2 == 0) goto L48
                    r0.b = r3
                    java.lang.Object r5 = r6.a(r5, r0)
                    if (r5 != r1) goto L48
                    return r1
                L48:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C5860Ld3.i.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
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

    /* renamed from: ir.nasim.Ld3$j */
    public static final class j extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        private /* synthetic */ Object c;
        /* synthetic */ Object d;

        public j(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                InterfaceC4557Fq2 interfaceC4557Fq2K = ((C17448mz0) this.d).k();
                AbstractC13042fc3.f(interfaceC4557Fq2K);
                this.b = 1;
                if (AbstractC6459Nq2.A(interfaceC4806Gq2, interfaceC4557Fq2K, this) == objE) {
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
            j jVar = new j(interfaceC20295rm1);
            jVar.c = interfaceC4806Gq2;
            jVar.d = obj;
            return jVar.invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ld3$k */
    public static final class k extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        private /* synthetic */ Object c;
        /* synthetic */ Object d;

        public k(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                List list = (List) this.d;
                InterfaceC4557Fq2 interfaceC4557Fq2R = list.isEmpty() ? AbstractC6459Nq2.R(new f(null)) : new o((InterfaceC4557Fq2[]) AbstractC15401jX0.m1(list).toArray(new InterfaceC4557Fq2[0]));
                this.b = 1;
                if (AbstractC6459Nq2.A(interfaceC4806Gq2, interfaceC4557Fq2R, this) == objE) {
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
            k kVar = new k(interfaceC20295rm1);
            kVar.c = interfaceC4806Gq2;
            kVar.d = obj;
            return kVar.invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ld3$l */
    public static final class l extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        private /* synthetic */ Object c;
        /* synthetic */ Object d;

        public l(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                p pVar = new p(((C17448mz0) this.d).g());
                this.b = 1;
                if (AbstractC6459Nq2.A(interfaceC4806Gq2, pVar, this) == objE) {
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
            l lVar = new l(interfaceC20295rm1);
            lVar.c = interfaceC4806Gq2;
            lVar.d = obj;
            return lVar.invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ld3$m */
    public static final class m implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ C5860Ld3 b;

        /* renamed from: ir.nasim.Ld3$m$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ C5860Ld3 b;

            /* renamed from: ir.nasim.Ld3$m$a$a, reason: collision with other inner class name */
            public static final class C0480a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0480a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2, C5860Ld3 c5860Ld3) {
                this.a = interfaceC4806Gq2;
                this.b = c5860Ld3;
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
                    boolean r0 = r8 instanceof ir.nasim.C5860Ld3.m.a.C0480a
                    if (r0 == 0) goto L13
                    r0 = r8
                    ir.nasim.Ld3$m$a$a r0 = (ir.nasim.C5860Ld3.m.a.C0480a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.Ld3$m$a$a r0 = new ir.nasim.Ld3$m$a$a
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
                    ir.nasim.Ld3$c r2 = new ir.nasim.Ld3$c
                    ir.nasim.Ld3 r4 = r6.b
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
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C5860Ld3.m.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public m(InterfaceC4557Fq2 interfaceC4557Fq2, C5860Ld3 c5860Ld3) {
            this.a = interfaceC4557Fq2;
            this.b = c5860Ld3;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Ld3$n */
    public static final class n implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        /* renamed from: ir.nasim.Ld3$n$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.Ld3$n$a$a, reason: collision with other inner class name */
            public static final class C0481a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0481a(InterfaceC20295rm1 interfaceC20295rm1) {
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
                    boolean r0 = r7 instanceof ir.nasim.C5860Ld3.n.a.C0481a
                    if (r0 == 0) goto L13
                    r0 = r7
                    ir.nasim.Ld3$n$a$a r0 = (ir.nasim.C5860Ld3.n.a.C0481a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.Ld3$n$a$a r0 = new ir.nasim.Ld3$n$a$a
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
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C5860Ld3.n.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public n(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Ld3$o */
    public static final class o implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2[] a;

        /* renamed from: ir.nasim.Ld3$o$a */
        static final class a extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ InterfaceC4557Fq2[] e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(InterfaceC4557Fq2[] interfaceC4557Fq2Arr) {
                super(0);
                this.e = interfaceC4557Fq2Arr;
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object[] invoke() {
                return new M26[this.e.length];
            }
        }

        /* renamed from: ir.nasim.Ld3$o$b */
        public static final class b extends AbstractC19859r37 implements InterfaceC15796kB2 {
            int b;
            private /* synthetic */ Object c;
            /* synthetic */ Object d;

            public b(InterfaceC20295rm1 interfaceC20295rm1) {
                super(3, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                    M26[] m26Arr = (M26[]) ((Object[]) this.d);
                    ArrayList arrayList = new ArrayList(m26Arr.length);
                    for (M26 m26 : m26Arr) {
                        arrayList.add(m26.j());
                    }
                    this.b = 1;
                    if (interfaceC4806Gq2.a(arrayList, this) == objE) {
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
            public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Object[] objArr, InterfaceC20295rm1 interfaceC20295rm1) {
                b bVar = new b(interfaceC20295rm1);
                bVar.c = interfaceC4806Gq2;
                bVar.d = objArr;
                return bVar.invokeSuspend(C19938rB7.a);
            }
        }

        public o(InterfaceC4557Fq2[] interfaceC4557Fq2Arr) {
            this.a = interfaceC4557Fq2Arr;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            InterfaceC4557Fq2[] interfaceC4557Fq2Arr = this.a;
            Object objA = AbstractC10404bZ0.a(interfaceC4806Gq2, interfaceC4557Fq2Arr, new a(interfaceC4557Fq2Arr), new b(null), interfaceC20295rm1);
            return objA == AbstractC14862ic3.e() ? objA : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Ld3$p */
    public static final class p implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        /* renamed from: ir.nasim.Ld3$p$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.Ld3$p$a$a, reason: collision with other inner class name */
            public static final class C0482a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0482a(InterfaceC20295rm1 interfaceC20295rm1) {
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
                    boolean r0 = r7 instanceof ir.nasim.C5860Ld3.p.a.C0482a
                    if (r0 == 0) goto L13
                    r0 = r7
                    ir.nasim.Ld3$p$a$a r0 = (ir.nasim.C5860Ld3.p.a.C0482a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.Ld3$p$a$a r0 = new ir.nasim.Ld3$p$a$a
                    r0.<init>(r7)
                L18:
                    java.lang.Object r7 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r7)
                    goto L66
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
                    if (r4 == 0) goto L5d
                    java.lang.Object r4 = r6.next()
                    ir.nasim.M26 r4 = (ir.nasim.M26) r4
                    java.lang.String r4 = r4.j()
                    r2.add(r4)
                    goto L49
                L5d:
                    r0.b = r3
                    java.lang.Object r6 = r7.a(r2, r0)
                    if (r6 != r1) goto L66
                    return r1
                L66:
                    ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C5860Ld3.p.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public p(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Ld3$q */
    static final class q extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;

        q(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C5860Ld3.this.new q(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            C5860Ld3 c5860Ld3;
            Object objL;
            Object value;
            Object value2;
            Object value3;
            String strC;
            Object value4;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                Iterable iterable = (Iterable) C5860Ld3.this.g.getValue();
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(iterable, 10));
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    arrayList.add(new C11458d25(W25.a, ((C22613vY) it.next()).d()));
                }
                C5860Ld3 c5860Ld32 = C5860Ld3.this;
                C19017pe3 c19017pe3 = c5860Ld32.e;
                long jC = ((C17448mz0) C18039nz0.a.d().getValue()).c();
                this.b = c5860Ld32;
                this.c = 1;
                Object objA = c19017pe3.a(jC, arrayList, this);
                if (objA == objE) {
                    return objE;
                }
                c5860Ld3 = c5860Ld32;
                objL = objA;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                c5860Ld3 = (C5860Ld3) this.b;
                AbstractC10685c16.b(obj);
                objL = ((C9475a16) obj).l();
            }
            if (C9475a16.g(objL)) {
                C4627Fy0 unused = c5860Ld3.b;
                C8942Xx0 c8942Xx0D = ((C17448mz0) C18039nz0.a.d().getValue()).d();
                if (c8942Xx0D != null && (strC = c8942Xx0D.c()) != null) {
                    InterfaceC9336Zm4 interfaceC9336Zm4 = c5860Ld3.h;
                    do {
                        value4 = interfaceC9336Zm4.getValue();
                    } while (!interfaceC9336Zm4.f(value4, C5626Kd3.b((C5626Kd3) value4, null, new AbstractC22884vz0.a.C1733a(strC), false, false, 13, null)));
                }
            }
            InterfaceC9336Zm4 interfaceC9336Zm42 = c5860Ld3.j;
            do {
                value = interfaceC9336Zm42.getValue();
            } while (!interfaceC9336Zm42.f(value, ""));
            InterfaceC9336Zm4 interfaceC9336Zm43 = c5860Ld3.g;
            do {
                value2 = interfaceC9336Zm43.getValue();
            } while (!interfaceC9336Zm43.f(value2, AbstractC10360bX0.m()));
            if (C9475a16.j(objL)) {
                InterfaceC9336Zm4 interfaceC9336Zm44 = c5860Ld3.h;
                do {
                    value3 = interfaceC9336Zm44.getValue();
                } while (!interfaceC9336Zm44.f(value3, C5626Kd3.b((C5626Kd3) value3, null, null, false, true, 7, null)));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((q) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ld3$r */
    public static final class r implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ C5860Ld3 b;

        /* renamed from: ir.nasim.Ld3$r$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ C5860Ld3 b;

            /* renamed from: ir.nasim.Ld3$r$a$a, reason: collision with other inner class name */
            public static final class C0483a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;
                Object c;
                Object e;
                Object f;
                Object g;
                Object h;
                int i;

                public C0483a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2, C5860Ld3 c5860Ld3) {
                this.a = interfaceC4806Gq2;
                this.b = c5860Ld3;
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
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C5860Ld3.r.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public r(InterfaceC4557Fq2 interfaceC4557Fq2, C5860Ld3 c5860Ld3) {
            this.a = interfaceC4557Fq2;
            this.b = c5860Ld3;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Ld3$s */
    public static final class s implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        /* renamed from: ir.nasim.Ld3$s$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.Ld3$s$a$a, reason: collision with other inner class name */
            public static final class C0484a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0484a(InterfaceC20295rm1 interfaceC20295rm1) {
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
                    boolean r0 = r6 instanceof ir.nasim.C5860Ld3.s.a.C0484a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.Ld3$s$a$a r0 = (ir.nasim.C5860Ld3.s.a.C0484a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.Ld3$s$a$a r0 = new ir.nasim.Ld3$s$a$a
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
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C5860Ld3.s.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public s(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    public C5860Ld3(C4627Fy0 c4627Fy0, C14375ho5 c14375ho5, Context context, C19017pe3 c19017pe3, AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(c4627Fy0, "callRepository");
        AbstractC13042fc3.i(c14375ho5, "presenceModule");
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(c19017pe3, "inviteToCallUserCase");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        this.b = c4627Fy0;
        this.c = c14375ho5;
        this.d = context;
        this.e = c19017pe3;
        this.f = abstractC13778go1;
        this.g = AbstractC12281eL6.a(AbstractC10360bX0.m());
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(new C5626Kd3(null, null, false, false, 15, null));
        this.h = interfaceC9336Zm4A;
        this.i = AbstractC6459Nq2.c(interfaceC9336Zm4A);
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), abstractC13778go1, null, new a(null), 2, null);
        this.j = AbstractC12281eL6.a("");
        InterfaceC9336Zm4 interfaceC9336Zm4A2 = AbstractC12281eL6.a(AbstractC10360bX0.m());
        this.k = interfaceC9336Zm4A2;
        this.l = new r(interfaceC9336Zm4A2, this);
    }

    public final InterfaceC4557Fq2 Z0() {
        return AbstractC6459Nq2.s0(this.j, new b(null, this));
    }

    public final InterfaceC10258bL6 a1() {
        return this.i;
    }

    public final InterfaceC10258bL6 b1() {
        return AbstractC6459Nq2.o0(new s(this.g), AbstractC9773aX7.a(this), InterfaceC16863lz6.a.c(), AbstractC10360bX0.m());
    }

    public final InterfaceC13730gj3 c1() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new q(null), 2, null);
    }

    public final void d1(C22613vY c22613vY) {
        Object value;
        ArrayList arrayList;
        Object value2;
        AbstractC13042fc3.i(c22613vY, "contact");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.g;
        do {
            value = interfaceC9336Zm4.getValue();
            arrayList = new ArrayList();
            for (Object obj : (List) value) {
                if (((C22613vY) obj).d() != c22613vY.d()) {
                    arrayList.add(obj);
                }
            }
        } while (!interfaceC9336Zm4.f(value, arrayList));
        InterfaceC9336Zm4 interfaceC9336Zm42 = this.h;
        do {
            value2 = interfaceC9336Zm42.getValue();
        } while (!interfaceC9336Zm42.f(value2, C5626Kd3.b((C5626Kd3) value2, null, null, !arrayList.isEmpty(), false, 11, null)));
    }

    public final void e1() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.h;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, C5626Kd3.b((C5626Kd3) value, null, null, false, false, 13, null)));
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f1(ir.nasim.C22613vY r13) {
        /*
            r12 = this;
            java.lang.String r0 = "contact"
            ir.nasim.AbstractC13042fc3.i(r13, r0)
            ir.nasim.Zm4 r0 = r12.g
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
            int r6 = r13.d()
            if (r5 != r6) goto L23
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r3 = r3.iterator()
        L42:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L92
            java.lang.Object r4 = r3.next()
            r5 = r4
            ir.nasim.vY r5 = (ir.nasim.C22613vY) r5
            int r5 = r5.d()
            int r6 = r13.d()
            if (r5 == r6) goto L42
            r2.add(r4)
            goto L42
        L5d:
            r3 = r2
            java.util.Collection r3 = (java.util.Collection) r3
            java.util.List r4 = ir.nasim.ZW0.e(r13)
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.List r3 = ir.nasim.ZW0.R0(r3, r4)
            r4 = r3
            java.util.Collection r4 = (java.util.Collection) r4
            int r4 = r4.size()
            r5 = 8
            if (r4 <= r5) goto L91
            ir.nasim.Zm4 r4 = r12.h
        L77:
            java.lang.Object r3 = r4.getValue()
            r5 = r3
            ir.nasim.Kd3 r5 = (ir.nasim.C5626Kd3) r5
            ir.nasim.vz0$a$d r7 = ir.nasim.AbstractC22884vz0.a.d.b
            r10 = 13
            r11 = 0
            r6 = 0
            r8 = 0
            r9 = 0
            ir.nasim.Kd3 r5 = ir.nasim.C5626Kd3.b(r5, r6, r7, r8, r9, r10, r11)
            boolean r3 = r4.f(r3, r5)
            if (r3 == 0) goto L77
            goto L92
        L91:
            r2 = r3
        L92:
            boolean r1 = r0.f(r1, r2)
            if (r1 == 0) goto L7
            ir.nasim.Zm4 r1 = r12.h
        L9a:
            java.lang.Object r13 = r1.getValue()
            r3 = r13
            ir.nasim.Kd3 r3 = (ir.nasim.C5626Kd3) r3
            r0 = r2
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r6 = r0 ^ 1
            r8 = 11
            r9 = 0
            r4 = 0
            r5 = 0
            r7 = 0
            ir.nasim.Kd3 r0 = ir.nasim.C5626Kd3.b(r3, r4, r5, r6, r7, r8, r9)
            boolean r13 = r1.f(r13, r0)
            if (r13 == 0) goto L9a
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C5860Ld3.f1(ir.nasim.vY):void");
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
