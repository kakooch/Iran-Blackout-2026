package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import ir.nasim.AbstractC21804u96;
import ir.nasim.AbstractC3795Cj5;

/* loaded from: classes3.dex */
public final class Scope extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new d();
    final int a;
    private final String b;

    Scope(int i, String str) {
        AbstractC3795Cj5.g(str, "scopeUri must not be null or empty");
        this.a = i;
        this.b = str;
    }

    public String P() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Scope) {
            return this.b.equals(((Scope) obj).b);
        }
        return false;
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int i2 = this.a;
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.n(parcel, 1, i2);
        AbstractC21804u96.t(parcel, 2, P(), false);
        AbstractC21804u96.b(parcel, iA);
    }

    public Scope(String str) {
        this(1, str);
    }
}
