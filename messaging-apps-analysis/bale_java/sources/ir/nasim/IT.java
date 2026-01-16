package ir.nasim;

import android.graphics.Matrix;
import android.graphics.Rect;
import ir.nasim.Z27;

/* loaded from: classes.dex */
final class IT extends Z27.h {
    private final Rect a;
    private final int b;
    private final int c;
    private final boolean d;
    private final Matrix e;
    private final boolean f;

    IT(Rect rect, int i, int i2, boolean z, Matrix matrix, boolean z2) {
        if (rect == null) {
            throw new NullPointerException("Null getCropRect");
        }
        this.a = rect;
        this.b = i;
        this.c = i2;
        this.d = z;
        if (matrix == null) {
            throw new NullPointerException("Null getSensorToBufferTransform");
        }
        this.e = matrix;
        this.f = z2;
    }

    @Override // ir.nasim.Z27.h
    public Rect a() {
        return this.a;
    }

    @Override // ir.nasim.Z27.h
    public int b() {
        return this.b;
    }

    @Override // ir.nasim.Z27.h
    public Matrix c() {
        return this.e;
    }

    @Override // ir.nasim.Z27.h
    public int d() {
        return this.c;
    }

    @Override // ir.nasim.Z27.h
    public boolean e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Z27.h)) {
            return false;
        }
        Z27.h hVar = (Z27.h) obj;
        return this.a.equals(hVar.a()) && this.b == hVar.b() && this.c == hVar.d() && this.d == hVar.e() && this.e.equals(hVar.c()) && this.f == hVar.f();
    }

    @Override // ir.nasim.Z27.h
    public boolean f() {
        return this.f;
    }

    public int hashCode() {
        return ((((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c) * 1000003) ^ (this.d ? 1231 : 1237)) * 1000003) ^ this.e.hashCode()) * 1000003) ^ (this.f ? 1231 : 1237);
    }

    public String toString() {
        return "TransformationInfo{getCropRect=" + this.a + ", getRotationDegrees=" + this.b + ", getTargetRotation=" + this.c + ", hasCameraTransform=" + this.d + ", getSensorToBufferTransform=" + this.e + ", isMirroring=" + this.f + "}";
    }
}
