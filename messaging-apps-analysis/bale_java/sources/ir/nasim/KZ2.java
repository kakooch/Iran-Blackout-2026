package ir.nasim;

import ir.nasim.features.audioplayer.audioinfo.mp3.ID3v2Exception;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes5.dex */
public class KZ2 {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private boolean g;
    private boolean h;

    public KZ2(InputStream inputStream) {
        this(new C8526Wi5(inputStream));
    }

    public int a() {
        return this.f;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.a;
    }

    public JZ2 d(InputStream inputStream) throws ID3v2Exception, IOException {
        if (this.h) {
            throw new ID3v2Exception("Tag compression is not supported");
        }
        if (this.a >= 4 || !this.g) {
            int i = this.c;
            return new JZ2(inputStream, i, (this.d - i) - this.f, this);
        }
        byte[] bArrC = new EZ2(inputStream).c(this.d - this.c);
        int length = bArrC.length;
        boolean z = false;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            byte b = bArrC[i3];
            if (!z || b != 0) {
                bArrC[i2] = b;
                i2++;
            }
            z = b == 255;
        }
        return new JZ2(new ByteArrayInputStream(bArrC, 0, i2), this.c, i2, this);
    }

    public String toString() {
        return String.format("%s[version=%s, totalTagSize=%d]", getClass().getSimpleName(), Integer.valueOf(this.a), Integer.valueOf(this.d));
    }

    KZ2(C8526Wi5 c8526Wi5) throws ID3v2Exception, IOException {
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        long jA = c8526Wi5.a();
        EZ2 ez2 = new EZ2(c8526Wi5);
        String str = new String(ez2.c(3), "ISO-8859-1");
        if (!"ID3".equals(str)) {
            throw new ID3v2Exception("Invalid ID3 identifier: " + str);
        }
        byte bA = ez2.a();
        this.a = bA;
        if (bA != 2 && bA != 3 && bA != 4) {
            throw new ID3v2Exception("Unsupported ID3v2 version: " + this.a);
        }
        this.b = ez2.a();
        byte bA2 = ez2.a();
        this.d = ez2.e() + 10;
        int i = this.a;
        if (i == 2) {
            this.g = (bA2 & 128) != 0;
            this.h = (bA2 & 64) != 0;
        } else {
            this.g = (bA2 & 128) != 0;
            if ((bA2 & 64) != 0) {
                if (i == 3) {
                    int iD = ez2.d();
                    ez2.a();
                    ez2.a();
                    this.e = ez2.d();
                    ez2.f(iD - 6);
                } else {
                    ez2.f(ez2.e() - 4);
                }
            }
            if (this.a >= 4 && (bA2 & 16) != 0) {
                this.f = 10;
                this.d += 10;
            }
        }
        this.c = (int) (c8526Wi5.a() - jA);
    }
}
