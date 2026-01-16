package ir.nasim;

import android.gov.nist.core.Separators;
import android.text.Spannable;
import ir.nasim.AbstractC17757nW1;

/* renamed from: ir.nasim.ei4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C12494ei4 {
    private final AbstractC4970Hi4 a;
    private final Spannable b;
    private final String c;
    private final boolean d;
    private final C11458d25 e;
    private final AbstractC17757nW1.c f;

    public C12494ei4(AbstractC4970Hi4 abstractC4970Hi4, Spannable spannable, String str, boolean z, C11458d25 c11458d25, AbstractC17757nW1.c cVar) {
        AbstractC13042fc3.i(abstractC4970Hi4, "receiver");
        AbstractC13042fc3.i(spannable, "requestAmount");
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(cVar, "graphical");
        this.a = abstractC4970Hi4;
        this.b = spannable;
        this.c = str;
        this.d = z;
        this.e = c11458d25;
        this.f = cVar;
    }

    public final AbstractC17757nW1.c a() {
        return this.f;
    }

    public final C11458d25 b() {
        return this.e;
    }

    public final Spannable c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12494ei4)) {
            return false;
        }
        C12494ei4 c12494ei4 = (C12494ei4) obj;
        return AbstractC13042fc3.d(this.a, c12494ei4.a) && AbstractC13042fc3.d(this.b, c12494ei4.b) && AbstractC13042fc3.d(this.c, c12494ei4.c) && this.d == c12494ei4.d && AbstractC13042fc3.d(this.e, c12494ei4.e) && AbstractC13042fc3.d(this.f, c12494ei4.f);
    }

    public int hashCode() {
        int iHashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        String str = this.c;
        return ((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.d)) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
    }

    public String toString() {
        AbstractC4970Hi4 abstractC4970Hi4 = this.a;
        Spannable spannable = this.b;
        return "MoneyRequest(receiver=" + abstractC4970Hi4 + ", requestAmount=" + ((Object) spannable) + ", targetWalletId=" + this.c + ", isChargePurchaseContent=" + this.d + ", peer=" + this.e + ", graphical=" + this.f + Separators.RPAREN;
    }
}
