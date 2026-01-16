package ir.nasim;

/* renamed from: ir.nasim.Iv, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C5316Iv extends AbstractC24063xz {
    private Integer a;
    private byte[] b;
    private C4626Fy c;
    private Integer d;
    private Long e;

    public C5316Iv(Integer num, byte[] bArr, C4626Fy c4626Fy, Integer num2, Long l) {
        this.a = num;
        this.b = bArr;
        this.c = c4626Fy;
        this.d = num2;
        this.e = l;
    }

    public Integer C() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = Integer.valueOf(c19084pl0.x(1));
        this.b = c19084pl0.v(2);
        this.c = (C4626Fy) c19084pl0.z(3, new C4626Fy());
        this.d = Integer.valueOf(c19084pl0.x(5));
        this.e = Long.valueOf(c19084pl0.y(6));
    }

    @Override // ir.nasim.AbstractC24063xz
    public int s() {
        return 24;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
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
        Integer num2 = this.d;
        if (num2 != null) {
            c19675ql0.f(5, num2.intValue());
        }
        Long l = this.e;
        if (l != null) {
            c19675ql0.g(6, l.longValue());
        }
    }

    public String toString() {
        return "struct AnimatedStickerMessage{}";
    }

    public byte[] u() {
        return this.b;
    }

    public C4626Fy w() {
        return this.c;
    }

    public Long y() {
        return this.e;
    }

    public Integer z() {
        return this.d;
    }

    public C5316Iv() {
    }
}
