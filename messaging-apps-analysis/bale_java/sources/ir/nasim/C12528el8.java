package ir.nasim;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.measurement.zzcl;

/* renamed from: ir.nasim.el8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C12528el8 extends AbstractC10521bk8 implements InterfaceC15546jl8 {
    C12528el8(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public final void beginAdUnitExposure(String str, long j) {
        Parcel parcelB2 = B2();
        parcelB2.writeString(str);
        parcelB2.writeLong(j);
        D2(23, parcelB2);
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        Parcel parcelB2 = B2();
        parcelB2.writeString(str);
        parcelB2.writeString(str2);
        AbstractC13154fk8.e(parcelB2, bundle);
        D2(9, parcelB2);
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public final void endAdUnitExposure(String str, long j) {
        Parcel parcelB2 = B2();
        parcelB2.writeString(str);
        parcelB2.writeLong(j);
        D2(24, parcelB2);
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public final void generateEventId(InterfaceC19683ql8 interfaceC19683ql8) {
        Parcel parcelB2 = B2();
        AbstractC13154fk8.f(parcelB2, interfaceC19683ql8);
        D2(22, parcelB2);
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public final void getCachedAppInstanceId(InterfaceC19683ql8 interfaceC19683ql8) {
        Parcel parcelB2 = B2();
        AbstractC13154fk8.f(parcelB2, interfaceC19683ql8);
        D2(19, parcelB2);
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public final void getConditionalUserProperties(String str, String str2, InterfaceC19683ql8 interfaceC19683ql8) {
        Parcel parcelB2 = B2();
        parcelB2.writeString(str);
        parcelB2.writeString(str2);
        AbstractC13154fk8.f(parcelB2, interfaceC19683ql8);
        D2(10, parcelB2);
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public final void getCurrentScreenClass(InterfaceC19683ql8 interfaceC19683ql8) {
        Parcel parcelB2 = B2();
        AbstractC13154fk8.f(parcelB2, interfaceC19683ql8);
        D2(17, parcelB2);
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public final void getCurrentScreenName(InterfaceC19683ql8 interfaceC19683ql8) {
        Parcel parcelB2 = B2();
        AbstractC13154fk8.f(parcelB2, interfaceC19683ql8);
        D2(16, parcelB2);
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public final void getGmpAppId(InterfaceC19683ql8 interfaceC19683ql8) {
        Parcel parcelB2 = B2();
        AbstractC13154fk8.f(parcelB2, interfaceC19683ql8);
        D2(21, parcelB2);
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public final void getMaxUserProperties(String str, InterfaceC19683ql8 interfaceC19683ql8) {
        Parcel parcelB2 = B2();
        parcelB2.writeString(str);
        AbstractC13154fk8.f(parcelB2, interfaceC19683ql8);
        D2(6, parcelB2);
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public final void getUserProperties(String str, String str2, boolean z, InterfaceC19683ql8 interfaceC19683ql8) {
        Parcel parcelB2 = B2();
        parcelB2.writeString(str);
        parcelB2.writeString(str2);
        AbstractC13154fk8.d(parcelB2, z);
        AbstractC13154fk8.f(parcelB2, interfaceC19683ql8);
        D2(5, parcelB2);
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public final void initialize(XZ2 xz2, zzcl zzclVar, long j) {
        Parcel parcelB2 = B2();
        AbstractC13154fk8.f(parcelB2, xz2);
        AbstractC13154fk8.e(parcelB2, zzclVar);
        parcelB2.writeLong(j);
        D2(1, parcelB2);
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public final void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        Parcel parcelB2 = B2();
        parcelB2.writeString(str);
        parcelB2.writeString(str2);
        AbstractC13154fk8.e(parcelB2, bundle);
        AbstractC13154fk8.d(parcelB2, z);
        AbstractC13154fk8.d(parcelB2, z2);
        parcelB2.writeLong(j);
        D2(2, parcelB2);
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public final void logHealthData(int i, String str, XZ2 xz2, XZ2 xz22, XZ2 xz23) {
        Parcel parcelB2 = B2();
        parcelB2.writeInt(5);
        parcelB2.writeString(str);
        AbstractC13154fk8.f(parcelB2, xz2);
        AbstractC13154fk8.f(parcelB2, xz22);
        AbstractC13154fk8.f(parcelB2, xz23);
        D2(33, parcelB2);
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public final void onActivityCreated(XZ2 xz2, Bundle bundle, long j) {
        Parcel parcelB2 = B2();
        AbstractC13154fk8.f(parcelB2, xz2);
        AbstractC13154fk8.e(parcelB2, bundle);
        parcelB2.writeLong(j);
        D2(27, parcelB2);
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public final void onActivityDestroyed(XZ2 xz2, long j) {
        Parcel parcelB2 = B2();
        AbstractC13154fk8.f(parcelB2, xz2);
        parcelB2.writeLong(j);
        D2(28, parcelB2);
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public final void onActivityPaused(XZ2 xz2, long j) {
        Parcel parcelB2 = B2();
        AbstractC13154fk8.f(parcelB2, xz2);
        parcelB2.writeLong(j);
        D2(29, parcelB2);
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public final void onActivityResumed(XZ2 xz2, long j) {
        Parcel parcelB2 = B2();
        AbstractC13154fk8.f(parcelB2, xz2);
        parcelB2.writeLong(j);
        D2(30, parcelB2);
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public final void onActivitySaveInstanceState(XZ2 xz2, InterfaceC19683ql8 interfaceC19683ql8, long j) {
        Parcel parcelB2 = B2();
        AbstractC13154fk8.f(parcelB2, xz2);
        AbstractC13154fk8.f(parcelB2, interfaceC19683ql8);
        parcelB2.writeLong(j);
        D2(31, parcelB2);
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public final void onActivityStarted(XZ2 xz2, long j) {
        Parcel parcelB2 = B2();
        AbstractC13154fk8.f(parcelB2, xz2);
        parcelB2.writeLong(j);
        D2(25, parcelB2);
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public final void onActivityStopped(XZ2 xz2, long j) {
        Parcel parcelB2 = B2();
        AbstractC13154fk8.f(parcelB2, xz2);
        parcelB2.writeLong(j);
        D2(26, parcelB2);
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public final void setConditionalUserProperty(Bundle bundle, long j) {
        Parcel parcelB2 = B2();
        AbstractC13154fk8.e(parcelB2, bundle);
        parcelB2.writeLong(j);
        D2(8, parcelB2);
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public final void setCurrentScreen(XZ2 xz2, String str, String str2, long j) {
        Parcel parcelB2 = B2();
        AbstractC13154fk8.f(parcelB2, xz2);
        parcelB2.writeString(str);
        parcelB2.writeString(str2);
        parcelB2.writeLong(j);
        D2(15, parcelB2);
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public final void setDataCollectionEnabled(boolean z) {
        Parcel parcelB2 = B2();
        AbstractC13154fk8.d(parcelB2, z);
        D2(39, parcelB2);
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public final void setUserProperty(String str, String str2, XZ2 xz2, boolean z, long j) {
        Parcel parcelB2 = B2();
        parcelB2.writeString(str);
        parcelB2.writeString(str2);
        AbstractC13154fk8.f(parcelB2, xz2);
        AbstractC13154fk8.d(parcelB2, z);
        parcelB2.writeLong(j);
        D2(4, parcelB2);
    }
}
