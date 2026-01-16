package ir.nasim;

import kotlin.Metadata;

/* renamed from: ir.nasim.aM5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC9672aM5 {

    /* renamed from: ir.nasim.aM5$a */
    static final /* synthetic */ class a extends DB2 implements InterfaceC14603iB2 {
        public static final a a = new a();

        a() {
            super(2);
        }

        @Override // ir.nasim.AbstractC15785kA0, ir.nasim.InterfaceC9916am3
        public final String getName() {
            return "loadFunction";
        }

        @Override // ir.nasim.AbstractC15785kA0
        public final InterfaceC15551jm3 getOwner() {
            return AbstractC10882cM5.b(C21732u24.class);
        }

        @Override // ir.nasim.AbstractC15785kA0
        public final String getSignature() {
            return "loadFunction(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Function;)Lorg/jetbrains/kotlin/descriptors/SimpleFunctionDescriptor;";
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final JC6 invoke(C21732u24 c21732u24, C7950Tw5 c7950Tw5) {
            AbstractC13042fc3.i(c21732u24, "p1");
            AbstractC13042fc3.i(c7950Tw5, "p2");
            return c21732u24.n(c7950Tw5);
        }
    }

    public static final InterfaceC16733lm3 a(InterfaceC18751pB2 interfaceC18751pB2) {
        AbstractC13042fc3.i(interfaceC18751pB2, "$this$reflect");
        Metadata metadata = (Metadata) interfaceC18751pB2.getClass().getAnnotation(Metadata.class);
        if (metadata != null) {
            String[] strArrD1 = metadata.d1();
            if (strArrD1.length == 0) {
                strArrD1 = null;
            }
            if (strArrD1 != null) {
                XV4 xv4J = C8083Ul3.j(strArrD1, metadata.d2());
                C6664Ol3 c6664Ol3 = (C6664Ol3) xv4J.a();
                C7950Tw5 c7950Tw5 = (C7950Tw5) xv4J.b();
                C6404Nl3 c6404Nl3 = new C6404Nl3(metadata.mv(), (metadata.xi() & 8) != 0);
                Class<?> cls = interfaceC18751pB2.getClass();
                C12644ex5 c12644ex5J0 = c7950Tw5.j0();
                AbstractC13042fc3.h(c12644ex5J0, "proto.typeTable");
                JC6 jc6 = (JC6) AbstractC14729iN7.e(cls, c7950Tw5, c6664Ol3, new C7029Py7(c12644ex5J0), c6404Nl3, a.a);
                if (jc6 != null) {
                    return new C17324mm3(C17530n72.d, jc6);
                }
            }
        }
        return null;
    }
}
