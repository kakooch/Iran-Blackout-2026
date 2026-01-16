package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import ir.nasim.AbstractC11916dl8;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.CG4;
import ir.nasim.InterfaceC12670f03;
import ir.nasim.InterfaceC12879fK4;
import ir.nasim.InterfaceC15678jz3;

/* loaded from: classes3.dex */
final class g implements InterfaceC15678jz3 {
    private final ViewGroup a;
    private final InterfaceC12670f03 b;
    private View c;

    public g(ViewGroup viewGroup, InterfaceC12670f03 interfaceC12670f03) {
        this.b = (InterfaceC12670f03) AbstractC3795Cj5.j(interfaceC12670f03);
        this.a = (ViewGroup) AbstractC3795Cj5.j(viewGroup);
    }

    @Override // ir.nasim.InterfaceC15678jz3
    public final void a(Activity activity, Bundle bundle, Bundle bundle2) {
        throw new UnsupportedOperationException("onInflate not allowed on StreetViewPanoramaViewDelegate");
    }

    @Override // ir.nasim.InterfaceC15678jz3
    public final View b(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        throw new UnsupportedOperationException("onCreateView not allowed on StreetViewPanoramaViewDelegate");
    }

    public final void c(InterfaceC12879fK4 interfaceC12879fK4) {
        try {
            this.b.X0(new f(this, interfaceC12879fK4));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Override // ir.nasim.InterfaceC15678jz3
    public final void f() {
        try {
            this.b.f();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Override // ir.nasim.InterfaceC15678jz3
    public final void i() {
        try {
            this.b.i();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Override // ir.nasim.InterfaceC15678jz3
    public final void k(Bundle bundle) {
        try {
            Bundle bundle2 = new Bundle();
            AbstractC11916dl8.b(bundle, bundle2);
            this.b.k(bundle2);
            AbstractC11916dl8.b(bundle2, bundle);
            this.c = (View) CG4.D2(this.b.getView());
            this.a.removeAllViews();
            this.a.addView(this.c);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Override // ir.nasim.InterfaceC15678jz3
    public final void l(Bundle bundle) {
        try {
            Bundle bundle2 = new Bundle();
            AbstractC11916dl8.b(bundle, bundle2);
            this.b.l(bundle2);
            AbstractC11916dl8.b(bundle2, bundle);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Override // ir.nasim.InterfaceC15678jz3
    public final void onDestroy() {
        try {
            this.b.onDestroy();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Override // ir.nasim.InterfaceC15678jz3
    public final void onLowMemory() {
        try {
            this.b.onLowMemory();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Override // ir.nasim.InterfaceC15678jz3
    public final void onPause() {
        try {
            this.b.onPause();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Override // ir.nasim.InterfaceC15678jz3
    public final void onResume() {
        try {
            this.b.onResume();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Override // ir.nasim.InterfaceC15678jz3
    public final void u() {
        throw new UnsupportedOperationException("onDestroyView not allowed on StreetViewPanoramaViewDelegate");
    }
}
