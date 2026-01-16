package kotlinx.serialization.descriptors;

import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC19731qq6;
import java.util.List;

/* loaded from: classes8.dex */
public interface SerialDescriptor {

    public static final class a {
        public static List a(SerialDescriptor serialDescriptor) {
            return AbstractC10360bX0.m();
        }

        public static boolean b(SerialDescriptor serialDescriptor) {
            return false;
        }

        public static boolean c(SerialDescriptor serialDescriptor) {
            return false;
        }
    }

    boolean b();

    int c(String str);

    int d();

    String e(int i);

    AbstractC19731qq6 f();

    List g(int i);

    List getAnnotations();

    SerialDescriptor h(int i);

    String i();

    boolean isInline();

    boolean j(int i);
}
