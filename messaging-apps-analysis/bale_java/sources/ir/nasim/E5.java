package ir.nasim;

import android.gov.nist.core.Separators;
import android.graphics.drawable.Drawable;

/* loaded from: classes4.dex */
public abstract class E5 {

    public static final class a extends E5 {
        private final int a;

        public a(int i) {
            super(null);
            this.a = i;
        }

        public final int a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && this.a == ((a) obj).a;
        }

        public int hashCode() {
            return Integer.hashCode(this.a);
        }

        public String toString() {
            return "DrawableResource(iconRes=" + this.a + Separators.RPAREN;
        }
    }

    public static final class b extends E5 {
        private final int a;
        private final InterfaceC10258bL6 b;

        public b(int i, InterfaceC10258bL6 interfaceC10258bL6) {
            super(null);
            this.a = i;
            this.b = interfaceC10258bL6;
        }

        public final InterfaceC10258bL6 a() {
            return this.b;
        }

        public final int b() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.a == bVar.a && AbstractC13042fc3.d(this.b, bVar.b);
        }

        public int hashCode() {
            int iHashCode = Integer.hashCode(this.a) * 31;
            InterfaceC10258bL6 interfaceC10258bL6 = this.b;
            return iHashCode + (interfaceC10258bL6 == null ? 0 : interfaceC10258bL6.hashCode());
        }

        public String toString() {
            return "Reaction(iconRes=" + this.a + ", avatarsReaction=" + this.b + Separators.RPAREN;
        }
    }

    public static final class c extends E5 {
        private final String a;
        private final Drawable b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, Drawable drawable) {
            super(null);
            AbstractC13042fc3.i(str, "path");
            this.a = str;
            this.b = drawable;
        }

        public final String a() {
            return this.a;
        }

        public final Drawable b() {
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
            Drawable drawable = this.b;
            return iHashCode + (drawable == null ? 0 : drawable.hashCode());
        }

        public String toString() {
            return "Uri(path=" + this.a + ", placeHolder=" + this.b + Separators.RPAREN;
        }
    }

    private E5() {
    }

    public /* synthetic */ E5(ED1 ed1) {
        this();
    }
}
