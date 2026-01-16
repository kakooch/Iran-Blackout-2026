package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.oN5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC18271oN5 {

    /* renamed from: ir.nasim.oN5$a */
    public static final class a extends AbstractC18271oN5 {
        private final String a;
        private final String b;
        private final Long c;
        private final String d;
        private final String e;
        private final Double f;
        private final Double g;
        private final Long h;
        private final Double i;
        private final double j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, Long l, String str3, String str4, Double d, Double d2, Long l2, Double d3, double d4) {
            super(null);
            AbstractC13042fc3.i(str, "id");
            AbstractC13042fc3.i(str2, "kind");
            this.a = str;
            this.b = str2;
            this.c = l;
            this.d = str3;
            this.e = str4;
            this.f = d;
            this.g = d2;
            this.h = l2;
            this.i = d3;
            this.j = d4;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return AbstractC13042fc3.d(this.a, aVar.a) && AbstractC13042fc3.d(this.b, aVar.b) && AbstractC13042fc3.d(this.c, aVar.c) && AbstractC13042fc3.d(this.d, aVar.d) && AbstractC13042fc3.d(this.e, aVar.e) && AbstractC13042fc3.d(this.f, aVar.f) && AbstractC13042fc3.d(this.g, aVar.g) && AbstractC13042fc3.d(this.h, aVar.h) && AbstractC13042fc3.d(this.i, aVar.i) && Double.compare(this.j, aVar.j) == 0;
        }

        public int hashCode() {
            int iHashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            Long l = this.c;
            int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
            String str = this.d;
            int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.e;
            int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
            Double d = this.f;
            int iHashCode5 = (iHashCode4 + (d == null ? 0 : d.hashCode())) * 31;
            Double d2 = this.g;
            int iHashCode6 = (iHashCode5 + (d2 == null ? 0 : d2.hashCode())) * 31;
            Long l2 = this.h;
            int iHashCode7 = (iHashCode6 + (l2 == null ? 0 : l2.hashCode())) * 31;
            Double d3 = this.i;
            return ((iHashCode7 + (d3 != null ? d3.hashCode() : 0)) * 31) + Double.hashCode(this.j);
        }

        public String toString() {
            return "Audio(id=" + this.a + ", kind=" + this.b + ", ssrc=" + this.c + ", transportId=" + this.d + ", codecId=" + this.e + ", jitter=" + this.f + ", roundTripTime=" + this.g + ", packetsLost=" + this.h + ", fractionLost=" + this.i + ", timestamp=" + this.j + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.oN5$b */
    public static final class b extends AbstractC18271oN5 {
        private final String a;
        private final String b;
        private final Long c;
        private final String d;
        private final String e;
        private final Double f;
        private final Double g;
        private final Long h;
        private final Double i;
        private final double j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, String str2, Long l, String str3, String str4, Double d, Double d2, Long l2, Double d3, double d4) {
            super(null);
            AbstractC13042fc3.i(str, "id");
            AbstractC13042fc3.i(str2, "kind");
            this.a = str;
            this.b = str2;
            this.c = l;
            this.d = str3;
            this.e = str4;
            this.f = d;
            this.g = d2;
            this.h = l2;
            this.i = d3;
            this.j = d4;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return AbstractC13042fc3.d(this.a, bVar.a) && AbstractC13042fc3.d(this.b, bVar.b) && AbstractC13042fc3.d(this.c, bVar.c) && AbstractC13042fc3.d(this.d, bVar.d) && AbstractC13042fc3.d(this.e, bVar.e) && AbstractC13042fc3.d(this.f, bVar.f) && AbstractC13042fc3.d(this.g, bVar.g) && AbstractC13042fc3.d(this.h, bVar.h) && AbstractC13042fc3.d(this.i, bVar.i) && Double.compare(this.j, bVar.j) == 0;
        }

        public int hashCode() {
            int iHashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            Long l = this.c;
            int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
            String str = this.d;
            int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.e;
            int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
            Double d = this.f;
            int iHashCode5 = (iHashCode4 + (d == null ? 0 : d.hashCode())) * 31;
            Double d2 = this.g;
            int iHashCode6 = (iHashCode5 + (d2 == null ? 0 : d2.hashCode())) * 31;
            Long l2 = this.h;
            int iHashCode7 = (iHashCode6 + (l2 == null ? 0 : l2.hashCode())) * 31;
            Double d3 = this.i;
            return ((iHashCode7 + (d3 != null ? d3.hashCode() : 0)) * 31) + Double.hashCode(this.j);
        }

        public String toString() {
            return "Video(id=" + this.a + ", kind=" + this.b + ", ssrc=" + this.c + ", transportId=" + this.d + ", codecId=" + this.e + ", jitter=" + this.f + ", roundTripTime=" + this.g + ", packetsLost=" + this.h + ", fractionLost=" + this.i + ", timestamp=" + this.j + Separators.RPAREN;
        }
    }

    private AbstractC18271oN5() {
    }

    public /* synthetic */ AbstractC18271oN5(ED1 ed1) {
        this();
    }
}
