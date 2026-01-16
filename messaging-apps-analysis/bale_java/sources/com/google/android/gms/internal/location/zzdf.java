package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import ir.nasim.AbstractBinderC21660tu8;
import ir.nasim.AbstractC21804u96;
import ir.nasim.Bu8;
import ir.nasim.InterfaceC13224fr8;
import ir.nasim.InterfaceC15055iv8;
import ir.nasim.Zu8;

@Deprecated
/* loaded from: classes3.dex */
public final class zzdf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdf> CREATOR = new l();
    private final int a;
    private final zzdd b;
    private final InterfaceC15055iv8 c;
    private final Bu8 d;
    private final PendingIntent e;
    private final InterfaceC13224fr8 f;
    private final String g;

    zzdf(int i, zzdd zzddVar, IBinder iBinder, IBinder iBinder2, PendingIntent pendingIntent, IBinder iBinder3, String str) {
        this.a = i;
        this.b = zzddVar;
        InterfaceC13224fr8 nVar = null;
        this.c = iBinder != null ? Zu8.C2(iBinder) : null;
        this.e = pendingIntent;
        this.d = iBinder2 != null ? AbstractBinderC21660tu8.C2(iBinder2) : null;
        if (iBinder3 != null) {
            IInterface iInterfaceQueryLocalInterface = iBinder3.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            nVar = iInterfaceQueryLocalInterface instanceof InterfaceC13224fr8 ? (InterfaceC13224fr8) iInterfaceQueryLocalInterface : new n(iBinder3);
        }
        this.f = nVar;
        this.g = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.n(parcel, 1, this.a);
        AbstractC21804u96.s(parcel, 2, this.b, i, false);
        InterfaceC15055iv8 interfaceC15055iv8 = this.c;
        AbstractC21804u96.m(parcel, 3, interfaceC15055iv8 == null ? null : interfaceC15055iv8.asBinder(), false);
        AbstractC21804u96.s(parcel, 4, this.e, i, false);
        Bu8 bu8 = this.d;
        AbstractC21804u96.m(parcel, 5, bu8 == null ? null : bu8.asBinder(), false);
        InterfaceC13224fr8 interfaceC13224fr8 = this.f;
        AbstractC21804u96.m(parcel, 6, interfaceC13224fr8 != null ? interfaceC13224fr8.asBinder() : null, false);
        AbstractC21804u96.t(parcel, 8, this.g, false);
        AbstractC21804u96.b(parcel, iA);
    }
}
