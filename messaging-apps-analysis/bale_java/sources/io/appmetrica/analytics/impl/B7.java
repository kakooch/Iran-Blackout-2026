package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentsInitializer;
import ir.nasim.AbstractC13610gX0;

/* loaded from: classes3.dex */
public final class B7 implements ServiceComponentsInitializer {
    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentsInitializer
    public final void onCreate(Context context) {
        C3018zc c3018zc = C2586ha.C.s;
        InterfaceC2994yc[] interfaceC2994ycArr = {new C2867t5("io.appmetrica.analytics.remotepermissions.internal.RemotePermissionsModuleEntryPoint"), new C2614ie(context, "io.appmetrica.analytics.modules.ads", "lsm")};
        synchronized (c3018zc) {
            AbstractC13610gX0.E(c3018zc.a, interfaceC2994ycArr);
        }
    }
}
