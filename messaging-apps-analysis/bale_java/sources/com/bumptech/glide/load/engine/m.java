package com.bumptech.glide.load.engine;

import ir.nasim.AbstractC3322Aj5;
import ir.nasim.HL4;
import ir.nasim.InterfaceC14373ho3;
import java.security.MessageDigest;
import java.util.Map;

/* loaded from: classes2.dex */
class m implements InterfaceC14373ho3 {
    private final Object b;
    private final int c;
    private final int d;
    private final Class e;
    private final Class f;
    private final InterfaceC14373ho3 g;
    private final Map h;
    private final HL4 i;
    private int j;

    m(Object obj, InterfaceC14373ho3 interfaceC14373ho3, int i, int i2, Map map, Class cls, Class cls2, HL4 hl4) {
        this.b = AbstractC3322Aj5.d(obj);
        this.g = (InterfaceC14373ho3) AbstractC3322Aj5.e(interfaceC14373ho3, "Signature must not be null");
        this.c = i;
        this.d = i2;
        this.h = (Map) AbstractC3322Aj5.d(map);
        this.e = (Class) AbstractC3322Aj5.e(cls, "Resource class must not be null");
        this.f = (Class) AbstractC3322Aj5.e(cls2, "Transcode class must not be null");
        this.i = (HL4) AbstractC3322Aj5.d(hl4);
    }

    @Override // ir.nasim.InterfaceC14373ho3
    public void b(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    @Override // ir.nasim.InterfaceC14373ho3
    public boolean equals(Object obj) {
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.b.equals(mVar.b) && this.g.equals(mVar.g) && this.d == mVar.d && this.c == mVar.c && this.h.equals(mVar.h) && this.e.equals(mVar.e) && this.f.equals(mVar.f) && this.i.equals(mVar.i);
    }

    @Override // ir.nasim.InterfaceC14373ho3
    public int hashCode() {
        if (this.j == 0) {
            int iHashCode = this.b.hashCode();
            this.j = iHashCode;
            int iHashCode2 = (((((iHashCode * 31) + this.g.hashCode()) * 31) + this.c) * 31) + this.d;
            this.j = iHashCode2;
            int iHashCode3 = (iHashCode2 * 31) + this.h.hashCode();
            this.j = iHashCode3;
            int iHashCode4 = (iHashCode3 * 31) + this.e.hashCode();
            this.j = iHashCode4;
            int iHashCode5 = (iHashCode4 * 31) + this.f.hashCode();
            this.j = iHashCode5;
            this.j = (iHashCode5 * 31) + this.i.hashCode();
        }
        return this.j;
    }

    public String toString() {
        return "EngineKey{model=" + this.b + ", width=" + this.c + ", height=" + this.d + ", resourceClass=" + this.e + ", transcodeClass=" + this.f + ", signature=" + this.g + ", hashCode=" + this.j + ", transformations=" + this.h + ", options=" + this.i + '}';
    }
}
