package ir.nasim;

import ir.nasim.DX4;
import ir.nasim.EX4;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.WX4;
import ir.nasim.core.modules.settings.SettingsModule;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.qY4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C19551qY4 extends VW7 {
    public static final a i = new a(null);
    public static final int j = 8;
    private final InterfaceC20760sZ4 b;
    private final C5220Ik2 c;
    private final SettingsModule d;
    private final C3607Bo6 e;
    private final InterfaceC9336Zm4 f;
    private final Integer g;
    private final Map h;

    /* renamed from: ir.nasim.qY4$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.qY4$b */
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
            return C19551qY4.this.new b(this.d, interfaceC20295rm1);
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
            C19551qY4.this.i1(this.d);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.qY4$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C19551qY4.this.new c(interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x0092  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00cd  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r20) {
            /*
                Method dump skipped, instructions count: 265
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C19551qY4.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.qY4$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ BX4 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(BX4 bx4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = bx4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C19551qY4.this.new d(this.d, interfaceC20295rm1);
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
                ir.nasim.qY4 r15 = ir.nasim.C19551qY4.this
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
                ir.nasim.C19551qY4.Z0(r15, r1)
                r14.b = r3
                r3 = 300(0x12c, double:1.48E-321)
                java.lang.Object r15 = ir.nasim.HG1.b(r3, r14)
                if (r15 != r0) goto L48
                return r0
            L48:
                ir.nasim.qY4 r15 = ir.nasim.C19551qY4.this
                ir.nasim.sZ4 r15 = ir.nasim.C19551qY4.V0(r15)
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
                ir.nasim.qY4 r0 = ir.nasim.C19551qY4.this
                boolean r1 = ir.nasim.C9475a16.j(r15)
                if (r1 == 0) goto L75
                r1 = r15
                ir.nasim.BX4 r1 = (ir.nasim.BX4) r1
                ir.nasim.C19551qY4.Z0(r0, r1)
            L75:
                ir.nasim.qY4 r0 = ir.nasim.C19551qY4.this
                ir.nasim.BX4 r1 = r14.d
                java.lang.Throwable r15 = ir.nasim.C9475a16.e(r15)
                if (r15 == 0) goto Lab
                int r15 = r1.d()
                ir.nasim.BX4 r15 = ir.nasim.C19551qY4.T0(r0, r15)
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
                ir.nasim.C19551qY4.Z0(r0, r15)
            Lab:
                ir.nasim.rB7 r15 = ir.nasim.C19938rB7.a
                return r15
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C19551qY4.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.qY4$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C19551qY4.this.new e(interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x00ab  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x0141  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r25) {
            /*
                Method dump skipped, instructions count: 383
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C19551qY4.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C19551qY4(InterfaceC20760sZ4 interfaceC20760sZ4, C5220Ik2 c5220Ik2, SettingsModule settingsModule, C3607Bo6 c3607Bo6, androidx.lifecycle.y yVar) {
        AbstractC13042fc3.i(interfaceC20760sZ4, "passportRepository");
        AbstractC13042fc3.i(c5220Ik2, "fieldValidator");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(c3607Bo6, "sendPassportAnalyticsUseCase");
        AbstractC13042fc3.i(yVar, "savedStateHandle");
        this.b = interfaceC20760sZ4;
        this.c = c5220Ik2;
        this.d = settingsModule;
        this.e = c3607Bo6;
        this.f = AbstractC12281eL6.a(new C17187mY4(null, null, null, false, null, null, null, null, 255, null));
        this.g = (Integer) yVar.c("arg_group_id");
        this.h = new LinkedHashMap();
        h1();
    }

    private final void a1(BX4 bx4) {
        InterfaceC13730gj3 interfaceC13730gj3 = (InterfaceC13730gj3) this.h.get(Integer.valueOf(bx4.d()));
        if (interfaceC13730gj3 != null) {
            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
        }
        this.h.put(Integer.valueOf(bx4.d()), AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new b(bx4, null), 3, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BX4 b1(int i2) {
        Object next;
        Iterator it = ((CX4) AbstractC15401jX0.q0(((C17187mY4) this.f.getValue()).f().d())).c().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((BX4) next).d() == i2) {
                break;
            }
        }
        return (BX4) next;
    }

    private final void d1(BX4 bx4, EX4.a aVar, long j2) {
        EX4.a aVarB = EX4.a.b(aVar, Long.valueOf(j2), null, null, 6, null);
        s1(BX4.b(bx4, 0, null, null, null, false, aVarB, false, 95, null));
        f1(bx4, aVarB);
    }

    private final void f1(BX4 bx4, EX4 ex4) {
        DX4 bVar;
        AbstractC11684dQ7 abstractC11684dQ7B = this.c.b(ex4);
        if (abstractC11684dQ7B != null) {
            bVar = new DX4.b(abstractC11684dQ7B);
        } else {
            if (bx4.e()) {
                a1(BX4.b(bx4, 0, null, null, DX4.a.a, false, ex4, false, 87, null));
            }
            bVar = DX4.a.a;
        }
        s1(BX4.b(bx4, 0, null, null, bVar, false, ex4, false, 87, null));
    }

    private final void g1() {
        Object value;
        C17187mY4 c17187mY4;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.f;
        do {
            value = interfaceC9336Zm4.getValue();
            c17187mY4 = (C17187mY4) value;
        } while (!interfaceC9336Zm4.f(value, c17187mY4.a((252 & 1) != 0 ? c17187mY4.a : null, (252 & 2) != 0 ? c17187mY4.b : null, (252 & 4) != 0 ? c17187mY4.c : null, (252 & 8) != 0 ? c17187mY4.d : false, (252 & 16) != 0 ? c17187mY4.e : null, (252 & 32) != 0 ? c17187mY4.f : null, (252 & 64) != 0 ? c17187mY4.g : null, (252 & 128) != 0 ? c17187mY4.h : this.d.y4())));
    }

    private final void h1() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new c(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i1(BX4 bx4) {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new d(bx4, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 o1(C19551qY4 c19551qY4, BX4 bx4, EX4.a aVar, long j2) {
        Object value;
        C17187mY4 c17187mY4;
        AbstractC13042fc3.i(c19551qY4, "this$0");
        AbstractC13042fc3.i(bx4, "$field");
        AbstractC13042fc3.i(aVar, "$fieldType");
        InterfaceC9336Zm4 interfaceC9336Zm4 = c19551qY4.f;
        do {
            value = interfaceC9336Zm4.getValue();
            c17187mY4 = (C17187mY4) value;
        } while (!interfaceC9336Zm4.f(value, c17187mY4.a((252 & 1) != 0 ? c17187mY4.a : null, (252 & 2) != 0 ? c17187mY4.b : null, (252 & 4) != 0 ? c17187mY4.c : null, (252 & 8) != 0 ? c17187mY4.d : false, (252 & 16) != 0 ? c17187mY4.e : null, (252 & 32) != 0 ? c17187mY4.f : null, (252 & 64) != 0 ? c17187mY4.g : null, (252 & 128) != 0 ? c17187mY4.h : null)));
        c19551qY4.d1(bx4, aVar, j2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 p1(C19551qY4 c19551qY4) {
        Object value;
        C17187mY4 c17187mY4;
        AbstractC13042fc3.i(c19551qY4, "this$0");
        InterfaceC9336Zm4 interfaceC9336Zm4 = c19551qY4.f;
        do {
            value = interfaceC9336Zm4.getValue();
            c17187mY4 = (C17187mY4) value;
        } while (!interfaceC9336Zm4.f(value, c17187mY4.a((252 & 1) != 0 ? c17187mY4.a : null, (252 & 2) != 0 ? c17187mY4.b : null, (252 & 4) != 0 ? c17187mY4.c : null, (252 & 8) != 0 ? c17187mY4.d : false, (252 & 16) != 0 ? c17187mY4.e : null, (252 & 32) != 0 ? c17187mY4.f : null, (252 & 64) != 0 ? c17187mY4.g : null, (252 & 128) != 0 ? c17187mY4.h : null)));
        return C19938rB7.a;
    }

    private final void q1() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new e(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s1(final BX4 bx4) {
        u1(bx4.d(), new UA2() { // from class: ir.nasim.nY4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C19551qY4.t1(bx4, (BX4) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BX4 t1(BX4 bx4, BX4 bx42) {
        AbstractC13042fc3.i(bx4, "$field");
        AbstractC13042fc3.i(bx42, "it");
        return bx4;
    }

    private final void u1(int i2, UA2 ua2) {
        Object value;
        C17187mY4 c17187mY4;
        C19777qv2 c19777qv2F;
        ArrayList arrayList;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.f;
        do {
            value = interfaceC9336Zm4.getValue();
            c17187mY4 = (C17187mY4) value;
            c19777qv2F = c17187mY4.f();
            List<CX4> listD = c17187mY4.f().d();
            arrayList = new ArrayList(AbstractC10976cX0.x(listD, 10));
            for (CX4 cx4 : listD) {
                List<BX4> listC = cx4.c();
                ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(listC, 10));
                for (BX4 bx4 : listC) {
                    if (bx4.d() == i2) {
                        bx4 = (BX4) ua2.invoke(bx4);
                    }
                    arrayList2.add(bx4);
                }
                arrayList.add(CX4.b(cx4, null, false, arrayList2, 3, null));
            }
        } while (!interfaceC9336Zm4.f(value, c17187mY4.a((252 & 1) != 0 ? c17187mY4.a : C19777qv2.b(c19777qv2F, arrayList, null, 2, null), (252 & 2) != 0 ? c17187mY4.b : null, (252 & 4) != 0 ? c17187mY4.c : null, (252 & 8) != 0 ? c17187mY4.d : false, (252 & 16) != 0 ? c17187mY4.e : null, (252 & 32) != 0 ? c17187mY4.f : null, (252 & 64) != 0 ? c17187mY4.g : null, (252 & 128) != 0 ? c17187mY4.h : null)));
    }

    public final InterfaceC10258bL6 c1() {
        return this.f;
    }

    public final void e1(WX4 wx4) {
        AbstractC13042fc3.i(wx4, "event");
        if (wx4 instanceof WX4.a) {
            WX4.a aVar = (WX4.a) wx4;
            m1(aVar.a(), aVar.b());
        } else if (wx4 instanceof WX4.b) {
            WX4.b bVar = (WX4.b) wx4;
            f1(bVar.a(), bVar.b());
        } else if (AbstractC13042fc3.d(wx4, WX4.d.a)) {
            q1();
        } else {
            if (!AbstractC13042fc3.d(wx4, WX4.c.a)) {
                throw new NoWhenBranchMatchedException();
            }
            g1();
        }
    }

    public final void j1() {
        Object value;
        C17187mY4 c17187mY4;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.f;
        do {
            value = interfaceC9336Zm4.getValue();
            c17187mY4 = (C17187mY4) value;
        } while (!interfaceC9336Zm4.f(value, c17187mY4.a((252 & 1) != 0 ? c17187mY4.a : null, (252 & 2) != 0 ? c17187mY4.b : null, (252 & 4) != 0 ? c17187mY4.c : null, (252 & 8) != 0 ? c17187mY4.d : false, (252 & 16) != 0 ? c17187mY4.e : null, (252 & 32) != 0 ? c17187mY4.f : null, (252 & 64) != 0 ? c17187mY4.g : null, (252 & 128) != 0 ? c17187mY4.h : null)));
    }

    public final void k1() {
        Object value;
        C17187mY4 c17187mY4;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.f;
        do {
            value = interfaceC9336Zm4.getValue();
            c17187mY4 = (C17187mY4) value;
        } while (!interfaceC9336Zm4.f(value, c17187mY4.a((252 & 1) != 0 ? c17187mY4.a : null, (252 & 2) != 0 ? c17187mY4.b : null, (252 & 4) != 0 ? c17187mY4.c : null, (252 & 8) != 0 ? c17187mY4.d : false, (252 & 16) != 0 ? c17187mY4.e : null, (252 & 32) != 0 ? c17187mY4.f : null, (252 & 64) != 0 ? c17187mY4.g : null, (252 & 128) != 0 ? c17187mY4.h : null)));
    }

    public final void l1() {
        Object value;
        C17187mY4 c17187mY4;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.f;
        do {
            value = interfaceC9336Zm4.getValue();
            c17187mY4 = (C17187mY4) value;
        } while (!interfaceC9336Zm4.f(value, c17187mY4.a((252 & 1) != 0 ? c17187mY4.a : null, (252 & 2) != 0 ? c17187mY4.b : null, (252 & 4) != 0 ? c17187mY4.c : null, (252 & 8) != 0 ? c17187mY4.d : false, (252 & 16) != 0 ? c17187mY4.e : null, (252 & 32) != 0 ? c17187mY4.f : null, (252 & 64) != 0 ? c17187mY4.g : null, (252 & 128) != 0 ? c17187mY4.h : null)));
    }

    public final void m1(final BX4 bx4, final EX4.a aVar) {
        Object value;
        C17187mY4 c17187mY4;
        String strH;
        String strH2;
        AbstractC11684dQ7 abstractC11684dQ7A;
        long timeInMillis;
        long timeInMillis2;
        long timeInMillis3;
        AbstractC13042fc3.i(bx4, "field");
        AbstractC13042fc3.i(aVar, "fieldType");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.f;
        do {
            value = interfaceC9336Zm4.getValue();
            c17187mY4 = (C17187mY4) value;
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
        } while (!interfaceC9336Zm4.f(value, c17187mY4.a((252 & 1) != 0 ? c17187mY4.a : null, (252 & 2) != 0 ? c17187mY4.b : null, (252 & 4) != 0 ? c17187mY4.c : new IA1(strH, strH2, abstractC11684dQ7A, timeInMillis, timeInMillis2, timeInMillis3, new UA2() { // from class: ir.nasim.oY4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C19551qY4.o1(this.a, bx4, aVar, ((Long) obj).longValue());
            }
        }, new SA2() { // from class: ir.nasim.pY4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C19551qY4.p1(this.a);
            }
        }), (252 & 8) != 0 ? c17187mY4.d : false, (252 & 16) != 0 ? c17187mY4.e : null, (252 & 32) != 0 ? c17187mY4.f : null, (252 & 64) != 0 ? c17187mY4.g : null, (252 & 128) != 0 ? c17187mY4.h : null)));
    }
}
