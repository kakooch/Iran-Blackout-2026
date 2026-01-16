package ir.nasim;

import com.bumptech.glide.load.ImageHeaderParser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* renamed from: ir.nasim.nd2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C17824nd2 implements ImageHeaderParser {
    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int a(InputStream inputStream, LJ lj) {
        int iF = new C17233md2(inputStream).f("Orientation", 1);
        if (iF == 0) {
            return -1;
        }
        return iF;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int b(ByteBuffer byteBuffer, LJ lj) {
        return a(AbstractC5254Io0.g(byteBuffer), lj);
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType c(ByteBuffer byteBuffer) {
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType d(InputStream inputStream) {
        return ImageHeaderParser.ImageType.UNKNOWN;
    }
}
