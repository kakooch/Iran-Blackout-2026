package ir.nasim;

import ir.nasim.core.modules.file.entity.FileReference;

/* renamed from: ir.nasim.iH2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C14661iH2 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public QG2 a(C5845Lb6 c5845Lb6) {
        AbstractC13042fc3.i(c5845Lb6, "input");
        return new QG2(new FileReference(new C12056dy(c5845Lb6.c(), c5845Lb6.a(), Integer.valueOf(c5845Lb6.e())), String.valueOf(System.currentTimeMillis()), null, (int) c5845Lb6.d()), c5845Lb6.k(), c5845Lb6.f(), c5845Lb6.b(), c5845Lb6.j(), null, c5845Lb6.h(), c5845Lb6.i(), 32, null);
    }
}
