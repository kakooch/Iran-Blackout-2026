package com.google.android.exoplayer2.source;

import android.gov.nist.core.Separators;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.exoplayer2.InterfaceC2029g;
import com.google.android.exoplayer2.X;
import com.google.android.exoplayer2.source.TrackGroup;
import ir.nasim.AbstractC12710f43;
import ir.nasim.AbstractC18815pI3;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC24462yf4;
import ir.nasim.AbstractC3344Am0;
import ir.nasim.AbstractC9683aN7;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class TrackGroup implements InterfaceC2029g {
    private static final String f = AbstractC9683aN7.r0(0);
    private static final String g = AbstractC9683aN7.r0(1);
    public static final InterfaceC2029g.a h = new InterfaceC2029g.a() { // from class: ir.nasim.Bt7
        @Override // com.google.android.exoplayer2.InterfaceC2029g.a
        public final InterfaceC2029g a(Bundle bundle) {
            return TrackGroup.f(bundle);
        }
    };
    public final int a;
    public final String b;
    public final int c;
    private final X[] d;
    private int e;

    public TrackGroup(X... xArr) {
        this("", xArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TrackGroup f(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(f);
        return new TrackGroup(bundle.getString(g, ""), (X[]) (parcelableArrayList == null ? AbstractC12710f43.V() : AbstractC3344Am0.b(X.g1, parcelableArrayList)).toArray(new X[0]));
    }

    private static void g(String str, String str2, String str3, int i) {
        AbstractC18815pI3.d("TrackGroup", "", new IllegalStateException("Different " + str + " combined in one TrackGroup: '" + str2 + "' (track 0) and '" + str3 + "' (track " + i + Separators.RPAREN));
    }

    private static String h(String str) {
        return (str == null || str.equals("und")) ? "" : str;
    }

    private static int i(int i) {
        return i | 16384;
    }

    private void j() {
        String strH = h(this.d[0].c);
        int i = i(this.d[0].e);
        int i2 = 1;
        while (true) {
            X[] xArr = this.d;
            if (i2 >= xArr.length) {
                return;
            }
            if (!strH.equals(h(xArr[i2].c))) {
                X[] xArr2 = this.d;
                g("languages", xArr2[0].c, xArr2[i2].c, i2);
                return;
            } else {
                if (i != i(this.d[i2].e)) {
                    g("role flags", Integer.toBinaryString(this.d[0].e), Integer.toBinaryString(this.d[i2].e), i2);
                    return;
                }
                i2++;
            }
        }
    }

    @Override // com.google.android.exoplayer2.InterfaceC2029g
    public Bundle a() {
        Bundle bundle = new Bundle();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>(this.d.length);
        for (X x : this.d) {
            arrayList.add(x.j(true));
        }
        bundle.putParcelableArrayList(f, arrayList);
        bundle.putString(g, this.b);
        return bundle;
    }

    public TrackGroup c(String str) {
        return new TrackGroup(str, this.d);
    }

    public X d(int i) {
        return this.d[i];
    }

    public int e(X x) {
        int i = 0;
        while (true) {
            X[] xArr = this.d;
            if (i >= xArr.length) {
                return -1;
            }
            if (x == xArr[i]) {
                return i;
            }
            i++;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TrackGroup.class != obj.getClass()) {
            return false;
        }
        TrackGroup trackGroup = (TrackGroup) obj;
        return this.b.equals(trackGroup.b) && Arrays.equals(this.d, trackGroup.d);
    }

    public int hashCode() {
        if (this.e == 0) {
            this.e = ((527 + this.b.hashCode()) * 31) + Arrays.hashCode(this.d);
        }
        return this.e;
    }

    public TrackGroup(String str, X... xArr) {
        AbstractC20011rK.a(xArr.length > 0);
        this.b = str;
        this.d = xArr;
        this.a = xArr.length;
        int iK = AbstractC24462yf4.k(xArr[0].l);
        this.c = iK == -1 ? AbstractC24462yf4.k(xArr[0].k) : iK;
        j();
    }
}
