package ir.nasim;

import androidx.compose.foundation.lazy.layout.d;

/* renamed from: ir.nasim.mE1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C17004mE1 implements InterfaceC13869gx3 {
    private final int a;
    private int b = -1;
    private d.b c;
    private boolean d;

    public C17004mE1(int i) {
        this.a = i;
    }

    @Override // ir.nasim.InterfaceC13869gx3
    public void a(InterfaceC23982xq4 interfaceC23982xq4, int i) {
        int i2 = this.a;
        for (int i3 = 0; i3 < i2; i3++) {
            interfaceC23982xq4.a(i + i3);
        }
    }

    @Override // ir.nasim.InterfaceC13869gx3
    public void c(InterfaceC13278fx3 interfaceC13278fx3, InterfaceC9425Zw3 interfaceC9425Zw3) {
        if (this.b == -1 || !(!interfaceC9425Zw3.i().isEmpty())) {
            return;
        }
        if (this.b != (this.d ? ((InterfaceC7948Tw3) AbstractC15401jX0.C0(interfaceC9425Zw3.i())).getIndex() + 1 : ((InterfaceC7948Tw3) AbstractC15401jX0.q0(interfaceC9425Zw3.i())).getIndex() - 1)) {
            this.b = -1;
            d.b bVar = this.c;
            if (bVar != null) {
                bVar.cancel();
            }
            this.c = null;
        }
    }

    @Override // ir.nasim.InterfaceC13869gx3
    public void d(InterfaceC13278fx3 interfaceC13278fx3, float f, InterfaceC9425Zw3 interfaceC9425Zw3) {
        d.b bVar;
        d.b bVar2;
        d.b bVar3;
        if (!interfaceC9425Zw3.i().isEmpty()) {
            boolean z = f < 0.0f;
            int index = z ? ((InterfaceC7948Tw3) AbstractC15401jX0.C0(interfaceC9425Zw3.i())).getIndex() + 1 : ((InterfaceC7948Tw3) AbstractC15401jX0.q0(interfaceC9425Zw3.i())).getIndex() - 1;
            if (index < 0 || index >= interfaceC9425Zw3.g()) {
                return;
            }
            if (index != this.b) {
                if (this.d != z && (bVar3 = this.c) != null) {
                    bVar3.cancel();
                }
                this.d = z;
                this.b = index;
                this.c = interfaceC13278fx3.a(index);
            }
            if (!z) {
                if (interfaceC9425Zw3.f() - ((InterfaceC7948Tw3) AbstractC15401jX0.q0(interfaceC9425Zw3.i())).getOffset() >= f || (bVar = this.c) == null) {
                    return;
                }
                bVar.a();
                return;
            }
            InterfaceC7948Tw3 interfaceC7948Tw3 = (InterfaceC7948Tw3) AbstractC15401jX0.C0(interfaceC9425Zw3.i());
            if (((interfaceC7948Tw3.getOffset() + interfaceC7948Tw3.f()) + interfaceC9425Zw3.h()) - interfaceC9425Zw3.d() >= (-f) || (bVar2 = this.c) == null) {
                return;
            }
            bVar2.a();
        }
    }
}
