package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.List;

/* loaded from: classes.dex */
public abstract class LW {

    public static final class a extends LW {
        private final String a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str) {
            super(null);
            AbstractC13042fc3.i(str, DialogEntity.COLUMN_MESSAGE);
            this.a = str;
        }

        public final String a() {
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
            return "DoneMessage(message=" + this.a + Separators.RPAREN;
        }
    }

    public static final class b extends LW {
        public static final b a = new b();

        private b() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return 68578857;
        }

        public String toString() {
            return "Idle";
        }
    }

    public static final class c extends LW {
        private final List a;
        private final List b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(List list, List list2) {
            super(null);
            AbstractC13042fc3.i(list, "badgesShimmer");
            AbstractC13042fc3.i(list2, "tabsShimmer");
            this.a = list;
            this.b = list2;
        }

        public final List a() {
            return this.a;
        }

        public final List b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return AbstractC13042fc3.d(this.a, cVar.a) && AbstractC13042fc3.d(this.b, cVar.b);
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            return "Loading(badgesShimmer=" + this.a + ", tabsShimmer=" + this.b + Separators.RPAREN;
        }
    }

    public static final class d extends LW {
        private final List a;
        private final List b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(List list, List list2) {
            super(null);
            AbstractC13042fc3.i(list, "badges");
            AbstractC13042fc3.i(list2, "tabs");
            this.a = list;
            this.b = list2;
        }

        public final List a() {
            return this.a;
        }

        public final List b() {
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
            return AbstractC13042fc3.d(this.a, dVar.a) && AbstractC13042fc3.d(this.b, dVar.b);
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            return "Success(badges=" + this.a + ", tabs=" + this.b + Separators.RPAREN;
        }
    }

    private LW() {
    }

    public /* synthetic */ LW(ED1 ed1) {
        this();
    }
}
