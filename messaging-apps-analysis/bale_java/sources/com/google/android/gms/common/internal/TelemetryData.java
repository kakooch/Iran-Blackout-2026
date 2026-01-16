package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import ir.nasim.AbstractC21804u96;
import ir.nasim.Oe8;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class TelemetryData extends AbstractSafeParcelable {
    public static final Parcelable.Creator<TelemetryData> CREATOR = new Oe8();
    private final int a;
    private List b;

    public TelemetryData(int i, List list) {
        this.a = i;
        this.b = list;
    }

    public final int P() {
        return this.a;
    }

    public final List S() {
        return this.b;
    }

    public final void d0(MethodInvocation methodInvocation) {
        if (this.b == null) {
            this.b = new ArrayList();
        }
        this.b.add(methodInvocation);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.n(parcel, 1, this.a);
        AbstractC21804u96.x(parcel, 2, this.b, false);
        AbstractC21804u96.b(parcel, iA);
    }
}
