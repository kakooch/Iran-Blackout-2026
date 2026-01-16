package ir.nasim;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes2.dex */
public class UX6 implements HW5 {
    private final List a;
    private final HW5 b;
    private final LJ c;

    public UX6(List list, HW5 hw5, LJ lj) {
        this.a = list;
        this.b = hw5;
        this.c = lj;
    }

    private static byte[] e(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
        } catch (IOException e) {
            if (!Log.isLoggable("StreamGifDecoder", 5)) {
                return null;
            }
            Log.w("StreamGifDecoder", "Error reading data from stream", e);
            return null;
        }
    }

    @Override // ir.nasim.HW5
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public DW5 a(InputStream inputStream, int i, int i2, HL4 hl4) throws IOException {
        byte[] bArrE = e(inputStream);
        if (bArrE == null) {
            return null;
        }
        return this.b.a(ByteBuffer.wrap(bArrE), i, i2, hl4);
    }

    @Override // ir.nasim.HW5
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(InputStream inputStream, HL4 hl4) {
        return !((Boolean) hl4.c(AbstractC23059wH2.b)).booleanValue() && com.bumptech.glide.load.a.f(this.a, inputStream, this.c) == ImageHeaderParser.ImageType.GIF;
    }
}
