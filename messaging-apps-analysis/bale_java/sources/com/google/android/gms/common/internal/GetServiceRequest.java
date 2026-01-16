package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes3.dex */
public class GetServiceRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new v();
    static final Scope[] o = new Scope[0];
    static final Feature[] p = new Feature[0];
    final int a;
    final int b;
    final int c;
    String d;
    IBinder e;
    Scope[] f;
    Bundle g;
    Account h;
    Feature[] i;
    Feature[] j;
    final boolean k;
    final int l;
    boolean m;
    private final String n;

    GetServiceRequest(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, Feature[] featureArr, Feature[] featureArr2, boolean z, int i4, boolean z2, String str2) {
        scopeArr = scopeArr == null ? o : scopeArr;
        bundle = bundle == null ? new Bundle() : bundle;
        featureArr = featureArr == null ? p : featureArr;
        featureArr2 = featureArr2 == null ? p : featureArr2;
        this.a = i;
        this.b = i2;
        this.c = i3;
        if ("com.google.android.gms".equals(str)) {
            this.d = "com.google.android.gms";
        } else {
            this.d = str;
        }
        if (i < 2) {
            this.h = iBinder != null ? AbstractBinderC2070a.D2(e.a.C2(iBinder)) : null;
        } else {
            this.e = iBinder;
            this.h = account;
        }
        this.f = scopeArr;
        this.g = bundle;
        this.i = featureArr;
        this.j = featureArr2;
        this.k = z;
        this.l = i4;
        this.m = z2;
        this.n = str2;
    }

    public final String P() {
        return this.n;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        v.a(this, parcel, i);
    }
}
