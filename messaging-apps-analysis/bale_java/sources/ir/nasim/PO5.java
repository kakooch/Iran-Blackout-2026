package ir.nasim;

import android.gov.nist.core.Separators;
import android.text.Spannable;
import java.util.Arrays;

/* loaded from: classes5.dex */
public abstract class PO5 {

    public static final class a extends PO5 {
        private final Integer a;
        private final Spannable b;
        private final Spannable c;

        public a(Integer num, Spannable spannable, Spannable spannable2) {
            super(null);
            this.a = num;
            this.b = spannable;
            this.c = spannable2;
        }

        @Override // ir.nasim.PO5
        public Spannable a() {
            return this.c;
        }

        @Override // ir.nasim.PO5
        public Integer b() {
            return this.a;
        }

        @Override // ir.nasim.PO5
        public Spannable c() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return AbstractC13042fc3.d(this.a, aVar.a) && AbstractC13042fc3.d(this.b, aVar.b) && AbstractC13042fc3.d(this.c, aVar.c);
        }

        public int hashCode() {
            Integer num = this.a;
            int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
            Spannable spannable = this.b;
            int iHashCode2 = (iHashCode + (spannable == null ? 0 : spannable.hashCode())) * 31;
            Spannable spannable2 = this.c;
            return iHashCode2 + (spannable2 != null ? spannable2.hashCode() : 0);
        }

        public String toString() {
            return "ReplyFile(color=" + this.a + ", userName=" + ((Object) this.b) + ", body=" + ((Object) this.c) + Separators.RPAREN;
        }
    }

    public static final class b extends PO5 {
        private final Integer a;
        private final Spannable b;
        private final Spannable c;
        private final byte[] d;

        public b(Integer num, Spannable spannable, Spannable spannable2, byte[] bArr) {
            super(null);
            this.a = num;
            this.b = spannable;
            this.c = spannable2;
            this.d = bArr;
        }

        @Override // ir.nasim.PO5
        public Spannable a() {
            return this.c;
        }

        @Override // ir.nasim.PO5
        public Integer b() {
            return this.a;
        }

        @Override // ir.nasim.PO5
        public Spannable c() {
            return this.b;
        }

        public final byte[] d() {
            return this.d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return AbstractC13042fc3.d(this.a, bVar.a) && AbstractC13042fc3.d(this.b, bVar.b) && AbstractC13042fc3.d(this.c, bVar.c) && AbstractC13042fc3.d(this.d, bVar.d);
        }

        public int hashCode() {
            Integer num = this.a;
            int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
            Spannable spannable = this.b;
            int iHashCode2 = (iHashCode + (spannable == null ? 0 : spannable.hashCode())) * 31;
            Spannable spannable2 = this.c;
            int iHashCode3 = (iHashCode2 + (spannable2 == null ? 0 : spannable2.hashCode())) * 31;
            byte[] bArr = this.d;
            return iHashCode3 + (bArr != null ? Arrays.hashCode(bArr) : 0);
        }

        public String toString() {
            Integer num = this.a;
            Spannable spannable = this.b;
            Spannable spannable2 = this.c;
            return "ReplyGraphical(color=" + num + ", userName=" + ((Object) spannable) + ", body=" + ((Object) spannable2) + ", thumbnail=" + Arrays.toString(this.d) + Separators.RPAREN;
        }
    }

    public static final class c extends PO5 {
        private final Integer a;
        private final Spannable b;
        private final Spannable c;
        private final String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Integer num, Spannable spannable, Spannable spannable2, String str) {
            super(null);
            AbstractC13042fc3.i(str, "locationUri");
            this.a = num;
            this.b = spannable;
            this.c = spannable2;
            this.d = str;
        }

        @Override // ir.nasim.PO5
        public Spannable a() {
            return this.c;
        }

        @Override // ir.nasim.PO5
        public Integer b() {
            return this.a;
        }

        @Override // ir.nasim.PO5
        public Spannable c() {
            return this.b;
        }

        public final String d() {
            return this.d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return AbstractC13042fc3.d(this.a, cVar.a) && AbstractC13042fc3.d(this.b, cVar.b) && AbstractC13042fc3.d(this.c, cVar.c) && AbstractC13042fc3.d(this.d, cVar.d);
        }

        public int hashCode() {
            Integer num = this.a;
            int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
            Spannable spannable = this.b;
            int iHashCode2 = (iHashCode + (spannable == null ? 0 : spannable.hashCode())) * 31;
            Spannable spannable2 = this.c;
            return ((iHashCode2 + (spannable2 != null ? spannable2.hashCode() : 0)) * 31) + this.d.hashCode();
        }

        public String toString() {
            Integer num = this.a;
            Spannable spannable = this.b;
            Spannable spannable2 = this.c;
            return "ReplyLocation(color=" + num + ", userName=" + ((Object) spannable) + ", body=" + ((Object) spannable2) + ", locationUri=" + this.d + Separators.RPAREN;
        }
    }

    public static final class d extends PO5 {
        private final Integer a;
        private final Spannable b;
        private final Spannable c;

        public d(Integer num, Spannable spannable, Spannable spannable2) {
            super(null);
            this.a = num;
            this.b = spannable;
            this.c = spannable2;
        }

        @Override // ir.nasim.PO5
        public Spannable a() {
            return this.c;
        }

        @Override // ir.nasim.PO5
        public Integer b() {
            return this.a;
        }

        @Override // ir.nasim.PO5
        public Spannable c() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return AbstractC13042fc3.d(this.a, dVar.a) && AbstractC13042fc3.d(this.b, dVar.b) && AbstractC13042fc3.d(this.c, dVar.c);
        }

        public int hashCode() {
            Integer num = this.a;
            int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
            Spannable spannable = this.b;
            int iHashCode2 = (iHashCode + (spannable == null ? 0 : spannable.hashCode())) * 31;
            Spannable spannable2 = this.c;
            return iHashCode2 + (spannable2 != null ? spannable2.hashCode() : 0);
        }

        public String toString() {
            return "SimpleReply(color=" + this.a + ", userName=" + ((Object) this.b) + ", body=" + ((Object) this.c) + Separators.RPAREN;
        }
    }

    public static final class e extends PO5 {
        private final Integer a;
        private final Spannable b;
        private final Spannable c;
        private final int d;
        private final String e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Integer num, Spannable spannable, Spannable spannable2, int i, String str) {
            super(null);
            AbstractC13042fc3.i(str, "storyId");
            this.a = num;
            this.b = spannable;
            this.c = spannable2;
            this.d = i;
            this.e = str;
        }

        @Override // ir.nasim.PO5
        public Spannable a() {
            return this.c;
        }

        @Override // ir.nasim.PO5
        public Integer b() {
            return this.a;
        }

        @Override // ir.nasim.PO5
        public Spannable c() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return AbstractC13042fc3.d(this.a, eVar.a) && AbstractC13042fc3.d(this.b, eVar.b) && AbstractC13042fc3.d(this.c, eVar.c) && this.d == eVar.d && AbstractC13042fc3.d(this.e, eVar.e);
        }

        public int hashCode() {
            Integer num = this.a;
            int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
            Spannable spannable = this.b;
            int iHashCode2 = (iHashCode + (spannable == null ? 0 : spannable.hashCode())) * 31;
            Spannable spannable2 = this.c;
            return ((((iHashCode2 + (spannable2 != null ? spannable2.hashCode() : 0)) * 31) + Integer.hashCode(this.d)) * 31) + this.e.hashCode();
        }

        public String toString() {
            Integer num = this.a;
            Spannable spannable = this.b;
            Spannable spannable2 = this.c;
            return "StoryReply(color=" + num + ", userName=" + ((Object) spannable) + ", body=" + ((Object) spannable2) + ", senderId=" + this.d + ", storyId=" + this.e + Separators.RPAREN;
        }
    }

    private PO5() {
    }

    public abstract Spannable a();

    public abstract Integer b();

    public abstract Spannable c();

    public /* synthetic */ PO5(ED1 ed1) {
        this();
    }
}
