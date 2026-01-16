package ir.nasim;

import android.content.Context;

/* renamed from: ir.nasim.qs6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C19751qs6 extends AbstractC12586er6 {
    public /* synthetic */ C19751qs6(C11909dl1 c11909dl1, int i, ED1 ed1) {
        this((i & 1) != 0 ? new C11909dl1(new C23011wC("Contact registered", new C13420gC())) : c11909dl1);
    }

    @Override // ir.nasim.InterfaceC13222fr6
    public String a(Context context, int i, String str, boolean z) {
        AbstractC13042fc3.i(context, "context");
        return AbstractC20655sN7.b(AbstractC20655sN7.c(context, AbstractC12217eE5.service_holder_user_registered, C24847zI7.b(C24847zI7.a, context, i, str, false, 8, null), context.getString(AbstractC12217eE5.all_app_name)), context, i == AbstractC5969Lp4.f());
    }

    @Override // ir.nasim.AbstractC12586er6, ir.nasim.InterfaceC25103zk1
    public String b(Context context, int i, String str, boolean z) {
        AbstractC13042fc3.i(context, "context");
        String string = context.getString(AbstractC12217eE5.service_holder_user_registered_compact, context.getString(AbstractC12217eE5.all_app_name));
        AbstractC13042fc3.h(string, "getString(...)");
        return string;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C19751qs6(C11909dl1 c11909dl1) {
        super(c11909dl1, (ED1) null);
        AbstractC13042fc3.i(c11909dl1, "contentContainer");
    }
}
