package com.google.android.exoplayer2.source;

import android.os.Bundle;
import com.google.android.exoplayer2.InterfaceC2029g;
import com.google.android.exoplayer2.source.TrackGroupArray;
import ir.nasim.AbstractC12710f43;
import ir.nasim.AbstractC18815pI3;
import ir.nasim.AbstractC3344Am0;
import ir.nasim.AbstractC9683aN7;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class TrackGroupArray implements InterfaceC2029g {
    public static final TrackGroupArray d = new TrackGroupArray(new TrackGroup[0]);
    private static final String e = AbstractC9683aN7.r0(0);
    public static final InterfaceC2029g.a f = new InterfaceC2029g.a() { // from class: ir.nasim.Ct7
        @Override // com.google.android.exoplayer2.InterfaceC2029g.a
        public final InterfaceC2029g a(Bundle bundle) {
            return TrackGroupArray.e(bundle);
        }
    };
    public final int a;
    private final AbstractC12710f43 b;
    private int c;

    public TrackGroupArray(TrackGroup... trackGroupArr) {
        this.b = AbstractC12710f43.P(trackGroupArr);
        this.a = trackGroupArr.length;
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TrackGroupArray e(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(e);
        return parcelableArrayList == null ? new TrackGroupArray(new TrackGroup[0]) : new TrackGroupArray((TrackGroup[]) AbstractC3344Am0.b(TrackGroup.h, parcelableArrayList).toArray(new TrackGroup[0]));
    }

    private void f() {
        int i = 0;
        while (i < this.b.size()) {
            int i2 = i + 1;
            for (int i3 = i2; i3 < this.b.size(); i3++) {
                if (((TrackGroup) this.b.get(i)).equals(this.b.get(i3))) {
                    AbstractC18815pI3.d("TrackGroupArray", "", new IllegalArgumentException("Multiple identical TrackGroups added to one TrackGroupArray."));
                }
            }
            i = i2;
        }
    }

    @Override // com.google.android.exoplayer2.InterfaceC2029g
    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(e, AbstractC3344Am0.d(this.b));
        return bundle;
    }

    public TrackGroup c(int i) {
        return (TrackGroup) this.b.get(i);
    }

    public int d(TrackGroup trackGroup) {
        int iIndexOf = this.b.indexOf(trackGroup);
        if (iIndexOf >= 0) {
            return iIndexOf;
        }
        return -1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TrackGroupArray.class != obj.getClass()) {
            return false;
        }
        TrackGroupArray trackGroupArray = (TrackGroupArray) obj;
        return this.a == trackGroupArray.a && this.b.equals(trackGroupArray.b);
    }

    public int hashCode() {
        if (this.c == 0) {
            this.c = this.b.hashCode();
        }
        return this.c;
    }
}
