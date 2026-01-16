package com.google.android.exoplayer2.upstream.cache;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.upstream.FileDataSource;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import com.google.android.exoplayer2.upstream.l;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import ir.nasim.AbstractC18533op0;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.C15535jk7;
import ir.nasim.C9315Zk1;
import ir.nasim.InterfaceC16169kp0;
import ir.nasim.InterfaceC20422rz1;
import ir.nasim.InterfaceC25209zu7;
import ir.nasim.InterfaceC8806Xk1;
import java.io.File;
import java.io.InterruptedIOException;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes2.dex */
public final class a implements com.google.android.exoplayer2.upstream.a {
    private final Cache a;
    private final com.google.android.exoplayer2.upstream.a b;
    private final com.google.android.exoplayer2.upstream.a c;
    private final com.google.android.exoplayer2.upstream.a d;
    private final InterfaceC16169kp0 e;
    private final boolean f;
    private final boolean g;
    private final boolean h;
    private Uri i;
    private com.google.android.exoplayer2.upstream.b j;
    private com.google.android.exoplayer2.upstream.b k;
    private com.google.android.exoplayer2.upstream.a l;
    private long m;
    private long n;
    private long o;
    private AbstractC18533op0 p;
    private boolean q;
    private boolean r;
    private long s;
    private long t;

    public interface b {
    }

    public static final class c implements a.InterfaceC0163a {
        private Cache a;
        private InterfaceC20422rz1.a c;
        private boolean e;
        private a.InterfaceC0163a f;
        private int g;
        private int h;
        private a.InterfaceC0163a b = new FileDataSource.b();
        private InterfaceC16169kp0 d = InterfaceC16169kp0.a;

        private a d(com.google.android.exoplayer2.upstream.a aVar, int i, int i2) {
            InterfaceC20422rz1 interfaceC20422rz1A;
            Cache cache = (Cache) AbstractC20011rK.e(this.a);
            if (this.e || aVar == null) {
                interfaceC20422rz1A = null;
            } else {
                InterfaceC20422rz1.a aVar2 = this.c;
                interfaceC20422rz1A = aVar2 != null ? aVar2.a() : new CacheDataSink.a().b(cache).a();
            }
            return new a(cache, aVar, this.b.a(), interfaceC20422rz1A, this.d, i, null, i2, null);
        }

        @Override // com.google.android.exoplayer2.upstream.a.InterfaceC0163a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a a() {
            a.InterfaceC0163a interfaceC0163a = this.f;
            return d(interfaceC0163a != null ? interfaceC0163a.a() : null, this.h, this.g);
        }

        public a c() {
            a.InterfaceC0163a interfaceC0163a = this.f;
            return d(interfaceC0163a != null ? interfaceC0163a.a() : null, this.h | 1, -1000);
        }

        public Cache e() {
            return this.a;
        }

        public InterfaceC16169kp0 f() {
            return this.d;
        }

        public PriorityTaskManager g() {
            return null;
        }

        public c h(Cache cache) {
            this.a = cache;
            return this;
        }

        public c i(InterfaceC16169kp0 interfaceC16169kp0) {
            this.d = interfaceC16169kp0;
            return this;
        }

        public c j(int i) {
            this.h = i;
            return this;
        }

        public c k(a.InterfaceC0163a interfaceC0163a) {
            this.f = interfaceC0163a;
            return this;
        }
    }

    private int A(com.google.android.exoplayer2.upstream.b bVar) {
        if (this.g && this.q) {
            return 0;
        }
        return (this.h && bVar.h == -1) ? 1 : -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void n() {
        com.google.android.exoplayer2.upstream.a aVar = this.l;
        if (aVar == null) {
            return;
        }
        try {
            aVar.close();
        } finally {
            this.k = null;
            this.l = null;
            AbstractC18533op0 abstractC18533op0 = this.p;
            if (abstractC18533op0 != null) {
                this.a.h(abstractC18533op0);
                this.p = null;
            }
        }
    }

    private static Uri q(Cache cache, String str, Uri uri) {
        Uri uriB = InterfaceC8806Xk1.b(cache.b(str));
        return uriB != null ? uriB : uri;
    }

    private void r(Throwable th) {
        if (t() || (th instanceof Cache.CacheException)) {
            this.q = true;
        }
    }

    private boolean s() {
        return this.l == this.d;
    }

    private boolean t() {
        return this.l == this.b;
    }

    private boolean u() {
        return !t();
    }

    private boolean v() {
        return this.l == this.c;
    }

    private void w() {
    }

    private void x(int i) {
    }

    private void y(com.google.android.exoplayer2.upstream.b bVar, boolean z) throws InterruptedIOException {
        AbstractC18533op0 abstractC18533op0I;
        long jMin;
        com.google.android.exoplayer2.upstream.b bVarA;
        com.google.android.exoplayer2.upstream.a aVar;
        String str = (String) AbstractC9683aN7.j(bVar.i);
        if (this.r) {
            abstractC18533op0I = null;
        } else if (this.f) {
            try {
                abstractC18533op0I = this.a.i(str, this.n, this.o);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException();
            }
        } else {
            abstractC18533op0I = this.a.d(str, this.n, this.o);
        }
        if (abstractC18533op0I == null) {
            aVar = this.d;
            bVarA = bVar.a().h(this.n).g(this.o).a();
        } else if (abstractC18533op0I.d) {
            Uri uriFromFile = Uri.fromFile((File) AbstractC9683aN7.j(abstractC18533op0I.e));
            long j = abstractC18533op0I.b;
            long j2 = this.n - j;
            long jMin2 = abstractC18533op0I.c - j2;
            long j3 = this.o;
            if (j3 != -1) {
                jMin2 = Math.min(jMin2, j3);
            }
            bVarA = bVar.a().i(uriFromFile).k(j).h(j2).g(jMin2).a();
            aVar = this.b;
        } else {
            if (abstractC18533op0I.i()) {
                jMin = this.o;
            } else {
                jMin = abstractC18533op0I.c;
                long j4 = this.o;
                if (j4 != -1) {
                    jMin = Math.min(jMin, j4);
                }
            }
            bVarA = bVar.a().h(this.n).g(jMin).a();
            aVar = this.c;
            if (aVar == null) {
                aVar = this.d;
                this.a.h(abstractC18533op0I);
                abstractC18533op0I = null;
            }
        }
        this.t = (this.r || aVar != this.d) ? Long.MAX_VALUE : this.n + 102400;
        if (z) {
            AbstractC20011rK.g(s());
            if (aVar == this.d) {
                return;
            }
            try {
                n();
            } finally {
            }
        }
        if (abstractC18533op0I != null && abstractC18533op0I.h()) {
            this.p = abstractC18533op0I;
        }
        this.l = aVar;
        this.k = bVarA;
        this.m = 0L;
        long jB = aVar.b(bVarA);
        C9315Zk1 c9315Zk1 = new C9315Zk1();
        if (bVarA.h == -1 && jB != -1) {
            this.o = jB;
            C9315Zk1.g(c9315Zk1, this.n + jB);
        }
        if (u()) {
            Uri uri = aVar.getUri();
            this.i = uri;
            C9315Zk1.h(c9315Zk1, bVar.a.equals(uri) ^ true ? this.i : null);
        }
        if (v()) {
            this.a.g(str, c9315Zk1);
        }
    }

    private void z(String str) {
        this.o = 0L;
        if (v()) {
            C9315Zk1 c9315Zk1 = new C9315Zk1();
            C9315Zk1.g(c9315Zk1, this.n);
            this.a.g(str, c9315Zk1);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long b(com.google.android.exoplayer2.upstream.b bVar) {
        try {
            String strA = this.e.a(bVar);
            com.google.android.exoplayer2.upstream.b bVarA = bVar.a().f(strA).a();
            this.j = bVarA;
            this.i = q(this.a, strA, bVarA.a);
            this.n = bVar.g;
            int iA = A(bVar);
            boolean z = iA != -1;
            this.r = z;
            if (z) {
                x(iA);
            }
            if (this.r) {
                this.o = -1L;
            } else {
                long jA = InterfaceC8806Xk1.a(this.a.b(strA));
                this.o = jA;
                if (jA != -1) {
                    long j = jA - bVar.g;
                    this.o = j;
                    if (j < 0) {
                        throw new DataSourceException(2008);
                    }
                }
            }
            long jMin = bVar.h;
            if (jMin != -1) {
                long j2 = this.o;
                if (j2 != -1) {
                    jMin = Math.min(j2, jMin);
                }
                this.o = jMin;
            }
            long j3 = this.o;
            if (j3 > 0 || j3 == -1) {
                y(bVarA, false);
            }
            long j4 = bVar.h;
            return j4 != -1 ? j4 : this.o;
        } catch (Throwable th) {
            r(th);
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() {
        this.j = null;
        this.i = null;
        this.n = 0L;
        w();
        try {
            n();
        } catch (Throwable th) {
            r(th);
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public Map d() {
        return u() ? this.d.d() : Collections.emptyMap();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public Uri getUri() {
        return this.i;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void i(InterfaceC25209zu7 interfaceC25209zu7) {
        AbstractC20011rK.e(interfaceC25209zu7);
        this.b.i(interfaceC25209zu7);
        this.d.i(interfaceC25209zu7);
    }

    public Cache o() {
        return this.a;
    }

    public InterfaceC16169kp0 p() {
        return this.e;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0083 A[Catch: all -> 0x002e, TryCatch #0 {all -> 0x002e, blocks: (B:9:0x0021, B:11:0x0029, B:14:0x0030, B:16:0x0044, B:18:0x004a, B:19:0x0050, B:21:0x0061, B:22:0x0065, B:24:0x006b, B:26:0x0071, B:28:0x0077, B:29:0x0083, B:35:0x0091), top: B:39:0x0021 }] */
    @Override // ir.nasim.InterfaceC18631oz1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int read(byte[] r16, int r17, int r18) {
        /*
            r15 = this;
            r1 = r15
            r0 = r18
            r2 = 0
            if (r0 != 0) goto L7
            return r2
        L7:
            long r3 = r1.o
            r5 = 0
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            r4 = -1
            if (r3 != 0) goto L11
            return r4
        L11:
            com.google.android.exoplayer2.upstream.b r3 = r1.j
            java.lang.Object r3 = ir.nasim.AbstractC20011rK.e(r3)
            com.google.android.exoplayer2.upstream.b r3 = (com.google.android.exoplayer2.upstream.b) r3
            com.google.android.exoplayer2.upstream.b r7 = r1.k
            java.lang.Object r7 = ir.nasim.AbstractC20011rK.e(r7)
            com.google.android.exoplayer2.upstream.b r7 = (com.google.android.exoplayer2.upstream.b) r7
            long r8 = r1.n     // Catch: java.lang.Throwable -> L2e
            long r10 = r1.t     // Catch: java.lang.Throwable -> L2e
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 < 0) goto L30
            r8 = 1
            r15.y(r3, r8)     // Catch: java.lang.Throwable -> L2e
            goto L30
        L2e:
            r0 = move-exception
            goto L9c
        L30:
            com.google.android.exoplayer2.upstream.a r8 = r1.l     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r8 = ir.nasim.AbstractC20011rK.e(r8)     // Catch: java.lang.Throwable -> L2e
            com.google.android.exoplayer2.upstream.a r8 = (com.google.android.exoplayer2.upstream.a) r8     // Catch: java.lang.Throwable -> L2e
            r9 = r16
            r10 = r17
            int r8 = r8.read(r9, r10, r0)     // Catch: java.lang.Throwable -> L2e
            r11 = -1
            if (r8 == r4) goto L65
            boolean r0 = r15.t()     // Catch: java.lang.Throwable -> L2e
            if (r0 == 0) goto L50
            long r2 = r1.s     // Catch: java.lang.Throwable -> L2e
            long r4 = (long) r8     // Catch: java.lang.Throwable -> L2e
            long r2 = r2 + r4
            r1.s = r2     // Catch: java.lang.Throwable -> L2e
        L50:
            long r2 = r1.n     // Catch: java.lang.Throwable -> L2e
            long r4 = (long) r8     // Catch: java.lang.Throwable -> L2e
            long r2 = r2 + r4
            r1.n = r2     // Catch: java.lang.Throwable -> L2e
            long r2 = r1.m     // Catch: java.lang.Throwable -> L2e
            long r2 = r2 + r4
            r1.m = r2     // Catch: java.lang.Throwable -> L2e
            long r2 = r1.o     // Catch: java.lang.Throwable -> L2e
            int r0 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r0 == 0) goto L90
            long r2 = r2 - r4
            r1.o = r2     // Catch: java.lang.Throwable -> L2e
            goto L90
        L65:
            boolean r4 = r15.u()     // Catch: java.lang.Throwable -> L2e
            if (r4 == 0) goto L83
            long r13 = r7.h     // Catch: java.lang.Throwable -> L2e
            int r4 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r4 == 0) goto L77
            long r11 = r1.m     // Catch: java.lang.Throwable -> L2e
            int r4 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r4 >= 0) goto L83
        L77:
            java.lang.String r0 = r3.i     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r0 = ir.nasim.AbstractC9683aN7.j(r0)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L2e
            r15.z(r0)     // Catch: java.lang.Throwable -> L2e
            goto L90
        L83:
            long r11 = r1.o     // Catch: java.lang.Throwable -> L2e
            int r4 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r4 > 0) goto L91
            r4 = -1
            int r4 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r4 != 0) goto L90
            goto L91
        L90:
            return r8
        L91:
            r15.n()     // Catch: java.lang.Throwable -> L2e
            r15.y(r3, r2)     // Catch: java.lang.Throwable -> L2e
            int r0 = r15.read(r16, r17, r18)     // Catch: java.lang.Throwable -> L2e
            return r0
        L9c:
            r15.r(r0)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.cache.a.read(byte[], int, int):int");
    }

    private a(Cache cache, com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.a aVar2, InterfaceC20422rz1 interfaceC20422rz1, InterfaceC16169kp0 interfaceC16169kp0, int i, PriorityTaskManager priorityTaskManager, int i2, b bVar) {
        this.a = cache;
        this.b = aVar2;
        this.e = interfaceC16169kp0 == null ? InterfaceC16169kp0.a : interfaceC16169kp0;
        this.f = (i & 1) != 0;
        this.g = (i & 2) != 0;
        this.h = (i & 4) != 0;
        if (aVar != null) {
            this.d = aVar;
            this.c = interfaceC20422rz1 != null ? new C15535jk7(aVar, interfaceC20422rz1) : null;
        } else {
            this.d = l.a;
            this.c = null;
        }
    }
}
