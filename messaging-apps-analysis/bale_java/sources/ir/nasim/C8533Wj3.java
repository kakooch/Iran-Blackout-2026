package ir.nasim;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import androidx.camera.core.ImageCaptureException;
import java.io.IOException;
import java.util.Objects;

/* renamed from: ir.nasim.Wj3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C8533Wj3 implements InterfaceC15888kL4 {
    C8533Wj3() {
    }

    private Bitmap b(byte[] bArr, Rect rect) throws ImageCaptureException, IOException {
        try {
            return BitmapRegionDecoder.newInstance(bArr, 0, bArr.length, false).decodeRegion(rect, new BitmapFactory.Options());
        } catch (IOException e) {
            throw new ImageCaptureException(1, "Failed to decode JPEG.", e);
        }
    }

    @Override // ir.nasim.InterfaceC15888kL4
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PS4 apply(PS4 ps4) throws ImageCaptureException, IOException {
        Rect rectB = ps4.b();
        Bitmap bitmapB = b((byte[]) ps4.c(), rectB);
        C14871id2 c14871id2D = ps4.d();
        Objects.requireNonNull(c14871id2D);
        return PS4.j(bitmapB, c14871id2D, new Rect(0, 0, bitmapB.getWidth(), bitmapB.getHeight()), ps4.f(), AbstractC14447hv7.t(ps4.g(), rectB), ps4.a());
    }
}
