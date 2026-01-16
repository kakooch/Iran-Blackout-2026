package com.bumptech.glide.load.engine;

import ir.nasim.InterfaceC14373ho3;
import java.security.MessageDigest;

/* loaded from: classes2.dex */
final class d implements InterfaceC14373ho3 {
    private final InterfaceC14373ho3 b;
    private final InterfaceC14373ho3 c;

    d(InterfaceC14373ho3 interfaceC14373ho3, InterfaceC14373ho3 interfaceC14373ho32) {
        this.b = interfaceC14373ho3;
        this.c = interfaceC14373ho32;
    }

    @Override // ir.nasim.InterfaceC14373ho3
    public void b(MessageDigest messageDigest) {
        this.b.b(messageDigest);
        this.c.b(messageDigest);
    }

    @Override // ir.nasim.InterfaceC14373ho3
    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.b.equals(dVar.b) && this.c.equals(dVar.c);
    }

    @Override // ir.nasim.InterfaceC14373ho3
    public int hashCode() {
        return (this.b.hashCode() * 31) + this.c.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.b + ", signature=" + this.c + '}';
    }
}
