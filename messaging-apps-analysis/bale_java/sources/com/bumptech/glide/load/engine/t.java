package com.bumptech.glide.load.engine;

import ir.nasim.C15887kL3;
import ir.nasim.HL4;
import ir.nasim.InterfaceC14373ho3;
import ir.nasim.InterfaceC15645jv7;
import ir.nasim.LJ;
import ir.nasim.YM7;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: classes2.dex */
final class t implements InterfaceC14373ho3 {
    private static final C15887kL3 j = new C15887kL3(50);
    private final LJ b;
    private final InterfaceC14373ho3 c;
    private final InterfaceC14373ho3 d;
    private final int e;
    private final int f;
    private final Class g;
    private final HL4 h;
    private final InterfaceC15645jv7 i;

    t(LJ lj, InterfaceC14373ho3 interfaceC14373ho3, InterfaceC14373ho3 interfaceC14373ho32, int i, int i2, InterfaceC15645jv7 interfaceC15645jv7, Class cls, HL4 hl4) {
        this.b = lj;
        this.c = interfaceC14373ho3;
        this.d = interfaceC14373ho32;
        this.e = i;
        this.f = i2;
        this.i = interfaceC15645jv7;
        this.g = cls;
        this.h = hl4;
    }

    private byte[] c() {
        C15887kL3 c15887kL3 = j;
        byte[] bArr = (byte[]) c15887kL3.g(this.g);
        if (bArr != null) {
            return bArr;
        }
        byte[] bytes = this.g.getName().getBytes(InterfaceC14373ho3.a);
        c15887kL3.k(this.g, bytes);
        return bytes;
    }

    @Override // ir.nasim.InterfaceC14373ho3
    public void b(MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.b.d(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.e).putInt(this.f).array();
        this.d.b(messageDigest);
        this.c.b(messageDigest);
        messageDigest.update(bArr);
        InterfaceC15645jv7 interfaceC15645jv7 = this.i;
        if (interfaceC15645jv7 != null) {
            interfaceC15645jv7.b(messageDigest);
        }
        this.h.b(messageDigest);
        messageDigest.update(c());
        this.b.e(bArr);
    }

    @Override // ir.nasim.InterfaceC14373ho3
    public boolean equals(Object obj) {
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return this.f == tVar.f && this.e == tVar.e && YM7.e(this.i, tVar.i) && this.g.equals(tVar.g) && this.c.equals(tVar.c) && this.d.equals(tVar.d) && this.h.equals(tVar.h);
    }

    @Override // ir.nasim.InterfaceC14373ho3
    public int hashCode() {
        int iHashCode = (((((this.c.hashCode() * 31) + this.d.hashCode()) * 31) + this.e) * 31) + this.f;
        InterfaceC15645jv7 interfaceC15645jv7 = this.i;
        if (interfaceC15645jv7 != null) {
            iHashCode = (iHashCode * 31) + interfaceC15645jv7.hashCode();
        }
        return (((iHashCode * 31) + this.g.hashCode()) * 31) + this.h.hashCode();
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.c + ", signature=" + this.d + ", width=" + this.e + ", height=" + this.f + ", decodedResourceClass=" + this.g + ", transformation='" + this.i + "', options=" + this.h + '}';
    }
}
