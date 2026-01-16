package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.aF7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C9611aF7 extends AbstractC20556sC7 {
    private final C11458d25 a;
    private final List b;
    private final boolean c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C9611aF7(C11458d25 c11458d25, List list, boolean z) {
        super(null);
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(list, "messageIds");
        this.a = c11458d25;
        this.b = list;
        this.c = z;
    }

    public final boolean a() {
        return this.c;
    }

    public final List b() {
        return this.b;
    }

    public final C11458d25 c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C9611aF7)) {
            return false;
        }
        C9611aF7 c9611aF7 = (C9611aF7) obj;
        return AbstractC13042fc3.d(this.a, c9611aF7.a) && AbstractC13042fc3.d(this.b, c9611aF7.b) && this.c == c9611aF7.c;
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + Boolean.hashCode(this.c);
    }

    public String toString() {
        return "UpdateMessagesUnPinned(peer=" + this.a + ", messageIds=" + this.b + ", all=" + this.c + Separators.RPAREN;
    }
}
