package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

/* renamed from: io.appmetrica.analytics.impl.y6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class ResultReceiverC2988y6 extends ResultReceiver {
    public final InterfaceC2964x6 a;

    public ResultReceiverC2988y6(Handler handler, InterfaceC2964x6 interfaceC2964x6) {
        super(handler);
        this.a = interfaceC2964x6;
    }

    public static void a(ResultReceiver resultReceiver, C2580h4 c2580h4) {
        if (resultReceiver != null) {
            Bundle bundle = new Bundle();
            c2580h4.b(bundle);
            resultReceiver.send(1, bundle);
        }
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.a.a(i, bundle);
    }

    public static void a(ResultReceiver resultReceiver, Ik ik, C2580h4 c2580h4) {
        if (resultReceiver != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("startup_error_key_code", ik.a);
            c2580h4.b(bundle);
            resultReceiver.send(2, bundle);
        }
    }
}
