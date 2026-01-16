package ir.nasim;

import java.lang.annotation.Annotation;

/* renamed from: ir.nasim.wL5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC23098wL5 implements InterfaceC4243Eh3 {
    public static final a b = new a(null);
    private final C6432No4 a;

    /* renamed from: ir.nasim.wL5$a */
    public static final class a {
        private a() {
        }

        public final AbstractC23098wL5 a(Object obj, C6432No4 c6432No4) {
            AbstractC13042fc3.i(obj, "value");
            return AbstractC21912uL5.i(obj.getClass()) ? new JL5(c6432No4, (Enum) obj) : obj instanceof Annotation ? new C23688xL5(c6432No4, (Annotation) obj) : obj instanceof Object[] ? new AL5(c6432No4, (Object[]) obj) : obj instanceof Class ? new FL5(c6432No4, (Class) obj) : new LL5(c6432No4, obj);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public AbstractC23098wL5(C6432No4 c6432No4) {
        this.a = c6432No4;
    }

    @Override // ir.nasim.InterfaceC4243Eh3
    public C6432No4 getName() {
        return this.a;
    }
}
