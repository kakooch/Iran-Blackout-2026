package ir.nasim.core.runtime;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.display.DisplayManager;
import android.view.Display;
import ir.nasim.AbstractC12281eL6;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C19406qI3;
import ir.nasim.DJ;
import ir.nasim.ED1;
import ir.nasim.InterfaceC10258bL6;
import ir.nasim.InterfaceC9336Zm4;
import java.util.Iterator;

/* loaded from: classes5.dex */
public final class ScreenStateObserver {
    public static final a d = new a(null);
    private final Context a;
    private final InterfaceC9336Zm4 b;
    private final InterfaceC10258bL6 c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public ScreenStateObserver(Context context) {
        AbstractC13042fc3.i(context, "context");
        this.a = context;
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(Boolean.FALSE);
        this.b = interfaceC9336Zm4A;
        this.c = interfaceC9336Zm4A;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        context.registerReceiver(new BroadcastReceiver() { // from class: ir.nasim.core.runtime.ScreenStateObserver.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                AbstractC13042fc3.i(context2, "context");
                AbstractC13042fc3.i(intent, "intent");
                ScreenStateObserver.this.b(intent);
            }
        }, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(Intent intent) {
        if (AbstractC13042fc3.d(intent.getAction(), "android.intent.action.SCREEN_ON") || d()) {
            C19406qI3.b("ScreenStateObserver", "screen on");
            this.b.setValue(Boolean.TRUE);
        } else if (AbstractC13042fc3.d(intent.getAction(), "android.intent.action.SCREEN_OFF") || !d()) {
            C19406qI3.b("ScreenStateObserver", "screen off");
            this.b.setValue(Boolean.FALSE);
        }
    }

    private final boolean d() {
        Object systemService = this.a.getSystemService("display");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.hardware.display.DisplayManager");
        Iterator itA = DJ.a(((DisplayManager) systemService).getDisplays());
        boolean z = false;
        while (itA.hasNext()) {
            if (((Display) itA.next()).getState() != 1) {
                z = true;
            }
        }
        return z;
    }

    public final InterfaceC10258bL6 c() {
        return this.c;
    }
}
