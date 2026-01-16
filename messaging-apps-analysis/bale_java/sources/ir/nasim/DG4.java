package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class DG4 {

    public static final class a {
        private final List a;
        private final Object b;

        /* synthetic */ a(Object obj, Zh8 zh8) {
            AbstractC3795Cj5.j(obj);
            this.b = obj;
            this.a = new ArrayList();
        }

        public a a(String str, Object obj) {
            AbstractC3795Cj5.j(str);
            this.a.add(str + Separators.EQUALS + String.valueOf(obj));
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(100);
            sb.append(this.b.getClass().getSimpleName());
            sb.append('{');
            int size = this.a.size();
            for (int i = 0; i < size; i++) {
                sb.append((String) this.a.get(i));
                if (i < size - 1) {
                    sb.append(", ");
                }
            }
            sb.append('}');
            return sb.toString();
        }
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int b(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static a c(Object obj) {
        return new a(obj, null);
    }
}
