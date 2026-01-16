package ir.nasim;

import ir.nasim.AbstractC12495ei5;
import ir.nasim.AbstractC19731qq6;
import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Encoder;

/* renamed from: ir.nasim.Ee6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C4219Ee6 extends AbstractC24673z1 {
    private final InterfaceC11299cm3 a;
    private List b;
    private final InterfaceC9173Yu3 c;
    private final Map d;
    private final Map e;

    /* renamed from: ir.nasim.Ee6$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ String e;
        final /* synthetic */ C4219Ee6 f;

        /* renamed from: ir.nasim.Ee6$a$a, reason: collision with other inner class name */
        static final class C0344a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ C4219Ee6 e;

            /* renamed from: ir.nasim.Ee6$a$a$a, reason: collision with other inner class name */
            static final class C0345a extends AbstractC8614Ws3 implements UA2 {
                final /* synthetic */ C4219Ee6 e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0345a(C4219Ee6 c4219Ee6) {
                    super(1);
                    this.e = c4219Ee6;
                }

                public final void a(FU0 fu0) {
                    AbstractC13042fc3.i(fu0, "$this$buildSerialDescriptor");
                    for (Map.Entry entry : this.e.e.entrySet()) {
                        FU0.b(fu0, (String) entry.getKey(), ((KSerializer) entry.getValue()).getDescriptor(), null, false, 12, null);
                    }
                }

                @Override // ir.nasim.UA2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((FU0) obj);
                    return C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0344a(C4219Ee6 c4219Ee6) {
                super(1);
                this.e = c4219Ee6;
            }

            public final void a(FU0 fu0) {
                AbstractC13042fc3.i(fu0, "$this$buildSerialDescriptor");
                FU0.b(fu0, "type", AbstractC18503om0.z(DY6.a).getDescriptor(), null, false, 12, null);
                FU0.b(fu0, "value", AbstractC17958nq6.b("kotlinx.serialization.Sealed<" + this.e.e().p() + '>', AbstractC19731qq6.a.a, new SerialDescriptor[0], new C0345a(this.e)), null, false, 12, null);
                fu0.h(this.e.b);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((FU0) obj);
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, C4219Ee6 c4219Ee6) {
            super(0);
            this.e = str;
            this.f = c4219Ee6;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final SerialDescriptor invoke() {
            return AbstractC17958nq6.b(this.e, AbstractC12495ei5.a.a, new SerialDescriptor[0], new C0344a(this.f));
        }
    }

    /* renamed from: ir.nasim.Ee6$b */
    public static final class b implements InterfaceC18868pO2 {
        final /* synthetic */ Iterable a;

        public b(Iterable iterable) {
            this.a = iterable;
        }

        @Override // ir.nasim.InterfaceC18868pO2
        public Object a(Object obj) {
            return ((KSerializer) ((Map.Entry) obj).getValue()).getDescriptor().i();
        }

        @Override // ir.nasim.InterfaceC18868pO2
        public Iterator b() {
            return this.a.iterator();
        }
    }

    public C4219Ee6(String str, InterfaceC11299cm3 interfaceC11299cm3, InterfaceC11299cm3[] interfaceC11299cm3Arr, KSerializer[] kSerializerArr) {
        AbstractC13042fc3.i(str, "serialName");
        AbstractC13042fc3.i(interfaceC11299cm3, "baseClass");
        AbstractC13042fc3.i(interfaceC11299cm3Arr, "subclasses");
        AbstractC13042fc3.i(kSerializerArr, "subclassSerializers");
        this.a = interfaceC11299cm3;
        this.b = AbstractC10360bX0.m();
        this.c = AbstractC13269fw3.b(EnumC4870Gx3.b, new a(str, this));
        if (interfaceC11299cm3Arr.length != kSerializerArr.length) {
            throw new IllegalArgumentException("All subclasses of sealed class " + e().p() + " should be marked @Serializable");
        }
        Map mapW = AbstractC20051rO3.w(AbstractC10242bK.u1(interfaceC11299cm3Arr, kSerializerArr));
        this.d = mapW;
        b bVar = new b(mapW.entrySet());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator itB = bVar.b();
        while (itB.hasNext()) {
            Object next = itB.next();
            Object objA = bVar.a(next);
            Object obj = linkedHashMap.get(objA);
            if (obj == null) {
                linkedHashMap.containsKey(objA);
            }
            Map.Entry entry = (Map.Entry) next;
            Map.Entry entry2 = (Map.Entry) obj;
            String str2 = (String) objA;
            if (entry2 != null) {
                throw new IllegalStateException(("Multiple sealed subclasses of '" + e() + "' have the same serial name '" + str2 + "': '" + entry2.getKey() + "', '" + entry.getKey() + '\'').toString());
            }
            linkedHashMap.put(objA, entry);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(AbstractC19460qO3.f(linkedHashMap.size()));
        for (Map.Entry entry3 : linkedHashMap.entrySet()) {
            linkedHashMap2.put(entry3.getKey(), (KSerializer) ((Map.Entry) entry3.getValue()).getValue());
        }
        this.e = linkedHashMap2;
    }

    @Override // ir.nasim.AbstractC24673z1
    public XI1 c(kotlinx.serialization.encoding.c cVar, String str) {
        AbstractC13042fc3.i(cVar, "decoder");
        KSerializer kSerializer = (KSerializer) this.e.get(str);
        return kSerializer != null ? kSerializer : super.c(cVar, str);
    }

    @Override // ir.nasim.AbstractC24673z1
    public InterfaceC22798vq6 d(Encoder encoder, Object obj) {
        AbstractC13042fc3.i(encoder, "encoder");
        AbstractC13042fc3.i(obj, "value");
        InterfaceC22798vq6 interfaceC22798vq6D = (KSerializer) this.d.get(AbstractC10882cM5.b(obj.getClass()));
        if (interfaceC22798vq6D == null) {
            interfaceC22798vq6D = super.d(encoder, obj);
        }
        if (interfaceC22798vq6D != null) {
            return interfaceC22798vq6D;
        }
        return null;
    }

    @Override // ir.nasim.AbstractC24673z1
    public InterfaceC11299cm3 e() {
        return this.a;
    }

    @Override // kotlinx.serialization.KSerializer, ir.nasim.InterfaceC22798vq6, ir.nasim.XI1
    public SerialDescriptor getDescriptor() {
        return (SerialDescriptor) this.c.getValue();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C4219Ee6(String str, InterfaceC11299cm3 interfaceC11299cm3, InterfaceC11299cm3[] interfaceC11299cm3Arr, KSerializer[] kSerializerArr, Annotation[] annotationArr) {
        this(str, interfaceC11299cm3, interfaceC11299cm3Arr, kSerializerArr);
        AbstractC13042fc3.i(str, "serialName");
        AbstractC13042fc3.i(interfaceC11299cm3, "baseClass");
        AbstractC13042fc3.i(interfaceC11299cm3Arr, "subclasses");
        AbstractC13042fc3.i(kSerializerArr, "subclassSerializers");
        AbstractC13042fc3.i(annotationArr, "classAnnotations");
        this.b = AbstractC9648aK.d(annotationArr);
    }
}
