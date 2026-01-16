package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.Vg3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C8272Vg3 implements InterfaceC8038Ug3 {
    public static final a g = new a(null);
    private final AbstractC13778go1 b;
    private final C6287Mz c;
    private final UG7 d;
    private InterfaceC9336Zm4 e;
    private InterfaceC9336Zm4 f;

    /* renamed from: ir.nasim.Vg3$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Vg3$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;

        /* renamed from: ir.nasim.Vg3$b$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C8272Vg3 c;
            final /* synthetic */ List d;
            final /* synthetic */ C12889fL5 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C8272Vg3 c8272Vg3, List list, C12889fL5 c12889fL5, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c8272Vg3;
                this.d = list;
                this.e = c12889fL5;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, this.e, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objD;
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    C6517Nv5 c6517Nv5W = this.c.d.W(this.d);
                    AbstractC13042fc3.h(c6517Nv5W, "forceLoadRequiredGroupPeers(...)");
                    this.b = 1;
                    objD = AbstractC6756Ov5.d(c6517Nv5W, null, this, 1, null);
                    if (objD == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    objD = ((C9475a16) obj).l();
                }
                if (C9475a16.j(objD)) {
                    C12889fL5 c12889fL5 = this.e;
                    List listM = AbstractC10360bX0.m();
                    if (C9475a16.g(objD)) {
                        objD = listM;
                    }
                    AbstractC13042fc3.h(objD, "getOrDefault(...)");
                    Iterable<C23464wy> iterable = (Iterable) objD;
                    ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(iterable, 10));
                    for (C23464wy c23464wy : iterable) {
                        AbstractC13042fc3.f(c23464wy);
                        arrayList.add(C18732p92.h(c23464wy));
                    }
                    c12889fL5.a = arrayList;
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C8272Vg3.this.new b(interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x00d6  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00f0  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r39) {
            /*
                Method dump skipped, instructions count: 438
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C8272Vg3.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Vg3$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        final /* synthetic */ NJ5 d;
        final /* synthetic */ C8272Vg3 e;

        /* renamed from: ir.nasim.Vg3$c$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C8272Vg3 c;
            final /* synthetic */ List d;
            final /* synthetic */ C12889fL5 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C8272Vg3 c8272Vg3, List list, C12889fL5 c12889fL5, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c8272Vg3;
                this.d = list;
                this.e = c12889fL5;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, this.e, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objD;
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    C6517Nv5 c6517Nv5W = this.c.d.W(this.d);
                    AbstractC13042fc3.h(c6517Nv5W, "forceLoadRequiredGroupPeers(...)");
                    this.b = 1;
                    objD = AbstractC6756Ov5.d(c6517Nv5W, null, this, 1, null);
                    if (objD == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    objD = ((C9475a16) obj).l();
                }
                if (C9475a16.j(objD)) {
                    C12889fL5 c12889fL5 = this.e;
                    List listM = AbstractC10360bX0.m();
                    if (C9475a16.g(objD)) {
                        objD = listM;
                    }
                    AbstractC13042fc3.h(objD, "getOrDefault(...)");
                    Iterable<C23464wy> iterable = (Iterable) objD;
                    ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(iterable, 10));
                    for (C23464wy c23464wy : iterable) {
                        AbstractC13042fc3.f(c23464wy);
                        arrayList.add(C18732p92.h(c23464wy));
                    }
                    c12889fL5.a = arrayList;
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(NJ5 nj5, C8272Vg3 c8272Vg3, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = nj5;
            this.e = c8272Vg3;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new c(this.d, this.e, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x00e2  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00fc  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r39) {
            /*
                Method dump skipped, instructions count: 450
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C8272Vg3.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C8272Vg3(AbstractC13778go1 abstractC13778go1, C6287Mz c6287Mz, UG7 ug7) {
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(c6287Mz, "apiModule");
        AbstractC13042fc3.i(ug7, "updateModule");
        this.b = abstractC13778go1;
        this.c = c6287Mz;
        this.d = ug7;
        this.e = AbstractC12281eL6.a(new ArrayList());
        this.f = AbstractC12281eL6.a(new ArrayList());
    }

    @Override // ir.nasim.InterfaceC8038Ug3
    public InterfaceC9336Zm4 a() {
        return this.e;
    }

    @Override // ir.nasim.InterfaceC8038Ug3
    public Object b(InterfaceC20295rm1 interfaceC20295rm1) {
        Object objG = AbstractC9323Zl0.g(this.b, new b(null), interfaceC20295rm1);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC8038Ug3
    public InterfaceC9336Zm4 c() {
        return this.f;
    }

    @Override // ir.nasim.InterfaceC8038Ug3
    public Object d(NJ5 nj5, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objG = AbstractC9323Zl0.g(this.b, new c(nj5, this, null), interfaceC20295rm1);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }
}
