package ir.nasim;

import android.content.Context;

/* renamed from: ir.nasim.zr6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C25178zr6 extends AbstractC12586er6 {
    /* JADX WARN: Multi-variable type inference failed */
    public C25178zr6() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // ir.nasim.InterfaceC13222fr6
    public String a(Context context, int i, String str, boolean z) {
        AbstractC13042fc3.i(context, "context");
        if (z) {
            return AbstractC20655sN7.b(AbstractC20655sN7.c(context, AbstractC12217eE5.service_holder_group_member_joined, C24847zI7.a.a(context, i, str, true)), context, i == AbstractC5969Lp4.f());
        }
        String string = context.getString(AbstractC12217eE5.service_holder_channel_member_joined);
        AbstractC13042fc3.f(string);
        return string;
    }

    public /* synthetic */ C25178zr6(C11909dl1 c11909dl1, int i, ED1 ed1) {
        this((i & 1) != 0 ? new C11909dl1(new C23011wC("User joined", new C21151tC())) : c11909dl1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C25178zr6(C11909dl1 c11909dl1) {
        super(c11909dl1, (ED1) null);
        AbstractC13042fc3.i(c11909dl1, "contentContainer");
    }
}
