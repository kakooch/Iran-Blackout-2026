package ir.nasim.story.ui.viewfragment.views;

import android.gov.nist.core.Separators;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;

/* loaded from: classes7.dex */
public abstract class a {
    private final boolean a;

    /* renamed from: ir.nasim.story.ui.viewfragment.views.a$a, reason: collision with other inner class name */
    public static final class C1549a extends a {
        private final boolean b;

        public C1549a(boolean z) {
            super(z, null);
            this.b = z;
        }

        @Override // ir.nasim.story.ui.viewfragment.views.a
        public boolean a() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof C1549a) && this.b == ((C1549a) obj).b;
        }

        public int hashCode() {
            return Boolean.hashCode(this.b);
        }

        public String toString() {
            return "Like(bounce=" + this.b + Separators.RPAREN;
        }

        public /* synthetic */ C1549a(boolean z, int i, ED1 ed1) {
            this((i & 1) != 0 ? false : z);
        }
    }

    public static final class b extends a {
        private final String b;
        private final boolean c;

        public /* synthetic */ b(String str, boolean z, int i, ED1 ed1) {
            this(str, (i & 2) != 0 ? false : z);
        }

        @Override // ir.nasim.story.ui.viewfragment.views.a
        public boolean a() {
            return this.c;
        }

        public final String b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return AbstractC13042fc3.d(this.b, bVar.b) && this.c == bVar.c;
        }

        public int hashCode() {
            return (this.b.hashCode() * 31) + Boolean.hashCode(this.c);
        }

        public String toString() {
            return "Reaction(unicode=" + this.b + ", bounce=" + this.c + Separators.RPAREN;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, boolean z) {
            super(z, null);
            AbstractC13042fc3.i(str, "unicode");
            this.b = str;
            this.c = z;
        }
    }

    public static final class c extends a {
        private final boolean b;

        public c(boolean z) {
            super(z, null);
            this.b = z;
        }

        @Override // ir.nasim.story.ui.viewfragment.views.a
        public boolean a() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && this.b == ((c) obj).b;
        }

        public int hashCode() {
            return Boolean.hashCode(this.b);
        }

        public String toString() {
            return "Unlike(bounce=" + this.b + Separators.RPAREN;
        }

        public /* synthetic */ c(boolean z, int i, ED1 ed1) {
            this((i & 1) != 0 ? false : z);
        }
    }

    public /* synthetic */ a(boolean z, ED1 ed1) {
        this(z);
    }

    public abstract boolean a();

    private a(boolean z) {
        this.a = z;
    }
}
