package ir.nasim;

import android.gov.nist.core.Separators;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* renamed from: ir.nasim.oP, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C18283oP extends H90 {
    public static Map V = new HashMap();
    public static Map W = new HashMap();
    public int A;
    public boolean B;
    public boolean C;
    public boolean D;
    public int E;
    public boolean F;
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public boolean U;
    byte[] d;
    public a e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public boolean k;
    public boolean l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    /* renamed from: ir.nasim.oP$a */
    public class a {
        public boolean a;
        public boolean b;
        public boolean c;
        public boolean d;
        public boolean e;
        public boolean f;
        public boolean g;

        public a(int i, C5641Kf0 c5641Kf0) {
            int iA;
            this.a = c5641Kf0.b();
            this.b = c5641Kf0.b();
            this.c = c5641Kf0.b();
            this.d = c5641Kf0.b();
            boolean zB = c5641Kf0.b();
            this.e = zB;
            if (zB) {
                this.f = c5641Kf0.b();
                this.g = c5641Kf0.b();
                a(i, c5641Kf0);
            }
            while (c5641Kf0.a(4) != 0) {
                int iA2 = c5641Kf0.a(4);
                if (iA2 == 15) {
                    iA = c5641Kf0.a(8);
                    iA2 += iA;
                } else {
                    iA = 0;
                }
                if (iA == 255) {
                    iA2 += c5641Kf0.a(16);
                }
                for (int i2 = 0; i2 < iA2; i2++) {
                    c5641Kf0.a(8);
                }
            }
        }

        public void a(int i, C5641Kf0 c5641Kf0) {
            int i2;
            switch (i) {
                case 1:
                case 2:
                    i2 = 1;
                    break;
                case 3:
                    i2 = 2;
                    break;
                case 4:
                case 5:
                case 6:
                    i2 = 3;
                    break;
                case 7:
                    i2 = 4;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                C18283oP.this.new b(c5641Kf0);
            }
        }
    }

    /* renamed from: ir.nasim.oP$b */
    public class b {
        public boolean a;
        public int b;
        public int c;
        public int d;
        public int e;
        public boolean f;
        public boolean g;
        public int h;
        public boolean i;
        public int j;
        public int k;
        public int l;
        public boolean m;
        public boolean n;

        public b(C5641Kf0 c5641Kf0) {
            this.a = c5641Kf0.b();
            this.b = c5641Kf0.a(4);
            this.c = c5641Kf0.a(4);
            this.d = c5641Kf0.a(3);
            this.e = c5641Kf0.a(2);
            this.f = c5641Kf0.b();
            this.g = c5641Kf0.b();
            if (this.f) {
                this.h = c5641Kf0.a(2);
                this.i = c5641Kf0.b();
                this.j = c5641Kf0.a(2);
            }
            if (this.g) {
                this.k = c5641Kf0.a(2);
                this.l = c5641Kf0.a(2);
                this.m = c5641Kf0.b();
            }
            this.n = c5641Kf0.b();
        }
    }

    static {
        V.put(0, 96000);
        V.put(1, 88200);
        V.put(2, 64000);
        V.put(3, 48000);
        V.put(4, 44100);
        V.put(5, 32000);
        V.put(6, 24000);
        V.put(7, 22050);
        V.put(8, 16000);
        V.put(9, 12000);
        V.put(10, 11025);
        V.put(11, 8000);
        W.put(1, "AAC main");
        W.put(2, "AAC LC");
        W.put(3, "AAC SSR");
        W.put(4, "AAC LTP");
        W.put(5, "SBR");
        W.put(6, "AAC Scalable");
        W.put(7, "TwinVQ");
        W.put(8, "CELP");
        W.put(9, "HVXC");
        W.put(10, "(reserved)");
        W.put(11, "(reserved)");
        W.put(12, "TTSI");
        W.put(13, "Main synthetic");
        W.put(14, "Wavetable synthesis");
        W.put(15, "General MIDI");
        W.put(16, "Algorithmic Synthesis and Audio FX");
        W.put(17, "ER AAC LC");
        W.put(18, "(reserved)");
        W.put(19, "ER AAC LTP");
        W.put(20, "ER AAC Scalable");
        W.put(21, "ER TwinVQ");
        W.put(22, "ER BSAC");
        W.put(23, "ER AAC LD");
        W.put(24, "ER CELP");
        W.put(25, "ER HVXC");
        W.put(26, "ER HILN");
        W.put(27, "ER Parametric");
        W.put(28, "SSC");
        W.put(29, "PS");
        W.put(30, "MPEG Surround");
        W.put(31, "(escape)");
        W.put(32, "Layer-1");
        W.put(33, "Layer-2");
        W.put(34, "Layer-3");
        W.put(35, "DST");
        W.put(36, "ALS");
        W.put(37, "SLS");
        W.put(38, "SLS non-core");
        W.put(39, "ER AAC ELD");
        W.put(40, "SMR Simple");
        W.put(41, "SMR Main");
    }

    private int f() {
        return 0;
    }

    private int g(C5641Kf0 c5641Kf0) {
        int iA = c5641Kf0.a(5);
        return iA == 31 ? c5641Kf0.a(6) + 32 : iA;
    }

    private void h(int i, int i2, int i3, C5641Kf0 c5641Kf0) {
        this.J = c5641Kf0.a(1);
        this.K = c5641Kf0.a(2);
        int iA = c5641Kf0.a(1);
        this.L = iA;
        if (iA == 1) {
            this.M = c5641Kf0.a(1);
        }
    }

    private void i(int i, int i2, int i3, C5641Kf0 c5641Kf0) {
        this.u = c5641Kf0.a(1);
        int iA = c5641Kf0.a(1);
        this.v = iA;
        if (iA == 1) {
            this.w = c5641Kf0.a(14);
        }
        this.x = c5641Kf0.a(1);
        if (i2 == 0) {
            throw new UnsupportedOperationException("can't parse program_config_element yet");
        }
        if (i3 == 6 || i3 == 20) {
            this.y = c5641Kf0.a(3);
        }
        if (this.x == 1) {
            if (i3 == 22) {
                this.z = c5641Kf0.a(5);
                this.A = c5641Kf0.a(11);
            }
            if (i3 == 17 || i3 == 19 || i3 == 20 || i3 == 23) {
                this.B = c5641Kf0.b();
                this.C = c5641Kf0.b();
                this.D = c5641Kf0.b();
            }
            this.E = c5641Kf0.a(1);
        }
        this.F = true;
    }

    private void j(int i, int i2, int i3, C5641Kf0 c5641Kf0) {
        this.N = c5641Kf0.a(1);
        this.O = c5641Kf0.a(8);
        this.P = c5641Kf0.a(4);
        this.Q = c5641Kf0.a(12);
        this.R = c5641Kf0.a(2);
    }

    private void k(int i, int i2, int i3, C5641Kf0 c5641Kf0) {
        int iA = c5641Kf0.a(1);
        this.S = iA;
        if (iA == 1) {
            this.T = c5641Kf0.a(2);
        }
    }

    private void l(int i, int i2, int i3, C5641Kf0 c5641Kf0) {
        int iA = c5641Kf0.a(2);
        this.H = iA;
        if (iA != 1) {
            h(i, i2, i3, c5641Kf0);
        }
        if (this.H != 0) {
            j(i, i2, i3, c5641Kf0);
        }
        this.I = c5641Kf0.a(1);
        this.U = true;
    }

    private void m(int i, int i2, int i3, C5641Kf0 c5641Kf0) {
        int iA = c5641Kf0.a(1);
        this.G = iA;
        if (iA == 1) {
            l(i, i2, i3, c5641Kf0);
        } else {
            k(i, i2, i3, c5641Kf0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x011b  */
    @Override // ir.nasim.H90
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void e(java.nio.ByteBuffer r10) {
        /*
            Method dump skipped, instructions count: 542
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C18283oP.e(java.nio.ByteBuffer):void");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C18283oP c18283oP = (C18283oP) obj;
        return this.C == c18283oP.C && this.B == c18283oP.B && this.D == c18283oP.D && this.f == c18283oP.f && this.i == c18283oP.i && this.w == c18283oP.w && this.v == c18283oP.v && this.s == c18283oP.s && this.r == c18283oP.r && this.L == c18283oP.L && this.j == c18283oP.j && this.o == c18283oP.o && this.x == c18283oP.x && this.E == c18283oP.E && this.n == c18283oP.n && this.m == c18283oP.m && this.q == c18283oP.q && this.u == c18283oP.u && this.F == c18283oP.F && this.R == c18283oP.R && this.S == c18283oP.S && this.T == c18283oP.T && this.Q == c18283oP.Q && this.O == c18283oP.O && this.N == c18283oP.N && this.P == c18283oP.P && this.K == c18283oP.K && this.J == c18283oP.J && this.G == c18283oP.G && this.y == c18283oP.y && this.A == c18283oP.A && this.z == c18283oP.z && this.I == c18283oP.I && this.H == c18283oP.H && this.U == c18283oP.U && this.l == c18283oP.l && this.p == c18283oP.p && this.h == c18283oP.h && this.g == c18283oP.g && this.k == c18283oP.k && this.t == c18283oP.t && this.M == c18283oP.M && Arrays.equals(this.d, c18283oP.d);
    }

    public int hashCode() {
        byte[] bArr = this.d;
        return ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((bArr != null ? Arrays.hashCode(bArr) : 0) * 31) + this.f) * 31) + this.g) * 31) + this.h) * 31) + this.i) * 31) + this.j) * 31) + (this.k ? 1 : 0)) * 31) + (this.l ? 1 : 0)) * 31) + this.m) * 31) + this.n) * 31) + this.o) * 31) + this.p) * 31) + this.q) * 31) + this.r) * 31) + this.s) * 31) + this.t) * 31) + this.u) * 31) + this.v) * 31) + this.w) * 31) + this.x) * 31) + this.y) * 31) + this.z) * 31) + this.A) * 31) + (this.B ? 1 : 0)) * 31) + (this.C ? 1 : 0)) * 31) + (this.D ? 1 : 0)) * 31) + this.E) * 31) + (this.F ? 1 : 0)) * 31) + this.G) * 31) + this.H) * 31) + this.I) * 31) + this.J) * 31) + this.K) * 31) + this.L) * 31) + this.M) * 31) + this.N) * 31) + this.O) * 31) + this.P) * 31) + this.Q) * 31) + this.R) * 31) + this.S) * 31) + this.T) * 31) + (this.U ? 1 : 0);
    }

    public ByteBuffer n() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(o());
        AbstractC5869Le3.j(byteBufferAllocate, 5);
        AbstractC5869Le3.j(byteBufferAllocate, o() - 2);
        C6347Nf0 c6347Nf0 = new C6347Nf0(byteBufferAllocate);
        c6347Nf0.a(this.f, 5);
        c6347Nf0.a(this.g, 4);
        if (this.g == 15) {
            throw new UnsupportedOperationException("can't serialize that yet");
        }
        c6347Nf0.a(this.i, 4);
        return byteBufferAllocate;
    }

    public int o() {
        if (this.f == 2) {
            return f() + 4;
        }
        throw new UnsupportedOperationException("can't serialize that yet");
    }

    public void p(int i) {
        this.f = i;
    }

    public void q(int i) {
        this.i = i;
    }

    public void r(int i) {
        this.g = i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AudioSpecificConfig");
        sb.append("{configBytes=");
        sb.append(AbstractC23185wV2.a(this.d));
        sb.append(", audioObjectType=");
        sb.append(this.f);
        sb.append(" (");
        sb.append((String) W.get(Integer.valueOf(this.f)));
        sb.append(Separators.RPAREN);
        sb.append(", samplingFrequencyIndex=");
        sb.append(this.g);
        sb.append(" (");
        sb.append(V.get(Integer.valueOf(this.g)));
        sb.append(Separators.RPAREN);
        sb.append(", samplingFrequency=");
        sb.append(this.h);
        sb.append(", channelConfiguration=");
        sb.append(this.i);
        if (this.j > 0) {
            sb.append(", extensionAudioObjectType=");
            sb.append(this.j);
            sb.append(" (");
            sb.append((String) W.get(Integer.valueOf(this.j)));
            sb.append(Separators.RPAREN);
            sb.append(", sbrPresentFlag=");
            sb.append(this.k);
            sb.append(", psPresentFlag=");
            sb.append(this.l);
            sb.append(", extensionSamplingFrequencyIndex=");
            sb.append(this.m);
            sb.append(" (");
            sb.append(V.get(Integer.valueOf(this.m)));
            sb.append(Separators.RPAREN);
            sb.append(", extensionSamplingFrequency=");
            sb.append(this.n);
            sb.append(", extensionChannelConfiguration=");
            sb.append(this.o);
        }
        sb.append(", syncExtensionType=");
        sb.append(this.t);
        if (this.F) {
            sb.append(", frameLengthFlag=");
            sb.append(this.u);
            sb.append(", dependsOnCoreCoder=");
            sb.append(this.v);
            sb.append(", coreCoderDelay=");
            sb.append(this.w);
            sb.append(", extensionFlag=");
            sb.append(this.x);
            sb.append(", layerNr=");
            sb.append(this.y);
            sb.append(", numOfSubFrame=");
            sb.append(this.z);
            sb.append(", layer_length=");
            sb.append(this.A);
            sb.append(", aacSectionDataResilienceFlag=");
            sb.append(this.B);
            sb.append(", aacScalefactorDataResilienceFlag=");
            sb.append(this.C);
            sb.append(", aacSpectralDataResilienceFlag=");
            sb.append(this.D);
            sb.append(", extensionFlag3=");
            sb.append(this.E);
        }
        if (this.U) {
            sb.append(", isBaseLayer=");
            sb.append(this.G);
            sb.append(", paraMode=");
            sb.append(this.H);
            sb.append(", paraExtensionFlag=");
            sb.append(this.I);
            sb.append(", hvxcVarMode=");
            sb.append(this.J);
            sb.append(", hvxcRateMode=");
            sb.append(this.K);
            sb.append(", erHvxcExtensionFlag=");
            sb.append(this.L);
            sb.append(", var_ScalableFlag=");
            sb.append(this.M);
            sb.append(", hilnQuantMode=");
            sb.append(this.N);
            sb.append(", hilnMaxNumLine=");
            sb.append(this.O);
            sb.append(", hilnSampleRateCode=");
            sb.append(this.P);
            sb.append(", hilnFrameLength=");
            sb.append(this.Q);
            sb.append(", hilnContMode=");
            sb.append(this.R);
            sb.append(", hilnEnhaLayer=");
            sb.append(this.S);
            sb.append(", hilnEnhaQuantMode=");
            sb.append(this.T);
        }
        sb.append('}');
        return sb.toString();
    }
}
