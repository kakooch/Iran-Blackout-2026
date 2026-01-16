package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.cF7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C10821cF7 extends AbstractC20556sC7 {
    private final long a;
    private final long b;
    private final List c;
    private final long d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C10821cF7(long j, long j2, List list, long j3) {
        super(null);
        AbstractC13042fc3.i(list, "participants");
        this.a = j;
        this.b = j2;
        this.c = list;
        this.d = j3;
    }

    public final long a() {
        return this.a;
    }

    public final long b() {
        return this.b;
    }

    public final List c() {
        return this.c;
    }

    public final long d() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C10821cF7)) {
            return false;
        }
        C10821cF7 c10821cF7 = (C10821cF7) obj;
        return this.a == c10821cF7.a && this.b == c10821cF7.b && AbstractC13042fc3.d(this.c, c10821cF7.c) && this.d == c10821cF7.d;
    }

    public int hashCode() {
        return (((((Long.hashCode(this.a) * 31) + Long.hashCode(this.b)) * 31) + this.c.hashCode()) * 31) + Long.hashCode(this.d);
    }

    public String toString() {
        return "UpdateMultiPeerCallStarted(id=" + this.a + ", initiator=" + this.b + ", participants=" + this.c + ", updateCreateDate=" + this.d + Separators.RPAREN;
    }
}
