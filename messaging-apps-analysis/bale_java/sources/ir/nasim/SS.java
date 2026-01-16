package ir.nasim;

import android.util.Size;
import ir.nasim.C14601iB0;
import java.util.List;

/* loaded from: classes.dex */
final class SS extends C14601iB0.k {
    private final String a;
    private final Class b;
    private final androidx.camera.core.impl.v c;
    private final androidx.camera.core.impl.C d;
    private final Size e;
    private final androidx.camera.core.impl.w f;
    private final List g;

    SS(String str, Class cls, androidx.camera.core.impl.v vVar, androidx.camera.core.impl.C c, Size size, androidx.camera.core.impl.w wVar, List list) {
        if (str == null) {
            throw new NullPointerException("Null useCaseId");
        }
        this.a = str;
        if (cls == null) {
            throw new NullPointerException("Null useCaseType");
        }
        this.b = cls;
        if (vVar == null) {
            throw new NullPointerException("Null sessionConfig");
        }
        this.c = vVar;
        if (c == null) {
            throw new NullPointerException("Null useCaseConfig");
        }
        this.d = c;
        this.e = size;
        this.f = wVar;
        this.g = list;
    }

    @Override // ir.nasim.C14601iB0.k
    List c() {
        return this.g;
    }

    @Override // ir.nasim.C14601iB0.k
    androidx.camera.core.impl.v d() {
        return this.c;
    }

    @Override // ir.nasim.C14601iB0.k
    androidx.camera.core.impl.w e() {
        return this.f;
    }

    public boolean equals(Object obj) {
        Size size;
        androidx.camera.core.impl.w wVar;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C14601iB0.k)) {
            return false;
        }
        C14601iB0.k kVar = (C14601iB0.k) obj;
        if (this.a.equals(kVar.h()) && this.b.equals(kVar.i()) && this.c.equals(kVar.d()) && this.d.equals(kVar.g()) && ((size = this.e) != null ? size.equals(kVar.f()) : kVar.f() == null) && ((wVar = this.f) != null ? wVar.equals(kVar.e()) : kVar.e() == null)) {
            List list = this.g;
            if (list == null) {
                if (kVar.c() == null) {
                    return true;
                }
            } else if (list.equals(kVar.c())) {
                return true;
            }
        }
        return false;
    }

    @Override // ir.nasim.C14601iB0.k
    Size f() {
        return this.e;
    }

    @Override // ir.nasim.C14601iB0.k
    androidx.camera.core.impl.C g() {
        return this.d;
    }

    @Override // ir.nasim.C14601iB0.k
    String h() {
        return this.a;
    }

    public int hashCode() {
        int iHashCode = (((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode()) * 1000003;
        Size size = this.e;
        int iHashCode2 = (iHashCode ^ (size == null ? 0 : size.hashCode())) * 1000003;
        androidx.camera.core.impl.w wVar = this.f;
        int iHashCode3 = (iHashCode2 ^ (wVar == null ? 0 : wVar.hashCode())) * 1000003;
        List list = this.g;
        return iHashCode3 ^ (list != null ? list.hashCode() : 0);
    }

    @Override // ir.nasim.C14601iB0.k
    Class i() {
        return this.b;
    }

    public String toString() {
        return "UseCaseInfo{useCaseId=" + this.a + ", useCaseType=" + this.b + ", sessionConfig=" + this.c + ", useCaseConfig=" + this.d + ", surfaceResolution=" + this.e + ", streamSpec=" + this.f + ", captureTypes=" + this.g + "}";
    }
}
