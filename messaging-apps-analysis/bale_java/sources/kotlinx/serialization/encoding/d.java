package kotlinx.serialization.encoding;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.InterfaceC22798vq6;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* loaded from: classes8.dex */
public interface d {

    public static final class a {
        public static boolean a(d dVar, SerialDescriptor serialDescriptor, int i) {
            AbstractC13042fc3.i(serialDescriptor, "descriptor");
            return true;
        }
    }

    void B(SerialDescriptor serialDescriptor, int i, InterfaceC22798vq6 interfaceC22798vq6, Object obj);

    void C(SerialDescriptor serialDescriptor, int i, short s);

    void D(SerialDescriptor serialDescriptor, int i, double d);

    void E(SerialDescriptor serialDescriptor, int i, long j);

    void c(SerialDescriptor serialDescriptor);

    Encoder e(SerialDescriptor serialDescriptor, int i);

    void m(SerialDescriptor serialDescriptor, int i, InterfaceC22798vq6 interfaceC22798vq6, Object obj);

    void n(SerialDescriptor serialDescriptor, int i, char c);

    void p(SerialDescriptor serialDescriptor, int i, byte b);

    void s(SerialDescriptor serialDescriptor, int i, float f);

    void w(SerialDescriptor serialDescriptor, int i, int i2);

    void x(SerialDescriptor serialDescriptor, int i, boolean z);

    void y(SerialDescriptor serialDescriptor, int i, String str);

    boolean z(SerialDescriptor serialDescriptor, int i);
}
