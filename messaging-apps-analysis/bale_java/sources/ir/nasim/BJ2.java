package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class BJ2 extends AbstractC17457n0 {
    public final long c;
    public final long d;
    public final long e;
    private final String f;
    public final EnumC19802qy g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BJ2(C11909dl1 c11909dl1) {
        super(c11909dl1);
        AbstractC13042fc3.i(c11909dl1, "contentContainer");
        AbstractC24063xz abstractC24063xzC = c11909dl1.c();
        AbstractC13042fc3.g(abstractC24063xzC, "null cannot be cast to non-null type ir.nasim.core.api.ApiGoldGiftPacketMessage");
        C22874vy c22874vy = (C22874vy) abstractC24063xzC;
        this.c = c22874vy.C();
        this.d = c22874vy.u();
        this.e = c22874vy.w();
        this.f = c22874vy.y();
        EnumC19802qy enumC19802qyZ = c22874vy.z();
        this.g = enumC19802qyZ == null ? EnumC19802qy.UNSUPPORTED_VALUE : enumC19802qyZ;
    }

    @Override // ir.nasim.InterfaceC25103zk1
    public String b(Context context, int i, String str, boolean z) {
        AbstractC13042fc3.i(context, "context");
        String string = context.getString(AbstractC12217eE5.gold_gift_packet);
        AbstractC13042fc3.h(string, "getString(...)");
        return string;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!AbstractC13042fc3.d(BJ2.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        AbstractC13042fc3.g(obj, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.GoldGiftPacketContent");
        BJ2 bj2 = (BJ2) obj;
        return this.c == bj2.c && this.d == bj2.d && this.e == bj2.e && AbstractC13042fc3.d(this.f, bj2.f) && this.g == bj2.g;
    }

    public int hashCode() {
        return (((((((Long.hashCode(this.c) * 31) + Long.hashCode(this.d)) * 31) + Long.hashCode(this.e)) * 31) + this.f.hashCode()) * 31) + this.g.hashCode();
    }

    @Override // ir.nasim.AbstractC17457n0
    public String j(Context context) {
        AbstractC13042fc3.i(context, "context");
        return context.getString(AbstractC12217eE5.gold_gift_packet) + Separators.SP + context.getString(AbstractC12217eE5.chat_fragment_has_caption_content_description) + Separators.SP + this.f;
    }

    @Override // ir.nasim.AbstractC17457n0
    public C23345wl7 l() {
        return null;
    }

    public final String r() {
        return this.f;
    }
}
