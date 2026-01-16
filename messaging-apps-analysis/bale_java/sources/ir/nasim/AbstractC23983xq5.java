package ir.nasim;

/* renamed from: ir.nasim.xq5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC23983xq5 {
    private final Class a;
    private final Class b;

    /* renamed from: ir.nasim.xq5$a */
    class a extends AbstractC23983xq5 {
        final /* synthetic */ b c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Class cls, Class cls2, b bVar) {
            super(cls, cls2, null);
            this.c = bVar;
        }

        @Override // ir.nasim.AbstractC23983xq5
        public Object a(AbstractC14981io3 abstractC14981io3) {
            return this.c.a(abstractC14981io3);
        }
    }

    /* renamed from: ir.nasim.xq5$b */
    public interface b {
        Object a(AbstractC14981io3 abstractC14981io3);
    }

    /* synthetic */ AbstractC23983xq5(Class cls, Class cls2, a aVar) {
        this(cls, cls2);
    }

    public static AbstractC23983xq5 b(b bVar, Class cls, Class cls2) {
        return new a(cls, cls2, bVar);
    }

    public abstract Object a(AbstractC14981io3 abstractC14981io3);

    public Class c() {
        return this.a;
    }

    public Class d() {
        return this.b;
    }

    private AbstractC23983xq5(Class cls, Class cls2) {
        this.a = cls;
        this.b = cls2;
    }
}
