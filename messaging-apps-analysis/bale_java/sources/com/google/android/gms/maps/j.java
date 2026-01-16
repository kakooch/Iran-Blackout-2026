package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import ir.nasim.AbstractC11916dl8;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.CG4;
import ir.nasim.InterfaceC15678jz3;
import ir.nasim.InterfaceC24259yJ4;
import ir.nasim.QZ2;
import ir.nasim.XZ2;

/* loaded from: classes3.dex */
final class j implements InterfaceC15678jz3 {
    private final Fragment a;
    private final QZ2 b;

    public j(Fragment fragment, QZ2 qz2) {
        this.b = (QZ2) AbstractC3795Cj5.j(qz2);
        this.a = (Fragment) AbstractC3795Cj5.j(fragment);
    }

    @Override // ir.nasim.InterfaceC15678jz3
    public final void a(Activity activity, Bundle bundle, Bundle bundle2) {
        GoogleMapOptions googleMapOptions = (GoogleMapOptions) bundle.getParcelable("MapOptions");
        try {
            Bundle bundle3 = new Bundle();
            AbstractC11916dl8.b(bundle2, bundle3);
            this.b.W1(CG4.E2(activity), googleMapOptions, bundle3);
            AbstractC11916dl8.b(bundle3, bundle2);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Override // ir.nasim.InterfaceC15678jz3
    public final View b(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            Bundle bundle2 = new Bundle();
            AbstractC11916dl8.b(bundle, bundle2);
            StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitAll().build());
            try {
                XZ2 xz2A2 = this.b.a2(CG4.E2(layoutInflater), CG4.E2(viewGroup), bundle2);
                StrictMode.setThreadPolicy(threadPolicy);
                AbstractC11916dl8.b(bundle2, bundle);
                return (View) CG4.D2(xz2A2);
            } catch (Throwable th) {
                StrictMode.setThreadPolicy(threadPolicy);
                throw th;
            }
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void c(InterfaceC24259yJ4 interfaceC24259yJ4) {
        try {
            this.b.w(new i(this, interfaceC24259yJ4));
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
            Bundle bundleE5 = this.a.E5();
            if (bundleE5 != null && bundleE5.containsKey("MapOptions")) {
                AbstractC11916dl8.c(bundle2, "MapOptions", bundleE5.getParcelable("MapOptions"));
            }
            this.b.k(bundle2);
            AbstractC11916dl8.b(bundle2, bundle);
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
        try {
            this.b.u();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
