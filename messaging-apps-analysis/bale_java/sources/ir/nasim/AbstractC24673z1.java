package ir.nasim;

import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.encoding.c;

/* renamed from: ir.nasim.z1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC24673z1 implements KSerializer {
    /* JADX INFO: Access modifiers changed from: private */
    public final Object b(kotlinx.serialization.encoding.c cVar) {
        return c.a.c(cVar, getDescriptor(), 1, AbstractC14313hi5.a(this, cVar, cVar.n(getDescriptor(), 0)), null, 8, null);
    }

    public XI1 c(kotlinx.serialization.encoding.c cVar, String str) {
        AbstractC13042fc3.i(cVar, "decoder");
        return cVar.a().d(e(), str);
    }

    public InterfaceC22798vq6 d(Encoder encoder, Object obj) {
        AbstractC13042fc3.i(encoder, "encoder");
        AbstractC13042fc3.i(obj, "value");
        return encoder.a().e(e(), obj);
    }

    @Override // ir.nasim.XI1
    public final Object deserialize(Decoder decoder) {
        Object objC;
        AbstractC13042fc3.i(decoder, "decoder");
        SerialDescriptor descriptor = getDescriptor();
        kotlinx.serialization.encoding.c cVarB = decoder.b(descriptor);
        C12889fL5 c12889fL5 = new C12889fL5();
        if (cVarB.p()) {
            objC = b(cVarB);
        } else {
            objC = null;
            while (true) {
                int iO = cVarB.o(getDescriptor());
                if (iO != -1) {
                    if (iO == 0) {
                        c12889fL5.a = cVarB.n(getDescriptor(), iO);
                    } else {
                        if (iO != 1) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Invalid index in polymorphic deserialization of ");
                            String str = (String) c12889fL5.a;
                            if (str == null) {
                                str = "unknown class";
                            }
                            sb.append(str);
                            sb.append("\n Expected 0, 1 or DECODE_DONE(-1), but found ");
                            sb.append(iO);
                            throw new SerializationException(sb.toString());
                        }
                        Object obj = c12889fL5.a;
                        if (obj == null) {
                            throw new IllegalArgumentException("Cannot read polymorphic value before its type token".toString());
                        }
                        c12889fL5.a = obj;
                        objC = c.a.c(cVarB, getDescriptor(), iO, AbstractC14313hi5.a(this, cVarB, (String) obj), null, 8, null);
                    }
                } else {
                    if (objC == null) {
                        throw new IllegalArgumentException(("Polymorphic value has not been read for class " + ((String) c12889fL5.a)).toString());
                    }
                    AbstractC13042fc3.g(objC, "null cannot be cast to non-null type T of kotlinx.serialization.internal.AbstractPolymorphicSerializer.deserialize$lambda$3");
                }
            }
        }
        cVarB.c(descriptor);
        return objC;
    }

    public abstract InterfaceC11299cm3 e();

    @Override // ir.nasim.InterfaceC22798vq6
    public final void serialize(Encoder encoder, Object obj) {
        AbstractC13042fc3.i(encoder, "encoder");
        AbstractC13042fc3.i(obj, "value");
        InterfaceC22798vq6 interfaceC22798vq6B = AbstractC14313hi5.b(this, encoder, obj);
        SerialDescriptor descriptor = getDescriptor();
        kotlinx.serialization.encoding.d dVarB = encoder.b(descriptor);
        dVarB.y(getDescriptor(), 0, interfaceC22798vq6B.getDescriptor().i());
        SerialDescriptor descriptor2 = getDescriptor();
        AbstractC13042fc3.g(interfaceC22798vq6B, "null cannot be cast to non-null type kotlinx.serialization.SerializationStrategy<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        dVarB.B(descriptor2, 1, interfaceC22798vq6B, obj);
        dVarB.c(descriptor);
    }
}
