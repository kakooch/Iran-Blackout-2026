package ir.nasim;

/* renamed from: ir.nasim.dy, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C12056dy extends AbstractC17902nl0 {
    private long a;
    private long b;
    private Integer c;

    public C12056dy(long j, long j2, Integer num) {
        this.a = j;
        this.b = j2;
        this.c = num;
    }

    public long getAccessHash() {
        return this.b;
    }

    public long getFileId() {
        return this.a;
    }

    public Integer getFileStorageVersion() {
        return this.c;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.i(1);
        this.b = c19084pl0.i(2);
        this.c = Integer.valueOf(c19084pl0.x(3));
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.g(1, this.a);
        c19675ql0.g(2, this.b);
        Integer num = this.c;
        if (num != null) {
            c19675ql0.f(3, num.intValue());
        }
    }

    public String toString() {
        return "struct FileLocation{}";
    }

    public C12056dy() {
    }
}
