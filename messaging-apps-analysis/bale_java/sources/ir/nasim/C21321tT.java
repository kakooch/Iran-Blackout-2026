package ir.nasim;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;

/* renamed from: ir.nasim.tT, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C21321tT extends PS4 {
    private final Object a;
    private final C14871id2 b;
    private final int c;
    private final Size d;
    private final Rect e;
    private final int f;
    private final Matrix g;
    private final QB0 h;

    C21321tT(Object obj, C14871id2 c14871id2, int i, Size size, Rect rect, int i2, Matrix matrix, QB0 qb0) {
        if (obj == null) {
            throw new NullPointerException("Null data");
        }
        this.a = obj;
        this.b = c14871id2;
        this.c = i;
        if (size == null) {
            throw new NullPointerException("Null size");
        }
        this.d = size;
        if (rect == null) {
            throw new NullPointerException("Null cropRect");
        }
        this.e = rect;
        this.f = i2;
        if (matrix == null) {
            throw new NullPointerException("Null sensorToBufferTransform");
        }
        this.g = matrix;
        if (qb0 == null) {
            throw new NullPointerException("Null cameraCaptureResult");
        }
        this.h = qb0;
    }

    @Override // ir.nasim.PS4
    public QB0 a() {
        return this.h;
    }

    @Override // ir.nasim.PS4
    public Rect b() {
        return this.e;
    }

    @Override // ir.nasim.PS4
    public Object c() {
        return this.a;
    }

    @Override // ir.nasim.PS4
    public C14871id2 d() {
        return this.b;
    }

    @Override // ir.nasim.PS4
    public int e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        C14871id2 c14871id2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PS4)) {
            return false;
        }
        PS4 ps4 = (PS4) obj;
        return this.a.equals(ps4.c()) && ((c14871id2 = this.b) != null ? c14871id2.equals(ps4.d()) : ps4.d() == null) && this.c == ps4.e() && this.d.equals(ps4.h()) && this.e.equals(ps4.b()) && this.f == ps4.f() && this.g.equals(ps4.g()) && this.h.equals(ps4.a());
    }

    @Override // ir.nasim.PS4
    public int f() {
        return this.f;
    }

    @Override // ir.nasim.PS4
    public Matrix g() {
        return this.g;
    }

    @Override // ir.nasim.PS4
    public Size h() {
        return this.d;
    }

    public int hashCode() {
        int iHashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        C14871id2 c14871id2 = this.b;
        return ((((((((((((iHashCode ^ (c14871id2 == null ? 0 : c14871id2.hashCode())) * 1000003) ^ this.c) * 1000003) ^ this.d.hashCode()) * 1000003) ^ this.e.hashCode()) * 1000003) ^ this.f) * 1000003) ^ this.g.hashCode()) * 1000003) ^ this.h.hashCode();
    }

    public String toString() {
        return "Packet{data=" + this.a + ", exif=" + this.b + ", format=" + this.c + ", size=" + this.d + ", cropRect=" + this.e + ", rotationDegrees=" + this.f + ", sensorToBufferTransform=" + this.g + ", cameraCaptureResult=" + this.h + "}";
    }
}
