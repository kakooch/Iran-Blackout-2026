package ir.nasim;

import ir.nasim.AV7;
import ir.nasim.AbstractC22594vV7;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.zV7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C24964zV7 implements InterfaceC14123hO3 {
    public static final C24964zV7 a = new C24964zV7();

    private C24964zV7() {
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public AV7 a(AbstractC22594vV7 abstractC22594vV7) {
        AbstractC13042fc3.i(abstractC22594vV7, "input");
        if (abstractC22594vV7 instanceof AbstractC22594vV7.a) {
            return new AV7.a(((AbstractC22594vV7.a) abstractC22594vV7).a());
        }
        if (abstractC22594vV7 instanceof AbstractC22594vV7.b) {
            return new AV7.b(((AbstractC22594vV7.b) abstractC22594vV7).n());
        }
        throw new NoWhenBranchMatchedException();
    }
}
