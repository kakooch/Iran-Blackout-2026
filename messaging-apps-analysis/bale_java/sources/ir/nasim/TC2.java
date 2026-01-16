package ir.nasim;

import android.gov.nist.core.Separators;
import java.io.Serializable;

/* loaded from: classes5.dex */
public interface TC2 extends Serializable {
    public static final /* synthetic */ b l0 = b.a;

    public static final class b {
        static final /* synthetic */ b a = new b();

        private b() {
        }
    }

    boolean A();

    int B();

    VC2 getContentType();

    default boolean t() {
        return B() > 1;
    }

    boolean v();

    boolean x();

    public static final class d implements TC2 {
        private final boolean a;
        private final VC2 b;
        private final boolean c;
        private final boolean d;
        private final int e;

        public d(boolean z, VC2 vc2) {
            AbstractC13042fc3.i(vc2, "contentType");
            this.a = z;
            this.b = vc2;
            this.e = 1;
        }

        @Override // ir.nasim.TC2
        public boolean A() {
            return this.d;
        }

        @Override // ir.nasim.TC2
        public int B() {
            return this.e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.a == dVar.a && this.b == dVar.b;
        }

        @Override // ir.nasim.TC2
        public VC2 getContentType() {
            return this.b;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.a) * 31) + this.b.hashCode();
        }

        public String toString() {
            return "StorySelect(allowEditMedia=" + this.a + ", contentType=" + this.b + Separators.RPAREN;
        }

        @Override // ir.nasim.TC2
        public boolean v() {
            return this.a;
        }

        @Override // ir.nasim.TC2
        public boolean x() {
            return this.c;
        }

        public /* synthetic */ d(boolean z, VC2 vc2, int i, ED1 ed1) {
            this((i & 1) != 0 ? true : z, (i & 2) != 0 ? VC2.a : vc2);
        }
    }

    public static final class a implements TC2 {
        private final boolean a;
        private final boolean b;
        private final boolean c;
        private final VC2 d;
        private final int e;

        public a(boolean z, boolean z2, boolean z3, VC2 vc2) {
            AbstractC13042fc3.i(vc2, "contentType");
            this.a = z;
            this.b = z2;
            this.c = z3;
            this.d = vc2;
            this.e = 1;
        }

        @Override // ir.nasim.TC2
        public boolean A() {
            return this.c;
        }

        @Override // ir.nasim.TC2
        public int B() {
            return this.e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.b == aVar.b && this.c == aVar.c && this.d == aVar.d;
        }

        @Override // ir.nasim.TC2
        public VC2 getContentType() {
            return this.d;
        }

        public int hashCode() {
            return (((((Boolean.hashCode(this.a) * 31) + Boolean.hashCode(this.b)) * 31) + Boolean.hashCode(this.c)) * 31) + this.d.hashCode();
        }

        public String toString() {
            return "AvatarSelect(allowCaption=" + this.a + ", allowEditMedia=" + this.b + ", showSendOptions=" + this.c + ", contentType=" + this.d + Separators.RPAREN;
        }

        @Override // ir.nasim.TC2
        public boolean v() {
            return this.b;
        }

        @Override // ir.nasim.TC2
        public boolean x() {
            return this.a;
        }

        public /* synthetic */ a(boolean z, boolean z2, boolean z3, VC2 vc2, int i, ED1 ed1) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? true : z2, (i & 4) != 0 ? false : z3, (i & 8) != 0 ? VC2.c : vc2);
        }
    }

    public static final class c implements TC2 {
        private final int a;
        private final boolean b;
        private final boolean c;
        private final boolean d;
        private final VC2 e;

        public c(int i, boolean z, boolean z2, boolean z3, VC2 vc2) {
            AbstractC13042fc3.i(vc2, "contentType");
            this.a = i;
            this.b = z;
            this.c = z2;
            this.d = z3;
            this.e = vc2;
        }

        @Override // ir.nasim.TC2
        public boolean A() {
            return this.d;
        }

        @Override // ir.nasim.TC2
        public int B() {
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
            return this.a == cVar.a && this.b == cVar.b && this.c == cVar.c && this.d == cVar.d && this.e == cVar.e;
        }

        @Override // ir.nasim.TC2
        public VC2 getContentType() {
            return this.e;
        }

        public int hashCode() {
            return (((((((Integer.hashCode(this.a) * 31) + Boolean.hashCode(this.b)) * 31) + Boolean.hashCode(this.c)) * 31) + Boolean.hashCode(this.d)) * 31) + this.e.hashCode();
        }

        public String toString() {
            return "MultiSelect(selectionLimit=" + this.a + ", allowCaption=" + this.b + ", allowEditMedia=" + this.c + ", showSendOptions=" + this.d + ", contentType=" + this.e + Separators.RPAREN;
        }

        @Override // ir.nasim.TC2
        public boolean v() {
            return this.c;
        }

        @Override // ir.nasim.TC2
        public boolean x() {
            return this.b;
        }

        public /* synthetic */ c(int i, boolean z, boolean z2, boolean z3, VC2 vc2, int i2, ED1 ed1) {
            this((i2 & 1) != 0 ? 50 : i, (i2 & 2) != 0 ? true : z, (i2 & 4) != 0 ? true : z2, (i2 & 8) == 0 ? z3 : true, (i2 & 16) != 0 ? VC2.a : vc2);
        }
    }
}
