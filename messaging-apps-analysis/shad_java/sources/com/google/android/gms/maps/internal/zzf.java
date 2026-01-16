package com.google.android.gms.maps.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.maps.zzi;
import com.google.android.gms.maps.GoogleMapOptions;

/* compiled from: com.google.android.gms:play-services-maps@@17.0.1 */
/* loaded from: classes3.dex */
public interface zzf extends IInterface {
    IMapViewDelegate zze(IObjectWrapper iObjectWrapper, GoogleMapOptions googleMapOptions) throws RemoteException;

    ICameraUpdateFactoryDelegate zzf() throws RemoteException;

    zzi zzg() throws RemoteException;

    void zzh(IObjectWrapper iObjectWrapper, int i) throws RemoteException;
}
