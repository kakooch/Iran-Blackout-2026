package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.r78, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C19900r78 {
    private final List a;
    private final List b;

    public C19900r78(List list, List list2) {
        AbstractC13042fc3.i(list, "outBoundTracks");
        AbstractC13042fc3.i(list2, "inBoundTracks");
        this.a = list;
        this.b = list2;
    }

    public static /* synthetic */ C19900r78 b(C19900r78 c19900r78, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = c19900r78.a;
        }
        if ((i & 2) != 0) {
            list2 = c19900r78.b;
        }
        return c19900r78.a(list, list2);
    }

    public final C19900r78 a(List list, List list2) {
        AbstractC13042fc3.i(list, "outBoundTracks");
        AbstractC13042fc3.i(list2, "inBoundTracks");
        return new C19900r78(list, list2);
    }

    public final List c() {
        return this.b;
    }

    public final List d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C19900r78)) {
            return false;
        }
        C19900r78 c19900r78 = (C19900r78) obj;
        return AbstractC13042fc3.d(this.a, c19900r78.a) && AbstractC13042fc3.d(this.b, c19900r78.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "WebRTCStats(outBoundTracks=" + this.a + ", inBoundTracks=" + this.b + Separators.RPAREN;
    }

    public /* synthetic */ C19900r78(List list, List list2, int i, ED1 ed1) {
        this((i & 1) != 0 ? AbstractC10360bX0.m() : list, (i & 2) != 0 ? AbstractC10360bX0.m() : list2);
    }
}
