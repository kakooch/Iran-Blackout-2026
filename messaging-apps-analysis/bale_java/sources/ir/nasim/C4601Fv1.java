package ir.nasim;

import ir.nasim.core.modules.banking.BankingModule;
import ir.nasim.database.dailogLists.DialogEntity;

/* renamed from: ir.nasim.Fv1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C4601Fv1 extends VW7 implements InterfaceC4367Ev1 {
    private final BankingModule b;

    public C4601Fv1(BankingModule bankingModule) {
        AbstractC13042fc3.i(bankingModule, "bankingModule");
        this.b = bankingModule;
    }

    @Override // ir.nasim.InterfaceC4367Ev1
    public void a(long j, long j2, long j3, C16247kx c16247kx) {
        AbstractC13042fc3.i(c16247kx, DialogEntity.COLUMN_MESSAGE);
        BankingModule bankingModule = this.b;
        C11458d25 c11458d25R = C11458d25.r(j);
        AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
        bankingModule.o1(c11458d25R, j2, j3, c16247kx);
    }
}
