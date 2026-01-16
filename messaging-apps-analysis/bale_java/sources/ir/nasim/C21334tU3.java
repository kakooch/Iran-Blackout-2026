package ir.nasim;

import ir.nasim.C20105rU3;
import ir.nasim.HW4;

/* renamed from: ir.nasim.tU3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C21334tU3 extends AbstractC16876m1 {
    private final C20105rU3.b a;

    /* renamed from: ir.nasim.tU3$a */
    public interface a {
        void a(C20105rU3.b bVar);
    }

    C21334tU3(C20105rU3.b bVar) {
        this.a = bVar;
    }

    public static C21334tU3 j(a aVar) {
        C20105rU3.b bVarW = C20105rU3.w();
        aVar.a(bVarW);
        return new C21334tU3(bVarW);
    }

    @Override // ir.nasim.AbstractC16876m1, ir.nasim.InterfaceC21991uU3
    public void d(HW4.a aVar) {
        aVar.h(this.a.a());
    }
}
