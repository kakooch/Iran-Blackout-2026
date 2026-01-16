package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.e;

/* renamed from: com.google.android.gms.common.internal.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractBinderC2070a extends e.a {
    public static Account D2(e eVar) {
        Account accountC = null;
        if (eVar != null) {
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                try {
                    accountC = eVar.c();
                } catch (RemoteException unused) {
                    Log.w("AccountAccessor", "Remote account accessor probably died");
                }
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        }
        return accountC;
    }
}
