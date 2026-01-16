package ir.nasim;

import ir.nasim.InterfaceC19365qD7;
import ir.nasim.InterfaceC9905al2;
import ir.nasim.MX1;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.xf4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C23872xf4 implements InterfaceC23282wf4 {
    private final OK a;

    public C23872xf4(OK ok) {
        AbstractC13042fc3.i(ok, "downloadedAsyncKeyValueEngine");
        this.a = ok;
    }

    @Override // ir.nasim.InterfaceC23282wf4
    public void a(MX1.a aVar, InterfaceC19365qD7 interfaceC19365qD7) {
        AbstractC13042fc3.i(aVar, "standardDownloadInput");
        AbstractC13042fc3.i(interfaceC19365qD7, "downloadState");
        if (interfaceC19365qD7 instanceof InterfaceC19365qD7.a) {
            this.a.e(new C10405bZ1(aVar.c().b(), (int) aVar.b(), ((InterfaceC9905al2.a) ((InterfaceC19365qD7.a) interfaceC19365qD7).a()).a()));
        } else if (!(interfaceC19365qD7 instanceof InterfaceC19365qD7.b)) {
            throw new NoWhenBranchMatchedException();
        }
    }
}
