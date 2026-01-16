package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.c82, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C10751c82 {
    private final List a = new ArrayList();

    /* renamed from: ir.nasim.c82$a */
    private static final class a {
        private final Class a;
        final Z72 b;

        a(Class cls, Z72 z72) {
            this.a = cls;
            this.b = z72;
        }

        boolean a(Class cls) {
            return this.a.isAssignableFrom(cls);
        }
    }

    public synchronized void a(Class cls, Z72 z72) {
        this.a.add(new a(cls, z72));
    }

    public synchronized Z72 b(Class cls) {
        for (a aVar : this.a) {
            if (aVar.a(cls)) {
                return aVar.b;
            }
        }
        return null;
    }
}
