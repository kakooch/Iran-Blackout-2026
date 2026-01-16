package ir.nasim;

import java.util.ServiceLoader;

/* renamed from: ir.nasim.gm0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public interface InterfaceC13757gm0 {
    public static final a a = a.a;

    /* renamed from: ir.nasim.gm0$a */
    public static final class a {
        static final /* synthetic */ a a = new a();
        private static final InterfaceC9173Yu3 b = AbstractC13269fw3.b(EnumC4870Gx3.b, C1258a.e);

        /* renamed from: ir.nasim.gm0$a$a, reason: collision with other inner class name */
        static final class C1258a extends AbstractC8614Ws3 implements SA2 {
            public static final C1258a e = new C1258a();

            C1258a() {
                super(0);
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final InterfaceC13757gm0 invoke() {
                ServiceLoader serviceLoaderLoad = ServiceLoader.load(InterfaceC13757gm0.class, InterfaceC13757gm0.class.getClassLoader());
                AbstractC13042fc3.h(serviceLoaderLoad, "implementations");
                InterfaceC13757gm0 interfaceC13757gm0 = (InterfaceC13757gm0) AbstractC15401jX0.r0(serviceLoaderLoad);
                if (interfaceC13757gm0 != null) {
                    return interfaceC13757gm0;
                }
                throw new IllegalStateException("No BuiltInsLoader implementation was found. Please ensure that the META-INF/services/ is not stripped from your application and that the Java virtual machine is not running under a security manager");
            }
        }

        private a() {
        }

        public final InterfaceC13757gm0 a() {
            return (InterfaceC13757gm0) b.getValue();
        }
    }

    AS4 a(ON6 on6, InterfaceC8507Wg4 interfaceC8507Wg4, Iterable iterable, InterfaceC8256Ve5 interfaceC8256Ve5, InterfaceC15427ja interfaceC15427ja, boolean z);
}
