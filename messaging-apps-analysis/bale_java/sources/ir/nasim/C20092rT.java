package ir.nasim;

import android.graphics.Rect;
import android.util.Size;
import java.util.UUID;

/* renamed from: ir.nasim.rT, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C20092rT extends MM4 {
    private final UUID a;
    private final int b;
    private final int c;
    private final Rect d;
    private final Size e;
    private final int f;
    private final boolean g;
    private final boolean h;

    C20092rT(UUID uuid, int i, int i2, Rect rect, Size size, int i3, boolean z, boolean z2) {
        if (uuid == null) {
            throw new NullPointerException("Null getUuid");
        }
        this.a = uuid;
        this.b = i;
        this.c = i2;
        if (rect == null) {
            throw new NullPointerException("Null getCropRect");
        }
        this.d = rect;
        if (size == null) {
            throw new NullPointerException("Null getSize");
        }
        this.e = size;
        this.f = i3;
        this.g = z;
        this.h = z2;
    }

    @Override // ir.nasim.MM4
    public Rect a() {
        return this.d;
    }

    @Override // ir.nasim.MM4
    public int b() {
        return this.c;
    }

    @Override // ir.nasim.MM4
    public int c() {
        return this.f;
    }

    @Override // ir.nasim.MM4
    public Size d() {
        return this.e;
    }

    @Override // ir.nasim.MM4
    public int e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MM4)) {
            return false;
        }
        MM4 mm4 = (MM4) obj;
        return this.a.equals(mm4.f()) && this.b == mm4.e() && this.c == mm4.b() && this.d.equals(mm4.a()) && this.e.equals(mm4.d()) && this.f == mm4.c() && this.g == mm4.g() && this.h == mm4.j();
    }

    @Override // ir.nasim.MM4
    UUID f() {
        return this.a;
    }

    @Override // ir.nasim.MM4
    public boolean g() {
        return this.g;
    }

    public int hashCode() {
        return ((((((((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c) * 1000003) ^ this.d.hashCode()) * 1000003) ^ this.e.hashCode()) * 1000003) ^ this.f) * 1000003) ^ (this.g ? 1231 : 1237)) * 1000003) ^ (this.h ? 1231 : 1237);
    }

    @Override // ir.nasim.MM4
    public boolean j() {
        return this.h;
    }

    public String toString() {
        return "OutConfig{getUuid=" + this.a + ", getTargets=" + this.b + ", getFormat=" + this.c + ", getCropRect=" + this.d + ", getSize=" + this.e + ", getRotationDegrees=" + this.f + ", isMirroring=" + this.g + ", shouldRespectInputCropRect=" + this.h + "}";
    }
}
