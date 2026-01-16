package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.Jb1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C5372Jb1 extends C22643vb1 {
    private final AbstractC11279ck3 c;
    private int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5372Jb1(InterfaceC6075Mb3 interfaceC6075Mb3, AbstractC11279ck3 abstractC11279ck3) {
        super(interfaceC6075Mb3);
        AbstractC13042fc3.i(interfaceC6075Mb3, "writer");
        AbstractC13042fc3.i(abstractC11279ck3, "json");
        this.c = abstractC11279ck3;
    }

    @Override // ir.nasim.C22643vb1
    public void b() {
        o(true);
        this.d++;
    }

    @Override // ir.nasim.C22643vb1
    public void c() {
        o(false);
        k(Separators.RETURN);
        int i = this.d;
        for (int i2 = 0; i2 < i; i2++) {
            k(this.c.d().m());
        }
    }

    @Override // ir.nasim.C22643vb1
    public void d() {
        if (a()) {
            o(false);
        } else {
            c();
        }
    }

    @Override // ir.nasim.C22643vb1
    public void p() {
        f(' ');
    }

    @Override // ir.nasim.C22643vb1
    public void q() {
        this.d--;
    }
}
