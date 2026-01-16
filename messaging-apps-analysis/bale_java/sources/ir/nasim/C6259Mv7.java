package ir.nasim;

import java.util.Set;

/* renamed from: ir.nasim.Mv7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C6259Mv7 implements InterfaceC6025Lv7 {
    private final Set a;
    private final AbstractC5792Kv7 b;
    private final InterfaceC6992Pv7 c;

    C6259Mv7(Set set, AbstractC5792Kv7 abstractC5792Kv7, InterfaceC6992Pv7 interfaceC6992Pv7) {
        this.a = set;
        this.b = abstractC5792Kv7;
        this.c = interfaceC6992Pv7;
    }

    @Override // ir.nasim.InterfaceC6025Lv7
    public InterfaceC5324Iv7 a(String str, Class cls, C11515d82 c11515d82, InterfaceC19191pv7 interfaceC19191pv7) {
        if (this.a.contains(c11515d82)) {
            return new C6758Ov7(this.b, str, c11515d82, interfaceC19191pv7, this.c);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", c11515d82, this.a));
    }
}
