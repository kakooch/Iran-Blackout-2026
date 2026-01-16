package ir.nasim;

import ai.bale.proto.PfmStruct$PfmUserAccount;
import android.gov.nist.core.Separators;

/* loaded from: classes6.dex */
public final class H75 {
    public static final a e = new a(null);
    public static final int f = 8;
    private final long a;
    private final String b;
    private final String c;
    private boolean d;

    public static final class a {
        private a() {
        }

        public final H75 a(PfmStruct$PfmUserAccount pfmStruct$PfmUserAccount) {
            AbstractC13042fc3.i(pfmStruct$PfmUserAccount, "structPfmUserAccount");
            long accountNumber = pfmStruct$PfmUserAccount.getAccountNumber();
            String accountCardNumber = pfmStruct$PfmUserAccount.getAccountCardNumber();
            AbstractC13042fc3.h(accountCardNumber, "getAccountCardNumber(...)");
            String amount = pfmStruct$PfmUserAccount.getAmount();
            AbstractC13042fc3.h(amount, "getAmount(...)");
            return new H75(accountNumber, accountCardNumber, amount, false);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public H75(long j, String str, String str2, boolean z) {
        AbstractC13042fc3.i(str, "accountCardNumber");
        AbstractC13042fc3.i(str2, "amount");
        this.a = j;
        this.b = str;
        this.c = str2;
        this.d = z;
    }

    public final long a() {
        return this.a;
    }

    public final String b() {
        return this.c;
    }

    public final boolean c() {
        return this.d;
    }

    public final void d(boolean z) {
        this.d = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof H75)) {
            return false;
        }
        H75 h75 = (H75) obj;
        return this.a == h75.a && AbstractC13042fc3.d(this.b, h75.b) && AbstractC13042fc3.d(this.c, h75.c) && this.d == h75.d;
    }

    public int hashCode() {
        return (((((Long.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + Boolean.hashCode(this.d);
    }

    public String toString() {
        return "PfmUserAccount(accountNumber=" + this.a + ", accountCardNumber=" + this.b + ", amount=" + this.c + ", showBalance=" + this.d + Separators.RPAREN;
    }
}
