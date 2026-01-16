package kotlinx.serialization.encoding;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.XI1;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* loaded from: classes8.dex */
public interface Decoder {

    public static final class a {
        public static Object a(Decoder decoder, XI1 xi1) {
            AbstractC13042fc3.i(xi1, "deserializer");
            return xi1.deserialize(decoder);
        }
    }

    boolean C();

    byte G();

    c b(SerialDescriptor serialDescriptor);

    int e(SerialDescriptor serialDescriptor);

    int h();

    Void j();

    Object k(XI1 xi1);

    long m();

    Decoder q(SerialDescriptor serialDescriptor);

    short s();

    float t();

    double v();

    boolean w();

    char x();

    String y();
}
