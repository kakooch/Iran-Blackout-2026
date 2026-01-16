package ir.nasim;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public class G22 extends H90 {
    private static Logger q = Logger.getLogger(G22.class.getName());
    int d;
    int e;
    int f;
    int g;
    int h;
    String j;
    int k;
    int l;
    int m;
    IB1 n;
    M76 o;
    int i = 0;
    List p = new ArrayList();

    @Override // ir.nasim.H90
    public void e(ByteBuffer byteBuffer) {
        this.d = AbstractC5635Ke3.h(byteBuffer);
        int iM = AbstractC5635Ke3.m(byteBuffer);
        int i = iM >>> 7;
        this.e = i;
        this.f = (iM >>> 6) & 1;
        this.g = (iM >>> 5) & 1;
        this.h = iM & 31;
        if (i == 1) {
            this.l = AbstractC5635Ke3.h(byteBuffer);
        }
        if (this.f == 1) {
            int iM2 = AbstractC5635Ke3.m(byteBuffer);
            this.i = iM2;
            this.j = AbstractC5635Ke3.g(byteBuffer, iM2);
        }
        if (this.g == 1) {
            this.m = AbstractC5635Ke3.h(byteBuffer);
        }
        int iB = b() + 4 + (this.e == 1 ? 2 : 0) + (this.f == 1 ? this.i + 1 : 0) + (this.g == 1 ? 2 : 0);
        int iPosition = byteBuffer.position();
        if (a() > iB + 2) {
            H90 h90A = AbstractC18798pG4.a(-1, byteBuffer);
            long jPosition = byteBuffer.position() - iPosition;
            Logger logger = q;
            StringBuilder sb = new StringBuilder();
            sb.append(h90A);
            sb.append(" - ESDescriptor1 read: ");
            sb.append(jPosition);
            sb.append(", size: ");
            sb.append(h90A != null ? Integer.valueOf(h90A.a()) : null);
            logger.finer(sb.toString());
            if (h90A != null) {
                int iA = h90A.a();
                byteBuffer.position(iPosition + iA);
                iB += iA;
            } else {
                iB = (int) (iB + jPosition);
            }
            if (h90A instanceof IB1) {
                this.n = (IB1) h90A;
            }
        }
        int iPosition2 = byteBuffer.position();
        if (a() > iB + 2) {
            H90 h90A2 = AbstractC18798pG4.a(-1, byteBuffer);
            long jPosition2 = byteBuffer.position() - iPosition2;
            Logger logger2 = q;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(h90A2);
            sb2.append(" - ESDescriptor2 read: ");
            sb2.append(jPosition2);
            sb2.append(", size: ");
            sb2.append(h90A2 != null ? Integer.valueOf(h90A2.a()) : null);
            logger2.finer(sb2.toString());
            if (h90A2 != null) {
                int iA2 = h90A2.a();
                byteBuffer.position(iPosition2 + iA2);
                iB += iA2;
            } else {
                iB = (int) (iB + jPosition2);
            }
            if (h90A2 instanceof M76) {
                this.o = (M76) h90A2;
            }
        } else {
            q.warning("SLConfigDescriptor is missing!");
        }
        while (a() - iB > 2) {
            int iPosition3 = byteBuffer.position();
            H90 h90A3 = AbstractC18798pG4.a(-1, byteBuffer);
            long jPosition3 = byteBuffer.position() - iPosition3;
            Logger logger3 = q;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(h90A3);
            sb3.append(" - ESDescriptor3 read: ");
            sb3.append(jPosition3);
            sb3.append(", size: ");
            sb3.append(h90A3 != null ? Integer.valueOf(h90A3.a()) : null);
            logger3.finer(sb3.toString());
            if (h90A3 != null) {
                int iA3 = h90A3.a();
                byteBuffer.position(iPosition3 + iA3);
                iB += iA3;
            } else {
                iB = (int) (iB + jPosition3);
            }
            this.p.add(h90A3);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        G22 g22 = (G22) obj;
        if (this.f != g22.f || this.i != g22.i || this.l != g22.l || this.d != g22.d || this.m != g22.m || this.g != g22.g || this.k != g22.k || this.e != g22.e || this.h != g22.h) {
            return false;
        }
        String str = this.j;
        if (str == null ? g22.j != null : !str.equals(g22.j)) {
            return false;
        }
        IB1 ib1 = this.n;
        if (ib1 == null ? g22.n != null : !ib1.equals(g22.n)) {
            return false;
        }
        List list = this.p;
        if (list == null ? g22.p != null : !list.equals(g22.p)) {
            return false;
        }
        M76 m76 = this.o;
        M76 m762 = g22.o;
        return m76 == null ? m762 == null : m76.equals(m762);
    }

    public ByteBuffer f() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(g());
        AbstractC5869Le3.j(byteBufferAllocate, 3);
        AbstractC5869Le3.j(byteBufferAllocate, g() - 2);
        AbstractC5869Le3.e(byteBufferAllocate, this.d);
        AbstractC5869Le3.j(byteBufferAllocate, (this.e << 7) | (this.f << 6) | (this.g << 5) | (this.h & 31));
        if (this.e > 0) {
            AbstractC5869Le3.e(byteBufferAllocate, this.l);
        }
        if (this.f > 0) {
            AbstractC5869Le3.j(byteBufferAllocate, this.i);
            AbstractC5869Le3.k(byteBufferAllocate, this.j);
        }
        if (this.g > 0) {
            AbstractC5869Le3.e(byteBufferAllocate, this.m);
        }
        ByteBuffer byteBufferF = this.n.f();
        ByteBuffer byteBufferF2 = this.o.f();
        byteBufferAllocate.put(byteBufferF.array());
        byteBufferAllocate.put(byteBufferF2.array());
        return byteBufferAllocate;
    }

    public int g() {
        int i = this.e > 0 ? 7 : 5;
        if (this.f > 0) {
            i += this.i + 1;
        }
        if (this.g > 0) {
            i += 2;
        }
        return i + this.n.g() + this.o.g();
    }

    public void h(IB1 ib1) {
        this.n = ib1;
    }

    public int hashCode() {
        int i = ((((((((((this.d * 31) + this.e) * 31) + this.f) * 31) + this.g) * 31) + this.h) * 31) + this.i) * 31;
        String str = this.j;
        int iHashCode = (((((((i + (str != null ? str.hashCode() : 0)) * 31) + this.k) * 31) + this.l) * 31) + this.m) * 31;
        IB1 ib1 = this.n;
        int iHashCode2 = (iHashCode + (ib1 != null ? ib1.hashCode() : 0)) * 31;
        M76 m76 = this.o;
        int iHashCode3 = (iHashCode2 + (m76 != null ? m76.hashCode() : 0)) * 31;
        List list = this.p;
        return iHashCode3 + (list != null ? list.hashCode() : 0);
    }

    public void i(int i) {
        this.d = i;
    }

    public void j(M76 m76) {
        this.o = m76;
    }

    public String toString() {
        return "ESDescriptor{esId=" + this.d + ", streamDependenceFlag=" + this.e + ", URLFlag=" + this.f + ", oCRstreamFlag=" + this.g + ", streamPriority=" + this.h + ", URLLength=" + this.i + ", URLString='" + this.j + "', remoteODFlag=" + this.k + ", dependsOnEsId=" + this.l + ", oCREsId=" + this.m + ", decoderConfigDescriptor=" + this.n + ", slConfigDescriptor=" + this.o + '}';
    }
}
