package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class cy implements Parcelable {
    public static final Parcelable.Creator<cy> CREATOR = new cw();
    public final int A;
    public final int B;
    public final int C;
    public final int D;
    public final Class E;
    private int F;
    public final String a;
    public final String b;
    public final String c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final String i;
    public final qz j;
    public final String k;
    public final String l;
    public final int m;
    public final List<byte[]> n;
    public final jc o;
    public final long p;
    public final int q;
    public final int r;
    public final float s;
    public final int t;
    public final float u;
    public final byte[] v;
    public final int w;
    public final aex x;
    public final int y;
    public final int z;

    cy(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readInt();
        this.e = parcel.readInt();
        int i = parcel.readInt();
        this.f = i;
        int i2 = parcel.readInt();
        this.g = i2;
        this.h = i2 != -1 ? i2 : i;
        this.i = parcel.readString();
        this.j = (qz) parcel.readParcelable(qz.class.getClassLoader());
        this.k = parcel.readString();
        this.l = parcel.readString();
        this.m = parcel.readInt();
        int i3 = parcel.readInt();
        this.n = new ArrayList(i3);
        for (int i4 = 0; i4 < i3; i4++) {
            this.n.add((byte[]) ary.t(parcel.createByteArray()));
        }
        jc jcVar = (jc) parcel.readParcelable(jc.class.getClassLoader());
        this.o = jcVar;
        this.p = parcel.readLong();
        this.q = parcel.readInt();
        this.r = parcel.readInt();
        this.s = parcel.readFloat();
        this.t = parcel.readInt();
        this.u = parcel.readFloat();
        this.v = aeu.s(parcel) ? parcel.createByteArray() : null;
        this.w = parcel.readInt();
        this.x = (aex) parcel.readParcelable(aex.class.getClassLoader());
        this.y = parcel.readInt();
        this.z = parcel.readInt();
        this.A = parcel.readInt();
        this.B = parcel.readInt();
        this.C = parcel.readInt();
        this.D = parcel.readInt();
        this.E = jcVar != null ? jl.class : null;
    }

    /* synthetic */ cy(cx cxVar) {
        this.a = cxVar.a;
        this.b = cxVar.b;
        this.c = aeu.v(cxVar.c);
        this.d = cxVar.d;
        this.e = cxVar.e;
        int i = cxVar.f;
        this.f = i;
        int i2 = cxVar.g;
        this.g = i2;
        this.h = i2 != -1 ? i2 : i;
        this.i = cxVar.h;
        this.j = cxVar.i;
        this.k = cxVar.j;
        this.l = cxVar.k;
        this.m = cxVar.l;
        this.n = cxVar.m == null ? Collections.emptyList() : cxVar.m;
        jc jcVar = cxVar.n;
        this.o = jcVar;
        this.p = cxVar.o;
        this.q = cxVar.p;
        this.r = cxVar.q;
        this.s = cxVar.r;
        this.t = cxVar.s == -1 ? 0 : cxVar.s;
        this.u = cxVar.t == -1.0f ? 1.0f : cxVar.t;
        this.v = cxVar.u;
        this.w = cxVar.v;
        this.x = cxVar.w;
        this.y = cxVar.x;
        this.z = cxVar.y;
        this.A = cxVar.z;
        this.B = cxVar.A == -1 ? 0 : cxVar.A;
        this.C = cxVar.B != -1 ? cxVar.B : 0;
        this.D = cxVar.C;
        this.E = (cxVar.D != null || jcVar == null) ? cxVar.D : jl.class;
    }

    public final cx a() {
        return new cx(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.ads.interactivemedia.v3.internal.cy b(com.google.ads.interactivemedia.v3.internal.cy r14) {
        /*
            r13 = this;
            if (r13 != r14) goto L3
            return r13
        L3:
            java.lang.String r0 = r13.l
            int r0 = com.google.ads.interactivemedia.v3.internal.adz.j(r0)
            java.lang.String r1 = r14.a
            java.lang.String r2 = r14.b
            if (r2 != 0) goto L11
            java.lang.String r2 = r13.b
        L11:
            java.lang.String r3 = r13.c
            r4 = 3
            r5 = 1
            if (r0 == r4) goto L1a
            if (r0 != r5) goto L1f
            r0 = 1
        L1a:
            java.lang.String r4 = r14.c
            if (r4 == 0) goto L1f
            r3 = r4
        L1f:
            int r4 = r13.f
            r6 = -1
            if (r4 != r6) goto L26
            int r4 = r14.f
        L26:
            int r7 = r13.g
            if (r7 != r6) goto L2c
            int r7 = r14.g
        L2c:
            java.lang.String r6 = r13.i
            if (r6 != 0) goto L3e
            java.lang.String r8 = r14.i
            java.lang.String r8 = com.google.ads.interactivemedia.v3.internal.aeu.T(r8, r0)
            java.lang.String[] r9 = com.google.ads.interactivemedia.v3.internal.aeu.U(r8)
            int r9 = r9.length
            if (r9 != r5) goto L3e
            r6 = r8
        L3e:
            com.google.ads.interactivemedia.v3.internal.qz r5 = r13.j
            if (r5 != 0) goto L45
            com.google.ads.interactivemedia.v3.internal.qz r5 = r14.j
            goto L4b
        L45:
            com.google.ads.interactivemedia.v3.internal.qz r8 = r14.j
            com.google.ads.interactivemedia.v3.internal.qz r5 = r5.c(r8)
        L4b:
            float r8 = r13.s
            r9 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r9 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
            if (r9 != 0) goto L58
            r9 = 2
            if (r0 != r9) goto L58
            float r8 = r14.s
        L58:
            int r0 = r13.d
            int r9 = r14.d
            int r10 = r13.e
            int r11 = r14.e
            com.google.ads.interactivemedia.v3.internal.jc r14 = r14.o
            com.google.ads.interactivemedia.v3.internal.jc r12 = r13.o
            com.google.ads.interactivemedia.v3.internal.jc r14 = com.google.ads.interactivemedia.v3.internal.jc.a(r14, r12)
            com.google.ads.interactivemedia.v3.internal.cx r12 = r13.a()
            r12.S(r1)
            r12.U(r2)
            r12.V(r3)
            r0 = r0 | r9
            r12.ag(r0)
            r0 = r10 | r11
            r12.ac(r0)
            r12.G(r4)
            r12.Z(r7)
            r12.I(r6)
            r12.X(r5)
            r12.L(r14)
            r12.P(r8)
            com.google.ads.interactivemedia.v3.internal.cy r14 = r12.a()
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.cy.b(com.google.ads.interactivemedia.v3.internal.cy):com.google.ads.interactivemedia.v3.internal.cy");
    }

    public final cy c(Class cls) {
        cx cxVarA = a();
        cxVarA.O(cls);
        return cxVarA.a();
    }

    public final int d() {
        int i;
        int i2 = this.q;
        if (i2 == -1 || (i = this.r) == -1) {
            return -1;
        }
        return i2 * i;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean e(cy cyVar) {
        if (this.n.size() != cyVar.n.size()) {
            return false;
        }
        for (int i = 0; i < this.n.size(); i++) {
            if (!Arrays.equals(this.n.get(i), cyVar.n.get(i))) {
                return false;
            }
        }
        return true;
    }

    public final boolean equals(Object obj) {
        int i;
        if (this == obj) {
            return true;
        }
        if (obj != null && cy.class == obj.getClass()) {
            cy cyVar = (cy) obj;
            int i2 = this.F;
            if ((i2 == 0 || (i = cyVar.F) == 0 || i2 == i) && this.d == cyVar.d && this.e == cyVar.e && this.f == cyVar.f && this.g == cyVar.g && this.m == cyVar.m && this.p == cyVar.p && this.q == cyVar.q && this.r == cyVar.r && this.t == cyVar.t && this.w == cyVar.w && this.y == cyVar.y && this.z == cyVar.z && this.A == cyVar.A && this.B == cyVar.B && this.C == cyVar.C && this.D == cyVar.D && Float.compare(this.s, cyVar.s) == 0 && Float.compare(this.u, cyVar.u) == 0 && aeu.c(this.E, cyVar.E) && aeu.c(this.a, cyVar.a) && aeu.c(this.b, cyVar.b) && aeu.c(this.i, cyVar.i) && aeu.c(this.k, cyVar.k) && aeu.c(this.l, cyVar.l) && aeu.c(this.c, cyVar.c) && Arrays.equals(this.v, cyVar.v) && aeu.c(this.j, cyVar.j) && aeu.c(this.x, cyVar.x) && aeu.c(this.o, cyVar.o) && e(cyVar)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.F;
        if (i != 0) {
            return i;
        }
        String str = this.a;
        int iHashCode = ((str == null ? 0 : str.hashCode()) + 527) * 31;
        String str2 = this.b;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.c;
        int iHashCode3 = (((((((((iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31) + this.g) * 31;
        String str4 = this.i;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        qz qzVar = this.j;
        int iHashCode5 = (iHashCode4 + (qzVar == null ? 0 : qzVar.hashCode())) * 31;
        String str5 = this.k;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.l;
        int iHashCode7 = (((((((((((((((((((((((((((((iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31) + this.m) * 31) + ((int) this.p)) * 31) + this.q) * 31) + this.r) * 31) + Float.floatToIntBits(this.s)) * 31) + this.t) * 31) + Float.floatToIntBits(this.u)) * 31) + this.w) * 31) + this.y) * 31) + this.z) * 31) + this.A) * 31) + this.B) * 31) + this.C) * 31) + this.D) * 31;
        Class cls = this.E;
        int iHashCode8 = iHashCode7 + (cls != null ? cls.hashCode() : 0);
        this.F = iHashCode8;
        return iHashCode8;
    }

    public final String toString() {
        String str = this.a;
        String str2 = this.b;
        String str3 = this.k;
        String str4 = this.l;
        String str5 = this.i;
        int i = this.h;
        String str6 = this.c;
        int i2 = this.q;
        int i3 = this.r;
        float f = this.s;
        int i4 = this.y;
        int i5 = this.z;
        int length = String.valueOf(str).length();
        int length2 = String.valueOf(str2).length();
        int length3 = String.valueOf(str3).length();
        int length4 = String.valueOf(str4).length();
        StringBuilder sb = new StringBuilder(length + 104 + length2 + length3 + length4 + String.valueOf(str5).length() + String.valueOf(str6).length());
        sb.append("Format(");
        sb.append(str);
        sb.append(", ");
        sb.append(str2);
        sb.append(", ");
        sb.append(str3);
        sb.append(", ");
        sb.append(str4);
        sb.append(", ");
        sb.append(str5);
        sb.append(", ");
        sb.append(i);
        sb.append(", ");
        sb.append(str6);
        sb.append(", [");
        sb.append(i2);
        sb.append(", ");
        sb.append(i3);
        sb.append(", ");
        sb.append(f);
        sb.append("], [");
        sb.append(i4);
        sb.append(", ");
        sb.append(i5);
        sb.append("])");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
        parcel.writeInt(this.g);
        parcel.writeString(this.i);
        parcel.writeParcelable(this.j, 0);
        parcel.writeString(this.k);
        parcel.writeString(this.l);
        parcel.writeInt(this.m);
        int size = this.n.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeByteArray(this.n.get(i2));
        }
        parcel.writeParcelable(this.o, 0);
        parcel.writeLong(this.p);
        parcel.writeInt(this.q);
        parcel.writeInt(this.r);
        parcel.writeFloat(this.s);
        parcel.writeInt(this.t);
        parcel.writeFloat(this.u);
        aeu.t(parcel, this.v != null);
        byte[] bArr = this.v;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
        parcel.writeInt(this.w);
        parcel.writeParcelable(this.x, i);
        parcel.writeInt(this.y);
        parcel.writeInt(this.z);
        parcel.writeInt(this.A);
        parcel.writeInt(this.B);
        parcel.writeInt(this.C);
        parcel.writeInt(this.D);
    }
}
