package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import io.appmetrica.analytics.coreutils.internal.services.telephony.CellularNetworkTypeExtractor;
import ir.nasim.AbstractC18000nu8;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.Xs8;

/* loaded from: classes3.dex */
final class x implements Handler.Callback {
    final /* synthetic */ y a;

    /* synthetic */ x(y yVar, AbstractC18000nu8 abstractC18000nu8) {
        this.a = yVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            synchronized (this.a.f) {
                try {
                    Xs8 xs8 = (Xs8) message.obj;
                    w wVar = (w) this.a.f.get(xs8);
                    if (wVar != null && wVar.i()) {
                        if (wVar.j()) {
                            wVar.g("GmsClientSupervisor");
                        }
                        this.a.f.remove(xs8);
                    }
                } finally {
                }
            }
            return true;
        }
        if (i != 1) {
            return false;
        }
        synchronized (this.a.f) {
            try {
                Xs8 xs82 = (Xs8) message.obj;
                w wVar2 = (w) this.a.f.get(xs82);
                if (wVar2 != null && wVar2.a() == 3) {
                    Log.e("GmsClientSupervisor", "Timeout waiting for ServiceConnection callback " + String.valueOf(xs82), new Exception());
                    ComponentName componentNameB = wVar2.b();
                    if (componentNameB == null) {
                        componentNameB = xs82.a();
                    }
                    if (componentNameB == null) {
                        String strC = xs82.c();
                        AbstractC3795Cj5.j(strC);
                        componentNameB = new ComponentName(strC, CellularNetworkTypeExtractor.UNKNOWN_NETWORK_TYPE_VALUE);
                    }
                    wVar2.onServiceDisconnected(componentNameB);
                }
            } finally {
            }
        }
        return true;
    }
}
