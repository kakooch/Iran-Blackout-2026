package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.gJ1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public interface InterfaceC13485gJ1 extends InterfaceC12795fB1, InterfaceC21058t24 {

    /* renamed from: ir.nasim.gJ1$a */
    public enum a {
        COMPATIBLE,
        NEEDS_WRAPPER,
        INCOMPATIBLE;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static a[] valuesCustom() {
            a[] aVarArrValuesCustom = values();
            a[] aVarArr = new a[aVarArrValuesCustom.length];
            System.arraycopy(aVarArrValuesCustom, 0, aVarArr, 0, aVarArrValuesCustom.length);
            return aVarArr;
        }
    }

    /* renamed from: ir.nasim.gJ1$b */
    public static final class b {
        public static List a(InterfaceC13485gJ1 interfaceC13485gJ1) {
            AbstractC13042fc3.i(interfaceC13485gJ1, "this");
            return C10322bS7.f.b(interfaceC13485gJ1.g0(), interfaceC13485gJ1.K(), interfaceC13485gJ1.I());
        }
    }

    C7029Py7 E();

    List G0();

    C10938cS7 I();

    InterfaceC6692Oo4 K();

    InterfaceC12258eJ1 L();

    kotlin.reflect.jvm.internal.impl.protobuf.l g0();
}
