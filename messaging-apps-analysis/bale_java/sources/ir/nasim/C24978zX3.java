package ir.nasim;

import ir.nasim.AbstractC15520jj2;
import java.util.ArrayList;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.zX3, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C24978zX3 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public AbstractC17457n0 a(AbstractC15520jj2.d dVar) {
        AbstractC13042fc3.i(dVar, "input");
        if ((dVar instanceof AbstractC15520jj2.c) || (dVar instanceof AbstractC15520jj2.e)) {
            AbstractC15520jj2.e eVar = (AbstractC15520jj2.e) dVar;
            return C13388g85.l.b(eVar.d(), new ArrayList(), eVar.g(), eVar.e(), new C22694vg2(eVar.g(), eVar.e(), eVar.f()));
        }
        if (!(dVar instanceof AbstractC15520jj2.h)) {
            throw new NoWhenBranchMatchedException();
        }
        AbstractC15520jj2.h hVar = (AbstractC15520jj2.h) dVar;
        return GS7.n.f(hVar.d(), new ArrayList(), hVar.g(), hVar.e(), hVar.h(), new C22694vg2(hVar.g(), hVar.e(), hVar.f()));
    }
}
