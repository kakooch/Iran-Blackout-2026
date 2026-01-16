package ir.nasim;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: ir.nasim.nI3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C17633nI3 {
    public static final a e = new a(null);
    private static final AtomicReferenceFieldUpdater f = AtomicReferenceFieldUpdater.newUpdater(C17633nI3.class, Object.class, "_next");
    private static final AtomicLongFieldUpdater g = AtomicLongFieldUpdater.newUpdater(C17633nI3.class, "_state");
    public static final C14539i47 h = new C14539i47("REMOVE_FROZEN");
    private volatile Object _next;
    private volatile long _state;
    private final int a;
    private final boolean b;
    private final int c;
    private final AtomicReferenceArray d;

    /* renamed from: ir.nasim.nI3$a */
    public static final class a {
        private a() {
        }

        public final int a(long j) {
            return (j & 2305843009213693952L) != 0 ? 2 : 1;
        }

        public final long b(long j, int i) {
            return d(j, 1073741823L) | i;
        }

        public final long c(long j, int i) {
            return d(j, 1152921503533105152L) | (i << 30);
        }

        public final long d(long j, long j2) {
            return j & (~j2);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.nI3$b */
    public static final class b {
        public final int a;

        public b(int i) {
            this.a = i;
        }
    }

    public C17633nI3(int i, boolean z) {
        this.a = i;
        this.b = z;
        int i2 = i - 1;
        this.c = i2;
        this.d = new AtomicReferenceArray(i);
        if (i2 > 1073741823) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if ((i & i2) != 0) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    private final C17633nI3 b(long j) {
        C17633nI3 c17633nI3 = new C17633nI3(this.a * 2, this.b);
        int i = (int) (1073741823 & j);
        int i2 = (int) ((1152921503533105152L & j) >> 30);
        while (true) {
            int i3 = this.c;
            if ((i & i3) == (i2 & i3)) {
                g.set(c17633nI3, e.d(j, 1152921504606846976L));
                return c17633nI3;
            }
            Object bVar = this.d.get(i3 & i);
            if (bVar == null) {
                bVar = new b(i);
            }
            c17633nI3.d.set(c17633nI3.c & i, bVar);
            i++;
        }
    }

    private final C17633nI3 c(long j) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f;
        while (true) {
            C17633nI3 c17633nI3 = (C17633nI3) atomicReferenceFieldUpdater.get(this);
            if (c17633nI3 != null) {
                return c17633nI3;
            }
            F1.a(f, this, null, b(j));
        }
    }

    private final C17633nI3 e(int i, Object obj) {
        Object obj2 = this.d.get(this.c & i);
        if (!(obj2 instanceof b) || ((b) obj2).a != i) {
            return null;
        }
        this.d.set(i & this.c, obj);
        return this;
    }

    private final long h() {
        long j;
        long j2;
        AtomicLongFieldUpdater atomicLongFieldUpdater = g;
        do {
            j = atomicLongFieldUpdater.get(this);
            if ((j & 1152921504606846976L) != 0) {
                return j;
            }
            j2 = j | 1152921504606846976L;
        } while (!atomicLongFieldUpdater.compareAndSet(this, j, j2));
        return j2;
    }

    private final C17633nI3 k(int i, int i2) {
        long j;
        int i3;
        AtomicLongFieldUpdater atomicLongFieldUpdater = g;
        do {
            j = atomicLongFieldUpdater.get(this);
            i3 = (int) (1073741823 & j);
            if ((1152921504606846976L & j) != 0) {
                return i();
            }
        } while (!g.compareAndSet(this, j, e.b(j, i2)));
        this.d.set(this.c & i3, null);
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x004e, code lost:
    
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(java.lang.Object r13) {
        /*
            r12 = this;
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = ir.nasim.C17633nI3.g
        L2:
            long r3 = r0.get(r12)
            r1 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r1 = r1 & r3
            r7 = 0
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r1 == 0) goto L16
            ir.nasim.nI3$a r13 = ir.nasim.C17633nI3.e
            int r13 = r13.a(r3)
            return r13
        L16:
            r1 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r1 = r1 & r3
            int r1 = (int) r1
            r5 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r5 = r5 & r3
            r2 = 30
            long r5 = r5 >> r2
            int r9 = (int) r5
            int r10 = r12.c
            int r2 = r9 + 2
            r2 = r2 & r10
            r5 = r1 & r10
            r6 = 1
            if (r2 != r5) goto L30
            return r6
        L30:
            boolean r2 = r12.b
            r5 = 1073741823(0x3fffffff, float:1.9999999)
            if (r2 != 0) goto L4f
            java.util.concurrent.atomic.AtomicReferenceArray r2 = r12.d
            r11 = r9 & r10
            java.lang.Object r2 = r2.get(r11)
            if (r2 == 0) goto L4f
            int r2 = r12.a
            r3 = 1024(0x400, float:1.435E-42)
            if (r2 < r3) goto L4e
            int r9 = r9 - r1
            r1 = r9 & r5
            int r2 = r2 >> 1
            if (r1 <= r2) goto L2
        L4e:
            return r6
        L4f:
            int r1 = r9 + 1
            r1 = r1 & r5
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = ir.nasim.C17633nI3.g
            ir.nasim.nI3$a r5 = ir.nasim.C17633nI3.e
            long r5 = r5.c(r3, r1)
            r1 = r2
            r2 = r12
            boolean r1 = r1.compareAndSet(r2, r3, r5)
            if (r1 == 0) goto L2
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r12.d
            r1 = r9 & r10
            r0.set(r1, r13)
            r0 = r12
        L6a:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = ir.nasim.C17633nI3.g
            long r1 = r1.get(r0)
            r3 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r1 = r1 & r3
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r1 == 0) goto L81
            ir.nasim.nI3 r0 = r0.i()
            ir.nasim.nI3 r0 = r0.e(r9, r13)
            if (r0 != 0) goto L6a
        L81:
            r13 = 0
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C17633nI3.a(java.lang.Object):int");
    }

    public final boolean d() {
        long j;
        AtomicLongFieldUpdater atomicLongFieldUpdater = g;
        do {
            j = atomicLongFieldUpdater.get(this);
            if ((j & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j) != 0) {
                return false;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j, j | 2305843009213693952L));
        return true;
    }

    public final int f() {
        long j = g.get(this);
        return (((int) ((j & 1152921503533105152L) >> 30)) - ((int) (1073741823 & j))) & 1073741823;
    }

    public final boolean g() {
        long j = g.get(this);
        return ((int) (1073741823 & j)) == ((int) ((j & 1152921503533105152L) >> 30));
    }

    public final C17633nI3 i() {
        return c(h());
    }

    public final Object j() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = g;
        while (true) {
            long j = atomicLongFieldUpdater.get(this);
            if ((1152921504606846976L & j) != 0) {
                return h;
            }
            int i = (int) (1073741823 & j);
            int i2 = this.c;
            if ((((int) ((1152921503533105152L & j) >> 30)) & i2) == (i & i2)) {
                return null;
            }
            Object obj = this.d.get(i2 & i);
            if (obj == null) {
                if (this.b) {
                    return null;
                }
            } else {
                if (obj instanceof b) {
                    return null;
                }
                int i3 = (i + 1) & 1073741823;
                if (g.compareAndSet(this, j, e.b(j, i3))) {
                    this.d.set(this.c & i, null);
                    return obj;
                }
                if (this.b) {
                    C17633nI3 c17633nI3K = this;
                    do {
                        c17633nI3K = c17633nI3K.k(i, i3);
                    } while (c17633nI3K != null);
                    return obj;
                }
            }
        }
    }
}
