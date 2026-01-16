package ir.nasim;

import android.content.Context;
import android.os.Handler;
import ir.nasim.C23992xr4;
import ir.nasim.InterfaceC10699c30;
import java.util.HashMap;
import java.util.Map;

/* renamed from: ir.nasim.xD1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C23612xD1 implements InterfaceC10699c30, InterfaceC25209zu7 {
    public static final AbstractC12710f43 p = AbstractC12710f43.Z(4400000L, 3200000L, 2300000L, 1600000L, 810000L);
    public static final AbstractC12710f43 q = AbstractC12710f43.Z(1400000L, 990000L, 730000L, 510000L, 230000L);
    public static final AbstractC12710f43 r = AbstractC12710f43.Z(2100000L, 1400000L, 1000000L, 890000L, 640000L);
    public static final AbstractC12710f43 s = AbstractC12710f43.Z(2600000L, 1700000L, 1300000L, 1000000L, 700000L);
    public static final AbstractC12710f43 t = AbstractC12710f43.Z(5700000L, 3700000L, 2300000L, 1700000L, 990000L);
    public static final AbstractC12710f43 u = AbstractC12710f43.Z(2800000L, 1800000L, 1400000L, 1100000L, 870000L);
    private static C23612xD1 v;
    private final AbstractC13937h43 a;
    private final InterfaceC10699c30.a.C0927a b;
    private final C19964rE6 c;
    private final NV0 d;
    private final boolean e;
    private int f;
    private long g;
    private long h;
    private int i;
    private long j;
    private long k;
    private long l;
    private long m;
    private boolean n;
    private int o;

    /* renamed from: ir.nasim.xD1$b */
    public static final class b {
        private final Context a;
        private Map b;
        private int c;
        private NV0 d;
        private boolean e;

        public b(Context context) {
            this.a = context == null ? null : context.getApplicationContext();
            this.b = b(AbstractC9683aN7.K(context));
            this.c = 2000;
            this.d = NV0.a;
            this.e = true;
        }

        private static Map b(String str) {
            int[] iArrL = C23612xD1.l(str);
            HashMap map = new HashMap(8);
            map.put(0, 1000000L);
            AbstractC12710f43 abstractC12710f43 = C23612xD1.p;
            map.put(2, (Long) abstractC12710f43.get(iArrL[0]));
            map.put(3, (Long) C23612xD1.q.get(iArrL[1]));
            map.put(4, (Long) C23612xD1.r.get(iArrL[2]));
            map.put(5, (Long) C23612xD1.s.get(iArrL[3]));
            map.put(10, (Long) C23612xD1.t.get(iArrL[4]));
            map.put(9, (Long) C23612xD1.u.get(iArrL[5]));
            map.put(7, (Long) abstractC12710f43.get(iArrL[0]));
            return map;
        }

        public C23612xD1 a() {
            return new C23612xD1(this.a, this.b, this.c, this.d, this.e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int[] l(java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 8436
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C23612xD1.l(java.lang.String):int[]");
    }

    private long m(int i) {
        Long l = (Long) this.a.get(Integer.valueOf(i));
        if (l == null) {
            l = (Long) this.a.get(0);
        }
        if (l == null) {
            l = 1000000L;
        }
        return l.longValue();
    }

    public static synchronized C23612xD1 n(Context context) {
        try {
            if (v == null) {
                v = new b(context).a();
            }
        } catch (Throwable th) {
            throw th;
        }
        return v;
    }

    private static boolean o(com.google.android.exoplayer2.upstream.b bVar, boolean z) {
        return z && !bVar.d(8);
    }

    private void p(int i, long j, long j2) {
        if (i == 0 && j == 0 && j2 == this.m) {
            return;
        }
        this.m = j2;
        this.b.c(i, j, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void q(int i) {
        int i2 = this.i;
        if (i2 == 0 || this.e) {
            if (this.n) {
                i = this.o;
            }
            if (i2 == i) {
                return;
            }
            this.i = i;
            if (i != 1 && i != 0 && i != 8) {
                this.l = m(i);
                long jElapsedRealtime = this.d.elapsedRealtime();
                p(this.f > 0 ? (int) (jElapsedRealtime - this.g) : 0, this.h, this.l);
                this.g = jElapsedRealtime;
                this.h = 0L;
                this.k = 0L;
                this.j = 0L;
                this.c.i();
            }
        }
    }

    @Override // ir.nasim.InterfaceC25209zu7
    public synchronized void b(com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.b bVar, boolean z) {
        try {
            if (o(bVar, z)) {
                AbstractC20011rK.g(this.f > 0);
                long jElapsedRealtime = this.d.elapsedRealtime();
                int i = (int) (jElapsedRealtime - this.g);
                this.j += i;
                long j = this.k;
                long j2 = this.h;
                this.k = j + j2;
                if (i > 0) {
                    this.c.c((int) Math.sqrt(j2), (j2 * 8000.0f) / i);
                    if (this.j >= 2000 || this.k >= 524288) {
                        this.l = (long) this.c.f(0.5f);
                    }
                    p(i, this.h, this.l);
                    this.g = jElapsedRealtime;
                    this.h = 0L;
                }
                this.f--;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // ir.nasim.InterfaceC10699c30
    public void c(InterfaceC10699c30.a aVar) {
        this.b.e(aVar);
    }

    @Override // ir.nasim.InterfaceC10699c30
    public synchronized long e() {
        return this.l;
    }

    @Override // ir.nasim.InterfaceC10699c30
    public void f(Handler handler, InterfaceC10699c30.a aVar) {
        AbstractC20011rK.e(handler);
        AbstractC20011rK.e(aVar);
        this.b.b(handler, aVar);
    }

    @Override // ir.nasim.InterfaceC25209zu7
    public synchronized void g(com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.b bVar, boolean z, int i) {
        if (o(bVar, z)) {
            this.h += i;
        }
    }

    @Override // ir.nasim.InterfaceC25209zu7
    public synchronized void h(com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.b bVar, boolean z) {
        try {
            if (o(bVar, z)) {
                if (this.f == 0) {
                    this.g = this.d.elapsedRealtime();
                }
                this.f++;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private C23612xD1(Context context, Map map, int i, NV0 nv0, boolean z) {
        this.a = AbstractC13937h43.e(map);
        this.b = new InterfaceC10699c30.a.C0927a();
        this.c = new C19964rE6(i);
        this.d = nv0;
        this.e = z;
        if (context == null) {
            this.i = 0;
            this.l = m(0);
            return;
        }
        C23992xr4 c23992xr4D = C23992xr4.d(context);
        int iF = c23992xr4D.f();
        this.i = iF;
        this.l = m(iF);
        c23992xr4D.i(new C23992xr4.c() { // from class: ir.nasim.wD1
            @Override // ir.nasim.C23992xr4.c
            public final void a(int i2) {
                this.a.q(i2);
            }
        });
    }

    @Override // ir.nasim.InterfaceC10699c30
    public InterfaceC25209zu7 d() {
        return this;
    }

    @Override // ir.nasim.InterfaceC25209zu7
    public void i(com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.b bVar, boolean z) {
    }
}
