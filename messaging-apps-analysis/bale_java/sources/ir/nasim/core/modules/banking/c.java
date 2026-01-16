package ir.nasim.core.modules.banking;

import ir.nasim.A7;
import ir.nasim.AG2;
import ir.nasim.AbstractC20471s40;
import ir.nasim.C11458d25;
import ir.nasim.C12736f7;
import ir.nasim.C14688iK2;
import ir.nasim.C19999rI5;
import ir.nasim.C20587sG2;
import ir.nasim.C22423vC7;
import ir.nasim.C22454vG2;
import ir.nasim.C24221yF2;
import ir.nasim.C3423Au7;
import ir.nasim.C6517Nv5;
import ir.nasim.C9057Yh4;
import ir.nasim.FN5;
import ir.nasim.HF2;
import ir.nasim.J44;
import ir.nasim.K6;
import ir.nasim.KF2;
import ir.nasim.U9;
import ir.nasim.UH1;
import ir.nasim.V6;
import ir.nasim.XY6;
import ir.nasim.Z6;
import ir.nasim.core.modules.banking.entity.HistoryMessageData;
import ir.nasim.features.payment.data.model.BankCreditCard;

/* loaded from: classes5.dex */
class c extends Z6 {
    c(final C9057Yh4 c9057Yh4) {
        super(C12736f7.n().e("banking/actor/bank", new V6() { // from class: ir.nasim.core.modules.banking.b
            @Override // ir.nasim.V6
            public final K6 create() {
                return c.v(c9057Yh4);
            }
        }, true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ K6 v(C9057Yh4 c9057Yh4) {
        return new BankActor(c9057Yh4);
    }

    public C6517Nv5 k(l lVar) {
        return c(new U9(lVar));
    }

    public C6517Nv5 l(BankCreditCard bankCreditCard) {
        return c(new A7(bankCreditCard));
    }

    public C6517Nv5 m(String str, String str2, int i, String str3) {
        return c(new UH1(str, str2, i, str3));
    }

    public C6517Nv5 n(d dVar) {
        return c(dVar);
    }

    public C6517Nv5 o(String str, String str2) {
        return c(new C24221yF2(str, XY6.h(str2)));
    }

    C6517Nv5 p(C11458d25 c11458d25, J44 j44) {
        return c(new HF2(c11458d25, j44));
    }

    public C6517Nv5 q(String str, String str2, int i, HistoryMessageData historyMessageData, Integer num) {
        return c(new KF2(str, str2, i, historyMessageData, num));
    }

    public C6517Nv5 r() {
        return c(new C20587sG2());
    }

    public C6517Nv5 s() {
        return c(new C22454vG2());
    }

    public C6517Nv5 t(int i) {
        return c(new AG2(i));
    }

    public C6517Nv5 u(C14688iK2 c14688iK2) {
        return c(c14688iK2);
    }

    public C6517Nv5 w() {
        return c(new C19999rI5());
    }

    public C6517Nv5 x(AbstractC20471s40 abstractC20471s40) {
        return c(new FN5(abstractC20471s40));
    }

    public C6517Nv5 y(String str, String str2, int i, String str3, String str4, String str5, String str6, String str7, HistoryMessageData historyMessageData, Long l, String str8, String str9) {
        return c(new C3423Au7(str, str2, i, str3, str4, str5, str6, str7, historyMessageData, l, str8, str9));
    }

    public C6517Nv5 z(C22423vC7 c22423vC7) {
        return c(c22423vC7);
    }
}
