package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzja implements ServiceConnection, BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ zzjb zza;
    private volatile boolean zzb;
    private volatile zzee zzc;

    protected zzja(zzjb zzjbVar) {
        this.zza = zzjbVar;
    }

    static /* synthetic */ boolean zzd(zzja zzjaVar, boolean z) {
        zzjaVar.zzb = false;
        return false;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                Preconditions.checkNotNull(this.zzc);
                this.zza.zzx.zzau().zzh(new zzix(this, this.zzc.getService()));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.zzc = null;
                this.zzb = false;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) throws IllegalStateException {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionFailed");
        zzei zzeiVarZzf = this.zza.zzx.zzf();
        if (zzeiVarZzf != null) {
            zzeiVarZzf.zze().zzb("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.zzb = false;
            this.zzc = null;
        }
        this.zza.zzx.zzau().zzh(new zziz(this));
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) throws IllegalStateException {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionSuspended");
        this.zza.zzx.zzat().zzj().zza("Service connection suspended");
        this.zza.zzx.zzau().zzh(new zziy(this));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onServiceConnected");
        synchronized (this) {
            if (iBinder == null) {
                this.zzb = false;
                this.zza.zzx.zzat().zzb().zza("Service connected with null binder");
                return;
            }
            zzdz zzdxVar = null;
            try {
                String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    zzdxVar = iInterfaceQueryLocalInterface instanceof zzdz ? (zzdz) iInterfaceQueryLocalInterface : new zzdx(iBinder);
                    this.zza.zzx.zzat().zzk().zza("Bound to IMeasurementService interface");
                } else {
                    this.zza.zzx.zzat().zzb().zzb("Got binder with a wrong descriptor", interfaceDescriptor);
                }
            } catch (RemoteException unused) {
                this.zza.zzx.zzat().zzb().zza("Service connect failed to get IMeasurementService");
            }
            if (zzdxVar == null) {
                this.zzb = false;
                try {
                    ConnectionTracker.getInstance().unbindService(this.zza.zzx.zzaw(), this.zza.zza);
                } catch (IllegalArgumentException unused2) {
                }
            } else {
                this.zza.zzx.zzau().zzh(new zziv(this, zzdxVar));
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) throws IllegalStateException {
        Preconditions.checkMainThread("MeasurementServiceConnection.onServiceDisconnected");
        this.zza.zzx.zzat().zzj().zza("Service disconnected");
        this.zza.zzx.zzau().zzh(new zziw(this, componentName));
    }

    public final void zza(Intent intent) {
        this.zza.zzg();
        Context contextZzaw = this.zza.zzx.zzaw();
        ConnectionTracker connectionTracker = ConnectionTracker.getInstance();
        synchronized (this) {
            if (this.zzb) {
                this.zza.zzx.zzat().zzk().zza("Connection attempt already in progress");
                return;
            }
            this.zza.zzx.zzat().zzk().zza("Using local app measurement service");
            this.zzb = true;
            connectionTracker.bindService(contextZzaw, intent, this.zza.zza, 129);
        }
    }

    public final void zzb() {
        if (this.zzc != null && (this.zzc.isConnected() || this.zzc.isConnecting())) {
            this.zzc.disconnect();
        }
        this.zzc = null;
    }

    public final void zzc() {
        this.zza.zzg();
        Context contextZzaw = this.zza.zzx.zzaw();
        synchronized (this) {
            if (this.zzb) {
                this.zza.zzx.zzat().zzk().zza("Connection attempt already in progress");
                return;
            }
            if (this.zzc != null && (this.zzc.isConnecting() || this.zzc.isConnected())) {
                this.zza.zzx.zzat().zzk().zza("Already awaiting connection attempt");
                return;
            }
            this.zzc = new zzee(contextZzaw, Looper.getMainLooper(), this, this);
            this.zza.zzx.zzat().zzk().zza("Connecting to remote service");
            this.zzb = true;
            Preconditions.checkNotNull(this.zzc);
            this.zzc.checkAvailabilityAndConnect();
        }
    }
}
