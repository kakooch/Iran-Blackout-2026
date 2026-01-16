package ir.nasim;

import java.util.Objects;

/* loaded from: classes5.dex */
public class PI7 extends AbstractC17902nl0 implements InterfaceC8844Xo3 {
    public static int e = 60000;
    public static InterfaceC17311ml0 f = new InterfaceC17311ml0() { // from class: ir.nasim.OI7
        @Override // ir.nasim.InterfaceC17311ml0
        public final Object a() {
            return PI7.q();
        }
    };
    private C11458d25 a;
    private long b;
    private a c;
    private boolean d;

    public enum a {
        EMPTY(1),
        ONLINE(2),
        OFFLINE(3);

        private int a;

        a(int i) {
            this.a = i;
        }

        public static a j(int i) {
            return values()[i - 1];
        }

        public int p() {
            return this.a;
        }
    }

    private PI7() {
    }

    public static /* synthetic */ PI7 q() {
        return new PI7();
    }

    @Override // ir.nasim.InterfaceC8844Xo3
    public long a() {
        return s().u();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PI7 pi7 = (PI7) obj;
        return this.b == pi7.b && this.d == pi7.d && this.c == pi7.c && Objects.equals(this.a, pi7.a);
    }

    public int hashCode() {
        return Objects.hash(this.c, Long.valueOf(this.b), this.a, Boolean.valueOf(this.d));
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        int iG = c19084pl0.g(1);
        if (iG == 2) {
            this.c = a.ONLINE;
        } else if (iG != 3) {
            this.c = a.EMPTY;
        } else {
            this.c = a.OFFLINE;
        }
        this.b = c19084pl0.i(2);
        this.a = C11458d25.q(c19084pl0.d(3));
        this.d = c19084pl0.u(4);
    }

    public long r() {
        return this.b;
    }

    public C11458d25 s() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.f(1, this.c.p());
        c19675ql0.g(2, this.b);
        c19675ql0.i(3, this.a);
        c19675ql0.a(4, this.d);
    }

    public String toString() {
        return "UserPresence{state=" + this.c + ", lastSeen=" + this.b + ", peer=" + this.a + ", unknown=" + this.d + '}';
    }

    public a u() {
        return AbstractC20507s76.p() - this.b > ((long) e) ? a.OFFLINE : this.c;
    }

    public boolean w() {
        return this.d;
    }

    public PI7(a aVar, long j, C11458d25 c11458d25, boolean z) {
        this.c = aVar;
        this.b = j;
        this.a = c11458d25;
        this.d = z;
    }
}
