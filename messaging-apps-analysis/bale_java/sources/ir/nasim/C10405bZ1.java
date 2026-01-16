package ir.nasim;

/* renamed from: ir.nasim.bZ1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C10405bZ1 extends AbstractC17902nl0 implements InterfaceC8844Xo3 {
    private long a;
    private int b;
    private String c;

    public C10405bZ1(long j, int i, String str) {
        AbstractC13042fc3.i(str, "descriptor");
        this.a = j;
        this.b = i;
        this.c = str;
    }

    @Override // ir.nasim.InterfaceC8844Xo3
    public long a() {
        return this.a;
    }

    public final long getFileId() {
        return this.a;
    }

    public final int getFileSize() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        AbstractC13042fc3.i(c19084pl0, "values");
        this.a = c19084pl0.i(1);
        this.b = c19084pl0.g(2);
        this.c = c19084pl0.r(3);
    }

    public final String q() {
        return this.c;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        AbstractC13042fc3.i(c19675ql0, "writer");
        c19675ql0.g(1, this.a);
        c19675ql0.f(2, this.b);
        c19675ql0.o(3, this.c);
    }

    public C10405bZ1() {
        this.c = "";
    }
}
