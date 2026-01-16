package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

/* loaded from: classes3.dex */
public final class If extends ResultReceiver {
    public final InterfaceC2853sf a;

    public If(Handler handler, InterfaceC2853sf interfaceC2853sf) {
        super(handler);
        this.a = interfaceC2853sf;
    }

    public static void a(ResultReceiver resultReceiver, Cf cf) {
        if (resultReceiver != null) {
            Bundle bundle = new Bundle();
            bundle.putByteArray("referrer", cf == null ? null : cf.a());
            resultReceiver.send(1, bundle);
        }
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i, Bundle bundle) {
        if (i == 1) {
            Cf cf = null;
            try {
                byte[] byteArray = bundle.getByteArray("referrer");
                if (byteArray != null && byteArray.length != 0) {
                    cf = new Cf(byteArray);
                }
            } catch (Throwable unused) {
            }
            this.a.a(cf);
        }
    }
}
