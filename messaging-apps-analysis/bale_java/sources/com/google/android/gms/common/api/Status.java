package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import ir.nasim.AbstractC21804u96;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.DG4;
import ir.nasim.InterfaceC10069b16;
import ir.nasim.ZZ0;

/* loaded from: classes3.dex */
public final class Status extends AbstractSafeParcelable implements InterfaceC10069b16, ReflectedParcelable {
    private final int a;
    private final String b;
    private final PendingIntent c;
    private final ConnectionResult d;
    public static final Status e = new Status(-1);
    public static final Status f = new Status(0);
    public static final Status g = new Status(14);
    public static final Status h = new Status(8);
    public static final Status i = new Status(15);
    public static final Status j = new Status(16);
    public static final Status l = new Status(17);
    public static final Status k = new Status(18);
    public static final Parcelable.Creator<Status> CREATOR = new e();

    Status(int i2, String str, PendingIntent pendingIntent, ConnectionResult connectionResult) {
        this.a = i2;
        this.b = str;
        this.c = pendingIntent;
        this.d = connectionResult;
    }

    public void A0(Activity activity, int i2) throws IntentSender.SendIntentException {
        if (s0()) {
            PendingIntent pendingIntent = this.c;
            AbstractC3795Cj5.j(pendingIntent);
            activity.startIntentSenderForResult(pendingIntent.getIntentSender(), i2, null, 0, 0, 0);
        }
    }

    public final String C0() {
        String str = this.b;
        return str != null ? str : ZZ0.a(this.a);
    }

    public ConnectionResult P() {
        return this.d;
    }

    public int S() {
        return this.a;
    }

    public String d0() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.a == status.a && DG4.a(this.b, status.b) && DG4.a(this.c, status.c) && DG4.a(this.d, status.d);
    }

    public int hashCode() {
        return DG4.b(Integer.valueOf(this.a), this.b, this.c, this.d);
    }

    @Override // ir.nasim.InterfaceC10069b16
    public Status j() {
        return this;
    }

    public boolean s0() {
        return this.c != null;
    }

    public String toString() {
        DG4.a aVarC = DG4.c(this);
        aVarC.a("statusCode", C0());
        aVarC.a("resolution", this.c);
        return aVarC.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.n(parcel, 1, S());
        AbstractC21804u96.t(parcel, 2, d0(), false);
        AbstractC21804u96.s(parcel, 3, this.c, i2, false);
        AbstractC21804u96.s(parcel, 4, P(), i2, false);
        AbstractC21804u96.b(parcel, iA);
    }

    public boolean x0() {
        return this.a <= 0;
    }

    public Status(int i2) {
        this(i2, (String) null);
    }

    public Status(ConnectionResult connectionResult, String str) {
        this(connectionResult, str, 17);
    }

    public Status(int i2, String str) {
        this(i2, str, (PendingIntent) null);
    }

    public Status(ConnectionResult connectionResult, String str, int i2) {
        this(i2, str, connectionResult.d0(), connectionResult);
    }

    public Status(int i2, String str, PendingIntent pendingIntent) {
        this(i2, str, pendingIntent, null);
    }
}
