package androidx.compose.animation;

import ir.nasim.C4414Fa3;
import ir.nasim.InterfaceC10195bE6;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC4788Go2;

/* loaded from: classes.dex */
final class m implements InterfaceC10195bE6 {
    private final boolean a;
    private final InterfaceC14603iB2 b;

    public m(boolean z, InterfaceC14603iB2 interfaceC14603iB2) {
        this.a = z;
        this.b = interfaceC14603iB2;
    }

    @Override // ir.nasim.InterfaceC10195bE6
    public boolean a() {
        return this.a;
    }

    @Override // ir.nasim.InterfaceC10195bE6
    public InterfaceC4788Go2 b(long j, long j2) {
        return (InterfaceC4788Go2) this.b.invoke(C4414Fa3.b(j), C4414Fa3.b(j2));
    }
}
