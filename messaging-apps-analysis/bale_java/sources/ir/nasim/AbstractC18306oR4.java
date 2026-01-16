package ir.nasim;

import ai.bale.proto.PfmStruct$PfmTransaction;
import ai.bale.proto.PfmStruct$PfmTransactionTag;
import ir.nasim.features.pfm.entity.PFMTransaction;
import ir.nasim.features.pfm.entity.PFMTransactionId;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.oR4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC18306oR4 {
    public static final PFMTransactionId a(PFMTransaction pFMTransaction) {
        AbstractC13042fc3.i(pFMTransaction, "<this>");
        return new PFMTransactionId(pFMTransaction.getAccountNumber(), pFMTransaction.getId(), pFMTransaction.getDate(), pFMTransaction.getTransactionType());
    }

    public static final PFMTransaction b(PfmStruct$PfmTransaction pfmStruct$PfmTransaction) {
        AbstractC13042fc3.i(pfmStruct$PfmTransaction, "<this>");
        long id = pfmStruct$PfmTransaction.getId();
        long date = pfmStruct$PfmTransaction.getDate();
        String amount = pfmStruct$PfmTransaction.getAmount();
        AbstractC13042fc3.h(amount, "getAmount(...)");
        EnumC18897pR4 enumC18897pR4A = AbstractC19488qR4.a(pfmStruct$PfmTransaction.getTransactionType());
        long accountNumber = pfmStruct$PfmTransaction.getAccountNumber();
        String value = pfmStruct$PfmTransaction.getDescription().getValue();
        List<PfmStruct$PfmTransactionTag> tagsList = pfmStruct$PfmTransaction.getTagsList();
        AbstractC13042fc3.h(tagsList, "getTagsList(...)");
        List<PfmStruct$PfmTransactionTag> listP1 = AbstractC15401jX0.p1(tagsList);
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listP1, 10));
        for (PfmStruct$PfmTransactionTag pfmStruct$PfmTransactionTag : listP1) {
            AbstractC13042fc3.f(pfmStruct$PfmTransactionTag);
            arrayList.add(RQ4.b(pfmStruct$PfmTransactionTag));
        }
        String detail = pfmStruct$PfmTransaction.getDetail();
        AbstractC13042fc3.h(detail, "getDetail(...)");
        return new PFMTransaction(id, date, amount, enumC18897pR4A, accountNumber, value, arrayList, detail, null, 256, null);
    }
}
