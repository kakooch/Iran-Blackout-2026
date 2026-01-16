package androidx.camera.core.impl;

import androidx.camera.core.impl.v;
import ir.nasim.C15116j22;
import java.util.List;

/* renamed from: androidx.camera.core.impl.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C1923d extends v.f {
    private final DeferrableSurface a;
    private final List b;
    private final String c;
    private final int d;
    private final int e;
    private final C15116j22 f;

    /* renamed from: androidx.camera.core.impl.d$b */
    static final class b extends v.f.a {
        private DeferrableSurface a;
        private List b;
        private String c;
        private Integer d;
        private Integer e;
        private C15116j22 f;

        b() {
        }

        @Override // androidx.camera.core.impl.v.f.a
        public v.f a() {
            String str = "";
            if (this.a == null) {
                str = " surface";
            }
            if (this.b == null) {
                str = str + " sharedSurfaces";
            }
            if (this.d == null) {
                str = str + " mirrorMode";
            }
            if (this.e == null) {
                str = str + " surfaceGroupId";
            }
            if (this.f == null) {
                str = str + " dynamicRange";
            }
            if (str.isEmpty()) {
                return new C1923d(this.a, this.b, this.c, this.d.intValue(), this.e.intValue(), this.f);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // androidx.camera.core.impl.v.f.a
        public v.f.a b(C15116j22 c15116j22) {
            if (c15116j22 == null) {
                throw new NullPointerException("Null dynamicRange");
            }
            this.f = c15116j22;
            return this;
        }

        @Override // androidx.camera.core.impl.v.f.a
        public v.f.a c(int i) {
            this.d = Integer.valueOf(i);
            return this;
        }

        @Override // androidx.camera.core.impl.v.f.a
        public v.f.a d(String str) {
            this.c = str;
            return this;
        }

        @Override // androidx.camera.core.impl.v.f.a
        public v.f.a e(List list) {
            if (list == null) {
                throw new NullPointerException("Null sharedSurfaces");
            }
            this.b = list;
            return this;
        }

        @Override // androidx.camera.core.impl.v.f.a
        public v.f.a f(int i) {
            this.e = Integer.valueOf(i);
            return this;
        }

        public v.f.a g(DeferrableSurface deferrableSurface) {
            if (deferrableSurface == null) {
                throw new NullPointerException("Null surface");
            }
            this.a = deferrableSurface;
            return this;
        }
    }

    @Override // androidx.camera.core.impl.v.f
    public C15116j22 b() {
        return this.f;
    }

    @Override // androidx.camera.core.impl.v.f
    public int c() {
        return this.d;
    }

    @Override // androidx.camera.core.impl.v.f
    public String d() {
        return this.c;
    }

    @Override // androidx.camera.core.impl.v.f
    public List e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v.f)) {
            return false;
        }
        v.f fVar = (v.f) obj;
        return this.a.equals(fVar.f()) && this.b.equals(fVar.e()) && ((str = this.c) != null ? str.equals(fVar.d()) : fVar.d() == null) && this.d == fVar.c() && this.e == fVar.g() && this.f.equals(fVar.b());
    }

    @Override // androidx.camera.core.impl.v.f
    public DeferrableSurface f() {
        return this.a;
    }

    @Override // androidx.camera.core.impl.v.f
    public int g() {
        return this.e;
    }

    public int hashCode() {
        int iHashCode = (((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003;
        String str = this.c;
        return ((((((iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.d) * 1000003) ^ this.e) * 1000003) ^ this.f.hashCode();
    }

    public String toString() {
        return "OutputConfig{surface=" + this.a + ", sharedSurfaces=" + this.b + ", physicalCameraId=" + this.c + ", mirrorMode=" + this.d + ", surfaceGroupId=" + this.e + ", dynamicRange=" + this.f + "}";
    }

    private C1923d(DeferrableSurface deferrableSurface, List list, String str, int i, int i2, C15116j22 c15116j22) {
        this.a = deferrableSurface;
        this.b = list;
        this.c = str;
        this.d = i;
        this.e = i2;
        this.f = c15116j22;
    }
}
