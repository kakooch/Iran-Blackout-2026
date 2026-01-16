package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import java.util.Objects;

/* renamed from: ir.nasim.vI2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C22472vI2 extends AbstractC17457n0 {
    private final int c;
    private final long d;
    private final EnumC19802qy e;
    private String f;
    private final Boolean g;

    public C22472vI2(C11909dl1 c11909dl1) {
        super(c11909dl1);
        C21001sy c21001sy = (C21001sy) c11909dl1.c();
        this.c = c21001sy.u();
        this.d = c21001sy.z();
        this.e = c21001sy.w();
        String strY = c21001sy.y();
        this.f = strY;
        if (strY == null) {
            this.f = "";
        }
        this.g = c21001sy.C();
    }

    @Override // ir.nasim.InterfaceC25103zk1
    public String b(Context context, int i, String str, boolean z) {
        return context.getString(AbstractC12217eE5.message_holder_content_gift_packet);
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C22472vI2 c22472vI2 = (C22472vI2) obj;
        return this.c == c22472vI2.c && this.d == c22472vI2.d && this.e == c22472vI2.e && Objects.equals(this.f, c22472vI2.f) && Objects.equals(this.g, c22472vI2.g);
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.c), Long.valueOf(this.d), this.e, this.f, this.g);
    }

    @Override // ir.nasim.AbstractC17457n0
    public String j(Context context) {
        return context.getString(AbstractC12217eE5.gift_packet) + Separators.SP + context.getString(AbstractC12217eE5.chat_fragment_has_caption_content_description) + Separators.SP + this.f;
    }

    @Override // ir.nasim.AbstractC17457n0
    public C23345wl7 l() {
        return null;
    }

    public int r() {
        return this.c;
    }

    public EnumC19802qy s() {
        return this.e;
    }

    public String t() {
        return this.f;
    }

    public Boolean u() {
        return this.g;
    }

    public long v() {
        return this.d;
    }
}
