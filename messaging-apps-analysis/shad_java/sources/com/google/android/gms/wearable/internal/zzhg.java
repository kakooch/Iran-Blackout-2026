package com.google.android.gms.wearable.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.ChannelApi$ChannelListener;
import com.google.android.gms.wearable.DataApi$DataListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.rbmain.messenger.MessagesController;

/* loaded from: classes3.dex */
public final class zzhg extends GmsClient<zzep> {
    private final ExecutorService zzew;
    private final zzer<Object> zzex;
    private final zzer<Object> zzey;
    private final zzer<ChannelApi$ChannelListener> zzez;
    private final zzer<DataApi$DataListener> zzfa;
    private final zzer<MessageApi.MessageListener> zzfb;
    private final zzer<Object> zzfc;
    private final zzer<Object> zzfd;
    private final zzer<CapabilityApi.CapabilityListener> zzfe;
    private final zzhp zzff;

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return 8600000;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getServiceDescriptor() {
        return "com.google.android.gms.wearable.internal.IWearableService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getStartServiceAction() {
        return "com.google.android.gms.wearable.BIND";
    }

    public zzhg(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, ClientSettings clientSettings) {
        this(context, looper, connectionCallbacks, onConnectionFailedListener, clientSettings, Executors.newCachedThreadPool(), zzhp.zza(context));
    }

    private zzhg(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, ClientSettings clientSettings, ExecutorService executorService, zzhp zzhpVar) {
        super(context, looper, 14, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.zzex = new zzer<>();
        this.zzey = new zzer<>();
        this.zzez = new zzer<>();
        this.zzfa = new zzer<>();
        this.zzfb = new zzer<>();
        this.zzfc = new zzer<>();
        this.zzfd = new zzer<>();
        this.zzfe = new zzer<>();
        this.zzew = (ExecutorService) Preconditions.checkNotNull(executorService);
        this.zzff = zzhpVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getStartServicePackage() {
        return this.zzff.zze("com.google.android.wearable.app.cn") ? "com.google.android.wearable.app.cn" : "com.google.android.gms";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final boolean requiresGooglePlayServices() {
        return !this.zzff.zze("com.google.android.wearable.app.cn");
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final void onPostInitHandler(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (Log.isLoggable("WearableClient", 2)) {
            StringBuilder sb = new StringBuilder(41);
            sb.append("onPostInitHandler: statusCode ");
            sb.append(i);
            Log.v("WearableClient", sb.toString());
        }
        if (i == 0) {
            this.zzex.zza(iBinder);
            this.zzey.zza(iBinder);
            this.zzez.zza(iBinder);
            this.zzfa.zza(iBinder);
            this.zzfb.zza(iBinder);
            this.zzfc.zza(iBinder);
            this.zzfd.zza(iBinder);
            this.zzfe.zza(iBinder);
        }
        super.onPostInitHandler(i, iBinder, bundle, i2);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final void connect(BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        if (!requiresGooglePlayServices()) {
            try {
                Bundle bundle = getContext().getPackageManager().getApplicationInfo("com.google.android.wearable.app.cn", 128).metaData;
                int i = bundle != null ? bundle.getInt("com.google.android.wearable.api.version", 0) : 0;
                if (i < 8600000) {
                    StringBuilder sb = new StringBuilder(82);
                    sb.append("The Wear OS app is out of date. Requires API version 8600000 but found ");
                    sb.append(i);
                    Log.w("WearableClient", sb.toString());
                    Context context = getContext();
                    Context context2 = getContext();
                    Intent intent = new Intent("com.google.android.wearable.app.cn.UPDATE_ANDROID_WEAR").setPackage("com.google.android.wearable.app.cn");
                    if (context2.getPackageManager().resolveActivity(intent, MessagesController.UPDATE_MASK_CHECK) == null) {
                        intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details").buildUpon().appendQueryParameter("id", "com.google.android.wearable.app.cn").build());
                    }
                    triggerNotAvailable(connectionProgressReportCallbacks, 6, PendingIntent.getActivity(context, 0, intent, 0));
                    return;
                }
            } catch (PackageManager.NameNotFoundException unused) {
                triggerNotAvailable(connectionProgressReportCallbacks, 16, null);
                return;
            }
        }
        super.connect(connectionProgressReportCallbacks);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableService");
        if (iInterfaceQueryLocalInterface instanceof zzep) {
            return (zzep) iInterfaceQueryLocalInterface;
        }
        return new zzeq(iBinder);
    }
}
