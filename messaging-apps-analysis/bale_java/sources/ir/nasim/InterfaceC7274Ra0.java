package ir.nasim;

import ai.bale.proto.SapOuterClass$ResponseEnrollNewCard;
import android.gov.nist.javax.sip.header.ParameterNames;
import ir.nasim.core.modules.banking.entity.HistoryMessageData;
import ir.nasim.features.payment.data.model.BankCreditCard;

/* renamed from: ir.nasim.Ra0, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public interface InterfaceC7274Ra0 {
    public static final a b0 = a.a;

    /* renamed from: ir.nasim.Ra0$a */
    public static final class a {
        static final /* synthetic */ a a = new a();

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static void D0(BankCreditCard bankCreditCard, SapOuterClass$ResponseEnrollNewCard sapOuterClass$ResponseEnrollNewCard) {
        AbstractC13042fc3.i(bankCreditCard, "$card");
        C7183Qq.p().putString("last_request_for_shaparak_migration_id", bankCreditCard.getId());
        C7183Qq.p().putString("last_request_for_shaparak_migration_transactionid", sapOuterClass$ResponseEnrollNewCard.getTransactionId());
    }

    default String Y() {
        return C7183Qq.p().e("last_request_for_shaparak_migration_id");
    }

    default C6517Nv5 w0(String str, String str2, int i, String str3) {
        AbstractC13042fc3.i(str, "sourceCardId");
        AbstractC13042fc3.i(str2, "destinationCardNumber");
        AbstractC13042fc3.i(str3, "approvalCode");
        return AbstractC5969Lp4.d().o2().y().k1(str, str2, i, str3);
    }

    default C6517Nv5 x0(String str, String str2, int i, HistoryMessageData historyMessageData, Integer num) {
        AbstractC13042fc3.i(str, "sourceCard");
        AbstractC13042fc3.i(str2, "destinationCardNumber");
        return AbstractC5969Lp4.d().o2().y().z1(GY6.b(str), GY6.b(str2), i, historyMessageData, num);
    }

    default C6517Nv5 z0(final BankCreditCard bankCreditCard) {
        AbstractC13042fc3.i(bankCreditCard, ParameterNames.CARD);
        C6517Nv5 c6517Nv5M0 = AbstractC5969Lp4.d().o2().y().r1().m0(new InterfaceC24449ye1() { // from class: ir.nasim.Qa0
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                InterfaceC7274Ra0.D0(bankCreditCard, (SapOuterClass$ResponseEnrollNewCard) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5M0, "then(...)");
        return c6517Nv5M0;
    }
}
