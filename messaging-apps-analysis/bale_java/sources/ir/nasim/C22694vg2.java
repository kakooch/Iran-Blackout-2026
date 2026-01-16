package ir.nasim;

import ir.nasim.core.modules.file.entity.FileReference;

/* renamed from: ir.nasim.vg2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C22694vg2 {
    private int a;
    private int b;
    private byte[] c;
    private C11920dm2 d;

    public C22694vg2(RG3 rg3) {
        this.a = rg3.s();
        this.b = rg3.q();
        this.c = rg3.r();
    }

    public C11920dm2 a() {
        return this.d;
    }

    public int b() {
        return this.b;
    }

    public byte[] c() {
        return this.c;
    }

    public int d() {
        return this.a;
    }

    public C22694vg2(C11413cy c11413cy) {
        this.a = c11413cy.u();
        this.b = c11413cy.q();
        this.c = c11413cy.s();
        if (c11413cy.r() != null) {
            this.d = new C11920dm2(new FileReference(c11413cy.r(), "Thumb" + c11413cy.r().getFileId() + c11413cy.r().getAccessHash(), "", 1));
        }
    }

    public C22694vg2(int i, int i2, byte[] bArr) {
        this.a = i;
        this.b = i2;
        this.c = bArr;
    }
}
