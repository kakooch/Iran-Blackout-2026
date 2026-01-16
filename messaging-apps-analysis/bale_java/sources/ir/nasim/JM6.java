package ir.nasim;

import android.content.Context;
import java.util.Objects;

/* loaded from: classes5.dex */
public class JM6 extends AbstractC17457n0 {
    private A23 c;
    private A23 d;
    private Integer e;
    private Integer f;
    private Long g;

    public JM6(C11909dl1 c11909dl1) {
        super(c11909dl1);
        IC ic = (IC) c11909dl1.c();
        this.e = ic.C();
        this.f = ic.z();
        this.g = ic.y();
        if (ic.w() != null) {
            this.d = new A23(ic.w(), "sticker.webp", "");
        }
        if (ic.u() != null) {
            this.c = new A23(ic.u(), "sticker.webp", "");
        }
    }

    public static JM6 r(C23698xM6 c23698xM6) {
        return new JM6(new C11909dl1(c23698xM6.D()));
    }

    @Override // ir.nasim.InterfaceC25103zk1
    public String b(Context context, int i, String str, boolean z) {
        return context.getString(AbstractC12217eE5.message_holder_content_sticker);
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        JM6 jm6 = (JM6) obj;
        return Objects.equals(this.c, jm6.c) && Objects.equals(this.d, jm6.d) && Objects.equals(this.e, jm6.e) && Objects.equals(this.f, jm6.f) && Objects.equals(this.g, jm6.g);
    }

    public int hashCode() {
        return Objects.hash(this.c, this.d, this.e, this.f, this.g);
    }

    @Override // ir.nasim.AbstractC17457n0
    public String j(Context context) {
        return context.getString(AbstractC12217eE5.media_sticker);
    }

    @Override // ir.nasim.AbstractC17457n0
    public C23345wl7 l() {
        return null;
    }

    public Long s() {
        return this.g;
    }

    public Integer t() {
        return this.f;
    }

    public A23 u() {
        return this.c;
    }

    public A23 v() {
        return this.d;
    }
}
