package ir.nasim;

import ir.nasim.features.audioplayer.audioinfo.mp3.ID3v2Exception;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes5.dex */
public class GZ2 {
    static final ThreadLocal e = new a();
    private final C21193tG5 a;
    private final KZ2 b;
    private final HZ2 c;
    private final EZ2 d;

    class a extends ThreadLocal {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b initialValue() {
            return new b(4096);
        }
    }

    static final class b {
        byte[] a;

        b(int i) {
            this.a = new byte[i];
        }

        byte[] a(int i) {
            byte[] bArr = this.a;
            if (i > bArr.length) {
                int length = bArr.length;
                do {
                    length *= 2;
                } while (i > length);
                this.a = new byte[length];
            }
            return this.a;
        }
    }

    GZ2(InputStream inputStream, long j, int i, KZ2 kz2, HZ2 hz2) {
        C21193tG5 c21193tG5 = new C21193tG5(inputStream, j, i);
        this.a = c21193tG5;
        this.d = new EZ2(c21193tG5);
        this.b = kz2;
        this.c = hz2;
    }

    private String a(byte[] bArr, int i, int i2, FZ2 fz2, boolean z) {
        if (z) {
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (i3 < i2) {
                    int i5 = i + i3;
                    if (bArr[i5] != 0 || (fz2 == FZ2.UTF_16 && i4 == 0 && i5 % 2 != 0)) {
                        i4 = 0;
                    } else {
                        i4++;
                        if (i4 == fz2.p()) {
                            i2 = (i3 + 1) - fz2.p();
                            break;
                        }
                    }
                    i3++;
                }
            }
        }
        try {
            String str = new String(bArr, i, i2, fz2.j().name());
            return (str.length() <= 0 || str.charAt(0) != 65279) ? str : str.substring(1);
        } catch (Exception unused) {
            return "";
        }
    }

    public EZ2 b() {
        return this.d;
    }

    public HZ2 c() {
        return this.c;
    }

    public long d() {
        return this.a.a();
    }

    public long e() {
        return this.a.b();
    }

    public KZ2 f() {
        return this.b;
    }

    public FZ2 g() throws ID3v2Exception, IOException {
        byte bA = this.d.a();
        if (bA == 0) {
            return FZ2.ISO_8859_1;
        }
        if (bA == 1) {
            return FZ2.UTF_16;
        }
        if (bA == 2) {
            return FZ2.UTF_16BE;
        }
        if (bA == 3) {
            return FZ2.UTF_8;
        }
        throw new ID3v2Exception("Invalid encoding: " + ((int) bA));
    }

    public String h(int i, FZ2 fz2) throws ID3v2Exception, IOException {
        if (i <= e()) {
            byte[] bArrA = ((b) e.get()).a(i);
            this.d.b(bArrA, 0, i);
            return a(bArrA, 0, i, fz2, true);
        }
        throw new ID3v2Exception("Could not read fixed-length string of length: " + i);
    }

    public String i(int i, FZ2 fz2) throws ID3v2Exception, IOException {
        int iMin = Math.min(i, (int) e());
        byte[] bArrA = ((b) e.get()).a(iMin);
        int i2 = 0;
        for (int i3 = 0; i3 < iMin; i3++) {
            byte bA = this.d.a();
            bArrA[i3] = bA;
            if (bA != 0 || (fz2 == FZ2.UTF_16 && i2 == 0 && i3 % 2 != 0)) {
                i2 = 0;
            } else {
                i2++;
                if (i2 == fz2.p()) {
                    return a(bArrA, 0, (i3 + 1) - fz2.p(), fz2, false);
                }
            }
        }
        throw new ID3v2Exception("Could not read zero-termiated string");
    }

    public String toString() {
        return "id3v2frame[pos=" + d() + ", " + e() + " left]";
    }
}
