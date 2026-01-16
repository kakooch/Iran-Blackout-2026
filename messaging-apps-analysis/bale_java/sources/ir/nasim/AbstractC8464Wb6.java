package ir.nasim;

/* renamed from: ir.nasim.Wb6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC8464Wb6 {
    private static final InterfaceC8230Vb6 a = a(a.e, b.e);

    /* renamed from: ir.nasim.Wb6$c */
    public static final class c implements InterfaceC8230Vb6 {
        final /* synthetic */ InterfaceC14603iB2 a;
        final /* synthetic */ UA2 b;

        c(InterfaceC14603iB2 interfaceC14603iB2, UA2 ua2) {
            this.a = interfaceC14603iB2;
            this.b = ua2;
        }

        @Override // ir.nasim.InterfaceC8230Vb6
        public Object a(InterfaceC8730Xb6 interfaceC8730Xb6, Object obj) {
            return this.a.invoke(interfaceC8730Xb6, obj);
        }

        @Override // ir.nasim.InterfaceC8230Vb6
        public Object b(Object obj) {
            return this.b.invoke(obj);
        }
    }

    public static final InterfaceC8230Vb6 a(InterfaceC14603iB2 interfaceC14603iB2, UA2 ua2) {
        return new c(interfaceC14603iB2, ua2);
    }

    public static final InterfaceC8230Vb6 b() {
        InterfaceC8230Vb6 interfaceC8230Vb6 = a;
        AbstractC13042fc3.g(interfaceC8230Vb6, "null cannot be cast to non-null type androidx.compose.runtime.saveable.Saver<T of androidx.compose.runtime.saveable.SaverKt.autoSaver, kotlin.Any>");
        return interfaceC8230Vb6;
    }

    /* renamed from: ir.nasim.Wb6$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        public static final b e = new b();

        b() {
            super(1);
        }

        @Override // ir.nasim.UA2
        public final Object invoke(Object obj) {
            return obj;
        }
    }

    /* renamed from: ir.nasim.Wb6$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final a e = new a();

        a() {
            super(2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC8730Xb6 interfaceC8730Xb6, Object obj) {
            return obj;
        }
    }
}
