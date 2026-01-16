package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import ir.nasim.AbstractBinderC10511bj8;

/* loaded from: classes3.dex */
public interface e extends IInterface {

    public static abstract class a extends AbstractBinderC10511bj8 implements e {
        public static e C2(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            return iInterfaceQueryLocalInterface instanceof e ? (e) iInterfaceQueryLocalInterface : new A(iBinder);
        }
    }

    Account c();
}
