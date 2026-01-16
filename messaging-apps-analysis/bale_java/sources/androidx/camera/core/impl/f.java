package androidx.camera.core.impl;

import androidx.camera.core.impl.j;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.I03;
import ir.nasim.InterfaceC12025du6;

/* loaded from: classes.dex */
public interface f extends u {
    public static final j.a a = j.a.a("camerax.core.camera.useCaseConfigFactory", D.class);
    public static final j.a b = j.a.a("camerax.core.camera.compatibilityId", I03.class);
    public static final j.a c = j.a.a("camerax.core.camera.useCaseCombinationRequiredRule", Integer.class);
    public static final j.a d = j.a.a("camerax.core.camera.SessionProcessor", InterfaceC12025du6.class);
    public static final j.a e = j.a.a("camerax.core.camera.isZslDisabled", Boolean.class);
    public static final j.a f = j.a.a("camerax.core.camera.isPostviewSupported", Boolean.class);
    public static final j.a g = j.a.a("camerax.core.camera.isCaptureProcessProgressSupported", Boolean.class);

    default InterfaceC12025du6 E(InterfaceC12025du6 interfaceC12025du6) {
        AbstractC18350oW3.a(g(d, interfaceC12025du6));
        return null;
    }

    default boolean L() {
        return ((Boolean) g(f, Boolean.FALSE)).booleanValue();
    }

    I03 Q();

    default boolean R() {
        return ((Boolean) g(g, Boolean.FALSE)).booleanValue();
    }

    default D j() {
        return (D) g(a, D.a);
    }

    default int t() {
        return ((Integer) g(c, 0)).intValue();
    }
}
