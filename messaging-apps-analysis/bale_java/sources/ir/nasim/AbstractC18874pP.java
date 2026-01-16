package ir.nasim;

/* renamed from: ir.nasim.pP, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC18874pP {
    private final float a;

    /* renamed from: ir.nasim.pP$a */
    public static final class a extends AbstractC18874pP {
        public a() {
            super(0.5f, null);
        }
    }

    /* renamed from: ir.nasim.pP$b */
    public static final class b extends AbstractC18874pP {
        public b() {
            super(1.5f, null);
        }
    }

    /* renamed from: ir.nasim.pP$c */
    public static final class c extends AbstractC18874pP {
        public c() {
            super(1.0f, null);
        }
    }

    /* renamed from: ir.nasim.pP$d */
    public static final class d extends AbstractC18874pP {
        public d() {
            super(2.0f, null);
        }
    }

    public /* synthetic */ AbstractC18874pP(float f, ED1 ed1) {
        this(f);
    }

    public final float a() {
        return this.a;
    }

    private AbstractC18874pP(float f) {
        this.a = f;
    }
}
