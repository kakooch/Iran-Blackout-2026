package com.google.android.gms.location;

import android.gov.nist.core.Separators;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.WorkSource;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.location.zzd;
import ir.nasim.AbstractC12608et8;
import ir.nasim.AbstractC16738lm8;
import ir.nasim.AbstractC17219mb8;
import ir.nasim.AbstractC21804u96;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.DG4;
import ir.nasim.Dh8;
import ir.nasim.Wh8;

/* loaded from: classes3.dex */
public final class LocationRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<LocationRequest> CREATOR = new d();
    private int a;
    private long b;
    private long c;
    private long d;
    private long e;
    private int f;
    private float g;
    private boolean h;
    private long i;
    private final int j;
    private final int k;
    private final String l;
    private final boolean m;
    private final WorkSource n;
    private final zzd o;

    public static final class a {
        private int a;
        private long b;
        private long c;
        private long d;
        private long e;
        private int f;
        private float g;
        private boolean h;
        private long i;
        private int j;
        private int k;
        private String l;
        private boolean m;
        private WorkSource n;
        private zzd o;

        public a(long j) {
            AbstractC3795Cj5.b(j >= 0, "intervalMillis must be greater than or equal to 0");
            this.b = j;
            this.a = 102;
            this.c = -1L;
            this.d = 0L;
            this.e = Long.MAX_VALUE;
            this.f = Integer.MAX_VALUE;
            this.g = 0.0f;
            this.h = true;
            this.i = -1L;
            this.j = 0;
            this.k = 0;
            this.l = null;
            this.m = false;
            this.n = null;
            this.o = null;
        }

        public LocationRequest a() {
            int i = this.a;
            long j = this.b;
            long jMin = this.c;
            if (jMin == -1) {
                jMin = j;
            } else if (i != 105) {
                jMin = Math.min(jMin, j);
            }
            long jMax = Math.max(this.d, this.b);
            long j2 = this.e;
            int i2 = this.f;
            float f = this.g;
            boolean z = this.h;
            long j3 = this.i;
            return new LocationRequest(i, j, jMin, jMax, Long.MAX_VALUE, j2, i2, f, z, j3 == -1 ? this.b : j3, this.j, this.k, this.l, this.m, new WorkSource(this.n), this.o);
        }

        public a b(int i) {
            AbstractC12608et8.a(i);
            this.j = i;
            return this;
        }

        public a c(long j) {
            AbstractC3795Cj5.b(j >= 0, "intervalMillis must be greater than or equal to 0");
            this.b = j;
            return this;
        }

        public a d(long j) {
            boolean z = true;
            if (j != -1 && j < 0) {
                z = false;
            }
            AbstractC3795Cj5.b(z, "maxUpdateAgeMillis must be greater than or equal to 0, or IMPLICIT_MAX_UPDATE_AGE");
            this.i = j;
            return this;
        }

        public a e(int i) {
            Dh8.a(i);
            this.a = i;
            return this;
        }

        public a f(boolean z) {
            this.h = z;
            return this;
        }

        public final a g(boolean z) {
            this.m = z;
            return this;
        }

        public final a h(String str) {
            if (Build.VERSION.SDK_INT < 30) {
                this.l = str;
            }
            return this;
        }

        public final a i(int i) {
            int i2;
            boolean z = true;
            if (i == 0 || i == 1) {
                i2 = i;
            } else {
                i2 = 2;
                if (i == 2) {
                    i = 2;
                } else {
                    z = false;
                    i2 = i;
                }
            }
            AbstractC3795Cj5.c(z, "throttle behavior %d must be a ThrottleBehavior.THROTTLE_* constant", Integer.valueOf(i));
            this.k = i2;
            return this;
        }

        public final a j(WorkSource workSource) {
            this.n = workSource;
            return this;
        }

        public a(LocationRequest locationRequest) {
            this.a = locationRequest.X0();
            this.b = locationRequest.s0();
            this.c = locationRequest.N0();
            this.d = locationRequest.A0();
            this.e = locationRequest.S();
            this.f = locationRequest.C0();
            this.g = locationRequest.J0();
            this.h = locationRequest.U1();
            this.i = locationRequest.x0();
            this.j = locationRequest.d0();
            this.k = locationRequest.X1();
            this.l = locationRequest.a2();
            this.m = locationRequest.b2();
            this.n = locationRequest.Y1();
            this.o = locationRequest.Z1();
        }
    }

    LocationRequest(int i, long j, long j2, long j3, long j4, long j5, int i2, float f, boolean z, long j6, int i3, int i4, String str, boolean z2, WorkSource workSource, zzd zzdVar) {
        this.a = i;
        long j7 = j;
        this.b = j7;
        this.c = j2;
        this.d = j3;
        this.e = j4 == Long.MAX_VALUE ? j5 : Math.min(Math.max(1L, j4 - SystemClock.elapsedRealtime()), j5);
        this.f = i2;
        this.g = f;
        this.h = z;
        this.i = j6 != -1 ? j6 : j7;
        this.j = i3;
        this.k = i4;
        this.l = str;
        this.m = z2;
        this.n = workSource;
        this.o = zzdVar;
    }

    public static LocationRequest P() {
        return new LocationRequest(102, 3600000L, 600000L, 0L, Long.MAX_VALUE, Long.MAX_VALUE, Integer.MAX_VALUE, 0.0f, true, 3600000L, 0, 0, null, false, new WorkSource(), null);
    }

    private static String c2(long j) {
        return j == Long.MAX_VALUE ? "∞" : AbstractC16738lm8.a(j);
    }

    public long A0() {
        return this.d;
    }

    public int C0() {
        return this.f;
    }

    public float J0() {
        return this.g;
    }

    public long N0() {
        return this.c;
    }

    public long S() {
        return this.e;
    }

    public boolean S1() {
        long j = this.d;
        return j > 0 && (j >> 1) >= this.b;
    }

    public boolean T1() {
        return this.a == 105;
    }

    public boolean U1() {
        return this.h;
    }

    public LocationRequest V1(long j) {
        AbstractC3795Cj5.b(j >= 0, "intervalMillis must be greater than or equal to 0");
        long j2 = this.c;
        long j3 = this.b;
        if (j2 == j3 / 6) {
            this.c = j / 6;
        }
        if (this.i == j3) {
            this.i = j;
        }
        this.b = j;
        return this;
    }

    public LocationRequest W1(int i) {
        Dh8.a(i);
        this.a = i;
        return this;
    }

    public int X0() {
        return this.a;
    }

    public final int X1() {
        return this.k;
    }

    public final WorkSource Y1() {
        return this.n;
    }

    public final zzd Z1() {
        return this.o;
    }

    public final String a2() {
        return this.l;
    }

    public final boolean b2() {
        return this.m;
    }

    public int d0() {
        return this.j;
    }

    public boolean equals(Object obj) {
        if (obj instanceof LocationRequest) {
            LocationRequest locationRequest = (LocationRequest) obj;
            if (this.a == locationRequest.a && ((T1() || this.b == locationRequest.b) && this.c == locationRequest.c && S1() == locationRequest.S1() && ((!S1() || this.d == locationRequest.d) && this.e == locationRequest.e && this.f == locationRequest.f && this.g == locationRequest.g && this.h == locationRequest.h && this.j == locationRequest.j && this.k == locationRequest.k && this.m == locationRequest.m && this.n.equals(locationRequest.n) && DG4.a(this.l, locationRequest.l) && DG4.a(this.o, locationRequest.o)))) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return DG4.b(Integer.valueOf(this.a), Long.valueOf(this.b), Long.valueOf(this.c), this.n);
    }

    public long s0() {
        return this.b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request[");
        if (T1()) {
            sb.append(Dh8.b(this.a));
        } else {
            sb.append(Separators.AT);
            if (S1()) {
                AbstractC16738lm8.b(this.b, sb);
                sb.append(Separators.SLASH);
                AbstractC16738lm8.b(this.d, sb);
            } else {
                AbstractC16738lm8.b(this.b, sb);
            }
            sb.append(Separators.SP);
            sb.append(Dh8.b(this.a));
        }
        if (T1() || this.c != this.b) {
            sb.append(", minUpdateInterval=");
            sb.append(c2(this.c));
        }
        if (this.g > 0.0d) {
            sb.append(", minUpdateDistance=");
            sb.append(this.g);
        }
        if (!T1() ? this.i != this.b : this.i != Long.MAX_VALUE) {
            sb.append(", maxUpdateAge=");
            sb.append(c2(this.i));
        }
        if (this.e != Long.MAX_VALUE) {
            sb.append(", duration=");
            AbstractC16738lm8.b(this.e, sb);
        }
        if (this.f != Integer.MAX_VALUE) {
            sb.append(", maxUpdates=");
            sb.append(this.f);
        }
        if (this.k != 0) {
            sb.append(", ");
            sb.append(Wh8.a(this.k));
        }
        if (this.j != 0) {
            sb.append(", ");
            sb.append(AbstractC12608et8.b(this.j));
        }
        if (this.h) {
            sb.append(", waitForAccurateLocation");
        }
        if (this.m) {
            sb.append(", bypass");
        }
        if (this.l != null) {
            sb.append(", moduleId=");
            sb.append(this.l);
        }
        if (!AbstractC17219mb8.d(this.n)) {
            sb.append(", ");
            sb.append(this.n);
        }
        if (this.o != null) {
            sb.append(", impersonation=");
            sb.append(this.o);
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.n(parcel, 1, X0());
        AbstractC21804u96.q(parcel, 2, s0());
        AbstractC21804u96.q(parcel, 3, N0());
        AbstractC21804u96.n(parcel, 6, C0());
        AbstractC21804u96.k(parcel, 7, J0());
        AbstractC21804u96.q(parcel, 8, A0());
        AbstractC21804u96.c(parcel, 9, U1());
        AbstractC21804u96.q(parcel, 10, S());
        AbstractC21804u96.q(parcel, 11, x0());
        AbstractC21804u96.n(parcel, 12, d0());
        AbstractC21804u96.n(parcel, 13, this.k);
        AbstractC21804u96.t(parcel, 14, this.l, false);
        AbstractC21804u96.c(parcel, 15, this.m);
        AbstractC21804u96.s(parcel, 16, this.n, i, false);
        AbstractC21804u96.s(parcel, 17, this.o, i, false);
        AbstractC21804u96.b(parcel, iA);
    }

    public long x0() {
        return this.i;
    }
}
