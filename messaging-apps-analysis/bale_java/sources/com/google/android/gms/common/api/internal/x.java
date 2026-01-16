package com.google.android.gms.common.api.internal;

import android.os.SystemClock;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.tasks.Task;
import ir.nasim.C46;
import ir.nasim.C9205Yy;
import ir.nasim.VJ;
import ir.nasim.WI4;

/* loaded from: classes3.dex */
final class x implements WI4 {
    private final C2059c a;
    private final int b;
    private final C9205Yy c;
    private final long d;
    private final long e;

    x(C2059c c2059c, int i, C9205Yy c9205Yy, long j, long j2, String str, String str2) {
        this.a = c2059c;
        this.b = i;
        this.c = c9205Yy;
        this.d = j;
        this.e = j2;
    }

    static x a(C2059c c2059c, int i, C9205Yy c9205Yy) {
        boolean zS0;
        if (!c2059c.g()) {
            return null;
        }
        RootTelemetryConfiguration rootTelemetryConfigurationA = C46.b().a();
        if (rootTelemetryConfigurationA == null) {
            zS0 = true;
        } else {
            if (!rootTelemetryConfigurationA.d0()) {
                return null;
            }
            zS0 = rootTelemetryConfigurationA.s0();
            s sVarX = c2059c.x(c9205Yy);
            if (sVarX != null) {
                if (!(sVarX.r() instanceof com.google.android.gms.common.internal.b)) {
                    return null;
                }
                com.google.android.gms.common.internal.b bVar = (com.google.android.gms.common.internal.b) sVarX.r();
                if (bVar.J() && !bVar.d()) {
                    ConnectionTelemetryConfiguration connectionTelemetryConfigurationB = b(sVarX, bVar, i);
                    if (connectionTelemetryConfigurationB == null) {
                        return null;
                    }
                    sVarX.C();
                    zS0 = connectionTelemetryConfigurationB.x0();
                }
            }
        }
        return new x(c2059c, i, c9205Yy, zS0 ? System.currentTimeMillis() : 0L, zS0 ? SystemClock.elapsedRealtime() : 0L, null, null);
    }

    private static ConnectionTelemetryConfiguration b(s sVar, com.google.android.gms.common.internal.b bVar, int i) {
        int[] iArrS;
        int[] iArrD0;
        ConnectionTelemetryConfiguration connectionTelemetryConfigurationH = bVar.H();
        if (connectionTelemetryConfigurationH == null || !connectionTelemetryConfigurationH.s0() || ((iArrS = connectionTelemetryConfigurationH.S()) != null ? !VJ.b(iArrS, i) : !((iArrD0 = connectionTelemetryConfigurationH.d0()) == null || !VJ.b(iArrD0, i))) || sVar.p() >= connectionTelemetryConfigurationH.P()) {
            return null;
        }
        return connectionTelemetryConfigurationH;
    }

    @Override // ir.nasim.WI4
    public final void onComplete(Task task) {
        s sVarX;
        int iX0;
        int i;
        int i2;
        int iP;
        long j;
        long j2;
        int iElapsedRealtime;
        if (this.a.g()) {
            RootTelemetryConfiguration rootTelemetryConfigurationA = C46.b().a();
            if ((rootTelemetryConfigurationA == null || rootTelemetryConfigurationA.d0()) && (sVarX = this.a.x(this.c)) != null && (sVarX.r() instanceof com.google.android.gms.common.internal.b)) {
                com.google.android.gms.common.internal.b bVar = (com.google.android.gms.common.internal.b) sVarX.r();
                int i3 = 0;
                boolean zS0 = this.d > 0;
                int iZ = bVar.z();
                if (rootTelemetryConfigurationA != null) {
                    zS0 &= rootTelemetryConfigurationA.s0();
                    int iP2 = rootTelemetryConfigurationA.P();
                    int iS = rootTelemetryConfigurationA.S();
                    iX0 = rootTelemetryConfigurationA.x0();
                    if (bVar.J() && !bVar.d()) {
                        ConnectionTelemetryConfiguration connectionTelemetryConfigurationB = b(sVarX, bVar, this.b);
                        if (connectionTelemetryConfigurationB == null) {
                            return;
                        }
                        boolean z = connectionTelemetryConfigurationB.x0() && this.d > 0;
                        iS = connectionTelemetryConfigurationB.P();
                        zS0 = z;
                    }
                    i2 = iP2;
                    i = iS;
                } else {
                    iX0 = 0;
                    i = 100;
                    i2 = 5000;
                }
                C2059c c2059c = this.a;
                if (task.p()) {
                    iP = 0;
                } else {
                    if (task.n()) {
                        i3 = 100;
                    } else {
                        Exception excK = task.k();
                        if (excK instanceof ApiException) {
                            Status statusA = ((ApiException) excK).a();
                            int iS2 = statusA.S();
                            ConnectionResult connectionResultP = statusA.P();
                            iP = connectionResultP == null ? -1 : connectionResultP.P();
                            i3 = iS2;
                        } else {
                            i3 = 101;
                        }
                    }
                    iP = -1;
                }
                if (zS0) {
                    long j3 = this.d;
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    iElapsedRealtime = (int) (SystemClock.elapsedRealtime() - this.e);
                    j = j3;
                    j2 = jCurrentTimeMillis;
                } else {
                    j = 0;
                    j2 = 0;
                    iElapsedRealtime = -1;
                }
                c2059c.I(new MethodInvocation(this.b, i3, iP, j, j2, null, null, iZ, iElapsedRealtime), iX0, i2, i);
            }
        }
    }
}
