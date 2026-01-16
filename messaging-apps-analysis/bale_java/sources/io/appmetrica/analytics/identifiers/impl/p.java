package io.appmetrica.analytics.identifiers.impl;

import android.os.IBinder;
import android.os.IInterface;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.UA2;

/* loaded from: classes3.dex */
public final class p extends AbstractC8614Ws3 implements UA2 {
    public static final p a = new p();

    public p() {
        super(1);
    }

    @Override // ir.nasim.UA2
    public final Object invoke(Object obj) {
        IBinder iBinder = (IBinder) obj;
        int i = t.a;
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.yandex.android.advid.service.YandexAdvIdInterface");
        return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof u)) ? new s(iBinder) : (u) iInterfaceQueryLocalInterface;
    }
}
