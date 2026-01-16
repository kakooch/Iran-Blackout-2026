package ir.nasim;

import ir.nasim.C24303yO3;
import ir.nasim.DX4;
import ir.nasim.EX4;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.InterfaceC22028uY4;
import ir.nasim.KO3;
import ir.nasim.core.modules.settings.SettingsModule;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes6.dex */
public final class TY4 extends VW7 {
    public static final a n = new a(null);
    public static final int o = 8;
    private final androidx.lifecycle.y b;
    private final InterfaceC20760sZ4 c;
    private final C5220Ik2 d;
    private final SettingsModule e;
    private final KO3.a f;
    private final C3607Bo6 g;
    private final InterfaceC9336Zm4 h;
    private String i;
    private String j;
    private String k;
    private final InterfaceC9173Yu3 l;
    private final Map m;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ BX4 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(BX4 bx4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = bx4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return TY4.this.new b(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                this.b = 1;
                if (HG1.b(300L, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            TY4.this.y1(this.d);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return TY4.this.new c(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE;
            Object value;
            OY4 oy4;
            Object value2;
            OY4 oy42;
            Object objE2 = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20760sZ4 interfaceC20760sZ4 = TY4.this.c;
                String str = TY4.this.i;
                if (str == null) {
                    str = "";
                }
                this.b = 1;
                objE = interfaceC20760sZ4.e(str, this);
                if (objE == objE2) {
                    return objE2;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objE = ((C9475a16) obj).l();
            }
            TY4 ty4 = TY4.this;
            if (C9475a16.j(objE)) {
                ty4.e.k7(true);
                InterfaceC9336Zm4 interfaceC9336Zm4 = ty4.h;
                do {
                    value2 = interfaceC9336Zm4.getValue();
                    oy42 = (OY4) value2;
                } while (!interfaceC9336Zm4.f(value2, oy42.a((237 & 1) != 0 ? oy42.a : null, (237 & 2) != 0 ? oy42.b : null, (237 & 4) != 0 ? oy42.c : null, (237 & 8) != 0 ? oy42.d : null, (237 & 16) != 0 ? oy42.e : EnumC21371tY4.c, (237 & 32) != 0 ? oy42.f : null, (237 & 64) != 0 ? oy42.g : null, (237 & 128) != 0 ? oy42.h : null)));
            }
            TY4 ty42 = TY4.this;
            Throwable thE = C9475a16.e(objE);
            if (thE != null) {
                C19406qI3.b("PASSPORT", "Failed to save passport info for linkId: " + ty42.i + ". Error: " + thE.getMessage());
                InterfaceC9336Zm4 interfaceC9336Zm42 = ty42.h;
                do {
                    value = interfaceC9336Zm42.getValue();
                    oy4 = (OY4) value;
                } while (!interfaceC9336Zm42.f(value, oy4.a((237 & 1) != 0 ? oy4.a : null, (237 & 2) != 0 ? oy4.b : null, (237 & 4) != 0 ? oy4.c : null, (237 & 8) != 0 ? oy4.d : null, (237 & 16) != 0 ? oy4.e : null, (237 & 32) != 0 ? oy4.f : null, (237 & 64) != 0 ? oy4.g : MY4.b, (237 & 128) != 0 ? oy4.h : null)));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return TY4.this.new d(interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0069  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x019e  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r22) {
            /*
                Method dump skipped, instructions count: 479
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.TY4.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ BX4 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(BX4 bx4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = bx4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return TY4.this.new e(this.d, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x006f  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x007f  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                r14 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r14.b
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L24
                if (r1 == r3) goto L20
                if (r1 != r2) goto L18
                ir.nasim.AbstractC10685c16.b(r15)
                ir.nasim.a16 r15 = (ir.nasim.C9475a16) r15
                java.lang.Object r15 = r15.l()
                goto L67
            L18:
                java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r15.<init>(r0)
                throw r15
            L20:
                ir.nasim.AbstractC10685c16.b(r15)
                goto L48
            L24:
                ir.nasim.AbstractC10685c16.b(r15)
                ir.nasim.TY4 r15 = ir.nasim.TY4.this
                ir.nasim.BX4 r4 = r14.d
                ir.nasim.DX4$c r8 = ir.nasim.DX4.c.a
                r12 = 119(0x77, float:1.67E-43)
                r13 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                ir.nasim.BX4 r1 = ir.nasim.BX4.b(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
                ir.nasim.TY4.h1(r15, r1)
                r14.b = r3
                r3 = 300(0x12c, double:1.48E-321)
                java.lang.Object r15 = ir.nasim.HG1.b(r3, r14)
                if (r15 != r0) goto L48
                return r0
            L48:
                ir.nasim.TY4 r15 = ir.nasim.TY4.this
                ir.nasim.sZ4 r15 = ir.nasim.TY4.X0(r15)
                ir.nasim.BX4 r1 = r14.d
                int r1 = r1.d()
                ir.nasim.BX4 r3 = r14.d
                ir.nasim.EX4 r3 = r3.i()
                java.lang.String r4 = ir.nasim.PH3.d()
                r14.b = r2
                java.lang.Object r15 = r15.c(r1, r3, r4, r14)
                if (r15 != r0) goto L67
                return r0
            L67:
                ir.nasim.TY4 r0 = ir.nasim.TY4.this
                boolean r1 = ir.nasim.C9475a16.j(r15)
                if (r1 == 0) goto L75
                r1 = r15
                ir.nasim.BX4 r1 = (ir.nasim.BX4) r1
                ir.nasim.TY4.h1(r0, r1)
            L75:
                ir.nasim.TY4 r0 = ir.nasim.TY4.this
                ir.nasim.BX4 r1 = r14.d
                java.lang.Throwable r15 = ir.nasim.C9475a16.e(r15)
                if (r15 == 0) goto Lab
                int r15 = r1.d()
                ir.nasim.BX4 r15 = ir.nasim.TY4.U0(r0, r15)
                if (r15 == 0) goto L8e
                ir.nasim.DX4 r15 = r15.g()
                goto L8f
            L8e:
                r15 = 0
            L8f:
                boolean r2 = r15 instanceof ir.nasim.DX4.c
                if (r2 != 0) goto L98
                if (r15 != 0) goto L96
                goto L98
            L96:
                r5 = r15
                goto L9b
            L98:
                ir.nasim.DX4$a r15 = ir.nasim.DX4.a.a
                goto L96
            L9b:
                r9 = 119(0x77, float:1.67E-43)
                r10 = 0
                r2 = 0
                r3 = 0
                r4 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                ir.nasim.BX4 r15 = ir.nasim.BX4.b(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
                ir.nasim.TY4.h1(r0, r15)
            Lab:
                ir.nasim.rB7 r15 = ir.nasim.C19938rB7.a
                return r15
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.TY4.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return TY4.this.new f(interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x0094  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x013a  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r19) {
            /*
                Method dump skipped, instructions count: 388
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.TY4.f.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public TY4(androidx.lifecycle.y yVar, InterfaceC20760sZ4 interfaceC20760sZ4, C5220Ik2 c5220Ik2, SettingsModule settingsModule, KO3.a aVar, C3607Bo6 c3607Bo6) {
        AbstractC13042fc3.i(yVar, "savedStateHandle");
        AbstractC13042fc3.i(interfaceC20760sZ4, "passportRepository");
        AbstractC13042fc3.i(c5220Ik2, "fieldValidator");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(aVar, "markWonHandlerFactory");
        AbstractC13042fc3.i(c3607Bo6, "sendPassportAnalyticsUseCase");
        this.b = yVar;
        this.c = interfaceC20760sZ4;
        this.d = c5220Ik2;
        this.e = settingsModule;
        this.f = aVar;
        this.g = c3607Bo6;
        this.h = AbstractC12281eL6.a(new OY4(null, null, null, null, null, null, null, null, 255, null));
        this.l = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.SY4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return TY4.x1(this.a);
            }
        });
        this.m = new LinkedHashMap();
        w1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 F1(TY4 ty4, BX4 bx4, EX4.a aVar, long j) {
        Object value;
        OY4 oy4;
        AbstractC13042fc3.i(ty4, "this$0");
        AbstractC13042fc3.i(bx4, "$field");
        AbstractC13042fc3.i(aVar, "$fieldType");
        InterfaceC9336Zm4 interfaceC9336Zm4 = ty4.h;
        do {
            value = interfaceC9336Zm4.getValue();
            oy4 = (OY4) value;
        } while (!interfaceC9336Zm4.f(value, oy4.a((237 & 1) != 0 ? oy4.a : null, (237 & 2) != 0 ? oy4.b : null, (237 & 4) != 0 ? oy4.c : null, (237 & 8) != 0 ? oy4.d : null, (237 & 16) != 0 ? oy4.e : null, (237 & 32) != 0 ? oy4.f : null, (237 & 64) != 0 ? oy4.g : null, (237 & 128) != 0 ? oy4.h : null)));
        ty4.o1(bx4, aVar, j);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 G1(TY4 ty4) {
        Object value;
        OY4 oy4;
        AbstractC13042fc3.i(ty4, "this$0");
        InterfaceC9336Zm4 interfaceC9336Zm4 = ty4.h;
        do {
            value = interfaceC9336Zm4.getValue();
            oy4 = (OY4) value;
        } while (!interfaceC9336Zm4.f(value, oy4.a((237 & 1) != 0 ? oy4.a : null, (237 & 2) != 0 ? oy4.b : null, (237 & 4) != 0 ? oy4.c : null, (237 & 8) != 0 ? oy4.d : null, (237 & 16) != 0 ? oy4.e : null, (237 & 32) != 0 ? oy4.f : null, (237 & 64) != 0 ? oy4.g : null, (237 & 128) != 0 ? oy4.h : null)));
        return C19938rB7.a;
    }

    private final void H1() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new f(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I1(final BX4 bx4) {
        K1(bx4.d(), new UA2() { // from class: ir.nasim.PY4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return TY4.J1(bx4, (BX4) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BX4 J1(BX4 bx4, BX4 bx42) {
        AbstractC13042fc3.i(bx4, "$field");
        AbstractC13042fc3.i(bx42, "it");
        return bx4;
    }

    private final void K1(int i, UA2 ua2) {
        Object value;
        OY4 oy4;
        ArrayList arrayList;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.h;
        do {
            value = interfaceC9336Zm4.getValue();
            oy4 = (OY4) value;
            List<CX4> listD = oy4.f().d();
            arrayList = new ArrayList(AbstractC10976cX0.x(listD, 10));
            for (CX4 cx4 : listD) {
                List<BX4> listC = cx4.c();
                ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(listC, 10));
                for (BX4 bx4 : listC) {
                    if (bx4.d() == i) {
                        bx4 = (BX4) ua2.invoke(bx4);
                    }
                    arrayList2.add(bx4);
                }
                arrayList.add(CX4.b(cx4, null, false, arrayList2, 3, null));
            }
        } while (!interfaceC9336Zm4.f(value, oy4.a((237 & 1) != 0 ? oy4.a : C19777qv2.b(oy4.f(), arrayList, null, 2, null), (237 & 2) != 0 ? oy4.b : null, (237 & 4) != 0 ? oy4.c : null, (237 & 8) != 0 ? oy4.d : null, (237 & 16) != 0 ? oy4.e : null, (237 & 32) != 0 ? oy4.f : null, (237 & 64) != 0 ? oy4.g : null, (237 & 128) != 0 ? oy4.h : null)));
    }

    private final void j1(BX4 bx4) {
        InterfaceC13730gj3 interfaceC13730gj3 = (InterfaceC13730gj3) this.m.get(Integer.valueOf(bx4.d()));
        if (interfaceC13730gj3 != null) {
            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
        }
        this.m.put(Integer.valueOf(bx4.d()), AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new b(bx4, null), 3, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BX4 k1(int i) {
        Object next;
        List listD = ((OY4) this.h.getValue()).f().d();
        ArrayList arrayList = new ArrayList();
        Iterator it = listD.iterator();
        while (it.hasNext()) {
            AbstractC13610gX0.D(arrayList, ((CX4) it.next()).c());
        }
        Iterator it2 = arrayList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            if (((BX4) next).d() == i) {
                break;
            }
        }
        return (BX4) next;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final KO3 l1() {
        return (KO3) this.l.getValue();
    }

    private final void o1(BX4 bx4, EX4.a aVar, long j) {
        EX4.a aVarB = EX4.a.b(aVar, Long.valueOf(j), null, null, 6, null);
        I1(BX4.b(bx4, 0, null, null, null, false, aVarB, false, 95, null));
        s1(bx4, aVarB);
    }

    private final void p1() {
        i1();
    }

    private final void s1(BX4 bx4, EX4 ex4) {
        DX4 bVar;
        AbstractC11684dQ7 abstractC11684dQ7B = this.d.b(ex4);
        if (abstractC11684dQ7B != null) {
            bVar = new DX4.b(abstractC11684dQ7B);
        } else {
            if (bx4.e()) {
                j1(BX4.b(bx4, 0, null, null, DX4.a.a, false, ex4, false, 87, null));
            }
            bVar = DX4.a.a;
        }
        I1(BX4.b(bx4, 0, null, null, bVar, false, ex4, false, 87, null));
    }

    private final void t1() {
        Object value;
        OY4 oy4;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.h;
        do {
            value = interfaceC9336Zm4.getValue();
            oy4 = (OY4) value;
        } while (!interfaceC9336Zm4.f(value, oy4.a((237 & 1) != 0 ? oy4.a : null, (237 & 2) != 0 ? oy4.b : null, (237 & 4) != 0 ? oy4.c : null, (237 & 8) != 0 ? oy4.d : new C20751sY4(this.j), (237 & 16) != 0 ? oy4.e : null, (237 & 32) != 0 ? oy4.f : null, (237 & 64) != 0 ? oy4.g : null, (237 & 128) != 0 ? oy4.h : null)));
    }

    private final void u1(boolean z) {
        Object value;
        OY4 oy4;
        Object value2;
        OY4 oy42;
        if (!z) {
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.h;
            do {
                value = interfaceC9336Zm4.getValue();
                oy4 = (OY4) value;
            } while (!interfaceC9336Zm4.f(value, oy4.a((237 & 1) != 0 ? oy4.a : null, (237 & 2) != 0 ? oy4.b : null, (237 & 4) != 0 ? oy4.c : null, (237 & 8) != 0 ? oy4.d : new C20751sY4(this.j), (237 & 16) != 0 ? oy4.e : null, (237 & 32) != 0 ? oy4.f : null, (237 & 64) != 0 ? oy4.g : null, (237 & 128) != 0 ? oy4.h : null)));
            return;
        }
        InterfaceC9336Zm4 interfaceC9336Zm42 = this.h;
        do {
            value2 = interfaceC9336Zm42.getValue();
            oy42 = (OY4) value2;
        } while (!interfaceC9336Zm42.f(value2, oy42.a((237 & 1) != 0 ? oy42.a : null, (237 & 2) != 0 ? oy42.b : AY4.b, (237 & 4) != 0 ? oy42.c : null, (237 & 8) != 0 ? oy42.d : null, (237 & 16) != 0 ? oy42.e : null, (237 & 32) != 0 ? oy42.f : null, (237 & 64) != 0 ? oy42.g : null, (237 & 128) != 0 ? oy42.h : null)));
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new c(null), 3, null);
    }

    private final void v1() {
        Object value;
        OY4 oy4;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.h;
        do {
            value = interfaceC9336Zm4.getValue();
            oy4 = (OY4) value;
        } while (!interfaceC9336Zm4.f(value, oy4.a((237 & 1) != 0 ? oy4.a : null, (237 & 2) != 0 ? oy4.b : null, (237 & 4) != 0 ? oy4.c : null, (237 & 8) != 0 ? oy4.d : null, (237 & 16) != 0 ? oy4.e : null, (237 & 32) != 0 ? oy4.f : null, (237 & 64) != 0 ? oy4.g : null, (237 & 128) != 0 ? oy4.h : this.e.y4())));
    }

    private final void w1() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new d(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KO3 x1(TY4 ty4) {
        AbstractC13042fc3.i(ty4, "this$0");
        KO3.a aVar = ty4.f;
        C24303yO3.a aVar2 = new C24303yO3.a();
        Boolean bool = Boolean.TRUE;
        return aVar.a(aVar2.l(bool).e(Boolean.FALSE).h(bool).g(bool).c(bool).i(bool).a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y1(BX4 bx4) {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new e(bx4, null), 3, null);
    }

    private final void z1() {
        Object value;
        OY4 oy4;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.h;
        do {
            value = interfaceC9336Zm4.getValue();
            oy4 = (OY4) value;
        } while (!interfaceC9336Zm4.f(value, oy4.a((237 & 1) != 0 ? oy4.a : null, (237 & 2) != 0 ? oy4.b : null, (237 & 4) != 0 ? oy4.c : null, (237 & 8) != 0 ? oy4.d : new C20751sY4(this.k), (237 & 16) != 0 ? oy4.e : null, (237 & 32) != 0 ? oy4.f : null, (237 & 64) != 0 ? oy4.g : null, (237 & 128) != 0 ? oy4.h : null)));
    }

    public final void A1() {
        Object value;
        OY4 oy4;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.h;
        do {
            value = interfaceC9336Zm4.getValue();
            oy4 = (OY4) value;
        } while (!interfaceC9336Zm4.f(value, oy4.a((237 & 1) != 0 ? oy4.a : null, (237 & 2) != 0 ? oy4.b : null, (237 & 4) != 0 ? oy4.c : null, (237 & 8) != 0 ? oy4.d : null, (237 & 16) != 0 ? oy4.e : null, (237 & 32) != 0 ? oy4.f : null, (237 & 64) != 0 ? oy4.g : null, (237 & 128) != 0 ? oy4.h : null)));
    }

    public final void B1() {
        Object value;
        OY4 oy4;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.h;
        do {
            value = interfaceC9336Zm4.getValue();
            oy4 = (OY4) value;
        } while (!interfaceC9336Zm4.f(value, oy4.a((237 & 1) != 0 ? oy4.a : null, (237 & 2) != 0 ? oy4.b : null, (237 & 4) != 0 ? oy4.c : null, (237 & 8) != 0 ? oy4.d : null, (237 & 16) != 0 ? oy4.e : null, (237 & 32) != 0 ? oy4.f : null, (237 & 64) != 0 ? oy4.g : null, (237 & 128) != 0 ? oy4.h : null)));
    }

    public final void C1() {
        Object value;
        OY4 oy4;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.h;
        do {
            value = interfaceC9336Zm4.getValue();
            oy4 = (OY4) value;
        } while (!interfaceC9336Zm4.f(value, oy4.a((237 & 1) != 0 ? oy4.a : null, (237 & 2) != 0 ? oy4.b : null, (237 & 4) != 0 ? oy4.c : null, (237 & 8) != 0 ? oy4.d : null, (237 & 16) != 0 ? oy4.e : null, (237 & 32) != 0 ? oy4.f : null, (237 & 64) != 0 ? oy4.g : null, (237 & 128) != 0 ? oy4.h : null)));
    }

    public final void D1() {
        this.g.a(EnumC23205wX4.e);
    }

    public final void E1(final BX4 bx4, final EX4.a aVar) {
        Object value;
        OY4 oy4;
        String strH;
        String strH2;
        AbstractC11684dQ7 abstractC11684dQ7A;
        long timeInMillis;
        long timeInMillis2;
        long timeInMillis3;
        AbstractC13042fc3.i(bx4, "field");
        AbstractC13042fc3.i(aVar, "fieldType");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.h;
        do {
            value = interfaceC9336Zm4.getValue();
            oy4 = (OY4) value;
            strH = bx4.h();
            strH2 = bx4.h();
            DX4 dx4G = bx4.g();
            DX4.b bVar = dx4G instanceof DX4.b ? (DX4.b) dx4G : null;
            abstractC11684dQ7A = bVar != null ? bVar.a() : null;
            Long lD = aVar.d();
            if (lD != null) {
                timeInMillis = lD.longValue();
            } else {
                Calendar calendar = Calendar.getInstance();
                calendar.add(1, -100);
                C19938rB7 c19938rB7 = C19938rB7.a;
                timeInMillis = calendar.getTimeInMillis();
            }
            Long lC = aVar.c();
            if (lC != null) {
                timeInMillis2 = lC.longValue();
            } else {
                Calendar calendar2 = Calendar.getInstance();
                calendar2.add(1, 100);
                C19938rB7 c19938rB72 = C19938rB7.a;
                timeInMillis2 = calendar2.getTimeInMillis();
            }
            Long lE = aVar.e();
            if (lE != null) {
                timeInMillis3 = lE.longValue();
            } else {
                Calendar calendar3 = Calendar.getInstance();
                calendar3.add(6, -1);
                C19938rB7 c19938rB73 = C19938rB7.a;
                timeInMillis3 = calendar3.getTimeInMillis();
            }
        } while (!interfaceC9336Zm4.f(value, oy4.a((237 & 1) != 0 ? oy4.a : null, (237 & 2) != 0 ? oy4.b : null, (237 & 4) != 0 ? oy4.c : new IA1(strH, strH2, abstractC11684dQ7A, timeInMillis, timeInMillis2, timeInMillis3, new UA2() { // from class: ir.nasim.QY4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return TY4.F1(this.a, bx4, aVar, ((Long) obj).longValue());
            }
        }, new SA2() { // from class: ir.nasim.RY4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return TY4.G1(this.a);
            }
        }), (237 & 8) != 0 ? oy4.d : null, (237 & 16) != 0 ? oy4.e : null, (237 & 32) != 0 ? oy4.f : null, (237 & 64) != 0 ? oy4.g : null, (237 & 128) != 0 ? oy4.h : null)));
    }

    public final void i1() {
        Object value;
        OY4 oy4;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.h;
        do {
            value = interfaceC9336Zm4.getValue();
            oy4 = (OY4) value;
        } while (!interfaceC9336Zm4.f(value, oy4.a((237 & 1) != 0 ? oy4.a : null, (237 & 2) != 0 ? oy4.b : null, (237 & 4) != 0 ? oy4.c : null, (237 & 8) != 0 ? oy4.d : new C20751sY4(this.k), (237 & 16) != 0 ? oy4.e : null, (237 & 32) != 0 ? oy4.f : null, (237 & 64) != 0 ? oy4.g : null, (237 & 128) != 0 ? oy4.h : null)));
    }

    public final InterfaceC10258bL6 m1() {
        return this.h;
    }

    public final void q1(InterfaceC22028uY4 interfaceC22028uY4) {
        AbstractC13042fc3.i(interfaceC22028uY4, "event");
        if (interfaceC22028uY4 instanceof InterfaceC22028uY4.d) {
            InterfaceC22028uY4.d dVar = (InterfaceC22028uY4.d) interfaceC22028uY4;
            s1(dVar.a(), dVar.b());
            return;
        }
        if (interfaceC22028uY4 instanceof InterfaceC22028uY4.a) {
            InterfaceC22028uY4.a aVar = (InterfaceC22028uY4.a) interfaceC22028uY4;
            E1(aVar.a(), aVar.b());
            return;
        }
        if (interfaceC22028uY4 instanceof InterfaceC22028uY4.f) {
            u1(((InterfaceC22028uY4.f) interfaceC22028uY4).a());
            return;
        }
        if (AbstractC13042fc3.d(interfaceC22028uY4, InterfaceC22028uY4.h.a)) {
            H1();
            return;
        }
        if (AbstractC13042fc3.d(interfaceC22028uY4, InterfaceC22028uY4.b.a)) {
            z1();
            return;
        }
        if (AbstractC13042fc3.d(interfaceC22028uY4, InterfaceC22028uY4.e.a)) {
            t1();
        } else if (AbstractC13042fc3.d(interfaceC22028uY4, InterfaceC22028uY4.g.a)) {
            v1();
        } else {
            if (!AbstractC13042fc3.d(interfaceC22028uY4, InterfaceC22028uY4.c.a)) {
                throw new NoWhenBranchMatchedException();
            }
            p1();
        }
    }
}
