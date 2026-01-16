package ir.nasim;

import android.content.Context;
import ir.nasim.M44;
import java.util.List;

/* loaded from: classes5.dex */
public final class N74 implements InterfaceC14123hO3 {
    private final Context a;
    private final ZN2 b;
    private final SA2 c;
    private final GM5 d;
    private final boolean e;
    private final String f;
    private final UA2 g;

    public N74(Context context, ZN2 zn2, SA2 sa2, GM5 gm5, boolean z, String str, UA2 ua2) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(zn2, "groupType");
        AbstractC13042fc3.i(sa2, "relatedChannels");
        AbstractC13042fc3.i(gm5, "relatedChannelsListener");
        AbstractC13042fc3.i(str, "relatedChannelsTitle");
        AbstractC13042fc3.i(ua2, "commonGroups");
        this.a = context;
        this.b = zn2;
        this.c = sa2;
        this.d = gm5;
        this.e = z;
        this.f = str;
        this.g = ua2;
    }

    private final M44 b() {
        M44.a aVar = new M44.a();
        aVar.K(true);
        aVar.S(true);
        return aVar.a();
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C9456Zz7 a(J44 j44) {
        C9403Zu c9403Zu;
        String strA;
        List listS;
        AbstractC13042fc3.i(j44, "input");
        AbstractC17457n0 abstractC17457n0F = j44.F();
        AbstractC12586er6 abstractC12586er6 = abstractC17457n0F instanceof AbstractC12586er6 ? (AbstractC12586er6) abstractC17457n0F : null;
        if (abstractC12586er6 == null) {
            throw new IllegalArgumentException();
        }
        if (abstractC12586er6 instanceof C5512Jq6) {
            C5512Jq6 c5512Jq6 = (C5512Jq6) abstractC12586er6;
            c5512Jq6.s();
            UA2 ua2 = this.g;
            C8894Xu c8894XuS = c5512Jq6.s();
            c9403Zu = new C9403Zu(AbstractC15401jX0.m1((Iterable) ua2.invoke((c8894XuS == null || (listS = c8894XuS.s()) == null) ? null : AbstractC15401jX0.m1(listS))), c5512Jq6.s());
        } else {
            c9403Zu = null;
        }
        if ((abstractC12586er6 instanceof C5980Lq6) || (abstractC12586er6 instanceof C6213Mq6)) {
            throw new IllegalArgumentException();
        }
        if (abstractC12586er6 instanceof C24584yr6) {
            int iU = j44.U();
            CI7 ci7Y = j44.Y();
            String strB = ci7Y != null ? ci7Y.b() : null;
            CI7 ci7Y2 = j44.Y();
            if (ci7Y2 != null && ci7Y2.d()) {
                iU = 0;
            }
            strA = ((C24584yr6) abstractC12586er6).a(this.a, iU, strB, this.b == ZN2.GROUP);
        } else {
            int iU2 = j44.U();
            CI7 ci7Y3 = j44.Y();
            strA = abstractC12586er6.a(this.a, iU2, ci7Y3 != null ? ci7Y3.b() : null, this.b == ZN2.GROUP);
        }
        return new C9456Zz7(new Q64(j44.h(), j44.i()), AbstractC17636nI6.i(strA), b(), j44, this.c, this.d, this.e, this.f, c9403Zu);
    }
}
