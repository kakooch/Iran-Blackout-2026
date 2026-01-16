package androidx.camera.core.impl;

import android.util.Range;
import android.util.Size;
import ir.nasim.AbstractC19849r27;
import ir.nasim.C15116j22;
import java.util.List;

/* renamed from: androidx.camera.core.impl.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C1921b extends AbstractC1920a {
    private final AbstractC19849r27 a;
    private final int b;
    private final Size c;
    private final C15116j22 d;
    private final List e;
    private final j f;
    private final Range g;

    C1921b(AbstractC19849r27 abstractC19849r27, int i, Size size, C15116j22 c15116j22, List list, j jVar, Range range) {
        if (abstractC19849r27 == null) {
            throw new NullPointerException("Null surfaceConfig");
        }
        this.a = abstractC19849r27;
        this.b = i;
        if (size == null) {
            throw new NullPointerException("Null size");
        }
        this.c = size;
        if (c15116j22 == null) {
            throw new NullPointerException("Null dynamicRange");
        }
        this.d = c15116j22;
        if (list == null) {
            throw new NullPointerException("Null captureTypes");
        }
        this.e = list;
        this.f = jVar;
        this.g = range;
    }

    @Override // androidx.camera.core.impl.AbstractC1920a
    public List b() {
        return this.e;
    }

    @Override // androidx.camera.core.impl.AbstractC1920a
    public C15116j22 c() {
        return this.d;
    }

    @Override // androidx.camera.core.impl.AbstractC1920a
    public int d() {
        return this.b;
    }

    @Override // androidx.camera.core.impl.AbstractC1920a
    public j e() {
        return this.f;
    }

    public boolean equals(Object obj) {
        j jVar;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC1920a)) {
            return false;
        }
        AbstractC1920a abstractC1920a = (AbstractC1920a) obj;
        if (this.a.equals(abstractC1920a.g()) && this.b == abstractC1920a.d() && this.c.equals(abstractC1920a.f()) && this.d.equals(abstractC1920a.c()) && this.e.equals(abstractC1920a.b()) && ((jVar = this.f) != null ? jVar.equals(abstractC1920a.e()) : abstractC1920a.e() == null)) {
            Range range = this.g;
            if (range == null) {
                if (abstractC1920a.h() == null) {
                    return true;
                }
            } else if (range.equals(abstractC1920a.h())) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.core.impl.AbstractC1920a
    public Size f() {
        return this.c;
    }

    @Override // androidx.camera.core.impl.AbstractC1920a
    public AbstractC19849r27 g() {
        return this.a;
    }

    @Override // androidx.camera.core.impl.AbstractC1920a
    public Range h() {
        return this.g;
    }

    public int hashCode() {
        int iHashCode = (((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode()) * 1000003) ^ this.e.hashCode()) * 1000003;
        j jVar = this.f;
        int iHashCode2 = (iHashCode ^ (jVar == null ? 0 : jVar.hashCode())) * 1000003;
        Range range = this.g;
        return iHashCode2 ^ (range != null ? range.hashCode() : 0);
    }

    public String toString() {
        return "AttachedSurfaceInfo{surfaceConfig=" + this.a + ", imageFormat=" + this.b + ", size=" + this.c + ", dynamicRange=" + this.d + ", captureTypes=" + this.e + ", implementationOptions=" + this.f + ", targetFrameRate=" + this.g + "}";
    }
}
