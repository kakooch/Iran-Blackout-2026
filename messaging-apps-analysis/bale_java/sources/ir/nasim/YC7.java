package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class YC7 extends AbstractC20556sC7 {
    private final C11458d25 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YC7(C11458d25 c11458d25) {
        super(null);
        AbstractC13042fc3.i(c11458d25, "peer");
        this.a = c11458d25;
    }

    public final C11458d25 a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof YC7) && AbstractC13042fc3.d(this.a, ((YC7) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "UpdateChatClear(peer=" + this.a + Separators.RPAREN;
    }
}
