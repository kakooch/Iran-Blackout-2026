package org.rbmain.messenger.support.customtabsclient.shared;

import org.rbmain.messenger.support.customtabs.CustomTabsClient;

/* loaded from: classes4.dex */
public interface ServiceConnectionCallback {
    void onServiceConnected(CustomTabsClient customTabsClient);

    void onServiceDisconnected();
}
