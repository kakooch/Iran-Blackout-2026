package kotlinx.serialization.encoding;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC3859Cq6;
import ir.nasim.InterfaceC22798vq6;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* loaded from: classes8.dex */
public interface Encoder {

    public static final class a {
        public static d a(Encoder encoder, SerialDescriptor serialDescriptor, int i) {
            AbstractC13042fc3.i(serialDescriptor, "descriptor");
            return encoder.b(serialDescriptor);
        }

        public static void b(Encoder encoder) {
        }

        public static void c(Encoder encoder, InterfaceC22798vq6 interfaceC22798vq6, Object obj) {
            AbstractC13042fc3.i(interfaceC22798vq6, "serializer");
            if (interfaceC22798vq6.getDescriptor().b()) {
                encoder.h(interfaceC22798vq6, obj);
            } else if (obj == null) {
                encoder.o();
            } else {
                encoder.v();
                encoder.h(interfaceC22798vq6, obj);
            }
        }

        public static void d(Encoder encoder, InterfaceC22798vq6 interfaceC22798vq6, Object obj) {
            AbstractC13042fc3.i(interfaceC22798vq6, "serializer");
            interfaceC22798vq6.serialize(encoder, obj);
        }
    }

    void A(int i);

    void F(String str);

    AbstractC3859Cq6 a();

    d b(SerialDescriptor serialDescriptor);

    void f(double d);

    void g(byte b);

    void h(InterfaceC22798vq6 interfaceC22798vq6, Object obj);

    d i(SerialDescriptor serialDescriptor, int i);

    void j(SerialDescriptor serialDescriptor, int i);

    Encoder k(SerialDescriptor serialDescriptor);

    void l(long j);

    void o();

    void q(short s);

    void r(boolean z);

    void t(float f);

    void u(char c);

    void v();
}
