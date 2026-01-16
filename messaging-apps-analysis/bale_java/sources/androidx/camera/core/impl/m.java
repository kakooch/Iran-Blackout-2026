package androidx.camera.core.impl;

import androidx.camera.core.impl.j;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.C22601vW5;
import ir.nasim.C24677z13;
import ir.nasim.DF0;
import ir.nasim.InterfaceC25045ze3;
import ir.nasim.P23;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class m implements C, o, InterfaceC25045ze3 {
    public static final j.a I;
    public static final j.a J;
    public static final j.a K;
    public static final j.a L;
    public static final j.a M;
    public static final j.a N;
    public static final j.a O;
    public static final j.a P;
    public static final j.a Q;
    public static final j.a R;
    public static final j.a S;
    public static final j.a T;
    public static final j.a U;
    private final r H;

    static {
        Class cls = Integer.TYPE;
        I = j.a.a("camerax.core.imageCapture.captureMode", cls);
        J = j.a.a("camerax.core.imageCapture.flashMode", cls);
        K = j.a.a("camerax.core.imageCapture.captureBundle", DF0.class);
        L = j.a.a("camerax.core.imageCapture.bufferFormat", Integer.class);
        M = j.a.a("camerax.core.imageCapture.outputFormat", Integer.class);
        N = j.a.a("camerax.core.imageCapture.maxCaptureStages", Integer.class);
        O = j.a.a("camerax.core.imageCapture.imageReaderProxyProvider", P23.class);
        P = j.a.a("camerax.core.imageCapture.useSoftwareJpegEncoder", Boolean.TYPE);
        Q = j.a.a("camerax.core.imageCapture.flashType", cls);
        R = j.a.a("camerax.core.imageCapture.jpegCompressionQuality", cls);
        S = j.a.a("camerax.core.imageCapture.screenFlash", C24677z13.f.class);
        T = j.a.a("camerax.core.useCase.postviewResolutionSelector", C22601vW5.class);
        U = j.a.a("camerax.core.useCase.isPostviewEnabled", Boolean.class);
    }

    public m(r rVar) {
        this.H = rVar;
    }

    public int V() {
        return ((Integer) a(I)).intValue();
    }

    public int W(int i) {
        return ((Integer) g(J, Integer.valueOf(i))).intValue();
    }

    public int X(int i) {
        return ((Integer) g(Q, Integer.valueOf(i))).intValue();
    }

    public P23 Y() {
        AbstractC18350oW3.a(g(O, null));
        return null;
    }

    public Executor Z(Executor executor) {
        return (Executor) g(InterfaceC25045ze3.E, executor);
    }

    public C24677z13.f a0() {
        return (C24677z13.f) g(S, null);
    }

    public boolean b0() {
        return b(I);
    }

    @Override // androidx.camera.core.impl.u
    public j getConfig() {
        return this.H;
    }

    @Override // androidx.camera.core.impl.n
    public int getInputFormat() {
        return ((Integer) a(n.h)).intValue();
    }
}
