package kotlinx.serialization.encoding;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC3859Cq6;
import ir.nasim.XI1;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* loaded from: classes8.dex */
public interface c {

    public static final class a {
        public static int a(c cVar, SerialDescriptor serialDescriptor) {
            AbstractC13042fc3.i(serialDescriptor, "descriptor");
            return -1;
        }

        public static boolean b(c cVar) {
            return false;
        }

        public static /* synthetic */ Object c(c cVar, SerialDescriptor serialDescriptor, int i, XI1 xi1, Object obj, int i2, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeSerializableElement");
            }
            if ((i2 & 8) != 0) {
                obj = null;
            }
            return cVar.E(serialDescriptor, i, xi1, obj);
        }
    }

    byte A(SerialDescriptor serialDescriptor, int i);

    boolean B(SerialDescriptor serialDescriptor, int i);

    short D(SerialDescriptor serialDescriptor, int i);

    Object E(SerialDescriptor serialDescriptor, int i, XI1 xi1, Object obj);

    double F(SerialDescriptor serialDescriptor, int i);

    Object H(SerialDescriptor serialDescriptor, int i, XI1 xi1, Object obj);

    AbstractC3859Cq6 a();

    void c(SerialDescriptor serialDescriptor);

    long f(SerialDescriptor serialDescriptor, int i);

    int i(SerialDescriptor serialDescriptor, int i);

    int l(SerialDescriptor serialDescriptor);

    String n(SerialDescriptor serialDescriptor, int i);

    int o(SerialDescriptor serialDescriptor);

    boolean p();

    Decoder r(SerialDescriptor serialDescriptor, int i);

    float u(SerialDescriptor serialDescriptor, int i);

    char z(SerialDescriptor serialDescriptor, int i);
}
