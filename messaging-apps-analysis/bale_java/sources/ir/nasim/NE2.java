package ir.nasim;

import kotlinx.serialization.KSerializer;

/* loaded from: classes8.dex */
public interface NE2 extends KSerializer {

    public static final class a {
        public static KSerializer[] a(NE2 ne2) {
            return AbstractC20237rg5.a;
        }
    }

    KSerializer[] childSerializers();

    KSerializer[] typeParametersSerializers();
}
