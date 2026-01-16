package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.InterfaceC24259yJ4;

/* loaded from: classes3.dex */
public class SupportMapFragment extends Fragment {
    private final k W0 = new k(this);

    @Override // androidx.fragment.app.Fragment
    public void G6(Bundle bundle) {
        ClassLoader classLoader = SupportMapFragment.class.getClassLoader();
        if (bundle != null && classLoader != null) {
            bundle.setClassLoader(classLoader);
        }
        super.G6(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void I6(Activity activity) {
        super.I6(activity);
        k.v(this.W0, activity);
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle bundle) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitAll().build());
        try {
            super.M6(bundle);
            this.W0.d(bundle);
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewE = this.W0.e(layoutInflater, viewGroup, bundle);
        viewE.setClickable(true);
        return viewE;
    }

    @Override // androidx.fragment.app.Fragment
    public void R6() {
        this.W0.f();
        super.R6();
    }

    @Override // androidx.fragment.app.Fragment
    public void T6() {
        this.W0.g();
        super.T6();
    }

    @Override // androidx.fragment.app.Fragment
    public void X6(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitAll().build());
        try {
            super.X6(activity, attributeSet, bundle);
            k.v(this.W0, activity);
            GoogleMapOptions googleMapOptionsX0 = GoogleMapOptions.x0(activity, attributeSet);
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("MapOptions", googleMapOptionsX0);
            this.W0.h(activity, bundle2, bundle);
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void a8(Bundle bundle) {
        super.a8(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void c7() {
        this.W0.j();
        super.c7();
    }

    @Override // androidx.fragment.app.Fragment
    public void h7() {
        super.h7();
        this.W0.k();
    }

    @Override // androidx.fragment.app.Fragment
    public void i7(Bundle bundle) {
        ClassLoader classLoader = SupportMapFragment.class.getClassLoader();
        if (bundle != null && classLoader != null) {
            bundle.setClassLoader(classLoader);
        }
        super.i7(bundle);
        this.W0.l(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void j7() {
        super.j7();
        this.W0.m();
    }

    @Override // androidx.fragment.app.Fragment
    public void k7() {
        this.W0.n();
        super.k7();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        this.W0.i();
        super.onLowMemory();
    }

    public void r8(InterfaceC24259yJ4 interfaceC24259yJ4) {
        AbstractC3795Cj5.e("getMapAsync must be called on the main thread.");
        AbstractC3795Cj5.k(interfaceC24259yJ4, "callback must not be null.");
        this.W0.w(interfaceC24259yJ4);
    }
}
