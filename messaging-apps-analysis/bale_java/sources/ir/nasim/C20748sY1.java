package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C20748sY1;
import ir.nasim.EX1;
import ir.nasim.MX1;
import ir.nasim.NX1;
import ir.nasim.SY1;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.sY1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C20748sY1 {
    private final HY1 a;
    private final IY1 b;
    private final AbstractC13778go1 c;
    private final InterfaceC20315ro1 d;
    private final SA2 e;
    private final KX1 f;

    /* renamed from: ir.nasim.sY1$a */
    /* synthetic */ class a extends EB2 implements SA2 {
        public static final a a = new a();

        a() {
            super(0, System.class, "currentTimeMillis", "currentTimeMillis()J", 0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final Long invoke() {
            return Long.valueOf(System.currentTimeMillis());
        }
    }

    /* renamed from: ir.nasim.sY1$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ MX1 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(MX1 mx1, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = mx1;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C20748sY1.this.new b(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C20748sY1 c20748sY1 = C20748sY1.this;
                MX1 mx1 = this.d;
                this.b = 1;
                obj = c20748sY1.n(mx1, false, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            SY1 sy1 = (SY1) obj;
            if (!(sy1 instanceof SY1.a)) {
                if (!(sy1 instanceof SY1.b) && !(sy1 instanceof SY1.c)) {
                    throw new NoWhenBranchMatchedException();
                }
                MX1 mx12 = this.d;
                if (!(mx12 instanceof MX1.a) && !(mx12 instanceof MX1.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                C20748sY1.this.f.m(this.d, new SY1.c(EX1.a.b));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.sY1$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C4995Hl2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(C4995Hl2 c4995Hl2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c4995Hl2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C20748sY1.this.new c(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C20748sY1 c20748sY1 = C20748sY1.this;
                C4995Hl2 c4995Hl2 = this.d;
                this.b = 1;
                obj = c20748sY1.o(c4995Hl2, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            SY1 sy1 = (SY1) obj;
            if (!(sy1 instanceof SY1.a)) {
                if (!(sy1 instanceof SY1.b) && !(sy1 instanceof SY1.c)) {
                    throw new NoWhenBranchMatchedException();
                }
                C20748sY1.this.f.l(this.d, new SY1.c(EX1.a.b));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.sY1$d */
    static final class d extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return C20748sY1.this.l(this);
        }
    }

    /* renamed from: ir.nasim.sY1$e */
    static final class e extends AbstractC22163um1 {
        Object a;
        Object b;
        boolean c;
        /* synthetic */ Object d;
        int f;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return C20748sY1.this.n(null, false, this);
        }
    }

    /* renamed from: ir.nasim.sY1$f */
    static final class f extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return C20748sY1.this.o(null, this);
        }
    }

    /* renamed from: ir.nasim.sY1$g */
    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;
        final /* synthetic */ MX1 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(MX1 mx1, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = mx1;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            g gVar = new g(this.d, interfaceC20295rm1);
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
            OX1.a(101, "getDownloadStates, onEach=" + ((SY1) this.c), this.d);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(SY1 sy1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(sy1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.sY1$h */
    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ MX1 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(MX1 mx1, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = mx1;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            h hVar = C20748sY1.this.new h(this.e, interfaceC20295rm1);
            hVar.c = obj;
            return hVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC4806Gq2 interfaceC4806Gq2;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                C20748sY1 c20748sY1 = C20748sY1.this;
                MX1 mx1 = this.e;
                this.c = interfaceC4806Gq2;
                this.b = 1;
                obj = C20748sY1.p(c20748sY1, mx1, false, this, 2, null);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return C19938rB7.a;
                }
                interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                AbstractC10685c16.b(obj);
            }
            this.c = null;
            this.b = 2;
            if (interfaceC4806Gq2.a(obj, this) == objE) {
                return objE;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((h) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.sY1$i */
    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ HY1 c;
        final /* synthetic */ HashMap d;
        final /* synthetic */ C20748sY1 e;

        /* renamed from: ir.nasim.sY1$i$a */
        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ HashMap a;
            final /* synthetic */ C20748sY1 b;
            final /* synthetic */ HY1 c;

            a(HashMap map, C20748sY1 c20748sY1, HY1 hy1) {
                this.a = map;
                this.b = c20748sY1;
                this.c = hy1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 g(NX1 nx1, C20748sY1 c20748sY1, HY1 hy1, SY1 sy1) {
                AbstractC13042fc3.i(nx1, "$item");
                AbstractC13042fc3.i(c20748sY1, "this$0");
                AbstractC13042fc3.i(hy1, "$downloadQueue");
                AbstractC13042fc3.i(sy1, "downloadState");
                OX1.a(3, "downloadWorker result=" + sy1, nx1.i());
                c20748sY1.f.m(nx1.i(), sy1);
                if ((sy1 instanceof SY1.a) || (sy1 instanceof SY1.c)) {
                    OX1.a(4, "file state is stable! removed from downloadQueue", nx1.i());
                    HY1.e(hy1, nx1.i(), false, 2, null);
                } else if (!(sy1 instanceof SY1.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public final Object a(List list, InterfaceC20295rm1 interfaceC20295rm1) {
                Set setKeySet = this.a.keySet();
                AbstractC13042fc3.h(setKeySet, "<get-keys>(...)");
                List list2 = list;
                List<NX1> listN0 = AbstractC15401jX0.N0(list2, setKeySet);
                Set setJ = AbstractC4846Gu6.j(setKeySet, AbstractC15401jX0.r1(list2));
                OX1.b(2, "observerQueue, downloadItems=" + list, null, 4, null);
                HashMap map = this.a;
                Iterator it = setJ.iterator();
                while (it.hasNext()) {
                    AY1 ay1 = (AY1) map.remove((NX1) it.next());
                    if (ay1 != null) {
                        ay1.e();
                    }
                }
                HashMap map2 = this.a;
                final C20748sY1 c20748sY1 = this.b;
                final HY1 hy1 = this.c;
                for (final NX1 nx1 : listN0) {
                    AY1 ay12 = new AY1(nx1.i(), nx1.h(), c20748sY1.b, c20748sY1.d, c20748sY1.c, new UA2() { // from class: ir.nasim.uY1
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C20748sY1.i.a.g(nx1, c20748sY1, hy1, (SY1) obj);
                        }
                    });
                    ay12.f();
                    map2.put(nx1, ay12);
                }
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(HY1 hy1, HashMap map, C20748sY1 c20748sY1, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = hy1;
            this.d = map;
            this.e = c20748sY1;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new i(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                HY1 hy1 = this.c;
                a aVar = new a(this.d, this.e, hy1);
                this.b = 1;
                if (hy1.b(aVar, this) == objE) {
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
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C20748sY1(HY1 hy1, IY1 iy1, AbstractC13778go1 abstractC13778go1, InterfaceC20315ro1 interfaceC20315ro1, SA2 sa2) {
        AbstractC13042fc3.i(hy1, "downloadQueue");
        AbstractC13042fc3.i(iy1, "downloadRepository");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(interfaceC20315ro1, "coroutineScope");
        AbstractC13042fc3.i(sa2, "getCurrentTime");
        this.a = hy1;
        this.b = iy1;
        this.c = abstractC13778go1;
        this.d = interfaceC20315ro1;
        this.e = sa2;
        this.f = new KX1();
        t(hy1);
    }

    private final InterfaceC13730gj3 j(MX1 mx1) {
        return AbstractC10533bm0.d(this.d, null, null, new b(mx1, null), 3, null);
    }

    private final InterfaceC13730gj3 k(C4995Hl2 c4995Hl2) {
        return AbstractC10533bm0.d(this.d, null, null, new c(c4995Hl2, null), 3, null);
    }

    private final void m(NX1 nx1) {
        this.f.m(nx1.i(), YY1.a());
        this.a.a(nx1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object n(ir.nasim.MX1 r6, boolean r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof ir.nasim.C20748sY1.e
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.sY1$e r0 = (ir.nasim.C20748sY1.e) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            ir.nasim.sY1$e r0 = new ir.nasim.sY1$e
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.d
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4c
            if (r2 == r4) goto L3e
            if (r2 != r3) goto L36
            boolean r7 = r0.c
            java.lang.Object r6 = r0.b
            ir.nasim.sY1 r6 = (ir.nasim.C20748sY1) r6
            java.lang.Object r0 = r0.a
            ir.nasim.MX1 r0 = (ir.nasim.MX1) r0
            ir.nasim.AbstractC10685c16.b(r8)
            goto L96
        L36:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3e:
            boolean r7 = r0.c
            java.lang.Object r6 = r0.b
            ir.nasim.sY1 r6 = (ir.nasim.C20748sY1) r6
            java.lang.Object r0 = r0.a
            ir.nasim.MX1 r0 = (ir.nasim.MX1) r0
            ir.nasim.AbstractC10685c16.b(r8)
            goto L75
        L4c:
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.KX1 r8 = r5.f
            ir.nasim.SY1 r8 = r8.f(r6)
            if (r8 != 0) goto Laa
            boolean r8 = r6 instanceof ir.nasim.MX1.a
            if (r8 == 0) goto L7c
            ir.nasim.IY1 r8 = r5.b
            r2 = r6
            ir.nasim.MX1$a r2 = (ir.nasim.MX1.a) r2
            ir.nasim.Hl2 r2 = r2.c()
            r0.a = r6
            r0.b = r5
            r0.c = r7
            r0.f = r4
            java.lang.Object r8 = r8.b(r2, r0)
            if (r8 != r1) goto L73
            return r1
        L73:
            r0 = r6
            r6 = r5
        L75:
            ir.nasim.nw1 r8 = (ir.nasim.InterfaceC18013nw1) r8
            ir.nasim.SY1 r8 = ir.nasim.AbstractC18604ow1.a(r8)
            goto L9c
        L7c:
            boolean r8 = r6 instanceof ir.nasim.MX1.b
            if (r8 == 0) goto La4
            ir.nasim.IY1 r8 = r5.b
            r2 = r6
            ir.nasim.MX1$b r2 = (ir.nasim.MX1.b) r2
            r0.a = r6
            r0.b = r5
            r0.c = r7
            r0.f = r3
            java.lang.Object r8 = r8.a(r2, r0)
            if (r8 != r1) goto L94
            return r1
        L94:
            r0 = r6
            r6 = r5
        L96:
            ir.nasim.nw1 r8 = (ir.nasim.InterfaceC18013nw1) r8
            ir.nasim.SY1 r8 = ir.nasim.AbstractC18604ow1.a(r8)
        L9c:
            if (r7 == 0) goto Laa
            ir.nasim.KX1 r6 = r6.f
            r6.m(r0, r8)
            goto Laa
        La4:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        Laa:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20748sY1.n(ir.nasim.MX1, boolean, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o(ir.nasim.C4995Hl2 r5, ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ir.nasim.C20748sY1.f
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.sY1$f r0 = (ir.nasim.C20748sY1.f) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.sY1$f r0 = new ir.nasim.sY1$f
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
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
            ir.nasim.KX1 r6 = r4.f
            ir.nasim.SY1 r6 = r6.g(r5)
            if (r6 != 0) goto L4d
            ir.nasim.IY1 r6 = r4.b
            r0.c = r3
            java.lang.Object r6 = r6.b(r5, r0)
            if (r6 != r1) goto L47
            return r1
        L47:
            ir.nasim.nw1 r6 = (ir.nasim.InterfaceC18013nw1) r6
            ir.nasim.SY1 r6 = ir.nasim.AbstractC18604ow1.a(r6)
        L4d:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20748sY1.o(ir.nasim.Hl2, ir.nasim.rm1):java.lang.Object");
    }

    static /* synthetic */ Object p(C20748sY1 c20748sY1, MX1 mx1, boolean z, InterfaceC20295rm1 interfaceC20295rm1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        return c20748sY1.n(mx1, z, interfaceC20295rm1);
    }

    private final InterfaceC4557Fq2 q(MX1 mx1) {
        InterfaceC4557Fq2 interfaceC4557Fq2Q = AbstractC6459Nq2.q(AbstractC6459Nq2.c0(AbstractC6459Nq2.b0(this.f.h(mx1), new g(mx1, null)), new h(mx1, null)));
        AbstractC13042fc3.g(interfaceC4557Fq2Q, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<ir.nasim.file.download.model.DownloadState<FILE_CONTENT of ir.nasim.file.download.DownloadManager.getDownloadStateAsFlow>>");
        return interfaceC4557Fq2Q;
    }

    private final void t(HY1 hy1) {
        AbstractC10533bm0.d(this.d, this.c, null, new i(hy1, new HashMap(), this, null), 2, null);
    }

    public final void g(MX1 mx1) {
        AbstractC13042fc3.i(mx1, "input");
        OX1.a(1, "cancel(ing)AutoDownload", mx1);
        this.a.c(mx1, true);
    }

    public final void h(MX1 mx1) {
        AbstractC13042fc3.i(mx1, "input");
        j(mx1);
        this.a.c(mx1, false);
        OX1.a(1, "cancelDownload", mx1);
    }

    public final void i(C4995Hl2 c4995Hl2) {
        AbstractC13042fc3.i(c4995Hl2, "location");
        k(c4995Hl2);
        this.a.d(c4995Hl2);
        OX1.b(1, "cancelDownload with location=" + c4995Hl2, null, 4, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object l(ir.nasim.InterfaceC20295rm1 r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof ir.nasim.C20748sY1.d
            if (r0 == 0) goto L13
            r0 = r5
            ir.nasim.sY1$d r0 = (ir.nasim.C20748sY1.d) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.sY1$d r0 = new ir.nasim.sY1$d
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.a
            ir.nasim.sY1 r0 = (ir.nasim.C20748sY1) r0
            ir.nasim.AbstractC10685c16.b(r5)
            goto L46
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L35:
            ir.nasim.AbstractC10685c16.b(r5)
            ir.nasim.IY1 r5 = r4.b
            r0.a = r4
            r0.d = r3
            java.lang.Object r5 = r5.c(r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            r0 = r4
        L46:
            ir.nasim.KX1 r5 = r0.f
            r5.e()
            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20748sY1.l(ir.nasim.rm1):java.lang.Object");
    }

    public final InterfaceC4557Fq2 r(MX1.a aVar) {
        AbstractC13042fc3.i(aVar, "input");
        InterfaceC4557Fq2 interfaceC4557Fq2Q = q(aVar);
        OX1.a(1, "getStandardDownloadStates", aVar);
        return interfaceC4557Fq2Q;
    }

    public final InterfaceC4557Fq2 s(MX1.b bVar) {
        AbstractC13042fc3.i(bVar, "input");
        return q(bVar);
    }

    public final void u(MX1 mx1, FY1 fy1, LY1 ly1) {
        AbstractC13042fc3.i(mx1, "input");
        AbstractC13042fc3.i(fy1, "downloadPolicy");
        AbstractC13042fc3.i(ly1, "requestType");
        m(new NX1.a(mx1, ((Number) this.e.invoke()).longValue(), fy1, ly1));
        C19938rB7 c19938rB7 = C19938rB7.a;
        OX1.a(1, "startImmediateDownload", mx1);
    }

    public final InterfaceC4557Fq2 v(MX1.a aVar, FY1 fy1, LY1 ly1) {
        AbstractC13042fc3.i(aVar, "input");
        AbstractC13042fc3.i(fy1, "downloadPolicy");
        AbstractC13042fc3.i(ly1, "requestType");
        u(aVar, fy1, ly1);
        return q(aVar);
    }

    public final InterfaceC4557Fq2 w(MX1.b bVar, FY1 fy1, LY1 ly1) {
        AbstractC13042fc3.i(bVar, "input");
        AbstractC13042fc3.i(fy1, "downloadPolicy");
        AbstractC13042fc3.i(ly1, "requestType");
        u(bVar, fy1, ly1);
        return q(bVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C20748sY1(HY1 hy1, IY1 iy1, AbstractC13778go1 abstractC13778go1, InterfaceC20315ro1 interfaceC20315ro1) {
        this(hy1, iy1, abstractC13778go1, interfaceC20315ro1, a.a);
        AbstractC13042fc3.i(hy1, "downloadQueue");
        AbstractC13042fc3.i(iy1, "downloadRepository");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(interfaceC20315ro1, "coroutineScope");
    }
}
