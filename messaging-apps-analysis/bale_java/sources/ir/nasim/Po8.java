package ir.nasim;

import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipFile;

/* loaded from: classes3.dex */
final class Po8 implements InterfaceC9974ar8 {
    final /* synthetic */ Su8 a;
    final /* synthetic */ Set b;
    final /* synthetic */ AtomicBoolean c;
    final /* synthetic */ C25190zs8 d;

    Po8(C25190zs8 c25190zs8, Su8 su8, Set set, AtomicBoolean atomicBoolean) {
        this.d = c25190zs8;
        this.a = su8;
        this.b = set;
        this.c = atomicBoolean;
    }

    @Override // ir.nasim.InterfaceC9974ar8
    public final void a(ZipFile zipFile, Set set) {
        this.d.f(this.a, set, new C14378ho8(this));
    }
}
