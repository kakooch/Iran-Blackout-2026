package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.nJ4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC17643nJ4 {
    private final long a;

    /* renamed from: ir.nasim.nJ4$a */
    public static final class a extends AbstractC17643nJ4 {
        private final long b;
        private final int c;
        private final int d;
        private final long e;

        public a(long j, int i, int i2, long j2) {
            super(j, null);
            this.b = j;
            this.c = i;
            this.d = i2;
            this.e = j2;
        }

        @Override // ir.nasim.AbstractC17643nJ4
        public long a() {
            return this.b;
        }

        public final int b() {
            return this.d;
        }

        public final int c() {
            return this.c;
        }

        public final long d() {
            return this.e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.b == aVar.b && this.c == aVar.c && this.d == aVar.d && this.e == aVar.e;
        }

        public int hashCode() {
            return (((((Long.hashCode(this.b) * 31) + Integer.hashCode(this.c)) * 31) + Integer.hashCode(this.d)) * 31) + Long.hashCode(this.e);
        }

        public String toString() {
            return "GroupCall(callId=" + this.b + ", peerId=" + this.c + ", initiatorUserId=" + this.d + ", startDate=" + this.e + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.nJ4$b */
    public static final class b extends c {
        private final long d;
        private final List e;
        private final int f;
        private final String g;
        private final String h;
        private final Long i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(long j, List list, int i, String str, String str2, Long l) {
            super(j, list);
            AbstractC13042fc3.i(list, "membersIds");
            AbstractC13042fc3.i(str, "callLink");
            this.d = j;
            this.e = list;
            this.f = i;
            this.g = str;
            this.h = str2;
            this.i = l;
        }

        @Override // ir.nasim.AbstractC17643nJ4.c, ir.nasim.AbstractC17643nJ4
        public long a() {
            return this.d;
        }

        @Override // ir.nasim.AbstractC17643nJ4.c
        public List b() {
            return this.e;
        }

        public final String c() {
            return this.g;
        }

        public final Long d() {
            return this.i;
        }

        public final String e() {
            return this.h;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.d == bVar.d && AbstractC13042fc3.d(this.e, bVar.e) && this.f == bVar.f && AbstractC13042fc3.d(this.g, bVar.g) && AbstractC13042fc3.d(this.h, bVar.h) && AbstractC13042fc3.d(this.i, bVar.i);
        }

        public final int f() {
            return this.f;
        }

        public int hashCode() {
            int iHashCode = ((((((Long.hashCode(this.d) * 31) + this.e.hashCode()) * 31) + Integer.hashCode(this.f)) * 31) + this.g.hashCode()) * 31;
            String str = this.h;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            Long l = this.i;
            return iHashCode2 + (l != null ? l.hashCode() : 0);
        }

        public String toString() {
            return "LinkCall(callId=" + this.d + ", membersIds=" + this.e + ", initiatorUserId=" + this.f + ", callLink=" + this.g + ", callTitle=" + this.h + ", callStartedTime=" + this.i + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.nJ4$c */
    public static class c extends AbstractC17643nJ4 {
        private final long b;
        private final List c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(long j, List list) {
            super(j, null);
            AbstractC13042fc3.i(list, "membersIds");
            this.b = j;
            this.c = list;
        }

        @Override // ir.nasim.AbstractC17643nJ4
        public long a() {
            return this.b;
        }

        public List b() {
            return this.c;
        }
    }

    public /* synthetic */ AbstractC17643nJ4(long j, ED1 ed1) {
        this(j);
    }

    public abstract long a();

    private AbstractC17643nJ4(long j) {
        this.a = j;
    }
}
