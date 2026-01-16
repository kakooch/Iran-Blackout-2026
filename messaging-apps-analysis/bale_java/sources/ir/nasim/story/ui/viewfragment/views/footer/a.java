package ir.nasim.story.ui.viewfragment.views.footer;

import android.gov.nist.core.Separators;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;
import ir.nasim.InterfaceC12925fP5;
import ir.nasim.InterfaceC3313Ai5;
import ir.nasim.InterfaceC5024Ho4;

/* loaded from: classes7.dex */
public abstract class a {
    private final int a;

    /* renamed from: ir.nasim.story.ui.viewfragment.views.footer.a$a, reason: collision with other inner class name */
    public static final class C1551a extends a {
        private final Integer b;
        private final Integer c;
        private final InterfaceC5024Ho4 d;

        public C1551a(Integer num, Integer num2, InterfaceC5024Ho4 interfaceC5024Ho4) {
            super(2, null);
            this.b = num;
            this.c = num2;
            this.d = interfaceC5024Ho4;
        }

        public final InterfaceC5024Ho4 b() {
            return this.d;
        }

        public final Integer c() {
            return this.c;
        }

        public final Integer d() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C1551a)) {
                return false;
            }
            C1551a c1551a = (C1551a) obj;
            return AbstractC13042fc3.d(this.b, c1551a.b) && AbstractC13042fc3.d(this.c, c1551a.c) && AbstractC13042fc3.d(this.d, c1551a.d);
        }

        public int hashCode() {
            Integer num = this.b;
            int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
            Integer num2 = this.c;
            int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
            InterfaceC5024Ho4 interfaceC5024Ho4 = this.d;
            return iHashCode2 + (interfaceC5024Ho4 != null ? interfaceC5024Ho4.hashCode() : 0);
        }

        public String toString() {
            return "MyStatus(viewCount=" + this.b + ", reactionCount=" + this.c + ", listener=" + this.d + Separators.RPAREN;
        }
    }

    public static final class b extends a {
        public static final b b = new b();

        private b() {
            super(0, null);
        }
    }

    public static final class c extends a {
        private final ir.nasim.story.ui.viewfragment.views.a b;
        private final Integer c;
        private final Integer d;
        private final InterfaceC3313Ai5 e;

        public /* synthetic */ c(ir.nasim.story.ui.viewfragment.views.a aVar, Integer num, Integer num2, InterfaceC3313Ai5 interfaceC3313Ai5, int i, ED1 ed1) {
            this((i & 1) != 0 ? null : aVar, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : interfaceC3313Ai5);
        }

        public final InterfaceC3313Ai5 b() {
            return this.e;
        }

        public final ir.nasim.story.ui.viewfragment.views.a c() {
            return this.b;
        }

        public final Integer d() {
            return this.d;
        }

        public final Integer e() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return AbstractC13042fc3.d(this.b, cVar.b) && AbstractC13042fc3.d(this.c, cVar.c) && AbstractC13042fc3.d(this.d, cVar.d) && AbstractC13042fc3.d(this.e, cVar.e);
        }

        public int hashCode() {
            ir.nasim.story.ui.viewfragment.views.a aVar = this.b;
            int iHashCode = (aVar == null ? 0 : aVar.hashCode()) * 31;
            Integer num = this.c;
            int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.d;
            int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
            InterfaceC3313Ai5 interfaceC3313Ai5 = this.e;
            return iHashCode3 + (interfaceC3313Ai5 != null ? interfaceC3313Ai5.hashCode() : 0);
        }

        public String toString() {
            return "Popular(reaction=" + this.b + ", viewCount=" + this.c + ", reactionCount=" + this.d + ", listener=" + this.e + Separators.RPAREN;
        }

        public c(ir.nasim.story.ui.viewfragment.views.a aVar, Integer num, Integer num2, InterfaceC3313Ai5 interfaceC3313Ai5) {
            super(4, null);
            this.b = aVar;
            this.c = num;
            this.d = num2;
            this.e = interfaceC3313Ai5;
        }
    }

    public static final class d extends a {
        private final boolean b;
        private final ir.nasim.story.ui.viewfragment.views.a c;
        private final InterfaceC12925fP5 d;
        private final String e;

        public /* synthetic */ d(boolean z, ir.nasim.story.ui.viewfragment.views.a aVar, InterfaceC12925fP5 interfaceC12925fP5, String str, int i, ED1 ed1) {
            this(z, (i & 2) != 0 ? null : aVar, (i & 4) != 0 ? null : interfaceC12925fP5, (i & 8) != 0 ? null : str);
        }

        public final InterfaceC12925fP5 b() {
            return this.d;
        }

        public final ir.nasim.story.ui.viewfragment.views.a c() {
            return this.c;
        }

        public final String d() {
            return this.e;
        }

        public final boolean e() {
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
            return this.b == dVar.b && AbstractC13042fc3.d(this.c, dVar.c) && AbstractC13042fc3.d(this.d, dVar.d) && AbstractC13042fc3.d(this.e, dVar.e);
        }

        public int hashCode() {
            int iHashCode = Boolean.hashCode(this.b) * 31;
            ir.nasim.story.ui.viewfragment.views.a aVar = this.c;
            int iHashCode2 = (iHashCode + (aVar == null ? 0 : aVar.hashCode())) * 31;
            InterfaceC12925fP5 interfaceC12925fP5 = this.d;
            int iHashCode3 = (iHashCode2 + (interfaceC12925fP5 == null ? 0 : interfaceC12925fP5.hashCode())) * 31;
            String str = this.e;
            return iHashCode3 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "Reply(showReply=" + this.b + ", reaction=" + this.c + ", listener=" + this.d + ", replyText=" + this.e + Separators.RPAREN;
        }

        public d(boolean z, ir.nasim.story.ui.viewfragment.views.a aVar, InterfaceC12925fP5 interfaceC12925fP5, String str) {
            super(3, null);
            this.b = z;
            this.c = aVar;
            this.d = interfaceC12925fP5;
            this.e = str;
        }
    }

    public static final class e extends a {
        public static final e b = new e();

        private e() {
            super(1, null);
        }
    }

    public /* synthetic */ a(int i, ED1 ed1) {
        this(i);
    }

    public final boolean a(a aVar) {
        AbstractC13042fc3.i(aVar, "compareInstance");
        return this.a == aVar.a;
    }

    private a(int i) {
        this.a = i;
    }
}
