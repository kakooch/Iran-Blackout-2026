package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.pinMessages.PinMessageEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Od5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6589Od5 implements InterfaceC6334Nd5 {
    private final C6095Md5 a;
    private final InterfaceC19600qd5 b;
    private final InterfaceC5628Kd5 c;
    private final C10299bQ2 d;
    private final AbstractC13778go1 e;

    /* renamed from: ir.nasim.Od5$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C11458d25 d;
        final /* synthetic */ Long e;
        final /* synthetic */ Long f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C11458d25 c11458d25, Long l, Long l2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c11458d25;
            this.e = l;
            this.f = l2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6589Od5.this.new a(this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC19600qd5 interfaceC19600qd5 = C6589Od5.this.b;
                List listE = AbstractC9766aX0.e(new PinMessageEntity(this.d.u(), ExPeerType.PRIVATE.getValue(), this.e.longValue(), this.f.longValue(), System.currentTimeMillis()));
                this.b = 1;
                if (interfaceC19600qd5.b(listE, this) == objE) {
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

    /* renamed from: ir.nasim.Od5$b */
    static final class b extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        int d;
        /* synthetic */ Object e;
        int g;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= RecyclerView.UNDEFINED_DURATION;
            Object objM = C6589Od5.this.m(null, 0, this);
            return objM == AbstractC14862ic3.e() ? objM : C9475a16.a(objM);
        }
    }

    /* renamed from: ir.nasim.Od5$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ PinMessageEntity d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(PinMessageEntity pinMessageEntity, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = pinMessageEntity;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6589Od5.this.new c(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC19600qd5 interfaceC19600qd5 = C6589Od5.this.b;
                List listE = AbstractC9766aX0.e(this.d);
                this.b = 1;
                if (interfaceC19600qd5.e(listE, this) == objE) {
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
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Od5$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ List d;
        final /* synthetic */ PinMessageEntity e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(List list, PinMessageEntity pinMessageEntity, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = list;
            this.e = pinMessageEntity;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6589Od5.this.new d(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC19600qd5 interfaceC19600qd5 = C6589Od5.this.b;
                List listS0 = AbstractC15401jX0.S0(this.d, this.e);
                this.b = 1;
                if (interfaceC19600qd5.e(listS0, this) == objE) {
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
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Od5$e */
    public static final class e implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ C6589Od5 b;
        final /* synthetic */ C11458d25 c;

        /* renamed from: ir.nasim.Od5$e$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ C6589Od5 b;
            final /* synthetic */ C11458d25 c;

            /* renamed from: ir.nasim.Od5$e$a$a, reason: collision with other inner class name */
            public static final class C0555a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;
                Object c;

                public C0555a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2, C6589Od5 c6589Od5, C11458d25 c11458d25) {
                this.a = interfaceC4806Gq2;
                this.b = c6589Od5;
                this.c = c11458d25;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r8, ir.nasim.InterfaceC20295rm1 r9) {
                /*
                    r7 = this;
                    boolean r0 = r9 instanceof ir.nasim.C6589Od5.e.a.C0555a
                    if (r0 == 0) goto L13
                    r0 = r9
                    ir.nasim.Od5$e$a$a r0 = (ir.nasim.C6589Od5.e.a.C0555a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.Od5$e$a$a r0 = new ir.nasim.Od5$e$a$a
                    r0.<init>(r9)
                L18:
                    java.lang.Object r9 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L3c
                    if (r2 == r4) goto L34
                    if (r2 != r3) goto L2c
                    ir.nasim.AbstractC10685c16.b(r9)
                    goto L65
                L2c:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r9)
                    throw r8
                L34:
                    java.lang.Object r8 = r0.c
                    ir.nasim.Gq2 r8 = (ir.nasim.InterfaceC4806Gq2) r8
                    ir.nasim.AbstractC10685c16.b(r9)
                    goto L59
                L3c:
                    ir.nasim.AbstractC10685c16.b(r9)
                    ir.nasim.Gq2 r9 = r7.a
                    java.util.List r8 = (java.util.List) r8
                    ir.nasim.Od5 r2 = r7.b
                    ir.nasim.Kd5 r2 = ir.nasim.C6589Od5.k(r2)
                    ir.nasim.d25 r5 = r7.c
                    r0.c = r9
                    r0.b = r4
                    java.lang.Object r8 = r2.a(r5, r8, r0)
                    if (r8 != r1) goto L56
                    return r1
                L56:
                    r6 = r9
                    r9 = r8
                    r8 = r6
                L59:
                    r2 = 0
                    r0.c = r2
                    r0.b = r3
                    java.lang.Object r8 = r8.a(r9, r0)
                    if (r8 != r1) goto L65
                    return r1
                L65:
                    ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6589Od5.e.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public e(InterfaceC4557Fq2 interfaceC4557Fq2, C6589Od5 c6589Od5, C11458d25 c11458d25) {
            this.a = interfaceC4557Fq2;
            this.b = c6589Od5;
            this.c = c11458d25;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2, this.b, this.c), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Od5$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C11458d25 d;
        final /* synthetic */ int e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(C11458d25 c11458d25, int i, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c11458d25;
            this.e = i;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6589Od5.this.new f(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objM;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC19600qd5 interfaceC19600qd5 = C6589Od5.this.b;
                long jU = this.d.u();
                this.b = 1;
                obj = interfaceC19600qd5.a(jU, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    objM = ((C9475a16) obj).l();
                    C9475a16.e(objM);
                    return C19938rB7.a;
                }
                AbstractC10685c16.b(obj);
            }
            Collection collection = (Collection) obj;
            if (collection == null || collection.isEmpty()) {
                C6589Od5 c6589Od5 = C6589Od5.this;
                C11458d25 c11458d25 = this.d;
                int i2 = this.e;
                this.b = 2;
                objM = c6589Od5.m(c11458d25, i2, this);
                if (objM == objE) {
                    return objE;
                }
                C9475a16.e(objM);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Od5$g */
    static final class g extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        private /* synthetic */ Object c;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
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

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Throwable th, InterfaceC20295rm1 interfaceC20295rm1) {
            g gVar = new g(interfaceC20295rm1);
            gVar.c = interfaceC4806Gq2;
            return gVar.invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Od5$h */
    static final class h extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objA = C6589Od5.this.a(0, 0, 0L, 0L, this);
            return objA == AbstractC14862ic3.e() ? objA : C9475a16.a(objA);
        }
    }

    /* renamed from: ir.nasim.Od5$i */
    static final class i extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        int e;
        /* synthetic */ Object f;
        int h;

        i(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.f = obj;
            this.h |= RecyclerView.UNDEFINED_DURATION;
            Object objH = C6589Od5.this.h(null, null, null, 0, false, this);
            return objH == AbstractC14862ic3.e() ? objH : C9475a16.a(objH);
        }
    }

    /* renamed from: ir.nasim.Od5$j */
    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C11458d25 d;
        final /* synthetic */ int e;
        final /* synthetic */ Long f;
        final /* synthetic */ Long g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(C11458d25 c11458d25, int i, Long l, Long l2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c11458d25;
            this.e = i;
            this.f = l;
            this.g = l2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6589Od5.this.new j(this.d, this.e, this.f, this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC19600qd5 interfaceC19600qd5 = C6589Od5.this.b;
                List listE = AbstractC9766aX0.e(new PinMessageEntity(this.d.u(), this.e, this.f.longValue(), this.g.longValue(), 0L, 16, null));
                this.b = 1;
                if (interfaceC19600qd5.e(listE, this) == objE) {
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
            return ((j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Od5$k */
    static final class k extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        k(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objC = C6589Od5.this.c(0, this);
            return objC == AbstractC14862ic3.e() ? objC : C9475a16.a(objC);
        }
    }

    /* renamed from: ir.nasim.Od5$l */
    static final class l extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        l(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objI = C6589Od5.this.i(0, 0L, 0L, this);
            return objI == AbstractC14862ic3.e() ? objI : C9475a16.a(objI);
        }
    }

    /* renamed from: ir.nasim.Od5$m */
    static final class m extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        m(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            Object objB = C6589Od5.this.b(null, null, false, this);
            return objB == AbstractC14862ic3.e() ? objB : C9475a16.a(objB);
        }
    }

    /* renamed from: ir.nasim.Od5$n */
    static final class n extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C11458d25 d;
        final /* synthetic */ List e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        n(C11458d25 c11458d25, List list, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c11458d25;
            this.e = list;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6589Od5.this.new n(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC19600qd5 interfaceC19600qd5 = C6589Od5.this.b;
                long jU = this.d.u();
                List list = this.e;
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(AbstractC6392Nk0.e(((J44) it.next()).i()));
                }
                List list2 = this.e;
                ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(list2, 10));
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(AbstractC6392Nk0.e(((J44) it2.next()).h()));
                }
                this.b = 1;
                if (interfaceC19600qd5.f(jU, arrayList, arrayList2, this) == objE) {
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
            return ((n) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Od5$o */
    static final class o extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C11458d25 d;
        final /* synthetic */ Long e;
        final /* synthetic */ Long f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        o(C11458d25 c11458d25, Long l, Long l2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c11458d25;
            this.e = l;
            this.f = l2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6589Od5.this.new o(this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC19600qd5 interfaceC19600qd5 = C6589Od5.this.b;
                List listE = AbstractC9766aX0.e(new PinMessageEntity(this.d.u(), ExPeerType.PRIVATE.getValue(), this.e.longValue(), this.f.longValue(), 0L, 16, null));
                this.b = 1;
                if (interfaceC19600qd5.e(listE, this) == objE) {
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
            return ((o) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Od5$p */
    static final class p extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ boolean c;
        final /* synthetic */ C6589Od5 d;
        final /* synthetic */ C11458d25 e;
        final /* synthetic */ List f;
        final /* synthetic */ List g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        p(boolean z, C6589Od5 c6589Od5, C11458d25 c11458d25, List list, List list2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = z;
            this.d = c6589Od5;
            this.e = c11458d25;
            this.f = list;
            this.g = list2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new p(this.c, this.d, this.e, this.f, this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                if (this.c) {
                    InterfaceC19600qd5 interfaceC19600qd5 = this.d.b;
                    long jU = this.e.u();
                    this.b = 1;
                    if (interfaceC19600qd5.d(jU, this) == objE) {
                        return objE;
                    }
                } else {
                    InterfaceC19600qd5 interfaceC19600qd52 = this.d.b;
                    long jU2 = this.e.u();
                    List list = this.f;
                    List list2 = this.g;
                    this.b = 2;
                    if (interfaceC19600qd52.f(jU2, list, list2, this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i != 1 && i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((p) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C6589Od5(C6095Md5 c6095Md5, InterfaceC19600qd5 interfaceC19600qd5, InterfaceC5628Kd5 interfaceC5628Kd5, C10299bQ2 c10299bQ2, AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(c6095Md5, "remoteDataSource");
        AbstractC13042fc3.i(interfaceC19600qd5, "dao");
        AbstractC13042fc3.i(interfaceC5628Kd5, "mapper");
        AbstractC13042fc3.i(c10299bQ2, "groupsModule");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        this.a = c6095Md5;
        this.b = interfaceC19600qd5;
        this.c = interfaceC5628Kd5;
        this.d = c10299bQ2;
        this.e = abstractC13778go1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m(ir.nasim.C11458d25 r28, int r29, ir.nasim.InterfaceC20295rm1 r30) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6589Od5.m(ir.nasim.d25, int, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    @Override // ir.nasim.InterfaceC6334Nd5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(int r14, int r15, long r16, long r18, ir.nasim.InterfaceC20295rm1 r20) {
        /*
            r13 = this;
            r0 = r13
            r1 = r20
            boolean r2 = r1 instanceof ir.nasim.C6589Od5.h
            if (r2 == 0) goto L16
            r2 = r1
            ir.nasim.Od5$h r2 = (ir.nasim.C6589Od5.h) r2
            int r3 = r2.c
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L16
            int r3 = r3 - r4
            r2.c = r3
            goto L1b
        L16:
            ir.nasim.Od5$h r2 = new ir.nasim.Od5$h
            r2.<init>(r1)
        L1b:
            java.lang.Object r1 = r2.a
            java.lang.Object r3 = ir.nasim.AbstractC13660gc3.e()
            int r4 = r2.c
            r5 = 1
            if (r4 == 0) goto L3a
            if (r4 != r5) goto L32
            ir.nasim.AbstractC10685c16.b(r1)
            ir.nasim.a16 r1 = (ir.nasim.C9475a16) r1
            java.lang.Object r1 = r1.l()
            goto L56
        L32:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L3a:
            ir.nasim.AbstractC10685c16.b(r1)
            ir.nasim.bQ2 r6 = r0.d
            int r8 = ir.nasim.AbstractC5969Lp4.f()
            r7 = r14
            r9 = r16
            r11 = r18
            ir.nasim.Nv5 r1 = r6.O2(r7, r8, r9, r11)
            r2.c = r5
            r4 = 0
            java.lang.Object r1 = ir.nasim.AbstractC6756Ov5.d(r1, r4, r2, r5, r4)
            if (r1 != r3) goto L56
            return r3
        L56:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6589Od5.a(int, int, long, long, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC6334Nd5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(java.util.List r8, ir.nasim.C11458d25 r9, boolean r10, ir.nasim.InterfaceC20295rm1 r11) {
        /*
            r7 = this;
            boolean r0 = r11 instanceof ir.nasim.C6589Od5.m
            if (r0 == 0) goto L13
            r0 = r11
            ir.nasim.Od5$m r0 = (ir.nasim.C6589Od5.m) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            ir.nasim.Od5$m r0 = new ir.nasim.Od5$m
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.d
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L53
            if (r2 == r4) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r8 = r0.a
            ir.nasim.AbstractC10685c16.b(r11)
            goto L9a
        L2f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L37:
            java.lang.Object r8 = r0.c
            r9 = r8
            ir.nasim.d25 r9 = (ir.nasim.C11458d25) r9
            java.lang.Object r8 = r0.b
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r10 = r0.a
            ir.nasim.Od5 r10 = (ir.nasim.C6589Od5) r10
            ir.nasim.AbstractC10685c16.b(r11)
            ir.nasim.a16 r11 = (ir.nasim.C9475a16) r11
            java.lang.Object r11 = r11.l()
            r6 = r9
            r9 = r8
            r8 = r11
            r11 = r10
        L51:
            r10 = r6
            goto L7a
        L53:
            ir.nasim.AbstractC10685c16.b(r11)
            if (r9 == 0) goto L9e
            r11 = r8
            java.util.Collection r11 = (java.util.Collection) r11
            if (r11 == 0) goto L9e
            boolean r11 = r11.isEmpty()
            if (r11 == 0) goto L64
            goto L9e
        L64:
            ir.nasim.Md5 r11 = r7.a
            r0.a = r7
            r0.b = r8
            r0.c = r9
            r0.f = r4
            java.lang.Object r10 = r11.e(r8, r9, r10, r0)
            if (r10 != r1) goto L75
            return r1
        L75:
            r11 = r7
            r6 = r9
            r9 = r8
            r8 = r10
            goto L51
        L7a:
            boolean r2 = ir.nasim.C9475a16.j(r8)
            if (r2 == 0) goto L9a
            r2 = r8
            ir.nasim.rB7 r2 = (ir.nasim.C19938rB7) r2
            ir.nasim.go1 r2 = r11.e
            ir.nasim.Od5$n r4 = new ir.nasim.Od5$n
            r5 = 0
            r4.<init>(r10, r9, r5)
            r0.a = r8
            r0.b = r5
            r0.c = r5
            r0.f = r3
            java.lang.Object r9 = ir.nasim.AbstractC9323Zl0.g(r2, r4, r0)
            if (r9 != r1) goto L9a
            return r1
        L9a:
            ir.nasim.C9475a16.e(r8)
            return r8
        L9e:
            ir.nasim.a16$a r8 = ir.nasim.C9475a16.b
            java.lang.Exception r8 = new java.lang.Exception
            java.lang.String r9 = "error in unpinPrivateMessage"
            r8.<init>(r9)
            java.lang.Object r8 = ir.nasim.AbstractC10685c16.a(r8)
            java.lang.Object r8 = ir.nasim.C9475a16.b(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6589Od5.b(java.util.List, ir.nasim.d25, boolean, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC6334Nd5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object c(int r5, ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ir.nasim.C6589Od5.k
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.Od5$k r0 = (ir.nasim.C6589Od5.k) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.Od5$k r0 = new ir.nasim.Od5$k
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.a16 r6 = (ir.nasim.C9475a16) r6
            java.lang.Object r5 = r6.l()
            goto L4a
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.bQ2 r6 = r4.d
            ir.nasim.Nv5 r5 = r6.U2(r5)
            r0.c = r3
            r6 = 0
            java.lang.Object r5 = ir.nasim.AbstractC6756Ov5.d(r5, r6, r0, r3, r6)
            if (r5 != r1) goto L4a
            return r1
        L4a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6589Od5.c(int, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.InterfaceC6334Nd5
    public Object d(C11458d25 c11458d25, List list, List list2, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
        List list3;
        List list4;
        if (c11458d25 == null || (list3 = list) == null || list3.isEmpty() || (list4 = list2) == null || list4.isEmpty()) {
            return C19938rB7.a;
        }
        Object objG = AbstractC9323Zl0.g(this.e, new p(z, this, c11458d25, list, list2, null), interfaceC20295rm1);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC6334Nd5
    public InterfaceC4557Fq2 e(C11458d25 c11458d25, int i2) {
        AbstractC13042fc3.i(c11458d25, "peer");
        return AbstractC6459Nq2.V(AbstractC6459Nq2.h(new e(AbstractC6459Nq2.c0(this.b.c(c11458d25.u()), new f(c11458d25, i2, null)), this, c11458d25), new g(null)), this.e);
    }

    @Override // ir.nasim.InterfaceC6334Nd5
    public Object f(Long l2, Long l3, C11458d25 c11458d25, InterfaceC20295rm1 interfaceC20295rm1) {
        if (c11458d25 == null || l2 == null || l3 == null) {
            return C19938rB7.a;
        }
        Object objG = AbstractC9323Zl0.g(this.e, new o(c11458d25, l2, l3, null), interfaceC20295rm1);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC6334Nd5
    public Object g(Long l2, Long l3, C11458d25 c11458d25, InterfaceC20295rm1 interfaceC20295rm1) {
        if (c11458d25 == null || l2 == null || l3 == null) {
            return C19938rB7.a;
        }
        Object objG = AbstractC9323Zl0.g(this.e, new a(c11458d25, l2, l3, null), interfaceC20295rm1);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    @Override // ir.nasim.InterfaceC6334Nd5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object h(java.lang.Long r17, java.lang.Long r18, ir.nasim.C11458d25 r19, int r20, boolean r21, ir.nasim.InterfaceC20295rm1 r22) {
        /*
            Method dump skipped, instructions count: 213
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6589Od5.h(java.lang.Long, java.lang.Long, ir.nasim.d25, int, boolean, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    @Override // ir.nasim.InterfaceC6334Nd5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object i(int r13, long r14, long r16, ir.nasim.InterfaceC20295rm1 r18) {
        /*
            r12 = this;
            r0 = r12
            r1 = r18
            boolean r2 = r1 instanceof ir.nasim.C6589Od5.l
            if (r2 == 0) goto L16
            r2 = r1
            ir.nasim.Od5$l r2 = (ir.nasim.C6589Od5.l) r2
            int r3 = r2.c
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L16
            int r3 = r3 - r4
            r2.c = r3
            goto L1b
        L16:
            ir.nasim.Od5$l r2 = new ir.nasim.Od5$l
            r2.<init>(r1)
        L1b:
            java.lang.Object r1 = r2.a
            java.lang.Object r3 = ir.nasim.AbstractC13660gc3.e()
            int r4 = r2.c
            r5 = 1
            if (r4 == 0) goto L3a
            if (r4 != r5) goto L32
            ir.nasim.AbstractC10685c16.b(r1)
            ir.nasim.a16 r1 = (ir.nasim.C9475a16) r1
            java.lang.Object r1 = r1.l()
            goto L51
        L32:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L3a:
            ir.nasim.AbstractC10685c16.b(r1)
            ir.nasim.bQ2 r6 = r0.d
            r7 = r13
            r8 = r14
            r10 = r16
            ir.nasim.Nv5 r1 = r6.X2(r7, r8, r10)
            r2.c = r5
            r4 = 0
            java.lang.Object r1 = ir.nasim.AbstractC6756Ov5.d(r1, r4, r2, r5, r4)
            if (r1 != r3) goto L51
            return r3
        L51:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6589Od5.i(int, long, long, ir.nasim.rm1):java.lang.Object");
    }
}
