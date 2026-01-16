package ir.eitaa.messenger.support.customtabsclient.shared;

import ir.eitaa.messenger.support.customtabs.CustomTabsClient;

/* loaded from: classes.dex */
public interface ServiceConnectionCallback {
    void onServiceConnected(CustomTabsClient client);

    void onServiceDisconnected();
}
