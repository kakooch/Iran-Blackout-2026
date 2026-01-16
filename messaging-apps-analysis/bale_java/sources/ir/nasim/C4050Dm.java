package ir.nasim;

import android.content.Context;
import android.os.Bundle;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* renamed from: ir.nasim.Dm, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C4050Dm implements InterfaceC3816Cm {
    private static volatile InterfaceC3816Cm c;
    final C17002mE a;
    final Map b;

    C4050Dm(C17002mE c17002mE) {
        AbstractC3795Cj5.j(c17002mE);
        this.a = c17002mE;
        this.b = new ConcurrentHashMap();
    }

    public static InterfaceC3816Cm c(C5490Jo2 c5490Jo2, Context context, InterfaceC17465n07 interfaceC17465n07) {
        AbstractC3795Cj5.j(c5490Jo2);
        AbstractC3795Cj5.j(context);
        AbstractC3795Cj5.j(interfaceC17465n07);
        AbstractC3795Cj5.j(context.getApplicationContext());
        if (c == null) {
            synchronized (C4050Dm.class) {
                try {
                    if (c == null) {
                        Bundle bundle = new Bundle(1);
                        if (c5490Jo2.t()) {
                            interfaceC17465n07.b(AbstractC7964Ty1.class, new Executor() { // from class: ir.nasim.Yg8
                                @Override // java.util.concurrent.Executor
                                public final void execute(Runnable runnable) {
                                    runnable.run();
                                }
                            }, new InterfaceC7276Ra2() { // from class: ir.nasim.rj8
                                @Override // ir.nasim.InterfaceC7276Ra2
                                public final void a(AbstractC17203ma2 abstractC17203ma2) {
                                    C4050Dm.d(abstractC17203ma2);
                                }
                            });
                            bundle.putBoolean("dataCollectionDefaultEnabled", c5490Jo2.s());
                        }
                        c = new C4050Dm(C15566jn8.q(context, null, null, null, bundle).n());
                    }
                } finally {
                }
            }
        }
        return c;
    }

    static /* synthetic */ void d(AbstractC17203ma2 abstractC17203ma2) {
        throw null;
    }

    @Override // ir.nasim.InterfaceC3816Cm
    public void a(String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (Tk8.d(str) && Tk8.c(str2, bundle) && Tk8.b(str, str2, bundle)) {
            Tk8.a(str, str2, bundle);
            this.a.a(str, str2, bundle);
        }
    }

    @Override // ir.nasim.InterfaceC3816Cm
    public void b(String str, String str2, Object obj) {
        if (Tk8.d(str) && Tk8.e(str, str2)) {
            this.a.b(str, str2, obj);
        }
    }
}
