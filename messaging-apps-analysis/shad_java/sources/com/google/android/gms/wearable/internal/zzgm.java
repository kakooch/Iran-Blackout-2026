package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.BaseImplementation$ResultHolder;

/* loaded from: classes3.dex */
class zzgm<T> extends zza {
    private BaseImplementation$ResultHolder<T> zzet;

    public zzgm(BaseImplementation$ResultHolder<T> baseImplementation$ResultHolder) {
        this.zzet = baseImplementation$ResultHolder;
    }

    public final void zza(T t) {
        BaseImplementation$ResultHolder<T> baseImplementation$ResultHolder = this.zzet;
        if (baseImplementation$ResultHolder != null) {
            baseImplementation$ResultHolder.setResult(t);
            this.zzet = null;
        }
    }
}
