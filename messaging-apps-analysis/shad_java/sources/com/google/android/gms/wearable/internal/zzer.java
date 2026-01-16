package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
final class zzer<T> {
    private final Map<T, zzhk<T>> zzeb = new HashMap();

    zzer() {
    }

    public final void zza(IBinder iBinder) {
        zzep zzeqVar;
        synchronized (this.zzeb) {
            if (iBinder == null) {
                zzeqVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableService");
                if (iInterfaceQueryLocalInterface instanceof zzep) {
                    zzeqVar = (zzep) iInterfaceQueryLocalInterface;
                } else {
                    zzeqVar = new zzeq(iBinder);
                }
            }
            zzgz zzgzVar = new zzgz();
            for (Map.Entry<T, zzhk<T>> entry : this.zzeb.entrySet()) {
                zzhk<T> value = entry.getValue();
                try {
                    zzeqVar.zza(zzgzVar, new zzd(value));
                    if (Log.isLoggable("WearableClient", 3)) {
                        String strValueOf = String.valueOf(entry.getKey());
                        String strValueOf2 = String.valueOf(value);
                        StringBuilder sb = new StringBuilder(strValueOf.length() + 27 + strValueOf2.length());
                        sb.append("onPostInitHandler: added: ");
                        sb.append(strValueOf);
                        sb.append("/");
                        sb.append(strValueOf2);
                        Log.d("WearableClient", sb.toString());
                    }
                } catch (RemoteException unused) {
                    String strValueOf3 = String.valueOf(entry.getKey());
                    String strValueOf4 = String.valueOf(value);
                    StringBuilder sb2 = new StringBuilder(strValueOf3.length() + 32 + strValueOf4.length());
                    sb2.append("onPostInitHandler: Didn't add: ");
                    sb2.append(strValueOf3);
                    sb2.append("/");
                    sb2.append(strValueOf4);
                    Log.w("WearableClient", sb2.toString());
                }
            }
        }
    }
}
