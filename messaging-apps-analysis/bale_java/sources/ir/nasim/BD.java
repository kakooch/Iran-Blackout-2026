package ir.nasim;

/* loaded from: classes4.dex */
public enum BD {
    EXTRACHANCE(1),
    COUPON(2),
    GIFTPACKET(3),
    POINT(4),
    CUSTOM(5),
    UNSUPPORTED_VALUE(-1);

    private int a;

    BD(int i) {
        this.a = i;
    }

    public static BD p(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? UNSUPPORTED_VALUE : CUSTOM : POINT : GIFTPACKET : COUPON : EXTRACHANCE;
    }

    public int j() {
        return this.a;
    }
}
