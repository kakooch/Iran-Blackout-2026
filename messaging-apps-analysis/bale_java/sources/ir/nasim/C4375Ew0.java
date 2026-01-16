package ir.nasim;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.InterfaceC16239kw0;
import ir.nasim.InterfaceC19416qJ4;
import ir.nasim.InterfaceC22261uw0;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Ew0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C4375Ew0 extends VW7 {
    private final C21671tw0 b;
    private final C4627Fy0 c;
    private final Context d;
    private final AbstractC13778go1 e;
    private final C10299bQ2 f;
    private final OK7 g;
    private final C4978Hj3 h;
    private final InterfaceC20468s37 i;
    private final InterfaceC20468s37 j;
    private final C15732k47 k;
    private final C8054Ui1 l;
    private final C6409Nm m;
    private final InterfaceC9336Zm4 n;
    private final InterfaceC10258bL6 o;
    private final InterfaceC8327Vm4 p;
    private final InterfaceC10040ay6 q;
    private final InterfaceC9336Zm4 r;
    private final InterfaceC9336Zm4 s;
    private final InterfaceC9336Zm4 t;

    /* renamed from: ir.nasim.Ew0$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C4375Ew0.this.new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C4375Ew0 c4375Ew0 = C4375Ew0.this;
                this.b = 1;
                if (c4375Ew0.s1(this) == objE) {
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

    /* renamed from: ir.nasim.Ew0$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ List d;
        final /* synthetic */ C9663aL5 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(List list, C9663aL5 c9663aL5, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = list;
            this.e = c9663aL5;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C4375Ew0.this.new b(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                this.b = 1;
                if (HG1.b(450L, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            C4375Ew0.this.b.f(this.d, this.e.a);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ew0$c */
    public static final class c implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ C4375Ew0 b;

        /* renamed from: ir.nasim.Ew0$c$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ C4375Ew0 b;

            /* renamed from: ir.nasim.Ew0$c$a$a, reason: collision with other inner class name */
            public static final class C0350a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0350a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2, C4375Ew0 c4375Ew0) {
                this.a = interfaceC4806Gq2;
                this.b = c4375Ew0;
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
                    boolean r0 = r8 instanceof ir.nasim.C4375Ew0.c.a.C0350a
                    if (r0 == 0) goto L13
                    r0 = r8
                    ir.nasim.Ew0$c$a$a r0 = (ir.nasim.C4375Ew0.c.a.C0350a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.Ew0$c$a$a r0 = new ir.nasim.Ew0$c$a$a
                    r0.<init>(r8)
                L18:
                    java.lang.Object r8 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r8)
                    goto L55
                L29:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L31:
                    ir.nasim.AbstractC10685c16.b(r8)
                    ir.nasim.Gq2 r8 = r6.a
                    ir.nasim.NT4 r7 = (ir.nasim.NT4) r7
                    ir.nasim.Ew0$d r2 = new ir.nasim.Ew0$d
                    ir.nasim.Ew0 r4 = r6.b
                    r5 = 0
                    r2.<init>(r5)
                    ir.nasim.NT4 r7 = ir.nasim.TT4.g(r7, r2)
                    ir.nasim.Ik7 r2 = ir.nasim.EnumC5225Ik7.SOURCE_COMPLETE
                    ir.nasim.kw0$d r4 = ir.nasim.InterfaceC16239kw0.d.a
                    ir.nasim.NT4 r7 = ir.nasim.TT4.d(r7, r2, r4)
                    r0.b = r3
                    java.lang.Object r7 = r8.a(r7, r0)
                    if (r7 != r1) goto L55
                    return r1
                L55:
                    ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4375Ew0.c.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public c(InterfaceC4557Fq2 interfaceC4557Fq2, C4375Ew0 c4375Ew0) {
            this.a = interfaceC4557Fq2;
            this.b = c4375Ew0;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Ew0$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            d dVar = C4375Ew0.this.new d(interfaceC20295rm1);
            dVar.c = obj;
            return dVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C12630ew0 c12630ew0 = (C12630ew0) this.c;
                InterfaceC20468s37 interfaceC20468s37 = C4375Ew0.this.i;
                this.b = 1;
                obj = interfaceC20468s37.a(c12630ew0, this);
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
        public final Object invoke(C12630ew0 c12630ew0, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(c12630ew0, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ew0$e */
    static final class e extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        /* synthetic */ Object c;
        /* synthetic */ Object d;

        /* renamed from: ir.nasim.Ew0$e$a */
        static final class a extends AbstractC19859r37 implements InterfaceC15796kB2 {
            int b;
            /* synthetic */ Object c;
            /* synthetic */ Object d;
            final /* synthetic */ InterfaceC22261uw0 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC22261uw0 interfaceC22261uw0, InterfaceC20295rm1 interfaceC20295rm1) {
                super(3, interfaceC20295rm1);
                this.e = interfaceC22261uw0;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                InterfaceC16239kw0 interfaceC16239kw0 = (InterfaceC16239kw0) this.c;
                InterfaceC16239kw0 interfaceC16239kw02 = (InterfaceC16239kw0) this.d;
                if ((interfaceC16239kw0 instanceof InterfaceC16239kw0.d) && (interfaceC16239kw02 instanceof InterfaceC16239kw0.a) && (this.e instanceof InterfaceC22261uw0.b)) {
                    return new InterfaceC16239kw0.b(((InterfaceC22261uw0.b) this.e).c());
                }
                return null;
            }

            @Override // ir.nasim.InterfaceC15796kB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object q(InterfaceC16239kw0 interfaceC16239kw0, InterfaceC16239kw0 interfaceC16239kw02, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.e, interfaceC20295rm1);
                aVar.c = interfaceC16239kw0;
                aVar.d = interfaceC16239kw02;
                return aVar.invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.Ew0$e$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ InterfaceC22261uw0 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(InterfaceC22261uw0 interfaceC22261uw0, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = interfaceC22261uw0;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                b bVar = new b(this.d, interfaceC20295rm1);
                bVar.c = obj;
                return bVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                return NN3.a(this.d, (InterfaceC16239kw0) this.c);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC16239kw0 interfaceC16239kw0, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(interfaceC16239kw0, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
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
            NT4 nt4 = (NT4) this.c;
            InterfaceC22261uw0 interfaceC22261uw0 = (InterfaceC22261uw0) this.d;
            return UT4.g(UT4.f(nt4, null, new a(interfaceC22261uw0, null), 1, null), new b(interfaceC22261uw0, null));
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(NT4 nt4, InterfaceC22261uw0 interfaceC22261uw0, InterfaceC20295rm1 interfaceC20295rm1) {
            e eVar = new e(interfaceC20295rm1);
            eVar.c = nt4;
            eVar.d = interfaceC22261uw0;
            return eVar.invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ew0$f */
    static final class f extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        /* synthetic */ Object c;
        /* synthetic */ boolean d;

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
            NT4 nt4 = (NT4) this.c;
            if (!this.d) {
                return nt4;
            }
            return TT4.b(nt4, EnumC5225Ik7.SOURCE_COMPLETE, InterfaceC16239kw0.f.a);
        }

        public final Object n(NT4 nt4, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            f fVar = new f(interfaceC20295rm1);
            fVar.c = nt4;
            fVar.d = z;
            return fVar.invokeSuspend(C19938rB7.a);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return n((NT4) obj, ((Boolean) obj2).booleanValue(), (InterfaceC20295rm1) obj3);
        }
    }

    /* renamed from: ir.nasim.Ew0$g */
    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;
        final /* synthetic */ int e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(long j, int i, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
            this.e = i;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C4375Ew0.this.new g(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C4627Fy0 unused = C4375Ew0.this.c;
                if (((C17448mz0) C18039nz0.a.d().getValue()).l()) {
                    InterfaceC8327Vm4 interfaceC8327Vm4 = C4375Ew0.this.p;
                    String string = C4375Ew0.this.d.getString(BD5.features_call_can_not_join_multiple_calls);
                    AbstractC13042fc3.h(string, "getString(...)");
                    this.b = 1;
                    if (interfaceC8327Vm4.a(string, this) == objE) {
                        return objE;
                    }
                } else {
                    C4375Ew0.this.h.a(this.d, this.e);
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
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ew0$h */
    public static final class h implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ C4375Ew0 b;

        /* renamed from: ir.nasim.Ew0$h$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ C4375Ew0 b;

            /* renamed from: ir.nasim.Ew0$h$a$a, reason: collision with other inner class name */
            public static final class C0351a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;
                Object c;
                Object e;
                Object f;
                Object g;

                public C0351a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2, C4375Ew0 c4375Ew0) {
                this.a = interfaceC4806Gq2;
                this.b = c4375Ew0;
            }

            /* JADX WARN: Removed duplicated region for block: B:19:0x0062  */
            /* JADX WARN: Removed duplicated region for block: B:24:0x0083  */
            /* JADX WARN: Removed duplicated region for block: B:25:0x0087  */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x007c -> B:22:0x007f). Please report as a decompilation issue!!! */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r9, ir.nasim.InterfaceC20295rm1 r10) {
                /*
                    r8 = this;
                    boolean r0 = r10 instanceof ir.nasim.C4375Ew0.h.a.C0351a
                    if (r0 == 0) goto L13
                    r0 = r10
                    ir.nasim.Ew0$h$a$a r0 = (ir.nasim.C4375Ew0.h.a.C0351a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.Ew0$h$a$a r0 = new ir.nasim.Ew0$h$a$a
                    r0.<init>(r10)
                L18:
                    java.lang.Object r10 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L48
                    if (r2 == r4) goto L34
                    if (r2 != r3) goto L2c
                    ir.nasim.AbstractC10685c16.b(r10)
                    goto L9b
                L2c:
                    java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                    java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                    r9.<init>(r10)
                    throw r9
                L34:
                    java.lang.Object r9 = r0.g
                    java.util.Iterator r9 = (java.util.Iterator) r9
                    java.lang.Object r2 = r0.f
                    java.util.Collection r2 = (java.util.Collection) r2
                    java.lang.Object r5 = r0.e
                    ir.nasim.Gq2 r5 = (ir.nasim.InterfaceC4806Gq2) r5
                    java.lang.Object r6 = r0.c
                    ir.nasim.Ew0$h$a r6 = (ir.nasim.C4375Ew0.h.a) r6
                    ir.nasim.AbstractC10685c16.b(r10)
                    goto L7f
                L48:
                    ir.nasim.AbstractC10685c16.b(r10)
                    ir.nasim.Gq2 r10 = r8.a
                    java.util.List r9 = (java.util.List) r9
                    java.lang.Iterable r9 = (java.lang.Iterable) r9
                    java.util.ArrayList r2 = new java.util.ArrayList
                    r2.<init>()
                    java.util.Iterator r9 = r9.iterator()
                    r6 = r8
                    r5 = r10
                L5c:
                    boolean r10 = r9.hasNext()
                    if (r10 == 0) goto L87
                    java.lang.Object r10 = r9.next()
                    ir.nasim.nJ4 r10 = (ir.nasim.AbstractC17643nJ4) r10
                    ir.nasim.Ew0 r7 = r6.b
                    ir.nasim.s37 r7 = ir.nasim.C4375Ew0.Y0(r7)
                    r0.c = r6
                    r0.e = r5
                    r0.f = r2
                    r0.g = r9
                    r0.b = r4
                    java.lang.Object r10 = r7.a(r10, r0)
                    if (r10 != r1) goto L7f
                    return r1
                L7f:
                    ir.nasim.qJ4 r10 = (ir.nasim.InterfaceC19416qJ4) r10
                    if (r10 == 0) goto L5c
                    r2.add(r10)
                    goto L5c
                L87:
                    java.util.List r2 = (java.util.List) r2
                    r9 = 0
                    r0.c = r9
                    r0.e = r9
                    r0.f = r9
                    r0.g = r9
                    r0.b = r3
                    java.lang.Object r9 = r5.a(r2, r0)
                    if (r9 != r1) goto L9b
                    return r1
                L9b:
                    ir.nasim.rB7 r9 = ir.nasim.C19938rB7.a
                    return r9
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4375Ew0.h.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public h(InterfaceC4557Fq2 interfaceC4557Fq2, C4375Ew0 c4375Ew0) {
            this.a = interfaceC4557Fq2;
            this.b = c4375Ew0;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Ew0$i */
    static final class i extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        /* synthetic */ Object c;

        i(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return (List) this.c;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(List list, C17448mz0 c17448mz0, InterfaceC20295rm1 interfaceC20295rm1) {
            i iVar = new i(interfaceC20295rm1);
            iVar.c = list;
            return iVar.invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ew0$j */
    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        j(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            j jVar = C4375Ew0.this.new j(interfaceC20295rm1);
            jVar.c = obj;
            return jVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            List list = (List) this.c;
            if (!list.isEmpty()) {
                C4375Ew0.this.e1(AbstractC15401jX0.R0(AbstractC9766aX0.e(InterfaceC19416qJ4.a.a), list));
            } else {
                C4375Ew0.this.e1(list);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(List list, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((j) create(list, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ew0$k */
    static final class k extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        k(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C4375Ew0.this.new k(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C4375Ew0.this.k.d();
                C21671tw0 c21671tw0 = C4375Ew0.this.b;
                this.b = 1;
                if (c21671tw0.i(this) == objE) {
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
            return ((k) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ew0$l */
    static final class l extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        l(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C4375Ew0.this.new l(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC8327Vm4 interfaceC8327Vm4 = C4375Ew0.this.p;
                String string = C4375Ew0.this.d.getString(BD5.features_call_start_call_link_max_reached);
                AbstractC13042fc3.h(string, "getString(...)");
                this.b = 1;
                if (interfaceC8327Vm4.a(string, this) == objE) {
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
            return ((l) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ew0$m */
    static final class m extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        final /* synthetic */ int d;
        final /* synthetic */ C4375Ew0 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(int i, C4375Ew0 c4375Ew0, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = i;
            this.e = c4375Ew0;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new m(this.d, this.e, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x005a  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x005f  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r6.c
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L29
                if (r1 == r3) goto L1b
                if (r1 != r2) goto L13
                ir.nasim.AbstractC10685c16.b(r7)
                goto L9b
            L13:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1b:
                java.lang.Object r1 = r6.b
                ir.nasim.d25 r1 = (ir.nasim.C11458d25) r1
                ir.nasim.AbstractC10685c16.b(r7)
                ir.nasim.a16 r7 = (ir.nasim.C9475a16) r7
                java.lang.Object r7 = r7.l()
                goto L53
            L29:
                ir.nasim.AbstractC10685c16.b(r7)
                int r7 = r6.d
                ir.nasim.d25 r1 = ir.nasim.C11458d25.y(r7)
                java.lang.String r7 = "group(...)"
                ir.nasim.AbstractC13042fc3.h(r1, r7)
                ir.nasim.Ew0 r7 = r6.e
                ir.nasim.bQ2 r7 = ir.nasim.C4375Ew0.W0(r7)
                ir.nasim.VL3 r7 = r7.Y1()
                if (r7 == 0) goto L9b
                int r4 = r1.getPeerId()
                long r4 = (long) r4
                r6.b = r1
                r6.c = r3
                java.lang.Object r7 = ir.nasim.AbstractC4298En4.a(r7, r4, r6)
                if (r7 != r0) goto L53
                return r0
            L53:
                boolean r3 = ir.nasim.C9475a16.g(r7)
                r4 = 0
                if (r3 == 0) goto L5b
                r7 = r4
            L5b:
                ir.nasim.iO2 r7 = (ir.nasim.C14733iO2) r7
                if (r7 == 0) goto L9b
                ir.nasim.Ew0 r3 = r6.e
                int r5 = r6.d
                ir.nasim.Wh0 r7 = r7.F()
                java.lang.Object r7 = r7.b()
                java.lang.Boolean r7 = (java.lang.Boolean) r7
                boolean r7 = r7.booleanValue()
                if (r7 != 0) goto L91
                ir.nasim.Vm4 r7 = ir.nasim.C4375Ew0.b1(r3)
                android.content.Context r1 = ir.nasim.C4375Ew0.V0(r3)
                int r3 = ir.nasim.BD5.start_group_call_is_not_member_error
                java.lang.String r1 = r1.getString(r3)
                java.lang.String r3 = "getString(...)"
                ir.nasim.AbstractC13042fc3.h(r1, r3)
                r6.b = r4
                r6.c = r2
                java.lang.Object r7 = r7.a(r1, r6)
                if (r7 != r0) goto L9b
                return r0
            L91:
                ir.nasim.rv0 r7 = ir.nasim.C20384rv0.a
                long r0 = r1.u()
                r2 = 0
                r7.h0(r5, r0, r2)
            L9b:
                ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4375Ew0.m.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((m) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ew0$n */
    static final class n extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int c;
        final /* synthetic */ C4375Ew0 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        n(int i, C4375Ew0 c4375Ew0, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = i;
            this.d = c4375Ew0;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new n(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objA;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C11458d25 c11458d25E = C11458d25.E(this.c);
                AbstractC13042fc3.h(c11458d25E, "user(...)");
                VL3 vl3O0 = this.d.g.o0();
                long jU = c11458d25E.u();
                this.b = 1;
                objA = AbstractC4298En4.a(vl3O0, jU, this);
                if (objA == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i != 2 && i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return C19938rB7.a;
                }
                AbstractC10685c16.b(obj);
                objA = ((C9475a16) obj).l();
            }
            if (C9475a16.g(objA)) {
                objA = null;
            }
            C21231tK7 c21231tK7 = (C21231tK7) objA;
            if (c21231tK7 != null) {
                C4375Ew0 c4375Ew0 = this.d;
                int i2 = this.c;
                if (((Boolean) c21231tK7.A().b()).booleanValue()) {
                    InterfaceC8327Vm4 interfaceC8327Vm4 = c4375Ew0.p;
                    String string = c4375Ew0.d.getString(BD5.start_person_call_is_deleted);
                    AbstractC13042fc3.h(string, "getString(...)");
                    this.b = 2;
                    if (interfaceC8327Vm4.a(string, this) == objE) {
                        return objE;
                    }
                } else if (((Boolean) c21231tK7.p().b()).booleanValue()) {
                    InterfaceC8327Vm4 interfaceC8327Vm42 = c4375Ew0.p;
                    String string2 = c4375Ew0.d.getString(BD5.start_person_call_is_blocked);
                    AbstractC13042fc3.h(string2, "getString(...)");
                    this.b = 3;
                    if (interfaceC8327Vm42.a(string2, this) == objE) {
                        return objE;
                    }
                } else {
                    C20384rv0.b0(i2, false);
                }
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((n) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C4375Ew0(C21671tw0 c21671tw0, C4627Fy0 c4627Fy0, Context context, AbstractC13778go1 abstractC13778go1, C10299bQ2 c10299bQ2, OK7 ok7, C4978Hj3 c4978Hj3, InterfaceC20468s37 interfaceC20468s37, InterfaceC20468s37 interfaceC20468s372, C15732k47 c15732k47, C8054Ui1 c8054Ui1, C6409Nm c6409Nm) {
        AbstractC13042fc3.i(c21671tw0, "callLogRepository");
        AbstractC13042fc3.i(c4627Fy0, "callRepository");
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(c10299bQ2, "groupModule");
        AbstractC13042fc3.i(ok7, "userModule");
        AbstractC13042fc3.i(c4978Hj3, "joinGroupCallUseCase");
        AbstractC13042fc3.i(interfaceC20468s37, "callLogToCallLogItem");
        AbstractC13042fc3.i(interfaceC20468s372, "onGoingCallStateToOnGoingCall");
        AbstractC13042fc3.i(c15732k47, "syncOnGoingCallUseCase");
        AbstractC13042fc3.i(c8054Ui1, "contactModule");
        AbstractC13042fc3.i(c6409Nm, "analyticsRepository");
        this.b = c21671tw0;
        this.c = c4627Fy0;
        this.d = context;
        this.e = abstractC13778go1;
        this.f = c10299bQ2;
        this.g = ok7;
        this.h = c4978Hj3;
        this.i = interfaceC20468s37;
        this.j = interfaceC20468s372;
        this.k = c15732k47;
        this.l = c8054Ui1;
        this.m = c6409Nm;
        Boolean bool = Boolean.FALSE;
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(bool);
        this.n = interfaceC9336Zm4A;
        this.o = AbstractC6459Nq2.c(interfaceC9336Zm4A);
        InterfaceC8327Vm4 interfaceC8327Vm4B = AbstractC11420cy6.b(0, 0, null, 7, null);
        this.p = interfaceC8327Vm4B;
        this.q = interfaceC8327Vm4B;
        InterfaceC9336Zm4 interfaceC9336Zm4A2 = AbstractC12281eL6.a(new InterfaceC22261uw0.a(AbstractC10360bX0.m()));
        this.r = interfaceC9336Zm4A2;
        this.s = interfaceC9336Zm4A2;
        this.t = AbstractC12281eL6.a(bool);
        o1();
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new a(null), 3, null);
    }

    private final List d1(List list, long j2) {
        return AbstractC15401jX0.j0(AbstractC15401jX0.R0(list, AbstractC9766aX0.e(Long.valueOf(j2))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e1(List list) {
        Object value;
        InterfaceC22261uw0 interfaceC22261uw0 = (InterfaceC22261uw0) this.r.getValue();
        if (!(interfaceC22261uw0 instanceof InterfaceC22261uw0.a)) {
            if (!(interfaceC22261uw0 instanceof InterfaceC22261uw0.b)) {
                throw new NoWhenBranchMatchedException();
            }
            InterfaceC22261uw0.b bVar = (InterfaceC22261uw0.b) interfaceC22261uw0;
            new InterfaceC22261uw0.b(bVar.b(), bVar.c(), list);
            return;
        }
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.r;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, new InterfaceC22261uw0.a(list)));
        C19938rB7 c19938rB7 = C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object s1(InterfaceC20295rm1 interfaceC20295rm1) {
        Object objL = AbstractC6459Nq2.l(new h(AbstractC6459Nq2.S(C10263bM2.a.b(), AbstractC6459Nq2.x(C18039nz0.a.d(), new UA2() { // from class: ir.nasim.Dw0
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return Long.valueOf(C4375Ew0.t1((C17448mz0) obj));
            }
        }), new i(null)), this), new j(null), interfaceC20295rm1);
        return objL == AbstractC14862ic3.e() ? objL : C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long t1(C17448mz0 c17448mz0) {
        AbstractC13042fc3.i(c17448mz0, "it");
        return c17448mz0.c();
    }

    private final List y1(List list, long j2) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (j2 != ((Number) obj).longValue()) {
                arrayList.add(obj);
            }
        }
        return AbstractC15401jX0.j0(arrayList);
    }

    public final void A1() {
        this.m.b("click_call_link_button");
    }

    public final InterfaceC13730gj3 B1() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new l(null), 3, null);
    }

    public final InterfaceC13730gj3 C1(int i2) {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new m(i2, this, null), 3, null);
    }

    public final InterfaceC13730gj3 D1(int i2) {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new n(i2, this, null), 3, null);
    }

    public final void E1(boolean z) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.n;
        do {
            value = interfaceC9336Zm4.getValue();
            ((Boolean) value).booleanValue();
        } while (!interfaceC9336Zm4.f(value, Boolean.valueOf(z)));
    }

    public final void F1(boolean z) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.t;
        do {
            value = interfaceC9336Zm4.getValue();
            ((Boolean) value).booleanValue();
        } while (!interfaceC9336Zm4.f(value, Boolean.valueOf(z)));
    }

    public final void f1() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.r;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, new InterfaceC22261uw0.a(((InterfaceC22261uw0) value).a())));
    }

    public final void g1() {
        Object value;
        InterfaceC22261uw0.b bVar;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.r;
        do {
            value = interfaceC9336Zm4.getValue();
            InterfaceC22261uw0 interfaceC22261uw0 = (InterfaceC22261uw0) value;
            if (interfaceC22261uw0 instanceof InterfaceC22261uw0.a) {
                bVar = new InterfaceC22261uw0.b(AbstractC10360bX0.m(), false, ((InterfaceC22261uw0.a) interfaceC22261uw0).a());
            } else {
                if (!(interfaceC22261uw0 instanceof InterfaceC22261uw0.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                bVar = new InterfaceC22261uw0.b(AbstractC10360bX0.m(), !r2.c(), ((InterfaceC22261uw0.b) interfaceC22261uw0).a());
            }
        } while (!interfaceC9336Zm4.f(value, bVar));
    }

    public final void h1() {
        Object value;
        C9663aL5 c9663aL5 = new C9663aL5();
        InterfaceC22261uw0 interfaceC22261uw0 = (InterfaceC22261uw0) this.r.getValue();
        if (interfaceC22261uw0 instanceof InterfaceC22261uw0.a) {
            return;
        }
        if (!(interfaceC22261uw0 instanceof InterfaceC22261uw0.b)) {
            throw new NoWhenBranchMatchedException();
        }
        InterfaceC22261uw0.b bVar = (InterfaceC22261uw0.b) interfaceC22261uw0;
        c9663aL5.a = bVar.c();
        List listB = bVar.b();
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.r;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, new InterfaceC22261uw0.a(((InterfaceC22261uw0) value).a())));
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new b(listB, c9663aL5, null), 3, null);
    }

    public final InterfaceC9336Zm4 i1() {
        return this.s;
    }

    public final InterfaceC4557Fq2 j1() {
        return AbstractC6459Nq2.V(AbstractC6459Nq2.S(AbstractC6459Nq2.S(AbstractC9395Zt0.a(AbstractC6459Nq2.V(new c(this.b.g(), this), this.e), AbstractC9773aX7.a(this)), this.r, new e(null)), this.n, new f(null)), this.e);
    }

    public final InterfaceC10258bL6 k1() {
        return AbstractC6459Nq2.c(this.t);
    }

    public final InterfaceC10258bL6 l1() {
        return this.o;
    }

    public final InterfaceC10040ay6 m1() {
        return this.q;
    }

    public final boolean o1() {
        Object value;
        int iA = AbstractC4043Dl1.a(this.d, "android.permission.READ_CONTACTS");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.t;
        do {
            value = interfaceC9336Zm4.getValue();
            ((Boolean) value).booleanValue();
        } while (!interfaceC9336Zm4.f(value, Boolean.valueOf(iA == 0)));
        return iA == 0;
    }

    public final InterfaceC13730gj3 p1(long j2, int i2) {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new g(j2, i2, null), 3, null);
    }

    public final boolean q1() {
        return C10263bM2.a.c() >= 5;
    }

    public final void u1(InterfaceC16239kw0 interfaceC16239kw0) {
        Object value;
        InterfaceC16239kw0.a aVar;
        AbstractC13042fc3.i(interfaceC16239kw0, "callLog");
        if (interfaceC16239kw0 instanceof InterfaceC16239kw0.a) {
            Object value2 = this.r.getValue();
            InterfaceC22261uw0.b bVar = value2 instanceof InterfaceC22261uw0.b ? (InterfaceC22261uw0.b) value2 : null;
            if (bVar != null) {
                InterfaceC9336Zm4 interfaceC9336Zm4 = this.r;
                do {
                    value = interfaceC9336Zm4.getValue();
                    aVar = (InterfaceC16239kw0.a) interfaceC16239kw0;
                } while (!interfaceC9336Zm4.f(value, new InterfaceC22261uw0.b(bVar.b().contains(Long.valueOf(aVar.getId())) ? y1(bVar.b(), aVar.getId()) : d1(bVar.b(), aVar.getId()), bVar.c(), ((InterfaceC22261uw0) value).a())));
            }
        }
    }

    public final void v1(InterfaceC16239kw0 interfaceC16239kw0) {
        Object value;
        AbstractC13042fc3.i(interfaceC16239kw0, "callLog");
        if ((this.r.getValue() instanceof InterfaceC22261uw0.a) && (interfaceC16239kw0 instanceof InterfaceC16239kw0.a)) {
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.r;
            do {
                value = interfaceC9336Zm4.getValue();
            } while (!interfaceC9336Zm4.f(value, new InterfaceC22261uw0.b(d1(AbstractC10360bX0.m(), ((InterfaceC16239kw0.a) interfaceC16239kw0).getId()), false, ((InterfaceC22261uw0) value).a())));
        }
    }

    public final void w1() {
        this.l.p0();
    }

    public final void x1() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new k(null), 3, null);
    }

    public final void z1(InterfaceC22848vv0 interfaceC22848vv0, long j2) {
        AbstractC13042fc3.i(interfaceC22848vv0, "callLinkClickEventType");
        this.c.c1(interfaceC22848vv0, j2);
    }
}
