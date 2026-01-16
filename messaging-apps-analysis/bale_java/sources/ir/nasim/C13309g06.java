package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.g06, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C13309g06 extends AbstractC10365bX5 {
    private List b;
    private EnumC20411ry c;
    private int d;
    private Long e;
    private Integer f;
    private List g;

    public static C13309g06 s(byte[] bArr) {
        return (C13309g06) AbstractC16720ll0.b(new C13309g06(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(1); i++) {
            arrayList.add(new C21688ty());
        }
        this.b = c19084pl0.p(1, arrayList);
        int iH = c19084pl0.h(2, 0);
        if (iH != 0) {
            this.c = EnumC20411ry.p(iH);
        }
        this.d = c19084pl0.g(3);
        this.e = Long.valueOf(c19084pl0.y(4));
        this.f = Integer.valueOf(c19084pl0.x(5));
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < c19084pl0.m(6); i2++) {
            arrayList2.add(new C18766pD());
        }
        this.g = c19084pl0.p(6, arrayList2);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.m(1, this.b);
        EnumC20411ry enumC20411ry = this.c;
        if (enumC20411ry != null) {
            c19675ql0.f(2, enumC20411ry.j());
        }
        c19675ql0.f(3, this.d);
        Long l = this.e;
        if (l != null) {
            c19675ql0.g(4, l.longValue());
        }
        Integer num = this.f;
        if (num != null) {
            c19675ql0.f(5, num.intValue());
        }
        c19675ql0.m(6, this.g);
    }

    public String toString() {
        return "response OpenGiftPacket{}";
    }
}
