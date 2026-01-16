package ir.eitaa.messenger.support.customtabs;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import ir.eitaa.messenger.support.customtabs.ICustomTabsCallback;

/* loaded from: classes.dex */
public class CustomTabsClient {
    private final ICustomTabsService mService;
    private final ComponentName mServiceComponentName;

    CustomTabsClient(ICustomTabsService service, ComponentName componentName) {
        this.mService = service;
        this.mServiceComponentName = componentName;
    }

    public static boolean bindCustomTabsService(Context context, String packageName, CustomTabsServiceConnection connection) {
        Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
        if (!TextUtils.isEmpty(packageName)) {
            intent.setPackage(packageName);
        }
        return context.bindService(intent, connection, 33);
    }

    public boolean warmup(long flags) {
        try {
            return this.mService.warmup(flags);
        } catch (RemoteException unused) {
            return false;
        }
    }

    public CustomTabsSession newSession(final CustomTabsCallback callback) {
        ICustomTabsCallback.Stub stub = new ICustomTabsCallback.Stub() { // from class: ir.eitaa.messenger.support.customtabs.CustomTabsClient.2
            private Handler mHandler = new Handler(Looper.getMainLooper());

            @Override // ir.eitaa.messenger.support.customtabs.ICustomTabsCallback
            public void onNavigationEvent(final int navigationEvent, final Bundle extras) {
                if (callback == null) {
                    return;
                }
                this.mHandler.post(new Runnable() { // from class: ir.eitaa.messenger.support.customtabs.CustomTabsClient.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        callback.onNavigationEvent(navigationEvent, extras);
                    }
                });
            }

            @Override // ir.eitaa.messenger.support.customtabs.ICustomTabsCallback
            public void extraCallback(final String callbackName, final Bundle args) throws RemoteException {
                if (callback == null) {
                    return;
                }
                this.mHandler.post(new Runnable() { // from class: ir.eitaa.messenger.support.customtabs.CustomTabsClient.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        callback.extraCallback(callbackName, args);
                    }
                });
            }

            @Override // ir.eitaa.messenger.support.customtabs.ICustomTabsCallback
            public void onMessageChannelReady(final Bundle extras) throws RemoteException {
                if (callback == null) {
                    return;
                }
                this.mHandler.post(new Runnable() { // from class: ir.eitaa.messenger.support.customtabs.CustomTabsClient.2.3
                    @Override // java.lang.Runnable
                    public void run() {
                        callback.onMessageChannelReady(extras);
                    }
                });
            }

            @Override // ir.eitaa.messenger.support.customtabs.ICustomTabsCallback
            public void onPostMessage(final String message, final Bundle extras) throws RemoteException {
                if (callback == null) {
                    return;
                }
                this.mHandler.post(new Runnable() { // from class: ir.eitaa.messenger.support.customtabs.CustomTabsClient.2.4
                    @Override // java.lang.Runnable
                    public void run() {
                        callback.onPostMessage(message, extras);
                    }
                });
            }
        };
        try {
            if (this.mService.newSession(stub)) {
                return new CustomTabsSession(this.mService, stub, this.mServiceComponentName);
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }
}
