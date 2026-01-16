package ir.nasim;

import java.io.IOException;

/* loaded from: classes4.dex */
public class IC extends AbstractC24063xz {
    private Integer a;
    private byte[] b;
    private C4626Fy c;
    private C4626Fy d;
    private Integer e;
    private Long f;

    public IC(Integer num, byte[] bArr, C4626Fy c4626Fy, C4626Fy c4626Fy2, Integer num2, Long l) {
        this.a = num;
        this.b = bArr;
        this.c = c4626Fy;
        this.d = c4626Fy2;
        this.e = num2;
        this.f = l;
    }

    public Integer C() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = Integer.valueOf(c19084pl0.x(1));
        this.b = c19084pl0.v(2);
        this.c = (C4626Fy) c19084pl0.z(3, new C4626Fy());
        this.d = (C4626Fy) c19084pl0.z(4, new C4626Fy());
        this.e = Integer.valueOf(c19084pl0.x(5));
        this.f = Long.valueOf(c19084pl0.y(6));
        if (c19084pl0.t()) {
            setUnmappedObjects(c19084pl0.a());
        }
    }

    @Override // ir.nasim.AbstractC24063xz
    public int s() {
        return 6;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        Integer num = this.a;
        if (num != null) {
            c19675ql0.f(1, num.intValue());
        }
        byte[] bArr = this.b;
        if (bArr != null) {
            c19675ql0.b(2, bArr);
        }
        C4626Fy c4626Fy = this.c;
        if (c4626Fy != null) {
            c19675ql0.i(3, c4626Fy);
        }
        C4626Fy c4626Fy2 = this.d;
        if (c4626Fy2 != null) {
            c19675ql0.i(4, c4626Fy2);
        }
        Integer num2 = this.e;
        if (num2 != null) {
            c19675ql0.f(5, num2.intValue());
        }
        Long l = this.f;
        if (l != null) {
            c19675ql0.g(6, l.longValue());
        }
        if (getUnmappedObjects() != null) {
            C18818pI6 unmappedObjects = getUnmappedObjects();
            for (int i = 0; i < unmappedObjects.k(); i++) {
                int iH = unmappedObjects.h(i);
                c19675ql0.q(iH, unmappedObjects.d(iH));
            }
        }
    }

    public String toString() {
        return "struct StickerMessage{}";
    }

    public C4626Fy u() {
        return this.d;
    }

    public C4626Fy w() {
        return this.c;
    }

    public Long y() {
        return this.f;
    }

    public Integer z() {
        return this.e;
    }

    public IC() {
    }
}
