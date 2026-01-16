package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import ir.nasim.AbstractC21804u96;

/* loaded from: classes3.dex */
public final class v implements Parcelable.Creator {
    static void a(GetServiceRequest getServiceRequest, Parcel parcel, int i) {
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.n(parcel, 1, getServiceRequest.a);
        AbstractC21804u96.n(parcel, 2, getServiceRequest.b);
        AbstractC21804u96.n(parcel, 3, getServiceRequest.c);
        AbstractC21804u96.t(parcel, 4, getServiceRequest.d, false);
        AbstractC21804u96.m(parcel, 5, getServiceRequest.e, false);
        AbstractC21804u96.w(parcel, 6, getServiceRequest.f, i, false);
        AbstractC21804u96.e(parcel, 7, getServiceRequest.g, false);
        AbstractC21804u96.s(parcel, 8, getServiceRequest.h, i, false);
        AbstractC21804u96.w(parcel, 10, getServiceRequest.i, i, false);
        AbstractC21804u96.w(parcel, 11, getServiceRequest.j, i, false);
        AbstractC21804u96.c(parcel, 12, getServiceRequest.k);
        AbstractC21804u96.n(parcel, 13, getServiceRequest.l);
        AbstractC21804u96.c(parcel, 14, getServiceRequest.m);
        AbstractC21804u96.t(parcel, 15, getServiceRequest.P(), false);
        AbstractC21804u96.b(parcel, iA);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iB = SafeParcelReader.B(parcel);
        Scope[] scopeArr = GetServiceRequest.o;
        Bundle bundle = new Bundle();
        Feature[] featureArr = GetServiceRequest.p;
        Feature[] featureArr2 = featureArr;
        String strF = null;
        IBinder iBinderU = null;
        Account account = null;
        String strF2 = null;
        int iV = 0;
        int iV2 = 0;
        int iV3 = 0;
        boolean zM = false;
        int iV4 = 0;
        boolean zM2 = false;
        while (parcel.dataPosition() < iB) {
            int iT = SafeParcelReader.t(parcel);
            switch (SafeParcelReader.l(iT)) {
                case 1:
                    iV = SafeParcelReader.v(parcel, iT);
                    break;
                case 2:
                    iV2 = SafeParcelReader.v(parcel, iT);
                    break;
                case 3:
                    iV3 = SafeParcelReader.v(parcel, iT);
                    break;
                case 4:
                    strF = SafeParcelReader.f(parcel, iT);
                    break;
                case 5:
                    iBinderU = SafeParcelReader.u(parcel, iT);
                    break;
                case 6:
                    scopeArr = (Scope[]) SafeParcelReader.i(parcel, iT, Scope.CREATOR);
                    break;
                case 7:
                    bundle = SafeParcelReader.a(parcel, iT);
                    break;
                case 8:
                    account = (Account) SafeParcelReader.e(parcel, iT, Account.CREATOR);
                    break;
                case 9:
                default:
                    SafeParcelReader.A(parcel, iT);
                    break;
                case 10:
                    featureArr = (Feature[]) SafeParcelReader.i(parcel, iT, Feature.CREATOR);
                    break;
                case 11:
                    featureArr2 = (Feature[]) SafeParcelReader.i(parcel, iT, Feature.CREATOR);
                    break;
                case 12:
                    zM = SafeParcelReader.m(parcel, iT);
                    break;
                case 13:
                    iV4 = SafeParcelReader.v(parcel, iT);
                    break;
                case 14:
                    zM2 = SafeParcelReader.m(parcel, iT);
                    break;
                case 15:
                    strF2 = SafeParcelReader.f(parcel, iT);
                    break;
            }
        }
        SafeParcelReader.k(parcel, iB);
        return new GetServiceRequest(iV, iV2, iV3, strF, iBinderU, scopeArr, bundle, account, featureArr, featureArr2, zM, iV4, zM2, strF2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new GetServiceRequest[i];
    }
}
