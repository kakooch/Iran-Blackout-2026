package ir.nasim;

import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* renamed from: ir.nasim.sV2, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C20722sV2 {
    boolean A;
    int a;
    int b;
    boolean c;
    int d;
    long e;
    long f;
    int g;
    int i;
    int k;
    int m;
    int o;
    int q;
    int r;
    int s;
    int t;
    boolean u;
    int v;
    boolean x;
    boolean y;
    boolean z;
    int h = 15;
    int j = 63;
    int l = 63;
    int n = 31;
    int p = 31;
    List w = new ArrayList();

    /* renamed from: ir.nasim.sV2$a */
    public static class a {
        public boolean a;
        public boolean b;
        public int c;
        public List d;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.a != aVar.a || this.c != aVar.c || this.b != aVar.b) {
                return false;
            }
            ListIterator listIterator = this.d.listIterator();
            ListIterator listIterator2 = aVar.d.listIterator();
            while (listIterator.hasNext() && listIterator2.hasNext()) {
                byte[] bArr = (byte[]) listIterator.next();
                byte[] bArr2 = (byte[]) listIterator2.next();
                if (bArr == null) {
                    if (bArr2 != null) {
                        return false;
                    }
                } else if (!Arrays.equals(bArr, bArr2)) {
                    return false;
                }
            }
            return (listIterator.hasNext() || listIterator2.hasNext()) ? false : true;
        }

        public int hashCode() {
            int i = (((((this.a ? 1 : 0) * 31) + (this.b ? 1 : 0)) * 31) + this.c) * 31;
            List list = this.d;
            return i + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            return "Array{nal_unit_type=" + this.c + ", reserved=" + this.b + ", array_completeness=" + this.a + ", num_nals=" + this.d.size() + '}';
        }
    }

    /* renamed from: ir.nasim.sV2$b */
    public static class b {
        public int a;
        public int b;
        public int c;
        public int d;
    }

    private static OY7 a(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, C6454Np6 c6454Np6) {
        OY7 oy7 = new OY7("hvc1");
        oy7.m(1);
        oy7.z(24);
        oy7.G(1);
        oy7.J(72.0d);
        oy7.K(72.0d);
        oy7.y("HEVC Coding");
        C20113rV2 c20113rV2 = new C20113rV2();
        c20113rV2.o().i(1);
        if (c6454Np6 != null) {
            oy7.M(c6454Np6.a);
            oy7.H(c6454Np6.b);
            C20722sV2 c20722sV2O = c20113rV2.o();
            c20722sV2O.h(c6454Np6.i);
            c20722sV2O.m(c6454Np6.e);
            c20722sV2O.l(c6454Np6.f);
            c20722sV2O.j(c6454Np6.g);
            c20722sV2O.k(c6454Np6.h);
            c20722sV2O.o(c6454Np6.d);
            c20722sV2O.n(c6454Np6.c);
            c20722sV2O.f(c6454Np6.k);
            c20722sV2O.g(c6454Np6.j);
            c20722sV2O.q(c6454Np6.m);
        }
        c20113rV2.o().p(3);
        a aVar = new a();
        aVar.a = true;
        aVar.c = 32;
        aVar.d = new ArrayList();
        Iterator it = arrayList3.iterator();
        while (it.hasNext()) {
            aVar.d.add(((ByteBuffer) it.next()).array());
        }
        a aVar2 = new a();
        aVar2.a = true;
        aVar2.c = 33;
        aVar2.d = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            aVar2.d.add(((ByteBuffer) it2.next()).array());
        }
        a aVar3 = new a();
        aVar3.a = true;
        aVar3.c = 34;
        aVar3.d = new ArrayList();
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            aVar3.d.add(((ByteBuffer) it3.next()).array());
        }
        c20113rV2.n().addAll(Arrays.asList(aVar, aVar2, aVar3));
        oy7.a(c20113rV2);
        return oy7;
    }

    private static b b(ByteBuffer byteBuffer) {
        byteBuffer.position(0);
        int iH = AbstractC5635Ke3.h(byteBuffer);
        b bVar = new b();
        bVar.a = (32768 & iH) >> 15;
        bVar.b = (iH & 32256) >> 9;
        bVar.c = (iH & 504) >> 3;
        bVar.d = iH & 7;
        return bVar;
    }

    public static OY7 e(List list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator it = list.iterator();
        C6454Np6 c6454Np6 = null;
        while (it.hasNext()) {
            ByteBuffer byteBuffer = (ByteBuffer) it.next();
            b bVarB = b(byteBuffer);
            byteBuffer.position(0);
            switch (bVarB.b) {
                case 32:
                    arrayList3.add(byteBuffer.duplicate());
                    break;
                case 33:
                    arrayList.add(byteBuffer.duplicate());
                    byteBuffer.position(2);
                    c6454Np6 = new C6454Np6(new PU0(Channels.newInputStream(new C3835Co0(byteBuffer.slice()))));
                    break;
                case 34:
                    arrayList2.add(byteBuffer.duplicate());
                    break;
            }
        }
        return a(arrayList, arrayList2, arrayList3, c6454Np6);
    }

    public int c() {
        Iterator it = this.w.iterator();
        int length = 23;
        while (it.hasNext()) {
            length += 3;
            Iterator it2 = ((a) it.next()).d.iterator();
            while (it2.hasNext()) {
                length = length + 2 + ((byte[]) it2.next()).length;
            }
        }
        return length;
    }

    public void d(ByteBuffer byteBuffer) {
        this.a = AbstractC5635Ke3.m(byteBuffer);
        int iM = AbstractC5635Ke3.m(byteBuffer);
        this.b = (iM & 192) >> 6;
        this.c = (iM & 32) > 0;
        this.d = iM & 31;
        this.e = AbstractC5635Ke3.j(byteBuffer);
        long jK = AbstractC5635Ke3.k(byteBuffer);
        this.f = jK;
        this.x = ((jK >> 44) & 8) > 0;
        this.y = ((jK >> 44) & 4) > 0;
        this.z = ((jK >> 44) & 2) > 0;
        this.A = ((jK >> 44) & 1) > 0;
        this.f = jK & 140737488355327L;
        this.g = AbstractC5635Ke3.m(byteBuffer);
        int iH = AbstractC5635Ke3.h(byteBuffer);
        this.h = (61440 & iH) >> 12;
        this.i = iH & 4095;
        int iM2 = AbstractC5635Ke3.m(byteBuffer);
        this.j = (iM2 & 252) >> 2;
        this.k = iM2 & 3;
        int iM3 = AbstractC5635Ke3.m(byteBuffer);
        this.l = (iM3 & 252) >> 2;
        this.m = iM3 & 3;
        int iM4 = AbstractC5635Ke3.m(byteBuffer);
        this.n = (iM4 & 248) >> 3;
        this.o = iM4 & 7;
        int iM5 = AbstractC5635Ke3.m(byteBuffer);
        this.p = (iM5 & 248) >> 3;
        this.q = iM5 & 7;
        this.r = AbstractC5635Ke3.h(byteBuffer);
        int iM6 = AbstractC5635Ke3.m(byteBuffer);
        this.s = (iM6 & 192) >> 6;
        this.t = (iM6 & 56) >> 3;
        this.u = (iM6 & 4) > 0;
        this.v = iM6 & 3;
        int iM7 = AbstractC5635Ke3.m(byteBuffer);
        this.w = new ArrayList();
        for (int i = 0; i < iM7; i++) {
            a aVar = new a();
            int iM8 = AbstractC5635Ke3.m(byteBuffer);
            aVar.a = (iM8 & 128) > 0;
            aVar.b = (iM8 & 64) > 0;
            aVar.c = iM8 & 63;
            int iH2 = AbstractC5635Ke3.h(byteBuffer);
            aVar.d = new ArrayList();
            for (int i2 = 0; i2 < iH2; i2++) {
                byte[] bArr = new byte[AbstractC5635Ke3.h(byteBuffer)];
                byteBuffer.get(bArr);
                aVar.d.add(bArr);
            }
            this.w.add(aVar);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C20722sV2 c20722sV2 = (C20722sV2) obj;
        if (this.r != c20722sV2.r || this.q != c20722sV2.q || this.o != c20722sV2.o || this.m != c20722sV2.m || this.a != c20722sV2.a || this.s != c20722sV2.s || this.f != c20722sV2.f || this.g != c20722sV2.g || this.e != c20722sV2.e || this.d != c20722sV2.d || this.b != c20722sV2.b || this.c != c20722sV2.c || this.v != c20722sV2.v || this.i != c20722sV2.i || this.t != c20722sV2.t || this.k != c20722sV2.k || this.h != c20722sV2.h || this.j != c20722sV2.j || this.l != c20722sV2.l || this.n != c20722sV2.n || this.p != c20722sV2.p || this.u != c20722sV2.u) {
            return false;
        }
        List list = this.w;
        List list2 = c20722sV2.w;
        return list == null ? list2 == null : list.equals(list2);
    }

    public void f(int i) {
        this.q = i;
    }

    public void g(int i) {
        this.o = i;
    }

    public void h(int i) {
        this.m = i;
    }

    public int hashCode() {
        int i = ((((((this.a * 31) + this.b) * 31) + (this.c ? 1 : 0)) * 31) + this.d) * 31;
        long j = this.e;
        int i2 = (i + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.f;
        int i3 = (((((((((((((((((((((((((((((((((i2 + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.g) * 31) + this.h) * 31) + this.i) * 31) + this.j) * 31) + this.k) * 31) + this.l) * 31) + this.m) * 31) + this.n) * 31) + this.o) * 31) + this.p) * 31) + this.q) * 31) + this.r) * 31) + this.s) * 31) + this.t) * 31) + (this.u ? 1 : 0)) * 31) + this.v) * 31;
        List list = this.w;
        return i3 + (list != null ? list.hashCode() : 0);
    }

    public void i(int i) {
        this.a = i;
    }

    public void j(long j) {
        this.f = j;
    }

    public void k(int i) {
        this.g = i;
    }

    public void l(long j) {
        this.e = j;
    }

    public void m(int i) {
        this.d = i;
    }

    public void n(int i) {
        this.b = i;
    }

    public void o(boolean z) {
        this.c = z;
    }

    public void p(int i) {
        this.v = i;
    }

    public void q(boolean z) {
        this.u = z;
    }

    public void r(ByteBuffer byteBuffer) {
        AbstractC5869Le3.j(byteBuffer, this.a);
        AbstractC5869Le3.j(byteBuffer, (this.b << 6) + (this.c ? 32 : 0) + this.d);
        AbstractC5869Le3.g(byteBuffer, this.e);
        long j = this.f;
        if (this.x) {
            j |= 140737488355328L;
        }
        if (this.y) {
            j |= 70368744177664L;
        }
        if (this.z) {
            j |= 35184372088832L;
        }
        if (this.A) {
            j |= 17592186044416L;
        }
        AbstractC5869Le3.h(byteBuffer, j);
        AbstractC5869Le3.j(byteBuffer, this.g);
        AbstractC5869Le3.e(byteBuffer, (this.h << 12) + this.i);
        AbstractC5869Le3.j(byteBuffer, (this.j << 2) + this.k);
        AbstractC5869Le3.j(byteBuffer, (this.l << 2) + this.m);
        AbstractC5869Le3.j(byteBuffer, (this.n << 3) + this.o);
        AbstractC5869Le3.j(byteBuffer, (this.p << 3) + this.q);
        AbstractC5869Le3.e(byteBuffer, this.r);
        AbstractC5869Le3.j(byteBuffer, (this.s << 6) + (this.t << 3) + (this.u ? 4 : 0) + this.v);
        AbstractC5869Le3.j(byteBuffer, this.w.size());
        for (a aVar : this.w) {
            AbstractC5869Le3.j(byteBuffer, (aVar.a ? 128 : 0) + (aVar.b ? 64 : 0) + aVar.c);
            AbstractC5869Le3.e(byteBuffer, aVar.d.size());
            for (byte[] bArr : aVar.d) {
                AbstractC5869Le3.e(byteBuffer, bArr.length);
                byteBuffer.put(bArr);
            }
        }
    }

    public String toString() {
        String str;
        String str2;
        String str3;
        String str4;
        StringBuilder sb = new StringBuilder();
        sb.append("HEVCDecoderConfigurationRecord{configurationVersion=");
        sb.append(this.a);
        sb.append(", general_profile_space=");
        sb.append(this.b);
        sb.append(", general_tier_flag=");
        sb.append(this.c);
        sb.append(", general_profile_idc=");
        sb.append(this.d);
        sb.append(", general_profile_compatibility_flags=");
        sb.append(this.e);
        sb.append(", general_constraint_indicator_flags=");
        sb.append(this.f);
        sb.append(", general_level_idc=");
        sb.append(this.g);
        String str5 = "";
        if (this.h != 15) {
            str = ", reserved1=" + this.h;
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(", min_spatial_segmentation_idc=");
        sb.append(this.i);
        if (this.j != 63) {
            str2 = ", reserved2=" + this.j;
        } else {
            str2 = "";
        }
        sb.append(str2);
        sb.append(", parallelismType=");
        sb.append(this.k);
        if (this.l != 63) {
            str3 = ", reserved3=" + this.l;
        } else {
            str3 = "";
        }
        sb.append(str3);
        sb.append(", chromaFormat=");
        sb.append(this.m);
        if (this.n != 31) {
            str4 = ", reserved4=" + this.n;
        } else {
            str4 = "";
        }
        sb.append(str4);
        sb.append(", bitDepthLumaMinus8=");
        sb.append(this.o);
        if (this.p != 31) {
            str5 = ", reserved5=" + this.p;
        }
        sb.append(str5);
        sb.append(", bitDepthChromaMinus8=");
        sb.append(this.q);
        sb.append(", avgFrameRate=");
        sb.append(this.r);
        sb.append(", constantFrameRate=");
        sb.append(this.s);
        sb.append(", numTemporalLayers=");
        sb.append(this.t);
        sb.append(", temporalIdNested=");
        sb.append(this.u);
        sb.append(", lengthSizeMinusOne=");
        sb.append(this.v);
        sb.append(", arrays=");
        sb.append(this.w);
        sb.append('}');
        return sb.toString();
    }
}
