package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class jc implements Comparator<jb>, Parcelable {
    public static final Parcelable.Creator<jc> CREATOR = new iz();
    public final String a;
    private final jb[] b;
    private int c;

    jc(Parcel parcel) {
        this.a = parcel.readString();
        jb[] jbVarArr = (jb[]) aeu.f((jb[]) parcel.createTypedArray(jb.CREATOR));
        this.b = jbVarArr;
        int length = jbVarArr.length;
    }

    public static jc a(jc jcVar, jc jcVar2) {
        String str;
        ArrayList arrayList = new ArrayList();
        if (jcVar != null) {
            str = jcVar.a;
            for (jb jbVar : jcVar.b) {
                if (jbVar.b()) {
                    arrayList.add(jbVar);
                }
            }
        } else {
            str = null;
        }
        if (jcVar2 != null) {
            if (str == null) {
                str = jcVar2.a;
            }
            int size = arrayList.size();
            for (jb jbVar2 : jcVar2.b) {
                if (jbVar2.b()) {
                    UUID uuid = jbVar2.a;
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            arrayList.add(jbVar2);
                            break;
                        }
                        if (((jb) arrayList.get(i)).a.equals(uuid)) {
                            break;
                        }
                        i++;
                    }
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new jc(str, arrayList);
    }

    public final jc b(String str) {
        return aeu.c(this.a, str) ? this : new jc(str, false, this.b);
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(jb jbVar, jb jbVar2) {
        jb jbVar3 = jbVar;
        jb jbVar4 = jbVar2;
        UUID uuid = bi.a;
        return uuid.equals(jbVar3.a) ? !uuid.equals(jbVar4.a) ? 1 : 0 : jbVar3.a.compareTo(jbVar4.a);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && jc.class == obj.getClass()) {
            jc jcVar = (jc) obj;
            if (aeu.c(this.a, jcVar.a) && Arrays.equals(this.b, jcVar.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.c;
        if (i != 0) {
            return i;
        }
        String str = this.a;
        int iHashCode = ((str == null ? 0 : str.hashCode()) * 31) + Arrays.hashCode(this.b);
        this.c = iHashCode;
        return iHashCode;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeTypedArray(this.b, 0);
    }

    public jc(String str, List<jb> list) {
        this(str, false, (jb[]) list.toArray(new jb[0]));
    }

    private jc(String str, boolean z, jb... jbVarArr) {
        this.a = str;
        jbVarArr = z ? (jb[]) jbVarArr.clone() : jbVarArr;
        this.b = jbVarArr;
        int length = jbVarArr.length;
        Arrays.sort(jbVarArr, this);
    }

    public jc(String str, jb... jbVarArr) {
        this(str, true, jbVarArr);
    }

    public jc(List<jb> list) {
        this(null, false, (jb[]) list.toArray(new jb[0]));
    }
}
