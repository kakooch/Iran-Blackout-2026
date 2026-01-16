package ir.nasim;

import ir.nasim.P27;
import java.util.List;

/* loaded from: classes.dex */
final class GT extends P27.b {
    private final C27 a;
    private final List b;

    GT(C27 c27, List list) {
        if (c27 == null) {
            throw new NullPointerException("Null surfaceEdge");
        }
        this.a = c27;
        if (list == null) {
            throw new NullPointerException("Null outConfigs");
        }
        this.b = list;
    }

    @Override // ir.nasim.P27.b
    public List a() {
        return this.b;
    }

    @Override // ir.nasim.P27.b
    public C27 b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof P27.b)) {
            return false;
        }
        P27.b bVar = (P27.b) obj;
        return this.a.equals(bVar.b()) && this.b.equals(bVar.a());
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public String toString() {
        return "In{surfaceEdge=" + this.a + ", outConfigs=" + this.b + "}";
    }
}
