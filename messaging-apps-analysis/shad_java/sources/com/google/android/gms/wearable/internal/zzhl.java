package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataApi$DataListener;
import com.google.android.gms.wearable.DataEventBuffer;

/* loaded from: classes3.dex */
final class zzhl implements ListenerHolder.Notifier<DataApi$DataListener> {
    private final /* synthetic */ DataHolder zzan;

    zzhl(DataHolder dataHolder) {
        this.zzan = dataHolder;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final void onNotifyListenerFailed() {
        this.zzan.close();
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(DataApi$DataListener dataApi$DataListener) {
        try {
            dataApi$DataListener.onDataChanged(new DataEventBuffer(this.zzan));
        } finally {
            this.zzan.close();
        }
    }
}
