package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* loaded from: classes5.dex */
public abstract class YI5 {
    private boolean a;

    public static final class a extends YI5 {
        private final long b;
        private final int c;
        private final C21231tK7 d;
        private final int e;
        private final List f;
        private final EnumC19802qy g;
        private final int h;
        private final boolean i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(long j, int i, C21231tK7 c21231tK7, int i2, List list, EnumC19802qy enumC19802qy, int i3, boolean z) {
            super(null);
            AbstractC13042fc3.i(c21231tK7, "sender");
            AbstractC13042fc3.i(list, "receivers");
            AbstractC13042fc3.i(enumC19802qy, "givingType");
            this.b = j;
            this.c = i;
            this.d = c21231tK7;
            this.e = i2;
            this.f = list;
            this.g = enumC19802qy;
            this.h = i3;
            this.i = z;
        }

        public final int c() {
            return this.c;
        }

        public final int d() {
            return this.e;
        }

        public final List e() {
            return this.f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.b == aVar.b && this.c == aVar.c && AbstractC13042fc3.d(this.d, aVar.d) && this.e == aVar.e && AbstractC13042fc3.d(this.f, aVar.f) && this.g == aVar.g && this.h == aVar.h && this.i == aVar.i;
        }

        public final int f() {
            return this.h;
        }

        public final boolean g() {
            return this.i;
        }

        public int hashCode() {
            return (((((((((((((Long.hashCode(this.b) * 31) + Integer.hashCode(this.c)) * 31) + this.d.hashCode()) * 31) + Integer.hashCode(this.e)) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + Integer.hashCode(this.h)) * 31) + Boolean.hashCode(this.i);
        }

        public String toString() {
            return "Group(date=" + this.b + ", allCount=" + this.c + ", sender=" + this.d + ", openedCount=" + this.e + ", receivers=" + this.f + ", givingType=" + this.g + ", yourGiftAmount=" + this.h + ", isFirst=" + this.i + Separators.RPAREN;
        }
    }

    public static final class b extends YI5 {
        private final long b;
        private final boolean c;
        private final C21231tK7 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(long j, boolean z, C21231tK7 c21231tK7) {
            super(null);
            AbstractC13042fc3.i(c21231tK7, "sender");
            this.b = j;
            this.c = z;
            this.d = c21231tK7;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.b == bVar.b && this.c == bVar.c && AbstractC13042fc3.d(this.d, bVar.d);
        }

        public int hashCode() {
            return (((Long.hashCode(this.b) * 31) + Boolean.hashCode(this.c)) * 31) + this.d.hashCode();
        }

        public String toString() {
            return "Private(date=" + this.b + ", isOpened=" + this.c + ", sender=" + this.d + Separators.RPAREN;
        }
    }

    private YI5() {
    }

    public final boolean a() {
        return this.a;
    }

    public final void b(boolean z) {
        this.a = z;
    }

    public /* synthetic */ YI5(ED1 ed1) {
        this();
    }
}
