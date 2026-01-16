package ir.nasim;

import ir.nasim.core.modules.banking.BankingModule;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.Hb6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C4909Hb6 extends VW7 implements InterfaceC22058ub6 {
    public static final a c = new a(null);
    public static final int d = 8;
    private final BankingModule b;

    /* renamed from: ir.nasim.Hb6$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C4909Hb6(BankingModule bankingModule) {
        AbstractC13042fc3.i(bankingModule, "bankingModule");
        this.b = bankingModule;
    }

    private final void c1(List list, C20298rm4 c20298rm4) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                AbstractC10360bX0.w();
            }
            ir.nasim.core.modules.banking.l lVar = (ir.nasim.core.modules.banking.l) obj;
            C20481s50 c20481s50 = C20481s50.a;
            C13466gH0 c13466gH0E = lVar.e();
            AbstractC13042fc3.f(c13466gH0E);
            String name = c13466gH0E.getName();
            AbstractC13042fc3.h(name, "getName(...)");
            String strSubstring = name.substring(0, 6);
            AbstractC13042fc3.h(strSubstring, "substring(...)");
            Integer numE = c20481s50.e(AbstractC10360bX0.g(strSubstring));
            if (numE == null) {
                numE = Integer.valueOf(KB5.ic_card_payment_cardunknown_icon_classic);
            }
            int iIntValue = numE.intValue();
            C13466gH0 c13466gH0E2 = lVar.e();
            AbstractC13042fc3.f(c13466gH0E2);
            String name2 = c13466gH0E2.getName();
            AbstractC13042fc3.h(name2, "getName(...)");
            C13466gH0 c13466gH0E3 = lVar.e();
            AbstractC13042fc3.f(c13466gH0E3);
            String name3 = c13466gH0E3.getName();
            AbstractC13042fc3.h(name3, "getName(...)");
            String strE = XY6.e(c20481s50.a(name3));
            C13466gH0 c13466gH0E4 = lVar.e();
            arrayList.add(new H40(lVar, iIntValue, name2, strE, c13466gH0E4 != null ? c13466gH0E4.y() : null, false, false, false, 224, null));
            if (i == arrayList.size() - 1) {
                c20298rm4.n(new C5354Iz1(arrayList));
            }
            i = i2;
        }
        m1(arrayList, 0, c20298rm4);
    }

    private final void d1(List list, C20298rm4 c20298rm4) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                AbstractC10360bX0.w();
            }
            ir.nasim.core.modules.banking.l lVar = (ir.nasim.core.modules.banking.l) obj;
            C20481s50 c20481s50 = C20481s50.a;
            C13466gH0 c13466gH0E = lVar.e();
            AbstractC13042fc3.f(c13466gH0E);
            String name = c13466gH0E.getName();
            AbstractC13042fc3.h(name, "getName(...)");
            String strSubstring = name.substring(0, 6);
            AbstractC13042fc3.h(strSubstring, "substring(...)");
            Integer numE = c20481s50.e(AbstractC10360bX0.g(strSubstring));
            if (numE == null) {
                numE = Integer.valueOf(KB5.ic_card_payment_cardunknown_icon_classic);
            }
            int iIntValue = numE.intValue();
            C13466gH0 c13466gH0E2 = lVar.e();
            AbstractC13042fc3.f(c13466gH0E2);
            String name2 = c13466gH0E2.getName();
            AbstractC13042fc3.h(name2, "getName(...)");
            C13466gH0 c13466gH0E3 = lVar.e();
            AbstractC13042fc3.f(c13466gH0E3);
            String name3 = c13466gH0E3.getName();
            AbstractC13042fc3.h(name3, "getName(...)");
            String strE = XY6.e(c20481s50.a(name3));
            C13466gH0 c13466gH0E4 = lVar.e();
            arrayList.add(new H40(lVar, iIntValue, name2, strE, c13466gH0E4 != null ? c13466gH0E4.y() : null, false, false, false, 224, null));
            i = i2;
        }
        q1(arrayList, 0, c20298rm4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e1(C20298rm4 c20298rm4, C14505i18 c14505i18) {
        AbstractC13042fc3.i(c20298rm4, "$liveData");
        c20298rm4.n(new C5354Iz1(Boolean.TRUE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f1(C20298rm4 c20298rm4, Exception exc) {
        AbstractC13042fc3.i(c20298rm4, "$liveData");
        c20298rm4.n(new C5354Iz1((Throwable) exc));
        C19406qI3.d("SavedCardListViewModelImpl", exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g1(C20298rm4 c20298rm4, List list) {
        AbstractC13042fc3.i(c20298rm4, "$liveData");
        c20298rm4.n(new C5354Iz1(Boolean.TRUE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h1(C20298rm4 c20298rm4, Exception exc) {
        AbstractC13042fc3.i(c20298rm4, "$liveData");
        c20298rm4.n(new C5354Iz1((Throwable) exc));
        C19406qI3.d("SavedCardListViewModelImpl", exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i1(C4909Hb6 c4909Hb6, C20298rm4 c20298rm4, List list) {
        AbstractC13042fc3.i(c4909Hb6, "this$0");
        AbstractC13042fc3.i(c20298rm4, "$liveData");
        AbstractC13042fc3.f(list);
        if (!list.isEmpty()) {
            c4909Hb6.c1(list, c20298rm4);
        } else {
            c20298rm4.n(new C5354Iz1(new ArrayList()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j1(C20298rm4 c20298rm4, Exception exc) {
        AbstractC13042fc3.i(c20298rm4, "$liveData");
        c20298rm4.n(new C5354Iz1((Throwable) exc));
        C19406qI3.d("SavedCardListViewModelImpl", exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k1(C4909Hb6 c4909Hb6, C20298rm4 c20298rm4, List list) {
        AbstractC13042fc3.i(c4909Hb6, "this$0");
        AbstractC13042fc3.i(c20298rm4, "$liveData");
        AbstractC13042fc3.f(list);
        if (!list.isEmpty()) {
            c4909Hb6.d1(AbstractC19810qy7.c(list), c20298rm4);
        } else {
            c20298rm4.n(new C5354Iz1(new ArrayList()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l1(C20298rm4 c20298rm4, Exception exc) {
        AbstractC13042fc3.i(c20298rm4, "$liveData");
        c20298rm4.n(new C5354Iz1((Throwable) exc));
        C19406qI3.d("SavedCardListViewModelImpl", exc);
    }

    private final void m1(final ArrayList arrayList, final int i, final C20298rm4 c20298rm4) {
        AbstractC20471s40 abstractC20471s40A = ((H40) arrayList.get(i)).a();
        AbstractC13042fc3.g(abstractC20471s40A, "null cannot be cast to non-null type ir.nasim.core.modules.banking.DigitOnlyBankCard");
        this.b.O1().d(((ir.nasim.core.modules.banking.l) abstractC20471s40A).e()).m0(new InterfaceC24449ye1() { // from class: ir.nasim.Fb6
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C4909Hb6.o1(arrayList, i, c20298rm4, this, (String) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.Gb6
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C4909Hb6.p1((Exception) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o1(ArrayList arrayList, int i, C20298rm4 c20298rm4, C4909Hb6 c4909Hb6, String str) {
        AbstractC13042fc3.i(arrayList, "$mList");
        AbstractC13042fc3.i(c20298rm4, "$liveData");
        AbstractC13042fc3.i(c4909Hb6, "this$0");
        ((H40) arrayList.get(i)).i(str);
        if (i == arrayList.size() - 1) {
            c20298rm4.n(new C5354Iz1(arrayList));
        } else {
            c4909Hb6.m1(arrayList, i + 1, c20298rm4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p1(Exception exc) {
        C19406qI3.b("SavedCardListViewModelImpl", exc.getLocalizedMessage());
    }

    private final void q1(final ArrayList arrayList, final int i, final C20298rm4 c20298rm4) {
        AbstractC20471s40 abstractC20471s40A = ((H40) arrayList.get(i)).a();
        AbstractC13042fc3.g(abstractC20471s40A, "null cannot be cast to non-null type ir.nasim.core.modules.banking.DigitOnlyBankCard");
        AbstractC5969Lp4.d().o2().y().v1(((ir.nasim.core.modules.banking.l) abstractC20471s40A).e()).m0(new InterfaceC24449ye1() { // from class: ir.nasim.wb6
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C4909Hb6.s1(arrayList, i, c20298rm4, this, (OG0) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.xb6
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C4909Hb6.t1((Exception) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s1(ArrayList arrayList, int i, C20298rm4 c20298rm4, C4909Hb6 c4909Hb6, OG0 og0) {
        AbstractC13042fc3.i(arrayList, "$mList");
        AbstractC13042fc3.i(c20298rm4, "$liveData");
        AbstractC13042fc3.i(c4909Hb6, "this$0");
        ((H40) arrayList.get(i)).i(og0.d());
        if (i == arrayList.size() - 1) {
            c20298rm4.n(new C5354Iz1(arrayList));
        } else {
            c4909Hb6.q1(arrayList, i + 1, c20298rm4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t1(Exception exc) {
        C19406qI3.b("SavedCardListViewModelImpl", exc.getLocalizedMessage());
    }

    @Override // ir.nasim.InterfaceC22058ub6
    public androidx.lifecycle.r P() {
        final C20298rm4 c20298rm4 = new C20298rm4();
        this.b.M1().m0(new InterfaceC24449ye1() { // from class: ir.nasim.vb6
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C4909Hb6.i1(this.a, c20298rm4, (List) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.yb6
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C4909Hb6.j1(c20298rm4, (Exception) obj);
            }
        });
        return c20298rm4;
    }

    @Override // ir.nasim.InterfaceC22058ub6
    public androidx.lifecycle.r T(H40 h40) {
        AbstractC13042fc3.i(h40, "bankCardSaved");
        final C20298rm4 c20298rm4 = new C20298rm4();
        this.b.F2(h40.a()).m0(new InterfaceC24449ye1() { // from class: ir.nasim.Bb6
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C4909Hb6.e1(c20298rm4, (C14505i18) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.Cb6
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C4909Hb6.f1(c20298rm4, (Exception) obj);
            }
        });
        return c20298rm4;
    }

    @Override // ir.nasim.InterfaceC22058ub6
    public androidx.lifecycle.r h() {
        final C20298rm4 c20298rm4 = new C20298rm4();
        this.b.V1().m0(new InterfaceC24449ye1() { // from class: ir.nasim.zb6
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C4909Hb6.k1(this.a, c20298rm4, (List) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.Ab6
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C4909Hb6.l1(c20298rm4, (Exception) obj);
            }
        });
        return c20298rm4;
    }

    @Override // ir.nasim.InterfaceC22058ub6
    public androidx.lifecycle.r i0(H40 h40) {
        AbstractC13042fc3.i(h40, "bankCardSaved");
        final C20298rm4 c20298rm4 = new C20298rm4();
        this.b.x2(h40.a()).m0(new InterfaceC24449ye1() { // from class: ir.nasim.Db6
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C4909Hb6.g1(c20298rm4, (List) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.Eb6
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C4909Hb6.h1(c20298rm4, (Exception) obj);
            }
        });
        return c20298rm4;
    }
}
