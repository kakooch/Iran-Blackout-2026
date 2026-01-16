package ir.nasim;

import android.content.Context;
import java.util.Arrays;

/* renamed from: ir.nasim.lt, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C16799lt extends AbstractC17457n0 {
    public static final a h = new a(null);
    public static final int i = 8;
    private final Integer c;
    private final byte[] d;
    private final A23 e;
    private final Integer f;
    private final Long g;

    /* renamed from: ir.nasim.lt$a */
    public static final class a {
        private a() {
        }

        public final C16799lt a(C14419ht c14419ht) {
            AbstractC13042fc3.i(c14419ht, "animatedSticker");
            return new C16799lt(new C11909dl1(c14419ht.e()));
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C16799lt(C11909dl1 c11909dl1) {
        super(c11909dl1);
        AbstractC13042fc3.i(c11909dl1, "contentRemoteContainer");
        AbstractC24063xz abstractC24063xzC = c11909dl1.c();
        AbstractC13042fc3.g(abstractC24063xzC, "null cannot be cast to non-null type ir.nasim.core.api.ApiAnimatedStickerMessage");
        C5316Iv c5316Iv = (C5316Iv) abstractC24063xzC;
        this.c = c5316Iv.C();
        this.f = c5316Iv.z();
        this.g = c5316Iv.y();
        C4626Fy c4626FyW = c5316Iv.w();
        AbstractC13042fc3.f(c4626FyW);
        this.e = new A23(c4626FyW, "sticker.webp", "");
        this.d = c5316Iv.u();
    }

    public static final C16799lt r(C14419ht c14419ht) {
        return h.a(c14419ht);
    }

    @Override // ir.nasim.InterfaceC25103zk1
    public String b(Context context, int i2, String str, boolean z) {
        AbstractC13042fc3.i(context, "context");
        String string = context.getString(AbstractC12217eE5.message_holder_content_sticker);
        AbstractC13042fc3.h(string, "getString(...)");
        return string;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C16799lt) || !super.equals(obj)) {
            return false;
        }
        C16799lt c16799lt = (C16799lt) obj;
        if (!AbstractC13042fc3.d(this.c, c16799lt.c)) {
            return false;
        }
        byte[] bArr = this.d;
        if (bArr != null) {
            byte[] bArr2 = c16799lt.d;
            if (bArr2 == null || !Arrays.equals(bArr, bArr2)) {
                return false;
            }
        } else if (c16799lt.d != null) {
            return false;
        }
        return AbstractC13042fc3.d(this.e, c16799lt.e) && AbstractC13042fc3.d(this.f, c16799lt.f) && AbstractC13042fc3.d(this.g, c16799lt.g);
    }

    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        Integer num = this.c;
        int iIntValue = (iHashCode + (num != null ? num.intValue() : 0)) * 31;
        byte[] bArr = this.d;
        int iHashCode2 = (iIntValue + (bArr != null ? Arrays.hashCode(bArr) : 0)) * 31;
        A23 a23 = this.e;
        int iHashCode3 = (iHashCode2 + (a23 != null ? a23.hashCode() : 0)) * 31;
        Integer num2 = this.f;
        int iIntValue2 = (iHashCode3 + (num2 != null ? num2.intValue() : 0)) * 31;
        Long l = this.g;
        return iIntValue2 + (l != null ? l.hashCode() : 0);
    }

    @Override // ir.nasim.AbstractC17457n0
    public C23345wl7 l() {
        return null;
    }

    public final String s() {
        Integer num = this.f;
        Integer num2 = this.c;
        StringBuilder sb = new StringBuilder();
        sb.append(num);
        sb.append(num2);
        return sb.toString();
    }

    public final byte[] t() {
        return this.d;
    }

    public final A23 u() {
        return this.e;
    }
}
