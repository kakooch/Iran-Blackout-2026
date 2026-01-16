package ir.nasim;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.vV, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C22586vV {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public List f;
    public List g;
    public boolean h;
    public int i;
    public int j;
    public int k;
    public List l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;

    public C22586vV() {
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.h = true;
        this.i = 1;
        this.j = 0;
        this.k = 0;
        this.l = new ArrayList();
        this.m = 63;
        this.n = 7;
        this.o = 31;
        this.p = 31;
        this.q = 31;
    }

    public void a(ByteBuffer byteBuffer) {
        AbstractC5869Le3.j(byteBuffer, this.a);
        AbstractC5869Le3.j(byteBuffer, this.b);
        AbstractC5869Le3.j(byteBuffer, this.c);
        AbstractC5869Le3.j(byteBuffer, this.d);
        C6347Nf0 c6347Nf0 = new C6347Nf0(byteBuffer);
        c6347Nf0.a(this.m, 6);
        c6347Nf0.a(this.e, 2);
        c6347Nf0.a(this.n, 3);
        c6347Nf0.a(this.g.size(), 5);
        for (byte[] bArr : this.f) {
            AbstractC5869Le3.e(byteBuffer, bArr.length);
            byteBuffer.put(bArr);
        }
        AbstractC5869Le3.j(byteBuffer, this.g.size());
        for (byte[] bArr2 : this.g) {
            AbstractC5869Le3.e(byteBuffer, bArr2.length);
            byteBuffer.put(bArr2);
        }
        if (this.h) {
            int i = this.b;
            if (i == 100 || i == 110 || i == 122 || i == 144) {
                C6347Nf0 c6347Nf02 = new C6347Nf0(byteBuffer);
                c6347Nf02.a(this.o, 6);
                c6347Nf02.a(this.i, 2);
                c6347Nf02.a(this.p, 5);
                c6347Nf02.a(this.j, 3);
                c6347Nf02.a(this.q, 5);
                c6347Nf02.a(this.k, 3);
                for (byte[] bArr3 : this.l) {
                    AbstractC5869Le3.e(byteBuffer, bArr3.length);
                    byteBuffer.put(bArr3);
                }
            }
        }
    }

    public long b() {
        int i;
        long length = 6;
        while (this.f.iterator().hasNext()) {
            length = length + 2 + ((byte[]) r0.next()).length;
        }
        long length2 = length + 1;
        while (this.g.iterator().hasNext()) {
            length2 = length2 + 2 + ((byte[]) r3.next()).length;
        }
        if (this.h && ((i = this.b) == 100 || i == 110 || i == 122 || i == 144)) {
            length2 += 4;
            while (this.l.iterator().hasNext()) {
                length2 = length2 + 2 + ((byte[]) r0.next()).length;
            }
        }
        return length2;
    }

    public String toString() {
        return "AvcDecoderConfigurationRecord{configurationVersion=" + this.a + ", avcProfileIndication=" + this.b + ", profileCompatibility=" + this.c + ", avcLevelIndication=" + this.d + ", lengthSizeMinusOne=" + this.e + ", hasExts=" + this.h + ", chromaFormat=" + this.i + ", bitDepthLumaMinus8=" + this.j + ", bitDepthChromaMinus8=" + this.k + ", lengthSizeMinusOnePaddingBits=" + this.m + ", numberOfSequenceParameterSetsPaddingBits=" + this.n + ", chromaFormatPaddingBits=" + this.o + ", bitDepthLumaMinus8PaddingBits=" + this.p + ", bitDepthChromaMinus8PaddingBits=" + this.q + '}';
    }

    public C22586vV(ByteBuffer byteBuffer) {
        int i;
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.h = true;
        this.i = 1;
        this.j = 0;
        this.k = 0;
        this.l = new ArrayList();
        this.m = 63;
        this.n = 7;
        this.o = 31;
        this.p = 31;
        this.q = 31;
        this.a = AbstractC5635Ke3.m(byteBuffer);
        this.b = AbstractC5635Ke3.m(byteBuffer);
        this.c = AbstractC5635Ke3.m(byteBuffer);
        this.d = AbstractC5635Ke3.m(byteBuffer);
        C5641Kf0 c5641Kf0 = new C5641Kf0(byteBuffer);
        this.m = c5641Kf0.a(6);
        this.e = c5641Kf0.a(2);
        this.n = c5641Kf0.a(3);
        int iA = c5641Kf0.a(5);
        for (int i2 = 0; i2 < iA; i2++) {
            byte[] bArr = new byte[AbstractC5635Ke3.h(byteBuffer)];
            byteBuffer.get(bArr);
            this.f.add(bArr);
        }
        long jM = AbstractC5635Ke3.m(byteBuffer);
        for (int i3 = 0; i3 < jM; i3++) {
            byte[] bArr2 = new byte[AbstractC5635Ke3.h(byteBuffer)];
            byteBuffer.get(bArr2);
            this.g.add(bArr2);
        }
        if (byteBuffer.remaining() < 4) {
            this.h = false;
        }
        if (this.h && ((i = this.b) == 100 || i == 110 || i == 122 || i == 144)) {
            C5641Kf0 c5641Kf02 = new C5641Kf0(byteBuffer);
            this.o = c5641Kf02.a(6);
            this.i = c5641Kf02.a(2);
            this.p = c5641Kf02.a(5);
            this.j = c5641Kf02.a(3);
            this.q = c5641Kf02.a(5);
            this.k = c5641Kf02.a(3);
            long jM2 = AbstractC5635Ke3.m(byteBuffer);
            for (int i4 = 0; i4 < jM2; i4++) {
                byte[] bArr3 = new byte[AbstractC5635Ke3.h(byteBuffer)];
                byteBuffer.get(bArr3);
                this.l.add(bArr3);
            }
            return;
        }
        this.i = -1;
        this.j = -1;
        this.k = -1;
    }
}
