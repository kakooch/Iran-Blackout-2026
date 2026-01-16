package ir.nasim;

import ai.bale.proto.Crowdfunding$ResponseGetTotalPaidAmount;
import ir.nasim.core.modules.banking.BankingModule;
import ir.nasim.database.dailogLists.DialogEntity;

/* renamed from: ir.nasim.Ov1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C6752Ov1 extends VW7 implements InterfaceC5552Jv1 {
    private final BankingModule b;

    public C6752Ov1(BankingModule bankingModule) {
        AbstractC13042fc3.i(bankingModule, "bankingModule");
        this.b = bankingModule;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U0(C20298rm4 c20298rm4, Crowdfunding$ResponseGetTotalPaidAmount crowdfunding$ResponseGetTotalPaidAmount) {
        AbstractC13042fc3.i(c20298rm4, "$liveData");
        c20298rm4.n(new C5354Iz1(crowdfunding$ResponseGetTotalPaidAmount));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V0(C20298rm4 c20298rm4, Exception exc) {
        AbstractC13042fc3.i(c20298rm4, "$liveData");
        c20298rm4.n(new C5354Iz1((Throwable) exc));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W0(C14505i18 c14505i18) {
        c14505i18.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X0(Exception exc) {
        C19406qI3.d("NON_FATAL_EXCEPTION", exc);
    }

    @Override // ir.nasim.InterfaceC5552Jv1
    public void a(long j, long j2, long j3, C16247kx c16247kx) {
        AbstractC13042fc3.i(c16247kx, DialogEntity.COLUMN_MESSAGE);
        BankingModule bankingModule = this.b;
        C11458d25 c11458d25R = C11458d25.r(j);
        AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
        bankingModule.o1(c11458d25R, j2, j3, c16247kx).m0(new InterfaceC24449ye1() { // from class: ir.nasim.Kv1
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C6752Ov1.W0((C14505i18) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.Lv1
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C6752Ov1.X0((Exception) obj);
            }
        });
    }

    @Override // ir.nasim.InterfaceC5552Jv1
    public androidx.lifecycle.r k0(C11458d25 c11458d25, J44 j44) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
        final C20298rm4 c20298rm4 = new C20298rm4();
        this.b.d2(c11458d25, j44).m0(new InterfaceC24449ye1() { // from class: ir.nasim.Mv1
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C6752Ov1.U0(c20298rm4, (Crowdfunding$ResponseGetTotalPaidAmount) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.Nv1
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C6752Ov1.V0(c20298rm4, (Exception) obj);
            }
        });
        return c20298rm4;
    }
}
