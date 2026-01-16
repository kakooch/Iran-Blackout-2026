package ir.nasim;

import java.util.ArrayList;
import java.util.List;
import kotlinx.serialization.KSerializer;

/* renamed from: ir.nasim.gi5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C13722gi5 {
    private final InterfaceC11299cm3 a;
    private final KSerializer b;
    private final List c;
    private UA2 d;
    private UA2 e;

    public C13722gi5(InterfaceC11299cm3 interfaceC11299cm3, KSerializer kSerializer) {
        AbstractC13042fc3.i(interfaceC11299cm3, "baseClass");
        this.a = interfaceC11299cm3;
        this.b = kSerializer;
        this.c = new ArrayList();
    }

    public final void a(C4093Dq6 c4093Dq6) {
        AbstractC13042fc3.i(c4093Dq6, "builder");
        KSerializer kSerializer = this.b;
        if (kSerializer != null) {
            InterfaceC11299cm3 interfaceC11299cm3 = this.a;
            C4093Dq6.j(c4093Dq6, interfaceC11299cm3, interfaceC11299cm3, kSerializer, false, 8, null);
        }
        for (XV4 xv4 : this.c) {
            InterfaceC11299cm3 interfaceC11299cm32 = (InterfaceC11299cm3) xv4.a();
            KSerializer kSerializer2 = (KSerializer) xv4.b();
            InterfaceC11299cm3 interfaceC11299cm33 = this.a;
            AbstractC13042fc3.g(interfaceC11299cm32, "null cannot be cast to non-null type kotlin.reflect.KClass<Base of kotlinx.serialization.modules.PolymorphicModuleBuilder.buildTo$lambda$1>");
            AbstractC13042fc3.g(kSerializer2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            C4093Dq6.j(c4093Dq6, interfaceC11299cm33, interfaceC11299cm32, kSerializer2, false, 8, null);
        }
        UA2 ua2 = this.d;
        if (ua2 != null) {
            c4093Dq6.h(this.a, ua2, false);
        }
        UA2 ua22 = this.e;
        if (ua22 != null) {
            c4093Dq6.g(this.a, ua22, false);
        }
    }

    public final void b(InterfaceC11299cm3 interfaceC11299cm3, KSerializer kSerializer) {
        AbstractC13042fc3.i(interfaceC11299cm3, "subclass");
        AbstractC13042fc3.i(kSerializer, "serializer");
        this.c.add(AbstractC4616Fw7.a(interfaceC11299cm3, kSerializer));
    }
}
