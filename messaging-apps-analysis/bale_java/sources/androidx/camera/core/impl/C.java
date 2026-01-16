package androidx.camera.core.impl;

import android.util.Range;
import androidx.camera.core.impl.D;
import androidx.camera.core.impl.i;
import androidx.camera.core.impl.j;
import androidx.camera.core.impl.v;
import ir.nasim.InterfaceC24505yj7;
import ir.nasim.InterfaceC3513Be2;

/* loaded from: classes.dex */
public interface C extends InterfaceC24505yj7, n {
    public static final j.a A;
    public static final j.a B;
    public static final j.a C;
    public static final j.a D;
    public static final j.a t = j.a.a("camerax.core.useCase.defaultSessionConfig", v.class);
    public static final j.a u = j.a.a("camerax.core.useCase.defaultCaptureConfig", i.class);
    public static final j.a v = j.a.a("camerax.core.useCase.sessionConfigUnpacker", v.e.class);
    public static final j.a w = j.a.a("camerax.core.useCase.captureConfigUnpacker", i.b.class);
    public static final j.a x;
    public static final j.a y;
    public static final j.a z;

    public interface a extends InterfaceC3513Be2 {
        C b();
    }

    static {
        Class cls = Integer.TYPE;
        x = j.a.a("camerax.core.useCase.surfaceOccupancyPriority", cls);
        y = j.a.a("camerax.core.useCase.targetFrameRate", Range.class);
        Class cls2 = Boolean.TYPE;
        z = j.a.a("camerax.core.useCase.zslDisabled", cls2);
        A = j.a.a("camerax.core.useCase.highResolutionDisabled", cls2);
        B = j.a.a("camerax.core.useCase.captureType", D.b.class);
        C = j.a.a("camerax.core.useCase.previewStabilizationMode", cls);
        D = j.a.a("camerax.core.useCase.videoStabilizationMode", cls);
    }

    default int B() {
        return ((Integer) g(C, 0)).intValue();
    }

    default v J() {
        return (v) a(t);
    }

    default boolean K(boolean z2) {
        return ((Boolean) g(z, Boolean.valueOf(z2))).booleanValue();
    }

    default D.b N() {
        return (D.b) a(B);
    }

    default boolean S(boolean z2) {
        return ((Boolean) g(A, Boolean.valueOf(z2))).booleanValue();
    }

    default v.e T(v.e eVar) {
        return (v.e) g(v, eVar);
    }

    default v m(v vVar) {
        return (v) g(t, vVar);
    }

    default i.b o(i.b bVar) {
        return (i.b) g(w, bVar);
    }

    default i q(i iVar) {
        return (i) g(u, iVar);
    }

    default int v() {
        return ((Integer) g(D, 0)).intValue();
    }

    default Range w(Range range) {
        return (Range) g(y, range);
    }

    default int z(int i) {
        return ((Integer) g(x, Integer.valueOf(i))).intValue();
    }
}
