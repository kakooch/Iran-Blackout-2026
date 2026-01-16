package com.google.android.gms.common.api.internal;

import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
/* loaded from: classes.dex */
public class zai extends zal {
    private final SparseArray<zaa> zad;

    public static zai zaa(LifecycleActivity lifecycleActivity) {
        LifecycleFragment fragment = LifecycleCallback.getFragment(lifecycleActivity);
        zai zaiVar = (zai) fragment.getCallbackOrNull("AutoManageHelper", zai.class);
        return zaiVar != null ? zaiVar : new zai(fragment);
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
    private class zaa implements GoogleApiClient.OnConnectionFailedListener {
        public final int zaa;
        public final GoogleApiClient zab;
        public final GoogleApiClient.OnConnectionFailedListener zac;

        public zaa(int i, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            this.zaa = i;
            this.zab = googleApiClient;
            this.zac = onConnectionFailedListener;
        }

        @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
        public final void onConnectionFailed(ConnectionResult connectionResult) {
            String strValueOf = String.valueOf(connectionResult);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 27);
            sb.append("beginFailureResolution for ");
            sb.append(strValueOf);
            Log.d("AutoManageHelper", sb.toString());
            zai.this.zab(connectionResult, this.zaa);
        }
    }

    private zai(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment);
        this.zad = new SparseArray<>();
        this.mLifecycleFragment.addCallback("AutoManageHelper", this);
    }

    public final void zaa(int i, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Preconditions.checkNotNull(googleApiClient, "GoogleApiClient instance cannot be null");
        boolean z = this.zad.indexOfKey(i) < 0;
        StringBuilder sb = new StringBuilder(54);
        sb.append("Already managing a GoogleApiClient with id ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        zak zakVar = this.zab.get();
        boolean z2 = this.zaa;
        String strValueOf = String.valueOf(zakVar);
        StringBuilder sb2 = new StringBuilder(strValueOf.length() + 49);
        sb2.append("starting AutoManage for client ");
        sb2.append(i);
        sb2.append(" ");
        sb2.append(z2);
        sb2.append(" ");
        sb2.append(strValueOf);
        Log.d("AutoManageHelper", sb2.toString());
        zaa zaaVar = new zaa(i, googleApiClient, onConnectionFailedListener);
        googleApiClient.registerConnectionFailedListener(zaaVar);
        this.zad.put(i, zaaVar);
        if (this.zaa && zakVar == null) {
            String strValueOf2 = String.valueOf(googleApiClient);
            StringBuilder sb3 = new StringBuilder(strValueOf2.length() + 11);
            sb3.append("connecting ");
            sb3.append(strValueOf2);
            Log.d("AutoManageHelper", sb3.toString());
            googleApiClient.connect();
        }
    }

    public final void zaa(int i) {
        zaa zaaVar = this.zad.get(i);
        this.zad.remove(i);
        if (zaaVar != null) {
            zaaVar.zab.unregisterConnectionFailedListener(zaaVar);
            zaaVar.zab.disconnect();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zal, com.google.android.gms.common.api.internal.LifecycleCallback
    public void onStart() {
        super.onStart();
        boolean z = this.zaa;
        String strValueOf = String.valueOf(this.zad);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 14);
        sb.append("onStart ");
        sb.append(z);
        sb.append(" ");
        sb.append(strValueOf);
        Log.d("AutoManageHelper", sb.toString());
        if (this.zab.get() == null) {
            for (int i = 0; i < this.zad.size(); i++) {
                zaa zaaVarZab = zab(i);
                if (zaaVarZab != null) {
                    zaaVarZab.zab.connect();
                }
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zal, com.google.android.gms.common.api.internal.LifecycleCallback
    public void onStop() {
        super.onStop();
        for (int i = 0; i < this.zad.size(); i++) {
            zaa zaaVarZab = zab(i);
            if (zaaVarZab != null) {
                zaaVarZab.zab.disconnect();
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        for (int i = 0; i < this.zad.size(); i++) {
            zaa zaaVarZab = zab(i);
            if (zaaVarZab != null) {
                printWriter.append((CharSequence) str).append("GoogleApiClient #").print(zaaVarZab.zaa);
                printWriter.println(":");
                zaaVarZab.zab.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zal
    protected final void zaa(ConnectionResult connectionResult, int i) {
        Log.w("AutoManageHelper", "Unresolved error while connecting client. Stopping auto-manage.");
        if (i < 0) {
            Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
            return;
        }
        zaa zaaVar = this.zad.get(i);
        if (zaaVar != null) {
            zaa(i);
            GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = zaaVar.zac;
            if (onConnectionFailedListener != null) {
                onConnectionFailedListener.onConnectionFailed(connectionResult);
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zal
    protected final void zaa() {
        for (int i = 0; i < this.zad.size(); i++) {
            zaa zaaVarZab = zab(i);
            if (zaaVarZab != null) {
                zaaVarZab.zab.connect();
            }
        }
    }

    private final zaa zab(int i) {
        if (this.zad.size() <= i) {
            return null;
        }
        SparseArray<zaa> sparseArray = this.zad;
        return sparseArray.get(sparseArray.keyAt(i));
    }
}
