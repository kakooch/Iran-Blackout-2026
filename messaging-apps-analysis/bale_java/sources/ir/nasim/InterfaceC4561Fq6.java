package ir.nasim;

import java.util.List;
import kotlinx.serialization.KSerializer;

/* renamed from: ir.nasim.Fq6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public interface InterfaceC4561Fq6 {

    /* renamed from: ir.nasim.Fq6$a */
    public static final class a {

        /* renamed from: ir.nasim.Fq6$a$a, reason: collision with other inner class name */
        static final class C0378a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ KSerializer e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0378a(KSerializer kSerializer) {
                super(1);
                this.e = kSerializer;
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final KSerializer invoke(List list) {
                AbstractC13042fc3.i(list, "it");
                return this.e;
            }
        }

        public static void a(InterfaceC4561Fq6 interfaceC4561Fq6, InterfaceC11299cm3 interfaceC11299cm3, KSerializer kSerializer) {
            AbstractC13042fc3.i(interfaceC11299cm3, "kClass");
            AbstractC13042fc3.i(kSerializer, "serializer");
            interfaceC4561Fq6.c(interfaceC11299cm3, new C0378a(kSerializer));
        }
    }

    void a(InterfaceC11299cm3 interfaceC11299cm3, UA2 ua2);

    void b(InterfaceC11299cm3 interfaceC11299cm3, UA2 ua2);

    void c(InterfaceC11299cm3 interfaceC11299cm3, UA2 ua2);

    void d(InterfaceC11299cm3 interfaceC11299cm3, InterfaceC11299cm3 interfaceC11299cm32, KSerializer kSerializer);

    void e(InterfaceC11299cm3 interfaceC11299cm3, KSerializer kSerializer);
}
