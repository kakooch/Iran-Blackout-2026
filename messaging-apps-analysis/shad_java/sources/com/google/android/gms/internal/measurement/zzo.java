package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes3.dex */
public abstract class zzo extends zzb implements zzp {
    public zzo() {
        super("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    public static zzp asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
        return iInterfaceQueryLocalInterface instanceof zzp ? (zzp) iInterfaceQueryLocalInterface : new zzn(iBinder);
    }

    @Override // com.google.android.gms.internal.measurement.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzs zzqVar;
        zzs zzqVar2 = null;
        zzs zzqVar3 = null;
        zzs zzqVar4 = null;
        zzv zztVar = null;
        zzv zztVar2 = null;
        zzv zztVar3 = null;
        zzs zzqVar5 = null;
        zzs zzqVar6 = null;
        zzs zzqVar7 = null;
        zzs zzqVar8 = null;
        zzs zzqVar9 = null;
        zzs zzqVar10 = null;
        zzx zzwVar = null;
        zzs zzqVar11 = null;
        zzs zzqVar12 = null;
        zzs zzqVar13 = null;
        zzs zzqVar14 = null;
        switch (i) {
            case 1:
                initialize(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzy) zzc.zzc(parcel, zzy.CREATOR), parcel.readLong());
                break;
            case 2:
                logEvent(parcel.readString(), parcel.readString(), (Bundle) zzc.zzc(parcel, Bundle.CREATOR), zzc.zza(parcel), zzc.zza(parcel), parcel.readLong());
                break;
            case 3:
                String string = parcel.readString();
                String string2 = parcel.readString();
                Bundle bundle = (Bundle) zzc.zzc(parcel, Bundle.CREATOR);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder == null) {
                    zzqVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzqVar = iInterfaceQueryLocalInterface instanceof zzs ? (zzs) iInterfaceQueryLocalInterface : new zzq(strongBinder);
                }
                logEventAndBundle(string, string2, bundle, zzqVar, parcel.readLong());
                break;
            case 4:
                setUserProperty(parcel.readString(), parcel.readString(), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), zzc.zza(parcel), parcel.readLong());
                break;
            case 5:
                String string3 = parcel.readString();
                String string4 = parcel.readString();
                boolean zZza = zzc.zza(parcel);
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzqVar2 = iInterfaceQueryLocalInterface2 instanceof zzs ? (zzs) iInterfaceQueryLocalInterface2 : new zzq(strongBinder2);
                }
                getUserProperties(string3, string4, zZza, zzqVar2);
                break;
            case 6:
                String string5 = parcel.readString();
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 != null) {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzqVar14 = iInterfaceQueryLocalInterface3 instanceof zzs ? (zzs) iInterfaceQueryLocalInterface3 : new zzq(strongBinder3);
                }
                getMaxUserProperties(string5, zzqVar14);
                break;
            case 7:
                setUserId(parcel.readString(), parcel.readLong());
                break;
            case 8:
                setConditionalUserProperty((Bundle) zzc.zzc(parcel, Bundle.CREATOR), parcel.readLong());
                break;
            case 9:
                clearConditionalUserProperty(parcel.readString(), parcel.readString(), (Bundle) zzc.zzc(parcel, Bundle.CREATOR));
                break;
            case 10:
                String string6 = parcel.readString();
                String string7 = parcel.readString();
                IBinder strongBinder4 = parcel.readStrongBinder();
                if (strongBinder4 != null) {
                    IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzqVar13 = iInterfaceQueryLocalInterface4 instanceof zzs ? (zzs) iInterfaceQueryLocalInterface4 : new zzq(strongBinder4);
                }
                getConditionalUserProperties(string6, string7, zzqVar13);
                break;
            case 11:
                setMeasurementEnabled(zzc.zza(parcel), parcel.readLong());
                break;
            case 12:
                resetAnalyticsData(parcel.readLong());
                break;
            case 13:
                setMinimumSessionDuration(parcel.readLong());
                break;
            case 14:
                setSessionTimeoutDuration(parcel.readLong());
                break;
            case 15:
                setCurrentScreen(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readLong());
                break;
            case 16:
                IBinder strongBinder5 = parcel.readStrongBinder();
                if (strongBinder5 != null) {
                    IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzqVar12 = iInterfaceQueryLocalInterface5 instanceof zzs ? (zzs) iInterfaceQueryLocalInterface5 : new zzq(strongBinder5);
                }
                getCurrentScreenName(zzqVar12);
                break;
            case 17:
                IBinder strongBinder6 = parcel.readStrongBinder();
                if (strongBinder6 != null) {
                    IInterface iInterfaceQueryLocalInterface6 = strongBinder6.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzqVar11 = iInterfaceQueryLocalInterface6 instanceof zzs ? (zzs) iInterfaceQueryLocalInterface6 : new zzq(strongBinder6);
                }
                getCurrentScreenClass(zzqVar11);
                break;
            case 18:
                IBinder strongBinder7 = parcel.readStrongBinder();
                if (strongBinder7 != null) {
                    IInterface iInterfaceQueryLocalInterface7 = strongBinder7.queryLocalInterface("com.google.android.gms.measurement.api.internal.IStringProvider");
                    zzwVar = iInterfaceQueryLocalInterface7 instanceof zzx ? (zzx) iInterfaceQueryLocalInterface7 : new zzw(strongBinder7);
                }
                setInstanceIdProvider(zzwVar);
                break;
            case 19:
                IBinder strongBinder8 = parcel.readStrongBinder();
                if (strongBinder8 != null) {
                    IInterface iInterfaceQueryLocalInterface8 = strongBinder8.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzqVar10 = iInterfaceQueryLocalInterface8 instanceof zzs ? (zzs) iInterfaceQueryLocalInterface8 : new zzq(strongBinder8);
                }
                getCachedAppInstanceId(zzqVar10);
                break;
            case 20:
                IBinder strongBinder9 = parcel.readStrongBinder();
                if (strongBinder9 != null) {
                    IInterface iInterfaceQueryLocalInterface9 = strongBinder9.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzqVar9 = iInterfaceQueryLocalInterface9 instanceof zzs ? (zzs) iInterfaceQueryLocalInterface9 : new zzq(strongBinder9);
                }
                getAppInstanceId(zzqVar9);
                break;
            case 21:
                IBinder strongBinder10 = parcel.readStrongBinder();
                if (strongBinder10 != null) {
                    IInterface iInterfaceQueryLocalInterface10 = strongBinder10.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzqVar8 = iInterfaceQueryLocalInterface10 instanceof zzs ? (zzs) iInterfaceQueryLocalInterface10 : new zzq(strongBinder10);
                }
                getGmpAppId(zzqVar8);
                break;
            case 22:
                IBinder strongBinder11 = parcel.readStrongBinder();
                if (strongBinder11 != null) {
                    IInterface iInterfaceQueryLocalInterface11 = strongBinder11.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzqVar7 = iInterfaceQueryLocalInterface11 instanceof zzs ? (zzs) iInterfaceQueryLocalInterface11 : new zzq(strongBinder11);
                }
                generateEventId(zzqVar7);
                break;
            case 23:
                beginAdUnitExposure(parcel.readString(), parcel.readLong());
                break;
            case 24:
                endAdUnitExposure(parcel.readString(), parcel.readLong());
                break;
            case 25:
                onActivityStarted(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 26:
                onActivityStopped(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 27:
                onActivityCreated(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (Bundle) zzc.zzc(parcel, Bundle.CREATOR), parcel.readLong());
                break;
            case 28:
                onActivityDestroyed(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 29:
                onActivityPaused(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 30:
                onActivityResumed(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 31:
                IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IBinder strongBinder12 = parcel.readStrongBinder();
                if (strongBinder12 != null) {
                    IInterface iInterfaceQueryLocalInterface12 = strongBinder12.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzqVar6 = iInterfaceQueryLocalInterface12 instanceof zzs ? (zzs) iInterfaceQueryLocalInterface12 : new zzq(strongBinder12);
                }
                onActivitySaveInstanceState(iObjectWrapperAsInterface, zzqVar6, parcel.readLong());
                break;
            case 32:
                Bundle bundle2 = (Bundle) zzc.zzc(parcel, Bundle.CREATOR);
                IBinder strongBinder13 = parcel.readStrongBinder();
                if (strongBinder13 != null) {
                    IInterface iInterfaceQueryLocalInterface13 = strongBinder13.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzqVar5 = iInterfaceQueryLocalInterface13 instanceof zzs ? (zzs) iInterfaceQueryLocalInterface13 : new zzq(strongBinder13);
                }
                performAction(bundle2, zzqVar5, parcel.readLong());
                break;
            case 33:
                logHealthData(parcel.readInt(), parcel.readString(), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                break;
            case 34:
                IBinder strongBinder14 = parcel.readStrongBinder();
                if (strongBinder14 != null) {
                    IInterface iInterfaceQueryLocalInterface14 = strongBinder14.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    zztVar3 = iInterfaceQueryLocalInterface14 instanceof zzv ? (zzv) iInterfaceQueryLocalInterface14 : new zzt(strongBinder14);
                }
                setEventInterceptor(zztVar3);
                break;
            case 35:
                IBinder strongBinder15 = parcel.readStrongBinder();
                if (strongBinder15 != null) {
                    IInterface iInterfaceQueryLocalInterface15 = strongBinder15.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    zztVar2 = iInterfaceQueryLocalInterface15 instanceof zzv ? (zzv) iInterfaceQueryLocalInterface15 : new zzt(strongBinder15);
                }
                registerOnMeasurementEventListener(zztVar2);
                break;
            case 36:
                IBinder strongBinder16 = parcel.readStrongBinder();
                if (strongBinder16 != null) {
                    IInterface iInterfaceQueryLocalInterface16 = strongBinder16.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    zztVar = iInterfaceQueryLocalInterface16 instanceof zzv ? (zzv) iInterfaceQueryLocalInterface16 : new zzt(strongBinder16);
                }
                unregisterOnMeasurementEventListener(zztVar);
                break;
            case 37:
                initForTests(zzc.zzf(parcel));
                break;
            case 38:
                IBinder strongBinder17 = parcel.readStrongBinder();
                if (strongBinder17 != null) {
                    IInterface iInterfaceQueryLocalInterface17 = strongBinder17.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzqVar4 = iInterfaceQueryLocalInterface17 instanceof zzs ? (zzs) iInterfaceQueryLocalInterface17 : new zzq(strongBinder17);
                }
                getTestFlag(zzqVar4, parcel.readInt());
                break;
            case 39:
                setDataCollectionEnabled(zzc.zza(parcel));
                break;
            case 40:
                IBinder strongBinder18 = parcel.readStrongBinder();
                if (strongBinder18 != null) {
                    IInterface iInterfaceQueryLocalInterface18 = strongBinder18.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzqVar3 = iInterfaceQueryLocalInterface18 instanceof zzs ? (zzs) iInterfaceQueryLocalInterface18 : new zzq(strongBinder18);
                }
                isDataCollectionEnabled(zzqVar3);
                break;
            case 41:
            default:
                return false;
            case 42:
                setDefaultEventParameters((Bundle) zzc.zzc(parcel, Bundle.CREATOR));
                break;
            case 43:
                clearMeasurementEnabled(parcel.readLong());
                break;
            case 44:
                setConsent((Bundle) zzc.zzc(parcel, Bundle.CREATOR), parcel.readLong());
                break;
            case 45:
                setConsentThirdParty((Bundle) zzc.zzc(parcel, Bundle.CREATOR), parcel.readLong());
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
