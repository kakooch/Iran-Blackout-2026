package ir.nasim;

import ir.nasim.InterfaceC17505n47;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public class Wa8 {
    private final Executor a;
    private final InterfaceC13031fb2 b;
    private final InterfaceC16628lb8 c;
    private final InterfaceC17505n47 d;

    Wa8(Executor executor, InterfaceC13031fb2 interfaceC13031fb2, InterfaceC16628lb8 interfaceC16628lb8, InterfaceC17505n47 interfaceC17505n47) {
        this.a = executor;
        this.b = interfaceC13031fb2;
        this.c = interfaceC16628lb8;
        this.d = interfaceC17505n47;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object d() {
        Iterator it = this.b.b0().iterator();
        while (it.hasNext()) {
            this.c.b((AbstractC5792Kv7) it.next(), 1);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        this.d.a(new InterfaceC17505n47.a() { // from class: ir.nasim.Va8
            @Override // ir.nasim.InterfaceC17505n47.a
            public final Object execute() {
                return this.a.d();
            }
        });
    }

    public void c() {
        this.a.execute(new Runnable() { // from class: ir.nasim.Ua8
            @Override // java.lang.Runnable
            public final void run() {
                this.a.e();
            }
        });
    }
}
