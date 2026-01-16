package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.yL1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC24274yL1 {

    /* renamed from: ir.nasim.yL1$a */
    public static final class a extends AbstractC24274yL1 {
        public static final a a = new a();

        private a() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public int hashCode() {
            return -1553902718;
        }

        public String toString() {
            return "Empty";
        }
    }

    /* renamed from: ir.nasim.yL1$b */
    public static abstract class b extends AbstractC24274yL1 {

        /* renamed from: ir.nasim.yL1$b$a */
        public static final class a extends b {
            private final C23564x80 a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(C23564x80 c23564x80) {
                super(null);
                AbstractC13042fc3.i(c23564x80, "bannerAd");
                this.a = c23564x80;
            }

            public final C23564x80 a() {
                return this.a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof a) && AbstractC13042fc3.d(this.a, ((a) obj).a);
            }

            public int hashCode() {
                return this.a.hashCode();
            }

            public String toString() {
                return "Banner(bannerAd=" + this.a + Separators.RPAREN;
            }
        }

        /* renamed from: ir.nasim.yL1$b$b, reason: collision with other inner class name */
        public static final class C1786b extends b {
            private final C17103mP1 a;
            private final int b;
            private final long c;
            private final int d;
            private final boolean e;

            public /* synthetic */ C1786b(C17103mP1 c17103mP1, int i, long j, int i2, boolean z, int i3, ED1 ed1) {
                this(c17103mP1, i, j, i2, (i3 & 16) != 0 ? false : z);
            }

            public static /* synthetic */ C1786b b(C1786b c1786b, C17103mP1 c17103mP1, int i, long j, int i2, boolean z, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    c17103mP1 = c1786b.a;
                }
                if ((i3 & 2) != 0) {
                    i = c1786b.b;
                }
                int i4 = i;
                if ((i3 & 4) != 0) {
                    j = c1786b.c;
                }
                long j2 = j;
                if ((i3 & 8) != 0) {
                    i2 = c1786b.d;
                }
                int i5 = i2;
                if ((i3 & 16) != 0) {
                    z = c1786b.e;
                }
                return c1786b.a(c17103mP1, i4, j2, i5, z);
            }

            public final C1786b a(C17103mP1 c17103mP1, int i, long j, int i2, boolean z) {
                AbstractC13042fc3.i(c17103mP1, "currentAd");
                return new C1786b(c17103mP1, i, j, i2, z);
            }

            public final C17103mP1 c() {
                return this.a;
            }

            public final int d() {
                return this.b;
            }

            public final long e() {
                return this.c;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C1786b)) {
                    return false;
                }
                C1786b c1786b = (C1786b) obj;
                return AbstractC13042fc3.d(this.a, c1786b.a) && this.b == c1786b.b && this.c == c1786b.c && this.d == c1786b.d && this.e == c1786b.e;
            }

            public final int f() {
                return this.d;
            }

            public final boolean g() {
                return this.e;
            }

            public int hashCode() {
                return (((((((this.a.hashCode() * 31) + Integer.hashCode(this.b)) * 31) + Long.hashCode(this.c)) * 31) + Integer.hashCode(this.d)) * 31) + Boolean.hashCode(this.e);
            }

            public String toString() {
                return "Pin(currentAd=" + this.a + ", currentAdClickCount=" + this.b + ", currentAdShowingStartTime=" + this.c + ", nextAdIndex=" + this.d + ", isPendingToCloseDialog=" + this.e + Separators.RPAREN;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C1786b(C17103mP1 c17103mP1, int i, long j, int i2, boolean z) {
                super(null);
                AbstractC13042fc3.i(c17103mP1, "currentAd");
                this.a = c17103mP1;
                this.b = i;
                this.c = j;
                this.d = i2;
                this.e = z;
            }
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }

        private b() {
            super(null);
        }
    }

    private AbstractC24274yL1() {
    }

    public /* synthetic */ AbstractC24274yL1(ED1 ed1) {
        this();
    }
}
