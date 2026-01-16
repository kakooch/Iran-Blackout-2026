package com.google.crypto.tink.shaded.protobuf;

import ir.nasim.EnumC25235zx5;

/* loaded from: classes3.dex */
final class T implements G {
    private final I a;
    private final String b;
    private final Object[] c;
    private final int d;

    T(I i, String str, Object[] objArr) {
        this.a = i;
        this.b = str;
        this.c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.d = cCharAt;
            return;
        }
        int i2 = cCharAt & 8191;
        int i3 = 13;
        int i4 = 1;
        while (true) {
            int i5 = i4 + 1;
            char cCharAt2 = str.charAt(i4);
            if (cCharAt2 < 55296) {
                this.d = i2 | (cCharAt2 << i3);
                return;
            } else {
                i2 |= (cCharAt2 & 8191) << i3;
                i3 += 13;
                i4 = i5;
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.G
    public boolean a() {
        return (this.d & 2) == 2;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.G
    public I b() {
        return this.a;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.G
    public EnumC25235zx5 c() {
        return (this.d & 1) == 1 ? EnumC25235zx5.PROTO2 : EnumC25235zx5.PROTO3;
    }

    Object[] d() {
        return this.c;
    }

    String e() {
        return this.b;
    }
}
