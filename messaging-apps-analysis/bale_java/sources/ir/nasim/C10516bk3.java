package ir.nasim;

import androidx.camera.core.internal.compat.quirk.IncorrectJpegMetadataQuirk;
import java.nio.ByteBuffer;

/* renamed from: ir.nasim.bk3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C10516bk3 {
    private final IncorrectJpegMetadataQuirk a;

    public C10516bk3(C6293Mz5 c6293Mz5) {
        this.a = (IncorrectJpegMetadataQuirk) c6293Mz5.b(IncorrectJpegMetadataQuirk.class);
    }

    public byte[] a(androidx.camera.core.f fVar) {
        IncorrectJpegMetadataQuirk incorrectJpegMetadataQuirk = this.a;
        if (incorrectJpegMetadataQuirk != null) {
            return incorrectJpegMetadataQuirk.f(fVar);
        }
        ByteBuffer buffer = fVar.P0()[0].getBuffer();
        byte[] bArr = new byte[buffer.capacity()];
        buffer.rewind();
        buffer.get(bArr);
        return bArr;
    }
}
