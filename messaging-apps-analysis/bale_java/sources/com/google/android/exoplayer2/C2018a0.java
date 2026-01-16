package com.google.android.exoplayer2;

import android.net.Uri;
import android.os.Bundle;
import com.google.android.exoplayer2.C2018a0;
import com.google.android.exoplayer2.InterfaceC2029g;
import ir.nasim.AbstractC12710f43;
import ir.nasim.AbstractC13937h43;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC9683aN7;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* renamed from: com.google.android.exoplayer2.a0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2018a0 implements InterfaceC2029g {
    public static final C2018a0 i = new c().a();
    private static final String j = AbstractC9683aN7.r0(0);
    private static final String k = AbstractC9683aN7.r0(1);
    private static final String l = AbstractC9683aN7.r0(2);
    private static final String m = AbstractC9683aN7.r0(3);
    private static final String n = AbstractC9683aN7.r0(4);
    public static final InterfaceC2029g.a o = new InterfaceC2029g.a() { // from class: ir.nasim.sX3
        @Override // com.google.android.exoplayer2.InterfaceC2029g.a
        public final InterfaceC2029g a(Bundle bundle) {
            return C2018a0.d(bundle);
        }
    };
    public final String a;
    public final h b;
    public final i c;
    public final g d;
    public final C2020b0 e;
    public final d f;
    public final e g;
    public final j h;

    /* renamed from: com.google.android.exoplayer2.a0$b */
    public static final class b {
    }

    /* renamed from: com.google.android.exoplayer2.a0$c */
    public static final class c {
        private String a;
        private Uri b;
        private String c;
        private d.a d;
        private f.a e;
        private List f;
        private String g;
        private AbstractC12710f43 h;
        private Object i;
        private C2020b0 j;
        private g.a k;
        private j l;

        public C2018a0 a() {
            i iVar;
            AbstractC20011rK.g(this.e.b == null || this.e.a != null);
            Uri uri = this.b;
            if (uri != null) {
                iVar = new i(uri, this.c, this.e.a != null ? this.e.i() : null, null, this.f, this.g, this.h, this.i);
            } else {
                iVar = null;
            }
            String str = this.a;
            if (str == null) {
                str = "";
            }
            String str2 = str;
            e eVarG = this.d.g();
            g gVarF = this.k.f();
            C2020b0 c2020b0 = this.j;
            if (c2020b0 == null) {
                c2020b0 = C2020b0.z0;
            }
            return new C2018a0(str2, eVarG, iVar, gVarF, c2020b0, this.l);
        }

        public c b(String str) {
            this.g = str;
            return this;
        }

        public c c(f fVar) {
            this.e = fVar != null ? fVar.b() : new f.a();
            return this;
        }

        public c d(g gVar) {
            this.k = gVar.c();
            return this;
        }

        public c e(String str) {
            this.a = (String) AbstractC20011rK.e(str);
            return this;
        }

        public c f(C2020b0 c2020b0) {
            this.j = c2020b0;
            return this;
        }

        public c g(String str) {
            this.c = str;
            return this;
        }

        public c h(List list) {
            this.h = AbstractC12710f43.O(list);
            return this;
        }

        public c i(Object obj) {
            this.i = obj;
            return this;
        }

        public c j(Uri uri) {
            this.b = uri;
            return this;
        }

        public c k(String str) {
            return j(str == null ? null : Uri.parse(str));
        }

        public c() {
            this.d = new d.a();
            this.e = new f.a();
            this.f = Collections.emptyList();
            this.h = AbstractC12710f43.V();
            this.k = new g.a();
            this.l = j.d;
        }

        private c(C2018a0 c2018a0) {
            f.a aVar;
            this();
            this.d = c2018a0.f.c();
            this.a = c2018a0.a;
            this.j = c2018a0.e;
            this.k = c2018a0.d.c();
            this.l = c2018a0.h;
            h hVar = c2018a0.b;
            if (hVar != null) {
                this.g = hVar.e;
                this.c = hVar.b;
                this.b = hVar.a;
                this.f = hVar.d;
                this.h = hVar.f;
                this.i = hVar.h;
                f fVar = hVar.c;
                if (fVar != null) {
                    aVar = fVar.b();
                } else {
                    aVar = new f.a();
                }
                this.e = aVar;
            }
        }
    }

    /* renamed from: com.google.android.exoplayer2.a0$d */
    public static class d implements InterfaceC2029g {
        public static final d f = new a().f();
        private static final String g = AbstractC9683aN7.r0(0);
        private static final String h = AbstractC9683aN7.r0(1);
        private static final String i = AbstractC9683aN7.r0(2);
        private static final String j = AbstractC9683aN7.r0(3);
        private static final String k = AbstractC9683aN7.r0(4);
        public static final InterfaceC2029g.a l = new InterfaceC2029g.a() { // from class: ir.nasim.uX3
            @Override // com.google.android.exoplayer2.InterfaceC2029g.a
            public final InterfaceC2029g a(Bundle bundle) {
                return C2018a0.d.d(bundle);
            }
        };
        public final long a;
        public final long b;
        public final boolean c;
        public final boolean d;
        public final boolean e;

        /* renamed from: com.google.android.exoplayer2.a0$d$a */
        public static final class a {
            private long a;
            private long b;
            private boolean c;
            private boolean d;
            private boolean e;

            public d f() {
                return g();
            }

            public e g() {
                return new e(this);
            }

            public a h(long j) {
                AbstractC20011rK.a(j == Long.MIN_VALUE || j >= 0);
                this.b = j;
                return this;
            }

            public a i(boolean z) {
                this.d = z;
                return this;
            }

            public a j(boolean z) {
                this.c = z;
                return this;
            }

            public a k(long j) {
                AbstractC20011rK.a(j >= 0);
                this.a = j;
                return this;
            }

            public a l(boolean z) {
                this.e = z;
                return this;
            }

            public a() {
                this.b = Long.MIN_VALUE;
            }

            private a(d dVar) {
                this.a = dVar.a;
                this.b = dVar.b;
                this.c = dVar.c;
                this.d = dVar.d;
                this.e = dVar.e;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ e d(Bundle bundle) {
            a aVar = new a();
            String str = g;
            d dVar = f;
            return aVar.k(bundle.getLong(str, dVar.a)).h(bundle.getLong(h, dVar.b)).j(bundle.getBoolean(i, dVar.c)).i(bundle.getBoolean(j, dVar.d)).l(bundle.getBoolean(k, dVar.e)).g();
        }

        @Override // com.google.android.exoplayer2.InterfaceC2029g
        public Bundle a() {
            Bundle bundle = new Bundle();
            long j2 = this.a;
            d dVar = f;
            if (j2 != dVar.a) {
                bundle.putLong(g, j2);
            }
            long j3 = this.b;
            if (j3 != dVar.b) {
                bundle.putLong(h, j3);
            }
            boolean z = this.c;
            if (z != dVar.c) {
                bundle.putBoolean(i, z);
            }
            boolean z2 = this.d;
            if (z2 != dVar.d) {
                bundle.putBoolean(j, z2);
            }
            boolean z3 = this.e;
            if (z3 != dVar.e) {
                bundle.putBoolean(k, z3);
            }
            return bundle;
        }

        public a c() {
            return new a();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.a == dVar.a && this.b == dVar.b && this.c == dVar.c && this.d == dVar.d && this.e == dVar.e;
        }

        public int hashCode() {
            long j2 = this.a;
            int i2 = ((int) (j2 ^ (j2 >>> 32))) * 31;
            long j3 = this.b;
            return ((((((i2 + ((int) ((j3 >>> 32) ^ j3))) * 31) + (this.c ? 1 : 0)) * 31) + (this.d ? 1 : 0)) * 31) + (this.e ? 1 : 0);
        }

        private d(a aVar) {
            this.a = aVar.a;
            this.b = aVar.b;
            this.c = aVar.c;
            this.d = aVar.d;
            this.e = aVar.e;
        }
    }

    /* renamed from: com.google.android.exoplayer2.a0$e */
    public static final class e extends d {
        public static final e m = new d.a().g();

        private e(d.a aVar) {
            super(aVar);
        }
    }

    /* renamed from: com.google.android.exoplayer2.a0$f */
    public static final class f {
        public final UUID a;
        public final UUID b;
        public final Uri c;
        public final AbstractC13937h43 d;
        public final AbstractC13937h43 e;
        public final boolean f;
        public final boolean g;
        public final boolean h;
        public final AbstractC12710f43 i;
        public final AbstractC12710f43 j;
        private final byte[] k;

        public a b() {
            return new a();
        }

        public byte[] c() {
            byte[] bArr = this.k;
            if (bArr != null) {
                return Arrays.copyOf(bArr, bArr.length);
            }
            return null;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return this.a.equals(fVar.a) && AbstractC9683aN7.c(this.c, fVar.c) && AbstractC9683aN7.c(this.e, fVar.e) && this.f == fVar.f && this.h == fVar.h && this.g == fVar.g && this.j.equals(fVar.j) && Arrays.equals(this.k, fVar.k);
        }

        public int hashCode() {
            int iHashCode = this.a.hashCode() * 31;
            Uri uri = this.c;
            return ((((((((((((iHashCode + (uri != null ? uri.hashCode() : 0)) * 31) + this.e.hashCode()) * 31) + (this.f ? 1 : 0)) * 31) + (this.h ? 1 : 0)) * 31) + (this.g ? 1 : 0)) * 31) + this.j.hashCode()) * 31) + Arrays.hashCode(this.k);
        }

        /* renamed from: com.google.android.exoplayer2.a0$f$a */
        public static final class a {
            private UUID a;
            private Uri b;
            private AbstractC13937h43 c;
            private boolean d;
            private boolean e;
            private boolean f;
            private AbstractC12710f43 g;
            private byte[] h;

            public f i() {
                return new f(this);
            }

            private a() {
                this.c = AbstractC13937h43.p();
                this.g = AbstractC12710f43.V();
            }

            private a(f fVar) {
                this.a = fVar.a;
                this.b = fVar.c;
                this.c = fVar.e;
                this.d = fVar.f;
                this.e = fVar.g;
                this.f = fVar.h;
                this.g = fVar.j;
                this.h = fVar.k;
            }
        }

        private f(a aVar) {
            AbstractC20011rK.g((aVar.f && aVar.b == null) ? false : true);
            UUID uuid = (UUID) AbstractC20011rK.e(aVar.a);
            this.a = uuid;
            this.b = uuid;
            this.c = aVar.b;
            this.d = aVar.c;
            this.e = aVar.c;
            this.f = aVar.d;
            this.h = aVar.f;
            this.g = aVar.e;
            this.i = aVar.g;
            this.j = aVar.g;
            this.k = aVar.h != null ? Arrays.copyOf(aVar.h, aVar.h.length) : null;
        }
    }

    /* renamed from: com.google.android.exoplayer2.a0$g */
    public static final class g implements InterfaceC2029g {
        public static final g f = new a().f();
        private static final String g = AbstractC9683aN7.r0(0);
        private static final String h = AbstractC9683aN7.r0(1);
        private static final String i = AbstractC9683aN7.r0(2);
        private static final String j = AbstractC9683aN7.r0(3);
        private static final String k = AbstractC9683aN7.r0(4);
        public static final InterfaceC2029g.a l = new InterfaceC2029g.a() { // from class: ir.nasim.wX3
            @Override // com.google.android.exoplayer2.InterfaceC2029g.a
            public final InterfaceC2029g a(Bundle bundle) {
                return C2018a0.g.d(bundle);
            }
        };
        public final long a;
        public final long b;
        public final long c;
        public final float d;
        public final float e;

        /* renamed from: com.google.android.exoplayer2.a0$g$a */
        public static final class a {
            private long a;
            private long b;
            private long c;
            private float d;
            private float e;

            public g f() {
                return new g(this);
            }

            public a g(long j) {
                this.c = j;
                return this;
            }

            public a h(float f) {
                this.e = f;
                return this;
            }

            public a i(long j) {
                this.b = j;
                return this;
            }

            public a j(float f) {
                this.d = f;
                return this;
            }

            public a k(long j) {
                this.a = j;
                return this;
            }

            public a() {
                this.a = -9223372036854775807L;
                this.b = -9223372036854775807L;
                this.c = -9223372036854775807L;
                this.d = -3.4028235E38f;
                this.e = -3.4028235E38f;
            }

            private a(g gVar) {
                this.a = gVar.a;
                this.b = gVar.b;
                this.c = gVar.c;
                this.d = gVar.d;
                this.e = gVar.e;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ g d(Bundle bundle) {
            String str = g;
            g gVar = f;
            return new g(bundle.getLong(str, gVar.a), bundle.getLong(h, gVar.b), bundle.getLong(i, gVar.c), bundle.getFloat(j, gVar.d), bundle.getFloat(k, gVar.e));
        }

        @Override // com.google.android.exoplayer2.InterfaceC2029g
        public Bundle a() {
            Bundle bundle = new Bundle();
            long j2 = this.a;
            g gVar = f;
            if (j2 != gVar.a) {
                bundle.putLong(g, j2);
            }
            long j3 = this.b;
            if (j3 != gVar.b) {
                bundle.putLong(h, j3);
            }
            long j4 = this.c;
            if (j4 != gVar.c) {
                bundle.putLong(i, j4);
            }
            float f2 = this.d;
            if (f2 != gVar.d) {
                bundle.putFloat(j, f2);
            }
            float f3 = this.e;
            if (f3 != gVar.e) {
                bundle.putFloat(k, f3);
            }
            return bundle;
        }

        public a c() {
            return new a();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return this.a == gVar.a && this.b == gVar.b && this.c == gVar.c && this.d == gVar.d && this.e == gVar.e;
        }

        public int hashCode() {
            long j2 = this.a;
            long j3 = this.b;
            int i2 = ((((int) (j2 ^ (j2 >>> 32))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31;
            long j4 = this.c;
            int i3 = (i2 + ((int) ((j4 >>> 32) ^ j4))) * 31;
            float f2 = this.d;
            int iFloatToIntBits = (i3 + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0)) * 31;
            float f3 = this.e;
            return iFloatToIntBits + (f3 != 0.0f ? Float.floatToIntBits(f3) : 0);
        }

        private g(a aVar) {
            this(aVar.a, aVar.b, aVar.c, aVar.d, aVar.e);
        }

        public g(long j2, long j3, long j4, float f2, float f3) {
            this.a = j2;
            this.b = j3;
            this.c = j4;
            this.d = f2;
            this.e = f3;
        }
    }

    /* renamed from: com.google.android.exoplayer2.a0$h */
    public static class h {
        public final Uri a;
        public final String b;
        public final f c;
        public final List d;
        public final String e;
        public final AbstractC12710f43 f;
        public final List g;
        public final Object h;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return this.a.equals(hVar.a) && AbstractC9683aN7.c(this.b, hVar.b) && AbstractC9683aN7.c(this.c, hVar.c) && AbstractC9683aN7.c(null, null) && this.d.equals(hVar.d) && AbstractC9683aN7.c(this.e, hVar.e) && this.f.equals(hVar.f) && AbstractC9683aN7.c(this.h, hVar.h);
        }

        public int hashCode() {
            int iHashCode = this.a.hashCode() * 31;
            String str = this.b;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            f fVar = this.c;
            int iHashCode3 = (((iHashCode2 + (fVar == null ? 0 : fVar.hashCode())) * 961) + this.d.hashCode()) * 31;
            String str2 = this.e;
            int iHashCode4 = (((iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.f.hashCode()) * 31;
            Object obj = this.h;
            return iHashCode4 + (obj != null ? obj.hashCode() : 0);
        }

        private h(Uri uri, String str, f fVar, b bVar, List list, String str2, AbstractC12710f43 abstractC12710f43, Object obj) {
            this.a = uri;
            this.b = str;
            this.c = fVar;
            this.d = list;
            this.e = str2;
            this.f = abstractC12710f43;
            AbstractC12710f43.a aVarL = AbstractC12710f43.L();
            for (int i = 0; i < abstractC12710f43.size(); i++) {
                aVarL.a(((l) abstractC12710f43.get(i)).a().i());
            }
            this.g = aVarL.h();
            this.h = obj;
        }
    }

    /* renamed from: com.google.android.exoplayer2.a0$i */
    public static final class i extends h {
        private i(Uri uri, String str, f fVar, b bVar, List list, String str2, AbstractC12710f43 abstractC12710f43, Object obj) {
            super(uri, str, fVar, bVar, list, str2, abstractC12710f43, obj);
        }
    }

    /* renamed from: com.google.android.exoplayer2.a0$j */
    public static final class j implements InterfaceC2029g {
        public static final j d = new a().d();
        private static final String e = AbstractC9683aN7.r0(0);
        private static final String f = AbstractC9683aN7.r0(1);
        private static final String g = AbstractC9683aN7.r0(2);
        public static final InterfaceC2029g.a h = new InterfaceC2029g.a() { // from class: ir.nasim.xX3
            @Override // com.google.android.exoplayer2.InterfaceC2029g.a
            public final InterfaceC2029g a(Bundle bundle) {
                return C2018a0.j.c(bundle);
            }
        };
        public final Uri a;
        public final String b;
        public final Bundle c;

        /* renamed from: com.google.android.exoplayer2.a0$j$a */
        public static final class a {
            private Uri a;
            private String b;
            private Bundle c;

            public j d() {
                return new j(this);
            }

            public a e(Bundle bundle) {
                this.c = bundle;
                return this;
            }

            public a f(Uri uri) {
                this.a = uri;
                return this;
            }

            public a g(String str) {
                this.b = str;
                return this;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ j c(Bundle bundle) {
            return new a().f((Uri) bundle.getParcelable(e)).g(bundle.getString(f)).e(bundle.getBundle(g)).d();
        }

        @Override // com.google.android.exoplayer2.InterfaceC2029g
        public Bundle a() {
            Bundle bundle = new Bundle();
            Uri uri = this.a;
            if (uri != null) {
                bundle.putParcelable(e, uri);
            }
            String str = this.b;
            if (str != null) {
                bundle.putString(f, str);
            }
            Bundle bundle2 = this.c;
            if (bundle2 != null) {
                bundle.putBundle(g, bundle2);
            }
            return bundle;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            return AbstractC9683aN7.c(this.a, jVar.a) && AbstractC9683aN7.c(this.b, jVar.b);
        }

        public int hashCode() {
            Uri uri = this.a;
            int iHashCode = (uri == null ? 0 : uri.hashCode()) * 31;
            String str = this.b;
            return iHashCode + (str != null ? str.hashCode() : 0);
        }

        private j(a aVar) {
            this.a = aVar.a;
            this.b = aVar.b;
            this.c = aVar.c;
        }
    }

    /* renamed from: com.google.android.exoplayer2.a0$k */
    public static final class k extends l {
        private k(l.a aVar) {
            super(aVar);
        }
    }

    /* renamed from: com.google.android.exoplayer2.a0$l */
    public static class l {
        public final Uri a;
        public final String b;
        public final String c;
        public final int d;
        public final int e;
        public final String f;
        public final String g;

        /* renamed from: com.google.android.exoplayer2.a0$l$a */
        public static final class a {
            private Uri a;
            private String b;
            private String c;
            private int d;
            private int e;
            private String f;
            private String g;

            /* JADX INFO: Access modifiers changed from: private */
            public k i() {
                return new k(this);
            }

            private a(l lVar) {
                this.a = lVar.a;
                this.b = lVar.b;
                this.c = lVar.c;
                this.d = lVar.d;
                this.e = lVar.e;
                this.f = lVar.f;
                this.g = lVar.g;
            }
        }

        public a a() {
            return new a();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof l)) {
                return false;
            }
            l lVar = (l) obj;
            return this.a.equals(lVar.a) && AbstractC9683aN7.c(this.b, lVar.b) && AbstractC9683aN7.c(this.c, lVar.c) && this.d == lVar.d && this.e == lVar.e && AbstractC9683aN7.c(this.f, lVar.f) && AbstractC9683aN7.c(this.g, lVar.g);
        }

        public int hashCode() {
            int iHashCode = this.a.hashCode() * 31;
            String str = this.b;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.c;
            int iHashCode3 = (((((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.d) * 31) + this.e) * 31;
            String str3 = this.f;
            int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.g;
            return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
        }

        private l(a aVar) {
            this.a = aVar.a;
            this.b = aVar.b;
            this.c = aVar.c;
            this.d = aVar.d;
            this.e = aVar.e;
            this.f = aVar.f;
            this.g = aVar.g;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static C2018a0 d(Bundle bundle) {
        String str = (String) AbstractC20011rK.e(bundle.getString(j, ""));
        Bundle bundle2 = bundle.getBundle(k);
        g gVar = bundle2 == null ? g.f : (g) g.l.a(bundle2);
        Bundle bundle3 = bundle.getBundle(l);
        C2020b0 c2020b0 = bundle3 == null ? C2020b0.z0 : (C2020b0) C2020b0.h1.a(bundle3);
        Bundle bundle4 = bundle.getBundle(m);
        e eVar = bundle4 == null ? e.m : (e) d.l.a(bundle4);
        Bundle bundle5 = bundle.getBundle(n);
        return new C2018a0(str, eVar, null, gVar, c2020b0, bundle5 == null ? j.d : (j) j.h.a(bundle5));
    }

    public static C2018a0 e(Uri uri) {
        return new c().j(uri).a();
    }

    public static C2018a0 f(String str) {
        return new c().k(str).a();
    }

    @Override // com.google.android.exoplayer2.InterfaceC2029g
    public Bundle a() {
        Bundle bundle = new Bundle();
        if (!this.a.equals("")) {
            bundle.putString(j, this.a);
        }
        if (!this.d.equals(g.f)) {
            bundle.putBundle(k, this.d.a());
        }
        if (!this.e.equals(C2020b0.z0)) {
            bundle.putBundle(l, this.e.a());
        }
        if (!this.f.equals(d.f)) {
            bundle.putBundle(m, this.f.a());
        }
        if (!this.h.equals(j.d)) {
            bundle.putBundle(n, this.h.a());
        }
        return bundle;
    }

    public c c() {
        return new c();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2018a0)) {
            return false;
        }
        C2018a0 c2018a0 = (C2018a0) obj;
        return AbstractC9683aN7.c(this.a, c2018a0.a) && this.f.equals(c2018a0.f) && AbstractC9683aN7.c(this.b, c2018a0.b) && AbstractC9683aN7.c(this.d, c2018a0.d) && AbstractC9683aN7.c(this.e, c2018a0.e) && AbstractC9683aN7.c(this.h, c2018a0.h);
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        h hVar = this.b;
        return ((((((((iHashCode + (hVar != null ? hVar.hashCode() : 0)) * 31) + this.d.hashCode()) * 31) + this.f.hashCode()) * 31) + this.e.hashCode()) * 31) + this.h.hashCode();
    }

    private C2018a0(String str, e eVar, i iVar, g gVar, C2020b0 c2020b0, j jVar) {
        this.a = str;
        this.b = iVar;
        this.c = iVar;
        this.d = gVar;
        this.e = c2020b0;
        this.f = eVar;
        this.g = eVar;
        this.h = jVar;
    }
}
