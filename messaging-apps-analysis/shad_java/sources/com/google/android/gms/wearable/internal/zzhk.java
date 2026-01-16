package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.ChannelApi$ChannelListener;
import com.google.android.gms.wearable.DataApi$DataListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.List;

/* loaded from: classes3.dex */
public final class zzhk<T> extends zzen {
    private final IntentFilter[] zzba;
    private final String zzbb;
    private ListenerHolder<DataApi$DataListener> zzfl;
    private ListenerHolder<MessageApi.MessageListener> zzfm;
    private ListenerHolder<ChannelApi$ChannelListener> zzfp;
    private ListenerHolder<CapabilityApi.CapabilityListener> zzfq;

    @Override // com.google.android.gms.wearable.internal.zzem
    public final void onConnectedNodes(List<zzfo> list) {
    }

    @Override // com.google.android.gms.wearable.internal.zzem
    public final void zza(zzfo zzfoVar) {
    }

    @Override // com.google.android.gms.wearable.internal.zzem
    public final void zza(zzi zziVar) {
    }

    @Override // com.google.android.gms.wearable.internal.zzem
    public final void zza(zzl zzlVar) {
    }

    @Override // com.google.android.gms.wearable.internal.zzem
    public final void zzb(zzfo zzfoVar) {
    }

    @Override // com.google.android.gms.wearable.internal.zzem
    public final void zza(DataHolder dataHolder) {
        ListenerHolder<DataApi$DataListener> listenerHolder = this.zzfl;
        if (listenerHolder != null) {
            listenerHolder.notifyListener(new zzhl(dataHolder));
        } else {
            dataHolder.close();
        }
    }

    @Override // com.google.android.gms.wearable.internal.zzem
    public final void zza(zzfe zzfeVar) {
        ListenerHolder<MessageApi.MessageListener> listenerHolder = this.zzfm;
        if (listenerHolder != null) {
            listenerHolder.notifyListener(new zzhm(zzfeVar));
        }
    }

    @Override // com.google.android.gms.wearable.internal.zzem
    public final void zza(zzaw zzawVar) {
        ListenerHolder<ChannelApi$ChannelListener> listenerHolder = this.zzfp;
        if (listenerHolder != null) {
            listenerHolder.notifyListener(new zzhn(zzawVar));
        }
    }

    @Override // com.google.android.gms.wearable.internal.zzem
    public final void zza(zzah zzahVar) {
        ListenerHolder<CapabilityApi.CapabilityListener> listenerHolder = this.zzfq;
        if (listenerHolder != null) {
            listenerHolder.notifyListener(new zzho(zzahVar));
        }
    }

    public final IntentFilter[] zze() {
        return this.zzba;
    }

    public final String zzf() {
        return this.zzbb;
    }
}
