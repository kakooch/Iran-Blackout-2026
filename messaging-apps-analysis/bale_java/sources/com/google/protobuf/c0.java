package com.google.protobuf;

import ir.nasim.EnumC3448Ax5;

/* loaded from: classes3.dex */
final class c0 implements N {
    private final P a;
    private final String b;
    private final Object[] c;
    private final int d;

    c0(P p, String str, Object[] objArr) {
        this.a = p;
        this.b = str;
        this.c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.d = cCharAt;
            return;
        }
        int i = cCharAt & 8191;
        int i2 = 13;
        int i3 = 1;
        while (true) {
            int i4 = i3 + 1;
            char cCharAt2 = str.charAt(i3);
            if (cCharAt2 < 55296) {
                this.d = i | (cCharAt2 << i2);
                return;
            } else {
                i |= (cCharAt2 & 8191) << i2;
                i2 += 13;
                i3 = i4;
            }
        }
    }

    @Override // com.google.protobuf.N
    public boolean a() {
        return (this.d & 2) == 2;
    }

    @Override // com.google.protobuf.N
    public P b() {
        return this.a;
    }

    @Override // com.google.protobuf.N
    public EnumC3448Ax5 c() {
        return (this.d & 1) == 1 ? EnumC3448Ax5.PROTO2 : EnumC3448Ax5.PROTO3;
    }

    Object[] d() {
        return this.c;
    }

    String e() {
        return this.b;
    }
}
