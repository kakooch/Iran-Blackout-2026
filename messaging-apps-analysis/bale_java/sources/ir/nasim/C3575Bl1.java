package ir.nasim;

import android.content.Context;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* renamed from: ir.nasim.Bl1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C3575Bl1 {
    private final Set a = new CopyOnWriteArraySet();
    private volatile Context b;

    public final void a(InterfaceC10854cJ4 interfaceC10854cJ4) {
        AbstractC13042fc3.i(interfaceC10854cJ4, "listener");
        Context context = this.b;
        if (context != null) {
            interfaceC10854cJ4.a(context);
        }
        this.a.add(interfaceC10854cJ4);
    }

    public final void b() {
        this.b = null;
    }

    public final void c(Context context) {
        AbstractC13042fc3.i(context, "context");
        this.b = context;
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((InterfaceC10854cJ4) it.next()).a(context);
        }
    }
}
