package ir.nasim;

import ir.nasim.N12;
import java.util.List;

/* renamed from: ir.nasim.aT, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C9729aT extends N12.b {
    private final C27 a;
    private final C27 b;
    private final List c;

    C9729aT(C27 c27, C27 c272, List list) {
        if (c27 == null) {
            throw new NullPointerException("Null primarySurfaceEdge");
        }
        this.a = c27;
        if (c272 == null) {
            throw new NullPointerException("Null secondarySurfaceEdge");
        }
        this.b = c272;
        if (list == null) {
            throw new NullPointerException("Null outConfigs");
        }
        this.c = list;
    }

    @Override // ir.nasim.N12.b
    public List a() {
        return this.c;
    }

    @Override // ir.nasim.N12.b
    public C27 b() {
        return this.a;
    }

    @Override // ir.nasim.N12.b
    public C27 c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof N12.b)) {
            return false;
        }
        N12.b bVar = (N12.b) obj;
        return this.a.equals(bVar.b()) && this.b.equals(bVar.c()) && this.c.equals(bVar.a());
    }

    public int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode();
    }

    public String toString() {
        return "In{primarySurfaceEdge=" + this.a + ", secondarySurfaceEdge=" + this.b + ", outConfigs=" + this.c + "}";
    }
}
