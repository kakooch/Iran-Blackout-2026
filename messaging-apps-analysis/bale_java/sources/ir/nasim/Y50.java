package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes8.dex */
public final class Y50 {
    private static final /* synthetic */ Y50[] F0;
    private static final /* synthetic */ F92 G0;
    public static final a b;
    private static final int c;
    public int a;
    public static final Y50 d = new Y50("UNKNOWN", 0, 0);
    public static final Y50 e = new Y50("MELLI", 1, 1);
    public static final Y50 f = new Y50("SEPAH", 2, 2);
    public static final Y50 g = new Y50("TOSEEH_SADERAT", 3, 3);
    public static final Y50 h = new Y50("SANAT_MADAN", 4, 4);
    public static final Y50 i = new Y50("KESHAVARZI", 5, 5);
    public static final Y50 j = new Y50("MASKAN", 6, 6);
    public static final Y50 k = new Y50("POST_BANK", 7, 7);
    public static final Y50 l = new Y50("TOSEEH_TEAVON", 8, 8);
    public static final Y50 m = new Y50("EGHTESAD_NOVIN", 9, 9);
    public static final Y50 n = new Y50("PARSIAN", 10, 10);
    public static final Y50 o = new Y50("PASARGAD", 11, 11);
    public static final Y50 p = new Y50("KARAFARIN", 12, 12);
    public static final Y50 q = new Y50("SAMAN", 13, 13);
    public static final Y50 r = new Y50("SINA", 14, 14);
    public static final Y50 s = new Y50("SARMAYEH", 15, 15);
    public static final Y50 t = new Y50("TAT", 16, 16);
    public static final Y50 u = new Y50("SHAHR", 17, 17);
    public static final Y50 v = new Y50("DEY", 18, 18);
    public static final Y50 w = new Y50("SADERAT", 19, 19);
    public static final Y50 x = new Y50("MELAT", 20, 20);
    public static final Y50 y = new Y50("TEJARAT", 21, 21);
    public static final Y50 z = new Y50("REFAH", 22, 22);
    public static final Y50 A = new Y50("RESALAT", 23, 23);
    public static final Y50 B = new Y50("GHAVAMIN", 24, 24);
    public static final Y50 D = new Y50("ANSAR", 25, 25);
    public static final Y50 G = new Y50("HEKMAT", 26, 26);
    public static final Y50 H = new Y50("GARDESHGARI", 27, 27);
    public static final Y50 J = new Y50("MEHR_EGHTESAD", 28, 28);
    public static final Y50 Y = new Y50("TOSEEH", 29, 29);
    public static final Y50 Z = new Y50("IRAN_ZAMIN", 30, 30);
    public static final Y50 z0 = new Y50("MEHR_IRAN", 31, 31);
    public static final Y50 A0 = new Y50("MARKAZI", 32, 32);
    public static final Y50 B0 = new Y50("KOWSAR", 33, 33);
    public static final Y50 C0 = new Y50("NOUR", 34, 34);
    public static final Y50 D0 = new Y50("MELAL", 35, 35);
    public static final Y50 E0 = new Y50("KHAVAR_MIANEH", 36, 36);

    public static final class a {
        private a() {
        }

        public final Y50 a(int i) {
            switch (i) {
                case 1:
                    return Y50.e;
                case 2:
                    return Y50.f;
                case 3:
                    return Y50.g;
                case 4:
                    return Y50.h;
                case 5:
                    return Y50.i;
                case 6:
                    return Y50.j;
                case 7:
                    return Y50.k;
                case 8:
                    return Y50.l;
                case 9:
                    return Y50.m;
                case 10:
                    return Y50.n;
                case 11:
                    return Y50.o;
                case 12:
                    return Y50.p;
                case 13:
                    return Y50.q;
                case 14:
                    return Y50.r;
                case 15:
                    return Y50.s;
                case 16:
                    return Y50.t;
                case 17:
                    return Y50.u;
                case 18:
                    return Y50.v;
                case 19:
                    return Y50.w;
                case 20:
                    return Y50.x;
                case 21:
                    return Y50.y;
                case 22:
                    return Y50.z;
                case 23:
                    return Y50.A;
                case 24:
                    return Y50.B;
                case 25:
                    return Y50.D;
                case 26:
                    return Y50.G;
                case 27:
                    return Y50.H;
                case 28:
                    return Y50.J;
                case 29:
                    return Y50.Y;
                case 30:
                    return Y50.Z;
                case 31:
                    return Y50.z0;
                case 32:
                    return Y50.A0;
                case 33:
                    return Y50.B0;
                case 34:
                    return Y50.C0;
                case 35:
                    return Y50.D0;
                case 36:
                    return Y50.E0;
                default:
                    return Y50.d;
            }
        }

        public final int b() {
            return Y50.c;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        Y50[] y50ArrA = a();
        F0 = y50ArrA;
        G0 = G92.a(y50ArrA);
        b = new a(null);
        c = values().length;
    }

    private Y50(String str, int i2, int i3) {
        this.a = i3;
    }

    private static final /* synthetic */ Y50[] a() {
        return new Y50[]{d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, D, G, H, J, Y, Z, z0, A0, B0, C0, D0, E0};
    }

    public static final Y50 p(int i2) {
        return b.a(i2);
    }

    public static Y50 valueOf(String str) {
        return (Y50) Enum.valueOf(Y50.class, str);
    }

    public static Y50[] values() {
        return (Y50[]) F0.clone();
    }
}
