package ir.nasim;

import ir.nasim.AbstractC6165Ml3;
import ir.nasim.AbstractC7849Tl3;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes8.dex */
public final class Z24 {
    public static final a b = new a(null);
    private final String a;

    public static final class a {
        private a() {
        }

        public final Z24 a(String str, String str2) {
            AbstractC13042fc3.i(str, "name");
            AbstractC13042fc3.i(str2, "desc");
            return new Z24(str + '#' + str2, null);
        }

        public final Z24 b(AbstractC6165Ml3 abstractC6165Ml3) {
            AbstractC13042fc3.i(abstractC6165Ml3, "signature");
            if (abstractC6165Ml3 instanceof AbstractC6165Ml3.b) {
                return d(abstractC6165Ml3.c(), abstractC6165Ml3.b());
            }
            if (abstractC6165Ml3 instanceof AbstractC6165Ml3.a) {
                return a(abstractC6165Ml3.c(), abstractC6165Ml3.b());
            }
            throw new NoWhenBranchMatchedException();
        }

        public final Z24 c(InterfaceC6692Oo4 interfaceC6692Oo4, AbstractC7849Tl3.c cVar) {
            AbstractC13042fc3.i(interfaceC6692Oo4, "nameResolver");
            AbstractC13042fc3.i(cVar, "signature");
            return d(interfaceC6692Oo4.getString(cVar.y()), interfaceC6692Oo4.getString(cVar.w()));
        }

        public final Z24 d(String str, String str2) {
            AbstractC13042fc3.i(str, "name");
            AbstractC13042fc3.i(str2, "desc");
            return new Z24(AbstractC13042fc3.q(str, str2), null);
        }

        public final Z24 e(Z24 z24, int i) {
            AbstractC13042fc3.i(z24, "signature");
            return new Z24(z24.a() + '@' + i, null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ Z24(String str, ED1 ed1) {
        this(str);
    }

    public final String a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Z24) && AbstractC13042fc3.d(this.a, ((Z24) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "MemberSignature(signature=" + this.a + ')';
    }

    private Z24(String str) {
        this.a = str;
    }
}
