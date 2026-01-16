package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import ir.nasim.Ek8;
import ir.nasim.Gg8;

/* loaded from: classes3.dex */
public final class A extends Gg8 implements e {
    A(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
    }

    @Override // com.google.android.gms.common.internal.e
    public final Account c() {
        Parcel parcelB2 = B2(2, C2());
        Account account = (Account) Ek8.a(parcelB2, Account.CREATOR);
        parcelB2.recycle();
        return account;
    }
}
