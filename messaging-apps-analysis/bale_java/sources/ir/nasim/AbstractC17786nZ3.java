package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.nZ3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC17786nZ3 {

    /* renamed from: ir.nasim.nZ3$a */
    public static final class a extends AbstractC17786nZ3 {
        private final String a;
        private final String b;
        private final Double c;
        private final Double d;
        private final Double e;
        private final Double f;
        private final Double g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, Double d, Double d2, Double d3, Double d4, Double d5) {
            super(null);
            AbstractC13042fc3.i(str, "id");
            this.a = str;
            this.b = str2;
            this.c = d;
            this.d = d2;
            this.e = d3;
            this.f = d4;
            this.g = d5;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return AbstractC13042fc3.d(this.a, aVar.a) && AbstractC13042fc3.d(this.b, aVar.b) && AbstractC13042fc3.d(this.c, aVar.c) && AbstractC13042fc3.d(this.d, aVar.d) && AbstractC13042fc3.d(this.e, aVar.e) && AbstractC13042fc3.d(this.f, aVar.f) && AbstractC13042fc3.d(this.g, aVar.g);
        }

        public int hashCode() {
            int iHashCode = this.a.hashCode() * 31;
            String str = this.b;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            Double d = this.c;
            int iHashCode3 = (iHashCode2 + (d == null ? 0 : d.hashCode())) * 31;
            Double d2 = this.d;
            int iHashCode4 = (iHashCode3 + (d2 == null ? 0 : d2.hashCode())) * 31;
            Double d3 = this.e;
            int iHashCode5 = (iHashCode4 + (d3 == null ? 0 : d3.hashCode())) * 31;
            Double d4 = this.f;
            int iHashCode6 = (iHashCode5 + (d4 == null ? 0 : d4.hashCode())) * 31;
            Double d5 = this.g;
            return iHashCode6 + (d5 != null ? d5.hashCode() : 0);
        }

        public String toString() {
            return "Audio(id=" + this.a + ", trackIdentifier=" + this.b + ", audioLevel=" + this.c + ", totalAudioEnergy=" + this.d + ", totalSamplesDuration=" + this.e + ", echoReturnLoss=" + this.f + ", echoReturnLossEnhancement=" + this.g + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.nZ3$b */
    public static final class b extends AbstractC17786nZ3 {
        private final String a;
        private final String b;
        private final Integer c;
        private final Integer d;
        private final Double e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, String str2, Integer num, Integer num2, Double d) {
            super(null);
            AbstractC13042fc3.i(str, "id");
            this.a = str;
            this.b = str2;
            this.c = num;
            this.d = num2;
            this.e = d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return AbstractC13042fc3.d(this.a, bVar.a) && AbstractC13042fc3.d(this.b, bVar.b) && AbstractC13042fc3.d(this.c, bVar.c) && AbstractC13042fc3.d(this.d, bVar.d) && AbstractC13042fc3.d(this.e, bVar.e);
        }

        public int hashCode() {
            int iHashCode = this.a.hashCode() * 31;
            String str = this.b;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            Integer num = this.c;
            int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.d;
            int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Double d = this.e;
            return iHashCode4 + (d != null ? d.hashCode() : 0);
        }

        public String toString() {
            return "Video(id=" + this.a + ", trackIdentifier=" + this.b + ", width=" + this.c + ", height=" + this.d + ", framesPerSecond=" + this.e + Separators.RPAREN;
        }
    }

    private AbstractC17786nZ3() {
    }

    public /* synthetic */ AbstractC17786nZ3(ED1 ed1) {
        this();
    }
}
