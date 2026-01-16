package ir.nasim;

/* renamed from: ir.nasim.uW4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC22010uW4 {
    private final Class a;
    private final Class b;

    /* renamed from: ir.nasim.uW4$a */
    class a extends AbstractC22010uW4 {
        final /* synthetic */ b c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Class cls, Class cls2, b bVar) {
            super(cls, cls2, null);
            this.c = bVar;
        }

        @Override // ir.nasim.AbstractC22010uW4
        public InterfaceC20931sq6 d(AbstractC20124rW4 abstractC20124rW4) {
            return this.c.a(abstractC20124rW4);
        }
    }

    /* renamed from: ir.nasim.uW4$b */
    public interface b {
        InterfaceC20931sq6 a(AbstractC20124rW4 abstractC20124rW4);
    }

    /* synthetic */ AbstractC22010uW4(Class cls, Class cls2, a aVar) {
        this(cls, cls2);
    }

    public static AbstractC22010uW4 a(b bVar, Class cls, Class cls2) {
        return new a(cls, cls2, bVar);
    }

    public Class b() {
        return this.a;
    }

    public Class c() {
        return this.b;
    }

    public abstract InterfaceC20931sq6 d(AbstractC20124rW4 abstractC20124rW4);

    private AbstractC22010uW4(Class cls, Class cls2) {
        this.a = cls;
        this.b = cls2;
    }
}
