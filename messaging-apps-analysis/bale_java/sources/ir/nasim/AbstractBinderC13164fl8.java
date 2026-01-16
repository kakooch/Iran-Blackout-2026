package ir.nasim;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.measurement.zzcl;
import ir.nasim.XZ2;
import java.util.HashMap;

/* renamed from: ir.nasim.fl8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractBinderC13164fl8 extends AbstractBinderC11906dk8 implements InterfaceC15546jl8 {
    public AbstractBinderC13164fl8() {
        super("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    public static InterfaceC15546jl8 asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
        return iInterfaceQueryLocalInterface instanceof InterfaceC15546jl8 ? (InterfaceC15546jl8) iInterfaceQueryLocalInterface : new C12528el8(iBinder);
    }

    @Override // ir.nasim.AbstractBinderC11906dk8
    protected final boolean B2(int i, Parcel parcel, Parcel parcel2, int i2) {
        InterfaceC19683ql8 c17319ml8;
        InterfaceC19683ql8 c17319ml82 = null;
        InterfaceC19683ql8 c17319ml83 = null;
        InterfaceC19683ql8 c17319ml84 = null;
        InterfaceC19683ql8 c17319ml85 = null;
        InterfaceC20883sl8 c20292rl8 = null;
        InterfaceC20883sl8 c20292rl82 = null;
        InterfaceC20883sl8 c20292rl83 = null;
        InterfaceC19683ql8 c17319ml86 = null;
        InterfaceC19683ql8 c17319ml87 = null;
        InterfaceC19683ql8 c17319ml88 = null;
        InterfaceC19683ql8 c17319ml89 = null;
        InterfaceC19683ql8 c17319ml810 = null;
        InterfaceC19683ql8 c17319ml811 = null;
        InterfaceC22750vl8 c21570tl8 = null;
        InterfaceC19683ql8 c17319ml812 = null;
        InterfaceC19683ql8 c17319ml813 = null;
        InterfaceC19683ql8 c17319ml814 = null;
        InterfaceC19683ql8 c17319ml815 = null;
        switch (i) {
            case 1:
                XZ2 xz2C2 = XZ2.a.C2(parcel.readStrongBinder());
                zzcl zzclVar = (zzcl) AbstractC13154fk8.a(parcel, zzcl.CREATOR);
                long j = parcel.readLong();
                AbstractC13154fk8.c(parcel);
                initialize(xz2C2, zzclVar, j);
                break;
            case 2:
                String string = parcel.readString();
                String string2 = parcel.readString();
                Bundle bundle = (Bundle) AbstractC13154fk8.a(parcel, Bundle.CREATOR);
                boolean zG = AbstractC13154fk8.g(parcel);
                boolean zG2 = AbstractC13154fk8.g(parcel);
                long j2 = parcel.readLong();
                AbstractC13154fk8.c(parcel);
                logEvent(string, string2, bundle, zG, zG2, j2);
                break;
            case 3:
                String string3 = parcel.readString();
                String string4 = parcel.readString();
                Bundle bundle2 = (Bundle) AbstractC13154fk8.a(parcel, Bundle.CREATOR);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder == null) {
                    c17319ml8 = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    c17319ml8 = iInterfaceQueryLocalInterface instanceof InterfaceC19683ql8 ? (InterfaceC19683ql8) iInterfaceQueryLocalInterface : new C17319ml8(strongBinder);
                }
                long j3 = parcel.readLong();
                AbstractC13154fk8.c(parcel);
                logEventAndBundle(string3, string4, bundle2, c17319ml8, j3);
                break;
            case 4:
                String string5 = parcel.readString();
                String string6 = parcel.readString();
                XZ2 xz2C22 = XZ2.a.C2(parcel.readStrongBinder());
                boolean zG3 = AbstractC13154fk8.g(parcel);
                long j4 = parcel.readLong();
                AbstractC13154fk8.c(parcel);
                setUserProperty(string5, string6, xz2C22, zG3, j4);
                break;
            case 5:
                String string7 = parcel.readString();
                String string8 = parcel.readString();
                boolean zG4 = AbstractC13154fk8.g(parcel);
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    c17319ml82 = iInterfaceQueryLocalInterface2 instanceof InterfaceC19683ql8 ? (InterfaceC19683ql8) iInterfaceQueryLocalInterface2 : new C17319ml8(strongBinder2);
                }
                AbstractC13154fk8.c(parcel);
                getUserProperties(string7, string8, zG4, c17319ml82);
                break;
            case 6:
                String string9 = parcel.readString();
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 != null) {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    c17319ml815 = iInterfaceQueryLocalInterface3 instanceof InterfaceC19683ql8 ? (InterfaceC19683ql8) iInterfaceQueryLocalInterface3 : new C17319ml8(strongBinder3);
                }
                AbstractC13154fk8.c(parcel);
                getMaxUserProperties(string9, c17319ml815);
                break;
            case 7:
                String string10 = parcel.readString();
                long j5 = parcel.readLong();
                AbstractC13154fk8.c(parcel);
                setUserId(string10, j5);
                break;
            case 8:
                Bundle bundle3 = (Bundle) AbstractC13154fk8.a(parcel, Bundle.CREATOR);
                long j6 = parcel.readLong();
                AbstractC13154fk8.c(parcel);
                setConditionalUserProperty(bundle3, j6);
                break;
            case 9:
                String string11 = parcel.readString();
                String string12 = parcel.readString();
                Bundle bundle4 = (Bundle) AbstractC13154fk8.a(parcel, Bundle.CREATOR);
                AbstractC13154fk8.c(parcel);
                clearConditionalUserProperty(string11, string12, bundle4);
                break;
            case 10:
                String string13 = parcel.readString();
                String string14 = parcel.readString();
                IBinder strongBinder4 = parcel.readStrongBinder();
                if (strongBinder4 != null) {
                    IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    c17319ml814 = iInterfaceQueryLocalInterface4 instanceof InterfaceC19683ql8 ? (InterfaceC19683ql8) iInterfaceQueryLocalInterface4 : new C17319ml8(strongBinder4);
                }
                AbstractC13154fk8.c(parcel);
                getConditionalUserProperties(string13, string14, c17319ml814);
                break;
            case 11:
                boolean zG5 = AbstractC13154fk8.g(parcel);
                long j7 = parcel.readLong();
                AbstractC13154fk8.c(parcel);
                setMeasurementEnabled(zG5, j7);
                break;
            case 12:
                long j8 = parcel.readLong();
                AbstractC13154fk8.c(parcel);
                resetAnalyticsData(j8);
                break;
            case 13:
                long j9 = parcel.readLong();
                AbstractC13154fk8.c(parcel);
                setMinimumSessionDuration(j9);
                break;
            case 14:
                long j10 = parcel.readLong();
                AbstractC13154fk8.c(parcel);
                setSessionTimeoutDuration(j10);
                break;
            case 15:
                XZ2 xz2C23 = XZ2.a.C2(parcel.readStrongBinder());
                String string15 = parcel.readString();
                String string16 = parcel.readString();
                long j11 = parcel.readLong();
                AbstractC13154fk8.c(parcel);
                setCurrentScreen(xz2C23, string15, string16, j11);
                break;
            case 16:
                IBinder strongBinder5 = parcel.readStrongBinder();
                if (strongBinder5 != null) {
                    IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    c17319ml813 = iInterfaceQueryLocalInterface5 instanceof InterfaceC19683ql8 ? (InterfaceC19683ql8) iInterfaceQueryLocalInterface5 : new C17319ml8(strongBinder5);
                }
                AbstractC13154fk8.c(parcel);
                getCurrentScreenName(c17319ml813);
                break;
            case 17:
                IBinder strongBinder6 = parcel.readStrongBinder();
                if (strongBinder6 != null) {
                    IInterface iInterfaceQueryLocalInterface6 = strongBinder6.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    c17319ml812 = iInterfaceQueryLocalInterface6 instanceof InterfaceC19683ql8 ? (InterfaceC19683ql8) iInterfaceQueryLocalInterface6 : new C17319ml8(strongBinder6);
                }
                AbstractC13154fk8.c(parcel);
                getCurrentScreenClass(c17319ml812);
                break;
            case 18:
                IBinder strongBinder7 = parcel.readStrongBinder();
                if (strongBinder7 != null) {
                    IInterface iInterfaceQueryLocalInterface7 = strongBinder7.queryLocalInterface("com.google.android.gms.measurement.api.internal.IStringProvider");
                    c21570tl8 = iInterfaceQueryLocalInterface7 instanceof InterfaceC22750vl8 ? (InterfaceC22750vl8) iInterfaceQueryLocalInterface7 : new C21570tl8(strongBinder7);
                }
                AbstractC13154fk8.c(parcel);
                setInstanceIdProvider(c21570tl8);
                break;
            case 19:
                IBinder strongBinder8 = parcel.readStrongBinder();
                if (strongBinder8 != null) {
                    IInterface iInterfaceQueryLocalInterface8 = strongBinder8.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    c17319ml811 = iInterfaceQueryLocalInterface8 instanceof InterfaceC19683ql8 ? (InterfaceC19683ql8) iInterfaceQueryLocalInterface8 : new C17319ml8(strongBinder8);
                }
                AbstractC13154fk8.c(parcel);
                getCachedAppInstanceId(c17319ml811);
                break;
            case 20:
                IBinder strongBinder9 = parcel.readStrongBinder();
                if (strongBinder9 != null) {
                    IInterface iInterfaceQueryLocalInterface9 = strongBinder9.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    c17319ml810 = iInterfaceQueryLocalInterface9 instanceof InterfaceC19683ql8 ? (InterfaceC19683ql8) iInterfaceQueryLocalInterface9 : new C17319ml8(strongBinder9);
                }
                AbstractC13154fk8.c(parcel);
                getAppInstanceId(c17319ml810);
                break;
            case 21:
                IBinder strongBinder10 = parcel.readStrongBinder();
                if (strongBinder10 != null) {
                    IInterface iInterfaceQueryLocalInterface10 = strongBinder10.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    c17319ml89 = iInterfaceQueryLocalInterface10 instanceof InterfaceC19683ql8 ? (InterfaceC19683ql8) iInterfaceQueryLocalInterface10 : new C17319ml8(strongBinder10);
                }
                AbstractC13154fk8.c(parcel);
                getGmpAppId(c17319ml89);
                break;
            case 22:
                IBinder strongBinder11 = parcel.readStrongBinder();
                if (strongBinder11 != null) {
                    IInterface iInterfaceQueryLocalInterface11 = strongBinder11.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    c17319ml88 = iInterfaceQueryLocalInterface11 instanceof InterfaceC19683ql8 ? (InterfaceC19683ql8) iInterfaceQueryLocalInterface11 : new C17319ml8(strongBinder11);
                }
                AbstractC13154fk8.c(parcel);
                generateEventId(c17319ml88);
                break;
            case 23:
                String string17 = parcel.readString();
                long j12 = parcel.readLong();
                AbstractC13154fk8.c(parcel);
                beginAdUnitExposure(string17, j12);
                break;
            case 24:
                String string18 = parcel.readString();
                long j13 = parcel.readLong();
                AbstractC13154fk8.c(parcel);
                endAdUnitExposure(string18, j13);
                break;
            case 25:
                XZ2 xz2C24 = XZ2.a.C2(parcel.readStrongBinder());
                long j14 = parcel.readLong();
                AbstractC13154fk8.c(parcel);
                onActivityStarted(xz2C24, j14);
                break;
            case 26:
                XZ2 xz2C25 = XZ2.a.C2(parcel.readStrongBinder());
                long j15 = parcel.readLong();
                AbstractC13154fk8.c(parcel);
                onActivityStopped(xz2C25, j15);
                break;
            case 27:
                XZ2 xz2C26 = XZ2.a.C2(parcel.readStrongBinder());
                Bundle bundle5 = (Bundle) AbstractC13154fk8.a(parcel, Bundle.CREATOR);
                long j16 = parcel.readLong();
                AbstractC13154fk8.c(parcel);
                onActivityCreated(xz2C26, bundle5, j16);
                break;
            case 28:
                XZ2 xz2C27 = XZ2.a.C2(parcel.readStrongBinder());
                long j17 = parcel.readLong();
                AbstractC13154fk8.c(parcel);
                onActivityDestroyed(xz2C27, j17);
                break;
            case 29:
                XZ2 xz2C28 = XZ2.a.C2(parcel.readStrongBinder());
                long j18 = parcel.readLong();
                AbstractC13154fk8.c(parcel);
                onActivityPaused(xz2C28, j18);
                break;
            case 30:
                XZ2 xz2C29 = XZ2.a.C2(parcel.readStrongBinder());
                long j19 = parcel.readLong();
                AbstractC13154fk8.c(parcel);
                onActivityResumed(xz2C29, j19);
                break;
            case 31:
                XZ2 xz2C210 = XZ2.a.C2(parcel.readStrongBinder());
                IBinder strongBinder12 = parcel.readStrongBinder();
                if (strongBinder12 != null) {
                    IInterface iInterfaceQueryLocalInterface12 = strongBinder12.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    c17319ml87 = iInterfaceQueryLocalInterface12 instanceof InterfaceC19683ql8 ? (InterfaceC19683ql8) iInterfaceQueryLocalInterface12 : new C17319ml8(strongBinder12);
                }
                long j20 = parcel.readLong();
                AbstractC13154fk8.c(parcel);
                onActivitySaveInstanceState(xz2C210, c17319ml87, j20);
                break;
            case 32:
                Bundle bundle6 = (Bundle) AbstractC13154fk8.a(parcel, Bundle.CREATOR);
                IBinder strongBinder13 = parcel.readStrongBinder();
                if (strongBinder13 != null) {
                    IInterface iInterfaceQueryLocalInterface13 = strongBinder13.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    c17319ml86 = iInterfaceQueryLocalInterface13 instanceof InterfaceC19683ql8 ? (InterfaceC19683ql8) iInterfaceQueryLocalInterface13 : new C17319ml8(strongBinder13);
                }
                long j21 = parcel.readLong();
                AbstractC13154fk8.c(parcel);
                performAction(bundle6, c17319ml86, j21);
                break;
            case 33:
                int i3 = parcel.readInt();
                String string19 = parcel.readString();
                XZ2 xz2C211 = XZ2.a.C2(parcel.readStrongBinder());
                XZ2 xz2C212 = XZ2.a.C2(parcel.readStrongBinder());
                XZ2 xz2C213 = XZ2.a.C2(parcel.readStrongBinder());
                AbstractC13154fk8.c(parcel);
                logHealthData(i3, string19, xz2C211, xz2C212, xz2C213);
                break;
            case 34:
                IBinder strongBinder14 = parcel.readStrongBinder();
                if (strongBinder14 != null) {
                    IInterface iInterfaceQueryLocalInterface14 = strongBinder14.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    c20292rl83 = iInterfaceQueryLocalInterface14 instanceof InterfaceC20883sl8 ? (InterfaceC20883sl8) iInterfaceQueryLocalInterface14 : new C20292rl8(strongBinder14);
                }
                AbstractC13154fk8.c(parcel);
                setEventInterceptor(c20292rl83);
                break;
            case 35:
                IBinder strongBinder15 = parcel.readStrongBinder();
                if (strongBinder15 != null) {
                    IInterface iInterfaceQueryLocalInterface15 = strongBinder15.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    c20292rl82 = iInterfaceQueryLocalInterface15 instanceof InterfaceC20883sl8 ? (InterfaceC20883sl8) iInterfaceQueryLocalInterface15 : new C20292rl8(strongBinder15);
                }
                AbstractC13154fk8.c(parcel);
                registerOnMeasurementEventListener(c20292rl82);
                break;
            case 36:
                IBinder strongBinder16 = parcel.readStrongBinder();
                if (strongBinder16 != null) {
                    IInterface iInterfaceQueryLocalInterface16 = strongBinder16.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    c20292rl8 = iInterfaceQueryLocalInterface16 instanceof InterfaceC20883sl8 ? (InterfaceC20883sl8) iInterfaceQueryLocalInterface16 : new C20292rl8(strongBinder16);
                }
                AbstractC13154fk8.c(parcel);
                unregisterOnMeasurementEventListener(c20292rl8);
                break;
            case 37:
                HashMap mapB = AbstractC13154fk8.b(parcel);
                AbstractC13154fk8.c(parcel);
                initForTests(mapB);
                break;
            case 38:
                IBinder strongBinder17 = parcel.readStrongBinder();
                if (strongBinder17 != null) {
                    IInterface iInterfaceQueryLocalInterface17 = strongBinder17.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    c17319ml85 = iInterfaceQueryLocalInterface17 instanceof InterfaceC19683ql8 ? (InterfaceC19683ql8) iInterfaceQueryLocalInterface17 : new C17319ml8(strongBinder17);
                }
                int i4 = parcel.readInt();
                AbstractC13154fk8.c(parcel);
                getTestFlag(c17319ml85, i4);
                break;
            case 39:
                boolean zG6 = AbstractC13154fk8.g(parcel);
                AbstractC13154fk8.c(parcel);
                setDataCollectionEnabled(zG6);
                break;
            case 40:
                IBinder strongBinder18 = parcel.readStrongBinder();
                if (strongBinder18 != null) {
                    IInterface iInterfaceQueryLocalInterface18 = strongBinder18.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    c17319ml84 = iInterfaceQueryLocalInterface18 instanceof InterfaceC19683ql8 ? (InterfaceC19683ql8) iInterfaceQueryLocalInterface18 : new C17319ml8(strongBinder18);
                }
                AbstractC13154fk8.c(parcel);
                isDataCollectionEnabled(c17319ml84);
                break;
            case 41:
            default:
                return false;
            case 42:
                Bundle bundle7 = (Bundle) AbstractC13154fk8.a(parcel, Bundle.CREATOR);
                AbstractC13154fk8.c(parcel);
                setDefaultEventParameters(bundle7);
                break;
            case 43:
                long j22 = parcel.readLong();
                AbstractC13154fk8.c(parcel);
                clearMeasurementEnabled(j22);
                break;
            case 44:
                Bundle bundle8 = (Bundle) AbstractC13154fk8.a(parcel, Bundle.CREATOR);
                long j23 = parcel.readLong();
                AbstractC13154fk8.c(parcel);
                setConsent(bundle8, j23);
                break;
            case 45:
                Bundle bundle9 = (Bundle) AbstractC13154fk8.a(parcel, Bundle.CREATOR);
                long j24 = parcel.readLong();
                AbstractC13154fk8.c(parcel);
                setConsentThirdParty(bundle9, j24);
                break;
            case 46:
                IBinder strongBinder19 = parcel.readStrongBinder();
                if (strongBinder19 != null) {
                    IInterface iInterfaceQueryLocalInterface19 = strongBinder19.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    c17319ml83 = iInterfaceQueryLocalInterface19 instanceof InterfaceC19683ql8 ? (InterfaceC19683ql8) iInterfaceQueryLocalInterface19 : new C17319ml8(strongBinder19);
                }
                AbstractC13154fk8.c(parcel);
                getSessionId(c17319ml83);
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
