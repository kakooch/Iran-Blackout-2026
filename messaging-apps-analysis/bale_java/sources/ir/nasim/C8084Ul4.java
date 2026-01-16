package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.Ul4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C8084Ul4 {
    private final List a;
    private final InterfaceC7850Tl4 b;

    public C8084Ul4(List list, InterfaceC7850Tl4 interfaceC7850Tl4) {
        AbstractC13042fc3.i(list, "fileIds");
        AbstractC13042fc3.i(interfaceC7850Tl4, "callback");
        this.a = list;
        this.b = interfaceC7850Tl4;
    }

    public final List a() {
        return this.a;
    }

    public final InterfaceC7850Tl4 b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C8084Ul4)) {
            return false;
        }
        C8084Ul4 c8084Ul4 = (C8084Ul4) obj;
        return AbstractC13042fc3.d(this.a, c8084Ul4.a) && AbstractC13042fc3.d(this.b, c8084Ul4.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "MultipleFileRequestState(fileIds=" + this.a + ", callback=" + this.b + Separators.RPAREN;
    }
}
