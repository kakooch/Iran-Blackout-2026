package com.google.android.gms.clearcut;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.clearcut.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.clearcut.zzr;
import com.google.android.gms.phenotype.ExperimentTokens;
import ir.nasim.AbstractC21804u96;
import ir.nasim.C12568ep8;
import ir.nasim.DG4;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class zze extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zze> CREATOR = new c();
    public zzr a;
    public byte[] b;
    private int[] c;
    private String[] d;
    private int[] e;
    private byte[][] f;
    private ExperimentTokens[] g;
    private boolean h;
    public final C12568ep8 i;

    public zze(zzr zzrVar, C12568ep8 c12568ep8, a.c cVar, a.c cVar2, int[] iArr, String[] strArr, int[] iArr2, byte[][] bArr, ExperimentTokens[] experimentTokensArr, boolean z) {
        this.a = zzrVar;
        this.i = c12568ep8;
        this.c = iArr;
        this.d = null;
        this.e = iArr2;
        this.f = null;
        this.g = null;
        this.h = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zze) {
            zze zzeVar = (zze) obj;
            if (DG4.a(this.a, zzeVar.a) && Arrays.equals(this.b, zzeVar.b) && Arrays.equals(this.c, zzeVar.c) && Arrays.equals(this.d, zzeVar.d) && DG4.a(this.i, zzeVar.i) && DG4.a(null, null) && DG4.a(null, null) && Arrays.equals(this.e, zzeVar.e) && Arrays.deepEquals(this.f, zzeVar.f) && Arrays.equals(this.g, zzeVar.g) && this.h == zzeVar.h) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return DG4.b(this.a, this.b, this.c, this.d, this.i, null, null, this.e, this.f, this.g, Boolean.valueOf(this.h));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("LogEventParcelable[");
        sb.append(this.a);
        sb.append(", LogEventBytes: ");
        byte[] bArr = this.b;
        sb.append(bArr == null ? null : new String(bArr));
        sb.append(", TestCodes: ");
        sb.append(Arrays.toString(this.c));
        sb.append(", MendelPackages: ");
        sb.append(Arrays.toString(this.d));
        sb.append(", LogEvent: ");
        sb.append(this.i);
        sb.append(", ExtensionProducer: ");
        sb.append((Object) null);
        sb.append(", VeProducer: ");
        sb.append((Object) null);
        sb.append(", ExperimentIDs: ");
        sb.append(Arrays.toString(this.e));
        sb.append(", ExperimentTokens: ");
        sb.append(Arrays.toString(this.f));
        sb.append(", ExperimentTokensParcelables: ");
        sb.append(Arrays.toString(this.g));
        sb.append(", AddPhenotypeExperimentTokens: ");
        sb.append(this.h);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.s(parcel, 2, this.a, i, false);
        AbstractC21804u96.g(parcel, 3, this.b, false);
        AbstractC21804u96.o(parcel, 4, this.c, false);
        AbstractC21804u96.u(parcel, 5, this.d, false);
        AbstractC21804u96.o(parcel, 6, this.e, false);
        AbstractC21804u96.h(parcel, 7, this.f, false);
        AbstractC21804u96.c(parcel, 8, this.h);
        AbstractC21804u96.w(parcel, 9, this.g, i, false);
        AbstractC21804u96.b(parcel, iA);
    }

    zze(zzr zzrVar, byte[] bArr, int[] iArr, String[] strArr, int[] iArr2, byte[][] bArr2, boolean z, ExperimentTokens[] experimentTokensArr) {
        this.a = zzrVar;
        this.b = bArr;
        this.c = iArr;
        this.d = strArr;
        this.i = null;
        this.e = iArr2;
        this.f = bArr2;
        this.g = experimentTokensArr;
        this.h = z;
    }
}
