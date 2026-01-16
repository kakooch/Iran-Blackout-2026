package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.bj0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC10503bj0 {

    /* renamed from: ir.nasim.bj0$a */
    public static final class a implements InterfaceC10503bj0 {
        public static final int c = 8;
        private final List a;
        private final boolean b;

        public a(List list, boolean z) {
            AbstractC13042fc3.i(list, "botCommands");
            this.a = list;
            this.b = z;
        }

        public static /* synthetic */ a b(a aVar, List list, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                list = aVar.a;
            }
            if ((i & 2) != 0) {
                z = aVar.b;
            }
            return aVar.a(list, z);
        }

        public final a a(List list, boolean z) {
            AbstractC13042fc3.i(list, "botCommands");
            return new a(list, z);
        }

        public final List c() {
            return this.a;
        }

        public final boolean d() {
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
            return AbstractC13042fc3.d(this.a, aVar.a) && this.b == aVar.b;
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + Boolean.hashCode(this.b);
        }

        public String toString() {
            return "CommandsMenu(botCommands=" + this.a + ", isExpanded=" + this.b + Separators.RPAREN;
        }

        public /* synthetic */ a(List list, boolean z, int i, ED1 ed1) {
            this(list, (i & 2) != 0 ? false : z);
        }
    }

    /* renamed from: ir.nasim.bj0$b */
    public static final class b implements InterfaceC10503bj0 {
        public static final b a = new b();
        public static final int b = 0;

        private b() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return -224065454;
        }

        public String toString() {
            return "None";
        }
    }

    /* renamed from: ir.nasim.bj0$c */
    public static final class c implements InterfaceC10503bj0 {
        public static final int c = 0;
        private final String a;
        private final String b;

        public c(String str, String str2) {
            AbstractC13042fc3.i(str, "title");
            this.a = str;
            this.b = str2;
        }

        public final String a() {
            return this.a;
        }

        public final String b() {
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
            int iHashCode = this.a.hashCode() * 31;
            String str = this.b;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "WebAppMenu(title=" + this.a + ", url=" + this.b + Separators.RPAREN;
        }
    }
}
