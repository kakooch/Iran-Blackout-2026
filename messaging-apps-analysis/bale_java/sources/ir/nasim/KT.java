package ir.nasim;

import androidx.camera.core.ImageCaptureException;
import ir.nasim.C17889nj7;

/* loaded from: classes.dex */
final class KT extends C17889nj7.a {
    private final int a;
    private final ImageCaptureException b;

    KT(int i, ImageCaptureException imageCaptureException) {
        this.a = i;
        if (imageCaptureException == null) {
            throw new NullPointerException("Null imageCaptureException");
        }
        this.b = imageCaptureException;
    }

    @Override // ir.nasim.C17889nj7.a
    ImageCaptureException a() {
        return this.b;
    }

    @Override // ir.nasim.C17889nj7.a
    int b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C17889nj7.a)) {
            return false;
        }
        C17889nj7.a aVar = (C17889nj7.a) obj;
        return this.a == aVar.b() && this.b.equals(aVar.a());
    }

    public int hashCode() {
        return ((this.a ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public String toString() {
        return "CaptureError{requestId=" + this.a + ", imageCaptureException=" + this.b + "}";
    }
}
