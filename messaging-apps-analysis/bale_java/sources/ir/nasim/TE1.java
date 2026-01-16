package ir.nasim;

import ir.nasim.InterfaceC17505n47;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public class TE1 implements InterfaceC3733Cc6 {
    private static final Logger f = Logger.getLogger(C7470Rv7.class.getName());
    private final InterfaceC16628lb8 a;
    private final Executor b;
    private final XV c;
    private final InterfaceC13031fb2 d;
    private final InterfaceC17505n47 e;

    public TE1(Executor executor, XV xv, InterfaceC16628lb8 interfaceC16628lb8, InterfaceC13031fb2 interfaceC13031fb2, InterfaceC17505n47 interfaceC17505n47) {
        this.b = executor;
        this.c = xv;
        this.a = interfaceC16628lb8;
        this.d = interfaceC13031fb2;
        this.e = interfaceC17505n47;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object d(AbstractC5792Kv7 abstractC5792Kv7, AbstractC7747Ta2 abstractC7747Ta2) {
        this.d.G0(abstractC5792Kv7, abstractC7747Ta2);
        this.a.b(abstractC5792Kv7, 1);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(final AbstractC5792Kv7 abstractC5792Kv7, InterfaceC8177Uv7 interfaceC8177Uv7, AbstractC7747Ta2 abstractC7747Ta2) {
        try {
            InterfaceC5558Jv7 interfaceC5558Jv7 = this.c.get(abstractC5792Kv7.b());
            if (interfaceC5558Jv7 == null) {
                String str = String.format("Transport backend '%s' is not registered", abstractC5792Kv7.b());
                f.warning(str);
                interfaceC8177Uv7.a(new IllegalArgumentException(str));
            } else {
                final AbstractC7747Ta2 abstractC7747Ta2B = interfaceC5558Jv7.b(abstractC7747Ta2);
                this.e.a(new InterfaceC17505n47.a() { // from class: ir.nasim.RE1
                    @Override // ir.nasim.InterfaceC17505n47.a
                    public final Object execute() {
                        return this.a.d(abstractC5792Kv7, abstractC7747Ta2B);
                    }
                });
                interfaceC8177Uv7.a(null);
            }
        } catch (Exception e) {
            f.warning("Error scheduling event " + e.getMessage());
            interfaceC8177Uv7.a(e);
        }
    }

    @Override // ir.nasim.InterfaceC3733Cc6
    public void a(final AbstractC5792Kv7 abstractC5792Kv7, final AbstractC7747Ta2 abstractC7747Ta2, final InterfaceC8177Uv7 interfaceC8177Uv7) {
        this.b.execute(new Runnable() { // from class: ir.nasim.QE1
            @Override // java.lang.Runnable
            public final void run() {
                this.a.e(abstractC5792Kv7, interfaceC8177Uv7, abstractC7747Ta2);
            }
        });
    }
}
