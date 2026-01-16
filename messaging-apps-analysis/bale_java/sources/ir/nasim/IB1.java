package ir.nasim;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public class IB1 extends H90 {
    private static Logger m = Logger.getLogger(IB1.class.getName());
    int d;
    int e;
    int f;
    int g;
    long h;
    long i;
    C18283oP j;
    List k = new ArrayList();
    byte[] l;

    @Override // ir.nasim.H90
    public void e(ByteBuffer byteBuffer) {
        int iA;
        this.d = AbstractC5635Ke3.m(byteBuffer);
        int iM = AbstractC5635Ke3.m(byteBuffer);
        this.e = iM >>> 2;
        this.f = (iM >> 1) & 1;
        this.g = AbstractC5635Ke3.i(byteBuffer);
        this.h = AbstractC5635Ke3.j(byteBuffer);
        this.i = AbstractC5635Ke3.j(byteBuffer);
        if (byteBuffer.remaining() > 2) {
            int iPosition = byteBuffer.position();
            H90 h90A = AbstractC18798pG4.a(this.d, byteBuffer);
            int iPosition2 = byteBuffer.position() - iPosition;
            Logger logger = m;
            StringBuilder sb = new StringBuilder();
            sb.append(h90A);
            sb.append(" - DecoderConfigDescr1 read: ");
            sb.append(iPosition2);
            sb.append(", size: ");
            sb.append(h90A != null ? Integer.valueOf(h90A.a()) : null);
            logger.finer(sb.toString());
            if (h90A != null && iPosition2 < (iA = h90A.a())) {
                byte[] bArr = new byte[iA - iPosition2];
                this.l = bArr;
                byteBuffer.get(bArr);
            }
            if (h90A instanceof C18283oP) {
                this.j = (C18283oP) h90A;
            }
        }
        while (byteBuffer.remaining() > 2) {
            long jPosition = byteBuffer.position();
            H90 h90A2 = AbstractC18798pG4.a(this.d, byteBuffer);
            long jPosition2 = byteBuffer.position() - jPosition;
            Logger logger2 = m;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(h90A2);
            sb2.append(" - DecoderConfigDescr2 read: ");
            sb2.append(jPosition2);
            sb2.append(", size: ");
            sb2.append(h90A2 != null ? Integer.valueOf(h90A2.a()) : null);
            logger2.finer(sb2.toString());
        }
    }

    public ByteBuffer f() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(g());
        AbstractC5869Le3.j(byteBufferAllocate, 4);
        AbstractC5869Le3.j(byteBufferAllocate, g() - 2);
        AbstractC5869Le3.j(byteBufferAllocate, this.d);
        AbstractC5869Le3.j(byteBufferAllocate, (this.e << 2) | (this.f << 1) | 1);
        AbstractC5869Le3.f(byteBufferAllocate, this.g);
        AbstractC5869Le3.g(byteBufferAllocate, this.h);
        AbstractC5869Le3.g(byteBufferAllocate, this.i);
        C18283oP c18283oP = this.j;
        if (c18283oP != null) {
            byteBufferAllocate.put(c18283oP.n().array());
        }
        return byteBufferAllocate;
    }

    public int g() {
        C18283oP c18283oP = this.j;
        return (c18283oP == null ? 0 : c18283oP.o()) + 15;
    }

    public void h(C18283oP c18283oP) {
        this.j = c18283oP;
    }

    public void i(long j) {
        this.i = j;
    }

    public void j(int i) {
        this.g = i;
    }

    public void k(long j) {
        this.h = j;
    }

    public void l(int i) {
        this.d = i;
    }

    public void m(int i) {
        this.e = i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DecoderConfigDescriptor");
        sb.append("{objectTypeIndication=");
        sb.append(this.d);
        sb.append(", streamType=");
        sb.append(this.e);
        sb.append(", upStream=");
        sb.append(this.f);
        sb.append(", bufferSizeDB=");
        sb.append(this.g);
        sb.append(", maxBitRate=");
        sb.append(this.h);
        sb.append(", avgBitRate=");
        sb.append(this.i);
        sb.append(", decoderSpecificInfo=");
        sb.append((Object) null);
        sb.append(", audioSpecificInfo=");
        sb.append(this.j);
        sb.append(", configDescriptorDeadBytes=");
        byte[] bArr = this.l;
        if (bArr == null) {
            bArr = new byte[0];
        }
        sb.append(AbstractC23185wV2.a(bArr));
        sb.append(", profileLevelIndicationDescriptors=");
        List list = this.k;
        sb.append(list == null ? "null" : Arrays.asList(list).toString());
        sb.append('}');
        return sb.toString();
    }
}
