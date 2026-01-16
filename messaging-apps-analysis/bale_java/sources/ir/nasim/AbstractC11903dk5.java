package ir.nasim;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/* renamed from: ir.nasim.dk5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC11903dk5 {

    /* renamed from: ir.nasim.dk5$b */
    private static class b implements InterfaceC11281ck5, Serializable {
        private final List a;

        @Override // ir.nasim.InterfaceC11281ck5
        public boolean apply(Object obj) {
            for (int i = 0; i < this.a.size(); i++) {
                if (!((InterfaceC11281ck5) this.a.get(i)).apply(obj)) {
                    return false;
                }
            }
            return true;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.a.equals(((b) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode() + 306654252;
        }

        public String toString() {
            return AbstractC11903dk5.d("and", this.a);
        }

        private b(List list) {
            this.a = list;
        }
    }

    public static InterfaceC11281ck5 b(InterfaceC11281ck5 interfaceC11281ck5, InterfaceC11281ck5 interfaceC11281ck52) {
        return new b(c((InterfaceC11281ck5) AbstractC4029Dj5.j(interfaceC11281ck5), (InterfaceC11281ck5) AbstractC4029Dj5.j(interfaceC11281ck52)));
    }

    private static List c(InterfaceC11281ck5 interfaceC11281ck5, InterfaceC11281ck5 interfaceC11281ck52) {
        return Arrays.asList(interfaceC11281ck5, interfaceC11281ck52);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(String str, Iterable iterable) {
        StringBuilder sb = new StringBuilder("Predicates.");
        sb.append(str);
        sb.append('(');
        boolean z = true;
        for (Object obj : iterable) {
            if (!z) {
                sb.append(',');
            }
            sb.append(obj);
            z = false;
        }
        sb.append(')');
        return sb.toString();
    }
}
