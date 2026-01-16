package ir.nasim;

import ir.nasim.core.modules.banking.BankingModule;
import java.util.List;

/* renamed from: ir.nasim.x14, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C23498x14 extends V50 {
    private final InterfaceC24088y14 j;
    private Long k;
    private Long l;
    private boolean m;
    private final BankingModule n;
    private final List o;
    private B14 p;

    /* JADX WARN: Illegal instructions before constructor call */
    public C23498x14(InterfaceC24088y14 interfaceC24088y14) {
        AbstractC13042fc3.i(interfaceC24088y14, "melliLoanMVPView");
        Z50 z50 = Z50.MELLI_LOAN;
        super(interfaceC24088y14, z50);
        this.j = interfaceC24088y14;
        BankingModule bankingModuleG = ((InterfaceC9291Zh4) C92.a(C5721Ko.a.d(), InterfaceC9291Zh4.class)).g();
        this.n = bankingModuleG;
        this.o = bankingModuleG.t1(z50);
        A();
    }

    private final void A() {
        if (this.o.size() > 1 || !this.o.contains(Y50.e)) {
            this.j.p5();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(final C23498x14 c23498x14, final ir.nasim.core.modules.banking.m mVar, final N60 n60) {
        AbstractC13042fc3.i(c23498x14, "this$0");
        AbstractC13042fc3.i(mVar, "$fullBankCard");
        if (n60 instanceof B14) {
            B14 b14 = (B14) n60;
            if (b14.b()) {
                c23498x14.m = true;
                c23498x14.p = b14;
                AbstractC20507s76.C(new Runnable() { // from class: ir.nasim.w14
                    @Override // java.lang.Runnable
                    public final void run() {
                        C23498x14.D(this.a, n60, mVar);
                    }
                });
            } else {
                String strA = b14.a();
                if (strA != null) {
                    c23498x14.j.x3(strA);
                } else {
                    c23498x14.j.x0();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(C23498x14 c23498x14, N60 n60, ir.nasim.core.modules.banking.m mVar) {
        AbstractC13042fc3.i(c23498x14, "this$0");
        AbstractC13042fc3.i(mVar, "$fullBankCard");
        c23498x14.j.R4();
        InterfaceC24088y14 interfaceC24088y14 = c23498x14.j;
        Long l = c23498x14.l;
        AbstractC13042fc3.f(l);
        long jLongValue = l.longValue();
        B14 b14 = (B14) n60;
        String strF = b14.f();
        AbstractC13042fc3.h(strF, "getLoanType(...)");
        String strE = b14.e();
        AbstractC13042fc3.h(strE, "getLoanNumber(...)");
        String strD = b14.d();
        AbstractC13042fc3.h(strD, "getFullName(...)");
        interfaceC24088y14.e5(new A14(jLongValue, strF, strE, strD, mVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(C23498x14 c23498x14, Exception exc) {
        AbstractC13042fc3.i(c23498x14, "this$0");
        c23498x14.j.x0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(C23498x14 c23498x14, ir.nasim.core.modules.banking.j jVar) {
        AbstractC13042fc3.i(c23498x14, "this$0");
        if (jVar != null) {
            if (jVar.b()) {
                c23498x14.j.G1();
                return;
            }
            String strA = jVar.a();
            if (strA != null) {
                c23498x14.j.x3(strA);
            } else {
                c23498x14.j.x0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(C23498x14 c23498x14, Exception exc) {
        AbstractC13042fc3.i(c23498x14, "this$0");
        c23498x14.j.X4();
    }

    public final boolean B(Y50 y50) {
        AbstractC13042fc3.i(y50, "bankName");
        return this.n.i2(y50, Z50.MELLI_LOAN);
    }

    public final void H(boolean z) {
        this.m = z;
    }

    public final void I(Long l) {
        this.l = l;
    }

    public final void J(Long l) {
        this.k = l;
    }

    @Override // ir.nasim.V50
    public void q(final ir.nasim.core.modules.banking.m mVar, String str, String str2) {
        C6517Nv5 c6517Nv5C;
        C6517Nv5 c6517Nv5M0;
        AbstractC13042fc3.i(mVar, "fullBankCard");
        AbstractC13042fc3.i(str, "pin2");
        AbstractC13042fc3.i(str2, "description");
        this.j.t2(0);
        if (this.m) {
            B14 b14 = this.p;
            if (b14 == null || (c6517Nv5C = b14.c()) == null || (c6517Nv5M0 = c6517Nv5C.m0(new InterfaceC24449ye1() { // from class: ir.nasim.u14
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C23498x14.F(this.a, (ir.nasim.core.modules.banking.j) obj);
                }
            })) == null) {
                return;
            }
            c6517Nv5M0.E(new InterfaceC24449ye1() { // from class: ir.nasim.v14
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C23498x14.G(this.a, (Exception) obj);
                }
            });
            return;
        }
        S64 s64J = j();
        if (s64J != null) {
            BankingModule bankingModule = this.n;
            Long l = this.l;
            AbstractC13042fc3.f(l);
            bankingModule.m1(new ir.nasim.core.modules.banking.p(mVar, str, l.longValue(), s64J, str2)).m0(new InterfaceC24449ye1() { // from class: ir.nasim.s14
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C23498x14.C(this.a, mVar, (N60) obj);
                }
            }).E(new InterfaceC24449ye1() { // from class: ir.nasim.t14
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C23498x14.E(this.a, (Exception) obj);
                }
            });
        }
    }

    public final List z() {
        return this.o;
    }
}
