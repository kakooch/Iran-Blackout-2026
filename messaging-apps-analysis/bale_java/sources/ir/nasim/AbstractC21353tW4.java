package ir.nasim;

/* renamed from: ir.nasim.tW4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC21353tW4 {
    private final C8575Wo0 a;
    private final Class b;

    /* renamed from: ir.nasim.tW4$a */
    class a extends AbstractC21353tW4 {
        final /* synthetic */ b c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C8575Wo0 c8575Wo0, Class cls, b bVar) {
            super(c8575Wo0, cls, null);
            this.c = bVar;
        }

        @Override // ir.nasim.AbstractC21353tW4
        public AbstractC20124rW4 d(InterfaceC20931sq6 interfaceC20931sq6) {
            return this.c.a(interfaceC20931sq6);
        }
    }

    /* renamed from: ir.nasim.tW4$b */
    public interface b {
        AbstractC20124rW4 a(InterfaceC20931sq6 interfaceC20931sq6);
    }

    /* synthetic */ AbstractC21353tW4(C8575Wo0 c8575Wo0, Class cls, a aVar) {
        this(c8575Wo0, cls);
    }

    public static AbstractC21353tW4 a(b bVar, C8575Wo0 c8575Wo0, Class cls) {
        return new a(c8575Wo0, cls, bVar);
    }

    public final C8575Wo0 b() {
        return this.a;
    }

    public final Class c() {
        return this.b;
    }

    public abstract AbstractC20124rW4 d(InterfaceC20931sq6 interfaceC20931sq6);

    private AbstractC21353tW4(C8575Wo0 c8575Wo0, Class cls) {
        this.a = c8575Wo0;
        this.b = cls;
    }
}
