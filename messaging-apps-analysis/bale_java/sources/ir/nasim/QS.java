package ir.nasim;

import java.util.List;

/* loaded from: classes2.dex */
final class QS extends AbstractC22662vd0 {
    private final List a;

    QS(List list) {
        if (list == null) {
            throw new NullPointerException("Null logRequests");
        }
        this.a = list;
    }

    @Override // ir.nasim.AbstractC22662vd0
    public List c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC22662vd0) {
            return this.a.equals(((AbstractC22662vd0) obj).c());
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "BatchedLogRequest{logRequests=" + this.a + "}";
    }
}
