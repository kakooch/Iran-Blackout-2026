package ir.nasim;

import java.util.Set;
import java.util.zip.ZipFile;

/* loaded from: classes3.dex */
final class Pp8 implements InterfaceC9974ar8 {
    final /* synthetic */ Set a;
    final /* synthetic */ Su8 b;
    final /* synthetic */ C25190zs8 c;

    Pp8(C25190zs8 c25190zs8, Set set, Su8 su8) {
        this.c = c25190zs8;
        this.a = set;
        this.b = su8;
    }

    @Override // ir.nasim.InterfaceC9974ar8
    public final void a(ZipFile zipFile, Set set) {
        this.a.addAll(C25190zs8.a(this.c, set, this.b, zipFile));
    }
}
