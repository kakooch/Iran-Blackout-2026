package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import ir.nasim.AbstractC13755gl8;
import ir.nasim.AbstractC17687nO3;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.BG1;
import ir.nasim.CG4;
import ir.nasim.InterfaceC11618dJ4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
final class h extends BG1 {
    private final ViewGroup e;
    private final Context f;
    protected InterfaceC11618dJ4 g;
    private final StreetViewPanoramaOptions h;
    private final List i = new ArrayList();

    h(ViewGroup viewGroup, Context context, StreetViewPanoramaOptions streetViewPanoramaOptions) {
        this.e = viewGroup;
        this.f = context;
        this.h = streetViewPanoramaOptions;
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
            this.g.a(new g(this.e, AbstractC13755gl8.a(this.f, null).x1(CG4.E2(this.f), this.h)));
            Iterator it = this.i.iterator();
            while (it.hasNext()) {
                AbstractC18350oW3.a(it.next());
                ((g) b()).c(null);
            }
            this.i.clear();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        } catch (GooglePlayServicesNotAvailableException unused) {
        }
    }
}
