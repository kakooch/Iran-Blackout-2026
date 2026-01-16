package ir.nasim;

import android.graphics.Rect;
import android.util.Size;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.internal.utils.ImageUtil;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Objects;

/* loaded from: classes.dex */
final class N03 implements InterfaceC15888kL4 {
    private final C10516bk3 a;

    static abstract class a {
        a() {
        }

        static a c(PS4 ps4, int i) {
            return new C14164hT(ps4, i);
        }

        abstract int a();

        abstract PS4 b();
    }

    N03(C6293Mz5 c6293Mz5) {
        this.a = new C10516bk3(c6293Mz5);
    }

    private static C14871id2 b(byte[] bArr) throws ImageCaptureException {
        try {
            return C14871id2.h(new ByteArrayInputStream(bArr));
        } catch (IOException e) {
            throw new ImageCaptureException(0, "Failed to extract Exif from YUV-generated JPEG", e);
        }
    }

    private PS4 c(a aVar, int i) {
        PS4 ps4B = aVar.b();
        byte[] bArrA = this.a.a((androidx.camera.core.f) ps4B.c());
        C14871id2 c14871id2D = ps4B.d();
        Objects.requireNonNull(c14871id2D);
        return PS4.m(bArrA, c14871id2D, i, ps4B.h(), ps4B.b(), ps4B.f(), ps4B.g(), ps4B.a());
    }

    private PS4 d(a aVar) throws ImageCaptureException {
        PS4 ps4B = aVar.b();
        androidx.camera.core.f fVar = (androidx.camera.core.f) ps4B.c();
        Rect rectB = ps4B.b();
        try {
            byte[] bArrJ = ImageUtil.j(fVar, rectB, aVar.a(), ps4B.f());
            return PS4.m(bArrJ, b(bArrJ), 256, new Size(rectB.width(), rectB.height()), new Rect(0, 0, rectB.width(), rectB.height()), ps4B.f(), AbstractC14447hv7.t(ps4B.g(), rectB), ps4B.a());
        } catch (ImageUtil.CodecFailedException e) {
            throw new ImageCaptureException(1, "Failed to encode the image to JPEG.", e);
        }
    }

    @Override // ir.nasim.InterfaceC15888kL4
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PS4 apply(a aVar) {
        PS4 ps4D;
        try {
            int iE = aVar.b().e();
            if (iE != 35) {
                if (iE != 256 && iE != 4101) {
                    throw new IllegalArgumentException("Unexpected format: " + iE);
                }
                ps4D = c(aVar, iE);
            } else {
                ps4D = d(aVar);
            }
            ((androidx.camera.core.f) aVar.b().c()).close();
            return ps4D;
        } catch (Throwable th) {
            ((androidx.camera.core.f) aVar.b().c()).close();
            throw th;
        }
    }
}
