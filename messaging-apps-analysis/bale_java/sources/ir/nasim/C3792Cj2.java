package ir.nasim;

import android.gov.nist.core.Separators;
import com.google.protobuf.BytesValue;
import java.util.List;

/* renamed from: ir.nasim.Cj2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3792Cj2 {
    private final List a;
    private final BytesValue b;

    public C3792Cj2(List list, BytesValue bytesValue) {
        AbstractC13042fc3.i(list, "messageList");
        AbstractC13042fc3.i(bytesValue, "loadMoreState");
        this.a = list;
        this.b = bytesValue;
    }

    public final BytesValue a() {
        return this.b;
    }

    public final List b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3792Cj2)) {
            return false;
        }
        C3792Cj2 c3792Cj2 = (C3792Cj2) obj;
        return AbstractC13042fc3.d(this.a, c3792Cj2.a) && AbstractC13042fc3.d(this.b, c3792Cj2.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "FeedResponse(messageList=" + this.a + ", loadMoreState=" + this.b + Separators.RPAREN;
    }
}
