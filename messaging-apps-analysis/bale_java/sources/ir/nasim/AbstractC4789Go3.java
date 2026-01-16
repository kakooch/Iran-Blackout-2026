package ir.nasim;

/* renamed from: ir.nasim.Go3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC4789Go3 {
    private final C8575Wo0 a;
    private final Class b;

    /* renamed from: ir.nasim.Go3$a */
    class a extends AbstractC4789Go3 {
        final /* synthetic */ b c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C8575Wo0 c8575Wo0, Class cls, b bVar) {
            super(c8575Wo0, cls, null);
            this.c = bVar;
        }

        @Override // ir.nasim.AbstractC4789Go3
        public AbstractC14981io3 d(InterfaceC20931sq6 interfaceC20931sq6, C19060pi6 c19060pi6) {
            return this.c.a(interfaceC20931sq6, c19060pi6);
        }
    }

    /* renamed from: ir.nasim.Go3$b */
    public interface b {
        AbstractC14981io3 a(InterfaceC20931sq6 interfaceC20931sq6, C19060pi6 c19060pi6);
    }

    /* synthetic */ AbstractC4789Go3(C8575Wo0 c8575Wo0, Class cls, a aVar) {
        this(c8575Wo0, cls);
    }

    public static AbstractC4789Go3 a(b bVar, C8575Wo0 c8575Wo0, Class cls) {
        return new a(c8575Wo0, cls, bVar);
    }

    public final C8575Wo0 b() {
        return this.a;
    }

    public final Class c() {
        return this.b;
    }

    public abstract AbstractC14981io3 d(InterfaceC20931sq6 interfaceC20931sq6, C19060pi6 c19060pi6);

    private AbstractC4789Go3(C8575Wo0 c8575Wo0, Class cls) {
        this.a = c8575Wo0;
        this.b = cls;
    }
}
