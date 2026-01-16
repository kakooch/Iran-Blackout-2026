package ir.nasim;

import android.content.Context;

/* renamed from: ir.nasim.Jq6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5512Jq6 extends AbstractC12586er6 {
    private C8894Xu d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5512Jq6(C8540Wk1 c8540Wk1) {
        super(c8540Wk1, (ED1) null);
        AbstractC13042fc3.i(c8540Wk1, "contentContainer");
        AbstractC19230q0 abstractC19230q0C = c8540Wk1.c();
        AbstractC13042fc3.g(abstractC19230q0C, "null cannot be cast to non-null type ir.nasim.core.modules.users.entity.AnonymousUser");
        this.d = (C8894Xu) abstractC19230q0C;
    }

    @Override // ir.nasim.InterfaceC13222fr6
    public String a(Context context, int i, String str, boolean z) {
        AbstractC13042fc3.i(context, "context");
        return r();
    }

    public final C8894Xu s() {
        return this.d;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5512Jq6(C11909dl1 c11909dl1) {
        super(c11909dl1, (ED1) null);
        AbstractC13042fc3.i(c11909dl1, "contentContainer");
        c11909dl1.c();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C5512Jq6(C8894Xu c8894Xu) {
        this(new C8540Wk1(c8894Xu));
        AbstractC13042fc3.i(c8894Xu, "anonymousUser");
        this.d = c8894Xu;
    }
}
