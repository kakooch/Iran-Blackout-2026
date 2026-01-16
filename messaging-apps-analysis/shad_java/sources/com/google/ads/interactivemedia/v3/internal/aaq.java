package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.HashMap;
import java.util.Map;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class aaq extends abe {
    private final SparseArray<Map<vj, aat>> F;
    private final SparseBooleanArray G;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public final int m;
    public final int n;
    public final boolean o;
    public final int p;
    public final int q;
    public final boolean r;
    public final boolean s;
    public final boolean t;
    public final boolean u;
    public final boolean v;
    public final boolean w;
    public final boolean x;
    public final int y;
    public static final aaq a = new aar().a();
    public static final Parcelable.Creator<aaq> CREATOR = new aap();

    aaq(int i, int i2, int i3, int i4, boolean z, boolean z2, int i5, int i6, boolean z3, arn<String> arnVar, int i7, int i8, boolean z4, arn<String> arnVar2, int i9, boolean z5, SparseArray<Map<vj, aat>> sparseArray, SparseBooleanArray sparseBooleanArray) {
        super(arnVar, arnVar2, i9);
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = z;
        this.k = false;
        this.l = z2;
        this.m = i5;
        this.n = i6;
        this.o = z3;
        this.p = i7;
        this.q = i8;
        this.r = z4;
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = false;
        this.x = z5;
        this.y = 0;
        this.F = sparseArray;
        this.G = sparseBooleanArray;
    }

    public static aaq a(Context context) {
        return new aar(context).a();
    }

    public final boolean b(int i) {
        return this.G.get(i);
    }

    public final boolean c(int i, vj vjVar) {
        Map<vj, aat> map = this.F.get(i);
        return map != null && map.containsKey(vjVar);
    }

    public final aat d(int i, vj vjVar) {
        Map<vj, aat> map = this.F.get(i);
        if (map != null) {
            return map.get(vjVar);
        }
        return null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abe, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abe
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && aaq.class == obj.getClass()) {
            aaq aaqVar = (aaq) obj;
            if (super.equals(obj) && this.b == aaqVar.b && this.c == aaqVar.c && this.d == aaqVar.d && this.e == aaqVar.e && this.f == aaqVar.f && this.g == aaqVar.g && this.h == aaqVar.h && this.i == aaqVar.i && this.j == aaqVar.j && this.k == aaqVar.k && this.l == aaqVar.l && this.o == aaqVar.o && this.m == aaqVar.m && this.n == aaqVar.n && this.p == aaqVar.p && this.q == aaqVar.q && this.r == aaqVar.r && this.s == aaqVar.s && this.t == aaqVar.t && this.u == aaqVar.u && this.v == aaqVar.v && this.w == aaqVar.w && this.x == aaqVar.x && this.y == aaqVar.y) {
                SparseBooleanArray sparseBooleanArray = this.G;
                SparseBooleanArray sparseBooleanArray2 = aaqVar.G;
                int size = sparseBooleanArray.size();
                if (sparseBooleanArray2.size() == size) {
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            SparseArray<Map<vj, aat>> sparseArray = this.F;
                            SparseArray<Map<vj, aat>> sparseArray2 = aaqVar.F;
                            int size2 = sparseArray.size();
                            if (sparseArray2.size() == size2) {
                                for (int i2 = 0; i2 < size2; i2++) {
                                    int iIndexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i2));
                                    if (iIndexOfKey >= 0) {
                                        Map<vj, aat> mapValueAt = sparseArray.valueAt(i2);
                                        Map<vj, aat> mapValueAt2 = sparseArray2.valueAt(iIndexOfKey);
                                        if (mapValueAt2.size() == mapValueAt.size()) {
                                            for (Map.Entry<vj, aat> entry : mapValueAt.entrySet()) {
                                                vj key = entry.getKey();
                                                if (!mapValueAt2.containsKey(key) || !aeu.c(entry.getValue(), mapValueAt2.get(key))) {
                                                }
                                            }
                                        }
                                    }
                                }
                                return true;
                            }
                        } else {
                            if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i)) < 0) {
                                break;
                            }
                            i++;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abe
    public final int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((super.hashCode() * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31) + this.g) * 31) + this.h) * 31) + this.i) * 31) + (this.j ? 1 : 0)) * 31) + (this.k ? 1 : 0)) * 31) + (this.l ? 1 : 0)) * 31) + (this.o ? 1 : 0)) * 31) + this.m) * 31) + this.n) * 31) + this.p) * 31) + this.q) * 31) + (this.r ? 1 : 0)) * 31) + (this.s ? 1 : 0)) * 31) + (this.t ? 1 : 0)) * 31) + (this.u ? 1 : 0)) * 31) + (this.v ? 1 : 0)) * 31) + (this.w ? 1 : 0)) * 31) + (this.x ? 1 : 0)) * 31) + this.y;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abe, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
        parcel.writeInt(this.g);
        parcel.writeInt(this.h);
        parcel.writeInt(this.i);
        aeu.t(parcel, this.j);
        aeu.t(parcel, this.k);
        aeu.t(parcel, this.l);
        parcel.writeInt(this.m);
        parcel.writeInt(this.n);
        aeu.t(parcel, this.o);
        parcel.writeInt(this.p);
        parcel.writeInt(this.q);
        aeu.t(parcel, this.r);
        aeu.t(parcel, this.s);
        aeu.t(parcel, this.t);
        aeu.t(parcel, this.u);
        aeu.t(parcel, this.v);
        aeu.t(parcel, this.w);
        aeu.t(parcel, this.x);
        parcel.writeInt(this.y);
        SparseArray<Map<vj, aat>> sparseArray = this.F;
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            int iKeyAt = sparseArray.keyAt(i2);
            Map<vj, aat> mapValueAt = sparseArray.valueAt(i2);
            int size2 = mapValueAt.size();
            parcel.writeInt(iKeyAt);
            parcel.writeInt(size2);
            for (Map.Entry<vj, aat> entry : mapValueAt.entrySet()) {
                parcel.writeParcelable(entry.getKey(), 0);
                parcel.writeParcelable(entry.getValue(), 0);
            }
        }
        parcel.writeSparseBooleanArray(this.G);
    }

    aaq(Parcel parcel) {
        super(parcel);
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readInt();
        this.e = parcel.readInt();
        this.f = parcel.readInt();
        this.g = parcel.readInt();
        this.h = parcel.readInt();
        this.i = parcel.readInt();
        this.j = aeu.s(parcel);
        this.k = aeu.s(parcel);
        this.l = aeu.s(parcel);
        this.m = parcel.readInt();
        this.n = parcel.readInt();
        this.o = aeu.s(parcel);
        this.p = parcel.readInt();
        this.q = parcel.readInt();
        this.r = aeu.s(parcel);
        this.s = aeu.s(parcel);
        this.t = aeu.s(parcel);
        this.u = aeu.s(parcel);
        this.v = aeu.s(parcel);
        this.w = aeu.s(parcel);
        this.x = aeu.s(parcel);
        this.y = parcel.readInt();
        int i = parcel.readInt();
        SparseArray<Map<vj, aat>> sparseArray = new SparseArray<>(i);
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = parcel.readInt();
            int i4 = parcel.readInt();
            HashMap map = new HashMap(i4);
            for (int i5 = 0; i5 < i4; i5++) {
                vj vjVar = (vj) parcel.readParcelable(vj.class.getClassLoader());
                ary.t(vjVar);
                map.put(vjVar, (aat) parcel.readParcelable(aat.class.getClassLoader()));
            }
            sparseArray.put(i3, map);
        }
        this.F = sparseArray;
        this.G = parcel.readSparseBooleanArray();
    }
}
