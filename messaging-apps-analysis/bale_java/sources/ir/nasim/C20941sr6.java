package ir.nasim;

import android.content.Context;

/* renamed from: ir.nasim.sr6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C20941sr6 extends AbstractC12586er6 {
    /* JADX WARN: Multi-variable type inference failed */
    public C20941sr6() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // ir.nasim.InterfaceC13222fr6
    public String a(Context context, int i, String str, boolean z) {
        AbstractC13042fc3.i(context, "context");
        return AbstractC20655sN7.c(context, AbstractC12217eE5.service_holder_group_created, AbstractC20655sN7.i(context, z, false, 2, null));
    }

    public /* synthetic */ C20941sr6(C11909dl1 c11909dl1, int i, ED1 ed1) {
        this((i & 1) != 0 ? new C11909dl1(new C23011wC("Group created", new C16393lC())) : c11909dl1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C20941sr6(C11909dl1 c11909dl1) {
        super(c11909dl1, (ED1) null);
        AbstractC13042fc3.i(c11909dl1, "contentContainer");
    }
}
