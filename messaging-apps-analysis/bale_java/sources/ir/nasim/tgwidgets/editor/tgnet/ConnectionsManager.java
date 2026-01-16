package ir.nasim.tgwidgets.editor.tgnet;

import ir.nasim.AbstractC12724f57;
import ir.nasim.F90;
import ir.nasim.Ib8;
import ir.nasim.InterfaceC5124Hz5;
import ir.nasim.JQ5;
import ir.nasim.LQ5;
import ir.nasim.tgwidgets.editor.messenger.Utilities;

/* loaded from: classes7.dex */
public class ConnectionsManager extends F90 {
    public static final int c = Runtime.getRuntime().availableProcessors();
    private static int d = 1;
    private static final ConnectionsManager[] e = new ConnectionsManager[1];

    public ConnectionsManager(int i) {
        super(i);
    }

    public static ConnectionsManager k(int i) {
        ConnectionsManager[] connectionsManagerArr = e;
        ConnectionsManager connectionsManager = connectionsManagerArr[i];
        if (connectionsManager == null) {
            synchronized (ConnectionsManager.class) {
                try {
                    connectionsManager = connectionsManagerArr[i];
                    if (connectionsManager == null) {
                        connectionsManager = new ConnectionsManager(i);
                        connectionsManagerArr[i] = connectionsManager;
                    }
                } finally {
                }
            }
        }
        return connectionsManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(int i, boolean z) {
        native_cancelRequest(this.a, i, z);
    }

    public static native void native_cancelRequest(int i, int i2, boolean z);

    public static native void native_discardConnection(int i, int i2, int i3);

    public static native void native_failNotRunningRequest(int i, int i2);

    public void i(final int i, final boolean z) {
        Utilities.f().i(new Runnable() { // from class: ir.nasim.Cd1
            @Override // java.lang.Runnable
            public final void run() {
                this.a.l(i, z);
            }
        });
    }

    public int j() {
        return 0;
    }

    public int m(AbstractC12724f57 abstractC12724f57, JQ5 jq5) {
        return n(abstractC12724f57, jq5, null, 0);
    }

    public int n(AbstractC12724f57 abstractC12724f57, JQ5 jq5, InterfaceC5124Hz5 interfaceC5124Hz5, int i) {
        return o(abstractC12724f57, jq5, null, interfaceC5124Hz5, null, i, Integer.MAX_VALUE, 1, true);
    }

    public int o(AbstractC12724f57 abstractC12724f57, JQ5 jq5, LQ5 lq5, InterfaceC5124Hz5 interfaceC5124Hz5, Ib8 ib8, int i, int i2, int i3, boolean z) {
        return 0;
    }
}
