package com.google.android.exoplayer2;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Pair;
import com.google.android.exoplayer2.C2018a0;
import com.google.android.exoplayer2.InterfaceC2029g;
import com.google.android.exoplayer2.J0;
import com.google.android.exoplayer2.source.ads.AdPlaybackState;
import ir.nasim.AbstractC12710f43;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC25122zm0;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.BinderC24528ym0;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public abstract class J0 implements InterfaceC2029g {
    public static final J0 a = new a();
    private static final String b = AbstractC9683aN7.r0(0);
    private static final String c = AbstractC9683aN7.r0(1);
    private static final String d = AbstractC9683aN7.r0(2);
    public static final InterfaceC2029g.a e = new InterfaceC2029g.a() { // from class: ir.nasim.vq7
        @Override // com.google.android.exoplayer2.InterfaceC2029g.a
        public final InterfaceC2029g a(Bundle bundle) {
            return com.google.android.exoplayer2.J0.c(bundle);
        }
    };

    class a extends J0 {
        a() {
        }

        @Override // com.google.android.exoplayer2.J0
        public int g(Object obj) {
            return -1;
        }

        @Override // com.google.android.exoplayer2.J0
        public b l(int i, b bVar, boolean z) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.google.android.exoplayer2.J0
        public int n() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.J0
        public Object r(int i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.google.android.exoplayer2.J0
        public d t(int i, d dVar, long j) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.google.android.exoplayer2.J0
        public int u() {
            return 0;
        }
    }

    public static final class b implements InterfaceC2029g {
        private static final String h = AbstractC9683aN7.r0(0);
        private static final String i = AbstractC9683aN7.r0(1);
        private static final String j = AbstractC9683aN7.r0(2);
        private static final String k = AbstractC9683aN7.r0(3);
        private static final String l = AbstractC9683aN7.r0(4);
        public static final InterfaceC2029g.a m = new InterfaceC2029g.a() { // from class: ir.nasim.wq7
            @Override // com.google.android.exoplayer2.InterfaceC2029g.a
            public final InterfaceC2029g a(Bundle bundle) {
                return J0.b.d(bundle);
            }
        };
        public Object a;
        public Object b;
        public int c;
        public long d;
        public long e;
        public boolean f;
        private AdPlaybackState g = AdPlaybackState.g;

        /* JADX INFO: Access modifiers changed from: private */
        public static b d(Bundle bundle) {
            int i2 = bundle.getInt(h, 0);
            long j2 = bundle.getLong(i, -9223372036854775807L);
            long j3 = bundle.getLong(j, 0L);
            boolean z = bundle.getBoolean(k, false);
            Bundle bundle2 = bundle.getBundle(l);
            AdPlaybackState adPlaybackState = bundle2 != null ? (AdPlaybackState) AdPlaybackState.m.a(bundle2) : AdPlaybackState.g;
            b bVar = new b();
            bVar.w(null, null, i2, j2, j3, adPlaybackState, z);
            return bVar;
        }

        @Override // com.google.android.exoplayer2.InterfaceC2029g
        public Bundle a() {
            Bundle bundle = new Bundle();
            int i2 = this.c;
            if (i2 != 0) {
                bundle.putInt(h, i2);
            }
            long j2 = this.d;
            if (j2 != -9223372036854775807L) {
                bundle.putLong(i, j2);
            }
            long j3 = this.e;
            if (j3 != 0) {
                bundle.putLong(j, j3);
            }
            boolean z = this.f;
            if (z) {
                bundle.putBoolean(k, z);
            }
            if (!this.g.equals(AdPlaybackState.g)) {
                bundle.putBundle(l, this.g.a());
            }
            return bundle;
        }

        public int e(int i2) {
            return this.g.d(i2).b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !b.class.equals(obj.getClass())) {
                return false;
            }
            b bVar = (b) obj;
            return AbstractC9683aN7.c(this.a, bVar.a) && AbstractC9683aN7.c(this.b, bVar.b) && this.c == bVar.c && this.d == bVar.d && this.e == bVar.e && this.f == bVar.f && AbstractC9683aN7.c(this.g, bVar.g);
        }

        public long f(int i2, int i3) {
            AdPlaybackState.AdGroup adGroupD = this.g.d(i2);
            if (adGroupD.b != -1) {
                return adGroupD.f[i3];
            }
            return -9223372036854775807L;
        }

        public int g() {
            return this.g.b;
        }

        public int h(long j2) {
            return this.g.e(j2, this.d);
        }

        public int hashCode() {
            Object obj = this.a;
            int iHashCode = (217 + (obj == null ? 0 : obj.hashCode())) * 31;
            Object obj2 = this.b;
            int iHashCode2 = (((iHashCode + (obj2 != null ? obj2.hashCode() : 0)) * 31) + this.c) * 31;
            long j2 = this.d;
            int i2 = (iHashCode2 + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            long j3 = this.e;
            return ((((i2 + ((int) (j3 ^ (j3 >>> 32)))) * 31) + (this.f ? 1 : 0)) * 31) + this.g.hashCode();
        }

        public int i(long j2) {
            return this.g.f(j2, this.d);
        }

        public long j(int i2) {
            return this.g.d(i2).a;
        }

        public long k() {
            return this.g.c;
        }

        public int l(int i2, int i3) {
            AdPlaybackState.AdGroup adGroupD = this.g.d(i2);
            if (adGroupD.b != -1) {
                return adGroupD.e[i3];
            }
            return 0;
        }

        public long m(int i2) {
            return this.g.d(i2).g;
        }

        public long n() {
            return this.d;
        }

        public int o(int i2) {
            return this.g.d(i2).f();
        }

        public int p(int i2, int i3) {
            return this.g.d(i2).g(i3);
        }

        public long q() {
            return AbstractC9683aN7.c1(this.e);
        }

        public long r() {
            return this.e;
        }

        public int s() {
            return this.g.e;
        }

        public boolean t(int i2) {
            return !this.g.d(i2).h();
        }

        public boolean u(int i2) {
            return this.g.d(i2).h;
        }

        public b v(Object obj, Object obj2, int i2, long j2, long j3) {
            return w(obj, obj2, i2, j2, j3, AdPlaybackState.g, false);
        }

        public b w(Object obj, Object obj2, int i2, long j2, long j3, AdPlaybackState adPlaybackState, boolean z) {
            this.a = obj;
            this.b = obj2;
            this.c = i2;
            this.d = j2;
            this.e = j3;
            this.g = adPlaybackState;
            this.f = z;
            return this;
        }
    }

    public static final class c extends J0 {
        private final AbstractC12710f43 f;
        private final AbstractC12710f43 g;
        private final int[] h;
        private final int[] i;

        public c(AbstractC12710f43 abstractC12710f43, AbstractC12710f43 abstractC12710f432, int[] iArr) {
            AbstractC20011rK.a(abstractC12710f43.size() == iArr.length);
            this.f = abstractC12710f43;
            this.g = abstractC12710f432;
            this.h = iArr;
            this.i = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.i[iArr[i]] = i;
            }
        }

        @Override // com.google.android.exoplayer2.J0
        public int f(boolean z) {
            if (v()) {
                return -1;
            }
            if (z) {
                return this.h[0];
            }
            return 0;
        }

        @Override // com.google.android.exoplayer2.J0
        public int g(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.android.exoplayer2.J0
        public int h(boolean z) {
            if (v()) {
                return -1;
            }
            return z ? this.h[u() - 1] : u() - 1;
        }

        @Override // com.google.android.exoplayer2.J0
        public int j(int i, int i2, boolean z) {
            if (i2 == 1) {
                return i;
            }
            if (i != h(z)) {
                return z ? this.h[this.i[i] + 1] : i + 1;
            }
            if (i2 == 2) {
                return f(z);
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.J0
        public b l(int i, b bVar, boolean z) {
            b bVar2 = (b) this.g.get(i);
            bVar.w(bVar2.a, bVar2.b, bVar2.c, bVar2.d, bVar2.e, bVar2.g, bVar2.f);
            return bVar;
        }

        @Override // com.google.android.exoplayer2.J0
        public int n() {
            return this.g.size();
        }

        @Override // com.google.android.exoplayer2.J0
        public int q(int i, int i2, boolean z) {
            if (i2 == 1) {
                return i;
            }
            if (i != f(z)) {
                return z ? this.h[this.i[i] - 1] : i - 1;
            }
            if (i2 == 2) {
                return h(z);
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.J0
        public Object r(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.android.exoplayer2.J0
        public d t(int i, d dVar, long j) {
            d dVar2 = (d) this.f.get(i);
            dVar.j(dVar2.a, dVar2.c, dVar2.d, dVar2.e, dVar2.f, dVar2.g, dVar2.h, dVar2.i, dVar2.k, dVar2.m, dVar2.n, dVar2.o, dVar2.p, dVar2.q);
            dVar.l = dVar2.l;
            return dVar;
        }

        @Override // com.google.android.exoplayer2.J0
        public int u() {
            return this.f.size();
        }
    }

    public static final class d implements InterfaceC2029g {
        public Object b;
        public Object d;
        public long e;
        public long f;
        public long g;
        public boolean h;
        public boolean i;
        public boolean j;
        public C2018a0.g k;
        public boolean l;
        public long m;
        public long n;
        public int o;
        public int p;
        public long q;
        public static final Object r = new Object();
        private static final Object s = new Object();
        private static final C2018a0 t = new C2018a0.c().e("com.google.android.exoplayer2.Timeline").j(Uri.EMPTY).a();
        private static final String u = AbstractC9683aN7.r0(1);
        private static final String v = AbstractC9683aN7.r0(2);
        private static final String w = AbstractC9683aN7.r0(3);
        private static final String x = AbstractC9683aN7.r0(4);
        private static final String y = AbstractC9683aN7.r0(5);
        private static final String z = AbstractC9683aN7.r0(6);
        private static final String A = AbstractC9683aN7.r0(7);
        private static final String B = AbstractC9683aN7.r0(8);
        private static final String D = AbstractC9683aN7.r0(9);
        private static final String G = AbstractC9683aN7.r0(10);
        private static final String H = AbstractC9683aN7.r0(11);
        private static final String J = AbstractC9683aN7.r0(12);
        private static final String Y = AbstractC9683aN7.r0(13);
        public static final InterfaceC2029g.a Z = new InterfaceC2029g.a() { // from class: ir.nasim.xq7
            @Override // com.google.android.exoplayer2.InterfaceC2029g.a
            public final InterfaceC2029g a(Bundle bundle) {
                return J0.d.c(bundle);
            }
        };
        public Object a = r;
        public C2018a0 c = t;

        /* JADX INFO: Access modifiers changed from: private */
        public static d c(Bundle bundle) {
            Bundle bundle2 = bundle.getBundle(u);
            C2018a0 c2018a0 = bundle2 != null ? (C2018a0) C2018a0.o.a(bundle2) : C2018a0.i;
            long j = bundle.getLong(v, -9223372036854775807L);
            long j2 = bundle.getLong(w, -9223372036854775807L);
            long j3 = bundle.getLong(x, -9223372036854775807L);
            boolean z2 = bundle.getBoolean(y, false);
            boolean z3 = bundle.getBoolean(z, false);
            Bundle bundle3 = bundle.getBundle(A);
            C2018a0.g gVar = bundle3 != null ? (C2018a0.g) C2018a0.g.l.a(bundle3) : null;
            boolean z4 = bundle.getBoolean(B, false);
            long j4 = bundle.getLong(D, 0L);
            long j5 = bundle.getLong(G, -9223372036854775807L);
            int i = bundle.getInt(H, 0);
            int i2 = bundle.getInt(J, 0);
            long j6 = bundle.getLong(Y, 0L);
            d dVar = new d();
            dVar.j(s, c2018a0, null, j, j2, j3, z2, z3, gVar, j4, j5, i, i2, j6);
            dVar.l = z4;
            return dVar;
        }

        @Override // com.google.android.exoplayer2.InterfaceC2029g
        public Bundle a() {
            Bundle bundle = new Bundle();
            if (!C2018a0.i.equals(this.c)) {
                bundle.putBundle(u, this.c.a());
            }
            long j = this.e;
            if (j != -9223372036854775807L) {
                bundle.putLong(v, j);
            }
            long j2 = this.f;
            if (j2 != -9223372036854775807L) {
                bundle.putLong(w, j2);
            }
            long j3 = this.g;
            if (j3 != -9223372036854775807L) {
                bundle.putLong(x, j3);
            }
            boolean z2 = this.h;
            if (z2) {
                bundle.putBoolean(y, z2);
            }
            boolean z3 = this.i;
            if (z3) {
                bundle.putBoolean(z, z3);
            }
            C2018a0.g gVar = this.k;
            if (gVar != null) {
                bundle.putBundle(A, gVar.a());
            }
            boolean z4 = this.l;
            if (z4) {
                bundle.putBoolean(B, z4);
            }
            long j4 = this.m;
            if (j4 != 0) {
                bundle.putLong(D, j4);
            }
            long j5 = this.n;
            if (j5 != -9223372036854775807L) {
                bundle.putLong(G, j5);
            }
            int i = this.o;
            if (i != 0) {
                bundle.putInt(H, i);
            }
            int i2 = this.p;
            if (i2 != 0) {
                bundle.putInt(J, i2);
            }
            long j6 = this.q;
            if (j6 != 0) {
                bundle.putLong(Y, j6);
            }
            return bundle;
        }

        public long d() {
            return AbstractC9683aN7.Z(this.g);
        }

        public long e() {
            return AbstractC9683aN7.c1(this.m);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !d.class.equals(obj.getClass())) {
                return false;
            }
            d dVar = (d) obj;
            return AbstractC9683aN7.c(this.a, dVar.a) && AbstractC9683aN7.c(this.c, dVar.c) && AbstractC9683aN7.c(this.d, dVar.d) && AbstractC9683aN7.c(this.k, dVar.k) && this.e == dVar.e && this.f == dVar.f && this.g == dVar.g && this.h == dVar.h && this.i == dVar.i && this.l == dVar.l && this.m == dVar.m && this.n == dVar.n && this.o == dVar.o && this.p == dVar.p && this.q == dVar.q;
        }

        public long f() {
            return this.m;
        }

        public long g() {
            return AbstractC9683aN7.c1(this.n);
        }

        public long h() {
            return this.q;
        }

        public int hashCode() {
            int iHashCode = (((217 + this.a.hashCode()) * 31) + this.c.hashCode()) * 31;
            Object obj = this.d;
            int iHashCode2 = (iHashCode + (obj == null ? 0 : obj.hashCode())) * 31;
            C2018a0.g gVar = this.k;
            int iHashCode3 = (iHashCode2 + (gVar != null ? gVar.hashCode() : 0)) * 31;
            long j = this.e;
            int i = (iHashCode3 + ((int) (j ^ (j >>> 32)))) * 31;
            long j2 = this.f;
            int i2 = (i + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            long j3 = this.g;
            int i3 = (((((((i2 + ((int) (j3 ^ (j3 >>> 32)))) * 31) + (this.h ? 1 : 0)) * 31) + (this.i ? 1 : 0)) * 31) + (this.l ? 1 : 0)) * 31;
            long j4 = this.m;
            int i4 = (i3 + ((int) (j4 ^ (j4 >>> 32)))) * 31;
            long j5 = this.n;
            int i5 = (((((i4 + ((int) (j5 ^ (j5 >>> 32)))) * 31) + this.o) * 31) + this.p) * 31;
            long j6 = this.q;
            return i5 + ((int) (j6 ^ (j6 >>> 32)));
        }

        public boolean i() {
            AbstractC20011rK.g(this.j == (this.k != null));
            return this.k != null;
        }

        public d j(Object obj, C2018a0 c2018a0, Object obj2, long j, long j2, long j3, boolean z2, boolean z3, C2018a0.g gVar, long j4, long j5, int i, int i2, long j6) {
            C2018a0.h hVar;
            this.a = obj;
            this.c = c2018a0 != null ? c2018a0 : t;
            this.b = (c2018a0 == null || (hVar = c2018a0.b) == null) ? null : hVar.h;
            this.d = obj2;
            this.e = j;
            this.f = j2;
            this.g = j3;
            this.h = z2;
            this.i = z3;
            this.j = gVar != null;
            this.k = gVar;
            this.m = j4;
            this.n = j5;
            this.o = i;
            this.p = i2;
            this.q = j6;
            this.l = false;
            return this;
        }
    }

    protected J0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static J0 c(Bundle bundle) {
        AbstractC12710f43 abstractC12710f43D = d(d.Z, AbstractC25122zm0.a(bundle, b));
        AbstractC12710f43 abstractC12710f43D2 = d(b.m, AbstractC25122zm0.a(bundle, c));
        int[] intArray = bundle.getIntArray(d);
        if (intArray == null) {
            intArray = e(abstractC12710f43D.size());
        }
        return new c(abstractC12710f43D, abstractC12710f43D2, intArray);
    }

    private static AbstractC12710f43 d(InterfaceC2029g.a aVar, IBinder iBinder) {
        if (iBinder == null) {
            return AbstractC12710f43.V();
        }
        AbstractC12710f43.a aVar2 = new AbstractC12710f43.a();
        AbstractC12710f43 abstractC12710f43A = BinderC24528ym0.a(iBinder);
        for (int i = 0; i < abstractC12710f43A.size(); i++) {
            aVar2.a(aVar.a((Bundle) abstractC12710f43A.get(i)));
        }
        return aVar2.h();
    }

    private static int[] e(int i) {
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = i2;
        }
        return iArr;
    }

    @Override // com.google.android.exoplayer2.InterfaceC2029g
    public final Bundle a() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        ArrayList arrayList = new ArrayList();
        int iU = u();
        d dVar = new d();
        for (int i = 0; i < iU; i++) {
            arrayList.add(t(i, dVar, 0L).a());
        }
        ArrayList arrayList2 = new ArrayList();
        int iN = n();
        b bVar = new b();
        for (int i2 = 0; i2 < iN; i2++) {
            arrayList2.add(l(i2, bVar, false).a());
        }
        int[] iArr = new int[iU];
        if (iU > 0) {
            iArr[0] = f(true);
        }
        for (int i3 = 1; i3 < iU; i3++) {
            iArr[i3] = j(iArr[i3 - 1], 0, true);
        }
        Bundle bundle = new Bundle();
        AbstractC25122zm0.c(bundle, b, new BinderC24528ym0(arrayList));
        AbstractC25122zm0.c(bundle, c, new BinderC24528ym0(arrayList2));
        bundle.putIntArray(d, iArr);
        return bundle;
    }

    public boolean equals(Object obj) {
        int iH;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof J0)) {
            return false;
        }
        J0 j0 = (J0) obj;
        if (j0.u() != u() || j0.n() != n()) {
            return false;
        }
        d dVar = new d();
        b bVar = new b();
        d dVar2 = new d();
        b bVar2 = new b();
        for (int i = 0; i < u(); i++) {
            if (!s(i, dVar).equals(j0.s(i, dVar2))) {
                return false;
            }
        }
        for (int i2 = 0; i2 < n(); i2++) {
            if (!l(i2, bVar, true).equals(j0.l(i2, bVar2, true))) {
                return false;
            }
        }
        int iF = f(true);
        if (iF != j0.f(true) || (iH = h(true)) != j0.h(true)) {
            return false;
        }
        while (iF != iH) {
            int iJ = j(iF, 0, true);
            if (iJ != j0.j(iF, 0, true)) {
                return false;
            }
            iF = iJ;
        }
        return true;
    }

    public int f(boolean z) {
        return v() ? -1 : 0;
    }

    public abstract int g(Object obj);

    public int h(boolean z) {
        if (v()) {
            return -1;
        }
        return u() - 1;
    }

    public int hashCode() {
        d dVar = new d();
        b bVar = new b();
        int iU = 217 + u();
        for (int i = 0; i < u(); i++) {
            iU = (iU * 31) + s(i, dVar).hashCode();
        }
        int iN = (iU * 31) + n();
        for (int i2 = 0; i2 < n(); i2++) {
            iN = (iN * 31) + l(i2, bVar, true).hashCode();
        }
        int iF = f(true);
        while (iF != -1) {
            iN = (iN * 31) + iF;
            iF = j(iF, 0, true);
        }
        return iN;
    }

    public final int i(int i, b bVar, d dVar, int i2, boolean z) {
        int i3 = k(i, bVar).c;
        if (s(i3, dVar).p != i) {
            return i + 1;
        }
        int iJ = j(i3, i2, z);
        if (iJ == -1) {
            return -1;
        }
        return s(iJ, dVar).o;
    }

    public int j(int i, int i2, boolean z) {
        if (i2 == 0) {
            if (i == h(z)) {
                return -1;
            }
            return i + 1;
        }
        if (i2 == 1) {
            return i;
        }
        if (i2 == 2) {
            return i == h(z) ? f(z) : i + 1;
        }
        throw new IllegalStateException();
    }

    public final b k(int i, b bVar) {
        return l(i, bVar, false);
    }

    public abstract b l(int i, b bVar, boolean z);

    public b m(Object obj, b bVar) {
        return l(g(obj), bVar, true);
    }

    public abstract int n();

    public final Pair o(d dVar, b bVar, int i, long j) {
        return (Pair) AbstractC20011rK.e(p(dVar, bVar, i, j, 0L));
    }

    public final Pair p(d dVar, b bVar, int i, long j, long j2) {
        AbstractC20011rK.c(i, 0, u());
        t(i, dVar, j2);
        if (j == -9223372036854775807L) {
            j = dVar.f();
            if (j == -9223372036854775807L) {
                return null;
            }
        }
        int i2 = dVar.o;
        k(i2, bVar);
        while (i2 < dVar.p && bVar.e != j) {
            int i3 = i2 + 1;
            if (k(i3, bVar).e > j) {
                break;
            }
            i2 = i3;
        }
        l(i2, bVar, true);
        long jMin = j - bVar.e;
        long j3 = bVar.d;
        if (j3 != -9223372036854775807L) {
            jMin = Math.min(jMin, j3 - 1);
        }
        return Pair.create(AbstractC20011rK.e(bVar.b), Long.valueOf(Math.max(0L, jMin)));
    }

    public int q(int i, int i2, boolean z) {
        if (i2 == 0) {
            if (i == f(z)) {
                return -1;
            }
            return i - 1;
        }
        if (i2 == 1) {
            return i;
        }
        if (i2 == 2) {
            return i == f(z) ? h(z) : i - 1;
        }
        throw new IllegalStateException();
    }

    public abstract Object r(int i);

    public final d s(int i, d dVar) {
        return t(i, dVar, 0L);
    }

    public abstract d t(int i, d dVar, long j);

    public abstract int u();

    public final boolean v() {
        return u() == 0;
    }

    public final boolean w(int i, b bVar, d dVar, int i2, boolean z) {
        return i(i, bVar, dVar, i2, z) == -1;
    }
}
