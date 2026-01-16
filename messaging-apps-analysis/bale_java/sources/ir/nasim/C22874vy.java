package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.vy, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C22874vy extends AbstractC24063xz {
    private long a;
    private long b;
    private long c;
    private String d;
    private EnumC19802qy e;

    public C22874vy(long j, long j2, long j3, String str, EnumC19802qy enumC19802qy) {
        this.a = j;
        this.b = j2;
        this.c = j3;
        this.d = str;
        this.e = enumC19802qy;
    }

    public long C() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.i(1);
        this.b = c19084pl0.i(2);
        this.c = c19084pl0.i(3);
        this.d = c19084pl0.r(4);
        int iH = c19084pl0.h(5, 0);
        if (iH != 0) {
            this.e = EnumC19802qy.p(iH);
        }
    }

    @Override // ir.nasim.AbstractC24063xz
    public int s() {
        return 62981;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.g(1, this.a);
        c19675ql0.g(2, this.b);
        c19675ql0.g(3, this.c);
        String str = this.d;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(4, str);
        EnumC19802qy enumC19802qy = this.e;
        if (enumC19802qy != null) {
            c19675ql0.f(5, enumC19802qy.j());
        }
    }

    public String toString() {
        return "struct GoldGiftPacketMessage{}";
    }

    public long u() {
        return this.b;
    }

    public long w() {
        return this.c;
    }

    public String y() {
        return this.d;
    }

    public EnumC19802qy z() {
        return this.e;
    }

    public C22874vy() {
    }
}
