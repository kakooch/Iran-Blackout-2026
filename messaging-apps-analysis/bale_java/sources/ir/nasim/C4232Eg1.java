package ir.nasim;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.google.protobuf.BytesValue;
import io.sentry.C3155n3;
import ir.nasim.AbstractC17858ng6;
import ir.nasim.C3521Bf1;
import ir.nasim.XL4;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Eg1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C4232Eg1 extends VW7 {
    public static final b E0 = new b(null);
    public static final int F0 = 8;
    private InterfaceC9336Zm4 A;
    private InterfaceC9336Zm4 A0;
    private InterfaceC9336Zm4 B;
    private InterfaceC9336Zm4 B0;
    private final InterfaceC9173Yu3 C0;
    private final InterfaceC9173Yu3 D;
    private InterfaceC9336Zm4 D0;
    private InterfaceC9336Zm4 G;
    private final h H;
    private final InterfaceC9336Zm4 J;
    private List Y;
    private YT4 Z;
    private final C8054Ui1 b;
    private final C3521Bf1.a c;
    private final C10299bQ2 d;
    private final androidx.lifecycle.y e;
    private final int f;
    private final PE g;
    private final VL4 h;
    private final Context i;
    private final KM2 j;
    private final C18852pM4 k;
    private final InterfaceC9173Yu3 l;
    private final InterfaceC9173Yu3 m;
    private final InterfaceC9173Yu3 n;
    private final InterfaceC9173Yu3 o;
    private final InterfaceC9173Yu3 p;
    private final InterfaceC9173Yu3 q;
    private final InterfaceC9173Yu3 r;
    private final InterfaceC9173Yu3 s;
    private final InterfaceC9173Yu3 t;
    private final InterfaceC9173Yu3 u;
    private final InterfaceC9173Yu3 v;
    private final InterfaceC9173Yu3 w;
    private final InterfaceC9173Yu3 x;
    private InterfaceC9336Zm4 y;
    private List z;
    private final InterfaceC9173Yu3 z0;

    /* renamed from: ir.nasim.Eg1$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.Eg1$a$a, reason: collision with other inner class name */
        static final class C0346a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C4232Eg1 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0346a(C4232Eg1 c4232Eg1, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c4232Eg1;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                C0346a c0346a = new C0346a(this.d, interfaceC20295rm1);
                c0346a.c = obj;
                return c0346a;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                C16110kj1 c16110kj1 = (C16110kj1) this.c;
                if (c16110kj1.d() && c16110kj1.c()) {
                    this.d.z2();
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C16110kj1 c16110kj1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C0346a) create(c16110kj1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C4232Eg1.this.new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10258bL6 interfaceC10258bL6B = C4232Eg1.this.g.D().b();
                C0346a c0346a = new C0346a(C4232Eg1.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC10258bL6B, c0346a, this) == objE) {
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

    /* renamed from: ir.nasim.Eg1$b */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Eg1$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        Object e;
        int f;
        int g;
        final /* synthetic */ UA2 i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.i = ua2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C4232Eg1.this.new c(this.i, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x00ea  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r18) {
            /*
                Method dump skipped, instructions count: 370
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4232Eg1.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Eg1$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        int d;
        final /* synthetic */ List f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(List list, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.f = list;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C4232Eg1.this.new d(this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            C4232Eg1 c4232Eg1;
            Object objD;
            List list;
            Object objE = AbstractC14862ic3.e();
            int i = this.d;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                Integer numC2 = C4232Eg1.this.c2();
                if (numC2 != null) {
                    c4232Eg1 = C4232Eg1.this;
                    List list2 = this.f;
                    int iIntValue = numC2.intValue();
                    Integer numK2 = c4232Eg1.k2();
                    if (numK2 != null) {
                        int iIntValue2 = numK2.intValue();
                        if (c4232Eg1.Y.size() >= 200) {
                            c4232Eg1.Y2(list2, c4232Eg1.Y);
                        } else if (c4232Eg1.d2().size() >= iIntValue2 || c4232Eg1.d2().size() >= 200) {
                            c4232Eg1.Y = c4232Eg1.d2();
                            c4232Eg1.Y2(list2, c4232Eg1.d2());
                        } else {
                            C6517Nv5 c6517Nv5W1 = c4232Eg1.d.W1(iIntValue, BytesValue.getDefaultInstance(), iIntValue2);
                            this.b = c4232Eg1;
                            this.c = list2;
                            this.d = 1;
                            objD = AbstractC6756Ov5.d(c6517Nv5W1, null, this, 1, null);
                            if (objD == objE) {
                                return objE;
                            }
                            list = list2;
                        }
                    }
                }
                return C19938rB7.a;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            list = (List) this.c;
            c4232Eg1 = (C4232Eg1) this.b;
            AbstractC10685c16.b(obj);
            objD = ((C9475a16) obj).l();
            if (C9475a16.j(objD)) {
                C24878zM2 c24878zM2 = (C24878zM2) objD;
                List listA = c24878zM2.a();
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listA, 10));
                Iterator it = listA.iterator();
                while (it.hasNext()) {
                    arrayList.add(AbstractC6392Nk0.d(((C23104wM2) it.next()).f()));
                }
                c4232Eg1.Y = arrayList;
                List listA2 = c24878zM2.a();
                ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(listA2, 10));
                Iterator it2 = listA2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(AbstractC6392Nk0.d(((C23104wM2) it2.next()).f()));
                }
                c4232Eg1.Y2(list, arrayList2);
            }
            C9475a16.a(objD);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Eg1$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        /* renamed from: ir.nasim.Eg1$e$a */
        public static final class a implements Comparator {
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return AbstractC18050o01.d(((C23209wY) obj).d(), ((C23209wY) obj2).d());
            }
        }

        /* renamed from: ir.nasim.Eg1$e$b */
        public static final class b implements Comparator {
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return AbstractC18050o01.d(((C23209wY) obj).d(), ((C23209wY) obj2).d());
            }
        }

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            e eVar = C4232Eg1.this.new e(interfaceC20295rm1);
            eVar.c = obj;
            return eVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            Object dVar;
            Object value2;
            XL4 dVar2;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            String str = (String) this.c;
            if (str == null || str.length() == 0) {
                InterfaceC9336Zm4 interfaceC9336Zm4 = C4232Eg1.this.y;
                C4232Eg1 c4232Eg1 = C4232Eg1.this;
                do {
                    value = interfaceC9336Zm4.getValue();
                    dVar = (XL4) value;
                    if (dVar instanceof XL4.d) {
                        dVar = new XL4.d(AbstractC15401jX0.a1(c4232Eg1.z, new b()));
                    }
                } while (!interfaceC9336Zm4.f(value, dVar));
            } else {
                C20644sM5 c20644sM5 = new C20644sM5(C3155n3.DEFAULT_PROPAGATION_TARGETS + str + C3155n3.DEFAULT_PROPAGATION_TARGETS, EnumC23107wM5.c);
                InterfaceC9336Zm4 interfaceC9336Zm42 = C4232Eg1.this.y;
                C4232Eg1 c4232Eg12 = C4232Eg1.this;
                do {
                    value2 = interfaceC9336Zm42.getValue();
                    dVar2 = (XL4) value2;
                    if (dVar2 instanceof XL4.d) {
                        dVar2 = new XL4.d(AbstractC15401jX0.a1(c4232Eg12.O2(c20644sM5), new a()));
                    }
                } while (!interfaceC9336Zm42.f(value2, dVar2));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(str, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Eg1$f */
    public static final class f implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ C4232Eg1 b;

        /* renamed from: ir.nasim.Eg1$f$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ C4232Eg1 b;

            /* renamed from: ir.nasim.Eg1$f$a$a, reason: collision with other inner class name */
            public static final class C0347a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0347a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2, C4232Eg1 c4232Eg1) {
                this.a = interfaceC4806Gq2;
                this.b = c4232Eg1;
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
                    boolean r0 = r8 instanceof ir.nasim.C4232Eg1.f.a.C0347a
                    if (r0 == 0) goto L13
                    r0 = r8
                    ir.nasim.Eg1$f$a$a r0 = (ir.nasim.C4232Eg1.f.a.C0347a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.Eg1$f$a$a r0 = new ir.nasim.Eg1$f$a$a
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
                    ir.nasim.Eg1$g r2 = new ir.nasim.Eg1$g
                    ir.nasim.Eg1 r4 = r6.b
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
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4232Eg1.f.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public f(InterfaceC4557Fq2 interfaceC4557Fq2, C4232Eg1 c4232Eg1) {
            this.a = interfaceC4557Fq2;
            this.b = c4232Eg1;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Eg1$g */
    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            g gVar = C4232Eg1.this.new g(interfaceC20295rm1);
            gVar.c = obj;
            return gVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return AbstractC6392Nk0.a(((C23209wY) this.c).a() != C4232Eg1.this.f);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(C23209wY c23209wY, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(c23209wY, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Eg1$h */
    public static final class h implements FB3 {
        h() {
        }

        @Override // ir.nasim.FB3
        public void b() {
            C4232Eg1.this.z2();
        }

        @Override // ir.nasim.FB3
        public void c(List list) {
            C4232Eg1.this.z2();
        }

        @Override // ir.nasim.FB3
        public void d(List list) {
            C4232Eg1.this.z2();
        }

        @Override // ir.nasim.FB3
        public void e(long j) {
            C4232Eg1.this.z2();
        }

        @Override // ir.nasim.FB3
        public void f(long[] jArr) {
            C4232Eg1.this.z2();
        }

        @Override // ir.nasim.FB3
        public void g(List list, EnumC24659yz5 enumC24659yz5) {
            C4232Eg1.this.z2();
        }

        @Override // ir.nasim.FB3
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void a(C3512Be1 c3512Be1) {
            C4232Eg1.this.z2();
        }
    }

    /* renamed from: ir.nasim.Eg1$i */
    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.Eg1$i$a */
        public static final class a implements Comparator {
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return AbstractC18050o01.d(((C23209wY) obj).d(), ((C23209wY) obj2).d());
            }
        }

        /* renamed from: ir.nasim.Eg1$i$b */
        public static final class b implements Comparator {
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return AbstractC18050o01.d(((C23209wY) obj).d(), ((C23209wY) obj2).d());
            }
        }

        i(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C4232Eg1.this.new i(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            Object objG;
            Object value2;
            Object value3;
            Object value4;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C4232Eg1.this.Q1();
                InterfaceC9336Zm4 interfaceC9336Zm4 = C4232Eg1.this.y;
                do {
                    value = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value, XL4.c.a));
                VL4 vl4 = C4232Eg1.this.h;
                this.b = 1;
                objG = vl4.g(this);
                if (objG == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objG = ((C9475a16) obj).l();
            }
            C4232Eg1 c4232Eg1 = C4232Eg1.this;
            Throwable thE = C9475a16.e(objG);
            if (thE != null) {
                InterfaceC9336Zm4 interfaceC9336Zm42 = c4232Eg1.y;
                do {
                    value4 = interfaceC9336Zm42.getValue();
                } while (!interfaceC9336Zm42.f(value4, new XL4.a(thE)));
            }
            C4232Eg1 c4232Eg12 = C4232Eg1.this;
            if (C9475a16.j(objG)) {
                List<WL4> list = (List) objG;
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
                for (WL4 wl4 : list) {
                    arrayList.add(new C23209wY(wl4.a(), wl4.d(), wl4.b(), wl4.f(), wl4.e(), wl4.c()));
                }
                c4232Eg12.z = arrayList;
                if (c4232Eg12.a2() == EnumC6357Ng1.a) {
                    List list2 = c4232Eg12.z;
                    ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(list2, 10));
                    Iterator it = list2.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(AbstractC6392Nk0.d(((C23209wY) it.next()).a()));
                    }
                    c4232Eg12.P1(arrayList2);
                }
                CharSequence charSequence = (CharSequence) c4232Eg12.p2().getValue();
                if (charSequence == null || charSequence.length() == 0) {
                    InterfaceC9336Zm4 interfaceC9336Zm43 = c4232Eg12.y;
                    do {
                        value2 = interfaceC9336Zm43.getValue();
                    } while (!interfaceC9336Zm43.f(value2, new XL4.d(AbstractC15401jX0.a1(arrayList, new b()))));
                } else {
                    C20644sM5 c20644sM5 = new C20644sM5(C3155n3.DEFAULT_PROPAGATION_TARGETS + c4232Eg12.p2().getValue() + C3155n3.DEFAULT_PROPAGATION_TARGETS, EnumC23107wM5.c);
                    InterfaceC9336Zm4 interfaceC9336Zm44 = c4232Eg12.y;
                    do {
                        value3 = interfaceC9336Zm44.getValue();
                    } while (!interfaceC9336Zm44.f(value3, new XL4.d(AbstractC15401jX0.a1(c4232Eg12.O2(c20644sM5), new a()))));
                }
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Eg1$j */
    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ boolean d;
        final /* synthetic */ UA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(boolean z, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = z;
            this.e = ua2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C4232Eg1.this.new j(this.d, this.e, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:42:0x0181  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                Method dump skipped, instructions count: 394
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4232Eg1.j.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Eg1$k */
    public static final class k extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        private /* synthetic */ Object c;
        /* synthetic */ Object d;
        final /* synthetic */ C4232Eg1 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(InterfaceC20295rm1 interfaceC20295rm1, C4232Eg1 c4232Eg1) {
            super(3, interfaceC20295rm1);
            this.e = c4232Eg1;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                String str = (String) this.d;
                InterfaceC4557Fq2 interfaceC4557Fq2S1 = this.e.S1(str != null ? AbstractC20762sZ6.n1(str).toString() : null);
                this.b = 1;
                if (AbstractC6459Nq2.A(interfaceC4806Gq2, interfaceC4557Fq2S1, this) == objE) {
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
            k kVar = new k(interfaceC20295rm1, this.e);
            kVar.c = interfaceC4806Gq2;
            kVar.d = obj;
            return kVar.invokeSuspend(C19938rB7.a);
        }
    }

    public C4232Eg1(C8054Ui1 c8054Ui1, C3521Bf1.a aVar, C10299bQ2 c10299bQ2, androidx.lifecycle.y yVar, int i2, PE pe, VL4 vl4, Context context, KM2 km2, C18852pM4 c18852pM4) {
        AbstractC13042fc3.i(c8054Ui1, "contactsModule");
        AbstractC13042fc3.i(aVar, "baleContactDataLoaderFactory");
        AbstractC13042fc3.i(c10299bQ2, "groupsModule");
        AbstractC13042fc3.i(yVar, "savedStateHandle");
        AbstractC13042fc3.i(pe, "appState");
        AbstractC13042fc3.i(vl4, "organizationContactDataLoader");
        AbstractC13042fc3.i(context, "applicationContext");
        AbstractC13042fc3.i(km2, "groupRepository");
        AbstractC13042fc3.i(c18852pM4, "organizationPreferencesStorage");
        this.b = c8054Ui1;
        this.c = aVar;
        this.d = c10299bQ2;
        this.e = yVar;
        this.f = i2;
        this.g = pe;
        this.h = vl4;
        this.i = context;
        this.j = km2;
        this.k = c18852pM4;
        this.l = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.lg1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C4232Eg1.y2(this.a);
            }
        });
        this.m = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Bg1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C4232Eg1.O1(this.a);
            }
        });
        this.n = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Cg1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C4232Eg1.x2(this.a);
            }
        });
        this.o = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Dg1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C4232Eg1.w2(this.a);
            }
        });
        this.p = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.mg1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C4232Eg1.N1(this.a);
            }
        });
        this.q = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.ng1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C4232Eg1.R1(this.a);
            }
        });
        this.r = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.og1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C4232Eg1.u2(this.a);
            }
        });
        this.s = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.pg1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C4232Eg1.L1(this.a);
            }
        });
        this.t = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.qg1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Boolean.valueOf(C4232Eg1.M1(this.a));
            }
        });
        this.u = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.rg1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C4232Eg1.F2(this.a);
            }
        });
        this.v = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.vg1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Boolean.valueOf(C4232Eg1.J2(this.a));
            }
        });
        this.w = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.wg1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C4232Eg1.v2(this.a);
            }
        });
        this.x = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.xg1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Boolean.valueOf(C4232Eg1.C2(this.a));
            }
        });
        this.y = AbstractC12281eL6.a(XL4.b.a);
        this.z = AbstractC10360bX0.m();
        this.A = AbstractC12281eL6.a(AbstractC10360bX0.m());
        this.B = AbstractC12281eL6.a(Boolean.FALSE);
        this.D = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.yg1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C4232Eg1.D2(this.a);
            }
        });
        this.G = AbstractC12281eL6.a(new C11046ce3(null, null, 3, null));
        h hVar = new h();
        this.H = hVar;
        this.J = AbstractC12281eL6.a(new HashMap());
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new a(null), 3, null);
        i2().j(hVar);
        this.Y = AbstractC10360bX0.m();
        this.z0 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.zg1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C4232Eg1.K2();
            }
        });
        this.A0 = AbstractC12281eL6.a(null);
        this.B0 = AbstractC12281eL6.a(AbstractC17858ng6.b.b);
        this.C0 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Ag1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C4232Eg1.L2(this.a);
            }
        });
        this.D0 = AbstractC12281eL6.a(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean C2(C4232Eg1 c4232Eg1) {
        AbstractC13042fc3.i(c4232Eg1, "this$0");
        return c4232Eg1.k.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WK D2(C4232Eg1 c4232Eg1) {
        AbstractC13042fc3.i(c4232Eg1, "this$0");
        DB3 db3M0 = c4232Eg1.b.m0();
        AbstractC13042fc3.g(db3M0, "null cannot be cast to non-null type ir.nasim.core.runtime.storage.AsyncListEngine<ir.nasim.core.modules.contacts.entity.Contact>");
        return (WK) db3M0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer F2(C4232Eg1 c4232Eg1) {
        AbstractC13042fc3.i(c4232Eg1, "this$0");
        return (Integer) c4232Eg1.e.c("MEMBER_COUNT");
    }

    public static /* synthetic */ InterfaceC13730gj3 H2(C4232Eg1 c4232Eg1, boolean z, UA2 ua2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        return c4232Eg1.G2(z, ua2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean J2(C4232Eg1 c4232Eg1) {
        AbstractC13042fc3.i(c4232Eg1, "this$0");
        Boolean bool = (Boolean) c4232Eg1.e.c("OPEN_FROM_CHAT");
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MT4 K2() {
        return new MT4(50, 0, false, 50, 0, 0, 50, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean L1(C4232Eg1 c4232Eg1) {
        AbstractC13042fc3.i(c4232Eg1, "this$0");
        return (Boolean) c4232Eg1.e.c("amIAdminArg");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC4557Fq2 L2(C4232Eg1 c4232Eg1) {
        AbstractC13042fc3.i(c4232Eg1, "this$0");
        return AbstractC9395Zt0.a(AbstractC6459Nq2.v(AbstractC6459Nq2.s0(AbstractC6459Nq2.t(c4232Eg1.A0, new UA2() { // from class: ir.nasim.sg1
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return Long.valueOf(C4232Eg1.M2((String) obj));
            }
        }), new k(null, c4232Eg1))), AbstractC9773aX7.a(c4232Eg1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean M1(C4232Eg1 c4232Eg1) {
        AbstractC13042fc3.i(c4232Eg1, "this$0");
        Boolean bool = (Boolean) c4232Eg1.e.c("AmIOwnerArg");
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long M2(String str) {
        return (str == null || str.length() == 0) ? 0L : 200L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String N1(C4232Eg1 c4232Eg1) {
        AbstractC13042fc3.i(c4232Eg1, "this$0");
        return (String) c4232Eg1.e.c("avatarPath");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String O1(C4232Eg1 c4232Eg1) {
        AbstractC13042fc3.i(c4232Eg1, "this$0");
        return (String) c4232Eg1.e.c("channelId");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List O2(C20644sM5 c20644sM5) {
        String strE;
        List list = this.z;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            C23209wY c23209wY = (C23209wY) obj;
            if (c20644sM5.g(c23209wY.d()) || ((strE = c23209wY.e()) != null && c20644sM5.g(strE))) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC13730gj3 Q1() {
        return AbstractC6459Nq2.W(AbstractC6459Nq2.b0(AbstractC6459Nq2.s(p2(), 200L), new e(null)), AbstractC9773aX7.a(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Q2(C23209wY c23209wY, C23209wY c23209wY2) {
        AbstractC13042fc3.i(c23209wY, "$contact");
        AbstractC13042fc3.i(c23209wY2, "it");
        return c23209wY2.a() == c23209wY.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EnumC6357Ng1 R1(C4232Eg1 c4232Eg1) {
        AbstractC13042fc3.i(c4232Eg1, "this$0");
        Object objC = c4232Eg1.e.c("contactSelectionType");
        AbstractC13042fc3.f(objC);
        return (EnumC6357Ng1) objC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC4557Fq2 S1(final String str) {
        return new f(new C12960fT4(n2(), null, new SA2() { // from class: ir.nasim.tg1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C4232Eg1.T1(this.a, str);
            }
        }, 2, null).a(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final YT4 T1(C4232Eg1 c4232Eg1, String str) {
        AbstractC13042fc3.i(c4232Eg1, "this$0");
        return c4232Eg1.U1(str);
    }

    private final YT4 U1(String str) {
        C24489yi1 c24489yi1 = new C24489yi1(this.c.a(str));
        this.Z = c24489yi1;
        return c24489yi1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U2(Throwable th) {
        W2(UN2.a(th, g2()));
    }

    private final void W2(String str) {
        this.D0.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String X1() {
        return (String) this.p.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y2(List list, List list2) {
        Object value;
        HashMap map;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.J;
        do {
            value = interfaceC9336Zm4.getValue();
            map = new HashMap();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Number) it.next()).intValue();
                Integer numValueOf = Integer.valueOf(iIntValue);
                List list3 = list2;
                boolean z = true;
                if (!(list3 instanceof Collection) || !list3.isEmpty()) {
                    Iterator it2 = list3.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        } else if (((Number) it2.next()).intValue() == iIntValue) {
                            z = false;
                            break;
                        }
                    }
                }
                map.put(numValueOf, Boolean.valueOf(z));
            }
        } while (!interfaceC9336Zm4.f(value, map));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String Z1() {
        return (String) this.m.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a3(boolean z) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.B;
        do {
            value = interfaceC9336Zm4.getValue();
            ((Boolean) value).booleanValue();
        } while (!interfaceC9336Zm4.f(value, Boolean.valueOf(z)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List d2() {
        return (List) this.w.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PM2 e2() {
        return (PM2) this.o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String f2() {
        return (String) this.n.getValue();
    }

    private final WK i2() {
        return (WK) this.D.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Integer k2() {
        return (Integer) this.u.getValue();
    }

    private final MT4 n2() {
        return (MT4) this.z0.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer u2(C4232Eg1 c4232Eg1) {
        AbstractC13042fc3.i(c4232Eg1, "this$0");
        return (Integer) c4232Eg1.e.c("groupIdArg");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List v2(C4232Eg1 c4232Eg1) {
        AbstractC13042fc3.i(c4232Eg1, "this$0");
        List list = (List) c4232Eg1.e.c("MEMBER_LIST_ARG");
        return list == null ? AbstractC10360bX0.m() : list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PM2 w2(C4232Eg1 c4232Eg1) {
        AbstractC13042fc3.i(c4232Eg1, "this$0");
        return (PM2) c4232Eg1.e.c("groupRestriction");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String x2(C4232Eg1 c4232Eg1) {
        AbstractC13042fc3.i(c4232Eg1, "this$0");
        String str = (String) c4232Eg1.e.c("groupTitle");
        return str == null ? "" : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ZN2 y2(C4232Eg1 c4232Eg1) {
        AbstractC13042fc3.i(c4232Eg1, "this$0");
        ZN2 zn2 = (ZN2) c4232Eg1.e.c("groupTypeKey");
        return zn2 == null ? ZN2.GROUP : zn2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C19938rB7 z2() {
        YT4 yt4 = this.Z;
        if (yt4 == null) {
            return null;
        }
        yt4.e();
        return C19938rB7.a;
    }

    public final boolean A2() {
        return ((Boolean) this.x.getValue()).booleanValue();
    }

    public final InterfaceC13730gj3 E2() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new i(null), 3, null);
    }

    public final InterfaceC13730gj3 G2(boolean z, UA2 ua2) {
        AbstractC13042fc3.i(ua2, "onSuccess");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new j(z, ua2, null), 3, null);
    }

    public final void I2() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.D0;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, null));
    }

    public final void K1(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "onSuccess");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new c(ua2, null), 3, null);
    }

    @Override // ir.nasim.VW7
    protected void L0() {
        i2().n(this.H);
        super.L0();
    }

    public final void N2() {
        this.b.p0();
    }

    public final void P1(List list) {
        AbstractC13042fc3.i(list, "uIds");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new d(list, null), 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void P2(final ir.nasim.C23209wY r8) {
        /*
            r7 = this;
            java.lang.String r0 = "contact"
            ir.nasim.AbstractC13042fc3.i(r8, r0)
            ir.nasim.Zm4 r0 = r7.A
        L7:
            java.lang.Object r1 = r0.getValue()
            r2 = r1
            java.util.List r2 = (java.util.List) r2
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Set r2 = ir.nasim.ZW0.q1(r2)
            r3 = r2
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            boolean r4 = r3 instanceof java.util.Collection
            if (r4 == 0) goto L25
            r4 = r3
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L25
            goto L48
        L25:
            java.util.Iterator r4 = r3.iterator()
        L29:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L48
            java.lang.Object r5 = r4.next()
            ir.nasim.wY r5 = (ir.nasim.C23209wY) r5
            int r5 = r5.a()
            int r6 = r8.a()
            if (r5 != r6) goto L29
            ir.nasim.ug1 r2 = new ir.nasim.ug1
            r2.<init>()
            ir.nasim.ZW0.I(r3, r2)
            goto L87
        L48:
            ir.nasim.Ng1 r4 = r7.a2()
            ir.nasim.Ng1 r5 = ir.nasim.EnumC6357Ng1.b
            if (r4 != r5) goto L53
            r2.clear()
        L53:
            int r4 = r2.size()
            r5 = 200(0xc8, float:2.8E-43)
            if (r4 > r5) goto L6f
            r2.add(r8)
            ir.nasim.Zm4 r2 = r7.A0
        L60:
            java.lang.Object r4 = r2.getValue()
            r5 = r4
            java.lang.String r5 = (java.lang.String) r5
            r5 = 0
            boolean r4 = r2.f(r4, r5)
            if (r4 == 0) goto L60
            goto L87
        L6f:
            android.content.Context r2 = r7.i
            int r4 = ir.nasim.ED5.contact_list_count_limit
            java.lang.String r2 = r2.getString(r4)
            ir.nasim.ZN2 r4 = r7.g2()
            java.lang.String r2 = ir.nasim.AbstractC5969Lp4.a(r2, r4)
            java.lang.String r4 = "formatGroupType(...)"
            ir.nasim.AbstractC13042fc3.h(r2, r4)
            r7.W2(r2)
        L87:
            java.util.List r2 = ir.nasim.ZW0.m1(r3)
            boolean r1 = r0.f(r1, r2)
            if (r1 == 0) goto L7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4232Eg1.P2(ir.nasim.wY):void");
    }

    public final void R2(String str) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.A0;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, str));
    }

    public final void S2(AbstractC17858ng6 abstractC17858ng6) {
        Object value;
        AbstractC13042fc3.i(abstractC17858ng6, "searchFocusState");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.B0;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, abstractC17858ng6));
    }

    public final Boolean V1() {
        return (Boolean) this.s.getValue();
    }

    public final boolean W1() {
        return ((Boolean) this.t.getValue()).booleanValue();
    }

    public final InterfaceC10258bL6 Y1() {
        return AbstractC6459Nq2.c(this.J);
    }

    public final EnumC6357Ng1 a2() {
        return (EnumC6357Ng1) this.q.getValue();
    }

    public final Integer c2() {
        return (Integer) this.r.getValue();
    }

    public final ZN2 g2() {
        return (ZN2) this.l.getValue();
    }

    public final InterfaceC10258bL6 h2() {
        return AbstractC6459Nq2.c(this.G);
    }

    public final InterfaceC10258bL6 j2() {
        return AbstractC6459Nq2.c(this.B);
    }

    public final boolean l2() {
        return ((Boolean) this.v.getValue()).booleanValue();
    }

    public final InterfaceC10258bL6 m2() {
        return AbstractC6459Nq2.c(this.y);
    }

    public final InterfaceC4557Fq2 o2() {
        return (InterfaceC4557Fq2) this.C0.getValue();
    }

    public final InterfaceC10258bL6 p2() {
        return AbstractC6459Nq2.c(this.A0);
    }

    public final InterfaceC10258bL6 r2() {
        return AbstractC6459Nq2.c(this.B0);
    }

    public final InterfaceC10258bL6 s2() {
        return AbstractC6459Nq2.c(this.A);
    }

    public final InterfaceC10258bL6 t2() {
        return AbstractC6459Nq2.c(this.D0);
    }
}
