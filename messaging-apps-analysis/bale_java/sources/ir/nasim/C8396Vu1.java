package ir.nasim;

import ai.bale.proto.Crowdfunding$ResponseGetTotalPaidAmount;
import ir.nasim.core.modules.banking.BankingModule;
import ir.nasim.core.modules.messaging.entity.content.CrowdfundingContentInfo;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.HashMap;

/* renamed from: ir.nasim.Vu1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C8396Vu1 {
    private final C11458d25 a;
    private final BankingModule b;
    private final InterfaceC9173Yu3 c;

    public C8396Vu1(C11458d25 c11458d25, BankingModule bankingModule) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(bankingModule, "module");
        this.a = c11458d25;
        this.b = bankingModule;
        this.c = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Tu1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C8396Vu1.e();
            }
        });
    }

    private final HashMap d() {
        return (HashMap) this.c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HashMap e() {
        return new HashMap();
    }

    private final void f(final J44 j44, final CrowdfundingContentInfo crowdfundingContentInfo, final SA2 sa2) {
        this.b.d2(this.a, j44).m0(new InterfaceC24449ye1() { // from class: ir.nasim.Uu1
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C8396Vu1.g(this.a, j44, crowdfundingContentInfo, sa2, (Crowdfunding$ResponseGetTotalPaidAmount) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(C8396Vu1 c8396Vu1, J44 j44, CrowdfundingContentInfo crowdfundingContentInfo, SA2 sa2, Crowdfunding$ResponseGetTotalPaidAmount crowdfunding$ResponseGetTotalPaidAmount) {
        AbstractC13042fc3.i(c8396Vu1, "this$0");
        AbstractC13042fc3.i(j44, "$message");
        AbstractC13042fc3.i(crowdfundingContentInfo, "$info");
        c8396Vu1.d().put(Long.valueOf(j44.i()), crowdfundingContentInfo.b((14207 & 1) != 0 ? crowdfundingContentInfo.isRemote : false, (14207 & 2) != 0 ? crowdfundingContentInfo.title : null, (14207 & 4) != 0 ? crowdfundingContentInfo.description : null, (14207 & 8) != 0 ? crowdfundingContentInfo.startTime : 0L, (14207 & 16) != 0 ? crowdfundingContentInfo.endTime : 0L, (14207 & 32) != 0 ? crowdfundingContentInfo.amount : 0L, (14207 & 64) != 0 ? crowdfundingContentInfo.quotaAmount : 0L, (14207 & 128) != 0 ? crowdfundingContentInfo.payCount : (int) (crowdfunding$ResponseGetTotalPaidAmount.getTotalPaidAmount() / crowdfundingContentInfo.getQuotaAmount()), (14207 & 256) != 0 ? crowdfundingContentInfo.cardNumber : null, (14207 & 512) != 0 ? crowdfundingContentInfo.msg : null, (14207 & 1024) != 0 ? crowdfundingContentInfo.status : null, (14207 & 2048) != 0 ? crowdfundingContentInfo.senderId : crowdfunding$ResponseGetTotalPaidAmount.getCreatorUserId(), (14207 & 4096) != 0 ? crowdfundingContentInfo.photoContent : null, (14207 & 8192) != 0 ? crowdfundingContentInfo.isForwarded : false));
        if (sa2 != null) {
            sa2.invoke();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final CrowdfundingContentInfo c(J44 j44, CrowdfundingContentInfo crowdfundingContentInfo, SA2 sa2) {
        AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(crowdfundingContentInfo, "defaultInfo");
        HashMap mapD = d();
        Long lValueOf = Long.valueOf(j44.i());
        Object obj = mapD.get(lValueOf);
        if (obj == 0) {
            f(j44, crowdfundingContentInfo, sa2);
            mapD.put(lValueOf, crowdfundingContentInfo);
        } else {
            crowdfundingContentInfo = obj;
        }
        return crowdfundingContentInfo;
    }
}
