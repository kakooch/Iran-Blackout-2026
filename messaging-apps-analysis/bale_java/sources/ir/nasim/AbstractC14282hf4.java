package ir.nasim;

/* renamed from: ir.nasim.hf4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC14282hf4 implements InterfaceC24449ye1, Comparable {
    private int a;

    public AbstractC14282hf4(int i) {
        this.a = i;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(AbstractC14282hf4 abstractC14282hf4) {
        return this.a - abstractC14282hf4.a;
    }

    public int h() {
        return this.a;
    }
}
