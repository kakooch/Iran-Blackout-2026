package ir.nasim;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import ir.nasim.features.payment.data.model.BankCreditCard;

/* renamed from: ir.nasim.vC7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C22423vC7 implements InterfaceC15283jK {
    private BankCreditCard a;
    private int b;
    private int c;
    private String d;

    public C22423vC7(BankCreditCard bankCreditCard, int i, int i2, String str) {
        AbstractC13042fc3.i(bankCreditCard, ParameterNames.CARD);
        AbstractC13042fc3.i(str, "cvv2");
        this.a = bankCreditCard;
        this.b = i;
        this.c = i2;
        this.d = str;
    }

    public final BankCreditCard a() {
        return this.a;
    }

    public final String b() {
        return this.d;
    }

    public final int c() {
        return this.b;
    }

    public final int d() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C22423vC7)) {
            return false;
        }
        C22423vC7 c22423vC7 = (C22423vC7) obj;
        return AbstractC13042fc3.d(this.a, c22423vC7.a) && this.b == c22423vC7.b && this.c == c22423vC7.c && AbstractC13042fc3.d(this.d, c22423vC7.d);
    }

    public int hashCode() {
        return (((((this.a.hashCode() * 31) + Integer.hashCode(this.b)) * 31) + Integer.hashCode(this.c)) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "UpdateBankCreditCard(card=" + this.a + ", month=" + this.b + ", year=" + this.c + ", cvv2=" + this.d + Separators.RPAREN;
    }
}
