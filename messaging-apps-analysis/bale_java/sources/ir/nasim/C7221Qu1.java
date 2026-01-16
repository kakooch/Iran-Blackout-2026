package ir.nasim;

import ir.nasim.AbstractC17757nW1;
import ir.nasim.core.modules.file.entity.FileReference;

/* renamed from: ir.nasim.Qu1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C7221Qu1 extends C22007uW1 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C7221Qu1(C14970in2 c14970in2, AbstractC17757nW1 abstractC17757nW1) {
        super(c14970in2, abstractC17757nW1, null, 4, null);
        AbstractC13042fc3.i(c14970in2, "filesModule");
        AbstractC13042fc3.i(abstractC17757nW1, "document");
    }

    @Override // ir.nasim.C22007uW1
    public boolean Q(EnumC18310oS enumC18310oS, FileReference fileReference) {
        AbstractC13042fc3.i(enumC18310oS, "autoDownload");
        AbstractC13042fc3.i(fileReference, "fileReference");
        return true;
    }

    @Override // ir.nasim.C22007uW1
    public void l() {
        if (!(s() instanceof AbstractC17757nW1.c.b.C1415b)) {
            super.l();
            return;
        }
        for (AbstractC22597vW1 abstractC22597vW1 : r()) {
            String strA = ((AbstractC17757nW1.c.b.C1415b) s()).b().a().a();
            if (strA == null) {
                strA = "";
            }
            C9115Yo c9115Yo = new C9115Yo(strA);
            abstractC22597vW1.m(0.0f, true);
            abstractC22597vW1.d(c9115Yo);
        }
    }
}
