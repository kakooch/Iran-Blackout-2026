package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.ih2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public interface InterfaceC14910ih2 {

    /* renamed from: ir.nasim.ih2$a */
    public static final class a implements InterfaceC14910ih2 {
        private final long a;

        public a(long j) {
            this.a = j;
        }

        public final long a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && this.a == ((a) obj).a;
        }

        public int hashCode() {
            return Long.hashCode(this.a);
        }

        public String toString() {
            return "Reaction(reactionCount=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.ih2$b */
    public static final class b implements InterfaceC14910ih2 {
        private final C4743Gj2 a;

        public b(C4743Gj2 c4743Gj2) {
            AbstractC13042fc3.i(c4743Gj2, "feedUI");
            this.a = c4743Gj2;
        }

        public final C4743Gj2 a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && AbstractC13042fc3.d(this.a, ((b) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "ReactionsList(feedUI=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.ih2$c */
    public static final class c implements InterfaceC14910ih2 {
        private final List a;

        public c(List list) {
            AbstractC13042fc3.i(list, "userList");
            this.a = list;
        }

        public final List a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && AbstractC13042fc3.d(this.a, ((c) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "Suggester(userList=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.ih2$d */
    public static final class d implements InterfaceC14910ih2 {
        private final C5886Lg2 a;
        private final long b;

        public d(C5886Lg2 c5886Lg2, long j) {
            AbstractC13042fc3.i(c5886Lg2, "feed");
            this.a = c5886Lg2;
            this.b = j;
        }

        public final C5886Lg2 a() {
            return this.a;
        }

        public final long b() {
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
            return AbstractC13042fc3.d(this.a, dVar.a) && this.b == dVar.b;
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + Long.hashCode(this.b);
        }

        public String toString() {
            return "ViewCount(feed=" + this.a + ", viewCount=" + this.b + Separators.RPAREN;
        }
    }
}
