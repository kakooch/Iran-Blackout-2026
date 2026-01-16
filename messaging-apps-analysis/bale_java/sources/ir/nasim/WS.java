package ir.nasim;

import android.util.Size;
import ir.nasim.QF0;

/* loaded from: classes.dex */
final class WS extends QF0.c {
    private final Size d;
    private final int e;
    private final int f;
    private final boolean g;
    private final Size h;
    private final int i;
    private final X22 j;
    private final X22 k;

    WS(Size size, int i, int i2, boolean z, P23 p23, Size size2, int i3, X22 x22, X22 x222) {
        if (size == null) {
            throw new NullPointerException("Null size");
        }
        this.d = size;
        this.e = i;
        this.f = i2;
        this.g = z;
        this.h = size2;
        this.i = i3;
        if (x22 == null) {
            throw new NullPointerException("Null requestEdge");
        }
        this.j = x22;
        if (x222 == null) {
            throw new NullPointerException("Null errorEdge");
        }
        this.k = x222;
    }

    @Override // ir.nasim.QF0.c
    X22 a() {
        return this.k;
    }

    @Override // ir.nasim.QF0.c
    P23 b() {
        return null;
    }

    @Override // ir.nasim.QF0.c
    int c() {
        return this.e;
    }

    @Override // ir.nasim.QF0.c
    int d() {
        return this.f;
    }

    @Override // ir.nasim.QF0.c
    int e() {
        return this.i;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof QF0.c)) {
            return false;
        }
        QF0.c cVar = (QF0.c) obj;
        if (this.d.equals(cVar.i()) && this.e == cVar.c() && this.f == cVar.d() && this.g == cVar.k()) {
            cVar.b();
            Size size = this.h;
            if (size != null ? size.equals(cVar.f()) : cVar.f() == null) {
                if (this.i == cVar.e() && this.j.equals(cVar.h()) && this.k.equals(cVar.a())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // ir.nasim.QF0.c
    Size f() {
        return this.h;
    }

    @Override // ir.nasim.QF0.c
    X22 h() {
        return this.j;
    }

    public int hashCode() {
        int iHashCode = (((((((this.d.hashCode() ^ 1000003) * 1000003) ^ this.e) * 1000003) ^ this.f) * 1000003) ^ (this.g ? 1231 : 1237)) * (-721379959);
        Size size = this.h;
        return ((((((iHashCode ^ (size == null ? 0 : size.hashCode())) * 1000003) ^ this.i) * 1000003) ^ this.j.hashCode()) * 1000003) ^ this.k.hashCode();
    }

    @Override // ir.nasim.QF0.c
    Size i() {
        return this.d;
    }

    @Override // ir.nasim.QF0.c
    boolean k() {
        return this.g;
    }

    public String toString() {
        return "In{size=" + this.d + ", inputFormat=" + this.e + ", outputFormat=" + this.f + ", virtualCamera=" + this.g + ", imageReaderProxyProvider=" + ((Object) null) + ", postviewSize=" + this.h + ", postviewImageFormat=" + this.i + ", requestEdge=" + this.j + ", errorEdge=" + this.k + "}";
    }
}
