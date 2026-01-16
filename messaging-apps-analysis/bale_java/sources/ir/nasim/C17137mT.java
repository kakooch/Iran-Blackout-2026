package ir.nasim;

import androidx.camera.core.internal.CameraUseCaseAdapter;
import ir.nasim.C13887gz3;

/* renamed from: ir.nasim.mT, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C17137mT extends C13887gz3.a {
    private final InterfaceC18633oz3 a;
    private final CameraUseCaseAdapter.a b;

    C17137mT(InterfaceC18633oz3 interfaceC18633oz3, CameraUseCaseAdapter.a aVar) {
        if (interfaceC18633oz3 == null) {
            throw new NullPointerException("Null lifecycleOwner");
        }
        this.a = interfaceC18633oz3;
        if (aVar == null) {
            throw new NullPointerException("Null cameraId");
        }
        this.b = aVar;
    }

    @Override // ir.nasim.C13887gz3.a
    public CameraUseCaseAdapter.a b() {
        return this.b;
    }

    @Override // ir.nasim.C13887gz3.a
    public InterfaceC18633oz3 c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C13887gz3.a)) {
            return false;
        }
        C13887gz3.a aVar = (C13887gz3.a) obj;
        return this.a.equals(aVar.c()) && this.b.equals(aVar.b());
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public String toString() {
        return "Key{lifecycleOwner=" + this.a + ", cameraId=" + this.b + "}";
    }
}
