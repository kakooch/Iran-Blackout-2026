package ir.nasim;

import ir.nasim.core.modules.profile.entity.ExPeer;

/* renamed from: ir.nasim.d25, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C11458d25 extends AbstractC17902nl0 {
    public static final InterfaceC17311ml0 c = new a();
    private W25 a;
    private int b;

    /* renamed from: ir.nasim.d25$a */
    class a implements InterfaceC17311ml0 {
        a() {
        }

        @Override // ir.nasim.InterfaceC17311ml0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C11458d25 a() {
            return new C11458d25();
        }
    }

    /* renamed from: ir.nasim.d25$b */
    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[W25.values().length];
            a = iArr;
            try {
                iArr[W25.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[W25.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[W25.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static C11458d25 E(int i) {
        return new C11458d25(W25.a, i);
    }

    public static C11458d25 q(byte[] bArr) {
        return (C11458d25) AbstractC16720ll0.b(new C11458d25(), bArr);
    }

    public static C11458d25 r(long j) {
        int i = (int) (j & 4294967295L);
        return ((int) ((j >> 32) & 4294967295L)) != 1 ? new C11458d25(W25.a, i) : new C11458d25(W25.b, i);
    }

    public static long w(int i, W25 w25) {
        return (i & 4294967295L) + (((b.a[w25.ordinal()] != 2 ? 0 : 1) & 4294967295L) << 32);
    }

    public static C11458d25 y(int i) {
        return new C11458d25(W25.b, i);
    }

    public boolean C() {
        return this.a.equals(W25.a);
    }

    public String D() {
        return this.a + "_" + this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C11458d25 c11458d25 = (C11458d25) obj;
        return this.b == c11458d25.b && this.a == c11458d25.a;
    }

    public int getPeerId() {
        return this.b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = c19084pl0.g(1);
        int iG = c19084pl0.g(2);
        if (iG == 3) {
            this.a = W25.b;
        } else if (iG != 4) {
            this.a = W25.a;
        } else {
            this.a = W25.c;
        }
    }

    public W25 s() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.f(1, this.b);
        int i = b.a[this.a.ordinal()];
        if (i == 2) {
            c19675ql0.f(2, 3);
        } else if (i != 3) {
            c19675ql0.f(2, 1);
        } else {
            c19675ql0.f(2, 4);
        }
    }

    public String toString() {
        return "{type:" + this.a + ", id:" + this.b + "}";
    }

    public long u() {
        return (this.b & 4294967295L) + ((4294967295L & (b.a[this.a.ordinal()] != 2 ? 0 : 1)) << 32);
    }

    public boolean z() {
        return this.a.equals(W25.b);
    }

    public C11458d25(W25 w25, int i) {
        this.a = w25;
        this.b = i;
    }

    public C11458d25(ExPeer exPeer) {
        this(exPeer.getExPeerType().getPeerType(), exPeer.getPeerId());
    }

    private C11458d25() {
    }
}
