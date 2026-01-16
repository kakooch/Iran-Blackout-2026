package ir.nasim;

import android.util.Size;
import java.util.Map;

/* loaded from: classes.dex */
final class JT extends AbstractC9496a37 {
    private final Size a;
    private final Map b;
    private final Size c;
    private final Map d;
    private final Size e;
    private final Map f;
    private final Map g;

    JT(Size size, Map map, Size size2, Map map2, Size size3, Map map3, Map map4) {
        if (size == null) {
            throw new NullPointerException("Null analysisSize");
        }
        this.a = size;
        if (map == null) {
            throw new NullPointerException("Null s720pSizeMap");
        }
        this.b = map;
        if (size2 == null) {
            throw new NullPointerException("Null previewSize");
        }
        this.c = size2;
        if (map2 == null) {
            throw new NullPointerException("Null s1440pSizeMap");
        }
        this.d = map2;
        if (size3 == null) {
            throw new NullPointerException("Null recordSize");
        }
        this.e = size3;
        if (map3 == null) {
            throw new NullPointerException("Null maximumSizeMap");
        }
        this.f = map3;
        if (map4 == null) {
            throw new NullPointerException("Null ultraMaximumSizeMap");
        }
        this.g = map4;
    }

    @Override // ir.nasim.AbstractC9496a37
    public Size b() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC9496a37
    public Map d() {
        return this.f;
    }

    @Override // ir.nasim.AbstractC9496a37
    public Size e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC9496a37)) {
            return false;
        }
        AbstractC9496a37 abstractC9496a37 = (AbstractC9496a37) obj;
        return this.a.equals(abstractC9496a37.b()) && this.b.equals(abstractC9496a37.j()) && this.c.equals(abstractC9496a37.e()) && this.d.equals(abstractC9496a37.h()) && this.e.equals(abstractC9496a37.f()) && this.f.equals(abstractC9496a37.d()) && this.g.equals(abstractC9496a37.l());
    }

    @Override // ir.nasim.AbstractC9496a37
    public Size f() {
        return this.e;
    }

    @Override // ir.nasim.AbstractC9496a37
    public Map h() {
        return this.d;
    }

    public int hashCode() {
        return ((((((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode()) * 1000003) ^ this.e.hashCode()) * 1000003) ^ this.f.hashCode()) * 1000003) ^ this.g.hashCode();
    }

    @Override // ir.nasim.AbstractC9496a37
    public Map j() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC9496a37
    public Map l() {
        return this.g;
    }

    public String toString() {
        return "SurfaceSizeDefinition{analysisSize=" + this.a + ", s720pSizeMap=" + this.b + ", previewSize=" + this.c + ", s1440pSizeMap=" + this.d + ", recordSize=" + this.e + ", maximumSizeMap=" + this.f + ", ultraMaximumSizeMap=" + this.g + "}";
    }
}
