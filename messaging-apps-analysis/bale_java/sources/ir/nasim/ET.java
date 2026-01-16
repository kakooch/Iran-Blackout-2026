package ir.nasim;

import android.graphics.Rect;
import android.util.Size;
import ir.nasim.G27;

/* loaded from: classes.dex */
final class ET extends G27.a {
    private final Size a;
    private final Rect b;
    private final InterfaceC15221jD0 c;
    private final int d;
    private final boolean e;

    ET(Size size, Rect rect, InterfaceC15221jD0 interfaceC15221jD0, int i, boolean z) {
        if (size == null) {
            throw new NullPointerException("Null inputSize");
        }
        this.a = size;
        if (rect == null) {
            throw new NullPointerException("Null inputCropRect");
        }
        this.b = rect;
        this.c = interfaceC15221jD0;
        this.d = i;
        this.e = z;
    }

    @Override // ir.nasim.G27.a
    public InterfaceC15221jD0 a() {
        return this.c;
    }

    @Override // ir.nasim.G27.a
    public Rect b() {
        return this.b;
    }

    @Override // ir.nasim.G27.a
    public Size c() {
        return this.a;
    }

    @Override // ir.nasim.G27.a
    public boolean d() {
        return this.e;
    }

    @Override // ir.nasim.G27.a
    public int e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        InterfaceC15221jD0 interfaceC15221jD0;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof G27.a)) {
            return false;
        }
        G27.a aVar = (G27.a) obj;
        return this.a.equals(aVar.c()) && this.b.equals(aVar.b()) && ((interfaceC15221jD0 = this.c) != null ? interfaceC15221jD0.equals(aVar.a()) : aVar.a() == null) && this.d == aVar.e() && this.e == aVar.d();
    }

    public int hashCode() {
        int iHashCode = (((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003;
        InterfaceC15221jD0 interfaceC15221jD0 = this.c;
        return ((((iHashCode ^ (interfaceC15221jD0 == null ? 0 : interfaceC15221jD0.hashCode())) * 1000003) ^ this.d) * 1000003) ^ (this.e ? 1231 : 1237);
    }

    public String toString() {
        return "CameraInputInfo{inputSize=" + this.a + ", inputCropRect=" + this.b + ", cameraInternal=" + this.c + ", rotationDegrees=" + this.d + ", mirroring=" + this.e + "}";
    }
}
