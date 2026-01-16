package com.google.android.gms.maps;

import android.app.Activity;
import android.os.RemoteException;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import ir.nasim.AbstractC13755gl8;
import ir.nasim.AbstractC17687nO3;
import ir.nasim.BG1;
import ir.nasim.CG4;
import ir.nasim.InterfaceC11618dJ4;
import ir.nasim.InterfaceC24259yJ4;
import ir.nasim.QZ2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
final class k extends BG1 {
    private final Fragment e;
    protected InterfaceC11618dJ4 f;
    private Activity g;
    private final List h = new ArrayList();

    k(Fragment fragment) {
        this.e = fragment;
    }

    static /* synthetic */ void v(k kVar, Activity activity) {
        kVar.g = activity;
        kVar.x();
    }

    @Override // ir.nasim.BG1
    protected final void a(InterfaceC11618dJ4 interfaceC11618dJ4) {
        this.f = interfaceC11618dJ4;
        x();
    }

    public final void w(InterfaceC24259yJ4 interfaceC24259yJ4) {
        if (b() != null) {
            ((j) b()).c(interfaceC24259yJ4);
        } else {
            this.h.add(interfaceC24259yJ4);
        }
    }

    public final void x() {
        if (this.g == null || this.f == null || b() != null) {
            return;
        }
        try {
            AbstractC17687nO3.a(this.g);
            QZ2 qz2U = AbstractC13755gl8.a(this.g, null).U(CG4.E2(this.g));
            if (qz2U == null) {
                return;
            }
            this.f.a(new j(this.e, qz2U));
            Iterator it = this.h.iterator();
            while (it.hasNext()) {
                ((j) b()).c((InterfaceC24259yJ4) it.next());
            }
            this.h.clear();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        } catch (GooglePlayServicesNotAvailableException unused) {
        }
    }
}
