package androidx.camera.core.impl;

import android.util.Size;
import androidx.camera.core.impl.j;
import ir.nasim.AbstractC18238oK;
import ir.nasim.C22601vW5;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public interface o extends u {
    public static final j.a j = j.a.a("camerax.core.imageOutput.targetAspectRatio", AbstractC18238oK.class);
    public static final j.a k;
    public static final j.a l;
    public static final j.a m;
    public static final j.a n;
    public static final j.a o;
    public static final j.a p;
    public static final j.a q;
    public static final j.a r;
    public static final j.a s;

    static {
        Class cls = Integer.TYPE;
        k = j.a.a("camerax.core.imageOutput.targetRotation", cls);
        l = j.a.a("camerax.core.imageOutput.appTargetRotation", cls);
        m = j.a.a("camerax.core.imageOutput.mirrorMode", cls);
        n = j.a.a("camerax.core.imageOutput.targetResolution", Size.class);
        o = j.a.a("camerax.core.imageOutput.defaultResolution", Size.class);
        p = j.a.a("camerax.core.imageOutput.maxResolution", Size.class);
        q = j.a.a("camerax.core.imageOutput.supportedResolutions", List.class);
        r = j.a.a("camerax.core.imageOutput.resolutionSelector", C22601vW5.class);
        s = j.a.a("camerax.core.imageOutput.customOrderedResolutions", List.class);
    }

    static void u(o oVar) {
        boolean zX = oVar.x();
        boolean z = oVar.M(null) != null;
        if (zX && z) {
            throw new IllegalArgumentException("Cannot use both setTargetResolution and setTargetAspectRatio on the same config.");
        }
        if (oVar.G(null) != null) {
            if (zX || z) {
                throw new IllegalArgumentException("Cannot use setTargetResolution or setTargetAspectRatio with setResolutionSelector on the same config.");
            }
        }
    }

    default int A() {
        return ((Integer) a(j)).intValue();
    }

    default int C(int i) {
        return ((Integer) g(k, Integer.valueOf(i))).intValue();
    }

    default C22601vW5 G(C22601vW5 c22601vW5) {
        return (C22601vW5) g(r, c22601vW5);
    }

    default List H(List list) {
        List list2 = (List) g(s, list);
        if (list2 != null) {
            return new ArrayList(list2);
        }
        return null;
    }

    default Size I(Size size) {
        return (Size) g(o, size);
    }

    default Size M(Size size) {
        return (Size) g(n, size);
    }

    default int U(int i) {
        return ((Integer) g(m, Integer.valueOf(i))).intValue();
    }

    default Size i(Size size) {
        return (Size) g(p, size);
    }

    default List k(List list) {
        return (List) g(q, list);
    }

    default C22601vW5 l() {
        return (C22601vW5) a(r);
    }

    default int r(int i) {
        return ((Integer) g(l, Integer.valueOf(i))).intValue();
    }

    default boolean x() {
        return b(j);
    }
}
