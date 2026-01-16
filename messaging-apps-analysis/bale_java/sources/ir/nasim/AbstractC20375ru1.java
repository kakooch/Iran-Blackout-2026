package ir.nasim;

import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: ir.nasim.ru1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC20375ru1 {
    private final Map a = new LinkedHashMap();

    /* renamed from: ir.nasim.ru1$a */
    public static final class a extends AbstractC20375ru1 {
        public static final a b = new a();

        private a() {
        }

        @Override // ir.nasim.AbstractC20375ru1
        public Object a(b bVar) {
            AbstractC13042fc3.i(bVar, "key");
            return null;
        }
    }

    /* renamed from: ir.nasim.ru1$b */
    public interface b {
    }

    public abstract Object a(b bVar);

    public final Map b() {
        return this.a;
    }
}
