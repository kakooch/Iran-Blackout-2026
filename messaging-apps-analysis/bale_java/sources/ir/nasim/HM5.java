package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class HM5 {
    private final IM5 a;
    private final C11458d25 b;

    public HM5(IM5 im5, C11458d25 c11458d25) {
        AbstractC13042fc3.i(im5, "uiState");
        AbstractC13042fc3.i(c11458d25, "peer");
        this.a = im5;
        this.b = c11458d25;
    }

    public final IM5 a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HM5)) {
            return false;
        }
        HM5 hm5 = (HM5) obj;
        return AbstractC13042fc3.d(this.a, hm5.a) && AbstractC13042fc3.d(this.b, hm5.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "RelatedChannelsResponse(uiState=" + this.a + ", peer=" + this.b + Separators.RPAREN;
    }
}
