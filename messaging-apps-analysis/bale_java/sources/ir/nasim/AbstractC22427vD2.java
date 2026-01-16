package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.vD2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC22427vD2 {

    /* renamed from: ir.nasim.vD2$a */
    public static final class a extends AbstractC22427vD2 {
        public static final a a = new a();

        private a() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public int hashCode() {
            return 205037946;
        }

        public String toString() {
            return "Dismissed";
        }
    }

    /* renamed from: ir.nasim.vD2$b */
    public static final class b extends AbstractC22427vD2 {
        public static final b a = new b();

        private b() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return -1544864179;
        }

        public String toString() {
            return "Loading";
        }
    }

    /* renamed from: ir.nasim.vD2$c */
    public static final class c extends AbstractC22427vD2 {
        private final int a;
        private final InterfaceC11562dD2 b;
        private final InterfaceC21791u83 c;
        private final List d;
        private final C9929an6 e;
        private final boolean f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(int i, InterfaceC11562dD2 interfaceC11562dD2, InterfaceC21791u83 interfaceC21791u83, List list, C9929an6 c9929an6, boolean z) {
            super(null);
            AbstractC13042fc3.i(interfaceC11562dD2, "keyboardState");
            AbstractC13042fc3.i(interfaceC21791u83, "inputBarState");
            AbstractC13042fc3.i(list, "buckets");
            AbstractC13042fc3.i(c9929an6, "selectedBucket");
            this.a = i;
            this.b = interfaceC11562dD2;
            this.c = interfaceC21791u83;
            this.d = list;
            this.e = c9929an6;
            this.f = z;
        }

        public final List a() {
            return this.d;
        }

        public final InterfaceC21791u83 b() {
            return this.c;
        }

        public final InterfaceC11562dD2 c() {
            return this.b;
        }

        public final C9929an6 d() {
            return this.e;
        }

        public final int e() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.a == cVar.a && AbstractC13042fc3.d(this.b, cVar.b) && AbstractC13042fc3.d(this.c, cVar.c) && AbstractC13042fc3.d(this.d, cVar.d) && AbstractC13042fc3.d(this.e, cVar.e) && this.f == cVar.f;
        }

        public final boolean f() {
            return this.f;
        }

        public int hashCode() {
            return (((((((((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + Boolean.hashCode(this.f);
        }

        public String toString() {
            return "SelectionMode(selectedItemsCount=" + this.a + ", keyboardState=" + this.b + ", inputBarState=" + this.c + ", buckets=" + this.d + ", selectedBucket=" + this.e + ", showSendOptions=" + this.f + Separators.RPAREN;
        }
    }

    private AbstractC22427vD2() {
    }

    public /* synthetic */ AbstractC22427vD2(ED1 ed1) {
        this();
    }
}
