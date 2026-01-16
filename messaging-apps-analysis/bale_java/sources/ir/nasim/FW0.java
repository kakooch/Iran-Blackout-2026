package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public abstract class FW0 {

    public static final class a extends FW0 {
        private final String a;
        private final String b;
        private final Integer c;
        private final Integer d;
        private final Integer e;
        private final String f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, Integer num, Integer num2, Integer num3, String str3) {
            super(null);
            AbstractC13042fc3.i(str, "id");
            this.a = str;
            this.b = str2;
            this.c = num;
            this.d = num2;
            this.e = num3;
            this.f = str3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return AbstractC13042fc3.d(this.a, aVar.a) && AbstractC13042fc3.d(this.b, aVar.b) && AbstractC13042fc3.d(this.c, aVar.c) && AbstractC13042fc3.d(this.d, aVar.d) && AbstractC13042fc3.d(this.e, aVar.e) && AbstractC13042fc3.d(this.f, aVar.f);
        }

        public int hashCode() {
            int iHashCode = this.a.hashCode() * 31;
            String str = this.b;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            Integer num = this.c;
            int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.d;
            int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.e;
            int iHashCode5 = (iHashCode4 + (num3 == null ? 0 : num3.hashCode())) * 31;
            String str2 = this.f;
            return iHashCode5 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "Audio(id=" + this.a + ", mimeType=" + this.b + ", payloadType=" + this.c + ", clockRate=" + this.d + ", channels=" + this.e + ", sdpFmtpLine=" + this.f + Separators.RPAREN;
        }
    }

    public static final class b extends FW0 {
        private final String a;
        private final String b;
        private final Integer c;
        private final Integer d;
        private final String e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, String str2, Integer num, Integer num2, String str3) {
            super(null);
            AbstractC13042fc3.i(str, "id");
            this.a = str;
            this.b = str2;
            this.c = num;
            this.d = num2;
            this.e = str3;
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
            String str2 = this.e;
            return iHashCode4 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "Video(id=" + this.a + ", mimeType=" + this.b + ", payloadType=" + this.c + ", clockRate=" + this.d + ", sdpFmtpLine=" + this.e + Separators.RPAREN;
        }
    }

    private FW0() {
    }

    public /* synthetic */ FW0(ED1 ed1) {
        this();
    }
}
