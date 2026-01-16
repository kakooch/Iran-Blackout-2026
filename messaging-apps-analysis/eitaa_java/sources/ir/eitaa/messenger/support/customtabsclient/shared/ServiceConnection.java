package ir.eitaa.messenger.support.customtabsclient.shared;

import android.content.ComponentName;
import ir.eitaa.messenger.support.customtabs.CustomTabsClient;
import ir.eitaa.messenger.support.customtabs.CustomTabsServiceConnection;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class ServiceConnection extends CustomTabsServiceConnection {
    private WeakReference<ServiceConnectionCallback> mConnectionCallback;

    public ServiceConnection(ServiceConnectionCallback connectionCallback) {
        this.mConnectionCallback = new WeakReference<>(connectionCallback);
    }

    @Override // ir.eitaa.messenger.support.customtabs.CustomTabsServiceConnection
    public void onCustomTabsServiceConnected(ComponentName name, CustomTabsClient client) {
        ServiceConnectionCallback serviceConnectionCallback = this.mConnectionCallback.get();
        if (serviceConnectionCallback != null) {
            serviceConnectionCallback.onServiceConnected(client);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName name) {
        ServiceConnectionCallback serviceConnectionCallback = this.mConnectionCallback.get();
        if (serviceConnectionCallback != null) {
            serviceConnectionCallback.onServiceDisconnected();
        }
    }
}
