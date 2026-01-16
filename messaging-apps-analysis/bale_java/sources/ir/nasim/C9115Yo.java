package ir.nasim;

import java.io.File;

/* renamed from: ir.nasim.Yo, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C9115Yo implements InterfaceC3346Am2 {
    private final String a;

    public C9115Yo(String str) {
        AbstractC13042fc3.i(str, "descriptor");
        this.a = str;
    }

    @Override // ir.nasim.InterfaceC3346Am2
    public boolean a() {
        return new File(getDescriptor()).exists();
    }

    @Override // ir.nasim.InterfaceC3346Am2
    public DN4 b(int i) {
        return new C13796gq(getDescriptor(), i);
    }

    @Override // ir.nasim.InterfaceC3346Am2
    public InterfaceC17551n93 c() {
        return new C19714qp(getDescriptor());
    }

    @Override // ir.nasim.InterfaceC3346Am2
    public int f() {
        return (int) new File(getDescriptor()).length();
    }

    @Override // ir.nasim.InterfaceC3346Am2
    public String getDescriptor() {
        return this.a;
    }
}
