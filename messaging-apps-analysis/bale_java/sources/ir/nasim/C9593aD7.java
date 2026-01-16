package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.aD7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C9593aD7 extends AbstractC20556sC7 {
    private final C11458d25 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C9593aD7(C11458d25 c11458d25) {
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
        return (obj instanceof C9593aD7) && AbstractC13042fc3.d(this.a, ((C9593aD7) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "UpdateChatDelete(peer=" + this.a + Separators.RPAREN;
    }
}
