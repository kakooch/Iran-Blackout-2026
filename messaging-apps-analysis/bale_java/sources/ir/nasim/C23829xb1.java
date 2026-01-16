package ir.nasim;

/* renamed from: ir.nasim.xb1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C23829xb1 extends C22643vb1 {
    private final boolean c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C23829xb1(InterfaceC6075Mb3 interfaceC6075Mb3, boolean z) {
        super(interfaceC6075Mb3);
        AbstractC13042fc3.i(interfaceC6075Mb3, "writer");
        this.c = z;
    }

    @Override // ir.nasim.C22643vb1
    public void n(String str) {
        AbstractC13042fc3.i(str, "value");
        if (this.c) {
            super.n(str);
        } else {
            super.k(str);
        }
    }
}
