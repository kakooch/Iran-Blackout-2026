package ir.nasim;

/* renamed from: ir.nasim.Xy, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C8950Xy implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public CD4 a(C8664Wy c8664Wy) {
        AbstractC13042fc3.i(c8664Wy, "input");
        C19231q00 c19231q00 = new C19231q00(c8664Wy.u());
        return AbstractC13042fc3.d(c19231q00.n("dataType"), "contact") ? C23615xD4.a : AbstractC13042fc3.d(c19231q00.n("dataType"), "location") ? C24205yD4.a : new C24214yE4(null);
    }
}
