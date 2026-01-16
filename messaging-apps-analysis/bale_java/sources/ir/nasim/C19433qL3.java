package ir.nasim;

import ir.nasim.K34;

/* renamed from: ir.nasim.qL3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C19433qL3 extends C15887kL3 implements K34 {
    private K34.a e;

    public C19433qL3(long j) {
        super(j);
    }

    @Override // ir.nasim.K34
    public void a(int i) {
        if (i >= 40) {
            b();
        } else if (i >= 20 || i == 15) {
            m(h() / 2);
        }
    }

    @Override // ir.nasim.K34
    public /* bridge */ /* synthetic */ DW5 c(InterfaceC14373ho3 interfaceC14373ho3, DW5 dw5) {
        return (DW5) super.k(interfaceC14373ho3, dw5);
    }

    @Override // ir.nasim.K34
    public void d(K34.a aVar) {
        this.e = aVar;
    }

    @Override // ir.nasim.K34
    public /* bridge */ /* synthetic */ DW5 e(InterfaceC14373ho3 interfaceC14373ho3) {
        return (DW5) super.l(interfaceC14373ho3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.C15887kL3
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public int i(DW5 dw5) {
        return dw5 == null ? super.i(null) : dw5.f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.C15887kL3
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void j(InterfaceC14373ho3 interfaceC14373ho3, DW5 dw5) {
        K34.a aVar = this.e;
        if (aVar == null || dw5 == null) {
            return;
        }
        aVar.a(dw5);
    }
}
