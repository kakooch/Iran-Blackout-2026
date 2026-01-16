package ir.nasim;

import android.content.Context;
import ir.nasim.core.modules.profile.entity.Avatar;

/* renamed from: ir.nasim.lr6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C16786lr6 extends AbstractC12586er6 {
    private final Avatar d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C16786lr6(C11909dl1 c11909dl1) {
        super(c11909dl1, (ED1) null);
        AbstractC13042fc3.i(c11909dl1, "remoteContainer");
        AbstractC24063xz abstractC24063xzC = c11909dl1.c();
        AbstractC13042fc3.g(abstractC24063xzC, "null cannot be cast to non-null type ir.nasim.core.api.ApiServiceMessage");
        VB vbU = ((C23011wC) abstractC24063xzC).u();
        AbstractC13042fc3.g(vbU, "null cannot be cast to non-null type ir.nasim.core.api.ApiServiceExChangedAvatar");
        C6984Pv c6984PvU = ((C9576aC) vbU).u();
        this.d = c6984PvU != null ? new Avatar(c6984PvU) : null;
    }

    @Override // ir.nasim.InterfaceC13222fr6
    public String a(Context context, int i, String str, boolean z) {
        AbstractC13042fc3.i(context, "context");
        String strB = C24847zI7.b(C24847zI7.a, context, i, str, false, 8, null);
        if (this.d != null) {
            if (!z) {
                String string = context.getString(AbstractC12217eE5.service_holder_channel_avatar_changed);
                AbstractC13042fc3.f(string);
                return string;
            }
            if (i != AbstractC5969Lp4.f()) {
                return AbstractC20655sN7.c(context, AbstractC12217eE5.service_holder_group_avatar_changed_by, strB);
            }
            String string2 = context.getString(AbstractC12217eE5.service_holder_group_avatar_changed_by_me);
            AbstractC13042fc3.f(string2);
            return string2;
        }
        if (!z) {
            String string3 = context.getString(AbstractC12217eE5.service_holder_channel_avatar_removed);
            AbstractC13042fc3.f(string3);
            return string3;
        }
        if (i != AbstractC5969Lp4.f()) {
            return AbstractC20655sN7.c(context, AbstractC12217eE5.service_holder_group_avatar_removed_by, strB);
        }
        String string4 = context.getString(AbstractC12217eE5.service_holder_group_avatar_removed_by_me);
        AbstractC13042fc3.f(string4);
        return string4;
    }

    public C16786lr6(C6984Pv c6984Pv) {
        this(new C11909dl1(new C23011wC("Avatar changed", new C9576aC(c6984Pv))));
    }
}
