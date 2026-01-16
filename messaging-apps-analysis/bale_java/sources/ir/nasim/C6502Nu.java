package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.Nu, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C6502Nu extends VW7 {
    private final KM2 b;
    private final AbstractC13778go1 c;
    private final InterfaceC9336Zm4 d;
    private final InterfaceC10258bL6 e;

    /* renamed from: ir.nasim.Nu$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        final /* synthetic */ List e;

        /* renamed from: ir.nasim.Nu$a$a, reason: collision with other inner class name */
        static final class C0542a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            Object b;
            int c;
            private /* synthetic */ Object d;
            final /* synthetic */ List e;
            final /* synthetic */ C6502Nu f;

            /* renamed from: ir.nasim.Nu$a$a$a, reason: collision with other inner class name */
            static final class C0543a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ C6502Nu c;
                final /* synthetic */ int d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0543a(C6502Nu c6502Nu, int i, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = c6502Nu;
                    this.d = i;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new C0543a(this.c, this.d, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        KM2 km2 = this.c.b;
                        long j = this.d;
                        this.b = 1;
                        obj = km2.l(j, this);
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
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C0543a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0542a(List list, C6502Nu c6502Nu, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.e = list;
                this.f = c6502Nu;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                C0542a c0542a = new C0542a(this.e, this.f, interfaceC20295rm1);
                c0542a.d = obj;
                return c0542a;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x006d  */
            /* JADX WARN: Removed duplicated region for block: B:20:0x0084  */
            /* JADX WARN: Removed duplicated region for block: B:21:0x0088  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x007d -> B:18:0x0080). Please report as a decompilation issue!!! */
            @Override // ir.nasim.E90
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r12) {
                /*
                    r11 = this;
                    java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                    int r1 = r11.c
                    r2 = 1
                    if (r1 == 0) goto L1f
                    if (r1 != r2) goto L17
                    java.lang.Object r1 = r11.b
                    java.util.Iterator r1 = (java.util.Iterator) r1
                    java.lang.Object r3 = r11.d
                    java.util.Collection r3 = (java.util.Collection) r3
                    ir.nasim.AbstractC10685c16.b(r12)
                    goto L80
                L17:
                    java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r12.<init>(r0)
                    throw r12
                L1f:
                    ir.nasim.AbstractC10685c16.b(r12)
                    java.lang.Object r12 = r11.d
                    ir.nasim.ro1 r12 = (ir.nasim.InterfaceC20315ro1) r12
                    java.util.List r1 = r11.e
                    java.lang.Iterable r1 = (java.lang.Iterable) r1
                    ir.nasim.Nu r9 = r11.f
                    java.util.ArrayList r10 = new java.util.ArrayList
                    r3 = 10
                    int r3 = ir.nasim.ZW0.x(r1, r3)
                    r10.<init>(r3)
                    java.util.Iterator r1 = r1.iterator()
                L3b:
                    boolean r3 = r1.hasNext()
                    if (r3 == 0) goto L5d
                    java.lang.Object r3 = r1.next()
                    java.lang.Number r3 = (java.lang.Number) r3
                    int r3 = r3.intValue()
                    ir.nasim.Nu$a$a$a r6 = new ir.nasim.Nu$a$a$a
                    r4 = 0
                    r6.<init>(r9, r3, r4)
                    r7 = 3
                    r8 = 0
                    r5 = 0
                    r3 = r12
                    ir.nasim.zG1 r3 = ir.nasim.AbstractC9323Zl0.b(r3, r4, r5, r6, r7, r8)
                    r10.add(r3)
                    goto L3b
                L5d:
                    java.util.ArrayList r12 = new java.util.ArrayList
                    r12.<init>()
                    java.util.Iterator r1 = r10.iterator()
                    r3 = r12
                L67:
                    boolean r12 = r1.hasNext()
                    if (r12 == 0) goto L88
                    java.lang.Object r12 = r1.next()
                    ir.nasim.zG1 r12 = (ir.nasim.InterfaceC24823zG1) r12
                    r11.d = r3
                    r11.b = r1
                    r11.c = r2
                    java.lang.Object r12 = r12.y(r11)
                    if (r12 != r0) goto L80
                    return r0
                L80:
                    ir.nasim.iL2 r12 = (ir.nasim.C14697iL2) r12
                    if (r12 == 0) goto L67
                    r3.add(r12)
                    goto L67
                L88:
                    java.util.List r3 = (java.util.List) r3
                    return r3
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6502Nu.a.C0542a.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C0542a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(List list, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = list;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6502Nu.this.new a(this.e, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0067 A[RETURN] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r7.c
                r2 = 0
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L2f
                if (r1 == r5) goto L26
                if (r1 == r4) goto L1e
                if (r1 != r3) goto L16
                ir.nasim.AbstractC10685c16.b(r8)
                goto L68
            L16:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L1e:
                java.lang.Object r1 = r7.b
                ir.nasim.Zm4 r1 = (ir.nasim.InterfaceC9336Zm4) r1
                ir.nasim.AbstractC10685c16.b(r8)
                goto L5d
            L26:
                ir.nasim.AbstractC10685c16.b(r8)
                ir.nasim.a16 r8 = (ir.nasim.C9475a16) r8
                r8.l()
                goto L43
            L2f:
                ir.nasim.AbstractC10685c16.b(r8)
                ir.nasim.Nu r8 = ir.nasim.C6502Nu.this
                ir.nasim.KM2 r8 = ir.nasim.C6502Nu.P0(r8)
                java.util.List r1 = r7.e
                r7.c = r5
                java.lang.Object r8 = r8.k(r1, r7)
                if (r8 != r0) goto L43
                return r0
            L43:
                ir.nasim.Nu r8 = ir.nasim.C6502Nu.this
                ir.nasim.Zm4 r1 = ir.nasim.C6502Nu.R0(r8)
                ir.nasim.Nu$a$a r8 = new ir.nasim.Nu$a$a
                java.util.List r5 = r7.e
                ir.nasim.Nu r6 = ir.nasim.C6502Nu.this
                r8.<init>(r5, r6, r2)
                r7.b = r1
                r7.c = r4
                java.lang.Object r8 = ir.nasim.AbstractC20906so1.e(r8, r7)
                if (r8 != r0) goto L5d
                return r0
            L5d:
                r7.b = r2
                r7.c = r3
                java.lang.Object r8 = r1.a(r8, r7)
                if (r8 != r0) goto L68
                return r0
            L68:
                ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6502Nu.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C6502Nu(KM2 km2, AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(km2, "groupRepository");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        this.b = km2;
        this.c = abstractC13778go1;
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(new ArrayList());
        this.d = interfaceC9336Zm4A;
        this.e = interfaceC9336Zm4A;
    }

    public final InterfaceC10258bL6 S0() {
        return this.e;
    }

    public final void T0(List list) {
        AbstractC13042fc3.i(list, "groupList");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), this.c, null, new a(list, null), 2, null);
    }
}
