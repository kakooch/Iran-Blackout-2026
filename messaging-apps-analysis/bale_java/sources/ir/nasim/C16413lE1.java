package ir.nasim;

import androidx.compose.foundation.lazy.layout.d;

/* renamed from: ir.nasim.lE1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C16413lE1 implements InterfaceC3901Cv3 {
    private final int a;
    private int b = -1;
    private final C12544en4 c = new C12544en4(new d.b[16], 0);
    private boolean d;

    public C16413lE1(int i) {
        this.a = i;
    }

    @Override // ir.nasim.InterfaceC3901Cv3
    public void a(InterfaceC23982xq4 interfaceC23982xq4, int i) {
        int i2 = this.a;
        for (int i3 = 0; i3 < i2; i3++) {
            interfaceC23982xq4.a(i + i3);
        }
    }

    @Override // ir.nasim.InterfaceC3901Cv3
    public void c(InterfaceC3667Bv3 interfaceC3667Bv3, InterfaceC21665tv3 interfaceC21665tv3) {
        int iF;
        if (this.b == -1 || !(!interfaceC21665tv3.i().isEmpty())) {
            return;
        }
        if (this.d) {
            InterfaceC16823lv3 interfaceC16823lv3 = (InterfaceC16823lv3) AbstractC15401jX0.C0(interfaceC21665tv3.i());
            iF = (interfaceC21665tv3.a() == EnumC24286yM4.a ? interfaceC16823lv3.f() : interfaceC16823lv3.b()) + 1;
        } else {
            InterfaceC16823lv3 interfaceC16823lv32 = (InterfaceC16823lv3) AbstractC15401jX0.q0(interfaceC21665tv3.i());
            iF = (interfaceC21665tv3.a() == EnumC24286yM4.a ? interfaceC16823lv32.f() : interfaceC16823lv32.b()) - 1;
        }
        if (this.b != iF) {
            this.b = -1;
            C12544en4 c12544en4 = this.c;
            Object[] objArr = c12544en4.a;
            int iO = c12544en4.o();
            for (int i = 0; i < iO; i++) {
                ((d.b) objArr[i]).cancel();
            }
            this.c.k();
        }
    }

    @Override // ir.nasim.InterfaceC3901Cv3
    public void d(InterfaceC3667Bv3 interfaceC3667Bv3, float f, InterfaceC21665tv3 interfaceC21665tv3) {
        int iF;
        int index;
        if (!interfaceC21665tv3.i().isEmpty()) {
            int i = 0;
            boolean z = f < 0.0f;
            if (z) {
                InterfaceC16823lv3 interfaceC16823lv3 = (InterfaceC16823lv3) AbstractC15401jX0.C0(interfaceC21665tv3.i());
                iF = (interfaceC21665tv3.a() == EnumC24286yM4.a ? interfaceC16823lv3.f() : interfaceC16823lv3.b()) + 1;
                index = ((InterfaceC16823lv3) AbstractC15401jX0.C0(interfaceC21665tv3.i())).getIndex() + 1;
            } else {
                InterfaceC16823lv3 interfaceC16823lv32 = (InterfaceC16823lv3) AbstractC15401jX0.q0(interfaceC21665tv3.i());
                iF = (interfaceC21665tv3.a() == EnumC24286yM4.a ? interfaceC16823lv32.f() : interfaceC16823lv32.b()) - 1;
                index = ((InterfaceC16823lv3) AbstractC15401jX0.q0(interfaceC21665tv3.i())).getIndex() - 1;
            }
            if (index < 0 || index >= interfaceC21665tv3.g()) {
                return;
            }
            if (iF != this.b && iF >= 0) {
                if (this.d != z) {
                    C12544en4 c12544en4 = this.c;
                    Object[] objArr = c12544en4.a;
                    int iO = c12544en4.o();
                    for (int i2 = 0; i2 < iO; i2++) {
                        ((d.b) objArr[i2]).cancel();
                    }
                }
                this.d = z;
                this.b = iF;
                this.c.k();
                C12544en4 c12544en42 = this.c;
                c12544en42.h(c12544en42.o(), interfaceC3667Bv3.a(iF));
            }
            if (!z) {
                if (interfaceC21665tv3.f() - AbstractC5320Iv3.b((InterfaceC16823lv3) AbstractC15401jX0.q0(interfaceC21665tv3.i()), interfaceC21665tv3.a()) < f) {
                    C12544en4 c12544en43 = this.c;
                    Object[] objArr2 = c12544en43.a;
                    int iO2 = c12544en43.o();
                    while (i < iO2) {
                        ((d.b) objArr2[i]).a();
                        i++;
                    }
                    return;
                }
                return;
            }
            InterfaceC16823lv3 interfaceC16823lv33 = (InterfaceC16823lv3) AbstractC15401jX0.C0(interfaceC21665tv3.i());
            if (((AbstractC5320Iv3.b(interfaceC16823lv33, interfaceC21665tv3.a()) + AbstractC5320Iv3.c(interfaceC16823lv33, interfaceC21665tv3.a())) + interfaceC21665tv3.h()) - interfaceC21665tv3.d() < (-f)) {
                C12544en4 c12544en44 = this.c;
                Object[] objArr3 = c12544en44.a;
                int iO3 = c12544en44.o();
                while (i < iO3) {
                    ((d.b) objArr3[i]).a();
                    i++;
                }
            }
        }
    }
}
