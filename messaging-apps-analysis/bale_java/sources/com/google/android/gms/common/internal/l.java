package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.view.View;
import com.google.android.gms.dynamic.RemoteCreator;
import ir.nasim.CG4;

/* loaded from: classes3.dex */
public final class l extends RemoteCreator {
    private static final l c = new l();

    private l() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    public static View c(Context context, int i, int i2) throws RemoteCreator.RemoteCreatorException {
        l lVar = c;
        try {
            return (View) CG4.D2(((h) lVar.b(context)).F2(CG4.E2(context), new zax(1, i, i2, null)));
        } catch (Exception e) {
            throw new RemoteCreator.RemoteCreatorException("Could not get button with size " + i + " and color " + i2, e);
        }
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    public final /* synthetic */ Object a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
        return iInterfaceQueryLocalInterface instanceof h ? (h) iInterfaceQueryLocalInterface : new h(iBinder);
    }
}
