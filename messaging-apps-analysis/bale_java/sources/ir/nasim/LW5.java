package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class LW5 {
    private final List a = new ArrayList();

    private static final class a {
        private final Class a;
        final KW5 b;

        a(Class cls, KW5 kw5) {
            this.a = cls;
            this.b = kw5;
        }

        boolean a(Class cls) {
            return this.a.isAssignableFrom(cls);
        }
    }

    public synchronized void a(Class cls, KW5 kw5) {
        this.a.add(new a(cls, kw5));
    }

    public synchronized KW5 b(Class cls) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            a aVar = (a) this.a.get(i);
            if (aVar.a(cls)) {
                return aVar.b;
            }
        }
        return null;
    }
}
