package com.google.android.gms.maps.model;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import ir.nasim.AbstractC21804u96;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.Lo8;
import ir.nasim.WZ2;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class MapStyleOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<MapStyleOptions> CREATOR = new Lo8();
    private String a;

    public MapStyleOptions(String str) {
        AbstractC3795Cj5.k(str, "json must not be null");
        this.a = str;
    }

    public static MapStyleOptions P(Context context, int i) {
        try {
            return new MapStyleOptions(new String(WZ2.c(context.getResources().openRawResource(i)), "UTF-8"));
        } catch (IOException e) {
            throw new Resources.NotFoundException("Failed to read resource " + i + ": " + e.toString());
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.t(parcel, 2, this.a, false);
        AbstractC21804u96.b(parcel, iA);
    }
}
