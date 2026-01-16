package com.google.android.exoplayer2.source.ads;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.exoplayer2.InterfaceC2029g;
import com.google.android.exoplayer2.source.ads.AdPlaybackState;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC9683aN7;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class AdPlaybackState implements InterfaceC2029g {
    public static final AdPlaybackState g = new AdPlaybackState(null, new AdGroup[0], 0, -9223372036854775807L, 0);
    private static final AdGroup h = new AdGroup(0).j(0);
    private static final String i = AbstractC9683aN7.r0(1);
    private static final String j = AbstractC9683aN7.r0(2);
    private static final String k = AbstractC9683aN7.r0(3);
    private static final String l = AbstractC9683aN7.r0(4);
    public static final InterfaceC2029g.a m = new InterfaceC2029g.a() { // from class: ir.nasim.q7
        @Override // com.google.android.exoplayer2.InterfaceC2029g.a
        public final InterfaceC2029g a(Bundle bundle) {
            return AdPlaybackState.c(bundle);
        }
    };
    public final Object a;
    public final int b;
    public final long c;
    public final long d;
    public final int e;
    private final AdGroup[] f;

    public static final class AdGroup implements InterfaceC2029g {
        private static final String i = AbstractC9683aN7.r0(0);
        private static final String j = AbstractC9683aN7.r0(1);
        private static final String k = AbstractC9683aN7.r0(2);
        private static final String l = AbstractC9683aN7.r0(3);
        private static final String m = AbstractC9683aN7.r0(4);
        private static final String n = AbstractC9683aN7.r0(5);
        private static final String o = AbstractC9683aN7.r0(6);
        private static final String p = AbstractC9683aN7.r0(7);
        public static final InterfaceC2029g.a q = new InterfaceC2029g.a() { // from class: ir.nasim.r7
            @Override // com.google.android.exoplayer2.InterfaceC2029g.a
            public final InterfaceC2029g a(Bundle bundle) {
                return AdPlaybackState.AdGroup.e(bundle);
            }
        };
        public final long a;
        public final int b;
        public final int c;
        public final Uri[] d;
        public final int[] e;
        public final long[] f;
        public final long g;
        public final boolean h;

        public AdGroup(long j2) {
            this(j2, -1, -1, new int[0], new Uri[0], new long[0], 0L, false);
        }

        private static long[] c(long[] jArr, int i2) {
            int length = jArr.length;
            int iMax = Math.max(i2, length);
            long[] jArrCopyOf = Arrays.copyOf(jArr, iMax);
            Arrays.fill(jArrCopyOf, length, iMax, -9223372036854775807L);
            return jArrCopyOf;
        }

        private static int[] d(int[] iArr, int i2) {
            int length = iArr.length;
            int iMax = Math.max(i2, length);
            int[] iArrCopyOf = Arrays.copyOf(iArr, iMax);
            Arrays.fill(iArrCopyOf, length, iMax, 0);
            return iArrCopyOf;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static AdGroup e(Bundle bundle) {
            long j2 = bundle.getLong(i);
            int i2 = bundle.getInt(j);
            int i3 = bundle.getInt(p);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(k);
            int[] intArray = bundle.getIntArray(l);
            long[] longArray = bundle.getLongArray(m);
            long j3 = bundle.getLong(n);
            boolean z = bundle.getBoolean(o);
            if (intArray == null) {
                intArray = new int[0];
            }
            return new AdGroup(j2, i2, i3, intArray, parcelableArrayList == null ? new Uri[0] : (Uri[]) parcelableArrayList.toArray(new Uri[0]), longArray == null ? new long[0] : longArray, j3, z);
        }

        @Override // com.google.android.exoplayer2.InterfaceC2029g
        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putLong(i, this.a);
            bundle.putInt(j, this.b);
            bundle.putInt(p, this.c);
            bundle.putParcelableArrayList(k, new ArrayList<>(Arrays.asList(this.d)));
            bundle.putIntArray(l, this.e);
            bundle.putLongArray(m, this.f);
            bundle.putLong(n, this.g);
            bundle.putBoolean(o, this.h);
            return bundle;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || AdGroup.class != obj.getClass()) {
                return false;
            }
            AdGroup adGroup = (AdGroup) obj;
            return this.a == adGroup.a && this.b == adGroup.b && this.c == adGroup.c && Arrays.equals(this.d, adGroup.d) && Arrays.equals(this.e, adGroup.e) && Arrays.equals(this.f, adGroup.f) && this.g == adGroup.g && this.h == adGroup.h;
        }

        public int f() {
            return g(-1);
        }

        public int g(int i2) {
            int i3;
            int i4 = i2 + 1;
            while (true) {
                int[] iArr = this.e;
                if (i4 >= iArr.length || this.h || (i3 = iArr[i4]) == 0 || i3 == 1) {
                    break;
                }
                i4++;
            }
            return i4;
        }

        public boolean h() {
            if (this.b == -1) {
                return true;
            }
            for (int i2 = 0; i2 < this.b; i2++) {
                int i3 = this.e[i2];
                if (i3 == 0 || i3 == 1) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            int i2 = ((this.b * 31) + this.c) * 31;
            long j2 = this.a;
            int iHashCode = (((((((i2 + ((int) (j2 ^ (j2 >>> 32)))) * 31) + Arrays.hashCode(this.d)) * 31) + Arrays.hashCode(this.e)) * 31) + Arrays.hashCode(this.f)) * 31;
            long j3 = this.g;
            return ((iHashCode + ((int) (j3 ^ (j3 >>> 32)))) * 31) + (this.h ? 1 : 0);
        }

        public boolean i() {
            return this.b == -1 || f() < this.b;
        }

        public AdGroup j(int i2) {
            int[] iArrD = d(this.e, i2);
            long[] jArrC = c(this.f, i2);
            return new AdGroup(this.a, i2, this.c, iArrD, (Uri[]) Arrays.copyOf(this.d, i2), jArrC, this.g, this.h);
        }

        public AdGroup k(long[] jArr) {
            int length = jArr.length;
            Uri[] uriArr = this.d;
            if (length < uriArr.length) {
                jArr = c(jArr, uriArr.length);
            } else if (this.b != -1 && jArr.length > uriArr.length) {
                jArr = Arrays.copyOf(jArr, uriArr.length);
            }
            return new AdGroup(this.a, this.b, this.c, this.e, this.d, jArr, this.g, this.h);
        }

        private AdGroup(long j2, int i2, int i3, int[] iArr, Uri[] uriArr, long[] jArr, long j3, boolean z) {
            AbstractC20011rK.a(iArr.length == uriArr.length);
            this.a = j2;
            this.b = i2;
            this.c = i3;
            this.e = iArr;
            this.d = uriArr;
            this.f = jArr;
            this.g = j3;
            this.h = z;
        }
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface AdState {
    }

    private AdPlaybackState(Object obj, AdGroup[] adGroupArr, long j2, long j3, int i2) {
        this.a = obj;
        this.c = j2;
        this.d = j3;
        this.b = adGroupArr.length + i2;
        this.f = adGroupArr;
        this.e = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AdPlaybackState c(Bundle bundle) {
        AdGroup[] adGroupArr;
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(i);
        if (parcelableArrayList == null) {
            adGroupArr = new AdGroup[0];
        } else {
            AdGroup[] adGroupArr2 = new AdGroup[parcelableArrayList.size()];
            for (int i2 = 0; i2 < parcelableArrayList.size(); i2++) {
                adGroupArr2[i2] = (AdGroup) AdGroup.q.a((Bundle) parcelableArrayList.get(i2));
            }
            adGroupArr = adGroupArr2;
        }
        String str = j;
        AdPlaybackState adPlaybackState = g;
        return new AdPlaybackState(null, adGroupArr, bundle.getLong(str, adPlaybackState.c), bundle.getLong(k, adPlaybackState.d), bundle.getInt(l, adPlaybackState.e));
    }

    private boolean g(long j2, long j3, int i2) {
        if (j2 == Long.MIN_VALUE) {
            return false;
        }
        long j4 = d(i2).a;
        return j4 == Long.MIN_VALUE ? j3 == -9223372036854775807L || j2 < j3 : j2 < j4;
    }

    @Override // com.google.android.exoplayer2.InterfaceC2029g
    public Bundle a() {
        Bundle bundle = new Bundle();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        for (AdGroup adGroup : this.f) {
            arrayList.add(adGroup.a());
        }
        if (!arrayList.isEmpty()) {
            bundle.putParcelableArrayList(i, arrayList);
        }
        long j2 = this.c;
        AdPlaybackState adPlaybackState = g;
        if (j2 != adPlaybackState.c) {
            bundle.putLong(j, j2);
        }
        long j3 = this.d;
        if (j3 != adPlaybackState.d) {
            bundle.putLong(k, j3);
        }
        int i2 = this.e;
        if (i2 != adPlaybackState.e) {
            bundle.putInt(l, i2);
        }
        return bundle;
    }

    public AdGroup d(int i2) {
        int i3 = this.e;
        return i2 < i3 ? h : this.f[i2 - i3];
    }

    public int e(long j2, long j3) {
        if (j2 == Long.MIN_VALUE) {
            return -1;
        }
        if (j3 != -9223372036854775807L && j2 >= j3) {
            return -1;
        }
        int i2 = this.e;
        while (i2 < this.b && ((d(i2).a != Long.MIN_VALUE && d(i2).a <= j2) || !d(i2).i())) {
            i2++;
        }
        if (i2 < this.b) {
            return i2;
        }
        return -1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AdPlaybackState.class != obj.getClass()) {
            return false;
        }
        AdPlaybackState adPlaybackState = (AdPlaybackState) obj;
        return AbstractC9683aN7.c(this.a, adPlaybackState.a) && this.b == adPlaybackState.b && this.c == adPlaybackState.c && this.d == adPlaybackState.d && this.e == adPlaybackState.e && Arrays.equals(this.f, adPlaybackState.f);
    }

    public int f(long j2, long j3) {
        int i2 = this.b - 1;
        while (i2 >= 0 && g(j2, j3, i2)) {
            i2--;
        }
        if (i2 < 0 || !d(i2).h()) {
            return -1;
        }
        return i2;
    }

    public AdPlaybackState h(long[][] jArr) {
        AbstractC20011rK.g(this.e == 0);
        AdGroup[] adGroupArr = this.f;
        AdGroup[] adGroupArr2 = (AdGroup[]) AbstractC9683aN7.G0(adGroupArr, adGroupArr.length);
        for (int i2 = 0; i2 < this.b; i2++) {
            adGroupArr2[i2] = adGroupArr2[i2].k(jArr[i2]);
        }
        return new AdPlaybackState(this.a, adGroupArr2, this.c, this.d, this.e);
    }

    public int hashCode() {
        int i2 = this.b * 31;
        Object obj = this.a;
        return ((((((((i2 + (obj == null ? 0 : obj.hashCode())) * 31) + ((int) this.c)) * 31) + ((int) this.d)) * 31) + this.e) * 31) + Arrays.hashCode(this.f);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AdPlaybackState(adsId=");
        sb.append(this.a);
        sb.append(", adResumePositionUs=");
        sb.append(this.c);
        sb.append(", adGroups=[");
        for (int i2 = 0; i2 < this.f.length; i2++) {
            sb.append("adGroup(timeUs=");
            sb.append(this.f[i2].a);
            sb.append(", ads=[");
            for (int i3 = 0; i3 < this.f[i2].e.length; i3++) {
                sb.append("ad(state=");
                int i4 = this.f[i2].e[i3];
                if (i4 == 0) {
                    sb.append('_');
                } else if (i4 == 1) {
                    sb.append('R');
                } else if (i4 == 2) {
                    sb.append('S');
                } else if (i4 == 3) {
                    sb.append('P');
                } else if (i4 != 4) {
                    sb.append('?');
                } else {
                    sb.append('!');
                }
                sb.append(", durationUs=");
                sb.append(this.f[i2].f[i3]);
                sb.append(')');
                if (i3 < this.f[i2].e.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("])");
            if (i2 < this.f.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("])");
        return sb.toString();
    }
}
