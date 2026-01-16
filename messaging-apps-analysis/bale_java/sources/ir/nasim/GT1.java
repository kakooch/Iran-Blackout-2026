package ir.nasim;

import ir.nasim.C13476gI1;

/* loaded from: classes2.dex */
class GT1 extends C13476gI1 {
    public int m;

    public GT1(AbstractC15192j98 abstractC15192j98) {
        super(abstractC15192j98);
        if (abstractC15192j98 instanceof RY2) {
            this.e = C13476gI1.a.HORIZONTAL_DIMENSION;
        } else {
            this.e = C13476gI1.a.VERTICAL_DIMENSION;
        }
    }

    @Override // ir.nasim.C13476gI1
    public void d(int i) {
        if (this.j) {
            return;
        }
        this.j = true;
        this.g = i;
        for (InterfaceC10842cI1 interfaceC10842cI1 : this.k) {
            interfaceC10842cI1.a(interfaceC10842cI1);
        }
    }
}
