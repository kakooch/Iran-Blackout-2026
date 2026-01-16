package com.google.android.exoplayer2;

import android.net.Uri;
import android.os.Bundle;
import com.google.android.exoplayer2.C2020b0;
import com.google.android.exoplayer2.InterfaceC2029g;
import com.google.android.exoplayer2.metadata.Metadata;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.EG4;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.b0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2020b0 implements InterfaceC2029g {
    public final CharSequence A;
    public final Integer B;
    public final Integer D;
    public final CharSequence G;
    public final CharSequence H;
    public final CharSequence J;
    public final Integer Y;
    public final Bundle Z;
    public final CharSequence a;
    public final CharSequence b;
    public final CharSequence c;
    public final CharSequence d;
    public final CharSequence e;
    public final CharSequence f;
    public final CharSequence g;
    public final C0 h;
    public final C0 i;
    public final byte[] j;
    public final Integer k;
    public final Uri l;
    public final Integer m;
    public final Integer n;
    public final Integer o;
    public final Boolean p;
    public final Boolean q;
    public final Integer r;
    public final Integer s;
    public final Integer t;
    public final Integer u;
    public final Integer v;
    public final Integer w;
    public final Integer x;
    public final CharSequence y;
    public final CharSequence z;
    public static final C2020b0 z0 = new b().H();
    private static final String A0 = AbstractC9683aN7.r0(0);
    private static final String B0 = AbstractC9683aN7.r0(1);
    private static final String C0 = AbstractC9683aN7.r0(2);
    private static final String D0 = AbstractC9683aN7.r0(3);
    private static final String E0 = AbstractC9683aN7.r0(4);
    private static final String F0 = AbstractC9683aN7.r0(5);
    private static final String G0 = AbstractC9683aN7.r0(6);
    private static final String H0 = AbstractC9683aN7.r0(8);
    private static final String I0 = AbstractC9683aN7.r0(9);
    private static final String J0 = AbstractC9683aN7.r0(10);
    private static final String K0 = AbstractC9683aN7.r0(11);
    private static final String L0 = AbstractC9683aN7.r0(12);
    private static final String M0 = AbstractC9683aN7.r0(13);
    private static final String N0 = AbstractC9683aN7.r0(14);
    private static final String O0 = AbstractC9683aN7.r0(15);
    private static final String P0 = AbstractC9683aN7.r0(16);
    private static final String Q0 = AbstractC9683aN7.r0(17);
    private static final String R0 = AbstractC9683aN7.r0(18);
    private static final String S0 = AbstractC9683aN7.r0(19);
    private static final String T0 = AbstractC9683aN7.r0(20);
    private static final String U0 = AbstractC9683aN7.r0(21);
    private static final String V0 = AbstractC9683aN7.r0(22);
    private static final String W0 = AbstractC9683aN7.r0(23);
    private static final String X0 = AbstractC9683aN7.r0(24);
    private static final String Y0 = AbstractC9683aN7.r0(25);
    private static final String Z0 = AbstractC9683aN7.r0(26);
    private static final String a1 = AbstractC9683aN7.r0(27);
    private static final String b1 = AbstractC9683aN7.r0(28);
    private static final String c1 = AbstractC9683aN7.r0(29);
    private static final String d1 = AbstractC9683aN7.r0(30);
    private static final String e1 = AbstractC9683aN7.r0(31);
    private static final String f1 = AbstractC9683aN7.r0(32);
    private static final String g1 = AbstractC9683aN7.r0(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT);
    public static final InterfaceC2029g.a h1 = new InterfaceC2029g.a() { // from class: ir.nasim.AX3
        @Override // com.google.android.exoplayer2.InterfaceC2029g.a
        public final InterfaceC2029g a(Bundle bundle) {
            return C2020b0.d(bundle);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static C2020b0 d(Bundle bundle) {
        Bundle bundle2;
        Bundle bundle3;
        b bVar = new b();
        b bVarU = bVar.m0(bundle.getCharSequence(A0)).O(bundle.getCharSequence(B0)).N(bundle.getCharSequence(C0)).M(bundle.getCharSequence(D0)).W(bundle.getCharSequence(E0)).l0(bundle.getCharSequence(F0)).U(bundle.getCharSequence(G0));
        byte[] byteArray = bundle.getByteArray(J0);
        String str = c1;
        bVarU.P(byteArray, bundle.containsKey(str) ? Integer.valueOf(bundle.getInt(str)) : null).Q((Uri) bundle.getParcelable(K0)).r0(bundle.getCharSequence(V0)).S(bundle.getCharSequence(W0)).T(bundle.getCharSequence(X0)).Z(bundle.getCharSequence(a1)).R(bundle.getCharSequence(b1)).k0(bundle.getCharSequence(d1)).X(bundle.getBundle(g1));
        String str2 = H0;
        if (bundle.containsKey(str2) && (bundle3 = bundle.getBundle(str2)) != null) {
            bVar.q0((C0) C0.b.a(bundle3));
        }
        String str3 = I0;
        if (bundle.containsKey(str3) && (bundle2 = bundle.getBundle(str3)) != null) {
            bVar.d0((C0) C0.b.a(bundle2));
        }
        String str4 = L0;
        if (bundle.containsKey(str4)) {
            bVar.p0(Integer.valueOf(bundle.getInt(str4)));
        }
        String str5 = M0;
        if (bundle.containsKey(str5)) {
            bVar.o0(Integer.valueOf(bundle.getInt(str5)));
        }
        String str6 = N0;
        if (bundle.containsKey(str6)) {
            bVar.Y(Integer.valueOf(bundle.getInt(str6)));
        }
        String str7 = f1;
        if (bundle.containsKey(str7)) {
            bVar.a0(Boolean.valueOf(bundle.getBoolean(str7)));
        }
        String str8 = O0;
        if (bundle.containsKey(str8)) {
            bVar.b0(Boolean.valueOf(bundle.getBoolean(str8)));
        }
        String str9 = P0;
        if (bundle.containsKey(str9)) {
            bVar.g0(Integer.valueOf(bundle.getInt(str9)));
        }
        String str10 = Q0;
        if (bundle.containsKey(str10)) {
            bVar.f0(Integer.valueOf(bundle.getInt(str10)));
        }
        String str11 = R0;
        if (bundle.containsKey(str11)) {
            bVar.e0(Integer.valueOf(bundle.getInt(str11)));
        }
        String str12 = S0;
        if (bundle.containsKey(str12)) {
            bVar.j0(Integer.valueOf(bundle.getInt(str12)));
        }
        String str13 = T0;
        if (bundle.containsKey(str13)) {
            bVar.i0(Integer.valueOf(bundle.getInt(str13)));
        }
        String str14 = U0;
        if (bundle.containsKey(str14)) {
            bVar.h0(Integer.valueOf(bundle.getInt(str14)));
        }
        String str15 = Y0;
        if (bundle.containsKey(str15)) {
            bVar.V(Integer.valueOf(bundle.getInt(str15)));
        }
        String str16 = Z0;
        if (bundle.containsKey(str16)) {
            bVar.n0(Integer.valueOf(bundle.getInt(str16)));
        }
        String str17 = e1;
        if (bundle.containsKey(str17)) {
            bVar.c0(Integer.valueOf(bundle.getInt(str17)));
        }
        return bVar.H();
    }

    private static int e(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
                return 1;
            case 20:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            default:
                return 0;
            case 21:
                return 2;
            case 22:
                return 3;
            case 23:
                return 4;
            case 24:
                return 5;
            case 25:
                return 6;
        }
    }

    private static int f(int i) {
        switch (i) {
            case 1:
                return 0;
            case 2:
                return 21;
            case 3:
                return 22;
            case 4:
                return 23;
            case 5:
                return 24;
            case 6:
                return 25;
            default:
                return 20;
        }
    }

    @Override // com.google.android.exoplayer2.InterfaceC2029g
    public Bundle a() {
        Bundle bundle = new Bundle();
        CharSequence charSequence = this.a;
        if (charSequence != null) {
            bundle.putCharSequence(A0, charSequence);
        }
        CharSequence charSequence2 = this.b;
        if (charSequence2 != null) {
            bundle.putCharSequence(B0, charSequence2);
        }
        CharSequence charSequence3 = this.c;
        if (charSequence3 != null) {
            bundle.putCharSequence(C0, charSequence3);
        }
        CharSequence charSequence4 = this.d;
        if (charSequence4 != null) {
            bundle.putCharSequence(D0, charSequence4);
        }
        CharSequence charSequence5 = this.e;
        if (charSequence5 != null) {
            bundle.putCharSequence(E0, charSequence5);
        }
        CharSequence charSequence6 = this.f;
        if (charSequence6 != null) {
            bundle.putCharSequence(F0, charSequence6);
        }
        CharSequence charSequence7 = this.g;
        if (charSequence7 != null) {
            bundle.putCharSequence(G0, charSequence7);
        }
        byte[] bArr = this.j;
        if (bArr != null) {
            bundle.putByteArray(J0, bArr);
        }
        Uri uri = this.l;
        if (uri != null) {
            bundle.putParcelable(K0, uri);
        }
        CharSequence charSequence8 = this.y;
        if (charSequence8 != null) {
            bundle.putCharSequence(V0, charSequence8);
        }
        CharSequence charSequence9 = this.z;
        if (charSequence9 != null) {
            bundle.putCharSequence(W0, charSequence9);
        }
        CharSequence charSequence10 = this.A;
        if (charSequence10 != null) {
            bundle.putCharSequence(X0, charSequence10);
        }
        CharSequence charSequence11 = this.G;
        if (charSequence11 != null) {
            bundle.putCharSequence(a1, charSequence11);
        }
        CharSequence charSequence12 = this.H;
        if (charSequence12 != null) {
            bundle.putCharSequence(b1, charSequence12);
        }
        CharSequence charSequence13 = this.J;
        if (charSequence13 != null) {
            bundle.putCharSequence(d1, charSequence13);
        }
        C0 c0 = this.h;
        if (c0 != null) {
            bundle.putBundle(H0, c0.a());
        }
        C0 c02 = this.i;
        if (c02 != null) {
            bundle.putBundle(I0, c02.a());
        }
        Integer num = this.m;
        if (num != null) {
            bundle.putInt(L0, num.intValue());
        }
        Integer num2 = this.n;
        if (num2 != null) {
            bundle.putInt(M0, num2.intValue());
        }
        Integer num3 = this.o;
        if (num3 != null) {
            bundle.putInt(N0, num3.intValue());
        }
        Boolean bool = this.p;
        if (bool != null) {
            bundle.putBoolean(f1, bool.booleanValue());
        }
        Boolean bool2 = this.q;
        if (bool2 != null) {
            bundle.putBoolean(O0, bool2.booleanValue());
        }
        Integer num4 = this.s;
        if (num4 != null) {
            bundle.putInt(P0, num4.intValue());
        }
        Integer num5 = this.t;
        if (num5 != null) {
            bundle.putInt(Q0, num5.intValue());
        }
        Integer num6 = this.u;
        if (num6 != null) {
            bundle.putInt(R0, num6.intValue());
        }
        Integer num7 = this.v;
        if (num7 != null) {
            bundle.putInt(S0, num7.intValue());
        }
        Integer num8 = this.w;
        if (num8 != null) {
            bundle.putInt(T0, num8.intValue());
        }
        Integer num9 = this.x;
        if (num9 != null) {
            bundle.putInt(U0, num9.intValue());
        }
        Integer num10 = this.B;
        if (num10 != null) {
            bundle.putInt(Y0, num10.intValue());
        }
        Integer num11 = this.D;
        if (num11 != null) {
            bundle.putInt(Z0, num11.intValue());
        }
        Integer num12 = this.k;
        if (num12 != null) {
            bundle.putInt(c1, num12.intValue());
        }
        Integer num13 = this.Y;
        if (num13 != null) {
            bundle.putInt(e1, num13.intValue());
        }
        Bundle bundle2 = this.Z;
        if (bundle2 != null) {
            bundle.putBundle(g1, bundle2);
        }
        return bundle;
    }

    public b c() {
        return new b();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2020b0.class != obj.getClass()) {
            return false;
        }
        C2020b0 c2020b0 = (C2020b0) obj;
        return AbstractC9683aN7.c(this.a, c2020b0.a) && AbstractC9683aN7.c(this.b, c2020b0.b) && AbstractC9683aN7.c(this.c, c2020b0.c) && AbstractC9683aN7.c(this.d, c2020b0.d) && AbstractC9683aN7.c(this.e, c2020b0.e) && AbstractC9683aN7.c(this.f, c2020b0.f) && AbstractC9683aN7.c(this.g, c2020b0.g) && AbstractC9683aN7.c(this.h, c2020b0.h) && AbstractC9683aN7.c(this.i, c2020b0.i) && Arrays.equals(this.j, c2020b0.j) && AbstractC9683aN7.c(this.k, c2020b0.k) && AbstractC9683aN7.c(this.l, c2020b0.l) && AbstractC9683aN7.c(this.m, c2020b0.m) && AbstractC9683aN7.c(this.n, c2020b0.n) && AbstractC9683aN7.c(this.o, c2020b0.o) && AbstractC9683aN7.c(this.p, c2020b0.p) && AbstractC9683aN7.c(this.q, c2020b0.q) && AbstractC9683aN7.c(this.s, c2020b0.s) && AbstractC9683aN7.c(this.t, c2020b0.t) && AbstractC9683aN7.c(this.u, c2020b0.u) && AbstractC9683aN7.c(this.v, c2020b0.v) && AbstractC9683aN7.c(this.w, c2020b0.w) && AbstractC9683aN7.c(this.x, c2020b0.x) && AbstractC9683aN7.c(this.y, c2020b0.y) && AbstractC9683aN7.c(this.z, c2020b0.z) && AbstractC9683aN7.c(this.A, c2020b0.A) && AbstractC9683aN7.c(this.B, c2020b0.B) && AbstractC9683aN7.c(this.D, c2020b0.D) && AbstractC9683aN7.c(this.G, c2020b0.G) && AbstractC9683aN7.c(this.H, c2020b0.H) && AbstractC9683aN7.c(this.J, c2020b0.J) && AbstractC9683aN7.c(this.Y, c2020b0.Y);
    }

    public int hashCode() {
        return EG4.b(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, Integer.valueOf(Arrays.hashCode(this.j)), this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.s, this.t, this.u, this.v, this.w, this.x, this.y, this.z, this.A, this.B, this.D, this.G, this.H, this.J, this.Y);
    }

    /* renamed from: com.google.android.exoplayer2.b0$b */
    public static final class b {
        private Integer A;
        private Integer B;
        private CharSequence C;
        private CharSequence D;
        private CharSequence E;
        private Integer F;
        private Bundle G;
        private CharSequence a;
        private CharSequence b;
        private CharSequence c;
        private CharSequence d;
        private CharSequence e;
        private CharSequence f;
        private CharSequence g;
        private C0 h;
        private C0 i;
        private byte[] j;
        private Integer k;
        private Uri l;
        private Integer m;
        private Integer n;
        private Integer o;
        private Boolean p;
        private Boolean q;
        private Integer r;
        private Integer s;
        private Integer t;
        private Integer u;
        private Integer v;
        private Integer w;
        private CharSequence x;
        private CharSequence y;
        private CharSequence z;

        public b() {
        }

        public C2020b0 H() {
            return new C2020b0(this);
        }

        public b I(byte[] bArr, int i) {
            if (this.j == null || AbstractC9683aN7.c(Integer.valueOf(i), 3) || !AbstractC9683aN7.c(this.k, 3)) {
                this.j = (byte[]) bArr.clone();
                this.k = Integer.valueOf(i);
            }
            return this;
        }

        public b J(C2020b0 c2020b0) {
            if (c2020b0 == null) {
                return this;
            }
            CharSequence charSequence = c2020b0.a;
            if (charSequence != null) {
                m0(charSequence);
            }
            CharSequence charSequence2 = c2020b0.b;
            if (charSequence2 != null) {
                O(charSequence2);
            }
            CharSequence charSequence3 = c2020b0.c;
            if (charSequence3 != null) {
                N(charSequence3);
            }
            CharSequence charSequence4 = c2020b0.d;
            if (charSequence4 != null) {
                M(charSequence4);
            }
            CharSequence charSequence5 = c2020b0.e;
            if (charSequence5 != null) {
                W(charSequence5);
            }
            CharSequence charSequence6 = c2020b0.f;
            if (charSequence6 != null) {
                l0(charSequence6);
            }
            CharSequence charSequence7 = c2020b0.g;
            if (charSequence7 != null) {
                U(charSequence7);
            }
            C0 c0 = c2020b0.h;
            if (c0 != null) {
                q0(c0);
            }
            C0 c02 = c2020b0.i;
            if (c02 != null) {
                d0(c02);
            }
            byte[] bArr = c2020b0.j;
            if (bArr != null) {
                P(bArr, c2020b0.k);
            }
            Uri uri = c2020b0.l;
            if (uri != null) {
                Q(uri);
            }
            Integer num = c2020b0.m;
            if (num != null) {
                p0(num);
            }
            Integer num2 = c2020b0.n;
            if (num2 != null) {
                o0(num2);
            }
            Integer num3 = c2020b0.o;
            if (num3 != null) {
                Y(num3);
            }
            Boolean bool = c2020b0.p;
            if (bool != null) {
                a0(bool);
            }
            Boolean bool2 = c2020b0.q;
            if (bool2 != null) {
                b0(bool2);
            }
            Integer num4 = c2020b0.r;
            if (num4 != null) {
                g0(num4);
            }
            Integer num5 = c2020b0.s;
            if (num5 != null) {
                g0(num5);
            }
            Integer num6 = c2020b0.t;
            if (num6 != null) {
                f0(num6);
            }
            Integer num7 = c2020b0.u;
            if (num7 != null) {
                e0(num7);
            }
            Integer num8 = c2020b0.v;
            if (num8 != null) {
                j0(num8);
            }
            Integer num9 = c2020b0.w;
            if (num9 != null) {
                i0(num9);
            }
            Integer num10 = c2020b0.x;
            if (num10 != null) {
                h0(num10);
            }
            CharSequence charSequence8 = c2020b0.y;
            if (charSequence8 != null) {
                r0(charSequence8);
            }
            CharSequence charSequence9 = c2020b0.z;
            if (charSequence9 != null) {
                S(charSequence9);
            }
            CharSequence charSequence10 = c2020b0.A;
            if (charSequence10 != null) {
                T(charSequence10);
            }
            Integer num11 = c2020b0.B;
            if (num11 != null) {
                V(num11);
            }
            Integer num12 = c2020b0.D;
            if (num12 != null) {
                n0(num12);
            }
            CharSequence charSequence11 = c2020b0.G;
            if (charSequence11 != null) {
                Z(charSequence11);
            }
            CharSequence charSequence12 = c2020b0.H;
            if (charSequence12 != null) {
                R(charSequence12);
            }
            CharSequence charSequence13 = c2020b0.J;
            if (charSequence13 != null) {
                k0(charSequence13);
            }
            Integer num13 = c2020b0.Y;
            if (num13 != null) {
                c0(num13);
            }
            Bundle bundle = c2020b0.Z;
            if (bundle != null) {
                X(bundle);
            }
            return this;
        }

        public b K(Metadata metadata) {
            for (int i = 0; i < metadata.e(); i++) {
                metadata.d(i).R0(this);
            }
            return this;
        }

        public b L(List list) {
            for (int i = 0; i < list.size(); i++) {
                Metadata metadata = (Metadata) list.get(i);
                for (int i2 = 0; i2 < metadata.e(); i2++) {
                    metadata.d(i2).R0(this);
                }
            }
            return this;
        }

        public b M(CharSequence charSequence) {
            this.d = charSequence;
            return this;
        }

        public b N(CharSequence charSequence) {
            this.c = charSequence;
            return this;
        }

        public b O(CharSequence charSequence) {
            this.b = charSequence;
            return this;
        }

        public b P(byte[] bArr, Integer num) {
            this.j = bArr == null ? null : (byte[]) bArr.clone();
            this.k = num;
            return this;
        }

        public b Q(Uri uri) {
            this.l = uri;
            return this;
        }

        public b R(CharSequence charSequence) {
            this.D = charSequence;
            return this;
        }

        public b S(CharSequence charSequence) {
            this.y = charSequence;
            return this;
        }

        public b T(CharSequence charSequence) {
            this.z = charSequence;
            return this;
        }

        public b U(CharSequence charSequence) {
            this.g = charSequence;
            return this;
        }

        public b V(Integer num) {
            this.A = num;
            return this;
        }

        public b W(CharSequence charSequence) {
            this.e = charSequence;
            return this;
        }

        public b X(Bundle bundle) {
            this.G = bundle;
            return this;
        }

        public b Y(Integer num) {
            this.o = num;
            return this;
        }

        public b Z(CharSequence charSequence) {
            this.C = charSequence;
            return this;
        }

        public b a0(Boolean bool) {
            this.p = bool;
            return this;
        }

        public b b0(Boolean bool) {
            this.q = bool;
            return this;
        }

        public b c0(Integer num) {
            this.F = num;
            return this;
        }

        public b d0(C0 c0) {
            this.i = c0;
            return this;
        }

        public b e0(Integer num) {
            this.t = num;
            return this;
        }

        public b f0(Integer num) {
            this.s = num;
            return this;
        }

        public b g0(Integer num) {
            this.r = num;
            return this;
        }

        public b h0(Integer num) {
            this.w = num;
            return this;
        }

        public b i0(Integer num) {
            this.v = num;
            return this;
        }

        public b j0(Integer num) {
            this.u = num;
            return this;
        }

        public b k0(CharSequence charSequence) {
            this.E = charSequence;
            return this;
        }

        public b l0(CharSequence charSequence) {
            this.f = charSequence;
            return this;
        }

        public b m0(CharSequence charSequence) {
            this.a = charSequence;
            return this;
        }

        public b n0(Integer num) {
            this.B = num;
            return this;
        }

        public b o0(Integer num) {
            this.n = num;
            return this;
        }

        public b p0(Integer num) {
            this.m = num;
            return this;
        }

        public b q0(C0 c0) {
            this.h = c0;
            return this;
        }

        public b r0(CharSequence charSequence) {
            this.x = charSequence;
            return this;
        }

        private b(C2020b0 c2020b0) {
            this.a = c2020b0.a;
            this.b = c2020b0.b;
            this.c = c2020b0.c;
            this.d = c2020b0.d;
            this.e = c2020b0.e;
            this.f = c2020b0.f;
            this.g = c2020b0.g;
            this.h = c2020b0.h;
            this.i = c2020b0.i;
            this.j = c2020b0.j;
            this.k = c2020b0.k;
            this.l = c2020b0.l;
            this.m = c2020b0.m;
            this.n = c2020b0.n;
            this.o = c2020b0.o;
            this.p = c2020b0.p;
            this.q = c2020b0.q;
            this.r = c2020b0.s;
            this.s = c2020b0.t;
            this.t = c2020b0.u;
            this.u = c2020b0.v;
            this.v = c2020b0.w;
            this.w = c2020b0.x;
            this.x = c2020b0.y;
            this.y = c2020b0.z;
            this.z = c2020b0.A;
            this.A = c2020b0.B;
            this.B = c2020b0.D;
            this.C = c2020b0.G;
            this.D = c2020b0.H;
            this.E = c2020b0.J;
            this.F = c2020b0.Y;
            this.G = c2020b0.Z;
        }
    }

    private C2020b0(b bVar) {
        Boolean boolValueOf = bVar.p;
        Integer numValueOf = bVar.o;
        Integer numValueOf2 = bVar.F;
        if (boolValueOf != null) {
            if (!boolValueOf.booleanValue()) {
                numValueOf = -1;
            } else if (numValueOf == null || numValueOf.intValue() == -1) {
                numValueOf = Integer.valueOf(numValueOf2 != null ? e(numValueOf2.intValue()) : 0);
            }
        } else if (numValueOf != null) {
            boolean z = numValueOf.intValue() != -1;
            boolValueOf = Boolean.valueOf(z);
            if (z && numValueOf2 == null) {
                numValueOf2 = Integer.valueOf(f(numValueOf.intValue()));
            }
        }
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.c;
        this.d = bVar.d;
        this.e = bVar.e;
        this.f = bVar.f;
        this.g = bVar.g;
        this.h = bVar.h;
        this.i = bVar.i;
        this.j = bVar.j;
        this.k = bVar.k;
        this.l = bVar.l;
        this.m = bVar.m;
        this.n = bVar.n;
        this.o = numValueOf;
        this.p = boolValueOf;
        this.q = bVar.q;
        this.r = bVar.r;
        this.s = bVar.r;
        this.t = bVar.s;
        this.u = bVar.t;
        this.v = bVar.u;
        this.w = bVar.v;
        this.x = bVar.w;
        this.y = bVar.x;
        this.z = bVar.y;
        this.A = bVar.z;
        this.B = bVar.A;
        this.D = bVar.B;
        this.G = bVar.C;
        this.H = bVar.D;
        this.J = bVar.E;
        this.Y = numValueOf2;
        this.Z = bVar.G;
    }
}
