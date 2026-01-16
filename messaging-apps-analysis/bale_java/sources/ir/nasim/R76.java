package ir.nasim;

import ir.nasim.InterfaceC13330g27;
import java.io.File;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class R76 implements InterfaceC13330g27.c {
    private final String a;
    private final File b;
    private final Callable c;
    private final InterfaceC13330g27.c d;

    public R76(String str, File file, Callable callable, InterfaceC13330g27.c cVar) {
        AbstractC13042fc3.i(cVar, "mDelegate");
        this.a = str;
        this.b = file;
        this.c = callable;
        this.d = cVar;
    }

    @Override // ir.nasim.InterfaceC13330g27.c
    public InterfaceC13330g27 a(InterfaceC13330g27.b bVar) {
        AbstractC13042fc3.i(bVar, "configuration");
        return new Q76(bVar.a, this.a, this.b, this.c, bVar.c.a, this.d.a(bVar));
    }
}
