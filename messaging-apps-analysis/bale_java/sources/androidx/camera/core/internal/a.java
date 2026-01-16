package androidx.camera.core.internal;

import androidx.camera.core.internal.CameraUseCaseAdapter;
import ir.nasim.I03;

/* loaded from: classes.dex */
final class a extends CameraUseCaseAdapter.a {
    private final String a;
    private final I03 b;

    a(String str, I03 i03) {
        if (str == null) {
            throw new NullPointerException("Null cameraIdString");
        }
        this.a = str;
        if (i03 == null) {
            throw new NullPointerException("Null cameraConfigId");
        }
        this.b = i03;
    }

    @Override // androidx.camera.core.internal.CameraUseCaseAdapter.a
    public I03 b() {
        return this.b;
    }

    @Override // androidx.camera.core.internal.CameraUseCaseAdapter.a
    public String c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CameraUseCaseAdapter.a)) {
            return false;
        }
        CameraUseCaseAdapter.a aVar = (CameraUseCaseAdapter.a) obj;
        return this.a.equals(aVar.c()) && this.b.equals(aVar.b());
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public String toString() {
        return "CameraId{cameraIdString=" + this.a + ", cameraConfigId=" + this.b + "}";
    }
}
