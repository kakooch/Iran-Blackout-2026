package ir.nasim;

import ir.nasim.AbstractC19686qm1;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.KSerializer;

/* renamed from: ir.nasim.rq6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C20340rq6 extends AbstractC3859Cq6 {
    private final Map a;
    public final Map b;
    private final Map c;
    private final Map d;
    private final Map e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C20340rq6(Map map, Map map2, Map map3, Map map4, Map map5) {
        super(null);
        AbstractC13042fc3.i(map, "class2ContextualFactory");
        AbstractC13042fc3.i(map2, "polyBase2Serializers");
        AbstractC13042fc3.i(map3, "polyBase2DefaultSerializerProvider");
        AbstractC13042fc3.i(map4, "polyBase2NamedSerializers");
        AbstractC13042fc3.i(map5, "polyBase2DefaultDeserializerProvider");
        this.a = map;
        this.b = map2;
        this.c = map3;
        this.d = map4;
        this.e = map5;
    }

    @Override // ir.nasim.AbstractC3859Cq6
    public void a(InterfaceC4561Fq6 interfaceC4561Fq6) {
        AbstractC13042fc3.i(interfaceC4561Fq6, "collector");
        for (Map.Entry entry : this.a.entrySet()) {
            InterfaceC11299cm3 interfaceC11299cm3 = (InterfaceC11299cm3) entry.getKey();
            AbstractC19686qm1 abstractC19686qm1 = (AbstractC19686qm1) entry.getValue();
            if (abstractC19686qm1 instanceof AbstractC19686qm1.a) {
                AbstractC13042fc3.g(interfaceC11299cm3, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                KSerializer kSerializerB = ((AbstractC19686qm1.a) abstractC19686qm1).b();
                AbstractC13042fc3.g(kSerializerB, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
                interfaceC4561Fq6.e(interfaceC11299cm3, kSerializerB);
            } else if (abstractC19686qm1 instanceof AbstractC19686qm1.b) {
                interfaceC4561Fq6.c(interfaceC11299cm3, ((AbstractC19686qm1.b) abstractC19686qm1).b());
            }
        }
        for (Map.Entry entry2 : this.b.entrySet()) {
            InterfaceC11299cm3 interfaceC11299cm32 = (InterfaceC11299cm3) entry2.getKey();
            for (Map.Entry entry3 : ((Map) entry2.getValue()).entrySet()) {
                InterfaceC11299cm3 interfaceC11299cm33 = (InterfaceC11299cm3) entry3.getKey();
                KSerializer kSerializer = (KSerializer) entry3.getValue();
                AbstractC13042fc3.g(interfaceC11299cm32, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                AbstractC13042fc3.g(interfaceC11299cm33, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                AbstractC13042fc3.g(kSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                interfaceC4561Fq6.d(interfaceC11299cm32, interfaceC11299cm33, kSerializer);
            }
        }
        for (Map.Entry entry4 : this.c.entrySet()) {
            InterfaceC11299cm3 interfaceC11299cm34 = (InterfaceC11299cm3) entry4.getKey();
            UA2 ua2 = (UA2) entry4.getValue();
            AbstractC13042fc3.g(interfaceC11299cm34, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
            AbstractC13042fc3.g(ua2, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'value')] kotlin.Any, kotlinx.serialization.SerializationStrategy<kotlin.Any>?>{ kotlinx.serialization.modules.SerializersModuleKt.PolymorphicSerializerProvider<kotlin.Any> }");
            interfaceC4561Fq6.b(interfaceC11299cm34, (UA2) AbstractC19810qy7.g(ua2, 1));
        }
        for (Map.Entry entry5 : this.e.entrySet()) {
            InterfaceC11299cm3 interfaceC11299cm35 = (InterfaceC11299cm3) entry5.getKey();
            UA2 ua22 = (UA2) entry5.getValue();
            AbstractC13042fc3.g(interfaceC11299cm35, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
            AbstractC13042fc3.g(ua22, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'className')] kotlin.String?, kotlinx.serialization.DeserializationStrategy<out kotlin.Any>?>{ kotlinx.serialization.modules.SerializersModuleKt.PolymorphicDeserializerProvider<out kotlin.Any> }");
            interfaceC4561Fq6.a(interfaceC11299cm35, (UA2) AbstractC19810qy7.g(ua22, 1));
        }
    }

    @Override // ir.nasim.AbstractC3859Cq6
    public KSerializer b(InterfaceC11299cm3 interfaceC11299cm3, List list) {
        AbstractC13042fc3.i(interfaceC11299cm3, "kClass");
        AbstractC13042fc3.i(list, "typeArgumentsSerializers");
        AbstractC19686qm1 abstractC19686qm1 = (AbstractC19686qm1) this.a.get(interfaceC11299cm3);
        KSerializer kSerializerA = abstractC19686qm1 != null ? abstractC19686qm1.a(list) : null;
        if (kSerializerA instanceof KSerializer) {
            return kSerializerA;
        }
        return null;
    }

    @Override // ir.nasim.AbstractC3859Cq6
    public XI1 d(InterfaceC11299cm3 interfaceC11299cm3, String str) {
        AbstractC13042fc3.i(interfaceC11299cm3, "baseClass");
        Map map = (Map) this.d.get(interfaceC11299cm3);
        KSerializer kSerializer = map != null ? (KSerializer) map.get(str) : null;
        if (!(kSerializer instanceof KSerializer)) {
            kSerializer = null;
        }
        if (kSerializer != null) {
            return kSerializer;
        }
        Object obj = this.e.get(interfaceC11299cm3);
        UA2 ua2 = AbstractC19810qy7.o(obj, 1) ? (UA2) obj : null;
        if (ua2 != null) {
            return (XI1) ua2.invoke(str);
        }
        return null;
    }

    @Override // ir.nasim.AbstractC3859Cq6
    public InterfaceC22798vq6 e(InterfaceC11299cm3 interfaceC11299cm3, Object obj) {
        AbstractC13042fc3.i(interfaceC11299cm3, "baseClass");
        AbstractC13042fc3.i(obj, "value");
        if (!interfaceC11299cm3.k(obj)) {
            return null;
        }
        Map map = (Map) this.b.get(interfaceC11299cm3);
        KSerializer kSerializer = map != null ? (KSerializer) map.get(AbstractC10882cM5.b(obj.getClass())) : null;
        if (!(kSerializer instanceof InterfaceC22798vq6)) {
            kSerializer = null;
        }
        if (kSerializer != null) {
            return kSerializer;
        }
        Object obj2 = this.c.get(interfaceC11299cm3);
        UA2 ua2 = AbstractC19810qy7.o(obj2, 1) ? (UA2) obj2 : null;
        if (ua2 != null) {
            return (InterfaceC22798vq6) ua2.invoke(obj);
        }
        return null;
    }
}
