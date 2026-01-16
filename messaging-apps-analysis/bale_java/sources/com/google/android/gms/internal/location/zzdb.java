package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import ir.nasim.AbstractC21804u96;
import ir.nasim.Bu8;

/* loaded from: classes3.dex */
public final class zzdb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdb> CREATOR = new j();
    private final int a;
    private final IBinder b;
    private final IBinder c;
    private final PendingIntent d;
    private final String e;
    private final String f;

    zzdb(int i, IBinder iBinder, IBinder iBinder2, PendingIntent pendingIntent, String str, String str2) {
        this.a = i;
        this.b = iBinder;
        this.c = iBinder2;
        this.d = pendingIntent;
        this.e = Build.VERSION.SDK_INT >= 30 ? null : str;
        this.f = str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.os.IBinder] */
    /* JADX WARN: Type inference failed for: r8v0, types: [android.os.IBinder, ir.nasim.Bu8] */
    public static zzdb P(IInterface iInterface, Bu8 bu8, String str, String str2) {
        if (iInterface == null) {
            iInterface = null;
        }
        return new zzdb(2, iInterface, bu8, null, null, str2);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.n(parcel, 1, this.a);
        AbstractC21804u96.m(parcel, 2, this.b, false);
        AbstractC21804u96.m(parcel, 3, this.c, false);
        AbstractC21804u96.s(parcel, 4, this.d, i, false);
        AbstractC21804u96.t(parcel, 5, this.e, false);
        AbstractC21804u96.t(parcel, 6, this.f, false);
        AbstractC21804u96.b(parcel, iA);
    }
}
