package com.google.android.exoplayer2;

import android.os.Bundle;
import com.google.android.exoplayer2.InterfaceC2029g;
import com.google.android.exoplayer2.K0;
import com.google.android.exoplayer2.source.TrackGroup;
import ir.nasim.AbstractC12710f43;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC3344Am0;
import ir.nasim.AbstractC8300Vj4;
import ir.nasim.AbstractC8778Xh0;
import ir.nasim.AbstractC9683aN7;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public final class K0 implements InterfaceC2029g {
    public static final K0 b = new K0(AbstractC12710f43.V());
    private static final String c = AbstractC9683aN7.r0(0);
    public static final InterfaceC2029g.a d = new InterfaceC2029g.a() { // from class: ir.nasim.Tt7
        @Override // com.google.android.exoplayer2.InterfaceC2029g.a
        public final InterfaceC2029g a(Bundle bundle) {
            return com.google.android.exoplayer2.K0.f(bundle);
        }
    };
    private final AbstractC12710f43 a;

    public static final class a implements InterfaceC2029g {
        private static final String f = AbstractC9683aN7.r0(0);
        private static final String g = AbstractC9683aN7.r0(1);
        private static final String h = AbstractC9683aN7.r0(3);
        private static final String i = AbstractC9683aN7.r0(4);
        public static final InterfaceC2029g.a j = new InterfaceC2029g.a() { // from class: ir.nasim.Ut7
            @Override // com.google.android.exoplayer2.InterfaceC2029g.a
            public final InterfaceC2029g a(Bundle bundle) {
                return K0.a.k(bundle);
            }
        };
        public final int a;
        private final TrackGroup b;
        private final boolean c;
        private final int[] d;
        private final boolean[] e;

        public a(TrackGroup trackGroup, boolean z, int[] iArr, boolean[] zArr) {
            int i2 = trackGroup.a;
            this.a = i2;
            boolean z2 = false;
            AbstractC20011rK.a(i2 == iArr.length && i2 == zArr.length);
            this.b = trackGroup;
            if (z && i2 > 1) {
                z2 = true;
            }
            this.c = z2;
            this.d = (int[]) iArr.clone();
            this.e = (boolean[]) zArr.clone();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ a k(Bundle bundle) {
            TrackGroup trackGroup = (TrackGroup) TrackGroup.h.a((Bundle) AbstractC20011rK.e(bundle.getBundle(f)));
            return new a(trackGroup, bundle.getBoolean(i, false), (int[]) AbstractC8300Vj4.a(bundle.getIntArray(g), new int[trackGroup.a]), (boolean[]) AbstractC8300Vj4.a(bundle.getBooleanArray(h), new boolean[trackGroup.a]));
        }

        @Override // com.google.android.exoplayer2.InterfaceC2029g
        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putBundle(f, this.b.a());
            bundle.putIntArray(g, this.d);
            bundle.putBooleanArray(h, this.e);
            bundle.putBoolean(i, this.c);
            return bundle;
        }

        public TrackGroup c() {
            return this.b;
        }

        public X d(int i2) {
            return this.b.d(i2);
        }

        public int e() {
            return this.b.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.c == aVar.c && this.b.equals(aVar.b) && Arrays.equals(this.d, aVar.d) && Arrays.equals(this.e, aVar.e);
        }

        public boolean f() {
            return this.c;
        }

        public boolean g() {
            return AbstractC8778Xh0.b(this.e, true);
        }

        public boolean h(int i2) {
            return this.e[i2];
        }

        public int hashCode() {
            return (((((this.b.hashCode() * 31) + (this.c ? 1 : 0)) * 31) + Arrays.hashCode(this.d)) * 31) + Arrays.hashCode(this.e);
        }

        public boolean i(int i2) {
            return j(i2, false);
        }

        public boolean j(int i2, boolean z) {
            int i3 = this.d[i2];
            return i3 == 4 || (z && i3 == 3);
        }
    }

    public K0(List list) {
        this.a = AbstractC12710f43.O(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ K0 f(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(c);
        return new K0(parcelableArrayList == null ? AbstractC12710f43.V() : AbstractC3344Am0.b(a.j, parcelableArrayList));
    }

    @Override // com.google.android.exoplayer2.InterfaceC2029g
    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(c, AbstractC3344Am0.d(this.a));
        return bundle;
    }

    public AbstractC12710f43 c() {
        return this.a;
    }

    public boolean d() {
        return this.a.isEmpty();
    }

    public boolean e(int i) {
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            a aVar = (a) this.a.get(i2);
            if (aVar.g() && aVar.e() == i) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || K0.class != obj.getClass()) {
            return false;
        }
        return this.a.equals(((K0) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
