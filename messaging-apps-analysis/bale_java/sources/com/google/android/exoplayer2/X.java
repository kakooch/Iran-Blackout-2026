package com.google.android.exoplayer2;

import android.gov.nist.core.Separators;
import android.os.Bundle;
import com.google.android.exoplayer2.InterfaceC2029g;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import ir.nasim.AbstractC24462yf4;
import ir.nasim.AbstractC3344Am0;
import ir.nasim.AbstractC9350Zo0;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.BX0;
import ir.nasim.C8299Vj3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.UUID;

/* loaded from: classes2.dex */
public final class X implements InterfaceC2029g {
    public final int A;
    public final int B;
    public final int D;
    public final int G;
    public final int H;
    public final int J;
    public final int Y;
    private int Z;
    public final String a;
    public final String b;
    public final String c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final String i;
    public final Metadata j;
    public final String k;
    public final String l;
    public final int m;
    public final List n;
    public final DrmInitData o;
    public final long p;
    public final int q;
    public final int r;
    public final float s;
    public final int t;
    public final float u;
    public final byte[] v;
    public final int w;
    public final BX0 x;
    public final int y;
    public final int z;
    private static final X z0 = new b().G();
    private static final String A0 = AbstractC9683aN7.r0(0);
    private static final String B0 = AbstractC9683aN7.r0(1);
    private static final String C0 = AbstractC9683aN7.r0(2);
    private static final String D0 = AbstractC9683aN7.r0(3);
    private static final String E0 = AbstractC9683aN7.r0(4);
    private static final String F0 = AbstractC9683aN7.r0(5);
    private static final String G0 = AbstractC9683aN7.r0(6);
    private static final String H0 = AbstractC9683aN7.r0(7);
    private static final String I0 = AbstractC9683aN7.r0(8);
    private static final String J0 = AbstractC9683aN7.r0(9);
    private static final String K0 = AbstractC9683aN7.r0(10);
    private static final String L0 = AbstractC9683aN7.r0(11);
    private static final String M0 = AbstractC9683aN7.r0(12);
    private static final String N0 = AbstractC9683aN7.r0(13);
    private static final String O0 = AbstractC9683aN7.r0(14);
    private static final String P0 = AbstractC9683aN7.r0(15);
    private static final String Q0 = AbstractC9683aN7.r0(16);
    private static final String R0 = AbstractC9683aN7.r0(17);
    private static final String S0 = AbstractC9683aN7.r0(18);
    private static final String T0 = AbstractC9683aN7.r0(19);
    private static final String U0 = AbstractC9683aN7.r0(20);
    private static final String V0 = AbstractC9683aN7.r0(21);
    private static final String W0 = AbstractC9683aN7.r0(22);
    private static final String X0 = AbstractC9683aN7.r0(23);
    private static final String Y0 = AbstractC9683aN7.r0(24);
    private static final String Z0 = AbstractC9683aN7.r0(25);
    private static final String a1 = AbstractC9683aN7.r0(26);
    private static final String b1 = AbstractC9683aN7.r0(27);
    private static final String c1 = AbstractC9683aN7.r0(28);
    private static final String d1 = AbstractC9683aN7.r0(29);
    private static final String e1 = AbstractC9683aN7.r0(30);
    private static final String f1 = AbstractC9683aN7.r0(31);
    public static final InterfaceC2029g.a g1 = new InterfaceC2029g.a() { // from class: ir.nasim.rv2
        @Override // com.google.android.exoplayer2.InterfaceC2029g.a
        public final InterfaceC2029g a(Bundle bundle) {
            return com.google.android.exoplayer2.X.f(bundle);
        }
    };

    public static final class b {
        private int A;
        private int B;
        private int C;
        private int D;
        private int E;
        private int F;
        private String a;
        private String b;
        private String c;
        private int d;
        private int e;
        private int f;
        private int g;
        private String h;
        private Metadata i;
        private String j;
        private String k;
        private int l;
        private List m;
        private DrmInitData n;
        private long o;
        private int p;
        private int q;
        private float r;
        private int s;
        private float t;
        private byte[] u;
        private int v;
        private BX0 w;
        private int x;
        private int y;
        private int z;

        public X G() {
            return new X(this);
        }

        public b H(int i) {
            this.C = i;
            return this;
        }

        public b I(int i) {
            this.f = i;
            return this;
        }

        public b J(int i) {
            this.x = i;
            return this;
        }

        public b K(String str) {
            this.h = str;
            return this;
        }

        public b L(BX0 bx0) {
            this.w = bx0;
            return this;
        }

        public b M(String str) {
            this.j = str;
            return this;
        }

        public b N(int i) {
            this.F = i;
            return this;
        }

        public b O(DrmInitData drmInitData) {
            this.n = drmInitData;
            return this;
        }

        public b P(int i) {
            this.A = i;
            return this;
        }

        public b Q(int i) {
            this.B = i;
            return this;
        }

        public b R(float f) {
            this.r = f;
            return this;
        }

        public b S(int i) {
            this.q = i;
            return this;
        }

        public b T(int i) {
            this.a = Integer.toString(i);
            return this;
        }

        public b U(String str) {
            this.a = str;
            return this;
        }

        public b V(List list) {
            this.m = list;
            return this;
        }

        public b W(String str) {
            this.b = str;
            return this;
        }

        public b X(String str) {
            this.c = str;
            return this;
        }

        public b Y(int i) {
            this.l = i;
            return this;
        }

        public b Z(Metadata metadata) {
            this.i = metadata;
            return this;
        }

        public b a0(int i) {
            this.z = i;
            return this;
        }

        public b b0(int i) {
            this.g = i;
            return this;
        }

        public b c0(float f) {
            this.t = f;
            return this;
        }

        public b d0(byte[] bArr) {
            this.u = bArr;
            return this;
        }

        public b e0(int i) {
            this.e = i;
            return this;
        }

        public b f0(int i) {
            this.s = i;
            return this;
        }

        public b g0(String str) {
            this.k = str;
            return this;
        }

        public b h0(int i) {
            this.y = i;
            return this;
        }

        public b i0(int i) {
            this.d = i;
            return this;
        }

        public b j0(int i) {
            this.v = i;
            return this;
        }

        public b k0(long j) {
            this.o = j;
            return this;
        }

        public b l0(int i) {
            this.D = i;
            return this;
        }

        public b m0(int i) {
            this.E = i;
            return this;
        }

        public b n0(int i) {
            this.p = i;
            return this;
        }

        public b() {
            this.f = -1;
            this.g = -1;
            this.l = -1;
            this.o = Long.MAX_VALUE;
            this.p = -1;
            this.q = -1;
            this.r = -1.0f;
            this.t = 1.0f;
            this.v = -1;
            this.x = -1;
            this.y = -1;
            this.z = -1;
            this.C = -1;
            this.D = -1;
            this.E = -1;
            this.F = 0;
        }

        private b(X x) {
            this.a = x.a;
            this.b = x.b;
            this.c = x.c;
            this.d = x.d;
            this.e = x.e;
            this.f = x.f;
            this.g = x.g;
            this.h = x.i;
            this.i = x.j;
            this.j = x.k;
            this.k = x.l;
            this.l = x.m;
            this.m = x.n;
            this.n = x.o;
            this.o = x.p;
            this.p = x.q;
            this.q = x.r;
            this.r = x.s;
            this.s = x.t;
            this.t = x.u;
            this.u = x.v;
            this.v = x.w;
            this.w = x.x;
            this.x = x.y;
            this.y = x.z;
            this.z = x.A;
            this.A = x.B;
            this.B = x.D;
            this.C = x.G;
            this.D = x.H;
            this.E = x.J;
            this.F = x.Y;
        }
    }

    private static Object e(Object obj, Object obj2) {
        return obj != null ? obj : obj2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static X f(Bundle bundle) {
        b bVar = new b();
        AbstractC3344Am0.a(bundle);
        String string = bundle.getString(A0);
        X x = z0;
        bVar.U((String) e(string, x.a)).W((String) e(bundle.getString(B0), x.b)).X((String) e(bundle.getString(C0), x.c)).i0(bundle.getInt(D0, x.d)).e0(bundle.getInt(E0, x.e)).I(bundle.getInt(F0, x.f)).b0(bundle.getInt(G0, x.g)).K((String) e(bundle.getString(H0), x.i)).Z((Metadata) e((Metadata) bundle.getParcelable(I0), x.j)).M((String) e(bundle.getString(J0), x.k)).g0((String) e(bundle.getString(K0), x.l)).Y(bundle.getInt(L0, x.m));
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            byte[] byteArray = bundle.getByteArray(i(i));
            if (byteArray == null) {
                break;
            }
            arrayList.add(byteArray);
            i++;
        }
        b bVarO = bVar.V(arrayList).O((DrmInitData) bundle.getParcelable(N0));
        String str = O0;
        X x2 = z0;
        bVarO.k0(bundle.getLong(str, x2.p)).n0(bundle.getInt(P0, x2.q)).S(bundle.getInt(Q0, x2.r)).R(bundle.getFloat(R0, x2.s)).f0(bundle.getInt(S0, x2.t)).c0(bundle.getFloat(T0, x2.u)).d0(bundle.getByteArray(U0)).j0(bundle.getInt(V0, x2.w));
        Bundle bundle2 = bundle.getBundle(W0);
        if (bundle2 != null) {
            bVar.L((BX0) BX0.k.a(bundle2));
        }
        bVar.J(bundle.getInt(X0, x2.y)).h0(bundle.getInt(Y0, x2.z)).a0(bundle.getInt(Z0, x2.A)).P(bundle.getInt(a1, x2.B)).Q(bundle.getInt(b1, x2.D)).H(bundle.getInt(c1, x2.G)).l0(bundle.getInt(e1, x2.H)).m0(bundle.getInt(f1, x2.J)).N(bundle.getInt(d1, x2.Y));
        return bVar.G();
    }

    private static String i(int i) {
        return M0 + "_" + Integer.toString(i, 36);
    }

    public static String k(X x) {
        if (x == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("id=");
        sb.append(x.a);
        sb.append(", mimeType=");
        sb.append(x.l);
        if (x.h != -1) {
            sb.append(", bitrate=");
            sb.append(x.h);
        }
        if (x.i != null) {
            sb.append(", codecs=");
            sb.append(x.i);
        }
        if (x.o != null) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int i = 0;
            while (true) {
                DrmInitData drmInitData = x.o;
                if (i >= drmInitData.d) {
                    break;
                }
                UUID uuid = drmInitData.e(i).b;
                if (uuid.equals(AbstractC9350Zo0.b)) {
                    linkedHashSet.add("cenc");
                } else if (uuid.equals(AbstractC9350Zo0.c)) {
                    linkedHashSet.add("clearkey");
                } else if (uuid.equals(AbstractC9350Zo0.e)) {
                    linkedHashSet.add("playready");
                } else if (uuid.equals(AbstractC9350Zo0.d)) {
                    linkedHashSet.add("widevine");
                } else if (uuid.equals(AbstractC9350Zo0.a)) {
                    linkedHashSet.add("universal");
                } else {
                    linkedHashSet.add("unknown (" + uuid + Separators.RPAREN);
                }
                i++;
            }
            sb.append(", drm=[");
            C8299Vj3.d(',').b(sb, linkedHashSet);
            sb.append(']');
        }
        if (x.q != -1 && x.r != -1) {
            sb.append(", res=");
            sb.append(x.q);
            sb.append("x");
            sb.append(x.r);
        }
        if (x.s != -1.0f) {
            sb.append(", fps=");
            sb.append(x.s);
        }
        if (x.y != -1) {
            sb.append(", channels=");
            sb.append(x.y);
        }
        if (x.z != -1) {
            sb.append(", sample_rate=");
            sb.append(x.z);
        }
        if (x.c != null) {
            sb.append(", language=");
            sb.append(x.c);
        }
        if (x.b != null) {
            sb.append(", label=");
            sb.append(x.b);
        }
        if (x.d != 0) {
            ArrayList arrayList = new ArrayList();
            if ((x.d & 4) != 0) {
                arrayList.add("auto");
            }
            if ((x.d & 1) != 0) {
                arrayList.add("default");
            }
            if ((x.d & 2) != 0) {
                arrayList.add("forced");
            }
            sb.append(", selectionFlags=[");
            C8299Vj3.d(',').b(sb, arrayList);
            sb.append("]");
        }
        if (x.e != 0) {
            ArrayList arrayList2 = new ArrayList();
            if ((x.e & 1) != 0) {
                arrayList2.add("main");
            }
            if ((x.e & 2) != 0) {
                arrayList2.add("alt");
            }
            if ((x.e & 4) != 0) {
                arrayList2.add("supplementary");
            }
            if ((x.e & 8) != 0) {
                arrayList2.add("commentary");
            }
            if ((x.e & 16) != 0) {
                arrayList2.add("dub");
            }
            if ((x.e & 32) != 0) {
                arrayList2.add("emergency");
            }
            if ((x.e & 64) != 0) {
                arrayList2.add("caption");
            }
            if ((x.e & 128) != 0) {
                arrayList2.add("subtitle");
            }
            if ((x.e & 256) != 0) {
                arrayList2.add("sign");
            }
            if ((x.e & 512) != 0) {
                arrayList2.add("describes-video");
            }
            if ((x.e & 1024) != 0) {
                arrayList2.add("describes-music");
            }
            if ((x.e & 2048) != 0) {
                arrayList2.add("enhanced-intelligibility");
            }
            if ((x.e & 4096) != 0) {
                arrayList2.add("transcribes-dialog");
            }
            if ((x.e & 8192) != 0) {
                arrayList2.add("easy-read");
            }
            if ((x.e & 16384) != 0) {
                arrayList2.add("trick-play");
            }
            sb.append(", roleFlags=[");
            C8299Vj3.d(',').b(sb, arrayList2);
            sb.append("]");
        }
        return sb.toString();
    }

    @Override // com.google.android.exoplayer2.InterfaceC2029g
    public Bundle a() {
        return j(false);
    }

    public b c() {
        return new b();
    }

    public X d(int i) {
        return c().N(i).G();
    }

    public boolean equals(Object obj) {
        int i;
        if (this == obj) {
            return true;
        }
        if (obj == null || X.class != obj.getClass()) {
            return false;
        }
        X x = (X) obj;
        int i2 = this.Z;
        if (i2 == 0 || (i = x.Z) == 0 || i2 == i) {
            return this.d == x.d && this.e == x.e && this.f == x.f && this.g == x.g && this.m == x.m && this.p == x.p && this.q == x.q && this.r == x.r && this.t == x.t && this.w == x.w && this.y == x.y && this.z == x.z && this.A == x.A && this.B == x.B && this.D == x.D && this.G == x.G && this.H == x.H && this.J == x.J && this.Y == x.Y && Float.compare(this.s, x.s) == 0 && Float.compare(this.u, x.u) == 0 && AbstractC9683aN7.c(this.a, x.a) && AbstractC9683aN7.c(this.b, x.b) && AbstractC9683aN7.c(this.i, x.i) && AbstractC9683aN7.c(this.k, x.k) && AbstractC9683aN7.c(this.l, x.l) && AbstractC9683aN7.c(this.c, x.c) && Arrays.equals(this.v, x.v) && AbstractC9683aN7.c(this.j, x.j) && AbstractC9683aN7.c(this.x, x.x) && AbstractC9683aN7.c(this.o, x.o) && h(x);
        }
        return false;
    }

    public int g() {
        int i;
        int i2 = this.q;
        if (i2 == -1 || (i = this.r) == -1) {
            return -1;
        }
        return i2 * i;
    }

    public boolean h(X x) {
        if (this.n.size() != x.n.size()) {
            return false;
        }
        for (int i = 0; i < this.n.size(); i++) {
            if (!Arrays.equals((byte[]) this.n.get(i), (byte[]) x.n.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        if (this.Z == 0) {
            String str = this.a;
            int iHashCode = (527 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.b;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.c;
            int iHashCode3 = (((((((((iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31) + this.g) * 31;
            String str4 = this.i;
            int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            Metadata metadata = this.j;
            int iHashCode5 = (iHashCode4 + (metadata == null ? 0 : metadata.hashCode())) * 31;
            String str5 = this.k;
            int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.l;
            this.Z = ((((((((((((((((((((((((((((((((((iHashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31) + this.m) * 31) + ((int) this.p)) * 31) + this.q) * 31) + this.r) * 31) + Float.floatToIntBits(this.s)) * 31) + this.t) * 31) + Float.floatToIntBits(this.u)) * 31) + this.w) * 31) + this.y) * 31) + this.z) * 31) + this.A) * 31) + this.B) * 31) + this.D) * 31) + this.G) * 31) + this.H) * 31) + this.J) * 31) + this.Y;
        }
        return this.Z;
    }

    public Bundle j(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString(A0, this.a);
        bundle.putString(B0, this.b);
        bundle.putString(C0, this.c);
        bundle.putInt(D0, this.d);
        bundle.putInt(E0, this.e);
        bundle.putInt(F0, this.f);
        bundle.putInt(G0, this.g);
        bundle.putString(H0, this.i);
        if (!z) {
            bundle.putParcelable(I0, this.j);
        }
        bundle.putString(J0, this.k);
        bundle.putString(K0, this.l);
        bundle.putInt(L0, this.m);
        for (int i = 0; i < this.n.size(); i++) {
            bundle.putByteArray(i(i), (byte[]) this.n.get(i));
        }
        bundle.putParcelable(N0, this.o);
        bundle.putLong(O0, this.p);
        bundle.putInt(P0, this.q);
        bundle.putInt(Q0, this.r);
        bundle.putFloat(R0, this.s);
        bundle.putInt(S0, this.t);
        bundle.putFloat(T0, this.u);
        bundle.putByteArray(U0, this.v);
        bundle.putInt(V0, this.w);
        BX0 bx0 = this.x;
        if (bx0 != null) {
            bundle.putBundle(W0, bx0.a());
        }
        bundle.putInt(X0, this.y);
        bundle.putInt(Y0, this.z);
        bundle.putInt(Z0, this.A);
        bundle.putInt(a1, this.B);
        bundle.putInt(b1, this.D);
        bundle.putInt(c1, this.G);
        bundle.putInt(e1, this.H);
        bundle.putInt(f1, this.J);
        bundle.putInt(d1, this.Y);
        return bundle;
    }

    public X l(X x) {
        String str;
        if (this == x) {
            return this;
        }
        int iK = AbstractC24462yf4.k(this.l);
        String str2 = x.a;
        String str3 = x.b;
        if (str3 == null) {
            str3 = this.b;
        }
        String str4 = this.c;
        if ((iK == 3 || iK == 1) && (str = x.c) != null) {
            str4 = str;
        }
        int i = this.f;
        if (i == -1) {
            i = x.f;
        }
        int i2 = this.g;
        if (i2 == -1) {
            i2 = x.g;
        }
        String str5 = this.i;
        if (str5 == null) {
            String strI = AbstractC9683aN7.I(x.i, iK);
            if (AbstractC9683aN7.T0(strI).length == 1) {
                str5 = strI;
            }
        }
        Metadata metadata = this.j;
        Metadata metadataB = metadata == null ? x.j : metadata.b(x.j);
        float f = this.s;
        if (f == -1.0f && iK == 2) {
            f = x.s;
        }
        return c().U(str2).W(str3).X(str4).i0(this.d | x.d).e0(this.e | x.e).I(i).b0(i2).K(str5).Z(metadataB).O(DrmInitData.d(x.o, this.o)).R(f).G();
    }

    public String toString() {
        return "Format(" + this.a + ", " + this.b + ", " + this.k + ", " + this.l + ", " + this.i + ", " + this.h + ", " + this.c + ", [" + this.q + ", " + this.r + ", " + this.s + "], [" + this.y + ", " + this.z + "])";
    }

    private X(b bVar) {
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = AbstractC9683aN7.D0(bVar.c);
        this.d = bVar.d;
        this.e = bVar.e;
        int i = bVar.f;
        this.f = i;
        int i2 = bVar.g;
        this.g = i2;
        this.h = i2 != -1 ? i2 : i;
        this.i = bVar.h;
        this.j = bVar.i;
        this.k = bVar.j;
        this.l = bVar.k;
        this.m = bVar.l;
        this.n = bVar.m == null ? Collections.emptyList() : bVar.m;
        DrmInitData drmInitData = bVar.n;
        this.o = drmInitData;
        this.p = bVar.o;
        this.q = bVar.p;
        this.r = bVar.q;
        this.s = bVar.r;
        this.t = bVar.s == -1 ? 0 : bVar.s;
        this.u = bVar.t == -1.0f ? 1.0f : bVar.t;
        this.v = bVar.u;
        this.w = bVar.v;
        this.x = bVar.w;
        this.y = bVar.x;
        this.z = bVar.y;
        this.A = bVar.z;
        this.B = bVar.A == -1 ? 0 : bVar.A;
        this.D = bVar.B != -1 ? bVar.B : 0;
        this.G = bVar.C;
        this.H = bVar.D;
        this.J = bVar.E;
        if (bVar.F != 0 || drmInitData == null) {
            this.Y = bVar.F;
        } else {
            this.Y = 1;
        }
    }
}
