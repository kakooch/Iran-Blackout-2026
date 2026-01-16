package ir.nasim;

/* renamed from: ir.nasim.Fb1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C4421Fb1 extends C22643vb1 {
    private final boolean c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4421Fb1(InterfaceC6075Mb3 interfaceC6075Mb3, boolean z) {
        super(interfaceC6075Mb3);
        AbstractC13042fc3.i(interfaceC6075Mb3, "writer");
        this.c = z;
    }

    @Override // ir.nasim.C22643vb1
    public void e(byte b) {
        boolean z = this.c;
        String strO = C7743Sz7.o(C7743Sz7.h(b));
        if (z) {
            n(strO);
        } else {
            k(strO);
        }
    }

    @Override // ir.nasim.C22643vb1
    public void i(int i) {
        boolean z = this.c;
        int iH = C11540dA7.h(i);
        if (z) {
            n(Long.toString(iH & 4294967295L, 10));
        } else {
            k(Long.toString(iH & 4294967295L, 10));
        }
    }

    @Override // ir.nasim.C22643vb1
    public void j(long j) {
        boolean z = this.c;
        long jH = C14599iA7.h(j);
        if (z) {
            n(AbstractC3953Db1.a(jH, 10));
        } else {
            k(AbstractC4187Eb1.a(jH, 10));
        }
    }

    @Override // ir.nasim.C22643vb1
    public void l(short s) {
        boolean z = this.c;
        String strO = C24771zA7.o(C24771zA7.h(s));
        if (z) {
            n(strO);
        } else {
            k(strO);
        }
    }
}
