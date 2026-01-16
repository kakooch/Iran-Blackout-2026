package ir.nasim;

import android.content.Context;

/* renamed from: ir.nasim.fJ6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C12872fJ6 extends AbstractC17457n0 {
    private C4626Fy c;
    private String d;
    private int e;
    private String f;
    private int g;
    private int h;
    private String i;
    private String j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12872fJ6(C8540Wk1 c8540Wk1) {
        super(c8540Wk1);
        AbstractC13042fc3.i(c8540Wk1, "contentLocalContainer");
        this.d = "";
        this.f = "";
        this.i = "";
        this.j = "";
        AbstractC19230q0 abstractC19230q0C = c8540Wk1.c();
        AbstractC13042fc3.g(abstractC19230q0C, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.internal.LocalSponsored");
        C18215oH3 c18215oH3 = (C18215oH3) abstractC19230q0C;
        this.c = c18215oH3.s();
        this.d = c18215oH3.w();
        this.e = c18215oH3.getPeerId();
        this.f = c18215oH3.u();
        this.g = c18215oH3.C();
        this.h = c18215oH3.D();
        this.i = c18215oH3.y();
        this.j = c18215oH3.z();
    }

    @Override // ir.nasim.InterfaceC25103zk1
    public String b(Context context, int i, String str, boolean z) {
        AbstractC13042fc3.i(context, "context");
        return InterfaceC25103zk1.a.a(context);
    }

    @Override // ir.nasim.AbstractC17457n0
    public C23345wl7 l() {
        return null;
    }

    public final C4626Fy r() {
        return this.c;
    }

    public final String s() {
        return this.f;
    }

    public final String t() {
        return this.d;
    }

    public final String u() {
        return this.i;
    }

    public final String v() {
        return this.j;
    }

    public final int w() {
        return this.e;
    }

    public final int x() {
        return this.g;
    }

    public final int y() {
        return this.h;
    }
}
