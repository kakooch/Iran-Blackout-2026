package com.google.android.gms.internal.location;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.C2060d;
import com.google.android.gms.location.LastLocationRequest;
import com.google.android.gms.location.LocationRequest;
import ir.nasim.AbstractC12598es8;
import ir.nasim.C23773xV0;
import ir.nasim.C24792zC6;
import ir.nasim.C4982Hj7;
import ir.nasim.Fl8;
import ir.nasim.InterfaceC11374ct8;
import ir.nasim.InterfaceC17823nd1;
import ir.nasim.ZI4;

/* loaded from: classes3.dex */
public final class i extends com.google.android.gms.common.internal.c {
    private final C24792zC6 A0;
    private final C24792zC6 B0;
    private final C24792zC6 z0;

    public i(Context context, Looper looper, C23773xV0 c23773xV0, InterfaceC17823nd1 interfaceC17823nd1, ZI4 zi4) {
        super(context, looper, 23, c23773xV0, interfaceC17823nd1, zi4);
        this.z0 = new C24792zC6();
        this.A0 = new C24792zC6();
        this.B0 = new C24792zC6();
    }

    private final boolean n0(Feature feature) {
        Feature feature2;
        Feature[] featureArrO = o();
        if (featureArrO == null) {
            return false;
        }
        int length = featureArrO.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                feature2 = null;
                break;
            }
            feature2 = featureArrO[i];
            if (feature.P().equals(feature2.P())) {
                break;
            }
            i++;
        }
        return feature2 != null && feature2.S() >= feature.S();
    }

    @Override // com.google.android.gms.common.internal.b
    protected final String E() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    @Override // com.google.android.gms.common.internal.b
    protected final String F() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    @Override // com.google.android.gms.common.internal.b
    public final void M(int i) {
        super.M(i);
        synchronized (this.z0) {
            this.z0.clear();
        }
        synchronized (this.A0) {
            this.A0.clear();
        }
        synchronized (this.B0) {
            this.B0.clear();
        }
    }

    @Override // com.google.android.gms.common.internal.b
    public final boolean S() {
        return true;
    }

    public final void m0(C2060d.a aVar, boolean z, C4982Hj7 c4982Hj7) {
        synchronized (this.A0) {
            try {
                h hVar = (h) this.A0.remove(aVar);
                if (hVar == null) {
                    c4982Hj7.c(Boolean.FALSE);
                    return;
                }
                hVar.F2();
                if (!z) {
                    c4982Hj7.c(Boolean.TRUE);
                } else if (n0(AbstractC12598es8.j)) {
                    ((InterfaceC11374ct8) D()).W0(zzdb.P(null, hVar, null, null), new a(this, Boolean.TRUE, c4982Hj7));
                } else {
                    ((InterfaceC11374ct8) D()).w1(new zzdf(2, null, null, hVar, null, new c(Boolean.TRUE, c4982Hj7), null));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.b, com.google.android.gms.common.api.a.f
    public final int n() {
        return 11717000;
    }

    public final void o0(LastLocationRequest lastLocationRequest, C4982Hj7 c4982Hj7) {
        y();
        if (n0(AbstractC12598es8.f)) {
            ((InterfaceC11374ct8) D()).v2(lastLocationRequest, new b(this, c4982Hj7));
        } else {
            c4982Hj7.c(((InterfaceC11374ct8) D()).d());
        }
    }

    public final void p0(Fl8 fl8, LocationRequest locationRequest, C4982Hj7 c4982Hj7) {
        h hVar;
        C2060d c2060dZza = fl8.zza();
        C2060d.a aVarB = c2060dZza.b();
        aVarB.getClass();
        boolean zN0 = n0(AbstractC12598es8.j);
        synchronized (this.A0) {
            try {
                h hVar2 = (h) this.A0.get(aVarB);
                if (hVar2 == null || zN0) {
                    h hVar3 = new h(fl8);
                    this.A0.put(aVarB, hVar3);
                    hVar = hVar3;
                } else {
                    hVar2.E2(c2060dZza);
                    hVar = hVar2;
                    hVar2 = null;
                }
                y();
                String strA = aVarB.a();
                if (zN0) {
                    ((InterfaceC11374ct8) D()).j2(zzdb.P(hVar2, hVar, null, strA), locationRequest, new a(this, null, c4982Hj7));
                } else {
                    InterfaceC11374ct8 interfaceC11374ct8 = (InterfaceC11374ct8) D();
                    LocationRequest.a aVar = new LocationRequest.a(locationRequest);
                    aVar.h(null);
                    interfaceC11374ct8.w1(new zzdf(1, zzdd.P(null, aVar.a()), null, hVar, null, new d(c4982Hj7, hVar), strA));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.b
    protected final /* synthetic */ IInterface s(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        return iInterfaceQueryLocalInterface instanceof InterfaceC11374ct8 ? (InterfaceC11374ct8) iInterfaceQueryLocalInterface : new o(iBinder);
    }

    @Override // com.google.android.gms.common.internal.b
    public final Feature[] v() {
        return AbstractC12598es8.l;
    }
}
