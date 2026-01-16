package com.google.android.exoplayer2.scheduler;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC9683aN7;

/* loaded from: classes2.dex */
public final class Requirements implements Parcelable {
    public static final Parcelable.Creator<Requirements> CREATOR = new a();
    private final int a;

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Requirements createFromParcel(Parcel parcel) {
            return new Requirements(parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Requirements[] newArray(int i) {
            return new Requirements[i];
        }
    }

    public Requirements(int i) {
        this.a = (i & 2) != 0 ? i | 1 : i;
    }

    private int a(Context context) {
        if (!h()) {
            return 0;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) AbstractC20011rK.e(context.getSystemService("connectivity"));
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return (activeNetworkInfo != null && activeNetworkInfo.isConnected() && g(connectivityManager)) ? (k() && connectivityManager.isActiveNetworkMetered()) ? 2 : 0 : this.a & 3;
    }

    private boolean d(Context context) {
        Intent intentL0 = AbstractC9683aN7.L0(context, null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (intentL0 == null) {
            return false;
        }
        int intExtra = intentL0.getIntExtra("status", -1);
        return intExtra == 2 || intExtra == 5;
    }

    private boolean e(Context context) {
        PowerManager powerManager = (PowerManager) AbstractC20011rK.e(context.getSystemService("power"));
        int i = AbstractC9683aN7.a;
        return i >= 23 ? powerManager.isDeviceIdleMode() : i < 20 ? !powerManager.isScreenOn() : !powerManager.isInteractive();
    }

    private static boolean g(ConnectivityManager connectivityManager) {
        if (AbstractC9683aN7.a < 24) {
            return true;
        }
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null) {
            return false;
        }
        try {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
            if (networkCapabilities != null) {
                if (networkCapabilities.hasCapability(16)) {
                    return true;
                }
            }
            return false;
        } catch (SecurityException unused) {
            return true;
        }
    }

    private boolean i(Context context) {
        return AbstractC9683aN7.L0(context, null, new IntentFilter("android.intent.action.DEVICE_STORAGE_LOW")) == null;
    }

    public int b(Context context) {
        int iA = a(context);
        if (c() && !d(context)) {
            iA |= 8;
        }
        if (f() && !e(context)) {
            iA |= 4;
        }
        return (!j() || i(context)) ? iA : iA | 16;
    }

    public boolean c() {
        return (this.a & 8) != 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && Requirements.class == obj.getClass() && this.a == ((Requirements) obj).a;
    }

    public boolean f() {
        return (this.a & 4) != 0;
    }

    public boolean h() {
        return (this.a & 1) != 0;
    }

    public int hashCode() {
        return this.a;
    }

    public boolean j() {
        return (this.a & 16) != 0;
    }

    public boolean k() {
        return (this.a & 2) != 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
    }
}
