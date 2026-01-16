package ir.nasim;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import ir.nasim.features.payment.data.model.BankCreditCard;

/* loaded from: classes5.dex */
public final class A7 implements InterfaceC15283jK {
    private BankCreditCard a;

    public A7(BankCreditCard bankCreditCard) {
        AbstractC13042fc3.i(bankCreditCard, ParameterNames.CARD);
        this.a = bankCreditCard;
    }

    public final BankCreditCard a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof A7) && AbstractC13042fc3.d(this.a, ((A7) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "AddBankCreditCard(card=" + this.a + Separators.RPAREN;
    }
}
