package ir.nasim;

import ir.nasim.features.audioplayer.audioinfo.mp3.ID3v2Exception;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.InflaterInputStream;

/* loaded from: classes5.dex */
public class JZ2 {
    private final C21193tG5 a;
    private final KZ2 b;
    private final EZ2 c;

    JZ2(InputStream inputStream, long j, int i, KZ2 kz2) {
        C21193tG5 c21193tG5 = new C21193tG5(inputStream, j, i);
        this.a = c21193tG5;
        this.c = new EZ2(c21193tG5);
        this.b = kz2;
    }

    public GZ2 a(HZ2 hz2) throws ID3v2Exception, IOException {
        int iB;
        InputStream inflaterInputStream;
        int iA = hz2.a();
        InputStream byteArrayInputStream = this.a;
        if (hz2.h()) {
            byte[] bArrC = this.c.c(hz2.a());
            int length = bArrC.length;
            int i = 0;
            boolean z = false;
            for (int i2 = 0; i2 < length; i2++) {
                byte b = bArrC[i2];
                if (!z || b != 0) {
                    bArrC[i] = b;
                    i++;
                }
                z = b == 255;
            }
            byteArrayInputStream = new ByteArrayInputStream(bArrC, 0, i);
            iA = i;
        }
        if (hz2.f()) {
            throw new ID3v2Exception("Frame encryption is not supported");
        }
        if (hz2.e()) {
            iB = hz2.b();
            inflaterInputStream = new InflaterInputStream(byteArrayInputStream);
        } else {
            iB = iA;
            inflaterInputStream = byteArrayInputStream;
        }
        return new GZ2(inflaterInputStream, hz2.d(), iB, this.b, hz2);
    }

    public EZ2 b() {
        return this.c;
    }

    public long c() {
        return this.a.a();
    }

    public long d() {
        return this.a.b();
    }

    public KZ2 e() {
        return this.b;
    }

    public String toString() {
        return "id3v2tag[pos=" + c() + ", " + d() + " left]";
    }
}
