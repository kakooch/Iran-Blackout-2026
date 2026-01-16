package ir.nasim;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Layout;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.InterfaceC2029g;

/* renamed from: ir.nasim.hw1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C14451hw1 implements InterfaceC2029g {
    public final CharSequence a;
    public final Layout.Alignment b;
    public final Layout.Alignment c;
    public final Bitmap d;
    public final float e;
    public final int f;
    public final int g;
    public final float h;
    public final int i;
    public final float j;
    public final float k;
    public final boolean l;
    public final int m;
    public final int n;
    public final float o;
    public final int p;
    public final float q;
    public static final C14451hw1 r = new b().o("").a();
    private static final String s = AbstractC9683aN7.r0(0);
    private static final String t = AbstractC9683aN7.r0(1);
    private static final String u = AbstractC9683aN7.r0(2);
    private static final String v = AbstractC9683aN7.r0(3);
    private static final String w = AbstractC9683aN7.r0(4);
    private static final String x = AbstractC9683aN7.r0(5);
    private static final String y = AbstractC9683aN7.r0(6);
    private static final String z = AbstractC9683aN7.r0(7);
    private static final String A = AbstractC9683aN7.r0(8);
    private static final String B = AbstractC9683aN7.r0(9);
    private static final String D = AbstractC9683aN7.r0(10);
    private static final String G = AbstractC9683aN7.r0(11);
    private static final String H = AbstractC9683aN7.r0(12);
    private static final String J = AbstractC9683aN7.r0(13);
    private static final String Y = AbstractC9683aN7.r0(14);
    private static final String Z = AbstractC9683aN7.r0(15);
    private static final String z0 = AbstractC9683aN7.r0(16);
    public static final InterfaceC2029g.a A0 = new InterfaceC2029g.a() { // from class: ir.nasim.gw1
        @Override // com.google.android.exoplayer2.InterfaceC2029g.a
        public final InterfaceC2029g a(Bundle bundle) {
            return C14451hw1.d(bundle);
        }
    };

    /* renamed from: ir.nasim.hw1$b */
    public static final class b {
        private CharSequence a;
        private Bitmap b;
        private Layout.Alignment c;
        private Layout.Alignment d;
        private float e;
        private int f;
        private int g;
        private float h;
        private int i;
        private int j;
        private float k;
        private float l;
        private float m;
        private boolean n;
        private int o;
        private int p;
        private float q;

        public C14451hw1 a() {
            return new C14451hw1(this.a, this.c, this.d, this.b, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q);
        }

        public b b() {
            this.n = false;
            return this;
        }

        public int c() {
            return this.g;
        }

        public int d() {
            return this.i;
        }

        public CharSequence e() {
            return this.a;
        }

        public b f(Bitmap bitmap) {
            this.b = bitmap;
            return this;
        }

        public b g(float f) {
            this.m = f;
            return this;
        }

        public b h(float f, int i) {
            this.e = f;
            this.f = i;
            return this;
        }

        public b i(int i) {
            this.g = i;
            return this;
        }

        public b j(Layout.Alignment alignment) {
            this.d = alignment;
            return this;
        }

        public b k(float f) {
            this.h = f;
            return this;
        }

        public b l(int i) {
            this.i = i;
            return this;
        }

        public b m(float f) {
            this.q = f;
            return this;
        }

        public b n(float f) {
            this.l = f;
            return this;
        }

        public b o(CharSequence charSequence) {
            this.a = charSequence;
            return this;
        }

        public b p(Layout.Alignment alignment) {
            this.c = alignment;
            return this;
        }

        public b q(float f, int i) {
            this.k = f;
            this.j = i;
            return this;
        }

        public b r(int i) {
            this.p = i;
            return this;
        }

        public b s(int i) {
            this.o = i;
            this.n = true;
            return this;
        }

        public b() {
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = -3.4028235E38f;
            this.f = RecyclerView.UNDEFINED_DURATION;
            this.g = RecyclerView.UNDEFINED_DURATION;
            this.h = -3.4028235E38f;
            this.i = RecyclerView.UNDEFINED_DURATION;
            this.j = RecyclerView.UNDEFINED_DURATION;
            this.k = -3.4028235E38f;
            this.l = -3.4028235E38f;
            this.m = -3.4028235E38f;
            this.n = false;
            this.o = -16777216;
            this.p = RecyclerView.UNDEFINED_DURATION;
        }

        private b(C14451hw1 c14451hw1) {
            this.a = c14451hw1.a;
            this.b = c14451hw1.d;
            this.c = c14451hw1.b;
            this.d = c14451hw1.c;
            this.e = c14451hw1.e;
            this.f = c14451hw1.f;
            this.g = c14451hw1.g;
            this.h = c14451hw1.h;
            this.i = c14451hw1.i;
            this.j = c14451hw1.n;
            this.k = c14451hw1.o;
            this.l = c14451hw1.j;
            this.m = c14451hw1.k;
            this.n = c14451hw1.l;
            this.o = c14451hw1.m;
            this.p = c14451hw1.p;
            this.q = c14451hw1.q;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C14451hw1 d(Bundle bundle) {
        b bVar = new b();
        CharSequence charSequence = bundle.getCharSequence(s);
        if (charSequence != null) {
            bVar.o(charSequence);
        }
        Layout.Alignment alignment = (Layout.Alignment) bundle.getSerializable(t);
        if (alignment != null) {
            bVar.p(alignment);
        }
        Layout.Alignment alignment2 = (Layout.Alignment) bundle.getSerializable(u);
        if (alignment2 != null) {
            bVar.j(alignment2);
        }
        Bitmap bitmap = (Bitmap) bundle.getParcelable(v);
        if (bitmap != null) {
            bVar.f(bitmap);
        }
        String str = w;
        if (bundle.containsKey(str)) {
            String str2 = x;
            if (bundle.containsKey(str2)) {
                bVar.h(bundle.getFloat(str), bundle.getInt(str2));
            }
        }
        String str3 = y;
        if (bundle.containsKey(str3)) {
            bVar.i(bundle.getInt(str3));
        }
        String str4 = z;
        if (bundle.containsKey(str4)) {
            bVar.k(bundle.getFloat(str4));
        }
        String str5 = A;
        if (bundle.containsKey(str5)) {
            bVar.l(bundle.getInt(str5));
        }
        String str6 = D;
        if (bundle.containsKey(str6)) {
            String str7 = B;
            if (bundle.containsKey(str7)) {
                bVar.q(bundle.getFloat(str6), bundle.getInt(str7));
            }
        }
        String str8 = G;
        if (bundle.containsKey(str8)) {
            bVar.n(bundle.getFloat(str8));
        }
        String str9 = H;
        if (bundle.containsKey(str9)) {
            bVar.g(bundle.getFloat(str9));
        }
        String str10 = J;
        if (bundle.containsKey(str10)) {
            bVar.s(bundle.getInt(str10));
        }
        if (!bundle.getBoolean(Y, false)) {
            bVar.b();
        }
        String str11 = Z;
        if (bundle.containsKey(str11)) {
            bVar.r(bundle.getInt(str11));
        }
        String str12 = z0;
        if (bundle.containsKey(str12)) {
            bVar.m(bundle.getFloat(str12));
        }
        return bVar.a();
    }

    @Override // com.google.android.exoplayer2.InterfaceC2029g
    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putCharSequence(s, this.a);
        bundle.putSerializable(t, this.b);
        bundle.putSerializable(u, this.c);
        bundle.putParcelable(v, this.d);
        bundle.putFloat(w, this.e);
        bundle.putInt(x, this.f);
        bundle.putInt(y, this.g);
        bundle.putFloat(z, this.h);
        bundle.putInt(A, this.i);
        bundle.putInt(B, this.n);
        bundle.putFloat(D, this.o);
        bundle.putFloat(G, this.j);
        bundle.putFloat(H, this.k);
        bundle.putBoolean(Y, this.l);
        bundle.putInt(J, this.m);
        bundle.putInt(Z, this.p);
        bundle.putFloat(z0, this.q);
        return bundle;
    }

    public b c() {
        return new b();
    }

    public boolean equals(Object obj) {
        Bitmap bitmap;
        Bitmap bitmap2;
        if (this == obj) {
            return true;
        }
        if (obj == null || C14451hw1.class != obj.getClass()) {
            return false;
        }
        C14451hw1 c14451hw1 = (C14451hw1) obj;
        return TextUtils.equals(this.a, c14451hw1.a) && this.b == c14451hw1.b && this.c == c14451hw1.c && ((bitmap = this.d) != null ? !((bitmap2 = c14451hw1.d) == null || !bitmap.sameAs(bitmap2)) : c14451hw1.d == null) && this.e == c14451hw1.e && this.f == c14451hw1.f && this.g == c14451hw1.g && this.h == c14451hw1.h && this.i == c14451hw1.i && this.j == c14451hw1.j && this.k == c14451hw1.k && this.l == c14451hw1.l && this.m == c14451hw1.m && this.n == c14451hw1.n && this.o == c14451hw1.o && this.p == c14451hw1.p && this.q == c14451hw1.q;
    }

    public int hashCode() {
        return EG4.b(this.a, this.b, this.c, this.d, Float.valueOf(this.e), Integer.valueOf(this.f), Integer.valueOf(this.g), Float.valueOf(this.h), Integer.valueOf(this.i), Float.valueOf(this.j), Float.valueOf(this.k), Boolean.valueOf(this.l), Integer.valueOf(this.m), Integer.valueOf(this.n), Float.valueOf(this.o), Integer.valueOf(this.p), Float.valueOf(this.q));
    }

    private C14451hw1(CharSequence charSequence, Layout.Alignment alignment, Layout.Alignment alignment2, Bitmap bitmap, float f, int i, int i2, float f2, int i3, int i4, float f3, float f4, float f5, boolean z2, int i5, int i6, float f6) {
        if (charSequence == null) {
            AbstractC20011rK.e(bitmap);
        } else {
            AbstractC20011rK.a(bitmap == null);
        }
        if (charSequence instanceof Spanned) {
            this.a = SpannedString.valueOf(charSequence);
        } else if (charSequence != null) {
            this.a = charSequence.toString();
        } else {
            this.a = null;
        }
        this.b = alignment;
        this.c = alignment2;
        this.d = bitmap;
        this.e = f;
        this.f = i;
        this.g = i2;
        this.h = f2;
        this.i = i3;
        this.j = f4;
        this.k = f5;
        this.l = z2;
        this.m = i5;
        this.n = i4;
        this.o = f3;
        this.p = i6;
        this.q = f6;
    }
}
