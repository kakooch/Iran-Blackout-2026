package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import ir.nasim.AbstractC13755gl8;
import ir.nasim.AbstractC17687nO3;
import ir.nasim.BG1;
import ir.nasim.CG4;
import ir.nasim.InterfaceC11618dJ4;
import ir.nasim.InterfaceC24259yJ4;
import ir.nasim.RZ2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
final class d extends BG1 {
    private final ViewGroup e;
    private final Context f;
    protected InterfaceC11618dJ4 g;
    private final GoogleMapOptions h;
    private final List i = new ArrayList();

    d(ViewGroup viewGroup, Context context, GoogleMapOptions googleMapOptions) {
        this.e = viewGroup;
        this.f = context;
        this.h = googleMapOptions;
    }

    @Override // ir.nasim.BG1
    protected final void a(InterfaceC11618dJ4 interfaceC11618dJ4) {
        this.g = interfaceC11618dJ4;
        v();
    }

    public final void v() {
        if (this.g == null || b() != null) {
            return;
        }
        try {
            AbstractC17687nO3.a(this.f);
            RZ2 rz2Q1 = AbstractC13755gl8.a(this.f, null).Q1(CG4.E2(this.f), this.h);
            if (rz2Q1 == null) {
                return;
            }
            this.g.a(new c(this.e, rz2Q1));
            Iterator it = this.i.iterator();
            while (it.hasNext()) {
                ((c) b()).c((InterfaceC24259yJ4) it.next());
            }
            this.i.clear();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        } catch (GooglePlayServicesNotAvailableException unused) {
        }
    }
}
